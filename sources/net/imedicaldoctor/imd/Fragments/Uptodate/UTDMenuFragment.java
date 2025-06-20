package net.imedicaldoctor.imd.Fragments.Uptodate;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.itextpdf.tool.xml.html.HTML;
import fi.iki.elonen.NanoHTTPD;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import net.imedicaldoctor.imd.Fragments.Uptodate.UTDViewerActivity;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.iMDLogger;
import org.apache.commons.lang3.StringUtils;

public class UTDMenuFragment extends DialogFragment {
    private static String g3(Context context, String str) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(str), StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb.append(readLine + StringUtils.LF);
            } else {
                bufferedReader.close();
                return sb.toString();
            }
        }
    }

    public Dialog U2(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(r());
        View inflate = r().getLayoutInflater().inflate(R.layout.f1273fragment_utdmenu, (ViewGroup) null);
        WebView webView = (WebView) inflate.findViewById(R.id.f1160webview);
        try {
            String string = y().getString(HTML.Tag.y);
            String g3 = g3(r(), "UTDHeader.css");
            String g32 = g3(r(), "UTDFooter.css");
            webView.setWebViewClient(new WebViewClient() {
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    iMDLogger.j("MenuFragment", str);
                    ((UTDViewerActivity.UTDViewerFragment) UTDMenuFragment.this.l0()).T4(str);
                    UTDMenuFragment.this.M2();
                    return true;
                }
            });
            webView.getSettings().setAllowFileAccess(true);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadDataWithBaseURL("file:///android_asset/", g3.replace("[size]", "200").replace("[Title]", y().getString("title")) + string + g32, NanoHTTPD.p, "utf-8", (String) null);
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            iMDLogger.f("Error in MenuFragment", e2.toString());
        }
        builder.setView(inflate);
        return builder.create();
    }
}
