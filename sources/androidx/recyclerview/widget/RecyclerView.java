package androidx.recyclerview.widget;

import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.os.TraceCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.EdgeEffectCompat;
import androidx.customview.poolingcontainer.PoolingContainer;
import androidx.customview.view.AbsSavedState;
import androidx.media3.extractor.ts.TsExtractor;
import androidx.recyclerview.R;

import com.dd.plist.ASCIIPropertyListParser;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;

public class RecyclerView extends ViewGroup implements ScrollingView, NestedScrollingChild2, NestedScrollingChild3 {
    private static final int[] A4 = {16843830};
    private static final float B4 = 0.015f;
    private static final float C4 = 0.35f;
    private static final float D4 = ((float) (Math.log(0.78d) / Math.log(0.9d)));
    static final boolean E4 = false;
    static final boolean F4;
    static final boolean G4 = true;
    static final boolean H4 = true;
    private static final boolean I4 = false;
    private static final boolean J4 = false;
    private static final float K4 = 4.0f;
    static final boolean L4 = false;
    public static final int M4 = 0;
    public static final int N4 = 1;
    static final int O4 = 1;
    public static final int P4 = -1;
    public static final long Q4 = -1;
    public static final int R4 = -1;
    public static final int S4 = 0;
    public static final int T4 = 1;
    public static final int U4 = Integer.MIN_VALUE;
    static final int V4 = 2000;
    static final String W4 = "RV Scroll";
    private static final String X4 = "RV OnLayout";
    private static final String Y4 = "RV FullInvalidate";
    private static final String Z4 = "RV PartialInvalidate";
    static final String a5 = "RV OnBindView";
    static final String b5 = "RV Prefetch";
    static final String c5 = "RV Nested Prefetch";
    static final String d5 = "RV CreateView";
    private static final Class<?>[] e5;
    private static final int f5 = -1;
    public static final int g5 = 0;
    public static final int h5 = 1;
    public static final int i5 = 2;
    static final long j5 = Long.MAX_VALUE;
    static final Interpolator k5 = new Interpolator() {
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    };
    static final StretchEdgeEffectFactory l5 = new StretchEdgeEffectFactory();
    static final String w4 = "RecyclerView";
    static boolean x4 = false;
    static boolean y4 = false;
    static final boolean z4 = false;
    private List<OnChildAttachStateChangeListener> A3;
    boolean B3;
    boolean C3;
    private int D3;
    private int E3;
    @NonNull
    private EdgeEffectFactory F3;
    private EdgeEffect G3;
    private EdgeEffect H3;
    private EdgeEffect I3;
    private EdgeEffect J3;
    ItemAnimator K3;
    private int L3;
    private int M3;
    private VelocityTracker N3;
    private int O3;
    private int P3;
    private int Q3;
    private int R3;
    private int S3;
    private OnFlingListener T3;
    private final int U3;
    private final int V3;
    private float W3;
    private final RecyclerViewDataObserver X2;
    private float X3;
    final Recycler Y2;
    private boolean Y3;
    SavedState Z2;
    final ViewFlinger Z3;
    AdapterHelper a3;
    GapWorker a4;
    ChildHelper b3;
    GapWorker.LayoutPrefetchRegistryImpl b4;
    final ViewInfoStore c3;
    final State c4;
    boolean d3;
    private OnScrollListener d4;
    final Runnable e3;
    private List<OnScrollListener> e4;
    final Rect f3;
    boolean f4;
    private final Rect g3;
    boolean g4;
    final RectF h3;
    private ItemAnimator.ItemAnimatorListener h4;
    Adapter i3;
    boolean i4;
    @VisibleForTesting
    LayoutManager j3;
    RecyclerViewAccessibilityDelegate j4;
    RecyclerListener k3;
    private ChildDrawingOrderCallback k4;
    final List<RecyclerListener> l3;
    private final int[] l4;
    final ArrayList<ItemDecoration> m3;
    private NestedScrollingChildHelper m4;
    private final ArrayList<OnItemTouchListener> n3;
    private final int[] n4;
    private OnItemTouchListener o3;
    private final int[] o4;
    boolean p3;
    final int[] p4;
    boolean q3;
    @VisibleForTesting
    final List<ViewHolder> q4;
    boolean r3;
    private Runnable r4;
    private final float s;
    @VisibleForTesting
    boolean s3;
    private boolean s4;
    private int t3;
    private int t4;
    boolean u3;
    private int u4;
    boolean v3;
    private final ViewInfoStore.ProcessCallback v4;
    private boolean w3;
    private int x3;
    boolean y3;
    private final AccessibilityManager z3;

    /* renamed from: androidx.recyclerview.widget.RecyclerView$7  reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f15489a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                androidx.recyclerview.widget.RecyclerView$Adapter$StateRestorationPolicy[] r0 = androidx.recyclerview.widget.RecyclerView.Adapter.StateRestorationPolicy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f15489a = r0
                androidx.recyclerview.widget.RecyclerView$Adapter$StateRestorationPolicy r1 = androidx.recyclerview.widget.RecyclerView.Adapter.StateRestorationPolicy.PREVENT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f15489a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.recyclerview.widget.RecyclerView$Adapter$StateRestorationPolicy r1 = androidx.recyclerview.widget.RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.AnonymousClass7.<clinit>():void");
        }
    }

    public static abstract class Adapter<VH extends ViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        private final AdapterDataObservable f15490a = new AdapterDataObservable();

        /* renamed from: b  reason: collision with root package name */
        private boolean f15491b = false;

        /* renamed from: c  reason: collision with root package name */
        private StateRestorationPolicy f15492c = StateRestorationPolicy.ALLOW;

        public enum StateRestorationPolicy {
            ALLOW,
            PREVENT_WHEN_EMPTY,
            PREVENT
        }

        public int A(@NonNull Adapter<? extends ViewHolder> adapter, @NonNull ViewHolder viewHolder, int i2) {
            if (adapter == this) {
                return i2;
            }
            return -1;
        }

        public long B(int i2) {
            return -1;
        }

        public int C(int i2) {
            return 0;
        }

        @NonNull
        public final StateRestorationPolicy D() {
            return this.f15492c;
        }

        public final boolean E() {
            return this.f15490a.a();
        }

        public final boolean F() {
            return this.f15491b;
        }

        public final void G() {
            this.f15490a.b();
        }

        public final void H(int i2) {
            this.f15490a.d(i2, 1);
        }

        public final void I(int i2, @Nullable Object obj) {
            this.f15490a.e(i2, 1, obj);
        }

        public final void J(int i2) {
            this.f15490a.f(i2, 1);
        }

        public final void K(int i2, int i3) {
            this.f15490a.c(i2, i3);
        }

        public final void L(int i2, int i3) {
            this.f15490a.d(i2, i3);
        }

        public final void M(int i2, int i3, @Nullable Object obj) {
            this.f15490a.e(i2, i3, obj);
        }

        public final void N(int i2, int i3) {
            this.f15490a.f(i2, i3);
        }

        public final void O(int i2, int i3) {
            this.f15490a.g(i2, i3);
        }

        public final void P(int i2) {
            this.f15490a.g(i2, 1);
        }

        public void Q(@NonNull RecyclerView recyclerView) {
        }

        public abstract void R(@NonNull VH vh, int i2);

        public void S(@NonNull VH vh, int i2, @NonNull List<Object> list) {
            R(vh, i2);
        }

        @NonNull
        public abstract VH T(@NonNull ViewGroup viewGroup, int i2);

        public void U(@NonNull RecyclerView recyclerView) {
        }

        public boolean V(@NonNull VH vh) {
            return false;
        }

        public void W(@NonNull VH vh) {
        }

        public void X(@NonNull VH vh) {
        }

        public void Y(@NonNull VH vh) {
        }

        public void Z(@NonNull AdapterDataObserver adapterDataObserver) {
            this.f15490a.registerObserver(adapterDataObserver);
        }

        public void a0(boolean z) {
            if (!E()) {
                this.f15491b = z;
                return;
            }
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }

        public abstract int b();

        public void b0(@NonNull StateRestorationPolicy stateRestorationPolicy) {
            this.f15492c = stateRestorationPolicy;
            this.f15490a.h();
        }

        public void c0(@NonNull AdapterDataObserver adapterDataObserver) {
            this.f15490a.unregisterObserver(adapterDataObserver);
        }

        public final void x(@NonNull VH vh, int i2) {
            boolean z = vh.s == null;
            if (z) {
                vh.f15589c = i2;
                if (F()) {
                    vh.f15591e = B(i2);
                }
                vh.a0(1, TIFFConstants.d2);
                TraceCompat.b(RecyclerView.a5);
            }
            vh.s = this;
            if (RecyclerView.x4) {
                if (vh.f15587a.getParent() == null && ViewCompat.R0(vh.f15587a) != vh.S()) {
                    throw new IllegalStateException("Temp-detached state out of sync with reality. holder.isTmpDetached(): " + vh.S() + ", attached to window: " + ViewCompat.R0(vh.f15587a) + ", holder: " + vh);
                } else if (vh.f15587a.getParent() == null && ViewCompat.R0(vh.f15587a)) {
                    throw new IllegalStateException("Attempting to bind attached holder with no parent (AKA temp detached): " + vh);
                }
            }
            S(vh, i2, vh.J());
            if (z) {
                vh.u();
                ViewGroup.LayoutParams layoutParams = vh.f15587a.getLayoutParams();
                if (layoutParams instanceof LayoutParams) {
                    ((LayoutParams) layoutParams).f15536c = true;
                }
                TraceCompat.d();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean y() {
            int i2 = AnonymousClass7.f15489a[this.f15492c.ordinal()];
            if (i2 != 1) {
                return i2 != 2 || b() > 0;
            }
            return false;
        }

        @NonNull
        public final VH z(@NonNull ViewGroup viewGroup, int i2) {
            try {
                TraceCompat.b(RecyclerView.d5);
                VH T = T(viewGroup, i2);
                if (T.f15587a.getParent() == null) {
                    T.f15592f = i2;
                    return T;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            } finally {
                TraceCompat.d();
            }
        }
    }

    static class AdapterDataObservable extends Observable<AdapterDataObserver> {
        AdapterDataObservable() {
        }

        public boolean a() {
            return !this.mObservers.isEmpty();
        }

        public void b() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).a();
            }
        }

