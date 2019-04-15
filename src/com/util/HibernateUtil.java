package com.util;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author : huyao
 * date : 2019/4/9
 */

public class HibernateUtil {

    /**
     * Hibernate打开session和关闭session
     *
     */
        private static ThreadLocal<Session> threadLocal=new ThreadLocal<Session>();
        private static Configuration configuration=null;
        private static SessionFactory sessionFactory=null;
        static{

            try {
                configuration=new Configuration().configure("/hibernate.cfg.xml");
                sessionFactory=configuration.buildSessionFactory();
            } catch (HibernateException e) {
                System.out.println("解析xml和创建Session工厂error");
                e.printStackTrace();
            }
        }

        public static Session getSession(){
            Session session=threadLocal.get();
            if(session==null){
                session=sessionFactory.openSession();
                threadLocal.set(session);
            }
            return session;
        }
        public static void closeSession(){
            Session session=threadLocal.get();
            if(session!=null){
                threadLocal.set(null);
                session.close();
            }
        }

}


