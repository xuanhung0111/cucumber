package com.zinio.zenith.common;

/**
 * Created by ducnguyen on 9/15/16.
 */
public class PagingHeader {
    private int XPaginationLimit;
    private int XPaginationPage;
    private int XPaginationPageTotal;
    private int XPaginationTotal;

    public int getXPaginationLimit() {
        return XPaginationLimit;
    }

    public void setXPaginationLimit(int XPaginationLimit) {
        this.XPaginationLimit = XPaginationLimit;
    }

    public int getXPaginationPage() {
        return XPaginationPage;
    }

    public void setXPaginationPage(int XPaginationPage) {
        this.XPaginationPage = XPaginationPage;
    }

    public int getXPaginationPageTotal() {
        return XPaginationPageTotal;
    }

    public void setXPaginationPageTotal(int XPaginationPageTotal) {
        this.XPaginationPageTotal = XPaginationPageTotal;
    }

    public int getXPaginationTotal() {
        return XPaginationTotal;
    }

    public void setXPaginationTotal(int XPaginationTotal) {
        this.XPaginationTotal = XPaginationTotal;
    }
}
