package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.TypedArrayUtils;
import androidx.transition.Transition;
import com.itextpdf.tool.xml.css.CSS;
import java.util.Map;

public class ChangeBounds extends Transition {
    private static final String W3 = "android:changeBounds:bounds";
    private static final String X3 = "android:changeBounds:clip";
    private static final String Y3 = "android:changeBounds:parent";
    private static final String Z3 = "android:changeBounds:windowX";
    private static final String a4 = "android:changeBounds:windowY";
    private static final String[] b4 = {W3, X3, Y3, Z3, a4};
    private static final Property<ViewBounds, PointF> c4;
    private static final Property<ViewBounds, PointF> d4;
    private static final Property<View, PointF> e4;
    private static final Property<View, PointF> f4;
    private static final Property<View, PointF> g4;
    private static final RectEvaluator h4 = new RectEvaluator();
    private boolean V3 = false;

    private static class ClipListener extends AnimatorListenerAdapter implements Transition.TransitionListener {
        private final Rect X;
        private final boolean X2;
        private final boolean Y;
        private final int Y2;
        private final Rect Z;
        private final int Z2;
        private final int a3;
        private final int b3;
        private final int c3;
        private final int d3;
        private final int e3;
        private final int f3;
        private boolean g3;
        private final View s;

        ClipListener(View view, Rect rect, boolean z, Rect rect2, boolean z2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            this.s = view;
            this.X = rect;
            this.Y = z;
            this.Z = rect2;
            this.X2 = z2;
            this.Y2 = i2;
            this.Z2 = i3;
            this.a3 = i4;
            this.b3 = i5;
            this.c3 = i6;
            this.d3 = i7;
            this.e3 = i8;
            this.f3 = i9;
        }

        public void b(@NonNull Transition transition) {
        }

        public void f(@NonNull Transition transition) {
            this.s.setTag(R.id.f16017f, this.s.getClipBounds());
            this.s.setClipBounds(this.X2 ? null : this.Z);
        }

        public /* synthetic */ void h(Transition transition, boolean z) {
            e.a(this, transition, z);
        }

        public void k(@NonNull Transition transition) {
        }

        public void onAnimationEnd(Animator animator) {
            onAnimationEnd(animator, false);
        }

        public void onAnimationStart(Animator animator) {
            onAnimationStart(animator, false);
        }

        public void p(@NonNull Transition transition) {
            this.g3 = true;
        }

        public /* synthetic */ void q(Transition transition, boolean z) {
            e.b(this, transition, z);
        }

        public void s(@NonNull Transition transition) {
            View view = this.s;
            int i2 = R.id.f16017f;
            this.s.setTag(i2, (Object) null);
            this.s.setClipBounds((Rect) view.getTag(i2));
        }

        public void onAnimationEnd(Animator animator, boolean z) {
            int i2;
            int i3;
            int i4;
            int i5;
            if (!this.g3) {
                Rect rect = null;
                if (z) {
                    if (!this.Y) {
                        rect = this.X;
                    }
                } else if (!this.X2) {
                    rect = this.Z;
                }
                this.s.setClipBounds(rect);
                View view = this.s;
                if (z) {
                    i2 = this.Y2;
                    i3 = this.Z2;
                    i4 = this.a3;
                    i5 = this.b3;
                } else {
                    i2 = this.c3;
                    i3 = this.d3;
                    i4 = this.e3;
                    i5 = this.f3;
                }
                ViewUtils.e(view, i2, i3, i4, i5);
            }
        }

        public void onAnimationStart(Animator animator, boolean z) {
            int max = Math.max(this.a3 - this.Y2, this.e3 - this.c3);
            int max2 = Math.max(this.b3 - this.Z2, this.f3 - this.d3);
            int i2 = z ? this.c3 : this.Y2;
            int i3 = z ? this.d3 : this.Z2;
            ViewUtils.e(this.s, i2, i3, max + i2, max2 + i3);
            this.s.setClipBounds(z ? this.Z : this.X);
        }
    }

    private static class SuppressLayoutListener extends TransitionListenerAdapter {
        final ViewGroup X;
        boolean s = false;

        SuppressLayoutListener(@NonNull ViewGroup viewGroup) {
            this.X = viewGroup;
        }

        public void f(@NonNull Transition transition) {
            ViewGroupUtils.c(this.X, false);
        }

        public void k(@NonNull Transition transition) {
            if (!this.s) {
                ViewGroupUtils.c(this.X, false);
            }
            transition.S0(this);
        }

        public void p(@NonNull Transition transition) {
            ViewGroupUtils.c(this.X, false);
            this.s = true;
        }

        public void s(@NonNull Transition transition) {
            ViewGroupUtils.c(this.X, true);
        }
    }

    private static class ViewBounds {

        /* renamed from: a  reason: collision with root package name */
        private int f15972a;

