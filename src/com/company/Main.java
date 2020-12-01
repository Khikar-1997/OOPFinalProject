package com.company;

import com.company.service.CoffeeMachineService;
import com.company.service.MenuService;

public class Main {

    public static void main(String[] args) {
//        UserService userService = new UserService();
//        User user = new User("j",9);
//
//        UserService.userMenu();
//        User u = UserService.userWhoCanDrink(UserService.createUser(UserService.readUserInfoFromFile()),"vaxo");
//        System.out.println(u.getName());

        MenuService.createMenu();
    }
}
