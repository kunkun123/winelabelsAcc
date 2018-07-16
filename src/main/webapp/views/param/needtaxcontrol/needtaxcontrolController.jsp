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
	<script src="/static/scripts/gecko-modules/bootstrap/bootstrap-datetimepicker.js"></script>
</head>
<style>
    .row-margin-top{
        margin-top: 10px;
    }
    .timeline {
  list-style: none;
  padding: 20px 0 20px;
  position: relative;
}
.timeline:before {
  top: 0;
  bottom: 0;
  position: absolute;
  content: " ";
  width: 3px;
  background-color: #eeeeee;
  left: 15%;
  margin-left: -1.5px;
}
.timeline > li {
  margin-bottom: 20px;
  position: relative;
}
.timeline > li:before,
.timeline > li:after {
  content: " ";
  display: table;
}
.timeline > li:after {
  clear: both;
}
.timeline > li:before,
.timeline > li:after {
  content: " ";
  display: table;
}
.timeline > li:after {
  clear: both;
}
.timeline > li > .timeline-panel {
  width: 30%;
  float: left;
  border: 1px solid #d4d4d4;
  border-radius: 2px;
  padding: 3px;
  position: relative;
  -webkit-box-shadow: 0 1px 6px rgba(0, 0, 0, 0.175);
  box-shadow: 0 1px 6px rgba(0, 0, 0, 0.175);
}
.timeline > li > .timeline-panel:before {
  position: absolute;
  top: 26px;
  right: -15px;
  display: inline-block;
  border-top: 15px solid transparent;
  border-left: 15px solid #ccc;
  border-right: 0 solid #ccc;
  border-bottom: 15px solid transparent;
  content: " ";
}
.timeline > li > .timeline-panel:after {
  position: absolute;
  top: 27px;
  right: -14px;
  display: inline-block;
  border-top: 14px solid transparent;
  border-left: 14px solid #fff;
  border-right: 0 solid #fff;
  border-bottom: 14px solid transparent;
  content: " ";
}
.timeline > li > .timeline-badge {
  color: #fff;
  width: 35px;
  height: 35px;
  line-height: 50px;
  font-size: 1.4em;
  text-align: center;
  position: absolute;
  top: 25px;
  left: 15.8%;
  margin-left: -25px;
  background-color: #999999;
  z-index: 100;
  border-top-right-radius: 50%;
  border-top-left-radius: 50%;
  border-bottom-right-radius: 50%;
  border-bottom-left-radius: 50%;
}
.timeline > li.timeline-inverted > .timeline-panel {
  float: right;
  left: -50%;
}
.timeline > li.timeline-inverted > .timeline-panel:before {
  border-left-width: 0;
  border-right-width: 15px;
  left: -15px;
  right: auto;
}
.timeline > li.timeline-inverted > .timeline-panel:after {
  border-left-width: 0;
  border-right-width: 14px;
  left: -14px;
  right: auto;
}
.timeline-badge.primary {
  background-color: #2e6da4 !important;
}
.timeline-badge.success {
  background-color: #3f903f !important;
}
.timeline-badge.warning {
  background-color: #f0ad4e !important;
}
.timeline-badge.danger {
  background-color: #d9534f !important;
}
.timeline-badge.info {
  background-color: #5bc0de !important;
}
.timeline-title {
  margin-top: 0;
  color: inherit;
}
.timeline-body > p,
.timeline-body > ul {
  margin-bottom: 0;
}
.timeline-body > p + p {
  margin-top: 5px;
}
 body {
        background-color:white;
    }
    .fixed-table-body {
    overflow-x: auto;
    overflow-y: auto;
    height: auto;
}
</style>
<body class="no-skin">
<div class="page-content">
<h3>酒标应税管理</h3>

              
                <form role="form" id="queryForm">
                   <tr id="lessQuery" >
		  			<td  colspan="4"  align="left">
		  			
		 				<button type="button" class="btn btn-sm btn-primary" onclick="queryList()">查询</button>
		 				
		 				<!-- <button type="button" class="btn btn-sm btn-light" onclick="clearInput()">重置</button>
		 			 --></td>
		 			</tr> 	
		 			
			<table class="">
				<tbody class="form-inline"> 
					<tr style="height:10px">
					</tr>		
					
	            <tr class="">
	                <td class=" " style="">
                                <label class="bolder blue control-label "  for="serialSearch">统一社会信用代码：</label>
                             </td><td class=" " style="">
                                <input name="search"  id="creditSearch" type="text"  class="form-control"/>
                            </td>
                            <td  class=" " style="">
                                <label class="bolder control-label  blue" for="productidSearch">&emsp;酒标申领企业：</label>
                            </td><td class=" " style="">
                                 <input name="search" id="entSearch" type="text" class="form-control"/>
                            </td>
                           <td align="center" class=" " style="">
								<label class="blue bolder control-label"  for="name">
								&emsp;统计区间:</label>
								<input style="" type="text" name="productname" class="form-control datepicker" id="startDate">
							
								<label class="control-label"  for="name">--</label>
								<input type="text" style="" name="productname" class="form-control datepicker" id="endDate">
							   </td>
	            </tr>
					
				</tbody>
			</table>
                </form>

                <table id="labelManagerList">
                </table>

            </div>
        </div><!-- PAGE CONTENT ENDS -->
    </div><!-- /.col -->
