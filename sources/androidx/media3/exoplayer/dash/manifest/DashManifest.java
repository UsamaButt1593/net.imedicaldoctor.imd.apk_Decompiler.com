package androidx.media3.exoplayer.dash.manifest;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.StreamKey;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.offline.FilterableManifest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@UnstableApi
public class DashManifest implements FilterableManifest<DashManifest> {

    /* renamed from: a  reason: collision with root package name */
    public final long f11131a;

    /* renamed from: b  reason: collision with root package name */
    public final long f11132b;

    /* renamed from: c  reason: collision with root package name */
    public final long f11133c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f11134d;

    /* renamed from: e  reason: collision with root package name */
    public final long f11135e;

    /* renamed from: f  reason: collision with root package name */
    public final long f11136f;

    /* renamed from: g  reason: collision with root package name */
    public final long f11137g;

    /* renamed from: h  reason: collision with root package name */
    public final long f11138h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public final UtcTimingElement f11139i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    public final ServiceDescriptionElement f11140j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    public final Uri f11141k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    public final ProgramInformation f11142l;

    /* renamed from: m  reason: collision with root package name */
    private final List<Period> f11143m;

    public DashManifest(long j2, long j3, long j4, boolean z, long j5, long j6, long j7, long j8, @Nullable ProgramInformation programInformation, @Nullable UtcTimingElement utcTimingElement, @Nullable ServiceDescriptionElement serviceDescriptionElement, @Nullable Uri uri, List<Period> list) {
        this.f11131a = j2;
        this.f11132b = j3;
        this.f11133c = j4;
        this.f11134d = z;
        this.f11135e = j5;
        this.f11136f = j6;
        this.f11137g = j7;
        this.f11138h = j8;
        this.f11142l = programInformation;
        this.f11139i = utcTimingElement;
        this.f11141k = uri;
        this.f11140j = serviceDescriptionElement;
        this.f11143m = list == null ? Collections.emptyList() : list;
    }

    private static ArrayList<AdaptationSet> c(List<AdaptationSet> list, LinkedList<StreamKey> linkedList) {
        StreamKey poll = linkedList.poll();
        int i2 = poll.s;
        ArrayList<AdaptationSet> arrayList = new ArrayList<>();
        do {
            int i3 = poll.X;
            AdaptationSet adaptationSet = list.get(i3);
            List<Representation> list2 = adaptationSet.f11120c;
            ArrayList arrayList2 = new ArrayList();
            do {
                arrayList2.add(list2.get(poll.Y));
                poll = linkedList.poll();
                if (!(poll.s == i2 && poll.X == i3)) {
                    arrayList.add(new AdaptationSet(adaptationSet.f11118a, adaptationSet.f11119b, arrayList2, adaptationSet.f11121d, adaptationSet.f11122e, adaptationSet.f11123f));
                }
                arrayList2.add(list2.get(poll.Y));
                poll = linkedList.poll();
                break;
            } while (poll.X == i3);
            arrayList.add(new AdaptationSet(adaptationSet.f11118a, adaptationSet.f11119b, arrayList2, adaptationSet.f11121d, adaptationSet.f11122e, adaptationSet.f11123f));
        } while (poll.s == i2);
        linkedList.addFirst(poll);
        return arrayList;
    }

    /* renamed from: b */
    public final DashManifest a(List<StreamKey> list) {
        long j2;
        LinkedList linkedList = new LinkedList(list);
        Collections.sort(linkedList);
        linkedList.add(new StreamKey(-1, -1, -1));
        ArrayList arrayList = new ArrayList();
        long j3 = 0;
        int i2 = 0;
        while (true) {
            int e2 = e();
            j2 = C.f9084b;
            if (i2 >= e2) {
                break;
            }
            if (((StreamKey) linkedList.peek()).s != i2) {
                long f2 = f(i2);
                if (f2 != C.f9084b) {
                    j3 += f2;
                }
            } else {
                Period d2 = d(i2);
                arrayList.add(new Period(d2.f11167a, d2.f11168b - j3, c(d2.f11169c, linkedList), d2.f11170d));
            }
            i2++;
        }
        long j4 = this.f11132b;
        if (j4 != C.f9084b) {
            j2 = j4 - j3;
        }
        return new DashManifest(this.f11131a, j2, this.f11133c, this.f11134d, this.f11135e, this.f11136f, this.f11137g, this.f11138h, this.f11142l, this.f11139i, this.f11140j, this.f11141k, arrayList);
    }

    public final Period d(int i2) {
        return this.f11143m.get(i2);
    }

    public final int e() {
        return this.f11143m.size();
    }

    public final long f(int i2) {
        long j2;
        if (i2 == this.f11143m.size() - 1) {
            j2 = this.f11132b;
            if (j2 == C.f9084b) {
                return C.f9084b;
            }
        } else {
            j2 = this.f11143m.get(i2 + 1).f11168b;
        }
        return j2 - this.f11143m.get(i2).f11168b;
    }

    public final long g(int i2) {
        return Util.I1(f(i2));
    }
}
