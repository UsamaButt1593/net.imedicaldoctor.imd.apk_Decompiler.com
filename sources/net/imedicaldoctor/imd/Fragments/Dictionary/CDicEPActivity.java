package net.imedicaldoctor.imd.Fragments.Dictionary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import java.io.File;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.ViewerHelperActivity;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.iMDLogger;
import org.apache.commons.lang3.StringUtils;

public class CDicEPActivity extends ViewerHelperActivity {

    public static class CDicEPFragment extends ViewerHelperFragment {
        public String X4;

        /* access modifiers changed from: private */
        public String I4(String str) {
            return str.replace(StringUtils.LF, "<br>");
        }

        /* access modifiers changed from: private */
        public String O4(int i2, String str, String str2) {
            return "<a name=\"f" + i2 + "\"><div id=\"h" + i2 + "\" class=\"headerExpanded\" onclick=\"collapse(f" + i2 + ");toggleHeaderExpanded(h" + i2 + ");\"><span class=\"fieldname\" style=\"font-family:X Traffic;\">" + str + "</span></div></a><div class=\"content\"  DIR=\"RTL\" id=\"f" + i2 + "\" style=\"font-family:X Traffic;\">" + str2 + "</div>";
        }

        private String P4(String str, String str2) {
            return "<div class=\"content\"  DIR=\"" + str2 + "\" style=\"font-family:\"X Traffic\";\">" + str + "</div>";
        }

        /* access modifiers changed from: private */
        public String Q4(int i2, String str, String str2) {
            return "<a name=\"f" + i2 + "\"><div id=\"h" + i2 + "\" class=\"headerExpanded\" onclick=\"collapse(f" + i2 + ");toggleHeaderExpanded(h" + i2 + ");\"><span class=\"fieldname\" style=\"font-family:X Traffic;\">" + str + "</span></div></a><div class=\"content\"  DIR=\"LTR\" id=\"f" + i2 + "\">" + str2 + "</div>";
        }

        private String R4(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            return "<a name=\"f" + str8 + "\"><div id=\"h" + str8 + "\" class=\"headerExpanded\"  DIR=\"" + str3 + "\" onclick=\"collapse(f" + str8 + ");toggleHeaderExpanded(h" + str8 + ");\"><span class=\"fieldname\" style=\"font-family:" + str2 + ";\">" + str + "</span></div></a><div class=\"content\" DIR=\"" + str7 + "\" id=\"f" + str8 + "\" style=\"font-family:" + str5 + "; " + str6 + "\">" + str4 + "</div>";
        }

        /* access modifiers changed from: private */
        public String S4(Bundle bundle) {
            String B = new CompressHelper(r()).B(bundle.getString("TLine"), bundle.getString("id"), "127");
            return "<div class=\"content\"  DIR=\"LTR\" >" + B + " <a href=\"Sample:" + bundle.getString("id") + "\"><img src=\"" + "file:///android_asset/VideoPlayer_Play.png" + "\" height=10 width=10></a></div>";
        }

        /* access modifiers changed from: private */
        public String T4(int i2, String str, String str2) {
            return "<a name=\"f" + i2 + "\"><div id=\"h" + i2 + "\" class=\"headerExpanded\" onclick=\"collapse(f" + i2 + ");toggleHeaderExpanded(h" + i2 + ");\"><span class=\"fieldname\" style=\"font-family:X Traffic;\">" + str + "</span></div></a><div class=\"content\"  DIR=\"LTR\" id=\"f" + i2 + "\">" + str2 + "</div>";
        }

        public void T0(Menu menu, MenuInflater menuInflater) {
            menuInflater.inflate(R.menu.f1421menu_cdic_e, menu);
            q4(menu);
            e3(menu);
        }

