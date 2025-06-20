package com.google.android.material.transition.platform;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.transition.PathMotion;
import android.transition.PatternPathMotion;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.PathParser;
import com.google.android.material.canvas.CanvasCompat;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;

@RequiresApi(21)
class TransitionUtils {

    /* renamed from: a  reason: collision with root package name */
    static final int f22227a = -1;
    @AttrRes

    /* renamed from: b  reason: collision with root package name */
    static final int f22228b = 0;

    /* renamed from: c  reason: collision with root package name */
    private static final int f22229c = 0;

    /* renamed from: d  reason: collision with root package name */
    private static final int f22230d = 1;

    /* renamed from: e  reason: collision with root package name */
    private static final RectF f22231e = new RectF();

    interface CornerSizeBinaryOperator {
        @NonNull
        CornerSize a(@NonNull CornerSize cornerSize, @NonNull CornerSize cornerSize2);
    }

    private TransitionUtils() {
    }

    static float b(@NonNull RectF rectF) {
        return rectF.width() * rectF.height();
    }

    static ShapeAppearanceModel c(ShapeAppearanceModel shapeAppearanceModel, RectF rectF) {
        return shapeAppearanceModel.y(new a(rectF));
    }

    static Shader d(@ColorInt int i2) {
        return new LinearGradient(0.0f, 0.0f, 0.0f, 0.0f, i2, i2, Shader.TileMode.CLAMP);
    }

    @NonNull
    static <T> T e(@Nullable T t, @NonNull T t2) {
        return t != null ? t : t2;
    }

    static View f(View view, @IdRes int i2) {
        String resourceName = view.getResources().getResourceName(i2);
        while (view != null) {
            if (view.getId() != i2) {
                ViewParent parent = view.getParent();
                if (!(parent instanceof View)) {
                    break;
                }
                view = (View) parent;
            } else {
                return view;
            }
        }
        throw new IllegalArgumentException(resourceName + " is not a valid ancestor");
    }

    static View g(View view, @IdRes int i2) {
        View findViewById = view.findViewById(i2);
        return findViewById != null ? findViewById : f(view, i2);
    }

    static RectF h(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i2 = iArr[0];
        int i3 = iArr[1];
        return new RectF((float) i2, (float) i3, (float) (view.getWidth() + i2), (float) (view.getHeight() + i3));
    }

    static RectF i(View view) {
        return new RectF((float) view.getLeft(), (float) view.getTop(), (float) view.getRight(), (float) view.getBottom());
    }

