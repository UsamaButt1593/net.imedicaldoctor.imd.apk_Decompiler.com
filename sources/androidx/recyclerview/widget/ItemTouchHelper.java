package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.ViewCompat;

import java.util.ArrayList;
import java.util.List;

public class ItemTouchHelper extends RecyclerView.ItemDecoration implements RecyclerView.OnChildAttachStateChangeListener {
    public static final int E = 1;
    public static final int F = 2;
    public static final int G = 4;
    public static final int H = 8;
    public static final int I = 16;
    public static final int J = 32;
    public static final int K = 0;
    public static final int L = 1;
    public static final int M = 2;
    public static final int N = 2;
    public static final int O = 4;
    public static final int P = 8;
    private static final String Q = "ItemTouchHelper";
    private static final boolean R = false;
    private static final int S = -1;
    static final int T = 8;
    private static final int U = 255;
    static final int V = 65280;
    static final int W = 16711680;
    private static final int X = 1000;
    private ItemTouchHelperGestureListener A;
    private final RecyclerView.OnItemTouchListener B = new RecyclerView.OnItemTouchListener() {
        public void a(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            ItemTouchHelper.this.z.b(motionEvent);
            VelocityTracker velocityTracker = ItemTouchHelper.this.t;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            if (ItemTouchHelper.this.f15374l != -1) {
                int actionMasked = motionEvent.getActionMasked();
                int findPointerIndex = motionEvent.findPointerIndex(ItemTouchHelper.this.f15374l);
                if (findPointerIndex >= 0) {
                    ItemTouchHelper.this.o(actionMasked, motionEvent, findPointerIndex);
                }
                ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                RecyclerView.ViewHolder viewHolder = itemTouchHelper.f15365c;
                if (viewHolder != null) {
                    int i2 = 0;
                    if (actionMasked != 1) {
                        if (actionMasked != 2) {
                            if (actionMasked == 3) {
                                VelocityTracker velocityTracker2 = itemTouchHelper.t;
                                if (velocityTracker2 != null) {
                                    velocityTracker2.clear();
                                }
                            } else if (actionMasked == 6) {
                                int actionIndex = motionEvent.getActionIndex();
                                int pointerId = motionEvent.getPointerId(actionIndex);
                                ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                                if (pointerId == itemTouchHelper2.f15374l) {
                                    if (actionIndex == 0) {
                                        i2 = 1;
                                    }
                                    itemTouchHelper2.f15374l = motionEvent.getPointerId(i2);
                                    ItemTouchHelper itemTouchHelper3 = ItemTouchHelper.this;
                                    itemTouchHelper3.M(motionEvent, itemTouchHelper3.o, actionIndex);
                                    return;
                                }
                                return;
                            } else {
                                return;
                            }
                        } else if (findPointerIndex >= 0) {
                            itemTouchHelper.M(motionEvent, itemTouchHelper.o, findPointerIndex);
                            ItemTouchHelper.this.z(viewHolder);
                            ItemTouchHelper itemTouchHelper4 = ItemTouchHelper.this;
                            itemTouchHelper4.r.removeCallbacks(itemTouchHelper4.s);
                            ItemTouchHelper.this.s.run();
                            ItemTouchHelper.this.r.invalidate();
                            return;
                        } else {
                            return;
                        }
                    }
                    ItemTouchHelper.this.F((RecyclerView.ViewHolder) null, 0);
                    ItemTouchHelper.this.f15374l = -1;
                }
            }
        }

        public boolean c(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            int findPointerIndex;
            RecoverAnimation s;
            ItemTouchHelper.this.z.b(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                ItemTouchHelper.this.f15374l = motionEvent.getPointerId(0);
                ItemTouchHelper.this.f15366d = motionEvent.getX();
                ItemTouchHelper.this.f15367e = motionEvent.getY();
                ItemTouchHelper.this.A();
                ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                if (itemTouchHelper.f15365c == null && (s = itemTouchHelper.s(motionEvent)) != null) {
                    ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                    itemTouchHelper2.f15366d -= s.c3;
                    itemTouchHelper2.f15367e -= s.d3;
                    itemTouchHelper2.r(s.X2, true);
                    if (ItemTouchHelper.this.f15363a.remove(s.X2.f15587a)) {
                        ItemTouchHelper itemTouchHelper3 = ItemTouchHelper.this;
                        itemTouchHelper3.f15375m.c(itemTouchHelper3.r, s.X2);
                    }
                    ItemTouchHelper.this.F(s.X2, s.Y2);
                    ItemTouchHelper itemTouchHelper4 = ItemTouchHelper.this;
                    itemTouchHelper4.M(motionEvent, itemTouchHelper4.o, 0);
                }
            } else if (actionMasked == 3 || actionMasked == 1) {
                ItemTouchHelper itemTouchHelper5 = ItemTouchHelper.this;
                itemTouchHelper5.f15374l = -1;
                itemTouchHelper5.F((RecyclerView.ViewHolder) null, 0);
            } else {
                int i2 = ItemTouchHelper.this.f15374l;
                if (i2 != -1 && (findPointerIndex = motionEvent.findPointerIndex(i2)) >= 0) {
                    ItemTouchHelper.this.o(actionMasked, motionEvent, findPointerIndex);
                }
            }
            VelocityTracker velocityTracker = ItemTouchHelper.this.t;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            return ItemTouchHelper.this.f15365c != null;
        }

        public void e(boolean z) {
            if (z) {
                ItemTouchHelper.this.F((RecyclerView.ViewHolder) null, 0);
            }
        }
    };
    private Rect C;
    private long D;

    /* renamed from: a  reason: collision with root package name */
    final List<View> f15363a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final float[] f15364b = new float[2];

    /* renamed from: c  reason: collision with root package name */
    RecyclerView.ViewHolder f15365c = null;

    /* renamed from: d  reason: collision with root package name */
    float f15366d;

    /* renamed from: e  reason: collision with root package name */
    float f15367e;

    /* renamed from: f  reason: collision with root package name */
    private float f15368f;

    /* renamed from: g  reason: collision with root package name */
    private float f15369g;

    /* renamed from: h  reason: collision with root package name */
    float f15370h;

    /* renamed from: i  reason: collision with root package name */
    float f15371i;

    /* renamed from: j  reason: collision with root package name */
    private float f15372j;

    /* renamed from: k  reason: collision with root package name */
    private float f15373k;

    /* renamed from: l  reason: collision with root package name */
    int f15374l = -1;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    Callback f15375m;

