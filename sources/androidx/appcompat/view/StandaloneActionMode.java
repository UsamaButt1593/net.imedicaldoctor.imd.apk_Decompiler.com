package androidx.appcompat.view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class StandaloneActionMode extends ActionMode implements MenuBuilder.Callback {
    private ActionMode.Callback X2;
    private Context Y;
    private WeakReference<View> Y2;
    private ActionBarContextView Z;
    private boolean Z2;
    private boolean a3;
    private MenuBuilder b3;

    public StandaloneActionMode(Context context, ActionBarContextView actionBarContextView, ActionMode.Callback callback, boolean z) {
        this.Y = context;
        this.Z = actionBarContextView;
        this.X2 = callback;
        MenuBuilder a0 = new MenuBuilder(actionBarContextView.getContext()).a0(1);
        this.b3 = a0;
        a0.Y(this);
        this.a3 = z;
    }

    public boolean a(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
        return this.X2.d(this, menuItem);
    }

    public void b(@NonNull MenuBuilder menuBuilder) {
        k();
        this.Z.o();
    }

    public void c() {
        if (!this.Z2) {
            this.Z2 = true;
            this.X2.a(this);
        }
    }

    public View d() {
        WeakReference<View> weakReference = this.Y2;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public Menu e() {
        return this.b3;
    }

    public MenuInflater f() {
        return new SupportMenuInflater(this.Z.getContext());
    }

    public CharSequence g() {
        return this.Z.getSubtitle();
    }

    public CharSequence i() {
        return this.Z.getTitle();
    }

    public void k() {
        this.X2.c(this, this.b3);
    }

    public boolean l() {
        return this.Z.s();
    }

    public boolean m() {
        return this.a3;
    }

    public void n(View view) {
        this.Z.setCustomView(view);
        this.Y2 = view != null ? new WeakReference<>(view) : null;
    }

    public void o(int i2) {
        p(this.Y.getString(i2));
    }

    public void p(CharSequence charSequence) {
        this.Z.setSubtitle(charSequence);
    }

    public void r(int i2) {
        s(this.Y.getString(i2));
    }

    public void s(CharSequence charSequence) {
        this.Z.setTitle(charSequence);
    }

    public void t(boolean z) {
        super.t(z);
        this.Z.setTitleOptional(z);
    }

    public void u(MenuBuilder menuBuilder, boolean z) {
    }

    public void v(SubMenuBuilder subMenuBuilder) {
    }

    public boolean w(SubMenuBuilder subMenuBuilder) {
        if (!subMenuBuilder.hasVisibleItems()) {
            return true;
        }
        new MenuPopupHelper(this.Z.getContext(), subMenuBuilder).l();
        return true;
    }
}
