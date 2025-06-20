package net.imedicaldoctor.imd.Fragments.AccessMedicine;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.WebView;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.ViewerHelperActivity;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.Gallery.GalleryActivity;
import net.imedicaldoctor.imd.GeneralDialogFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Utils.iMDWebView;
import net.imedicaldoctor.imd.iMDLogger;

public class AMViewerActivity extends ViewerHelperActivity {

    public static class AMViewerFragment extends ViewerHelperFragment {
        private GeneralDialogFragment X4;
        /* access modifiers changed from: private */
        public String Y4;
        /* access modifiers changed from: private */
        public MenuItem Z4;
        public ArrayList<Bundle> a5;
        public ArrayList<Bundle> b5;
        public ArrayList<Bundle> c5;
        public ArrayList<Bundle> d5;

        /* access modifiers changed from: private */
        public void I4() {
            String str;
            String str2;
            CompressHelper compressHelper = new CompressHelper(r());
            Bundle bundle = this.D4;
            ArrayList<Bundle> V = compressHelper.V(bundle, "Select rowid as _id, * from images where sectionId=" + this.E4);
            this.a5 = new ArrayList<>();
            String str3 = "\\|";
            String str4 = "Resources-E";
            if (V == null) {
                iMDLogger.j("LoadResources", "No images to load");
            } else {
                Iterator<Bundle> it2 = V.iterator();
                while (it2.hasNext()) {
                    Bundle next = it2.next();
                    String[] split = TextUtils.split(next.getString("image"), str3);
                    int length = split.length;
                    Iterator<Bundle> it3 = it2;
                    int i2 = 0;
                    while (i2 < length) {
                        String str5 = split[i2];
                        int i3 = length;
                        String h1 = CompressHelper.h1(this.D4, str5, str4);
                        String[] strArr = split;
                        if (!new File(h1).exists()) {
                            iMDLogger.f("AMViewerFragmet", "Image " + h1 + " not exist . ");
                            str = str3;
                            str2 = str4;
                        } else {
                            File file = new File(h1);
                            str2 = str4;
                            try {
                                String h12 = CompressHelper.h1(this.D4, str5, "base");
                                str = str3;
                                try {
                                    if (!new File(h12).exists()) {
                                        byte[] d2 = CompressHelper.d2(file);
                                        file.getName();
                                        CompressHelper.D2(new File(h12), compressHelper.w(d2, file.getName(), "127"));
                                    }
                                    Bundle bundle2 = new Bundle();
                                    bundle2.putString("ImagePath", h12);
                                    bundle2.putString("id", str5);
                                    bundle2.putString("Description", next.getString("descriptionSimple"));
                                    this.a5.add(bundle2);
                                } catch (Exception e2) {
                                    e = e2;
                                    iMDLogger.f("LoadResources", "Images Error in loading " + h1 + " . error " + e.getLocalizedMessage());
                                    i2++;
                                    length = i3;
                                    split = strArr;
                                    str4 = str2;
                                    str3 = str;
                                }
                            } catch (Exception e3) {
                                e = e3;
                                str = str3;
                                iMDLogger.f("LoadResources", "Images Error in loading " + h1 + " . error " + e.getLocalizedMessage());
                                i2++;
                                length = i3;
                                split = strArr;
                                str4 = str2;
                                str3 = str;
                            }
                        }
                        i2++;
                        length = i3;
                        split = strArr;
                        str4 = str2;
                        str3 = str;
                    }
                    it2 = it3;
                }
            }
            String str6 = str3;
            String str7 = str4;
            Bundle bundle3 = this.D4;
            ArrayList<Bundle> V2 = compressHelper.V(bundle3, "Select rowid as _id, * from videos where sectionId=" + this.E4);
            this.b5 = new ArrayList<>();
            if (V2 == null) {
                iMDLogger.j("LoadResources", "No Videos to load");
            } else {
                Iterator<Bundle> it4 = V2.iterator();
                while (it4.hasNext()) {
                    Bundle next2 = it4.next();
                    Bundle bundle4 = this.D4;
                    String h13 = CompressHelper.h1(bundle4, next2.getString("id") + ".mp4", "videos-E");
                    if (new File(h13).exists()) {
                        new File(h13);
                        try {
                            Bundle bundle5 = this.D4;
                            String h14 = CompressHelper.h1(bundle5, next2.getString("id") + ".mp4", "base");
                            Bundle bundle6 = new Bundle();
                            bundle6.putString("VideoPath", h13);
                            bundle6.putString("ImagePath", h14);
                            bundle6.putString("id", next2.getString("id"));
                            bundle6.putString("isVideo", IcyHeaders.a3);
                            bundle6.putString("Description", next2.getString("title"));
                            this.b5.add(bundle6);
                        } catch (Exception e4) {
                            iMDLogger.f("LoadResources", "OtherImages Error in loading " + h13 + " . error " + e4.getLocalizedMessage());
                        }
                    }
                }
            }
            this.c5 = new ArrayList<>();
            if (this.Y4.length() != 0) {
                String[] split2 = TextUtils.split(this.Y4, str6);
                int length2 = split2.length;
                int i4 = 0;
                while (i4 < length2) {
                    String str8 = split2[i4];
                    String str9 = str7;
                    String h15 = CompressHelper.h1(this.D4, str8, str9);
                    if (!new File(h15).exists()) {
                        h15 = CompressHelper.h1(this.D4, str8.replace(".png", ".gif"), str9);
                        if (!new File(h15).exists()) {
                            i4++;
                            str7 = str9;
                        }
                    }
                    File file2 = new File(h15);
                    try {
                        byte[] w = compressHelper.w(CompressHelper.d2(file2), file2.getName(), "127");
                        String h16 = CompressHelper.h1(this.D4, str8, "base");
                        if (!new File(h16).exists()) {
                            CompressHelper.D2(new File(h16), w);
                            new File(h16).deleteOnExit();
                            Bundle bundle7 = new Bundle();
                            bundle7.putString("ImagePath", h16);
                            this.c5.add(bundle7);
                        }
                    } catch (Exception e5) {
                        FirebaseCrashlytics.d().g(e5);
                        iMDLogger.f("LoadResourcesOther", "Error in loading " + h15 + " . error " + e5.getLocalizedMessage());
                    }
                    i4++;
                    str7 = str9;
                }
            }
        }

