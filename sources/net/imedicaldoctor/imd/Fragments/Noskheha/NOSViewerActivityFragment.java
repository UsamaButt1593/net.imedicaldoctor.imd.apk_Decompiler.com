package net.imedicaldoctor.imd.Fragments.Noskheha;

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
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.iMDLogger;
import org.apache.commons.lang3.StringUtils;

public class NOSViewerActivityFragment extends ViewerHelperFragment {
    public Bundle X4;
    public ArrayList<String> Y4;
    public ArrayList<Bundle> Z4;
    public boolean a5;

    /* access modifiers changed from: private */
    public String J4(String str, String str2, String str3, String str4, String str5) {
        return "<div class=\"content\" DIR=\"" + str4 + "\" id=\"f" + str5 + "\" style=\"font-family:" + str2 + "; " + str3 + "\">" + str + "</div>";
    }

    public View U0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.C4;
        if (view != null) {
            return view;
        }
        View inflate = layoutInflater.inflate(R.layout.f1255fragment_new_viewer, viewGroup, false);
        this.C4 = inflate;
        this.a5 = true;
        r4(inflate, bundle);
        if (y() == null) {
            return this.C4;
        }
        T2(new Runnable() {
            public void run() {
                NOSViewerActivityFragment nOSViewerActivityFragment;
                String str;
                String str2;
                String str3;
                String str4;
                try {
                    String str5 = NOSViewerActivityFragment.this.A4;
                    if (str5 != null) {
                        if (str5.length() == 0) {
                        }
                        NOSViewerActivityFragment.this.m3();
                        return;
                    }
                    iMDLogger.f("Loading Document", NOSViewerActivityFragment.this.E4);
                    NOSViewerActivityFragment nOSViewerActivityFragment2 = NOSViewerActivityFragment.this;
                    CompressHelper compressHelper = nOSViewerActivityFragment2.Q4;
                    Bundle bundle = nOSViewerActivityFragment2.D4;
                    ArrayList<Bundle> V = compressHelper.V(bundle, "Select * from docs where id=" + NOSViewerActivityFragment.this.E4);
                    if (V != null) {
                        if (V.size() != 0) {
                            NOSViewerActivityFragment.this.X4 = V.get(0);
                            NOSViewerActivityFragment nOSViewerActivityFragment3 = NOSViewerActivityFragment.this;
                            nOSViewerActivityFragment3.F4 = nOSViewerActivityFragment3.X4.getString("name");
                            NOSViewerActivityFragment nOSViewerActivityFragment4 = NOSViewerActivityFragment.this;
                            nOSViewerActivityFragment4.F4 = nOSViewerActivityFragment4.F4.replace("\\n", StringUtils.SPACE);
                            String replace = NOSViewerActivityFragment.this.X4.getString(Annotation.i3).replace("\\n", "<br />");
                            if (NOSViewerActivityFragment.this.D4.getString("Name").equals("orders.db")) {
                                nOSViewerActivityFragment = NOSViewerActivityFragment.this;
                                str = "";
                                str2 = "";
                                str3 = "LTR";
                                str4 = "0";
                            } else {
                                nOSViewerActivityFragment = NOSViewerActivityFragment.this;
                                str = "X Traffic";
                                str2 = "";
                                str3 = "RTL";
                                str4 = "0";
                            }
                            String I4 = nOSViewerActivityFragment.J4(replace, str, str2, str3, str4);
                            NOSViewerActivityFragment nOSViewerActivityFragment5 = NOSViewerActivityFragment.this;
                            String d4 = nOSViewerActivityFragment5.d4(nOSViewerActivityFragment5.r(), "IDHeader.css");
                            NOSViewerActivityFragment nOSViewerActivityFragment6 = NOSViewerActivityFragment.this;
                            String d42 = nOSViewerActivityFragment6.d4(nOSViewerActivityFragment6.r(), "IDFooter.css");
                            String replace2 = d4.replace("[size]", "200").replace("[title]", NOSViewerActivityFragment.this.F4).replace("[include]", "");
                            NOSViewerActivityFragment nOSViewerActivityFragment7 = NOSViewerActivityFragment.this;
                            nOSViewerActivityFragment7.A4 = replace2 + I4 + d42;
                            NOSViewerActivityFragment.this.m3();
                            return;
                        }
                    }
                    NOSViewerActivityFragment.this.p4 = "Document doesn't exist";
                } catch (Exception e2) {
                    e2.printStackTrace();
                    NOSViewerActivityFragment.this.p4 = e2.getLocalizedMessage();
                }
            }
        }, new Runnable() {
            public void run() {
                String str = NOSViewerActivityFragment.this.p4;
                if (str == null || str.length() <= 0) {
                    String g1 = CompressHelper.g1(NOSViewerActivityFragment.this.D4, "base");
                    NOSViewerActivityFragment.this.s4();
                    NOSViewerActivityFragment nOSViewerActivityFragment = NOSViewerActivityFragment.this;
                    nOSViewerActivityFragment.O3(nOSViewerActivityFragment.A4, g1);
                    NOSViewerActivityFragment.this.p4();
                    NOSViewerActivityFragment.this.f3(R.menu.f1411elsviewer2);
                    NOSViewerActivityFragment.this.o2(false);
                    NOSViewerActivityFragment.this.G3();
                    return;
                }
                NOSViewerActivityFragment nOSViewerActivityFragment2 = NOSViewerActivityFragment.this;
                nOSViewerActivityFragment2.C4(nOSViewerActivityFragment2.p4);
            }
        });
        return this.C4;
    }

    public void Z3(WebView webView, String str) {
        super.Z3(webView, str);
    }

    public boolean e1(MenuItem menuItem) {
        menuItem.getItemId();
        return super.e1(menuItem);
    }

    public void e3(Menu menu) {
        menu.removeItem(R.id.f799action_gallery);
        menu.removeItem(R.id.f801action_menu);
    }

    public boolean y4(WebView webView, String str, String str2, String str3) {
        iMDLogger.j("Override", "Url : " + str + ", Scheme : " + str2 + ", Resource : " + str3);
        return true;
    }
}
