package com.itextpdf.tool.xml;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactoryImp;
import com.itextpdf.text.pdf.BaseFont;
import java.nio.charset.UnsupportedCharsetException;
import java.util.HashMap;

public class XMLWorkerFontProvider extends FontFactoryImp {

    /* renamed from: i  reason: collision with root package name */
    public static final String f27450i = "￼";

    /* renamed from: g  reason: collision with root package name */
    protected HashMap<String, String> f27451g;

    /* renamed from: h  reason: collision with root package name */
    protected boolean f27452h;

    public XMLWorkerFontProvider() {
        this((String) null, (HashMap<String, String>) null);
    }

    private Font A(String str, String str2, float f2, int i2) {
        String str3;
        String str4;
        BaseFont baseFont = null;
        try {
            Font a2 = super.a(str, this.f27452h ? BaseFont.a4 : str2, true, f2, i2, (BaseColor) null);
            if ((a2 != null ? a2.c() : null) != null || (str4 = this.f27451g.get(str)) == null || str4.length() <= 0) {
                return a2;
            }
            return super.a(str4, this.f27452h ? BaseFont.a4 : str2, true, f2, i2, (BaseColor) null);
        } catch (UnsupportedCharsetException unused) {
            Font a3 = super.a(str, str2, true, f2, i2, (BaseColor) null);
            if (a3 != null) {
                baseFont = a3.c();
            }
            return (baseFont != null || (str3 = this.f27451g.get(str)) == null || str3.length() <= 0) ? a3 : super.a(str3, str2, true, f2, i2, (BaseColor) null);
        }
    }

    public void B(boolean z) {
        this.f27452h = z;
    }

    public Font a(String str, String str2, boolean z, float f2, int i2, BaseColor baseColor) {
        Font k2 = k(str, str2, f2, i2);
        k2.w(baseColor);
        return k2;
    }

    public Font k(String str, String str2, float f2, int i2) {
        return str == null ? new Font(Font.FontFamily.UNDEFINED, f2, i2) : A(str, str2, f2, i2);
    }

    public void z(String str, String str2) {
        this.f27451g.put(str, str2);
    }

    public XMLWorkerFontProvider(String str) {
        this(str, (HashMap<String, String>) null);
    }

    public XMLWorkerFontProvider(String str, HashMap<String, String> hashMap) {
        this.f27451g = new HashMap<>();
        this.f27452h = true;
        if (str == null || str.length() == 0) {
            super.u();
        } else if (!str.equals("￼")) {
            super.w(str, true);
        }
        if (hashMap != null) {
            this.f27451g = hashMap;
        }
    }
}
