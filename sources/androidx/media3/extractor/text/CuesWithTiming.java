package androidx.media3.extractor.text;

import androidx.media3.common.C;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.UnstableApi;
import com.google.common.collect.ImmutableList;
import java.util.List;

@UnstableApi
public class CuesWithTiming {

    /* renamed from: a  reason: collision with root package name */
    public final ImmutableList<Cue> f13768a;

    /* renamed from: b  reason: collision with root package name */
    public final long f13769b;

    /* renamed from: c  reason: collision with root package name */
    public final long f13770c;

    /* renamed from: d  reason: collision with root package name */
    public final long f13771d;

    public CuesWithTiming(List<Cue> list, long j2, long j3) {
        this.f13768a = ImmutableList.B(list);
        this.f13769b = j2;
        this.f13770c = j3;
        long j4 = C.f9084b;
        if (!(j2 == C.f9084b || j3 == C.f9084b)) {
            j4 = j2 + j3;
        }
        this.f13771d = j4;
    }
}
