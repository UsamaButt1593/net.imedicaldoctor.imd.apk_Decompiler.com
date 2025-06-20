package net.imedicaldoctor.imd.Fragments.Skyscape;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.WebView;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.itextpdf.tool.xml.html.HTML;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Data.UnzipCompleted;
import net.imedicaldoctor.imd.Decompress;
import net.imedicaldoctor.imd.Fragments.ViewerHelperActivity;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.Gallery.GalleryActivity;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Utils.iMDWebView;
import net.imedicaldoctor.imd.iMDLogger;
import okio.BufferedSink;
import okio.Okio;
import org.apache.commons.lang3.StringUtils;

public class SSViewerActivity extends ViewerHelperActivity {

    public static class SSViewerFragment extends ViewerHelperFragment {
        /* access modifiers changed from: private */
        public int X4;
        public ArrayList<Bundle> Y4;
        public ArrayList<Bundle> Z4;

        private void L4(String str) {
            ArrayList<Bundle> arrayList = this.Z4;
            if (arrayList == null || arrayList.size() == 0) {
                CompressHelper.x2(r(), "There is no media in this document", 1);
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(this.Z4);
            int i2 = 0;
            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                if (((Bundle) arrayList2.get(i3)).getString("id").contains(str)) {
                    i2 = i3;
                }
            }
            Intent intent = new Intent(r(), GalleryActivity.class);
            intent.putExtra("Images", arrayList2);
            intent.putExtra("Start", i2);
            D2(intent);
        }

        public void C3(String str) {
            iMDWebView imdwebview = this.G4;
            imdwebview.g("document.getElementsByName(\"section__" + str + "\")[0].scrollIntoView(true);");
        }

        public void I4() {
            try {
                K4("ssimages");
                K4("ssscripts");
                K4("ssstyles");
            } catch (Exception e2) {
                FirebaseCrashlytics.d().g(e2);
                iMDLogger.f("SSViewer", "Error in getting ss resources : " + e2.getLocalizedMessage());
            }
        }

        public void K4(String str) {
            InputStream open;
            FileOutputStream fileOutputStream;
            BufferedSink d2;
            String g1 = CompressHelper.g1(this.D4, "base");
            if (!new File(g1).exists()) {
                new File(g1).mkdirs();
            }
            String h1 = CompressHelper.h1(this.D4, str, "base");
            if (!new File(h1).exists()) {
                new File(h1).mkdirs();
            }
            String[] strArr = new String[0];
            try {
                strArr = r().getAssets().list(str);
            } catch (Exception e2) {
                FirebaseCrashlytics.d().g(e2);
                iMDLogger.f("SSViewer copyfolder", "Can't list files");
            }
            for (String str2 : strArr) {
                File file = new File(h1 + '/' + str2);
                if (!file.exists()) {
                    try {
                        open = r().getAssets().open(str + "/" + str2);
                        fileOutputStream = new FileOutputStream(file);
                        d2 = Okio.d(Okio.p(fileOutputStream));
                        d2.y1(Okio.u(open));
                        d2.flush();
                        d2.close();
                        fileOutputStream.close();
                        if (open != null) {
                            open.close();
                        }
                    } catch (Exception unused) {
                        iMDLogger.f("CopyJavascript", "Error in Copying " + str2 + " to " + g1 + "/" + str2);
                    } catch (Throwable th) {
                        th.addSuppressed(th);
                    }
                }
            }
            return;
            throw th;
            throw th;
            throw th;
        }

        public void M4() {
            SSSectionsViewer sSSectionsViewer = new SSSectionsViewer();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("items", this.Y4);
            bundle.putString("titleProperty", HTML.Tag.V);
            bundle.putString("sectionProperty", "sectionId");
            sSSectionsViewer.i2(bundle);
            sSSectionsViewer.Z2(true);
            sSSectionsViewer.A2(this, 0);
            sSSectionsViewer.e3(M(), "SSSectionViewer");
        }

