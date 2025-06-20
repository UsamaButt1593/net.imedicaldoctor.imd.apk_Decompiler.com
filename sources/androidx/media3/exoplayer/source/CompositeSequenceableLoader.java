package androidx.media3.exoplayer.source;

import androidx.media3.common.C;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.LoadingInfo;
import com.google.common.collect.ImmutableList;
import java.util.Collections;
import java.util.List;

@UnstableApi
public final class CompositeSequenceableLoader implements SequenceableLoader {
    private long X;
    private final ImmutableList<SequenceableLoaderWithTrackTypes> s;

    private static final class SequenceableLoaderWithTrackTypes implements SequenceableLoader {
        private final ImmutableList<Integer> X;
        private final SequenceableLoader s;

        public SequenceableLoaderWithTrackTypes(SequenceableLoader sequenceableLoader, List<Integer> list) {
            this.s = sequenceableLoader;
            this.X = ImmutableList.B(list);
        }

        public boolean a(LoadingInfo loadingInfo) {
            return this.s.a(loadingInfo);
        }

        public ImmutableList<Integer> b() {
            return this.X;
        }

        public boolean c() {
            return this.s.c();
        }

        public long e() {
            return this.s.e();
        }

        public long g() {
            return this.s.g();
        }

        public void h(long j2) {
            this.s.h(j2);
        }
    }

    public CompositeSequenceableLoader(List<? extends SequenceableLoader> list, List<List<Integer>> list2) {
        ImmutableList.Builder r = ImmutableList.r();
        Assertions.a(list.size() == list2.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            r.g(new SequenceableLoaderWithTrackTypes((SequenceableLoader) list.get(i2), list2.get(i2)));
        }
        this.s = r.e();
        this.X = C.f9084b;
    }

    public boolean a(LoadingInfo loadingInfo) {
        boolean z;
        boolean z2 = false;
        do {
            long e2 = e();
            if (e2 == Long.MIN_VALUE) {
                break;
            }
            z = false;
            for (int i2 = 0; i2 < this.s.size(); i2++) {
                long e3 = this.s.get(i2).e();
                boolean z3 = e3 != Long.MIN_VALUE && e3 <= loadingInfo.f10228a;
                if (e3 == e2 || z3) {
                    z |= this.s.get(i2).a(loadingInfo);
                }
            }
            z2 |= z;
        } while (z);
        return z2;
    }

    public boolean c() {
        for (int i2 = 0; i2 < this.s.size(); i2++) {
            if (this.s.get(i2).c()) {
                return true;
            }
        }
        return false;
    }

    public long e() {
        long j2 = Long.MAX_VALUE;
        for (int i2 = 0; i2 < this.s.size(); i2++) {
            long e2 = this.s.get(i2).e();
            if (e2 != Long.MIN_VALUE) {
                j2 = Math.min(j2, e2);
            }
        }
        if (j2 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j2;
    }

    public long g() {
        long j2 = Long.MAX_VALUE;
        long j3 = Long.MAX_VALUE;
        for (int i2 = 0; i2 < this.s.size(); i2++) {
            SequenceableLoaderWithTrackTypes sequenceableLoaderWithTrackTypes = this.s.get(i2);
            long g2 = sequenceableLoaderWithTrackTypes.g();
            if ((sequenceableLoaderWithTrackTypes.b().contains(1) || sequenceableLoaderWithTrackTypes.b().contains(2) || sequenceableLoaderWithTrackTypes.b().contains(4)) && g2 != Long.MIN_VALUE) {
                j2 = Math.min(j2, g2);
            }
            if (g2 != Long.MIN_VALUE) {
                j3 = Math.min(j3, g2);
            }
        }
        if (j2 != Long.MAX_VALUE) {
            this.X = j2;
            return j2;
        } else if (j3 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        } else {
            long j4 = this.X;
            return j4 != C.f9084b ? j4 : j3;
        }
    }

    public void h(long j2) {
        for (int i2 = 0; i2 < this.s.size(); i2++) {
            this.s.get(i2).h(j2);
        }
    }

    @Deprecated
    public CompositeSequenceableLoader(SequenceableLoader[] sequenceableLoaderArr) {
        this(ImmutableList.D(sequenceableLoaderArr), Collections.nCopies(sequenceableLoaderArr.length, ImmutableList.K(-1)));
    }
}
