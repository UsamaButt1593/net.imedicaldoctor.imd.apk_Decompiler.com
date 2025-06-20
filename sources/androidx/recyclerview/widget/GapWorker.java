package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import androidx.core.os.TraceCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

final class GapWorker implements Runnable {
    static final ThreadLocal<GapWorker> X2 = new ThreadLocal<>();
    static Comparator<Task> Y2 = new Comparator<Task>() {
        /* renamed from: a */
        public int compare(Task task, Task task2) {
            RecyclerView recyclerView = task.f15354d;
            if ((recyclerView == null) != (task2.f15354d == null)) {
                return recyclerView == null ? 1 : -1;
            }
            boolean z = task.f15351a;
            if (z != task2.f15351a) {
                return z ? -1 : 1;
            }
            int i2 = task2.f15352b - task.f15352b;
            if (i2 != 0) {
                return i2;
            }
            int i3 = task.f15353c - task2.f15353c;
            if (i3 != 0) {
                return i3;
            }
            return 0;
        }
    };
    long X;
    long Y;
    private ArrayList<Task> Z = new ArrayList<>();
    ArrayList<RecyclerView> s = new ArrayList<>();

    @SuppressLint({"VisibleForTests"})
    static class LayoutPrefetchRegistryImpl implements RecyclerView.LayoutManager.LayoutPrefetchRegistry {

        /* renamed from: a  reason: collision with root package name */
        int f15347a;

        /* renamed from: b  reason: collision with root package name */
        int f15348b;

        /* renamed from: c  reason: collision with root package name */
        int[] f15349c;

        /* renamed from: d  reason: collision with root package name */
        int f15350d;

        LayoutPrefetchRegistryImpl() {
        }

