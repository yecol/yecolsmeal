var init = function() {
	
	var map = new QQMap.QMap(document.getElementById("container"), {
		center : new QQMap.QLatLng(39.920, 116.405),
		zoomLevel : 13
	});

    var navControl = new QQMap.QNavigationControl({
        align: QQMap.QALIGN.TOP_RIGHT,
        margin: new QQMap.QSize(5, 15),
        map: map
    });

   var scaleControl = new QQMap.QScaleControl({
	   align: QQMap.QALIGN.BOTTOM_RIGHT,
	   margin: new QQMap.QSize(85, 15),
	   map: map
    });

//	var tot = document.getElementsByName("dev_branch").length;
//	alert("tot="+tot);
//
//	var str = "";
//	var vertexs_arr = new Array();
//	var vertexs_str;
//	for ( var i = 0; tot > 0 && i < 1000; i = i + 1) {
//		alert("xxx");
//		if (document.getElementById(i + "_ls_h_mer")) {
//			alert("sdads");
//			tot = tot - 1;
//			
//			vertexs_str = document.getElementById(i + "_dev_vertexs").innerHTML;
//			vertexs_str = vertexs_str.trim();
//			if (vertexs_str == "")
//				continue;
//			vertexs_str = vertexs_str.substring(1, vertexs_str.length - 1);  //delete '[]'
//			if (vertexs_str == "")
//				continue;
//			
//			vertexs_arr = vertexs_str.split(",");
//	//		alert(vertexs_str+"   "+vertexs_arr.length);
//			
//			var center = new QQMap.QLatLng(
//					document.getElementById(i + "_lat").innerHTML.trim(), document
//							.getElementById(i + "_lon").innerHTML.trim());
//			var marker = new QQMap.QMarker( {
//				position : center,
//				map : map
//			});
//			
//	//		var type = document.getElementById(i + "_type").innerHTML.trim();
//			if(vertexs_arr.length == 2) {
//				var radius = map.getDistance(center, new QQMap.QLatLng(
//						vertexs_arr[0].trim(), vertexs_arr[1].trim()));
//				
//
//				var cirle = new QQMap.QCircle( {
//					center : center,
//					radius : radius,
//					map : map
//				});
//			}
//			else {
//				var pgonPath = new Array();
//				for(var i=0; i<vertexs_arr.length; i=i+2) {
//					pgonPath.push(new QQMap.QLatLng(vertexs_arr[i].trim(), vertexs_arr[i+1].trim()));
//				}
//	//			alert(pgonPath);
//				var pgon = new QQMap.QPolygon( {
//					strokeColor : '#0000FF',
//					strokeOpacity : 0.5,
//					strokeWeight : 1,
//					path: pgonPath,
//					map: map
//				});
//			}
//
//		}
//	}

}

String.prototype.trim = function() {
	return this.replace(/(^\s*)|(\s*$)/g, "");
}