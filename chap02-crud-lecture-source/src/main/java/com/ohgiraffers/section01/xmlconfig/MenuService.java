package com.ohgiraffers.section01.xmlconfig;

import static com.ohgiraffers.section01.xmlconfig.Template.getSqlSession;

import java.util.List;
import org.apache.ibatis.session.SqlSession;

public class MenuService {
    private final MenuDAO menuDAO;

    public MenuService() {
        menuDAO = new MenuDAO();
    }

    public List<MenuDTO> findAllMenus() {
        SqlSession sqlSession = getSqlSession();

        List<MenuDTO> menuList = menuDAO.selectAllMenus(sqlSession);

        sqlSession.close();

        return menuList;
    }

    public MenuDTO findMenuByMenuCode(int menuCode) {
        // 전역으로 빼면안됨. 요청당 메소드가 따로 실행되기 때문에
        SqlSession sqlSession = getSqlSession();

        MenuDTO menu = menuDAO.selectMenuByMenuCode(sqlSession, menuCode);

        sqlSession.close();

        return menu;
    }

    public boolean registMenu(MenuDTO menu) {
        SqlSession sqlSession = getSqlSession();

        int result = menuDAO.insertMenu(sqlSession, menu);

        /* 설명. 성공 실패에 따라 트랜잭션 처리(commit/rollback) */
        if (result == 1) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result == 1? true : false;
    }

    public boolean modifyMenu(MenuDTO menu) {
        SqlSession sqlSession = getSqlSession();

        int result = menuDAO.updateMenu(sqlSession, menu);

        /* 설명. 성공 실패에 따라 트랜잭션 처리(commit/rollback) */
        if (result == 1 ) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result == 1? true : false;
    }

    public boolean removeMenu(int menuCode) {
        SqlSession sqlSession = getSqlSession();

        int result = menuDAO.deleteMenu(sqlSession, menuCode);

        /* 설명. 성공 실패에 따라 트랜잭션 처리(commit/rollback) */
        if (result == 1 ) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result == 1? true : false;
    }
}
