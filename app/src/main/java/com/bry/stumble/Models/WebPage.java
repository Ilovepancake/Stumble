package com.bry.stumble.Models;

public class WebPage {
    private String PageName;
    private String PageId;
    private String PageURL;

    public WebPage(){

    }

    public WebPage(String pageName,String pageId,String PageURL){
        this.PageName=pageName;
        this.PageId=pageId;
        this.PageURL=PageURL;
    }

    public void setPageName(String pageName) {
        PageName = pageName;
    }

    public String getPageId() {
        return PageId;
    }

    public void setPageId(String pageId) {
        PageId = pageId;
    }

    public String getPageURL() {
        return PageURL;
    }

    public void setPageURL(String pageURL) {
        PageURL = pageURL;
    }
}
