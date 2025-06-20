package net.imedicaldoctor.imd.Fragments.Elsevier;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.itextpdf.text.Annotation;
import java.util.ArrayList;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.ViewerHelperActivity;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.Gallery.GalleryActivity;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.iMDLogger;
import org.apache.commons.lang3.StringUtils;

public class ELSViewerActivity extends ViewerHelperActivity {

    public static class ELSViewerFragment extends ViewerHelperFragment {
        /* access modifiers changed from: private */
        public String X4;
        private MenuItem Y4;
        public ArrayList<Bundle> Z4;
        public ArrayList<Bundle> a5;

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x016d A[Catch:{ Exception -> 0x0160 }] */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x0186 A[Catch:{ Exception -> 0x0184 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void I4() {
            /*
                r22 = this;
                r1 = r22
                java.lang.String r2 = "descriptionSimple"
                java.lang.String r3 = "resource"
                java.lang.String r4 = "id"
                net.imedicaldoctor.imd.Data.CompressHelper r5 = new net.imedicaldoctor.imd.Data.CompressHelper
                androidx.fragment.app.FragmentActivity r0 = r22.r()
                r5.<init>(r0)
                android.os.Bundle r0 = r1.D4
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r7 = "Select rowid as _id, * from images where docId="
                r6.append(r7)
                java.lang.String r7 = r1.E4
                r6.append(r7)
                java.lang.String r6 = r6.toString()
                java.util.ArrayList r0 = r5.V(r0, r6)
                java.util.ArrayList r6 = new java.util.ArrayList
                r6.<init>()
                r1.Z4 = r6
                java.util.ArrayList r6 = new java.util.ArrayList
                r6.<init>()
                r1.a5 = r6
                java.lang.String r6 = " . error "
                java.lang.String r7 = "Error in loading "
                java.lang.String r8 = "ImagePath"
                java.lang.String r9 = "base"
                java.lang.String r10 = ".gif"
                java.lang.String r11 = ".jpg"
                java.lang.String r12 = "Images-E"
                java.lang.String r13 = "LoadResources"
                java.lang.String r15 = "127"
                if (r0 != 0) goto L_0x0058
                java.lang.String r0 = "No images to load"
                net.imedicaldoctor.imd.iMDLogger.j(r13, r0)
            L_0x0051:
                r20 = r9
                r19 = r10
                r13 = 0
                goto L_0x01e0
            L_0x0058:
                java.util.Iterator r16 = r0.iterator()
            L_0x005c:
                boolean r0 = r16.hasNext()
                if (r0 == 0) goto L_0x0051
                java.lang.Object r0 = r16.next()
                r14 = r0
                android.os.Bundle r14 = (android.os.Bundle) r14
                android.os.Bundle r0 = r1.D4
                r17 = r13
                java.lang.String r13 = "imageName"
                r18 = r6
                java.lang.String r6 = r14.getString(r13)
                java.lang.String r0 = net.imedicaldoctor.imd.Data.CompressHelper.h1(r0, r6, r12)
                java.io.File r6 = new java.io.File
                r6.<init>(r0)
                boolean r6 = r6.exists()
                if (r6 != 0) goto L_0x0088
                java.lang.String r0 = r0.replace(r11, r10)
            L_0x0088:
                r6 = r0
                java.io.File r0 = new java.io.File
                r0.<init>(r6)
                boolean r0 = r0.exists()
                if (r0 != 0) goto L_0x0099
                r13 = r17
                r6 = r18
                goto L_0x005c
            L_0x0099:
                java.io.File r0 = new java.io.File
                r0.<init>(r6)
                r19 = r10
                android.os.Bundle r10 = r1.D4     // Catch:{ Exception -> 0x01ad }
                java.lang.String r13 = r14.getString(r13)     // Catch:{ Exception -> 0x01ad }
                java.lang.String r10 = net.imedicaldoctor.imd.Data.CompressHelper.h1(r10, r13, r9)     // Catch:{ Exception -> 0x01ad }
                java.io.File r13 = new java.io.File     // Catch:{ Exception -> 0x01ad }
                r13.<init>(r10)     // Catch:{ Exception -> 0x01ad }
                boolean r13 = r13.exists()     // Catch:{ Exception -> 0x01ad }
                if (r13 != 0) goto L_0x00e2
                byte[] r13 = net.imedicaldoctor.imd.Data.CompressHelper.d2(r0)     // Catch:{ Exception -> 0x00de }
                r0.getName()     // Catch:{ Exception -> 0x00de }
                r20 = r9
                java.lang.String r9 = r0.getName()     // Catch:{ Exception -> 0x00d8 }
                byte[] r9 = r5.w(r13, r9, r15)     // Catch:{ Exception -> 0x00d8 }
                java.lang.String r13 = "Decrypting "
                java.lang.String r0 = r0.getName()     // Catch:{ Exception -> 0x00d8 }
                android.util.Log.e(r13, r0)     // Catch:{ Exception -> 0x00d8 }
                java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x00d8 }
                r0.<init>(r10)     // Catch:{ Exception -> 0x00d8 }
                net.imedicaldoctor.imd.Data.CompressHelper.D2(r0, r9)     // Catch:{ Exception -> 0x00d8 }
                goto L_0x00e4
            L_0x00d8:
                r0 = move-exception
            L_0x00d9:
                r21 = r2
            L_0x00db:
                r13 = 0
                goto L_0x01b4
            L_0x00de:
                r0 = move-exception
                r20 = r9
                goto L_0x00d9
            L_0x00e2:
                r20 = r9
            L_0x00e4:
                android.os.Bundle r9 = new android.os.Bundle     // Catch:{ Exception -> 0x00d8 }
                r9.<init>()     // Catch:{ Exception -> 0x00d8 }
                r9.putString(r8, r10)     // Catch:{ Exception -> 0x00d8 }
                java.lang.String r0 = r14.getString(r4)     // Catch:{ Exception -> 0x00d8 }
                r9.putString(r4, r0)     // Catch:{ Exception -> 0x00d8 }
                java.lang.String r10 = ""
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d8 }
                r0.<init>()     // Catch:{ Exception -> 0x00d8 }
                r0.append(r3)     // Catch:{ Exception -> 0x00d8 }
                java.lang.String r13 = r14.getString(r4)     // Catch:{ Exception -> 0x00d8 }
                r0.append(r13)     // Catch:{ Exception -> 0x00d8 }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00d8 }
                java.lang.Boolean r0 = r1.E3(r0)     // Catch:{ Exception -> 0x00d8 }
                boolean r0 = r0.booleanValue()     // Catch:{ Exception -> 0x00d8 }
                if (r0 == 0) goto L_0x012e
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d8 }
                r0.<init>()     // Catch:{ Exception -> 0x00d8 }
                r0.append(r3)     // Catch:{ Exception -> 0x00d8 }
                java.lang.String r10 = r14.getString(r4)     // Catch:{ Exception -> 0x00d8 }
                r0.append(r10)     // Catch:{ Exception -> 0x00d8 }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00d8 }
                java.lang.String r0 = r1.y3(r0)     // Catch:{ Exception -> 0x00d8 }
                r21 = r2
                r13 = 0
                goto L_0x019e
            L_0x012e:
                java.lang.String r0 = r14.getString(r2)     // Catch:{ Exception -> 0x00d8 }
                if (r0 == 0) goto L_0x0163
                java.lang.String r0 = r14.getString(r2)     // Catch:{ Exception -> 0x00d8 }
                int r0 = r0.length()     // Catch:{ Exception -> 0x00d8 }
                if (r0 <= 0) goto L_0x0163
                java.lang.String r0 = new java.lang.String     // Catch:{ Exception -> 0x0155 }
                java.lang.String r13 = r14.getString(r2)     // Catch:{ Exception -> 0x0155 }
                r21 = r2
                java.lang.String r2 = r14.getString(r4)     // Catch:{ Exception -> 0x0153 }
                byte[] r2 = r5.v(r13, r2, r15)     // Catch:{ Exception -> 0x0153 }
                r0.<init>(r2)     // Catch:{ Exception -> 0x0153 }
                r10 = r0
                goto L_0x0165
            L_0x0153:
                r0 = move-exception
                goto L_0x0158
            L_0x0155:
                r0 = move-exception
                r21 = r2
            L_0x0158:
                com.google.firebase.crashlytics.FirebaseCrashlytics r2 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()     // Catch:{ Exception -> 0x0160 }
                r2.g(r0)     // Catch:{ Exception -> 0x0160 }
                goto L_0x0165
            L_0x0160:
                r0 = move-exception
                goto L_0x00db
            L_0x0163:
                r21 = r2
            L_0x0165:
                int r0 = r10.length()     // Catch:{ Exception -> 0x0160 }
                r2 = 1024(0x400, float:1.435E-42)
                if (r0 <= r2) goto L_0x0186
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0160 }
                r0.<init>()     // Catch:{ Exception -> 0x0160 }
                r13 = 0
                java.lang.String r2 = r10.substring(r13, r2)     // Catch:{ Exception -> 0x0184 }
                r0.append(r2)     // Catch:{ Exception -> 0x0184 }
                java.lang.String r2 = "..."
                r0.append(r2)     // Catch:{ Exception -> 0x0184 }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0184 }
                goto L_0x0188
            L_0x0184:
                r0 = move-exception
                goto L_0x01b4
            L_0x0186:
                r13 = 0
                r0 = r10
            L_0x0188:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0184 }
                r2.<init>()     // Catch:{ Exception -> 0x0184 }
                r2.append(r3)     // Catch:{ Exception -> 0x0184 }
                java.lang.String r10 = r14.getString(r4)     // Catch:{ Exception -> 0x0184 }
                r2.append(r10)     // Catch:{ Exception -> 0x0184 }
                java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0184 }
                r1.b3(r2, r0)     // Catch:{ Exception -> 0x0184 }
            L_0x019e:
                java.lang.String r2 = "Description"
                r9.putString(r2, r0)     // Catch:{ Exception -> 0x0184 }
                java.util.ArrayList<android.os.Bundle> r0 = r1.Z4     // Catch:{ Exception -> 0x0184 }
                r0.add(r9)     // Catch:{ Exception -> 0x0184 }
                r2 = r17
                r6 = r18
                goto L_0x01d7
            L_0x01ad:
                r0 = move-exception
                r21 = r2
                r20 = r9
                goto L_0x00db
            L_0x01b4:
                r0.printStackTrace()
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                r2.append(r7)
                r2.append(r6)
                r6 = r18
                r2.append(r6)
                java.lang.String r0 = r0.getLocalizedMessage()
                r2.append(r0)
                java.lang.String r0 = r2.toString()
                r2 = r17
                net.imedicaldoctor.imd.iMDLogger.f(r2, r0)
            L_0x01d7:
                r13 = r2
                r10 = r19
                r9 = r20
                r2 = r21
                goto L_0x005c
            L_0x01e0:
                java.lang.String r0 = r1.X4
                int r0 = r0.length()
                if (r0 != 0) goto L_0x01e9
                return
            L_0x01e9:
                java.lang.String r0 = r1.X4
                java.lang.String r2 = ","
                java.lang.String[] r2 = android.text.TextUtils.split(r0, r2)
                int r3 = r2.length
                r4 = 0
            L_0x01f3:
                if (r4 >= r3) goto L_0x02a9
                r0 = r2[r4]
                android.os.Bundle r9 = r1.D4
                java.lang.String r9 = net.imedicaldoctor.imd.Data.CompressHelper.h1(r9, r0, r12)
                java.io.File r10 = new java.io.File
                r10.<init>(r9)
                boolean r10 = r10.exists()
                if (r10 != 0) goto L_0x020f
                r10 = r19
                java.lang.String r9 = r9.replace(r11, r10)
                goto L_0x0211
            L_0x020f:
                r10 = r19
            L_0x0211:
                java.io.File r14 = new java.io.File
                r14.<init>(r9)
                boolean r14 = r14.exists()
                if (r14 != 0) goto L_0x0222
                r16 = r2
                r2 = r20
                goto L_0x029e
            L_0x0222:
                java.io.File r14 = new java.io.File
                r14.<init>(r9)
                android.os.Bundle r13 = r1.D4     // Catch:{ Exception -> 0x0274 }
                r16 = r2
                r2 = r20
                java.lang.String r0 = net.imedicaldoctor.imd.Data.CompressHelper.h1(r13, r0, r2)     // Catch:{ Exception -> 0x025c }
                java.io.File r13 = new java.io.File     // Catch:{ Exception -> 0x025c }
                r13.<init>(r0)     // Catch:{ Exception -> 0x025c }
                boolean r13 = r13.exists()     // Catch:{ Exception -> 0x025c }
                if (r13 != 0) goto L_0x0266
                byte[] r13 = net.imedicaldoctor.imd.Data.CompressHelper.d2(r14)     // Catch:{ Exception -> 0x025c }
                java.lang.String r14 = r14.getName()     // Catch:{ Exception -> 0x025c }
                byte[] r13 = r5.w(r13, r14, r15)     // Catch:{ Exception -> 0x025c }
                java.io.File r14 = new java.io.File     // Catch:{ Exception -> 0x025c }
                r14.<init>(r0)     // Catch:{ Exception -> 0x025c }
                boolean r14 = r14.exists()     // Catch:{ Exception -> 0x025c }
                if (r14 == 0) goto L_0x025e
                java.io.File r14 = new java.io.File     // Catch:{ Exception -> 0x025c }
                r14.<init>(r0)     // Catch:{ Exception -> 0x025c }
                r14.delete()     // Catch:{ Exception -> 0x025c }
                goto L_0x025e
            L_0x025c:
                r0 = move-exception
                goto L_0x0279
            L_0x025e:
                java.io.File r14 = new java.io.File     // Catch:{ Exception -> 0x025c }
                r14.<init>(r0)     // Catch:{ Exception -> 0x025c }
                net.imedicaldoctor.imd.Data.CompressHelper.D2(r14, r13)     // Catch:{ Exception -> 0x025c }
            L_0x0266:
                android.os.Bundle r13 = new android.os.Bundle     // Catch:{ Exception -> 0x025c }
                r13.<init>()     // Catch:{ Exception -> 0x025c }
                r13.putString(r8, r0)     // Catch:{ Exception -> 0x025c }
                java.util.ArrayList<android.os.Bundle> r0 = r1.a5     // Catch:{ Exception -> 0x025c }
                r0.add(r13)     // Catch:{ Exception -> 0x025c }
                goto L_0x029e
            L_0x0274:
                r0 = move-exception
                r16 = r2
                r2 = r20
            L_0x0279:
                com.google.firebase.crashlytics.FirebaseCrashlytics r13 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()
                r13.g(r0)
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>()
                r13.append(r7)
                r13.append(r9)
                r13.append(r6)
                java.lang.String r0 = r0.getLocalizedMessage()
                r13.append(r0)
                java.lang.String r0 = r13.toString()
                java.lang.String r9 = "LoadResourcesOther"
                net.imedicaldoctor.imd.iMDLogger.f(r9, r0)
            L_0x029e:
                int r4 = r4 + 1
                r20 = r2
                r19 = r10
                r2 = r16
                r13 = 0
                goto L_0x01f3
            L_0x02a9:
                android.view.MenuItem r0 = r1.Y4
                if (r0 == 0) goto L_0x02c2
                java.util.ArrayList<android.os.Bundle> r2 = r1.Z4
                int r2 = r2.size()
                java.util.ArrayList<android.os.Bundle> r3 = r1.a5
                int r3 = r3.size()
                int r2 = r2 + r3
                if (r2 == 0) goto L_0x02be
                r14 = 1
                goto L_0x02bf
            L_0x02be:
                r14 = 0
            L_0x02bf:
                r0.setVisible(r14)
            L_0x02c2:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity.ELSViewerFragment.I4():void");
        }

        public static void M4(StringBuilder sb, String str, String str2) {
            while (true) {
                int lastIndexOf = sb.lastIndexOf(str);
                if (lastIndexOf != -1) {
                    sb.replace(lastIndexOf, str.length() + lastIndexOf, str2);
                } else {
                    return;
                }
            }
        }

        private void N4(String str) {
            Intent intent;
            ArrayList<Bundle> arrayList = this.Z4;
            Class<GalleryActivity> cls = GalleryActivity.class;
            if (arrayList == null || arrayList.size() == 0) {
                ArrayList arrayList2 = new ArrayList();
                Bundle bundle = new Bundle();
                bundle.putString("id", str);
                Bundle bundle2 = this.D4;
                bundle.putString("ImagePath", CompressHelper.h1(bundle2, str + ".jpg", "base"));
                bundle.putString("Description", "");
                arrayList2.add(bundle);
                intent = new Intent(r(), cls);
                intent.putExtra("Images", arrayList2);
                intent.putExtra("Start", 0);
            } else {
                int i2 = 0;
                for (int i3 = 0; i3 < this.Z4.size(); i3++) {
                    if (this.Z4.get(i3).getString("id").equals(str)) {
                        i2 = i3;
                    }
                }
                Log.e("Images count", "Images count" + this.Z4.size());
                intent = new Intent(r(), cls);
                intent.putExtra("Images", this.Z4);
                intent.putExtra("Start", i2);
            }
            D2(intent);
        }

        public boolean D3() {
            ArrayList<Bundle> arrayList = this.Z4;
            return (arrayList == null || arrayList.size() == 0) ? false : true;
        }

        public void L4(String str, Boolean bool) {
            StringBuilder sb;
            String str2;
            if (bool.booleanValue()) {
                sb = new StringBuilder();
                sb.append(str);
                str2 = " - Before";
            } else {
                sb = new StringBuilder();
                sb.append(str);
                str2 = " - After";
            }
            sb.append(str2);
            Log.e("TimeProfiler", sb.toString());
        }

        public String R2() {
            Bundle v3;
            ArrayList<Bundle> arrayList = this.Z4;
            if (arrayList == null || arrayList.size() <= 0 || (v3 = v3(this.Z4)) == null) {
                return null;
            }
            return v3.getString("ImagePath");
        }

        public View onFragmentBind(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View view = this.C4;
            if (view != null) {
                return view;
            }
            L4("OnCreateView", Boolean.TRUE);
            View inflate = layoutInflater.inflate(R.layout.f1255fragment_new_viewer, viewGroup, false);
            r4(inflate, bundle);
            if (bundle != null) {
                this.X4 = bundle.getString("mResources");
                this.Z4 = bundle.getParcelableArrayList("mImages");
                this.a5 = bundle.getParcelableArrayList("mOtherImages");
            }
            if (y() == null) {
                return inflate;
            }
            T2(new Runnable() {
                /* JADX WARNING: Removed duplicated region for block: B:23:0x0189 A[Catch:{ Exception -> 0x0026 }] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r14 = this;
                        java.lang.String r0 = "LoadResource"
                        java.lang.String r1 = "ng-click=\"loadPartial('openPane')\""
                        java.lang.String r2 = "QueryDB"
                        java.lang.String r3 = "eid://"
                        java.lang.String r4 = "javascript:app.eidLink"
                        java.lang.String r5 = "onclick=\"window.location='image://'+this.getElementsByTagName('img')[0].getAttribute('eid');\""
                        java.lang.String r6 = "_id"
                        net.imedicaldoctor.imd.Data.CompressHelper r7 = new net.imedicaldoctor.imd.Data.CompressHelper     // Catch:{ Exception -> 0x0026 }
                        net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity$ELSViewerFragment r8 = net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity.ELSViewerFragment.this     // Catch:{ Exception -> 0x0026 }
                        androidx.fragment.app.FragmentActivity r8 = r8.r()     // Catch:{ Exception -> 0x0026 }
                        r7.<init>(r8)     // Catch:{ Exception -> 0x0026 }
                        net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity$ELSViewerFragment r8 = net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity.ELSViewerFragment.this     // Catch:{ Exception -> 0x0026 }
                        java.lang.String r8 = r8.A4     // Catch:{ Exception -> 0x0026 }
                        if (r8 == 0) goto L_0x0029
                        int r8 = r8.length()     // Catch:{ Exception -> 0x0026 }
                        if (r8 != 0) goto L_0x0179
                        goto L_0x0029
                    L_0x0026:
                        r0 = move-exception
                        goto L_0x01b5
                    L_0x0029:
                        net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity$ELSViewerFragment r8 = net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity.ELSViewerFragment.this     // Catch:{ Exception -> 0x0026 }
                        java.lang.Boolean r9 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0026 }
                        r8.L4(r2, r9)     // Catch:{ Exception -> 0x0026 }
                        net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity$ELSViewerFragment r8 = net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity.ELSViewerFragment.this     // Catch:{ Exception -> 0x0026 }
                        android.os.Bundle r8 = r8.D4     // Catch:{ Exception -> 0x0026 }
                        java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0026 }
                        r10.<init>()     // Catch:{ Exception -> 0x0026 }
                        java.lang.String r11 = "Select id as _id,* from Docs where id="
                        r10.append(r11)     // Catch:{ Exception -> 0x0026 }
                        net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity$ELSViewerFragment r11 = net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity.ELSViewerFragment.this     // Catch:{ Exception -> 0x0026 }
                        java.lang.String r11 = r11.E4     // Catch:{ Exception -> 0x0026 }
                        r10.append(r11)     // Catch:{ Exception -> 0x0026 }
                        java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x0026 }
                        android.os.Bundle r8 = r7.e0(r8, r10)     // Catch:{ Exception -> 0x0026 }
                        if (r8 != 0) goto L_0x0056
                        net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity$ELSViewerFragment r0 = net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity.ELSViewerFragment.this     // Catch:{ Exception -> 0x0026 }
                        java.lang.String r1 = "Document doesn't exist"
                        r0.p4 = r1     // Catch:{ Exception -> 0x0026 }
                        return
                    L_0x0056:
                        net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity$ELSViewerFragment r10 = net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity.ELSViewerFragment.this     // Catch:{ Exception -> 0x0026 }
                        java.lang.Boolean r11 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x0026 }
                        r10.L4(r2, r11)     // Catch:{ Exception -> 0x0026 }
                        java.lang.String r2 = "mainContent"
                        java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0026 }
                        net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity$ELSViewerFragment r10 = net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity.ELSViewerFragment.this     // Catch:{ Exception -> 0x0026 }
                        java.lang.String r12 = "resources"
                        java.lang.String r12 = r8.getString(r12)     // Catch:{ Exception -> 0x0026 }
                        java.lang.String unused = r10.X4 = r12     // Catch:{ Exception -> 0x0026 }
                        net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity$ELSViewerFragment r10 = net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity.ELSViewerFragment.this     // Catch:{ Exception -> 0x0026 }
                        java.lang.String r12 = "name"
                        java.lang.String r12 = r8.getString(r12)     // Catch:{ Exception -> 0x0026 }
                        r10.F4 = r12     // Catch:{ Exception -> 0x0026 }
                        net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity$ELSViewerFragment r10 = net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity.ELSViewerFragment.this     // Catch:{ Exception -> 0x0026 }
                        java.lang.String r12 = r8.getString(r6)     // Catch:{ Exception -> 0x0026 }
                        java.lang.Boolean r10 = r10.E3(r12)     // Catch:{ Exception -> 0x0026 }
                        boolean r10 = r10.booleanValue()     // Catch:{ Exception -> 0x0026 }
                        if (r10 == 0) goto L_0x0094
                        net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity$ELSViewerFragment r1 = net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity.ELSViewerFragment.this     // Catch:{ Exception -> 0x0026 }
                        java.lang.String r2 = r8.getString(r6)     // Catch:{ Exception -> 0x0026 }
                        java.lang.String r1 = r1.y3(r2)     // Catch:{ Exception -> 0x0026 }
                        goto L_0x0163
                    L_0x0094:
                        java.lang.String r10 = r8.getString(r6)     // Catch:{ Exception -> 0x0026 }
                        java.lang.String r12 = "127"
                        byte[] r2 = r7.v(r2, r10, r12)     // Catch:{ Exception -> 0x0026 }
                        java.lang.String r7 = new java.lang.String     // Catch:{ Exception -> 0x0026 }
                        r7.<init>(r2)     // Catch:{ Exception -> 0x0026 }
                        net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity$ELSViewerFragment r2 = net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity.ELSViewerFragment.this     // Catch:{ Exception -> 0x0026 }
                        androidx.fragment.app.FragmentActivity r10 = r2.r()     // Catch:{ Exception -> 0x0026 }
                        java.lang.String r12 = "ELSHeaderNew.css"
                        java.lang.String r2 = r2.d4(r10, r12)     // Catch:{ Exception -> 0x0026 }
                        net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity$ELSViewerFragment r10 = net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity.ELSViewerFragment.this     // Catch:{ Exception -> 0x0026 }
                        androidx.fragment.app.FragmentActivity r12 = r10.r()     // Catch:{ Exception -> 0x0026 }
                        java.lang.String r13 = "ELSFooterNew.css"
                        java.lang.String r10 = r10.d4(r12, r13)     // Catch:{ Exception -> 0x0026 }
                        java.lang.String r12 = "[size]"
                        java.lang.String r13 = "200"
                        java.lang.String r2 = r2.replace(r12, r13)     // Catch:{ Exception -> 0x0026 }
                        java.lang.String r12 = "[title]"
                        net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity$ELSViewerFragment r13 = net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity.ELSViewerFragment.this     // Catch:{ Exception -> 0x0026 }
                        java.lang.String r13 = r13.F4     // Catch:{ Exception -> 0x0026 }
                        java.lang.String r2 = r2.replace(r12, r13)     // Catch:{ Exception -> 0x0026 }
                        java.lang.String r12 = "<div class=\"table\""
                        java.lang.String r13 = "<div class=\"table\" style=\"width:90%%;overflow: scroll;\""
                        java.lang.String r7 = r7.replace(r12, r13)     // Catch:{ Exception -> 0x0026 }
                        java.lang.String r12 = "<div once-if=\"item.tables.length &gt; 0\""
                        java.lang.String r13 = "<div once-if=\"item.tables.length &gt; 0\" style=\"width:90%%;overflow: scroll;\""
                        java.lang.String r7 = r7.replace(r12, r13)     // Catch:{ Exception -> 0x0026 }
                        java.lang.String r12 = "<div once-if=\"bi.tables.length &gt; 0\""
                        java.lang.String r13 = "<div once-if=\"bi.tables.length &gt; 0\" style=\"width:90%%;overflow: scroll;\""
                        java.lang.String r7 = r7.replace(r12, r13)     // Catch:{ Exception -> 0x0026 }
                        java.lang.String r12 = "<div once-if=\"item.math\""
                        java.lang.String r13 = "<div once-if=\"item.math\" style=\"width:90%%;overflow: scroll;\""
                        java.lang.String r7 = r7.replace(r12, r13)     // Catch:{ Exception -> 0x0026 }
                        java.lang.String r7 = r7.replace(r1, r5)     // Catch:{ Exception -> 0x0026 }
                        java.lang.String r7 = r7.replace(r4, r3)     // Catch:{ Exception -> 0x0026 }
                        java.lang.String r12 = "<div class=\"inline-image figure\""
                        java.lang.String r13 = "<div class=\"inline-image figure\" style=\"width:90%%;overflow: scroll;\""
                        java.lang.String r7 = r7.replace(r12, r13)     // Catch:{ Exception -> 0x0026 }
                        java.lang.String r12 = "‍ng-click=\"loadPartial('openPane')\""
                        java.lang.String r7 = r7.replace(r12, r5)     // Catch:{ Exception -> 0x0026 }
                        java.lang.String r7 = r7.replace(r4, r3)     // Catch:{ Exception -> 0x0026 }
                        java.lang.String r12 = "#!"
                        java.lang.String r13 = "chapter:/"
                        java.lang.String r7 = r7.replace(r12, r13)     // Catch:{ Exception -> 0x0026 }
                        java.lang.String r1 = r7.replace(r1, r5)     // Catch:{ Exception -> 0x0026 }
                        java.lang.String r1 = r1.replace(r4, r3)     // Catch:{ Exception -> 0x0026 }
                        java.lang.String r3 = "See additional content on Expert Consult"
                        java.lang.String r4 = ""
                        java.lang.String r1 = r1.replace(r3, r4)     // Catch:{ Exception -> 0x0026 }
                        java.lang.String r3 = "c-ckc-bibliography"
                        int r3 = r1.indexOf(r3)     // Catch:{ Exception -> 0x0026 }
                        r4 = -1
                        if (r3 <= r4) goto L_0x0148
                        r4 = 0
                        java.lang.String r4 = r1.substring(r4, r3)     // Catch:{ Exception -> 0x0026 }
                        java.lang.String r1 = r1.substring(r3)     // Catch:{ Exception -> 0x0026 }
                        java.lang.String r3 = "ng-repeat=\"item in XocsCtrl.sections\""
                        java.lang.String r5 = "ng-repeat=\"item in XocsCtrl.sections\" style=\"display:none\""
                        java.lang.String r1 = r1.replace(r3, r5)     // Catch:{ Exception -> 0x0026 }
                        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0026 }
                        r3.<init>()     // Catch:{ Exception -> 0x0026 }
                        r3.append(r4)     // Catch:{ Exception -> 0x0026 }
                        r3.append(r1)     // Catch:{ Exception -> 0x0026 }
                        java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x0026 }
                    L_0x0148:
                        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0026 }
                        r3.<init>()     // Catch:{ Exception -> 0x0026 }
                        r3.append(r2)     // Catch:{ Exception -> 0x0026 }
                        r3.append(r1)     // Catch:{ Exception -> 0x0026 }
                        r3.append(r10)     // Catch:{ Exception -> 0x0026 }
                        java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x0026 }
                        net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity$ELSViewerFragment r2 = net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity.ELSViewerFragment.this     // Catch:{ Exception -> 0x0026 }
                        java.lang.String r3 = r8.getString(r6)     // Catch:{ Exception -> 0x0026 }
                        r2.b3(r3, r1)     // Catch:{ Exception -> 0x0026 }
                    L_0x0163:
                        net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity$ELSViewerFragment r2 = net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity.ELSViewerFragment.this     // Catch:{ Exception -> 0x0026 }
                        r2.m3()     // Catch:{ Exception -> 0x0026 }
                        net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity$ELSViewerFragment r2 = net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity.ELSViewerFragment.this     // Catch:{ Exception -> 0x0026 }
                        r2.A4 = r1     // Catch:{ Exception -> 0x0026 }
                        r2.L4(r0, r9)     // Catch:{ Exception -> 0x0026 }
                        net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity$ELSViewerFragment r1 = net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity.ELSViewerFragment.this     // Catch:{ Exception -> 0x0026 }
                        r1.I4()     // Catch:{ Exception -> 0x0026 }
                        net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity$ELSViewerFragment r1 = net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity.ELSViewerFragment.this     // Catch:{ Exception -> 0x0026 }
                        r1.L4(r0, r11)     // Catch:{ Exception -> 0x0026 }
                    L_0x0179:
                        net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity$ELSViewerFragment r0 = net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity.ELSViewerFragment.this     // Catch:{ Exception -> 0x0026 }
                        android.os.Bundle r0 = r0.D4     // Catch:{ Exception -> 0x0026 }
                        java.lang.String r1 = "base"
                        java.lang.String r0 = net.imedicaldoctor.imd.Data.CompressHelper.g1(r0, r1)     // Catch:{ Exception -> 0x0026 }
                        boolean r1 = net.imedicaldoctor.imd.iMD.a()     // Catch:{ Exception -> 0x0026 }
                        if (r1 == 0) goto L_0x01af
                        java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x0026 }
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0026 }
                        r2.<init>()     // Catch:{ Exception -> 0x0026 }
                        r2.append(r0)     // Catch:{ Exception -> 0x0026 }
                        java.lang.String r3 = "/test.html"
                        r2.append(r3)     // Catch:{ Exception -> 0x0026 }
                        java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0026 }
                        r1.<init>(r2)     // Catch:{ Exception -> 0x0026 }
                        boolean r2 = r1.exists()     // Catch:{ Exception -> 0x0026 }
                        if (r2 == 0) goto L_0x01a8
                        r1.delete()     // Catch:{ Exception -> 0x0026 }
                    L_0x01a8:
                        net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity$ELSViewerFragment r2 = net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity.ELSViewerFragment.this     // Catch:{ Exception -> 0x0026 }
                        java.lang.String r2 = r2.A4     // Catch:{ Exception -> 0x0026 }
                        net.imedicaldoctor.imd.Data.CompressHelper.E2(r1, r2)     // Catch:{ Exception -> 0x0026 }
                    L_0x01af:
                        net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity$ELSViewerFragment r1 = net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity.ELSViewerFragment.this     // Catch:{ Exception -> 0x0026 }
                        r1.h3(r0)     // Catch:{ Exception -> 0x0026 }
                        goto L_0x01c7
                    L_0x01b5:
                        com.google.firebase.crashlytics.FirebaseCrashlytics r1 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()
                        r1.g(r0)
                        r0.printStackTrace()
                        net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity$ELSViewerFragment r1 = net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity.ELSViewerFragment.this
                        java.lang.String r0 = r0.getLocalizedMessage()
                        r1.p4 = r0
                    L_0x01c7:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity.ELSViewerFragment.AnonymousClass1.run():void");
                }
            }, new Runnable() {
                public void run() {
                    String str = ELSViewerFragment.this.p4;
                    if (str == null || str.length() <= 0) {
                        ELSViewerFragment.this.s4();
                        String g1 = CompressHelper.g1(ELSViewerFragment.this.D4, "base");
                        ELSViewerFragment eLSViewerFragment = ELSViewerFragment.this;
                        eLSViewerFragment.O3(eLSViewerFragment.A4, g1);
                        ELSViewerFragment.this.p4();
                        ELSViewerFragment.this.f3(R.menu.f1411elsviewer2);
                        ELSViewerFragment.this.o2(false);
                        ELSViewerFragment.this.G3();
                        return;
                    }
                    ELSViewerFragment eLSViewerFragment2 = ELSViewerFragment.this;
                    eLSViewerFragment2.C4(eLSViewerFragment2.p4);
                }
            });
            return inflate;
        }

        public void Z3(WebView webView, String str) {
            super.Z3(webView, str);
        }

        public boolean e1(MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            if (itemId == R.id.f799action_gallery) {
                N4("soheilvb");
            }
            if (itemId == R.id.f801action_menu) {
                ELSSectionsViewer eLSSectionsViewer = new ELSSectionsViewer();
                Bundle bundle = new Bundle();
                bundle.putBundle("db", this.D4);
                bundle.putString("docId", this.E4);
                bundle.putString("parentId", "0");
                eLSSectionsViewer.i2(bundle);
                eLSSectionsViewer.Z2(true);
                eLSSectionsViewer.A2(this, 0);
                eLSSectionsViewer.e3(V(), "ELSSectionsViewer");
            }
            return super.e1(menuItem);
        }

        public void e3(Menu menu) {
            menu.findItem(R.id.f799action_gallery).setVisible(D3());
        }

        public void m1(Bundle bundle) {
            super.m1(bundle);
        }

        public boolean y4(WebView webView, String str, String str2, String str3) {
            String str4;
            iMDLogger.j("Override", "Url : " + str + ", Scheme : " + str2 + ", Resource : " + str3);
            if (str2.equals("image")) {
                N4(str3.substring(2));
                return true;
            } else if (str2.equals("chapter")) {
                CompressHelper compressHelper = new CompressHelper(r());
                String[] split = str3.split("/");
                String str5 = split[split.length - 1];
                if (str5.contains("?scroll")) {
                    str4 = StringUtils.splitByWholeSeparator(str5, "scrollTo=#")[1];
                    str5 = StringUtils.splitByWholeSeparator(str5, "?")[0];
                } else {
                    str4 = null;
                }
                Bundle e0 = compressHelper.e0(this.D4, "Select id from docs where eid='" + str5 + "'");
                if (e0 == null) {
                    CompressHelper.x2(r(), "No Document Found", 1);
                    return true;
                }
                compressHelper.A1(this.D4, e0.getString("id"), (String[]) null, str4);
                return true;
            } else if (!str2.equals(Annotation.k3) && (!str2.equals("http") || !str3.contains("localhost:"))) {
                return true;
            } else {
                String[] split2 = str3.split("/");
                C3(split2[split2.length - 1]);
                return true;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.f1175activity_general_viewer);
        Y0(new ELSViewerFragment(), bundle);
    }
}
