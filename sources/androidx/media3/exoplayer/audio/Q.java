package androidx.media3.exoplayer.audio;

import androidx.media3.exoplayer.audio.AudioCapabilitiesReceiver;

public final /* synthetic */ class Q implements AudioCapabilitiesReceiver.Listener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultAudioSink f10909a;

    public /* synthetic */ Q(DefaultAudioSink defaultAudioSink) {
        this.f10909a = defaultAudioSink;
    }

    public final void a(AudioCapabilities audioCapabilities) {
        this.f10909a.i0(audioCapabilities);
    }
}