    static Rect j(View view) {
        return new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    private static boolean k(ShapeAppearanceModel shapeAppearanceModel, RectF rectF) {
        return (shapeAppearanceModel.r().a(rectF) == 0.0f && shapeAppearanceModel.t().a(rectF) == 0.0f && shapeAppearanceModel.l().a(rectF) == 0.0f && shapeAppearanceModel.j().a(rectF) == 0.0f) ? false : true;
    }

    static float m(float f2, float f3, float f4) {
        return f2 + (f4 * (f3 - f2));
    }

    static float n(float f2, float f3, @FloatRange(from = 0.0d, to = 1.0d) float f4, @FloatRange(from = 0.0d, to = 1.0d) float f5, @FloatRange(from = 0.0d, to = 1.0d) float f6) {
        return o(f2, f3, f4, f5, f6, false);
    }

    static float o(float f2, float f3, @FloatRange(from = 0.0d, to = 1.0d) float f4, @FloatRange(from = 0.0d, to = 1.0d) float f5, @FloatRange(from = 0.0d) float f6, boolean z) {
        if (z && (f6 < 0.0f || f6 > 1.0f)) {
            return m(f2, f3, f6);
        }
        if (f6 < f4) {
            return f2;
        }
        return f6 > f5 ? f3 : m(f2, f3, (f6 - f4) / (f5 - f4));
    }

    static int p(int i2, int i3, @FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3, @FloatRange(from = 0.0d, to = 1.0d) float f4) {
        if (f4 < f2) {
            return i2;
        }
        return f4 > f3 ? i3 : (int) m((float) i2, (float) i3, (f4 - f2) / (f3 - f2));
    }

    static ShapeAppearanceModel q(ShapeAppearanceModel shapeAppearanceModel, ShapeAppearanceModel shapeAppearanceModel2, RectF rectF, RectF rectF2, @FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3, @FloatRange(from = 0.0d, to = 1.0d) float f4) {
        if (f4 < f2) {
            return shapeAppearanceModel;
        }
        if (f4 > f3) {
            return shapeAppearanceModel2;
        }
        final RectF rectF3 = rectF;
        final RectF rectF4 = rectF2;
        final float f5 = f2;
        final float f6 = f3;
        final float f7 = f4;
        return z(shapeAppearanceModel, shapeAppearanceModel2, rectF, new CornerSizeBinaryOperator() {
            @NonNull
            public CornerSize a(@NonNull CornerSize cornerSize, @NonNull CornerSize cornerSize2) {
                return new AbsoluteCornerSize(TransitionUtils.n(cornerSize.a(rectF3), cornerSize2.a(rectF4), f5, f6, f7));
            }
        });
    }

    static void r(TransitionSet transitionSet, @Nullable Transition transition) {
        if (transition != null) {
            transitionSet.addTransition(transition);
        }
    }

    static boolean s(Transition transition, Context context, @AttrRes int i2) {
        int f2;
        if (i2 == 0 || transition.getDuration() != -1 || (f2 = MotionUtils.f(context, i2, -1)) == -1) {
            return false;
        }
        transition.setDuration((long) f2);
        return true;
    }

    static boolean t(Transition transition, Context context, @AttrRes int i2, TimeInterpolator timeInterpolator) {
        if (i2 == 0 || transition.getInterpolator() != null) {
            return false;
        }
        transition.setInterpolator(MotionUtils.g(context, i2, timeInterpolator));
        return true;
    }

    static boolean u(Transition transition, Context context, @AttrRes int i2) {
        PathMotion w;
        if (i2 == 0 || (w = w(context, i2)) == null) {
            return false;
        }
        transition.setPathMotion(w);
        return true;
    }

    static void v(TransitionSet transitionSet, @Nullable Transition transition) {
        if (transition != null) {
            transitionSet.removeTransition(transition);
        }
    }

    @Nullable
    static PathMotion w(Context context, @AttrRes int i2) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i2, typedValue, true)) {
            return null;
        }
        int i3 = typedValue.type;
        if (i3 == 16) {
            int i4 = typedValue.data;
            if (i4 == 0) {
                return null;
            }
            if (i4 == 1) {
                return new MaterialArcMotion();
            }
            throw new IllegalArgumentException("Invalid motion path type: " + i4);
        } else if (i3 == 3) {
            return new PatternPathMotion(PathParser.e(String.valueOf(typedValue.string)));
        } else {
            throw new IllegalArgumentException("Motion path theme attribute must either be an enum value or path data string");
        }
    }

    private static int x(Canvas canvas, Rect rect, int i2) {
        RectF rectF = f22231e;
        rectF.set(rect);
        return canvas.saveLayerAlpha(rectF, i2);
    }

    static void y(Canvas canvas, Rect rect, float f2, float f3, float f4, int i2, CanvasCompat.CanvasOperation canvasOperation) {
        if (i2 > 0) {
            int save = canvas.save();
            canvas.translate(f2, f3);
            canvas.scale(f4, f4);
            if (i2 < 255) {
                x(canvas, rect, i2);
            }
            canvasOperation.a(canvas);
            canvas.restoreToCount(save);
        }
    }

    static ShapeAppearanceModel z(ShapeAppearanceModel shapeAppearanceModel, ShapeAppearanceModel shapeAppearanceModel2, RectF rectF, CornerSizeBinaryOperator cornerSizeBinaryOperator) {
        return (k(shapeAppearanceModel, rectF) ? shapeAppearanceModel : shapeAppearanceModel2).v().L(cornerSizeBinaryOperator.a(shapeAppearanceModel.r(), shapeAppearanceModel2.r())).Q(cornerSizeBinaryOperator.a(shapeAppearanceModel.t(), shapeAppearanceModel2.t())).y(cornerSizeBinaryOperator.a(shapeAppearanceModel.j(), shapeAppearanceModel2.j())).D(cornerSizeBinaryOperator.a(shapeAppearanceModel.l(), shapeAppearanceModel2.l())).m();
    }
}
