package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.google.android.material.R;
import com.google.android.material.drawable.DrawableUtils;
import java.util.ArrayList;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ViewUtils {
    @RequiresApi(16)

    /* renamed from: a  reason: collision with root package name */
    public static final int f21582a = 768;

    public interface OnApplyWindowInsetsListener {
        WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat, RelativePadding relativePadding);
    }

    public static class RelativePadding {

        /* renamed from: a  reason: collision with root package name */
        public int f21589a;

        /* renamed from: b  reason: collision with root package name */
        public int f21590b;

        /* renamed from: c  reason: collision with root package name */
        public int f21591c;

        /* renamed from: d  reason: collision with root package name */
        public int f21592d;

        public RelativePadding(int i2, int i3, int i4, int i5) {
            this.f21589a = i2;
            this.f21590b = i3;
            this.f21591c = i4;
            this.f21592d = i5;
        }

        public void a(View view) {
            ViewCompat.n2(view, this.f21589a, this.f21590b, this.f21591c, this.f21592d);
        }

        public RelativePadding(@NonNull RelativePadding relativePadding) {
            this.f21589a = relativePadding.f21589a;
            this.f21590b = relativePadding.f21590b;
            this.f21591c = relativePadding.f21591c;
            this.f21592d = relativePadding.f21592d;
        }
    }

    private ViewUtils() {
    }

    public static void A(@NonNull View view, @NonNull Rect rect) {
        view.setLeft(rect.left);
        view.setTop(rect.top);
        view.setRight(rect.right);
        view.setBottom(rect.bottom);
    }

    public static void B(@NonNull View view) {
        C(view, true);
    }

    public static void C(@NonNull View view, boolean z) {
        WindowInsetsControllerCompat E0;
        if (!z || (E0 = ViewCompat.E0(view)) == null) {
            n(view).showSoftInput(view, 1);
        } else {
            E0.k(WindowInsetsCompat.Type.d());
        }
    }

    public static void b(@Nullable View view, @NonNull ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (view != null) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    @NonNull
    public static Rect c(@NonNull View view, @NonNull View view2) {
        int[] iArr = new int[2];
        view2.getLocationOnScreen(iArr);
        int i2 = iArr[0];
        int i3 = iArr[1];
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int i4 = i2 - iArr2[0];
        int i5 = i3 - iArr2[1];
        return new Rect(i4, i5, view2.getWidth() + i4, view2.getHeight() + i5);
    }

    @NonNull
    public static Rect d(@NonNull View view) {
        return e(view, 0);
    }

    @NonNull
    public static Rect e(@NonNull View view, int i2) {
        return new Rect(view.getLeft(), view.getTop() + i2, view.getRight(), view.getBottom() + i2);
    }

    public static void f(@NonNull View view, @Nullable AttributeSet attributeSet, int i2, int i3) {
        g(view, attributeSet, i2, i3, (OnApplyWindowInsetsListener) null);
    }

    public static void g(@NonNull View view, @Nullable AttributeSet attributeSet, int i2, int i3, @Nullable final OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        TypedArray obtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, R.styleable.Rh, i2, i3);
        final boolean z = obtainStyledAttributes.getBoolean(R.styleable.Vh, false);
        final boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.Wh, false);
        final boolean z3 = obtainStyledAttributes.getBoolean(R.styleable.Xh, false);
        obtainStyledAttributes.recycle();
        h(view, new OnApplyWindowInsetsListener() {
            @NonNull
            public WindowInsetsCompat a(View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull RelativePadding relativePadding) {
                if (z) {
                    relativePadding.f21592d += windowInsetsCompat.o();
                }
                boolean s = ViewUtils.s(view);
                if (z2) {
                    if (s) {
                        relativePadding.f21591c += windowInsetsCompat.p();
                    } else {
                        relativePadding.f21589a += windowInsetsCompat.p();
                    }
                }
                if (z3) {
                    if (s) {
                        relativePadding.f21589a += windowInsetsCompat.q();
                    } else {
                        relativePadding.f21591c += windowInsetsCompat.q();
                    }
                }
                relativePadding.a(view);
                OnApplyWindowInsetsListener onApplyWindowInsetsListener = onApplyWindowInsetsListener;
                return onApplyWindowInsetsListener != null ? onApplyWindowInsetsListener.a(view, windowInsetsCompat, relativePadding) : windowInsetsCompat;
            }
        });
    }

    public static void h(@NonNull View view, @NonNull final OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        final RelativePadding relativePadding = new RelativePadding(ViewCompat.n0(view), view.getPaddingTop(), ViewCompat.m0(view), view.getPaddingBottom());
        ViewCompat.k2(view, new androidx.core.view.OnApplyWindowInsetsListener() {
            public WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat) {
                return OnApplyWindowInsetsListener.this.a(view, windowInsetsCompat, new RelativePadding(relativePadding));
            }
        });
        x(view);
    }

    public static float i(@NonNull Context context, @Dimension(unit = 0) int i2) {
        return TypedValue.applyDimension(1, (float) i2, context.getResources().getDisplayMetrics());
    }

    @Nullable
    public static Integer j(@NonNull View view) {
        ColorStateList g2 = DrawableUtils.g(view.getBackground());
        if (g2 != null) {
            return Integer.valueOf(g2.getDefaultColor());
        }
        return null;
    }

    @NonNull
    public static List<View> k(@Nullable View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                arrayList.add(viewGroup.getChildAt(i2));
            }
        }
        return arrayList;
    }

    @Nullable
    public static ViewGroup l(@Nullable View view) {
        if (view == null) {
            return null;
        }
        View rootView = view.getRootView();
        ViewGroup viewGroup = (ViewGroup) rootView.findViewById(16908290);
        if (viewGroup != null) {
            return viewGroup;
        }
        if (rootView == view || !(rootView instanceof ViewGroup)) {
            return null;
        }
        return (ViewGroup) rootView;
    }

    @Nullable
    public static ViewOverlayImpl m(@NonNull View view) {
        return o(l(view));
    }

    @Nullable
    private static InputMethodManager n(@NonNull View view) {
        return (InputMethodManager) ContextCompat.s(view.getContext(), InputMethodManager.class);
    }

    @Nullable
    public static ViewOverlayImpl o(@Nullable View view) {
        if (view == null) {
            return null;
        }
        return new ViewOverlayApi18(view);
    }

    public static float p(@NonNull View view) {
        float f2 = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            f2 += ViewCompat.T((View) parent);
        }
        return f2;
    }

    public static void q(@NonNull View view) {
        r(view, true);
    }

    public static void r(@NonNull View view, boolean z) {
        WindowInsetsControllerCompat E0;
        if (!z || (E0 = ViewCompat.E0(view)) == null) {
            InputMethodManager n2 = n(view);
            if (n2 != null) {
                n2.hideSoftInputFromWindow(view.getWindowToken(), 0);
                return;
            }
            return;
        }
        E0.d(WindowInsetsCompat.Type.d());
    }

    public static boolean s(View view) {
        return ViewCompat.c0(view) == 1;
    }

    public static PorterDuff.Mode u(int i2, PorterDuff.Mode mode) {
        if (i2 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i2 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i2 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i2) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public static void v(@Nullable View view, @NonNull ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (view != null) {
            w(view.getViewTreeObserver(), onGlobalLayoutListener);
        }
    }

    public static void w(@NonNull ViewTreeObserver viewTreeObserver, @NonNull ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    public static void x(@NonNull View view) {
        if (ViewCompat.R0(view)) {
            ViewCompat.B1(view);
        } else {
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                public void onViewAttachedToWindow(@NonNull View view) {
                    view.removeOnAttachStateChangeListener(this);
                    ViewCompat.B1(view);
                }

                public void onViewDetachedFromWindow(View view) {
                }
            });
        }
    }

    public static void y(@NonNull View view) {
        z(view, true);
    }

    public static void z(@NonNull View view, boolean z) {
        view.requestFocus();
        view.post(new k(view, z));
    }
}
