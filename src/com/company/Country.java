package com.company;

enum Country {
    RUSSIA("Россия", true), USA("США", false), CANADA("Канада", true);
    private final String ruName;
    private final boolean isOpen;

    Country(final String ruName, final boolean isOpen) {
        this.ruName = ruName;
        this.isOpen = isOpen;
    }

    boolean isOpen() {
        return isOpen;
    }

    @Override
    public String toString() {
        return name() + " (" + ruName + ")";
    }

    static Country getByRuName(final String ruName) throws NoSuchCountryException {
        for (Country c : values()) {
            if (c.ruName.equals(ruName)) {
                return c;
            }
        }
        throw new NoSuchCountryException("Страны " + ruName + " не существует.");
    }
}