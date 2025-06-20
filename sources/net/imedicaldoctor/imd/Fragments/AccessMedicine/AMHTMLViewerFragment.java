package net.imedicaldoctor.imd.Fragments.AccessMedicine;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebView;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.R;

public class AMHTMLViewerFragment extends ViewerHelperFragment {
    public void I4() {
    }

    public String R2() {
        return CompressHelper.C(this.D4);
    }

    public void T0(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.f1417menu_amviewer, menu);
        q4(menu);
        e3(menu);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00e9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View onFragmentBind(android.view.LayoutInflater r6, android.view.ViewGroup r7, android.os.Bundle r8) {
        /*
            r5 = this;
            java.lang.String r0 = ""
            android.view.View r1 = r5.C4
            if (r1 == 0) goto L_0x0007
            return r1
        L_0x0007:
            r1 = 2131558545(0x7f0d0091, float:1.8742409E38)
            r2 = 0
            android.view.View r6 = r6.inflate(r1, r7, r2)
            r5.r4(r6, r8)
            android.os.Bundle r7 = r5.y()
            if (r7 != 0) goto L_0x0019
            return r6
        L_0x0019:
            net.imedicaldoctor.imd.Data.CompressHelper r7 = new net.imedicaldoctor.imd.Data.CompressHelper     // Catch:{ Exception -> 0x002d }
            androidx.fragment.app.FragmentActivity r8 = r5.r()     // Catch:{ Exception -> 0x002d }
            r7.<init>(r8)     // Catch:{ Exception -> 0x002d }
            java.lang.String r7 = r5.A4     // Catch:{ Exception -> 0x002d }
            if (r7 == 0) goto L_0x0030
            int r7 = r7.length()     // Catch:{ Exception -> 0x002d }
            if (r7 != 0) goto L_0x00b7
            goto L_0x0030
        L_0x002d:
            r7 = move-exception
            goto L_0x00f9
        L_0x0030:
            java.lang.String r7 = r5.E4     // Catch:{ Exception -> 0x002d }
            java.lang.String r8 = "file"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x002d }
            if (r7 == 0) goto L_0x004d
            android.os.Bundle r7 = r5.D4     // Catch:{ Exception -> 0x002d }
            java.lang.String r8 = "temp.html"
            java.lang.String r7 = net.imedicaldoctor.imd.Data.CompressHelper.g1(r7, r8)     // Catch:{ Exception -> 0x002d }
            java.io.File r8 = new java.io.File     // Catch:{ Exception -> 0x002d }
            r8.<init>(r7)     // Catch:{ Exception -> 0x002d }
            java.lang.String r7 = net.imedicaldoctor.imd.Data.CompressHelper.e2(r8)     // Catch:{ Exception -> 0x002d }
            r5.E4 = r7     // Catch:{ Exception -> 0x002d }
        L_0x004d:
            java.lang.String r7 = r5.E4     // Catch:{ Exception -> 0x002d }
            java.lang.String r8 = "html-"
            java.lang.String r7 = r7.replace(r8, r0)     // Catch:{ Exception -> 0x002d }
            java.lang.String r8 = ",,,,,"
            java.lang.String[] r7 = org.apache.commons.lang3.StringUtils.splitByWholeSeparator(r7, r8)     // Catch:{ Exception -> 0x002d }
            r8 = r7[r2]     // Catch:{ Exception -> 0x002d }
            r5.F4 = r8     // Catch:{ Exception -> 0x002d }
            r8 = 1
            r7 = r7[r8]     // Catch:{ Exception -> 0x002d }
            android.os.Bundle r8 = r5.D4     // Catch:{ Exception -> 0x002d }
            java.lang.String r1 = "Type"
            java.lang.String r8 = r8.getString(r1)     // Catch:{ Exception -> 0x002d }
            java.lang.String r1 = "accessmedicine"
            boolean r8 = r8.equals(r1)     // Catch:{ Exception -> 0x002d }
            if (r8 == 0) goto L_0x009f
            androidx.fragment.app.FragmentActivity r8 = r5.r()     // Catch:{ Exception -> 0x002d }
            java.lang.String r0 = "AMHeader.css"
            java.lang.String r8 = r5.d4(r8, r0)     // Catch:{ Exception -> 0x002d }
            androidx.fragment.app.FragmentActivity r0 = r5.r()     // Catch:{ Exception -> 0x002d }
            java.lang.String r1 = "AMFooter.css"
            java.lang.String r0 = r5.d4(r0, r1)     // Catch:{ Exception -> 0x002d }
            java.lang.String r1 = "[size]"
            java.lang.String r3 = "200"
            java.lang.String r8 = r8.replace(r1, r3)     // Catch:{ Exception -> 0x002d }
            java.lang.String r1 = "[title]"
            java.lang.String r3 = r5.F4     // Catch:{ Exception -> 0x002d }
            java.lang.String r8 = r8.replace(r1, r3)     // Catch:{ Exception -> 0x002d }
            java.lang.String r1 = "mgh.Popup.Dialog.js"
            r5.l3(r1)     // Catch:{ Exception -> 0x002d }
            r4 = r0
            r0 = r8
            r8 = r4
            goto L_0x00a0
        L_0x009f:
            r8 = r0
        L_0x00a0:
            r5.m3()     // Catch:{ Exception -> 0x002d }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x002d }
            r1.<init>()     // Catch:{ Exception -> 0x002d }
            r1.append(r0)     // Catch:{ Exception -> 0x002d }
            r1.append(r7)     // Catch:{ Exception -> 0x002d }
            r1.append(r8)     // Catch:{ Exception -> 0x002d }
            java.lang.String r7 = r1.toString()     // Catch:{ Exception -> 0x002d }
            r5.A4 = r7     // Catch:{ Exception -> 0x002d }
        L_0x00b7:
            android.os.Bundle r7 = r5.D4     // Catch:{ Exception -> 0x002d }
            java.lang.String r8 = "base"
            java.lang.String r7 = net.imedicaldoctor.imd.Data.CompressHelper.g1(r7, r8)     // Catch:{ Exception -> 0x002d }
            java.lang.String r8 = r5.A4     // Catch:{ Exception -> 0x002d }
            r5.O3(r8, r7)     // Catch:{ Exception -> 0x002d }
            r5.s4()     // Catch:{ Exception -> 0x002d }
            android.os.Bundle r7 = r5.y()
            if (r7 == 0) goto L_0x00e9
            android.os.Bundle r7 = r5.y()
            java.lang.String r8 = "Dialog"
            boolean r7 = r7.containsKey(r8)
            if (r7 == 0) goto L_0x00e9
            java.lang.String r7 = r5.F4
            if (r7 != 0) goto L_0x00e1
            java.lang.String r7 = "Unknown"
            r5.F4 = r7
        L_0x00e1:
            androidx.appcompat.widget.Toolbar r7 = r5.L4
            java.lang.String r8 = r5.F4
            r7.setTitle((java.lang.CharSequence) r8)
            goto L_0x00f2
        L_0x00e9:
            r5.p4()
            r7 = 2131689513(0x7f0f0029, float:1.9008043E38)
            r5.f3(r7)
        L_0x00f2:
            r5.o2(r2)
            r5.G3()
            return r6
        L_0x00f9:
            com.google.firebase.crashlytics.FirebaseCrashlytics r8 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()
            r8.g(r7)
            r5.B4(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.AccessMedicine.AMHTMLViewerFragment.U0(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    public void Z3(WebView webView, String str) {
        this.G4.g("adjustTableLinks()");
        super.Z3(webView, str);
    }

    public boolean e1(MenuItem menuItem) {
        menuItem.getItemId();
        return super.e1(menuItem);
    }

    public void e3(Menu menu) {
        menu.removeItem(R.id.f799action_gallery);
        menu.removeItem(R.id.f801action_menu);
    }

    public void t3(String str) {
        I4();
        super.t3(str);
    }

    public boolean v4() {
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0155, code lost:
        if (r9.getString("sectionId").equals(r7.E4) != false) goto L_0x0190;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x018e, code lost:
        if (r9.getString("sectionId").equals(r7.E4) != false) goto L_0x0190;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0194, code lost:
        r7.Q4.A1(r7.D4, r9.getString("sectionId"), (java.lang.String[]) null, r8);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean y4(android.webkit.WebView r8, java.lang.String r9, java.lang.String r10, java.lang.String r11) {
        /*
            r7 = this;
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "Url : "
            r8.append(r0)
            r8.append(r9)
            java.lang.String r0 = ", Scheme : "
            r8.append(r0)
            r8.append(r10)
            java.lang.String r0 = ", Resource : "
            r8.append(r0)
            r8.append(r11)
            java.lang.String r8 = r8.toString()
            java.lang.String r0 = "Override"
            net.imedicaldoctor.imd.iMDLogger.j(r0, r8)
            java.lang.String r8 = "tabledialog"
            boolean r8 = r10.equals(r8)
            r0 = 1
            if (r8 == 0) goto L_0x0053
            java.lang.String r8 = "//"
            java.lang.String r9 = ""
            java.lang.String r8 = r11.replace(r8, r9)
            net.imedicaldoctor.imd.Utils.iMDWebView r9 = r7.G4
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "console.log('tableAction,,,,,' +  document.getElementById(\""
            r10.append(r11)
            r10.append(r8)
            java.lang.String r8 = "\").innerHTML)"
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            r9.g(r8)
            return r0
        L_0x0053:
            java.lang.String r8 = "MultimediaPlayer.aspx"
            boolean r8 = r11.contains(r8)
            java.lang.String r1 = "&"
            if (r8 == 0) goto L_0x0079
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r11)
            r8.append(r1)
            java.lang.String r8 = r8.toString()
            java.lang.String r9 = "MultimediaID="
            net.imedicaldoctor.imd.Data.CompressHelper.f(r8, r9, r1)
            net.imedicaldoctor.imd.Utils.iMDWebView r8 = r7.G4
            java.lang.String r9 = "$(document).trigger('click')"
            r8.g(r9)
            return r0
        L_0x0079:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r11)
            r8.append(r1)
            java.lang.String r8 = r8.toString()
            java.lang.String r11 = "file"
            boolean r11 = r10.equals(r11)
            if (r11 != 0) goto L_0x009f
            java.lang.String r11 = "http"
            boolean r11 = r10.equals(r11)
            java.lang.String r2 = "localhost:"
            boolean r2 = r8.contains(r2)
            r11 = r11 & r2
            if (r11 == 0) goto L_0x019f
        L_0x009f:
            java.lang.String r11 = "content.aspx"
            boolean r11 = r8.contains(r11)
            r2 = 0
            if (r11 == 0) goto L_0x0119
            java.lang.String r9 = "bookid="
            boolean r10 = r8.contains(r9)
            if (r10 == 0) goto L_0x00d7
            java.lang.String r9 = net.imedicaldoctor.imd.Data.CompressHelper.f(r8, r9, r1)
            android.os.Bundle r10 = r7.D4
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r9)
            java.lang.String r9 = ".db"
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            java.lang.String r9 = net.imedicaldoctor.imd.Data.CompressHelper.g1(r10, r9)
            java.io.File r10 = new java.io.File
            r10.<init>(r9)
            boolean r9 = r10.exists()
            if (r9 != 0) goto L_0x00d7
            return r0
        L_0x00d7:
            java.lang.String r9 = "sectionid="
            boolean r10 = r8.contains(r9)
            if (r10 == 0) goto L_0x00e4
            java.lang.String r8 = net.imedicaldoctor.imd.Data.CompressHelper.f(r8, r9, r1)
            goto L_0x010f
        L_0x00e4:
            java.lang.String r9 = "aid="
            boolean r10 = r8.contains(r9)
            if (r10 == 0) goto L_0x0118
            java.lang.String r8 = net.imedicaldoctor.imd.Data.CompressHelper.f(r8, r9, r1)
            net.imedicaldoctor.imd.Data.CompressHelper r9 = r7.Q4
            android.os.Bundle r10 = r7.D4
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r1 = "Select * from docs where aid="
            r11.append(r1)
            r11.append(r8)
            java.lang.String r11 = r11.toString()
            android.os.Bundle r9 = r9.e0(r10, r11)
            if (r9 == 0) goto L_0x010f
            r7.C3(r8)
            return r0
        L_0x010f:
            net.imedicaldoctor.imd.Data.CompressHelper r9 = r7.Q4
            android.os.Bundle r10 = r7.D4
            r9.A1(r10, r8, r2, r8)
            goto L_0x019f
        L_0x0118:
            return r0
        L_0x0119:
            java.lang.String r11 = "#"
            boolean r3 = r8.contains(r11)
            java.lang.String r4 = "'"
            java.lang.String r5 = "Select * from Allsections where section = '"
            java.lang.String r6 = "sectionId"
            if (r3 == 0) goto L_0x0158
            java.lang.String r8 = net.imedicaldoctor.imd.Data.CompressHelper.f(r8, r11, r1)
            net.imedicaldoctor.imd.Data.CompressHelper r9 = r7.Q4
            android.os.Bundle r10 = r7.D4
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r5)
            r11.append(r8)
            r11.append(r4)
            java.lang.String r11 = r11.toString()
            android.os.Bundle r9 = r9.e0(r10, r11)
            if (r9 == 0) goto L_0x014b
            r7.C3(r8)
            return r0
        L_0x014b:
            java.lang.String r10 = r9.getString(r6)
            java.lang.String r11 = r7.E4
            boolean r10 = r10.equals(r11)
            if (r10 == 0) goto L_0x0194
            goto L_0x0190
        L_0x0158:
            java.lang.String r8 = "contentref"
            boolean r8 = r10.equals(r8)
            if (r8 == 0) goto L_0x019f
            java.lang.String r8 = net.imedicaldoctor.imd.Data.CompressHelper.f(r9, r11, r1)
            net.imedicaldoctor.imd.Data.CompressHelper r9 = r7.Q4
            android.os.Bundle r10 = r7.D4
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r5)
            r11.append(r8)
            r11.append(r4)
            java.lang.String r11 = r11.toString()
            android.os.Bundle r9 = r9.e0(r10, r11)
            if (r9 == 0) goto L_0x0184
            r7.C3(r8)
            return r0
        L_0x0184:
            java.lang.String r10 = r9.getString(r6)
            java.lang.String r11 = r7.E4
            boolean r10 = r10.equals(r11)
            if (r10 == 0) goto L_0x0194
        L_0x0190:
            r7.C3(r8)
            goto L_0x019f
        L_0x0194:
            net.imedicaldoctor.imd.Data.CompressHelper r10 = r7.Q4
            android.os.Bundle r11 = r7.D4
            java.lang.String r9 = r9.getString(r6)
            r10.A1(r11, r9, r2, r8)
        L_0x019f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.AccessMedicine.AMHTMLViewerFragment.y4(android.webkit.WebView, java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    public boolean z4() {
        if (y() == null || !y().containsKey("Dialog")) {
            return B().getSharedPreferences("default_preferences", 0).getBoolean("NestedScroll", true);
        }
        return false;
    }
}
