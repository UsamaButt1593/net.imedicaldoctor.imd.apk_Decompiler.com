package okhttp3;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.ByteString;
import okio.Okio;
import okio.Source;

public abstract class RequestBody {
    public static RequestBody c(@Nullable final MediaType mediaType, final File file) {
        if (file != null) {
            return new RequestBody() {
                public long a() {
                    return file.length();
                }

                @Nullable
                public MediaType b() {
                    return MediaType.this;
                }

                public void h(BufferedSink bufferedSink) throws IOException {
                    Source source = null;
                    try {
                        source = Okio.t(file);
                        bufferedSink.y1(source);
                    } finally {
                        Util.g(source);
                    }
                }
            };
        }
        throw new NullPointerException("file == null");
    }

    public static RequestBody d(@Nullable MediaType mediaType, String str) {
        Charset charset = Util.f30979j;
        if (mediaType != null) {
            Charset a2 = mediaType.a();
            if (a2 == null) {
                mediaType = MediaType.d(mediaType + "; charset=utf-8");
            } else {
                charset = a2;
            }
        }
        return f(mediaType, str.getBytes(charset));
    }

    public static RequestBody e(@Nullable final MediaType mediaType, final ByteString byteString) {
        return new RequestBody() {
            public long a() throws IOException {
                return (long) byteString.m0();
            }

            @Nullable
            public MediaType b() {
                return MediaType.this;
            }

            public void h(BufferedSink bufferedSink) throws IOException {
                bufferedSink.g2(byteString);
            }
        };
    }

    public static RequestBody f(@Nullable MediaType mediaType, byte[] bArr) {
        return g(mediaType, bArr, 0, bArr.length);
    }

    public static RequestBody g(@Nullable final MediaType mediaType, final byte[] bArr, final int i2, final int i3) {
        if (bArr != null) {
            Util.f((long) bArr.length, (long) i2, (long) i3);
            return new RequestBody() {
                public long a() {
                    return (long) i3;
                }

                @Nullable
                public MediaType b() {
                    return MediaType.this;
                }

                public void h(BufferedSink bufferedSink) throws IOException {
                    bufferedSink.write(bArr, i2, i3);
                }
            };
        }
        throw new NullPointerException("content == null");
    }

    public long a() throws IOException {
        return -1;
    }

    @Nullable
    public abstract MediaType b();

    public abstract void h(BufferedSink bufferedSink) throws IOException;
}
