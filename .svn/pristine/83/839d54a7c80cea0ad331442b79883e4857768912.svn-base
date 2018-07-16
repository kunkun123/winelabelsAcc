/**
 * ent-ententbasic
 */
$(function () {
    $("#entbasicTable").bootstrapTable({
        //toolbar: "#toolbar",
        idField: "id",
        pagination: true,
        queryParams:queryParams,
        sidePagination: "client",
        pageNumber: 1,
        pageSize: 5,
        pageList: [5, 10, 20],
        url: "/ent/ententbasic/auditlist",
        columns: [
            
            [{
                field: "id",
                visible: false
            }, {
                field: "creditcode",
                title: "统一社会信用代码",
                type: "text",
                search: "true",
                align: 'center',
            }, {
                field: "entname",
                title: "企业名称",
                type: "text",
                search: "true",
                align: 'center',

            }, {
                field: "temp2",
                title: "审核状态",
                type: "text",
                search: "true",
                align: 'center',

            }, {
                field: 'operate',
                title: '操作',
                align: 'center',
                //width : 100,
                //events: operateEvents,
                formatter: operateFormatter
            }]]

    });

});

function operateFormatter(value, row, index) {
	var obj = JSON.stringify(row);
    return [
        "<button onclick='javascript:view("+obj+");' type='button' class='btn btn-link' style='margin-right:15px;'>查看</button>"+
        "<button onclick='javascript:auditing("+obj+");' type='button' class='btn btn-link' style='margin-right:15px;'>审核</button>&nbsp;&nbsp;"
    ];


};

function query(){
    $('#entbasicTable').bootstrapTable('refresh');
}

function queryParams(params) {
    var param = {
        creditcode : $("#creditcode").val(),
        entname : $("#entname").val()
    }
    return param;
}
function auditing(obj){
	if(obj.producepermissionurl!=null){
		$("#producepermissionurlDiv1").html('<img name="producepermissionurl" src="'+obj.producepermissionurl+'" height="55%" width="100%"/>');
	}
	if(obj.importpermissionurl!=null){
		$("#importpermissionurlDiv1").html('<img name="producepermissionurl" src="'+obj.importpermissionurl+'" height="55%" width="100%"/>');
	}
	if(obj.sellpermissionurl!=null){
		$("#sellpermissionurlDiv1").html('<img name="sellpermissionurl" src="'+obj.sellpermissionurl+'" height="55%" width="100%"/>');
	}
	if(obj.businesspermissionurl!=null){
		$("#businesspermissionurlDiv1").html('<img name="businesspermissionurl" src="'+obj.businesspermissionurl+'" height="55%" width="100%"/>');
	}
	if(obj.licenseattach!=null){
		$("#licenseattachDiv1").html('<img name="licenseattach" src="'+obj.licenseattach+'" height="150%" width="85%"/>');
	}
	$("[name='creditcode1']").val(obj.creditcode);
	$("[name='entname1']").val(obj.entname);
	$("[name='address']").val(obj.address);
	$("[name='tel']").val(obj.tel);
	$("[name='bank']").val(obj.bank);
	$("[name='acct']").val(obj.acct);  
	$("#editEntId").val(obj.id);
	$("#editAuditModel").modal("show");
}
function view(obj){
	console.log(obj);
	if(obj.producepermissionurl!=null){
		$("#producepermissionurlDiv").html('<img name="producepermissionurl" src="'+obj.producepermissionurl+'" height="55%" width="100%"/>');
	}
	if(obj.importpermissionurl!=null){
		$("#importpermissionurlDiv").html('<img name="producepermissionurl" src="'+obj.importpermissionurl+'" height="55%" width="100%"/>');
	}
	if(obj.sellpermissionurl!=null){
		$("#sellpermissionurlDiv").html('<img name="sellpermissionurl" src="'+obj.sellpermissionurl+'" height="55%" width="100%"/>');
	}
	if(obj.businesspermissionurl!=null){
		$("#businesspermissionurlDiv").html('<img name="businesspermissionurl" src="'+obj.businesspermissionurl+'" height="55%" width="100%"/>');
	}
	if(obj.licenseattach!=null){
		$("#licenseattachDiv").html('<img name="licenseattach" src="'+obj.licenseattach+'" height="150%" width="85%"/>');
	}
	//$("[name='licenseattach']").attr("src",accPath+"/"+obj.licenseattach);
	$("[name='creditcode1']").val(obj.creditcode);
	$("[name='entname1']").val(obj.entname);
	$("[name='address']").val(obj.address);
	$("[name='tel']").val(obj.tel);
	$("[name='bank']").val(obj.bank);
	$("[name='acct']").val(obj.acct);   
	$("[name='contacts']").val(obj.contacts);
	$("[name='contactphone']").val(obj.contactphone);
	$("[name='email']").val(obj.email);
//	$("#creditcode").html(obj.creditcode);
	$("#myDetailModal").modal("show");
}
function clearInput(){
	document.getElementById("queryForm").reset();	
}