var init = function() {

	var center = new QQMap.QLatLng(39.920, 116.405);

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
	
}

eamilCheck = function (emailStr) {
	var emailPat = /^(.+)@(.+)$/;
	var matchArray = emailStr.match(emailPat);
	if (matchArray == null) {
		return false;
	}
	return true;
}

telCheck = function isTel(telStr){
    var reg=/^([0-9]|[\-])+$/g ;
    if(telStr.length<7 || telStr.length>18){
    	return false;
    }
    else{
      return reg.exec(str);
    }
}

isValid = function(myForm) {
	
	if(document.getElementById('MerchantAction_merchant_username').value.trim()==""){
		alert("用户名不能为空！");
		return false;
	}
	
	if(document.getElementById('MerchantAction_merchant_pwd').value.trim()==""){
		alert("密码不能为空！");
		return false;
	}
	
	if(eamilCheck(document.getElementById('MerchantAction_merchant_email').value) == false)
	{
		alert("邮件地址格式不正确！");
		return false;
	}
	
	if(telCheck(document.getElementById('MerchantAction_merchant_phone').value) == false)
	{
		alert("电话号码格式不正确！");
		return false;
	}
	
	if(document.getElementById('UserAction_user_address').value == null){
		alert("地址不能为空！");
		return false;
	}
	
	return true;
}
