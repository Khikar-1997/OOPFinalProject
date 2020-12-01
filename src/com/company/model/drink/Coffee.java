package com.company.model.drink;

public class Coffee extends Drink {
    //region Properties

    private int sugarQuantity;
    private int stick;
    private String grade;

    //endregion

    //region Constructors

    public Coffee(String name, int cast, int sugarQuantity, int stick) {
        if (sugarQuantity >= 0) {
            this.sugarQuantity = sugarQuantity;
        } else {
            throw new RuntimeException("!!!!");
        }
        if (stick == 1 || stick == 0) {
            this.stick = stick;
        } else {
            throw new RuntimeException("Choose one coffee stick.");
        }
    }

    public Coffee(int sugarQuantity, int stick) {
        if (sugarQuantity >= 0) {
            this.sugarQuantity = sugarQuantity;
        } else {
            throw new RuntimeException("!!!!");
        }
        if (stick == 1 || stick == 0) {
            this.stick = stick;
        } else {
            throw new RuntimeException("Choose one coffee stick.");
        }
        if (sugarQuantity == 0) {
            this.stick = 0;
        } else {
            this.stick = stick;
        }
    }

    public Coffee(String grade, int cast) {
        super(cast);
        this.grade = grade;
    }

    public Coffee() {
    }

    //endregion

    //region Getter and Setter

    public int getSugarQuantity() {
        return sugarQuantity;
    }

    public void setSugarQuantity(int sugarQuantity) {
        if (sugarQuantity >= 0) {
            this.sugarQuantity = sugarQuantity;
        } else {
            throw new RuntimeException("!!!!");
        }
    }

    public int getStick() {
        return stick;
    }

    public void setStick(int stick) {
        if (stick == 1 || stick == 0) {
            this.stick = stick;
        } else {
            throw new RuntimeException("Choose one coffee stick.");
        }
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    //endregion

    //region toString Public Method

    @Override
    public String toString() {
        return "Coffee{" +
                " grade='" + grade + super.toString() + '\'';
    }

    //endregion
}