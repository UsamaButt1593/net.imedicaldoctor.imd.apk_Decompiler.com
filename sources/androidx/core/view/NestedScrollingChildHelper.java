package androidx.core.view;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class NestedScrollingChildHelper {

    /* renamed from: a  reason: collision with root package name */
    private ViewParent f6455a;

    /* renamed from: b  reason: collision with root package name */
    private ViewParent f6456b;

    /* renamed from: c  reason: collision with root package name */
    private final View f6457c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f6458d;

    /* renamed from: e  reason: collision with root package name */
    private int[] f6459e;

    public NestedScrollingChildHelper(@NonNull View view) {
        this.f6457c = view;
    }

    private boolean h(int i2, int i3, int i4, int i5, @Nullable int[] iArr, int i6, @Nullable int[] iArr2) {
        ViewParent i7;
        int i8;
        int i9;
        int[] iArr3;
        int[] iArr4 = iArr;
        if (!m() || (i7 = i(i6)) == null) {
            return false;
        }
        if (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) {
            if (iArr4 != null) {
                iArr4[0] = 0;
                iArr4[1] = 0;
            }
            return false;
        }
        if (iArr4 != null) {
            this.f6457c.getLocationInWindow(iArr4);
            i9 = iArr4[0];
            i8 = iArr4[1];
        } else {
            i9 = 0;
            i8 = 0;
        }
        if (iArr2 == null) {
            int[] j2 = j();
            j2[0] = 0;
            j2[1] = 0;
            iArr3 = j2;
        } else {
            iArr3 = iArr2;
        }
        ViewParentCompat.i(i7, this.f6457c, i2, i3, i4, i5, i6, iArr3);
        if (iArr4 != null) {
            this.f6457c.getLocationInWindow(iArr4);
            iArr4[0] = iArr4[0] - i9;
            iArr4[1] = iArr4[1] - i8;
        }
        return true;
    }

    private ViewParent i(int i2) {
        if (i2 == 0) {
            return this.f6455a;
        }
        if (i2 != 1) {
            return null;
        }
        return this.f6456b;
    }

    private int[] j() {
        if (this.f6459e == null) {
            this.f6459e = new int[2];
        }
        return this.f6459e;
    }

    private void q(int i2, ViewParent viewParent) {
        if (i2 == 0) {
            this.f6455a = viewParent;
        } else if (i2 == 1) {
            this.f6456b = viewParent;
        }
    }

    public boolean a(float f2, float f3, boolean z) {
        ViewParent i2;
        if (!m() || (i2 = i(0)) == null) {
            return false;
        }
        return ViewParentCompat.c(i2, this.f6457c, f2, f3, z);
    }

    public boolean b(float f2, float f3) {
        ViewParent i2;
        if (!m() || (i2 = i(0)) == null) {
            return false;
        }
        return ViewParentCompat.d(i2, this.f6457c, f2, f3);
    }

    public boolean c(int i2, int i3, @Nullable int[] iArr, @Nullable int[] iArr2) {
        return d(i2, i3, iArr, iArr2, 0);
    }

    public boolean d(int i2, int i3, @Nullable int[] iArr, @Nullable int[] iArr2, int i4) {
        ViewParent i5;
        int i6;
        int i7;
        if (!m() || (i5 = i(i4)) == null) {
            return false;
        }
        if (i2 != 0 || i3 != 0) {
            if (iArr2 != null) {
                this.f6457c.getLocationInWindow(iArr2);
                i7 = iArr2[0];
                i6 = iArr2[1];
            } else {
                i7 = 0;
                i6 = 0;
            }
            if (iArr == null) {
                iArr = j();
            }
            iArr[0] = 0;
            iArr[1] = 0;
            ViewParentCompat.f(i5, this.f6457c, i2, i3, iArr, i4);
            if (iArr2 != null) {
                this.f6457c.getLocationInWindow(iArr2);
                iArr2[0] = iArr2[0] - i7;
                iArr2[1] = iArr2[1] - i6;
            }
            return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
        } else if (iArr2 == null) {
            return false;
        } else {
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
    }

    public void e(int i2, int i3, int i4, int i5, @Nullable int[] iArr, int i6, @Nullable int[] iArr2) {
        h(i2, i3, i4, i5, iArr, i6, iArr2);
    }

    public boolean f(int i2, int i3, int i4, int i5, @Nullable int[] iArr) {
        return h(i2, i3, i4, i5, iArr, 0, (int[]) null);
    }

    public boolean g(int i2, int i3, int i4, int i5, @Nullable int[] iArr, int i6) {
        return h(i2, i3, i4, i5, iArr, i6, (int[]) null);
    }

    public boolean k() {
        return l(0);
    }

    public boolean l(int i2) {
        return i(i2) != null;
    }

    public boolean m() {
        return this.f6458d;
    }

    public void n() {
        ViewCompat.P2(this.f6457c);
    }

    public void o(@NonNull View view) {
        ViewCompat.P2(this.f6457c);
    }

    public void p(boolean z) {
        if (this.f6458d) {
            ViewCompat.P2(this.f6457c);
        }
        this.f6458d = z;
    }

    public boolean r(int i2) {
        return s(i2, 0);
    }

    public boolean s(int i2, int i3) {
        if (l(i3)) {
            return true;
        }
        if (!m()) {
            return false;
        }
        View view = this.f6457c;
        for (ViewParent parent = this.f6457c.getParent(); parent != null; parent = parent.getParent()) {
            if (ViewParentCompat.m(parent, view, this.f6457c, i2, i3)) {
                q(i3, parent);
                ViewParentCompat.k(parent, view, this.f6457c, i2, i3);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    public void t() {
        u(0);
    }

    public void u(int i2) {
        ViewParent i3 = i(i2);
        if (i3 != null) {
            ViewParentCompat.o(i3, this.f6457c, i2);
            q(i2, (ViewParent) null);
        }
    }
}
