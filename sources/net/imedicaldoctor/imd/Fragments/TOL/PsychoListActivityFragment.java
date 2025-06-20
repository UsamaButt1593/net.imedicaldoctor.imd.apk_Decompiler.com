package net.imedicaldoctor.imd.Fragments.TOL;

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
import net.imedicaldoctor.imd.ViewHolders.RippleTextGotoViewHolder;
import net.imedicaldoctor.imd.ViewHolders.SpellSearchAdapter;

public class PsychoListActivityFragment extends SearchHelperFragment {
    public SpellSearchAdapter A4;
    public String B4;

    public View U0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.q4 = layoutInflater.inflate(R.layout.f1246fragment_new_list, viewGroup, false);
        W2(bundle);
        S2();
        this.s4 = (SearchView) this.q4.findViewById(R.id.f1069search_view);
        O2();
        this.w4 = (RecyclerView) this.q4.findViewById(R.id.f1054recycler_view);
        ((RelativeLayout) this.q4.findViewById(R.id.f830background_layout)).setVisibility(0);
        AppBarLayout appBarLayout = (AppBarLayout) this.q4.findViewById(R.id.f825appbar);
        ArrayList<Bundle> arrayList = new ArrayList<>();
        this.n4 = arrayList;
        arrayList.add(i3("Tower Of London Test", 1));
        this.n4.add(i3("IOWA Gambling Test", 10));
        this.n4.add(i3("Share Result", 100));
        AnonymousClass1 r2 = new ChaptersAdapter(r(), this.n4, "title", R.layout.f1340list_view_item_ripple_goto_arrow) {
            public void e0(RecyclerView.ViewHolder viewHolder, final Bundle bundle, final int i2) {
                RippleTextGotoViewHolder rippleTextGotoViewHolder = (RippleTextGotoViewHolder) viewHolder;
                rippleTextGotoViewHolder.I.setText(bundle.getString("title"));
                rippleTextGotoViewHolder.L.setVisibility(8);
                rippleTextGotoViewHolder.K.setVisibility(8);
                rippleTextGotoViewHolder.J.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        PsychoListActivityFragment.this.j3(bundle, i2);
                    }
                });
            }

            public RecyclerView.ViewHolder h0(View view) {
                return new RippleTextGotoViewHolder(view);
            }
        };
        this.l4 = r2;
        this.w4.setAdapter(r2);
        N2();
        o2(false);
        return this.q4;
    }

    public String h3() {
        return "Psychological Tests";
    }

    public Bundle i3(String str, int i2) {
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        bundle.putInt("id", i2);
        return bundle;
    }

    public void j3(Bundle bundle, int i2) {
        V2();
        if (bundle.getInt("id") == 100) {
            CompressHelper compressHelper = this.k4;
            compressHelper.u2(compressHelper.R(), "*/*");
            return;
        }
        CompressHelper compressHelper2 = this.k4;
        Bundle bundle2 = this.h4;
        compressHelper2.A1(bundle2, bundle.getInt("id") + "", (String[]) null, (String) null);
    }
}
