var init = function() {
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

}
