package net.imedicaldoctor.imd.Fragments.IranDaru;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.SearchHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.ViewHolders.SpellSearchAdapter;
import net.imedicaldoctor.imd.ViewHolders.StatusAdapter;
import net.imedicaldoctor.imd.iMDActivity;

public class IDSearchActivity extends iMDActivity {

    public static class IDSearchFragment extends SearchHelperFragment {
        private AsyncTask A4;
        private SpellSearchAdapter B4;

        public void T0(Menu menu, MenuInflater menuInflater) {
            menuInflater.inflate(R.menu.f1494search, menu);
            this.s4 = (SearchView) menu.findItem(R.id.f814action_search).getActionView();
            Q2();
        }

        public View U0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View inflate = layoutInflater.inflate(R.layout.f1246fragment_new_list, viewGroup, false);
            this.q4 = inflate;
            W2(bundle);
            S2();
            this.s4 = (SearchView) this.q4.findViewById(R.id.f1069search_view);
            Q2();
            this.w4 = (RecyclerView) this.q4.findViewById(R.id.f1054recycler_view);
            ((RelativeLayout) this.q4.findViewById(R.id.f830background_layout)).setVisibility(0);
            this.l4 = new StatusAdapter(r(), "Search Drugs");
            this.B4 = new SpellSearchAdapter(r(), this.o4, "drug", (String) null) {
                public void g0(Bundle bundle, int i2) {
                    IDSearchFragment.this.V2();
                    IDSearchFragment iDSearchFragment = IDSearchFragment.this;
                    iDSearchFragment.k4.A1(iDSearchFragment.h4, bundle.getString("drugId"), (String[]) null, (String) null);
                }

                public void h0(Bundle bundle) {
                    IDSearchFragment.this.V2();
                    IDSearchFragment.this.s4.k0(bundle.getString("word"), true);
                }
            };
            this.w4.setAdapter(this.l4);
            N2();
            o2(false);
            return inflate;
        }

        public void X2() {
            this.B4.i0(this.o4, this.p4);
            this.w4.setAdapter(this.B4);
        }

        public ArrayList<Bundle> a3(String str) {
            CompressHelper compressHelper = this.k4;
            Bundle bundle = this.h4;
            return compressHelper.V(bundle, "Select rowid as _id,* from Search where drugSearch match '" + str + "*' order by drug asc");
        }

        public ArrayList<Bundle> g3(String str) {
            CompressHelper compressHelper = this.k4;
            Bundle bundle = this.h4;
            return compressHelper.V(bundle, "Select rowid as _id,word from spell where word match '" + str + "*'");
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a1(bundle, new IDSearchFragment());
    }
}
