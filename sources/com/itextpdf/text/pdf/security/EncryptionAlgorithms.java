package com.itextpdf.text.pdf.security;

import java.util.HashMap;

public class EncryptionAlgorithms {

    /* renamed from: a  reason: collision with root package name */
    static final HashMap<String, String> f27279a;

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        f27279a = hashMap;
        hashMap.put(SecurityIDs.f27344c, SecurityConstants.f27341n);
        hashMap.put(SecurityIDs.f27345d, SecurityConstants.f27340m);
        hashMap.put("1.2.840.113549.1.1.2", SecurityConstants.f27341n);
        hashMap.put("1.2.840.113549.1.1.4", SecurityConstants.f27341n);
        hashMap.put("1.2.840.113549.1.1.5", SecurityConstants.f27341n);
        hashMap.put("1.2.840.113549.1.1.14", SecurityConstants.f27341n);
        hashMap.put("1.2.840.113549.1.1.11", SecurityConstants.f27341n);
        hashMap.put("1.2.840.113549.1.1.12", SecurityConstants.f27341n);
        hashMap.put("1.2.840.113549.1.1.13", SecurityConstants.f27341n);
        hashMap.put("1.2.840.10040.4.3", SecurityConstants.f27340m);
        hashMap.put("2.16.840.1.101.3.4.3.1", SecurityConstants.f27340m);
        hashMap.put("2.16.840.1.101.3.4.3.2", SecurityConstants.f27340m);
        hashMap.put("1.3.14.3.2.29", SecurityConstants.f27341n);
        hashMap.put("1.3.36.3.3.1.2", SecurityConstants.f27341n);
        hashMap.put("1.3.36.3.3.1.3", SecurityConstants.f27341n);
        hashMap.put("1.3.36.3.3.1.4", SecurityConstants.f27341n);
        hashMap.put("1.2.643.2.2.19", "ECGOST3410");
    }

    public static String a(String str) {
        String str2 = f27279a.get(str);
        return str2 == null ? str : str2;
    }
}
