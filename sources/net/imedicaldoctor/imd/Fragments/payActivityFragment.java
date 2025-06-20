package net.imedicaldoctor.imd.Fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.media3.extractor.ts.TsExtractor;
import com.google.common.net.HttpHeaders;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Map;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Utils.iMDWebView;
import net.imedicaldoctor.imd.VBHelper;
import net.imedicaldoctor.imd.Views.ProgressBarCircularIndeterminate;
import net.imedicaldoctor.imd.iMDLogger;

public class payActivityFragment extends Fragment {
    /* access modifiers changed from: private */
    public View e4;
    /* access modifiers changed from: private */
    public iMDWebView f4;
    private boolean g4;
    /* access modifiers changed from: private */
    public boolean h4;
    private WebResourceRequest i4;
    private ProgressBarCircularIndeterminate j4;

    /* access modifiers changed from: private */
    public void N2() {
        this.j4.setVisibility(8);
    }

    private void P2() {
        this.j4.setBackgroundColor(Color.parseColor("#1e88e5"));
        this.j4.setVisibility(0);
    }

    public WebResourceResponse O2(WebView webView, WebResourceRequest webResourceRequest) {
        String uri = webResourceRequest.getUrl().toString();
        if (this.g4) {
            return null;
        }
        try {
            Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
            if (requestHeaders.get(HttpHeaders.f22875c) == null) {
                return null;
            }
            if (requestHeaders.get(HttpHeaders.f22875c).contains("x-www-form-urlencoded") && requestHeaders.containsKey(HttpHeaders.F) && requestHeaders.get(HttpHeaders.F).contains("shaparak")) {
                this.g4 = true;
                this.h4 = false;
                this.i4 = webResourceRequest;
                r().runOnUiThread(new Runnable() {
                    public void run() {
                        VBHelper vBHelper = new VBHelper(payActivityFragment.this.r());
                        iMDWebView L2 = payActivityFragment.this.f4;
                        L2.g("" + vBHelper.decryptHexEncodedStringForKey(vBHelper.decryptHexEncodedStringForKey("2204F7542EDADE86DEC73251369885B8A241E7692D1BA9FC430D497DAD9FA92BCB875485C0C7C870F709A03B18FA69D195F6BB98332699C8497AD7FE77E43D8E9BC1E3BC9596D7130F58CC3FE3DCA77B89865653F7F54C54B9368A3DD07B5E478F9FFA72F3264AD6BEFA58190B571E3546E6C387AF72DA96CAB58446AAEF93931BC8195BD517535791DD314AC24F788D8B2CA46D641B0B9897231B8296D392B83DCC9F577080522A7E79BC7568B38A5558CDE2F315A7FBD1E2F06520F77AAF3E916655590623C0D447DB5E4E08992EC822DC267673EEEBAEE6B8ACD0A9BC2E7D3DB2A6A5B8834CF19AFA2E0172238EF9CFCEFADE51BC6687C0F6C8174D886C05EB08F3061A888EF9F89CC72A08CAF6C43C9324422B89F6DA736628BC8253698B096D1A38F0942F22C54CB0A39F3EEA02883A563F05EC778800CBA65EA4687F8AF45E927CB8893A27EE9D7BCDCD55E2E2466E7F833301219F5D24C0C369FE5E3ACD7067251C26AB51D7989DBD78DCE47291E136B032176B6FD77562218B98AF1E291AAFBB373826EBE57340BB07BBF1A8")));
                        payActivityFragment.this.f4.postDelayed(new Runnable() {
                            public void run() {
                                boolean unused = payActivityFragment.this.h4 = true;
                            }
                        }, 100);
                    }
                });
                while (!this.h4) {
                    iMDLogger.f("Wait", "waiting ...");
                }
            }
            iMDLogger.f("URL", uri + ", Method : " + webResourceRequest.getRequestHeaders().toString());
            return null;
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            iMDLogger.f("Exeption", e2.getLocalizedMessage());
        }
    }