        /* renamed from: b  reason: collision with root package name */
        private int f15973b;

        /* renamed from: c  reason: collision with root package name */
        private int f15974c;

        /* renamed from: d  reason: collision with root package name */
        private int f15975d;

        /* renamed from: e  reason: collision with root package name */
        private final View f15976e;

        /* renamed from: f  reason: collision with root package name */
        private int f15977f;

        /* renamed from: g  reason: collision with root package name */
        private int f15978g;

        ViewBounds(View view) {
            this.f15976e = view;
        }

        private void b() {
            ViewUtils.e(this.f15976e, this.f15972a, this.f15973b, this.f15974c, this.f15975d);
            this.f15977f = 0;
            this.f15978g = 0;
        }

        /* access modifiers changed from: package-private */
        public void a(PointF pointF) {
            this.f15974c = Math.round(pointF.x);
            this.f15975d = Math.round(pointF.y);
            int i2 = this.f15978g + 1;
            this.f15978g = i2;
            if (this.f15977f == i2) {
                b();
            }
        }

        /* access modifiers changed from: package-private */
        public void c(PointF pointF) {
            this.f15972a = Math.round(pointF.x);
            this.f15973b = Math.round(pointF.y);
            int i2 = this.f15977f + 1;
            this.f15977f = i2;
            if (i2 == this.f15978g) {
                b();
            }
        }
    }

