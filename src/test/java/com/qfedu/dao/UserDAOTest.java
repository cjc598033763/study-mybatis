package com.qfedu.dao;


import com.qfedu.pojo.Detail;
import com.qfedu.pojo.User;
import com.qfedu.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserDAOTest {
    @Test
    public void testInsertUser() {
        User user = new User(0,"12312345","123124","张四","01.img",null);
        Detail detail = new Detail(0,"江西","88888888","我要成功一个优秀的人",0);
        SqlSession session = MyBatisUtil.getSqlSession();
        try {
            UserDAO userDAO = session.getMapper(UserDAO.class);
            int i = userDAO.insertUser(user);
            System.out.println(i);
            detail.setUid(user.getUserId());

            DetailDAO detailDAO = session.getMapper(DetailDAO.class);
            int j = detailDAO.insertDetail(detail);
            System.out.println(detailDAO);
            System.out.println(j);
            session.commit();
        }catch(Exception e){
            e.printStackTrace();
            session.rollback();
        }
    }
    @Test
    public void testQueryUser(){
        UserDAO userDAO = MyBatisUtil.getMapper(UserDAO.class);
        User user  = userDAO.queryUser("1231234");
        System.out.println(user);
    }






}