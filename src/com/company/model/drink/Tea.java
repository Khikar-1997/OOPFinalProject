package com.company.model.drink;

public class Tea extends Drink {
    //region Properties

    private int sugarQuantity;
    private int stick;
    private String grade;

    //endregion

    //region Constructors

    public Tea(int sugarQuantity, int stick) {
        if (stick == 1 || stick == 0) {
            this.stick = stick;
        } else {
            throw new RuntimeException("Choose one tea stick");
        }
        if (sugarQuantity >= 0) {
            this.sugarQuantity = sugarQuantity;
        } else {
            throw new RuntimeException("!!!!");
        }
        if (sugarQuantity == 0) {
            this.stick = 0;
        } else {
            this.stick = stick;
        }
    }

    public Tea(String grade, int cast) {
        super(cast);
        this.grade = grade;
    }

    public Tea() {
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
            throw new RuntimeException("Choose one tea stick");
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
        return "Tea{" +
                " grade='" + grade + super.toString() + '\'';
    }

    //endregion
}