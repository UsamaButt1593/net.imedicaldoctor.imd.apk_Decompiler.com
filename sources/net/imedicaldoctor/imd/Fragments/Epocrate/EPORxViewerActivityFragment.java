package net.imedicaldoctor.imd.Fragments.Epocrate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.bumptech.glide.Glide;
import com.itextpdf.tool.xml.css.CSS;
import java.util.ArrayList;
import java.util.Iterator;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.Lexi.LXSectionsViewer;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.iMDLogger;
import org.apache.commons.lang3.StringUtils;

public class EPORxViewerActivityFragment extends ViewerHelperFragment {
    public int X4;
    public ArrayList<Bundle> Y4;
    public ArrayList<Bundle> Z4;
    public String a5;
    public String b5;
    public Bundle c5;
    public ArrayList<Bundle> d5;

    public void I4(String str, int i2) {
        Bundle bundle = new Bundle();
        bundle.putString("sequence", String.valueOf(i2));
        bundle.putString("label", str);
        this.d5.add(bundle);
    }

    public void J4(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("Title", str);
        bundle.putString("Content", str2);
        this.Z4.add(bundle);
    }

    public String K4(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int i2 = this.X4 + 1;
        this.X4 = i2;
        String valueOf = String.valueOf(i2);
        return "<a name=\"f" + valueOf + "\"><div id=\"h" + valueOf + "\" class=\"headerExpanded3\"  DIR=\"" + str3 + "\" onclick=\"collapse(f" + valueOf + ");toggleHeaderExpanded3(h" + valueOf + ");\"><span class=\"fieldname\" style=\"font-family:" + str2 + ";\">" + str + "</span></div></a><div class=\"content\" DIR=\"" + str7 + "\" id=\"f" + valueOf + "\" style=\"font-family:" + str5 + "; " + str6 + "\">" + str4 + "</div>";
    }

    public String L4(String str, String str2, String str3, String str4) {
        int i2 = this.X4 + 1;
        this.X4 = i2;
        String valueOf = String.valueOf(i2);
        return "<div class=\"content\" DIR=\"" + str4 + "\" id=\"f" + valueOf + "\" style=\"font-family:" + str2 + "; " + str3 + "\">" + str + "</div>";
    }

    public String M4(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int i2 = this.X4 + 1;
        this.X4 = i2;
        String valueOf = String.valueOf(i2);
        return "<a name=\"f" + valueOf + "\"><div id=\"h" + valueOf + "\" class=\"headerExpanded\"  DIR=\"" + str3 + "\" onclick=\"collapse(f" + valueOf + ");toggleHeaderExpanded(h" + valueOf + ");\"><span class=\"fieldname\" style=\"font-family:" + str2 + ";\">" + str + "</span></div></a><div class=\"content\" DIR=\"" + str7 + "\" id=\"f" + valueOf + "\" style=\"font-family:" + str5 + "; " + str6 + "\">" + str4 + "</div>";
    }

    public String N4(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int i2 = this.X4 + 1;
        this.X4 = i2;
        String valueOf = String.valueOf(i2);
        return "<a name=\"f" + valueOf + "\"><div id=\"h" + valueOf + "\" class=\"headerExpanded2\"  DIR=\"" + str3 + "\" onclick=\"collapse(f" + valueOf + ");toggleHeaderExpanded2(h" + valueOf + ");\"><span class=\"fieldname\" style=\"font-family:" + str2 + ";\">" + str + "</span></div></a><div class=\"content\" DIR=\"" + str7 + "\" id=\"f" + valueOf + "\" style=\"font-family:" + str5 + "; " + str6 + "\">" + str4 + "</div>";
    }

    public String O4(String str, int i2) {
        StringBuilder sb;
        String K4;
        CompressHelper compressHelper = this.Q4;
        Bundle bundle = this.D4;
        Iterator<Bundle> it2 = compressHelper.X(bundle, "SELECT * FROM  drug_aggregate where parent_id=" + str, this.a5, true).iterator();
        String str2 = "";
        while (it2.hasNext()) {
            Bundle next = it2.next();
            String P4 = P4(next.getString("AGGREGATE_STRING_ID"));
            String O4 = O4(next.getString("ID"), i2 + 1);
            if (P4.length() == 0) {
                sb = new StringBuilder();
                sb.append(str2);
                K4 = L4(O4, "", "", "");
            } else if (O4.length() == 0) {
                sb = new StringBuilder();
                sb.append(str2);
                K4 = L4(P4, "", "", "");
            } else {
                sb = new StringBuilder();
                sb.append(str2);
                K4 = K4(P4, "", "LTR", O4, "", "margin-left: " + (i2 * 5) + CSS.Value.h0, "");
            }
            sb.append(K4);
            str2 = sb.toString();
        }
        return str2;
    }

    public String P4(String str) {
        return R4(str, "aggregate");
    }

    public String Q4(String str) {
        return R4(str, "bbw");
    }

    public String R4(String str, String str2) {
        if (!(str == null || str.length() == 0)) {
            CompressHelper compressHelper = this.Q4;
            Bundle bundle = this.D4;
            Bundle s1 = compressHelper.s1(compressHelper.W(bundle, "select * from " + str2 + "_string where id=" + str, this.a5));
            if (!(s1 == null || s1.size() == 0)) {
                return s1.getString("STRING");
            }
        }
        return "";
    }

    public String S4(String str) {
        Iterator<Bundle> it2 = this.Q4.X(this.D4, "SELECT * FROM  drug_aggregate where drug_id=%@ AND aggregate_type_id=" + this.b5, this.a5, true).iterator();
        String str2 = "";
        while (it2.hasNext()) {
            Bundle next = it2.next();
            String P4 = P4(next.getString("AGGREGATE_STRING_ID"));
            String O4 = O4(next.getString("ID"), 1);
            str2 = str2 + N4(P4, "", "LTR", O4, "", "margin-left: 20px", "");
        }
        return str2;
    }

    public String T4(String str) {
        return R4(str, "pricing");
    }

