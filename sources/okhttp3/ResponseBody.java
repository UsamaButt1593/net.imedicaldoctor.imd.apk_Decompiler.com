package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

public abstract class ResponseBody implements Closeable {
    @Nullable
    private Reader s;

    static final class BomAwareReader extends Reader {
        private final Charset X;
        private boolean Y;
        @Nullable
        private Reader Z;
        private final BufferedSource s;

        BomAwareReader(BufferedSource bufferedSource, Charset charset) {
            this.s = bufferedSource;
            this.X = charset;
        }

        public void close() throws IOException {
            this.Y = true;
            Reader reader = this.Z;
            if (reader != null) {
                reader.close();
            } else {
                this.s.close();
            }
        }

        public int read(char[] cArr, int i2, int i3) throws IOException {
            if (!this.Y) {
                Reader reader = this.Z;
                if (reader == null) {
                    InputStreamReader inputStreamReader = new InputStreamReader(this.s.z(), Util.c(this.s, this.X));
                    this.Z = inputStreamReader;
                    reader = inputStreamReader;
                }
                return reader.read(cArr, i2, i3);
            }
            throw new IOException("Stream closed");
        }
    }

    private Charset e() {
        MediaType h2 = h();
        return h2 != null ? h2.b(Util.f30979j) : Util.f30979j;
    }

    public static ResponseBody i(@Nullable final MediaType mediaType, final long j2, final BufferedSource bufferedSource) {
        if (bufferedSource != null) {
            return new ResponseBody() {
                public long f() {
                    return j2;
                }

                @Nullable
                public MediaType h() {
                    return MediaType.this;
                }

                public BufferedSource q() {
                    return bufferedSource;
                }
            };
        }
        throw new NullPointerException("source == null");
    }

    public static ResponseBody k(@Nullable MediaType mediaType, String str) {
        Charset charset = Util.f30979j;
        if (mediaType != null) {
            Charset a2 = mediaType.a();
            if (a2 == null) {
                mediaType = MediaType.d(mediaType + "; charset=utf-8");
            } else {
                charset = a2;
            }
        }
        Buffer P2 = new Buffer().C1(str, charset);
        return i(mediaType, P2.L0(), P2);
    }

    public static ResponseBody n(@Nullable MediaType mediaType, ByteString byteString) {
        return i(mediaType, (long) byteString.m0(), new Buffer().g2(byteString));
    }

    public static ResponseBody p(@Nullable MediaType mediaType, byte[] bArr) {
        return i(mediaType, (long) bArr.length, new Buffer().write(bArr));
    }

    public final InputStream b() {
        return q().z();
    }

    /* JADX INFO: finally extract failed */
    public final byte[] c() throws IOException {
        long f2 = f();
        if (f2 <= 2147483647L) {
            BufferedSource q = q();
            try {
                byte[] b0 = q.b0();
                Util.g(q);
                if (f2 == -1 || f2 == ((long) b0.length)) {
                    return b0;
                }
                throw new IOException("Content-Length (" + f2 + ") and stream length (" + b0.length + ") disagree");
            } catch (Throwable th) {
                Util.g(q);
                throw th;
            }
        } else {
            throw new IOException("Cannot buffer entire body for content length: " + f2);
        }
    }

    public void close() {
        Util.g(q());
    }

    public final Reader d() {
        Reader reader = this.s;
        if (reader != null) {
            return reader;
        }
        BomAwareReader bomAwareReader = new BomAwareReader(q(), e());
        this.s = bomAwareReader;
        return bomAwareReader;
    }

    public abstract long f();

    @Nullable
    public abstract MediaType h();

    public abstract BufferedSource q();

    public final String r() throws IOException {
        BufferedSource q = q();
        try {
            return q.g1(Util.c(q, e()));
        } finally {
            Util.g(q);
        }
    }
}
