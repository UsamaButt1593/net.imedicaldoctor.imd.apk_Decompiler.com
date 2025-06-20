package net.imedicaldoctor.imd.Fragments.UTDAdvanced;

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
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.Amirsys.ASSectionViewer;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Utils.iMDWebView;
import net.imedicaldoctor.imd.iMDLogger;
import org.apache.commons.lang3.StringUtils;

public class UTDAViewerActivityFragment extends ViewerHelperFragment {
    public Bundle X4;
    public ArrayList<String> Y4;
    public ArrayList<Bundle> Z4;
    public int a5;
    public String b5;

    public void I4(String str, int i2) {
        Bundle bundle = new Bundle();
        bundle.putString("sequence", String.valueOf(i2));
        bundle.putString("label", str);
        this.Z4.add(bundle);
    }

    public String J4() {
        iMDLogger.f("Loading Document", this.E4);
        String[] split = this.E4.split("-");
        this.Z4 = new ArrayList<>();
        this.a5 = 0;
        ArrayList<Bundle> W = this.Q4.W(this.D4, "Select * from pages where post='" + this.b5 + "'", "pathways/" + split[1] + ".db");
        if (W == null || W.size() == 0) {
            CompressHelper.x2(r(), "Document doesn't exist", 1);
            return "";
        }
        this.X4 = W.get(0);
        this.F4 = this.Q4.W(this.D4, "Select * from TOC where id=" + split[1], "pathways.db").get(0).getString("title");
        String string = this.X4.getString("result");
        if (!string.contains("<form")) {
            string = new String(this.Q4.v(string, split[1], "127"));
        }
        String replace = string.replace("jQuery.fn.handleCheckBoxClick(this)", "handleCheckBoxClick(this)");
        String d4 = d4(r(), "UTDAHeader.css");
        String d42 = d4(r(), "UTDAFooter.css");
        return d4.replace("[size]", "200").replace("[title]", this.F4) + replace + d42;
    }

    public String K4(String str) {
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
        try {
            String str = this.A4;
            if (str != null) {
                if (str.length() == 0) {
                }
                String g1 = CompressHelper.g1(this.D4, "base");
                m3();
                O3(this.A4, g1);
                s4();
                p4();
                f3(R.menu.f1411elsviewer2);
                o2(false);
                G3();
                return this.C4;
            }
            this.b5 = "";
            this.A4 = J4();
            String g12 = CompressHelper.g1(this.D4, "base");
            m3();
            O3(this.A4, g12);
            s4();
            p4();
            f3(R.menu.f1411elsviewer2);
            o2(false);
            G3();
        } catch (Exception e2) {
            B4(e2);
        }
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
                            str = K4(str);
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
        } else if (split[0].equals("reload")) {
            this.b5 = split[1];
            this.A4 = J4();
            O3(this.A4, CompressHelper.g1(this.D4, "base"));
        }
        return super.W3(consoleMessage);
    }

    public void Z3(WebView webView, String str) {
        String f2 = CompressHelper.f(this.A4, "<script>", "</script>");
        iMDWebView imdwebview = this.G4;
        imdwebview.g("" + f2);
        this.C4.postDelayed(new Runnable() {
            public void run() {
            }
        }, 1000);
        this.G4.g("jQuery.fn.animateTextViewAnswerChange();");
        this.G4.g("jQuery.fn.addSummaryButtonProperties();");
        this.G4.g("$('table.group').last()[0].scrollIntoView();");
        super.Z3(webView, str);
    }

    public boolean e1(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.f799action_gallery) {
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
            return true;
        }
        iMDLogger.j("Override", "Url : " + str + ", Scheme : " + str2 + ", Resource : " + str3);
        return true;
    }
}
