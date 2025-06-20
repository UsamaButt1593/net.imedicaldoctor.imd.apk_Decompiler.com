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

public class EPODxListActivityFragment extends SearchHelperFragment {
    public SpellSearchAdapter A4;
    public String B4;

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
            str2 = "Select * from dx_cats";
        } else {
            compressHelper = this.k4;
            bundle2 = this.h4;
            str2 = "SELECT * FROM dx_topics where id in ( select topicid from dx_cats_topics where catId=" + this.B4 + ")";
        }
        this.n4 = compressHelper.V(bundle2, str2);
        this.l4 = new ChaptersAdapter(r(), this.n4, "title", R.layout.f1343list_view_item_ripple_text_arrow) {
            public void f0(Bundle bundle, int i2) {
                EPODxListActivityFragment.this.V2();
                EPODxListActivityFragment ePODxListActivityFragment = EPODxListActivityFragment.this;
                if (ePODxListActivityFragment.B4 == null) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putBundle("DB", EPODxListActivityFragment.this.h4);
                    bundle2.putString("ParentId", bundle.getString("id"));
                    EPODxListActivityFragment.this.k4.N(EPODxListActivity.class, EPODxListActivityFragment.class, bundle2);
                    return;
                }
                CompressHelper compressHelper = ePODxListActivityFragment.k4;
                Bundle bundle3 = ePODxListActivityFragment.h4;
                compressHelper.A1(bundle3, "dx-" + bundle.getString("mId"), (String[]) null, (String) null);
            }
        };
        this.A4 = new SpellSearchAdapter(r(), this.o4, "text", (String) null) {
            public void g0(Bundle bundle, int i2) {
                EPODxListActivityFragment.this.V2();
                EPODxListActivityFragment ePODxListActivityFragment = EPODxListActivityFragment.this;
                CompressHelper compressHelper = ePODxListActivityFragment.k4;
                Bundle bundle2 = ePODxListActivityFragment.h4;
                compressHelper.A1(bundle2, "dx-" + bundle.getString("contentId"), (String[]) null, (String) null);
            }

            public void h0(Bundle bundle) {
                EPODxListActivityFragment.this.V2();
                EPODxListActivityFragment.this.s4.k0(bundle.getString("word"), true);
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
        return compressHelper.V(bundle, "Select * from search where search match 'text:" + str + "* AND typeText:Dx AND type:1'");
    }

    public void c3() {
        this.t4.setImageDrawable(b0().getDrawable(R.drawable.f658id_tx_icon));
    }

    public ArrayList<Bundle> g3(String str) {
        CompressHelper compressHelper = this.k4;
        Bundle bundle = this.h4;
        return compressHelper.V(bundle, "Select rowid as _id,word from spell where word match '" + str + "*'");
    }

    public String h3() {
        return "Diseases";
    }
}
