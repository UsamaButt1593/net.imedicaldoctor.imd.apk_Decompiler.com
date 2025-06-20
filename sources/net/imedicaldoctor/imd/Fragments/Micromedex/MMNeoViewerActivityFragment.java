package net.imedicaldoctor.imd.Fragments.Micromedex;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.WebView;
import androidx.media3.exoplayer.ExoPlayer;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.Amirsys.ASSectionViewer;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.Gallery.GalleryActivity;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.iMDLogger;
import org.apache.commons.lang3.StringUtils;

public class MMNeoViewerActivityFragment extends ViewerHelperFragment {
    public Bundle X4;
    public ArrayList<String> Y4;
    public ArrayList<Bundle> Z4;
    public int a5;

    private void O4(String str) {
        ArrayList<String> arrayList = this.Y4;
        if (arrayList == null || arrayList.size() == 0) {
            CompressHelper.x2(r(), "There is no images in this document", 1);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<String> it2 = this.Y4.iterator();
        while (it2.hasNext()) {
            String next = it2.next();
            Bundle bundle = new Bundle();
            bundle.putString("ImagePath", next);
            bundle.putString("Description", "");
            bundle.putString("id", next);
            if (new File(next).length() > 5000) {
                arrayList2.add(bundle);
            }
        }
        int i2 = 0;
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            if (str.contains(((Bundle) arrayList2.get(i3)).getString("id"))) {
                i2 = i3;
            }
        }
        Intent intent = new Intent(r(), GalleryActivity.class);
        intent.putExtra("Images", arrayList2);
        intent.putExtra("Start", i2);
        D2(intent);
    }

