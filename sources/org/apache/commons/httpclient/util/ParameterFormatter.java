package org.apache.commons.httpclient.util;

import com.dd.plist.ASCIIPropertyListParser;
import org.apache.commons.httpclient.NameValuePair;

public class ParameterFormatter {
    private static final char[] SEPARATORS = {ASCIIPropertyListParser.f18649g, ASCIIPropertyListParser.f18650h, '<', '>', '@', ASCIIPropertyListParser.f18651i, ASCIIPropertyListParser.f18655m, ASCIIPropertyListParser.A, ASCIIPropertyListParser.p, '\"', '/', '[', ']', '?', ASCIIPropertyListParser.f18654l, ASCIIPropertyListParser.f18652j, ASCIIPropertyListParser.f18653k, ' ', 9};
    private static final char[] UNSAFE_CHARS = {'\"', ASCIIPropertyListParser.p};
    private boolean alwaysUseQuotes = true;

    public static void formatValue(StringBuffer stringBuffer, String str, boolean z) {
        if (stringBuffer == null) {
            throw new IllegalArgumentException("String buffer may not be null");
        } else if (str != null) {
            int i2 = 0;
            if (z) {
                stringBuffer.append('\"');
                while (i2 < str.length()) {
                    char charAt = str.charAt(i2);
                    if (isUnsafeChar(charAt)) {
                        stringBuffer.append(ASCIIPropertyListParser.p);
                    }
                    stringBuffer.append(charAt);
                    i2++;
                }
            } else {
                int length = stringBuffer.length();
                boolean z2 = false;
                while (i2 < str.length()) {
                    char charAt2 = str.charAt(i2);
                    if (isSeparator(charAt2)) {
                        z2 = true;
                    }
                    if (isUnsafeChar(charAt2)) {
                        stringBuffer.append(ASCIIPropertyListParser.p);
                    }
                    stringBuffer.append(charAt2);
                    i2++;
                }
                if (z2) {
                    stringBuffer.insert(length, '\"');
                } else {
                    return;
                }
            }
            stringBuffer.append('\"');
        } else {
            throw new IllegalArgumentException("Value buffer may not be null");
        }
    }

    private static boolean isOneOf(char[] cArr, char c2) {
        for (char c3 : cArr) {
            if (c2 == c3) {
                return true;
            }
        }
        return false;
    }

    private static boolean isSeparator(char c2) {
        return isOneOf(SEPARATORS, c2);
    }

    private static boolean isUnsafeChar(char c2) {
        return isOneOf(UNSAFE_CHARS, c2);
    }

    public String format(NameValuePair nameValuePair) {
        StringBuffer stringBuffer = new StringBuffer();
        format(stringBuffer, nameValuePair);
        return stringBuffer.toString();
    }

    public boolean isAlwaysUseQuotes() {
        return this.alwaysUseQuotes;
    }

    public void setAlwaysUseQuotes(boolean z) {
        this.alwaysUseQuotes = z;
    }

    public void format(StringBuffer stringBuffer, NameValuePair nameValuePair) {
        if (stringBuffer == null) {
            throw new IllegalArgumentException("String buffer may not be null");
        } else if (nameValuePair != null) {
            stringBuffer.append(nameValuePair.getName());
            String value = nameValuePair.getValue();
            if (value != null) {
                stringBuffer.append("=");
                formatValue(stringBuffer, value, this.alwaysUseQuotes);
            }
        } else {
            throw new IllegalArgumentException("Parameter may not be null");
        }
    }
}