</div><!-- /.row -->
<!-- /.main-container -->

<!-- 查看酒标信息 -->
<div class="modal fade role-modal" id="winelabelDetails" tabindex="-1" role="dialog" aria-labelledby="myModalAuthLabel">
	<div class="modal-dialog" role="document" style="width:898px;height:492px;">
		<div class="modal-content" >
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
			                        aria-hidden="true">&times;</span></button>
			    <span class="modal-title" id="myModalNoticeLabel" style="color:#DD5A43">酒标明细</span>
			</div>
			<!--modal-body部分-->
				<div class="modal-body" id="notice">
					
					<table id="winelabelsDetail"></table>
				</div>
				<!--modal-footer部分-->
			<!-- <div class="modal-footer" style="text-align:center;">
			    <button type="button" class="btn btn-primary save" data-dismiss="modal">关闭</button>
			</div> -->
		</div>
	</div>
</div>
<!-- 查看酒标信息 -->
<div class="modal fade role-modal" id="winelabelDetails1" tabindex="-1" role="dialog" aria-labelledby="myModalAuthLabel">
	<div class="modal-dialog" role="document" style="width:898px;height:492px;">
		<div class="modal-content" >
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
			                        aria-hidden="true">&times;</span></button>
			    <span class="modal-title" id="myModalNoticeLabel" style="color:#DD5A43">查看酒标详细信息</span>
			</div>
			<!--modal-body部分-->
				<div class="modal-body" id="notice">
					<form role="form" method="post" class="form-horizontal">
						<div class="form-group">
							<label for="name" class="control-label col-sm-2">酒标编码</label> 
							<div class="col-sm-4">
								<span name="winelabelCode" class="form-control" id="detailsSerial"></span>
							</div>
							<label for="name" class="control-label col-sm-2">对应商品</label> 
							<div class="col-sm-4">
								<span name="winelabelCode" class="form-control" id="detailsProduct"></span>
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="control-label col-sm-2">酒标类型</label> 
							<div class="col-sm-4">
								<span name="winelabelCode" class="form-control" id="detailsWineLabelsType"></span>
							</div>
							<label for="name" class="control-label col-sm-2">商品种类</label> 
							<div class="col-sm-4">
								<span name="winelabelCode" class="form-control" id="detailsProductType"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="name">状态</label> 
							<div class="col-sm-4">
								<span name="winelabelCode" class="form-control" id="detailsStatus"></span>
							</div>
							<label class="col-sm-2 control-label" for="name">企业名称</label> 
							<div class="col-sm-4">
								<span name="winelabelCode" class="form-control" id="detailsEnt"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="name">统一社会代码</label> 
							<div class="col-sm-4">
								<span name="winelabelCode" class="form-control" id="detailsCredit"></span>
							</div>
						</div>
					</form>
					<div class="">
						<span name="winelabelCode" class="" id="info"></span>
						</div>
					<table id="winelabelsDetail1"></table>
				</div>
				<!--modal-footer部分-->
			<!-- <div class="modal-footer" style="text-align:center;">
			    <button type="button" class="btn btn-primary save" data-dismiss="modal">关闭</button>
			</div> -->
		</div>
	</div>
