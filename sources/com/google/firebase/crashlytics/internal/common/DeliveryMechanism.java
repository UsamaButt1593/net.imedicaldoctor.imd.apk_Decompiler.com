package com.google.firebase.crashlytics.internal.common;

public enum DeliveryMechanism {
    DEVELOPER(1),
    USER_SIDELOAD(2),
    TEST_DISTRIBUTION(3),
    APP_STORE(4);
    
    private final int s;

    private DeliveryMechanism(int i2) {
        this.s = i2;
    }

    public static DeliveryMechanism b(String str) {
        return str != null ? APP_STORE : DEVELOPER;
    }

    public int c() {
        return this.s;
    }

    public String toString() {
        return Integer.toString(this.s);
    }
}
