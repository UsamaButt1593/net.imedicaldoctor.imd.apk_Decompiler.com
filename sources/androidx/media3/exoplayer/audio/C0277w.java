package androidx.media3.exoplayer.audio;

import android.media.AudioDeviceInfo;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.Format;
import androidx.media3.common.util.Clock;
import androidx.media3.exoplayer.analytics.PlayerId;

/* renamed from: androidx.media3.exoplayer.audio.w  reason: case insensitive filesystem */
public final /* synthetic */ class C0277w {
    public static AudioOffloadSupport a(AudioSink audioSink, Format format) {
        return AudioOffloadSupport.f10770d;
    }

    @RequiresApi(29)
    public static void d(AudioSink audioSink, int i2, int i3) {
    }

    public static void c(AudioSink audioSink, Clock clock) {
    }

    @RequiresApi(29)
    public static void e(AudioSink audioSink, int i2) {
    }

    public static void f(AudioSink audioSink, long j2) {
    }

    public static void g(AudioSink audioSink, @Nullable PlayerId playerId) {
    }

    @RequiresApi(23)
    public static void h(AudioSink audioSink, @Nullable AudioDeviceInfo audioDeviceInfo) {
    }

    public static void b(AudioSink audioSink) {
    }
}
