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
        new Student();
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory  = builder.build(is);

        SqlSession sqlSession = factory.openSession();

        StudentDAO studentDAO = sqlSession.getMapper(StudentDAO.class);
        int i = studentDAO.insertStudent(new Student(0,"10001","张三","男的",1));
        System.out.println(i);


    }

    @org.junit.Test
    public void deleteStudent(){

    }

}