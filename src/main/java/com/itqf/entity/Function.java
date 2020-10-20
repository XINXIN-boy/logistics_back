package com.itqf.entity;

/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/517:48
 * description:
 */
public class Function {

    private int id ;
    private String pageName ;
    private String  pageFunction ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getPageFunction() {
        return pageFunction;
    }

    public void setPageFunction(String pageFunction) {
        this.pageFunction = pageFunction;
    }
}
