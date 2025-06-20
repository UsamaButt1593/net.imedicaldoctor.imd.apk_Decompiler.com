package androidx.appcompat.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.RestrictTo;

public abstract class ActionMode {
    private boolean X;
    private Object s;

    public interface Callback {
        void a(ActionMode actionMode);

        boolean b(ActionMode actionMode, Menu menu);

        boolean c(ActionMode actionMode, Menu menu);

        boolean d(ActionMode actionMode, MenuItem menuItem);
    }

    public abstract void c();

    public abstract View d();

    public abstract Menu e();

    public abstract MenuInflater f();

    public abstract CharSequence g();

    public Object h() {
        return this.s;
    }

    public abstract CharSequence i();

    public boolean j() {
        return this.X;
    }

    public abstract void k();

    public boolean l() {
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean m() {
        return true;
    }

    public abstract void n(View view);

    public abstract void o(int i2);

    public abstract void p(CharSequence charSequence);

    public void q(Object obj) {
        this.s = obj;
    }

    public abstract void r(int i2);

    public abstract void s(CharSequence charSequence);

    public void t(boolean z) {
        this.X = z;
    }
}
