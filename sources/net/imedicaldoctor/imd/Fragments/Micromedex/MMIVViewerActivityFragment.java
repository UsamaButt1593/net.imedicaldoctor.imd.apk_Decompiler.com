package net.imedicaldoctor.imd.Fragments.Micromedex;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.Amirsys.ASSectionViewer;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.iMDLogger;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.lang3.StringUtils;

public class MMIVViewerActivityFragment extends ViewerHelperFragment {
    public Bundle X4;
    public ArrayList<Bundle> Y4;
    public int Z4;

    public void I4(String str, int i2) {
        Bundle bundle = new Bundle();
        bundle.putString("sequence", String.valueOf(i2));
        bundle.putString("label", str);
        this.Y4.add(bundle);
    }

    public String J4(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int i2 = this.Z4 + 1;
        this.Z4 = i2;
        String valueOf = String.valueOf(i2);
        return "<a name=\"f" + valueOf + "\"><div id=\"h" + valueOf + "\" class=\"headerExpanded3\"  DIR=\"" + str3 + "\" onclick=\"collapse(f" + valueOf + ");toggleHeaderExpanded3(h" + valueOf + ");\"><span class=\"fieldname\" style=\"font-family:" + str2 + ";\">" + str + "</span></div></a><div class=\"content\" DIR=\"" + str7 + "\" id=\"f" + valueOf + "\" style=\"font-family:" + str5 + "; " + str6 + "\">" + str4 + "</div>";
    }

    public String K4(String str, String str2, String str3, String str4) {
        int i2 = this.Z4 + 1;
        this.Z4 = i2;
        String valueOf = String.valueOf(i2);
        return "<div class=\"content\" DIR=\"" + str4 + "\" id=\"f" + valueOf + "\" style=\"font-family:" + str2 + "; " + str3 + "\">" + str + "</div>";
    }

    public String L4(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int i2 = this.Z4 + 1;
        this.Z4 = i2;
        String valueOf = String.valueOf(i2);
        return "<a name=\"f" + valueOf + "\"><div id=\"h" + valueOf + "\" class=\"headerExpanded\"  DIR=\"" + str3 + "\" onclick=\"collapse(f" + valueOf + ");toggleHeaderExpanded(h" + valueOf + ");\"><span class=\"fieldname\" style=\"font-family:" + str2 + ";\">" + str + "</span></div></a><div class=\"content\" DIR=\"" + str7 + "\" id=\"f" + valueOf + "\" style=\"font-family:" + str5 + "; " + str6 + "\">" + str4 + "</div>";
    }

    public String M4(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int i2 = this.Z4 + 1;
        this.Z4 = i2;
        String valueOf = String.valueOf(i2);
        return "<a name=\"f" + valueOf + "\"><div id=\"h" + valueOf + "\" class=\"headerExpanded2\"  DIR=\"" + str3 + "\" onclick=\"collapse(f" + valueOf + ");toggleHeaderExpanded2(h" + valueOf + ");\"><span class=\"fieldname\" style=\"font-family:" + str2 + ";\">" + str + "</span></div></a><div class=\"content\" DIR=\"" + str7 + "\" id=\"f" + valueOf + "\" style=\"font-family:" + str5 + "; " + str6 + "\">" + str4 + "</div>";
    }

    public String N4(String str) {
        if (str.equals("C")) {
            return "iv_compat_compatible";
        }
        if (str.equals("I")) {
            return "iv_compat_incompatible";
        }
        if (str.equals("U")) {
            return "iv_compat_uncertain";
        }
        if (str.equals("N")) {
            return "iv_compat_nottested";
        }
        return str.equals(ExifInterface.X4) ? "iv_compat_cautionvariable" : "";
    }

