package net.imedicaldoctor.imd.Fragments.UptodateDDX;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.SearchHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.ViewHolders.ChaptersAdapter;
import net.imedicaldoctor.imd.ViewHolders.ContentSearchAdapter;
import net.imedicaldoctor.imd.iMDActivity;

public class UTDDSearchActivity extends iMDActivity {

    public static class UTDDSearchFragment extends SearchHelperFragment {
        public void T0(Menu menu, MenuInflater menuInflater) {
            menuInflater.inflate(R.menu.f1494search, menu);
            this.s4 = (SearchView) menu.findItem(R.id.f814action_search).getActionView();
            O2();
        }

        public View onFragmentBind(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View inflate = layoutInflater.inflate(R.layout.f1246fragment_new_list, viewGroup, false);
            this.q4 = inflate;
            W2(bundle);
            S2();
            this.s4 = (SearchView) this.q4.findViewById(R.id.f1069search_view);
            O2();
            this.w4 = (RecyclerView) this.q4.findViewById(R.id.f1054recycler_view);
            ((RelativeLayout) this.q4.findViewById(R.id.f830background_layout)).setVisibility(0);
            this.n4 = this.k4.V(this.h4, "Select id as _id,* from diagnoses where isMain=1 order by diagnosisName collate nocase asc");
            this.l4 = new ChaptersAdapter(r(), this.n4, "diagnosisName") {
                public void f0(Bundle bundle, int i2) {
                    UTDDSearchFragment.this.V2();
                    UTDDSearchFragment uTDDSearchFragment = UTDDSearchFragment.this;
                    uTDDSearchFragment.k4.A1(uTDDSearchFragment.h4, bundle.getString("id"), (String[]) null, (String) null);
                }
            };
            this.m4 = new ContentSearchAdapter(r(), this.o4, "diagnosis", (String) null) {
                public void e0(Bundle bundle, int i2) {
                    UTDDSearchFragment.this.V2();
                    UTDDSearchFragment uTDDSearchFragment = UTDDSearchFragment.this;
                    uTDDSearchFragment.k4.A1(uTDDSearchFragment.h4, bundle.getString("id"), (String[]) null, (String) null);
                }
            };
            this.w4.setAdapter(this.l4);
            N2();
            o2(true);
            return inflate;
        }

        public ArrayList<Bundle> a3(String str) {
            CompressHelper compressHelper = this.k4;
            Bundle bundle = this.h4;
            return compressHelper.V(bundle, "Select id as _id,* from search where diagnosisSearch match '" + str + "*' order by isMain desc");
        }

        public ArrayList<Bundle> g3(String str) {
            CompressHelper compressHelper = this.k4;
            Bundle bundle = this.h4;
            return compressHelper.V(bundle, "Select rowid as _id,word from spell where word match '" + str + "*'");
        }
    }

    public void b1() {
        try {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a1(bundle, new UTDDSearchFragment());
    }
}