    public View onFragmentBind(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.C4;
        if (view != null) {
            return view;
        }
        this.C4 = layoutInflater.inflate(R.layout.f1255fragment_new_viewer, viewGroup, false);
        this.c5 = new Bundle();
        r4(this.C4, bundle);
        this.a5 = "RX.sqlite";
        if (y() == null) {
            return this.C4;
        }
        T2(new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:105:0x05ac A[Catch:{ Exception -> 0x0517 }] */
            /* JADX WARNING: Removed duplicated region for block: B:108:0x05c3 A[Catch:{ Exception -> 0x0517 }] */
            /* JADX WARNING: Removed duplicated region for block: B:120:0x0614 A[SYNTHETIC, Splitter:B:120:0x0614] */
            /* JADX WARNING: Removed duplicated region for block: B:133:0x06f0 A[Catch:{ Exception -> 0x0517 }] */
            /* JADX WARNING: Removed duplicated region for block: B:143:0x07a1 A[Catch:{ Exception -> 0x0517 }] */
            /* JADX WARNING: Removed duplicated region for block: B:147:0x07b7 A[Catch:{ Exception -> 0x0517 }, LOOP:8: B:145:0x07b1->B:147:0x07b7, LOOP_END] */
            /* JADX WARNING: Removed duplicated region for block: B:150:0x0801 A[Catch:{ Exception -> 0x0517 }] */
            /* JADX WARNING: Removed duplicated region for block: B:151:0x0830 A[Catch:{ Exception -> 0x0517 }] */
            /* JADX WARNING: Removed duplicated region for block: B:154:0x083b A[Catch:{ Exception -> 0x0517 }] */
            /* JADX WARNING: Removed duplicated region for block: B:157:0x086f A[Catch:{ Exception -> 0x0517 }] */
            /* JADX WARNING: Removed duplicated region for block: B:158:0x08ba A[Catch:{ Exception -> 0x0517 }] */
            /* JADX WARNING: Removed duplicated region for block: B:161:0x08e9 A[Catch:{ Exception -> 0x0517 }] */
            /* JADX WARNING: Removed duplicated region for block: B:165:0x0960 A[Catch:{ Exception -> 0x0517 }, LOOP:9: B:163:0x095a->B:165:0x0960, LOOP_END] */
            /* JADX WARNING: Removed duplicated region for block: B:168:0x09ad A[Catch:{ Exception -> 0x0517 }] */
            /* JADX WARNING: Removed duplicated region for block: B:171:0x09c0 A[Catch:{ Exception -> 0x0517 }] */
            /* JADX WARNING: Removed duplicated region for block: B:178:0x0a1d A[Catch:{ Exception -> 0x0517 }] */
            /* JADX WARNING: Removed duplicated region for block: B:183:0x0a96 A[SYNTHETIC, Splitter:B:183:0x0a96] */
            /* JADX WARNING: Removed duplicated region for block: B:187:0x0b7b A[Catch:{ Exception -> 0x0517 }] */
            /* JADX WARNING: Removed duplicated region for block: B:190:0x0b90 A[Catch:{ Exception -> 0x0517 }] */
            /* JADX WARNING: Removed duplicated region for block: B:195:0x0bcb A[SYNTHETIC, Splitter:B:195:0x0bcb] */
            /* JADX WARNING: Removed duplicated region for block: B:199:0x0bf1 A[Catch:{ Exception -> 0x0517 }] */
            /* JADX WARNING: Removed duplicated region for block: B:200:0x0c0f A[Catch:{ Exception -> 0x0517 }] */
            /* JADX WARNING: Removed duplicated region for block: B:204:0x0c3f A[Catch:{ Exception -> 0x0517 }, LOOP:12: B:202:0x0c39->B:204:0x0c3f, LOOP_END] */
            /* JADX WARNING: Removed duplicated region for block: B:207:0x0c65 A[Catch:{ Exception -> 0x0517 }] */
            /* JADX WARNING: Removed duplicated region for block: B:208:0x0ca8 A[Catch:{ Exception -> 0x0517 }] */
            /* JADX WARNING: Removed duplicated region for block: B:212:0x0ce1 A[Catch:{ Exception -> 0x0517 }, LOOP:13: B:210:0x0cdb->B:212:0x0ce1, LOOP_END] */
            /* JADX WARNING: Removed duplicated region for block: B:215:0x0d07 A[Catch:{ Exception -> 0x0517 }] */
            /* JADX WARNING: Removed duplicated region for block: B:216:0x0d3f A[Catch:{ Exception -> 0x0517 }] */
            /* JADX WARNING: Removed duplicated region for block: B:219:0x0d49 A[Catch:{ Exception -> 0x0517 }] */
            /* JADX WARNING: Removed duplicated region for block: B:223:0x0d82 A[Catch:{ Exception -> 0x0517 }, LOOP:14: B:221:0x0d7c->B:223:0x0d82, LOOP_END] */
            /* JADX WARNING: Removed duplicated region for block: B:226:0x0dc4 A[Catch:{ Exception -> 0x0517 }] */
            /* JADX WARNING: Removed duplicated region for block: B:229:0x0e05 A[Catch:{ Exception -> 0x0517 }] */
            /* JADX WARNING: Removed duplicated region for block: B:237:0x0e2a A[SYNTHETIC, Splitter:B:237:0x0e2a] */
            /* JADX WARNING: Removed duplicated region for block: B:293:0x1222 A[Catch:{ Exception -> 0x0517 }] */
            /* JADX WARNING: Removed duplicated region for block: B:296:0x1239 A[Catch:{ Exception -> 0x0517 }] */
            /* JADX WARNING: Removed duplicated region for block: B:306:0x1305 A[Catch:{ Exception -> 0x0517 }, LOOP:23: B:304:0x12ff->B:306:0x1305, LOOP_END] */
            /* JADX WARNING: Removed duplicated region for block: B:311:0x018e A[EDGE_INSN: B:311:0x018e->B:40:0x018e ?: BREAK  , SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:38:0x0113 A[SYNTHETIC, Splitter:B:38:0x0113] */
            /* JADX WARNING: Removed duplicated region for block: B:42:0x019d A[Catch:{ Exception -> 0x0016 }] */
            /* JADX WARNING: Removed duplicated region for block: B:46:0x01d4 A[Catch:{ Exception -> 0x0016 }, LOOP:1: B:44:0x01ce->B:46:0x01d4, LOOP_END] */
            /* JADX WARNING: Removed duplicated region for block: B:49:0x025c A[Catch:{ Exception -> 0x0016 }] */
            /* JADX WARNING: Removed duplicated region for block: B:53:0x0297 A[Catch:{ Exception -> 0x0016 }, LOOP:2: B:51:0x0291->B:53:0x0297, LOOP_END] */
            /* JADX WARNING: Removed duplicated region for block: B:57:0x02f5 A[SYNTHETIC, Splitter:B:57:0x02f5] */
            /* JADX WARNING: Removed duplicated region for block: B:67:0x03b9 A[Catch:{ Exception -> 0x0016 }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r40 = this;
                    r1 = r40
                    java.lang.String r2 = "DRUG_TYPE"
                    java.lang.String r3 = "GENERIC_ID"
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r4 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r4 = r4.A4     // Catch:{ Exception -> 0x0016 }
                    if (r4 == 0) goto L_0x001b
                    int r4 = r4.length()     // Catch:{ Exception -> 0x0016 }
                    if (r4 != 0) goto L_0x0013
                    goto L_0x001b
                L_0x0013:
                    r6 = r1
                    goto L_0x1370
                L_0x0016:
                    r0 = move-exception
                    r6 = r1
                L_0x0018:
                    r1 = r0
                    goto L_0x1365
                L_0x001b:
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r4 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0016 }
                    r5 = 0
                    r4.X4 = r5     // Catch:{ Exception -> 0x0016 }
                    java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ Exception -> 0x0016 }
                    r5.<init>()     // Catch:{ Exception -> 0x0016 }
                    r4.Z4 = r5     // Catch:{ Exception -> 0x0016 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r4 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0016 }
                    java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ Exception -> 0x0016 }
                    r5.<init>()     // Catch:{ Exception -> 0x0016 }
                    r4.d5 = r5     // Catch:{ Exception -> 0x0016 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r4 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r4 = r4.E4     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r5 = "-"
                    java.lang.String[] r4 = r4.split(r5)     // Catch:{ Exception -> 0x0016 }
                    r5 = 1
                    r4 = r4[r5]     // Catch:{ Exception -> 0x0016 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r6 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0016 }
                    r6.b5 = r4     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r15 = "margin-left: 20px"
                    net.imedicaldoctor.imd.Data.CompressHelper r7 = r6.Q4     // Catch:{ Exception -> 0x0016 }
                    android.os.Bundle r6 = r6.D4     // Catch:{ Exception -> 0x0016 }
                    java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0016 }
                    r8.<init>()     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r9 = "Select * from drug where ID="
                    r8.append(r9)     // Catch:{ Exception -> 0x0016 }
                    r8.append(r4)     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0016 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r9 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r9 = r9.a5     // Catch:{ Exception -> 0x0016 }
                    java.util.ArrayList r6 = r7.X(r6, r8, r9, r5)     // Catch:{ Exception -> 0x0016 }
                    if (r6 == 0) goto L_0x0068
                    int r7 = r6.size()     // Catch:{ Exception -> 0x0016 }
                    if (r7 != 0) goto L_0x006b
                L_0x0068:
                    r6 = r1
                    goto L_0x135e
                L_0x006b:
                    r7 = 0
                    java.lang.Object r6 = r6.get(r7)     // Catch:{ Exception -> 0x0016 }
                    android.os.Bundle r6 = (android.os.Bundle) r6     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r7 = r6.getString(r3)     // Catch:{ Exception -> 0x0016 }
                    int r7 = r7.length()     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r14 = "0"
                    java.lang.String r13 = "ID"
                    java.lang.String r12 = "NAME"
                    if (r7 == 0) goto L_0x00c6
                    java.lang.String r7 = r6.getString(r3)     // Catch:{ Exception -> 0x0016 }
                    boolean r7 = r7.equals(r14)     // Catch:{ Exception -> 0x0016 }
                    if (r7 == 0) goto L_0x008d
                    goto L_0x00c6
                L_0x008d:
                    java.lang.String r7 = r6.getString(r3)     // Catch:{ Exception -> 0x0016 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r8 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x00b8 }
                    net.imedicaldoctor.imd.Data.CompressHelper r9 = r8.Q4     // Catch:{ Exception -> 0x00b8 }
                    android.os.Bundle r8 = r8.D4     // Catch:{ Exception -> 0x00b8 }
                    java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b8 }
                    r10.<init>()     // Catch:{ Exception -> 0x00b8 }
                    java.lang.String r11 = "SELECT  DRUG.ID ,  DRUG.CLINICAL_ID ,  DRUG.GENERIC_ID ,  DRUG.NAME ,  DRUG.DRUG_TYPE ,  DRUG.ACTIVE ,  DRUG.ADULT_DSG_ID ,  DRUG.PEDS_DSG_ID ,  DRUG.MFR_STRING_ID ,  DRUG.BBW_ID   FROM DRUG   WHERE  ID =  "
                    r10.append(r11)     // Catch:{ Exception -> 0x00b8 }
                    r10.append(r4)     // Catch:{ Exception -> 0x00b8 }
                    java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x00b8 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r11 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x00b8 }
                    java.lang.String r11 = r11.a5     // Catch:{ Exception -> 0x00b8 }
                    java.util.ArrayList r8 = r9.X(r8, r10, r11, r5)     // Catch:{ Exception -> 0x00b8 }
                    android.os.Bundle r8 = r9.s1(r8)     // Catch:{ Exception -> 0x00b8 }
                    r8.getString(r12)     // Catch:{ Exception -> 0x00b8 }
                    goto L_0x00c4
                L_0x00b8:
                    r0 = move-exception
                    r8 = r0
                    com.google.firebase.crashlytics.FirebaseCrashlytics r9 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()     // Catch:{ Exception -> 0x0016 }
                    r9.g(r8)     // Catch:{ Exception -> 0x0016 }
                    r8.printStackTrace()     // Catch:{ Exception -> 0x0016 }
                L_0x00c4:
                    r11 = r7
                    goto L_0x00ce
                L_0x00c6:
                    java.lang.String r7 = r6.getString(r13)     // Catch:{ Exception -> 0x0016 }
                    r6.getString(r12)     // Catch:{ Exception -> 0x0016 }
                    goto L_0x00c4
                L_0x00ce:
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r8 = r6.getString(r12)     // Catch:{ Exception -> 0x0016 }
                    r7.F4 = r8     // Catch:{ Exception -> 0x0016 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0016 }
                    net.imedicaldoctor.imd.Data.CompressHelper r8 = r7.Q4     // Catch:{ Exception -> 0x0016 }
                    android.os.Bundle r7 = r7.D4     // Catch:{ Exception -> 0x0016 }
                    java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0016 }
                    r9.<init>()     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r10 = "SELECT  ADULT_DOSING.ID ,  ADULT_DOSING.DRUG_ID ,  ADULT_DOSING.DISPLAY_ORDER ,  ADULT_DOSING.INDICATION_STRING_ID ,  ADULT_DOSING.DOSING_STRING_ID ,  ADULT_DOSING.INFO_STRING_ID   FROM ADULT_DOSING   WHERE  DRUG_ID =  "
                    r9.append(r10)     // Catch:{ Exception -> 0x0016 }
                    r9.append(r4)     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r10 = " ORDER BY  ADULT_DOSING.DISPLAY_ORDER"
                    r9.append(r10)     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0016 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r10 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r10 = r10.a5     // Catch:{ Exception -> 0x0016 }
                    java.util.ArrayList r7 = r8.X(r7, r9, r10, r5)     // Catch:{ Exception -> 0x0016 }
                    java.util.Iterator r16 = r7.iterator()     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r10 = ""
                    r7 = r10
                L_0x0101:
                    boolean r8 = r16.hasNext()     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r9 = "</div>"
                    java.lang.String r5 = "<div class=\"cellTitle\">"
                    r18 = r3
                    java.lang.String r3 = "DOSING_STRING_ID"
                    r19 = r2
                    java.lang.String r2 = "INDICATION_STRING_ID"
                    if (r8 == 0) goto L_0x018e
                    java.lang.Object r8 = r16.next()     // Catch:{ Exception -> 0x0016 }
                    android.os.Bundle r8 = (android.os.Bundle) r8     // Catch:{ Exception -> 0x0016 }
                    r20 = r10
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r10 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r2 = r10.V4(r2)     // Catch:{ Exception -> 0x0016 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r10 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r3 = r8.getString(r3)     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r3 = r10.V4(r3)     // Catch:{ Exception -> 0x0016 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r10 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0016 }
                    r21 = r11
                    java.lang.String r11 = "INFO_STRING_ID"
                    java.lang.String r8 = r8.getString(r11)     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r8 = r10.V4(r8)     // Catch:{ Exception -> 0x0016 }
                    java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0016 }
                    r10.<init>()     // Catch:{ Exception -> 0x0016 }
                    r10.append(r5)     // Catch:{ Exception -> 0x0016 }
                    r10.append(r3)     // Catch:{ Exception -> 0x0016 }
                    r10.append(r9)     // Catch:{ Exception -> 0x0016 }
                    r10.append(r8)     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r11 = r10.toString()     // Catch:{ Exception -> 0x0016 }
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0016 }
                    r3.<init>()     // Catch:{ Exception -> 0x0016 }
                    r3.append(r7)     // Catch:{ Exception -> 0x0016 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r9 = ""
                    java.lang.String r10 = "LTR"
                    java.lang.String r5 = ""
                    java.lang.String r22 = ""
                    r8 = r2
                    r2 = r20
                    r23 = r21
                    r20 = r6
                    r6 = r12
                    r12 = r5
                    r5 = r13
                    r13 = r15
                    r24 = r14
                    r14 = r22
                    java.lang.String r7 = r7.N4(r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x0016 }
                    r3.append(r7)     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r7 = r3.toString()     // Catch:{ Exception -> 0x0016 }
                    r10 = r2
                    r13 = r5
                    r12 = r6
                    r3 = r18
                    r2 = r19
                    r6 = r20
                    r11 = r23
                    r14 = r24
                    r5 = 1
                    goto L_0x0101
                L_0x018e:
                    r20 = r6
                    r23 = r11
                    r6 = r12
                    r24 = r14
                    r14 = r13
                    r13 = r10
                    int r8 = r7.length()     // Catch:{ Exception -> 0x0016 }
                    if (r8 <= 0) goto L_0x01a4
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r8 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r10 = "Adult Dosing"
                    r8.J4(r10, r7)     // Catch:{ Exception -> 0x0016 }
                L_0x01a4:
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0016 }
                    net.imedicaldoctor.imd.Data.CompressHelper r8 = r7.Q4     // Catch:{ Exception -> 0x0016 }
                    android.os.Bundle r7 = r7.D4     // Catch:{ Exception -> 0x0016 }
                    java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0016 }
                    r10.<init>()     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r11 = "SELECT  PEDS_DOSING.ID ,  PEDS_DOSING.DRUG_ID ,  PEDS_DOSING.DISPLAY_ORDER ,  PEDS_DOSING.INDICATION_STRING_ID ,  PEDS_DOSING.DOSING_STRING_ID ,  PEDS_DOSING.INFO_STRING_ID   FROM PEDS_DOSING   WHERE  DRUG_ID =  "
                    r10.append(r11)     // Catch:{ Exception -> 0x0016 }
                    r10.append(r4)     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r11 = "  ORDER BY  PEDS_DOSING.DISPLAY_ORDER"
                    r10.append(r11)     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x0016 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r11 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r11 = r11.a5     // Catch:{ Exception -> 0x0016 }
                    r12 = 1
                    java.util.ArrayList r7 = r8.X(r7, r10, r11, r12)     // Catch:{ Exception -> 0x0016 }
                    java.util.Iterator r16 = r7.iterator()     // Catch:{ Exception -> 0x0016 }
                    r10 = r13
                L_0x01ce:
                    boolean r7 = r16.hasNext()     // Catch:{ Exception -> 0x0016 }
                    if (r7 == 0) goto L_0x024c
                    java.lang.Object r7 = r16.next()     // Catch:{ Exception -> 0x0016 }
                    android.os.Bundle r7 = (android.os.Bundle) r7     // Catch:{ Exception -> 0x0016 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r8 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r11 = r7.getString(r2)     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r8 = r8.V4(r11)     // Catch:{ Exception -> 0x0016 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r11 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r12 = r7.getString(r3)     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r11 = r11.V4(r12)     // Catch:{ Exception -> 0x0016 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r12 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0016 }
                    r21 = r13
                    java.lang.String r13 = "INFO_STRING_ID"
                    java.lang.String r7 = r7.getString(r13)     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r7 = r12.V4(r7)     // Catch:{ Exception -> 0x0016 }
                    java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0016 }
                    r12.<init>()     // Catch:{ Exception -> 0x0016 }
                    r12.append(r5)     // Catch:{ Exception -> 0x0016 }
                    r12.append(r11)     // Catch:{ Exception -> 0x0016 }
                    r12.append(r9)     // Catch:{ Exception -> 0x0016 }
                    r12.append(r7)     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r11 = r12.toString()     // Catch:{ Exception -> 0x0016 }
                    java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0016 }
                    r13.<init>()     // Catch:{ Exception -> 0x0016 }
                    r13.append(r10)     // Catch:{ Exception -> 0x0016 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r10 = ""
                    java.lang.String r12 = "LTR"
                    java.lang.String r22 = ""
                    java.lang.String r25 = ""
                    r26 = r9
                    r9 = r10
                    r10 = r12
                    r12 = r22
                    r22 = r5
                    r5 = r21
                    r21 = r3
                    r3 = r13
                    r13 = r15
                    r27 = r2
                    r2 = r14
                    r14 = r25
                    java.lang.String r7 = r7.N4(r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x0016 }
                    r3.append(r7)     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r10 = r3.toString()     // Catch:{ Exception -> 0x0016 }
                    r14 = r2
                    r13 = r5
                    r3 = r21
                    r5 = r22
                    r9 = r26
                    r2 = r27
                    goto L_0x01ce
                L_0x024c:
                    r27 = r2
                    r21 = r3
                    r22 = r5
                    r26 = r9
                    r5 = r13
                    r2 = r14
                    int r3 = r10.length()     // Catch:{ Exception -> 0x0016 }
                    if (r3 <= 0) goto L_0x0263
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r3 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r7 = "Pediatric Dosing"
                    r3.J4(r7, r10)     // Catch:{ Exception -> 0x0016 }
                L_0x0263:
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r3 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0016 }
                    net.imedicaldoctor.imd.Data.CompressHelper r7 = r3.Q4     // Catch:{ Exception -> 0x0016 }
                    android.os.Bundle r3 = r3.D4     // Catch:{ Exception -> 0x0016 }
                    java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0016 }
                    r8.<init>()     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r9 = "SELECT  DRUG_CLASS.ID ,  DRUG_CLASS.NAME   FROM DRUG_TO_DRUG_CLASS   JOIN DRUG_CLASS ON  DRUG_TO_DRUG_CLASS.DRUG_ID =  "
                    r8.append(r9)     // Catch:{ Exception -> 0x0016 }
                    r8.append(r4)     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r9 = "   AND DRUG_CLASS.ID = DRUG_TO_DRUG_CLASS.DRUG_CLASS_ID    ORDER BY  DRUG_CLASS.NAME COLLATE NOCASE"
                    r8.append(r9)     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0016 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r9 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r9 = r9.a5     // Catch:{ Exception -> 0x0016 }
                    r10 = 1
                    java.util.ArrayList r3 = r7.X(r3, r8, r9, r10)     // Catch:{ Exception -> 0x0016 }
                    java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ Exception -> 0x0016 }
                    r14.<init>()     // Catch:{ Exception -> 0x0016 }
                    java.util.Iterator r7 = r3.iterator()     // Catch:{ Exception -> 0x0016 }
                L_0x0291:
                    boolean r8 = r7.hasNext()     // Catch:{ Exception -> 0x0016 }
                    if (r8 == 0) goto L_0x02d9
                    java.lang.Object r8 = r7.next()     // Catch:{ Exception -> 0x0016 }
                    android.os.Bundle r8 = (android.os.Bundle) r8     // Catch:{ Exception -> 0x0016 }
                    r8.getString(r6)     // Catch:{ Exception -> 0x0016 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r9 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0016 }
                    net.imedicaldoctor.imd.Data.CompressHelper r10 = r9.Q4     // Catch:{ Exception -> 0x0016 }
                    android.os.Bundle r9 = r9.D4     // Catch:{ Exception -> 0x0016 }
                    java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0016 }
                    r11.<init>()     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r12 = "SELECT  DRUG_CLASS.ID ,  DRUG_CLASS.NAME   FROM DRUG_CLASS_RELATIONSHIP   JOIN DRUG_CLASS ON  DRUG_CLASS_RELATIONSHIP.CLASS_0_ID =  "
                    r11.append(r12)     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r12 = r8.getString(r2)     // Catch:{ Exception -> 0x0016 }
                    r11.append(r12)     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r12 = "   AND DRUG_CLASS.ID = DRUG_CLASS_RELATIONSHIP.CLASS_1_ID   UNION SELECT  DRUG_CLASS.ID ,  DRUG_CLASS.NAME   FROM DRUG_CLASS_RELATIONSHIP   JOIN DRUG_CLASS ON  DRUG_CLASS_RELATIONSHIP.CLASS_1_ID =  "
                    r11.append(r12)     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r8 = r8.getString(r2)     // Catch:{ Exception -> 0x0016 }
                    r11.append(r8)     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r8 = "   AND DRUG_CLASS.ID = DRUG_CLASS_RELATIONSHIP.CLASS_0_ID   order by name asc"
                    r11.append(r8)     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r8 = r11.toString()     // Catch:{ Exception -> 0x0016 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r11 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r11 = r11.a5     // Catch:{ Exception -> 0x0016 }
                    r12 = 1
                    java.util.ArrayList r8 = r10.X(r9, r8, r11, r12)     // Catch:{ Exception -> 0x0016 }
                    r14.addAll(r8)     // Catch:{ Exception -> 0x0016 }
                    goto L_0x0291
                L_0x02d9:
                    r13 = r19
                    r12 = r20
                    java.lang.String r7 = r12.getString(r13)     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r8 = "6"
                    boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r11 = "<li><a href=\"grp://"
                    java.lang.String r10 = ",,,,,"
                    java.lang.String r9 = "\">"
                    java.lang.String r8 = "<ul>"
                    r16 = r4
                    java.lang.String r4 = "</ul>"
                    if (r7 != 0) goto L_0x03b9
                    java.util.Iterator r7 = r3.iterator()     // Catch:{ Exception -> 0x0016 }
                    r14 = r5
                L_0x02fa:
                    boolean r18 = r7.hasNext()     // Catch:{ Exception -> 0x0016 }
                    if (r18 == 0) goto L_0x0340
                    java.lang.Object r18 = r7.next()     // Catch:{ Exception -> 0x0016 }
                    r19 = r7
                    r7 = r18
                    android.os.Bundle r7 = (android.os.Bundle) r7     // Catch:{ Exception -> 0x0016 }
                    r20 = r12
                    java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0016 }
                    r12.<init>()     // Catch:{ Exception -> 0x0016 }
                    r12.append(r14)     // Catch:{ Exception -> 0x0016 }
                    r12.append(r11)     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r14 = r7.getString(r2)     // Catch:{ Exception -> 0x0016 }
                    r12.append(r14)     // Catch:{ Exception -> 0x0016 }
                    r12.append(r10)     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r14 = r7.getString(r6)     // Catch:{ Exception -> 0x0016 }
                    r12.append(r14)     // Catch:{ Exception -> 0x0016 }
                    r12.append(r9)     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r7 = r7.getString(r6)     // Catch:{ Exception -> 0x0016 }
                    r12.append(r7)     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r7 = "</a></li>"
                    r12.append(r7)     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r14 = r12.toString()     // Catch:{ Exception -> 0x0016 }
                    r7 = r19
                    r12 = r20
                    goto L_0x02fa
                L_0x0340:
                    r20 = r12
                    int r7 = r14.length()     // Catch:{ Exception -> 0x0016 }
                    if (r7 <= 0) goto L_0x0396
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0016 }
                    r7.<init>()     // Catch:{ Exception -> 0x0016 }
                    r7.append(r8)     // Catch:{ Exception -> 0x0016 }
                    r7.append(r14)     // Catch:{ Exception -> 0x0016 }
                    r7.append(r4)     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r11 = r7.toString()     // Catch:{ Exception -> 0x0016 }
                    java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0016 }
                    r14.<init>()     // Catch:{ Exception -> 0x0016 }
                    r14.append(r5)     // Catch:{ Exception -> 0x0016 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r12 = "Subclasses"
                    java.lang.String r18 = ""
                    java.lang.String r19 = "LTR"
                    java.lang.String r25 = ""
                    java.lang.String r28 = ""
                    r29 = r3
                    r3 = r8
                    r8 = r12
                    r12 = r9
                    r9 = r18
                    r30 = r10
                    r10 = r19
                    r19 = r5
                    r5 = r20
                    r20 = r4
                    r4 = r12
                    r12 = r25
                    r31 = r13
                    r13 = r15
                    r25 = r15
                    r15 = r14
                    r14 = r28
                    java.lang.String r7 = r7.N4(r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x0016 }
                    r15.append(r7)     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r10 = r15.toString()     // Catch:{ Exception -> 0x0016 }
                    goto L_0x03a8
                L_0x0396:
                    r29 = r3
                    r19 = r5
                    r3 = r8
                    r30 = r10
                    r31 = r13
                    r25 = r15
                    r5 = r20
                    r20 = r4
                    r4 = r9
                    r10 = r19
                L_0x03a8:
                    r18 = r5
                    r28 = r6
                    r32 = r19
                    r15 = r20
                    r6 = r1
                    r39 = r30
                    r30 = r2
                    r2 = r39
                    goto L_0x05a6
                L_0x03b9:
                    r29 = r3
                    r20 = r4
                    r19 = r5
                    r3 = r8
                    r4 = r9
                    r30 = r10
                    r5 = r12
                    r31 = r13
                    r25 = r15
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0016 }
                    net.imedicaldoctor.imd.Data.CompressHelper r8 = r7.Q4     // Catch:{ Exception -> 0x0016 }
                    android.os.Bundle r7 = r7.D4     // Catch:{ Exception -> 0x0016 }
                    java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0016 }
                    r9.<init>()     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r10 = "SELECT  DRUG.ID ,  DRUG.CLINICAL_ID ,  DRUG.GENERIC_ID ,  DRUG.NAME ,  DRUG.DRUG_TYPE ,  DRUG.ACTIVE ,  DRUG.ADULT_DSG_ID ,  DRUG.PEDS_DSG_ID ,  DRUG.MFR_STRING_ID ,  DRUG.BBW_ID   FROM DRUG   WHERE  GENERIC_ID =  "
                    r9.append(r10)     // Catch:{ Exception -> 0x0016 }
                    r10 = r18
                    java.lang.String r10 = r5.getString(r10)     // Catch:{ Exception -> 0x0016 }
                    r9.append(r10)     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r10 = "   AND   ACTIVE = 1      ORDER BY  DRUG.NAME COLLATE NOCASE"
                    r9.append(r10)     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0016 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r10 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r10 = r10.a5     // Catch:{ Exception -> 0x0016 }
                    r12 = 1
                    java.util.ArrayList r7 = r8.X(r7, r9, r10, r12)     // Catch:{ Exception -> 0x0016 }
                    java.util.Iterator r7 = r7.iterator()     // Catch:{ Exception -> 0x0016 }
                    r10 = r19
                L_0x03f9:
                    boolean r8 = r7.hasNext()     // Catch:{ Exception -> 0x0016 }
                    if (r8 == 0) goto L_0x042d
                    java.lang.Object r8 = r7.next()     // Catch:{ Exception -> 0x0016 }
                    android.os.Bundle r8 = (android.os.Bundle) r8     // Catch:{ Exception -> 0x0016 }
                    java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0016 }
                    r9.<init>()     // Catch:{ Exception -> 0x0016 }
                    r9.append(r10)     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r10 = "<li><a href=\"rx://"
                    r9.append(r10)     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r10 = r8.getString(r2)     // Catch:{ Exception -> 0x0016 }
                    r9.append(r10)     // Catch:{ Exception -> 0x0016 }
                    r9.append(r4)     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r8 = r8.getString(r6)     // Catch:{ Exception -> 0x0016 }
                    r9.append(r8)     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r8 = "</a><br/></li>"
                    r9.append(r8)     // Catch:{ Exception -> 0x0016 }
                    java.lang.String r10 = r9.toString()     // Catch:{ Exception -> 0x0016 }
                    goto L_0x03f9
                L_0x042d:
                    int r7 = r10.length()     // Catch:{ Exception -> 0x0016 }
                    if (r7 <= 0) goto L_0x047f
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x047a }
                    r7.<init>()     // Catch:{ Exception -> 0x047a }
                    r7.append(r3)     // Catch:{ Exception -> 0x047a }
                    r7.append(r10)     // Catch:{ Exception -> 0x047a }
                    r15 = r20
                    r7.append(r15)     // Catch:{ Exception -> 0x047a }
                    java.lang.String r12 = r7.toString()     // Catch:{ Exception -> 0x047a }
                    java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x047a }
                    r13.<init>()     // Catch:{ Exception -> 0x047a }
                    r10 = r19
                    r13.append(r10)     // Catch:{ Exception -> 0x047a }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x047a }
                    java.lang.String r8 = "Other OTCs with Same Active Ingredients"
                    java.lang.String r9 = ""
                    java.lang.String r18 = "LTR"
                    java.lang.String r19 = ""
                    java.lang.String r20 = ""
                    r32 = r10
                    r10 = r18
                    r18 = r5
                    r5 = r11
                    r11 = r12
                    r12 = r19
                    r1 = r13
                    r13 = r25
                    r19 = r14
                    r14 = r20
                    java.lang.String r7 = r7.N4(r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x047a }
                    r1.append(r7)     // Catch:{ Exception -> 0x047a }
                    java.lang.String r10 = r1.toString()     // Catch:{ Exception -> 0x047a }
                    goto L_0x048a
                L_0x047a:
                    r0 = move-exception
                    r6 = r40
                    goto L_0x0018
                L_0x047f:
                    r18 = r5
                    r5 = r11
                    r32 = r19
                    r15 = r20
                    r19 = r14
                    r10 = r32
                L_0x048a:
                    java.util.Iterator r1 = r29.iterator()     // Catch:{ Exception -> 0x047a }
                    r7 = r32
                L_0x0490:
                    boolean r8 = r1.hasNext()     // Catch:{ Exception -> 0x047a }
                    if (r8 == 0) goto L_0x04d0
                    java.lang.Object r8 = r1.next()     // Catch:{ Exception -> 0x047a }
                    android.os.Bundle r8 = (android.os.Bundle) r8     // Catch:{ Exception -> 0x047a }
                    java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x047a }
                    r9.<init>()     // Catch:{ Exception -> 0x047a }
                    r9.append(r7)     // Catch:{ Exception -> 0x047a }
                    r9.append(r5)     // Catch:{ Exception -> 0x047a }
                    java.lang.String r7 = r8.getString(r2)     // Catch:{ Exception -> 0x047a }
                    r9.append(r7)     // Catch:{ Exception -> 0x047a }
                    r14 = r30
                    r9.append(r14)     // Catch:{ Exception -> 0x047a }
                    java.lang.String r7 = r8.getString(r6)     // Catch:{ Exception -> 0x047a }
                    r9.append(r7)     // Catch:{ Exception -> 0x047a }
                    r9.append(r4)     // Catch:{ Exception -> 0x047a }
                    java.lang.String r7 = r8.getString(r6)     // Catch:{ Exception -> 0x047a }
                    r9.append(r7)     // Catch:{ Exception -> 0x047a }
                    java.lang.String r7 = "</a><br/></li>"
                    r9.append(r7)     // Catch:{ Exception -> 0x047a }
                    java.lang.String r7 = r9.toString()     // Catch:{ Exception -> 0x047a }
                    r30 = r14
                    goto L_0x0490
                L_0x04d0:
                    r14 = r30
                    int r1 = r7.length()     // Catch:{ Exception -> 0x047a }
                    if (r1 <= 0) goto L_0x051e
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x047a }
                    r1.<init>()     // Catch:{ Exception -> 0x047a }
                    r1.append(r3)     // Catch:{ Exception -> 0x047a }
                    r1.append(r7)     // Catch:{ Exception -> 0x047a }
                    r1.append(r15)     // Catch:{ Exception -> 0x047a }
                    java.lang.String r11 = r1.toString()     // Catch:{ Exception -> 0x047a }
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x047a }
                    r1.<init>()     // Catch:{ Exception -> 0x047a }
                    r1.append(r10)     // Catch:{ Exception -> 0x047a }
                    r13 = r40
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x051a }
                    java.lang.String r8 = "Same Subclass"
                    java.lang.String r9 = ""
                    java.lang.String r10 = "LTR"
                    java.lang.String r12 = ""
                    java.lang.String r20 = ""
                    r28 = r6
                    r6 = r13
                    r13 = r25
                    r30 = r2
                    r2 = r14
                    r14 = r20
                    java.lang.String r7 = r7.N4(r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x0517 }
                    r1.append(r7)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0517 }
                    r10 = r1
                    goto L_0x0525
                L_0x0517:
                    r0 = move-exception
                    goto L_0x0018
                L_0x051a:
                    r0 = move-exception
                    r6 = r13
                    goto L_0x0018
                L_0x051e:
                    r30 = r2
                    r28 = r6
                    r2 = r14
                    r6 = r40
                L_0x0525:
                    java.util.Iterator r1 = r19.iterator()     // Catch:{ Exception -> 0x0517 }
                    r7 = r32
                L_0x052b:
                    boolean r8 = r1.hasNext()     // Catch:{ Exception -> 0x0517 }
                    if (r8 == 0) goto L_0x056d
                    java.lang.Object r8 = r1.next()     // Catch:{ Exception -> 0x0517 }
                    android.os.Bundle r8 = (android.os.Bundle) r8     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r9.<init>()     // Catch:{ Exception -> 0x0517 }
                    r9.append(r7)     // Catch:{ Exception -> 0x0517 }
                    r9.append(r5)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r7 = "DRUG_CLASS.ID"
                    java.lang.String r7 = r8.getString(r7)     // Catch:{ Exception -> 0x0517 }
                    r9.append(r7)     // Catch:{ Exception -> 0x0517 }
                    r9.append(r2)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r7 = "DRUG_CLASS.NAME"
                    java.lang.String r7 = r8.getString(r7)     // Catch:{ Exception -> 0x0517 }
                    r9.append(r7)     // Catch:{ Exception -> 0x0517 }
                    r9.append(r4)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r7 = "DRUG_CLASS.NAME"
                    java.lang.String r7 = r8.getString(r7)     // Catch:{ Exception -> 0x0517 }
                    r9.append(r7)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r7 = "</a><br/></li>"
                    r9.append(r7)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r7 = r9.toString()     // Catch:{ Exception -> 0x0517 }
                    goto L_0x052b
                L_0x056d:
                    int r1 = r7.length()     // Catch:{ Exception -> 0x0517 }
                    if (r1 <= 0) goto L_0x05a6
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r1.<init>()     // Catch:{ Exception -> 0x0517 }
                    r1.append(r3)     // Catch:{ Exception -> 0x0517 }
                    r1.append(r7)     // Catch:{ Exception -> 0x0517 }
                    r1.append(r15)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r11 = r1.toString()     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r1.<init>()     // Catch:{ Exception -> 0x0517 }
                    r1.append(r10)     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = "Related Subclasses"
                    java.lang.String r9 = ""
                    java.lang.String r10 = "LTR"
                    java.lang.String r12 = ""
                    java.lang.String r14 = ""
                    r13 = r25
                    java.lang.String r5 = r7.N4(r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x0517 }
                    r1.append(r5)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r10 = r1.toString()     // Catch:{ Exception -> 0x0517 }
                L_0x05a6:
                    int r1 = r10.length()     // Catch:{ Exception -> 0x0517 }
                    if (r1 <= 0) goto L_0x05b3
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r1 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r5 = "Alternatives"
                    r1.J4(r5, r10)     // Catch:{ Exception -> 0x0517 }
                L_0x05b3:
                    r5 = r18
                    r1 = r31
                    java.lang.String r7 = r5.getString(r1)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = "6"
                    boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x0517 }
                    if (r7 == 0) goto L_0x0602
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = "1"
                    java.lang.String r7 = r7.S4(r8)     // Catch:{ Exception -> 0x0517 }
                    int r8 = r7.length()     // Catch:{ Exception -> 0x0517 }
                    if (r8 <= 0) goto L_0x05d8
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r8 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r9 = "Uses"
                    r8.J4(r9, r7)     // Catch:{ Exception -> 0x0517 }
                L_0x05d8:
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = "5"
                    java.lang.String r7 = r7.S4(r8)     // Catch:{ Exception -> 0x0517 }
                    int r8 = r7.length()     // Catch:{ Exception -> 0x0517 }
                    if (r8 <= 0) goto L_0x05ed
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r8 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r9 = "Dosing"
                    r8.J4(r9, r7)     // Catch:{ Exception -> 0x0517 }
                L_0x05ed:
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = "9"
                    java.lang.String r7 = r7.S4(r8)     // Catch:{ Exception -> 0x0517 }
                    int r8 = r7.length()     // Catch:{ Exception -> 0x0517 }
                    if (r8 <= 0) goto L_0x0602
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r8 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r9 = "Formulations"
                    r8.J4(r9, r7)     // Catch:{ Exception -> 0x0517 }
                L_0x0602:
                    java.lang.String r7 = "BBW_ID"
                    java.lang.String r7 = r5.getString(r7)     // Catch:{ Exception -> 0x0517 }
                    r14 = r24
                    boolean r8 = r7.equals(r14)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r13 = "DESCRIPTION_STRING_ID"
                    java.lang.String r12 = " order by display_order"
                    if (r8 != 0) goto L_0x061a
                    int r8 = r7.length()     // Catch:{ Exception -> 0x0517 }
                    if (r8 != 0) goto L_0x0626
                L_0x061a:
                    r31 = r1
                    r19 = r3
                    r3 = r12
                    r33 = r13
                    r20 = r15
                    r15 = r14
                    goto L_0x06c4
                L_0x0626:
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r8 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Data.CompressHelper r9 = r8.Q4     // Catch:{ Exception -> 0x0517 }
                    android.os.Bundle r8 = r8.D4     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r10.<init>()     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r11 = "Select * from BBW_ENTRY where bbw_id="
                    r10.append(r11)     // Catch:{ Exception -> 0x0517 }
                    r10.append(r7)     // Catch:{ Exception -> 0x0517 }
                    r10.append(r12)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r7 = r10.toString()     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r10 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r10 = r10.a5     // Catch:{ Exception -> 0x0517 }
                    r11 = 1
                    java.util.ArrayList r7 = r9.X(r8, r7, r10, r11)     // Catch:{ Exception -> 0x0517 }
                    java.util.Iterator r18 = r7.iterator()     // Catch:{ Exception -> 0x0517 }
                    r10 = r32
                L_0x064f:
                    boolean r7 = r18.hasNext()     // Catch:{ Exception -> 0x0517 }
                    if (r7 == 0) goto L_0x06ad
                    java.lang.Object r7 = r18.next()     // Catch:{ Exception -> 0x0517 }
                    android.os.Bundle r7 = (android.os.Bundle) r7     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r8 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r9 = "HEADER_STRING_ID"
                    java.lang.String r9 = r7.getString(r9)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = r8.Q4(r9)     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r9 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r7 = r7.getString(r13)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r11 = r9.Q4(r7)     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r9.<init>()     // Catch:{ Exception -> 0x0517 }
                    r9.append(r10)     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r10 = ""
                    java.lang.String r19 = "LTR"
                    java.lang.String r20 = ""
                    java.lang.String r24 = ""
                    r31 = r1
                    r1 = r9
                    r9 = r10
                    r10 = r19
                    r19 = r3
                    r3 = r12
                    r12 = r20
                    r33 = r13
                    r13 = r25
                    r20 = r15
                    r15 = r14
                    r14 = r24
                    java.lang.String r7 = r7.N4(r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x0517 }
                    r1.append(r7)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r10 = r1.toString()     // Catch:{ Exception -> 0x0517 }
                    r12 = r3
                    r14 = r15
                    r3 = r19
                    r15 = r20
                    r1 = r31
                    r13 = r33
                    goto L_0x064f
                L_0x06ad:
                    r31 = r1
                    r19 = r3
                    r3 = r12
                    r33 = r13
                    r20 = r15
                    r15 = r14
                    int r1 = r10.length()     // Catch:{ Exception -> 0x0517 }
                    if (r1 <= 0) goto L_0x06c4
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r1 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r7 = "Black Box Warnings"
                    r1.J4(r7, r10)     // Catch:{ Exception -> 0x0517 }
                L_0x06c4:
                    java.lang.String r1 = "CLINICAL_ID"
                    java.lang.String r1 = r5.getString(r1)     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Data.CompressHelper r8 = r7.Q4     // Catch:{ Exception -> 0x0517 }
                    android.os.Bundle r7 = r7.D4     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r9.<init>()     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r10 = "SELECT  CLINICAL.ID ,  CLINICAL.NAME ,  CLINICAL.TYPE ,  CLINICAL.METABOLISM_STRING_ID ,  CLINICAL.EXCRETION_STRING_ID ,  CLINICAL.MECHANISM_STRING_ID ,  CLINICAL.PREG_ENTRY_ID ,  CLINICAL.LACT_ENTRY_ID ,  CLINICAL.DEA_ENTRY_ID   FROM CLINICAL   WHERE  ID =  "
                    r9.append(r10)     // Catch:{ Exception -> 0x0517 }
                    r9.append(r1)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r10 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r10 = r10.a5     // Catch:{ Exception -> 0x0517 }
                    r11 = 1
                    java.util.ArrayList r7 = r8.X(r7, r9, r10, r11)     // Catch:{ Exception -> 0x0517 }
                    android.os.Bundle r7 = r8.s1(r7)     // Catch:{ Exception -> 0x0517 }
                    if (r7 == 0) goto L_0x07a1
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r8 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r9 = "METABOLISM_STRING_ID"
                    java.lang.String r9 = r7.getString(r9)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r11 = r8.V4(r9)     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r8 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r9 = "EXCRETION_STRING_ID"
                    java.lang.String r9 = r7.getString(r9)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r18 = r8.V4(r9)     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r8 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r9 = "MECHANISM_STRING_ID"
                    java.lang.String r7 = r7.getString(r9)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r24 = r8.V4(r7)     // Catch:{ Exception -> 0x0517 }
                    int r7 = r11.length()     // Catch:{ Exception -> 0x0517 }
                    if (r7 <= 0) goto L_0x0746
                    java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r14.<init>()     // Catch:{ Exception -> 0x0517 }
                    r13 = r32
                    r14.append(r13)     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = "Metabolism"
                    java.lang.String r9 = ""
                    java.lang.String r10 = "LTR"
                    java.lang.String r12 = ""
                    java.lang.String r32 = ""
                    r34 = r3
                    r3 = r13
                    r13 = r25
                    r35 = r1
                    r1 = r14
                    r14 = r32
                    java.lang.String r7 = r7.N4(r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x0517 }
                    r1.append(r7)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r10 = r1.toString()     // Catch:{ Exception -> 0x0517 }
                    goto L_0x074d
                L_0x0746:
                    r35 = r1
                    r34 = r3
                    r3 = r32
                    r10 = r3
                L_0x074d:
                    int r1 = r18.length()     // Catch:{ Exception -> 0x0517 }
                    if (r1 <= 0) goto L_0x0777
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r1.<init>()     // Catch:{ Exception -> 0x0517 }
                    r1.append(r10)     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = "Excretion"
                    java.lang.String r9 = ""
                    java.lang.String r10 = "LTR"
                    java.lang.String r12 = ""
                    java.lang.String r14 = ""
                    r11 = r18
                    r13 = r25
                    java.lang.String r7 = r7.N4(r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x0517 }
                    r1.append(r7)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0517 }
                    r10 = r1
                L_0x0777:
                    int r1 = r24.length()     // Catch:{ Exception -> 0x0517 }
                    if (r1 <= 0) goto L_0x07a8
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r1.<init>()     // Catch:{ Exception -> 0x0517 }
                    r1.append(r10)     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = "Mechanism of Action"
                    java.lang.String r9 = ""
                    java.lang.String r10 = "LTR"
                    java.lang.String r12 = ""
                    java.lang.String r14 = ""
                    r11 = r24
                    r13 = r25
                    java.lang.String r7 = r7.N4(r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x0517 }
                    r1.append(r7)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r10 = r1.toString()     // Catch:{ Exception -> 0x0517 }
                    goto L_0x07a8
                L_0x07a1:
                    r35 = r1
                    r34 = r3
                    r3 = r32
                    r10 = r3
                L_0x07a8:
                    java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Exception -> 0x0517 }
                    r1.<init>()     // Catch:{ Exception -> 0x0517 }
                    java.util.Iterator r7 = r29.iterator()     // Catch:{ Exception -> 0x0517 }
                L_0x07b1:
                    boolean r8 = r7.hasNext()     // Catch:{ Exception -> 0x0517 }
                    if (r8 == 0) goto L_0x07f7
                    java.lang.Object r8 = r7.next()     // Catch:{ Exception -> 0x0517 }
                    android.os.Bundle r8 = (android.os.Bundle) r8     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r9.<init>()     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r11 = "<a href=\"grp://"
                    r9.append(r11)     // Catch:{ Exception -> 0x0517 }
                    r14 = r30
                    java.lang.String r11 = r8.getString(r14)     // Catch:{ Exception -> 0x0517 }
                    r9.append(r11)     // Catch:{ Exception -> 0x0517 }
                    r9.append(r2)     // Catch:{ Exception -> 0x0517 }
                    r13 = r28
                    java.lang.String r11 = r8.getString(r13)     // Catch:{ Exception -> 0x0517 }
                    r9.append(r11)     // Catch:{ Exception -> 0x0517 }
                    r9.append(r4)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = r8.getString(r13)     // Catch:{ Exception -> 0x0517 }
                    r9.append(r8)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = "</a>"
                    r9.append(r8)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = r9.toString()     // Catch:{ Exception -> 0x0517 }
                    r1.add(r8)     // Catch:{ Exception -> 0x0517 }
                    r28 = r13
                    r30 = r14
                    goto L_0x07b1
                L_0x07f7:
                    r13 = r28
                    r14 = r30
                    int r2 = r1.size()     // Catch:{ Exception -> 0x0517 }
                    if (r2 <= 0) goto L_0x0830
                    java.lang.String r2 = "; "
                    java.lang.String r11 = org.apache.commons.lang3.StringUtils.join((java.lang.Iterable<?>) r1, (java.lang.String) r2)     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r1.<init>()     // Catch:{ Exception -> 0x0517 }
                    r1.append(r10)     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = "Subclasses"
                    java.lang.String r9 = ""
                    java.lang.String r10 = "LTR"
                    java.lang.String r12 = ""
                    java.lang.String r2 = ""
                    r18 = r4
                    r4 = r13
                    r13 = r25
                    r28 = r4
                    r4 = r14
                    r14 = r2
                    java.lang.String r2 = r7.N4(r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x0517 }
                    r1.append(r2)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r10 = r1.toString()     // Catch:{ Exception -> 0x0517 }
                    goto L_0x0835
                L_0x0830:
                    r18 = r4
                    r28 = r13
                    r4 = r14
                L_0x0835:
                    int r1 = r10.length()     // Catch:{ Exception -> 0x0517 }
                    if (r1 <= 0) goto L_0x0842
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r1 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r2 = "Pharmacology"
                    r1.J4(r2, r10)     // Catch:{ Exception -> 0x0517 }
                L_0x0842:
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r1 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Data.CompressHelper r2 = r1.Q4     // Catch:{ Exception -> 0x0517 }
                    android.os.Bundle r1 = r1.D4     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r7.<init>()     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = "SELECT  PREGNANCY_ENTRY.ID ,  PREGNANCY_ENTRY.DISPLAY_ORDER ,  PREGNANCY_ENTRY.TERM ,  PREGNANCY_ENTRY.DEFINITION   FROM CLINICAL_PREGNANCY   JOIN PREGNANCY_ENTRY ON  CLINICAL_PREGNANCY.CLINICAL_ID =  "
                    r7.append(r8)     // Catch:{ Exception -> 0x0517 }
                    r14 = r23
                    r7.append(r14)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = "   AND PREGNANCY_ENTRY.ID = CLINICAL_PREGNANCY.PREG_ENTRY_ID    ORDER BY  PREGNANCY_ENTRY.DISPLAY_ORDER"
                    r7.append(r8)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r8 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = r8.a5     // Catch:{ Exception -> 0x0517 }
                    r9 = 1
                    java.util.ArrayList r1 = r2.X(r1, r7, r8, r9)     // Catch:{ Exception -> 0x0517 }
                    android.os.Bundle r1 = r2.s1(r1)     // Catch:{ Exception -> 0x0517 }
                    if (r1 == 0) goto L_0x08ba
                    java.lang.String r2 = "TERM"
                    java.lang.String r2 = r1.getString(r2)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r7 = "DEFINITION"
                    java.lang.String r1 = r1.getString(r7)     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r7.<init>()     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = "<b>"
                    r7.append(r8)     // Catch:{ Exception -> 0x0517 }
                    r7.append(r2)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r2 = ": </b>"
                    r7.append(r2)     // Catch:{ Exception -> 0x0517 }
                    r7.append(r1)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r11 = r7.toString()     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r1.<init>()     // Catch:{ Exception -> 0x0517 }
                    r1.append(r3)     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = "Pregnancy"
                    java.lang.String r9 = ""
                    java.lang.String r10 = "LTR"
                    java.lang.String r12 = ""
                    java.lang.String r2 = ""
                    r13 = r25
                    r30 = r4
                    r4 = r14
                    r14 = r2
                    java.lang.String r2 = r7.N4(r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x0517 }
                    r1.append(r2)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r10 = r1.toString()     // Catch:{ Exception -> 0x0517 }
                    goto L_0x08be
                L_0x08ba:
                    r30 = r4
                    r4 = r14
                    r10 = r3
                L_0x08be:
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r1 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Data.CompressHelper r2 = r1.Q4     // Catch:{ Exception -> 0x0517 }
                    android.os.Bundle r1 = r1.D4     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r7.<init>()     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = "SELECT  LACTATION_ENTRY.ID ,  LACTATION_ENTRY.DISPLAY_ORDER ,  LACTATION_ENTRY.TERM ,  LACTATION_ENTRY.DEFINITION   FROM CLINICAL_LACTATION   JOIN LACTATION_ENTRY ON  CLINICAL_LACTATION.CLINICAL_ID =  "
                    r7.append(r8)     // Catch:{ Exception -> 0x0517 }
                    r7.append(r4)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = "  AND LACTATION_ENTRY.ID = CLINICAL_LACTATION.LACT_ENTRY_ID    ORDER BY  LACTATION_ENTRY.DISPLAY_ORDER"
                    r7.append(r8)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r8 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = r8.a5     // Catch:{ Exception -> 0x0517 }
                    r9 = 1
                    java.util.ArrayList r1 = r2.X(r1, r7, r8, r9)     // Catch:{ Exception -> 0x0517 }
                    android.os.Bundle r1 = r2.s1(r1)     // Catch:{ Exception -> 0x0517 }
                    if (r1 == 0) goto L_0x092f
                    java.lang.String r2 = "TERM"
                    java.lang.String r2 = r1.getString(r2)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r7 = "DEFINITION"
                    java.lang.String r1 = r1.getString(r7)     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r7.<init>()     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = "<b>"
                    r7.append(r8)     // Catch:{ Exception -> 0x0517 }
                    r7.append(r2)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r2 = ": </b>"
                    r7.append(r2)     // Catch:{ Exception -> 0x0517 }
                    r7.append(r1)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r11 = r7.toString()     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r1.<init>()     // Catch:{ Exception -> 0x0517 }
                    r1.append(r10)     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = "Lactation"
                    java.lang.String r9 = ""
                    java.lang.String r10 = "LTR"
                    java.lang.String r12 = ""
                    java.lang.String r14 = ""
                    r13 = r25
                    java.lang.String r2 = r7.N4(r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x0517 }
                    r1.append(r2)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r10 = r1.toString()     // Catch:{ Exception -> 0x0517 }
                L_0x092f:
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r1 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Data.CompressHelper r2 = r1.Q4     // Catch:{ Exception -> 0x0517 }
                    android.os.Bundle r1 = r1.D4     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r7.<init>()     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = "SELECT  SAFETY.ID ,  SAFETY.DRUG_ID ,  SAFETY.DISPLAY_ORDER ,  SAFETY.HEADER_STRING_ID ,  SAFETY.SAFETY_STRING_ID   FROM SAFETY   WHERE  DRUG_ID =  "
                    r7.append(r8)     // Catch:{ Exception -> 0x0517 }
                    r14 = r16
                    r7.append(r14)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = " ORDER BY  SAFETY.DISPLAY_ORDER"
                    r7.append(r8)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r8 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = r8.a5     // Catch:{ Exception -> 0x0517 }
                    r9 = 1
                    java.util.ArrayList r1 = r2.X(r1, r7, r8, r9)     // Catch:{ Exception -> 0x0517 }
                    java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x0517 }
                L_0x095a:
                    boolean r2 = r1.hasNext()     // Catch:{ Exception -> 0x0517 }
                    if (r2 == 0) goto L_0x09a6
                    java.lang.Object r2 = r1.next()     // Catch:{ Exception -> 0x0517 }
                    android.os.Bundle r2 = (android.os.Bundle) r2     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = "HEADER_STRING_ID"
                    java.lang.String r8 = r2.getString(r8)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = r7.U4(r8)     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r9 = "SAFETY_STRING_ID"
                    java.lang.String r2 = r2.getString(r9)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r11 = r7.U4(r2)     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r2.<init>()     // Catch:{ Exception -> 0x0517 }
                    r2.append(r10)     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r9 = ""
                    java.lang.String r10 = "LTR"
                    java.lang.String r12 = ""
                    java.lang.String r16 = ""
                    r13 = r25
                    r23 = r1
                    r1 = r14
                    r14 = r16
                    java.lang.String r7 = r7.N4(r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x0517 }
                    r2.append(r7)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r10 = r2.toString()     // Catch:{ Exception -> 0x0517 }
                    r14 = r1
                    r1 = r23
                    goto L_0x095a
                L_0x09a6:
                    r1 = r14
                    int r2 = r10.length()     // Catch:{ Exception -> 0x0517 }
                    if (r2 <= 0) goto L_0x09b4
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r2 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r7 = "Safety/Monitoring"
                    r2.J4(r7, r10)     // Catch:{ Exception -> 0x0517 }
                L_0x09b4:
                    java.lang.String r2 = "MFR_STRING_ID"
                    java.lang.String r2 = r5.getString(r2)     // Catch:{ Exception -> 0x0517 }
                    int r7 = r2.length()     // Catch:{ Exception -> 0x0517 }
                    if (r7 == 0) goto L_0x09ef
                    boolean r7 = r2.equals(r15)     // Catch:{ Exception -> 0x0517 }
                    if (r7 == 0) goto L_0x09c7
                    goto L_0x09ef
                L_0x09c7:
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r11 = r7.V4(r2)     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r2.<init>()     // Catch:{ Exception -> 0x0517 }
                    r2.append(r3)     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = "Manufacturer"
                    java.lang.String r9 = ""
                    java.lang.String r10 = "LTR"
                    java.lang.String r12 = ""
                    java.lang.String r14 = ""
                    r13 = r25
                    java.lang.String r7 = r7.N4(r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x0517 }
                    r2.append(r7)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r10 = r2.toString()     // Catch:{ Exception -> 0x0517 }
                    goto L_0x09f0
                L_0x09ef:
                    r10 = r3
                L_0x09f0:
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r2 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Data.CompressHelper r7 = r2.Q4     // Catch:{ Exception -> 0x0517 }
                    android.os.Bundle r2 = r2.D4     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r8.<init>()     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r9 = "SELECT  DEA_ENTRY.ID ,  DEA_ENTRY.DISPLAY_ORDER ,  DEA_ENTRY.TERM ,  DEA_ENTRY.DEFINITION   FROM CLINICAL_DEA   JOIN DEA_ENTRY ON  CLINICAL_DEA.CLINICAL_ID =  "
                    r8.append(r9)     // Catch:{ Exception -> 0x0517 }
                    r15 = r35
                    r8.append(r15)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r9 = "   AND DEA_ENTRY.ID = CLINICAL_DEA.DEA_ENTRY_ID    ORDER BY  DEA_ENTRY.DISPLAY_ORDER"
                    r8.append(r9)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r9 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r9 = r9.a5     // Catch:{ Exception -> 0x0517 }
                    r11 = 1
                    java.util.ArrayList r2 = r7.X(r2, r8, r9, r11)     // Catch:{ Exception -> 0x0517 }
                    android.os.Bundle r2 = r7.s1(r2)     // Catch:{ Exception -> 0x0517 }
                    if (r2 == 0) goto L_0x0a63
                    java.lang.String r7 = "TERM"
                    java.lang.String r7 = r2.getString(r7)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = "DEFINITION"
                    java.lang.String r2 = r2.getString(r8)     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r8.<init>()     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r9 = "<b>"
                    r8.append(r9)     // Catch:{ Exception -> 0x0517 }
                    r8.append(r7)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r7 = " :</b>"
                    r8.append(r7)     // Catch:{ Exception -> 0x0517 }
                    r8.append(r2)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r11 = r8.toString()     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r2.<init>()     // Catch:{ Exception -> 0x0517 }
                    r2.append(r10)     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = "DEA/FDA"
                    java.lang.String r9 = ""
                    java.lang.String r10 = "LTR"
                    java.lang.String r12 = ""
                    java.lang.String r14 = ""
                    r13 = r25
                    java.lang.String r7 = r7.N4(r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x0517 }
                    r2.append(r7)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r10 = r2.toString()     // Catch:{ Exception -> 0x0517 }
                L_0x0a63:
                    r2 = r10
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Data.CompressHelper r8 = r7.Q4     // Catch:{ Exception -> 0x0517 }
                    android.os.Bundle r7 = r7.D4     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r9.<init>()     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r10 = "SELECT  PRICING_STRENGTH.PRICING_STRENGTH_ID ,  PRICING_STRENGTH.DRUG_ID ,  PRICING_STRENGTH.HEADER_ID ,  PRICING_STRENGTH.SOURCE_ID ,  PRICING_STRENGTH.UNIT_ID ,  PRICING_STRENGTH.COMBO_ID ,  PRICING_STRENGTH.FORM_ID ,  PRICING_STRENGTH.STRENGTH ,  PRICING_STRENGTH.QUANTITY ,  PRICING_STRENGTH.PRICE   FROM PRICING_STRENGTH   WHERE  DRUG_ID =  "
                    r9.append(r10)     // Catch:{ Exception -> 0x0517 }
                    r9.append(r1)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r10 = "  ORDER BY  PRICING_STRENGTH.FORM_ID ,  PRICING_STRENGTH.STRENGTH"
                    r9.append(r10)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r10 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r10 = r10.a5     // Catch:{ Exception -> 0x0517 }
                    r11 = 1
                    java.util.ArrayList r7 = r8.X(r7, r9, r10, r11)     // Catch:{ Exception -> 0x0517 }
                    java.util.Iterator r16 = r7.iterator()     // Catch:{ Exception -> 0x0517 }
                    r10 = r3
                L_0x0a8e:
                    boolean r7 = r16.hasNext()     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r14 = "STRING"
                    if (r7 == 0) goto L_0x0b6f
                    java.lang.Object r7 = r16.next()     // Catch:{ Exception -> 0x0517 }
                    android.os.Bundle r7 = (android.os.Bundle) r7     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r8 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r9 = "HEADER_ID"
                    java.lang.String r9 = r7.getString(r9)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = r8.T4(r9)     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r9 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r11 = "SOURCE_ID"
                    java.lang.String r11 = r7.getString(r11)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r9 = r9.T4(r11)     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r11 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r12 = "UNIT_ID"
                    java.lang.String r12 = r7.getString(r12)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r11 = r11.T4(r12)     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r12 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Data.CompressHelper r13 = r12.Q4     // Catch:{ Exception -> 0x0517 }
                    android.os.Bundle r12 = r12.D4     // Catch:{ Exception -> 0x0517 }
                    r23 = r5
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r5.<init>()     // Catch:{ Exception -> 0x0517 }
                    r24 = r4
                    java.lang.String r4 = "SELECT  FORMULATION.ID ,  FORMULATION.STRING ,  FORMULATION.ABBR   FROM FORMULATION   WHERE  ID = "
                    r5.append(r4)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r4 = "FORM_ID"
                    java.lang.String r4 = r7.getString(r4)     // Catch:{ Exception -> 0x0517 }
                    r5.append(r4)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r4 = r5.toString()     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r5 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r5 = r5.a5     // Catch:{ Exception -> 0x0517 }
                    r29 = r1
                    r1 = 1
                    java.util.ArrayList r4 = r13.X(r12, r4, r5, r1)     // Catch:{ Exception -> 0x0517 }
                    android.os.Bundle r1 = r13.s1(r4)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r4 = r1.getString(r14)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r5 = "ABBR"
                    java.lang.String r1 = r1.getString(r5)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r5 = "STRENGTH"
                    java.lang.String r5 = r7.getString(r5)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r12 = "QUANTITY"
                    java.lang.String r12 = r7.getString(r12)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r13 = "PRICE"
                    java.lang.String r7 = r7.getString(r13)     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r13.<init>()     // Catch:{ Exception -> 0x0517 }
                    r13.append(r9)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r9 = "<br/>["
                    r13.append(r9)     // Catch:{ Exception -> 0x0517 }
                    r13.append(r4)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r4 = "] "
                    r13.append(r4)     // Catch:{ Exception -> 0x0517 }
                    r13.append(r5)     // Catch:{ Exception -> 0x0517 }
                    r13.append(r11)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r4 = " ("
                    r13.append(r4)     // Catch:{ Exception -> 0x0517 }
                    r13.append(r12)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r4 = " "
                    r13.append(r4)     // Catch:{ Exception -> 0x0517 }
                    r13.append(r1)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r1 = "): "
                    r13.append(r1)     // Catch:{ Exception -> 0x0517 }
                    r13.append(r7)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r1 = "$"
                    r13.append(r1)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r11 = r13.toString()     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r1.<init>()     // Catch:{ Exception -> 0x0517 }
                    r1.append(r10)     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r9 = ""
                    java.lang.String r10 = "LTR"
                    java.lang.String r12 = ""
                    java.lang.String r14 = ""
                    r13 = r25
                    java.lang.String r4 = r7.N4(r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x0517 }
                    r1.append(r4)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r10 = r1.toString()     // Catch:{ Exception -> 0x0517 }
                    r5 = r23
                    r4 = r24
                    r1 = r29
                    goto L_0x0a8e
                L_0x0b6f:
                    r29 = r1
                    r24 = r4
                    r23 = r5
                    int r1 = r10.length()     // Catch:{ Exception -> 0x0517 }
                    if (r1 <= 0) goto L_0x0b8a
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r1.<init>()     // Catch:{ Exception -> 0x0517 }
                    r1.append(r2)     // Catch:{ Exception -> 0x0517 }
                    r1.append(r10)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r2 = r1.toString()     // Catch:{ Exception -> 0x0517 }
                L_0x0b8a:
                    int r1 = r2.length()     // Catch:{ Exception -> 0x0517 }
                    if (r1 <= 0) goto L_0x0b97
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r1 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r4 = "Manufacturer/Pricing"
                    r1.J4(r4, r2)     // Catch:{ Exception -> 0x0517 }
                L_0x0b97:
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r1 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Data.CompressHelper r2 = r1.Q4     // Catch:{ Exception -> 0x0517 }
                    android.os.Bundle r1 = r1.D4     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r4.<init>()     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r5 = "select * from contraindication inner join general_string on contraindication.description_string_id = general_string.id where clinical_id="
                    r4.append(r5)     // Catch:{ Exception -> 0x0517 }
                    r4.append(r15)     // Catch:{ Exception -> 0x0517 }
                    r5 = r34
                    r4.append(r5)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r7 = r7.a5     // Catch:{ Exception -> 0x0517 }
                    r8 = 1
                    java.util.ArrayList r1 = r2.X(r1, r4, r7, r8)     // Catch:{ Exception -> 0x0517 }
                    java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x0517 }
                    r10 = r3
                L_0x0bc1:
                    boolean r2 = r1.hasNext()     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r4 = "</li>"
                    java.lang.String r13 = "<li>"
                    if (r2 == 0) goto L_0x0beb
                    java.lang.Object r2 = r1.next()     // Catch:{ Exception -> 0x0517 }
                    android.os.Bundle r2 = (android.os.Bundle) r2     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r7.<init>()     // Catch:{ Exception -> 0x0517 }
                    r7.append(r10)     // Catch:{ Exception -> 0x0517 }
                    r7.append(r13)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r2 = r2.getString(r14)     // Catch:{ Exception -> 0x0517 }
                    r7.append(r2)     // Catch:{ Exception -> 0x0517 }
                    r7.append(r4)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r10 = r7.toString()     // Catch:{ Exception -> 0x0517 }
                    goto L_0x0bc1
                L_0x0beb:
                    int r1 = r10.length()     // Catch:{ Exception -> 0x0517 }
                    if (r1 <= 0) goto L_0x0c0f
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r1.<init>()     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r2 = "<ul style=\"margin-left=20px;margin-top:10px\">"
                    r1.append(r2)     // Catch:{ Exception -> 0x0517 }
                    r1.append(r10)     // Catch:{ Exception -> 0x0517 }
                    r2 = r20
                    r1.append(r2)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = "Contraindications/Cautions"
                    r7.J4(r8, r1)     // Catch:{ Exception -> 0x0517 }
                    goto L_0x0c11
                L_0x0c0f:
                    r2 = r20
                L_0x0c11:
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r1 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Data.CompressHelper r7 = r1.Q4     // Catch:{ Exception -> 0x0517 }
                    android.os.Bundle r1 = r1.D4     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r8.<init>()     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r9 = "select * from serious_reaction inner join general_string on serious_reaction.description_string_id = general_string.id where clinical_id="
                    r8.append(r9)     // Catch:{ Exception -> 0x0517 }
                    r8.append(r15)     // Catch:{ Exception -> 0x0517 }
                    r8.append(r5)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r9 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r9 = r9.a5     // Catch:{ Exception -> 0x0517 }
                    r10 = 1
                    java.util.ArrayList r1 = r7.X(r1, r8, r9, r10)     // Catch:{ Exception -> 0x0517 }
                    java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x0517 }
                    r10 = r3
                L_0x0c39:
                    boolean r7 = r1.hasNext()     // Catch:{ Exception -> 0x0517 }
                    if (r7 == 0) goto L_0x0c5f
                    java.lang.Object r7 = r1.next()     // Catch:{ Exception -> 0x0517 }
                    android.os.Bundle r7 = (android.os.Bundle) r7     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r8.<init>()     // Catch:{ Exception -> 0x0517 }
                    r8.append(r10)     // Catch:{ Exception -> 0x0517 }
                    r8.append(r13)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r7 = r7.getString(r14)     // Catch:{ Exception -> 0x0517 }
                    r8.append(r7)     // Catch:{ Exception -> 0x0517 }
                    r8.append(r4)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r10 = r8.toString()     // Catch:{ Exception -> 0x0517 }
                    goto L_0x0c39
                L_0x0c5f:
                    int r1 = r10.length()     // Catch:{ Exception -> 0x0517 }
                    if (r1 <= 0) goto L_0x0ca8
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r1.<init>()     // Catch:{ Exception -> 0x0517 }
                    r12 = r19
                    r1.append(r12)     // Catch:{ Exception -> 0x0517 }
                    r1.append(r10)     // Catch:{ Exception -> 0x0517 }
                    r1.append(r2)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r11 = r1.toString()     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r1.<init>()     // Catch:{ Exception -> 0x0517 }
                    r1.append(r3)     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = "Serious Reactions"
                    java.lang.String r9 = ""
                    java.lang.String r10 = "LTR"
                    java.lang.String r16 = ""
                    java.lang.String r19 = ""
                    r20 = r3
                    r3 = r12
                    r12 = r16
                    r16 = r2
                    r2 = r13
                    r13 = r25
                    r32 = r3
                    r3 = r14
                    r14 = r19
                    java.lang.String r7 = r7.N4(r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x0517 }
                    r1.append(r7)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r10 = r1.toString()     // Catch:{ Exception -> 0x0517 }
                    goto L_0x0cb2
                L_0x0ca8:
                    r16 = r2
                    r20 = r3
                    r2 = r13
                    r3 = r14
                    r32 = r19
                    r10 = r20
                L_0x0cb2:
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r1 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Data.CompressHelper r7 = r1.Q4     // Catch:{ Exception -> 0x0517 }
                    android.os.Bundle r1 = r1.D4     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r8.<init>()     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r9 = "select * from common_reaction inner join general_string on common_reaction.description_string_id = general_string.id where clinical_id="
                    r8.append(r9)     // Catch:{ Exception -> 0x0517 }
                    r8.append(r15)     // Catch:{ Exception -> 0x0517 }
                    r8.append(r5)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r9 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r9 = r9.a5     // Catch:{ Exception -> 0x0517 }
                    r11 = 1
                    java.util.ArrayList r1 = r7.X(r1, r8, r9, r11)     // Catch:{ Exception -> 0x0517 }
                    java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x0517 }
                    r7 = r20
                L_0x0cdb:
                    boolean r8 = r1.hasNext()     // Catch:{ Exception -> 0x0517 }
                    if (r8 == 0) goto L_0x0d01
                    java.lang.Object r8 = r1.next()     // Catch:{ Exception -> 0x0517 }
                    android.os.Bundle r8 = (android.os.Bundle) r8     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r9.<init>()     // Catch:{ Exception -> 0x0517 }
                    r9.append(r7)     // Catch:{ Exception -> 0x0517 }
                    r9.append(r2)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r7 = r8.getString(r3)     // Catch:{ Exception -> 0x0517 }
                    r9.append(r7)     // Catch:{ Exception -> 0x0517 }
                    r9.append(r4)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r7 = r9.toString()     // Catch:{ Exception -> 0x0517 }
                    goto L_0x0cdb
                L_0x0d01:
                    int r1 = r7.length()     // Catch:{ Exception -> 0x0517 }
                    if (r1 <= 0) goto L_0x0d3f
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r1.<init>()     // Catch:{ Exception -> 0x0517 }
                    r3 = r32
                    r1.append(r3)     // Catch:{ Exception -> 0x0517 }
                    r1.append(r7)     // Catch:{ Exception -> 0x0517 }
                    r15 = r16
                    r1.append(r15)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r11 = r1.toString()     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r1.<init>()     // Catch:{ Exception -> 0x0517 }
                    r1.append(r10)     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = "Common Reactions"
                    java.lang.String r9 = ""
                    java.lang.String r10 = "LTR"
                    java.lang.String r12 = ""
                    java.lang.String r14 = ""
                    r13 = r25
                    java.lang.String r7 = r7.N4(r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x0517 }
                    r1.append(r7)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r10 = r1.toString()     // Catch:{ Exception -> 0x0517 }
                    goto L_0x0d43
                L_0x0d3f:
                    r15 = r16
                    r3 = r32
                L_0x0d43:
                    int r1 = r10.length()     // Catch:{ Exception -> 0x0517 }
                    if (r1 <= 0) goto L_0x0d50
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r1 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r7 = "Adverse Reactions"
                    r1.J4(r7, r10)     // Catch:{ Exception -> 0x0517 }
                L_0x0d50:
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r1 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Data.CompressHelper r7 = r1.Q4     // Catch:{ Exception -> 0x0517 }
                    android.os.Bundle r1 = r1.D4     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r8.<init>()     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r9 = "Select * from pill_pictures where drug_id="
                    r8.append(r9)     // Catch:{ Exception -> 0x0517 }
                    r9 = r29
                    r8.append(r9)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r9 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r9 = r9.a5     // Catch:{ Exception -> 0x0517 }
                    r10 = 1
                    java.util.ArrayList r1 = r7.X(r1, r8, r9, r10)     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    r7.Y4 = r1     // Catch:{ Exception -> 0x0517 }
                    java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x0517 }
                    r10 = r20
                L_0x0d7c:
                    boolean r7 = r1.hasNext()     // Catch:{ Exception -> 0x0517 }
                    if (r7 == 0) goto L_0x0dbe
                    java.lang.Object r7 = r1.next()     // Catch:{ Exception -> 0x0517 }
                    android.os.Bundle r7 = (android.os.Bundle) r7     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r8.<init>()     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r9 = "http://www.epocrates.com/pillimages/"
                    r8.append(r9)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r9 = "FILENAME"
                    java.lang.String r7 = r7.getString(r9)     // Catch:{ Exception -> 0x0517 }
                    r8.append(r7)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r7 = ".jpg"
                    r8.append(r7)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r7 = r8.toString()     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r8.<init>()     // Catch:{ Exception -> 0x0517 }
                    r8.append(r10)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r9 = "<div style=\"width:90%%;overflow: scroll;\"><img src=\""
                    r8.append(r9)     // Catch:{ Exception -> 0x0517 }
                    r8.append(r7)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r7 = "\" /></div>"
                    r8.append(r7)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r10 = r8.toString()     // Catch:{ Exception -> 0x0517 }
                    goto L_0x0d7c
                L_0x0dbe:
                    int r1 = r10.length()     // Catch:{ Exception -> 0x0517 }
                    if (r1 <= 0) goto L_0x0ddc
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r1.<init>()     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r7 = "</br>"
                    r1.append(r7)     // Catch:{ Exception -> 0x0517 }
                    r1.append(r10)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = "Pill Picture"
                    r7.J4(r8, r1)     // Catch:{ Exception -> 0x0517 }
                L_0x0ddc:
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r1 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Data.CompressHelper r7 = r1.Q4     // Catch:{ Exception -> 0x0517 }
                    android.os.Bundle r1 = r1.D4     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r8.<init>()     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r9 = "SELECT DDI.ID AS DDI_ID,                    DRUG_TO_DDI_GROUP.GROUP_ID AS GROUP_0_ID,                    CASE WHEN DDI.GROUP_0_ID = DRUG_TO_DDI_GROUP.GROUP_ID THEN DDI.GROUP_1_ID ELSE DDI.GROUP_0_ID END AS GROUP_1_ID,                    DDI_GROUP.NAME AS GROUP_1_NAME,                    DDI.CATEGORY_ID,                    DDI.ACTION_STRING_ID,                    DDI.EFFECT_STRING_ID,                    DDI.MECHANISM_STRING_ID,                    (select name from ddi_category where ddi_category.id=ddi.category_id) as CATEGORY,                     (select name from ddi_group where ddi_group.id=DRUG_TO_DDI_GROUP.GROUP_ID) as GROUP_0_NAME,                     (select string from general_string where general_string.id=ddi.action_string_id) as ACTION_STRING,                     (select string from general_string where general_string.id=ddi.effect_string_id) as EFFECT_STRING,                     (select string from general_string where general_string.id=ddi.mechanism_string_id) as MECHANISM_STRING                     FROM DRUG                     JOIN DRUG_TO_DDI_GROUP ON DRUG_TO_DDI_GROUP.DRUG_ID = DRUG.ID                     JOIN DDI ON DDI.GROUP_0_ID = DRUG_TO_DDI_GROUP.GROUP_ID OR DDI.GROUP_1_ID = DRUG_TO_DDI_GROUP.GROUP_ID                     JOIN DDI_GROUP ON DDI_GROUP.ID = CASE WHEN DDI.GROUP_0_ID = DRUG_TO_DDI_GROUP.GROUP_ID THEN DDI.GROUP_1_ID ELSE DDI.GROUP_0_ID END                    WHERE DRUG.ID = "
                    r8.append(r9)     // Catch:{ Exception -> 0x0517 }
                    r14 = r24
                    r8.append(r14)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r9 = "                    ORDER BY CATEGORY_ID, GROUP_1_NAME, GROUP_0_NAME"
                    r8.append(r9)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r9 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r9 = r9.a5     // Catch:{ Exception -> 0x0517 }
                    r10 = 1
                    java.util.ArrayList r1 = r7.X(r1, r8, r9, r10)     // Catch:{ Exception -> 0x0517 }
                    if (r1 == 0) goto L_0x0e0f
                    int r1 = r1.size()     // Catch:{ Exception -> 0x0517 }
                    if (r1 != 0) goto L_0x0e0c
                    goto L_0x0e0f
                L_0x0e0c:
                    java.lang.String r1 = "<div style=\"margin-left:15px;margin-top:5px\"><a href=\"interaction://\">See Interactions</a></div>"
                    goto L_0x0e11
                L_0x0e0f:
                    java.lang.String r1 = "<div style=\"margin-left:15px;margin-top:5px;color:grey;\">No Interactions Found</div>"
                L_0x0e11:
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = "Drug Interaction"
                    r7.J4(r8, r1)     // Catch:{ Exception -> 0x0517 }
                    r13 = r23
                    r1 = r31
                    java.lang.String r7 = r13.getString(r1)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = "7"
                    boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r12 = "<ul style=\"margin-left:10px;margin-top:5px\">"
                    if (r7 == 0) goto L_0x1222
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Data.CompressHelper r8 = r7.Q4     // Catch:{ Exception -> 0x0517 }
                    android.os.Bundle r7 = r7.D4     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r9.<init>()     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r10 = "select * from altmed_use where drug_id="
                    r9.append(r10)     // Catch:{ Exception -> 0x0517 }
                    r9.append(r14)     // Catch:{ Exception -> 0x0517 }
                    r9.append(r5)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r10 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r10 = r10.a5     // Catch:{ Exception -> 0x0517 }
                    r11 = 1
                    java.util.ArrayList r7 = r8.X(r7, r9, r10, r11)     // Catch:{ Exception -> 0x0517 }
                    java.util.Iterator r7 = r7.iterator()     // Catch:{ Exception -> 0x0517 }
                    r10 = r20
                L_0x0e53:
                    boolean r8 = r7.hasNext()     // Catch:{ Exception -> 0x0517 }
                    if (r8 == 0) goto L_0x0e83
                    java.lang.Object r8 = r7.next()     // Catch:{ Exception -> 0x0517 }
                    android.os.Bundle r8 = (android.os.Bundle) r8     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r9 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    r11 = r33
                    java.lang.String r8 = r8.getString(r11)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = r9.V4(r8)     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r9.<init>()     // Catch:{ Exception -> 0x0517 }
                    r9.append(r10)     // Catch:{ Exception -> 0x0517 }
                    r9.append(r2)     // Catch:{ Exception -> 0x0517 }
                    r9.append(r8)     // Catch:{ Exception -> 0x0517 }
                    r9.append(r4)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r10 = r9.toString()     // Catch:{ Exception -> 0x0517 }
                    r33 = r11
                    goto L_0x0e53
                L_0x0e83:
                    r11 = r33
                    int r7 = r10.length()     // Catch:{ Exception -> 0x0517 }
                    if (r7 <= 0) goto L_0x0ea4
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r7.<init>()     // Catch:{ Exception -> 0x0517 }
                    r7.append(r12)     // Catch:{ Exception -> 0x0517 }
                    r7.append(r10)     // Catch:{ Exception -> 0x0517 }
                    r7.append(r15)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r8 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r9 = "Reported Uses"
                    r8.J4(r9, r7)     // Catch:{ Exception -> 0x0517 }
                L_0x0ea4:
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Data.CompressHelper r8 = r7.Q4     // Catch:{ Exception -> 0x0517 }
                    android.os.Bundle r7 = r7.D4     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r9.<init>()     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r10 = "select * from altmed_dose where drug_id="
                    r9.append(r10)     // Catch:{ Exception -> 0x0517 }
                    r9.append(r14)     // Catch:{ Exception -> 0x0517 }
                    r9.append(r5)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r10 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r10 = r10.a5     // Catch:{ Exception -> 0x0517 }
                    r33 = r11
                    r11 = 1
                    java.util.ArrayList r7 = r8.X(r7, r9, r10, r11)     // Catch:{ Exception -> 0x0517 }
                    java.util.Iterator r16 = r7.iterator()     // Catch:{ Exception -> 0x0517 }
                    r10 = r20
                L_0x0ecf:
                    boolean r7 = r16.hasNext()     // Catch:{ Exception -> 0x0517 }
                    if (r7 == 0) goto L_0x0f6d
                    java.lang.Object r7 = r16.next()     // Catch:{ Exception -> 0x0517 }
                    android.os.Bundle r7 = (android.os.Bundle) r7     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r8 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    r11 = r27
                    java.lang.String r9 = r7.getString(r11)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = r8.V4(r9)     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r9 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    r19 = r1
                    r27 = r11
                    r1 = r21
                    java.lang.String r11 = r7.getString(r1)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r9 = r9.V4(r11)     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r11 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    r21 = r1
                    java.lang.String r1 = "MSG_STRING_ID"
                    java.lang.String r1 = r7.getString(r1)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r1 = r11.V4(r1)     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r7.<init>()     // Catch:{ Exception -> 0x0517 }
                    r11 = r22
                    r7.append(r11)     // Catch:{ Exception -> 0x0517 }
                    r7.append(r9)     // Catch:{ Exception -> 0x0517 }
                    r9 = r26
                    r7.append(r9)     // Catch:{ Exception -> 0x0517 }
                    r7.append(r1)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r1 = r7.toString()     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r7.<init>()     // Catch:{ Exception -> 0x0517 }
                    r7.append(r10)     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r10 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r22 = ""
                    java.lang.String r23 = "LTR"
                    java.lang.String r24 = ""
                    java.lang.String r26 = ""
                    r29 = r15
                    r15 = r7
                    r7 = r10
                    r31 = r9
                    r9 = r22
                    r10 = r23
                    r32 = r3
                    r22 = r11
                    r23 = r27
                    r3 = r33
                    r11 = r1
                    r1 = r12
                    r12 = r24
                    r36 = r13
                    r13 = r25
                    r24 = r1
                    r1 = r14
                    r14 = r26
                    java.lang.String r7 = r7.N4(r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x0517 }
                    r15.append(r7)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r10 = r15.toString()     // Catch:{ Exception -> 0x0517 }
                    r14 = r1
                    r33 = r3
                    r1 = r19
                    r27 = r23
                    r12 = r24
                    r15 = r29
                    r26 = r31
                    r3 = r32
                    r13 = r36
                    goto L_0x0ecf
                L_0x0f6d:
                    r19 = r1
                    r32 = r3
                    r24 = r12
                    r36 = r13
                    r1 = r14
                    r29 = r15
                    r3 = r33
                    int r7 = r10.length()     // Catch:{ Exception -> 0x0517 }
                    if (r7 <= 0) goto L_0x0f87
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = "Reported Doses"
                    r7.J4(r8, r10)     // Catch:{ Exception -> 0x0517 }
                L_0x0f87:
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Data.CompressHelper r8 = r7.Q4     // Catch:{ Exception -> 0x0517 }
                    android.os.Bundle r7 = r7.D4     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r9.<init>()     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r11 = "select * from altmed_caution_header where drug_id="
                    r9.append(r11)     // Catch:{ Exception -> 0x0517 }
                    r9.append(r1)     // Catch:{ Exception -> 0x0517 }
                    r9.append(r5)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r11 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r11 = r11.a5     // Catch:{ Exception -> 0x0517 }
                    r12 = 1
                    java.util.ArrayList r7 = r8.X(r7, r9, r11, r12)     // Catch:{ Exception -> 0x0517 }
                    java.util.Iterator r15 = r7.iterator()     // Catch:{ Exception -> 0x0517 }
                L_0x0fae:
                    boolean r7 = r15.hasNext()     // Catch:{ Exception -> 0x0517 }
                    if (r7 == 0) goto L_0x107e
                    java.lang.Object r7 = r15.next()     // Catch:{ Exception -> 0x0517 }
                    android.os.Bundle r7 = (android.os.Bundle) r7     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r8 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r9 = r7.getString(r3)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = r8.V4(r9)     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r9 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Data.CompressHelper r11 = r9.Q4     // Catch:{ Exception -> 0x0517 }
                    android.os.Bundle r9 = r9.D4     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r12.<init>()     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r13 = "Select * from altmed_caution where caution_header_id="
                    r12.append(r13)     // Catch:{ Exception -> 0x0517 }
                    r14 = r30
                    java.lang.String r7 = r7.getString(r14)     // Catch:{ Exception -> 0x0517 }
                    r12.append(r7)     // Catch:{ Exception -> 0x0517 }
                    r12.append(r5)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r7 = r12.toString()     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r12 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r12 = r12.a5     // Catch:{ Exception -> 0x0517 }
                    r13 = 1
                    java.util.ArrayList r7 = r11.X(r9, r7, r12, r13)     // Catch:{ Exception -> 0x0517 }
                    java.util.Iterator r7 = r7.iterator()     // Catch:{ Exception -> 0x0517 }
                    r9 = r20
                L_0x0ff3:
                    boolean r11 = r7.hasNext()     // Catch:{ Exception -> 0x0517 }
                    if (r11 == 0) goto L_0x101f
                    java.lang.Object r11 = r7.next()     // Catch:{ Exception -> 0x0517 }
                    android.os.Bundle r11 = (android.os.Bundle) r11     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r12.<init>()     // Catch:{ Exception -> 0x0517 }
                    r12.append(r9)     // Catch:{ Exception -> 0x0517 }
                    r12.append(r2)     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r9 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r11 = r11.getString(r3)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r9 = r9.V4(r11)     // Catch:{ Exception -> 0x0517 }
                    r12.append(r9)     // Catch:{ Exception -> 0x0517 }
                    r12.append(r4)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r9 = r12.toString()     // Catch:{ Exception -> 0x0517 }
                    goto L_0x0ff3
                L_0x101f:
                    int r7 = r9.length()     // Catch:{ Exception -> 0x0517 }
                    if (r7 <= 0) goto L_0x106c
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r7.<init>()     // Catch:{ Exception -> 0x0517 }
                    r13 = r32
                    r7.append(r13)     // Catch:{ Exception -> 0x0517 }
                    r7.append(r9)     // Catch:{ Exception -> 0x0517 }
                    r12 = r29
                    r7.append(r12)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r11 = r7.toString()     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r9.<init>()     // Catch:{ Exception -> 0x0517 }
                    r9.append(r10)     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r10 = ""
                    java.lang.String r16 = "LTR"
                    java.lang.String r21 = ""
                    java.lang.String r22 = ""
                    r23 = r15
                    r15 = r9
                    r9 = r10
                    r10 = r16
                    r37 = r12
                    r12 = r21
                    r16 = r13
                    r13 = r25
                    r38 = r14
                    r14 = r22
                    java.lang.String r7 = r7.N4(r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x0517 }
                    r15.append(r7)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r7 = r15.toString()     // Catch:{ Exception -> 0x0517 }
                    r10 = r7
                    goto L_0x1074
                L_0x106c:
                    r38 = r14
                    r23 = r15
                    r37 = r29
                    r16 = r32
                L_0x1074:
                    r32 = r16
                    r15 = r23
                    r29 = r37
                    r30 = r38
                    goto L_0x0fae
                L_0x107e:
                    r37 = r29
                    r38 = r30
                    int r7 = r10.length()     // Catch:{ Exception -> 0x0517 }
                    if (r7 <= 0) goto L_0x108f
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = "Cautions"
                    r7.J4(r8, r10)     // Catch:{ Exception -> 0x0517 }
                L_0x108f:
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Data.CompressHelper r8 = r7.Q4     // Catch:{ Exception -> 0x0517 }
                    android.os.Bundle r7 = r7.D4     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r9.<init>()     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r10 = "select * from altmed_reaction where drug_id="
                    r9.append(r10)     // Catch:{ Exception -> 0x0517 }
                    r9.append(r1)     // Catch:{ Exception -> 0x0517 }
                    r9.append(r5)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r10 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r10 = r10.a5     // Catch:{ Exception -> 0x0517 }
                    r11 = 1
                    java.util.ArrayList r7 = r8.X(r7, r9, r10, r11)     // Catch:{ Exception -> 0x0517 }
                    java.util.Iterator r7 = r7.iterator()     // Catch:{ Exception -> 0x0517 }
                    r10 = r20
                L_0x10b8:
                    boolean r8 = r7.hasNext()     // Catch:{ Exception -> 0x0517 }
                    if (r8 == 0) goto L_0x10e4
                    java.lang.Object r8 = r7.next()     // Catch:{ Exception -> 0x0517 }
                    android.os.Bundle r8 = (android.os.Bundle) r8     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r9 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = r8.getString(r3)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = r9.V4(r8)     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r9.<init>()     // Catch:{ Exception -> 0x0517 }
                    r9.append(r10)     // Catch:{ Exception -> 0x0517 }
                    r9.append(r2)     // Catch:{ Exception -> 0x0517 }
                    r9.append(r8)     // Catch:{ Exception -> 0x0517 }
                    r9.append(r4)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r10 = r9.toString()     // Catch:{ Exception -> 0x0517 }
                    goto L_0x10b8
                L_0x10e4:
                    int r7 = r10.length()     // Catch:{ Exception -> 0x0517 }
                    if (r7 <= 0) goto L_0x1108
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r7.<init>()     // Catch:{ Exception -> 0x0517 }
                    r15 = r24
                    r7.append(r15)     // Catch:{ Exception -> 0x0517 }
                    r7.append(r10)     // Catch:{ Exception -> 0x0517 }
                    r14 = r37
                    r7.append(r14)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r8 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r9 = "Adverse Reactions"
                    r8.J4(r9, r7)     // Catch:{ Exception -> 0x0517 }
                    goto L_0x110c
                L_0x1108:
                    r15 = r24
                    r14 = r37
                L_0x110c:
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Data.CompressHelper r8 = r7.Q4     // Catch:{ Exception -> 0x0517 }
                    android.os.Bundle r7 = r7.D4     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r9.<init>()     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r10 = "select * from drug where generic_id="
                    r9.append(r10)     // Catch:{ Exception -> 0x0517 }
                    r9.append(r1)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r10 = " order by name collate nocase asc"
                    r9.append(r10)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r10 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r10 = r10.a5     // Catch:{ Exception -> 0x0517 }
                    r11 = 1
                    java.util.ArrayList r7 = r8.X(r7, r9, r10, r11)     // Catch:{ Exception -> 0x0517 }
                    java.util.Iterator r7 = r7.iterator()     // Catch:{ Exception -> 0x0517 }
                    r10 = r20
                L_0x1137:
                    boolean r8 = r7.hasNext()     // Catch:{ Exception -> 0x0517 }
                    if (r8 == 0) goto L_0x1170
                    java.lang.Object r8 = r7.next()     // Catch:{ Exception -> 0x0517 }
                    android.os.Bundle r8 = (android.os.Bundle) r8     // Catch:{ Exception -> 0x0517 }
                    r13 = r28
                    java.lang.String r8 = r8.getString(r13)     // Catch:{ Exception -> 0x0517 }
                    r12 = r36
                    java.lang.String r9 = r12.getString(r13)     // Catch:{ Exception -> 0x0517 }
                    boolean r9 = r8.equals(r9)     // Catch:{ Exception -> 0x0517 }
                    if (r9 == 0) goto L_0x115a
                L_0x1155:
                    r36 = r12
                    r28 = r13
                    goto L_0x1137
                L_0x115a:
                    java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r9.<init>()     // Catch:{ Exception -> 0x0517 }
                    r9.append(r10)     // Catch:{ Exception -> 0x0517 }
                    r9.append(r2)     // Catch:{ Exception -> 0x0517 }
                    r9.append(r8)     // Catch:{ Exception -> 0x0517 }
                    r9.append(r4)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r10 = r9.toString()     // Catch:{ Exception -> 0x0517 }
                    goto L_0x1155
                L_0x1170:
                    r13 = r28
                    r12 = r36
                    int r2 = r10.length()     // Catch:{ Exception -> 0x0517 }
                    if (r2 <= 0) goto L_0x1193
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r2.<init>()     // Catch:{ Exception -> 0x0517 }
                    r2.append(r15)     // Catch:{ Exception -> 0x0517 }
                    r2.append(r10)     // Catch:{ Exception -> 0x0517 }
                    r2.append(r14)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r4 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r7 = "Synonyms"
                    r4.J4(r7, r2)     // Catch:{ Exception -> 0x0517 }
                L_0x1193:
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r2 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Data.CompressHelper r4 = r2.Q4     // Catch:{ Exception -> 0x0517 }
                    android.os.Bundle r2 = r2.D4     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r7.<init>()     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = "select * from altmed_other_info where drug_id="
                    r7.append(r8)     // Catch:{ Exception -> 0x0517 }
                    r7.append(r1)     // Catch:{ Exception -> 0x0517 }
                    r7.append(r5)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r5 = r7.toString()     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r7 = r7.a5     // Catch:{ Exception -> 0x0517 }
                    r8 = 1
                    java.util.ArrayList r2 = r4.X(r2, r5, r7, r8)     // Catch:{ Exception -> 0x0517 }
                    java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x0517 }
                    r10 = r20
                L_0x11bc:
                    boolean r4 = r2.hasNext()     // Catch:{ Exception -> 0x0517 }
                    if (r4 == 0) goto L_0x120f
                    java.lang.Object r4 = r2.next()     // Catch:{ Exception -> 0x0517 }
                    android.os.Bundle r4 = (android.os.Bundle) r4     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r5 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r7 = "HEADER_STRING_ID"
                    java.lang.String r7 = r4.getString(r7)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = r5.V4(r7)     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r5 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r4 = r4.getString(r3)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r11 = r5.V4(r4)     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r4.<init>()     // Catch:{ Exception -> 0x0517 }
                    r4.append(r10)     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r9 = ""
                    java.lang.String r10 = "LTR"
                    java.lang.String r5 = ""
                    java.lang.String r16 = ""
                    r21 = r2
                    r2 = r12
                    r12 = r5
                    r5 = r13
                    r13 = r25
                    r33 = r3
                    r3 = r14
                    r14 = r16
                    java.lang.String r7 = r7.N4(r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x0517 }
                    r4.append(r7)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r10 = r4.toString()     // Catch:{ Exception -> 0x0517 }
                    r12 = r2
                    r14 = r3
                    r13 = r5
                    r2 = r21
                    r3 = r33
                    goto L_0x11bc
                L_0x120f:
                    r2 = r12
                    r5 = r13
                    r3 = r14
                    int r4 = r10.length()     // Catch:{ Exception -> 0x0517 }
                    if (r4 <= 0) goto L_0x121f
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r4 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r7 = "Other Info"
                    r4.J4(r7, r10)     // Catch:{ Exception -> 0x0517 }
                L_0x121f:
                    r4 = r19
                    goto L_0x122d
                L_0x1222:
                    r19 = r1
                    r2 = r13
                    r1 = r14
                    r3 = r15
                    r5 = r28
                    r38 = r30
                    r15 = r12
                    goto L_0x121f
                L_0x122d:
                    java.lang.String r2 = r2.getString(r4)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r4 = "3"
                    boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x0517 }
                    if (r2 == 0) goto L_0x12ba
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r2 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Data.CompressHelper r4 = r2.Q4     // Catch:{ Exception -> 0x0517 }
                    android.os.Bundle r2 = r2.D4     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r7.<init>()     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r8 = "Select * from drug where generic_id = "
                    r7.append(r8)     // Catch:{ Exception -> 0x0517 }
                    r7.append(r1)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r1 = r7.toString()     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r7 = r7.a5     // Catch:{ Exception -> 0x0517 }
                    r8 = 1
                    java.util.ArrayList r1 = r4.X(r2, r1, r7, r8)     // Catch:{ Exception -> 0x0517 }
                    java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x0517 }
                    r10 = r20
                L_0x125f:
                    boolean r2 = r1.hasNext()     // Catch:{ Exception -> 0x0517 }
                    if (r2 == 0) goto L_0x129b
                    java.lang.Object r2 = r1.next()     // Catch:{ Exception -> 0x0517 }
                    android.os.Bundle r2 = (android.os.Bundle) r2     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r4.<init>()     // Catch:{ Exception -> 0x0517 }
                    r4.append(r10)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r7 = "<li><a href=\"rx://"
                    r4.append(r7)     // Catch:{ Exception -> 0x0517 }
                    r7 = r38
                    java.lang.String r8 = r2.getString(r7)     // Catch:{ Exception -> 0x0517 }
                    r4.append(r8)     // Catch:{ Exception -> 0x0517 }
                    r8 = r18
                    r4.append(r8)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r2 = r2.getString(r5)     // Catch:{ Exception -> 0x0517 }
                    r4.append(r2)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r2 = "</a></li>"
                    r4.append(r2)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r10 = r4.toString()     // Catch:{ Exception -> 0x0517 }
                    r38 = r7
                    r18 = r8
                    goto L_0x125f
                L_0x129b:
                    int r1 = r10.length()     // Catch:{ Exception -> 0x0517 }
                    if (r1 <= 0) goto L_0x12ba
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r1.<init>()     // Catch:{ Exception -> 0x0517 }
                    r1.append(r15)     // Catch:{ Exception -> 0x0517 }
                    r1.append(r10)     // Catch:{ Exception -> 0x0517 }
                    r1.append(r3)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r2 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r3 = "Please See"
                    r2.J4(r3, r1)     // Catch:{ Exception -> 0x0517 }
                L_0x12ba:
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r1 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    androidx.fragment.app.FragmentActivity r2 = r1.r()     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r3 = "EPOHeader.css"
                    java.lang.String r1 = r1.d4(r2, r3)     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r2 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    androidx.fragment.app.FragmentActivity r3 = r2.r()     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r4 = "EPOFooter.css"
                    java.lang.String r2 = r2.d4(r3, r4)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r3 = "[size]"
                    java.lang.String r4 = "200"
                    java.lang.String r1 = r1.replace(r3, r4)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r3 = "[title]"
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r4 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r4 = r4.F4     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r1 = r1.replace(r3, r4)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r3 = "[include]"
                    r4 = r20
                    java.lang.String r1 = r1.replace(r3, r4)     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r3 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.util.ArrayList<android.os.Bundle> r5 = r3.Z4     // Catch:{ Exception -> 0x0517 }
                    java.util.ArrayList r5 = r3.W4(r5)     // Catch:{ Exception -> 0x0517 }
                    r3.Z4 = r5     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r3 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.util.ArrayList<android.os.Bundle> r3 = r3.Z4     // Catch:{ Exception -> 0x0517 }
                    java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x0517 }
                    r10 = r4
                L_0x12ff:
                    boolean r4 = r3.hasNext()     // Catch:{ Exception -> 0x0517 }
                    if (r4 == 0) goto L_0x133f
                    java.lang.Object r4 = r3.next()     // Catch:{ Exception -> 0x0517 }
                    android.os.Bundle r4 = (android.os.Bundle) r4     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r5 = "Title"
                    java.lang.String r5 = r4.getString(r5)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r7 = "Content"
                    java.lang.String r15 = r4.getString(r7)     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r4.<init>()     // Catch:{ Exception -> 0x0517 }
                    r4.append(r10)     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r11 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r13 = ""
                    java.lang.String r14 = "LTR"
                    java.lang.String r16 = ""
                    java.lang.String r17 = "margin-left: 10px"
                    java.lang.String r18 = ""
                    r12 = r5
                    java.lang.String r7 = r11.M4(r12, r13, r14, r15, r16, r17, r18)     // Catch:{ Exception -> 0x0517 }
                    r4.append(r7)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r10 = r4.toString()     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r4 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    int r7 = r4.X4     // Catch:{ Exception -> 0x0517 }
                    r4.I4(r5, r7)     // Catch:{ Exception -> 0x0517 }
                    goto L_0x12ff
                L_0x133f:
                    java.lang.String r3 = ".."
                    java.lang.String r4 = "."
                    java.lang.String r3 = r10.replace(r3, r4)     // Catch:{ Exception -> 0x0517 }
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r4 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0517 }
                    r5.<init>()     // Catch:{ Exception -> 0x0517 }
                    r5.append(r1)     // Catch:{ Exception -> 0x0517 }
                    r5.append(r3)     // Catch:{ Exception -> 0x0517 }
                    r5.append(r2)     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r1 = r5.toString()     // Catch:{ Exception -> 0x0517 }
                    r4.A4 = r1     // Catch:{ Exception -> 0x0517 }
                    goto L_0x1370
                L_0x135e:
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r1 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this     // Catch:{ Exception -> 0x0517 }
                    java.lang.String r2 = "Document doesn't exist"
                    r1.p4 = r2     // Catch:{ Exception -> 0x0517 }
                    return
                L_0x1365:
                    r1.printStackTrace()
                    net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r2 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.this
                    java.lang.String r1 = r1.getLocalizedMessage()
                    r2.p4 = r1
                L_0x1370:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment.AnonymousClass1.run():void");
            }
        }, new Runnable() {
            public void run() {
                String str = EPORxViewerActivityFragment.this.p4;
                if (str == null || str.length() <= 0) {
                    String f1 = CompressHelper.f1(EPORxViewerActivityFragment.this.D4);
                    EPORxViewerActivityFragment ePORxViewerActivityFragment = EPORxViewerActivityFragment.this;
                    ePORxViewerActivityFragment.O3(ePORxViewerActivityFragment.A4, f1);
                    EPORxViewerActivityFragment.this.s4();
                    EPORxViewerActivityFragment.this.p4();
                    EPORxViewerActivityFragment.this.f3(R.menu.f1411elsviewer2);
                    EPORxViewerActivityFragment.this.o2(false);
                    EPORxViewerActivityFragment.this.G3();
                    return;
                }
                EPORxViewerActivityFragment ePORxViewerActivityFragment2 = EPORxViewerActivityFragment.this;
                ePORxViewerActivityFragment2.C4(ePORxViewerActivityFragment2.p4);
            }
        });
        return this.C4;
    }

    public String U4(String str) {
        return R4(str, "safety");
    }

    public String V4(String str) {
        return R4(str, "general");
    }

    public ArrayList<Bundle> W4(ArrayList<Bundle> arrayList) {
        ArrayList<Bundle> arrayList2 = arrayList;
        String[] strArr = {"Adult Dosing", "Pediatric Dosing", "Alternatives", "Uses", "Dosing", "Reported Uses", "Reported Doses", "Cautions", "Formulations", "Black Box Warnings", "Contraindications/Cautions", "Adverse Reactions", "Drug Interaction", "Safety/Monitoring", "Pharmacology", "Manufacturer/Pricing", "Synonyms", "Other Info", "Pill Picture"};
        ArrayList<Bundle> arrayList3 = new ArrayList<>();
        for (int i2 = 0; i2 < 19; i2++) {
            Bundle q1 = CompressHelper.q1(arrayList2, "Title", strArr[i2]);
            if (q1 != null) {
                arrayList3.add(q1);
                arrayList2.remove(q1);
            }
        }
        arrayList3.addAll(arrayList2);
        return arrayList3;
    }

    public boolean e1(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.f801action_menu) {
            LXSectionsViewer lXSectionsViewer = new LXSectionsViewer();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("fields", this.d5);
            lXSectionsViewer.i2(bundle);
            lXSectionsViewer.Z2(true);
            lXSectionsViewer.A2(this, 0);
            lXSectionsViewer.e3(M(), "RxSection");
        }
        return super.e1(menuItem);
    }

    public void e3(Menu menu) {
        if (menu.findItem(R.id.f799action_gallery) != null) {
            menu.removeItem(R.id.f799action_gallery);
        }
    }

    public void o4() {
        Bundle v3 = v3(this.Y4);
        if (v3 != null) {
            Glide.G(r()).t("http://www.epocrates.com/pillimages/" + (v3.getString("FILENAME") + ".jpg")).B2(this.M4);
        }
    }

    public boolean y4(WebView webView, String str, String str2, String str3) {
        iMDLogger.j("Override", "Url : " + str + ", Scheme : " + str2 + ", Resource : " + str3);
        if (this.Q4.N1(this.D4, str)) {
            return true;
        }
        if (str2.equals("grp")) {
            String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(str3.replace("//", ""), ",,,,,");
            Bundle bundle = new Bundle();
            bundle.putBundle("DB", this.D4);
            bundle.putString("ParentId", splitByWholeSeparator[0]);
            this.Q4.N(EPORxListActivity.class, EPORxListActivityFragment.class, bundle);
        } else if (str2.equals("rx")) {
            String replace = str3.replace("//", "");
            CompressHelper compressHelper = this.Q4;
            Bundle bundle2 = this.D4;
            compressHelper.A1(bundle2, "rx-" + replace, (String[]) null, (String) null);
        } else if (str2.equals("interaction")) {
            str3.replace("//", "");
            CompressHelper compressHelper2 = this.Q4;
            Bundle bundle3 = this.D4;
            compressHelper2.A1(bundle3, "interact-" + this.b5, (String[]) null, (String) null);
        }
        return true;
    }
}
