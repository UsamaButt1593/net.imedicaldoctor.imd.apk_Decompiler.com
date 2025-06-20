package net.imedicaldoctor.imd.Fragments.mksap;

import android.os.Bundle;
import android.view.Menu;
import android.webkit.ConsoleMessage;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.media3.common.C;
import com.itextpdf.text.Annotation;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.iMDLogger;
import org.apache.commons.lang3.StringUtils;

public class MKSAPActivityFragment extends ViewerHelperFragment {
    public boolean X4;
    public String Y4;

    public Boolean J4() {
        return Boolean.valueOf(!this.D4.getString("Name").toLowerCase().contains("mksap17"));
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x011d A[Catch:{ Exception -> 0x0057 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x017c A[Catch:{ Exception -> 0x0057 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View U0(android.view.LayoutInflater r17, android.view.ViewGroup r18, android.os.Bundle r19) {
        /*
            r16 = this;
            r1 = r16
            java.lang.String r2 = "</body>"
            java.lang.String r3 = ">"
            java.lang.String r4 = "file://"
            java.lang.String r0 = "index.html"
            java.lang.String r5 = "<body"
            android.view.View r6 = r1.C4
            if (r6 == 0) goto L_0x0011
            return r6
        L_0x0011:
            r6 = 2131558548(0x7f0d0094, float:1.8742415E38)
            r7 = 0
            r8 = r17
            r9 = r18
            android.view.View r6 = r8.inflate(r6, r9, r7)
            r1.C4 = r6
            r8 = 1
            r1.X4 = r8
            r9 = r19
            r1.r4(r6, r9)
            android.os.Bundle r6 = r16.y()
            if (r6 != 0) goto L_0x0030
            android.view.View r0 = r1.C4
            return r0
        L_0x0030:
            android.os.Bundle r6 = r1.D4     // Catch:{ Exception -> 0x0057 }
            java.lang.String r6 = net.imedicaldoctor.imd.Data.CompressHelper.g1(r6, r0)     // Catch:{ Exception -> 0x0057 }
            java.io.File r9 = new java.io.File     // Catch:{ Exception -> 0x0057 }
            r9.<init>(r6)     // Catch:{ Exception -> 0x0057 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0057 }
            r10.<init>()     // Catch:{ Exception -> 0x0057 }
            r10.append(r4)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r9 = r9.getAbsolutePath()     // Catch:{ Exception -> 0x0057 }
            r10.append(r9)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r9 = r10.toString()     // Catch:{ Exception -> 0x0057 }
            java.lang.String r10 = r1.E4     // Catch:{ Exception -> 0x0057 }
            java.lang.String r11 = ""
            if (r10 != r11) goto L_0x005a
            r1.E4 = r9     // Catch:{ Exception -> 0x0057 }
            goto L_0x005a
        L_0x0057:
            r0 = move-exception
            goto L_0x0206
        L_0x005a:
            java.lang.String r10 = r1.E4     // Catch:{ Exception -> 0x0057 }
            boolean r0 = r10.contains(r0)     // Catch:{ Exception -> 0x0057 }
            if (r0 != 0) goto L_0x007a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0057 }
            r0.<init>()     // Catch:{ Exception -> 0x0057 }
            r0.append(r9)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r9 = "#"
            r0.append(r9)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r9 = r1.E4     // Catch:{ Exception -> 0x0057 }
            r0.append(r9)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0057 }
            r1.E4 = r0     // Catch:{ Exception -> 0x0057 }
        L_0x007a:
            r16.s4()     // Catch:{ Exception -> 0x0057 }
            net.imedicaldoctor.imd.Utils.iMDWebView r0 = r1.G4     // Catch:{ Exception -> 0x0057 }
            android.webkit.WebSettings r0 = r0.getSettings()     // Catch:{ Exception -> 0x0057 }
            r0.setDomStorageEnabled(r8)     // Catch:{ Exception -> 0x0057 }
            net.imedicaldoctor.imd.Utils.iMDWebView r0 = r1.G4     // Catch:{ Exception -> 0x0057 }
            android.webkit.WebSettings r0 = r0.getSettings()     // Catch:{ Exception -> 0x0057 }
            r0.setAllowFileAccessFromFileURLs(r8)     // Catch:{ Exception -> 0x0057 }
            net.imedicaldoctor.imd.Utils.iMDWebView r0 = r1.G4     // Catch:{ Exception -> 0x0057 }
            android.webkit.WebSettings r0 = r0.getSettings()     // Catch:{ Exception -> 0x0057 }
            r0.setAllowUniversalAccessFromFileURLs(r8)     // Catch:{ Exception -> 0x0057 }
            java.lang.Boolean r0 = r16.J4()     // Catch:{ Exception -> 0x0057 }
            boolean r0 = r0.booleanValue()     // Catch:{ Exception -> 0x0057 }
            if (r0 == 0) goto L_0x01b0
            net.imedicaldoctor.imd.Data.CompressHelper r0 = r1.Q4     // Catch:{ Exception -> 0x0057 }
            java.lang.String r9 = r0.f2(r6)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r10 = "<body style=\"-webkit-text-size-adjust:200%;\" "
            androidx.fragment.app.FragmentActivity r0 = r16.r()     // Catch:{ Exception -> 0x00ce }
            java.lang.String r12 = "EPUBStyle.css"
            java.lang.String r12 = r1.d4(r0, r12)     // Catch:{ Exception -> 0x00ce }
            androidx.fragment.app.FragmentActivity r0 = r16.r()     // Catch:{ Exception -> 0x00cb }
            java.lang.String r13 = "EPUBJava.css"
            java.lang.String r13 = r1.d4(r0, r13)     // Catch:{ Exception -> 0x00cb }
            androidx.fragment.app.FragmentActivity r0 = r16.r()     // Catch:{ Exception -> 0x00c9 }
            java.lang.String r14 = "EPUBFooter.css"
            java.lang.String r0 = r1.d4(r0, r14)     // Catch:{ Exception -> 0x00c9 }
            goto L_0x00ef
        L_0x00c9:
            r0 = move-exception
            goto L_0x00d1
        L_0x00cb:
            r0 = move-exception
            r13 = r11
            goto L_0x00d1
        L_0x00ce:
            r0 = move-exception
            r12 = r11
            r13 = r12
        L_0x00d1:
            com.google.firebase.crashlytics.FirebaseCrashlytics r14 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()     // Catch:{ Exception -> 0x0057 }
            r14.g(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r14 = "MHViewer"
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0057 }
            r15.<init>()     // Catch:{ Exception -> 0x0057 }
            java.lang.String r8 = "Error in reading EPUBStyle and EPUBJava : "
            r15.append(r8)     // Catch:{ Exception -> 0x0057 }
            r15.append(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = r15.toString()     // Catch:{ Exception -> 0x0057 }
            net.imedicaldoctor.imd.iMDLogger.f(r14, r0)     // Catch:{ Exception -> 0x0057 }
            r0 = r11
        L_0x00ef:
            java.lang.String r8 = "</head>"
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0057 }
            r14.<init>()     // Catch:{ Exception -> 0x0057 }
            java.lang.String r15 = "<style type=\"text/css\">"
            r14.append(r15)     // Catch:{ Exception -> 0x0057 }
            r14.append(r12)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r12 = "</style><script type=\"text/javascript\">"
            r14.append(r12)     // Catch:{ Exception -> 0x0057 }
            r14.append(r13)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r12 = "</script></head>"
            r14.append(r12)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r12 = r14.toString()     // Catch:{ Exception -> 0x0057 }
            java.lang.String r8 = r9.replace(r8, r12)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r8 = r8.replace(r5, r10)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r9 = net.imedicaldoctor.imd.Data.CompressHelper.f(r8, r5, r3)     // Catch:{ Exception -> 0x0057 }
            if (r9 != 0) goto L_0x011e
            r9 = r11
        L_0x011e:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0057 }
            r10.<init>()     // Catch:{ Exception -> 0x0057 }
            r10.append(r5)     // Catch:{ Exception -> 0x0057 }
            r10.append(r9)     // Catch:{ Exception -> 0x0057 }
            r10.append(r3)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r3 = r10.toString()     // Catch:{ Exception -> 0x0057 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0057 }
            r5.<init>()     // Catch:{ Exception -> 0x0057 }
            java.lang.String r10 = "<body onload=\"onBodyLoad();\" "
            r5.append(r10)     // Catch:{ Exception -> 0x0057 }
            r5.append(r9)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r9 = "> <script src=\"file:///android_asset/log4javascript.js\" ></script><script src=\"file:///android_asset/core.js\" ></script><script src=\"file:///android_asset/dom.js\" ></script><script src=\"file:///android_asset/domrange.js\" ></script><script src=\"file:///android_asset/wrappedrange.js\" ></script><script src=\"file:///android_asset/wrappedselection.js\" ></script><script src=\"file:///android_asset/rangy-cssclassapplier.js\" ></script><script src=\"file:///android_asset/rangy-highlighter.js\" ></script><script src=\"file:///android_asset/hightlight.js\" ></script><script src=\"file:///android_asset/find.js\" ></script>"
            r5.append(r9)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0057 }
            java.lang.String r3 = r8.replace(r3, r5)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r5 = "/*<![CDATA[ */ window.console = { log: function (str) { window.external.logMessage(str); } };if ('undefined' === typeof window.VSTWindowController ) {    window.VSTWindowController = { noteTextForGUID: function (str) { return window.external.noteTextForGUID(str); }, markerInfoForGUID: function (str) { return window.external.markerInfoForGUID(str); }, getBibliographyHTML: function (str) { return window.external.getBibliographyHTML(str); },loadPageBreaks: function (str) { return window.external.loadPageBreaks(); }, syncToCFI: function (str) { window.external.syncToCFI(str); }, logMessage: function (str) { window.external.logMessage(str); }, setHasHighlightableSelection: function (bval) { window.external.setHasHighlightableSelection(bval); }, editNote: function (str) { window.external.editNote(str); }, getScores: function (str) { window.external.getScores(str); }, reportScores: function (str) { window.external.reportScores(str); } };   window.VSTWindowController.tooltipStyle = window.external.tooltipStyle;};/* ]]> */"
            java.lang.String r3 = r3.replace(r5, r11)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r5 = "width=device-width,"
            java.lang.String r3 = r3.replace(r5, r11)     // Catch:{ Exception -> 0x0057 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0057 }
            r5.<init>()     // Catch:{ Exception -> 0x0057 }
            r5.append(r0)     // Catch:{ Exception -> 0x0057 }
            r5.append(r2)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = r5.toString()     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = r3.replace(r2, r0)     // Catch:{ Exception -> 0x0057 }
            androidx.fragment.app.FragmentActivity r2 = r16.V1()     // Catch:{ Exception -> 0x0057 }
            java.lang.String r3 = "default_preferences"
            android.content.SharedPreferences r2 = r2.getSharedPreferences(r3, r7)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r3 = "justify"
            r5 = 1
            boolean r2 = r2.getBoolean(r3, r5)     // Catch:{ Exception -> 0x0057 }
            if (r2 != 0) goto L_0x0180
            java.lang.String r0 = net.imedicaldoctor.imd.Fragments.ViewerHelperFragment.i4(r0)     // Catch:{ Exception -> 0x0057 }
        L_0x0180:
            java.lang.String r10 = net.imedicaldoctor.imd.Fragments.ViewerHelperFragment.h4(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0057 }
            r0.<init>()     // Catch:{ Exception -> 0x0057 }
            r0.append(r4)     // Catch:{ Exception -> 0x0057 }
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x0057 }
            r2.<init>(r6)     // Catch:{ Exception -> 0x0057 }
            java.io.File r2 = r2.getParentFile()     // Catch:{ Exception -> 0x0057 }
            java.lang.String r2 = r2.getAbsolutePath()     // Catch:{ Exception -> 0x0057 }
            r0.append(r2)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r2 = "/"
            r0.append(r2)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r9 = r0.toString()     // Catch:{ Exception -> 0x0057 }
            net.imedicaldoctor.imd.Utils.iMDWebView r8 = r1.G4     // Catch:{ Exception -> 0x0057 }
            java.lang.String r11 = "text/html"
            java.lang.String r12 = "utf-8"
            r13 = 0
            r8.loadDataWithBaseURL(r9, r10, r11, r12, r13)     // Catch:{ Exception -> 0x0057 }
            goto L_0x0210
        L_0x01b0:
            androidx.fragment.app.FragmentActivity r0 = r16.r()     // Catch:{ Exception -> 0x0057 }
            java.lang.String r2 = "MKSAPIndex.css"
            java.lang.String r0 = r1.d4(r0, r2)     // Catch:{ Exception -> 0x0057 }
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x0057 }
            r2.<init>(r6)     // Catch:{ Exception -> 0x0057 }
            boolean r2 = r2.exists()     // Catch:{ Exception -> 0x0057 }
            if (r2 == 0) goto L_0x01cd
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x0057 }
            r2.<init>(r6)     // Catch:{ Exception -> 0x0057 }
            r2.delete()     // Catch:{ Exception -> 0x0057 }
        L_0x01cd:
            java.io.File r2 = new java.io.File     // Catch:{ IOException -> 0x01e4 }
            r2.<init>(r6)     // Catch:{ IOException -> 0x01e4 }
            okio.Sink r2 = okio.Okio.n(r2)     // Catch:{ IOException -> 0x01e4 }
            okio.BufferedSink r2 = okio.Okio.d(r2)     // Catch:{ IOException -> 0x01e4 }
            r2.W0(r0)     // Catch:{ all -> 0x01e6 }
            r2.flush()     // Catch:{ all -> 0x01e6 }
            r2.close()     // Catch:{ IOException -> 0x01e4 }
            goto L_0x01fe
        L_0x01e4:
            r0 = move-exception
            goto L_0x01f4
        L_0x01e6:
            r0 = move-exception
            r3 = r0
            if (r2 == 0) goto L_0x01f3
            r2.close()     // Catch:{ all -> 0x01ee }
            goto L_0x01f3
        L_0x01ee:
            r0 = move-exception
            r2 = r0
            r3.addSuppressed(r2)     // Catch:{ IOException -> 0x01e4 }
        L_0x01f3:
            throw r3     // Catch:{ IOException -> 0x01e4 }
        L_0x01f4:
            com.google.firebase.crashlytics.FirebaseCrashlytics r2 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()     // Catch:{ Exception -> 0x0057 }
            r2.g(r0)     // Catch:{ Exception -> 0x0057 }
            r0.printStackTrace()     // Catch:{ Exception -> 0x0057 }
        L_0x01fe:
            net.imedicaldoctor.imd.Utils.iMDWebView r0 = r1.G4     // Catch:{ Exception -> 0x0057 }
            java.lang.String r2 = r1.E4     // Catch:{ Exception -> 0x0057 }
            r0.loadUrl(r2)     // Catch:{ Exception -> 0x0057 }
            goto L_0x0210
        L_0x0206:
            com.google.firebase.crashlytics.FirebaseCrashlytics r2 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()
            r2.g(r0)
            r0.printStackTrace()
        L_0x0210:
            r16.p4()
            r0 = 2131689474(0x7f0f0002, float:1.9007964E38)
            r1.f3(r0)
            androidx.appcompat.widget.Toolbar r0 = r1.L4
            java.lang.String r2 = "Loading, Please wait"
            r0.setTitle((java.lang.CharSequence) r2)
            r1.o2(r7)
            r16.G3()
            android.view.View r0 = r1.C4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.mksap.MKSAPActivityFragment.U0(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    public boolean W3(ConsoleMessage consoleMessage) {
        iMDLogger.f("Javascript Console Message", consoleMessage.message() + " - " + consoleMessage.sourceId() + " - " + consoleMessage.lineNumber());
        String[] split = consoleMessage.message().split(",,,,,");
        if (split[0].equals("title") && split.length == 2) {
            String str = split[1];
            this.F4 = str;
            this.L4.setTitle((CharSequence) str);
            this.Q4.A0(this.D4.getString("Name"), this.D4.getString("Title"), this.E4, this.F4);
        }
        return super.W3(consoleMessage);
    }

    public void Y3(WebView webView, String str) {
    }

    public void Z3(final WebView webView, final String str) {
        iMDLogger.f(" Finished", str);
        this.E4 = str;
        this.G4.g("console.log('title,,,,,' + document.title )");
        this.k4 = true;
        this.C4.postDelayed(new Runnable() {
            public void run() {
                MKSAPActivityFragment.super.Z3(webView, str);
            }
        }, C.c2);
    }

    public void e3(Menu menu) {
        menu.removeItem(R.id.f799action_gallery);
        menu.removeItem(R.id.f801action_menu);
    }

    public boolean v4() {
        return false;
    }

    public WebResourceResponse w4(WebView webView, WebResourceRequest webResourceRequest) {
        String uri = webResourceRequest.getUrl().toString();
        String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(uri, "/");
        String str = splitByWholeSeparator[splitByWholeSeparator.length - 1];
        if (!str.endsWith(".json")) {
            return null;
        }
        String replace = str.replace(".json", "");
        CompressHelper compressHelper = this.Q4;
        Bundle bundle = this.D4;
        Bundle s1 = compressHelper.s1(compressHelper.V(bundle, "select * from docs where docName='" + replace + "'"));
        if (s1 != null) {
            return new WebResourceResponse("application/json", "utf-8", new ByteArrayInputStream(this.Q4.B(s1.getString(Annotation.i3), s1.getString("docName"), "127").getBytes(StandardCharsets.UTF_8)));
        }
        iMDLogger.f("MKSAP", "can't find json of " + uri + StringUtils.SPACE + s1);
        return null;
    }

    public WebResourceResponse x4(WebView webView, String str) {
        String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(str, "/");
        String str2 = splitByWholeSeparator[splitByWholeSeparator.length - 1];
        if (!str2.endsWith(".json")) {
            return null;
        }
        String replace = str2.replace(".json", "");
        CompressHelper compressHelper = this.Q4;
        Bundle bundle = this.D4;
        Bundle s1 = compressHelper.s1(compressHelper.V(bundle, "select * from docs where docName='" + replace + "'"));
        if (s1 != null) {
            return new WebResourceResponse("application/json", "utf-8", new ByteArrayInputStream(this.Q4.B(s1.getString(Annotation.i3), s1.getString("docName"), "127").getBytes(StandardCharsets.UTF_8)));
        }
        iMDLogger.f("MKSAP", "can't find json of " + str + StringUtils.SPACE + s1);
        return null;
    }

    public boolean y4(WebView webView, String str, String str2, String str3) {
        iMDLogger.j("Override", "Url : " + str + ", Scheme : " + str2 + ", Resource : " + str3);
        return true;
    }
}
