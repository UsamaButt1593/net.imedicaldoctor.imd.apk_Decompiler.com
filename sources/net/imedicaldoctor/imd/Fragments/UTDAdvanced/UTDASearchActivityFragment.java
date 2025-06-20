package net.imedicaldoctor.imd.Fragments.UTDAdvanced;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.itextpdf.text.Annotation;
import com.itextpdf.tool.xml.html.HTML;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersDecoration;
import java.util.ArrayList;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.CustomItemDecoration;
import net.imedicaldoctor.imd.Fragments.SearchHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.ViewHolders.ChaptersSectionAdapter;
import net.imedicaldoctor.imd.ViewHolders.RippleTextFullViewHolder;
import net.imedicaldoctor.imd.ViewHolders.SpellSearchAdapter;

public class UTDASearchActivityFragment extends SearchHelperFragment {
    /* access modifiers changed from: private */
    public StickyRecyclerHeadersDecoration A4;
    public SpellSearchAdapter B4;
    public String C4;
    public TabLayout D4;

    public View U0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.q4 = layoutInflater.inflate(R.layout.f1247fragment_new_list_tab, viewGroup, false);
        W2(bundle);
        S2();
        this.s4 = (SearchView) this.q4.findViewById(R.id.f1069search_view);
        Q2();
        this.w4 = (RecyclerView) this.q4.findViewById(R.id.f1054recycler_view);
        this.D4 = (TabLayout) this.q4.findViewById(R.id.f1111tabs);
        ((AppBarLayout) this.q4.findViewById(R.id.f825appbar)).D(true, false);
        ((RelativeLayout) this.q4.findViewById(R.id.f830background_layout)).setVisibility(0);
        this.C4 = null;
        this.n4 = this.k4.W(this.h4, "SELECT * FROM toc order by section asc", "pathways.db");
        this.D4.setVisibility(0);
        String[] strArr = {"Pathways", "Lab Interpretation"};
        for (int i2 = 0; i2 < 2; i2++) {
            TabLayout.Tab I = this.D4.I();
            I.D(strArr[i2]);
            this.D4.i(I);
        }
        this.D4.setOnTabSelectedListener((TabLayout.OnTabSelectedListener) new TabLayout.OnTabSelectedListener() {
            public void a(TabLayout.Tab tab) {
            }

            public void b(TabLayout.Tab tab) {
                UTDASearchActivityFragment uTDASearchActivityFragment;
                CompressHelper compressHelper;
                Bundle bundle;
                String str;
                String str2;
                if (tab.k() == 0) {
                    uTDASearchActivityFragment = UTDASearchActivityFragment.this;
                    compressHelper = uTDASearchActivityFragment.k4;
                    bundle = uTDASearchActivityFragment.h4;
                    str = "SELECT * FROM TOC order by section asc";
                    str2 = "pathways.db";
                } else {
                    uTDASearchActivityFragment = UTDASearchActivityFragment.this;
                    compressHelper = uTDASearchActivityFragment.k4;
                    bundle = uTDASearchActivityFragment.h4;
                    str = "SELECT * FROM TOC";
                    str2 = "lab.db";
                }
                uTDASearchActivityFragment.n4 = compressHelper.W(bundle, str, str2);
                if (UTDASearchActivityFragment.this.s4.getQuery().toString().length() > 0) {
                    UTDASearchActivityFragment uTDASearchActivityFragment2 = UTDASearchActivityFragment.this;
                    uTDASearchActivityFragment2.o4 = uTDASearchActivityFragment2.a3(uTDASearchActivityFragment2.s4.getQuery().toString());
                    UTDASearchActivityFragment.this.X2();
                    return;
                }
                UTDASearchActivityFragment uTDASearchActivityFragment3 = UTDASearchActivityFragment.this;
                ((ChaptersSectionAdapter) uTDASearchActivityFragment3.l4).g0(uTDASearchActivityFragment3.n4);
                UTDASearchActivityFragment uTDASearchActivityFragment4 = UTDASearchActivityFragment.this;
                uTDASearchActivityFragment4.w4.setAdapter(uTDASearchActivityFragment4.l4);
            }

            public void c(TabLayout.Tab tab) {
            }
        });
        this.l4 = new ChaptersSectionAdapter(r(), this.n4, "title", HTML.Tag.V) {
            public void f0(Bundle bundle, int i2) {
                CompressHelper compressHelper;
                Bundle bundle2;
                StringBuilder sb;
                String str;
                UTDASearchActivityFragment.this.V2();
                if (bundle.getString("leaf").equals(IcyHeaders.a3)) {
                    if (UTDASearchActivityFragment.this.D4.getSelectedTabPosition() == 0) {
                        compressHelper = new CompressHelper(UTDASearchActivityFragment.this.r());
                        bundle2 = UTDASearchActivityFragment.this.h4;
                        sb = new StringBuilder();
                        str = "pathway-";
                    } else {
                        compressHelper = new CompressHelper(UTDASearchActivityFragment.this.r());
                        bundle2 = UTDASearchActivityFragment.this.h4;
                        sb = new StringBuilder();
                        str = "lab-";
                    }
                    sb.append(str);
                    sb.append(bundle.getString("id"));
                    compressHelper.A1(bundle2, sb.toString(), (String[]) null, (String) null);
                }
            }
        };
        this.B4 = new SpellSearchAdapter(r(), this.o4, "text", (String) null, R.layout.f1346list_view_item_ripple_text_full) {
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
                        UTDASearchActivityFragment.this.V2();
                        if (bundle.getString("typeText").equals("Pathway")) {
                            UTDASearchActivityFragment uTDASearchActivityFragment = UTDASearchActivityFragment.this;
                            compressHelper = uTDASearchActivityFragment.k4;
                            bundle = uTDASearchActivityFragment.h4;
                            sb = new StringBuilder();
                            str = "pathway-";
                        } else {
                            UTDASearchActivityFragment uTDASearchActivityFragment2 = UTDASearchActivityFragment.this;
                            compressHelper = uTDASearchActivityFragment2.k4;
                            bundle = uTDASearchActivityFragment2.h4;
                            sb = new StringBuilder();
                            str = "lab-";
                        }
                        sb.append(str);
                        sb.append(bundle.getString("contentId"));
                        compressHelper.A1(bundle, sb.toString(), (String[]) null, (String) null);
                    }
                });
            }

            public void h0(Bundle bundle) {
                UTDASearchActivityFragment.this.V2();
                UTDASearchActivityFragment.this.s4.k0(bundle.getString("word"), true);
            }

            public RecyclerView.ViewHolder j0(View view) {
                RippleTextFullViewHolder rippleTextFullViewHolder = new RippleTextFullViewHolder(view);
                rippleTextFullViewHolder.K.setVisibility(8);
                return rippleTextFullViewHolder;
            }
        };
        this.w4.setAdapter(this.l4);
        StickyRecyclerHeadersDecoration stickyRecyclerHeadersDecoration = new StickyRecyclerHeadersDecoration((StickyRecyclerHeadersAdapter) this.l4);
        this.A4 = stickyRecyclerHeadersDecoration;
        this.w4.setItemDecoration(stickyRecyclerHeadersDecoration);
        this.w4.setLayoutManager(new LinearLayoutManager(r()));
        this.w4.setItemAnimator(new DefaultItemAnimator());
        this.w4.setItemDecoration(new CustomItemDecoration(r()));
        this.l4.Z(new RecyclerView.AdapterDataObserver() {
            public void a() {
                UTDASearchActivityFragment.this.A4.n();
            }
        });
        N2();
        o2(false);
        return this.q4;
    }

    public void X2() {
        this.B4.i0(this.o4, this.p4);
        this.w4.setAdapter(this.B4);
        this.A4.n();
        this.w4.A1(this.A4);
    }

    public void Z2() {
        this.w4.setItemDecoration(this.A4);
    }

    public ArrayList<Bundle> a3(String str) {
        CompressHelper compressHelper;
        Bundle bundle;
        StringBuilder sb;
        String str2;
        if (this.D4.getSelectedTabPosition() == 0) {
            compressHelper = this.k4;
            bundle = this.h4;
            sb = new StringBuilder();
            sb.append("Select * from search where search match '(text:");
            sb.append(str);
            sb.append("* OR content:");
            sb.append(str);
            str2 = "*) AND type:1 AND typeText:Pathway'";
        } else {
            compressHelper = this.k4;
            bundle = this.h4;
            sb = new StringBuilder();
            sb.append("Select * from search where search match '(text:");
            sb.append(str);
            sb.append("* OR content:");
            sb.append(str);
            str2 = "*) AND type:1 AND typeText:Lab'";
        }
        sb.append(str2);
        return compressHelper.W(bundle, sb.toString(), "search.db");
    }

    public ArrayList<Bundle> g3(String str) {
        CompressHelper compressHelper = this.k4;
        Bundle bundle = this.h4;
        return compressHelper.W(bundle, "Select rowid as _id,word from spell where word match '" + str + "*'", "search.db");
    }
}