    /* renamed from: n  reason: collision with root package name */
    private int f15376n = 0;
    int o;
    @VisibleForTesting
    List<RecoverAnimation> p = new ArrayList();
    private int q;
    RecyclerView r;
    final Runnable s = new Runnable() {
        public void run() {
            ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
            if (itemTouchHelper.f15365c != null && itemTouchHelper.E()) {
                ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                RecyclerView.ViewHolder viewHolder = itemTouchHelper2.f15365c;
                if (viewHolder != null) {
                    itemTouchHelper2.z(viewHolder);
                }
                ItemTouchHelper itemTouchHelper3 = ItemTouchHelper.this;
                itemTouchHelper3.r.removeCallbacks(itemTouchHelper3.s);
                ViewCompat.v1(ItemTouchHelper.this.r, this);
            }
        }
    };
    VelocityTracker t;
    private List<RecyclerView.ViewHolder> u;
    private List<Integer> v;
    private RecyclerView.ChildDrawingOrderCallback w = null;
    View x = null;
    int y = -1;
    GestureDetectorCompat z;

    public static abstract class Callback {

        /* renamed from: b  reason: collision with root package name */
        public static final int f15379b = 200;

        /* renamed from: c  reason: collision with root package name */
        public static final int f15380c = 250;

        /* renamed from: d  reason: collision with root package name */
        static final int f15381d = 3158064;

        /* renamed from: e  reason: collision with root package name */
        private static final int f15382e = 789516;

        /* renamed from: f  reason: collision with root package name */
        private static final Interpolator f15383f = new Interpolator() {
            public float getInterpolation(float f2) {
                return f2 * f2 * f2 * f2 * f2;
            }
        };

        /* renamed from: g  reason: collision with root package name */
        private static final Interpolator f15384g = new Interpolator() {
            public float getInterpolation(float f2) {
                float f3 = f2 - 1.0f;
                return (f3 * f3 * f3 * f3 * f3) + 1.0f;
            }
        };

        /* renamed from: h  reason: collision with root package name */
        private static final long f15385h = 2000;

        /* renamed from: a  reason: collision with root package name */
        private int f15386a = -1;

        public static int e(int i2, int i3) {
            int i4;
            int i5 = i2 & f15382e;
            if (i5 == 0) {
                return i2;
            }
            int i6 = i2 & (~i5);
            if (i3 == 0) {
                i4 = i5 << 2;
            } else {
                int i7 = i5 << 1;
                i6 |= -789517 & i7;
                i4 = (i7 & f15382e) << 2;
            }
            return i6 | i4;
        }

        @NonNull
        public static ItemTouchUIUtil i() {
            return ItemTouchUIUtilImpl.f15389a;
        }

        private int j(RecyclerView recyclerView) {
            if (this.f15386a == -1) {
                this.f15386a = recyclerView.getResources().getDimensionPixelSize(R.dimen.f15170d);
            }
            return this.f15386a;
        }

        public static int u(int i2, int i3) {
            return i3 << (i2 * 8);
        }

        public static int v(int i2, int i3) {
            int u = u(0, i3 | i2);
            return u(2, i2) | u(1, i3) | u;
        }

        public abstract boolean A(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder2);

