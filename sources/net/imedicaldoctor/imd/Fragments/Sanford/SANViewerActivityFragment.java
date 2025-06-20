package net.imedicaldoctor.imd.Fragments.Sanford;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.WebView;
import androidx.media3.exoplayer.ExoPlayer;
import com.itextpdf.text.Annotation;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.Gallery.GalleryActivity;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.iMDLogger;
import org.apache.commons.lang3.StringUtils;

public class SANViewerActivityFragment extends ViewerHelperFragment {
    public Bundle X4;
    public ArrayList<String> Y4;
    public ArrayList<Bundle> Z4;
    public boolean a5;

    private void J4(String str) {
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

    public String I4(String str) {
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
        View inflate = layoutInflater.inflate(R.layout.f1255fragment_new_viewer, viewGroup, false);
        this.C4 = inflate;
        this.a5 = true;
        r4(inflate, bundle);
        if (y() == null) {
            return this.C4;
        }
        T2(new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:26:0x00be A[Catch:{ Exception -> 0x0013 }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r10 = this;
                    java.lang.String r0 = ">"
                    java.lang.String r1 = "<body"
                    java.lang.String r2 = ""
                    net.imedicaldoctor.imd.Fragments.Sanford.SANViewerActivityFragment r3 = net.imedicaldoctor.imd.Fragments.Sanford.SANViewerActivityFragment.this     // Catch:{ Exception -> 0x0013 }
                    java.lang.String r3 = r3.A4     // Catch:{ Exception -> 0x0013 }
                    if (r3 == 0) goto L_0x0016
                    int r3 = r3.length()     // Catch:{ Exception -> 0x0013 }
                    if (r3 != 0) goto L_0x0108
                    goto L_0x0016
                L_0x0013:
                    r0 = move-exception
                    goto L_0x00fd
                L_0x0016:
                    java.lang.String r3 = "Loading Document"
                    net.imedicaldoctor.imd.Fragments.Sanford.SANViewerActivityFragment r4 = net.imedicaldoctor.imd.Fragments.Sanford.SANViewerActivityFragment.this     // Catch:{ Exception -> 0x0013 }
                    java.lang.String r4 = r4.E4     // Catch:{ Exception -> 0x0013 }
                    net.imedicaldoctor.imd.iMDLogger.f(r3, r4)     // Catch:{ Exception -> 0x0013 }
                    net.imedicaldoctor.imd.Fragments.Sanford.SANViewerActivityFragment r3 = net.imedicaldoctor.imd.Fragments.Sanford.SANViewerActivityFragment.this     // Catch:{ Exception -> 0x0013 }
                    android.os.Bundle r4 = r3.D4     // Catch:{ Exception -> 0x0013 }
                    java.lang.String r3 = r3.E4     // Catch:{ Exception -> 0x0013 }
                    java.lang.String r3 = net.imedicaldoctor.imd.Data.CompressHelper.g1(r4, r3)     // Catch:{ Exception -> 0x0013 }
                    net.imedicaldoctor.imd.Fragments.Sanford.SANViewerActivityFragment r4 = net.imedicaldoctor.imd.Fragments.Sanford.SANViewerActivityFragment.this     // Catch:{ Exception -> 0x0013 }
                    net.imedicaldoctor.imd.Data.CompressHelper r4 = r4.Q4     // Catch:{ Exception -> 0x0013 }
                    java.lang.String r3 = r4.f2(r3)     // Catch:{ Exception -> 0x0013 }
                    if (r3 == 0) goto L_0x00f6
                    int r4 = r3.length()     // Catch:{ Exception -> 0x0013 }
                    if (r4 != 0) goto L_0x003b
                    goto L_0x00f6
                L_0x003b:
                    net.imedicaldoctor.imd.Fragments.Sanford.SANViewerActivityFragment r4 = net.imedicaldoctor.imd.Fragments.Sanford.SANViewerActivityFragment.this     // Catch:{ Exception -> 0x0013 }
                    java.lang.String r5 = "<title>"
                    java.lang.String r6 = "</title>"
                    java.lang.String r5 = net.imedicaldoctor.imd.Data.CompressHelper.f(r3, r5, r6)     // Catch:{ Exception -> 0x0013 }
                    r4.F4 = r5     // Catch:{ Exception -> 0x0013 }
                    net.imedicaldoctor.imd.Fragments.Sanford.SANViewerActivityFragment r4 = net.imedicaldoctor.imd.Fragments.Sanford.SANViewerActivityFragment.this     // Catch:{ Exception -> 0x0013 }
                    java.lang.String r5 = r4.F4     // Catch:{ Exception -> 0x0013 }
                    java.lang.String r6 = "\n"
                    java.lang.String r5 = r5.replace(r6, r2)     // Catch:{ Exception -> 0x0013 }
                    r4.F4 = r5     // Catch:{ Exception -> 0x0013 }
                    java.lang.String r4 = "<body style=\"-webkit-text-size-adjust:200%;\" "
                    net.imedicaldoctor.imd.Fragments.Sanford.SANViewerActivityFragment r5 = net.imedicaldoctor.imd.Fragments.Sanford.SANViewerActivityFragment.this     // Catch:{ Exception -> 0x0070 }
                    androidx.fragment.app.FragmentActivity r6 = r5.r()     // Catch:{ Exception -> 0x0070 }
                    java.lang.String r7 = "SANStyle.css"
                    java.lang.String r5 = r5.d4(r6, r7)     // Catch:{ Exception -> 0x0070 }
                    net.imedicaldoctor.imd.Fragments.Sanford.SANViewerActivityFragment r6 = net.imedicaldoctor.imd.Fragments.Sanford.SANViewerActivityFragment.this     // Catch:{ Exception -> 0x006e }
                    androidx.fragment.app.FragmentActivity r7 = r6.r()     // Catch:{ Exception -> 0x006e }
                    java.lang.String r8 = "SANJava.css"
                    java.lang.String r6 = r6.d4(r7, r8)     // Catch:{ Exception -> 0x006e }
                    goto L_0x0090
                L_0x006e:
                    r6 = move-exception
                    goto L_0x0072
                L_0x0070:
                    r6 = move-exception
                    r5 = r2
                L_0x0072:
                    com.google.firebase.crashlytics.FirebaseCrashlytics r7 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()     // Catch:{ Exception -> 0x0013 }
                    r7.g(r6)     // Catch:{ Exception -> 0x0013 }
                    java.lang.String r7 = "MHViewer"
                    java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0013 }
                    r8.<init>()     // Catch:{ Exception -> 0x0013 }
                    java.lang.String r9 = "Error in reading EPUBStyle and EPUBJava : "
                    r8.append(r9)     // Catch:{ Exception -> 0x0013 }
                    r8.append(r6)     // Catch:{ Exception -> 0x0013 }
                    java.lang.String r6 = r8.toString()     // Catch:{ Exception -> 0x0013 }
                    net.imedicaldoctor.imd.iMDLogger.f(r7, r6)     // Catch:{ Exception -> 0x0013 }
                    r6 = r2
                L_0x0090:
                    java.lang.String r7 = "</head>"
                    java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0013 }
                    r8.<init>()     // Catch:{ Exception -> 0x0013 }
                    java.lang.String r9 = "<style type=\"text/css\">"
                    r8.append(r9)     // Catch:{ Exception -> 0x0013 }
                    r8.append(r5)     // Catch:{ Exception -> 0x0013 }
                    java.lang.String r5 = "</style><script type=\"text/javascript\">"
                    r8.append(r5)     // Catch:{ Exception -> 0x0013 }
                    r8.append(r6)     // Catch:{ Exception -> 0x0013 }
                    java.lang.String r5 = "</script></head>"
                    r8.append(r5)     // Catch:{ Exception -> 0x0013 }
                    java.lang.String r5 = r8.toString()     // Catch:{ Exception -> 0x0013 }
                    java.lang.String r3 = r3.replace(r7, r5)     // Catch:{ Exception -> 0x0013 }
                    java.lang.String r3 = r3.replace(r1, r4)     // Catch:{ Exception -> 0x0013 }
                    java.lang.String r4 = net.imedicaldoctor.imd.Data.CompressHelper.f(r3, r1, r0)     // Catch:{ Exception -> 0x0013 }
                    if (r4 != 0) goto L_0x00bf
                    r4 = r2
                L_0x00bf:
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0013 }
                    r5.<init>()     // Catch:{ Exception -> 0x0013 }
                    r5.append(r1)     // Catch:{ Exception -> 0x0013 }
                    r5.append(r4)     // Catch:{ Exception -> 0x0013 }
                    r5.append(r0)     // Catch:{ Exception -> 0x0013 }
                    java.lang.String r0 = r5.toString()     // Catch:{ Exception -> 0x0013 }
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0013 }
                    r1.<init>()     // Catch:{ Exception -> 0x0013 }
                    java.lang.String r5 = "<body onload=\\\"onBodyLoad();\\\" style=\\\"-webkit-text-size-adjust:200%;\" "
                    r1.append(r5)     // Catch:{ Exception -> 0x0013 }
                    r1.append(r4)     // Catch:{ Exception -> 0x0013 }
                    java.lang.String r4 = "> <script src=\"file:///android_asset/log4javascript.js\" ></script><script src=\"file:///android_asset/core.js\" ></script><script src=\"file:///android_asset/dom.js\" ></script><script src=\"file:///android_asset/domrange.js\" ></script><script src=\"file:///android_asset/wrappedrange.js\" ></script><script src=\"file:///android_asset/wrappedselection.js\" ></script><script src=\"file:///android_asset/rangy-cssclassapplier.js\" ></script><script src=\"file:///android_asset/rangy-highlighter.js\" ></script><script src=\"file:///android_asset/hightlight.js\" ></script><script src=\"file:///android_asset/find.js\" ></script>"
                    r1.append(r4)     // Catch:{ Exception -> 0x0013 }
                    java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0013 }
                    java.lang.String r0 = r3.replace(r0, r1)     // Catch:{ Exception -> 0x0013 }
                    java.lang.String r1 = "width=device-width,"
                    java.lang.String r0 = r0.replace(r1, r2)     // Catch:{ Exception -> 0x0013 }
                    net.imedicaldoctor.imd.Fragments.Sanford.SANViewerActivityFragment r1 = net.imedicaldoctor.imd.Fragments.Sanford.SANViewerActivityFragment.this     // Catch:{ Exception -> 0x0013 }
                    r1.A4 = r0     // Catch:{ Exception -> 0x0013 }
                    goto L_0x0108
                L_0x00f6:
                    net.imedicaldoctor.imd.Fragments.Sanford.SANViewerActivityFragment r0 = net.imedicaldoctor.imd.Fragments.Sanford.SANViewerActivityFragment.this     // Catch:{ Exception -> 0x0013 }
                    java.lang.String r1 = "Document doesn't exist"
                    r0.p4 = r1     // Catch:{ Exception -> 0x0013 }
                    return
                L_0x00fd:
                    r0.printStackTrace()
                    net.imedicaldoctor.imd.Fragments.Sanford.SANViewerActivityFragment r1 = net.imedicaldoctor.imd.Fragments.Sanford.SANViewerActivityFragment.this
                    java.lang.String r0 = r0.getLocalizedMessage()
                    r1.p4 = r0
                L_0x0108:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.Sanford.SANViewerActivityFragment.AnonymousClass1.run():void");
            }
        }, new Runnable() {
            public void run() {
                String str = SANViewerActivityFragment.this.p4;
                if (str == null || str.length() <= 0) {
                    String string = SANViewerActivityFragment.this.D4.getString("Path");
                    SANViewerActivityFragment sANViewerActivityFragment = SANViewerActivityFragment.this;
                    sANViewerActivityFragment.O3(sANViewerActivityFragment.A4, string);
                    SANViewerActivityFragment.this.s4();
                    SANViewerActivityFragment.this.p4();
                    SANViewerActivityFragment.this.f3(R.menu.f1411elsviewer2);
                    SANViewerActivityFragment.this.o2(false);
                    SANViewerActivityFragment.this.G3();
                    return;
                }
                SANViewerActivityFragment sANViewerActivityFragment2 = SANViewerActivityFragment.this;
                sANViewerActivityFragment2.C4(sANViewerActivityFragment2.p4);
            }
        });
        return this.C4;
    }

    public boolean W3(ConsoleMessage consoleMessage) {
        String str;
        String[] split = consoleMessage.message().split(",,,,,");
        String string = this.D4.getString("Path");
        if (split[0].equals("images")) {
            if (split.length < 2) {
                return true;
            }
            String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(split[1], "|");
            ArrayList<String> arrayList = new ArrayList<>();
            for (String str2 : splitByWholeSeparator) {
                if (str2.contains("/")) {
                    String replace = string.replace("file://", "");
                    str = replace.substring(0, replace.length() - 1);
                    for (String str3 : StringUtils.splitByWholeSeparator(str2, "/")) {
                        if (str3.equals("..")) {
                            str = I4(str);
                        } else {
                            str = str + "/" + str3;
                        }
                    }
                } else {
                    str = string + "/" + str2;
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
        this.G4.g("ConvertAllImages();");
        this.G4.g("fixAllImages2();");
        this.G4.g("console.log(\"images,,,,,\" + getImageList());");
        super.Z3(webView, str);
    }

    public boolean e1(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.f799action_gallery) {
            return super.e1(menuItem);
        }
        J4("asdfafdsaf");
        return true;
    }

    public void e3(Menu menu) {
        menu.removeItem(R.id.f801action_menu);
    }

    public boolean y4(WebView webView, String str, String str2, String str3) {
        String str4;
        iMDLogger.j("Override", "Url : " + str + ", Scheme : " + str2 + ", Resource : " + str3);
        if (str2.equals("image")) {
            J4(str3);
            return true;
        } else if (str2.equals(Annotation.k3) || (str2.equals("http") && str3.contains("localhost:"))) {
            CompressHelper compressHelper = new CompressHelper(r());
            String str5 = "//" + this.D4.getString("Path") + "/";
            if (str.contains("#")) {
                str4 = StringUtils.splitByWholeSeparator(str, "#")[1];
                iMDLogger.f("Testing", "BasePath : " + str5 + ", Resource : " + str3 + ", mPath : " + this.E4);
                str3 = str3.replace(str5, "");
                if (this.E4.equalsIgnoreCase(str3)) {
                    C3(str4);
                    return true;
                }
            } else {
                str4 = "";
            }
            iMDLogger.f("Testing", "BasePath : " + str5 + ", Resource : " + str3 + ", mPath : " + this.E4);
            String replace = str3.replace(str5, "");
            if (!new File(CompressHelper.g1(this.D4, replace)).exists()) {
                replace = compressHelper.t1(StringUtils.splitByWholeSeparator(replace, "/"));
                if (!replace.endsWith(".html")) {
                    replace = replace + ".html";
                }
                if (!new File(CompressHelper.g1(this.D4, replace)).exists()) {
                    CompressHelper.x2(r(), "Sorry, Document not available", 1);
                    return true;
                }
            }
            compressHelper.A1(this.D4, replace, (String[]) null, str4);
            return true;
        } else {
            if (str2.equals("http")) {
                a4(str);
            }
            return true;
        }
    }
}
