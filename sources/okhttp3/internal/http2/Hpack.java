package okhttp3.internal.http2;

import com.google.common.primitives.SignedBytes;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import com.itextpdf.tool.xml.html.HTML;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;
import org.apache.commons.httpclient.cookie.RFC2109Spec;

final class Hpack {

    /* renamed from: a  reason: collision with root package name */
    private static final int f31130a = 15;

    /* renamed from: b  reason: collision with root package name */
    private static final int f31131b = 31;

    /* renamed from: c  reason: collision with root package name */
    private static final int f31132c = 63;

    /* renamed from: d  reason: collision with root package name */
    private static final int f31133d = 127;

    /* renamed from: e  reason: collision with root package name */
    static final Header[] f31134e;

    /* renamed from: f  reason: collision with root package name */
    static final Map<ByteString, Integer> f31135f = b();

    static final class Reader {

        /* renamed from: a  reason: collision with root package name */
        private final List<Header> f31136a;

        /* renamed from: b  reason: collision with root package name */
        private final BufferedSource f31137b;

        /* renamed from: c  reason: collision with root package name */
        private final int f31138c;

        /* renamed from: d  reason: collision with root package name */
        private int f31139d;

        /* renamed from: e  reason: collision with root package name */
        Header[] f31140e;

        /* renamed from: f  reason: collision with root package name */
        int f31141f;

        /* renamed from: g  reason: collision with root package name */
        int f31142g;

        /* renamed from: h  reason: collision with root package name */
        int f31143h;

        Reader(int i2, int i3, Source source) {
            this.f31136a = new ArrayList();
            Header[] headerArr = new Header[8];
            this.f31140e = headerArr;
            this.f31141f = headerArr.length - 1;
            this.f31142g = 0;
            this.f31143h = 0;
            this.f31138c = i2;
            this.f31139d = i3;
            this.f31137b = Okio.e(source);
        }

        private void a() {
            int i2 = this.f31139d;
            int i3 = this.f31143h;
            if (i2 >= i3) {
                return;
            }
            if (i2 == 0) {
                b();
            } else {
                d(i3 - i2);
            }
        }

        private void b() {
            Arrays.fill(this.f31140e, (Object) null);
            this.f31141f = this.f31140e.length - 1;
            this.f31142g = 0;
            this.f31143h = 0;
        }

        private int c(int i2) {
            return this.f31141f + 1 + i2;
        }

        private int d(int i2) {
            int i3;
            int i4 = 0;
            if (i2 > 0) {
                int length = this.f31140e.length;
                while (true) {
                    length--;
                    i3 = this.f31141f;
                    if (length < i3 || i2 <= 0) {
                        Header[] headerArr = this.f31140e;
                        System.arraycopy(headerArr, i3 + 1, headerArr, i3 + 1 + i4, this.f31142g);
                        this.f31141f += i4;
                    } else {
                        int i5 = this.f31140e[length].f31129c;
                        i2 -= i5;
                        this.f31143h -= i5;
                        this.f31142g--;
                        i4++;
                    }
                }
                Header[] headerArr2 = this.f31140e;
                System.arraycopy(headerArr2, i3 + 1, headerArr2, i3 + 1 + i4, this.f31142g);
                this.f31141f += i4;
            }
            return i4;
        }

        private ByteString f(int i2) throws IOException {
            Header header;
            if (h(i2)) {
                header = Hpack.f31134e[i2];
            } else {
                int c2 = c(i2 - Hpack.f31134e.length);
                if (c2 >= 0) {
                    Header[] headerArr = this.f31140e;
                    if (c2 < headerArr.length) {
                        header = headerArr[c2];
                    }
                }
                throw new IOException("Header index too large " + (i2 + 1));
            }
            return header.f31127a;
        }

