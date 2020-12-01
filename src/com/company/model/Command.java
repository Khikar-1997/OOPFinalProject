package com.company.model;

public class Command {
    //region Properties

    private String drinkName;
    private int sugarQuantity;
    private int stick;

    //endregion

    //region Constructors

    public Command(String drinkName, int sugarQuantity, int stick) {
        this.drinkName = drinkName;
        this.sugarQuantity = sugarQuantity;
        this.stick = stick;
    }

    public Command() {
    }

    //endregion

    //region Getter and Setter

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public int getSugarQuantity() {
        return sugarQuantity;
    }

    public void setSugarQuantity(int sugarQuantity) {
        this.sugarQuantity = sugarQuantity;
    }

    public int getStick() {
        return stick;
    }

    public void setStick(int stick) {
        this.stick = stick;
    }

    //endregion

    //region toString Public Method

    @Override
    public String toString() {
        return "Command{" +
                "drinkName='" + drinkName + '\'' +
                ", sugarQuantity=" + sugarQuantity +
                ", coffeeStick=" + stick +
                '}';
    }

    //endregion
}
