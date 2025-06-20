package androidx.media3.exoplayer.drm;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSourceInputStream;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.HttpDataSource;
import androidx.media3.datasource.StatsDataSource;
import androidx.media3.exoplayer.drm.ExoMediaDrm;
import com.google.common.collect.ImmutableMap;
import com.google.common.net.HttpHeaders;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.apache.commons.httpclient.methods.multipart.FilePart;

@UnstableApi
public final class HttpMediaDrmCallback implements MediaDrmCallback {

    /* renamed from: e  reason: collision with root package name */
    private static final int f11342e = 5;

    /* renamed from: a  reason: collision with root package name */
    private final DataSource.Factory f11343a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final String f11344b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f11345c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, String> f11346d;

    public HttpMediaDrmCallback(@Nullable String str, DataSource.Factory factory) {
        this(str, false, factory);
    }

    private static byte[] e(DataSource.Factory factory, String str, @Nullable byte[] bArr, Map<String, String> map) throws MediaDrmCallbackException {
        DataSourceInputStream dataSourceInputStream;
        StatsDataSource statsDataSource = new StatsDataSource(factory.a());
        DataSpec a2 = new DataSpec.Builder().k(str).f(map).e(2).d(bArr).c(1).a();
        int i2 = 0;
        DataSpec dataSpec = a2;
        while (true) {
            try {
                dataSourceInputStream = new DataSourceInputStream(statsDataSource, dataSpec);
                byte[] y2 = Util.y2(dataSourceInputStream);
                Util.t(dataSourceInputStream);
                return y2;
            } catch (HttpDataSource.InvalidResponseCodeException e2) {
                String f2 = f(e2, i2);
                if (f2 != null) {
                    i2++;
                    dataSpec = dataSpec.a().k(f2).a();
                    Util.t(dataSourceInputStream);
                } else {
                    throw e2;
                }
            } catch (Exception e3) {
                throw new MediaDrmCallbackException(a2, (Uri) Assertions.g(statsDataSource.u()), statsDataSource.getResponseHeaders(), statsDataSource.t(), e3);
            } catch (Throwable th) {
                Util.t(dataSourceInputStream);
                throw th;
            }
        }
    }

    @Nullable
    private static String f(HttpDataSource.InvalidResponseCodeException invalidResponseCodeException, int i2) {
        Map<String, List<String>> map;
        List list;
        int i3 = invalidResponseCodeException.a3;
        if ((i3 == 307 || i3 == 308) && i2 < 5 && (map = invalidResponseCodeException.c3) != null && (list = map.get(HttpHeaders.t0)) != null && !list.isEmpty()) {
            return (String) list.get(0);
        }
        return null;
    }

    public byte[] a(UUID uuid, ExoMediaDrm.ProvisionRequest provisionRequest) throws MediaDrmCallbackException {
        return e(this.f11343a, provisionRequest.b() + "&signedRequest=" + Util.T(provisionRequest.a()), (byte[]) null, Collections.emptyMap());
    }

    public byte[] b(UUID uuid, ExoMediaDrm.KeyRequest keyRequest) throws MediaDrmCallbackException {
        String b2 = keyRequest.b();
        if (this.f11345c || TextUtils.isEmpty(b2)) {
            b2 = this.f11344b;
        }
        if (!TextUtils.isEmpty(b2)) {
            HashMap hashMap = new HashMap();
            UUID uuid2 = C.l2;
            hashMap.put(HttpHeaders.f22875c, uuid2.equals(uuid) ? "text/xml" : C.j2.equals(uuid) ? "application/json" : FilePart.DEFAULT_CONTENT_TYPE);
            if (uuid2.equals(uuid)) {
                hashMap.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
            }
            synchronized (this.f11346d) {
                hashMap.putAll(this.f11346d);
            }
            return e(this.f11343a, b2, keyRequest.a(), hashMap);
        }
        DataSpec.Builder builder = new DataSpec.Builder();
        Uri uri = Uri.EMPTY;
        throw new MediaDrmCallbackException(builder.j(uri).a(), uri, ImmutableMap.s(), 0, new IllegalStateException("No license URL"));
    }

    public void c() {
        synchronized (this.f11346d) {
            this.f11346d.clear();
        }
    }

    public void d(String str) {
        Assertions.g(str);
        synchronized (this.f11346d) {
            this.f11346d.remove(str);
        }
    }

    public void g(String str, String str2) {
        Assertions.g(str);
        Assertions.g(str2);
        synchronized (this.f11346d) {
            this.f11346d.put(str, str2);
        }
    }

    public HttpMediaDrmCallback(@Nullable String str, boolean z, DataSource.Factory factory) {
        Assertions.a(!z || !TextUtils.isEmpty(str));
        this.f11343a = factory;
        this.f11344b = str;
        this.f11345c = z;
        this.f11346d = new HashMap();
    }
}
