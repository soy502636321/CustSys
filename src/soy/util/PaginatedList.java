package soy.util;

import java.util.List;

import org.displaytag.properties.SortOrderEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 分页器
 * 
 * @author 小胡
 * 
 */

public class PaginatedList implements org.displaytag.pagination.PaginatedList {
	private static final Logger log = LoggerFactory
			.getLogger(PaginatedList.class);

	// 属性
	private int fullListSize; // 查询总数
	private List list; // 查询集合
	private int objectsPerPage = PropsParser.getPageSize(); // 分页数量
	private int pageNumber; // 分页的序号
	private int startNumber;
	private String searchId;
	private String sortCriterion;
	private SortOrderEnum sortDirection;

	// 构造方法
	/**
	 * 默认的构造方法
	 */
	public PaginatedList() {
	}

	/**
	 * 指定页数的构造方法
	 */
	public PaginatedList(Integer pageNumber) {
		if (pageNumber == null || pageNumber.intValue() <= 0) {
			this.pageNumber = new Integer(1);
		} else {
			this.pageNumber = pageNumber.intValue();
		}
	}

	// 属性访问
	public int getFullListSize() {
		return fullListSize;
	}

	public void setFullListSize(int fullListSize) {
		this.fullListSize = fullListSize;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public int getObjectsPerPage() {
		if (objectsPerPage <= 0) {
			objectsPerPage = 15;
		}
		return objectsPerPage;
	}

	public void setObjectsPerPage(int objectsPerPage) {
		this.objectsPerPage = objectsPerPage;
	}

	public int getPageNumber() {
		if (pageNumber <= 0) {
			pageNumber = 1;
		}
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String getSearchId() {
		return searchId;
	}

	public void setSearchId(String searchId) {
		this.searchId = searchId;
	}

	public String getSortCriterion() {
		return sortCriterion;
	}

	public void setSortCriterion(String sortCriterion) {
		this.sortCriterion = sortCriterion;
	}

	public SortOrderEnum getSortDirection() {
		return sortDirection;
	}

	public void setSortDirection(SortOrderEnum sortDirection) {
		this.sortDirection = sortDirection;
	}

	public int getStartNumber() {
		startNumber = (getPageNumber() - 1) * getObjectsPerPage();
		return startNumber;
	}

	public void setStartNumber(int startNumber) {
		this.startNumber = startNumber;
	}
	
}
