package net.imedicaldoctor.imd.Fragments.Uptodate;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import androidx.exifinterface.media.ExifInterface;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.itextpdf.tool.xml.html.HTML;
import fi.iki.elonen.NanoHTTPD;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.UWorld.h;
import net.imedicaldoctor.imd.Fragments.ViewerHelperActivity;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.GeneralDialogFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Utils.iMDWebView;
import net.imedicaldoctor.imd.iMDLogger;
import okio.BufferedSink;
import okio.Okio;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class UTDViewerActivity extends ViewerHelperActivity {

    public static class UTDViewerFragment extends ViewerHelperFragment {
        private GeneralDialogFragment X4;
        /* access modifiers changed from: private */
        public String Y4;
        /* access modifiers changed from: private */
        public String Z4 = null;
        /* access modifiers changed from: private */
        public String a5 = null;
        /* access modifiers changed from: private */
        public String b5 = null;
        /* access modifiers changed from: private */
        public String c5;
        /* access modifiers changed from: private */
        public String d5;
        /* access modifiers changed from: private */
        public String e5;
        /* access modifiers changed from: private */
        public String f5;

        public void A3(int i2) {
            if (this.H4.length() > 0) {
                try {
                    iMDWebView imdwebview = this.G4;
                    imdwebview.g("setHighlightClass(\"" + this.H4.getString(this.n4) + "\")");
                    iMDWebView imdwebview2 = this.G4;
                    imdwebview2.g("var obj = document.getElementById(\"" + this.H4.getString(i2) + "\");obj.className = \"highlightedCurrent\";obj.scrollIntoView(true);");
                    this.n4 = i2;
                } catch (Exception e2) {
                    FirebaseCrashlytics.d().g(e2);
                }
            }
            U2();
        }

        public String R2() {
            JSONArray jSONArray;
            CompressHelper compressHelper;
            Bundle bundle;
            String str;
            String str2;
            String g1;
            FileOutputStream fileOutputStream;
            BufferedSink d2;
            if (this.b5 == null) {
                return null;
            }
            try {
                jSONArray = new JSONArray(this.b5);
            } catch (Exception e2) {
                FirebaseCrashlytics.d().g(e2);
                jSONArray = null;
            }
            if (jSONArray == null || jSONArray.length() == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    JSONArray jSONArray2 = jSONArray.getJSONObject(i2).getJSONArray("graphics");
                    for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                        JSONObject jSONObject = jSONArray2.getJSONObject(i3);
                        jSONObject.getJSONObject("graphicInfo").getString("displayName");
                        arrayList.add(jSONObject.getJSONObject("graphicInfo").getString("id"));
                    }
                } catch (Exception e3) {
                    FirebaseCrashlytics.d().g(e3);
                }
            }
            Random random = new Random();
            int i4 = 0;
            while (true) {
                int nextInt = random.nextInt(arrayList.size());
                if (i4 > arrayList.size() - 1) {
                    return null;
                }
                i4++;
                String str3 = (String) arrayList.get(nextInt);
                if (this.D4.getString("Name").equals("utdadvanced")) {
                    compressHelper = this.Q4;
                    bundle = this.D4;
                    str = "select * from graphic_asset where id =" + str3;
                    str2 = "lab.db";
                } else {
                    compressHelper = this.Q4;
                    bundle = this.D4;
                    str = "select * from graphic_asset where id =" + str3;
                    str2 = "utdasset.sqlite";
                }
                Bundle s1 = compressHelper.s1(compressHelper.W(bundle, str, str2));
                if (s1 != null) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(new String(this.Q4.v(s1.getString("payload"), s1.getString("id"), "127")));
                        if (jSONObject2.has("base64Image")) {
                            String string = jSONObject2.getString("base64Image");
                            g1 = CompressHelper.g1(this.D4, "background.png");
                            File file = new File(g1);
                            if (file.exists() && !file.delete()) {
                                iMDLogger.f("ImagePathForToolbar", "Not Deleted");
                            }
                            try {
                                fileOutputStream = new FileOutputStream(file);
                                d2 = Okio.d(Okio.p(fileOutputStream));
                                d2.write(Base64.decode(string, 0));
                                d2.flush();
                                d2.close();
                                fileOutputStream.close();
                                break;
                            } catch (IOException e4) {
                                e4.printStackTrace();
                                break;
                            } catch (Throwable th) {
                                th.addSuppressed(th);
                                break;
                            }
                        } else {
                            continue;
                        }
                    } catch (Exception e6) {
                        FirebaseCrashlytics.d().g(e6);
                    }
                }
            }
            throw th;
            throw th;
            return g1;
        }

        public void R4(String str) {
            JSONArray jSONArray;
            ArrayList arrayList = new ArrayList();
            try {
                jSONArray = new JSONArray(this.b5);
            } catch (Exception e2) {
                FirebaseCrashlytics.d().g(e2);
                jSONArray = null;
            }
            if (jSONArray != null && jSONArray.length() != 0) {
                new ArrayList();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    try {
                        JSONArray jSONArray2 = jSONArray.getJSONObject(i2).getJSONArray("graphics");
                        for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                            arrayList.add(jSONArray2.getJSONObject(i3).getJSONObject("graphicInfo").getString("id"));
                        }
                    } catch (Exception e3) {
                        FirebaseCrashlytics.d().g(e3);
                    }
                }
                this.Q4.A1(this.D4, "Graphic-" + str + "-" + h.a(",", arrayList) + "-" + arrayList.indexOf(str), (String[]) null, (String) null);
            }
        }

        public void S4(String str) {
            CompressHelper compressHelper = this.Q4;
            Bundle bundle = this.D4;
            compressHelper.A1(bundle, "Topic-" + str, (String[]) null, (String) null);
        }

        public void T0(Menu menu, MenuInflater menuInflater) {
            menuInflater.inflate(R.menu.f1485menu_utdviewer, menu);
            q4(menu);
            MenuItem findItem = menu.findItem(R.id.f809action_relatedTopics);
            MenuItem findItem2 = menu.findItem(R.id.f808action_relatedGraphics);
            MenuItem findItem3 = menu.findItem(R.id.f807action_relatedCalcs);
            MenuItem findItem4 = menu.findItem(R.id.f801action_menu);
            MenuItem findItem5 = menu.findItem(R.id.f806action_references);
            if (this.Z4 == null) {
                findItem.setVisible(false);
            }
            if (this.b5 == null) {
                findItem2.setVisible(false);
            }
            if (this.a5 == null) {
                findItem3.setVisible(false);
            }
            if (this.Y4 == null) {
                findItem4.setVisible(false);
            }
            if (this.c5 == null) {
                findItem5.setVisible(false);
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(2:15|16) */
        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r11 = r3.getJSONArray("data").getJSONObject(0).getString("id");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
            r0 = r3.getJSONArray("data").getJSONObject(0).getString(com.itextpdf.tool.xml.html.HTML.Tag.V);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0138, code lost:
            r0 = null;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x012b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void T4(java.lang.String r11) {
            /*
                r10 = this;
                java.lang.String r0 = "section"
                java.lang.String r1 = ""
                java.lang.String r2 = "meta"
                r3 = 21
                java.lang.String r11 = r11.substring(r3)
                java.lang.String r11 = android.net.Uri.decode(r11)
                org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x004a }
                r3.<init>(r11)     // Catch:{ Exception -> 0x004a }
                org.json.JSONObject r11 = r3.getJSONObject(r2)     // Catch:{ Exception -> 0x004a }
                java.lang.String r4 = "assetType"
                java.lang.String r11 = r11.getString(r4)     // Catch:{ Exception -> 0x004a }
                java.lang.String r4 = "graphic"
                boolean r11 = r11.equals(r4)     // Catch:{ Exception -> 0x004a }
                java.lang.String r4 = "id"
                java.lang.String r5 = "data"
                r6 = 0
                r7 = 0
                if (r11 == 0) goto L_0x006d
                org.json.JSONArray r11 = r3.getJSONArray(r5)     // Catch:{ Exception -> 0x004a }
                java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x004a }
                r0.<init>()     // Catch:{ Exception -> 0x004a }
            L_0x0036:
                int r1 = r11.length()     // Catch:{ Exception -> 0x004a }
                if (r7 >= r1) goto L_0x004d
                org.json.JSONObject r1 = r11.getJSONObject(r7)     // Catch:{ Exception -> 0x004a }
                java.lang.String r1 = r1.getString(r4)     // Catch:{ Exception -> 0x004a }
                r0.add(r1)     // Catch:{ Exception -> 0x004a }
                int r7 = r7 + 1
                goto L_0x0036
            L_0x004a:
                r11 = move-exception
                goto L_0x016f
            L_0x004d:
                net.imedicaldoctor.imd.Data.CompressHelper r11 = r10.Q4     // Catch:{ Exception -> 0x004a }
                android.os.Bundle r1 = r10.D4     // Catch:{ Exception -> 0x004a }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004a }
                r2.<init>()     // Catch:{ Exception -> 0x004a }
                java.lang.String r3 = "Graphic-"
                r2.append(r3)     // Catch:{ Exception -> 0x004a }
                java.lang.String r3 = ",,,,"
                java.lang.String r0 = android.text.TextUtils.join(r3, r0)     // Catch:{ Exception -> 0x004a }
                r2.append(r0)     // Catch:{ Exception -> 0x004a }
                java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x004a }
                r11.A1(r1, r0, r6, r6)     // Catch:{ Exception -> 0x004a }
                goto L_0x017f
            L_0x006d:
                org.json.JSONObject r11 = r3.getJSONObject(r2)     // Catch:{ Exception -> 0x0078 }
                java.lang.String r8 = "topicId"
                java.lang.String r11 = r11.getString(r8)     // Catch:{ Exception -> 0x0078 }
                goto L_0x0084
            L_0x0078:
                org.json.JSONArray r11 = r3.getJSONArray(r5)     // Catch:{ Exception -> 0x004a }
                org.json.JSONObject r11 = r11.getJSONObject(r7)     // Catch:{ Exception -> 0x004a }
                java.lang.String r11 = r11.getString(r4)     // Catch:{ Exception -> 0x004a }
            L_0x0084:
                org.json.JSONArray r8 = r3.getJSONArray(r5)     // Catch:{ Exception -> 0x0093 }
                org.json.JSONObject r8 = r8.getJSONObject(r7)     // Catch:{ Exception -> 0x0093 }
                java.lang.String r9 = "subtype"
                java.lang.String r8 = r8.getString(r9)     // Catch:{ Exception -> 0x0093 }
                goto L_0x0094
            L_0x0093:
                r8 = r1
            L_0x0094:
                java.lang.String r9 = "narrative_icg"
                boolean r8 = r8.equals(r9)     // Catch:{ Exception -> 0x004a }
                if (r8 == 0) goto L_0x0122
                java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x004a }
                androidx.fragment.app.FragmentActivity r2 = r10.r()     // Catch:{ Exception -> 0x004a }
                android.content.Context r2 = r2.getApplicationContext()     // Catch:{ Exception -> 0x004a }
                net.imedicaldoctor.imd.iMD r2 = (net.imedicaldoctor.imd.iMD) r2     // Catch:{ Exception -> 0x004a }
                java.util.ArrayList<android.os.Bundle> r2 = r2.s     // Catch:{ Exception -> 0x004a }
                net.imedicaldoctor.imd.Fragments.Uptodate.UTDViewerActivity$UTDViewerFragment$8 r3 = new net.imedicaldoctor.imd.Fragments.Uptodate.UTDViewerActivity$UTDViewerFragment$8     // Catch:{ Exception -> 0x004a }
                r3.<init>()     // Catch:{ Exception -> 0x004a }
                java.util.Collection r2 = com.google.common.collect.Collections2.d(r2, r3)     // Catch:{ Exception -> 0x004a }
                r0.<init>(r2)     // Catch:{ Exception -> 0x004a }
                int r2 = r0.size()     // Catch:{ Exception -> 0x004a }
                r3 = 1
                if (r2 != 0) goto L_0x00c7
                androidx.fragment.app.FragmentActivity r11 = r10.r()     // Catch:{ Exception -> 0x004a }
                java.lang.String r0 = "You must install Uptodate Pathways Database"
                net.imedicaldoctor.imd.Data.CompressHelper.x2(r11, r0, r3)     // Catch:{ Exception -> 0x004a }
                return
            L_0x00c7:
                java.lang.Object r0 = r0.get(r7)     // Catch:{ Exception -> 0x004a }
                android.os.Bundle r0 = (android.os.Bundle) r0     // Catch:{ Exception -> 0x004a }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004a }
                r2.<init>()     // Catch:{ Exception -> 0x004a }
                java.lang.String r5 = "base/"
                r2.append(r5)     // Catch:{ Exception -> 0x004a }
                r2.append(r11)     // Catch:{ Exception -> 0x004a }
                java.lang.String r11 = ".html"
                r2.append(r11)     // Catch:{ Exception -> 0x004a }
                java.lang.String r11 = r2.toString()     // Catch:{ Exception -> 0x004a }
                net.imedicaldoctor.imd.Data.CompressHelper r2 = r10.Q4     // Catch:{ Exception -> 0x004a }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004a }
                r5.<init>()     // Catch:{ Exception -> 0x004a }
                java.lang.String r8 = "Select * from docs where path = '"
                r5.append(r8)     // Catch:{ Exception -> 0x004a }
                r5.append(r11)     // Catch:{ Exception -> 0x004a }
                java.lang.String r11 = "'"
                r5.append(r11)     // Catch:{ Exception -> 0x004a }
                java.lang.String r11 = r5.toString()     // Catch:{ Exception -> 0x004a }
                java.util.ArrayList r11 = r2.V(r0, r11)     // Catch:{ Exception -> 0x004a }
                if (r11 == 0) goto L_0x0118
                int r2 = r11.size()     // Catch:{ Exception -> 0x004a }
                if (r2 != 0) goto L_0x0108
                goto L_0x0118
            L_0x0108:
                java.lang.Object r11 = r11.get(r7)     // Catch:{ Exception -> 0x004a }
                android.os.Bundle r11 = (android.os.Bundle) r11     // Catch:{ Exception -> 0x004a }
                net.imedicaldoctor.imd.Data.CompressHelper r2 = r10.Q4     // Catch:{ Exception -> 0x004a }
                java.lang.String r11 = r11.getString(r4)     // Catch:{ Exception -> 0x004a }
                r2.A1(r0, r11, r6, r1)     // Catch:{ Exception -> 0x004a }
                goto L_0x017f
            L_0x0118:
                androidx.fragment.app.FragmentActivity r11 = r10.r()     // Catch:{ Exception -> 0x004a }
                java.lang.String r0 = "Sorry, Document not available"
                net.imedicaldoctor.imd.Data.CompressHelper.x2(r11, r0, r3)     // Catch:{ Exception -> 0x004a }
                goto L_0x017f
            L_0x0122:
                org.json.JSONObject r1 = r3.getJSONObject(r2)     // Catch:{ Exception -> 0x012b }
                java.lang.String r0 = r1.getString(r0)     // Catch:{ Exception -> 0x012b }
                goto L_0x0139
            L_0x012b:
                org.json.JSONArray r1 = r3.getJSONArray(r5)     // Catch:{ Exception -> 0x0138 }
                org.json.JSONObject r1 = r1.getJSONObject(r7)     // Catch:{ Exception -> 0x0138 }
                java.lang.String r0 = r1.getString(r0)     // Catch:{ Exception -> 0x0138 }
                goto L_0x0139
            L_0x0138:
                r0 = r6
            L_0x0139:
                java.lang.String r1 = r10.f5     // Catch:{ Exception -> 0x004a }
                boolean r1 = r1.equals(r11)     // Catch:{ Exception -> 0x004a }
                if (r1 == 0) goto L_0x0145
                r10.C3(r0)     // Catch:{ Exception -> 0x004a }
                goto L_0x017f
            L_0x0145:
                java.lang.String r1 = "Activity Type"
                androidx.fragment.app.FragmentActivity r2 = r10.r()     // Catch:{ Exception -> 0x004a }
                java.lang.Class r2 = r2.getClass()     // Catch:{ Exception -> 0x004a }
                java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x004a }
                net.imedicaldoctor.imd.iMDLogger.j(r1, r2)     // Catch:{ Exception -> 0x004a }
                net.imedicaldoctor.imd.Data.CompressHelper r1 = r10.Q4     // Catch:{ Exception -> 0x004a }
                android.os.Bundle r2 = r10.D4     // Catch:{ Exception -> 0x004a }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004a }
                r3.<init>()     // Catch:{ Exception -> 0x004a }
                java.lang.String r4 = "Topic-"
                r3.append(r4)     // Catch:{ Exception -> 0x004a }
                r3.append(r11)     // Catch:{ Exception -> 0x004a }
                java.lang.String r11 = r3.toString()     // Catch:{ Exception -> 0x004a }
                r1.A1(r2, r11, r6, r0)     // Catch:{ Exception -> 0x004a }
                goto L_0x017f
            L_0x016f:
                com.google.firebase.crashlytics.FirebaseCrashlytics r0 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()
                r0.g(r11)
                java.lang.String r0 = "ViewerActivity , onMenuURLClicked"
                java.lang.String r11 = r11.toString()
                net.imedicaldoctor.imd.iMDLogger.f(r0, r11)
            L_0x017f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.Uptodate.UTDViewerActivity.UTDViewerFragment.T4(java.lang.String):void");
        }

        public View onFragmentBind(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View view = this.C4;
            if (view != null) {
                return view;
            }
            View inflate = layoutInflater.inflate(R.layout.f1255fragment_new_viewer, viewGroup, false);
            r4(inflate, bundle);
            if (y() == null) {
                return inflate;
            }
            if (bundle != null) {
                this.e5 = bundle.getString("mLastMajorUpdates");
                this.d5 = bundle.getString("mContributers");
                this.b5 = bundle.getString("mRelatedGraphics");
                this.a5 = bundle.getString("mRelatedCalcs");
                this.Z4 = bundle.getString("mRelatedTopics");
                this.c5 = bundle.getString("mReferences");
                this.Y4 = bundle.getString("mMenuHTML");
            }
            this.f5 = this.E4.split("-")[1];
            T2(new Runnable() {
                public void run() {
                    String str;
                    Bundle bundle;
                    try {
                        String str2 = UTDViewerFragment.this.A4;
                        if (str2 != null) {
                            if (str2.length() != 0) {
                                return;
                            }
                        }
                        if (UTDViewerFragment.this.D4.getString("Name").equals("uptodateonline")) {
                            try {
                                str = UTDViewerFragment.this.Q4.p1(UTDViewerFragment.this.Q4.getBaseUrl() + "/utdonline/topic/" + UTDViewerFragment.this.f5 + ".txt", "topic-" + UTDViewerFragment.this.f5 + UTDViewerFragment.this.D4.getString("Version"));
                            } catch (Exception unused) {
                                str = null;
                            }
                            if (str == null) {
                                UTDViewerFragment.this.p4 = "Error in retrieving data from server";
                                return;
                            }
                        } else if (!new File(CompressHelper.g1(UTDViewerFragment.this.D4, "utdasset.sqlite")).exists()) {
                            UTDViewerFragment.this.p4 = IcyHeaders.a3;
                            return;
                        } else {
                            UTDViewerFragment uTDViewerFragment = UTDViewerFragment.this;
                            String unused2 = uTDViewerFragment.f5 = uTDViewerFragment.f5.replace(StringUtils.SPACE, "");
                            if (UTDViewerFragment.this.D4.getString("Name").equals("utdadvanced")) {
                                UTDViewerFragment uTDViewerFragment2 = UTDViewerFragment.this;
                                bundle = uTDViewerFragment2.Q4.f0(uTDViewerFragment2.D4, "select * from topic_asset where id = " + UTDViewerFragment.this.f5, "lab.db");
                            } else {
                                UTDViewerFragment uTDViewerFragment3 = UTDViewerFragment.this;
                                bundle = uTDViewerFragment3.Q4.f0(uTDViewerFragment3.D4, "select * from topic_asset where id = " + UTDViewerFragment.this.f5, "utdasset.sqlite");
                            }
                            if (bundle == null) {
                                UTDViewerFragment.this.p4 = ExifInterface.Y4;
                                return;
                            }
                            str = bundle.getString("payload");
                        }
                        UTDViewerFragment uTDViewerFragment4 = UTDViewerFragment.this;
                        JSONObject jSONObject = new JSONObject(new String(uTDViewerFragment4.Q4.v(str, uTDViewerFragment4.f5, "127")));
                        if (jSONObject.has("outlineHtml")) {
                            String unused3 = UTDViewerFragment.this.Y4 = jSONObject.getString("outlineHtml");
                        }
                        if (jSONObject.has("referenceHtml")) {
                            String unused4 = UTDViewerFragment.this.c5 = jSONObject.getString("referenceHtml");
                        }
                        String string = jSONObject.getString("bodyHtml");
                        if (jSONObject.has("relatedTopics")) {
                            String unused5 = UTDViewerFragment.this.Z4 = jSONObject.getJSONObject("relatedTopics").getString("topics");
                        }
                        if (jSONObject.has("relatedCalculators")) {
                            String unused6 = UTDViewerFragment.this.a5 = jSONObject.getJSONObject("relatedCalculators").getString("topics");
                        }
                        if (jSONObject.has("relatedGraphics")) {
                            String unused7 = UTDViewerFragment.this.b5 = jSONObject.getString("relatedGraphics");
                        }
                        if (jSONObject.has("contributors")) {
                            String unused8 = UTDViewerFragment.this.d5 = jSONObject.getString("contributors");
                        }
                        String unused9 = UTDViewerFragment.this.e5 = jSONObject.getJSONObject("topicInfo").getString("lastMajorUpdateMs");
                        UTDViewerFragment.this.F4 = jSONObject.getJSONObject("topicInfo").getString("title");
                        UTDViewerFragment uTDViewerFragment5 = UTDViewerFragment.this;
                        String d4 = uTDViewerFragment5.d4(uTDViewerFragment5.r(), "UTDHeader.css");
                        UTDViewerFragment uTDViewerFragment6 = UTDViewerFragment.this;
                        String replace = uTDViewerFragment6.d4(uTDViewerFragment6.r(), "UTDFooter.css").replace("[year]", new SimpleDateFormat("yyyy").format(new Date()));
                        String replace2 = d4.replace("[Title]", UTDViewerFragment.this.F4).replace("[size]", "200");
                        UTDViewerFragment.this.A4 = replace2 + string + replace;
                    } catch (Exception e2) {
                        FirebaseCrashlytics.d().g(e2);
                        e2.printStackTrace();
                        UTDViewerFragment.this.p4 = e2.getLocalizedMessage();
                    }
                }
            }, new Runnable() {
                public void run() {
                    AlertDialog.Builder s2;
                    DialogInterface.OnClickListener r2;
                    String str = UTDViewerFragment.this.p4;
                    if (str == null || str.length() <= 0) {
                        boolean x1 = UTDViewerFragment.this.Q4.x1();
                        UTDViewerFragment.this.m4("Topic");
                        new File(CompressHelper.g1(UTDViewerFragment.this.D4, "base"));
                        UTDViewerFragment uTDViewerFragment = UTDViewerFragment.this;
                        uTDViewerFragment.G4.loadDataWithBaseURL("file:///android_asset/", uTDViewerFragment.A4, NanoHTTPD.p, "utf-8", (String) null);
                        UTDViewerFragment.this.s4();
                        UTDViewerFragment.this.p4();
                        UTDViewerFragment.this.f3(R.menu.f1485menu_utdviewer);
                        UTDViewerFragment.this.o2(false);
                        UTDViewerFragment.this.G3();
                        return;
                    }
                    if (UTDViewerFragment.this.p4.equals(IcyHeaders.a3)) {
                        s2 = new AlertDialog.Builder(UTDViewerFragment.this.r(), R.style.f2185alertDialogTheme).l("The database is corrupt . it may happen after delta update or as a result of bad installation or a cleaner app in your device . you must delete and redownload this database. what do you want to do ?").p("Delete", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                new AlertDialog.Builder(UTDViewerFragment.this.r(), R.style.f2185alertDialogTheme).l("Are you sure ? this will delete uptodate database ...").y("Yes", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogInterface, int i2) {
                                        UTDViewerFragment.this.Q2(new File(UTDViewerFragment.this.D4.getString("Path")));
                                        LocalBroadcastManager.b(UTDViewerFragment.this.r()).d(new Intent("reload"));
                                        UTDViewerFragment.this.Q4.Z1(false);
                                        UTDViewerFragment.this.Q4.Z1(true);
                                    }
                                }).p("No", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogInterface, int i2) {
                                    }
                                }).I();
                            }
                        }).s("More Info", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                UTDViewerFragment.this.a4("http://imedicaldoctor.net/faq#null");
                                UTDViewerFragment.this.Q4.W1(false);
                            }
                        });
                        r2 = new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i2) {
                            }
                        };
                    } else if (UTDViewerFragment.this.p4.equals(ExifInterface.Y4)) {
                        s2 = new AlertDialog.Builder(UTDViewerFragment.this.r(), R.style.f2185alertDialogTheme).l("Document can't be found . if this happens a lot your database is corrupted. what do you want to do ?").p("Delete", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                new AlertDialog.Builder(UTDViewerFragment.this.r(), R.style.f2185alertDialogTheme).l("Are you sure ? this will delete uptodate database ...").y("Yes", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogInterface, int i2) {
                                        UTDViewerFragment.this.Q2(new File(UTDViewerFragment.this.D4.getString("Path")));
                                        LocalBroadcastManager.b(UTDViewerFragment.this.r()).d(new Intent("reload"));
                                        UTDViewerFragment.this.Q4.Z1(true);
                                        UTDViewerFragment.this.Q4.Z1(false);
                                    }
                                }).p("No", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogInterface, int i2) {
                                    }
                                }).I();
                            }
                        }).s("More Info", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                UTDViewerFragment.this.a4("http://imedicaldoctor.net/faq#null");
                                UTDViewerFragment.this.Q4.W1(false);
                            }
                        });
                        r2 = new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                UTDViewerFragment.this.Q4.W1(false);
                            }
                        };
                    } else {
                        UTDViewerFragment uTDViewerFragment2 = UTDViewerFragment.this;
                        uTDViewerFragment2.C4(uTDViewerFragment2.p4);
                        return;
                    }
                    s2.y("OK", r2).I();
                }
            });
            return inflate;
        }

        public void U4() {
            if (this.d5 != null) {
                try {
                    JSONArray jSONArray = new JSONArray(this.d5);
                    String str = "";
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i2);
                        ArrayList arrayList = new ArrayList();
                        for (int i3 = 0; i3 < jSONObject.getJSONArray("contributorList").length(); i3++) {
                            ArrayList arrayList2 = new ArrayList();
                            JSONObject jSONObject2 = jSONObject.getJSONArray("contributorList").getJSONObject(i3);
                            for (int i4 = 0; i4 < jSONObject2.getJSONArray("associations").length(); i4++) {
                                arrayList2.add(jSONObject2.getJSONArray("associations").getString(i4));
                            }
                            arrayList.add("<i>" + jSONObject2.getString("name") + "</i><br>" + TextUtils.join("<br>", arrayList2));
                        }
                        String str2 = "<b>" + jSONObject.getString("headingTitle") + "</b><br>" + TextUtils.join(StringUtils.LF, arrayList);
                        if (str.length() == 0) {
                            str = str2;
                        } else {
                            str = str + "<br>" + str2;
                        }
                    }
                    new AlertDialog.Builder(r(), R.style.f2185alertDialogTheme).l(Html.fromHtml(str)).y("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    }).I();
                } catch (Exception e2) {
                    FirebaseCrashlytics.d().g(e2);
                }
            }
        }

        public void V4() {
            if (this.d5 != null) {
                try {
                    JSONArray jSONArray = new JSONArray(this.d5);
                    String str = "";
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i2);
                        ArrayList arrayList = new ArrayList();
                        for (int i3 = 0; i3 < jSONObject.getJSONArray("contributorList").length(); i3++) {
                            JSONObject jSONObject2 = jSONObject.getJSONArray("contributorList").getJSONObject(i3);
                            arrayList.add("<b>" + jSONObject2.getString("name") + "</b><br>" + jSONObject2.getString("disclosure"));
                        }
                        String join = TextUtils.join("<br>", arrayList);
                        if (str.length() == 0) {
                            str = join;
                        } else {
                            str = str + "<br>" + join;
                        }
                    }
                    new AlertDialog.Builder(r(), R.style.f2185alertDialogTheme).l(Html.fromHtml(str)).y("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    }).I();
                } catch (Exception e2) {
                    FirebaseCrashlytics.d().g(e2);
                }
            }
        }

        public boolean e1(MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            if (itemId == R.id.f801action_menu) {
                UTDMenuFragment uTDMenuFragment = new UTDMenuFragment();
                Bundle bundle = new Bundle();
                bundle.putString(HTML.Tag.y, this.Y4);
                bundle.putString("title", this.F4);
                uTDMenuFragment.i2(bundle);
                uTDMenuFragment.A2(this, 0);
                uTDMenuFragment.e3(M(), HTML.Tag.w0);
                return true;
            } else if (itemId == R.id.f806action_references) {
                UTDMenuFragment uTDMenuFragment2 = new UTDMenuFragment();
                Bundle bundle2 = new Bundle();
                bundle2.putString(HTML.Tag.y, this.c5);
                bundle2.putString("title", this.F4);
                uTDMenuFragment2.i2(bundle2);
                uTDMenuFragment2.A2(this, 0);
                uTDMenuFragment2.e3(M(), "references");
                return true;
            } else if (itemId == R.id.f809action_relatedTopics) {
                UTDRelatedTopicsFragment uTDRelatedTopicsFragment = new UTDRelatedTopicsFragment();
                Bundle bundle3 = new Bundle();
                bundle3.putString("RELATED", this.Z4);
                uTDRelatedTopicsFragment.i2(bundle3);
                uTDRelatedTopicsFragment.A2(this, 0);
                uTDRelatedTopicsFragment.e3(M(), "related");
                return true;
            } else if (itemId == R.id.f807action_relatedCalcs) {
                UTDRelatedTopicsFragment uTDRelatedTopicsFragment2 = new UTDRelatedTopicsFragment();
                Bundle bundle4 = new Bundle();
                bundle4.putString("RELATED", this.a5);
                bundle4.putString("CALC", "");
                uTDRelatedTopicsFragment2.i2(bundle4);
                uTDRelatedTopicsFragment2.A2(this, 0);
                uTDRelatedTopicsFragment2.e3(M(), "relatedcalc");
                return true;
            } else if (itemId != R.id.f808action_relatedGraphics) {
                return super.e1(menuItem);
            } else {
                UTDRelatedGraphicsFragment uTDRelatedGraphicsFragment = new UTDRelatedGraphicsFragment();
                Bundle bundle5 = new Bundle();
                bundle5.putString("RELATED", this.b5);
                uTDRelatedGraphicsFragment.i2(bundle5);
                uTDRelatedGraphicsFragment.A2(this, 0);
                uTDRelatedGraphicsFragment.e3(M(), "related");
                return true;
            }
        }

        public void e3(Menu menu) {
            MenuItem findItem = menu.findItem(R.id.f809action_relatedTopics);
            MenuItem findItem2 = menu.findItem(R.id.f808action_relatedGraphics);
            MenuItem findItem3 = menu.findItem(R.id.f807action_relatedCalcs);
            MenuItem findItem4 = menu.findItem(R.id.f801action_menu);
            MenuItem findItem5 = menu.findItem(R.id.f806action_references);
            if (this.Z4 == null) {
                findItem.setVisible(false);
            }
            if (this.b5 == null) {
                findItem2.setVisible(false);
            }
            if (this.a5 == null) {
                findItem3.setVisible(false);
            }
            if (this.Y4 == null) {
                findItem4.setVisible(false);
            }
            if (this.c5 == null) {
                findItem5.setVisible(false);
            }
        }

        public void m1(Bundle bundle) {
            super.m1(bundle);
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(2:24|25) */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            r10 = r11.getJSONArray("data").getJSONObject(0).getString("type");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
            r10 = r11.getJSONArray("data").getJSONObject(0).getString("id");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
            r9 = r11.getJSONArray("data").getJSONObject(0).getString(com.itextpdf.tool.xml.html.HTML.Tag.V);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x01ed, code lost:
            r9 = null;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x00c4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:40:0x012c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x01e0 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean y4(android.webkit.WebView r9, java.lang.String r10, java.lang.String r11, java.lang.String r12) {
            /*
                r8 = this;
                java.lang.String r9 = "section"
                java.lang.String r0 = ""
                java.lang.String r1 = "meta"
                java.lang.String r2 = "data"
                java.lang.String r3 = "uptodatewebaction"
                boolean r3 = r11.equals(r3)
                r4 = 1
                r5 = 0
                if (r3 == 0) goto L_0x009a
                java.lang.String r9 = "//zoomOut"
                boolean r9 = r12.equals(r9)
                if (r9 == 0) goto L_0x001c
                goto L_0x02cd
            L_0x001c:
                java.lang.String r9 = "//zoomIn"
                boolean r9 = r12.equals(r9)
                if (r9 == 0) goto L_0x0026
                goto L_0x02cd
            L_0x0026:
                java.lang.String r9 = "//zoomFinished"
                boolean r9 = r12.equals(r9)
                if (r9 == 0) goto L_0x0030
                goto L_0x02cd
            L_0x0030:
                java.lang.String r9 = "//contributors"
                boolean r9 = r12.equals(r9)
                if (r9 == 0) goto L_0x003d
                r8.U4()
                goto L_0x02cd
            L_0x003d:
                java.lang.String r9 = "//contributorsDisclosure"
                boolean r9 = r12.equals(r9)
                if (r9 == 0) goto L_0x004a
                r8.V4()
                goto L_0x02cd
            L_0x004a:
                java.lang.String r9 = "//lastUpdated"
                boolean r9 = r12.startsWith(r9)
                if (r9 == 0) goto L_0x02cd
                android.os.Bundle r9 = r8.D4
                java.lang.String r10 = "Version"
                java.lang.String r9 = r9.getString(r10)
                java.lang.String r10 = r8.e5
                long r10 = java.lang.Long.parseLong(r10)
                java.util.Date r12 = new java.util.Date
                r12.<init>(r10)
                java.text.SimpleDateFormat r10 = new java.text.SimpleDateFormat
                java.lang.String r11 = "yyyy-MM-dd"
                r10.<init>(r11)
                java.lang.StringBuilder r11 = new java.lang.StringBuilder
                r11.<init>()
                java.lang.String r0 = "All topics are updated as new evidence becomes available and our peer review process is complete. Literature review current through "
                r11.append(r0)
                java.lang.String r0 = " "
                java.lang.String[] r9 = r9.split(r0)
                r9 = r9[r5]
                r11.append(r9)
                java.lang.String r9 = ". This topic was last updated: "
                r11.append(r9)
                java.lang.String r9 = r10.format(r12)
                r11.append(r9)
                java.lang.String r9 = r11.toString()
                androidx.fragment.app.FragmentActivity r10 = r8.r()
                net.imedicaldoctor.imd.Data.CompressHelper.x2(r10, r9, r4)
                goto L_0x02cd
            L_0x009a:
                java.lang.String r12 = "uptodateappaction"
                boolean r11 = r11.equals(r12)
                if (r11 == 0) goto L_0x02cd
                android.net.Uri r10 = android.net.Uri.parse(r10)
                java.lang.String r10 = r10.toString()
                r11 = 21
                java.lang.String r10 = r10.substring(r11)
                java.lang.String r10 = android.net.Uri.decode(r10)
                org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ Exception -> 0x02cd }
                r11.<init>(r10)     // Catch:{ Exception -> 0x02cd }
                org.json.JSONObject r10 = r11.getJSONObject(r1)     // Catch:{ Exception -> 0x00c4 }
                java.lang.String r12 = "assetType"
                java.lang.String r10 = r10.getString(r12)     // Catch:{ Exception -> 0x00c4 }
                goto L_0x00d2
            L_0x00c4:
                org.json.JSONArray r10 = r11.getJSONArray(r2)     // Catch:{ Exception -> 0x02cd }
                org.json.JSONObject r10 = r10.getJSONObject(r5)     // Catch:{ Exception -> 0x02cd }
                java.lang.String r12 = "type"
                java.lang.String r10 = r10.getString(r12)     // Catch:{ Exception -> 0x02cd }
            L_0x00d2:
                java.lang.String r12 = "graphic"
                boolean r12 = r10.equals(r12)     // Catch:{ Exception -> 0x02cd }
                java.lang.String r3 = "id"
                r6 = 0
                if (r12 == 0) goto L_0x0119
                org.json.JSONArray r9 = r11.getJSONArray(r2)     // Catch:{ Exception -> 0x02cd }
                java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ Exception -> 0x02cd }
                r10.<init>()     // Catch:{ Exception -> 0x02cd }
            L_0x00e6:
                int r11 = r9.length()     // Catch:{ Exception -> 0x02cd }
                if (r5 >= r11) goto L_0x00fa
                org.json.JSONObject r11 = r9.getJSONObject(r5)     // Catch:{ Exception -> 0x02cd }
                java.lang.String r11 = r11.getString(r3)     // Catch:{ Exception -> 0x02cd }
                r10.add(r11)     // Catch:{ Exception -> 0x02cd }
                int r5 = r5 + 1
                goto L_0x00e6
            L_0x00fa:
                net.imedicaldoctor.imd.Data.CompressHelper r9 = r8.Q4     // Catch:{ Exception -> 0x02cd }
                android.os.Bundle r11 = r8.D4     // Catch:{ Exception -> 0x02cd }
                java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02cd }
                r12.<init>()     // Catch:{ Exception -> 0x02cd }
                java.lang.String r0 = "Graphic-"
                r12.append(r0)     // Catch:{ Exception -> 0x02cd }
                java.lang.String r0 = ",,,,"
                java.lang.String r10 = android.text.TextUtils.join(r0, r10)     // Catch:{ Exception -> 0x02cd }
                r12.append(r10)     // Catch:{ Exception -> 0x02cd }
                java.lang.String r10 = r12.toString()     // Catch:{ Exception -> 0x02cd }
                r9.A1(r11, r10, r6, r6)     // Catch:{ Exception -> 0x02cd }
                return r4
            L_0x0119:
                java.lang.String r12 = "topic"
                boolean r12 = r10.equals(r12)     // Catch:{ Exception -> 0x02cd }
                if (r12 == 0) goto L_0x0225
                org.json.JSONObject r10 = r11.getJSONObject(r1)     // Catch:{ Exception -> 0x012c }
                java.lang.String r12 = "topicId"
                java.lang.String r10 = r10.getString(r12)     // Catch:{ Exception -> 0x012c }
                goto L_0x0138
            L_0x012c:
                org.json.JSONArray r10 = r11.getJSONArray(r2)     // Catch:{ Exception -> 0x02cd }
                org.json.JSONObject r10 = r10.getJSONObject(r5)     // Catch:{ Exception -> 0x02cd }
                java.lang.String r10 = r10.getString(r3)     // Catch:{ Exception -> 0x02cd }
            L_0x0138:
                org.json.JSONArray r12 = r11.getJSONArray(r2)     // Catch:{ Exception -> 0x0147 }
                org.json.JSONObject r12 = r12.getJSONObject(r5)     // Catch:{ Exception -> 0x0147 }
                java.lang.String r7 = "subtype"
                java.lang.String r12 = r12.getString(r7)     // Catch:{ Exception -> 0x0147 }
                goto L_0x0148
            L_0x0147:
                r12 = r0
            L_0x0148:
                java.lang.String r7 = "narrative_icg"
                boolean r12 = r12.equals(r7)     // Catch:{ Exception -> 0x02cd }
                if (r12 == 0) goto L_0x01d7
                java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ Exception -> 0x02cd }
                androidx.fragment.app.FragmentActivity r11 = r8.r()     // Catch:{ Exception -> 0x02cd }
                android.content.Context r11 = r11.getApplicationContext()     // Catch:{ Exception -> 0x02cd }
                net.imedicaldoctor.imd.iMD r11 = (net.imedicaldoctor.imd.iMD) r11     // Catch:{ Exception -> 0x02cd }
                java.util.ArrayList<android.os.Bundle> r11 = r11.s     // Catch:{ Exception -> 0x02cd }
                net.imedicaldoctor.imd.Fragments.Uptodate.UTDViewerActivity$UTDViewerFragment$5 r12 = new net.imedicaldoctor.imd.Fragments.Uptodate.UTDViewerActivity$UTDViewerFragment$5     // Catch:{ Exception -> 0x02cd }
                r12.<init>()     // Catch:{ Exception -> 0x02cd }
                java.util.Collection r11 = com.google.common.collect.Collections2.d(r11, r12)     // Catch:{ Exception -> 0x02cd }
                r9.<init>(r11)     // Catch:{ Exception -> 0x02cd }
                int r11 = r9.size()     // Catch:{ Exception -> 0x02cd }
                if (r11 != 0) goto L_0x017a
                androidx.fragment.app.FragmentActivity r9 = r8.r()     // Catch:{ Exception -> 0x02cd }
                java.lang.String r10 = "You must install Uptodate Pathways Database"
                net.imedicaldoctor.imd.Data.CompressHelper.x2(r9, r10, r4)     // Catch:{ Exception -> 0x02cd }
                return r4
            L_0x017a:
                java.lang.Object r9 = r9.get(r5)     // Catch:{ Exception -> 0x02cd }
                android.os.Bundle r9 = (android.os.Bundle) r9     // Catch:{ Exception -> 0x02cd }
                java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02cd }
                r11.<init>()     // Catch:{ Exception -> 0x02cd }
                java.lang.String r12 = "base/"
                r11.append(r12)     // Catch:{ Exception -> 0x02cd }
                r11.append(r10)     // Catch:{ Exception -> 0x02cd }
                java.lang.String r10 = ".html"
                r11.append(r10)     // Catch:{ Exception -> 0x02cd }
                java.lang.String r10 = r11.toString()     // Catch:{ Exception -> 0x02cd }
                net.imedicaldoctor.imd.Data.CompressHelper r11 = r8.Q4     // Catch:{ Exception -> 0x02cd }
                java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02cd }
                r12.<init>()     // Catch:{ Exception -> 0x02cd }
                java.lang.String r1 = "Select * from docs where path = '"
                r12.append(r1)     // Catch:{ Exception -> 0x02cd }
                r12.append(r10)     // Catch:{ Exception -> 0x02cd }
                java.lang.String r10 = "'"
                r12.append(r10)     // Catch:{ Exception -> 0x02cd }
                java.lang.String r10 = r12.toString()     // Catch:{ Exception -> 0x02cd }
                java.util.ArrayList r10 = r11.V(r9, r10)     // Catch:{ Exception -> 0x02cd }
                if (r10 == 0) goto L_0x01cc
                int r11 = r10.size()     // Catch:{ Exception -> 0x02cd }
                if (r11 != 0) goto L_0x01bb
                goto L_0x01cc
            L_0x01bb:
                java.lang.Object r10 = r10.get(r5)     // Catch:{ Exception -> 0x02cd }
                android.os.Bundle r10 = (android.os.Bundle) r10     // Catch:{ Exception -> 0x02cd }
                net.imedicaldoctor.imd.Data.CompressHelper r11 = r8.Q4     // Catch:{ Exception -> 0x02cd }
                java.lang.String r10 = r10.getString(r3)     // Catch:{ Exception -> 0x02cd }
                r11.A1(r9, r10, r6, r0)     // Catch:{ Exception -> 0x02cd }
                goto L_0x02cd
            L_0x01cc:
                androidx.fragment.app.FragmentActivity r9 = r8.r()     // Catch:{ Exception -> 0x02cd }
                java.lang.String r10 = "Sorry, Document not available"
                net.imedicaldoctor.imd.Data.CompressHelper.x2(r9, r10, r4)     // Catch:{ Exception -> 0x02cd }
                goto L_0x02cd
            L_0x01d7:
                org.json.JSONObject r12 = r11.getJSONObject(r1)     // Catch:{ Exception -> 0x01e0 }
                java.lang.String r9 = r12.getString(r9)     // Catch:{ Exception -> 0x01e0 }
                goto L_0x01ee
            L_0x01e0:
                org.json.JSONArray r11 = r11.getJSONArray(r2)     // Catch:{ Exception -> 0x01ed }
                org.json.JSONObject r11 = r11.getJSONObject(r5)     // Catch:{ Exception -> 0x01ed }
                java.lang.String r9 = r11.getString(r9)     // Catch:{ Exception -> 0x01ed }
                goto L_0x01ee
            L_0x01ed:
                r9 = r6
            L_0x01ee:
                java.lang.String r11 = r8.f5     // Catch:{ Exception -> 0x02cd }
                boolean r11 = r11.equals(r10)     // Catch:{ Exception -> 0x02cd }
                if (r11 == 0) goto L_0x01fa
                r8.C3(r9)     // Catch:{ Exception -> 0x02cd }
                return r4
            L_0x01fa:
                java.lang.String r11 = "Activity Type"
                androidx.fragment.app.FragmentActivity r12 = r8.r()     // Catch:{ Exception -> 0x02cd }
                java.lang.Class r12 = r12.getClass()     // Catch:{ Exception -> 0x02cd }
                java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x02cd }
                net.imedicaldoctor.imd.iMDLogger.j(r11, r12)     // Catch:{ Exception -> 0x02cd }
                net.imedicaldoctor.imd.Data.CompressHelper r11 = r8.Q4     // Catch:{ Exception -> 0x02cd }
                android.os.Bundle r12 = r8.D4     // Catch:{ Exception -> 0x02cd }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02cd }
                r0.<init>()     // Catch:{ Exception -> 0x02cd }
                java.lang.String r1 = "Topic-"
                r0.append(r1)     // Catch:{ Exception -> 0x02cd }
                r0.append(r10)     // Catch:{ Exception -> 0x02cd }
                java.lang.String r10 = r0.toString()     // Catch:{ Exception -> 0x02cd }
                r11.A1(r12, r10, r6, r9)     // Catch:{ Exception -> 0x02cd }
                goto L_0x02cd
            L_0x0225:
                java.lang.String r9 = "abstract"
                boolean r9 = r10.equals(r9)     // Catch:{ Exception -> 0x02cd }
                if (r9 == 0) goto L_0x0291
                java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ Exception -> 0x02cd }
                r9.<init>()     // Catch:{ Exception -> 0x02cd }
                org.json.JSONArray r10 = r11.getJSONArray(r2)     // Catch:{ Exception -> 0x02cd }
            L_0x0236:
                int r11 = r10.length()     // Catch:{ Exception -> 0x02cd }
                if (r5 >= r11) goto L_0x024a
                org.json.JSONObject r11 = r10.getJSONObject(r5)     // Catch:{ Exception -> 0x02cd }
                java.lang.String r11 = r11.getString(r3)     // Catch:{ Exception -> 0x02cd }
                r9.add(r11)     // Catch:{ Exception -> 0x02cd }
                int r5 = r5 + 1
                goto L_0x0236
            L_0x024a:
                java.lang.String r10 = ","
                java.lang.String r9 = android.text.TextUtils.join(r10, r9)     // Catch:{ Exception -> 0x02cd }
                androidx.fragment.app.FragmentActivity r10 = r8.r()     // Catch:{ Exception -> 0x02cd }
                java.lang.String r11 = "Loading"
                java.lang.String r12 = "Please wait..."
                android.app.ProgressDialog r10 = android.app.ProgressDialog.show(r10, r11, r12, r4)     // Catch:{ Exception -> 0x02cd }
                java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02cd }
                r11.<init>()     // Catch:{ Exception -> 0x02cd }
                java.lang.String r12 = "abstracts|||||"
                r11.append(r12)     // Catch:{ Exception -> 0x02cd }
                r11.append(r9)     // Catch:{ Exception -> 0x02cd }
                java.lang.String r9 = r11.toString()     // Catch:{ Exception -> 0x02cd }
                net.imedicaldoctor.imd.Data.CompressHelper r11 = r8.Q4     // Catch:{ Exception -> 0x02cd }
                io.reactivex.rxjava3.core.Observable r9 = r11.o0(r9)     // Catch:{ Exception -> 0x02cd }
                io.reactivex.rxjava3.core.Scheduler r11 = io.reactivex.rxjava3.schedulers.Schedulers.e()     // Catch:{ Exception -> 0x02cd }
                io.reactivex.rxjava3.core.Observable r9 = r9.h6(r11)     // Catch:{ Exception -> 0x02cd }
                io.reactivex.rxjava3.core.Scheduler r11 = io.reactivex.rxjava3.android.schedulers.AndroidSchedulers.e()     // Catch:{ Exception -> 0x02cd }
                io.reactivex.rxjava3.core.Observable r9 = r9.s4(r11)     // Catch:{ Exception -> 0x02cd }
                net.imedicaldoctor.imd.Fragments.Uptodate.UTDViewerActivity$UTDViewerFragment$6 r11 = new net.imedicaldoctor.imd.Fragments.Uptodate.UTDViewerActivity$UTDViewerFragment$6     // Catch:{ Exception -> 0x02cd }
                r11.<init>(r10)     // Catch:{ Exception -> 0x02cd }
                net.imedicaldoctor.imd.Fragments.Uptodate.UTDViewerActivity$UTDViewerFragment$7 r12 = new net.imedicaldoctor.imd.Fragments.Uptodate.UTDViewerActivity$UTDViewerFragment$7     // Catch:{ Exception -> 0x02cd }
                r12.<init>(r10)     // Catch:{ Exception -> 0x02cd }
                r9.e6(r11, r12)     // Catch:{ Exception -> 0x02cd }
                goto L_0x02cd
            L_0x0291:
                java.lang.String r9 = "external"
                boolean r9 = r10.equals(r9)     // Catch:{ Exception -> 0x02cd }
                if (r9 == 0) goto L_0x02cd
                org.json.JSONArray r9 = r11.getJSONArray(r2)     // Catch:{ Exception -> 0x02cd }
                org.json.JSONObject r9 = r9.getJSONObject(r5)     // Catch:{ Exception -> 0x02cd }
                java.lang.String r10 = "url"
                java.lang.String r9 = r9.getString(r10)     // Catch:{ Exception -> 0x02cd }
                java.lang.String r9 = java.net.URLDecoder.decode(r9)     // Catch:{ Exception -> 0x02cd }
                net.imedicaldoctor.imd.Data.CompressHelper r10 = r8.Q4     // Catch:{ Exception -> 0x02cd }
                java.lang.String r11 = "?target_url="
                java.lang.String[] r9 = org.apache.commons.lang3.StringUtils.splitByWholeSeparator(r9, r11)     // Catch:{ Exception -> 0x02cd }
                java.lang.String r9 = r10.t1(r9)     // Catch:{ Exception -> 0x02cd }
                java.lang.String r10 = "&token="
                java.lang.String[] r9 = org.apache.commons.lang3.StringUtils.splitByWholeSeparator(r9, r10)     // Catch:{ Exception -> 0x02cd }
                r9 = r9[r5]     // Catch:{ Exception -> 0x02cd }
                android.content.Intent r10 = new android.content.Intent     // Catch:{ Exception -> 0x02cd }
                java.lang.String r11 = "android.intent.action.VIEW"
                android.net.Uri r9 = android.net.Uri.parse(r9)     // Catch:{ Exception -> 0x02cd }
                r10.<init>(r11, r9)     // Catch:{ Exception -> 0x02cd }
                r8.D2(r10)     // Catch:{ Exception -> 0x02cd }
            L_0x02cd:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.Uptodate.UTDViewerActivity.UTDViewerFragment.y4(android.webkit.WebView, java.lang.String, java.lang.String, java.lang.String):boolean");
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.f1175activity_general_viewer);
        Y0(new UTDViewerFragment(), bundle);
    }
}
