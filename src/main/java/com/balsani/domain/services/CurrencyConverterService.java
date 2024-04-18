package com.balsani.domain.services;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class CurrencyConverterService {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/182a0708d95b2e08e0e84e44/latest/";

    public static void convertCurrency(String from, String to) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL + from))
                    .build();

            String response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
            JsonObject rates = new Gson().fromJson(response, JsonObject.class).getAsJsonObject("conversion_rates");

            System.out.println("Digite o valor que deseja converter:");
            BigDecimal value = SCANNER.nextBigDecimal();

            BigDecimal rate = rates.get(to).getAsBigDecimal();
            BigDecimal result = value.multiply(rate);

            System.out.printf("O valor convertido de %s para %s é: %.2f%n", from, to, result);
        } catch (Exception e) {
            System.out.println("Erro ao converter moeda: " + e.getMessage());
        }
    }
}