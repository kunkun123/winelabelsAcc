<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="org.gecko.common.utils.GeckoProperties"%>
<%
	String accPath = GeckoProperties.getString("WINELABELS_ACC");
%>
<script> var accPath = '<%=accPath%>';</script>
<html>
<head>
	<meta charset="UTF-8">
    <title>system-Account</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" type="text/css" href="/static/styles/css/ace-fonts.css"/>
    <link rel="stylesheet" type="text/css" href="/static/styles/css/font-awesome.css"/>
    <link rel="stylesheet" type="text/css" href="/static/styles/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="/static/styles/css/bootstrap-table.css"/>
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
	
    <script src="../../../static/scripts/ent/ententbasic/entauditbasic.js"></script>


</head>
<body>
<style>
    body {
        background-color:white;
    }
    .fixed-table-body {
    overflow-x: auto;
    overflow-y: auto;
    height: auto;
}
</style>


<div class="page-content">
<h3>注册审核</h3>
    <form role="form" id="queryForm" action="/ent/ententbasic/auditlist">
    <tr style="height:10px"></tr>
     <tr id="lessQuery" >
                <td  colspan="4"  align="left">

                    <button type="button" class="btn btn-sm btn-primary" onclick="query()">查询</button>
                    
                   <!--  <button type="button" class="btn btn-sm btn-light" onclick="clearInput()">重置</button>
                --> </td>
           </tr>
        <table class="">
            <tbody class="form-inline">
	 	<tr style="height:10px"></tr>
            <tr class="">
                <td class=" " style="" align="right">
                    <label class="bolder blue control-label"  for="form-field-1">统一社会信用代码：</label>
                </td>
                <td class=" " style="">
                    <input name="search"  id="creditcode" type="text" class="form-control" width="98%"/>
                </td>
                <td class=" " style="" align="right">
                    <label class="control-label bolder blue" for="form-field-1">&emsp;企业名称：</label>
                </td>
                <td class=" " style="">
                    <input name="search" id="entname" type="text" class="form-control" width="98%"/>
                </td>
            </tr>
             <tr style="height:10px"></tr>
           
            </tbody>
        </table>
    </form>
    <table id="entbasicTable" class=""></table>
</div>

<!-- 明细Moda窗口 -->
<div class="modal fade role-modal" id="myDetailModal" tabindex="-1" role="dialog" aria-labelledby="myDetailModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <i class="normal-icon ace-icon fa fa-user red bigger-130 user-icon"></i>
                <span class="modal-title" style="color: #DD5A43">查看企业信息</span>
            </div>
            <!--modal-body部分-->
            <div class="modal-body" style="height:35%">
            	<form role="form" class="form-horizontal" style="width:60%;height:60%" id="enttypeFormDetail">
            		<div class="form-group">
						    <label for="firstname" class="col-sm-4 control-label">社会信用代码</label>
						    <div class="col-sm-6">
						      <input type="text" class="form-control" name="creditcode1" readonly/>
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="firstname" class="col-sm-4 control-label">企业名称</label>
						    <div class="col-sm-6">
						      <input type="text" class="form-control" name="entname1" readonly/>
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="firstname" class="col-sm-4 control-label">地址</label>
						    <div class="col-sm-6">
						      <input type="text" class="form-control" name="address" readonly/>
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="firstname" class="col-sm-4 control-label">电话</label>
						    <div class="col-sm-6">
						      <input type="text" class="form-control" name="tel" readonly/>
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="firstname" class="col-sm-4 control-label">开户银行</label>
						    <div class="col-sm-6">
						      <input type="text" class="form-control" name="bank" readonly/>
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="firstname" class="col-sm-4 control-label">银行账号</label>
						    <div class="col-sm-6">
						      <input type="text" class="form-control" name="acct" readonly/>
						    </div>
						  </div>
	                </form>
	               
	                <%--<div style="margin-left:60%;margin-top:-23%;width:40%;" id="licenseattachDiv"></div>--%>
				<img  style="margin-left:4%;margin-top:-23%;width:40%;" src="/fakeimage/zhizhao.jpg">
	                <br/><br/>
	                 <form role="form" class="form-horizontal" style="width:100%;height:80%" id="">
            			<div class="form-group">
						    <div class="col-sm-3" id="">
								<img width="100%" height="50%"  src="/fakeimage/xuke.jpeg">
						    </div>
						     <div class="col-sm-3" id="">
								 <img width="100%" height="50%"  src="/fakeimage/xuke.jpeg">
						    </div>
						     <div class="col-sm-3" id="">
								 <img width="100%" height="50%"  src="/fakeimage/xuke.jpeg">
						    </div>
						     <div class="col-sm-3"  id="">
								 <img width="100%" height="50%"  src="/fakeimage/xuke.jpeg">
						     </div>
						 </div>
					</form>

					<form role="form" class="form-inline"style="margin-top:-13%;width:100%;height:10%" id="enttypeFormDetail">
						以下是企业联系信息：<br>
						<div class="form-group">
							<label for="f1">联系人：</label> <input style="border: 0px;outline:none;width:20%" type="text" name="contacts"
								class="form-control" readonly/>

							<label for="f2">联系电话：</label> <input style="border: 0px;outline:none;width:20%" type="text" name="contactphone"
								class="form-control" readonly/>

							<label for="f3" >电子邮箱：</label> <input style="border: 0px;outline:none;width:21%" type="text" name="email"
								class="form-control" readonly/>
						</div>
					</form>
				</div>
           <!--  <!--modal-footer部分-->
            <div class="modal-footer" id="modal-footer" style="height:0%;margin-top:42%">
			    <button type="button" class="hidden" data-dismiss="modal"></button>
            </div>
        </div>
    </div>