        public String R2() {
            Bundle v3;
            ArrayList<Bundle> arrayList = this.Z4;
            if (arrayList == null || arrayList.size() <= 0 || (v3 = v3(this.Z4)) == null) {
                return null;
            }
            return v3.getString("ImagePath");
        }

        public void T0(Menu menu, MenuInflater menuInflater) {
            menuInflater.inflate(R.menu.f1417menu_amviewer, menu);
            q4(menu);
        }

        public View onFragmentBind(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View view = this.C4;
            if (view != null) {
                return view;
            }
            View inflate = layoutInflater.inflate(R.layout.f1255fragment_new_viewer, viewGroup, false);
            r4(inflate, bundle);
            if (y().containsKey("Mode")) {
                this.X4 = y().getInt("Mode");
            } else {
                this.X4 = 0;
            }
            if (bundle != null) {
                this.Y4 = bundle.getParcelableArrayList("mSections");
                this.X4 = bundle.getInt("Mode");
                this.Z4 = bundle.getParcelableArrayList("mImages");
            }
            if (y() == null) {
                return inflate;
            }
            iMDLogger.j("AMViewer", "Loading AM Document with mDocAddress = " + this.E4);
            T2(new Runnable() {
                public void run() {
                    try {
                        CompressHelper compressHelper = new CompressHelper(SSViewerFragment.this.r());
                        String str = SSViewerFragment.this.A4;
                        if (str != null) {
                            if (str.length() != 0) {
                                return;
                            }
                        }
                        if (SSViewerFragment.this.X4 == 0) {
                            ArrayList<Bundle> V = compressHelper.V(SSViewerFragment.this.D4, "select * from document where id = " + SSViewerFragment.this.E4);
                            if (V.size() == 0) {
                                SSViewerFragment.this.p4 = "Document doesn't exist";
                                return;
                            }
                            Bundle bundle = V.get(0);
                            String B = compressHelper.B(bundle.getString("doc"), bundle.getString("id"), "127");
                            SSViewerFragment.this.F4 = bundle.getString("title");
                            String replace = B.replace("<img data-original=\"s_audio_intext.jpeg\" src=\"spinnerLarge.gif\" alt=\"Image not available.\" class=\"contentFigures\" />", "<img src=\"s_audio_intext.jpeg\">").replace("<body>", "<body >");
                            String f2 = CompressHelper.f(replace, "<body", ">");
                            if (f2 == null) {
                                f2 = "";
                            }
                            String replace2 = replace.replace("<body" + f2 + ">", "<body onload=\\\"onBodyLoad();\\\" style=\\\"-webkit-text-size-adjust:200%;\" " + f2 + "> <script src=\"log4javascript.js\" ></script><script src=\"core.js\" ></script><script src=\"dom.js\" ></script><script src=\"domrange.js\" ></script><script src=\"wrappedrange.js\" ></script><script src=\"wrappedselection.js\" ></script><script src=\"rangy-cssclassapplier.js\" ></script><script src=\"rangy-highlighter.js\" ></script><script src=\"hightlight.js\" ></script><script src=\"find.js\" ></script>").replace("../../../", "ss");
                            SSViewerFragment sSViewerFragment = SSViewerFragment.this;
                            sSViewerFragment.Y4 = compressHelper.V(sSViewerFragment.D4, "Select * from documentSections where docId=" + SSViewerFragment.this.E4);
                            SSViewerFragment.this.m3();
                            SSViewerFragment.this.A4 = replace2;
                        }
                        if (!compressHelper.x1()) {
                            SSViewerFragment.this.m4("Chapter");
                        }
                        SSViewerFragment.this.I4();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        SSViewerFragment.this.p4 = e2.getLocalizedMessage();
                    }
                }
            }, new Runnable() {
                public void run() {
                    String str = SSViewerFragment.this.p4;
                    if (str == null || str.length() <= 0) {
                        String g1 = CompressHelper.g1(SSViewerFragment.this.D4, "base");
                        SSViewerFragment sSViewerFragment = SSViewerFragment.this;
                        sSViewerFragment.O3(sSViewerFragment.A4, g1);
                        if (SSViewerFragment.this.F4.contains("- Calculator")) {
                            SSViewerFragment.this.t4();
                        } else {
                            SSViewerFragment.this.s4();
                        }
                        SSViewerFragment.this.p4();
                        SSViewerFragment.this.f3(R.menu.f1417menu_amviewer);
                        SSViewerFragment.this.o2(false);
                        SSViewerFragment.this.G3();
                        return;
                    }
                    SSViewerFragment sSViewerFragment2 = SSViewerFragment.this;
                    sSViewerFragment2.C4(sSViewerFragment2.p4);
                }
            });
            return inflate;
        }

