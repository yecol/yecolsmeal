var map;

var init = function() {

	map = new QQMap.QMap(document.getElementById("container"), {
		center : new QQMap.QLatLng(39.920, 116.405),
		zoomLevel : 13
	});

	if (document.getElementById('interactive').innerHTML == "add") {

		var center = new QQMap.QLatLng(39.920, 116.405);

		var drawCircle = false;
		var drawPolygon = false;

		var location;
		var hasLocation = false;

		var dashPolylinePath = new Array(2);
		var dashPolyline = new QQMap.QPolyline( {
			strokeColor : '#0000FF',
			strokeDashStyle : 'dash',
			strokeOpacity : 0.5,
			strokeWeight : 5
		});

		var solidPolylinePath = new Array();
		var solidPolyline = new QQMap.QPolyline( {
			strokeColor : '#0000FF',
			strokeWeight : 5,
			strokeOpacity : 0.5,
			strokeDashStyle : 'solid'
		});

		var polygonPath = new Array();
		var polygon = new QQMap.QPolygon( {
			strokeColor : '#0000FF',
			strokeOpacity : 0.5,
			strokeWeight : 5
		});

		// add a circle
		var circle = new QQMap.QCircle( {});

		// add a marker
		var marker = new QQMap.QMarker( {});

		// marker's click event
		var markerInfo = new QQMap.QInfoWindow( {});

		QQMap.QEvent
				.addListener(marker, 'click', function() {
					if (drawPolygon == true) {
						drawPolygon = false;
						hasLocation = false;

						document.getElementById('br_areaType').value = '1';
						document.getElementById('br_la').value = location
								.getLat();
						document.getElementById('br_lo').value = location
								.getLng();

						var vertexs_str = "";
						var is_first = true;
						for ( var i = 0; i < solidPolylinePath.length; i++) {
							if (is_first == false) {
								vertexs_str = vertexs_str + ",";
							} else {
								is_first = false;
							}
							vertexs_str = vertexs_str
									+ solidPolylinePath[i].getLat().toFixed(5)
									+ ","
									+ solidPolylinePath[i].getLng().toFixed(5);
							// var input_alas = document.createElement("input");
						// input_alas.type = "hidden";
						// input_alas.name = "alas";
						// input_alas.value = solidPolylinePath[i].getLat();
						// document.getElementById('dev_vertexs').appendChild(input_alas);
						//								
						// var input_alos = document.createElement("input");
						// input_alos.type = "hidden";
						// input_alos.name = "alos";
						// input_alos.value = solidPolylinePath[i].getLng();
						// document.getElementById('dev_vertexs').appendChild(input_alos);
					}

					document.getElementById('dev_vertexs').value = vertexs_str;

					polygon.setPath(solidPolylinePath);
					polygon.setMap(map);

					solidPolygonPath = [];
					solidPolyline.setPath(solidPolygonPath);

					// dashPolygonPath = [];
					dashPolyline.setPath( []);

				} else {
			//		document.getElementById('info').innerHTML = 'Start a a polygon!';
					markerInfo.setMap(map);
					markerInfo
							.open(
									'<div style="text-align:center;white-space:nowrap;margin:10px;">The shop\'s location</div>',
									marker);
				}
				
			}	);

		// Mouse-move event
		QQMap.QEvent.addListener(map, 'mousemove', function(event) {

			var latLng = event.qLatLng;// lat =
				// latLng.getLat().toFixed(5);
				if (drawCircle == true && hasLocation == true) {

					dashPolylinePath[1] = latLng;
					dashPolyline.setPath(dashPolylinePath);

					circle.setRadius(map.getDistance(location, latLng));
				}

				if (drawPolygon == true && hasLocation == true) {

					dashPolylinePath[1] = latLng;
					dashPolyline.setPath(dashPolylinePath);
				}

			});

		// The event of click the map
		QQMap.QEvent.addListener(map, 'click', function(event) {

			var latLng = event.qLatLng;

			if (drawCircle == true) {

				if (hasLocation == false) {
					hasLocation = true;
					location = latLng;

					marker.setPosition(latLng);
					marker.setMap(map);

					circle.setCenter(latLng);
					circle.setRadius(0);
					circle.setMap(map);

					dashPolylinePath[0] = latLng;
					dashPolylinePath[1] = latLng;
					dashPolyline.setPath(dashPolylinePath);
					dashPolyline.setMap(map);

				} else {
					drawCircle = false;

					hasLocation = false;

					circle.setRadius(map.getDistance(location, latLng));

					dashPolyline.setPath( []);

					document.getElementById('br_areaType').value = '0';
					document.getElementById('br_la').value = location.getLat();
					document.getElementById('br_lo').value = location.getLng();
					document.getElementById('dev_vertexs').value = latLng
							.getLat().toFixed(5)
							+ "," + latLng.getLng().toFixed(5);
					// var input_alas = document.createElement("input");
				// input_alas.type = "hidden";
				// input_alas.name = "alas";
				// input_alas.value = latLng.getLat();
				// document.getElementById('dev_vertexs').appendChild(input_alas);
				//				
				// var input_alos = document.createElement("input");
				// input_alos.type = "hidden";
				// input_alos.name = "alos";
				// input_alos.value = latLng.getLng();
				// document.getElementById('dev_vertexs').appendChild(input_alos);

				// document.getElementById('dev_vertexs').innerHTML = '< input
				// type\="hidden\" name=\"alas\" value=\"' + latLng.getLat() +
				// '\" />\n';
				// document.getElementById('dev_vertexs').innerHTML += ('<input
				// type="hidden" name="alas" value=' + latLng.getLng() + '
				// />\n');

				// alert(document.getElementById('dev_vertexs').innerHTML);

			}

		}

		if (drawPolygon == true) {

			dashPolylinePath[0] = latLng;
			dashPolylinePath[1] = latLng;
			dashPolyline.setPath(dashPolylinePath);
			dashPolyline.setMap(map);

			if (hasLocation == false) {

				hasLocation = true;
				location = latLng;

				marker.setPosition(latLng);
				marker.setMap(map);
				solidPolylinePath = [];

			}

			solidPolylinePath.push(latLng);
			solidPolyline.setPath(solidPolylinePath);
			solidPolyline.setMap(map);
		}

	}	);

		// ÓÒ¼ü²Ëµ¥
		var contextMenu = new QQMap.QContextMenuControl();
		contextMenu.setMap(map);
		contextMenu.addItem('Draw a circle!', drawCircleFunc);
		contextMenu.addSeparator();
		contextMenu.addItem('Draw a polygon!', drawPolygonFunc);
		contextMenu.addTarget(map);

		function drawCircleFunc() {

			circle.setMap(null);
			marker.setMap(null);
			polygon.setMap(null);
			dashPolyline.setMap(null);
			solidPolyline.setMap(null);
			markerInfo.setMap(null);

			drawCircle = true;
			drawPolygon = false;
			// document.getElementById('info').innerHTML = 'Start drawing a
			// circle!';
		}

		function drawPolygonFunc() {
			circle.setMap(null);
			marker.setMap(null);
			polygon.setMap(null);
			dashPolyline.setMap(null);
			solidPolyline.setMap(null);
			markerInfo.setMap(null);

			drawCircle = false;
			drawPolygon = true;
			// document.getElementById('info').innerHTML = 'Start drawing a
			// polygon!';
		}
	}
	else
	{
		var isExsit = false;
		for(var i=0;;i++)
		{
			isExsit = document.getElementById('0');
			if(isExsit)
			{
			}	
			else
			{
				break;
			}
		}
	}

}

var showGraph = function()
{
	var isExsit = false;
	var str = "";
	var vertexs_arr = new Array();
	var vertexs_str;
	for(var i=0;;i++)
	{
		isExsit = document.getElementById(i);
		if(isExsit)
		{
			var center =  new QQMap.QLatLng(document.getElementById(i+"_lat").innerHTML, document.getElementById(i+"_lon").innerHTML);
	          var marker = new QQMap.QMarker({
	              position: center,
	              map: map
	          });
	         vertexs_str = document.getElementById(i+"_dev_vertexs").innerHTML;
	         if(vertexs_str == "") continue;
	         vertexs_arr = vertexs_str.split(",");
	         var radius = map.getDistance(center, new QQMap.QLatLng(vertexs_arr[0],vertexs_arr[1]));
	         
	         var cirle = new QQMap.QCircle(
	        	        {
	        	            center: center,
	        	            radius: radius,
	        	            map: map
	        	        });
	         
		}	
		else
		{
			break;
		}
	}

	
}
