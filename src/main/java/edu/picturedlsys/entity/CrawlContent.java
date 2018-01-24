package edu.picturedlsys.entity;

import java.util.List;
import java.util.Set;

/**
 * 封装爬取内容的实体类
 */
public class CrawlContent {

    private static CrawlContent crawlContent = null;

    private String htmlUrl;//网页路径
    private String sourceCode;//源码
    private List pricute;//图片集合

    private CrawlContent() {
    }

    public static CrawlContent getInstance(){
        if(crawlContent==null){
            crawlContent = new CrawlContent();
        }
        return crawlContent;
    }

    public CrawlContent(String htmlUrl, String sourceCode, List pricute) {
        this.htmlUrl = htmlUrl;
        this.sourceCode = sourceCode;
        this.pricute = pricute;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public List getPricute() {
        return pricute;
    }

    public void setPricute(List pricute) {
        this.pricute = pricute;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }
}
