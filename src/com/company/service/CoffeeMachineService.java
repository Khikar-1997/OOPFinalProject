package com.company.service;

import com.company.exceptions.CommandNotFindException;
import com.company.model.Command;
import com.company.exceptions.DoNotHaveMuchMoneyException;
import com.company.model.drink.Coffee;
import com.company.model.drink.Drink;
import com.company.model.drink.Tea;
import com.company.model.user.User;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class CoffeeMachineService {
    public static final String FILE = "tea.txt";
    public static final String FILE1 = "Coffee.txt";


    //region Public Methods

    public Drink makeDrink(Command command) {
        if (command.getDrinkName().equals("C")) {
            return new Coffee(command.getSugarQuantity(), command.getStick());
        } else if (command.getDrinkName().equals("T")) {
            return new Tea(command.getSugarQuantity(), command.getStick());
        } else {
            throw new CommandNotFindException("This is invalid command. Please reload program.");
        }
    }

    public boolean buyDrink(int changeStuff) {
        if (changeStuff >= 0) {
            return true;
        } else {
            throw new DoNotHaveMuchMoneyException("You don't have that much money");
        }
    }

    public int changeStuff(int drinkCast, int userMoney) {
        return userMoney - drinkCast;
    }

    public void printChangeStuff(int changeStuff) {
        System.out.println("Your change " + changeStuff + ".");
    }

    public void printCoffeeMachineProduct(boolean buyDrink, Drink drink) {
        if (buyDrink) {
            System.out.println(drink.toString());
        }
    }

    private String[][] read(String filePath) {
        Scanner scanner;
        File file = new File(filePath);
        int count = 0;

        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                count++;
            }

            scanner = new Scanner(file);
            String[][] castInfo = new String[count][];
            for (int i = 0; i < castInfo.length; i++) {
                String newLine = scanner.nextLine();
                castInfo[i] = newLine.split(",");
            }

            return castInfo;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private Coffee[] createCoffee(String[][] info) {
        Coffee[] coffees = new Coffee[info.length];

        for (int i = 0; i < info.length; i++) {
            String grade = info[i][0];
            int cast = Integer.parseInt(info[i][1]);
            Coffee coffee = new Coffee(grade, cast);
            coffees[i] = coffee;
        }
        return coffees;
    }

    private Tea[] createTea(String[][] info) {
        Tea[] teas = new Tea[info.length];

        for (int i = 0; i < info.length; i++) {
            String grade = info[i][0];
            int cast = Integer.parseInt(info[i][1]);
            Tea tea = new Tea(grade, cast);
            teas[i] = tea;
        }
        return teas;
    }

    private void writeTeaInfoInFile(Tea tea) throws IOException {
        if (!(new File(FILE).isFile())) {
            new PrintWriter(FILE, StandardCharsets.UTF_8);
        }
        String teaInfo = tea.getGrade() + "," + tea.getCast() + "\n";
        Files.write(Paths.get(FILE), teaInfo.getBytes(), StandardOpenOption.APPEND);
    }

    private void writeCoffeeInfoInFile(Coffee coffee) throws IOException {
        if (!(new File(FILE1).isFile())) {
            new PrintWriter(FILE1, StandardCharsets.UTF_8);
        }
        String teaInfo = coffee.getGrade() + "," + coffee.getCast() + "\n";
        Files.write(Paths.get(FILE1), teaInfo.getBytes(), StandardOpenOption.APPEND);
    }

    public static void coffeeMachineMenu() {
        CoffeeMachineService coffeeMachineService = new CoffeeMachineService();
        Coffee coffee = new Coffee();
        Tea tea = new Tea();
        int num;
        do {
            System.out.println("_____________________________________");
            System.out.println("          Create drink      ");
            System.out.println("   Press 1 to create Tea      ");
            System.out.println("   Press 2 to create Coffee   ");
            System.out.println("   Press 3 to see all tea grades");
            System.out.println("   Press 4 to see all coffee grades");
            System.out.println("   Press 5 to return general menu     ");
            System.out.println("_____________________________________");

            Scanner scanner = new Scanner(System.in);
            num = scanner.nextInt();
            String test = scanner.nextLine();
            switch (num) {
                case 1:
                    try {
                        System.out.println("Please input tea grade");
                        String grade = scanner.next();
                        System.out.println("Please input tea cast");
                        int cast = scanner.nextInt();
                        tea.setGrade(grade);
                        tea.setCast(cast);
                        coffeeMachineService.writeTeaInfoInFile(tea);
                    } catch (IOException e) {
                        e.getStackTrace();
                    }
                    break;
                case 2:
                    try {
                        System.out.println("Please input coffee grade");
                        String grade = scanner.next();
                        System.out.println("Please input coffee cast");
                        int cast = scanner.nextInt();
                        coffee.setGrade(grade);
                        coffee.setCast(cast);
                        coffeeMachineService.writeCoffeeInfoInFile(coffee);
                    } catch (IOException e) {
                        e.getStackTrace();
                    }
                    break;
                case 3:
                    Tea[] teas = coffeeMachineService.createTea(coffeeMachineService.read(FILE));
                    System.out.println("______________All Teas grades_____________");
                    for (Tea tea1 : teas) {
                        System.out.println(tea1.toString());
                    }
                    System.out.println("__________________________________________");
                    break;
                case 4:
                    Coffee[] coffees = coffeeMachineService.createCoffee(coffeeMachineService.read(FILE1));
                    System.out.println("______________All Coffee grades_____________");
                    for (Coffee coffee1 : coffees) {
                        System.out.println(coffee1.toString());
                    }
                    System.out.println("____________________________________________");
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Please write valid order");
            }
        } while (num != 5);

    }

    private Coffee choosingCoffee(Coffee[] coffees, String grade){
        Coffee coffee = new Coffee();
        for (Coffee coffee1 : coffees) {
            if (coffee1.getGrade().contains(grade)) {
                coffee = coffee1;
            }
        }
        return coffee;
    }

    private Tea choosingTea(Tea[] teas, String grade){
        Tea tea = new Tea();
        for (Tea tea1 : teas) {
            if (tea1.getGrade().contains(grade)) {
                tea = tea1;
            }
        }
        return tea;
    }

    public static void drinkChoosingMenu() {
        CoffeeMachineService coffeeMachineService = new CoffeeMachineService();

        int num;
        do {
            System.out.println("_____________________________________");
            System.out.println("             Choose Drink      ");
            System.out.println("   Press 1 to choose Tea      ");
            System.out.println("   Press 2 to choose Coffee   ");
            System.out.println("   Press 3 to see all teas grades");
            System.out.println("   Press 4 to see all teas grades");
            System.out.println("   Press 5 to return general menu     ");
            System.out.println("_____________________________________");

            Scanner scanner = new Scanner(System.in);
            num = scanner.nextInt();
            String test = scanner.nextLine();
            switch (num) {
                case 1:
                    System.out.println("Please input command by this 'Tea(only first char):sugar quantity(int):stick(int)'");
                    String commandLine = scanner.nextLine();
                    Command command = Converter.convertInputCommand(commandLine);
                    System.out.println("Please input user name");
                    String userName = scanner.next();
                    User u = UserService.userWhoCanDrink(UserService.createUser(UserService.readUserInfoFromFile()),userName);
                    System.out.println("Please input tea grade");
                    String teaGrade = scanner.next();
                    Tea tea = coffeeMachineService.choosingTea(coffeeMachineService.createTea(coffeeMachineService.read(FILE)),teaGrade);
                    int changeStuff = coffeeMachineService.changeStuff(tea.getCast(),u.getMoney());
                    coffeeMachineService.printChangeStuff(changeStuff);
                    coffeeMachineService.printCoffeeMachineProduct(coffeeMachineService.buyDrink(changeStuff),coffeeMachineService.makeDrink(command));
                    break;
                case 2:
                    System.out.println("Please input command by this 'Coffee(only first char):sugar quantity(int):stick(int)'");
                    String commandLine1 = scanner.nextLine();
                    Command command1 = Converter.convertInputCommand(commandLine1);
                    System.out.println("Please input user name");
                    String userName1 = scanner.next();
                    User user = UserService.userWhoCanDrink(UserService.createUser(UserService.readUserInfoFromFile()),userName1);
                    System.out.println("Please input coffee grade");
                    String coffeeGrade = scanner.next();
                    Coffee coffee = coffeeMachineService.choosingCoffee(coffeeMachineService.createCoffee(coffeeMachineService.read(FILE1)),coffeeGrade);
                    coffeeMachineService.printChangeStuff(coffeeMachineService.changeStuff(coffee.getCast(),user.getMoney()));
                    break;
                case 3:
                    Tea[] teas = coffeeMachineService.createTea(coffeeMachineService.read(FILE));
                    System.out.println("______________All Teas grades_____________");
                    for (Tea tea1 : teas) {
                        System.out.println(tea1.toString());
                    }
                    System.out.println("__________________________________________");
                    break;
                case 4:
                    Coffee[] coffees = coffeeMachineService.createCoffee(coffeeMachineService.read(FILE1));
                    System.out.println("______________All Coffee grades_____________");
                    for (Coffee coffee1 : coffees) {
                        System.out.println(coffee1.toString());
                    }
                    System.out.println("____________________________________________");
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Please write valid order");
            }
        } while (num != 5);
    }
}