        public void a(int i2, int i3) {
            if (i2 < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            } else if (i3 >= 0) {
                int i4 = this.f15350d;
                int i5 = i4 * 2;
                int[] iArr = this.f15349c;
                if (iArr == null) {
                    int[] iArr2 = new int[4];
                    this.f15349c = iArr2;
                    Arrays.fill(iArr2, -1);
                } else if (i5 >= iArr.length) {
                    int[] iArr3 = new int[(i4 * 4)];
                    this.f15349c = iArr3;
                    System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                }
                int[] iArr4 = this.f15349c;
                iArr4[i5] = i2;
                iArr4[i5 + 1] = i3;
                this.f15350d++;
            } else {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            int[] iArr = this.f15349c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f15350d = 0;
        }

        /* access modifiers changed from: package-private */
        public void c(RecyclerView recyclerView, boolean z) {
            this.f15350d = 0;
            int[] iArr = this.f15349c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.j3;
            if (recyclerView.i3 != null && layoutManager != null && layoutManager.M0()) {
                if (z) {
                    if (!recyclerView.a3.q()) {
                        layoutManager.x(recyclerView.i3.b(), this);
                    }
                } else if (!recyclerView.J0()) {
                    layoutManager.w(this.f15347a, this.f15348b, recyclerView.c4, this);
                }
                int i2 = this.f15350d;
                if (i2 > layoutManager.f15526m) {
                    layoutManager.f15526m = i2;
                    layoutManager.f15527n = z;
                    recyclerView.Y2.Q();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean d(int i2) {
            if (this.f15349c != null) {
                int i3 = this.f15350d * 2;
                for (int i4 = 0; i4 < i3; i4 += 2) {
                    if (this.f15349c[i4] == i2) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void e(int i2, int i3) {
            this.f15347a = i2;
            this.f15348b = i3;
        }
    }

    static class Task {

        /* renamed from: a  reason: collision with root package name */
        public boolean f15351a;

        /* renamed from: b  reason: collision with root package name */
        public int f15352b;

        /* renamed from: c  reason: collision with root package name */
        public int f15353c;

        /* renamed from: d  reason: collision with root package name */
        public RecyclerView f15354d;

        /* renamed from: e  reason: collision with root package name */
        public int f15355e;

        Task() {
        }

        public void a() {
            this.f15351a = false;
            this.f15352b = 0;
            this.f15353c = 0;
            this.f15354d = null;
            this.f15355e = 0;
        }
    }

    GapWorker() {
    }

    private void b() {
        Task task;
        int size = this.s.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            RecyclerView recyclerView = this.s.get(i3);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.b4.c(recyclerView, false);
                i2 += recyclerView.b4.f15350d;
            }
        }
        this.Z.ensureCapacity(i2);
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            RecyclerView recyclerView2 = this.s.get(i5);
            if (recyclerView2.getWindowVisibility() == 0) {
                LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView2.b4;
                int abs = Math.abs(layoutPrefetchRegistryImpl.f15347a) + Math.abs(layoutPrefetchRegistryImpl.f15348b);
                for (int i6 = 0; i6 < layoutPrefetchRegistryImpl.f15350d * 2; i6 += 2) {
                    if (i4 >= this.Z.size()) {
                        task = new Task();
                        this.Z.add(task);
                    } else {
                        task = this.Z.get(i4);
                    }
                    int[] iArr = layoutPrefetchRegistryImpl.f15349c;
                    int i7 = iArr[i6 + 1];
                    task.f15351a = i7 <= abs;
                    task.f15352b = abs;
                    task.f15353c = i7;
                    task.f15354d = recyclerView2;
                    task.f15355e = iArr[i6];
                    i4++;
                }
            }
        }
        Collections.sort(this.Z, Y2);
    }

    private void c(Task task, long j2) {
        RecyclerView.ViewHolder i2 = i(task.f15354d, task.f15355e, task.f15351a ? Long.MAX_VALUE : j2);
        if (i2 != null && i2.f15588b != null && i2.N() && !i2.O()) {
            h(i2.f15588b.get(), j2);
        }
    }

    private void d(long j2) {
        int i2 = 0;
        while (i2 < this.Z.size()) {
            Task task = this.Z.get(i2);
            if (task.f15354d != null) {
                c(task, j2);
                task.a();
                i2++;
            } else {
                return;
            }
        }
    }

    static boolean e(RecyclerView recyclerView, int i2) {
        int j2 = recyclerView.b3.j();
        for (int i3 = 0; i3 < j2; i3++) {
            RecyclerView.ViewHolder z0 = RecyclerView.z0(recyclerView.b3.i(i3));
            if (z0.f15589c == i2 && !z0.O()) {
                return true;
            }
        }
        return false;
    }

    private void h(@Nullable RecyclerView recyclerView, long j2) {
        if (recyclerView != null) {
            if (recyclerView.B3 && recyclerView.b3.j() != 0) {
                recyclerView.y1();
            }
            LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView.b4;
            layoutPrefetchRegistryImpl.c(recyclerView, true);
            if (layoutPrefetchRegistryImpl.f15350d != 0) {
                try {
                    TraceCompat.b("RV Nested Prefetch");
                    recyclerView.c4.k(recyclerView.i3);
                    for (int i2 = 0; i2 < layoutPrefetchRegistryImpl.f15350d * 2; i2 += 2) {
                        i(recyclerView, layoutPrefetchRegistryImpl.f15349c[i2], j2);
                    }
                } finally {
                    TraceCompat.d();
                }
            }
        }
    }

    private RecyclerView.ViewHolder i(RecyclerView recyclerView, int i2, long j2) {
        if (e(recyclerView, i2)) {
            return null;
        }
        RecyclerView.Recycler recycler = recyclerView.Y2;
        try {
            recyclerView.i1();
            RecyclerView.ViewHolder O = recycler.O(i2, false, j2);
            if (O != null) {
                if (!O.N() || O.O()) {
                    recycler.a(O, false);
                } else {
                    recycler.H(O.f15587a);
                }
            }
            return O;
        } finally {
            recyclerView.k1(false);
        }
    }

    public void a(RecyclerView recyclerView) {
        if (!RecyclerView.x4 || !this.s.contains(recyclerView)) {
            this.s.add(recyclerView);
            return;
        }
        throw new IllegalStateException("RecyclerView already present in worker list!");
    }

    /* access modifiers changed from: package-private */
    public void f(RecyclerView recyclerView, int i2, int i3) {
        if (recyclerView.isAttachedToWindow()) {
            if (RecyclerView.x4 && !this.s.contains(recyclerView)) {
                throw new IllegalStateException("attempting to post unregistered view!");
            } else if (this.X == 0) {
                this.X = recyclerView.getNanoTime();
                recyclerView.post(this);
            }
        }
        recyclerView.b4.e(i2, i3);
    }

    /* access modifiers changed from: package-private */
    public void g(long j2) {
        b();
        d(j2);
    }

    public void j(RecyclerView recyclerView) {
        boolean remove = this.s.remove(recyclerView);
        if (RecyclerView.x4 && !remove) {
            throw new IllegalStateException("RecyclerView removal failed!");
        }
    }

    public void run() {
        try {
            TraceCompat.b("RV Prefetch");
            if (!this.s.isEmpty()) {
                int size = this.s.size();
                long j2 = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    RecyclerView recyclerView = this.s.get(i2);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j2 = Math.max(recyclerView.getDrawingTime(), j2);
                    }
                }
                if (j2 != 0) {
                    g(TimeUnit.MILLISECONDS.toNanos(j2) + this.Y);
                    this.X = 0;
                    TraceCompat.d();
                }
            }
        } finally {
            this.X = 0;
            TraceCompat.d();
        }
    }
}
