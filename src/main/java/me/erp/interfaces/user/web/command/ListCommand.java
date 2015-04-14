package me.erp.interfaces.user.web.command;

import java.io.Serializable;

/**
 * Created by ivan_ on 2015/3/30.
 */
public class ListCommand implements Serializable {
    private String username;
    private int page = 1;
    private int pageSize = 20;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
