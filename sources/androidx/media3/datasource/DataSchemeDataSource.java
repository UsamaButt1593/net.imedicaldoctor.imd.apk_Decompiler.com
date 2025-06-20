package androidx.media3.datasource;

import android.net.Uri;
import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.base.Charsets;
import java.io.IOException;
import java.net.URLDecoder;

@UnstableApi
public final class DataSchemeDataSource extends BaseDataSource {

    /* renamed from: j  reason: collision with root package name */
    public static final String f9767j = "data";
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private DataSpec f9768f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private byte[] f9769g;

    /* renamed from: h  reason: collision with root package name */
    private int f9770h;

    /* renamed from: i  reason: collision with root package name */
    private int f9771i;

    public DataSchemeDataSource() {
        super(false);
    }

    public long a(DataSpec dataSpec) throws IOException {
        v(dataSpec);
        this.f9768f = dataSpec;
        Uri normalizeScheme = dataSpec.f9779a.normalizeScheme();
        String scheme = normalizeScheme.getScheme();
        boolean equals = "data".equals(scheme);
        Assertions.b(equals, "Unsupported scheme: " + scheme);
        String[] p2 = Util.p2(normalizeScheme.getSchemeSpecificPart(), ",");
        if (p2.length == 2) {
            String str = p2[1];
            if (p2[0].contains(";base64")) {
                try {
                    this.f9769g = Base64.decode(str, 0);
                } catch (IllegalArgumentException e2) {
                    throw ParserException.b("Error while parsing Base64 encoded string: " + str, e2);
                }
            } else {
                this.f9769g = Util.R0(URLDecoder.decode(str, Charsets.f22253a.name()));
            }
            long j2 = dataSpec.f9785g;
            byte[] bArr = this.f9769g;
            if (j2 <= ((long) bArr.length)) {
                int i2 = (int) j2;
                this.f9770h = i2;
                int length = bArr.length - i2;
                this.f9771i = length;
                long j3 = dataSpec.f9786h;
                if (j3 != -1) {
                    this.f9771i = (int) Math.min((long) length, j3);
                }
                w(dataSpec);
                long j4 = dataSpec.f9786h;
                return j4 != -1 ? j4 : (long) this.f9771i;
            }
            this.f9769g = null;
            throw new DataSourceException(2008);
        }
        throw ParserException.b("Unexpected URI format: " + normalizeScheme, (Throwable) null);
    }

    @Nullable
    public Uri c() {
        DataSpec dataSpec = this.f9768f;
        if (dataSpec != null) {
            return dataSpec.f9779a;
        }
        return null;
    }

    public void close() {
        if (this.f9769g != null) {
            this.f9769g = null;
            u();
        }
        this.f9768f = null;
    }

    public int read(byte[] bArr, int i2, int i3) {
        if (i3 == 0) {
            return 0;
        }
        int i4 = this.f9771i;
        if (i4 == 0) {
            return -1;
        }
        int min = Math.min(i3, i4);
        System.arraycopy(Util.o(this.f9769g), this.f9770h, bArr, i2, min);
        this.f9770h += min;
        this.f9771i -= min;
        t(min);
        return min;
    }
}
