package androidx.core.view;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public final class ViewParentCompat {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6525a = "ViewParentCompat";

    /* renamed from: b  reason: collision with root package name */
    private static int[] f6526b;

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static boolean a(ViewParent viewParent, View view, float f2, float f3, boolean z) {
            return viewParent.onNestedFling(view, f2, f3, z);
        }

        @DoNotInline
        static boolean b(ViewParent viewParent, View view, float f2, float f3) {
            return viewParent.onNestedPreFling(view, f2, f3);
        }

        @DoNotInline
        static void c(ViewParent viewParent, View view, int i2, int i3, int[] iArr) {
            viewParent.onNestedPreScroll(view, i2, i3, iArr);
        }

        @DoNotInline
        static void d(ViewParent viewParent, View view, int i2, int i3, int i4, int i5) {
            viewParent.onNestedScroll(view, i2, i3, i4, i5);
        }

        @DoNotInline
        static void e(ViewParent viewParent, View view, View view2, int i2) {
            viewParent.onNestedScrollAccepted(view, view2, i2);
        }

        @DoNotInline
        static boolean f(ViewParent viewParent, View view, View view2, int i2) {
            return viewParent.onStartNestedScroll(view, view2, i2);
        }

        @DoNotInline
        static void g(ViewParent viewParent, View view) {
            viewParent.onStopNestedScroll(view);
        }
    }

    private ViewParentCompat() {
    }

    private static int[] a() {
        int[] iArr = f6526b;
        if (iArr == null) {
            f6526b = new int[2];
        } else {
            iArr[0] = 0;
            iArr[1] = 0;
        }
        return f6526b;
    }

    public static void b(@NonNull ViewParent viewParent, @NonNull View view, @NonNull View view2, int i2) {
        viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i2);
    }

    public static boolean c(@NonNull ViewParent viewParent, @NonNull View view, float f2, float f3, boolean z) {
        try {
            return Api21Impl.a(viewParent, view, f2, f3, z);
        } catch (AbstractMethodError e2) {
            Log.e(f6525a, "ViewParent " + viewParent + " does not implement interface method onNestedFling", e2);
            return false;
        }
    }

    public static boolean d(@NonNull ViewParent viewParent, @NonNull View view, float f2, float f3) {
        try {
            return Api21Impl.b(viewParent, view, f2, f3);
        } catch (AbstractMethodError e2) {
            Log.e(f6525a, "ViewParent " + viewParent + " does not implement interface method onNestedPreFling", e2);
            return false;
        }
    }

    public static void e(@NonNull ViewParent viewParent, @NonNull View view, int i2, int i3, @NonNull int[] iArr) {
        f(viewParent, view, i2, i3, iArr, 0);
    }

    public static void f(@NonNull ViewParent viewParent, @NonNull View view, int i2, int i3, @NonNull int[] iArr, int i4) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).u(view, i2, i3, iArr, i4);
        } else if (i4 == 0) {
            try {
                Api21Impl.c(viewParent, view, i2, i3, iArr);
            } catch (AbstractMethodError e2) {
                Log.e(f6525a, "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e2);
            }
        }
    }

    public static void g(@NonNull ViewParent viewParent, @NonNull View view, int i2, int i3, int i4, int i5) {
        i(viewParent, view, i2, i3, i4, i5, 0, a());
    }

    public static void h(@NonNull ViewParent viewParent, @NonNull View view, int i2, int i3, int i4, int i5, int i6) {
        i(viewParent, view, i2, i3, i4, i5, i6, a());
    }

    public static void i(@NonNull ViewParent viewParent, @NonNull View view, int i2, int i3, int i4, int i5, int i6, @NonNull int[] iArr) {
        ViewParent viewParent2 = viewParent;
        if (viewParent2 instanceof NestedScrollingParent3) {
            ((NestedScrollingParent3) viewParent2).g(view, i2, i3, i4, i5, i6, iArr);
            return;
        }
        iArr[0] = iArr[0] + i4;
        iArr[1] = iArr[1] + i5;
        if (viewParent2 instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent2).q(view, i2, i3, i4, i5, i6);
        } else if (i6 == 0) {
            try {
                Api21Impl.d(viewParent, view, i2, i3, i4, i5);
            } catch (AbstractMethodError e2) {
                AbstractMethodError abstractMethodError = e2;
                Log.e(f6525a, "ViewParent " + viewParent + " does not implement interface method onNestedScroll", abstractMethodError);
            }
        }
    }

    public static void j(@NonNull ViewParent viewParent, @NonNull View view, @NonNull View view2, int i2) {
        k(viewParent, view, view2, i2, 0);
    }

    public static void k(@NonNull ViewParent viewParent, @NonNull View view, @NonNull View view2, int i2, int i3) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).s(view, view2, i2, i3);
        } else if (i3 == 0) {
            try {
                Api21Impl.e(viewParent, view, view2, i2);
            } catch (AbstractMethodError e2) {
                Log.e(f6525a, "ViewParent " + viewParent + " does not implement interface method onNestedScrollAccepted", e2);
            }
        }
    }

    public static boolean l(@NonNull ViewParent viewParent, @NonNull View view, @NonNull View view2, int i2) {
        return m(viewParent, view, view2, i2, 0);
    }

    public static boolean m(@NonNull ViewParent viewParent, @NonNull View view, @NonNull View view2, int i2, int i3) {
        if (viewParent instanceof NestedScrollingParent2) {
            return ((NestedScrollingParent2) viewParent).r(view, view2, i2, i3);
        }
        if (i3 != 0) {
            return false;
        }
        try {
            return Api21Impl.f(viewParent, view, view2, i2);
        } catch (AbstractMethodError e2) {
            Log.e(f6525a, "ViewParent " + viewParent + " does not implement interface method onStartNestedScroll", e2);
            return false;
        }
    }

    public static void n(@NonNull ViewParent viewParent, @NonNull View view) {
        o(viewParent, view, 0);
    }

    public static void o(@NonNull ViewParent viewParent, @NonNull View view, int i2) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).t(view, i2);
        } else if (i2 == 0) {
            try {
                Api21Impl.g(viewParent, view);
            } catch (AbstractMethodError e2) {
                Log.e(f6525a, "ViewParent " + viewParent + " does not implement interface method onStopNestedScroll", e2);
            }
        }
    }

    @Deprecated
    public static boolean p(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
        return viewParent.requestSendAccessibilityEvent(view, accessibilityEvent);
    }
}
