package com.kuaidan.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListPageUtil<T> implements Serializable{
    private static final long serialVersionUID = 1L;

    public ListPageUtil() {
    }

    public void setPageList(List<T> pageList) {
        this.pageList.addAll(pageList);
    }

    /**
     * 分页数据
     */
    private List<T> pageList = new ArrayList<>();

    public List<T> getPageList() {
        return pageList;
    }

    /** 上一页 */
    private int previousPage;

    /** 当前页 */
    private int pageNum;

    /** 下一页 */
    private int nextPage;
//
    /** 每页条数 */
    private int pageSize;

    /** 总页数 */
    private int totalPage;

    /** 总数据条数 */
    private int totalCount;
    /**
     * 每页开始数
     */

    private int startNum;
    /**
     * 是否是第一页
     */
    private boolean isFirstPage;
    /**
     * 是否是最后一页
     */
    private boolean isLastPage;

    /**
     * 每页结束数
     */

    private int endNum;
    public ListPageUtil(int totalCount, int pageNum, int pageSize) {
        if(pageSize < 1){
            pageSize = 10;
        }
        if(pageNum < 1){
            pageNum = 1;
        }
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        this.totalCount = totalCount;
        this.totalPage = (totalCount + pageSize - 1) / pageSize;
        this.previousPage = pageNum-1>1? pageNum-1:1;
        this.nextPage = pageNum>=totalPage? totalPage: pageNum + 1;
        this.startNum = (pageNum-1)*pageSize+1;
        this.endNum = startNum + pageSize-1;
        if(startNum <= pageSize){
            this.isFirstPage = true;
        }else{
            this.isFirstPage = false;
        }
        if(startNum >= totalCount - pageSize){
            this.isLastPage = true;
        }else{
            this.isLastPage = false;
        }

    }
    public ListPageUtil(int totalCount, int pageNum, int pageSize,List<T> list) {
        if(pageSize < 1){
            pageSize = 10;
        }
        if(pageNum < 1){
            pageNum = 1;
        }
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.totalPage = (totalCount + pageSize - 1) / pageSize;
        if (pageNum>getTotalPage()){
            this.pageNum=getTotalPage();
            pageNum=getTotalPage();
        }else {
            this.pageNum = pageNum;
        }
        this.previousPage = pageNum-1>1? pageNum-1:1;
        this.nextPage = pageNum>=totalPage? totalPage: pageNum + 1;
        this.startNum = (pageNum-1)*pageSize;
        this.endNum = startNum + pageSize;
        if(startNum <= pageSize){
            this.isFirstPage = true;
        }else{
            this.isFirstPage = false;
        }
        if(startNum >= totalCount - pageSize){
            this.isLastPage = true;
        }else{
            this.isLastPage = false;
        }
        if(!list.isEmpty()){
            List<T> tList=new ArrayList<>();
            if (endNum>list.size()){
                tList = list.subList(startNum,list.size());
            }else {
                tList = list.subList(startNum, endNum);
            }
            this.getPageList().addAll(tList);
        }else{
            this.getPageList().clear();
        }
    }
    public int getPreviousPage() {
        return previousPage;
    }

    public void setPreviousPage(int previousPage) {
        this.previousPage = previousPage;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getStartNum() {
        return startNum;
    }

    public void setStartNum(int startNum) {
        this.startNum = startNum;
    }

    public boolean isFirstPage() {
        return isFirstPage;
    }

    public void setFirstPage(boolean firstPage) {
        isFirstPage = firstPage;
    }

    public boolean isLastPage() {
        return isLastPage;
    }

    public void setLastPage(boolean lastPage) {
        isLastPage = lastPage;
    }

    public int getEndNum() {
        return endNum;
    }

    public void setEndNum(int endNum) {
        this.endNum = endNum;
    }
}
