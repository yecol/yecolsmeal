// JavaScript Document
// AJAX loading controller
$(document).ready(function() {
    $SitePrefix="/SpeedyMeal"; 
	
	// 动态加载登录框
    /*
		$("#bt_signin").click(function() {
			$("#sidebar_body").load("login.jsp");
		});
		*/
		// 动态请求可用商店列表
		$("#ListAvailables").click(function() {
			jQuery.ajax( {
				url : $SitePrefix+'/list-availables',
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
		
	});
//异步记载调用函数
function ajaxLoad(url)
{
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