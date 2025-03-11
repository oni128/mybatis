package com.ohgiraffers.section01.xml;

import static com.ohgiraffers.section01.xml.Template.getSqlSession;

import java.util.List;
import org.apache.ibatis.session.SqlSession;

public class MenuService {
    public void findMenuByPrice(int maxPrice) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper mapper = sqlSession.getMapper(MenuMapper.class); // 타입을 넣으면 하위 구현체 뱉어줌

        List<MenuDTO> menus = mapper.selectMenuByPrice(maxPrice); // DAO이자 mapper
        System.out.println("===== Service Layer");
        menus.forEach(System.out::println);
        sqlSession.close();
    }
}
