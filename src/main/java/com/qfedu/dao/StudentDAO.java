package com.qfedu.dao;

import com.qfedu.pojo.Student;

public interface StudentDAO {
    public int insertStudent(Student student);
    public int deleteStudent(String stuNum);
}
