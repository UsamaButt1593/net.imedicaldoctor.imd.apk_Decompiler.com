package net.imedicaldoctor.imd.Fragments.Medhand;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.ExoPlayer;
import com.google.android.material.appbar.AppBarLayout;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.io.File;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import net.imedicaldoctor.imd.CollapsingToolbar.CollapsingToolbarLayout;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.ViewerHelperActivity;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.Gallery.GalleryActivity;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Utils.iMDWebView;
import net.imedicaldoctor.imd.iMDLogger;
import org.apache.commons.lang3.StringUtils;

public class MHViewerActivity extends ViewerHelperActivity {

    public static class MHViewerFragment extends ViewerHelperFragment {
        public ArrayList<Bundle> X4;
        public String Y4;
        public String Z4;
        public String a5;
        public boolean b5;
        public ArrayList<String> c5;
        public String d5;
        public int e5;
        public boolean f5;
        private boolean g5;

        private Bundle M4(String str, String str2) {
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            bundle.putString(TypedValues.CycleType.R, str2);
            return bundle;
        }

        private void T4(String str) {
            ArrayList<String> arrayList = this.c5;
            if (arrayList == null || arrayList.size() == 0) {
                CompressHelper.x2(r(), "There is no images in this document", 1);
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator<String> it2 = this.c5.iterator();
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
                if (((Bundle) arrayList2.get(i3)).getString("id").equals(str)) {
                    i2 = i3;
                }
            }
            Intent intent = new Intent(r(), GalleryActivity.class);
            intent.putExtra("Images", arrayList2);
            intent.putExtra("Start", i2);
            D2(intent);
        }

        public void I4() {
            this.s4.findItem(R.id.f792action_back).setEnabled(false);
            this.s4.findItem(R.id.f792action_back).setIcon(R.drawable.L5);
        }

        public void J4() {
            this.s4.findItem(R.id.f798action_forward).setEnabled(false);
            this.s4.findItem(R.id.f798action_forward).setIcon(R.drawable.I5);
        }

        public void K4() {
            this.s4.findItem(R.id.f792action_back).setEnabled(true);
            this.s4.findItem(R.id.f792action_back).setIcon(R.drawable.J5);
        }

        public void L4() {
            this.s4.findItem(R.id.f798action_forward).setEnabled(true);
            this.s4.findItem(R.id.f798action_forward).setIcon(R.drawable.G5);
        }

