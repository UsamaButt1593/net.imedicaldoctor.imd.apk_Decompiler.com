package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.SpinnerAdapter;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.view.ViewPropertyAnimatorCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public interface DecorToolbar {
    boolean A();

    int B();

    void C(int i2);

    ViewPropertyAnimatorCompat D(int i2, long j2);

    void E(int i2);

    void F(int i2);

    void G(MenuPresenter.Callback callback, MenuBuilder.Callback callback2);

    ViewGroup H();

    void I(boolean z);

    void J(SpinnerAdapter spinnerAdapter, AdapterView.OnItemSelectedListener onItemSelectedListener);

    void K(SparseArray<Parcelable> sparseArray);

    CharSequence L();

    int M();

    int N();

    void O(int i2);

    void P(View view);

    void Q();

    int R();

    void S();

    void T(Drawable drawable);

    void U(boolean z);

    void a(Menu menu, MenuPresenter.Callback callback);

    int b();

    void c(Drawable drawable);

    void collapseActionView();

    boolean d();

    void e();

    boolean f();

    Context g();

    int getHeight();

    CharSequence getTitle();

    boolean h();

    boolean i();

    boolean j();

    boolean k();

    boolean l();

    void m(int i2);

    void n();

    View o();

    void p(ScrollingTabContainerView scrollingTabContainerView);

    void q(Drawable drawable);

    boolean r();

    boolean s();

    void setIcon(int i2);

    void setIcon(Drawable drawable);

    void setLogo(int i2);

    void setTitle(CharSequence charSequence);

    void setVisibility(int i2);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);

    void t(int i2);

    void u(CharSequence charSequence);

    void v(CharSequence charSequence);

    void w(Drawable drawable);

    void x(SparseArray<Parcelable> sparseArray);

    void y(int i2);

    Menu z();
}
