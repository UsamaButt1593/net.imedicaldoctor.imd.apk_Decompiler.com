package androidx.recyclerview.widget;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class DiffUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final Comparator<Diagonal> f15293a = new Comparator<Diagonal>() {
        /* renamed from: a */
        public int compare(Diagonal diagonal, Diagonal diagonal2) {
            return diagonal.f15296a - diagonal2.f15296a;
        }
    };

    public static abstract class Callback {
        public abstract boolean a(int i2, int i3);

        public abstract boolean b(int i2, int i3);

        @Nullable
        public Object c(int i2, int i3) {
            return null;
        }

        public abstract int d();

        public abstract int e();
    }

    static class CenteredArray {

        /* renamed from: a  reason: collision with root package name */
        private final int[] f15294a;

        /* renamed from: b  reason: collision with root package name */
        private final int f15295b;

        CenteredArray(int i2) {
            int[] iArr = new int[i2];
            this.f15294a = iArr;
            this.f15295b = iArr.length / 2;
        }

        /* access modifiers changed from: package-private */
        public int[] a() {
            return this.f15294a;
        }

        public void b(int i2) {
            Arrays.fill(this.f15294a, i2);
        }

        /* access modifiers changed from: package-private */
        public int c(int i2) {
            return this.f15294a[i2 + this.f15295b];
        }

        /* access modifiers changed from: package-private */
        public void d(int i2, int i3) {
            this.f15294a[i2 + this.f15295b] = i3;
        }
    }

    static class Diagonal {

        /* renamed from: a  reason: collision with root package name */
        public final int f15296a;

        /* renamed from: b  reason: collision with root package name */
        public final int f15297b;

        /* renamed from: c  reason: collision with root package name */
        public final int f15298c;

        Diagonal(int i2, int i3, int i4) {
            this.f15296a = i2;
            this.f15297b = i3;
            this.f15298c = i4;
        }

        /* access modifiers changed from: package-private */
        public int a() {
            return this.f15296a + this.f15298c;
        }

        /* access modifiers changed from: package-private */
        public int b() {
            return this.f15297b + this.f15298c;
        }
    }

    public static class DiffResult {

        /* renamed from: h  reason: collision with root package name */
        public static final int f15299h = -1;

        /* renamed from: i  reason: collision with root package name */
        private static final int f15300i = 1;

        /* renamed from: j  reason: collision with root package name */
        private static final int f15301j = 2;

        /* renamed from: k  reason: collision with root package name */
        private static final int f15302k = 4;

        /* renamed from: l  reason: collision with root package name */
        private static final int f15303l = 8;

        /* renamed from: m  reason: collision with root package name */
        private static final int f15304m = 12;

        /* renamed from: n  reason: collision with root package name */
        private static final int f15305n = 4;
        private static final int o = 15;

        /* renamed from: a  reason: collision with root package name */
        private final List<Diagonal> f15306a;

        /* renamed from: b  reason: collision with root package name */
        private final int[] f15307b;

        /* renamed from: c  reason: collision with root package name */
        private final int[] f15308c;

        /* renamed from: d  reason: collision with root package name */
        private final Callback f15309d;

        /* renamed from: e  reason: collision with root package name */
        private final int f15310e;

        /* renamed from: f  reason: collision with root package name */
        private final int f15311f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f15312g;

        DiffResult(Callback callback, List<Diagonal> list, int[] iArr, int[] iArr2, boolean z) {
            this.f15306a = list;
            this.f15307b = iArr;
            this.f15308c = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.f15309d = callback;
            this.f15310e = callback.e();
            this.f15311f = callback.d();
            this.f15312g = z;
            a();
            g();
        }

        private void a() {
            Diagonal diagonal = this.f15306a.isEmpty() ? null : this.f15306a.get(0);
            if (!(diagonal != null && diagonal.f15296a == 0 && diagonal.f15297b == 0)) {
                this.f15306a.add(0, new Diagonal(0, 0, 0));
            }
            this.f15306a.add(new Diagonal(this.f15310e, this.f15311f, 0));
        }

        private void f(int i2) {
            int size = this.f15306a.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                Diagonal diagonal = this.f15306a.get(i4);
                while (i3 < diagonal.f15297b) {
                    if (this.f15308c[i3] != 0 || !this.f15309d.b(i2, i3)) {
                        i3++;
                    } else {
                        int i5 = this.f15309d.a(i2, i3) ? 8 : 4;
                        this.f15307b[i2] = (i3 << 4) | i5;
                        this.f15308c[i3] = (i2 << 4) | i5;
                        return;
                    }
                }
                i3 = diagonal.b();
            }
        }

        private void g() {
            for (Diagonal next : this.f15306a) {
                for (int i2 = 0; i2 < next.f15298c; i2++) {
                    int i3 = next.f15296a + i2;
                    int i4 = next.f15297b + i2;
                    int i5 = this.f15309d.a(i3, i4) ? 1 : 2;
                    this.f15307b[i3] = (i4 << 4) | i5;
                    this.f15308c[i4] = (i3 << 4) | i5;
                }
            }
            if (this.f15312g) {
                h();
            }
        }

        private void h() {
            int i2 = 0;
            for (Diagonal next : this.f15306a) {
                while (i2 < next.f15296a) {
                    if (this.f15307b[i2] == 0) {
                        f(i2);
                    }
                    i2++;
                }
                i2 = next.a();
            }
        }

        @Nullable
        private static PostponedUpdate i(Collection<PostponedUpdate> collection, int i2, boolean z) {
            PostponedUpdate postponedUpdate;
            Iterator<PostponedUpdate> it2 = collection.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    postponedUpdate = null;
                    break;
                }
                postponedUpdate = it2.next();
                if (postponedUpdate.f15313a == i2 && postponedUpdate.f15315c == z) {
                    it2.remove();
                    break;
                }
            }
            while (it2.hasNext()) {
                PostponedUpdate next = it2.next();
                int i3 = next.f15314b;
                next.f15314b = z ? i3 - 1 : i3 + 1;
            }
            return postponedUpdate;
        }

        public int b(@IntRange(from = 0) int i2) {
            if (i2 < 0 || i2 >= this.f15311f) {
                throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + i2 + ", new list size = " + this.f15311f);
            }
            int i3 = this.f15308c[i2];
            if ((i3 & 15) == 0) {
                return -1;
            }
            return i3 >> 4;
        }

        public int c(@IntRange(from = 0) int i2) {
            if (i2 < 0 || i2 >= this.f15310e) {
                throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + i2 + ", old list size = " + this.f15310e);
            }
            int i3 = this.f15307b[i2];
            if ((i3 & 15) == 0) {
                return -1;
            }
            return i3 >> 4;
        }

        public void d(@NonNull ListUpdateCallback listUpdateCallback) {
            int i2;
            BatchingListUpdateCallback batchingListUpdateCallback = listUpdateCallback instanceof BatchingListUpdateCallback ? (BatchingListUpdateCallback) listUpdateCallback : new BatchingListUpdateCallback(listUpdateCallback);
            int i3 = this.f15310e;
            ArrayDeque arrayDeque = new ArrayDeque();
            int i4 = this.f15310e;
            int i5 = this.f15311f;
            for (int size = this.f15306a.size() - 1; size >= 0; size--) {
                Diagonal diagonal = this.f15306a.get(size);
                int a2 = diagonal.a();
                int b2 = diagonal.b();
                while (true) {
                    if (i4 <= a2) {
                        break;
                    }
                    i4--;
                    int i6 = this.f15307b[i4];
                    if ((i6 & 12) != 0) {
                        int i7 = i6 >> 4;
                        PostponedUpdate i8 = i(arrayDeque, i7, false);
                        if (i8 != null) {
                            int i9 = (i3 - i8.f15314b) - 1;
                            batchingListUpdateCallback.a(i4, i9);
                            if ((i6 & 4) != 0) {
                                batchingListUpdateCallback.d(i9, 1, this.f15309d.c(i4, i7));
                            }
                        } else {
                            arrayDeque.add(new PostponedUpdate(i4, (i3 - i4) - 1, true));
                        }
                    } else {
                        batchingListUpdateCallback.c(i4, 1);
                        i3--;
                    }
                }
                while (i5 > b2) {
                    i5--;
                    int i10 = this.f15308c[i5];
                    if ((i10 & 12) != 0) {
                        int i11 = i10 >> 4;
                        PostponedUpdate i12 = i(arrayDeque, i11, true);
                        if (i12 == null) {
                            arrayDeque.add(new PostponedUpdate(i5, i3 - i4, false));
                        } else {
                            batchingListUpdateCallback.a((i3 - i12.f15314b) - 1, i4);
                            if ((i10 & 4) != 0) {
                                batchingListUpdateCallback.d(i4, 1, this.f15309d.c(i11, i5));
                            }
                        }
                    } else {
                        batchingListUpdateCallback.b(i4, 1);
                        i3++;
                    }
                }
                int i13 = diagonal.f15296a;
                int i14 = diagonal.f15297b;
                for (i2 = 0; i2 < diagonal.f15298c; i2++) {
                    if ((this.f15307b[i13] & 15) == 2) {
                        batchingListUpdateCallback.d(i13, 1, this.f15309d.c(i13, i14));
                    }
                    i13++;
                    i14++;
                }
                i4 = diagonal.f15296a;
                i5 = diagonal.f15297b;
            }
            batchingListUpdateCallback.e();
        }

        public void e(@NonNull RecyclerView.Adapter adapter) {
            d(new AdapterListUpdateCallback(adapter));
        }
    }

    public static abstract class ItemCallback<T> {
        public abstract boolean a(@NonNull T t, @NonNull T t2);

        public abstract boolean b(@NonNull T t, @NonNull T t2);

        @Nullable
        public Object c(@NonNull T t, @NonNull T t2) {
            return null;
        }
    }

    private static class PostponedUpdate {

        /* renamed from: a  reason: collision with root package name */
        int f15313a;

        /* renamed from: b  reason: collision with root package name */
        int f15314b;

        /* renamed from: c  reason: collision with root package name */
        boolean f15315c;

        PostponedUpdate(int i2, int i3, boolean z) {
            this.f15313a = i2;
            this.f15314b = i3;
            this.f15315c = z;
        }
    }

    static class Range {

        /* renamed from: a  reason: collision with root package name */
        int f15316a;

        /* renamed from: b  reason: collision with root package name */
        int f15317b;

        /* renamed from: c  reason: collision with root package name */
        int f15318c;

        /* renamed from: d  reason: collision with root package name */
        int f15319d;

        public Range() {
        }

        /* access modifiers changed from: package-private */
        public int a() {
            return this.f15319d - this.f15318c;
        }

        /* access modifiers changed from: package-private */
        public int b() {
            return this.f15317b - this.f15316a;
        }

        public Range(int i2, int i3, int i4, int i5) {
            this.f15316a = i2;
            this.f15317b = i3;
            this.f15318c = i4;
            this.f15319d = i5;
        }
    }

    static class Snake {

        /* renamed from: a  reason: collision with root package name */
        public int f15320a;

        /* renamed from: b  reason: collision with root package name */
        public int f15321b;

        /* renamed from: c  reason: collision with root package name */
        public int f15322c;

        /* renamed from: d  reason: collision with root package name */
        public int f15323d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f15324e;

        Snake() {
        }

        /* access modifiers changed from: package-private */
        public int a() {
            return Math.min(this.f15322c - this.f15320a, this.f15323d - this.f15321b);
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            return this.f15323d - this.f15321b != this.f15322c - this.f15320a;
        }

        /* access modifiers changed from: package-private */
        public boolean c() {
            return this.f15323d - this.f15321b > this.f15322c - this.f15320a;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Diagonal d() {
            if (!b()) {
                int i2 = this.f15320a;
                return new Diagonal(i2, this.f15321b, this.f15322c - i2);
            } else if (this.f15324e) {
                return new Diagonal(this.f15320a, this.f15321b, a());
            } else {
                return c() ? new Diagonal(this.f15320a, this.f15321b + 1, a()) : new Diagonal(this.f15320a + 1, this.f15321b, a());
            }
        }
    }

    private DiffUtil() {
    }

    @Nullable
    private static Snake a(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2, int i2) {
        int i3;
        int i4;
        int i5;
        boolean z = (range.b() - range.a()) % 2 == 0;
        int b2 = range.b() - range.a();
        int i6 = -i2;
        int i7 = i6;
        while (i7 <= i2) {
            if (i7 == i6 || (i7 != i2 && centeredArray2.c(i7 + 1) < centeredArray2.c(i7 - 1))) {
                i4 = centeredArray2.c(i7 + 1);
                i3 = i4;
            } else {
                i4 = centeredArray2.c(i7 - 1);
                i3 = i4 - 1;
            }
            int i8 = range.f15319d - ((range.f15317b - i3) - i7);
            int i9 = (i2 == 0 || i3 != i4) ? i8 : i8 + 1;
            while (i3 > range.f15316a && i8 > range.f15318c && callback.b(i3 - 1, i8 - 1)) {
                i3--;
                i8--;
            }
            centeredArray2.d(i7, i3);
            if (!z || (i5 = b2 - i7) < i6 || i5 > i2 || centeredArray.c(i5) < i3) {
                i7 += 2;
            } else {
                Snake snake = new Snake();
                snake.f15320a = i3;
                snake.f15321b = i8;
                snake.f15322c = i4;
                snake.f15323d = i9;
                snake.f15324e = true;
                return snake;
            }
        }
        return null;
    }

    @NonNull
    public static DiffResult b(@NonNull Callback callback) {
        return c(callback, true);
    }

    @NonNull
    public static DiffResult c(@NonNull Callback callback, boolean z) {
        int e2 = callback.e();
        int d2 = callback.d();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new Range(0, e2, 0, d2));
        int i2 = ((((e2 + d2) + 1) / 2) * 2) + 1;
        CenteredArray centeredArray = new CenteredArray(i2);
        CenteredArray centeredArray2 = new CenteredArray(i2);
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            Range range = (Range) arrayList2.remove(arrayList2.size() - 1);
            Snake e3 = e(range, callback, centeredArray, centeredArray2);
            if (e3 != null) {
                if (e3.a() > 0) {
                    arrayList.add(e3.d());
                }
                Range range2 = arrayList3.isEmpty() ? new Range() : (Range) arrayList3.remove(arrayList3.size() - 1);
                range2.f15316a = range.f15316a;
                range2.f15318c = range.f15318c;
                range2.f15317b = e3.f15320a;
                range2.f15319d = e3.f15321b;
                arrayList2.add(range2);
                range.f15317b = range.f15317b;
                range.f15319d = range.f15319d;
                range.f15316a = e3.f15322c;
                range.f15318c = e3.f15323d;
                arrayList2.add(range);
            } else {
                arrayList3.add(range);
            }
        }
        Collections.sort(arrayList, f15293a);
        return new DiffResult(callback, arrayList, centeredArray.a(), centeredArray2.a(), z);
    }

    @Nullable
    private static Snake d(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2, int i2) {
        int i3;
        int i4;
        int i5;
        boolean z = true;
        if (Math.abs(range.b() - range.a()) % 2 != 1) {
            z = false;
        }
        int b2 = range.b() - range.a();
        int i6 = -i2;
        int i7 = i6;
        while (i7 <= i2) {
            if (i7 == i6 || (i7 != i2 && centeredArray.c(i7 + 1) > centeredArray.c(i7 - 1))) {
                i4 = centeredArray.c(i7 + 1);
                i3 = i4;
            } else {
                i4 = centeredArray.c(i7 - 1);
                i3 = i4 + 1;
            }
            int i8 = (range.f15318c + (i3 - range.f15316a)) - i7;
            int i9 = (i2 == 0 || i3 != i4) ? i8 : i8 - 1;
            while (i3 < range.f15317b && i8 < range.f15319d && callback.b(i3, i8)) {
                i3++;
                i8++;
            }
            centeredArray.d(i7, i3);
            if (!z || (i5 = b2 - i7) < i6 + 1 || i5 > i2 - 1 || centeredArray2.c(i5) > i3) {
                i7 += 2;
            } else {
                Snake snake = new Snake();
                snake.f15320a = i4;
                snake.f15321b = i9;
                snake.f15322c = i3;
                snake.f15323d = i8;
                snake.f15324e = false;
                return snake;
            }
        }
        return null;
    }

    @Nullable
    private static Snake e(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2) {
        if (range.b() >= 1 && range.a() >= 1) {
            int b2 = ((range.b() + range.a()) + 1) / 2;
            centeredArray.d(1, range.f15316a);
            centeredArray2.d(1, range.f15317b);
            for (int i2 = 0; i2 < b2; i2++) {
                Snake d2 = d(range, callback, centeredArray, centeredArray2, i2);
                if (d2 != null) {
                    return d2;
                }
                Snake a2 = a(range, callback, centeredArray, centeredArray2, i2);
                if (a2 != null) {
                    return a2;
                }
            }
        }
        return null;
    }
}
