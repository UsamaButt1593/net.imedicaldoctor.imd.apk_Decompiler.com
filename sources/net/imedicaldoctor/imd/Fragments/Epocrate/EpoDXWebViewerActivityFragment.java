package net.imedicaldoctor.imd.Fragments.Epocrate;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.itextpdf.text.Annotation;
import com.itextpdf.tool.xml.html.HTML;
import java.util.ArrayList;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.Gallery.GalleryActivity;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.iMDLogger;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

public class EpoDXWebViewerActivityFragment extends ViewerHelperFragment {
    public Bundle X4;
    public JSONObject Y4;
    public String Z4;
    public ArrayList<Bundle> a5;

    private void I4(String str) {
        ArrayList<Bundle> arrayList = this.a5;
        if (arrayList == null || arrayList.size() == 0) {
            CompressHelper.x2(r(), "There is no media in this document", 1);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(this.a5);
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

    public String R2() {
        ArrayList<Bundle> arrayList;
        Bundle v3;
        if (this.a5.size() <= 0 || (arrayList = this.a5) == null || arrayList.size() <= 0 || (v3 = v3(this.a5)) == null) {
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
                try {
                    String str = EpoDXWebViewerActivityFragment.this.A4;
                    if (str != null) {
                        if (str.length() != 0) {
                            return;
                        }
                    }
                    EpoDXWebViewerActivityFragment epoDXWebViewerActivityFragment = EpoDXWebViewerActivityFragment.this;
                    epoDXWebViewerActivityFragment.E4 = epoDXWebViewerActivityFragment.y().getString("DocAddress");
                    iMDLogger.f("Loading Document", EpoDXWebViewerActivityFragment.this.E4);
                    String str2 = EpoDXWebViewerActivityFragment.this.E4.split("-")[1];
                    if (EpoDXWebViewerActivityFragment.this.y().containsKey("mDB")) {
                        EpoDXWebViewerActivityFragment epoDXWebViewerActivityFragment2 = EpoDXWebViewerActivityFragment.this;
                        epoDXWebViewerActivityFragment2.Z4 = epoDXWebViewerActivityFragment2.y().getString("mDB");
                    }
                    EpoDXWebViewerActivityFragment epoDXWebViewerActivityFragment3 = EpoDXWebViewerActivityFragment.this;
                    if (epoDXWebViewerActivityFragment3.Z4 == null) {
                        epoDXWebViewerActivityFragment3.Z4 = "Dx";
                    }
                    CompressHelper compressHelper = epoDXWebViewerActivityFragment3.Q4;
                    Bundle bundle = epoDXWebViewerActivityFragment3.D4;
                    ArrayList<Bundle> V = compressHelper.V(bundle, "Select * from " + EpoDXWebViewerActivityFragment.this.Z4 + "_monographs where id=" + str2);
                    if (V != null) {
                        if (V.size() != 0) {
                            JSONObject jSONObject = new JSONObject(EpoDXWebViewerActivityFragment.this.Q4.B(V.get(0).getString("monograph"), str2, "127"));
                            EpoDXWebViewerActivityFragment epoDXWebViewerActivityFragment4 = EpoDXWebViewerActivityFragment.this;
                            epoDXWebViewerActivityFragment4.Y4 = jSONObject;
                            epoDXWebViewerActivityFragment4.F4 = epoDXWebViewerActivityFragment4.y().getString("Title");
                            EpoDXWebViewerActivityFragment epoDXWebViewerActivityFragment5 = EpoDXWebViewerActivityFragment.this;
                            epoDXWebViewerActivityFragment5.a5 = epoDXWebViewerActivityFragment5.y().getParcelableArrayList("Images");
                            EpoDXWebViewerActivityFragment epoDXWebViewerActivityFragment6 = EpoDXWebViewerActivityFragment.this;
                            String d4 = epoDXWebViewerActivityFragment6.d4(epoDXWebViewerActivityFragment6.r(), "EPOHeader.css");
                            EpoDXWebViewerActivityFragment epoDXWebViewerActivityFragment7 = EpoDXWebViewerActivityFragment.this;
                            String d42 = epoDXWebViewerActivityFragment7.d4(epoDXWebViewerActivityFragment7.r(), "EPOFooter.css");
                            String replace = d4.replace("[size]", "200").replace("[title]", EpoDXWebViewerActivityFragment.this.F4).replace("[include]", "");
                            String replace2 = EpoDXWebViewerActivityFragment.this.y().getString("Html").replace("..", ".");
                            EpoDXWebViewerActivityFragment epoDXWebViewerActivityFragment8 = EpoDXWebViewerActivityFragment.this;
                            epoDXWebViewerActivityFragment8.A4 = replace + replace2 + d42;
                            return;
                        }
                    }
                    EpoDXWebViewerActivityFragment.this.p4 = "Document doesn't exist";
                } catch (Exception e2) {
                    e2.printStackTrace();
                    EpoDXWebViewerActivityFragment.this.p4 = e2.getLocalizedMessage();
                }
            }
        }, new Runnable() {
            public void run() {
                String str = EpoDXWebViewerActivityFragment.this.p4;
                if (str == null || str.length() <= 0) {
                    EpoDXWebViewerActivityFragment epoDXWebViewerActivityFragment = EpoDXWebViewerActivityFragment.this;
                    epoDXWebViewerActivityFragment.O3(epoDXWebViewerActivityFragment.A4, (String) null);
                    EpoDXWebViewerActivityFragment.this.s4();
                    EpoDXWebViewerActivityFragment.this.p4();
                    EpoDXWebViewerActivityFragment.this.f3(R.menu.f1413epolistmenu);
                    EpoDXWebViewerActivityFragment.this.o2(false);
                    EpoDXWebViewerActivityFragment.this.G3();
                    return;
                }
                EpoDXWebViewerActivityFragment epoDXWebViewerActivityFragment2 = EpoDXWebViewerActivityFragment.this;
                epoDXWebViewerActivityFragment2.C4(epoDXWebViewerActivityFragment2.p4);
            }
        });
        return this.C4;
    }

    public boolean e1(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.f799action_gallery) {
            I4("soheilvb");
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
                JSONObject r1 = this.Q4.r1(this.Y4.getJSONArray("views"), "id", this.Q4.t1(StringUtils.splitByWholeSeparator(str3, "//current?view=")));
                if (r1 != null && r1.getString("type").equals("image")) {
                    I4(this.Y4.getJSONArray("media").getJSONObject(Integer.valueOf(r1.getJSONArray("image_refs").getString(0)).intValue()).getString(Annotation.k3));
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
                compressHelper.A1(bundle, "epohtml-" + ("<div style=\"margin:15px\">" + this.Y4.getJSONObject("citations").getJSONArray("articles").getJSONObject(Integer.valueOf(this.Q4.t1(StringUtils.splitByWholeSeparator(str3, "//current?article="))).intValue() - 1).getString(HTML.Tag.y) + "</div>"), (String[]) null, (String) null);
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
