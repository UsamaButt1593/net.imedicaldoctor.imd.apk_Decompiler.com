package net.imedicaldoctor.imd.Fragments.Statdx;

import android.content.Intent;
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
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.Amirsys.ASSectionViewer;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.Gallery.GalleryActivity;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.iMDLogger;
import org.apache.commons.lang3.StringUtils;

public class SDDocActivityFragment extends ViewerHelperFragment {
    public Bundle X4;
    public ArrayList<Bundle> Y4;
    public ArrayList<Bundle> Z4;
    public ArrayList<Bundle> a5;
    public String b5;
    public String c5;

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
        String h1 = CompressHelper.h1(bundle, v3.getString("id") + ".jpg", "images-E");
        T3(v3.getString("id"), "images-E");
        return h1;
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
                String str;
                try {
                    String str2 = SDDocActivityFragment.this.A4;
                    if (str2 != null) {
                        if (str2.length() == 0) {
                        }
                        SDDocActivityFragment.this.m3();
                    }
                    SDDocActivityFragment.this.Z4 = new ArrayList<>();
                    String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(SDDocActivityFragment.this.E4, ",,,");
                    String str3 = "127";
                    if (splitByWholeSeparator.length == 3) {
                        SDDocActivityFragment sDDocActivityFragment = SDDocActivityFragment.this;
                        sDDocActivityFragment.c5 = splitByWholeSeparator[2];
                        CompressHelper compressHelper = sDDocActivityFragment.Q4;
                        Bundle bundle = sDDocActivityFragment.D4;
                        StringBuilder sb = new StringBuilder();
                        String str4 = "Document doesn't exist";
                        sb.append("Select id,title,description as content from cases where id='");
                        sb.append(SDDocActivityFragment.this.c5);
                        sb.append("'");
                        ArrayList<Bundle> V = compressHelper.V(bundle, sb.toString());
                        if (V != null) {
                            if (V.size() != 0) {
                                SDDocActivityFragment.this.X4 = V.get(0);
                                SDDocActivityFragment sDDocActivityFragment2 = SDDocActivityFragment.this;
                                sDDocActivityFragment2.F4 = sDDocActivityFragment2.X4.getString("title");
                                SDDocActivityFragment sDDocActivityFragment3 = SDDocActivityFragment.this;
                                CompressHelper compressHelper2 = sDDocActivityFragment3.Q4;
                                Bundle bundle2 = sDDocActivityFragment3.D4;
                                sDDocActivityFragment3.Y4 = compressHelper2.V(bundle2, "Select imageId as id, * from cases_images where caseId='" + SDDocActivityFragment.this.c5 + "'");
                                SDDocActivityFragment sDDocActivityFragment4 = SDDocActivityFragment.this;
                                if (sDDocActivityFragment4.Y4 == null) {
                                    sDDocActivityFragment4.Y4 = new ArrayList<>();
                                }
                                if (SDDocActivityFragment.this.Y4.size() > 0) {
                                    Iterator<Bundle> it2 = SDDocActivityFragment.this.Y4.iterator();
                                    while (it2.hasNext()) {
                                        Bundle next = it2.next();
                                        Bundle bundle3 = new Bundle();
                                        Bundle bundle4 = SDDocActivityFragment.this.D4;
                                        bundle3.putString("ImagePath", CompressHelper.h1(bundle4, next.getString("imageId") + ".jpg", "images-E"));
                                        bundle3.putString("id", next.getString("imageId"));
                                        bundle3.putString("Encrypted", IcyHeaders.a3);
                                        bundle3.putBundle("db", SDDocActivityFragment.this.D4);
                                        SDDocActivityFragment.this.Z4.add(bundle3);
                                    }
                                }
                                SDDocActivityFragment.this.a5 = new ArrayList<>();
                                Bundle bundle5 = new Bundle();
                                bundle5.putString("fieldTitle", "Description");
                                bundle5.putString("fieldId", "");
                                SDDocActivityFragment.this.a5.add(bundle5);
                                str = str3;
                            }
                        }
                        SDDocActivityFragment.this.p4 = str4;
                        return;
                    }
                    String str5 = "Document doesn't exist";
                    SDDocActivityFragment sDDocActivityFragment5 = SDDocActivityFragment.this;
                    sDDocActivityFragment5.b5 = splitByWholeSeparator[1];
                    CompressHelper compressHelper3 = sDDocActivityFragment5.Q4;
                    Bundle bundle6 = sDDocActivityFragment5.D4;
                    ArrayList<Bundle> V2 = compressHelper3.V(bundle6, "Select * from docs where id='" + SDDocActivityFragment.this.b5 + "'");
                    if (V2 != null) {
                        if (V2.size() != 0) {
                            SDDocActivityFragment.this.X4 = V2.get(0);
                            SDDocActivityFragment sDDocActivityFragment6 = SDDocActivityFragment.this;
                            sDDocActivityFragment6.F4 = SDDocActivityFragment.this.X4.getString("title") + " - " + SDDocActivityFragment.this.X4.getString("category");
                            SDDocActivityFragment sDDocActivityFragment7 = SDDocActivityFragment.this;
                            CompressHelper compressHelper4 = sDDocActivityFragment7.Q4;
                            Bundle bundle7 = sDDocActivityFragment7.D4;
                            sDDocActivityFragment7.Y4 = compressHelper4.V(bundle7, "Select * from images where docId='" + SDDocActivityFragment.this.b5 + "'");
                            SDDocActivityFragment sDDocActivityFragment8 = SDDocActivityFragment.this;
                            if (sDDocActivityFragment8.Y4 == null) {
                                sDDocActivityFragment8.Y4 = new ArrayList<>();
                            }
                            if (SDDocActivityFragment.this.Y4.size() > 0) {
                                Iterator<Bundle> it3 = SDDocActivityFragment.this.Y4.iterator();
                                while (it3.hasNext()) {
                                    Bundle next2 = it3.next();
                                    Bundle bundle8 = new Bundle();
                                    Bundle bundle9 = SDDocActivityFragment.this.D4;
                                    bundle8.putString("ImagePath", CompressHelper.h1(bundle9, next2.getString("id") + ".jpg", "images-E"));
                                    bundle8.putString("id", next2.getString("id"));
                                    bundle8.putString("Encrypted", IcyHeaders.a3);
                                    String str6 = str3;
                                    bundle8.putString("DescriptionHTML2", SDDocActivityFragment.this.Q4.B(next2.getString(HTML.Tag.f27619g), next2.getString("id"), str6));
                                    bundle8.putBundle("db", SDDocActivityFragment.this.D4);
                                    SDDocActivityFragment.this.Z4.add(bundle8);
                                    str3 = str6;
                                }
                            }
                            str = str3;
                            SDDocActivityFragment sDDocActivityFragment9 = SDDocActivityFragment.this;
                            CompressHelper compressHelper5 = sDDocActivityFragment9.Q4;
                            Bundle bundle10 = sDDocActivityFragment9.D4;
                            sDDocActivityFragment9.a5 = compressHelper5.V(bundle10, "Select * from fields where topicId='" + SDDocActivityFragment.this.b5 + "'");
                            SDDocActivityFragment sDDocActivityFragment10 = SDDocActivityFragment.this;
                            if (sDDocActivityFragment10.a5 == null) {
                                sDDocActivityFragment10.a5 = new ArrayList<>();
                            }
                        }
                    }
                    SDDocActivityFragment.this.p4 = str5;
                    return;
                    SDDocActivityFragment sDDocActivityFragment11 = SDDocActivityFragment.this;
                    String d4 = sDDocActivityFragment11.d4(sDDocActivityFragment11.r(), "ASHeader.css");
                    SDDocActivityFragment sDDocActivityFragment12 = SDDocActivityFragment.this;
                    String d42 = sDDocActivityFragment12.d4(sDDocActivityFragment12.r(), "ASFooter.css");
                    String replace = d4.replace("[size]", "200").replace("[title]", SDDocActivityFragment.this.F4).replace("[include]", "");
                    SDDocActivityFragment sDDocActivityFragment13 = SDDocActivityFragment.this;
                    String B = sDDocActivityFragment13.Q4.B(sDDocActivityFragment13.X4.getString(Annotation.i3), SDDocActivityFragment.this.X4.getString("id"), str);
                    SDDocActivityFragment sDDocActivityFragment14 = SDDocActivityFragment.this;
                    sDDocActivityFragment14.A4 = replace + B + d42;
                    SDDocActivityFragment.this.m3();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    SDDocActivityFragment.this.p4 = e2.getLocalizedMessage();
                }
            }
        }, new Runnable() {
            public void run() {
                String str = SDDocActivityFragment.this.p4;
                if (str == null || str.length() <= 0) {
                    String g1 = CompressHelper.g1(SDDocActivityFragment.this.D4, "base");
                    SDDocActivityFragment sDDocActivityFragment = SDDocActivityFragment.this;
                    sDDocActivityFragment.O3(sDDocActivityFragment.A4, g1);
                    SDDocActivityFragment.this.s4();
                    SDDocActivityFragment.this.p4();
                    SDDocActivityFragment.this.f3(R.menu.f1411elsviewer2);
                    SDDocActivityFragment.this.o2(false);
                    SDDocActivityFragment.this.G3();
                    return;
                }
                SDDocActivityFragment sDDocActivityFragment2 = SDDocActivityFragment.this;
                sDDocActivityFragment2.C4(sDDocActivityFragment2.p4);
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
            aSSectionViewer.A2(this, 0);
            aSSectionViewer.i2(bundle);
            aSSectionViewer.Z2(true);
            aSSectionViewer.e3(M(), "asdfasdfasdf");
        }
        return super.e1(menuItem);
    }

    public void o4() {
        S2().h6(Schedulers.e()).s4(AndroidSchedulers.e()).e6(new Consumer<String>() {
            /* renamed from: a */
            public void accept(String str) throws Throwable {
                if (str != null) {
                    File file = new File(str);
                    if (file.exists()) {
                        try {
                            Glide.G(SDDocActivityFragment.this.r()).h(new CompressHelper(SDDocActivityFragment.this.r()).w(CompressHelper.d2(file), file.getName(), "127")).B2(SDDocActivityFragment.this.M4);
                        } catch (Exception e2) {
                            FirebaseCrashlytics.d().g(e2);
                            iMDLogger.f("ImageGallery", "Error in decrypting image");
                        }
                    }
                }
            }
        }, new Consumer<Throwable>() {
            /* renamed from: a */
            public void accept(Throwable th) throws Throwable {
            }
        });
    }

    public boolean y4(WebView webView, String str, String str2, String str3) {
        iMDLogger.j("Override", "Url : " + str + ", Scheme : " + str2 + ", Resource : " + str3);
        return true;
    }
}
