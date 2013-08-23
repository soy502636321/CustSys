function changeCheckBoxAll(obj, keys) {
	nodes = document.getElementsByName(keys);
	for (var i = 0; i < nodes.length; i++) {
		nodes[i].checked = obj.checked;
	}
}
function changeCheckBoxStatus(objCb, bStatus) {
	if (objCb == null)
		return;
	if (objCb.length != null) {
		for (var i = 0; i < objCb.length; i++) {
			objCb[i].checked = bStatus;
		}
	} else {
		objCb.checked = bStatus;
	}
}
function changeCheckBox(objCbChild, objCbParent) {
	if (objCbChild.length != null) {
		for (var i = 0; i < objCbChild.length; i++) {
			if (!objCbChild[i].checked) {
				objCbParent.checked = false;
				return;
			}
		}
		objCbParent.checked = true;
	} else {
		objCbParent.checked = objCbChild.checked;
	}

}
function getCbValue(objCb, nStatus) {
	// nStatus, -1 means unchecked, 0 means all, 1 means checked
	if (objCb == null)
		return "";
	var strVal = "";
	if (objCb.length != null) {
		switch (nStatus) {
			case -1 :
				for (var i = 0; i < objCb.length; i++) {
					if (!objCb[i].checked) {
						strVal += objCb[i].value + ",";
					}
				}
				break;

			case 0 :
				for (var i = 0; i < objCb.length; i++) {
					strVal += objCb[i].value + ",";
				}
				break;

			case 1 :
				for (var i = 0; i < objCb.length; i++) {
					if (objCb[i].checked) {
						strVal += objCb[i].value + ",";
					}
				}
				break;

			default :
				for (var i = 0; i < objCb.length; i++) {
					if (objCb[i].checked) {
						strVal += objCb[i].value + ",";
					}
				}
				break;
		}
		if (strVal.length > 0)
			strVal = strVal.substr(0, strVal.length - 1);
	} else {
		switch (nStatus) {
			case -1 :
				if (!objCb.checked)
					strVal = objCb.value;
				break;
			case 0 :
				strVal = objCb.value;
				break;
			case 1 :
				if (objCb.checked)
					strVal = objCb.value;
				break;
			default :
				if (objCb.checked)
					strVal = objCb.value;
				break;
		}
	}
	// alert(strVal);
	return strVal;
}
function addOption(objSel, strValue, strText) {
	var objOption = document.createElement("OPTION");
	objOption.text = strText;
	objOption.value = strValue;
	objSel.add(objOption);
}
function removeOption(objSel, strVal) {
	for (var i = 0; i < objSel.length; i++) {
		if (objSel.item(i).value == strVal) {
			objSel.remove(i);
		}
	}
}

// 得到默认选中的值
function getDefaultCheckValue() {
	return getCheckValue("cbId");
}

// 得到选中的值
function getCheckValue(checkboxName) {
	var strVal = "";
	var objCb = document.all(checkboxName);
	if (objCb == null)
		return "";
	if (objCb.length != null) {
		for (var i = 0; i < objCb.length; i++) {
			if (objCb[i].checked) {
				strVal += objCb[i].value + ",";
			}
		}
		if (strVal.length > 0) {
			strVal = strVal.substring(0, strVal.length - 1);
		}
	}
	return strVal;

}

// 默认单选框
function singleSelect() {
	return singleSelectCheckBox("cbId");
}

// 默认至少选择一个
function moreSelect() {
	return moreSelectCheckBox("cbId");
}

// 判断复选框只能单选
function singleSelectCheckBox(checkboxName) {
	if (!checkboxName || checkboxName.length == 0) {
		name = "cbId";
	}
	total = $('input:checked[name="' + checkboxName +'"]').length;
	if (total < 1) {
		alert("请选择一条记录!");
		return false;		
	} else if (total > 1) {
		alert("只能同时选择一条记录!");
		return false;		
	}
	return true;
}

// 必须至少选择一个复选框
function moreSelectCheckBox(checkboxName) {
	var strIds = getCbValue(document.all(checkboxName), 1);
	if (strIds == "") {
		alert("请至少选择一条记录!");
		return false;
	}
	return true;
}

/* 当回车事件触发时候要执行的操作，objName：表示要执行的操作 */
function onEnterPressKeyDown(eventE, objName) {
	if (eventE.keyCode == 13) {
		if (document.all(objName) != null) {
			document.all(objName).click();
		}
	}

}

/* 打开showModel窗口使用 */
function windowOpenShowModel(obj, width, height) {
	var dialogWidth = "dialogWidth:800px;";
	var dialogHeight = "dialogHeight:600px";
	if (width != undefined && width != "") {
		dialogWidth = "dialogWidth:" + width + "px;";
	}
	if (height != undefined && height != "") {
		dialogHeight = "dialogHeight:" + height + "px;";
	}
	return window.showModalDialog(
			"jsp/showModelCommonFrame.jsp?distinctUrlObject=" + obj, window,
			dialogWidth + dialogHeight);
}

