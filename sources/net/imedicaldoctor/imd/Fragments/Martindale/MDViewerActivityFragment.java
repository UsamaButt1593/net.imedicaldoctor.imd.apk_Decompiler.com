package net.imedicaldoctor.imd.Fragments.Martindale;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.WebView;
import androidx.media3.exoplayer.ExoPlayer;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.itextpdf.text.Annotation;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.Amirsys.ASSectionViewer;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.Gallery.GalleryActivity;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.iMDLogger;
import org.apache.commons.lang3.StringUtils;

public class MDViewerActivityFragment extends ViewerHelperFragment {
    public Bundle X4;
    public ArrayList<String> Y4;
    public ArrayList<Bundle> Z4;
    public ArrayList<Bundle> a5;
    public String b5;
    public TabLayout c5;

    private void L4(String str) {
        ArrayList<String> arrayList = this.Y4;
        if (arrayList == null || arrayList.size() == 0) {
            CompressHelper.x2(r(), "There is no images in this document", 1);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<String> it2 = this.Y4.iterator();
        while (it2.hasNext()) {
            String next = it2.next();
            Bundle bundle = new Bundle();
            bundle.putString("ImagePath", next);
            bundle.putString("Description", "");
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

    public void I4(String str) {
        TabLayout.Tab I = this.c5.I();
        I.D(str);
        this.c5.i(I);
    }

    public void J4(String str) {
        String str2;
        CompressHelper compressHelper;
        Bundle bundle;
        String str3;
        if (str.equals("Monograph")) {
            CompressHelper compressHelper2 = this.Q4;
            Bundle bundle2 = this.D4;
            this.a5 = compressHelper2.V(bundle2, "Select * from fields where docId='" + this.E4 + "' AND doctype=0");
            compressHelper = this.Q4;
            bundle = this.X4;
            str3 = "monograph";
        } else if (str.equals("Adult Pt Ed")) {
            CompressHelper compressHelper3 = this.Q4;
            Bundle bundle3 = this.D4;
            this.a5 = compressHelper3.V(bundle3, "Select * from fields where docId='" + this.E4 + "' AND doctype=1");
            compressHelper = this.Q4;
            bundle = this.X4;
            str3 = "adult_ed";
        } else if (str.equals("Ped Pt Ed")) {
            CompressHelper compressHelper4 = this.Q4;
            Bundle bundle4 = this.D4;
            this.a5 = compressHelper4.V(bundle4, "Select * from fields where docId='" + this.E4 + "' AND doctype=2");
            compressHelper = this.Q4;
            bundle = this.X4;
            str3 = "ped_ed";
        } else {
            if (str.equals("Products")) {
                str2 = this.Q4.B(this.X4.getString("product_list"), this.X4.getString("id"), "127").replace("<button class=\"btn\" type=\"button\">See More</button>", "").replace("<th style=\"min-width:65px;\">Product Image and Details</th>", "");
                this.a5 = null;
            } else {
                str2 = "";
            }
            String d4 = d4(r(), "MDHeader.css");
            String d42 = d4(r(), "MDFooter.css");
            String replace = d4.replace("[size]", "200").replace("[title]", this.F4).replace("[include]", "");
            this.A4 = replace + str2 + d42;
            O3(this.A4, CompressHelper.g1(this.D4, "base"));
        }
        str2 = compressHelper.B(bundle.getString(str3), this.X4.getString("id"), "127");
        try {
            String d43 = d4(r(), "MDHeader.css");
            String d422 = d4(r(), "MDFooter.css");
            String replace2 = d43.replace("[size]", "200").replace("[title]", this.F4).replace("[include]", "");
            this.A4 = replace2 + str2 + d422;
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            e2.printStackTrace();
        }
        O3(this.A4, CompressHelper.g1(this.D4, "base"));
    }

    public String K4(String str) {
        ArrayList arrayList = new ArrayList(Arrays.asList(StringUtils.splitByWholeSeparator(str, "/")));
        arrayList.remove(arrayList.size() - 1);
        return StringUtils.join((Iterable<?>) arrayList, "/");
    }

    public String R2() {
        return w3(this.Y4);
    }

    public View U0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.C4;
        if (view != null) {
            return view;
        }
        View inflate = layoutInflater.inflate(R.layout.f1257fragment_new_viewer_tab, viewGroup, false);
        this.C4 = inflate;
        r4(inflate, bundle);
        this.c5 = (TabLayout) this.C4.findViewById(R.id.f1111tabs);
        if (y() == null) {
            return this.C4;
        }
        T2(new Runnable() {
            public void run() {
                try {
                    String str = MDViewerActivityFragment.this.A4;
                    if (str != null) {
                        if (str.length() == 0) {
                        }
                        MDViewerActivityFragment.this.m3();
                        return;
                    }
                    MDViewerActivityFragment mDViewerActivityFragment = MDViewerActivityFragment.this;
                    CompressHelper compressHelper = mDViewerActivityFragment.Q4;
                    Bundle bundle = mDViewerActivityFragment.D4;
                    ArrayList<Bundle> V = compressHelper.V(bundle, "Select * from docs where id=" + MDViewerActivityFragment.this.E4);
                    if (V != null) {
                        if (V.size() != 0) {
                            MDViewerActivityFragment.this.X4 = V.get(0);
                            MDViewerActivityFragment mDViewerActivityFragment2 = MDViewerActivityFragment.this;
                            mDViewerActivityFragment2.F4 = mDViewerActivityFragment2.X4.getString("title");
                            MDViewerActivityFragment.this.I4("Monograph");
                            if (MDViewerActivityFragment.this.X4.getString("adult_ed").length() > 0) {
                                MDViewerActivityFragment.this.I4("Adult Pt Ed");
                            }
                            if (MDViewerActivityFragment.this.X4.getString("ped_ed").length() > 0) {
                                MDViewerActivityFragment.this.I4("Ped Pt Ed");
                            }
                            if (MDViewerActivityFragment.this.X4.getString("product_list").length() > 0) {
                                MDViewerActivityFragment.this.I4("Products");
                            }
                            MDViewerActivityFragment.this.c5.setOnTabSelectedListener((TabLayout.OnTabSelectedListener) new TabLayout.OnTabSelectedListener() {
                                public void a(TabLayout.Tab tab) {
                                }

                                public void b(TabLayout.Tab tab) {
                                    MDViewerActivityFragment.this.J4(tab.n().toString());
                                }

                                public void c(TabLayout.Tab tab) {
                                }
                            });
                            MDViewerActivityFragment.this.m3();
                            return;
                        }
                    }
                    MDViewerActivityFragment.this.p4 = "Document doesn't exist";
                } catch (Exception e2) {
                    e2.printStackTrace();
                    MDViewerActivityFragment.this.p4 = e2.getLocalizedMessage();
                }
            }
        }, new Runnable() {
            public void run() {
                String str = MDViewerActivityFragment.this.p4;
                if (str == null || str.length() <= 0) {
                    MDViewerActivityFragment.this.J4("Monograph");
                    MDViewerActivityFragment.this.s4();
                    MDViewerActivityFragment.this.p4();
                    MDViewerActivityFragment.this.f3(R.menu.f1411elsviewer2);
                    MDViewerActivityFragment.this.o2(false);
                    MDViewerActivityFragment.this.G3();
                    return;
                }
                MDViewerActivityFragment mDViewerActivityFragment = MDViewerActivityFragment.this;
                mDViewerActivityFragment.C4(mDViewerActivityFragment.p4);
            }
        });
        return this.C4;
    }

    public boolean W3(ConsoleMessage consoleMessage) {
        String str;
        String[] split = consoleMessage.message().split(",,,,,");
        String g1 = CompressHelper.g1(this.D4, "base");
        if (split[0].equals("images")) {
            if (split.length < 2) {
                return true;
            }
            String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(split[1], "|");
            ArrayList<String> arrayList = new ArrayList<>();
            for (String str2 : splitByWholeSeparator) {
                if (str2.contains("/")) {
                    String replace = g1.replace("file://", "");
                    str = replace.substring(0, replace.length() - 1);
                    for (String str3 : StringUtils.splitByWholeSeparator(str2, "/")) {
                        if (str3.equals("..")) {
                            str = K4(str);
                        } else {
                            str = str + "/" + str3;
                        }
                    }
                } else {
                    str = g1 + "/" + str2;
                }
                if (new File(str).length() > ExoPlayer.a1) {
                    arrayList.add(str);
                }
                iMDLogger.j("EPUB Images", "Imagepath = : " + str);
            }
            this.Y4 = arrayList;
            o4();
        }
        return super.W3(consoleMessage);
    }

    public void Z3(WebView webView, String str) {
        super.Z3(webView, str);
        this.G4.g("ConvertAllImages();");
        this.G4.g("console.log(\"images,,,,,\" + getImageList());");
        this.G4.g("onBodyLoad();");
    }

    public boolean e1(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.f799action_gallery) {
            L4("asdfafdsaf");
            return true;
        }
        if (itemId == R.id.f801action_menu) {
            ASSectionViewer aSSectionViewer = new ASSectionViewer();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("Items", this.a5);
            bundle.putString("TitleProperty", "title");
            aSSectionViewer.A2(this, 0);
            aSSectionViewer.i2(bundle);
            aSSectionViewer.Z2(true);
            aSSectionViewer.e3(M(), "asdfasdfasdf");
        }
        return super.e1(menuItem);
    }

    public boolean y4(WebView webView, String str, String str2, String str3) {
        String str4;
        if (str2.equals("image")) {
            L4(str3);
            return true;
        }
        if (str2.equals(Annotation.k3) || (str2.equals("http") && str3.contains("localhost:"))) {
            String t1 = this.Q4.t1(StringUtils.splitByWholeSeparator(str3, "/"));
            if (!(t1 == null || t1.length() == 0)) {
                if (t1.contains("?")) {
                    t1 = StringUtils.splitByWholeSeparator(t1, "?")[0];
                }
                if (str3.contains("/pated_f/")) {
                    Bundle Y0 = this.Q4.Y0("Name", "259_pated_f.sqlite");
                    if (Y0 == null) {
                        CompressHelper.x2(r(), "You Must Install Adult Patient Education Database", 1);
                        return true;
                    }
                    this.Q4.A1(Y0, t1, (String[]) null, (String) null);
                }
                if (str3.contains("/pedip_f/")) {
                    Bundle Y02 = this.Q4.Y0("Name", "261_pedip_f.sqlite");
                    if (Y02 == null) {
                        CompressHelper.x2(r(), "You Must Install Pediatric Patient Education Database", 1);
                        return true;
                    }
                    this.Q4.A1(Y02, t1, (String[]) null, (String) null);
                }
                if (t1.contains("#")) {
                    str4 = this.Q4.t1(StringUtils.splitByWholeSeparator(t1, "#"));
                    t1 = StringUtils.splitByWholeSeparator(t1, "#")[0];
                } else {
                    str4 = "";
                }
                if (t1.equals(this.E4)) {
                    C3(str4);
                    return true;
                }
                CompressHelper compressHelper = this.Q4;
                Bundle bundle = this.D4;
                if (compressHelper.s1(compressHelper.V(bundle, "Select * from docs where id = '" + t1 + "'")) != null) {
                    this.Q4.A1(this.D4, t1, (String[]) null, str4);
                }
            }
            return true;
        }
        iMDLogger.j("Override", "Url : " + str + ", Scheme : " + str2 + ", Resource : " + str3);
        return true;
    }
}
