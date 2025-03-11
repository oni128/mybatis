package com.ohgiraffers.section01.xmlmapper;

import static com.ohgiraffers.section01.xmlmapper.Template.getSqlSession;

import java.util.List;
import org.apache.ibatis.session.SqlSession;

public class ElementService {
    public void selectResultMapTest() {
        SqlSession sqlSession = getSqlSession();
        ElementMapper mapper = sqlSession.getMapper(ElementMapper.class);

        /*다중행 조회*/
        List<MenuDTO> menus = mapper.selectResultMapTest();
        menus.forEach(System.out::println);

        sqlSession.close();
    }

    public void selectResultMapAssociationTest() {
    }
}