// 检查表单
function submitCheck(o) {
	var form = $(o).parents('form:first');
	b = true;
	if (form) {
		$(form).find('input').each(function(i) {
					if ($(this).attr('data') && !$(this).val() && b) {
						alert($(this).attr('data') + '不能为空!');
						b = false;
						$(this).focus();
					}
				});
		if (b) {
			$(form).find('select').each(function(i) {
						if ($(this).attr('data') && !$(this).val() && b) {
							alert('请选择' + $(this).attr('data') + '!');
							b = false;
							$(this).focus();
						}
					})
		}
	}
	return b;
}

// 打开一个新的页面表单
function openBlank(o) {
	var form = $(o).parents('form:first');
	form.attr('target', '_blank');
}

function openThis(o) {
	var form = $(o).parents('form:first');
	form.attr('target', '');
	return true;
}

// 要选择一条记录跳转指定页面(当前页面中跳转)
function openSingle(o) {
	var form = $(o).parents('form:first');
	form.attr('target', '');
	if (singleSelect()) {
		return true;
	}
	return false;
}

// 要选一条记录打开新页面(新窗口)
function openBlankSingle(o) {
	if (singleSelect()) {
		var form = $(o).parents('form:first');
		form.attr('target', '_blank');
		return true;
	}
	return false;
}

// 至少要选一条记录才能跳转指定页面(当前页面中跳转)
function openMore(o) {
	var form = $(o).parents('form:first');
	form.attr('target', '');
	if (moreSelect()) {
		return true;
	}
	return false;
}

// 至少要选择一条记录打开新页面(新窗口)
function openBlankMore(o) {
	if (moreSelect()) {
		var form = $(o).parents('form:first');
		form.attr('target', '_blank');
		return true;
	}
	return false;
}

function openAllSelectWindow(o, t, url) {
	return false;
}

function deleteDialog(o) {
	var form = $(o).parents('form:first');
	form.attr('target', '');
	if (moreSelect()) {
		if (confirm("你确定删除所选择的记录?")) {
			return true;
		} else {
			return false;
		}
	}
	return false;
}

function closeWindow(o) {
	if (confirm('确定关闭当前窗口!')) {
		window.opener = null;
		// 取消询问弹窗
		window.open('', '_self');
		window.close();
	}
	return false;
}

//display tag checkbox 单选
function changeCheckBoxSingle(objCbChild, obj) {
	if($(obj).is(':checked')) {
		if (objCbChild.length != null) {
			for (var i = 0; i < objCbChild.length; i++) {
				if ($(objCbChild[i]).val() != $(obj).val()) {
					$(objCbChild[i]).attr('checked', false);
				}
			}
		}
	}
}

//根据组件名字判断是否是单选的
function jQuerySingleSelect(name) {
	if (!name || name.length == 0) {
		name = "cbId";
	}
	total = $('input:checked[name="' + name +'"]').length;
	if (total < 1) {
		alert("请选择一条记录!");
		return false;		
	} else if (total > 1) {
		alert("只能同时选择一条记录!");
		return false;		
	}
	return true;
}

function isNumber(o) {
	var pattern = new RegExp(/^\d+(\.\d+)?$/);
	var form = $(o).parents('form:first');
	b = true;
	if (form) {
		$(form).find('input').each(function(i) {
					if ($(this).val() && $(this).val.length > 0 && $(this).attr('num') && !pattern.test($(this).val())
							&& b) {
						alert($(this).attr('num') + '只能为数字!');
						b = false;
						$(this).focus();
					}
				});
	}
	return b;
}

function search(o) {
	var form = $(o).parents('form:first');
	form.attr('target', '');
}

function openSearchDialog(o, sUrl, sWeight, sHeight) {
	if (!sWeight) {
		sWeight = 500;
	}
	if (!sHeight) {
		sHeight = 500;
	}
	var returnValue = window.showModalDialog(sUrl, window, "dialogHeight:"
					+ sHeight + "px;dialogWidth:" + sWeight
					+ "px;center: yes; help: no;status: no");
	if (returnValue) {
		var form = $(o).parents('form:first');
		for (pro in returnValue) {
			if (returnValue[pro].value) {
				for (v in returnValue[pro].value) {
					form.append("<input type='hidden' name='" + pro + "' value='"
						+ returnValue[pro].value[v] + "' />");
				}
			} else {
				form.append("<input type='hidden' name='" + pro + "' value='"
						+ returnValue[pro] + "' />");
			}
		}
		form.attr('target', '');		
		return true;
	}
	return false;
}

