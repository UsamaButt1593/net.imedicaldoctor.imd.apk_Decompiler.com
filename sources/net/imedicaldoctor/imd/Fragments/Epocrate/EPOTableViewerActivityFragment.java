package net.imedicaldoctor.imd.Fragments.Epocrate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import java.util.ArrayList;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.Lexi.LXSectionsViewer;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.R;
import org.apache.commons.lang3.StringUtils;

public class EPOTableViewerActivityFragment extends ViewerHelperFragment {
    public ArrayList<Bundle> X4;
    public int Y4;
    public String Z4;

    public void I4(String str, int i2) {
        Bundle bundle = new Bundle();
        bundle.putString("sequence", String.valueOf(i2));
        bundle.putString("label", str);
        this.X4.add(bundle);
    }

    public String J4(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int i2 = this.Y4 + 1;
        this.Y4 = i2;
        String valueOf = String.valueOf(i2);
        return "<a name=\"f" + valueOf + "\"><div id=\"h" + valueOf + "\" class=\"headerExpanded\"  DIR=\"" + str3 + "\" onclick=\"collapse(f" + valueOf + ");toggleHeaderExpanded(h" + valueOf + ");\"><span class=\"fieldname\" style=\"font-family:" + str2 + ";\">" + str + "</span></div></a><div class=\"content\" DIR=\"" + str7 + "\" id=\"f" + valueOf + "\" style=\"font-family:" + str5 + "; " + str6 + "\">" + str4 + "</div>";
    }

    public String K4(String str, String str2) {
        if (!(str == null || str.length() == 0)) {
            CompressHelper compressHelper = this.Q4;
            Bundle bundle = this.D4;
            Bundle s1 = compressHelper.s1(compressHelper.W(bundle, "select * from " + str2 + "_string where id=" + str, this.Z4));
            if (!(s1 == null || s1.size() == 0)) {
                return s1.getString("STRING");
            }
        }
        return "";
    }