        public void N4() {
            if (this.X4.size() == 0) {
                I4();
                J4();
                return;
            }
            if (this.e5 > 0 || this.f5) {
                K4();
            } else {
                I4();
            }
            if (this.e5 >= this.X4.size() - 1) {
                J4();
            } else {
                L4();
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x00ca  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String O4(java.lang.String r7) {
            /*
                r6 = this;
                net.imedicaldoctor.imd.Data.CompressHelper r0 = r6.Q4
                android.os.Bundle r1 = r6.D4
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "select * from content where addr = '"
                r2.append(r3)
                r2.append(r7)
                java.lang.String r3 = "'"
                r2.append(r3)
                java.lang.String r2 = r2.toString()
                java.lang.String r3 = "content.db"
                java.util.ArrayList r0 = r0.W(r1, r2, r3)
                r1 = 1
                java.lang.String r2 = ""
                if (r0 == 0) goto L_0x00fe
                int r3 = r0.size()
                if (r3 != 0) goto L_0x002d
                goto L_0x00fe
            L_0x002d:
                r7 = 0
                java.lang.Object r7 = r0.get(r7)
                android.os.Bundle r7 = (android.os.Bundle) r7
                net.imedicaldoctor.imd.Data.CompressHelper r0 = r6.Q4
                java.lang.String r3 = "content"
                java.lang.String r3 = r7.getString(r3)
                net.imedicaldoctor.imd.Data.CompressHelper r4 = r6.Q4
                java.lang.String r5 = "addr"
                java.lang.String r7 = r7.getString(r5)
                java.lang.String r5 = "\\"
                java.lang.String[] r7 = org.apache.commons.lang3.StringUtils.splitByWholeSeparator(r7, r5)
                java.lang.String r7 = r4.t1(r7)
                java.lang.String r4 = "127"
                java.lang.String r7 = r0.B(r3, r7, r4)
                java.lang.String r0 = "class=\"large\" />"
                boolean r0 = r7.contains(r0)
                r0 = r0 ^ r1
                r6.b5 = r0
                androidx.fragment.app.FragmentActivity r0 = r6.r()     // Catch:{ Exception -> 0x0074 }
                java.lang.String r1 = "MHStyle.css"
                java.lang.String r0 = r6.d4(r0, r1)     // Catch:{ Exception -> 0x0074 }
                androidx.fragment.app.FragmentActivity r1 = r6.r()     // Catch:{ Exception -> 0x0072 }
                java.lang.String r3 = "MHJava.css"
                java.lang.String r1 = r6.d4(r1, r3)     // Catch:{ Exception -> 0x0072 }
                goto L_0x0094
            L_0x0072:
                r1 = move-exception
                goto L_0x0076
            L_0x0074:
                r1 = move-exception
                r0 = r2
            L_0x0076:
                com.google.firebase.crashlytics.FirebaseCrashlytics r3 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()
                r3.g(r1)
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "Error in reading MHStyle and MHJAVA : "
                r3.append(r4)
                r3.append(r1)
                java.lang.String r1 = r3.toString()
                java.lang.String r3 = "MHViewer"
                net.imedicaldoctor.imd.iMDLogger.f(r3, r1)
                r1 = r2
            L_0x0094:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "<style type=\"text/css\">"
                r3.append(r4)
                r3.append(r0)
                java.lang.String r0 = "</style><script type=\"text/javascript\">"
                r3.append(r0)
                r3.append(r1)
                java.lang.String r0 = "</script></head>"
                r3.append(r0)
                java.lang.String r0 = r3.toString()
                java.lang.String r1 = "</head>"
                java.lang.String r7 = r7.replace(r1, r0)
                java.lang.String r0 = "<body "
                java.lang.String r1 = "<body style=\"-webkit-text-size-adjust:200%;\" "
                java.lang.String r7 = r7.replace(r0, r1)
                java.lang.String r0 = "<body"
                java.lang.String r1 = ">"
                java.lang.String r3 = net.imedicaldoctor.imd.Data.CompressHelper.f(r7, r0, r1)
                if (r3 != 0) goto L_0x00cb
                r3 = r2
            L_0x00cb:
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                r4.append(r0)
                r4.append(r3)
                r4.append(r1)
                java.lang.String r0 = r4.toString()
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r4 = "<body onload=\\\"onBodyLoad();\\\" style=\\\"-webkit-text-size-adjust:200%;\" "
                r1.append(r4)
                r1.append(r3)
                java.lang.String r3 = "> <script src=\"file:///android_asset/log4javascript.js\" ></script><script src=\"file:///android_asset/core.js\" ></script><script src=\"file:///android_asset/dom.js\" ></script><script src=\"file:///android_asset/domrange.js\" ></script><script src=\"file:///android_asset/wrappedrange.js\" ></script><script src=\"file:///android_asset/wrappedselection.js\" ></script><script src=\"file:///android_asset/rangy-cssclassapplier.js\" ></script><script src=\"file:///android_asset/rangy-highlighter.js\" ></script><script src=\"file:///android_asset/hightlight.js\" ></script><script src=\"file:///android_asset/find.js\" ></script>"
                r1.append(r3)
                java.lang.String r1 = r1.toString()
                java.lang.String r7 = r7.replace(r0, r1)
                java.lang.String r0 = "width=device-width,"
                java.lang.String r7 = r7.replace(r0, r2)
                return r7
            L_0x00fe:
                androidx.fragment.app.FragmentActivity r0 = r6.r()
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "Can't find page "
                r3.append(r4)
                r3.append(r7)
                java.lang.String r7 = r3.toString()
                net.imedicaldoctor.imd.Data.CompressHelper.x2(r0, r7, r1)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.Medhand.MHViewerActivity.MHViewerFragment.O4(java.lang.String):java.lang.String");
        }

        public void P4() {
            this.g5 = false;
            if (this.e5 == this.X4.size() - 1 && this.f5) {
                iMDWebView imdwebview = this.G4;
                imdwebview.g("console.log(\"history,,,,," + this.Y4 + ",,,,,\" + window.pageYOffset);");
                this.f5 = false;
                this.g5 = true;
            }
            if (!this.g5) {
                int i2 = this.e5;
                if (i2 - 1 >= 0) {
                    int i3 = i2 - 1;
                    this.e5 = i3;
                    this.d5 = this.X4.get(i3).getString(TypedValues.CycleType.R);
                    R4(this.X4.get(this.e5).getString("url"), Boolean.TRUE);
                }
            }
            N4();
        }

        public void Q4() {
            if (this.X4.size() != 0) {
                if (this.e5 + 1 <= this.X4.size() - 1) {
                    int i2 = this.e5 + 1;
                    this.e5 = i2;
                    this.d5 = this.X4.get(i2).getString(TypedValues.CycleType.R);
                    R4(this.X4.get(this.e5).getString("url"), Boolean.TRUE);
                }
                N4();
            }
        }

        public String R2() {
            ArrayList<String> arrayList = this.c5;
            if (arrayList == null || arrayList.size() <= 0) {
                return null;
            }
            return w3(this.c5);
        }

        public void R4(String str, Boolean bool) {
            String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(str, "#");
            String str2 = splitByWholeSeparator[0];
            String str3 = splitByWholeSeparator.length == 2 ? splitByWholeSeparator[1] : null;
            this.Y4 = str2;
            ArrayList arrayList = new ArrayList(Arrays.asList(StringUtils.splitByWholeSeparator(str2, "/")));
            arrayList.remove(arrayList.size() - 1);
            String g1 = CompressHelper.g1(this.D4, StringUtils.join((Iterable<?>) arrayList, "/"));
            String absolutePath = new File(g1).getAbsolutePath();
            this.Z4 = "file://" + absolutePath + "/";
            this.A4 = O4(str2.replace("/", "\\"));
            this.a5 = str3;
            if (bool.booleanValue()) {
                O3(this.A4, g1);
            }
        }

        public String S4(String str) {
            ArrayList arrayList = new ArrayList(Arrays.asList(StringUtils.splitByWholeSeparator(str, "/")));
            arrayList.remove(arrayList.size() - 1);
            return StringUtils.join((Iterable<?>) arrayList, "/");
        }

        public void T0(Menu menu, MenuInflater menuInflater) {
            menuInflater.inflate(R.menu.f1457menu_mhviewer, menu);
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
                this.X4 = bundle.getParcelableArrayList("mHistory");
                this.Y4 = bundle.getString("mCurrentURL");
                this.Z4 = bundle.getString("mLastBasePath");
                this.b5 = bundle.getBoolean("mNewZoom");
                this.c5 = bundle.getStringArrayList("mImages");
                this.d5 = bundle.getString("mGotoOffset");
                this.e5 = bundle.getInt("mHistoryIndex");
                this.f5 = bundle.getBoolean("mRegisterLastPage");
            }
            if (y() == null) {
                return inflate;
            }
            try {
                CompressHelper compressHelper = new CompressHelper(r());
                String str = this.A4;
                if (str != null) {
                    if (str.length() == 0) {
                    }
                    boolean x1 = compressHelper.x1();
                    m4("");
                    O3(this.A4, this.Z4);
                    s4();
                    p4();
                    f3(R.menu.f1457menu_mhviewer);
                    o2(false);
                    G3();
                    ((AppBarLayout) this.C4.findViewById(R.id.f825appbar)).D(false, true);
                    return inflate;
                }
                this.X4 = new ArrayList<>();
                R4(this.E4, Boolean.FALSE);
                boolean x12 = compressHelper.x1();
                m4("");
                O3(this.A4, this.Z4);
                s4();
                p4();
                f3(R.menu.f1457menu_mhviewer);
                o2(false);
                G3();
                ((AppBarLayout) this.C4.findViewById(R.id.f825appbar)).D(false, true);
                return inflate;
            } catch (Exception e2) {
                FirebaseCrashlytics.d().g(e2);
                B4(e2);
                return inflate;
            }
        }

        public boolean W3(ConsoleMessage consoleMessage) {
            String[] split = consoleMessage.message().split(",,,,,");
            boolean z = false;
            if (split[0].equals("title")) {
                this.F4 = split.length < 2 ? "Unnamed" : split[1];
                ((CollapsingToolbarLayout) this.C4.findViewById(R.id.f882collapsing_toolbar)).setTitle(this.F4);
                return true;
            }
            if (split[0].equals("images")) {
                String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(split[1], "|");
                ArrayList<String> arrayList = new ArrayList<>();
                for (String splitByWholeSeparator2 : splitByWholeSeparator) {
                    String replace = this.Z4.replace("file://", "");
                    String substring = replace.substring(0, replace.length() - 1);
                    for (String str : StringUtils.splitByWholeSeparator(splitByWholeSeparator2, "/")) {
                        if (str.equals("..")) {
                            substring = S4(substring);
                        } else {
                            substring = substring + "/" + str;
                        }
                    }
                    if (new File(substring).length() > ExoPlayer.a1) {
                        arrayList.add(substring);
                    }
                    iMDLogger.j("MedhandImages", "Imagepath = : " + substring);
                }
                this.c5 = arrayList;
                MenuItem findItem = this.s4.findItem(R.id.f799action_gallery);
                if (this.c5.size() > 0) {
                    z = true;
                }
                findItem.setVisible(z);
                o4();
                this.G4.g("IgnoreSmallImages();");
                this.G4.g("ConvertAllImages();");
                this.G4.g("fixAllImages2();");
            } else if (split[0].equals("history")) {
                this.X4.add(M4(split[1], split[2]));
                int size = this.X4.size();
                this.e5 = size - 1;
                if (this.g5) {
                    if (size - 2 >= 0) {
                        int i2 = size - 2;
                        this.e5 = i2;
                        this.d5 = this.X4.get(i2).getString(TypedValues.CycleType.R);
                        R4(this.X4.get(this.e5).getString("url"), Boolean.TRUE);
                    }
                    this.g5 = false;
                }
                N4();
            }
            return super.W3(consoleMessage);
        }

        public boolean X3(WebView webView, String str, String str2, JsResult jsResult) {
            jsResult.confirm();
            return true;
        }

        public void Z3(WebView webView, String str) {
            iMDWebView imdwebview;
            String str2;
            super.Z3(webView, str);
            this.G4.g("console.log(\"title,,,,,\" + document.title);");
            if (this.b5) {
                imdwebview = this.G4;
                str2 = "onBodyLoad();";
            } else {
                imdwebview = this.G4;
                str2 = "console.log(\"images,,,,,\" + getImageList());";
            }
            imdwebview.g(str2);
            if (this.d5 != null) {
                iMDWebView imdwebview2 = this.G4;
                imdwebview2.g("document.body.scrollTop=" + this.d5);
                this.d5 = null;
            }
            String str3 = this.a5;
            if (str3 != null) {
                C3(str3);
                this.a5 = null;
            }
        }

        public boolean e1(MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            if (itemId == R.id.f798action_forward) {
                Q4();
                return true;
            } else if (itemId == R.id.f792action_back) {
                P4();
                return true;
            } else if (itemId != R.id.f799action_gallery) {
                return super.e1(menuItem);
            } else {
                T4("soheilvb");
                return true;
            }
        }

        public void e3(Menu menu) {
            this.s4 = menu;
        }

        public void m1(Bundle bundle) {
            super.m1(bundle);
        }

        public boolean y4(WebView webView, String str, String str2, String str3) {
            if (str2.equals("image")) {
                T4(str3);
                return true;
            }
            iMDLogger.j("Override", "Url : " + str + ", Scheme : " + str2 + ", Resource : " + str3);
            new CompressHelper(r());
            this.f5 = true;
            try {
                str3 = URLDecoder.decode(str3, "UTF-8");
            } catch (Exception e2) {
                FirebaseCrashlytics.d().g(e2);
                iMDLogger.f("MHViewerShould", "Error in decoding " + str3 + " : " + e2.getMessage());
            }
            String substring = str3.replace(S4(CompressHelper.f1(this.D4)), "").substring(4);
            if (this.e5 != this.X4.size() - 1 && this.X4.size() > 0) {
                int i2 = this.e5;
                int size = this.X4.size() - this.e5;
                if (size != 0) {
                    for (int i3 = 0; i3 < size; i3++) {
                        this.X4.remove(i2);
                    }
                }
            }
            if (this.X4.size() != 0) {
                ArrayList<Bundle> arrayList = this.X4;
                if (arrayList.get(arrayList.size() - 1).getString("url").equals(this.Y4)) {
                    ArrayList<Bundle> arrayList2 = this.X4;
                    arrayList2.remove(arrayList2.size() - 1);
                }
            }
            iMDWebView imdwebview = this.G4;
            imdwebview.g("console.log(\"history,,,,," + this.Y4 + ",,,,,\" + window.pageYOffset);");
            N4();
            if (!substring.contains(".html")) {
                return true;
            }
            R4(substring, Boolean.TRUE);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.f1175activity_general_viewer);
        Y0(new MHViewerFragment(), bundle);
    }
}