</div>


<!-- 酒标流转 -->
<div class="modal fade role-modal" id="winelabelTranfer" tabindex="-1" role="dialog" aria-labelledby="myModalAuthLabel">
	<div class="modal-dialog" role="document" style="width:65%;height:150%;">
		<div class="modal-content" >
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
			                        aria-hidden="true">&times;</span></button>
			    <span class="modal-title" id="myModalNoticeLabel" style="color:#DD5A43">查看酒标详细信息</span>
			</div>
			<!--modal-body部分-->
				<div class="modal-body" id="notice">
					<div>
						<form role="form" method="post" class="form-horizontal">
							<div class="form-group">
								<label for="name" class="control-label col-sm-2">酒标编码</label> 
								<div class="col-sm-4">
									<span name="winelabelCode" class="form-control" id="detailsSerial1"></span>
								</div>
								<label for="name" class="control-label col-sm-2">对应商品</label> 
								<div class="col-sm-4">
									<span name="winelabelCode" class="form-control" id="detailsProduct1"></span>
								</div>
							</div>
							<div class="form-group">
								<label for="name" class="control-label col-sm-2">酒标类型</label> 
								<div class="col-sm-4">
									<span name="winelabelCode" class="form-control" id="detailsWineLabelsType1"></span>
								</div>
								<label for="name" class="control-label col-sm-2">商品种类</label> 
								<div class="col-sm-4">
									<span name="winelabelCode" class="form-control" id="detailsProductType1"></span>
								</div>
							</div>
						</form>
					</div>
					<br><br>
					<div class="container" style="overflow:auto;width:95%;height:35%">
					    <ul class="timeline" id="timeline"></ul>
					</div>
				</div>
				<!--modal-footer部分-->
			<!-- <div class="modal-footer" style="text-align:center;">
			    <button type="button" class="btn btn-primary save" data-dismiss="modal">关闭</button>
			</div> -->
		</div>
	</div>
</div>

