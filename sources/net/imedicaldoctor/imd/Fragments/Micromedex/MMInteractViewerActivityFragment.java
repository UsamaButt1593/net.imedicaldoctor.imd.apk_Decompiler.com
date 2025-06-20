package net.imedicaldoctor.imd.Fragments.Micromedex;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.google.common.net.HttpHeaders;
import java.util.ArrayList;
import java.util.Arrays;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.Amirsys.ASSectionViewer;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.iMDLogger;
import org.apache.commons.lang3.StringUtils;

public class MMInteractViewerActivityFragment extends ViewerHelperFragment {
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
        T2(new Runnable() {
            public void run() {
                try {
                    String str = MMInteractViewerActivityFragment.this.A4;
                    if (str != null) {
                        if (str.length() == 0) {
                        }
                        MMInteractViewerActivityFragment.this.m3();
                        return;
                    }
                    iMDLogger.f("Loading Document", MMInteractViewerActivityFragment.this.E4);
                    String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(MMInteractViewerActivityFragment.this.E4.split("-")[1], ",,,,,");
                    String str2 = splitByWholeSeparator[0];
                    MMInteractViewerActivityFragment mMInteractViewerActivityFragment = MMInteractViewerActivityFragment.this;
                    mMInteractViewerActivityFragment.F4 = splitByWholeSeparator[1];
                    CompressHelper compressHelper = mMInteractViewerActivityFragment.Q4;
                    Bundle bundle = mMInteractViewerActivityFragment.D4;
                    compressHelper.m(bundle, "Update app_state set value=" + str2 + " where key='current_doc'");
                    MMInteractViewerActivityFragment mMInteractViewerActivityFragment2 = MMInteractViewerActivityFragment.this;
                    ArrayList<Bundle> V = mMInteractViewerActivityFragment2.Q4.V(mMInteractViewerActivityFragment2.D4, "Select * from v_interactions_mono");
                    if (V != null) {
                        if (V.size() != 0) {
                            MMInteractViewerActivityFragment.this.Y4 = new ArrayList<>();
                            MMInteractViewerActivityFragment mMInteractViewerActivityFragment3 = MMInteractViewerActivityFragment.this;
                            mMInteractViewerActivityFragment3.Z4 = 0;
                            mMInteractViewerActivityFragment3.X4 = V.get(0);
                            StringBuilder sb = new StringBuilder();
                            sb.append("");
                            MMInteractViewerActivityFragment mMInteractViewerActivityFragment4 = MMInteractViewerActivityFragment.this;
                            sb.append(mMInteractViewerActivityFragment4.M4("Evidence", "", "LTR", mMInteractViewerActivityFragment4.X4.getString("evidence"), "", "margin-left:10px;margin-top:5px", ""));
                            String sb2 = sb.toString();
                            MMInteractViewerActivityFragment mMInteractViewerActivityFragment5 = MMInteractViewerActivityFragment.this;
                            mMInteractViewerActivityFragment5.I4("Evidence", mMInteractViewerActivityFragment5.Z4);
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(sb2);
                            MMInteractViewerActivityFragment mMInteractViewerActivityFragment6 = MMInteractViewerActivityFragment.this;
                            sb3.append(mMInteractViewerActivityFragment6.M4("Onset", "", "LTR", mMInteractViewerActivityFragment6.X4.getString("onset"), "", "margin-left:10px;margin-top:5px", ""));
                            String sb4 = sb3.toString();
                            MMInteractViewerActivityFragment mMInteractViewerActivityFragment7 = MMInteractViewerActivityFragment.this;
                            mMInteractViewerActivityFragment7.I4("Onset", mMInteractViewerActivityFragment7.Z4);
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append(sb4);
                            MMInteractViewerActivityFragment mMInteractViewerActivityFragment8 = MMInteractViewerActivityFragment.this;
                            sb5.append(mMInteractViewerActivityFragment8.M4("Severity", "", "LTR", mMInteractViewerActivityFragment8.X4.getString("severity"), "", "margin-left:10px;margin-top:5px", ""));
                            String sb6 = sb5.toString();
                            MMInteractViewerActivityFragment mMInteractViewerActivityFragment9 = MMInteractViewerActivityFragment.this;
                            mMInteractViewerActivityFragment9.I4("Severity", mMInteractViewerActivityFragment9.Z4);
                            StringBuilder sb7 = new StringBuilder();
                            sb7.append(sb6);
                            MMInteractViewerActivityFragment mMInteractViewerActivityFragment10 = MMInteractViewerActivityFragment.this;
                            sb7.append(mMInteractViewerActivityFragment10.M4(HttpHeaders.f22879g, "", "LTR", mMInteractViewerActivityFragment10.X4.getString("warning"), "", "margin-left:10px;margin-top:5px", ""));
                            String sb8 = sb7.toString();
                            MMInteractViewerActivityFragment mMInteractViewerActivityFragment11 = MMInteractViewerActivityFragment.this;
                            mMInteractViewerActivityFragment11.I4(HttpHeaders.f22879g, mMInteractViewerActivityFragment11.Z4);
                            StringBuilder sb9 = new StringBuilder();
                            sb9.append(sb8);
                            MMInteractViewerActivityFragment mMInteractViewerActivityFragment12 = MMInteractViewerActivityFragment.this;
                            sb9.append(mMInteractViewerActivityFragment12.M4("Description", "", "LTR", mMInteractViewerActivityFragment12.X4.getString("monograph"), "", "margin-left:10px;margin-top:5px", ""));
                            String sb10 = sb9.toString();
                            MMInteractViewerActivityFragment mMInteractViewerActivityFragment13 = MMInteractViewerActivityFragment.this;
                            mMInteractViewerActivityFragment13.I4("Description", mMInteractViewerActivityFragment13.Z4);
                            MMInteractViewerActivityFragment mMInteractViewerActivityFragment14 = MMInteractViewerActivityFragment.this;
                            String d4 = mMInteractViewerActivityFragment14.d4(mMInteractViewerActivityFragment14.r(), "MMHeader.css");
                            MMInteractViewerActivityFragment mMInteractViewerActivityFragment15 = MMInteractViewerActivityFragment.this;
                            String d42 = mMInteractViewerActivityFragment15.d4(mMInteractViewerActivityFragment15.r(), "MMFooter.css");
                            String replace = d4.replace("[size]", "200").replace("[title]", MMInteractViewerActivityFragment.this.F4).replace("[include]", "");
                            MMInteractViewerActivityFragment mMInteractViewerActivityFragment16 = MMInteractViewerActivityFragment.this;
                            mMInteractViewerActivityFragment16.A4 = replace + sb10 + d42;
                            MMInteractViewerActivityFragment.this.m3();
                            return;
                        }
                    }
                    MMInteractViewerActivityFragment.this.p4 = "Document doesn't exist";
                } catch (Exception e2) {
                    e2.printStackTrace();
                    MMInteractViewerActivityFragment.this.p4 = e2.getLocalizedMessage();
                }
            }
        }, new Runnable() {
            public void run() {
                String str = MMInteractViewerActivityFragment.this.p4;
                if (str == null || str.length() <= 0) {
                    String g1 = CompressHelper.g1(MMInteractViewerActivityFragment.this.D4, "base");
                    MMInteractViewerActivityFragment mMInteractViewerActivityFragment = MMInteractViewerActivityFragment.this;
                    mMInteractViewerActivityFragment.O3(mMInteractViewerActivityFragment.A4, g1);
                    MMInteractViewerActivityFragment.this.s4();
                    MMInteractViewerActivityFragment.this.p4();
                    MMInteractViewerActivityFragment.this.f3(R.menu.f1411elsviewer2);
                    MMInteractViewerActivityFragment.this.o2(false);
                    MMInteractViewerActivityFragment.this.G3();
                    return;
                }
                MMInteractViewerActivityFragment mMInteractViewerActivityFragment2 = MMInteractViewerActivityFragment.this;
                mMInteractViewerActivityFragment2.C4(mMInteractViewerActivityFragment2.p4);
            }
        });
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
