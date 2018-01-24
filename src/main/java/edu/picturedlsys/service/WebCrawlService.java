package edu.picturedlsys.service;

import edu.picturedlsys.entity.CrawlContent;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 网页爬取的业务层
 */
public class WebCrawlService {

    private CrawlContent crawlContent = CrawlContent.getInstance();

    public CrawlContent crawlContent(String url) throws IOException {
        //模拟浏览器链接
        Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 6.1; rv:30.0) Gecko/20100101 Firefox/30.0").get();

        //存储数据
        crawlContent.setHtmlUrl(url);
        crawlContent.setSourceCode(getSourceCode(doc));
        crawlContent.setPricute(getPricutes(doc));
        return crawlContent;
    }

    /**
     * 获取网页源码的方法
     * @param doc
     * @return
     */
    private String getSourceCode(Document doc){
        return doc.toString();
    }

    /**
     * 获取网页所有图片的方法
     * @param doc
     * @return
     */
    private List getPricutes(Document doc){
        //创建集合
        List list = new ArrayList();
        //筛选条件
        Elements items = doc.select("img");
        String imgSrc = null;
        for (Element e:items) {
            imgSrc = e.attr("src");
            if(imgSrc.contains(".jpg")||imgSrc.contains(".png")||imgSrc.contains(".jpeg")||imgSrc.contains(".gif")){
                list.add(e);
            }
        }
        return list;
    }

}
