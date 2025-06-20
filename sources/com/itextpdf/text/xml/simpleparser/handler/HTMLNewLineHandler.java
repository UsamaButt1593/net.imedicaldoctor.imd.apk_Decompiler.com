package com.itextpdf.text.xml.simpleparser.handler;

import com.itextpdf.text.xml.simpleparser.NewLineHandler;
import java.util.HashSet;
import java.util.Set;

public class HTMLNewLineHandler implements NewLineHandler {

    /* renamed from: a  reason: collision with root package name */
    private final Set<String> f27394a;

    public HTMLNewLineHandler() {
        HashSet hashSet = new HashSet();
        this.f27394a = hashSet;
        hashSet.add("p");
        hashSet.add("blockquote");
        hashSet.add("br");
    }

    public boolean a(String str) {
        return this.f27394a.contains(str);
    }
}
