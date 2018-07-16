<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<html>
<head>
	<meta charset="UTF-8">
    <title>system-Account</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="/static/styles/css/ace-fonts.css"/>
    <link rel="stylesheet" type="text/css" href="/static/styles/css/font-awesome.css"/>
    <link rel="stylesheet" type="text/css" href="/static/styles/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="/static/styles/css/bootstrap-table.min.css"/>
    <link rel="stylesheet" href="/static/scripts/gecko-modules/bootstrap/bootstrap-editable.css">
    <link rel="stylesheet" type="text/css" href="/static/styles/css/ace.css"/>
    <link rel="stylesheet" href="/static/styles/css/bootstrap-select.min.css" />
    <link rel="stylesheet" href="/static/styles/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/static/styles/css/bootstrap-datetimepicker.min.css" />
    <link rel="stylesheet" href="/static/styles/css/jquery-ui.custom.min.css" />
	<link rel="stylesheet" href="/static/styles/css/chosen.min.css" />
	
	<!-- ace styles -->
		<link rel="stylesheet" href="/static/static/css/system/ace/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />

		<!--[if lte IE 9]>
			<link rel="stylesheet" href="assets/css/ace-part2.min.css" class="ace-main-stylesheet" />
		<![endif]-->
		<link rel="stylesheet" href="/static/static/css/system/ace/ace-skins.min.css" />
		<link rel="stylesheet" href="/static/static/css/system/ace/ace-rtl.min.css" />

		<!--[if lte IE 9]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->
	<script type="text/javascript" src="/static/scripts/gecko-modules/jquery/jquery-2.2.1.min.js"></script>
    <script src="/static/scripts/gecko-modules/bootstrap/bootstrap.min.js"></script>
    
    <script type="text/javascript" src="/static/scripts/gecko-modules/bootstrap/bootstrap-table.js"></script>
	<!-- ace scripts -->
	<script src="/static/scripts/gecko-modules/ace/ace-elements.min.js"></script>
	<script src="/static/scripts/gecko-modules/ace/ace.min.js"></script>
	<script type="text/javascript" src="/static/scripts/gecko-modules/bootstrap/bootstrap-table-zh-CN.js"></script>
	
	<script src="/static/scripts/gecko-modules/bootstrap/bootstrap-datepicker.js"></script>
   	<script src="/static/scripts/gecko-modules/bootstrap/bootstrap-select.min.js"></script>
<style>
.spinner1 {  
  width: 100px;  
}  
.spinner2 {  
  width: 100px;  
} 
.spinner3 {  
  width: 100px;  
} 
.spinner4 {  
  width: 100px;  
} 
.spinner5 {  
  width: 100px;  
} 

.spinner1 input {  
  text-align: right;  
}  
.spinner2 input {  
  text-align: right;  
}  
.spinner3 input {  
  text-align: right;  
}  
.spinner4 input {  
  text-align: right;  
}  
.spinner5 input {  
  text-align: right;  
}  
.input-group-btn-vertical {  
  position: relative;  
  white-space: nowrap;  
  width: 1%;  
  vertical-align: middle;  
  display: table-cell;  
}  
.input-group-btn-vertical > .btn {  
  display: block;  
  float: none;  
  width: 100%;  
  max-width: 100%;  
  padding: 4px;  
  margin-left: -1px;  
  position: relative;  
  border-radius: 0;  
}  
.input-group-btn-vertical > .btn:first-child {  
  border-top-right-radius: 4px;  
}  
.input-group-btn-vertical > .btn:last-child {  
  margin-top: -2px;  
  border-bottom-right-radius: 4px;  
}  
.input-group-btn-vertical i{  
  position: absolute;  
  top: 0;  
  left: 4px;  
}  
.fa-caret-up{
	margin-left: -2px;
}
.fa-caret-down{
	margin-left: -2px;
	margin-top: -3px;
}
.fixed-table-body {
    height: 65%;
}
</style>		
<title></title>
</head>
<body class="no-skin">
<!--顶部按钮-->
<div class="page-content" style="height:100%">
<h3>酒标超期设置 单位：年</h3>
<br>
 <form role="form"  method="post" action="/param/exceedparam/save">

						<div class="form-group container">
						<label for="name" class="col-sm-2 control-label">白酒酒标有效期</label>
							<div class="input-group spinner1 col-sm-4">  
							    <input type="text" class="form-control" id="spec" name="whiteyear" value="${exceedparam.whiteyear}" READONLY>  
							    <div class="input-group-btn-vertical">  
							      <button class="btn btn-default" type="button"><i class="fa fa-caret-up"></i></button>  
							      <button class="btn btn-default" type="button"><i class="fa fa-caret-down"></i></button>  
							    </div>  
							    <label for="name" class="col-sm-1 control-label">年</label>
							</div>
						</div>
						<div class="form-group container">
						<label for="name" class="col-sm-2 control-label">黄酒酒标有效期</label>
							<div class="input-group spinner2 col-sm-4">  
							    <input type="text" class="form-control" id="spec" name="yellowyear" value="${exceedparam.yellowyear}" READONLY>  
							    <div class="input-group-btn-vertical">  
							      <button class="btn btn-default" type="button"><i class="fa fa-caret-up"></i></button>  
							      <button class="btn btn-default" type="button"><i class="fa fa-caret-down"></i></button>  
							    </div>  
							    <label for="name" class="col-sm-1 control-label">年</label>
							</div>
						</div>
						<div class="form-group container">
						<label for="name" class="col-sm-2 control-label">啤酒酒标有效期</label>
							<div class="input-group spinner3 col-sm-4">  
							    <input type="text" class="form-control" id="spec" name="beeryear" value="${exceedparam.beeryear}" READONLY>  
							    <div class="input-group-btn-vertical">  
							      <button class="btn btn-default" type="button"><i class="fa fa-caret-up"></i></button>  
							      <button class="btn btn-default" type="button"><i class="fa fa-caret-down"></i></button>  
							    </div>  
							    <label for="name" class="col-sm-1 control-label">年</label>
							</div>
						</div>
						<div class="form-group container">
						<label for="name" class="col-sm-2 control-label">红酒酒标有效期</label>
							<div class="input-group spinner4 col-sm-4">  
							    <input type="text" class="form-control" id="spec" name="redyear" value="${exceedparam.redyear}" READONLY>  
							    <div class="input-group-btn-vertical">  
							      <button class="btn btn-default" type="button"><i class="fa fa-caret-up"></i></button>  
							      <button class="btn btn-default" type="button"><i class="fa fa-caret-down"></i></button>  
							    </div>  
							    <label for="name" class="col-sm-1 control-label">年</label>
							</div>
						</div>
						<div class="form-group container">
						<label for="name" class="col-sm-2 control-label">进口酒酒标有效期</label>
							<div class="input-group spinner5 col-sm-4">  
							    <input type="text" class="form-control" id="spec" name="importyear" value="${exceedparam.importyear}" READONLY>  
							    <div class="input-group-btn-vertical">  
							      <button class="btn btn-default" type="button"><i class="fa fa-caret-up"></i></button>  
							      <button class="btn btn-default" type="button"><i class="fa fa-caret-down"></i></button>  
							    </div>  
							    <label for="name" class="col-sm-1 control-label">年</label>
							</div>
						</div>
						<input type="hidden" class="form-control" id="spec" name="id" value="${exceedparam.id}" READONLY>  
				<div align="center">
					<button class="btn btn-primary btn-sm" type="submit" >保存</button>
				</div>
	</form>
