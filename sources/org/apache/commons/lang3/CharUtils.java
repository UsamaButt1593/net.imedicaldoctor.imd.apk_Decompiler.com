package org.apache.commons.lang3;

public class CharUtils {
    private static final String[] CHAR_STRING_ARRAY = new String[128];
    public static final char CR = '\r';
    public static final char LF = '\n';

    static {
        char c2 = 0;
        while (true) {
            String[] strArr = CHAR_STRING_ARRAY;
            if (c2 < strArr.length) {
                strArr[c2] = String.valueOf(c2);
                c2 = (char) (c2 + 1);
            } else {
                return;
            }
        }
    }

    public static boolean isAscii(char c2) {
        return c2 < 128;
    }

    public static boolean isAsciiAlpha(char c2) {
        return isAsciiAlphaUpper(c2) || isAsciiAlphaLower(c2);
    }

    public static boolean isAsciiAlphaLower(char c2) {
        return c2 >= 'a' && c2 <= 'z';
    }

    public static boolean isAsciiAlphaUpper(char c2) {
        return c2 >= 'A' && c2 <= 'Z';
    }

    public static boolean isAsciiAlphanumeric(char c2) {
        return isAsciiAlpha(c2) || isAsciiNumeric(c2);
    }

    public static boolean isAsciiControl(char c2) {
        return c2 < ' ' || c2 == 127;
    }

    public static boolean isAsciiNumeric(char c2) {
        return c2 >= '0' && c2 <= '9';
    }

    public static boolean isAsciiPrintable(char c2) {
        return c2 >= ' ' && c2 < 127;
    }

    public static char toChar(Character ch) {
        if (ch != null) {
            return ch.charValue();
        }
        throw new IllegalArgumentException("The Character must not be null");
    }

    @Deprecated
    public static Character toCharacterObject(char c2) {
        return Character.valueOf(c2);
    }

    public static int toIntValue(char c2) {
        if (isAsciiNumeric(c2)) {
            return c2 - '0';
        }
        throw new IllegalArgumentException("The character " + c2 + " is not in the range '0' - '9'");
    }

    public static String toString(char c2) {
        if (c2 < 128) {
            return CHAR_STRING_ARRAY[c2];
        }
        return new String(new char[]{c2});
    }

    public static String unicodeEscaped(char c2) {
        StringBuilder sb;
        String str;
        if (c2 < 16) {
            sb = new StringBuilder();
            str = "\\u000";
        } else if (c2 < 256) {
            sb = new StringBuilder();
            str = "\\u00";
        } else if (c2 < 4096) {
            sb = new StringBuilder();
            str = "\\u0";
        } else {
            sb = new StringBuilder();
            str = "\\u";
        }
        sb.append(str);
        sb.append(Integer.toHexString(c2));
        return sb.toString();
    }

    public static char toChar(Character ch, char c2) {
        return ch == null ? c2 : ch.charValue();
    }

    public static Character toCharacterObject(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        return Character.valueOf(str.charAt(0));
    }

    public static int toIntValue(char c2, int i2) {
        return !isAsciiNumeric(c2) ? i2 : c2 - '0';
    }

    public static String toString(Character ch) {
        if (ch == null) {
            return null;
        }
        return toString(ch.charValue());
    }

    public static String unicodeEscaped(Character ch) {
        if (ch == null) {
            return null;
        }
        return unicodeEscaped(ch.charValue());
    }

    public static char toChar(String str) {
        if (!StringUtils.isEmpty(str)) {
            return str.charAt(0);
        }
        throw new IllegalArgumentException("The String must not be empty");
    }

    public static int toIntValue(Character ch) {
        if (ch != null) {
            return toIntValue(ch.charValue());
        }
        throw new IllegalArgumentException("The character must not be null");
    }

    public static char toChar(String str, char c2) {
        return StringUtils.isEmpty(str) ? c2 : str.charAt(0);
    }

    public static int toIntValue(Character ch, int i2) {
        return ch == null ? i2 : toIntValue(ch.charValue(), i2);
    }
}
