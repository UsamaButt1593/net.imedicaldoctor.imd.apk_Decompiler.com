package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.recyclerview.widget.RecyclerView;
import com.dd.plist.ASCIIPropertyListParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider {
    private static final String Q = "StaggeredGridLManager";
    static final boolean R = false;
    public static final int S = 0;
    public static final int T = 1;
    public static final int U = 0;
    @Deprecated
    public static final int V = 1;
    public static final int W = 2;
    static final int X = Integer.MIN_VALUE;
    private static final float Y = 0.33333334f;
    boolean A = false;
    private BitSet B;
    int C = -1;
    int D = Integer.MIN_VALUE;
    LazySpanLookup E = new LazySpanLookup();
    private int F = 2;
    private boolean G;
    private boolean H;
    private SavedState I;
    private int J;
    private final Rect K = new Rect();
    private final AnchorInfo L = new AnchorInfo();
    private boolean M = false;
    private boolean N = true;
    private int[] O;
    private final Runnable P = new Runnable() {
        public void run() {
            StaggeredGridLayoutManager.this.u2();
        }
    };
    private int s = -1;
    Span[] t;
    @NonNull
    OrientationHelper u;
    @NonNull
    OrientationHelper v;
    private int w;
    private int x;
    @NonNull
    private final LayoutState y;
    boolean z = false;

    class AnchorInfo {

        /* renamed from: a  reason: collision with root package name */
        int f15635a;

        /* renamed from: b  reason: collision with root package name */
        int f15636b;

        /* renamed from: c  reason: collision with root package name */
        boolean f15637c;

        /* renamed from: d  reason: collision with root package name */
        boolean f15638d;

        /* renamed from: e  reason: collision with root package name */
        boolean f15639e;

        /* renamed from: f  reason: collision with root package name */
        int[] f15640f;

        AnchorInfo() {
            c();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f15636b = this.f15637c ? StaggeredGridLayoutManager.this.u.i() : StaggeredGridLayoutManager.this.u.n();
        }

        /* access modifiers changed from: package-private */
        public void b(int i2) {
            this.f15636b = this.f15637c ? StaggeredGridLayoutManager.this.u.i() - i2 : StaggeredGridLayoutManager.this.u.n() + i2;
        }

        /* access modifiers changed from: package-private */
        public void c() {
            this.f15635a = -1;
            this.f15636b = Integer.MIN_VALUE;
            this.f15637c = false;
            this.f15638d = false;
            this.f15639e = false;
            int[] iArr = this.f15640f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        /* access modifiers changed from: package-private */
        public void d(Span[] spanArr) {
            int length = spanArr.length;
            int[] iArr = this.f15640f;
            if (iArr == null || iArr.length < length) {
                this.f15640f = new int[StaggeredGridLayoutManager.this.t.length];
            }
            for (int i2 = 0; i2 < length; i2++) {
                this.f15640f[i2] = spanArr[i2].u(Integer.MIN_VALUE);
            }
        }
    }

    public static class LayoutParams extends RecyclerView.LayoutParams {

        /* renamed from: g  reason: collision with root package name */
        public static final int f15642g = -1;

        /* renamed from: e  reason: collision with root package name */
        Span f15643e;

        /* renamed from: f  reason: collision with root package name */
        boolean f15644f;

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        public final int j() {
            Span span = this.f15643e;
            if (span == null) {
                return -1;
            }
            return span.f15653e;
        }

        public boolean k() {
            return this.f15644f;
        }

        public void l(boolean z) {
            this.f15644f = z;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    static class LazySpanLookup {

        /* renamed from: c  reason: collision with root package name */
        private static final int f15645c = 10;

        /* renamed from: a  reason: collision with root package name */
        int[] f15646a;

        /* renamed from: b  reason: collision with root package name */
        List<FullSpanItem> f15647b;

        @SuppressLint({"BanParcelableUsage"})
        static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new Parcelable.Creator<FullSpanItem>() {
                /* renamed from: a */
                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                /* renamed from: b */
                public FullSpanItem[] newArray(int i2) {
                    return new FullSpanItem[i2];
                }
            };
            int X;
            int[] Y;
            boolean Z;
            int s;

            FullSpanItem() {
            }

            /* access modifiers changed from: package-private */
            public int a(int i2) {
                int[] iArr = this.Y;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i2];
            }

            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.s + ", mGapDir=" + this.X + ", mHasUnwantedGapAfter=" + this.Z + ", mGapPerSpan=" + Arrays.toString(this.Y) + ASCIIPropertyListParser.f18653k;
            }

            public void writeToParcel(Parcel parcel, int i2) {
                parcel.writeInt(this.s);
                parcel.writeInt(this.X);
                parcel.writeInt(this.Z ? 1 : 0);
                int[] iArr = this.Y;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(iArr.length);
                parcel.writeIntArray(this.Y);
            }

            FullSpanItem(Parcel parcel) {
                this.s = parcel.readInt();
                this.X = parcel.readInt();
                this.Z = parcel.readInt() != 1 ? false : true;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    int[] iArr = new int[readInt];
                    this.Y = iArr;
                    parcel.readIntArray(iArr);
                }
            }
        }

        LazySpanLookup() {
        }

        private int i(int i2) {
            if (this.f15647b == null) {
                return -1;
            }
            FullSpanItem f2 = f(i2);
            if (f2 != null) {
                this.f15647b.remove(f2);
            }
            int size = this.f15647b.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    i3 = -1;
                    break;
                } else if (this.f15647b.get(i3).s >= i2) {
                    break;
                } else {
                    i3++;
                }
            }
            if (i3 == -1) {
                return -1;
            }
            this.f15647b.remove(i3);
            return this.f15647b.get(i3).s;
        }

        private void l(int i2, int i3) {
            List<FullSpanItem> list = this.f15647b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = this.f15647b.get(size);
                    int i4 = fullSpanItem.s;
                    if (i4 >= i2) {
                        fullSpanItem.s = i4 + i3;
                    }
                }
            }
        }

        private void m(int i2, int i3) {
            List<FullSpanItem> list = this.f15647b;
            if (list != null) {
                int i4 = i2 + i3;
                for (int size = list.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = this.f15647b.get(size);
                    int i5 = fullSpanItem.s;
                    if (i5 >= i2) {
                        if (i5 < i4) {
                            this.f15647b.remove(size);
                        } else {
                            fullSpanItem.s = i5 - i3;
                        }
                    }
                }
            }
        }

        public void a(FullSpanItem fullSpanItem) {
            if (this.f15647b == null) {
                this.f15647b = new ArrayList();
            }
            int size = this.f15647b.size();
            for (int i2 = 0; i2 < size; i2++) {
                FullSpanItem fullSpanItem2 = this.f15647b.get(i2);
                if (fullSpanItem2.s == fullSpanItem.s) {
                    this.f15647b.remove(i2);
                }
                if (fullSpanItem2.s >= fullSpanItem.s) {
                    this.f15647b.add(i2, fullSpanItem);
                    return;
                }
            }
            this.f15647b.add(fullSpanItem);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            int[] iArr = this.f15646a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f15647b = null;
        }

        /* access modifiers changed from: package-private */
        public void c(int i2) {
            int[] iArr = this.f15646a;
            if (iArr == null) {
                int[] iArr2 = new int[(Math.max(i2, 10) + 1)];
                this.f15646a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i2 >= iArr.length) {
                int[] iArr3 = new int[o(i2)];
                this.f15646a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f15646a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        /* access modifiers changed from: package-private */
        public int d(int i2) {
            List<FullSpanItem> list = this.f15647b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.f15647b.get(size).s >= i2) {
                        this.f15647b.remove(size);
                    }
                }
            }
            return h(i2);
        }

        public FullSpanItem e(int i2, int i3, int i4, boolean z) {
            List<FullSpanItem> list = this.f15647b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                FullSpanItem fullSpanItem = this.f15647b.get(i5);
                int i6 = fullSpanItem.s;
                if (i6 >= i3) {
                    return null;
                }
                if (i6 >= i2 && (i4 == 0 || fullSpanItem.X == i4 || (z && fullSpanItem.Z))) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public FullSpanItem f(int i2) {
            List<FullSpanItem> list = this.f15647b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f15647b.get(size);
                if (fullSpanItem.s == i2) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public int g(int i2) {
            int[] iArr = this.f15646a;
            if (iArr == null || i2 >= iArr.length) {
                return -1;
            }
            return iArr[i2];
        }

        /* access modifiers changed from: package-private */
        public int h(int i2) {
            int[] iArr = this.f15646a;
            if (iArr == null || i2 >= iArr.length) {
                return -1;
            }
            int i3 = i(i2);
            if (i3 == -1) {
                int[] iArr2 = this.f15646a;
                Arrays.fill(iArr2, i2, iArr2.length, -1);
                return this.f15646a.length;
            }
            int min = Math.min(i3 + 1, this.f15646a.length);
            Arrays.fill(this.f15646a, i2, min, -1);
            return min;
        }

        /* access modifiers changed from: package-private */
        public void j(int i2, int i3) {
            int[] iArr = this.f15646a;
            if (iArr != null && i2 < iArr.length) {
                int i4 = i2 + i3;
                c(i4);
                int[] iArr2 = this.f15646a;
                System.arraycopy(iArr2, i2, iArr2, i4, (iArr2.length - i2) - i3);
                Arrays.fill(this.f15646a, i2, i4, -1);
                l(i2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        public void k(int i2, int i3) {
            int[] iArr = this.f15646a;
            if (iArr != null && i2 < iArr.length) {
                int i4 = i2 + i3;
                c(i4);
                int[] iArr2 = this.f15646a;
                System.arraycopy(iArr2, i4, iArr2, i2, (iArr2.length - i2) - i3);
                int[] iArr3 = this.f15646a;
                Arrays.fill(iArr3, iArr3.length - i3, iArr3.length, -1);
                m(i2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        public void n(int i2, Span span) {
            c(i2);
            this.f15646a[i2] = span.f15653e;
        }

        /* access modifiers changed from: package-private */
        public int o(int i2) {
            int length = this.f15646a.length;
            while (length <= i2) {
                length *= 2;
            }
            return length;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };
        int X;
        int X2;
        int Y;
        int[] Y2;
        int[] Z;
        List<LazySpanLookup.FullSpanItem> Z2;
        boolean a3;
        boolean b3;
        boolean c3;
        int s;

        public SavedState() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.Z = null;
            this.Y = 0;
            this.s = -1;
            this.X = -1;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.Z = null;
            this.Y = 0;
            this.X2 = 0;
            this.Y2 = null;
            this.Z2 = null;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.s);
            parcel.writeInt(this.X);
            parcel.writeInt(this.Y);
            if (this.Y > 0) {
                parcel.writeIntArray(this.Z);
            }
            parcel.writeInt(this.X2);
            if (this.X2 > 0) {
                parcel.writeIntArray(this.Y2);
            }
            parcel.writeInt(this.a3 ? 1 : 0);
            parcel.writeInt(this.b3 ? 1 : 0);
            parcel.writeInt(this.c3 ? 1 : 0);
            parcel.writeList(this.Z2);
        }

        SavedState(Parcel parcel) {
            this.s = parcel.readInt();
            this.X = parcel.readInt();
            int readInt = parcel.readInt();
            this.Y = readInt;
            if (readInt > 0) {
                int[] iArr = new int[readInt];
                this.Z = iArr;
                parcel.readIntArray(iArr);
            }
            int readInt2 = parcel.readInt();
            this.X2 = readInt2;
            if (readInt2 > 0) {
                int[] iArr2 = new int[readInt2];
                this.Y2 = iArr2;
                parcel.readIntArray(iArr2);
            }
            boolean z = false;
            this.a3 = parcel.readInt() == 1;
            this.b3 = parcel.readInt() == 1;
            this.c3 = parcel.readInt() == 1 ? true : z;
            this.Z2 = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.Y = savedState.Y;
            this.s = savedState.s;
            this.X = savedState.X;
            this.Z = savedState.Z;
            this.X2 = savedState.X2;
            this.Y2 = savedState.Y2;
            this.a3 = savedState.a3;
            this.b3 = savedState.b3;
            this.c3 = savedState.c3;
            this.Z2 = savedState.Z2;
        }
    }

    class Span {

        /* renamed from: g  reason: collision with root package name */
        static final int f15648g = Integer.MIN_VALUE;

        /* renamed from: a  reason: collision with root package name */
        ArrayList<View> f15649a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        int f15650b = Integer.MIN_VALUE;

        /* renamed from: c  reason: collision with root package name */
        int f15651c = Integer.MIN_VALUE;

        /* renamed from: d  reason: collision with root package name */
        int f15652d = 0;

        /* renamed from: e  reason: collision with root package name */
        final int f15653e;

        Span(int i2) {
            this.f15653e = i2;
        }

        /* access modifiers changed from: package-private */
        public void A(int i2) {
            this.f15650b = i2;
            this.f15651c = i2;
        }

        /* access modifiers changed from: package-private */
        public void a(View view) {
            LayoutParams s = s(view);
            s.f15643e = this;
            this.f15649a.add(view);
            this.f15651c = Integer.MIN_VALUE;
            if (this.f15649a.size() == 1) {
                this.f15650b = Integer.MIN_VALUE;
            }
            if (s.g() || s.f()) {
                this.f15652d += StaggeredGridLayoutManager.this.u.e(view);
            }
        }

        /* access modifiers changed from: package-private */
        public void b(boolean z, int i2) {
            int q = z ? q(Integer.MIN_VALUE) : u(Integer.MIN_VALUE);
            e();
            if (q != Integer.MIN_VALUE) {
                if (z && q < StaggeredGridLayoutManager.this.u.i()) {
                    return;
                }
                if (z || q <= StaggeredGridLayoutManager.this.u.n()) {
                    if (i2 != Integer.MIN_VALUE) {
                        q += i2;
                    }
                    this.f15651c = q;
                    this.f15650b = q;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            LazySpanLookup.FullSpanItem f2;
            ArrayList<View> arrayList = this.f15649a;
            View view = arrayList.get(arrayList.size() - 1);
            LayoutParams s = s(view);
            this.f15651c = StaggeredGridLayoutManager.this.u.d(view);
            if (s.f15644f && (f2 = StaggeredGridLayoutManager.this.E.f(s.d())) != null && f2.X == 1) {
                this.f15651c += f2.a(this.f15653e);
            }
        }

        /* access modifiers changed from: package-private */
        public void d() {
            LazySpanLookup.FullSpanItem f2;
            View view = this.f15649a.get(0);
            LayoutParams s = s(view);
            this.f15650b = StaggeredGridLayoutManager.this.u.g(view);
            if (s.f15644f && (f2 = StaggeredGridLayoutManager.this.E.f(s.d())) != null && f2.X == -1) {
                this.f15650b -= f2.a(this.f15653e);
            }
        }

        /* access modifiers changed from: package-private */
        public void e() {
            this.f15649a.clear();
            v();
            this.f15652d = 0;
        }

        public int f() {
            return StaggeredGridLayoutManager.this.z ? n(this.f15649a.size() - 1, -1, true) : n(0, this.f15649a.size(), true);
        }

        public int g() {
            return StaggeredGridLayoutManager.this.z ? m(this.f15649a.size() - 1, -1, true) : m(0, this.f15649a.size(), true);
        }

        public int h() {
            return StaggeredGridLayoutManager.this.z ? n(this.f15649a.size() - 1, -1, false) : n(0, this.f15649a.size(), false);
        }

        public int i() {
            return StaggeredGridLayoutManager.this.z ? n(0, this.f15649a.size(), true) : n(this.f15649a.size() - 1, -1, true);
        }

        public int j() {
            return StaggeredGridLayoutManager.this.z ? m(0, this.f15649a.size(), true) : m(this.f15649a.size() - 1, -1, true);
        }

        public int k() {
            return StaggeredGridLayoutManager.this.z ? n(0, this.f15649a.size(), false) : n(this.f15649a.size() - 1, -1, false);
        }

        /* access modifiers changed from: package-private */
        public int l(int i2, int i3, boolean z, boolean z2, boolean z3) {
            int n2 = StaggeredGridLayoutManager.this.u.n();
            int i4 = StaggeredGridLayoutManager.this.u.i();
            int i5 = i3 > i2 ? 1 : -1;
            while (i2 != i3) {
                View view = this.f15649a.get(i2);
                int g2 = StaggeredGridLayoutManager.this.u.g(view);
                int d2 = StaggeredGridLayoutManager.this.u.d(view);
                boolean z4 = false;
                boolean z5 = !z3 ? g2 < i4 : g2 <= i4;
                if (!z3 ? d2 > n2 : d2 >= n2) {
                    z4 = true;
                }
                if (z5 && z4) {
                    if (!z || !z2) {
                        if (!z2 && g2 >= n2 && d2 <= i4) {
                        }
                    } else if (g2 >= n2 && d2 <= i4) {
                    }
                    return StaggeredGridLayoutManager.this.w0(view);
                }
                i2 += i5;
            }
            return -1;
        }

        /* access modifiers changed from: package-private */
        public int m(int i2, int i3, boolean z) {
            return l(i2, i3, false, false, z);
        }

        /* access modifiers changed from: package-private */
        public int n(int i2, int i3, boolean z) {
            return l(i2, i3, z, true, false);
        }

        public int o() {
            return this.f15652d;
        }

        /* access modifiers changed from: package-private */
        public int p() {
            int i2 = this.f15651c;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            c();
            return this.f15651c;
        }

        /* access modifiers changed from: package-private */
        public int q(int i2) {
            int i3 = this.f15651c;
            if (i3 != Integer.MIN_VALUE) {
                return i3;
            }
            if (this.f15649a.size() == 0) {
                return i2;
            }
            c();
            return this.f15651c;
        }

        public View r(int i2, int i3) {
            View view = null;
            if (i3 != -1) {
                int size = this.f15649a.size() - 1;
                while (size >= 0) {
                    View view2 = this.f15649a.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.z && staggeredGridLayoutManager.w0(view2) >= i2) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.z && staggeredGridLayoutManager2.w0(view2) <= i2) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.f15649a.size();
                int i4 = 0;
                while (i4 < size2) {
                    View view3 = this.f15649a.get(i4);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.z && staggeredGridLayoutManager3.w0(view3) <= i2) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.z && staggeredGridLayoutManager4.w0(view3) >= i2) || !view3.hasFocusable()) {
                        break;
                    }
                    i4++;
                    view = view3;
                }
            }
            return view;
        }

        /* access modifiers changed from: package-private */
        public LayoutParams s(View view) {
            return (LayoutParams) view.getLayoutParams();
        }

        /* access modifiers changed from: package-private */
        public int t() {
            int i2 = this.f15650b;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            d();
            return this.f15650b;
        }

        /* access modifiers changed from: package-private */
        public int u(int i2) {
            int i3 = this.f15650b;
            if (i3 != Integer.MIN_VALUE) {
                return i3;
            }
            if (this.f15649a.size() == 0) {
                return i2;
            }
            d();
            return this.f15650b;
        }

        /* access modifiers changed from: package-private */
        public void v() {
            this.f15650b = Integer.MIN_VALUE;
            this.f15651c = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public void w(int i2) {
            int i3 = this.f15650b;
            if (i3 != Integer.MIN_VALUE) {
                this.f15650b = i3 + i2;
            }
            int i4 = this.f15651c;
            if (i4 != Integer.MIN_VALUE) {
                this.f15651c = i4 + i2;
            }
        }

        /* access modifiers changed from: package-private */
        public void x() {
            int size = this.f15649a.size();
            View remove = this.f15649a.remove(size - 1);
            LayoutParams s = s(remove);
            s.f15643e = null;
            if (s.g() || s.f()) {
                this.f15652d -= StaggeredGridLayoutManager.this.u.e(remove);
            }
            if (size == 1) {
                this.f15650b = Integer.MIN_VALUE;
            }
            this.f15651c = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public void y() {
            View remove = this.f15649a.remove(0);
            LayoutParams s = s(remove);
            s.f15643e = null;
            if (this.f15649a.size() == 0) {
                this.f15651c = Integer.MIN_VALUE;
            }
            if (s.g() || s.f()) {
                this.f15652d -= StaggeredGridLayoutManager.this.u.e(remove);
            }
            this.f15650b = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public void z(View view) {
            LayoutParams s = s(view);
            s.f15643e = this;
            this.f15649a.add(0, view);
            this.f15650b = Integer.MIN_VALUE;
            if (this.f15649a.size() == 1) {
                this.f15651c = Integer.MIN_VALUE;
            }
            if (s.g() || s.f()) {
                this.f15652d += StaggeredGridLayoutManager.this.u.e(view);
            }
        }
    }

    public StaggeredGridLayoutManager(int i2, int i3) {
        this.w = i3;
        v3(i2);
        this.y = new LayoutState();
        C2();
    }

    private LazySpanLookup.FullSpanItem A2(int i2) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.Y = new int[this.s];
        for (int i3 = 0; i3 < this.s; i3++) {
            fullSpanItem.Y[i3] = i2 - this.t[i3].q(i2);
        }
        return fullSpanItem;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void A3(int r5, androidx.recyclerview.widget.RecyclerView.State r6) {
        /*
            r4 = this;
            androidx.recyclerview.widget.LayoutState r0 = r4.y
            r1 = 0
            r0.f15396b = r1
            r0.f15397c = r5
            boolean r0 = r4.Q0()
            r2 = 1
            if (r0 == 0) goto L_0x002f
            int r6 = r6.g()
            r0 = -1
            if (r6 == r0) goto L_0x002f
            boolean r0 = r4.A
            if (r6 >= r5) goto L_0x001b
            r5 = 1
            goto L_0x001c
        L_0x001b:
            r5 = 0
        L_0x001c:
            if (r0 != r5) goto L_0x0026
            androidx.recyclerview.widget.OrientationHelper r5 = r4.u
            int r5 = r5.o()
        L_0x0024:
            r6 = 0
            goto L_0x0031
        L_0x0026:
            androidx.recyclerview.widget.OrientationHelper r5 = r4.u
            int r5 = r5.o()
            r6 = r5
            r5 = 0
            goto L_0x0031
        L_0x002f:
            r5 = 0
            goto L_0x0024
        L_0x0031:
            boolean r0 = r4.Z()
            if (r0 == 0) goto L_0x004e
            androidx.recyclerview.widget.LayoutState r0 = r4.y
            androidx.recyclerview.widget.OrientationHelper r3 = r4.u
            int r3 = r3.n()
            int r3 = r3 - r6
            r0.f15400f = r3
            androidx.recyclerview.widget.LayoutState r6 = r4.y
            androidx.recyclerview.widget.OrientationHelper r0 = r4.u
            int r0 = r0.i()
            int r0 = r0 + r5
            r6.f15401g = r0
            goto L_0x005e
        L_0x004e:
            androidx.recyclerview.widget.LayoutState r0 = r4.y
            androidx.recyclerview.widget.OrientationHelper r3 = r4.u
            int r3 = r3.h()
            int r3 = r3 + r5
            r0.f15401g = r3
            androidx.recyclerview.widget.LayoutState r5 = r4.y
            int r6 = -r6
            r5.f15400f = r6
        L_0x005e:
            androidx.recyclerview.widget.LayoutState r5 = r4.y
            r5.f15402h = r1
            r5.f15395a = r2
            androidx.recyclerview.widget.OrientationHelper r6 = r4.u
            int r6 = r6.l()
            if (r6 != 0) goto L_0x0075
            androidx.recyclerview.widget.OrientationHelper r6 = r4.u
            int r6 = r6.h()
            if (r6 != 0) goto L_0x0075
            r1 = 1
        L_0x0075:
            r5.f15403i = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.A3(int, androidx.recyclerview.widget.RecyclerView$State):void");
    }

    private LazySpanLookup.FullSpanItem B2(int i2) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.Y = new int[this.s];
        for (int i3 = 0; i3 < this.s; i3++) {
            fullSpanItem.Y[i3] = this.t[i3].u(i2) - i2;
        }
        return fullSpanItem;
    }

    private void C2() {
        this.u = OrientationHelper.b(this, this.w);
        this.v = OrientationHelper.b(this, 1 - this.w);
    }

    private void C3(Span span, int i2, int i3) {
        int o = span.o();
        if (i2 == -1) {
            if (span.t() + o > i3) {
                return;
            }
        } else if (span.p() - o < i3) {
            return;
        }
        this.B.set(span.f15653e, false);
    }

    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r9v1, types: [int, boolean] */
    /* JADX WARNING: type inference failed for: r9v5 */
    private int D2(RecyclerView.Recycler recycler, LayoutState layoutState, RecyclerView.State state) {
        int i2;
        Span span;
        int i3;
        int i4;
        int i5;
        int i6;
        StaggeredGridLayoutManager staggeredGridLayoutManager;
        View view;
        int i7;
        int i8;
        RecyclerView.Recycler recycler2 = recycler;
        LayoutState layoutState2 = layoutState;
        ? r9 = 0;
        this.B.set(0, this.s, true);
        if (this.y.f15403i) {
            i2 = layoutState2.f15399e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            i2 = layoutState2.f15399e == 1 ? layoutState2.f15401g + layoutState2.f15396b : layoutState2.f15400f - layoutState2.f15396b;
        }
        w3(layoutState2.f15399e, i2);
        int i9 = this.A ? this.u.i() : this.u.n();
        boolean z2 = false;
        while (layoutState.a(state) && (this.y.f15403i || !this.B.isEmpty())) {
            View b2 = layoutState2.b(recycler2);
            LayoutParams layoutParams = (LayoutParams) b2.getLayoutParams();
            int d2 = layoutParams.d();
            int g2 = this.E.g(d2);
            boolean z3 = g2 == -1;
            if (z3) {
                span = layoutParams.f15644f ? this.t[r9] : W2(layoutState2);
                this.E.n(d2, span);
            } else {
                span = this.t[g2];
            }
            Span span2 = span;
            layoutParams.f15643e = span2;
            if (layoutState2.f15399e == 1) {
                j(b2);
            } else {
                k(b2, r9);
            }
            f3(b2, layoutParams, r9);
            if (layoutState2.f15399e == 1) {
                int S2 = layoutParams.f15644f ? S2(i9) : span2.q(i9);
                int e2 = this.u.e(b2) + S2;
                if (z3 && layoutParams.f15644f) {
                    LazySpanLookup.FullSpanItem A2 = A2(S2);
                    A2.X = -1;
                    A2.s = d2;
                    this.E.a(A2);
                }
                i3 = e2;
                i4 = S2;
            } else {
                int V2 = layoutParams.f15644f ? V2(i9) : span2.u(i9);
                i4 = V2 - this.u.e(b2);
                if (z3 && layoutParams.f15644f) {
                    LazySpanLookup.FullSpanItem B2 = B2(V2);
                    B2.X = 1;
                    B2.s = d2;
                    this.E.a(B2);
                }
                i3 = V2;
            }
            if (layoutParams.f15644f && layoutState2.f15398d == -1) {
                if (!z3) {
                    if (!(layoutState2.f15399e == 1 ? q2() : r2())) {
                        LazySpanLookup.FullSpanItem f2 = this.E.f(d2);
                        if (f2 != null) {
                            f2.Z = true;
                        }
                    }
                }
                this.M = true;
            }
            s2(b2, layoutParams, layoutState2);
            if (!d3() || this.w != 1) {
                int n2 = layoutParams.f15644f ? this.v.n() : (span2.f15653e * this.x) + this.v.n();
                i6 = n2;
                i5 = this.v.e(b2) + n2;
            } else {
                int i10 = layoutParams.f15644f ? this.v.i() : this.v.i() - (((this.s - 1) - span2.f15653e) * this.x);
                i5 = i10;
                i6 = i10 - this.v.e(b2);
            }
            if (this.w == 1) {
                staggeredGridLayoutManager = this;
                view = b2;
                i7 = i6;
                i6 = i4;
                i8 = i5;
            } else {
                staggeredGridLayoutManager = this;
                view = b2;
                i7 = i4;
                i8 = i3;
                i3 = i5;
            }
            staggeredGridLayoutManager.T0(view, i7, i6, i8, i3);
            if (layoutParams.f15644f) {
                w3(this.y.f15399e, i2);
            } else {
                C3(span2, this.y.f15399e, i2);
            }
            k3(recycler2, this.y);
            if (this.y.f15402h && b2.hasFocusable()) {
                if (layoutParams.f15644f) {
                    this.B.clear();
                } else {
                    this.B.set(span2.f15653e, false);
                    z2 = true;
                    r9 = 0;
                }
            }
            z2 = true;
            r9 = 0;
        }
        if (!z2) {
            k3(recycler2, this.y);
        }
        int n3 = this.y.f15399e == -1 ? this.u.n() - V2(this.u.n()) : S2(this.u.i()) - this.u.i();
        if (n3 > 0) {
            return Math.min(layoutState2.f15396b, n3);
        }
        return 0;
    }

    private int D3(int i2, int i3, int i4) {
        if (i3 == 0 && i4 == 0) {
            return i2;
        }
        int mode = View.MeasureSpec.getMode(i2);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i2) - i3) - i4), mode) : i2;
    }

    private int F2(int i2) {
        int V2 = V();
        for (int i3 = 0; i3 < V2; i3++) {
            int w0 = w0(U(i3));
            if (w0 >= 0 && w0 < i2) {
                return w0;
            }
        }
        return 0;
    }

    private int L2(int i2) {
        for (int V2 = V() - 1; V2 >= 0; V2--) {
            int w0 = w0(U(V2));
            if (w0 >= 0 && w0 < i2) {
                return w0;
            }
        }
        return 0;
    }

    private void N2(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z2) {
        int i2;
        int S2 = S2(Integer.MIN_VALUE);
        if (S2 != Integer.MIN_VALUE && (i2 = this.u.i() - S2) > 0) {
            int i3 = i2 - (-p3(-i2, recycler, state));
            if (z2 && i3 > 0) {
                this.u.t(i3);
            }
        }
    }

    private void O2(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z2) {
        int n2;
        int V2 = V2(Integer.MAX_VALUE);
        if (V2 != Integer.MAX_VALUE && (n2 = V2 - this.u.n()) > 0) {
            int p3 = n2 - p3(n2, recycler, state);
            if (z2 && p3 > 0) {
                this.u.t(-p3);
            }
        }
    }

    private int S2(int i2) {
        int q = this.t[0].q(i2);
        for (int i3 = 1; i3 < this.s; i3++) {
            int q2 = this.t[i3].q(i2);
            if (q2 > q) {
                q = q2;
            }
        }
        return q;
    }

    private int T2(int i2) {
        int u2 = this.t[0].u(i2);
        for (int i3 = 1; i3 < this.s; i3++) {
            int u3 = this.t[i3].u(i2);
            if (u3 > u2) {
                u2 = u3;
            }
        }
        return u2;
    }

    private int U2(int i2) {
        int q = this.t[0].q(i2);
        for (int i3 = 1; i3 < this.s; i3++) {
            int q2 = this.t[i3].q(i2);
            if (q2 < q) {
                q = q2;
            }
        }
        return q;
    }

    private int V2(int i2) {
        int u2 = this.t[0].u(i2);
        for (int i3 = 1; i3 < this.s; i3++) {
            int u3 = this.t[i3].u(i2);
            if (u3 < u2) {
                u2 = u3;
            }
        }
        return u2;
    }

    private Span W2(LayoutState layoutState) {
        int i2;
        int i3;
        int i4;
        if (h3(layoutState.f15399e)) {
            i4 = this.s - 1;
            i3 = -1;
            i2 = -1;
        } else {
            i3 = this.s;
            i4 = 0;
            i2 = 1;
        }
        Span span = null;
        if (layoutState.f15399e == 1) {
            int n2 = this.u.n();
            int i5 = Integer.MAX_VALUE;
            while (i4 != i3) {
                Span span2 = this.t[i4];
                int q = span2.q(n2);
                if (q < i5) {
                    span = span2;
                    i5 = q;
                }
                i4 += i2;
            }
            return span;
        }
        int i6 = this.u.i();
        int i7 = Integer.MIN_VALUE;
        while (i4 != i3) {
            Span span3 = this.t[i4];
            int u2 = span3.u(i6);
            if (u2 > i7) {
                span = span3;
                i7 = u2;
            }
            i4 += i2;
        }
        return span;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0044 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0045  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a3(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.A
            if (r0 == 0) goto L_0x0009
            int r0 = r6.R2()
            goto L_0x000d
        L_0x0009:
            int r0 = r6.P2()
        L_0x000d:
            r1 = 8
            if (r9 != r1) goto L_0x001b
            if (r7 >= r8) goto L_0x0017
            int r2 = r8 + 1
        L_0x0015:
            r3 = r7
            goto L_0x001e
        L_0x0017:
            int r2 = r7 + 1
            r3 = r8
            goto L_0x001e
        L_0x001b:
            int r2 = r7 + r8
            goto L_0x0015
        L_0x001e:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r4 = r6.E
            r4.h(r3)
            r4 = 1
            if (r9 == r4) goto L_0x003d
            r5 = 2
            if (r9 == r5) goto L_0x0037
            if (r9 == r1) goto L_0x002c
            goto L_0x0042
        L_0x002c:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.E
            r9.k(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r7 = r6.E
            r7.j(r8, r4)
            goto L_0x0042
        L_0x0037:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.E
            r9.k(r7, r8)
            goto L_0x0042
        L_0x003d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.E
            r9.j(r7, r8)
        L_0x0042:
            if (r2 > r0) goto L_0x0045
            return
        L_0x0045:
            boolean r7 = r6.A
            if (r7 == 0) goto L_0x004e
            int r7 = r6.P2()
            goto L_0x0052
        L_0x004e:
            int r7 = r6.R2()
        L_0x0052:
            if (r3 > r7) goto L_0x0057
            r6.R1()
        L_0x0057:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.a3(int, int, int):void");
    }

    private void e3(View view, int i2, int i3, boolean z2) {
        r(view, this.K);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i4 = layoutParams.leftMargin;
        Rect rect = this.K;
        int D3 = D3(i2, i4 + rect.left, layoutParams.rightMargin + rect.right);
        int i5 = layoutParams.topMargin;
        Rect rect2 = this.K;
        int D32 = D3(i3, i5 + rect2.top, layoutParams.bottomMargin + rect2.bottom);
        if (z2 ? i2(view, D3, D32, layoutParams) : g2(view, D3, D32, layoutParams)) {
            view.measure(D3, D32);
        }
    }

    private void f3(View view, LayoutParams layoutParams, boolean z2) {
        int W2;
        int W3;
        if (layoutParams.f15644f) {
            if (this.w == 1) {
                W2 = this.J;
            } else {
                e3(view, RecyclerView.LayoutManager.W(D0(), E0(), s0() + t0(), layoutParams.width, true), this.J, z2);
                return;
            }
        } else if (this.w == 1) {
            W2 = RecyclerView.LayoutManager.W(this.x, E0(), 0, layoutParams.width, false);
        } else {
            W2 = RecyclerView.LayoutManager.W(D0(), E0(), s0() + t0(), layoutParams.width, true);
            W3 = RecyclerView.LayoutManager.W(this.x, k0(), 0, layoutParams.height, false);
            e3(view, W2, W3, z2);
        }
        W3 = RecyclerView.LayoutManager.W(j0(), k0(), v0() + q0(), layoutParams.height, true);
        e3(view, W2, W3, z2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0147, code lost:
        if (u2() != false) goto L_0x014b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void g3(androidx.recyclerview.widget.RecyclerView.Recycler r9, androidx.recyclerview.widget.RecyclerView.State r10, boolean r11) {
        /*
            r8 = this;
            androidx.recyclerview.widget.StaggeredGridLayoutManager$AnchorInfo r0 = r8.L
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r1 = r8.I
            r2 = -1
            if (r1 != 0) goto L_0x000b
            int r1 = r8.C
            if (r1 == r2) goto L_0x0018
        L_0x000b:
            int r1 = r10.d()
            if (r1 != 0) goto L_0x0018
            r8.H1(r9)
            r0.c()
            return
        L_0x0018:
            boolean r1 = r0.f15639e
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0029
            int r1 = r8.C
            if (r1 != r2) goto L_0x0029
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r1 = r8.I
            if (r1 == 0) goto L_0x0027
            goto L_0x0029
        L_0x0027:
            r1 = 0
            goto L_0x002a
        L_0x0029:
            r1 = 1
        L_0x002a:
            if (r1 == 0) goto L_0x0043
            r0.c()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r5 = r8.I
            if (r5 == 0) goto L_0x0037
            r8.p2(r0)
            goto L_0x003e
        L_0x0037:
            r8.o3()
            boolean r5 = r8.A
            r0.f15637c = r5
        L_0x003e:
            r8.z3(r10, r0)
            r0.f15639e = r4
        L_0x0043:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r5 = r8.I
            if (r5 != 0) goto L_0x0060
            int r5 = r8.C
            if (r5 != r2) goto L_0x0060
            boolean r5 = r0.f15637c
            boolean r6 = r8.G
            if (r5 != r6) goto L_0x0059
            boolean r5 = r8.d3()
            boolean r6 = r8.H
            if (r5 == r6) goto L_0x0060
        L_0x0059:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r5 = r8.E
            r5.b()
            r0.f15638d = r4
        L_0x0060:
            int r5 = r8.V()
            if (r5 <= 0) goto L_0x00c9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r5 = r8.I
            if (r5 == 0) goto L_0x006e
            int r5 = r5.Y
            if (r5 >= r4) goto L_0x00c9
        L_0x006e:
            boolean r5 = r0.f15638d
            if (r5 == 0) goto L_0x008e
            r1 = 0
        L_0x0073:
            int r5 = r8.s
            if (r1 >= r5) goto L_0x00c9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span[] r5 = r8.t
            r5 = r5[r1]
            r5.e()
            int r5 = r0.f15636b
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r5 == r6) goto L_0x008b
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span[] r6 = r8.t
            r6 = r6[r1]
            r6.A(r5)
        L_0x008b:
            int r1 = r1 + 1
            goto L_0x0073
        L_0x008e:
            if (r1 != 0) goto L_0x00af
            androidx.recyclerview.widget.StaggeredGridLayoutManager$AnchorInfo r1 = r8.L
            int[] r1 = r1.f15640f
            if (r1 != 0) goto L_0x0097
            goto L_0x00af
        L_0x0097:
            r1 = 0
        L_0x0098:
            int r5 = r8.s
            if (r1 >= r5) goto L_0x00c9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span[] r5 = r8.t
            r5 = r5[r1]
            r5.e()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$AnchorInfo r6 = r8.L
            int[] r6 = r6.f15640f
            r6 = r6[r1]
            r5.A(r6)
            int r1 = r1 + 1
            goto L_0x0098
        L_0x00af:
            r1 = 0
        L_0x00b0:
            int r5 = r8.s
            if (r1 >= r5) goto L_0x00c2
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span[] r5 = r8.t
            r5 = r5[r1]
            boolean r6 = r8.A
            int r7 = r0.f15636b
            r5.b(r6, r7)
            int r1 = r1 + 1
            goto L_0x00b0
        L_0x00c2:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$AnchorInfo r1 = r8.L
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span[] r5 = r8.t
            r1.d(r5)
        L_0x00c9:
            r8.E(r9)
            androidx.recyclerview.widget.LayoutState r1 = r8.y
            r1.f15395a = r3
            r8.M = r3
            androidx.recyclerview.widget.OrientationHelper r1 = r8.v
            int r1 = r1.o()
            r8.B3(r1)
            int r1 = r0.f15635a
            r8.A3(r1, r10)
            boolean r1 = r0.f15637c
            if (r1 == 0) goto L_0x00fc
            r8.s3(r2)
            androidx.recyclerview.widget.LayoutState r1 = r8.y
            r8.D2(r9, r1, r10)
            r8.s3(r4)
        L_0x00ef:
            androidx.recyclerview.widget.LayoutState r1 = r8.y
            int r2 = r0.f15635a
            int r5 = r1.f15398d
            int r2 = r2 + r5
            r1.f15397c = r2
            r8.D2(r9, r1, r10)
            goto L_0x0108
        L_0x00fc:
            r8.s3(r4)
            androidx.recyclerview.widget.LayoutState r1 = r8.y
            r8.D2(r9, r1, r10)
            r8.s3(r2)
            goto L_0x00ef
        L_0x0108:
            r8.n3()
            int r1 = r8.V()
            if (r1 <= 0) goto L_0x0122
            boolean r1 = r8.A
            if (r1 == 0) goto L_0x011c
            r8.N2(r9, r10, r4)
            r8.O2(r9, r10, r3)
            goto L_0x0122
        L_0x011c:
            r8.O2(r9, r10, r4)
            r8.N2(r9, r10, r3)
        L_0x0122:
            if (r11 == 0) goto L_0x014a
            boolean r11 = r10.j()
            if (r11 != 0) goto L_0x014a
            int r11 = r8.F
            if (r11 == 0) goto L_0x014a
            int r11 = r8.V()
            if (r11 <= 0) goto L_0x014a
            boolean r11 = r8.M
            if (r11 != 0) goto L_0x013e
            android.view.View r11 = r8.b3()
            if (r11 == 0) goto L_0x014a
        L_0x013e:
            java.lang.Runnable r11 = r8.P
            r8.L1(r11)
            boolean r11 = r8.u2()
            if (r11 == 0) goto L_0x014a
            goto L_0x014b
        L_0x014a:
            r4 = 0
        L_0x014b:
            boolean r11 = r10.j()
            if (r11 == 0) goto L_0x0156
            androidx.recyclerview.widget.StaggeredGridLayoutManager$AnchorInfo r11 = r8.L
            r11.c()
        L_0x0156:
            boolean r11 = r0.f15637c
            r8.G = r11
            boolean r11 = r8.d3()
            r8.H = r11
            if (r4 == 0) goto L_0x016a
            androidx.recyclerview.widget.StaggeredGridLayoutManager$AnchorInfo r11 = r8.L
            r11.c()
            r8.g3(r9, r10, r3)
        L_0x016a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.g3(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State, boolean):void");
    }

    private boolean h3(int i2) {
        if (this.w == 0) {
            return (i2 == -1) != this.A;
        }
        return ((i2 == -1) == this.A) == d3();
    }

    private void j3(View view) {
        for (int i2 = this.s - 1; i2 >= 0; i2--) {
            this.t[i2].z(view);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0010, code lost:
        if (r4.f15399e == -1) goto L_0x0012;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void k3(androidx.recyclerview.widget.RecyclerView.Recycler r3, androidx.recyclerview.widget.LayoutState r4) {
        /*
            r2 = this;
            boolean r0 = r4.f15395a
            if (r0 == 0) goto L_0x004d
            boolean r0 = r4.f15403i
            if (r0 == 0) goto L_0x0009
            goto L_0x004d
        L_0x0009:
            int r0 = r4.f15396b
            r1 = -1
            if (r0 != 0) goto L_0x001e
            int r0 = r4.f15399e
            if (r0 != r1) goto L_0x0018
        L_0x0012:
            int r4 = r4.f15401g
        L_0x0014:
            r2.l3(r3, r4)
            goto L_0x004d
        L_0x0018:
            int r4 = r4.f15400f
        L_0x001a:
            r2.m3(r3, r4)
            goto L_0x004d
        L_0x001e:
            int r0 = r4.f15399e
            if (r0 != r1) goto L_0x0037
            int r0 = r4.f15400f
            int r1 = r2.T2(r0)
            int r0 = r0 - r1
            if (r0 >= 0) goto L_0x002c
            goto L_0x0012
        L_0x002c:
            int r1 = r4.f15401g
            int r4 = r4.f15396b
            int r4 = java.lang.Math.min(r0, r4)
            int r4 = r1 - r4
            goto L_0x0014
        L_0x0037:
            int r0 = r4.f15401g
            int r0 = r2.U2(r0)
            int r1 = r4.f15401g
            int r0 = r0 - r1
            if (r0 >= 0) goto L_0x0043
            goto L_0x0018
        L_0x0043:
            int r1 = r4.f15400f
            int r4 = r4.f15396b
            int r4 = java.lang.Math.min(r0, r4)
            int r4 = r4 + r1
            goto L_0x001a
        L_0x004d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.k3(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.LayoutState):void");
    }

    private void l3(RecyclerView.Recycler recycler, int i2) {
        int V2 = V() - 1;
        while (V2 >= 0) {
            View U2 = U(V2);
            if (this.u.g(U2) >= i2 && this.u.r(U2) >= i2) {
                LayoutParams layoutParams = (LayoutParams) U2.getLayoutParams();
                if (layoutParams.f15644f) {
                    int i3 = 0;
                    while (i3 < this.s) {
                        if (this.t[i3].f15649a.size() != 1) {
                            i3++;
                        } else {
                            return;
                        }
                    }
                    for (int i4 = 0; i4 < this.s; i4++) {
                        this.t[i4].x();
                    }
                } else if (layoutParams.f15643e.f15649a.size() != 1) {
                    layoutParams.f15643e.x();
                } else {
                    return;
                }
                J1(U2, recycler);
                V2--;
            } else {
                return;
            }
        }
    }

    private void m3(RecyclerView.Recycler recycler, int i2) {
        while (V() > 0) {
            View U2 = U(0);
            if (this.u.d(U2) <= i2 && this.u.q(U2) <= i2) {
                LayoutParams layoutParams = (LayoutParams) U2.getLayoutParams();
                if (layoutParams.f15644f) {
                    int i3 = 0;
                    while (i3 < this.s) {
                        if (this.t[i3].f15649a.size() != 1) {
                            i3++;
                        } else {
                            return;
                        }
                    }
                    for (int i4 = 0; i4 < this.s; i4++) {
                        this.t[i4].y();
                    }
                } else if (layoutParams.f15643e.f15649a.size() != 1) {
                    layoutParams.f15643e.y();
                } else {
                    return;
                }
                J1(U2, recycler);
            } else {
                return;
            }
        }
    }

    private void n3() {
        if (this.v.l() != 1073741824) {
            int V2 = V();
            float f2 = 0.0f;
            for (int i2 = 0; i2 < V2; i2++) {
                View U2 = U(i2);
                float e2 = (float) this.v.e(U2);
                if (e2 >= f2) {
                    if (((LayoutParams) U2.getLayoutParams()).k()) {
                        e2 = (e2 * 1.0f) / ((float) this.s);
                    }
                    f2 = Math.max(f2, e2);
                }
            }
            int i3 = this.x;
            int round = Math.round(f2 * ((float) this.s));
            if (this.v.l() == Integer.MIN_VALUE) {
                round = Math.min(round, this.v.o());
            }
            B3(round);
            if (this.x != i3) {
                for (int i4 = 0; i4 < V2; i4++) {
                    View U3 = U(i4);
                    LayoutParams layoutParams = (LayoutParams) U3.getLayoutParams();
                    if (!layoutParams.f15644f) {
                        if (!d3() || this.w != 1) {
                            int i5 = layoutParams.f15643e.f15653e;
                            int i6 = this.w;
                            int i7 = (this.x * i5) - (i5 * i3);
                            if (i6 == 1) {
                                U3.offsetLeftAndRight(i7);
                            } else {
                                U3.offsetTopAndBottom(i7);
                            }
                        } else {
                            int i8 = this.s;
                            int i9 = layoutParams.f15643e.f15653e;
                            U3.offsetLeftAndRight(((-((i8 - 1) - i9)) * this.x) - ((-((i8 - 1) - i9)) * i3));
                        }
                    }
                }
            }
        }
    }

    private void o2(View view) {
        for (int i2 = this.s - 1; i2 >= 0; i2--) {
            this.t[i2].a(view);
        }
    }

    private void o3() {
        this.A = (this.w == 1 || !d3()) ? this.z : !this.z;
    }

    private void p2(AnchorInfo anchorInfo) {
        boolean z2;
        SavedState savedState = this.I;
        int i2 = savedState.Y;
        if (i2 > 0) {
            if (i2 == this.s) {
                for (int i3 = 0; i3 < this.s; i3++) {
                    this.t[i3].e();
                    SavedState savedState2 = this.I;
                    int i4 = savedState2.Z[i3];
                    if (i4 != Integer.MIN_VALUE) {
                        i4 += savedState2.b3 ? this.u.i() : this.u.n();
                    }
                    this.t[i3].A(i4);
                }
            } else {
                savedState.b();
                SavedState savedState3 = this.I;
                savedState3.s = savedState3.X;
            }
        }
        SavedState savedState4 = this.I;
        this.H = savedState4.c3;
        u3(savedState4.a3);
        o3();
        SavedState savedState5 = this.I;
        int i5 = savedState5.s;
        if (i5 != -1) {
            this.C = i5;
            z2 = savedState5.b3;
        } else {
            z2 = this.A;
        }
        anchorInfo.f15637c = z2;
        if (savedState5.X2 > 1) {
            LazySpanLookup lazySpanLookup = this.E;
            lazySpanLookup.f15646a = savedState5.Y2;
            lazySpanLookup.f15647b = savedState5.Z2;
        }
    }

    private void s2(View view, LayoutParams layoutParams, LayoutState layoutState) {
        if (layoutState.f15399e == 1) {
            if (layoutParams.f15644f) {
                o2(view);
            } else {
                layoutParams.f15643e.a(view);
            }
        } else if (layoutParams.f15644f) {
            j3(view);
        } else {
            layoutParams.f15643e.z(view);
        }
    }

    private void s3(int i2) {
        LayoutState layoutState = this.y;
        layoutState.f15399e = i2;
        int i3 = 1;
        if (this.A != (i2 == -1)) {
            i3 = -1;
        }
        layoutState.f15398d = i3;
    }

    private int t2(int i2) {
        if (V() == 0) {
            return this.A ? 1 : -1;
        }
        return (i2 < P2()) != this.A ? -1 : 1;
    }

    private boolean v2(Span span) {
        if (this.A) {
            if (span.p() < this.u.i()) {
                ArrayList<View> arrayList = span.f15649a;
                return !span.s(arrayList.get(arrayList.size() - 1)).f15644f;
            }
        } else if (span.t() > this.u.n()) {
            return !span.s(span.f15649a.get(0)).f15644f;
        }
        return false;
    }

    private int w2(RecyclerView.State state) {
        if (V() == 0) {
            return 0;
        }
        return ScrollbarHelper.a(state, this.u, H2(!this.N), G2(!this.N), this, this.N);
    }

    private void w3(int i2, int i3) {
        for (int i4 = 0; i4 < this.s; i4++) {
            if (!this.t[i4].f15649a.isEmpty()) {
                C3(this.t[i4], i2, i3);
            }
        }
    }

    private int x2(RecyclerView.State state) {
        if (V() == 0) {
            return 0;
        }
        return ScrollbarHelper.b(state, this.u, H2(!this.N), G2(!this.N), this, this.N, this.A);
    }

    private boolean x3(RecyclerView.State state, AnchorInfo anchorInfo) {
        boolean z2 = this.G;
        int d2 = state.d();
        anchorInfo.f15635a = z2 ? L2(d2) : F2(d2);
        anchorInfo.f15636b = Integer.MIN_VALUE;
        return true;
    }

    private int y2(RecyclerView.State state) {
        if (V() == 0) {
            return 0;
        }
        return ScrollbarHelper.c(state, this.u, H2(!this.N), G2(!this.N), this, this.N);
    }

    private int z2(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 17 ? i2 != 33 ? i2 != 66 ? (i2 == 130 && this.w == 1) ? 1 : Integer.MIN_VALUE : this.w == 0 ? 1 : Integer.MIN_VALUE : this.w == 1 ? -1 : Integer.MIN_VALUE : this.w == 0 ? -1 : Integer.MIN_VALUE : (this.w != 1 && d3()) ? -1 : 1 : (this.w != 1 && d3()) ? 1 : -1;
    }

    public int A(RecyclerView.State state) {
        return y2(state);
    }

    public int B(RecyclerView.State state) {
        return w2(state);
    }

    /* access modifiers changed from: package-private */
    public void B3(int i2) {
        this.x = i2 / this.s;
        this.J = View.MeasureSpec.makeMeasureSpec(i2, this.v.l());
    }

    public int C(RecyclerView.State state) {
        return x2(state);
    }

    public int D(RecyclerView.State state) {
        return y2(state);
    }

    public int[] E2(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.s];
        } else if (iArr.length < this.s) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.s + ", array size:" + iArr.length);
        }
        for (int i2 = 0; i2 < this.s; i2++) {
            iArr[i2] = this.t[i2].f();
        }
        return iArr;
    }

    /* access modifiers changed from: package-private */
    public View G2(boolean z2) {
        int n2 = this.u.n();
        int i2 = this.u.i();
        View view = null;
        for (int V2 = V() - 1; V2 >= 0; V2--) {
            View U2 = U(V2);
            int g2 = this.u.g(U2);
            int d2 = this.u.d(U2);
            if (d2 > n2 && g2 < i2) {
                if (d2 <= i2 || !z2) {
                    return U2;
                }
                if (view == null) {
                    view = U2;
                }
            }
        }
        return view;
    }

    /* access modifiers changed from: package-private */
    public View H2(boolean z2) {
        int n2 = this.u.n();
        int i2 = this.u.i();
        int V2 = V();
        View view = null;
        for (int i3 = 0; i3 < V2; i3++) {
            View U2 = U(i3);
            int g2 = this.u.g(U2);
            if (this.u.d(U2) > n2 && g2 < i2) {
                if (g2 >= n2 || !z2) {
                    return U2;
                }
                if (view == null) {
                    view = U2;
                }
            }
        }
        return view;
    }

    /* access modifiers changed from: package-private */
    public int I2() {
        View G2 = this.A ? G2(true) : H2(true);
        if (G2 == null) {
            return -1;
        }
        return w0(G2);
    }

    public boolean J0() {
        return this.F != 0;
    }

    public int[] J2(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.s];
        } else if (iArr.length < this.s) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.s + ", array size:" + iArr.length);
        }
        for (int i2 = 0; i2 < this.s; i2++) {
            iArr[i2] = this.t[i2].h();
        }
        return iArr;
    }

    public int[] K2(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.s];
        } else if (iArr.length < this.s) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.s + ", array size:" + iArr.length);
        }
        for (int i2 = 0; i2 < this.s; i2++) {
            iArr[i2] = this.t[i2].i();
        }
        return iArr;
    }

    public int[] M2(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.s];
        } else if (iArr.length < this.s) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.s + ", array size:" + iArr.length);
        }
        for (int i2 = 0; i2 < this.s; i2++) {
            iArr[i2] = this.t[i2].k();
        }
        return iArr;
    }

    public RecyclerView.LayoutParams P() {
        return this.w == 0 ? new LayoutParams(-2, -1) : new LayoutParams(-1, -2);
    }

    /* access modifiers changed from: package-private */
    public int P2() {
        if (V() == 0) {
            return 0;
        }
        return w0(U(0));
    }

    public RecyclerView.LayoutParams Q(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public int Q2() {
        return this.F;
    }

    public RecyclerView.LayoutParams R(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: package-private */
    public int R2() {
        int V2 = V();
        if (V2 == 0) {
            return 0;
        }
        return w0(U(V2 - 1));
    }

    public int U1(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return p3(i2, recycler, state);
    }

    public void V1(int i2) {
        SavedState savedState = this.I;
        if (!(savedState == null || savedState.s == i2)) {
            savedState.a();
        }
        this.C = i2;
        this.D = Integer.MIN_VALUE;
        R1();
    }

    public int W1(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return p3(i2, recycler, state);
    }

    public void X0(int i2) {
        super.X0(i2);
        for (int i3 = 0; i3 < this.s; i3++) {
            this.t[i3].w(i2);
        }
    }

    public int X2() {
        return this.w;
    }

    public void Y0(int i2) {
        super.Y0(i2);
        for (int i3 = 0; i3 < this.s; i3++) {
            this.t[i3].w(i2);
        }
    }

    public boolean Y2() {
        return this.z;
    }

    public void Z0(@Nullable RecyclerView.Adapter adapter, @Nullable RecyclerView.Adapter adapter2) {
        this.E.b();
        for (int i2 = 0; i2 < this.s; i2++) {
            this.t[i2].e();
        }
    }

    public int Z2() {
        return this.s;
    }

    public PointF a(int i2) {
        int t2 = t2(i2);
        PointF pointF = new PointF();
        if (t2 == 0) {
            return null;
        }
        if (this.w == 0) {
            pointF.x = (float) t2;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = (float) t2;
        }
        return pointF;
    }

    /* access modifiers changed from: package-private */
    public View b3() {
        int i2;
        int V2 = V();
        int i3 = V2 - 1;
        BitSet bitSet = new BitSet(this.s);
        bitSet.set(0, this.s, true);
        int i4 = -1;
        char c2 = (this.w != 1 || !d3()) ? (char) 65535 : 1;
        if (this.A) {
            V2 = -1;
        } else {
            i3 = 0;
        }
        if (i3 < V2) {
            i4 = 1;
        }
        while (i3 != V2) {
            View U2 = U(i3);
            LayoutParams layoutParams = (LayoutParams) U2.getLayoutParams();
            if (bitSet.get(layoutParams.f15643e.f15653e)) {
                if (v2(layoutParams.f15643e)) {
                    return U2;
                }
                bitSet.clear(layoutParams.f15643e.f15653e);
            }
            if (!layoutParams.f15644f && (i2 = i3 + i4) != V2) {
                View U3 = U(i2);
                if (this.A) {
                    int d2 = this.u.d(U2);
                    int d3 = this.u.d(U3);
                    if (d2 < d3) {
                        return U2;
                    }
                    if (d2 != d3) {
                        continue;
                    }
                } else {
                    int g2 = this.u.g(U2);
                    int g3 = this.u.g(U3);
                    if (g2 > g3) {
                        return U2;
                    }
                    if (g2 != g3) {
                        continue;
                    }
                }
                if ((layoutParams.f15643e.f15653e - ((LayoutParams) U3.getLayoutParams()).f15643e.f15653e < 0) != (c2 < 0)) {
                    return U2;
                }
            }
            i3 += i4;
        }
        return null;
    }

    public void c2(Rect rect, int i2, int i3) {
        int i4;
        int i5;
        int s0 = s0() + t0();
        int v0 = v0() + q0();
        if (this.w == 1) {
            i5 = RecyclerView.LayoutManager.v(i3, rect.height() + v0, o0());
            i4 = RecyclerView.LayoutManager.v(i2, (this.x * this.s) + s0, p0());
        } else {
            i4 = RecyclerView.LayoutManager.v(i2, rect.width() + s0, p0());
            i5 = RecyclerView.LayoutManager.v(i3, (this.x * this.s) + v0, o0());
        }
        b2(i4, i5);
    }

    public void c3() {
        this.E.b();
        R1();
    }

    public void d1(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.d1(recyclerView, recycler);
        L1(this.P);
        for (int i2 = 0; i2 < this.s; i2++) {
            this.t[i2].e();
        }
        recyclerView.requestLayout();
    }

    /* access modifiers changed from: package-private */
    public boolean d3() {
        return m0() == 1;
    }

    @Nullable
    public View e1(View view, int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        View N2;
        View r;
        if (V() == 0 || (N2 = N(view)) == null) {
            return null;
        }
        o3();
        int z2 = z2(i2);
        if (z2 == Integer.MIN_VALUE) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) N2.getLayoutParams();
        boolean z3 = layoutParams.f15644f;
        Span span = layoutParams.f15643e;
        int R2 = z2 == 1 ? R2() : P2();
        A3(R2, state);
        s3(z2);
        LayoutState layoutState = this.y;
        layoutState.f15397c = layoutState.f15398d + R2;
        layoutState.f15396b = (int) (((float) this.u.o()) * Y);
        LayoutState layoutState2 = this.y;
        layoutState2.f15402h = true;
        layoutState2.f15395a = false;
        D2(recycler, layoutState2, state);
        this.G = this.A;
        if (!z3 && (r = span.r(R2, z2)) != null && r != N2) {
            return r;
        }
        if (h3(z2)) {
            for (int i3 = this.s - 1; i3 >= 0; i3--) {
                View r2 = this.t[i3].r(R2, z2);
                if (r2 != null && r2 != N2) {
                    return r2;
                }
            }
        } else {
            for (int i4 = 0; i4 < this.s; i4++) {
                View r3 = this.t[i4].r(R2, z2);
                if (r3 != null && r3 != N2) {
                    return r3;
                }
            }
        }
        boolean z4 = (this.z ^ true) == (z2 == -1);
        if (!z3) {
            View O2 = O(z4 ? span.g() : span.j());
            if (!(O2 == null || O2 == N2)) {
                return O2;
            }
        }
        if (h3(z2)) {
            for (int i5 = this.s - 1; i5 >= 0; i5--) {
                if (i5 != span.f15653e) {
                    Span[] spanArr = this.t;
                    View O3 = O(z4 ? spanArr[i5].g() : spanArr[i5].j());
                    if (!(O3 == null || O3 == N2)) {
                        return O3;
                    }
                }
            }
        } else {
            for (int i6 = 0; i6 < this.s; i6++) {
                Span[] spanArr2 = this.t;
                View O4 = O(z4 ? spanArr2[i6].g() : spanArr2[i6].j());
                if (O4 != null && O4 != N2) {
                    return O4;
                }
            }
        }
        return null;
    }

    public void f1(AccessibilityEvent accessibilityEvent) {
        super.f1(accessibilityEvent);
        if (V() > 0) {
            View H2 = H2(false);
            View G2 = G2(false);
            if (H2 != null && G2 != null) {
                int w0 = w0(H2);
                int w02 = w0(G2);
                if (w0 < w02) {
                    accessibilityEvent.setFromIndex(w0);
                    accessibilityEvent.setToIndex(w02);
                    return;
                }
                accessibilityEvent.setFromIndex(w02);
                accessibilityEvent.setToIndex(w0);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void i3(int i2, RecyclerView.State state) {
        int i3;
        int i4;
        if (i2 > 0) {
            i4 = R2();
            i3 = 1;
        } else {
            i4 = P2();
            i3 = -1;
        }
        this.y.f15395a = true;
        A3(i4, state);
        s3(i3);
        LayoutState layoutState = this.y;
        layoutState.f15397c = i4 + layoutState.f15398d;
        layoutState.f15396b = Math.abs(i2);
    }

    public void j2(RecyclerView recyclerView, RecyclerView.State state, int i2) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.q(i2);
        k2(linearSmoothScroller);
    }

    public void m1(RecyclerView recyclerView, int i2, int i3) {
        a3(i2, i3, 1);
    }

    public void n(String str) {
        if (this.I == null) {
            super.n(str);
        }
    }

    public void n1(RecyclerView recyclerView) {
        this.E.b();
        R1();
    }

    public boolean n2() {
        return this.I == null;
    }

    public void o1(RecyclerView recyclerView, int i2, int i3, int i4) {
        a3(i2, i3, 8);
    }

    public void p1(RecyclerView recyclerView, int i2, int i3) {
        a3(i2, i3, 2);
    }

    /* access modifiers changed from: package-private */
    public int p3(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (V() == 0 || i2 == 0) {
            return 0;
        }
        i3(i2, state);
        int D2 = D2(recycler, this.y, state);
        if (this.y.f15396b >= D2) {
            i2 = i2 < 0 ? -D2 : D2;
        }
        this.u.t(-i2);
        this.G = this.A;
        LayoutState layoutState = this.y;
        layoutState.f15396b = 0;
        k3(recycler, layoutState);
        return i2;
    }

    /* access modifiers changed from: package-private */
    public boolean q2() {
        int q = this.t[0].q(Integer.MIN_VALUE);
        for (int i2 = 1; i2 < this.s; i2++) {
            if (this.t[i2].q(Integer.MIN_VALUE) != q) {
                return false;
            }
        }
        return true;
    }

    public void q3(int i2, int i3) {
        SavedState savedState = this.I;
        if (savedState != null) {
            savedState.a();
        }
        this.C = i2;
        this.D = i3;
        R1();
    }

    public void r1(RecyclerView recyclerView, int i2, int i3, Object obj) {
        a3(i2, i3, 4);
    }

    /* access modifiers changed from: package-private */
    public boolean r2() {
        int u2 = this.t[0].u(Integer.MIN_VALUE);
        for (int i2 = 1; i2 < this.s; i2++) {
            if (this.t[i2].u(Integer.MIN_VALUE) != u2) {
                return false;
            }
        }
        return true;
    }

    public void r3(int i2) {
        n((String) null);
        if (i2 != this.F) {
            if (i2 == 0 || i2 == 2) {
                this.F = i2;
                R1();
                return;
            }
            throw new IllegalArgumentException("invalid gap strategy. Must be GAP_HANDLING_NONE or GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS");
        }
    }

    public boolean s() {
        return this.w == 0;
    }

    public void s1(RecyclerView.Recycler recycler, RecyclerView.State state) {
        g3(recycler, state, true);
    }

    public boolean t() {
        return this.w == 1;
    }

    public void t1(RecyclerView.State state) {
        super.t1(state);
        this.C = -1;
        this.D = Integer.MIN_VALUE;
        this.I = null;
        this.L.c();
    }

    public void t3(int i2) {
        if (i2 == 0 || i2 == 1) {
            n((String) null);
            if (i2 != this.w) {
                this.w = i2;
                OrientationHelper orientationHelper = this.u;
                this.u = this.v;
                this.v = orientationHelper;
                R1();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    public boolean u(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* access modifiers changed from: package-private */
    public boolean u2() {
        int i2;
        int i3;
        if (V() == 0 || this.F == 0 || !I0()) {
            return false;
        }
        if (this.A) {
            i3 = R2();
            i2 = P2();
        } else {
            i3 = P2();
            i2 = R2();
        }
        if (i3 == 0 && b3() != null) {
            this.E.b();
        } else if (!this.M) {
            return false;
        } else {
            int i4 = this.A ? -1 : 1;
            int i5 = i2 + 1;
            LazySpanLookup.FullSpanItem e2 = this.E.e(i3, i5, i4, true);
            if (e2 == null) {
                this.M = false;
                this.E.d(i5);
                return false;
            }
            LazySpanLookup.FullSpanItem e3 = this.E.e(i3, e2.s, i4 * -1, true);
            if (e3 == null) {
                this.E.d(e2.s);
            } else {
                this.E.d(e3.s + 1);
            }
        }
        S1();
        R1();
        return true;
    }

    public void u3(boolean z2) {
        n((String) null);
        SavedState savedState = this.I;
        if (!(savedState == null || savedState.a3 == z2)) {
            savedState.a3 = z2;
        }
        this.z = z2;
        R1();
    }

    public void v3(int i2) {
        n((String) null);
        if (i2 != this.s) {
            c3();
            this.s = i2;
            this.B = new BitSet(this.s);
            this.t = new Span[this.s];
            for (int i3 = 0; i3 < this.s; i3++) {
                this.t[i3] = new Span(i3);
            }
            R1();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void w(int i2, int i3, RecyclerView.State state, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int q;
        int i4;
        if (this.w != 0) {
            i2 = i3;
        }
        if (V() != 0 && i2 != 0) {
            i3(i2, state);
            int[] iArr = this.O;
            if (iArr == null || iArr.length < this.s) {
                this.O = new int[this.s];
            }
            int i5 = 0;
            for (int i6 = 0; i6 < this.s; i6++) {
                LayoutState layoutState = this.y;
                if (layoutState.f15398d == -1) {
                    q = layoutState.f15400f;
                    i4 = this.t[i6].u(q);
                } else {
                    q = this.t[i6].q(layoutState.f15401g);
                    i4 = this.y.f15401g;
                }
                int i7 = q - i4;
                if (i7 >= 0) {
                    this.O[i5] = i7;
                    i5++;
                }
            }
            Arrays.sort(this.O, 0, i5);
            for (int i8 = 0; i8 < i5 && this.y.a(state); i8++) {
                layoutPrefetchRegistry.a(this.y.f15397c, this.O[i8]);
                LayoutState layoutState2 = this.y;
                layoutState2.f15397c += layoutState2.f15398d;
            }
        }
    }

    public void x1(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.I = savedState;
            if (this.C != -1) {
                savedState.a();
                this.I.b();
            }
            R1();
        }
    }

    public int y(RecyclerView.State state) {
        return w2(state);
    }

    public Parcelable y1() {
        int i2;
        int n2;
        int[] iArr;
        if (this.I != null) {
            return new SavedState(this.I);
        }
        SavedState savedState = new SavedState();
        savedState.a3 = this.z;
        savedState.b3 = this.G;
        savedState.c3 = this.H;
        LazySpanLookup lazySpanLookup = this.E;
        if (lazySpanLookup == null || (iArr = lazySpanLookup.f15646a) == null) {
            savedState.X2 = 0;
        } else {
            savedState.Y2 = iArr;
            savedState.X2 = iArr.length;
            savedState.Z2 = lazySpanLookup.f15647b;
        }
        if (V() > 0) {
            savedState.s = this.G ? R2() : P2();
            savedState.X = I2();
            int i3 = this.s;
            savedState.Y = i3;
            savedState.Z = new int[i3];
            for (int i4 = 0; i4 < this.s; i4++) {
                if (this.G) {
                    i2 = this.t[i4].q(Integer.MIN_VALUE);
                    if (i2 != Integer.MIN_VALUE) {
                        n2 = this.u.i();
                    } else {
                        savedState.Z[i4] = i2;
                    }
                } else {
                    i2 = this.t[i4].u(Integer.MIN_VALUE);
                    if (i2 != Integer.MIN_VALUE) {
                        n2 = this.u.n();
                    } else {
                        savedState.Z[i4] = i2;
                    }
                }
                i2 -= n2;
                savedState.Z[i4] = i2;
            }
        } else {
            savedState.s = -1;
            savedState.X = -1;
            savedState.Y = 0;
        }
        return savedState;
    }

    /* access modifiers changed from: package-private */
    public boolean y3(RecyclerView.State state, AnchorInfo anchorInfo) {
        int i2;
        int n2;
        int g2;
        boolean z2 = false;
        if (!state.j() && (i2 = this.C) != -1) {
            if (i2 < 0 || i2 >= state.d()) {
                this.C = -1;
                this.D = Integer.MIN_VALUE;
            } else {
                SavedState savedState = this.I;
                if (savedState == null || savedState.s == -1 || savedState.Y < 1) {
                    View O2 = O(this.C);
                    if (O2 != null) {
                        anchorInfo.f15635a = this.A ? R2() : P2();
                        if (this.D != Integer.MIN_VALUE) {
                            if (anchorInfo.f15637c) {
                                n2 = this.u.i() - this.D;
                                g2 = this.u.d(O2);
                            } else {
                                n2 = this.u.n() + this.D;
                                g2 = this.u.g(O2);
                            }
                            anchorInfo.f15636b = n2 - g2;
                            return true;
                        } else if (this.u.e(O2) > this.u.o()) {
                            anchorInfo.f15636b = anchorInfo.f15637c ? this.u.i() : this.u.n();
                            return true;
                        } else {
                            int g3 = this.u.g(O2) - this.u.n();
                            if (g3 < 0) {
                                anchorInfo.f15636b = -g3;
                                return true;
                            }
                            int i3 = this.u.i() - this.u.d(O2);
                            if (i3 < 0) {
                                anchorInfo.f15636b = i3;
                                return true;
                            }
                            anchorInfo.f15636b = Integer.MIN_VALUE;
                        }
                    } else {
                        int i4 = this.C;
                        anchorInfo.f15635a = i4;
                        int i5 = this.D;
                        if (i5 == Integer.MIN_VALUE) {
                            if (t2(i4) == 1) {
                                z2 = true;
                            }
                            anchorInfo.f15637c = z2;
                            anchorInfo.a();
                        } else {
                            anchorInfo.b(i5);
                        }
                        anchorInfo.f15638d = true;
                    }
                } else {
                    anchorInfo.f15636b = Integer.MIN_VALUE;
                    anchorInfo.f15635a = this.C;
                }
                return true;
            }
        }
        return false;
    }

    public int z(RecyclerView.State state) {
        return x2(state);
    }

    public void z1(int i2) {
        if (i2 == 0) {
            u2();
        }
    }

    /* access modifiers changed from: package-private */
    public void z3(RecyclerView.State state, AnchorInfo anchorInfo) {
        if (!y3(state, anchorInfo) && !x3(state, anchorInfo)) {
            anchorInfo.a();
            anchorInfo.f15635a = 0;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        RecyclerView.LayoutManager.Properties x0 = RecyclerView.LayoutManager.x0(context, attributeSet, i2, i3);
        t3(x0.f15530a);
        v3(x0.f15531b);
        u3(x0.f15532c);
        this.y = new LayoutState();
        C2();
    }
}
