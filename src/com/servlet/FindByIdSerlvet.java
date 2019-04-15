package com.servlet;/*
  author:huyao
  date:2019/4/11
  */

import com.entity.Student;
import com.service.StudentServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FindByIdSerlvet",urlPatterns = "/FindByIdSerlvet" )
public class FindByIdSerlvet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // 2.接受参数
        Integer sid=Integer.valueOf(request.getParameter("sid"));

        // 3.业务处理
        // 3.业务处理
        ClassPathXmlApplicationContext applicationContext =  new ClassPathXmlApplicationContext("annotation.xml");
        StudentServiceImpl service = applicationContext.getBean("studentServiceImpl", StudentServiceImpl.class);

        Student stu=service.findById(sid);
        System.out.println("stu:"+stu);
        if(stu!=null){
            System.out.println("根据id查询到对象");
            request.setAttribute("stu", stu);
            request.getRequestDispatcher("update.jsp").forward(request, response);
        }else{
            System.out.println("没有根据id查询到对象");
        }

    }
}
