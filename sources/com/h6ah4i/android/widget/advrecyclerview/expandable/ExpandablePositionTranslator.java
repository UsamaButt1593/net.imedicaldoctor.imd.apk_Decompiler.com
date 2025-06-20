package com.h6ah4i.android.widget.advrecyclerview.expandable;

import androidx.core.app.FrameMetricsAggregator;
import androidx.core.view.InputDeviceCompat;
import com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager;
import java.util.Arrays;

class ExpandablePositionTranslator {

    /* renamed from: i  reason: collision with root package name */
    private static final long f25445i = 2147483648L;

    /* renamed from: j  reason: collision with root package name */
    private static final long f25446j = 2147483647L;

    /* renamed from: k  reason: collision with root package name */
    private static final long f25447k = 4294967295L;

    /* renamed from: l  reason: collision with root package name */
    private static final long f25448l = -4294967296L;

    /* renamed from: a  reason: collision with root package name */
    private final int f25449a = 256;

    /* renamed from: b  reason: collision with root package name */
    private long[] f25450b;

    /* renamed from: c  reason: collision with root package name */
    private int[] f25451c;

    /* renamed from: d  reason: collision with root package name */
    private int f25452d;

    /* renamed from: e  reason: collision with root package name */
    private int f25453e;

    /* renamed from: f  reason: collision with root package name */
    private int f25454f;

    /* renamed from: g  reason: collision with root package name */
    private int f25455g = -1;

    /* renamed from: h  reason: collision with root package name */
    private ExpandableItemAdapter f25456h;

    private static int a(long[] jArr, int i2, int i3) {
        int i4 = 0;
        if (i2 <= 0) {
            return 0;
        }
        int i5 = (int) (jArr[0] >>> 32);
        int i6 = (int) (jArr[i2] >>> 32);
        if (i3 <= i5) {
            return 0;
        }
        if (i3 >= i6) {
            return i2;
        }
        int i7 = 0;
        while (i4 < i2) {
            int i8 = (i4 + i2) >>> 1;
            if (((int) (jArr[i8] >>> 32)) < i3) {
                i7 = i4;
                i4 = i8 + 1;
            } else {
                i2 = i8;
            }
        }
        return i7;
    }

