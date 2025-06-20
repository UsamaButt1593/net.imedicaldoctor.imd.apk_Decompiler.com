package net.imedicaldoctor.imd.Fragments.Epocrate;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersDecoration;
import java.util.ArrayList;
import java.util.Iterator;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.CustomItemDecoration;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.ViewHolders.StickySectionAdapter;

public class EPOInteractSingleActivityFragment extends ViewerHelperFragment {
    public RecyclerView X4;
    public ArrayList<Bundle> Y4;
    public TabLayout Z4;
    public String a5;
    public String b5;
    public String c5;
    public String d5;
    /* access modifiers changed from: private */
    public StickyRecyclerHeadersDecoration e5;
    public OverviewAdapter f5;
    public StickySectionAdapter g5;
    public StickySectionAdapter h5;

    public class OverviewAdapter extends RecyclerView.Adapter {
        public OverviewAdapter() {
        }

        public void R(RecyclerView.ViewHolder viewHolder, int i2) {
            ((TextViewHolder) viewHolder).I.setText(Html.fromHtml(EPOInteractSingleActivityFragment.this.d5));
        }

        public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
            View inflate = LayoutInflater.from(EPOInteractSingleActivityFragment.this.r()).inflate(R.layout.f1378list_view_item_text, viewGroup, false);
            EPOInteractSingleActivityFragment ePOInteractSingleActivityFragment = EPOInteractSingleActivityFragment.this;
            return new TextViewHolder(ePOInteractSingleActivityFragment.r(), inflate);
        }

