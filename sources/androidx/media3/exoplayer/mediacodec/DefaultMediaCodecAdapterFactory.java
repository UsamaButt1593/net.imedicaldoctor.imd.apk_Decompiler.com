package androidx.media3.exoplayer.mediacodec;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecAdapter;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;
import androidx.media3.exoplayer.mediacodec.SynchronousMediaCodecAdapter;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;

@UnstableApi
public final class DefaultMediaCodecAdapterFactory implements MediaCodecAdapter.Factory {

    /* renamed from: e  reason: collision with root package name */
    private static final int f11677e = 0;

    /* renamed from: f  reason: collision with root package name */
    private static final int f11678f = 1;

    /* renamed from: g  reason: collision with root package name */
    private static final int f11679g = 2;

    /* renamed from: h  reason: collision with root package name */
    private static final String f11680h = "DMCodecAdapterFactory";
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final Context f11681b;

    /* renamed from: c  reason: collision with root package name */
    private int f11682c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f11683d;

    @Deprecated
    public DefaultMediaCodecAdapterFactory() {
        this.f11682c = 0;
        this.f11683d = true;
        this.f11681b = null;
    }

    private boolean e() {
        int i2 = Util.f9646a;
        if (i2 >= 31) {
            return true;
        }
        Context context = this.f11681b;
        return context != null && i2 >= 28 && context.getPackageManager().hasSystemFeature("com.amazon.hardware.tv_screen");
    }

    public MediaCodecAdapter a(MediaCodecAdapter.Configuration configuration) throws IOException {
        int i2;
        if (Util.f9646a < 23 || ((i2 = this.f11682c) != 1 && (i2 != 0 || !e()))) {
            return new SynchronousMediaCodecAdapter.Factory().a(configuration);
        }
        int l2 = MimeTypes.l(configuration.f11686c.f3);
        Log.h(f11680h, "Creating an asynchronous MediaCodec adapter for track type " + Util.P0(l2));
        AsynchronousMediaCodecAdapter.Factory factory = new AsynchronousMediaCodecAdapter.Factory(l2);
        factory.e(this.f11683d);
        return factory.a(configuration);
    }

    @CanIgnoreReturnValue
    public DefaultMediaCodecAdapterFactory b(boolean z) {
        this.f11683d = z;
        return this;
    }

    @CanIgnoreReturnValue
    public DefaultMediaCodecAdapterFactory c() {
        this.f11682c = 2;
        return this;
    }

    @CanIgnoreReturnValue
    public DefaultMediaCodecAdapterFactory d() {
        this.f11682c = 1;
        return this;
    }

    public DefaultMediaCodecAdapterFactory(Context context) {
        this.f11681b = context;
        this.f11682c = 0;
        this.f11683d = true;
    }
}
