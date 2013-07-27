<jsp:directive.include file="/include/mainMenu.jsp" />
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
	<head>
		<title>订单编号(<s:property value="sysBusinessVO.businessNo" />)的生产记录</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
	</head>

	<body>
		<s:form action="sysRecordAction" namespace="/sysRecord" method="post">
			<s:hidden name="sysCustVO.id"></s:hidden>
			<br>
			<table align="center" class="tableBorder"
				style="margin: auto; width: 900px;">
				<tr class="forumRowHighlight"
					style="background-color: #3c7fb5; color: #ffffff;">
					<td>
						订单编号(<s:property value="sysBusinessVO.businessNo" />)的生产记录
						<s:actionerror cssStyle="color:red;" />
						<s:actionmessage cssStyle="color:#ffffff;" />
					</td>
				</tr>
				<tr>
					<td>
						<table>
							<tr>
								<td>
									编号:
								</td>
								<td>
									<s:textfield name="sysContactVO.id" />
								</td>
								<td>
									联系人:
								</td>
								<td>
									<s:textfield name="sysContactVO.name" />
								</td>
								<td>
									职务:
								</td>
								<td>
									<s:textfield name="sysContactVO.position" />
								</td>
								<td>
									性别:
								</td>
								<td>
									<s:select list="genders" listKey="key" listValue="value"
										name="sysContactVO.genderId" />
								</td>
								<td>
									手机号码:
								</td>
								<td>
									<s:textfield name="sysContactVO.mobile" />
								</td>
							</tr>
							<tr>

								<td>
									电子邮箱:
								</td>
								<td>
									<s:textfield name="sysContactVO.email" />
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td class="tdCenter" colspan="2">
						<div align="center">
							<hq:buttons function="81">
								<hq:button name="添加记录" mode="all"></hq:button>
								<hq:button name="修改记录" mode="single"></hq:button>
								<hq:button name="删除记录" mode="del"></hq:button>
								<hq:button name="查  询"></hq:button>
								<hq:button type="reset"></hq:button>
								<hq:button mode="close"></hq:button>
							</hq:buttons>
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<display:table name="list" class="simple"
							requestURI="sysContactAction!query">
							<display:column property="id"
								decorator="soy.common.displaytag.CheckBoxDecorator"
								style="width:3%;"
								title="<input type=checkbox class=checkbox name=cbAll onclick=changeCheckBoxAll(this,\"cbId\")>">
							</display:column>
							<display:column property="id" title="编号"></display:column>
							<display:column property="name" title="姓名"></display:column>
							<display:column property="position" title="生产类型"></display:column>
							<display:column property="gender" title="数量"></display:column>
							<display:column property="mobile" title="金额"></display:column>
							<display:column property="office" title="扣款"></display:column>
						</display:table>
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</html>