    public void I4(String str, int i2) {
        Bundle bundle = new Bundle();
        bundle.putString("sequence", String.valueOf(i2));
        bundle.putString("label", str);
        this.Z4.add(bundle);
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

    public String L4(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int i2 = this.a5 + 1;
        this.a5 = i2;
        String valueOf = String.valueOf(i2);
        return "<a name=\"f" + valueOf + "\"><div id=\"h" + valueOf + "\" class=\"headerExpanded\"  DIR=\"" + str3 + "\" onclick=\"collapse(f" + valueOf + ");toggleHeaderExpanded(h" + valueOf + ");\"><span class=\"fieldname\" style=\"font-family:" + str2 + ";\">" + str + "</span></div></a><div class=\"content\" DIR=\"" + str7 + "\" id=\"f" + valueOf + "\" style=\"font-family:" + str5 + "; " + str6 + "\">" + str4 + "</div>";
    }

    public String M4(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int i2 = this.a5 + 1;
        this.a5 = i2;
        String valueOf = String.valueOf(i2);
        return "<a name=\"f" + valueOf + "\"><div id=\"h" + valueOf + "\" class=\"headerExpanded2\"  DIR=\"" + str3 + "\" onclick=\"collapse(f" + valueOf + ");toggleHeaderExpanded2(h" + valueOf + ");\"><span class=\"fieldname\" style=\"font-family:" + str2 + ";\">" + str + "</span></div></a><div class=\"content\" DIR=\"" + str7 + "\" id=\"f" + valueOf + "\" style=\"font-family:" + str5 + "; " + str6 + "\">" + str4 + "</div>";
    }

    public String N4(String str) {
        ArrayList arrayList = new ArrayList(Arrays.asList(StringUtils.splitByWholeSeparator(str, "/")));
        arrayList.remove(arrayList.size() - 1);
        return StringUtils.join((Iterable<?>) arrayList, "/");
    }

    public String R2() {
        return w3(this.Y4);
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
                try {
                    String str2 = MMNeoViewerActivityFragment.this.A4;
                    if (str2 != null) {
                        if (str2.length() == 0) {
                        }
                        MMNeoViewerActivityFragment.this.m3();
                    }
                    iMDLogger.f("Loading Document", MMNeoViewerActivityFragment.this.E4);
                    String[] split = MMNeoViewerActivityFragment.this.E4.split("-");
                    MMNeoViewerActivityFragment.this.Z4 = new ArrayList<>();
                    MMNeoViewerActivityFragment.this.a5 = 0;
                    if (split[0].equals("drug")) {
                        MMNeoViewerActivityFragment mMNeoViewerActivityFragment = MMNeoViewerActivityFragment.this;
                        ArrayList<Bundle> V = mMNeoViewerActivityFragment.Q4.V(mMNeoViewerActivityFragment.D4, "Select * from drug_idx where drug_id=" + split[1] + " and has_generic=0");
                        if (V != null) {
                            if (V.size() != 0) {
                                MMNeoViewerActivityFragment.this.X4 = V.get(0);
                                MMNeoViewerActivityFragment mMNeoViewerActivityFragment2 = MMNeoViewerActivityFragment.this;
                                mMNeoViewerActivityFragment2.F4 = mMNeoViewerActivityFragment2.X4.getString("name");
                                MMNeoViewerActivityFragment mMNeoViewerActivityFragment3 = MMNeoViewerActivityFragment.this;
                                ArrayList<Bundle> V2 = mMNeoViewerActivityFragment3.Q4.V(mMNeoViewerActivityFragment3.D4, "select drug_section.title as sectionTitle, drug_sub_section.title as subSectionTitle, monograph from (drug_mono inner join drug_sub_section on drug_sub_section.sub_section_id=drug_mono.sub_section_id) inner join drug_section on drug_section.section_id=drug_sub_section.section_id where drug_id=" + split[1] + " AND monograph<>'' AND drug_section.section_id<>0 order by drug_section.section_id, drug_sub_section.sub_section_id");
                                if (V2 == null) {
                                    V2 = new ArrayList<>();
                                }
                                Iterator<Bundle> it2 = V2.iterator();
                                str = "";
                                while (it2.hasNext()) {
                                    Bundle next = it2.next();
                                    str = str + MMNeoViewerActivityFragment.this.L4(next.getString("sectionTitle"), "", "LTR", next.getString("monograph"), "", "margin-left:10px;margin-top:5px", "");
                                    MMNeoViewerActivityFragment.this.I4(next.getString("sectionTitle"), MMNeoViewerActivityFragment.this.a5);
                                }
                            }
                        }
                        MMNeoViewerActivityFragment.this.p4 = "Document doesn't exist";
                        return;
                    } else if (split[0].equals("formula")) {
                        MMNeoViewerActivityFragment mMNeoViewerActivityFragment4 = MMNeoViewerActivityFragment.this;
                        ArrayList<Bundle> V3 = mMNeoViewerActivityFragment4.Q4.V(mMNeoViewerActivityFragment4.D4, "Select * from formula_idx where formula_id=" + split[1]);
                        if (V3 != null) {
                            if (V3.size() != 0) {
                                MMNeoViewerActivityFragment.this.X4 = V3.get(0);
                                MMNeoViewerActivityFragment mMNeoViewerActivityFragment5 = MMNeoViewerActivityFragment.this;
                                mMNeoViewerActivityFragment5.F4 = mMNeoViewerActivityFragment5.X4.getString("title");
                                MMNeoViewerActivityFragment mMNeoViewerActivityFragment6 = MMNeoViewerActivityFragment.this;
                                ArrayList<Bundle> V4 = mMNeoViewerActivityFragment6.Q4.V(mMNeoViewerActivityFragment6.D4, "SELECT (  CASE WHEN (fs.sorter = 0) THEN '<th>'  WHEN (fs.sorter % 2 != 0) THEN '<tr class=\"\"odd\"\"><td>'   ELSE '<tr><td>' END ||   fs.value ||   CASE WHEN (fs.sorter = 0) THEN '</th><th>' ELSE '</td><td>' END || (CASE WHEN (ft.per_100_cal_value = '') THEN '&nbsp;' ELSE ft.per_100_cal_value END) || CASE WHEN (fs.sorter = 0) THEN '</th><th>' ELSE '</td><td>' END || (CASE WHEN (ft.per_liter_value = '') THEN '&nbsp;' ELSE ft.per_liter_value END) || CASE WHEN (fs.sorter = 0) THEN '</th>'  ELSE '</td></tr>' END  ) formatted_formula_data FROM formula_table ft, formula_section fs WHERE formula_id = " + split[1] + " AND ft.section_id = fs.section_id ORDER BY fs.sorter");
                                MMNeoViewerActivityFragment mMNeoViewerActivityFragment7 = MMNeoViewerActivityFragment.this;
                                ArrayList<Bundle> V5 = mMNeoViewerActivityFragment7.Q4.V(mMNeoViewerActivityFragment7.D4, "SELECT ((CASE note_id WHEN 5 THEN X'e280a0' || ' Protein Source: ' WHEN 6 THEN X'e280a1' || ' Fat Source: ' WHEN 7 THEN X'c2a7' || ' Carbohydrate Source: ' ELSE '' END) || value) as formatted_product_note FROM product_notes WHERE formula_id = " + split[1] + "  AND note_id != 1 ORDER BY note_id");
                                Iterator<Bundle> it3 = V4.iterator();
                                String str3 = "";
                                while (it3.hasNext()) {
                                    str3 = str3 + it3.next().getString("formatted_formula_data");
                                }
                                String str4 = "<table>" + str3 + "</table>";
                                Iterator<Bundle> it4 = V5.iterator();
                                String str5 = "";
                                while (it4.hasNext()) {
                                    str5 = str5 + it4.next().getString("formatted_product_note");
                                }
                                MMNeoViewerActivityFragment mMNeoViewerActivityFragment8 = MMNeoViewerActivityFragment.this;
                                mMNeoViewerActivityFragment8.I4("Table", mMNeoViewerActivityFragment8.a5);
                                str = ("" + MMNeoViewerActivityFragment.this.L4("Table", "", "LTR", str4, "", "margin-left:10px;margin-top:5px", "")) + MMNeoViewerActivityFragment.this.L4("Product Notes", "", "LTR", str5, "", "margin-left:10px;margin-top:5px", "");
                                MMNeoViewerActivityFragment mMNeoViewerActivityFragment9 = MMNeoViewerActivityFragment.this;
                                mMNeoViewerActivityFragment9.I4("Product Notes", mMNeoViewerActivityFragment9.a5);
                            }
                        }
                        MMNeoViewerActivityFragment.this.p4 = "Document doesn't exist";
                        return;
                    } else {
                        str = "";
                    }
                    MMNeoViewerActivityFragment mMNeoViewerActivityFragment10 = MMNeoViewerActivityFragment.this;
                    String d4 = mMNeoViewerActivityFragment10.d4(mMNeoViewerActivityFragment10.r(), "MMHeader.css");
                    MMNeoViewerActivityFragment mMNeoViewerActivityFragment11 = MMNeoViewerActivityFragment.this;
                    String d42 = mMNeoViewerActivityFragment11.d4(mMNeoViewerActivityFragment11.r(), "MMFooter.css");
                    String replace = d4.replace("[size]", "200").replace("[title]", MMNeoViewerActivityFragment.this.F4).replace("[include]", "");
                    MMNeoViewerActivityFragment.this.A4 = replace + str + d42;
                    MMNeoViewerActivityFragment.this.m3();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    MMNeoViewerActivityFragment.this.p4 = e2.getLocalizedMessage();
                }
            }
        }, new Runnable() {
            public void run() {
                String str = MMNeoViewerActivityFragment.this.p4;
                if (str == null || str.length() <= 0) {
                    String g1 = CompressHelper.g1(MMNeoViewerActivityFragment.this.D4, "base");
                    MMNeoViewerActivityFragment mMNeoViewerActivityFragment = MMNeoViewerActivityFragment.this;
                    mMNeoViewerActivityFragment.O3(mMNeoViewerActivityFragment.A4, g1);
                    MMNeoViewerActivityFragment.this.s4();
                    MMNeoViewerActivityFragment.this.p4();
                    MMNeoViewerActivityFragment.this.f3(R.menu.f1411elsviewer2);
                    MMNeoViewerActivityFragment.this.o2(false);
                    MMNeoViewerActivityFragment.this.G3();
                    return;
                }
                MMNeoViewerActivityFragment mMNeoViewerActivityFragment2 = MMNeoViewerActivityFragment.this;
                mMNeoViewerActivityFragment2.C4(mMNeoViewerActivityFragment2.p4);
            }
        });
        return this.C4;
    }

    public boolean W3(ConsoleMessage consoleMessage) {
        String str;
        String[] split = consoleMessage.message().split(",,,,,");
        String g1 = CompressHelper.g1(this.D4, "base");
        if (split[0].equals("images")) {
            if (split.length < 2) {
                return true;
            }
            String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(split[1], "|");
            ArrayList<String> arrayList = new ArrayList<>();
            for (String str2 : splitByWholeSeparator) {
                if (str2.contains("/")) {
                    String replace = g1.replace("file://", "");
                    str = replace.substring(0, replace.length() - 1);
                    for (String str3 : StringUtils.splitByWholeSeparator(str2, "/")) {
                        if (str3.equals("..")) {
                            str = N4(str);
                        } else {
                            str = str + "/" + str3;
                        }
                    }
                } else {
                    str = g1 + "/" + str2;
                }
                if (new File(str).length() > ExoPlayer.a1) {
                    arrayList.add(str);
                }
                iMDLogger.j("EPUB Images", "Imagepath = : " + str);
            }
            this.Y4 = arrayList;
            o4();
        }
        return super.W3(consoleMessage);
    }

    public void Z3(WebView webView, String str) {
        this.G4.g("ConvertAllImages();");
        this.G4.g("console.log(\"images,,,,,\" + getImageList());");
        super.Z3(webView, str);
    }

    public boolean e1(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.f799action_gallery) {
            O4("asdfafdsaf");
            return true;
        }
        if (itemId == R.id.f801action_menu) {
            ASSectionViewer aSSectionViewer = new ASSectionViewer();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("Items", this.Z4);
            bundle.putString("TitleProperty", "label");
            aSSectionViewer.A2(this, 0);
            aSSectionViewer.i2(bundle);
            aSSectionViewer.Z2(true);
            aSSectionViewer.e3(M(), "asdfasdfasdf");
        }
        return super.e1(menuItem);
    }

    public boolean y4(WebView webView, String str, String str2, String str3) {
        if (str2.equals("image")) {
            O4(str3);
            return true;
        }
        iMDLogger.j("Override", "Url : " + str + ", Scheme : " + str2 + ", Resource : " + str3);
        return true;
    }
}
