package saman.zamani.persiandate;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.html.HTML;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PersianDateFormat {

    /* renamed from: a  reason: collision with root package name */
    private final String[] f31907a;

    /* renamed from: b  reason: collision with root package name */
    private String f31908b;

    /* renamed from: c  reason: collision with root package name */
    private PersianDateNumberCharacter f31909c;

    /* renamed from: d  reason: collision with root package name */
    private final String[] f31910d;

    public enum PersianDateNumberCharacter {
        ENGLISH,
        FARSI
    }

    public PersianDateFormat() {
        this.f31907a = new String[]{"a", CmcdData.Factory.q, "j", "F", "Y", "H", "i", "s", "d", "g", "n", "m", "t", "w", "y", "z", ExifInterface.W4, "L", "X", "C", ExifInterface.S4, "P", "Q", "R"};
        this.f31908b = "l j F Y H:i:s";
        this.f31909c = PersianDateNumberCharacter.ENGLISH;
        this.f31910d = new String[]{"yyyy", "MM", HTML.Tag.t, "HH", CSS.Value.k0, "ss"};
    }

    public static String[] a(String[] strArr) {
        String[] strArr2 = {"۰", "۱", "۲", "٣", "۴", "۵", "۶", "۷", "۸", "٩"};
        String[] strArr3 = {"0", IcyHeaders.a3, ExifInterface.Y4, ExifInterface.Z4, "4", "5", "6", "7", "8", "9"};
        for (int i2 = 0; i2 < strArr.length; i2++) {
            String str = strArr[i2];
            for (int i3 = 0; i3 < 10; i3++) {
                str = str.replaceAll(strArr3[i3], strArr2[i3]);
            }
            strArr[i2] = str;
        }
        return strArr;
    }

    public static String c(PersianDate persianDate, String str) {
        return d(persianDate, str, PersianDateNumberCharacter.ENGLISH);
    }

    public static String d(PersianDate persianDate, String str, PersianDateNumberCharacter persianDateNumberCharacter) {
        String str2;
        String substring;
        String str3 = str == null ? "l j F Y H:i:s" : str;
        String[] strArr = {"a", CmcdData.Factory.q, "j", "F", "Y", "H", "i", "s", "d", "g", "n", "m", "t", "w", "y", "z", ExifInterface.W4, "L", "X", "C", ExifInterface.S4, "P", "Q", "R"};
        if (("" + persianDate.u0()).length() == 2) {
            substring = "" + persianDate.u0();
        } else {
            int i2 = 3;
            if (("" + persianDate.u0()).length() == 3) {
                str2 = "" + persianDate.u0();
            } else {
                str2 = "" + persianDate.u0();
                i2 = 4;
            }
            substring = str2.substring(2, i2);
        }
        String str4 = substring;
        String v0 = persianDate.v0();
        String I = persianDate.I();
        String str5 = "" + persianDate.s0();
        String V0 = persianDate.V0();
        String str6 = "" + persianDate.u0();
        String m2 = m("" + persianDate.f0());
        String m3 = m("" + persianDate.h0());
        String m4 = m("" + persianDate.r0());
        String m5 = m("" + persianDate.s0());
        String str7 = "" + persianDate.Q();
        String str8 = "" + persianDate.t0();
        String m6 = m("" + persianDate.t0());
        StringBuilder sb = new StringBuilder();
        sb.append("");
        String str9 = str3;
        sb.append(persianDate.i0());
        String[] strArr2 = {v0, I, str5, V0, str6, m2, m3, m4, m5, str7, str8, m6, sb.toString(), "" + persianDate.K(), str4, "" + persianDate.S(), persianDate.y0(), persianDate.M0() ? IcyHeaders.a3 : "0", persianDate.a(), persianDate.e(), persianDate.g(), persianDate.c(), persianDate.G(), persianDate.E()};
        if (persianDateNumberCharacter == PersianDateNumberCharacter.FARSI) {
            a(strArr2);
        }
        String str10 = str9;
        for (int i3 = 0; i3 < 24; i3++) {
            str10 = str10.replace(strArr[i3], strArr2[i3]);
        }
        return str10;
    }

    private String k(String str, String[] strArr, String[] strArr2) {
        for (int i2 = 0; i2 < strArr.length; i2++) {
            str = str.replace(strArr[i2], strArr2[i2]);
        }
        return str;
    }

    private String l(String str) {
        if (str.length() >= 2) {
            return str;
        }
        return "0" + str;
    }

    public static String m(String str) {
        if (str.length() >= 2) {
            return str;
        }
        return "0" + str;
    }

    public String b(PersianDate persianDate) {
        String str;
        String substring;
        if (("" + persianDate.u0()).length() == 2) {
            substring = "" + persianDate.u0();
        } else {
            int i2 = 3;
            if (("" + persianDate.u0()).length() == 3) {
                str = "" + persianDate.u0();
            } else {
                str = "" + persianDate.u0();
                i2 = 4;
            }
            substring = str.substring(2, i2);
        }
        String str2 = substring;
        String[] strArr = {persianDate.v0(), persianDate.I(), "" + persianDate.s0(), persianDate.V0(), "" + persianDate.u0(), l("" + persianDate.f0()), l("" + persianDate.h0()), l("" + persianDate.r0()), l("" + persianDate.s0()), "" + persianDate.Q(), "" + persianDate.t0(), l("" + persianDate.t0()), "" + persianDate.i0(), "" + persianDate.K(), str2, "" + persianDate.S(), persianDate.y0(), persianDate.M0() ? IcyHeaders.a3 : "0", persianDate.a(), persianDate.e(), persianDate.g(), persianDate.c(), persianDate.G(), persianDate.E()};
        if (this.f31909c == PersianDateNumberCharacter.FARSI) {
            a(strArr);
        }
        return k(this.f31908b, this.f31907a, strArr);
    }

    public PersianDate e(String str) throws ParseException {
        return f(str, this.f31908b);
    }

    public PersianDate f(String str, String str2) throws ParseException {
        AnonymousClass1 r0 = new ArrayList<Integer>() {
            {
                add(0);
                add(0);
                add(0);
                add(0);
                add(0);
                add(0);
            }
        };
        int i2 = 0;
        while (true) {
            String[] strArr = this.f31910d;
            if (i2 >= strArr.length) {
                return new PersianDate().J0(((Integer) r0.get(0)).intValue(), ((Integer) r0.get(1)).intValue(), ((Integer) r0.get(2)).intValue(), ((Integer) r0.get(3)).intValue(), ((Integer) r0.get(4)).intValue(), ((Integer) r0.get(5)).intValue());
            }
            if (str2.contains(strArr[i2])) {
                int indexOf = str2.indexOf(this.f31910d[i2]);
                String substring = str.substring(indexOf, this.f31910d[i2].length() + indexOf);
                if (substring.matches("[-+]?\\d*\\.?\\d+")) {
                    r0.set(i2, Integer.valueOf(Integer.parseInt(substring)));
                } else {
                    throw new ParseException("Parse Exception", 10);
                }
            }
            i2++;
        }
    }

    public PersianDate g(String str) throws ParseException {
        return h(str, this.f31908b);
    }

    public PersianDate h(String str, String str2) throws ParseException {
        return new PersianDate(Long.valueOf(new SimpleDateFormat(str2).parse(str).getTime()));
    }

    public void i(PersianDateNumberCharacter persianDateNumberCharacter) {
        this.f31909c = persianDateNumberCharacter;
    }

    public void j(String str) {
        this.f31908b = str;
    }

    public PersianDateFormat(String str) {
        this.f31907a = new String[]{"a", CmcdData.Factory.q, "j", "F", "Y", "H", "i", "s", "d", "g", "n", "m", "t", "w", "y", "z", ExifInterface.W4, "L", "X", "C", ExifInterface.S4, "P", "Q", "R"};
        this.f31908b = "l j F Y H:i:s";
        this.f31909c = PersianDateNumberCharacter.ENGLISH;
        this.f31910d = new String[]{"yyyy", "MM", HTML.Tag.t, "HH", CSS.Value.k0, "ss"};
        this.f31908b = str;
    }

    public PersianDateFormat(String str, PersianDateNumberCharacter persianDateNumberCharacter) {
        this.f31907a = new String[]{"a", CmcdData.Factory.q, "j", "F", "Y", "H", "i", "s", "d", "g", "n", "m", "t", "w", "y", "z", ExifInterface.W4, "L", "X", "C", ExifInterface.S4, "P", "Q", "R"};
        this.f31908b = "l j F Y H:i:s";
        PersianDateNumberCharacter persianDateNumberCharacter2 = PersianDateNumberCharacter.ENGLISH;
        this.f31910d = new String[]{"yyyy", "MM", HTML.Tag.t, "HH", CSS.Value.k0, "ss"};
        this.f31908b = str;
        this.f31909c = persianDateNumberCharacter;
    }
}
