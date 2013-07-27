<jsp:directive.include file="/include/mainMenu.jsp" />
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<title>客户编号(<s:property value="sysCustVO.id" />)的联系方式</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
</head>

<body>
	<s:form namespace="/sysCust" method="post">
		<s:hidden name="sysCustVO.id"></s:hidden>
		<br>
		<table align="center" class="tableBorder"
			style="margin: auto; width: 900px;">
			<tr class="forumRowHighlight"
				style="background-color: #3c7fb5; color: #ffffff;">
				<td>客户编号( <s:property value="sysCustVO.id" /> )的联系方式 <s:actionerror
						cssStyle="color:red;" /> <s:actionmessage
						cssStyle="color:#ffffff;" /></td>
			</tr>
			<tr>
				<td>
					<table>
						<tr>
							<td>编号:</td>
							<td><s:textfield name="sysContactVO.id" /></td>
							<td>联系人:</td>
							<td><s:textfield name="sysContactVO.name" /></td>
							<td>职务:</td>
							<td><s:textfield name="sysContactVO.position" /></td>
							<td>性别:</td>
							<td><s:select list="genders" listKey="key" listValue="value"
									name="sysContactVO.genderId" /></td>
							<td>手机号码:</td>
							<td><s:textfield name="sysContactVO.mobile" /></td>
						</tr>
						<tr>

							<td>办公室号码:</td>
							<td><s:textfield name="sysContactVO.office" /></td>
							<td>家庭号码:</td>
							<td><s:textfield name="sysContactVO.familty" /></td>
							<td>QQ:</td>
							<td><s:textfield name="sysContactVO.qq" /></td>
							<td>MSN:</td>
							<td><s:textfield name="sysContactVO.msn" /></td>
							<td>传真:</td>
							<td><s:textfield name="sysContactVO.fax" /></td>
						</tr>
						<tr>

							<td>电子邮箱:</td>
							<td><s:textfield name="sysContactVO.email" /></td>
							<td>家庭地址:</td>
							<td><s:textfield name="sysContactVO.address" /></td>
							<td>兴趣爱好:</td>
							<td colspan="2"><s:textarea name="sysContactVO.interests" />
							</td>
							<td>备注:</td>
							<td colspan="3"><s:textarea name="sysContactVO.remark" /></td>
						</tr>
					</table></td>
			</tr>
			<tr>
				<td class="tdCenter" colspan="2">
					<div align="center">
						<hq:buttons function="61">
							<hq:button name="添加联系"></hq:button>
							<hq:button name="修改联系" mode="single"></hq:button>
							<hq:button name="查  询"></hq:button>
							<hq:button type="reset"></hq:button>
							<hq:button mode="close"></hq:button>
						</hq:buttons>
					</div></td>
			</tr>
			<tr>
				<td><display:table name="list" class="simple"
						requestURI="sysContactAction!query">
						<display:column property="id"
							decorator="soy.common.displaytag.CheckBoxDecorator"
							style="width:3%;"
							title="<input type=checkbox class=checkbox name=cbAll onclick=changeCheckBoxAll(this,\"cbId\")>">
											</display:column>
						<display:column property="id" title="编号"></display:column>
						<display:column property="name" title="联系人"></display:column>
						<display:column property="position" title="职务"></display:column>
						<display:column property="gender" title="性别"></display:column>
						<display:column property="mobile" title="手机号码"></display:column>
						<display:column property="office" title="办公室号码"></display:column>
						<display:column property="familty" title="家庭号码"></display:column>
						<display:column property="qq" title="QQ"></display:column>
						<display:column property="msn" title="MSN"></display:column>
						<display:column property="address" title="家庭地址"></display:column>
						<display:column property="fax" title="传真"></display:column>
						<display:column property="email" title="电子邮箱"></display:column>
						<display:column property="interests" title="兴趣爱好"></display:column>
						<display:column property="remark" title="备注"></display:column>
					</display:table></td>
			</tr>
		</table>
	</s:form>
</body>
</html>