        private void g(int i2, Header header) {
            this.f31136a.add(header);
            int i3 = header.f31129c;
            if (i2 != -1) {
                i3 -= this.f31140e[c(i2)].f31129c;
            }
            int i4 = this.f31139d;
            if (i3 > i4) {
                b();
                return;
            }
            int d2 = d((this.f31143h + i3) - i4);
            if (i2 == -1) {
                int i5 = this.f31142g + 1;
                Header[] headerArr = this.f31140e;
                if (i5 > headerArr.length) {
                    Header[] headerArr2 = new Header[(headerArr.length * 2)];
                    System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                    this.f31141f = this.f31140e.length - 1;
                    this.f31140e = headerArr2;
                }
                int i6 = this.f31141f;
                this.f31141f = i6 - 1;
                this.f31140e[i6] = header;
                this.f31142g++;
            } else {
                this.f31140e[i2 + c(i2) + d2] = header;
            }
            this.f31143h += i3;
        }

        private boolean h(int i2) {
            return i2 >= 0 && i2 <= Hpack.f31134e.length - 1;
        }

        private int j() throws IOException {
            return this.f31137b.readByte() & 255;
        }

        private void m(int i2) throws IOException {
            if (h(i2)) {
                this.f31136a.add(Hpack.f31134e[i2]);
                return;
            }
            int c2 = c(i2 - Hpack.f31134e.length);
            if (c2 >= 0) {
                Header[] headerArr = this.f31140e;
                if (c2 < headerArr.length) {
                    this.f31136a.add(headerArr[c2]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i2 + 1));
        }

        private void o(int i2) throws IOException {
            g(-1, new Header(f(i2), k()));
        }

        private void p() throws IOException {
            g(-1, new Header(Hpack.a(k()), k()));
        }

        private void q(int i2) throws IOException {
            this.f31136a.add(new Header(f(i2), k()));
        }

        private void r() throws IOException {
            this.f31136a.add(new Header(Hpack.a(k()), k()));
        }

        public List<Header> e() {
            ArrayList arrayList = new ArrayList(this.f31136a);
            this.f31136a.clear();
            return arrayList;
        }

        /* access modifiers changed from: package-private */
        public int i() {
            return this.f31139d;
        }

        /* access modifiers changed from: package-private */
        public ByteString k() throws IOException {
            int j2 = j();
            boolean z = (j2 & 128) == 128;
            int n2 = n(j2, 127);
            return z ? ByteString.U(Huffman.f().c(this.f31137b.U1((long) n2))) : this.f31137b.K((long) n2);
        }

        /* access modifiers changed from: package-private */
        public void l() throws IOException {
            while (!this.f31137b.o0()) {
                byte readByte = this.f31137b.readByte();
                byte b2 = readByte & 255;
                if (b2 == 128) {
                    throw new IOException("index == 0");
                } else if ((readByte & 128) == 128) {
                    m(n(b2, 127) - 1);
                } else if (b2 == 64) {
                    p();
                } else if ((readByte & SignedBytes.f22967a) == 64) {
                    o(n(b2, 63) - 1);
                } else if ((readByte & 32) == 32) {
                    int n2 = n(b2, 31);
                    this.f31139d = n2;
                    if (n2 < 0 || n2 > this.f31138c) {
                        throw new IOException("Invalid dynamic table size update " + this.f31139d);
                    }
                    a();
                } else if (b2 == 16 || b2 == 0) {
                    r();
                } else {
                    q(n(b2, 15) - 1);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public int n(int i2, int i3) throws IOException {
            int i4 = i2 & i3;
            if (i4 < i3) {
                return i4;
            }
            int i5 = 0;
            while (true) {
                int j2 = j();
                if ((j2 & 128) == 0) {
                    return i3 + (j2 << i5);
                }
                i3 += (j2 & 127) << i5;
                i5 += 7;
            }
        }

        Reader(int i2, Source source) {
            this(i2, i2, source);
        }
    }

    static final class Writer {

        /* renamed from: k  reason: collision with root package name */
        private static final int f31144k = 4096;

        /* renamed from: l  reason: collision with root package name */
        private static final int f31145l = 16384;

        /* renamed from: a  reason: collision with root package name */
        private final Buffer f31146a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f31147b;

        /* renamed from: c  reason: collision with root package name */
        private int f31148c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f31149d;

        /* renamed from: e  reason: collision with root package name */
        int f31150e;

        /* renamed from: f  reason: collision with root package name */
        int f31151f;

        /* renamed from: g  reason: collision with root package name */
        Header[] f31152g;

        /* renamed from: h  reason: collision with root package name */
        int f31153h;

        /* renamed from: i  reason: collision with root package name */
        int f31154i;

        /* renamed from: j  reason: collision with root package name */
        int f31155j;

        Writer(int i2, boolean z, Buffer buffer) {
            this.f31148c = Integer.MAX_VALUE;
            Header[] headerArr = new Header[8];
            this.f31152g = headerArr;
            this.f31153h = headerArr.length - 1;
            this.f31154i = 0;
            this.f31155j = 0;
            this.f31150e = i2;
            this.f31151f = i2;
            this.f31147b = z;
            this.f31146a = buffer;
        }

        private void a() {
            int i2 = this.f31151f;
            int i3 = this.f31155j;
            if (i2 >= i3) {
                return;
            }
            if (i2 == 0) {
                b();
            } else {
                c(i3 - i2);
            }
        }

        private void b() {
            Arrays.fill(this.f31152g, (Object) null);
            this.f31153h = this.f31152g.length - 1;
            this.f31154i = 0;
            this.f31155j = 0;
        }

        private int c(int i2) {
            int i3;
            int i4 = 0;
            if (i2 > 0) {
                int length = this.f31152g.length;
                while (true) {
                    length--;
                    i3 = this.f31153h;
                    if (length < i3 || i2 <= 0) {
                        Header[] headerArr = this.f31152g;
                        System.arraycopy(headerArr, i3 + 1, headerArr, i3 + 1 + i4, this.f31154i);
                        Header[] headerArr2 = this.f31152g;
                        int i5 = this.f31153h;
                        Arrays.fill(headerArr2, i5 + 1, i5 + 1 + i4, (Object) null);
                        this.f31153h += i4;
                    } else {
                        int i6 = this.f31152g[length].f31129c;
                        i2 -= i6;
                        this.f31155j -= i6;
                        this.f31154i--;
                        i4++;
                    }
                }
                Header[] headerArr3 = this.f31152g;
                System.arraycopy(headerArr3, i3 + 1, headerArr3, i3 + 1 + i4, this.f31154i);
                Header[] headerArr22 = this.f31152g;
                int i52 = this.f31153h;
                Arrays.fill(headerArr22, i52 + 1, i52 + 1 + i4, (Object) null);
                this.f31153h += i4;
            }
            return i4;
        }

        private void d(Header header) {
            int i2 = header.f31129c;
            int i3 = this.f31151f;
            if (i2 > i3) {
                b();
                return;
            }
            c((this.f31155j + i2) - i3);
            int i4 = this.f31154i + 1;
            Header[] headerArr = this.f31152g;
            if (i4 > headerArr.length) {
                Header[] headerArr2 = new Header[(headerArr.length * 2)];
                System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                this.f31153h = this.f31152g.length - 1;
                this.f31152g = headerArr2;
            }
            int i5 = this.f31153h;
            this.f31153h = i5 - 1;
            this.f31152g[i5] = header;
            this.f31154i++;
            this.f31155j += i2;
        }

        /* access modifiers changed from: package-private */
        public void e(int i2) {
            this.f31150e = i2;
            int min = Math.min(i2, 16384);
            int i3 = this.f31151f;
            if (i3 != min) {
                if (min < i3) {
                    this.f31148c = Math.min(this.f31148c, min);
                }
                this.f31149d = true;
                this.f31151f = min;
                a();
            }
        }

        /* access modifiers changed from: package-private */
        public void f(ByteString byteString) throws IOException {
            int m0;
            int i2;
            if (!this.f31147b || Huffman.f().e(byteString) >= byteString.m0()) {
                m0 = byteString.m0();
                i2 = 0;
            } else {
                Buffer buffer = new Buffer();
                Huffman.f().d(byteString, buffer);
                byteString = buffer.A1();
                m0 = byteString.m0();
                i2 = 128;
            }
            h(m0, 127, i2);
            this.f31146a.g2(byteString);
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0070  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x00a8  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x00b0  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void g(java.util.List<okhttp3.internal.http2.Header> r14) throws java.io.IOException {
            /*
                r13 = this;
                boolean r0 = r13.f31149d
                r1 = 0
                if (r0 == 0) goto L_0x001e
                int r0 = r13.f31148c
                int r2 = r13.f31151f
                r3 = 32
                r4 = 31
                if (r0 >= r2) goto L_0x0012
                r13.h(r0, r4, r3)
            L_0x0012:
                r13.f31149d = r1
                r0 = 2147483647(0x7fffffff, float:NaN)
                r13.f31148c = r0
                int r0 = r13.f31151f
                r13.h(r0, r4, r3)
            L_0x001e:
                int r0 = r14.size()
                r2 = 0
            L_0x0023:
                if (r2 >= r0) goto L_0x00e6
                java.lang.Object r3 = r14.get(r2)
                okhttp3.internal.http2.Header r3 = (okhttp3.internal.http2.Header) r3
                okio.ByteString r4 = r3.f31127a
                okio.ByteString r4 = r4.C0()
                okio.ByteString r5 = r3.f31128b
                java.util.Map<okio.ByteString, java.lang.Integer> r6 = okhttp3.internal.http2.Hpack.f31135f
                java.lang.Object r6 = r6.get(r4)
                java.lang.Integer r6 = (java.lang.Integer) r6
                r7 = 1
                r8 = -1
                if (r6 == 0) goto L_0x006c
                int r6 = r6.intValue()
                int r9 = r6 + 1
                if (r9 <= r7) goto L_0x0069
                r10 = 8
                if (r9 >= r10) goto L_0x0069
                okhttp3.internal.http2.Header[] r10 = okhttp3.internal.http2.Hpack.f31134e
                r11 = r10[r6]
                okio.ByteString r11 = r11.f31128b
                boolean r11 = okhttp3.internal.Util.r(r11, r5)
                if (r11 == 0) goto L_0x0059
                r6 = r9
                goto L_0x006e
            L_0x0059:
                r10 = r10[r9]
                okio.ByteString r10 = r10.f31128b
                boolean r10 = okhttp3.internal.Util.r(r10, r5)
                if (r10 == 0) goto L_0x0069
                int r6 = r6 + 2
                r12 = r9
                r9 = r6
                r6 = r12
                goto L_0x006e
            L_0x0069:
                r6 = r9
            L_0x006a:
                r9 = -1
                goto L_0x006e
            L_0x006c:
                r6 = -1
                goto L_0x006a
            L_0x006e:
                if (r9 != r8) goto L_0x00a6
                int r10 = r13.f31153h
                int r10 = r10 + r7
                okhttp3.internal.http2.Header[] r7 = r13.f31152g
                int r7 = r7.length
            L_0x0076:
                if (r10 >= r7) goto L_0x00a6
                okhttp3.internal.http2.Header[] r11 = r13.f31152g
                r11 = r11[r10]
                okio.ByteString r11 = r11.f31127a
                boolean r11 = okhttp3.internal.Util.r(r11, r4)
                if (r11 == 0) goto L_0x00a3
                okhttp3.internal.http2.Header[] r11 = r13.f31152g
                r11 = r11[r10]
                okio.ByteString r11 = r11.f31128b
                boolean r11 = okhttp3.internal.Util.r(r11, r5)
                if (r11 == 0) goto L_0x0099
                int r7 = r13.f31153h
                int r10 = r10 - r7
                okhttp3.internal.http2.Header[] r7 = okhttp3.internal.http2.Hpack.f31134e
                int r7 = r7.length
                int r9 = r10 + r7
                goto L_0x00a6
            L_0x0099:
                if (r6 != r8) goto L_0x00a3
                int r6 = r13.f31153h
                int r6 = r10 - r6
                okhttp3.internal.http2.Header[] r11 = okhttp3.internal.http2.Hpack.f31134e
                int r11 = r11.length
                int r6 = r6 + r11
            L_0x00a3:
                int r10 = r10 + 1
                goto L_0x0076
            L_0x00a6:
                if (r9 == r8) goto L_0x00b0
                r3 = 127(0x7f, float:1.78E-43)
                r4 = 128(0x80, float:1.794E-43)
                r13.h(r9, r3, r4)
                goto L_0x00e2
            L_0x00b0:
                r7 = 64
                if (r6 != r8) goto L_0x00c3
                okio.Buffer r6 = r13.f31146a
                r6.writeByte(r7)
                r13.f(r4)
            L_0x00bc:
                r13.f(r5)
                r13.d(r3)
                goto L_0x00e2
            L_0x00c3:
                okio.ByteString r8 = okhttp3.internal.http2.Header.f31116d
                boolean r8 = r4.p0(r8)
                if (r8 == 0) goto L_0x00dc
                okio.ByteString r8 = okhttp3.internal.http2.Header.f31126n
                boolean r4 = r8.equals(r4)
                if (r4 != 0) goto L_0x00dc
                r3 = 15
                r13.h(r6, r3, r1)
                r13.f(r5)
                goto L_0x00e2
            L_0x00dc:
                r4 = 63
                r13.h(r6, r4, r7)
                goto L_0x00bc
            L_0x00e2:
                int r2 = r2 + 1
                goto L_0x0023
            L_0x00e6:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Hpack.Writer.g(java.util.List):void");
        }

        /* access modifiers changed from: package-private */
        public void h(int i2, int i3, int i4) {
            int i5;
            Buffer buffer;
            if (i2 < i3) {
                buffer = this.f31146a;
                i5 = i2 | i4;
            } else {
                this.f31146a.writeByte(i4 | i3);
                i5 = i2 - i3;
                while (i5 >= 128) {
                    this.f31146a.writeByte(128 | (i5 & 127));
                    i5 >>>= 7;
                }
                buffer = this.f31146a;
            }
            buffer.writeByte(i5);
        }

        Writer(Buffer buffer) {
            this(4096, true, buffer);
        }
    }

    static {
        Header header = new Header(Header.f31126n, "");
        ByteString byteString = Header.f31123k;
        Header header2 = new Header(byteString, "GET");
        Header header3 = new Header(byteString, "POST");
        ByteString byteString2 = Header.f31124l;
        Header header4 = new Header(byteString2, "/");
        Header header5 = new Header(byteString2, "/index.html");
        ByteString byteString3 = Header.f31125m;
        Header header6 = new Header(byteString3, "http");
        Header header7 = new Header(byteString3, "https");
        ByteString byteString4 = Header.f31122j;
        Header header8 = new Header(byteString4, "200");
        Header header9 = new Header(byteString4, "204");
        Header header10 = new Header(byteString4, "206");
        Header header11 = new Header(byteString4, "304");
        Header header12 = new Header(byteString4, "400");
        Header header13 = new Header(byteString4, "404");
        Header header14 = new Header(byteString4, "500");
        Header header15 = header14;
        f31134e = new Header[]{header, header2, header3, header4, header5, header6, header7, header8, header9, header10, header11, header12, header13, header15, new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header(DublinCoreProperties.f27398d, ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header(HTML.Tag.C, ""), new Header("location", ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header(RFC2109Spec.SET_COOKIE_KEY, ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};
    }

    private Hpack() {
    }

    static ByteString a(ByteString byteString) throws IOException {
        int m0 = byteString.m0();
        int i2 = 0;
        while (i2 < m0) {
            byte q = byteString.q(i2);
            if (q < 65 || q > 90) {
                i2++;
            } else {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.I0());
            }
        }
        return byteString;
    }

    private static Map<ByteString, Integer> b() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f31134e.length);
        int i2 = 0;
        while (true) {
            Header[] headerArr = f31134e;
            if (i2 >= headerArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(headerArr[i2].f31127a)) {
                linkedHashMap.put(headerArr[i2].f31127a, Integer.valueOf(i2));
            }
            i2++;
        }
    }
}
