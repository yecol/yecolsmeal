// JavaScript Document
// AJAX loading controller
$(document).ready(function() {
    $SitePrefix="/SpeedyMeal"; 
	
	// ��̬���ص�¼��
    /*
		$("#bt_signin").click(function() {
			$("#sidebar_body").load("login.jsp");
		});
		*/
		// ��̬��������̵��б�
		$("#ListAvailables").click(function() {
			jQuery.ajax( {
				url : $SitePrefix+'/list-availables',
				data : {
					author : 'hello'
				}, // �ӱ��л�ȡ����
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
		//�̻��ķֵ����
		
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