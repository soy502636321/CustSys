<jsp:directive.include file="/include/mainMenu.jsp" />
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
	</head>
	
	<body>
		<s:form action="publicSysCustAction" namespace="/sysCust">
			<br>
			<table>
				<tr>
					<td colspan="4">
						<s:submit value="查  询" onclick="return openSearchDialog(this, 'publicSysCustAction!search', 500, 300);" action="publicSysCustAction!query" />
					</td>
				</tr>
				<tr>
					<td colspan="4">
						${ actionMessages[0] }${actionErrors[0]}
					</td>
				</tr>
			</table>
			<br>
			<table style="width: 100%">
				<tr>
					<td></td>
				</tr>
				<tr>
					<td>
						<display:table name="list" class="simple"
							requestURI="publicSysCustAction!query">
							<display:column property="id"
								decorator="soy.common.displaytag.CheckBoxDecorator"
								style="width:3%;"
								title="<input type=checkbox class=checkbox name=cbAll onclick=changeCheckBoxAll(this,\"cbId\")>">
							</display:column>
							<display:column property="id" title="客户编号"></display:column>
							<display:column property="name" title="客户名称"></display:column>
							<display:column property="address" title="详细地址"></display:column>
							<display:column property="postalCode" title="邮编"></display:column>
							<display:column property="baseIndustryName" title="所属行业"></display:column>
							<display:column property="baseTypeName" title="客户类型"></display:column>
							<display:column property="baseSourceName" title="客户来源"></display:column>
							<display:column property="baseStateName" title="客户状态"></display:column>
							<display:column property="privateUserUsername" title="开发人"></display:column>
							<display:column property="website" title="公司主页"></display:column>
							<display:column property="remark" title="备注"></display:column>
						</display:table>
					</td>
				</tr>
			</table>
			
			<hq:buttons function="9024">
				<hq:button name="添加客户" mode="all"></hq:button>
				<hq:button name="修改客户" mode="single"></hq:button>
				<hq:button name="联系方式" mode="single"></hq:button>
				<hq:button name="维护记录" mode="single"></hq:button>
				<hq:button name="获取到我的客户" mode="more" location="this"></hq:button>
			</hq:buttons>
		</s:form>
	</body>
</html>