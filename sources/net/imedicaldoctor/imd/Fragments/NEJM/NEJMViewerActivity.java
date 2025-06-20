package net.imedicaldoctor.imd.Fragments.NEJM;

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
import android.webkit.WebView;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.itextpdf.text.Annotation;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import java.io.File;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.ViewerHelperActivity;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.Gallery.GalleryActivity;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Utils.iMDWebView;
import net.imedicaldoctor.imd.iMDLogger;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

public class NEJMViewerActivity extends ViewerHelperActivity {

    public static class NEJMViewerFragment extends ViewerHelperFragment {
        private String X4;
        private MenuItem Y4;
        public ArrayList<String> Z4;
        public Bundle a5;
        public String b5;
        public String c5;
        public boolean d5;
        public Bundle e5;

        private void K4(String str) {
            Bundle bundle = new Bundle();
            bundle.putString("ImagePath", str);
            bundle.putString("isVideo", IcyHeaders.a3);
            ArrayList arrayList = new ArrayList();
            arrayList.add(bundle);
            Intent intent = new Intent(r(), GalleryActivity.class);
            intent.putExtra("Images", arrayList);
            intent.putExtra("Start", 0);
            D2(intent);
        }

        private void M4(String str) {
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

        public void I4(String str, String str2) {
            ArrayList arrayList = new ArrayList();
            Bundle bundle = new Bundle();
            bundle.putString("ImagePath", J4(str));
            bundle.putString("Description", str2);
            arrayList.add(bundle);
            Intent intent = new Intent(r(), GalleryActivity.class);
            intent.putExtra("Images", arrayList);
            intent.putExtra("Start", 0);
            D2(intent);
        }

        public String J4(String str) {
            String j2 = CompressHelper.j2(CompressHelper.h1(this.D4, this.e5.getString("purl"), this.e5.getString("issueName")));
            while (j2.contains("../")) {
                j2 = CompressHelper.j2(j2);
                str = str.substring(3);
            }
            return j2 + "/" + str;
        }

        public String L4(String str) {
            ArrayList arrayList = new ArrayList(Arrays.asList(StringUtils.splitByWholeSeparator(str, "/")));
            arrayList.remove(arrayList.size() - 1);
            return StringUtils.join((Iterable<?>) arrayList, "/");
        }

        public void N4(String str) {
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
            iMDLogger.j("NEJMViewerActivity", "Loading NEJM Document with mDocAddress = " + this.E4);
            T2(new Runnable() {
                /* JADX WARNING: Removed duplicated region for block: B:25:0x0111 A[Catch:{ Exception -> 0x0022 }] */
                /* JADX WARNING: Removed duplicated region for block: B:28:0x016c A[Catch:{ Exception -> 0x0022 }] */
                /* JADX WARNING: Removed duplicated region for block: B:32:0x017e A[Catch:{ Exception -> 0x0022 }] */
                /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r13 = this;
                        java.lang.String r0 = "</body>"
                        java.lang.String r1 = ">"
                        java.lang.String r2 = "/"
                        java.lang.String r3 = "<body"
                        java.lang.String r4 = ""
                        net.imedicaldoctor.imd.Data.CompressHelper r5 = new net.imedicaldoctor.imd.Data.CompressHelper     // Catch:{ Exception -> 0x0022 }
                        net.imedicaldoctor.imd.Fragments.NEJM.NEJMViewerActivity$NEJMViewerFragment r6 = net.imedicaldoctor.imd.Fragments.NEJM.NEJMViewerActivity.NEJMViewerFragment.this     // Catch:{ Exception -> 0x0022 }
                        androidx.fragment.app.FragmentActivity r6 = r6.r()     // Catch:{ Exception -> 0x0022 }
                        r5.<init>(r6)     // Catch:{ Exception -> 0x0022 }
                        net.imedicaldoctor.imd.Fragments.NEJM.NEJMViewerActivity$NEJMViewerFragment r6 = net.imedicaldoctor.imd.Fragments.NEJM.NEJMViewerActivity.NEJMViewerFragment.this     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r6 = r6.A4     // Catch:{ Exception -> 0x0022 }
                        if (r6 == 0) goto L_0x0025
                        int r6 = r6.length()     // Catch:{ Exception -> 0x0022 }
                        if (r6 != 0) goto L_0x0178
                        goto L_0x0025
                    L_0x0022:
                        r0 = move-exception
                        goto L_0x0186
                    L_0x0025:
                        net.imedicaldoctor.imd.Fragments.NEJM.NEJMViewerActivity$NEJMViewerFragment r6 = net.imedicaldoctor.imd.Fragments.NEJM.NEJMViewerActivity.NEJMViewerFragment.this     // Catch:{ Exception -> 0x0022 }
                        android.os.Bundle r6 = r6.D4     // Catch:{ Exception -> 0x0022 }
                        java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0022 }
                        r7.<init>()     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r8 = "Select * from contents Where pid = "
                        r7.append(r8)     // Catch:{ Exception -> 0x0022 }
                        net.imedicaldoctor.imd.Fragments.NEJM.NEJMViewerActivity$NEJMViewerFragment r8 = net.imedicaldoctor.imd.Fragments.NEJM.NEJMViewerActivity.NEJMViewerFragment.this     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r8 = r8.E4     // Catch:{ Exception -> 0x0022 }
                        r7.append(r8)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0022 }
                        android.os.Bundle r6 = r5.e0(r6, r7)     // Catch:{ Exception -> 0x0022 }
                        if (r6 != 0) goto L_0x004b
                        net.imedicaldoctor.imd.Fragments.NEJM.NEJMViewerActivity$NEJMViewerFragment r0 = net.imedicaldoctor.imd.Fragments.NEJM.NEJMViewerActivity.NEJMViewerFragment.this     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r1 = "Document doesn't exist"
                        r0.p4 = r1     // Catch:{ Exception -> 0x0022 }
                        return
                    L_0x004b:
                        net.imedicaldoctor.imd.Fragments.NEJM.NEJMViewerActivity$NEJMViewerFragment r7 = net.imedicaldoctor.imd.Fragments.NEJM.NEJMViewerActivity.NEJMViewerFragment.this     // Catch:{ Exception -> 0x0022 }
                        r7.e5 = r6     // Catch:{ Exception -> 0x0022 }
                        android.os.Bundle r8 = r7.D4     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r9 = "purl"
                        java.lang.String r9 = r6.getString(r9)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r10 = "issueName"
                        java.lang.String r10 = r6.getString(r10)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r8 = net.imedicaldoctor.imd.Data.CompressHelper.h1(r8, r9, r10)     // Catch:{ Exception -> 0x0022 }
                        r7.b5 = r8     // Catch:{ Exception -> 0x0022 }
                        java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ Exception -> 0x0022 }
                        net.imedicaldoctor.imd.Fragments.NEJM.NEJMViewerActivity$NEJMViewerFragment r8 = net.imedicaldoctor.imd.Fragments.NEJM.NEJMViewerActivity.NEJMViewerFragment.this     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r8 = r8.b5     // Catch:{ Exception -> 0x0022 }
                        java.lang.String[] r8 = org.apache.commons.lang3.StringUtils.splitByWholeSeparator(r8, r2)     // Catch:{ Exception -> 0x0022 }
                        java.util.List r8 = java.util.Arrays.asList(r8)     // Catch:{ Exception -> 0x0022 }
                        r7.<init>(r8)     // Catch:{ Exception -> 0x0022 }
                        int r8 = r7.size()     // Catch:{ Exception -> 0x0022 }
                        r9 = 1
                        int r8 = r8 - r9
                        r7.remove(r8)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r2 = org.apache.commons.lang3.StringUtils.join((java.lang.Iterable<?>) r7, (java.lang.String) r2)     // Catch:{ Exception -> 0x0022 }
                        net.imedicaldoctor.imd.Fragments.NEJM.NEJMViewerActivity$NEJMViewerFragment r7 = net.imedicaldoctor.imd.Fragments.NEJM.NEJMViewerActivity.NEJMViewerFragment.this     // Catch:{ Exception -> 0x0022 }
                        r7.b5 = r2     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r2 = "doc"
                        java.lang.String r2 = r6.getString(r2)     // Catch:{ Exception -> 0x0022 }
                        net.imedicaldoctor.imd.Fragments.NEJM.NEJMViewerActivity$NEJMViewerFragment r7 = net.imedicaldoctor.imd.Fragments.NEJM.NEJMViewerActivity.NEJMViewerFragment.this     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r8 = "title"
                        java.lang.String r8 = r6.getString(r8)     // Catch:{ Exception -> 0x0022 }
                        r7.F4 = r8     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r7 = "pid"
                        java.lang.String r6 = r6.getString(r7)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r7 = "127"
                        byte[] r2 = r5.v(r2, r6, r7)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r6 = new java.lang.String     // Catch:{ Exception -> 0x0022 }
                        r6.<init>(r2)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r2 = "<body style=\"-webkit-text-size-adjust:200%;\" "
                        net.imedicaldoctor.imd.Fragments.NEJM.NEJMViewerActivity$NEJMViewerFragment r7 = net.imedicaldoctor.imd.Fragments.NEJM.NEJMViewerActivity.NEJMViewerFragment.this     // Catch:{ Exception -> 0x00c3 }
                        androidx.fragment.app.FragmentActivity r8 = r7.r()     // Catch:{ Exception -> 0x00c3 }
                        java.lang.String r10 = "NMStyles.css"
                        java.lang.String r7 = r7.d4(r8, r10)     // Catch:{ Exception -> 0x00c3 }
                        net.imedicaldoctor.imd.Fragments.NEJM.NEJMViewerActivity$NEJMViewerFragment r8 = net.imedicaldoctor.imd.Fragments.NEJM.NEJMViewerActivity.NEJMViewerFragment.this     // Catch:{ Exception -> 0x00c1 }
                        androidx.fragment.app.FragmentActivity r10 = r8.r()     // Catch:{ Exception -> 0x00c1 }
                        java.lang.String r11 = "NMJava.css"
                        java.lang.String r8 = r8.d4(r10, r11)     // Catch:{ Exception -> 0x00c1 }
                        goto L_0x00e3
                    L_0x00c1:
                        r8 = move-exception
                        goto L_0x00c5
                    L_0x00c3:
                        r8 = move-exception
                        r7 = r4
                    L_0x00c5:
                        com.google.firebase.crashlytics.FirebaseCrashlytics r10 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()     // Catch:{ Exception -> 0x0022 }
                        r10.g(r8)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r10 = "MHViewer"
                        java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0022 }
                        r11.<init>()     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r12 = "Error in reading NMStyles and NMJava : "
                        r11.append(r12)     // Catch:{ Exception -> 0x0022 }
                        r11.append(r8)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r8 = r11.toString()     // Catch:{ Exception -> 0x0022 }
                        net.imedicaldoctor.imd.iMDLogger.f(r10, r8)     // Catch:{ Exception -> 0x0022 }
                        r8 = r4
                    L_0x00e3:
                        java.lang.String r10 = "</head>"
                        java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0022 }
                        r11.<init>()     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r12 = "<style type=\"text/css\">"
                        r11.append(r12)     // Catch:{ Exception -> 0x0022 }
                        r11.append(r7)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r7 = "</style><script type=\"text/javascript\">"
                        r11.append(r7)     // Catch:{ Exception -> 0x0022 }
                        r11.append(r8)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r7 = "</script></head>"
                        r11.append(r7)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r7 = r11.toString()     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r6 = r6.replace(r10, r7)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r2 = r6.replace(r3, r2)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r6 = net.imedicaldoctor.imd.Data.CompressHelper.f(r2, r3, r1)     // Catch:{ Exception -> 0x0022 }
                        if (r6 != 0) goto L_0x0112
                        r6 = r4
                    L_0x0112:
                        java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0022 }
                        r7.<init>()     // Catch:{ Exception -> 0x0022 }
                        r7.append(r3)     // Catch:{ Exception -> 0x0022 }
                        r7.append(r6)     // Catch:{ Exception -> 0x0022 }
                        r7.append(r1)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r1 = r7.toString()     // Catch:{ Exception -> 0x0022 }
                        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0022 }
                        r3.<init>()     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r7 = "<body onload=\"onBodyLoad();\" "
                        r3.append(r7)     // Catch:{ Exception -> 0x0022 }
                        r3.append(r6)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r6 = "> <script src=\"file:///android_asset/log4javascript.js\" ></script><script src=\"file:///android_asset/core.js\" ></script><script src=\"file:///android_asset/dom.js\" ></script><script src=\"file:///android_asset/domrange.js\" ></script><script src=\"file:///android_asset/wrappedrange.js\" ></script><script src=\"file:///android_asset/wrappedselection.js\" ></script><script src=\"file:///android_asset/rangy-cssclassapplier.js\" ></script><script src=\"file:///android_asset/rangy-highlighter.js\" ></script><script src=\"file:///android_asset/hightlight.js\" ></script><script src=\"file:///android_asset/find.js\" ></script>"
                        r3.append(r6)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r1 = r2.replace(r1, r3)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r2 = "width=device-width,"
                        java.lang.String r1 = r1.replace(r2, r4)     // Catch:{ Exception -> 0x0022 }
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0022 }
                        r2.<init>()     // Catch:{ Exception -> 0x0022 }
                        r2.append(r4)     // Catch:{ Exception -> 0x0022 }
                        r2.append(r0)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r0 = r1.replace(r0, r2)     // Catch:{ Exception -> 0x0022 }
                        net.imedicaldoctor.imd.Fragments.NEJM.NEJMViewerActivity$NEJMViewerFragment r1 = net.imedicaldoctor.imd.Fragments.NEJM.NEJMViewerActivity.NEJMViewerFragment.this     // Catch:{ Exception -> 0x0022 }
                        androidx.fragment.app.FragmentActivity r1 = r1.V1()     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r2 = "default_preferences"
                        r3 = 0
                        android.content.SharedPreferences r1 = r1.getSharedPreferences(r2, r3)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r2 = "justify"
                        boolean r1 = r1.getBoolean(r2, r9)     // Catch:{ Exception -> 0x0022 }
                        if (r1 != 0) goto L_0x0170
                        java.lang.String r0 = net.imedicaldoctor.imd.Fragments.ViewerHelperFragment.i4(r0)     // Catch:{ Exception -> 0x0022 }
                    L_0x0170:
                        java.lang.String r0 = net.imedicaldoctor.imd.Fragments.ViewerHelperFragment.h4(r0)     // Catch:{ Exception -> 0x0022 }
                        net.imedicaldoctor.imd.Fragments.NEJM.NEJMViewerActivity$NEJMViewerFragment r1 = net.imedicaldoctor.imd.Fragments.NEJM.NEJMViewerActivity.NEJMViewerFragment.this     // Catch:{ Exception -> 0x0022 }
                        r1.A4 = r0     // Catch:{ Exception -> 0x0022 }
                    L_0x0178:
                        boolean r0 = r5.x1()     // Catch:{ Exception -> 0x0022 }
                        if (r0 != 0) goto L_0x0198
                        net.imedicaldoctor.imd.Fragments.NEJM.NEJMViewerActivity$NEJMViewerFragment r0 = net.imedicaldoctor.imd.Fragments.NEJM.NEJMViewerActivity.NEJMViewerFragment.this     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r1 = "Chapter"
                        r0.m4(r1)     // Catch:{ Exception -> 0x0022 }
                        goto L_0x0198
                    L_0x0186:
                        com.google.firebase.crashlytics.FirebaseCrashlytics r1 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()
                        r1.g(r0)
                        r0.printStackTrace()
                        net.imedicaldoctor.imd.Fragments.NEJM.NEJMViewerActivity$NEJMViewerFragment r1 = net.imedicaldoctor.imd.Fragments.NEJM.NEJMViewerActivity.NEJMViewerFragment.this
                        java.lang.String r0 = r0.getLocalizedMessage()
                        r1.p4 = r0
                    L_0x0198:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.NEJM.NEJMViewerActivity.NEJMViewerFragment.AnonymousClass1.run():void");
                }
            }, new Runnable() {
                public void run() {
                    NEJMViewerFragment.this.s4();
                    String str = NEJMViewerFragment.this.p4;
                    if (str == null || str.length() <= 0) {
                        NEJMViewerFragment nEJMViewerFragment = NEJMViewerFragment.this;
                        nEJMViewerFragment.O3(nEJMViewerFragment.A4, nEJMViewerFragment.b5);
                        NEJMViewerFragment.this.p4();
                        NEJMViewerFragment.this.f3(R.menu.f1445menu_epubviewer);
                        NEJMViewerFragment.this.o2(false);
                        NEJMViewerFragment.this.G3();
                        return;
                    }
                    NEJMViewerFragment nEJMViewerFragment2 = NEJMViewerFragment.this;
                    nEJMViewerFragment2.C4(nEJMViewerFragment2.p4);
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
                            str = L4(str);
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

        public void Z3(WebView webView, String str) {
            super.Z3(webView, str);
            this.G4.g("IgnoreSmallImages();");
            this.G4.g("fixAllImages2();");
            this.G4.g("fixAllTables();");
            this.G4.g("console.log(\"images,,,,,\" + getImageList());");
        }

        public boolean e1(MenuItem menuItem) {
            if (menuItem.getItemId() == R.id.f799action_gallery) {
                M4("soheilvb");
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
            String str6;
            String str7 = str;
            String str8 = str2;
            String str9 = str3;
            iMDLogger.j("Override", "Url : " + str7 + ", Scheme : " + str8 + ", Resource : " + str9);
            if (str9.startsWith("//")) {
                str9 = str9.substring(2);
            }
            String str10 = str9;
            if (str8.equals("image")) {
                M4(str10);
                return true;
            }
            try {
                str10 = URLDecoder.decode(str10, "UTF-8");
            } catch (Exception e2) {
                FirebaseCrashlytics.d().g(e2);
            }
            if (str8.equals("svv")) {
                N4(this.D4.getString("Path") + str10.replace("//", ""));
                return true;
            }
            if (str8.equals(Annotation.k3) || (str8.equals("http") && str10.contains("localhost:"))) {
                CompressHelper compressHelper = new CompressHelper(r());
                String f1 = CompressHelper.f1(this.D4);
                str5 = "NEJM";
                str4 = "image";
                if (str7.contains("#")) {
                    str6 = StringUtils.splitByWholeSeparator(str7, "#")[1];
                    iMDLogger.f("Testing", "BasePath : " + f1 + ", Resource : " + str10 + ", mPath : " + this.c5);
                    StringBuilder sb = new StringBuilder();
                    sb.append(f1);
                    sb.append("/");
                    str10 = str10.replace(sb.toString(), "").replace(this.e5.getString("issueName") + "/", "");
                    if (this.c5.equalsIgnoreCase(str10)) {
                        C3(str6);
                        return true;
                    } else if (str10.endsWith("/")) {
                        C3(str6);
                        return true;
                    }
                } else {
                    str6 = "";
                }
                iMDLogger.f("Testing", "BasePath : " + f1 + ", Resource : " + str10 + ", mPath : " + this.c5);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(f1);
                sb2.append("/");
                str10 = str10.replace(sb2.toString(), "").replace(this.e5.getString("issueName") + "/", "");
                ArrayList<Bundle> V = compressHelper.V(this.D4, "Select * from contents where purl = '" + str10 + "'");
                if (V == null || V.size() == 0) {
                    CompressHelper.x2(r(), "Sorry, Document not available", 1);
                } else {
                    compressHelper.A1(this.D4, V.get(0).getString("pid"), (String[]) null, str6);
                }
            } else {
                str5 = "NEJM";
                str4 = "image";
            }
            String str11 = str2;
            if (str11.equals("opennejmimage")) {
                try {
                    Log.e("Opennejmimage", "Opennejmimage " + str10);
                    JSONObject jSONObject = new JSONObject(str10);
                    I4(jSONObject.getString(str4), jSONObject.getString(DublinCoreProperties.f27399e));
                } catch (Exception e3) {
                    FirebaseCrashlytics.d().g(e3);
                }
            }
            if (str11.equals("resourceproxy")) {
                Log.e("Resourceproxy", "Resourceproxy " + str10);
                if (str10.startsWith("video/")) {
                    str10 = str10.replace("video/", "");
                    try {
                        String string = new JSONObject(str10).getString("video");
                        String str12 = str5;
                        Log.e(str12, "Video  " + string);
                        if (string == null) {
                            return false;
                        }
                        String h1 = CompressHelper.h1(this.D4, string, "resources");
                        if (!new File(h1).exists()) {
                            String str13 = this.Q4.getBaseUrl() + "/nejm/videos-E/" + string;
                            Log.e(str12, "VideoURL  " + str13 + " Path " + h1);
                            Z2(str13, h1);
                            return true;
                        }
                        byte[] x = this.Q4.x(CompressHelper.d2(new File(h1)), string.toLowerCase(), "127");
                        String g1 = CompressHelper.g1(this.D4, "video.mp4");
                        if (new File(g1).exists()) {
                            new File(g1).delete();
                        }
                        CompressHelper.D2(new File(g1), x);
                        K4(g1);
                    } catch (Exception e4) {
                        FirebaseCrashlytics.d().g(e4);
                    }
                }
                if (str10.startsWith("audio/")) {
                    str10 = str10.replace("audio/", "");
                    try {
                        String string2 = new JSONObject(str10).getString("href");
                        if (string2 == null) {
                            string2 = CompressHelper.K1(str10);
                        }
                        String h12 = CompressHelper.h1(this.D4, string2, "resources");
                        if (!new File(h12).exists()) {
                            Z2(this.Q4.getBaseUrl() + "/nejm/audios-E/" + string2, h12);
                        }
                        byte[] x2 = this.Q4.x(CompressHelper.d2(new File(h12)), string2.toLowerCase(), "127");
                        String g12 = CompressHelper.g1(this.D4, "audio.mp3");
                        if (new File(g12).exists()) {
                            new File(g12).delete();
                        }
                        CompressHelper.D2(new File(g12), x2);
                        K4(g12);
                    } catch (Exception e6) {
                        FirebaseCrashlytics.d().g(e6);
                    }
                }
                if (str10.startsWith("doi/")) {
                    String K1 = CompressHelper.K1(str10);
                    ArrayList<Bundle> V2 = this.Q4.V(this.D4, "Select * from contents where purl like '%" + K1 + "%'");
                    if (V2 == null || V2.size() == 0) {
                        CompressHelper.x2(r(), "Sorry, Document not available", 1);
                        return true;
                    }
                    this.Q4.A1(this.D4, V2.get(0).getString("pid"), (String[]) null, (String) null);
                }
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.f1175activity_general_viewer);
        Y0(new NEJMViewerFragment(), bundle);
    }
}
