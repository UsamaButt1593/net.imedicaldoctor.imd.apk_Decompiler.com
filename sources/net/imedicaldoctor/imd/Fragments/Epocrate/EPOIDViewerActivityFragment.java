package net.imedicaldoctor.imd.Fragments.Epocrate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.itextpdf.text.Annotation;
import java.util.ArrayList;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.Lexi.LXSectionsViewer;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.iMDLogger;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

public class EPOIDViewerActivityFragment extends ViewerHelperFragment {
    public ArrayList<Bundle> X4;
    public int Y4;
    public String Z4;
    public JSONObject a5;

    public void I4(String str, int i2) {
        Bundle bundle = new Bundle();
        bundle.putString("sequence", String.valueOf(i2));
        bundle.putString("label", str);
        this.X4.add(bundle);
    }

    public String J4(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int i2 = this.Y4 + 1;
        this.Y4 = i2;
        String valueOf = String.valueOf(i2);
        return "<a name=\"f" + valueOf + "\"><div id=\"h" + valueOf + "\" class=\"headerExpanded\"  DIR=\"" + str3 + "\" onclick=\"collapse(f" + valueOf + ");toggleHeaderExpanded(h" + valueOf + ");\"><span class=\"fieldname\" style=\"font-family:" + str2 + ";\">" + str + "</span></div></a><div class=\"content\" DIR=\"" + str7 + "\" id=\"f" + valueOf + "\" style=\"font-family:" + str5 + "; " + str6 + "\">" + str4 + "</div>";
    }

    public View U0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        String str2;
        View view = this.C4;
        if (view != null) {
            return view;
        }
        int i2 = 0;
        View inflate = layoutInflater.inflate(R.layout.f1255fragment_new_viewer, viewGroup, false);
        this.C4 = inflate;
        r4(inflate, bundle);
        if (y() == null) {
            return this.C4;
        }
        try {
            String str3 = this.A4;
            if (str3 != null) {
                if (str3.length() == 0) {
                }
                O3(this.A4, CompressHelper.f1(this.D4));
                s4();
                p4();
                f3(R.menu.f1411elsviewer2);
                o2(false);
                G3();
                return this.C4;
            }
            this.Y4 = 0;
            this.X4 = new ArrayList<>();
            iMDLogger.f("Loading Document", this.E4);
            String[] split = this.E4.split("-");
            int i3 = 1;
            String str4 = split[1];
            if (split.length == 3) {
                this.Z4 = split[2];
            }
            ArrayList<Bundle> V = this.Q4.V(this.D4, "Select * from id_monographs where id=" + str4);
            if (V != null) {
                if (V.size() != 0) {
                    Bundle bundle2 = V.get(0);
                    this.F4 = bundle2.getString("title");
                    JSONObject jSONObject = new JSONObject(this.Q4.B(bundle2.getString("monograph"), str4, "127")).getJSONObject(Annotation.i3);
                    this.a5 = jSONObject;
                    String[] strArr = {"empiric", "specific", "other"};
                    String str5 = "";
                    if (this.Z4 == null) {
                        str2 = str5;
                        int i4 = 0;
                        for (int i5 = 3; i4 < i5; i5 = 3) {
                            String str6 = strArr[i4];
                            String str7 = str6.substring(i2, i3).toUpperCase() + str6.substring(i3).toLowerCase();
                            String replace = this.Q4.r1(this.a5.getJSONArray("views"), "id", str6).getString(Annotation.i3).replace("<html>", str5).replace("</html>", str5);
                            StringBuilder sb = new StringBuilder();
                            sb.append(str2);
                            StringBuilder sb2 = sb;
                            sb2.append(J4(str7, "", "LTR", replace, "", "", ""));
                            str2 = sb2.toString();
                            I4(str7, this.Y4);
                            i4++;
                            str5 = str5;
                            i2 = 0;
                            i3 = 1;
                        }
                        str = str5;
                    } else {
                        str = str5;
                        JSONObject r1 = this.Q4.r1(jSONObject.getJSONArray("views"), "id", this.Z4);
                        str2 = "<div style=\"margin:0px\">" + r1.getString(Annotation.i3) + "</div>";
                    }
                    String d4 = d4(r(), "EPOHeader.css");
                    String d42 = d4(r(), "EPOFooter.css");
                    this.A4 = d4.replace("[size]", "200").replace("[title]", this.F4).replace("[include]", str) + str2.replace("..", ".") + d42;
                    O3(this.A4, CompressHelper.f1(this.D4));
                    s4();
                    p4();
                    f3(R.menu.f1411elsviewer2);
                    o2(false);
                    G3();
                    return this.C4;
                }
            }
            CompressHelper.x2(r(), "Document doesn't exist", 1);
            return this.C4;
        } catch (Exception e2) {
            B4(e2);
        }
    }

    public boolean e1(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.f801action_menu) {
            LXSectionsViewer lXSectionsViewer = new LXSectionsViewer();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("fields", this.X4);
            lXSectionsViewer.i2(bundle);
            lXSectionsViewer.Z2(true);
            lXSectionsViewer.A2(this, 0);
            lXSectionsViewer.e3(M(), "LXSectionsViewer");
        }
        return super.e1(menuItem);
    }

    public void e3(Menu menu) {
        menu.removeItem(R.id.f799action_gallery);
    }

    public boolean y4(WebView webView, String str, String str2, String str3) {
        if (!this.Q4.N1(this.D4, str) && str3.contains("//current/")) {
            String str4 = StringUtils.splitByWholeSeparator(str3, "//current/")[1];
            CompressHelper compressHelper = this.Q4;
            Bundle bundle = this.D4;
            compressHelper.A1(bundle, this.E4 + "-" + str4, (String[]) null, (String) null);
        }
        return true;
    }
}
