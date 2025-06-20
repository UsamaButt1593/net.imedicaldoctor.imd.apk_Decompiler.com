package androidx.media3.exoplayer.audio;

import android.media.AudioRouting;
import androidx.media3.exoplayer.audio.DefaultAudioSink;

public final /* synthetic */ class h0 implements AudioRouting.OnRoutingChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultAudioSink.OnRoutingChangedListenerApi24 f10950a;

    public /* synthetic */ h0(DefaultAudioSink.OnRoutingChangedListenerApi24 onRoutingChangedListenerApi24) {
        this.f10950a = onRoutingChangedListenerApi24;
    }

    public final void onRoutingChanged(AudioRouting audioRouting) {
        this.f10950a.b(audioRouting);
    }
}
