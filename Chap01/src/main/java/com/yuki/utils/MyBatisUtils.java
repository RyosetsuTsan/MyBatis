package com.yuki.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;

//工具类
//sqlSessionFactory → sqlSession
public class MyBatisUtils {
    private static SqlSessionFactory sqlSessionFactory;
    static {
        try {
            //使用mybatis第一步：获取sqlSessionFactory对象
            String resource= "mybatis_config_chap01.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //获取sqlSession实例
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }

    public static void main(String[] args) {
        System.out.println(sqlSessionFactory);
    }
}
