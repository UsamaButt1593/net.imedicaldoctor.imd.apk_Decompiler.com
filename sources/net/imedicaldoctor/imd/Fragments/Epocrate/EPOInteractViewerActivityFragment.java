package net.imedicaldoctor.imd.Fragments.Epocrate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.R;

public class EPOInteractViewerActivityFragment extends ViewerHelperFragment {
    public ArrayList<Bundle> X4;
    public String Y4;
    public int Z4;

    public String I4(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int i2 = this.Z4 + 1;
        this.Z4 = i2;
        String valueOf = String.valueOf(i2);
        return "<a name=\"f" + valueOf + "\"><div id=\"h" + valueOf + "\" class=\"headerExpanded2\"  DIR=\"" + str3 + "\" onclick=\"collapse(f" + valueOf + ");toggleHeaderExpanded2(h" + valueOf + ");\"><span class=\"fieldname\" style=\"font-family:" + str2 + ";\">" + str + "</span></div></a><div class=\"content\" DIR=\"" + str7 + "\" id=\"f" + valueOf + "\" style=\"font-family:" + str5 + "; " + str6 + "\">" + str4 + "</div>";
    }

    public String J4(String str, String str2) {
        if (!(str == null || str.length() == 0)) {
            CompressHelper compressHelper = this.Q4;
            Bundle bundle = this.D4;
            Bundle s1 = compressHelper.s1(compressHelper.W(bundle, "select * from " + str2 + "_string where id=" + str, this.Y4));
            if (!(s1 == null || s1.size() == 0)) {
                return s1.getString("STRING");
            }
        }
        return "";
    }

    public String K4(String str) {
        return J4(str, "general");
    }

