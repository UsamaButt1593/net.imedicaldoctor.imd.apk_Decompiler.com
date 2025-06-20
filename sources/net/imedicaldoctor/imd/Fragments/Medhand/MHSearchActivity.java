package net.imedicaldoctor.imd.Fragments.Medhand;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import java.util.ArrayList;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.SearchHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.ViewHolders.ContentSearchAdapter;
import net.imedicaldoctor.imd.ViewHolders.StatusAdapter;
import net.imedicaldoctor.imd.iMDActivity;

public class MHSearchActivity extends iMDActivity {

    public static class MHSearchFragment extends SearchHelperFragment {
        private AsyncTask A4;

        public void T0(Menu menu, MenuInflater menuInflater) {
            menuInflater.inflate(R.menu.f1494search, menu);
            this.s4 = (SearchView) menu.findItem(R.id.f814action_search).getActionView();
            P2();
        }

        public View onFragmentBind(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View inflate = layoutInflater.inflate(R.layout.f1243fragment_mhsearch_new, viewGroup, false);
            this.q4 = inflate;
            W2(bundle);
            S2();
            this.s4 = (SearchView) this.q4.findViewById(R.id.f1069search_view);
            P2();
            this.w4 = (RecyclerView) this.q4.findViewById(R.id.f1054recycler_view);
            AppBarLayout appBarLayout = (AppBarLayout) this.q4.findViewById(R.id.f825appbar);
            final RelativeLayout relativeLayout = (RelativeLayout) this.q4.findViewById(R.id.f830background_layout);
            appBarLayout.D(false, false);
            appBarLayout.postDelayed(new Runnable() {
                public void run() {
                    relativeLayout.setVisibility(0);
                }
            }, 800);
            this.l4 = new StatusAdapter(r(), "Search Book");
            this.m4 = new ContentSearchAdapter(r(), this.o4, "Text", "table") {
                public void e0(Bundle bundle, int i2) {
                    MHSearchFragment.this.V2();
                    MHSearchFragment mHSearchFragment = MHSearchFragment.this;
                    mHSearchFragment.k4.A1(mHSearchFragment.h4, bundle.getString("URL"), (String[]) null, (String) null);
                }
            };
            ((Button) this.q4.findViewById(R.id.f1073show_book)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    MHSearchFragment mHSearchFragment = MHSearchFragment.this;
                    mHSearchFragment.k4.A1(mHSearchFragment.h4, "index.html", (String[]) null, (String) null);
                }
            });
            this.w4.setAdapter(this.l4);
            N2();
            o2(true);
            return inflate;
        }

        public ArrayList<Bundle> a3(String str) {
            CompressHelper compressHelper = this.k4;
            Bundle bundle = this.h4;
            return compressHelper.W(bundle, "select rowid as _id,* from search where text match '" + str + "*'", "fsearch.db");
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a1(bundle, new MHSearchFragment());
    }
}
