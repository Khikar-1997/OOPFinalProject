package com.company.model.drink;

public abstract class Drink {
    //region Properties

    private String name;
    private int cast;

    //endregion

    //region Constructors

    public Drink(int cast) {
        this.cast = cast;
    }

    public Drink() {
    }

    //endregion

    //region Getter and Setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCast() {
        return cast;
    }

    public void setCast(int cast) {
        this.cast = cast;
    }

    //endregion

    //region toString Public Method

    @Override
    public String toString() {
        return ", cast=" + cast +
                '}';
    }

    //endregion
}
