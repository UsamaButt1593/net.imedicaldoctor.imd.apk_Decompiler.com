package net.imedicaldoctor.imd.Fragments.Epocrate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.SearchView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.SearchHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.ViewHolders.ChaptersAdapter;
import net.imedicaldoctor.imd.ViewHolders.SpellSearchAdapter;

public class EPOLabListActivityFragment extends SearchHelperFragment {
    public SpellSearchAdapter A4;
    public String B4;
    public TabLayout C4;

    public View U0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        CompressHelper compressHelper;
        Bundle bundle2;
        String str;
        this.q4 = layoutInflater.inflate(R.layout.f1238fragment_lab_list, viewGroup, false);
        W2(bundle);
        S2();
        this.s4 = (SearchView) this.q4.findViewById(R.id.f1069search_view);
        Q2();
        this.w4 = (RecyclerView) this.q4.findViewById(R.id.f1054recycler_view);
        AppBarLayout appBarLayout = (AppBarLayout) this.q4.findViewById(R.id.f825appbar);
        final RelativeLayout relativeLayout = (RelativeLayout) this.q4.findViewById(R.id.f830background_layout);
        this.C4 = (TabLayout) this.q4.findViewById(R.id.f1111tabs);
        String[] strArr = {"Specimen Type", "Panel Type"};
        for (int i2 = 0; i2 < 2; i2++) {
            TabLayout.Tab I = this.C4.I();
            I.D(strArr[i2]);
            this.C4.i(I);
        }
        if (y() == null || !y().containsKey("ParentId")) {
            this.C4.setVisibility(0);
            appBarLayout.D(true, false);
            relativeLayout.setVisibility(0);
            this.B4 = null;
            if (this.C4.getSelectedTabPosition() == 0) {
                compressHelper = this.k4;
                bundle2 = this.h4;
                str = "Select * from lab_specimen";
            } else {
                compressHelper = this.k4;
                bundle2 = this.h4;
                str = "Select * from lab_panel";
            }
        } else {
            appBarLayout.D(false, false);
            appBarLayout.postDelayed(new Runnable() {
                public void run() {
                    relativeLayout.setVisibility(0);
                }
            }, 800);
            this.C4.setVisibility(8);
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.w4.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.w4.setLayoutParams(layoutParams);
            this.B4 = y().getString("ParentId");
            compressHelper = this.k4;
            bundle2 = this.h4;
            str = "SELECT * FROM lab_topics where id in ( select topicid from lab_cats_topics where catId=" + this.B4 + ")";
        }
        this.n4 = compressHelper.V(bundle2, str);
        this.C4.setOnTabSelectedListener((TabLayout.OnTabSelectedListener) new TabLayout.OnTabSelectedListener() {
            public void a(TabLayout.Tab tab) {
            }

            public void b(TabLayout.Tab tab) {
                EPOLabListActivityFragment ePOLabListActivityFragment;
                CompressHelper compressHelper;
                Bundle bundle;
                String str;
                if (EPOLabListActivityFragment.this.C4.getSelectedTabPosition() == 0) {
                    ePOLabListActivityFragment = EPOLabListActivityFragment.this;
                    compressHelper = ePOLabListActivityFragment.k4;
                    bundle = ePOLabListActivityFragment.h4;
                    str = "Select * from lab_specimen";
                } else {
                    ePOLabListActivityFragment = EPOLabListActivityFragment.this;
                    compressHelper = ePOLabListActivityFragment.k4;
                    bundle = ePOLabListActivityFragment.h4;
                    str = "Select * from lab_panel";
                }
                ePOLabListActivityFragment.n4 = compressHelper.V(bundle, str);
                EPOLabListActivityFragment ePOLabListActivityFragment2 = EPOLabListActivityFragment.this;
                ((ChaptersAdapter) ePOLabListActivityFragment2.l4).g0(ePOLabListActivityFragment2.n4);
                EPOLabListActivityFragment ePOLabListActivityFragment3 = EPOLabListActivityFragment.this;
                ePOLabListActivityFragment3.w4.setAdapter(ePOLabListActivityFragment3.l4);
            }

            public void c(TabLayout.Tab tab) {
            }
        });
        this.l4 = new ChaptersAdapter(r(), this.n4, "title", R.layout.f1343list_view_item_ripple_text_arrow) {
            public void f0(Bundle bundle, int i2) {
                EPOLabListActivityFragment.this.V2();
                EPOLabListActivityFragment ePOLabListActivityFragment = EPOLabListActivityFragment.this;
                if (ePOLabListActivityFragment.B4 == null) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putBundle("DB", EPOLabListActivityFragment.this.h4);
                    bundle2.putString("ParentId", bundle.getString("id"));
                    EPOLabListActivityFragment.this.k4.N(EPOLabListActivity.class, EPOLabListActivityFragment.class, bundle2);
                    return;
                }
                CompressHelper compressHelper = ePOLabListActivityFragment.k4;
                Bundle bundle3 = ePOLabListActivityFragment.h4;
                compressHelper.A1(bundle3, "lab-" + bundle.getString("mId"), (String[]) null, (String) null);
            }
        };
        this.A4 = new SpellSearchAdapter(r(), this.o4, "text", (String) null) {
            public void g0(Bundle bundle, int i2) {
                EPOLabListActivityFragment.this.V2();
                EPOLabListActivityFragment ePOLabListActivityFragment = EPOLabListActivityFragment.this;
                CompressHelper compressHelper = ePOLabListActivityFragment.k4;
                Bundle bundle2 = ePOLabListActivityFragment.h4;
                compressHelper.A1(bundle2, "lab-" + bundle.getString("contentId"), (String[]) null, (String) null);
            }

            public void h0(Bundle bundle) {
                EPOLabListActivityFragment.this.V2();
                EPOLabListActivityFragment.this.s4.k0(bundle.getString("word"), true);
            }
        };
        this.w4.setAdapter(this.l4);
        N2();
        o2(false);
        return this.q4;
    }

    public void X2() {
        this.A4.i0(this.o4, this.p4);
        this.w4.setAdapter(this.A4);
    }

    public ArrayList<Bundle> a3(String str) {
        CompressHelper compressHelper = this.k4;
        Bundle bundle = this.h4;
        return compressHelper.V(bundle, "Select * from search where search match 'text:" + str + "* AND typeText:Lab AND type:1'");
    }

    public void c3() {
        this.t4.setImageDrawable(b0().getDrawable(R.drawable.f672labs_icon));
    }

    public ArrayList<Bundle> g3(String str) {
        CompressHelper compressHelper = this.k4;
        Bundle bundle = this.h4;
        return compressHelper.V(bundle, "Select rowid as _id,word from spell where word match '" + str + "*'");
    }

    public String h3() {
        return "Labs";
    }
}
