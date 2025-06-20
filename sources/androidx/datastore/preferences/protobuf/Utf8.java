package androidx.datastore.preferences.protobuf;

import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.extractor.ts.PsExtractor;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;

final class Utf8 {

    /* renamed from: a  reason: collision with root package name */
    private static final Processor f7294a = ((!UnsafeProcessor.p() || Android.c()) ? new SafeProcessor() : new UnsafeProcessor());

    /* renamed from: b  reason: collision with root package name */
    private static final long f7295b = -9187201950435737472L;

    /* renamed from: c  reason: collision with root package name */
    static final int f7296c = 3;

    /* renamed from: d  reason: collision with root package name */
    public static final int f7297d = 0;

    /* renamed from: e  reason: collision with root package name */
    public static final int f7298e = -1;

    /* renamed from: f  reason: collision with root package name */
    private static final int f7299f = 16;

    private static class DecodeUtil {
        private DecodeUtil() {
        }

        /* access modifiers changed from: private */
        public static void h(byte b2, byte b3, byte b4, byte b5, char[] cArr, int i2) throws InvalidProtocolBufferException {
            if (m(b3) || (((b2 << Ascii.F) + (b3 + 112)) >> 30) != 0 || m(b4) || m(b5)) {
                throw InvalidProtocolBufferException.d();
            }
            int r = ((b2 & 7) << 18) | (r(b3) << 12) | (r(b4) << 6) | r(b5);
            cArr[i2] = l(r);
            cArr[i2 + 1] = q(r);
        }

        /* access modifiers changed from: private */
        public static void i(byte b2, char[] cArr, int i2) {
            cArr[i2] = (char) b2;
        }

        /* access modifiers changed from: private */
        public static void j(byte b2, byte b3, byte b4, char[] cArr, int i2) throws InvalidProtocolBufferException {
            if (m(b3) || ((b2 == -32 && b3 < -96) || ((b2 == -19 && b3 >= -96) || m(b4)))) {
                throw InvalidProtocolBufferException.d();
            }
            cArr[i2] = (char) (((b2 & 15) << 12) | (r(b3) << 6) | r(b4));
        }

        /* access modifiers changed from: private */
        public static void k(byte b2, byte b3, char[] cArr, int i2) throws InvalidProtocolBufferException {
            if (b2 < -62 || m(b3)) {
                throw InvalidProtocolBufferException.d();
            }
            cArr[i2] = (char) (((b2 & Ascii.I) << 6) | r(b3));
        }

        private static char l(int i2) {
            return (char) ((i2 >>> 10) + okio.Utf8.f31407d);
        }

        private static boolean m(byte b2) {
            return b2 > -65;
        }

        /* access modifiers changed from: private */
        public static boolean n(byte b2) {
            return b2 >= 0;
        }

        /* access modifiers changed from: private */
        public static boolean o(byte b2) {
            return b2 < -16;
        }

        /* access modifiers changed from: private */
        public static boolean p(byte b2) {
            return b2 < -32;
        }

        private static char q(int i2) {
            return (char) ((i2 & AnalyticsListener.c0) + okio.Utf8.f31408e);
        }

        private static int r(byte b2) {
            return b2 & okio.Utf8.f31404a;
        }
    }

    static abstract class Processor {
        Processor() {
        }

        private static int m(ByteBuffer byteBuffer, int i2, int i3) {
            int e2 = i2 + Utf8.m(byteBuffer, i2, i3);
            while (e2 < i3) {
                int i4 = e2 + 1;
                byte b2 = byteBuffer.get(e2);
                if (b2 >= 0) {
                    e2 = i4;
                } else if (b2 >= -32) {
                    if (b2 < -16) {
                        if (i4 < i3 - 1) {
                            int i5 = e2 + 2;
                            byte b3 = byteBuffer.get(i4);
                            if (b3 > -65 || ((b2 == -32 && b3 < -96) || ((b2 == -19 && b3 >= -96) || byteBuffer.get(i5) > -65))) {
                                return -1;
                            }
                            e2 += 3;
                        }
                    } else if (i4 < i3 - 2) {
                        int i6 = e2 + 2;
                        byte b4 = byteBuffer.get(i4);
                        if (b4 <= -65 && (((b2 << Ascii.F) + (b4 + 112)) >> 30) == 0) {
                            int i7 = e2 + 3;
                            if (byteBuffer.get(i6) <= -65) {
                                e2 += 4;
                                if (byteBuffer.get(i7) > -65) {
                                }
                            }
                        }
                        return -1;
                    }
                    return Utf8.q(byteBuffer, b2, i4, i3 - i4);
                } else if (i4 >= i3) {
                    return b2;
                } else {
                    if (b2 < -62 || byteBuffer.get(i4) > -65) {
                        return -1;
                    }
                    e2 += 2;
                }
            }
            return 0;
        }

        /* access modifiers changed from: package-private */
        public final String a(ByteBuffer byteBuffer, int i2, int i3) throws InvalidProtocolBufferException {
            if (!byteBuffer.hasArray()) {
                return byteBuffer.isDirect() ? d(byteBuffer, i2, i3) : c(byteBuffer, i2, i3);
            }
            return b(byteBuffer.array(), byteBuffer.arrayOffset() + i2, i3);
        }

        /* access modifiers changed from: package-private */
        public abstract String b(byte[] bArr, int i2, int i3) throws InvalidProtocolBufferException;

