package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.view.GravityCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MenuPopupHelper implements MenuHelper {

    /* renamed from: m  reason: collision with root package name */
    private static final int f2978m = 48;

    /* renamed from: a  reason: collision with root package name */
    private final Context f2979a;

    /* renamed from: b  reason: collision with root package name */
    private final MenuBuilder f2980b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f2981c;

    /* renamed from: d  reason: collision with root package name */
    private final int f2982d;

    /* renamed from: e  reason: collision with root package name */
    private final int f2983e;

    /* renamed from: f  reason: collision with root package name */
    private View f2984f;

    /* renamed from: g  reason: collision with root package name */
    private int f2985g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f2986h;

    /* renamed from: i  reason: collision with root package name */
    private MenuPresenter.Callback f2987i;

    /* renamed from: j  reason: collision with root package name */
    private MenuPopup f2988j;

    /* renamed from: k  reason: collision with root package name */
    private PopupWindow.OnDismissListener f2989k;

    /* renamed from: l  reason: collision with root package name */
    private final PopupWindow.OnDismissListener f2990l;

    public MenuPopupHelper(@NonNull Context context, @NonNull MenuBuilder menuBuilder) {
        this(context, menuBuilder, (View) null, false, R.attr.z2, 0);
    }

    /* JADX WARNING: type inference failed for: r0v6, types: [androidx.appcompat.view.menu.MenuPopup, androidx.appcompat.view.menu.MenuPresenter] */
    /* JADX WARNING: type inference failed for: r8v1, types: [androidx.appcompat.view.menu.StandardMenuPopup] */
    /* JADX WARNING: type inference failed for: r2v2, types: [androidx.appcompat.view.menu.CascadingMenuPopup] */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private androidx.appcompat.view.menu.MenuPopup b() {
        /*
            r15 = this;
            android.content.Context r0 = r15.f2979a
            java.lang.String r1 = "window"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            android.view.Display r0 = r0.getDefaultDisplay()
            android.graphics.Point r1 = new android.graphics.Point
            r1.<init>()
            r0.getRealSize(r1)
            int r0 = r1.x
            int r1 = r1.y
            int r0 = java.lang.Math.min(r0, r1)
            android.content.Context r1 = r15.f2979a
            android.content.res.Resources r1 = r1.getResources()
            int r2 = androidx.appcompat.R.dimen.w
            int r1 = r1.getDimensionPixelSize(r2)
            if (r0 < r1) goto L_0x003d
            androidx.appcompat.view.menu.CascadingMenuPopup r0 = new androidx.appcompat.view.menu.CascadingMenuPopup
            android.content.Context r3 = r15.f2979a
            android.view.View r4 = r15.f2984f
            int r5 = r15.f2982d
            int r6 = r15.f2983e
            boolean r7 = r15.f2981c
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            goto L_0x004f
        L_0x003d:
            androidx.appcompat.view.menu.StandardMenuPopup r0 = new androidx.appcompat.view.menu.StandardMenuPopup
            android.content.Context r9 = r15.f2979a
            androidx.appcompat.view.menu.MenuBuilder r10 = r15.f2980b
            android.view.View r11 = r15.f2984f
            int r12 = r15.f2982d
            int r13 = r15.f2983e
            boolean r14 = r15.f2981c
            r8 = r0
            r8.<init>(r9, r10, r11, r12, r13, r14)
        L_0x004f:
            androidx.appcompat.view.menu.MenuBuilder r1 = r15.f2980b
            r0.o(r1)
            android.widget.PopupWindow$OnDismissListener r1 = r15.f2990l
            r0.x(r1)
            android.view.View r1 = r15.f2984f
            r0.s(r1)
            androidx.appcompat.view.menu.MenuPresenter$Callback r1 = r15.f2987i
            r0.h(r1)
            boolean r1 = r15.f2986h
            r0.u(r1)
            int r1 = r15.f2985g
            r0.v(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.MenuPopupHelper.b():androidx.appcompat.view.menu.MenuPopup");
    }

    private void n(int i2, int i3, boolean z, boolean z2) {
        MenuPopup e2 = e();
        e2.y(z2);
        if (z) {
            if ((GravityCompat.d(this.f2985g, this.f2984f.getLayoutDirection()) & 7) == 5) {
                i2 -= this.f2984f.getWidth();
            }
            e2.w(i2);
            e2.z(i3);
            int i4 = (int) ((this.f2979a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            e2.t(new Rect(i2 - i4, i3 - i4, i2 + i4, i3 + i4));
        }
        e2.a();
    }

    public void a(@Nullable MenuPresenter.Callback callback) {
        this.f2987i = callback;
        MenuPopup menuPopup = this.f2988j;
        if (menuPopup != null) {
            menuPopup.h(callback);
        }
    }

    public int c() {
        return this.f2985g;
    }

    public ListView d() {
        return e().k();
    }

    public void dismiss() {
        if (f()) {
            this.f2988j.dismiss();
        }
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public MenuPopup e() {
        if (this.f2988j == null) {
            this.f2988j = b();
        }
        return this.f2988j;
    }

    public boolean f() {
        MenuPopup menuPopup = this.f2988j;
        return menuPopup != null && menuPopup.b();
    }

    /* access modifiers changed from: protected */
    public void g() {
        this.f2988j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f2989k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void h(@NonNull View view) {
        this.f2984f = view;
    }

    public void i(boolean z) {
        this.f2986h = z;
        MenuPopup menuPopup = this.f2988j;
        if (menuPopup != null) {
            menuPopup.u(z);
        }
    }

    public void j(int i2) {
        this.f2985g = i2;
    }

    public void k(@Nullable PopupWindow.OnDismissListener onDismissListener) {
        this.f2989k = onDismissListener;
    }

    public void l() {
        if (!o()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public void m(int i2, int i3) {
        if (!p(i2, i3)) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean o() {
        if (f()) {
            return true;
        }
        if (this.f2984f == null) {
            return false;
        }
        n(0, 0, false, false);
        return true;
    }

    public boolean p(int i2, int i3) {
        if (f()) {
            return true;
        }
        if (this.f2984f == null) {
            return false;
        }
        n(i2, i3, true, true);
        return true;
    }

    public MenuPopupHelper(@NonNull Context context, @NonNull MenuBuilder menuBuilder, @NonNull View view) {
        this(context, menuBuilder, view, false, R.attr.z2, 0);
    }

    public MenuPopupHelper(@NonNull Context context, @NonNull MenuBuilder menuBuilder, @NonNull View view, boolean z, @AttrRes int i2) {
        this(context, menuBuilder, view, z, i2, 0);
    }

    public MenuPopupHelper(@NonNull Context context, @NonNull MenuBuilder menuBuilder, @NonNull View view, boolean z, @AttrRes int i2, @StyleRes int i3) {
        this.f2985g = GravityCompat.f6387b;
        this.f2990l = new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                MenuPopupHelper.this.g();
            }
        };
        this.f2979a = context;
        this.f2980b = menuBuilder;
        this.f2984f = view;
        this.f2981c = z;
        this.f2982d = i2;
        this.f2983e = i3;
    }
}