        public boolean W3(ConsoleMessage consoleMessage) {
            super.W3(consoleMessage);
            iMDLogger.f("SSViewer - console", consoleMessage.message());
            new CompressHelper(r());
            String[] split = consoleMessage.message().split(",,,,,");
            if (split.length == 2 && split[0].equals("SSImage")) {
                String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(split[1], "|");
                if (splitByWholeSeparator.length > 0) {
                    ArrayList<Bundle> arrayList = new ArrayList<>();
                    for (String str : splitByWholeSeparator) {
                        if (!str.contains("ssimages")) {
                            String[] splitByWholeSeparator2 = StringUtils.splitByWholeSeparator(str, "/");
                            String h1 = CompressHelper.h1(this.D4, splitByWholeSeparator2[1] + "_" + splitByWholeSeparator2[2], "Images");
                            if (new File(h1).length() > ExoPlayer.a1) {
                                Bundle bundle = new Bundle();
                                bundle.putString("ImagePath", h1);
                                bundle.putString("Description", (String) null);
                                bundle.putString("id", h1);
                                arrayList.add(bundle);
                            }
                        }
                    }
                    this.Z4 = arrayList;
                    arrayList.size();
                    o4();
                }
                for (String str2 : splitByWholeSeparator) {
                    if (!str2.contains("ssimages")) {
                        String[] splitByWholeSeparator3 = StringUtils.splitByWholeSeparator(str2, "/");
                        this.G4.g("updateImageSource(\"" + str2 + "\", \"" + (splitByWholeSeparator3[0] + "/Images/" + splitByWholeSeparator3[1] + "_" + splitByWholeSeparator3[2]) + "\")");
                    }
                }
            }
            return true;
        }

        public void Z3(WebView webView, String str) {
            super.Z3(webView, str);
            this.G4.g("updatePlayImage();");
            this.G4.g("console.log('SSImage,,,,,' +getImageList());");
        }

        public boolean e1(MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            if (itemId == R.id.f799action_gallery) {
                L4("soheilvb");
            }
            if (itemId == R.id.f801action_menu) {
                M4();
            }
            return super.e1(menuItem);
        }

        public void m1(Bundle bundle) {
            super.m1(bundle);
        }

