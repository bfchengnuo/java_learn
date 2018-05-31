package com.bfchengnuo.po;

import java.util.List;

/**
 * Created by 冰封承諾Andy on 2018/5/30.
 */
public class Page<T> {
    // 当前页
    private Integer pageNumber;
    private Integer pageSize = 5;
    private Integer pageCount;
    private Integer total;

    private Integer next;
    private Integer pre;
    private Integer start;

    private List<T> rows;

    public Page() {
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageCount() {
        return (total + pageSize - 1) / pageSize;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getNext() {
        if (pageNumber < getPageCount()) {
            return pageNumber + 1;
        }
        return getPageCount();
    }


    public Integer getPre() {
        if (pageNumber > 1) {
            return pageNumber - 1;
        }
        return 1;
    }


    public Integer getStart() {
        return (pageNumber - 1) * pageSize;
    }


    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
