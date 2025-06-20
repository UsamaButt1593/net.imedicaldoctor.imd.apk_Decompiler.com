package androidx.legacy.app;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;

@Deprecated
public abstract class FragmentPagerAdapter extends PagerAdapter {

    /* renamed from: h  reason: collision with root package name */
    private static final String f8089h = "FragmentPagerAdapter";

    /* renamed from: i  reason: collision with root package name */
    private static final boolean f8090i = false;

    /* renamed from: e  reason: collision with root package name */
    private final FragmentManager f8091e;

    /* renamed from: f  reason: collision with root package name */
    private FragmentTransaction f8092f = null;

    /* renamed from: g  reason: collision with root package name */
    private Fragment f8093g = null;

    @Deprecated
    public FragmentPagerAdapter(FragmentManager fragmentManager) {
        this.f8091e = fragmentManager;
    }

    private static String x(int i2, long j2) {
        return "android:switcher:" + i2 + ":" + j2;
    }

    @Deprecated
    public void b(ViewGroup viewGroup, int i2, Object obj) {
        if (this.f8092f == null) {
            this.f8092f = this.f8091e.beginTransaction();
        }
        this.f8092f.detach((Fragment) obj);
    }

    @Deprecated
    public void d(ViewGroup viewGroup) {
        FragmentTransaction fragmentTransaction = this.f8092f;
        if (fragmentTransaction != null) {
            fragmentTransaction.commitAllowingStateLoss();
            this.f8092f = null;
            this.f8091e.executePendingTransactions();
        }
    }

    @Deprecated
    public Object j(ViewGroup viewGroup, int i2) {
        if (this.f8092f == null) {
            this.f8092f = this.f8091e.beginTransaction();
        }
        long w = w(i2);
        Fragment findFragmentByTag = this.f8091e.findFragmentByTag(x(viewGroup.getId(), w));
        if (findFragmentByTag != null) {
            this.f8092f.attach(findFragmentByTag);
        } else {
            findFragmentByTag = v(i2);
            this.f8092f.add(viewGroup.getId(), findFragmentByTag, x(viewGroup.getId(), w));
        }
        if (findFragmentByTag != this.f8093g) {
            findFragmentByTag.setMenuVisibility(false);
            FragmentCompat.e(findFragmentByTag, false);
        }
        return findFragmentByTag;
    }

    @Deprecated
    public boolean k(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    @Deprecated
    public void n(Parcelable parcelable, ClassLoader classLoader) {
    }

    @Deprecated
    public Parcelable o() {
        return null;
    }

    @Deprecated
    public void q(ViewGroup viewGroup, int i2, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f8093g;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                FragmentCompat.e(this.f8093g, false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
                FragmentCompat.e(fragment, true);
            }
            this.f8093g = fragment;
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

    @Deprecated
    public long w(int i2) {
        return (long) i2;
    }
}
