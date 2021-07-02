package com.rgnews;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class test {

    public static void main(String[] args) throws IOException {

        //mybatis的配置文件
//        String resource = "newsConf.xml";
        String resource = "conf.xml";

        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = Resources.getResourceAsStream(resource);

        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource);
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();
        /**
         * 映射sql的标识字符串，
         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */

//        /* 根据——key查找 */
//        String statement = "com.springtest.mapping.NewsMapper.getNewsById";
//                newsDo news = session.selectOne(statement,2);
//                System.out.println(news);


        String statement = "com.woodmoon.newsCenter.mapper.NewsMapper.getAllNews";
        List newsList = new ArrayList();
        newsList=    session.selectList(statement);

//        List  newsList = session.selectList(statement);
        for(int i=0;i<newsList.size();i++) {
            System.out.println(newsList.get(i)); }
    }

}