    public String L4(String str) {
        return K4(str, "general");
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:37:0x0188=Splitter:B:37:0x0188, B:25:0x00af=Splitter:B:25:0x00af} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View onFragmentBind(android.view.LayoutInflater r12, android.view.ViewGroup r13, android.os.Bundle r14) {
        /*
            r11 = this;
            android.view.View r0 = r11.C4
            if (r0 == 0) goto L_0x0005
            return r0
        L_0x0005:
            r0 = 2131558547(0x7f0d0093, float:1.8742413E38)
            r1 = 0
            android.view.View r12 = r12.inflate(r0, r13, r1)
            r11.C4 = r12
            r11.r4(r12, r14)
            java.lang.String r12 = "RX.sqlite"
            r11.Z4 = r12
            android.os.Bundle r12 = r11.y()
            if (r12 != 0) goto L_0x001f
            android.view.View r12 = r11.C4
            return r12
        L_0x001f:
            java.lang.String r12 = r11.A4     // Catch:{ Exception -> 0x002a }
            if (r12 == 0) goto L_0x002d
            int r12 = r12.length()     // Catch:{ Exception -> 0x002a }
            if (r12 != 0) goto L_0x0168
            goto L_0x002d
        L_0x002a:
            r12 = move-exception
            goto L_0x0194
        L_0x002d:
            r11.Y4 = r1     // Catch:{ Exception -> 0x002a }
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ Exception -> 0x002a }
            r12.<init>()     // Catch:{ Exception -> 0x002a }
            r11.X4 = r12     // Catch:{ Exception -> 0x002a }
            java.lang.String r12 = "Loading Document"
            java.lang.String r13 = r11.E4     // Catch:{ Exception -> 0x002a }
            net.imedicaldoctor.imd.iMDLogger.f(r12, r13)     // Catch:{ Exception -> 0x002a }
            java.lang.String r12 = r11.E4     // Catch:{ Exception -> 0x002a }
            java.lang.String r13 = "-"
            java.lang.String[] r12 = r12.split(r13)     // Catch:{ Exception -> 0x002a }
            r13 = 1
            r12 = r12[r13]     // Catch:{ Exception -> 0x002a }
            net.imedicaldoctor.imd.Data.CompressHelper r14 = r11.Q4     // Catch:{ Exception -> 0x002a }
            android.os.Bundle r0 = r11.D4     // Catch:{ Exception -> 0x002a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x002a }
            r2.<init>()     // Catch:{ Exception -> 0x002a }
            java.lang.String r3 = "Select * from content_table where ID="
            r2.append(r3)     // Catch:{ Exception -> 0x002a }
            r2.append(r12)     // Catch:{ Exception -> 0x002a }
            java.lang.String r12 = r2.toString()     // Catch:{ Exception -> 0x002a }
            java.lang.String r2 = r11.Z4     // Catch:{ Exception -> 0x002a }
            java.util.ArrayList r12 = r14.W(r0, r12, r2)     // Catch:{ Exception -> 0x002a }
            if (r12 == 0) goto L_0x0188
            int r14 = r12.size()     // Catch:{ Exception -> 0x002a }
            if (r14 != 0) goto L_0x006d
            goto L_0x0188
        L_0x006d:
            java.lang.Object r12 = r12.get(r1)     // Catch:{ Exception -> 0x002a }
            android.os.Bundle r12 = (android.os.Bundle) r12     // Catch:{ Exception -> 0x002a }
            java.lang.String r13 = "NAME"
            java.lang.String r13 = r12.getString(r13)     // Catch:{ Exception -> 0x002a }
            r11.F4 = r13     // Catch:{ Exception -> 0x002a }
            net.imedicaldoctor.imd.Data.CompressHelper r13 = r11.Q4     // Catch:{ Exception -> 0x002a }
            android.os.Bundle r14 = r11.D4     // Catch:{ Exception -> 0x002a }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x002a }
            r0.<init>()     // Catch:{ Exception -> 0x002a }
            java.lang.String r2 = "Select * from content_table_entry where table_id="
            r0.append(r2)     // Catch:{ Exception -> 0x002a }
            java.lang.String r2 = "ID"
            java.lang.String r12 = r12.getString(r2)     // Catch:{ Exception -> 0x002a }
            r0.append(r12)     // Catch:{ Exception -> 0x002a }
            java.lang.String r12 = " order by display_order asc"
            r0.append(r12)     // Catch:{ Exception -> 0x002a }
            java.lang.String r12 = r0.toString()     // Catch:{ Exception -> 0x002a }
            java.lang.String r0 = r11.Z4     // Catch:{ Exception -> 0x002a }
            java.util.ArrayList r12 = r13.W(r14, r12, r0)     // Catch:{ Exception -> 0x002a }
            if (r12 != 0) goto L_0x00a8
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ Exception -> 0x002a }
            r12.<init>()     // Catch:{ Exception -> 0x002a }
        L_0x00a8:
            java.util.Iterator r12 = r12.iterator()     // Catch:{ Exception -> 0x002a }
            java.lang.String r13 = ""
            r14 = r13
        L_0x00af:
            boolean r0 = r12.hasNext()     // Catch:{ Exception -> 0x002a }
            if (r0 == 0) goto L_0x0122
            java.lang.Object r0 = r12.next()     // Catch:{ Exception -> 0x002a }
            android.os.Bundle r0 = (android.os.Bundle) r0     // Catch:{ Exception -> 0x002a }
            java.lang.String r2 = "HEADER_STRING_ID"
            java.lang.String r2 = r0.getString(r2)     // Catch:{ Exception -> 0x002a }
            java.lang.String r2 = r11.L4(r2)     // Catch:{ Exception -> 0x002a }
            java.lang.String r3 = "BRACKET_STRING_ID"
            java.lang.String r3 = r0.getString(r3)     // Catch:{ Exception -> 0x002a }
            java.lang.String r3 = r11.L4(r3)     // Catch:{ Exception -> 0x002a }
            java.lang.String r4 = "MSG_STRING_ID"
            java.lang.String r0 = r0.getString(r4)     // Catch:{ Exception -> 0x002a }
            java.lang.String r0 = r11.L4(r0)     // Catch:{ Exception -> 0x002a }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x002a }
            r4.<init>()     // Catch:{ Exception -> 0x002a }
            java.lang.String r5 = "<div style=\"margin:10px\"><div class=\"cellTitle\">"
            r4.append(r5)     // Catch:{ Exception -> 0x002a }
            r4.append(r3)     // Catch:{ Exception -> 0x002a }
            java.lang.String r3 = "</div><div>"
            r4.append(r3)     // Catch:{ Exception -> 0x002a }
            r4.append(r0)     // Catch:{ Exception -> 0x002a }
            java.lang.String r0 = "</div></div>"
            r4.append(r0)     // Catch:{ Exception -> 0x002a }
            java.lang.String r7 = r4.toString()     // Catch:{ Exception -> 0x002a }
            int r0 = r2.length()     // Catch:{ Exception -> 0x002a }
            if (r0 <= 0) goto L_0x0112
            java.lang.String r5 = ""
            java.lang.String r6 = "LTR"
            java.lang.String r8 = ""
            java.lang.String r9 = "margin-left: 5px"
            java.lang.String r10 = ""
            r3 = r11
            r4 = r2
            java.lang.String r7 = r3.J4(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x002a }
            int r0 = r11.Y4     // Catch:{ Exception -> 0x002a }
            r11.I4(r2, r0)     // Catch:{ Exception -> 0x002a }
        L_0x0112:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x002a }
            r0.<init>()     // Catch:{ Exception -> 0x002a }
            r0.append(r14)     // Catch:{ Exception -> 0x002a }
            r0.append(r7)     // Catch:{ Exception -> 0x002a }
            java.lang.String r14 = r0.toString()     // Catch:{ Exception -> 0x002a }
            goto L_0x00af
        L_0x0122:
            androidx.fragment.app.FragmentActivity r12 = r11.r()     // Catch:{ Exception -> 0x002a }
            java.lang.String r0 = "EPOHeader.css"
            java.lang.String r12 = r11.d4(r12, r0)     // Catch:{ Exception -> 0x002a }
            androidx.fragment.app.FragmentActivity r0 = r11.r()     // Catch:{ Exception -> 0x002a }
            java.lang.String r2 = "EPOFooter.css"
            java.lang.String r0 = r11.d4(r0, r2)     // Catch:{ Exception -> 0x002a }
            java.lang.String r2 = "[size]"
            java.lang.String r3 = "200"
            java.lang.String r12 = r12.replace(r2, r3)     // Catch:{ Exception -> 0x002a }
            java.lang.String r2 = "[title]"
            java.lang.String r3 = r11.F4     // Catch:{ Exception -> 0x002a }
            java.lang.String r12 = r12.replace(r2, r3)     // Catch:{ Exception -> 0x002a }
            java.lang.String r2 = "[include]"
            java.lang.String r12 = r12.replace(r2, r13)     // Catch:{ Exception -> 0x002a }
            java.lang.String r13 = ".."
            java.lang.String r2 = "."
            java.lang.String r13 = r14.replace(r13, r2)     // Catch:{ Exception -> 0x002a }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x002a }
            r14.<init>()     // Catch:{ Exception -> 0x002a }
            r14.append(r12)     // Catch:{ Exception -> 0x002a }
            r14.append(r13)     // Catch:{ Exception -> 0x002a }
            r14.append(r0)     // Catch:{ Exception -> 0x002a }
            java.lang.String r12 = r14.toString()     // Catch:{ Exception -> 0x002a }
            r11.A4 = r12     // Catch:{ Exception -> 0x002a }
        L_0x0168:
            android.os.Bundle r12 = r11.D4     // Catch:{ Exception -> 0x002a }
            java.lang.String r12 = net.imedicaldoctor.imd.Data.CompressHelper.f1(r12)     // Catch:{ Exception -> 0x002a }
            java.lang.String r13 = r11.A4     // Catch:{ Exception -> 0x002a }
            r11.O3(r13, r12)     // Catch:{ Exception -> 0x002a }
            r11.s4()     // Catch:{ Exception -> 0x002a }
            r11.p4()
            r12 = 2131689474(0x7f0f0002, float:1.9007964E38)
            r11.f3(r12)
            r11.o2(r1)
            r11.G3()
        L_0x0185:
            android.view.View r12 = r11.C4
            return r12
        L_0x0188:
            androidx.fragment.app.FragmentActivity r12 = r11.r()     // Catch:{ Exception -> 0x002a }
            java.lang.String r14 = "Document doesn't exist"
            net.imedicaldoctor.imd.Data.CompressHelper.x2(r12, r14, r13)     // Catch:{ Exception -> 0x002a }
            android.view.View r12 = r11.C4     // Catch:{ Exception -> 0x002a }
            return r12
        L_0x0194:
            r11.B4(r12)
            goto L_0x0185
        */
        throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.Epocrate.EPOTableViewerActivityFragment.U0(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    public boolean e1(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.f801action_menu) {
            LXSectionsViewer lXSectionsViewer = new LXSectionsViewer();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("fields", this.X4);
            lXSectionsViewer.i2(bundle);
            lXSectionsViewer.Z2(true);
            lXSectionsViewer.A2(this, 0);
            lXSectionsViewer.e3(M(), "LXSectionsViewer");
        }
        return super.e1(menuItem);
    }

    public void e3(Menu menu) {
        menu.removeItem(R.id.f799action_gallery);
    }

    public boolean y4(WebView webView, String str, String str2, String str3) {
        if (!this.Q4.N1(this.D4, str) && str3.contains("//current/")) {
            String str4 = StringUtils.splitByWholeSeparator(str3, "//current/")[1];
            CompressHelper compressHelper = this.Q4;
            Bundle bundle = this.D4;
            compressHelper.A1(bundle, this.E4 + "-" + str4, (String[]) null, (String) null);
        }
        return true;
    }
}
