package androidx.appcompat.widget;

import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.Menu;
import android.view.Window;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuPresenter;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public interface DecorContentParent {
    void a(Menu menu, MenuPresenter.Callback callback);

    boolean d();

    void e();

    boolean f();

    CharSequence getTitle();

    boolean h();

    boolean i();

    boolean j();

    boolean k();

    boolean l();

    void m(SparseArray<Parcelable> sparseArray);

    void n(int i2);

    void o();

    void p(SparseArray<Parcelable> sparseArray);

    void setIcon(int i2);

    void setIcon(Drawable drawable);

    void setLogo(int i2);

    void setUiOptions(int i2);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);
}
