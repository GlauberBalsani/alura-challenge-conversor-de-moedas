package com.balsani;

import com.balsani.domain.services.ConverterService;
import com.balsani.domain.services.MenuService;


public class App {
    public static void main(String[] args) {
        int option;
        do {
            option = MenuService.showMenu();
            String currencyPair = MenuService.getCurrencyPair(option);
            if (!currencyPair.isEmpty()) {
                String[] currencies = currencyPair.split("-");
                ConverterService.convertCurrency(currencies[0], currencies[1]);
            }
        } while (option != 7);
    }
}
