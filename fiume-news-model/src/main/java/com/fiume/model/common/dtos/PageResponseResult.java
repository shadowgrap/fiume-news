package com.fiume.model.common.dtos;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

public class PageResponseResult extends ResponseResult implements Serializable {
    private Integer currentPage;
    private Integer size;
    private Long total;

    public PageResponseResult(Integer currentPage, Integer size, Long total) {
        this.currentPage = currentPage;
        this.size = size;
        this.total = total;
    }

    public PageResponseResult() {

    }


    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
