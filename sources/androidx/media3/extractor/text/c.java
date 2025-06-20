package androidx.media3.extractor.text;

import androidx.media3.common.util.Consumer;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SubtitleExtractor f13799a;

    public /* synthetic */ c(SubtitleExtractor subtitleExtractor) {
        this.f13799a = subtitleExtractor;
    }

    public final void accept(Object obj) {
        this.f13799a.f((CuesWithTiming) obj);
    }
}
