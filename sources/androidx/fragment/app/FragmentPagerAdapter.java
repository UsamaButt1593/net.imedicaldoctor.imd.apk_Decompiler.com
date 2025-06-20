package androidx.fragment.app;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.PagerAdapter;

@Deprecated
public abstract class FragmentPagerAdapter extends PagerAdapter {

    /* renamed from: j  reason: collision with root package name */
    private static final String f7953j = "FragmentPagerAdapter";

    /* renamed from: k  reason: collision with root package name */
    private static final boolean f7954k = false;
    @Deprecated

    /* renamed from: l  reason: collision with root package name */
    public static final int f7955l = 0;

    /* renamed from: m  reason: collision with root package name */
    public static final int f7956m = 1;

    /* renamed from: e  reason: collision with root package name */
    private final FragmentManager f7957e;

    /* renamed from: f  reason: collision with root package name */
    private final int f7958f;

    /* renamed from: g  reason: collision with root package name */
    private FragmentTransaction f7959g;

    /* renamed from: h  reason: collision with root package name */
    private Fragment f7960h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f7961i;

    @Deprecated
    public FragmentPagerAdapter(@NonNull FragmentManager fragmentManager) {
        this(fragmentManager, 0);
    }

    private static String x(int i2, long j2) {
        return "android:switcher:" + i2 + ":" + j2;
    }

    public void b(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f7959g == null) {
            this.f7959g = this.f7957e.u();
        }
        this.f7959g.v(fragment);
        if (fragment.equals(this.f7960h)) {
            this.f7960h = null;
        }
    }

    /* JADX INFO: finally extract failed */
    public void d(@NonNull ViewGroup viewGroup) {
        FragmentTransaction fragmentTransaction = this.f7959g;
        if (fragmentTransaction != null) {
            if (!this.f7961i) {
                try {
                    this.f7961i = true;
                    fragmentTransaction.t();
                    this.f7961i = false;
                } catch (Throwable th) {
                    this.f7961i = false;
                    throw th;
                }
            }
            this.f7959g = null;
        }
    }

    @NonNull
    public Object j(@NonNull ViewGroup viewGroup, int i2) {
        if (this.f7959g == null) {
            this.f7959g = this.f7957e.u();
        }
        long w = w(i2);
        Fragment s0 = this.f7957e.s0(x(viewGroup.getId(), w));
        if (s0 != null) {
            this.f7959g.p(s0);
        } else {
            s0 = v(i2);
            this.f7959g.g(viewGroup.getId(), s0, x(viewGroup.getId(), w));
        }
        if (s0 != this.f7960h) {
            s0.q2(false);
            if (this.f7958f == 1) {
                this.f7959g.O(s0, Lifecycle.State.STARTED);
            } else {
                s0.B2(false);
            }
        }
        return s0;
    }

    public boolean k(@NonNull View view, @NonNull Object obj) {
        return ((Fragment) obj).q0() == view;
    }

    public void n(@Nullable Parcelable parcelable, @Nullable ClassLoader classLoader) {
    }

    @Nullable
    public Parcelable o() {
        return null;
    }

    public void q(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f7960h;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.q2(false);
                if (this.f7958f == 1) {
                    if (this.f7959g == null) {
                        this.f7959g = this.f7957e.u();
                    }
                    this.f7959g.O(this.f7960h, Lifecycle.State.STARTED);
                } else {
                    this.f7960h.B2(false);
                }
            }
            fragment.q2(true);
            if (this.f7958f == 1) {
                if (this.f7959g == null) {
                    this.f7959g = this.f7957e.u();
                }
                this.f7959g.O(fragment, Lifecycle.State.RESUMED);
            } else {
                fragment.B2(true);
            }
            this.f7960h = fragment;
        }
    }

    public void t(@NonNull ViewGroup viewGroup) {
        if (viewGroup.getId() == -1) {
            throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
        }
    }

    @NonNull
    public abstract Fragment v(int i2);

    public long w(int i2) {
        return (long) i2;
    }

    public FragmentPagerAdapter(@NonNull FragmentManager fragmentManager, int i2) {
        this.f7959g = null;
        this.f7960h = null;
        this.f7957e = fragmentManager;
        this.f7958f = i2;
    }
}
