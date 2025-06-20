package okhttp3.internal.cache;

import com.google.common.net.HttpHeaders;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Internal;
import okhttp3.internal.http.HttpDate;
import org.apache.commons.lang3.time.DateUtils;

public final class CacheStrategy {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final Request f30985a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final Response f30986b;

    public static class Factory {

        /* renamed from: a  reason: collision with root package name */
        final long f30987a;

        /* renamed from: b  reason: collision with root package name */
        final Request f30988b;

        /* renamed from: c  reason: collision with root package name */
        final Response f30989c;

        /* renamed from: d  reason: collision with root package name */
        private Date f30990d;

        /* renamed from: e  reason: collision with root package name */
        private String f30991e;

        /* renamed from: f  reason: collision with root package name */
        private Date f30992f;

        /* renamed from: g  reason: collision with root package name */
        private String f30993g;

        /* renamed from: h  reason: collision with root package name */
        private Date f30994h;

        /* renamed from: i  reason: collision with root package name */
        private long f30995i;

        /* renamed from: j  reason: collision with root package name */
        private long f30996j;

        /* renamed from: k  reason: collision with root package name */
        private String f30997k;

        /* renamed from: l  reason: collision with root package name */
        private int f30998l = -1;

        public Factory(long j2, Request request, Response response) {
            this.f30987a = j2;
            this.f30988b = request;
            this.f30989c = response;
            if (response != null) {
                this.f30995i = response.C();
                this.f30996j = response.y();
                Headers p = response.p();
                int l2 = p.l();
                for (int i2 = 0; i2 < l2; i2++) {
                    String g2 = p.g(i2);
                    String n2 = p.n(i2);
                    if (HttpHeaders.f22876d.equalsIgnoreCase(g2)) {
                        this.f30990d = HttpDate.b(n2);
                        this.f30991e = n2;
                    } else if (HttpHeaders.q0.equalsIgnoreCase(g2)) {
                        this.f30994h = HttpDate.b(n2);
                    } else if (HttpHeaders.r0.equalsIgnoreCase(g2)) {
                        this.f30992f = HttpDate.b(n2);
                        this.f30993g = n2;
                    } else if (HttpHeaders.p0.equalsIgnoreCase(g2)) {
                        this.f30997k = n2;
                    } else if (HttpHeaders.Y.equalsIgnoreCase(g2)) {
                        this.f30998l = okhttp3.internal.http.HttpHeaders.h(n2, -1);
                    }
                }
            }
        }

        private long a() {
            Date date = this.f30990d;
            long j2 = 0;
            if (date != null) {
                j2 = Math.max(0, this.f30996j - date.getTime());
            }
            int i2 = this.f30998l;
            if (i2 != -1) {
                j2 = Math.max(j2, TimeUnit.SECONDS.toMillis((long) i2));
            }
            long j3 = this.f30996j;
            return j2 + (j3 - this.f30995i) + (this.f30987a - j3);
        }

        private long b() {
            CacheControl c2 = this.f30989c.c();
            if (c2.e() != -1) {
                return TimeUnit.SECONDS.toMillis((long) c2.e());
            }
            if (this.f30994h != null) {
                Date date = this.f30990d;
                long time = this.f30994h.getTime() - (date != null ? date.getTime() : this.f30996j);
                if (time > 0) {
                    return time;
                }
                return 0;
            } else if (this.f30992f == null || this.f30989c.A().k().F() != null) {
                return 0;
            } else {
                Date date2 = this.f30990d;
                long time2 = (date2 != null ? date2.getTime() : this.f30995i) - this.f30992f.getTime();
                if (time2 > 0) {
                    return time2 / 10;
                }
                return 0;
            }
        }

