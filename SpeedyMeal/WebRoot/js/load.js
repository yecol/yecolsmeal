// JavaScript Document
// AJAX loading controller
$(document).ready(function() {
	
	
	
	$SitePrefix = "/SpeedyMeal";

	// alert($(document).height());
		// alert($('#sidebar').css('height'));

		$('#sidebar').css('height', $(document).height() - 100 + 'px');

		// 动态加载登录框
		/*
		 * $("#bt_signin").click(function() {
		 * $("#sidebar_body").load("login.jsp"); });
		 */
		// 动态请求可用商店列表
		$("#ListAvailables").click(function() {
			jQuery.ajax( {
				url : $SitePrefix + '/list-availables',
				data : {
					author : 'hello'
				}, // 从表单中获取数据
				type : 'POST',
				error : function(request) {
					alert("Server Error YZEN001");
				},
				success : function(data) {
					$("#sidebar_body").html(data);
				}
			});
			return false;
		});

		if (navigator.geolocation) {
			navigator.geolocation.getCurrentPosition(success, error);
		} else {
			error('not supported');
		}
		function error(msg) {
			$('#detectGeo').html("浏览器不支持位置检测或检测不到您的位置！")
			init("39.916527","116.397128");
		}
		function success(position) {
			$('#detectGeo').html("检测到您的位置！");
			$('#l_lat').html(position.coords.latitude);
			$('#l_lng').html(position.coords.longitude);
	//		$('#test').attr('value','xxx');
			
			
			if($('#searchBotton').hasClass('hidden')){
			$('#searchBotton').removeClass('hidden');
			}
	//		$('#indexSearchA').attr('href','SearchAction!unLoginList.action?l_lat='+position.coords.latitude+'&l_lng='+position.coords.longitude);
			
			init(position.coords.latitude, position.coords.longitude);
		}
		
		$('a.mag').imgPreview( {
			containerID : 'imgPreviewWithStyles',
			imgCSS : {
			height : 200
		}
		});
		
		

	});

// 异步记载调用函数
function ajaxLoad(url) {
	jQuery.ajax( {
		url : url,
		type : 'GET',
		error : function(request) {
			alert("Server Error YZEN00X");
		},
		success : function(data) {
			$("#sidebar_body").html(data);
		}
	});
	return false;
}