    @Nullable
    public View onFragmentBind(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.e4;
        if (view != null) {
            return view;
        }
        this.e4 = layoutInflater.inflate(R.layout.f1260fragment_pay, viewGroup, false);
        AppCompatActivity appCompatActivity = (AppCompatActivity) r();
        this.j4 = (ProgressBarCircularIndeterminate) this.e4.findViewById(R.id.f1043progress_bar);
        ActionBar F0 = ((AppCompatActivity) r()).F0();
        F0.Y(true);
        this.f4 = (iMDWebView) this.e4.findViewById(R.id.f1159webView);
        CompressHelper compressHelper = new CompressHelper(r());
        VBHelper vBHelper = new VBHelper(r());
        this.f4.getSettings().setAllowContentAccess(true);
        this.f4.getSettings().setAllowFileAccess(true);
        this.f4.getSettings().setDomStorageEnabled(true);
        this.f4.getSettings().setJavaScriptEnabled(true);
        this.f4.getSettings().setUseWideViewPort(true);
        this.f4.setWebChromeClient(new WebChromeClient() {
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                iMDLogger.f("Console", consoleMessage.message());
                String message = consoleMessage.message();
                if (message.contains("a,,,")) {
                    boolean unused = payActivityFragment.this.h4 = true;
                    String n2 = new VBHelper(payActivityFragment.this.r()).encodeActivationCodeToHex(new VBHelper(payActivityFragment.this.r()).encodeActivationCodeToHex(message.replace("a,,,", "")));
                    CompressHelper compressHelper = new CompressHelper(payActivityFragment.this.r());
                    payActivityFragment payactivityfragment = payActivityFragment.this;
                    compressHelper.I0(payactivityfragment, compressHelper.o0("addBuy|||||" + new VBHelper(payActivityFragment.this.r()).m() + "|||||" + n2)).f6(new Consumer<String>() {
                        /* renamed from: a */
                        public void accept(String str) throws Throwable {
                        }
                    }, new Consumer<Throwable>() {
                        /* renamed from: a */
                        public void accept(Throwable th) throws Throwable {
                        }
                    }, new Action() {
                        public void run() throws Throwable {
                        }
                    });
                }
                return super.onConsoleMessage(consoleMessage);
            }
        });
        this.f4.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView webView, String str) {
                iMDLogger.f("WEEB", "Finished " + str);
                payActivityFragment.this.N2();
                payActivityFragment.this.f4.requestFocus(TsExtractor.L);
            }

            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                iMDLogger.f("WEEB", "Started " + str);
            }

            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                WebResourceResponse O2 = payActivityFragment.this.O2(webView, webResourceRequest);
                return O2 != null ? O2 : super.shouldInterceptRequest(webView, webResourceRequest);
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                iMDLogger.j("WEEB", "Override : " + str);
                Uri parse = Uri.parse(str);
                String scheme = parse.getScheme();
                String schemeSpecificPart = parse.getSchemeSpecificPart();
                iMDLogger.j("Pay", "Scheme : " + scheme + ", Resource : " + schemeSpecificPart);
                if (!schemeSpecificPart.contains("//imedicaldoctor.net/confirmaaip.php?command=") && !schemeSpecificPart.contains("//imedicaldoctor.net/confirmaip.php")) {
                    return false;
                }
                CompressHelper.x2(payActivityFragment.this.r(), "Please wait 10 second", 1);
                payActivityFragment.this.f4.setVisibility(4);
                payActivityFragment.this.e4.postDelayed(new Runnable() {
                    public void run() {
                        payActivityFragment.this.N2();
                        Intent intent = new Intent();
                        intent.putExtra("result", 1);
                        if (payActivityFragment.this.r() != null) {
                            payActivityFragment.this.r().setResult(1, intent);
                            payActivityFragment.this.r().finish();
                            payActivityFragment.this.r().overridePendingTransition(R.anim.f23to_fade_in, R.anim.f24to_fade_out);
                        }
                    }
                }, 10000);
                return false;
            }

            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                return super.shouldInterceptRequest(webView, str);
            }
        });
        String string = y().getString("Type");
        if (string.equals("account")) {
            F0.A0("Buying Account");
            String string2 = y().getString("AccountCommand");
            iMDWebView imdwebview = this.f4;
            imdwebview.postUrl(compressHelper.getBaseUrl() + "/buyaaip.php", ("command=" + vBHelper.encodeActivationCodeToHex(string2)).getBytes());
        } else if (string.equals("credit")) {
            F0.A0("Buying " + y().getString("Price") + " Toman Credit");
            this.f4.loadUrl(compressHelper.getBaseUrl() + "/buyaip.php?user=" + vBHelper.m() + "&price=" + y().getString("Price"));
        }
        this.f4.requestFocus(TsExtractor.L);
        P2();
        return this.e4;
    }
}
