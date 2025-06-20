package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.MenuPopupWindow;

final class StandardMenuPopup extends MenuPopup implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, MenuPresenter, View.OnKeyListener {
    private static final int o3 = R.layout.t;
    private final Context X;
    private final boolean X2;
    private final MenuBuilder Y;
    private final int Y2;
    private final MenuAdapter Z;
    private final int Z2;
    private final int a3;
    final MenuPopupWindow b3;
    final ViewTreeObserver.OnGlobalLayoutListener c3 = new ViewTreeObserver.OnGlobalLayoutListener() {
        public void onGlobalLayout() {
            if (StandardMenuPopup.this.b() && !StandardMenuPopup.this.b3.L()) {
                View view = StandardMenuPopup.this.g3;
                if (view == null || !view.isShown()) {
                    StandardMenuPopup.this.dismiss();
                } else {
                    StandardMenuPopup.this.b3.a();
                }
            }
        }
    };
    private final View.OnAttachStateChangeListener d3 = new View.OnAttachStateChangeListener() {
        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = StandardMenuPopup.this.i3;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    StandardMenuPopup.this.i3 = view.getViewTreeObserver();
                }
                StandardMenuPopup standardMenuPopup = StandardMenuPopup.this;
                standardMenuPopup.i3.removeGlobalOnLayoutListener(standardMenuPopup.c3);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    private PopupWindow.OnDismissListener e3;
    private View f3;
    View g3;
    private MenuPresenter.Callback h3;
    ViewTreeObserver i3;
    private boolean j3;
    private boolean k3;
    private int l3;
    private int m3 = 0;
    private boolean n3;

    public StandardMenuPopup(Context context, MenuBuilder menuBuilder, View view, int i2, int i4, boolean z) {
        this.X = context;
        this.Y = menuBuilder;
        this.X2 = z;
        this.Z = new MenuAdapter(menuBuilder, LayoutInflater.from(context), z, o3);
        this.Z2 = i2;
        this.a3 = i4;
        Resources resources = context.getResources();
        this.Y2 = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.x));
        this.f3 = view;
        this.b3 = new MenuPopupWindow(context, (AttributeSet) null, i2, i4);
        menuBuilder.c(this, context);
    }

    private boolean C() {
        View view;
        if (b()) {
            return true;
        }
        if (this.j3 || (view = this.f3) == null) {
            return false;
        }
        this.g3 = view;
        this.b3.e0(this);
        this.b3.f0(this);
        this.b3.d0(true);
        View view2 = this.g3;
        boolean z = this.i3 == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.i3 = viewTreeObserver;
        if (z) {
            viewTreeObserver.addOnGlobalLayoutListener(this.c3);
        }
        view2.addOnAttachStateChangeListener(this.d3);
        this.b3.S(view2);
        this.b3.W(this.m3);
        if (!this.k3) {
            this.l3 = MenuPopup.r(this.Z, (ViewGroup) null, this.X, this.Y2);
            this.k3 = true;
        }
        this.b3.U(this.l3);
        this.b3.a0(2);
        this.b3.X(q());
        this.b3.a();
        ListView k2 = this.b3.k();
        k2.setOnKeyListener(this);
        if (this.n3 && this.Y.A() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.X).inflate(R.layout.s, k2, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            if (textView != null) {
                textView.setText(this.Y.A());
            }
            frameLayout.setEnabled(false);
            k2.addHeaderView(frameLayout, (Object) null, false);
        }
        this.b3.q(this.Z);
        this.b3.a();
        return true;
    }

    public void a() {
        if (!C()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    public boolean b() {
        return !this.j3 && this.b3.b();
    }

    public void c(MenuBuilder menuBuilder, boolean z) {
        if (menuBuilder == this.Y) {
            dismiss();
            MenuPresenter.Callback callback = this.h3;
            if (callback != null) {
                callback.c(menuBuilder, z);
            }
        }
    }

    public void d(boolean z) {
        this.k3 = false;
        MenuAdapter menuAdapter = this.Z;
        if (menuAdapter != null) {
            menuAdapter.notifyDataSetChanged();
        }
    }

    public void dismiss() {
        if (b()) {
            this.b3.dismiss();
        }
    }

    public boolean e() {
        return false;
    }

    public void h(MenuPresenter.Callback callback) {
        this.h3 = callback;
    }

    public void j(Parcelable parcelable) {
    }

    public ListView k() {
        return this.b3.k();
    }

    public boolean l(SubMenuBuilder subMenuBuilder) {
        if (subMenuBuilder.hasVisibleItems()) {
            MenuPopupHelper menuPopupHelper = new MenuPopupHelper(this.X, subMenuBuilder, this.g3, this.X2, this.Z2, this.a3);
            menuPopupHelper.a(this.h3);
            menuPopupHelper.i(MenuPopup.A(subMenuBuilder));
            menuPopupHelper.k(this.e3);
            this.e3 = null;
            this.Y.f(false);
            int d2 = this.b3.d();
            int o = this.b3.o();
            if ((Gravity.getAbsoluteGravity(this.m3, this.f3.getLayoutDirection()) & 7) == 5) {
                d2 += this.f3.getWidth();
            }
            if (menuPopupHelper.p(d2, o)) {
                MenuPresenter.Callback callback = this.h3;
                if (callback == null) {
                    return true;
                }
                callback.d(subMenuBuilder);
                return true;
            }
        }
        return false;
    }

    public Parcelable n() {
        return null;
    }

    public void o(MenuBuilder menuBuilder) {
    }

    public void onDismiss() {
        this.j3 = true;
        this.Y.close();
        ViewTreeObserver viewTreeObserver = this.i3;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.i3 = this.g3.getViewTreeObserver();
            }
            this.i3.removeGlobalOnLayoutListener(this.c3);
            this.i3 = null;
        }
        this.g3.removeOnAttachStateChangeListener(this.d3);
        PopupWindow.OnDismissListener onDismissListener = this.e3;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i2 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    public void s(View view) {
        this.f3 = view;
    }

    public void u(boolean z) {
        this.Z.e(z);
    }

    public void v(int i2) {
        this.m3 = i2;
    }

    public void w(int i2) {
        this.b3.f(i2);
    }

    public void x(PopupWindow.OnDismissListener onDismissListener) {
        this.e3 = onDismissListener;
    }

    public void y(boolean z) {
        this.n3 = z;
    }

    public void z(int i2) {
        this.b3.l(i2);
    }
}
