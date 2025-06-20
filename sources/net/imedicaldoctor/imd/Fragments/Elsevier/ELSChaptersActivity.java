package net.imedicaldoctor.imd.Fragments.Elsevier;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.SearchView;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.SearchHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.ViewHolders.ChaptersAdapter;
import net.imedicaldoctor.imd.ViewHolders.ContentSearchAdapter;
import net.imedicaldoctor.imd.iMDActivity;

public class ELSChaptersActivity extends iMDActivity {

    public static class ELSChaptersFragment extends SearchHelperFragment {
        private static String A4;

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
            this.n4 = this.k4.V(this.h4, "Select id as _id,* from chapters");
            this.l4 = new ChaptersAdapter(r(), this.n4, "name") {
                public void f0(Bundle bundle, int i2) {
                    ELSChaptersFragment.this.V2();
                    ELSChaptersFragment eLSChaptersFragment = ELSChaptersFragment.this;
                    eLSChaptersFragment.k4.A1(eLSChaptersFragment.h4, bundle.getString("docId"), (String[]) null, (String) null);
                }
            };
            this.m4 = new ContentSearchAdapter(r(), this.o4, "text", "subText") {
                public void e0(Bundle bundle, int i2) {
                    Bundle e0;
                    String str;
                    ELSChaptersFragment.this.V2();
                    String string = bundle.getString("type");
                    String string2 = bundle.getString("contentId");
                    if (string.equals(IcyHeaders.a3)) {
                        ELSChaptersFragment eLSChaptersFragment = ELSChaptersFragment.this;
                        eLSChaptersFragment.k4.A1(eLSChaptersFragment.h4, string2, (String[]) null, (String) null);
                        return;
                    }
                    if (string.equals(ExifInterface.Z4)) {
                        ELSChaptersFragment eLSChaptersFragment2 = ELSChaptersFragment.this;
                        CompressHelper compressHelper = eLSChaptersFragment2.k4;
                        Bundle bundle2 = eLSChaptersFragment2.h4;
                        e0 = compressHelper.e0(bundle2, "select * from images where id='" + string2 + "'");
                        if (e0 != null) {
                            str = "docId";
                        } else {
                            return;
                        }
                    } else if (string.equals("4")) {
                        ELSChaptersFragment eLSChaptersFragment3 = ELSChaptersFragment.this;
                        CompressHelper compressHelper2 = eLSChaptersFragment3.k4;
                        Bundle bundle3 = eLSChaptersFragment3.h4;
                        e0 = compressHelper2.e0(bundle3, "select * from tables where id=" + string2);
                        if (e0 != null) {
                            str = "sectionId";
                        } else {
                            return;
                        }
                    } else if (string.equals("5")) {
                        ELSChaptersFragment eLSChaptersFragment4 = ELSChaptersFragment.this;
                        eLSChaptersFragment4.k4.A1(eLSChaptersFragment4.h4, string2, eLSChaptersFragment4.T2(bundle.getString("subText")), (String) null);
                        return;
                    } else {
                        return;
                    }
                    String string3 = e0.getString(str);
                    String string4 = e0.getString("goto");
                    ELSChaptersFragment eLSChaptersFragment5 = ELSChaptersFragment.this;
                    eLSChaptersFragment5.k4.A1(eLSChaptersFragment5.h4, string3, (String[]) null, string4);
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
            return compressHelper.V(bundle, "Select rowid as _id, Text as text,snippet(search) as subText, type, contentId from search where search match '" + str + "' ORDER BY rank(matchinfo(search)) DESC");
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
        a1(bundle, new ELSChaptersFragment());
    }
}
