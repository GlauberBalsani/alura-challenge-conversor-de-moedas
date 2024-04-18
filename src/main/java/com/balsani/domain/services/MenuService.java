package com.balsani.domain.services;

import java.util.Scanner;

public class MenuService {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static int showMenu() {
        System.out.println("""
                Seja Bem vindo/a ao Conversor de Moedas =]
                
                1 - Dólar =>> Peso Argentino
                2 - Peso Argentino =>> Dólar 
                3 - Dólar =>> Real Brasileiro
                4 - Real Brasileiro =>> Dólar
                5 - Dólar =>> Peso Colombiano
                6 - Peso Colombiano =>> Dólar 
                7 - Sair
                """);
        return SCANNER.nextInt();
    }

    public static String getCurrencyPair(int option) {
        return switch (option) {
            case 1 -> "USD-ARS";
            case 2 -> "ARS-USD";
            case 3 -> "USD-BRL";
            case 4 -> "BRL-USD";
            case 5 -> "USD-COP";
            case 6 -> "COP-USD";
            default -> "";
        };
    }
}
