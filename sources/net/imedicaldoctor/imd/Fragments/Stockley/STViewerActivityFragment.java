package net.imedicaldoctor.imd.Fragments.Stockley;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.WebView;
import androidx.media3.exoplayer.ExoPlayer;
import com.itextpdf.text.Annotation;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.Gallery.GalleryActivity;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.iMDLogger;
import org.apache.commons.lang3.StringUtils;

public class STViewerActivityFragment extends ViewerHelperFragment {
    public Bundle X4;
    public ArrayList<String> Y4;
    public ArrayList<Bundle> Z4;

    private void J4(String str) {
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

    public String I4(String str) {
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
                try {
                    String str = STViewerActivityFragment.this.A4;
                    if (str != null) {
                        if (str.length() == 0) {
                        }
                        STViewerActivityFragment.this.m3();
                        return;
                    }
                    iMDLogger.f("Loading Document", STViewerActivityFragment.this.E4);
                    STViewerActivityFragment sTViewerActivityFragment = STViewerActivityFragment.this;
                    CompressHelper compressHelper = sTViewerActivityFragment.Q4;
                    Bundle bundle = sTViewerActivityFragment.D4;
                    ArrayList<Bundle> V = compressHelper.V(bundle, "Select * from docs where docName='" + STViewerActivityFragment.this.E4 + "'");
                    if (V != null) {
                        if (V.size() != 0) {
                            STViewerActivityFragment.this.X4 = V.get(0);
                            STViewerActivityFragment sTViewerActivityFragment2 = STViewerActivityFragment.this;
                            sTViewerActivityFragment2.F4 = sTViewerActivityFragment2.X4.getString("title");
                            STViewerActivityFragment sTViewerActivityFragment3 = STViewerActivityFragment.this;
                            String B = sTViewerActivityFragment3.Q4.B(sTViewerActivityFragment3.X4.getString(Annotation.i3), STViewerActivityFragment.this.E4, "127");
                            STViewerActivityFragment sTViewerActivityFragment4 = STViewerActivityFragment.this;
                            String d4 = sTViewerActivityFragment4.d4(sTViewerActivityFragment4.r(), "STHeader.css");
                            STViewerActivityFragment sTViewerActivityFragment5 = STViewerActivityFragment.this;
                            String d42 = sTViewerActivityFragment5.d4(sTViewerActivityFragment5.r(), "STFooter.css");
                            String replace = d4.replace("[size]", "200").replace("[title]", STViewerActivityFragment.this.F4).replace("[include]", "");
                            STViewerActivityFragment sTViewerActivityFragment6 = STViewerActivityFragment.this;
                            sTViewerActivityFragment6.A4 = replace + B + d42;
                            STViewerActivityFragment.this.m3();
                            return;
                        }
                    }
                    STViewerActivityFragment.this.p4 = "Document doesn't exist";
                } catch (Exception e2) {
                    e2.printStackTrace();
                    STViewerActivityFragment.this.p4 = e2.getLocalizedMessage();
                }
            }
        }, new Runnable() {
            public void run() {
                String str = STViewerActivityFragment.this.p4;
                if (str == null || str.length() <= 0) {
                    STViewerActivityFragment sTViewerActivityFragment = STViewerActivityFragment.this;
                    sTViewerActivityFragment.O3(sTViewerActivityFragment.A4, STViewerActivityFragment.this.D4.getString("Path") + "/base");
                    STViewerActivityFragment.this.s4();
                    STViewerActivityFragment.this.p4();
                    STViewerActivityFragment.this.f3(R.menu.f1411elsviewer2);
                    STViewerActivityFragment.this.o2(false);
                    STViewerActivityFragment.this.G3();
                    return;
                }
                STViewerActivityFragment sTViewerActivityFragment2 = STViewerActivityFragment.this;
                sTViewerActivityFragment2.C4(sTViewerActivityFragment2.p4);
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
                            str = I4(str);
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
        this.G4.g("onBodyLoad();");
        super.Z3(webView, str);
    }

    public boolean e1(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.f799action_gallery) {
            return super.e1(menuItem);
        }
        J4("asdfafdsaf");
        return true;
    }

    public void e3(Menu menu) {
        menu.removeItem(R.id.f801action_menu);
    }

    public boolean y4(WebView webView, String str, String str2, String str3) {
        String str4;
        if (str2.equals("image")) {
            J4(str3);
            return true;
        }
        if (str2.equals(Annotation.k3) || (str2.equals("http") && str3.contains("localhost:"))) {
            String str5 = "//" + CompressHelper.g1(this.D4, "base") + "/";
            if (str3.contains("#")) {
                String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(str3, "#");
                String str6 = splitByWholeSeparator[0];
                String str7 = splitByWholeSeparator[1];
                String replace = str6.replace(str5, "").replace(".html", "");
                if (this.X4.getString("docName").equalsIgnoreCase(replace)) {
                    this.G4.g("window.location.href = \"#" + str7 + "\"");
                    return true;
                } else if (replace.length() == 0) {
                    this.G4.g("window.location.href = \"#" + str7 + "\"");
                    return true;
                } else if (replace.endsWith("/")) {
                    this.G4.g("window.location.href = \"#" + str7 + "\"");
                    return true;
                } else {
                    str4 = str7;
                    str3 = replace;
                }
            } else {
                str4 = "";
            }
            String replace2 = str3.replace(str5, "");
            if (replace2.length() == 0) {
                return true;
            }
            str3 = replace2.toLowerCase();
            CompressHelper compressHelper = this.Q4;
            if (compressHelper.s1(compressHelper.V(this.D4, "select * from docs where docName='" + str3 + "'")) == null) {
                CompressHelper.x2(r(), "Sorry, not in this book", 1);
            } else {
                this.Q4.A1(this.D4, str3, (String[]) null, str4);
            }
        }
        iMDLogger.j("Override", "Url : " + str + ", Scheme : " + str2 + ", Resource : " + str3);
        return true;
    }
}
