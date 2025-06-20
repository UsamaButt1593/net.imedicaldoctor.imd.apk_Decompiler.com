package androidx.emoji2.text.flatbuffer;

import androidx.media3.exoplayer.analytics.AnalyticsListener;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;

public abstract class Utf8 {

    /* renamed from: a  reason: collision with root package name */
    private static Utf8 f7777a;

    static class DecodeUtil {
        DecodeUtil() {
        }

        static void a(byte b2, byte b3, byte b4, byte b5, char[] cArr, int i2) throws IllegalArgumentException {
            if (f(b3) || (((b2 << Ascii.F) + (b3 + 112)) >> 30) != 0 || f(b4) || f(b5)) {
                throw new IllegalArgumentException("Invalid UTF-8");
            }
            int k2 = ((b2 & 7) << 18) | (k(b3) << 12) | (k(b4) << 6) | k(b5);
            cArr[i2] = e(k2);
            cArr[i2 + 1] = j(k2);
        }

        static void b(byte b2, char[] cArr, int i2) {
            cArr[i2] = (char) b2;
        }

        static void c(byte b2, byte b3, byte b4, char[] cArr, int i2) throws IllegalArgumentException {
            if (f(b3) || ((b2 == -32 && b3 < -96) || ((b2 == -19 && b3 >= -96) || f(b4)))) {
                throw new IllegalArgumentException("Invalid UTF-8");
            }
            cArr[i2] = (char) (((b2 & 15) << 12) | (k(b3) << 6) | k(b4));
        }

        static void d(byte b2, byte b3, char[] cArr, int i2) throws IllegalArgumentException {
            if (b2 < -62) {
                throw new IllegalArgumentException("Invalid UTF-8: Illegal leading byte in 2 bytes utf");
            } else if (!f(b3)) {
                cArr[i2] = (char) (((b2 & Ascii.I) << 6) | k(b3));
            } else {
                throw new IllegalArgumentException("Invalid UTF-8: Illegal trailing byte in 2 bytes utf");
            }
        }

        private static char e(int i2) {
            return (char) ((i2 >>> 10) + okio.Utf8.f31407d);
        }

        private static boolean f(byte b2) {
            return b2 > -65;
        }

        static boolean g(byte b2) {
            return b2 >= 0;
        }

        static boolean h(byte b2) {
            return b2 < -16;
        }

        static boolean i(byte b2) {
            return b2 < -32;
        }

        private static char j(int i2) {
            return (char) ((i2 & AnalyticsListener.c0) + okio.Utf8.f31408e);
        }

        private static int k(byte b2) {
            return b2 & okio.Utf8.f31404a;
        }
    }

    static class UnpairedSurrogateException extends IllegalArgumentException {
        UnpairedSurrogateException(int i2, int i3) {
            super("Unpaired surrogate at index " + i2 + " of " + i3);
        }
    }

    public static Utf8 d() {
        if (f7777a == null) {
            f7777a = new Utf8Safe();
        }
        return f7777a;
    }

    public static void e(Utf8 utf8) {
        f7777a = utf8;
    }

    public abstract String a(ByteBuffer byteBuffer, int i2, int i3);

    public abstract void b(CharSequence charSequence, ByteBuffer byteBuffer);

    public abstract int c(CharSequence charSequence);
}
