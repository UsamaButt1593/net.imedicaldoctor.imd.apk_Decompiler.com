package net.imedicaldoctor.imd.Fragments.EPUB;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebView;
import androidx.appcompat.app.AlertDialog;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.itextpdf.text.Annotation;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.Gallery.GalleryActivity;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Utils.iMDWebView;
import net.imedicaldoctor.imd.iMD;
import net.imedicaldoctor.imd.iMDLogger;
import org.apache.commons.lang3.StringUtils;

public class EPUBViewerActivityFragment extends ViewerHelperFragment {
    private String X4;
    private MenuItem Y4;
    public ArrayList<String> Z4;
    public Bundle a5;
    public String b5;
    public String c5;
    public boolean d5;
    public long e5;

    private void J4(String str) {
        ArrayList<String> arrayList = this.Z4;
        if (arrayList == null || arrayList.size() == 0) {
            CompressHelper.x2(r(), "There is no images in this document", 1);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<String> it2 = this.Z4.iterator();
        while (it2.hasNext()) {
            String next = it2.next();
            Bundle bundle = new Bundle();
            bundle.putString("ImagePath", next);
            try {
                String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(next, "/");
                String str2 = splitByWholeSeparator[splitByWholeSeparator.length - 1];
                bundle.putString("Description", this.a5.containsKey(str2) ? this.a5.getString(str2) : "");
            } catch (Exception e2) {
                FirebaseCrashlytics.d().g(e2);
            }
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

    public void C3(String str) {
        iMDWebView imdwebview = this.G4;
        imdwebview.g("document.getElementById(\"" + str + "\").scrollIntoView(true);");
        iMDWebView imdwebview2 = this.G4;
        imdwebview2.g("document.getElementsByName(\"" + str + "\")[0].scrollIntoView(true);");
    }

    public String I4(String str) {
        ArrayList arrayList = new ArrayList(Arrays.asList(StringUtils.splitByWholeSeparator(str, "/")));
        arrayList.remove(arrayList.size() - 1);
        return StringUtils.join((Iterable<?>) arrayList, "/");
    }

    public boolean J3(Context context) {
        if (this.D4.getString("Name").equals("utdpathways.db")) {
            return false;
        }
        return super.J3(context);
    }

    public void K4(String str) {
        ArrayList arrayList = new ArrayList();
        Bundle bundle = new Bundle();
        bundle.putString("ImagePath", str);
        bundle.putString("isVideo", IcyHeaders.a3);
        arrayList.add(bundle);
        Intent intent = new Intent(r(), GalleryActivity.class);
        intent.putExtra("Images", arrayList);
        intent.putExtra("Start", 0);
        D2(intent);
    }

    public String R2() {
        ArrayList<String> arrayList = this.Z4;
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        return w3(this.Z4);
    }

    public void T0(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.f1445menu_epubviewer, menu);
        q4(menu);
        e3(menu);
    }

    public View onFragmentBind(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.C4;
        if (view != null) {
            return view;
        }
        this.a5 = new Bundle();
        View inflate = layoutInflater.inflate(R.layout.f1255fragment_new_viewer, viewGroup, false);
        r4(inflate, bundle);
        if (bundle != null) {
            this.Z4 = bundle.getStringArrayList("mImages");
            this.b5 = bundle.getString("mBasePath");
            this.c5 = bundle.getString("mPath");
        }
        if (y() == null) {
            return inflate;
        }
        iMDLogger.j("AMViewer", "Loading EPUB Document with mDocAddress = " + this.E4);
        T2(new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:43:0x014e A[Catch:{ Exception -> 0x0052 }] */
            /* JADX WARNING: Removed duplicated region for block: B:46:0x01ae A[Catch:{ Exception -> 0x0052 }] */
            /* JADX WARNING: Removed duplicated region for block: B:50:0x01c0 A[Catch:{ Exception -> 0x0052 }] */
            /* JADX WARNING: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r15 = this;
                    java.lang.String r0 = "</body>"
                    java.lang.String r1 = ">"
                    java.lang.String r2 = "/"
                    java.lang.String r3 = "path"
                    java.lang.String r4 = "<body"
                    java.lang.String r5 = ""
                    net.imedicaldoctor.imd.Data.CompressHelper r6 = new net.imedicaldoctor.imd.Data.CompressHelper     // Catch:{ Exception -> 0x0052 }
                    net.imedicaldoctor.imd.Fragments.EPUB.EPUBViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.EPUB.EPUBViewerActivityFragment.this     // Catch:{ Exception -> 0x0052 }
                    androidx.fragment.app.FragmentActivity r7 = r7.r()     // Catch:{ Exception -> 0x0052 }
                    r6.<init>(r7)     // Catch:{ Exception -> 0x0052 }
                    r7 = 0
                    r8 = 1
                    net.imedicaldoctor.imd.Fragments.EPUB.EPUBViewerActivityFragment r9 = net.imedicaldoctor.imd.Fragments.EPUB.EPUBViewerActivityFragment.this     // Catch:{ Exception -> 0x0035 }
                    android.os.Bundle r9 = r9.D4     // Catch:{ Exception -> 0x0035 }
                    java.lang.String r10 = "select * from sqlite_master where tbl_name='images'"
                    java.util.ArrayList r9 = r6.V(r9, r10)     // Catch:{ Exception -> 0x0035 }
                    android.os.Bundle r9 = r6.s1(r9)     // Catch:{ Exception -> 0x0035 }
                    java.lang.String r10 = "EPUB"
                    if (r9 != 0) goto L_0x0037
                    net.imedicaldoctor.imd.Fragments.EPUB.EPUBViewerActivityFragment r9 = net.imedicaldoctor.imd.Fragments.EPUB.EPUBViewerActivityFragment.this     // Catch:{ Exception -> 0x0035 }
                    r9.d5 = r7     // Catch:{ Exception -> 0x0035 }
                    java.lang.String r9 = "Dont have image"
                L_0x0031:
                    net.imedicaldoctor.imd.iMDLogger.f(r10, r9)     // Catch:{ Exception -> 0x0035 }
                    goto L_0x0045
                L_0x0035:
                    r9 = move-exception
                    goto L_0x003e
                L_0x0037:
                    net.imedicaldoctor.imd.Fragments.EPUB.EPUBViewerActivityFragment r9 = net.imedicaldoctor.imd.Fragments.EPUB.EPUBViewerActivityFragment.this     // Catch:{ Exception -> 0x0035 }
                    r9.d5 = r8     // Catch:{ Exception -> 0x0035 }
                    java.lang.String r9 = "have image"
                    goto L_0x0031
                L_0x003e:
                    com.google.firebase.crashlytics.FirebaseCrashlytics r10 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()     // Catch:{ Exception -> 0x0052 }
                    r10.g(r9)     // Catch:{ Exception -> 0x0052 }
                L_0x0045:
                    net.imedicaldoctor.imd.Fragments.EPUB.EPUBViewerActivityFragment r9 = net.imedicaldoctor.imd.Fragments.EPUB.EPUBViewerActivityFragment.this     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r9 = r9.A4     // Catch:{ Exception -> 0x0052 }
                    if (r9 == 0) goto L_0x0055
                    int r9 = r9.length()     // Catch:{ Exception -> 0x0052 }
                    if (r9 != 0) goto L_0x01ba
                    goto L_0x0055
                L_0x0052:
                    r0 = move-exception
                    goto L_0x01c8
                L_0x0055:
                    net.imedicaldoctor.imd.Fragments.EPUB.EPUBViewerActivityFragment r9 = net.imedicaldoctor.imd.Fragments.EPUB.EPUBViewerActivityFragment.this     // Catch:{ Exception -> 0x0052 }
                    android.os.Bundle r9 = r9.D4     // Catch:{ Exception -> 0x0052 }
                    java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0052 }
                    r10.<init>()     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r11 = "Select * from Docs where id="
                    r10.append(r11)     // Catch:{ Exception -> 0x0052 }
                    net.imedicaldoctor.imd.Fragments.EPUB.EPUBViewerActivityFragment r11 = net.imedicaldoctor.imd.Fragments.EPUB.EPUBViewerActivityFragment.this     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r11 = r11.E4     // Catch:{ Exception -> 0x0052 }
                    r10.append(r11)     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x0052 }
                    android.os.Bundle r9 = r6.e0(r9, r10)     // Catch:{ Exception -> 0x0052 }
                    if (r9 != 0) goto L_0x007b
                    net.imedicaldoctor.imd.Fragments.EPUB.EPUBViewerActivityFragment r0 = net.imedicaldoctor.imd.Fragments.EPUB.EPUBViewerActivityFragment.this     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r1 = "Document doesn't exist"
                    r0.p4 = r1     // Catch:{ Exception -> 0x0052 }
                    return
                L_0x007b:
                    net.imedicaldoctor.imd.Fragments.EPUB.EPUBViewerActivityFragment r10 = net.imedicaldoctor.imd.Fragments.EPUB.EPUBViewerActivityFragment.this     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r11 = r9.getString(r3)     // Catch:{ Exception -> 0x0052 }
                    r10.c5 = r11     // Catch:{ Exception -> 0x0052 }
                    net.imedicaldoctor.imd.Fragments.EPUB.EPUBViewerActivityFragment r10 = net.imedicaldoctor.imd.Fragments.EPUB.EPUBViewerActivityFragment.this     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r3 = r9.getString(r3)     // Catch:{ Exception -> 0x0052 }
                    r10.b5 = r3     // Catch:{ Exception -> 0x0052 }
                    java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x0052 }
                    net.imedicaldoctor.imd.Fragments.EPUB.EPUBViewerActivityFragment r10 = net.imedicaldoctor.imd.Fragments.EPUB.EPUBViewerActivityFragment.this     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r10 = r10.b5     // Catch:{ Exception -> 0x0052 }
                    java.lang.String[] r10 = org.apache.commons.lang3.StringUtils.splitByWholeSeparator(r10, r2)     // Catch:{ Exception -> 0x0052 }
                    java.util.List r10 = java.util.Arrays.asList(r10)     // Catch:{ Exception -> 0x0052 }
                    r3.<init>(r10)     // Catch:{ Exception -> 0x0052 }
                    int r10 = r3.size()     // Catch:{ Exception -> 0x0052 }
                    int r10 = r10 - r8
                    r3.remove(r10)     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r2 = org.apache.commons.lang3.StringUtils.join((java.lang.Iterable<?>) r3, (java.lang.String) r2)     // Catch:{ Exception -> 0x0052 }
                    net.imedicaldoctor.imd.Fragments.EPUB.EPUBViewerActivityFragment r3 = net.imedicaldoctor.imd.Fragments.EPUB.EPUBViewerActivityFragment.this     // Catch:{ Exception -> 0x0052 }
                    android.os.Bundle r10 = r3.D4     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r2 = net.imedicaldoctor.imd.Data.CompressHelper.g1(r10, r2)     // Catch:{ Exception -> 0x0052 }
                    r3.b5 = r2     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r2 = "doc"
                    java.lang.String r2 = r9.getString(r2)     // Catch:{ Exception -> 0x0052 }
                    net.imedicaldoctor.imd.Fragments.EPUB.EPUBViewerActivityFragment r3 = net.imedicaldoctor.imd.Fragments.EPUB.EPUBViewerActivityFragment.this     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r10 = "title"
                    java.lang.String r10 = r9.getString(r10)     // Catch:{ Exception -> 0x0052 }
                    r3.F4 = r10     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r3 = "id"
                    java.lang.String r3 = r9.getString(r3)     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r9 = "127"
                    byte[] r2 = r6.v(r2, r3, r9)     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r3 = new java.lang.String     // Catch:{ Exception -> 0x0052 }
                    r3.<init>(r2)     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r2 = "<body style=\"-webkit-text-size-adjust:200%;\" "
                    net.imedicaldoctor.imd.Fragments.EPUB.EPUBViewerActivityFragment r9 = net.imedicaldoctor.imd.Fragments.EPUB.EPUBViewerActivityFragment.this     // Catch:{ Exception -> 0x00ff }
                    androidx.fragment.app.FragmentActivity r10 = r9.r()     // Catch:{ Exception -> 0x00ff }
                    java.lang.String r11 = "EPUBStyle.css"
                    java.lang.String r9 = r9.d4(r10, r11)     // Catch:{ Exception -> 0x00ff }
                    net.imedicaldoctor.imd.Fragments.EPUB.EPUBViewerActivityFragment r10 = net.imedicaldoctor.imd.Fragments.EPUB.EPUBViewerActivityFragment.this     // Catch:{ Exception -> 0x00fc }
                    androidx.fragment.app.FragmentActivity r11 = r10.r()     // Catch:{ Exception -> 0x00fc }
                    java.lang.String r12 = "EPUBJava.css"
                    java.lang.String r10 = r10.d4(r11, r12)     // Catch:{ Exception -> 0x00fc }
                    net.imedicaldoctor.imd.Fragments.EPUB.EPUBViewerActivityFragment r11 = net.imedicaldoctor.imd.Fragments.EPUB.EPUBViewerActivityFragment.this     // Catch:{ Exception -> 0x00fa }
                    androidx.fragment.app.FragmentActivity r12 = r11.r()     // Catch:{ Exception -> 0x00fa }
                    java.lang.String r13 = "EPUBFooter.css"
                    java.lang.String r11 = r11.d4(r12, r13)     // Catch:{ Exception -> 0x00fa }
                    goto L_0x0120
                L_0x00fa:
                    r11 = move-exception
                    goto L_0x0102
                L_0x00fc:
                    r11 = move-exception
                    r10 = r5
                    goto L_0x0102
                L_0x00ff:
                    r11 = move-exception
                    r9 = r5
                    r10 = r9
                L_0x0102:
                    com.google.firebase.crashlytics.FirebaseCrashlytics r12 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()     // Catch:{ Exception -> 0x0052 }
                    r12.g(r11)     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r12 = "MHViewer"
                    java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0052 }
                    r13.<init>()     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r14 = "Error in reading EPUBStyle and EPUBJava : "
                    r13.append(r14)     // Catch:{ Exception -> 0x0052 }
                    r13.append(r11)     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r11 = r13.toString()     // Catch:{ Exception -> 0x0052 }
                    net.imedicaldoctor.imd.iMDLogger.f(r12, r11)     // Catch:{ Exception -> 0x0052 }
                    r11 = r5
                L_0x0120:
                    java.lang.String r12 = "</head>"
                    java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0052 }
                    r13.<init>()     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r14 = "<style type=\"text/css\">"
                    r13.append(r14)     // Catch:{ Exception -> 0x0052 }
                    r13.append(r9)     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r9 = "</style><script type=\"text/javascript\">"
                    r13.append(r9)     // Catch:{ Exception -> 0x0052 }
                    r13.append(r10)     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r9 = "</script></head>"
                    r13.append(r9)     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r9 = r13.toString()     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r3 = r3.replace(r12, r9)     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r2 = r3.replace(r4, r2)     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r3 = net.imedicaldoctor.imd.Data.CompressHelper.f(r2, r4, r1)     // Catch:{ Exception -> 0x0052 }
                    if (r3 != 0) goto L_0x014f
                    r3 = r5
                L_0x014f:
                    java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0052 }
                    r9.<init>()     // Catch:{ Exception -> 0x0052 }
                    r9.append(r4)     // Catch:{ Exception -> 0x0052 }
                    r9.append(r3)     // Catch:{ Exception -> 0x0052 }
                    r9.append(r1)     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r1 = r9.toString()     // Catch:{ Exception -> 0x0052 }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0052 }
                    r4.<init>()     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r9 = "<body onload=\"onBodyLoad();\" "
                    r4.append(r9)     // Catch:{ Exception -> 0x0052 }
                    r4.append(r3)     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r3 = "> <script src=\"file:///android_asset/log4javascript.js\" ></script><script src=\"file:///android_asset/core.js\" ></script><script src=\"file:///android_asset/dom.js\" ></script><script src=\"file:///android_asset/domrange.js\" ></script><script src=\"file:///android_asset/wrappedrange.js\" ></script><script src=\"file:///android_asset/wrappedselection.js\" ></script><script src=\"file:///android_asset/rangy-cssclassapplier.js\" ></script><script src=\"file:///android_asset/rangy-highlighter.js\" ></script><script src=\"file:///android_asset/hightlight.js\" ></script><script src=\"file:///android_asset/find.js\" ></script>"
                    r4.append(r3)     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r1 = r2.replace(r1, r3)     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r2 = "/*<![CDATA[ */ window.console = { log: function (str) { window.external.logMessage(str); } };if ('undefined' === typeof window.VSTWindowController ) {    window.VSTWindowController = { noteTextForGUID: function (str) { return window.external.noteTextForGUID(str); }, markerInfoForGUID: function (str) { return window.external.markerInfoForGUID(str); }, getBibliographyHTML: function (str) { return window.external.getBibliographyHTML(str); },loadPageBreaks: function (str) { return window.external.loadPageBreaks(); }, syncToCFI: function (str) { window.external.syncToCFI(str); }, logMessage: function (str) { window.external.logMessage(str); }, setHasHighlightableSelection: function (bval) { window.external.setHasHighlightableSelection(bval); }, editNote: function (str) { window.external.editNote(str); }, getScores: function (str) { window.external.getScores(str); }, reportScores: function (str) { window.external.reportScores(str); } };   window.VSTWindowController.tooltipStyle = window.external.tooltipStyle;};/* ]]> */"
                    java.lang.String r1 = r1.replace(r2, r5)     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r2 = "width=device-width,"
                    java.lang.String r1 = r1.replace(r2, r5)     // Catch:{ Exception -> 0x0052 }
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0052 }
                    r2.<init>()     // Catch:{ Exception -> 0x0052 }
                    r2.append(r11)     // Catch:{ Exception -> 0x0052 }
                    r2.append(r0)     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r0 = r1.replace(r0, r2)     // Catch:{ Exception -> 0x0052 }
                    net.imedicaldoctor.imd.Fragments.EPUB.EPUBViewerActivityFragment r1 = net.imedicaldoctor.imd.Fragments.EPUB.EPUBViewerActivityFragment.this     // Catch:{ Exception -> 0x0052 }
                    androidx.fragment.app.FragmentActivity r1 = r1.V1()     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r2 = "default_preferences"
                    android.content.SharedPreferences r1 = r1.getSharedPreferences(r2, r7)     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r2 = "justify"
                    boolean r1 = r1.getBoolean(r2, r8)     // Catch:{ Exception -> 0x0052 }
                    if (r1 != 0) goto L_0x01b2
                    java.lang.String r0 = net.imedicaldoctor.imd.Fragments.ViewerHelperFragment.i4(r0)     // Catch:{ Exception -> 0x0052 }
                L_0x01b2:
                    java.lang.String r0 = net.imedicaldoctor.imd.Fragments.ViewerHelperFragment.h4(r0)     // Catch:{ Exception -> 0x0052 }
                    net.imedicaldoctor.imd.Fragments.EPUB.EPUBViewerActivityFragment r1 = net.imedicaldoctor.imd.Fragments.EPUB.EPUBViewerActivityFragment.this     // Catch:{ Exception -> 0x0052 }
                    r1.A4 = r0     // Catch:{ Exception -> 0x0052 }
                L_0x01ba:
                    boolean r0 = r6.x1()     // Catch:{ Exception -> 0x0052 }
                    if (r0 != 0) goto L_0x01da
                    net.imedicaldoctor.imd.Fragments.EPUB.EPUBViewerActivityFragment r0 = net.imedicaldoctor.imd.Fragments.EPUB.EPUBViewerActivityFragment.this     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r1 = "Chapter"
                    r0.m4(r1)     // Catch:{ Exception -> 0x0052 }
                    goto L_0x01da
                L_0x01c8:
                    com.google.firebase.crashlytics.FirebaseCrashlytics r1 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()
                    r1.g(r0)
                    r0.printStackTrace()
                    net.imedicaldoctor.imd.Fragments.EPUB.EPUBViewerActivityFragment r1 = net.imedicaldoctor.imd.Fragments.EPUB.EPUBViewerActivityFragment.this
                    java.lang.String r0 = r0.getLocalizedMessage()
                    r1.p4 = r0
                L_0x01da:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.EPUB.EPUBViewerActivityFragment.AnonymousClass1.run():void");
            }
        }, new Runnable() {
            public void run() {
                String str = EPUBViewerActivityFragment.this.p4;
                if (str == null || str.length() <= 0) {
                    EPUBViewerActivityFragment ePUBViewerActivityFragment = EPUBViewerActivityFragment.this;
                    ePUBViewerActivityFragment.O3(ePUBViewerActivityFragment.A4, ePUBViewerActivityFragment.b5);
                    EPUBViewerActivityFragment.this.s4();
                    EPUBViewerActivityFragment.this.p4();
                    EPUBViewerActivityFragment.this.f3(R.menu.f1445menu_epubviewer);
                    EPUBViewerActivityFragment.this.o2(false);
                    EPUBViewerActivityFragment.this.G3();
                    return;
                }
                EPUBViewerActivityFragment ePUBViewerActivityFragment2 = EPUBViewerActivityFragment.this;
                ePUBViewerActivityFragment2.C4(ePUBViewerActivityFragment2.p4);
            }
        });
        return inflate;
    }

    public boolean W3(ConsoleMessage consoleMessage) {
        String str;
        String[] split = consoleMessage.message().split(",,,,,");
        if (split[0].equals("images")) {
            if (split.length < 2) {
                return true;
            }
            String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(split[1], "|");
            ArrayList<String> arrayList = new ArrayList<>();
            for (String str2 : splitByWholeSeparator) {
                String replace = this.b5.replace("file://", "");
                if (replace.endsWith("/")) {
                    replace = replace.substring(0, replace.length() - 1);
                }
                String[] splitByWholeSeparator2 = StringUtils.splitByWholeSeparator(str2, "/");
                for (String str3 : splitByWholeSeparator2) {
                    if (str3.equals("..")) {
                        str = I4(str);
                    } else {
                        str = str + "/" + str3;
                    }
                }
                try {
                    if (this.d5 && splitByWholeSeparator2.length > 0) {
                        String str4 = splitByWholeSeparator2[splitByWholeSeparator2.length - 1];
                        CompressHelper compressHelper = this.Q4;
                        Bundle z = compressHelper.z(compressHelper.V(this.D4, "Select * from images where imageName='" + str4 + "'"));
                        if (z != null) {
                            String string = z.getString("desc");
                            if (!this.a5.containsKey(str4)) {
                                this.a5.putString(str4, string);
                            }
                        }
                    }
                } catch (Exception e2) {
                    FirebaseCrashlytics.d().g(e2);
                }
                File file = new File(str);
                file.length();
                if (file.length() > ExoPlayer.a1) {
                    arrayList.add(str);
                }
                iMDLogger.j("EPUB Images", "Imagepath = : " + str);
            }
            this.Z4 = arrayList;
            o4();
        }
        return super.W3(consoleMessage);
    }

    public boolean X3(WebView webView, String str, String str2, JsResult jsResult) {
        if (System.currentTimeMillis() - this.e5 > 1000) {
            this.e5 = System.currentTimeMillis();
            new AlertDialog.Builder(r()).l(str2).s("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                }
            }).I();
        } else {
            Log.e("e-Anatomy", "too many alerts");
        }
        jsResult.cancel();
        return true;
    }

    public void Z3(WebView webView, String str) {
        super.Z3(webView, str);
        this.G4.g("IgnoreSmallImages();");
        this.G4.g("ConvertAllImages();");
        this.G4.g("fixAllImages2();");
        if (!this.D4.getString("Name").contains("auntminni") && !this.D4.getString("Name").contains("student-")) {
            this.G4.g("fixAllTables();");
        }
        this.G4.g("console.log(\"images,,,,,\" + getImageList());");
    }

    public boolean e1(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.f799action_gallery) {
            J4("soheilvb");
        }
        return super.e1(menuItem);
    }

    public void e3(Menu menu) {
        this.Y4 = menu.findItem(R.id.f799action_gallery);
    }

    public void m1(Bundle bundle) {
        super.m1(bundle);
    }

    public boolean y4(WebView webView, String str, String str2, String str3) {
        String str4;
        String str5;
        String str6 = str;
        String str7 = str2;
        String str8 = str3;
        iMDLogger.j("Override", "Url : " + str6 + ", Scheme : " + str7 + ", Resource : " + str8);
        if (str7.equals("image")) {
            J4(str8);
            return true;
        }
        if (str7.equals("utdpathway")) {
            ArrayList arrayList = new ArrayList(Collections2.d(((iMD) r().getApplicationContext()).s, new Predicate<Bundle>() {
                /* renamed from: a */
                public boolean apply(Bundle bundle) {
                    return bundle.getString("Name").equals("uptodate");
                }
            }));
            if (arrayList.size() == 0) {
                CompressHelper.x2(r(), "you must install Uptodate", 1);
                return false;
            }
            Bundle bundle = (Bundle) arrayList.get(0);
            str8 = str8.replace(".html", "");
            String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(str8, "-");
            if (splitByWholeSeparator.length < 3) {
                return false;
            }
            if (splitByWholeSeparator[1].equals("MED") || splitByWholeSeparator[1].equals("PAT") || splitByWholeSeparator[1].equals("Society_Guidelines") || splitByWholeSeparator[1].equals("DRG")) {
                String str9 = splitByWholeSeparator[3];
                if (str9.contains("#")) {
                    str9 = StringUtils.splitByWholeSeparator(str9, "#")[0];
                }
                this.Q4.A1(bundle, "Topic-" + splitByWholeSeparator[2], (String[]) null, str9);
            } else if (splitByWholeSeparator[1].equals("Graphic")) {
                this.Q4.A1(bundle, "Graphic-" + splitByWholeSeparator[2], (String[]) null, "");
            }
        }
        if (str7.equals("svv")) {
            K4(this.D4.getString("Path") + str8.replace("//", ""));
            return true;
        }
        if (str7.equals(Annotation.k3) || (str7.equals("http") && str8.contains("localhost:"))) {
            CompressHelper compressHelper = new CompressHelper(r());
            String str10 = "//" + this.D4.getString("Path") + "/";
            if (this.D4.getString("Name").contains("student-")) {
                str8 = str8.replace("///student/content/book", "base");
            }
            if (str6.contains("#")) {
                str5 = StringUtils.splitByWholeSeparator(str6, "#")[1];
                iMDLogger.f("Testing", "BasePath : " + str10 + ", Resource : " + str8 + ", mPath : " + this.c5);
                str4 = str8.replace(str10, "");
                if (this.D4.getString("Name").contains("student-")) {
                    str4 = str4 + ".html";
                }
                if (this.c5.equalsIgnoreCase(str4)) {
                    C3(str5);
                    return true;
                }
            } else {
                if (this.D4.getString("Name").contains("student-")) {
                    str8 = str8 + ".html";
                }
                str5 = "";
            }
            iMDLogger.f("Testing", "BasePath : " + str10 + ", Resource : " + str4 + ", mPath : " + this.c5);
            String replace = str4.replace(str10, "");
            Bundle bundle2 = this.D4;
            StringBuilder sb = new StringBuilder();
            sb.append("Select * from docs where path = '");
            sb.append(replace);
            sb.append("'");
            ArrayList<Bundle> V = compressHelper.V(bundle2, sb.toString());
            if (V == null || V.size() == 0) {
                CompressHelper.x2(r(), "Sorry, Document not available", 1);
                return true;
            }
            compressHelper.A1(this.D4, V.get(0).getString("id"), (String[]) null, str5);
        }
        return true;
    }
}
