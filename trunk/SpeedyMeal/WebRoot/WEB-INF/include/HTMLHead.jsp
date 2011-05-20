<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>SpeedyMeal</title>
<link href="style.css" rel="stylesheet" type="text/css" />


<script language="javascript" src="js/jquery14.js"></script>
<script language="javascript" src="js/load.js"></script>

<script charset="utf-8" src="http://s.map.qq.com/api/js/beta/v2.1/QQMapAPI.js">
</script>
<script>

var init = function() {
	var map = new QQMap.QMap(document.getElementById("container"));
	map.moveTo(new QQMap.QLatLng(39.916527,116.397128));	
}

</script>
</head>