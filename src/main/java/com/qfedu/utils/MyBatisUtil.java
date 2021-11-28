package com.qfedu.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {
    private static SqlSessionFactory factory;
    private static final ThreadLocal<SqlSession> local = new ThreadLocal<SqlSession>();
    static{
        try{
            // 加载主配置文件,mybatis-config.xml
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            // 会话
            factory = builder.build(is);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static SqlSessionFactory getFactory(){
        return factory;
    }
    // 私有
    private static SqlSession getSqlSession(Boolean isAutoCommit){
        SqlSession sqlSession = local.get();
        if(sqlSession == null){
            // 通话SqlSessionFactory调用openSession方法获取SqlSession对象时,可以通过参数设置事务是否自动提交
            // 如果参数设置为true,表示自定提交事务：factory.openSession(true);
            // 如果参数设置为false,或者不设置参数,表示了手动提交:factory.openSession(); / factory.openSession(false);
            sqlSession = factory.openSession(isAutoCommit);
            local.set(sqlSession);
        }
        return sqlSession;
    }
    // 手动事务管理
    public static SqlSession getSqlSession(){
        return getSqlSession(false);
    }

    // 自动事务管理
    public static <T extends Object> T getMapper(Class<T> c){
        SqlSession sqlSession = getSqlSession(true);
        return sqlSession.getMapper(c);
    }
}
