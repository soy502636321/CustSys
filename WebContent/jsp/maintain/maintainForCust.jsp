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
		<s:form namespace="/sysMaintain" method="post">
			<s:hidden name="sysMaintainVO.id"></s:hidden>
			<s:hidden name="sysCustVO.id"></s:hidden>
			<br>
			<table align="center" class="tableBorder"
				style="margin: auto; width: 600px;">
				<tr class="forumRowHighlight"
					style="background-color: #3c7fb5; color: #ffffff;">
					<td colspan="4">
						<s:if test="edit">
							客户维护修改:维护编号(<s:property value="sysMaintainVO.id" />)
						</s:if>
						<s:else>
							客户维护增加
						</s:else>
						<s:actionerror cssStyle="color:red;" />
						<s:actionmessage cssStyle="color:#ffffff;" />
					</td>
				</tr>
				<tr>
					<td>
						客户编号:
					</td>
					<td>
						<s:textfield name="sysMaintainVO.sysCustId" disabled="true" data="客户编号" />
						<s:hidden name="sysMaintainVO.sysCustId" />
					</td>
					<td>
						维护时间:
					</td>
					<td>
						<s:textfield name="sysMaintainVO.maintainTime" data="维护时间" cssClass="calendar" />
					</td>
				</tr>

				<tr>
					<td>
						联系人名称:*
					</td>
					<td>
						<s:textfield name="sysMaintainVO.name" data="联系人名称"></s:textfield>
					</td>
					<td>
						维护类型:
					</td>
					<td>
						<s:select list="baseMaintaintypeVOs" listKey="id"
							listValue="maintaintypeName"
							name="sysMaintainVO.baseMaintaintypeId">
						</s:select>
					</td>
				</tr>
				<tr>
					<td>
						活动描述:
					</td>
					<td colspan="3">
						<s:textarea rows="6" name="sysMaintainVO.activeDesc"></s:textarea>
					</td>
				</tr>
				<tr>
					<td>
						维护结果:
					</td>
					<td colspan="3">
						<s:textarea rows="6" name="sysMaintainVO.result"></s:textarea>
					</td>
				</tr>
				<tr>
					<td>
						备注:
					</td>
					<td colspan="3">
						<s:textarea rows="6" name="sysMaintainVO.remark"></s:textarea>
					</td>
				</tr>

				<tr>
					<td class="tdCenter" colspan="4">
						<table width="100%">
							<tr>
								<td>
									<div align="center">
										<s:if test="edit">
											<s:submit value="修  改" action="sysMaintainForCustAction!update"
												onclick="return submitCheck(this);"></s:submit>
										</s:if>
										<s:else>
											<s:submit value="增  加" action="sysMaintainForCustAction!save"
												onclick="return submitCheck(this);"></s:submit>
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
	<script type="text/javascript">
	$(function() {
		//维护时间组件
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