package net.imedicaldoctor.imd.Views;

import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.view.ViewHelper;
import net.imedicaldoctor.imd.R;

public class AnimUtils {

    /* renamed from: net.imedicaldoctor.imd.Views.AnimUtils$9  reason: invalid class name */
    static /* synthetic */ class AnonymousClass9 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f30512a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                net.imedicaldoctor.imd.Views.AnimUtils$Style[] r0 = net.imedicaldoctor.imd.Views.AnimUtils.Style.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f30512a = r0
                net.imedicaldoctor.imd.Views.AnimUtils$Style r1 = net.imedicaldoctor.imd.Views.AnimUtils.Style.Fade     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f30512a     // Catch:{ NoSuchFieldError -> 0x001d }
                net.imedicaldoctor.imd.Views.AnimUtils$Style r1 = net.imedicaldoctor.imd.Views.AnimUtils.Style.Pop     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f30512a     // Catch:{ NoSuchFieldError -> 0x0028 }
                net.imedicaldoctor.imd.Views.AnimUtils$Style r1 = net.imedicaldoctor.imd.Views.AnimUtils.Style.Fly     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f30512a     // Catch:{ NoSuchFieldError -> 0x0033 }
                net.imedicaldoctor.imd.Views.AnimUtils$Style r1 = net.imedicaldoctor.imd.Views.AnimUtils.Style.BrightnessSaturationFade     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Views.AnimUtils.AnonymousClass9.<clinit>():void");
        }
    }

    public enum Style {
        None,
        Fade,
        Pop,
        Fly,
        BrightnessSaturationFade,
        ProgressWidth
    }

    private AnimUtils() {
    }

    public static ValueAnimator a(View view, Style style, Animator.AnimatorListener animatorListener) {
        int i2 = AnonymousClass9.f30512a[style.ordinal()];
        if (i2 == 1) {
            return e(view, animatorListener);
        }
        if (i2 == 2) {
            return k(view, animatorListener);
        }
        if (i2 == 3) {
            return g(view, animatorListener);
        }
        if (i2 == 4) {
            return view instanceof ImageView ? c((ImageView) view, animatorListener) : e(view, animatorListener);
        }
        if (animatorListener != null) {
            animatorListener.d((Animator) null);
        }
        return null;
    }

    public static ValueAnimator b(View view, Style style, Animator.AnimatorListener animatorListener) {
        int i2 = AnonymousClass9.f30512a[style.ordinal()];
        if (i2 == 1) {
            return f(view, animatorListener);
        }
        if (i2 == 2) {
            return l(view, animatorListener);
        }
        if (i2 == 3) {
            return h(view, animatorListener);
        }
        if (i2 == 4) {
            return view instanceof ImageView ? d((ImageView) view, animatorListener) : f(view, animatorListener);
        }
        if (animatorListener != null) {
            animatorListener.d((Animator) null);
        }
        return null;
    }

    public static ValueAnimator c(final ImageView imageView, Animator.AnimatorListener animatorListener) {
        final ValueAnimator l0 = ValueAnimator.l0(0.0f, 1.0f);
        final AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
        l0.n(accelerateDecelerateInterpolator);
        l0.m(800);
        if (animatorListener != null) {
            l0.a(animatorListener);
        }
        l0.F(new ValueAnimator.AnimatorUpdateListener() {

            /* renamed from: a  reason: collision with root package name */
            final ColorMatrix f30502a = new ColorMatrix();

            /* renamed from: b  reason: collision with root package name */
            final ColorMatrix f30503b = new ColorMatrix();

            public void e(ValueAnimator valueAnimator) {
                float S = ValueAnimator.this.S();
                this.f30502a.setSaturation(((Float) ValueAnimator.this.U()).floatValue());
                float interpolation = 2.0f - accelerateDecelerateInterpolator.getInterpolation(Math.min((4.0f * S) / 3.0f, 1.0f));
                this.f30503b.setScale(interpolation, interpolation, interpolation, accelerateDecelerateInterpolator.getInterpolation(Math.min(S * 2.0f, 1.0f)));
                this.f30502a.preConcat(this.f30503b);
                imageView.setColorFilter(new ColorMatrixColorFilter(this.f30502a));
                if (imageView.getParent() != null) {
                    ((View) imageView.getParent()).postInvalidate();
                }
            }
        });
        l0.s();
        return l0;
    }

    public static ValueAnimator d(final ImageView imageView, Animator.AnimatorListener animatorListener) {
        final ValueAnimator l0 = ValueAnimator.l0(1.0f, 0.0f);
        final AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
        l0.n(accelerateDecelerateInterpolator);
        l0.m(800);
        if (animatorListener != null) {
            l0.a(animatorListener);
        }
        l0.F(new ValueAnimator.AnimatorUpdateListener() {

            /* renamed from: a  reason: collision with root package name */
            final ColorMatrix f30507a = new ColorMatrix();

            /* renamed from: b  reason: collision with root package name */
            final ColorMatrix f30508b = new ColorMatrix();

            public void e(ValueAnimator valueAnimator) {
                float S = ValueAnimator.this.S();
                this.f30507a.setSaturation(((Float) ValueAnimator.this.U()).floatValue());
                float f2 = 1.0f - S;
                float interpolation = 2.0f - accelerateDecelerateInterpolator.getInterpolation(Math.min((4.0f * f2) / 3.0f, 1.0f));
                this.f30508b.setScale(interpolation, interpolation, interpolation, accelerateDecelerateInterpolator.getInterpolation(Math.min(f2 * 2.0f, 1.0f)));
                this.f30507a.preConcat(this.f30508b);
                imageView.setColorFilter(new ColorMatrixColorFilter(this.f30507a));
                if (imageView.getParent() != null) {
                    ((View) imageView.getParent()).postInvalidate();
                }
            }
        });
        l0.s();
        return l0;
    }

    public static ValueAnimator e(final View view, Animator.AnimatorListener animatorListener) {
        if (view.getVisibility() != 0) {
            ViewHelper.o(view, 0.0f);
        }
        float a2 = ViewHelper.a(view);
        ValueAnimator l0 = ValueAnimator.l0(a2, 1.0f);
        l0.m((long) ((1.0f - a2) * 200.0f));
        l0.n(new DecelerateInterpolator());
        if (animatorListener != null) {
            l0.a(animatorListener);
        }
        l0.F(new ValueAnimator.AnimatorUpdateListener() {
            public void e(ValueAnimator valueAnimator) {
                ViewHelper.o(view, ((Float) valueAnimator.U()).floatValue());
                if (view.getParent() != null) {
                    ((View) view.getParent()).postInvalidate();
                }
            }
        });
        l0.s();
        return l0;
    }

    public static ValueAnimator f(final View view, Animator.AnimatorListener animatorListener) {
        float a2 = ViewHelper.a(view);
        ValueAnimator l0 = ValueAnimator.l0(a2, 0.0f);
        l0.m((long) (a2 * 200.0f));
        l0.n(new DecelerateInterpolator());
        if (animatorListener != null) {
            l0.a(animatorListener);
        }
        l0.F(new ValueAnimator.AnimatorUpdateListener() {
            public void e(ValueAnimator valueAnimator) {
                ViewHelper.o(view, ((Float) valueAnimator.U()).floatValue());
                if (view.getParent() != null) {
                    ((View) view.getParent()).postInvalidate();
                }
            }
        });
        l0.s();
        return l0;
    }

    public static ValueAnimator g(final View view, Animator.AnimatorListener animatorListener) {
        if (view.getVisibility() != 0) {
            ViewHelper.o(view, 0.0f);
        }
        float a2 = ViewHelper.a(view);
        ValueAnimator l0 = ValueAnimator.l0(a2, 1.0f);
        l0.m((long) ((1.0f - a2) * 200.0f));
        l0.n(new DecelerateInterpolator());
        if (animatorListener != null) {
            l0.a(animatorListener);
        }
        l0.F(new ValueAnimator.AnimatorUpdateListener() {
            public void e(ValueAnimator valueAnimator) {
                ViewHelper.o(view, ((Float) valueAnimator.U()).floatValue());
                View view = view;
                ViewHelper.z(view, Math.min((float) (view.getHeight() / 2), view.getResources().getDimension(R.dimen.f473carbon_1dip) * 50.0f) * (1.0f - ((Float) valueAnimator.U()).floatValue()));
                if (view.getParent() != null) {
                    ((View) view.getParent()).postInvalidate();
                }
            }
        });
        l0.s();
        return l0;
    }

    public static ValueAnimator h(final View view, Animator.AnimatorListener animatorListener) {
        float a2 = ViewHelper.a(view);
        ValueAnimator l0 = ValueAnimator.l0(a2, 0.0f);
        l0.m((long) (a2 * 200.0f));
        l0.n(new DecelerateInterpolator());
        if (animatorListener != null) {
            l0.a(animatorListener);
        }
        l0.F(new ValueAnimator.AnimatorUpdateListener() {
            public void e(ValueAnimator valueAnimator) {
                ViewHelper.o(view, ((Float) valueAnimator.U()).floatValue());
                View view = view;
                ViewHelper.z(view, Math.min((float) (view.getHeight() / 2), view.getResources().getDimension(R.dimen.f473carbon_1dip) * 50.0f) * (1.0f - ((Float) valueAnimator.U()).floatValue()));
                if (view.getParent() != null) {
                    ((View) view.getParent()).postInvalidate();
                }
            }
        });
        l0.s();
        return l0;
    }

    public static float i(float f2, float f3, float f4) {
        return (f3 * (1.0f - f2)) + (f4 * f2);
    }

    public static int j(float f2, int i2, int i3) {
        return Color.argb((int) i(f2, (float) (i2 >> 24), (float) (i3 >> 24)), (int) i(f2, (float) ((i2 >> 16) & 255), (float) ((i3 >> 16) & 255)), (int) i(f2, (float) ((i2 >> 8) & 255), (float) ((i3 >> 8) & 255)), (int) i(f2, (float) (i2 & 255), (float) (i3 & 255)));
    }

    public static ValueAnimator k(final View view, Animator.AnimatorListener animatorListener) {
        if (view.getVisibility() != 0) {
            ViewHelper.o(view, 0.0f);
        }
        float a2 = ViewHelper.a(view);
        ValueAnimator l0 = ValueAnimator.l0(a2, 1.0f);
        l0.m((long) ((1.0f - a2) * 200.0f));
        l0.n(new DecelerateInterpolator());
        if (animatorListener != null) {
            l0.a(animatorListener);
        }
        l0.F(new ValueAnimator.AnimatorUpdateListener() {
            public void e(ValueAnimator valueAnimator) {
                ViewHelper.o(view, ((Float) valueAnimator.U()).floatValue());
                ViewHelper.u(view, ((Float) valueAnimator.U()).floatValue());
                ViewHelper.v(view, ((Float) valueAnimator.U()).floatValue());
                if (view.getParent() != null) {
                    ((View) view.getParent()).postInvalidate();
                }
            }
        });
        l0.s();
        return l0;
    }

    public static ValueAnimator l(final View view, Animator.AnimatorListener animatorListener) {
        float a2 = ViewHelper.a(view);
        ValueAnimator l0 = ValueAnimator.l0(a2, 0.0f);
        l0.m((long) (a2 * 200.0f));
        l0.n(new DecelerateInterpolator());
        if (animatorListener != null) {
            l0.a(animatorListener);
        }
        l0.F(new ValueAnimator.AnimatorUpdateListener() {
            public void e(ValueAnimator valueAnimator) {
                ViewHelper.o(view, ((Float) valueAnimator.U()).floatValue());
                ViewHelper.u(view, ((Float) valueAnimator.U()).floatValue());
                ViewHelper.v(view, ((Float) valueAnimator.U()).floatValue());
                if (view.getParent() != null) {
                    ((View) view.getParent()).postInvalidate();
                }
            }
        });
        l0.s();
        return l0;
    }
}
