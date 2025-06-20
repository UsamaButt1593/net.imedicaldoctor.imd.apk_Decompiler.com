package net.imedicaldoctor.imd.Fragments.Dictionary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.fragment.app.FragmentManager;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.itextpdf.text.Annotation;
import com.itextpdf.tool.xml.html.HTML;
import java.io.File;
import java.net.URLDecoder;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.ViewerHelperActivity;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.iMDLogger;
import org.apache.commons.lang3.StringUtils;

public class CDicEEActivity extends ViewerHelperActivity {

    public static class CDicEEFragment extends ViewerHelperFragment {
        /* access modifiers changed from: private */
        public String X4;
        private int Y4;
        /* access modifiers changed from: private */
        public Bundle Z4;
        private String a5;
        /* access modifiers changed from: private */
        public Bundle b5;

        /* access modifiers changed from: private */
        public String N4(String str) {
            return str.replace("</S>", "</SPAN>").replace("<SC=", "<SPAN CLASS=").replace("<DC=", "<DIV CLASS=").replace("<PC=", "<P CLASS=");
        }

        public void T0(Menu menu, MenuInflater menuInflater) {
            menuInflater.inflate(R.menu.f1421menu_cdic_e, menu);
            q4(menu);
        }

        public View onFragmentBind(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View view = this.C4;
            if (view != null) {
                return view;
            }
            View inflate = layoutInflater.inflate(R.layout.f1255fragment_new_viewer, viewGroup, false);
            r4(inflate, bundle);
            if (bundle != null) {
                this.Z4 = bundle.getBundle("mSound");
                this.a5 = bundle.getString("mLastSampleSoundFileName");
                this.b5 = bundle.getBundle("mMean");
            }
            if (y() == null) {
                return inflate;
            }
            this.Y4++;
            T2(new Runnable() {
                /* JADX WARNING: Removed duplicated region for block: B:42:0x02e6 A[Catch:{ Exception -> 0x004b }] */
                /* JADX WARNING: Removed duplicated region for block: B:43:0x02f1 A[Catch:{ Exception -> 0x004b }] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r23 = this;
                        r1 = r23
                        java.lang.String r0 = "'"
                        java.lang.String r2 = "select * from LongSound where word ='"
                        net.imedicaldoctor.imd.Data.CompressHelper r3 = new net.imedicaldoctor.imd.Data.CompressHelper     // Catch:{ Exception -> 0x004b }
                        net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity$CDicEEFragment r4 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity.CDicEEFragment.this     // Catch:{ Exception -> 0x004b }
                        androidx.fragment.app.FragmentActivity r4 = r4.r()     // Catch:{ Exception -> 0x004b }
                        r3.<init>(r4)     // Catch:{ Exception -> 0x004b }
                        net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity$CDicEEFragment r4 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity.CDicEEFragment.this     // Catch:{ Exception -> 0x004b }
                        java.lang.String r4 = r4.E4     // Catch:{ Exception -> 0x004b }
                        java.lang.String r5 = "-"
                        java.lang.String[] r4 = r4.split(r5)     // Catch:{ Exception -> 0x004b }
                        r5 = 1
                        r4 = r4[r5]     // Catch:{ Exception -> 0x004b }
                        java.lang.String r6 = ",,,,,"
                        java.lang.String[] r4 = org.apache.commons.lang3.StringUtils.splitByWholeSeparator(r4, r6)     // Catch:{ Exception -> 0x004b }
                        r6 = 0
                        r7 = r4[r6]     // Catch:{ Exception -> 0x004b }
                        r5 = r4[r5]     // Catch:{ Exception -> 0x004b }
                        r8 = 2
                        r4 = r4[r8]     // Catch:{ Exception -> 0x004b }
                        net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity$CDicEEFragment r8 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity.CDicEEFragment.this     // Catch:{ Exception -> 0x004b }
                        java.lang.String r8 = r8.A4     // Catch:{ Exception -> 0x004b }
                        java.lang.String r9 = "Oxford-tmp"
                        java.lang.String r10 = "10"
                        java.lang.String r11 = "Longman-tmp"
                        java.lang.String r12 = "5"
                        if (r8 == 0) goto L_0x004e
                        int r8 = r8.length()     // Catch:{ Exception -> 0x004b }
                        if (r8 != 0) goto L_0x0041
                        goto L_0x004e
                    L_0x0041:
                        r4 = r7
                        r8 = r9
                        r20 = r10
                        r21 = r11
                        r16 = r12
                        goto L_0x02d4
                    L_0x004b:
                        r0 = move-exception
                        goto L_0x0307
                    L_0x004e:
                        net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity$CDicEEFragment r8 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity.CDicEEFragment.this     // Catch:{ Exception -> 0x004b }
                        r8.F4 = r4     // Catch:{ Exception -> 0x004b }
                        boolean r4 = r7.equals(r12)     // Catch:{ Exception -> 0x004b }
                        java.lang.String r8 = "> <script src=\"log4javascript.js\" ></script><script src=\"core.js\" ></script><script src=\"dom.js\" ></script><script src=\"domrange.js\" ></script><script src=\"wrappedrange.js\" ></script><script src=\"wrappedselection.js\" ></script><script src=\"rangy-cssclassapplier.js\" ></script><script src=\"rangy-highlighter.js\" ></script><script src=\"hightlight.js\" ></script><script src=\"find.js\" ></script>"
                        java.lang.String r13 = "<body onload=\\\"onBodyLoad();\\\" style=\\\"-webkit-text-size-adjust:200%;\" "
                        java.lang.String r14 = ""
                        java.lang.String r15 = "mean"
                        java.lang.String r6 = ")"
                        r16 = r12
                        java.lang.String r12 = ">"
                        r17 = r9
                        java.lang.String r9 = "<body"
                        r18 = r14
                        java.lang.String r14 = "127"
                        r19 = r7
                        java.lang.String r7 = "id"
                        if (r4 == 0) goto L_0x01a2
                        java.lang.String r4 = "LongMean.db"
                        r20 = r10
                        net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity$CDicEEFragment r10 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity.CDicEEFragment.this     // Catch:{ Exception -> 0x004b }
                        android.os.Bundle r10 = r10.D4     // Catch:{ Exception -> 0x004b }
                        r21 = r11
                        java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004b }
                        r11.<init>()     // Catch:{ Exception -> 0x004b }
                        r22 = r8
                        java.lang.String r8 = "select * from LongMean where id in ("
                        r11.append(r8)     // Catch:{ Exception -> 0x004b }
                        r11.append(r5)     // Catch:{ Exception -> 0x004b }
                        r11.append(r6)     // Catch:{ Exception -> 0x004b }
                        java.lang.String r5 = r11.toString()     // Catch:{ Exception -> 0x004b }
                        java.util.ArrayList r5 = r3.W(r10, r5, r4)     // Catch:{ Exception -> 0x004b }
                        android.os.Bundle r5 = r3.z(r5)     // Catch:{ Exception -> 0x004b }
                        net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity$CDicEEFragment r6 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity.CDicEEFragment.this     // Catch:{ Exception -> 0x004b }
                        android.os.Bundle unused = r6.b5 = r5     // Catch:{ Exception -> 0x004b }
                        net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity$CDicEEFragment r6 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity.CDicEEFragment.this     // Catch:{ Exception -> 0x004b }
                        android.os.Bundle r6 = r6.D4     // Catch:{ Exception -> 0x004b }
                        java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004b }
                        r8.<init>()     // Catch:{ Exception -> 0x004b }
                        r8.append(r2)     // Catch:{ Exception -> 0x004b }
                        java.lang.String r10 = "word"
                        java.lang.String r10 = r5.getString(r10)     // Catch:{ Exception -> 0x004b }
                        r8.append(r10)     // Catch:{ Exception -> 0x004b }
                        r8.append(r0)     // Catch:{ Exception -> 0x004b }
                        java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x004b }
                        java.util.ArrayList r6 = r3.W(r6, r8, r4)     // Catch:{ Exception -> 0x004b }
                        android.os.Bundle r6 = r3.z(r6)     // Catch:{ Exception -> 0x004b }
                        if (r6 != 0) goto L_0x00e9
                        net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity$CDicEEFragment r6 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity.CDicEEFragment.this     // Catch:{ Exception -> 0x004b }
                        android.os.Bundle r6 = r6.D4     // Catch:{ Exception -> 0x004b }
                        java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004b }
                        r8.<init>()     // Catch:{ Exception -> 0x004b }
                        r8.append(r2)     // Catch:{ Exception -> 0x004b }
                        java.lang.String r2 = "origWord"
                        java.lang.String r2 = r5.getString(r2)     // Catch:{ Exception -> 0x004b }
                        r8.append(r2)     // Catch:{ Exception -> 0x004b }
                        r8.append(r0)     // Catch:{ Exception -> 0x004b }
                        java.lang.String r0 = r8.toString()     // Catch:{ Exception -> 0x004b }
                        java.util.ArrayList r0 = r3.W(r6, r0, r4)     // Catch:{ Exception -> 0x004b }
                        android.os.Bundle r6 = r3.z(r0)     // Catch:{ Exception -> 0x004b }
                    L_0x00e9:
                        net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity$CDicEEFragment r0 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity.CDicEEFragment.this     // Catch:{ Exception -> 0x004b }
                        android.os.Bundle unused = r0.Z4 = r6     // Catch:{ Exception -> 0x004b }
                        java.lang.String r0 = r5.getString(r15)     // Catch:{ Exception -> 0x004b }
                        java.lang.String r2 = r5.getString(r7)     // Catch:{ Exception -> 0x004b }
                        java.lang.String r0 = r3.B(r0, r2, r14)     // Catch:{ Exception -> 0x004b }
                        java.lang.String r2 = net.imedicaldoctor.imd.Data.CompressHelper.f(r0, r9, r12)     // Catch:{ Exception -> 0x004b }
                        if (r2 != 0) goto L_0x0102
                        r2 = r18
                    L_0x0102:
                        java.lang.String r4 = "\"js.js\""
                        java.lang.String r6 = "\"file:///android_asset/js.js\""
                        java.lang.String r0 = r0.replace(r4, r6)     // Catch:{ Exception -> 0x004b }
                        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004b }
                        r4.<init>()     // Catch:{ Exception -> 0x004b }
                        r4.append(r9)     // Catch:{ Exception -> 0x004b }
                        r4.append(r2)     // Catch:{ Exception -> 0x004b }
                        r4.append(r12)     // Catch:{ Exception -> 0x004b }
                        java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x004b }
                        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004b }
                        r6.<init>()     // Catch:{ Exception -> 0x004b }
                        r6.append(r13)     // Catch:{ Exception -> 0x004b }
                        r6.append(r2)     // Catch:{ Exception -> 0x004b }
                        r2 = r22
                        r6.append(r2)     // Catch:{ Exception -> 0x004b }
                        java.lang.String r2 = r6.toString()     // Catch:{ Exception -> 0x004b }
                        java.lang.String r0 = r0.replace(r4, r2)     // Catch:{ Exception -> 0x004b }
                        net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity$CDicEEFragment r2 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity.CDicEEFragment.this     // Catch:{ Exception -> 0x004b }
                        r2.A4 = r0     // Catch:{ Exception -> 0x004b }
                        r0 = r21
                        r2.n3(r0)     // Catch:{ Exception -> 0x004b }
                        java.lang.String r2 = "resources"
                        java.lang.String r2 = r5.getString(r2)     // Catch:{ Exception -> 0x004b }
                        int r4 = r2.length()     // Catch:{ Exception -> 0x004b }
                        if (r4 != 0) goto L_0x014a
                        goto L_0x019a
                    L_0x014a:
                        java.lang.String r4 = r5.getString(r7)     // Catch:{ Exception -> 0x004b }
                        java.lang.String r2 = r3.B(r2, r4, r14)     // Catch:{ Exception -> 0x004b }
                        java.lang.String r4 = "\t"
                        java.lang.String[] r2 = org.apache.commons.lang3.StringUtils.splitByWholeSeparator(r2, r4)     // Catch:{ Exception -> 0x004b }
                        int r4 = r2.length     // Catch:{ Exception -> 0x004b }
                        r6 = 0
                    L_0x015a:
                        if (r6 >= r4) goto L_0x019a
                        r5 = r2[r6]     // Catch:{ Exception -> 0x004b }
                        net.imedicaldoctor.imd.VBHelper r7 = new net.imedicaldoctor.imd.VBHelper     // Catch:{ Exception -> 0x004b }
                        net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity$CDicEEFragment r8 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity.CDicEEFragment.this     // Catch:{ Exception -> 0x004b }
                        androidx.fragment.app.FragmentActivity r8 = r8.r()     // Catch:{ Exception -> 0x004b }
                        r7.<init>(r8)     // Catch:{ Exception -> 0x004b }
                        java.lang.String r8 = "Resources"
                        java.lang.String r7 = r7.q(r5, r8)     // Catch:{ Exception -> 0x004b }
                        java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004b }
                        r8.<init>()     // Catch:{ Exception -> 0x004b }
                        java.lang.String r9 = "LongResources/"
                        r8.append(r9)     // Catch:{ Exception -> 0x004b }
                        r8.append(r7)     // Catch:{ Exception -> 0x004b }
                        java.lang.String r7 = ".res"
                        r8.append(r7)     // Catch:{ Exception -> 0x004b }
                        java.lang.String r7 = r8.toString()     // Catch:{ Exception -> 0x004b }
                        net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity$CDicEEFragment r8 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity.CDicEEFragment.this     // Catch:{ Exception -> 0x004b }
                        android.os.Bundle r8 = r8.D4     // Catch:{ Exception -> 0x004b }
                        java.lang.String r9 = "LongResources.zip"
                        java.lang.String r8 = net.imedicaldoctor.imd.Data.CompressHelper.g1(r8, r9)     // Catch:{ Exception -> 0x004b }
                        net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity$CDicEEFragment$1$1 r9 = new net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity$CDicEEFragment$1$1     // Catch:{ Exception -> 0x004b }
                        r9.<init>(r3, r5)     // Catch:{ Exception -> 0x004b }
                        net.imedicaldoctor.imd.Decompress.f(r8, r7, r9)     // Catch:{ Exception -> 0x004b }
                        int r6 = r6 + 1
                        goto L_0x015a
                    L_0x019a:
                        r21 = r0
                        r8 = r17
                        r4 = r19
                        goto L_0x02d4
                    L_0x01a2:
                        r2 = r8
                        r8 = r10
                        r0 = r11
                        r4 = r19
                        boolean r10 = r4.equals(r8)     // Catch:{ Exception -> 0x004b }
                        if (r10 == 0) goto L_0x0232
                        java.lang.String r10 = "OxfMean.db"
                        net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity$CDicEEFragment r11 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity.CDicEEFragment.this     // Catch:{ Exception -> 0x004b }
                        android.os.Bundle r11 = r11.D4     // Catch:{ Exception -> 0x004b }
                        r20 = r8
                        java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004b }
                        r8.<init>()     // Catch:{ Exception -> 0x004b }
                        r21 = r0
                        java.lang.String r0 = "select * from OxfMean where id in ("
                        r8.append(r0)     // Catch:{ Exception -> 0x004b }
                        r8.append(r5)     // Catch:{ Exception -> 0x004b }
                        r8.append(r6)     // Catch:{ Exception -> 0x004b }
                        java.lang.String r0 = r8.toString()     // Catch:{ Exception -> 0x004b }
                        java.util.ArrayList r0 = r3.W(r11, r0, r10)     // Catch:{ Exception -> 0x004b }
                        android.os.Bundle r0 = r3.z(r0)     // Catch:{ Exception -> 0x004b }
                        net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity$CDicEEFragment r5 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity.CDicEEFragment.this     // Catch:{ Exception -> 0x004b }
                        android.os.Bundle unused = r5.b5 = r0     // Catch:{ Exception -> 0x004b }
                        java.lang.String r5 = r0.getString(r15)     // Catch:{ Exception -> 0x004b }
                        java.lang.String r0 = r0.getString(r7)     // Catch:{ Exception -> 0x004b }
                        java.lang.String r0 = r3.B(r5, r0, r14)     // Catch:{ Exception -> 0x004b }
                        java.lang.String r3 = "<BODY"
                        java.lang.String r5 = "<body onload=\"onBodyLoad();\" style=\"-webkit-text-size-adjust:200%;\""
                        java.lang.String r0 = r0.replace(r3, r5)     // Catch:{ Exception -> 0x004b }
                        java.lang.String r3 = " ontouchend=\"processClick(event)\" ontouchstart=\"touchStartCallback(event)\" ontouchmove=\"touchMoveCallback(event)\""
                        r5 = r18
                        java.lang.String r0 = r0.replace(r3, r5)     // Catch:{ Exception -> 0x004b }
                        java.lang.String r3 = net.imedicaldoctor.imd.Data.CompressHelper.f(r0, r9, r12)     // Catch:{ Exception -> 0x004b }
                        if (r3 != 0) goto L_0x01fc
                        r14 = r5
                        goto L_0x01fd
                    L_0x01fc:
                        r14 = r3
                    L_0x01fd:
                        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004b }
                        r3.<init>()     // Catch:{ Exception -> 0x004b }
                        r3.append(r9)     // Catch:{ Exception -> 0x004b }
                        r3.append(r14)     // Catch:{ Exception -> 0x004b }
                        r3.append(r12)     // Catch:{ Exception -> 0x004b }
                        java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x004b }
                        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004b }
                        r5.<init>()     // Catch:{ Exception -> 0x004b }
                        r5.append(r13)     // Catch:{ Exception -> 0x004b }
                        r5.append(r14)     // Catch:{ Exception -> 0x004b }
                        r5.append(r2)     // Catch:{ Exception -> 0x004b }
                        java.lang.String r2 = r5.toString()     // Catch:{ Exception -> 0x004b }
                        java.lang.String r0 = r0.replace(r3, r2)     // Catch:{ Exception -> 0x004b }
                        net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity$CDicEEFragment r2 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity.CDicEEFragment.this     // Catch:{ Exception -> 0x004b }
                        r8 = r17
                        r2.n3(r8)     // Catch:{ Exception -> 0x004b }
                        net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity$CDicEEFragment r2 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity.CDicEEFragment.this     // Catch:{ Exception -> 0x004b }
                        r2.A4 = r0     // Catch:{ Exception -> 0x004b }
                        goto L_0x02d4
                    L_0x0232:
                        r21 = r0
                        r20 = r8
                        r8 = r17
                        java.lang.String r0 = "15"
                        boolean r0 = r4.equals(r0)     // Catch:{ Exception -> 0x004b }
                        if (r0 == 0) goto L_0x02d4
                        java.lang.String r0 = "HWeb.db"
                        net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity$CDicEEFragment r2 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity.CDicEEFragment.this     // Catch:{ Exception -> 0x004b }
                        android.os.Bundle r2 = r2.D4     // Catch:{ Exception -> 0x004b }
                        java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004b }
                        r9.<init>()     // Catch:{ Exception -> 0x004b }
                        java.lang.String r10 = "select * from Webster where id in ("
                        r9.append(r10)     // Catch:{ Exception -> 0x004b }
                        r9.append(r5)     // Catch:{ Exception -> 0x004b }
                        r9.append(r6)     // Catch:{ Exception -> 0x004b }
                        java.lang.String r5 = r9.toString()     // Catch:{ Exception -> 0x004b }
                        java.util.ArrayList r0 = r3.W(r2, r5, r0)     // Catch:{ Exception -> 0x004b }
                        android.os.Bundle r0 = r3.z(r0)     // Catch:{ Exception -> 0x004b }
                        net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity$CDicEEFragment r2 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity.CDicEEFragment.this     // Catch:{ Exception -> 0x004b }
                        android.os.Bundle unused = r2.b5 = r0     // Catch:{ Exception -> 0x004b }
                        net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity$CDicEEFragment r2 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity.CDicEEFragment.this     // Catch:{ Exception -> 0x004b }
                        androidx.fragment.app.FragmentActivity r5 = r2.r()     // Catch:{ Exception -> 0x004b }
                        java.lang.String r6 = "WebHeader.css"
                        java.lang.String r2 = r2.d4(r5, r6)     // Catch:{ Exception -> 0x004b }
                        net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity$CDicEEFragment r5 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity.CDicEEFragment.this     // Catch:{ Exception -> 0x004b }
                        androidx.fragment.app.FragmentActivity r6 = r5.r()     // Catch:{ Exception -> 0x004b }
                        java.lang.String r9 = "WebFooter.css"
                        java.lang.String r5 = r5.d4(r6, r9)     // Catch:{ Exception -> 0x004b }
                        java.lang.String r6 = "[size]"
                        java.lang.String r9 = "200"
                        java.lang.String r2 = r2.replace(r6, r9)     // Catch:{ Exception -> 0x004b }
                        java.lang.String r6 = "[title]"
                        net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity$CDicEEFragment r9 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity.CDicEEFragment.this     // Catch:{ Exception -> 0x004b }
                        java.lang.String r9 = r9.F4     // Catch:{ Exception -> 0x004b }
                        java.lang.String r2 = r2.replace(r6, r9)     // Catch:{ Exception -> 0x004b }
                        java.lang.String r6 = r0.getString(r15)     // Catch:{ Exception -> 0x004b }
                        java.lang.String r0 = r0.getString(r7)     // Catch:{ Exception -> 0x004b }
                        java.lang.String r0 = r3.B(r6, r0, r14)     // Catch:{ Exception -> 0x004b }
                        net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity$CDicEEFragment r3 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity.CDicEEFragment.this     // Catch:{ Exception -> 0x004b }
                        java.lang.String r0 = r3.N4(r0)     // Catch:{ Exception -> 0x004b }
                        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004b }
                        r3.<init>()     // Catch:{ Exception -> 0x004b }
                        java.lang.String r6 = "<div class=\"\"  DIR=\"LTR\" >"
                        r3.append(r6)     // Catch:{ Exception -> 0x004b }
                        r3.append(r0)     // Catch:{ Exception -> 0x004b }
                        java.lang.String r0 = "</div>"
                        r3.append(r0)     // Catch:{ Exception -> 0x004b }
                        java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x004b }
                        net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity$CDicEEFragment r3 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity.CDicEEFragment.this     // Catch:{ Exception -> 0x004b }
                        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004b }
                        r6.<init>()     // Catch:{ Exception -> 0x004b }
                        r6.append(r2)     // Catch:{ Exception -> 0x004b }
                        r6.append(r0)     // Catch:{ Exception -> 0x004b }
                        r6.append(r5)     // Catch:{ Exception -> 0x004b }
                        java.lang.String r0 = r6.toString()     // Catch:{ Exception -> 0x004b }
                        r3.A4 = r0     // Catch:{ Exception -> 0x004b }
                        net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity$CDicEEFragment r0 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity.CDicEEFragment.this     // Catch:{ Exception -> 0x004b }
                        r0.m3()     // Catch:{ Exception -> 0x004b }
                    L_0x02d4:
                        net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity$CDicEEFragment r0 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity.CDicEEFragment.this     // Catch:{ Exception -> 0x004b }
                        android.os.Bundle r0 = r0.D4     // Catch:{ Exception -> 0x004b }
                        java.lang.String r2 = "base"
                        java.lang.String r0 = net.imedicaldoctor.imd.Data.CompressHelper.g1(r0, r2)     // Catch:{ Exception -> 0x004b }
                        r2 = r16
                        boolean r2 = r4.equals(r2)     // Catch:{ Exception -> 0x004b }
                        if (r2 == 0) goto L_0x02f1
                        net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity$CDicEEFragment r0 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity.CDicEEFragment.this     // Catch:{ Exception -> 0x004b }
                        android.os.Bundle r0 = r0.D4     // Catch:{ Exception -> 0x004b }
                        r2 = r21
                        java.lang.String r0 = net.imedicaldoctor.imd.Data.CompressHelper.g1(r0, r2)     // Catch:{ Exception -> 0x004b }
                        goto L_0x0301
                    L_0x02f1:
                        r2 = r20
                        boolean r2 = r4.equals(r2)     // Catch:{ Exception -> 0x004b }
                        if (r2 == 0) goto L_0x0301
                        net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity$CDicEEFragment r0 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity.CDicEEFragment.this     // Catch:{ Exception -> 0x004b }
                        android.os.Bundle r0 = r0.D4     // Catch:{ Exception -> 0x004b }
                        java.lang.String r0 = net.imedicaldoctor.imd.Data.CompressHelper.g1(r0, r8)     // Catch:{ Exception -> 0x004b }
                    L_0x0301:
                        net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity$CDicEEFragment r2 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity.CDicEEFragment.this     // Catch:{ Exception -> 0x004b }
                        java.lang.String unused = r2.X4 = r0     // Catch:{ Exception -> 0x004b }
                        goto L_0x0319
                    L_0x0307:
                        com.google.firebase.crashlytics.FirebaseCrashlytics r2 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()
                        r2.g(r0)
                        r0.printStackTrace()
                        net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity$CDicEEFragment r2 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity.CDicEEFragment.this
                        java.lang.String r0 = r0.getLocalizedMessage()
                        r2.p4 = r0
                    L_0x0319:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity.CDicEEFragment.AnonymousClass1.run():void");
                }
            }, new Runnable() {
                public void run() {
                    String str = CDicEEFragment.this.p4;
                    if (str == null || str.length() <= 0) {
                        if (!CDicEEFragment.this.Q4.x1()) {
                            CDicEEFragment cDicEEFragment = CDicEEFragment.this;
                            cDicEEFragment.m4(cDicEEFragment.F4);
                        }
                        CDicEEFragment cDicEEFragment2 = CDicEEFragment.this;
                        cDicEEFragment2.O3(cDicEEFragment2.A4, cDicEEFragment2.X4);
                        CDicEEFragment.this.s4();
                        CDicEEFragment.this.p4();
                        CDicEEFragment.this.f3(R.menu.f1421menu_cdic_e);
                        CDicEEFragment.this.o2(false);
                        CDicEEFragment.this.G3();
                        return;
                    }
                    CDicEEFragment cDicEEFragment3 = CDicEEFragment.this;
                    cDicEEFragment3.C4(cDicEEFragment3.p4);
                }
            });
            return inflate;
        }

        public boolean e1(MenuItem menuItem) {
            menuItem.getItemId();
            return super.e1(menuItem);
        }

        public void m1(Bundle bundle) {
            super.m1(bundle);
        }

        public boolean y4(WebView webView, String str, String str2, String str3) {
            String str4;
            String str5;
            WebViewDialog webViewDialog;
            FragmentManager M;
            String str6;
            String sb;
            String g1;
            String str7;
            String h1;
            String str8 = str;
            String str9 = str2;
            String str10 = str3;
            try {
                iMDLogger.j("Override", "Url : " + str8 + ", Scheme : " + str9 + ", Resource : " + str10);
                CompressHelper compressHelper = new CompressHelper(r());
                if (str9.equals("about")) {
                    String substring = StringUtils.splitByWholeSeparator(str10, "?")[0].substring(1);
                    String g12 = CompressHelper.g1(this.D4, "about" + substring);
                    compressHelper.A1(this.D4, "URL-file://" + new File(g12).getAbsolutePath(), (String[]) null, (String) null);
                    return true;
                } else if (str9.equals("firsttap")) {
                    iMDLogger.f("DicEEShould", "First Tap");
                    return true;
                } else {
                    if (!str9.equals(Annotation.k3)) {
                        if (!str9.equals("http") || !str10.contains("localhost:")) {
                            if (str9.equals("actionmenu")) {
                                StringUtils.splitByWholeSeparator(str10.replace("//", ""), "&");
                                return true;
                            }
                            String str11 = "id";
                            String str12 = "CDicEEFragment";
                            String str13 = "url";
                            String str14 = "db";
                            String str15 = ")";
                            if (str9.equals("sound")) {
                                int indexOf = str10.indexOf("src=");
                                if (indexOf < 0) {
                                    sb = compressHelper.t1(StringUtils.splitByWholeSeparator(str10, "/")).replace(".WAV", ".mp3");
                                    this.a5 = sb;
                                    if (!new File(CompressHelper.g1(this.D4, "LongSamples.zip")).exists()) {
                                        CompressHelper.x2(r(), "Not Available", 1);
                                        return true;
                                    }
                                    g1 = CompressHelper.g1(this.D4, "LongSamples.zip");
                                    str7 = "LongSamples/" + sb;
                                    h1 = CompressHelper.h1(this.D4, "LongSamples" + sb, "base");
                                } else {
                                    sb = str10.substring(indexOf + 4) + ".mp3";
                                    if (!new File(CompressHelper.g1(this.D4, "OxfSounds.zip")).exists()) {
                                        CompressHelper.x2(r(), "Not Available", 1);
                                        return true;
                                    }
                                    g1 = CompressHelper.g1(this.D4, "OxfSounds.zip");
                                    str7 = "Sounds/" + sb;
                                    h1 = CompressHelper.h1(this.D4, "OxfSamples" + sb, "base");
                                }
                            } else if (str9.equals("soundagain")) {
                                c4(CompressHelper.g1(this.D4, "LongSamples.zip"), "LongSamples/" + this.a5, CompressHelper.h1(this.D4, "LongSamples" + this.a5, "base"), this.a5);
                                return true;
                            } else {
                                if (str9.equals(HTML.Tag.C)) {
                                    String str16 = str;
                                    String str17 = str15;
                                    String f2 = CompressHelper.f(str16, "list_idx=(", str17);
                                    String f3 = CompressHelper.f(str16, "entry_idx=(", str17);
                                    CompressHelper.f(str16, "label=(", str17);
                                    if (f2.equals("5")) {
                                        String h12 = CompressHelper.h1(this.D4, "oxfordhelp.html", "Oxford-tmp");
                                        WebViewDialog webViewDialog2 = new WebViewDialog();
                                        Bundle bundle = new Bundle();
                                        bundle.putBundle(str14, this.D4);
                                        bundle.putString(str13, "file://" + new File(h12).getAbsolutePath());
                                        webViewDialog2.i2(bundle);
                                        webViewDialog2.Z2(true);
                                        webViewDialog2.A2(this, 0);
                                        webViewDialog2.e3(M(), str12);
                                        return true;
                                    }
                                    str5 = str12;
                                    String str18 = str14;
                                    if (!f2.equals(IcyHeaders.a3)) {
                                        return true;
                                    }
                                    Bundle s1 = compressHelper.s1(compressHelper.W(this.D4, "Select * from OxfExtra where id = " + f3, "OxfMean.db"));
                                    String B = compressHelper.B(s1.getString("mean"), s1.getString(str11), "127");
                                    webViewDialog = new WebViewDialog();
                                    Bundle bundle2 = new Bundle();
                                    bundle2.putBundle(str18, this.D4);
                                    bundle2.putString("baseURL", "file://" + new File(CompressHelper.g1(this.D4, "Oxford-tmp")).getAbsolutePath() + "/");
                                    bundle2.putString("htmlString", B);
                                    webViewDialog.i2(bundle2);
                                    webViewDialog.Z2(true);
                                    webViewDialog.A2(this, 0);
                                    M = M();
                                } else {
                                    String str19 = "base";
                                    String str20 = str11;
                                    str5 = str12;
                                    String str21 = str14;
                                    String str22 = str;
                                    if (str9.equals("extsnd")) {
                                        try {
                                            str6 = URLDecoder.decode(str22, "UTF-8");
                                        } catch (Exception unused) {
                                            str6 = str22;
                                        }
                                        String string = compressHelper.z(compressHelper.V(this.D4, "select * from OxfSample where wordId=" + this.b5.getString(str20) + " AND sample = '" + str6 + "'")).getString(str20);
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append(string);
                                        sb2.append(".mp3");
                                        sb = sb2.toString();
                                        String str23 = "OxfSamples" + (str10.indexOf("43464635") < 0 ? "US" : "UK");
                                        g1 = CompressHelper.g1(this.D4, str23 + ".zip");
                                        str7 = str23 + "/" + sb;
                                        h1 = CompressHelper.h1(this.D4, str23 + sb, str19);
                                    } else if (!str9.equals("image")) {
                                        return true;
                                    } else {
                                        String f4 = CompressHelper.f(str10 + ":::", "src=", ":::");
                                        String h13 = CompressHelper.h1(this.D4, "Images", "Oxford-tmp");
                                        webViewDialog = new WebViewDialog();
                                        Bundle bundle3 = new Bundle();
                                        bundle3.putBundle(str21, this.D4);
                                        bundle3.putString("baseURL", "file://" + new File(h13).getAbsolutePath() + "/");
                                        bundle3.putString("htmlString", "<html><head><meta name=\"viewport\" content=\"width=device-width; initial-scale=1.0; maximum-scale=2.0; minimum-scale=0.1; user-scalable=1\"/></head><body><img src='" + (h13 + f4 + ".jpg") + "'/></body></html>");
                                        webViewDialog.i2(bundle3);
                                        webViewDialog.Z2(true);
                                        webViewDialog.A2(this, 0);
                                        M = M();
                                    }
                                }
                                webViewDialog.e3(M, str5);
                                return true;
                            }
                            c4(g1, str7, h1, sb);
                            return true;
                        }
                    }
                    String str24 = "url";
                    String str25 = "db";
                    String str26 = "id";
                    String str27 = "CDicEEFragment";
                    String h14 = CompressHelper.h1(this.D4, "us_", "Longman-tmp");
                    String h15 = CompressHelper.h1(this.D4, "uk_", "Longman-tmp");
                    try {
                        str4 = URLDecoder.decode(str10, "UTF-8");
                    } catch (Exception e2) {
                        FirebaseCrashlytics.d().g(e2);
                        iMDLogger.f("CDicEEShould", "Error in decoding " + str10 + " : " + e2);
                        str4 = str10;
                    }
                    int indexOf2 = str4.indexOf(h14);
                    String g13 = CompressHelper.g1(this.D4, "LongSounds.zip");
                    if (indexOf2 >= 0) {
                        if (!new File(g13).exists()) {
                            CompressHelper.x2(r(), "Not Available", 1);
                            return true;
                        }
                        c4(g13, "Sounds/" + this.Z4.getString(str26) + "us.aif", CompressHelper.g1(this.D4, "USSound" + this.Z4.getString(str26) + "us.aif"), "USSound");
                        return true;
                    } else if (str4.indexOf(h15) >= 0) {
                        if (!new File(g13).exists()) {
                            CompressHelper.x2(r(), "Not Available", 1);
                            return true;
                        }
                        c4(g13, this.Z4.getString(str26) + "uk.aif", CompressHelper.g1(this.D4, "UKSound" + this.Z4.getString(str26) + "uk.aif"), "UKSound");
                        return true;
                    } else if (str4.indexOf("#") >= 0 || str4.indexOf("Oxford-tmp/hide") >= 0) {
                        return true;
                    } else {
                        WebViewDialog webViewDialog3 = new WebViewDialog();
                        Bundle bundle4 = new Bundle();
                        bundle4.putBundle(str25, this.D4);
                        bundle4.putString(str24, str8);
                        webViewDialog3.i2(bundle4);
                        webViewDialog3.Z2(true);
                        webViewDialog3.A2(this, 0);
                        webViewDialog3.e3(M(), str27);
                        return true;
                    }
                }
            } catch (Exception e3) {
                FirebaseCrashlytics.d().g(e3);
                return true;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.f1175activity_general_viewer);
        Y0(new CDicEEFragment(), bundle);
    }
}
