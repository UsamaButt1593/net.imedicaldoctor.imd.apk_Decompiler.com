package net.imedicaldoctor.imd.Fragments.Micromedex;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.itextpdf.text.Annotation;
import java.util.ArrayList;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.SearchHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.ViewHolders.ChaptersAdapter;
import net.imedicaldoctor.imd.ViewHolders.RippleTextFullViewHolder;
import net.imedicaldoctor.imd.ViewHolders.SpellSearchAdapter;

public class MMNeoListActivityFragment extends SearchHelperFragment {
    public SpellSearchAdapter A4;
    public String B4;
    public TabLayout C4;

    public View onFragmentBind(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.q4 = layoutInflater.inflate(R.layout.f1247fragment_new_list_tab, viewGroup, false);
        W2(bundle);
        S2();
        this.s4 = (SearchView) this.q4.findViewById(R.id.f1069search_view);
        Q2();
        this.w4 = (RecyclerView) this.q4.findViewById(R.id.f1054recycler_view);
        this.C4 = (TabLayout) this.q4.findViewById(R.id.f1111tabs);
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
            this.n4 = this.k4.V(this.h4, "SELECT * FROM drug_class_idx order by title collate nocase asc");
            this.C4.setVisibility(0);
        } else {
            CompressHelper compressHelper = this.k4;
            Bundle bundle2 = this.h4;
            this.n4 = compressHelper.V(bundle2, "select drug_class_int.name as title, drug_class_int.drug_Id as drug_id ,genericTitle as subtitle from drug_class_int inner join (select drug_id as generic_id, name as genericTitle from drug_idx where has_generic=0) on drug_class_int.drug_id =generic_id where class_id=" + this.B4 + " order by drug_class_int.name collate nocase asc");
            this.C4.setVisibility(8);
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.w4.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.w4.setLayoutParams(layoutParams);
        }
        String[] strArr = {"Drugs", "Enteral Formulas"};
        for (int i2 = 0; i2 < 2; i2++) {
            TabLayout.Tab I = this.C4.I();
            I.D(strArr[i2]);
            this.C4.i(I);
        }
        this.C4.setOnTabSelectedListener((TabLayout.OnTabSelectedListener) new TabLayout.OnTabSelectedListener() {
            public void a(TabLayout.Tab tab) {
            }

            public void b(TabLayout.Tab tab) {
                MMNeoListActivityFragment mMNeoListActivityFragment;
                CompressHelper compressHelper;
                Bundle bundle;
                String str;
                if (tab.k() == 0) {
                    mMNeoListActivityFragment = MMNeoListActivityFragment.this;
                    compressHelper = mMNeoListActivityFragment.k4;
                    bundle = mMNeoListActivityFragment.h4;
                    str = "SELECT * FROM drug_class_idx order by title collate nocase asc";
                } else {
                    mMNeoListActivityFragment = MMNeoListActivityFragment.this;
                    compressHelper = mMNeoListActivityFragment.k4;
                    bundle = mMNeoListActivityFragment.h4;
                    str = "SELECT * FROM formula_idx order by title collate nocase asc";
                }
                mMNeoListActivityFragment.n4 = compressHelper.V(bundle, str);
                if (MMNeoListActivityFragment.this.s4.getQuery().toString().length() > 0) {
                    MMNeoListActivityFragment mMNeoListActivityFragment2 = MMNeoListActivityFragment.this;
                    mMNeoListActivityFragment2.o4 = mMNeoListActivityFragment2.a3(mMNeoListActivityFragment2.s4.getQuery().toString());
                    MMNeoListActivityFragment.this.X2();
                    return;
                }
                MMNeoListActivityFragment mMNeoListActivityFragment3 = MMNeoListActivityFragment.this;
                ((ChaptersAdapter) mMNeoListActivityFragment3.l4).g0(mMNeoListActivityFragment3.n4);
                MMNeoListActivityFragment mMNeoListActivityFragment4 = MMNeoListActivityFragment.this;
                mMNeoListActivityFragment4.w4.setAdapter(mMNeoListActivityFragment4.l4);
            }

            public void c(TabLayout.Tab tab) {
            }
        });
        this.l4 = new ChaptersAdapter(r(), this.n4, "title", R.layout.f1346list_view_item_ripple_text_full) {
            public void e0(RecyclerView.ViewHolder viewHolder, final Bundle bundle, final int i2) {
                RippleTextFullViewHolder rippleTextFullViewHolder = (RippleTextFullViewHolder) viewHolder;
                rippleTextFullViewHolder.I.setText(bundle.getString("title"));
                String string = bundle.getString("subtitle");
                if (bundle.getString("title").equals(string) || string == null || string.length() == 0) {
                    rippleTextFullViewHolder.J.setVisibility(8);
                } else {
                    rippleTextFullViewHolder.J.setVisibility(0);
                    rippleTextFullViewHolder.J.setText(string);
                }
                rippleTextFullViewHolder.M.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        MMNeoListActivityFragment.this.i3(bundle, i2);
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
                if (bundle.getString(Annotation.i3).equals(bundle.getString("text")) || bundle.getString(Annotation.i3).length() == 0) {
                    textView = rippleTextFullViewHolder.J;
                    i3 = 8;
                } else {
                    textView = rippleTextFullViewHolder.J;
                    i3 = 0;
                }
                textView.setVisibility(i3);
                rippleTextFullViewHolder.M.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        CompressHelper compressHelper;
                        Bundle bundle;
                        StringBuilder sb;
                        String str;
                        MMNeoListActivityFragment.this.V2();
                        if (bundle.getString("typeText").equals("Drug")) {
                            MMNeoListActivityFragment mMNeoListActivityFragment = MMNeoListActivityFragment.this;
                            compressHelper = mMNeoListActivityFragment.k4;
                            bundle = mMNeoListActivityFragment.h4;
                            sb = new StringBuilder();
                            str = "drug-";
                        } else {
                            MMNeoListActivityFragment mMNeoListActivityFragment2 = MMNeoListActivityFragment.this;
                            compressHelper = mMNeoListActivityFragment2.k4;
                            bundle = mMNeoListActivityFragment2.h4;
                            sb = new StringBuilder();
                            str = "formula-";
                        }
                        sb.append(str);
                        sb.append(bundle.getString("contentId"));
                        compressHelper.A1(bundle, sb.toString(), (String[]) null, (String) null);
                    }
                });
            }

            public void h0(Bundle bundle) {
                MMNeoListActivityFragment.this.V2();
                MMNeoListActivityFragment.this.s4.k0(bundle.getString("word"), true);
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
        CompressHelper compressHelper;
        Bundle bundle;
        StringBuilder sb;
        String str2;
        if (this.C4.getSelectedTabPosition() == 0) {
            compressHelper = this.k4;
            bundle = this.h4;
            sb = new StringBuilder();
            sb.append("Select * from search where search match '(text:");
            sb.append(str);
            sb.append("* OR content:");
            sb.append(str);
            str2 = "*) AND type:1 AND typeText:Drug'";
        } else {
            compressHelper = this.k4;
            bundle = this.h4;
            sb = new StringBuilder();
            sb.append("Select * from search where search match '(text:");
            sb.append(str);
            sb.append("* OR content:");
            sb.append(str);
            str2 = "*) AND type:1 AND typeText:Formula'";
        }
        sb.append(str2);
        return compressHelper.W(bundle, sb.toString(), "fsearch.sqlite");
    }

    public ArrayList<Bundle> g3(String str) {
        CompressHelper compressHelper = this.k4;
        Bundle bundle = this.h4;
        return compressHelper.W(bundle, "Select rowid as _id,word from spell where word match '" + str + "*'", "fsearch.sqlite");
    }

    public void i3(Bundle bundle, int i2) {
        CompressHelper compressHelper;
        Bundle bundle2;
        StringBuilder sb;
        String str;
        V2();
        if (this.B4 != null) {
            compressHelper = this.k4;
            bundle2 = this.h4;
            sb = new StringBuilder();
            sb.append("drug-");
            str = "drug_id";
        } else if (this.C4.getSelectedTabPosition() == 0) {
            Bundle bundle3 = new Bundle();
            bundle3.putBundle("DB", this.h4);
            bundle3.putString("ParentId", bundle.getString("class_id"));
            this.k4.N(MMNeoListActivity.class, MMNeoListActivityFragment.class, bundle3);
            return;
        } else {
            compressHelper = this.k4;
            bundle2 = this.h4;
            sb = new StringBuilder();
            sb.append("formula-");
            str = "formula_id";
        }
        sb.append(bundle.getString(str));
        compressHelper.A1(bundle2, sb.toString(), (String[]) null, (String) null);
    }
}
