package edu.picturedlsys.controll;

import com.google.gson.Gson;
import edu.picturedlsys.entity.CrawlContent;
import edu.picturedlsys.exception.DownloadPicutreException;
import edu.picturedlsys.service.DownloadPictureService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/DownloadPictureControll")
public class DownloadPictureControll extends HttpServlet {

    private DownloadPictureService downloadPictureService = null;

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受下载路径.
        String downPath = req.getParameter("downPath");
        downPath = downPath.replaceAll("\\\\","/");
        //调用业务层方法
        downloadPictureService = new DownloadPictureService();
        PrintWriter out = resp.getWriter();
        try {
            downloadPictureService.downloadPicture(downPath);
            out.println("1");
        } catch (DownloadPicutreException e) {
            out.println("0");
        } finally{
            out.close();
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }

}
