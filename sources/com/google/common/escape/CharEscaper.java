package com.google.common.escape;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class CharEscaper extends Escaper {

    /* renamed from: b  reason: collision with root package name */
    private static final int f22530b = 2;

    protected CharEscaper() {
    }

    private static char[] e(char[] cArr, int i2, int i3) {
        if (i3 >= 0) {
            char[] cArr2 = new char[i3];
            if (i2 > 0) {
                System.arraycopy(cArr, 0, cArr2, 0, i2);
            }
            return cArr2;
        }
        throw new AssertionError("Cannot increase internal buffer any further");
    }

    public String b(String str) {
        Preconditions.E(str);
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (c(str.charAt(i2)) != null) {
                return d(str, i2);
            }
        }
        return str;
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public abstract char[] c(char c2);

    /* access modifiers changed from: protected */
    public final String d(String str, int i2) {
        int length = str.length();
        char[] a2 = Platform.a();
        int length2 = a2.length;
        int i3 = 0;
        int i4 = 0;
        while (i2 < length) {
            char[] c2 = c(str.charAt(i2));
            if (c2 != null) {
                int length3 = c2.length;
                int i5 = i2 - i3;
                int i6 = i4 + i5;
                int i7 = i6 + length3;
                if (length2 < i7) {
                    length2 = ((length - i2) * 2) + i7;
                    a2 = e(a2, i4, length2);
                }
                if (i5 > 0) {
                    str.getChars(i3, i2, a2, i4);
                    i4 = i6;
                }
                if (length3 > 0) {
                    System.arraycopy(c2, 0, a2, i4, length3);
                    i4 += length3;
                }
                i3 = i2 + 1;
            }
            i2++;
        }
        int i8 = length - i3;
        if (i8 > 0) {
            int i9 = i8 + i4;
            if (length2 < i9) {
                a2 = e(a2, i4, i9);
            }
            str.getChars(i3, length, a2, i4);
            i4 = i9;
        }
        return new String(a2, 0, i4);
    }
}