function searchSubmit(o) {
	var map = new Object();
	// 文本输入框
	$('form').find('input:text').each(function(i) {
		if ($(this).val() && $(this).val().length > 0 && $(this).attr('name')
				&& $(this).attr('name').length > 0) {
			map[$(this).attr('name')] = $(this).val();
		}
	});
	// 单选下拉框
	$('form').find('select').each(function(i) {
		if ($(this).attr('name') && $(this).attr('name').length > 0 && $(this).val() && $(this).val().length > 0 && !$(this).prop('multiple')) {
			map[$(this).attr('name')] = $(this).val();
		}
	});
	// 多选下拉框
	$('form').find('select').each(function(i) {
		if ($(this).prop('multiple') && $(this).attr('name') && $(this).attr('name').length > 0 && $(this).val()) {
			map[$(this).attr('name')] = {
				value: $(this).val()
			}
		}
	});
	// 大文本输入框
	$('form').find('textarea').each(function(i) {
		if ($(this).attr('name') && $(this).attr('name').length > 0 && $(this).val() && $(this).val().length > 0) {
			map[$(this).attr('name')] = $(this).val();
		}
	});
	window.returnValue = map;
	closeThisWindow(o);
	return false;
}

function closeThisWindow(o) {
	window.opener = null;
	// 取消询问弹窗
	window.open('', '_self');
	window.close();
	return false;
}

(function($) {
	
	$.fn.extend({
		// 增加一个隐藏的值
		addHidden: function (name, value) {
			if ($(this).length > 0) {
				var hidden = "<input type='hidden' name='" + name + "' value='" + value + "' />";
				$(this).append(hidden);
			}
		},
		addHiddenMap: function(map) {
			if (map) {
				for (value in map) {
					var hidden = "<input type='hidden' name='" + value + "' value='" + map[value] + "' />";
					$(this).append(hidden);
				}
			}
		}
	});
	
	$.extend({
		// 在当前页面中打开一个字窗口，返回子窗口传值
		openSubWindow: function (src, height, width, w) {
			var sFeatures = "dialogHeight:" + height + "px;dialogWidth:" + width + "px;resizable:no;help:no;status:no;scroll:no;";
			var result = window.showModalDialog(src, w, sFeatures);
			return result;			
		},
		openTab: function(src) {
		},
		createSearchMap: function(obj, window) {
			var form = $(obj).parents('form:first');
			if (form && form.length > 0) {
				var map = new Object();
				// 文本框
				$(form).find('input:text').each(function(i) {
					if ($(this).attr('name') && $(this).attr('name').length > 0 && $(this).val() && $(this).val().length > 0) {
						map[$(this).attr('name')] = $(this).val();
					}
				});
				// 隐藏文本框
				$(form).find('input:hidden').each(function(i) {
					if ($(this).attr('name') && $(this).attr('name').length > 0 && $(this).val() && $(this).val().length > 0) {
						map[$(this).attr('name')] = $(this).val();
					}
				});
				// 单选下拉框
				$(form).find('select').each(function(b) {
					if (!$(this).prop('multiple') && $(this).attr('name') && $(this).attr('name').length > 0 && $(this).val() && $(this).val().length > 0) {
						map[$(this).attr('name')] = $(this).val();
					}
				}); 
				window.returnValue = map;
				closeWindow(obj);
			}
			return false;
		},
		openSysCustList: function(obj, config, w) {
			if (!config.multiple || config.multiple != true) {
				// 单选
				var src = window.basepath + '/sysCust/sysCustAction!findList?', height = 650, weight = 650;
				if (config.data) {
					// 增加查询洽谈人的参数
					for (value in config.data) {
						src += value + "=" + config.data[value] + "&";
					}
				}
				var returnValue = $.openSubWindow(src, height, weight, window);
				if (returnValue) {
					// 假如有了模型，将根据模型来处理，不再返回洽谈人对象
					if (config.model) {
						var form = $(obj).parents('form:first');
						for (value in config.model) {
							// 获得选择器，根据选择器去获得标签，如果存在该标签，则修改值为模型对应的值，如果没有，将用模型的的属性为名字，新建一个标签
							var selector = '[name="' + value + '"]';
							var key = config.model[value];
							var set = $(selector);
							if (set && set.length > 0) {
								$(set).attr('value', returnValue[key]);
							} else {
								$(form).addHidden(value, returnValue[key]);
							}
						}
					} else {
						// 单选返回的是一个洽谈人对象
						return returnValue;
					}
				}
			} else {
				// 多选
				var src = window.basepath + '/sysCust/sysCustAction!findList?', height = 650, weight = 650;
				if (config.data) {
					// 增加查询洽谈人的参数
					for (value in config.data) {
						src += value + "=" + config.data[value] + "&";
					}
				}
				var returnValue = $.openSubWindow(src, height, weight);
				// 多选返回的是一个洽谈人对象数组
				if (returnValue) {
					
				}
				return returnValue;
			}
		}
	});
}($));