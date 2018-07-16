/**
 * ent-ententbasic
 */
$(function () {
    $("#entbasicTable").bootstrapTable({
    	idField: "id",
        pagination: true,
	    sidePagination: 'client',
	    pageNumber: 1,
	    pageSize: 5,
        url: "/ent/ententbasic/list",
        queryParams:queryParams,
	    pageList: [5, 10, 20],
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
                field: "creditcode",
                title: "统一社会信用代码",
                type: "text",
                align: 'center',
                search: "true"

            }, {
                field: "entname",
                title: "企业名称",
                type: "text",
                align: 'center',
                search: "true",


            }, {
                field: "temp2",
                title: "企业状态",
                type: "text",
                align: 'center',
                search: "true",
            }, {
                field: 'operate',
                title: '操作',
                align: 'center',
                width : 100,
                //events: operateEvents,
                formatter: operateFormatter1
            }]]
    });

});

function operateFormatter1(value, row, index) {
	var obj = JSON.stringify(row);
    return ["<a onclick='javascript:view("+obj+");' style='margin-right:15px;'>查看</a>"].join('');

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
function clearInput(){
	document.getElementById("queryForm").reset();	
}
function view(obj){
	console.log(obj)
	if(obj.producepermissionurl!=null){
		
		$("#producepermissionurlDiv").html('<img name="producepermissionurl" src="'+''+obj.producepermissionurl+'" height="55%" width="100%"/>');
	}
	if(obj.importpermissionurl!=null){
		
		$("#importpermissionurlDiv").html('<img name="producepermissionurl" src="'+''+obj.importpermissionurl+'" height="55%" width="100%"/>');
	}
	if(obj.sellpermissionurl!=null){
		
		$("#sellpermissionurlDiv").html('<img name="sellpermissionurl" src="'+''+obj.sellpermissionurl+'" height="55%" width="100%"/>');
	}
	if(obj.businesspermissionurl!=null){
		
		$("#businesspermissionurlDiv").html('<img name="businesspermissionurl" src="'+''+obj.businesspermissionurl+'" height="55%" width="100%"/>');
	}
	if(obj.licenseattach!=null){
		$("#licenseattachDiv").html('<img name="licenseattach" src="'+''+obj.licenseattach+'" height="150%" width="85%"/>');
	}
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
function editStatus(obj){
	if(obj.producepermissionurl!=null){
		
		$("#producepermissionurlDiv1").html('<img name="producepermissionurl" src="'+accPath+"/"+obj.producepermissionurl+'" height="55%" width="100%"/>');
	}
	if(obj.importpermissionurl!=null){
		
		$("#importpermissionurlDiv1").html('<img name="producepermissionurl" src="'+accPath+"/"+obj.importpermissionurl+'" height="55%" width="100%"/>');
	}
	if(obj.sellpermissionurl!=null){
		
		$("#sellpermissionurlDiv1").html('<img name="sellpermissionurl" src="'+accPath+"/"+obj.sellpermissionurl+'" height="55%" width="100%"/>');
	}
	if(obj.businesspermissionurl!=null){
		
		$("#businesspermissionurlDiv1").html('<img name="businesspermissionurl" src="'+accPath+"/"+obj.businesspermissionurl+'" height="55%" width="100%"/>');
	}
	if(obj.licenseattach!=null){
		$("#licenseattachDiv1").html('<img name="licenseattach" src="'+accPath+"/"+obj.licenseattach+'" height="150%" width="85%"/>');
	}
	$("[name='creditcode1']").val(obj.creditcode);
	$("[name='entname1']").val(obj.entname);
	$("[name='address']").val(obj.address);
	$("[name='tel']").val(obj.tel);
	$("[name='bank']").val(obj.bank);
	$("[name='acct']").val(obj.acct);  
	$("#editEntId").val(obj.id);
	$("#editStatus").modal("show");
}