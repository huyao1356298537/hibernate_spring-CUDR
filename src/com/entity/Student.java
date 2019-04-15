package com.entity;/*
  author:huyao
  date:2019/4/11
  */

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
        private Integer sid;
        private String sname;
        private String password;
        private String sex;
        private Integer cid;

        public Student() {
        }
        public Student(Integer sid, String sname, String password, String sex,
                       Integer cid) {
            this.sid = sid;
            this.sname = sname;
            this.password = password;
            this.sex = sex;
            this.cid = cid;
        }
        public Student(String sname, String password, String sex,
                       Integer cid) {
            this.sname = sname;
            this.password = password;
            this.sex = sex;
            this.cid = cid;
        }
    @Id
    @GenericGenerator( name = "native",strategy = "native")
    @GeneratedValue(generator = "native")
    @Column(name = "SID")
        public Integer getSid() {
            return sid;
        }
        public void setSid(Integer sid) {
            this.sid = sid;
        }
    @Column(name = "SNAME")
        public String getSname() {
            return sname;
        }
        public void setSname(String sname) {
            this.sname = sname;
        }
    @Column(name = "PASSWORD")
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
    @Column(name = "SEX")
        public String getSex() {
            return sex;
        }
        public void setSex(String sex) {
            this.sex = sex;
        }
    @Column(name = "CID")
        public Integer getCid() {
            return cid;
        }
        public void setCid(Integer cid) {
            this.cid = cid;
        }

        @Override
        public String toString() {
            return "Student [cid=" + cid + ", password=" + password + ", sex="
                    + sex + ", sid=" + sid + ", sname=" + sname + "]";
        }
}


