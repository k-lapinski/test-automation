package org.selenium;


public enum PropertyEnum {
    // project enums
    TIMEOUT("30"),

    // logins and passwords
    TESTOWY_LOGIN(AuthorizationDataLoader.getProperty("user_1_login"));

    private final String description;

    PropertyEnum(String description) {
        this.description = description;
    }

    public String get() {
        return description;
    }
}
