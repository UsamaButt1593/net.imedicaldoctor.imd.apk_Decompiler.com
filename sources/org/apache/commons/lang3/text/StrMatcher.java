package org.apache.commons.lang3.text;

import com.dd.plist.ASCIIPropertyListParser;
import java.util.Arrays;
import org.apache.commons.lang3.StringUtils;

public abstract class StrMatcher {
    private static final StrMatcher COMMA_MATCHER = new CharMatcher(ASCIIPropertyListParser.f18651i);
    private static final StrMatcher DOUBLE_QUOTE_MATCHER = new CharMatcher('\"');
    private static final StrMatcher NONE_MATCHER = new NoMatcher();
    private static final StrMatcher QUOTE_MATCHER = new CharSetMatcher("'\"".toCharArray());
    private static final StrMatcher SINGLE_QUOTE_MATCHER = new CharMatcher('\'');
    private static final StrMatcher SPACE_MATCHER = new CharMatcher(' ');
    private static final StrMatcher SPLIT_MATCHER = new CharSetMatcher(" \t\n\r\f".toCharArray());
    private static final StrMatcher TAB_MATCHER = new CharMatcher(9);
    private static final StrMatcher TRIM_MATCHER = new TrimMatcher();

    static final class CharMatcher extends StrMatcher {
        private final char ch;

        CharMatcher(char c2) {
            this.ch = c2;
        }

        public int isMatch(char[] cArr, int i2, int i3, int i4) {
            return this.ch == cArr[i2] ? 1 : 0;
        }
    }

    static final class CharSetMatcher extends StrMatcher {
        private final char[] chars;

        CharSetMatcher(char[] cArr) {
            char[] cArr2 = (char[]) cArr.clone();
            this.chars = cArr2;
            Arrays.sort(cArr2);
        }

        public int isMatch(char[] cArr, int i2, int i3, int i4) {
            return Arrays.binarySearch(this.chars, cArr[i2]) >= 0 ? 1 : 0;
        }
    }

    static final class NoMatcher extends StrMatcher {
        NoMatcher() {
        }

        public int isMatch(char[] cArr, int i2, int i3, int i4) {
            return 0;
        }
    }

    static final class StringMatcher extends StrMatcher {
        private final char[] chars;

        StringMatcher(String str) {
            this.chars = str.toCharArray();
        }

        public int isMatch(char[] cArr, int i2, int i3, int i4) {
            int length = this.chars.length;
            if (i2 + length > i4) {
                return 0;
            }
            int i5 = 0;
            while (true) {
                char[] cArr2 = this.chars;
                if (i5 >= cArr2.length) {
                    return length;
                }
                if (cArr2[i5] != cArr[i2]) {
                    return 0;
                }
                i5++;
                i2++;
            }
        }
    }

    static final class TrimMatcher extends StrMatcher {
        TrimMatcher() {
        }

        public int isMatch(char[] cArr, int i2, int i3, int i4) {
            return cArr[i2] <= ' ' ? 1 : 0;
        }
    }

    protected StrMatcher() {
    }

    public static StrMatcher charMatcher(char c2) {
        return new CharMatcher(c2);
    }

    public static StrMatcher charSetMatcher(String str) {
        if (StringUtils.isEmpty(str)) {
            return NONE_MATCHER;
        }
        return str.length() == 1 ? new CharMatcher(str.charAt(0)) : new CharSetMatcher(str.toCharArray());
    }

    public static StrMatcher commaMatcher() {
        return COMMA_MATCHER;
    }

    public static StrMatcher doubleQuoteMatcher() {
        return DOUBLE_QUOTE_MATCHER;
    }

    public static StrMatcher noneMatcher() {
        return NONE_MATCHER;
    }

    public static StrMatcher quoteMatcher() {
        return QUOTE_MATCHER;
    }

    public static StrMatcher singleQuoteMatcher() {
        return SINGLE_QUOTE_MATCHER;
    }

    public static StrMatcher spaceMatcher() {
        return SPACE_MATCHER;
    }

    public static StrMatcher splitMatcher() {
        return SPLIT_MATCHER;
    }

    public static StrMatcher stringMatcher(String str) {
        return StringUtils.isEmpty(str) ? NONE_MATCHER : new StringMatcher(str);
    }

    public static StrMatcher tabMatcher() {
        return TAB_MATCHER;
    }

    public static StrMatcher trimMatcher() {
        return TRIM_MATCHER;
    }

    public int isMatch(char[] cArr, int i2) {
        return isMatch(cArr, i2, 0, cArr.length);
    }

    public abstract int isMatch(char[] cArr, int i2, int i3, int i4);

    public static StrMatcher charSetMatcher(char... cArr) {
        if (cArr == null || cArr.length == 0) {
            return NONE_MATCHER;
        }
        return cArr.length == 1 ? new CharMatcher(cArr[0]) : new CharSetMatcher(cArr);
    }
}
