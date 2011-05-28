
var init = function() {
	var map = new QQMap.QMap(document.getElementById("container"), {
		center : new QQMap.QLatLng(39.920, 116.405),
		zoomLevel : 13
	});
	var isExsit = false;
	var str = "";
	var vertexs_arr = new Array();
	var vertexs_str;
	for ( var i = 0;; i++) {
		isExsit = document.getElementById(i);
		if (isExsit) {
			var center = new QQMap.QLatLng(
					document.getElementById(i + "_lat").innerHTML, document
							.getElementById(i + "_lon").innerHTML);
			var marker = new QQMap.QMarker( {
				position : center,
				map : map
			});
			vertexs_str = document.getElementById(i + "_dev_vertexs").innerHTML;
			if (vertexs_str == "")
				continue;
			vertexs_arr = vertexs_str.split(",");
			var type = document.getElementById(i + "_type").innerHTML;
			if(type == "0") {
				var radius = map.getDistance(center, new QQMap.QLatLng(
						vertexs_arr[0], vertexs_arr[1]));

				var cirle = new QQMap.QCircle( {
					center : center,
					radius : radius,
					map : map
				});
			}
			else {
				
			}

		} else {
			break;
		}
	}

}
