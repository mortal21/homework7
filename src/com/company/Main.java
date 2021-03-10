package com.company;

import java.util.Scanner;

public class Main {
    public static void main(final String[] args) {
        boolean ruNameCheck = false;

        for (Country c : Country.values()) {
            System.out.println(c.toString());
        }

        Scanner scanner = new Scanner(System.in);
        String country = scanner.nextLine();

        try {
            Country realCountry = Country.valueOf(country);
            openOrClosedOutput(realCountry);
        } catch (NullPointerException npe) {
            System.out.println("Аргумент null"); // Если null, нет смысла проверять ruName
        } catch (IllegalArgumentException e) {
            ruNameCheck = true;
            System.out.println("Наименование страны на английском введено некорректно, проверяем русское название...");
        }

        if (ruNameCheck) {
            try {
                Country realCountry = Country.getByRuName(country);
                openOrClosedOutput(realCountry);
            } catch (NoSuchCountryException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    static void openOrClosedOutput(final Country realCountry) {
        if (realCountry.isOpen()) {
            System.out.println("Страна " + realCountry.toString() + " открыта для посещения.");
        } else {
            System.out.println("Страна " + realCountry.toString() + " закрыта для посещения.");
        }
    }
}