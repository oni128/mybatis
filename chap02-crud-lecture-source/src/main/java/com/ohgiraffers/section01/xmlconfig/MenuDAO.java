package com.ohgiraffers.section01.xmlconfig;

import java.util.List;
import org.apache.ibatis.session.SqlSession;

public class MenuDAO {
    public List<MenuDTO> selectAllMenus(SqlSession sqlSession) {
        return sqlSession.selectList("MenuMapper.selectAllMenus");
        /* MenuMapper에 있는 selectAllMenus를 가져와서 리스트로 내보내줘 (?) */
    }

    public MenuDTO selectMenuByMenuCode(SqlSession sqlSession, int menuCode) {
        return sqlSession.selectOne("MenuMapper.selectMenu", menuCode);
    }

    public int insertMenu(SqlSession sqlSession, MenuDTO menu) {
        return sqlSession.insert("MenuMapper.insertMenu", menu);
    }

    public int updateMenu(SqlSession sqlSession, MenuDTO menu) {
        return sqlSession.update("MenuMapper.updateMenu", menu);
    }

    public int deleteMenu(SqlSession sqlSession, int menuCode) {
        return sqlSession.delete("MenuMapper.deleteMenu", menuCode);
    }
}
