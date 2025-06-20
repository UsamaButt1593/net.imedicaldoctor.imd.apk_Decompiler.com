package com.itextpdf.text.xml.simpleparser;

import androidx.exifinterface.media.ExifInterface;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.xml.xmp.PdfProperties;
import java.util.HashMap;
import java.util.Map;
import kotlin.text.Typography;

public class EntitiesToUnicode {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, Character> f27378a;

    static {
        HashMap hashMap = new HashMap();
        f27378a = hashMap;
        hashMap.put("nbsp", Character.valueOf(Typography.f29120g));
        hashMap.put("iexcl", 161);
        hashMap.put("cent", Character.valueOf(Typography.f29122i));
        hashMap.put("pound", Character.valueOf(Typography.f29123j));
        hashMap.put("curren", 164);
        hashMap.put("yen", 165);
        hashMap.put("brvbar", 166);
        hashMap.put("sect", Character.valueOf(Typography.f29124k));
        hashMap.put("uml", 168);
        hashMap.put("copy", Character.valueOf(Typography.f29125l));
        hashMap.put("ordf", 170);
        hashMap.put("laquo", 171);
        hashMap.put("not", 172);
        hashMap.put("shy", 173);
        hashMap.put("reg", Character.valueOf(Typography.o));
        hashMap.put("macr", 175);
        hashMap.put("deg", Character.valueOf(Typography.p));
        hashMap.put("plusmn", Character.valueOf(Typography.q));
        hashMap.put("sup2", 178);
        hashMap.put("sup3", 179);
        hashMap.put("acute", 180);
        hashMap.put("micro", 181);
        hashMap.put("para", Character.valueOf(Typography.r));
        hashMap.put("middot", Character.valueOf(Typography.s));
        hashMap.put("cedil", 184);
        hashMap.put("sup1", 185);
        hashMap.put("ordm", 186);
        hashMap.put("raquo", 187);
        hashMap.put("frac14", 188);
        hashMap.put("frac12", Character.valueOf(Typography.t));
        hashMap.put("frac34", 190);
        hashMap.put("iquest", 191);
        hashMap.put("Agrave", 192);
        hashMap.put("Aacute", 193);
        hashMap.put("Acirc", 194);
        hashMap.put("Atilde", Character.valueOf(Barcode128.N));
        hashMap.put("Auml", Character.valueOf(Barcode128.O));
        hashMap.put("Aring", Character.valueOf(Barcode128.P));
        hashMap.put("AElig", Character.valueOf(Barcode128.Q));
        hashMap.put("Ccedil", Character.valueOf(Barcode128.R));
        hashMap.put("Egrave", 200);
        hashMap.put("Eacute", 201);
        hashMap.put("Ecirc", Character.valueOf(Barcode128.M));
        hashMap.put("Euml", Character.valueOf(Barcode128.U));
        hashMap.put("Igrave", Character.valueOf(Barcode128.V));
        hashMap.put("Iacute", Character.valueOf(Barcode128.W));
        hashMap.put("Icirc", 206);
        hashMap.put("Iuml", 207);
        hashMap.put("ETH", 208);
        hashMap.put("Ntilde", 209);
        hashMap.put("Ograve", 210);
        hashMap.put("Oacute", 211);
        hashMap.put("Ocirc", 212);
        hashMap.put("Otilde", 213);
        hashMap.put("Ouml", 214);
        hashMap.put("times", Character.valueOf(Typography.f29121h));
        hashMap.put("Oslash", 216);
        hashMap.put("Ugrave", 217);
        hashMap.put("Uacute", 218);
        hashMap.put("Ucirc", 219);
        hashMap.put("Uuml", 220);
        hashMap.put("Yacute", 221);
        hashMap.put("THORN", 222);
        hashMap.put("szlig", 223);
        hashMap.put("agrave", 224);
        hashMap.put("aacute", 225);
        hashMap.put("acirc", 226);
        hashMap.put("atilde", 227);
        hashMap.put("auml", 228);
        hashMap.put("aring", 229);
        hashMap.put("aelig", 230);
        hashMap.put("ccedil", 231);
        hashMap.put("egrave", 232);
        hashMap.put("eacute", 233);
        hashMap.put("ecirc", 234);
        hashMap.put("euml", 235);
        hashMap.put("igrave", 236);
        hashMap.put("iacute", 237);
        hashMap.put("icirc", 238);
        hashMap.put("iuml", 239);
        hashMap.put("eth", 240);
        hashMap.put("ntilde", 241);
        hashMap.put("ograve", 242);
        hashMap.put("oacute", 243);
        hashMap.put("ocirc", 244);
        hashMap.put("otilde", 245);
        hashMap.put("ouml", 246);
        hashMap.put("divide", 247);
        hashMap.put("oslash", 248);
        hashMap.put("ugrave", 249);
        hashMap.put("uacute", 250);
        hashMap.put("ucirc", 251);
        hashMap.put("uuml", 252);
        hashMap.put("yacute", 253);
        hashMap.put("thorn", 254);
        hashMap.put("yuml", 255);
        hashMap.put("fnof", 402);
        hashMap.put("Alpha", 913);
        hashMap.put("Beta", 914);
        hashMap.put(ExifInterface.e0, 915);
        hashMap.put("Delta", 916);
        hashMap.put("Epsilon", 917);
        hashMap.put("Zeta", 918);
        hashMap.put("Eta", 919);
        hashMap.put("Theta", 920);
        hashMap.put("Iota", 921);
        hashMap.put("Kappa", 922);
        hashMap.put("Lambda", 923);
        hashMap.put("Mu", 924);
        hashMap.put("Nu", 925);
        hashMap.put("Xi", 926);
        hashMap.put("Omicron", 927);
        hashMap.put("Pi", 928);
        hashMap.put("Rho", 929);
        hashMap.put("Sigma", 931);
        hashMap.put("Tau", 932);
        hashMap.put("Upsilon", 933);
        hashMap.put("Phi", 934);
        hashMap.put("Chi", 935);
        hashMap.put("Psi", 936);
        hashMap.put("Omega", 937);
        hashMap.put("alpha", 945);
        hashMap.put("beta", 946);
        hashMap.put("gamma", 947);
        hashMap.put("delta", 948);
        hashMap.put("epsilon", 949);
        hashMap.put("zeta", 950);
        hashMap.put("eta", 951);
        hashMap.put("theta", 952);
        hashMap.put("iota", 953);
        hashMap.put("kappa", 954);
        hashMap.put("lambda", 955);
        hashMap.put("mu", 956);
        hashMap.put("nu", 957);
        hashMap.put("xi", 958);
        hashMap.put("omicron", 959);
        hashMap.put("pi", 960);
        hashMap.put("rho", 961);
        hashMap.put("sigmaf", 962);
        hashMap.put("sigma", 963);
        hashMap.put("tau", 964);
        hashMap.put("upsilon", 965);
        hashMap.put("phi", 966);
        hashMap.put("chi", 967);
        hashMap.put("psi", 968);
        hashMap.put("omega", 969);
        hashMap.put("thetasym", 977);
        hashMap.put("upsih", 978);
        hashMap.put("piv", 982);
        hashMap.put("bull", Character.valueOf(Typography.E));
        hashMap.put("hellip", Character.valueOf(Typography.F));
        hashMap.put("prime", Character.valueOf(Typography.G));
        hashMap.put("Prime", Character.valueOf(Typography.H));
        hashMap.put("oline", 8254);
        hashMap.put("frasl", 8260);
        hashMap.put("weierp", 8472);
        hashMap.put("image", 8465);
        hashMap.put("real", 8476);
        hashMap.put("trade", Character.valueOf(Typography.J));
        hashMap.put("alefsym", 8501);
        hashMap.put("larr", 8592);
        hashMap.put("uarr", 8593);
        hashMap.put("rarr", 8594);
        hashMap.put("darr", 8595);
        hashMap.put("harr", 8596);
        hashMap.put("crarr", 8629);
        hashMap.put("lArr", 8656);
        hashMap.put("uArr", 8657);
        hashMap.put("rArr", 8658);
        hashMap.put("dArr", 8659);
        hashMap.put("hArr", 8660);
        hashMap.put("forall", 8704);
        hashMap.put(PdfProperties.f27412d, 8706);
        hashMap.put("exist", 8707);
        hashMap.put("empty", 8709);
        hashMap.put("nabla", 8711);
        hashMap.put("isin", 8712);
        hashMap.put("notin", 8713);
        hashMap.put("ni", 8715);
        hashMap.put("prod", 8719);
        hashMap.put("sum", 8721);
        hashMap.put("minus", 8722);
        hashMap.put("lowast", 8727);
        hashMap.put("radic", 8730);
        hashMap.put("prop", 8733);
        hashMap.put("infin", 8734);
        hashMap.put("ang", 8736);
        hashMap.put("and", 8743);
        hashMap.put("or", 8744);
        hashMap.put("cap", 8745);
        hashMap.put("cup", 8746);
        hashMap.put("int", 8747);
        hashMap.put("there4", 8756);
        hashMap.put("sim", 8764);
        hashMap.put("cong", 8773);
        hashMap.put("asymp", Character.valueOf(Typography.K));
        hashMap.put("ne", Character.valueOf(Typography.L));
        hashMap.put("equiv", 8801);
        hashMap.put("le", Character.valueOf(Typography.M));
        hashMap.put("ge", Character.valueOf(Typography.N));
        hashMap.put("sub", 8834);
        hashMap.put("sup", 8835);
        hashMap.put("nsub", 8836);
        hashMap.put("sube", 8838);
        hashMap.put("supe", 8839);
        hashMap.put("oplus", 8853);
        hashMap.put("otimes", 8855);
        hashMap.put("perp", 8869);
        hashMap.put("sdot", 8901);
        hashMap.put("lceil", 8968);
        hashMap.put("rceil", 8969);
        hashMap.put("lfloor", 8970);
        hashMap.put("rfloor", 8971);
        hashMap.put("lang", 9001);
        hashMap.put("rang", 9002);
        hashMap.put("loz", 9674);
        hashMap.put("spades", 9824);
        hashMap.put("clubs", 9827);
        hashMap.put("hearts", 9829);
        hashMap.put("diams", 9830);
        hashMap.put("quot", '\"');
        hashMap.put("amp", Character.valueOf(Typography.f29117d));
        hashMap.put("apos", '\'');
        hashMap.put("lt", '<');
        hashMap.put("gt", '>');
        hashMap.put("OElig", 338);
        hashMap.put("oelig", 339);
        hashMap.put("Scaron", 352);
        hashMap.put("scaron", 353);
        hashMap.put("Yuml", 376);
        hashMap.put("circ", 710);
        hashMap.put("tilde", 732);
        hashMap.put("ensp", 8194);
        hashMap.put("emsp", 8195);
        hashMap.put("thinsp", 8201);
        hashMap.put("zwnj", 8204);
        hashMap.put("zwj", 8205);
        hashMap.put("lrm", 8206);
        hashMap.put("rlm", 8207);
        hashMap.put("ndash", Character.valueOf(Typography.u));
        hashMap.put("mdash", Character.valueOf(Typography.v));
        hashMap.put("lsquo", Character.valueOf(Typography.w));
        hashMap.put("rsquo", Character.valueOf(Typography.x));
        hashMap.put("sbquo", Character.valueOf(Typography.y));
        hashMap.put("ldquo", Character.valueOf(Typography.z));
        hashMap.put("rdquo", Character.valueOf(Typography.A));
        hashMap.put("bdquo", Character.valueOf(Typography.B));
        hashMap.put("dagger", Character.valueOf(Typography.C));
        hashMap.put("Dagger", Character.valueOf(Typography.D));
        hashMap.put("permil", 8240);
        hashMap.put("lsaquo", 8249);
        hashMap.put("rsaquo", 8250);
        hashMap.put("euro", Character.valueOf(Typography.I));
    }

