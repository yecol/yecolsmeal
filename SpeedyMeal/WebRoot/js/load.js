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
		//商户的分店管理
		
		$("a#merchant_branches_mgr").click(function() {
			jQuery.ajax( {
				url : $SitePrefix+'/ax-branches-mgr!listBranches',
				type : 'GET',
				error : function(request) {
					alert("Server Error YZEN002");
				},
				success : function(data) {
					$("#sidebar_body").html(data);
				}
			});
			return false;
		});
		

	});