        public boolean y4(WebView webView, String str, String str2, String str3) {
            try {
                iMDLogger.j("Override", "Url : " + str + ", Scheme : " + str2 + ", Resource : " + str3);
                CompressHelper compressHelper = new CompressHelper(r());
                if (str2.equals("skyscape")) {
                    if (str3.contains("artinart:KAUD:url=")) {
                        String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(str3, "/");
                        final String str4 = splitByWholeSeparator[splitByWholeSeparator.length - 1];
                        String h1 = CompressHelper.h1(this.D4, str4, "base");
                        if (new File(h1).exists()) {
                            b4(h1);
                            return true;
                        }
                        String g1 = CompressHelper.g1(this.D4, "Sounds.zip");
                        Decompress.f(g1, "Sounds/" + str4, new UnzipCompleted() {
                            public void a(String str) {
                            }

                            public void b(byte[] bArr) {
                                BufferedSink d2;
                                String h1 = CompressHelper.h1(SSViewerFragment.this.D4, str4, "base");
                                File file = new File(h1);
                                if (!file.exists()) {
                                    try {
                                        d2 = Okio.d(Okio.n(file));
                                        d2.write(bArr);
                                        d2.flush();
                                        SSViewerFragment.this.b4(h1);
                                        file.deleteOnExit();
                                        d2.close();
                                        return;
                                    } catch (IOException e2) {
                                        FirebaseCrashlytics.d().g(e2);
                                        iMDLogger.f("GetResource Error", "Unable to write byte array to " + file.getAbsolutePath() + " :" + e2.getLocalizedMessage());
                                        return;
                                    } catch (Throwable th) {
                                        th.addSuppressed(th);
                                    }
                                } else {
                                    return;
                                }
                                throw th;
                            }
                        });
                        return true;
                    } else if (str3.contains("artinart:KVID:url=")) {
                        String h12 = CompressHelper.h1(this.D4, compressHelper.t1(StringUtils.splitByWholeSeparator(str3, "=")), "Videos");
                        Bundle bundle = new Bundle();
                        bundle.putString("isVideo", IcyHeaders.a3);
                        bundle.putString("ImagePath", h12);
                        bundle.putString("Description", (String) null);
                        bundle.putString("id", h12);
                        this.Z4.add(bundle);
                        L4(h12);
                        return true;
                    } else if (str3.equals("#section_list")) {
                        M4();
                    } else if (str3.startsWith("#")) {
                        iMDWebView imdwebview = this.G4;
                        imdwebview.g("document.getElementsByName(\"" + str3.substring(1) + "\")[0].scrollIntoView(true);");
                        this.G4.g("document.body.scrollTop = window.pageYOffset - 50;");
                    } else {
                        String[] splitByWholeSeparator2 = StringUtils.splitByWholeSeparator(str3, "/");
                        String[] splitByWholeSeparator3 = StringUtils.splitByWholeSeparator(splitByWholeSeparator2[splitByWholeSeparator2.length - 2] + "/" + splitByWholeSeparator2[splitByWholeSeparator2.length - 1], "#");
                        new Bundle();
                        Bundle bundle2 = this.D4;
                        Bundle s1 = compressHelper.s1(compressHelper.V(bundle2, "select * from document where name = '" + splitByWholeSeparator3[0] + "'"));
                        if (s1 == null) {
                            CompressHelper.x2(r(), "Document is not available", 1);
                            return true;
                        }
                        compressHelper.A1(this.D4, s1.getString("id"), (String[]) null, splitByWholeSeparator3.length > 1 ? splitByWholeSeparator3[1] : null);
                        return true;
                    }
                } else if (str2.equals("myskycape")) {
                    String[] split = StringUtils.split(str3, "=");
                    if (!split[0].equals("?url") || split[1].contains("../")) {
                        return true;
                    }
                    String[] splitByWholeSeparator4 = StringUtils.splitByWholeSeparator(StringUtils.splitByWholeSeparator(split[1], "&")[0], "/");
                    String[] splitByWholeSeparator5 = StringUtils.splitByWholeSeparator(splitByWholeSeparator4[splitByWholeSeparator4.length - 2] + "/" + splitByWholeSeparator4[splitByWholeSeparator4.length - 1], "#");
                    new Bundle();
                    Bundle bundle3 = this.D4;
                    Bundle s12 = compressHelper.s1(compressHelper.V(bundle3, "select * from document where name = '" + splitByWholeSeparator5[0] + "'"));
                    if (s12 == null) {
                        CompressHelper.x2(r(), "Document is not available", 1);
                        return true;
                    }
                    compressHelper.A1(this.D4, s12.getString("id"), (String[]) null, splitByWholeSeparator5.length > 1 ? splitByWholeSeparator5[1] : null);
                    return true;
                }
            } catch (Exception e2) {
                FirebaseCrashlytics.d().g(e2);
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.f1175activity_general_viewer);
        Y0(new SSViewerFragment(), bundle);
    }
}
