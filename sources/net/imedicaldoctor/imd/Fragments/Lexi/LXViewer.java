package net.imedicaldoctor.imd.Fragments.Lexi;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.WebView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.net.HttpHeaders;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.itextpdf.text.Annotation;
import java.io.File;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.Lexi.LXItems;
import net.imedicaldoctor.imd.Fragments.ViewerHelperActivity;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.Gallery.GalleryActivity;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Utils.iMDWebView;
import net.imedicaldoctor.imd.iMD;
import net.imedicaldoctor.imd.iMDLogger;
import org.apache.commons.lang3.StringUtils;

public class LXViewer extends ViewerHelperActivity {

    public static class LXViewerFragment extends ViewerHelperFragment {
        public ArrayList<String> X4;
        public Bundle Y4;
        public String Z4;
        public String a5;
        public boolean b5;
        private String c5;
        /* access modifiers changed from: private */
        public Bundle d5;
        /* access modifiers changed from: private */
        public ArrayList<Bundle> e5;
        private MenuItem f5;
        /* access modifiers changed from: private */
        public int g5;

        /* access modifiers changed from: private */
        public void I4() {
            j3("ivc_compatible.png");
            j3("ivc_conflict.png");
            j3("ivc_incompatible.png");
            j3("ivc_no_info.png");
        }

        /* access modifiers changed from: private */
        public String J4(ArrayList<Bundle> arrayList, ArrayList<Bundle> arrayList2, String str) {
            StringBuilder sb;
            String str2;
            StringBuilder sb2;
            String str3;
            String str4 = "<div><div class=\"ivc_table_label\">" + str + "</div><table class=\"ivc_compatibility\"><tbody>";
            int i2 = 0;
            while (i2 < ((arrayList.size() - 1) / 6) + 1) {
                if (i2 != 0) {
                    str4 = str4 + "<tr><td class=\"ivc_table_spacer\" colspan=\"" + 6 + "\"></td></tr>";
                }
                String str5 = str4 + "<tr>";
                int i3 = i2 + 1;
                int i4 = i3 * 6;
                if (arrayList.size() < i4) {
                    i4 = arrayList.size();
                }
                int i5 = i2 * 6;
                for (int i6 = i5; i6 < i4; i6++) {
                    if (i6 % 2 == 1) {
                        sb2 = new StringBuilder();
                        sb2.append(str5);
                        str3 = "<td class=\"ivc_compatibility_header ivc_compatibility_even_col\">";
                    } else {
                        sb2 = new StringBuilder();
                        sb2.append(str5);
                        str3 = "<td class=\"ivc_compatibility_header ivc_compatibility_odd_col\">";
                    }
                    sb2.append(str3);
                    sb2.append(arrayList.get(i6).getString("name"));
                    sb2.append("</td>");
                    str5 = sb2.toString();
                }
                String str6 = (str5 + "</tr>") + "<tr>";
                while (i5 < i4) {
                    Bundle q1 = CompressHelper.q1(arrayList2, "name", arrayList.get(i5).getString("name"));
                    String str7 = "ivc_no_info.png";
                    if (q1 != null && !q1.getString(Annotation.i3).equals("6")) {
                        str7 = q1.getString(Annotation.i3).equals("5") ? "ivc_compatible.png" : q1.getString(Annotation.i3).equals(ExifInterface.Z4) ? "ivc_conflict.png" : q1.getString(Annotation.i3).equals(IcyHeaders.a3) ? "ivc_incompatible.png" : "";
                    }
                    if (i5 % 2 == 1) {
                        sb = new StringBuilder();
                        sb.append(str6);
                        str2 = "<td class=\"ivc_compatibility_content ivc_compatibility_even_col\"><img src=\"";
                    } else {
                        sb = new StringBuilder();
                        sb.append(str6);
                        str2 = "<td class=\"ivc_compatibility_content ivc_compatibility_even_odd\"><img src=\"";
                    }
                    sb.append(str2);
                    sb.append(str7);
                    sb.append("\" width=\"25px\" height=\"25px\"></td>");
                    str6 = sb.toString();
                    i5++;
                }
                str4 = str6 + "</tr>";
                i2 = i3;
            }
            return str4 + "</tbody></table></div>";
        }

        private void K4() {
        }

        private String T4() {
            Bundle bundle = this.d5;
            if (bundle == null) {
                return "alaki";
            }
            if (!bundle.containsKey("globalid")) {
                return "adsf";
            }
            Bundle bundle2 = this.D4;
            return CompressHelper.h1(bundle2, this.d5.getString("globalid") + ".mp3", "sound");
        }

        /* access modifiers changed from: private */
        public void U4() {
            MenuItem findItem;
            Menu menu = this.s4;
            if (menu != null && (findItem = menu.findItem(R.id.f817action_sound)) != null) {
                findItem.setVisible(new File(T4()).exists());
            }
        }

        /* access modifiers changed from: private */
        public String V4(String str, String str2, String str3, String str4, String str5) {
            return "<div class=\"content\" DIR=\"" + str4 + "\" id=\"f" + str5 + "\" style=\"font-family:" + str2 + "; " + str3 + "\">" + str + "</div>";
        }

        /* access modifiers changed from: private */
        public String W4(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            return "<a name=\"f" + str8 + "\"><div id=\"h" + str8 + "\" class=\"headerExpanded\"  DIR=\"" + str3 + "\" onclick=\"collapse(f" + str8 + ");toggleHeaderExpanded(h" + str8 + ");\"><span class=\"fieldname\" style=\"font-family:" + str2 + ";\">" + str + "</span></div></a><div class=\"content\" DIR=\"" + str7 + "\" id=\"f" + str8 + "\" style=\"font-family:" + str5 + "; " + str6 + "\">" + str4 + "</div>";
        }

