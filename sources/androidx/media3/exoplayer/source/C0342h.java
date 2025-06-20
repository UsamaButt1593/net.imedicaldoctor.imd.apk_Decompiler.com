package androidx.media3.exoplayer.source;

import com.google.common.base.Supplier;

/* renamed from: androidx.media3.exoplayer.source.h  reason: case insensitive filesystem */
public final /* synthetic */ class C0342h implements Supplier {
    public final /* synthetic */ Class s;

    public /* synthetic */ C0342h(Class cls) {
        this.s = cls;
    }

    public final Object get() {
        return DefaultMediaSourceFactory.p(this.s);
    }
}
