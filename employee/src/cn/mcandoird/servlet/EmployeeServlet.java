package cn.mcandoird.servlet;

import cn.mcandoird.service.EmployeeService;
import cn.mcandoird.service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *  将json数据请求路径设置为/emp
 *
 *  将json数据返回给前台页面
 */
@WebServlet("/emp")
public class EmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=utf-8");
        PrintWriter out=response.getWriter();
        EmployeeService service=new EmployeeServiceImpl();
        out.print(service.findAllToJson());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //偷懒 都在doPost 进行处理
        doPost(request,response);
    }
}
