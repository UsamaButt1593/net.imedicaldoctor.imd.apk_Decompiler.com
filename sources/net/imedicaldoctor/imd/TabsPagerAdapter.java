package net.imedicaldoctor.imd;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import net.imedicaldoctor.imd.Fragments.accountFragment;
import net.imedicaldoctor.imd.Fragments.contentFragment;
import net.imedicaldoctor.imd.Fragments.databasesFragment;
import net.imedicaldoctor.imd.Fragments.downloadFragment;
import net.imedicaldoctor.imd.Fragments.favoritesFragment;
import net.imedicaldoctor.imd.Fragments.searchFragment;

public class TabsPagerAdapter extends FragmentPagerAdapter {

    /* renamed from: n  reason: collision with root package name */
    public FragmentManager f30423n;

    public TabsPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.f30423n = fragmentManager;
    }

    private static String z(int i2, int i3) {
        return "android:switcher:" + i2 + ":" + i3;
    }

    public int e() {
        return 6;
    }

    public CharSequence g(int i2) {
        return "";
    }

    public Fragment v(int i2) {
        if (i2 == 0) {
            return new searchFragment();
        }
        if (i2 == 1) {
            return new databasesFragment();
        }
        if (i2 == 2) {
            return new favoritesFragment();
        }
        if (i2 == 3) {
            return new contentFragment();
        }
        if (i2 == 4) {
            return new downloadFragment();
        }
        if (i2 != 5) {
            return null;
        }
        return new accountFragment();
    }

    public Fragment y(ViewPager viewPager, int i2) {
        return this.f30423n.s0(z(viewPager.getId(), i2));
    }
}
