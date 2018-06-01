package com.codegen.common.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(
		ignoreUnknown = true
)
public class Page<E> implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private int length = 8;// 显示页面长度
	private String funcName = "page"; // 设置点击页码调用的js函数名称，默认为page，在一页有多个分页对象时使用。
	private String funcParam = ""; // 函数的附加参数，第三个参数值。
	private int slider = 1;// 前后显示页面长度
	private int first = 1; //第1页
	private int last;// 尾页索引
	private int prev;// 上一页索引
	private int next;// 下一页索引
	private String message = ""; // 设置提示消息，显示在“共n条”之后
	
	/**
	 * 页码，从1开始
	 */
	private int pageNum;
	/**
	 * 页面大小
	 */
	private int pageSize;
	/**
	 * 起始行
	 */
	private int startRow;
	/**
	 * 末行
	 */
	private int endRow;
	/**
	 * 总数
	 */
	private long total;
	/**
	 * 总页数
	 */
	private int pages;
	/**
	 * 分页合理化
	 */
	private Boolean reasonable;

	private List<E> result = new ArrayList<E>();

	public Page() {

	}

	public Page(com.github.pagehelper.Page page) {
		this.pageNum = page.getPageNum();
		this.pageSize = page.getPageSize();
		this.startRow = page.getStartRow();
		this.endRow = page.getEndRow();
		this.total = page.getTotal();
		this.pages = page.getPages();
		this.result = page.getResult();

		calculateStartAndEndRow();
		setReasonable(reasonable);
	}

	/**
	 * 计算起止行号
	 */
	public void calculateStartAndEndRow() {
		this.last = this.pages;

		if (this.pageNum < this.last - 1) {
			this.next = this.pageNum + 1;
		} else {
			this.next = this.last;
		}

		if (this.pageNum > 1) {
			this.prev = this.pageNum - 1;
		} else {
			this.prev = this.first;
		}

		this.startRow = this.pageNum > 0 ? (this.pageNum - 1) * this.pageSize : 0;
		this.endRow = this.startRow + this.pageSize * (this.pageNum > 0 ? 1 : 0);



	}

	public Boolean getReasonable() {
		return reasonable;
	}

	public Page<E> setReasonable(Boolean reasonable) {
		if (reasonable == null) {
			return this;
		}
		this.reasonable = reasonable;
		//分页合理化，针对不合理的页码自动处理
		if (this.reasonable && this.pageNum <= 0) {
			this.pageNum = 1;
			calculateStartAndEndRow();
		}
		return this;
	}


	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		if (pageNum == first) {// 如果是首页
			sb.append("<li class=\"disabled\"><a href=\"javascript:\">&#171; 上一页</a></li>\n");
		} else {
			sb.append("<li><a href=\"javascript:\" onclick=\""+funcName+"("+prev+","+pageSize+",'"+funcParam+"');\">&#171; 上一页</a></li>\n");
		}

		int begin = pageNum - (length / 2);

		if (begin < first) {
			begin = first;
		}

		int end = begin + length - 1;

		if (end >= last) {
			end = last;
			begin = end - length + 1;
			if (begin < first) {
				begin = first;
			}
		}

		if (begin > first) {
			int i = 0;
			for (i = first; i < first + slider && i < begin; i++) {
				sb.append("<li><a href=\"javascript:\" onclick=\""+funcName+"("+i+","+pageSize+",'"+funcParam+"');\">"
						+ (i + 1 - first) + "</a></li>\n");
			}
			if (i < begin) {
				sb.append("<li class=\"disabled\"><a href=\"javascript:\">...</a></li>\n");
			}
		}

		for (int i = begin; i <= end; i++) {
			if (i == pageNum) {
				sb.append("<li class=\"active\"><a href=\"javascript:\">" + (i + 1 - first)
						+ "</a></li>\n");
			} else {
				sb.append("<li><a href=\"javascript:\" onclick=\""+funcName+"("+i+","+pageSize+",'"+funcParam+"');\">"
						+ (i + 1 - first) + "</a></li>\n");
			}
		}

		if (last - end > slider) {
			sb.append("<li class=\"disabled\"><a href=\"javascript:\">...</a></li>\n");
			end = last - slider;
		}

		for (int i = end + 1; i <= last; i++) {
			sb.append("<li><a href=\"javascript:\" onclick=\""+funcName+"("+i+","+pageSize+",'"+funcParam+"');\">"
					+ (i + 1 - first) + "</a></li>\n");
		}

		if (pageNum == last) {
			sb.append("<li class=\"disabled\"><a href=\"javascript:\">下一页 &#187;</a></li>\n");
		} else {
			sb.append("<li><a href=\"javascript:\" onclick=\""+funcName+"("+next+","+pageSize+",'"+funcParam+"');\">"
					+ "下一页 &#187;</a></li>\n");
		}

		sb.append("<li class=\"disabled controls\"><a href=\"javascript:\">当前 ");
		sb.append("<input type=\"text\" value=\""+pageNum+"\" onkeypress=\"var e=window.event||this;var c=e.keyCode||e.which;if(c==13)");
		sb.append(funcName+"(this.value,"+pageSize+",'"+funcParam+"');\" onclick=\"this.select();\"/> / ");
		sb.append("<input type=\"text\" value=\""+pageSize+"\" onkeypress=\"var e=window.event||this;var c=e.keyCode||e.which;if(c==13)");
		sb.append(funcName+"("+pageNum+",this.value,'"+funcParam+"');\" onclick=\"this.select();\"/> 条，");
		sb.append("共 " + this.total + " 条"+(message!=null?message:"")+"</a></li>\n");

		sb.insert(0,"<ul>\n").append("</ul>\n");
		
		sb.append("<div style=\"clear:both;\"></div>");

//		sb.insert(0,"<div class=\"page\">\n").append("</div>\n");
		
		return sb.toString();
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public List<E> getResult() {
		return result;
	}

	public void setResult(List<E> result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getFuncName() {
		return funcName;
	}

	public void setFuncName(String funcName) {
		this.funcName = funcName;
	}

	public String getFuncParam() {
		return funcParam;
	}

	public void setFuncParam(String funcParam) {
		this.funcParam = funcParam;
	}

	public int getSlider() {
		return slider;
	}

	public void setSlider(int slider) {
		this.slider = slider;
	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getLast() {
		return last;
	}

	public void setLast(int last) {
		this.last = last;
	}

	public int getPrev() {
		return prev;
	}

	public void setPrev(int prev) {
		this.prev = prev;
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}
}
