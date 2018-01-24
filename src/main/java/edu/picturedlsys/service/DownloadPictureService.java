package edu.picturedlsys.service;

import edu.picturedlsys.entity.CrawlContent;
import edu.picturedlsys.exception.DownloadPicutreException;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

/**
 * 下载图片的业务层
 */
public class DownloadPictureService {

    private CrawlContent crawlContent = CrawlContent.getInstance();

    /**
     * 下载图片方法
     * @param downPath
     */
    public void downloadPicture(String downPath){
        //获取所有图片对象
        List<Element> list = crawlContent.getPricute();
        String imgUrl = null;
        //遍历图片url
        for (Element e:list) {
            imgUrl = e.attr("src");
            try {
                //执行下载
                excuteDownload(imgUrl,downPath);
            } catch (DownloadPicutreException ex) {
                ex.getMessage();
            }
        }
    }

    /**
     * 执行下载方法
     * @param imgUrl
     * @param downPath
     */
    private void excuteDownload(String imgUrl,String downPath){
        try {
            //建立连接
            URL url = new URL(imgUrl);
            InputStream inputStream = url.openStream();
            //创建文件
            File file = new File(downPath,System.currentTimeMillis()+".jpg");
            //文件传输
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            int i = 0;
            while((i=inputStream.read())!=-1){
                fileOutputStream.write(i);
            }
            fileOutputStream.close();
            inputStream.close();
        } catch (Exception e) {
            throw new DownloadPicutreException("图片: "+imgUrl+" ,下载有误!");
        }
    }

}
