<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
</head>
<body>

<script>
	var iframesrc= "http://10.16.41.137:8180/iData/vision/openresource.jsp?user=admin&password=manager&resid=I297edff815b2411f0161033ff1e83907";
</script>	
	
<iframe id="analysisTable" style="padding: 0px; width: 100%; height:450px; overflow-y : hidden;" src=""></iframe>

<script>
	var iframe = document.getElementById("analysisTable");
	iframe.src = iframesrc;
</script>


</body>
</html>	