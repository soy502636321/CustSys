<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-tags.tld" prefix="s"%>
<html>
<head>
<title>客户管理系统</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-1.9.1.js"></script>
	<style type="text/css">
	body {
		background: #3c7fb5 url(<%=request.getContextPath()%>/images/bg_login.jpg
			) repeat-x left top;
		margin-left: 0px;
		margin-top: 0px;
		margin-right: 0px;
		margin-bottom: 0px;
	}
	
	body,table,td,div {
		font-size: 12px;
		line-height: 24px;
	}
	
	.textfile {
		background: url(<%=request.getContextPath()%>/images/bg_login_textfile.gif
			) no-repeat left top;
		padding: 0px 2px;
		height: 29px;
		width: 143px;
		border: 0;
	}
	</style>
</head>
<body>
	<table width="95" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td><img
				src="<%=request.getContextPath()%>/images/top_login.jpg"
				width="596" height="331" /></td>
		</tr>
		<tr>
			<td><table width="100%" border="0" cellspacing="0"
					cellpadding="0">
					<tr>
						<td width="99"><img
							src="<%=request.getContextPath()%>/images/login_06.jpg"
							width="99" height="139" />
						</td>
						<td
							background="<%=request.getContextPath()%>/images/bg_form.jpg"><table
								width="250" border="0" align="center" cellpadding="0"
								cellspacing="0">
								<s:form method="post" action="loginAction" namespace="/login">
									<tr>
										<td colspan="2">
											<s:actionerror cssStyle="color:red;" /><s:actionmessage cssStyle="color:blue;" />
										</td>
									</tr>
									<tr>
										<td height="35" align="right">用户名：</td>
										<td><label> <s:textfield name="username"
													class="textfile" /> </label></td>
									</tr>
									<tr>
										<td height="35" align="right">密&nbsp;&nbsp;码：</td>
										<td><label> <s:password name="password"
													class="textfile" /> </label>
										</td>
									</tr>
									<tr>
										<td height="35">&nbsp;</td>
										<td><label> <s:submit name="Submit" value="登录"
													action="loginAction!login"></s:submit> &nbsp;&nbsp; <s:reset
													name="Submit2" value="重置"></s:reset> </label>
										</td>
									</tr>
									<tr>
										<td height="30">&nbsp;</td>
										<td><label> <input type="checkbox"
												name="checkbox" value="checkbox" /> </label> 记住密码</td>
									</tr>
								</s:form>
							</table>
						</td>
						<td width="98" align="right"><img
							src="<%=request.getContextPath()%>/images/login_08.jpg"
							width="98" height="139" />
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td><img
				src="<%=request.getContextPath()%>/images/bottom_login.jpg"
				width="596" height="39" /></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td align="center"></td>
		</tr>
	</table>
</body>

<script type="text/javascript">
	function vaildateLogin() {
		//var userId=document.all("userId").value;
		var userId = $("#userId").val();
		var password = $("#password").val();
		var msg = "";
		if (userId == "") {
			msg += "用户名不能为空！\n";
		}
		if (password == "") {
			msg += "密码不能为空！";
		}
		if (msg.length > 0) {
			alert(msg);
			return false;
		}

		return true;
	}
</script>
</html>
