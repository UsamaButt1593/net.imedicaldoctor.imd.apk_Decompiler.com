package net.imedicaldoctor.imd.Fragments.Amirsys;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import com.bumptech.glide.Glide;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.itextpdf.text.Annotation;
import com.itextpdf.tool.xml.html.HTML;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.Gallery.GalleryActivity;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.iMDLogger;
import org.apache.commons.lang3.StringUtils;

public class ASDocActivityFragment extends ViewerHelperFragment {
    public Bundle X4;
    public ArrayList<Bundle> Y4;
    public ArrayList<Bundle> Z4;
    public ArrayList<Bundle> a5;
    public String b5;

    private void I4(String str) {
        if (this.Z4.size() == 0) {
            CompressHelper.x2(r(), "There is no media in this document", 1);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.Z4);
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

    public String R2() {
        ArrayList<Bundle> arrayList = this.Y4;
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        Bundle v3 = v3(this.Y4);
        Bundle bundle = this.D4;
        return CompressHelper.h1(bundle, v3.getString("id") + ".jpg", "images-E");
    }

    public View U0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.C4;
        if (view != null) {
            return view;
        }
        View inflate = layoutInflater.inflate(R.layout.f1255fragment_new_viewer, viewGroup, false);
        this.C4 = inflate;
        r4(inflate, bundle);
        if (y() == null) {
            return this.C4;
        }
        T2(new Runnable() {
            public void run() {
                try {
                    String str = ASDocActivityFragment.this.A4;
                    if (str != null) {
                        if (str.length() == 0) {
                        }
                        ASDocActivityFragment.this.m3();
                        return;
                    }
                    String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(ASDocActivityFragment.this.E4, ",,,");
                    ASDocActivityFragment aSDocActivityFragment = ASDocActivityFragment.this;
                    aSDocActivityFragment.b5 = splitByWholeSeparator[1];
                    CompressHelper compressHelper = aSDocActivityFragment.Q4;
                    Bundle bundle = aSDocActivityFragment.D4;
                    ArrayList<Bundle> V = compressHelper.V(bundle, "Select * from topics where id='" + ASDocActivityFragment.this.b5 + "'");
                    if (V != null) {
                        if (V.size() != 0) {
                            ASDocActivityFragment.this.X4 = V.get(0);
                            ASDocActivityFragment aSDocActivityFragment2 = ASDocActivityFragment.this;
                            aSDocActivityFragment2.F4 = ASDocActivityFragment.this.X4.getString("title") + " - " + ASDocActivityFragment.this.X4.getString("category");
                            ASDocActivityFragment aSDocActivityFragment3 = ASDocActivityFragment.this;
                            CompressHelper compressHelper2 = aSDocActivityFragment3.Q4;
                            Bundle bundle2 = aSDocActivityFragment3.D4;
                            aSDocActivityFragment3.a5 = compressHelper2.V(bundle2, "Select * from fields where topicId='" + ASDocActivityFragment.this.b5 + "'");
                            ASDocActivityFragment aSDocActivityFragment4 = ASDocActivityFragment.this;
                            CompressHelper compressHelper3 = aSDocActivityFragment4.Q4;
                            Bundle bundle3 = aSDocActivityFragment4.D4;
                            aSDocActivityFragment4.Y4 = compressHelper3.V(bundle3, "Select * from images where topic_id='" + ASDocActivityFragment.this.b5 + "'");
                            ASDocActivityFragment aSDocActivityFragment5 = ASDocActivityFragment.this;
                            if (aSDocActivityFragment5.Y4 == null) {
                                aSDocActivityFragment5.Y4 = new ArrayList<>();
                            }
                            ASDocActivityFragment.this.Z4 = new ArrayList<>();
                            Iterator<Bundle> it2 = ASDocActivityFragment.this.Y4.iterator();
                            while (it2.hasNext()) {
                                Bundle next = it2.next();
                                Bundle bundle4 = new Bundle();
                                Bundle bundle5 = ASDocActivityFragment.this.D4;
                                bundle4.putString("ImagePath", CompressHelper.h1(bundle5, next.getString("id") + ".jpg", "images-E"));
                                bundle4.putString("id", next.getString("id"));
                                bundle4.putString("Encrypted", IcyHeaders.a3);
                                bundle4.putString("DescriptionHTML2", ASDocActivityFragment.this.Q4.B(next.getString(HTML.Tag.f27619g), next.getString("id"), "127"));
                                bundle4.putBundle("db", ASDocActivityFragment.this.D4);
                                ASDocActivityFragment.this.Z4.add(bundle4);
                            }
                            ASDocActivityFragment aSDocActivityFragment6 = ASDocActivityFragment.this;
                            String d4 = aSDocActivityFragment6.d4(aSDocActivityFragment6.r(), "ASHeader.css");
                            ASDocActivityFragment aSDocActivityFragment7 = ASDocActivityFragment.this;
                            String d42 = aSDocActivityFragment7.d4(aSDocActivityFragment7.r(), "ASFooter.css");
                            String replace = d4.replace("[size]", "200").replace("[title]", ASDocActivityFragment.this.F4).replace("[include]", "");
                            ASDocActivityFragment aSDocActivityFragment8 = ASDocActivityFragment.this;
                            String B = aSDocActivityFragment8.Q4.B(aSDocActivityFragment8.X4.getString(Annotation.i3), ASDocActivityFragment.this.X4.getString("id"), "127");
                            ASDocActivityFragment aSDocActivityFragment9 = ASDocActivityFragment.this;
                            aSDocActivityFragment9.A4 = replace + B + d42;
                            ASDocActivityFragment.this.m3();
                            return;
                        }
                    }
                    ASDocActivityFragment.this.p4 = "Document doesn't exist";
                } catch (Exception e2) {
                    e2.printStackTrace();
                    ASDocActivityFragment.this.p4 = e2.getLocalizedMessage();
                }
            }
        }, new Runnable() {
            public void run() {
                String str = ASDocActivityFragment.this.p4;
                if (str == null || str.length() <= 0) {
                    String g1 = CompressHelper.g1(ASDocActivityFragment.this.D4, "base");
                    ASDocActivityFragment aSDocActivityFragment = ASDocActivityFragment.this;
                    aSDocActivityFragment.O3(aSDocActivityFragment.A4, g1);
                    ASDocActivityFragment.this.s4();
                    ASDocActivityFragment.this.p4();
                    ASDocActivityFragment.this.f3(R.menu.f1411elsviewer2);
                    ASDocActivityFragment.this.o2(false);
                    ASDocActivityFragment.this.G3();
                    return;
                }
                ASDocActivityFragment aSDocActivityFragment2 = ASDocActivityFragment.this;
                aSDocActivityFragment2.C4(aSDocActivityFragment2.p4);
            }
        });
        return this.C4;
    }

