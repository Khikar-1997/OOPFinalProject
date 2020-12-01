package com.company.service;

import com.company.model.user.User;

import java.util.Scanner;

public class MenuService {
    public static void createMenu() {
        User user = new User();

        int num;
        do {
            System.out.println("______________CoffeeMachine_____________");
            System.out.println("                Menu                 ");
            System.out.println("   press 1 for create User           ");
            System.out.println("   press 2 for create drink          ");
            System.out.println("   press 3 to choosing drink        ");
            System.out.println("   press 4 exit    ");
            System.out.println("________________________________________");

            Scanner scanner = new Scanner(System.in);
            num = scanner.nextInt();
            String test = scanner.nextLine();
            switch (num) {
                case 1:
                    UserService.userMenu();
                    break;
                case 2:
                    CoffeeMachineService.coffeeMachineMenu();
                    break;
                case 3:
                    CoffeeMachineService.drinkChoosingMenu();
                    break;
                case 4:
                    System.out.println("I wish you have a good day");
                    break;
                default:
                    System.out.println("Please write valid order");
            }

        } while (num != 4);
    }
}
