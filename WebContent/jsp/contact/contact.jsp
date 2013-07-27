<jsp:directive.include file="/include/mainMenu.jsp" />
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
	<head>
		<title>增加联系方式</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
	</head>

	<body>
		<s:form namespace="/sysCust" method="post">
			<s:hidden name="sysCustVO.id"></s:hidden>
			<s:hidden name="sysContactVO.id"></s:hidden>
			<br>
			<table align="center" class="tableBorder"
				style="margin: auto; width: 600px;">
				<tr class="forumRowHighlight"
					style="background-color: #3c7fb5; color: #ffffff;">
					<td colspan="4">
						联系方式增加
						<s:actionerror cssStyle="color:red;" />
						<s:actionmessage cssStyle="color:#ffffff;" />
					</td>
				</tr>
				<tr>
					<td>
						联系人:
					</td>
					<td>
						<s:textfield data="联系人" name="sysContactVO.name" />
					</td>
					<td>
						职务:
					</td>
					<td>
						<s:textfield name="sysContactVO.position" />
					</td>
				</tr>
				<tr>
					<td>
						性别:
					</td>
					<td>
						<s:select list="genders" listKey="key" listValue="value" name="sysContactVO.genderId" />
					</td>
					<td>
						新浪微博:
					</td>
					<td>
						<s:textfield name="sysContactVO.weibo" />
					</td>
				</tr>
				<tr>
					<td>
						手机号码:
					</td>
					<td>
						<s:textfield data="手机号码" name="sysContactVO.mobile" />
					</td>
					<td>
						办公室号码:
					</td>
					<td>
						<s:textfield data="办公室号码" name="sysContactVO.office" />
					</td>
				</tr>
				<tr>
					<td>
						家庭号码:
					</td>
					<td>
						<s:textfield name="sysContactVO.familty"></s:textfield>
					</td>
					<td>
						传真:
					</td>
					<td>
						<s:textfield name="sysContactVO.fax"></s:textfield>
					</td>
				</tr>
				<tr>
					<td>
						腾讯QQ:
					</td>
					<td>
						<s:textfield name="sysContactVO.qq"></s:textfield>
					</td>
					<td>
						微软MSN:
					</td>
					<td>
						<s:textfield name="sysContactVO.msn"></s:textfield>
					</td>
				</tr>
				<tr>
					<td>
						家庭地址:
					</td>
					<td colspan="3">
						<s:textarea rows="6" name="sysContactVO.address"></s:textarea>
					</td>
				</tr>
				<tr>
					<td>
						兴趣爱好:
					</td>
					<td colspan="3">
						<s:textarea rows="6" name="sysContactVO.interests"></s:textarea>
					</td>
				</tr>
				<tr>
					<td>
						备注:
					</td>
					<td colspan="3">
						<s:textarea rows="6" name="sysContactVO.remark"></s:textarea>
					</td>
				</tr>

				<tr>
					<td class="tdCenter" colspan="4">
						<table width="100%">
							<tr>
								<td>
									<div align="center">
										<s:if test="edit">
											<s:submit value="修  改" action="sysContactAction!update"
												onclick="return submitCheck(this);" />
										</s:if>
										<s:else>
											<s:submit value="增  加" action="sysContactAction!save"
												onclick="return submitCheck(this);" />
										</s:else>
										&nbsp;&nbsp;
										<s:reset value="重  置"></s:reset>
										&nbsp;&nbsp;
										<s:submit value="关  闭" onclick="return closeWindow(this);"></s:submit>
									</div>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</html>