        public void c(int i2, int i3) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).e(i2, i3, 1);
            }
        }

        public void d(int i2, int i3) {
            e(i2, i3, (Object) null);
        }

        public void e(int i2, int i3, @Nullable Object obj) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).c(i2, i3, obj);
            }
        }

        public void f(int i2, int i3) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).d(i2, i3);
            }
        }

        public void g(int i2, int i3) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).f(i2, i3);
            }
        }

        public void h() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).g();
            }
        }
    }

    public static abstract class AdapterDataObserver {
        public void a() {
        }

        public void b(int i2, int i3) {
        }

        public void c(int i2, int i3, @Nullable Object obj) {
            b(i2, i3);
        }

        public void d(int i2, int i3) {
        }

        public void e(int i2, int i3, int i4) {
        }

        public void f(int i2, int i3) {
        }

        public void g() {
        }
    }

    public interface ChildDrawingOrderCallback {
        int a(int i2, int i3);
    }

    public static class EdgeEffectFactory {

        /* renamed from: a  reason: collision with root package name */
        public static final int f15493a = 0;

        /* renamed from: b  reason: collision with root package name */
        public static final int f15494b = 1;

        /* renamed from: c  reason: collision with root package name */
        public static final int f15495c = 2;

        /* renamed from: d  reason: collision with root package name */
        public static final int f15496d = 3;

        @Retention(RetentionPolicy.SOURCE)
        public @interface EdgeDirection {
        }

        /* access modifiers changed from: protected */
        @NonNull
        public EdgeEffect a(@NonNull RecyclerView recyclerView, int i2) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static abstract class ItemAnimator {

        /* renamed from: g  reason: collision with root package name */
        public static final int f15497g = 2;

        /* renamed from: h  reason: collision with root package name */
        public static final int f15498h = 8;

        /* renamed from: i  reason: collision with root package name */
        public static final int f15499i = 4;

        /* renamed from: j  reason: collision with root package name */
        public static final int f15500j = 2048;

        /* renamed from: k  reason: collision with root package name */
        public static final int f15501k = 4096;

        /* renamed from: a  reason: collision with root package name */
        private ItemAnimatorListener f15502a = null;

        /* renamed from: b  reason: collision with root package name */
        private ArrayList<ItemAnimatorFinishedListener> f15503b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        private long f15504c = 120;

        /* renamed from: d  reason: collision with root package name */
        private long f15505d = 120;

        /* renamed from: e  reason: collision with root package name */
        private long f15506e = 250;

        /* renamed from: f  reason: collision with root package name */
        private long f15507f = 250;

        @Retention(RetentionPolicy.SOURCE)
        public @interface AdapterChanges {
        }

        public interface ItemAnimatorFinishedListener {
            void a();
        }

        interface ItemAnimatorListener {
            void a(@NonNull ViewHolder viewHolder);
        }

        public static class ItemHolderInfo {

            /* renamed from: a  reason: collision with root package name */
            public int f15508a;

            /* renamed from: b  reason: collision with root package name */
            public int f15509b;

            /* renamed from: c  reason: collision with root package name */
            public int f15510c;

            /* renamed from: d  reason: collision with root package name */
            public int f15511d;

            /* renamed from: e  reason: collision with root package name */
            public int f15512e;

            @NonNull
            public ItemHolderInfo a(@NonNull ViewHolder viewHolder) {
                return b(viewHolder, 0);
            }

            @NonNull
            public ItemHolderInfo b(@NonNull ViewHolder viewHolder, int i2) {
                View view = viewHolder.f15587a;
                this.f15508a = view.getLeft();
                this.f15509b = view.getTop();
                this.f15510c = view.getRight();
                this.f15511d = view.getBottom();
                return this;
            }
        }

        static int e(ViewHolder viewHolder) {
            int i2 = viewHolder.f15596j;
            int i3 = i2 & 14;
            if (viewHolder.O()) {
                return 4;
            }
            if ((i2 & 4) != 0) {
                return i3;
            }
            int H = viewHolder.H();
            int A = viewHolder.A();
            return (H == -1 || A == -1 || H == A) ? i3 : i3 | 2048;
        }

        /* access modifiers changed from: package-private */
        public void A(ItemAnimatorListener itemAnimatorListener) {
            this.f15502a = itemAnimatorListener;
        }

        public void B(long j2) {
            this.f15506e = j2;
        }

        public void C(long j2) {
            this.f15505d = j2;
        }

        public abstract boolean a(@NonNull ViewHolder viewHolder, @Nullable ItemHolderInfo itemHolderInfo, @NonNull ItemHolderInfo itemHolderInfo2);

        public abstract boolean b(@NonNull ViewHolder viewHolder, @NonNull ViewHolder viewHolder2, @NonNull ItemHolderInfo itemHolderInfo, @NonNull ItemHolderInfo itemHolderInfo2);

        public abstract boolean c(@NonNull ViewHolder viewHolder, @NonNull ItemHolderInfo itemHolderInfo, @Nullable ItemHolderInfo itemHolderInfo2);

        public abstract boolean d(@NonNull ViewHolder viewHolder, @NonNull ItemHolderInfo itemHolderInfo, @NonNull ItemHolderInfo itemHolderInfo2);

        public boolean f(@NonNull ViewHolder viewHolder) {
            return true;
        }

        public boolean g(@NonNull ViewHolder viewHolder, @NonNull List<Object> list) {
            return f(viewHolder);
        }

        public final void h(@NonNull ViewHolder viewHolder) {
            t(viewHolder);
            ItemAnimatorListener itemAnimatorListener = this.f15502a;
            if (itemAnimatorListener != null) {
                itemAnimatorListener.a(viewHolder);
            }
        }

        public final void i(@NonNull ViewHolder viewHolder) {
            u(viewHolder);
        }

        public final void j() {
            int size = this.f15503b.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f15503b.get(i2).a();
            }
            this.f15503b.clear();
        }

        public abstract void k(@NonNull ViewHolder viewHolder);

        public abstract void l();

        public long m() {
            return this.f15504c;
        }

        public long n() {
            return this.f15507f;
        }

        public long o() {
            return this.f15506e;
        }

        public long p() {
            return this.f15505d;
        }

        public abstract boolean q();

        public final boolean r(@Nullable ItemAnimatorFinishedListener itemAnimatorFinishedListener) {
            boolean q = q();
            if (itemAnimatorFinishedListener != null) {
                if (!q) {
                    itemAnimatorFinishedListener.a();
                } else {
                    this.f15503b.add(itemAnimatorFinishedListener);
                }
            }
            return q;
        }

        @NonNull
        public ItemHolderInfo s() {
            return new ItemHolderInfo();
        }

        public void t(@NonNull ViewHolder viewHolder) {
        }

        public void u(@NonNull ViewHolder viewHolder) {
        }

        @NonNull
        public ItemHolderInfo v(@NonNull State state, @NonNull ViewHolder viewHolder) {
            return s().a(viewHolder);
        }

        @NonNull
        public ItemHolderInfo w(@NonNull State state, @NonNull ViewHolder viewHolder, int i2, @NonNull List<Object> list) {
            return s().a(viewHolder);
        }

        public abstract void x();

        public void y(long j2) {
            this.f15504c = j2;
        }

        public void z(long j2) {
            this.f15507f = j2;
        }
    }

    private class ItemAnimatorRestoreListener implements ItemAnimator.ItemAnimatorListener {
        ItemAnimatorRestoreListener() {
        }

        public void a(ViewHolder viewHolder) {
            viewHolder.b0(true);
            if (viewHolder.f15594h != null && viewHolder.f15595i == null) {
                viewHolder.f15594h = null;
            }
            viewHolder.f15595i = null;
            if (!viewHolder.d0() && !RecyclerView.this.z1(viewHolder.f15587a) && viewHolder.S()) {
                RecyclerView.this.removeDetachedView(viewHolder.f15587a, false);
            }
        }
    }

    public static abstract class ItemDecoration {
        @Deprecated
        public void f(@NonNull Rect rect, int i2, @NonNull RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void g(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull State state) {
            f(rect, ((LayoutParams) view.getLayoutParams()).d(), recyclerView);
        }

        @Deprecated
        public void h(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView) {
        }

        public void i(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull State state) {
            h(canvas, recyclerView);
        }

        @Deprecated
        public void j(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView) {
        }

        public void k(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull State state) {
            j(canvas, recyclerView);
        }
    }

    public static abstract class LayoutManager {

        /* renamed from: a  reason: collision with root package name */
        ChildHelper f15514a;

        /* renamed from: b  reason: collision with root package name */
        RecyclerView f15515b;

        /* renamed from: c  reason: collision with root package name */
        private final ViewBoundsCheck.Callback f15516c;

        /* renamed from: d  reason: collision with root package name */
        private final ViewBoundsCheck.Callback f15517d;

        /* renamed from: e  reason: collision with root package name */
        ViewBoundsCheck f15518e;

        /* renamed from: f  reason: collision with root package name */
        ViewBoundsCheck f15519f;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        SmoothScroller f15520g;

        /* renamed from: h  reason: collision with root package name */
        boolean f15521h = false;

        /* renamed from: i  reason: collision with root package name */
        boolean f15522i = false;

        /* renamed from: j  reason: collision with root package name */
        boolean f15523j = false;

        /* renamed from: k  reason: collision with root package name */
        private boolean f15524k = true;

        /* renamed from: l  reason: collision with root package name */
        private boolean f15525l = true;

        /* renamed from: m  reason: collision with root package name */
        int f15526m;

        /* renamed from: n  reason: collision with root package name */
        boolean f15527n;
        private int o;
        private int p;
        private int q;
        private int r;

        public interface LayoutPrefetchRegistry {
            void a(int i2, int i3);
        }

        public static class Properties {

            /* renamed from: a  reason: collision with root package name */
            public int f15530a;

            /* renamed from: b  reason: collision with root package name */
            public int f15531b;

            /* renamed from: c  reason: collision with root package name */
            public boolean f15532c;

            /* renamed from: d  reason: collision with root package name */
            public boolean f15533d;
        }

        public LayoutManager() {
            AnonymousClass1 r0 = new ViewBoundsCheck.Callback() {
                public View a(int i2) {
                    return LayoutManager.this.U(i2);
                }

                public int b(View view) {
                    return LayoutManager.this.d0(view) - ((LayoutParams) view.getLayoutParams()).leftMargin;
                }

                public int c() {
                    return LayoutManager.this.s0();
                }

                public int d() {
                    return LayoutManager.this.D0() - LayoutManager.this.t0();
                }

                public int e(View view) {
                    return LayoutManager.this.g0(view) + ((LayoutParams) view.getLayoutParams()).rightMargin;
                }
            };
            this.f15516c = r0;
            AnonymousClass2 r1 = new ViewBoundsCheck.Callback() {
                public View a(int i2) {
                    return LayoutManager.this.U(i2);
                }

                public int b(View view) {
                    return LayoutManager.this.h0(view) - ((LayoutParams) view.getLayoutParams()).topMargin;
                }

                public int c() {
                    return LayoutManager.this.v0();
                }

                public int d() {
                    return LayoutManager.this.j0() - LayoutManager.this.q0();
                }

                public int e(View view) {
                    return LayoutManager.this.b0(view) + ((LayoutParams) view.getLayoutParams()).bottomMargin;
                }
            };
            this.f15517d = r1;
            this.f15518e = new ViewBoundsCheck(r0);
            this.f15519f = new ViewBoundsCheck(r1);
        }

        private void J(int i2, @NonNull View view) {
            this.f15514a.d(i2);
        }

        private boolean L0(RecyclerView recyclerView, int i2, int i3) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int s0 = s0();
            int v0 = v0();
            int D0 = D0() - t0();
            int j0 = j0() - q0();
            Rect rect = this.f15515b.f3;
            c0(focusedChild, rect);
            return rect.left - i2 < D0 && rect.right - i2 > s0 && rect.top - i3 < j0 && rect.bottom - i3 > v0;
        }

        private static boolean P0(int i2, int i3, int i4) {
            int mode = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            if (i4 > 0 && i2 != i4) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i2;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i2;
            }
            return true;
        }

        private void T1(Recycler recycler, int i2, View view) {
            ViewHolder z0 = RecyclerView.z0(view);
            if (z0.e0()) {
                if (RecyclerView.y4) {
                    Log.d(RecyclerView.w4, "ignoring view " + z0);
                }
            } else if (!z0.O() || z0.Q() || this.f15515b.i3.F()) {
                I(i2);
                recycler.J(view);
                this.f15515b.c3.k(z0);
            } else {
                O1(i2);
                recycler.I(z0);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0019, code lost:
            if (r5 == 1073741824) goto L_0x0023;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static int W(int r4, int r5, int r6, int r7, boolean r8) {
            /*
                int r4 = r4 - r6
                r6 = 0
                int r4 = java.lang.Math.max(r6, r4)
                r0 = -2
                r1 = -1
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = 1073741824(0x40000000, float:2.0)
                if (r8 == 0) goto L_0x001e
                if (r7 < 0) goto L_0x0013
            L_0x0010:
                r5 = 1073741824(0x40000000, float:2.0)
                goto L_0x0031
            L_0x0013:
                if (r7 != r1) goto L_0x001b
                if (r5 == r2) goto L_0x0023
                if (r5 == 0) goto L_0x001b
                if (r5 == r3) goto L_0x0023
            L_0x001b:
                r5 = 0
                r7 = 0
                goto L_0x0031
            L_0x001e:
                if (r7 < 0) goto L_0x0021
                goto L_0x0010
            L_0x0021:
                if (r7 != r1) goto L_0x0025
            L_0x0023:
                r7 = r4
                goto L_0x0031
            L_0x0025:
                if (r7 != r0) goto L_0x001b
                if (r5 == r2) goto L_0x002e
                if (r5 != r3) goto L_0x002c
                goto L_0x002e
            L_0x002c:
                r5 = 0
                goto L_0x0023
            L_0x002e:
                r5 = -2147483648(0xffffffff80000000, float:-0.0)
                goto L_0x0023
            L_0x0031:
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r5)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.LayoutManager.W(int, int, int, int, boolean):int");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
            if (r3 >= 0) goto L_0x000c;
         */
        @java.lang.Deprecated
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static int X(int r1, int r2, int r3, boolean r4) {
            /*
                int r1 = r1 - r2
                r2 = 0
                int r1 = java.lang.Math.max(r2, r1)
                r0 = 1073741824(0x40000000, float:2.0)
                if (r4 == 0) goto L_0x0011
                if (r3 < 0) goto L_0x000f
            L_0x000c:
                r2 = 1073741824(0x40000000, float:2.0)
                goto L_0x0021
            L_0x000f:
                r3 = 0
                goto L_0x0021
            L_0x0011:
                if (r3 < 0) goto L_0x0014
                goto L_0x000c
            L_0x0014:
                r4 = -1
                if (r3 != r4) goto L_0x001b
                r2 = 1073741824(0x40000000, float:2.0)
            L_0x0019:
                r3 = r1
                goto L_0x0021
            L_0x001b:
                r4 = -2
                if (r3 != r4) goto L_0x000f
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                goto L_0x0019
            L_0x0021:
                int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.LayoutManager.X(int, int, int, boolean):int");
        }

        private int[] Y(View view, Rect rect) {
            int s0 = s0();
            int v0 = v0();
            int D0 = D0() - t0();
            int j0 = j0() - q0();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width = rect.width() + left;
            int height = rect.height() + top;
            int i2 = left - s0;
            int min = Math.min(0, i2);
            int i3 = top - v0;
            int min2 = Math.min(0, i3);
            int i4 = width - D0;
            int max = Math.max(0, i4);
            int max2 = Math.max(0, height - j0);
            if (m0() != 1) {
                if (min == 0) {
                    min = Math.min(i2, max);
                }
                max = min;
            } else if (max == 0) {
                max = Math.max(min, i4);
            }
            if (min2 == 0) {
                min2 = Math.min(i3, max2);
            }
            return new int[]{max, min2};
        }

        private void l(View view, int i2, boolean z) {
            ViewHolder z0 = RecyclerView.z0(view);
            if (z || z0.Q()) {
                this.f15515b.c3.b(z0);
            } else {
                this.f15515b.c3.p(z0);
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (z0.h0() || z0.R()) {
                if (z0.R()) {
                    z0.g0();
                } else {
                    z0.v();
                }
                this.f15514a.c(view, i2, view.getLayoutParams(), false);
            } else if (view.getParent() == this.f15515b) {
                int m2 = this.f15514a.m(view);
                if (i2 == -1) {
                    i2 = this.f15514a.g();
                }
                if (m2 == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f15515b.indexOfChild(view) + this.f15515b.d0());
                } else if (m2 != i2) {
                    this.f15515b.j3.W0(m2, i2);
                }
            } else {
                this.f15514a.a(view, i2, false);
                layoutParams.f15536c = true;
                SmoothScroller smoothScroller = this.f15520g;
                if (smoothScroller != null && smoothScroller.i()) {
                    this.f15520g.l(view);
                }
            }
            if (layoutParams.f15537d) {
                if (RecyclerView.y4) {
                    Log.d(RecyclerView.w4, "consuming pending invalidate on child " + layoutParams.f15534a);
                }
                z0.f15587a.invalidate();
                layoutParams.f15537d = false;
            }
        }

        public static int v(int i2, int i3, int i4) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i3, i4) : size;
            }
            return Math.min(size, Math.max(i3, i4));
        }

        public static Properties x0(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
            Properties properties = new Properties();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.f15174a, i2, i3);
            properties.f15530a = obtainStyledAttributes.getInt(R.styleable.f15175b, 1);
            properties.f15531b = obtainStyledAttributes.getInt(R.styleable.f15185l, 1);
            properties.f15532c = obtainStyledAttributes.getBoolean(R.styleable.f15184k, false);
            properties.f15533d = obtainStyledAttributes.getBoolean(R.styleable.f15186m, false);
            obtainStyledAttributes.recycle();
            return properties;
        }

        public int A(@NonNull State state) {
            return 0;
        }

        public int A0(@NonNull Recycler recycler, @NonNull State state) {
            return 0;
        }

        /* access modifiers changed from: package-private */
        public void A1(SmoothScroller smoothScroller) {
            if (this.f15520g == smoothScroller) {
                this.f15520g = null;
            }
        }

        public int B(@NonNull State state) {
            return 0;
        }

        public int B0(@NonNull View view) {
            return ((LayoutParams) view.getLayoutParams()).f15535b.top;
        }

        /* access modifiers changed from: package-private */
        public boolean B1(int i2, @Nullable Bundle bundle) {
            RecyclerView recyclerView = this.f15515b;
            return C1(recyclerView.Y2, recyclerView.c4, i2, bundle);
        }

        public int C(@NonNull State state) {
            return 0;
        }

        public void C0(@NonNull View view, boolean z, @NonNull Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((LayoutParams) view.getLayoutParams()).f15535b;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (!(this.f15515b == null || (matrix = view.getMatrix()) == null || matrix.isIdentity())) {
                RectF rectF = this.f15515b.h3;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        /* JADX WARNING: Removed duplicated region for block: B:30:0x0094 A[ADDED_TO_REGION] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean C1(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.Recycler r9, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.State r10, int r11, @androidx.annotation.Nullable android.os.Bundle r12) {
            /*
                r8 = this;
                androidx.recyclerview.widget.RecyclerView r9 = r8.f15515b
                r10 = 0
                if (r9 != 0) goto L_0x0006
                return r10
            L_0x0006:
                int r9 = r8.j0()
                int r12 = r8.D0()
                android.graphics.Rect r0 = new android.graphics.Rect
                r0.<init>()
                androidx.recyclerview.widget.RecyclerView r1 = r8.f15515b
                android.graphics.Matrix r1 = r1.getMatrix()
                boolean r1 = r1.isIdentity()
                if (r1 == 0) goto L_0x002f
                androidx.recyclerview.widget.RecyclerView r1 = r8.f15515b
                boolean r1 = r1.getGlobalVisibleRect(r0)
                if (r1 == 0) goto L_0x002f
                int r9 = r0.height()
                int r12 = r0.width()
            L_0x002f:
                r0 = 4096(0x1000, float:5.74E-42)
                r1 = 1
                if (r11 == r0) goto L_0x006a
                r0 = 8192(0x2000, float:1.14794E-41)
                if (r11 == r0) goto L_0x003b
                r3 = 0
                r4 = 0
                goto L_0x0092
            L_0x003b:
                androidx.recyclerview.widget.RecyclerView r11 = r8.f15515b
                r0 = -1
                boolean r11 = r11.canScrollVertically(r0)
                if (r11 == 0) goto L_0x0050
                int r11 = r8.v0()
                int r9 = r9 - r11
                int r11 = r8.q0()
                int r9 = r9 - r11
                int r9 = -r9
                goto L_0x0051
            L_0x0050:
                r9 = 0
            L_0x0051:
                androidx.recyclerview.widget.RecyclerView r11 = r8.f15515b
                boolean r11 = r11.canScrollHorizontally(r0)
                if (r11 == 0) goto L_0x0067
                int r11 = r8.s0()
                int r12 = r12 - r11
                int r11 = r8.t0()
                int r12 = r12 - r11
                int r11 = -r12
            L_0x0064:
                r4 = r9
                r3 = r11
                goto L_0x0092
            L_0x0067:
                r4 = r9
                r3 = 0
                goto L_0x0092
            L_0x006a:
                androidx.recyclerview.widget.RecyclerView r11 = r8.f15515b
                boolean r11 = r11.canScrollVertically(r1)
                if (r11 == 0) goto L_0x007d
                int r11 = r8.v0()
                int r9 = r9 - r11
                int r11 = r8.q0()
                int r9 = r9 - r11
                goto L_0x007e
            L_0x007d:
                r9 = 0
            L_0x007e:
                androidx.recyclerview.widget.RecyclerView r11 = r8.f15515b
                boolean r11 = r11.canScrollHorizontally(r1)
                if (r11 == 0) goto L_0x0067
                int r11 = r8.s0()
                int r12 = r12 - r11
                int r11 = r8.t0()
                int r11 = r12 - r11
                goto L_0x0064
            L_0x0092:
                if (r4 != 0) goto L_0x0097
                if (r3 != 0) goto L_0x0097
                return r10
            L_0x0097:
                androidx.recyclerview.widget.RecyclerView r2 = r8.f15515b
                r6 = -2147483648(0xffffffff80000000, float:-0.0)
                r7 = 1
                r5 = 0
                r2.W1(r3, r4, r5, r6, r7)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.LayoutManager.C1(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State, int, android.os.Bundle):boolean");
        }

        public int D(@NonNull State state) {
            return 0;
        }

        @Px
        public int D0() {
            return this.q;
        }

        /* access modifiers changed from: package-private */
        public boolean D1(@NonNull View view, int i2, @Nullable Bundle bundle) {
            RecyclerView recyclerView = this.f15515b;
            return E1(recyclerView.Y2, recyclerView.c4, view, i2, bundle);
        }

        public void E(@NonNull Recycler recycler) {
            for (int V = V() - 1; V >= 0; V--) {
                T1(recycler, V, U(V));
            }
        }

        public int E0() {
            return this.o;
        }

        public boolean E1(@NonNull Recycler recycler, @NonNull State state, @NonNull View view, int i2, @Nullable Bundle bundle) {
            return false;
        }

        public void F(@NonNull View view, @NonNull Recycler recycler) {
            T1(recycler, this.f15514a.m(view), view);
        }

        /* access modifiers changed from: package-private */
        public boolean F0() {
            int V = V();
            for (int i2 = 0; i2 < V; i2++) {
                ViewGroup.LayoutParams layoutParams = U(i2).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public void F1(Runnable runnable) {
            RecyclerView recyclerView = this.f15515b;
            if (recyclerView != null) {
                ViewCompat.v1(recyclerView, runnable);
            }
        }

        public void G(int i2, @NonNull Recycler recycler) {
            T1(recycler, i2, U(i2));
        }

        public boolean G0() {
            RecyclerView recyclerView = this.f15515b;
            return recyclerView != null && recyclerView.hasFocus();
        }

        public void G1() {
            for (int V = V() - 1; V >= 0; V--) {
                this.f15514a.q(V);
            }
        }

        public void H(@NonNull View view) {
            int m2 = this.f15514a.m(view);
            if (m2 >= 0) {
                J(m2, view);
            }
        }

        public void H0(@NonNull View view) {
            ViewParent parent = view.getParent();
            RecyclerView recyclerView = this.f15515b;
            if (parent != recyclerView || recyclerView.indexOfChild(view) == -1) {
                throw new IllegalArgumentException("View should be fully attached to be ignored" + this.f15515b.d0());
            }
            ViewHolder z0 = RecyclerView.z0(view);
            z0.s(128);
            this.f15515b.c3.q(z0);
        }

        public void H1(@NonNull Recycler recycler) {
            for (int V = V() - 1; V >= 0; V--) {
                if (!RecyclerView.z0(U(V)).e0()) {
                    K1(V, recycler);
                }
            }
        }

        public void I(int i2) {
            J(i2, U(i2));
        }

        public boolean I0() {
            return this.f15522i;
        }

        /* access modifiers changed from: package-private */
        public void I1(Recycler recycler) {
            int k2 = recycler.k();
            for (int i2 = k2 - 1; i2 >= 0; i2--) {
                View o2 = recycler.o(i2);
                ViewHolder z0 = RecyclerView.z0(o2);
                if (!z0.e0()) {
                    z0.b0(false);
                    if (z0.S()) {
                        this.f15515b.removeDetachedView(o2, false);
                    }
                    ItemAnimator itemAnimator = this.f15515b.K3;
                    if (itemAnimator != null) {
                        itemAnimator.k(z0);
                    }
                    z0.b0(true);
                    recycler.E(o2);
                }
            }
            recycler.f();
            if (k2 > 0) {
                this.f15515b.invalidate();
            }
        }

        public boolean J0() {
            return this.f15523j;
        }

        public void J1(@NonNull View view, @NonNull Recycler recycler) {
            N1(view);
            recycler.H(view);
        }

        /* access modifiers changed from: package-private */
        public void K(RecyclerView recyclerView) {
            this.f15522i = true;
            b1(recyclerView);
        }

        public boolean K0() {
            RecyclerView recyclerView = this.f15515b;
            return recyclerView != null && recyclerView.isFocused();
        }

        public void K1(int i2, @NonNull Recycler recycler) {
            View U = U(i2);
            O1(i2);
            recycler.H(U);
        }

        /* access modifiers changed from: package-private */
        public void L(RecyclerView recyclerView, Recycler recycler) {
            this.f15522i = false;
            d1(recyclerView, recycler);
        }

        public boolean L1(Runnable runnable) {
            RecyclerView recyclerView = this.f15515b;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        @SuppressLint({"UnknownNullness"})
        public void M(View view) {
            ItemAnimator itemAnimator = this.f15515b.K3;
            if (itemAnimator != null) {
                itemAnimator.k(RecyclerView.z0(view));
            }
        }

        public final boolean M0() {
            return this.f15525l;
        }

        public void M1(@NonNull View view) {
            this.f15515b.removeDetachedView(view, false);
        }

        @Nullable
        public View N(@NonNull View view) {
            View g0;
            RecyclerView recyclerView = this.f15515b;
            if (recyclerView == null || (g0 = recyclerView.g0(view)) == null || this.f15514a.n(g0)) {
                return null;
            }
            return g0;
        }

        public boolean N0(@NonNull Recycler recycler, @NonNull State state) {
            return false;
        }

        @SuppressLint({"UnknownNullness"})
        public void N1(View view) {
            this.f15514a.p(view);
        }

        @Nullable
        public View O(int i2) {
            int V = V();
            for (int i3 = 0; i3 < V; i3++) {
                View U = U(i3);
                ViewHolder z0 = RecyclerView.z0(U);
                if (z0 != null && z0.G() == i2 && !z0.e0() && (this.f15515b.c4.j() || !z0.Q())) {
                    return U;
                }
            }
            return null;
        }

        public boolean O0() {
            return this.f15524k;
        }

        public void O1(int i2) {
            if (U(i2) != null) {
                this.f15514a.q(i2);
            }
        }

        @SuppressLint({"UnknownNullness"})
        public abstract LayoutParams P();

        public boolean P1(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z) {
            return Q1(recyclerView, view, rect, z, false);
        }

        @SuppressLint({"UnknownNullness"})
        public LayoutParams Q(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        public boolean Q0() {
            SmoothScroller smoothScroller = this.f15520g;
            return smoothScroller != null && smoothScroller.i();
        }

        public boolean Q1(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z, boolean z2) {
            int[] Y = Y(view, rect);
            int i2 = Y[0];
            int i3 = Y[1];
            if ((z2 && !L0(recyclerView, i2, i3)) || (i2 == 0 && i3 == 0)) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(i2, i3);
            } else {
                recyclerView.T1(i2, i3);
            }
            return true;
        }

        @SuppressLint({"UnknownNullness"})
        public LayoutParams R(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof LayoutParams) {
                return new LayoutParams((LayoutParams) layoutParams);
            }
            return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
        }

        public boolean R0(@NonNull View view, boolean z, boolean z2) {
            boolean z3 = this.f15518e.b(view, 24579) && this.f15519f.b(view, 24579);
            return z ? z3 : !z3;
        }

        public void R1() {
            RecyclerView recyclerView = this.f15515b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public int S() {
            return -1;
        }

        public void S0(@NonNull View view, int i2, int i3, int i4, int i5) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f15535b;
            view.layout(i2 + rect.left, i3 + rect.top, i4 - rect.right, i5 - rect.bottom);
        }

        public void S1() {
            this.f15521h = true;
        }

        public int T(@NonNull View view) {
            return ((LayoutParams) view.getLayoutParams()).f15535b.bottom;
        }

        public void T0(@NonNull View view, int i2, int i3, int i4, int i5) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rect = layoutParams.f15535b;
            view.layout(i2 + rect.left + layoutParams.leftMargin, i3 + rect.top + layoutParams.topMargin, (i4 - rect.right) - layoutParams.rightMargin, (i5 - rect.bottom) - layoutParams.bottomMargin);
        }

        @Nullable
        public View U(int i2) {
            ChildHelper childHelper = this.f15514a;
            if (childHelper != null) {
                return childHelper.f(i2);
            }
            return null;
        }

        public void U0(@NonNull View view, int i2, int i3) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect E0 = this.f15515b.E0(view);
            int i4 = i2 + E0.left + E0.right;
            int i5 = i3 + E0.top + E0.bottom;
            int W = W(D0(), E0(), s0() + t0() + i4, layoutParams.width, s());
            int W2 = W(j0(), k0(), v0() + q0() + i5, layoutParams.height, t());
            if (g2(view, W, W2, layoutParams)) {
                view.measure(W, W2);
            }
        }

        @SuppressLint({"UnknownNullness"})
        public int U1(int i2, Recycler recycler, State state) {
            return 0;
        }

        public int V() {
            ChildHelper childHelper = this.f15514a;
            if (childHelper != null) {
                return childHelper.g();
            }
            return 0;
        }

        public void V0(@NonNull View view, int i2, int i3) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect E0 = this.f15515b.E0(view);
            int i4 = i2 + E0.left + E0.right;
            int i5 = i3 + E0.top + E0.bottom;
            int W = W(D0(), E0(), s0() + t0() + layoutParams.leftMargin + layoutParams.rightMargin + i4, layoutParams.width, s());
            int W2 = W(j0(), k0(), v0() + q0() + layoutParams.topMargin + layoutParams.bottomMargin + i5, layoutParams.height, t());
            if (g2(view, W, W2, layoutParams)) {
                view.measure(W, W2);
            }
        }

        public void V1(int i2) {
            if (RecyclerView.y4) {
                Log.e(RecyclerView.w4, "You MUST implement scrollToPosition. It will soon become abstract");
            }
        }

        public void W0(int i2, int i3) {
            View U = U(i2);
            if (U != null) {
                I(i2);
                p(U, i3);
                return;
            }
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i2 + this.f15515b.toString());
        }

        @SuppressLint({"UnknownNullness"})
        public int W1(int i2, Recycler recycler, State state) {
            return 0;
        }

        public void X0(@Px int i2) {
            RecyclerView recyclerView = this.f15515b;
            if (recyclerView != null) {
                recyclerView.b1(i2);
            }
        }

        @Deprecated
        public void X1(boolean z) {
            this.f15523j = z;
        }

        public void Y0(@Px int i2) {
            RecyclerView recyclerView = this.f15515b;
            if (recyclerView != null) {
                recyclerView.c1(i2);
            }
        }

        /* access modifiers changed from: package-private */
        public void Y1(RecyclerView recyclerView) {
            a2(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public boolean Z() {
            RecyclerView recyclerView = this.f15515b;
            return recyclerView != null && recyclerView.d3;
        }

        public void Z0(@Nullable Adapter adapter, @Nullable Adapter adapter2) {
        }

        public final void Z1(boolean z) {
            if (z != this.f15525l) {
                this.f15525l = z;
                this.f15526m = 0;
                RecyclerView recyclerView = this.f15515b;
                if (recyclerView != null) {
                    recyclerView.Y2.Q();
                }
            }
        }

        public int a0(@NonNull Recycler recycler, @NonNull State state) {
            return -1;
        }

        public boolean a1(@NonNull RecyclerView recyclerView, @NonNull ArrayList<View> arrayList, int i2, int i3) {
            return false;
        }

        /* access modifiers changed from: package-private */
        public void a2(int i2, int i3) {
            this.q = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i2);
            this.o = mode;
            if (mode == 0 && !RecyclerView.F4) {
                this.q = 0;
            }
            this.r = View.MeasureSpec.getSize(i3);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.p = mode2;
            if (mode2 == 0 && !RecyclerView.F4) {
                this.r = 0;
            }
        }

        public int b() {
            RecyclerView recyclerView = this.f15515b;
            Adapter adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.b();
            }
            return 0;
        }

        public int b0(@NonNull View view) {
            return view.getBottom() + T(view);
        }

        @CallSuper
        public void b1(RecyclerView recyclerView) {
        }

        public void b2(int i2, int i3) {
            this.f15515b.setMeasuredDimension(i2, i3);
        }

        public void c0(@NonNull View view, @NonNull Rect rect) {
            RecyclerView.B0(view, rect);
        }

        @Deprecated
        public void c1(RecyclerView recyclerView) {
        }

        public void c2(Rect rect, int i2, int i3) {
            b2(v(i2, rect.width() + s0() + t0(), p0()), v(i3, rect.height() + v0() + q0(), o0()));
        }

        public int d0(@NonNull View view) {
            return view.getLeft() - n0(view);
        }

        @CallSuper
        @SuppressLint({"UnknownNullness"})
        public void d1(RecyclerView recyclerView, Recycler recycler) {
            c1(recyclerView);
        }

        /* access modifiers changed from: package-private */
        public void d2(int i2, int i3) {
            int V = V();
            if (V == 0) {
                this.f15515b.M(i2, i3);
                return;
            }
            int i4 = Integer.MIN_VALUE;
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MAX_VALUE;
            int i7 = Integer.MAX_VALUE;
            for (int i8 = 0; i8 < V; i8++) {
                View U = U(i8);
                Rect rect = this.f15515b.f3;
                c0(U, rect);
                int i9 = rect.left;
                if (i9 < i6) {
                    i6 = i9;
                }
                int i10 = rect.right;
                if (i10 > i4) {
                    i4 = i10;
                }
                int i11 = rect.top;
                if (i11 < i7) {
                    i7 = i11;
                }
                int i12 = rect.bottom;
                if (i12 > i5) {
                    i5 = i12;
                }
            }
            this.f15515b.f3.set(i6, i7, i4, i5);
            c2(this.f15515b.f3, i2, i3);
        }

        public int e0(@NonNull View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f15535b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        @Nullable
        public View e1(@NonNull View view, int i2, @NonNull Recycler recycler, @NonNull State state) {
            return null;
        }

        public void e2(boolean z) {
            this.f15524k = z;
        }

        public int f0(@NonNull View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f15535b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public void f1(@NonNull AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f15515b;
            g1(recyclerView.Y2, recyclerView.c4, accessibilityEvent);
        }

        /* access modifiers changed from: package-private */
        public void f2(RecyclerView recyclerView) {
            int height;
            if (recyclerView == null) {
                this.f15515b = null;
                this.f15514a = null;
                height = 0;
                this.q = 0;
            } else {
                this.f15515b = recyclerView;
                this.f15514a = recyclerView.b3;
                this.q = recyclerView.getWidth();
                height = recyclerView.getHeight();
            }
            this.r = height;
            this.o = 1073741824;
            this.p = 1073741824;
        }

        public int g0(@NonNull View view) {
            return view.getRight() + y0(view);
        }

        public void g1(@NonNull Recycler recycler, @NonNull State state, @NonNull AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f15515b;
            if (recyclerView != null && accessibilityEvent != null) {
                boolean z = true;
                if (!recyclerView.canScrollVertically(1) && !this.f15515b.canScrollVertically(-1) && !this.f15515b.canScrollHorizontally(-1) && !this.f15515b.canScrollHorizontally(1)) {
                    z = false;
                }
                accessibilityEvent.setScrollable(z);
                Adapter adapter = this.f15515b.i3;
                if (adapter != null) {
                    accessibilityEvent.setItemCount(adapter.b());
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean g2(View view, int i2, int i3, LayoutParams layoutParams) {
            return view.isLayoutRequested() || !this.f15524k || !P0(view.getWidth(), i2, layoutParams.width) || !P0(view.getHeight(), i3, layoutParams.height);
        }

        @SuppressLint({"UnknownNullness"})
        public void h(View view) {
            i(view, -1);
        }

        public int h0(@NonNull View view) {
            return view.getTop() - B0(view);
        }

        /* access modifiers changed from: package-private */
        public void h1(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            RecyclerView recyclerView = this.f15515b;
            i1(recyclerView.Y2, recyclerView.c4, accessibilityNodeInfoCompat);
        }

        /* access modifiers changed from: package-private */
        public boolean h2() {
            return false;
        }

        @SuppressLint({"UnknownNullness"})
        public void i(View view, int i2) {
            l(view, i2, true);
        }

        @Nullable
        public View i0() {
            View focusedChild;
            RecyclerView recyclerView = this.f15515b;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.f15514a.n(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public void i1(@NonNull Recycler recycler, @NonNull State state, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (this.f15515b.canScrollVertically(-1) || this.f15515b.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat.a(8192);
                accessibilityNodeInfoCompat.X1(true);
            }
            if (this.f15515b.canScrollVertically(1) || this.f15515b.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.a(4096);
                accessibilityNodeInfoCompat.X1(true);
            }
            accessibilityNodeInfoCompat.l1(AccessibilityNodeInfoCompat.CollectionInfoCompat.f(z0(recycler, state), a0(recycler, state), N0(recycler, state), A0(recycler, state)));
        }

        /* access modifiers changed from: package-private */
        public boolean i2(View view, int i2, int i3, LayoutParams layoutParams) {
            return !this.f15524k || !P0(view.getMeasuredWidth(), i2, layoutParams.width) || !P0(view.getMeasuredHeight(), i3, layoutParams.height);
        }

        @SuppressLint({"UnknownNullness"})
        public void j(View view) {
            k(view, -1);
        }

        @Px
        public int j0() {
            return this.r;
        }

        /* access modifiers changed from: package-private */
        public void j1(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            ViewHolder z0 = RecyclerView.z0(view);
            if (z0 != null && !z0.Q() && !this.f15514a.n(z0.f15587a)) {
                RecyclerView recyclerView = this.f15515b;
                k1(recyclerView.Y2, recyclerView.c4, view, accessibilityNodeInfoCompat);
            }
        }

        @SuppressLint({"UnknownNullness"})
        public void j2(RecyclerView recyclerView, State state, int i2) {
            Log.e(RecyclerView.w4, "You must override smoothScrollToPosition to support smooth scrolling");
        }

        @SuppressLint({"UnknownNullness"})
        public void k(View view, int i2) {
            l(view, i2, false);
        }

        public int k0() {
            return this.p;
        }

        public void k1(@NonNull Recycler recycler, @NonNull State state, @NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        }

        @SuppressLint({"UnknownNullness"})
        public void k2(SmoothScroller smoothScroller) {
            SmoothScroller smoothScroller2 = this.f15520g;
            if (!(smoothScroller2 == null || smoothScroller == smoothScroller2 || !smoothScroller2.i())) {
                this.f15520g.s();
            }
            this.f15520g = smoothScroller;
            smoothScroller.r(this.f15515b, this);
        }

        public int l0(@NonNull View view) {
            return RecyclerView.z0(view).F();
        }

        @Nullable
        public View l1(@NonNull View view, int i2) {
            return null;
        }

        public void l2(@NonNull View view) {
            ViewHolder z0 = RecyclerView.z0(view);
            z0.f0();
            z0.Y();
            z0.s(4);
        }

        public void m(String str) {
            RecyclerView recyclerView = this.f15515b;
            if (recyclerView != null) {
                recyclerView.y(str);
            }
        }

        public int m0() {
            return ViewCompat.c0(this.f15515b);
        }

        public void m1(@NonNull RecyclerView recyclerView, int i2, int i3) {
        }

        /* access modifiers changed from: package-private */
        public void m2() {
            SmoothScroller smoothScroller = this.f15520g;
            if (smoothScroller != null) {
                smoothScroller.s();
            }
        }

        @SuppressLint({"UnknownNullness"})
        public void n(String str) {
            RecyclerView recyclerView = this.f15515b;
            if (recyclerView != null) {
                recyclerView.z(str);
            }
        }

        public int n0(@NonNull View view) {
            return ((LayoutParams) view.getLayoutParams()).f15535b.left;
        }

        public void n1(@NonNull RecyclerView recyclerView) {
        }

        public boolean n2() {
            return false;
        }

        public void o(@NonNull View view) {
            p(view, -1);
        }

        @Px
        public int o0() {
            return ViewCompat.h0(this.f15515b);
        }

        public void o1(@NonNull RecyclerView recyclerView, int i2, int i3, int i4) {
        }

        public void p(@NonNull View view, int i2) {
            q(view, i2, (LayoutParams) view.getLayoutParams());
        }

        @Px
        public int p0() {
            return ViewCompat.i0(this.f15515b);
        }

        public void p1(@NonNull RecyclerView recyclerView, int i2, int i3) {
        }

        public void q(@NonNull View view, int i2, LayoutParams layoutParams) {
            ViewHolder z0 = RecyclerView.z0(view);
            if (z0.Q()) {
                this.f15515b.c3.b(z0);
            } else {
                this.f15515b.c3.p(z0);
            }
            this.f15514a.c(view, i2, layoutParams, z0.Q());
        }

        @Px
        public int q0() {
            RecyclerView recyclerView = this.f15515b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public void q1(@NonNull RecyclerView recyclerView, int i2, int i3) {
        }

        public void r(@NonNull View view, @NonNull Rect rect) {
            RecyclerView recyclerView = this.f15515b;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.E0(view));
            }
        }

        @Px
        public int r0() {
            RecyclerView recyclerView = this.f15515b;
            if (recyclerView != null) {
                return ViewCompat.m0(recyclerView);
            }
            return 0;
        }

        public void r1(@NonNull RecyclerView recyclerView, int i2, int i3, @Nullable Object obj) {
            q1(recyclerView, i2, i3);
        }

        public boolean s() {
            return false;
        }

        @Px
        public int s0() {
            RecyclerView recyclerView = this.f15515b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        @SuppressLint({"UnknownNullness"})
        public void s1(Recycler recycler, State state) {
            Log.e(RecyclerView.w4, "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public boolean t() {
            return false;
        }

        @Px
        public int t0() {
            RecyclerView recyclerView = this.f15515b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        @SuppressLint({"UnknownNullness"})
        public void t1(State state) {
        }

        public boolean u(LayoutParams layoutParams) {
            return layoutParams != null;
        }

        @Px
        public int u0() {
            RecyclerView recyclerView = this.f15515b;
            if (recyclerView != null) {
                return ViewCompat.n0(recyclerView);
            }
            return 0;
        }

        public void u1(@NonNull Recycler recycler, @NonNull State state, int i2, int i3) {
            this.f15515b.M(i2, i3);
        }

        @Px
        public int v0() {
            RecyclerView recyclerView = this.f15515b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        @Deprecated
        public boolean v1(@NonNull RecyclerView recyclerView, @NonNull View view, @Nullable View view2) {
            return Q0() || recyclerView.T0();
        }

        @SuppressLint({"UnknownNullness"})
        public void w(int i2, int i3, State state, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        }

        public int w0(@NonNull View view) {
            return ((LayoutParams) view.getLayoutParams()).d();
        }

        public boolean w1(@NonNull RecyclerView recyclerView, @NonNull State state, @NonNull View view, @Nullable View view2) {
            return v1(recyclerView, view, view2);
        }

        @SuppressLint({"UnknownNullness"})
        public void x(int i2, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        }

        @SuppressLint({"UnknownNullness"})
        public void x1(Parcelable parcelable) {
        }

        public int y(@NonNull State state) {
            return 0;
        }

        public int y0(@NonNull View view) {
            return ((LayoutParams) view.getLayoutParams()).f15535b.right;
        }

        @Nullable
        public Parcelable y1() {
            return null;
        }

        public int z(@NonNull State state) {
            return 0;
        }

        public int z0(@NonNull Recycler recycler, @NonNull State state) {
            return -1;
        }

        public void z1(int i2) {
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        ViewHolder f15534a;

        /* renamed from: b  reason: collision with root package name */
        final Rect f15535b = new Rect();

        /* renamed from: c  reason: collision with root package name */
        boolean f15536c = true;

        /* renamed from: d  reason: collision with root package name */
        boolean f15537d = false;

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        public int a() {
            return this.f15534a.A();
        }

        public int b() {
            return this.f15534a.D();
        }

        @Deprecated
        public int c() {
            return this.f15534a.D();
        }

        public int d() {
            return this.f15534a.G();
        }

        @Deprecated
        public int e() {
            return this.f15534a.I();
        }

        public boolean f() {
            return this.f15534a.T();
        }

        public boolean g() {
            return this.f15534a.Q();
        }

        public boolean h() {
            return this.f15534a.O();
        }

        public boolean i() {
            return this.f15534a.U();
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

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public interface OnChildAttachStateChangeListener {
        void b(@NonNull View view);

        void d(@NonNull View view);
    }

    public static abstract class OnFlingListener {
        public abstract boolean a(int i2, int i3);
    }

    public interface OnItemTouchListener {
        void a(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent);

        boolean c(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent);

        void e(boolean z);
    }

    public static abstract class OnScrollListener {
        public void a(@NonNull RecyclerView recyclerView, int i2) {
        }

        public void b(@NonNull RecyclerView recyclerView, int i2, int i3) {
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Orientation {
    }

    public static class RecycledViewPool {

        /* renamed from: d  reason: collision with root package name */
        private static final int f15538d = 5;

        /* renamed from: a  reason: collision with root package name */
        SparseArray<ScrapData> f15539a = new SparseArray<>();

        /* renamed from: b  reason: collision with root package name */
        int f15540b = 0;

        /* renamed from: c  reason: collision with root package name */
        Set<Adapter<?>> f15541c = Collections.newSetFromMap(new IdentityHashMap());

        static class ScrapData {

            /* renamed from: a  reason: collision with root package name */
            final ArrayList<ViewHolder> f15542a = new ArrayList<>();

            /* renamed from: b  reason: collision with root package name */
            int f15543b = 5;

            /* renamed from: c  reason: collision with root package name */
            long f15544c = 0;

            /* renamed from: d  reason: collision with root package name */
            long f15545d = 0;

            ScrapData() {
            }
        }

        private ScrapData j(int i2) {
            ScrapData scrapData = this.f15539a.get(i2);
            if (scrapData != null) {
                return scrapData;
            }
            ScrapData scrapData2 = new ScrapData();
            this.f15539a.put(i2, scrapData2);
            return scrapData2;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f15540b++;
        }

        /* access modifiers changed from: package-private */
        public void b(@NonNull Adapter<?> adapter) {
            this.f15541c.add(adapter);
        }

        public void c() {
            for (int i2 = 0; i2 < this.f15539a.size(); i2++) {
                ScrapData valueAt = this.f15539a.valueAt(i2);
                Iterator<ViewHolder> it2 = valueAt.f15542a.iterator();
                while (it2.hasNext()) {
                    PoolingContainer.b(it2.next().f15587a);
                }
                valueAt.f15542a.clear();
            }
        }

        /* access modifiers changed from: package-private */
        public void d() {
            this.f15540b--;
        }

        /* access modifiers changed from: package-private */
        public void e(@NonNull Adapter<?> adapter, boolean z) {
            this.f15541c.remove(adapter);
            if (this.f15541c.size() == 0 && !z) {
                for (int i2 = 0; i2 < this.f15539a.size(); i2++) {
                    SparseArray<ScrapData> sparseArray = this.f15539a;
                    ArrayList<ViewHolder> arrayList = sparseArray.get(sparseArray.keyAt(i2)).f15542a;
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        PoolingContainer.b(arrayList.get(i3).f15587a);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void f(int i2, long j2) {
            ScrapData j3 = j(i2);
            j3.f15545d = m(j3.f15545d, j2);
        }

        /* access modifiers changed from: package-private */
        public void g(int i2, long j2) {
            ScrapData j3 = j(i2);
            j3.f15544c = m(j3.f15544c, j2);
        }

        @Nullable
        public ViewHolder h(int i2) {
            ScrapData scrapData = this.f15539a.get(i2);
            if (scrapData == null || scrapData.f15542a.isEmpty()) {
                return null;
            }
            ArrayList<ViewHolder> arrayList = scrapData.f15542a;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!arrayList.get(size).M()) {
                    return arrayList.remove(size);
                }
            }
            return null;
        }

        public int i(int i2) {
            return j(i2).f15542a.size();
        }

        /* access modifiers changed from: package-private */
        public void k(Adapter<?> adapter, Adapter<?> adapter2, boolean z) {
            if (adapter != null) {
                d();
            }
            if (!z && this.f15540b == 0) {
                c();
            }
            if (adapter2 != null) {
                a();
            }
        }

        public void l(ViewHolder viewHolder) {
            int F = viewHolder.F();
            ArrayList<ViewHolder> arrayList = j(F).f15542a;
            if (this.f15539a.get(F).f15543b <= arrayList.size()) {
                PoolingContainer.b(viewHolder.f15587a);
            } else if (!RecyclerView.x4 || !arrayList.contains(viewHolder)) {
                viewHolder.Y();
                arrayList.add(viewHolder);
            } else {
                throw new IllegalArgumentException("this scrap item already exists");
            }
        }

        /* access modifiers changed from: package-private */
        public long m(long j2, long j3) {
            return j2 == 0 ? j3 : ((j2 / 4) * 3) + (j3 / 4);
        }

        public void n(int i2, int i3) {
            ScrapData j2 = j(i2);
            j2.f15543b = i3;
            ArrayList<ViewHolder> arrayList = j2.f15542a;
            while (arrayList.size() > i3) {
                arrayList.remove(arrayList.size() - 1);
            }
        }

        /* access modifiers changed from: package-private */
        public int o() {
            int i2 = 0;
            for (int i3 = 0; i3 < this.f15539a.size(); i3++) {
                ArrayList<ViewHolder> arrayList = this.f15539a.valueAt(i3).f15542a;
                if (arrayList != null) {
                    i2 += arrayList.size();
                }
            }
            return i2;
        }

        /* access modifiers changed from: package-private */
        public boolean p(int i2, long j2, long j3) {
            long j4 = j(i2).f15545d;
            return j4 == 0 || j2 + j4 < j3;
        }

        /* access modifiers changed from: package-private */
        public boolean q(int i2, long j2, long j3) {
            long j4 = j(i2).f15544c;
            return j4 == 0 || j2 + j4 < j3;
        }
    }

    public final class Recycler {

        /* renamed from: j  reason: collision with root package name */
        static final int f15546j = 2;

        /* renamed from: a  reason: collision with root package name */
        final ArrayList<ViewHolder> f15547a;

        /* renamed from: b  reason: collision with root package name */
        ArrayList<ViewHolder> f15548b = null;

        /* renamed from: c  reason: collision with root package name */
        final ArrayList<ViewHolder> f15549c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        private final List<ViewHolder> f15550d;

        /* renamed from: e  reason: collision with root package name */
        private int f15551e;

        /* renamed from: f  reason: collision with root package name */
        int f15552f;

        /* renamed from: g  reason: collision with root package name */
        RecycledViewPool f15553g;

        /* renamed from: h  reason: collision with root package name */
        private ViewCacheExtension f15554h;

        public Recycler() {
            ArrayList<ViewHolder> arrayList = new ArrayList<>();
            this.f15547a = arrayList;
            this.f15550d = Collections.unmodifiableList(arrayList);
            this.f15551e = 2;
            this.f15552f = 2;
        }

        private void C(Adapter<?> adapter) {
            D(adapter, false);
        }

        private void D(Adapter<?> adapter, boolean z) {
            RecycledViewPool recycledViewPool = this.f15553g;
            if (recycledViewPool != null) {
                recycledViewPool.e(adapter, z);
            }
        }

        private boolean N(@NonNull ViewHolder viewHolder, int i2, int i3, long j2) {
            viewHolder.s = null;
            viewHolder.r = RecyclerView.this;
            int F = viewHolder.F();
            long nanoTime = RecyclerView.this.getNanoTime();
            boolean z = false;
            if (j2 != Long.MAX_VALUE && !this.f15553g.p(F, nanoTime, j2)) {
                return false;
            }
            if (viewHolder.S()) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.attachViewToParent(viewHolder.f15587a, recyclerView.getChildCount(), viewHolder.f15587a.getLayoutParams());
                z = true;
            }
            RecyclerView.this.i3.x(viewHolder, i2);
            if (z) {
                RecyclerView.this.detachViewFromParent(viewHolder.f15587a);
            }
            this.f15553g.f(viewHolder.F(), RecyclerView.this.getNanoTime() - nanoTime);
            b(viewHolder);
            if (RecyclerView.this.c4.j()) {
                viewHolder.f15593g = i3;
            }
            return true;
        }

        private void b(ViewHolder viewHolder) {
            if (RecyclerView.this.R0()) {
                View view = viewHolder.f15587a;
                if (ViewCompat.X(view) == 0) {
                    ViewCompat.Z1(view, 1);
                }
                RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate = RecyclerView.this.j4;
                if (recyclerViewAccessibilityDelegate != null) {
                    AccessibilityDelegateCompat n2 = recyclerViewAccessibilityDelegate.n();
                    if (n2 instanceof RecyclerViewAccessibilityDelegate.ItemDelegate) {
                        ((RecyclerViewAccessibilityDelegate.ItemDelegate) n2).o(view);
                    }
                    ViewCompat.H1(view, n2);
                }
            }
        }

        private void r(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    r((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                    return;
                }
                int visibility = viewGroup.getVisibility();
                viewGroup.setVisibility(4);
                viewGroup.setVisibility(visibility);
            }
        }

        private void s(ViewHolder viewHolder) {
            View view = viewHolder.f15587a;
            if (view instanceof ViewGroup) {
                r((ViewGroup) view, false);
            }
        }

        private void v() {
            if (this.f15553g != null) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.i3 != null && recyclerView.isAttachedToWindow()) {
                    this.f15553g.b(RecyclerView.this.i3);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void A() {
            v();
        }

        /* access modifiers changed from: package-private */
        public void B() {
            for (int i2 = 0; i2 < this.f15549c.size(); i2++) {
                PoolingContainer.b(this.f15549c.get(i2).f15587a);
            }
            C(RecyclerView.this.i3);
        }

        /* access modifiers changed from: package-private */
        public void E(View view) {
            ViewHolder z0 = RecyclerView.z0(view);
            z0.f15600n = null;
            z0.o = false;
            z0.v();
            I(z0);
        }

        /* access modifiers changed from: package-private */
        public void F() {
            for (int size = this.f15549c.size() - 1; size >= 0; size--) {
                G(size);
            }
            this.f15549c.clear();
            if (RecyclerView.H4) {
                RecyclerView.this.b4.b();
            }
        }

        /* access modifiers changed from: package-private */
        public void G(int i2) {
            if (RecyclerView.y4) {
                Log.d(RecyclerView.w4, "Recycling cached view at index " + i2);
            }
            ViewHolder viewHolder = this.f15549c.get(i2);
            if (RecyclerView.y4) {
                Log.d(RecyclerView.w4, "CachedViewHolder to be recycled: " + viewHolder);
            }
            a(viewHolder, true);
            this.f15549c.remove(i2);
        }

        public void H(@NonNull View view) {
            ViewHolder z0 = RecyclerView.z0(view);
            if (z0.S()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (z0.R()) {
                z0.g0();
            } else if (z0.h0()) {
                z0.v();
            }
            I(z0);
            if (RecyclerView.this.K3 != null && !z0.P()) {
                RecyclerView.this.K3.k(z0);
            }
        }

        /* access modifiers changed from: package-private */
        public void I(ViewHolder viewHolder) {
            boolean z;
            boolean z2 = false;
            boolean z3 = true;
            if (viewHolder.R() || viewHolder.f15587a.getParent() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(viewHolder.R());
                sb.append(" isAttached:");
                if (viewHolder.f15587a.getParent() != null) {
                    z2 = true;
                }
                sb.append(z2);
                sb.append(RecyclerView.this.d0());
                throw new IllegalArgumentException(sb.toString());
            } else if (viewHolder.S()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + viewHolder + RecyclerView.this.d0());
            } else if (!viewHolder.e0()) {
                boolean y = viewHolder.y();
                Adapter adapter = RecyclerView.this.i3;
                boolean z4 = adapter != null && y && adapter.V(viewHolder);
                if (!RecyclerView.x4 || !this.f15549c.contains(viewHolder)) {
                    if (z4 || viewHolder.P()) {
                        if (this.f15552f <= 0 || viewHolder.K(MetaDo.v)) {
                            z = false;
                        } else {
                            int size = this.f15549c.size();
                            if (size >= this.f15552f && size > 0) {
                                G(0);
                                size--;
                            }
                            if (RecyclerView.H4 && size > 0 && !RecyclerView.this.b4.d(viewHolder.f15589c)) {
                                int i2 = size - 1;
                                while (i2 >= 0) {
                                    if (!RecyclerView.this.b4.d(this.f15549c.get(i2).f15589c)) {
                                        break;
                                    }
                                    i2--;
                                }
                                size = i2 + 1;
                            }
                            this.f15549c.add(size, viewHolder);
                            z = true;
                        }
                        if (!z) {
                            a(viewHolder, true);
                            z2 = z;
                            RecyclerView.this.c3.q(viewHolder);
                            if (!z2 && !z3 && y) {
                                PoolingContainer.b(viewHolder.f15587a);
                                viewHolder.s = null;
                                viewHolder.r = null;
                                return;
                            }
                            return;
                        }
                        z2 = z;
                    } else if (RecyclerView.y4) {
                        Log.d(RecyclerView.w4, "trying to recycle a non-recycleable holder. Hopefully, it will re-visit here. We are still removing it from animation lists" + RecyclerView.this.d0());
                    }
                    z3 = false;
                    RecyclerView.this.c3.q(viewHolder);
                    if (!z2) {
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("cached view received recycle internal? " + viewHolder + RecyclerView.this.d0());
            } else {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.d0());
            }
        }

        /* access modifiers changed from: package-private */
        public void J(View view) {
            ArrayList<ViewHolder> arrayList;
            ViewHolder z0 = RecyclerView.z0(view);
            if (!z0.K(12) && z0.T() && !RecyclerView.this.A(z0)) {
                if (this.f15548b == null) {
                    this.f15548b = new ArrayList<>();
                }
                z0.c0(this, true);
                arrayList = this.f15548b;
            } else if (!z0.O() || z0.Q() || RecyclerView.this.i3.F()) {
                z0.c0(this, false);
                arrayList = this.f15547a;
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.d0());
            }
            arrayList.add(z0);
        }

        /* access modifiers changed from: package-private */
        public void K(RecycledViewPool recycledViewPool) {
            C(RecyclerView.this.i3);
            RecycledViewPool recycledViewPool2 = this.f15553g;
            if (recycledViewPool2 != null) {
                recycledViewPool2.d();
            }
            this.f15553g = recycledViewPool;
            if (!(recycledViewPool == null || RecyclerView.this.getAdapter() == null)) {
                this.f15553g.a();
            }
            v();
        }

        /* access modifiers changed from: package-private */
        public void L(ViewCacheExtension viewCacheExtension) {
            this.f15554h = viewCacheExtension;
        }

        public void M(int i2) {
            this.f15551e = i2;
            Q();
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:105:0x0251  */
        /* JADX WARNING: Removed duplicated region for block: B:107:0x025f  */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0037  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x005c  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x005f  */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x01ca  */
        /* JADX WARNING: Removed duplicated region for block: B:88:0x01f3  */
        /* JADX WARNING: Removed duplicated region for block: B:89:0x01f6  */
        @androidx.annotation.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public androidx.recyclerview.widget.RecyclerView.ViewHolder O(int r19, boolean r20, long r21) {
            /*
                r18 = this;
                r6 = r18
                r3 = r19
                r0 = r20
                if (r3 < 0) goto L_0x027b
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r1 = r1.c4
                int r1 = r1.d()
                if (r3 >= r1) goto L_0x027b
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r1 = r1.c4
                boolean r1 = r1.j()
                r2 = 0
                r7 = 1
                r8 = 0
                if (r1 == 0) goto L_0x0027
                androidx.recyclerview.widget.RecyclerView$ViewHolder r1 = r18.i(r19)
                if (r1 == 0) goto L_0x0028
                r4 = 1
                goto L_0x0029
            L_0x0027:
                r1 = r2
            L_0x0028:
                r4 = 0
            L_0x0029:
                if (r1 != 0) goto L_0x005d
                androidx.recyclerview.widget.RecyclerView$ViewHolder r1 = r18.n(r19, r20)
                if (r1 == 0) goto L_0x005d
                boolean r5 = r6.R(r1)
                if (r5 != 0) goto L_0x005c
                if (r0 != 0) goto L_0x005a
                r5 = 4
                r1.s(r5)
                boolean r5 = r1.R()
                if (r5 == 0) goto L_0x004e
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                android.view.View r9 = r1.f15587a
                r5.removeDetachedView(r9, r8)
                r1.g0()
                goto L_0x0057
            L_0x004e:
                boolean r5 = r1.h0()
                if (r5 == 0) goto L_0x0057
                r1.v()
            L_0x0057:
                r6.I(r1)
            L_0x005a:
                r1 = r2
                goto L_0x005d
            L_0x005c:
                r4 = 1
            L_0x005d:
                if (r1 != 0) goto L_0x0170
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.AdapterHelper r5 = r5.a3
                int r5 = r5.n(r3)
                if (r5 < 0) goto L_0x0173
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r9 = r9.i3
                int r9 = r9.b()
                if (r5 >= r9) goto L_0x0173
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r9 = r9.i3
                int r9 = r9.C(r5)
                androidx.recyclerview.widget.RecyclerView r10 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r10 = r10.i3
                boolean r10 = r10.F()
                if (r10 == 0) goto L_0x0096
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r1 = r1.i3
                long r10 = r1.B(r5)
                androidx.recyclerview.widget.RecyclerView$ViewHolder r1 = r6.m(r10, r9, r0)
                if (r1 == 0) goto L_0x0096
                r1.f15589c = r5
                r4 = 1
            L_0x0096:
                if (r1 != 0) goto L_0x00eb
                androidx.recyclerview.widget.RecyclerView$ViewCacheExtension r0 = r6.f15554h
                if (r0 == 0) goto L_0x00eb
                android.view.View r0 = r0.a(r6, r3, r9)
                if (r0 == 0) goto L_0x00eb
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$ViewHolder r1 = r1.y0(r0)
                if (r1 == 0) goto L_0x00ce
                boolean r0 = r1.e0()
                if (r0 != 0) goto L_0x00b1
                goto L_0x00eb
            L_0x00b1:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view."
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.d0()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x00ce:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "getViewForPositionAndType returned a view which does not have a ViewHolder"
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.d0()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x00eb:
                java.lang.String r0 = "RecyclerView"
                if (r1 != 0) goto L_0x0120
                boolean r1 = androidx.recyclerview.widget.RecyclerView.y4
                if (r1 == 0) goto L_0x010c
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r5 = "tryGetViewHolderForPositionByDeadline("
                r1.append(r5)
                r1.append(r3)
                java.lang.String r5 = ") fetching from shared pool"
                r1.append(r5)
                java.lang.String r1 = r1.toString()
                android.util.Log.d(r0, r1)
            L_0x010c:
                androidx.recyclerview.widget.RecyclerView$RecycledViewPool r1 = r18.j()
                androidx.recyclerview.widget.RecyclerView$ViewHolder r1 = r1.h(r9)
                if (r1 == 0) goto L_0x0120
                r1.Y()
                boolean r5 = androidx.recyclerview.widget.RecyclerView.E4
                if (r5 == 0) goto L_0x0120
                r6.s(r1)
            L_0x0120:
                if (r1 != 0) goto L_0x0170
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                long r16 = r1.getNanoTime()
                r10 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r1 = (r21 > r10 ? 1 : (r21 == r10 ? 0 : -1))
                if (r1 == 0) goto L_0x013f
                androidx.recyclerview.widget.RecyclerView$RecycledViewPool r10 = r6.f15553g
                r11 = r9
                r12 = r16
                r14 = r21
                boolean r1 = r10.q(r11, r12, r14)
                if (r1 != 0) goto L_0x013f
                return r2
            L_0x013f:
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r2 = r1.i3
                androidx.recyclerview.widget.RecyclerView$ViewHolder r1 = r2.z(r1, r9)
                boolean r2 = androidx.recyclerview.widget.RecyclerView.H4
                if (r2 == 0) goto L_0x015a
                android.view.View r2 = r1.f15587a
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.k0(r2)
                if (r2 == 0) goto L_0x015a
                java.lang.ref.WeakReference r5 = new java.lang.ref.WeakReference
                r5.<init>(r2)
                r1.f15588b = r5
            L_0x015a:
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                long r10 = r2.getNanoTime()
                androidx.recyclerview.widget.RecyclerView$RecycledViewPool r2 = r6.f15553g
                long r10 = r10 - r16
                r2.g(r9, r10)
                boolean r2 = androidx.recyclerview.widget.RecyclerView.y4
                if (r2 == 0) goto L_0x0170
                java.lang.String r2 = "tryGetViewHolderForPositionByDeadline created new ViewHolder"
                android.util.Log.d(r0, r2)
            L_0x0170:
                r9 = r1
                r10 = r4
                goto L_0x01ab
            L_0x0173:
                java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Inconsistency detected. Invalid item position "
                r1.append(r2)
                r1.append(r3)
                java.lang.String r2 = "(offset:"
                r1.append(r2)
                r1.append(r5)
                java.lang.String r2 = ").state:"
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r2 = r2.c4
                int r2 = r2.d()
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.d0()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x01ab:
                if (r10 == 0) goto L_0x01e3
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r0 = r0.c4
                boolean r0 = r0.j()
                if (r0 != 0) goto L_0x01e3
                r0 = 8192(0x2000, float:1.14794E-41)
                boolean r1 = r9.K(r0)
                if (r1 == 0) goto L_0x01e3
                r9.a0(r8, r0)
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r0 = r0.c4
                boolean r0 = r0.f15583k
                if (r0 == 0) goto L_0x01e3
                int r0 = androidx.recyclerview.widget.RecyclerView.ItemAnimator.e(r9)
                r0 = r0 | 4096(0x1000, float:5.74E-42)
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$ItemAnimator r2 = r1.K3
                androidx.recyclerview.widget.RecyclerView$State r1 = r1.c4
                java.util.List r4 = r9.J()
                androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemHolderInfo r0 = r2.w(r1, r9, r0, r4)
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                r1.t1(r9, r0)
            L_0x01e3:
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r0 = r0.c4
                boolean r0 = r0.j()
                if (r0 == 0) goto L_0x01f6
                boolean r0 = r9.N()
                if (r0 == 0) goto L_0x01f6
                r9.f15593g = r3
                goto L_0x0209
            L_0x01f6:
                boolean r0 = r9.N()
                if (r0 == 0) goto L_0x020b
                boolean r0 = r9.U()
                if (r0 != 0) goto L_0x020b
                boolean r0 = r9.O()
                if (r0 == 0) goto L_0x0209
                goto L_0x020b
            L_0x0209:
                r0 = 0
                goto L_0x0249
            L_0x020b:
                boolean r0 = androidx.recyclerview.widget.RecyclerView.x4
                if (r0 == 0) goto L_0x0236
                boolean r0 = r9.Q()
                if (r0 != 0) goto L_0x0216
                goto L_0x0236
            L_0x0216:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Removed holder should be bound and it should come here only in pre-layout. Holder: "
                r1.append(r2)
                r1.append(r9)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.d0()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x0236:
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.AdapterHelper r0 = r0.a3
                int r2 = r0.n(r3)
                r0 = r18
                r1 = r9
                r3 = r19
                r4 = r21
                boolean r0 = r0.N(r1, r2, r3, r4)
            L_0x0249:
                android.view.View r1 = r9.f15587a
                android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
                if (r1 != 0) goto L_0x025f
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                android.view.ViewGroup$LayoutParams r1 = r1.generateDefaultLayoutParams()
            L_0x0257:
                androidx.recyclerview.widget.RecyclerView$LayoutParams r1 = (androidx.recyclerview.widget.RecyclerView.LayoutParams) r1
                android.view.View r2 = r9.f15587a
                r2.setLayoutParams(r1)
                goto L_0x0270
            L_0x025f:
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                boolean r2 = r2.checkLayoutParams(r1)
                if (r2 != 0) goto L_0x026e
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                android.view.ViewGroup$LayoutParams r1 = r2.generateLayoutParams((android.view.ViewGroup.LayoutParams) r1)
                goto L_0x0257
            L_0x026e:
                androidx.recyclerview.widget.RecyclerView$LayoutParams r1 = (androidx.recyclerview.widget.RecyclerView.LayoutParams) r1
            L_0x0270:
                r1.f15534a = r9
                if (r10 == 0) goto L_0x0277
                if (r0 == 0) goto L_0x0277
                goto L_0x0278
            L_0x0277:
                r7 = 0
            L_0x0278:
                r1.f15537d = r7
                return r9
            L_0x027b:
                java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Invalid item position "
                r1.append(r2)
                r1.append(r3)
                java.lang.String r2 = "("
                r1.append(r2)
                r1.append(r3)
                java.lang.String r2 = "). Item count:"
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r2 = r2.c4
                int r2 = r2.d()
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.d0()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.Recycler.O(int, boolean, long):androidx.recyclerview.widget.RecyclerView$ViewHolder");
        }

        /* access modifiers changed from: package-private */
        public void P(ViewHolder viewHolder) {
            (viewHolder.o ? this.f15548b : this.f15547a).remove(viewHolder);
            viewHolder.f15600n = null;
            viewHolder.o = false;
            viewHolder.v();
        }

        /* access modifiers changed from: package-private */
        public void Q() {
            LayoutManager layoutManager = RecyclerView.this.j3;
            this.f15552f = this.f15551e + (layoutManager != null ? layoutManager.f15526m : 0);
            for (int size = this.f15549c.size() - 1; size >= 0 && this.f15549c.size() > this.f15552f; size--) {
                G(size);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean R(ViewHolder viewHolder) {
            if (!viewHolder.Q()) {
                int i2 = viewHolder.f15589c;
                if (i2 < 0 || i2 >= RecyclerView.this.i3.b()) {
                    throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + viewHolder + RecyclerView.this.d0());
                } else if (RecyclerView.this.c4.j() || RecyclerView.this.i3.C(viewHolder.f15589c) == viewHolder.F()) {
                    return !RecyclerView.this.i3.F() || viewHolder.E() == RecyclerView.this.i3.B(viewHolder.f15589c);
                } else {
                    return false;
                }
            } else if (!RecyclerView.x4 || RecyclerView.this.c4.j()) {
                return RecyclerView.this.c4.j();
            } else {
                throw new IllegalStateException("should not receive a removed view unless it is pre layout" + RecyclerView.this.d0());
            }
        }

        /* access modifiers changed from: package-private */
        public void S(int i2, int i3) {
            int i4;
            int i5 = i3 + i2;
            for (int size = this.f15549c.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.f15549c.get(size);
                if (viewHolder != null && (i4 = viewHolder.f15589c) >= i2 && i4 < i5) {
                    viewHolder.s(2);
                    G(size);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a(@NonNull ViewHolder viewHolder, boolean z) {
            RecyclerView.C(viewHolder);
            View view = viewHolder.f15587a;
            RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate = RecyclerView.this.j4;
            if (recyclerViewAccessibilityDelegate != null) {
                AccessibilityDelegateCompat n2 = recyclerViewAccessibilityDelegate.n();
                ViewCompat.H1(view, n2 instanceof RecyclerViewAccessibilityDelegate.ItemDelegate ? ((RecyclerViewAccessibilityDelegate.ItemDelegate) n2).n(view) : null);
            }
            if (z) {
                h(viewHolder);
            }
            viewHolder.s = null;
            viewHolder.r = null;
            j().l(viewHolder);
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x005a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void c(@androidx.annotation.NonNull android.view.View r7, int r8) {
            /*
                r6 = this;
                androidx.recyclerview.widget.RecyclerView$ViewHolder r7 = androidx.recyclerview.widget.RecyclerView.z0(r7)
                if (r7 == 0) goto L_0x0096
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.AdapterHelper r0 = r0.a3
                int r2 = r0.n(r8)
                if (r2 < 0) goto L_0x005e
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r0 = r0.i3
                int r0 = r0.b()
                if (r2 >= r0) goto L_0x005e
                r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                r0 = r6
                r1 = r7
                r3 = r8
                r0.N(r1, r2, r3, r4)
                android.view.View r8 = r7.f15587a
                android.view.ViewGroup$LayoutParams r8 = r8.getLayoutParams()
                if (r8 != 0) goto L_0x003b
                androidx.recyclerview.widget.RecyclerView r8 = androidx.recyclerview.widget.RecyclerView.this
                android.view.ViewGroup$LayoutParams r8 = r8.generateDefaultLayoutParams()
            L_0x0033:
                androidx.recyclerview.widget.RecyclerView$LayoutParams r8 = (androidx.recyclerview.widget.RecyclerView.LayoutParams) r8
                android.view.View r0 = r7.f15587a
                r0.setLayoutParams(r8)
                goto L_0x004c
            L_0x003b:
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                boolean r0 = r0.checkLayoutParams(r8)
                if (r0 != 0) goto L_0x004a
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                android.view.ViewGroup$LayoutParams r8 = r0.generateLayoutParams((android.view.ViewGroup.LayoutParams) r8)
                goto L_0x0033
            L_0x004a:
                androidx.recyclerview.widget.RecyclerView$LayoutParams r8 = (androidx.recyclerview.widget.RecyclerView.LayoutParams) r8
            L_0x004c:
                r0 = 1
                r8.f15536c = r0
                r8.f15534a = r7
                android.view.View r7 = r7.f15587a
                android.view.ViewParent r7 = r7.getParent()
                if (r7 != 0) goto L_0x005a
                goto L_0x005b
            L_0x005a:
                r0 = 0
            L_0x005b:
                r8.f15537d = r0
                return
            L_0x005e:
                java.lang.IndexOutOfBoundsException r7 = new java.lang.IndexOutOfBoundsException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Inconsistency detected. Invalid item position "
                r0.append(r1)
                r0.append(r8)
                java.lang.String r8 = "(offset:"
                r0.append(r8)
                r0.append(r2)
                java.lang.String r8 = ").state:"
                r0.append(r8)
                androidx.recyclerview.widget.RecyclerView r8 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r8 = r8.c4
                int r8 = r8.d()
                r0.append(r8)
                androidx.recyclerview.widget.RecyclerView r8 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r8 = r8.d0()
                r0.append(r8)
                java.lang.String r8 = r0.toString()
                r7.<init>(r8)
                throw r7
            L_0x0096:
                java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                java.lang.String r0 = "The view does not have a ViewHolder. You cannot pass arbitrary views to this method, they should be created by the Adapter"
                r8.append(r0)
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r0 = r0.d0()
                r8.append(r0)
                java.lang.String r8 = r8.toString()
                r7.<init>(r8)
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.Recycler.c(android.view.View, int):void");
        }

        public void d() {
            this.f15547a.clear();
            F();
        }

        /* access modifiers changed from: package-private */
        public void e() {
            int size = this.f15549c.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f15549c.get(i2).t();
            }
            int size2 = this.f15547a.size();
            for (int i3 = 0; i3 < size2; i3++) {
                this.f15547a.get(i3).t();
            }
            ArrayList<ViewHolder> arrayList = this.f15548b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i4 = 0; i4 < size3; i4++) {
                    this.f15548b.get(i4).t();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void f() {
            this.f15547a.clear();
            ArrayList<ViewHolder> arrayList = this.f15548b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        public int g(int i2) {
            if (i2 >= 0 && i2 < RecyclerView.this.c4.d()) {
                return !RecyclerView.this.c4.j() ? i2 : RecyclerView.this.a3.n(i2);
            }
            throw new IndexOutOfBoundsException("invalid position " + i2 + ". State item count is " + RecyclerView.this.c4.d() + RecyclerView.this.d0());
        }

        /* access modifiers changed from: package-private */
        public void h(@NonNull ViewHolder viewHolder) {
            RecyclerListener recyclerListener = RecyclerView.this.k3;
            if (recyclerListener != null) {
                recyclerListener.a(viewHolder);
            }
            int size = RecyclerView.this.l3.size();
            for (int i2 = 0; i2 < size; i2++) {
                RecyclerView.this.l3.get(i2).a(viewHolder);
            }
            Adapter adapter = RecyclerView.this.i3;
            if (adapter != null) {
                adapter.Y(viewHolder);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.c4 != null) {
                recyclerView.c3.q(viewHolder);
            }
            if (RecyclerView.y4) {
                Log.d(RecyclerView.w4, "dispatchViewRecycled: " + viewHolder);
            }
        }

        /* access modifiers changed from: package-private */
        public ViewHolder i(int i2) {
            int size;
            int n2;
            ArrayList<ViewHolder> arrayList = this.f15548b;
            if (!(arrayList == null || (size = arrayList.size()) == 0)) {
                int i3 = 0;
                int i4 = 0;
                while (i4 < size) {
                    ViewHolder viewHolder = this.f15548b.get(i4);
                    if (viewHolder.h0() || viewHolder.G() != i2) {
                        i4++;
                    } else {
                        viewHolder.s(32);
                        return viewHolder;
                    }
                }
                if (RecyclerView.this.i3.F() && (n2 = RecyclerView.this.a3.n(i2)) > 0 && n2 < RecyclerView.this.i3.b()) {
                    long B = RecyclerView.this.i3.B(n2);
                    while (i3 < size) {
                        ViewHolder viewHolder2 = this.f15548b.get(i3);
                        if (viewHolder2.h0() || viewHolder2.E() != B) {
                            i3++;
                        } else {
                            viewHolder2.s(32);
                            return viewHolder2;
                        }
                    }
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public RecycledViewPool j() {
            if (this.f15553g == null) {
                this.f15553g = new RecycledViewPool();
                v();
            }
            return this.f15553g;
        }

        /* access modifiers changed from: package-private */
        public int k() {
            return this.f15547a.size();
        }

        @NonNull
        public List<ViewHolder> l() {
            return this.f15550d;
        }

        /* access modifiers changed from: package-private */
        public ViewHolder m(long j2, int i2, boolean z) {
            for (int size = this.f15547a.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.f15547a.get(size);
                if (viewHolder.E() == j2 && !viewHolder.h0()) {
                    if (i2 == viewHolder.F()) {
                        viewHolder.s(32);
                        if (viewHolder.Q() && !RecyclerView.this.c4.j()) {
                            viewHolder.a0(2, 14);
                        }
                        return viewHolder;
                    } else if (!z) {
                        this.f15547a.remove(size);
                        RecyclerView.this.removeDetachedView(viewHolder.f15587a, false);
                        E(viewHolder.f15587a);
                    }
                }
            }
            int size2 = this.f15549c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                ViewHolder viewHolder2 = this.f15549c.get(size2);
                if (viewHolder2.E() == j2 && !viewHolder2.M()) {
                    if (i2 == viewHolder2.F()) {
                        if (!z) {
                            this.f15549c.remove(size2);
                        }
                        return viewHolder2;
                    } else if (!z) {
                        G(size2);
                        return null;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public ViewHolder n(int i2, boolean z) {
            View e2;
            int size = this.f15547a.size();
            int i3 = 0;
            int i4 = 0;
            while (i4 < size) {
                ViewHolder viewHolder = this.f15547a.get(i4);
                if (viewHolder.h0() || viewHolder.G() != i2 || viewHolder.O() || (!RecyclerView.this.c4.f15580h && viewHolder.Q())) {
                    i4++;
                } else {
                    viewHolder.s(32);
                    return viewHolder;
                }
            }
            if (z || (e2 = RecyclerView.this.b3.e(i2)) == null) {
                int size2 = this.f15549c.size();
                while (i3 < size2) {
                    ViewHolder viewHolder2 = this.f15549c.get(i3);
                    if (viewHolder2.O() || viewHolder2.G() != i2 || viewHolder2.M()) {
                        i3++;
                    } else {
                        if (!z) {
                            this.f15549c.remove(i3);
                        }
                        if (RecyclerView.y4) {
                            Log.d(RecyclerView.w4, "getScrapOrHiddenOrCachedHolderForPosition(" + i2 + ") found match in cache: " + viewHolder2);
                        }
                        return viewHolder2;
                    }
                }
                return null;
            }
            ViewHolder z0 = RecyclerView.z0(e2);
            RecyclerView.this.b3.s(e2);
            int m2 = RecyclerView.this.b3.m(e2);
            if (m2 != -1) {
                RecyclerView.this.b3.d(m2);
                J(e2);
                z0.s(8224);
                return z0;
            }
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + z0 + RecyclerView.this.d0());
        }

        /* access modifiers changed from: package-private */
        public View o(int i2) {
            return this.f15547a.get(i2).f15587a;
        }

        @NonNull
        public View p(int i2) {
            return q(i2, false);
        }

        /* access modifiers changed from: package-private */
        public View q(int i2, boolean z) {
            return O(i2, z, Long.MAX_VALUE).f15587a;
        }

        /* access modifiers changed from: package-private */
        public void t() {
            int size = this.f15549c.size();
            for (int i2 = 0; i2 < size; i2++) {
                LayoutParams layoutParams = (LayoutParams) this.f15549c.get(i2).f15587a.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.f15536c = true;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void u() {
            int size = this.f15549c.size();
            for (int i2 = 0; i2 < size; i2++) {
                ViewHolder viewHolder = this.f15549c.get(i2);
                if (viewHolder != null) {
                    viewHolder.s(6);
                    viewHolder.r((Object) null);
                }
            }
            Adapter adapter = RecyclerView.this.i3;
            if (adapter == null || !adapter.F()) {
                F();
            }
        }

        /* access modifiers changed from: package-private */
        public void w(int i2, int i3) {
            int size = this.f15549c.size();
            for (int i4 = 0; i4 < size; i4++) {
                ViewHolder viewHolder = this.f15549c.get(i4);
                if (viewHolder != null && viewHolder.f15589c >= i2) {
                    if (RecyclerView.y4) {
                        Log.d(RecyclerView.w4, "offsetPositionRecordsForInsert cached " + i4 + " holder " + viewHolder + " now at position " + (viewHolder.f15589c + i3));
                    }
                    viewHolder.V(i3, false);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void x(int i2, int i3) {
            int i4;
            int i5;
            int i6;
            int i7;
            if (i2 < i3) {
                i6 = -1;
                i5 = i2;
                i4 = i3;
            } else {
                i6 = 1;
                i4 = i2;
                i5 = i3;
            }
            int size = this.f15549c.size();
            for (int i8 = 0; i8 < size; i8++) {
                ViewHolder viewHolder = this.f15549c.get(i8);
                if (viewHolder != null && (i7 = viewHolder.f15589c) >= i5 && i7 <= i4) {
                    if (i7 == i2) {
                        viewHolder.V(i3 - i2, false);
                    } else {
                        viewHolder.V(i6, false);
                    }
                    if (RecyclerView.y4) {
                        Log.d(RecyclerView.w4, "offsetPositionRecordsForMove cached child " + i8 + " holder " + viewHolder);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void y(int i2, int i3, boolean z) {
            int i4 = i2 + i3;
            for (int size = this.f15549c.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.f15549c.get(size);
                if (viewHolder != null) {
                    int i5 = viewHolder.f15589c;
                    if (i5 >= i4) {
                        if (RecyclerView.y4) {
                            Log.d(RecyclerView.w4, "offsetPositionRecordsForRemove cached " + size + " holder " + viewHolder + " now at position " + (viewHolder.f15589c - i3));
                        }
                        viewHolder.V(-i3, z);
                    } else if (i5 >= i2) {
                        viewHolder.s(8);
                        G(size);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void z(Adapter<?> adapter, Adapter<?> adapter2, boolean z) {
            d();
            D(adapter, true);
            j().k(adapter, adapter2, z);
            v();
        }
    }

    public interface RecyclerListener {
        void a(@NonNull ViewHolder viewHolder);
    }

    private class RecyclerViewDataObserver extends AdapterDataObserver {
        RecyclerViewDataObserver() {
        }

        public void a() {
            RecyclerView.this.z((String) null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.c4.f15579g = true;
            recyclerView.r1(true);
            if (!RecyclerView.this.a3.q()) {
                RecyclerView.this.requestLayout();
            }
        }

        public void c(int i2, int i3, Object obj) {
            RecyclerView.this.z((String) null);
            if (RecyclerView.this.a3.s(i2, i3, obj)) {
                h();
            }
        }

        public void d(int i2, int i3) {
            RecyclerView.this.z((String) null);
            if (RecyclerView.this.a3.t(i2, i3)) {
                h();
            }
        }

        public void e(int i2, int i3, int i4) {
            RecyclerView.this.z((String) null);
            if (RecyclerView.this.a3.u(i2, i3, i4)) {
                h();
            }
        }

        public void f(int i2, int i3) {
            RecyclerView.this.z((String) null);
            if (RecyclerView.this.a3.v(i2, i3)) {
                h();
            }
        }

        public void g() {
            Adapter adapter;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.Z2 != null && (adapter = recyclerView.i3) != null && adapter.y()) {
                RecyclerView.this.requestLayout();
            }
        }

        /* access modifiers changed from: package-private */
        public void h() {
            if (RecyclerView.G4) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.q3 && recyclerView.p3) {
                    ViewCompat.v1(recyclerView, recyclerView.e3);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.y3 = true;
            recyclerView2.requestLayout();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: c */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };
        Parcelable Y;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.Y = parcel.readParcelable(classLoader == null ? LayoutManager.class.getClassLoader() : classLoader);
        }

        /* access modifiers changed from: package-private */
        public void b(SavedState savedState) {
            this.Y = savedState.Y;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeParcelable(this.Y, 0);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public static class SimpleOnItemTouchListener implements OnItemTouchListener {
        public void a(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        }

        public boolean c(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            return false;
        }

        public void e(boolean z) {
        }
    }

    public static abstract class SmoothScroller {

        /* renamed from: a  reason: collision with root package name */
        private int f15557a = -1;

        /* renamed from: b  reason: collision with root package name */
        private RecyclerView f15558b;

        /* renamed from: c  reason: collision with root package name */
        private LayoutManager f15559c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f15560d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f15561e;

        /* renamed from: f  reason: collision with root package name */
        private View f15562f;

        /* renamed from: g  reason: collision with root package name */
        private final Action f15563g = new Action(0, 0);

        /* renamed from: h  reason: collision with root package name */
        private boolean f15564h;

        public static class Action {

            /* renamed from: h  reason: collision with root package name */
            public static final int f15565h = Integer.MIN_VALUE;

            /* renamed from: a  reason: collision with root package name */
            private int f15566a;

            /* renamed from: b  reason: collision with root package name */
            private int f15567b;

            /* renamed from: c  reason: collision with root package name */
            private int f15568c;

            /* renamed from: d  reason: collision with root package name */
            private int f15569d;

            /* renamed from: e  reason: collision with root package name */
            private Interpolator f15570e;

            /* renamed from: f  reason: collision with root package name */
            private boolean f15571f;

            /* renamed from: g  reason: collision with root package name */
            private int f15572g;

            public Action(@Px int i2, @Px int i3) {
                this(i2, i3, Integer.MIN_VALUE, (Interpolator) null);
            }

            private void m() {
                if (this.f15570e != null && this.f15568c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                } else if (this.f15568c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            public int a() {
                return this.f15568c;
            }

            @Px
            public int b() {
                return this.f15566a;
            }

            @Px
            public int c() {
                return this.f15567b;
            }

            @Nullable
            public Interpolator d() {
                return this.f15570e;
            }

            /* access modifiers changed from: package-private */
            public boolean e() {
                return this.f15569d >= 0;
            }

            public void f(int i2) {
                this.f15569d = i2;
            }

            /* access modifiers changed from: package-private */
            public void g(RecyclerView recyclerView) {
                int i2 = this.f15569d;
                if (i2 >= 0) {
                    this.f15569d = -1;
                    recyclerView.W0(i2);
                    this.f15571f = false;
                } else if (this.f15571f) {
                    m();
                    recyclerView.Z3.e(this.f15566a, this.f15567b, this.f15568c, this.f15570e);
                    int i3 = this.f15572g + 1;
                    this.f15572g = i3;
                    if (i3 > 10) {
                        Log.e(RecyclerView.w4, "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f15571f = false;
                } else {
                    this.f15572g = 0;
                }
            }

            public void h(int i2) {
                this.f15571f = true;
                this.f15568c = i2;
            }

            public void i(@Px int i2) {
                this.f15571f = true;
                this.f15566a = i2;
            }

            public void j(@Px int i2) {
                this.f15571f = true;
                this.f15567b = i2;
            }

            public void k(@Nullable Interpolator interpolator) {
                this.f15571f = true;
                this.f15570e = interpolator;
            }

            public void l(@Px int i2, @Px int i3, int i4, @Nullable Interpolator interpolator) {
                this.f15566a = i2;
                this.f15567b = i3;
                this.f15568c = i4;
                this.f15570e = interpolator;
                this.f15571f = true;
            }

            public Action(@Px int i2, @Px int i3, int i4) {
                this(i2, i3, i4, (Interpolator) null);
            }

            public Action(@Px int i2, @Px int i3, int i4, @Nullable Interpolator interpolator) {
                this.f15569d = -1;
                this.f15571f = false;
                this.f15572g = 0;
                this.f15566a = i2;
                this.f15567b = i3;
                this.f15568c = i4;
                this.f15570e = interpolator;
            }
        }

        public interface ScrollVectorProvider {
            @Nullable
            PointF a(int i2);
        }

        @Nullable
        public PointF a(int i2) {
            LayoutManager e2 = e();
            if (e2 instanceof ScrollVectorProvider) {
                return ((ScrollVectorProvider) e2).a(i2);
            }
            Log.w(RecyclerView.w4, "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + ScrollVectorProvider.class.getCanonicalName());
            return null;
        }

        public View b(int i2) {
            return this.f15558b.j3.O(i2);
        }

        public int c() {
            return this.f15558b.j3.V();
        }

        public int d(View view) {
            return this.f15558b.w0(view);
        }

        @Nullable
        public LayoutManager e() {
            return this.f15559c;
        }

        public int f() {
            return this.f15557a;
        }

        @Deprecated
        public void g(int i2) {
            this.f15558b.O1(i2);
        }

        public boolean h() {
            return this.f15560d;
        }

        public boolean i() {
            return this.f15561e;
        }

        /* access modifiers changed from: protected */
        public void j(@NonNull PointF pointF) {
            float f2 = pointF.x;
            float f3 = pointF.y;
            float sqrt = (float) Math.sqrt((double) ((f2 * f2) + (f3 * f3)));
            pointF.x /= sqrt;
            pointF.y /= sqrt;
        }

        /* access modifiers changed from: package-private */
        public void k(int i2, int i3) {
            PointF a2;
            RecyclerView recyclerView = this.f15558b;
            if (this.f15557a == -1 || recyclerView == null) {
                s();
            }
            if (this.f15560d && this.f15562f == null && this.f15559c != null && (a2 = a(this.f15557a)) != null) {
                float f2 = a2.x;
                if (!(f2 == 0.0f && a2.y == 0.0f)) {
                    recyclerView.N1((int) Math.signum(f2), (int) Math.signum(a2.y), (int[]) null);
                }
            }
            this.f15560d = false;
            View view = this.f15562f;
            if (view != null) {
                if (d(view) == this.f15557a) {
                    p(this.f15562f, recyclerView.c4, this.f15563g);
                    this.f15563g.g(recyclerView);
                    s();
                } else {
                    Log.e(RecyclerView.w4, "Passed over target position while smooth scrolling.");
                    this.f15562f = null;
                }
            }
            if (this.f15561e) {
                m(i2, i3, recyclerView.c4, this.f15563g);
                boolean e2 = this.f15563g.e();
                this.f15563g.g(recyclerView);
                if (e2 && this.f15561e) {
                    this.f15560d = true;
                    recyclerView.Z3.d();
                }
            }
        }

        /* access modifiers changed from: protected */
        public void l(View view) {
            if (d(view) == f()) {
                this.f15562f = view;
                if (RecyclerView.y4) {
                    Log.d(RecyclerView.w4, "smooth scroll target view has been attached");
                }
            }
        }

        /* access modifiers changed from: protected */
        public abstract void m(@Px int i2, @Px int i3, @NonNull State state, @NonNull Action action);

        /* access modifiers changed from: protected */
        public abstract void n();

        /* access modifiers changed from: protected */
        public abstract void o();

        /* access modifiers changed from: protected */
        public abstract void p(@NonNull View view, @NonNull State state, @NonNull Action action);

        public void q(int i2) {
            this.f15557a = i2;
        }

        /* access modifiers changed from: package-private */
        public void r(RecyclerView recyclerView, LayoutManager layoutManager) {
            recyclerView.Z3.f();
            if (this.f15564h) {
                Log.w(RecyclerView.w4, "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.f15558b = recyclerView;
            this.f15559c = layoutManager;
            int i2 = this.f15557a;
            if (i2 != -1) {
                recyclerView.c4.f15573a = i2;
                this.f15561e = true;
                this.f15560d = true;
                this.f15562f = b(f());
                n();
                this.f15558b.Z3.d();
                this.f15564h = true;
                return;
            }
            throw new IllegalArgumentException("Invalid target position");
        }

        /* access modifiers changed from: protected */
        public final void s() {
            if (this.f15561e) {
                this.f15561e = false;
                o();
                this.f15558b.c4.f15573a = -1;
                this.f15562f = null;
                this.f15557a = -1;
                this.f15560d = false;
                this.f15559c.A1(this);
                this.f15559c = null;
                this.f15558b = null;
            }
        }
    }

    public static class State {
        static final int r = 1;
        static final int s = 2;
        static final int t = 4;

        /* renamed from: a  reason: collision with root package name */
        int f15573a = -1;

        /* renamed from: b  reason: collision with root package name */
        private SparseArray<Object> f15574b;

        /* renamed from: c  reason: collision with root package name */
        int f15575c = 0;

        /* renamed from: d  reason: collision with root package name */
        int f15576d = 0;

        /* renamed from: e  reason: collision with root package name */
        int f15577e = 1;

        /* renamed from: f  reason: collision with root package name */
        int f15578f = 0;

        /* renamed from: g  reason: collision with root package name */
        boolean f15579g = false;

        /* renamed from: h  reason: collision with root package name */
        boolean f15580h = false;

        /* renamed from: i  reason: collision with root package name */
        boolean f15581i = false;

        /* renamed from: j  reason: collision with root package name */
        boolean f15582j = false;

        /* renamed from: k  reason: collision with root package name */
        boolean f15583k = false;

        /* renamed from: l  reason: collision with root package name */
        boolean f15584l = false;

        /* renamed from: m  reason: collision with root package name */
        int f15585m;

        /* renamed from: n  reason: collision with root package name */
        long f15586n;
        int o;
        int p;
        int q;

        /* access modifiers changed from: package-private */
        public void a(int i2) {
            if ((this.f15577e & i2) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i2) + " but it is " + Integer.toBinaryString(this.f15577e));
            }
        }

        public boolean b() {
            return this.f15579g;
        }

        public <T> T c(int i2) {
            SparseArray<Object> sparseArray = this.f15574b;
            if (sparseArray == null) {
                return null;
            }
            return sparseArray.get(i2);
        }

        public int d() {
            return this.f15580h ? this.f15575c - this.f15576d : this.f15578f;
        }

        public int e() {
            return this.p;
        }

        public int f() {
            return this.q;
        }

        public int g() {
            return this.f15573a;
        }

        public boolean h() {
            return this.f15573a != -1;
        }

        public boolean i() {
            return this.f15582j;
        }

        public boolean j() {
            return this.f15580h;
        }

        /* access modifiers changed from: package-private */
        public void k(Adapter adapter) {
            this.f15577e = 1;
            this.f15578f = adapter.b();
            this.f15580h = false;
            this.f15581i = false;
            this.f15582j = false;
        }

        public void l(int i2, Object obj) {
            if (this.f15574b == null) {
                this.f15574b = new SparseArray<>();
            }
            this.f15574b.put(i2, obj);
        }

        public void m(int i2) {
            SparseArray<Object> sparseArray = this.f15574b;
            if (sparseArray != null) {
                sparseArray.remove(i2);
            }
        }

        public boolean n() {
            return this.f15584l;
        }

        public boolean o() {
            return this.f15583k;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f15573a + ", mData=" + this.f15574b + ", mItemCount=" + this.f15578f + ", mIsMeasuring=" + this.f15582j + ", mPreviousLayoutItemCount=" + this.f15575c + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f15576d + ", mStructureChanged=" + this.f15579g + ", mInPreLayout=" + this.f15580h + ", mRunSimpleAnimations=" + this.f15583k + ", mRunPredictiveAnimations=" + this.f15584l + ASCIIPropertyListParser.f18653k;
        }
    }

    static class StretchEdgeEffectFactory extends EdgeEffectFactory {
        StretchEdgeEffectFactory() {
        }

        /* access modifiers changed from: protected */
        @NonNull
        public EdgeEffect a(@NonNull RecyclerView recyclerView, int i2) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static abstract class ViewCacheExtension {
        @Nullable
        public abstract View a(@NonNull Recycler recycler, int i2, int i3);
    }

    class ViewFlinger implements Runnable {
        private int X;
        private boolean X2 = false;
        OverScroller Y;
        private boolean Y2 = false;
        Interpolator Z;
        private int s;

        ViewFlinger() {
            Interpolator interpolator = RecyclerView.k5;
            this.Z = interpolator;
            this.Y = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        private int a(int i2, int i3) {
            int abs = Math.abs(i2);
            int abs2 = Math.abs(i3);
            boolean z = abs > abs2;
            RecyclerView recyclerView = RecyclerView.this;
            int width = z ? recyclerView.getWidth() : recyclerView.getHeight();
            if (!z) {
                abs = abs2;
            }
            return Math.min((int) (((((float) abs) / ((float) width)) + 1.0f) * 300.0f), 2000);
        }

        private void c() {
            RecyclerView.this.removeCallbacks(this);
            ViewCompat.v1(RecyclerView.this, this);
        }

        public void b(int i2, int i3) {
            RecyclerView.this.setScrollState(2);
            this.X = 0;
            this.s = 0;
            Interpolator interpolator = this.Z;
            Interpolator interpolator2 = RecyclerView.k5;
            if (interpolator != interpolator2) {
                this.Z = interpolator2;
                this.Y = new OverScroller(RecyclerView.this.getContext(), interpolator2);
            }
            this.Y.fling(0, 0, i2, i3, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            d();
        }

        /* access modifiers changed from: package-private */
        public void d() {
            if (this.X2) {
                this.Y2 = true;
            } else {
                c();
            }
        }

        public void e(int i2, int i3, int i4, @Nullable Interpolator interpolator) {
            if (i4 == Integer.MIN_VALUE) {
                i4 = a(i2, i3);
            }
            int i5 = i4;
            if (interpolator == null) {
                interpolator = RecyclerView.k5;
            }
            if (this.Z != interpolator) {
                this.Z = interpolator;
                this.Y = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.X = 0;
            this.s = 0;
            RecyclerView.this.setScrollState(2);
            this.Y.startScroll(0, 0, i2, i3, i5);
            if (Build.VERSION.SDK_INT < 23) {
                this.Y.computeScrollOffset();
            }
            d();
        }

        public void f() {
            RecyclerView.this.removeCallbacks(this);
            this.Y.abortAnimation();
        }

        public void run() {
            int i2;
            int i3;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.j3 == null) {
                f();
                return;
            }
            this.Y2 = false;
            this.X2 = true;
            recyclerView.K();
            OverScroller overScroller = this.Y;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i4 = currX - this.s;
                int i5 = currY - this.X;
                this.s = currX;
                this.X = currY;
                int H = RecyclerView.this.H(i4);
                int J = RecyclerView.this.J(i5);
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.p4;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.b(H, J, iArr, (int[]) null, 1)) {
                    int[] iArr2 = RecyclerView.this.p4;
                    H -= iArr2[0];
                    J -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.G(H, J);
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                if (recyclerView3.i3 != null) {
                    int[] iArr3 = recyclerView3.p4;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView3.N1(H, J, iArr3);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    int[] iArr4 = recyclerView4.p4;
                    i2 = iArr4[0];
                    i3 = iArr4[1];
                    H -= i2;
                    J -= i3;
                    SmoothScroller smoothScroller = recyclerView4.j3.f15520g;
                    if (smoothScroller != null && !smoothScroller.h() && smoothScroller.i()) {
                        int d2 = RecyclerView.this.c4.d();
                        if (d2 == 0) {
                            smoothScroller.s();
                        } else {
                            if (smoothScroller.f() >= d2) {
                                smoothScroller.q(d2 - 1);
                            }
                            smoothScroller.k(i2, i3);
                        }
                    }
                } else {
                    i3 = 0;
                    i2 = 0;
                }
                if (!RecyclerView.this.m3.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                int[] iArr5 = recyclerView5.p4;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView5.c(i2, i3, H, J, (int[]) null, 1, iArr5);
                RecyclerView recyclerView6 = RecyclerView.this;
                int[] iArr6 = recyclerView6.p4;
                int i6 = H - iArr6[0];
                int i7 = J - iArr6[1];
                if (!(i2 == 0 && i3 == 0)) {
                    recyclerView6.W(i2, i3);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i6 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i7 != 0));
                SmoothScroller smoothScroller2 = RecyclerView.this.j3.f15520g;
                if ((smoothScroller2 == null || !smoothScroller2.h()) && z) {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        int i8 = i6 < 0 ? -currVelocity : i6 > 0 ? currVelocity : 0;
                        if (i7 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i7 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.g(i8, currVelocity);
                    }
                    if (RecyclerView.H4) {
                        RecyclerView.this.b4.b();
                    }
                } else {
                    d();
                    RecyclerView recyclerView7 = RecyclerView.this;
                    GapWorker gapWorker = recyclerView7.a4;
                    if (gapWorker != null) {
                        gapWorker.f(recyclerView7, i2, i3);
                    }
                }
            }
            SmoothScroller smoothScroller3 = RecyclerView.this.j3.f15520g;
            if (smoothScroller3 != null && smoothScroller3.h()) {
                smoothScroller3.k(0, 0);
            }
            this.X2 = false;
            if (this.Y2) {
                c();
                return;
            }
            RecyclerView.this.setScrollState(0);
            RecyclerView.this.h(1);
        }
    }

    public static abstract class ViewHolder {
        static final int A = 256;
        static final int B = 512;
        static final int C = 1024;
        static final int D = 2048;
        static final int E = 4096;
        static final int F = -1;
        static final int G = 8192;
        private static final List<Object> H = Collections.emptyList();
        static final int t = 1;
        static final int u = 2;
        static final int v = 4;
        static final int w = 8;
        static final int x = 16;
        static final int y = 32;
        static final int z = 128;
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        public final View f15587a;

        /* renamed from: b  reason: collision with root package name */
        WeakReference<RecyclerView> f15588b;

        /* renamed from: c  reason: collision with root package name */
        int f15589c = -1;

        /* renamed from: d  reason: collision with root package name */
        int f15590d = -1;

        /* renamed from: e  reason: collision with root package name */
        long f15591e = -1;

        /* renamed from: f  reason: collision with root package name */
        int f15592f = -1;

        /* renamed from: g  reason: collision with root package name */
        int f15593g = -1;

        /* renamed from: h  reason: collision with root package name */
        ViewHolder f15594h = null;

        /* renamed from: i  reason: collision with root package name */
        ViewHolder f15595i = null;

        /* renamed from: j  reason: collision with root package name */
        int f15596j;

        /* renamed from: k  reason: collision with root package name */
        List<Object> f15597k = null;

        /* renamed from: l  reason: collision with root package name */
        List<Object> f15598l = null;

        /* renamed from: m  reason: collision with root package name */
        private int f15599m = 0;

        /* renamed from: n  reason: collision with root package name */
        Recycler f15600n = null;
        boolean o = false;
        private int p = 0;
        @VisibleForTesting
        int q = -1;
        RecyclerView r;
        Adapter<? extends ViewHolder> s;

        public ViewHolder(@NonNull View view) {
            if (view != null) {
                this.f15587a = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        private void x() {
            if (this.f15597k == null) {
                ArrayList arrayList = new ArrayList();
                this.f15597k = arrayList;
                this.f15598l = Collections.unmodifiableList(arrayList);
            }
        }

        public final int A() {
            RecyclerView recyclerView = this.r;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.s0(this);
        }

        @Deprecated
        public final int B() {
            return D();
        }

        @Nullable
        public final Adapter<? extends ViewHolder> C() {
            return this.s;
        }

        public final int D() {
            RecyclerView recyclerView;
            Adapter adapter;
            int s0;
            if (this.s == null || (recyclerView = this.r) == null || (adapter = recyclerView.getAdapter()) == null || (s0 = this.r.s0(this)) == -1) {
                return -1;
            }
            return adapter.A(this.s, this, s0);
        }

        public final long E() {
            return this.f15591e;
        }

        public final int F() {
            return this.f15592f;
        }

        public final int G() {
            int i2 = this.f15593g;
            return i2 == -1 ? this.f15589c : i2;
        }

        public final int H() {
            return this.f15590d;
        }

        @Deprecated
        public final int I() {
            int i2 = this.f15593g;
            return i2 == -1 ? this.f15589c : i2;
        }

        /* access modifiers changed from: package-private */
        public List<Object> J() {
            if ((this.f15596j & 1024) != 0) {
                return H;
            }
            List<Object> list = this.f15597k;
            return (list == null || list.size() == 0) ? H : this.f15598l;
        }

        /* access modifiers changed from: package-private */
        public boolean K(int i2) {
            return (i2 & this.f15596j) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean L() {
            return (this.f15596j & 512) != 0 || O();
        }

        /* access modifiers changed from: package-private */
        public boolean M() {
            return (this.f15587a.getParent() == null || this.f15587a.getParent() == this.r) ? false : true;
        }

        /* access modifiers changed from: package-private */
        public boolean N() {
            return (this.f15596j & 1) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean O() {
            return (this.f15596j & 4) != 0;
        }

        public final boolean P() {
            return (this.f15596j & 16) == 0 && !ViewCompat.P0(this.f15587a);
        }

        /* access modifiers changed from: package-private */
        public boolean Q() {
            return (this.f15596j & 8) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean R() {
            return this.f15600n != null;
        }

        /* access modifiers changed from: package-private */
        public boolean S() {
            return (this.f15596j & 256) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean T() {
            return (this.f15596j & 2) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean U() {
            return (this.f15596j & 2) != 0;
        }

        /* access modifiers changed from: package-private */
        public void V(int i2, boolean z2) {
            if (this.f15590d == -1) {
                this.f15590d = this.f15589c;
            }
            if (this.f15593g == -1) {
                this.f15593g = this.f15589c;
            }
            if (z2) {
                this.f15593g += i2;
            }
            this.f15589c += i2;
            if (this.f15587a.getLayoutParams() != null) {
                ((LayoutParams) this.f15587a.getLayoutParams()).f15536c = true;
            }
        }

        /* access modifiers changed from: package-private */
        public void W(RecyclerView recyclerView) {
            int i2 = this.q;
            if (i2 == -1) {
                i2 = ViewCompat.X(this.f15587a);
            }
            this.p = i2;
            recyclerView.Q1(this, 4);
        }

        /* access modifiers changed from: package-private */
        public void X(RecyclerView recyclerView) {
            recyclerView.Q1(this, this.p);
            this.p = 0;
        }

        /* access modifiers changed from: package-private */
        public void Y() {
            if (!RecyclerView.x4 || !S()) {
                this.f15596j = 0;
                this.f15589c = -1;
                this.f15590d = -1;
                this.f15591e = -1;
                this.f15593g = -1;
                this.f15599m = 0;
                this.f15594h = null;
                this.f15595i = null;
                u();
                this.p = 0;
                this.q = -1;
                RecyclerView.C(this);
                return;
            }
            throw new IllegalStateException("Attempting to reset temp-detached ViewHolder: " + this + ". ViewHolders should be fully detached before resetting.");
        }

        /* access modifiers changed from: package-private */
        public void Z() {
            if (this.f15590d == -1) {
                this.f15590d = this.f15589c;
            }
        }

        /* access modifiers changed from: package-private */
        public void a0(int i2, int i3) {
            this.f15596j = (i2 & i3) | (this.f15596j & (~i3));
        }

        public final void b0(boolean z2) {
            int i2;
            int i3 = this.f15599m;
            int i4 = z2 ? i3 - 1 : i3 + 1;
            this.f15599m = i4;
            if (i4 < 0) {
                this.f15599m = 0;
                if (!RecyclerView.x4) {
                    Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                } else {
                    throw new RuntimeException("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                }
            } else {
                if (!z2 && i4 == 1) {
                    i2 = this.f15596j | 16;
                } else if (z2 && i4 == 0) {
                    i2 = this.f15596j & -17;
                }
                this.f15596j = i2;
            }
            if (RecyclerView.y4) {
                Log.d(RecyclerView.w4, "setIsRecyclable val:" + z2 + ":" + this);
            }
        }

        /* access modifiers changed from: package-private */
        public void c0(Recycler recycler, boolean z2) {
            this.f15600n = recycler;
            this.o = z2;
        }

        /* access modifiers changed from: package-private */
        public boolean d0() {
            return (this.f15596j & 16) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean e0() {
            return (this.f15596j & 128) != 0;
        }

        /* access modifiers changed from: package-private */
        public void f0() {
            this.f15596j &= -129;
        }

        /* access modifiers changed from: package-private */
        public void g0() {
            this.f15600n.P(this);
        }

        /* access modifiers changed from: package-private */
        public boolean h0() {
            return (this.f15596j & 32) != 0;
        }

        /* access modifiers changed from: package-private */
        public void r(Object obj) {
            if (obj == null) {
                s(1024);
            } else if ((1024 & this.f15596j) == 0) {
                x();
                this.f15597k.add(obj);
            }
        }

        /* access modifiers changed from: package-private */
        public void s(int i2) {
            this.f15596j = i2 | this.f15596j;
        }

        /* access modifiers changed from: package-private */
        public void t() {
            this.f15590d = -1;
            this.f15593g = -1;
        }

        public String toString() {
            String simpleName = getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName();
            StringBuilder sb = new StringBuilder(simpleName + "{" + Integer.toHexString(hashCode()) + " position=" + this.f15589c + " id=" + this.f15591e + ", oldPos=" + this.f15590d + ", pLpos:" + this.f15593g);
            if (R()) {
                sb.append(" scrap ");
                sb.append(this.o ? "[changeScrap]" : "[attachedScrap]");
            }
            if (O()) {
                sb.append(" invalid");
            }
            if (!N()) {
                sb.append(" unbound");
            }
            if (U()) {
                sb.append(" update");
            }
            if (Q()) {
                sb.append(" removed");
            }
            if (e0()) {
                sb.append(" ignored");
            }
            if (S()) {
                sb.append(" tmpDetached");
            }
            if (!P()) {
                sb.append(" not recyclable(" + this.f15599m + ")");
            }
            if (L()) {
                sb.append(" undefined adapter position");
            }
            if (this.f15587a.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        /* access modifiers changed from: package-private */
        public void u() {
            List<Object> list = this.f15597k;
            if (list != null) {
                list.clear();
            }
            this.f15596j &= -1025;
        }

        /* access modifiers changed from: package-private */
        public void v() {
            this.f15596j &= -33;
        }

        /* access modifiers changed from: package-private */
        public void w() {
            this.f15596j &= -257;
        }

        /* access modifiers changed from: package-private */
        public boolean y() {
            return (this.f15596j & 16) == 0 && ViewCompat.P0(this.f15587a);
        }

        /* access modifiers changed from: package-private */
        public void z(int i2, int i3, boolean z2) {
            s(8);
            V(i3, z2);
            this.f15589c = i2;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.lang.Class<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            r0 = 1
            r1 = 0
            r2 = 16843830(0x1010436, float:2.369658E-38)
            int[] r2 = new int[]{r2}
            A4 = r2
            r2 = 4605200834963974390(0x3fe8f5c28f5c28f6, double:0.78)
            double r2 = java.lang.Math.log(r2)
            r4 = 4606281698874543309(0x3feccccccccccccd, double:0.9)
            double r4 = java.lang.Math.log(r4)
            double r2 = r2 / r4
            float r2 = (float) r2
            D4 = r2
            int r2 = android.os.Build.VERSION.SDK_INT
            E4 = r1
            r3 = 23
            if (r2 < r3) goto L_0x002b
            r2 = 1
            goto L_0x002c
        L_0x002b:
            r2 = 0
        L_0x002c:
            F4 = r2
            G4 = r0
            H4 = r0
            I4 = r1
            J4 = r1
            r2 = 4
            java.lang.Class[] r2 = new java.lang.Class[r2]
            java.lang.Class<android.content.Context> r3 = android.content.Context.class
            r2[r1] = r3
            java.lang.Class<android.util.AttributeSet> r1 = android.util.AttributeSet.class
            r2[r0] = r1
            java.lang.Class r0 = java.lang.Integer.TYPE
            r1 = 2
            r2[r1] = r0
            r1 = 3
            r2[r1] = r0
            e5 = r2
            androidx.recyclerview.widget.RecyclerView$3 r0 = new androidx.recyclerview.widget.RecyclerView$3
            r0.<init>()
            k5 = r0
            androidx.recyclerview.widget.RecyclerView$StretchEdgeEffectFactory r0 = new androidx.recyclerview.widget.RecyclerView$StretchEdgeEffectFactory
            r0.<init>()
            l5 = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.<clinit>():void");
    }

    public RecyclerView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void B() {
        J1();
        setScrollState(0);
    }

    static void B0(View view, Rect rect) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect2 = layoutParams.f15535b;
        rect.set((view.getLeft() - rect2.left) - layoutParams.leftMargin, (view.getTop() - rect2.top) - layoutParams.topMargin, view.getRight() + rect2.right + layoutParams.rightMargin, view.getBottom() + rect2.bottom + layoutParams.bottomMargin);
    }

    static void C(@NonNull ViewHolder viewHolder) {
        Reference reference = viewHolder.f15588b;
        if (reference != null) {
            Object obj = reference.get();
            while (true) {
                View view = (View) obj;
                while (true) {
                    if (view == null) {
                        viewHolder.f15588b = null;
                        return;
                    } else if (view != viewHolder.f15587a) {
                        obj = view.getParent();
                        if (!(obj instanceof View)) {
                            view = null;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private int C0(View view) {
        int id;
        loop0:
        while (true) {
            id = view.getId();
            while (true) {
                if (view.isFocused() || !(view instanceof ViewGroup) || !view.hasFocus()) {
                    return id;
                }
                view = ((ViewGroup) view).getFocusedChild();
                if (view.getId() != -1) {
                }
            }
        }
        return id;
    }

    private String D0(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        } else if (str.contains(".")) {
            return str;
        } else {
            return RecyclerView.class.getPackage().getName() + ClassUtils.PACKAGE_SEPARATOR_CHAR + str;
        }
    }

    private float G0(int i2) {
        double log = Math.log((double) ((((float) Math.abs(i2)) * C4) / (this.s * B4)));
        float f2 = D4;
        return (float) (((double) (this.s * B4)) * Math.exp((((double) f2) / (((double) f2) - 1.0d)) * log));
    }

    private void H0(long j2, ViewHolder viewHolder, ViewHolder viewHolder2) {
        int g2 = this.b3.g();
        for (int i2 = 0; i2 < g2; i2++) {
            ViewHolder z0 = z0(this.b3.f(i2));
            if (z0 != viewHolder && t0(z0) == j2) {
                Adapter adapter = this.i3;
                if (adapter == null || !adapter.F()) {
                    throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + z0 + " \n View Holder 2:" + viewHolder + d0());
                }
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + z0 + " \n View Holder 2:" + viewHolder + d0());
            }
        }
        Log.e(w4, "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + viewHolder2 + " cannot be found but it is necessary for " + viewHolder + d0());
    }

    private void H1(@NonNull View view, @Nullable View view2) {
        View view3 = view2 != null ? view2 : view;
        this.f3.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (!layoutParams2.f15536c) {
                Rect rect = layoutParams2.f15535b;
                Rect rect2 = this.f3;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.f3);
            offsetRectIntoDescendantCoords(view, this.f3);
        }
        this.j3.Q1(this, view, this.f3, !this.s3, view2 == null);
    }

    private int I(int i2, EdgeEffect edgeEffect, EdgeEffect edgeEffect2, int i6) {
        if (i2 > 0 && edgeEffect != null && EdgeEffectCompat.d(edgeEffect) != 0.0f) {
            int round = Math.round((((float) (-i6)) / K4) * EdgeEffectCompat.j(edgeEffect, (((float) (-i2)) * K4) / ((float) i6), 0.5f));
            if (round != i2) {
                edgeEffect.finish();
            }
            return i2 - round;
        } else if (i2 >= 0 || edgeEffect2 == null || EdgeEffectCompat.d(edgeEffect2) == 0.0f) {
            return i2;
        } else {
            float f2 = (float) i6;
            int round2 = Math.round((f2 / K4) * EdgeEffectCompat.j(edgeEffect2, (((float) i2) * K4) / f2, 0.5f));
            if (round2 != i2) {
                edgeEffect2.finish();
            }
            return i2 - round2;
        }
    }

    private void I1() {
        State state = this.c4;
        state.f15586n = -1;
        state.f15585m = -1;
        state.o = -1;
    }

    private void J1() {
        VelocityTracker velocityTracker = this.N3;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        h(0);
        v1();
    }

    private boolean K0() {
        int g2 = this.b3.g();
        for (int i2 = 0; i2 < g2; i2++) {
            ViewHolder z0 = z0(this.b3.f(i2));
            if (z0 != null && !z0.e0() && z0.T()) {
                return true;
            }
        }
        return false;
    }

    private void K1() {
        ViewHolder viewHolder = null;
        View focusedChild = (!this.Y3 || !hasFocus() || this.i3 == null) ? null : getFocusedChild();
        if (focusedChild != null) {
            viewHolder = h0(focusedChild);
        }
        if (viewHolder == null) {
            I1();
            return;
        }
        this.c4.f15586n = this.i3.F() ? viewHolder.E() : -1;
        this.c4.f15585m = this.B3 ? -1 : viewHolder.Q() ? viewHolder.f15590d : viewHolder.A();
        this.c4.o = C0(viewHolder.f15587a);
    }

    private void L(Context context, String str, AttributeSet attributeSet, int i2, int i6) {
        Object[] objArr;
        Constructor<? extends U> constructor;
        if (str != null) {
            String trim = str.trim();
            if (!trim.isEmpty()) {
                String D0 = D0(context, trim);
                try {
                    Class<? extends U> asSubclass = Class.forName(D0, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(LayoutManager.class);
                    try {
                        constructor = asSubclass.getConstructor(e5);
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i6)};
                    } catch (NoSuchMethodException e2) {
                        objArr = null;
                        constructor = asSubclass.getConstructor((Class[]) null);
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((LayoutManager) constructor.newInstance(objArr));
                } catch (NoSuchMethodException e6) {
                    e6.initCause(e2);
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + D0, e6);
                } catch (ClassNotFoundException e7) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + D0, e7);
                } catch (InvocationTargetException e8) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + D0, e8);
                } catch (InstantiationException e9) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + D0, e9);
                } catch (IllegalAccessException e10) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + D0, e10);
                } catch (ClassCastException e11) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + D0, e11);
                }
            }
        }
    }

    @SuppressLint({"InlinedApi"})
    private void M0() {
        if (ViewCompat.Y(this) == 0) {
            ViewCompat.b2(this, 8);
        }
    }

    private boolean N(int i2, int i6) {
        j0(this.l4);
        int[] iArr = this.l4;
        return (iArr[0] == i2 && iArr[1] == i6) ? false : true;
    }

    private void N0() {
        this.b3 = new ChildHelper(new ChildHelper.Callback() {
            public View a(int i2) {
                return RecyclerView.this.getChildAt(i2);
            }

            public void b(View view) {
                ViewHolder z0 = RecyclerView.z0(view);
                if (z0 != null) {
                    z0.W(RecyclerView.this);
                }
            }

            public int c() {
                return RecyclerView.this.getChildCount();
            }

            public void d() {
                int c2 = c();
                for (int i2 = 0; i2 < c2; i2++) {
                    View a2 = a(i2);
                    RecyclerView.this.P(a2);
                    a2.clearAnimation();
                }
                RecyclerView.this.removeAllViews();
            }

            public int e(View view) {
                return RecyclerView.this.indexOfChild(view);
            }

            public ViewHolder f(View view) {
                return RecyclerView.z0(view);
            }

            public void g(int i2) {
                View a2 = a(i2);
                if (a2 != null) {
                    ViewHolder z0 = RecyclerView.z0(a2);
                    if (z0 != null) {
                        if (!z0.S() || z0.e0()) {
                            if (RecyclerView.y4) {
                                Log.d(RecyclerView.w4, "tmpDetach " + z0);
                            }
                            z0.s(256);
                        } else {
                            throw new IllegalArgumentException("called detach on an already detached child " + z0 + RecyclerView.this.d0());
                        }
                    }
                } else if (RecyclerView.x4) {
                    throw new IllegalArgumentException("No view at offset " + i2 + RecyclerView.this.d0());
                }
                RecyclerView.this.detachViewFromParent(i2);
            }

            public void h(View view) {
                ViewHolder z0 = RecyclerView.z0(view);
                if (z0 != null) {
                    z0.X(RecyclerView.this);
                }
            }

            public void i(View view, int i2) {
                RecyclerView.this.addView(view, i2);
                RecyclerView.this.O(view);
            }

            public void j(int i2) {
                View childAt = RecyclerView.this.getChildAt(i2);
                if (childAt != null) {
                    RecyclerView.this.P(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeViewAt(i2);
            }

            public void k(View view, int i2, ViewGroup.LayoutParams layoutParams) {
                ViewHolder z0 = RecyclerView.z0(view);
                if (z0 != null) {
                    if (z0.S() || z0.e0()) {
                        if (RecyclerView.y4) {
                            Log.d(RecyclerView.w4, "reAttach " + z0);
                        }
                        z0.w();
                    } else {
                        throw new IllegalArgumentException("Called attach on a child which is not detached: " + z0 + RecyclerView.this.d0());
                    }
                } else if (RecyclerView.x4) {
                    throw new IllegalArgumentException("No ViewHolder found for child: " + view + ", index: " + i2 + RecyclerView.this.d0());
                }
                RecyclerView.this.attachViewToParent(view, i2, layoutParams);
            }
        });
    }

    private void P1(@Nullable Adapter<?> adapter, boolean z, boolean z2) {
        Adapter adapter2 = this.i3;
        if (adapter2 != null) {
            adapter2.c0(this.X2);
            this.i3.U(this);
        }
        if (!z || z2) {
            y1();
        }
        this.a3.z();
        Adapter adapter3 = this.i3;
        this.i3 = adapter;
        if (adapter != null) {
            adapter.Z(this.X2);
            adapter.Q(this);
        }
        LayoutManager layoutManager = this.j3;
        if (layoutManager != null) {
            layoutManager.Z0(adapter3, this.i3);
        }
        this.Y2.z(adapter3, this.i3, z);
        this.c4.f15579g = true;
    }

    private void Q() {
        int i2 = this.x3;
        this.x3 = 0;
        if (i2 != 0 && R0()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            AccessibilityEventCompat.k(obtain, i2);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    private boolean R1(@NonNull EdgeEffect edgeEffect, int i2, int i6) {
        if (i2 > 0) {
            return true;
        }
        return G0(-i2) < EdgeEffectCompat.d(edgeEffect) * ((float) i6);
    }

    private void S() {
        boolean z = true;
        this.c4.a(1);
        e0(this.c4);
        this.c4.f15582j = false;
        Y1();
        this.c3.f();
        i1();
        q1();
        K1();
        State state = this.c4;
        if (!state.f15583k || !this.g4) {
            z = false;
        }
        state.f15581i = z;
        this.g4 = false;
        this.f4 = false;
        state.f15580h = state.f15584l;
        state.f15578f = this.i3.b();
        j0(this.l4);
        if (this.c4.f15583k) {
            int g2 = this.b3.g();
            for (int i2 = 0; i2 < g2; i2++) {
                ViewHolder z0 = z0(this.b3.f(i2));
                if (!z0.e0() && (!z0.O() || this.i3.F())) {
                    this.c3.e(z0, this.K3.w(this.c4, z0, ItemAnimator.e(z0), z0.J()));
                    if (this.c4.f15581i && z0.T() && !z0.Q() && !z0.e0() && !z0.O()) {
                        this.c3.c(t0(z0), z0);
                    }
                }
            }
        }
        if (this.c4.f15584l) {
            L1();
            State state2 = this.c4;
            boolean z2 = state2.f15579g;
            state2.f15579g = false;
            this.j3.s1(this.Y2, state2);
            this.c4.f15579g = z2;
            for (int i6 = 0; i6 < this.b3.g(); i6++) {
                ViewHolder z02 = z0(this.b3.f(i6));
                if (!z02.e0() && !this.c3.i(z02)) {
                    int e2 = ItemAnimator.e(z02);
                    boolean K = z02.K(8192);
                    if (!K) {
                        e2 |= 4096;
                    }
                    ItemAnimator.ItemHolderInfo w = this.K3.w(this.c4, z02, e2, z02.J());
                    if (K) {
                        t1(z02, w);
                    } else {
                        this.c3.a(z02, w);
                    }
                }
            }
        }
        D();
        j1();
        a2(false);
        this.c4.f15577e = 2;
    }

    private void T() {
        Y1();
        i1();
        this.c4.a(6);
        this.a3.k();
        this.c4.f15578f = this.i3.b();
        this.c4.f15576d = 0;
        if (this.Z2 != null && this.i3.y()) {
            Parcelable parcelable = this.Z2.Y;
            if (parcelable != null) {
                this.j3.x1(parcelable);
            }
            this.Z2 = null;
        }
        State state = this.c4;
        state.f15580h = false;
        this.j3.s1(this.Y2, state);
        State state2 = this.c4;
        state2.f15579g = false;
        state2.f15583k = state2.f15583k && this.K3 != null;
        state2.f15577e = 4;
        j1();
        a2(false);
    }

    private void U() {
        this.c4.a(4);
        Y1();
        i1();
        State state = this.c4;
        state.f15577e = 1;
        if (state.f15583k) {
            for (int g2 = this.b3.g() - 1; g2 >= 0; g2--) {
                ViewHolder z0 = z0(this.b3.f(g2));
                if (!z0.e0()) {
                    long t0 = t0(z0);
                    ItemAnimator.ItemHolderInfo v = this.K3.v(this.c4, z0);
                    ViewHolder g6 = this.c3.g(t0);
                    if (g6 != null && !g6.e0()) {
                        boolean h2 = this.c3.h(g6);
                        boolean h6 = this.c3.h(z0);
                        if (!h2 || g6 != z0) {
                            ItemAnimator.ItemHolderInfo n2 = this.c3.n(g6);
                            this.c3.d(z0, v);
                            ItemAnimator.ItemHolderInfo m2 = this.c3.m(z0);
                            if (n2 == null) {
                                H0(t0, z0, g6);
                            } else {
                                w(g6, z0, n2, m2, h2, h6);
                            }
                        }
                    }
                    this.c3.d(z0, v);
                }
            }
            this.c3.o(this.v4);
        }
        this.j3.I1(this.Y2);
        State state2 = this.c4;
        state2.f15575c = state2.f15578f;
        this.B3 = false;
        this.C3 = false;
        state2.f15583k = false;
        state2.f15584l = false;
        this.j3.f15521h = false;
        ArrayList<ViewHolder> arrayList = this.Y2.f15548b;
        if (arrayList != null) {
            arrayList.clear();
        }
        LayoutManager layoutManager = this.j3;
        if (layoutManager.f15527n) {
            layoutManager.f15526m = 0;
            layoutManager.f15527n = false;
            this.Y2.Q();
        }
        this.j3.t1(this.c4);
        j1();
        a2(false);
        this.c3.f();
        int[] iArr = this.l4;
        if (N(iArr[0], iArr[1])) {
            W(0, 0);
        }
        u1();
        I1();
    }

    private boolean V0(View view, View view2, int i2) {
        int i6;
        if (view2 == null || view2 == this || view2 == view || g0(view2) == null) {
            return false;
        }
        if (view == null || g0(view) == null) {
            return true;
        }
        this.f3.set(0, 0, view.getWidth(), view.getHeight());
        this.g3.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.f3);
        offsetDescendantRectToMyCoords(view2, this.g3);
        char c2 = 65535;
        int i7 = this.j3.m0() == 1 ? -1 : 1;
        Rect rect = this.f3;
        int i8 = rect.left;
        Rect rect2 = this.g3;
        int i9 = rect2.left;
        if ((i8 < i9 || rect.right <= i9) && rect.right < rect2.right) {
            i6 = 1;
        } else {
            int i10 = rect.right;
            int i11 = rect2.right;
            i6 = ((i10 > i11 || i8 >= i11) && i8 > i9) ? -1 : 0;
        }
        int i12 = rect.top;
        int i13 = rect2.top;
        if ((i12 < i13 || rect.bottom <= i13) && rect.bottom < rect2.bottom) {
            c2 = 1;
        } else {
            int i14 = rect.bottom;
            int i15 = rect2.bottom;
            if ((i14 <= i15 && i12 < i15) || i12 <= i13) {
                c2 = 0;
            }
        }
        if (i2 == 1) {
            return c2 < 0 || (c2 == 0 && i6 * i7 < 0);
        }
        if (i2 == 2) {
            return c2 > 0 || (c2 == 0 && i6 * i7 > 0);
        }
        if (i2 == 17) {
            return i6 < 0;
        }
        if (i2 == 33) {
            return c2 < 0;
        }
        if (i2 == 66) {
            return i6 > 0;
        }
        if (i2 == 130) {
            return c2 > 0;
        }
        throw new IllegalArgumentException("Invalid direction: " + i2 + d0());
    }

    private boolean Y(MotionEvent motionEvent) {
        OnItemTouchListener onItemTouchListener = this.o3;
        if (onItemTouchListener != null) {
            onItemTouchListener.a(this, motionEvent);
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.o3 = null;
            }
            return true;
        } else if (motionEvent.getAction() == 0) {
            return false;
        } else {
            return i0(motionEvent);
        }
    }

    private boolean Z1(MotionEvent motionEvent) {
        boolean z;
        EdgeEffect edgeEffect = this.G3;
        if (edgeEffect == null || EdgeEffectCompat.d(edgeEffect) == 0.0f || canScrollHorizontally(-1)) {
            z = false;
        } else {
            EdgeEffectCompat.j(this.G3, 0.0f, 1.0f - (motionEvent.getY() / ((float) getHeight())));
            z = true;
        }
        EdgeEffect edgeEffect2 = this.I3;
        if (!(edgeEffect2 == null || EdgeEffectCompat.d(edgeEffect2) == 0.0f || canScrollHorizontally(1))) {
            EdgeEffectCompat.j(this.I3, 0.0f, motionEvent.getY() / ((float) getHeight()));
            z = true;
        }
        EdgeEffect edgeEffect3 = this.H3;
        if (!(edgeEffect3 == null || EdgeEffectCompat.d(edgeEffect3) == 0.0f || canScrollVertically(-1))) {
            EdgeEffectCompat.j(this.H3, 0.0f, motionEvent.getX() / ((float) getWidth()));
            z = true;
        }
        EdgeEffect edgeEffect4 = this.J3;
        if (edgeEffect4 == null || EdgeEffectCompat.d(edgeEffect4) == 0.0f || canScrollVertically(1)) {
            return z;
        }
        EdgeEffectCompat.j(this.J3, 0.0f, 1.0f - (motionEvent.getX() / ((float) getWidth())));
        return true;
    }

    private void a1(int i2, int i6, @Nullable MotionEvent motionEvent, int i7) {
        LayoutManager layoutManager = this.j3;
        if (layoutManager == null) {
            Log.e(w4, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.v3) {
            int[] iArr = this.p4;
            int i8 = 0;
            iArr[0] = 0;
            iArr[1] = 0;
            boolean s2 = layoutManager.s();
            boolean t = this.j3.t();
            boolean z = t ? s2 | true : s2;
            float height = motionEvent == null ? ((float) getHeight()) / 2.0f : motionEvent.getY();
            float width = motionEvent == null ? ((float) getWidth()) / 2.0f : motionEvent.getX();
            int w1 = i2 - w1(i2, height);
            int x1 = i6 - x1(i6, width);
            f(z ? 1 : 0, i7);
            if (b(s2 ? w1 : 0, t ? x1 : 0, this.p4, this.n4, i7)) {
                int[] iArr2 = this.p4;
                w1 -= iArr2[0];
                x1 -= iArr2[1];
            }
            int i9 = s2 ? w1 : 0;
            if (t) {
                i8 = x1;
            }
            M1(i9, i8, motionEvent, i7);
            GapWorker gapWorker = this.a4;
            if (!(gapWorker == null || (w1 == 0 && x1 == 0))) {
                gapWorker.f(this, w1, x1);
            }
            h(i7);
        }
    }

    private void c2() {
        this.Z3.f();
        LayoutManager layoutManager = this.j3;
        if (layoutManager != null) {
            layoutManager.m2();
        }
    }

    private NestedScrollingChildHelper getScrollingChildHelper() {
        if (this.m4 == null) {
            this.m4 = new NestedScrollingChildHelper(this);
        }
        return this.m4;
    }

    private boolean i0(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.n3.size();
        int i2 = 0;
        while (i2 < size) {
            OnItemTouchListener onItemTouchListener = this.n3.get(i2);
            if (!onItemTouchListener.c(this, motionEvent) || action == 3) {
                i2++;
            } else {
                this.o3 = onItemTouchListener;
                return true;
            }
        }
        return false;
    }

    private void j0(int[] iArr) {
        int g2 = this.b3.g();
        if (g2 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i2 = Integer.MAX_VALUE;
        int i6 = Integer.MIN_VALUE;
        for (int i7 = 0; i7 < g2; i7++) {
            ViewHolder z0 = z0(this.b3.f(i7));
            if (!z0.e0()) {
                int G = z0.G();
                if (G < i2) {
                    i2 = G;
                }
                if (G > i6) {
                    i6 = G;
                }
            }
        }
        iArr[0] = i2;
        iArr[1] = i6;
    }

    @Nullable
    static RecyclerView k0(@NonNull View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            RecyclerView k0 = k0(viewGroup.getChildAt(i2));
            if (k0 != null) {
                return k0;
            }
        }
        return null;
    }

    @Nullable
    private View l0() {
        ViewHolder m0;
        State state = this.c4;
        int i2 = state.f15585m;
        if (i2 == -1) {
            i2 = 0;
        }
        int d2 = state.d();
        int i6 = i2;
        while (i6 < d2) {
            ViewHolder m02 = m0(i6);
            if (m02 == null) {
                break;
            } else if (m02.f15587a.hasFocusable()) {
                return m02.f15587a;
            } else {
                i6++;
            }
        }
        int min = Math.min(d2, i2);
        while (true) {
            min--;
            if (min < 0 || (m0 = m0(min)) == null) {
                return null;
            }
            if (m0.f15587a.hasFocusable()) {
                return m0.f15587a;
            }
        }
    }

    private void l1(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.M3) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.M3 = motionEvent.getPointerId(i2);
            int x = (int) (motionEvent.getX(i2) + 0.5f);
            this.Q3 = x;
            this.O3 = x;
            int y = (int) (motionEvent.getY(i2) + 0.5f);
            this.R3 = y;
            this.P3 = y;
        }
    }

    private void o(ViewHolder viewHolder) {
        View view = viewHolder.f15587a;
        boolean z = view.getParent() == this;
        this.Y2.P(y0(view));
        if (viewHolder.S()) {
            this.b3.c(view, -1, view.getLayoutParams(), true);
            return;
        }
        ChildHelper childHelper = this.b3;
        if (!z) {
            childHelper.b(view, true);
        } else {
            childHelper.k(view);
        }
    }

    private boolean p1() {
        return this.K3 != null && this.j3.n2();
    }

    private void q1() {
        boolean z;
        if (this.B3) {
            this.a3.z();
            if (this.C3) {
                this.j3.n1(this);
            }
        }
        if (p1()) {
            this.a3.x();
        } else {
            this.a3.k();
        }
        boolean z2 = true;
        boolean z5 = this.f4 || this.g4;
        this.c4.f15583k = this.s3 && this.K3 != null && ((z = this.B3) || z5 || this.j3.f15521h) && (!z || this.i3.F());
        State state = this.c4;
        if (!state.f15583k || !z5 || this.B3 || !p1()) {
            z2 = false;
        }
        state.f15584l = z2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void s1(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = 1
            r2 = 0
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 >= 0) goto L_0x0021
            r6.a0()
            android.widget.EdgeEffect r3 = r6.G3
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r0 - r9
        L_0x001c:
            androidx.core.widget.EdgeEffectCompat.j(r3, r4, r9)
            r9 = 1
            goto L_0x0039
        L_0x0021:
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 <= 0) goto L_0x0038
            r6.b0()
            android.widget.EdgeEffect r3 = r6.I3
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            goto L_0x001c
        L_0x0038:
            r9 = 0
        L_0x0039:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 >= 0) goto L_0x0053
            r6.c0()
            android.widget.EdgeEffect r9 = r6.H3
            float r0 = -r10
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r0 = r0 / r3
            int r3 = r6.getWidth()
            float r3 = (float) r3
            float r7 = r7 / r3
            androidx.core.widget.EdgeEffectCompat.j(r9, r0, r7)
            goto L_0x006f
        L_0x0053:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 <= 0) goto L_0x006e
            r6.Z()
            android.widget.EdgeEffect r9 = r6.J3
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r3 = r10 / r3
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r0 = r0 - r7
            androidx.core.widget.EdgeEffectCompat.j(r9, r3, r0)
            goto L_0x006f
        L_0x006e:
            r1 = r9
        L_0x006f:
            if (r1 != 0) goto L_0x0079
            int r7 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r7 != 0) goto L_0x0079
            int r7 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r7 == 0) goto L_0x007c
        L_0x0079:
            androidx.core.view.ViewCompat.t1(r6)
        L_0x007c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.s1(float, float, float, float):void");
    }

    public static void setDebugAssertionsEnabled(boolean z) {
        x4 = z;
    }

    public static void setVerboseLoggingEnabled(boolean z) {
        y4 = z;
    }

    private void u1() {
        View findViewById;
        if (this.Y3 && this.i3 != null && hasFocus() && getDescendantFocusability() != 393216) {
            if (getDescendantFocusability() != 131072 || !isFocused()) {
                if (!isFocused()) {
                    View focusedChild = getFocusedChild();
                    if (!J4 || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                        if (!this.b3.n(focusedChild)) {
                            return;
                        }
                    } else if (this.b3.g() == 0) {
                        requestFocus();
                        return;
                    }
                }
                View view = null;
                ViewHolder n0 = (this.c4.f15586n == -1 || !this.i3.F()) ? null : n0(this.c4.f15586n);
                if (n0 != null && !this.b3.n(n0.f15587a) && n0.f15587a.hasFocusable()) {
                    view = n0.f15587a;
                } else if (this.b3.g() > 0) {
                    view = l0();
                }
                if (view != null) {
                    int i2 = this.c4.o;
                    if (!(((long) i2) == -1 || (findViewById = view.findViewById(i2)) == null || !findViewById.isFocusable())) {
                        view = findViewById;
                    }
                    view.requestFocus();
                }
            }
        }
    }

    private void v1() {
        boolean z;
        EdgeEffect edgeEffect = this.G3;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z = this.G3.isFinished();
        } else {
            z = false;
        }
        EdgeEffect edgeEffect2 = this.H3;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z |= this.H3.isFinished();
        }
        EdgeEffect edgeEffect3 = this.I3;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z |= this.I3.isFinished();
        }
        EdgeEffect edgeEffect4 = this.J3;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z |= this.J3.isFinished();
        }
        if (z) {
            ViewCompat.t1(this);
        }
    }

    private void w(@NonNull ViewHolder viewHolder, @NonNull ViewHolder viewHolder2, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo2, boolean z, boolean z2) {
        viewHolder.b0(false);
        if (z) {
            o(viewHolder);
        }
        if (viewHolder != viewHolder2) {
            if (z2) {
                o(viewHolder2);
            }
            viewHolder.f15594h = viewHolder2;
            o(viewHolder);
            this.Y2.P(viewHolder);
            viewHolder2.b0(false);
            viewHolder2.f15595i = viewHolder;
        }
        if (this.K3.b(viewHolder, viewHolder2, itemHolderInfo, itemHolderInfo2)) {
            o1();
        }
    }

    private int w1(int i2, float f2) {
        float j2;
        EdgeEffect edgeEffect;
        float height = f2 / ((float) getHeight());
        float width = ((float) i2) / ((float) getWidth());
        EdgeEffect edgeEffect2 = this.G3;
        float f6 = 0.0f;
        if (edgeEffect2 == null || EdgeEffectCompat.d(edgeEffect2) == 0.0f) {
            EdgeEffect edgeEffect3 = this.I3;
            if (!(edgeEffect3 == null || EdgeEffectCompat.d(edgeEffect3) == 0.0f)) {
                if (canScrollHorizontally(1)) {
                    edgeEffect = this.I3;
                } else {
                    j2 = EdgeEffectCompat.j(this.I3, width, height);
                    if (EdgeEffectCompat.d(this.I3) == 0.0f) {
                        this.I3.onRelease();
                    }
                    f6 = j2;
                    invalidate();
                }
            }
            return Math.round(f6 * ((float) getWidth()));
        } else if (canScrollHorizontally(-1)) {
            edgeEffect = this.G3;
        } else {
            j2 = -EdgeEffectCompat.j(this.G3, -width, 1.0f - height);
            if (EdgeEffectCompat.d(this.G3) == 0.0f) {
                this.G3.onRelease();
            }
            f6 = j2;
            invalidate();
            return Math.round(f6 * ((float) getWidth()));
        }
        edgeEffect.onRelease();
        invalidate();
        return Math.round(f6 * ((float) getWidth()));
    }

    private int x1(int i2, float f2) {
        float j2;
        EdgeEffect edgeEffect;
        float width = f2 / ((float) getWidth());
        float height = ((float) i2) / ((float) getHeight());
        EdgeEffect edgeEffect2 = this.H3;
        float f6 = 0.0f;
        if (edgeEffect2 == null || EdgeEffectCompat.d(edgeEffect2) == 0.0f) {
            EdgeEffect edgeEffect3 = this.J3;
            if (!(edgeEffect3 == null || EdgeEffectCompat.d(edgeEffect3) == 0.0f)) {
                if (canScrollVertically(1)) {
                    edgeEffect = this.J3;
                } else {
                    j2 = EdgeEffectCompat.j(this.J3, height, 1.0f - width);
                    if (EdgeEffectCompat.d(this.J3) == 0.0f) {
                        this.J3.onRelease();
                    }
                    f6 = j2;
                    invalidate();
                }
            }
            return Math.round(f6 * ((float) getHeight()));
        } else if (canScrollVertically(-1)) {
            edgeEffect = this.H3;
        } else {
            j2 = -EdgeEffectCompat.j(this.H3, -height, width);
            if (EdgeEffectCompat.d(this.H3) == 0.0f) {
                this.H3.onRelease();
            }
            f6 = j2;
            invalidate();
            return Math.round(f6 * ((float) getHeight()));
        }
        edgeEffect.onRelease();
        invalidate();
        return Math.round(f6 * ((float) getHeight()));
    }

    static ViewHolder z0(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).f15534a;
    }

    /* access modifiers changed from: package-private */
    public boolean A(ViewHolder viewHolder) {
        ItemAnimator itemAnimator = this.K3;
        return itemAnimator == null || itemAnimator.g(viewHolder, viewHolder.J());
    }

    public void A0(@NonNull View view, @NonNull Rect rect) {
        B0(view, rect);
    }

    public void A1(@NonNull ItemDecoration itemDecoration) {
        LayoutManager layoutManager = this.j3;
        if (layoutManager != null) {
            layoutManager.n("Cannot remove item decoration during a scroll  or layout");
        }
        this.m3.remove(itemDecoration);
        if (this.m3.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        X0();
        requestLayout();
    }

    public void B1(int i2) {
        int itemDecorationCount = getItemDecorationCount();
        if (i2 < 0 || i2 >= itemDecorationCount) {
            throw new IndexOutOfBoundsException(i2 + " is an invalid index for size " + itemDecorationCount);
        }
        A1(F0(i2));
    }

    public void C1(@NonNull OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        List<OnChildAttachStateChangeListener> list = this.A3;
        if (list != null) {
            list.remove(onChildAttachStateChangeListener);
        }
    }

    /* access modifiers changed from: package-private */
    public void D() {
        int j2 = this.b3.j();
        for (int i2 = 0; i2 < j2; i2++) {
            ViewHolder z0 = z0(this.b3.i(i2));
            if (!z0.e0()) {
                z0.t();
            }
        }
        this.Y2.e();
    }

    public void D1(@NonNull OnItemTouchListener onItemTouchListener) {
        this.n3.remove(onItemTouchListener);
        if (this.o3 == onItemTouchListener) {
            this.o3 = null;
        }
    }

    public void E() {
        List<OnChildAttachStateChangeListener> list = this.A3;
        if (list != null) {
            list.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public Rect E0(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.f15536c) {
            return layoutParams.f15535b;
        }
        if (this.c4.j() && (layoutParams.f() || layoutParams.h())) {
            return layoutParams.f15535b;
        }
        Rect rect = layoutParams.f15535b;
        rect.set(0, 0, 0, 0);
        int size = this.m3.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f3.set(0, 0, 0, 0);
            this.m3.get(i2).g(this.f3, view, this, this.c4);
            int i6 = rect.left;
            Rect rect2 = this.f3;
            rect.left = i6 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        layoutParams.f15536c = false;
        return rect;
    }

    public void E1(@NonNull OnScrollListener onScrollListener) {
        List<OnScrollListener> list = this.e4;
        if (list != null) {
            list.remove(onScrollListener);
        }
    }

    public void F() {
        List<OnScrollListener> list = this.e4;
        if (list != null) {
            list.clear();
        }
    }

    @NonNull
    public ItemDecoration F0(int i2) {
        int itemDecorationCount = getItemDecorationCount();
        if (i2 >= 0 && i2 < itemDecorationCount) {
            return this.m3.get(i2);
        }
        throw new IndexOutOfBoundsException(i2 + " is an invalid index for size " + itemDecorationCount);
    }

    public void F1(@NonNull RecyclerListener recyclerListener) {
        this.l3.remove(recyclerListener);
    }

    /* access modifiers changed from: package-private */
    public void G(int i2, int i6) {
        boolean z;
        EdgeEffect edgeEffect = this.G3;
        if (edgeEffect == null || edgeEffect.isFinished() || i2 <= 0) {
            z = false;
        } else {
            this.G3.onRelease();
            z = this.G3.isFinished();
        }
        EdgeEffect edgeEffect2 = this.I3;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i2 < 0) {
            this.I3.onRelease();
            z |= this.I3.isFinished();
        }
        EdgeEffect edgeEffect3 = this.H3;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i6 > 0) {
            this.H3.onRelease();
            z |= this.H3.isFinished();
        }
        EdgeEffect edgeEffect4 = this.J3;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i6 < 0) {
            this.J3.onRelease();
            z |= this.J3.isFinished();
        }
        if (z) {
            ViewCompat.t1(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void G1() {
        ViewHolder viewHolder;
        int g2 = this.b3.g();
        for (int i2 = 0; i2 < g2; i2++) {
            View f2 = this.b3.f(i2);
            ViewHolder y0 = y0(f2);
            if (!(y0 == null || (viewHolder = y0.f15595i) == null)) {
                View view = viewHolder.f15587a;
                int left = f2.getLeft();
                int top = f2.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int H(int i2) {
        return I(i2, this.G3, this.I3, getWidth());
    }

    public boolean I0() {
        return this.q3;
    }

    /* access modifiers changed from: package-private */
    public int J(int i2) {
        return I(i2, this.H3, this.J3, getHeight());
    }

    public boolean J0() {
        return !this.s3 || this.B3 || this.a3.q();
    }

    /* access modifiers changed from: package-private */
    public void K() {
        if (!this.s3 || this.B3) {
            TraceCompat.b(Y4);
            R();
            TraceCompat.d();
        } else if (this.a3.q()) {
            if (this.a3.p(4) && !this.a3.p(11)) {
                TraceCompat.b(Z4);
                Y1();
                i1();
                this.a3.x();
                if (!this.u3) {
                    if (K0()) {
                        R();
                    } else {
                        this.a3.j();
                    }
                }
                a2(true);
                j1();
            } else if (this.a3.q()) {
                TraceCompat.b(Y4);
                R();
            } else {
                return;
            }
            TraceCompat.d();
        }
    }

    /* access modifiers changed from: package-private */
    public void L0() {
        this.a3 = new AdapterHelper(new AdapterHelper.Callback() {
            public void a(int i2, int i3) {
                RecyclerView.this.e1(i2, i3);
                RecyclerView.this.f4 = true;
            }

            public void b(AdapterHelper.UpdateOp updateOp) {
                i(updateOp);
            }

            public void c(int i2, int i3, Object obj) {
                RecyclerView.this.e2(i2, i3, obj);
                RecyclerView.this.g4 = true;
            }

            public void d(AdapterHelper.UpdateOp updateOp) {
                i(updateOp);
            }

            public ViewHolder e(int i2) {
                ViewHolder q0 = RecyclerView.this.q0(i2, true);
                if (q0 == null) {
                    return null;
                }
                if (!RecyclerView.this.b3.n(q0.f15587a)) {
                    return q0;
                }
                if (RecyclerView.y4) {
                    Log.d(RecyclerView.w4, "assuming view holder cannot be find because it is hidden");
                }
                return null;
            }

            public void f(int i2, int i3) {
                RecyclerView.this.f1(i2, i3, false);
                RecyclerView.this.f4 = true;
            }

            public void g(int i2, int i3) {
                RecyclerView.this.d1(i2, i3);
                RecyclerView.this.f4 = true;
            }

            public void h(int i2, int i3) {
                RecyclerView.this.f1(i2, i3, true);
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.f4 = true;
                recyclerView.c4.f15576d += i3;
            }

            /* access modifiers changed from: package-private */
            public void i(AdapterHelper.UpdateOp updateOp) {
                int i2 = updateOp.f15204a;
                if (i2 == 1) {
                    RecyclerView recyclerView = RecyclerView.this;
                    recyclerView.j3.m1(recyclerView, updateOp.f15205b, updateOp.f15207d);
                } else if (i2 == 2) {
                    RecyclerView recyclerView2 = RecyclerView.this;
                    recyclerView2.j3.p1(recyclerView2, updateOp.f15205b, updateOp.f15207d);
                } else if (i2 == 4) {
                    RecyclerView recyclerView3 = RecyclerView.this;
                    recyclerView3.j3.r1(recyclerView3, updateOp.f15205b, updateOp.f15207d, updateOp.f15206c);
                } else if (i2 == 8) {
                    RecyclerView recyclerView4 = RecyclerView.this;
                    recyclerView4.j3.o1(recyclerView4, updateOp.f15205b, updateOp.f15207d, 1);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void L1() {
        int j2 = this.b3.j();
        int i2 = 0;
        while (i2 < j2) {
            ViewHolder z0 = z0(this.b3.i(i2));
            if (!x4 || z0.f15589c != -1 || z0.Q()) {
                if (!z0.e0()) {
                    z0.Z();
                }
                i2++;
            } else {
                throw new IllegalStateException("view holder cannot have position -1 unless it is removed" + d0());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void M(int i2, int i6) {
        setMeasuredDimension(LayoutManager.v(i2, getPaddingLeft() + getPaddingRight(), ViewCompat.i0(this)), LayoutManager.v(i6, getPaddingTop() + getPaddingBottom(), ViewCompat.h0(this)));
    }

    /* access modifiers changed from: package-private */
    public boolean M1(int i2, int i6, MotionEvent motionEvent, int i7) {
        int i8;
        int i9;
        int i10;
        int i11;
        int i12 = i2;
        int i13 = i6;
        MotionEvent motionEvent2 = motionEvent;
        K();
        if (this.i3 != null) {
            int[] iArr = this.p4;
            iArr[0] = 0;
            iArr[1] = 0;
            N1(i12, i13, iArr);
            int[] iArr2 = this.p4;
            int i14 = iArr2[0];
            int i15 = iArr2[1];
            i11 = i15;
            i10 = i14;
            i9 = i12 - i14;
            i8 = i13 - i15;
        } else {
            i11 = 0;
            i10 = 0;
            i9 = 0;
            i8 = 0;
        }
        if (!this.m3.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.p4;
        iArr3[0] = 0;
        iArr3[1] = 0;
        c(i10, i11, i9, i8, this.n4, i7, iArr3);
        int[] iArr4 = this.p4;
        int i16 = iArr4[0];
        int i17 = i9 - i16;
        int i18 = iArr4[1];
        int i19 = i8 - i18;
        boolean z = (i16 == 0 && i18 == 0) ? false : true;
        int i20 = this.Q3;
        int[] iArr5 = this.n4;
        int i21 = iArr5[0];
        this.Q3 = i20 - i21;
        int i22 = this.R3;
        int i23 = iArr5[1];
        this.R3 = i22 - i23;
        int[] iArr6 = this.o4;
        iArr6[0] = iArr6[0] + i21;
        iArr6[1] = iArr6[1] + i23;
        if (getOverScrollMode() != 2) {
            if (motionEvent2 != null && !MotionEventCompat.l(motionEvent2, 8194)) {
                s1(motionEvent.getX(), (float) i17, motionEvent.getY(), (float) i19);
            }
            G(i2, i6);
        }
        if (!(i10 == 0 && i11 == 0)) {
            W(i10, i11);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (!z && i10 == 0 && i11 == 0) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public void N1(int i2, int i6, @Nullable int[] iArr) {
        Y1();
        i1();
        TraceCompat.b(W4);
        e0(this.c4);
        int U1 = i2 != 0 ? this.j3.U1(i2, this.Y2, this.c4) : 0;
        int W1 = i6 != 0 ? this.j3.W1(i6, this.Y2, this.c4) : 0;
        TraceCompat.d();
        G1();
        j1();
        a2(false);
        if (iArr != null) {
            iArr[0] = U1;
            iArr[1] = W1;
        }
    }

    /* access modifiers changed from: package-private */
    public void O(View view) {
        ViewHolder z0 = z0(view);
        g1(view);
        Adapter adapter = this.i3;
        if (!(adapter == null || z0 == null)) {
            adapter.W(z0);
        }
        List<OnChildAttachStateChangeListener> list = this.A3;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.A3.get(size).d(view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void O0(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + d0());
        }
        Resources resources = getContext().getResources();
        new FastScroller(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(R.dimen.f15167a), resources.getDimensionPixelSize(R.dimen.f15169c), resources.getDimensionPixelOffset(R.dimen.f15168b));
    }

    public void O1(int i2) {
        if (!this.v3) {
            b2();
            LayoutManager layoutManager = this.j3;
            if (layoutManager == null) {
                Log.e(w4, "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
                return;
            }
            layoutManager.V1(i2);
            awakenScrollBars();
        }
    }

    /* access modifiers changed from: package-private */
    public void P(View view) {
        ViewHolder z0 = z0(view);
        h1(view);
        Adapter adapter = this.i3;
        if (!(adapter == null || z0 == null)) {
            adapter.X(z0);
        }
        List<OnChildAttachStateChangeListener> list = this.A3;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.A3.get(size).b(view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void P0() {
        this.J3 = null;
        this.H3 = null;
        this.I3 = null;
        this.G3 = null;
    }

    public void Q0() {
        if (this.m3.size() != 0) {
            LayoutManager layoutManager = this.j3;
            if (layoutManager != null) {
                layoutManager.n("Cannot invalidate item decorations during a scroll or layout");
            }
            X0();
            requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean Q1(ViewHolder viewHolder, int i2) {
        if (T0()) {
            viewHolder.q = i2;
            this.q4.add(viewHolder);
            return false;
        }
        ViewCompat.Z1(viewHolder.f15587a, i2);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void R() {
        if (this.i3 == null) {
            Log.w(w4, "No adapter attached; skipping layout");
        } else if (this.j3 == null) {
            Log.e(w4, "No layout manager attached; skipping layout");
        } else {
            this.c4.f15582j = false;
            boolean z = this.s4 && !(this.t4 == getWidth() && this.u4 == getHeight());
            this.t4 = 0;
            this.u4 = 0;
            this.s4 = false;
            if (this.c4.f15577e == 1) {
                S();
            } else if (!this.a3.r() && !z && this.j3.D0() == getWidth() && this.j3.j0() == getHeight()) {
                this.j3.Y1(this);
                U();
            }
            this.j3.Y1(this);
            T();
            U();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean R0() {
        AccessibilityManager accessibilityManager = this.z3;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public boolean S0() {
        ItemAnimator itemAnimator = this.K3;
        return itemAnimator != null && itemAnimator.q();
    }

    /* access modifiers changed from: package-private */
    public boolean S1(AccessibilityEvent accessibilityEvent) {
        int i2 = 0;
        if (!T0()) {
            return false;
        }
        int d2 = accessibilityEvent != null ? AccessibilityEventCompat.d(accessibilityEvent) : 0;
        if (d2 != 0) {
            i2 = d2;
        }
        this.x3 |= i2;
        return true;
    }

    public boolean T0() {
        return this.D3 > 0;
    }

    public void T1(@Px int i2, @Px int i6) {
        U1(i2, i6, (Interpolator) null);
    }

    @Deprecated
    public boolean U0() {
        return isLayoutSuppressed();
    }

    public void U1(@Px int i2, @Px int i6, @Nullable Interpolator interpolator) {
        V1(i2, i6, interpolator, Integer.MIN_VALUE);
    }

    /* access modifiers changed from: package-private */
    public void V(int i2) {
        LayoutManager layoutManager = this.j3;
        if (layoutManager != null) {
            layoutManager.z1(i2);
        }
        m1(i2);
        OnScrollListener onScrollListener = this.d4;
        if (onScrollListener != null) {
            onScrollListener.a(this, i2);
        }
        List<OnScrollListener> list = this.e4;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.e4.get(size).a(this, i2);
            }
        }
    }

    public void V1(@Px int i2, @Px int i6, @Nullable Interpolator interpolator, int i7) {
        W1(i2, i6, interpolator, i7, false);
    }

    /* access modifiers changed from: package-private */
    public void W(int i2, int i6) {
        this.E3++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i2, scrollY - i6);
        n1(i2, i6);
        OnScrollListener onScrollListener = this.d4;
        if (onScrollListener != null) {
            onScrollListener.b(this, i2, i6);
        }
        List<OnScrollListener> list = this.e4;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.e4.get(size).b(this, i2, i6);
            }
        }
        this.E3--;
    }

    /* access modifiers changed from: package-private */
    public void W0(int i2) {
        if (this.j3 != null) {
            setScrollState(2);
            this.j3.V1(i2);
            awakenScrollBars();
        }
    }

    /* access modifiers changed from: package-private */
    public void W1(@Px int i2, @Px int i6, @Nullable Interpolator interpolator, int i7, boolean z) {
        LayoutManager layoutManager = this.j3;
        if (layoutManager == null) {
            Log.e(w4, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.v3) {
            int i8 = 0;
            if (!layoutManager.s()) {
                i2 = 0;
            }
            if (!this.j3.t()) {
                i6 = 0;
            }
            if (i2 != 0 || i6 != 0) {
                if (i7 == Integer.MIN_VALUE || i7 > 0) {
                    if (z) {
                        if (i2 != 0) {
                            i8 = 1;
                        }
                        if (i6 != 0) {
                            i8 |= 2;
                        }
                        f(i8, 1);
                    }
                    this.Z3.e(i2, i6, i7, interpolator);
                    return;
                }
                scrollBy(i2, i6);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void X() {
        int i2;
        for (int size = this.q4.size() - 1; size >= 0; size--) {
            ViewHolder viewHolder = this.q4.get(size);
            if (viewHolder.f15587a.getParent() == this && !viewHolder.e0() && (i2 = viewHolder.q) != -1) {
                ViewCompat.Z1(viewHolder.f15587a, i2);
                viewHolder.q = -1;
            }
        }
        this.q4.clear();
    }

    /* access modifiers changed from: package-private */
    public void X0() {
        int j2 = this.b3.j();
        for (int i2 = 0; i2 < j2; i2++) {
            ((LayoutParams) this.b3.i(i2).getLayoutParams()).f15536c = true;
        }
        this.Y2.t();
    }

    public void X1(int i2) {
        if (!this.v3) {
            LayoutManager layoutManager = this.j3;
            if (layoutManager == null) {
                Log.e(w4, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            } else {
                layoutManager.j2(this, this.c4, i2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void Y0() {
        int j2 = this.b3.j();
        for (int i2 = 0; i2 < j2; i2++) {
            ViewHolder z0 = z0(this.b3.i(i2));
            if (z0 != null && !z0.e0()) {
                z0.s(6);
            }
        }
        X0();
        this.Y2.u();
    }

    /* access modifiers changed from: package-private */
    public void Y1() {
        int i2 = this.t3 + 1;
        this.t3 = i2;
        if (i2 == 1 && !this.v3) {
            this.u3 = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void Z() {
        int measuredWidth;
        int measuredHeight;
        if (this.J3 == null) {
            EdgeEffect a2 = this.F3.a(this, 3);
            this.J3 = a2;
            if (this.d3) {
                measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
                measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            } else {
                measuredWidth = getMeasuredWidth();
                measuredHeight = getMeasuredHeight();
            }
            a2.setSize(measuredWidth, measuredHeight);
        }
    }

    public void Z0(int i2, int i6) {
        a1(i2, i6, (MotionEvent) null, 1);
    }

    public boolean a(int i2, int i6, int i7, int i8, int[] iArr, int i9) {
        return getScrollingChildHelper().g(i2, i6, i7, i8, iArr, i9);
    }

    /* access modifiers changed from: package-private */
    public void a0() {
        int measuredHeight;
        int measuredWidth;
        if (this.G3 == null) {
            EdgeEffect a2 = this.F3.a(this, 0);
            this.G3 = a2;
            if (this.d3) {
                measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
                measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            } else {
                measuredHeight = getMeasuredHeight();
                measuredWidth = getMeasuredWidth();
            }
            a2.setSize(measuredHeight, measuredWidth);
        }
    }

    /* access modifiers changed from: package-private */
    public void a2(boolean z) {
        if (this.t3 < 1) {
            if (!x4) {
                this.t3 = 1;
            } else {
                throw new IllegalStateException("stopInterceptRequestLayout was called more times than startInterceptRequestLayout." + d0());
            }
        }
        if (!z && !this.v3) {
            this.u3 = false;
        }
        if (this.t3 == 1) {
            if (z && this.u3 && !this.v3 && this.j3 != null && this.i3 != null) {
                R();
            }
            if (!this.v3) {
                this.u3 = false;
            }
        }
        this.t3--;
    }

    public void addFocusables(ArrayList<View> arrayList, int i2, int i6) {
        LayoutManager layoutManager = this.j3;
        if (layoutManager == null || !layoutManager.a1(this, arrayList, i2, i6)) {
            super.addFocusables(arrayList, i2, i6);
        }
    }

    public boolean b(int i2, int i6, int[] iArr, int[] iArr2, int i7) {
        return getScrollingChildHelper().d(i2, i6, iArr, iArr2, i7);
    }

    /* access modifiers changed from: package-private */
    public void b0() {
        int measuredHeight;
        int measuredWidth;
        if (this.I3 == null) {
            EdgeEffect a2 = this.F3.a(this, 2);
            this.I3 = a2;
            if (this.d3) {
                measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
                measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            } else {
                measuredHeight = getMeasuredHeight();
                measuredWidth = getMeasuredWidth();
            }
            a2.setSize(measuredHeight, measuredWidth);
        }
    }

    public void b1(@Px int i2) {
        int g2 = this.b3.g();
        for (int i6 = 0; i6 < g2; i6++) {
            this.b3.f(i6).offsetLeftAndRight(i2);
        }
    }

    public void b2() {
        setScrollState(0);
        c2();
    }

    public final void c(int i2, int i6, int i7, int i8, int[] iArr, int i9, @NonNull int[] iArr2) {
        getScrollingChildHelper().e(i2, i6, i7, i8, iArr, i9, iArr2);
    }

    /* access modifiers changed from: package-private */
    public void c0() {
        int measuredWidth;
        int measuredHeight;
        if (this.H3 == null) {
            EdgeEffect a2 = this.F3.a(this, 1);
            this.H3 = a2;
            if (this.d3) {
                measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
                measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            } else {
                measuredWidth = getMeasuredWidth();
                measuredHeight = getMeasuredHeight();
            }
            a2.setSize(measuredWidth, measuredHeight);
        }
    }

    public void c1(@Px int i2) {
        int g2 = this.b3.g();
        for (int i6 = 0; i6 < g2; i6++) {
            this.b3.f(i6).offsetTopAndBottom(i2);
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && this.j3.u((LayoutParams) layoutParams);
    }

    public int computeHorizontalScrollExtent() {
        LayoutManager layoutManager = this.j3;
        if (layoutManager != null && layoutManager.s()) {
            return this.j3.y(this.c4);
        }
        return 0;
    }

    public int computeHorizontalScrollOffset() {
        LayoutManager layoutManager = this.j3;
        if (layoutManager != null && layoutManager.s()) {
            return this.j3.z(this.c4);
        }
        return 0;
    }

    public int computeHorizontalScrollRange() {
        LayoutManager layoutManager = this.j3;
        if (layoutManager != null && layoutManager.s()) {
            return this.j3.A(this.c4);
        }
        return 0;
    }

    public int computeVerticalScrollExtent() {
        LayoutManager layoutManager = this.j3;
        if (layoutManager != null && layoutManager.t()) {
            return this.j3.B(this.c4);
        }
        return 0;
    }

    public int computeVerticalScrollOffset() {
        LayoutManager layoutManager = this.j3;
        if (layoutManager != null && layoutManager.t()) {
            return this.j3.C(this.c4);
        }
        return 0;
    }

    public int computeVerticalScrollRange() {
        LayoutManager layoutManager = this.j3;
        if (layoutManager != null && layoutManager.t()) {
            return this.j3.D(this.c4);
        }
        return 0;
    }

    public boolean d(int i2) {
        return getScrollingChildHelper().l(i2);
    }

    /* access modifiers changed from: package-private */
    public String d0() {
        return StringUtils.SPACE + super.toString() + ", adapter:" + this.i3 + ", layout:" + this.j3 + ", context:" + getContext();
    }

    /* access modifiers changed from: package-private */
    public void d1(int i2, int i6) {
        int j2 = this.b3.j();
        for (int i7 = 0; i7 < j2; i7++) {
            ViewHolder z0 = z0(this.b3.i(i7));
            if (z0 != null && !z0.e0() && z0.f15589c >= i2) {
                if (y4) {
                    Log.d(w4, "offsetPositionRecordsForInsert attached child " + i7 + " holder " + z0 + " now at position " + (z0.f15589c + i6));
                }
                z0.V(i6, false);
                this.c4.f15579g = true;
            }
        }
        this.Y2.w(i2, i6);
        requestLayout();
    }

    public void d2(@Nullable Adapter adapter, boolean z) {
        setLayoutFrozen(false);
        P1(adapter, true, z);
        r1(true);
        requestLayout();
    }

    public boolean dispatchNestedFling(float f2, float f6, boolean z) {
        return getScrollingChildHelper().a(f2, f6, z);
    }

    public boolean dispatchNestedPreFling(float f2, float f6) {
        return getScrollingChildHelper().b(f2, f6);
    }

    public boolean dispatchNestedPreScroll(int i2, int i6, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i2, i6, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i2, int i6, int i7, int i8, int[] iArr) {
        return getScrollingChildHelper().f(i2, i6, i7, i8, iArr);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    /* access modifiers changed from: protected */
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    public void draw(Canvas canvas) {
        boolean z;
        float f2;
        int i2;
        super.draw(canvas);
        int size = this.m3.size();
        boolean z2 = false;
        for (int i6 = 0; i6 < size; i6++) {
            this.m3.get(i6).k(canvas, this, this.c4);
        }
        EdgeEffect edgeEffect = this.G3;
        boolean z5 = true;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.d3 ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) ((-getHeight()) + paddingBottom), 0.0f);
            EdgeEffect edgeEffect2 = this.G3;
            z = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.H3;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.d3) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.H3;
            z |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.I3;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.d3 ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate((float) paddingTop, (float) (-width));
            EdgeEffect edgeEffect6 = this.I3;
            z |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.J3;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.d3) {
                f2 = (float) ((-getWidth()) + getPaddingRight());
                i2 = (-getHeight()) + getPaddingBottom();
            } else {
                f2 = (float) (-getWidth());
                i2 = -getHeight();
            }
            canvas.translate(f2, (float) i2);
            EdgeEffect edgeEffect8 = this.J3;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z2 = true;
            }
            z |= z2;
            canvas.restoreToCount(save4);
        }
        if (z || this.K3 == null || this.m3.size() <= 0 || !this.K3.q()) {
            z5 = z;
        }
        if (z5) {
            ViewCompat.t1(this);
        }
    }

    public boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    /* access modifiers changed from: package-private */
    public final void e0(State state) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.Z3.Y;
            state.p = overScroller.getFinalX() - overScroller.getCurrX();
            state.q = overScroller.getFinalY() - overScroller.getCurrY();
            return;
        }
        state.p = 0;
        state.q = 0;
    }

    /* access modifiers changed from: package-private */
    public void e1(int i2, int i6) {
        int i7;
        int i8;
        int i9;
        int i10;
        int j2 = this.b3.j();
        if (i2 < i6) {
            i9 = -1;
            i8 = i2;
            i7 = i6;
        } else {
            i7 = i2;
            i8 = i6;
            i9 = 1;
        }
        for (int i11 = 0; i11 < j2; i11++) {
            ViewHolder z0 = z0(this.b3.i(i11));
            if (z0 != null && (i10 = z0.f15589c) >= i8 && i10 <= i7) {
                if (y4) {
                    Log.d(w4, "offsetPositionRecordsForMove attached child " + i11 + " holder " + z0);
                }
                if (z0.f15589c == i2) {
                    z0.V(i6 - i2, false);
                } else {
                    z0.V(i9, false);
                }
                this.c4.f15579g = true;
            }
        }
        this.Y2.x(i2, i6);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void e2(int i2, int i6, Object obj) {
        int i7;
        int j2 = this.b3.j();
        int i8 = i2 + i6;
        for (int i9 = 0; i9 < j2; i9++) {
            View i10 = this.b3.i(i9);
            ViewHolder z0 = z0(i10);
            if (z0 != null && !z0.e0() && (i7 = z0.f15589c) >= i2 && i7 < i8) {
                z0.s(2);
                z0.r(obj);
                ((LayoutParams) i10.getLayoutParams()).f15536c = true;
            }
        }
        this.Y2.S(i2, i6);
    }

    public boolean f(int i2, int i6) {
        return getScrollingChildHelper().s(i2, i6);
    }

    @Nullable
    public View f0(float f2, float f6) {
        for (int g2 = this.b3.g() - 1; g2 >= 0; g2--) {
            View f7 = this.b3.f(g2);
            float translationX = f7.getTranslationX();
            float translationY = f7.getTranslationY();
            if (f2 >= ((float) f7.getLeft()) + translationX && f2 <= ((float) f7.getRight()) + translationX && f6 >= ((float) f7.getTop()) + translationY && f6 <= ((float) f7.getBottom()) + translationY) {
                return f7;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void f1(int i2, int i6, boolean z) {
        int i7 = i2 + i6;
        int j2 = this.b3.j();
        for (int i8 = 0; i8 < j2; i8++) {
            ViewHolder z0 = z0(this.b3.i(i8));
            if (z0 != null && !z0.e0()) {
                int i9 = z0.f15589c;
                if (i9 >= i7) {
                    if (y4) {
                        Log.d(w4, "offsetPositionRecordsForRemove attached child " + i8 + " holder " + z0 + " now at position " + (z0.f15589c - i6));
                    }
                    z0.V(-i6, z);
                } else if (i9 >= i2) {
                    if (y4) {
                        Log.d(w4, "offsetPositionRecordsForRemove attached child " + i8 + " holder " + z0 + " now REMOVED");
                    }
                    z0.z(i2 - 1, -i6, z);
                }
                this.c4.f15579g = true;
            }
        }
        this.Y2.y(i2, i6, z);
        requestLayout();
    }

    public View focusSearch(View view, int i2) {
        View view2;
        boolean z;
        View l1 = this.j3.l1(view, i2);
        if (l1 != null) {
            return l1;
        }
        boolean z2 = true;
        boolean z5 = this.i3 != null && this.j3 != null && !T0() && !this.v3;
        FocusFinder instance = FocusFinder.getInstance();
        if (!z5 || !(i2 == 2 || i2 == 1)) {
            View findNextFocus = instance.findNextFocus(this, view, i2);
            if (findNextFocus != null || !z5) {
                view2 = findNextFocus;
            } else {
                K();
                if (g0(view) == null) {
                    return null;
                }
                Y1();
                view2 = this.j3.e1(view, i2, this.Y2, this.c4);
                a2(false);
            }
        } else {
            if (this.j3.t()) {
                int i6 = i2 == 2 ? TsExtractor.L : 33;
                z = instance.findNextFocus(this, view, i6) == null;
                if (I4) {
                    i2 = i6;
                }
            } else {
                z = false;
            }
            if (!z && this.j3.s()) {
                int i7 = (this.j3.m0() == 1) ^ (i2 == 2) ? 66 : 17;
                if (instance.findNextFocus(this, view, i7) != null) {
                    z2 = false;
                }
                if (I4) {
                    i2 = i7;
                }
                z = z2;
            }
            if (z) {
                K();
                if (g0(view) == null) {
                    return null;
                }
                Y1();
                this.j3.e1(view, i2, this.Y2, this.c4);
                a2(false);
            }
            view2 = instance.findNextFocus(this, view, i2);
        }
        if (view2 == null || view2.hasFocusable()) {
            return V0(view, view2, i2) ? view2 : super.focusSearch(view, i2);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i2);
        }
        H1(view2, (View) null);
        return view;
    }

    /* access modifiers changed from: package-private */
    public void g(int i2, int i6) {
        if (i2 < 0) {
            a0();
            if (this.G3.isFinished()) {
                this.G3.onAbsorb(-i2);
            }
        } else if (i2 > 0) {
            b0();
            if (this.I3.isFinished()) {
                this.I3.onAbsorb(i2);
            }
        }
        if (i6 < 0) {
            c0();
            if (this.H3.isFinished()) {
                this.H3.onAbsorb(-i6);
            }
        } else if (i6 > 0) {
            Z();
            if (this.J3.isFinished()) {
                this.J3.onAbsorb(i6);
            }
        }
        if (i2 != 0 || i6 != 0) {
            ViewCompat.t1(this);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0013 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View g0(@androidx.annotation.NonNull android.view.View r3) {
        /*
            r2 = this;
        L_0x0000:
            android.view.ViewParent r0 = r3.getParent()
            if (r0 == 0) goto L_0x0010
            if (r0 == r2) goto L_0x0010
            boolean r1 = r0 instanceof android.view.View
            if (r1 == 0) goto L_0x0010
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            goto L_0x0000
        L_0x0010:
            if (r0 != r2) goto L_0x0013
            goto L_0x0014
        L_0x0013:
            r3 = 0
        L_0x0014:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.g0(android.view.View):android.view.View");
    }

    public void g1(@NonNull View view) {
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        LayoutManager layoutManager = this.j3;
        if (layoutManager != null) {
            return layoutManager.P();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + d0());
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        LayoutManager layoutManager = this.j3;
        if (layoutManager != null) {
            return layoutManager.Q(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + d0());
    }

    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    @Nullable
    public Adapter getAdapter() {
        return this.i3;
    }

    public int getBaseline() {
        LayoutManager layoutManager = this.j3;
        return layoutManager != null ? layoutManager.S() : super.getBaseline();
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i2, int i6) {
        ChildDrawingOrderCallback childDrawingOrderCallback = this.k4;
        return childDrawingOrderCallback == null ? super.getChildDrawingOrder(i2, i6) : childDrawingOrderCallback.a(i2, i6);
    }

    public boolean getClipToPadding() {
        return this.d3;
    }

    @Nullable
    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
        return this.j4;
    }

    @NonNull
    public EdgeEffectFactory getEdgeEffectFactory() {
        return this.F3;
    }

    @Nullable
    public ItemAnimator getItemAnimator() {
        return this.K3;
    }

    public int getItemDecorationCount() {
        return this.m3.size();
    }

    @Nullable
    public LayoutManager getLayoutManager() {
        return this.j3;
    }

    public int getMaxFlingVelocity() {
        return this.V3;
    }

    public int getMinFlingVelocity() {
        return this.U3;
    }

    /* access modifiers changed from: package-private */
    public long getNanoTime() {
        if (H4) {
            return System.nanoTime();
        }
        return 0;
    }

    @Nullable
    public OnFlingListener getOnFlingListener() {
        return this.T3;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.Y3;
    }

    @NonNull
    public RecycledViewPool getRecycledViewPool() {
        return this.Y2.j();
    }

    public int getScrollState() {
        return this.L3;
    }

    public void h(int i2) {
        getScrollingChildHelper().u(i2);
    }

    @Nullable
    public ViewHolder h0(@NonNull View view) {
        View g0 = g0(view);
        if (g0 == null) {
            return null;
        }
        return y0(g0);
    }

    public void h1(@NonNull View view) {
    }

    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().k();
    }

    /* access modifiers changed from: package-private */
    public void i1() {
        this.D3++;
    }

    public boolean isAttachedToWindow() {
        return this.p3;
    }

    public final boolean isLayoutSuppressed() {
        return this.v3;
    }

    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().m();
    }

    /* access modifiers changed from: package-private */
    public void j1() {
        k1(true);
    }

    /* access modifiers changed from: package-private */
    public void k1(boolean z) {
        int i2 = this.D3 - 1;
        this.D3 = i2;
        if (i2 >= 1) {
            return;
        }
        if (!x4 || i2 >= 0) {
            this.D3 = 0;
            if (z) {
                Q();
                X();
                return;
            }
            return;
        }
        throw new IllegalStateException("layout or scroll counter cannot go below zero.Some calls are not matching" + d0());
    }

    @Nullable
    public ViewHolder m0(int i2) {
        ViewHolder viewHolder = null;
        if (this.B3) {
            return null;
        }
        int j2 = this.b3.j();
        for (int i6 = 0; i6 < j2; i6++) {
            ViewHolder z0 = z0(this.b3.i(i6));
            if (z0 != null && !z0.Q() && s0(z0) == i2) {
                if (!this.b3.n(z0.f15587a)) {
                    return z0;
                }
                viewHolder = z0;
            }
        }
        return viewHolder;
    }

    public void m1(int i2) {
    }

    public ViewHolder n0(long j2) {
        Adapter adapter = this.i3;
        ViewHolder viewHolder = null;
        if (adapter != null && adapter.F()) {
            int j6 = this.b3.j();
            for (int i2 = 0; i2 < j6; i2++) {
                ViewHolder z0 = z0(this.b3.i(i2));
                if (z0 != null && !z0.Q() && z0.E() == j2) {
                    if (!this.b3.n(z0.f15587a)) {
                        return z0;
                    }
                    viewHolder = z0;
                }
            }
        }
        return viewHolder;
    }

    public void n1(@Px int i2, @Px int i6) {
    }

    @Nullable
    public ViewHolder o0(int i2) {
        return q0(i2, false);
    }

    /* access modifiers changed from: package-private */
    public void o1() {
        if (!this.i4 && this.p3) {
            ViewCompat.v1(this, this.r4);
            this.i4 = true;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0050, code lost:
        if (r1 >= 30.0f) goto L_0x0055;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onAttachedToWindow() {
        /*
            r5 = this;
            super.onAttachedToWindow()
            r0 = 0
            r5.D3 = r0
            r1 = 1
            r5.p3 = r1
            boolean r2 = r5.s3
            if (r2 == 0) goto L_0x0014
            boolean r2 = r5.isLayoutRequested()
            if (r2 != 0) goto L_0x0014
            goto L_0x0015
        L_0x0014:
            r1 = 0
        L_0x0015:
            r5.s3 = r1
            androidx.recyclerview.widget.RecyclerView$Recycler r1 = r5.Y2
            r1.A()
            androidx.recyclerview.widget.RecyclerView$LayoutManager r1 = r5.j3
            if (r1 == 0) goto L_0x0023
            r1.K(r5)
        L_0x0023:
            r5.i4 = r0
            boolean r0 = H4
            if (r0 == 0) goto L_0x0066
            java.lang.ThreadLocal<androidx.recyclerview.widget.GapWorker> r0 = androidx.recyclerview.widget.GapWorker.X2
            java.lang.Object r1 = r0.get()
            androidx.recyclerview.widget.GapWorker r1 = (androidx.recyclerview.widget.GapWorker) r1
            r5.a4 = r1
            if (r1 != 0) goto L_0x0061
            androidx.recyclerview.widget.GapWorker r1 = new androidx.recyclerview.widget.GapWorker
            r1.<init>()
            r5.a4 = r1
            android.view.Display r1 = androidx.core.view.ViewCompat.S(r5)
            boolean r2 = r5.isInEditMode()
            if (r2 != 0) goto L_0x0053
            if (r1 == 0) goto L_0x0053
            float r1 = r1.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x0053
            goto L_0x0055
        L_0x0053:
            r1 = 1114636288(0x42700000, float:60.0)
        L_0x0055:
            androidx.recyclerview.widget.GapWorker r2 = r5.a4
            r3 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r3 = r3 / r1
            long r3 = (long) r3
            r2.Y = r3
            r0.set(r2)
        L_0x0061:
            androidx.recyclerview.widget.GapWorker r0 = r5.a4
            r0.a(r5)
        L_0x0066:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        GapWorker gapWorker;
        super.onDetachedFromWindow();
        ItemAnimator itemAnimator = this.K3;
        if (itemAnimator != null) {
            itemAnimator.l();
        }
        b2();
        this.p3 = false;
        LayoutManager layoutManager = this.j3;
        if (layoutManager != null) {
            layoutManager.L(this, this.Y2);
        }
        this.q4.clear();
        removeCallbacks(this.r4);
        this.c3.j();
        this.Y2.B();
        PoolingContainer.c(this);
        if (H4 && (gapWorker = this.a4) != null) {
            gapWorker.j(this);
            this.a4 = null;
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.m3.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.m3.get(i2).i(canvas, this, this.c4);
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f2;
        float f6;
        if (this.j3 != null && !this.v3 && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                f6 = this.j3.t() ? -motionEvent.getAxisValue(9) : 0.0f;
                if (this.j3.s()) {
                    f2 = motionEvent.getAxisValue(10);
                    if (!(f6 == 0.0f && f2 == 0.0f)) {
                        a1((int) (f2 * this.W3), (int) (f6 * this.X3), motionEvent, 1);
                    }
                }
            } else {
                if ((motionEvent.getSource() & 4194304) != 0) {
                    float axisValue = motionEvent.getAxisValue(26);
                    if (this.j3.t()) {
                        f6 = -axisValue;
                    } else if (this.j3.s()) {
                        f2 = axisValue;
                        f6 = 0.0f;
                        a1((int) (f2 * this.W3), (int) (f6 * this.X3), motionEvent, 1);
                    }
                }
                f6 = 0.0f;
            }
            f2 = 0.0f;
            a1((int) (f2 * this.W3), (int) (f6 * this.X3), motionEvent, 1);
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.v3) {
            return false;
        }
        this.o3 = null;
        if (i0(motionEvent)) {
            B();
            return true;
        }
        LayoutManager layoutManager = this.j3;
        if (layoutManager == null) {
            return false;
        }
        boolean s2 = layoutManager.s();
        boolean t = this.j3.t();
        if (this.N3 == null) {
            this.N3 = VelocityTracker.obtain();
        }
        this.N3.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.w3) {
                this.w3 = false;
            }
            this.M3 = motionEvent.getPointerId(0);
            int x = (int) (motionEvent.getX() + 0.5f);
            this.Q3 = x;
            this.O3 = x;
            int y = (int) (motionEvent.getY() + 0.5f);
            this.R3 = y;
            this.P3 = y;
            if (Z1(motionEvent) || this.L3 == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                h(1);
            }
            int[] iArr = this.o4;
            iArr[1] = 0;
            iArr[0] = 0;
            if (t) {
                s2 |= true;
            }
            f(s2 ? 1 : 0, 0);
        } else if (actionMasked == 1) {
            this.N3.clear();
            h(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.M3);
            if (findPointerIndex < 0) {
                Log.e(w4, "Error processing scroll; pointer index for id " + this.M3 + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x2 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y2 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.L3 != 1) {
                int i2 = x2 - this.O3;
                int i6 = y2 - this.P3;
                if (!s2 || Math.abs(i2) <= this.S3) {
                    z = false;
                } else {
                    this.Q3 = x2;
                    z = true;
                }
                if (t && Math.abs(i6) > this.S3) {
                    this.R3 = y2;
                    z = true;
                }
                if (z) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            B();
        } else if (actionMasked == 5) {
            this.M3 = motionEvent.getPointerId(actionIndex);
            int x5 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.Q3 = x5;
            this.O3 = x5;
            int y5 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.R3 = y5;
            this.P3 = y5;
        } else if (actionMasked == 6) {
            l1(motionEvent);
        }
        return this.L3 == 1;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i6, int i7, int i8) {
        TraceCompat.b(X4);
        R();
        TraceCompat.d();
        this.s3 = true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i6) {
        LayoutManager layoutManager = this.j3;
        if (layoutManager == null) {
            M(i2, i6);
            return;
        }
        boolean z = false;
        if (layoutManager.J0()) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i6);
            this.j3.u1(this.Y2, this.c4, i2, i6);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            this.s4 = z;
            if (!z && this.i3 != null) {
                if (this.c4.f15577e == 1) {
                    S();
                }
                this.j3.a2(i2, i6);
                this.c4.f15582j = true;
                T();
                this.j3.d2(i2, i6);
                if (this.j3.h2()) {
                    this.j3.a2(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.c4.f15582j = true;
                    T();
                    this.j3.d2(i2, i6);
                }
                this.t4 = getMeasuredWidth();
                this.u4 = getMeasuredHeight();
            }
        } else if (this.q3) {
            this.j3.u1(this.Y2, this.c4, i2, i6);
        } else {
            if (this.y3) {
                Y1();
                i1();
                q1();
                j1();
                State state = this.c4;
                if (state.f15584l) {
                    state.f15580h = true;
                } else {
                    this.a3.k();
                    this.c4.f15580h = false;
                }
                this.y3 = false;
                a2(false);
            } else if (this.c4.f15584l) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            Adapter adapter = this.i3;
            if (adapter != null) {
                this.c4.f15578f = adapter.b();
            } else {
                this.c4.f15578f = 0;
            }
            Y1();
            this.j3.u1(this.Y2, this.c4, i2, i6);
            a2(false);
            this.c4.f15580h = false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (T0()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i2, rect);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.Z2 = savedState;
        super.onRestoreInstanceState(savedState.a());
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.Z2;
        if (savedState2 != null) {
            savedState.b(savedState2);
        } else {
            LayoutManager layoutManager = this.j3;
            savedState.Y = layoutManager != null ? layoutManager.y1() : null;
        }
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i6, int i7, int i8) {
        super.onSizeChanged(i2, i6, i7, i8);
        if (i2 != i7 || i6 != i8) {
            P0();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00f4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r6 = r17
            r7 = r18
            boolean r0 = r6.v3
            r8 = 0
            if (r0 != 0) goto L_0x01eb
            boolean r0 = r6.w3
            if (r0 == 0) goto L_0x000f
            goto L_0x01eb
        L_0x000f:
            boolean r0 = r17.Y(r18)
            r9 = 1
            if (r0 == 0) goto L_0x001a
            r17.B()
            return r9
        L_0x001a:
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r6.j3
            if (r0 != 0) goto L_0x001f
            return r8
        L_0x001f:
            boolean r10 = r0.s()
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r6.j3
            boolean r11 = r0.t()
            android.view.VelocityTracker r0 = r6.N3
            if (r0 != 0) goto L_0x0033
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r6.N3 = r0
        L_0x0033:
            int r0 = r18.getActionMasked()
            int r1 = r18.getActionIndex()
            if (r0 != 0) goto L_0x0043
            int[] r2 = r6.o4
            r2[r9] = r8
            r2[r8] = r8
        L_0x0043:
            android.view.MotionEvent r12 = android.view.MotionEvent.obtain(r18)
            int[] r2 = r6.o4
            r3 = r2[r8]
            float r3 = (float) r3
            r2 = r2[r9]
            float r2 = (float) r2
            r12.offsetLocation(r3, r2)
            r2 = 1056964608(0x3f000000, float:0.5)
            if (r0 == 0) goto L_0x01c1
            if (r0 == r9) goto L_0x0180
            r3 = 2
            if (r0 == r3) goto L_0x008c
            r3 = 3
            if (r0 == r3) goto L_0x0087
            r3 = 5
            if (r0 == r3) goto L_0x006b
            r1 = 6
            if (r0 == r1) goto L_0x0066
            goto L_0x01e2
        L_0x0066:
            r17.l1(r18)
            goto L_0x01e2
        L_0x006b:
            int r0 = r7.getPointerId(r1)
            r6.M3 = r0
            float r0 = r7.getX(r1)
            float r0 = r0 + r2
            int r0 = (int) r0
            r6.Q3 = r0
            r6.O3 = r0
            float r0 = r7.getY(r1)
            float r0 = r0 + r2
            int r0 = (int) r0
            r6.R3 = r0
            r6.P3 = r0
            goto L_0x01e2
        L_0x0087:
            r17.B()
            goto L_0x01e2
        L_0x008c:
            int r0 = r6.M3
            int r0 = r7.findPointerIndex(r0)
            if (r0 >= 0) goto L_0x00b2
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Error processing scroll; pointer index for id "
            r0.append(r1)
            int r1 = r6.M3
            r0.append(r1)
            java.lang.String r1 = " not found. Did any MotionEvents get skipped?"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "RecyclerView"
            android.util.Log.e(r1, r0)
            return r8
        L_0x00b2:
            float r1 = r7.getX(r0)
            float r1 = r1 + r2
            int r13 = (int) r1
            float r0 = r7.getY(r0)
            float r0 = r0 + r2
            int r14 = (int) r0
            int r0 = r6.Q3
            int r0 = r0 - r13
            int r1 = r6.R3
            int r1 = r1 - r14
            int r2 = r6.L3
            if (r2 == r9) goto L_0x00f7
            if (r10 == 0) goto L_0x00dd
            int r2 = r6.S3
            if (r0 <= 0) goto L_0x00d4
            int r0 = r0 - r2
            int r0 = java.lang.Math.max(r8, r0)
            goto L_0x00d9
        L_0x00d4:
            int r0 = r0 + r2
            int r0 = java.lang.Math.min(r8, r0)
        L_0x00d9:
            if (r0 == 0) goto L_0x00dd
            r2 = 1
            goto L_0x00de
        L_0x00dd:
            r2 = 0
        L_0x00de:
            if (r11 == 0) goto L_0x00f2
            int r3 = r6.S3
            if (r1 <= 0) goto L_0x00ea
            int r1 = r1 - r3
            int r1 = java.lang.Math.max(r8, r1)
            goto L_0x00ef
        L_0x00ea:
            int r1 = r1 + r3
            int r1 = java.lang.Math.min(r8, r1)
        L_0x00ef:
            if (r1 == 0) goto L_0x00f2
            r2 = 1
        L_0x00f2:
            if (r2 == 0) goto L_0x00f7
            r6.setScrollState(r9)
        L_0x00f7:
            int r2 = r6.L3
            if (r2 != r9) goto L_0x01e2
            int[] r2 = r6.p4
            r2[r8] = r8
            r2[r9] = r8
            float r2 = r18.getY()
            int r2 = r6.w1(r0, r2)
            int r15 = r0 - r2
            float r0 = r18.getX()
            int r0 = r6.x1(r1, r0)
            int r16 = r1 - r0
            if (r10 == 0) goto L_0x0119
            r1 = r15
            goto L_0x011a
        L_0x0119:
            r1 = 0
        L_0x011a:
            if (r11 == 0) goto L_0x011f
            r2 = r16
            goto L_0x0120
        L_0x011f:
            r2 = 0
        L_0x0120:
            int[] r3 = r6.p4
            int[] r4 = r6.n4
            r5 = 0
            r0 = r17
            boolean r0 = r0.b(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x014f
            int[] r0 = r6.p4
            r1 = r0[r8]
            int r15 = r15 - r1
            r0 = r0[r9]
            int r16 = r16 - r0
            int[] r0 = r6.o4
            r1 = r0[r8]
            int[] r2 = r6.n4
            r3 = r2[r8]
            int r1 = r1 + r3
            r0[r8] = r1
            r1 = r0[r9]
            r2 = r2[r9]
            int r1 = r1 + r2
            r0[r9] = r1
            android.view.ViewParent r0 = r17.getParent()
            r0.requestDisallowInterceptTouchEvent(r9)
        L_0x014f:
            r0 = r16
            int[] r1 = r6.n4
            r2 = r1[r8]
            int r13 = r13 - r2
            r6.Q3 = r13
            r1 = r1[r9]
            int r14 = r14 - r1
            r6.R3 = r14
            if (r10 == 0) goto L_0x0161
            r1 = r15
            goto L_0x0162
        L_0x0161:
            r1 = 0
        L_0x0162:
            if (r11 == 0) goto L_0x0166
            r2 = r0
            goto L_0x0167
        L_0x0166:
            r2 = 0
        L_0x0167:
            boolean r1 = r6.M1(r1, r2, r7, r8)
            if (r1 == 0) goto L_0x0174
            android.view.ViewParent r1 = r17.getParent()
            r1.requestDisallowInterceptTouchEvent(r9)
        L_0x0174:
            androidx.recyclerview.widget.GapWorker r1 = r6.a4
            if (r1 == 0) goto L_0x01e2
            if (r15 != 0) goto L_0x017c
            if (r0 == 0) goto L_0x01e2
        L_0x017c:
            r1.f(r6, r15, r0)
            goto L_0x01e2
        L_0x0180:
            android.view.VelocityTracker r0 = r6.N3
            r0.addMovement(r12)
            android.view.VelocityTracker r0 = r6.N3
            int r1 = r6.V3
            float r1 = (float) r1
            r2 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r2, r1)
            r0 = 0
            if (r10 == 0) goto L_0x019c
            android.view.VelocityTracker r1 = r6.N3
            int r2 = r6.M3
            float r1 = r1.getXVelocity(r2)
            float r1 = -r1
            goto L_0x019d
        L_0x019c:
            r1 = 0
        L_0x019d:
            if (r11 == 0) goto L_0x01a9
            android.view.VelocityTracker r2 = r6.N3
            int r3 = r6.M3
            float r2 = r2.getYVelocity(r3)
            float r2 = -r2
            goto L_0x01aa
        L_0x01a9:
            r2 = 0
        L_0x01aa:
            int r3 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r3 != 0) goto L_0x01b2
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 == 0) goto L_0x01ba
        L_0x01b2:
            int r0 = (int) r1
            int r1 = (int) r2
            boolean r0 = r6.r0(r0, r1)
            if (r0 != 0) goto L_0x01bd
        L_0x01ba:
            r6.setScrollState(r8)
        L_0x01bd:
            r17.J1()
            goto L_0x01e7
        L_0x01c1:
            int r0 = r7.getPointerId(r8)
            r6.M3 = r0
            float r0 = r18.getX()
            float r0 = r0 + r2
            int r0 = (int) r0
            r6.Q3 = r0
            r6.O3 = r0
            float r0 = r18.getY()
            float r0 = r0 + r2
            int r0 = (int) r0
            r6.R3 = r0
            r6.P3 = r0
            if (r11 == 0) goto L_0x01df
            r10 = r10 | 2
        L_0x01df:
            r6.f(r10, r8)
        L_0x01e2:
            android.view.VelocityTracker r0 = r6.N3
            r0.addMovement(r12)
        L_0x01e7:
            r12.recycle()
            return r9
        L_0x01eb:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setItemDecoration(@NonNull ItemDecoration itemDecoration) {
        q(itemDecoration, -1);
    }

    @Deprecated
    @Nullable
    public ViewHolder p0(int i2) {
        return q0(i2, false);
    }

    public void q(@NonNull ItemDecoration itemDecoration, int i2) {
        LayoutManager layoutManager = this.j3;
        if (layoutManager != null) {
            layoutManager.n("Cannot add item decoration during a scroll  or layout");
        }
        if (this.m3.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i2 < 0) {
            this.m3.add(itemDecoration);
        } else {
            this.m3.add(i2, itemDecoration);
        }
        X0();
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public ViewHolder q0(int i2, boolean z) {
        int j2 = this.b3.j();
        ViewHolder viewHolder = null;
        for (int i6 = 0; i6 < j2; i6++) {
            ViewHolder z0 = z0(this.b3.i(i6));
            if (z0 != null && !z0.Q()) {
                if (z) {
                    if (z0.f15589c != i2) {
                        continue;
                    }
                } else if (z0.G() != i2) {
                    continue;
                }
                if (!this.b3.n(z0.f15587a)) {
                    return z0;
                }
                viewHolder = z0;
            }
        }
        return viewHolder;
    }

    public void r(@NonNull OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        if (this.A3 == null) {
            this.A3 = new ArrayList();
        }
        this.A3.add(onChildAttachStateChangeListener);
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00e0 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00f0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean r0(int r8, int r9) {
        /*
            r7 = this;
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r7.j3
            r1 = 0
            if (r0 != 0) goto L_0x000d
            java.lang.String r8 = "RecyclerView"
            java.lang.String r9 = "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument."
            android.util.Log.e(r8, r9)
            return r1
        L_0x000d:
            boolean r2 = r7.v3
            if (r2 == 0) goto L_0x0012
            return r1
        L_0x0012:
            boolean r0 = r0.s()
            androidx.recyclerview.widget.RecyclerView$LayoutManager r2 = r7.j3
            boolean r2 = r2.t()
            if (r0 == 0) goto L_0x0026
            int r3 = java.lang.Math.abs(r8)
            int r4 = r7.U3
            if (r3 >= r4) goto L_0x0027
        L_0x0026:
            r8 = 0
        L_0x0027:
            if (r2 == 0) goto L_0x0031
            int r3 = java.lang.Math.abs(r9)
            int r4 = r7.U3
            if (r3 >= r4) goto L_0x0032
        L_0x0031:
            r9 = 0
        L_0x0032:
            if (r8 != 0) goto L_0x0037
            if (r9 != 0) goto L_0x0037
            return r1
        L_0x0037:
            r3 = 0
            if (r8 == 0) goto L_0x007a
            android.widget.EdgeEffect r4 = r7.G3
            if (r4 == 0) goto L_0x005c
            float r4 = androidx.core.widget.EdgeEffectCompat.d(r4)
            int r4 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r4 == 0) goto L_0x005c
            android.widget.EdgeEffect r4 = r7.G3
            int r5 = -r8
            int r6 = r7.getWidth()
            boolean r4 = r7.R1(r4, r5, r6)
            if (r4 == 0) goto L_0x0059
            android.widget.EdgeEffect r8 = r7.G3
            r8.onAbsorb(r5)
        L_0x0058:
            r8 = 0
        L_0x0059:
            r4 = r8
            r8 = 0
            goto L_0x007b
        L_0x005c:
            android.widget.EdgeEffect r4 = r7.I3
            if (r4 == 0) goto L_0x007a
            float r4 = androidx.core.widget.EdgeEffectCompat.d(r4)
            int r4 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r4 == 0) goto L_0x007a
            android.widget.EdgeEffect r4 = r7.I3
            int r5 = r7.getWidth()
            boolean r4 = r7.R1(r4, r8, r5)
            if (r4 == 0) goto L_0x0059
            android.widget.EdgeEffect r4 = r7.I3
            r4.onAbsorb(r8)
            goto L_0x0058
        L_0x007a:
            r4 = 0
        L_0x007b:
            if (r9 == 0) goto L_0x00bc
            android.widget.EdgeEffect r5 = r7.H3
            if (r5 == 0) goto L_0x009e
            float r5 = androidx.core.widget.EdgeEffectCompat.d(r5)
            int r5 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x009e
            android.widget.EdgeEffect r3 = r7.H3
            int r5 = -r9
            int r6 = r7.getHeight()
            boolean r3 = r7.R1(r3, r5, r6)
            if (r3 == 0) goto L_0x009c
            android.widget.EdgeEffect r9 = r7.H3
            r9.onAbsorb(r5)
        L_0x009b:
            r9 = 0
        L_0x009c:
            r3 = 0
            goto L_0x00be
        L_0x009e:
            android.widget.EdgeEffect r5 = r7.J3
            if (r5 == 0) goto L_0x00bc
            float r5 = androidx.core.widget.EdgeEffectCompat.d(r5)
            int r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r3 == 0) goto L_0x00bc
            android.widget.EdgeEffect r3 = r7.J3
            int r5 = r7.getHeight()
            boolean r3 = r7.R1(r3, r9, r5)
            if (r3 == 0) goto L_0x009c
            android.widget.EdgeEffect r3 = r7.J3
            r3.onAbsorb(r9)
            goto L_0x009b
        L_0x00bc:
            r3 = r9
            r9 = 0
        L_0x00be:
            if (r4 != 0) goto L_0x00c2
            if (r9 == 0) goto L_0x00dd
        L_0x00c2:
            int r5 = r7.V3
            int r6 = -r5
            int r4 = java.lang.Math.min(r4, r5)
            int r4 = java.lang.Math.max(r6, r4)
            int r5 = r7.V3
            int r6 = -r5
            int r9 = java.lang.Math.min(r9, r5)
            int r9 = java.lang.Math.max(r6, r9)
            androidx.recyclerview.widget.RecyclerView$ViewFlinger r5 = r7.Z3
            r5.b(r4, r9)
        L_0x00dd:
            r5 = 1
            if (r8 != 0) goto L_0x00e8
            if (r3 != 0) goto L_0x00e8
            if (r4 != 0) goto L_0x00e6
            if (r9 == 0) goto L_0x00e7
        L_0x00e6:
            r1 = 1
        L_0x00e7:
            return r1
        L_0x00e8:
            float r9 = (float) r8
            float r4 = (float) r3
            boolean r6 = r7.dispatchNestedPreFling(r9, r4)
            if (r6 != 0) goto L_0x012b
            if (r0 != 0) goto L_0x00f7
            if (r2 == 0) goto L_0x00f5
            goto L_0x00f7
        L_0x00f5:
            r6 = 0
            goto L_0x00f8
        L_0x00f7:
            r6 = 1
        L_0x00f8:
            r7.dispatchNestedFling(r9, r4, r6)
            androidx.recyclerview.widget.RecyclerView$OnFlingListener r9 = r7.T3
            if (r9 == 0) goto L_0x0106
            boolean r9 = r9.a(r8, r3)
            if (r9 == 0) goto L_0x0106
            return r5
        L_0x0106:
            if (r6 == 0) goto L_0x012b
            if (r2 == 0) goto L_0x010c
            r0 = r0 | 2
        L_0x010c:
            r7.f(r0, r5)
            int r9 = r7.V3
            int r0 = -r9
            int r8 = java.lang.Math.min(r8, r9)
            int r8 = java.lang.Math.max(r0, r8)
            int r9 = r7.V3
            int r0 = -r9
            int r9 = java.lang.Math.min(r3, r9)
            int r9 = java.lang.Math.max(r0, r9)
            androidx.recyclerview.widget.RecyclerView$ViewFlinger r0 = r7.Z3
            r0.b(r8, r9)
            return r5
        L_0x012b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.r0(int, int):boolean");
    }

    /* access modifiers changed from: package-private */
    public void r1(boolean z) {
        this.C3 = z | this.C3;
        this.B3 = true;
        Y0();
    }

    /* access modifiers changed from: protected */
    public void removeDetachedView(View view, boolean z) {
        ViewHolder z0 = z0(view);
        if (z0 != null) {
            if (z0.S()) {
                z0.w();
            } else if (!z0.e0()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + z0 + d0());
            }
        } else if (x4) {
            throw new IllegalArgumentException("No ViewHolder found for child: " + view + d0());
        }
        view.clearAnimation();
        P(view);
        super.removeDetachedView(view, z);
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.j3.w1(this, this.c4, view, view2) && view2 != null) {
            H1(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.j3.P1(this, view, rect, z);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.n3.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.n3.get(i2).e(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public void requestLayout() {
        if (this.t3 != 0 || this.v3) {
            this.u3 = true;
        } else {
            super.requestLayout();
        }
    }

    public void s(@NonNull OnItemTouchListener onItemTouchListener) {
        this.n3.add(onItemTouchListener);
    }

    /* access modifiers changed from: package-private */
    public int s0(ViewHolder viewHolder) {
        if (viewHolder.K(MetaDo.t) || !viewHolder.N()) {
            return -1;
        }
        return this.a3.f(viewHolder.f15589c);
    }

    public void scrollBy(int i2, int i6) {
        LayoutManager layoutManager = this.j3;
        if (layoutManager == null) {
            Log.e(w4, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.v3) {
            boolean s2 = layoutManager.s();
            boolean t = this.j3.t();
            if (s2 || t) {
                if (!s2) {
                    i2 = 0;
                }
                if (!t) {
                    i6 = 0;
                }
                M1(i2, i6, (MotionEvent) null, 0);
            }
        }
    }

    public void scrollTo(int i2, int i6) {
        Log.w(w4, "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!S1(accessibilityEvent)) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public void setAccessibilityDelegateCompat(@Nullable RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
        this.j4 = recyclerViewAccessibilityDelegate;
        ViewCompat.H1(this, recyclerViewAccessibilityDelegate);
    }

    public void setAdapter(@Nullable Adapter adapter) {
        setLayoutFrozen(false);
        P1(adapter, false, true);
        r1(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(@Nullable ChildDrawingOrderCallback childDrawingOrderCallback) {
        if (childDrawingOrderCallback != this.k4) {
            this.k4 = childDrawingOrderCallback;
            setChildrenDrawingOrderEnabled(childDrawingOrderCallback != null);
        }
    }

    public void setClipToPadding(boolean z) {
        if (z != this.d3) {
            P0();
        }
        this.d3 = z;
        super.setClipToPadding(z);
        if (this.s3) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(@NonNull EdgeEffectFactory edgeEffectFactory) {
        Preconditions.l(edgeEffectFactory);
        this.F3 = edgeEffectFactory;
        P0();
    }

    public void setHasFixedSize(boolean z) {
        this.q3 = z;
    }

    public void setItemAnimator(@Nullable ItemAnimator itemAnimator) {
        ItemAnimator itemAnimator2 = this.K3;
        if (itemAnimator2 != null) {
            itemAnimator2.l();
            this.K3.A((ItemAnimator.ItemAnimatorListener) null);
        }
        this.K3 = itemAnimator;
        if (itemAnimator != null) {
            itemAnimator.A(this.h4);
        }
    }

    public void setItemViewCacheSize(int i2) {
        this.Y2.M(i2);
    }

    @Deprecated
    public void setLayoutFrozen(boolean z) {
        suppressLayout(z);
    }

    public void setLayoutManager(@Nullable LayoutManager layoutManager) {
        if (layoutManager != this.j3) {
            b2();
            if (this.j3 != null) {
                ItemAnimator itemAnimator = this.K3;
                if (itemAnimator != null) {
                    itemAnimator.l();
                }
                this.j3.H1(this.Y2);
                this.j3.I1(this.Y2);
                this.Y2.d();
                if (this.p3) {
                    this.j3.L(this, this.Y2);
                }
                this.j3.f2((RecyclerView) null);
                this.j3 = null;
            } else {
                this.Y2.d();
            }
            this.b3.o();
            this.j3 = layoutManager;
            if (layoutManager != null) {
                if (layoutManager.f15515b == null) {
                    layoutManager.f2(this);
                    if (this.p3) {
                        this.j3.K(this);
                    }
                } else {
                    throw new IllegalArgumentException("LayoutManager " + layoutManager + " is already attached to a RecyclerView:" + layoutManager.f15515b.d0());
                }
            }
            this.Y2.Q();
            requestLayout();
        }
    }

    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition == null) {
            super.setLayoutTransition((LayoutTransition) null);
            return;
        }
        throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    }

    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().p(z);
    }

    public void setOnFlingListener(@Nullable OnFlingListener onFlingListener) {
        this.T3 = onFlingListener;
    }

    @Deprecated
    public void setOnScrollListener(@Nullable OnScrollListener onScrollListener) {
        this.d4 = onScrollListener;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.Y3 = z;
    }

    public void setRecycledViewPool(@Nullable RecycledViewPool recycledViewPool) {
        this.Y2.K(recycledViewPool);
    }

    @Deprecated
    public void setRecyclerListener(@Nullable RecyclerListener recyclerListener) {
        this.k3 = recyclerListener;
    }

    /* access modifiers changed from: package-private */
    public void setScrollState(int i2) {
        if (i2 != this.L3) {
            if (y4) {
                Log.d(w4, "setting scroll state to " + i2 + " from " + this.L3, new Exception());
            }
            this.L3 = i2;
            if (i2 != 2) {
                c2();
            }
            V(i2);
        }
    }

    public void setScrollingTouchSlop(int i2) {
        int scaledTouchSlop;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i2 != 0) {
            if (i2 != 1) {
                Log.w(w4, "setScrollingTouchSlop(): bad argument constant " + i2 + "; using default value");
            } else {
                scaledTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                this.S3 = scaledTouchSlop;
            }
        }
        scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.S3 = scaledTouchSlop;
    }

    public void setViewCacheExtension(@Nullable ViewCacheExtension viewCacheExtension) {
        this.Y2.L(viewCacheExtension);
    }

    public boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().r(i2);
    }

    public void stopNestedScroll() {
        getScrollingChildHelper().t();
    }

    public final void suppressLayout(boolean z) {
        if (z != this.v3) {
            z("Do not suppressLayout in layout or scroll");
            if (!z) {
                this.v3 = false;
                if (!(!this.u3 || this.j3 == null || this.i3 == null)) {
                    requestLayout();
                }
                this.u3 = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.v3 = true;
            this.w3 = true;
            b2();
        }
    }

    public void t(@NonNull OnScrollListener onScrollListener) {
        if (this.e4 == null) {
            this.e4 = new ArrayList();
        }
        this.e4.add(onScrollListener);
    }

    /* access modifiers changed from: package-private */
    public long t0(ViewHolder viewHolder) {
        return this.i3.F() ? viewHolder.E() : (long) viewHolder.f15589c;
    }

    /* access modifiers changed from: package-private */
    public void t1(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo) {
        viewHolder.a0(0, 8192);
        if (this.c4.f15581i && viewHolder.T() && !viewHolder.Q() && !viewHolder.e0()) {
            this.c3.c(t0(viewHolder), viewHolder);
        }
        this.c3.e(viewHolder, itemHolderInfo);
    }

    public void u(@NonNull RecyclerListener recyclerListener) {
        Preconditions.b(recyclerListener != null, "'listener' arg cannot be null.");
        this.l3.add(recyclerListener);
    }

    public int u0(@NonNull View view) {
        ViewHolder z0 = z0(view);
        if (z0 != null) {
            return z0.A();
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public void v(@NonNull ViewHolder viewHolder, @Nullable ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        viewHolder.b0(false);
        if (this.K3.a(viewHolder, itemHolderInfo, itemHolderInfo2)) {
            o1();
        }
    }

    public long v0(@NonNull View view) {
        ViewHolder z0;
        Adapter adapter = this.i3;
        if (adapter == null || !adapter.F() || (z0 = z0(view)) == null) {
            return -1;
        }
        return z0.E();
    }

    public int w0(@NonNull View view) {
        ViewHolder z0 = z0(view);
        if (z0 != null) {
            return z0.G();
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public void x(@NonNull ViewHolder viewHolder, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo, @Nullable ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        o(viewHolder);
        viewHolder.b0(false);
        if (this.K3.c(viewHolder, itemHolderInfo, itemHolderInfo2)) {
            o1();
        }
    }

    @Deprecated
    public int x0(@NonNull View view) {
        return u0(view);
    }

    /* access modifiers changed from: package-private */
    public void y(String str) {
        if (T0()) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling" + d0());
        }
        throw new IllegalStateException(str + d0());
    }

    public ViewHolder y0(@NonNull View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return z0(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    /* access modifiers changed from: package-private */
    public void y1() {
        ItemAnimator itemAnimator = this.K3;
        if (itemAnimator != null) {
            itemAnimator.l();
        }
        LayoutManager layoutManager = this.j3;
        if (layoutManager != null) {
            layoutManager.H1(this.Y2);
            this.j3.I1(this.Y2);
        }
        this.Y2.d();
    }

    /* access modifiers changed from: package-private */
    public void z(String str) {
        if (T0()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + d0());
            }
            throw new IllegalStateException(str);
        } else if (this.E3 > 0) {
            Log.w(w4, "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + d0()));
        }
    }

    /* access modifiers changed from: package-private */
    public boolean z1(View view) {
        Y1();
        boolean r = this.b3.r(view);
        if (r) {
            ViewHolder z0 = z0(view);
            this.Y2.P(z0);
            this.Y2.I(z0);
            if (y4) {
                Log.d(w4, "after removing animated view: " + view + ", " + this);
            }
        }
        a2(!r);
        return r;
    }

    public RecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.f15163g);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        LayoutManager layoutManager = this.j3;
        if (layoutManager != null) {
            return layoutManager.R(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + d0());
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Context context2 = context;
        AttributeSet attributeSet2 = attributeSet;
        int i6 = i2;
        this.X2 = new RecyclerViewDataObserver();
        this.Y2 = new Recycler();
        this.c3 = new ViewInfoStore();
        this.e3 = new Runnable() {
            public void run() {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.s3 && !recyclerView.isLayoutRequested()) {
                    RecyclerView recyclerView2 = RecyclerView.this;
                    if (!recyclerView2.p3) {
                        recyclerView2.requestLayout();
                    } else if (recyclerView2.v3) {
                        recyclerView2.u3 = true;
                    } else {
                        recyclerView2.K();
                    }
                }
            }
        };
        this.f3 = new Rect();
        this.g3 = new Rect();
        this.h3 = new RectF();
        this.l3 = new ArrayList();
        this.m3 = new ArrayList<>();
        this.n3 = new ArrayList<>();
        this.t3 = 0;
        this.B3 = false;
        this.C3 = false;
        this.D3 = 0;
        this.E3 = 0;
        this.F3 = l5;
        this.K3 = new DefaultItemAnimator();
        this.L3 = 0;
        this.M3 = -1;
        this.W3 = Float.MIN_VALUE;
        this.X3 = Float.MIN_VALUE;
        this.Y3 = true;
        this.Z3 = new ViewFlinger();
        this.b4 = H4 ? new GapWorker.LayoutPrefetchRegistryImpl() : null;
        this.c4 = new State();
        this.f4 = false;
        this.g4 = false;
        this.h4 = new ItemAnimatorRestoreListener();
        this.i4 = false;
        this.l4 = new int[2];
        this.n4 = new int[2];
        this.o4 = new int[2];
        this.p4 = new int[2];
        this.q4 = new ArrayList();
        this.r4 = new Runnable() {
            public void run() {
                ItemAnimator itemAnimator = RecyclerView.this.K3;
                if (itemAnimator != null) {
                    itemAnimator.x();
                }
                RecyclerView.this.i4 = false;
            }
        };
        this.t4 = 0;
        this.u4 = 0;
        this.v4 = new ViewInfoStore.ProcessCallback() {
            public void a(ViewHolder viewHolder) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.j3.J1(viewHolder.f15587a, recyclerView.Y2);
            }

            public void b(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                RecyclerView.this.v(viewHolder, itemHolderInfo, itemHolderInfo2);
            }

            public void c(ViewHolder viewHolder, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo, @Nullable ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                RecyclerView.this.Y2.P(viewHolder);
                RecyclerView.this.x(viewHolder, itemHolderInfo, itemHolderInfo2);
            }

            public void d(ViewHolder viewHolder, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                viewHolder.b0(false);
                RecyclerView recyclerView = RecyclerView.this;
                boolean z = recyclerView.B3;
                ItemAnimator itemAnimator = recyclerView.K3;
                if (z) {
                    if (!itemAnimator.b(viewHolder, viewHolder, itemHolderInfo, itemHolderInfo2)) {
                        return;
                    }
                } else if (!itemAnimator.d(viewHolder, itemHolderInfo, itemHolderInfo2)) {
                    return;
                }
                RecyclerView.this.o1();
            }
        };
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.S3 = viewConfiguration.getScaledTouchSlop();
        this.W3 = ViewConfigurationCompat.f(viewConfiguration, context2);
        this.X3 = ViewConfigurationCompat.k(viewConfiguration, context2);
        this.U3 = viewConfiguration.getScaledMinimumFlingVelocity();
        this.V3 = viewConfiguration.getScaledMaximumFlingVelocity();
        this.s = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        setWillNotDraw(getOverScrollMode() == 2);
        this.K3.A(this.h4);
        L0();
        N0();
        M0();
        if (ViewCompat.X(this) == 0) {
            ViewCompat.Z1(this, 1);
        }
        this.z3 = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
        int[] iArr = R.styleable.f15174a;
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet2, iArr, i6, 0);
        ViewCompat.F1(this, context, iArr, attributeSet, obtainStyledAttributes, i2, 0);
        String string = obtainStyledAttributes.getString(R.styleable.f15183j);
        if (obtainStyledAttributes.getInt(R.styleable.f15177d, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.d3 = obtainStyledAttributes.getBoolean(R.styleable.f15176c, true);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.f15178e, false);
        this.r3 = z;
        if (z) {
            O0((StateListDrawable) obtainStyledAttributes.getDrawable(R.styleable.f15181h), obtainStyledAttributes.getDrawable(R.styleable.f15182i), (StateListDrawable) obtainStyledAttributes.getDrawable(R.styleable.f15179f), obtainStyledAttributes.getDrawable(R.styleable.f15180g));
        }
        obtainStyledAttributes.recycle();
        L(context, string, attributeSet, i2, 0);
        int[] iArr2 = A4;
        TypedArray obtainStyledAttributes2 = context2.obtainStyledAttributes(attributeSet2, iArr2, i6, 0);
        ViewCompat.F1(this, context, iArr2, attributeSet, obtainStyledAttributes2, i2, 0);
        boolean z2 = obtainStyledAttributes2.getBoolean(0, true);
        obtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z2);
        PoolingContainer.h(this, true);
    }
}
