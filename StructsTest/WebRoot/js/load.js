// JavaScript Document
// AJAX loading controller
$(document).ready(function() {
	// ��̬���ص�¼��
		$("#bt_signin").click(function() {
			$("#sidebar_body").load("login.jsp");
		});
		// ��̬��������̵��б�
		$("#ListAvailables").click(function() {
			jQuery.ajax( {
				url : '/StructsTest/list-availables',
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

	});