    public View onFragmentBind(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.C4;
        if (view != null) {
            return view;
        }
        View inflate = layoutInflater.inflate(R.layout.f1255fragment_new_viewer, viewGroup, false);
        this.C4 = inflate;
        r4(inflate, bundle);
        if (y() == null) {
            return this.C4;
        }
        this.Y4 = "RX.sqlite";
        T2(new Runnable() {
            public void run() {
                String str;
                String str2;
                Bundle bundle;
                try {
                    String str3 = EPOInteractViewerActivityFragment.this.A4;
                    if (str3 != null) {
                        if (str3.length() != 0) {
                            return;
                        }
                    }
                    EPOInteractViewerActivityFragment ePOInteractViewerActivityFragment = EPOInteractViewerActivityFragment.this;
                    ePOInteractViewerActivityFragment.Z4 = 0;
                    String[] split = ePOInteractViewerActivityFragment.E4.split("-");
                    if (split.length == 3) {
                        String str4 = split[1];
                        String str5 = split[2];
                        EPOInteractViewerActivityFragment ePOInteractViewerActivityFragment2 = EPOInteractViewerActivityFragment.this;
                        CompressHelper compressHelper = ePOInteractViewerActivityFragment2.Q4;
                        Bundle s1 = compressHelper.s1(compressHelper.W(ePOInteractViewerActivityFragment2.D4, "SELECT                     ID,                     DRUG_ID AS DRUG_0_ID,                     INTERACTING_DRUG_ID AS DRUG_1_ID,                     DDI_ID,                     GROUP_0_ID,                     GROUP_1_ID                     FROM (                     SELECT DISTINCT                     tDID.ID,                     MIN(d1.ID, d2.ID) AS DRUG_ID,                     MAX(d1.ID, d2.ID) AS INTERACTING_DRUG_ID,                     tDID.DDI_ID,                     DDI.GROUP_0_ID,                     DDI.GROUP_1_ID                     FROM                     DRUG_TO_INTERACTING_DRUG tDID                     JOIN DDI ON tDID.DDI_ID = DDI.ID                     JOIN DRUG d1 ON d1.ID = tDID.DRUG_0_ID OR d1.GENERIC_ID = tDID.DRUG_0_ID OR d1.ID = tDID.DRUG_1_ID OR d1.GENERIC_ID = tDID.DRUG_1_ID                     JOIN DRUG d2 ON                     CASE WHEN d1.ID = tDID.DRUG_0_ID OR d1.GENERIC_ID = tDID.DRUG_0_ID                     THEN d2.ID = tDID.DRUG_1_ID OR d2.GENERIC_ID = tDID.DRUG_1_ID                     ELSE d2.ID = tDID.DRUG_0_ID OR d2.GENERIC_ID = tDID.DRUG_0_ID                     END                     WHERE                     tDID.DRUG_0_ID IN (" + str4 + ", " + str5 + ")                     AND                     tDID.DRUG_1_ID IN (" + str4 + ", " + str5 + ")                     AND                     DRUG_0_ID <> DRUG_1_ID                     AND                     d1.ID IN (" + str4 + ", " + str5 + ")                     AND                     d2.ID IN (" + str4 + ", " + str5 + ")                     ORDER BY CATEGORY_ID, d1.name, d2.name                     )", EPOInteractViewerActivityFragment.this.Y4));
                        String string = s1.getString("DRUG_0_ID");
                        String string2 = s1.getString("DRUG_1_ID");
                        String string3 = s1.getString("DDI_ID");
                        EPOInteractViewerActivityFragment ePOInteractViewerActivityFragment3 = EPOInteractViewerActivityFragment.this;
                        CompressHelper compressHelper2 = ePOInteractViewerActivityFragment3.Q4;
                        Bundle bundle2 = ePOInteractViewerActivityFragment3.D4;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Select * from Drug where ID=");
                        sb.append(string);
                        str2 = compressHelper2.s1(compressHelper2.W(bundle2, sb.toString(), EPOInteractViewerActivityFragment.this.Y4)).getString("NAME");
                        EPOInteractViewerActivityFragment ePOInteractViewerActivityFragment4 = EPOInteractViewerActivityFragment.this;
                        CompressHelper compressHelper3 = ePOInteractViewerActivityFragment4.Q4;
                        Bundle bundle3 = ePOInteractViewerActivityFragment4.D4;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Select * from Drug where ID=");
                        sb2.append(string2);
                        String string4 = compressHelper3.s1(compressHelper3.W(bundle3, sb2.toString(), EPOInteractViewerActivityFragment.this.Y4)).getString("NAME");
                        EPOInteractViewerActivityFragment ePOInteractViewerActivityFragment5 = EPOInteractViewerActivityFragment.this;
                        CompressHelper compressHelper4 = ePOInteractViewerActivityFragment5.Q4;
                        Bundle bundle4 = ePOInteractViewerActivityFragment5.D4;
                        StringBuilder sb3 = new StringBuilder();
                        str = string4;
                        sb3.append("SELECT  DDI.ID ,  DDI.GROUP_0_ID ,  DDI.GROUP_1_ID ,  DDI.CATEGORY_ID ,  DDI.ACTION_STRING_ID ,  DDI.EFFECT_STRING_ID ,  DDI.MECHANISM_STRING_ID   FROM DDI   WHERE  ID =  ");
                        sb3.append(string3);
                        bundle = compressHelper4.s1(compressHelper4.W(bundle4, sb3.toString(), EPOInteractViewerActivityFragment.this.Y4));
                        EPOInteractViewerActivityFragment ePOInteractViewerActivityFragment6 = EPOInteractViewerActivityFragment.this;
                        ePOInteractViewerActivityFragment6.X4 = ePOInteractViewerActivityFragment6.Q4.X(ePOInteractViewerActivityFragment6.D4, "Select * from pill_pictures where drug_id=" + string + " OR drug_id=" + string2, EPOInteractViewerActivityFragment.this.Y4, true);
                    } else {
                        String str6 = split[1];
                        EPOInteractViewerActivityFragment ePOInteractViewerActivityFragment7 = EPOInteractViewerActivityFragment.this;
                        CompressHelper compressHelper5 = ePOInteractViewerActivityFragment7.Q4;
                        bundle = compressHelper5.s1(compressHelper5.W(ePOInteractViewerActivityFragment7.D4, "SELECT  DDI.ID ,  DDI.GROUP_0_ID ,  DDI.GROUP_1_ID ,  DDI.CATEGORY_ID ,  DDI.ACTION_STRING_ID ,  DDI.EFFECT_STRING_ID ,  DDI.MECHANISM_STRING_ID   FROM DDI   WHERE  ID = " + str6, EPOInteractViewerActivityFragment.this.Y4));
                        EPOInteractViewerActivityFragment ePOInteractViewerActivityFragment8 = EPOInteractViewerActivityFragment.this;
                        ePOInteractViewerActivityFragment8.X4 = ePOInteractViewerActivityFragment8.Q4.X(ePOInteractViewerActivityFragment8.D4, "Select * from pill_pictures where drug_id=" + bundle.getString("GROUP_0_ID") + " OR drug_id=" + bundle.getString("GROUP_1_ID"), EPOInteractViewerActivityFragment.this.Y4, true);
                        str2 = null;
                        str = null;
                    }
                    String string5 = bundle.getString("GROUP_0_ID");
                    String string6 = bundle.getString("GROUP_1_ID");
                    EPOInteractViewerActivityFragment ePOInteractViewerActivityFragment9 = EPOInteractViewerActivityFragment.this;
                    CompressHelper compressHelper6 = ePOInteractViewerActivityFragment9.Q4;
                    String string7 = compressHelper6.s1(compressHelper6.W(ePOInteractViewerActivityFragment9.D4, "SELECT  DDI_GROUP.ID ,  DDI_GROUP.NAME   FROM DDI_GROUP   WHERE  ID =  " + string5, EPOInteractViewerActivityFragment.this.Y4)).getString("NAME");
                    EPOInteractViewerActivityFragment ePOInteractViewerActivityFragment10 = EPOInteractViewerActivityFragment.this;
                    CompressHelper compressHelper7 = ePOInteractViewerActivityFragment10.Q4;
                    String string8 = compressHelper7.s1(compressHelper7.W(ePOInteractViewerActivityFragment10.D4, "SELECT  DDI_GROUP.ID ,  DDI_GROUP.NAME   FROM DDI_GROUP   WHERE  ID =  " + string6, EPOInteractViewerActivityFragment.this.Y4)).getString("NAME");
                    if (str2 == null) {
                        str2 = string7;
                    }
                    if (str != null) {
                        string8 = str;
                    }
                    EPOInteractViewerActivityFragment.this.F4 = string8 + " - " + str2;
                    EPOInteractViewerActivityFragment ePOInteractViewerActivityFragment11 = EPOInteractViewerActivityFragment.this;
                    CompressHelper compressHelper8 = ePOInteractViewerActivityFragment11.Q4;
                    String string9 = compressHelper8.s1(compressHelper8.W(ePOInteractViewerActivityFragment11.D4, "Select * from DDI_Category where id = " + bundle.getString("CATEGORY_ID"), EPOInteractViewerActivityFragment.this.Y4)).getString("NAME");
                    String K4 = EPOInteractViewerActivityFragment.this.K4(bundle.getString("ACTION_STRING_ID"));
                    String K42 = EPOInteractViewerActivityFragment.this.K4(bundle.getString("EFFECT_STRING_ID"));
                    String K43 = EPOInteractViewerActivityFragment.this.K4(bundle.getString("MECHANISM_STRING_ID"));
                    EPOInteractViewerActivityFragment ePOInteractViewerActivityFragment12 = EPOInteractViewerActivityFragment.this;
                    String d4 = ePOInteractViewerActivityFragment12.d4(ePOInteractViewerActivityFragment12.r(), "EPOHeader.css");
                    EPOInteractViewerActivityFragment ePOInteractViewerActivityFragment13 = EPOInteractViewerActivityFragment.this;
                    String d42 = ePOInteractViewerActivityFragment13.d4(ePOInteractViewerActivityFragment13.r(), "EPOFooter.css");
                    String replace = d4.replace("[size]", "200").replace("[title]", EPOInteractViewerActivityFragment.this.F4).replace("[include]", "");
                    String replace2 = ((((("<div class=\"cellTitle\" style=\"margin-left:15px;margin-top:15px\">" + string8 + " + " + str2 + "</div>") + "<div style=\"color:red;font-weight:bold;margin-left:15px\">" + string9 + "</div>") + EPOInteractViewerActivityFragment.this.I4("Action", "", "", K4, "", "margin-left:15px", "")) + EPOInteractViewerActivityFragment.this.I4("Effect", "", "", K42, "", "margin-left:15px", "")) + EPOInteractViewerActivityFragment.this.I4("Mechanism", "", "", K43, "", "margin-left:15px", "")).replace("..", ".");
                    EPOInteractViewerActivityFragment.this.A4 = replace + replace2 + d42;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    EPOInteractViewerActivityFragment.this.p4 = e2.getLocalizedMessage();
                }
            }
        }, new Runnable() {
            public void run() {
                String str = EPOInteractViewerActivityFragment.this.p4;
                if (str == null || str.length() <= 0) {
                    String f1 = CompressHelper.f1(EPOInteractViewerActivityFragment.this.D4);
                    EPOInteractViewerActivityFragment ePOInteractViewerActivityFragment = EPOInteractViewerActivityFragment.this;
                    ePOInteractViewerActivityFragment.O3(ePOInteractViewerActivityFragment.A4, f1);
                    EPOInteractViewerActivityFragment.this.s4();
                    EPOInteractViewerActivityFragment.this.p4();
                    EPOInteractViewerActivityFragment.this.f3(R.menu.f1411elsviewer2);
                    EPOInteractViewerActivityFragment.this.o2(false);
                    EPOInteractViewerActivityFragment.this.G3();
                    return;
                }
                EPOInteractViewerActivityFragment ePOInteractViewerActivityFragment2 = EPOInteractViewerActivityFragment.this;
                ePOInteractViewerActivityFragment2.C4(ePOInteractViewerActivityFragment2.p4);
            }
        });
        return this.C4;
    }

    public boolean e1(MenuItem menuItem) {
        return super.e1(menuItem);
    }

    public void e3(Menu menu) {
        menu.removeItem(R.id.f799action_gallery);
        menu.removeItem(R.id.f801action_menu);
    }

    public void o4() {
        Bundle v3;
        ArrayList<Bundle> arrayList = this.X4;
        if (arrayList != null && arrayList.size() != 0 && (v3 = v3(this.X4)) != null) {
            Glide.G(r()).t("http://www.epocrates.com/pillimages/" + (v3.getString("FILENAME") + ".jpg")).B2(this.M4);
        }
    }

    public boolean y4(WebView webView, String str, String str2, String str3) {
        this.Q4.N1(this.D4, str);
        return true;
    }
}
