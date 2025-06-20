package net.imedicaldoctor.imd.Fragments.Statdx;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.SearchView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.itextpdf.text.Annotation;
import java.util.ArrayList;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.SearchHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Utils.MaterialRippleLayout;
import net.imedicaldoctor.imd.ViewHolders.ChaptersAdapter;
import net.imedicaldoctor.imd.ViewHolders.RippleTextFullViewHolder;
import net.imedicaldoctor.imd.ViewHolders.RippleTextViewHolder;
import net.imedicaldoctor.imd.ViewHolders.SpellSearchAdapter;

public class SDListActivityFragment extends SearchHelperFragment {
    public SpellSearchAdapter A4;
    public String B4;
    public ArrayList<Bundle> C4;
    public ArrayList<Bundle> D4;

    public View U0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
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
        this.C4 = compressHelper.V(bundle2, "select * from categories where parent='" + this.B4 + "'");
        CompressHelper compressHelper2 = this.k4;
        Bundle bundle3 = this.h4;
        this.D4 = compressHelper2.V(bundle3, "select * from docs where id in (Select docId from cats_docs where catId='" + this.B4 + "')");
        if (this.C4 == null) {
            this.C4 = new ArrayList<>();
        }
        if (this.D4 == null) {
            this.D4 = new ArrayList<>();
        }
        this.l4 = new ChaptersAdapter(r(), (ArrayList) null, "title", R.layout.f1343list_view_item_ripple_text_arrow) {
            public int C(int i2) {
                return i2 < SDListActivityFragment.this.C4.size() ? 0 : 1;
            }

            public void R(RecyclerView.ViewHolder viewHolder, int i2) {
                MaterialRippleLayout materialRippleLayout;
                View.OnClickListener r0;
                if (viewHolder.F() == 0) {
                    RippleTextViewHolder rippleTextViewHolder = (RippleTextViewHolder) viewHolder;
                    final Bundle bundle = SDListActivityFragment.this.C4.get(i2);
                    rippleTextViewHolder.I.setText(bundle.getString("title"));
                    materialRippleLayout = rippleTextViewHolder.J;
                    r0 = new View.OnClickListener() {
                        public void onClick(View view) {
                            Bundle bundle = new Bundle();
                            bundle.putBundle("DB", SDListActivityFragment.this.h4);
                            bundle.putString("ParentId", bundle.getString("id"));
                            SDListActivityFragment.this.k4.N(SDListActivity.class, SDListActivityFragment.class, bundle);
                        }
                    };
                } else {
                    RippleTextFullViewHolder rippleTextFullViewHolder = (RippleTextFullViewHolder) viewHolder;
                    SDListActivityFragment sDListActivityFragment = SDListActivityFragment.this;
                    final Bundle bundle2 = sDListActivityFragment.D4.get(i2 - sDListActivityFragment.C4.size());
                    rippleTextFullViewHolder.I.setText(bundle2.getString("title"));
                    if (SDListActivityFragment.this.h4.getString("Name").equals("expertpath.db")) {
                        rippleTextFullViewHolder.K.setVisibility(8);
                    } else {
                        rippleTextFullViewHolder.K.setVisibility(0);
                        rippleTextFullViewHolder.K.setImageDrawable(SDListActivityFragment.this.r().getResources().getDrawable(SDListActivityFragment.this.i3(bundle2.getString("type"))));
                    }
                    materialRippleLayout = rippleTextFullViewHolder.M;
                    r0 = new View.OnClickListener() {
                        public void onClick(View view) {
                            SDListActivityFragment sDListActivityFragment = SDListActivityFragment.this;
                            CompressHelper compressHelper = sDListActivityFragment.k4;
                            Bundle bundle = sDListActivityFragment.h4;
                            compressHelper.A1(bundle, "menu,,," + bundle2.getString("id"), (String[]) null, (String) null);
                        }
                    };
                }
                materialRippleLayout.setOnClickListener(r0);
            }

            public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
                if (i2 == 0) {
                    return new RippleTextViewHolder(LayoutInflater.from(this.f30459d).inflate(R.layout.f1343list_view_item_ripple_text_arrow, viewGroup, false));
                }
                if (i2 != 1) {
                    return null;
                }
                RippleTextFullViewHolder rippleTextFullViewHolder = new RippleTextFullViewHolder(LayoutInflater.from(this.f30459d).inflate(R.layout.f1346list_view_item_ripple_text_full, viewGroup, false));
                rippleTextFullViewHolder.J.setVisibility(8);
                return rippleTextFullViewHolder;
            }