        private CacheStrategy d() {
            String str;
            if (this.f30989c == null) {
                return new CacheStrategy(this.f30988b, (Response) null);
            }
            if (this.f30988b.f() && this.f30989c.h() == null) {
                return new CacheStrategy(this.f30988b, (Response) null);
            }
            if (!CacheStrategy.a(this.f30989c, this.f30988b)) {
                return new CacheStrategy(this.f30988b, (Response) null);
            }
            CacheControl b2 = this.f30988b.b();
            if (b2.i() || e(this.f30988b)) {
                return new CacheStrategy(this.f30988b, (Response) null);
            }
            CacheControl c2 = this.f30989c.c();
            long a2 = a();
            long b3 = b();
            if (b2.e() != -1) {
                b3 = Math.min(b3, TimeUnit.SECONDS.toMillis((long) b2.e()));
            }
            long j2 = 0;
            long millis = b2.g() != -1 ? TimeUnit.SECONDS.toMillis((long) b2.g()) : 0;
            if (!c2.h() && b2.f() != -1) {
                j2 = TimeUnit.SECONDS.toMillis((long) b2.f());
            }
            if (!c2.i()) {
                long j3 = millis + a2;
                if (j3 < j2 + b3) {
                    Response.Builder u = this.f30989c.u();
                    if (j3 >= b3) {
                        u.a(HttpHeaders.f22879g, "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (a2 > DateUtils.MILLIS_PER_DAY && f()) {
                        u.a(HttpHeaders.f22879g, "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new CacheStrategy((Request) null, u.c());
                }
            }
            String str2 = this.f30997k;
            if (str2 != null) {
                str = HttpHeaders.A;
            } else {
                if (this.f30992f != null) {
                    str2 = this.f30993g;
                } else if (this.f30990d == null) {
                    return new CacheStrategy(this.f30988b, (Response) null);
                } else {
                    str2 = this.f30991e;
                }
                str = HttpHeaders.z;
            }
            Headers.Builder i2 = this.f30988b.e().i();
            Internal.f30969a.b(i2, str, str2);
            return new CacheStrategy(this.f30988b.h().i(i2.h()).b(), this.f30989c);
        }

        private static boolean e(Request request) {
            return (request.c(HttpHeaders.z) == null && request.c(HttpHeaders.A) == null) ? false : true;
        }

        private boolean f() {
            return this.f30989c.c().e() == -1 && this.f30994h == null;
        }

        public CacheStrategy c() {
            CacheStrategy d2 = d();
            return (d2.f30985a == null || !this.f30988b.b().l()) ? d2 : new CacheStrategy((Request) null, (Response) null);
        }
    }

    CacheStrategy(Request request, Response response) {
        this.f30985a = request;
        this.f30986b = response;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0056, code lost:
        if (r3.c().c() == false) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0059, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(okhttp3.Response r3, okhttp3.Request r4) {
        /*
            int r0 = r3.f()
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 0
            if (r0 == r1) goto L_0x005a
            r1 = 410(0x19a, float:5.75E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 414(0x19e, float:5.8E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 501(0x1f5, float:7.02E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 203(0xcb, float:2.84E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 307(0x133, float:4.3E-43)
            if (r0 == r1) goto L_0x0031
            r1 = 308(0x134, float:4.32E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 404(0x194, float:5.66E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 405(0x195, float:5.68E-43)
            if (r0 == r1) goto L_0x005a
            switch(r0) {
                case 300: goto L_0x005a;
                case 301: goto L_0x005a;
                case 302: goto L_0x0031;
                default: goto L_0x0030;
            }
        L_0x0030:
            goto L_0x0059
        L_0x0031:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r3.i(r0)
            if (r0 != 0) goto L_0x005a
            okhttp3.CacheControl r0 = r3.c()
            int r0 = r0.e()
            r1 = -1
            if (r0 != r1) goto L_0x005a
            okhttp3.CacheControl r0 = r3.c()
            boolean r0 = r0.d()
            if (r0 != 0) goto L_0x005a
            okhttp3.CacheControl r0 = r3.c()
            boolean r0 = r0.c()
            if (r0 == 0) goto L_0x0059
            goto L_0x005a
        L_0x0059:
            return r2
        L_0x005a:
            okhttp3.CacheControl r3 = r3.c()
            boolean r3 = r3.j()
            if (r3 != 0) goto L_0x006f
            okhttp3.CacheControl r3 = r4.b()
            boolean r3 = r3.j()
            if (r3 != 0) goto L_0x006f
            r2 = 1
        L_0x006f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.CacheStrategy.a(okhttp3.Response, okhttp3.Request):boolean");
    }
}