        /* access modifiers changed from: package-private */
        public final String c(ByteBuffer byteBuffer, int i2, int i3) throws InvalidProtocolBufferException {
            if ((i2 | i3 | ((byteBuffer.limit() - i2) - i3)) >= 0) {
                int i4 = i2 + i3;
                char[] cArr = new char[i3];
                int i5 = 0;
                while (r14 < i4) {
                    byte b2 = byteBuffer.get(r14);
                    if (!DecodeUtil.n(b2)) {
                        break;
                    }
                    i2 = r14 + 1;
                    DecodeUtil.i(b2, cArr, i5);
                    i5++;
                }
                int i6 = i5;
                while (r14 < i4) {
                    int i7 = r14 + 1;
                    byte b3 = byteBuffer.get(r14);
                    if (DecodeUtil.n(b3)) {
                        int i8 = i6 + 1;
                        DecodeUtil.i(b3, cArr, i6);
                        while (i7 < i4) {
                            byte b4 = byteBuffer.get(i7);
                            if (!DecodeUtil.n(b4)) {
                                break;
                            }
                            i7++;
                            DecodeUtil.i(b4, cArr, i8);
                            i8++;
                        }
                        i6 = i8;
                        r14 = i7;
                    } else if (DecodeUtil.p(b3)) {
                        if (i7 < i4) {
                            r14 += 2;
                            DecodeUtil.k(b3, byteBuffer.get(i7), cArr, i6);
                            i6++;
                        } else {
                            throw InvalidProtocolBufferException.d();
                        }
                    } else if (DecodeUtil.o(b3)) {
                        if (i7 < i4 - 1) {
                            int i9 = r14 + 2;
                            r14 += 3;
                            DecodeUtil.j(b3, byteBuffer.get(i7), byteBuffer.get(i9), cArr, i6);
                            i6++;
                        } else {
                            throw InvalidProtocolBufferException.d();
                        }
                    } else if (i7 < i4 - 2) {
                        byte b5 = byteBuffer.get(i7);
                        int i10 = r14 + 3;
                        byte b6 = byteBuffer.get(r14 + 2);
                        r14 += 4;
                        DecodeUtil.h(b3, b5, b6, byteBuffer.get(i10), cArr, i6);
                        i6 += 2;
                    } else {
                        throw InvalidProtocolBufferException.d();
                    }
                }
                return new String(cArr, 0, i6);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i2), Integer.valueOf(i3)}));
        }

        /* access modifiers changed from: package-private */
        public abstract String d(ByteBuffer byteBuffer, int i2, int i3) throws InvalidProtocolBufferException;

        /* access modifiers changed from: package-private */
        public abstract int e(CharSequence charSequence, byte[] bArr, int i2, int i3);

        /* access modifiers changed from: package-private */
        public final void f(CharSequence charSequence, ByteBuffer byteBuffer) {
            if (byteBuffer.hasArray()) {
                int arrayOffset = byteBuffer.arrayOffset();
                byteBuffer.position(Utf8.i(charSequence, byteBuffer.array(), byteBuffer.position() + arrayOffset, byteBuffer.remaining()) - arrayOffset);
            } else if (byteBuffer.isDirect()) {
                h(charSequence, byteBuffer);
            } else {
                g(charSequence, byteBuffer);
            }
        }

        /* access modifiers changed from: package-private */
        public final void g(CharSequence charSequence, ByteBuffer byteBuffer) {
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

        /* access modifiers changed from: package-private */
        public abstract void h(CharSequence charSequence, ByteBuffer byteBuffer);

        /* access modifiers changed from: package-private */
        public final boolean i(ByteBuffer byteBuffer, int i2, int i3) {
            return k(0, byteBuffer, i2, i3) == 0;
        }

        /* access modifiers changed from: package-private */
        public final boolean j(byte[] bArr, int i2, int i3) {
            return l(0, bArr, i2, i3) == 0;
        }

        /* access modifiers changed from: package-private */
        public final int k(int i2, ByteBuffer byteBuffer, int i3, int i4) {
            if (!byteBuffer.hasArray()) {
                return byteBuffer.isDirect() ? o(i2, byteBuffer, i3, i4) : n(i2, byteBuffer, i3, i4);
            }
            int arrayOffset = byteBuffer.arrayOffset();
            return l(i2, byteBuffer.array(), i3 + arrayOffset, arrayOffset + i4);
        }

        /* access modifiers changed from: package-private */
        public abstract int l(int i2, byte[] bArr, int i3, int i4);

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x004c, code lost:
            if (r8.get(r9) > -65) goto L_0x004e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x008f, code lost:
            if (r8.get(r7) > -65) goto L_0x0091;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0017, code lost:
            if (r8.get(r9) > -65) goto L_0x001d;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int n(int r7, java.nio.ByteBuffer r8, int r9, int r10) {
            /*
                r6 = this;
                if (r7 == 0) goto L_0x0092
                if (r9 < r10) goto L_0x0005
                return r7
            L_0x0005:
                byte r0 = (byte) r7
                r1 = -32
                r2 = -1
                r3 = -65
                if (r0 >= r1) goto L_0x001e
                r7 = -62
                if (r0 < r7) goto L_0x001d
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r9 <= r3) goto L_0x001a
                goto L_0x001d
            L_0x001a:
                r9 = r7
                goto L_0x0092
            L_0x001d:
                return r2
            L_0x001e:
                r4 = -16
                if (r0 >= r4) goto L_0x004f
                int r7 = r7 >> 8
                int r7 = ~r7
                byte r7 = (byte) r7
                if (r7 != 0) goto L_0x0038
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r7 < r10) goto L_0x0035
                int r7 = androidx.datastore.preferences.protobuf.Utf8.o(r0, r9)
                return r7
            L_0x0035:
                r5 = r9
                r9 = r7
                r7 = r5
            L_0x0038:
                if (r7 > r3) goto L_0x004e
                r4 = -96
                if (r0 != r1) goto L_0x0040
                if (r7 < r4) goto L_0x004e
            L_0x0040:
                r1 = -19
                if (r0 != r1) goto L_0x0046
                if (r7 >= r4) goto L_0x004e
            L_0x0046:
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r9 <= r3) goto L_0x001a
            L_0x004e:
                return r2
            L_0x004f:
                int r1 = r7 >> 8
                int r1 = ~r1
                byte r1 = (byte) r1
                if (r1 != 0) goto L_0x0064
                int r7 = r9 + 1
                byte r1 = r8.get(r9)
                if (r7 < r10) goto L_0x0062
                int r7 = androidx.datastore.preferences.protobuf.Utf8.o(r0, r1)
                return r7
            L_0x0062:
                r9 = 0
                goto L_0x006a
            L_0x0064:
                int r7 = r7 >> 16
                byte r7 = (byte) r7
                r5 = r9
                r9 = r7
                r7 = r5
            L_0x006a:
                if (r9 != 0) goto L_0x007c
                int r9 = r7 + 1
                byte r7 = r8.get(r7)
                if (r9 < r10) goto L_0x0079
                int r7 = androidx.datastore.preferences.protobuf.Utf8.p(r0, r1, r7)
                return r7
            L_0x0079:
                r5 = r9
                r9 = r7
                r7 = r5
            L_0x007c:
                if (r1 > r3) goto L_0x0091
                int r0 = r0 << 28
                int r1 = r1 + 112
                int r0 = r0 + r1
                int r0 = r0 >> 30
                if (r0 != 0) goto L_0x0091
                if (r9 > r3) goto L_0x0091
                int r9 = r7 + 1
                byte r7 = r8.get(r7)
                if (r7 <= r3) goto L_0x0092
            L_0x0091:
                return r2
            L_0x0092:
                int r7 = m(r8, r9, r10)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Utf8.Processor.n(int, java.nio.ByteBuffer, int, int):int");
        }

        /* access modifiers changed from: package-private */
        public abstract int o(int i2, ByteBuffer byteBuffer, int i3, int i4);
    }

    static final class SafeProcessor extends Processor {
        SafeProcessor() {
        }

        private static int p(byte[] bArr, int i2, int i3) {
            while (i2 < i3 && bArr[i2] >= 0) {
                i2++;
            }
            if (i2 >= i3) {
                return 0;
            }
            return q(bArr, i2, i3);
        }

        private static int q(byte[] bArr, int i2, int i3) {
            while (i2 < i3) {
                int i4 = i2 + 1;
                byte b2 = bArr[i2];
                if (b2 >= 0) {
                    i2 = i4;
                } else if (b2 < -32) {
                    if (i4 >= i3) {
                        return b2;
                    }
                    if (b2 >= -62) {
                        i2 += 2;
                        if (bArr[i4] > -65) {
                        }
                    }
                    return -1;
                } else if (b2 < -16) {
                    if (i4 >= i3 - 1) {
                        return Utf8.r(bArr, i4, i3);
                    }
                    int i5 = i2 + 2;
                    byte b3 = bArr[i4];
                    if (b3 <= -65 && ((b2 != -32 || b3 >= -96) && (b2 != -19 || b3 < -96))) {
                        i2 += 3;
                        if (bArr[i5] > -65) {
                        }
                    }
                    return -1;
                } else if (i4 >= i3 - 2) {
                    return Utf8.r(bArr, i4, i3);
                } else {
                    int i6 = i2 + 2;
                    byte b4 = bArr[i4];
                    if (b4 <= -65 && (((b2 << Ascii.F) + (b4 + 112)) >> 30) == 0) {
                        int i7 = i2 + 3;
                        if (bArr[i6] <= -65) {
                            i2 += 4;
                            if (bArr[i7] > -65) {
                            }
                        }
                    }
                    return -1;
                }
            }
            return 0;
        }

        /* access modifiers changed from: package-private */
        public String b(byte[] bArr, int i2, int i3) throws InvalidProtocolBufferException {
            if ((i2 | i3 | ((bArr.length - i2) - i3)) >= 0) {
                int i4 = i2 + i3;
                char[] cArr = new char[i3];
                int i5 = 0;
                while (r14 < i4) {
                    byte b2 = bArr[r14];
                    if (!DecodeUtil.n(b2)) {
                        break;
                    }
                    i2 = r14 + 1;
                    DecodeUtil.i(b2, cArr, i5);
                    i5++;
                }
                int i6 = i5;
                while (r14 < i4) {
                    int i7 = r14 + 1;
                    byte b3 = bArr[r14];
                    if (DecodeUtil.n(b3)) {
                        int i8 = i6 + 1;
                        DecodeUtil.i(b3, cArr, i6);
                        while (i7 < i4) {
                            byte b4 = bArr[i7];
                            if (!DecodeUtil.n(b4)) {
                                break;
                            }
                            i7++;
                            DecodeUtil.i(b4, cArr, i8);
                            i8++;
                        }
                        i6 = i8;
                        r14 = i7;
                    } else if (DecodeUtil.p(b3)) {
                        if (i7 < i4) {
                            r14 += 2;
                            DecodeUtil.k(b3, bArr[i7], cArr, i6);
                            i6++;
                        } else {
                            throw InvalidProtocolBufferException.d();
                        }
                    } else if (DecodeUtil.o(b3)) {
                        if (i7 < i4 - 1) {
                            int i9 = r14 + 2;
                            r14 += 3;
                            DecodeUtil.j(b3, bArr[i7], bArr[i9], cArr, i6);
                            i6++;
                        } else {
                            throw InvalidProtocolBufferException.d();
                        }
                    } else if (i7 < i4 - 2) {
                        byte b5 = bArr[i7];
                        int i10 = r14 + 3;
                        byte b6 = bArr[r14 + 2];
                        r14 += 4;
                        DecodeUtil.h(b3, b5, b6, bArr[i10], cArr, i6);
                        i6 += 2;
                    } else {
                        throw InvalidProtocolBufferException.d();
                    }
                }
                return new String(cArr, 0, i6);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)}));
        }

        /* access modifiers changed from: package-private */
        public String d(ByteBuffer byteBuffer, int i2, int i3) throws InvalidProtocolBufferException {
            return c(byteBuffer, i2, i3);
        }

        /* access modifiers changed from: package-private */
        public int e(CharSequence charSequence, byte[] bArr, int i2, int i3) {
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

        /* access modifiers changed from: package-private */
        public void h(CharSequence charSequence, ByteBuffer byteBuffer) {
            g(charSequence, byteBuffer);
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0046, code lost:
            if (r8[r9] > -65) goto L_0x0048;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0083, code lost:
            if (r8[r7] > -65) goto L_0x0085;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0015, code lost:
            if (r8[r9] > -65) goto L_0x001b;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int l(int r7, byte[] r8, int r9, int r10) {
            /*
                r6 = this;
                if (r7 == 0) goto L_0x0086
                if (r9 < r10) goto L_0x0005
                return r7
            L_0x0005:
                byte r0 = (byte) r7
                r1 = -32
                r2 = -1
                r3 = -65
                if (r0 >= r1) goto L_0x001c
                r7 = -62
                if (r0 < r7) goto L_0x001b
                int r7 = r9 + 1
                byte r9 = r8[r9]
                if (r9 <= r3) goto L_0x0018
                goto L_0x001b
            L_0x0018:
                r9 = r7
                goto L_0x0086
            L_0x001b:
                return r2
            L_0x001c:
                r4 = -16
                if (r0 >= r4) goto L_0x0049
                int r7 = r7 >> 8
                int r7 = ~r7
                byte r7 = (byte) r7
                if (r7 != 0) goto L_0x0034
                int r7 = r9 + 1
                byte r9 = r8[r9]
                if (r7 < r10) goto L_0x0031
                int r7 = androidx.datastore.preferences.protobuf.Utf8.o(r0, r9)
                return r7
            L_0x0031:
                r5 = r9
                r9 = r7
                r7 = r5
            L_0x0034:
                if (r7 > r3) goto L_0x0048
                r4 = -96
                if (r0 != r1) goto L_0x003c
                if (r7 < r4) goto L_0x0048
            L_0x003c:
                r1 = -19
                if (r0 != r1) goto L_0x0042
                if (r7 >= r4) goto L_0x0048
            L_0x0042:
                int r7 = r9 + 1
                byte r9 = r8[r9]
                if (r9 <= r3) goto L_0x0018
            L_0x0048:
                return r2
            L_0x0049:
                int r1 = r7 >> 8
                int r1 = ~r1
                byte r1 = (byte) r1
                if (r1 != 0) goto L_0x005c
                int r7 = r9 + 1
                byte r1 = r8[r9]
                if (r7 < r10) goto L_0x005a
                int r7 = androidx.datastore.preferences.protobuf.Utf8.o(r0, r1)
                return r7
            L_0x005a:
                r9 = 0
                goto L_0x0062
            L_0x005c:
                int r7 = r7 >> 16
                byte r7 = (byte) r7
                r5 = r9
                r9 = r7
                r7 = r5
            L_0x0062:
                if (r9 != 0) goto L_0x0072
                int r9 = r7 + 1
                byte r7 = r8[r7]
                if (r9 < r10) goto L_0x006f
                int r7 = androidx.datastore.preferences.protobuf.Utf8.p(r0, r1, r7)
                return r7
            L_0x006f:
                r5 = r9
                r9 = r7
                r7 = r5
            L_0x0072:
                if (r1 > r3) goto L_0x0085
                int r0 = r0 << 28
                int r1 = r1 + 112
                int r0 = r0 + r1
                int r0 = r0 >> 30
                if (r0 != 0) goto L_0x0085
                if (r9 > r3) goto L_0x0085
                int r9 = r7 + 1
                byte r7 = r8[r7]
                if (r7 <= r3) goto L_0x0086
            L_0x0085:
                return r2
            L_0x0086:
                int r7 = p(r8, r9, r10)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Utf8.SafeProcessor.l(int, byte[], int, int):int");
        }

        /* access modifiers changed from: package-private */
        public int o(int i2, ByteBuffer byteBuffer, int i3, int i4) {
            return n(i2, byteBuffer, i3, i4);
        }
    }

    static class UnpairedSurrogateException extends IllegalArgumentException {
        UnpairedSurrogateException(int i2, int i3) {
            super("Unpaired surrogate at index " + i2 + " of " + i3);
        }
    }

    static final class UnsafeProcessor extends Processor {
        UnsafeProcessor() {
        }

        static boolean p() {
            return UnsafeUtil.S() && UnsafeUtil.T();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0039, code lost:
            return -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0064, code lost:
            return -1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static int q(long r10, int r12) {
            /*
                int r0 = s(r10, r12)
                long r1 = (long) r0
                long r10 = r10 + r1
                int r12 = r12 - r0
            L_0x0007:
                r0 = 0
                r1 = 0
            L_0x0009:
                r2 = 1
                if (r12 <= 0) goto L_0x001a
                long r4 = r10 + r2
                byte r1 = androidx.datastore.preferences.protobuf.UnsafeUtil.y(r10)
                if (r1 < 0) goto L_0x0019
                int r12 = r12 + -1
                r10 = r4
                goto L_0x0009
            L_0x0019:
                r10 = r4
            L_0x001a:
                if (r12 != 0) goto L_0x001d
                return r0
            L_0x001d:
                int r0 = r12 + -1
                r4 = -32
                r5 = -1
                r6 = -65
                if (r1 >= r4) goto L_0x003a
                if (r0 != 0) goto L_0x0029
                return r1
            L_0x0029:
                int r12 = r12 + -2
                r0 = -62
                if (r1 < r0) goto L_0x0039
                long r2 = r2 + r10
                byte r10 = androidx.datastore.preferences.protobuf.UnsafeUtil.y(r10)
                if (r10 <= r6) goto L_0x0037
                goto L_0x0039
            L_0x0037:
                r10 = r2
                goto L_0x0007
            L_0x0039:
                return r5
            L_0x003a:
                r7 = -16
                r8 = 2
                if (r1 >= r7) goto L_0x0065
                r7 = 2
                if (r0 >= r7) goto L_0x0048
                int r10 = u(r10, r1, r0)
                return r10
            L_0x0048:
                int r12 = r12 + -3
                long r2 = r2 + r10
                byte r0 = androidx.datastore.preferences.protobuf.UnsafeUtil.y(r10)
                if (r0 > r6) goto L_0x0064
                r7 = -96
                if (r1 != r4) goto L_0x0057
                if (r0 < r7) goto L_0x0064
            L_0x0057:
                r4 = -19
                if (r1 != r4) goto L_0x005d
                if (r0 >= r7) goto L_0x0064
            L_0x005d:
                long r10 = r10 + r8
                byte r0 = androidx.datastore.preferences.protobuf.UnsafeUtil.y(r2)
                if (r0 <= r6) goto L_0x0007
            L_0x0064:
                return r5
            L_0x0065:
                r4 = 3
                if (r0 >= r4) goto L_0x006d
                int r10 = u(r10, r1, r0)
                return r10
            L_0x006d:
                int r12 = r12 + -4
                long r2 = r2 + r10
                byte r0 = androidx.datastore.preferences.protobuf.UnsafeUtil.y(r10)
                if (r0 > r6) goto L_0x008f
                int r1 = r1 << 28
                int r0 = r0 + 112
                int r1 = r1 + r0
                int r0 = r1 >> 30
                if (r0 != 0) goto L_0x008f
                long r8 = r8 + r10
                byte r0 = androidx.datastore.preferences.protobuf.UnsafeUtil.y(r2)
                if (r0 > r6) goto L_0x008f
                r0 = 3
                long r10 = r10 + r0
                byte r0 = androidx.datastore.preferences.protobuf.UnsafeUtil.y(r8)
                if (r0 <= r6) goto L_0x0007
            L_0x008f:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Utf8.UnsafeProcessor.q(long, int):int");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0039, code lost:
            return -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0064, code lost:
            return -1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static int r(byte[] r10, long r11, int r13) {
            /*
                int r0 = t(r10, r11, r13)
                int r13 = r13 - r0
                long r0 = (long) r0
                long r11 = r11 + r0
            L_0x0007:
                r0 = 0
                r1 = 0
            L_0x0009:
                r2 = 1
                if (r13 <= 0) goto L_0x001a
                long r4 = r11 + r2
                byte r1 = androidx.datastore.preferences.protobuf.UnsafeUtil.A(r10, r11)
                if (r1 < 0) goto L_0x0019
                int r13 = r13 + -1
                r11 = r4
                goto L_0x0009
            L_0x0019:
                r11 = r4
            L_0x001a:
                if (r13 != 0) goto L_0x001d
                return r0
            L_0x001d:
                int r0 = r13 + -1
                r4 = -32
                r5 = -1
                r6 = -65
                if (r1 >= r4) goto L_0x003a
                if (r0 != 0) goto L_0x0029
                return r1
            L_0x0029:
                int r13 = r13 + -2
                r0 = -62
                if (r1 < r0) goto L_0x0039
                long r2 = r2 + r11
                byte r11 = androidx.datastore.preferences.protobuf.UnsafeUtil.A(r10, r11)
                if (r11 <= r6) goto L_0x0037
                goto L_0x0039
            L_0x0037:
                r11 = r2
                goto L_0x0007
            L_0x0039:
                return r5
            L_0x003a:
                r7 = -16
                r8 = 2
                if (r1 >= r7) goto L_0x0065
                r7 = 2
                if (r0 >= r7) goto L_0x0048
                int r10 = v(r10, r1, r11, r0)
                return r10
            L_0x0048:
                int r13 = r13 + -3
                long r2 = r2 + r11
                byte r0 = androidx.datastore.preferences.protobuf.UnsafeUtil.A(r10, r11)
                if (r0 > r6) goto L_0x0064
                r7 = -96
                if (r1 != r4) goto L_0x0057
                if (r0 < r7) goto L_0x0064
            L_0x0057:
                r4 = -19
                if (r1 != r4) goto L_0x005d
                if (r0 >= r7) goto L_0x0064
            L_0x005d:
                long r11 = r11 + r8
                byte r0 = androidx.datastore.preferences.protobuf.UnsafeUtil.A(r10, r2)
                if (r0 <= r6) goto L_0x0007
            L_0x0064:
                return r5
            L_0x0065:
                r4 = 3
                if (r0 >= r4) goto L_0x006d
                int r10 = v(r10, r1, r11, r0)
                return r10
            L_0x006d:
                int r13 = r13 + -4
                long r2 = r2 + r11
                byte r0 = androidx.datastore.preferences.protobuf.UnsafeUtil.A(r10, r11)
                if (r0 > r6) goto L_0x008f
                int r1 = r1 << 28
                int r0 = r0 + 112
                int r1 = r1 + r0
                int r0 = r1 >> 30
                if (r0 != 0) goto L_0x008f
                long r8 = r8 + r11
                byte r0 = androidx.datastore.preferences.protobuf.UnsafeUtil.A(r10, r2)
                if (r0 > r6) goto L_0x008f
                r0 = 3
                long r11 = r11 + r0
                byte r0 = androidx.datastore.preferences.protobuf.UnsafeUtil.A(r10, r8)
                if (r0 <= r6) goto L_0x0007
            L_0x008f:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Utf8.UnsafeProcessor.r(byte[], long, int):int");
        }

        private static int s(long j2, int i2) {
            if (i2 < 16) {
                return 0;
            }
            int i3 = 8 - (((int) j2) & 7);
            int i4 = i3;
            while (i4 > 0) {
                long j3 = 1 + j2;
                if (UnsafeUtil.y(j2) < 0) {
                    return i3 - i4;
                }
                i4--;
                j2 = j3;
            }
            int i5 = i2 - i3;
            while (i5 >= 8 && (UnsafeUtil.K(j2) & Utf8.f7295b) == 0) {
                j2 += 8;
                i5 -= 8;
            }
            return i2 - i5;
        }

        private static int t(byte[] bArr, long j2, int i2) {
            int i3 = 0;
            if (i2 < 16) {
                return 0;
            }
            while (i3 < i2) {
                long j3 = 1 + j2;
                if (UnsafeUtil.A(bArr, j2) < 0) {
                    return i3;
                }
                i3++;
                j2 = j3;
            }
            return i2;
        }

        private static int u(long j2, int i2, int i3) {
            if (i3 == 0) {
                return Utf8.n(i2);
            }
            if (i3 == 1) {
                return Utf8.o(i2, UnsafeUtil.y(j2));
            }
            if (i3 == 2) {
                return Utf8.p(i2, UnsafeUtil.y(j2), UnsafeUtil.y(j2 + 1));
            }
            throw new AssertionError();
        }

        private static int v(byte[] bArr, int i2, long j2, int i3) {
            if (i3 == 0) {
                return Utf8.n(i2);
            }
            if (i3 == 1) {
                return Utf8.o(i2, UnsafeUtil.A(bArr, j2));
            }
            if (i3 == 2) {
                return Utf8.p(i2, UnsafeUtil.A(bArr, j2), UnsafeUtil.A(bArr, j2 + 1));
            }
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        public String b(byte[] bArr, int i2, int i3) throws InvalidProtocolBufferException {
            if ((i2 | i3 | ((bArr.length - i2) - i3)) >= 0) {
                int i4 = i2 + i3;
                char[] cArr = new char[i3];
                int i5 = 0;
                while (r14 < i4) {
                    byte A = UnsafeUtil.A(bArr, (long) r14);
                    if (!DecodeUtil.n(A)) {
                        break;
                    }
                    i2 = r14 + 1;
                    DecodeUtil.i(A, cArr, i5);
                    i5++;
                }
                int i6 = i5;
                while (r14 < i4) {
                    int i7 = r14 + 1;
                    byte A2 = UnsafeUtil.A(bArr, (long) r14);
                    if (DecodeUtil.n(A2)) {
                        int i8 = i6 + 1;
                        DecodeUtil.i(A2, cArr, i6);
                        while (i7 < i4) {
                            byte A3 = UnsafeUtil.A(bArr, (long) i7);
                            if (!DecodeUtil.n(A3)) {
                                break;
                            }
                            i7++;
                            DecodeUtil.i(A3, cArr, i8);
                            i8++;
                        }
                        i6 = i8;
                        r14 = i7;
                    } else if (DecodeUtil.p(A2)) {
                        if (i7 < i4) {
                            r14 += 2;
                            DecodeUtil.k(A2, UnsafeUtil.A(bArr, (long) i7), cArr, i6);
                            i6++;
                        } else {
                            throw InvalidProtocolBufferException.d();
                        }
                    } else if (DecodeUtil.o(A2)) {
                        if (i7 < i4 - 1) {
                            int i9 = r14 + 2;
                            r14 += 3;
                            DecodeUtil.j(A2, UnsafeUtil.A(bArr, (long) i7), UnsafeUtil.A(bArr, (long) i9), cArr, i6);
                            i6++;
                        } else {
                            throw InvalidProtocolBufferException.d();
                        }
                    } else if (i7 < i4 - 2) {
                        byte A4 = UnsafeUtil.A(bArr, (long) i7);
                        int i10 = r14 + 3;
                        r14 += 4;
                        DecodeUtil.h(A2, A4, UnsafeUtil.A(bArr, (long) (r14 + 2)), UnsafeUtil.A(bArr, (long) i10), cArr, i6);
                        i6 += 2;
                    } else {
                        throw InvalidProtocolBufferException.d();
                    }
                }
                return new String(cArr, 0, i6);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)}));
        }

        /* access modifiers changed from: package-private */
        public String d(ByteBuffer byteBuffer, int i2, int i3) throws InvalidProtocolBufferException {
            long j2;
            int i4;
            int i5 = i2;
            int i6 = i3;
            if ((i5 | i6 | ((byteBuffer.limit() - i5) - i6)) >= 0) {
                long i7 = UnsafeUtil.i(byteBuffer) + ((long) i5);
                long j3 = ((long) i6) + i7;
                char[] cArr = new char[i6];
                int i8 = 0;
                while (j2 < j3) {
                    byte y = UnsafeUtil.y(j2);
                    if (!DecodeUtil.n(y)) {
                        break;
                    }
                    i7 = j2 + 1;
                    DecodeUtil.i(y, cArr, i4);
                    i8 = i4 + 1;
                }
                while (j2 < j3) {
                    long j4 = j2 + 1;
                    byte y2 = UnsafeUtil.y(j2);
                    if (DecodeUtil.n(y2)) {
                        int i9 = i4 + 1;
                        DecodeUtil.i(y2, cArr, i4);
                        while (j4 < j3) {
                            byte y3 = UnsafeUtil.y(j4);
                            if (!DecodeUtil.n(y3)) {
                                break;
                            }
                            j4++;
                            DecodeUtil.i(y3, cArr, i9);
                            i9++;
                        }
                        i4 = i9;
                        j2 = j4;
                    } else if (DecodeUtil.p(y2)) {
                        if (j4 < j3) {
                            j2 += 2;
                            DecodeUtil.k(y2, UnsafeUtil.y(j4), cArr, i4);
                            i4++;
                        } else {
                            throw InvalidProtocolBufferException.d();
                        }
                    } else if (DecodeUtil.o(y2)) {
                        if (j4 < j3 - 1) {
                            long j5 = 2 + j2;
                            j2 += 3;
                            DecodeUtil.j(y2, UnsafeUtil.y(j4), UnsafeUtil.y(j5), cArr, i4);
                            i4++;
                        } else {
                            throw InvalidProtocolBufferException.d();
                        }
                    } else if (j4 < j3 - 2) {
                        byte y4 = UnsafeUtil.y(j4);
                        long j6 = j2 + 3;
                        byte y5 = UnsafeUtil.y(2 + j2);
                        j2 += 4;
                        DecodeUtil.h(y2, y4, y5, UnsafeUtil.y(j6), cArr, i4);
                        i4 += 2;
                    } else {
                        throw InvalidProtocolBufferException.d();
                    }
                }
                return new String(cArr, 0, i4);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i2), Integer.valueOf(i3)}));
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0033 A[LOOP:1: B:13:0x0033->B:38:0x00f8, LOOP_START, PHI: r2 r4 r6 r9 r10 r11 
          PHI: (r2v3 int) = (r2v2 int), (r2v5 int) binds: [B:10:0x002f, B:38:0x00f8] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r4v3 long) = (r4v2 long), (r4v4 long) binds: [B:10:0x002f, B:38:0x00f8] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r6v3 long) = (r6v1 long), (r6v4 long) binds: [B:10:0x002f, B:38:0x00f8] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r9v1 java.lang.String) = (r9v0 java.lang.String), (r9v2 java.lang.String) binds: [B:10:0x002f, B:38:0x00f8] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r10v1 java.lang.String) = (r10v0 java.lang.String), (r10v2 java.lang.String) binds: [B:10:0x002f, B:38:0x00f8] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r11v3 long) = (r11v2 long), (r11v4 long) binds: [B:10:0x002f, B:38:0x00f8] A[DONT_GENERATE, DONT_INLINE]] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int e(java.lang.CharSequence r25, byte[] r26, int r27, int r28) {
            /*
                r24 = this;
                r0 = r25
                r1 = r26
                r2 = r27
                r3 = r28
                long r4 = (long) r2
                long r6 = (long) r3
                long r6 = r6 + r4
                int r8 = r25.length()
                java.lang.String r9 = " at index "
                java.lang.String r10 = "Failed writing "
                if (r8 > r3) goto L_0x0144
                int r11 = r1.length
                int r11 = r11 - r3
                if (r11 < r2) goto L_0x0144
                r2 = 0
            L_0x001a:
                r11 = 1
                r3 = 128(0x80, float:1.794E-43)
                if (r2 >= r8) goto L_0x002f
                char r13 = r0.charAt(r2)
                if (r13 >= r3) goto L_0x002f
                long r11 = r11 + r4
                byte r3 = (byte) r13
                androidx.datastore.preferences.protobuf.UnsafeUtil.d0(r1, r4, r3)
                int r2 = r2 + 1
                r4 = r11
                goto L_0x001a
            L_0x002f:
                if (r2 != r8) goto L_0x0033
                int r0 = (int) r4
                return r0
            L_0x0033:
                if (r2 >= r8) goto L_0x0142
                char r13 = r0.charAt(r2)
                if (r13 >= r3) goto L_0x004f
                int r14 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r14 >= 0) goto L_0x004f
                long r14 = r4 + r11
                byte r13 = (byte) r13
                androidx.datastore.preferences.protobuf.UnsafeUtil.d0(r1, r4, r13)
                r22 = r6
                r17 = r10
                r20 = r11
                r4 = r14
                r14 = r9
                goto L_0x00f8
            L_0x004f:
                r14 = 2048(0x800, float:2.87E-42)
                r15 = 2
                if (r13 >= r14) goto L_0x0076
                long r17 = r6 - r15
                int r14 = (r4 > r17 ? 1 : (r4 == r17 ? 0 : -1))
                if (r14 > 0) goto L_0x0076
                r14 = r9
                r17 = r10
                long r9 = r4 + r11
                int r11 = r13 >>> 6
                r11 = r11 | 960(0x3c0, float:1.345E-42)
                byte r11 = (byte) r11
                androidx.datastore.preferences.protobuf.UnsafeUtil.d0(r1, r4, r11)
                long r4 = r4 + r15
                r11 = r13 & 63
                r11 = r11 | r3
                byte r11 = (byte) r11
                androidx.datastore.preferences.protobuf.UnsafeUtil.d0(r1, r9, r11)
            L_0x0070:
                r22 = r6
                r20 = 1
                goto L_0x00f8
            L_0x0076:
                r14 = r9
                r17 = r10
                r9 = 57343(0xdfff, float:8.0355E-41)
                r10 = 55296(0xd800, float:7.7486E-41)
                r11 = 3
                if (r13 < r10) goto L_0x0085
                if (r9 >= r13) goto L_0x00ad
            L_0x0085:
                long r18 = r6 - r11
                int r20 = (r4 > r18 ? 1 : (r4 == r18 ? 0 : -1))
                if (r20 > 0) goto L_0x00ad
                r18 = 1
                long r9 = r4 + r18
                int r11 = r13 >>> 12
                r11 = r11 | 480(0x1e0, float:6.73E-43)
                byte r11 = (byte) r11
                androidx.datastore.preferences.protobuf.UnsafeUtil.d0(r1, r4, r11)
                long r11 = r4 + r15
                int r15 = r13 >>> 6
                r15 = r15 & 63
                r15 = r15 | r3
                byte r15 = (byte) r15
                androidx.datastore.preferences.protobuf.UnsafeUtil.d0(r1, r9, r15)
                r9 = 3
                long r4 = r4 + r9
                r9 = r13 & 63
                r9 = r9 | r3
                byte r9 = (byte) r9
                androidx.datastore.preferences.protobuf.UnsafeUtil.d0(r1, r11, r9)
                goto L_0x0070
            L_0x00ad:
                r11 = 4
                long r20 = r6 - r11
                int r22 = (r4 > r20 ? 1 : (r4 == r20 ? 0 : -1))
                if (r22 > 0) goto L_0x010c
                int r9 = r2 + 1
                if (r9 == r8) goto L_0x0104
                char r2 = r0.charAt(r9)
                boolean r10 = java.lang.Character.isSurrogatePair(r13, r2)
                if (r10 == 0) goto L_0x0103
                int r2 = java.lang.Character.toCodePoint(r13, r2)
                r20 = 1
                long r11 = r4 + r20
                int r10 = r2 >>> 18
                r10 = r10 | 240(0xf0, float:3.36E-43)
                byte r10 = (byte) r10
                androidx.datastore.preferences.protobuf.UnsafeUtil.d0(r1, r4, r10)
                r22 = r6
                long r6 = r4 + r15
                int r10 = r2 >>> 12
                r10 = r10 & 63
                r10 = r10 | r3
                byte r10 = (byte) r10
                androidx.datastore.preferences.protobuf.UnsafeUtil.d0(r1, r11, r10)
                r10 = 3
                long r11 = r4 + r10
                int r10 = r2 >>> 6
                r10 = r10 & 63
                r10 = r10 | r3
                byte r10 = (byte) r10
                androidx.datastore.preferences.protobuf.UnsafeUtil.d0(r1, r6, r10)
                r6 = 4
                long r4 = r4 + r6
                r2 = r2 & 63
                r2 = r2 | r3
                byte r2 = (byte) r2
                androidx.datastore.preferences.protobuf.UnsafeUtil.d0(r1, r11, r2)
                r2 = r9
            L_0x00f8:
                int r2 = r2 + 1
                r9 = r14
                r10 = r17
                r11 = r20
                r6 = r22
                goto L_0x0033
            L_0x0103:
                r2 = r9
            L_0x0104:
                androidx.datastore.preferences.protobuf.Utf8$UnpairedSurrogateException r0 = new androidx.datastore.preferences.protobuf.Utf8$UnpairedSurrogateException
                int r2 = r2 + -1
                r0.<init>(r2, r8)
                throw r0
            L_0x010c:
                if (r10 > r13) goto L_0x0124
                if (r13 > r9) goto L_0x0124
                int r1 = r2 + 1
                if (r1 == r8) goto L_0x011e
                char r0 = r0.charAt(r1)
                boolean r0 = java.lang.Character.isSurrogatePair(r13, r0)
                if (r0 != 0) goto L_0x0124
            L_0x011e:
                androidx.datastore.preferences.protobuf.Utf8$UnpairedSurrogateException r0 = new androidx.datastore.preferences.protobuf.Utf8$UnpairedSurrogateException
                r0.<init>(r2, r8)
                throw r0
            L_0x0124:
                java.lang.ArrayIndexOutOfBoundsException r0 = new java.lang.ArrayIndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r6 = r17
                r1.append(r6)
                r1.append(r13)
                r7 = r14
                r1.append(r7)
                r1.append(r4)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x0142:
                int r0 = (int) r4
                return r0
            L_0x0144:
                r7 = r9
                r6 = r10
                java.lang.ArrayIndexOutOfBoundsException r1 = new java.lang.ArrayIndexOutOfBoundsException
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                r4.append(r6)
                int r8 = r8 + -1
                char r0 = r0.charAt(r8)
                r4.append(r0)
                r4.append(r7)
                int r0 = r2 + r3
                r4.append(r0)
                java.lang.String r0 = r4.toString()
                r1.<init>(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Utf8.UnsafeProcessor.e(java.lang.CharSequence, byte[], int, int):int");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0041 A[LOOP:1: B:12:0x0041->B:37:0x010f, LOOP_START, PHI: r2 r4 r6 r9 r10 r12 
          PHI: (r2v2 long) = (r2v0 long), (r2v3 long) binds: [B:8:0x0039, B:37:0x010f] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r4v4 long) = (r4v3 long), (r4v6 long) binds: [B:8:0x0039, B:37:0x010f] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r6v3 long) = (r6v2 long), (r6v4 long) binds: [B:8:0x0039, B:37:0x010f] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r9v3 int) = (r9v2 int), (r9v4 int) binds: [B:8:0x0039, B:37:0x010f] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r10v1 long) = (r10v0 long), (r10v2 long) binds: [B:8:0x0039, B:37:0x010f] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r12v1 char) = (r12v0 char), (r12v2 char) binds: [B:8:0x0039, B:37:0x010f] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARNING: Removed duplicated region for block: B:9:0x003b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void h(java.lang.CharSequence r30, java.nio.ByteBuffer r31) {
            /*
                r29 = this;
                r0 = r30
                r1 = r31
                long r2 = androidx.datastore.preferences.protobuf.UnsafeUtil.i(r31)
                int r4 = r31.position()
                long r4 = (long) r4
                long r4 = r4 + r2
                int r6 = r31.limit()
                long r6 = (long) r6
                long r6 = r6 + r2
                int r8 = r30.length()
                long r9 = (long) r8
                long r11 = r6 - r4
                java.lang.String r13 = " at index "
                java.lang.String r14 = "Failed writing "
                int r15 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
                if (r15 > 0) goto L_0x0163
                r9 = 0
            L_0x0024:
                r10 = 1
                r12 = 128(0x80, float:1.794E-43)
                if (r9 >= r8) goto L_0x0039
                char r15 = r0.charAt(r9)
                if (r15 >= r12) goto L_0x0039
                long r10 = r10 + r4
                byte r12 = (byte) r15
                androidx.datastore.preferences.protobuf.UnsafeUtil.b0(r4, r12)
                int r9 = r9 + 1
                r4 = r10
                goto L_0x0024
            L_0x0039:
                if (r9 != r8) goto L_0x0041
                long r4 = r4 - r2
                int r0 = (int) r4
            L_0x003d:
                r1.position(r0)
                return
            L_0x0041:
                if (r9 >= r8) goto L_0x015a
                char r15 = r0.charAt(r9)
                if (r15 >= r12) goto L_0x0060
                int r16 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r16 >= 0) goto L_0x0060
                long r16 = r4 + r10
                byte r15 = (byte) r15
                androidx.datastore.preferences.protobuf.UnsafeUtil.b0(r4, r15)
                r19 = r2
                r27 = r6
                r1 = r9
                r23 = r10
                r4 = r16
            L_0x005c:
                r9 = 128(0x80, float:1.794E-43)
                goto L_0x010f
            L_0x0060:
                r12 = 2048(0x800, float:2.87E-42)
                r17 = 2
                if (r15 >= r12) goto L_0x0089
                long r19 = r6 - r17
                int r12 = (r4 > r19 ? 1 : (r4 == r19 ? 0 : -1))
                if (r12 > 0) goto L_0x0089
                r19 = r2
                long r1 = r4 + r10
                int r3 = r15 >>> 6
                r3 = r3 | 960(0x3c0, float:1.345E-42)
                byte r3 = (byte) r3
                androidx.datastore.preferences.protobuf.UnsafeUtil.b0(r4, r3)
                long r4 = r4 + r17
                r3 = r15 & 63
                r12 = 128(0x80, float:1.794E-43)
                r3 = r3 | r12
                byte r3 = (byte) r3
                androidx.datastore.preferences.protobuf.UnsafeUtil.b0(r1, r3)
                r27 = r6
                r1 = r9
                r23 = r10
                goto L_0x005c
            L_0x0089:
                r19 = r2
                r1 = 57343(0xdfff, float:8.0355E-41)
                r2 = 55296(0xd800, float:7.7486E-41)
                r21 = 3
                if (r15 < r2) goto L_0x0097
                if (r1 >= r15) goto L_0x00c5
            L_0x0097:
                long r23 = r6 - r21
                int r3 = (r4 > r23 ? 1 : (r4 == r23 ? 0 : -1))
                if (r3 > 0) goto L_0x00c5
                long r1 = r4 + r10
                int r3 = r15 >>> 12
                r3 = r3 | 480(0x1e0, float:6.73E-43)
                byte r3 = (byte) r3
                androidx.datastore.preferences.protobuf.UnsafeUtil.b0(r4, r3)
                long r10 = r4 + r17
                int r3 = r15 >>> 6
                r3 = r3 & 63
                r12 = 128(0x80, float:1.794E-43)
                r3 = r3 | r12
                byte r3 = (byte) r3
                androidx.datastore.preferences.protobuf.UnsafeUtil.b0(r1, r3)
                long r4 = r4 + r21
                r1 = r15 & 63
                r1 = r1 | r12
                byte r1 = (byte) r1
                androidx.datastore.preferences.protobuf.UnsafeUtil.b0(r10, r1)
                r27 = r6
                r1 = r9
                r9 = 128(0x80, float:1.794E-43)
                r23 = 1
                goto L_0x010f
            L_0x00c5:
                r10 = 4
                long r25 = r6 - r10
                int r3 = (r4 > r25 ? 1 : (r4 == r25 ? 0 : -1))
                if (r3 > 0) goto L_0x0127
                int r1 = r9 + 1
                if (r1 == r8) goto L_0x011f
                char r2 = r0.charAt(r1)
                boolean r3 = java.lang.Character.isSurrogatePair(r15, r2)
                if (r3 == 0) goto L_0x011e
                int r2 = java.lang.Character.toCodePoint(r15, r2)
                r23 = 1
                long r10 = r4 + r23
                int r3 = r2 >>> 18
                r3 = r3 | 240(0xf0, float:3.36E-43)
                byte r3 = (byte) r3
                androidx.datastore.preferences.protobuf.UnsafeUtil.b0(r4, r3)
                r27 = r6
                long r6 = r4 + r17
                int r3 = r2 >>> 12
                r3 = r3 & 63
                r9 = 128(0x80, float:1.794E-43)
                r3 = r3 | r9
                byte r3 = (byte) r3
                androidx.datastore.preferences.protobuf.UnsafeUtil.b0(r10, r3)
                long r10 = r4 + r21
                int r3 = r2 >>> 6
                r3 = r3 & 63
                r3 = r3 | r9
                byte r3 = (byte) r3
                androidx.datastore.preferences.protobuf.UnsafeUtil.b0(r6, r3)
                r6 = 4
                long r4 = r4 + r6
                r2 = r2 & 63
                r2 = r2 | r9
                byte r2 = (byte) r2
                androidx.datastore.preferences.protobuf.UnsafeUtil.b0(r10, r2)
            L_0x010f:
                int r1 = r1 + 1
                r9 = r1
                r2 = r19
                r10 = r23
                r6 = r27
                r12 = 128(0x80, float:1.794E-43)
                r1 = r31
                goto L_0x0041
            L_0x011e:
                r9 = r1
            L_0x011f:
                androidx.datastore.preferences.protobuf.Utf8$UnpairedSurrogateException r0 = new androidx.datastore.preferences.protobuf.Utf8$UnpairedSurrogateException
                int r9 = r9 + -1
                r0.<init>(r9, r8)
                throw r0
            L_0x0127:
                if (r2 > r15) goto L_0x013f
                if (r15 > r1) goto L_0x013f
                int r1 = r9 + 1
                if (r1 == r8) goto L_0x0139
                char r0 = r0.charAt(r1)
                boolean r0 = java.lang.Character.isSurrogatePair(r15, r0)
                if (r0 != 0) goto L_0x013f
            L_0x0139:
                androidx.datastore.preferences.protobuf.Utf8$UnpairedSurrogateException r0 = new androidx.datastore.preferences.protobuf.Utf8$UnpairedSurrogateException
                r0.<init>(r9, r8)
                throw r0
            L_0x013f:
                java.lang.ArrayIndexOutOfBoundsException r0 = new java.lang.ArrayIndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r14)
                r1.append(r15)
                r1.append(r13)
                r1.append(r4)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x015a:
                r19 = r2
                long r4 = r4 - r19
                int r0 = (int) r4
                r1 = r31
                goto L_0x003d
            L_0x0163:
                java.lang.ArrayIndexOutOfBoundsException r2 = new java.lang.ArrayIndexOutOfBoundsException
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r14)
                int r8 = r8 + -1
                char r0 = r0.charAt(r8)
                r3.append(r0)
                r3.append(r13)
                int r0 = r31.limit()
                r3.append(r0)
                java.lang.String r0 = r3.toString()
                r2.<init>(r0)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Utf8.UnsafeProcessor.h(java.lang.CharSequence, java.nio.ByteBuffer):void");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0059, code lost:
            if (androidx.datastore.preferences.protobuf.UnsafeUtil.A(r13, r1) > -65) goto L_0x005e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x009e, code lost:
            if (androidx.datastore.preferences.protobuf.UnsafeUtil.A(r13, r1) > -65) goto L_0x00a0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int l(int r12, byte[] r13, int r14, int r15) {
            /*
                r11 = this;
                r0 = 0
                r1 = r14 | r15
                int r2 = r13.length
                int r2 = r2 - r15
                r1 = r1 | r2
                if (r1 < 0) goto L_0x00a8
                long r1 = (long) r14
                long r14 = (long) r15
                if (r12 == 0) goto L_0x00a1
                int r3 = (r1 > r14 ? 1 : (r1 == r14 ? 0 : -1))
                if (r3 < 0) goto L_0x0011
                return r12
            L_0x0011:
                byte r3 = (byte) r12
                r4 = -32
                r5 = -1
                r6 = -65
                r7 = 1
                if (r3 >= r4) goto L_0x002b
                r12 = -62
                if (r3 < r12) goto L_0x002a
                long r7 = r7 + r1
                byte r12 = androidx.datastore.preferences.protobuf.UnsafeUtil.A(r13, r1)
                if (r12 <= r6) goto L_0x0027
                goto L_0x002a
            L_0x0027:
                r1 = r7
                goto L_0x00a1
            L_0x002a:
                return r5
            L_0x002b:
                r9 = -16
                if (r3 >= r9) goto L_0x005f
                int r12 = r12 >> 8
                int r12 = ~r12
                byte r12 = (byte) r12
                if (r12 != 0) goto L_0x0045
                long r9 = r1 + r7
                byte r12 = androidx.datastore.preferences.protobuf.UnsafeUtil.A(r13, r1)
                int r0 = (r9 > r14 ? 1 : (r9 == r14 ? 0 : -1))
                if (r0 < 0) goto L_0x0044
                int r12 = androidx.datastore.preferences.protobuf.Utf8.o(r3, r12)
                return r12
            L_0x0044:
                r1 = r9
            L_0x0045:
                if (r12 > r6) goto L_0x005e
                r0 = -96
                if (r3 != r4) goto L_0x004d
                if (r12 < r0) goto L_0x005e
            L_0x004d:
                r4 = -19
                if (r3 != r4) goto L_0x0053
                if (r12 >= r0) goto L_0x005e
            L_0x0053:
                long r3 = r1 + r7
                byte r12 = androidx.datastore.preferences.protobuf.UnsafeUtil.A(r13, r1)
                if (r12 <= r6) goto L_0x005c
                goto L_0x005e
            L_0x005c:
                r1 = r3
                goto L_0x00a1
            L_0x005e:
                return r5
            L_0x005f:
                int r4 = r12 >> 8
                int r4 = ~r4
                byte r4 = (byte) r4
                if (r4 != 0) goto L_0x0076
                long r9 = r1 + r7
                byte r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.A(r13, r1)
                int r12 = (r9 > r14 ? 1 : (r9 == r14 ? 0 : -1))
                if (r12 < 0) goto L_0x0074
                int r12 = androidx.datastore.preferences.protobuf.Utf8.o(r3, r4)
                return r12
            L_0x0074:
                r1 = r9
                goto L_0x0079
            L_0x0076:
                int r12 = r12 >> 16
                byte r0 = (byte) r12
            L_0x0079:
                if (r0 != 0) goto L_0x008b
                long r9 = r1 + r7
                byte r0 = androidx.datastore.preferences.protobuf.UnsafeUtil.A(r13, r1)
                int r12 = (r9 > r14 ? 1 : (r9 == r14 ? 0 : -1))
                if (r12 < 0) goto L_0x008a
                int r12 = androidx.datastore.preferences.protobuf.Utf8.p(r3, r4, r0)
                return r12
            L_0x008a:
                r1 = r9
            L_0x008b:
                if (r4 > r6) goto L_0x00a0
                int r12 = r3 << 28
                int r4 = r4 + 112
                int r12 = r12 + r4
                int r12 = r12 >> 30
                if (r12 != 0) goto L_0x00a0
                if (r0 > r6) goto L_0x00a0
                long r3 = r1 + r7
                byte r12 = androidx.datastore.preferences.protobuf.UnsafeUtil.A(r13, r1)
                if (r12 <= r6) goto L_0x005c
            L_0x00a0:
                return r5
            L_0x00a1:
                long r14 = r14 - r1
                int r12 = (int) r14
                int r12 = r(r13, r1, r12)
                return r12
            L_0x00a8:
                java.lang.ArrayIndexOutOfBoundsException r12 = new java.lang.ArrayIndexOutOfBoundsException
                int r13 = r13.length
                java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
                java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
                java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
                r1 = 3
                java.lang.Object[] r1 = new java.lang.Object[r1]
                r1[r0] = r13
                r13 = 1
                r1[r13] = r14
                r13 = 2
                r1[r13] = r15
                java.lang.String r13 = "Array length=%d, index=%d, limit=%d"
                java.lang.String r13 = java.lang.String.format(r13, r1)
                r12.<init>(r13)
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Utf8.UnsafeProcessor.l(int, byte[], int, int):int");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x002e, code lost:
            if (androidx.datastore.preferences.protobuf.UnsafeUtil.y(r1) > -65) goto L_0x0034;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0062, code lost:
            if (androidx.datastore.preferences.protobuf.UnsafeUtil.y(r1) > -65) goto L_0x0064;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x00a3, code lost:
            if (androidx.datastore.preferences.protobuf.UnsafeUtil.y(r1) > -65) goto L_0x00a5;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int o(int r11, java.nio.ByteBuffer r12, int r13, int r14) {
            /*
                r10 = this;
                r0 = 0
                r1 = r13 | r14
                int r2 = r12.limit()
                int r2 = r2 - r14
                r1 = r1 | r2
                if (r1 < 0) goto L_0x00ad
                long r1 = androidx.datastore.preferences.protobuf.UnsafeUtil.i(r12)
                long r3 = (long) r13
                long r1 = r1 + r3
                int r14 = r14 - r13
                long r12 = (long) r14
                long r12 = r12 + r1
                if (r11 == 0) goto L_0x00a6
                int r14 = (r1 > r12 ? 1 : (r1 == r12 ? 0 : -1))
                if (r14 < 0) goto L_0x001b
                return r11
            L_0x001b:
                byte r14 = (byte) r11
                r3 = -32
                r4 = -1
                r5 = -65
                r6 = 1
                if (r14 >= r3) goto L_0x0035
                r11 = -62
                if (r14 < r11) goto L_0x0034
                long r6 = r6 + r1
                byte r11 = androidx.datastore.preferences.protobuf.UnsafeUtil.y(r1)
                if (r11 <= r5) goto L_0x0031
                goto L_0x0034
            L_0x0031:
                r1 = r6
                goto L_0x00a6
            L_0x0034:
                return r4
            L_0x0035:
                r8 = -16
                if (r14 >= r8) goto L_0x0065
                int r11 = r11 >> 8
                int r11 = ~r11
                byte r11 = (byte) r11
                if (r11 != 0) goto L_0x004f
                long r8 = r1 + r6
                byte r11 = androidx.datastore.preferences.protobuf.UnsafeUtil.y(r1)
                int r0 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
                if (r0 < 0) goto L_0x004e
                int r11 = androidx.datastore.preferences.protobuf.Utf8.o(r14, r11)
                return r11
            L_0x004e:
                r1 = r8
            L_0x004f:
                if (r11 > r5) goto L_0x0064
                r0 = -96
                if (r14 != r3) goto L_0x0057
                if (r11 < r0) goto L_0x0064
            L_0x0057:
                r3 = -19
                if (r14 != r3) goto L_0x005d
                if (r11 >= r0) goto L_0x0064
            L_0x005d:
                long r6 = r6 + r1
                byte r11 = androidx.datastore.preferences.protobuf.UnsafeUtil.y(r1)
                if (r11 <= r5) goto L_0x0031
            L_0x0064:
                return r4
            L_0x0065:
                int r3 = r11 >> 8
                int r3 = ~r3
                byte r3 = (byte) r3
                if (r3 != 0) goto L_0x007c
                long r8 = r1 + r6
                byte r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.y(r1)
                int r11 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
                if (r11 < 0) goto L_0x007a
                int r11 = androidx.datastore.preferences.protobuf.Utf8.o(r14, r3)
                return r11
            L_0x007a:
                r1 = r8
                goto L_0x007f
            L_0x007c:
                int r11 = r11 >> 16
                byte r0 = (byte) r11
            L_0x007f:
                if (r0 != 0) goto L_0x0091
                long r8 = r1 + r6
                byte r0 = androidx.datastore.preferences.protobuf.UnsafeUtil.y(r1)
                int r11 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
                if (r11 < 0) goto L_0x0090
                int r11 = androidx.datastore.preferences.protobuf.Utf8.p(r14, r3, r0)
                return r11
            L_0x0090:
                r1 = r8
            L_0x0091:
                if (r3 > r5) goto L_0x00a5
                int r11 = r14 << 28
                int r3 = r3 + 112
                int r11 = r11 + r3
                int r11 = r11 >> 30
                if (r11 != 0) goto L_0x00a5
                if (r0 > r5) goto L_0x00a5
                long r6 = r6 + r1
                byte r11 = androidx.datastore.preferences.protobuf.UnsafeUtil.y(r1)
                if (r11 <= r5) goto L_0x0031
            L_0x00a5:
                return r4
            L_0x00a6:
                long r12 = r12 - r1
                int r11 = (int) r12
                int r11 = q(r1, r11)
                return r11
            L_0x00ad:
                java.lang.ArrayIndexOutOfBoundsException r11 = new java.lang.ArrayIndexOutOfBoundsException
                int r12 = r12.limit()
                java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
                java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
                java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
                r1 = 3
                java.lang.Object[] r1 = new java.lang.Object[r1]
                r1[r0] = r12
                r12 = 1
                r1[r12] = r13
                r12 = 2
                r1[r12] = r14
                java.lang.String r12 = "buffer limit=%d, index=%d, limit=%d"
                java.lang.String r12 = java.lang.String.format(r12, r1)
                r11.<init>(r12)
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Utf8.UnsafeProcessor.o(int, java.nio.ByteBuffer, int, int):int");
        }
    }

    private Utf8() {
    }

    static String g(ByteBuffer byteBuffer, int i2, int i3) throws InvalidProtocolBufferException {
        return f7294a.a(byteBuffer, i2, i3);
    }

    static String h(byte[] bArr, int i2, int i3) throws InvalidProtocolBufferException {
        return f7294a.b(bArr, i2, i3);
    }

    static int i(CharSequence charSequence, byte[] bArr, int i2, int i3) {
        return f7294a.e(charSequence, bArr, i2, i3);
    }

    static void j(CharSequence charSequence, ByteBuffer byteBuffer) {
        f7294a.f(charSequence, byteBuffer);
    }

    static int k(CharSequence charSequence) {
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
                    i3 += l(charSequence, i2);
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

    private static int l(CharSequence charSequence, int i2) {
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

    /* access modifiers changed from: private */
    public static int m(ByteBuffer byteBuffer, int i2, int i3) {
        int i4 = i3 - 7;
        int i5 = i2;
        while (i5 < i4 && (byteBuffer.getLong(i5) & f7295b) == 0) {
            i5 += 8;
        }
        return i5 - i2;
    }

    /* access modifiers changed from: private */
    public static int n(int i2) {
        if (i2 > -12) {
            return -1;
        }
        return i2;
    }

    /* access modifiers changed from: private */
    public static int o(int i2, int i3) {
        if (i2 > -12 || i3 > -65) {
            return -1;
        }
        return i2 ^ (i3 << 8);
    }

    /* access modifiers changed from: private */
    public static int p(int i2, int i3, int i4) {
        if (i2 > -12 || i3 > -65 || i4 > -65) {
            return -1;
        }
        return (i2 ^ (i3 << 8)) ^ (i4 << 16);
    }

    /* access modifiers changed from: private */
    public static int q(ByteBuffer byteBuffer, int i2, int i3, int i4) {
        if (i4 == 0) {
            return n(i2);
        }
        if (i4 == 1) {
            return o(i2, byteBuffer.get(i3));
        }
        if (i4 == 2) {
            return p(i2, byteBuffer.get(i3), byteBuffer.get(i3 + 1));
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: private */
    public static int r(byte[] bArr, int i2, int i3) {
        byte b2 = bArr[i2 - 1];
        int i4 = i3 - i2;
        if (i4 == 0) {
            return n(b2);
        }
        if (i4 == 1) {
            return o(b2, bArr[i2]);
        }
        if (i4 == 2) {
            return p(b2, bArr[i2], bArr[i2 + 1]);
        }
        throw new AssertionError();
    }

    static boolean s(ByteBuffer byteBuffer) {
        return f7294a.i(byteBuffer, byteBuffer.position(), byteBuffer.remaining());
    }

    public static boolean t(byte[] bArr) {
        return f7294a.j(bArr, 0, bArr.length);
    }

    public static boolean u(byte[] bArr, int i2, int i3) {
        return f7294a.j(bArr, i2, i3);
    }

    static int v(int i2, ByteBuffer byteBuffer, int i3, int i4) {
        return f7294a.k(i2, byteBuffer, i3, i4);
    }

    public static int w(int i2, byte[] bArr, int i3, int i4) {
        return f7294a.l(i2, bArr, i3, i4);
    }
}
