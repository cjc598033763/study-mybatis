package qfedu.dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qfedu.dao.StudentDAO;
import com.qfedu.pojo.Student;
import com.qfedu.utils.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

public class StudentDAOTest {
    @org.junit.Test
    public void insertStudent() throws Exception {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        //1,当我们获取sqlSession 对象时，就默认开启了事务
        try{
        // 通过会话获取DAO对象
        StudentDAO studentDAO = sqlSession.getMapper(StudentDAO.class);
        Student student = new Student(10,"10020","张三","男的",1);
        // 测试StudentDAO中的方法
        int i = studentDAO.insertStudent(student);
        System.out.println(student);
        // 操作1
        // 操作2
        // 操作3
        // 2.操作完成并成功之后,需要手动提交,一般手动提交都有多个步骤
        sqlSession.commit();
        System.out.println(i);
        }catch(Exception e){

        // 3.当操作出现异常,调用rollback进行回滚
            sqlSession.rollback();
            throw new Exception("出现报错");
        }


    }

    @org.junit.Test
    public void deleteStudent(){
                StudentDAO studentDAO= MyBatisUtil.getMapper(StudentDAO.class);
                int i = studentDAO.deleteStudent("10004");
                System.out.println(i);
            }

    @org.junit.Test
    public void updateStudent(){
        // 通过SqlSession 通过调用getMapper方法获取DAO接口对象
        StudentDAO studentDAO = MyBatisUtil.getMapper(StudentDAO.class);
        int i = studentDAO.updateStudent(new Student(2,"10007","张三","男的",1));
        System.out.println(i);
    }
    @org.junit.Test
    public void testSelectStudent(){
        try {
            InputStream is = null;
            is = Resources.getResourceAsStream("mybatis-config.xml");
            //
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            // SqlSessionFactory 表示MyBatis的会话工厂
            SqlSessionFactory factory = builder.build(is);
            // SqlSession 表示MyBatis 与 数据库之间的会话，通过工厂方法设计模式
            SqlSession sqlSession = factory.openSession();
            // 通过SqlSession 通过调用getMapper方法获取DAO接口对象
            StudentDAO studentDAO = sqlSession.getMapper(StudentDAO.class);
            List<Student> student = studentDAO.listStudents();
            for (Student s: student
                 ) {
                System.out.println(s.toString());

            }
            sqlSession.commit();
            System.out.println(student);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @org.junit.Test
    public void testSelectStudent2(){

        StudentDAO studentDAO = MyBatisUtil.getMapper(StudentDAO.class);
        PageHelper.startPage(1,3);
        List<Student>students = studentDAO.listStudents();
        PageInfo<Student> pageInfo = new PageInfo<Student>(students);
        //  pageInfo就包含了数据及分页信息
        List<Student> list = pageInfo.getList();
        for (Student s: list
             ) {
            System.out.println(s);
        }


    }
    @org.junit.Test
    public void testSelectStudentByQuery(){
        try {
            InputStream is = null;
            is = Resources.getResourceAsStream("mybatis-config.xml");
            //
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            // SqlSessionFactory 表示MyBatis的会话工厂
            SqlSessionFactory factory = builder.build(is);
            // SqlSession 表示MyBatis 与 数据库之间的会话，通过工厂方法设计模式
            SqlSession sqlSession = factory.openSession();
            // 通过SqlSession 通过调用getMapper方法获取DAO接口对象
            StudentDAO studentDAO = sqlSession.getMapper(StudentDAO.class);
            List<Student> student = studentDAO.listStudentsByPage(0,1);
            for (Student s: student
            ) {
                System.out.println(s.toString());

            }
            sqlSession.commit();
            System.out.println(student);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @org.junit.Test
    public void testSelectStudentByCount(){
        try {
            InputStream is = null;
            is = Resources.getResourceAsStream("mybatis-config.xml");
            //
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            // SqlSessionFactory 表示MyBatis的会话工厂
            SqlSessionFactory factory = builder.build(is);
            // SqlSession 表示MyBatis 与 数据库之间的会话，通过工厂方法设计模式
            SqlSession sqlSession = factory.openSession();
            // 通过SqlSession 通过调用getMapper方法获取DAO接口对象
            StudentDAO studentDAO = sqlSession.getMapper(StudentDAO.class);
            int i  = studentDAO.getCount();
            System.out.println(i);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    }

