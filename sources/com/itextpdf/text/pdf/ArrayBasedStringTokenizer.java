package com.itextpdf.text.pdf;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrayBasedStringTokenizer {

    /* renamed from: a  reason: collision with root package name */
    private final Pattern f25850a;

    public ArrayBasedStringTokenizer(String[] strArr) {
        this.f25850a = Pattern.compile(a(strArr));
    }

    private String a(String[] strArr) {
        StringBuilder sb = new StringBuilder(100);
        for (String append : strArr) {
            sb.append("(");
            sb.append(append);
            sb.append(")|");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    public String[] b(String str) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = this.f25850a.matcher(str);
        int i2 = 0;
        while (matcher.find()) {
            String substring = str.substring(i2, matcher.start());
            if (substring.length() > 0) {
                arrayList.add(substring);
            }
            arrayList.add(matcher.group());
            i2 = matcher.end();
        }
        String substring2 = str.substring(i2, str.length());
        if (substring2.length() > 0) {
            arrayList.add(substring2);
        }
        return (String[]) arrayList.toArray(new String[0]);
    }
}
