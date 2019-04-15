package com.service;/*
  author:huyao
  date:2019/4/11
  */

import com.dao.StudentDaoImpl;
import com.entity.Student;
import com.page.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
// 业务层
@Service
public class StudentServiceImpl {
    /**
     * 使用多态引用数据访问层对象
     */
    @Resource
    private StudentDaoImpl studentDaoImpl;
    
    public int save(Student stu) {
            // TODO Auto-generated method stub
            return studentDaoImpl.save(stu);
        }

    public int delete(Student stu) {
        // TODO Auto-generated method stub
        return studentDaoImpl.delete(stu);
    }

    public List<Student> findAll() {
        // TODO Auto-generated method stub
        return studentDaoImpl.findAll();
    }

    public Student findById(Integer sid) {
        // TODO Auto-generated method stub
        return studentDaoImpl.findById(sid);
    }



    public int update(Student stu) {
        // TODO Auto-generated method stub
        return studentDaoImpl.update(stu);
    }

    public List<Student> findPage(Page page) {
        // TODO Auto-generated method stub
        return studentDaoImpl.findPage(page);
    }

    public int getTotalCount() {
        // TODO Auto-generated method stub
        return studentDaoImpl.getTotalCount();
    }


}