    static {
        Class<PointF> cls = PointF.class;
        c4 = new Property<ViewBounds, PointF>(cls, "topLeft") {
            /* renamed from: a */
            public PointF get(ViewBounds viewBounds) {
                return null;
            }

            /* renamed from: b */
            public void set(ViewBounds viewBounds, PointF pointF) {
                viewBounds.c(pointF);
            }
        };
        d4 = new Property<ViewBounds, PointF>(cls, "bottomRight") {
            /* renamed from: a */
            public PointF get(ViewBounds viewBounds) {
                return null;
            }

            /* renamed from: b */
            public void set(ViewBounds viewBounds, PointF pointF) {
                viewBounds.a(pointF);
            }
        };
        e4 = new Property<View, PointF>(cls, "bottomRight") {
            /* renamed from: a */
            public PointF get(View view) {
                return null;
            }

            /* renamed from: b */
            public void set(View view, PointF pointF) {
                ViewUtils.e(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
            }
        };
        f4 = new Property<View, PointF>(cls, "topLeft") {
            /* renamed from: a */
            public PointF get(View view) {
                return null;
            }

            /* renamed from: b */
            public void set(View view, PointF pointF) {
                ViewUtils.e(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
            }
        };
        g4 = new Property<View, PointF>(cls, CSS.Property.m0) {
            /* renamed from: a */
            public PointF get(View view) {
                return null;
            }

            /* renamed from: b */
            public void set(View view, PointF pointF) {
                int round = Math.round(pointF.x);
                int round2 = Math.round(pointF.y);
                ViewUtils.e(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
            }
        };
    }

    public ChangeBounds() {
    }

    private void C1(TransitionValues transitionValues) {
        View view = transitionValues.f16095b;
        if (view.isLaidOut() || view.getWidth() != 0 || view.getHeight() != 0) {
            transitionValues.f16094a.put(W3, new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            transitionValues.f16094a.put(Y3, transitionValues.f16095b.getParent());
            if (this.V3) {
                transitionValues.f16094a.put(X3, view.getClipBounds());
            }
        }
    }

    public boolean D1() {
        return this.V3;
    }

    public void F1(boolean z) {
        this.V3 = z;
    }

    public void n(@NonNull TransitionValues transitionValues) {
        C1(transitionValues);
    }

    public void q(@NonNull TransitionValues transitionValues) {
        Rect rect;
        C1(transitionValues);
        if (this.V3 && (rect = (Rect) transitionValues.f16095b.getTag(R.id.f16017f)) != null) {
            transitionValues.f16094a.put(X3, rect);
        }
    }

    @NonNull
    public String[] r0() {
        return b4;
    }

    @Nullable
    public Animator u(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        int i2;
        View view;
        Animator animator;
        int i3;
        int i4;
        int i5;
        ObjectAnimator objectAnimator;
        int i6;
        ObjectAnimator objectAnimator2;
        Path a2;
        Property<View, PointF> property;
        TransitionValues transitionValues3 = transitionValues;
        TransitionValues transitionValues4 = transitionValues2;
        if (transitionValues3 == null || transitionValues4 == null) {
            return null;
        }
        Map<String, Object> map = transitionValues3.f16094a;
        Map<String, Object> map2 = transitionValues4.f16094a;
        ViewGroup viewGroup2 = (ViewGroup) map.get(Y3);
        ViewGroup viewGroup3 = (ViewGroup) map2.get(Y3);
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = transitionValues4.f16095b;
        Rect rect = (Rect) transitionValues3.f16094a.get(W3);
        Rect rect2 = (Rect) transitionValues4.f16094a.get(W3);
        int i7 = rect.left;
        int i8 = rect2.left;
        int i9 = rect.top;
        int i10 = rect2.top;
        int i11 = rect.right;
        int i12 = rect2.right;
        int i13 = rect.bottom;
        int i14 = rect2.bottom;
        int i15 = i11 - i7;
        int i16 = i13 - i9;
        int i17 = i12 - i8;
        int i18 = i14 - i10;
        View view3 = view2;
        Rect rect3 = (Rect) transitionValues3.f16094a.get(X3);
        Rect rect4 = (Rect) transitionValues4.f16094a.get(X3);
        if ((i15 == 0 || i16 == 0) && (i17 == 0 || i18 == 0)) {
            i2 = 0;
        } else {
            i2 = (i7 == i8 && i9 == i10) ? 0 : 1;
            if (!(i11 == i12 && i13 == i14)) {
                i2++;
            }
        }
        if ((rect3 != null && !rect3.equals(rect4)) || (rect3 == null && rect4 != null)) {
            i2++;
        }
        if (i2 <= 0) {
            return null;
        }
        Rect rect5 = rect4;
        if (!this.V3) {
            view = view3;
            ViewUtils.e(view, i7, i9, i11, i13);
            if (i2 == 2) {
                if (i15 == i17 && i16 == i18) {
                    a2 = b0().a((float) i7, (float) i9, (float) i8, (float) i10);
                    property = g4;
                } else {
                    ViewBounds viewBounds = new ViewBounds(view);
                    ObjectAnimator a3 = ObjectAnimatorUtils.a(viewBounds, c4, b0().a((float) i7, (float) i9, (float) i8, (float) i10));
                    ObjectAnimator a5 = ObjectAnimatorUtils.a(viewBounds, d4, b0().a((float) i11, (float) i13, (float) i12, (float) i14));
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(new Animator[]{a3, a5});
                    animatorSet.addListener(new AnimatorListenerAdapter(viewBounds) {
                        private final ViewBounds mViewBounds;
                        final /* synthetic */ ViewBounds s;

                        {
                            this.s = r2;
                            this.mViewBounds = r2;
                        }
                    });
                    animator = animatorSet;
                }
            } else if (i7 == i8 && i9 == i10) {
                a2 = b0().a((float) i11, (float) i13, (float) i12, (float) i14);
                property = e4;
            } else {
                a2 = b0().a((float) i7, (float) i9, (float) i8, (float) i10);
                property = f4;
            }
            animator = ObjectAnimatorUtils.a(view, property, a2);
        } else {
            view = view3;
            int i19 = i14;
            ViewUtils.e(view, i7, i9, Math.max(i15, i17) + i7, i9 + Math.max(i16, i18));
            if (i7 == i8 && i9 == i10) {
                i5 = i12;
                i4 = i11;
                i3 = i9;
                objectAnimator = null;
            } else {
                i5 = i12;
                i4 = i11;
                i3 = i9;
                objectAnimator = ObjectAnimatorUtils.a(view, g4, b0().a((float) i7, (float) i9, (float) i8, (float) i10));
            }
            boolean z = rect3 == null;
            if (z) {
                i6 = 0;
                rect3 = new Rect(0, 0, i15, i16);
            } else {
                i6 = 0;
            }
            Rect rect6 = rect3;
            boolean z2 = rect5 == null;
            Rect rect7 = z2 ? new Rect(i6, i6, i17, i18) : rect5;
            if (!rect6.equals(rect7)) {
                view.setClipBounds(rect6);
                RectEvaluator rectEvaluator = h4;
                Object[] objArr = new Object[2];
                objArr[i6] = rect6;
                objArr[1] = rect7;
                objectAnimator2 = ObjectAnimator.ofObject(view, "clipBounds", rectEvaluator, objArr);
                ClipListener clipListener = new ClipListener(view, rect6, z, rect7, z2, i7, i3, i4, i13, i8, i10, i5, i19);
                objectAnimator2.addListener(clipListener);
                c(clipListener);
            } else {
                objectAnimator2 = null;
            }
            animator = TransitionUtils.c(objectAnimator, objectAnimator2);
        }
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
            ViewGroupUtils.c(viewGroup4, true);
            f0().c(new SuppressLayoutListener(viewGroup4));
        }
        return animator;
    }

    public boolean u0() {
        return true;
    }

    public ChangeBounds(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.f16037d);
        boolean e2 = TypedArrayUtils.e(obtainStyledAttributes, (XmlResourceParser) attributeSet, "resizeClip", 0, false);
        obtainStyledAttributes.recycle();
        F1(e2);
    }
}
