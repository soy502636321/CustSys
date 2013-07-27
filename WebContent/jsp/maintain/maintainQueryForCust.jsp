<jsp:directive.include file="/include/mainMenu.jsp" />
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
	<head>
		<title>客户编号(<s:property value="sysCustVO.id" />)的维护记录</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
	</head>

	<body>
		<s:form namespace="/sysMaintain" method="post"
			action="sysMaintainForCustAction">
			<s:hidden name="sysCustVO.id"></s:hidden>
			<br>
			<table align="center" class="tableBorder"
				style="margin: auto; min-width:  1000px;">
				<tr class="forumRowHighlight"
					style="background-color: #3c7fb5; color: #ffffff;">
					<td colspan="4">
						客户编号(
						<s:property value="sysCustVO.id" />
						)的联系方式
						<s:actionerror cssStyle="color:red;" />
						<s:actionmessage cssStyle="color:#ffffff;" />
					</td>
				</tr>
				<tr>
					<td>
						<table>
							<tr>
								<td>
									维护编号
								</td>
								<td>
									<s:textfield name="sysMaintainVO.id" />
								</td>
								<td>
									开始维护时间:
								</td>
								<td>
									<s:textfield cssClass="calendar"
										name="sysMaintainVO.maintainTimeStart" />
								</td>
								<td>
									结束维护时间:
								</td>
								<td>
									<s:textfield cssClass="calendar"
										name="sysMaintainVO.maintainTimeEnd" />
								</td>
								<td>
									联系人名称
								</td>
								<td>
									<s:textfield name="sysMaintainVO.name" />
								</td>
							</tr>
							<tr>
								<td>
									维护类型
								</td>
								<td>
									<s:select list="baseMaintaintypeVOs" listKey="id"
										listValue="maintaintypeName"
										name="sysMaintainVO.baseMaintaintypeId" />
								</td>
								<td>
									活动描述
								</td>
								<td>
									<s:textarea name="sysMaintainVO.activeDesc" />
								</td>
								<td>
									维护结果
								</td>
								<td>
									<s:textarea name="sysMaintainVO.result" />
								</td>
								<td>
									备注
								</td>
								<td>
									<s:textarea name="sysMaintainVO.remark" />
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<div align="center">
							<hq:buttons function="62">
								<hq:button name="添加维护" mode="all"></hq:button>
								<hq:button name="修改维护" mode="single"></hq:button>
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
							requestURI="sysMaintainForCustAction!query">
							<display:column property="id"
								decorator="soy.common.displaytag.CheckBoxDecorator"
								style="width:3%;"
								title="<input type=checkbox class=checkbox name=cbAll onclick=changeCheckBoxAll(this,\"cbId\")>">
								</display:column>
							<display:column property="id" title="维护编号"></display:column>
							<display:column property="sysCustId" title="客户编号"></display:column>
							<display:column property="maintainTime" title="维护时间"
								format="{0,date,yyyy-MM-dd HH:mm}" sortable="true"></display:column>
							<display:column property="name" title="联系人名称"></display:column>
							<display:column property="baseMaintaintype.maintaintypeName"
								title="维护类型"></display:column>
							<display:column property="activeDesc" title="活动描述"></display:column>
							<display:column property="result" title="维护结果"></display:column>
							<display:column property="remark" title="备注"></display:column>
						</display:table>
					</td>
				</tr>
			</table>
		</s:form>
	</body>
	<script type="text/javascript">
	$(function() {
		$('.calendar').each(
				function() {
					$(this).attr("id", ++$.datepicker.uuid).removeClass(
							"hasDatepicker").datetimepicker({
						numberOfMonths : 1,
						showButtonPanel : false,
						changeYear : true,
						changeMonth : true,
						dateFormat : 'yy-mm-dd'
					});
				});
	});
	</script>
</html>