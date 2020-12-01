package com.company.service;

import com.company.model.Command;

public class Converter {
    //region Public Methods

    public static Command convertInputCommand(String text) {
        Command command = new Command();
        String[] textArray = text.split(":");
        String textPart1 = textArray[0];
        String textPart2 = textArray[1];
        String textPart3 = textArray[2];
        command.setDrinkName(textPart1);
        command.setSugarQuantity(Integer.parseInt(textPart2));
        command.setStick(Integer.parseInt(textPart3));
        return command;
    }

    //endregion
}