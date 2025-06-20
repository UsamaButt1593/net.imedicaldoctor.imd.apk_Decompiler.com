package net.imedicaldoctor.imd.Fragments.Epocrate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.itextpdf.tool.xml.html.HTML;
import fi.iki.elonen.NanoHTTPD;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Utils.iMDWebView;

public class EPOHTMLViewerFragment extends ViewerHelperFragment {
    public View U0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.f1285fragment_webview, viewGroup, false);
        this.C4 = inflate;
        this.G4 = (iMDWebView) inflate.findViewById(R.id.f1159webView);
        this.Q4 = new CompressHelper(r());
        this.D4 = y().getBundle("DB");
        String string = y().getString("Type");
        String string2 = y().getString("URL");
        if (string.equals(HTML.Tag.y)) {
            String replace = string2.replace("epohtml-", "");
            try {
                String d4 = d4(r(), "EPOHeader.css");
                String d42 = d4(r(), "EPOFooter.css");
                String replace2 = d4.replace("[size]", "200").replace("[include]", "");
                this.G4.loadData((replace2 + replace + d42).replace("..", "."), NanoHTTPD.p, (String) null);
            } catch (Exception e2) {
                FirebaseCrashlytics.d().g(e2);
                e2.printStackTrace();
            }
        } else {
            if (string.equals("url")) {
                this.G4.loadUrl(string2.replace("epourl-", ""));
            }
            return this.C4;
        }
        s4();
        return this.C4;
    }

    public boolean y4(WebView webView, String str, String str2, String str3) {
        if (!this.Q4.N1(this.D4, str) && str2.equals("http")) {
            CompressHelper compressHelper = this.Q4;
            Bundle bundle = this.D4;
            compressHelper.A1(bundle, "epourl-" + str, (String[]) null, (String) null);
        }
        return true;
    }
}
