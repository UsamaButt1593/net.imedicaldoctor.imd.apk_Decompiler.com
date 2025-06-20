package androidx.media3.exoplayer.dash.manifest;

import androidx.media3.common.util.UnstableApi;
import java.util.Collections;
import java.util.List;

@UnstableApi
public class AdaptationSet {

    /* renamed from: g  reason: collision with root package name */
    public static final long f11117g = -1;

    /* renamed from: a  reason: collision with root package name */
    public final long f11118a;

    /* renamed from: b  reason: collision with root package name */
    public final int f11119b;

    /* renamed from: c  reason: collision with root package name */
    public final List<Representation> f11120c;

    /* renamed from: d  reason: collision with root package name */
    public final List<Descriptor> f11121d;

    /* renamed from: e  reason: collision with root package name */
    public final List<Descriptor> f11122e;

    /* renamed from: f  reason: collision with root package name */
    public final List<Descriptor> f11123f;

    public AdaptationSet(long j2, int i2, List<Representation> list, List<Descriptor> list2, List<Descriptor> list3, List<Descriptor> list4) {
        this.f11118a = j2;
        this.f11119b = i2;
        this.f11120c = Collections.unmodifiableList(list);
        this.f11121d = Collections.unmodifiableList(list2);
        this.f11122e = Collections.unmodifiableList(list3);
        this.f11123f = Collections.unmodifiableList(list4);
    }
}
