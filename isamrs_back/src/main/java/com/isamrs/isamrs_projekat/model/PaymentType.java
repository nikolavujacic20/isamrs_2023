package com.isamrs.isamrs_projekat.model;

public enum PaymentType {
    CREDIT_CARD("kartica"),
    PAYPAL("paypal"),
    BITCOIN("bitcoin"),
    CASH("kes");

    private final String displayName;

    PaymentType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
