package androidx.emoji2.text.flatbuffer;

import androidx.emoji2.text.flatbuffer.Utf8;
import androidx.media3.extractor.ts.PsExtractor;
import java.nio.ByteBuffer;

public final class Utf8Safe extends Utf8 {

    static class UnpairedSurrogateException extends IllegalArgumentException {
        UnpairedSurrogateException(int i2, int i3) {
            super("Unpaired surrogate at index " + i2 + " of " + i3);
        }
    }

    private static int f(CharSequence charSequence) {
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
                    i3 += k(charSequence, i2);
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

    public static String g(byte[] bArr, int i2, int i3) {
        if ((i2 | i3 | ((bArr.length - i2) - i3)) >= 0) {
            int i4 = i2 + i3;
            char[] cArr = new char[i3];
            int i5 = 0;
            while (r13 < i4) {
                byte b2 = bArr[r13];
                if (!Utf8.DecodeUtil.g(b2)) {
                    break;
                }
                i2 = r13 + 1;
                Utf8.DecodeUtil.b(b2, cArr, i5);
                i5++;
            }
            int i6 = i5;
            while (r13 < i4) {
                int i7 = r13 + 1;
                byte b3 = bArr[r13];
                if (Utf8.DecodeUtil.g(b3)) {
                    int i8 = i6 + 1;
                    Utf8.DecodeUtil.b(b3, cArr, i6);
                    while (i7 < i4) {
                        byte b4 = bArr[i7];
                        if (!Utf8.DecodeUtil.g(b4)) {
                            break;
                        }
                        i7++;
                        Utf8.DecodeUtil.b(b4, cArr, i8);
                        i8++;
                    }
                    i6 = i8;
                    r13 = i7;
                } else if (Utf8.DecodeUtil.i(b3)) {
                    if (i7 < i4) {
                        r13 += 2;
                        Utf8.DecodeUtil.d(b3, bArr[i7], cArr, i6);
                        i6++;
                    } else {
                        throw new IllegalArgumentException("Invalid UTF-8");
                    }
                } else if (Utf8.DecodeUtil.h(b3)) {
                    if (i7 < i4 - 1) {
                        int i9 = r13 + 2;
                        r13 += 3;
                        Utf8.DecodeUtil.c(b3, bArr[i7], bArr[i9], cArr, i6);
                        i6++;
                    } else {
                        throw new IllegalArgumentException("Invalid UTF-8");
                    }
                } else if (i7 < i4 - 2) {
                    byte b5 = bArr[i7];
                    int i10 = r13 + 3;
                    byte b6 = bArr[r13 + 2];
                    r13 += 4;
                    Utf8.DecodeUtil.a(b3, b5, b6, bArr[i10], cArr, i6);
                    i6 += 2;
                } else {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
            }
            return new String(cArr, 0, i6);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)}));
    }

    public static String h(ByteBuffer byteBuffer, int i2, int i3) {
        if ((i2 | i3 | ((byteBuffer.limit() - i2) - i3)) >= 0) {
            int i4 = i2 + i3;
            char[] cArr = new char[i3];
            int i5 = 0;
            while (r13 < i4) {
                byte b2 = byteBuffer.get(r13);
                if (!Utf8.DecodeUtil.g(b2)) {
                    break;
                }
                i2 = r13 + 1;
                Utf8.DecodeUtil.b(b2, cArr, i5);
                i5++;
            }
            int i6 = i5;
            while (r13 < i4) {
                int i7 = r13 + 1;
                byte b3 = byteBuffer.get(r13);
                if (Utf8.DecodeUtil.g(b3)) {
                    int i8 = i6 + 1;
                    Utf8.DecodeUtil.b(b3, cArr, i6);
                    while (i7 < i4) {
                        byte b4 = byteBuffer.get(i7);
                        if (!Utf8.DecodeUtil.g(b4)) {
                            break;
                        }
                        i7++;
                        Utf8.DecodeUtil.b(b4, cArr, i8);
                        i8++;
                    }
                    i6 = i8;
                    r13 = i7;
                } else if (Utf8.DecodeUtil.i(b3)) {
                    if (i7 < i4) {
                        r13 += 2;
                        Utf8.DecodeUtil.d(b3, byteBuffer.get(i7), cArr, i6);
                        i6++;
                    } else {
                        throw new IllegalArgumentException("Invalid UTF-8");
                    }
                } else if (Utf8.DecodeUtil.h(b3)) {
                    if (i7 < i4 - 1) {
                        int i9 = r13 + 2;
                        r13 += 3;
                        Utf8.DecodeUtil.c(b3, byteBuffer.get(i7), byteBuffer.get(i9), cArr, i6);
                        i6++;
                    } else {
                        throw new IllegalArgumentException("Invalid UTF-8");
                    }
                } else if (i7 < i4 - 2) {
                    byte b5 = byteBuffer.get(i7);
                    int i10 = r13 + 3;
                    byte b6 = byteBuffer.get(r13 + 2);
                    r13 += 4;
                    Utf8.DecodeUtil.a(b3, b5, b6, byteBuffer.get(i10), cArr, i6);
                    i6 += 2;
                } else {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
            }
            return new String(cArr, 0, i6);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i2), Integer.valueOf(i3)}));
    }

    private static int i(CharSequence charSequence, byte[] bArr, int i2, int i3) {
        int i4;
        int i5;
        char charAt;
        int length = charSequence.length();
        int i6 = i3 + i2;
        int i7 = 0;
        while (i7 < length && (i5 = i7 + i2) < i6 && (charAt = charSequence.charAt(i7)) < 128) {
            bArr[i5] = (byte) charAt;
            i7++;
        }
        if (i7 == length) {
            return i2 + length;
        }
        int i8 = i2 + i7;
        while (i7 < length) {
            char charAt2 = charSequence.charAt(i7);
            if (charAt2 < 128 && i8 < i6) {
                bArr[i8] = (byte) charAt2;
                i8++;
            } else if (charAt2 < 2048 && i8 <= i6 - 2) {
                int i9 = i8 + 1;
                bArr[i8] = (byte) ((charAt2 >>> 6) | 960);
                i8 += 2;
                bArr[i9] = (byte) ((charAt2 & '?') | 128);
            } else if ((charAt2 < 55296 || 57343 < charAt2) && i8 <= i6 - 3) {
                bArr[i8] = (byte) ((charAt2 >>> 12) | 480);
                int i10 = i8 + 2;
                bArr[i8 + 1] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i8 += 3;
                bArr[i10] = (byte) ((charAt2 & '?') | 128);
            } else if (i8 <= i6 - 4) {
                int i11 = i7 + 1;
                if (i11 != charSequence.length()) {
                    char charAt3 = charSequence.charAt(i11);
                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                        int codePoint = Character.toCodePoint(charAt2, charAt3);
                        bArr[i8] = (byte) ((codePoint >>> 18) | PsExtractor.A);
                        bArr[i8 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                        int i12 = i8 + 3;
                        bArr[i8 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                        i8 += 4;
                        bArr[i12] = (byte) ((codePoint & 63) | 128);
                        i7 = i11;
                    } else {
                        i7 = i11;
                    }
                }
                throw new UnpairedSurrogateException(i7 - 1, length);
            } else if (55296 > charAt2 || charAt2 > 57343 || ((i4 = i7 + 1) != charSequence.length() && Character.isSurrogatePair(charAt2, charSequence.charAt(i4)))) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i8);
            } else {
                throw new UnpairedSurrogateException(i7, length);
            }
            i7++;
        }
        return i8;
    }

    private static void j(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i2;
        int length = charSequence.length();
        int position = byteBuffer.position();
        int i3 = 0;
        while (i3 < length) {
            try {
                char charAt = charSequence.charAt(i3);
                if (charAt >= 128) {
                    break;
                }
                byteBuffer.put(position + i3, (byte) charAt);
                i3++;
            } catch (IndexOutOfBoundsException unused) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i3) + " at index " + (byteBuffer.position() + Math.max(i3, (position - byteBuffer.position()) + 1)));
            }
        }
        if (i3 == length) {
            byteBuffer.position(position + i3);
            return;
        }
        position += i3;
        while (i3 < length) {
            char charAt2 = charSequence.charAt(i3);
            if (charAt2 < 128) {
                byteBuffer.put(position, (byte) charAt2);
            } else if (charAt2 < 2048) {
                i2 = position + 1;
                try {
                    byteBuffer.put(position, (byte) ((charAt2 >>> 6) | PsExtractor.x));
                    byteBuffer.put(i2, (byte) ((charAt2 & '?') | 128));
                    position = i2;
                } catch (IndexOutOfBoundsException unused2) {
                    position = i2;
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i3) + " at index " + (byteBuffer.position() + Math.max(i3, (position - byteBuffer.position()) + 1)));
                }
            } else if (charAt2 < 55296 || 57343 < charAt2) {
                i2 = position + 1;
                byteBuffer.put(position, (byte) ((charAt2 >>> 12) | 224));
                position += 2;
                byteBuffer.put(i2, (byte) (((charAt2 >>> 6) & 63) | 128));
                byteBuffer.put(position, (byte) ((charAt2 & '?') | 128));
            } else {
                int i4 = i3 + 1;
                if (i4 != length) {
                    try {
                        char charAt3 = charSequence.charAt(i4);
                        if (Character.isSurrogatePair(charAt2, charAt3)) {
                            int codePoint = Character.toCodePoint(charAt2, charAt3);
                            int i5 = position + 1;
                            try {
                                byteBuffer.put(position, (byte) ((codePoint >>> 18) | PsExtractor.A));
                                int i6 = position + 2;
                                try {
                                    byteBuffer.put(i5, (byte) (((codePoint >>> 12) & 63) | 128));
                                    position += 3;
                                    byteBuffer.put(i6, (byte) (((codePoint >>> 6) & 63) | 128));
                                    byteBuffer.put(position, (byte) ((codePoint & 63) | 128));
                                    i3 = i4;
                                } catch (IndexOutOfBoundsException unused3) {
                                    i3 = i4;
                                    position = i6;
                                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i3) + " at index " + (byteBuffer.position() + Math.max(i3, (position - byteBuffer.position()) + 1)));
                                }
                            } catch (IndexOutOfBoundsException unused4) {
                                position = i5;
                                i3 = i4;
                                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i3) + " at index " + (byteBuffer.position() + Math.max(i3, (position - byteBuffer.position()) + 1)));
                            }
                        } else {
                            i3 = i4;
                        }
                    } catch (IndexOutOfBoundsException unused5) {
                        i3 = i4;
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i3) + " at index " + (byteBuffer.position() + Math.max(i3, (position - byteBuffer.position()) + 1)));
                    }
                }
                throw new UnpairedSurrogateException(i3, length);
            }
            i3++;
            position++;
        }
        byteBuffer.position(position);
    }

    private static int k(CharSequence charSequence, int i2) {
        int length = charSequence.length();
        int i3 = 0;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            if (charAt < 2048) {
                i3 += (127 - charAt) >>> 31;
            } else {
                i3 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(charSequence, i2) >= 65536) {
                        i2++;
                    } else {
                        throw new UnpairedSurrogateException(i2, length);
                    }
                }
            }
            i2++;
        }
        return i3;
    }

    public String a(ByteBuffer byteBuffer, int i2, int i3) throws IllegalArgumentException {
        return byteBuffer.hasArray() ? g(byteBuffer.array(), byteBuffer.arrayOffset() + i2, i3) : h(byteBuffer, i2, i3);
    }

    public void b(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            int arrayOffset = byteBuffer.arrayOffset();
            byteBuffer.position(i(charSequence, byteBuffer.array(), byteBuffer.position() + arrayOffset, byteBuffer.remaining()) - arrayOffset);
            return;
        }
        j(charSequence, byteBuffer);
    }

    public int c(CharSequence charSequence) {
        return f(charSequence);
    }
}
