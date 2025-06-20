package net.imedicaldoctor.imd.Fragments.LWW;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.WebView;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.itextpdf.text.Annotation;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.Amirsys.ASSectionViewer;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.Gallery.GalleryActivity;
import net.imedicaldoctor.imd.GeneralDialogFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Utils.iMDWebView;
import net.imedicaldoctor.imd.iMDLogger;
import org.apache.commons.lang3.StringUtils;

public class LWWViewerFragment extends ViewerHelperFragment {
    private GeneralDialogFragment X4;
    /* access modifiers changed from: private */
    public String Y4;
    /* access modifiers changed from: private */
    public MenuItem Z4;
    public ArrayList<Bundle> a5;
    public ArrayList<Bundle> b5;
    public ArrayList<Bundle> c5;
    public ArrayList<Bundle> d5;
    public String e5;

    /* access modifiers changed from: private */
    public void I4() {
        String str;
        CompressHelper compressHelper;
        Iterator<Bundle> it2;
        CompressHelper compressHelper2 = new CompressHelper(r());
        Bundle bundle = this.D4;
        ArrayList<Bundle> V = compressHelper2.V(bundle, "Select rowid as _id, * from images where docId=" + this.E4);
        this.a5 = new ArrayList<>();
        String str2 = "127";
        if (V == null) {
            iMDLogger.j("LoadResources", "No images to load");
        } else {
            Iterator<Bundle> it3 = V.iterator();
            while (it3.hasNext()) {
                Bundle next = it3.next();
                String string = next.getString("name");
                String h1 = CompressHelper.h1(this.D4, string, "Resources-E");
                if (!new File(h1).exists()) {
                    iMDLogger.f("LWWViewerFragment", "Image " + h1 + " not exist . ");
                } else {
                    File file = new File(h1);
                    try {
                        String h12 = CompressHelper.h1(this.D4, string, "base");
                        it2 = it3;
                        try {
                            byte[] d2 = CompressHelper.d2(file);
                            file.getName();
                            byte[] w = compressHelper2.w(d2, file.getName(), str2);
                            if (new File(h12).exists()) {
                                new File(h12).delete();
                            }
                            CompressHelper.D2(new File(h12), w);
                            new File(h12).deleteOnExit();
                            Bundle bundle2 = new Bundle();
                            bundle2.putString("ImagePath", h12);
                            bundle2.putString("id", string);
                            bundle2.putString("Description", next.getString("label") + StringUtils.LF + next.getString(DublinCoreProperties.f27399e));
                            this.a5.add(bundle2);
                        } catch (Exception e2) {
                            e = e2;
                            iMDLogger.f("LoadResources", "Images Error in loading " + h1 + " . error " + e.getLocalizedMessage());
                            it3 = it2;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        it2 = it3;
                        iMDLogger.f("LoadResources", "Images Error in loading " + h1 + " . error " + e.getLocalizedMessage());
                        it3 = it2;
                    }
                    it3 = it2;
                }
            }
        }
        this.b5 = new ArrayList<>();
        if (this.Y4.length() != 0) {
            String[] split = TextUtils.split(this.Y4, "\\|");
            int length = split.length;
            int i2 = 0;
            while (i2 < length) {
                String str3 = split[i2];
                String h13 = CompressHelper.h1(this.D4, str3, "Resources-E");
                if (!new File(h13).exists()) {
                    h13 = CompressHelper.h1(this.D4, str3.replace(".png", ".gif"), "Resources-E");
                    if (!new File(h13).exists()) {
                        compressHelper = compressHelper2;
                        str = str2;
                        i2++;
                        compressHelper2 = compressHelper;
                        str2 = str;
                    }
                }
                File file2 = new File(h13);
                try {
                    byte[] w2 = compressHelper2.w(CompressHelper.d2(file2), file2.getName(), str2);
                    String h14 = CompressHelper.h1(this.D4, str3, "base");
                    compressHelper = compressHelper2;
                    try {
                        Bundle bundle3 = new Bundle();
                        bundle3.putString("ImagePath", h14);
                        str = str2;
                        try {
                            this.b5.add(bundle3);
                            bundle3.putString("ImagePath", h14);
                            bundle3.putString("id", str3);
                            bundle3.putString("Description", "");
                            this.a5.add(bundle3);
                            if (!new File(h14).exists()) {
                                CompressHelper.D2(new File(h14), w2);
                                new File(h14).deleteOnExit();
                            }
                        } catch (Exception e4) {
                            e = e4;
                            FirebaseCrashlytics.d().g(e);
                            iMDLogger.f("LoadResourcesOther", "Error in loading " + h13 + " . error " + e.getLocalizedMessage());
                            i2++;
                            compressHelper2 = compressHelper;
                            str2 = str;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        str = str2;
                        FirebaseCrashlytics.d().g(e);
                        iMDLogger.f("LoadResourcesOther", "Error in loading " + h13 + " . error " + e.getLocalizedMessage());
                        i2++;
                        compressHelper2 = compressHelper;
                        str2 = str;
                    }
                } catch (Exception e7) {
                    e = e7;
                    compressHelper = compressHelper2;
                    str = str2;
                    FirebaseCrashlytics.d().g(e);
                    iMDLogger.f("LoadResourcesOther", "Error in loading " + h13 + " . error " + e.getLocalizedMessage());
                    i2++;
                    compressHelper2 = compressHelper;
                    str2 = str;
                }
                i2++;
                compressHelper2 = compressHelper;
                str2 = str;
            }
        }
    }

    private void M4(String str) {
        if (this.a5.size() == 0) {
            CompressHelper.x2(r(), "There is no media in this document", 1);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.a5);
        int i2 = 0;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            if (((Bundle) arrayList.get(i3)).getString("id").startsWith(str)) {
                i2 = i3;
            }
        }
        Intent intent = new Intent(r(), GalleryActivity.class);
        intent.putExtra("Images", arrayList);
        intent.putExtra("Start", i2);
        D2(intent);
    }

    public void C3(String str) {
        iMDWebView imdwebview = this.G4;
        imdwebview.g("showSection('" + str + "');");
    }

    public String R2() {
        ArrayList<Bundle> arrayList;
        Bundle v3;
        if (this.a5.size() <= 0 || (arrayList = this.a5) == null || arrayList.size() <= 0 || (v3 = v3(this.a5)) == null) {
            return null;
        }
        return v3.getString("ImagePath");
    }

    public void T0(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.f1417menu_amviewer, menu);
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
            this.Y4 = bundle.getString("mResources");
            this.a5 = bundle.getParcelableArrayList("mImages");
            this.b5 = bundle.getParcelableArrayList("mOtherImages");
            this.c5 = bundle.getParcelableArrayList("mSections");
        }
        if (y() == null) {
            return inflate;
        }
        iMDLogger.j("AMViewer", "Loading LWW Document with mDocAddress = " + this.E4);
        T2(new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:33:0x01a2 A[Catch:{ Exception -> 0x001a }] */
            /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r7 = this;
                    java.lang.String r0 = "Select * from Docs where id="
                    net.imedicaldoctor.imd.Data.CompressHelper r1 = new net.imedicaldoctor.imd.Data.CompressHelper     // Catch:{ Exception -> 0x001a }
                    net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment r2 = net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment.this     // Catch:{ Exception -> 0x001a }
                    androidx.fragment.app.FragmentActivity r2 = r2.r()     // Catch:{ Exception -> 0x001a }
                    r1.<init>(r2)     // Catch:{ Exception -> 0x001a }
                    net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment r2 = net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment.this     // Catch:{ Exception -> 0x001a }
                    java.lang.String r2 = r2.A4     // Catch:{ Exception -> 0x001a }
                    if (r2 == 0) goto L_0x001d
                    int r2 = r2.length()     // Catch:{ Exception -> 0x001a }
                    if (r2 != 0) goto L_0x017d
                    goto L_0x001d
                L_0x001a:
                    r0 = move-exception
                    goto L_0x01aa
                L_0x001d:
                    net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment r2 = net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment.this     // Catch:{ Exception -> 0x001a }
                    android.os.Bundle r2 = r2.D4     // Catch:{ Exception -> 0x001a }
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x001a }
                    r3.<init>()     // Catch:{ Exception -> 0x001a }
                    r3.append(r0)     // Catch:{ Exception -> 0x001a }
                    net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment r4 = net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment.this     // Catch:{ Exception -> 0x001a }
                    java.lang.String r4 = r4.E4     // Catch:{ Exception -> 0x001a }
                    r3.append(r4)     // Catch:{ Exception -> 0x001a }
                    java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x001a }
                    java.util.ArrayList r2 = r1.V(r2, r3)     // Catch:{ Exception -> 0x001a }
                    android.os.Bundle r2 = r1.z(r2)     // Catch:{ Exception -> 0x001a }
                    java.lang.String r3 = "id"
                    if (r2 != 0) goto L_0x00ed
                    net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment r2 = net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment.this     // Catch:{ Exception -> 0x001a }
                    android.os.Bundle r2 = r2.D4     // Catch:{ Exception -> 0x001a }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x001a }
                    r4.<init>()     // Catch:{ Exception -> 0x001a }
                    java.lang.String r5 = "Select * from AllSections where id='"
                    r4.append(r5)     // Catch:{ Exception -> 0x001a }
                    net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment r5 = net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment.this     // Catch:{ Exception -> 0x001a }
                    java.lang.String r5 = r5.E4     // Catch:{ Exception -> 0x001a }
                    r4.append(r5)     // Catch:{ Exception -> 0x001a }
                    java.lang.String r5 = "' collate nocase"
                    r4.append(r5)     // Catch:{ Exception -> 0x001a }
                    java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x001a }
                    java.util.ArrayList r2 = r1.V(r2, r4)     // Catch:{ Exception -> 0x001a }
                    android.os.Bundle r2 = r1.z(r2)     // Catch:{ Exception -> 0x001a }
                    java.lang.String r4 = "docId"
                    if (r2 != 0) goto L_0x00c1
                    net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment r2 = net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment.this     // Catch:{ Exception -> 0x001a }
                    android.os.Bundle r2 = r2.D4     // Catch:{ Exception -> 0x001a }
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x001a }
                    r5.<init>()     // Catch:{ Exception -> 0x001a }
                    java.lang.String r6 = "Select * from AllSections where id like '"
                    r5.append(r6)     // Catch:{ Exception -> 0x001a }
                    net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment r6 = net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment.this     // Catch:{ Exception -> 0x001a }
                    java.lang.String r6 = r6.E4     // Catch:{ Exception -> 0x001a }
                    r5.append(r6)     // Catch:{ Exception -> 0x001a }
                    java.lang.String r6 = "%' collate nocase"
                    r5.append(r6)     // Catch:{ Exception -> 0x001a }
                    java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x001a }
                    java.util.ArrayList r2 = r1.V(r2, r5)     // Catch:{ Exception -> 0x001a }
                    android.os.Bundle r2 = r1.z(r2)     // Catch:{ Exception -> 0x001a }
                    if (r2 != 0) goto L_0x0099
                    net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment r0 = net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment.this     // Catch:{ Exception -> 0x001a }
                    java.lang.String r1 = "Document doesn't exist"
                    r0.p4 = r1     // Catch:{ Exception -> 0x001a }
                    return
                L_0x0099:
                    net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment r5 = net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment.this     // Catch:{ Exception -> 0x001a }
                    java.lang.String r2 = r2.getString(r4)     // Catch:{ Exception -> 0x001a }
                    r5.E4 = r2     // Catch:{ Exception -> 0x001a }
                    net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment r2 = net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment.this     // Catch:{ Exception -> 0x001a }
                    android.os.Bundle r2 = r2.D4     // Catch:{ Exception -> 0x001a }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x001a }
                    r4.<init>()     // Catch:{ Exception -> 0x001a }
                    r4.append(r0)     // Catch:{ Exception -> 0x001a }
                    net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment r0 = net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment.this     // Catch:{ Exception -> 0x001a }
                    java.lang.String r0 = r0.E4     // Catch:{ Exception -> 0x001a }
                    r4.append(r0)     // Catch:{ Exception -> 0x001a }
                    java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x001a }
                    java.util.ArrayList r0 = r1.V(r2, r0)     // Catch:{ Exception -> 0x001a }
                L_0x00bc:
                    android.os.Bundle r2 = r1.z(r0)     // Catch:{ Exception -> 0x001a }
                    goto L_0x00ed
                L_0x00c1:
                    net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment r5 = net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment.this     // Catch:{ Exception -> 0x001a }
                    java.lang.String r4 = r2.getString(r4)     // Catch:{ Exception -> 0x001a }
                    r5.E4 = r4     // Catch:{ Exception -> 0x001a }
                    net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment r4 = net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment.this     // Catch:{ Exception -> 0x001a }
                    java.lang.String r2 = r2.getString(r3)     // Catch:{ Exception -> 0x001a }
                    r4.e5 = r2     // Catch:{ Exception -> 0x001a }
                    net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment r2 = net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment.this     // Catch:{ Exception -> 0x001a }
                    android.os.Bundle r2 = r2.D4     // Catch:{ Exception -> 0x001a }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x001a }
                    r4.<init>()     // Catch:{ Exception -> 0x001a }
                    r4.append(r0)     // Catch:{ Exception -> 0x001a }
                    net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment r0 = net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment.this     // Catch:{ Exception -> 0x001a }
                    java.lang.String r0 = r0.E4     // Catch:{ Exception -> 0x001a }
                    r4.append(r0)     // Catch:{ Exception -> 0x001a }
                    java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x001a }
                    java.util.ArrayList r0 = r1.V(r2, r0)     // Catch:{ Exception -> 0x001a }
                    goto L_0x00bc
                L_0x00ed:
                    java.lang.String r0 = "mainContent"
                    java.lang.String r0 = r2.getString(r0)     // Catch:{ Exception -> 0x001a }
                    net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment r4 = net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment.this     // Catch:{ Exception -> 0x001a }
                    java.lang.String r5 = "resources"
                    java.lang.String r5 = r2.getString(r5)     // Catch:{ Exception -> 0x001a }
                    java.lang.String unused = r4.Y4 = r5     // Catch:{ Exception -> 0x001a }
                    net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment r4 = net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment.this     // Catch:{ Exception -> 0x001a }
                    java.lang.String r5 = "name"
                    java.lang.String r5 = r2.getString(r5)     // Catch:{ Exception -> 0x001a }
                    r4.F4 = r5     // Catch:{ Exception -> 0x001a }
                    java.lang.String r2 = r2.getString(r3)     // Catch:{ Exception -> 0x001a }
                    java.lang.String r3 = "127"
                    byte[] r0 = r1.v(r0, r2, r3)     // Catch:{ Exception -> 0x001a }
                    java.lang.String r2 = new java.lang.String     // Catch:{ Exception -> 0x001a }
                    r2.<init>(r0)     // Catch:{ Exception -> 0x001a }
                    net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment r0 = net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment.this     // Catch:{ Exception -> 0x001a }
                    androidx.fragment.app.FragmentActivity r3 = r0.r()     // Catch:{ Exception -> 0x001a }
                    java.lang.String r4 = "LWWHeader.css"
                    java.lang.String r0 = r0.d4(r3, r4)     // Catch:{ Exception -> 0x001a }
                    net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment r3 = net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment.this     // Catch:{ Exception -> 0x001a }
                    androidx.fragment.app.FragmentActivity r4 = r3.r()     // Catch:{ Exception -> 0x001a }
                    java.lang.String r5 = "LWWFooter.css"
                    java.lang.String r3 = r3.d4(r4, r5)     // Catch:{ Exception -> 0x001a }
                    java.lang.String r4 = "[size]"
                    java.lang.String r5 = "200"
                    java.lang.String r0 = r0.replace(r4, r5)     // Catch:{ Exception -> 0x001a }
                    java.lang.String r4 = "[title]"
                    net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment r5 = net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment.this     // Catch:{ Exception -> 0x001a }
                    java.lang.String r5 = r5.F4     // Catch:{ Exception -> 0x001a }
                    java.lang.String r0 = r0.replace(r4, r5)     // Catch:{ Exception -> 0x001a }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x001a }
                    r4.<init>()     // Catch:{ Exception -> 0x001a }
                    r4.append(r0)     // Catch:{ Exception -> 0x001a }
                    r4.append(r2)     // Catch:{ Exception -> 0x001a }
                    r4.append(r3)     // Catch:{ Exception -> 0x001a }
                    java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x001a }
                    net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment r2 = net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment.this     // Catch:{ Exception -> 0x001a }
                    r2.m3()     // Catch:{ Exception -> 0x001a }
                    net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment r2 = net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment.this     // Catch:{ Exception -> 0x001a }
                    r2.A4 = r0     // Catch:{ Exception -> 0x001a }
                    r2.I4()     // Catch:{ Exception -> 0x001a }
                    net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment r0 = net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment.this     // Catch:{ Exception -> 0x001a }
                    android.view.MenuItem r0 = r0.Z4     // Catch:{ Exception -> 0x001a }
                    if (r0 == 0) goto L_0x017d
                    net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment r0 = net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment.this     // Catch:{ Exception -> 0x001a }
                    android.view.MenuItem r0 = r0.Z4     // Catch:{ Exception -> 0x001a }
                    net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment r2 = net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment.this     // Catch:{ Exception -> 0x001a }
                    java.util.ArrayList<android.os.Bundle> r2 = r2.a5     // Catch:{ Exception -> 0x001a }
                    int r2 = r2.size()     // Catch:{ Exception -> 0x001a }
                    if (r2 == 0) goto L_0x0179
                    r2 = 1
                    goto L_0x017a
                L_0x0179:
                    r2 = 0
                L_0x017a:
                    r0.setVisible(r2)     // Catch:{ Exception -> 0x001a }
                L_0x017d:
                    net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment r0 = net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment.this     // Catch:{ Exception -> 0x001a }
                    android.os.Bundle r2 = r0.D4     // Catch:{ Exception -> 0x001a }
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x001a }
                    r3.<init>()     // Catch:{ Exception -> 0x001a }
                    java.lang.String r4 = "Select * from sections where docId="
                    r3.append(r4)     // Catch:{ Exception -> 0x001a }
                    net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment r4 = net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment.this     // Catch:{ Exception -> 0x001a }
                    java.lang.String r4 = r4.E4     // Catch:{ Exception -> 0x001a }
                    r3.append(r4)     // Catch:{ Exception -> 0x001a }
                    java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x001a }
                    java.util.ArrayList r2 = r1.V(r2, r3)     // Catch:{ Exception -> 0x001a }
                    r0.d5 = r2     // Catch:{ Exception -> 0x001a }
                    boolean r0 = r1.x1()     // Catch:{ Exception -> 0x001a }
                    if (r0 != 0) goto L_0x01bc
                    net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment r0 = net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment.this     // Catch:{ Exception -> 0x001a }
                    java.lang.String r1 = "Chapter"
                    r0.m4(r1)     // Catch:{ Exception -> 0x001a }
                    goto L_0x01bc
                L_0x01aa:
                    com.google.firebase.crashlytics.FirebaseCrashlytics r1 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()
                    r1.g(r0)
                    r0.printStackTrace()
                    net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment r1 = net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment.this
                    java.lang.String r0 = r0.getLocalizedMessage()
                    r1.p4 = r0
                L_0x01bc:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment.AnonymousClass1.run():void");
            }
        }, new Runnable() {
            public void run() {
                String str = LWWViewerFragment.this.p4;
                if (str == null || str.length() <= 0) {
                    String g1 = CompressHelper.g1(LWWViewerFragment.this.D4, "base");
                    LWWViewerFragment lWWViewerFragment = LWWViewerFragment.this;
                    lWWViewerFragment.O3(lWWViewerFragment.A4, g1);
                    LWWViewerFragment.this.s4();
                    LWWViewerFragment.this.p4();
                    LWWViewerFragment.this.f3(R.menu.f1417menu_amviewer);
                    LWWViewerFragment.this.o2(false);
                    LWWViewerFragment.this.G3();
                    return;
                }
                LWWViewerFragment lWWViewerFragment2 = LWWViewerFragment.this;
                lWWViewerFragment2.C4(lWWViewerFragment2.p4);
            }
        });
        return inflate;
    }

    public boolean W3(ConsoleMessage consoleMessage) {
        iMDLogger.f("Javascript Console Message", consoleMessage.message());
        return super.W3(consoleMessage);
    }

    public void Z3(WebView webView, String str) {
        super.Z3(webView, str);
        String str2 = this.e5;
        if (str2 != null) {
            C3(str2);
            this.e5 = null;
        }
    }

    public boolean e1(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.f799action_gallery) {
            M4("soheilvb");
        }
        if (itemId == R.id.f801action_menu) {
            ASSectionViewer aSSectionViewer = new ASSectionViewer();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("Items", this.d5);
            bundle.putString("TitleProperty", "name");
            aSSectionViewer.A2(this, 0);
            aSSectionViewer.i2(bundle);
            aSSectionViewer.Z2(true);
            aSSectionViewer.e3(M(), "lwwsections");
        }
        return super.e1(menuItem);
    }

    public void e3(Menu menu) {
        this.Z4 = menu.findItem(R.id.f799action_gallery);
    }

    public void m1(Bundle bundle) {
        super.m1(bundle);
    }

    public void t3(String str) {
        super.t3(str);
    }

    public boolean y4(WebView webView, String str, String str2, String str3) {
        iMDLogger.j("Override", "Url : " + str + ", Scheme : " + str2 + ", Resource : " + str3);
        if (str2.equals("image")) {
            M4(str3.replace("//", ""));
            return true;
        }
        String str4 = str3 + "&";
        if ((str2.equals(Annotation.k3) || (str2.equals("http") && str4.contains("localhost:"))) && str4.contains("content.aspx")) {
            if (!str4.toLowerCase().contains("sectionid=")) {
                return false;
            }
            new CompressHelper(r()).A1(this.D4, CompressHelper.f(str4.toLowerCase() + "&", "sectionid=", "&"), (String[]) null, (String) null);
        }
        return true;
    }
}
