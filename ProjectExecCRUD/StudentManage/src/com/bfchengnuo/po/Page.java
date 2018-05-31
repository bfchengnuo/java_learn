package com.bfchengnuo.po;

import java.util.List;

/**
 * Created by 冰封承諾Andy on 2018/5/29.
 */
public class Page<T> {
    // 当前页
    private int pageNumber;
    private int pageSize = 3;
    private int total;
    // 总页数
    private int pageCount;

    private int next;
    private int pre;
    private int start;

    private List<T> rows;

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageCount() {
        return (total + pageSize - 1) / pageSize;
    }

    public int getNext() {
        if (pageNumber < getPageCount()) {
            return pageNumber + 1;
        }
        return getPageCount();
    }

    public int getPre() {
        if (pageNumber > 1) {
            return pageNumber - 1;
        }
        return 1;
    }

    public int getStart() {
        return (pageNumber - 1) * pageSize;
    }


    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
