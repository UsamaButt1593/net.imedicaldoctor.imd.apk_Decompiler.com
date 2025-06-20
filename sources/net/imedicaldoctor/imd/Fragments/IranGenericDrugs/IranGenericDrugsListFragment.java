package net.imedicaldoctor.imd.Fragments.IranGenericDrugs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.itextpdf.text.Annotation;
import java.util.ArrayList;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.SearchHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.ViewHolders.ChaptersAdapter;
import net.imedicaldoctor.imd.ViewHolders.RippleTextFullViewHolder;
import net.imedicaldoctor.imd.ViewHolders.SpellSearchAdapter;
import org.apache.commons.lang3.StringUtils;

public class IranGenericDrugsListFragment extends SearchHelperFragment {
    public SpellSearchAdapter A4;
    public String B4;
    public ArrayList<Bundle> C4;

    public View U0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.q4 = layoutInflater.inflate(R.layout.f1246fragment_new_list, viewGroup, false);
        W2(bundle);
        S2();
        this.s4 = (SearchView) this.q4.findViewById(R.id.f1069search_view);
        Q2();
        this.w4 = (RecyclerView) this.q4.findViewById(R.id.f1054recycler_view);
        this.C4 = new ArrayList<>();
        ((AppBarLayout) this.q4.findViewById(R.id.f825appbar)).D(true, false);
        ((RelativeLayout) this.q4.findViewById(R.id.f830background_layout)).setVisibility(0);
        this.l4 = new ChaptersAdapter(r(), this.n4, "name", R.layout.f1346list_view_item_ripple_text_full) {
            public void e0(RecyclerView.ViewHolder viewHolder, Bundle bundle, int i2) {
                RippleTextFullViewHolder rippleTextFullViewHolder = (RippleTextFullViewHolder) viewHolder;
                rippleTextFullViewHolder.I.setText(bundle.getString("shortForm") + StringUtils.SPACE + bundle.getString("name") + StringUtils.SPACE + bundle.getString("dose"));
                rippleTextFullViewHolder.J.setVisibility(8);
                if (bundle.getString("genName").length() > 0) {
                    rippleTextFullViewHolder.J.setText(bundle.getString("genForm") + StringUtils.SPACE + bundle.getString("genName") + StringUtils.SPACE + bundle.getString("genDose"));
                    rippleTextFullViewHolder.J.setVisibility(0);
                }
            }

            public RecyclerView.ViewHolder h0(View view) {
                RippleTextFullViewHolder rippleTextFullViewHolder = new RippleTextFullViewHolder(view);
                rippleTextFullViewHolder.K.setVisibility(8);
                rippleTextFullViewHolder.L.setVisibility(8);
                return rippleTextFullViewHolder;
            }
        };
        this.A4 = new SpellSearchAdapter(r(), this.o4, "text", Annotation.i3, R.layout.f1346list_view_item_ripple_text_full) {
            public void e0(RecyclerView.ViewHolder viewHolder, final Bundle bundle, int i2) {
                RippleTextFullViewHolder rippleTextFullViewHolder = (RippleTextFullViewHolder) viewHolder;
                rippleTextFullViewHolder.I.setText(bundle.getString("shortForm") + StringUtils.SPACE + bundle.getString("name") + StringUtils.SPACE + bundle.getString("dose"));
                rippleTextFullViewHolder.J.setVisibility(8);
                if (bundle.getString("genName").length() > 0) {
                    rippleTextFullViewHolder.J.setText(bundle.getString("genForm") + StringUtils.SPACE + bundle.getString("genName") + StringUtils.SPACE + bundle.getString("genDose"));
                    rippleTextFullViewHolder.J.setVisibility(0);
                }
                rippleTextFullViewHolder.M.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        IranGenericDrugsListFragment.this.V2();
                        IranGenericDrugsListFragment.this.C4.add(bundle);
                        IranGenericDrugsListFragment.this.s4.k0("", false);
                        IranGenericDrugsListFragment iranGenericDrugsListFragment = IranGenericDrugsListFragment.this;
                        ((ChaptersAdapter) iranGenericDrugsListFragment.l4).g0(iranGenericDrugsListFragment.C4);
                        IranGenericDrugsListFragment.this.l4.G();
                        IranGenericDrugsListFragment iranGenericDrugsListFragment2 = IranGenericDrugsListFragment.this;
                        iranGenericDrugsListFragment2.w4.setAdapter(iranGenericDrugsListFragment2.l4);
                    }
                });
            }

            public void h0(Bundle bundle) {
                IranGenericDrugsListFragment.this.V2();
                IranGenericDrugsListFragment.this.s4.k0(bundle.getString("word"), true);
            }

            public RecyclerView.ViewHolder j0(View view) {
                RippleTextFullViewHolder rippleTextFullViewHolder = new RippleTextFullViewHolder(view);
                rippleTextFullViewHolder.K.setVisibility(8);
                return rippleTextFullViewHolder;
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
        return compressHelper.V(bundle, "Select * from search where search match 'name:" + str + "*'");
    }

    public ArrayList<Bundle> g3(String str) {
        CompressHelper compressHelper = this.k4;
        Bundle bundle = this.h4;
        return compressHelper.V(bundle, "Select word from spell where word match '" + str + "*'");
    }
}
