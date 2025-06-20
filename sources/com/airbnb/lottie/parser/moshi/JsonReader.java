package com.airbnb.lottie.parser.moshi;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

public abstract class JsonReader implements Closeable {
    private static final String[] Z2 = new String[128];
    int[] X = new int[32];
    boolean X2;
    String[] Y = new String[32];
    boolean Y2;
    int[] Z = new int[32];
    int s;

    public static final class Options {

        /* renamed from: a  reason: collision with root package name */
        final String[] f17327a;

        /* renamed from: b  reason: collision with root package name */
        final okio.Options f17328b;

        private Options(String[] strArr, okio.Options options) {
            this.f17327a = strArr;
            this.f17328b = options;
        }

        public static Options a(String... strArr) {
            try {
                ByteString[] byteStringArr = new ByteString[strArr.length];
                Buffer buffer = new Buffer();
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    JsonReader.x(buffer, strArr[i2]);
                    buffer.readByte();
                    byteStringArr[i2] = buffer.A1();
                }
                return new Options((String[]) strArr.clone(), okio.Options.m(byteStringArr));
            } catch (IOException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    public enum Token {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    static {
        for (int i2 = 0; i2 <= 31; i2++) {
            Z2[i2] = String.format("\\u%04x", new Object[]{Integer.valueOf(i2)});
        }
        String[] strArr = Z2;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    JsonReader() {
    }

    public static JsonReader r(BufferedSource bufferedSource) {
        return new JsonUtf8Reader(bufferedSource);
    }

    /* access modifiers changed from: private */
    public static void x(BufferedSink bufferedSink, String str) throws IOException {
        String str2;
        String[] strArr = Z2;
        bufferedSink.writeByte(34);
        int length = str.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if (charAt < 128) {
                str2 = strArr[charAt];
                if (str2 == null) {
                }
            } else if (charAt == 8232) {
                str2 = "\\u2028";
            } else if (charAt == 8233) {
                str2 = "\\u2029";
            }
            if (i2 < i3) {
                bufferedSink.w1(str, i2, i3);
            }
            bufferedSink.W0(str2);
            i2 = i3 + 1;
        }
        if (i2 < length) {
            bufferedSink.w1(str, i2, length);
        }
        bufferedSink.writeByte(34);
    }

    public abstract void c() throws IOException;

    public abstract void d() throws IOException;

    public abstract void e() throws IOException;

    public abstract void f() throws IOException;

    public final String getPath() {
        return JsonScope.a(this.s, this.X, this.Y, this.Z);
    }

    public abstract boolean h() throws IOException;

    public abstract boolean i() throws IOException;

    public abstract double k() throws IOException;

    public abstract int n() throws IOException;

    public abstract String p() throws IOException;

    public abstract String q() throws IOException;

    public abstract Token s() throws IOException;

    /* access modifiers changed from: package-private */
    public final void t(int i2) {
        int i3 = this.s;
        int[] iArr = this.X;
        if (i3 == iArr.length) {
            if (i3 != 256) {
                this.X = Arrays.copyOf(iArr, iArr.length * 2);
                String[] strArr = this.Y;
                this.Y = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                int[] iArr2 = this.Z;
                this.Z = Arrays.copyOf(iArr2, iArr2.length * 2);
            } else {
                throw new JsonDataException("Nesting too deep at " + getPath());
            }
        }
        int[] iArr3 = this.X;
        int i4 = this.s;
        this.s = i4 + 1;
        iArr3[i4] = i2;
    }

    public abstract int u(Options options) throws IOException;

    public abstract void v() throws IOException;

    public abstract void w() throws IOException;

    /* access modifiers changed from: package-private */
    public final JsonEncodingException y(String str) throws JsonEncodingException {
        throw new JsonEncodingException(str + " at path " + getPath());
    }
}
