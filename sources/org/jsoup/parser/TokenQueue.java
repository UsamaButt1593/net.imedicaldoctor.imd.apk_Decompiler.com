package org.jsoup.parser;

import com.dd.plist.ASCIIPropertyListParser;
import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;

public class TokenQueue {

    /* renamed from: c  reason: collision with root package name */
    private static final char f31691c = '\\';

    /* renamed from: a  reason: collision with root package name */
    private String f31692a;

    /* renamed from: b  reason: collision with root package name */
    private int f31693b = 0;

    public TokenQueue(String str) {
        Validate.j(str);
        this.f31692a = str;
    }

    private int C() {
        return this.f31692a.length() - this.f31693b;
    }

    public static String D(String str) {
        StringBuilder sb = new StringBuilder();
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i2 = 0;
        char c2 = 0;
        while (i2 < length) {
            char c3 = charArray[i2];
            if (c3 != '\\' || (c2 != 0 && c2 == '\\')) {
                sb.append(c3);
            }
            i2++;
            c2 = c3;
        }
        return sb.toString();
    }

    public char A() {
        if (r()) {
            return 0;
        }
        return this.f31692a.charAt(this.f31693b);
    }

    public String B() {
        String str = this.f31692a;
        String substring = str.substring(this.f31693b, str.length());
        this.f31693b = this.f31692a.length();
        return substring;
    }

    public void a(Character ch) {
        b(ch.toString());
    }

    public void b(String str) {
        this.f31692a = str + this.f31692a.substring(this.f31693b);
        this.f31693b = 0;
    }

