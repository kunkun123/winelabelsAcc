<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
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
	
    <script src="../../../static/scripts/wineLabels/alalcohollable/alalcohollable.js"></script>
	<script src="../../../static/scripts/ent/ententbasic/ententbasic.js"></script>

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


<div class="page-content table-responsive">
<h3>申领审核</h3>
    <form role="form" id="queryForm" action="/ent/ententbasic/auditlist">
      	<tr id="lessQuery" >
		  			<td  colspan="4"  align="left">
		  			
		 				<button type="button" class="btn btn-sm btn-primary" onclick="query()">查询</button>
		 				
		 				<!-- <button type="button" class="btn btn-sm btn-light" onclick="clearInput()">重置</button>
		 		 -->	</td>
		 			</tr> 	
		 			
			<table class="">
				<tbody class="form-inline"> 
					<tr style="height:10px">
					</tr>		
					
	            <tr class="">
	                <td class="" style="">
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
	                <td class=" " style="">
                    <label class="bolder blue control-label"  for="form-field-1">&emsp;审核状态：</label>
	                </td>
	                <td class="" style="%">
	                    <select id="status">
	                        <option selected="true" value="">不限</option>
	                        <option value="1">未审核</option>
							<option value="2">通过</option>
													<option value="3">不通过</option>
	                    </select>
	                </td>
	            </tr>
					<tr style="height:10px"></tr>	
				</tbody>
			</table>
    </form>
    <table id="winelabelsAuditTable" class="text-nowrap"></table>
</div>

<!-- 明细Moda窗口 -->
<div class="modal fade role-modal" id="winelabelAudit" tabindex="-1" role="dialog" aria-labelledby="myDetailModalLabel">
    <div class="modal-dialog" role="document" >
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <i class="normal-icon ace-icon fa fa-user red bigger-130 user-icon"></i>
                <span class="modal-title" style="color: #DD5A43">审核</span>
            </div>
            <!--modal-body部分-->
            <div class="modal-body">
            	<form role="form" class="form-horizontal" style="width:100%;height:22%" id="enttypeFormDetail">
            			<div class="form-group">
						    <label for="firstname" class="col-sm-2 control-label">申领企业</label>
						    <div class="col-sm-4">
						      <input type="text" class="form-control" name="entnameAudit" readonly/>
						    </div>
						     <label for="firstname" class="col-sm-2 control-label">申领数量</label>
						    <div class="col-sm-4">
						      <input type="text" class="form-control" name="numberAudit" readonly/>
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="firstname" class="col-sm-2 control-label">信用代码</label>
						    <div class="col-sm-4">
						      <input type="text" class="form-control" name="creditcodeAudit" readonly/>
						    </div>
						    <label for="firstname" class="col-sm-2 control-label">申领时间</label>
						    <div class="col-sm-4">
						      <input type="text" class="form-control" name="applicantDateAudit" readonly/>
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="firstname" class="col-sm-2 control-label">商品种类</label>
						    <div class="col-sm-4">
						      <input type="text" class="form-control" name="producttypeAudit" readonly/>
						    </div>
						    <!-- <label for="firstname" class="col-sm-2 control-label">库存数量</label>
						    <div class="col-sm-4">
						      <input type="text" class="form-control" name="surplusNumberAudit" readonly/>
						    </div> -->
						     <div class="col-sm-4">
						      <input type="hidden" class="form-control" name="entidAudit" readonly/>
						    </div>
						  </div>
	                </form>
	                 <br>
	                <div class="form-group" style="text-align:center ">
						<button type="button" onclick="entView()" style="border-radius:25px;" class="btn btn-primary save btn-sm">查看企业信息</button>
						<button type="button" onclick="applicationHis()" style="border-radius:25px;" class="btn btn-primary save btn-sm">查看申领历史</button>
					</div>
	               
	                <hr style="BORDER-BOTTOM-STYLE: dotted; BORDER-LEFT-STYLE: dotted; BORDER-RIGHT-STYLE: dotted; BORDER-TOP-STYLE: dotted" color=#111111 size=1> 
	                 <form role="form" class="form-horizontal" style="width:100%;height:20%" action="/ent/entapplication/winelabelsAudit">
						  <div class="form-group">
						    	<label for="firstname" class="col-sm-4 control-label">请选择审核结果：</label>
						    	<!-- <select id="winelabelsStatus" class="col-sm-4" name="winelabelsStatus"><option value="ON">通过</option>
						    	<option value="UN">不通过</option>
						    	 -->
						    	 <input type="radio" name="winelabelsStatus" value="ON" checked/>通过 &nbsp;&nbsp;&nbsp;
						    	 <input type="radio" name="winelabelsStatus" value="UN"/>不通过
						    	<input type="hidden" id="applicantId" name="applicantId"/>
						  </div>
						  <div class="form-group">
						    	<label for="firstname" class="col-sm-4 control-label">审核意见：</label>
						    	<textarea id="reason" name="reason"rows="2" cols="25"></textarea>
						  </div>
						   <div class="form-group" style="text-align:center">
						    	<button style="" class="btn btn-primary save btn-sm">提交</button>
						  </div>
					</form>
				
			</div>
           <!--  <!--modal-footer部分-->
            <div class="modal-footer" id="modal-footer" style="height:0%;margin-top:10%">
			    <button type="button" class="hidden" data-dismiss="modal"></button>
            </div>
        </div>
    </div>
