package net.imedicaldoctor.imd.Fragments.Epocrate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import java.util.ArrayList;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.SearchHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.ViewHolders.ChaptersAdapter;
import net.imedicaldoctor.imd.ViewHolders.SpellSearchAdapter;

public class EPOTableListActivityFragment extends SearchHelperFragment {
    public SpellSearchAdapter A4;
    public String B4;
    public String C4;

    public View onFragmentBind(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        CompressHelper compressHelper;
        Bundle bundle2;
        String str2;
        this.q4 = layoutInflater.inflate(R.layout.f1246fragment_new_list, viewGroup, false);
        W2(bundle);
        S2();
        this.s4 = (SearchView) this.q4.findViewById(R.id.f1069search_view);
        Q2();
        this.w4 = (RecyclerView) this.q4.findViewById(R.id.f1054recycler_view);
        this.C4 = "RX.sqlite";
        AppBarLayout appBarLayout = (AppBarLayout) this.q4.findViewById(R.id.f825appbar);
        final RelativeLayout relativeLayout = (RelativeLayout) this.q4.findViewById(R.id.f830background_layout);
        if (y() == null || !y().containsKey("ParentId")) {
            appBarLayout.D(true, false);
            relativeLayout.setVisibility(0);
            str = null;
        } else {
            if (y().getString("ParentId").equals("0")) {
                appBarLayout.D(true, false);
                relativeLayout.setVisibility(0);
            } else {
                appBarLayout.D(false, false);
                appBarLayout.postDelayed(new Runnable() {
                    public void run() {
                        relativeLayout.setVisibility(0);
                    }
                }, 800);
            }
            str = y().getString("ParentId");
        }
        this.B4 = str;
        if (this.B4 == null) {
            compressHelper = this.k4;
            bundle2 = this.h4;
            str2 = "Select * from content_table_cat";
        } else {
            compressHelper = this.k4;
            bundle2 = this.h4;
            str2 = "select * from content_table_to_cat inner join content_table on content_table_to_cat.table_id=content_table.id where cat_id=" + this.B4 + " order by display_order";
        }
        this.n4 = compressHelper.W(bundle2, str2, this.C4);
        this.l4 = new ChaptersAdapter(r(), this.n4, "NAME", R.layout.f1343list_view_item_ripple_text_arrow) {
            public void f0(Bundle bundle, int i2) {
                EPOTableListActivityFragment.this.V2();
                EPOTableListActivityFragment ePOTableListActivityFragment = EPOTableListActivityFragment.this;
                if (ePOTableListActivityFragment.B4 == null) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putBundle("DB", EPOTableListActivityFragment.this.h4);
                    bundle2.putString("ParentId", bundle.getString("ID"));
                    EPOTableListActivityFragment.this.k4.N(EPOTableListActivity.class, EPOTableListActivityFragment.class, bundle2);
                    return;
                }
                CompressHelper compressHelper = ePOTableListActivityFragment.k4;
                Bundle bundle3 = ePOTableListActivityFragment.h4;
                compressHelper.A1(bundle3, "table-" + bundle.getString("ID"), (String[]) null, (String) null);
            }
        };
        this.A4 = new SpellSearchAdapter(r(), this.o4, "text", (String) null) {
            public void g0(Bundle bundle, int i2) {
                EPOTableListActivityFragment.this.V2();
                EPOTableListActivityFragment ePOTableListActivityFragment = EPOTableListActivityFragment.this;
                CompressHelper compressHelper = ePOTableListActivityFragment.k4;
                Bundle bundle2 = ePOTableListActivityFragment.h4;
                compressHelper.A1(bundle2, "table-" + bundle.getString("contentId"), (String[]) null, (String) null);
            }

            public void h0(Bundle bundle) {
                EPOTableListActivityFragment.this.V2();
                EPOTableListActivityFragment.this.s4.k0(bundle.getString("word"), true);
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
        return compressHelper.V(bundle, "Select * from search where search match 'text:" + str + "* AND typeText:Table AND type:1'");
    }

    public void c3() {
        this.t4.setImageDrawable(b0().getDrawable(R.drawable.f761tables_icon));
    }

    public ArrayList<Bundle> g3(String str) {
        CompressHelper compressHelper = this.k4;
        Bundle bundle = this.h4;
        return compressHelper.V(bundle, "Select rowid as _id,word from spell where word match '" + str + "*'");
    }

    public String h3() {
        return "Tables";
    }
}
