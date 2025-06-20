package com.google.android.material.bottomsheet;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.RoundedCorner;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import androidx.activity.BackEventCompat;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.Insets;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.R;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MaterialBackHandler;
import com.google.android.material.motion.MaterialBottomContainerBackHelper;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> implements MaterialBackHandler {
    public static final int b4 = 1;
    public static final int c4 = 2;
    public static final int d4 = 3;
    public static final int e4 = 4;
    public static final int f4 = 5;
    public static final int g4 = 6;
    public static final int h4 = -1;
    public static final int i4 = 1;
    public static final int j4 = 2;
    public static final int k4 = 4;
    public static final int l4 = 8;
    public static final int m4 = -1;
    public static final int n4 = 0;
    private static final String o4 = "BottomSheetBehavior";
    @VisibleForTesting
    static final int p4 = 500;
    private static final float q4 = 0.5f;
    private static final float r4 = 0.1f;
    private static final int s4 = 500;
    private static final int t4 = -1;
    private static final int u4 = 0;
    private static final int v4 = -1;
    @VisibleForTesting
    static final int w4 = 1;
    private static final int x4 = R.style.Ne;
    int A3;
    float B3 = -1.0f;
    boolean C3;
    /* access modifiers changed from: private */
    public boolean D3;
    /* access modifiers changed from: private */
    public boolean E3 = true;
    int F3 = 4;
    int G3 = 4;
    @Nullable
    ViewDragHelper H3;
    private boolean I3;
    private int J3;
    private boolean K3;
    private float L3 = 0.1f;
    private int M3;
    int N3;
    int O3;
    @Nullable
    WeakReference<V> P3;
    @Nullable
    WeakReference<View> Q3;
    @Nullable
    WeakReference<View> R3;
    @NonNull
    private final ArrayList<BottomSheetCallback> S3 = new ArrayList<>();
    @Nullable
    private VelocityTracker T3;
    @Nullable
    MaterialBottomContainerBackHelper U3;
    int V3;
    private int W3 = -1;
    /* access modifiers changed from: private */
    public boolean X = true;
    /* access modifiers changed from: private */
    public int X2;
    boolean X3;
    private boolean Y = false;
    /* access modifiers changed from: private */
    public int Y2;
    @Nullable
    private Map<View, Integer> Y3;
    private float Z;
    private boolean Z2;
    @VisibleForTesting
    final SparseIntArray Z3 = new SparseIntArray();
    private int a3;
    private final ViewDragHelper.Callback a4 = new ViewDragHelper.Callback() {

        /* renamed from: a  reason: collision with root package name */
        private long f20856a;

        private boolean n(@NonNull View view) {
            int top = view.getTop();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return top > (bottomSheetBehavior.O3 + bottomSheetBehavior.A0()) / 2;
        }

        public int a(@NonNull View view, int i2, int i3) {
            return view.getLeft();
        }

        public int b(@NonNull View view, int i2, int i3) {
            return MathUtils.e(i2, BottomSheetBehavior.this.A0(), e(view));
        }

        public int e(@NonNull View view) {
            return BottomSheetBehavior.this.p0() ? BottomSheetBehavior.this.O3 : BottomSheetBehavior.this.A3;
        }

        public void j(int i2) {
            if (i2 == 1 && BottomSheetBehavior.this.E3) {
                BottomSheetBehavior.this.v1(1);
            }
        }

        public void k(@NonNull View view, int i2, int i3, int i4, int i5) {
            BottomSheetBehavior.this.v0(i3);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x003c, code lost:
            if (r9 > r7.f20857b.y3) goto L_0x012b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0091, code lost:
            if (java.lang.Math.abs(r8.getTop() - r7.f20857b.A0()) < java.lang.Math.abs(r8.getTop() - r7.f20857b.y3)) goto L_0x0010;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00d0, code lost:
            if (r7.f20857b.B1() == false) goto L_0x012b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x00f2, code lost:
            if (java.lang.Math.abs(r9 - r7.f20857b.x3) < java.lang.Math.abs(r9 - r7.f20857b.A3)) goto L_0x0010;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x010e, code lost:
            if (r7.f20857b.B1() != false) goto L_0x00ae;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x0128, code lost:
            if (r7.f20857b.B1() == false) goto L_0x012b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0035, code lost:
            if (r10.y1(r3, (((float) r9) * 100.0f) / ((float) r10.O3)) != false) goto L_0x0010;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void l(@androidx.annotation.NonNull android.view.View r8, float r9, float r10) {
            /*
                r7 = this;
                r0 = 6
                r1 = 3
                r2 = 4
                r3 = 0
                int r4 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
                if (r4 >= 0) goto L_0x0040
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r9 = r9.X
                if (r9 == 0) goto L_0x0013
            L_0x0010:
                r0 = 3
                goto L_0x012b
            L_0x0013:
                int r9 = r8.getTop()
                long r3 = java.lang.System.currentTimeMillis()
                long r5 = r7.f20856a
                long r3 = r3 - r5
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r10 = r10.B1()
                if (r10 == 0) goto L_0x0038
                float r9 = (float) r9
                r10 = 1120403456(0x42c80000, float:100.0)
                float r9 = r9 * r10
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r10.O3
                float r0 = (float) r0
                float r9 = r9 / r0
                boolean r9 = r10.y1(r3, r9)
                if (r9 == 0) goto L_0x00ae
                goto L_0x0010
            L_0x0038:
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r10 = r10.y3
                if (r9 <= r10) goto L_0x0010
                goto L_0x012b
            L_0x0040:
                com.google.android.material.bottomsheet.BottomSheetBehavior r4 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r5 = r4.C3
                if (r5 == 0) goto L_0x0095
                boolean r4 = r4.A1(r8, r10)
                if (r4 == 0) goto L_0x0095
                float r9 = java.lang.Math.abs(r9)
                float r2 = java.lang.Math.abs(r10)
                int r9 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
                if (r9 >= 0) goto L_0x0063
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r9 = r9.X2
                float r9 = (float) r9
                int r9 = (r10 > r9 ? 1 : (r10 == r9 ? 0 : -1))
                if (r9 > 0) goto L_0x0069
            L_0x0063:
                boolean r9 = r7.n(r8)
                if (r9 == 0) goto L_0x006c
            L_0x0069:
                r0 = 5
                goto L_0x012b
            L_0x006c:
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r9 = r9.X
                if (r9 == 0) goto L_0x0075
                goto L_0x0010
            L_0x0075:
                int r9 = r8.getTop()
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r10 = r10.A0()
                int r9 = r9 - r10
                int r9 = java.lang.Math.abs(r9)
                int r10 = r8.getTop()
                com.google.android.material.bottomsheet.BottomSheetBehavior r2 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r2 = r2.y3
                int r10 = r10 - r2
                int r10 = java.lang.Math.abs(r10)
                if (r9 >= r10) goto L_0x012b
                goto L_0x0010
            L_0x0095:
                int r3 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
                if (r3 == 0) goto L_0x00d3
                float r9 = java.lang.Math.abs(r9)
                float r10 = java.lang.Math.abs(r10)
                int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
                if (r9 <= 0) goto L_0x00a6
                goto L_0x00d3
            L_0x00a6:
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r9 = r9.X
                if (r9 == 0) goto L_0x00b1
            L_0x00ae:
                r0 = 4
                goto L_0x012b
            L_0x00b1:
                int r9 = r8.getTop()
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r10 = r10.y3
                int r10 = r9 - r10
                int r10 = java.lang.Math.abs(r10)
                com.google.android.material.bottomsheet.BottomSheetBehavior r1 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r1 = r1.A3
                int r9 = r9 - r1
                int r9 = java.lang.Math.abs(r9)
                if (r10 >= r9) goto L_0x00ae
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r9 = r9.B1()
                if (r9 == 0) goto L_0x012b
                goto L_0x00ae
            L_0x00d3:
                int r9 = r8.getTop()
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r10 = r10.X
                if (r10 == 0) goto L_0x00f6
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r10 = r10.x3
                int r10 = r9 - r10
                int r10 = java.lang.Math.abs(r10)
                com.google.android.material.bottomsheet.BottomSheetBehavior r0 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r0.A3
                int r9 = r9 - r0
                int r9 = java.lang.Math.abs(r9)
                if (r10 >= r9) goto L_0x00ae
                goto L_0x0010
            L_0x00f6:
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r3 = r10.y3
                if (r9 >= r3) goto L_0x0111
                int r10 = r10.A3
                int r10 = r9 - r10
                int r10 = java.lang.Math.abs(r10)
                if (r9 >= r10) goto L_0x0108
                goto L_0x0010
            L_0x0108:
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r9 = r9.B1()
                if (r9 == 0) goto L_0x012b
                goto L_0x00ae
            L_0x0111:
                int r10 = r9 - r3
                int r10 = java.lang.Math.abs(r10)
                com.google.android.material.bottomsheet.BottomSheetBehavior r1 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r1 = r1.A3
                int r9 = r9 - r1
                int r9 = java.lang.Math.abs(r9)
                if (r10 >= r9) goto L_0x00ae
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r9 = r9.B1()
                if (r9 == 0) goto L_0x012b
                goto L_0x00ae
            L_0x012b:
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r10 = r9.C1()
                r9.D1(r8, r0, r10)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.AnonymousClass5.l(android.view.View, float, float):void");
        }

        public boolean m(@NonNull View view, int i2) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i3 = bottomSheetBehavior.F3;
            if (i3 == 1 || bottomSheetBehavior.X3) {
                return false;
            }
            if (i3 == 3 && bottomSheetBehavior.V3 == i2) {
                WeakReference<View> weakReference = bottomSheetBehavior.R3;
                View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            this.f20856a = System.currentTimeMillis();
            WeakReference<V> weakReference2 = BottomSheetBehavior.this.P3;
            return weakReference2 != null && weakReference2.get() == view;
        }
    };
    private int b3;
    /* access modifiers changed from: private */
    public MaterialShapeDrawable c3;
    @Nullable
    private ColorStateList d3;
    private int e3 = -1;
    private int f3 = -1;
    /* access modifiers changed from: private */
    public int g3;
    private boolean h3;
    /* access modifiers changed from: private */
    public boolean i3;
    /* access modifiers changed from: private */
    public boolean j3;
    /* access modifiers changed from: private */
    public boolean k3;
    private boolean l3;
    /* access modifiers changed from: private */
    public boolean m3;
    /* access modifiers changed from: private */
    public boolean n3;
    /* access modifiers changed from: private */
    public boolean o3;
    /* access modifiers changed from: private */
    public int p3;
    /* access modifiers changed from: private */
    public int q3;
    private boolean r3;
    private int s = 0;
    private ShapeAppearanceModel s3;
    private boolean t3;
    private final BottomSheetBehavior<V>.StateSettlingTracker u3 = new StateSettlingTracker();
    @Nullable
    private ValueAnimator v3;
    int w3;
    int x3;
    int y3;
    float z3 = 0.5f;

    public static abstract class BottomSheetCallback {
        /* access modifiers changed from: package-private */
        public void a(@NonNull View view) {
        }

        public abstract void b(@NonNull View view, float f2);

        public abstract void c(@NonNull View view, int i2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface SaveFlags {
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            @Nullable
            /* renamed from: a */
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            @NonNull
            /* renamed from: b */
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @NonNull
            /* renamed from: c */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };
        boolean X2;
        final int Y;
        boolean Y2;
        int Z;
        boolean Z2;

        public SavedState(@NonNull Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.Y);
            parcel.writeInt(this.Z);
            parcel.writeInt(this.X2 ? 1 : 0);
            parcel.writeInt(this.Y2 ? 1 : 0);
            parcel.writeInt(this.Z2 ? 1 : 0);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.Y = parcel.readInt();
            this.Z = parcel.readInt();
            boolean z = false;
            this.X2 = parcel.readInt() == 1;
            this.Y2 = parcel.readInt() == 1;
            this.Z2 = parcel.readInt() == 1 ? true : z;
        }

        @Deprecated
        public SavedState(Parcelable parcelable, int i2) {
            super(parcelable);
            this.Y = i2;
        }

        public SavedState(Parcelable parcelable, @NonNull BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.Y = bottomSheetBehavior.F3;
            this.Z = bottomSheetBehavior.Y2;
            this.X2 = bottomSheetBehavior.X;
            this.Y2 = bottomSheetBehavior.C3;
            this.Z2 = bottomSheetBehavior.D3;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface StableState {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    private class StateSettlingTracker {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public int f20860a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public boolean f20861b;

        /* renamed from: c  reason: collision with root package name */
        private final Runnable f20862c;

        private StateSettlingTracker() {
            this.f20862c = new Runnable() {
                public void run() {
                    boolean unused = StateSettlingTracker.this.f20861b = false;
                    ViewDragHelper viewDragHelper = BottomSheetBehavior.this.H3;
                    if (viewDragHelper == null || !viewDragHelper.o(true)) {
                        StateSettlingTracker stateSettlingTracker = StateSettlingTracker.this;
                        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                        if (bottomSheetBehavior.F3 == 2) {
                            bottomSheetBehavior.v1(stateSettlingTracker.f20860a);
                            return;
                        }
                        return;
                    }
                    StateSettlingTracker stateSettlingTracker2 = StateSettlingTracker.this;
                    stateSettlingTracker2.c(stateSettlingTracker2.f20860a);
                }
            };
        }

        /* access modifiers changed from: package-private */
        public void c(int i2) {
            WeakReference<V> weakReference = BottomSheetBehavior.this.P3;
            if (weakReference != null && weakReference.get() != null) {
                this.f20860a = i2;
                if (!this.f20861b) {
                    ViewCompat.v1((View) BottomSheetBehavior.this.P3.get(), this.f20862c);
                    this.f20861b = true;
                }
            }
        }
    }

    public BottomSheetBehavior() {
    }

    /* access modifiers changed from: private */
    public void D1(View view, int i2, boolean z) {
        int M0 = M0(i2);
        ViewDragHelper viewDragHelper = this.H3;
        if (viewDragHelper == null || (!z ? !viewDragHelper.X(view, view.getLeft(), M0) : !viewDragHelper.V(view.getLeft(), M0))) {
            v1(i2);
            return;
        }
        v1(2);
        G1(i2, true);
        this.u3.c(i2);
    }

    private void E1() {
        WeakReference<V> weakReference = this.P3;
        if (weakReference != null) {
            F1((View) weakReference.get(), 0);
        }
        WeakReference<View> weakReference2 = this.Q3;
        if (weakReference2 != null) {
            F1(weakReference2.get(), 1);
        }
    }

    private void F1(View view, int i2) {
        AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat;
        if (view != null) {
            q0(view, i2);
            int i5 = 6;
            if (!this.X && this.F3 != 6) {
                this.Z3.put(i2, g0(view, R.string.F, 6));
            }
            if (this.C3 && U0() && this.F3 != 5) {
                Z0(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.z, 5);
            }
            int i6 = this.F3;
            if (i6 == 3) {
                if (this.X) {
                    i5 = 4;
                }
                accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.y;
            } else if (i6 == 4) {
                if (this.X) {
                    i5 = 3;
                }
                accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.x;
            } else if (i6 == 6) {
                Z0(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.y, 4);
                Z0(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.x, 3);
                return;
            } else {
                return;
            }
            Z0(view, accessibilityActionCompat, i5);
        }
    }

    private void G1(int i2, boolean z) {
        boolean Q0;
        ValueAnimator valueAnimator;
        if (i2 != 2 && this.t3 != (Q0 = Q0()) && this.c3 != null) {
            this.t3 = Q0;
            float f2 = 1.0f;
            if (!z || (valueAnimator = this.v3) == null) {
                ValueAnimator valueAnimator2 = this.v3;
                if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                    this.v3.cancel();
                }
                MaterialShapeDrawable materialShapeDrawable = this.c3;
                if (this.t3) {
                    f2 = l0();
                }
                materialShapeDrawable.q0(f2);
            } else if (valueAnimator.isRunning()) {
                this.v3.reverse();
            } else {
                float A = this.c3.A();
                if (Q0) {
                    f2 = l0();
                }
                this.v3.setFloatValues(new float[]{A, f2});
                this.v3.start();
            }
        }
    }

    private void H1(boolean z) {
        Map<View, Integer> map;
        int intValue;
        WeakReference<V> weakReference = this.P3;
        if (weakReference != null) {
            ViewParent parent = ((View) weakReference.get()).getParent();
            if (parent instanceof CoordinatorLayout) {
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
                int childCount = coordinatorLayout.getChildCount();
                if (z) {
                    if (this.Y3 == null) {
                        this.Y3 = new HashMap(childCount);
                    } else {
                        return;
                    }
                }
                for (int i2 = 0; i2 < childCount; i2++) {
                    V childAt = coordinatorLayout.getChildAt(i2);
                    if (childAt != this.P3.get()) {
                        if (z) {
                            this.Y3.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                            if (this.Y) {
                                intValue = 4;
                            }
                        } else if (this.Y && (map = this.Y3) != null && map.containsKey(childAt)) {
                            intValue = this.Y3.get(childAt).intValue();
                        }
                        ViewCompat.Z1(childAt, intValue);
                    }
                }
                if (!z) {
                    this.Y3 = null;
                } else if (this.Y) {
                    ((View) this.P3.get()).sendAccessibilityEvent(8);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void I1(boolean z) {
        View view;
        if (this.P3 != null) {
            i0();
            if (this.F3 == 4 && (view = (View) this.P3.get()) != null) {
                if (z) {
                    b(4);
                } else {
                    view.requestLayout();
                }
            }
        }
    }

    private int M0(int i2) {
        if (i2 == 3) {
            return A0();
        }
        if (i2 == 4) {
            return this.A3;
        }
        if (i2 == 5) {
            return this.O3;
        }
        if (i2 == 6) {
            return this.y3;
        }
        throw new IllegalArgumentException("Invalid state to get top offset: " + i2);
    }

    private float N0() {
        VelocityTracker velocityTracker = this.T3;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.Z);
        return this.T3.getYVelocity(this.V3);
    }

    private boolean O0() {
        WeakReference<V> weakReference = this.P3;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        int[] iArr = new int[2];
        ((View) this.P3.get()).getLocationOnScreen(iArr);
        return iArr[1] == 0;
    }

    private boolean Q0() {
        return this.F3 == 3 && (this.r3 || O0());
    }

    private boolean V0(V v) {
        ViewParent parent = v.getParent();
        return parent != null && parent.isLayoutRequested() && ViewCompat.R0(v);
    }

    private void Z0(View view, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, int i2) {
        ViewCompat.A1(view, accessibilityActionCompat, (CharSequence) null, r0(i2));
    }

    private void a1() {
        this.V3 = -1;
        this.W3 = -1;
        VelocityTracker velocityTracker = this.T3;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.T3 = null;
        }
    }

    private void b1(@NonNull SavedState savedState) {
        int i2 = this.s;
        if (i2 != 0) {
            if (i2 == -1 || (i2 & 1) == 1) {
                this.Y2 = savedState.Z;
            }
            if (i2 == -1 || (i2 & 2) == 2) {
                this.X = savedState.X2;
            }
            if (i2 == -1 || (i2 & 4) == 4) {
                this.C3 = savedState.Y2;
            }
            if (i2 == -1 || (i2 & 8) == 8) {
                this.D3 = savedState.Z2;
            }
        }
    }

    private void c1(V v, Runnable runnable) {
        if (V0(v)) {
            v.post(runnable);
        } else {
            runnable.run();
        }
    }

    private int g0(View view, @StringRes int i2, int i5) {
        return ViewCompat.c(view, view.getResources().getString(i2), r0(i5));
    }

    private void i0() {
        int m0 = m0();
        if (this.X) {
            this.A3 = Math.max(this.O3 - m0, this.x3);
        } else {
            this.A3 = this.O3 - m0;
        }
    }

    @RequiresApi(31)
    private float j0(float f2, @Nullable RoundedCorner roundedCorner) {
        if (roundedCorner != null) {
            float a2 = (float) roundedCorner.getRadius();
            if (a2 > 0.0f && f2 > 0.0f) {
                return a2 / f2;
            }
        }
        return 0.0f;
    }

    private void k0() {
        this.y3 = (int) (((float) this.O3) * (1.0f - this.z3));
    }

    private float l0() {
        WeakReference<V> weakReference;
        WindowInsets a2;
        if (this.c3 == null || (weakReference = this.P3) == null || weakReference.get() == null || Build.VERSION.SDK_INT < 31) {
            return 0.0f;
        }
        View view = (View) this.P3.get();
        if (!O0() || (a2 = view.getRootWindowInsets()) == null) {
            return 0.0f;
        }
        return Math.max(j0(this.c3.T(), a2.getRoundedCorner(0)), j0(this.c3.U(), a2.getRoundedCorner(1)));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0025, code lost:
        r0 = r3.g3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m0() {
        /*
            r3 = this;
            boolean r0 = r3.Z2
            if (r0 == 0) goto L_0x001d
            int r0 = r3.a3
            int r1 = r3.O3
            int r2 = r3.N3
            int r2 = r2 * 9
            int r2 = r2 / 16
            int r1 = r1 - r2
            int r0 = java.lang.Math.max(r0, r1)
            int r1 = r3.M3
            int r0 = java.lang.Math.min(r0, r1)
            int r1 = r3.p3
            int r0 = r0 + r1
            return r0
        L_0x001d:
            boolean r0 = r3.h3
            if (r0 != 0) goto L_0x0033
            boolean r0 = r3.i3
            if (r0 != 0) goto L_0x0033
            int r0 = r3.g3
            if (r0 <= 0) goto L_0x0033
            int r1 = r3.Y2
            int r2 = r3.b3
            int r0 = r0 + r2
            int r0 = java.lang.Math.max(r1, r0)
            return r0
        L_0x0033:
            int r0 = r3.Y2
            int r1 = r3.p3
            int r0 = r0 + r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.m0():int");
    }

    private float o0(int i2) {
        float f2;
        float f5;
        int i5 = this.A3;
        if (i2 > i5 || i5 == A0()) {
            int i6 = this.A3;
            f2 = (float) (i6 - i2);
            f5 = (float) (this.O3 - i6);
        } else {
            int i7 = this.A3;
            f2 = (float) (i7 - i2);
            f5 = (float) (i7 - A0());
        }
        return f2 / f5;
    }

    /* access modifiers changed from: private */
    public boolean p0() {
        return T0() && U0();
    }

    private void q0(View view, int i2) {
        if (view != null) {
            ViewCompat.x1(view, 524288);
            ViewCompat.x1(view, 262144);
            ViewCompat.x1(view, 1048576);
            int i5 = this.Z3.get(i2, -1);
            if (i5 != -1) {
                ViewCompat.x1(view, i5);
                this.Z3.delete(i2);
            }
        }
    }

    private AccessibilityViewCommand r0(final int i2) {
        return new AccessibilityViewCommand() {
            public boolean a(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
                BottomSheetBehavior.this.b(i2);
                return true;
            }
        };
    }

    private void s0(@NonNull Context context) {
        if (this.s3 != null) {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.s3);
            this.c3 = materialShapeDrawable;
            materialShapeDrawable.a0(context);
            ColorStateList colorStateList = this.d3;
            if (colorStateList != null) {
                this.c3.p0(colorStateList);
                return;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(16842801, typedValue, true);
            this.c3.setTint(typedValue.data);
        }
    }

    private void t0() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{l0(), 1.0f});
        this.v3 = ofFloat;
        ofFloat.setDuration(500);
        this.v3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (BottomSheetBehavior.this.c3 != null) {
                    BottomSheetBehavior.this.c3.q0(floatValue);
                }
            }
        });
    }

    @NonNull
    public static <V extends View> BottomSheetBehavior<V> x0(@NonNull V v) {
        ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior f2 = ((CoordinatorLayout.LayoutParams) layoutParams).f();
            if (f2 instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) f2;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    private void x1(@NonNull View view) {
        final boolean z = Build.VERSION.SDK_INT >= 29 && !S0() && !this.Z2;
        if (this.i3 || this.j3 || this.k3 || this.m3 || this.n3 || this.o3 || z) {
            ViewUtils.h(view, new ViewUtils.OnApplyWindowInsetsListener() {
                public WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat, ViewUtils.RelativePadding relativePadding) {
                    boolean z;
                    int i2;
                    int i3;
                    int i4;
                    Insets f2 = windowInsetsCompat.f(WindowInsetsCompat.Type.i());
                    Insets f3 = windowInsetsCompat.f(WindowInsetsCompat.Type.f());
                    int unused = BottomSheetBehavior.this.q3 = f2.f5825b;
                    boolean s = ViewUtils.s(view);
                    int paddingBottom = view.getPaddingBottom();
                    int paddingLeft = view.getPaddingLeft();
                    int paddingRight = view.getPaddingRight();
                    if (BottomSheetBehavior.this.i3) {
                        int unused2 = BottomSheetBehavior.this.p3 = windowInsetsCompat.o();
                        paddingBottom = relativePadding.f21592d + BottomSheetBehavior.this.p3;
                    }
                    if (BottomSheetBehavior.this.j3) {
                        paddingLeft = (s ? relativePadding.f21591c : relativePadding.f21589a) + f2.f5824a;
                    }
                    if (BottomSheetBehavior.this.k3) {
                        paddingRight = (s ? relativePadding.f21589a : relativePadding.f21591c) + f2.f5826c;
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                    boolean z2 = true;
                    if (!BottomSheetBehavior.this.m3 || marginLayoutParams.leftMargin == (i4 = f2.f5824a)) {
                        z = false;
                    } else {
                        marginLayoutParams.leftMargin = i4;
                        z = true;
                    }
                    if (BottomSheetBehavior.this.n3 && marginLayoutParams.rightMargin != (i3 = f2.f5826c)) {
                        marginLayoutParams.rightMargin = i3;
                        z = true;
                    }
                    if (!BottomSheetBehavior.this.o3 || marginLayoutParams.topMargin == (i2 = f2.f5825b)) {
                        z2 = z;
                    } else {
                        marginLayoutParams.topMargin = i2;
                    }
                    if (z2) {
                        view.setLayoutParams(marginLayoutParams);
                    }
                    view.setPadding(paddingLeft, view.getPaddingTop(), paddingRight, paddingBottom);
                    if (z) {
                        int unused3 = BottomSheetBehavior.this.g3 = f3.f5827d;
                    }
                    if (BottomSheetBehavior.this.i3 || z) {
                        BottomSheetBehavior.this.I1(false);
                    }
                    return windowInsetsCompat;
                }
            });
        }
    }

    private int z0(int i2, int i5, int i6, int i7) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, i5, i7);
        if (i6 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i6), 1073741824);
        }
        if (size != 0) {
            i6 = Math.min(size, i6);
        }
        return View.MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE);
    }

    private boolean z1() {
        return this.H3 != null && (this.E3 || this.F3 == 1);
    }

    public int A0() {
        if (this.X) {
            return this.x3;
        }
        return Math.max(this.w3, this.l3 ? 0 : this.q3);
    }

    /* access modifiers changed from: package-private */
    public boolean A1(@NonNull View view, float f2) {
        if (this.D3) {
            return true;
        }
        if (!U0() || view.getTop() < this.A3) {
            return false;
        }
        return Math.abs((((float) view.getTop()) + (f2 * this.L3)) - ((float) this.A3)) / ((float) m0()) > 0.5f;
    }

    public void B(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, int i2, int i5, int i6, int i7, int i8, @NonNull int[] iArr) {
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float B0() {
        return this.z3;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean B1() {
        return false;
    }

    public float C0() {
        return this.L3;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean C1() {
        return true;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int D0() {
        return this.G3;
    }

    /* access modifiers changed from: package-private */
    public MaterialShapeDrawable E0() {
        return this.c3;
    }

    public void F(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.F(coordinatorLayout, v, savedState.a());
        b1(savedState);
        int i2 = savedState.Y;
        if (i2 == 1 || i2 == 2) {
            i2 = 4;
        }
        this.F3 = i2;
        this.G3 = i2;
    }

    @Px
    public int F0() {
        return this.f3;
    }

    @NonNull
    public Parcelable G(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v) {
        return new SavedState(super.G(coordinatorLayout, v), (BottomSheetBehavior<?>) this);
    }

    @Px
    public int G0() {
        return this.e3;
    }

    public int H0() {
        if (this.Z2) {
            return -1;
        }
        return this.Y2;
    }

    public boolean I(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, @NonNull View view2, int i2, int i5) {
        this.J3 = 0;
        this.K3 = false;
        return (i2 & 2) != 0;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public int I0() {
        return this.a3;
    }

    public int J0() {
        return this.s;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0035, code lost:
        if (r4.getTop() <= r2.y3) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0065, code lost:
        if (java.lang.Math.abs(r3 - r2.x3) < java.lang.Math.abs(r3 - r2.A3)) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x007b, code lost:
        if (B1() != false) goto L_0x0092;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x008b, code lost:
        if (java.lang.Math.abs(r3 - r1) < java.lang.Math.abs(r3 - r2.A3)) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a7, code lost:
        if (java.lang.Math.abs(r3 - r2.y3) < java.lang.Math.abs(r3 - r2.A3)) goto L_0x00a9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void K(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout r3, @androidx.annotation.NonNull V r4, @androidx.annotation.NonNull android.view.View r5, int r6) {
        /*
            r2 = this;
            int r3 = r4.getTop()
            int r6 = r2.A0()
            r0 = 3
            if (r3 != r6) goto L_0x000f
            r2.v1(r0)
            return
        L_0x000f:
            boolean r3 = r2.W0()
            if (r3 == 0) goto L_0x0024
            java.lang.ref.WeakReference<android.view.View> r3 = r2.R3
            if (r3 == 0) goto L_0x0023
            java.lang.Object r3 = r3.get()
            if (r5 != r3) goto L_0x0023
            boolean r3 = r2.K3
            if (r3 != 0) goto L_0x0024
        L_0x0023:
            return
        L_0x0024:
            int r3 = r2.J3
            r5 = 6
            if (r3 <= 0) goto L_0x0039
            boolean r3 = r2.X
            if (r3 == 0) goto L_0x002f
            goto L_0x00aa
        L_0x002f:
            int r3 = r4.getTop()
            int r6 = r2.y3
            if (r3 <= r6) goto L_0x00aa
            goto L_0x00a9
        L_0x0039:
            boolean r3 = r2.C3
            if (r3 == 0) goto L_0x0049
            float r3 = r2.N0()
            boolean r3 = r2.A1(r4, r3)
            if (r3 == 0) goto L_0x0049
            r0 = 5
            goto L_0x00aa
        L_0x0049:
            int r3 = r2.J3
            r6 = 4
            if (r3 != 0) goto L_0x008e
            int r3 = r4.getTop()
            boolean r1 = r2.X
            if (r1 == 0) goto L_0x0068
            int r5 = r2.x3
            int r5 = r3 - r5
            int r5 = java.lang.Math.abs(r5)
            int r1 = r2.A3
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r5 >= r3) goto L_0x0092
            goto L_0x00aa
        L_0x0068:
            int r1 = r2.y3
            if (r3 >= r1) goto L_0x007e
            int r1 = r2.A3
            int r1 = r3 - r1
            int r1 = java.lang.Math.abs(r1)
            if (r3 >= r1) goto L_0x0077
            goto L_0x00aa
        L_0x0077:
            boolean r3 = r2.B1()
            if (r3 == 0) goto L_0x00a9
            goto L_0x0092
        L_0x007e:
            int r0 = r3 - r1
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.A3
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L_0x0092
            goto L_0x00a9
        L_0x008e:
            boolean r3 = r2.X
            if (r3 == 0) goto L_0x0094
        L_0x0092:
            r0 = 4
            goto L_0x00aa
        L_0x0094:
            int r3 = r4.getTop()
            int r0 = r2.y3
            int r0 = r3 - r0
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.A3
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L_0x0092
        L_0x00a9:
            r0 = 6
        L_0x00aa:
            r3 = 0
            r2.D1(r4, r0, r3)
            r2.K3 = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.K(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int):void");
    }

    public int K0() {
        return this.X2;
    }

    public boolean L(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.F3 == 1 && actionMasked == 0) {
            return true;
        }
        if (z1()) {
            this.H3.M(motionEvent);
        }
        if (actionMasked == 0) {
            a1();
        }
        if (this.T3 == null) {
            this.T3 = VelocityTracker.obtain();
        }
        this.T3.addMovement(motionEvent);
        if (z1() && actionMasked == 2 && !this.I3 && Math.abs(((float) this.W3) - motionEvent.getY()) > ((float) this.H3.E())) {
            this.H3.d(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.I3;
    }

    public boolean L0() {
        return this.D3;
    }

    public boolean P0() {
        return this.E3;
    }

    public boolean R0() {
        return this.X;
    }

    public boolean S0() {
        return this.h3;
    }

    public boolean T0() {
        return this.C3;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean U0() {
        return true;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean W0() {
        return true;
    }

    public boolean X0() {
        return this.r3;
    }

    public void Y0(@NonNull BottomSheetCallback bottomSheetCallback) {
        this.S3.remove(bottomSheetCallback);
    }

    public void b(int i2) {
        if (i2 == 1 || i2 == 2) {
            StringBuilder sb = new StringBuilder();
            sb.append("STATE_");
            sb.append(i2 == 1 ? "DRAGGING" : "SETTLING");
            sb.append(" should not be set externally.");
            throw new IllegalArgumentException(sb.toString());
        } else if (this.C3 || i2 != 5) {
            final int i5 = (i2 != 6 || !this.X || M0(i2) > this.x3) ? i2 : 3;
            WeakReference<V> weakReference = this.P3;
            if (weakReference == null || weakReference.get() == null) {
                v1(i2);
                return;
            }
            final View view = (View) this.P3.get();
            c1(view, new Runnable() {
                public void run() {
                    BottomSheetBehavior.this.D1(view, i5, false);
                }
            });
        } else {
            Log.w(o4, "Cannot set state: " + i2);
        }
    }

    public void c(@NonNull BackEventCompat backEventCompat) {
        MaterialBottomContainerBackHelper materialBottomContainerBackHelper = this.U3;
        if (materialBottomContainerBackHelper != null) {
            materialBottomContainerBackHelper.j(backEventCompat);
        }
    }

    public void d(@NonNull BackEventCompat backEventCompat) {
        MaterialBottomContainerBackHelper materialBottomContainerBackHelper = this.U3;
        if (materialBottomContainerBackHelper != null) {
            materialBottomContainerBackHelper.l(backEventCompat);
        }
    }

    /* access modifiers changed from: package-private */
    public void d1(@Nullable View view) {
        WeakReference<View> weakReference;
        if (view != null || (weakReference = this.Q3) == null) {
            this.Q3 = new WeakReference<>(view);
            F1(view, 1);
            return;
        }
        q0(weakReference.get(), 1);
        this.Q3 = null;
    }

    public void e() {
        MaterialBottomContainerBackHelper materialBottomContainerBackHelper = this.U3;
        if (materialBottomContainerBackHelper != null) {
            BackEventCompat c2 = materialBottomContainerBackHelper.c();
            int i2 = 4;
            if (c2 == null || Build.VERSION.SDK_INT < 34) {
                if (this.C3) {
                    i2 = 5;
                }
                b(i2);
            } else if (this.C3) {
                this.U3.h(c2, new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        BottomSheetBehavior.this.v1(5);
                        WeakReference<V> weakReference = BottomSheetBehavior.this.P3;
                        if (weakReference != null && weakReference.get() != null) {
                            ((View) BottomSheetBehavior.this.P3.get()).requestLayout();
                        }
                    }
                });
            } else {
                this.U3.i(c2, (Animator.AnimatorListener) null);
                b(4);
            }
        }
    }

    @Deprecated
    public void e1(BottomSheetCallback bottomSheetCallback) {
        Log.w(o4, "BottomSheetBehavior now supports multiple callbacks. `setBottomSheetCallback()` removes all existing callbacks, including ones set internally by library authors, which may result in unintended behavior. This may change in the future. Please use `addBottomSheetCallback()` and `removeBottomSheetCallback()` instead to set your own callbacks.");
        this.S3.clear();
        if (bottomSheetCallback != null) {
            this.S3.add(bottomSheetCallback);
        }
    }

    public void f1(boolean z) {
        this.E3 = z;
    }

    public void g() {
        MaterialBottomContainerBackHelper materialBottomContainerBackHelper = this.U3;
        if (materialBottomContainerBackHelper != null) {
            materialBottomContainerBackHelper.f();
        }
    }

    public void g1(int i2) {
        if (i2 >= 0) {
            this.w3 = i2;
            G1(this.F3, true);
            return;
        }
        throw new IllegalArgumentException("offset must be greater than or equal to 0");
    }

    public int getState() {
        return this.F3;
    }

    public void h0(@NonNull BottomSheetCallback bottomSheetCallback) {
        if (!this.S3.contains(bottomSheetCallback)) {
            this.S3.add(bottomSheetCallback);
        }
    }

    public void h1(boolean z) {
        if (this.X != z) {
            this.X = z;
            if (this.P3 != null) {
                i0();
            }
            v1((!this.X || this.F3 != 6) ? this.F3 : 3);
            G1(this.F3, true);
            E1();
        }
    }

    public void i1(boolean z) {
        this.h3 = z;
    }

    public void j1(@FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d, toInclusive = false) float f2) {
        if (f2 <= 0.0f || f2 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.z3 = f2;
        if (this.P3 != null) {
            k0();
        }
    }

    public void k1(float f2) {
        this.L3 = f2;
    }

    public void l1(boolean z) {
        if (this.C3 != z) {
            this.C3 = z;
            if (!z && this.F3 == 5) {
                b(4);
            }
            E1();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void m1(boolean z) {
        this.C3 = z;
    }

    public float n0() {
        WeakReference<V> weakReference = this.P3;
        if (weakReference == null || weakReference.get() == null) {
            return -1.0f;
        }
        return o0(((View) this.P3.get()).getTop());
    }

    public void n1(@Px int i2) {
        this.f3 = i2;
    }

    public void o(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.o(layoutParams);
        this.P3 = null;
        this.H3 = null;
        this.U3 = null;
    }

    public void o1(@Px int i2) {
        this.e3 = i2;
    }

    public void p1(int i2) {
        q1(i2, false);
    }

    public final void q1(int i2, boolean z) {
        if (i2 == -1) {
            if (!this.Z2) {
                this.Z2 = true;
            } else {
                return;
            }
        } else if (this.Z2 || this.Y2 != i2) {
            this.Z2 = false;
            this.Y2 = Math.max(0, i2);
        } else {
            return;
        }
        I1(z);
    }

    public void r() {
        super.r();
        this.P3 = null;
        this.H3 = null;
        this.U3 = null;
    }

    public void r1(int i2) {
        this.s = i2;
    }

    public boolean s(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull MotionEvent motionEvent) {
        int i2;
        ViewDragHelper viewDragHelper;
        if (!v.isShown() || !this.E3) {
            this.I3 = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            a1();
        }
        if (this.T3 == null) {
            this.T3 = VelocityTracker.obtain();
        }
        this.T3.addMovement(motionEvent);
        View view = null;
        if (actionMasked == 0) {
            int x = (int) motionEvent.getX();
            this.W3 = (int) motionEvent.getY();
            if (this.F3 != 2) {
                WeakReference<View> weakReference = this.R3;
                View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && coordinatorLayout.G(view2, x, this.W3)) {
                    this.V3 = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.X3 = true;
                }
            }
            this.I3 = this.V3 == -1 && !coordinatorLayout.G(v, x, this.W3);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.X3 = false;
            this.V3 = -1;
            if (this.I3) {
                this.I3 = false;
                return false;
            }
        }
        if (!this.I3 && (viewDragHelper = this.H3) != null && viewDragHelper.W(motionEvent)) {
            return true;
        }
        WeakReference<View> weakReference2 = this.R3;
        if (weakReference2 != null) {
            view = weakReference2.get();
        }
        return actionMasked == 2 && view != null && !this.I3 && this.F3 != 1 && !coordinatorLayout.G(view, (int) motionEvent.getX(), (int) motionEvent.getY()) && this.H3 != null && (i2 = this.W3) != -1 && Math.abs(((float) i2) - motionEvent.getY()) > ((float) this.H3.E());
    }

    public void s1(boolean z) {
        if (this.r3 != z) {
            this.r3 = z;
            G1(getState(), true);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0099, code lost:
        if (r5 == -1) goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a6, code lost:
        if (r5 == -1) goto L_0x00a0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0103 A[LOOP:0: B:52:0x00fb->B:54:0x0103, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean t(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout r5, @androidx.annotation.NonNull V r6, int r7) {
        /*
            r4 = this;
            boolean r0 = androidx.core.view.ViewCompat.W(r5)
            r1 = 1
            if (r0 == 0) goto L_0x0010
            boolean r0 = androidx.core.view.ViewCompat.W(r6)
            if (r0 != 0) goto L_0x0010
            r6.setFitsSystemWindows(r1)
        L_0x0010:
            java.lang.ref.WeakReference<V> r0 = r4.P3
            if (r0 != 0) goto L_0x0065
            android.content.res.Resources r0 = r5.getResources()
            int r2 = com.google.android.material.R.dimen.f1
            int r0 = r0.getDimensionPixelSize(r2)
            r4.a3 = r0
            r4.x1(r6)
            com.google.android.material.bottomsheet.InsetsAnimationCallback r0 = new com.google.android.material.bottomsheet.InsetsAnimationCallback
            r0.<init>(r6)
            androidx.core.view.ViewCompat.H2(r6, r0)
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference
            r0.<init>(r6)
            r4.P3 = r0
            com.google.android.material.motion.MaterialBottomContainerBackHelper r0 = new com.google.android.material.motion.MaterialBottomContainerBackHelper
            r0.<init>(r6)
            r4.U3 = r0
            com.google.android.material.shape.MaterialShapeDrawable r0 = r4.c3
            if (r0 == 0) goto L_0x0052
            androidx.core.view.ViewCompat.P1(r6, r0)
            com.google.android.material.shape.MaterialShapeDrawable r0 = r4.c3
            float r2 = r4.B3
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 != 0) goto L_0x004e
            float r2 = androidx.core.view.ViewCompat.T(r6)
        L_0x004e:
            r0.o0(r2)
            goto L_0x0059
        L_0x0052:
            android.content.res.ColorStateList r0 = r4.d3
            if (r0 == 0) goto L_0x0059
            androidx.core.view.ViewCompat.Q1(r6, r0)
        L_0x0059:
            r4.E1()
            int r0 = androidx.core.view.ViewCompat.X(r6)
            if (r0 != 0) goto L_0x0065
            androidx.core.view.ViewCompat.Z1(r6, r1)
        L_0x0065:
            androidx.customview.widget.ViewDragHelper r0 = r4.H3
            if (r0 != 0) goto L_0x0071
            androidx.customview.widget.ViewDragHelper$Callback r0 = r4.a4
            androidx.customview.widget.ViewDragHelper r0 = androidx.customview.widget.ViewDragHelper.q(r5, r0)
            r4.H3 = r0
        L_0x0071:
            int r0 = r6.getTop()
            r5.N(r6, r7)
            int r7 = r5.getWidth()
            r4.N3 = r7
            int r5 = r5.getHeight()
            r4.O3 = r5
            int r5 = r6.getHeight()
            r4.M3 = r5
            int r7 = r4.O3
            int r5 = r7 - r5
            int r2 = r4.q3
            if (r5 >= r2) goto L_0x00a9
            boolean r5 = r4.l3
            r3 = -1
            if (r5 == 0) goto L_0x00a3
            int r5 = r4.f3
            if (r5 != r3) goto L_0x009c
            goto L_0x00a0
        L_0x009c:
            int r7 = java.lang.Math.min(r7, r5)
        L_0x00a0:
            r4.M3 = r7
            goto L_0x00a9
        L_0x00a3:
            int r7 = r7 - r2
            int r5 = r4.f3
            if (r5 != r3) goto L_0x009c
            goto L_0x00a0
        L_0x00a9:
            int r5 = r4.O3
            int r7 = r4.M3
            int r5 = r5 - r7
            r7 = 0
            int r5 = java.lang.Math.max(r7, r5)
            r4.x3 = r5
            r4.k0()
            r4.i0()
            int r5 = r4.F3
            r2 = 3
            if (r5 != r2) goto L_0x00c8
            int r5 = r4.A0()
        L_0x00c4:
            androidx.core.view.ViewCompat.j1(r6, r5)
            goto L_0x00eb
        L_0x00c8:
            r2 = 6
            if (r5 != r2) goto L_0x00ce
            int r5 = r4.y3
            goto L_0x00c4
        L_0x00ce:
            boolean r2 = r4.C3
            if (r2 == 0) goto L_0x00d8
            r2 = 5
            if (r5 != r2) goto L_0x00d8
            int r5 = r4.O3
            goto L_0x00c4
        L_0x00d8:
            r2 = 4
            if (r5 != r2) goto L_0x00de
            int r5 = r4.A3
            goto L_0x00c4
        L_0x00de:
            if (r5 == r1) goto L_0x00e3
            r2 = 2
            if (r5 != r2) goto L_0x00eb
        L_0x00e3:
            int r5 = r6.getTop()
            int r0 = r0 - r5
            androidx.core.view.ViewCompat.j1(r6, r0)
        L_0x00eb:
            int r5 = r4.F3
            r4.G1(r5, r7)
            java.lang.ref.WeakReference r5 = new java.lang.ref.WeakReference
            android.view.View r0 = r4.w0(r6)
            r5.<init>(r0)
            r4.R3 = r5
        L_0x00fb:
            java.util.ArrayList<com.google.android.material.bottomsheet.BottomSheetBehavior$BottomSheetCallback> r5 = r4.S3
            int r5 = r5.size()
            if (r7 >= r5) goto L_0x0111
            java.util.ArrayList<com.google.android.material.bottomsheet.BottomSheetBehavior$BottomSheetCallback> r5 = r4.S3
            java.lang.Object r5 = r5.get(r7)
            com.google.android.material.bottomsheet.BottomSheetBehavior$BottomSheetCallback r5 = (com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback) r5
            r5.a(r6)
            int r7 = r7 + 1
            goto L_0x00fb
        L_0x0111:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.t(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, int):boolean");
    }

    public void t1(int i2) {
        this.X2 = i2;
    }

    public boolean u(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i2, int i5, int i6, int i7) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
        v.measure(z0(i2, coordinatorLayout.getPaddingLeft() + coordinatorLayout.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i5, this.e3, marginLayoutParams.width), z0(i6, coordinatorLayout.getPaddingTop() + coordinatorLayout.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i7, this.f3, marginLayoutParams.height));
        return true;
    }

    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void u0() {
        this.v3 = null;
    }

    public void u1(boolean z) {
        this.D3 = z;
    }

    /* access modifiers changed from: package-private */
    public void v0(int i2) {
        View view = (View) this.P3.get();
        if (view != null && !this.S3.isEmpty()) {
            float o0 = o0(i2);
            for (int i5 = 0; i5 < this.S3.size(); i5++) {
                this.S3.get(i5).b(view, o0);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void v1(int i2) {
        View view;
        if (this.F3 != i2) {
            this.F3 = i2;
            if (i2 == 4 || i2 == 3 || i2 == 6 || (this.C3 && i2 == 5)) {
                this.G3 = i2;
            }
            WeakReference<V> weakReference = this.P3;
            if (weakReference != null && (view = (View) weakReference.get()) != null) {
                if (i2 == 3) {
                    H1(true);
                } else if (i2 == 6 || i2 == 5 || i2 == 4) {
                    H1(false);
                }
                G1(i2, true);
                for (int i5 = 0; i5 < this.S3.size(); i5++) {
                    this.S3.get(i5).c(view, i2);
                }
                E1();
            }
        }
    }

    public boolean w(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, float f2, float f5) {
        WeakReference<View> weakReference;
        if (!W0() || (weakReference = this.R3) == null || view != weakReference.get()) {
            return false;
        }
        return this.F3 != 3 || super.w(coordinatorLayout, v, view, f2, f5);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    @Nullable
    public View w0(View view) {
        if (view.getVisibility() != 0) {
            return null;
        }
        if (ViewCompat.a1(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View w0 = w0(viewGroup.getChildAt(i2));
                if (w0 != null) {
                    return w0;
                }
            }
        }
        return null;
    }

    public void w1(boolean z) {
        this.Y = z;
    }

    public void y(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, int i2, int i5, @NonNull int[] iArr, int i6) {
        int i7;
        if (i6 != 1) {
            WeakReference<View> weakReference = this.R3;
            View view2 = weakReference != null ? weakReference.get() : null;
            if (!W0() || view == view2) {
                int top = v.getTop();
                int i8 = top - i5;
                if (i5 <= 0) {
                    if (i5 < 0 && !view.canScrollVertically(-1)) {
                        if (i8 > this.A3 && !p0()) {
                            int i9 = top - this.A3;
                            iArr[1] = i9;
                            ViewCompat.j1(v, -i9);
                            i7 = 4;
                        } else if (this.E3) {
                            iArr[1] = i5;
                            ViewCompat.j1(v, -i5);
                            v1(1);
                        } else {
                            return;
                        }
                    }
                    v0(v.getTop());
                    this.J3 = i5;
                    this.K3 = true;
                } else if (i8 < A0()) {
                    int A0 = top - A0();
                    iArr[1] = A0;
                    ViewCompat.j1(v, -A0);
                    i7 = 3;
                } else if (this.E3) {
                    iArr[1] = i5;
                    ViewCompat.j1(v, -i5);
                    v1(1);
                    v0(v.getTop());
                    this.J3 = i5;
                    this.K3 = true;
                } else {
                    return;
                }
                v1(i7);
                v0(v.getTop());
                this.J3 = i5;
                this.K3 = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    @Nullable
    public MaterialBottomContainerBackHelper y0() {
        return this.U3;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean y1(long j2, @FloatRange(from = 0.0d, to = 100.0d) float f2) {
        return false;
    }

    public BottomSheetBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        int i2;
        this.b3 = context.getResources().getDimensionPixelSize(R.dimen.Ec);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.j5);
        int i5 = R.styleable.n5;
        if (obtainStyledAttributes.hasValue(i5)) {
            this.d3 = MaterialResources.a(context, obtainStyledAttributes, i5);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.F5)) {
            this.s3 = ShapeAppearanceModel.e(context, attributeSet, R.attr.n1, x4).m();
        }
        s0(context);
        t0();
        this.B3 = obtainStyledAttributes.getDimension(R.styleable.m5, -1.0f);
        int i6 = R.styleable.k5;
        if (obtainStyledAttributes.hasValue(i6)) {
            o1(obtainStyledAttributes.getDimensionPixelSize(i6, -1));
        }
        int i7 = R.styleable.l5;
        if (obtainStyledAttributes.hasValue(i7)) {
            n1(obtainStyledAttributes.getDimensionPixelSize(i7, -1));
        }
        int i8 = R.styleable.t5;
        TypedValue peekValue = obtainStyledAttributes.peekValue(i8);
        if (peekValue == null || (i2 = peekValue.data) != -1) {
            p1(obtainStyledAttributes.getDimensionPixelSize(i8, -1));
        } else {
            p1(i2);
        }
        l1(obtainStyledAttributes.getBoolean(R.styleable.s5, false));
        i1(obtainStyledAttributes.getBoolean(R.styleable.x5, false));
        h1(obtainStyledAttributes.getBoolean(R.styleable.q5, true));
        u1(obtainStyledAttributes.getBoolean(R.styleable.w5, false));
        f1(obtainStyledAttributes.getBoolean(R.styleable.o5, true));
        r1(obtainStyledAttributes.getInt(R.styleable.u5, 0));
        j1(obtainStyledAttributes.getFloat(R.styleable.r5, 0.5f));
        int i9 = R.styleable.p5;
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(i9);
        g1((peekValue2 == null || peekValue2.type != 16) ? obtainStyledAttributes.getDimensionPixelOffset(i9, 0) : peekValue2.data);
        t1(obtainStyledAttributes.getInt(R.styleable.v5, 500));
        this.i3 = obtainStyledAttributes.getBoolean(R.styleable.B5, false);
        this.j3 = obtainStyledAttributes.getBoolean(R.styleable.C5, false);
        this.k3 = obtainStyledAttributes.getBoolean(R.styleable.D5, false);
        this.l3 = obtainStyledAttributes.getBoolean(R.styleable.E5, true);
        this.m3 = obtainStyledAttributes.getBoolean(R.styleable.y5, false);
        this.n3 = obtainStyledAttributes.getBoolean(R.styleable.z5, false);
        this.o3 = obtainStyledAttributes.getBoolean(R.styleable.A5, false);
        this.r3 = obtainStyledAttributes.getBoolean(R.styleable.H5, true);
        obtainStyledAttributes.recycle();
        this.Z = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
