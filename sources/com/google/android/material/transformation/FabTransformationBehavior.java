package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.animation.ChildrenAlphaProperty;
import com.google.android.material.animation.DrawableAlphaProperty;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.MotionTiming;
import com.google.android.material.animation.Positioning;
import com.google.android.material.circularreveal.CircularRevealCompat;
import com.google.android.material.circularreveal.CircularRevealHelper;
import com.google.android.material.circularreveal.CircularRevealWidget;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.math.MathUtils;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {
    private final Rect Y2 = new Rect();
    private final RectF Z2 = new RectF();
    private final RectF a3 = new RectF();
    private final int[] b3 = new int[2];
    private float c3;
    private float d3;

    protected static class FabTransformationSpec {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        public MotionSpec f22089a;

        /* renamed from: b  reason: collision with root package name */
        public Positioning f22090b;

        protected FabTransformationSpec() {
        }
    }

    public FabTransformationBehavior() {
    }

    @Nullable
    private ViewGroup U(@NonNull View view) {
        View findViewById = view.findViewById(R.id.q3);
        if (findViewById != null) {
            return p0(findViewById);
        }
        return ((view instanceof TransformationChildLayout) || (view instanceof TransformationChildCard)) ? p0(((ViewGroup) view).getChildAt(0)) : p0(view);
    }

    private void V(@NonNull View view, @NonNull FabTransformationSpec fabTransformationSpec, @NonNull MotionTiming motionTiming, @NonNull MotionTiming motionTiming2, float f2, float f3, float f4, float f5, @NonNull RectF rectF) {
        float c0 = c0(fabTransformationSpec, motionTiming, f2, f4);
        float c02 = c0(fabTransformationSpec, motionTiming2, f3, f5);
        Rect rect = this.Y2;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.Z2;
        rectF2.set(rect);
        RectF rectF3 = this.a3;
        d0(view, rectF3);
        rectF3.offset(c0, c02);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    private void W(@NonNull View view, @NonNull RectF rectF) {
        d0(view, rectF);
        rectF.offset(this.c3, this.d3);
    }

    @NonNull
    private Pair<MotionTiming, MotionTiming> X(float f2, float f3, boolean z, @NonNull FabTransformationSpec fabTransformationSpec) {
        MotionTiming h2;
        MotionSpec motionSpec;
        String str;
        int i2;
        if (f2 == 0.0f || f3 == 0.0f) {
            h2 = fabTransformationSpec.f22089a.h("translationXLinear");
            motionSpec = fabTransformationSpec.f22089a;
            str = "translationYLinear";
        } else if ((!z || f3 >= 0.0f) && (z || i2 <= 0)) {
            h2 = fabTransformationSpec.f22089a.h("translationXCurveDownwards");
            motionSpec = fabTransformationSpec.f22089a;
            str = "translationYCurveDownwards";
        } else {
            h2 = fabTransformationSpec.f22089a.h("translationXCurveUpwards");
            motionSpec = fabTransformationSpec.f22089a;
            str = "translationYCurveUpwards";
        }
        return new Pair<>(h2, motionSpec.h(str));
    }

    private float Y(@NonNull View view, @NonNull View view2, @NonNull Positioning positioning) {
        RectF rectF = this.Z2;
        RectF rectF2 = this.a3;
        W(view, rectF);
        d0(view2, rectF2);
        rectF2.offset(-a0(view, view2, positioning), 0.0f);
        return rectF.centerX() - rectF2.left;
    }

    private float Z(@NonNull View view, @NonNull View view2, @NonNull Positioning positioning) {
        RectF rectF = this.Z2;
        RectF rectF2 = this.a3;
        W(view, rectF);
        d0(view2, rectF2);
        rectF2.offset(0.0f, -b0(view, view2, positioning));
        return rectF.centerY() - rectF2.top;
    }

    private float a0(@NonNull View view, @NonNull View view2, @NonNull Positioning positioning) {
        float f2;
        float centerX;
        float centerX2;
        RectF rectF = this.Z2;
        RectF rectF2 = this.a3;
        W(view, rectF);
        d0(view2, rectF2);
        int i2 = positioning.f20787a & 7;
        if (i2 == 1) {
            centerX = rectF2.centerX();
            centerX2 = rectF.centerX();
        } else if (i2 == 3) {
            centerX = rectF2.left;
            centerX2 = rectF.left;
        } else if (i2 != 5) {
            f2 = 0.0f;
            return f2 + positioning.f20788b;
        } else {
            centerX = rectF2.right;
            centerX2 = rectF.right;
        }
        f2 = centerX - centerX2;
        return f2 + positioning.f20788b;
    }

    private float b0(@NonNull View view, @NonNull View view2, @NonNull Positioning positioning) {
        float f2;
        float centerY;
        float centerY2;
        RectF rectF = this.Z2;
        RectF rectF2 = this.a3;
        W(view, rectF);
        d0(view2, rectF2);
        int i2 = positioning.f20787a & 112;
        if (i2 == 16) {
            centerY = rectF2.centerY();
            centerY2 = rectF.centerY();
        } else if (i2 == 48) {
            centerY = rectF2.top;
            centerY2 = rectF.top;
        } else if (i2 != 80) {
            f2 = 0.0f;
            return f2 + positioning.f20789c;
        } else {
            centerY = rectF2.bottom;
            centerY2 = rectF.bottom;
        }
        f2 = centerY - centerY2;
        return f2 + positioning.f20789c;
    }

    private float c0(@NonNull FabTransformationSpec fabTransformationSpec, @NonNull MotionTiming motionTiming, float f2, float f3) {
        long c2 = motionTiming.c();
        long d2 = motionTiming.d();
        MotionTiming h2 = fabTransformationSpec.f22089a.h("expansion");
        return AnimationUtils.a(f2, f3, motionTiming.e().getInterpolation(((float) (((h2.c() + h2.d()) + 17) - c2)) / ((float) d2)));
    }

    private void d0(@NonNull View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        int[] iArr = this.b3;
        view.getLocationInWindow(iArr);
        rectF.offsetTo((float) iArr[0], (float) iArr[1]);
        rectF.offset((float) ((int) (-view.getTranslationX())), (float) ((int) (-view.getTranslationY())));
    }

    private void e0(View view, View view2, boolean z, boolean z2, @NonNull FabTransformationSpec fabTransformationSpec, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2) {
        ViewGroup U;
        ObjectAnimator objectAnimator;
        if (view2 instanceof ViewGroup) {
            if ((!(view2 instanceof CircularRevealWidget) || CircularRevealHelper.o != 0) && (U = U(view2)) != null) {
                if (z) {
                    if (!z2) {
                        ChildrenAlphaProperty.f20772a.set(U, Float.valueOf(0.0f));
                    }
                    objectAnimator = ObjectAnimator.ofFloat(U, ChildrenAlphaProperty.f20772a, new float[]{1.0f});
                } else {
                    objectAnimator = ObjectAnimator.ofFloat(U, ChildrenAlphaProperty.f20772a, new float[]{0.0f});
                }
                fabTransformationSpec.f22089a.h("contentFade").a(objectAnimator);
                list.add(objectAnimator);
            }
        }
    }

    private void f0(@NonNull View view, View view2, boolean z, boolean z2, @NonNull FabTransformationSpec fabTransformationSpec, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimator;
        if (view2 instanceof CircularRevealWidget) {
            CircularRevealWidget circularRevealWidget = (CircularRevealWidget) view2;
            int n0 = n0(view);
            int i2 = 16777215 & n0;
            if (z) {
                if (!z2) {
                    circularRevealWidget.setCircularRevealScrimColor(n0);
                }
                objectAnimator = ObjectAnimator.ofInt(circularRevealWidget, CircularRevealWidget.CircularRevealScrimColorProperty.f21008a, new int[]{i2});
            } else {
                objectAnimator = ObjectAnimator.ofInt(circularRevealWidget, CircularRevealWidget.CircularRevealScrimColorProperty.f21008a, new int[]{n0});
            }
            objectAnimator.setEvaluator(ArgbEvaluatorCompat.b());
            fabTransformationSpec.f22089a.h("color").a(objectAnimator);
            list.add(objectAnimator);
        }
    }

    private void g0(@NonNull View view, @NonNull View view2, boolean z, @NonNull FabTransformationSpec fabTransformationSpec, @NonNull List<Animator> list) {
        float a0 = a0(view, view2, fabTransformationSpec.f22090b);
        float b0 = b0(view, view2, fabTransformationSpec.f22090b);
        Pair<MotionTiming, MotionTiming> X = X(a0, b0, z, fabTransformationSpec);
        MotionTiming motionTiming = (MotionTiming) X.first;
        MotionTiming motionTiming2 = (MotionTiming) X.second;
        Property property = View.TRANSLATION_X;
        if (!z) {
            a0 = this.c3;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, property, new float[]{a0});
        Property property2 = View.TRANSLATION_Y;
        if (!z) {
            b0 = this.d3;
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, property2, new float[]{b0});
        motionTiming.a(ofFloat);
        motionTiming2.a(ofFloat2);
        list.add(ofFloat);
        list.add(ofFloat2);
    }

    @TargetApi(21)
    private void h0(View view, @NonNull View view2, boolean z, boolean z2, @NonNull FabTransformationSpec fabTransformationSpec, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimator;
        float T = ViewCompat.T(view2) - ViewCompat.T(view);
        if (z) {
            if (!z2) {
                view2.setTranslationZ(-T);
            }
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, new float[]{0.0f});
        } else {
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, new float[]{-T});
        }
        fabTransformationSpec.f22089a.h("elevation").a(objectAnimator);
        list.add(objectAnimator);
    }

    private void i0(@NonNull View view, View view2, boolean z, boolean z2, @NonNull FabTransformationSpec fabTransformationSpec, float f2, float f3, @NonNull List<Animator> list, @NonNull List<Animator.AnimatorListener> list2) {
        Animator animator;
        View view3 = view;
        View view4 = view2;
        FabTransformationSpec fabTransformationSpec2 = fabTransformationSpec;
        if (view4 instanceof CircularRevealWidget) {
            final CircularRevealWidget circularRevealWidget = (CircularRevealWidget) view4;
            float Y = Y(view3, view4, fabTransformationSpec2.f22090b);
            float Z = Z(view3, view4, fabTransformationSpec2.f22090b);
            ((FloatingActionButton) view3).k(this.Y2);
            float width = ((float) this.Y2.width()) / 2.0f;
            MotionTiming h2 = fabTransformationSpec2.f22089a.h("expansion");
            if (z) {
                if (!z2) {
                    circularRevealWidget.setRevealInfo(new CircularRevealWidget.RevealInfo(Y, Z, width));
                }
                if (z2) {
                    width = circularRevealWidget.getRevealInfo().f21012c;
                }
                animator = CircularRevealCompat.a(circularRevealWidget, Y, Z, MathUtils.b(Y, Z, 0.0f, 0.0f, f2, f3));
                animator.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        CircularRevealWidget.RevealInfo revealInfo = circularRevealWidget.getRevealInfo();
                        revealInfo.f21012c = Float.MAX_VALUE;
                        circularRevealWidget.setRevealInfo(revealInfo);
                    }
                });
                l0(view2, h2.c(), (int) Y, (int) Z, width, list);
            } else {
                float f4 = circularRevealWidget.getRevealInfo().f21012c;
                Animator a2 = CircularRevealCompat.a(circularRevealWidget, Y, Z, width);
                int i2 = (int) Y;
                int i3 = (int) Z;
                View view5 = view2;
                l0(view5, h2.c(), i2, i3, f4, list);
                long c2 = h2.c();
                long d2 = h2.d();
                long i4 = fabTransformationSpec2.f22089a.i();
                k0(view5, c2, d2, i4, i2, i3, width, list);
                animator = a2;
            }
            h2.a(animator);
            list.add(animator);
            list2.add(CircularRevealCompat.c(circularRevealWidget));
        }
    }

    private void j0(View view, final View view2, boolean z, boolean z2, @NonNull FabTransformationSpec fabTransformationSpec, @NonNull List<Animator> list, @NonNull List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimator;
        if ((view2 instanceof CircularRevealWidget) && (view instanceof ImageView)) {
            final CircularRevealWidget circularRevealWidget = (CircularRevealWidget) view2;
            final Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable != null) {
                drawable.mutate();
                if (z) {
                    if (!z2) {
                        drawable.setAlpha(255);
                    }
                    objectAnimator = ObjectAnimator.ofInt(drawable, DrawableAlphaProperty.f20773b, new int[]{0});
                } else {
                    objectAnimator = ObjectAnimator.ofInt(drawable, DrawableAlphaProperty.f20773b, new int[]{255});
                }
                objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        view2.invalidate();
                    }
                });
                fabTransformationSpec.f22089a.h("iconFade").a(objectAnimator);
                list.add(objectAnimator);
                list2.add(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        circularRevealWidget.setCircularRevealOverlayDrawable((Drawable) null);
                    }

                    public void onAnimationStart(Animator animator) {
                        circularRevealWidget.setCircularRevealOverlayDrawable(drawable);
                    }
                });
            }
        }
    }

    private void k0(View view, long j2, long j3, long j4, int i2, int i3, float f2, @NonNull List<Animator> list) {
        long j5 = j2 + j3;
        if (j5 < j4) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i2, i3, f2, f2);
            createCircularReveal.setStartDelay(j5);
            createCircularReveal.setDuration(j4 - j5);
            list.add(createCircularReveal);
        }
    }

    private void l0(View view, long j2, int i2, int i3, float f2, @NonNull List<Animator> list) {
        if (j2 > 0) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i2, i3, f2, f2);
            createCircularReveal.setStartDelay(0);
            createCircularReveal.setDuration(j2);
            list.add(createCircularReveal);
        }
    }

    private void m0(@NonNull View view, @NonNull View view2, boolean z, boolean z2, @NonNull FabTransformationSpec fabTransformationSpec, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2, @NonNull RectF rectF) {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        View view3 = view;
        View view4 = view2;
        boolean z3 = z;
        FabTransformationSpec fabTransformationSpec2 = fabTransformationSpec;
        List<Animator> list3 = list;
        float a0 = a0(view3, view4, fabTransformationSpec2.f22090b);
        float b0 = b0(view3, view4, fabTransformationSpec2.f22090b);
        Pair<MotionTiming, MotionTiming> X = X(a0, b0, z3, fabTransformationSpec2);
        MotionTiming motionTiming = (MotionTiming) X.first;
        MotionTiming motionTiming2 = (MotionTiming) X.second;
        if (z3) {
            if (!z2) {
                view4.setTranslationX(-a0);
                view4.setTranslationY(-b0);
            }
            objectAnimator2 = ObjectAnimator.ofFloat(view4, View.TRANSLATION_X, new float[]{0.0f});
            objectAnimator = ObjectAnimator.ofFloat(view4, View.TRANSLATION_Y, new float[]{0.0f});
            V(view2, fabTransformationSpec, motionTiming, motionTiming2, -a0, -b0, 0.0f, 0.0f, rectF);
        } else {
            objectAnimator2 = ObjectAnimator.ofFloat(view4, View.TRANSLATION_X, new float[]{-a0});
            objectAnimator = ObjectAnimator.ofFloat(view4, View.TRANSLATION_Y, new float[]{-b0});
        }
        motionTiming.a(objectAnimator2);
        motionTiming2.a(objectAnimator);
        list3.add(objectAnimator2);
        list3.add(objectAnimator);
    }

    private int n0(@NonNull View view) {
        ColorStateList O = ViewCompat.O(view);
        if (O != null) {
            return O.getColorForState(view.getDrawableState(), O.getDefaultColor());
        }
        return 0;
    }

    @Nullable
    private ViewGroup p0(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public AnimatorSet T(@NonNull View view, @NonNull View view2, boolean z, boolean z2) {
        final boolean z3 = z;
        FabTransformationSpec o0 = o0(view2.getContext(), z3);
        if (z3) {
            this.c3 = view.getTranslationX();
            this.d3 = view.getTranslationY();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        h0(view, view2, z, z2, o0, arrayList, arrayList2);
        RectF rectF = this.Z2;
        View view3 = view;
        View view4 = view2;
        boolean z4 = z;
        ArrayList arrayList3 = arrayList;
        ArrayList arrayList4 = arrayList2;
        m0(view3, view4, z4, z2, o0, arrayList3, arrayList4, rectF);
        float width = rectF.width();
        float height = rectF.height();
        g0(view3, view4, z4, o0, arrayList);
        boolean z5 = z2;
        FabTransformationSpec fabTransformationSpec = o0;
        j0(view3, view4, z4, z5, fabTransformationSpec, arrayList3, arrayList4);
        i0(view3, view4, z4, z5, fabTransformationSpec, width, height, arrayList, arrayList2);
        ArrayList arrayList5 = arrayList;
        ArrayList arrayList6 = arrayList2;
        f0(view3, view4, z4, z5, fabTransformationSpec, arrayList5, arrayList6);
        e0(view3, view4, z4, z5, fabTransformationSpec, arrayList5, arrayList6);
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSetCompat.a(animatorSet, arrayList);
        final View view5 = view;
        final View view6 = view2;
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (!z3) {
                    view6.setVisibility(4);
                    view5.setAlpha(1.0f);
                    view5.setVisibility(0);
                }
            }

            public void onAnimationStart(Animator animator) {
                if (z3) {
                    view6.setVisibility(0);
                    view5.setAlpha(0.0f);
                    view5.setVisibility(4);
                }
            }
        });
        int size = arrayList2.size();
        for (int i2 = 0; i2 < size; i2++) {
            animatorSet.addListener((Animator.AnimatorListener) arrayList2.get(i2));
        }
        return animatorSet;
    }

    @CallSuper
    public boolean m(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        } else if (!(view2 instanceof FloatingActionButton)) {
            return false;
        } else {
            int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
            return expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId();
        }
    }

    @CallSuper
    public void o(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        if (layoutParams.f5084h == 0) {
            layoutParams.f5084h = 80;
        }
    }

    /* access modifiers changed from: protected */
    public abstract FabTransformationSpec o0(Context context, boolean z);

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
