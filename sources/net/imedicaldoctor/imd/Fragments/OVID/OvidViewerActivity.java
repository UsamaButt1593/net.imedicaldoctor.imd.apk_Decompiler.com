package net.imedicaldoctor.imd.Fragments.OVID;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.itextpdf.tool.xml.html.HTML;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.ViewerHelperActivity;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.Gallery.GalleryActivity;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.iMDLogger;
import org.apache.commons.lang3.StringUtils;

public class OvidViewerActivity extends ViewerHelperActivity {

    public static class OvidViewerFragment extends ViewerHelperFragment {
        /* access modifiers changed from: private */
        public String X4;
        private MenuItem Y4;
        public ArrayList<Bundle> Z4;
        /* access modifiers changed from: private */
        public Bundle a5;
        private boolean b5;

        /* access modifiers changed from: private */
        public void I4() {
            String str;
            String str2;
            ArrayList arrayList;
            String str3;
            int i2;
            String[] strArr;
            String str4;
            String str5;
            ArrayList<Bundle> arrayList2;
            CompressHelper compressHelper = new CompressHelper(r());
            Bundle bundle = this.D4;
            ArrayList<Bundle> V = compressHelper.V(bundle, "Select rowid as _id, * from images where bookid='" + this.E4 + "'");
            ArrayList<Bundle> arrayList3 = new ArrayList<>();
            ArrayList arrayList4 = new ArrayList();
            if (V == null) {
                V = new ArrayList<>();
            }
            Iterator<Bundle> it2 = V.iterator();
            while (true) {
                str = "ImagePath";
                str2 = "base";
                if (!it2.hasNext()) {
                    break;
                }
                Bundle next = it2.next();
                String[] split = StringUtils.split(next.getString("imagename"), "|");
                Iterator<Bundle> it3 = it2;
                int length = split.length;
                ArrayList<Bundle> arrayList5 = arrayList3;
                int i3 = 0;
                while (i3 < length) {
                    int i4 = length;
                    String str6 = split[i3];
                    String[] strArr2 = split;
                    String h1 = CompressHelper.h1(this.D4, str6, str2);
                    int i5 = i3;
                    Bundle bundle2 = new Bundle();
                    File file = new File(h1);
                    if (!file.exists()) {
                        str5 = str2;
                        arrayList2 = arrayList5;
                    } else {
                        ArrayList arrayList6 = arrayList4;
                        try {
                            String h12 = CompressHelper.h1(this.D4, str6, str2);
                            str5 = str2;
                            try {
                                if (!new File(h12).exists()) {
                                    CompressHelper.D2(new File(h12), compressHelper.w(CompressHelper.d2(file), file.getName(), "127"));
                                }
                            } catch (Exception e2) {
                                e = e2;
                                FirebaseCrashlytics.d().g(e);
                                iMDLogger.f("LoadResourcesOther", "Error in loading " + h1 + " . error " + e.getLocalizedMessage());
                                e.printStackTrace();
                                bundle2.putString(str, h1);
                                bundle2.putString("Description", next.getString("descriptionSimple"));
                                bundle2.putString("id", str6);
                                arrayList4 = arrayList6;
                                arrayList4.add(str6);
                                arrayList2 = arrayList5;
                                arrayList2.add(bundle2);
                                i3 = i5 + 1;
                                arrayList5 = arrayList2;
                                length = i4;
                                split = strArr2;
                                str2 = str5;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            str5 = str2;
                            FirebaseCrashlytics.d().g(e);
                            iMDLogger.f("LoadResourcesOther", "Error in loading " + h1 + " . error " + e.getLocalizedMessage());
                            e.printStackTrace();
                            bundle2.putString(str, h1);
                            bundle2.putString("Description", next.getString("descriptionSimple"));
                            bundle2.putString("id", str6);
                            arrayList4 = arrayList6;
                            arrayList4.add(str6);
                            arrayList2 = arrayList5;
                            arrayList2.add(bundle2);
                            i3 = i5 + 1;
                            arrayList5 = arrayList2;
                            length = i4;
                            split = strArr2;
                            str2 = str5;
                        }
                        bundle2.putString(str, h1);
                        bundle2.putString("Description", next.getString("descriptionSimple"));
                        bundle2.putString("id", str6);
                        arrayList4 = arrayList6;
                        arrayList4.add(str6);
                        arrayList2 = arrayList5;
                        arrayList2.add(bundle2);
                    }
                    i3 = i5 + 1;
                    arrayList5 = arrayList2;
                    length = i4;
                    split = strArr2;
                    str2 = str5;
                }
                it2 = it3;
                arrayList3 = arrayList5;
            }
            String str7 = str2;
            this.Z4 = arrayList3;
            if (this.X4.length() != 0) {
                String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(this.X4, "|");
                int length2 = splitByWholeSeparator.length;
                int i6 = 0;
                while (i6 < length2) {
                    String str8 = splitByWholeSeparator[i6];
                    String h13 = CompressHelper.h1(this.D4, str8, "Resources-E");
                    File file2 = new File(h13);
                    if (!arrayList4.contains(str8)) {
                        strArr = splitByWholeSeparator;
                        Bundle bundle3 = new Bundle();
                        arrayList = arrayList4;
                        i2 = length2;
                        str4 = str7;
                        String h14 = CompressHelper.h1(this.D4, str8, str4);
                        bundle3.putString(str, h14);
                        str3 = str;
                        bundle3.putString("Description", "");
                        bundle3.putString("id", str8);
                        File file3 = new File(h14);
                        if (!file3.exists() ? !(!file2.exists() || file2.length() <= 5000) : file3.length() > 5000) {
                            this.Z4.add(bundle3);
                        }
                    } else {
                        strArr = splitByWholeSeparator;
                        arrayList = arrayList4;
                        i2 = length2;
                        str3 = str;
                        str4 = str7;
                    }
                    if (file2.exists()) {
                        try {
                            String h15 = CompressHelper.h1(this.D4, str8, str4);
                            if (!new File(h15).exists()) {
                                CompressHelper.D2(new File(h15), compressHelper.w(CompressHelper.d2(file2), file2.getName(), "127"));
                            }
                        } catch (Exception e4) {
                            FirebaseCrashlytics.d().g(e4);
                            iMDLogger.f("LoadResourcesOther", "Error in loading " + h13 + " . error " + e4.getLocalizedMessage());
                            e4.printStackTrace();
                        }
                    }
                    i6++;
                    str7 = str4;
                    splitByWholeSeparator = strArr;
                    length2 = i2;
                    str = str3;
                    arrayList4 = arrayList;
                }
                MenuItem menuItem = this.Y4;
                if (menuItem != null) {
                    menuItem.setVisible(this.Z4.size() != 0);
                }
            }
        }

        private void N4(String str) {
            if (str.contains("?")) {
                str = str.split("\\?")[0];
            }
            ArrayList<Bundle> arrayList = this.Z4;
            if (arrayList == null || arrayList.size() == 0) {
                CompressHelper.x2(r(), "There is no images in this document", 1);
                return;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.Z4.size(); i3++) {
                if (this.Z4.get(i3).getString("id").equals(str)) {
                    i2 = i3;
                }
            }
            Intent intent = new Intent(r(), GalleryActivity.class);
            intent.putExtra("Images", this.Z4);
            intent.putExtra("Start", i2);
            D2(intent);
        }

        public void M4(Bundle bundle) {
            CompressHelper compressHelper = new CompressHelper(r());
            Bundle s1 = compressHelper.s1(compressHelper.V(this.D4, "Select * from Docs Where bookid = '" + this.E4 + "'"));
            if (bundle.getString(HTML.Tag.V).length() > 0) {
                this.G4.g("showSection('" + bundle.getString(HTML.Tag.V) + "');");
                return;
            }
            String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(bundle.getString("xpath").replace(s1.getString("xpath"), ""), "/");
            this.G4.g("jump = document;");
            for (String str : splitByWholeSeparator) {
                if (str.contains("[")) {
                    this.G4.g("" + ("jump = jump.getElementsByClassName('" + str.substring(0, str.indexOf("[")) + "')[" + String.valueOf(Integer.valueOf(CompressHelper.f(str, "[", "]")).intValue() - 1) + "];"));
                }
            }
            this.G4.g("jump.scrollIntoView(true);");
        }

        public String R2() {
            ArrayList<Bundle> arrayList;
            Bundle v3;
            if (this.Z4.size() <= 0 || (arrayList = this.Z4) == null || arrayList.size() <= 0 || (v3 = v3(this.Z4)) == null) {
                return null;
            }
            return v3.getString("ImagePath");
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
                this.X4 = bundle.getString("mResources");
                this.Z4 = bundle.getParcelableArrayList("mImages");
            }
            if (y() == null) {
                return inflate;
            }
            T2(new Runnable() {
                /* JADX WARNING: Removed duplicated region for block: B:21:0x00fb A[Catch:{ Exception -> 0x001a }] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r6 = this;
                        java.lang.String r0 = "gotoSection"
                        net.imedicaldoctor.imd.Data.CompressHelper r1 = new net.imedicaldoctor.imd.Data.CompressHelper     // Catch:{ Exception -> 0x001a }
                        net.imedicaldoctor.imd.Fragments.OVID.OvidViewerActivity$OvidViewerFragment r2 = net.imedicaldoctor.imd.Fragments.OVID.OvidViewerActivity.OvidViewerFragment.this     // Catch:{ Exception -> 0x001a }
                        androidx.fragment.app.FragmentActivity r2 = r2.r()     // Catch:{ Exception -> 0x001a }
                        r1.<init>(r2)     // Catch:{ Exception -> 0x001a }
                        net.imedicaldoctor.imd.Fragments.OVID.OvidViewerActivity$OvidViewerFragment r2 = net.imedicaldoctor.imd.Fragments.OVID.OvidViewerActivity.OvidViewerFragment.this     // Catch:{ Exception -> 0x001a }
                        java.lang.String r2 = r2.A4     // Catch:{ Exception -> 0x001a }
                        if (r2 == 0) goto L_0x001d
                        int r2 = r2.length()     // Catch:{ Exception -> 0x001a }
                        if (r2 != 0) goto L_0x00f5
                        goto L_0x001d
                    L_0x001a:
                        r0 = move-exception
                        goto L_0x0112
                    L_0x001d:
                        net.imedicaldoctor.imd.Fragments.OVID.OvidViewerActivity$OvidViewerFragment r2 = net.imedicaldoctor.imd.Fragments.OVID.OvidViewerActivity.OvidViewerFragment.this     // Catch:{ Exception -> 0x001a }
                        android.os.Bundle r2 = r2.y()     // Catch:{ Exception -> 0x001a }
                        if (r2 == 0) goto L_0x003e
                        net.imedicaldoctor.imd.Fragments.OVID.OvidViewerActivity$OvidViewerFragment r2 = net.imedicaldoctor.imd.Fragments.OVID.OvidViewerActivity.OvidViewerFragment.this     // Catch:{ Exception -> 0x001a }
                        android.os.Bundle r2 = r2.y()     // Catch:{ Exception -> 0x001a }
                        boolean r2 = r2.containsKey(r0)     // Catch:{ Exception -> 0x001a }
                        if (r2 == 0) goto L_0x003e
                        net.imedicaldoctor.imd.Fragments.OVID.OvidViewerActivity$OvidViewerFragment r2 = net.imedicaldoctor.imd.Fragments.OVID.OvidViewerActivity.OvidViewerFragment.this     // Catch:{ Exception -> 0x001a }
                        android.os.Bundle r3 = r2.y()     // Catch:{ Exception -> 0x001a }
                        android.os.Bundle r0 = r3.getBundle(r0)     // Catch:{ Exception -> 0x001a }
                        android.os.Bundle unused = r2.a5 = r0     // Catch:{ Exception -> 0x001a }
                    L_0x003e:
                        net.imedicaldoctor.imd.Fragments.OVID.OvidViewerActivity$OvidViewerFragment r0 = net.imedicaldoctor.imd.Fragments.OVID.OvidViewerActivity.OvidViewerFragment.this     // Catch:{ Exception -> 0x001a }
                        android.os.Bundle r0 = r0.D4     // Catch:{ Exception -> 0x001a }
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x001a }
                        r2.<init>()     // Catch:{ Exception -> 0x001a }
                        java.lang.String r3 = "Select * from Docs Where bookid = '"
                        r2.append(r3)     // Catch:{ Exception -> 0x001a }
                        net.imedicaldoctor.imd.Fragments.OVID.OvidViewerActivity$OvidViewerFragment r3 = net.imedicaldoctor.imd.Fragments.OVID.OvidViewerActivity.OvidViewerFragment.this     // Catch:{ Exception -> 0x001a }
                        java.lang.String r3 = r3.E4     // Catch:{ Exception -> 0x001a }
                        r2.append(r3)     // Catch:{ Exception -> 0x001a }
                        java.lang.String r3 = "'"
                        r2.append(r3)     // Catch:{ Exception -> 0x001a }
                        java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x001a }
                        android.os.Bundle r0 = r1.e0(r0, r2)     // Catch:{ Exception -> 0x001a }
                        if (r0 != 0) goto L_0x0069
                        net.imedicaldoctor.imd.Fragments.OVID.OvidViewerActivity$OvidViewerFragment r0 = net.imedicaldoctor.imd.Fragments.OVID.OvidViewerActivity.OvidViewerFragment.this     // Catch:{ Exception -> 0x001a }
                        java.lang.String r1 = "Document doesn't exist"
                        r0.p4 = r1     // Catch:{ Exception -> 0x001a }
                        return
                    L_0x0069:
                        java.lang.String r2 = "mainContent"
                        java.lang.String r2 = r0.getString(r2)     // Catch:{ Exception -> 0x001a }
                        net.imedicaldoctor.imd.Fragments.OVID.OvidViewerActivity$OvidViewerFragment r3 = net.imedicaldoctor.imd.Fragments.OVID.OvidViewerActivity.OvidViewerFragment.this     // Catch:{ Exception -> 0x001a }
                        java.lang.String r4 = "resources"
                        java.lang.String r4 = r0.getString(r4)     // Catch:{ Exception -> 0x001a }
                        java.lang.String unused = r3.X4 = r4     // Catch:{ Exception -> 0x001a }
                        net.imedicaldoctor.imd.Fragments.OVID.OvidViewerActivity$OvidViewerFragment r3 = net.imedicaldoctor.imd.Fragments.OVID.OvidViewerActivity.OvidViewerFragment.this     // Catch:{ Exception -> 0x001a }
                        java.lang.String r4 = "name"
                        java.lang.String r4 = r0.getString(r4)     // Catch:{ Exception -> 0x001a }
                        r3.F4 = r4     // Catch:{ Exception -> 0x001a }
                        java.lang.String r3 = "bookid"
                        java.lang.String r0 = r0.getString(r3)     // Catch:{ Exception -> 0x001a }
                        java.lang.String r3 = "127"
                        byte[] r0 = r1.v(r2, r0, r3)     // Catch:{ Exception -> 0x001a }
                        java.lang.String r2 = new java.lang.String     // Catch:{ Exception -> 0x001a }
                        r2.<init>(r0)     // Catch:{ Exception -> 0x001a }
                        net.imedicaldoctor.imd.Fragments.OVID.OvidViewerActivity$OvidViewerFragment r0 = net.imedicaldoctor.imd.Fragments.OVID.OvidViewerActivity.OvidViewerFragment.this     // Catch:{ Exception -> 0x001a }
                        androidx.fragment.app.FragmentActivity r3 = r0.r()     // Catch:{ Exception -> 0x001a }
                        java.lang.String r4 = "OVIDHeader.css"
                        java.lang.String r0 = r0.d4(r3, r4)     // Catch:{ Exception -> 0x001a }
                        net.imedicaldoctor.imd.Fragments.OVID.OvidViewerActivity$OvidViewerFragment r3 = net.imedicaldoctor.imd.Fragments.OVID.OvidViewerActivity.OvidViewerFragment.this     // Catch:{ Exception -> 0x001a }
                        androidx.fragment.app.FragmentActivity r4 = r3.r()     // Catch:{ Exception -> 0x001a }
                        java.lang.String r5 = "OVIDFooter.css"
                        java.lang.String r3 = r3.d4(r4, r5)     // Catch:{ Exception -> 0x001a }
                        java.lang.String r4 = "[size]"
                        java.lang.String r5 = "200"
                        java.lang.String r0 = r0.replace(r4, r5)     // Catch:{ Exception -> 0x001a }
                        java.lang.String r4 = "[title]"
                        net.imedicaldoctor.imd.Fragments.OVID.OvidViewerActivity$OvidViewerFragment r5 = net.imedicaldoctor.imd.Fragments.OVID.OvidViewerActivity.OvidViewerFragment.this     // Catch:{ Exception -> 0x001a }
                        java.lang.String r5 = r5.F4     // Catch:{ Exception -> 0x001a }
                        java.lang.String r0 = r0.replace(r4, r5)     // Catch:{ Exception -> 0x001a }
                        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x001a }
                        r4.<init>()     // Catch:{ Exception -> 0x001a }
                        r4.append(r0)     // Catch:{ Exception -> 0x001a }
                        r4.append(r2)     // Catch:{ Exception -> 0x001a }
                        r4.append(r3)     // Catch:{ Exception -> 0x001a }
                        java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x001a }
                        java.lang.String r2 = "<div class=\"FG\""
                        java.lang.String r3 = "<div class=\"FG\" style=\"width:100%;overflow: scroll;\""
                        java.lang.String r0 = r0.replace(r2, r3)     // Catch:{ Exception -> 0x001a }
                        java.lang.String r2 = "<div class=\"TB\""
                        java.lang.String r3 = "<div class=\"TB\" style=\"width:100%;overflow: scroll;\""
                        java.lang.String r0 = r0.replace(r2, r3)     // Catch:{ Exception -> 0x001a }
                        java.lang.String r2 = "<div class=\"MATH\""
                        java.lang.String r3 = "<div class=\"MATH\" style=\"width:100%;overflow: scroll;\""
                        java.lang.String r0 = r0.replace(r2, r3)     // Catch:{ Exception -> 0x001a }
                        net.imedicaldoctor.imd.Fragments.OVID.OvidViewerActivity$OvidViewerFragment r2 = net.imedicaldoctor.imd.Fragments.OVID.OvidViewerActivity.OvidViewerFragment.this     // Catch:{ Exception -> 0x001a }
                        r2.m3()     // Catch:{ Exception -> 0x001a }
                        net.imedicaldoctor.imd.Fragments.OVID.OvidViewerActivity$OvidViewerFragment r2 = net.imedicaldoctor.imd.Fragments.OVID.OvidViewerActivity.OvidViewerFragment.this     // Catch:{ Exception -> 0x001a }
                        r2.A4 = r0     // Catch:{ Exception -> 0x001a }
                        r2.I4()     // Catch:{ Exception -> 0x001a }
                    L_0x00f5:
                        boolean r0 = r1.x1()     // Catch:{ Exception -> 0x001a }
                        if (r0 != 0) goto L_0x0102
                        net.imedicaldoctor.imd.Fragments.OVID.OvidViewerActivity$OvidViewerFragment r0 = net.imedicaldoctor.imd.Fragments.OVID.OvidViewerActivity.OvidViewerFragment.this     // Catch:{ Exception -> 0x001a }
                        java.lang.String r1 = "Chapter"
                        r0.m4(r1)     // Catch:{ Exception -> 0x001a }
                    L_0x0102:
                        net.imedicaldoctor.imd.Fragments.OVID.OvidViewerActivity$OvidViewerFragment r0 = net.imedicaldoctor.imd.Fragments.OVID.OvidViewerActivity.OvidViewerFragment.this     // Catch:{ Exception -> 0x001a }
                        android.os.Bundle r0 = r0.D4     // Catch:{ Exception -> 0x001a }
                        java.lang.String r1 = "base"
                        java.lang.String r0 = net.imedicaldoctor.imd.Data.CompressHelper.g1(r0, r1)     // Catch:{ Exception -> 0x001a }
                        net.imedicaldoctor.imd.Fragments.OVID.OvidViewerActivity$OvidViewerFragment r1 = net.imedicaldoctor.imd.Fragments.OVID.OvidViewerActivity.OvidViewerFragment.this     // Catch:{ Exception -> 0x001a }
                        r1.h3(r0)     // Catch:{ Exception -> 0x001a }
                        goto L_0x0124
                    L_0x0112:
                        com.google.firebase.crashlytics.FirebaseCrashlytics r1 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()
                        r1.g(r0)
                        r0.printStackTrace()
                        net.imedicaldoctor.imd.Fragments.OVID.OvidViewerActivity$OvidViewerFragment r1 = net.imedicaldoctor.imd.Fragments.OVID.OvidViewerActivity.OvidViewerFragment.this
                        java.lang.String r0 = r0.getLocalizedMessage()
                        r1.p4 = r0
                    L_0x0124:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.OVID.OvidViewerActivity.OvidViewerFragment.AnonymousClass1.run():void");
                }
            }, new Runnable() {
                public void run() {
                    String str = OvidViewerFragment.this.p4;
                    if (str == null || str.length() <= 0) {
                        String g1 = CompressHelper.g1(OvidViewerFragment.this.D4, "base");
                        OvidViewerFragment ovidViewerFragment = OvidViewerFragment.this;
                        ovidViewerFragment.O3(ovidViewerFragment.A4, g1);
                        OvidViewerFragment.this.s4();
                        OvidViewerFragment.this.p4();
                        OvidViewerFragment.this.f3(R.menu.f1411elsviewer2);
                        OvidViewerFragment.this.o2(false);
                        OvidViewerFragment.this.G3();
                        return;
                    }
                    OvidViewerFragment ovidViewerFragment2 = OvidViewerFragment.this;
                    ovidViewerFragment2.C4(ovidViewerFragment2.p4);
                }
            });
            return inflate;
        }

        public void Z3(WebView webView, String str) {
            super.Z3(webView, str);
            Bundle bundle = this.a5;
            if (bundle != null) {
                M4(bundle);
                this.a5 = null;
            }
            this.G4.g("fixAllImages2();");
            this.G4.g("ConvertAllImages();");
        }

        public boolean e1(MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            if (itemId == R.id.f799action_gallery) {
                N4("soheilvb");
            }
            if (itemId == R.id.f801action_menu) {
                CompressHelper compressHelper = new CompressHelper(r());
                Bundle bundle = this.D4;
                Bundle s1 = compressHelper.s1(compressHelper.V(bundle, "Select id from toc where bookid='" + this.E4 + "' AND section='" + this.E4 + "'"));
                OvidSectionsViewer ovidSectionsViewer = new OvidSectionsViewer();
                Bundle bundle2 = new Bundle();
                bundle2.putBundle("db", this.D4);
                bundle2.putString("parentId", s1.getString("id"));
                ovidSectionsViewer.i2(bundle2);
                ovidSectionsViewer.Z2(true);
                ovidSectionsViewer.A2(this, 0);
                ovidSectionsViewer.e3(M(), "OvidSectionsViewer");
            }
            return super.e1(menuItem);
        }

        public void e3(Menu menu) {
            MenuItem findItem = menu.findItem(R.id.f799action_gallery);
            this.Y4 = findItem;
            ArrayList<Bundle> arrayList = this.Z4;
            findItem.setVisible((arrayList == null || arrayList.size() == 0) ? false : true);
        }

        public void m1(Bundle bundle) {
            super.m1(bundle);
        }

        public boolean y4(WebView webView, String str, String str2, String str3) {
            iMDLogger.j("Override", "Url : " + str + ", Scheme : " + str2 + ", Resource : " + str3);
            CompressHelper compressHelper = new CompressHelper(r());
            if (str2.equals("image")) {
                try {
                    String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(str3, "/");
                    N4(splitByWholeSeparator[splitByWholeSeparator.length - 1]);
                } catch (Exception e2) {
                    FirebaseCrashlytics.d().g(e2);
                }
                return true;
            }
            if (str2.equals("chapter")) {
                String substring = str3.substring(2);
                if (substring.startsWith("PG")) {
                    ArrayList<Bundle> V = compressHelper.V(this.D4, "Select * from pages where pagenum=" + substring.substring(2));
                    if (V.size() == 0) {
                        return true;
                    }
                    compressHelper.A1(this.D4, V.get(0).getString("bookid"), (String[]) null, substring);
                } else {
                    compressHelper.A1(this.D4, substring, (String[]) null, substring);
                }
            }
            String str4 = str3 + "&";
            String[] splitByWholeSeparator2 = StringUtils.splitByWholeSeparator(str4, "/");
            if (!str4.contains("Book+Image") && splitByWholeSeparator2[splitByWholeSeparator2.length - 1].charAt(0) == '#') {
                String replace = splitByWholeSeparator2[splitByWholeSeparator2.length - 1].substring(1).replace("&", "");
                this.G4.g("showSection('" + replace + "')");
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.f1175activity_general_viewer);
        Y0(new OvidViewerFragment(), bundle);
    }
}
