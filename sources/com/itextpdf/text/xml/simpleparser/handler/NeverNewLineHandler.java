package com.itextpdf.text.xml.simpleparser.handler;

import com.itextpdf.text.xml.simpleparser.NewLineHandler;

public class NeverNewLineHandler implements NewLineHandler {
    public boolean a(String str) {
        return false;
    }
}
