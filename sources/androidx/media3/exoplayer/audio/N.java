package androidx.media3.exoplayer.audio;

import android.media.AudioTrack;
import android.os.Handler;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.exoplayer.audio.AudioSink;

public final /* synthetic */ class N implements Runnable {
    public final /* synthetic */ AudioSink.Listener X;
    public final /* synthetic */ ConditionVariable X2;
    public final /* synthetic */ Handler Y;
    public final /* synthetic */ AudioSink.AudioTrackConfig Z;
    public final /* synthetic */ AudioTrack s;

    public /* synthetic */ N(AudioTrack audioTrack, AudioSink.Listener listener, Handler handler, AudioSink.AudioTrackConfig audioTrackConfig, ConditionVariable conditionVariable) {
        this.s = audioTrack;
        this.X = listener;
        this.Y = handler;
        this.Z = audioTrackConfig;
        this.X2 = conditionVariable;
    }

    public final void run() {
        DefaultAudioSink.e0(this.s, this.X, this.Y, this.Z, this.X2);
    }
}
