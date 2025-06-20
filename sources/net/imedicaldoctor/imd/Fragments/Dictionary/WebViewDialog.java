package net.imedicaldoctor.imd.Fragments.Dictionary;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import fi.iki.elonen.NanoHTTPD;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.iMDLogger;

public class WebViewDialog extends DialogFragment {
    private Bundle F4;
    private View G4;

    public Dialog U2(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(r());
        View inflate = r().getLayoutInflater().inflate(R.layout.f1234fragment_general_viewer, (ViewGroup) null);
        this.G4 = inflate;
        WebView webView = (WebView) inflate.findViewById(R.id.f1159webView);
        this.F4 = y().getBundle("db");
        if (y().containsKey("url")) {
            webView.loadUrl(y().getString("url"));
        } else {
            webView.loadDataWithBaseURL(y().getString("baseURL"), y().getString("htmlString"), NanoHTTPD.p, "utf-8", (String) null);
        }
        webView.getSettings().setAllowFileAccess(true);
        webView.setWebChromeClient(new WebChromeClient() {
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                iMDLogger.f("DialogConsole", consoleMessage.message());
                return true;
            }
        });
        webView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return false;
            }
        });
        builder.setView(inflate);
        return builder.create();
    }

    public void onFragmentCreated(View view, Bundle bundle) {
        super.onFragmentCreated(view, bundle);
        ((WebView) this.G4.findViewById(R.id.f1159webView)).loadUrl(y().getString("url"));
    }
}
