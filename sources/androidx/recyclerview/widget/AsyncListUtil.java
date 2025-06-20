package androidx.recyclerview.widget;

import android.util.Log;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.WorkerThread;
import androidx.recyclerview.widget.ThreadUtil;
import androidx.recyclerview.widget.TileList;

public class AsyncListUtil<T> {
    static final String s = "AsyncListUtil";
    static final boolean t = false;

    /* renamed from: a  reason: collision with root package name */
    final Class<T> f15225a;

    /* renamed from: b  reason: collision with root package name */
    final int f15226b;

    /* renamed from: c  reason: collision with root package name */
    final DataCallback<T> f15227c;

    /* renamed from: d  reason: collision with root package name */
    final ViewCallback f15228d;

    /* renamed from: e  reason: collision with root package name */
    final TileList<T> f15229e;

    /* renamed from: f  reason: collision with root package name */
    final ThreadUtil.MainThreadCallback<T> f15230f;

    /* renamed from: g  reason: collision with root package name */
    final ThreadUtil.BackgroundCallback<T> f15231g;

    /* renamed from: h  reason: collision with root package name */
    final int[] f15232h = new int[2];

    /* renamed from: i  reason: collision with root package name */
    final int[] f15233i = new int[2];

    /* renamed from: j  reason: collision with root package name */
    final int[] f15234j = new int[2];

    /* renamed from: k  reason: collision with root package name */
    boolean f15235k;

    /* renamed from: l  reason: collision with root package name */
    private int f15236l = 0;

    /* renamed from: m  reason: collision with root package name */
    int f15237m = 0;

    /* renamed from: n  reason: collision with root package name */
    int f15238n = 0;
    int o = 0;
    final SparseIntArray p = new SparseIntArray();
    private final ThreadUtil.MainThreadCallback<T> q;
    private final ThreadUtil.BackgroundCallback<T> r;

    public static abstract class DataCallback<T> {
        @WorkerThread
        public abstract void a(@NonNull T[] tArr, int i2, int i3);

        @WorkerThread
        public int b() {
            return 10;
        }

        @WorkerThread
        public void c(@NonNull T[] tArr, int i2) {
        }

        @WorkerThread
        public abstract int d();
    }

    public static abstract class ViewCallback {

        /* renamed from: a  reason: collision with root package name */
        public static final int f15247a = 0;

        /* renamed from: b  reason: collision with root package name */
        public static final int f15248b = 1;

        /* renamed from: c  reason: collision with root package name */
        public static final int f15249c = 2;

        @UiThread
        public void a(@NonNull int[] iArr, @NonNull int[] iArr2, int i2) {
            int i3 = iArr[1];
            int i4 = iArr[0];
            int i5 = (i3 - i4) + 1;
            int i6 = i5 / 2;
            iArr2[0] = i4 - (i2 == 1 ? i5 : i6);
            if (i2 != 2) {
                i5 = i6;
            }
            iArr2[1] = i3 + i5;
        }

        @UiThread
        public abstract void b(@NonNull int[] iArr);

        @UiThread
        public abstract void c();

        @UiThread
        public abstract void d(int i2);
    }

