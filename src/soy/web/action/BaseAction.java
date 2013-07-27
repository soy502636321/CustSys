package soy.web.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.Option;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import soy.basic.database.entity.BaseMain;
import soy.basic.database.entity.BasePayment;
import soy.basic.database.entity.BaseSource;
import soy.basic.database.entity.SysRole;
import soy.basic.vo.BaseClassVO;
import soy.basic.vo.BaseDeliveryVO;
import soy.basic.vo.BaseIndustryVO;
import soy.basic.vo.BaseMaintaintypeVO;
import soy.basic.vo.BasePaymentVO;
import soy.basic.vo.BaseQualityVO;
import soy.basic.vo.BaseSourceVO;
import soy.basic.vo.BaseStateVO;
import soy.basic.vo.BaseTypeVO;
import soy.util.ConfigUtil;
import soy.util.OptionVO;
import soy.util.StringUtil;
import soy.util.SystemUtil;
import soy.web.service.BaseClassService;
import soy.web.service.BaseDeliveryService;
import soy.web.service.BaseIndustryService;
import soy.web.service.BaseMainService;
import soy.web.service.BaseMaintaintypeService;
import soy.web.service.BasePaymentService;
import soy.web.service.BaseQualityService;
import soy.web.service.BaseSourceService;
import soy.web.service.BaseStateService;
import soy.web.service.BaseTypeService;
import soy.web.service.SysCustService;
import soy.web.service.SysMaintainService;
import soy.web.service.SysRoleService;
import soy.web.service.SysUserService;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements SessionAware,
		ServletRequestAware, ServletResponseAware {

	private Map<String, Object> session;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private static List<OptionVO> genders;
	private static List<OptionVO> yesOrNo;
	private static List<OptionVO> userStates;
	private List<SysRole> sysRoles;
	private SysRoleService sysRoleService;

	private List<BaseMaintaintypeVO> baseMaintaintypeVOs; // 维护类型/
	private BaseMaintaintypeService baseMaintaintypeService;

	private List<BaseIndustryVO> baseIndustryVOs; // 客户行业/
	private BaseIndustryService baseIndustryService;

	private List<BaseTypeVO> baseTypeVOs; // 客户类型/
	private BaseTypeService baseTypeService;

	private List<BaseSourceVO> baseSourceVOs; // 客户来源/
	private BaseSourceService baseSourceService;

	private List<BaseStateVO> baseStateVOs; // 客户状态/
	private BaseStateService baseStateService;

	private String allSysCustIdOfString;
	private SysCustService sysCustService;

	private List<BaseQualityVO> baseQualityVOs; // 订单品质/
	private BaseQualityService baseQualityService;

	private List<BaseClassVO> baseClassVOs; // 订单种类/
	private BaseClassService baseClassService;

	private List<BaseDeliveryVO> baseDeliveryVOs; // 交付方式/
	private BaseDeliveryService baseDeliveryService;

	private List<BasePaymentVO> basePaymentVOs; // 支付方式/
	private BasePaymentService basePaymentService;

	private List<BaseMain> baseMains; // 供应商主营
	private BaseMainService baseMainService;

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public boolean isNull(String obj) {
		if (obj == null || obj.equals("")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isNotNull(String obj) {
		return !isNull(obj);
	}

	public List<OptionVO> getGenders() {
		if (SystemUtil.isNull(genders)) {
			genders = new ArrayList<OptionVO>();
			genders.add(new OptionVO("", "——请选择——", null));
			genders.addAll(ConfigUtil.getConfigUtil().findById("0001"));
		}
		return genders;
	}

	public void setGenders(List<OptionVO> genders) {
		this.genders = genders;
	}

	public List<OptionVO> getYesOrNo() {
		if (SystemUtil.isNull(yesOrNo)) {
			yesOrNo = new ArrayList<OptionVO>();
			yesOrNo.add(new OptionVO("", "——请选择——", null));
			yesOrNo.addAll(ConfigUtil.getConfigUtil().findById("0002"));
		}
		return yesOrNo;
	}

	public void setYesOrNo(List<OptionVO> yesOrNo) {
		this.yesOrNo = yesOrNo;
	}

	public List<OptionVO> getUserStates() {
		if (SystemUtil.isNull(userStates)) {
			userStates = new ArrayList<OptionVO>();
			userStates.add(new OptionVO("", "——请选择——", null));
			userStates.addAll(ConfigUtil.getConfigUtil().findById("0003"));
		}
		return userStates;
	}

	public void setUserStates(List<OptionVO> userStates) {
		this.userStates = userStates;
	}

	public List<SysRole> getSysRoles() {
		if (SystemUtil.isNull(sysRoles)) {
			sysRoles = new ArrayList<SysRole>();
			sysRoles.add(new SysRole("——请选择——", null, null, null));
			sysRoles.addAll(getSysRoleService().findAll());
		}
		return sysRoles;
	}

	public void setSysRoles(List<SysRole> sysRoles) {
		this.sysRoles = sysRoles;
	}

	public SysRoleService getSysRoleService() {
		return sysRoleService;
	}

	public void setSysRoleService(SysRoleService sysRoleService) {
		this.sysRoleService = sysRoleService;
	}

	public List<BaseMaintaintypeVO> getBaseMaintaintypeVOs() {
		if (SystemUtil.isNull(baseMaintaintypeVOs)) {
			baseMaintaintypeVOs = new ArrayList<BaseMaintaintypeVO>();
			BaseMaintaintypeVO baseMaintaintypeVO = new BaseMaintaintypeVO();
			baseMaintaintypeVO.setId("");
			baseMaintaintypeVO.setMaintaintypeName("——请选择——");
			baseMaintaintypeVOs.add(baseMaintaintypeVO);
			baseMaintaintypeVOs.addAll(getBaseMaintaintypeService().findAll());
		}
		return baseMaintaintypeVOs;
	}

	public BaseMaintaintypeService getBaseMaintaintypeService() {
		return baseMaintaintypeService;
	}

	public void setBaseMaintaintypeService(
			BaseMaintaintypeService baseMaintaintypeService) {
		this.baseMaintaintypeService = baseMaintaintypeService;
	}

	public String getAllSysCustIdOfString() {
		return allSysCustIdOfString = getSysCustService().findAllIdOfString();
	}

	public SysCustService getSysCustService() {
		return sysCustService;
	}

	public void setSysCustService(SysCustService sysCustService) {
		this.sysCustService = sysCustService;
	}

	public List<BaseIndustryVO> getBaseIndustryVOs() {
		if (SystemUtil.isNull(baseIndustryVOs)) {
			baseIndustryVOs = new ArrayList<BaseIndustryVO>();
			baseIndustryVOs.add(new BaseIndustryVO("", "——请选择——"));
			baseIndustryVOs.addAll(getBaseIndustryService().findAll());
		}
		return baseIndustryVOs;
	}

	public BaseIndustryService getBaseIndustryService() {
		return baseIndustryService;
	}

	public void setBaseIndustryService(BaseIndustryService baseIndustryService) {
		this.baseIndustryService = baseIndustryService;
	}

	public List<BaseTypeVO> getBaseTypeVOs() {
		if (SystemUtil.isNull(baseTypeVOs)) {
			baseTypeVOs = new ArrayList<BaseTypeVO>();
			baseTypeVOs.add(new BaseTypeVO("", "——请选择——"));
			baseTypeVOs.addAll(getBaseTypeService().findAll());
		}
		return baseTypeVOs;
	}

	public BaseTypeService getBaseTypeService() {
		return baseTypeService;
	}

	public void setBaseTypeService(BaseTypeService baseTypeService) {
		this.baseTypeService = baseTypeService;
	}

	public List<BaseSourceVO> getBaseSourceVOs() {
		if (SystemUtil.isNull(baseSourceVOs)) {
			baseSourceVOs = new ArrayList<BaseSourceVO>();
			BaseSourceVO baseSourceVO = new BaseSourceVO("", "——请选择——");
			baseSourceVOs.add(baseSourceVO);
			baseSourceVOs.addAll(getBaseSourceService().findAll());
		}
		return baseSourceVOs;
	}

	public BaseSourceService getBaseSourceService() {
		return baseSourceService;
	}

	public void setBaseSourceService(BaseSourceService baseSourceService) {
		this.baseSourceService = baseSourceService;
	}

	public List<BaseStateVO> getBaseStateVOs() {
		if (SystemUtil.isNull(baseStateVOs)) {
			baseStateVOs = new ArrayList<BaseStateVO>();
			BaseStateVO baseStateVO = new BaseStateVO();
			baseStateVO.setStateName("——请选择——");
			baseStateVO.setId("");
			baseStateVOs.add(baseStateVO);
			baseStateVOs.addAll(getBaseStateService().findAll());
		}
		return baseStateVOs;
	}

	public BaseStateService getBaseStateService() {
		return baseStateService;
	}

	public void setBaseStateService(BaseStateService baseStateService) {
		this.baseStateService = baseStateService;
	}

	public List<BaseQualityVO> getBaseQualityVOs() {
		if (SystemUtil.isNull(baseQualityVOs)) {
			baseQualityVOs = new ArrayList<BaseQualityVO>();
			baseQualityVOs.addAll(getBaseQualityService().findAll());
		}
		return baseQualityVOs;
	}

	public BaseQualityService getBaseQualityService() {
		return baseQualityService;
	}

	public void setBaseQualityService(BaseQualityService baseQualityService) {
		this.baseQualityService = baseQualityService;
	}

	public List<BaseClassVO> getBaseClassVOs() {
		if (SystemUtil.isNull(baseClassVOs)) {
			baseClassVOs = new ArrayList<BaseClassVO>();
			baseClassVOs.addAll(getBaseClassService().findAll());
		}
		return baseClassVOs;
	}

	public BaseClassService getBaseClassService() {
		return baseClassService;
	}

	public void setBaseClassService(BaseClassService baseClassService) {
		this.baseClassService = baseClassService;
	}

	public List<BaseDeliveryVO> getBaseDeliveryVOs() {
		if (SystemUtil.isNull(baseDeliveryVOs)) {
			baseDeliveryVOs = new ArrayList<BaseDeliveryVO>();
			BaseDeliveryVO baseDeliveryVO = new BaseDeliveryVO();
			baseDeliveryVO.setId("");
			baseDeliveryVO.setDeliveryName("——请选择——");
			baseDeliveryVOs.add(baseDeliveryVO);
			baseDeliveryVOs.addAll(getBaseDeliveryService().findAll());
		}
		return baseDeliveryVOs;
	}

	public BaseDeliveryService getBaseDeliveryService() {
		return baseDeliveryService;
	}

	public void setBaseDeliveryService(BaseDeliveryService baseDeliveryService) {
		this.baseDeliveryService = baseDeliveryService;
	}

	public List<BasePaymentVO> getBasePaymentVOs() {
		if (SystemUtil.isNull(basePaymentVOs)) {
			basePaymentVOs = new ArrayList<BasePaymentVO>();
			BasePaymentVO basePaymentVO = new BasePaymentVO();
			basePaymentVO.setId("");
			basePaymentVO.setPaymentName("——请选择——");
			basePaymentVOs.add(basePaymentVO);
			basePaymentVOs.addAll(getBasePaymentService().findAll());
		}
		return basePaymentVOs;
	}

	public BasePaymentService getBasePaymentService() {
		return basePaymentService;
	}

	public void setBasePaymentService(BasePaymentService basePaymentService) {
		this.basePaymentService = basePaymentService;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public List<BaseMain> getBaseMains() {
		setBaseMains(getBaseMainService().getBaseMainSelect());
		return baseMains;
	}

	public void setBaseMains(List<BaseMain> baseMains) {
		this.baseMains = baseMains;
	}

	public BaseMainService getBaseMainService() {
		return baseMainService;
	}

	public void setBaseMainService(BaseMainService baseMainService) {
		this.baseMainService = baseMainService;
	}

}
