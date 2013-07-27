package soy.basic.database.entity;

import java.io.Serializable;

/**
 * @author XiaoLiang·Hu
 * 
 */
public class BaseProduction implements Serializable {
	private Integer id;
	private String name;
	private String remark;
	
	//构造方法
	
	/**
	 * 默认的构造方法
	 */
	public BaseProduction() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
