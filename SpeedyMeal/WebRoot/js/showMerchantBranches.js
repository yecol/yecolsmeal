var color_size = 6;
var color = new Array('#ff0000', '#785e00', '#6735b8','#785e00', '#6735b8','#006699', '#0085a6');

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
		align : QQMap.QALIGN.BOTTOM_LEFT,
		margin : new QQMap.QSize(85, 15),
		map : map
	});

	var tot = document.getElementsByName("dev_branch").length;
	// alert("tot="+tot);

	var str = "";
	var vertexs_arr = new Array();
	var vertexs_str;

	var style = {
		// url : 'images/infobox.png',
		url : "http://cstar.qq.com/qqmapapi/img/infowindow.png",
		top_left : [ 8, 11, 13, 13 ],
		bottom_right : [ 620, 451, 14, 14 ],
		margin : [ 20, 10 ],
		width_range : [ 200, 600 ],
		height_range : [ 80, 500 ],
		offset : [ -2, 5 ],
		stem : {
			x : [ 38, 64, 17 ],
			y : 503,
			align : QQMap.QALIGN.CENTER, // 'left', 'center', 'right'
			offset : 0
		},
		close : {
			url : 'http://cstar.qq.com/qqmapapi/img/close.png',
			coordinate : [ 0, 0, 30, 30 ],
			align : QQMap.QALIGN.TOP_RIGHT,
			margin : [ -8, -8 ]
		},
		shadow : {
			url : 'http://cstar.qq.com/qqmapapi/img/shadow.png',
			top_left : [ 354, 156 ],
			bottom_right : [ 657, 472 ],
			stem : {
				x : [ 60, 90, 16 ],
				y : 503,
				offset : [ -4, -4 ],
				blur : 5
			}
		}
	};

	var info = new QQMap.QInfoWindow( {
		// style: style,
			map : map
		});

	if (document.getElementById("u_lat")) {
		var u_loc = new QQMap.QLatLng(
				document.getElementById("u_lat").innerHTML, document
						.getElementById("u_lng").innerHTML);
		var icon = new QQMap.QMarkerImage('images/marker.png');
		var locMark = new QQMap.QMarker( {
			position : u_loc,
			icon : icon,
			map : map
		});
	}

	var c_index = 0;
	var latLngBounds = new QQMap.QLatLngBounds(); // 显示最佳比例
	var m_icon = new QQMap.QMarkerImage('images/mMarker.png',null,new QQMap.QPoint(11, 39));
	var m_icon_tmp = new QQMap.QMarkerImage('images/mMarker.png',null,new QQMap.QPoint(11, 0));

	//alert("test");
	for ( var i = 1;; i = i + 1) {

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
				var location_arr = document.getElementById(i + "_location").innerHTML
						.trim().split(",");
				center = new QQMap.QLatLng(location_arr[0], location_arr[1]);

				var distan = map.getDistance(u_loc, center).toFixed(0);
				document.getElementById(i + "_ls_h_dis").innerHTML = "该商家距你约有"
						+ distan + "米";

				var marker = new QQMap.QMarker( {
					icon : m_icon,
					position : center,
					map : map
				});
				
				var marker_tmp = new QQMap.QMarker( {
						icon : m_icon_tmp,
						position : center,
					//	map : map
					});

				var decor = new QQMap.QMarkerDecoration( {
					content : i.toString(),
					margin : new QQMap.QSize(0, -4),
					align : QQMap.QALIGN.CENTER,
					marker : marker
				});

				(function(info_marker,info_marker_tmp, mer, bra, addr, phone, dis) { // 闭包

					QQMap.QEvent
							.addListener(info_marker,
									'click',
									function() {
										// info.setAnimation(QQMap.QAnimation.POP);
									info
											.open(
													"<div class='info_single'><div class='ls_head'>"
															+ "<div class='ls_h_mer'>"
															+ mer
															+ "</div>"
															+ "<div class='ls_h_bra'>"
															+ bra
															+ "</div>"
															+ "<div class='info_h_gre'>"
															+ addr
															+ "</div>"
															+ "<div c" +
																	"lass='info_h_gre'>"
															+ phone
															+ "</div>"
															+ "<div class='info_h_dis'>该商家距你约有<span style='color:#C00'>"
															+ dis
															+ "</span>米&nbsp;&nbsp;&nbsp;<a href='#' class='r'>查看菜单</a></div><div class='clear'></div></div></div>",
													info_marker.getPosition);
								});
				})(marker, document.getElementById(i + "_ls_h_mer").innerHTML
						.trim(),
						document.getElementById(i + "_ls_h_bra").innerHTML
								.trim(), document.getElementById(i
								+ "_ls_h_addr").innerHTML.trim(), document
								.getElementById(i + "_ls_h_phone").innerHTML
								.trim(), distan);

			} else {
				center = new QQMap.QLatLng(
						document.getElementById(i + "_lat").innerHTML.trim(),
						document.getElementById(i + "_lon").innerHTML.trim());

				var marker = new QQMap.QMarker( {
					icon : m_icon,
					position : center,
					map : map
				});

				var decor = new QQMap.QMarkerDecoration( {
					content : i.toString(),
					margin : new QQMap.QSize(0, -4),
					align : QQMap.QALIGN.CENTER,
					marker : marker
				});

				(function(info_marker, mer, bra, dis) { // 闭包

					QQMap.QEvent.addListener(info_marker, 'click', function() {
						// info.setAnimation(QQMap.QAnimation.POP);
							info.open(
									"<div class='info_single'><div class='ls_head'>"
											+ "<div class='ls_h_mer'>" + mer
											+ "</div>"
											+ "<div class='ls_h_bra'>" + bra
											+ "</div>"
											+ "<div class='ls_h_dis'>" + dis
											+ "</div>", info_marker.getPosition());
						});

				})(marker, document.getElementById(i + "_ls_h_mer").innerHTML
						.trim(),
						document.getElementById(i + "_ls_h_bra").innerHTML
								.trim(), document.getElementById(i
								+ "_ls_h_dis").innerHTML.trim());
			}

			// var type = document.getElementById(i + "_type").innerHTML.trim();
			if (vertexs_arr.length == 2) {
				var tude_radius = Math.sqrt(Math.pow(vertexs_arr[0].trim()
						- center.getLat(), 2)
						+ Math.pow(vertexs_arr[1].trim() - center.getLng(), 2));
				latLngBounds.extend(new QQMap.QLatLng(center.getLat()
						+ tude_radius, center.getLng() + tude_radius)); // 加四个对称点
				latLngBounds.extend(new QQMap.QLatLng(center.getLat()
						+ tude_radius, center.getLng() - tude_radius));
				latLngBounds.extend(new QQMap.QLatLng(center.getLat()
						- tude_radius, center.getLng() + tude_radius));
				latLngBounds.extend(new QQMap.QLatLng(center.getLat()
						- tude_radius, center.getLng() - tude_radius));

				var radius = map.getDistance(center, new QQMap.QLatLng(
						vertexs_arr[0].trim(), vertexs_arr[1].trim()));

				var circle = new QQMap.QCircle( {
					center : center,
					strokeOpacity : 0.5,
					// strokeWeight: 5,
					radius : radius,
					map : map
				});
				// alert(circle.getFillOpacity());
				circle.setStrokeColor(color[c_index]);
				circle.setFillColor(color[c_index]);

			} else {
				// alert(vertexs_arr);
				var pgonPath = new Array();
				for ( var j = 0; j < vertexs_arr.length; j = j + 2) {
					latLngBounds.extend(new QQMap.QLatLng(
							vertexs_arr[j].trim(), vertexs_arr[j + 1].trim()));

					pgonPath.push(new QQMap.QLatLng(vertexs_arr[j].trim(),
							vertexs_arr[j + 1].trim()));
				}

				var pgon = new QQMap.QPolygon( {
					path : pgonPath,
					strokeOpacity : 0.5,
					// strokeWeight: 5,
					map : map
				});
				// alert(pgon.getStrokeWeight());
				pgon.setStrokeColor(color[c_index]);
				pgon.setFillColor(color[c_index]);

			}

			c_index++;
			if (c_index == color_size) {
				c_index -= color_size;
			}

		} else {
			if (i == 1)
				return;
			break;
		}
	}
	map.fitBounds(latLngBounds)

}

String.prototype.trim = function() {
	return this.replace(/(^\s*)|(\s*$)/g, "");
}