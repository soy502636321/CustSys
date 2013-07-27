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
		<s:form namespace="/system" method="post">
			<s:hidden name="sysUserVO.id"></s:hidden>
			<br>
			<table align="center" class="tableBorder" style="margin: auto;">
				<tr class="forumRowHighlight"
					style="background-color: #1960a2; color: #ffffff;">
					<td colspan="4">
						用户增加
						<s:actionerror cssStyle="color:red;" />
						<s:actionmessage cssStyle="color:blue;" />
					</td>
				</tr>
				<tr>
					<td>
						用户名:
					</td>
					<td>
						<s:if test="edit">
							<s:textfield name="sysUserVO.username" disabled="true"
								cssStyle="width:100%"></s:textfield>
						</s:if>
						<s:else>
							<s:textfield name="sysUserVO.username" cssStyle="width:100%"
								data="用户名"></s:textfield>
						</s:else>
					</td>
					<td>
						名字:
					</td>
					<td>
						<s:textfield name="sysUserVO.name" cssStyle="width:100%"></s:textfield>
					</td>
				</tr>

				<tr>
					<td>
						<s:if test="edit">
							新密码:
						</s:if>
						<s:else>
							密码:
						</s:else>
					</td>
					<td>
						<s:textfield name="sysUserVO.password" cssStyle="width:100%"
							data="密码"></s:textfield>
					</td>
					<td>
						<s:if test="edit">
							确认新密码:
						</s:if>
						<s:else>
							确认密码:
						</s:else>
					</td>
					<td>
						<s:textfield name="sysUserVO.repassword" cssStyle="width:100%"
							data="确认密码"></s:textfield>
					</td>
				</tr>
				<tr>
					<td>
						性别:
					</td>
					<td>
						<s:select list="genders" listKey="key" listValue="value"
							name="sysUserVO.gender" cssStyle="width:150px"></s:select>
					</td>
					<td>
						权限级别:
					</td>
					<td>
						<s:select list="sysRoles" listKey="id" listValue="roleName"
							data="权限级别" name="sysUserVO.sysRoleId" cssStyle="width:150px"></s:select>
					</td>
				</tr>
				<tr>
					<td>
						电话:
					</td>
					<td>
						<s:textfield name="sysUserVO.phoneTh1" cssStyle="width:100%"></s:textfield>
					</td>
					<td>
						邮箱地址:
					</td>
					<td>
						<s:textfield name="sysUserVO.emailTh1" cssStyle="width:100%"></s:textfield>
					</td>
				</tr>

				<tr>
					<td>
						备注:
					</td>
					<td colspan="3">
						<s:textarea name="sysUserVO.remark" rows="6"
							cssStyle="width: 100%"></s:textarea>
					</td>
				</tr>

				<tr>
					<td class="tdCenter" colspan="4">
						<s:if test="edit">
							<s:submit value="修  改" onclick="return save(this);"
								action="sysUserAction!edit"></s:submit>
						</s:if>
						<s:else>
							<s:submit value="增  加" onclick="return save(this);"
								action="sysUserAction!save"></s:submit>
						</s:else>
						&nbsp;&nbsp;
						<s:reset value="重  置"></s:reset>
						&nbsp;&nbsp;
						<s:submit value="返  回" action="sysUserAction!back"></s:submit>
					</td>
				</tr>
			</table>
		</s:form>
	</body>
	<script type="text/javascript">
		function save(o) {
			var username = $('input[name="sysUserVO.username"]').val();
			if (!username || username.length < 5) {
				alert('用户名不能少于5位字符!');
				$('input[name="sysUserVO.username"]').focus();
				return false;
			}
			var password = $('input[name="sysUserVO.password"]').val();
			if (!password || password.length < 5) {
				alert('密码不能少于5位字符!');
				$('input[name="sysUserVO.password"]').focus();
				return false;
			}
			var repassword = $('input[name="sysUserVO.repassword"]').val();
			if (!repassword || repassword.length < 5) {
				alert('两次密码不一致!');
				$('input[name="sysUserVO.repassword"]').focus();
				return false;
			}
			if (password != repassword) {
				alert('两次密码不一致!');
				$('input[name="sysUserVO.repassword"]').focus();
				return false;
			}

			var sysRoleId = $('select[name="sysUserVO.sysRoleId"]').val();
			if (!sysRoleId || sysRoleId.length <= 0) {
				alert('请选择权限级别!');
				$('select[name="sysUserVO.sysRoleId"]').focus();
				return false;
			}
			return true;
		}
	</script>
</html>