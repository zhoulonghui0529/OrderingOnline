package com.order.common.entity;
/**
 * 分页参数类
 * @author zlh
 *
 */
public class Pager {
	private Integer start;//开始行数
	private Integer page;//当前页码
	private Integer rows;//每页显示的行数
	public Pager(int page,int rows) {
		this.start=(page-1)*rows;
		this.page=page;
		this.rows=rows;
	}
	
	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "Pager [start=" + start + ", page=" + page + ", rows=" + rows + "]";
	}
	
}
