var locMark;
var init = function() {

	var center = new QQMap.QLatLng(39.920, 116.405);

	var map = new QQMap.QMap(document.getElementById("container"), {
		center : center,
		zoomLevel : 13
	});
	var icon = new QQMap.QMarkerImage('images/marker.png');
	locMark = new QQMap.QMarker( {
		icon: icon,
		draggable : true,
	});

	QQMap.QEvent.addListener(map, 'click', function(event) {
		locMark.setPosition(event.qLatLng);
		locMark.setMap(map);		
	});
}

isValid = function(myForm) {
	var inputs = myForm.getElementsByTagName("input");
	if(locMark.getPosition() == null) {
		alert("Please set you location!");
		return false;
	}
	else {
		var latLng = locMark.getPosition();
		document.getElementById('user-acts_r_lat').value = latLng.getLat();
		document.getElementById('user-acts_r_lon').value = latLng.getLng();
	}
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
