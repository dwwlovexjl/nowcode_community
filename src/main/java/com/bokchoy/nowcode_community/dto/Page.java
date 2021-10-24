package com.bokchoy.nowcode_community.dto;

import org.springframework.stereotype.Component;

/**
 * @author bokchoy
 * @description: 分页信息
 * @date 2021年10月20日 17:10
 */

@Component
public class Page {
    private int current=1;//当前页码

    private int limit=10;//每页数量

    private int pageCount=3;//显示页码数量

    private int rows=0;//数据总数

    private String path;//当前访问路径(用于复用分页链接)

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if (current>=1) {
            this.current = current;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if (limit>=1&&limit<=100) {
            this.limit = limit;
        }
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if (rows>=0){
            this.rows = rows;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /*
     * 获取当前页起始行
     * @return int
     */
    public int getOffset(){
        return (current-1)*limit;
    }

    /*
     * 用来获取总页数
     * @return int
     */
    public int getTotal(){
        if (rows%limit==0){
            return rows/limit;
        }else {
            return rows/limit+1;
        }
    }

    /*
     * 获取起始页码
     * @author bokchoy
     * @date 2021/10/20 17:29
     * @return int
     */
    public int getFrom(){
        int from = current - pageCount;
        return from >0? from :1;
    }

    /*
     * 获取结束页码
     * @author bokchoy
     * @date 2021/10/20 17:29
     * @return int
     */
    public int getTo(){
        int to = current + pageCount;
        return to <getTotal()? to :getTotal();
    }
}
