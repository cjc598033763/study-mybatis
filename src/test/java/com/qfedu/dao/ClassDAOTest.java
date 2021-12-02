package com.qfedu.dao;

import com.qfedu.pojo.Clazz;
import com.qfedu.utils.MyBatisUtil;
import org.junit.Test;

public class ClassDAOTest {
    @Test
    public void testQueryClass(){
        ClazzDAO classDAO=MyBatisUtil.getMapper(ClazzDAO.class);
        Clazz clazz = classDAO.queryClazz(1);
        System.out.println(clazz);
    }
}