            public int b() {
                return SDListActivityFragment.this.C4.size() + SDListActivityFragment.this.D4.size();
            }
        };
        this.A4 = new SpellSearchAdapter(r(), this.o4, "text", Annotation.i3, R.layout.f1346list_view_item_ripple_text_full) {
            public void e0(RecyclerView.ViewHolder viewHolder, final Bundle bundle, int i2) {
                RippleTextFullViewHolder rippleTextFullViewHolder = (RippleTextFullViewHolder) viewHolder;
                if (SDListActivityFragment.this.h4.getString("Name").equals("expertpath.db")) {
                    rippleTextFullViewHolder.K.setVisibility(8);
                } else {
                    rippleTextFullViewHolder.K.setVisibility(0);
                    rippleTextFullViewHolder.K.setImageDrawable(SDListActivityFragment.this.r().getResources().getDrawable(SDListActivityFragment.this.i3(bundle.getString("typeText"))));
                }
                rippleTextFullViewHolder.I.setText(bundle.getString("text"));
                if (bundle.getString("type").equals(ExifInterface.Z4)) {
                    rippleTextFullViewHolder.J.setVisibility(8);
                } else {
                    rippleTextFullViewHolder.J.setVisibility(0);
                    rippleTextFullViewHolder.J.setText(bundle.getString(Annotation.i3));
                }
                rippleTextFullViewHolder.M.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        CompressHelper compressHelper;
                        Bundle bundle;
                        StringBuilder sb;
                        String str;
                        if (bundle.getString("type").equals(ExifInterface.Z4)) {
                            SDListActivityFragment sDListActivityFragment = SDListActivityFragment.this;
                            compressHelper = sDListActivityFragment.k4;
                            bundle = sDListActivityFragment.h4;
                            sb = new StringBuilder();
                            str = "case,,,";
                        } else {
                            SDListActivityFragment sDListActivityFragment2 = SDListActivityFragment.this;
                            compressHelper = sDListActivityFragment2.k4;
                            bundle = sDListActivityFragment2.h4;
                            sb = new StringBuilder();
                            str = "menu,,,";
                        }
                        sb.append(str);
                        sb.append(bundle.getString("contentId"));
                        compressHelper.A1(bundle, sb.toString(), (String[]) null, (String) null);
                    }
                });
            }

            public void h0(Bundle bundle) {
                SDListActivityFragment.this.V2();
                SDListActivityFragment.this.s4.k0(bundle.getString("word"), true);
            }

            public RecyclerView.ViewHolder j0(View view) {
                return new RippleTextFullViewHolder(view);
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
        return compressHelper.V(bundle, "Select * from search where search match '(text:" + str + "*) AND (type:1 OR type:3)' order by type asc");
    }

    public ArrayList<Bundle> g3(String str) {
        CompressHelper compressHelper = this.k4;
        Bundle bundle = this.h4;
        return compressHelper.V(bundle, "Select rowid as _id,word from spell where word match '" + str + "*'");
    }

    public int i3(String str) {
        if (str.equals("di3-dx") || str.equals("dx")) {
            return R.drawable.f743statdx_dx;
        }
        if (str.equals("expert-ddx")) {
            return R.drawable.f742statdx_ddx;
        }
        if (str.equals("anatomymodule")) {
            return R.drawable.f744statdx_person;
        }
        if (str.equals("tsm")) {
            return R.drawable.f747statdx_tnm;
        }
        if (str.equals("procedure")) {
            return R.drawable.f745statdx_syringe;
        }
        if (str.equals("di3-generic")) {
            return R.drawable.f743statdx_dx;
        }
        if (str.equals("di3-tsm")) {
            return R.drawable.f747statdx_tnm;
        }
        if (str.equals("di3-procedure")) {
            return R.drawable.f745statdx_syringe;
        }
        if (str.equals("ia2-module")) {
            return R.drawable.f744statdx_person;
        }
        if (str.equals("di3-expert-ddx")) {
            return R.drawable.f742statdx_ddx;
        }
        if (str.equals("table")) {
            return R.drawable.f746statdx_table;
        }
        return str.equals("Case") ? R.drawable.f741statdx_case : R.drawable.f743statdx_dx;
    }
}