        private void Y4(String str) {
            ArrayList<String> arrayList = this.X4;
            if (arrayList == null || arrayList.size() == 0) {
                CompressHelper.x2(r(), "There is no images in this document", 1);
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator<String> it2 = this.X4.iterator();
            while (it2.hasNext()) {
                String next = it2.next();
                Bundle bundle = new Bundle();
                bundle.putString("ImagePath", next);
                try {
                    String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(next, "/");
                    String str2 = splitByWholeSeparator[splitByWholeSeparator.length - 1];
                    bundle.putString("Description", this.Y4.containsKey(str2) ? this.Y4.getString(str2) : "");
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
            iMDLogger.j("Viewer activity , Gotosection", str);
            iMDWebView imdwebview = this.G4;
            imdwebview.g("document.getElementById(\"" + str + "\").scrollIntoView(true);document.body.scrollTop = window.pageYOffset - 50;");
        }

        public void T0(Menu menu, MenuInflater menuInflater) {
            menuInflater.inflate(R.menu.f1454menu_lxviewer, menu);
            q4(menu);
            e3(menu);
        }

        public View onFragmentBind(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View view = this.C4;
            if (view != null) {
                return view;
            }
            View inflate = layoutInflater.inflate(R.layout.f1255fragment_new_viewer, viewGroup, false);
            r4(inflate, bundle);
            if (y().containsKey("Mode")) {
                this.g5 = y().getInt("Mode");
            } else {
                this.g5 = 0;
            }
            if (bundle != null) {
                this.c5 = bundle.getString("mResources");
                this.g5 = bundle.getInt("Mode");
                this.d5 = bundle.getBundle("mDocument");
                this.e5 = bundle.getParcelableArrayList("mFields");
            }
            if (y() == null) {
                return inflate;
            }
            iMDLogger.j("LXViewer", "Loading Lexi Document with mDocAddress = " + this.E4);
            T2(new Runnable() {
                /* JADX WARNING: Removed duplicated region for block: B:104:0x05d8 A[Catch:{ Exception -> 0x0020 }] */
                /* JADX WARNING: Removed duplicated region for block: B:193:0x0943 A[Catch:{ Exception -> 0x0020 }] */
                /* JADX WARNING: Removed duplicated region for block: B:194:0x095d A[Catch:{ Exception -> 0x0020 }] */
                /* JADX WARNING: Removed duplicated region for block: B:198:0x0968 A[Catch:{ Exception -> 0x0020 }] */
                /* JADX WARNING: Removed duplicated region for block: B:210:0x0a97 A[Catch:{ Exception -> 0x0020 }] */
                /* JADX WARNING: Removed duplicated region for block: B:244:0x0d3e A[Catch:{ Exception -> 0x0020 }] */
                /* JADX WARNING: Removed duplicated region for block: B:245:0x0d5a A[Catch:{ Exception -> 0x0020 }] */
                /* JADX WARNING: Removed duplicated region for block: B:249:0x0d65 A[Catch:{ Exception -> 0x0020 }] */
                /* JADX WARNING: Removed duplicated region for block: B:262:0x0e75 A[Catch:{ Exception -> 0x0020 }] */
                /* JADX WARNING: Removed duplicated region for block: B:49:0x02cf A[Catch:{ Exception -> 0x0020 }] */
                /* JADX WARNING: Unknown top exception splitter block from list: {B:44:0x0287=Splitter:B:44:0x0287, B:240:0x0d09=Splitter:B:240:0x0d09, B:99:0x059c=Splitter:B:99:0x059c, B:189:0x090c=Splitter:B:189:0x090c} */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r41 = this;
                        r1 = r41
                        java.lang.String r2 = "onset"
                        net.imedicaldoctor.imd.Data.CompressHelper r3 = new net.imedicaldoctor.imd.Data.CompressHelper     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r4 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        androidx.fragment.app.FragmentActivity r4 = r4.r()     // Catch:{ Exception -> 0x0020 }
                        r3.<init>(r4)     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r4 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r4 = r4.A4     // Catch:{ Exception -> 0x0020 }
                        if (r4 == 0) goto L_0x0024
                        int r4 = r4.length()     // Catch:{ Exception -> 0x0020 }
                        if (r4 != 0) goto L_0x001c
                        goto L_0x0024
                    L_0x001c:
                        r20 = r3
                        goto L_0x0e6a
                    L_0x0020:
                        r0 = move-exception
                        r2 = r0
                        goto L_0x0ead
                    L_0x0024:
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r4 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        int r4 = r4.g5     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r5 = "</div>"
                        java.lang.String r6 = "[include]"
                        java.lang.String r7 = "200"
                        java.lang.String r8 = "[size]"
                        java.lang.String r9 = "Error in reading LXHeader and LXFooter : "
                        java.lang.String r10 = "LXFooter.css"
                        java.lang.String r11 = "LXHeader.css"
                        java.lang.String r12 = "content"
                        java.lang.String r13 = "title"
                        java.lang.String r14 = "sequence"
                        java.lang.String r15 = "Name"
                        r16 = r2
                        java.lang.String r2 = "LXViewer"
                        r18 = r5
                        java.lang.String r5 = "id"
                        r19 = r14
                        java.lang.String r14 = "label"
                        r20 = r14
                        java.lang.String r14 = ""
                        if (r4 != 0) goto L_0x0396
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r4 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        android.os.Bundle r4 = r4.D4     // Catch:{ Exception -> 0x0020 }
                        r21 = r6
                        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r6.<init>()     // Catch:{ Exception -> 0x0020 }
                        r22 = r7
                        java.lang.String r7 = "Select * from document where id="
                        r6.append(r7)     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r7 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r7 = r7.E4     // Catch:{ Exception -> 0x0020 }
                        r6.append(r7)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0020 }
                        java.util.ArrayList r4 = r3.V(r4, r6)     // Catch:{ Exception -> 0x0020 }
                        android.os.Bundle r4 = r3.z(r4)     // Catch:{ Exception -> 0x0020 }
                        if (r4 != 0) goto L_0x0080
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r2 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r3 = "Document doesn't exist"
                        r2.p4 = r3     // Catch:{ Exception -> 0x0020 }
                        return
                    L_0x0080:
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r6 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        android.os.Bundle unused = r6.d5 = r4     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r6 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r7 = r4.getString(r13)     // Catch:{ Exception -> 0x0020 }
                        r6.F4 = r7     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r6 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        android.os.Bundle r6 = r6.D4     // Catch:{ Exception -> 0x0020 }
                        java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r7.<init>()     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r13 = "Select view_id from chapter where id="
                        r7.append(r13)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r13 = "chapter_id"
                        java.lang.String r4 = r4.getString(r13)     // Catch:{ Exception -> 0x0020 }
                        r7.append(r4)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r4 = r7.toString()     // Catch:{ Exception -> 0x0020 }
                        java.util.ArrayList r4 = r3.V(r6, r4)     // Catch:{ Exception -> 0x0020 }
                        android.os.Bundle r4 = r3.z(r4)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r6 = "view_id"
                        java.lang.String r4 = r4.getString(r6)     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r6 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        android.os.Bundle r6 = r6.D4     // Catch:{ Exception -> 0x0020 }
                        java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r7.<init>()     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r13 = "select  field.id, field.fieldtype_id,label,sequence,content from field join viewfield on field.fieldtype_id=viewfield.fieldtype_id where view_id="
                        r7.append(r13)     // Catch:{ Exception -> 0x0020 }
                        r7.append(r4)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r4 = " AND document_id="
                        r7.append(r4)     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r4 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r4 = r4.E4     // Catch:{ Exception -> 0x0020 }
                        r7.append(r4)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r4 = " Order by sequence"
                        r7.append(r4)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r4 = r7.toString()     // Catch:{ Exception -> 0x0020 }
                        java.util.ArrayList r4 = r3.V(r6, r4)     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r6 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        android.os.Bundle r6 = r6.D4     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r6 = r6.getString(r15)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r7 = "calc.sqlite"
                        boolean r6 = r6.equals(r7)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r7 = "127"
                        if (r6 == 0) goto L_0x0261
                        java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment$1$1 r13 = new net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment$1$1     // Catch:{ Exception -> 0x0020 }
                        r13.<init>()     // Catch:{ Exception -> 0x0020 }
                        java.util.Collection r13 = com.google.common.collect.Collections2.d(r4, r13)     // Catch:{ Exception -> 0x0020 }
                        r6.<init>(r13)     // Catch:{ Exception -> 0x0020 }
                        android.os.Bundle r6 = r3.z(r6)     // Catch:{ Exception -> 0x0020 }
                        if (r6 == 0) goto L_0x017b
                        java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r13.<init>()     // Catch:{ Exception -> 0x0020 }
                        r13.append(r14)     // Catch:{ Exception -> 0x0020 }
                        r23 = r14
                        java.lang.String r14 = "<script type=\"text/javascript\">"
                        r13.append(r14)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x0020 }
                        java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r14.<init>()     // Catch:{ Exception -> 0x0020 }
                        r14.append(r13)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r13 = r6.getString(r12)     // Catch:{ Exception -> 0x0020 }
                        r24 = r15
                        java.lang.String r15 = r6.getString(r5)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r13 = r3.B(r13, r15, r7)     // Catch:{ Exception -> 0x0020 }
                        r14.append(r13)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r13 = r14.toString()     // Catch:{ Exception -> 0x0020 }
                        java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r14.<init>()     // Catch:{ Exception -> 0x0020 }
                        r14.append(r13)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r13 = "</script>"
                        r14.append(r13)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r13 = r14.toString()     // Catch:{ Exception -> 0x0020 }
                        java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r14.<init>()     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r15 = "1. Fields Count : "
                        r14.append(r15)     // Catch:{ Exception -> 0x0020 }
                        int r15 = r4.size()     // Catch:{ Exception -> 0x0020 }
                        r14.append(r15)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r14 = r14.toString()     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.iMDLogger.j(r2, r14)     // Catch:{ Exception -> 0x0020 }
                        r4.remove(r6)     // Catch:{ Exception -> 0x0020 }
                        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r6.<init>()     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r14 = "2. Fields Count : "
                        r6.append(r14)     // Catch:{ Exception -> 0x0020 }
                        int r14 = r4.size()     // Catch:{ Exception -> 0x0020 }
                        r6.append(r14)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.iMDLogger.j(r2, r6)     // Catch:{ Exception -> 0x0020 }
                        goto L_0x0181
                    L_0x017b:
                        r23 = r14
                        r24 = r15
                        r13 = r23
                    L_0x0181:
                        java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment$1$2 r14 = new net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment$1$2     // Catch:{ Exception -> 0x0020 }
                        r14.<init>()     // Catch:{ Exception -> 0x0020 }
                        java.util.Collection r14 = com.google.common.collect.Collections2.d(r4, r14)     // Catch:{ Exception -> 0x0020 }
                        r6.<init>(r14)     // Catch:{ Exception -> 0x0020 }
                        int r14 = r6.size()     // Catch:{ Exception -> 0x0020 }
                        if (r14 <= 0) goto L_0x025e
                        r4.removeAll(r6)     // Catch:{ Exception -> 0x0020 }
                        java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r14.<init>()     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r15 = "3. Fields Count : "
                        r14.append(r15)     // Catch:{ Exception -> 0x0020 }
                        int r15 = r4.size()     // Catch:{ Exception -> 0x0020 }
                        r14.append(r15)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r14 = r14.toString()     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.iMDLogger.j(r2, r14)     // Catch:{ Exception -> 0x0020 }
                        android.os.Bundle r6 = r3.z(r6)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r14 = r6.getString(r12)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r6 = r6.getString(r5)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r6 = r3.B(r14, r6, r7)     // Catch:{ Exception -> 0x0020 }
                        java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r15 = "</li>"
                        java.lang.String[] r6 = org.apache.commons.lang3.StringUtils.splitByWholeSeparator(r6, r15)     // Catch:{ Exception -> 0x0020 }
                        java.util.List r6 = java.util.Arrays.asList(r6)     // Catch:{ Exception -> 0x0020 }
                        r14.<init>(r6)     // Catch:{ Exception -> 0x0020 }
                        int r6 = r14.size()     // Catch:{ Exception -> 0x0020 }
                        r15 = 1
                        int r6 = r6 - r15
                        r14.remove(r6)     // Catch:{ Exception -> 0x0020 }
                        java.util.Iterator r6 = r14.iterator()     // Catch:{ Exception -> 0x0020 }
                    L_0x01dc:
                        boolean r14 = r6.hasNext()     // Catch:{ Exception -> 0x0020 }
                        if (r14 == 0) goto L_0x025e
                        java.lang.Object r14 = r6.next()     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r14 = (java.lang.String) r14     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r15 = ">"
                        java.lang.String[] r14 = org.apache.commons.lang3.StringUtils.splitByWholeSeparator(r14, r15)     // Catch:{ Exception -> 0x0020 }
                        java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r15.<init>()     // Catch:{ Exception -> 0x0020 }
                        r15.append(r13)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r13 = "<script type=\"text/javascript\">"
                        r15.append(r13)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r13 = r15.toString()     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r15 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        android.os.Bundle r15 = r15.D4     // Catch:{ Exception -> 0x0020 }
                        r16 = r6
                        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r6.<init>()     // Catch:{ Exception -> 0x0020 }
                        r25 = r4
                        java.lang.String r4 = "select  field.id,content from field join viewfield on field.fieldtype_id=viewfield.fieldtype_id where document_id="
                        r6.append(r4)     // Catch:{ Exception -> 0x0020 }
                        int r4 = r14.length     // Catch:{ Exception -> 0x0020 }
                        r17 = 1
                        int r4 = r4 + -1
                        r4 = r14[r4]     // Catch:{ Exception -> 0x0020 }
                        r6.append(r4)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r4 = " AND field.fieldtype_id=1433 Order by sequence"
                        r6.append(r4)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r4 = r6.toString()     // Catch:{ Exception -> 0x0020 }
                        java.util.ArrayList r4 = r3.V(r15, r4)     // Catch:{ Exception -> 0x0020 }
                        android.os.Bundle r4 = r3.s1(r4)     // Catch:{ Exception -> 0x0020 }
                        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r6.<init>()     // Catch:{ Exception -> 0x0020 }
                        r6.append(r13)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r13 = r4.getString(r12)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r4 = r4.getString(r5)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r4 = r3.B(r13, r4, r7)     // Catch:{ Exception -> 0x0020 }
                        r6.append(r4)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r4 = r6.toString()     // Catch:{ Exception -> 0x0020 }
                        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r6.<init>()     // Catch:{ Exception -> 0x0020 }
                        r6.append(r4)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r4 = "</script>"
                        r6.append(r4)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r13 = r6.toString()     // Catch:{ Exception -> 0x0020 }
                        r6 = r16
                        r4 = r25
                        goto L_0x01dc
                    L_0x025e:
                        r25 = r4
                        goto L_0x0269
                    L_0x0261:
                        r25 = r4
                        r23 = r14
                        r24 = r15
                        r13 = r23
                    L_0x0269:
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r4 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0283 }
                        androidx.fragment.app.FragmentActivity r6 = r4.r()     // Catch:{ Exception -> 0x0283 }
                        java.lang.String r4 = r4.d4(r6, r11)     // Catch:{ Exception -> 0x0283 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r6 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0280 }
                        androidx.fragment.app.FragmentActivity r11 = r6.r()     // Catch:{ Exception -> 0x0280 }
                        java.lang.String r2 = r6.d4(r11, r10)     // Catch:{ Exception -> 0x0280 }
                        r6 = r22
                        goto L_0x02a8
                    L_0x0280:
                        r0 = move-exception
                        r6 = r0
                        goto L_0x0287
                    L_0x0283:
                        r0 = move-exception
                        r6 = r0
                        r4 = r23
                    L_0x0287:
                        com.google.firebase.crashlytics.FirebaseCrashlytics r10 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()     // Catch:{ Exception -> 0x0020 }
                        r10.g(r6)     // Catch:{ Exception -> 0x0020 }
                        java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r10.<init>()     // Catch:{ Exception -> 0x0020 }
                        r10.append(r9)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r6 = r6.getLocalizedMessage()     // Catch:{ Exception -> 0x0020 }
                        r10.append(r6)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r6 = r10.toString()     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.iMDLogger.f(r2, r6)     // Catch:{ Exception -> 0x0020 }
                        r6 = r22
                        r2 = r23
                    L_0x02a8:
                        java.lang.String r4 = r4.replace(r8, r6)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r6 = "[title]"
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r8 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r8 = r8.F4     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r4 = r4.replace(r6, r8)     // Catch:{ Exception -> 0x0020 }
                        r14 = r21
                        java.lang.String r4 = r4.replace(r14, r13)     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r6 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        r8 = r25
                        java.util.ArrayList unused = r6.e5 = r8     // Catch:{ Exception -> 0x0020 }
                        java.util.Iterator r6 = r8.iterator()     // Catch:{ Exception -> 0x0020 }
                        r14 = r23
                    L_0x02c9:
                        boolean r8 = r6.hasNext()     // Catch:{ Exception -> 0x0020 }
                        if (r8 == 0) goto L_0x0379
                        java.lang.Object r8 = r6.next()     // Catch:{ Exception -> 0x0020 }
                        android.os.Bundle r8 = (android.os.Bundle) r8     // Catch:{ Exception -> 0x0020 }
                        r15 = r20
                        java.lang.String r9 = r8.getString(r15)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r10 = r8.getString(r12)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r11 = r8.getString(r5)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r10 = r3.B(r10, r11, r7)     // Catch:{ Exception -> 0x0020 }
                        r11 = r19
                        java.lang.String r8 = r8.getString(r11)     // Catch:{ Exception -> 0x0020 }
                        r13 = r24
                        boolean r16 = r9.equals(r13)     // Catch:{ Exception -> 0x0020 }
                        if (r16 == 0) goto L_0x031d
                        java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r9.<init>()     // Catch:{ Exception -> 0x0020 }
                        r9.append(r14)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r14 = "<div class=\"content\" DIR=\"\" id=\"f"
                        r9.append(r14)     // Catch:{ Exception -> 0x0020 }
                        r9.append(r8)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r8 = "\" style=\"font-family:HelveticaNeue-CondensedBold; font-size:26px; text-align:center;\">"
                        r9.append(r8)     // Catch:{ Exception -> 0x0020 }
                        r9.append(r10)     // Catch:{ Exception -> 0x0020 }
                        r8 = r18
                        r9.append(r8)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0020 }
                        r17 = r6
                        r16 = r7
                        r7 = r8
                        r14 = r9
                        goto L_0x036b
                    L_0x031d:
                        r17 = r6
                        r16 = r7
                        r7 = r18
                        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r6.<init>()     // Catch:{ Exception -> 0x0020 }
                        r6.append(r14)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r14 = "<a name=\"f"
                        r6.append(r14)     // Catch:{ Exception -> 0x0020 }
                        r6.append(r8)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r14 = "\"><div id=\"h"
                        r6.append(r14)     // Catch:{ Exception -> 0x0020 }
                        r6.append(r8)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r14 = "\" class=\"headerExpanded\"  DIR=\"LTR\" onclick=\"collapse(f"
                        r6.append(r14)     // Catch:{ Exception -> 0x0020 }
                        r6.append(r8)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r14 = ");toggleHeaderExpanded(h"
                        r6.append(r14)     // Catch:{ Exception -> 0x0020 }
                        r6.append(r8)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r14 = ");\"><span class=\"fieldname\" style=\"font-family:;\">"
                        r6.append(r14)     // Catch:{ Exception -> 0x0020 }
                        r6.append(r9)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r9 = "</span></div></a><div class=\"content\" DIR=\"LTR\" id=\"f"
                        r6.append(r9)     // Catch:{ Exception -> 0x0020 }
                        r6.append(r8)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r8 = "\" style=\"font-family:;\">"
                        r6.append(r8)     // Catch:{ Exception -> 0x0020 }
                        r6.append(r10)     // Catch:{ Exception -> 0x0020 }
                        r6.append(r7)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0020 }
                        r14 = r6
                    L_0x036b:
                        r18 = r7
                        r19 = r11
                        r24 = r13
                        r20 = r15
                        r7 = r16
                        r6 = r17
                        goto L_0x02c9
                    L_0x0379:
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r5 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        r5.m3()     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r5 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r6.<init>()     // Catch:{ Exception -> 0x0020 }
                        r6.append(r4)     // Catch:{ Exception -> 0x0020 }
                        r6.append(r14)     // Catch:{ Exception -> 0x0020 }
                        r6.append(r2)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r2 = r6.toString()     // Catch:{ Exception -> 0x0020 }
                        r5.A4 = r2     // Catch:{ Exception -> 0x0020 }
                        goto L_0x001c
                    L_0x0396:
                        r23 = r14
                        r4 = r19
                        r14 = r6
                        r6 = r7
                        r19 = r18
                        r18 = r12
                        r12 = r15
                        r15 = r20
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r7 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        int r7 = r7.g5     // Catch:{ Exception -> 0x0020 }
                        r20 = r3
                        r3 = 1
                        if (r7 != r3) goto L_0x0817
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r3 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        r3.y()     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r3 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        android.os.Bundle r3 = r3.y()     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r5 = "monographItem"
                        android.os.Bundle r3 = r3.getBundle(r5)     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r5 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        android.os.Bundle r5 = r5.y()     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r7 = "monograph"
                        android.os.Bundle r5 = r5.getBundle(r7)     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r7 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        android.os.Bundle r7 = r7.y()     // Catch:{ Exception -> 0x0020 }
                        r22 = r15
                        java.lang.String r15 = "monographMembers"
                        java.util.ArrayList r7 = r7.getParcelableArrayList(r15)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r15 = "text1"
                        java.lang.String r15 = r3.getString(r15)     // Catch:{ Exception -> 0x0020 }
                        r24 = r4
                        java.lang.String r4 = "text2"
                        java.lang.String r4 = r3.getString(r4)     // Catch:{ Exception -> 0x0020 }
                        r18 = r5
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r5 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        r25 = r14
                        java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r14.<init>()     // Catch:{ Exception -> 0x0020 }
                        r14.append(r15)     // Catch:{ Exception -> 0x0020 }
                        r26 = r6
                        java.lang.String r6 = " / "
                        r14.append(r6)     // Catch:{ Exception -> 0x0020 }
                        r14.append(r4)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r6 = r14.toString()     // Catch:{ Exception -> 0x0020 }
                        r5.F4 = r6     // Catch:{ Exception -> 0x0020 }
                        java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ Exception -> 0x0020 }
                        r5.<init>()     // Catch:{ Exception -> 0x0020 }
                        java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ Exception -> 0x0020 }
                        r6.<init>()     // Catch:{ Exception -> 0x0020 }
                        java.util.Iterator r7 = r7.iterator()     // Catch:{ Exception -> 0x0020 }
                        r14 = r23
                    L_0x0415:
                        boolean r19 = r7.hasNext()     // Catch:{ Exception -> 0x0020 }
                        if (r19 == 0) goto L_0x04c4
                        java.lang.Object r19 = r7.next()     // Catch:{ Exception -> 0x0020 }
                        r27 = r7
                        r7 = r19
                        android.os.Bundle r7 = (android.os.Bundle) r7     // Catch:{ Exception -> 0x0020 }
                        r28 = r8
                        java.lang.String r8 = "c.id"
                        java.lang.String r8 = r7.getString(r8)     // Catch:{ Exception -> 0x0020 }
                        r29 = r2
                        java.lang.String r2 = "g.id"
                        java.lang.String r2 = r7.getString(r2)     // Catch:{ Exception -> 0x0020 }
                        boolean r2 = r8.equals(r2)     // Catch:{ Exception -> 0x0020 }
                        if (r2 == 0) goto L_0x0442
                    L_0x043b:
                        r7 = r27
                        r8 = r28
                        r2 = r29
                        goto L_0x0415
                    L_0x0442:
                        java.lang.String r2 = "mgx.category_id"
                        java.lang.String r2 = r7.getString(r2)     // Catch:{ Exception -> 0x0020 }
                        int r2 = r2.length()     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r8 = "g.name"
                        if (r2 != 0) goto L_0x04b5
                        java.lang.String r2 = "g.id"
                        java.lang.String r2 = r7.getString(r2)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r14 = "t.generic_id"
                        java.lang.String r14 = r3.getString(r14)     // Catch:{ Exception -> 0x0020 }
                        boolean r2 = r2.equals(r14)     // Catch:{ Exception -> 0x0020 }
                        if (r2 == 0) goto L_0x0480
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r2.<init>()     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r14 = "<b>"
                        r2.append(r14)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r8 = r7.getString(r8)     // Catch:{ Exception -> 0x0020 }
                        r2.append(r8)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r8 = "</b>"
                        r2.append(r8)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0020 }
                    L_0x047c:
                        r5.add(r2)     // Catch:{ Exception -> 0x0020 }
                        goto L_0x04bc
                    L_0x0480:
                        java.lang.String r2 = r7.getString(r8)     // Catch:{ Exception -> 0x0020 }
                        boolean r2 = r15.equals(r2)     // Catch:{ Exception -> 0x0020 }
                        if (r2 != 0) goto L_0x049a
                        java.lang.String r2 = r7.getString(r8)     // Catch:{ Exception -> 0x0020 }
                        boolean r2 = r4.equals(r2)     // Catch:{ Exception -> 0x0020 }
                        if (r2 == 0) goto L_0x0495
                        goto L_0x049a
                    L_0x0495:
                        java.lang.String r2 = r7.getString(r8)     // Catch:{ Exception -> 0x0020 }
                        goto L_0x047c
                    L_0x049a:
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r2.<init>()     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r14 = "<b>"
                        r2.append(r14)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r8 = r7.getString(r8)     // Catch:{ Exception -> 0x0020 }
                        r2.append(r8)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r8 = "</b>"
                        r2.append(r8)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0020 }
                        goto L_0x047c
                    L_0x04b5:
                        java.lang.String r2 = r7.getString(r8)     // Catch:{ Exception -> 0x0020 }
                        r6.add(r2)     // Catch:{ Exception -> 0x0020 }
                    L_0x04bc:
                        java.lang.String r2 = "c.name"
                        java.lang.String r14 = r7.getString(r2)     // Catch:{ Exception -> 0x0020 }
                        goto L_0x043b
                    L_0x04c4:
                        r29 = r2
                        r28 = r8
                        int r2 = r14.length()     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r3 = "</p>"
                        if (r2 <= 0) goto L_0x0516
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r2.<init>()     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r4 = "<p style=\"font-size:22px;\"><b>"
                        r2.append(r4)     // Catch:{ Exception -> 0x0020 }
                        r2.append(r14)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r4 = " Interacting Members</b></p><p>"
                        r2.append(r4)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r4 = ", "
                        java.lang.String r4 = android.text.TextUtils.join(r4, r5)     // Catch:{ Exception -> 0x0020 }
                        r2.append(r4)     // Catch:{ Exception -> 0x0020 }
                        r2.append(r3)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0020 }
                        int r4 = r6.size()     // Catch:{ Exception -> 0x0020 }
                        if (r4 <= 0) goto L_0x0518
                        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r4.<init>()     // Catch:{ Exception -> 0x0020 }
                        r4.append(r2)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r2 = "<p><b>Exceptions: </b>"
                        r4.append(r2)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r2 = ", "
                        java.lang.String r2 = android.text.TextUtils.join(r2, r6)     // Catch:{ Exception -> 0x0020 }
                        r4.append(r2)     // Catch:{ Exception -> 0x0020 }
                        r4.append(r3)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r2 = r4.toString()     // Catch:{ Exception -> 0x0020 }
                        goto L_0x0518
                    L_0x0516:
                        r2 = r23
                    L_0x0518:
                        android.os.Bundle r4 = new android.os.Bundle     // Catch:{ Exception -> 0x0020 }
                        r4.<init>()     // Catch:{ Exception -> 0x0020 }
                        r4.putString(r13, r12)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r5 = "risk"
                        java.lang.String r6 = "Risk Rating"
                        r4.putString(r5, r6)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r5 = "summary"
                        java.lang.String r6 = "Summary"
                        r4.putString(r5, r6)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r5 = "severity"
                        java.lang.String r6 = "Severity"
                        r4.putString(r5, r6)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r5 = "Onset"
                        r6 = r16
                        r4.putString(r6, r5)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r5 = "reliability"
                        java.lang.String r7 = "Reliability"
                        r4.putString(r5, r7)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r5 = "management"
                        java.lang.String r7 = "Management"
                        r4.putString(r5, r7)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r5 = "discussion"
                        java.lang.String r7 = "Discussion"
                        r4.putString(r5, r7)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r5 = "footnotes"
                        java.lang.String r7 = "Footnotes"
                        r4.putString(r5, r7)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r5 = "dependencies"
                        java.lang.String r7 = "Dependencies"
                        r4.putString(r5, r7)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r5 = "members"
                        java.lang.String r7 = "Interacting Members"
                        r4.putString(r5, r7)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r30 = "title"
                        java.lang.String r31 = "dependencies"
                        java.lang.String r32 = "risk"
                        java.lang.String r33 = "summary"
                        java.lang.String r34 = "onset"
                        java.lang.String r35 = "management"
                        java.lang.String r36 = "members"
                        java.lang.String r37 = "discussion"
                        java.lang.String r38 = "footnotes"
                        java.lang.String[] r5 = new java.lang.String[]{r30, r31, r32, r33, r34, r35, r36, r37, r38}     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r7 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0598 }
                        androidx.fragment.app.FragmentActivity r8 = r7.r()     // Catch:{ Exception -> 0x0598 }
                        java.lang.String r7 = r7.d4(r8, r11)     // Catch:{ Exception -> 0x0598 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r8 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0595 }
                        androidx.fragment.app.FragmentActivity r11 = r8.r()     // Catch:{ Exception -> 0x0595 }
                        java.lang.String r8 = r8.d4(r11, r10)     // Catch:{ Exception -> 0x0595 }
                    L_0x0590:
                        r9 = r26
                        r10 = r28
                        goto L_0x05be
                    L_0x0595:
                        r0 = move-exception
                        r8 = r0
                        goto L_0x059c
                    L_0x0598:
                        r0 = move-exception
                        r8 = r0
                        r7 = r23
                    L_0x059c:
                        com.google.firebase.crashlytics.FirebaseCrashlytics r10 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()     // Catch:{ Exception -> 0x0020 }
                        r10.g(r8)     // Catch:{ Exception -> 0x0020 }
                        java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r10.<init>()     // Catch:{ Exception -> 0x0020 }
                        r10.append(r9)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r8 = r8.getLocalizedMessage()     // Catch:{ Exception -> 0x0020 }
                        r10.append(r8)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r8 = r10.toString()     // Catch:{ Exception -> 0x0020 }
                        r15 = r29
                        net.imedicaldoctor.imd.iMDLogger.f(r15, r8)     // Catch:{ Exception -> 0x0020 }
                        r8 = r23
                        goto L_0x0590
                    L_0x05be:
                        java.lang.String r7 = r7.replace(r10, r9)     // Catch:{ Exception -> 0x0020 }
                        r10 = r23
                        r9 = r25
                        java.lang.String r7 = r7.replace(r9, r10)     // Catch:{ Exception -> 0x0020 }
                        java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ Exception -> 0x0020 }
                        r9.<init>()     // Catch:{ Exception -> 0x0020 }
                        r16 = r8
                        r15 = r10
                        r11 = 0
                        r13 = 0
                    L_0x05d4:
                        r8 = 9
                        if (r11 >= r8) goto L_0x07ef
                        r8 = r5[r11]     // Catch:{ Exception -> 0x0020 }
                        r19 = r5
                        r5 = r18
                        r18 = r7
                        java.lang.String r7 = r5.getString(r8)     // Catch:{ Exception -> 0x0020 }
                        r17 = 1
                        int r13 = r13 + 1
                        r23 = r11
                        java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r11.<init>()     // Catch:{ Exception -> 0x0020 }
                        r11.append(r10)     // Catch:{ Exception -> 0x0020 }
                        r11.append(r13)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x0020 }
                        r39 = r10
                        java.lang.String r10 = "members"
                        boolean r10 = r8.equals(r10)     // Catch:{ Exception -> 0x0020 }
                        if (r10 == 0) goto L_0x0632
                        int r10 = r14.length()     // Catch:{ Exception -> 0x0020 }
                        if (r10 <= 0) goto L_0x0632
                        java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r10.<init>()     // Catch:{ Exception -> 0x0020 }
                        r10.append(r15)     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r15 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r31 = r4.getString(r8)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r32 = ""
                        java.lang.String r33 = "LTR"
                        java.lang.String r35 = ""
                        java.lang.String r36 = "margin-top:0.75em;"
                        java.lang.String r37 = ""
                        r30 = r15
                        r34 = r2
                        r38 = r11
                        java.lang.String r15 = r30.W4(r31, r32, r33, r34, r35, r36, r37, r38)     // Catch:{ Exception -> 0x0020 }
                        r10.append(r15)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r15 = r10.toString()     // Catch:{ Exception -> 0x0020 }
                    L_0x0632:
                        if (r7 == 0) goto L_0x07da
                        int r10 = r7.length()     // Catch:{ Exception -> 0x0020 }
                        if (r10 <= 0) goto L_0x07da
                        java.lang.String r8 = r4.getString(r8)     // Catch:{ Exception -> 0x0020 }
                        boolean r10 = r8.equals(r12)     // Catch:{ Exception -> 0x0020 }
                        if (r10 == 0) goto L_0x0683
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r10 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r10 = r10.F4     // Catch:{ Exception -> 0x0020 }
                        if (r10 != 0) goto L_0x064d
                        r25 = 1
                        goto L_0x064f
                    L_0x064d:
                        r25 = 0
                    L_0x064f:
                        int r10 = r10.length()     // Catch:{ Exception -> 0x0020 }
                        if (r10 != 0) goto L_0x0657
                        r10 = 1
                        goto L_0x0658
                    L_0x0657:
                        r10 = 0
                    L_0x0658:
                        r10 = r25 | r10
                        if (r10 == 0) goto L_0x0660
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r10 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        r10.F4 = r7     // Catch:{ Exception -> 0x0020 }
                    L_0x0660:
                        java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r10.<init>()     // Catch:{ Exception -> 0x0020 }
                        r10.append(r15)     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r15 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r27 = "HelveticaNeue-Thin"
                        java.lang.String r28 = "font-size:26px; text-align:center;"
                        java.lang.String r29 = ""
                        r25 = r15
                        r26 = r7
                        r30 = r11
                        java.lang.String r7 = r25.V4(r26, r27, r28, r29, r30)     // Catch:{ Exception -> 0x0020 }
                        r10.append(r7)     // Catch:{ Exception -> 0x0020 }
                    L_0x067d:
                        java.lang.String r7 = r10.toString()     // Catch:{ Exception -> 0x0020 }
                        goto L_0x07c2
                    L_0x0683:
                        java.lang.String r10 = "Dependencies"
                        boolean r10 = r8.equals(r10)     // Catch:{ Exception -> 0x0020 }
                        if (r10 == 0) goto L_0x06a8
                        java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r10.<init>()     // Catch:{ Exception -> 0x0020 }
                        r10.append(r15)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r11 = "<a name=\"fdependencies\"><div id=\"hdependencies\" class=\"header_warningExpanded\" onclick=\"collapse(fdependencies); toggleHeaderExpanded(hdependencies);\"><span class=\"fieldname\">Dependencies</span></div></a><div class=\"content_warning\" id=\"fdependencies\"><p>"
                        r10.append(r11)     // Catch:{ Exception -> 0x0020 }
                        r10.append(r7)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r7 = "</p></div>"
                        r10.append(r7)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r7 = r10.toString()     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r11 = "dependencies"
                        goto L_0x07c2
                    L_0x06a8:
                        java.lang.String r10 = "Summary"
                        boolean r10 = r8.equals(r10)     // Catch:{ Exception -> 0x0020 }
                        if (r10 == 0) goto L_0x0738
                        java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r10.<init>()     // Catch:{ Exception -> 0x0020 }
                        r10.append(r7)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r7 = "<p><b>Severity: </b> "
                        r10.append(r7)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r7 = "severity"
                        java.lang.String r7 = r5.getString(r7)     // Catch:{ Exception -> 0x0020 }
                        r10.append(r7)     // Catch:{ Exception -> 0x0020 }
                        r10.append(r3)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r7 = r10.toString()     // Catch:{ Exception -> 0x0020 }
                        java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r10.<init>()     // Catch:{ Exception -> 0x0020 }
                        r10.append(r7)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r7 = "<p><b>Reliability: </b> "
                        r10.append(r7)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r7 = "reliability"
                        java.lang.String r7 = r5.getString(r7)     // Catch:{ Exception -> 0x0020 }
                        r10.append(r7)     // Catch:{ Exception -> 0x0020 }
                        r10.append(r3)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r7 = r10.toString()     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r10 = r5.getString(r6)     // Catch:{ Exception -> 0x0020 }
                        int r10 = r10.length()     // Catch:{ Exception -> 0x0020 }
                        if (r10 <= 0) goto L_0x070f
                        java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r10.<init>()     // Catch:{ Exception -> 0x0020 }
                        r10.append(r7)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r7 = "<p><b>Reliability: </b> "
                        r10.append(r7)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r7 = r5.getString(r6)     // Catch:{ Exception -> 0x0020 }
                        r10.append(r7)     // Catch:{ Exception -> 0x0020 }
                        r10.append(r3)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r7 = r10.toString()     // Catch:{ Exception -> 0x0020 }
                    L_0x070f:
                        r29 = r7
                        java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r7.<init>()     // Catch:{ Exception -> 0x0020 }
                        r7.append(r15)     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r10 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r27 = ""
                        java.lang.String r28 = "LTR"
                        java.lang.String r30 = ""
                        java.lang.String r31 = "margin-top:0.75em;"
                        java.lang.String r32 = ""
                        r25 = r10
                        r26 = r8
                        r33 = r11
                        java.lang.String r10 = r25.W4(r26, r27, r28, r29, r30, r31, r32, r33)     // Catch:{ Exception -> 0x0020 }
                        r7.append(r10)     // Catch:{ Exception -> 0x0020 }
                    L_0x0732:
                        java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0020 }
                        goto L_0x07c2
                    L_0x0738:
                        java.lang.String r10 = "Risk Rating"
                        boolean r10 = r8.equals(r10)     // Catch:{ Exception -> 0x0020 }
                        if (r10 == 0) goto L_0x079d
                        java.lang.String r10 = "5"
                        boolean r10 = r7.equals(r10)     // Catch:{ Exception -> 0x0020 }
                        if (r10 == 0) goto L_0x074d
                        java.lang.String r7 = "X: Avoid combination"
                    L_0x074a:
                        r29 = r7
                        goto L_0x077b
                    L_0x074d:
                        java.lang.String r10 = "4"
                        boolean r10 = r7.equals(r10)     // Catch:{ Exception -> 0x0020 }
                        if (r10 == 0) goto L_0x0758
                        java.lang.String r7 = "D: Consider therapy modification"
                        goto L_0x074a
                    L_0x0758:
                        java.lang.String r10 = "3"
                        boolean r10 = r7.equals(r10)     // Catch:{ Exception -> 0x0020 }
                        if (r10 == 0) goto L_0x0763
                        java.lang.String r7 = "C: Monitor therapy"
                        goto L_0x074a
                    L_0x0763:
                        java.lang.String r10 = "2"
                        boolean r10 = r7.equals(r10)     // Catch:{ Exception -> 0x0020 }
                        if (r10 == 0) goto L_0x076e
                        java.lang.String r7 = "B: No action needed"
                        goto L_0x074a
                    L_0x076e:
                        java.lang.String r10 = "1"
                        boolean r7 = r7.equals(r10)     // Catch:{ Exception -> 0x0020 }
                        if (r7 == 0) goto L_0x0779
                        java.lang.String r7 = "A: No known interaction"
                        goto L_0x074a
                    L_0x0779:
                        r29 = r39
                    L_0x077b:
                        java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r7.<init>()     // Catch:{ Exception -> 0x0020 }
                        r7.append(r15)     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r10 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r27 = ""
                        java.lang.String r28 = "LTR"
                        java.lang.String r30 = ""
                        java.lang.String r31 = "margin-top:0.75em;"
                        java.lang.String r32 = ""
                        r25 = r10
                        r26 = r8
                        r33 = r11
                        java.lang.String r10 = r25.W4(r26, r27, r28, r29, r30, r31, r32, r33)     // Catch:{ Exception -> 0x0020 }
                        r7.append(r10)     // Catch:{ Exception -> 0x0020 }
                        goto L_0x0732
                    L_0x079d:
                        java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r10.<init>()     // Catch:{ Exception -> 0x0020 }
                        r10.append(r15)     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r15 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r27 = ""
                        java.lang.String r28 = "LTR"
                        java.lang.String r30 = ""
                        java.lang.String r31 = "margin-top:0.75em;"
                        java.lang.String r32 = ""
                        r25 = r15
                        r26 = r8
                        r29 = r7
                        r33 = r11
                        java.lang.String r7 = r25.W4(r26, r27, r28, r29, r30, r31, r32, r33)     // Catch:{ Exception -> 0x0020 }
                        r10.append(r7)     // Catch:{ Exception -> 0x0020 }
                        goto L_0x067d
                    L_0x07c2:
                        android.os.Bundle r10 = new android.os.Bundle     // Catch:{ Exception -> 0x0020 }
                        r10.<init>()     // Catch:{ Exception -> 0x0020 }
                        r15 = r24
                        r10.putString(r15, r11)     // Catch:{ Exception -> 0x0020 }
                        r11 = r22
                        r10.putString(r11, r8)     // Catch:{ Exception -> 0x0020 }
                        r9.add(r10)     // Catch:{ Exception -> 0x0020 }
                        r40 = r15
                        r15 = r7
                        r7 = r40
                        goto L_0x07de
                    L_0x07da:
                        r11 = r22
                        r7 = r24
                    L_0x07de:
                        int r8 = r23 + 1
                        r24 = r7
                        r22 = r11
                        r7 = r18
                        r10 = r39
                        r18 = r5
                        r11 = r8
                        r5 = r19
                        goto L_0x05d4
                    L_0x07ef:
                        r18 = r7
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r2 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        java.util.ArrayList unused = r2.e5 = r9     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r2 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        r2.m3()     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r2 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r3.<init>()     // Catch:{ Exception -> 0x0020 }
                        r4 = r18
                        r3.append(r4)     // Catch:{ Exception -> 0x0020 }
                        r3.append(r15)     // Catch:{ Exception -> 0x0020 }
                        r8 = r16
                        r3.append(r8)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0020 }
                    L_0x0813:
                        r2.A4 = r3     // Catch:{ Exception -> 0x0020 }
                        goto L_0x0e6a
                    L_0x0817:
                        r7 = r4
                        r4 = r6
                        r6 = r8
                        r3 = r14
                        r8 = r15
                        r15 = r2
                        r2 = r23
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r14 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        int r14 = r14.g5     // Catch:{ Exception -> 0x0020 }
                        r24 = r7
                        r7 = 2
                        r16 = r12
                        java.lang.String r12 = "Warning"
                        if (r14 != r7) goto L_0x0c38
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r7 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        android.os.Bundle r7 = r7.y()     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r14 = "ivMonograph"
                        java.util.ArrayList r7 = r7.getParcelableArrayList(r14)     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r14 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        android.os.Bundle r14 = r14.y()     // Catch:{ Exception -> 0x0020 }
                        r23 = r2
                        java.lang.String r2 = "Solutions"
                        java.util.ArrayList r2 = r14.getParcelableArrayList(r2)     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r14 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        android.os.Bundle r14 = r14.y()     // Catch:{ Exception -> 0x0020 }
                        r25 = r3
                        java.lang.String r3 = "Sites"
                        java.util.ArrayList r3 = r14.getParcelableArrayList(r3)     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r14 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        android.os.Bundle r14 = r14.y()     // Catch:{ Exception -> 0x0020 }
                        boolean r14 = r14.containsKey(r12)     // Catch:{ Exception -> 0x0020 }
                        if (r14 == 0) goto L_0x086e
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r14 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        android.os.Bundle r14 = r14.y()     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r12 = r14.getString(r12)     // Catch:{ Exception -> 0x0020 }
                    L_0x086c:
                        r14 = 0
                        goto L_0x0871
                    L_0x086e:
                        r12 = r23
                        goto L_0x086c
                    L_0x0871:
                        java.lang.Object r14 = r7.get(r14)     // Catch:{ Exception -> 0x0020 }
                        android.os.Bundle r14 = (android.os.Bundle) r14     // Catch:{ Exception -> 0x0020 }
                        r17 = r3
                        java.lang.String r3 = "d.id"
                        java.lang.String r3 = r14.getString(r3)     // Catch:{ Exception -> 0x0020 }
                        java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r14.<init>()     // Catch:{ Exception -> 0x0020 }
                        r18 = r7
                        java.lang.String r7 = "SELECT vf.label, sol.name,iv.content FROM document d JOIN chapter c ON c.id = d.chapter_id JOIN VIEW v ON v.id = c.view_id JOIN viewfield vf ON vf.view_id = v.id JOIN ivsolution iv ON d.id = iv.document_id AND vf.fieldtype_id = iv.fieldtype_id JOIN solution sol ON iv.solution_id = sol.id LEFT JOIN fieldtypesite f ON vf.fieldtype_id = f.fieldtype_id WHERE d.id ="
                        r14.append(r7)     // Catch:{ Exception -> 0x0020 }
                        r14.append(r3)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r3 = " and sol.id in ("
                        r14.append(r3)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r3 = net.imedicaldoctor.imd.Data.CompressHelper.I1(r2, r5)     // Catch:{ Exception -> 0x0020 }
                        r14.append(r3)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r3 = ")"
                        r14.append(r3)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r3 = r14.toString()     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r7 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        android.os.Bundle r7 = r7.D4     // Catch:{ Exception -> 0x0020 }
                        r14 = r20
                        java.util.ArrayList r3 = r14.V(r7, r3)     // Catch:{ Exception -> 0x0020 }
                        java.util.ArrayList r7 = r14.r2(r3, r8)     // Catch:{ Exception -> 0x0020 }
                        if (r7 != 0) goto L_0x08b8
                        java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ Exception -> 0x0020 }
                        r7.<init>()     // Catch:{ Exception -> 0x0020 }
                    L_0x08b8:
                        r20 = r3
                        android.os.Bundle r3 = new android.os.Bundle     // Catch:{ Exception -> 0x0020 }
                        r3.<init>()     // Catch:{ Exception -> 0x0020 }
                        java.util.Iterator r7 = r7.iterator()     // Catch:{ Exception -> 0x0020 }
                    L_0x08c3:
                        boolean r21 = r7.hasNext()     // Catch:{ Exception -> 0x0020 }
                        if (r21 == 0) goto L_0x08eb
                        java.lang.Object r21 = r7.next()     // Catch:{ Exception -> 0x0020 }
                        r22 = r7
                        r7 = r21
                        android.os.Bundle r7 = (android.os.Bundle) r7     // Catch:{ Exception -> 0x0020 }
                        r21 = r14
                        java.lang.String r14 = r7.getString(r13)     // Catch:{ Exception -> 0x0020 }
                        r26 = r13
                        java.lang.String r13 = "items"
                        java.util.ArrayList r7 = r7.getParcelableArrayList(r13)     // Catch:{ Exception -> 0x0020 }
                        r3.putParcelableArrayList(r14, r7)     // Catch:{ Exception -> 0x0020 }
                        r14 = r21
                        r7 = r22
                        r13 = r26
                        goto L_0x08c3
                    L_0x08eb:
                        r26 = r13
                        r21 = r14
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r7 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0908 }
                        androidx.fragment.app.FragmentActivity r13 = r7.r()     // Catch:{ Exception -> 0x0908 }
                        java.lang.String r7 = r7.d4(r13, r11)     // Catch:{ Exception -> 0x0908 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r11 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0904 }
                        androidx.fragment.app.FragmentActivity r13 = r11.r()     // Catch:{ Exception -> 0x0904 }
                        java.lang.String r10 = r11.d4(r13, r10)     // Catch:{ Exception -> 0x0904 }
                        goto L_0x092c
                    L_0x0904:
                        r0 = move-exception
                        r10 = r7
                        r7 = r0
                        goto L_0x090c
                    L_0x0908:
                        r0 = move-exception
                        r7 = r0
                        r10 = r23
                    L_0x090c:
                        com.google.firebase.crashlytics.FirebaseCrashlytics r11 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()     // Catch:{ Exception -> 0x0020 }
                        r11.g(r7)     // Catch:{ Exception -> 0x0020 }
                        java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r11.<init>()     // Catch:{ Exception -> 0x0020 }
                        r11.append(r9)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r7 = r7.getLocalizedMessage()     // Catch:{ Exception -> 0x0020 }
                        r11.append(r7)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r7 = r11.toString()     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.iMDLogger.f(r15, r7)     // Catch:{ Exception -> 0x0020 }
                        r7 = r10
                        r10 = r23
                    L_0x092c:
                        java.lang.String r4 = r7.replace(r6, r4)     // Catch:{ Exception -> 0x0020 }
                        r13 = r23
                        r7 = r25
                        java.lang.String r4 = r4.replace(r7, r13)     // Catch:{ Exception -> 0x0020 }
                        java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ Exception -> 0x0020 }
                        r6.<init>()     // Catch:{ Exception -> 0x0020 }
                        int r7 = r12.length()     // Catch:{ Exception -> 0x0020 }
                        if (r7 <= 0) goto L_0x095d
                        java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r7.<init>()     // Catch:{ Exception -> 0x0020 }
                        r7.append(r13)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r9 = "<div style=\"color:red; text-align:center;\">"
                        r7.append(r9)     // Catch:{ Exception -> 0x0020 }
                        r7.append(r12)     // Catch:{ Exception -> 0x0020 }
                        r14 = r19
                        r7.append(r14)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0020 }
                        goto L_0x095e
                    L_0x095d:
                        r7 = r13
                    L_0x095e:
                        java.util.Iterator r9 = r18.iterator()     // Catch:{ Exception -> 0x0020 }
                    L_0x0962:
                        boolean r11 = r9.hasNext()     // Catch:{ Exception -> 0x0020 }
                        if (r11 == 0) goto L_0x0a47
                        java.lang.Object r11 = r9.next()     // Catch:{ Exception -> 0x0020 }
                        android.os.Bundle r11 = (android.os.Bundle) r11     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r12 = "vf.label"
                        java.lang.String r12 = r11.getString(r12)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r14 = "f.content"
                        java.lang.String r14 = r11.getString(r14)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r15 = "vf.sequence"
                        java.lang.String r11 = r11.getString(r15)     // Catch:{ Exception -> 0x0020 }
                        r15 = r16
                        boolean r16 = r12.equals(r15)     // Catch:{ Exception -> 0x0020 }
                        if (r16 == 0) goto L_0x09c2
                        r16 = r9
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r9 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        r18 = r15
                        java.lang.String r15 = "\">"
                        r23 = r13
                        java.lang.String r13 = "<"
                        java.lang.String r13 = net.imedicaldoctor.imd.Data.CompressHelper.f(r14, r15, r13)     // Catch:{ Exception -> 0x0020 }
                        r9.F4 = r13     // Catch:{ Exception -> 0x0020 }
                        java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r9.<init>()     // Catch:{ Exception -> 0x0020 }
                        r9.append(r7)     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r7 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r29 = ""
                        java.lang.String r30 = "LTR"
                        java.lang.String r32 = ""
                        java.lang.String r33 = "margin-top:0.5em;font-size:22;"
                        java.lang.String r34 = ""
                        r27 = r7
                        r28 = r12
                        r31 = r14
                        r35 = r11
                        java.lang.String r7 = r27.W4(r28, r29, r30, r31, r32, r33, r34, r35)     // Catch:{ Exception -> 0x0020 }
                        r9.append(r7)     // Catch:{ Exception -> 0x0020 }
                    L_0x09bd:
                        java.lang.String r7 = r9.toString()     // Catch:{ Exception -> 0x0020 }
                        goto L_0x0a2d
                    L_0x09c2:
                        r16 = r9
                        r23 = r13
                        r18 = r15
                        boolean r9 = r3.containsKey(r12)     // Catch:{ Exception -> 0x0020 }
                        if (r9 == 0) goto L_0x0a09
                        java.util.ArrayList r9 = r3.getParcelableArrayList(r12)     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r13 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r9 = r13.J4(r2, r9, r12)     // Catch:{ Exception -> 0x0020 }
                        java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r13.<init>()     // Catch:{ Exception -> 0x0020 }
                        r13.append(r9)     // Catch:{ Exception -> 0x0020 }
                        r13.append(r14)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r31 = r13.toString()     // Catch:{ Exception -> 0x0020 }
                        java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r9.<init>()     // Catch:{ Exception -> 0x0020 }
                        r9.append(r7)     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r7 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r29 = ""
                        java.lang.String r30 = "LTR"
                        java.lang.String r32 = ""
                        java.lang.String r33 = ""
                        java.lang.String r34 = ""
                        r27 = r7
                        r28 = r12
                        r35 = r11
                        java.lang.String r7 = r27.W4(r28, r29, r30, r31, r32, r33, r34, r35)     // Catch:{ Exception -> 0x0020 }
                        r9.append(r7)     // Catch:{ Exception -> 0x0020 }
                        goto L_0x09bd
                    L_0x0a09:
                        java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r9.<init>()     // Catch:{ Exception -> 0x0020 }
                        r9.append(r7)     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r7 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r29 = ""
                        java.lang.String r30 = "LTR"
                        java.lang.String r32 = ""
                        java.lang.String r33 = ""
                        java.lang.String r34 = ""
                        r27 = r7
                        r28 = r12
                        r31 = r14
                        r35 = r11
                        java.lang.String r7 = r27.W4(r28, r29, r30, r31, r32, r33, r34, r35)     // Catch:{ Exception -> 0x0020 }
                        r9.append(r7)     // Catch:{ Exception -> 0x0020 }
                        goto L_0x09bd
                    L_0x0a2d:
                        android.os.Bundle r9 = new android.os.Bundle     // Catch:{ Exception -> 0x0020 }
                        r9.<init>()     // Catch:{ Exception -> 0x0020 }
                        r13 = r24
                        r9.putString(r13, r11)     // Catch:{ Exception -> 0x0020 }
                        r9.putString(r8, r12)     // Catch:{ Exception -> 0x0020 }
                        r6.add(r9)     // Catch:{ Exception -> 0x0020 }
                        r24 = r13
                        r9 = r16
                        r16 = r18
                        r13 = r23
                        goto L_0x0962
                    L_0x0a47:
                        r23 = r13
                        r13 = r24
                        java.lang.String r3 = "Drug-Drug Compatibility"
                        java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r9.<init>()     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r11 = "select p.document_id, p.level, i.rowid as g1rowid, i.name as g1name, g1.id as g1id, 0 as g2rowid, g2.name as g2name, g2.id as g2id from item i join generic g1 on g1.id = i.generic_id join pair p on p.generic1_id = g1.id join generic g2 on g2.id = p.generic2_id join ivsolution iv on p.document_id = iv.document_id left join fieldtypesite f on iv.fieldtype_id = f.fieldtype_id where i.rowid = "
                        r9.append(r11)     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r11 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r11 = r11.E4     // Catch:{ Exception -> 0x0020 }
                        r9.append(r11)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r11 = " and f.site_id in ("
                        r9.append(r11)     // Catch:{ Exception -> 0x0020 }
                        r11 = r17
                        java.lang.String r11 = net.imedicaldoctor.imd.Data.CompressHelper.I1(r11, r5)     // Catch:{ Exception -> 0x0020 }
                        r9.append(r11)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r11 = ") union select p.document_id, p.level, 0 as g1rowid, g1.name, g1.id, i.rowid as g2rowid, i.name, g2.id from item i join generic g2 on g2.id = i.generic_id join pair p on p.generic2_id = g2.id join generic g1 on g1.id = p.generic1_id join ivsolution iv on p.document_id = iv.document_id left join fieldtypesite f on iv.fieldtype_id = f.fieldtype_id where i.rowid = "
                        r9.append(r11)     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r11 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r11 = r11.E4     // Catch:{ Exception -> 0x0020 }
                        r9.append(r11)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r11 = " order by level asc, g1name, g2name"
                        r9.append(r11)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r11 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        android.os.Bundle r11 = r11.D4     // Catch:{ Exception -> 0x0020 }
                        r12 = r21
                        java.util.ArrayList r9 = r12.V(r11, r9)     // Catch:{ Exception -> 0x0020 }
                        java.util.Iterator r9 = r9.iterator()     // Catch:{ Exception -> 0x0020 }
                        r11 = r23
                    L_0x0a91:
                        boolean r14 = r9.hasNext()     // Catch:{ Exception -> 0x0020 }
                        if (r14 == 0) goto L_0x0bce
                        java.lang.Object r14 = r9.next()     // Catch:{ Exception -> 0x0020 }
                        android.os.Bundle r14 = (android.os.Bundle) r14     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r15 = "p.document_id"
                        java.lang.String r15 = r14.getString(r15)     // Catch:{ Exception -> 0x0020 }
                        r16 = r9
                        java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r9.<init>()     // Catch:{ Exception -> 0x0020 }
                        r17 = r10
                        java.lang.String r10 = "SELECT vf.label, sol.name,iv.content FROM document d JOIN chapter c ON c.id = d.chapter_id JOIN VIEW v ON v.id = c.view_id JOIN viewfield vf ON vf.view_id = v.id JOIN ivsolution iv ON d.id = iv.document_id AND vf.fieldtype_id = iv.fieldtype_id JOIN solution sol ON iv.solution_id = sol.id LEFT JOIN fieldtypesite f ON vf.fieldtype_id = f.fieldtype_id WHERE d.id ="
                        r9.append(r10)     // Catch:{ Exception -> 0x0020 }
                        r9.append(r15)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r10 = " and sol.id in ("
                        r9.append(r10)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r10 = net.imedicaldoctor.imd.Data.CompressHelper.I1(r2, r5)     // Catch:{ Exception -> 0x0020 }
                        r9.append(r10)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r10 = ")"
                        r9.append(r10)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r10 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        android.os.Bundle r10 = r10.D4     // Catch:{ Exception -> 0x0020 }
                        r12.V(r10, r9)     // Catch:{ Exception -> 0x0020 }
                        r9 = r20
                        java.util.ArrayList r10 = r12.r2(r9, r8)     // Catch:{ Exception -> 0x0020 }
                        if (r10 != 0) goto L_0x0ae3
                        r18 = r4
                        r22 = r5
                        r20 = r9
                        r21 = r12
                        r4 = r26
                        goto L_0x0b3b
                    L_0x0ae3:
                        java.util.Iterator r10 = r10.iterator()     // Catch:{ Exception -> 0x0020 }
                        r20 = r9
                        r9 = r23
                    L_0x0aeb:
                        boolean r18 = r10.hasNext()     // Catch:{ Exception -> 0x0020 }
                        if (r18 == 0) goto L_0x0b2d
                        java.lang.Object r18 = r10.next()     // Catch:{ Exception -> 0x0020 }
                        r19 = r10
                        r10 = r18
                        android.os.Bundle r10 = (android.os.Bundle) r10     // Catch:{ Exception -> 0x0020 }
                        r21 = r12
                        java.lang.String r12 = "items"
                        java.util.ArrayList r12 = r10.getParcelableArrayList(r12)     // Catch:{ Exception -> 0x0020 }
                        r22 = r5
                        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r5.<init>()     // Catch:{ Exception -> 0x0020 }
                        r5.append(r9)     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r9 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        r18 = r4
                        r4 = r26
                        java.lang.String r10 = r10.getString(r4)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r9 = r9.J4(r2, r12, r10)     // Catch:{ Exception -> 0x0020 }
                        r5.append(r9)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r9 = r5.toString()     // Catch:{ Exception -> 0x0020 }
                        r26 = r4
                        r4 = r18
                        r10 = r19
                        r12 = r21
                        r5 = r22
                        goto L_0x0aeb
                    L_0x0b2d:
                        r18 = r4
                        r22 = r5
                        r21 = r12
                        r4 = r26
                        int r5 = r9.length()     // Catch:{ Exception -> 0x0020 }
                        if (r5 != 0) goto L_0x0b49
                    L_0x0b3b:
                        r26 = r4
                        r9 = r16
                        r10 = r17
                        r4 = r18
                        r12 = r21
                        r5 = r22
                        goto L_0x0a91
                    L_0x0b49:
                        java.lang.String r5 = "g2id"
                        java.lang.String r5 = r14.getString(r5)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r10 = "g2name"
                        java.lang.String r10 = r14.getString(r10)     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r12 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r12 = r12.F4     // Catch:{ Exception -> 0x0020 }
                        boolean r12 = r10.equals(r12)     // Catch:{ Exception -> 0x0020 }
                        if (r12 == 0) goto L_0x0b6b
                        java.lang.String r5 = "g1name"
                        java.lang.String r10 = r14.getString(r5)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r5 = "g1id"
                        java.lang.String r5 = r14.getString(r5)     // Catch:{ Exception -> 0x0020 }
                    L_0x0b6b:
                        java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r12.<init>()     // Catch:{ Exception -> 0x0020 }
                        r12.append(r11)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r11 = "<div id=\"ivcgid"
                        r12.append(r11)     // Catch:{ Exception -> 0x0020 }
                        r12.append(r5)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r11 = "\" class=\"ivc_item\"><span id=\"ivcgid"
                        r12.append(r11)     // Catch:{ Exception -> 0x0020 }
                        r12.append(r5)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r11 = "title\" class=\"collapsible-title collapsible-title-collapsed\" onclick=\"collapse(ivcgid"
                        r12.append(r11)     // Catch:{ Exception -> 0x0020 }
                        r12.append(r5)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r11 = "content); toggleContentTitleExpanded($(this));\">"
                        r12.append(r11)     // Catch:{ Exception -> 0x0020 }
                        r12.append(r10)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r10 = "</span><div class=\"ivc_item_content\" style=\"display:none;\" id=\"ivcgid"
                        r12.append(r10)     // Catch:{ Exception -> 0x0020 }
                        r12.append(r5)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r5 = "content\">"
                        r12.append(r5)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r5 = r12.toString()     // Catch:{ Exception -> 0x0020 }
                        java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r10.<init>()     // Catch:{ Exception -> 0x0020 }
                        r10.append(r5)     // Catch:{ Exception -> 0x0020 }
                        r10.append(r9)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r5 = r10.toString()     // Catch:{ Exception -> 0x0020 }
                        java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r9.<init>()     // Catch:{ Exception -> 0x0020 }
                        r9.append(r5)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r5 = "<div class=\"ivc_more_info\"><a href=\"ivcpair:"
                        r9.append(r5)     // Catch:{ Exception -> 0x0020 }
                        r9.append(r15)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r5 = "\">See more information</a></div></div></div>"
                        r9.append(r5)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r11 = r9.toString()     // Catch:{ Exception -> 0x0020 }
                        goto L_0x0b3b
                    L_0x0bce:
                        r18 = r4
                        r17 = r10
                        r21 = r12
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r2.<init>()     // Catch:{ Exception -> 0x0020 }
                        r2.append(r7)     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r4 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r29 = ""
                        java.lang.String r30 = "LTR"
                        java.lang.String r32 = ""
                        java.lang.String r33 = ""
                        java.lang.String r34 = ""
                        java.lang.String r35 = "drugdrug"
                        r27 = r4
                        r28 = r3
                        r31 = r11
                        java.lang.String r4 = r27.W4(r28, r29, r30, r31, r32, r33, r34, r35)     // Catch:{ Exception -> 0x0020 }
                        r2.append(r4)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0020 }
                        android.os.Bundle r4 = new android.os.Bundle     // Catch:{ Exception -> 0x0020 }
                        r4.<init>()     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r5 = "drugdrug"
                        r4.putString(r13, r5)     // Catch:{ Exception -> 0x0020 }
                        r4.putString(r8, r3)     // Catch:{ Exception -> 0x0020 }
                        r6.add(r4)     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r3 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        r3.m3()     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r3 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        r3.I4()     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r3 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        java.util.ArrayList unused = r3.e5 = r6     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r3 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r4.<init>()     // Catch:{ Exception -> 0x0020 }
                        r5 = r18
                        r4.append(r5)     // Catch:{ Exception -> 0x0020 }
                        r4.append(r2)     // Catch:{ Exception -> 0x0020 }
                        r10 = r17
                        r4.append(r10)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r2 = r4.toString()     // Catch:{ Exception -> 0x0020 }
                        r3.A4 = r2     // Catch:{ Exception -> 0x0020 }
                        r20 = r21
                        goto L_0x0e6a
                    L_0x0c38:
                        r23 = r2
                        r7 = r3
                        r3 = r4
                        r22 = r5
                        r4 = r13
                        r14 = r19
                        r2 = r20
                        r13 = r24
                        r24 = r16
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r5 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        int r5 = r5.g5     // Catch:{ Exception -> 0x0020 }
                        r19 = r13
                        r13 = 3
                        if (r5 != r13) goto L_0x0e68
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r5 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        android.os.Bundle r5 = r5.y()     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r13 = "ivMonograph"
                        java.util.ArrayList r5 = r5.getParcelableArrayList(r13)     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r13 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        android.os.Bundle r13 = r13.y()     // Catch:{ Exception -> 0x0020 }
                        r16 = r5
                        java.lang.String r5 = "Solutions"
                        java.util.ArrayList r5 = r13.getParcelableArrayList(r5)     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r13 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        android.os.Bundle r13 = r13.y()     // Catch:{ Exception -> 0x0020 }
                        r17 = r14
                        java.lang.String r14 = "Sites"
                        r13.getParcelableArrayList(r14)     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r13 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        android.os.Bundle r13 = r13.y()     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r12 = r13.getString(r12)     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r13 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        android.os.Bundle r13 = r13.y()     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r14 = "docId"
                        java.lang.String r13 = r13.getString(r14)     // Catch:{ Exception -> 0x0020 }
                        java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r14.<init>()     // Catch:{ Exception -> 0x0020 }
                        r20 = r12
                        java.lang.String r12 = "SELECT vf.label, sol.name,iv.content FROM document d JOIN chapter c ON c.id = d.chapter_id JOIN VIEW v ON v.id = c.view_id JOIN viewfield vf ON vf.view_id = v.id JOIN ivsolution iv ON d.id = iv.document_id AND vf.fieldtype_id = iv.fieldtype_id JOIN solution sol ON iv.solution_id = sol.id LEFT JOIN fieldtypesite f ON vf.fieldtype_id = f.fieldtype_id WHERE d.id ="
                        r14.append(r12)     // Catch:{ Exception -> 0x0020 }
                        r14.append(r13)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r12 = " and sol.id in ("
                        r14.append(r12)     // Catch:{ Exception -> 0x0020 }
                        r12 = r22
                        java.lang.String r12 = net.imedicaldoctor.imd.Data.CompressHelper.I1(r5, r12)     // Catch:{ Exception -> 0x0020 }
                        r14.append(r12)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r12 = ")"
                        r14.append(r12)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r12 = r14.toString()     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r13 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        android.os.Bundle r13 = r13.D4     // Catch:{ Exception -> 0x0020 }
                        java.util.ArrayList r12 = r2.V(r13, r12)     // Catch:{ Exception -> 0x0020 }
                        java.util.ArrayList r12 = r2.r2(r12, r8)     // Catch:{ Exception -> 0x0020 }
                        android.os.Bundle r13 = new android.os.Bundle     // Catch:{ Exception -> 0x0020 }
                        r13.<init>()     // Catch:{ Exception -> 0x0020 }
                        java.util.Iterator r12 = r12.iterator()     // Catch:{ Exception -> 0x0020 }
                    L_0x0cca:
                        boolean r14 = r12.hasNext()     // Catch:{ Exception -> 0x0020 }
                        if (r14 == 0) goto L_0x0cec
                        java.lang.Object r14 = r12.next()     // Catch:{ Exception -> 0x0020 }
                        android.os.Bundle r14 = (android.os.Bundle) r14     // Catch:{ Exception -> 0x0020 }
                        r21 = r12
                        java.lang.String r12 = r14.getString(r4)     // Catch:{ Exception -> 0x0020 }
                        r26 = r4
                        java.lang.String r4 = "items"
                        java.util.ArrayList r4 = r14.getParcelableArrayList(r4)     // Catch:{ Exception -> 0x0020 }
                        r13.putParcelableArrayList(r12, r4)     // Catch:{ Exception -> 0x0020 }
                        r12 = r21
                        r4 = r26
                        goto L_0x0cca
                    L_0x0cec:
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r4 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0d05 }
                        androidx.fragment.app.FragmentActivity r12 = r4.r()     // Catch:{ Exception -> 0x0d05 }
                        java.lang.String r4 = r4.d4(r12, r11)     // Catch:{ Exception -> 0x0d05 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r11 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0d01 }
                        androidx.fragment.app.FragmentActivity r12 = r11.r()     // Catch:{ Exception -> 0x0d01 }
                        java.lang.String r10 = r11.d4(r12, r10)     // Catch:{ Exception -> 0x0d01 }
                        goto L_0x0d29
                    L_0x0d01:
                        r0 = move-exception
                        r10 = r4
                        r4 = r0
                        goto L_0x0d09
                    L_0x0d05:
                        r0 = move-exception
                        r4 = r0
                        r10 = r23
                    L_0x0d09:
                        com.google.firebase.crashlytics.FirebaseCrashlytics r11 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()     // Catch:{ Exception -> 0x0020 }
                        r11.g(r4)     // Catch:{ Exception -> 0x0020 }
                        java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r11.<init>()     // Catch:{ Exception -> 0x0020 }
                        r11.append(r9)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r4 = r4.getLocalizedMessage()     // Catch:{ Exception -> 0x0020 }
                        r11.append(r4)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r4 = r11.toString()     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.iMDLogger.f(r15, r4)     // Catch:{ Exception -> 0x0020 }
                        r4 = r10
                        r10 = r23
                    L_0x0d29:
                        java.lang.String r3 = r4.replace(r6, r3)     // Catch:{ Exception -> 0x0020 }
                        r4 = r23
                        java.lang.String r3 = r3.replace(r7, r4)     // Catch:{ Exception -> 0x0020 }
                        java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ Exception -> 0x0020 }
                        r6.<init>()     // Catch:{ Exception -> 0x0020 }
                        int r7 = r20.length()     // Catch:{ Exception -> 0x0020 }
                        if (r7 <= 0) goto L_0x0d5a
                        java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r7.<init>()     // Catch:{ Exception -> 0x0020 }
                        r7.append(r4)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r4 = "<div style=\"color:red; text-align:center;\">"
                        r7.append(r4)     // Catch:{ Exception -> 0x0020 }
                        r4 = r20
                        r7.append(r4)     // Catch:{ Exception -> 0x0020 }
                        r4 = r17
                        r7.append(r4)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r14 = r7.toString()     // Catch:{ Exception -> 0x0020 }
                        goto L_0x0d5b
                    L_0x0d5a:
                        r14 = r4
                    L_0x0d5b:
                        java.util.Iterator r4 = r16.iterator()     // Catch:{ Exception -> 0x0020 }
                    L_0x0d5f:
                        boolean r7 = r4.hasNext()     // Catch:{ Exception -> 0x0020 }
                        if (r7 == 0) goto L_0x0e41
                        java.lang.Object r7 = r4.next()     // Catch:{ Exception -> 0x0020 }
                        android.os.Bundle r7 = (android.os.Bundle) r7     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r9 = r7.getString(r8)     // Catch:{ Exception -> 0x0020 }
                        r11 = r18
                        java.lang.String r12 = r7.getString(r11)     // Catch:{ Exception -> 0x0020 }
                        r15 = r19
                        java.lang.String r7 = r7.getString(r15)     // Catch:{ Exception -> 0x0020 }
                        r16 = r4
                        r4 = r24
                        boolean r17 = r9.equals(r4)     // Catch:{ Exception -> 0x0020 }
                        if (r17 == 0) goto L_0x0dc0
                        r24 = r4
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r4 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        r18 = r11
                        java.lang.String r11 = "\">"
                        r20 = r2
                        java.lang.String r2 = "<"
                        java.lang.String r2 = net.imedicaldoctor.imd.Data.CompressHelper.f(r12, r11, r2)     // Catch:{ Exception -> 0x0020 }
                        r4.F4 = r2     // Catch:{ Exception -> 0x0020 }
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r2.<init>()     // Catch:{ Exception -> 0x0020 }
                        r2.append(r14)     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r4 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r27 = ""
                        java.lang.String r28 = "LTR"
                        java.lang.String r30 = ""
                        java.lang.String r31 = "margin-top:0.5em;font-size:22;"
                        java.lang.String r32 = ""
                        r25 = r4
                        r26 = r9
                        r29 = r12
                        r33 = r7
                        java.lang.String r4 = r25.W4(r26, r27, r28, r29, r30, r31, r32, r33)     // Catch:{ Exception -> 0x0020 }
                        r2.append(r4)     // Catch:{ Exception -> 0x0020 }
                    L_0x0dba:
                        java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0020 }
                        r14 = r2
                        goto L_0x0e2b
                    L_0x0dc0:
                        r20 = r2
                        r24 = r4
                        r18 = r11
                        boolean r2 = r13.containsKey(r9)     // Catch:{ Exception -> 0x0020 }
                        if (r2 == 0) goto L_0x0e07
                        java.util.ArrayList r2 = r13.getParcelableArrayList(r9)     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r4 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r2 = r4.J4(r5, r2, r9)     // Catch:{ Exception -> 0x0020 }
                        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r4.<init>()     // Catch:{ Exception -> 0x0020 }
                        r4.append(r2)     // Catch:{ Exception -> 0x0020 }
                        r4.append(r12)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r29 = r4.toString()     // Catch:{ Exception -> 0x0020 }
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r2.<init>()     // Catch:{ Exception -> 0x0020 }
                        r2.append(r14)     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r4 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r27 = ""
                        java.lang.String r28 = "LTR"
                        java.lang.String r30 = ""
                        java.lang.String r31 = ""
                        java.lang.String r32 = ""
                        r25 = r4
                        r26 = r9
                        r33 = r7
                        java.lang.String r4 = r25.W4(r26, r27, r28, r29, r30, r31, r32, r33)     // Catch:{ Exception -> 0x0020 }
                        r2.append(r4)     // Catch:{ Exception -> 0x0020 }
                        goto L_0x0dba
                    L_0x0e07:
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r2.<init>()     // Catch:{ Exception -> 0x0020 }
                        r2.append(r14)     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r4 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r27 = ""
                        java.lang.String r28 = "LTR"
                        java.lang.String r30 = ""
                        java.lang.String r31 = ""
                        java.lang.String r32 = ""
                        r25 = r4
                        r26 = r9
                        r29 = r12
                        r33 = r7
                        java.lang.String r4 = r25.W4(r26, r27, r28, r29, r30, r31, r32, r33)     // Catch:{ Exception -> 0x0020 }
                        r2.append(r4)     // Catch:{ Exception -> 0x0020 }
                        goto L_0x0dba
                    L_0x0e2b:
                        android.os.Bundle r2 = new android.os.Bundle     // Catch:{ Exception -> 0x0020 }
                        r2.<init>()     // Catch:{ Exception -> 0x0020 }
                        r2.putString(r15, r7)     // Catch:{ Exception -> 0x0020 }
                        r2.putString(r8, r9)     // Catch:{ Exception -> 0x0020 }
                        r6.add(r2)     // Catch:{ Exception -> 0x0020 }
                        r19 = r15
                        r4 = r16
                        r2 = r20
                        goto L_0x0d5f
                    L_0x0e41:
                        r20 = r2
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r2 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        r2.m3()     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r2 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        r2.I4()     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r2 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        java.util.ArrayList unused = r2.e5 = r6     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r2 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r4.<init>()     // Catch:{ Exception -> 0x0020 }
                        r4.append(r3)     // Catch:{ Exception -> 0x0020 }
                        r4.append(r14)     // Catch:{ Exception -> 0x0020 }
                        r4.append(r10)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x0020 }
                        goto L_0x0813
                    L_0x0e68:
                        r20 = r2
                    L_0x0e6a:
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r2 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        r2.U4()     // Catch:{ Exception -> 0x0020 }
                        boolean r2 = r20.x1()     // Catch:{ Exception -> 0x0020 }
                        if (r2 != 0) goto L_0x0e7c
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r2 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r3 = "Topic"
                        r2.m4(r3)     // Catch:{ Exception -> 0x0020 }
                    L_0x0e7c:
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r2 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        android.os.Bundle r2 = r2.D4     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r3 = "Path"
                        java.lang.String r2 = r2.getString(r3)     // Catch:{ Exception -> 0x0020 }
                        java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x0020 }
                        r3.<init>(r2)     // Catch:{ Exception -> 0x0020 }
                        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0020 }
                        r4.<init>()     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r5 = "file://"
                        r4.append(r5)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ Exception -> 0x0020 }
                        r4.append(r3)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r3 = "/"
                        r4.append(r3)     // Catch:{ Exception -> 0x0020 }
                        java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x0020 }
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r4 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this     // Catch:{ Exception -> 0x0020 }
                        r4.Z4 = r3     // Catch:{ Exception -> 0x0020 }
                        r4.h3(r2)     // Catch:{ Exception -> 0x0020 }
                        goto L_0x0ebf
                    L_0x0ead:
                        com.google.firebase.crashlytics.FirebaseCrashlytics r3 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()
                        r3.g(r2)
                        r2.printStackTrace()
                        net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r3 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.this
                        java.lang.String r2 = r2.getLocalizedMessage()
                        r3.p4 = r2
                    L_0x0ebf:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.LXViewerFragment.AnonymousClass1.run():void");
                }
            }, new Runnable() {
                public void run() {
                    String str = LXViewerFragment.this.p4;
                    if (str == null || str.length() <= 0) {
                        LXViewerFragment.this.G4.clearCache(true);
                        LXViewerFragment lXViewerFragment = LXViewerFragment.this;
                        lXViewerFragment.O3(lXViewerFragment.A4, lXViewerFragment.Z4);
                        LXViewerFragment.this.s4();
                        LXViewerFragment.this.p4();
                        LXViewerFragment.this.f3(R.menu.f1454menu_lxviewer);
                        LXViewerFragment.this.o2(false);
                        LXViewerFragment.this.G3();
                        return;
                    }
                    LXViewerFragment lXViewerFragment2 = LXViewerFragment.this;
                    lXViewerFragment2.C4(lXViewerFragment2.p4);
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
                    String replace = this.Z4.replace("file://", "");
                    if (replace.endsWith("/")) {
                        replace = replace.substring(0, replace.length() - 1);
                    }
                    String[] splitByWholeSeparator2 = StringUtils.splitByWholeSeparator(str2, "/");
                    for (String str3 : splitByWholeSeparator2) {
                        if (str3.equals("..")) {
                            str = X4(str);
                        } else {
                            str = str + "/" + str3;
                        }
                    }
                    try {
                        if (this.b5 && splitByWholeSeparator2.length > 0) {
                            String str4 = splitByWholeSeparator2[splitByWholeSeparator2.length - 1];
                            CompressHelper compressHelper = this.Q4;
                            Bundle z = compressHelper.z(compressHelper.V(this.D4, "Select * from images where imageName='" + str4 + "'"));
                            if (z != null) {
                                String string = z.getString("desc");
                                if (!this.Y4.containsKey(str4)) {
                                    this.Y4.putString(str4, string);
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
                this.X4 = arrayList;
                o4();
            }
            return super.W3(consoleMessage);
        }

        public String X4(String str) {
            ArrayList arrayList = new ArrayList(Arrays.asList(StringUtils.splitByWholeSeparator(str, "/")));
            arrayList.remove(arrayList.size() - 1);
            return StringUtils.join((Iterable<?>) arrayList, "/");
        }

        public void Z3(WebView webView, String str) {
            super.Z3(webView, str);
            this.G4.g("ConvertAllImages();");
            this.G4.g("fixAllImages2();");
            this.G4.g("console.log(\"images,,,,,\" + getImageList());");
        }

        public boolean e1(MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            if (itemId == R.id.f817action_sound && new File(T4()).exists()) {
                b4(T4());
            }
            if (itemId == R.id.f801action_menu) {
                LXSectionsViewer lXSectionsViewer = new LXSectionsViewer();
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("fields", this.e5);
                lXSectionsViewer.i2(bundle);
                lXSectionsViewer.Z2(true);
                lXSectionsViewer.A2(this, 0);
                lXSectionsViewer.e3(M(), "LXSectionsViewer");
            }
            if (itemId == R.id.f799action_gallery) {
                Y4("soheilvb");
            }
            return super.e1(menuItem);
        }

        public void e3(Menu menu) {
            this.f5 = menu.findItem(R.id.f817action_sound);
            U4();
        }

        public void m1(Bundle bundle) {
            super.m1(bundle);
        }

        public boolean v4() {
            if (this.g5 != 0) {
                return false;
            }
            return super.v4();
        }

        public boolean y4(WebView webView, String str, String str2, String str3) {
            String substring;
            Bundle bundle;
            String str4;
            String str5;
            iMDLogger.j("Override", "Url : " + str + ", Scheme : " + str2 + ", Resource : " + str3);
            CompressHelper compressHelper = new CompressHelper(r());
            if (str2.equals("image")) {
                Y4(str3);
                return true;
            }
            if (str2.equals("index")) {
                Bundle bundle2 = new Bundle();
                bundle2.putBundle("DB", this.D4);
                Bundle bundle3 = this.D4;
                Bundle s1 = compressHelper.s1(compressHelper.V(bundle3, "select * from indexitem where id=" + str3));
                if (s1 == null) {
                    CompressHelper.x2(r(), "There is nothing there . sorry . please report it to support@imedicaldoctor.net", 1);
                    return true;
                }
                bundle2.putString("ParentId", s1.getString("id"));
                bundle2.putInt("Mode", 2);
                compressHelper.N(LXItems.class, LXItems.LXItemsFragment.class, bundle2);
            } else if (str2.equals("urn")) {
                String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(str3, ":");
                if (splitByWholeSeparator[0].equals("lexicalc")) {
                    ArrayList arrayList = new ArrayList(Collections2.d(((iMD) r().getApplicationContext()).s, new Predicate<Bundle>("Lexi-CALC") {
                        /* renamed from: a */
                        public boolean apply(Bundle bundle) {
                            return bundle.getString("Title").equals("Lexi-CALC");
                        }
                    }));
                    if (arrayList.size() == 0) {
                        FragmentActivity r = r();
                        CompressHelper.x2(r, "You Must Install " + "Lexi-CALC", 1);
                        return true;
                    }
                    Bundle bundle4 = (Bundle) arrayList.get(0);
                    bundle = this.D4;
                    substring = splitByWholeSeparator[1];
                } else if (splitByWholeSeparator[0].equals("lims")) {
                    if (splitByWholeSeparator[1].charAt(0) == 's') {
                        compressHelper.A1(this.D4, splitByWholeSeparator[1].substring(1), (String[]) null, (String) null);
                        return true;
                    } else if (splitByWholeSeparator[1].charAt(0) == 'b') {
                        final String substring2 = splitByWholeSeparator[1].substring(1);
                        substring = splitByWholeSeparator[2].substring(1);
                        if (!this.D4.getString("Name").equals("429_martindale_f.sqlite") || !substring2.equals("429")) {
                            ArrayList arrayList2 = new ArrayList(Collections2.d(((iMD) r().getApplicationContext()).s, new Predicate<Bundle>() {
                                /* renamed from: a */
                                public boolean apply(Bundle bundle) {
                                    if (bundle.containsKey("lexiID")) {
                                        return bundle.getString("lexiID").equals(substring2);
                                    }
                                    return false;
                                }
                            }));
                            if (arrayList2.size() == 0) {
                                FragmentActivity r2 = r();
                                CompressHelper.x2(r2, "You Must Install Database with id " + substring2, 1);
                                return true;
                            }
                            bundle = (Bundle) arrayList2.get(0);
                        } else {
                            try {
                                str4 = URLDecoder.decode(substring, "UTF-8");
                            } catch (Exception unused) {
                                str4 = substring;
                            }
                            if (str4.contains("#")) {
                                str5 = StringUtils.splitByWholeSeparator(str4, "#")[1];
                                str4 = StringUtils.splitByWholeSeparator(str4, "#")[0];
                            } else {
                                str5 = "";
                            }
                            if (this.E4.equals(str4)) {
                                iMDWebView imdwebview = this.G4;
                                imdwebview.g("document.getElementById('" + str5 + "').scrollIntoView(true);");
                                iMDWebView imdwebview2 = this.G4;
                                imdwebview2.g("element=document.getElementById('" + str5 + "');element.parentNode.removeChild(element);");
                            } else {
                                compressHelper.A1(this.D4, substring, (String[]) null, str5);
                            }
                            return true;
                        }
                    }
                }
                compressHelper.A1(bundle, substring, (String[]) null, (String) null);
            } else if (str2.equals("ivcpair")) {
                ArrayList<Bundle> V = compressHelper.V(this.D4, "select vf.sequence as sequence, vf.label as label, f.content as content, vf.fieldtype_id as typeId from document d join chapter c on c.id = d.chapter_id join view v on v.id = c.view_id join viewfield vf on vf.view_id = v.id left join field f on f.document_id = d.id and vf.fieldtype_id = f.fieldtype_id left join fieldtypesite s on vf.fieldtype_id = s.fieldtype_id left join ivsolution l on d.id = l.document_id and vf.fieldtype_id = l.fieldtype_id where d.id =" + str3 + " and (f.content is not null or l.solution_id is not null) and f.fieldtype_id != 38 and f.fieldtype_id != 42 union select vf.sequence, vf.label, iv.content, vf.fieldtype_id from document d join chapter c on c.id = d.chapter_id join view v on v.id = c.view_id join viewfield vf on vf.view_id = v.id left join ivfield iv on iv.document_id = d.id and vf.fieldtype_id = iv.fieldtype_id left join fieldtypesite s on vf.fieldtype_id = s.fieldtype_id left join ivsolution l on d.id = l.document_id and vf.fieldtype_id = l.fieldtype_id where d.id =" + str3 + " and (iv.content is not null or l.solution_id is not null) and iv.fieldtype_id != 38 and iv.fieldtype_id != 42");
                Bundle bundle5 = new Bundle();
                bundle5.putParcelableArrayList("ivMonograph", V);
                bundle5.putParcelableArrayList("Solutions", y().getParcelableArrayList("Solutions"));
                bundle5.putParcelableArrayList("Sites", y().getParcelableArrayList("Sites"));
                bundle5.putInt("Mode", 3);
                if (y().containsKey(HttpHeaders.f22879g)) {
                    bundle5.putString(HttpHeaders.f22879g, y().getString(HttpHeaders.f22879g));
                }
                bundle5.putString("docId", str3);
                Bundle bundle6 = this.D4;
                compressHelper.B1(bundle6, "Pair - " + str3, (String[]) null, (String) null, bundle5);
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.f1175activity_general_viewer);
        Y0(new LXViewerFragment(), bundle);
    }
}
