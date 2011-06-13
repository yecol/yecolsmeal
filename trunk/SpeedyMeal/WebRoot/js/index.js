var locMark;

var init = function(lat, lng) {

	var center = new QQMap.QLatLng(lat, lng);

	var map = new QQMap.QMap(document.getElementById("container"), {
		center : center,
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
	
	var icon = new QQMap.QMarkerImage('images/marker.png');
	locMark = new QQMap.QMarker( {
		position: center,
		icon: icon,
		draggable : true,
		map: map
	});
	
	QQMap.QEvent.addListener(map, 'click', function(event) {
		locMark.setPosition(event.qLatLng);
		locMark.setMap(map);		
	});
		
//	//var bbb = function(){alert("dddd");}
//	alert(lat+","+lng);
//	if(lat != ""){
//	//	alert(lat+lng);
//
//	//	alert("in");
//		locMark.setPosition(QQMap.QLatLng(lat.trim(),lng.trim()));
//		locMark.setMap(map);
//	}
//	else{
//		QQMap.QEvent.addListener(map, 'click', function(event) {
//			locMark.setPosition(event.qLatLng);
//			locMark.setMap(map);		
//		});
//	}
	
}

var setHref = function() {
	if(locMark.getPosition().getLat()>39.81395&&locMark.getPosition().getLat()<40.00777
			&& locMark.getPosition().getLng()>116.28255&&locMark.getPosition().getLng()<116.47344)
	{
	document.getElementById("indexSearchA").href = 'SearchAction!unLoginList.action?l_lat='
		+locMark.getPosition().getLat()+'&l_lng='+locMark.getPosition().getLng();
	}
	else
	{
		document.getElementById("indexSearchA").href='#';
		alert("由于数据未完全添加，目前只演示北京四环内的外卖信息，敬请谅解！");
		return false;
	}
}

String.prototype.trim = function() {
	return this.replace(/(^\s*)|(\s*$)/g, "");
}