    public AsyncListUtil(@NonNull Class<T> cls, int i2, @NonNull DataCallback<T> dataCallback, @NonNull ViewCallback viewCallback) {
        AnonymousClass1 r0 = new ThreadUtil.MainThreadCallback<T>() {
            private boolean d(int i2) {
                return i2 == AsyncListUtil.this.o;
            }

            private void e() {
                for (int i2 = 0; i2 < AsyncListUtil.this.f15229e.f(); i2++) {
                    AsyncListUtil asyncListUtil = AsyncListUtil.this;
                    asyncListUtil.f15231g.b(asyncListUtil.f15229e.c(i2));
                }
                AsyncListUtil.this.f15229e.b();
            }

            public void a(int i2, TileList.Tile<T> tile) {
                if (!d(i2)) {
                    AsyncListUtil.this.f15231g.b(tile);
                    return;
                }
                TileList.Tile<T> a2 = AsyncListUtil.this.f15229e.a(tile);
                if (a2 != null) {
                    Log.e(AsyncListUtil.s, "duplicate tile @" + a2.f15659b);
                    AsyncListUtil.this.f15231g.b(a2);
                }
                int i3 = tile.f15659b + tile.f15660c;
                int i4 = 0;
                while (i4 < AsyncListUtil.this.p.size()) {
                    int keyAt = AsyncListUtil.this.p.keyAt(i4);
                    if (tile.f15659b > keyAt || keyAt >= i3) {
                        i4++;
                    } else {
                        AsyncListUtil.this.p.removeAt(i4);
                        AsyncListUtil.this.f15228d.d(keyAt);
                    }
                }
            }

            public void b(int i2, int i3) {
                if (d(i2)) {
                    TileList.Tile<T> e2 = AsyncListUtil.this.f15229e.e(i3);
                    if (e2 == null) {
                        Log.e(AsyncListUtil.s, "tile not found @" + i3);
                        return;
                    }
                    AsyncListUtil.this.f15231g.b(e2);
                }
            }

            public void c(int i2, int i3) {
                if (d(i2)) {
                    AsyncListUtil asyncListUtil = AsyncListUtil.this;
                    asyncListUtil.f15237m = i3;
                    asyncListUtil.f15228d.c();
                    AsyncListUtil asyncListUtil2 = AsyncListUtil.this;
                    asyncListUtil2.f15238n = asyncListUtil2.o;
                    e();
                    AsyncListUtil asyncListUtil3 = AsyncListUtil.this;
                    asyncListUtil3.f15235k = false;
                    asyncListUtil3.g();
                }
            }
        };
        this.q = r0;
        AnonymousClass2 r1 = new ThreadUtil.BackgroundCallback<T>() {

            /* renamed from: a  reason: collision with root package name */
            private TileList.Tile<T> f15240a;

            /* renamed from: b  reason: collision with root package name */
            final SparseBooleanArray f15241b = new SparseBooleanArray();

            /* renamed from: c  reason: collision with root package name */
            private int f15242c;

            /* renamed from: d  reason: collision with root package name */
            private int f15243d;

            /* renamed from: e  reason: collision with root package name */
            private int f15244e;

            /* renamed from: f  reason: collision with root package name */
            private int f15245f;

            private TileList.Tile<T> e() {
                TileList.Tile<T> tile = this.f15240a;
                if (tile != null) {
                    this.f15240a = tile.f15661d;
                    return tile;
                }
                AsyncListUtil asyncListUtil = AsyncListUtil.this;
                return new TileList.Tile<>(asyncListUtil.f15225a, asyncListUtil.f15226b);
            }

            private void f(TileList.Tile<T> tile) {
                this.f15241b.put(tile.f15659b, true);
                AsyncListUtil.this.f15230f.a(this.f15242c, tile);
            }

            private void g(int i2) {
                int b2 = AsyncListUtil.this.f15227c.b();
                while (this.f15241b.size() >= b2) {
                    int keyAt = this.f15241b.keyAt(0);
                    SparseBooleanArray sparseBooleanArray = this.f15241b;
                    int keyAt2 = sparseBooleanArray.keyAt(sparseBooleanArray.size() - 1);
                    int i3 = this.f15244e - keyAt;
                    int i4 = keyAt2 - this.f15245f;
                    if (i3 > 0 && (i3 >= i4 || i2 == 2)) {
                        k(keyAt);
                    } else if (i4 <= 0) {
                        return;
                    } else {
                        if (i3 < i4 || i2 == 1) {
                            k(keyAt2);
                        } else {
                            return;
                        }
                    }
                }
            }

            private int h(int i2) {
                return i2 - (i2 % AsyncListUtil.this.f15226b);
            }

            private boolean i(int i2) {
                return this.f15241b.get(i2);
            }

            private void j(String str, Object... objArr) {
                Log.d(AsyncListUtil.s, "[BKGR] " + String.format(str, objArr));
            }

            private void k(int i2) {
                this.f15241b.delete(i2);
                AsyncListUtil.this.f15230f.b(this.f15242c, i2);
            }

            private void l(int i2, int i3, int i4, boolean z) {
                int i5 = i2;
                while (i5 <= i3) {
                    AsyncListUtil.this.f15231g.c(z ? (i3 + i2) - i5 : i5, i4);
                    i5 += AsyncListUtil.this.f15226b;
                }
            }

            public void a(int i2, int i3, int i4, int i5, int i6) {
                if (i2 <= i3) {
                    int h2 = h(i2);
                    int h3 = h(i3);
                    this.f15244e = h(i4);
                    int h4 = h(i5);
                    this.f15245f = h4;
                    if (i6 == 1) {
                        l(this.f15244e, h3, i6, true);
                        l(h3 + AsyncListUtil.this.f15226b, this.f15245f, i6, false);
                        return;
                    }
                    l(h2, h4, i6, false);
                    l(this.f15244e, h2 - AsyncListUtil.this.f15226b, i6, true);
                }
            }

            public void b(TileList.Tile<T> tile) {
                AsyncListUtil.this.f15227c.c(tile.f15658a, tile.f15660c);
                tile.f15661d = this.f15240a;
                this.f15240a = tile;
            }

            public void c(int i2, int i3) {
                if (!i(i2)) {
                    TileList.Tile e2 = e();
                    e2.f15659b = i2;
                    int min = Math.min(AsyncListUtil.this.f15226b, this.f15243d - i2);
                    e2.f15660c = min;
                    AsyncListUtil.this.f15227c.a(e2.f15658a, e2.f15659b, min);
                    g(i3);
                    f(e2);
                }
            }

            public void d(int i2) {
                this.f15242c = i2;
                this.f15241b.clear();
                int d2 = AsyncListUtil.this.f15227c.d();
                this.f15243d = d2;
                AsyncListUtil.this.f15230f.c(this.f15242c, d2);
            }
        };
        this.r = r1;
        this.f15225a = cls;
        this.f15226b = i2;
        this.f15227c = dataCallback;
        this.f15228d = viewCallback;
        this.f15229e = new TileList<>(i2);
        MessageThreadUtil messageThreadUtil = new MessageThreadUtil();
        this.f15230f = messageThreadUtil.b(r0);
        this.f15231g = messageThreadUtil.a(r1);
        f();
    }

