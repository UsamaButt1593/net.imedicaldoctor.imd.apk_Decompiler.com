package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Preconditions;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FragmentController {

    /* renamed from: a  reason: collision with root package name */
    private final FragmentHostCallback<?> f7901a;

    private FragmentController(FragmentHostCallback<?> fragmentHostCallback) {
        this.f7901a = fragmentHostCallback;
    }

    @NonNull
    public static FragmentController b(@NonNull FragmentHostCallback<?> fragmentHostCallback) {
        return new FragmentController((FragmentHostCallback) Preconditions.m(fragmentHostCallback, "callbacks == null"));
    }

    @Nullable
    public Fragment A(@NonNull String str) {
        return this.f7901a.X2.t0(str);
    }

    @NonNull
    public List<Fragment> B(@SuppressLint({"UnknownNullness"}) List<Fragment> list) {
        return this.f7901a.X2.z0();
    }

    public int C() {
        return this.f7901a.X2.y0();
    }

    @NonNull
    public FragmentManager D() {
        return this.f7901a.X2;
    }

    @SuppressLint({"UnknownNullness"})
    @Deprecated
    public LoaderManager E() {
        throw new UnsupportedOperationException("Loaders are managed separately from FragmentController, use LoaderManager.getInstance() to obtain a LoaderManager.");
    }

    public void F() {
        this.f7901a.X2.n1();
    }

    @Nullable
    public View G(@Nullable View view, @NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        return this.f7901a.X2.K0().onCreateView(view, str, context, attributeSet);
    }

    @Deprecated
    public void H() {
    }

    @Deprecated
    public void I(@Nullable Parcelable parcelable, @Nullable FragmentManagerNonConfig fragmentManagerNonConfig) {
        this.f7901a.X2.I1(parcelable, fragmentManagerNonConfig);
    }

    @Deprecated
    public void J(@Nullable Parcelable parcelable, @Nullable List<Fragment> list) {
        this.f7901a.X2.I1(parcelable, new FragmentManagerNonConfig(list, (Map<String, FragmentManagerNonConfig>) null, (Map<String, ViewModelStore>) null));
    }

    @Deprecated
    public void K(@SuppressLint({"UnknownNullness"}) SimpleArrayMap<String, LoaderManager> simpleArrayMap) {
    }

    @Deprecated
    public void L(@Nullable Parcelable parcelable) {
        FragmentHostCallback<?> fragmentHostCallback = this.f7901a;
        if (fragmentHostCallback instanceof ViewModelStoreOwner) {
            fragmentHostCallback.X2.L1(parcelable);
            return;
        }
        throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
    }

    @Deprecated
    @Nullable
    public SimpleArrayMap<String, LoaderManager> M() {
        return null;
    }

    @Deprecated
    @Nullable
    public FragmentManagerNonConfig N() {
        return this.f7901a.X2.N1();
    }

    @Deprecated
    @Nullable
    public List<Fragment> O() {
        FragmentManagerNonConfig N1 = this.f7901a.X2.N1();
        if (N1 == null || N1.b() == null) {
            return null;
        }
        return new ArrayList(N1.b());
    }

    @Deprecated
    @Nullable
    public Parcelable P() {
        return this.f7901a.X2.P1();
    }

    public void a(@Nullable Fragment fragment) {
        FragmentHostCallback<?> fragmentHostCallback = this.f7901a;
        fragmentHostCallback.X2.s(fragmentHostCallback, fragmentHostCallback, fragment);
    }

    public void c() {
        this.f7901a.X2.F();
    }

    @Deprecated
    public void d(@NonNull Configuration configuration) {
        this.f7901a.X2.H(configuration, true);
    }

    public boolean e(@NonNull MenuItem menuItem) {
        return this.f7901a.X2.I(menuItem);
    }

    public void f() {
        this.f7901a.X2.J();
    }

    @Deprecated
    public boolean g(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        return this.f7901a.X2.K(menu, menuInflater);
    }

    public void h() {
        this.f7901a.X2.L();
    }

    public void i() {
        this.f7901a.X2.M();
    }

    @Deprecated
    public void j() {
        this.f7901a.X2.N(true);
    }

    @Deprecated
    public void k(boolean z) {
        this.f7901a.X2.O(z, true);
    }

    @Deprecated
    public boolean l(@NonNull MenuItem menuItem) {
        return this.f7901a.X2.R(menuItem);
    }

    @Deprecated
    public void m(@NonNull Menu menu) {
        this.f7901a.X2.S(menu);
    }

    public void n() {
        this.f7901a.X2.U();
    }

    @Deprecated
    public void o(boolean z) {
        this.f7901a.X2.V(z, true);
    }

    @Deprecated
    public boolean p(@NonNull Menu menu) {
        return this.f7901a.X2.W(menu);
    }

    @Deprecated
    public void q() {
    }

    public void r() {
        this.f7901a.X2.Y();
    }

    public void s() {
        this.f7901a.X2.Z();
    }

    public void t() {
        this.f7901a.X2.b0();
    }

    @Deprecated
    public void u() {
    }

    @Deprecated
    public void v() {
    }

    @Deprecated
    public void w() {
    }

    @Deprecated
    public void x(boolean z) {
    }

    @Deprecated
    public void y(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
    }

    public boolean z() {
        return this.f7901a.X2.j0(true);
    }
}
