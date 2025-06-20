package net.imedicaldoctor.imd.Fragments.Uptodate;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.appcompat.app.AlertDialog;
import androidx.exifinterface.media.ExifInterface;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.media3.common.MimeTypes;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import fi.iki.elonen.NanoHTTPD;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.ViewerHelperActivity;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.Gallery.GalleryActivity;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.iMDLogger;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import org.apache.commons.lang3.StringUtils;

public class UTDGraphicActivity extends ViewerHelperActivity {

    public static class UTDGraphicFragment extends ViewerHelperFragment {
        public boolean X4;
        public ArrayList<String> Y4;
        public int Z4;
        /* access modifiers changed from: private */
        public String[] a5;
        /* access modifiers changed from: private */
        public ArrayList<String> b5;
        /* access modifiers changed from: private */
        public ArrayList<String> c5;
        /* access modifiers changed from: private */
        public ArrayList<String> d5;
        /* access modifiers changed from: private */
        public ArrayList<Bundle> e5;
        /* access modifiers changed from: private */
        public float f5;
        /* access modifiers changed from: private */
        public boolean g5;
        /* access modifiers changed from: private */
        public String h5;
        /* access modifiers changed from: private */
        public String i5;
        /* access modifiers changed from: private */
        public String j5;

        public static void c5(String str, Context context) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
            contentValues.put("mime_type", MimeTypes.Q0);
            contentValues.put("_data", str);
            context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        }

