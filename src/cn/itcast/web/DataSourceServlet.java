package cn.itcast.web;

import cn.itcast.dao.DaoData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by yvettee on 2017/9/29.
 */
@WebServlet(name = "DataSourceServlet", urlPatterns = "/DataSourceServlet")
public class DataSourceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        DaoData dao = new DaoData();
        dao.add();
    }
}