</body>
</html>
 
<script type="text/javascript">
var checkedIds = new Array();
$(function () {
	$('.spinner1 .btn:first-of-type').on('click', function() {  
		if(parseInt($('.spinner1 input').val(),10)<8){
			$('.spinner1 input').val(parseInt($('.spinner1 input').val(), 10) + 1);  
		}  
	});  
	$('.spinner1 .btn:last-of-type').on('click', function() {  
		if(parseInt($('.spinner1 input').val(),10)>1){
			$('.spinner1 input').val(parseInt($('.spinner1 input').val(), 10) - 1);  
		}  
	    //$('.spinner input').val(parseInt($('.spinner input').val(), 10) - 1);  
	});  
	
	$('.spinner2 .btn:first-of-type').on('click', function() {  
		if(parseInt($('.spinner2 input').val(),10)<8){
			$('.spinner2 input').val(parseInt($('.spinner2 input').val(), 10) + 1);  
		}  
	});  
	$('.spinner2 .btn:last-of-type').on('click', function() {  
		if(parseInt($('.spinner2 input').val(),10)>2){
			$('.spinner2 input').val(parseInt($('.spinner2 input').val(), 10) - 1);  
		}  
	    //$('.spinner input').val(parseInt($('.spinner input').val(), 10) - 1);  
	}); 
	$('.spinner3 .btn:first-of-type').on('click', function() {  
		if(parseInt($('.spinner3 input').val(),10)<8){
			$('.spinner3 input').val(parseInt($('.spinner3 input').val(), 10) + 1);  
		}  
	});  
	$('.spinner3 .btn:last-of-type').on('click', function() {  
		if(parseInt($('.spinner3 input').val(),10)>1){
			$('.spinner3 input').val(parseInt($('.spinner3 input').val(), 10) - 1);  
		}  
	    //$('.spinner input').val(parseInt($('.spinner input').val(), 10) - 1);  
	}); 
	$('.spinner4 .btn:first-of-type').on('click', function() {  
		if(parseInt($('.spinner4 input').val(),10)<8){
			$('.spinner4 input').val(parseInt($('.spinner4 input').val(), 10) + 1);  
		}  
	});  
	$('.spinner4 .btn:last-of-type').on('click', function() {  
		if(parseInt($('.spinner4 input').val(),10)>1){
			$('.spinner4 input').val(parseInt($('.spinner4 input').val(), 10) - 1);  
		}  
	    //$('.spinner input').val(parseInt($('.spinner input').val(), 10) - 1);  
	}); 
	$('.spinner5 .btn:first-of-type').on('click', function() {  
		if(parseInt($('.spinner5 input').val(),10)<8){
			$('.spinner5 input').val(parseInt($('.spinner5 input').val(), 10) + 1);  
		}  
	});  
	$('.spinner5 .btn:last-of-type').on('click', function() {  
		if(parseInt($('.spinner5 input').val(),10)>1){
			$('.spinner5 input').val(parseInt($('.spinner5 input').val(), 10) - 1);  
		}  
	    //$('.spinner input').val(parseInt($('.spinner input').val(), 10) - 1);  
	}); 
	})
</script>