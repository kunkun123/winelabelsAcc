 <%@include file="../../include/ent_include.jsp"%><!--静态包含--> 
<html>
  <head>
  
    
    <title>查看企业信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style="background-color:white">
  
            	<form role="form" class="form-horizontal" style="width:60%;height:60%" id="enttypeFormDetail">
            		<div class="form-group">
						    <label for="firstname" class="col-sm-4 control-label">统一社会信用代码</label>
						    <div class="col-sm-6">
						      <input type="text" class="form-control" name="creditcode1" value="${entBasic.creditcode}" readonly/>
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="firstname" class="col-sm-4 control-label">企业名称</label>
						    <div class="col-sm-6">
						      <input type="text" class="form-control" name="entname1" value="${entBasic.entname}" readonly/>
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="firstname" class="col-sm-4 control-label">地址</label>
						    <div class="col-sm-6">
						      <input type="text" class="form-control" name="address" value="${entBasic.address}" readonly/>
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="firstname" class="col-sm-4 control-label">电话</label>
						    <div class="col-sm-6">
						      <input type="text" class="form-control" name="tel"  value="${entBasic.tel}" readonly/>
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="firstname" class="col-sm-4 control-label">开户银行</label>
						    <div class="col-sm-6">
						      <input type="text" class="form-control" name="bank" value="${entBasic.bank}" readonly/>
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="firstname" class="col-sm-4 control-label">银行账号</label>
						    <div class="col-sm-6">
						      <input type="text" class="form-control" name="acct"  value="${entBasic.acct}" readonly/>
						    </div>
						  </div>
	                </form>
	               
	               
					<form role="form" class="form-inline"style="margin-top:3%;margin-left:3%;width:80%;height:10%" id="enttypeFormDetail">
						&emsp;联系方式：<br>
						<div class="form-group">
							<br>
							<label for="f1">&emsp;联系人：</label> <input style="border: 0px;outline:none;width:23%" type="text" name="contacts"
								class="form-control" value="${entBasic.contacts}" readonly/>
						
							<label for="f2">联系电话：</label> <input style="border: 0px;outline:none;width:20%" type="text" name="contactphone"
								class="form-control" value="${entBasic.contactphone}" readonly/>
						
							<label for="f3" >电子邮箱：</label> <input style="border: 0px;outline:none;width:20%" type="text" name="email"
								class="form-control" value="${entBasic.email}" readonly/>
						</div>
					</form>
		
  </body>
</html>