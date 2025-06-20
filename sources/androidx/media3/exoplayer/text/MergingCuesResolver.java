package androidx.media3.exoplayer.text;

import androidx.media3.common.C;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Assertions;
import androidx.media3.extractor.text.CuesWithTiming;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import java.util.ArrayList;
import java.util.List;

final class MergingCuesResolver implements CuesResolver {

    /* renamed from: b  reason: collision with root package name */
    private static final Ordering<CuesWithTiming> f12343b = Ordering.z().D(new a()).e(Ordering.z().E().D(new b()));

    /* renamed from: a  reason: collision with root package name */
    private final List<CuesWithTiming> f12344a = new ArrayList();

    public long a(long j2) {
        int i2 = 0;
        long j3 = -9223372036854775807L;
        while (true) {
            if (i2 >= this.f12344a.size()) {
                break;
            }
            long j4 = this.f12344a.get(i2).f13769b;
            long j5 = this.f12344a.get(i2).f13771d;
            if (j2 < j4) {
                j3 = j3 == C.f9084b ? j4 : Math.min(j3, j4);
            } else {
                if (j2 < j5) {
                    j3 = j3 == C.f9084b ? j5 : Math.min(j3, j5);
                }
                i2++;
            }
        }
        if (j3 != C.f9084b) {
            return j3;
        }
        return Long.MIN_VALUE;
    }

    public ImmutableList<Cue> b(long j2) {
        if (!this.f12344a.isEmpty()) {
            if (j2 >= this.f12344a.get(0).f13769b) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < this.f12344a.size(); i2++) {
                    CuesWithTiming cuesWithTiming = this.f12344a.get(i2);
                    if (j2 >= cuesWithTiming.f13769b && j2 < cuesWithTiming.f13771d) {
                        arrayList.add(cuesWithTiming);
                    }
                    if (j2 < cuesWithTiming.f13769b) {
                        break;
                    }
                }
                ImmutableList<E> a0 = ImmutableList.a0(f12343b, arrayList);
                ImmutableList.Builder r = ImmutableList.r();
                for (int i3 = 0; i3 < a0.size(); i3++) {
                    r.c(((CuesWithTiming) a0.get(i3)).f13768a);
                }
                return r.e();
            }
        }
        return ImmutableList.I();
    }

    public boolean c(CuesWithTiming cuesWithTiming, long j2) {
        Assertions.a(cuesWithTiming.f13769b != C.f9084b);
        Assertions.a(cuesWithTiming.f13770c != C.f9084b);
        boolean z = cuesWithTiming.f13769b <= j2 && j2 < cuesWithTiming.f13771d;
        for (int size = this.f12344a.size() - 1; size >= 0; size--) {
            if (cuesWithTiming.f13769b >= this.f12344a.get(size).f13769b) {
                this.f12344a.add(size + 1, cuesWithTiming);
                return z;
            }
        }
        this.f12344a.add(0, cuesWithTiming);
        return z;
    }

    public void clear() {
        this.f12344a.clear();
    }

    public long d(long j2) {
        if (this.f12344a.isEmpty()) {
            return C.f9084b;
        }
        if (j2 < this.f12344a.get(0).f13769b) {
            return C.f9084b;
        }
        long j3 = this.f12344a.get(0).f13769b;
        for (int i2 = 0; i2 < this.f12344a.size(); i2++) {
            long j4 = this.f12344a.get(i2).f13769b;
            long j5 = this.f12344a.get(i2).f13771d;
            if (j5 > j2) {
                if (j4 > j2) {
                    break;
                }
                j3 = Math.max(j3, j4);
            } else {
                j3 = Math.max(j3, j5);
            }
        }
        return j3;
    }

    public void e(long j2) {
        int i2 = 0;
        while (i2 < this.f12344a.size()) {
            int i3 = (j2 > this.f12344a.get(i2).f13769b ? 1 : (j2 == this.f12344a.get(i2).f13769b ? 0 : -1));
            if (i3 > 0 && j2 > this.f12344a.get(i2).f13771d) {
                this.f12344a.remove(i2);
                i2--;
            } else if (i3 < 0) {
                return;
            }
            i2++;
        }
    }
}
