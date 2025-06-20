package androidx.media3.extractor.text;

import androidx.media3.common.util.Consumer;

public final /* synthetic */ class f implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SubtitleTranscodingTrackOutput f13916a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f13917b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f13918c;

    public /* synthetic */ f(SubtitleTranscodingTrackOutput subtitleTranscodingTrackOutput, long j2, int i2) {
        this.f13916a = subtitleTranscodingTrackOutput;
        this.f13917b = j2;
        this.f13918c = i2;
    }

    public final void accept(Object obj) {
        this.f13916a.i(this.f13917b, this.f13918c, (CuesWithTiming) obj);
    }
}
