package com.itextpdf.text.html;

import com.dd.plist.ASCIIPropertyListParser;
import com.itextpdf.text.BaseColor;
import java.util.HashSet;
import java.util.Set;

@Deprecated
public final class HtmlEncoder {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f25744a = new String[256];

    /* renamed from: b  reason: collision with root package name */
    private static final Set<String> f25745b;

    static {
        int i2;
        int i3;
        for (int i4 = 0; i4 < 10; i4++) {
            String[] strArr = f25744a;
            strArr[i4] = "&#00" + i4 + ";";
        }
        int i5 = 10;
        while (true) {
            i2 = 32;
            if (i5 >= 32) {
                break;
            }
            String[] strArr2 = f25744a;
            strArr2[i5] = "&#0" + i5 + ";";
            i5++;
        }
        while (true) {
            if (i2 >= 128) {
                break;
            }
            f25744a[i2] = String.valueOf((char) i2);
            i2++;
        }
        String[] strArr3 = f25744a;
        strArr3[9] = "\t";
        strArr3[10] = "<br />\n";
        strArr3[34] = "&quot;";
        strArr3[38] = "&amp;";
        strArr3[60] = "&lt;";
        strArr3[62] = "&gt;";
        for (i3 = 128; i3 < 256; i3++) {
            String[] strArr4 = f25744a;
            strArr4[i3] = "&#" + i3 + ";";
        }
        HashSet hashSet = new HashSet();
        f25745b = hashSet;
        hashSet.add("p");
        hashSet.add("blockquote");
        hashSet.add("br");
    }

    private HtmlEncoder() {
    }

    public static String a(BaseColor baseColor) {
        StringBuffer stringBuffer = new StringBuffer("#");
        if (baseColor.g() < 16) {
            stringBuffer.append('0');
        }
        stringBuffer.append(Integer.toString(baseColor.g(), 16));
        if (baseColor.e() < 16) {
            stringBuffer.append('0');
        }
        stringBuffer.append(Integer.toString(baseColor.e(), 16));
        if (baseColor.d() < 16) {
            stringBuffer.append('0');
        }
        stringBuffer.append(Integer.toString(baseColor.d(), 16));
        return stringBuffer.toString();
    }

    public static String b(String str) {
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt < 256) {
                stringBuffer.append(f25744a[charAt]);
            } else {
                stringBuffer.append("&#");
                stringBuffer.append(charAt);
                stringBuffer.append(ASCIIPropertyListParser.f18655m);
            }
        }
        return stringBuffer.toString();
    }

    public static String c(int i2) {
        switch (i2) {
            case 0:
                return "left";
            case 1:
                return "center";
            case 2:
                return "right";
            case 3:
            case 8:
                return "justify";
            case 4:
                return "top";
            case 5:
                return HtmlTags.g0;
            case 6:
                return "bottom";
            case 7:
                return HtmlTags.i0;
            default:
                return "";
        }
    }

    public static boolean d(String str) {
        return f25745b.contains(str);
    }
}
