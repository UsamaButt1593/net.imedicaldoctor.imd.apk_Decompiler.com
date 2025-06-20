package androidx.profileinstaller;

import androidx.annotation.NonNull;
import java.util.TreeMap;

class DexProfileData {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    final String f15073a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    final String f15074b;

    /* renamed from: c  reason: collision with root package name */
    final long f15075c;

    /* renamed from: d  reason: collision with root package name */
    long f15076d;

    /* renamed from: e  reason: collision with root package name */
    int f15077e;

    /* renamed from: f  reason: collision with root package name */
    final int f15078f;

    /* renamed from: g  reason: collision with root package name */
    final int f15079g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    int[] f15080h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    final TreeMap<Integer, Integer> f15081i;

    DexProfileData(@NonNull String str, @NonNull String str2, long j2, long j3, int i2, int i3, int i4, @NonNull int[] iArr, @NonNull TreeMap<Integer, Integer> treeMap) {
        this.f15073a = str;
        this.f15074b = str2;
        this.f15075c = j2;
        this.f15076d = j3;
        this.f15077e = i2;
        this.f15078f = i3;
        this.f15079g = i4;
        this.f15080h = iArr;
        this.f15081i = treeMap;
    }
}
