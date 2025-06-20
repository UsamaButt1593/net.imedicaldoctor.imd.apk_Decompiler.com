package com.itextpdf.text.exceptions;

import java.io.IOException;

public class BadPasswordException extends IOException {
    private static final long s = -4333706268155063964L;

    public BadPasswordException(String str) {
        super(str);
    }
}
