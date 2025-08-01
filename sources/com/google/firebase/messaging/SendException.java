package com.google.firebase.messaging;

import java.util.Locale;

public final class SendException extends Exception {
    public static final int X = 0;
    public static final int X2 = 3;
    public static final int Y = 1;
    public static final int Y2 = 4;
    public static final int Z = 2;
    private final int s;

    SendException(String str) {
        super(str);
        this.s = b(str);
    }

    private int b(String str) {
        if (str == null) {
            return 0;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        lowerCase.hashCode();
        char c2 = 65535;
        switch (lowerCase.hashCode()) {
            case -1743242157:
                if (lowerCase.equals("service_not_available")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1290953729:
                if (lowerCase.equals("toomanymessages")) {
                    c2 = 1;
                    break;
                }
                break;
            case -920906446:
                if (lowerCase.equals("invalid_parameters")) {
                    c2 = 2;
                    break;
                }
                break;
            case -617027085:
                if (lowerCase.equals("messagetoobig")) {
                    c2 = 3;
                    break;
                }
                break;
            case -95047692:
                if (lowerCase.equals("missing_to")) {
                    c2 = 4;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return 3;
            case 1:
                return 4;
            case 2:
            case 4:
                return 1;
            case 3:
                return 2;
            default:
                return 0;
        }
    }

    public int a() {
        return this.s;
    }
}
