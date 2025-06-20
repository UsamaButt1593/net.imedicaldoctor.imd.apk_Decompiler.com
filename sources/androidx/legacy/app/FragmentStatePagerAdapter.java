package androidx.legacy.app;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;

@Deprecated
public abstract class FragmentStatePagerAdapter extends PagerAdapter {

    /* renamed from: j  reason: collision with root package name */
    private static final String f8094j = "FragStatePagerAdapter";

    /* renamed from: k  reason: collision with root package name */
    private static final boolean f8095k = false;

    /* renamed from: e  reason: collision with root package name */
    private final FragmentManager f8096e;

    /* renamed from: f  reason: collision with root package name */
    private FragmentTransaction f8097f = null;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<Fragment.SavedState> f8098g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<Fragment> f8099h = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    private Fragment f8100i = null;

    @Deprecated
    public FragmentStatePagerAdapter(FragmentManager fragmentManager) {
        this.f8096e = fragmentManager;
    }

    @Deprecated
    public void b(ViewGroup viewGroup, int i2, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f8097f == null) {
            this.f8097f = this.f8096e.beginTransaction();
        }
        while (this.f8098g.size() <= i2) {
            this.f8098g.add((Object) null);
        }
        this.f8098g.set(i2, fragment.isAdded() ? this.f8096e.saveFragmentInstanceState(fragment) : null);
        this.f8099h.set(i2, (Object) null);
        this.f8097f.remove(fragment);
    }

    @Deprecated
    public void d(ViewGroup viewGroup) {
        FragmentTransaction fragmentTransaction = this.f8097f;
        if (fragmentTransaction != null) {
            fragmentTransaction.commitAllowingStateLoss();
            this.f8097f = null;
            this.f8096e.executePendingTransactions();
        }
    }

    @Deprecated
    public Object j(ViewGroup viewGroup, int i2) {
        Fragment.SavedState savedState;
        Fragment fragment;
        if (this.f8099h.size() > i2 && (fragment = this.f8099h.get(i2)) != null) {
            return fragment;
        }
        if (this.f8097f == null) {
            this.f8097f = this.f8096e.beginTransaction();
        }
        Fragment v = v(i2);
        if (this.f8098g.size() > i2 && (savedState = this.f8098g.get(i2)) != null) {
            v.setInitialSavedState(savedState);
        }
        while (this.f8099h.size() <= i2) {
            this.f8099h.add((Object) null);
        }
        v.setMenuVisibility(false);
        FragmentCompat.e(v, false);
        this.f8099h.set(i2, v);
        this.f8097f.add(viewGroup.getId(), v);
        return v;
    }

    @Deprecated
    public boolean k(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    @Deprecated
    public void n(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.f8098g.clear();
            this.f8099h.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.f8098g.add((Fragment.SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    Fragment fragment = this.f8096e.getFragment(bundle, str);
                    if (fragment != null) {
                        while (this.f8099h.size() <= parseInt) {
                            this.f8099h.add((Object) null);
                        }
                        FragmentCompat.c(fragment, false);
                        this.f8099h.set(parseInt, fragment);
                    } else {
                        Log.w(f8094j, "Bad fragment at key " + str);
                    }
                }
            }
        }
    }

    @Deprecated
    public Parcelable o() {
        Bundle bundle;
        if (this.f8098g.size() > 0) {
            bundle = new Bundle();
            Fragment.SavedState[] savedStateArr = new Fragment.SavedState[this.f8098g.size()];
            this.f8098g.toArray(savedStateArr);
            bundle.putParcelableArray("states", savedStateArr);
        } else {
            bundle = null;
        }
        for (int i2 = 0; i2 < this.f8099h.size(); i2++) {
            Fragment fragment = this.f8099h.get(i2);
            if (fragment != null && fragment.isAdded()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                this.f8096e.putFragment(bundle, "f" + i2, fragment);
            }
        }
        return bundle;
    }

    @Deprecated
    public void q(ViewGroup viewGroup, int i2, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f8100i;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                FragmentCompat.e(this.f8100i, false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
                FragmentCompat.e(fragment, true);
            }
            this.f8100i = fragment;
        }
    }

    @Deprecated
    public void t(ViewGroup viewGroup) {
        if (viewGroup.getId() == -1) {
            throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
        }
    }

    @Deprecated
    public abstract Fragment v(int i2);
}
