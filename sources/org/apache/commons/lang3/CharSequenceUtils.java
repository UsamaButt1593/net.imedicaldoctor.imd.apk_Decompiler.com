package org.apache.commons.lang3;

public class CharSequenceUtils {
    static int indexOf(CharSequence charSequence, int i2, int i3) {
        if (charSequence instanceof String) {
            return ((String) charSequence).indexOf(i2, i3);
        }
        int length = charSequence.length();
        if (i3 < 0) {
            i3 = 0;
        }
        while (i3 < length) {
            if (charSequence.charAt(i3) == i2) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    static int lastIndexOf(CharSequence charSequence, int i2, int i3) {
        if (charSequence instanceof String) {
            return ((String) charSequence).lastIndexOf(i2, i3);
        }
        int length = charSequence.length();
        if (i3 < 0) {
            return -1;
        }
        if (i3 >= length) {
            i3 = length - 1;
        }
        while (i3 >= 0) {
            if (charSequence.charAt(i3) == i2) {
                return i3;
            }
            i3--;
        }
        return -1;
    }

    static boolean regionMatches(CharSequence charSequence, boolean z, int i2, CharSequence charSequence2, int i3, int i4) {
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            while (true) {
                int i5 = i4 - 1;
                if (i4 <= 0) {
                    return true;
                }
                int i6 = i2 + 1;
                char charAt = charSequence.charAt(i2);
                int i7 = i3 + 1;
                char charAt2 = charSequence2.charAt(i3);
                if (charAt != charAt2) {
                    if (!z) {
                        return false;
                    }
                    if (!(Character.toUpperCase(charAt) == Character.toUpperCase(charAt2) || Character.toLowerCase(charAt) == Character.toLowerCase(charAt2))) {
                        return false;
                    }
                }
                i2 = i6;
                i4 = i5;
                i3 = i7;
            }
        } else {
            return ((String) charSequence).regionMatches(z, i2, (String) charSequence2, i3, i4);
        }
    }

    public static CharSequence subSequence(CharSequence charSequence, int i2) {
        if (charSequence == null) {
            return null;
        }
        return charSequence.subSequence(i2, charSequence.length());
    }

    static char[] toCharArray(CharSequence charSequence) {
        if (charSequence instanceof String) {
            return ((String) charSequence).toCharArray();
        }
        int length = charSequence.length();
        char[] cArr = new char[charSequence.length()];
        for (int i2 = 0; i2 < length; i2++) {
            cArr[i2] = charSequence.charAt(i2);
        }
        return cArr;
    }

    static int indexOf(CharSequence charSequence, CharSequence charSequence2, int i2) {
        return charSequence.toString().indexOf(charSequence2.toString(), i2);
    }

    static int lastIndexOf(CharSequence charSequence, CharSequence charSequence2, int i2) {
        return charSequence.toString().lastIndexOf(charSequence2.toString(), i2);
    }
}
