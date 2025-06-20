package org.apache.commons.lang3;

public class CharSetUtils {
    public static boolean containsAny(String str, String... strArr) {
        if (!StringUtils.isEmpty(str) && !deepEmpty(strArr)) {
            CharSet instance = CharSet.getInstance(strArr);
            for (char contains : str.toCharArray()) {
                if (instance.contains(contains)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int count(String str, String... strArr) {
        if (StringUtils.isEmpty(str) || deepEmpty(strArr)) {
            return 0;
        }
        CharSet instance = CharSet.getInstance(strArr);
        int i2 = 0;
        for (char contains : str.toCharArray()) {
            if (instance.contains(contains)) {
                i2++;
            }
        }
        return i2;
    }

    private static boolean deepEmpty(String[] strArr) {
        if (strArr == null) {
            return true;
        }
        for (String isNotEmpty : strArr) {
            if (StringUtils.isNotEmpty(isNotEmpty)) {
                return false;
            }
        }
        return true;
    }

    public static String delete(String str, String... strArr) {
        return (StringUtils.isEmpty(str) || deepEmpty(strArr)) ? str : modify(str, strArr, false);
    }

    public static String keep(String str, String... strArr) {
        if (str == null) {
            return null;
        }
        return (str.isEmpty() || deepEmpty(strArr)) ? "" : modify(str, strArr, true);
    }

    private static String modify(String str, String[] strArr, boolean z) {
        CharSet instance = CharSet.getInstance(strArr);
        StringBuilder sb = new StringBuilder(str.length());
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (instance.contains(charArray[i2]) == z) {
                sb.append(charArray[i2]);
            }
        }
        return sb.toString();
    }

    public static String squeeze(String str, String... strArr) {
        if (StringUtils.isEmpty(str) || deepEmpty(strArr)) {
            return str;
        }
        CharSet instance = CharSet.getInstance(strArr);
        StringBuilder sb = new StringBuilder(str.length());
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        char c2 = ' ';
        for (int i2 = 0; i2 < length; i2++) {
            char c3 = charArray[i2];
            if (c3 != c2 || i2 == 0 || !instance.contains(c3)) {
                sb.append(c3);
                c2 = c3;
            }
        }
        return sb.toString();
    }
}
