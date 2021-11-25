package com.qfedu.dao;

import com.qfedu.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
// 在MyBatis 进行条件查询操作
// 1.如果操作方法只有一个简单类型或者字符串类型的参数，在Mapper配置中可以直接通过#{key}直接获取
// 2.如果操作方法有一个对象类型的参数，在Mapper配置中可以直接通过#{attrName}获取对象的指定属性值（attName 必须是参数对象的属性）
// 3，如果操作方法有一个Map类型的参数，在Mapper配置中可以直接通过${key} 获得key对应的value

public interface StudentDAO {
    public int insertStudent(Student student);
    public int deleteStudent(String stuNum);
    public int updateStudent(Student student);
    public List<Student> listStudents();
    public Student queryStudent(String stuNum);
    public List<Student> listStudentsByPage(@Param("start")int start, @Param("pageSize")int PageSize);
    public int getCount();
}
