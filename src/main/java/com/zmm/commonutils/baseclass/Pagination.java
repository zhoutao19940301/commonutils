package com.zmm.commonutils.baseclass;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * 分页类
 * 
 * @author lzy
 */
public class Pagination implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -540893817802127558L;

	/**
	 * 注释内容
	 */

	/**
	 * 默认每页显示个数
	 */
	public static final Integer DEFAULT_NUM_PERPAGE = 10;

	/**
	 * 默认查询第几页
	 */
	public static final Integer DEFAULT_PAGENO = 1;

	/**
	 * 查询所有数据
	 */
	public static final Integer QUERY_ALL = -1;

	/**
	 * 每页显示数量
	 */
	@ApiModelProperty(value = "每页显示数量")
	private Integer pageSize = DEFAULT_NUM_PERPAGE;

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	/**
	 * 默认起始数据
	 */
	public static final Integer DEFAULT_NUM_START = -1;

	/**
	 * 起始条数
	 */
	@ApiModelProperty(value = "起始条数")
	private Integer startNum = DEFAULT_NUM_START;

	/**
	 * 第几页
	 * <p>
	 * 如果传值为{@link #QUERY_ALL}，表示查询所有数据，不传，则表示默认查询第1页)
	 */
	@ApiModelProperty(value = "页码(第几页)")
	private Integer pageNo = DEFAULT_PAGENO;

	@ApiModelProperty(value = "是否计算总条数")
	private boolean calTotal = true;

	// 总条数
	private Integer total;
	// 总页数
	private Integer pages;

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getPageSize() {
		// 如果是查询所有的
		if (Pagination.QUERY_ALL == this.pageNo) {
			// 这里的5000可配置..........
			return 5000;
		}
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNo() {
		if(pageNo <= 0)
		{
			pageNo = DEFAULT_PAGENO;
		}
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	/**
	 * 计算从第几行获取数据
	 * 
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	public Integer getStart() {
		// 如果传了起始条数,则直接返回该值;
		if (this.startNum >= 0) {
			return this.startNum;
		}
		// 如果是查询所有的，则从第0条开始获取数据
		if (Pagination.QUERY_ALL == this.pageNo) {
			return 0;
		}

		if (this.pageNo <= 0) {
			this.pageNo = DEFAULT_PAGENO;
		}

		if (this.pageSize <= 0) {
			this.pageSize = DEFAULT_NUM_PERPAGE;
		}

		return (this.pageNo - 1) * this.pageSize;
	}

	public Integer getStartNum() {
		return startNum;
	}

	public void setStartNum(Integer startNum) {
		this.startNum = startNum;
	}

	public boolean isCalTotal() {
		return calTotal;
	}

	public void setCalTotal(boolean calTotal) {
		this.calTotal = calTotal;
	}

	@Override
	public String toString() {
		return "Pagination [numPerPage=" + pageSize + ", startNum=" + startNum + ", pageNo=" + pageNo + ", calTotal="
				+ calTotal + "]";
	}

}
