
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>complaint-CpComplaintsreport</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- bootstrap & fontawesome -->
    <link rel="stylesheet" href="/static/styles/css/bootstrap.css"/>
    <link rel="stylesheet" href="/static/styles/css/font-awesome.css"/>
    <!-- page specific plugin styles -->
    <!-- text fonts -->
    <link rel="stylesheet" href="/static/styles/css/ace-fonts.css"/>
    <!-- ace styles -->
    <link rel="stylesheet" href="/static/styles/css/ace.css" class="ace-main-stylesheet" id="main-ace-style"/>
    <script src="/static/scripts/gecko-modules/ace/ace-extra.min.js"></script>
    <script src="/static/scripts/gecko-modules/jquery/jquery.js"></script>
    <script src="/static/scripts/gecko-modules/bootstrap/bootstrap.js"></script>
    <script src="/static/scripts/gecko-modules/bootstrap/bootstrap-table.js"></script>
    <script src="/static/scripts/gecko-modules/bootstrap/bootstrap-table-zh-CN.js"></script>
    <script src="/static/scripts/gecko-modules/bootstrap/bootstrap-datepicker.js"></script>
    <script src="/static/scripts/gecko-modules/bootstrap/bootstrap-datepicker-zhCN.js"></script>
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
</style>
<body class="no-skin">
<div class="main-container ace-save-state" id="main-container">
    <div class="main-content">
        <div class="main-content-inner">
            <div class="page-content">
                <div class="page-header">
                   
                </div><!-- /.page-header -->
               
                <table id="labelManagerList"></table>

<script type="text/javascript">
$(function () {
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

        <%--url: "<c:url value='/SellServlet?act=ajaxGetSellRecord'/>", //获取数据的Servlet地址--%>
        url:"/ent/entapplication/applicationHis",

        columns: [{
                field: 'applicandate',
                title: '申领日期',
                sortable:true
            },  {
                field: 'productnumber',
                title: '申领数量',
                visible: false
            },{
                field: 'temp2',
                title: '对应产品类型'
            }, {
                field: 'temp1',
                title: '审核状态'
            }]
    });

});  

function queryParams(params) {
    var param = {
        entId : <%=request.getParameter("entId")%> 
    }
    return param;
}  
</script>


</body>
</html>
