package androidx.media3.exoplayer.dash;

import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.dash.manifest.BaseUrl;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

@UnstableApi
public final class BaseUrlExclusionList {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, Long> f10954a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<Integer, Long> f10955b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<List<Pair<String, Integer>>, BaseUrl> f10956c;

    /* renamed from: d  reason: collision with root package name */
    private final Random f10957d;

    public BaseUrlExclusionList() {
        this(new Random());
    }

    private static <T> void b(T t, long j2, Map<T, Long> map) {
        if (map.containsKey(t)) {
            j2 = Math.max(j2, ((Long) Util.o(map.get(t))).longValue());
        }
        map.put(t, Long.valueOf(j2));
    }

    private List<BaseUrl> c(List<BaseUrl> list) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        h(elapsedRealtime, this.f10954a);
        h(elapsedRealtime, this.f10955b);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            BaseUrl baseUrl = list.get(i2);
            if (!this.f10954a.containsKey(baseUrl.f11128b) && !this.f10955b.containsKey(Integer.valueOf(baseUrl.f11129c))) {
                arrayList.add(baseUrl);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static int d(BaseUrl baseUrl, BaseUrl baseUrl2) {
        int compare = Integer.compare(baseUrl.f11129c, baseUrl2.f11129c);
        return compare != 0 ? compare : baseUrl.f11128b.compareTo(baseUrl2.f11128b);
    }

    public static int f(List<BaseUrl> list) {
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < list.size(); i2++) {
            hashSet.add(Integer.valueOf(list.get(i2).f11129c));
        }
        return hashSet.size();
    }

    private static <T> void h(long j2, Map<T, Long> map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : map.entrySet()) {
            if (((Long) next.getValue()).longValue() <= j2) {
                arrayList.add(next.getKey());
            }
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            map.remove(arrayList.get(i2));
        }
    }

    private BaseUrl k(List<BaseUrl> list) {
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            i2 += list.get(i3).f11130d;
        }
        int nextInt = this.f10957d.nextInt(i2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            BaseUrl baseUrl = list.get(i5);
            i4 += baseUrl.f11130d;
            if (nextInt < i4) {
                return baseUrl;
            }
        }
        return (BaseUrl) Iterables.w(list);
    }

    public void e(BaseUrl baseUrl, long j2) {
        long elapsedRealtime = SystemClock.elapsedRealtime() + j2;
        b(baseUrl.f11128b, elapsedRealtime, this.f10954a);
        int i2 = baseUrl.f11129c;
        if (i2 != Integer.MIN_VALUE) {
            b(Integer.valueOf(i2), elapsedRealtime, this.f10955b);
        }
    }

    public int g(List<BaseUrl> list) {
        HashSet hashSet = new HashSet();
        List<BaseUrl> c2 = c(list);
        for (int i2 = 0; i2 < c2.size(); i2++) {
            hashSet.add(Integer.valueOf(c2.get(i2).f11129c));
        }
        return hashSet.size();
    }

    public void i() {
        this.f10954a.clear();
        this.f10955b.clear();
        this.f10956c.clear();
    }

    /* JADX WARNING: type inference failed for: r8v0, types: [java.util.List<androidx.media3.exoplayer.dash.manifest.BaseUrl>, java.util.List] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.media3.exoplayer.dash.manifest.BaseUrl j(java.util.List<androidx.media3.exoplayer.dash.manifest.BaseUrl> r8) {
        /*
            r7 = this;
            java.util.List r8 = r7.c(r8)
            int r0 = r8.size()
            r1 = 2
            if (r0 >= r1) goto L_0x0013
            r0 = 0
            java.lang.Object r8 = com.google.common.collect.Iterables.v(r8, r0)
        L_0x0010:
            androidx.media3.exoplayer.dash.manifest.BaseUrl r8 = (androidx.media3.exoplayer.dash.manifest.BaseUrl) r8
            return r8
        L_0x0013:
            androidx.media3.exoplayer.dash.a r0 = new androidx.media3.exoplayer.dash.a
            r0.<init>()
            java.util.Collections.sort(r8, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            java.lang.Object r2 = r8.get(r1)
            androidx.media3.exoplayer.dash.manifest.BaseUrl r2 = (androidx.media3.exoplayer.dash.manifest.BaseUrl) r2
            int r2 = r2.f11129c
            r3 = 0
        L_0x002a:
            int r4 = r8.size()
            if (r3 >= r4) goto L_0x0059
            java.lang.Object r4 = r8.get(r3)
            androidx.media3.exoplayer.dash.manifest.BaseUrl r4 = (androidx.media3.exoplayer.dash.manifest.BaseUrl) r4
            int r5 = r4.f11129c
            if (r2 == r5) goto L_0x0046
            int r2 = r0.size()
            r3 = 1
            if (r2 != r3) goto L_0x0059
            java.lang.Object r8 = r8.get(r1)
            goto L_0x0010
        L_0x0046:
            android.util.Pair r5 = new android.util.Pair
            java.lang.String r6 = r4.f11128b
            int r4 = r4.f11130d
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r5.<init>(r6, r4)
            r0.add(r5)
            int r3 = r3 + 1
            goto L_0x002a
        L_0x0059:
            java.util.Map<java.util.List<android.util.Pair<java.lang.String, java.lang.Integer>>, androidx.media3.exoplayer.dash.manifest.BaseUrl> r2 = r7.f10956c
            java.lang.Object r2 = r2.get(r0)
            androidx.media3.exoplayer.dash.manifest.BaseUrl r2 = (androidx.media3.exoplayer.dash.manifest.BaseUrl) r2
            if (r2 != 0) goto L_0x0074
            int r2 = r0.size()
            java.util.List r8 = r8.subList(r1, r2)
            androidx.media3.exoplayer.dash.manifest.BaseUrl r2 = r7.k(r8)
            java.util.Map<java.util.List<android.util.Pair<java.lang.String, java.lang.Integer>>, androidx.media3.exoplayer.dash.manifest.BaseUrl> r8 = r7.f10956c
            r8.put(r0, r2)
        L_0x0074:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.dash.BaseUrlExclusionList.j(java.util.List):androidx.media3.exoplayer.dash.manifest.BaseUrl");
    }

    @VisibleForTesting
    BaseUrlExclusionList(Random random) {
        this.f10956c = new HashMap();
        this.f10957d = random;
        this.f10954a = new HashMap();
        this.f10955b = new HashMap();
    }
}
