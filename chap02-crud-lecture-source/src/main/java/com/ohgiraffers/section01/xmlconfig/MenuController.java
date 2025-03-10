package com.ohgiraffers.section01.xmlconfig;


import java.lang.reflect.Parameter;
import java.util.List;
import java.util.Map;

public class MenuController {
    private final MenuService menuService;
    private final PrintResult printResult;

    public MenuController() {
        menuService = new MenuService();
        printResult = new PrintResult();
    }

    public void findAllMenus() {
        List<MenuDTO> menuList = menuService.findAllMenus();
//        System.out.println("===== Controller에서 출력");
//        menuList.forEach(System.out::println);
        // !객체는 있는데 비어있어?  -> 다중행 조회가 성공했어?
        // 우리가 모델에 담을 재료가 이거 아님 저거야
        if (!menuList.isEmpty()){       // 조회 성공
            printResult.printMenus(menuList);
        } else {                        // 조회 실패
            printResult.printErrorMessage("전체 메뉴 조회 실패!");
        }
    }

    public void findMenuByMenuCode(Map<String, String> parameter) {
        int menuCode = Integer.parseInt(parameter.get("menuCode"));

        MenuDTO menu = menuService.findMenuByMenuCode(menuCode);

        if (menu != null) {
            printResult.printMenu(menu);
        } else {
            printResult.printErrorMessage(menuCode + "번의 메뉴는 없습니다.");
        }
    }

    public void registMenu(Map<String, String> parameter) {
        String menuName = parameter.get("menuName");
        int menuPrice = Integer.parseInt(parameter.get("menuPrice"));
        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));

        MenuDTO menu = new MenuDTO();
        menu.setMenuName(menuName);
        menu.setMenuPrice(menuPrice);
        menu.setCategoryCode(categoryCode);

        if (menuService.registMenu(menu)){
            printResult.printSuccessMessage("regist");
        } else {
            printResult.printErrorMessage("메뉴 추가 실패!");
        }
    }

    public void modifyMenu(Map<String, String> parameter) {
        int menuCode = Integer.parseInt(parameter.get("menuCode"));
        String menuName = parameter.get("menuName");
        int menuPrice = Integer.parseInt(parameter.get("menuPrice"));

        MenuDTO menu = new MenuDTO();
        menu.setMenuCode(menuCode);
        menu.setMenuName(menuName);
        menu.setMenuPrice(menuPrice);

        if (menuService.modifyMenu(menu)){
            printResult.printSuccessMessage("modify");
        } else {
            printResult.printErrorMessage("메뉴 수정 실패!");
        }
    }

    public void removeMenu(Map<String, String> parameter) {
        int menuCode = Integer.parseInt(parameter.get("menuCode"));

        if (menuService.removeMenu(menuCode)) {
            printResult.printSuccessMessage("remove");
        } else {
            printResult.printErrorMessage("메뉴 삭제 실패!");
        }
    }
}
