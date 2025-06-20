package net.imedicaldoctor.imd.Fragments.Epocrate;

import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.R;

public class EPOGuidelineViewerActivityFragment extends ViewerHelperFragment {
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00f9 A[Catch:{ Exception -> 0x002c }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00fa A[Catch:{ Exception -> 0x002c }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:39:0x014b=Splitter:B:39:0x014b, B:28:0x00ad=Splitter:B:28:0x00ad} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View U0(android.view.LayoutInflater r9, android.view.ViewGroup r10, android.os.Bundle r11) {
        /*
            r8 = this;
            java.lang.String r0 = ">"
            java.lang.String r1 = "<body"
            java.lang.String r2 = ""
            android.view.View r3 = r8.C4
            if (r3 == 0) goto L_0x000b
            return r3
        L_0x000b:
            r3 = 2131558547(0x7f0d0093, float:1.8742413E38)
            r4 = 0
            android.view.View r9 = r9.inflate(r3, r10, r4)
            r8.C4 = r9
            r8.r4(r9, r11)
            android.os.Bundle r9 = r8.y()
            if (r9 != 0) goto L_0x0021
            android.view.View r9 = r8.C4
            return r9
        L_0x0021:
            java.lang.String r9 = r8.A4     // Catch:{ Exception -> 0x002c }
            if (r9 == 0) goto L_0x002f
            int r9 = r9.length()     // Catch:{ Exception -> 0x002c }
            if (r9 != 0) goto L_0x0129
            goto L_0x002f
        L_0x002c:
            r9 = move-exception
            goto L_0x0157
        L_0x002f:
            java.lang.String r9 = "Loading Document"
            java.lang.String r10 = r8.E4     // Catch:{ Exception -> 0x002c }
            net.imedicaldoctor.imd.iMDLogger.f(r9, r10)     // Catch:{ Exception -> 0x002c }
            java.lang.String r9 = r8.E4     // Catch:{ Exception -> 0x002c }
            java.lang.String r10 = "-"
            java.lang.String[] r9 = r9.split(r10)     // Catch:{ Exception -> 0x002c }
            r10 = 1
            r9 = r9[r10]     // Catch:{ Exception -> 0x002c }
            net.imedicaldoctor.imd.Data.CompressHelper r11 = r8.Q4     // Catch:{ Exception -> 0x002c }
            android.os.Bundle r3 = r8.D4     // Catch:{ Exception -> 0x002c }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x002c }
            r5.<init>()     // Catch:{ Exception -> 0x002c }
            java.lang.String r6 = "Select * from gl_topics where id="
            r5.append(r6)     // Catch:{ Exception -> 0x002c }
            r5.append(r9)     // Catch:{ Exception -> 0x002c }
            java.lang.String r9 = r5.toString()     // Catch:{ Exception -> 0x002c }
            java.util.ArrayList r9 = r11.V(r3, r9)     // Catch:{ Exception -> 0x002c }
            if (r9 == 0) goto L_0x014b
            int r11 = r9.size()     // Catch:{ Exception -> 0x002c }
            if (r11 != 0) goto L_0x0064
            goto L_0x014b
        L_0x0064:
            java.lang.Object r9 = r9.get(r4)     // Catch:{ Exception -> 0x002c }
            android.os.Bundle r9 = (android.os.Bundle) r9     // Catch:{ Exception -> 0x002c }
            java.lang.String r10 = "title"
            java.lang.String r10 = r9.getString(r10)     // Catch:{ Exception -> 0x002c }
            r8.F4 = r10     // Catch:{ Exception -> 0x002c }
            net.imedicaldoctor.imd.Data.CompressHelper r10 = r8.Q4     // Catch:{ Exception -> 0x002c }
            java.lang.String r11 = "content"
            java.lang.String r11 = r9.getString(r11)     // Catch:{ Exception -> 0x002c }
            java.lang.String r3 = "id"
            java.lang.String r9 = r9.getString(r3)     // Catch:{ Exception -> 0x002c }
            java.lang.String r3 = "127"
            java.lang.String r9 = r10.B(r11, r9, r3)     // Catch:{ Exception -> 0x002c }
            java.lang.String r10 = "151/munchkin.js"
            java.lang.String r9 = r9.replace(r10, r2)     // Catch:{ Exception -> 0x002c }
            java.lang.String r10 = "https://ssl.google-analytics.com/ga.js"
            java.lang.String r9 = r9.replace(r10, r2)     // Catch:{ Exception -> 0x002c }
            java.lang.String r10 = "<body style=\"-webkit-text-size-adjust:200%;\" "
            androidx.fragment.app.FragmentActivity r11 = r8.r()     // Catch:{ Exception -> 0x00ab }
            java.lang.String r3 = "GLStyle.css"
            java.lang.String r11 = r8.d4(r11, r3)     // Catch:{ Exception -> 0x00ab }
            androidx.fragment.app.FragmentActivity r3 = r8.r()     // Catch:{ Exception -> 0x00a9 }
            java.lang.String r5 = "GLJava.css"
            java.lang.String r3 = r8.d4(r3, r5)     // Catch:{ Exception -> 0x00a9 }
            goto L_0x00cb
        L_0x00a9:
            r3 = move-exception
            goto L_0x00ad
        L_0x00ab:
            r3 = move-exception
            r11 = r2
        L_0x00ad:
            com.google.firebase.crashlytics.FirebaseCrashlytics r5 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()     // Catch:{ Exception -> 0x002c }
            r5.g(r3)     // Catch:{ Exception -> 0x002c }
            java.lang.String r5 = "EPOGuideline"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x002c }
            r6.<init>()     // Catch:{ Exception -> 0x002c }
            java.lang.String r7 = "Error in reading EPUBStyle and EPUBJava : "
            r6.append(r7)     // Catch:{ Exception -> 0x002c }
            r6.append(r3)     // Catch:{ Exception -> 0x002c }
            java.lang.String r3 = r6.toString()     // Catch:{ Exception -> 0x002c }
            net.imedicaldoctor.imd.iMDLogger.f(r5, r3)     // Catch:{ Exception -> 0x002c }
            r3 = r2
        L_0x00cb:
            java.lang.String r5 = "</head>"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x002c }
            r6.<init>()     // Catch:{ Exception -> 0x002c }
            java.lang.String r7 = "<style type=\"text/css\">"
            r6.append(r7)     // Catch:{ Exception -> 0x002c }
            r6.append(r11)     // Catch:{ Exception -> 0x002c }
            java.lang.String r11 = "</style><script type=\"text/javascript\">"
            r6.append(r11)     // Catch:{ Exception -> 0x002c }
            r6.append(r3)     // Catch:{ Exception -> 0x002c }
            java.lang.String r11 = "</script></head>"
            r6.append(r11)     // Catch:{ Exception -> 0x002c }
            java.lang.String r11 = r6.toString()     // Catch:{ Exception -> 0x002c }
            java.lang.String r9 = r9.replace(r5, r11)     // Catch:{ Exception -> 0x002c }
            java.lang.String r9 = r9.replace(r1, r10)     // Catch:{ Exception -> 0x002c }
            java.lang.String r10 = net.imedicaldoctor.imd.Data.CompressHelper.f(r9, r1, r0)     // Catch:{ Exception -> 0x002c }
            if (r10 != 0) goto L_0x00fa
            goto L_0x00fb
        L_0x00fa:
            r2 = r10
        L_0x00fb:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x002c }
            r10.<init>()     // Catch:{ Exception -> 0x002c }
            r10.append(r1)     // Catch:{ Exception -> 0x002c }
            r10.append(r2)     // Catch:{ Exception -> 0x002c }
            r10.append(r0)     // Catch:{ Exception -> 0x002c }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x002c }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x002c }
            r11.<init>()     // Catch:{ Exception -> 0x002c }
            java.lang.String r0 = "<body onload=\\\"onBodyLoad();\\\" style=\\\"-webkit-text-size-adjust:200%;\" "
            r11.append(r0)     // Catch:{ Exception -> 0x002c }
            r11.append(r2)     // Catch:{ Exception -> 0x002c }
            java.lang.String r0 = "> <script src=\"file:///android_asset/log4javascript.js\" ></script><script src=\"file:///android_asset/core.js\" ></script><script src=\"file:///android_asset/dom.js\" ></script><script src=\"file:///android_asset/domrange.js\" ></script><script src=\"file:///android_asset/wrappedrange.js\" ></script><script src=\"file:///android_asset/wrappedselection.js\" ></script><script src=\"file:///android_asset/rangy-cssclassapplier.js\" ></script><script src=\"file:///android_asset/rangy-highlighter.js\" ></script><script src=\"file:///android_asset/hightlight.js\" ></script><script src=\"file:///android_asset/find.js\" ></script>"
            r11.append(r0)     // Catch:{ Exception -> 0x002c }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x002c }
            java.lang.String r9 = r9.replace(r10, r11)     // Catch:{ Exception -> 0x002c }
            r8.A4 = r9     // Catch:{ Exception -> 0x002c }
        L_0x0129:
            android.os.Bundle r9 = r8.D4     // Catch:{ Exception -> 0x002c }
            java.lang.String r10 = "glbase"
            java.lang.String r9 = net.imedicaldoctor.imd.Data.CompressHelper.g1(r9, r10)     // Catch:{ Exception -> 0x002c }
            java.lang.String r10 = r8.A4     // Catch:{ Exception -> 0x002c }
            r8.O3(r10, r9)     // Catch:{ Exception -> 0x002c }
            r8.s4()     // Catch:{ Exception -> 0x002c }
            r8.p4()
            r9 = 2131689474(0x7f0f0002, float:1.9007964E38)
            r8.f3(r9)
            r8.o2(r4)
            r8.G3()
        L_0x0148:
            android.view.View r9 = r8.C4
            return r9
        L_0x014b:
            androidx.fragment.app.FragmentActivity r9 = r8.r()     // Catch:{ Exception -> 0x002c }
            java.lang.String r11 = "Document doesn't exist"
            net.imedicaldoctor.imd.Data.CompressHelper.x2(r9, r11, r10)     // Catch:{ Exception -> 0x002c }
            android.view.View r9 = r8.C4     // Catch:{ Exception -> 0x002c }
            return r9
        L_0x0157:
            r8.B4(r9)
            goto L_0x0148
        */
        throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.Epocrate.EPOGuidelineViewerActivityFragment.U0(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    public boolean e1(MenuItem menuItem) {
        return super.e1(menuItem);
    }

    public void e3(Menu menu) {
        menu.removeItem(R.id.f799action_gallery);
        menu.removeItem(R.id.f801action_menu);
    }

    public boolean y4(WebView webView, String str, String str2, String str3) {
        this.Q4.N1(this.D4, str);
        return true;
    }
}
