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

public class MMViewerActivityFragment extends ViewerHelperFragment {
    public Bundle X4;
    public ArrayList<String> Y4;
    public ArrayList<Bundle> Z4;
    public int a5;
    public boolean b5;

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

    public View U0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.C4;
        if (view != null) {
            return view;
        }
        View inflate = layoutInflater.inflate(R.layout.f1255fragment_new_viewer, viewGroup, false);
        this.C4 = inflate;
        this.b5 = true;
        r4(inflate, bundle);
        if (y() == null) {
            return this.C4;
        }
        T2(new Runnable() {
            public void run() {
                try {
                    String str = MMViewerActivityFragment.this.A4;
                    if (str != null) {
                        if (str.length() == 0) {
                        }
                        MMViewerActivityFragment.this.m3();
                        return;
                    }
                    iMDLogger.f("Loading Document", MMViewerActivityFragment.this.E4);
                    MMViewerActivityFragment mMViewerActivityFragment = MMViewerActivityFragment.this;
                    ArrayList<Bundle> V = mMViewerActivityFragment.Q4.V(mMViewerActivityFragment.D4, "Select * from drug_idx where drug_id=" + MMViewerActivityFragment.this.E4 + " and has_generic=0");
                    if (V != null) {
                        if (V.size() != 0) {
                            MMViewerActivityFragment.this.Z4 = new ArrayList<>();
                            MMViewerActivityFragment mMViewerActivityFragment2 = MMViewerActivityFragment.this;
                            mMViewerActivityFragment2.a5 = 0;
                            mMViewerActivityFragment2.X4 = V.get(0);
                            MMViewerActivityFragment mMViewerActivityFragment3 = MMViewerActivityFragment.this;
                            mMViewerActivityFragment3.F4 = mMViewerActivityFragment3.X4.getString("title");
                            MMViewerActivityFragment mMViewerActivityFragment4 = MMViewerActivityFragment.this;
                            ArrayList<Bundle> V2 = mMViewerActivityFragment4.Q4.V(mMViewerActivityFragment4.D4, "select drug_section.title as sectionTitle, drug_sub_section.title as subSectionTitle, monograph from (drug_mono inner join drug_sub_section on drug_sub_section.sub_section_id=drug_mono.sub_section_id) inner join drug_section on drug_section.section_id=drug_sub_section.section_id where drug_id=" + MMViewerActivityFragment.this.E4 + " AND monograph<>'' AND drug_section.section_id<>0 order by drug_section.section_id, drug_sub_section.sub_section_id");
                            if (V2 == null) {
                                V2 = new ArrayList<>();
                            }
                            Iterator<Bundle> it2 = V2.iterator();
                            String str2 = "";
                            String str3 = str2;
                            String str4 = str3;
                            while (it2.hasNext()) {
                                Bundle next = it2.next();
                                String string = next.getString("sectionTitle");
                                String string2 = next.getString("subSectionTitle");
                                String string3 = next.getString("monograph");
                                if (!string.equals(str4)) {
                                    if (str3.length() > 0) {
                                        str2 = str2 + MMViewerActivityFragment.this.L4(str4, "", "LTR", str3, "", "", "");
                                        MMViewerActivityFragment mMViewerActivityFragment5 = MMViewerActivityFragment.this;
                                        mMViewerActivityFragment5.I4(str4, mMViewerActivityFragment5.a5);
                                    }
                                    str3 = "";
                                    str4 = string;
                                }
                                str3 = str3 + MMViewerActivityFragment.this.M4(string2, "", "", string3, "", "margin-left:15px", "");
                            }
                            if (str3.length() > 0) {
                                str2 = str2 + MMViewerActivityFragment.this.L4(str4, "", "LTR", str3, "", "", "");
                                MMViewerActivityFragment mMViewerActivityFragment6 = MMViewerActivityFragment.this;
                                mMViewerActivityFragment6.I4(str4, mMViewerActivityFragment6.a5);
                            }
                            MMViewerActivityFragment mMViewerActivityFragment7 = MMViewerActivityFragment.this;
                            String d4 = mMViewerActivityFragment7.d4(mMViewerActivityFragment7.r(), "MMHeader.css");
                            MMViewerActivityFragment mMViewerActivityFragment8 = MMViewerActivityFragment.this;
                            String d42 = mMViewerActivityFragment8.d4(mMViewerActivityFragment8.r(), "MMFooter.css");
                            String replace = d4.replace("[size]", "200").replace("[title]", MMViewerActivityFragment.this.F4).replace("[include]", "");
                            MMViewerActivityFragment.this.A4 = replace + str2 + d42;
                            MMViewerActivityFragment.this.m3();
                            return;
                        }
                    }
                    MMViewerActivityFragment.this.p4 = "Document doesn't exist";
                } catch (Exception e2) {
                    e2.printStackTrace();
                    MMViewerActivityFragment.this.p4 = e2.getLocalizedMessage();
                }
            }
        }, new Runnable() {
            public void run() {
                String str = MMViewerActivityFragment.this.p4;
                if (str == null || str.length() <= 0) {
                    String g1 = CompressHelper.g1(MMViewerActivityFragment.this.D4, "base");
                    MMViewerActivityFragment mMViewerActivityFragment = MMViewerActivityFragment.this;
                    mMViewerActivityFragment.O3(mMViewerActivityFragment.A4, g1);
                    MMViewerActivityFragment.this.s4();
                    MMViewerActivityFragment.this.p4();
                    MMViewerActivityFragment.this.f3(R.menu.f1411elsviewer2);
                    MMViewerActivityFragment.this.o2(false);
                    MMViewerActivityFragment.this.G3();
                    return;
                }
                MMViewerActivityFragment mMViewerActivityFragment2 = MMViewerActivityFragment.this;
                mMViewerActivityFragment2.C4(mMViewerActivityFragment2.p4);
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
