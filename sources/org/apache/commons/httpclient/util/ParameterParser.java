package org.apache.commons.httpclient.util;

import java.util.ArrayList;
import java.util.List;

public class ParameterParser {
    private char[] chars = null;
    private int i1 = 0;
    private int i2 = 0;
    private int len = 0;
    private int pos = 0;

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0032  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String getToken(boolean r5) {
        /*
            r4 = this;
        L_0x0000:
            int r0 = r4.i1
            int r1 = r4.i2
            if (r0 >= r1) goto L_0x0017
            char[] r1 = r4.chars
            char r0 = r1[r0]
            boolean r0 = java.lang.Character.isWhitespace(r0)
            if (r0 == 0) goto L_0x0017
            int r0 = r4.i1
            int r0 = r0 + 1
            r4.i1 = r0
            goto L_0x0000
        L_0x0017:
            int r0 = r4.i2
            int r1 = r4.i1
            if (r0 <= r1) goto L_0x0030
            char[] r1 = r4.chars
            int r0 = r0 + -1
            char r0 = r1[r0]
            boolean r0 = java.lang.Character.isWhitespace(r0)
            if (r0 == 0) goto L_0x0030
            int r0 = r4.i2
            int r0 = r0 + -1
            r4.i2 = r0
            goto L_0x0017
        L_0x0030:
            if (r5 == 0) goto L_0x0051
            int r5 = r4.i2
            int r0 = r4.i1
            int r1 = r5 - r0
            r2 = 2
            if (r1 < r2) goto L_0x0051
            char[] r1 = r4.chars
            char r2 = r1[r0]
            r3 = 34
            if (r2 != r3) goto L_0x0051
            int r2 = r5 + -1
            char r1 = r1[r2]
            if (r1 != r3) goto L_0x0051
            int r0 = r0 + 1
            r4.i1 = r0
            int r5 = r5 + -1
            r4.i2 = r5
        L_0x0051:
            int r5 = r4.i2
            int r0 = r4.i1
            if (r5 < r0) goto L_0x0060
            java.lang.String r1 = new java.lang.String
            char[] r2 = r4.chars
            int r5 = r5 - r0
            r1.<init>(r2, r0, r5)
            goto L_0x0061
        L_0x0060:
            r1 = 0
        L_0x0061:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.httpclient.util.ParameterParser.getToken(boolean):java.lang.String");
    }

    private boolean hasChar() {
        return this.pos < this.len;
    }

    private boolean isOneOf(char c2, char[] cArr) {
        for (char c3 : cArr) {
            if (c2 == c3) {
                return true;
            }
        }
        return false;
    }

    private String parseQuotedToken(char[] cArr) {
        int i3 = this.pos;
        this.i1 = i3;
        this.i2 = i3;
        boolean z = false;
        boolean z2 = false;
        while (hasChar()) {
            char c2 = this.chars[this.pos];
            if (!z && isOneOf(c2, cArr)) {
                break;
            }
            if (!z2 && c2 == '\"') {
                z = !z;
            }
            z2 = !z2 && c2 == '\\';
            this.i2++;
            this.pos++;
        }
        return getToken(true);
    }

    private String parseToken(char[] cArr) {
        int i3 = this.pos;
        this.i1 = i3;
        this.i2 = i3;
        while (hasChar() && !isOneOf(this.chars[this.pos], cArr)) {
            this.i2++;
            this.pos++;
        }
        return getToken(false);
    }

    public List parse(String str, char c2) {
        return str == null ? new ArrayList() : parse(str.toCharArray(), c2);
    }

    public List parse(char[] cArr, char c2) {
        return cArr == null ? new ArrayList() : parse(cArr, 0, cArr.length, c2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0047  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List parse(char[] r6, int r7, int r8, char r9) {
        /*
            r5 = this;
            r0 = 0
            r1 = 1
            if (r6 != 0) goto L_0x000a
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            return r6
        L_0x000a:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r5.chars = r6
            r5.pos = r7
            r5.len = r8
        L_0x0015:
            boolean r7 = r5.hasChar()
            if (r7 == 0) goto L_0x0065
            r7 = 61
            r8 = 2
            char[] r8 = new char[r8]
            r8[r0] = r7
            r8[r1] = r9
            java.lang.String r8 = r5.parseToken(r8)
            boolean r3 = r5.hasChar()
            if (r3 == 0) goto L_0x0040
            int r3 = r5.pos
            char r4 = r6[r3]
            if (r4 != r7) goto L_0x0040
            int r3 = r3 + r1
            r5.pos = r3
            char[] r7 = new char[r1]
            r7[r0] = r9
            java.lang.String r7 = r5.parseQuotedToken(r7)
            goto L_0x0041
        L_0x0040:
            r7 = 0
        L_0x0041:
            boolean r3 = r5.hasChar()
            if (r3 == 0) goto L_0x0050
            int r3 = r5.pos
            char r4 = r6[r3]
            if (r4 != r9) goto L_0x0050
            int r3 = r3 + r1
            r5.pos = r3
        L_0x0050:
            if (r8 == 0) goto L_0x0015
            java.lang.String r3 = ""
            boolean r3 = r8.equals(r3)
            if (r3 == 0) goto L_0x005c
            if (r7 == 0) goto L_0x0015
        L_0x005c:
            org.apache.commons.httpclient.NameValuePair r3 = new org.apache.commons.httpclient.NameValuePair
            r3.<init>(r8, r7)
            r2.add(r3)
            goto L_0x0015
        L_0x0065:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.httpclient.util.ParameterParser.parse(char[], int, int, char):java.util.List");
    }
}
