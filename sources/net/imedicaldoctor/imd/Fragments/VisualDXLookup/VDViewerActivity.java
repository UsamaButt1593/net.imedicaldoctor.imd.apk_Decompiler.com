package net.imedicaldoctor.imd.Fragments.VisualDXLookup;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.bumptech.glide.Glide;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.ViewerHelperActivity;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.iMDLogger;

public class VDViewerActivity extends ViewerHelperActivity {

    public static class VDViewerFragment extends ViewerHelperFragment implements VDDialogListInterface {
        public ArrayList<Bundle> X4;

        public void I4() {
            VDDialogList vDDialogList = new VDDialogList();
            Bundle bundle = new Bundle();
            bundle.putBundle("db", this.D4);
            bundle.putParcelableArrayList("items", this.X4);
            bundle.putString("titleProperty", "fieldName");
            bundle.putString("type", "Field");
            vDDialogList.i2(bundle);
            vDDialogList.Z2(true);
            vDDialogList.A2(this, 0);
            vDDialogList.e3(M(), "VDDialogFragment");
        }

        public String R2() {
            String str = this.E4.split("-")[1];
            CompressHelper compressHelper = this.Q4;
            Bundle bundle = this.D4;
            ArrayList<Bundle> V = compressHelper.V(bundle, "select imageId ,copyRight from Images where diagnosesModulesid=" + str);
            if (V == null || V.size() <= 0) {
                return null;
            }
            Bundle v3 = v3(V);
            Bundle bundle2 = this.D4;
            return CompressHelper.h1(bundle2, v3.getString("imageId") + ".jpg", "Large-Encrypted");
        }

        public void T0(Menu menu, MenuInflater menuInflater) {
            menuInflater.inflate(R.menu.f1491menu_vdviewer, menu);
            q4(menu);
        }

        public View onFragmentBind(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View view = this.C4;
            if (view != null) {
                return view;
            }
            View inflate = layoutInflater.inflate(R.layout.f1255fragment_new_viewer, viewGroup, false);
            r4(inflate, bundle);
            if (bundle != null) {
                this.X4 = bundle.getParcelableArrayList("mFields");
            }
            if (y() == null) {
                return inflate;
            }
            iMDLogger.j("VDViewer", "Loading VD Document with mDocAddress = " + this.E4);
            try {
                CompressHelper compressHelper = new CompressHelper(r());
                String str = this.A4;
                if (str != null) {
                    if (str.length() == 0) {
                    }
                    p4();
                    f3(R.menu.f1491menu_vdviewer);
                    o2(false);
                    G3();
                    return inflate;
                }
                String str2 = this.E4.split("-")[1];
                Bundle s1 = compressHelper.s1(compressHelper.V(this.D4, "select * from DiagnosesModules where id =" + str2));
                this.F4 = compressHelper.s1(compressHelper.V(this.D4, "select * from Diagnoses where id =" + s1.getString("diagnosisId"))).getString("dName");
                ArrayList<Bundle> V = compressHelper.V(this.D4, "select fieldId, fieldName,doc  from Documents, fields where DiagnosesModulesId=" + str2 + " and documents.fieldId = fields.id");
                this.X4 = V;
                String str3 = "";
                Iterator<Bundle> it2 = V.iterator();
                while (it2.hasNext()) {
                    Bundle next = it2.next();
                    str3 = str3 + "<span class=\"h1\" id=\"field" + next.getString("fieldId") + "\">" + next.getString("fieldName") + "</span>" + compressHelper.B(next.getString("doc"), str2, "127");
                }
                String d4 = d4(r(), "VDHeader.css");
                String d42 = d4(r(), "VDFooter.css");
                m3();
                this.A4 = d4.replace("[size]", "200").replace("[title]", this.F4) + str3 + d42;
                if (!compressHelper.x1()) {
                    m4("Diagnosis");
                }
                O3(this.A4, CompressHelper.g1(this.D4, "base"));
                s4();
                p4();
                f3(R.menu.f1491menu_vdviewer);
                o2(false);
                G3();
                return inflate;
            } catch (Exception e2) {
                B4(e2);
                return inflate;
            }
        }

        public boolean e1(MenuItem menuItem) {
            if (menuItem.getItemId() == R.id.f801action_menu) {
                I4();
            }
            return super.e1(menuItem);
        }

        public void h(Bundle bundle, String str) {
            new CompressHelper(r());
            if (str.equals("Field")) {
                C3("field" + bundle.getString("fieldId"));
            }
        }

        public void m1(Bundle bundle) {
            super.m1(bundle);
        }

        public void o4() {
            new AsyncTask() {

                /* renamed from: a  reason: collision with root package name */
                byte[] f30067a;

                /* access modifiers changed from: protected */
                public Object doInBackground(Object[] objArr) {
                    try {
                        File file = new File(VDViewerFragment.this.R2());
                        this.f30067a = new CompressHelper(VDViewerFragment.this.r()).w(CompressHelper.d2(file), file.getName(), "127");
                        return null;
                    } catch (Exception e2) {
                        FirebaseCrashlytics.d().g(e2);
                        iMDLogger.f("ImageGallery", "Error in decrypting image");
                        return null;
                    }
                }

                /* access modifiers changed from: protected */
                public void onPostExecute(Object obj) {
                    super.onPostExecute(obj);
                    Glide.G(VDViewerFragment.this.r()).h(this.f30067a).B2(VDViewerFragment.this.M4);
                }
            }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
        }

        public boolean y4(WebView webView, String str, String str2, String str3) {
            iMDLogger.j("Override", "Url : " + str + ", Scheme : " + str2 + ", Resource : " + str3);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.f1175activity_general_viewer);
        Y0(new VDViewerFragment(), bundle);
    }
}
