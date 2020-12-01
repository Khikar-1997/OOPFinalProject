package com.company.model.user;

public abstract class Human {
    //region Properties

    public String name;

    //endregion

    //region Constructors

    public Human(String name) {
        this.name = name;
    }

    public Human() {
    }

    //endregion

    //region Getter and Setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //endregion

    //region toString Public Method

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                '}';
    }

    //endregion
}