    public boolean e1(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.f799action_gallery) {
            I4("soheilvb");
        }
        if (itemId == R.id.f801action_menu) {
            ASSectionViewer aSSectionViewer = new ASSectionViewer();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("Items", this.a5);
            bundle.putString("TitleProperty", "fieldTitle");
            aSSectionViewer.i2(bundle);
            aSSectionViewer.A2(this, 0);
            aSSectionViewer.Z2(true);
            aSSectionViewer.e3(M(), "asdfasdfasdf");
        }
        return super.e1(menuItem);
    }

    public void o4() {
        new AsyncTask() {

            /* renamed from: a  reason: collision with root package name */
            byte[] f29619a;

            /* access modifiers changed from: protected */
            public Object doInBackground(Object[] objArr) {
                try {
                    File file = new File(ASDocActivityFragment.this.R2());
                    this.f29619a = new CompressHelper(ASDocActivityFragment.this.r()).w(CompressHelper.d2(file), file.getName(), "127");
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
                Glide.G(ASDocActivityFragment.this.r()).h(this.f29619a).B2(ASDocActivityFragment.this.M4);
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
    }

    public boolean y4(WebView webView, String str, String str2, String str3) {
        iMDLogger.j("Override", "Url : " + str + ", Scheme : " + str2 + ", Resource : " + str3);
        return true;
    }
}