</div>





<!-- 查看申领信息的modal窗口 -->
<div class="modal fade role-modal" id="entInfo" tabindex="-1" role="dialog" aria-labelledby="myDetailModalLabel">
    <div class="modal-dialog" role="document" >
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <i class="normal-icon ace-icon fa fa-user red bigger-130 user-icon"></i>
                <span class="modal-title" style="color: #DD5A43">审核</span>
            </div>
            <!--modal-body部分-->
            <div class="modal-body">
            	<form role="form" class="form-horizontal" style="width:100%;height:50%" id="enttypeFormDetail">
            			<div class="form-group">
						    <label for="firstname" class="col-sm-2 control-label">申领企业</label>
						    <div class="col-sm-4">
						      <input type="text" class="form-control" name="entnameAudit" readonly/>
						    </div>
						     <label for="firstname" class="col-sm-2 control-label">申领数量</label>
						    <div class="col-sm-4">
						      <input type="text" class="form-control" name="numberAudit" readonly/>
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="firstname" class="col-sm-2 control-label">统一社会信用代码</label>
						    <div class="col-sm-4">
						      <input type="text" class="form-control" name="creditcodeAudit" readonly/>
						    </div>
						    <label for="firstname" class="col-sm-2 control-label">申领时间</label>
						    <div class="col-sm-4">
						      <input type="text" class="form-control" name="applicantDateAudit" readonly/>
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="firstname" class="col-sm-2 control-label">商品种类</label>
						    <div class="col-sm-4">
						      <input type="text" class="form-control" name="producttypeAudit" readonly/>
						    </div>
						    <label for="firstname" class="col-sm-2 control-label">库存数量</label>
						    <div class="col-sm-4">
						      <input type="text" class="form-control" name="surplusNumberAudit" readonly/>
						    </div>
						  </div>
	                </form>
	                 <br>
	                <div class="form-group" style="text-align:center">
						<button type="button" style="border-radius:25px;" class="btn btn-success save btn-sm">查看企业信息</button>
						<button type="button" style="border-radius:25px;" class="btn btn-success save btn-sm">查看申领历史</button>
					</div>
	               
	                <hr style="BORDER-BOTTOM-STYLE: dotted; BORDER-LEFT-STYLE: dotted; BORDER-RIGHT-STYLE: dotted; BORDER-TOP-STYLE: dotted" color=#111111 size=1> 
	                 <form role="form" class="form-horizontal" style="width:100%;height:50%" action="/ent/entapplication/winelabelsAudit">
						  <div class="form-group">
						    	<label for="firstname" class="col-sm-4 control-label">请选择审核结果：</label>
						    	<select id="winelabelsStatus" class="col-sm-4" name="winelabelsStatus"><option value="ON">通过</option>
						    	<option value="UN">不通过</option>
						    	<input type="hidden" id="applicantId" name="applicantId"/>
						  </div>
						  <div class="form-group">
						    	<label for="firstname" class="col-sm-4 control-label">审核意见：</label>
						    	<textarea id="reason" name="reason"rows="2" cols="25"></textarea>
						  </div>
						   <div class="form-group" style="text-align:center">
						    	<button style="border-radius:25px;" class="btn btn-success save btn-sm">提交</button>
						  </div>
					</form>
				
			</div>
           <!--  <!--modal-footer部分-->
            <div class="modal-footer" id="modal-footer" style="height:10%;margin-top:5%">
			    <button type="button" class="btn btn-primary save" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>

</body>
</html>