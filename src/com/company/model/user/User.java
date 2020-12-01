package com.company.model.user;

public class User extends Human {
    //region Properties

    private int money;

    //endregion

    //region Constructors

    public User(String name, int money) {
        super(name);
        this.money = money;
    }

    public User() {
    }

    //endregion

    //region Getter and Setter

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    //endregion

    //region toString Public Method

    @Override
    public String toString() {
        return "User{" +
                "name: = '" + name + '\''
                + ",money: = " + money +
                '}';
    }

    //endregion
}