        public static void d5(String str, Context context) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
            contentValues.put("mime_type", MimeTypes.f9231f);
            contentValues.put("_data", str);
            context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        }

        private void g5(String str) {
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

        private void i5(String str) {
            ArrayList<Bundle> arrayList = this.e5;
            if (arrayList == null || arrayList.size() == 0) {
                CompressHelper.x2(r(), "There is no images in this document", 1);
                return;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.e5.size(); i3++) {
                if (this.e5.get(i3).getString("name").equals(str)) {
                    i2 = i3;
                }
            }
            Intent intent = new Intent(r(), GalleryActivity.class);
            intent.putExtra("Images", this.e5);
            intent.putExtra("Start", i2);
            D2(intent);
        }

        public void I4() {
            this.s4.findItem(R.id.f805action_previous).setEnabled(false);
            this.s4.findItem(R.id.f805action_previous).setIcon(R.drawable.L5);
        }

        public void J4() {
            this.s4.findItem(R.id.f803action_next).setEnabled(false);
            this.s4.findItem(R.id.f803action_next).setIcon(R.drawable.I5);
        }

        public void K4() {
            this.s4.findItem(R.id.f805action_previous).setEnabled(true);
            this.s4.findItem(R.id.f805action_previous).setIcon(R.drawable.J5);
        }

        public void L4() {
            this.s4.findItem(R.id.f803action_next).setEnabled(true);
            this.s4.findItem(R.id.f803action_next).setIcon(R.drawable.G5);
        }

        public void M4() {
            T2(new Runnable() {
                /* JADX WARNING: Removed duplicated region for block: B:117:0x02f5  */
                /* JADX WARNING: Removed duplicated region for block: B:186:0x042b A[Catch:{ Exception -> 0x0454 }] */
                /* JADX WARNING: Removed duplicated region for block: B:187:0x042e A[Catch:{ Exception -> 0x0454 }] */
                /* JADX WARNING: Removed duplicated region for block: B:49:0x016e A[SYNTHETIC, Splitter:B:49:0x016e] */
                /* JADX WARNING: Removed duplicated region for block: B:64:0x01d9 A[SYNTHETIC, Splitter:B:64:0x01d9] */
                /* JADX WARNING: Removed duplicated region for block: B:79:0x0210  */
                /* JADX WARNING: Removed duplicated region for block: B:84:0x0230 A[SYNTHETIC, Splitter:B:84:0x0230] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r35 = this;
                        r1 = r35
                        java.lang.String r2 = "base64Image"
                        java.lang.String r3 = "127"
                        java.lang.String r4 = "related_topic"
                        java.lang.String r5 = "'"
                        java.lang.String r6 = "graphicActivity"
                        java.lang.String r7 = "uptodateonline"
                        java.lang.String r8 = "Name"
                        java.lang.String r9 = "graphicInfo"
                        java.lang.String r10 = ""
                        net.imedicaldoctor.imd.Data.CompressHelper r11 = new net.imedicaldoctor.imd.Data.CompressHelper     // Catch:{ Exception -> 0x0033 }
                        net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity$UTDGraphicFragment r0 = net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity.UTDGraphicFragment.this     // Catch:{ Exception -> 0x0033 }
                        androidx.fragment.app.FragmentActivity r0 = r0.r()     // Catch:{ Exception -> 0x0033 }
                        r11.<init>(r0)     // Catch:{ Exception -> 0x0033 }
                        net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity$UTDGraphicFragment r0 = net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity.UTDGraphicFragment.this     // Catch:{ Exception -> 0x0033 }
                        java.lang.String r0 = r0.A4     // Catch:{ Exception -> 0x0033 }
                        r12 = 1
                        if (r0 == 0) goto L_0x0036
                        int r0 = r0.length()     // Catch:{ Exception -> 0x0033 }
                        if (r0 == 0) goto L_0x0036
                        net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity$UTDGraphicFragment r0 = net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity.UTDGraphicFragment.this     // Catch:{ Exception -> 0x0033 }
                        boolean r0 = r0.X4     // Catch:{ Exception -> 0x0033 }
                        if (r0 != r12) goto L_0x0598
                        goto L_0x0036
                    L_0x0033:
                        r0 = move-exception
                        goto L_0x0586
                    L_0x0036:
                        net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity$UTDGraphicFragment r0 = net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity.UTDGraphicFragment.this     // Catch:{ Exception -> 0x0033 }
                        r13 = 0
                        r0.X4 = r13     // Catch:{ Exception -> 0x0033 }
                        android.os.Bundle r0 = r0.D4     // Catch:{ Exception -> 0x0033 }
                        java.lang.String r0 = r0.getString(r8)     // Catch:{ Exception -> 0x0033 }
                        boolean r0 = r0.equals(r7)     // Catch:{ Exception -> 0x0033 }
                        java.lang.String r14 = "1"
                        java.lang.String r15 = "utdasset.sqlite"
                        if (r0 != 0) goto L_0x0063
                        net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity$UTDGraphicFragment r0 = net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity.UTDGraphicFragment.this     // Catch:{ Exception -> 0x0033 }
                        android.os.Bundle r0 = r0.D4     // Catch:{ Exception -> 0x0033 }
                        java.lang.String r0 = net.imedicaldoctor.imd.Data.CompressHelper.g1(r0, r15)     // Catch:{ Exception -> 0x0033 }
                        java.io.File r13 = new java.io.File     // Catch:{ Exception -> 0x0033 }
                        r13.<init>(r0)     // Catch:{ Exception -> 0x0033 }
                        boolean r0 = r13.exists()     // Catch:{ Exception -> 0x0033 }
                        if (r0 != 0) goto L_0x0063
                        net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity$UTDGraphicFragment r0 = net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity.UTDGraphicFragment.this     // Catch:{ Exception -> 0x0033 }
                        r0.p4 = r14     // Catch:{ Exception -> 0x0033 }
                        return
                    L_0x0063:
                        net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity$UTDGraphicFragment r0 = net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity.UTDGraphicFragment.this     // Catch:{ Exception -> 0x0033 }
                        java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ Exception -> 0x0033 }
                        r13.<init>()     // Catch:{ Exception -> 0x0033 }
                        java.util.ArrayList unused = r0.c5 = r13     // Catch:{ Exception -> 0x0033 }
                        net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity$UTDGraphicFragment r0 = net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity.UTDGraphicFragment.this     // Catch:{ Exception -> 0x0033 }
                        java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ Exception -> 0x0033 }
                        r13.<init>()     // Catch:{ Exception -> 0x0033 }
                        java.util.ArrayList unused = r0.d5 = r13     // Catch:{ Exception -> 0x0033 }
                        net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity$UTDGraphicFragment r0 = net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity.UTDGraphicFragment.this     // Catch:{ Exception -> 0x0033 }
                        java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ Exception -> 0x0033 }
                        r13.<init>()     // Catch:{ Exception -> 0x0033 }
                        java.util.ArrayList unused = r0.b5 = r13     // Catch:{ Exception -> 0x0033 }
                        net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity$UTDGraphicFragment r0 = net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity.UTDGraphicFragment.this     // Catch:{ Exception -> 0x008f }
                        androidx.fragment.app.FragmentActivity r13 = r0.r()     // Catch:{ Exception -> 0x008f }
                        java.lang.String r12 = "UTDGraphicContent.css"
                        java.lang.String r0 = r0.d4(r13, r12)     // Catch:{ Exception -> 0x008f }
                        r12 = r0
                        goto L_0x00a5
                    L_0x008f:
                        r0 = move-exception
                        java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0033 }
                        r12.<init>()     // Catch:{ Exception -> 0x0033 }
                        java.lang.String r13 = "Error in reading UTDGraphicContent.css asset with error "
                        r12.append(r13)     // Catch:{ Exception -> 0x0033 }
                        r12.append(r0)     // Catch:{ Exception -> 0x0033 }
                        java.lang.String r0 = r12.toString()     // Catch:{ Exception -> 0x0033 }
                        net.imedicaldoctor.imd.iMDLogger.f(r6, r0)     // Catch:{ Exception -> 0x0033 }
                        r12 = r10
                    L_0x00a5:
                        java.lang.String r16 = "graphic_picture"
                        java.lang.String r17 = "graphic_figure"
                        java.lang.String r18 = "graphic_algorithm"
                        java.lang.String r19 = "graphic_diagnosticimage"
                        java.lang.String r20 = "graphic_waveform"
                        java.lang.String r21 = "graphic_form"
                        java.lang.String[] r13 = new java.lang.String[]{r16, r17, r18, r19, r20, r21}     // Catch:{ Exception -> 0x0033 }
                        net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity$UTDGraphicFragment r0 = net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity.UTDGraphicFragment.this     // Catch:{ Exception -> 0x0033 }
                        r16 = r14
                        java.lang.String[] r14 = r0.a5     // Catch:{ Exception -> 0x0033 }
                        r17 = r6
                        int r6 = r14.length     // Catch:{ Exception -> 0x0033 }
                        r18 = 0
                        r21 = r10
                        r22 = r21
                        r19 = r12
                        r12 = 0
                        r20 = 0
                    L_0x00cb:
                        java.lang.String r0 = "[id]"
                        if (r12 >= r6) goto L_0x04ad
                        r23 = r6
                        r6 = r14[r12]     // Catch:{ Exception -> 0x0033 }
                        r24 = r14
                        net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity$UTDGraphicFragment r14 = net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity.UTDGraphicFragment.this     // Catch:{ Exception -> 0x0033 }
                        android.os.Bundle r14 = r14.D4     // Catch:{ Exception -> 0x0033 }
                        r25 = r12
                        java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0033 }
                        r12.<init>()     // Catch:{ Exception -> 0x0033 }
                        r26 = r0
                        java.lang.String r0 = "select rowid as _id, related_topic from Search where url='Graphic-"
                        r12.append(r0)     // Catch:{ Exception -> 0x0033 }
                        r12.append(r6)     // Catch:{ Exception -> 0x0033 }
                        r12.append(r5)     // Catch:{ Exception -> 0x0033 }
                        java.lang.String r0 = r12.toString()     // Catch:{ Exception -> 0x0033 }
                        java.lang.String r12 = "fsearch.db"
                        android.os.Bundle r0 = r11.f0(r14, r0, r12)     // Catch:{ Exception -> 0x0033 }
                        if (r0 == 0) goto L_0x0110
                        java.lang.String r12 = r0.getString(r4)     // Catch:{ Exception -> 0x0033 }
                        int r12 = r12.length()     // Catch:{ Exception -> 0x0033 }
                        if (r12 <= 0) goto L_0x0110
                        net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity$UTDGraphicFragment r12 = net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity.UTDGraphicFragment.this     // Catch:{ Exception -> 0x0033 }
                        java.util.ArrayList r12 = r12.b5     // Catch:{ Exception -> 0x0033 }
                        java.lang.String r0 = r0.getString(r4)     // Catch:{ Exception -> 0x0033 }
                        r12.add(r0)     // Catch:{ Exception -> 0x0033 }
                    L_0x0110:
                        java.lang.String r0 = " "
                        java.lang.String r0 = r6.replace(r0, r10)     // Catch:{ Exception -> 0x0033 }
                        net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity$UTDGraphicFragment r6 = net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity.UTDGraphicFragment.this     // Catch:{ Exception -> 0x0033 }
                        android.os.Bundle r6 = r6.D4     // Catch:{ Exception -> 0x0033 }
                        java.lang.String r6 = r6.getString(r8)     // Catch:{ Exception -> 0x0033 }
                        boolean r6 = r6.equals(r7)     // Catch:{ Exception -> 0x0033 }
                        if (r6 == 0) goto L_0x0175
                        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0168 }
                        r6.<init>()     // Catch:{ Exception -> 0x0168 }
                        java.lang.String r14 = r11.J()     // Catch:{ Exception -> 0x0168 }
                        r6.append(r14)     // Catch:{ Exception -> 0x0168 }
                        java.lang.String r14 = "/utdonline/graphic/"
                        r6.append(r14)     // Catch:{ Exception -> 0x0168 }
                        r6.append(r0)     // Catch:{ Exception -> 0x0168 }
                        java.lang.String r14 = ".txt"
                        r6.append(r14)     // Catch:{ Exception -> 0x0168 }
                        java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0168 }
                        java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0168 }
                        r14.<init>()     // Catch:{ Exception -> 0x0168 }
                        java.lang.String r12 = "graphic-"
                        r14.append(r12)     // Catch:{ Exception -> 0x0168 }
                        r14.append(r0)     // Catch:{ Exception -> 0x0168 }
                        net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity$UTDGraphicFragment r12 = net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity.UTDGraphicFragment.this     // Catch:{ Exception -> 0x0168 }
                        android.os.Bundle r12 = r12.D4     // Catch:{ Exception -> 0x0168 }
                        r28 = r4
                        java.lang.String r4 = "Version"
                        java.lang.String r4 = r12.getString(r4)     // Catch:{ Exception -> 0x0166 }
                        r14.append(r4)     // Catch:{ Exception -> 0x0166 }
                        java.lang.String r4 = r14.toString()     // Catch:{ Exception -> 0x0166 }
                        java.lang.String r4 = r11.p1(r6, r4)     // Catch:{ Exception -> 0x0166 }
                        goto L_0x016c
                    L_0x0166:
                        goto L_0x016b
                    L_0x0168:
                        r28 = r4
                        goto L_0x0166
                    L_0x016b:
                        r4 = 0
                    L_0x016c:
                        if (r4 != 0) goto L_0x019f
                        net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity$UTDGraphicFragment r0 = net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity.UTDGraphicFragment.this     // Catch:{ Exception -> 0x0033 }
                        java.lang.String r2 = "Error in retrieving data from server"
                        r0.p4 = r2     // Catch:{ Exception -> 0x0033 }
                        return
                    L_0x0175:
                        r28 = r4
                        net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity$UTDGraphicFragment r4 = net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity.UTDGraphicFragment.this     // Catch:{ Exception -> 0x0033 }
                        android.os.Bundle r4 = r4.D4     // Catch:{ Exception -> 0x0033 }
                        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0033 }
                        r6.<init>()     // Catch:{ Exception -> 0x0033 }
                        java.lang.String r12 = "select * from graphic_asset where id ="
                        r6.append(r12)     // Catch:{ Exception -> 0x0033 }
                        r6.append(r0)     // Catch:{ Exception -> 0x0033 }
                        java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0033 }
                        android.os.Bundle r4 = r11.f0(r4, r6, r15)     // Catch:{ Exception -> 0x0033 }
                        if (r4 != 0) goto L_0x0199
                        net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity$UTDGraphicFragment r0 = net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity.UTDGraphicFragment.this     // Catch:{ Exception -> 0x0033 }
                        java.lang.String r2 = "2"
                        r0.p4 = r2     // Catch:{ Exception -> 0x0033 }
                        return
                    L_0x0199:
                        java.lang.String r6 = "payload"
                        java.lang.String r4 = r4.getString(r6)     // Catch:{ Exception -> 0x0033 }
                    L_0x019f:
                        byte[] r0 = r11.v(r4, r0, r3)     // Catch:{ Exception -> 0x0033 }
                        java.lang.String r4 = new java.lang.String     // Catch:{ Exception -> 0x0033 }
                        r4.<init>(r0)     // Catch:{ Exception -> 0x0033 }
                        org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0475 }
                        r0.<init>(r4)     // Catch:{ Exception -> 0x0475 }
                        org.json.JSONObject r4 = r0.getJSONObject(r9)     // Catch:{ Exception -> 0x0475 }
                        java.lang.String r6 = "subtype"
                        java.lang.String r4 = r4.getString(r6)     // Catch:{ Exception -> 0x0475 }
                        java.lang.String r6 = "imageHtml"
                        java.lang.String r6 = r0.getString(r6)     // Catch:{ Exception -> 0x0475 }
                        org.json.JSONObject r12 = r0.getJSONObject(r9)     // Catch:{ Exception -> 0x0475 }
                        java.lang.String r14 = "id"
                        java.lang.String r12 = r12.getString(r14)     // Catch:{ Exception -> 0x0475 }
                        org.json.JSONObject r14 = r0.getJSONObject(r9)     // Catch:{ Exception -> 0x0475 }
                        r29 = r7
                        java.lang.String r7 = "title"
                        java.lang.String r7 = r14.getString(r7)     // Catch:{ Exception -> 0x046f }
                        boolean r14 = r0.has(r2)     // Catch:{ Exception -> 0x046f }
                        if (r14 == 0) goto L_0x0210
                        java.lang.String r14 = r0.getString(r2)     // Catch:{ Exception -> 0x020c }
                        r30 = r2
                        java.lang.String r2 = "imageSource"
                        java.lang.String r2 = r0.getString(r2)     // Catch:{ Exception -> 0x0208 }
                        r31 = r8
                        net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity$UTDGraphicFragment r8 = net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity.UTDGraphicFragment.this     // Catch:{ Exception -> 0x01fa }
                        java.util.ArrayList r8 = r8.c5     // Catch:{ Exception -> 0x01fa }
                        r8.add(r14)     // Catch:{ Exception -> 0x01fa }
                        net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity$UTDGraphicFragment r8 = net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity.UTDGraphicFragment.this     // Catch:{ Exception -> 0x01fa }
                        java.util.ArrayList r8 = r8.d5     // Catch:{ Exception -> 0x01fa }
                        r8.add(r2)     // Catch:{ Exception -> 0x01fa }
                        goto L_0x0216
                    L_0x01fa:
                        r0 = move-exception
                    L_0x01fb:
                        r27 = r9
                        r32 = r13
                        r33 = r15
                        r8 = r19
                    L_0x0203:
                        r4 = 1
                        r19 = r5
                        goto L_0x047b
                    L_0x0208:
                        r0 = move-exception
                    L_0x0209:
                        r31 = r8
                        goto L_0x01fb
                    L_0x020c:
                        r0 = move-exception
                        r30 = r2
                        goto L_0x0209
                    L_0x0210:
                        r30 = r2
                        r31 = r8
                        r2 = 0
                        r14 = 0
                    L_0x0216:
                        java.util.List r8 = java.util.Arrays.asList(r13)     // Catch:{ Exception -> 0x0460 }
                        boolean r8 = r8.contains(r4)     // Catch:{ Exception -> 0x0460 }
                        r27 = r9
                        java.lang.String r9 = "px"
                        r32 = r13
                        java.lang.String r13 = "width: "
                        r33 = r15
                        java.lang.String r15 = "data:image/jpg;base64,"
                        r34 = r7
                        java.lang.String r7 = "[content]"
                        if (r8 == 0) goto L_0x02f5
                        java.lang.String[] r0 = r6.split(r13)     // Catch:{ Exception -> 0x02f1 }
                        r4 = 1
                        r0 = r0[r4]     // Catch:{ Exception -> 0x02f1 }
                        java.lang.String[] r0 = r0.split(r9)     // Catch:{ Exception -> 0x02f1 }
                        r4 = 0
                        r0 = r0[r4]     // Catch:{ Exception -> 0x02f1 }
                        float r0 = java.lang.Float.parseFloat(r0)     // Catch:{ Exception -> 0x02f1 }
                        int r4 = (r0 > r20 ? 1 : (r0 == r20 ? 0 : -1))
                        if (r4 <= 0) goto L_0x0248
                        r20 = r0
                    L_0x0248:
                        r8 = r19
                        r0 = r26
                        java.lang.String r0 = r8.replace(r0, r12)     // Catch:{ Exception -> 0x02ed }
                        java.lang.String r4 = r0.replace(r7, r6)     // Catch:{ Exception -> 0x02ed }
                        android.os.Bundle r7 = new android.os.Bundle     // Catch:{ Exception -> 0x02b2 }
                        r7.<init>()     // Catch:{ Exception -> 0x02b2 }
                        java.lang.String r0 = "base64"
                        r9 = 0
                        byte[] r13 = android.util.Base64.decode(r14, r9)     // Catch:{ Exception -> 0x02b2 }
                        r7.putByteArray(r0, r13)     // Catch:{ Exception -> 0x02b2 }
                        java.lang.String r0 = "name"
                        r7.putString(r0, r12)     // Catch:{ Exception -> 0x02b2 }
                        java.lang.String r0 = "<div class=\"graphic_lgnd\">"
                        java.lang.String[] r0 = org.apache.commons.lang3.StringUtils.splitByWholeSeparator(r6, r0)     // Catch:{ Exception -> 0x0282 }
                        java.lang.String r6 = "Description"
                        int r9 = r0.length     // Catch:{ Exception -> 0x0282 }
                        r13 = 1
                        int r9 = r9 - r13
                        r0 = r0[r9]     // Catch:{ Exception -> 0x0282 }
                        java.lang.String r9 = "</div>"
                        java.lang.String[] r0 = org.apache.commons.lang3.StringUtils.splitByWholeSeparator(r0, r9)     // Catch:{ Exception -> 0x0282 }
                        r9 = 0
                        r0 = r0[r9]     // Catch:{ Exception -> 0x0282 }
                        r7.putString(r6, r0)     // Catch:{ Exception -> 0x0282 }
                        goto L_0x028a
                    L_0x0282:
                        r0 = move-exception
                        com.google.firebase.crashlytics.FirebaseCrashlytics r6 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()     // Catch:{ Exception -> 0x02b2 }
                        r6.g(r0)     // Catch:{ Exception -> 0x02b2 }
                    L_0x028a:
                        net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity$UTDGraphicFragment r0 = net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity.UTDGraphicFragment.this     // Catch:{ Exception -> 0x02b2 }
                        java.util.ArrayList r0 = r0.e5     // Catch:{ Exception -> 0x02b2 }
                        r0.add(r7)     // Catch:{ Exception -> 0x02b2 }
                        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02b2 }
                        r0.<init>()     // Catch:{ Exception -> 0x02b2 }
                        r0.append(r15)     // Catch:{ Exception -> 0x02b2 }
                        r0.append(r14)     // Catch:{ Exception -> 0x02b2 }
                        java.lang.String r6 = "\" onclick=\"document.location.href='image://"
                        r0.append(r6)     // Catch:{ Exception -> 0x02b2 }
                        r0.append(r12)     // Catch:{ Exception -> 0x02b2 }
                        r0.append(r5)     // Catch:{ Exception -> 0x02b2 }
                        java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x02b2 }
                        java.lang.String r0 = r4.replace(r2, r0)     // Catch:{ Exception -> 0x02b2 }
                        goto L_0x02cd
                    L_0x02b2:
                        r0 = move-exception
                        com.google.firebase.crashlytics.FirebaseCrashlytics r6 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()     // Catch:{ Exception -> 0x02ed }
                        r6.g(r0)     // Catch:{ Exception -> 0x02ed }
                        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ed }
                        r0.<init>()     // Catch:{ Exception -> 0x02ed }
                        r0.append(r15)     // Catch:{ Exception -> 0x02ed }
                        r0.append(r14)     // Catch:{ Exception -> 0x02ed }
                        java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x02ed }
                        java.lang.String r0 = r4.replace(r2, r0)     // Catch:{ Exception -> 0x02ed }
                    L_0x02cd:
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ed }
                        r2.<init>()     // Catch:{ Exception -> 0x02ed }
                        r4 = r22
                        r2.append(r4)     // Catch:{ Exception -> 0x02e5 }
                        r2.append(r0)     // Catch:{ Exception -> 0x02e5 }
                        java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x02e5 }
                        r22 = r0
                        r19 = r5
                        r4 = 1
                        goto L_0x0425
                    L_0x02e5:
                        r0 = move-exception
                        r22 = r4
                    L_0x02e8:
                        r19 = r5
                    L_0x02ea:
                        r4 = 1
                        goto L_0x047b
                    L_0x02ed:
                        r0 = move-exception
                    L_0x02ee:
                        r4 = r22
                        goto L_0x02e8
                    L_0x02f1:
                        r0 = move-exception
                        r8 = r19
                        goto L_0x02ee
                    L_0x02f5:
                        r8 = r19
                        r19 = r5
                        r5 = r26
                        r26 = r2
                        java.lang.String r2 = "graphic_movie"
                        boolean r2 = r4.equals(r2)     // Catch:{ Exception -> 0x045c }
                        if (r2 == 0) goto L_0x040a
                        java.lang.String[] r2 = r6.split(r13)     // Catch:{ Exception -> 0x0405 }
                        r4 = 1
                        r2 = r2[r4]     // Catch:{ Exception -> 0x0400 }
                        java.lang.String[] r2 = r2.split(r9)     // Catch:{ Exception -> 0x0405 }
                        r4 = 0
                        r2 = r2[r4]     // Catch:{ Exception -> 0x0405 }
                        float r2 = java.lang.Float.parseFloat(r2)     // Catch:{ Exception -> 0x0405 }
                        int r4 = (r2 > r20 ? 1 : (r2 == r20 ? 0 : -1))
                        if (r4 <= 0) goto L_0x031d
                        r20 = r2
                    L_0x031d:
                        java.lang.String r2 = "movieUrl"
                        java.lang.String r0 = r0.getString(r2)     // Catch:{ Exception -> 0x0405 }
                        java.lang.String r2 = "/"
                        java.lang.String[] r0 = r0.split(r2)     // Catch:{ Exception -> 0x0405 }
                        int r2 = r0.length     // Catch:{ Exception -> 0x0405 }
                        r4 = 1
                        int r2 = r2 - r4
                        r0 = r0[r2]     // Catch:{ Exception -> 0x0405 }
                        net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity$UTDGraphicFragment r2 = net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity.UTDGraphicFragment.this     // Catch:{ Exception -> 0x0405 }
                        android.os.Bundle r2 = r2.D4     // Catch:{ Exception -> 0x0405 }
                        java.lang.String r2 = net.imedicaldoctor.imd.Data.CompressHelper.g1(r2, r0)     // Catch:{ Exception -> 0x0405 }
                        net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity$UTDGraphicFragment r4 = net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity.UTDGraphicFragment.this     // Catch:{ Exception -> 0x0405 }
                        android.os.Bundle r4 = r4.D4     // Catch:{ Exception -> 0x0405 }
                        java.lang.String r9 = "videos-E"
                        java.lang.String r4 = net.imedicaldoctor.imd.Data.CompressHelper.h1(r4, r0, r9)     // Catch:{ Exception -> 0x0405 }
                        net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity$UTDGraphicFragment r9 = net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity.UTDGraphicFragment.this     // Catch:{ Exception -> 0x0405 }
                        java.lang.String unused = r9.j5 = r4     // Catch:{ Exception -> 0x0405 }
                        java.io.File r9 = new java.io.File     // Catch:{ Exception -> 0x0405 }
                        r9.<init>(r4)     // Catch:{ Exception -> 0x0405 }
                        boolean r9 = r9.exists()     // Catch:{ Exception -> 0x0405 }
                        if (r9 == 0) goto L_0x03af
                        java.io.File r9 = new java.io.File     // Catch:{ Exception -> 0x0390 }
                        r9.<init>(r4)     // Catch:{ Exception -> 0x0390 }
                        okio.Source r4 = okio.Okio.t(r9)     // Catch:{ Exception -> 0x0390 }
                        okio.BufferedSource r4 = okio.Okio.e(r4)     // Catch:{ Exception -> 0x0390 }
                        byte[] r9 = r4.b0()     // Catch:{ all -> 0x03a1 }
                        r4.close()     // Catch:{ Exception -> 0x0390 }
                        byte[] r4 = r11.x(r9, r0, r3)     // Catch:{ Exception -> 0x0390 }
                        java.io.File r9 = new java.io.File     // Catch:{ Exception -> 0x0390 }
                        r9.<init>(r2)     // Catch:{ Exception -> 0x0390 }
                        okio.Sink r9 = okio.Okio.n(r9)     // Catch:{ Exception -> 0x0390 }
                        okio.BufferedSink r9 = okio.Okio.d(r9)     // Catch:{ Exception -> 0x0390 }
                        r9.write(r4)     // Catch:{ all -> 0x0393 }
                        r9.close()     // Catch:{ Exception -> 0x0390 }
                        java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x0390 }
                        r4.<init>(r2)     // Catch:{ Exception -> 0x0390 }
                        r4.deleteOnExit()     // Catch:{ Exception -> 0x0390 }
                        net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity$UTDGraphicFragment r4 = net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity.UTDGraphicFragment.this     // Catch:{ Exception -> 0x0390 }
                        r9 = 1
                        boolean unused = r4.g5 = r9     // Catch:{ Exception -> 0x0390 }
                        net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity$UTDGraphicFragment r4 = net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity.UTDGraphicFragment.this     // Catch:{ Exception -> 0x0390 }
                        java.lang.String unused = r4.h5 = r2     // Catch:{ Exception -> 0x0390 }
                        r4 = 1
                        goto L_0x03ba
                    L_0x0390:
                        r0 = move-exception
                        goto L_0x02ea
                    L_0x0393:
                        r0 = move-exception
                        r2 = r0
                        if (r9 == 0) goto L_0x03a0
                        r9.close()     // Catch:{ all -> 0x039b }
                        goto L_0x03a0
                    L_0x039b:
                        r0 = move-exception
                        r4 = r0
                        r2.addSuppressed(r4)     // Catch:{ Exception -> 0x0390 }
                    L_0x03a0:
                        throw r2     // Catch:{ Exception -> 0x0390 }
                    L_0x03a1:
                        r0 = move-exception
                        r2 = r0
                        if (r4 == 0) goto L_0x03ae
                        r4.close()     // Catch:{ all -> 0x03a9 }
                        goto L_0x03ae
                    L_0x03a9:
                        r0 = move-exception
                        r4 = r0
                        r2.addSuppressed(r4)     // Catch:{ Exception -> 0x0390 }
                    L_0x03ae:
                        throw r2     // Catch:{ Exception -> 0x0390 }
                    L_0x03af:
                        net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity$UTDGraphicFragment r2 = net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity.UTDGraphicFragment.this     // Catch:{ Exception -> 0x0405 }
                        r4 = 1
                        boolean unused = r2.g5 = r4     // Catch:{ Exception -> 0x0400 }
                        net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity$UTDGraphicFragment r2 = net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity.UTDGraphicFragment.this     // Catch:{ Exception -> 0x0400 }
                        java.lang.String unused = r2.h5 = r10     // Catch:{ Exception -> 0x0400 }
                    L_0x03ba:
                        net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity$UTDGraphicFragment r2 = net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity.UTDGraphicFragment.this     // Catch:{ Exception -> 0x0400 }
                        android.os.Bundle r9 = r2.D4     // Catch:{ Exception -> 0x0400 }
                        java.lang.String r0 = net.imedicaldoctor.imd.Data.CompressHelper.g1(r9, r0)     // Catch:{ Exception -> 0x0400 }
                        java.lang.String unused = r2.i5 = r0     // Catch:{ Exception -> 0x0400 }
                        java.lang.String r0 = r8.replace(r5, r12)     // Catch:{ Exception -> 0x0400 }
                        java.lang.String r0 = r0.replace(r7, r6)     // Catch:{ Exception -> 0x0400 }
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0400 }
                        r2.<init>()     // Catch:{ Exception -> 0x0400 }
                        r2.append(r15)     // Catch:{ Exception -> 0x0400 }
                        r2.append(r14)     // Catch:{ Exception -> 0x0400 }
                        java.lang.String r5 = "\" onclick=\"document.location.href='video://video'"
                        r2.append(r5)     // Catch:{ Exception -> 0x0400 }
                        java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0400 }
                        r5 = r26
                        java.lang.String r0 = r0.replace(r5, r2)     // Catch:{ Exception -> 0x0400 }
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0400 }
                        r2.<init>()     // Catch:{ Exception -> 0x0400 }
                        r9 = r22
                        r2.append(r9)     // Catch:{ Exception -> 0x03fb }
                        r2.append(r0)     // Catch:{ Exception -> 0x03fb }
                        java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x03fb }
                    L_0x03f8:
                        r22 = r0
                        goto L_0x0425
                    L_0x03fb:
                        r0 = move-exception
                    L_0x03fc:
                        r22 = r9
                        goto L_0x047b
                    L_0x0400:
                        r0 = move-exception
                        r9 = r22
                        goto L_0x047b
                    L_0x0405:
                        r0 = move-exception
                    L_0x0406:
                        r9 = r22
                        goto L_0x02ea
                    L_0x040a:
                        r9 = r22
                        r4 = 1
                        java.lang.String r0 = r8.replace(r5, r12)     // Catch:{ Exception -> 0x0458 }
                        java.lang.String r0 = r0.replace(r7, r6)     // Catch:{ Exception -> 0x0458 }
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0458 }
                        r2.<init>()     // Catch:{ Exception -> 0x0458 }
                        r2.append(r9)     // Catch:{ Exception -> 0x0458 }
                        r2.append(r0)     // Catch:{ Exception -> 0x0458 }
                        java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x0458 }
                        goto L_0x03f8
                    L_0x0425:
                        int r0 = r21.length()     // Catch:{ Exception -> 0x0454 }
                        if (r0 != 0) goto L_0x042e
                        r2 = r34
                        goto L_0x0447
                    L_0x042e:
                        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0454 }
                        r0.<init>()     // Catch:{ Exception -> 0x0454 }
                        r2 = r21
                        r0.append(r2)     // Catch:{ Exception -> 0x0450 }
                        java.lang.String r5 = " & "
                        r0.append(r5)     // Catch:{ Exception -> 0x0450 }
                        r5 = r34
                        r0.append(r5)     // Catch:{ Exception -> 0x0450 }
                        java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0450 }
                        r2 = r0
                    L_0x0447:
                        net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity$UTDGraphicFragment r0 = net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity.UTDGraphicFragment.this     // Catch:{ Exception -> 0x0450 }
                        r0.F4 = r2     // Catch:{ Exception -> 0x0450 }
                        r21 = r2
                        r2 = r17
                        goto L_0x0491
                    L_0x0450:
                        r0 = move-exception
                        r21 = r2
                        goto L_0x047b
                    L_0x0454:
                        r0 = move-exception
                        r2 = r21
                        goto L_0x047b
                    L_0x0458:
                        r0 = move-exception
                        r2 = r21
                        goto L_0x03fc
                    L_0x045c:
                        r0 = move-exception
                        r2 = r21
                        goto L_0x0406
                    L_0x0460:
                        r0 = move-exception
                    L_0x0461:
                        r27 = r9
                        r32 = r13
                        r33 = r15
                        r8 = r19
                        r2 = r21
                        r9 = r22
                        goto L_0x0203
                    L_0x046f:
                        r0 = move-exception
                        r30 = r2
                    L_0x0472:
                        r31 = r8
                        goto L_0x0461
                    L_0x0475:
                        r0 = move-exception
                        r30 = r2
                        r29 = r7
                        goto L_0x0472
                    L_0x047b:
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0033 }
                        r2.<init>()     // Catch:{ Exception -> 0x0033 }
                        java.lang.String r5 = "Error in loading image id : id , With error "
                        r2.append(r5)     // Catch:{ Exception -> 0x0033 }
                        r2.append(r0)     // Catch:{ Exception -> 0x0033 }
                        java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x0033 }
                        r2 = r17
                        net.imedicaldoctor.imd.iMDLogger.f(r2, r0)     // Catch:{ Exception -> 0x0033 }
                    L_0x0491:
                        int r12 = r25 + 1
                        r17 = r2
                        r5 = r19
                        r6 = r23
                        r14 = r24
                        r9 = r27
                        r4 = r28
                        r7 = r29
                        r2 = r30
                        r13 = r32
                        r15 = r33
                        r19 = r8
                        r8 = r31
                        goto L_0x00cb
                    L_0x04ad:
                        r5 = r0
                        r9 = r22
                        net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity$UTDGraphicFragment r0 = net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity.UTDGraphicFragment.this     // Catch:{ Exception -> 0x0033 }
                        androidx.fragment.app.FragmentActivity r0 = r0.r()     // Catch:{ Exception -> 0x0033 }
                        android.view.WindowManager r0 = r0.getWindowManager()     // Catch:{ Exception -> 0x0033 }
                        android.view.Display r0 = r0.getDefaultDisplay()     // Catch:{ Exception -> 0x0033 }
                        android.util.DisplayMetrics r2 = new android.util.DisplayMetrics     // Catch:{ Exception -> 0x0033 }
                        r2.<init>()     // Catch:{ Exception -> 0x0033 }
                        r0.getMetrics(r2)     // Catch:{ Exception -> 0x0033 }
                        int r0 = r2.widthPixels     // Catch:{ Exception -> 0x0033 }
                        float r0 = (float) r0     // Catch:{ Exception -> 0x0033 }
                        float r2 = r2.density     // Catch:{ Exception -> 0x0033 }
                        float r0 = r0 / r2
                        r2 = 1109393408(0x42200000, float:40.0)
                        float r0 = r0 - r2
                        boolean r2 = r11.x1()     // Catch:{ Exception -> 0x0033 }
                        if (r2 == 0) goto L_0x04d7
                        float r0 = r0 * r18
                    L_0x04d7:
                        int r2 = (r20 > r18 ? 1 : (r20 == r18 ? 0 : -1))
                        if (r2 != 0) goto L_0x04ee
                        net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity$UTDGraphicFragment r2 = net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity.UTDGraphicFragment.this     // Catch:{ Exception -> 0x0033 }
                        float r2 = r2.f5     // Catch:{ Exception -> 0x0033 }
                        int r2 = (r2 > r18 ? 1 : (r2 == r18 ? 0 : -1))
                        if (r2 != 0) goto L_0x04e8
                        r20 = r0
                        goto L_0x04ee
                    L_0x04e8:
                        net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity$UTDGraphicFragment r0 = net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity.UTDGraphicFragment.this     // Catch:{ Exception -> 0x0033 }
                        float r0 = r0.f5     // Catch:{ Exception -> 0x0033 }
                    L_0x04ee:
                        java.lang.String r2 = "graphicViewer"
                        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0033 }
                        r3.<init>()     // Catch:{ Exception -> 0x0033 }
                        java.lang.String r4 = "Initial is : "
                        r3.append(r4)     // Catch:{ Exception -> 0x0033 }
                        float r0 = r0 / r20
                        r3.append(r0)     // Catch:{ Exception -> 0x0033 }
                        java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0033 }
                        net.imedicaldoctor.imd.iMDLogger.j(r2, r3)     // Catch:{ Exception -> 0x0033 }
                        boolean r2 = r11.x1()     // Catch:{ Exception -> 0x0033 }
                        java.lang.String r3 = "[initial]"
                        java.lang.String r4 = "UTDGraphicHeader.css"
                        if (r2 == 0) goto L_0x052e
                        net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity$UTDGraphicFragment r0 = net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity.UTDGraphicFragment.this     // Catch:{ Exception -> 0x0033 }
                        androidx.fragment.app.FragmentActivity r2 = r0.r()     // Catch:{ Exception -> 0x0033 }
                        java.lang.String r0 = r0.d4(r2, r4)     // Catch:{ Exception -> 0x0033 }
                        net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity$UTDGraphicFragment r2 = net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity.UTDGraphicFragment.this     // Catch:{ Exception -> 0x0033 }
                        java.lang.String[] r2 = r2.a5     // Catch:{ Exception -> 0x0033 }
                        r4 = 0
                        r2 = r2[r4]     // Catch:{ Exception -> 0x0033 }
                        java.lang.String r0 = r0.replace(r5, r2)     // Catch:{ Exception -> 0x0033 }
                        r2 = r16
                        java.lang.String r0 = r0.replace(r3, r2)     // Catch:{ Exception -> 0x0033 }
                        goto L_0x054d
                    L_0x052e:
                        net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity$UTDGraphicFragment r2 = net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity.UTDGraphicFragment.this     // Catch:{ Exception -> 0x0033 }
                        androidx.fragment.app.FragmentActivity r6 = r2.r()     // Catch:{ Exception -> 0x0033 }
                        java.lang.String r2 = r2.d4(r6, r4)     // Catch:{ Exception -> 0x0033 }
                        net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity$UTDGraphicFragment r4 = net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity.UTDGraphicFragment.this     // Catch:{ Exception -> 0x0033 }
                        java.lang.String[] r4 = r4.a5     // Catch:{ Exception -> 0x0033 }
                        r6 = 0
                        r4 = r4[r6]     // Catch:{ Exception -> 0x0033 }
                        java.lang.String r2 = r2.replace(r5, r4)     // Catch:{ Exception -> 0x0033 }
                        java.lang.String r0 = java.lang.Float.toString(r0)     // Catch:{ Exception -> 0x0033 }
                        java.lang.String r0 = r2.replace(r3, r0)     // Catch:{ Exception -> 0x0033 }
                    L_0x054d:
                        net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity$UTDGraphicFragment r2 = net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity.UTDGraphicFragment.this     // Catch:{ Exception -> 0x0033 }
                        androidx.fragment.app.FragmentActivity r3 = r2.r()     // Catch:{ Exception -> 0x0033 }
                        java.lang.String r4 = "UTDGraphicFooter.css"
                        java.lang.String r2 = r2.d4(r3, r4)     // Catch:{ Exception -> 0x0033 }
                        java.text.SimpleDateFormat r3 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x0033 }
                        java.lang.String r4 = "yyyy"
                        r3.<init>(r4)     // Catch:{ Exception -> 0x0033 }
                        java.lang.String r4 = "[year]"
                        java.util.Date r5 = new java.util.Date     // Catch:{ Exception -> 0x0033 }
                        r5.<init>()     // Catch:{ Exception -> 0x0033 }
                        java.lang.String r3 = r3.format(r5)     // Catch:{ Exception -> 0x0033 }
                        java.lang.String r2 = r2.replace(r4, r3)     // Catch:{ Exception -> 0x0033 }
                        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0033 }
                        r3.<init>()     // Catch:{ Exception -> 0x0033 }
                        r3.append(r0)     // Catch:{ Exception -> 0x0033 }
                        r3.append(r9)     // Catch:{ Exception -> 0x0033 }
                        r3.append(r2)     // Catch:{ Exception -> 0x0033 }
                        java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x0033 }
                        net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity$UTDGraphicFragment r2 = net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity.UTDGraphicFragment.this     // Catch:{ Exception -> 0x0033 }
                        r2.A4 = r0     // Catch:{ Exception -> 0x0033 }
                        goto L_0x0598
                    L_0x0586:
                        com.google.firebase.crashlytics.FirebaseCrashlytics r2 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()
                        r2.g(r0)
                        r0.printStackTrace()
                        net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity$UTDGraphicFragment r2 = net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity.UTDGraphicFragment.this
                        java.lang.String r0 = r0.getLocalizedMessage()
                        r2.p4 = r0
                    L_0x0598:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity.UTDGraphicFragment.AnonymousClass2.run():void");
                }
            }, new Runnable() {
                public void run() {
                    AlertDialog.Builder s2;
                    DialogInterface.OnClickListener r2;
                    String str = UTDGraphicFragment.this.p4;
                    if (str == null || str.length() <= 0) {
                        UTDGraphicFragment uTDGraphicFragment = UTDGraphicFragment.this;
                        uTDGraphicFragment.G4.loadDataWithBaseURL("file:///android_asset/", uTDGraphicFragment.A4, NanoHTTPD.p, "utf-8", (String) null);
                        UTDGraphicFragment.this.s4();
                        UTDGraphicFragment.this.p4();
                        UTDGraphicFragment.this.f3(R.menu.f1484menu_utdgraphic);
                        UTDGraphicFragment.this.o2(false);
                        UTDGraphicFragment.this.G3();
                        UTDGraphicFragment.this.j5();
                        return;
                    }
                    if (UTDGraphicFragment.this.p4.equals(IcyHeaders.a3)) {
                        s2 = new AlertDialog.Builder(UTDGraphicFragment.this.r(), R.style.f2185alertDialogTheme).l("The database is corrupt . it may happen after delta update or as a result of bad installation or a cleaner app in your device . you must delete and redownload this database. what do you want to do ?").p("Delete", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                new AlertDialog.Builder(UTDGraphicFragment.this.r(), R.style.f2185alertDialogTheme).l("Are you sure ? this will delete uptodate database ...").y("Yes", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogInterface, int i2) {
                                        UTDGraphicFragment.this.Q2(new File(UTDGraphicFragment.this.D4.getString("Path")));
                                        LocalBroadcastManager.b(UTDGraphicFragment.this.r()).d(new Intent("reload"));
                                        UTDGraphicFragment.this.Q4.Z1(false);
                                        UTDGraphicFragment.this.Q4.Z1(true);
                                    }
                                }).p("No", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogInterface, int i2) {
                                    }
                                }).I();
                            }
                        }).s("More Info", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                UTDGraphicFragment.this.a4("http://imedicaldoctor.net/faq#null");
                                UTDGraphicFragment.this.Q4.W1(false);
                            }
                        });
                        r2 = new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i2) {
                            }
                        };
                    } else if (UTDGraphicFragment.this.p4.equals(ExifInterface.Y4)) {
                        s2 = new AlertDialog.Builder(UTDGraphicFragment.this.r(), R.style.f2185alertDialogTheme).l("Document can't be found . if this happens a lot your database is corrupted . it may happen after delta update . you must delete and redownload this database. what do you want to do ?").p("Delete", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                new AlertDialog.Builder(UTDGraphicFragment.this.r(), R.style.f2185alertDialogTheme).l("Are you sure ? this will delete uptodate database ...").y("Yes", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogInterface, int i2) {
                                        UTDGraphicFragment.this.Q2(new File(UTDGraphicFragment.this.D4.getString("Path")));
                                        LocalBroadcastManager.b(UTDGraphicFragment.this.r()).d(new Intent("reload"));
                                        UTDGraphicFragment.this.Q4.Z1(true);
                                        UTDGraphicFragment.this.Q4.Z1(false);
                                    }
                                }).p("No", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogInterface, int i2) {
                                    }
                                }).I();
                            }
                        }).s("More Info", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                UTDGraphicFragment.this.a4("http://imedicaldoctor.net/faq#null");
                                UTDGraphicFragment.this.Q4.W1(false);
                            }
                        });
                        r2 = new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i2) {
                            }
                        };
                    } else {
                        UTDGraphicFragment uTDGraphicFragment2 = UTDGraphicFragment.this;
                        uTDGraphicFragment2.C4(uTDGraphicFragment2.p4);
                        return;
                    }
                    s2.y("OK", r2).I();
                }
            });
        }

        public String R2() {
            BufferedSink d2;
            try {
                ArrayList<String> arrayList = this.c5;
                if (arrayList != null) {
                    if (arrayList.size() != 0) {
                        int nextInt = new Random().nextInt(this.c5.size());
                        if (this.c5.size() - 1 < 0) {
                            return null;
                        }
                        String str = this.c5.get(nextInt);
                        String g1 = CompressHelper.g1(this.D4, "background.png");
                        File file = new File(g1);
                        if (file.exists()) {
                            file.delete();
                            Log.e("Deleted", "deleted");
                        }
                        d2 = Okio.d(Okio.n(file));
                        d2.write(Base64.decode(str, 0));
                        d2.flush();
                        d2.close();
                        return g1;
                    }
                }
                return null;
            } catch (Exception e2) {
                FirebaseCrashlytics.d().g(e2);
                return null;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
            throw th;
        }

        public void T0(Menu menu, MenuInflater menuInflater) {
            menuInflater.inflate(R.menu.f1484menu_utdgraphic, menu);
            q4(menu);
            e3(menu);
        }

        public View onFragmentBind(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View view = this.C4;
            if (view != null) {
                return view;
            }
            this.e5 = new ArrayList<>();
            View inflate = layoutInflater.inflate(R.layout.f1255fragment_new_viewer, viewGroup, false);
            this.C4 = inflate;
            r4(inflate, bundle);
            this.T4 = new Runnable() {
                public void run() {
                    BufferedSource e2;
                    BufferedSink d2;
                    CompressHelper.x2(UTDGraphicFragment.this.r(), "Download Completed", 1);
                    try {
                        File file = new File(UTDGraphicFragment.this.j5);
                        if (file.exists()) {
                            e2 = Okio.e(Okio.t(file));
                            byte[] b0 = e2.b0();
                            e2.close();
                            String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(UTDGraphicFragment.this.i5, "/");
                            byte[] x = UTDGraphicFragment.this.Q4.x(b0, splitByWholeSeparator[splitByWholeSeparator.length - 1], "127");
                            d2 = Okio.d(Okio.n(new File(UTDGraphicFragment.this.i5)));
                            d2.write(x);
                            d2.close();
                            new File(UTDGraphicFragment.this.i5).deleteOnExit();
                            boolean unused = UTDGraphicFragment.this.g5 = true;
                            UTDGraphicFragment uTDGraphicFragment = UTDGraphicFragment.this;
                            String unused2 = uTDGraphicFragment.h5 = uTDGraphicFragment.i5;
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    } catch (Throwable th) {
                        th.addSuppressed(th);
                    }
                    UTDGraphicFragment.this.F3();
                    return;
                    throw th;
                    throw th;
                }
            };
            if (y() == null) {
                return this.C4;
            }
            if (bundle != null) {
                this.c5 = bundle.getStringArrayList("mBase64Images");
                this.d5 = bundle.getStringArrayList("mBase64ImageNames");
                this.b5 = bundle.getStringArrayList("mRelatedTopics");
                this.g5 = bundle.getBoolean("mIsVideo");
                this.h5 = bundle.getString("mVideoPath");
                this.i5 = bundle.getString("mVideoSavePath");
            }
            String[] stringArray = y().getStringArray("IDS");
            this.a5 = stringArray;
            String join = TextUtils.join(";", stringArray);
            this.E4 = "Graphic-" + join;
            if (y().containsKey("AllGraphics")) {
                this.Y4 = y().getStringArrayList("AllGraphics");
            }
            if (y().containsKey("GraphicIndex")) {
                this.Z4 = Integer.valueOf(y().getString("GraphicIndex")).intValue();
            }
            c3();
            M4();
            return this.C4;
        }

        public boolean e1(MenuItem menuItem) {
            BufferedSink d2;
            BufferedSource e2;
            BufferedSink d3;
            int itemId = menuItem.getItemId();
            if (itemId == R.id.f813action_save_gallery) {
                if (this.g5) {
                    new File(this.h5);
                    try {
                        e2 = Okio.e(Okio.t(new File(this.h5)));
                        d3 = Okio.d(Okio.n(new File(this.i5)));
                        d3.y1(e2);
                        d3.close();
                        if (e2 != null) {
                            e2.close();
                        }
                    } catch (IOException e3) {
                        String cls = getClass().toString();
                        iMDLogger.f(cls, "Error in copying " + this.h5 + " to " + this.i5);
                        e3.printStackTrace();
                    } catch (Throwable th) {
                        th.addSuppressed(th);
                    }
                    MediaScannerConnection.scanFile(r(), new String[]{this.i5}, (String[]) null, (MediaScannerConnection.OnScanCompletedListener) null);
                    d5(this.i5, r());
                } else {
                    for (int i2 = 0; i2 < this.c5.size(); i2++) {
                        String str = this.c5.get(i2);
                        String[] split = this.d5.get(i2).split("/");
                        String g1 = CompressHelper.g1(this.D4, split[split.length - 1]);
                        try {
                            d2 = Okio.d(Okio.n(new File(g1)));
                            d2.write(Base64.decode(str, 0));
                            d2.flush();
                            d2.close();
                        } catch (IOException e4) {
                            String cls2 = getClass().toString();
                            iMDLogger.f(cls2, "Error in writing to " + g1);
                            e4.printStackTrace();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        MediaScannerConnection.scanFile(r(), new String[]{g1}, (String[]) null, (MediaScannerConnection.OnScanCompletedListener) null);
                        c5(g1, r());
                    }
                }
            }
            if (itemId == R.id.f810action_related_topics) {
                String join = TextUtils.join(",", this.b5);
                UTDRelatedTopics2Fragment uTDRelatedTopics2Fragment = new UTDRelatedTopics2Fragment();
                Bundle bundle = new Bundle();
                bundle.putString("RELATED", join);
                bundle.putBundle("db", this.D4);
                uTDRelatedTopics2Fragment.i2(bundle);
                uTDRelatedTopics2Fragment.A2(this, 0);
                uTDRelatedTopics2Fragment.e3(M(), "related");
                return true;
            }
            if (itemId == R.id.f805action_previous) {
                h5();
            }
            if (itemId == R.id.f803action_next) {
                f5();
            }
            return super.e1(menuItem);
            throw th;
            throw th;
            throw th;
        }

        public void e3(Menu menu) {
            MenuItem findItem = menu.findItem(R.id.f810action_related_topics);
            if (this.b5.size() == 0) {
                findItem.setVisible(false);
            }
        }

        public void e5(String str) {
            CompressHelper compressHelper = new CompressHelper(r());
            Bundle bundle = this.D4;
            compressHelper.A1(bundle, "Topic-" + str, (String[]) null, (String) null);
        }

        public void f5() {
            int i2 = this.Z4 + 1;
            if (i2 <= this.Y4.size() - 1) {
                this.Z4 = i2;
                String[] strArr = {this.Y4.get(i2)};
                this.a5 = strArr;
                String join = TextUtils.join(";", strArr);
                this.E4 = "Graphic-" + join;
                this.X4 = true;
                M4();
            }
            j5();
        }

        public void h5() {
            int i2 = this.Z4 - 1;
            if (i2 >= 0) {
                this.Z4 = i2;
                String[] strArr = {this.Y4.get(i2)};
                this.a5 = strArr;
                this.E4 = "Graphic-" + TextUtils.join(";", strArr);
                this.X4 = true;
                M4();
            }
            j5();
        }

        public void j5() {
            if (this.Y4 == null) {
                I4();
                J4();
                return;
            }
            K4();
            L4();
            if (this.Z4 <= 0) {
                I4();
            }
            if (this.Z4 >= this.Y4.size() - 1) {
                J4();
            }
        }

        public void m1(Bundle bundle) {
            super.m1(bundle);
        }

        public boolean y4(WebView webView, String str, String str2, String str3) {
            iMDLogger.j("URL Requested", str);
            Uri.parse(str);
            if (str2.equals("image")) {
                i5(str3.substring(2));
                return true;
            }
            if (str2.equals("video")) {
                if (this.h5.equals("")) {
                    String[] split = StringUtils.split(this.i5, "/");
                    String str4 = split[split.length - 1];
                    Z2(this.Q4.getBaseUrl() + "/videos-E/" + str4, this.D4.getString("Path") + "/videos-E/" + str4);
                } else {
                    iMDLogger.f("Video Path ", this.h5);
                    g5(this.h5);
                }
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.f1175activity_general_viewer);
        Y0(new UTDGraphicFragment(), bundle);
    }
}
