package net.imedicaldoctor.imd.Fragments.Epocrate;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.itextpdf.text.Annotation;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.html.HTML;
import java.io.File;
import java.util.ArrayList;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.Lexi.LXSectionsViewer;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.Gallery.GalleryActivity;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Utils.iMDWebView;
import net.imedicaldoctor.imd.iMDLogger;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

public class EPODxViewerActivityFragment extends ViewerHelperFragment {
    public String X4;
    public Bundle Y4;
    public JSONObject Z4;
    public int a5;
    public ArrayList<Bundle> b5;
    public ArrayList<Bundle> c5;

    private void O4(String str) {
        ArrayList<Bundle> arrayList = this.b5;
        if (arrayList == null || arrayList.size() == 0) {
            CompressHelper.x2(r(), "There is no media in this document", 1);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(this.b5);
        int i2 = 0;
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            if (((Bundle) arrayList2.get(i3)).getString("id").startsWith(str)) {
                i2 = i3;
            }
        }
        Intent intent = new Intent(r(), GalleryActivity.class);
        intent.putExtra("Images", arrayList2);
        intent.putExtra("Start", i2);
        D2(intent);
    }

    public void C3(String str) {
        iMDLogger.j("Gotosection", str);
        iMDWebView imdwebview = this.G4;
        imdwebview.g("document.getElementById(\"" + str + "\").scrollIntoView(true);document.body.scrollTop = window.pageYOffset - 50;");
    }

    public void I4(String str, int i2) {
        Bundle bundle = new Bundle();
        bundle.putString("sequence", String.valueOf(i2));
        bundle.putString("label", str);
        this.c5.add(bundle);
    }

    public String J4(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int i2 = this.a5 + 1;
        this.a5 = i2;
        String valueOf = String.valueOf(i2);
        return "<a name=\"f" + valueOf + "\"><div id=\"h" + valueOf + "\" class=\"headerExpanded3\"  DIR=\"" + str3 + "\" onclick=\"collapse(f" + valueOf + ");toggleHeaderExpanded3(h" + valueOf + ");\"><span class=\"fieldname\" style=\"font-family:" + str2 + ";\">" + str + "</span></div></a><div class=\"content\" DIR=\"" + str7 + "\" id=\"f" + valueOf + "\" style=\"font-family:" + str5 + "; " + str6 + "\">" + str4 + "</div>";
    }

    public String K4(String str, String str2, String str3, String str4) {
        int i2 = this.a5 + 1;
        this.a5 = i2;
        String valueOf = String.valueOf(i2);
        return "<div class=\"content\" DIR=\"" + str4 + "\" id=\"f" + valueOf + "\" style=\"font-family:" + str2 + "; " + str3 + "\">" + str + "</div>";
    }

