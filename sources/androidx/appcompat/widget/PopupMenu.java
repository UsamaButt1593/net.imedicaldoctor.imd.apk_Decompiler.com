package androidx.appcompat.widget;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.ShowableListMenu;

public class PopupMenu {

    /* renamed from: a  reason: collision with root package name */
    private final Context f3217a;

    /* renamed from: b  reason: collision with root package name */
    private final MenuBuilder f3218b;

    /* renamed from: c  reason: collision with root package name */
    private final View f3219c;

    /* renamed from: d  reason: collision with root package name */
    final MenuPopupHelper f3220d;

    /* renamed from: e  reason: collision with root package name */
    OnMenuItemClickListener f3221e;

    /* renamed from: f  reason: collision with root package name */
    OnDismissListener f3222f;

    /* renamed from: g  reason: collision with root package name */
    private View.OnTouchListener f3223g;

    public interface OnDismissListener {
        void a(PopupMenu popupMenu);
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public PopupMenu(@NonNull Context context, @NonNull View view) {
        this(context, view, 0);
    }

    public void a() {
        this.f3220d.dismiss();
    }

    @NonNull
    public View.OnTouchListener b() {
        if (this.f3223g == null) {
            this.f3223g = new ForwardingListener(this.f3219c) {
                public ShowableListMenu b() {
                    return PopupMenu.this.f3220d.e();
                }

                /* access modifiers changed from: protected */
                public boolean c() {
                    PopupMenu.this.l();
                    return true;
                }

                /* access modifiers changed from: protected */
                public boolean d() {
                    PopupMenu.this.a();
                    return true;
                }
            };
        }
        return this.f3223g;
    }

    public int c() {
        return this.f3220d.c();
    }

    @NonNull
    public Menu d() {
        return this.f3218b;
    }

    @NonNull
    public MenuInflater e() {
        return new SupportMenuInflater(this.f3217a);
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ListView f() {
        if (!this.f3220d.f()) {
            return null;
        }
        return this.f3220d.d();
    }

    public void g(@MenuRes int i2) {
        e().inflate(i2, this.f3218b);
    }

    public void h(boolean z) {
        this.f3220d.i(z);
    }

    public void i(int i2) {
        this.f3220d.j(i2);
    }

    public void j(@Nullable OnDismissListener onDismissListener) {
        this.f3222f = onDismissListener;
    }

    public void k(@Nullable OnMenuItemClickListener onMenuItemClickListener) {
        this.f3221e = onMenuItemClickListener;
    }

    public void l() {
        this.f3220d.l();
    }

    public PopupMenu(@NonNull Context context, @NonNull View view, int i2) {
        this(context, view, i2, R.attr.z2, 0);
    }

    public PopupMenu(@NonNull Context context, @NonNull View view, int i2, @AttrRes int i3, @StyleRes int i4) {
        this.f3217a = context;
        this.f3219c = view;
        MenuBuilder menuBuilder = new MenuBuilder(context);
        this.f3218b = menuBuilder;
        menuBuilder.Y(new MenuBuilder.Callback() {
            public boolean a(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
                OnMenuItemClickListener onMenuItemClickListener = PopupMenu.this.f3221e;
                if (onMenuItemClickListener != null) {
                    return onMenuItemClickListener.onMenuItemClick(menuItem);
                }
                return false;
            }

            public void b(@NonNull MenuBuilder menuBuilder) {
            }
        });
        MenuPopupHelper menuPopupHelper = new MenuPopupHelper(context, menuBuilder, view, false, i3, i4);
        this.f3220d = menuPopupHelper;
        menuPopupHelper.j(i2);
        menuPopupHelper.k(new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                PopupMenu popupMenu = PopupMenu.this;
                OnDismissListener onDismissListener = popupMenu.f3222f;
                if (onDismissListener != null) {
                    onDismissListener.a(popupMenu);
                }
            }
        });
    }
}
