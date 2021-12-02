package com.qfedu.dao;

import com.qfedu.pojo.Students;

import java.util.List;

public interface StudentsDAO {
    public List<Students> listStudentsByCid(int cid);
}
