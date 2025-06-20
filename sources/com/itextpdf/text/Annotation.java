package com.itextpdf.text;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Annotation implements Element {
    public static final int Z2 = 0;
    public static final int a3 = 1;
    public static final int b3 = 2;
    public static final int c3 = 3;
    public static final int d3 = 4;
    public static final int e3 = 5;
    public static final int f3 = 6;
    public static final int g3 = 7;
    public static final String h3 = "title";
    public static final String i3 = "content";
    public static final String j3 = "url";
    public static final String k3 = "file";
    public static final String l3 = "destination";
    public static final String m3 = "page";
    public static final String n3 = "named";
    public static final String o3 = "application";
    public static final String p3 = "parameters";
    public static final String q3 = "operation";
    public static final String r3 = "defaultdir";
    public static final String s3 = "llx";
    public static final String t3 = "lly";
    public static final String u3 = "urx";
    public static final String v3 = "ury";
    public static final String w3 = "mime";
    protected HashMap<String, Object> X;
    protected float X2;
    protected float Y;
    protected float Y2;
    protected float Z;
    protected int s;

    private Annotation(float f2, float f4, float f5, float f6) {
        this.X = new HashMap<>();
        this.Y = f2;
        this.Z = f4;
        this.X2 = f5;
        this.Y2 = f6;
    }

    public boolean V() {
        return true;
    }

    public List<Chunk> Y() {
        return new ArrayList();
    }

    public int a() {
        return this.s;
    }

    public HashMap<String, Object> c() {
        return this.X;
    }

    public String e() {
        String str = (String) this.X.get(i3);
        return str == null ? "" : str;
    }

    public float f() {
        return this.Y;
    }

    public float g(float f2) {
        return Float.isNaN(this.Y) ? f2 : this.Y;
    }

    public float h() {
        return this.Z;
    }

    public float i(float f2) {
        return Float.isNaN(this.Z) ? f2 : this.Z;
    }

    public void j(float f2, float f4, float f5, float f6) {
        this.Y = f2;
        this.Z = f4;
        this.X2 = f5;
        this.Y2 = f6;
    }

    public String k() {
        String str = (String) this.X.get("title");
        return str == null ? "" : str;
    }

    public float l() {
        return this.X2;
    }

    public float m(float f2) {
        return Float.isNaN(this.X2) ? f2 : this.X2;
    }

    public float n() {
        return this.Y2;
    }

    public float o(float f2) {
        return Float.isNaN(this.Y2) ? f2 : this.Y2;
    }

    public boolean t(ElementListener elementListener) {
        try {
            return elementListener.b(this);
        } catch (DocumentException unused) {
            return false;
        }
    }

    public int type() {
        return 29;
    }

    public boolean x() {
        return true;
    }

    public Annotation(float f2, float f4, float f5, float f6, int i2) {
        this(f2, f4, f5, f6);
        this.s = 5;
        this.X.put(n3, Integer.valueOf(i2));
    }

    public Annotation(float f2, float f4, float f5, float f6, String str) {
        this(f2, f4, f5, f6);
        this.s = 2;
        this.X.put(k3, str);
    }

    public Annotation(float f2, float f4, float f5, float f6, String str, int i2) {
        this(f2, f4, f5, f6);
        this.s = 4;
        this.X.put(k3, str);
        this.X.put(m3, Integer.valueOf(i2));
    }

    public Annotation(float f2, float f4, float f5, float f6, String str, String str2) {
        this(f2, f4, f5, f6);
        this.s = 3;
        this.X.put(k3, str);
        this.X.put(l3, str2);
    }

    public Annotation(float f2, float f4, float f5, float f6, String str, String str2, String str3, String str4) {
        this(f2, f4, f5, f6);
        this.s = 6;
        this.X.put("application", str);
        this.X.put(p3, str2);
        this.X.put(q3, str3);
        this.X.put(r3, str4);
    }

    public Annotation(float f2, float f4, float f5, float f6, String str, String str2, boolean z) {
        this(f2, f4, f5, f6);
        this.s = 7;
        this.X.put(k3, str);
        this.X.put(w3, str2);
        this.X.put(p3, new boolean[]{false, z});
    }

    public Annotation(float f2, float f4, float f5, float f6, URL url) {
        this(f2, f4, f5, f6);
        this.s = 1;
        this.X.put("url", url);
    }

    public Annotation(Annotation annotation) {
        this.X = new HashMap<>();
        this.Y = Float.NaN;
        this.Z = Float.NaN;
        this.X2 = Float.NaN;
        this.Y2 = Float.NaN;
        this.s = annotation.s;
        this.X = annotation.X;
        this.Y = annotation.Y;
        this.Z = annotation.Z;
        this.X2 = annotation.X2;
        this.Y2 = annotation.Y2;
    }

    public Annotation(String str, String str2) {
        HashMap<String, Object> hashMap = new HashMap<>();
        this.X = hashMap;
        this.Y = Float.NaN;
        this.Z = Float.NaN;
        this.X2 = Float.NaN;
        this.Y2 = Float.NaN;
        this.s = 0;
        hashMap.put("title", str);
        this.X.put(i3, str2);
    }

    public Annotation(String str, String str2, float f2, float f4, float f5, float f6) {
        this(f2, f4, f5, f6);
        this.s = 0;
        this.X.put("title", str);
        this.X.put(i3, str2);
    }
}
