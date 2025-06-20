package net.imedicaldoctor.imd.Fragments.Martindale;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
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

public class MDListActivityFragment extends SearchHelperFragment {
    public SpellSearchAdapter A4;
    public String B4;

    public View onFragmentBind(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
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
            this.B4 = "0";
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
            this.B4 = y().getString("ParentId");
        }
        CompressHelper compressHelper = this.k4;
        Bundle bundle2 = this.h4;
        this.n4 = compressHelper.V(bundle2, "Select * from toc where parentId=" + this.B4);
        this.l4 = new ChaptersAdapter(r(), this.n4, "title", R.layout.f1346list_view_item_ripple_text_full) {
            public void e0(RecyclerView.ViewHolder viewHolder, final Bundle bundle, final int i2) {
                RippleTextFullViewHolder rippleTextFullViewHolder = (RippleTextFullViewHolder) viewHolder;
                rippleTextFullViewHolder.I.setText(bundle.getString("title"));
                String string = bundle.getString("genericName");
                if (string.length() == 0) {
                    rippleTextFullViewHolder.J.setVisibility(8);
                } else {
                    rippleTextFullViewHolder.J.setVisibility(0);
                    rippleTextFullViewHolder.J.setText(string);
                }
                rippleTextFullViewHolder.M.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        MDListActivityFragment.this.i3(bundle, i2);
                    }
                });
            }

            public RecyclerView.ViewHolder h0(View view) {
                RippleTextFullViewHolder rippleTextFullViewHolder = new RippleTextFullViewHolder(view);
                rippleTextFullViewHolder.K.setVisibility(8);
                return rippleTextFullViewHolder;
            }
        };
        this.A4 = new SpellSearchAdapter(r(), this.o4, "text", (String) null, R.layout.f1346list_view_item_ripple_text_full) {
            public void e0(RecyclerView.ViewHolder viewHolder, final Bundle bundle, int i2) {
                TextView textView;
                int i3;
                RippleTextFullViewHolder rippleTextFullViewHolder = (RippleTextFullViewHolder) viewHolder;
                rippleTextFullViewHolder.I.setText(bundle.getString("text"));
                rippleTextFullViewHolder.J.setText(bundle.getString(Annotation.i3));
                if (bundle.getString(Annotation.i3).length() == 0) {
                    textView = rippleTextFullViewHolder.J;
                    i3 = 8;
                } else {
                    textView = rippleTextFullViewHolder.J;
                    i3 = 0;
                }
                textView.setVisibility(i3);
                rippleTextFullViewHolder.M.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        MDListActivityFragment.this.V2();
                        MDListActivityFragment mDListActivityFragment = MDListActivityFragment.this;
                        mDListActivityFragment.k4.A1(mDListActivityFragment.h4, bundle.getString("contentId"), (String[]) null, (String) null);
                    }
                });
            }

            public void h0(Bundle bundle) {
                MDListActivityFragment.this.V2();
                MDListActivityFragment.this.s4.k0(bundle.getString("word"), true);
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
        return compressHelper.V(bundle, "Select distinct(text),* from search where search match '(text:" + str + "*) AND (type:1)' order by type asc");
    }

    public ArrayList<Bundle> g3(String str) {
        CompressHelper compressHelper = this.k4;
        Bundle bundle = this.h4;
        return compressHelper.V(bundle, "Select rowid as _id,word from spell where word match '" + str + "*'");
    }

    public void i3(Bundle bundle, int i2) {
        V2();
        if (bundle.getString("docId").equals("0")) {
            Bundle bundle2 = new Bundle();
            bundle2.putBundle("DB", this.h4);
            bundle2.putString("ParentId", bundle.getString("id"));
            this.k4.N(MDListActivity.class, MDListActivityFragment.class, bundle2);
            return;
        }
        this.k4.A1(this.h4, bundle.getString("docId"), (String[]) null, (String) null);
    }
}