        public int b() {
            return 1;
        }
    }

    public class TextViewHolder extends RecyclerView.ViewHolder {
        public TextView I;

        public TextViewHolder(Context context, View view) {
            super(view);
            this.I = (TextView) view.findViewById(R.id.text);
            this.I.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/HelveticaNeue-Light.otf"));
        }
    }

    public void K4() {
        this.X4.setItemAnimator(new DefaultItemAnimator());
        this.X4.setItemDecoration(new CustomItemDecoration(r()));
        this.X4.setLayoutManager(new LinearLayoutManager(r(), 1, false));
    }

    public View U0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        View view = this.C4;
        if (view != null) {
            return view;
        }
        View inflate = layoutInflater.inflate(R.layout.f1228fragment_epointeract_single, viewGroup, false);
        this.C4 = inflate;
        r4(inflate, bundle);
        this.X4 = (RecyclerView) this.C4.findViewById(R.id.f1054recycler_view);
        if (y() == null) {
            return this.C4;
        }
        this.c5 = "RX.sqlite";
        this.Z4 = (TabLayout) this.C4.findViewById(R.id.f1111tabs);
        String[] strArr = {"Overview", "By Category", "By Drug"};
        for (int i2 = 0; i2 < 3; i2++) {
            TabLayout.Tab I = this.Z4.I();
            I.D(strArr[i2]);
            this.Z4.i(I);
        }
        this.Z4.setOnTabSelectedListener((TabLayout.OnTabSelectedListener) new TabLayout.OnTabSelectedListener() {
            public void a(TabLayout.Tab tab) {
            }

            public void b(TabLayout.Tab tab) {
                RecyclerView recyclerView;
                RecyclerView.Adapter adapter;
                int selectedTabPosition = EPOInteractSingleActivityFragment.this.Z4.getSelectedTabPosition();
                if (selectedTabPosition == 0) {
                    if (EPOInteractSingleActivityFragment.this.e5 != null) {
                        EPOInteractSingleActivityFragment ePOInteractSingleActivityFragment = EPOInteractSingleActivityFragment.this;
                        ePOInteractSingleActivityFragment.X4.A1(ePOInteractSingleActivityFragment.e5);
                        EPOInteractSingleActivityFragment.this.e5.n();
                        StickyRecyclerHeadersDecoration unused = EPOInteractSingleActivityFragment.this.e5 = null;
                    }
                    EPOInteractSingleActivityFragment ePOInteractSingleActivityFragment2 = EPOInteractSingleActivityFragment.this;
                    recyclerView = ePOInteractSingleActivityFragment2.X4;
                    adapter = ePOInteractSingleActivityFragment2.f5;
                } else if (selectedTabPosition == 1) {
                    if (EPOInteractSingleActivityFragment.this.e5 != null) {
                        EPOInteractSingleActivityFragment ePOInteractSingleActivityFragment3 = EPOInteractSingleActivityFragment.this;
                        ePOInteractSingleActivityFragment3.X4.A1(ePOInteractSingleActivityFragment3.e5);
                        EPOInteractSingleActivityFragment.this.e5.n();
                        StickyRecyclerHeadersDecoration unused2 = EPOInteractSingleActivityFragment.this.e5 = null;
                    }
                    EPOInteractSingleActivityFragment ePOInteractSingleActivityFragment4 = EPOInteractSingleActivityFragment.this;
                    StickyRecyclerHeadersDecoration unused3 = ePOInteractSingleActivityFragment4.e5 = new StickyRecyclerHeadersDecoration(ePOInteractSingleActivityFragment4.g5);
                    EPOInteractSingleActivityFragment ePOInteractSingleActivityFragment5 = EPOInteractSingleActivityFragment.this;
                    ePOInteractSingleActivityFragment5.X4.setItemDecoration(ePOInteractSingleActivityFragment5.e5);
                    EPOInteractSingleActivityFragment ePOInteractSingleActivityFragment6 = EPOInteractSingleActivityFragment.this;
                    recyclerView = ePOInteractSingleActivityFragment6.X4;
                    adapter = ePOInteractSingleActivityFragment6.g5;
                } else if (selectedTabPosition == 2) {
                    if (EPOInteractSingleActivityFragment.this.e5 != null) {
                        EPOInteractSingleActivityFragment ePOInteractSingleActivityFragment7 = EPOInteractSingleActivityFragment.this;
                        ePOInteractSingleActivityFragment7.X4.A1(ePOInteractSingleActivityFragment7.e5);
                        EPOInteractSingleActivityFragment.this.e5.n();
                        StickyRecyclerHeadersDecoration unused4 = EPOInteractSingleActivityFragment.this.e5 = null;
                    }
                    EPOInteractSingleActivityFragment ePOInteractSingleActivityFragment8 = EPOInteractSingleActivityFragment.this;
                    StickyRecyclerHeadersDecoration unused5 = ePOInteractSingleActivityFragment8.e5 = new StickyRecyclerHeadersDecoration(ePOInteractSingleActivityFragment8.h5);
                    EPOInteractSingleActivityFragment ePOInteractSingleActivityFragment9 = EPOInteractSingleActivityFragment.this;
                    ePOInteractSingleActivityFragment9.X4.setItemDecoration(ePOInteractSingleActivityFragment9.e5);
                    EPOInteractSingleActivityFragment ePOInteractSingleActivityFragment10 = EPOInteractSingleActivityFragment.this;
                    recyclerView = ePOInteractSingleActivityFragment10.X4;
                    adapter = ePOInteractSingleActivityFragment10.h5;
                } else {
                    return;
                }
                recyclerView.setAdapter(adapter);
            }

            public void c(TabLayout.Tab tab) {
            }
        });
        String str2 = this.E4.split("-")[1];
        this.a5 = str2;
        ArrayList<Bundle> X = this.Q4.X(this.D4, "Select * from drug where ID=" + str2, this.c5, true);
        if (X == null || X.size() == 0) {
            CompressHelper.x2(r(), "Sorry, Drug can't be found", 1);
        } else {
            Bundle bundle2 = X.get(0);
            this.Y4 = this.Q4.X(this.D4, "Select * from pill_pictures where drug_id=" + str2, this.c5, true);
            if (bundle2.getString("GENERIC_ID").length() == 0 || bundle2.getString("GENERIC_ID").equals("0")) {
                str = bundle2.getString("ID");
                bundle2.getString("NAME");
            } else {
                str = bundle2.getString("GENERIC_ID");
                try {
                    CompressHelper compressHelper = this.Q4;
                    compressHelper.s1(compressHelper.X(this.D4, "SELECT  DRUG.ID ,  DRUG.CLINICAL_ID ,  DRUG.GENERIC_ID ,  DRUG.NAME ,  DRUG.DRUG_TYPE ,  DRUG.ACTIVE ,  DRUG.ADULT_DSG_ID ,  DRUG.PEDS_DSG_ID ,  DRUG.MFR_STRING_ID ,  DRUG.BBW_ID   FROM DRUG   WHERE  ID =  " + str2, this.c5, true)).getString("NAME");
                } catch (Exception e2) {
                    FirebaseCrashlytics.d().g(e2);
                    e2.printStackTrace();
                }
            }
            this.F4 = bundle2.getString("NAME");
            this.b5 = str;
            CompressHelper compressHelper2 = this.Q4;
            Bundle s1 = compressHelper2.s1(compressHelper2.W(this.D4, "SELECT  DDI_GROUP.ID ,  DDI_GROUP.NAME ,  DDI_GROUP.PHARMACOLOGIC_CLASS_ID                      FROM DDI_GROUP                     JOIN DRUG_TO_DDI_GROUP ON DDI_GROUP.ID = DRUG_TO_DDI_GROUP.GROUP_ID                     WHERE DRUG_TO_DDI_GROUP.DRUG_ID=" + str, this.c5));
            String string = s1.getString("ID");
            String string2 = s1.getString("NAME");
            ArrayList<Bundle> X2 = this.Q4.X(this.D4, "SELECT  CHARACTERISTIC.ID ,  CHARACTERISTIC.NAME                             FROM INGREDIENT_CHARACTERISTIC                            JOIN CHARACTERISTIC ON INGREDIENT_CHARACTERISTIC.CHARACTERISTIC_ID = CHARACTERISTIC.ID                            WHERE INGREDIENT_CHARACTERISTIC.INGREDIENT_ID = " + string + "                            ORDER BY INGREDIENT_CHARACTERISTIC.DISPLAY_ORDER", this.c5, true);
            String str3 = "<div><font color=\"#009900\"><b>" + string2 + "</b></font></div>Interaction Characteristics : <br/>";
            Iterator<Bundle> it2 = X2.iterator();
            while (it2.hasNext()) {
                str3 = str3 + "<br/>   • " + it2.next().getString("NAME");
            }
            this.d5 = str3;
            if (X2.size() == 0) {
                this.d5 = "<b>No Information<b>";
            }
            this.f5 = new OverviewAdapter();
            this.g5 = new StickySectionAdapter(r(), this.Q4.r2(this.Q4.X(this.D4, "SELECT                     DDI.ID AS DDI_ID,                    DRUG_TO_DDI_GROUP.GROUP_ID AS GROUP_0_ID,                    CASE WHEN DDI.GROUP_0_ID = DRUG_TO_DDI_GROUP.GROUP_ID THEN DDI.GROUP_1_ID ELSE DDI.GROUP_0_ID END AS GROUP_1_ID,                    DDI_GROUP.NAME AS GROUP_1_NAME,                    DDI.CATEGORY_ID,                    DDI.ACTION_STRING_ID,                    DDI.EFFECT_STRING_ID,                    DDI.MECHANISM_STRING_ID,                    (select name from ddi_category where ddi_category.id=ddi.category_id) as CATEGORY,                     (select name from ddi_group where ddi_group.id=DRUG_TO_DDI_GROUP.GROUP_ID) as GROUP_0_NAME,                     (select string from general_string where general_string.id=ddi.action_string_id) as ACTION_STRING,                     (select string from general_string where general_string.id=ddi.effect_string_id) as EFFECT_STRING,                     (select string from general_string where general_string.id=ddi.mechanism_string_id) as MECHANISM_STRING                     FROM DRUG                     JOIN DRUG_TO_DDI_GROUP ON DRUG_TO_DDI_GROUP.DRUG_ID = DRUG.ID                     JOIN DDI ON DDI.GROUP_0_ID = DRUG_TO_DDI_GROUP.GROUP_ID OR DDI.GROUP_1_ID = DRUG_TO_DDI_GROUP.GROUP_ID                     JOIN DDI_GROUP ON DDI_GROUP.ID = CASE WHEN DDI.GROUP_0_ID = DRUG_TO_DDI_GROUP.GROUP_ID THEN DDI.GROUP_1_ID ELSE DDI.GROUP_0_ID END                    WHERE DRUG.ID = " + str + "                    ORDER BY CATEGORY_ID, GROUP_1_NAME, GROUP_0_NAME", this.c5, true), "CATEGORY_ID"), "GROUP_1_NAME") {
                public void h0(Bundle bundle, int i2) {
                    EPOInteractSingleActivityFragment ePOInteractSingleActivityFragment = EPOInteractSingleActivityFragment.this;
                    CompressHelper compressHelper = ePOInteractSingleActivityFragment.Q4;
                    Bundle bundle2 = ePOInteractSingleActivityFragment.D4;
                    compressHelper.A1(bundle2, "interactview-" + bundle.getString("DDI_ID"), (String[]) null, (String) null);
                }

                public String j0(String str) {
                    if (str.equals("5")) {
                        return "Caution Advised";
                    }
                    if (str.equals("4")) {
                        return "Therapeutic Advantage";
                    }
                    if (str.equals(ExifInterface.Z4)) {
                        return "Monitor / Modify Tx";
                    }
                    if (str.equals(ExifInterface.Y4)) {
                        return "Avoid / Use Alternative";
                    }
                    return str.equals(IcyHeaders.a3) ? "Contraindicated" : str;
                }
            };
            this.h5 = new StickySectionAdapter(r(), this.Q4.s2(this.Q4.X(this.D4, "SELECT DISTINCT                            DRUG.ID,                           DRUG.CLINICAL_ID,                           DRUG.GENERIC_ID,                           DRUG.NAME,                           DRUG.DRUG_TYPE,                           DRUG.ACTIVE,                           DRUG.ADULT_DSG_ID,                           DRUG.PEDS_DSG_ID,                           DRUG.MFR_STRING_ID,                           DRUG.BBW_ID                           FROM DRUG_TO_INTERACTING_DRUG                           JOIN DRUG ON (                            DRUG.ID = CASE WHEN DRUG_TO_INTERACTING_DRUG.DRUG_0_ID = " + str + " THEN DRUG_TO_INTERACTING_DRUG.DRUG_1_ID ELSE DRUG_TO_INTERACTING_DRUG.DRUG_0_ID END  or                            DRUG.GENERIC_ID = CASE WHEN DRUG_TO_INTERACTING_DRUG.DRUG_0_ID = " + str + " THEN DRUG_TO_INTERACTING_DRUG.DRUG_1_ID ELSE DRUG_TO_INTERACTING_DRUG.DRUG_0_ID END                            )                            WHERE                            DRUG_TO_INTERACTING_DRUG.DRUG_1_ID = " + str + " OR                           DRUG_TO_INTERACTING_DRUG.DRUG_0_ID = " + str + "                           ORDER BY DRUG.NAME", this.c5, true), "NAME"), "NAME") {
                public void h0(Bundle bundle, int i2) {
                    String string = bundle.getString("ID");
                    if (bundle.getString("GENERIC_ID").length() > 0 && !bundle.getString("GENERIC_ID").equals("0")) {
                        string = bundle.getString("GENERIC_ID");
                    }
                    EPOInteractSingleActivityFragment ePOInteractSingleActivityFragment = EPOInteractSingleActivityFragment.this;
                    CompressHelper compressHelper = ePOInteractSingleActivityFragment.Q4;
                    Bundle bundle2 = ePOInteractSingleActivityFragment.D4;
                    compressHelper.A1(bundle2, "interactview-" + EPOInteractSingleActivityFragment.this.b5 + "-" + string, (String[]) null, (String) null);
                }
            };
            this.X4.setAdapter(this.f5);
            K4();
            f3(R.menu.f1414favorite);
            o2(false);
            G3();
        }
        return this.C4;
    }

    public boolean e1(MenuItem menuItem) {
        menuItem.getItemId();
        return super.e1(menuItem);
    }

    public void o4() {
        Bundle v3;
        ArrayList<Bundle> arrayList = this.Y4;
        if (arrayList != null && arrayList.size() != 0 && (v3 = v3(this.Y4)) != null) {
            Glide.G(r()).t("http://www.epocrates.com/pillimages/" + (v3.getString("FILENAME") + ".jpg")).B2(this.M4);
        }
    }
}
