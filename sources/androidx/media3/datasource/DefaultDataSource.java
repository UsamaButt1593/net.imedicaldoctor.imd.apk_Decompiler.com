package androidx.media3.datasource;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DefaultHttpDataSource;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class DefaultDataSource implements DataSource {

    /* renamed from: m  reason: collision with root package name */
    private static final String f9800m = "DefaultDataSource";

    /* renamed from: n  reason: collision with root package name */
    private static final String f9801n = "asset";
    private static final String o = "content";
    private static final String p = "rtmp";
    private static final String q = "udp";
    private static final String r = "data";
    private static final String s = "rawresource";
    private static final String t = "android.resource";

    /* renamed from: b  reason: collision with root package name */
    private final Context f9802b;

    /* renamed from: c  reason: collision with root package name */
    private final List<TransferListener> f9803c;

    /* renamed from: d  reason: collision with root package name */
    private final DataSource f9804d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private DataSource f9805e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private DataSource f9806f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private DataSource f9807g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private DataSource f9808h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private DataSource f9809i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private DataSource f9810j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private DataSource f9811k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private DataSource f9812l;

    public static final class Factory implements DataSource.Factory {

        /* renamed from: a  reason: collision with root package name */
        private final Context f9813a;

        /* renamed from: b  reason: collision with root package name */
        private final DataSource.Factory f9814b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private TransferListener f9815c;

        public Factory(Context context) {
            this(context, new DefaultHttpDataSource.Factory());
        }

        @UnstableApi
        /* renamed from: c */
        public DefaultDataSource a() {
            DefaultDataSource defaultDataSource = new DefaultDataSource(this.f9813a, this.f9814b.a());
            TransferListener transferListener = this.f9815c;
            if (transferListener != null) {
                defaultDataSource.e(transferListener);
            }
            return defaultDataSource;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Factory d(@Nullable TransferListener transferListener) {
            this.f9815c = transferListener;
            return this;
        }

        public Factory(Context context, DataSource.Factory factory) {
            this.f9813a = context.getApplicationContext();
            this.f9814b = factory;
        }
    }

    @UnstableApi
    public DefaultDataSource(Context context, DataSource dataSource) {
        this.f9802b = context.getApplicationContext();
        this.f9804d = (DataSource) Assertions.g(dataSource);
        this.f9803c = new ArrayList();
    }

    private DataSource A() {
        if (this.f9809i == null) {
            UdpDataSource udpDataSource = new UdpDataSource();
            this.f9809i = udpDataSource;
            t(udpDataSource);
        }
        return this.f9809i;
    }

    private void B(@Nullable DataSource dataSource, TransferListener transferListener) {
        if (dataSource != null) {
            dataSource.e(transferListener);
        }
    }

    private void t(DataSource dataSource) {
        for (int i2 = 0; i2 < this.f9803c.size(); i2++) {
            dataSource.e(this.f9803c.get(i2));
        }
    }

    private DataSource u() {
        if (this.f9806f == null) {
            AssetDataSource assetDataSource = new AssetDataSource(this.f9802b);
            this.f9806f = assetDataSource;
            t(assetDataSource);
        }
        return this.f9806f;
    }

    private DataSource v() {
        if (this.f9807g == null) {
            ContentDataSource contentDataSource = new ContentDataSource(this.f9802b);
            this.f9807g = contentDataSource;
            t(contentDataSource);
        }
        return this.f9807g;
    }

    private DataSource w() {
        if (this.f9810j == null) {
            DataSchemeDataSource dataSchemeDataSource = new DataSchemeDataSource();
            this.f9810j = dataSchemeDataSource;
            t(dataSchemeDataSource);
        }
        return this.f9810j;
    }

    private DataSource x() {
        if (this.f9805e == null) {
            FileDataSource fileDataSource = new FileDataSource();
            this.f9805e = fileDataSource;
            t(fileDataSource);
        }
        return this.f9805e;
    }

    private DataSource y() {
        if (this.f9811k == null) {
            RawResourceDataSource rawResourceDataSource = new RawResourceDataSource(this.f9802b);
            this.f9811k = rawResourceDataSource;
            t(rawResourceDataSource);
        }
        return this.f9811k;
    }

    private DataSource z() {
        if (this.f9808h == null) {
            try {
                DataSource dataSource = (DataSource) Class.forName("androidx.media3.datasource.rtmp.RtmpDataSource").getConstructor((Class[]) null).newInstance((Object[]) null);
                this.f9808h = dataSource;
                t(dataSource);
            } catch (ClassNotFoundException unused) {
                Log.n(f9800m, "Attempting to play RTMP stream without depending on the RTMP extension");
            } catch (Exception e2) {
                throw new RuntimeException("Error instantiating RTMP extension", e2);
            }
            if (this.f9808h == null) {
                this.f9808h = this.f9804d;
            }
        }
        return this.f9808h;
    }

    @UnstableApi
    public long a(DataSpec dataSpec) throws IOException {
        DataSource dataSource;
        Assertions.i(this.f9812l == null);
        String scheme = dataSpec.f9779a.getScheme();
        if (Util.l1(dataSpec.f9779a)) {
            String path = dataSpec.f9779a.getPath();
            if (path == null || !path.startsWith("/android_asset/")) {
                dataSource = x();
                this.f9812l = dataSource;
                return this.f9812l.a(dataSpec);
            }
        } else if (!f9801n.equals(scheme)) {
            dataSource = "content".equals(scheme) ? v() : p.equals(scheme) ? z() : q.equals(scheme) ? A() : "data".equals(scheme) ? w() : ("rawresource".equals(scheme) || t.equals(scheme)) ? y() : this.f9804d;
            this.f9812l = dataSource;
            return this.f9812l.a(dataSpec);
        }
        dataSource = u();
        this.f9812l = dataSource;
        return this.f9812l.a(dataSpec);
    }

    @UnstableApi
    @Nullable
    public Uri c() {
        DataSource dataSource = this.f9812l;
        if (dataSource == null) {
            return null;
        }
        return dataSource.c();
    }

    @UnstableApi
    public void close() throws IOException {
        DataSource dataSource = this.f9812l;
        if (dataSource != null) {
            try {
                dataSource.close();
            } finally {
                this.f9812l = null;
            }
        }
    }

    @UnstableApi
    public void e(TransferListener transferListener) {
        Assertions.g(transferListener);
        this.f9804d.e(transferListener);
        this.f9803c.add(transferListener);
        B(this.f9805e, transferListener);
        B(this.f9806f, transferListener);
        B(this.f9807g, transferListener);
        B(this.f9808h, transferListener);
        B(this.f9809i, transferListener);
        B(this.f9810j, transferListener);
        B(this.f9811k, transferListener);
    }

    @UnstableApi
    public Map<String, List<String>> getResponseHeaders() {
        DataSource dataSource = this.f9812l;
        return dataSource == null ? Collections.emptyMap() : dataSource.getResponseHeaders();
    }

    @UnstableApi
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        return ((DataSource) Assertions.g(this.f9812l)).read(bArr, i2, i3);
    }

    @UnstableApi
    public DefaultDataSource(Context context, @Nullable String str, int i2, int i3, boolean z) {
        this(context, (DataSource) new DefaultHttpDataSource.Factory().k(str).e(i2).i(i3).d(z).a());
    }

    @UnstableApi
    public DefaultDataSource(Context context, @Nullable String str, boolean z) {
        this(context, str, 8000, 8000, z);
    }

    @UnstableApi
    public DefaultDataSource(Context context, boolean z) {
        this(context, (String) null, 8000, 8000, z);
    }
}
