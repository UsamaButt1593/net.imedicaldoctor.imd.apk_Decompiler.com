package androidx.media3.common;

import androidx.media3.common.SimpleBasePlayer;

public final /* synthetic */ class c1 implements SimpleBasePlayer.PositionSupplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f9435b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f9436c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ float f9437d;

    public /* synthetic */ c1(long j2, long j3, float f2) {
        this.f9435b = j2;
        this.f9436c = j3;
        this.f9437d = f2;
    }

    public final long get() {
        return e1.d(this.f9435b, this.f9436c, this.f9437d);
    }
}
