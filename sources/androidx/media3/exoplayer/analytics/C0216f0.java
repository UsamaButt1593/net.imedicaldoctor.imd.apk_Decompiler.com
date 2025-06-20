package androidx.media3.exoplayer.analytics;

import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

/* renamed from: androidx.media3.exoplayer.analytics.f0  reason: case insensitive filesystem */
public final /* synthetic */ class C0216f0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10655a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CueGroup f10656b;

    public /* synthetic */ C0216f0(AnalyticsListener.EventTime eventTime, CueGroup cueGroup) {
        this.f10655a = eventTime;
        this.f10656b = cueGroup;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).Q(this.f10655a, this.f10656b);
    }
}
