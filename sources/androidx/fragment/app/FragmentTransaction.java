package androidx.fragment.app;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AnimRes;
import androidx.annotation.AnimatorRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class FragmentTransaction {
    static final int A = 7;
    static final int B = 8;
    static final int C = 9;
    static final int D = 10;
    public static final int E = 4096;
    public static final int F = 8192;
    public static final int G = -1;
    public static final int H = 0;
    public static final int I = 4097;
    public static final int J = 8194;
    public static final int K = 4099;
    public static final int L = 4100;
    public static final int M = 8197;
    static final int t = 0;
    static final int u = 1;
    static final int v = 2;
    static final int w = 3;
    static final int x = 4;
    static final int y = 5;
    static final int z = 6;

    /* renamed from: a  reason: collision with root package name */
    private final FragmentFactory f7994a;

    /* renamed from: b  reason: collision with root package name */
    private final ClassLoader f7995b;

    /* renamed from: c  reason: collision with root package name */
    ArrayList<Op> f7996c;

    /* renamed from: d  reason: collision with root package name */
    int f7997d;

    /* renamed from: e  reason: collision with root package name */
    int f7998e;

    /* renamed from: f  reason: collision with root package name */
    int f7999f;

    /* renamed from: g  reason: collision with root package name */
    int f8000g;

    /* renamed from: h  reason: collision with root package name */
    int f8001h;

    /* renamed from: i  reason: collision with root package name */
    boolean f8002i;

    /* renamed from: j  reason: collision with root package name */
    boolean f8003j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    String f8004k;

    /* renamed from: l  reason: collision with root package name */
    int f8005l;

    /* renamed from: m  reason: collision with root package name */
    CharSequence f8006m;

    /* renamed from: n  reason: collision with root package name */
    int f8007n;
    CharSequence o;
    ArrayList<String> p;
    ArrayList<String> q;
    boolean r;
    ArrayList<Runnable> s;

    static final class Op {

        /* renamed from: a  reason: collision with root package name */
        int f8008a;

        /* renamed from: b  reason: collision with root package name */
        Fragment f8009b;

        /* renamed from: c  reason: collision with root package name */
        boolean f8010c;

        /* renamed from: d  reason: collision with root package name */
        int f8011d;

        /* renamed from: e  reason: collision with root package name */
        int f8012e;

        /* renamed from: f  reason: collision with root package name */
        int f8013f;

        /* renamed from: g  reason: collision with root package name */
        int f8014g;

        /* renamed from: h  reason: collision with root package name */
        Lifecycle.State f8015h;

        /* renamed from: i  reason: collision with root package name */
        Lifecycle.State f8016i;

        Op() {
        }

        Op(int i2, Fragment fragment) {
            this.f8008a = i2;
            this.f8009b = fragment;
            this.f8010c = false;
            Lifecycle.State state = Lifecycle.State.RESUMED;
            this.f8015h = state;
            this.f8016i = state;
        }

        Op(int i2, @NonNull Fragment fragment, Lifecycle.State state) {
            this.f8008a = i2;
            this.f8009b = fragment;
            this.f8010c = false;
            this.f8015h = fragment.K3;
            this.f8016i = state;
        }

        Op(int i2, Fragment fragment, boolean z) {
            this.f8008a = i2;
            this.f8009b = fragment;
            this.f8010c = z;
            Lifecycle.State state = Lifecycle.State.RESUMED;
            this.f8015h = state;
            this.f8016i = state;
        }

        Op(Op op) {
            this.f8008a = op.f8008a;
            this.f8009b = op.f8009b;
            this.f8010c = op.f8010c;
            this.f8011d = op.f8011d;
            this.f8012e = op.f8012e;
            this.f8013f = op.f8013f;
            this.f8014g = op.f8014g;
            this.f8015h = op.f8015h;
            this.f8016i = op.f8016i;
        }
    }

    @Deprecated
    public FragmentTransaction() {
        this.f7996c = new ArrayList<>();
        this.f8003j = true;
        this.r = false;
        this.f7994a = null;
        this.f7995b = null;
    }

    @NonNull
    private Fragment u(@NonNull Class<? extends Fragment> cls, @Nullable Bundle bundle) {
        FragmentFactory fragmentFactory = this.f7994a;
        if (fragmentFactory != null) {
            ClassLoader classLoader = this.f7995b;
            if (classLoader != null) {
                Fragment a2 = fragmentFactory.a(classLoader, cls.getName());
                if (bundle != null) {
                    a2.i2(bundle);
                }
                return a2;
            }
            throw new IllegalStateException("The FragmentManager must be attached to itshost to create a Fragment");
        }
        throw new IllegalStateException("Creating a Fragment requires that this FragmentTransaction was built with FragmentManager.beginTransaction()");
    }

    public boolean A() {
        return this.f7996c.isEmpty();
    }

    @NonNull
    public FragmentTransaction B(@NonNull Fragment fragment) {
        m(new Op(3, fragment));
        return this;
    }

    @NonNull
    public FragmentTransaction C(@IdRes int i2, @NonNull Fragment fragment) {
        return D(i2, fragment, (String) null);
    }

    @NonNull
    public FragmentTransaction D(@IdRes int i2, @NonNull Fragment fragment, @Nullable String str) {
        if (i2 != 0) {
            x(i2, fragment, str, 2);
            return this;
        }
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }

    @NonNull
    public final FragmentTransaction E(@IdRes int i2, @NonNull Class<? extends Fragment> cls, @Nullable Bundle bundle) {
        return F(i2, cls, bundle, (String) null);
    }

    @NonNull
    public final FragmentTransaction F(@IdRes int i2, @NonNull Class<? extends Fragment> cls, @Nullable Bundle bundle, @Nullable String str) {
        return D(i2, u(cls, bundle), str);
    }

    @NonNull
    public FragmentTransaction G(@NonNull Runnable runnable) {
        w();
        if (this.s == null) {
            this.s = new ArrayList<>();
        }
        this.s.add(runnable);
        return this;
    }

    @NonNull
    @Deprecated
    public FragmentTransaction H(boolean z2) {
        return Q(z2);
    }

    @NonNull
    @Deprecated
    public FragmentTransaction I(@StringRes int i2) {
        this.f8007n = i2;
        this.o = null;
        return this;
    }

    @NonNull
    @Deprecated
    public FragmentTransaction J(@Nullable CharSequence charSequence) {
        this.f8007n = 0;
        this.o = charSequence;
        return this;
    }

    @NonNull
    @Deprecated
    public FragmentTransaction K(@StringRes int i2) {
        this.f8005l = i2;
        this.f8006m = null;
        return this;
    }

    @NonNull
    @Deprecated
    public FragmentTransaction L(@Nullable CharSequence charSequence) {
        this.f8005l = 0;
        this.f8006m = charSequence;
        return this;
    }

    @NonNull
    public FragmentTransaction M(@AnimRes @AnimatorRes int i2, @AnimRes @AnimatorRes int i3) {
        return N(i2, i3, 0, 0);
    }

    @NonNull
    public FragmentTransaction N(@AnimRes @AnimatorRes int i2, @AnimRes @AnimatorRes int i3, @AnimRes @AnimatorRes int i4, @AnimRes @AnimatorRes int i5) {
        this.f7997d = i2;
        this.f7998e = i3;
        this.f7999f = i4;
        this.f8000g = i5;
        return this;
    }

    @NonNull
    public FragmentTransaction O(@NonNull Fragment fragment, @NonNull Lifecycle.State state) {
        m(new Op(10, fragment, state));
        return this;
    }

    @NonNull
    public FragmentTransaction P(@Nullable Fragment fragment) {
        m(new Op(8, fragment));
        return this;
    }

    @NonNull
    public FragmentTransaction Q(boolean z2) {
        this.r = z2;
        return this;
    }

    @NonNull
    public FragmentTransaction R(int i2) {
        this.f8001h = i2;
        return this;
    }

    @NonNull
    @Deprecated
    public FragmentTransaction S(@StyleRes int i2) {
        return this;
    }

    @NonNull
    public FragmentTransaction T(@NonNull Fragment fragment) {
        m(new Op(5, fragment));
        return this;
    }

    @NonNull
    public FragmentTransaction f(@IdRes int i2, @NonNull Fragment fragment) {
        x(i2, fragment, (String) null, 1);
        return this;
    }

    @NonNull
    public FragmentTransaction g(@IdRes int i2, @NonNull Fragment fragment, @Nullable String str) {
        x(i2, fragment, str, 1);
        return this;
    }

    @NonNull
    public final FragmentTransaction h(@IdRes int i2, @NonNull Class<? extends Fragment> cls, @Nullable Bundle bundle) {
        return f(i2, u(cls, bundle));
    }

    @NonNull
    public final FragmentTransaction i(@IdRes int i2, @NonNull Class<? extends Fragment> cls, @Nullable Bundle bundle, @Nullable String str) {
        return g(i2, u(cls, bundle), str);
    }

    /* access modifiers changed from: package-private */
    public FragmentTransaction j(@NonNull ViewGroup viewGroup, @NonNull Fragment fragment, @Nullable String str) {
        fragment.A3 = viewGroup;
        return g(viewGroup.getId(), fragment, str);
    }

    @NonNull
    public FragmentTransaction k(@NonNull Fragment fragment, @Nullable String str) {
        x(0, fragment, str, 1);
        return this;
    }

    @NonNull
    public final FragmentTransaction l(@NonNull Class<? extends Fragment> cls, @Nullable Bundle bundle, @Nullable String str) {
        return k(u(cls, bundle), str);
    }

    /* access modifiers changed from: package-private */
    public void m(Op op) {
        this.f7996c.add(op);
        op.f8011d = this.f7997d;
        op.f8012e = this.f7998e;
        op.f8013f = this.f7999f;
        op.f8014g = this.f8000g;
    }

    @NonNull
    public FragmentTransaction n(@NonNull View view, @NonNull String str) {
        if (FragmentTransition.f()) {
            String A0 = ViewCompat.A0(view);
            if (A0 != null) {
                if (this.p == null) {
                    this.p = new ArrayList<>();
                    this.q = new ArrayList<>();
                } else if (this.q.contains(str)) {
                    throw new IllegalArgumentException("A shared element with the target name '" + str + "' has already been added to the transaction.");
                } else if (this.p.contains(A0)) {
                    throw new IllegalArgumentException("A shared element with the source name '" + A0 + "' has already been added to the transaction.");
                }
                this.p.add(A0);
                this.q.add(str);
            } else {
                throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
            }
        }
        return this;
    }

    @NonNull
    public FragmentTransaction o(@Nullable String str) {
        if (this.f8003j) {
            this.f8002i = true;
            this.f8004k = str;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    @NonNull
    public FragmentTransaction p(@NonNull Fragment fragment) {
        m(new Op(7, fragment));
        return this;
    }

    public abstract int q();

    public abstract int r();

    public abstract void s();

    public abstract void t();

    @NonNull
    public FragmentTransaction v(@NonNull Fragment fragment) {
        m(new Op(6, fragment));
        return this;
    }

    @NonNull
    public FragmentTransaction w() {
        if (!this.f8002i) {
            this.f8003j = false;
            return this;
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    /* access modifiers changed from: package-private */
    public void x(int i2, Fragment fragment, @Nullable String str, int i3) {
        String str2 = fragment.J3;
        if (str2 != null) {
            FragmentStrictMode.i(fragment, str2);
        }
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str3 = fragment.s3;
            if (str3 == null || str.equals(str3)) {
                fragment.s3 = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.s3 + " now " + str);
            }
        }
        if (i2 != 0) {
            if (i2 != -1) {
                int i4 = fragment.q3;
                if (i4 == 0 || i4 == i2) {
                    fragment.q3 = i2;
                    fragment.r3 = i2;
                } else {
                    throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.q3 + " now " + i2);
                }
            } else {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
        }
        m(new Op(i3, fragment));
    }

    @NonNull
    public FragmentTransaction y(@NonNull Fragment fragment) {
        m(new Op(4, fragment));
        return this;
    }

    public boolean z() {
        return this.f8003j;
    }

    FragmentTransaction(@NonNull FragmentFactory fragmentFactory, @Nullable ClassLoader classLoader) {
        this.f7996c = new ArrayList<>();
        this.f8003j = true;
        this.r = false;
        this.f7994a = fragmentFactory;
        this.f7995b = classLoader;
    }

    FragmentTransaction(@NonNull FragmentFactory fragmentFactory, @Nullable ClassLoader classLoader, @NonNull FragmentTransaction fragmentTransaction) {
        this(fragmentFactory, classLoader);
        Iterator<Op> it2 = fragmentTransaction.f7996c.iterator();
        while (it2.hasNext()) {
            this.f7996c.add(new Op(it2.next()));
        }
        this.f7997d = fragmentTransaction.f7997d;
        this.f7998e = fragmentTransaction.f7998e;
        this.f7999f = fragmentTransaction.f7999f;
        this.f8000g = fragmentTransaction.f8000g;
        this.f8001h = fragmentTransaction.f8001h;
        this.f8002i = fragmentTransaction.f8002i;
        this.f8003j = fragmentTransaction.f8003j;
        this.f8004k = fragmentTransaction.f8004k;
        this.f8007n = fragmentTransaction.f8007n;
        this.o = fragmentTransaction.o;
        this.f8005l = fragmentTransaction.f8005l;
        this.f8006m = fragmentTransaction.f8006m;
        if (fragmentTransaction.p != null) {
            ArrayList<String> arrayList = new ArrayList<>();
            this.p = arrayList;
            arrayList.addAll(fragmentTransaction.p);
        }
        if (fragmentTransaction.q != null) {
            ArrayList<String> arrayList2 = new ArrayList<>();
            this.q = arrayList2;
            arrayList2.addAll(fragmentTransaction.q);
        }
        this.r = fragmentTransaction.r;
    }
}
