package androidx.media3.exoplayer.analytics;

import androidx.media3.common.MediaItem;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

/* renamed from: androidx.media3.exoplayer.analytics.k  reason: case insensitive filesystem */
public final /* synthetic */ class C0225k implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10675a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaItem f10676b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f10677c;

    public /* synthetic */ C0225k(AnalyticsListener.EventTime eventTime, MediaItem mediaItem, int i2) {
        this.f10675a = eventTime;
        this.f10676b = mediaItem;
        this.f10677c = i2;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).c0(this.f10675a, this.f10676b, this.f10677c);
    }
}
