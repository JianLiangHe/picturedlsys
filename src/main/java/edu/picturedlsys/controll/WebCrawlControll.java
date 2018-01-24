package edu.picturedlsys.controll;

import edu.picturedlsys.entity.CrawlContent;
import edu.picturedlsys.service.WebCrawlService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/WebCrawlControll")
public class WebCrawlControll extends HttpServlet {

    private WebCrawlService webCrawlService = new WebCrawlService();

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取URL
        String url = req.getParameter("url");
        //存储数据
        CrawlContent crawlContent = webCrawlService.crawlContent(url);
        //设置到请求作用域中
        req.setAttribute("crawlContent",crawlContent);
        //转向
        req.getRequestDispatcher("/result.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

}
