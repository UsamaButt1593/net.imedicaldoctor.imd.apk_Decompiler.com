package org.apache.commons.lang3.text;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;

public class WordUtils {
    public static String capitalize(String str) {
        return capitalize(str, (char[]) null);
    }

    public static String capitalizeFully(String str) {
        return capitalizeFully(str, (char[]) null);
    }

    public static String initials(String str) {
        return initials(str, (char[]) null);
    }

    private static boolean isDelimiter(char c2, char[] cArr) {
        if (cArr == null) {
            return Character.isWhitespace(c2);
        }
        for (char c3 : cArr) {
            if (c2 == c3) {
                return true;
            }
        }
        return false;
    }

    public static String swapCase(String str) {
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        boolean z = true;
        for (int i2 = 0; i2 < charArray.length; i2++) {
            char c2 = charArray[i2];
            if (Character.isUpperCase(c2)) {
                charArray[i2] = Character.toLowerCase(c2);
            } else if (Character.isTitleCase(c2)) {
                charArray[i2] = Character.toLowerCase(c2);
            } else {
                if (!Character.isLowerCase(c2)) {
                    z = Character.isWhitespace(c2);
                } else if (z) {
                    charArray[i2] = Character.toTitleCase(c2);
                } else {
                    charArray[i2] = Character.toUpperCase(c2);
                }
            }
            z = false;
        }
        return new String(charArray);
    }

    public static String uncapitalize(String str) {
        return uncapitalize(str, (char[]) null);
    }

    public static String wrap(String str, int i2) {
        return wrap(str, i2, (String) null, false);
    }

    public static String capitalize(String str, char... cArr) {
        int length = cArr == null ? -1 : cArr.length;
        if (StringUtils.isEmpty(str) || length == 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        boolean z = true;
        for (int i2 = 0; i2 < charArray.length; i2++) {
            char c2 = charArray[i2];
            if (isDelimiter(c2, cArr)) {
                z = true;
            } else if (z) {
                charArray[i2] = Character.toTitleCase(c2);
                z = false;
            }
        }
        return new String(charArray);
    }

    public static String capitalizeFully(String str, char... cArr) {
        return (StringUtils.isEmpty(str) || (cArr == null ? -1 : cArr.length) == 0) ? str : capitalize(str.toLowerCase(), cArr);
    }

    public static String initials(String str, char... cArr) {
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        if (cArr != null && cArr.length == 0) {
            return "";
        }
        int length = str.length();
        char[] cArr2 = new char[((length / 2) + 1)];
        int i2 = 0;
        boolean z = true;
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if (isDelimiter(charAt, cArr)) {
                z = true;
            } else if (z) {
                cArr2[i2] = charAt;
                i2++;
                z = false;
            }
        }
        return new String(cArr2, 0, i2);
    }

    public static String uncapitalize(String str, char... cArr) {
        int length = cArr == null ? -1 : cArr.length;
        if (StringUtils.isEmpty(str) || length == 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        boolean z = true;
        for (int i2 = 0; i2 < charArray.length; i2++) {
            char c2 = charArray[i2];
            if (isDelimiter(c2, cArr)) {
                z = true;
            } else if (z) {
                charArray[i2] = Character.toLowerCase(c2);
                z = false;
            }
        }
        return new String(charArray);
    }

    public static String wrap(String str, int i2, String str2, boolean z) {
        if (str == null) {
            return null;
        }
        if (str2 == null) {
            str2 = SystemUtils.LINE_SEPARATOR;
        }
        if (i2 < 1) {
            i2 = 1;
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(length + 32);
        int i3 = 0;
        while (length - i3 > i2) {
            if (str.charAt(i3) == ' ') {
                i3++;
            } else {
                int i4 = i2 + i3;
                int lastIndexOf = str.lastIndexOf(32, i4);
                if (lastIndexOf >= i3) {
                    sb.append(str.substring(i3, lastIndexOf));
                    sb.append(str2);
                    i3 = lastIndexOf + 1;
                } else {
                    if (z) {
                        sb.append(str.substring(i3, i4));
                        sb.append(str2);
                    } else {
                        int indexOf = str.indexOf(32, i4);
                        if (indexOf >= 0) {
                            sb.append(str.substring(i3, indexOf));
                            sb.append(str2);
                            i4 = indexOf + 1;
                        } else {
                            sb.append(str.substring(i3));
                            i3 = length;
                        }
                    }
                    i3 = i4;
                }
            }
        }
        sb.append(str.substring(i3));
        return sb.toString();
    }
}
