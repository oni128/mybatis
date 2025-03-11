package com.ohgiraffers.section01.xml;

import static com.ohgiraffers.section01.xml.Template.getSqlSession;

import java.util.List;
import java.util.Map;
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

    public void searchMenu(SearchCriteria searchCriteria) {
        SqlSession sqlsession = getSqlSession();
        // 인터페이스의 하위구현체를 주세요 - DAO계층에 있는 메소드 호출?
        MenuMapper mapper = sqlsession.getMapper(MenuMapper.class);
        List<MenuDTO> menus = mapper.searchMenu(searchCriteria); // 다중행 조회가 가능
        // 인터페이스에 추상메소드가 생긴다? searchCriteria라는
        System.out.println("===== Service Layer");
        menus.forEach(System.out::println);

        sqlsession.close();
    }

    public void searchMenuBySupCategory(SearchCriteria searchCriteria) {
        SqlSession sqlsession = getSqlSession();
        MenuMapper mapper = sqlsession.getMapper(MenuMapper.class);

        List<MenuDTO> menus = mapper.searchMenuBySupCategory(searchCriteria);
        System.out.println("===== Service Layer");
        menus.forEach(System.out::println);

        sqlsession.close();
    }

    public void searchMenuByRandomMenuCode(List<Integer> randomList) {
        SqlSession sqlsession = getSqlSession();
        MenuMapper mapper = sqlsession.getMapper(MenuMapper.class);

        List<MenuDTO> menus = mapper.searchMenuByRandomMenuCode(randomList);
        System.out.println("===== Service Layer");
        menus.forEach(System.out::println);

        sqlsession.close();
    }

    public void searchMenuByCodeOrSearchAll(SearchCriteria searchCriteria) {
        SqlSession sqlsession = getSqlSession();
        MenuMapper mapper = sqlsession.getMapper(MenuMapper.class);

        List<MenuDTO> menus = mapper.searchMenuByCodeOrSearchAll(searchCriteria);
        System.out.println("===== Service Layer");
        menus.forEach(System.out::println);

        sqlsession.close();
    }

    public void searchMenuByNameOrCategory(Map<String, Object> criteria) {
        SqlSession sqlsession = getSqlSession();
        MenuMapper mapper = sqlsession.getMapper(MenuMapper.class);

        List<MenuDTO> menus = mapper.searchMenuByNameOrCategory(criteria);
        System.out.println("===== Service Layer");
        menus.forEach(System.out::println);

        sqlsession.close();
    }
}
