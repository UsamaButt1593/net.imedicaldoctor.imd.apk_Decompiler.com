package net.imedicaldoctor.imd.Fragments.Sanford;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.util.ArrayList;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.SearchHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.ViewHolders.ChaptersAdapter;
import net.imedicaldoctor.imd.ViewHolders.RippleTextFullViewHolder;
import net.imedicaldoctor.imd.ViewHolders.SpellSearchAdapter;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class SANTocActivityFragment extends SearchHelperFragment {
    public SpellSearchAdapter A4;
    public String B4;
    public JSONArray C4;
    public JSONObject D4;

    public View U0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.q4 = layoutInflater.inflate(R.layout.f1246fragment_new_list, viewGroup, false);
        W2(bundle);
        this.s4 = (SearchView) this.q4.findViewById(R.id.f1069search_view);
        Q2();
        this.w4 = (RecyclerView) this.q4.findViewById(R.id.f1054recycler_view);
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
        try {
            JSONArray jSONArray = new JSONObject(this.k4.f2(CompressHelper.g1(this.h4, "BT_config.txt"))).getJSONObject("BT_appConfig").getJSONArray("BT_items").getJSONObject(0).getJSONArray("BT_screens");
            this.C4 = jSONArray;
            String str2 = this.B4;
            this.D4 = str2 == null ? jSONArray.getJSONObject(0) : this.k4.r1(jSONArray, "itemId", str2);
            if (this.D4.has(TtmlNode.H)) {
                this.D4.getString(TtmlNode.H);
                this.D4.getString("listHeaderTextFontColor");
            }
            this.l4 = new ChaptersAdapter(r(), this.k4.F(this.D4.getJSONArray("childItems")), "titleText", R.layout.f1343list_view_item_ripple_text_arrow) {
                public void f0(Bundle bundle, int i2) {
                    SANTocActivityFragment.this.i3(bundle, i2);
                }
            };
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            e2.printStackTrace();
        }
        this.A4 = new SpellSearchAdapter(r(), this.o4, "text", (String) null, R.layout.f1346list_view_item_ripple_text_full) {
            public void e0(RecyclerView.ViewHolder viewHolder, final Bundle bundle, int i2) {
                TextView textView;
                int i3;
                RippleTextFullViewHolder rippleTextFullViewHolder = (RippleTextFullViewHolder) viewHolder;
                rippleTextFullViewHolder.I.setText(bundle.getString("text"));
                rippleTextFullViewHolder.J.setText(bundle.getString("subText"));
                if (bundle.getString("subText").length() == 0) {
                    textView = rippleTextFullViewHolder.J;
                    i3 = 8;
                } else {
                    textView = rippleTextFullViewHolder.J;
                    i3 = 0;
                }
                textView.setVisibility(i3);
                rippleTextFullViewHolder.M.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        SANTocActivityFragment.this.V2();
                        String t1 = SANTocActivityFragment.this.k4.t1(StringUtils.splitByWholeSeparator(bundle.getString("contentId"), "/"));
                        SANTocActivityFragment sANTocActivityFragment = SANTocActivityFragment.this;
                        CompressHelper compressHelper = sANTocActivityFragment.k4;
                        Bundle bundle = sANTocActivityFragment.h4;
                        compressHelper.A1(bundle, t1 + ".html", (String[]) null, (String) null);
                    }
                });
            }

            public void h0(Bundle bundle) {
                SANTocActivityFragment.this.V2();
                SANTocActivityFragment.this.s4.k0(bundle.getString("word"), true);
            }

            public RecyclerView.ViewHolder j0(View view) {
                RippleTextFullViewHolder rippleTextFullViewHolder = new RippleTextFullViewHolder(view);
                rippleTextFullViewHolder.K.setVisibility(8);
                return rippleTextFullViewHolder;
            }
        };
        this.w4.setAdapter(this.l4);
        N2();
        S2();
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
        return compressHelper.W(bundle, "Select title as text, subject as subText,path as contentId from search_base where search_base match 'title:" + str + "* OR subject:" + str + "*'", "FTS.db");
    }

    public ArrayList<Bundle> g3(String str) {
        CompressHelper compressHelper = this.k4;
        Bundle bundle = this.h4;
        return compressHelper.W(bundle, "Select word from spell where word match '" + str + "*'", "spell.db");
    }

    public String h3() {
        try {
            return this.D4.getString("itemNickname");
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            return this.h4.getString("Title");
        }
    }

    public void i3(Bundle bundle, int i2) {
        Bundle bundle2;
        V2();
        String string = bundle.getString("loadScreenWithItemId");
        try {
            bundle2 = this.k4.G(this.k4.r1(this.C4, "itemId", string));
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            e2.printStackTrace();
            bundle2 = null;
        }
        if (!bundle2.getString("itemType").equals("BT_screen_webView")) {
            Bundle bundle3 = new Bundle();
            bundle3.putBundle("DB", this.h4);
            bundle3.putString("ParentId", string);
            this.k4.N(SANTocActivity.class, SANTocActivityFragment.class, bundle3);
            return;
        }
        this.k4.A1(this.h4, bundle2.getString("localFileName"), (String[]) null, (String) null);
    }
}
