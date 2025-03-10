package com.ohgiraffers.section01.xmlconfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.ResourceBundle;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
    private static SqlSessionFactory sqlSessionFactory;
    // 싱글톤 패턴을 채택한 팩토리 방식?
    public static SqlSession getSqlSession() {
        if (sqlSessionFactory == null) {
            // lazy singleton 방식 채택, xml을 stream타입으로 불러와서  ~?
            String resource = "com/ohgiraffers/section01/xmlconfig/mybatis-config.xml";

            try {
                InputStream inputStream = Resources.getResourceAsStream(resource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return sqlSessionFactory.openSession();
    }
}
