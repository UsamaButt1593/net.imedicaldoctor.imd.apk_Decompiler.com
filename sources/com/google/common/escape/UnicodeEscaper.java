package com.google.common.escape;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class UnicodeEscaper extends Escaper {

    /* renamed from: b  reason: collision with root package name */
    private static final int f22545b = 32;

    protected UnicodeEscaper() {
    }

    protected static int c(CharSequence charSequence, int i2, int i3) {
        Preconditions.E(charSequence);
        if (i2 < i3) {
            int i4 = i2 + 1;
            char charAt = charSequence.charAt(i2);
            if (charAt < 55296 || charAt > 57343) {
                return charAt;
            }
            if (charAt > 56319) {
                throw new IllegalArgumentException("Unexpected low surrogate character '" + charAt + "' with value " + charAt + " at index " + i2 + " in '" + charSequence + "'");
            } else if (i4 == i3) {
                return -charAt;
            } else {
                char charAt2 = charSequence.charAt(i4);
                if (Character.isLowSurrogate(charAt2)) {
                    return Character.toCodePoint(charAt, charAt2);
                }
                throw new IllegalArgumentException("Expected low surrogate but got char '" + charAt2 + "' with value " + charAt2 + " at index " + i4 + " in '" + charSequence + "'");
            }
        } else {
            throw new IndexOutOfBoundsException("Index exceeds specified range");
        }
    }

    private static char[] f(char[] cArr, int i2, int i3) {
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
        int g2 = g(str, 0, length);
        return g2 == length ? str : e(str, g2);
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public abstract char[] d(int i2);

    /* access modifiers changed from: protected */
    public final String e(String str, int i2) {
        int length = str.length();
        char[] a2 = Platform.a();
        int i3 = 0;
        int i4 = 0;
        while (i2 < length) {
            int c2 = c(str, i2, length);
            if (c2 >= 0) {
                char[] d2 = d(c2);
                int i5 = (Character.isSupplementaryCodePoint(c2) ? 2 : 1) + i2;
                if (d2 != null) {
                    int i6 = i2 - i3;
                    int i7 = i4 + i6;
                    int length2 = d2.length + i7;
                    if (a2.length < length2) {
                        a2 = f(a2, i4, length2 + (length - i2) + 32);
                    }
                    if (i6 > 0) {
                        str.getChars(i3, i2, a2, i4);
                        i4 = i7;
                    }
                    if (d2.length > 0) {
                        System.arraycopy(d2, 0, a2, i4, d2.length);
                        i4 += d2.length;
                    }
                    i3 = i5;
                }
                i2 = g(str, i5, length);
            } else {
                throw new IllegalArgumentException("Trailing high surrogate at end of input");
            }
        }
        int i8 = length - i3;
        if (i8 > 0) {
            int i9 = i8 + i4;
            if (a2.length < i9) {
                a2 = f(a2, i4, i9);
            }
            str.getChars(i3, length, a2, i4);
            i4 = i9;
        }
        return new String(a2, 0, i4);
    }

    /* access modifiers changed from: protected */
    public int g(CharSequence charSequence, int i2, int i3) {
        while (i2 < i3) {
            int c2 = c(charSequence, i2, i3);
            if (c2 < 0 || d(c2) != null) {
                break;
            }
            i2 += Character.isSupplementaryCodePoint(c2) ? 2 : 1;
        }
        return i2;
    }
}
