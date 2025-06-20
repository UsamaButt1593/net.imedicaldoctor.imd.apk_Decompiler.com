package org.jsoup.helper;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;

public final class StringUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f31603a = {"", StringUtils.SPACE, "  ", "   ", "    ", "     ", "      ", "       ", "        ", "         ", "          "};

    public static void a(StringBuilder sb, String str, boolean z) {
        int length = str.length();
        int i2 = 0;
        boolean z2 = false;
        boolean z3 = false;
        while (i2 < length) {
            int codePointAt = str.codePointAt(i2);
            if (!f(codePointAt)) {
                sb.appendCodePoint(codePointAt);
                z2 = true;
                z3 = false;
            } else if ((!z || z2) && !z3) {
                sb.append(' ');
                z3 = true;
            }
            i2 += Character.charCount(codePointAt);
        }
    }

    public static boolean b(String str, String... strArr) {
        for (String equals : strArr) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean c(String str, String[] strArr) {
        return Arrays.binarySearch(strArr, str) >= 0;
    }

    public static boolean d(String str) {
        if (!(str == null || str.length() == 0)) {
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                if (!f(str.codePointAt(i2))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean e(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isDigit(str.codePointAt(i2))) {
                return false;
            }
        }
        return true;
    }

    public static boolean f(int i2) {
        return i2 == 32 || i2 == 9 || i2 == 10 || i2 == 12 || i2 == 13;
    }

    public static String g(Collection collection, String str) {
        return h(collection.iterator(), str);
    }

    public static String h(Iterator it2, String str) {
        if (!it2.hasNext()) {
            return "";
        }
        String obj = it2.next().toString();
        if (!it2.hasNext()) {
            return obj;
        }
        StringBuilder sb = new StringBuilder(64);
        sb.append(obj);
        while (it2.hasNext()) {
            sb.append(str);
            sb.append(it2.next());
        }
        return sb.toString();
    }

    public static String i(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        a(sb, str, false);
        return sb.toString();
    }

    public static String j(int i2) {
        if (i2 >= 0) {
            String[] strArr = f31603a;
            if (i2 < strArr.length) {
                return strArr[i2];
            }
            char[] cArr = new char[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                cArr[i3] = ' ';
            }
            return String.valueOf(cArr);
        }
        throw new IllegalArgumentException("width must be > 0");
    }

    public static String k(String str, String str2) {
        try {
            try {
                return l(new URL(str), str2).toExternalForm();
            } catch (MalformedURLException unused) {
                return "";
            }
        } catch (MalformedURLException unused2) {
            return new URL(str2).toExternalForm();
        }
    }

    public static URL l(URL url, String str) throws MalformedURLException {
        if (str.startsWith("?")) {
            str = url.getPath() + str;
        }
        if (str.indexOf(46) == 0 && url.getFile().indexOf(47) != 0) {
            url = new URL(url.getProtocol(), url.getHost(), url.getPort(), "/" + url.getFile());
        }
        return new URL(url, str);
    }
}