    public void c() {
        if (!r()) {
            this.f31693b++;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0060 A[EDGE_INSN: B:34:0x0060->B:27:0x0060 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String d(char r10, char r11) {
        /*
            r9 = this;
            r0 = -1
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = -1
            r5 = -1
        L_0x0006:
            boolean r6 = r9.r()
            if (r6 == 0) goto L_0x000d
            goto L_0x0060
        L_0x000d:
            char r6 = r9.g()
            java.lang.Character r7 = java.lang.Character.valueOf(r6)
            if (r1 == 0) goto L_0x001b
            r8 = 92
            if (r1 == r8) goto L_0x0057
        L_0x001b:
            r8 = 39
            java.lang.Character r8 = java.lang.Character.valueOf(r8)
            boolean r8 = r7.equals(r8)
            if (r8 != 0) goto L_0x0033
            r8 = 34
            java.lang.Character r8 = java.lang.Character.valueOf(r8)
            boolean r8 = r7.equals(r8)
            if (r8 == 0) goto L_0x0037
        L_0x0033:
            if (r6 == r10) goto L_0x0037
            r2 = r2 ^ 1
        L_0x0037:
            if (r2 == 0) goto L_0x003a
            goto L_0x005e
        L_0x003a:
            java.lang.Character r8 = java.lang.Character.valueOf(r10)
            boolean r8 = r7.equals(r8)
            if (r8 == 0) goto L_0x004b
            int r3 = r3 + 1
            if (r4 != r0) goto L_0x0057
            int r4 = r9.f31693b
            goto L_0x0057
        L_0x004b:
            java.lang.Character r8 = java.lang.Character.valueOf(r11)
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x0057
            int r3 = r3 + -1
        L_0x0057:
            if (r3 <= 0) goto L_0x005d
            if (r1 == 0) goto L_0x005d
            int r5 = r9.f31693b
        L_0x005d:
            r1 = r6
        L_0x005e:
            if (r3 > 0) goto L_0x0006
        L_0x0060:
            if (r5 < 0) goto L_0x0069
            java.lang.String r10 = r9.f31692a
            java.lang.String r10 = r10.substring(r4, r5)
            goto L_0x006b
        L_0x0069:
            java.lang.String r10 = ""
        L_0x006b:
            if (r3 <= 0) goto L_0x0081
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "Did not find balanced maker at "
            r11.append(r0)
            r11.append(r10)
            java.lang.String r11 = r11.toString()
            org.jsoup.helper.Validate.a(r11)
        L_0x0081:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.TokenQueue.d(char, char):java.lang.String");
    }

    public String e(String str) {
        String m2 = m(str);
        s(str);
        return m2;
    }

    public String f(String str) {
        String o = o(str);
        s(str);
        return o;
    }

    public char g() {
        String str = this.f31692a;
        int i2 = this.f31693b;
        this.f31693b = i2 + 1;
        return str.charAt(i2);
    }

    public void h(String str) {
        if (t(str)) {
            int length = str.length();
            if (length <= C()) {
                this.f31693b += length;
                return;
            }
            throw new IllegalStateException("Queue not long enough to consume sequence");
        }
        throw new IllegalStateException("Queue did not match expected sequence");
    }

    public String i() {
        int i2 = this.f31693b;
        while (!r() && (z() || u('-', '_', ASCIIPropertyListParser.A))) {
            this.f31693b++;
        }
        return this.f31692a.substring(i2, this.f31693b);
    }

    public String j() {
        int i2 = this.f31693b;
        while (!r() && (z() || u('-', '_'))) {
            this.f31693b++;
        }
        return this.f31692a.substring(i2, this.f31693b);
    }

    public String k() {
        int i2 = this.f31693b;
        while (!r() && (z() || v("*|", "|", "_", "-"))) {
            this.f31693b++;
        }
        return this.f31692a.substring(i2, this.f31693b);
    }

    public String l() {
        int i2 = this.f31693b;
        while (!r() && (z() || u(ASCIIPropertyListParser.A, '_', '-'))) {
            this.f31693b++;
        }
        return this.f31692a.substring(i2, this.f31693b);
    }

    public String m(String str) {
        int indexOf = this.f31692a.indexOf(str, this.f31693b);
        if (indexOf == -1) {
            return B();
        }
        String substring = this.f31692a.substring(this.f31693b, indexOf);
        this.f31693b += substring.length();
        return substring;
    }

    public String n(String... strArr) {
        int i2 = this.f31693b;
        while (!r() && !v(strArr)) {
            this.f31693b++;
        }
        return this.f31692a.substring(i2, this.f31693b);
    }

    public String o(String str) {
        int i2;
        int i3;
        int i4 = this.f31693b;
        String substring = str.substring(0, 1);
        boolean equals = substring.toLowerCase().equals(substring.toUpperCase());
        while (!r() && !t(str)) {
            if (equals) {
                int indexOf = this.f31692a.indexOf(substring, this.f31693b);
                int i5 = this.f31693b;
                int i6 = indexOf - i5;
                if (i6 == 0) {
                    i3 = i5 + 1;
                } else if (i6 < 0) {
                    i2 = this.f31692a.length();
                } else {
                    i3 = i5 + i6;
                }
                this.f31693b = i3;
            } else {
                i2 = this.f31693b + 1;
            }
            this.f31693b = i2;
        }
        return this.f31692a.substring(i4, this.f31693b);
    }

    public boolean p() {
        boolean z = false;
        while (y()) {
            this.f31693b++;
            z = true;
        }
        return z;
    }

    public String q() {
        int i2 = this.f31693b;
        while (z()) {
            this.f31693b++;
        }
        return this.f31692a.substring(i2, this.f31693b);
    }

    public boolean r() {
        return C() == 0;
    }

    public boolean s(String str) {
        if (!t(str)) {
            return false;
        }
        this.f31693b += str.length();
        return true;
    }

    public boolean t(String str) {
        return this.f31692a.regionMatches(true, this.f31693b, str, 0, str.length());
    }

    public String toString() {
        return this.f31692a.substring(this.f31693b);
    }

    public boolean u(char... cArr) {
        if (r()) {
            return false;
        }
        for (char c2 : cArr) {
            if (this.f31692a.charAt(this.f31693b) == c2) {
                return true;
            }
        }
        return false;
    }

    public boolean v(String... strArr) {
        for (String t : strArr) {
            if (t(t)) {
                return true;
            }
        }
        return false;
    }

    public boolean w(String str) {
        return this.f31692a.startsWith(str, this.f31693b);
    }

    public boolean x() {
        return C() >= 2 && this.f31692a.charAt(this.f31693b) == '<' && Character.isLetter(this.f31692a.charAt(this.f31693b + 1));
    }

    public boolean y() {
        return !r() && StringUtil.f(this.f31692a.charAt(this.f31693b));
    }

    public boolean z() {
        return !r() && Character.isLetterOrDigit(this.f31692a.charAt(this.f31693b));
    }
}
