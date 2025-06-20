package androidx.media3.exoplayer.dash.manifest;

import androidx.media3.common.util.UnstableApi;

@UnstableApi
public final class UtcTimingElement {

    /* renamed from: a  reason: collision with root package name */
    public final String f11231a;

    /* renamed from: b  reason: collision with root package name */
    public final String f11232b;

    public UtcTimingElement(String str, String str2) {
        this.f11231a = str;
        this.f11232b = str2;
    }

    public String toString() {
        return this.f11231a + ", " + this.f11232b;
    }
}
