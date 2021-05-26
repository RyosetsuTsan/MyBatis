package com.yuki.servlet;

import com.yuki.bean.Course;
import com.yuki.service.indexService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yuki
 */
@WebServlet("/index")
public class indexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String dowhat=req.getParameter("do");

        if (dowhat==null)dowhat="findAll";
        indexService service = new indexService();
        String[] ids_window=null;
        switch (dowhat){
            //展示所有数据
            case "findAll":
                List<Course> courses = service.findAll();
                req.setAttribute("courses",courses);
                req.getRequestDispatcher("index.jsp").forward(req,resp);
                break;
            //多行删除
            case "delete":
                ids_window = req.getParameterValues("id");
            case "delete2":
                String str=req.getParameter("str");
                if (dowhat.equals("delete2"))
                    ids_window=str.split(",");//str to str[]
                
                int[] ids_ints = Arrays.stream(ids_window).mapToInt(Integer::parseInt).toArray();//str[] to int[]
                List<Integer> ids = Arrays.stream(ids_ints).boxed().collect(Collectors.toList());//转List<Integer>
                boolean delete = service.delete(ids);
                if (delete)
                    resp.sendRedirect("index");
                break;
            //条件查询
            case "select":
                Course course=new Course();
                List<Course> by = service.FindBy(req.getParameter("name"),req.getParameter("startdate"),req.getParameter("enddate"),req.getParameter("teacher"));
                req.setAttribute("courses",by);
                req.getRequestDispatcher("index.jsp").forward(req,resp);
                break;

        }
    }
}
