/**
 * wineLabels-alalcohollable
 */
$(function () {
    $("#winelabelsAuditTable").bootstrapTable({
        //toolbar: "#toolbar",
        idField: "id",
        pagination: true,
        queryParams:queryParams,
        sidePagination: "client",
        pageNumber: 1,
        pageSize: 5,
        pageList: [5, 10, 20],
        url: "/ent/entapplication/winelabelsAuditList",
        columns: [
           /* [{
                "title": "<img src='/static/scripts/gecko-modules/img/u152.png' class='img-rounded' >企业列表",
                "halign":"left",
                "align":"center",
                "colspan": 15
            }],*/
            [{
                field: "id",
                visible: false
            }, {
                field: "applicant",
                title: "申领企业",
                type: "text",
                search: "true",
                align: 'center',

            }, {
                field: "temp4",
                visible: false
            }, {
                field: "temp3",
                title: "统一社会信用代码",
                type: "text",
                align: 'center',
                search: "true"

            }, {
                field: "temp1",
                title: "商品种类",
                type: "text",
                align: 'center',
                search: "true"
            }, {
                field: "productnumber",
                title: "申领数量",
                type: "text",
                align: 'center',
                search: "true",
            },{
                field: "applicandate",
                title: "申领时间",
                type: "text",
                align: 'center',
                search: "true"
            }, {
                field: 'operate',
                title: '操作',
                align: 'center',
                //width : 100,
                formatter: operateFormatter
            }]]
    });
});
function operateFormatter(value, row, index) {
	var obj = JSON.stringify(row);
	//alert(row.auditor);
	if(row.auditor=="正常"){
		return "已通过";
	}else if(row.auditor=="未通过"){
		return "未通过";
	}else{
		 return ["<button class='btn-link' onclick='javascript:audit("+obj+");' style='margin-right:15px;'>审核</button>&nbsp;&nbsp;&nbsp;&nbsp;"].join('');
	}
   
};
function queryParams(params) {
    var param = {
        creditcode : $("#creditcode").val(),
        entname : $("#entname").val()
    }
    return param;
}
function entView(){
	var entId = $("input[name='entidAudit']").val();
	window.open("/ent/ententbasic/entInfoView?entId="+entId,'企业信息', 'height=460, width=800, top=150, left=281, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=n o, status=no');
}
function applicationHis(){
	var entId = $("input[name='entidAudit']").val();
	window.open("/views/wineLabels/alalcohollable/labelApplicationHis.jsp?entId="+entId,'申领历史', 'height=460, width=800, top=150, left=281, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=n o, status=no');
}
function audit(obj){
	$("input[name='entidAudit']").val(obj.temp4);
	$("input[name='entnameAudit']").val(obj.applicant);
	$("input[name='numberAudit']").val(obj.productnumber);
	$("input[name='creditcodeAudit']").val(obj.temp3);
	$("input[name='applicantDateAudit']").val(obj.applicandate);
	$("input[name='producttypeAudit']").val(obj.temp1);
	$("input[name='surplusNumberAudit']").val(obj.temp2);
	$("input[name='applicantId']").val(obj.id);
	$("#winelabelAudit").modal("show");
}