package com.servlet;/*
  author:huyao
  date:2019/4/11
  */

import com.entity.Student;
import com.page.Page;
import com.service.StudentServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "FindAllServlet",urlPatterns = "/FindAllServlet" )
public class FindAllServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        this.doPost(request, response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        /**
         * ☆
         * 在使用ajax往前台通过输出流对象的print方法发送json时
         * 该行获取输出流对象的代码必须放在
         * response.setContentType("text/html;charset=UTF-8");
         * 之后,否则ajax回调时,页面拿到的中文数据就永远都是乱码,
         * 原因是:如果将改行代码写在处理客户端乱码之前,表示编码格式已经确定,
         * 所以,编码格式的处理应该放在获取PrintWriter对象之前
         *
         */
        PrintWriter out=response.getWriter();

        // 2.接受参数
        String no=request.getParameter("pageNo");


        // 3.业务处理
        // 3.业务处理
        ClassPathXmlApplicationContext applicationContext =  new ClassPathXmlApplicationContext("annotation.xml");
        StudentServiceImpl service = applicationContext.getBean("studentServiceImpl", StudentServiceImpl.class);

        int pageSize=3; //每页条数
        int pageNo=1; //默认的起始页码为1
        if(no!=null && no!=""){
            pageNo=Integer.valueOf(no);
        }
        //获取总条数
        int totalCount=service.getTotalCount();
        Page page=new Page(pageSize, pageNo, totalCount);

        List<Student> list = service.findPage(page);
        if(list!=null){
            System.out.println("find All page success");
            request.setAttribute("list", list);
            request.setAttribute("page", page);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }else{
            System.out.println("find All page fail!");
        }
    }
}
