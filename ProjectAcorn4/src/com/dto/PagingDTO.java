package com.dto;

import java.util.List;

public class PagingDTO {

	private int curPage;
	private int perPage=3;
	private int totalCount;
	private int perBlock=2;
	private List<GoodsDTO> list;
	
	
	public PagingDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PagingDTO(int curPage, int perPage, int totalCount, int perBlock, List<GoodsDTO> list) {
		super();
		this.curPage = curPage;
		this.perPage = perPage;
		this.totalCount = totalCount;
		this.perBlock = perBlock;
		this.list = list;
	}
	@Override
	public String toString() {
		return "PagingDTO [curPage=" + curPage + ", perPage=" + perPage + ", totalCount=" + totalCount + ", perBlock="
				+ perBlock + ", list=" + list + "]";
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPerBlock() {
		return perBlock;
	}
	public void setPerBlock(int perBlock) {
		this.perBlock = perBlock;
	}
	public List<GoodsDTO> getList() {
		return list;
	}
	public void setList(List<GoodsDTO> list) {
		this.list = list;
	}
	
	
}
