package androidx.media3.exoplayer.video;

import android.view.Display;
import androidx.media3.exoplayer.video.VideoFrameReleaseHelper;

public final /* synthetic */ class l implements VideoFrameReleaseHelper.DisplayHelper.Listener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VideoFrameReleaseHelper f12819a;

    public /* synthetic */ l(VideoFrameReleaseHelper videoFrameReleaseHelper) {
        this.f12819a = videoFrameReleaseHelper;
    }

    public final void a(Display display) {
        this.f12819a.p(display);
    }
}
