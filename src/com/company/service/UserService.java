package com.company.service;

import com.company.model.user.User;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class UserService {
    public static final String FILE = "User.txt";

    public static String[][] readUserInfoFromFile() {
        Scanner scanner;
        File file = new File(FILE);
        int count = 0;

        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                count++;
            }

            scanner = new Scanner(file);
            String[][] studentInfo = new String[count][];
            for (int i = 0; i < studentInfo.length; i++) {
                String newLine = scanner.nextLine();
                studentInfo[i] = newLine.split(",");
            }

            return studentInfo;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static User[] createUser(String[][] userInfo) {
        User[] users = new User[userInfo.length];

        for (int i = 0; i < userInfo.length; i++) {
            String name = userInfo[i][0];
            int money = Integer.parseInt(userInfo[i][1]);
            User user = new User(name, money);
            users[i] = user;
        }
        return users;
    }

    public static User userWhoCanDrink(User[] users, String name){
        User user1 = new User();
        for (User user : users) {
            if (user.getName().contains(name)) {
                user1 = user;
            }
        }
        return user1;
    }


    private void writeUserInfoInFile(User user) throws IOException {
        if (!(new File(FILE).isFile())) {
            new PrintWriter(FILE, StandardCharsets.UTF_8);
        }
        String userinfo = user.getName() + "," + user.getMoney() + "\n";
        Files.write(Paths.get(FILE), userinfo.getBytes(), StandardOpenOption.APPEND);
    }

    public static void userMenu() {
        UserService userService = new UserService();
        User user = new User();
        int num;
        do {
            System.out.println("____________________________________");
            System.out.println("              Users           ");
            System.out.println("   Press 1 to create User     ");
            System.out.println("   Press 2 to print all Users ");
            System.out.println("   Press 3 to return general menu");
            System.out.println("____________________________________");

            Scanner scanner = new Scanner(System.in);
            num = scanner.nextInt();
            String test = scanner.nextLine();
            switch (num) {
                case 1:
                    try {
                        System.out.println("Please input user name");
                        String name = scanner.next();
                        System.out.println("Please input user money");
                        int money = scanner.nextInt();
                        user.setName(name);
                        user.setMoney(money);
                        userService.writeUserInfoInFile(user);
                    } catch (IOException e){
                        e.getStackTrace();
                    }
                    break;
                case 2:
                    User[] users = UserService.createUser(UserService.readUserInfoFromFile());
                    System.out.println("______________All Users_____________");
                    for (User value : users) {
                        System.out.println(value.toString());
                    }
                    System.out.println("____________________________________");
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Please write valid order");
            }
        } while (num != 3);
    }
}
