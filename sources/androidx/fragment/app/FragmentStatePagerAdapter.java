package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;

@Deprecated
public abstract class FragmentStatePagerAdapter extends PagerAdapter {

    /* renamed from: l  reason: collision with root package name */
    private static final String f7974l = "FragmentStatePagerAdapt";

    /* renamed from: m  reason: collision with root package name */
    private static final boolean f7975m = false;
    @Deprecated

    /* renamed from: n  reason: collision with root package name */
    public static final int f7976n = 0;
    public static final int o = 1;

    /* renamed from: e  reason: collision with root package name */
    private final FragmentManager f7977e;

    /* renamed from: f  reason: collision with root package name */
    private final int f7978f;

    /* renamed from: g  reason: collision with root package name */
    private FragmentTransaction f7979g;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<Fragment.SavedState> f7980h;

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<Fragment> f7981i;

    /* renamed from: j  reason: collision with root package name */
    private Fragment f7982j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f7983k;

    @Deprecated
    public FragmentStatePagerAdapter(@NonNull FragmentManager fragmentManager) {
        this(fragmentManager, 0);
    }

    public void b(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f7979g == null) {
            this.f7979g = this.f7977e.u();
        }
        while (this.f7980h.size() <= i2) {
            this.f7980h.add((Object) null);
        }
        this.f7980h.set(i2, fragment.y0() ? this.f7977e.T1(fragment) : null);
        this.f7981i.set(i2, (Object) null);
        this.f7979g.B(fragment);
        if (fragment.equals(this.f7982j)) {
            this.f7982j = null;
        }
    }

    /* JADX INFO: finally extract failed */
    public void d(@NonNull ViewGroup viewGroup) {
        FragmentTransaction fragmentTransaction = this.f7979g;
        if (fragmentTransaction != null) {
            if (!this.f7983k) {
                try {
                    this.f7983k = true;
                    fragmentTransaction.t();
                    this.f7983k = false;
                } catch (Throwable th) {
                    this.f7983k = false;
                    throw th;
                }
            }
            this.f7979g = null;
        }
    }

    @NonNull
    public Object j(@NonNull ViewGroup viewGroup, int i2) {
        Fragment.SavedState savedState;
        Fragment fragment;
        if (this.f7981i.size() > i2 && (fragment = this.f7981i.get(i2)) != null) {
            return fragment;
        }
        if (this.f7979g == null) {
            this.f7979g = this.f7977e.u();
        }
        Fragment v = v(i2);
        if (this.f7980h.size() > i2 && (savedState = this.f7980h.get(i2)) != null) {
            v.p2(savedState);
        }
        while (this.f7981i.size() <= i2) {
            this.f7981i.add((Object) null);
        }
        v.q2(false);
        if (this.f7978f == 0) {
            v.B2(false);
        }
        this.f7981i.set(i2, v);
        this.f7979g.f(viewGroup.getId(), v);
        if (this.f7978f == 1) {
            this.f7979g.O(v, Lifecycle.State.STARTED);
        }
        return v;
    }

    public boolean k(@NonNull View view, @NonNull Object obj) {
        return ((Fragment) obj).q0() == view;
    }

    public void n(@Nullable Parcelable parcelable, @Nullable ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.f7980h.clear();
            this.f7981i.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.f7980h.add((Fragment.SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    Fragment E0 = this.f7977e.E0(bundle, str);
                    if (E0 != null) {
                        while (this.f7981i.size() <= parseInt) {
                            this.f7981i.add((Object) null);
                        }
                        E0.q2(false);
                        this.f7981i.set(parseInt, E0);
                    } else {
                        Log.w(f7974l, "Bad fragment at key " + str);
                    }
                }
            }
        }
    }

    @Nullable
    public Parcelable o() {
        Bundle bundle;
        if (this.f7980h.size() > 0) {
            bundle = new Bundle();
            Fragment.SavedState[] savedStateArr = new Fragment.SavedState[this.f7980h.size()];
            this.f7980h.toArray(savedStateArr);
            bundle.putParcelableArray("states", savedStateArr);
        } else {
            bundle = null;
        }
        for (int i2 = 0; i2 < this.f7981i.size(); i2++) {
            Fragment fragment = this.f7981i.get(i2);
            if (fragment != null && fragment.y0()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                this.f7977e.A1(bundle, "f" + i2, fragment);
            }
        }
        return bundle;
    }

    public void q(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f7982j;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.q2(false);
                if (this.f7978f == 1) {
                    if (this.f7979g == null) {
                        this.f7979g = this.f7977e.u();
                    }
                    this.f7979g.O(this.f7982j, Lifecycle.State.STARTED);
                } else {
                    this.f7982j.B2(false);
                }
            }
            fragment.q2(true);
            if (this.f7978f == 1) {
                if (this.f7979g == null) {
                    this.f7979g = this.f7977e.u();
                }
                this.f7979g.O(fragment, Lifecycle.State.RESUMED);
            } else {
                fragment.B2(true);
            }
            this.f7982j = fragment;
        }
    }

    public void t(@NonNull ViewGroup viewGroup) {
        if (viewGroup.getId() == -1) {
            throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
        }
    }

    @NonNull
    public abstract Fragment v(int i2);

    public FragmentStatePagerAdapter(@NonNull FragmentManager fragmentManager, int i2) {
        this.f7979g = null;
        this.f7980h = new ArrayList<>();
        this.f7981i = new ArrayList<>();
        this.f7982j = null;
        this.f7977e = fragmentManager;
        this.f7978f = i2;
    }
}
