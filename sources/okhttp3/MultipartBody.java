package okhttp3;

import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.ByteString;
import org.apache.commons.httpclient.methods.MultipartPostMethod;

public final class MultipartBody extends RequestBody {

    /* renamed from: f  reason: collision with root package name */
    public static final MediaType f30902f = MediaType.c("multipart/mixed");

    /* renamed from: g  reason: collision with root package name */
    public static final MediaType f30903g = MediaType.c("multipart/alternative");

    /* renamed from: h  reason: collision with root package name */
    public static final MediaType f30904h = MediaType.c("multipart/digest");

    /* renamed from: i  reason: collision with root package name */
    public static final MediaType f30905i = MediaType.c("multipart/parallel");

    /* renamed from: j  reason: collision with root package name */
    public static final MediaType f30906j = MediaType.c(MultipartPostMethod.MULTIPART_FORM_CONTENT_TYPE);

    /* renamed from: k  reason: collision with root package name */
    private static final byte[] f30907k = {58, 32};

    /* renamed from: l  reason: collision with root package name */
    private static final byte[] f30908l = {13, 10};

    /* renamed from: m  reason: collision with root package name */
    private static final byte[] f30909m = {45, 45};

    /* renamed from: a  reason: collision with root package name */
    private final ByteString f30910a;

    /* renamed from: b  reason: collision with root package name */
    private final MediaType f30911b;

    /* renamed from: c  reason: collision with root package name */
    private final MediaType f30912c;

    /* renamed from: d  reason: collision with root package name */
    private final List<Part> f30913d;

    /* renamed from: e  reason: collision with root package name */
    private long f30914e = -1;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final ByteString f30915a;

        /* renamed from: b  reason: collision with root package name */
        private MediaType f30916b;

        /* renamed from: c  reason: collision with root package name */
        private final List<Part> f30917c;

        public Builder() {
            this(UUID.randomUUID().toString());
        }

        public Builder a(String str, String str2) {
            return d(Part.d(str, str2));
        }

        public Builder b(String str, @Nullable String str2, RequestBody requestBody) {
            return d(Part.e(str, str2, requestBody));
        }

        public Builder c(@Nullable Headers headers, RequestBody requestBody) {
            return d(Part.b(headers, requestBody));
        }

        public Builder d(Part part) {
            if (part != null) {
                this.f30917c.add(part);
                return this;
            }
            throw new NullPointerException("part == null");
        }

        public Builder e(RequestBody requestBody) {
            return d(Part.c(requestBody));
        }

        public MultipartBody f() {
            if (!this.f30917c.isEmpty()) {
                return new MultipartBody(this.f30915a, this.f30916b, this.f30917c);
            }
            throw new IllegalStateException("Multipart body must have at least one part.");
        }

        public Builder g(MediaType mediaType) {
            if (mediaType == null) {
                throw new NullPointerException("type == null");
            } else if (mediaType.f().equals("multipart")) {
                this.f30916b = mediaType;
                return this;
            } else {
                throw new IllegalArgumentException("multipart != " + mediaType);
            }
        }

