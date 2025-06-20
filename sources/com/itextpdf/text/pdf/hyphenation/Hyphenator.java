package com.itextpdf.text.pdf.hyphenation;

import com.itextpdf.text.io.StreamUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Hashtable;

public class Hyphenator {

    /* renamed from: d  reason: collision with root package name */
    private static Hashtable<String, HyphenationTree> f26849d = new Hashtable<>();

    /* renamed from: e  reason: collision with root package name */
    private static final String f26850e = "com/itextpdf/text/pdf/hyphenation/hyph/";

    /* renamed from: f  reason: collision with root package name */
    private static String f26851f = "";

    /* renamed from: a  reason: collision with root package name */
    private HyphenationTree f26852a = null;

    /* renamed from: b  reason: collision with root package name */
    private int f26853b = 2;

    /* renamed from: c  reason: collision with root package name */
    private int f26854c = 2;

    public Hyphenator(String str, String str2, int i2, int i3) {
        this.f26852a = c(str, str2);
        this.f26853b = i2;
        this.f26854c = i3;
    }

    public static HyphenationTree a(String str) {
        try {
            if (f26851f == null) {
                return null;
            }
            String str2 = f26851f;
            File file = new File(str2, str + ".xml");
            FileInputStream fileInputStream = file.canRead() ? new FileInputStream(file) : null;
            if (fileInputStream == null && str.length() > 2) {
                String str3 = f26851f;
                File file2 = new File(str3, str.substring(0, 2) + ".xml");
                if (file2.canRead()) {
                    fileInputStream = new FileInputStream(file2);
                }
            }
            if (fileInputStream == null) {
                return null;
            }
            HyphenationTree hyphenationTree = new HyphenationTree();
            hyphenationTree.F(fileInputStream);
            return hyphenationTree;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String b() {
        return f26851f;
    }

    public static HyphenationTree c(String str, String str2) {
        String str3;
        Object obj;
        if (str2 == null || str2.equals("none")) {
            str3 = str;
        } else {
            str3 = str + "_" + str2;
        }
        if (f26849d.containsKey(str3)) {
            obj = f26849d.get(str3);
        } else if (f26849d.containsKey(str)) {
            obj = f26849d.get(str);
        } else {
            HyphenationTree d2 = d(str3);
            if (d2 == null) {
                d2 = a(str3);
            }
            if (d2 != null) {
                f26849d.put(str3, d2);
            }
            return d2;
        }
        return (HyphenationTree) obj;
    }

    public static HyphenationTree d(String str) {
        try {
            InputStream b2 = StreamUtil.b(f26850e + str + ".xml");
            if (b2 == null && str.length() > 2) {
                b2 = StreamUtil.b(f26850e + str.substring(0, 2) + ".xml");
            }
            if (b2 == null) {
                return null;
            }
            HyphenationTree hyphenationTree = new HyphenationTree();
            hyphenationTree.F(b2);
            return hyphenationTree;
        } catch (Exception unused) {
            return null;
        }
    }

    public static Hyphenation f(String str, String str2, String str3, int i2, int i3) {
        HyphenationTree c2 = c(str, str2);
        if (c2 == null) {
            return null;
        }
        return c2.D(str3, i2, i3);
    }

    public static Hyphenation g(String str, String str2, char[] cArr, int i2, int i3, int i4, int i5) {
        HyphenationTree c2 = c(str, str2);
        if (c2 == null) {
            return null;
        }
        return c2.E(cArr, i2, i3, i4, i5);
    }

    public static void i(String str) {
        f26851f = str;
    }

    public Hyphenation e(String str) {
        HyphenationTree hyphenationTree = this.f26852a;
        if (hyphenationTree == null) {
            return null;
        }
        return hyphenationTree.D(str, this.f26853b, this.f26854c);
    }

    public Hyphenation h(char[] cArr, int i2, int i3) {
        HyphenationTree hyphenationTree = this.f26852a;
        if (hyphenationTree == null) {
            return null;
        }
        return hyphenationTree.E(cArr, i2, i3, this.f26853b, this.f26854c);
    }

    public void j(String str, String str2) {
        this.f26852a = c(str, str2);
    }

    public void k(int i2) {
        this.f26854c = i2;
    }

    public void l(int i2) {
        this.f26853b = i2;
    }
}
