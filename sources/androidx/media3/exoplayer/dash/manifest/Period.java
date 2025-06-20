package androidx.media3.exoplayer.dash.manifest;

import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;
import java.util.Collections;
import java.util.List;

@UnstableApi
public class Period {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final String f11167a;

    /* renamed from: b  reason: collision with root package name */
    public final long f11168b;

    /* renamed from: c  reason: collision with root package name */
    public final List<AdaptationSet> f11169c;

    /* renamed from: d  reason: collision with root package name */
    public final List<EventStream> f11170d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public final Descriptor f11171e;

    public Period(@Nullable String str, long j2, List<AdaptationSet> list) {
        this(str, j2, list, Collections.emptyList(), (Descriptor) null);
    }

    public int a(int i2) {
        int size = this.f11169c.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.f11169c.get(i3).f11119b == i2) {
                return i3;
            }
        }
        return -1;
    }

    public Period(@Nullable String str, long j2, List<AdaptationSet> list, List<EventStream> list2) {
        this(str, j2, list, list2, (Descriptor) null);
    }

    public Period(@Nullable String str, long j2, List<AdaptationSet> list, List<EventStream> list2, @Nullable Descriptor descriptor) {
        this.f11167a = str;
        this.f11168b = j2;
        this.f11169c = Collections.unmodifiableList(list);
        this.f11170d = Collections.unmodifiableList(list2);
        this.f11171e = descriptor;
    }
}
