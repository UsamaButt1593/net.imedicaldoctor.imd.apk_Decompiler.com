package com.google.common.base;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class Utf8 {
    private Utf8() {
    }

    public static int a(CharSequence charSequence) {
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (true) {
            if (i2 < length) {
                char charAt = charSequence.charAt(i2);
                if (charAt >= 2048) {
                    i3 += b(charSequence, i2);
                    break;
                }
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                break;
            }
        }
        if (i3 >= length) {
            return i3;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i3) + 4294967296L));
    }

    private static int b(CharSequence charSequence, int i2) {
        int length = charSequence.length();
        int i3 = 0;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            if (charAt < 2048) {
                i3 += (127 - charAt) >>> 31;
            } else {
                i3 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(charSequence, i2) != charAt) {
                        i2++;
                    } else {
                        throw new IllegalArgumentException(f(i2));
                    }
                }
            }
            i2++;
        }
        return i3;
    }

    public static boolean c(byte[] bArr) {
        return d(bArr, 0, bArr.length);
    }

    public static boolean d(byte[] bArr, int i2, int i3) {
        int i4 = i3 + i2;
        Preconditions.f0(i2, i4, bArr.length);
        while (i2 < i4) {
            if (bArr[i2] < 0) {
                return e(bArr, i2, i4);
            }
            i2++;
        }
        return true;
    }

    private static boolean e(byte[] bArr, int i2, int i3) {
        byte b2;
        while (i2 < i3) {
            int i4 = i2 + 1;
            byte b3 = bArr[i2];
            if (b3 >= 0) {
                i2 = i4;
            } else if (b3 < -32) {
                if (i4 != i3 && b3 >= -62) {
                    i2 += 2;
                    if (bArr[i4] > -65) {
                    }
                }
                return false;
            } else if (b3 < -16) {
                int i5 = i2 + 2;
                if (i5 < i3 && (b2 = bArr[i4]) <= -65 && ((b3 != -32 || b2 >= -96) && (b3 != -19 || -96 > b2))) {
                    i2 += 3;
                    if (bArr[i5] > -65) {
                    }
                }
                return false;
            } else if (i2 + 3 >= i3) {
                return false;
            } else {
                int i6 = i2 + 2;
                byte b4 = bArr[i4];
                if (b4 <= -65 && (((b3 << Ascii.F) + (b4 + 112)) >> 30) == 0) {
                    int i7 = i2 + 3;
                    if (bArr[i6] <= -65) {
                        i2 += 4;
                        if (bArr[i7] > -65) {
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }

    private static String f(int i2) {
        return "Unpaired surrogate at index " + i2;
    }
}
