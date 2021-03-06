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

@WebServlet(name = "UpdateServlet",urlPatterns = "/UpdateServlet")
public class UpdateServlet extends HttpServlet {

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
        String sname = request.getParameter("sname");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex");
        Integer cid=Integer.valueOf(request.getParameter("cid"));
        Student stu=new Student(sid,sname, password, sex, cid);

        // 3.业务处理
        // 3.业务处理
        ClassPathXmlApplicationContext applicationContext =  new ClassPathXmlApplicationContext("annotation.xml");
        StudentServiceImpl service = applicationContext.getBean("studentServiceImpl", StudentServiceImpl.class);
        int num=service.update(stu);
        if(num>0){
            System.out.println("update success!");
            response.sendRedirect("FindAllServlet");
        }else{
            System.out.println("update fail!");

        }

    }


}

