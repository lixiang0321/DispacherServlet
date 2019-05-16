package www.mldn.common.servlet;


import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import www.mldn.common.servlet.bean.ScannerPackageUtil;


public class DispacherServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        //读取初始化扫描报
        String scanPackages =
                config.getInitParameter("scanPackages");
        //如果配置的扫描包不为空
        if(!(scanPackages ==null || "".equals(scanPackages))){
            //进行调用
            ScannerPackageUtil.scannerHandle(this.getClass(),scanPackages);
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
