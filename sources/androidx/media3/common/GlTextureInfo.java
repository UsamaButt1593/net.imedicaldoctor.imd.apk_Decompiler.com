package androidx.media3.common;

import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
public final class GlTextureInfo {

    /* renamed from: f  reason: collision with root package name */
    public static final GlTextureInfo f9149f = new GlTextureInfo(-1, -1, -1, -1, -1);

    /* renamed from: a  reason: collision with root package name */
    public final int f9150a;

    /* renamed from: b  reason: collision with root package name */
    public final int f9151b;

    /* renamed from: c  reason: collision with root package name */
    public final int f9152c;

    /* renamed from: d  reason: collision with root package name */
    public final int f9153d;

    /* renamed from: e  reason: collision with root package name */
    public final int f9154e;

    public GlTextureInfo(int i2, int i3, int i4, int i5, int i6) {
        this.f9150a = i2;
        this.f9151b = i3;
        this.f9152c = i4;
        this.f9153d = i5;
        this.f9154e = i6;
    }

    public void a() throws GlUtil.GlException {
        int i2 = this.f9150a;
        if (i2 != -1) {
            GlUtil.z(i2);
        }
        int i3 = this.f9151b;
        if (i3 != -1) {
            GlUtil.v(i3);
        }
        int i4 = this.f9152c;
        if (i4 != -1) {
            GlUtil.w(i4);
        }
    }
}
