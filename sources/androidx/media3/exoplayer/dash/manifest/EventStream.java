package androidx.media3.exoplayer.dash.manifest;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.metadata.emsg.EventMessage;

@UnstableApi
public final class EventStream {

    /* renamed from: a  reason: collision with root package name */
    public final EventMessage[] f11162a;

    /* renamed from: b  reason: collision with root package name */
    public final long[] f11163b;

    /* renamed from: c  reason: collision with root package name */
    public final String f11164c;

    /* renamed from: d  reason: collision with root package name */
    public final String f11165d;

    /* renamed from: e  reason: collision with root package name */
    public final long f11166e;

    public EventStream(String str, String str2, long j2, long[] jArr, EventMessage[] eventMessageArr) {
        this.f11164c = str;
        this.f11165d = str2;
        this.f11166e = j2;
        this.f11163b = jArr;
        this.f11162a = eventMessageArr;
    }

    public String a() {
        return this.f11164c + "/" + this.f11165d;
    }
}
