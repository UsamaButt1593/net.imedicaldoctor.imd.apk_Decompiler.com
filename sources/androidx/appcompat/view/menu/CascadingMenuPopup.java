package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.MenuItemHoverListener;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.GravityCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

final class CascadingMenuPopup extends MenuPopup implements MenuPresenter, View.OnKeyListener, PopupWindow.OnDismissListener {
    private static final int u3 = R.layout.f2645l;
    static final int v3 = 0;
    static final int w3 = 1;
    static final int x3 = 200;
    private final Context X;
    private final int X2;
    private final int Y;
    private final boolean Y2;
    private final int Z;
    final Handler Z2;
    private final List<MenuBuilder> a3 = new ArrayList();
    final List<CascadingMenuInfo> b3 = new ArrayList();
    final ViewTreeObserver.OnGlobalLayoutListener c3 = new ViewTreeObserver.OnGlobalLayoutListener() {
        public void onGlobalLayout() {
            if (CascadingMenuPopup.this.b() && CascadingMenuPopup.this.b3.size() > 0 && !CascadingMenuPopup.this.b3.get(0).f2961a.L()) {
                View view = CascadingMenuPopup.this.i3;
                if (view == null || !view.isShown()) {
                    CascadingMenuPopup.this.dismiss();
                    return;
                }
                for (CascadingMenuInfo cascadingMenuInfo : CascadingMenuPopup.this.b3) {
                    cascadingMenuInfo.f2961a.a();
                }
            }
        }
    };
    private final View.OnAttachStateChangeListener d3 = new View.OnAttachStateChangeListener() {
        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = CascadingMenuPopup.this.r3;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    CascadingMenuPopup.this.r3 = view.getViewTreeObserver();
                }
                CascadingMenuPopup cascadingMenuPopup = CascadingMenuPopup.this;
                cascadingMenuPopup.r3.removeGlobalOnLayoutListener(cascadingMenuPopup.c3);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    private final MenuItemHoverListener e3 = new MenuItemHoverListener() {
        public void e(@NonNull final MenuBuilder menuBuilder, @NonNull final MenuItem menuItem) {
            final CascadingMenuInfo cascadingMenuInfo = null;
            CascadingMenuPopup.this.Z2.removeCallbacksAndMessages((Object) null);
            int size = CascadingMenuPopup.this.b3.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                } else if (menuBuilder == CascadingMenuPopup.this.b3.get(i2).f2962b) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 != -1) {
                int i3 = i2 + 1;
                if (i3 < CascadingMenuPopup.this.b3.size()) {
                    cascadingMenuInfo = CascadingMenuPopup.this.b3.get(i3);
                }
                CascadingMenuPopup.this.Z2.postAtTime(new Runnable() {
                    public void run() {
                        CascadingMenuInfo cascadingMenuInfo = cascadingMenuInfo;
                        if (cascadingMenuInfo != null) {
                            CascadingMenuPopup.this.t3 = true;
                            cascadingMenuInfo.f2962b.f(false);
                            CascadingMenuPopup.this.t3 = false;
                        }
                        if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                            menuBuilder.P(menuItem, 4);
                        }
                    }
                }, menuBuilder, SystemClock.uptimeMillis() + 200);
            }
        }

        public void h(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
            CascadingMenuPopup.this.Z2.removeCallbacksAndMessages(menuBuilder);
        }
    };
    private int f3 = 0;
    private int g3 = 0;
    private View h3;
    View i3;
    private int j3;
    private boolean k3;
    private boolean l3;
    private int m3;
    private int n3;
    private boolean o3;
    private boolean p3;
    private MenuPresenter.Callback q3;
    ViewTreeObserver r3;
    private PopupWindow.OnDismissListener s3;
    boolean t3;

    private static class CascadingMenuInfo {

        /* renamed from: a  reason: collision with root package name */
        public final MenuPopupWindow f2961a;

        /* renamed from: b  reason: collision with root package name */
        public final MenuBuilder f2962b;

        /* renamed from: c  reason: collision with root package name */
        public final int f2963c;

        public CascadingMenuInfo(@NonNull MenuPopupWindow menuPopupWindow, @NonNull MenuBuilder menuBuilder, int i2) {
            this.f2961a = menuPopupWindow;
            this.f2962b = menuBuilder;
            this.f2963c = i2;
        }

        public ListView a() {
            return this.f2961a.k();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface HorizPosition {
    }

    public CascadingMenuPopup(@NonNull Context context, @NonNull View view, @AttrRes int i2, @StyleRes int i4, boolean z) {
        this.X = context;
        this.h3 = view;
        this.Z = i2;
        this.X2 = i4;
        this.Y2 = z;
        this.o3 = false;
        this.j3 = G();
        Resources resources = context.getResources();
        this.Y = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.x));
        this.Z2 = new Handler();
    }

    private MenuPopupWindow C() {
        MenuPopupWindow menuPopupWindow = new MenuPopupWindow(this.X, (AttributeSet) null, this.Z, this.X2);
        menuPopupWindow.r0(this.e3);
        menuPopupWindow.f0(this);
        menuPopupWindow.e0(this);
        menuPopupWindow.S(this.h3);
        menuPopupWindow.W(this.g3);
        menuPopupWindow.d0(true);
        menuPopupWindow.a0(2);
        return menuPopupWindow;
    }

    private int D(@NonNull MenuBuilder menuBuilder) {
        int size = this.b3.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (menuBuilder == this.b3.get(i2).f2962b) {
                return i2;
            }
        }
        return -1;
    }

    private MenuItem E(@NonNull MenuBuilder menuBuilder, @NonNull MenuBuilder menuBuilder2) {
        int size = menuBuilder.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = menuBuilder.getItem(i2);
            if (item.hasSubMenu() && menuBuilder2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    @Nullable
    private View F(@NonNull CascadingMenuInfo cascadingMenuInfo, @NonNull MenuBuilder menuBuilder) {
        int i2;
        MenuAdapter menuAdapter;
        int firstVisiblePosition;
        MenuItem E = E(cascadingMenuInfo.f2962b, menuBuilder);
        if (E == null) {
            return null;
        }
        ListView a2 = cascadingMenuInfo.a();
        ListAdapter adapter = a2.getAdapter();
        int i4 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i2 = headerViewListAdapter.getHeadersCount();
            menuAdapter = (MenuAdapter) headerViewListAdapter.getWrappedAdapter();
        } else {
            menuAdapter = (MenuAdapter) adapter;
            i2 = 0;
        }
        int count = menuAdapter.getCount();
        while (true) {
            if (i4 >= count) {
                i4 = -1;
                break;
            } else if (E == menuAdapter.getItem(i4)) {
                break;
            } else {
                i4++;
            }
        }
        if (i4 != -1 && (firstVisiblePosition = (i4 + i2) - a2.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < a2.getChildCount()) {
            return a2.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    private int G() {
        return this.h3.getLayoutDirection() == 1 ? 0 : 1;
    }

    private int H(int i2) {
        List<CascadingMenuInfo> list = this.b3;
        ListView a2 = list.get(list.size() - 1).a();
        int[] iArr = new int[2];
        a2.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.i3.getWindowVisibleDisplayFrame(rect);
        return this.j3 == 1 ? (iArr[0] + a2.getWidth()) + i2 > rect.right ? 0 : 1 : iArr[0] - i2 < 0 ? 1 : 0;
    }

    private void I(@NonNull MenuBuilder menuBuilder) {
        View view;
        CascadingMenuInfo cascadingMenuInfo;
        int i2;
        int i4;
        int i5;
        LayoutInflater from = LayoutInflater.from(this.X);
        MenuAdapter menuAdapter = new MenuAdapter(menuBuilder, from, this.Y2, u3);
        if (!b() && this.o3) {
            menuAdapter.e(true);
        } else if (b()) {
            menuAdapter.e(MenuPopup.A(menuBuilder));
        }
        int r = MenuPopup.r(menuAdapter, (ViewGroup) null, this.X, this.Y);
        MenuPopupWindow C = C();
        C.q(menuAdapter);
        C.U(r);
        C.W(this.g3);
        if (this.b3.size() > 0) {
            List<CascadingMenuInfo> list = this.b3;
            cascadingMenuInfo = list.get(list.size() - 1);
            view = F(cascadingMenuInfo, menuBuilder);
        } else {
            cascadingMenuInfo = null;
            view = null;
        }
        if (view != null) {
            C.s0(false);
            C.p0((Object) null);
            int H = H(r);
            boolean z = H == 1;
            this.j3 = H;
            if (Build.VERSION.SDK_INT >= 26) {
                C.S(view);
                i4 = 0;
                i2 = 0;
            } else {
                int[] iArr = new int[2];
                this.h3.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.g3 & 7) == 5) {
                    iArr[0] = iArr[0] + this.h3.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i2 = iArr2[0] - iArr[0];
                i4 = iArr2[1] - iArr[1];
            }
            if ((this.g3 & 5) != 5) {
                if (z) {
                    r = view.getWidth();
                }
                i5 = i2 - r;
                C.f(i5);
                C.h0(true);
                C.l(i4);
            } else if (!z) {
                r = view.getWidth();
                i5 = i2 - r;
                C.f(i5);
                C.h0(true);
                C.l(i4);
            }
            i5 = i2 + r;
            C.f(i5);
            C.h0(true);
            C.l(i4);
        } else {
            if (this.k3) {
                C.f(this.m3);
            }
            if (this.l3) {
                C.l(this.n3);
            }
            C.X(q());
        }
        this.b3.add(new CascadingMenuInfo(C, menuBuilder, this.j3));
        C.a();
        ListView k2 = C.k();
        k2.setOnKeyListener(this);
        if (cascadingMenuInfo == null && this.p3 && menuBuilder.A() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(R.layout.s, k2, false);
            frameLayout.setEnabled(false);
            ((TextView) frameLayout.findViewById(16908310)).setText(menuBuilder.A());
            k2.addHeaderView(frameLayout, (Object) null, false);
            C.a();
        }
    }

    public void a() {
        if (!b()) {
            for (MenuBuilder I : this.a3) {
                I(I);
            }
            this.a3.clear();
            View view = this.h3;
            this.i3 = view;
            if (view != null) {
                boolean z = this.r3 == null;
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                this.r3 = viewTreeObserver;
                if (z) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.c3);
                }
                this.i3.addOnAttachStateChangeListener(this.d3);
            }
        }
    }

    public boolean b() {
        return this.b3.size() > 0 && this.b3.get(0).f2961a.b();
    }

    public void c(MenuBuilder menuBuilder, boolean z) {
        int D = D(menuBuilder);
        if (D >= 0) {
            int i2 = D + 1;
            if (i2 < this.b3.size()) {
                this.b3.get(i2).f2962b.f(false);
            }
            CascadingMenuInfo remove = this.b3.remove(D);
            remove.f2962b.T(this);
            if (this.t3) {
                remove.f2961a.q0((Object) null);
                remove.f2961a.T(0);
            }
            remove.f2961a.dismiss();
            int size = this.b3.size();
            this.j3 = size > 0 ? this.b3.get(size - 1).f2963c : G();
            if (size == 0) {
                dismiss();
                MenuPresenter.Callback callback = this.q3;
                if (callback != null) {
                    callback.c(menuBuilder, true);
                }
                ViewTreeObserver viewTreeObserver = this.r3;
                if (viewTreeObserver != null) {
                    if (viewTreeObserver.isAlive()) {
                        this.r3.removeGlobalOnLayoutListener(this.c3);
                    }
                    this.r3 = null;
                }
                this.i3.removeOnAttachStateChangeListener(this.d3);
                this.s3.onDismiss();
            } else if (z) {
                this.b3.get(0).f2962b.f(false);
            }
        }
    }

    public void d(boolean z) {
        for (CascadingMenuInfo a2 : this.b3) {
            MenuPopup.B(a2.a().getAdapter()).notifyDataSetChanged();
        }
    }

    public void dismiss() {
        int size = this.b3.size();
        if (size > 0) {
            CascadingMenuInfo[] cascadingMenuInfoArr = (CascadingMenuInfo[]) this.b3.toArray(new CascadingMenuInfo[size]);
            for (int i2 = size - 1; i2 >= 0; i2--) {
                CascadingMenuInfo cascadingMenuInfo = cascadingMenuInfoArr[i2];
                if (cascadingMenuInfo.f2961a.b()) {
                    cascadingMenuInfo.f2961a.dismiss();
                }
            }
        }
    }

    public boolean e() {
        return false;
    }

    public void h(MenuPresenter.Callback callback) {
        this.q3 = callback;
    }

    public void j(Parcelable parcelable) {
    }

    public ListView k() {
        if (this.b3.isEmpty()) {
            return null;
        }
        List<CascadingMenuInfo> list = this.b3;
        return list.get(list.size() - 1).a();
    }

    public boolean l(SubMenuBuilder subMenuBuilder) {
        for (CascadingMenuInfo next : this.b3) {
            if (subMenuBuilder == next.f2962b) {
                next.a().requestFocus();
                return true;
            }
        }
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        o(subMenuBuilder);
        MenuPresenter.Callback callback = this.q3;
        if (callback != null) {
            callback.d(subMenuBuilder);
        }
        return true;
    }

    public Parcelable n() {
        return null;
    }

    public void o(MenuBuilder menuBuilder) {
        menuBuilder.c(this, this.X);
        if (b()) {
            I(menuBuilder);
        } else {
            this.a3.add(menuBuilder);
        }
    }

    public void onDismiss() {
        CascadingMenuInfo cascadingMenuInfo;
        int size = this.b3.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                cascadingMenuInfo = null;
                break;
            }
            cascadingMenuInfo = this.b3.get(i2);
            if (!cascadingMenuInfo.f2961a.b()) {
                break;
            }
            i2++;
        }
        if (cascadingMenuInfo != null) {
            cascadingMenuInfo.f2962b.f(false);
        }
    }

    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i2 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean p() {
        return false;
    }

    public void s(@NonNull View view) {
        if (this.h3 != view) {
            this.h3 = view;
            this.g3 = GravityCompat.d(this.f3, view.getLayoutDirection());
        }
    }

    public void u(boolean z) {
        this.o3 = z;
    }

    public void v(int i2) {
        if (this.f3 != i2) {
            this.f3 = i2;
            this.g3 = GravityCompat.d(i2, this.h3.getLayoutDirection());
        }
    }

    public void w(int i2) {
        this.k3 = true;
        this.m3 = i2;
    }

    public void x(PopupWindow.OnDismissListener onDismissListener) {
        this.s3 = onDismissListener;
    }

    public void y(boolean z) {
        this.p3 = z;
    }

    public void z(int i2) {
        this.l3 = true;
        this.n3 = i2;
    }
}
