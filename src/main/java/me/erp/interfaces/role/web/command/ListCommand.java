package me.erp.interfaces.role.web.command;

import java.io.Serializable;

/**
 * Created by ivan_ on 2015/3/31.
 */
public class ListCommand implements Serializable {
    private int page = 1;
    private int pageSize = 20;

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
