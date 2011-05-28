var init = function() {

	var center = new QQMap.QLatLng(39.920, 116.405);

	var map = new QQMap.QMap(document.getElementById("container"), {
		center : center,
		zoomLevel : 13
	});
	
    var navControl = new QQMap.QNavigationControl({
        align: QQMap.QALIGN.TOP_LEFT,
        margin: new QQMap.QSize(5, 15),
        map: map

    });


	var drawCircle = false;
	var drawPolygon = false;

	var location;
	var hasLocation = false;

	var dashPlinePath = new Array(2);
	var dashPline = new QQMap.QPolyline( {
		strokeColor : '#0000FF',
		strokeDashStyle : 'dash',
		strokeOpacity : 0.5,
		strokeWeight : 5
	});

	var solidPlinePath = new Array();
	var solidPline = new QQMap.QPolyline( {
		strokeColor : '#0000FF',
		strokeWeight : 5,
		strokeOpacity : 0.5,
		strokeDashStyle : 'solid'
	});

	var pgonPath = new Array();
	var pgon = new QQMap.QPolygon( {
		strokeColor : '#0000FF',
		strokeOpacity : 0.5,
		strokeWeight : 0
	});

	// add a circle
	var circle = new QQMap.QCircle( {});

    var anchor = new QQMap.QPoint(6, 6),
    size = new QQMap.QSize(24, 24),
    icon = new QQMap.QMarkerImage('images/pgonSrcMarker.gif', size, anchor);
	var pgonSrcMark = new QQMap.QMarker( {icon: icon});
	QQMap.QEvent.addListener(pgonSrcMark, 'click', function() {
		pgonPath.shift();
		pgonPath.pop();

		document.getElementById('br_areaType').value = '1';
		document.getElementById('br_la').value = location.getLat();
		document.getElementById('br_lo').value = location.getLng();

		var vertexs_str = "";
		var is_first = true;
		for ( var i = 0; i < pgonPath.length; i = i + 1) {
			if (is_first == false) {
				vertexs_str += ",";
			} else {
				is_first = false;
			}
			vertexs_str += pgonPath[i].getLat().toFixed(5) + ","
					+ pgonPath[i].getLng().toFixed(5);
		}
		document.getElementById('dev_vertexs').value = vertexs_str;

		pgon.setStrokeWeight(1);
		pgon.setPath(pgonPath);
		pgon.setMap(map);

		drawPolygon = false;
		hasLocation = false;
		pgonSrcMark.setMap(null);
		solidPgonPath = [];
		solidPline.setPath( []);
		
		dashPline.setPath( []);
	});

	var hasSrc;
	// Mouse-move event
	QQMap.QEvent.addListener(map, 'mousemove', function(event) {
		var latLng = event.qLatLng;
		if (drawCircle == true && hasLocation == true) {
			dashPlinePath[1] = latLng;
			dashPline.setPath(dashPlinePath);
			
			circle.setRadius(map.getDistance(location, latLng));
		}

		if (drawPolygon == true && hasLocation == true) {
			dashPlinePath[1] = latLng;
			dashPline.setPath(dashPlinePath);
			
			if(hasSrc == true) {
				pgonPath[pgonPath.length-1] = latLng;
				pgon.setPath(pgonPath);
				pgon.setMap(map);
			}
		}
	});

	// add a marker and marker's click event
	var locMark = new QQMap.QMarker( {});
	var locMarkInfo = new QQMap.QInfoWindow( {});
	QQMap.QEvent.addListener(locMark, 'click', function() {
	//	locMarkInfo.setMap(map);
		locMarkInfo.open('The shop\'s location</div>', locMark);
	});
	
	// The event of click the map
	QQMap.QEvent.addListener(map, 'click', function(event) {
		var latLng = event.qLatLng;
		
		if (drawCircle == true) {
			if (hasLocation == false) {
				hasLocation = true;
				location = latLng;

				locMark.setPosition(location);
				locMark.setMap(map);

				circle.setCenter(latLng);
				circle.setRadius(0);
				circle.setMap(map);

				dashPlinePath[0] = location;
				dashPlinePath[1] = location;
				dashPline.setPath(dashPlinePath);
				dashPline.setMap(map);

			} else {
				drawCircle = false;
				hasLocation = false;

				circle.setRadius(map.getDistance(location, latLng));
				dashPline.setPath( []);

				document.getElementById('br_areaType').value = '0';
				document.getElementById('br_la').value = location.getLat();
				document.getElementById('br_lo').value = location.getLng();
				document.getElementById('dev_vertexs').value = latLng.getLat()
						.toFixed(5)	+ "," + latLng.getLng().toFixed(5);
			}
		}
		
		if (drawPolygon == true) {
			dashPlinePath[0] = latLng;
			dashPlinePath[1] = latLng;
			dashPline.setPath(dashPlinePath);
			dashPline.setMap(map);

			if (hasLocation == false) {
				hasLocation = true;
				location = latLng;
				
				locMark.setPosition(location);
				locMark.setMap(map);	
				solidPlinePath = [];
				pgonPath = [];
				pgonPath.push(location);
			}
			else {
				if(hasSrc ==false) {
					hasSrc = true;
					
					pgonSrcMark.setPosition(latLng);
					pgonSrcMark.setMap(map);
				}
				solidPlinePath.push(latLng);
				solidPline.setPath(solidPlinePath);
				solidPline.setMap(map);
			}
			
			pgonPath[pgonPath.length-1] = latLng;
			pgonPath.push(latLng);
	//		pgon.setMap(map);
		}
	});

	// ÓÒ¼ü²Ëµ¥
	var contextMenu = new QQMap.QContextMenuControl();
	contextMenu.setMap(map);
	contextMenu.addItem('Draw a circle!', drawCircleFunc);
	contextMenu.addSeparator();
	contextMenu.addItem('Draw a polygon!', drawPolygonFunc);
	contextMenu.addTarget(map);

	function drawCircleFunc() {

		if(drawCircle == true || drawPolygon == true) {
			return;
		}
		
		circle.setMap(null);
		locMark.setMap(null);
		pgon.setMap(null);
		dashPline.setMap(null);
		solidPline.setMap(null);
		locMarkInfo.setMap(null);
		pgon.setStrokeWeight(0);

		drawCircle = true;
		drawPolygon = false;
		hasSrc = false;
	}

	function drawPolygonFunc() {
		if(drawCircle == true || drawPolygon == true) {
			return;
		}
		
		circle.setMap(null);
		locMark.setMap(null);
		pgon.setMap(null);
		dashPline.setMap(null);
		solidPline.setMap(null);
		locMarkInfo.setMap(null);
		pgon.setStrokeWeight(0);

		drawCircle = false;
		drawPolygon = true;
		hasSrc = false;
	}
}

isValid = function(myForm) {
	var inputs = myForm.getElementsByTagName("input");
	for(var i=0; i<inputs.length; i = i + 1) {
		input = inputs[i];
		if (input.type == "text" || input.type == "hidden") {
			if(input.value == "") {
				alert("Please complete the information!");
				return false;
			}
		}
	}
	return true;
}