        public void B(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, int i2, @NonNull RecyclerView.ViewHolder viewHolder2, int i3, int i4, int i5) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof ViewDropHandler) {
                ((ViewDropHandler) layoutManager).e(viewHolder.f15587a, viewHolder2.f15587a, i4, i5);
                return;
            }
            if (layoutManager.s()) {
                if (layoutManager.d0(viewHolder2.f15587a) <= recyclerView.getPaddingLeft()) {
                    recyclerView.O1(i3);
                }
                if (layoutManager.g0(viewHolder2.f15587a) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.O1(i3);
                }
            }
            if (layoutManager.t()) {
                if (layoutManager.h0(viewHolder2.f15587a) <= recyclerView.getPaddingTop()) {
                    recyclerView.O1(i3);
                }
                if (layoutManager.b0(viewHolder2.f15587a) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.O1(i3);
                }
            }
        }

        public void C(@Nullable RecyclerView.ViewHolder viewHolder, int i2) {
            if (viewHolder != null) {
                ItemTouchUIUtilImpl.f15389a.b(viewHolder.f15587a);
            }
        }

        public abstract void D(@NonNull RecyclerView.ViewHolder viewHolder, int i2);

        public boolean a(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder2) {
            return true;
        }

        @SuppressLint({"UnknownNullness"})
        public RecyclerView.ViewHolder b(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull List<RecyclerView.ViewHolder> list, int i2, int i3) {
            int bottom;
            int abs;
            int top;
            int abs2;
            int left;
            int abs3;
            int right;
            int abs4;
            RecyclerView.ViewHolder viewHolder2 = viewHolder;
            int width = i2 + viewHolder2.f15587a.getWidth();
            int height = i3 + viewHolder2.f15587a.getHeight();
            int left2 = i2 - viewHolder2.f15587a.getLeft();
            int top2 = i3 - viewHolder2.f15587a.getTop();
            int size = list.size();
            RecyclerView.ViewHolder viewHolder3 = null;
            int i4 = -1;
            for (int i5 = 0; i5 < size; i5++) {
                RecyclerView.ViewHolder viewHolder4 = list.get(i5);
                if (left2 > 0 && (right = viewHolder4.f15587a.getRight() - width) < 0 && viewHolder4.f15587a.getRight() > viewHolder2.f15587a.getRight() && (abs4 = Math.abs(right)) > i4) {
                    viewHolder3 = viewHolder4;
                    i4 = abs4;
                }
                if (left2 < 0 && (left = viewHolder4.f15587a.getLeft() - i2) > 0 && viewHolder4.f15587a.getLeft() < viewHolder2.f15587a.getLeft() && (abs3 = Math.abs(left)) > i4) {
                    viewHolder3 = viewHolder4;
                    i4 = abs3;
                }
                if (top2 < 0 && (top = viewHolder4.f15587a.getTop() - i3) > 0 && viewHolder4.f15587a.getTop() < viewHolder2.f15587a.getTop() && (abs2 = Math.abs(top)) > i4) {
                    viewHolder3 = viewHolder4;
                    i4 = abs2;
                }
                if (top2 > 0 && (bottom = viewHolder4.f15587a.getBottom() - height) < 0 && viewHolder4.f15587a.getBottom() > viewHolder2.f15587a.getBottom() && (abs = Math.abs(bottom)) > i4) {
                    viewHolder3 = viewHolder4;
                    i4 = abs;
                }
            }
            return viewHolder3;
        }

        public void c(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            ItemTouchUIUtilImpl.f15389a.a(viewHolder.f15587a);
        }

        public int d(int i2, int i3) {
            int i4;
            int i5 = i2 & f15381d;
            if (i5 == 0) {
                return i2;
            }
            int i6 = i2 & (~i5);
            if (i3 == 0) {
                i4 = i5 >> 2;
            } else {
                int i7 = i5 >> 1;
                i6 |= -3158065 & i7;
                i4 = (i7 & f15381d) >> 2;
            }
            return i6 | i4;
        }

        /* access modifiers changed from: package-private */
        public final int f(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return d(l(recyclerView, viewHolder), ViewCompat.c0(recyclerView));
        }

        public long g(@NonNull RecyclerView recyclerView, int i2, float f2, float f3) {
            RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
            return itemAnimator == null ? i2 == 8 ? 200 : 250 : i2 == 8 ? itemAnimator.o() : itemAnimator.p();
        }

        public int h() {
            return 0;
        }

        public float k(@NonNull RecyclerView.ViewHolder viewHolder) {
            return 0.5f;
        }

        public abstract int l(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder);

        public float m(float f2) {
            return f2;
        }

        public float n(@NonNull RecyclerView.ViewHolder viewHolder) {
            return 0.5f;
        }

        public float o(float f2) {
            return f2;
        }

        /* access modifiers changed from: package-private */
        public boolean p(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return (f(recyclerView, viewHolder) & ItemTouchHelper.W) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean q(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return (f(recyclerView, viewHolder) & 65280) != 0;
        }

        public int r(@NonNull RecyclerView recyclerView, int i2, int i3, int i4, long j2) {
            float f2 = 1.0f;
            int signum = (int) (((float) (((int) Math.signum((float) i3)) * j(recyclerView))) * f15384g.getInterpolation(Math.min(1.0f, (((float) Math.abs(i3)) * 1.0f) / ((float) i2))));
            if (j2 <= 2000) {
                f2 = ((float) j2) / 2000.0f;
            }
            int interpolation = (int) (((float) signum) * f15383f.getInterpolation(f2));
            if (interpolation == 0) {
                return i3 > 0 ? 1 : -1;
            }
            return interpolation;
        }

        public boolean s() {
            return true;
        }

        public boolean t() {
            return true;
        }

        public void w(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float f2, float f3, int i2, boolean z) {
            ItemTouchUIUtilImpl.f15389a.d(canvas, recyclerView, viewHolder.f15587a, f2, f3, i2, z);
        }

        public void x(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @SuppressLint({"UnknownNullness"}) RecyclerView.ViewHolder viewHolder, float f2, float f3, int i2, boolean z) {
            ItemTouchUIUtilImpl.f15389a.c(canvas, recyclerView, viewHolder.f15587a, f2, f3, i2, z);
        }

        /* access modifiers changed from: package-private */
        public void y(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, List<RecoverAnimation> list, int i2, float f2, float f3) {
            Canvas canvas2 = canvas;
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                RecoverAnimation recoverAnimation = list.get(i3);
                recoverAnimation.e();
                int save = canvas.save();
                w(canvas, recyclerView, recoverAnimation.X2, recoverAnimation.c3, recoverAnimation.d3, recoverAnimation.Y2, false);
                canvas.restoreToCount(save);
            }
            if (viewHolder != null) {
                int save2 = canvas.save();
                w(canvas, recyclerView, viewHolder, f2, f3, i2, true);
                canvas.restoreToCount(save2);
            }
        }

        /* access modifiers changed from: package-private */
        public void z(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, List<RecoverAnimation> list, int i2, float f2, float f3) {
            Canvas canvas2 = canvas;
            List<RecoverAnimation> list2 = list;
            int size = list.size();
            boolean z = false;
            for (int i3 = 0; i3 < size; i3++) {
                RecoverAnimation recoverAnimation = list2.get(i3);
                int save = canvas.save();
                x(canvas, recyclerView, recoverAnimation.X2, recoverAnimation.c3, recoverAnimation.d3, recoverAnimation.Y2, false);
                canvas.restoreToCount(save);
            }
            if (viewHolder != null) {
                int save2 = canvas.save();
                x(canvas, recyclerView, viewHolder, f2, f3, i2, true);
                canvas.restoreToCount(save2);
            }
            for (int i4 = size - 1; i4 >= 0; i4--) {
                RecoverAnimation recoverAnimation2 = list2.get(i4);
                boolean z2 = recoverAnimation2.f3;
                if (z2 && !recoverAnimation2.b3) {
                    list2.remove(i4);
                } else if (!z2) {
                    z = true;
                }
            }
            if (z) {
                recyclerView.invalidate();
            }
        }
    }

    private class ItemTouchHelperGestureListener extends GestureDetector.SimpleOnGestureListener {
        private boolean s = true;

        ItemTouchHelperGestureListener() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.s = false;
        }

        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public void onLongPress(MotionEvent motionEvent) {
            View t;
            RecyclerView.ViewHolder y0;
            int i2;
            if (this.s && (t = ItemTouchHelper.this.t(motionEvent)) != null && (y0 = ItemTouchHelper.this.r.y0(t)) != null) {
                ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                if (itemTouchHelper.f15375m.p(itemTouchHelper.r, y0) && motionEvent.getPointerId(0) == (i2 = ItemTouchHelper.this.f15374l)) {
                    int findPointerIndex = motionEvent.findPointerIndex(i2);
                    float x = motionEvent.getX(findPointerIndex);
                    float y = motionEvent.getY(findPointerIndex);
                    ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                    itemTouchHelper2.f15366d = x;
                    itemTouchHelper2.f15367e = y;
                    itemTouchHelper2.f15371i = 0.0f;
                    itemTouchHelper2.f15370h = 0.0f;
                    if (itemTouchHelper2.f15375m.t()) {
                        ItemTouchHelper.this.F(y0, 2);
                    }
                }
            }
        }
    }

    @VisibleForTesting
    static class RecoverAnimation implements Animator.AnimatorListener {
        final float X;
        final RecyclerView.ViewHolder X2;
        final float Y;
        final int Y2;
        final float Z;
        @VisibleForTesting
        final ValueAnimator Z2;
        final int a3;
        boolean b3;
        float c3;
        float d3;
        boolean e3 = false;
        boolean f3 = false;
        private float g3;
        final float s;

        RecoverAnimation(RecyclerView.ViewHolder viewHolder, int i2, int i3, float f2, float f4, float f5, float f6) {
            this.Y2 = i3;
            this.a3 = i2;
            this.X2 = viewHolder;
            this.s = f2;
            this.X = f4;
            this.Y = f5;
            this.Z = f6;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.Z2 = ofFloat;
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    RecoverAnimation.this.c(valueAnimator.getAnimatedFraction());
                }
            });
            ofFloat.setTarget(viewHolder.f15587a);
            ofFloat.addListener(this);
            c(0.0f);
        }

        public void a() {
            this.Z2.cancel();
        }

        public void b(long j2) {
            this.Z2.setDuration(j2);
        }

        public void c(float f2) {
            this.g3 = f2;
        }

        public void d() {
            this.X2.b0(false);
            this.Z2.start();
        }

        public void e() {
            float f2 = this.s;
            float f4 = this.Y;
            this.c3 = f2 == f4 ? this.X2.f15587a.getTranslationX() : f2 + (this.g3 * (f4 - f2));
            float f5 = this.X;
            float f6 = this.Z;
            this.d3 = f5 == f6 ? this.X2.f15587a.getTranslationY() : f5 + (this.g3 * (f6 - f5));
        }

        public void onAnimationCancel(Animator animator) {
            c(1.0f);
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f3) {
                this.X2.b0(true);
            }
            this.f3 = true;
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    public static abstract class SimpleCallback extends Callback {

        /* renamed from: i  reason: collision with root package name */
        private int f15387i;

        /* renamed from: j  reason: collision with root package name */
        private int f15388j;

        public SimpleCallback(int i2, int i3) {
            this.f15387i = i3;
            this.f15388j = i2;
        }

        public int E(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            return this.f15388j;
        }

        public int F(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            return this.f15387i;
        }

        public void G(int i2) {
            this.f15388j = i2;
        }

        public void H(int i2) {
            this.f15387i = i2;
        }

        public int l(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            return Callback.v(E(recyclerView, viewHolder), F(recyclerView, viewHolder));
        }
    }

    public interface ViewDropHandler {
        void e(@NonNull View view, @NonNull View view2, int i2, int i3);
    }

    public ItemTouchHelper(@NonNull Callback callback) {
        this.f15375m = callback;
    }

    private void C() {
        VelocityTracker velocityTracker = this.t;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.t = null;
        }
    }

    private void G() {
        this.q = ViewConfiguration.get(this.r.getContext()).getScaledTouchSlop();
        this.r.setItemDecoration(this);
        this.r.s(this.B);
        this.r.r(this);
        I();
    }

    private void I() {
        this.A = new ItemTouchHelperGestureListener();
        this.z = new GestureDetectorCompat(this.r.getContext(), this.A);
    }

    private void K() {
        ItemTouchHelperGestureListener itemTouchHelperGestureListener = this.A;
        if (itemTouchHelperGestureListener != null) {
            itemTouchHelperGestureListener.a();
            this.A = null;
        }
        if (this.z != null) {
            this.z = null;
        }
    }

    private int L(RecyclerView.ViewHolder viewHolder) {
        if (this.f15376n == 2) {
            return 0;
        }
        int l2 = this.f15375m.l(this.r, viewHolder);
        int d2 = (this.f15375m.d(l2, ViewCompat.c0(this.r)) & 65280) >> 8;
        if (d2 == 0) {
            return 0;
        }
        int i2 = (l2 & 65280) >> 8;
        if (Math.abs(this.f15370h) > Math.abs(this.f15371i)) {
            int n2 = n(viewHolder, d2);
            if (n2 > 0) {
                return (i2 & n2) == 0 ? Callback.e(n2, ViewCompat.c0(this.r)) : n2;
            }
            int p2 = p(viewHolder, d2);
            if (p2 > 0) {
                return p2;
            }
        } else {
            int p3 = p(viewHolder, d2);
            if (p3 > 0) {
                return p3;
            }
            int n3 = n(viewHolder, d2);
            if (n3 > 0) {
                return (i2 & n3) == 0 ? Callback.e(n3, ViewCompat.c0(this.r)) : n3;
            }
        }
        return 0;
    }

    private void l() {
    }

    private int n(RecyclerView.ViewHolder viewHolder, int i2) {
        if ((i2 & 12) == 0) {
            return 0;
        }
        int i3 = 4;
        int i4 = this.f15370h > 0.0f ? 8 : 4;
        VelocityTracker velocityTracker = this.t;
        if (velocityTracker != null && this.f15374l > -1) {
            velocityTracker.computeCurrentVelocity(1000, this.f15375m.o(this.f15369g));
            float xVelocity = this.t.getXVelocity(this.f15374l);
            float yVelocity = this.t.getYVelocity(this.f15374l);
            if (xVelocity > 0.0f) {
                i3 = 8;
            }
            float abs = Math.abs(xVelocity);
            if ((i3 & i2) != 0 && i4 == i3 && abs >= this.f15375m.m(this.f15368f) && abs > Math.abs(yVelocity)) {
                return i3;
            }
        }
        float width = ((float) this.r.getWidth()) * this.f15375m.n(viewHolder);
        if ((i2 & i4) == 0 || Math.abs(this.f15370h) <= width) {
            return 0;
        }
        return i4;
    }

    private int p(RecyclerView.ViewHolder viewHolder, int i2) {
        if ((i2 & 3) == 0) {
            return 0;
        }
        int i3 = 1;
        int i4 = this.f15371i > 0.0f ? 2 : 1;
        VelocityTracker velocityTracker = this.t;
        if (velocityTracker != null && this.f15374l > -1) {
            velocityTracker.computeCurrentVelocity(1000, this.f15375m.o(this.f15369g));
            float xVelocity = this.t.getXVelocity(this.f15374l);
            float yVelocity = this.t.getYVelocity(this.f15374l);
            if (yVelocity > 0.0f) {
                i3 = 2;
            }
            float abs = Math.abs(yVelocity);
            if ((i3 & i2) != 0 && i3 == i4 && abs >= this.f15375m.m(this.f15368f) && abs > Math.abs(xVelocity)) {
                return i3;
            }
        }
        float height = ((float) this.r.getHeight()) * this.f15375m.n(viewHolder);
        if ((i2 & i4) == 0 || Math.abs(this.f15371i) <= height) {
            return 0;
        }
        return i4;
    }

    private void q() {
        this.r.A1(this);
        this.r.D1(this.B);
        this.r.C1(this);
        for (int size = this.p.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = this.p.get(0);
            recoverAnimation.a();
            this.f15375m.c(this.r, recoverAnimation.X2);
        }
        this.p.clear();
        this.x = null;
        this.y = -1;
        C();
        K();
    }

    private List<RecyclerView.ViewHolder> u(RecyclerView.ViewHolder viewHolder) {
        RecyclerView.ViewHolder viewHolder2 = viewHolder;
        List<RecyclerView.ViewHolder> list = this.u;
        if (list == null) {
            this.u = new ArrayList();
            this.v = new ArrayList();
        } else {
            list.clear();
            this.v.clear();
        }
        int h2 = this.f15375m.h();
        int round = Math.round(this.f15372j + this.f15370h) - h2;
        int round2 = Math.round(this.f15373k + this.f15371i) - h2;
        int i2 = h2 * 2;
        int width = viewHolder2.f15587a.getWidth() + round + i2;
        int height = viewHolder2.f15587a.getHeight() + round2 + i2;
        int i3 = (round + width) / 2;
        int i4 = (round2 + height) / 2;
        RecyclerView.LayoutManager layoutManager = this.r.getLayoutManager();
        int V2 = layoutManager.V();
        int i5 = 0;
        while (i5 < V2) {
            View U2 = layoutManager.U(i5);
            if (U2 != viewHolder2.f15587a && U2.getBottom() >= round2 && U2.getTop() <= height && U2.getRight() >= round && U2.getLeft() <= width) {
                RecyclerView.ViewHolder y0 = this.r.y0(U2);
                if (this.f15375m.a(this.r, this.f15365c, y0)) {
                    int abs = Math.abs(i3 - ((U2.getLeft() + U2.getRight()) / 2));
                    int abs2 = Math.abs(i4 - ((U2.getTop() + U2.getBottom()) / 2));
                    int i6 = (abs * abs) + (abs2 * abs2);
                    int size = this.u.size();
                    int i7 = 0;
                    int i8 = 0;
                    while (i7 < size && i6 > this.v.get(i7).intValue()) {
                        i8++;
                        i7++;
                        RecyclerView.ViewHolder viewHolder3 = viewHolder;
                    }
                    this.u.add(i8, y0);
                    this.v.add(i8, Integer.valueOf(i6));
                }
            }
            i5++;
            viewHolder2 = viewHolder;
        }
        return this.u;
    }

    private RecyclerView.ViewHolder v(MotionEvent motionEvent) {
        View t2;
        RecyclerView.LayoutManager layoutManager = this.r.getLayoutManager();
        int i2 = this.f15374l;
        if (i2 == -1) {
            return null;
        }
        int findPointerIndex = motionEvent.findPointerIndex(i2);
        float abs = Math.abs(motionEvent.getX(findPointerIndex) - this.f15366d);
        float abs2 = Math.abs(motionEvent.getY(findPointerIndex) - this.f15367e);
        int i3 = this.q;
        if (abs < ((float) i3) && abs2 < ((float) i3)) {
            return null;
        }
        if (abs > abs2 && layoutManager.s()) {
            return null;
        }
        if ((abs2 <= abs || !layoutManager.t()) && (t2 = t(motionEvent)) != null) {
            return this.r.y0(t2);
        }
        return null;
    }

    private void w(float[] fArr) {
        if ((this.o & 12) != 0) {
            fArr[0] = (this.f15372j + this.f15370h) - ((float) this.f15365c.f15587a.getLeft());
        } else {
            fArr[0] = this.f15365c.f15587a.getTranslationX();
        }
        if ((this.o & 3) != 0) {
            fArr[1] = (this.f15373k + this.f15371i) - ((float) this.f15365c.f15587a.getTop());
        } else {
            fArr[1] = this.f15365c.f15587a.getTranslationY();
        }
    }

    private static boolean y(View view, float f2, float f3, float f4, float f5) {
        return f2 >= f4 && f2 <= f4 + ((float) view.getWidth()) && f3 >= f5 && f3 <= f5 + ((float) view.getHeight());
    }

    /* access modifiers changed from: package-private */
    public void A() {
        VelocityTracker velocityTracker = this.t;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.t = VelocityTracker.obtain();
    }

    /* access modifiers changed from: package-private */
    public void B(final RecoverAnimation recoverAnimation, final int i2) {
        this.r.post(new Runnable() {
            public void run() {
                RecyclerView recyclerView = ItemTouchHelper.this.r;
                if (recyclerView != null && recyclerView.isAttachedToWindow()) {
                    RecoverAnimation recoverAnimation = recoverAnimation;
                    if (!recoverAnimation.e3 && recoverAnimation.X2.A() != -1) {
                        RecyclerView.ItemAnimator itemAnimator = ItemTouchHelper.this.r.getItemAnimator();
                        if ((itemAnimator == null || !itemAnimator.r((RecyclerView.ItemAnimator.ItemAnimatorFinishedListener) null)) && !ItemTouchHelper.this.x()) {
                            ItemTouchHelper.this.f15375m.D(recoverAnimation.X2, i2);
                        } else {
                            ItemTouchHelper.this.r.post(this);
                        }
                    }
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void D(View view) {
        if (view == this.x) {
            this.x = null;
            if (this.w != null) {
                this.r.setChildDrawingOrderCallback((RecyclerView.ChildDrawingOrderCallback) null);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c1, code lost:
        if (r1 > 0) goto L_0x00c5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0100 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x010c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean E() {
        /*
            r16 = this;
            r0 = r16
            androidx.recyclerview.widget.RecyclerView$ViewHolder r1 = r0.f15365c
            r2 = 0
            r3 = -9223372036854775808
            if (r1 != 0) goto L_0x000c
            r0.D = r3
            return r2
        L_0x000c:
            long r5 = java.lang.System.currentTimeMillis()
            long r7 = r0.D
            int r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x0019
            r7 = 0
            goto L_0x001b
        L_0x0019:
            long r7 = r5 - r7
        L_0x001b:
            androidx.recyclerview.widget.RecyclerView r1 = r0.r
            androidx.recyclerview.widget.RecyclerView$LayoutManager r1 = r1.getLayoutManager()
            android.graphics.Rect r9 = r0.C
            if (r9 != 0) goto L_0x002c
            android.graphics.Rect r9 = new android.graphics.Rect
            r9.<init>()
            r0.C = r9
        L_0x002c:
            androidx.recyclerview.widget.RecyclerView$ViewHolder r9 = r0.f15365c
            android.view.View r9 = r9.f15587a
            android.graphics.Rect r10 = r0.C
            r1.r(r9, r10)
            boolean r9 = r1.s()
            r10 = 0
            if (r9 == 0) goto L_0x007d
            float r9 = r0.f15372j
            float r11 = r0.f15370h
            float r9 = r9 + r11
            int r9 = (int) r9
            android.graphics.Rect r11 = r0.C
            int r11 = r11.left
            int r11 = r9 - r11
            androidx.recyclerview.widget.RecyclerView r12 = r0.r
            int r12 = r12.getPaddingLeft()
            int r11 = r11 - r12
            float r12 = r0.f15370h
            int r13 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r13 >= 0) goto L_0x0059
            if (r11 >= 0) goto L_0x0059
            r12 = r11
            goto L_0x007e
        L_0x0059:
            int r11 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r11 <= 0) goto L_0x007d
            androidx.recyclerview.widget.RecyclerView$ViewHolder r11 = r0.f15365c
            android.view.View r11 = r11.f15587a
            int r11 = r11.getWidth()
            int r9 = r9 + r11
            android.graphics.Rect r11 = r0.C
            int r11 = r11.right
            int r9 = r9 + r11
            androidx.recyclerview.widget.RecyclerView r11 = r0.r
            int r11 = r11.getWidth()
            androidx.recyclerview.widget.RecyclerView r12 = r0.r
            int r12 = r12.getPaddingRight()
            int r11 = r11 - r12
            int r9 = r9 - r11
            if (r9 <= 0) goto L_0x007d
            r12 = r9
            goto L_0x007e
        L_0x007d:
            r12 = 0
        L_0x007e:
            boolean r1 = r1.t()
            if (r1 == 0) goto L_0x00c4
            float r1 = r0.f15373k
            float r9 = r0.f15371i
            float r1 = r1 + r9
            int r1 = (int) r1
            android.graphics.Rect r9 = r0.C
            int r9 = r9.top
            int r9 = r1 - r9
            androidx.recyclerview.widget.RecyclerView r11 = r0.r
            int r11 = r11.getPaddingTop()
            int r9 = r9 - r11
            float r11 = r0.f15371i
            int r13 = (r11 > r10 ? 1 : (r11 == r10 ? 0 : -1))
            if (r13 >= 0) goto L_0x00a1
            if (r9 >= 0) goto L_0x00a1
            r1 = r9
            goto L_0x00c5
        L_0x00a1:
            int r9 = (r11 > r10 ? 1 : (r11 == r10 ? 0 : -1))
            if (r9 <= 0) goto L_0x00c4
            androidx.recyclerview.widget.RecyclerView$ViewHolder r9 = r0.f15365c
            android.view.View r9 = r9.f15587a
            int r9 = r9.getHeight()
            int r1 = r1 + r9
            android.graphics.Rect r9 = r0.C
            int r9 = r9.bottom
            int r1 = r1 + r9
            androidx.recyclerview.widget.RecyclerView r9 = r0.r
            int r9 = r9.getHeight()
            androidx.recyclerview.widget.RecyclerView r10 = r0.r
            int r10 = r10.getPaddingBottom()
            int r9 = r9 - r10
            int r1 = r1 - r9
            if (r1 <= 0) goto L_0x00c4
            goto L_0x00c5
        L_0x00c4:
            r1 = 0
        L_0x00c5:
            if (r12 == 0) goto L_0x00de
            androidx.recyclerview.widget.ItemTouchHelper$Callback r9 = r0.f15375m
            androidx.recyclerview.widget.RecyclerView r10 = r0.r
            androidx.recyclerview.widget.RecyclerView$ViewHolder r11 = r0.f15365c
            android.view.View r11 = r11.f15587a
            int r11 = r11.getWidth()
            androidx.recyclerview.widget.RecyclerView r13 = r0.r
            int r13 = r13.getWidth()
            r14 = r7
            int r12 = r9.r(r10, r11, r12, r13, r14)
        L_0x00de:
            r14 = r12
            if (r1 == 0) goto L_0x00fd
            androidx.recyclerview.widget.ItemTouchHelper$Callback r9 = r0.f15375m
            androidx.recyclerview.widget.RecyclerView r10 = r0.r
            androidx.recyclerview.widget.RecyclerView$ViewHolder r11 = r0.f15365c
            android.view.View r11 = r11.f15587a
            int r11 = r11.getHeight()
            androidx.recyclerview.widget.RecyclerView r12 = r0.r
            int r13 = r12.getHeight()
            r12 = r1
            r1 = r14
            r14 = r7
            int r7 = r9.r(r10, r11, r12, r13, r14)
            r12 = r1
            r1 = r7
            goto L_0x00fe
        L_0x00fd:
            r12 = r14
        L_0x00fe:
            if (r12 != 0) goto L_0x0106
            if (r1 == 0) goto L_0x0103
            goto L_0x0106
        L_0x0103:
            r0.D = r3
            return r2
        L_0x0106:
            long r7 = r0.D
            int r2 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r2 != 0) goto L_0x010e
            r0.D = r5
        L_0x010e:
            androidx.recyclerview.widget.RecyclerView r2 = r0.r
            r2.scrollBy(r12, r1)
            r1 = 1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.ItemTouchHelper.E():boolean");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0137  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void F(@androidx.annotation.Nullable androidx.recyclerview.widget.RecyclerView.ViewHolder r24, int r25) {
        /*
            r23 = this;
            r11 = r23
            r12 = r24
            r13 = r25
            androidx.recyclerview.widget.RecyclerView$ViewHolder r0 = r11.f15365c
            if (r12 != r0) goto L_0x000f
            int r0 = r11.f15376n
            if (r13 != r0) goto L_0x000f
            return
        L_0x000f:
            r0 = -9223372036854775808
            r11.D = r0
            int r4 = r11.f15376n
            r14 = 1
            r11.r(r12, r14)
            r11.f15376n = r13
            r15 = 2
            if (r13 != r15) goto L_0x0030
            if (r12 == 0) goto L_0x0028
            android.view.View r0 = r12.f15587a
            r11.x = r0
            r23.l()
            goto L_0x0030
        L_0x0028:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Must pass a ViewHolder when dragging"
            r0.<init>(r1)
            throw r0
        L_0x0030:
            int r0 = r13 * 8
            r10 = 8
            int r0 = r0 + r10
            int r0 = r14 << r0
            int r16 = r0 + -1
            androidx.recyclerview.widget.RecyclerView$ViewHolder r9 = r11.f15365c
            r8 = 0
            if (r9 == 0) goto L_0x00ee
            android.view.View r0 = r9.f15587a
            android.view.ViewParent r0 = r0.getParent()
            if (r0 == 0) goto L_0x00da
            if (r4 != r15) goto L_0x004a
            r7 = 0
            goto L_0x004f
        L_0x004a:
            int r0 = r11.L(r9)
            r7 = r0
        L_0x004f:
            r23.C()
            r0 = 4
            r1 = 0
            if (r7 == r14) goto L_0x007b
            if (r7 == r15) goto L_0x007b
            if (r7 == r0) goto L_0x0069
            if (r7 == r10) goto L_0x0069
            r2 = 16
            if (r7 == r2) goto L_0x0069
            r2 = 32
            if (r7 == r2) goto L_0x0069
            r17 = 0
        L_0x0066:
            r18 = 0
            goto L_0x008e
        L_0x0069:
            float r2 = r11.f15370h
            float r2 = java.lang.Math.signum(r2)
            androidx.recyclerview.widget.RecyclerView r3 = r11.r
            int r3 = r3.getWidth()
            float r3 = (float) r3
            float r2 = r2 * r3
            r17 = r2
            goto L_0x0066
        L_0x007b:
            float r2 = r11.f15371i
            float r2 = java.lang.Math.signum(r2)
            androidx.recyclerview.widget.RecyclerView r3 = r11.r
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r2 = r2 * r3
            r18 = r2
            r17 = 0
        L_0x008e:
            if (r4 != r15) goto L_0x0093
            r6 = 8
            goto L_0x0098
        L_0x0093:
            if (r7 <= 0) goto L_0x0097
            r6 = 2
            goto L_0x0098
        L_0x0097:
            r6 = 4
        L_0x0098:
            float[] r0 = r11.f15364b
            r11.w(r0)
            float[] r0 = r11.f15364b
            r19 = r0[r8]
            r20 = r0[r14]
            androidx.recyclerview.widget.ItemTouchHelper$3 r5 = new androidx.recyclerview.widget.ItemTouchHelper$3
            r0 = r5
            r1 = r23
            r2 = r9
            r3 = r6
            r14 = r5
            r5 = r19
            r15 = r6
            r6 = r20
            r21 = r7
            r7 = r17
            r8 = r18
            r22 = r9
            r9 = r21
            r21 = 8
            r10 = r22
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            androidx.recyclerview.widget.ItemTouchHelper$Callback r0 = r11.f15375m
            androidx.recyclerview.widget.RecyclerView r1 = r11.r
            float r2 = r17 - r19
            float r3 = r18 - r20
            long r0 = r0.g(r1, r15, r2, r3)
            r14.b(r0)
            java.util.List<androidx.recyclerview.widget.ItemTouchHelper$RecoverAnimation> r0 = r11.p
            r0.add(r14)
            r14.d()
            r8 = 1
            goto L_0x00ea
        L_0x00da:
            r0 = r9
            r21 = 8
            android.view.View r1 = r0.f15587a
            r11.D(r1)
            androidx.recyclerview.widget.ItemTouchHelper$Callback r1 = r11.f15375m
            androidx.recyclerview.widget.RecyclerView r2 = r11.r
            r1.c(r2, r0)
            r8 = 0
        L_0x00ea:
            r0 = 0
            r11.f15365c = r0
            goto L_0x00f1
        L_0x00ee:
            r21 = 8
            r8 = 0
        L_0x00f1:
            if (r12 == 0) goto L_0x0122
            androidx.recyclerview.widget.ItemTouchHelper$Callback r0 = r11.f15375m
            androidx.recyclerview.widget.RecyclerView r1 = r11.r
            int r0 = r0.f(r1, r12)
            r0 = r0 & r16
            int r1 = r11.f15376n
            int r1 = r1 * 8
            int r0 = r0 >> r1
            r11.o = r0
            android.view.View r0 = r12.f15587a
            int r0 = r0.getLeft()
            float r0 = (float) r0
            r11.f15372j = r0
            android.view.View r0 = r12.f15587a
            int r0 = r0.getTop()
            float r0 = (float) r0
            r11.f15373k = r0
            r11.f15365c = r12
            r0 = 2
            if (r13 != r0) goto L_0x0122
            android.view.View r0 = r12.f15587a
            r1 = 0
            r0.performHapticFeedback(r1)
            goto L_0x0123
        L_0x0122:
            r1 = 0
        L_0x0123:
            androidx.recyclerview.widget.RecyclerView r0 = r11.r
            android.view.ViewParent r0 = r0.getParent()
            if (r0 == 0) goto L_0x0135
            androidx.recyclerview.widget.RecyclerView$ViewHolder r2 = r11.f15365c
            if (r2 == 0) goto L_0x0131
            r14 = 1
            goto L_0x0132
        L_0x0131:
            r14 = 0
        L_0x0132:
            r0.requestDisallowInterceptTouchEvent(r14)
        L_0x0135:
            if (r8 != 0) goto L_0x0140
            androidx.recyclerview.widget.RecyclerView r0 = r11.r
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r0.getLayoutManager()
            r0.S1()
        L_0x0140:
            androidx.recyclerview.widget.ItemTouchHelper$Callback r0 = r11.f15375m
            androidx.recyclerview.widget.RecyclerView$ViewHolder r1 = r11.f15365c
            int r2 = r11.f15376n
            r0.C(r1, r2)
            androidx.recyclerview.widget.RecyclerView r0 = r11.r
            r0.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.ItemTouchHelper.F(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
    }

    public void H(@NonNull RecyclerView.ViewHolder viewHolder) {
        if (!this.f15375m.p(this.r, viewHolder)) {
            Log.e(Q, "Start drag has been called but dragging is not enabled");
        } else if (viewHolder.f15587a.getParent() != this.r) {
            Log.e(Q, "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
        } else {
            A();
            this.f15371i = 0.0f;
            this.f15370h = 0.0f;
            F(viewHolder, 2);
        }
    }

    public void J(@NonNull RecyclerView.ViewHolder viewHolder) {
        if (!this.f15375m.q(this.r, viewHolder)) {
            Log.e(Q, "Start swipe has been called but swiping is not enabled");
        } else if (viewHolder.f15587a.getParent() != this.r) {
            Log.e(Q, "Start swipe has been called with a view holder which is not a child of the RecyclerView controlled by this ItemTouchHelper.");
        } else {
            A();
            this.f15371i = 0.0f;
            this.f15370h = 0.0f;
            F(viewHolder, 1);
        }
    }

    /* access modifiers changed from: package-private */
    public void M(MotionEvent motionEvent, int i2, int i3) {
        float x2 = motionEvent.getX(i3);
        float y2 = motionEvent.getY(i3);
        float f2 = x2 - this.f15366d;
        this.f15370h = f2;
        this.f15371i = y2 - this.f15367e;
        if ((i2 & 4) == 0) {
            this.f15370h = Math.max(0.0f, f2);
        }
        if ((i2 & 8) == 0) {
            this.f15370h = Math.min(0.0f, this.f15370h);
        }
        if ((i2 & 1) == 0) {
            this.f15371i = Math.max(0.0f, this.f15371i);
        }
        if ((i2 & 2) == 0) {
            this.f15371i = Math.min(0.0f, this.f15371i);
        }
    }

    public void b(@NonNull View view) {
        D(view);
        RecyclerView.ViewHolder y0 = this.r.y0(view);
        if (y0 != null) {
            RecyclerView.ViewHolder viewHolder = this.f15365c;
            if (viewHolder == null || y0 != viewHolder) {
                r(y0, false);
                if (this.f15363a.remove(y0.f15587a)) {
                    this.f15375m.c(this.r, y0);
                    return;
                }
                return;
            }
            F((RecyclerView.ViewHolder) null, 0);
        }
    }

    public void d(@NonNull View view) {
    }

    @SuppressLint({"UnknownNullness"})
    public void g(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.setEmpty();
    }

    @SuppressLint({"UnknownNullness"})
    public void i(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        float f2;
        float f3;
        this.y = -1;
        if (this.f15365c != null) {
            w(this.f15364b);
            float[] fArr = this.f15364b;
            float f4 = fArr[0];
            f2 = fArr[1];
            f3 = f4;
        } else {
            f3 = 0.0f;
            f2 = 0.0f;
        }
        this.f15375m.y(canvas, recyclerView, this.f15365c, this.p, this.f15376n, f3, f2);
    }

    public void k(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        float f2;
        float f3;
        if (this.f15365c != null) {
            w(this.f15364b);
            float[] fArr = this.f15364b;
            float f4 = fArr[0];
            f2 = fArr[1];
            f3 = f4;
        } else {
            f3 = 0.0f;
            f2 = 0.0f;
        }
        this.f15375m.z(canvas, recyclerView, this.f15365c, this.p, this.f15376n, f3, f2);
    }

    public void m(@Nullable RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.r;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                q();
            }
            this.r = recyclerView;
            if (recyclerView != null) {
                Resources resources = recyclerView.getResources();
                this.f15368f = resources.getDimension(R.dimen.f15172f);
                this.f15369g = resources.getDimension(R.dimen.f15171e);
                G();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void o(int i2, MotionEvent motionEvent, int i3) {
        RecyclerView.ViewHolder v2;
        int f2;
        if (this.f15365c == null && i2 == 2 && this.f15376n != 2 && this.f15375m.s() && this.r.getScrollState() != 1 && (v2 = v(motionEvent)) != null && (f2 = (this.f15375m.f(this.r, v2) & 65280) >> 8) != 0) {
            float x2 = motionEvent.getX(i3);
            float y2 = motionEvent.getY(i3);
            float f3 = x2 - this.f15366d;
            float f4 = y2 - this.f15367e;
            float abs = Math.abs(f3);
            float abs2 = Math.abs(f4);
            int i4 = this.q;
            if (abs >= ((float) i4) || abs2 >= ((float) i4)) {
                if (abs > abs2) {
                    if (f3 < 0.0f && (f2 & 4) == 0) {
                        return;
                    }
                    if (f3 > 0.0f && (f2 & 8) == 0) {
                        return;
                    }
                } else if (f4 < 0.0f && (f2 & 1) == 0) {
                    return;
                } else {
                    if (f4 > 0.0f && (f2 & 2) == 0) {
                        return;
                    }
                }
                this.f15371i = 0.0f;
                this.f15370h = 0.0f;
                this.f15374l = motionEvent.getPointerId(0);
                F(v2, 1);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void r(RecyclerView.ViewHolder viewHolder, boolean z2) {
        for (int size = this.p.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = this.p.get(size);
            if (recoverAnimation.X2 == viewHolder) {
                recoverAnimation.e3 |= z2;
                if (!recoverAnimation.f3) {
                    recoverAnimation.a();
                }
                this.p.remove(size);
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public RecoverAnimation s(MotionEvent motionEvent) {
        if (this.p.isEmpty()) {
            return null;
        }
        View t2 = t(motionEvent);
        for (int size = this.p.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = this.p.get(size);
            if (recoverAnimation.X2.f15587a == t2) {
                return recoverAnimation;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public View t(MotionEvent motionEvent) {
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        RecyclerView.ViewHolder viewHolder = this.f15365c;
        if (viewHolder != null) {
            View view = viewHolder.f15587a;
            if (y(view, x2, y2, this.f15372j + this.f15370h, this.f15373k + this.f15371i)) {
                return view;
            }
        }
        for (int size = this.p.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = this.p.get(size);
            View view2 = recoverAnimation.X2.f15587a;
            if (y(view2, x2, y2, recoverAnimation.c3, recoverAnimation.d3)) {
                return view2;
            }
        }
        return this.r.f0(x2, y2);
    }

    /* access modifiers changed from: package-private */
    public boolean x() {
        int size = this.p.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!this.p.get(i2).f3) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void z(RecyclerView.ViewHolder viewHolder) {
        if (!this.r.isLayoutRequested() && this.f15376n == 2) {
            float k2 = this.f15375m.k(viewHolder);
            int i2 = (int) (this.f15372j + this.f15370h);
            int i3 = (int) (this.f15373k + this.f15371i);
            if (((float) Math.abs(i3 - viewHolder.f15587a.getTop())) >= ((float) viewHolder.f15587a.getHeight()) * k2 || ((float) Math.abs(i2 - viewHolder.f15587a.getLeft())) >= ((float) viewHolder.f15587a.getWidth()) * k2) {
                List<RecyclerView.ViewHolder> u2 = u(viewHolder);
                if (u2.size() != 0) {
                    RecyclerView.ViewHolder b2 = this.f15375m.b(viewHolder, u2, i2, i3);
                    if (b2 == null) {
                        this.u.clear();
                        this.v.clear();
                        return;
                    }
                    int A2 = b2.A();
                    int A3 = viewHolder.A();
                    if (this.f15375m.A(this.r, viewHolder, b2)) {
                        this.f15375m.B(this.r, viewHolder, A3, b2, A2, i2, i3);
                    }
                }
            }
        }
    }
}