    private boolean c() {
        return this.o != this.f15238n;
    }

    @Nullable
    public T a(int i2) {
        if (i2 < 0 || i2 >= this.f15237m) {
            throw new IndexOutOfBoundsException(i2 + " is not within 0 and " + this.f15237m);
        }
        T d2 = this.f15229e.d(i2);
        if (d2 == null && !c()) {
            this.p.put(i2, 0);
        }
        return d2;
    }

    public int b() {
        return this.f15237m;
    }

    /* access modifiers changed from: package-private */
    public void d(String str, Object... objArr) {
        Log.d(s, "[MAIN] " + String.format(str, objArr));
    }

    public void e() {
        if (!c()) {
            g();
            this.f15235k = true;
        }
    }

    public void f() {
        this.p.clear();
        ThreadUtil.BackgroundCallback<T> backgroundCallback = this.f15231g;
        int i2 = this.o + 1;
        this.o = i2;
        backgroundCallback.d(i2);
    }

    /* access modifiers changed from: package-private */
    public void g() {
        int i2;
        this.f15228d.b(this.f15232h);
        int[] iArr = this.f15232h;
        int i3 = iArr[0];
        int i4 = iArr[1];
        if (i3 <= i4 && i3 >= 0 && i4 < this.f15237m) {
            if (this.f15235k) {
                int[] iArr2 = this.f15233i;
                if (i3 <= iArr2[1] && (i2 = iArr2[0]) <= i4) {
                    if (i3 < i2) {
                        this.f15236l = 1;
                    } else if (i3 > i2) {
                        this.f15236l = 2;
                    }
                    int[] iArr3 = this.f15233i;
                    iArr3[0] = i3;
                    iArr3[1] = i4;
                    this.f15228d.a(iArr, this.f15234j, this.f15236l);
                    int[] iArr4 = this.f15234j;
                    iArr4[0] = Math.min(this.f15232h[0], Math.max(iArr4[0], 0));
                    int[] iArr5 = this.f15234j;
                    iArr5[1] = Math.max(this.f15232h[1], Math.min(iArr5[1], this.f15237m - 1));
                    ThreadUtil.BackgroundCallback<T> backgroundCallback = this.f15231g;
                    int[] iArr6 = this.f15232h;
                    int i5 = iArr6[0];
                    int i6 = iArr6[1];
                    int[] iArr7 = this.f15234j;
                    backgroundCallback.a(i5, i6, iArr7[0], iArr7[1], this.f15236l);
                }
            }
            this.f15236l = 0;
            int[] iArr32 = this.f15233i;
            iArr32[0] = i3;
            iArr32[1] = i4;
            this.f15228d.a(iArr, this.f15234j, this.f15236l);
            int[] iArr42 = this.f15234j;
            iArr42[0] = Math.min(this.f15232h[0], Math.max(iArr42[0], 0));
            int[] iArr52 = this.f15234j;
            iArr52[1] = Math.max(this.f15232h[1], Math.min(iArr52[1], this.f15237m - 1));
            ThreadUtil.BackgroundCallback<T> backgroundCallback2 = this.f15231g;
            int[] iArr62 = this.f15232h;
            int i52 = iArr62[0];
            int i62 = iArr62[1];
            int[] iArr72 = this.f15234j;
            backgroundCallback2.a(i52, i62, iArr72[0], iArr72[1], this.f15236l);
        }
    }
}
