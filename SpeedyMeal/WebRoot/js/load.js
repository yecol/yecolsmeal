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
		
	});
//�첽���ص��ú���
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