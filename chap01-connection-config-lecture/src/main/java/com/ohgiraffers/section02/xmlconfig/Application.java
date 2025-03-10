package com.ohgiraffers.section02.xmlconfig;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Application {
    public static void main(String[] args) {

        String resource = "mybatis-config.xml";

        SqlSession session = null;
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);

            SqlSessionFactory sqlSessionFactory =
                    new SqlSessionFactoryBuilder().build(inputStream);
            session = sqlSessionFactory.openSession(false); // sqlSession 사물함이 아닌 객체임.

            java.util.Date date = session.selectOne("mapper.selectNow"); /*이름으로 호출*/
            System.out.println("date = " + date);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
    }
}