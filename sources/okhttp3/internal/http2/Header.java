package okhttp3.internal.http2;

import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okio.ByteString;

public final class Header {

    /* renamed from: d  reason: collision with root package name */
    public static final ByteString f31116d = ByteString.n(":");

    /* renamed from: e  reason: collision with root package name */
    public static final String f31117e = ":status";

    /* renamed from: f  reason: collision with root package name */
    public static final String f31118f = ":method";

    /* renamed from: g  reason: collision with root package name */
    public static final String f31119g = ":path";

    /* renamed from: h  reason: collision with root package name */
    public static final String f31120h = ":scheme";

    /* renamed from: i  reason: collision with root package name */
    public static final String f31121i = ":authority";

    /* renamed from: j  reason: collision with root package name */
    public static final ByteString f31122j = ByteString.n(f31117e);

    /* renamed from: k  reason: collision with root package name */
    public static final ByteString f31123k = ByteString.n(f31118f);

    /* renamed from: l  reason: collision with root package name */
    public static final ByteString f31124l = ByteString.n(f31119g);

    /* renamed from: m  reason: collision with root package name */
    public static final ByteString f31125m = ByteString.n(f31120h);

    /* renamed from: n  reason: collision with root package name */
    public static final ByteString f31126n = ByteString.n(f31121i);

    /* renamed from: a  reason: collision with root package name */
    public final ByteString f31127a;

    /* renamed from: b  reason: collision with root package name */
    public final ByteString f31128b;

    /* renamed from: c  reason: collision with root package name */
    final int f31129c;

    interface Listener {
        void a(Headers headers);
    }

    public Header(String str, String str2) {
        this(ByteString.n(str), ByteString.n(str2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Header)) {
            return false;
        }
        Header header = (Header) obj;
        return this.f31127a.equals(header.f31127a) && this.f31128b.equals(header.f31128b);
    }

    public int hashCode() {
        return ((MetaDo.w + this.f31127a.hashCode()) * 31) + this.f31128b.hashCode();
    }

    public String toString() {
        return Util.s("%s: %s", this.f31127a.I0(), this.f31128b.I0());
    }

    public Header(ByteString byteString, String str) {
        this(byteString, ByteString.n(str));
    }

    public Header(ByteString byteString, ByteString byteString2) {
        this.f31127a = byteString;
        this.f31128b = byteString2;
        this.f31129c = byteString.m0() + 32 + byteString2.m0();
    }
}
