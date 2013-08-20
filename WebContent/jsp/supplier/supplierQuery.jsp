<jsp:directive.include file="/include/mainMenu.jsp" />
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
	<head>
		<title></title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
	</head>
	
	<body>
		<s:form action="sysSupplierAction" namespace="/sysSupplier">
			<br>
			<table>
				<tr>
					<td colspan="4">
						<s:submit value="查  询" onclick="return openSearchDialog(this, 'sysSupplierAction!search', 500, 400);" action="sysSupplierAction!query" />
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
							requestURI="sysSupplierAction!query">
							<display:column property="id"
								decorator="soy.common.displaytag.CheckBoxDecorator"
								style="width:3%;"
								title="<input type=checkbox class=checkbox name=cbAll onclick=changeCheckBoxAll(this,\"cbId\")>">
							</display:column>
							<display:column property="id" title="供应商编号"></display:column>
							<display:column property="name" title="姓名"></display:column>
							<display:column property="gender" title="性别"></display:column>
							<display:column property="phoneTh1" title="联系电话"></display:column>
							<display:column property="qq" title="QQ"></display:column>
							<display:column property="email" title="邮箱"></display:column>
		
							<display:column property="mainTh1.mainName" title="主营一"></display:column>
							<display:column property="mainTh2.mainName" title="主营二"></display:column>
							<display:column property="mainTh3.mainName" title="主营三"></display:column>
							<display:column property="price" title="成交价格"></display:column>
							<display:column property="other" title="其他"></display:column>
							<display:column property="remark" title="备注"></display:column>
						</display:table>
					</td>
				</tr>
			</table>
			<hq:buttons function="85">
				<hq:button name="添加供应商" mode="all"></hq:button>
				<hq:button name="修改供应商" mode="single"></hq:button>
				<hq:button name="显示供应商" mode="single"></hq:button>
				<hq:button name="删除供应商" mode="del"></hq:button>
			</hq:buttons>
		</s:form>
	</body>
	<script type="text/javascript">
		$(function() {
			$(function() {
				$(".chosen").chosen();
			});
		})
	</script>
</html>