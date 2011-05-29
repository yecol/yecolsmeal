﻿var init = function() {

	var map = new QQMap.QMap(document.getElementById("container"), {
		center : new QQMap.QLatLng(39.920, 116.405),
		zoomLevel : 13
	});

	var navControl = new QQMap.QNavigationControl( {
		align : QQMap.QALIGN.TOP_RIGHT,
		margin : new QQMap.QSize(5, 15),
		map : map
	});

	var scaleControl = new QQMap.QScaleControl( {
		align : QQMap.QALIGN.BOTTOM_RIGHT,
		margin : new QQMap.QSize(85, 15),
		map : map
	});

	var tot = document.getElementsByName("dev_branch").length;
	// alert("tot="+tot);

	var str = "";
	var vertexs_arr = new Array();
	var vertexs_str;
//	var marker;
	var markers = new Array();
//	var info;
	var infos = new Array();
	for ( var i = 1;; i = i + 1) {
		// alert(i);
		if (document.getElementById(i + "_ls_h_mer")) {

			vertexs_str = document.getElementById(i + "_dev_vertexs").innerHTML;
			vertexs_str = vertexs_str.trim();
			if (vertexs_str == "")
				continue;
			vertexs_str = vertexs_str.substring(1, vertexs_str.length - 1); // delete
																			// '[]'
			if (vertexs_str == "")
				continue;

			vertexs_arr = vertexs_str.split(",");
			// alert(vertexs_str+" "+vertexs_arr.length);

			var center;
			if (document.getElementById(i + "_location")) {
				var location_arr = document.getElementById(i + "_location").innerHTML.trim().split(",");
				center = new QQMap.QLatLng(location_arr[0], location_arr[1]);
			} else {
				center = new QQMap.QLatLng(document.getElementById(i
						+ "_lat").innerHTML.trim(), document.getElementById(i
						+ "_lon").innerHTML.trim());
			}

			var marker = new QQMap.QMarker( {
				position : center,
				map : map
			});
		//	markers.push(marker);
			var info = new QQMap.QInfoWindow({
				  position : center,
	              map: map
	          });
	//		infos.push(info);
//	        QQMap.QEvent.addListener(marker, 'click', function() {
//	            info.open('<div>标记信息</div>',
//	            		  marker); 
//	        });


			// var type = document.getElementById(i + "_type").innerHTML.trim();
			if (vertexs_arr.length == 2) {
				var radius = map.getDistance(center, new QQMap.QLatLng(
						vertexs_arr[0].trim(), vertexs_arr[1].trim()));

				var cirle = new QQMap.QCircle( {
					center : center,
					radius : radius,
					map : map
				});
			} else {
				var pgonPath = new Array();
				for ( var j = 0; j < vertexs_arr.length; j = j + 2) {
					pgonPath.push(new QQMap.QLatLng(vertexs_arr[j].trim(),
							vertexs_arr[j + 1].trim()));
				}

				var pgon = new QQMap.QPolygon( {
					strokeColor : '#0000FF',
					strokeOpacity : 0.5,
					strokeWeight : 1,
					path : pgonPath,
					map : map
				});
			}

		} else {
			break;
		}
	}

}

String.prototype.trim = function() {
	return this.replace(/(^\s*)|(\s*$)/g, "");
}