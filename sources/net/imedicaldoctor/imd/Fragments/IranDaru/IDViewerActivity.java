package net.imedicaldoctor.imd.Fragments.IranDaru;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.itextpdf.text.Annotation;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.Amirsys.ASSectionViewer;
import net.imedicaldoctor.imd.Fragments.ViewerHelperActivity;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.iMDLogger;
import org.apache.commons.lang3.StringUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class IDViewerActivity extends ViewerHelperActivity {

    public static class IDViewerFragment extends ViewerHelperFragment {
        private String X4;
        private String Y4;
        /* access modifiers changed from: private */
        public ArrayList<Bundle> Z4;

        private String M4(String str, String str2, String str3, String str4, String str5) {
            return "<div class=\"content\" DIR=\"" + str4 + "\" id=\"f" + str5 + "\" style=\"font-family:" + str2 + "; " + str3 + "\">" + str + "</div>";
        }

        /* access modifiers changed from: private */
        public String N4(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            return "<a name=\"f" + str8 + "\"><div id=\"h" + str8 + "\" class=\"headerExpanded\"  DIR=\"" + str3 + "\" text-align=\"center\" onclick=\"collapse(f" + str8 + ");toggleHeaderExpanded(h" + str8 + ");\"><span class=\"fieldname\" style=\"font-family:" + str2 + ";\">" + str + "</span></div></a><div class=\"content\" DIR=\"" + str7 + "\" id=\"f" + str8 + "\" style=\"font-family:" + str5 + "; " + str6 + "\">" + str4 + "</div>";
        }

        /* access modifiers changed from: private */
        public void O4(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
            int eventType = xmlPullParser.getEventType();
            while (eventType != 1) {
                if (eventType == 0) {
                    this.Z4 = new ArrayList<>();
                } else if (eventType == 2) {
                    Bundle P4 = P4(xmlPullParser);
                    this.X4 = P4.containsKey("TitlePe") ? P4.getString("TitlePe") : null;
                    this.Y4 = "";
                } else if (eventType != 3) {
                    if (eventType == 4) {
                        this.Y4 += xmlPullParser.getText();
                    }
                } else if (this.X4 != null && this.Y4.length() > 0) {
                    Bundle bundle = new Bundle();
                    bundle.putString("title", this.X4);
                    bundle.putString("value", this.Y4);
                    bundle.putString("element", xmlPullParser.getName());
                    this.Z4.add(bundle);
                }
                eventType = xmlPullParser.next();
            }
        }

        private Bundle P4(XmlPullParser xmlPullParser) {
            Bundle bundle = new Bundle();
            for (int i2 = 0; i2 < xmlPullParser.getAttributeCount(); i2++) {
                bundle.putString(xmlPullParser.getAttributeName(i2), xmlPullParser.getAttributeValue(i2));
            }
            return bundle;
        }

        public void T0(Menu menu, MenuInflater menuInflater) {
            menuInflater.inflate(R.menu.f1410elsviewer, menu);
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
                this.Z4 = bundle.getParcelableArrayList("mFields");
            }
            if (y() == null) {
                return inflate;
            }
            T2(new Runnable() {
                /* JADX WARNING: Removed duplicated region for block: B:139:0x06ad A[Catch:{ Exception -> 0x054f }] */
                /* JADX WARNING: Removed duplicated region for block: B:147:0x0714 A[Catch:{ Exception -> 0x0030 }] */
                /* JADX WARNING: Removed duplicated region for block: B:163:? A[RETURN, SYNTHETIC] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r40 = this;
                        r1 = r40
                        java.lang.String r2 = "fPharmGroupID"
                        java.lang.String r3 = "fMedicalGroupID"
                        java.lang.String r0 = "</root>"
                        java.lang.String r4 = "<root>"
                        java.lang.String r5 = "fDrugGenericName"
                        java.lang.String r6 = "\n"
                        java.lang.String r7 = "127"
                        java.lang.String r8 = "</td><td align=\"center\">"
                        java.lang.String r9 = ""
                        net.imedicaldoctor.imd.Data.CompressHelper r10 = new net.imedicaldoctor.imd.Data.CompressHelper     // Catch:{ Exception -> 0x0030 }
                        net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity$IDViewerFragment r11 = net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity.IDViewerFragment.this     // Catch:{ Exception -> 0x0030 }
                        androidx.fragment.app.FragmentActivity r11 = r11.r()     // Catch:{ Exception -> 0x0030 }
                        r10.<init>(r11)     // Catch:{ Exception -> 0x0030 }
                        net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity$IDViewerFragment r11 = net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity.IDViewerFragment.this     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r11 = r11.A4     // Catch:{ Exception -> 0x0030 }
                        if (r11 == 0) goto L_0x0033
                        int r11 = r11.length()     // Catch:{ Exception -> 0x0030 }
                        if (r11 != 0) goto L_0x002c
                        goto L_0x0033
                    L_0x002c:
                        r21 = r10
                        goto L_0x070e
                    L_0x0030:
                        r0 = move-exception
                        goto L_0x071c
                    L_0x0033:
                        net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity$IDViewerFragment r11 = net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity.IDViewerFragment.this     // Catch:{ Exception -> 0x0030 }
                        android.os.Bundle r11 = r11.D4     // Catch:{ Exception -> 0x0030 }
                        java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0030 }
                        r12.<init>()     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r13 = "Select * from tDrugGenerics where fDrugGenericId="
                        r12.append(r13)     // Catch:{ Exception -> 0x0030 }
                        net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity$IDViewerFragment r13 = net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity.IDViewerFragment.this     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r13 = r13.E4     // Catch:{ Exception -> 0x0030 }
                        r12.append(r13)     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x0030 }
                        java.util.ArrayList r11 = r10.V(r11, r12)     // Catch:{ Exception -> 0x0030 }
                        android.os.Bundle r11 = r10.s1(r11)     // Catch:{ Exception -> 0x0030 }
                        net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity$IDViewerFragment r12 = net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity.IDViewerFragment.this     // Catch:{ Exception -> 0x0030 }
                        android.os.Bundle r12 = r12.D4     // Catch:{ Exception -> 0x0030 }
                        java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0030 }
                        r13.<init>()     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r14 = "Select htMedicalGroup.fMedicalGroupId, fMedicalGroupname from htMedicalGroup, tMedicalGroupGenerics where tMedicalGroupGenerics.fDrugGenericId="
                        r13.append(r14)     // Catch:{ Exception -> 0x0030 }
                        net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity$IDViewerFragment r14 = net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity.IDViewerFragment.this     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r14 = r14.E4     // Catch:{ Exception -> 0x0030 }
                        r13.append(r14)     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r14 = " AND tMedicalGroupGenerics.fMedicalGroupId=htMedicalGroup.fMedicalGroupId"
                        r13.append(r14)     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x0030 }
                        java.util.ArrayList r12 = r10.V(r12, r13)     // Catch:{ Exception -> 0x0030 }
                        net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity$IDViewerFragment r13 = net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity.IDViewerFragment.this     // Catch:{ Exception -> 0x0030 }
                        android.os.Bundle r13 = r13.D4     // Catch:{ Exception -> 0x0030 }
                        java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0030 }
                        r14.<init>()     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r15 = "Select htPharmGroup.fPharmGroupId, fPharmGroupname from htPharmGroup, tPharmGroupGenerics where tPharmGroupGenerics.fDrugGenericId="
                        r14.append(r15)     // Catch:{ Exception -> 0x0030 }
                        net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity$IDViewerFragment r15 = net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity.IDViewerFragment.this     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r15 = r15.E4     // Catch:{ Exception -> 0x0030 }
                        r14.append(r15)     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r15 = " AND tPharmGroupGenerics.fPharmGroupId=htPharmGroup.fPharmGroupId"
                        r14.append(r15)     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r14 = r14.toString()     // Catch:{ Exception -> 0x0030 }
                        java.util.ArrayList r13 = r10.V(r13, r14)     // Catch:{ Exception -> 0x0030 }
                        net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity$IDViewerFragment r14 = net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity.IDViewerFragment.this     // Catch:{ Exception -> 0x0030 }
                        android.os.Bundle r14 = r14.D4     // Catch:{ Exception -> 0x0030 }
                        java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0030 }
                        r15.<init>()     // Catch:{ Exception -> 0x0030 }
                        r16 = r8
                        java.lang.String r8 = "select fDrugTradeName from tDrugTrades where fDrugGenericId="
                        r15.append(r8)     // Catch:{ Exception -> 0x0030 }
                        net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity$IDViewerFragment r8 = net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity.IDViewerFragment.this     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r8 = r8.E4     // Catch:{ Exception -> 0x0030 }
                        r15.append(r8)     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r8 = r15.toString()     // Catch:{ Exception -> 0x0030 }
                        java.util.ArrayList r8 = r10.V(r14, r8)     // Catch:{ Exception -> 0x0030 }
                        net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity$IDViewerFragment r14 = net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity.IDViewerFragment.this     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r15 = r11.getString(r5)     // Catch:{ Exception -> 0x0030 }
                        r14.F4 = r15     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r14 = "fDescription"
                        java.lang.String r14 = r11.getString(r14)     // Catch:{ Exception -> 0x0030 }
                        net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity$IDViewerFragment r15 = net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity.IDViewerFragment.this     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r15 = r15.E4     // Catch:{ Exception -> 0x0030 }
                        byte[] r14 = r10.v(r14, r15, r7)     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r15 = new java.lang.String     // Catch:{ Exception -> 0x0030 }
                        r15.<init>(r14)     // Catch:{ Exception -> 0x0030 }
                        java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0030 }
                        r14.<init>()     // Catch:{ Exception -> 0x0030 }
                        r14.append(r4)     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r4 = net.imedicaldoctor.imd.Data.CompressHelper.f(r15, r4, r0)     // Catch:{ Exception -> 0x0030 }
                        r14.append(r4)     // Catch:{ Exception -> 0x0030 }
                        r14.append(r0)     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r0 = r14.toString()     // Catch:{ Exception -> 0x0030 }
                        org.xmlpull.v1.XmlPullParser r4 = android.util.Xml.newPullParser()     // Catch:{ Exception -> 0x0030 }
                        java.io.ByteArrayInputStream r14 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x011c }
                        java.nio.charset.Charset r15 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ Exception -> 0x011c }
                        byte[] r0 = r0.getBytes(r15)     // Catch:{ Exception -> 0x011c }
                        r14.<init>(r0)     // Catch:{ Exception -> 0x011c }
                        okio.Source r0 = okio.Okio.u(r14)     // Catch:{ Exception -> 0x011c }
                        okio.BufferedSource r0 = okio.Okio.e(r0)     // Catch:{ Exception -> 0x011c }
                        java.io.InputStream r14 = r0.z()     // Catch:{ Exception -> 0x011c }
                        r0 = 0
                        r4.setInput(r14, r0)     // Catch:{ all -> 0x011e }
                        net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity$IDViewerFragment r0 = net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity.IDViewerFragment.this     // Catch:{ all -> 0x011e }
                        java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ all -> 0x011e }
                        r15.<init>()     // Catch:{ all -> 0x011e }
                        java.util.ArrayList unused = r0.Z4 = r15     // Catch:{ all -> 0x011e }
                        net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity$IDViewerFragment r0 = net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity.IDViewerFragment.this     // Catch:{ all -> 0x011e }
                        r0.O4(r4)     // Catch:{ all -> 0x011e }
                        if (r14 == 0) goto L_0x0136
                        r14.close()     // Catch:{ Exception -> 0x011c }
                        goto L_0x0136
                    L_0x011c:
                        r0 = move-exception
                        goto L_0x012c
                    L_0x011e:
                        r0 = move-exception
                        r4 = r0
                        if (r14 == 0) goto L_0x012b
                        r14.close()     // Catch:{ all -> 0x0126 }
                        goto L_0x012b
                    L_0x0126:
                        r0 = move-exception
                        r14 = r0
                        r4.addSuppressed(r14)     // Catch:{ Exception -> 0x011c }
                    L_0x012b:
                        throw r4     // Catch:{ Exception -> 0x011c }
                    L_0x012c:
                        com.google.firebase.crashlytics.FirebaseCrashlytics r4 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()     // Catch:{ Exception -> 0x0030 }
                        r4.g(r0)     // Catch:{ Exception -> 0x0030 }
                        r0.printStackTrace()     // Catch:{ Exception -> 0x0030 }
                    L_0x0136:
                        net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity$IDViewerFragment r0 = net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity.IDViewerFragment.this     // Catch:{ Exception -> 0x0030 }
                        androidx.fragment.app.FragmentActivity r4 = r0.r()     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r14 = "IDHeader.css"
                        java.lang.String r0 = r0.d4(r4, r14)     // Catch:{ Exception -> 0x0030 }
                        net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity$IDViewerFragment r4 = net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity.IDViewerFragment.this     // Catch:{ Exception -> 0x0030 }
                        androidx.fragment.app.FragmentActivity r14 = r4.r()     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r15 = "IDFooter.css"
                        java.lang.String r4 = r4.d4(r14, r15)     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r14 = "[size]"
                        java.lang.String r15 = "200"
                        java.lang.String r0 = r0.replace(r14, r15)     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r14 = "[title]"
                        net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity$IDViewerFragment r15 = net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity.IDViewerFragment.this     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r15 = r15.F4     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r0 = r0.replace(r14, r15)     // Catch:{ Exception -> 0x0030 }
                        java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0030 }
                        r14.<init>()     // Catch:{ Exception -> 0x0030 }
                        r14.append(r9)     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r15 = "<div class=\"title\" style=\"font-family:Helvetica\";>"
                        r14.append(r15)     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r5 = r11.getString(r5)     // Catch:{ Exception -> 0x0030 }
                        r14.append(r5)     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r5 = "</div>"
                        r14.append(r5)     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r5 = r14.toString()     // Catch:{ Exception -> 0x0030 }
                        if (r8 == 0) goto L_0x01b7
                        int r17 = r8.size()     // Catch:{ Exception -> 0x0030 }
                        if (r17 <= 0) goto L_0x01b7
                        java.lang.String r14 = "fDrugTradeName"
                        java.lang.String r15 = " ; "
                        java.lang.String r23 = net.imedicaldoctor.imd.Data.CompressHelper.J1(r8, r14, r15, r9, r9)     // Catch:{ Exception -> 0x0030 }
                        java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0030 }
                        r8.<init>()     // Catch:{ Exception -> 0x0030 }
                        r8.append(r5)     // Catch:{ Exception -> 0x0030 }
                        net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity$IDViewerFragment r5 = net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity.IDViewerFragment.this     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r20 = "نام های تجاری"
                        java.lang.String r21 = "X Traffic"
                        java.lang.String r22 = "LTR"
                        java.lang.String r24 = "Helvetica Light"
                        java.lang.String r25 = ""
                        java.lang.String r26 = "LTR"
                        r14 = 0
                        java.lang.String r27 = java.lang.String.valueOf(r14)     // Catch:{ Exception -> 0x0030 }
                        r19 = r5
                        java.lang.String r5 = r19.N4(r20, r21, r22, r23, r24, r25, r26, r27)     // Catch:{ Exception -> 0x0030 }
                        r8.append(r5)     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r5 = r8.toString()     // Catch:{ Exception -> 0x0030 }
                        r8 = 1
                        goto L_0x01b8
                    L_0x01b7:
                        r8 = 0
                    L_0x01b8:
                        java.lang.String r14 = "fPregnancyGroup"
                        java.lang.String r11 = r11.getString(r14)     // Catch:{ Exception -> 0x0030 }
                        net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity$IDViewerFragment r14 = net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity.IDViewerFragment.this     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r14 = r14.E4     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r23 = r10.B(r11, r14, r7)     // Catch:{ Exception -> 0x0030 }
                        if (r23 == 0) goto L_0x01f7
                        int r11 = r23.length()     // Catch:{ Exception -> 0x0030 }
                        if (r11 <= 0) goto L_0x01f7
                        java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0030 }
                        r11.<init>()     // Catch:{ Exception -> 0x0030 }
                        r11.append(r5)     // Catch:{ Exception -> 0x0030 }
                        net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity$IDViewerFragment r5 = net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity.IDViewerFragment.this     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r20 = "مصرف در حاملگی"
                        java.lang.String r21 = "X Traffic"
                        java.lang.String r22 = "LTR"
                        java.lang.String r24 = "X Traffic"
                        java.lang.String r25 = ""
                        java.lang.String r26 = "RTL"
                        java.lang.String r27 = java.lang.String.valueOf(r8)     // Catch:{ Exception -> 0x0030 }
                        r19 = r5
                        java.lang.String r5 = r19.N4(r20, r21, r22, r23, r24, r25, r26, r27)     // Catch:{ Exception -> 0x0030 }
                        r11.append(r5)     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r5 = r11.toString()     // Catch:{ Exception -> 0x0030 }
                        int r8 = r8 + 1
                    L_0x01f7:
                        if (r12 != 0) goto L_0x01fe
                        java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ Exception -> 0x0030 }
                        r12.<init>()     // Catch:{ Exception -> 0x0030 }
                    L_0x01fe:
                        java.util.Iterator r11 = r12.iterator()     // Catch:{ Exception -> 0x0030 }
                        r12 = r9
                    L_0x0203:
                        boolean r14 = r11.hasNext()     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r15 = "</a><br>"
                        r28 = r4
                        java.lang.String r4 = "\">"
                        r29 = r0
                        java.lang.String r0 = "://"
                        if (r14 == 0) goto L_0x025b
                        java.lang.Object r14 = r11.next()     // Catch:{ Exception -> 0x0030 }
                        android.os.Bundle r14 = (android.os.Bundle) r14     // Catch:{ Exception -> 0x0030 }
                        r19 = r11
                        java.lang.String r11 = "fMedicalGroupName"
                        java.lang.String r11 = r14.getString(r11)     // Catch:{ Exception -> 0x0030 }
                        r30 = r9
                        java.lang.String r9 = r14.getString(r3)     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r9 = r10.B(r11, r9, r7)     // Catch:{ Exception -> 0x0030 }
                        java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0030 }
                        r11.<init>()     // Catch:{ Exception -> 0x0030 }
                        r11.append(r12)     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r12 = "<a href=@\"medCategory://"
                        r11.append(r12)     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r12 = r14.getString(r3)     // Catch:{ Exception -> 0x0030 }
                        r11.append(r12)     // Catch:{ Exception -> 0x0030 }
                        r11.append(r0)     // Catch:{ Exception -> 0x0030 }
                        r11.append(r9)     // Catch:{ Exception -> 0x0030 }
                        r11.append(r4)     // Catch:{ Exception -> 0x0030 }
                        r11.append(r9)     // Catch:{ Exception -> 0x0030 }
                        r11.append(r15)     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r12 = r11.toString()     // Catch:{ Exception -> 0x0030 }
                        r11 = r19
                        r4 = r28
                        r0 = r29
                        r9 = r30
                        goto L_0x0203
                    L_0x025b:
                        r30 = r9
                        int r3 = r12.length()     // Catch:{ Exception -> 0x0030 }
                        if (r3 <= 0) goto L_0x028e
                        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0030 }
                        r3.<init>()     // Catch:{ Exception -> 0x0030 }
                        r3.append(r5)     // Catch:{ Exception -> 0x0030 }
                        net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity$IDViewerFragment r5 = net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity.IDViewerFragment.this     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r20 = "گروه های بالینی"
                        java.lang.String r21 = "X Traffic"
                        java.lang.String r22 = "LTR"
                        java.lang.String r24 = "X Traffic"
                        java.lang.String r25 = ""
                        java.lang.String r26 = "RTL"
                        java.lang.String r27 = java.lang.String.valueOf(r8)     // Catch:{ Exception -> 0x0030 }
                        r19 = r5
                        r23 = r12
                        java.lang.String r5 = r19.N4(r20, r21, r22, r23, r24, r25, r26, r27)     // Catch:{ Exception -> 0x0030 }
                        r3.append(r5)     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r5 = r3.toString()     // Catch:{ Exception -> 0x0030 }
                        int r8 = r8 + 1
                    L_0x028e:
                        if (r13 != 0) goto L_0x0295
                        java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ Exception -> 0x0030 }
                        r13.<init>()     // Catch:{ Exception -> 0x0030 }
                    L_0x0295:
                        java.util.Iterator r3 = r13.iterator()     // Catch:{ Exception -> 0x0030 }
                        r9 = r30
                    L_0x029b:
                        boolean r11 = r3.hasNext()     // Catch:{ Exception -> 0x0030 }
                        if (r11 == 0) goto L_0x02dd
                        java.lang.Object r11 = r3.next()     // Catch:{ Exception -> 0x0030 }
                        android.os.Bundle r11 = (android.os.Bundle) r11     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r12 = "fPharmGroupName"
                        java.lang.String r12 = r11.getString(r12)     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r13 = r11.getString(r2)     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r12 = r10.B(r12, r13, r7)     // Catch:{ Exception -> 0x0030 }
                        java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0030 }
                        r13.<init>()     // Catch:{ Exception -> 0x0030 }
                        r13.append(r9)     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r9 = "<a href=@\"pharmCategory://"
                        r13.append(r9)     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r9 = r11.getString(r2)     // Catch:{ Exception -> 0x0030 }
                        r13.append(r9)     // Catch:{ Exception -> 0x0030 }
                        r13.append(r0)     // Catch:{ Exception -> 0x0030 }
                        r13.append(r12)     // Catch:{ Exception -> 0x0030 }
                        r13.append(r4)     // Catch:{ Exception -> 0x0030 }
                        r13.append(r12)     // Catch:{ Exception -> 0x0030 }
                        r13.append(r15)     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r9 = r13.toString()     // Catch:{ Exception -> 0x0030 }
                        goto L_0x029b
                    L_0x02dd:
                        int r0 = r9.length()     // Catch:{ Exception -> 0x0030 }
                        if (r0 <= 0) goto L_0x030e
                        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0030 }
                        r0.<init>()     // Catch:{ Exception -> 0x0030 }
                        r0.append(r5)     // Catch:{ Exception -> 0x0030 }
                        net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity$IDViewerFragment r2 = net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity.IDViewerFragment.this     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r20 = "گروه های فارماکولوژی"
                        java.lang.String r21 = "X Traffic"
                        java.lang.String r22 = "LTR"
                        java.lang.String r24 = "X Traffic"
                        java.lang.String r25 = ""
                        java.lang.String r26 = "RTL"
                        java.lang.String r27 = java.lang.String.valueOf(r8)     // Catch:{ Exception -> 0x0030 }
                        r19 = r2
                        r23 = r9
                        java.lang.String r2 = r19.N4(r20, r21, r22, r23, r24, r25, r26, r27)     // Catch:{ Exception -> 0x0030 }
                        r0.append(r2)     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r5 = r0.toString()     // Catch:{ Exception -> 0x0030 }
                        int r8 = r8 + 1
                    L_0x030e:
                        net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity$IDViewerFragment r0 = net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity.IDViewerFragment.this     // Catch:{ Exception -> 0x0030 }
                        java.util.ArrayList r0 = r0.Z4     // Catch:{ Exception -> 0x0030 }
                        java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x0030 }
                    L_0x0318:
                        boolean r2 = r0.hasNext()     // Catch:{ Exception -> 0x0030 }
                        if (r2 == 0) goto L_0x06ed
                        java.lang.Object r2 = r0.next()     // Catch:{ Exception -> 0x0030 }
                        android.os.Bundle r2 = (android.os.Bundle) r2     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r3 = "value"
                        java.lang.String r3 = r2.getString(r3)     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r4 = "element"
                        java.lang.String r4 = r2.getString(r4)     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r7 = "-"
                        java.lang.String r9 = "<span style=\"font-family:Tahoma;\">-</span>"
                        java.lang.String r3 = r3.replace(r7, r9)     // Catch:{ Exception -> 0x0030 }
                        java.lang.String[] r7 = org.apache.commons.lang3.StringUtils.splitByWholeSeparator(r3, r6)     // Catch:{ Exception -> 0x0030 }
                        java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ Exception -> 0x0030 }
                        r9.<init>()     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r11 = "indications"
                        boolean r11 = r4.equals(r11)     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r12 = "products"
                        java.lang.String r13 = "<span class=\"important\">"
                        java.lang.String r14 = "<br>"
                        java.lang.String r15 = "</span>"
                        r19 = r0
                        java.lang.String r0 = ":"
                        if (r11 == 0) goto L_0x03e8
                        int r3 = r7.length     // Catch:{ Exception -> 0x0030 }
                        r11 = 0
                    L_0x0357:
                        if (r11 >= r3) goto L_0x03d1
                        r20 = r3
                        r3 = r7[r11]     // Catch:{ Exception -> 0x0030 }
                        boolean r21 = r3.contains(r0)     // Catch:{ Exception -> 0x0030 }
                        if (r21 == 0) goto L_0x03a0
                        java.lang.String[] r3 = org.apache.commons.lang3.StringUtils.splitByWholeSeparator(r3, r0)     // Catch:{ Exception -> 0x0030 }
                        r21 = r10
                        java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ Exception -> 0x0030 }
                        java.util.List r3 = java.util.Arrays.asList(r3)     // Catch:{ Exception -> 0x0030 }
                        r10.<init>(r3)     // Catch:{ Exception -> 0x0030 }
                        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0030 }
                        r3.<init>()     // Catch:{ Exception -> 0x0030 }
                        r22 = r8
                        java.lang.String r8 = "<span style=\"font-style:italic;\">"
                        r3.append(r8)     // Catch:{ Exception -> 0x0030 }
                        r8 = 0
                        java.lang.Object r18 = r10.get(r8)     // Catch:{ Exception -> 0x0030 }
                        r8 = r18
                        java.lang.String r8 = (java.lang.String) r8     // Catch:{ Exception -> 0x0030 }
                        r3.append(r8)     // Catch:{ Exception -> 0x0030 }
                        r3.append(r15)     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0030 }
                        r8 = 0
                        r10.remove(r8)     // Catch:{ Exception -> 0x0030 }
                        r10.add(r8, r3)     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r3 = org.apache.commons.lang3.StringUtils.join((java.lang.Iterable<?>) r10, (java.lang.String) r0)     // Catch:{ Exception -> 0x0030 }
                    L_0x039c:
                        r9.add(r3)     // Catch:{ Exception -> 0x0030 }
                        goto L_0x03c8
                    L_0x03a0:
                        r22 = r8
                        r21 = r10
                        java.lang.String r8 = "mg"
                        boolean r8 = r3.contains(r8)     // Catch:{ Exception -> 0x0030 }
                        if (r8 != 0) goto L_0x039c
                        java.lang.String r8 = "گرم"
                        boolean r8 = r3.contains(r8)     // Catch:{ Exception -> 0x0030 }
                        if (r8 == 0) goto L_0x03b5
                        goto L_0x039c
                    L_0x03b5:
                        java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0030 }
                        r8.<init>()     // Catch:{ Exception -> 0x0030 }
                        r8.append(r13)     // Catch:{ Exception -> 0x0030 }
                        r8.append(r3)     // Catch:{ Exception -> 0x0030 }
                        r8.append(r15)     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r3 = r8.toString()     // Catch:{ Exception -> 0x0030 }
                        goto L_0x039c
                    L_0x03c8:
                        int r11 = r11 + 1
                        r3 = r20
                        r10 = r21
                        r8 = r22
                        goto L_0x0357
                    L_0x03d1:
                        r22 = r8
                        r21 = r10
                        java.lang.String r0 = org.apache.commons.lang3.StringUtils.join((java.lang.Iterable<?>) r9, (java.lang.String) r14)     // Catch:{ Exception -> 0x0030 }
                    L_0x03d9:
                        r35 = r0
                        r23 = r2
                    L_0x03dd:
                        r24 = r4
                        r20 = r5
                        r2 = r16
                        r8 = 0
                        r16 = r12
                        goto L_0x069f
                    L_0x03e8:
                        r22 = r8
                        r21 = r10
                        boolean r8 = r4.equals(r12)     // Catch:{ Exception -> 0x0030 }
                        if (r8 == 0) goto L_0x03f7
                        java.lang.String r0 = r3.replace(r6, r14)     // Catch:{ Exception -> 0x0030 }
                        goto L_0x03d9
                    L_0x03f7:
                        java.lang.String r8 = "complications"
                        boolean r8 = r4.equals(r8)     // Catch:{ Exception -> 0x0030 }
                        if (r8 == 0) goto L_0x04a8
                        int r3 = r7.length     // Catch:{ Exception -> 0x0030 }
                        r8 = 0
                    L_0x0401:
                        if (r8 >= r3) goto L_0x049a
                        r10 = r7[r8]     // Catch:{ Exception -> 0x0030 }
                        boolean r11 = r10.contains(r0)     // Catch:{ Exception -> 0x0030 }
                        if (r11 != 0) goto L_0x0416
                        r9.add(r10)     // Catch:{ Exception -> 0x0030 }
                        r23 = r2
                        r20 = r3
                        r2 = r30
                        goto L_0x0490
                    L_0x0416:
                        java.lang.String r11 = " "
                        java.lang.String[] r10 = org.apache.commons.lang3.StringUtils.splitByWholeSeparator(r10, r11)     // Catch:{ Exception -> 0x0030 }
                        java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ Exception -> 0x0030 }
                        java.util.List r10 = java.util.Arrays.asList(r10)     // Catch:{ Exception -> 0x0030 }
                        r11.<init>(r10)     // Catch:{ Exception -> 0x0030 }
                        r10 = 0
                        java.lang.Object r20 = r11.get(r10)     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r20 = (java.lang.String) r20     // Catch:{ Exception -> 0x0030 }
                        int r10 = r20.length()     // Catch:{ Exception -> 0x0030 }
                        r20 = r3
                        r3 = 1
                        if (r10 > r3) goto L_0x0462
                        java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0030 }
                        r10.<init>()     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r3 = "<span class=\"important\" style=\"font-family:Helvetica Light;\">"
                        r10.append(r3)     // Catch:{ Exception -> 0x0030 }
                        r3 = 1
                        java.lang.Object r23 = r11.get(r3)     // Catch:{ Exception -> 0x0030 }
                        r3 = r23
                        java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0030 }
                        r23 = r2
                        r2 = r30
                        java.lang.String r3 = r3.replace(r0, r2)     // Catch:{ Exception -> 0x0030 }
                        r10.append(r3)     // Catch:{ Exception -> 0x0030 }
                        r10.append(r15)     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r3 = r10.toString()     // Catch:{ Exception -> 0x0030 }
                        r10 = 1
                        r11.remove(r10)     // Catch:{ Exception -> 0x0030 }
                    L_0x045e:
                        r11.add(r10, r3)     // Catch:{ Exception -> 0x0030 }
                        goto L_0x0487
                    L_0x0462:
                        r23 = r2
                        r2 = r30
                        r10 = 1
                        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0030 }
                        r3.<init>()     // Catch:{ Exception -> 0x0030 }
                        r3.append(r13)     // Catch:{ Exception -> 0x0030 }
                        r10 = 0
                        java.lang.Object r18 = r11.get(r10)     // Catch:{ Exception -> 0x0030 }
                        r10 = r18
                        java.lang.String r10 = (java.lang.String) r10     // Catch:{ Exception -> 0x0030 }
                        r3.append(r10)     // Catch:{ Exception -> 0x0030 }
                        r3.append(r15)     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0030 }
                        r10 = 0
                        r11.remove(r10)     // Catch:{ Exception -> 0x0030 }
                        goto L_0x045e
                    L_0x0487:
                        java.lang.String r3 = " "
                        java.lang.String r3 = org.apache.commons.lang3.StringUtils.join((java.lang.Iterable<?>) r11, (java.lang.String) r3)     // Catch:{ Exception -> 0x0030 }
                        r9.add(r3)     // Catch:{ Exception -> 0x0030 }
                    L_0x0490:
                        int r8 = r8 + 1
                        r30 = r2
                        r3 = r20
                        r2 = r23
                        goto L_0x0401
                    L_0x049a:
                        r23 = r2
                        r2 = r30
                        java.lang.String r0 = org.apache.commons.lang3.StringUtils.join((java.lang.Iterable<?>) r9, (java.lang.String) r14)     // Catch:{ Exception -> 0x0030 }
                        r35 = r0
                        r30 = r2
                        goto L_0x03dd
                    L_0x04a8:
                        r23 = r2
                        r2 = r30
                        java.lang.String r8 = "pharmaco"
                        boolean r8 = r4.equals(r8)     // Catch:{ Exception -> 0x0030 }
                        if (r8 == 0) goto L_0x0647
                        java.util.List r8 = java.util.Arrays.asList(r7)     // Catch:{ Exception -> 0x054f }
                        java.lang.String r10 = "راه مصرف"
                        boolean r8 = r8.contains(r10)     // Catch:{ Exception -> 0x054f }
                        if (r8 == 0) goto L_0x05ed
                        java.util.List r3 = java.util.Arrays.asList(r7)     // Catch:{ Exception -> 0x054f }
                        java.lang.String r8 = "راه مصرف"
                        int r3 = r3.indexOf(r8)     // Catch:{ Exception -> 0x054f }
                        r8 = 0
                        java.lang.Object[] r10 = java.util.Arrays.copyOfRange(r7, r8, r3)     // Catch:{ Exception -> 0x054f }
                        java.lang.String[] r10 = (java.lang.String[]) r10     // Catch:{ Exception -> 0x054f }
                        java.lang.String r8 = org.apache.commons.lang3.StringUtils.join((java.lang.Object[]) r10, (java.lang.String) r6)     // Catch:{ Exception -> 0x054f }
                        java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ Exception -> 0x054f }
                        r10.<init>()     // Catch:{ Exception -> 0x054f }
                        java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x054f }
                        r11.<init>()     // Catch:{ Exception -> 0x054f }
                        r30 = r2
                        java.lang.String r2 = "<table align=\"center\"><tr><td align=\"center\">"
                        r11.append(r2)     // Catch:{ Exception -> 0x054f }
                        r2 = r7[r3]     // Catch:{ Exception -> 0x054f }
                        r11.append(r2)     // Catch:{ Exception -> 0x054f }
                        r2 = r16
                        r11.append(r2)     // Catch:{ Exception -> 0x054f }
                        int r16 = r3 + 1
                        r1 = r7[r16]     // Catch:{ Exception -> 0x054f }
                        r11.append(r1)     // Catch:{ Exception -> 0x054f }
                        r11.append(r2)     // Catch:{ Exception -> 0x054f }
                        int r1 = r3 + 2
                        r20 = r5
                        r5 = r7[r1]     // Catch:{ Exception -> 0x054f }
                        r11.append(r5)     // Catch:{ Exception -> 0x054f }
                        r11.append(r2)     // Catch:{ Exception -> 0x054f }
                        int r5 = r3 + 3
                        r24 = r4
                        r4 = r7[r5]     // Catch:{ Exception -> 0x054f }
                        r11.append(r4)     // Catch:{ Exception -> 0x054f }
                        java.lang.String r4 = "</td></tr>"
                        r11.append(r4)     // Catch:{ Exception -> 0x054f }
                        java.lang.String r4 = r11.toString()     // Catch:{ Exception -> 0x054f }
                        r11 = r7[r3]     // Catch:{ Exception -> 0x054f }
                        r10.add(r11)     // Catch:{ Exception -> 0x054f }
                        r11 = r7[r16]     // Catch:{ Exception -> 0x054f }
                        r10.add(r11)     // Catch:{ Exception -> 0x054f }
                        r1 = r7[r1]     // Catch:{ Exception -> 0x054f }
                        r10.add(r1)     // Catch:{ Exception -> 0x054f }
                        r1 = r7[r5]     // Catch:{ Exception -> 0x054f }
                        r10.add(r1)     // Catch:{ Exception -> 0x054f }
                        int r3 = r3 + 4
                    L_0x052e:
                        int r1 = r7.length     // Catch:{ Exception -> 0x054f }
                        int r5 = r3 + 4
                        if (r1 < r5) goto L_0x0554
                        r1 = r7[r3]     // Catch:{ Exception -> 0x054f }
                        r10.add(r1)     // Catch:{ Exception -> 0x054f }
                        int r1 = r3 + 1
                        r1 = r7[r1]     // Catch:{ Exception -> 0x054f }
                        r10.add(r1)     // Catch:{ Exception -> 0x054f }
                        int r1 = r3 + 2
                        r1 = r7[r1]     // Catch:{ Exception -> 0x054f }
                        r10.add(r1)     // Catch:{ Exception -> 0x054f }
                        int r3 = r3 + 3
                        r1 = r7[r3]     // Catch:{ Exception -> 0x054f }
                        r10.add(r1)     // Catch:{ Exception -> 0x054f }
                        r3 = r5
                        goto L_0x052e
                    L_0x054f:
                        r0 = move-exception
                        r1 = r40
                        goto L_0x071c
                    L_0x0554:
                        int r1 = r10.size()     // Catch:{ Exception -> 0x054f }
                        r5 = 4
                        int r1 = r1 / r5
                        int r11 = r1 + -1
                    L_0x055c:
                        r16 = r12
                        int r12 = r1 + 3
                        if (r5 >= r12) goto L_0x05b2
                        java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x054f }
                        r12.<init>()     // Catch:{ Exception -> 0x054f }
                        r12.append(r4)     // Catch:{ Exception -> 0x054f }
                        java.lang.String r4 = "<tr><td align=\"center\">"
                        r12.append(r4)     // Catch:{ Exception -> 0x054f }
                        java.lang.Object r4 = r10.get(r5)     // Catch:{ Exception -> 0x054f }
                        java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x054f }
                        r12.append(r4)     // Catch:{ Exception -> 0x054f }
                        r12.append(r2)     // Catch:{ Exception -> 0x054f }
                        int r4 = r5 + r11
                        java.lang.Object r4 = r10.get(r4)     // Catch:{ Exception -> 0x054f }
                        java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x054f }
                        r12.append(r4)     // Catch:{ Exception -> 0x054f }
                        r12.append(r2)     // Catch:{ Exception -> 0x054f }
                        int r4 = r11 * 2
                        int r4 = r4 + r5
                        java.lang.Object r4 = r10.get(r4)     // Catch:{ Exception -> 0x054f }
                        java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x054f }
                        r12.append(r4)     // Catch:{ Exception -> 0x054f }
                        r12.append(r2)     // Catch:{ Exception -> 0x054f }
                        int r4 = r11 * 3
                        int r4 = r4 + r5
                        java.lang.Object r4 = r10.get(r4)     // Catch:{ Exception -> 0x054f }
                        java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x054f }
                        r12.append(r4)     // Catch:{ Exception -> 0x054f }
                        java.lang.String r4 = "</td></tr>"
                        r12.append(r4)     // Catch:{ Exception -> 0x054f }
                        java.lang.String r4 = r12.toString()     // Catch:{ Exception -> 0x054f }
                        int r5 = r5 + 1
                        r12 = r16
                        goto L_0x055c
                    L_0x05b2:
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x054f }
                        r1.<init>()     // Catch:{ Exception -> 0x054f }
                        r1.append(r4)     // Catch:{ Exception -> 0x054f }
                        java.lang.String r4 = "</table>"
                        r1.append(r4)     // Catch:{ Exception -> 0x054f }
                        java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x054f }
                        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x054f }
                        r4.<init>()     // Catch:{ Exception -> 0x054f }
                        r4.append(r8)     // Catch:{ Exception -> 0x054f }
                        r4.append(r1)     // Catch:{ Exception -> 0x054f }
                        java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x054f }
                        int r4 = r7.length     // Catch:{ Exception -> 0x054f }
                        java.lang.Object[] r3 = java.util.Arrays.copyOfRange(r7, r3, r4)     // Catch:{ Exception -> 0x054f }
                        java.lang.String[] r3 = (java.lang.String[]) r3     // Catch:{ Exception -> 0x054f }
                        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x054f }
                        r4.<init>()     // Catch:{ Exception -> 0x054f }
                        r4.append(r1)     // Catch:{ Exception -> 0x054f }
                        java.lang.String r1 = org.apache.commons.lang3.StringUtils.join((java.lang.Object[]) r3, (java.lang.String) r6)     // Catch:{ Exception -> 0x054f }
                        r4.append(r1)     // Catch:{ Exception -> 0x054f }
                        java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x054f }
                        goto L_0x05f7
                    L_0x05ed:
                        r30 = r2
                        r24 = r4
                        r20 = r5
                        r2 = r16
                        r16 = r12
                    L_0x05f7:
                        java.lang.String[] r1 = org.apache.commons.lang3.StringUtils.splitByWholeSeparator(r3, r6)     // Catch:{ Exception -> 0x054f }
                        int r3 = r1.length     // Catch:{ Exception -> 0x054f }
                        r4 = 0
                    L_0x05fd:
                        if (r4 >= r3) goto L_0x063f
                        r5 = r1[r4]     // Catch:{ Exception -> 0x054f }
                        boolean r7 = r5.contains(r0)     // Catch:{ Exception -> 0x054f }
                        if (r7 != 0) goto L_0x060b
                    L_0x0607:
                        r9.add(r5)     // Catch:{ Exception -> 0x054f }
                        goto L_0x063c
                    L_0x060b:
                        java.lang.String[] r5 = org.apache.commons.lang3.StringUtils.splitByWholeSeparator(r5, r0)     // Catch:{ Exception -> 0x054f }
                        java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ Exception -> 0x054f }
                        java.util.List r5 = java.util.Arrays.asList(r5)     // Catch:{ Exception -> 0x054f }
                        r7.<init>(r5)     // Catch:{ Exception -> 0x054f }
                        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x054f }
                        r5.<init>()     // Catch:{ Exception -> 0x054f }
                        r5.append(r13)     // Catch:{ Exception -> 0x054f }
                        r8 = 0
                        java.lang.Object r10 = r7.get(r8)     // Catch:{ Exception -> 0x054f }
                        java.lang.String r10 = (java.lang.String) r10     // Catch:{ Exception -> 0x054f }
                        r5.append(r10)     // Catch:{ Exception -> 0x054f }
                        r5.append(r15)     // Catch:{ Exception -> 0x054f }
                        java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x054f }
                        r7.remove(r8)     // Catch:{ Exception -> 0x054f }
                        r7.add(r8, r5)     // Catch:{ Exception -> 0x054f }
                        java.lang.String r5 = org.apache.commons.lang3.StringUtils.join((java.lang.Iterable<?>) r7, (java.lang.String) r0)     // Catch:{ Exception -> 0x054f }
                        goto L_0x0607
                    L_0x063c:
                        int r4 = r4 + 1
                        goto L_0x05fd
                    L_0x063f:
                        java.lang.String r0 = org.apache.commons.lang3.StringUtils.join((java.lang.Iterable<?>) r9, (java.lang.String) r14)     // Catch:{ Exception -> 0x054f }
                        r35 = r0
                        r8 = 0
                        goto L_0x069f
                    L_0x0647:
                        r30 = r2
                        r24 = r4
                        r20 = r5
                        r2 = r16
                        r16 = r12
                        int r1 = r7.length     // Catch:{ Exception -> 0x054f }
                        r3 = 0
                    L_0x0653:
                        if (r3 >= r1) goto L_0x0698
                        r4 = r7[r3]     // Catch:{ Exception -> 0x054f }
                        boolean r5 = r4.contains(r0)     // Catch:{ Exception -> 0x054f }
                        if (r5 != 0) goto L_0x0662
                        r9.add(r4)     // Catch:{ Exception -> 0x054f }
                        r8 = 0
                        goto L_0x0695
                    L_0x0662:
                        java.lang.String[] r4 = org.apache.commons.lang3.StringUtils.splitByWholeSeparator(r4, r0)     // Catch:{ Exception -> 0x054f }
                        java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ Exception -> 0x054f }
                        java.util.List r4 = java.util.Arrays.asList(r4)     // Catch:{ Exception -> 0x054f }
                        r5.<init>(r4)     // Catch:{ Exception -> 0x054f }
                        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x054f }
                        r4.<init>()     // Catch:{ Exception -> 0x054f }
                        r4.append(r13)     // Catch:{ Exception -> 0x054f }
                        r8 = 0
                        java.lang.Object r10 = r5.get(r8)     // Catch:{ Exception -> 0x054f }
                        java.lang.String r10 = (java.lang.String) r10     // Catch:{ Exception -> 0x054f }
                        r4.append(r10)     // Catch:{ Exception -> 0x054f }
                        r4.append(r15)     // Catch:{ Exception -> 0x054f }
                        java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x054f }
                        r5.remove(r8)     // Catch:{ Exception -> 0x054f }
                        r5.add(r8, r4)     // Catch:{ Exception -> 0x054f }
                        java.lang.String r4 = org.apache.commons.lang3.StringUtils.join((java.lang.Iterable<?>) r5, (java.lang.String) r0)     // Catch:{ Exception -> 0x054f }
                        r9.add(r4)     // Catch:{ Exception -> 0x054f }
                    L_0x0695:
                        int r3 = r3 + 1
                        goto L_0x0653
                    L_0x0698:
                        r8 = 0
                        java.lang.String r0 = org.apache.commons.lang3.StringUtils.join((java.lang.Iterable<?>) r9, (java.lang.String) r14)     // Catch:{ Exception -> 0x054f }
                        r35 = r0
                    L_0x069f:
                        java.lang.String r0 = "RTL"
                        java.lang.String r1 = "X Nazanin"
                        r4 = r16
                        r3 = r24
                        boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x054f }
                        if (r3 == 0) goto L_0x06b1
                        java.lang.String r0 = "LTR"
                        java.lang.String r1 = "Helvetica"
                    L_0x06b1:
                        r38 = r0
                        r36 = r1
                        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x054f }
                        r0.<init>()     // Catch:{ Exception -> 0x054f }
                        r5 = r20
                        r0.append(r5)     // Catch:{ Exception -> 0x054f }
                        r1 = r40
                        net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity$IDViewerFragment r3 = net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity.IDViewerFragment.this     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r4 = "title"
                        r5 = r23
                        java.lang.String r32 = r5.getString(r4)     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r33 = "X Traffic"
                        java.lang.String r34 = "LTR"
                        java.lang.String r37 = ""
                        java.lang.String r39 = java.lang.String.valueOf(r22)     // Catch:{ Exception -> 0x0030 }
                        r31 = r3
                        java.lang.String r3 = r31.N4(r32, r33, r34, r35, r36, r37, r38, r39)     // Catch:{ Exception -> 0x0030 }
                        r0.append(r3)     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r5 = r0.toString()     // Catch:{ Exception -> 0x0030 }
                        int r0 = r22 + 1
                        r8 = r0
                        r16 = r2
                        r0 = r19
                        r10 = r21
                        goto L_0x0318
                    L_0x06ed:
                        r21 = r10
                        net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity$IDViewerFragment r0 = net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity.IDViewerFragment.this     // Catch:{ Exception -> 0x0030 }
                        r0.m3()     // Catch:{ Exception -> 0x0030 }
                        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0030 }
                        r0.<init>()     // Catch:{ Exception -> 0x0030 }
                        r2 = r29
                        r0.append(r2)     // Catch:{ Exception -> 0x0030 }
                        r0.append(r5)     // Catch:{ Exception -> 0x0030 }
                        r2 = r28
                        r0.append(r2)     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0030 }
                        net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity$IDViewerFragment r2 = net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity.IDViewerFragment.this     // Catch:{ Exception -> 0x0030 }
                        r2.A4 = r0     // Catch:{ Exception -> 0x0030 }
                    L_0x070e:
                        boolean r0 = r21.x1()     // Catch:{ Exception -> 0x0030 }
                        if (r0 != 0) goto L_0x072e
                        net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity$IDViewerFragment r0 = net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity.IDViewerFragment.this     // Catch:{ Exception -> 0x0030 }
                        java.lang.String r2 = "Chapter"
                        r0.m4(r2)     // Catch:{ Exception -> 0x0030 }
                        goto L_0x072e
                    L_0x071c:
                        com.google.firebase.crashlytics.FirebaseCrashlytics r2 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()
                        r2.g(r0)
                        r0.printStackTrace()
                        net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity$IDViewerFragment r2 = net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity.IDViewerFragment.this
                        java.lang.String r0 = r0.getLocalizedMessage()
                        r2.p4 = r0
                    L_0x072e:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity.IDViewerFragment.AnonymousClass1.run():void");
                }
            }, new Runnable() {
                public void run() {
                    String str = IDViewerFragment.this.p4;
                    if (str == null || str.length() <= 0) {
                        String g1 = CompressHelper.g1(IDViewerFragment.this.D4, "base");
                        IDViewerFragment iDViewerFragment = IDViewerFragment.this;
                        iDViewerFragment.O3(iDViewerFragment.A4, g1);
                        IDViewerFragment.this.s4();
                        IDViewerFragment.this.p4();
                        IDViewerFragment.this.f3(R.menu.f1410elsviewer);
                        IDViewerFragment.this.o2(false);
                        IDViewerFragment.this.G3();
                        return;
                    }
                    IDViewerFragment iDViewerFragment2 = IDViewerFragment.this;
                    iDViewerFragment2.C4(iDViewerFragment2.p4);
                }
            });
            return inflate;
        }

        public boolean e1(MenuItem menuItem) {
            menuItem.getItemId();
            return super.e1(menuItem);
        }

        public void e3(Menu menu) {
            menu.removeItem(R.id.f801action_menu);
        }

        public void m1(Bundle bundle) {
            super.m1(bundle);
        }

        public boolean y4(WebView webView, String str, String str2, String str3) {
            CompressHelper compressHelper;
            Bundle bundle;
            String str4;
            iMDLogger.j("Override", "Url : " + str + ", Scheme : " + str2 + ", Resource : " + str3);
            if (str2.equals(Annotation.k3) || (str2.equals("http") && str3.contains("localhost:"))) {
                try {
                    if (!str3.contains("@\"")) {
                        return true;
                    }
                    new CompressHelper(r());
                    String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(URLDecoder.decode(CompressHelper.f(str3, "@\"", "\""), "UTF-8"), "://");
                    String str5 = "";
                    if (splitByWholeSeparator[0].equals("medCategory")) {
                        str5 = "medical";
                    } else if (splitByWholeSeparator[0].equals("pharmCategory")) {
                        str5 = "pharm";
                    }
                    String str6 = splitByWholeSeparator[1];
                    URLDecoder.decode(splitByWholeSeparator[2]);
                    new ArrayList();
                    if (str5.equals("medical")) {
                        compressHelper = this.Q4;
                        bundle = this.D4;
                        str4 = "Select  tDrugGenerics.fDrugGenericId as _id,tDrugGenerics.fDrugGenericId, fDrugGenericName from tMedicalGroupGenerics,tDrugGenerics where tMedicalGroupGenerics.fMedicalGroupId=" + str6 + " AND tDrugGenerics.fDrugGenericId=tMedicalGroupGenerics.fDrugGenericId";
                    } else {
                        compressHelper = this.Q4;
                        bundle = this.D4;
                        str4 = "Select tDrugGenerics.fDrugGenericId as _id,tDrugGenerics.fDrugGenericId, fDrugGenericName from tPharmGroupGenerics,tDrugGenerics where tPharmGroupGenerics.fPharmGroupId=" + str6 + " AND tDrugGenerics.fDrugGenericId=tPharmGroupGenerics.fDrugGenericId";
                    }
                    ArrayList<Bundle> V = compressHelper.V(bundle, str4);
                    ASSectionViewer aSSectionViewer = new ASSectionViewer();
                    Bundle bundle2 = new Bundle();
                    bundle2.putParcelableArrayList("Items", V);
                    bundle2.putString("TitleProperty", "fDrugGenericName");
                    aSSectionViewer.A2(this, 0);
                    aSSectionViewer.i2(bundle2);
                    aSSectionViewer.Z2(true);
                    aSSectionViewer.e3(M(), "asdfasdfasdf");
                } catch (Exception e2) {
                    FirebaseCrashlytics.d().g(e2);
                    iMDLogger.f("IDViewer ShouldOverride", "Error " + e2);
                }
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.f1175activity_general_viewer);
        Y0(new IDViewerFragment(), bundle);
    }
}
