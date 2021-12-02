package com.qfedu.dao;

import com.qfedu.pojo.Clazz;

public interface ClazzDAO {
    /**
     * 根据班级编号，查询班级信息
     * */
    public Clazz queryClazz(int classId);
}
