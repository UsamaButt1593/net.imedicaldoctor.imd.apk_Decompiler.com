package okhttp3;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;
import org.apache.commons.httpclient.methods.PostMethod;

public final class FormBody extends RequestBody {

    /* renamed from: c  reason: collision with root package name */
    private static final MediaType f30859c = MediaType.c(PostMethod.FORM_URL_ENCODED_CONTENT_TYPE);

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f30860a;

    /* renamed from: b  reason: collision with root package name */
    private final List<String> f30861b;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final List<String> f30862a;

        /* renamed from: b  reason: collision with root package name */
        private final List<String> f30863b;

        /* renamed from: c  reason: collision with root package name */
        private final Charset f30864c;

        public Builder() {
            this((Charset) null);
        }

        public Builder a(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (str2 != null) {
                this.f30862a.add(HttpUrl.c(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.f30864c));
                this.f30863b.add(HttpUrl.c(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.f30864c));
                return this;
            } else {
                throw new NullPointerException("value == null");
            }
        }

        public Builder b(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (str2 != null) {
                this.f30862a.add(HttpUrl.c(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.f30864c));
                this.f30863b.add(HttpUrl.c(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.f30864c));
                return this;
            } else {
                throw new NullPointerException("value == null");
            }
        }

        public FormBody c() {
            return new FormBody(this.f30862a, this.f30863b);
        }

        public Builder(Charset charset) {
            this.f30862a = new ArrayList();
            this.f30863b = new ArrayList();
            this.f30864c = charset;
        }
    }

    FormBody(List<String> list, List<String> list2) {
        this.f30860a = Util.u(list);
        this.f30861b = Util.u(list2);
    }

    private long n(@Nullable BufferedSink bufferedSink, boolean z) {
        Buffer buffer = z ? new Buffer() : bufferedSink.g();
        int size = this.f30860a.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 > 0) {
                buffer.writeByte(38);
            }
            buffer.W0(this.f30860a.get(i2));
            buffer.writeByte(61);
            buffer.W0(this.f30861b.get(i2));
        }
        if (!z) {
            return 0;
        }
        long L0 = buffer.L0();
        buffer.d();
        return L0;
    }

    public long a() {
        return n((BufferedSink) null, true);
    }

    public MediaType b() {
        return f30859c;
    }

    public void h(BufferedSink bufferedSink) throws IOException {
        n(bufferedSink, false);
    }

    public String i(int i2) {
        return this.f30860a.get(i2);
    }

    public String j(int i2) {
        return this.f30861b.get(i2);
    }

    public String k(int i2) {
        return HttpUrl.A(i(i2), true);
    }

    public int l() {
        return this.f30860a.size();
    }

    public String m(int i2) {
        return HttpUrl.A(j(i2), true);
    }
}
