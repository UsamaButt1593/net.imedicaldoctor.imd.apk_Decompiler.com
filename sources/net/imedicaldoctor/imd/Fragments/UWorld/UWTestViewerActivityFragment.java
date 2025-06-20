package net.imedicaldoctor.imd.Fragments.UWorld;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.core.widget.TextViewCompat;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.itextpdf.text.Annotation;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.Gallery.GalleryActivity;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Utils.iMDWebView;
import net.imedicaldoctor.imd.iMDLogger;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

public class UWTestViewerActivityFragment extends ViewerHelperFragment {
    public Bundle X4;
    public Boolean Y4;
    public String Z4;
    public ArrayList<String> a5;
    public ArrayList<Bundle> b5;
    public ArrayList<Bundle> c5;
    public ArrayList<Bundle> d5;
    public int e5;
    public Bundle f5;
    public Date g5;
    public String h5;
    /* access modifiers changed from: private */
    public TextView i5;
    /* access modifiers changed from: private */
    public Handler j5;
    /* access modifiers changed from: private */
    public long k5 = 0;
    /* access modifiers changed from: private */
    public String l5;
    /* access modifiers changed from: private */
    public Boolean m5;
    /* access modifiers changed from: private */
    public Boolean n5;
    /* access modifiers changed from: private */
    public boolean o5;
    /* access modifiers changed from: private */
    public boolean p5;
    public int q5;
    public int r5;
    private Runnable s5 = new Runnable() {
        public void run() {
            if (UWTestViewerActivityFragment.this.k5 != -1) {
                int uptimeMillis = (int) ((SystemClock.uptimeMillis() - UWTestViewerActivityFragment.this.k5) / 1000);
                int i2 = uptimeMillis / 60;
                int i3 = uptimeMillis % 60;
                UWTestViewerActivityFragment.this.i5.setText(String.format("%02d:%02d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}));
                if (i3 % 5 == 0) {
                    UWTestViewerActivityFragment.this.o5();
                }
                UWTestViewerActivityFragment.this.j5.postDelayed(this, 1000);
            }
        }
    };

    /* access modifiers changed from: private */
    public void M4() {
        CompressHelper compressHelper = this.Q4;
        Bundle bundle = this.D4;
        ArrayList<Bundle> V = compressHelper.V(bundle, "Select * from images where questionId = " + this.d5.get(this.e5).getString("id"));
        if (V == null) {
            V = new ArrayList<>();
        }
        Iterator<Bundle> it2 = V.iterator();
        while (it2.hasNext()) {
            String string = it2.next().getString("filename");
            String h1 = CompressHelper.h1(this.D4, string, "media-E");
            if (new File(h1).exists()) {
                try {
                    byte[] w = this.Q4.w(CompressHelper.d2(new File(h1)), string, "127");
                    String h12 = CompressHelper.h1(this.D4, string, "base");
                    if (new File(h12).exists()) {
                        new File(h12).delete();
                    }
                    CompressHelper.D2(new File(h12), w);
                    new File(h12).deleteOnExit();
                } catch (Exception e2) {
                    FirebaseCrashlytics.d().g(e2);
                    e2.printStackTrace();
                }
            }
        }
        this.b5 = V;
    }

    /* access modifiers changed from: private */
    public void N4(ArrayList<String> arrayList) {
        Iterator<String> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            String next = it2.next();
            String replace = next.replace(".JPG", ".jpg").replace(".PNG", ".png");
            Log.e("UW", "Media2 : " + replace);
            String h1 = CompressHelper.h1(this.D4, replace, "media-E");
            if (new File(h1).exists()) {
                File file = new File(h1);
                try {
                    String replace2 = CompressHelper.h1(this.D4, next, "base").replace(".mov", ".mp4");
                    if (!new File(replace2).exists()) {
                        byte[] d2 = CompressHelper.d2(file);
                        Log.e("UW", "GET DATA " + replace);
                        byte[] w = this.Q4.w(d2, replace, "127");
                        Log.e("UW", "New Image Path : " + replace2);
                        CompressHelper.D2(new File(replace2), w);
                    }
                } catch (Exception e2) {
                    FirebaseCrashlytics.d().g(e2);
                    e2.printStackTrace();
                }
            }
        }
        this.a5 = arrayList;
    }

    private String e5(String str, String str2, String str3) {
        return "<a name=\"f" + str3 + "\"><div id=\"h" + str3 + "\" class=\"headerExpanded\"  DIR=\"LTR\" onclick=\"collapse(f" + str3 + ");toggleHeaderExpanded(h" + str3 + ");\"><span class=\"fieldname\">" + str + "</span></div></a><div class=\"content\" DIR=\"LTR\" id=\"f" + str3 + "\">" + str2 + "</div>";
    }

    private void m5() {
        Bundle bundle = this.f5;
        if (bundle != null) {
            String[] split = bundle.getString("createdDate").split("\\|");
            if (split.length > 1) {
                String[] split2 = split[1].split(":");
                int parseInt = Integer.parseInt(split2[0]);
                this.k5 = SystemClock.uptimeMillis() - ((long) (((parseInt * 60) + Integer.parseInt(split2[1])) * 1000));
                return;
            }
            this.k5 = SystemClock.uptimeMillis();
        }
    }

    /* access modifiers changed from: private */
    public void o5() {
        if (this.f5 != null) {
            int uptimeMillis = (int) ((SystemClock.uptimeMillis() - this.k5) / 1000);
            String format = String.format("%02d:%02d", new Object[]{Integer.valueOf(uptimeMillis / 60), Integer.valueOf(uptimeMillis % 60)});
            this.Q4.m(this.D4, "UPDATE tests SET createdDate = '" + (this.f5.getString("createdDate").split("\\|")[0] + "|" + format) + "' WHERE id = " + this.f5.getString("id"));
        }
    }

    private void p5() {
        AppCompatTextView appCompatTextView = new AppCompatTextView(B());
        this.i5 = appCompatTextView;
        appCompatTextView.setTextSize(16.0f);
        this.i5.setTextColor(b0().getColor(17170443));
        this.i5.setGravity(GravityCompat.f6388c);
        TextViewCompat.r(this.i5, 1);
        ((Toolbar) this.C4.findViewById(R.id.f1139toolbar)).addView(this.i5);
        if (this.f5.getString("done").equals("0")) {
            s5();
            return;
        }
        String[] split = this.f5.getString("createdDate").split("\\|");
        if (split.length > 1) {
            this.i5.setText(split[1]);
        }
    }

    private void q5(String str) {
        ArrayList<String> arrayList = this.a5;
        if ((arrayList == null && this.b5 == null) || arrayList.size() + this.b5.size() == 0) {
            CompressHelper.x2(r(), "There is no images in this document", 1);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<String> it2 = this.a5.iterator();
        while (it2.hasNext()) {
            String next = it2.next();
            Bundle bundle = new Bundle();
            bundle.putString("ImagePath", CompressHelper.h1(this.D4, next, "base"));
            bundle.putString("Description", "");
            bundle.putString("id", next);
            if (next.endsWith(".mov") || next.endsWith(".mp4") || next.endsWith(".mp3")) {
                bundle.putString("isVideo", IcyHeaders.a3);
            }
            arrayList2.add(bundle);
        }
        Iterator<Bundle> it3 = this.b5.iterator();
        while (it3.hasNext()) {
            Bundle next2 = it3.next();
            Bundle bundle2 = new Bundle();
            Iterator<Bundle> it4 = it3;
            bundle2.putString("ImagePath", CompressHelper.h1(this.D4, next2.getString("filename"), "base"));
            bundle2.putString("Description", next2.getString("title"));
            bundle2.putString("id", next2.getString("mediaId"));
            if (next2.getString("filename").endsWith(".mov")) {
                bundle2.putString("isVideo", IcyHeaders.a3);
            }
            if (next2.getString("filename").endsWith(".mp4")) {
                bundle2.putString("isVideo", IcyHeaders.a3);
            }
            if (next2.getString("filename").endsWith(".mp3")) {
                bundle2.putString("isVideo", IcyHeaders.a3);
            }
            arrayList2.add(bundle2);
            it3 = it4;
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

    private void s5() {
        this.j5 = new Handler();
        this.k5 = SystemClock.uptimeMillis();
        this.j5.postDelayed(this.s5, 0);
    }

    public void I4() {
        this.s4.findItem(R.id.f805action_previous).setEnabled(false);
        this.s4.findItem(R.id.f805action_previous).setIcon(R.drawable.L5);
    }

    public void J4() {
        this.s4.findItem(R.id.f803action_next).setEnabled(false);
        this.s4.findItem(R.id.f803action_next).setIcon(R.drawable.I5);
    }

    public Boolean K3(String str) {
        CompressHelper compressHelper = this.Q4;
        String X0 = compressHelper.X0();
        StringBuilder sb = new StringBuilder();
        sb.append("select * from favorites where dbName='");
        sb.append(this.Q4.a1(this.D4.getString("Name")));
        sb.append("' AND (dbAddress='");
        sb.append(this.Q4.a1(str));
        sb.append("' OR dbAddress='question-");
        sb.append(this.Q4.a1(str));
        sb.append("' OR dbAddress='answer-");
        sb.append(this.Q4.a1(str));
        sb.append("')");
        return Boolean.valueOf(compressHelper.s1(compressHelper.Y(X0, sb.toString())) != null);
    }

    public void K4() {
        this.s4.findItem(R.id.f805action_previous).setEnabled(true);
        this.s4.findItem(R.id.f805action_previous).setIcon(R.drawable.J5);
    }

    public void L4() {
        this.s4.findItem(R.id.f803action_next).setEnabled(true);
        this.s4.findItem(R.id.f803action_next).setIcon(R.drawable.G5);
    }

    public void O4() {
        if (this.j5 != null) {
            try {
                if (this.k5 != -1) {
                    o5();
                }
                this.k5 = -1;
                this.j5.removeCallbacks(this.s5);
            } catch (Exception unused) {
            }
        }
    }

    public String R2() {
        return null;
    }

    public View onFragmentBind(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
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
        this.m5 = Boolean.valueOf(!this.Q4.V(this.D4, "select count(distinct  corrTaken) as c  from questions").get(0).getString("c").equals(IcyHeaders.a3));
        this.n5 = Boolean.valueOf(!this.Q4.V(this.D4, "select count(distinct  lastUpdated) as c  from questions").get(0).getString("c").equals(IcyHeaders.a3));
        this.o5 = !this.Q4.V(this.D4, "select count(distinct  subId) as c  from questions").get(0).getString("c").equals(IcyHeaders.a3);
        this.p5 = !this.Q4.V(this.D4, "select count(distinct  sysId) as c  from questions").get(0).getString("c").equals(IcyHeaders.a3);
        try {
            String str = this.A4;
            if (str != null) {
                if (str.length() == 0) {
                }
                m3();
                s4();
                Bundle bundle2 = this.f5;
                if (bundle2 != null && bundle2.getString("mode").equals("Testing (Timed)")) {
                    p5();
                    m5();
                }
                return this.C4;
            }
            p4();
            o2(false);
            if (this.D4.getString("Name").toLowerCase(Locale.ROOT).contains("uworld")) {
                f3(R.menu.f1496uworld_test_uworld);
            } else {
                f3(R.menu.f1495uworld_test);
            }
            G3();
            iMDLogger.f("Loading Document", this.E4);
            this.l5 = "";
            if (!this.E4.contains("-")) {
                this.d5 = this.Q4.V(this.D4, y().getString("Query"));
                this.e5 = y().getInt("QuestionIndex");
            } else {
                String[] split = this.E4.split("-");
                if (split[0].equals("test")) {
                    CompressHelper compressHelper = this.Q4;
                    Bundle bundle3 = this.D4;
                    Bundle s1 = compressHelper.s1(compressHelper.V(bundle3, "Select * from tests where id =" + split[1]));
                    this.f5 = s1;
                    j5(s1.getString("qIds"));
                    ArrayList<Bundle> arrayList = this.d5;
                    if (arrayList != null) {
                        if (arrayList.size() != 0) {
                            this.e5 = Integer.valueOf(this.f5.getString("qIndex")).intValue();
                            if (y().containsKey("gotoQIndex")) {
                                this.e5 = y().getInt("gotoQIndex");
                            }
                        }
                    }
                    CompressHelper.x2(r(), "No Questions Found", 1);
                    this.Q4.W1(false);
                    return this.C4;
                } else if (split[0].equals("question")) {
                    CompressHelper compressHelper2 = this.Q4;
                    Bundle bundle4 = this.D4;
                    this.d5 = compressHelper2.V(bundle4, "Select * from Questions where id=" + split[1]);
                    this.e5 = 0;
                } else {
                    if (split[0].equals("answer")) {
                        CompressHelper compressHelper3 = this.Q4;
                        Bundle bundle5 = this.D4;
                        this.d5 = compressHelper3.V(bundle5, "Select * from Questions where id=" + split[1]);
                        this.e5 = 0;
                        g5("", false);
                    }
                    m3();
                    s4();
                    Bundle bundle22 = this.f5;
                    p5();
                    m5();
                    return this.C4;
                }
            }
            h5();
            m3();
            s4();
            Bundle bundle222 = this.f5;
            p5();
            m5();
            return this.C4;
        } catch (Exception e2) {
            e2.printStackTrace();
            B4(e2);
            return this.C4;
        }
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
                            str = l5(str);
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
            this.a5 = arrayList;
            o4();
        } else if (split[0].equals("answer")) {
            String str4 = split[1];
            k5(str4);
            Bundle bundle = this.f5;
            if (bundle == null || !bundle.getString("mode").equals("Testing (Timed)")) {
                g5(str4, true);
            }
        }
        return super.W3(consoleMessage);
    }

    public void X0() {
        super.X0();
        O4();
    }

    public void Z3(WebView webView, String str) {
        int i2 = this.q5;
        if (i2 > 0 || this.r5 > 0) {
            this.G4.scrollTo(this.r5, i2);
            this.q5 = 0;
            this.r5 = 0;
        }
        this.G4.g("ConvertAllImages();");
        this.G4.g("onBodyLoad();");
        String str2 = this.h5;
        if (str2 != null) {
            C3(str2);
            this.h5 = null;
        }
        super.Z3(webView, str);
        this.G4.postDelayed(new Runnable() {
            public void run() {
                UWTestViewerActivityFragment uWTestViewerActivityFragment = UWTestViewerActivityFragment.this;
                int i2 = uWTestViewerActivityFragment.q5;
                if (i2 > 0 || uWTestViewerActivityFragment.r5 > 0) {
                    uWTestViewerActivityFragment.G4.scrollTo(uWTestViewerActivityFragment.r5, i2);
                    UWTestViewerActivityFragment uWTestViewerActivityFragment2 = UWTestViewerActivityFragment.this;
                    uWTestViewerActivityFragment2.q5 = 0;
                    uWTestViewerActivityFragment2.r5 = 0;
                }
            }
        }, 200);
    }

    public String a5(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ZZZ").format(date);
    }

    public String b5() {
        return "Question " + this.d5.get(this.e5).getString("id") + " (" + this.d5.get(this.e5).getString("title") + ")";
    }

    public String c5(String str) {
        try {
            int parseInt = Integer.parseInt(str);
            if (parseInt > 0) {
                return String.valueOf((char) (parseInt + 64));
            }
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
        }
        return str;
    }

    public String d5(ArrayList<String> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator<String> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(c5(it2.next()));
        }
        return StringUtils.join((Iterable<?>) arrayList2, ",");
    }

    public boolean e1(MenuItem menuItem) {
        int i2;
        int itemId = menuItem.getItemId();
        if (itemId == R.id.f796action_favorites) {
            new Bundle();
            String b52 = b5();
            if (menuItem.getTitle().equals("Add Favorite")) {
                L2(b52, s3());
                menuItem.setTitle("Remove Favorite");
                i2 = R.drawable.F5;
            } else {
                p3(s3());
                menuItem.setTitle("Add Favorite");
                i2 = R.drawable.D5;
            }
            menuItem.setIcon(i2);
            return true;
        } else if (itemId == R.id.f990lab_values) {
            r5();
            return true;
        } else if (itemId == R.id.f799action_gallery) {
            q5("asdfafdsaf");
            return true;
        } else {
            if (itemId == R.id.f805action_previous) {
                this.e5--;
                h5();
                t5();
                if (this.f5 != null) {
                    this.Q4.m(this.D4, "Update tests set qIndex=" + this.e5 + " where id=" + this.f5.getString("id"));
                }
            }
            if (itemId == R.id.f803action_next) {
                this.e5++;
                h5();
                t5();
                if (this.f5 != null) {
                    this.Q4.m(this.D4, "Update tests set qIndex=" + this.e5 + " where id=" + this.f5.getString("id"));
                }
            }
            if (itemId == R.id.f820action_stop) {
                new AlertDialog.Builder(r(), R.style.f2185alertDialogTheme).l("Do you want to END this test ?").y("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        UWTestViewerActivityFragment uWTestViewerActivityFragment = UWTestViewerActivityFragment.this;
                        if (uWTestViewerActivityFragment.f5 != null) {
                            uWTestViewerActivityFragment.O4();
                            UWTestViewerActivityFragment uWTestViewerActivityFragment2 = UWTestViewerActivityFragment.this;
                            CompressHelper compressHelper = uWTestViewerActivityFragment2.Q4;
                            Bundle bundle = uWTestViewerActivityFragment2.D4;
                            ArrayList<Bundle> V = compressHelper.V(bundle, "Select questions.id,pplTaken,corrTaken,title,selectedAnswer,corrAnswer,time  from Questions left outer join (select * from logs where testId=" + UWTestViewerActivityFragment.this.f5.getString("id") + ") as logs2 on questions.id=logs2.qid where questions.id in (" + UWTestViewerActivityFragment.this.f5.getString("qIds") + ")");
                            Iterator<Bundle> it2 = V.iterator();
                            float f2 = 0.0f;
                            while (it2.hasNext()) {
                                Bundle next = it2.next();
                                if (next.getString("selectedAnswer").length() != 0 && next.getString("selectedAnswer").equals(next.getString("corrAnswer"))) {
                                    f2 += 1.0f;
                                }
                            }
                            int size = (int) ((f2 / ((float) V.size())) * 100.0f);
                            UWTestViewerActivityFragment uWTestViewerActivityFragment3 = UWTestViewerActivityFragment.this;
                            CompressHelper compressHelper2 = uWTestViewerActivityFragment3.Q4;
                            Bundle bundle2 = uWTestViewerActivityFragment3.D4;
                            compressHelper2.m(bundle2, "Update tests set score='" + size + "', done=1 where id=" + UWTestViewerActivityFragment.this.f5.getString("id"));
                            UWTestViewerActivityFragment uWTestViewerActivityFragment4 = UWTestViewerActivityFragment.this;
                            CompressHelper compressHelper3 = uWTestViewerActivityFragment4.Q4;
                            Bundle bundle3 = uWTestViewerActivityFragment4.D4;
                            compressHelper3.A1(bundle3, "testresult-" + UWTestViewerActivityFragment.this.f5.getString("id"), (String[]) null, (String) null);
                        }
                    }
                }).p("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i2) {
                    }
                }).I();
            }
            return super.e1(menuItem);
        }
    }

    public void e3(Menu menu) {
    }

    public String e4() {
        if (this.f5 == null) {
            return this.E4;
        }
        return "test-" + this.f5.getString("id");
    }

    public String f4() {
        if (this.f5 == null) {
            return b5();
        }
        return "Test #" + this.f5.getString("id");
    }

    public void f5(String str) {
        this.G4.evaluateJavascript("highlighter.removeAllHighlights();", (ValueCallback) null);
        iMDWebView imdwebview = this.G4;
        imdwebview.evaluateJavascript("highlighter.deserialize('" + ("type:textContent|" + str) + "');", (ValueCallback) null);
        this.G4.evaluateJavascript("gotoHighlight('" + str + "');", (ValueCallback) null);
        this.G4.evaluateJavascript("highlighter.removeAllHighlights();", (ValueCallback) null);
        this.G4.evaluateJavascript("var element = document.getElementById('orientation'); if (element) { element.parentNode.removeChild(element); }", (ValueCallback) null);
        S3();
    }

    public void g5(final String str, final boolean z) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList(Arrays.asList(StringUtils.splitByWholeSeparator(str, ",")));
        } catch (Exception unused) {
            arrayList = null;
        }
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        if (arrayList.size() > 0) {
            n5();
        }
        q3(new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:66:0x03d4  */
            /* JADX WARNING: Removed duplicated region for block: B:67:0x03d7  */
            /* JADX WARNING: Removed duplicated region for block: B:70:0x0420  */
            /* JADX WARNING: Removed duplicated region for block: B:77:0x0484  */
            /* JADX WARNING: Removed duplicated region for block: B:80:0x0492  */
            /* JADX WARNING: Removed duplicated region for block: B:91:0x0512  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r32 = this;
                    r0 = r32
                    java.lang.String r1 = ","
                    net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment r2 = net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment.this
                    java.util.Date r3 = new java.util.Date
                    r3.<init>()
                    r2.g5 = r3
                    net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment r2 = net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment.this
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    java.lang.String r4 = "Question "
                    r3.append(r4)
                    net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment r4 = net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment.this
                    int r4 = r4.e5
                    r5 = 1
                    int r4 = r4 + r5
                    r3.append(r4)
                    java.lang.String r4 = " Of "
                    r3.append(r4)
                    net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment r4 = net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment.this
                    java.util.ArrayList<android.os.Bundle> r4 = r4.d5
                    int r4 = r4.size()
                    r3.append(r4)
                    java.lang.String r3 = r3.toString()
                    r2.F4 = r3
                    net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment r2 = net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment.this
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    java.lang.String r4 = "answer-"
                    r3.append(r4)
                    net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment r4 = net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment.this
                    java.util.ArrayList<android.os.Bundle> r6 = r4.d5
                    int r4 = r4.e5
                    java.lang.Object r4 = r6.get(r4)
                    android.os.Bundle r4 = (android.os.Bundle) r4
                    java.lang.String r6 = "id"
                    java.lang.String r4 = r4.getString(r6)
                    r3.append(r4)
                    java.lang.String r3 = r3.toString()
                    r2.E4 = r3
                    java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x006f }
                    java.lang.String r3 = r3     // Catch:{ Exception -> 0x006f }
                    java.lang.String[] r3 = org.apache.commons.lang3.StringUtils.splitByWholeSeparator(r3, r1)     // Catch:{ Exception -> 0x006f }
                    java.util.List r3 = java.util.Arrays.asList(r3)     // Catch:{ Exception -> 0x006f }
                    r2.<init>(r3)     // Catch:{ Exception -> 0x006f }
                    goto L_0x0070
                L_0x006f:
                    r2 = 0
                L_0x0070:
                    if (r2 != 0) goto L_0x0077
                    java.util.ArrayList r2 = new java.util.ArrayList
                    r2.<init>()
                L_0x0077:
                    net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment r3 = net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment.this
                    java.util.ArrayList<android.os.Bundle> r4 = r3.d5
                    int r3 = r3.e5
                    java.lang.Object r3 = r4.get(r3)
                    android.os.Bundle r3 = (android.os.Bundle) r3
                    java.lang.String r4 = r3.getString(r6)
                    java.lang.String r6 = "question"
                    java.lang.String r6 = r3.getString(r6)
                    net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment.this
                    net.imedicaldoctor.imd.Data.CompressHelper r7 = r7.Q4
                    java.lang.String r8 = "127"
                    java.lang.String r6 = r7.B(r6, r4, r8)
                    java.lang.String r7 = "explanation"
                    java.lang.String r7 = r3.getString(r7)
                    net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment r9 = net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment.this
                    net.imedicaldoctor.imd.Data.CompressHelper r9 = r9.Q4
                    java.lang.String r7 = r9.B(r7, r4, r8)
                    net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment r9 = net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment.this
                    androidx.fragment.app.FragmentActivity r10 = r9.r()
                    java.lang.String r11 = "UWHeader.css"
                    java.lang.String r9 = r9.d4(r10, r11)
                    java.lang.StringBuilder r10 = new java.lang.StringBuilder
                    r10.<init>()
                    r10.append(r9)
                    net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment r9 = net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment.this
                    androidx.fragment.app.FragmentActivity r11 = r9.r()
                    java.lang.String r12 = "UWAnswer.css"
                    java.lang.String r9 = r9.d4(r11, r12)
                    r10.append(r9)
                    java.lang.String r9 = r10.toString()
                    java.lang.String r10 = "[size]"
                    java.lang.String r11 = "200"
                    java.lang.String r9 = net.imedicaldoctor.imd.Fragments.ViewerHelperFragment.j4(r9, r10, r11)
                    java.util.ArrayList r10 = new java.util.ArrayList
                    r10.<init>()
                    java.lang.String r11 = "mediaName"
                    java.lang.String r11 = r3.getString(r11)
                    java.lang.String r12 = "otherMedias"
                    java.lang.String r12 = r3.getString(r12)
                    int r13 = r11.length()
                    if (r13 <= 0) goto L_0x00f4
                    java.lang.String r13 = ";"
                    java.lang.String[] r11 = org.apache.commons.lang3.StringUtils.splitByWholeSeparator(r11, r13)
                    java.util.Collections.addAll(r10, r11)
                L_0x00f4:
                    int r11 = r12.length()
                    if (r11 <= 0) goto L_0x0113
                    java.lang.String[] r11 = org.apache.commons.lang3.StringUtils.splitByWholeSeparator(r12, r1)
                    int r12 = r11.length
                    r14 = 0
                L_0x0100:
                    if (r14 >= r12) goto L_0x0113
                    r15 = r11[r14]
                    java.lang.String r13 = "/"
                    java.lang.String r5 = "_"
                    java.lang.String r5 = r15.replace(r13, r5)
                    r10.add(r5)
                    int r14 = r14 + 1
                    r5 = 1
                    goto L_0x0100
                L_0x0113:
                    net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment r5 = net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment.this
                    r5.N4(r10)
                    net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment r5 = net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment.this
                    r5.M4()
                    java.util.ArrayList r5 = new java.util.ArrayList
                    java.lang.String r10 = "corrAns"
                    java.lang.String r11 = r3.getString(r10)
                    java.lang.String[] r1 = org.apache.commons.lang3.StringUtils.splitByWholeSeparator(r11, r1)
                    java.util.List r1 = java.util.Arrays.asList(r1)
                    r5.<init>(r1)
                    int r1 = r5.size()
                    r11 = 1
                    if (r1 <= r11) goto L_0x0139
                    r1 = 1
                    goto L_0x013a
                L_0x0139:
                    r1 = 0
                L_0x013a:
                    net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment r11 = net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment.this
                    net.imedicaldoctor.imd.Data.CompressHelper r12 = r11.Q4
                    android.os.Bundle r11 = r11.D4
                    java.lang.StringBuilder r13 = new java.lang.StringBuilder
                    r13.<init>()
                    java.lang.String r14 = "select * from answers where qId = "
                    r13.append(r14)
                    r13.append(r4)
                    java.lang.String r13 = r13.toString()
                    java.util.ArrayList r11 = r12.V(r11, r13)
                    if (r11 != 0) goto L_0x015c
                    java.util.ArrayList r11 = new java.util.ArrayList
                    r11.<init>()
                L_0x015c:
                    int r12 = r11.size()
                    if (r12 != 0) goto L_0x01aa
                    net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment r11 = net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment.this
                    net.imedicaldoctor.imd.Data.CompressHelper r12 = r11.Q4
                    android.os.Bundle r11 = r11.D4
                    java.lang.StringBuilder r13 = new java.lang.StringBuilder
                    r13.<init>()
                    java.lang.String r14 = "select '1' as id, '"
                    r13.append(r14)
                    r13.append(r4)
                    java.lang.String r14 = "' as qId,'"
                    r13.append(r14)
                    java.lang.String r15 = r3.getString(r10)
                    r13.append(r15)
                    java.lang.String r15 = "' as answerId, 'I Know the Answer' as answerText, '0' as correctPercentage UNION ALL select '2' as id, '"
                    r13.append(r15)
                    r13.append(r4)
                    r13.append(r14)
                    java.lang.String r14 = r3.getString(r10)
                    java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
                    int r14 = r14.intValue()
                    r15 = 1
                    int r14 = r14 + r15
                    r13.append(r14)
                    java.lang.String r14 = "' as answerId, 'I Don''t Know the Answer' as answerText, '0' as correctPercentage"
                    r13.append(r14)
                    java.lang.String r13 = r13.toString()
                    java.util.ArrayList r11 = r12.V(r11, r13)
                L_0x01aa:
                    java.lang.String r12 = "[correctID]"
                    java.lang.String r10 = r3.getString(r10)
                    java.lang.String r9 = net.imedicaldoctor.imd.Fragments.ViewerHelperFragment.j4(r9, r12, r10)
                    java.lang.String r10 = "[Question]"
                    java.lang.String r6 = net.imedicaldoctor.imd.Fragments.ViewerHelperFragment.j4(r9, r10, r6)
                    java.lang.String r9 = "[isMultipleAnswers]"
                    java.lang.String r10 = java.lang.String.valueOf(r1)
                    java.lang.String r6 = net.imedicaldoctor.imd.Fragments.ViewerHelperFragment.j4(r6, r9, r10)
                    java.util.Iterator r9 = r11.iterator()
                    r12 = 0
                L_0x01ca:
                    boolean r10 = r9.hasNext()
                    java.lang.String r14 = "correctPercentage"
                    if (r10 == 0) goto L_0x01e6
                    java.lang.Object r10 = r9.next()
                    android.os.Bundle r10 = (android.os.Bundle) r10
                    java.lang.String r10 = r10.getString(r14)
                    java.lang.Long r10 = java.lang.Long.valueOf(r10)
                    long r14 = r10.longValue()
                    long r12 = r12 + r14
                    goto L_0x01ca
                L_0x01e6:
                    java.lang.StringBuilder r9 = new java.lang.StringBuilder
                    r9.<init>()
                    java.util.Iterator r10 = r11.iterator()
                L_0x01ef:
                    boolean r11 = r10.hasNext()
                    java.lang.String r15 = ""
                    if (r11 == 0) goto L_0x035c
                    java.lang.Object r11 = r10.next()
                    android.os.Bundle r11 = (android.os.Bundle) r11
                    r17 = r10
                    java.lang.String r10 = "answerText"
                    java.lang.String r10 = r11.getString(r10)
                    r18 = r15
                    java.lang.String r15 = "the Answer"
                    boolean r15 = r10.contains(r15)
                    if (r15 != 0) goto L_0x0217
                    net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment r15 = net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment.this
                    net.imedicaldoctor.imd.Data.CompressHelper r15 = r15.Q4
                    java.lang.String r10 = r15.B(r10, r4, r8)
                L_0x0217:
                    java.lang.String r15 = "answerId"
                    java.lang.String r15 = r11.getString(r15)
                    r19 = r8
                    net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment r8 = net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment.this
                    java.lang.String r8 = r8.c5(r15)
                    java.lang.String r11 = r11.getString(r14)
                    java.lang.Float r11 = java.lang.Float.valueOf(r11)
                    float r11 = r11.floatValue()
                    r20 = r14
                    float r14 = (float) r12
                    float r11 = r11 / r14
                    r14 = 1120403456(0x42c80000, float:100.0)
                    float r11 = r11 * r14
                    int r11 = (int) r11
                    boolean r14 = r2.contains(r15)
                    if (r14 == 0) goto L_0x0249
                    java.lang.String r14 = "<img id=\"false\" src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAANCAMAAACXZR4WAAAABGdBTUEAAK/INwWK6QAAABl0RVh0U29mdHdhcmUAQWRvYmUgSW1hZ2VSZWFkeXHJZTwAAABgUExURQAAANkAANwREffMzPCZmehmZuEzM/zu7uNERPW7u+ZVVfrd3d4iIut3dwAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAO4UQPoAAAABdFJOUwBA5thmAAAAUUlEQVR42mzPSQ7AIAwDQFzK2vb/321CLOQDuUQeIUekdJjxxM6DgCv7ugFCXWK5EJqL5BDNJi8w9Y69Z/POpYqsviYSfS6E/kXz7Kd//AIMAHTvAR54Dn9XAAAAAElFTkSuQmCC\">"
                    java.lang.String r16 = "checked=\"checked\""
                    r18 = r14
                    r14 = r16
                    goto L_0x024b
                L_0x0249:
                    r14 = r18
                L_0x024b:
                    boolean r16 = r5.contains(r15)
                    if (r16 == 0) goto L_0x0253
                    java.lang.String r18 = "<img id=\"correct\" src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAANCAMAAACXZR4WAAAABGdBTUEAAK/INwWK6QAAABl0RVh0U29mdHdhcmUAQWRvYmUgSW1hZ2VSZWFkeXHJZTwAAABgUExURQCtACG9IVrOWnPOc5zWnLXWtQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAv7hYAAAAHdFJOU////////wAaSwNGAAAAQklEQVR42mzOwREAIAgDwaCR/kt2BBF05Lf3CdDnUNGfIHIHQYRGdwbQjHYCuCyaAWELLPYVpvcsj+OP8X993RRgAK2vA9pkmd9zAAAAAElFTkSuQmCC\">"
                L_0x0253:
                    r21 = r12
                    r12 = r18
                    if (r1 == 0) goto L_0x025e
                    java.lang.String r13 = "checkbox"
                L_0x025b:
                    r23 = r1
                    goto L_0x0261
                L_0x025e:
                    java.lang.String r13 = "radio"
                    goto L_0x025b
                L_0x0261:
                    java.lang.String r1 = ");\">"
                    r24 = r4
                    java.lang.String r4 = "\" onclick=\"answerClickedForStrikeout("
                    r25 = r3
                    java.lang.String r3 = ". </span></td><td><span id=\"AnswerText"
                    r26 = r7
                    java.lang.String r7 = "></td><td class=\"answerOptionNumber\"><span>"
                    r27 = r5
                    java.lang.String r5 = "\" "
                    r28 = r2
                    java.lang.String r2 = "\" name=\"Qbank-Answer-Button-Group\" onclick=\"answerChanged()\" value=\""
                    r29 = r6
                    java.lang.String r6 = "</td><td><input type=\""
                    r30 = r9
                    java.lang.String r9 = "\">"
                    r16 = r10
                    java.lang.String r10 = "\"><td width=\"16\" id=\"Qbank-Answer-Row-Image-"
                    r18 = r1
                    java.lang.String r1 = "<tr name=\"Qbank-Answer-Row-"
                    if (r11 == 0) goto L_0x0297
                    r31 = r11
                    net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment r11 = net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment.this
                    java.lang.Boolean r11 = r11.m5
                    boolean r11 = r11.booleanValue()
                    if (r11 != 0) goto L_0x029a
                L_0x0297:
                    r0 = r18
                    goto L_0x02f5
                L_0x029a:
                    java.lang.StringBuilder r11 = new java.lang.StringBuilder
                    r11.<init>()
                    r11.append(r1)
                    r11.append(r15)
                    r11.append(r10)
                    r11.append(r15)
                    r11.append(r9)
                    r11.append(r12)
                    r11.append(r6)
                    r11.append(r13)
                    r11.append(r2)
                    r11.append(r15)
                    r11.append(r5)
                    r11.append(r14)
                    r11.append(r7)
                    r11.append(r8)
                    r11.append(r3)
                    r11.append(r15)
                    r11.append(r4)
                    r11.append(r15)
                    r1 = r18
                    r11.append(r1)
                    r1 = r16
                    r11.append(r1)
                    java.lang.String r1 = " <span style=\"display: inline;\" name=\"Qbank-Answer-Stats\">["
                    r11.append(r1)
                    r1 = r31
                    r11.append(r1)
                    java.lang.String r1 = "%]</span></span></td>"
                    r11.append(r1)
                L_0x02ee:
                    java.lang.String r1 = r11.toString()
                    r0 = r30
                    goto L_0x033e
                L_0x02f5:
                    java.lang.StringBuilder r11 = new java.lang.StringBuilder
                    r11.<init>()
                    r11.append(r1)
                    r11.append(r15)
                    r11.append(r10)
                    r11.append(r15)
                    r11.append(r9)
                    r11.append(r12)
                    r11.append(r6)
                    r11.append(r13)
                    r11.append(r2)
                    r11.append(r15)
                    r11.append(r5)
                    r11.append(r14)
                    r11.append(r7)
                    r11.append(r8)
                    r11.append(r3)
                    r11.append(r15)
                    r11.append(r4)
                    r11.append(r15)
                    r11.append(r0)
                    r10 = r16
                    r11.append(r10)
                    java.lang.String r0 = " <span style=\"display: inline;\" name=\"Qbank-Answer-Stats\"></span></span></td>"
                    r11.append(r0)
                    goto L_0x02ee
                L_0x033e:
                    r0.append(r1)
                    r9 = r0
                    r10 = r17
                    r8 = r19
                    r14 = r20
                    r12 = r21
                    r1 = r23
                    r4 = r24
                    r3 = r25
                    r7 = r26
                    r5 = r27
                    r2 = r28
                    r6 = r29
                    r0 = r32
                    goto L_0x01ef
                L_0x035c:
                    r28 = r2
                    r25 = r3
                    r24 = r4
                    r27 = r5
                    r29 = r6
                    r26 = r7
                    r0 = r9
                    r18 = r15
                    java.lang.String r0 = r0.toString()
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    java.lang.String r2 = "<div id=\"answerSectionsa\"></div>"
                    r1.append(r2)
                    r1.append(r0)
                    java.lang.String r0 = r1.toString()
                    java.lang.String r1 = "[Answers]"
                    r2 = r29
                    java.lang.String r0 = net.imedicaldoctor.imd.Fragments.ViewerHelperFragment.j4(r2, r1, r0)
                    int r1 = r28.size()
                    java.lang.String r2 = "</b>"
                    java.lang.String r3 = "[Correct]"
                    if (r1 != 0) goto L_0x03b5
                    r1 = r32
                    net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment r4 = net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment.this
                    r5 = r27
                    java.lang.String r4 = r4.d5(r5)
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder
                    r5.<init>()
                    java.lang.String r6 = "<span id=\"resultstatement\" style=\"display: inline;\"> Correct answer is <b class=\"greenFont\">"
                L_0x03a3:
                    r5.append(r6)
                    r5.append(r4)
                    r5.append(r2)
                    java.lang.String r2 = r5.toString()
                L_0x03b0:
                    java.lang.String r0 = net.imedicaldoctor.imd.Fragments.ViewerHelperFragment.j4(r0, r3, r2)
                    goto L_0x03d2
                L_0x03b5:
                    r1 = r32
                    r5 = r27
                    r4 = r28
                    boolean r4 = r4.equals(r5)
                    if (r4 == 0) goto L_0x03c4
                    java.lang.String r2 = "<span class=\"greenFont\">Correct</span>"
                    goto L_0x03b0
                L_0x03c4:
                    net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment r4 = net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment.this
                    java.lang.String r4 = r4.d5(r5)
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder
                    r5.<init>()
                    java.lang.String r6 = "<span class=\"redFont\">Incorrect</span>.</span><span id=\"resultstatement\" style=\"display: inline;\"> Correct answer is <b class=\"greenFont\">"
                    goto L_0x03a3
                L_0x03d2:
                    if (r26 != 0) goto L_0x03d7
                    r7 = r18
                    goto L_0x03d9
                L_0x03d7:
                    r7 = r26
                L_0x03d9:
                    java.lang.String r2 = "corrTaken"
                    r3 = r25
                    java.lang.String r2 = r3.getString(r2)
                    java.lang.Float r2 = java.lang.Float.valueOf(r2)
                    float r2 = r2.floatValue()
                    java.lang.String r4 = "pplTaken"
                    java.lang.String r4 = r3.getString(r4)
                    java.lang.Float r4 = java.lang.Float.valueOf(r4)
                    float r4 = r4.floatValue()
                    float r2 = r2 / r4
                    r4 = 1120403456(0x42c80000, float:100.0)
                    float r2 = r2 * r4
                    int r2 = (int) r2
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder
                    r4.<init>()
                    r4.append(r2)
                    r5 = r18
                    r4.append(r5)
                    java.lang.String r4 = r4.toString()
                    java.lang.String r6 = "[CorrectPercent]"
                    java.lang.String r0 = net.imedicaldoctor.imd.Fragments.ViewerHelperFragment.j4(r0, r6, r4)
                    net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment r4 = net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment.this
                    java.lang.Boolean r4 = r4.m5
                    boolean r4 = r4.booleanValue()
                    if (r4 != 0) goto L_0x0462
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder
                    r4.<init>()
                    r4.append(r2)
                    r4.append(r5)
                    java.lang.String r4 = r4.toString()
                    int r4 = r4.length()
                    r6 = 1
                    if (r4 != r6) goto L_0x044e
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder
                    r4.<init>()
                    r4.append(r2)
                    java.lang.String r2 = "% answered correctly"
                    r4.append(r2)
                    java.lang.String r2 = r4.toString()
                    java.lang.String r4 = "No data available now"
                L_0x0449:
                    java.lang.String r0 = net.imedicaldoctor.imd.Fragments.ViewerHelperFragment.j4(r0, r2, r4)
                    goto L_0x0462
                L_0x044e:
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder
                    r4.<init>()
                    r4.append(r2)
                    java.lang.String r2 = "% answered correctly"
                    r4.append(r2)
                    java.lang.String r2 = r4.toString()
                    java.lang.String r4 = "No data available now."
                    goto L_0x0449
                L_0x0462:
                    java.lang.String r2 = "[Explanation]"
                    java.lang.String r0 = net.imedicaldoctor.imd.Fragments.ViewerHelperFragment.j4(r0, r2, r7)
                    net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment r2 = net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment.this
                    java.lang.String r2 = r2.l5
                    java.lang.String r4 = "[Seconds]"
                    java.lang.String r0 = net.imedicaldoctor.imd.Fragments.ViewerHelperFragment.j4(r0, r4, r2)
                    java.lang.String r2 = "[QID]"
                    r4 = r24
                    java.lang.String r0 = net.imedicaldoctor.imd.Fragments.ViewerHelperFragment.j4(r0, r2, r4)
                    net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment r2 = net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment.this
                    boolean r2 = r2.o5
                    if (r2 != 0) goto L_0x048a
                    java.lang.String r2 = "<td width=\"50%\" class=\"copyright\"><b>Subject:</b><br/>[Subject]</td>"
                    java.lang.String r0 = net.imedicaldoctor.imd.Fragments.ViewerHelperFragment.j4(r0, r2, r5)
                L_0x048a:
                    net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment r2 = net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment.this
                    boolean r2 = r2.p5
                    if (r2 != 0) goto L_0x0498
                    java.lang.String r2 = "<td width=\"50%\" class=\"copyright\"><b>System:</b><br/>[System]</td>"
                    java.lang.String r0 = net.imedicaldoctor.imd.Fragments.ViewerHelperFragment.j4(r0, r2, r5)
                L_0x0498:
                    net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment r2 = net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment.this     // Catch:{ Exception -> 0x04f7 }
                    net.imedicaldoctor.imd.Data.CompressHelper r4 = r2.Q4     // Catch:{ Exception -> 0x04f7 }
                    android.os.Bundle r2 = r2.D4     // Catch:{ Exception -> 0x04f7 }
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04f7 }
                    r6.<init>()     // Catch:{ Exception -> 0x04f7 }
                    java.lang.String r7 = "select name as name from subjects where id="
                    r6.append(r7)     // Catch:{ Exception -> 0x04f7 }
                    java.lang.String r7 = "subId"
                    java.lang.String r7 = r3.getString(r7)     // Catch:{ Exception -> 0x04f7 }
                    r6.append(r7)     // Catch:{ Exception -> 0x04f7 }
                    java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x04f7 }
                    java.util.ArrayList r2 = r4.V(r2, r6)     // Catch:{ Exception -> 0x04f7 }
                    r4 = 0
                    java.lang.Object r2 = r2.get(r4)     // Catch:{ Exception -> 0x04f7 }
                    android.os.Bundle r2 = (android.os.Bundle) r2     // Catch:{ Exception -> 0x04f7 }
                    java.lang.String r4 = "name"
                    java.lang.String r2 = r2.getString(r4)     // Catch:{ Exception -> 0x04f7 }
                    net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment r4 = net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment.this     // Catch:{ Exception -> 0x04f5 }
                    net.imedicaldoctor.imd.Data.CompressHelper r6 = r4.Q4     // Catch:{ Exception -> 0x04f5 }
                    android.os.Bundle r4 = r4.D4     // Catch:{ Exception -> 0x04f5 }
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04f5 }
                    r7.<init>()     // Catch:{ Exception -> 0x04f5 }
                    java.lang.String r8 = "select name as name from systems where id="
                    r7.append(r8)     // Catch:{ Exception -> 0x04f5 }
                    java.lang.String r8 = "sysId"
                    java.lang.String r8 = r3.getString(r8)     // Catch:{ Exception -> 0x04f5 }
                    r7.append(r8)     // Catch:{ Exception -> 0x04f5 }
                    java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x04f5 }
                    java.util.ArrayList r4 = r6.V(r4, r7)     // Catch:{ Exception -> 0x04f5 }
                    r6 = 0
                    java.lang.Object r4 = r4.get(r6)     // Catch:{ Exception -> 0x04f5 }
                    android.os.Bundle r4 = (android.os.Bundle) r4     // Catch:{ Exception -> 0x04f5 }
                    java.lang.String r6 = "name"
                    java.lang.String r4 = r4.getString(r6)     // Catch:{ Exception -> 0x04f5 }
                    goto L_0x04fa
                L_0x04f5:
                    goto L_0x04f9
                L_0x04f7:
                    r2 = r5
                L_0x04f9:
                    r4 = r5
                L_0x04fa:
                    java.lang.String r6 = "[Subject]"
                    java.lang.String r0 = net.imedicaldoctor.imd.Fragments.ViewerHelperFragment.j4(r0, r6, r2)
                    java.lang.String r2 = "[System]"
                    java.lang.String r0 = net.imedicaldoctor.imd.Fragments.ViewerHelperFragment.j4(r0, r2, r4)
                    net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment r2 = net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment.this
                    java.lang.Boolean r2 = r2.n5
                    boolean r2 = r2.booleanValue()
                    if (r2 != 0) goto L_0x0518
                    java.lang.String r2 = "<td width=\"33%\" class=\"copyright\"><b>Last updated</b>:<br>[LastUpdated]</td>"
                    java.lang.String r0 = net.imedicaldoctor.imd.Fragments.ViewerHelperFragment.j4(r0, r2, r5)
                L_0x0518:
                    java.lang.String r2 = "lastUpdated"
                    java.lang.String r2 = r3.getString(r2)
                    java.lang.String r3 = "[LastUpdated]"
                    java.lang.String r0 = net.imedicaldoctor.imd.Fragments.ViewerHelperFragment.j4(r0, r3, r2)
                    java.lang.String r2 = "highresdefault/"
                    java.lang.String r3 = "highresdefault_"
                    java.lang.String r0 = net.imedicaldoctor.imd.Fragments.ViewerHelperFragment.j4(r0, r2, r3)
                    net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment r2 = net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment.this
                    r2.A4 = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment.AnonymousClass2.run():void");
            }
        }, new Runnable() {
            public void run() {
                UWTestViewerActivityFragment.this.i5();
            }
        });
    }

    public void h5() {
        this.g5 = new Date();
        this.F4 = "Question " + (this.e5 + 1) + " Of " + this.d5.size();
        StringBuilder sb = new StringBuilder();
        sb.append("question-");
        sb.append(this.d5.get(this.e5).getString("id"));
        this.E4 = sb.toString();
        Bundle bundle = this.d5.get(this.e5);
        String string = bundle.getString("id");
        boolean contains = bundle.getString("corrAns").contains(",");
        Bundle bundle2 = this.f5;
        String str = "100";
        if (bundle2 != null) {
            String string2 = bundle2.getString("id");
            ArrayList<Bundle> V = this.Q4.V(this.D4, "Select * from logs where testId=" + string2 + " AND qid = " + string);
            if (V == null || V.size() <= 0) {
                if (this.f5.getString("done").equals(IcyHeaders.a3)) {
                    g5(str, false);
                    return;
                }
            } else if (!this.f5.getString("mode").equals("Testing (Timed)")) {
                g5(V.get(0).getString("selectedAnswer"), false);
                return;
            } else if (this.f5.getString("done").equals("0")) {
                str = V.get(0).getString("selectedAnswer");
            } else {
                g5(V.get(0).getString("selectedAnswer"), false);
                return;
            }
        }
        String B = this.Q4.B(bundle.getString("question"), string, "127");
        this.Q4.B(bundle.getString("explanation"), string, "127");
        String j4 = ViewerHelperFragment.j4(d4(r(), "UWHeader.css") + d4(r(), "UWQuestion.css"), "[size]", "200");
        ArrayList arrayList = new ArrayList();
        String string3 = bundle.getString("mediaName");
        String string4 = bundle.getString("otherMedias");
        if (string3.length() > 0) {
            Collections.addAll(arrayList, StringUtils.splitByWholeSeparator(string3, ";"));
        }
        if (string4.length() > 0) {
            for (String replace : StringUtils.splitByWholeSeparator(string4, ",")) {
                arrayList.add(replace.replace("/", "_"));
            }
        }
        N4(arrayList);
        M4();
        ArrayList<Bundle> V2 = this.Q4.V(this.D4, "select * from answers where qId = " + string);
        if (V2 == null) {
            V2 = new ArrayList<>();
        }
        if (V2.size() == 0) {
            V2 = this.Q4.V(this.D4, "select '1' as id, '" + string + "' as qId,'" + bundle.getString("corrAns") + "' as answerId, 'I Know the Answer' as answerText, '0' as correctPercentage UNION ALL select '2' as id, '" + string + "' as qId,'" + (Integer.valueOf(bundle.getString("corrAns")).intValue() + 1) + "' as answerId, 'I Don''t Know the Answer' as answerText, '0' as correctPercentage");
        }
        String j42 = ViewerHelperFragment.j4(ViewerHelperFragment.j4(j4, "[correctID]", bundle.getString("corrAns")), "[Question]", B);
        StringBuilder sb2 = new StringBuilder();
        Iterator<Bundle> it2 = V2.iterator();
        while (it2.hasNext()) {
            Bundle next = it2.next();
            String string5 = next.getString("answerText");
            if (!string5.contains("the Answer")) {
                string5 = this.Q4.B(string5, string, "127");
            }
            String string6 = next.getString("answerId");
            String c52 = c5(string6);
            sb2.append("<tr><td width=\"16\" id=\"Qbank-Answer-Row-Image-" + string6 + "\"></td><td><input type=\"" + (contains ? "checkbox" : "radio") + "\" name=\"Qbank-Answer-Button-Group\" value=\"" + string6 + "\" onclick=\"answerChanged()\" " + (string6.equals(str) ? "checked=\"checked\"" : "") + "></td><td class=\"answerOptionNumber\"><span>" + c52 + ". </span></td><td><span id=\"AnswerText" + string6 + "\" onclick=\"answerClickedForStrikeout(" + string6 + ");\">" + string5 + "</span></td></tr>");
        }
        this.A4 = ViewerHelperFragment.j4(ViewerHelperFragment.j4(ViewerHelperFragment.j4(j42, "[Answers]", sb2.toString()), "highresdefault/", "highresdefault_"), "[isMultipleAnswers]", String.valueOf(contains));
        i5();
    }

    public void i5() {
        O3(this.A4, CompressHelper.g1(this.D4, "base"));
        String str = this.F4;
        if (str != null) {
            this.L4.setTitle((CharSequence) str);
            n4(this.F4);
            M2();
        }
        o4();
        q4(this.L4.getMenu());
        t5();
    }

    public void j5(String str) {
        String[] split = str.split(",");
        StringBuilder sb = new StringBuilder("CASE id ");
        for (int i2 = 0; i2 < split.length; i2++) {
            sb.append("WHEN ");
            sb.append(split[i2]);
            sb.append(" THEN ");
            sb.append(i2);
            sb.append(StringUtils.SPACE);
        }
        sb.append("END");
        this.d5 = this.Q4.V(this.D4, "SELECT * FROM Questions WHERE id IN (" + str + ") ORDER BY " + sb.toString());
    }

    public void k5(String str) {
        String str2;
        String string = this.d5.get(this.e5).getString("id");
        String string2 = this.d5.get(this.e5).getString("corrAns");
        Date date = new Date();
        String a52 = a5(date);
        long time = (date.getTime() - this.g5.getTime()) / 1000;
        Bundle bundle = this.f5;
        String string3 = bundle != null ? bundle.getString("id") : "null";
        ArrayList<Bundle> V = this.Q4.V(this.D4, "Select * from logs where testId=" + string3 + " AND qid = " + string);
        StringBuilder sb = new StringBuilder();
        sb.append(time);
        sb.append(" Seconds");
        this.l5 = sb.toString();
        if (V == null || V.size() <= 0) {
            str2 = "Insert into logs (id, qid, selectedAnswer, corrAnswer, answerDate, time, testId) values (null, " + string + ", '" + str + "', '" + string2 + "', '" + a52 + "', " + time + ", " + string3 + ")";
        } else {
            str2 = "Update logs set selectedAnswer = '" + str + "', answerDate='" + a52 + "', time=" + time + " where id=" + V.get(0).getString("id");
        }
        this.Q4.m(this.D4, str2);
    }

    public String l5(String str) {
        ArrayList arrayList = new ArrayList(Arrays.asList(StringUtils.splitByWholeSeparator(str, "/")));
        arrayList.remove(arrayList.size() - 1);
        return StringUtils.join((Iterable<?>) arrayList, "/");
    }

    public void n5() {
        this.q5 = this.G4.getScrollY();
        this.r5 = this.G4.getScrollX();
    }

    public void o4() {
    }

    public void p3(String str) {
        CompressHelper compressHelper = this.Q4;
        String X0 = compressHelper.X0();
        compressHelper.q(X0, "delete from favorites where dbName='" + this.Q4.a1(this.D4.getString("Name")) + "' AND (dbAddress='" + this.Q4.a1(str) + "' OR dbAddress='question-" + this.Q4.a1(str) + "' OR dbAddress='answer-" + this.Q4.a1(str) + "')");
        l4();
    }

    public void r5() {
        try {
            String d4 = d4(r(), "LXHeader.css");
            String d42 = d4(r(), "LXFooter.css");
            String replace = d4.replace("[size]", "200").replace("[title]", this.F4).replace("[include]", "");
            Iterator it2 = this.Q4.G(new JSONObject(d4(r(), "l.json"))).getParcelableArrayList("USMLE").iterator();
            int i2 = 0;
            String str = "";
            while (it2.hasNext()) {
                Bundle bundle = (Bundle) it2.next();
                i2++;
                str = str + e5(bundle.getString("name"), bundle.getString(Annotation.i3).replace("display:none", ""), i2 + "");
            }
            E4(replace + str + d42, "Lab Values");
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            iMDLogger.f("LXViewer", "Error in reading LXHeader and LXFooter : " + e2.getLocalizedMessage());
        }
    }

    public String s3() {
        String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(this.E4, "-");
        return splitByWholeSeparator.length > 1 ? splitByWholeSeparator[1] : this.E4;
    }

    public void t5() {
        this.s4.findItem(R.id.f820action_stop).setVisible(false);
        if (this.f5 != null) {
            this.s4.findItem(R.id.f820action_stop).setVisible(true);
        }
        K4();
        L4();
        if (this.e5 <= 0) {
            I4();
        }
        if (this.e5 >= this.d5.size() - 1) {
            J4();
        }
    }

    public boolean v4() {
        return false;
    }

    public boolean y4(WebView webView, String str, String str2, String str3) {
        String str4;
        if (str2.equals("image")) {
            String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(str3, "/");
            q5(splitByWholeSeparator[splitByWholeSeparator.length - 1]);
            return true;
        }
        iMDLogger.j("Override", "Url : " + str + ", Scheme : " + str2 + ", Resource : " + str3);
        if (str3.contains("USMLEWorld-Question-Answer-Changed")) {
            this.G4.g("console.log(\"answer,,,,,\" + prevAnswerID);");
            return true;
        } else if (str3.contains("/2323")) {
            q5("soheilvb");
            return true;
        } else {
            if (str2.equals(Annotation.k3) || (str2.equals("http") && str3.contains("localhost:"))) {
                String[] splitByWholeSeparator2 = StringUtils.splitByWholeSeparator(str3, "/");
                String str5 = splitByWholeSeparator2[splitByWholeSeparator2.length - 1];
                if (str5.endsWith(".html")) {
                    try {
                        str4 = CompressHelper.e2(new File(CompressHelper.h1(this.D4, str5, "base")));
                    } catch (Exception unused) {
                        str4 = "";
                    }
                    E4(str4, "UWORLD");
                    return true;
                }
                q5(str5);
            }
            return true;
        }
    }
}
