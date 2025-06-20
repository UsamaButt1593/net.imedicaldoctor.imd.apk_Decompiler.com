package com.itextpdf.tool.xml.parser;

import java.util.LinkedHashMap;
import java.util.Map;

public class XMLParserMemory {

    /* renamed from: a  reason: collision with root package name */
    private String f27677a;

    /* renamed from: b  reason: collision with root package name */
    private String f27678b;

    /* renamed from: c  reason: collision with root package name */
    private final StringBuilder f27679c = new StringBuilder();

    /* renamed from: d  reason: collision with root package name */
    private final StringBuilder f27680d = new StringBuilder();

    /* renamed from: e  reason: collision with root package name */
    private final StringBuilder f27681e = new StringBuilder();

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, String> f27682f = new LinkedHashMap();

    /* renamed from: g  reason: collision with root package name */
    private String f27683g = "";

    /* renamed from: h  reason: collision with root package name */
    private String f27684h = "";

    /* renamed from: i  reason: collision with root package name */
    private char f27685i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f27686j;

    /* renamed from: k  reason: collision with root package name */
    private String f27687k;

    public XMLParserMemory(boolean z) {
        this.f27686j = z;
    }

    public StringBuilder a() {
        return this.f27680d;
    }

    public StringBuilder b() {
        return this.f27681e;
    }

    public void c(String str) {
        this.f27678b = str;
    }

    public StringBuilder d() {
        return this.f27679c;
    }

    public void e(String str) {
        this.f27677a = str;
        this.f27683g = str;
        this.f27682f.clear();
    }

    public void f() {
        this.f27684h = "";
    }

    public Map<String, String> g() {
        return new LinkedHashMap(this.f27682f);
    }

    public String h() {
        return this.f27677a;
    }

    public String i() {
        return this.f27684h;
    }

    public String j() {
        return this.f27687k;
    }

    public boolean k() {
        return this.f27678b != null;
    }

    public char l() {
        return this.f27685i;
    }

    public void m(char c2) {
        this.f27685i = c2;
    }

    public void n(String str) {
        this.f27684h = str;
    }

    public void o(String str) {
        Map<String, String> map;
        String str2 = this.f27678b;
        if (str2 != null) {
            if (this.f27686j) {
                map = this.f27682f;
                str2 = str2.toLowerCase();
            } else {
                map = this.f27682f;
            }
            map.put(str2, str);
            this.f27678b = null;
        }
    }

    public void p() {
        this.f27681e.setLength(0);
    }

    public void q(String str) {
        this.f27687k = str;
    }

    public String r() {
        return this.f27683g;
    }

    public void s(String str) {
        this.f27683g = str;
    }
}
