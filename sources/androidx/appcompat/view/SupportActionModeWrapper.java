package androidx.appcompat.view;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.view.menu.MenuWrapperICS;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenu;
import androidx.core.internal.view.SupportMenuItem;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SupportActionModeWrapper extends ActionMode {

    /* renamed from: a  reason: collision with root package name */
    final Context f2912a;

    /* renamed from: b  reason: collision with root package name */
    final ActionMode f2913b;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class CallbackWrapper implements ActionMode.Callback {

        /* renamed from: a  reason: collision with root package name */
        final ActionMode.Callback f2914a;

        /* renamed from: b  reason: collision with root package name */
        final Context f2915b;

        /* renamed from: c  reason: collision with root package name */
        final ArrayList<SupportActionModeWrapper> f2916c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        final SimpleArrayMap<Menu, Menu> f2917d = new SimpleArrayMap<>();

        public CallbackWrapper(Context context, ActionMode.Callback callback) {
            this.f2915b = context;
            this.f2914a = callback;
        }

        private Menu f(Menu menu) {
            Menu menu2 = this.f2917d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            MenuWrapperICS menuWrapperICS = new MenuWrapperICS(this.f2915b, (SupportMenu) menu);
            this.f2917d.put(menu, menuWrapperICS);
            return menuWrapperICS;
        }

        public void a(ActionMode actionMode) {
            this.f2914a.onDestroyActionMode(e(actionMode));
        }

        public boolean b(ActionMode actionMode, Menu menu) {
            return this.f2914a.onCreateActionMode(e(actionMode), f(menu));
        }

        public boolean c(ActionMode actionMode, Menu menu) {
            return this.f2914a.onPrepareActionMode(e(actionMode), f(menu));
        }

        public boolean d(ActionMode actionMode, MenuItem menuItem) {
            return this.f2914a.onActionItemClicked(e(actionMode), new MenuItemWrapperICS(this.f2915b, (SupportMenuItem) menuItem));
        }

        public android.view.ActionMode e(ActionMode actionMode) {
            int size = this.f2916c.size();
            for (int i2 = 0; i2 < size; i2++) {
                SupportActionModeWrapper supportActionModeWrapper = this.f2916c.get(i2);
                if (supportActionModeWrapper != null && supportActionModeWrapper.f2913b == actionMode) {
                    return supportActionModeWrapper;
                }
            }
            SupportActionModeWrapper supportActionModeWrapper2 = new SupportActionModeWrapper(this.f2915b, actionMode);
            this.f2916c.add(supportActionModeWrapper2);
            return supportActionModeWrapper2;
        }
    }

    public SupportActionModeWrapper(Context context, ActionMode actionMode) {
        this.f2912a = context;
        this.f2913b = actionMode;
    }

    public void finish() {
        this.f2913b.c();
    }

    public View getCustomView() {
        return this.f2913b.d();
    }

    public Menu getMenu() {
        return new MenuWrapperICS(this.f2912a, (SupportMenu) this.f2913b.e());
    }

    public MenuInflater getMenuInflater() {
        return this.f2913b.f();
    }

    public CharSequence getSubtitle() {
        return this.f2913b.g();
    }

    public Object getTag() {
        return this.f2913b.h();
    }

    public CharSequence getTitle() {
        return this.f2913b.i();
    }

    public boolean getTitleOptionalHint() {
        return this.f2913b.j();
    }

    public void invalidate() {
        this.f2913b.k();
    }

    public boolean isTitleOptional() {
        return this.f2913b.l();
    }

    public void setCustomView(View view) {
        this.f2913b.n(view);
    }

    public void setSubtitle(int i2) {
        this.f2913b.o(i2);
    }

    public void setTag(Object obj) {
        this.f2913b.q(obj);
    }

    public void setTitle(int i2) {
        this.f2913b.r(i2);
    }

    public void setTitleOptionalHint(boolean z) {
        this.f2913b.t(z);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f2913b.p(charSequence);
    }

    public void setTitle(CharSequence charSequence) {
        this.f2913b.s(charSequence);
    }
}
