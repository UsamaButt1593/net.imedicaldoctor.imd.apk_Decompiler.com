package com.itextpdf.tool.xml.net.exc;

import com.itextpdf.tool.xml.exceptions.LocaleMessages;

public class NoImageException extends Exception {
    private static final long s = 1;

    public NoImageException(String str) {
        this(str, (Exception) null);
    }

    public NoImageException(String str, Exception exc) {
        super(String.format(LocaleMessages.a().b(LocaleMessages.f27583n), new Object[]{str}), exc);
    }
}