        private void N4(String str) {
            if (this.a5.size() + this.b5.size() == 0) {
                CompressHelper.x2(r(), "There is no media in this document", 1);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.a5);
            arrayList.addAll(this.b5);
            Boolean bool = Boolean.FALSE;
            int i2 = 0;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (((Bundle) arrayList.get(i3)).getString("id").startsWith(str)) {
                    bool = Boolean.TRUE;
                    i2 = i3;
                }
            }
            if (!bool.booleanValue()) {
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    if (((Bundle) arrayList.get(i4)).getString("id").replace("m_", "").startsWith(str.replace("m_", ""))) {
                        i2 = i4;
                    }
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

        public void M4() {
            this.G4.g("$(\".contentJump\").each(function(){justShowSection($(this).find(\"a[name]\").first().attr(\"name\"))});");
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
                this.b5 = bundle.getParcelableArrayList("mVideos");
                this.c5 = bundle.getParcelableArrayList("mOtherImages");
                this.d5 = bundle.getParcelableArrayList("mSections");
            }
            if (y() == null) {
                return inflate;
            }
            this.p4 = null;
            iMDLogger.j("AMViewer", "Loading AM Document with mDocAddress = " + this.E4);
            T2(new Runnable() {
                public void run() {
                    Bundle bundle;
                    String str;
                    try {
                        CompressHelper compressHelper = new CompressHelper(AMViewerFragment.this.r());
                        String str2 = AMViewerFragment.this.A4;
                        if (str2 != null) {
                            if (str2.length() != 0) {
                                return;
                            }
                        }
                        Bundle e0 = compressHelper.e0(AMViewerFragment.this.D4, "Select * from Docs where id=" + AMViewerFragment.this.E4);
                        if (e0 == null) {
                            e0 = compressHelper.e0(AMViewerFragment.this.D4, "Select * from Docs where aid=" + AMViewerFragment.this.E4);
                            if (e0 == null) {
                                Bundle e02 = compressHelper.e0(AMViewerFragment.this.D4, "Select * from Sections Where id = " + AMViewerFragment.this.E4);
                                if (e02 == null) {
                                    Bundle e03 = compressHelper.e0(AMViewerFragment.this.D4, "Select * from AllSections Where section like '" + AMViewerFragment.this.E4 + "%'");
                                    if (e03 == null) {
                                        AMViewerFragment.this.p4 = "Document doesn't exist";
                                        return;
                                    }
                                    AMViewerFragment.this.E4 = e03.getString("sectionId");
                                    bundle = AMViewerFragment.this.D4;
                                    str = "Select * from Docs where id=" + AMViewerFragment.this.E4;
                                } else {
                                    AMViewerFragment.this.E4 = e02.getString("sectionId");
                                    bundle = AMViewerFragment.this.D4;
                                    str = "Select * from Docs where id=" + AMViewerFragment.this.E4;
                                }
                                e0 = compressHelper.e0(bundle, str);
                            } else {
                                AMViewerFragment.this.E4 = e0.getString("id");
                            }
                        }
                        String string = e0.getString("mainContent");
                        String unused = AMViewerFragment.this.Y4 = e0.getString("resources");
                        AMViewerFragment.this.F4 = e0.getString("name");
                        String replace = new String(compressHelper.v(string, e0.getString("id"), "127")).replace(">Print Section<", "><").replace(">Favorite Table<", "><").replace(">Download (.pdf)<", "><").replace(">|<", "><").replace(">Favorite Figure<", "><").replace(">Download Slide (.ppt)<", "><");
                        AMViewerFragment aMViewerFragment = AMViewerFragment.this;
                        String d4 = aMViewerFragment.d4(aMViewerFragment.r(), "AMHeader.css");
                        AMViewerFragment aMViewerFragment2 = AMViewerFragment.this;
                        String d42 = aMViewerFragment2.d4(aMViewerFragment2.r(), "AMFooter.css");
                        String str3 = d4.replace("[size]", "200").replace("[title]", AMViewerFragment.this.F4) + replace.replace("<img data-original=\"s_audio_intext.jpeg\" src=\"spinnerLarge.gif\" alt=\"Image not available.\" class=\"contentFigures\" />", "<img src=\"s_audio_intext.jpeg\">").replace(">Download Section PDF</", "></") + d42;
                        AMViewerFragment.this.l3("mgh.Popup.Dialog.js");
                        AMViewerFragment.this.m3();
                        AMViewerFragment aMViewerFragment3 = AMViewerFragment.this;
                        aMViewerFragment3.A4 = str3;
                        aMViewerFragment3.I4();
                    } catch (Exception e2) {
                        FirebaseCrashlytics.d().g(e2);
                        e2.printStackTrace();
                        AMViewerFragment.this.p4 = e2.getLocalizedMessage();
                    }
                }
            }, new Runnable() {
                public void run() {
                    String str = AMViewerFragment.this.p4;
                    if (str == null || str.length() <= 0) {
                        if (AMViewerFragment.this.Z4 != null) {
                            AMViewerFragment.this.Z4.setVisible(AMViewerFragment.this.a5.size() + AMViewerFragment.this.b5.size() != 0);
                        }
                        if (!AMViewerFragment.this.Q4.x1()) {
                            AMViewerFragment.this.m4("Chapter");
                        }
                        String g1 = CompressHelper.g1(AMViewerFragment.this.D4, "base");
                        AMViewerFragment aMViewerFragment = AMViewerFragment.this;
                        aMViewerFragment.A4 = aMViewerFragment.A4.replace("href=\"#", "href=\"svbfile://somewhere#");
                        AMViewerFragment.this.h3(g1);
                        AMViewerFragment aMViewerFragment2 = AMViewerFragment.this;
                        aMViewerFragment2.O3(aMViewerFragment2.A4, g1);
                        AMViewerFragment.this.s4();
                        AMViewerFragment.this.p4();
                        AMViewerFragment.this.f3(R.menu.f1417menu_amviewer);
                        AMViewerFragment.this.o2(false);
                        AMViewerFragment.this.G3();
                        return;
                    }
                    AMViewerFragment aMViewerFragment3 = AMViewerFragment.this;
                    aMViewerFragment3.C4(aMViewerFragment3.p4);
                }
            });
            return inflate;
        }