    public String O4(String str) {
        ArrayList arrayList = new ArrayList(Arrays.asList(StringUtils.splitByWholeSeparator(str, "/")));
        arrayList.remove(arrayList.size() - 1);
        return StringUtils.join((Iterable<?>) arrayList, "/");
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
        String str = this.A4;
        if (str == null || str.length() == 0) {
            this.Z4 = 0;
            this.Y4 = new ArrayList<>();
            r3(new Runnable() {
                public void run() {
                    String str;
                    String str2;
                    MMIVViewerActivityFragment mMIVViewerActivityFragment = MMIVViewerActivityFragment.this;
                    String str3 = "";
                    mMIVViewerActivityFragment.A4 = str3;
                    String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(mMIVViewerActivityFragment.E4.replace("doc-", str3), ",,,");
                    String str4 = "</div>";
                    String str5 = "\" style=\"margin:2px;width: 100%%;max-width:25px\"/>";
                    if (splitByWholeSeparator[0].equals("solution")) {
                        String str6 = splitByWholeSeparator[1];
                        String str7 = splitByWholeSeparator[2];
                        String str8 = "<div style=\"display: flex; align-items: center\"><img src=\"";
                        String str9 = splitByWholeSeparator[3];
                        String str10 = splitByWholeSeparator[4];
                        String str11 = ".png";
                        MMIVViewerActivityFragment mMIVViewerActivityFragment2 = MMIVViewerActivityFragment.this;
                        String str12 = "file:///android_asset/";
                        String str13 = "result";
                        mMIVViewerActivityFragment2.Q4.m(mMIVViewerActivityFragment2.D4, "Update app_state set value=" + str9 + ", title='" + str10 + "' where key='current_solution_id'");
                        MMIVViewerActivityFragment mMIVViewerActivityFragment3 = MMIVViewerActivityFragment.this;
                        StringBuilder sb = new StringBuilder();
                        sb.append(str7);
                        sb.append(" - ");
                        sb.append(str10);
                        mMIVViewerActivityFragment3.F4 = sb.toString();
                        MMIVViewerActivityFragment mMIVViewerActivityFragment4 = MMIVViewerActivityFragment.this;
                        ArrayList<Bundle> V = mMIVViewerActivityFragment4.Q4.V(mMIVViewerActivityFragment4.D4, "Select * from v_solution_intermediate");
                        if (V == null) {
                            V = new ArrayList<>();
                        }
                        Iterator<Bundle> it2 = V.iterator();
                        while (it2.hasNext()) {
                            Bundle next = it2.next();
                            String str14 = next.getString("name") + " - " + next.getString("concentration");
                            if (next.getString("storage").length() > 0) {
                                str2 = str3 + MMIVViewerActivityFragment.this.M4("Storage", "", "LTR", next.getString("storage"), "", "margin-left:15px;", "");
                            } else {
                                str2 = str3;
                            }
                            if (next.getString("study_period").length() > 0) {
                                str2 = str2 + MMIVViewerActivityFragment.this.M4("Study Period", "", "LTR", next.getString("study_period"), "", "margin-left:15px;", "");
                            }
                            if (next.getString(TtmlNode.W).length() > 0) {
                                str2 = str2 + MMIVViewerActivityFragment.this.M4("Container", "", "LTR", next.getString(TtmlNode.W), "", "margin-left:15px;", "");
                            }
                            if (next.getString(CookiePolicy.BROWSER_COMPATIBILITY).length() > 0) {
                                str2 = str2 + MMIVViewerActivityFragment.this.M4("Physical Compatibility", "", "LTR", next.getString(CookiePolicy.BROWSER_COMPATIBILITY), "", "margin-left:15px;", "");
                            }
                            if (next.getString("stability").length() > 0) {
                                str2 = str2 + MMIVViewerActivityFragment.this.M4("Chemical Stability", "", "LTR", next.getString("stability"), "", "margin-left:15px;", "");
                            }
                            String str15 = str2;
                            String str16 = str8 + (str12 + MMIVViewerActivityFragment.this.N4(next.getString(str13)) + str11) + str5 + str14 + str4;
                            Iterator<Bundle> it3 = it2;
                            MMIVViewerActivityFragment.this.A4 = MMIVViewerActivityFragment.this.A4 + MMIVViewerActivityFragment.this.L4(str16, "", "LTR", str15, "", "margin-left:10px;margin-top:5px", "");
                            MMIVViewerActivityFragment mMIVViewerActivityFragment5 = MMIVViewerActivityFragment.this;
                            mMIVViewerActivityFragment5.I4(str14, mMIVViewerActivityFragment5.Z4);
                            it2 = it3;
                        }
                        return;
                    }
                    String str17 = splitByWholeSeparator[1];
                    String str18 = "<div style=\"display: flex; align-items: center\"><img src=\"";
                    String str19 = splitByWholeSeparator[2];
                    String str20 = ".png";
                    String str21 = splitByWholeSeparator[3];
                    String str22 = splitByWholeSeparator[4];
                    String str23 = "file:///android_asset/";
                    MMIVViewerActivityFragment mMIVViewerActivityFragment6 = MMIVViewerActivityFragment.this;
                    String str24 = "result";
                    String str25 = "stability";
                    mMIVViewerActivityFragment6.Q4.m(mMIVViewerActivityFragment6.D4, "Update app_state set value=" + str17 + ", title='" + str19 + "' where key='current_agent_id'");
                    MMIVViewerActivityFragment mMIVViewerActivityFragment7 = MMIVViewerActivityFragment.this;
                    mMIVViewerActivityFragment7.Q4.m(mMIVViewerActivityFragment7.D4, "Update app_state set value=" + str21 + ", title='" + str22 + "' where key='current_drug2_id'");
                    MMIVViewerActivityFragment mMIVViewerActivityFragment8 = MMIVViewerActivityFragment.this;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str19);
                    sb2.append(" - ");
                    sb2.append(str22);
                    mMIVViewerActivityFragment8.F4 = sb2.toString();
                    MMIVViewerActivityFragment mMIVViewerActivityFragment9 = MMIVViewerActivityFragment.this;
                    ArrayList<Bundle> V2 = mMIVViewerActivityFragment9.Q4.V(mMIVViewerActivityFragment9.D4, "Select * from v_drug_drug_intermediate");
                    if (V2 == null) {
                        V2 = new ArrayList<>();
                    }
                    Iterator<Bundle> it4 = V2.iterator();
                    while (it4.hasNext()) {
                        Bundle next2 = it4.next();
                        String str26 = next2.getString("drug1_title") + StringUtils.SPACE + next2.getString("drug1_concentration") + " : " + next2.getString("drug1_vehicle") + " <br/> " + next2.getString("drug2_title") + StringUtils.SPACE + next2.getString("drug2_concentration") + " :";
                        if (next2.getString("storage").length() > 0) {
                            str = str3 + MMIVViewerActivityFragment.this.M4("Storage", "", "LTR", next2.getString("storage"), "", "margin-left:15px;", "");
                        } else {
                            str = str3;
                        }
                        if (next2.getString("study_period").length() > 0) {
                            str = str + MMIVViewerActivityFragment.this.M4("Study Period", "", "LTR", next2.getString("study_period"), "", "margin-left:15px;", "");
                        }
                        if (next2.getString(TtmlNode.W).length() > 0) {
                            str = str + MMIVViewerActivityFragment.this.M4("Container", "", "LTR", next2.getString(TtmlNode.W), "", "margin-left:15px;", "");
                        }
                        if (next2.getString(CookiePolicy.BROWSER_COMPATIBILITY).length() > 0) {
                            str = str + MMIVViewerActivityFragment.this.M4("Physical Compatibility", "", "LTR", next2.getString(CookiePolicy.BROWSER_COMPATIBILITY), "", "margin-left:15px;", "");
                        }
                        String str27 = str25;
                        if (next2.getString(str27).length() > 0) {
                            str = str + MMIVViewerActivityFragment.this.M4("Chemical Stability", "", "LTR", next2.getString(str27), "", "margin-left:15px;", "");
                        }
                        String str28 = str;
                        String str29 = str18 + (str23 + MMIVViewerActivityFragment.this.N4(next2.getString(str24)) + str20) + str5 + str26 + str4;
                        Iterator<Bundle> it5 = it4;
                        MMIVViewerActivityFragment.this.A4 = MMIVViewerActivityFragment.this.A4 + MMIVViewerActivityFragment.this.L4(str29, "", "LTR", str28, "", "margin-left:10px;margin-top:5px", "");
                        MMIVViewerActivityFragment mMIVViewerActivityFragment10 = MMIVViewerActivityFragment.this;
                        mMIVViewerActivityFragment10.I4(str26, mMIVViewerActivityFragment10.Z4);
                        it4 = it5;
                        str3 = str3;
                        str25 = str27;
                    }
                }
            }, new Runnable() {
                public void run() {
                    MMIVViewerActivityFragment mMIVViewerActivityFragment = MMIVViewerActivityFragment.this;
                    String d4 = mMIVViewerActivityFragment.d4(mMIVViewerActivityFragment.r(), "MMHeader.css");
                    MMIVViewerActivityFragment mMIVViewerActivityFragment2 = MMIVViewerActivityFragment.this;
                    String d42 = mMIVViewerActivityFragment2.d4(mMIVViewerActivityFragment2.r(), "MMFooter.css");
                    String replace = d4.replace("[size]", "200").replace("[title]", MMIVViewerActivityFragment.this.F4).replace("[include]", "");
                    String g1 = CompressHelper.g1(MMIVViewerActivityFragment.this.D4, "base");
                    MMIVViewerActivityFragment mMIVViewerActivityFragment3 = MMIVViewerActivityFragment.this;
                    mMIVViewerActivityFragment3.A4 = replace + MMIVViewerActivityFragment.this.A4 + d42;
                    MMIVViewerActivityFragment.this.m3();
                    MMIVViewerActivityFragment mMIVViewerActivityFragment4 = MMIVViewerActivityFragment.this;
                    mMIVViewerActivityFragment4.O3(mMIVViewerActivityFragment4.A4, g1);
                    MMIVViewerActivityFragment.this.f3(R.menu.f1411elsviewer2);
                }
            });
            s4();
        }
        p4();
        o2(false);
        G3();
        return this.C4;
    }

    public void Z3(WebView webView, String str) {
        this.G4.g("ConvertAllImages();");
        this.G4.g("console.log(\"images,,,,,\" + getImageList());");
        super.Z3(webView, str);
    }

    public boolean e1(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.f801action_menu) {
            ASSectionViewer aSSectionViewer = new ASSectionViewer();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("Items", this.Y4);
            bundle.putString("TitleProperty", "label");
            aSSectionViewer.A2(this, 0);
            aSSectionViewer.i2(bundle);
            aSSectionViewer.Z2(true);
            aSSectionViewer.e3(M(), "asdfasdfasdf");
        }
        return super.e1(menuItem);
    }

    public void e3(Menu menu) {
        menu.removeItem(R.id.f799action_gallery);
    }

    public boolean y4(WebView webView, String str, String str2, String str3) {
        iMDLogger.j("Override", "Url : " + str + ", Scheme : " + str2 + ", Resource : " + str3);
        return true;
    }
}