<script type="text/javascript">
    $('#labelManagerList').bootstrapTable({
        //toolbar: "#toolbar",
        idField: "id",
        pagination: true,
        clickToSelect:true,
        // method : "POST",
        //contentType : "application/x-www-form-urlencoded",
        sidePagination: 'client',
        pageNumber: 1,
        pageSize: 5,
        pageList: [5, 10, 20],
        queryParams:queryParams,
		showFooter:true,
        <%--url: "<c:url value='/SellServlet?act=ajaxGetSellRecord'/>", //获取数据的Servlet地址--%>
        url:"/param/needtaxcontrol/list",

        columns: [
	         {
	            field:'id',
	            visible:false
	        },{
                //field: 'credit',
                title: '序号',
                 align: 'center',
                sortable:true,
                 formatter: function (value, row, index) {  
			        return index+1;  
			        }  ,
                footerFormatter:runningFormatter
            },{
                field: 'credit',
                title: '统一社会信用代码',
                 align: 'center',
                sortable:true
            },  {
                field: 'ent',
                title: '酒标申领企业',
                align: 'center',
                visible: true
            },{
                field: 'needtax',
                 align: 'center',
                title: '应税酒标数量',
                footerFormatter:sumFormatter,
                formatter:operateFormatter
            }, {
                field: 'white',
                 align: 'center',
                title: '白酒数量',
                 footerFormatter:sumFormatter
            }, {
                field: 'yellow',
                title: '黄酒数量',
                 align: 'center',
                  footerFormatter:sumFormatter
            }, {
                field: 'beer',
                 align: 'center',
                title: '啤酒数量',
                 footerFormatter:sumFormatter
            }, {
                field: 'other',
                 align: 'center',
                title: '其他酒数量',
                 footerFormatter:sumFormatter
            }]
    });

    function queryParams(params) {
        /*var params = {
            startDate : $('#startDate').val(),
            endDate : $('#endDate').val(),
            auditStatus : $('#auditStatus').val()
        }*/
        params.entName = $('#entSearch').val();
        params.credit = $('#creditSearch').val();
        params.startDate = $('#startDate').val();
        params.endDate = $('#endDate').val();
        return params;
    }
    /*申请列表查询*/
    function queryList(){
        $('#labelManagerList').bootstrapTable('refresh');
    }

    
    function bigImg(x) {
        x.style.width = "100%";
    }
    function normalImg(x) {
        x.style.width = "10%";
    }
    /*根据审核状态进行相应的操作*/
    function operateFormatter(value,row,index) {
        return[
          "<button class='btn btn-link' href='javascript:void(0)' onclick='view()'>"+row.needtax+"</button>"].join('')
       
    }
    function clearInput(){
		document.getElementById("queryForm").reset();	
	}
    function view(){
		$("#winelabelsDetail").bootstrapTable('destroy'); 
	   
		$("#winelabelsDetail").bootstrapTable({
                idField: "id",
                pagination: true,
			    sidePagination: 'client',
			    pageNumber: 1,
			    pageSize: 5,
			   	url: "/param/inventorycontrol/detailList",
			    pageList: [5, 10, 20],
                columns: [  
               	[{
                    field: "id",
                    visible: false
                },{  
			        field: 'Number',  
			        title: '序号',  align: 'center',
			        formatter: function (value, row, index) {  
			        return index+1;  
			        }  
			    },{
                    field: "serial",
                    title: "酒标编码",
                    type: "text",
                    search: "true",align: 'center',
                    sortable: true,
                    editable: {
                        type: "text"
                    }
                }, {
                    field: "temp1",
                    title: "酒标类型",
                    type: "text",
                    search: "true",align: 'center',
                    editable: {
                        type: "text"
                    }
                }, {
                    field: "productid",
                    title: "对应商品",
                    type: "text",align: 'center',
                    search: "true",
                    editable: {
                        type: "text"
                    }
                }, {
                    field: "applicanid",
                    title: "商品种类",
                    type: "text",
                    search: "true",align: 'center',
                    editable: {
                        type: "text"
                    }
                }, {
                    field: "creator",
                    title: "状态",
                    type: "text",
                    search: "true",align: 'center',
                    editable: {
                        type: "text"
                    }
                },{
                field: 'operate',
                 align: 'center',
                title: '操作',
                //events: operateEvents,
                formatter:operateFormatter1
            	}]]
            });  
       
		$("#winelabelDetails").modal("show");
	}
	function viewBox(obj){
		$.ajax({
             type: "GET",
             url: "/wineLabels/alalcoholflow/winelabelsTransfer",
             data: {winelabels:obj.serial},
             dataType: "json",
             success: function(data){
              	var str ="";
              	$.each(data, function(i, item){
              		//alert(item.temp1);
              	    if(i==0){
              	    	str+='<li class="timeline-inverted">'+
					          '<div class="timeline-badge warning"><i class="glyphicon glyphicon-credit-card"'+
					          'style="margin-left:2px;margin-top:8px"></i></div>'+
					         ' <div class="timeline-panel">'+
					           ' <div class="timeline-heading">'+
					              '<h4 class="timeline-title">'+item.temp1+'</h4>'+
					            '</div>'+
					            '<div class="timeline-body">'+
					              '<p>'+item.flowname+'</p>'+
					            '</div>'+
					          '</div>'+
					        '</li>';
              	    }else{
              	    	str+='<li class="timeline-inverted">'+
					          '<div class="timeline-badge"><i class="glyphicon glyphicon-check"'+
					          'style="margin-left:2px;margin-top:8px"></i></div>'+
					         ' <div class="timeline-panel">'+
					           ' <div class="timeline-heading">'+
					              '<h4 class="timeline-title">'+item.temp1+'</h4>'+
					            '</div>'+
					            '<div class="timeline-body">'+
					              '<p>'+item.flowname+'</p>'+
					            '</div>'+
					          '</div>'+
					        '</li>';
              	    }
              	});
              	$("#timeline").html(str);
             }
         });
          
        $("#detailsSerial1").html(obj.serial);
        $("#detailsProduct1").html(obj.productid);
        $("#detailsWineLabelsType1").html(obj.temp1);
        $("#detailsProductType1").html(obj.applicanid); 
		$("#winelabelTranfer").modal("show");
	}
	function sumFormatter(data) {
	    field = this.field;
	    return data.reduce(function(sum, row) { 
	        return sum + (+row[field]);
	    }, 0);
}
function runningFormatter(value, row, index) {
    return '合计';
}
function operateFormatter1(value,row,index) {
        return[
          "<button class='btn btn-link' href='javascript:void(0)' onclick='viewInfo("+JSON.stringify(row)+")'>查看酒标</button>"
        + "<button class='btn btn-link' href='javascript:void(0)' onclick='viewBox("+JSON.stringify(row)+")'>查看流转</button>"
        ].join('')
       
    }
    function viewInfo(obj){
		$("#winelabelsDetail1").bootstrapTable('destroy'); 
	    var id = obj.serial;
		$("#winelabelsDetail1").bootstrapTable({
                idField: "id",
                pagination: true,
			    sidePagination: 'client',
			    pageNumber: 1,
			    pageSize: 5,
			    queryParams:{winelabelId:id},
                url: "/wineLabels/alalcohollable/wineLabelsDetail",
			    pageList: [5, 10, 20],
                columns: [  
               	[{
                    field: "id",
                    visible: false
                },{  
			        field: 'Number',  
			        title: '序号',
                    align: 'center',
			        formatter: function (value, row, index) {  
			        return index+1;  
			        }  
			    },{
                    field: "serial",
                    title: "酒标编码",
                    align: 'center',
                    type: "text",
                    search: "true",
                    sortable: true,
                    editable: {
                        type: "text"
                    }
                }, {
                    field: "temp1",
                    title: "状态",
                    align: 'center',
                    type: "text",
                    search: "true",
                    editable: {
                        type: "text"
                    }
                }]]
            });  
        if("箱标"==obj.temp1){
        	$("#info").html("包含的瓶标如下：");
        }else if("瓶标"==obj.temp1){
        	$("#info").html("所属的箱标如下：");
        }
        $("#detailsSerial").html(obj.serial);
        $("#detailsProduct").html(obj.productid);
        $("#detailsWineLabelsType").html(obj.temp1);
        $("#detailsProductType").html(obj.applicanid); 
        $("#detailsStatus").html(obj.creator);
       	 
       	$("#detailsEnt").html(obj.grant); 
        $("#detailsCredit").html(obj.owner);   
		$("#winelabelDetails1").modal("show");
	}
$(window).on('load', function () {  
  		
            if(!ace.vars['old_ie']) $(".datepicker").datetimepicker({
				 //format: 'YYYY/MM/DD h:mm:ss A',//use this option to display seconds
				 	format: 'yyyy-mm',  
		        	language: 'cn',  
		        	 autoclose: true,
		        	 viewSelect: 'year',
		        	 startView: 'year',
       	 			minView:'year',
        			maxView:'decade'
				});
  		});  
</script>


</body>
</html>