        public boolean W3(ConsoleMessage consoleMessage) {
            String str;
            iMDLogger.f("Javascript Console", consoleMessage.message());
            String[] split = consoleMessage.message().split(",,,,,");
            if (split[0].equals("tableAction")) {
                String replace = split[1].replace(" rs_skip_always", "");
                try {
                    CompressHelper.f(replace, "class=\"tableLabel\">", "</span>");
                    str = Html.fromHtml(CompressHelper.f(replace, "class=\"tableCaption\">", "</span>")).toString();
                } catch (Exception unused) {
                    str = "Caption";
                }
                if (str == null) {
                    str = "Table";
                }
                E4(replace, str);
            }
            return super.W3(consoleMessage);
        }

        public void Z3(WebView webView, String str) {
            this.G4.g("adjustTableLinks()");
            this.G4.g("$(\"img[data-original]\").each(function(){if (this.style.display==\"none\"){$(this).attr(\"src\",$(this).attr(\"data-original\"));$(this).show();}});");
            super.Z3(webView, str);
        }

        public boolean e1(MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            if (itemId == R.id.f799action_gallery) {
                N4("soheilvb");
            }
            if (itemId == R.id.f801action_menu) {
                AMSectionsViewer aMSectionsViewer = new AMSectionsViewer();
                Bundle bundle = new Bundle();
                bundle.putBundle("db", this.D4);
                bundle.putString("docId", this.E4);
                bundle.putString("parentId", "0");
                aMSectionsViewer.i2(bundle);
                aMSectionsViewer.Z2(true);
                aMSectionsViewer.A2(this, 0);
                aMSectionsViewer.e3(M(), "AMSectionsViewer");
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
            M4();
            super.t3(str);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:47:0x01a0, code lost:
            if (r9.getString("sectionId").equals(r7.E4) != false) goto L_0x01db;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x01d9, code lost:
            if (r9.getString("sectionId").equals(r7.E4) != false) goto L_0x01db;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x01df, code lost:
            r7.Q4.A1(r7.D4, r9.getString("sectionId"), (java.lang.String[]) null, r8);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean y4(android.webkit.WebView r8, java.lang.String r9, java.lang.String r10, java.lang.String r11) {
            /*
                r7 = this;
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                java.lang.String r0 = "Url : "
                r8.append(r0)
                r8.append(r9)
                java.lang.String r0 = ", Scheme : "
                r8.append(r0)
                r8.append(r10)
                java.lang.String r0 = ", Resource : "
                r8.append(r0)
                r8.append(r11)
                java.lang.String r8 = r8.toString()
                java.lang.String r0 = "Override"
                net.imedicaldoctor.imd.iMDLogger.j(r0, r8)
                java.lang.String r8 = "svb"
                boolean r8 = r10.equals(r8)
                r0 = 1
                if (r8 == 0) goto L_0x0054
                java.lang.String r8 = "ShowGallery"
                android.util.Log.e(r8, r11)
                java.lang.String r9 = "//figureDialog"
                java.lang.String r10 = "m_"
                java.lang.String r9 = r11.replace(r9, r10)
                android.util.Log.e(r8, r9)
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                r8.append(r9)
                java.lang.String r9 = "."
                r8.append(r9)
                java.lang.String r8 = r8.toString()
                r7.N4(r8)
                return r0
            L_0x0054:
                java.lang.String r8 = "tabledialog"
                boolean r8 = r10.equals(r8)
                if (r8 == 0) goto L_0x0080
                java.lang.String r8 = "//"
                java.lang.String r9 = ""
                java.lang.String r8 = r11.replace(r8, r9)
                net.imedicaldoctor.imd.Utils.iMDWebView r9 = r7.G4
                java.lang.StringBuilder r10 = new java.lang.StringBuilder
                r10.<init>()
                java.lang.String r11 = "console.log('tableAction,,,,,' +  document.getElementById(\""
                r10.append(r11)
                r10.append(r8)
                java.lang.String r8 = "\").innerHTML)"
                r10.append(r8)
                java.lang.String r8 = r10.toString()
                r9.g(r8)
                return r0
            L_0x0080:
                java.lang.String r8 = "MultimediaPlayer.aspx"
                boolean r8 = r11.contains(r8)
                java.lang.String r1 = "&"
                if (r8 == 0) goto L_0x00aa
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                r8.append(r11)
                r8.append(r1)
                java.lang.String r8 = r8.toString()
                java.lang.String r9 = "MultimediaID="
                java.lang.String r8 = net.imedicaldoctor.imd.Data.CompressHelper.f(r8, r9, r1)
                r7.N4(r8)
                net.imedicaldoctor.imd.Utils.iMDWebView r8 = r7.G4
                java.lang.String r9 = "$(document).trigger('click')"
                r8.g(r9)
                return r0
            L_0x00aa:
                java.lang.String r8 = "//somewhere"
                boolean r8 = r11.equals(r8)
                java.lang.String r2 = "#"
                if (r8 == 0) goto L_0x00be
                java.lang.String[] r8 = r9.split(r2)
                r8 = r8[r0]
                r7.C3(r8)
                return r0
            L_0x00be:
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                r8.append(r11)
                r8.append(r1)
                java.lang.String r8 = r8.toString()
                java.lang.String r11 = "file"
                boolean r11 = r10.equals(r11)
                if (r11 != 0) goto L_0x00ec
                java.lang.String r11 = "svbfile"
                boolean r11 = r10.equals(r11)
                if (r11 != 0) goto L_0x00ec
                java.lang.String r11 = "http"
                boolean r11 = r10.equals(r11)
                java.lang.String r3 = "localhost:"
                boolean r3 = r8.contains(r3)
                r11 = r11 & r3
                if (r11 == 0) goto L_0x01ea
            L_0x00ec:
                java.lang.String r11 = "content.aspx"
                boolean r11 = r8.contains(r11)
                r3 = 0
                if (r11 == 0) goto L_0x0166
                java.lang.String r9 = "bookid="
                boolean r10 = r8.contains(r9)
                if (r10 == 0) goto L_0x0124
                java.lang.String r9 = net.imedicaldoctor.imd.Data.CompressHelper.f(r8, r9, r1)
                android.os.Bundle r10 = r7.D4
                java.lang.StringBuilder r11 = new java.lang.StringBuilder
                r11.<init>()
                r11.append(r9)
                java.lang.String r9 = ".db"
                r11.append(r9)
                java.lang.String r9 = r11.toString()
                java.lang.String r9 = net.imedicaldoctor.imd.Data.CompressHelper.g1(r10, r9)
                java.io.File r10 = new java.io.File
                r10.<init>(r9)
                boolean r9 = r10.exists()
                if (r9 != 0) goto L_0x0124
                return r0
            L_0x0124:
                java.lang.String r9 = "sectionid="
                boolean r10 = r8.contains(r9)
                if (r10 == 0) goto L_0x0131
                java.lang.String r8 = net.imedicaldoctor.imd.Data.CompressHelper.f(r8, r9, r1)
                goto L_0x015c
            L_0x0131:
                java.lang.String r9 = "aid="
                boolean r10 = r8.contains(r9)
                if (r10 == 0) goto L_0x0165
                java.lang.String r8 = net.imedicaldoctor.imd.Data.CompressHelper.f(r8, r9, r1)
                net.imedicaldoctor.imd.Data.CompressHelper r9 = r7.Q4
                android.os.Bundle r10 = r7.D4
                java.lang.StringBuilder r11 = new java.lang.StringBuilder
                r11.<init>()
                java.lang.String r1 = "Select * from docs where aid="
                r11.append(r1)
                r11.append(r8)
                java.lang.String r11 = r11.toString()
                android.os.Bundle r9 = r9.e0(r10, r11)
                if (r9 != 0) goto L_0x015c
                r7.C3(r8)
                return r0
            L_0x015c:
                net.imedicaldoctor.imd.Data.CompressHelper r9 = r7.Q4
                android.os.Bundle r10 = r7.D4
                r9.A1(r10, r8, r3, r8)
                goto L_0x01ea
            L_0x0165:
                return r0
            L_0x0166:
                boolean r11 = r8.contains(r2)
                java.lang.String r4 = "'"
                java.lang.String r5 = "Select * from Allsections where section = '"
                java.lang.String r6 = "sectionId"
                if (r11 == 0) goto L_0x01a3
                java.lang.String r8 = net.imedicaldoctor.imd.Data.CompressHelper.f(r8, r2, r1)
                net.imedicaldoctor.imd.Data.CompressHelper r9 = r7.Q4
                android.os.Bundle r10 = r7.D4
                java.lang.StringBuilder r11 = new java.lang.StringBuilder
                r11.<init>()
                r11.append(r5)
                r11.append(r8)
                r11.append(r4)
                java.lang.String r11 = r11.toString()
                android.os.Bundle r9 = r9.e0(r10, r11)
                if (r9 != 0) goto L_0x0196
                r7.C3(r8)
                return r0
            L_0x0196:
                java.lang.String r10 = r9.getString(r6)
                java.lang.String r11 = r7.E4
                boolean r10 = r10.equals(r11)
                if (r10 == 0) goto L_0x01df
                goto L_0x01db
            L_0x01a3:
                java.lang.String r8 = "contentref"
                boolean r8 = r10.equals(r8)
                if (r8 == 0) goto L_0x01ea
                java.lang.String r8 = net.imedicaldoctor.imd.Data.CompressHelper.f(r9, r2, r1)
                net.imedicaldoctor.imd.Data.CompressHelper r9 = r7.Q4
                android.os.Bundle r10 = r7.D4
                java.lang.StringBuilder r11 = new java.lang.StringBuilder
                r11.<init>()
                r11.append(r5)
                r11.append(r8)
                r11.append(r4)
                java.lang.String r11 = r11.toString()
                android.os.Bundle r9 = r9.e0(r10, r11)
                if (r9 != 0) goto L_0x01cf
                r7.C3(r8)
                return r0
            L_0x01cf:
                java.lang.String r10 = r9.getString(r6)
                java.lang.String r11 = r7.E4
                boolean r10 = r10.equals(r11)
                if (r10 == 0) goto L_0x01df
            L_0x01db:
                r7.C3(r8)
                goto L_0x01ea
            L_0x01df:
                net.imedicaldoctor.imd.Data.CompressHelper r10 = r7.Q4
                android.os.Bundle r11 = r7.D4
                java.lang.String r9 = r9.getString(r6)
                r10.A1(r11, r9, r3, r8)
            L_0x01ea:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.AccessMedicine.AMViewerActivity.AMViewerFragment.y4(android.webkit.WebView, java.lang.String, java.lang.String, java.lang.String):boolean");
        }

        public void z3() {
            if (V1().getSharedPreferences("default_preferences", 0).getBoolean("lastred", false)) {
                CompressHelper compressHelper = this.Q4;
                Bundle s1 = compressHelper.s1(compressHelper.Y(I3(), "select save from highlight where dbName='" + this.D4.getString("Name").replace("'", "''") + "' AND dbAddress='" + this.Q4.a1(this.E4) + "' AND save like '%$highlightRed$%'"));
                if (s1 != null) {
                    M4();
                    this.G4.g("gotoHighlight('" + s1.getString("save") + "');");
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.f1175activity_general_viewer);
        Y0(new AMViewerFragment(), bundle);
    }
}