</div>
<!-- 明细Moda窗口 -->
<div class="modal fade role-modal" id="editAuditModel" tabindex="-1" role="dialog" aria-labelledby="myDetailModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <i class="normal-icon ace-icon fa fa-user red bigger-130 user-icon"></i>
                <span class="modal-title" style="color: #DD5A43">审核企业信息</span>
            </div>
            <!--modal-body部分-->
            <div class="modal-body" style="height:35%">
            	<form role="form" class="form-horizontal" style="width:60%;height:60%" id="enttypeFormDetail">
            		<div class="form-group">
						    <label for="firstname" class="col-sm-4 control-label">社会信用代码</label>
						    <div class="col-sm-6">
						      <input type="text" class="form-control" name="creditcode1" readonly/>
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="firstname" class="col-sm-4 control-label">企业名称</label>
						    <div class="col-sm-6">
						      <input type="text" class="form-control" name="entname1" readonly/>
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="firstname" class="col-sm-4 control-label">地址</label>
						    <div class="col-sm-6">
						      <input type="text" class="form-control" name="address" readonly/>
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="firstname" class="col-sm-4 control-label">电话</label>
						    <div class="col-sm-6">
						      <input type="text" class="form-control" name="tel" readonly/>
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="firstname" class="col-sm-4 control-label">开户银行</label>
						    <div class="col-sm-6">
						      <input type="text" class="form-control" name="bank" readonly/>
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="firstname" class="col-sm-4 control-label">银行账号</label>
						    <div class="col-sm-6">
						      <input type="text" class="form-control" name="acct" readonly/>
						    </div>
						  </div>
	                </form>
	               
	                <%--<div style="margin-left:60%;margin-top:-23%;width:40%;" id="licenseattachDiv1"></div>--%>
					<img  style="margin-left:4%;margin-top:-23%;width:40%;" src="/fakeimage/zhizhao.jpg">
	                <br/><br/>
	                 <form role="form" class="form-horizontal" style="width:100%;height:80%" id="enttypeFormDetail" action="/ent/ententbasic/editStatus">
            			<div class="form-group">
						    <div class="col-sm-3" id="">
								<img width="100%" height="50%"  src="/fakeimage/xuke.jpeg">
						    </div>
						     <div class="col-sm-3" id="">
								 <img width="100%" height="50%"  src="/fakeimage/xuke.jpeg">
						    </div>
						     <div class="col-sm-3" id="">
								 <img width="100%" height="50%"  src="/fakeimage/xuke.jpeg">
						    </div>
						     <div class="col-sm-3"  id="">
								 <img width="100%" height="50%"  src="/fakeimage/xuke.jpeg">
						     </div>
						 </div>
						     <div class="form-group" style="margin-top:3%;width:100%;height:5%">
						    	
						    	<label for="firstname" class="col-sm-4 control-label">请选择审核结果：</label>
						    	<!-- <select id="winelabelsStatus" class="col-sm-4" name="winelabelsStatus"><option value="ON">通过</option>
						    	<option value="UN">不通过</option>
						    	 -->
						    	 <input type="radio" name="entStatus" value="ON" checked/>通过 &nbsp;&nbsp;&nbsp;
						    	 <input type="radio" name="entStatus" value="UN"/>不通过
						    	<input type="hidden" id="editEntId" name="editEntId"/>
						    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<button style="" class="btn btn-primary save btn-mini">提交</button>
						  	</div>
					</form>
				</div>
           <!--  <!--modal-footer部分-->
            <div class="modal-footer" id="modal-footer" style="height:0%;margin-top:43%">
			    <button type="button" class="hidden" data-dismiss="modal"></button>
            </div>
        </div>
    </div>
</div>
</body>
</html>