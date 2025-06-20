package org.jsoup.parser;

import java.util.Arrays;
import java.util.Locale;
import org.jsoup.helper.Validate;

public final class CharacterReader {

    /* renamed from: f  reason: collision with root package name */
    static final char f31622f = '￿';

    /* renamed from: g  reason: collision with root package name */
    private static final int f31623g = 12;

    /* renamed from: a  reason: collision with root package name */
    private final char[] f31624a;

    /* renamed from: b  reason: collision with root package name */
    private final int f31625b;

    /* renamed from: c  reason: collision with root package name */
    private int f31626c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f31627d = 0;

    /* renamed from: e  reason: collision with root package name */
    private final String[] f31628e = new String[512];

    public CharacterReader(String str) {
        Validate.j(str);
        char[] charArray = str.toCharArray();
        this.f31624a = charArray;
        this.f31625b = charArray.length;
    }

    private String b(int i2, int i3) {
        char[] cArr = this.f31624a;
        String[] strArr = this.f31628e;
        if (i3 > 12) {
            return new String(cArr, i2, i3);
        }
        int i4 = 0;
        int i5 = i2;
        int i6 = 0;
        while (i4 < i3) {
            i6 = (i6 * 31) + cArr[i5];
            i4++;
            i5++;
        }
        int length = (strArr.length - 1) & i6;
        String str = strArr[length];
        if (str == null) {
            String str2 = new String(cArr, i2, i3);
            strArr[length] = str2;
            return str2;
        } else if (F(i2, i3, str)) {
            return str;
        } else {
            String str3 = new String(cArr, i2, i3);
            strArr[length] = str3;
            return str3;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean A(String str) {
        int length = str.length();
        if (length > this.f31625b - this.f31626c) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (Character.toUpperCase(str.charAt(i2)) != Character.toUpperCase(this.f31624a[this.f31626c + i2])) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean B() {
        if (r()) {
            return false;
        }
        char c2 = this.f31624a[this.f31626c];
        return (c2 >= 'A' && c2 <= 'Z') || (c2 >= 'a' && c2 <= 'z') || Character.isLetter(c2);
    }

    /* access modifiers changed from: package-private */
    public int C(char c2) {
        for (int i2 = this.f31626c; i2 < this.f31625b; i2++) {
            if (c2 == this.f31624a[i2]) {
                return i2 - this.f31626c;
            }
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public int D(CharSequence charSequence) {
        char charAt = charSequence.charAt(0);
        int i2 = this.f31626c;
        while (i2 < this.f31625b) {
            int i3 = 1;
            if (charAt != this.f31624a[i2]) {
                do {
                    i2++;
                    if (i2 >= this.f31625b) {
                        break;
                    }
                } while (charAt == this.f31624a[i2]);
            }
            int i4 = i2 + 1;
            int length = (charSequence.length() + i4) - 1;
            int i5 = this.f31625b;
            if (i2 < i5 && length <= i5) {
                int i6 = i4;
                while (i6 < length && charSequence.charAt(i3) == this.f31624a[i6]) {
                    i6++;
                    i3++;
                }
                if (i6 == length) {
                    return i2 - this.f31626c;
                }
            }
            i2 = i4;
        }
        return -1;
    }

    public int E() {
        return this.f31626c;
    }

    /* access modifiers changed from: package-private */
    public boolean F(int i2, int i3, String str) {
        if (i3 != str.length()) {
            return false;
        }
        char[] cArr = this.f31624a;
        int i4 = 0;
        while (true) {
            int i5 = i3 - 1;
            if (i3 == 0) {
                return true;
            }
            int i6 = i2 + 1;
            int i7 = i4 + 1;
            if (cArr[i2] != str.charAt(i4)) {
                return false;
            }
            i2 = i6;
            i3 = i5;
            i4 = i7;
        }
    }

    /* access modifiers changed from: package-private */
    public void G() {
        this.f31626c = this.f31627d;
    }

    /* access modifiers changed from: package-private */
    public void H() {
        this.f31626c--;
    }

    public void a() {
        this.f31626c++;
    }

    /* access modifiers changed from: package-private */
    public char c() {
        int i2 = this.f31626c;
        char c2 = i2 >= this.f31625b ? 65535 : this.f31624a[i2];
        this.f31626c = i2 + 1;
        return c2;
    }

    /* access modifiers changed from: package-private */
    public String d() {
        char[] cArr = this.f31624a;
        int i2 = this.f31626c;
        this.f31626c = i2 + 1;
        return new String(cArr, i2, 1);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x001e  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0024 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String e() {
        /*
            r6 = this;
            int r0 = r6.f31626c
            int r1 = r6.f31625b
            char[] r2 = r6.f31624a
        L_0x0006:
            int r3 = r6.f31626c
            if (r3 >= r1) goto L_0x001c
            char r4 = r2[r3]
            r5 = 38
            if (r4 == r5) goto L_0x001c
            r5 = 60
            if (r4 == r5) goto L_0x001c
            if (r4 != 0) goto L_0x0017
            goto L_0x001c
        L_0x0017:
            int r3 = r3 + 1
            r6.f31626c = r3
            goto L_0x0006
        L_0x001c:
            if (r3 <= r0) goto L_0x0024
            int r3 = r3 - r0
            java.lang.String r0 = r6.b(r0, r3)
            goto L_0x0026
        L_0x0024:
            java.lang.String r0 = ""
        L_0x0026:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.CharacterReader.e():java.lang.String");
    }

    /* access modifiers changed from: package-private */
    public String f() {
        int i2;
        char c2;
        int i3 = this.f31626c;
        while (true) {
            i2 = this.f31626c;
            if (i2 < this.f31625b && (c2 = this.f31624a[i2]) >= '0' && c2 <= '9') {
                this.f31626c = i2 + 1;
            }
        }
        return b(i3, i2 - i3);
    }

    /* access modifiers changed from: package-private */
    public String g() {
        int i2;
        char c2;
        int i3 = this.f31626c;
        while (true) {
            i2 = this.f31626c;
            if (i2 < this.f31625b && (((c2 = this.f31624a[i2]) >= '0' && c2 <= '9') || ((c2 >= 'A' && c2 <= 'F') || (c2 >= 'a' && c2 <= 'f')))) {
                this.f31626c = i2 + 1;
            }
        }
        return b(i3, i2 - i3);
    }

    /* access modifiers changed from: package-private */
    public String h() {
        char c2;
        int i2 = this.f31626c;
        while (true) {
            int i3 = this.f31626c;
            if (i3 < this.f31625b && (((c2 = this.f31624a[i3]) >= 'A' && c2 <= 'Z') || ((c2 >= 'a' && c2 <= 'z') || Character.isLetter(c2)))) {
                this.f31626c++;
            }
        }
        return b(i2, this.f31626c - i2);
    }

    /* access modifiers changed from: package-private */
    public String i() {
        char c2;
        int i2 = this.f31626c;
        while (true) {
            int i3 = this.f31626c;
            if (i3 < this.f31625b && (((c2 = this.f31624a[i3]) >= 'A' && c2 <= 'Z') || ((c2 >= 'a' && c2 <= 'z') || Character.isLetter(c2)))) {
                this.f31626c++;
            }
        }
        while (!r() && (r1 = this.f31624a[r2]) >= '0' && r1 <= '9') {
            this.f31626c = (r2 = this.f31626c) + 1;
        }
        return b(i2, this.f31626c - i2);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0038 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String j() {
        /*
            r6 = this;
            int r0 = r6.f31626c
            int r1 = r6.f31625b
            char[] r2 = r6.f31624a
        L_0x0006:
            int r3 = r6.f31626c
            if (r3 >= r1) goto L_0x0030
            char r4 = r2[r3]
            r5 = 9
            if (r4 == r5) goto L_0x0030
            r5 = 10
            if (r4 == r5) goto L_0x0030
            r5 = 13
            if (r4 == r5) goto L_0x0030
            r5 = 12
            if (r4 == r5) goto L_0x0030
            r5 = 32
            if (r4 == r5) goto L_0x0030
            r5 = 47
            if (r4 == r5) goto L_0x0030
            r5 = 62
            if (r4 == r5) goto L_0x0030
            if (r4 != 0) goto L_0x002b
            goto L_0x0030
        L_0x002b:
            int r3 = r3 + 1
            r6.f31626c = r3
            goto L_0x0006
        L_0x0030:
            if (r3 <= r0) goto L_0x0038
            int r3 = r3 - r0
            java.lang.String r0 = r6.b(r0, r3)
            goto L_0x003a
        L_0x0038:
            java.lang.String r0 = ""
        L_0x003a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.CharacterReader.j():java.lang.String");
    }

    public String k(char c2) {
        int C = C(c2);
        if (C == -1) {
            return o();
        }
        String b2 = b(this.f31626c, C);
        this.f31626c += C;
        return b2;
    }

    /* access modifiers changed from: package-private */
    public String l(String str) {
        int D = D(str);
        if (D == -1) {
            return o();
        }
        String b2 = b(this.f31626c, D);
        this.f31626c += D;
        return b2;
    }

    public String m(char... cArr) {
        int i2 = this.f31626c;
        int i3 = this.f31625b;
        char[] cArr2 = this.f31624a;
        loop0:
        while (this.f31626c < i3) {
            for (char c2 : cArr) {
                if (cArr2[this.f31626c] == c2) {
                    break loop0;
                }
            }
            this.f31626c++;
        }
        int i4 = this.f31626c;
        return i4 > i2 ? b(i2, i4 - i2) : "";
    }

    /* access modifiers changed from: package-private */
    public String n(char... cArr) {
        int i2 = this.f31626c;
        int i3 = this.f31625b;
        char[] cArr2 = this.f31624a;
        while (true) {
            int i4 = this.f31626c;
            if (i4 >= i3 || Arrays.binarySearch(cArr, cArr2[i4]) >= 0) {
                int i5 = this.f31626c;
            } else {
                this.f31626c++;
            }
        }
        int i52 = this.f31626c;
        return i52 > i2 ? b(i2, i52 - i2) : "";
    }

    /* access modifiers changed from: package-private */
    public String o() {
        int i2 = this.f31626c;
        String b2 = b(i2, this.f31625b - i2);
        this.f31626c = this.f31625b;
        return b2;
    }

    /* access modifiers changed from: package-private */
    public boolean p(String str) {
        Locale locale = Locale.ENGLISH;
        return D(str.toLowerCase(locale)) > -1 || D(str.toUpperCase(locale)) > -1;
    }

    public char q() {
        int i2 = this.f31626c;
        if (i2 >= this.f31625b) {
            return 65535;
        }
        return this.f31624a[i2];
    }

    public boolean r() {
        return this.f31626c >= this.f31625b;
    }

    /* access modifiers changed from: package-private */
    public void s() {
        this.f31627d = this.f31626c;
    }

    /* access modifiers changed from: package-private */
    public boolean t(String str) {
        if (!w(str)) {
            return false;
        }
        this.f31626c += str.length();
        return true;
    }

    public String toString() {
        char[] cArr = this.f31624a;
        int i2 = this.f31626c;
        return new String(cArr, i2, this.f31625b - i2);
    }

    /* access modifiers changed from: package-private */
    public boolean u(String str) {
        if (!A(str)) {
            return false;
        }
        this.f31626c += str.length();
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean v(char c2) {
        return !r() && this.f31624a[this.f31626c] == c2;
    }

    /* access modifiers changed from: package-private */
    public boolean w(String str) {
        int length = str.length();
        if (length > this.f31625b - this.f31626c) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (str.charAt(i2) != this.f31624a[this.f31626c + i2]) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean x(char... cArr) {
        if (r()) {
            return false;
        }
        char c2 = this.f31624a[this.f31626c];
        for (char c3 : cArr) {
            if (c3 == c2) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean y(char[] cArr) {
        return !r() && Arrays.binarySearch(cArr, this.f31624a[this.f31626c]) >= 0;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r0 = r3.f31624a[r3.f31626c];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean z() {
        /*
            r3 = this;
            boolean r0 = r3.r()
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            char[] r0 = r3.f31624a
            int r2 = r3.f31626c
            char r0 = r0[r2]
            r2 = 48
            if (r0 < r2) goto L_0x0017
            r2 = 57
            if (r0 > r2) goto L_0x0017
            r1 = 1
        L_0x0017:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.CharacterReader.z():boolean");
    }
}