    private void d(int i2, boolean z) {
        int i3 = (i2 + FrameMetricsAggregator.u) & InputDeviceCompat.u;
        long[] jArr = this.f25450b;
        int[] iArr = this.f25451c;
        long[] jArr2 = (jArr == null || jArr.length < i2) ? new long[i3] : jArr;
        int[] iArr2 = (iArr == null || iArr.length < i2) ? new int[i3] : iArr;
        if (z) {
            if (!(jArr == null || jArr == jArr2)) {
                System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
            }
            if (!(iArr == null || iArr == iArr2)) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            }
        }
        this.f25450b = jArr2;
        this.f25451c = iArr2;
    }

    public void b(ExpandableItemAdapter expandableItemAdapter) {
        int groupCount = expandableItemAdapter.getGroupCount();
        d(groupCount, false);
        long[] jArr = this.f25450b;
        int[] iArr = this.f25451c;
        for (int i2 = 0; i2 < groupCount; i2++) {
            long groupId = expandableItemAdapter.getGroupId(i2);
            jArr[i2] = (((long) i2) << 32) | ((long) expandableItemAdapter.m(i2));
            iArr[i2] = (int) (groupId & 4294967295L);
        }
        this.f25456h = expandableItemAdapter;
        this.f25452d = groupCount;
        this.f25453e = 0;
        this.f25454f = 0;
        this.f25455g = Math.max(0, groupCount - 1);
    }

    public boolean c(int i2) {
        long[] jArr = this.f25450b;
        long j2 = jArr[i2];
        if ((f25445i & j2) == 0) {
            return false;
        }
        jArr[i2] = j2 & -2147483649L;
        this.f25453e--;
        this.f25454f -= (int) (f25446j & j2);
        this.f25455g = Math.min(this.f25455g, i2);
        return true;
    }

    public boolean e(int i2) {
        long[] jArr = this.f25450b;
        long j2 = jArr[i2];
        if ((j2 & f25445i) != 0) {
            return false;
        }
        jArr[i2] = j2 | f25445i;
        this.f25453e++;
        this.f25454f += (int) (f25446j & j2);
        this.f25455g = Math.min(this.f25455g, i2);
        return true;
    }

    public int f(int i2) {
        return (int) (this.f25450b[i2] & f25446j);
    }

    public long g(int i2) {
        long j2 = -1;
        if (i2 == -1) {
            return -1;
        }
        int i3 = this.f25452d;
        int a2 = a(this.f25450b, this.f25455g, i2);
        int i4 = this.f25455g;
        int i5 = a2 == 0 ? 0 : (int) (this.f25450b[a2] >>> 32);
        while (true) {
            if (a2 >= i3) {
                a2 = i4;
                break;
            }
            long[] jArr = this.f25450b;
            long j3 = jArr[a2];
            jArr[a2] = (((long) i5) << 32) | (4294967295L & j3);
            if (i5 >= i2) {
                j2 = ExpandableAdapterHelper.g(a2);
                break;
            }
            int i6 = i5 + 1;
            if ((f25445i & j3) != 0) {
                int i7 = (int) (j3 & f25446j);
                if (i7 > 0 && (i6 + i7) - 1 >= i2) {
                    j2 = ExpandableAdapterHelper.f(a2, i2 - i6);
                    break;
                }
                i6 += i7;
            }
            i4 = a2;
            a2++;
        }
        this.f25455g = Math.max(this.f25455g, a2);
        return j2;
    }

    public int h(long j2) {
        int i2 = -1;
        if (j2 == -1) {
            return -1;
        }
        int h2 = ExpandableAdapterHelper.h(j2);
        int e2 = ExpandableAdapterHelper.e(j2);
        int i3 = this.f25452d;
        if (h2 >= 0 && h2 < i3) {
            if (e2 != -1 && !p(h2)) {
                return -1;
            }
            int max = Math.max(0, Math.min(h2, this.f25455g));
            int i4 = this.f25455g;
            int i5 = (int) (this.f25450b[max] >>> 32);
            while (true) {
                if (max >= i3) {
                    max = i4;
                    break;
                }
                long[] jArr = this.f25450b;
                long j3 = jArr[max];
                jArr[max] = (((long) i5) << 32) | (4294967295L & j3);
                int i6 = (int) (f25446j & j3);
                if (max != h2) {
                    i5++;
                    if ((j3 & f25445i) != 0) {
                        i5 += i6;
                    }
                    i4 = max;
                    max++;
                } else if (e2 == -1) {
                    i2 = i5;
                } else if (e2 < i6) {
                    i2 = i5 + 1 + e2;
                }
            }
            this.f25455g = Math.max(this.f25455g, max);
        }
        return i2;
    }

    public int i() {
        return this.f25452d + this.f25454f;
    }

    public int[] j() {
        int[] iArr = new int[this.f25453e];
        int i2 = 0;
        for (int i3 = 0; i3 < this.f25452d; i3++) {
            if ((this.f25450b[i3] & f25445i) != 0) {
                iArr[i2] = this.f25451c[i3];
                i2++;
            }
        }
        if (i2 == this.f25453e) {
            Arrays.sort(iArr);
            return iArr;
        }
        throw new IllegalStateException("may be a bug  (index = " + i2 + ", mExpandedGroupCount = " + this.f25453e + ")");
    }

    public int k(int i2) {
        if (p(i2)) {
            return f(i2);
        }
        return 0;
    }

    public void l(int i2, int i3) {
        m(i2, i3, 1);
    }

    public void m(int i2, int i3, int i4) {
        long[] jArr = this.f25450b;
        long j2 = jArr[i2];
        int i5 = (int) (f25446j & j2);
        if (i3 < 0 || i3 > i5) {
            throw new IllegalStateException("Invalid child position insertChildItems(groupPosition = " + i2 + ", childPositionStart = " + i3 + ", count = " + i4 + ")");
        }
        if ((f25445i & j2) != 0) {
            this.f25454f += i4;
        }
        jArr[i2] = ((long) (i5 + i4)) | (j2 & -2147483648L);
        this.f25455g = Math.min(this.f25455g, i2);
    }

    public int n(int i2) {
        return o(i2, 1);
    }

    public int o(int i2, int i3) {
        if (i3 <= 0) {
            return 0;
        }
        d(this.f25452d + i3, true);
        ExpandableItemAdapter expandableItemAdapter = this.f25456h;
        long[] jArr = this.f25450b;
        int[] iArr = this.f25451c;
        int i4 = i2 - 1;
        int i5 = i4 + i3;
        for (int i6 = (this.f25452d - 1) + i3; i6 > i5; i6--) {
            int i7 = i6 - i3;
            jArr[i6] = jArr[i7];
            iArr[i6] = iArr[i7];
        }
        int i8 = i2 + i3;
        while (i2 < i8) {
            long groupId = expandableItemAdapter.getGroupId(i2);
            jArr[i2] = (((long) i2) << 32) | ((long) expandableItemAdapter.m(i2));
            iArr[i2] = (int) (groupId & 4294967295L);
            i2++;
        }
        int i9 = this.f25452d + i3;
        this.f25452d = i9;
        if (i9 == 0) {
            i4 = -1;
        }
        this.f25455g = Math.min(this.f25455g, i4);
        return i3;
    }

    public boolean p(int i2) {
        return (this.f25450b[i2] & f25445i) != 0;
    }

    public void q(int i2, int i3, int i4, int i5) {
        if (i2 != i4) {
            long[] jArr = this.f25450b;
            long j2 = jArr[i2];
            int i6 = (int) (j2 & f25446j);
            int i7 = (int) (f25446j & jArr[i4]);
            if (i6 != 0) {
                jArr[i2] = (j2 & -2147483648L) | ((long) (i6 - 1));
                long j3 = (jArr[i4] & -2147483648L) | ((long) (i7 + 1));
                jArr[i4] = j3;
                if ((jArr[i2] & f25445i) != 0) {
                    this.f25454f--;
                }
                if ((j3 & f25445i) != 0) {
                    this.f25454f++;
                }
                int min = Math.min(i2, i4);
                this.f25455g = min > 0 ? Math.min(this.f25455g, min - 1) : -1;
                return;
            }
            throw new IllegalStateException("moveChildItem(fromGroupPosition = " + i2 + ", fromChildPosition = " + i3 + ", toGroupPosition = " + i4 + ", toChildPosition = " + i5 + ")  --- may be a bug.");
        }
    }

    public void r(int i2, int i3) {
        if (i2 != i3) {
            long j2 = this.f25450b[i2];
            int i4 = this.f25451c[i2];
            int i5 = i2;
            if (i3 < i2) {
                while (i5 > i3) {
                    long[] jArr = this.f25450b;
                    int i6 = i5 - 1;
                    jArr[i5] = jArr[i6];
                    int[] iArr = this.f25451c;
                    iArr[i5] = iArr[i6];
                    i5--;
                }
            } else {
                while (i5 < i3) {
                    long[] jArr2 = this.f25450b;
                    int i7 = i5 + 1;
                    jArr2[i5] = jArr2[i7];
                    int[] iArr2 = this.f25451c;
                    iArr2[i5] = iArr2[i7];
                    i5 = i7;
                }
            }
            this.f25450b[i3] = j2;
            this.f25451c[i3] = i4;
            int min = Math.min(i2, i3);
            this.f25455g = min > 0 ? Math.min(this.f25455g, min - 1) : -1;
        }
    }

    public void s(int i2, int i3) {
        t(i2, i3, 1);
    }

    public void t(int i2, int i3, int i4) {
        long[] jArr = this.f25450b;
        long j2 = jArr[i2];
        int i5 = (int) (f25446j & j2);
        if (i3 < 0 || i3 + i4 > i5) {
            throw new IllegalStateException("Invalid child position removeChildItems(groupPosition = " + i2 + ", childPosition = " + i3 + ", count = " + i4 + ")");
        }
        if ((f25445i & j2) != 0) {
            this.f25454f -= i4;
        }
        jArr[i2] = ((long) (i5 - i4)) | (j2 & -2147483648L);
        this.f25455g = Math.min(this.f25455g, i2 - 1);
    }

    public int u(int i2) {
        return v(i2, 1);
    }

    public int v(int i2, int i3) {
        int i4;
        if (i3 <= 0) {
            return 0;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < i3; i6++) {
            long j2 = this.f25450b[i2 + i6];
            if ((f25445i & j2) != 0) {
                int i7 = (int) (j2 & f25446j);
                i5 += i7;
                this.f25454f -= i7;
                this.f25453e--;
            }
        }
        int i8 = i5 + i3;
        this.f25452d -= i3;
        int i9 = i2;
        while (true) {
            i4 = this.f25452d;
            if (i9 >= i4) {
                break;
            }
            long[] jArr = this.f25450b;
            int i10 = i9 + i3;
            jArr[i9] = jArr[i10];
            int[] iArr = this.f25451c;
            iArr[i9] = iArr[i10];
            i9++;
        }
        this.f25455g = Math.min(this.f25455g, i4 == 0 ? -1 : i2 - 1);
        return i8;
    }

    public void w(int[] iArr, ExpandableItemAdapter expandableItemAdapter, RecyclerViewExpandableItemManager.OnGroupExpandListener onGroupExpandListener, RecyclerViewExpandableItemManager.OnGroupCollapseListener onGroupCollapseListener) {
        int i2;
        int i3;
        int[] iArr2 = iArr;
        ExpandableItemAdapter expandableItemAdapter2 = expandableItemAdapter;
        RecyclerViewExpandableItemManager.OnGroupExpandListener onGroupExpandListener2 = onGroupExpandListener;
        RecyclerViewExpandableItemManager.OnGroupCollapseListener onGroupCollapseListener2 = onGroupCollapseListener;
        if (iArr2 != null && iArr2.length != 0 && this.f25450b != null) {
            int i4 = this.f25452d;
            long[] jArr = new long[i4];
            for (int i5 = 0; i5 < this.f25452d; i5++) {
                jArr[i5] = (((long) this.f25451c[i5]) << 32) | ((long) i5);
            }
            Arrays.sort(jArr);
            int i6 = 0;
            int i7 = 0;
            while (i6 < iArr2.length) {
                int i8 = iArr2[i6];
                int i9 = i7;
                while (true) {
                    if (i7 >= i4) {
                        i2 = i6;
                        i3 = i9;
                        break;
                    }
                    long j2 = jArr[i7];
                    i2 = i6;
                    int i10 = (int) (j2 >> 32);
                    i3 = i9;
                    int i11 = (int) (j2 & f25446j);
                    if (i10 >= i8) {
                        if (i10 != i8) {
                            break;
                        }
                        int i12 = i7 + 1;
                        if ((expandableItemAdapter2 == null || expandableItemAdapter2.u(i11, false)) && e(i11) && onGroupExpandListener2 != null) {
                            onGroupExpandListener2.a(i11, false);
                        }
                        i9 = i12;
                    } else {
                        if ((expandableItemAdapter2 == null || expandableItemAdapter2.n(i11, false)) && c(i11) && onGroupCollapseListener2 != null) {
                            onGroupCollapseListener2.a(i11, false);
                        }
                        i9 = i7;
                    }
                    i7++;
                    i6 = i2;
                }
                i6 = i2 + 1;
                i7 = i3;
            }
            if (expandableItemAdapter2 != null || onGroupCollapseListener2 != null) {
                while (i7 < i4) {
                    int i13 = (int) (jArr[i7] & f25446j);
                    if ((expandableItemAdapter2 == null || expandableItemAdapter2.n(i13, false)) && c(i13) && onGroupCollapseListener2 != null) {
                        onGroupCollapseListener2.a(i13, false);
                    }
                    i7++;
                }
            }
        }
    }
}
