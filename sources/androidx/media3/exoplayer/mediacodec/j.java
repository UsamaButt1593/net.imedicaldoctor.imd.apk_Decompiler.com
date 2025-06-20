package androidx.media3.exoplayer.mediacodec;

import android.content.Context;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;

public final /* synthetic */ class j {
    static {
        MediaCodecAdapter.Factory factory = MediaCodecAdapter.Factory.f11690a;
    }

    public static MediaCodecAdapter.Factory a(Context context) {
        return new DefaultMediaCodecAdapterFactory(context);
    }
}
