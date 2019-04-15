package com.dao;/*
  author:huyao
  date:2019/4/11
  */

import com.entity.Student;
import com.page.Page;
import com.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;
// 持久层  数据访问层 DAO
@Repository
public class StudentDaoImpl{
    /**
     * 1.查询所有:立即加载
     */
    public List<Student> findAll() {
        //1.获取session对象
        Session session= HibernateUtil.getSession();
        //2.定义hql语句
        String hql="from Student";
        //3.Session创建Query对象
        Query query=session.createQuery(hql);
        //4.query对象执行操作
        List<Student> it=query.list();
        //5.释放资源
        HibernateUtil.closeSession();
        return it;
    }

    /**
     * 根据id主键查询单条
     */
    public Student findById(Integer sid) {
        //1.获取session对象
        Session session=HibernateUtil.getSession();
        //2.利用session根据主键查询
        Student stu=(Student) session.get(Student.class, sid);
        /*3.
         * 因为在修改时要提前查询单条,和session关联已经变成持久化对象,
         * 而在修改时session执行update方法时,
         * 首先会查询该主键id是否存在,
         * 如果存在,则根据主键id修改该对象,此时对象已经处于持久化对象,
         * 而实际session中不能同时存在两个主键id相同的对象,
         * 否则会出现如下错误:
         * org.hibernate.NonUniqueObjectException:
         * a different object with the same identifier
         * value was already associated with the
         * session: [com.entity.Student#1]
         */
        HibernateUtil.closeSession();
        // session.clear();
        return stu;
    }
    /**
     * 删除对象
     */
    public int delete(Student stu) {
        int num=1;
        //1.获取session对象
        Session session=HibernateUtil.getSession();

        try {
            //session删除操作
            session.delete(stu);
            session.beginTransaction().commit();
        } catch (HibernateException e) {
            num=0;
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            //5.释放资源
            HibernateUtil.closeSession();
        }

        return num;
    }
    /**
     * 添加
     */
    public int save(Student stu) {
        int num=1;
        //1.获取session对象
        Session session=HibernateUtil.getSession();
        //执行操作
        try {
            session.save(stu);
            session.beginTransaction().commit();
        } catch (HibernateException e) {
            num=0;
            e.printStackTrace();
        }finally{
            //5.释放资源
            HibernateUtil.closeSession();
        }
        return num;
    }
    /**
     * 修改
     */
    public int update(Student stu) {
        int num=1;
        //1.获取session对象
        Session session=HibernateUtil.getSession();
        try {
            //执行操作
            //该对象的主键id必须存在
            session.update(stu);
            session.beginTransaction().commit();
        } catch (HibernateException e) {
            num=0;
            e.printStackTrace();
        }finally{
            //5.释放资源
            HibernateUtil.closeSession();
        }
        return num;
    }
    /**
     * 7.分页查询
     */
    public List<Student> findPage(Page page) {
        //1.获取session
        Session session=HibernateUtil.getSession();

        //2.定义查询最大记录数的hql
        String hql="from Student";

        //3.定义查询最大记录数的Query对象
        Query querypage=session.createQuery(hql);

        //4.查询最大记录数的数据
        querypage.setMaxResults(page.getPagesize());

        //5.确定查询起点
        querypage.setFirstResult(page.getStartrow());

        //6.分页查询
        List<Student> list=querypage.list();

        //7.关闭session
        HibernateUtil.closeSession();

        return list;
    }
    /**
     * 8.查询总条数
     */
    public int getTotalCount() {
        //1.获取session
        Session session=HibernateUtil.getSession();

        //2.定义查询总条数hql语句
        String hqlcount="select count(*) from Student";

        //3.利用Session创建Query对象
        Query querycount=session.createQuery(hqlcount);

        //4.获取总条数(返回单行数据uniqueResult())
        Integer totalCount=Integer.parseInt(querycount.uniqueResult().toString());
        //5.释放资源
        HibernateUtil.closeSession();
        return totalCount;
    }
}