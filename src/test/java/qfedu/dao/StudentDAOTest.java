package qfedu.dao;

import com.qfedu.dao.StudentDAO;
import com.qfedu.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

public class StudentDAOTest {
    @org.junit.Test
    public void insertStudent() throws IOException {
        // 加载mybatis配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 会话工厂
        SqlSessionFactory factory  = builder.build(is);
        // 会话（连接）
        SqlSession sqlSession = factory.openSession();
        // 通过会话获取DAO对象
        StudentDAO studentDAO = sqlSession.getMapper(StudentDAO.class);
        // 测试StudentDAO中的方法
        int i = studentDAO.insertStudent(new Student(3,"10004","张三","男的",1));
        // 需要手动提交
        sqlSession.commit();
        System.out.println(i);


    }

    @org.junit.Test
    public void deleteStudent(){
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
                int i = studentDAO.deleteStudent("10001");
                sqlSession.commit();
                System.out.println(i);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    @org.junit.Test
    public void updateStudent(){
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
            int i = studentDAO.updateStudent(new Student(0,"10004","张三","男的",1));
            sqlSession.commit();
            System.out.println(i);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    }