    public static char a(String str) {
        if (str.startsWith("#x")) {
            try {
                return (char) Integer.parseInt(str.substring(2), 16);
            } catch (NumberFormatException unused) {
                return 0;
            }
        } else if (str.startsWith("#")) {
            try {
                return (char) Integer.parseInt(str.substring(1));
            } catch (NumberFormatException unused2) {
                return 0;
            }
        } else {
            Character ch = f27378a.get(str);
            if (ch == null) {
                return 0;
            }
            return ch.charValue();
        }
    }

    public static String b(String str) {
        String substring;
        int i2;
        int indexOf = str.indexOf(38);
        if (indexOf == -1) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(str.substring(0, indexOf));
        while (true) {
            int indexOf2 = str.indexOf(59, indexOf);
            if (indexOf2 == -1) {
                substring = str.substring(indexOf);
                break;
            }
            while (true) {
                i2 = indexOf;
                indexOf = str.indexOf(38, indexOf + 1);
                if (indexOf == -1 || indexOf >= indexOf2) {
                    char a2 = a(str.substring(i2 + 1, indexOf2));
                    int i3 = indexOf2 + 1;
                } else {
                    stringBuffer.append(str.substring(i2, indexOf));
                }
            }
            char a22 = a(str.substring(i2 + 1, indexOf2));
            int i32 = indexOf2 + 1;
            if (str.length() < i32) {
                return stringBuffer.toString();
            }
            if (a22 == 0) {
                stringBuffer.append(str.substring(i2, i32));
            } else {
                stringBuffer.append(a22);
            }
            indexOf = str.indexOf(38, indexOf2);
            if (indexOf == -1) {
                substring = str.substring(i32);
                break;
            }
            stringBuffer.append(str.substring(i32, indexOf));
        }
        stringBuffer.append(substring);
        return stringBuffer.toString();
    }
}
