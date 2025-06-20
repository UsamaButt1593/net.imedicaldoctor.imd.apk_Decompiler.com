package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.appcompat.R;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.menu.MenuPresenter;

class MenuDialogHelper implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, MenuPresenter.Callback {
    private AlertDialog X;
    ListMenuPresenter Y;
    private MenuPresenter.Callback Z;
    private MenuBuilder s;

    public MenuDialogHelper(MenuBuilder menuBuilder) {
        this.s = menuBuilder;
    }

    public void a() {
        AlertDialog alertDialog = this.X;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public void b(MenuPresenter.Callback callback) {
        this.Z = callback;
    }

    public void c(@NonNull MenuBuilder menuBuilder, boolean z) {
        if (z || menuBuilder == this.s) {
            a();
        }
        MenuPresenter.Callback callback = this.Z;
        if (callback != null) {
            callback.c(menuBuilder, z);
        }
    }

    public boolean d(@NonNull MenuBuilder menuBuilder) {
        MenuPresenter.Callback callback = this.Z;
        if (callback != null) {
            return callback.d(menuBuilder);
        }
        return false;
    }

    public void e(IBinder iBinder) {
        MenuBuilder menuBuilder = this.s;
        AlertDialog.Builder builder = new AlertDialog.Builder(menuBuilder.x());
        ListMenuPresenter listMenuPresenter = new ListMenuPresenter(builder.getContext(), R.layout.q);
        this.Y = listMenuPresenter;
        listMenuPresenter.h(this);
        this.s.b(this.Y);
        builder.a(this.Y.a(), this);
        View B = menuBuilder.B();
        if (B != null) {
            builder.d(B);
        } else {
            builder.f(menuBuilder.z()).setTitle(menuBuilder.A());
        }
        builder.x(this);
        AlertDialog create = builder.create();
        this.X = create;
        create.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.X.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.X.show();
    }

    public void onClick(DialogInterface dialogInterface, int i2) {
        this.s.P((MenuItemImpl) this.Y.a().getItem(i2), 0);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.Y.c(this.s, true);
    }

    public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i2 == 82 || i2 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.X.getWindow();
                if (!(window2 == null || (decorView2 = window2.getDecorView()) == null || (keyDispatcherState2 = decorView2.getKeyDispatcherState()) == null)) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.X.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.s.f(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.s.performShortcut(i2, keyEvent, 0);
    }
}