        public View U0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View view = this.C4;
            if (view != null) {
                return view;
            }
            View inflate = layoutInflater.inflate(R.layout.f1255fragment_new_viewer, viewGroup, false);
            r4(inflate, bundle);
            if (bundle != null) {
                this.X4 = bundle.getString("mSoundNumber");
            }
            if (y() == null) {
                return inflate;
            }
            T2(new Runnable() {
                /* JADX WARNING: Removed duplicated region for block: B:61:0x02f3 A[Catch:{ Exception -> 0x0022 }] */
                /* JADX WARNING: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r22 = this;
                        r1 = r22
                        java.lang.String r0 = ""
                        java.lang.String r2 = "Phonetic"
                        java.lang.String r3 = "Grammer"
                        java.lang.String r4 = "'"
                        net.imedicaldoctor.imd.Data.CompressHelper r5 = new net.imedicaldoctor.imd.Data.CompressHelper     // Catch:{ Exception -> 0x0022 }
                        net.imedicaldoctor.imd.Fragments.Dictionary.CDicEPActivity$CDicEPFragment r6 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEPActivity.CDicEPFragment.this     // Catch:{ Exception -> 0x0022 }
                        androidx.fragment.app.FragmentActivity r6 = r6.r()     // Catch:{ Exception -> 0x0022 }
                        r5.<init>(r6)     // Catch:{ Exception -> 0x0022 }
                        net.imedicaldoctor.imd.Fragments.Dictionary.CDicEPActivity$CDicEPFragment r6 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEPActivity.CDicEPFragment.this     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r6 = r6.A4     // Catch:{ Exception -> 0x0022 }
                        if (r6 == 0) goto L_0x0025
                        int r6 = r6.length()     // Catch:{ Exception -> 0x0022 }
                        if (r6 != 0) goto L_0x02ed
                        goto L_0x0025
                    L_0x0022:
                        r0 = move-exception
                        goto L_0x02fb
                    L_0x0025:
                        java.lang.String r6 = "HData.db"
                        net.imedicaldoctor.imd.Fragments.Dictionary.CDicEPActivity$CDicEPFragment r7 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEPActivity.CDicEPFragment.this     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r7 = r7.E4     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r8 = "-"
                        java.lang.String[] r7 = r7.split(r8)     // Catch:{ Exception -> 0x0022 }
                        r8 = 1
                        r7 = r7[r8]     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r9 = ",,,,,"
                        java.lang.String[] r7 = org.apache.commons.lang3.StringUtils.splitByWholeSeparator(r7, r9)     // Catch:{ Exception -> 0x0022 }
                        r9 = 0
                        r10 = r7[r9]     // Catch:{ Exception -> 0x0022 }
                        r7 = r7[r8]     // Catch:{ Exception -> 0x0022 }
                        net.imedicaldoctor.imd.Fragments.Dictionary.CDicEPActivity$CDicEPFragment r8 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEPActivity.CDicEPFragment.this     // Catch:{ Exception -> 0x0022 }
                        r8.F4 = r7     // Catch:{ Exception -> 0x0022 }
                        android.os.Bundle r8 = r8.D4     // Catch:{ Exception -> 0x0022 }
                        java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0022 }
                        r11.<init>()     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r12 = "Select english.id as id,Word,Mean,Grammer, Phonetic, USVoice, UKVoice, TCode, type, Type.id as typeId  from English Inner Join Type On English.TCode = Type.ID where english.id in ("
                        r11.append(r12)     // Catch:{ Exception -> 0x0022 }
                        r11.append(r10)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r10 = ")"
                        r11.append(r10)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r10 = r11.toString()     // Catch:{ Exception -> 0x0022 }
                        java.util.ArrayList r8 = r5.W(r8, r10, r6)     // Catch:{ Exception -> 0x0022 }
                        net.imedicaldoctor.imd.Fragments.Dictionary.CDicEPActivity$CDicEPFragment r10 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEPActivity.CDicEPFragment.this     // Catch:{ Exception -> 0x0022 }
                        android.os.Bundle r10 = r10.D4     // Catch:{ Exception -> 0x0022 }
                        java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0022 }
                        r11.<init>()     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r12 = "Select * from Sample where word = '"
                        r11.append(r12)     // Catch:{ Exception -> 0x0022 }
                        r11.append(r7)     // Catch:{ Exception -> 0x0022 }
                        r11.append(r4)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x0022 }
                        java.util.ArrayList r10 = r5.W(r10, r11, r6)     // Catch:{ Exception -> 0x0022 }
                        net.imedicaldoctor.imd.Fragments.Dictionary.CDicEPActivity$CDicEPFragment r11 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEPActivity.CDicEPFragment.this     // Catch:{ Exception -> 0x0022 }
                        android.os.Bundle r11 = r11.D4     // Catch:{ Exception -> 0x0022 }
                        java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0022 }
                        r12.<init>()     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r13 = "Select * from Verb where verb = '"
                        r12.append(r13)     // Catch:{ Exception -> 0x0022 }
                        r12.append(r7)     // Catch:{ Exception -> 0x0022 }
                        r12.append(r4)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r4 = r12.toString()     // Catch:{ Exception -> 0x0022 }
                        java.util.ArrayList r4 = r5.W(r11, r4, r6)     // Catch:{ Exception -> 0x0022 }
                        java.util.Iterator r6 = r8.iterator()     // Catch:{ Exception -> 0x0022 }
                        r11 = 0
                        r12 = r11
                        r13 = r12
                    L_0x009e:
                        boolean r14 = r6.hasNext()     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r15 = "id"
                        if (r14 == 0) goto L_0x00e7
                        java.lang.Object r14 = r6.next()     // Catch:{ Exception -> 0x0022 }
                        android.os.Bundle r14 = (android.os.Bundle) r14     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r16 = r14.getString(r3)     // Catch:{ Exception -> 0x0022 }
                        int r16 = r16.length()     // Catch:{ Exception -> 0x0022 }
                        if (r16 <= 0) goto L_0x00be
                        java.lang.String r12 = r14.getString(r3)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r13 = r14.getString(r15)     // Catch:{ Exception -> 0x0022 }
                    L_0x00be:
                        java.lang.String r16 = r14.getString(r2)     // Catch:{ Exception -> 0x0022 }
                        int r16 = r16.length()     // Catch:{ Exception -> 0x0022 }
                        if (r16 <= 0) goto L_0x00ce
                        r14.getString(r2)     // Catch:{ Exception -> 0x0022 }
                        r14.getString(r15)     // Catch:{ Exception -> 0x0022 }
                    L_0x00ce:
                        java.lang.String r9 = "USVoice"
                        java.lang.String r9 = r14.getString(r9)     // Catch:{ Exception -> 0x0022 }
                        r17 = r2
                        java.lang.String r2 = "1"
                        boolean r2 = r9.equals(r2)     // Catch:{ Exception -> 0x0022 }
                        if (r2 == 0) goto L_0x00e3
                        java.lang.String r2 = r14.getString(r15)     // Catch:{ Exception -> 0x0022 }
                        r11 = r2
                    L_0x00e3:
                        r2 = r17
                        r9 = 0
                        goto L_0x009e
                    L_0x00e7:
                        net.imedicaldoctor.imd.Fragments.Dictionary.CDicEPActivity$CDicEPFragment r2 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEPActivity.CDicEPFragment.this     // Catch:{ Exception -> 0x0022 }
                        r2.X4 = r11     // Catch:{ Exception -> 0x0022 }
                        androidx.fragment.app.FragmentActivity r3 = r2.r()     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r6 = "EPHeader.css"
                        java.lang.String r2 = r2.d4(r3, r6)     // Catch:{ Exception -> 0x0022 }
                        net.imedicaldoctor.imd.Fragments.Dictionary.CDicEPActivity$CDicEPFragment r3 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEPActivity.CDicEPFragment.this     // Catch:{ Exception -> 0x0022 }
                        androidx.fragment.app.FragmentActivity r6 = r3.r()     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r9 = "EPFooter.css"
                        java.lang.String r3 = r3.d4(r6, r9)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r6 = "[size]"
                        java.lang.String r9 = "200"
                        java.lang.String r2 = r2.replace(r6, r9)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r6 = "[title]"
                        net.imedicaldoctor.imd.Fragments.Dictionary.CDicEPActivity$CDicEPFragment r9 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEPActivity.CDicEPFragment.this     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r9 = r9.F4     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r2 = r2.replace(r6, r9)     // Catch:{ Exception -> 0x0022 }
                        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0022 }
                        r6.<init>()     // Catch:{ Exception -> 0x0022 }
                        r6.append(r0)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r9 = "</head><body><a name=\"f0\"><div class=\"title\">"
                        r6.append(r9)     // Catch:{ Exception -> 0x0022 }
                        r6.append(r7)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r7 = "</div></a>"
                        r6.append(r7)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0022 }
                        java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ Exception -> 0x0022 }
                        r7.<init>()     // Catch:{ Exception -> 0x0022 }
                        java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ Exception -> 0x0022 }
                        r9.<init>()     // Catch:{ Exception -> 0x0022 }
                        java.util.Iterator r8 = r8.iterator()     // Catch:{ Exception -> 0x0022 }
                    L_0x013a:
                        boolean r11 = r8.hasNext()     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r14 = "127"
                        if (r11 == 0) goto L_0x01a8
                        java.lang.Object r11 = r8.next()     // Catch:{ Exception -> 0x0022 }
                        android.os.Bundle r11 = (android.os.Bundle) r11     // Catch:{ Exception -> 0x0022 }
                        r17 = r0
                        java.lang.String r0 = "type"
                        java.lang.String r0 = r11.getString(r0)     // Catch:{ Exception -> 0x0022 }
                        r18 = r6
                        java.lang.String r6 = "typeId"
                        java.lang.String r6 = r11.getString(r6)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r0 = r5.B(r0, r6, r14)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r6 = "Mean"
                        java.lang.String r6 = r11.getString(r6)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r11 = r11.getString(r15)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r6 = r5.B(r6, r11, r14)     // Catch:{ Exception -> 0x0022 }
                        boolean r11 = r7.contains(r0)     // Catch:{ Exception -> 0x0022 }
                        if (r11 == 0) goto L_0x0199
                        int r11 = r7.indexOf(r0)     // Catch:{ Exception -> 0x0022 }
                        java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0022 }
                        r14.<init>()     // Catch:{ Exception -> 0x0022 }
                        java.lang.Object r19 = r9.get(r11)     // Catch:{ Exception -> 0x0022 }
                        r20 = r8
                        r8 = r19
                        java.lang.String r8 = (java.lang.String) r8     // Catch:{ Exception -> 0x0022 }
                        r14.append(r8)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r8 = "<br>"
                        r14.append(r8)     // Catch:{ Exception -> 0x0022 }
                        r14.append(r6)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r6 = r14.toString()     // Catch:{ Exception -> 0x0022 }
                        r9.remove(r11)     // Catch:{ Exception -> 0x0022 }
                        r7.remove(r11)     // Catch:{ Exception -> 0x0022 }
                        goto L_0x019b
                    L_0x0199:
                        r20 = r8
                    L_0x019b:
                        r7.add(r0)     // Catch:{ Exception -> 0x0022 }
                        r9.add(r6)     // Catch:{ Exception -> 0x0022 }
                        r0 = r17
                        r6 = r18
                        r8 = r20
                        goto L_0x013a
                    L_0x01a8:
                        r17 = r0
                        r18 = r6
                        r0 = 0
                        r8 = 0
                    L_0x01ae:
                        int r11 = r7.size()     // Catch:{ Exception -> 0x0022 }
                        if (r0 >= r11) goto L_0x0224
                        java.lang.Object r11 = r7.get(r0)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r11 = (java.lang.String) r11     // Catch:{ Exception -> 0x0022 }
                        r18 = r3
                        java.lang.String r3 = "معنی عمومی"
                        boolean r3 = r11.equals(r3)     // Catch:{ Exception -> 0x0022 }
                        if (r3 == 0) goto L_0x01f3
                        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0022 }
                        r3.<init>()     // Catch:{ Exception -> 0x0022 }
                        r3.append(r6)     // Catch:{ Exception -> 0x0022 }
                        net.imedicaldoctor.imd.Fragments.Dictionary.CDicEPActivity$CDicEPFragment r6 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEPActivity.CDicEPFragment.this     // Catch:{ Exception -> 0x0022 }
                        java.lang.Object r11 = r7.get(r0)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r11 = (java.lang.String) r11     // Catch:{ Exception -> 0x0022 }
                        r19 = r2
                        net.imedicaldoctor.imd.Fragments.Dictionary.CDicEPActivity$CDicEPFragment r2 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEPActivity.CDicEPFragment.this     // Catch:{ Exception -> 0x0022 }
                        java.lang.Object r20 = r9.get(r0)     // Catch:{ Exception -> 0x0022 }
                        r21 = r13
                        r13 = r20
                        java.lang.String r13 = (java.lang.String) r13     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r2 = r2.I4(r13)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r2 = r6.O4(r8, r11, r2)     // Catch:{ Exception -> 0x0022 }
                        r3.append(r2)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x0022 }
                    L_0x01f1:
                        r6 = r2
                        goto L_0x0219
                    L_0x01f3:
                        r19 = r2
                        r21 = r13
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0022 }
                        r2.<init>()     // Catch:{ Exception -> 0x0022 }
                        r2.append(r6)     // Catch:{ Exception -> 0x0022 }
                        net.imedicaldoctor.imd.Fragments.Dictionary.CDicEPActivity$CDicEPFragment r3 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEPActivity.CDicEPFragment.this     // Catch:{ Exception -> 0x0022 }
                        java.lang.Object r6 = r7.get(r0)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0022 }
                        java.lang.Object r11 = r9.get(r0)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r11 = (java.lang.String) r11     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r3 = r3.O4(r8, r6, r11)     // Catch:{ Exception -> 0x0022 }
                        r2.append(r3)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0022 }
                        goto L_0x01f1
                    L_0x0219:
                        int r8 = r8 + 1
                        int r0 = r0 + 1
                        r3 = r18
                        r2 = r19
                        r13 = r21
                        goto L_0x01ae
                    L_0x0224:
                        r19 = r2
                        r18 = r3
                        r21 = r13
                        if (r10 == 0) goto L_0x0273
                        int r0 = r10.size()     // Catch:{ Exception -> 0x0022 }
                        if (r0 <= 0) goto L_0x0273
                        java.util.Iterator r0 = r10.iterator()     // Catch:{ Exception -> 0x0022 }
                        r2 = r17
                    L_0x0238:
                        boolean r3 = r0.hasNext()     // Catch:{ Exception -> 0x0022 }
                        if (r3 == 0) goto L_0x025a
                        java.lang.Object r3 = r0.next()     // Catch:{ Exception -> 0x0022 }
                        android.os.Bundle r3 = (android.os.Bundle) r3     // Catch:{ Exception -> 0x0022 }
                        java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0022 }
                        r7.<init>()     // Catch:{ Exception -> 0x0022 }
                        r7.append(r2)     // Catch:{ Exception -> 0x0022 }
                        net.imedicaldoctor.imd.Fragments.Dictionary.CDicEPActivity$CDicEPFragment r2 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEPActivity.CDicEPFragment.this     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r2 = r2.S4(r3)     // Catch:{ Exception -> 0x0022 }
                        r7.append(r2)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r2 = r7.toString()     // Catch:{ Exception -> 0x0022 }
                        goto L_0x0238
                    L_0x025a:
                        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0022 }
                        r0.<init>()     // Catch:{ Exception -> 0x0022 }
                        r0.append(r6)     // Catch:{ Exception -> 0x0022 }
                        net.imedicaldoctor.imd.Fragments.Dictionary.CDicEPActivity$CDicEPFragment r3 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEPActivity.CDicEPFragment.this     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r6 = "Samples"
                        r7 = 122(0x7a, float:1.71E-43)
                        java.lang.String r2 = r3.Q4(r7, r6, r2)     // Catch:{ Exception -> 0x0022 }
                        r0.append(r2)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r6 = r0.toString()     // Catch:{ Exception -> 0x0022 }
                    L_0x0273:
                        if (r4 == 0) goto L_0x02ad
                        int r0 = r4.size()     // Catch:{ Exception -> 0x0022 }
                        if (r0 <= 0) goto L_0x02ad
                        r0 = 0
                        java.lang.Object r0 = r4.get(r0)     // Catch:{ Exception -> 0x0022 }
                        android.os.Bundle r0 = (android.os.Bundle) r0     // Catch:{ Exception -> 0x0022 }
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0022 }
                        r2.<init>()     // Catch:{ Exception -> 0x0022 }
                        r2.append(r6)     // Catch:{ Exception -> 0x0022 }
                        net.imedicaldoctor.imd.Fragments.Dictionary.CDicEPActivity$CDicEPFragment r3 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEPActivity.CDicEPFragment.this     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r4 = "Verbs"
                        java.lang.String r6 = "forms"
                        java.lang.String r6 = r0.getString(r6)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r0 = r0.getString(r15)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r0 = r5.B(r6, r0, r14)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r0 = r3.I4(r0)     // Catch:{ Exception -> 0x0022 }
                        r6 = 123(0x7b, float:1.72E-43)
                        java.lang.String r0 = r3.T4(r6, r4, r0)     // Catch:{ Exception -> 0x0022 }
                        r2.append(r0)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r6 = r2.toString()     // Catch:{ Exception -> 0x0022 }
                    L_0x02ad:
                        if (r12 == 0) goto L_0x02ce
                        r11 = r21
                        java.lang.String r0 = r5.B(r12, r11, r14)     // Catch:{ Exception -> 0x0022 }
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0022 }
                        r2.<init>()     // Catch:{ Exception -> 0x0022 }
                        r2.append(r6)     // Catch:{ Exception -> 0x0022 }
                        net.imedicaldoctor.imd.Fragments.Dictionary.CDicEPActivity$CDicEPFragment r3 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEPActivity.CDicEPFragment.this     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r4 = "گرامر"
                        r6 = 222(0xde, float:3.11E-43)
                        java.lang.String r0 = r3.Q4(r6, r4, r0)     // Catch:{ Exception -> 0x0022 }
                        r2.append(r0)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r6 = r2.toString()     // Catch:{ Exception -> 0x0022 }
                    L_0x02ce:
                        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0022 }
                        r0.<init>()     // Catch:{ Exception -> 0x0022 }
                        r2 = r19
                        r0.append(r2)     // Catch:{ Exception -> 0x0022 }
                        r0.append(r6)     // Catch:{ Exception -> 0x0022 }
                        r2 = r18
                        r0.append(r2)     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0022 }
                        net.imedicaldoctor.imd.Fragments.Dictionary.CDicEPActivity$CDicEPFragment r2 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEPActivity.CDicEPFragment.this     // Catch:{ Exception -> 0x0022 }
                        r2.m3()     // Catch:{ Exception -> 0x0022 }
                        net.imedicaldoctor.imd.Fragments.Dictionary.CDicEPActivity$CDicEPFragment r2 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEPActivity.CDicEPFragment.this     // Catch:{ Exception -> 0x0022 }
                        r2.A4 = r0     // Catch:{ Exception -> 0x0022 }
                    L_0x02ed:
                        boolean r0 = r5.x1()     // Catch:{ Exception -> 0x0022 }
                        if (r0 != 0) goto L_0x030d
                        net.imedicaldoctor.imd.Fragments.Dictionary.CDicEPActivity$CDicEPFragment r0 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEPActivity.CDicEPFragment.this     // Catch:{ Exception -> 0x0022 }
                        java.lang.String r2 = r0.F4     // Catch:{ Exception -> 0x0022 }
                        r0.m4(r2)     // Catch:{ Exception -> 0x0022 }
                        goto L_0x030d
                    L_0x02fb:
                        com.google.firebase.crashlytics.FirebaseCrashlytics r2 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()
                        r2.g(r0)
                        r0.printStackTrace()
                        net.imedicaldoctor.imd.Fragments.Dictionary.CDicEPActivity$CDicEPFragment r2 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEPActivity.CDicEPFragment.this
                        java.lang.String r0 = r0.getLocalizedMessage()
                        r2.p4 = r0
                    L_0x030d:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.Dictionary.CDicEPActivity.CDicEPFragment.AnonymousClass1.run():void");
                }
            }, new Runnable() {
                public void run() {
                    String str = CDicEPFragment.this.p4;
                    if (str == null || str.length() <= 0) {
                        String g1 = CompressHelper.g1(CDicEPFragment.this.D4, "base");
                        CDicEPFragment cDicEPFragment = CDicEPFragment.this;
                        cDicEPFragment.O3(cDicEPFragment.A4, g1);
                        CDicEPFragment.this.s4();
                        CDicEPFragment.this.p4();
                        CDicEPFragment.this.f3(R.menu.f1421menu_cdic_e);
                        CDicEPFragment.this.o2(false);
                        CDicEPFragment.this.G3();
                        return;
                    }
                    CDicEPFragment cDicEPFragment2 = CDicEPFragment.this;
                    cDicEPFragment2.C4(cDicEPFragment2.p4);
                }
            });
            return inflate;
        }

        public boolean e1(MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            if (itemId == R.id.f819action_sound_us || itemId == R.id.f818action_sound_uk) {
                new CompressHelper(r());
                String str = itemId == R.id.f819action_sound_us ? "US" : "UK";
                String str2 = str + "/" + this.X4 + ".mp3";
                new File(CompressHelper.h1(this.D4, str + this.X4 + ".mp3", "base"));
                String g1 = CompressHelper.g1(this.D4, str + ".zip");
                String h1 = CompressHelper.h1(this.D4, str + this.X4 + ".mp3", "base");
                StringBuilder sb = new StringBuilder();
                sb.append(this.X4);
                sb.append(".mp3");
                c4(g1, str2, h1, sb.toString());
            }
            return super.e1(menuItem);
        }

        public void e3(Menu menu) {
            if (this.X4 == null) {
                menu.removeItem(R.id.f818action_sound_uk);
                menu.removeItem(R.id.f819action_sound_us);
            }
        }

        public void m1(Bundle bundle) {
            super.m1(bundle);
        }

        public boolean y4(WebView webView, String str, String str2, String str3) {
            iMDLogger.j("Override", "Url : " + str + ", Scheme : " + str2 + ", Resource : " + str3);
            new CompressHelper(r());
            if (!str2.equals("sample")) {
                return true;
            }
            String g1 = CompressHelper.g1(this.D4, "Samples.zip");
            String h1 = CompressHelper.h1(this.D4, "sample" + str3 + ".mp3", "base");
            StringBuilder sb = new StringBuilder();
            sb.append(str3);
            sb.append(".mp3");
            c4(g1, "Samples/" + str3 + ".mp3", h1, sb.toString());
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.f1175activity_general_viewer);
        Y0(new CDicEPFragment(), bundle);
    }
}