        public Builder(String str) {
            this.f30916b = MultipartBody.f30902f;
            this.f30917c = new ArrayList();
            this.f30915a = ByteString.n(str);
        }
    }

    public static final class Part {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        final Headers f30918a;

        /* renamed from: b  reason: collision with root package name */
        final RequestBody f30919b;

        private Part(@Nullable Headers headers, RequestBody requestBody) {
            this.f30918a = headers;
            this.f30919b = requestBody;
        }

        public static Part b(@Nullable Headers headers, RequestBody requestBody) {
            if (requestBody == null) {
                throw new NullPointerException("body == null");
            } else if (headers != null && headers.d(HttpHeaders.f22875c) != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            } else if (headers == null || headers.d(HttpHeaders.f22874b) == null) {
                return new Part(headers, requestBody);
            } else {
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }
        }

        public static Part c(RequestBody requestBody) {
            return b((Headers) null, requestBody);
        }

        public static Part d(String str, String str2) {
            return e(str, (String) null, RequestBody.d((MediaType) null, str2));
        }

        public static Part e(String str, @Nullable String str2, RequestBody requestBody) {
            if (str != null) {
                StringBuilder sb = new StringBuilder("form-data; name=");
                MultipartBody.i(sb, str);
                if (str2 != null) {
                    sb.append("; filename=");
                    MultipartBody.i(sb, str2);
                }
                return b(Headers.k(HttpHeaders.a0, sb.toString()), requestBody);
            }
            throw new NullPointerException("name == null");
        }

        public RequestBody a() {
            return this.f30919b;
        }

        @Nullable
        public Headers f() {
            return this.f30918a;
        }
    }

    MultipartBody(ByteString byteString, MediaType mediaType, List<Part> list) {
        this.f30910a = byteString;
        this.f30911b = mediaType;
        this.f30912c = MediaType.c(mediaType + "; boundary=" + byteString.I0());
        this.f30913d = Util.u(list);
    }

    static StringBuilder i(StringBuilder sb, String str) {
        String str2;
        sb.append('\"');
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt == 10) {
                str2 = "%0A";
            } else if (charAt == 13) {
                str2 = "%0D";
            } else if (charAt != '\"') {
                sb.append(charAt);
            } else {
                str2 = "%22";
            }
            sb.append(str2);
        }
        sb.append('\"');
        return sb;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v1, resolved type: okio.BufferedSink} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: okio.Buffer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: okio.Buffer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v3, resolved type: okio.BufferedSink} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: okio.Buffer} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private long o(@javax.annotation.Nullable okio.BufferedSink r13, boolean r14) throws java.io.IOException {
        /*
            r12 = this;
            if (r14 == 0) goto L_0x0009
            okio.Buffer r13 = new okio.Buffer
            r13.<init>()
            r0 = r13
            goto L_0x000a
        L_0x0009:
            r0 = 0
        L_0x000a:
            java.util.List<okhttp3.MultipartBody$Part> r1 = r12.f30913d
            int r1 = r1.size()
            r2 = 0
            r3 = 0
            r5 = 0
        L_0x0014:
            if (r5 >= r1) goto L_0x00a4
            java.util.List<okhttp3.MultipartBody$Part> r6 = r12.f30913d
            java.lang.Object r6 = r6.get(r5)
            okhttp3.MultipartBody$Part r6 = (okhttp3.MultipartBody.Part) r6
            okhttp3.Headers r7 = r6.f30918a
            okhttp3.RequestBody r6 = r6.f30919b
            byte[] r8 = f30909m
            r13.write(r8)
            okio.ByteString r8 = r12.f30910a
            r13.g2(r8)
            byte[] r8 = f30908l
            r13.write(r8)
            if (r7 == 0) goto L_0x0058
            int r8 = r7.l()
            r9 = 0
        L_0x0038:
            if (r9 >= r8) goto L_0x0058
            java.lang.String r10 = r7.g(r9)
            okio.BufferedSink r10 = r13.W0(r10)
            byte[] r11 = f30907k
            okio.BufferedSink r10 = r10.write(r11)
            java.lang.String r11 = r7.n(r9)
            okio.BufferedSink r10 = r10.W0(r11)
            byte[] r11 = f30908l
            r10.write(r11)
            int r9 = r9 + 1
            goto L_0x0038
        L_0x0058:
            okhttp3.MediaType r7 = r6.b()
            if (r7 == 0) goto L_0x0071
            java.lang.String r8 = "Content-Type: "
            okio.BufferedSink r8 = r13.W0(r8)
            java.lang.String r7 = r7.toString()
            okio.BufferedSink r7 = r8.W0(r7)
            byte[] r8 = f30908l
            r7.write(r8)
        L_0x0071:
            long r7 = r6.a()
            r9 = -1
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 == 0) goto L_0x008b
            java.lang.String r9 = "Content-Length: "
            okio.BufferedSink r9 = r13.W0(r9)
            okio.BufferedSink r9 = r9.L2(r7)
            byte[] r10 = f30908l
            r9.write(r10)
            goto L_0x0091
        L_0x008b:
            if (r14 == 0) goto L_0x0091
            r0.d()
            return r9
        L_0x0091:
            byte[] r9 = f30908l
            r13.write(r9)
            if (r14 == 0) goto L_0x009a
            long r3 = r3 + r7
            goto L_0x009d
        L_0x009a:
            r6.h(r13)
        L_0x009d:
            r13.write(r9)
            int r5 = r5 + 1
            goto L_0x0014
        L_0x00a4:
            byte[] r1 = f30909m
            r13.write(r1)
            okio.ByteString r2 = r12.f30910a
            r13.g2(r2)
            r13.write(r1)
            byte[] r1 = f30908l
            r13.write(r1)
            if (r14 == 0) goto L_0x00c0
            long r13 = r0.L0()
            long r3 = r3 + r13
            r0.d()
        L_0x00c0:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.MultipartBody.o(okio.BufferedSink, boolean):long");
    }

    public long a() throws IOException {
        long j2 = this.f30914e;
        if (j2 != -1) {
            return j2;
        }
        long o = o((BufferedSink) null, true);
        this.f30914e = o;
        return o;
    }

    public MediaType b() {
        return this.f30912c;
    }

    public void h(BufferedSink bufferedSink) throws IOException {
        o(bufferedSink, false);
    }

    public String j() {
        return this.f30910a.I0();
    }

    public Part k(int i2) {
        return this.f30913d.get(i2);
    }

    public List<Part> l() {
        return this.f30913d;
    }

    public int m() {
        return this.f30913d.size();
    }

    public MediaType n() {
        return this.f30911b;
    }
}