    public String L4(JSONObject jSONObject, int i2) {
        JSONObject jSONObject2;
        String str;
        StringBuilder sb;
        String str2;
        String str3;
        String str4;
        String str5;
        int i3;
        int i4;
        String str6;
        String str7;
        JSONObject jSONObject3;
        String str8;
        String str9;
        JSONObject jSONObject4 = jSONObject;
        int i5 = i2;
        String str10 = "flag";
        String str11 = "cells";
        String str12 = "sections";
        String str13 = "title";
        try {
            if (jSONObject4.has("targetHTML")) {
                return jSONObject4.getString("targetHTML");
            }
            String str14 = "";
            if (!jSONObject4.has(TypedValues.AttributesType.M)) {
                return str14;
            }
            JSONObject r1 = this.Q4.r1(this.Z4.getJSONArray("views"), "id", jSONObject4.getString(TypedValues.AttributesType.M));
            if (r1.getString("type").equals("web")) {
                return r1.getString(HTML.Tag.y);
            }
            String str15 = str14;
            int i6 = 0;
            while (i6 < r1.getJSONArray(str12).length()) {
                JSONObject jSONObject5 = r1.getJSONArray(str12).getJSONObject(i6);
                String str16 = str14;
                int i7 = 0;
                while (true) {
                    jSONObject2 = r1;
                    str = str15;
                    if (i7 >= jSONObject5.getJSONArray(str11).length()) {
                        break;
                    }
                    JSONObject jSONObject6 = jSONObject5.getJSONArray(str11).getJSONObject(i7);
                    int i8 = i7;
                    String L4 = L4(jSONObject6, i5 + 1);
                    if (jSONObject6.has(str13)) {
                        JSONObject jSONObject7 = jSONObject5;
                        String string = jSONObject6.getString(str13);
                        int i9 = i6;
                        String str17 = str14;
                        if (jSONObject6.has(str10)) {
                            str8 = str13;
                            StringBuilder sb2 = new StringBuilder();
                            str2 = str11;
                            sb2.append("orb");
                            sb2.append(jSONObject6.getString(str10));
                            sb2.append(".png");
                            string = "<div style=\"display: flex; align-items: center\"><img src=\"" + ("file:///android_asset/" + sb2.toString()) + "\" style=\"margin:2px;width: 100%%;max-width:25px\"/>" + string + "</div>";
                        } else {
                            str8 = str13;
                            str2 = str11;
                        }
                        if (L4.length() <= 0) {
                            i4 = i8;
                            str7 = str8;
                            str5 = str10;
                            jSONObject3 = jSONObject7;
                            str4 = str12;
                            str6 = str17;
                            int i10 = i9;
                            str3 = str;
                            i3 = i10;
                            if (jSONObject6.has("targetURL")) {
                                String string2 = jSONObject6.getString("targetURL");
                                String str18 = "file:///android_asset/" + (string2.contains("rx/monograph/") ? "plus_rx.png" : string2.contains("dx/monograph/") ? "plus_dx.png" : string2.contains("lab/monograph/") ? "plus_lab.png" : string2.contains("lab/list/panel/") ? "plus_panel.png" : str6);
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append(str16);
                                sb3.append(K4("<div style=\"display: flex; align-items: center\"><img src=\"" + str18 + "\" style=\"margin:2px;width: 100%%;max-width:25px\"/><a href=\"" + jSONObject6.getString("targetURL") + "\">" + jSONObject6.getString(str7) + "</a></div>", str6, "margin-left: " + (i5 * 5) + CSS.Value.h0, str6));
                                str9 = sb3.toString();
                            } else {
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append(str16);
                                sb4.append(K4(jSONObject6.getString(str7), str6, "margin-left: " + (i5 * 5) + CSS.Value.h0, str6));
                                str9 = sb4.toString();
                            }
                        } else if (i5 < 2) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append(str16);
                            i4 = i8;
                            str5 = str10;
                            jSONObject3 = jSONObject7;
                            String str19 = str;
                            str4 = str12;
                            i3 = i9;
                            str3 = str19;
                            str6 = str17;
                            sb5.append(N4(string, "", "LTR", L4, "", "margin-left: " + (i5 * 5) + CSS.Value.h0, ""));
                            str9 = sb5.toString();
                            str7 = str8;
                        } else {
                            i4 = i8;
                            str7 = str8;
                            str5 = str10;
                            jSONObject3 = jSONObject7;
                            str4 = str12;
                            str6 = str17;
                            int i11 = i9;
                            str3 = str;
                            i3 = i11;
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append(str16);
                            StringBuilder sb7 = sb6;
                            sb7.append(J4(string, "", "LTR", L4, "", "margin-left: " + (i5 * 5) + CSS.Value.h0, ""));
                            str9 = sb7.toString();
                        }
                        str16 = str9;
                    } else {
                        str2 = str11;
                        str4 = str12;
                        str3 = str;
                        i4 = i8;
                        i3 = i6;
                        str6 = str14;
                        str7 = str13;
                        str5 = str10;
                        jSONObject3 = jSONObject5;
                        str16 = str16 + L4;
                    }
                    i7 = i4 + 1;
                    r1 = jSONObject2;
                    jSONObject5 = jSONObject3;
                    str13 = str7;
                    str14 = str6;
                    i6 = i3;
                    str10 = str5;
                    str12 = str4;
                    str15 = str3;
                    str11 = str2;
                }
                String str20 = str10;
                String str21 = str11;
                String str22 = str12;
                String str23 = str;
                JSONObject jSONObject8 = jSONObject5;
                int i12 = i6;
                String str24 = str14;
                String str25 = str13;
                if (!jSONObject8.has("headerText")) {
                    sb = new StringBuilder();
                    sb.append(str23);
                    sb.append(str16);
                } else if (i5 < 2) {
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append(str23);
                    sb = sb8;
                    sb.append(N4(jSONObject8.getString("headerText"), "", "LTR", str16, "", "margin-left: " + (i5 * 5) + CSS.Value.h0, ""));
                } else {
                    StringBuilder sb9 = new StringBuilder();
                    sb9.append(str23);
                    sb = sb9;
                    sb.append(J4(jSONObject8.getString("headerText"), "", "LTR", str16, "", "margin-left: " + (i5 * 5) + CSS.Value.h0, ""));
                }
                str15 = sb.toString();
                i6 = i12 + 1;
                r1 = jSONObject2;
                str13 = str25;
                str14 = str24;
                str10 = str20;
                str12 = str22;
                str11 = str21;
            }
            return str15;
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            e2.printStackTrace();
            return null;
        }
    }

    public String M4(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int i2 = this.a5 + 1;
        this.a5 = i2;
        String valueOf = String.valueOf(i2);
        return "<a name=\"f" + valueOf + "\"><div id=\"h" + valueOf + "\" class=\"headerExpanded\"  DIR=\"" + str3 + "\" onclick=\"collapse(f" + valueOf + ");toggleHeaderExpanded(h" + valueOf + ");\"><span class=\"fieldname\" style=\"font-family:" + str2 + ";\">" + str + "</span></div></a><div class=\"content\" DIR=\"" + str7 + "\" id=\"f" + valueOf + "\" style=\"font-family:" + str5 + "; " + str6 + "\">" + str4 + "</div>";
    }

    public String N4(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int i2 = this.a5 + 1;
        this.a5 = i2;
        String valueOf = String.valueOf(i2);
        return "<a name=\"f" + valueOf + "\"><div id=\"h" + valueOf + "\" class=\"headerExpanded2\"  DIR=\"" + str3 + "\" onclick=\"collapse(f" + valueOf + ");toggleHeaderExpanded2(h" + valueOf + ");\"><span class=\"fieldname\" style=\"font-family:" + str2 + ";\">" + str + "</span></div></a><div class=\"content\" DIR=\"" + str7 + "\" id=\"f" + valueOf + "\" style=\"font-family:" + str5 + "; " + str6 + "\">" + str4 + "</div>";
    }

    public String R2() {
        ArrayList<Bundle> arrayList;
        Bundle v3;
        if (this.b5.size() <= 0 || (arrayList = this.b5) == null || arrayList.size() <= 0 || (v3 = v3(this.b5)) == null) {
            return null;
        }
        return v3.getString("ImagePath");
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
        T2(new Runnable() {
            public void run() {
                String str;
                String str2 = "cells";
                String str3 = "sections";
                String str4 = "title";
                String str5 = "";
                try {
                    String str6 = EPODxViewerActivityFragment.this.A4;
                    if (str6 != null) {
                        if (str6.length() != 0) {
                            return;
                        }
                    }
                    EPODxViewerActivityFragment ePODxViewerActivityFragment = EPODxViewerActivityFragment.this;
                    ePODxViewerActivityFragment.a5 = 0;
                    ePODxViewerActivityFragment.c5 = new ArrayList<>();
                    iMDLogger.f("Loading Document", EPODxViewerActivityFragment.this.E4);
                    String str7 = EPODxViewerActivityFragment.this.E4.split("-")[1];
                    if (EPODxViewerActivityFragment.this.y().containsKey("mDB")) {
                        EPODxViewerActivityFragment ePODxViewerActivityFragment2 = EPODxViewerActivityFragment.this;
                        ePODxViewerActivityFragment2.X4 = ePODxViewerActivityFragment2.y().getString("mDB");
                    }
                    EPODxViewerActivityFragment ePODxViewerActivityFragment3 = EPODxViewerActivityFragment.this;
                    if (ePODxViewerActivityFragment3.X4 == null) {
                        ePODxViewerActivityFragment3.X4 = "Dx";
                    }
                    ArrayList<Bundle> V = ePODxViewerActivityFragment3.Q4.V(ePODxViewerActivityFragment3.D4, "Select * from " + EPODxViewerActivityFragment.this.X4 + "_monographs where id=" + str7);
                    if (V != null) {
                        if (V.size() != 0) {
                            EPODxViewerActivityFragment.this.Y4 = V.get(0);
                            EPODxViewerActivityFragment ePODxViewerActivityFragment4 = EPODxViewerActivityFragment.this;
                            EPODxViewerActivityFragment.this.Z4 = new JSONObject(ePODxViewerActivityFragment4.Q4.B(ePODxViewerActivityFragment4.Y4.getString("monograph"), str7, "127"));
                            EPODxViewerActivityFragment ePODxViewerActivityFragment5 = EPODxViewerActivityFragment.this;
                            ePODxViewerActivityFragment5.F4 = ePODxViewerActivityFragment5.Z4.getString(str4);
                            EPODxViewerActivityFragment ePODxViewerActivityFragment6 = EPODxViewerActivityFragment.this;
                            JSONObject r1 = ePODxViewerActivityFragment6.Q4.r1(ePODxViewerActivityFragment6.Z4.getJSONArray("views"), "id", "root");
                            EPODxViewerActivityFragment ePODxViewerActivityFragment7 = EPODxViewerActivityFragment.this;
                            String d4 = ePODxViewerActivityFragment7.d4(ePODxViewerActivityFragment7.r(), "EPOHeader.css");
                            EPODxViewerActivityFragment ePODxViewerActivityFragment8 = EPODxViewerActivityFragment.this;
                            String d42 = ePODxViewerActivityFragment8.d4(ePODxViewerActivityFragment8.r(), "EPOFooter.css");
                            String replace = d4.replace("[size]", "200").replace("[title]", EPODxViewerActivityFragment.this.F4).replace("[include]", str5);
                            String str8 = str5;
                            int i2 = 0;
                            while (i2 < r1.getJSONArray(str3).length()) {
                                JSONObject jSONObject = r1.getJSONArray(str3).getJSONObject(i2);
                                int i3 = 0;
                                while (true) {
                                    str = str3;
                                    if (i3 >= jSONObject.getJSONArray(str2).length()) {
                                        break;
                                    }
                                    JSONObject jSONObject2 = jSONObject.getJSONArray(str2).getJSONObject(i3);
                                    String str9 = str2;
                                    String string = jSONObject2.getString(str4);
                                    String replace2 = EPODxViewerActivityFragment.this.L4(jSONObject2, 1).replace("<html>", str5).replace("</html>", str5);
                                    str8 = str8 + EPODxViewerActivityFragment.this.M4(string, "", "LTR", replace2, "", "", "");
                                    EPODxViewerActivityFragment ePODxViewerActivityFragment9 = EPODxViewerActivityFragment.this;
                                    ePODxViewerActivityFragment9.I4(string, ePODxViewerActivityFragment9.a5);
                                    i3++;
                                    str2 = str9;
                                    str3 = str;
                                    str4 = str4;
                                    r1 = r1;
                                }
                                String str10 = str2;
                                String str11 = str4;
                                i2++;
                                str3 = str;
                                r1 = r1;
                            }
                            if (EPODxViewerActivityFragment.this.Z4.has("citations") && EPODxViewerActivityFragment.this.Z4.getJSONObject("citations").has("articles")) {
                                for (int i4 = 0; i4 < EPODxViewerActivityFragment.this.Z4.getJSONObject("citations").getJSONArray("articles").length(); i4++) {
                                    JSONObject jSONObject3 = EPODxViewerActivityFragment.this.Z4.getJSONObject("citations").getJSONArray("articles").getJSONObject(i4);
                                    str5 = str5 + "<div id=\"articleCitation" + jSONObject3.getString("id") + "\" style=\"margin:10px\"><b>" + jSONObject3.getString("id") + ": </b>" + jSONObject3.getString(HTML.Tag.y) + "</div>";
                                }
                                if (str5.length() > 0) {
                                    str8 = str8 + EPODxViewerActivityFragment.this.M4("Citations", "", "LTR", str5, "", "", "");
                                    EPODxViewerActivityFragment ePODxViewerActivityFragment10 = EPODxViewerActivityFragment.this;
                                    ePODxViewerActivityFragment10.I4("Citations", ePODxViewerActivityFragment10.a5);
                                }
                            }
                            ArrayList<Bundle> arrayList = new ArrayList<>();
                            if (EPODxViewerActivityFragment.this.Z4.has("media")) {
                                for (int i5 = 0; i5 < EPODxViewerActivityFragment.this.Z4.getJSONArray("media").length(); i5++) {
                                    JSONObject jSONObject4 = EPODxViewerActivityFragment.this.Z4.getJSONArray("media").getJSONObject(i5);
                                    String string2 = jSONObject4.getString(Annotation.k3);
                                    String h1 = CompressHelper.h1(EPODxViewerActivityFragment.this.D4, string2, "pictures");
                                    if (new File(h1).exists()) {
                                        Bundle bundle = new Bundle();
                                        bundle.putString("ImagePath", h1);
                                        bundle.putString("id", string2);
                                        bundle.putString("Description", jSONObject4.getString(HTML.Tag.f27619g) + StringUtils.LF + jSONObject4.getString("source"));
                                        arrayList.add(bundle);
                                    }
                                }
                            }
                            EPODxViewerActivityFragment.this.b5 = arrayList;
                            String replace3 = str8.replace("..", ".");
                            EPODxViewerActivityFragment.this.A4 = replace + replace3 + d42;
                            return;
                        }
                    }
                    EPODxViewerActivityFragment.this.p4 = "Document doesn't exist";
                } catch (Exception e2) {
                    e2.printStackTrace();
                    EPODxViewerActivityFragment.this.p4 = e2.getLocalizedMessage();
                }
            }
        }, new Runnable() {
            public void run() {
                String str = EPODxViewerActivityFragment.this.p4;
                if (str == null || str.length() <= 0) {
                    String f1 = CompressHelper.f1(EPODxViewerActivityFragment.this.D4);
                    EPODxViewerActivityFragment ePODxViewerActivityFragment = EPODxViewerActivityFragment.this;
                    ePODxViewerActivityFragment.O3(ePODxViewerActivityFragment.A4, f1);
                    EPODxViewerActivityFragment.this.s4();
                    EPODxViewerActivityFragment.this.p4();
                    EPODxViewerActivityFragment.this.f3(R.menu.f1411elsviewer2);
                    EPODxViewerActivityFragment.this.o2(false);
                    EPODxViewerActivityFragment.this.G3();
                    return;
                }
                EPODxViewerActivityFragment ePODxViewerActivityFragment2 = EPODxViewerActivityFragment.this;
                ePODxViewerActivityFragment2.C4(ePODxViewerActivityFragment2.p4);
            }
        });
        return this.C4;
    }

    public boolean e1(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.f799action_gallery) {
            O4("soheilvb");
        }
        if (itemId == R.id.f801action_menu) {
            LXSectionsViewer lXSectionsViewer = new LXSectionsViewer();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("fields", this.c5);
            lXSectionsViewer.i2(bundle);
            lXSectionsViewer.Z2(true);
            lXSectionsViewer.A2(this, 0);
            lXSectionsViewer.e3(M(), "LXSectionsViewer");
        }
        return super.e1(menuItem);
    }

    public boolean y4(WebView webView, String str, String str2, String str3) {
        iMDLogger.j("Override", "Url : " + str + ", Scheme : " + str2 + ", Resource : " + str3);
        if (this.Q4.N1(this.D4, str)) {
            return true;
        }
        if (str3.contains("//current?view=")) {
            try {
                JSONObject r1 = this.Q4.r1(this.Z4.getJSONArray("views"), "id", this.Q4.t1(StringUtils.splitByWholeSeparator(str3, "//current?view=")));
                if (r1 != null && r1.getString("type").equals("image")) {
                    O4(this.Z4.getJSONArray("media").getJSONObject(Integer.valueOf(r1.getJSONArray("image_refs").getString(0)).intValue()).getString(Annotation.k3));
                }
                return true;
            } catch (Exception e2) {
                FirebaseCrashlytics.d().g(e2);
                e2.printStackTrace();
                return true;
            }
        } else if (str3.contains("//current?article=")) {
            try {
                CompressHelper compressHelper = this.Q4;
                Bundle bundle = this.D4;
                compressHelper.A1(bundle, "epohtml-" + ("<div style=\"margin:15px\">" + this.Z4.getJSONObject("citations").getJSONArray("articles").getJSONObject(Integer.valueOf(this.Q4.t1(StringUtils.splitByWholeSeparator(str3, "//current?article="))).intValue() - 1).getString(HTML.Tag.y) + "</div>"), (String[]) null, (String) null);
            } catch (Exception e3) {
                FirebaseCrashlytics.d().g(e3);
                e3.printStackTrace();
            }
            return true;
        } else if (!str2.equals("http")) {
            return false;
        } else {
            this.Q4.A1(this.D4, "epourl-" + str, (String[]) null, (String) null);
            return true;
        }
    }
}
