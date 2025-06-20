package net.imedicaldoctor.imd.Fragments;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.print.PrintAttributes;
import android.print.PrintManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.media3.common.C;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;
import at.grabner.circleprogress.CircleProgressView;
import com.basusingh.beautifulprogressdialog.BeautifulProgressDialog;
import com.google.android.material.appbar.AppBarLayout;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.itextpdf.text.Annotation;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.itextpdf.tool.xml.html.HTML;
import fi.iki.elonen.NanoHTTPD;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.requery.android.database.sqlite.SQLiteDatabase;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import net.imedicaldoctor.imd.CollapsingToolbar.CollapsingToolbarLayout;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Data.HistoryAdapter;
import net.imedicaldoctor.imd.Data.UnzipCompleted;
import net.imedicaldoctor.imd.Decompress;
import net.imedicaldoctor.imd.Fragments.AccessMedicine.AMHTMLViewerFragment;
import net.imedicaldoctor.imd.Fragments.Dictionary.CDicSearchActivity;
import net.imedicaldoctor.imd.GeneralDialogFragment;
import net.imedicaldoctor.imd.LocalServer;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Utils.ActionModeResponse;
import net.imedicaldoctor.imd.Utils.iMDWebView;
import net.imedicaldoctor.imd.Views.BlueHighlightButton;
import net.imedicaldoctor.imd.Views.GreenHighlightButton;
import net.imedicaldoctor.imd.Views.RedHighlightButton;
import net.imedicaldoctor.imd.Views.WhiteHighlightButton;
import net.imedicaldoctor.imd.Views.YellowHighlightButton;
import net.imedicaldoctor.imd.extractingFragment;
import net.imedicaldoctor.imd.iMD;
import net.imedicaldoctor.imd.iMDLogger;
import okio.BufferedSink;
import okio.Okio;
import org.apache.commons.lang3.StringUtils;
import org.ccil.cowan.tagsoup.Parser;
import org.ccil.cowan.tagsoup.XMLWriter;
import org.json.JSONArray;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.xml.sax.InputSource;

public class ViewerHelperFragment extends Fragment implements ActionBar.TabListener {
    private static final String V4 = "ViewerHelperFragment";
    /* access modifiers changed from: private */
    public static extractingFragment W4;
    public String A4;
    public Activity B4;
    public View C4;
    public Bundle D4;
    public String E4;
    public String F4;
    public iMDWebView G4;
    public JSONArray H4;
    public BeautifulProgressDialog I4;
    public MenuItem J4;
    public String K4;
    public Toolbar L4;
    public ImageView M4;
    public TextView N4;
    public PopupWindow O4;
    public NestedScrollView P4;
    public CompressHelper Q4;
    public long R4;
    public String S4;
    public Runnable T4;
    public Runnable U4;
    public boolean e4;
    public String f4;
    public String g4;
    public boolean h4;
    /* access modifiers changed from: private */
    public DrawerLayout i4;
    public RecyclerView j4;
    public boolean k4;
    public GeneralDialogFragment l4;
    public Bundle m4;
    public int n4;
    public int o4;
    public String p4;
    /* access modifiers changed from: private */
    public ProgressBar q4;
    public SearchView r4;
    public Menu s4;
    public ImageButton t4;
    public ImageButton u4;
    public TextView v4;
    public MenuItem w4;
    public TabHost x4;
    public String[] y4;
    public String z4;

    /* access modifiers changed from: private */
    public /* synthetic */ void L3(String str) {
        try {
            this.G4.evaluateJavascript("document.documentElement.innerHTML = '" + str + "';", new ValueCallback<String>() {
                /* renamed from: a */
                public void onReceiveValue(String str) {
                    ViewerHelperFragment.this.I4.a();
                }
            });
        } catch (Exception e2) {
            Log.e("WebView", "Activity is finishing or has finished", e2);
        }
    }

    public static String O2(String str, String str2) {
        int indexOf;
        if (str2.equalsIgnoreCase("charis")) {
            return str;
        }
        while (true) {
            int indexOf2 = str.indexOf("@font-face");
            if (indexOf2 <= -1 || (indexOf = str.indexOf("}", indexOf2)) < indexOf2) {
            } else {
                int i2 = indexOf + 1;
                str = str.substring(0, indexOf2) + "" + (i2 < str.length() ? str.substring(i2) : "");
            }
        }
        return j4(str, "\"Charis\"", "\"" + str2 + "\"");
    }

    public static String h4(String str) {
        int indexOf;
        while (true) {
            int indexOf2 = str.indexOf("line-height:");
            if (indexOf2 <= -1 || (indexOf = str.indexOf(";", indexOf2)) < indexOf2) {
                return str;
            }
            int i2 = indexOf + 1;
            str = str.substring(0, indexOf2) + "" + (i2 < str.length() ? str.substring(i2) : "");
        }
        return str;
    }

    public static void i3(File file, File file2) throws IOException {
        if (file.isDirectory()) {
            if (!file2.exists()) {
                file2.mkdir();
            }
            String[] list = file.list();
            for (int i2 = 0; i2 < file.listFiles().length; i2++) {
                i3(new File(file, list[i2]), new File(file2, list[i2]));
            }
            return;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        byte[] bArr = new byte[102400];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read > 0) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                fileInputStream.close();
                fileOutputStream.close();
                return;
            }
        }
    }

    public static String i4(String str) {
        int indexOf;
        while (true) {
            int indexOf2 = str.indexOf("text-align:");
            if (indexOf2 <= -1 || (indexOf = str.indexOf(";", indexOf2)) < indexOf2) {
                return str;
            }
            int i2 = indexOf + 1;
            str = str.substring(0, indexOf2) + "" + (i2 < str.length() ? str.substring(i2) : "");
        }
        return str;
    }

    public static String j4(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        int indexOf = sb.indexOf(str2);
        while (indexOf != -1) {
            sb.replace(indexOf, str2.length() + indexOf, str3);
            indexOf = sb.indexOf(str2, indexOf + str3.length());
        }
        return sb.toString();
    }

    public void A3(int i2) {
        if (this.H4.length() > 0) {
            try {
                iMDWebView imdwebview = this.G4;
                imdwebview.g("setHighlightClass(\"" + this.H4.getString(this.n4) + "\")");
                iMDWebView imdwebview2 = this.G4;
                imdwebview2.g("goToSelectedItem(\"" + this.H4.getString(i2) + "\")");
                this.n4 = i2;
            } catch (Exception e2) {
                FirebaseCrashlytics.d().g(e2);
            }
        }
        U2();
    }

    public boolean A4() {
        return getActivity().getSharedPreferences("default_preferences", 0).getBoolean("showpopup", true);
    }

    public void B3() {
        if (y().containsKey("gotoHighlight")) {
            String string = y().getString("gotoHighlight");
            iMDWebView imdwebview = this.G4;
            imdwebview.g("gotoHighlight('" + string + "');");
            y().remove("gotoHighlight");
        }
    }

    public void B4(Exception exc) {
        exc.printStackTrace();
        FirebaseCrashlytics.d().g(exc);
        AlertDialog.Builder builder = new AlertDialog.Builder(r(), R.style.f2185alertDialogTheme);
        builder.l("Error occured in loading document. : " + exc).p("Go Back", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                ViewerHelperFragment.this.Q4.W1(false);
            }
        }).I();
    }

    public void C(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    public void C3(String str) {
        iMDLogger.j("Viewer activity , Gotosection", str);
        iMDWebView imdwebview = this.G4;
        imdwebview.g("document.getElementById(\"" + str + "\").scrollIntoView(true);");
    }

    public void C4(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(r(), R.style.f2185alertDialogTheme);
        builder.l("Error occured in loading document. : " + str).p("Go Back", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                ViewerHelperFragment.this.Q4.W1(false);
            }
        }).I();
    }

    public void D2(Intent intent) {
        super.D2(intent);
        r().overridePendingTransition(R.anim.f15from_fade_in, R.anim.f16from_fade_out);
    }

    public boolean D3() {
        return true;
    }

    public void D4(String str) {
        String str2 = "select rowid as _id,* from highlight where save match '" + this.Q4.a1(str) + "' AND rowid in (select rowid from highlight where highlight match 'dbName:" + this.D4.getString("Name").replace("'", "''") + " AND dbAddress:" + this.Q4.a1(s3()) + "')";
        iMDLogger.j("Url", "sql : " + str2);
        ArrayList<Bundle> Y = this.Q4.Y(I3(), str2);
        if (Y == null || Y.size() == 0) {
            iMDLogger.j("Url", "note size is zero");
            CompressHelper.x2(r(), "Note Not Found", 1);
            return;
        }
        final Bundle bundle = Y.get(0);
        final EditText editText = new EditText(r());
        editText.setTextColor(b0().getColor(R.color.f140black));
        editText.setText(bundle.getString("note"));
        new AlertDialog.Builder(r(), R.style.f2185alertDialogTheme).l("Note").setView(editText).y("Update", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                String obj = editText.getText().toString();
                ViewerHelperFragment viewerHelperFragment = ViewerHelperFragment.this;
                CompressHelper compressHelper = viewerHelperFragment.Q4;
                String I3 = viewerHelperFragment.I3();
                compressHelper.q(I3, "Update highlight set note = '" + obj.replace("'", "''") + "' where rowid=" + bundle.getString("_id"));
            }
        }).p("Delete", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                ViewerHelperFragment viewerHelperFragment = ViewerHelperFragment.this;
                CompressHelper compressHelper = viewerHelperFragment.Q4;
                String I3 = viewerHelperFragment.I3();
                compressHelper.q(I3, "delete from highlight where rowid=" + bundle.getString("_id"));
                ViewerHelperFragment.this.S3();
            }
        }).I();
    }

    public Boolean E3(String str) {
        return Boolean.FALSE;
    }

    public void E4(String str, String str2) {
        if (A4()) {
            Bundle bundle = new Bundle();
            bundle.putBundle("DB", this.D4);
            CompressHelper compressHelper = this.Q4;
            Bundle bundle2 = this.D4;
            bundle.putString("URL", compressHelper.F2(bundle2, "html-" + str2 + ",,,,," + str));
            bundle.putString("Dialog", IcyHeaders.a3);
            AMHTMLViewerFragment aMHTMLViewerFragment = new AMHTMLViewerFragment();
            aMHTMLViewerFragment.i2(bundle);
            GeneralDialogFragment generalDialogFragment = new GeneralDialogFragment(aMHTMLViewerFragment);
            this.l4 = generalDialogFragment;
            generalDialogFragment.Z2(true);
            this.l4.e3(getActivity().k0(), "AMSectionsViewer");
            getActivity().k0().b("AMResult", this, new c());
            return;
        }
        CompressHelper compressHelper2 = this.Q4;
        Bundle bundle3 = this.D4;
        compressHelper2.A1(bundle3, "html-" + str2 + ",,,,," + str, (String[]) null, (String) null);
    }

    public void F3() {
        CircleProgressView circleProgressView = (CircleProgressView) this.C4.findViewById(R.id.f1046progress_view);
        if (circleProgressView != null) {
            circleProgressView.setVisibility(8);
        }
    }

    public String F4() {
        String g1 = CompressHelper.g1(this.D4, "tempp.db");
        if (!new File(g1).exists()) {
            try {
                SQLiteDatabase.openOrCreateDatabase(g1, (SQLiteDatabase.CursorFactory) null).execSQL("CREATE TABLE tempp (id varchar(255) PRIMARY KEY NOT NULL  UNIQUE , content Text, date Text);");
            } catch (Exception e2) {
                FirebaseCrashlytics.d().g(e2);
                new File(g1).delete();
                try {
                    SQLiteDatabase.openOrCreateDatabase(g1, (SQLiteDatabase.CursorFactory) null).execSQL("CREATE TABLE tempp (id varchar(255) PRIMARY KEY NOT NULL  UNIQUE , content Text, date Text);");
                } catch (Exception unused) {
                }
            }
        }
        return g1;
    }

    public void G3() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) r().getSystemService("input_method");
            if (r().getCurrentFocus() != null) {
                inputMethodManager.hideSoftInputFromWindow(r().getCurrentFocus().getWindowToken(), 0);
            }
            r().getCurrentFocus().clearFocus();
        } catch (Exception unused) {
        }
    }

    public void G4() {
        this.G4.i();
    }

    public void H3(Boolean bool) {
        try {
            LinearLayout linearLayout = (LinearLayout) r().findViewById(R.id.f937find_layout);
            if (bool.booleanValue()) {
                this.w4.setVisible(false);
                linearLayout.setVisibility(8);
                return;
            }
            linearLayout.setVisibility(0);
        } catch (Exception unused) {
        }
    }

    public void H4() {
        this.G4.j();
    }

    public void I(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    public String I3() {
        String str = this.Q4.M1() + "/highlights.db";
        if (!new File(str).exists()) {
            SQLiteDatabase.openOrCreateDatabase(str, (SQLiteDatabase.CursorFactory) null).execSQL("create virtual table highlight using fts4 (dbName, dbTitle, dbAddress, dbDate, dbDocName, type, text, note, save)");
        }
        return str;
    }

    public boolean J3(Context context) {
        return getActivity().getSharedPreferences("default_preferences", 0).getBoolean("dark", false);
    }

    public Boolean K3(String str) {
        CompressHelper compressHelper = this.Q4;
        String X0 = compressHelper.X0();
        StringBuilder sb = new StringBuilder();
        sb.append("select * from favorites where dbName='");
        sb.append(this.Q4.a1(this.D4.getString("Name")));
        sb.append("' AND dbAddress='");
        sb.append(this.Q4.a1(str));
        sb.append("'");
        return Boolean.valueOf(compressHelper.s1(compressHelper.Y(X0, sb.toString())) != null);
    }

    public void L2(String str, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String a1 = this.Q4.a1(str);
        String a12 = this.Q4.a1(str2);
        String format = simpleDateFormat.format(new Date());
        String a13 = this.Q4.a1(this.D4.getString("Title"));
        String a14 = this.Q4.a1(this.D4.getString("Name"));
        CompressHelper compressHelper = this.Q4;
        String X0 = compressHelper.X0();
        compressHelper.q(X0, "Insert into favorites values (null, '" + a14 + "', '" + a13 + "', '" + a12 + "', '" + format + "', '" + a1 + "')");
        l4();
    }

    public void M0(Activity activity) {
        super.M0(activity);
        this.B4 = activity;
    }

    public void M2() {
        Bundle bundle = this.D4;
        if (bundle != null) {
            this.Q4.A0(bundle.getString("Name"), this.D4.getString("Title"), e4(), f4());
        }
    }

    public void N2() {
        this.G4.g("removeAllHighlights(\"aa\");");
        H3(Boolean.TRUE);
    }

    public void N3(String str, String str2) {
        this.G4.loadDataWithBaseURL(str, "<html><body>Loading Content</body></html>", NanoHTTPD.p, "utf-8", (String) null);
        String replace = str2.replace("'", "\\'").replace(StringUtils.LF, "\\n").replace(StringUtils.CR, "\\r");
        BeautifulProgressDialog beautifulProgressDialog = new BeautifulProgressDialog(r(), BeautifulProgressDialog.q, (String) null);
        this.I4 = beautifulProgressDialog;
        beautifulProgressDialog.p("loading-1.json");
        this.I4.q(true);
        this.I4.w();
        this.G4.postDelayed(new b(this, replace), 100);
    }

    public void O3(String str, String str2) {
        if (str2 != null && str2.startsWith("file://")) {
            String replace = str2.replace("file://", "");
            str2 = replace.substring(0, replace.length() - 1);
        }
        if (getActivity().getSharedPreferences("default_preferences", 0).getBoolean("newdocument", false)) {
            R3(str, str2);
        } else {
            P3(str, str2);
        }
    }

    public void P2() {
        ((AppBarLayout) this.C4.findViewById(R.id.f825appbar)).D(false, false);
    }

    public void P3(String str, String str2) {
        String str3;
        if (str2 != null) {
            File file = new File(str2);
            str3 = "file://" + file.getAbsolutePath() + "/";
        } else {
            str3 = null;
        }
        this.G4.loadDataWithBaseURL(str3, str, NanoHTTPD.p, "utf-8", (String) null);
    }

    public void Q0(Bundle bundle) {
        super.Q0(bundle);
        this.Q4 = new CompressHelper(r());
    }

    public void Q2(File file) {
        if (file.isDirectory()) {
            for (File Q2 : file.listFiles()) {
                Q2(Q2);
            }
        }
        file.delete();
    }

    public void Q3(String str, String str2) {
        if (str2 != null) {
            File file = new File(new File(str2), "t.html");
            try {
                CompressHelper.E2(file, str);
            } catch (Exception unused) {
            }
            this.G4.loadUrl("file://" + file.getAbsolutePath());
            return;
        }
        P3(str, str2);
    }

    public String R2() {
        return null;
    }

    public void R3(String str, String str2) {
        this.G4.getSettings().setCacheMode(2);
        if (((iMD) r().getApplicationContext()).X != null) {
            try {
                ((iMD) r().getApplicationContext()).X.O();
            } catch (Exception unused) {
            }
        }
        ((iMD) r().getApplicationContext()).X = new LocalServer(8585, str, str2);
        try {
            ((iMD) r().getApplicationContext()).X.L();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        this.G4.loadUrl("about:blank");
        this.G4.loadUrl("http://localhost:8585/content");
    }

    public Observable<String> S2() {
        return Observable.w1(new ObservableOnSubscribe<String>() {
            public void a(@NonNull ObservableEmitter<String> observableEmitter) throws Throwable {
                String R2 = ViewerHelperFragment.this.R2();
                if (R2 == null) {
                    R2 = "";
                }
                observableEmitter.onNext(R2);
                observableEmitter.onComplete();
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0168 A[Catch:{ Exception -> 0x0050 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x006d A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void S3() {
        /*
            r19 = this;
            r1 = r19
            java.lang.String r0 = "text"
            java.lang.String r2 = "save"
            java.lang.String r3 = "'"
            java.lang.String r4 = "$"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0050 }
            r5.<init>()     // Catch:{ Exception -> 0x0050 }
            java.lang.String r6 = "select rowid as _id, dbName, dbTitle, dbAddress, dbDate, dbDocName, type, text, note, save from highlight where dbName='"
            r5.append(r6)     // Catch:{ Exception -> 0x0050 }
            android.os.Bundle r6 = r1.D4     // Catch:{ Exception -> 0x0050 }
            java.lang.String r7 = "Name"
            java.lang.String r6 = r6.getString(r7)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r7 = "''"
            java.lang.String r6 = r6.replace(r3, r7)     // Catch:{ Exception -> 0x0050 }
            r5.append(r6)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r6 = "' AND dbAddress='"
            r5.append(r6)     // Catch:{ Exception -> 0x0050 }
            net.imedicaldoctor.imd.Data.CompressHelper r6 = r1.Q4     // Catch:{ Exception -> 0x0050 }
            java.lang.String r7 = r19.s3()     // Catch:{ Exception -> 0x0050 }
            java.lang.String r6 = r6.a1(r7)     // Catch:{ Exception -> 0x0050 }
            r5.append(r6)     // Catch:{ Exception -> 0x0050 }
            r5.append(r3)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r3 = r5.toString()     // Catch:{ Exception -> 0x0050 }
            net.imedicaldoctor.imd.Data.CompressHelper r5 = r1.Q4     // Catch:{ Exception -> 0x0050 }
            java.lang.String r6 = r19.I3()     // Catch:{ Exception -> 0x0050 }
            java.util.ArrayList r3 = r5.Y(r6, r3)     // Catch:{ Exception -> 0x0050 }
            if (r3 != 0) goto L_0x0053
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x0050 }
            r3.<init>()     // Catch:{ Exception -> 0x0050 }
            goto L_0x0053
        L_0x0050:
            r0 = move-exception
            goto L_0x01a6
        L_0x0053:
            net.imedicaldoctor.imd.Utils.iMDWebView r5 = r1.G4     // Catch:{ Exception -> 0x0050 }
            java.lang.String r6 = "highlighter.removeAllHighlights();"
            r5.g(r6)     // Catch:{ Exception -> 0x0050 }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ Exception -> 0x0050 }
            r5.<init>()     // Catch:{ Exception -> 0x0050 }
            java.lang.String r6 = "type:textContent"
            r5.add(r6)     // Catch:{ Exception -> 0x0050 }
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ Exception -> 0x0050 }
            r6.<init>()     // Catch:{ Exception -> 0x0050 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x0050 }
        L_0x006d:
            boolean r7 = r3.hasNext()     // Catch:{ Exception -> 0x0050 }
            r8 = 0
            if (r7 == 0) goto L_0x016d
            java.lang.Object r7 = r3.next()     // Catch:{ Exception -> 0x0050 }
            android.os.Bundle r7 = (android.os.Bundle) r7     // Catch:{ Exception -> 0x0050 }
            java.lang.String r9 = r7.getString(r2)     // Catch:{ Exception -> 0x0050 }
            int r9 = r9.length()     // Catch:{ Exception -> 0x0050 }
            if (r9 <= 0) goto L_0x006d
            java.lang.String r9 = r7.getString(r2)     // Catch:{ Exception -> 0x0050 }
            java.lang.String[] r10 = org.apache.commons.lang3.StringUtils.splitByWholeSeparator(r9, r4)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r11 = "type"
            java.lang.String r11 = r7.getString(r11)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r12 = ","
            java.lang.String[] r12 = org.apache.commons.lang3.StringUtils.splitByWholeSeparator(r11, r12)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r13 = "0"
            boolean r11 = r11.equals(r13)     // Catch:{ Exception -> 0x0050 }
            if (r11 != 0) goto L_0x011e
            int r11 = r12.length     // Catch:{ Exception -> 0x0050 }
            r13 = 2
            if (r11 >= r13) goto L_0x00a6
            goto L_0x011e
        L_0x00a6:
            r11 = 1
            r12 = r12[r11]     // Catch:{ Exception -> 0x0050 }
            java.lang.Long r12 = java.lang.Long.valueOf(r12)     // Catch:{ Exception -> 0x0050 }
            long r14 = r1.R4     // Catch:{ Exception -> 0x0050 }
            long r16 = r12.longValue()     // Catch:{ Exception -> 0x0050 }
            int r18 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r18 == 0) goto L_0x0142
            long r14 = r1.R4     // Catch:{ Exception -> 0x0050 }
            long r16 = r12.longValue()     // Catch:{ Exception -> 0x0050 }
            long r14 = r14 - r16
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0105 }
            r9.<init>()     // Catch:{ Exception -> 0x0105 }
            r8 = r10[r8]     // Catch:{ Exception -> 0x0105 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x0105 }
            int r8 = r8.intValue()     // Catch:{ Exception -> 0x0105 }
            long r11 = (long) r8     // Catch:{ Exception -> 0x0105 }
            long r11 = r11 + r14
            r9.append(r11)     // Catch:{ Exception -> 0x0105 }
            r9.append(r4)     // Catch:{ Exception -> 0x0105 }
            r8 = 1
            r8 = r10[r8]     // Catch:{ Exception -> 0x0105 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x0105 }
            int r8 = r8.intValue()     // Catch:{ Exception -> 0x0105 }
            long r11 = (long) r8     // Catch:{ Exception -> 0x0105 }
            long r11 = r11 + r14
            r9.append(r11)     // Catch:{ Exception -> 0x0105 }
            r9.append(r4)     // Catch:{ Exception -> 0x0105 }
            r8 = r10[r13]     // Catch:{ Exception -> 0x0105 }
            r9.append(r8)     // Catch:{ Exception -> 0x0105 }
            r9.append(r4)     // Catch:{ Exception -> 0x0105 }
            r8 = 3
            r8 = r10[r8]     // Catch:{ Exception -> 0x0105 }
            r9.append(r8)     // Catch:{ Exception -> 0x0105 }
            r9.append(r4)     // Catch:{ Exception -> 0x0105 }
            r8 = 4
            r8 = r10[r8]     // Catch:{ Exception -> 0x0105 }
            r9.append(r8)     // Catch:{ Exception -> 0x0105 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0105 }
            goto L_0x0142
        L_0x0105:
            java.lang.String r8 = "Highlighter"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0050 }
            r9.<init>()     // Catch:{ Exception -> 0x0050 }
            java.lang.String r11 = "Error in loading "
            r9.append(r11)     // Catch:{ Exception -> 0x0050 }
            r9.append(r10)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0050 }
            android.util.Log.e(r8, r9)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r9 = ""
            goto L_0x0142
        L_0x011e:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0050 }
            r8.<init>()     // Catch:{ Exception -> 0x0050 }
            java.lang.String r10 = "Update highlight set type='base,"
            r8.append(r10)     // Catch:{ Exception -> 0x0050 }
            long r10 = r1.R4     // Catch:{ Exception -> 0x0050 }
            r8.append(r10)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r10 = "' where rowid="
            r8.append(r10)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r10 = "_id"
            java.lang.String r10 = r7.getString(r10)     // Catch:{ Exception -> 0x0050 }
            r8.append(r10)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0050 }
            r6.add(r8)     // Catch:{ Exception -> 0x0050 }
        L_0x0142:
            r7.getString(r0)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r8 = "HighlightFixer"
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0050 }
            r10.<init>()     // Catch:{ Exception -> 0x0050 }
            r10.append(r9)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r11 = " --- "
            r10.append(r11)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r7 = r7.getString(r0)     // Catch:{ Exception -> 0x0050 }
            r10.append(r7)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r7 = r10.toString()     // Catch:{ Exception -> 0x0050 }
            android.util.Log.e(r8, r7)     // Catch:{ Exception -> 0x0050 }
            boolean r7 = r9.isEmpty()     // Catch:{ Exception -> 0x0050 }
            if (r7 != 0) goto L_0x006d
            r5.add(r9)     // Catch:{ Exception -> 0x0050 }
            goto L_0x006d
        L_0x016d:
            boolean r0 = r6.isEmpty()     // Catch:{ Exception -> 0x0050 }
            if (r0 != 0) goto L_0x0184
            net.imedicaldoctor.imd.Data.CompressHelper r0 = r1.Q4     // Catch:{ Exception -> 0x0050 }
            java.lang.String r2 = r19.I3()     // Catch:{ Exception -> 0x0050 }
            java.lang.String[] r3 = new java.lang.String[r8]     // Catch:{ Exception -> 0x0050 }
            java.lang.Object[] r3 = r6.toArray(r3)     // Catch:{ Exception -> 0x0050 }
            java.lang.String[] r3 = (java.lang.String[]) r3     // Catch:{ Exception -> 0x0050 }
            r0.r(r2, r3, r8)     // Catch:{ Exception -> 0x0050 }
        L_0x0184:
            java.lang.String r0 = "|"
            java.lang.String r0 = android.text.TextUtils.join(r0, r5)     // Catch:{ Exception -> 0x0050 }
            net.imedicaldoctor.imd.Utils.iMDWebView r2 = r1.G4     // Catch:{ Exception -> 0x0050 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0050 }
            r3.<init>()     // Catch:{ Exception -> 0x0050 }
            java.lang.String r4 = "highlighter.deserialize('"
            r3.append(r4)     // Catch:{ Exception -> 0x0050 }
            r3.append(r0)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r0 = "');"
            r3.append(r0)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x0050 }
            r2.g(r0)     // Catch:{ Exception -> 0x0050 }
            goto L_0x01c6
        L_0x01a6:
            com.google.firebase.crashlytics.FirebaseCrashlytics r2 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()
            r2.g(r0)
            r0.printStackTrace()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Error in loading highlights "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.String r2 = "ViewerActivity"
            net.imedicaldoctor.imd.iMDLogger.f(r2, r0)
        L_0x01c6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.ViewerHelperFragment.S3():void");
    }

    public void T2(final Runnable runnable, final Runnable runnable2) {
        final BeautifulProgressDialog beautifulProgressDialog = new BeautifulProgressDialog(r(), BeautifulProgressDialog.q, (String) null);
        beautifulProgressDialog.p("loading-1.json");
        beautifulProgressDialog.q(true);
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(500);
                    ViewerHelperFragment.this.C4.post(new Runnable() {
                        public void run() {
                            AnonymousClass24 r0 = AnonymousClass24.this;
                            if (!ViewerHelperFragment.this.h4) {
                                beautifulProgressDialog.w();
                            }
                        }
                    });
                } catch (InterruptedException unused) {
                }
            }
        }).start();
        Observable.w1(new ObservableOnSubscribe<String>() {
            public void a(@NonNull ObservableEmitter<String> observableEmitter) throws Throwable {
                try {
                    runnable.run();
                    observableEmitter.onNext("asdfadf");
                } catch (Exception e2) {
                    FirebaseCrashlytics.d().g(e2);
                    e2.printStackTrace();
                    ViewerHelperFragment.this.h4 = true;
                    beautifulProgressDialog.a();
                }
            }
        }).h6(Schedulers.e()).s4(AndroidSchedulers.e()).e6(new Consumer<String>() {
            /* renamed from: a */
            public void accept(String str) throws Throwable {
                ViewerHelperFragment.this.h4 = true;
                beautifulProgressDialog.a();
                try {
                    runnable2.run();
                } catch (Exception e2) {
                    FirebaseCrashlytics.d().g(e2);
                }
            }
        }, new Consumer<Throwable>() {
            /* renamed from: a */
            public void accept(Throwable th) throws Throwable {
                ViewerHelperFragment.this.h4 = true;
                beautifulProgressDialog.a();
                th.printStackTrace();
                FirebaseCrashlytics.d().g(th);
                runnable2.run();
            }
        });
    }

    public void T3(String str, String str2) {
        Bundle bundle = this.D4;
        String h1 = CompressHelper.h1(bundle, str + ".jpg", str2);
        if (!new File(h1).exists()) {
            String str3 = str2.equals("small") ? "small.db" : "01234567".contains(str.substring(0, 1)) ? "images-1.db" : "images-2.db";
            String g1 = CompressHelper.g1(this.D4, str2);
            if (!new File(g1).exists()) {
                new File(g1).mkdirs();
            }
            CompressHelper compressHelper = this.Q4;
            Bundle bundle2 = this.D4;
            Bundle n1 = compressHelper.n1(compressHelper.W(bundle2, "Select image from thumbs where id='" + str + "'", str3));
            if (n1 != null) {
                try {
                    CompressHelper.D2(new File(h1), n1.getByteArray("image"));
                } catch (Exception e2) {
                    FirebaseCrashlytics.d().g(e2);
                    iMDLogger.f("LoadImageIfnecessary", "Failed at writing to " + h1 + " loading image with id" + str + " in folder " + str2);
                }
            }
        }
    }

    public void U2() {
        JSONArray jSONArray = this.H4;
        if (jSONArray == null || jSONArray.length() == 0) {
            this.v4.setText("Nothing Found");
            this.t4.setEnabled(false);
            this.u4.setEnabled(false);
            return;
        }
        this.t4.setEnabled(true);
        this.u4.setEnabled(true);
        TextView textView = this.v4;
        textView.setText((this.n4 + 1) + " Of " + this.H4.length());
    }

    public void U3() {
        try {
            PopupWindow popupWindow = this.O4;
            if (popupWindow != null) {
                popupWindow.dismiss();
            }
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            e2.printStackTrace();
        }
    }

    public void V3() {
        iMDWebView imdwebview = this.G4;
        imdwebview.g("getRect(" + this.G4.getWidth() + "," + this.G4.getHeight() + ")");
    }

    public boolean W3(ConsoleMessage consoleMessage) {
        iMDLogger.f("Javascript Console Message", consoleMessage.message() + " - " + consoleMessage.sourceId() + " - " + consoleMessage.lineNumber());
        String[] split = consoleMessage.message().split(",,,,,");
        if (split[0].equals("baserange")) {
            this.R4 = Long.valueOf(split[1]).longValue();
            S3();
            if (y() == null || !y().containsKey("SEARCH")) {
                z3();
            }
        }
        if (split[0].equals("highlightAction")) {
            String str = split[1];
            String str2 = split[2];
            String s3 = s3();
            String str3 = this.F4;
            a3(s3, str3, "base," + this.R4, str, "", str2);
        } else if (split[0].equals("defineAction")) {
            if (split.length == 1) {
                iMDLogger.f("HelperFragment", "Dont have a word to define");
                return true;
            }
            o3(split[1]);
        } else if (split[0].equals("dehighlightAction")) {
            g4(split[1], this.E4);
        } else if (split[0].equals("copyAction")) {
            ((ClipboardManager) r().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("label", split[1]));
        } else if (split[0].equals("shareAction")) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            String str4 = split[1];
            intent.putExtra("android.intent.extra.SUBJECT", this.F4);
            intent.putExtra("android.intent.extra.TEXT", str4);
            D2(Intent.createChooser(intent, "Share via"));
        } else if (split[0].equals("saveAction")) {
            this.G4.g("window.getSelection().removeAllRanges();");
            String str5 = split[1];
            this.g4 = str5;
            this.m4.putString("mLastPosition", str5);
        } else if (split[0].equals(HTML.Tag.y)) {
            final String str6 = split[1];
            new AsyncTask() {

                /* renamed from: a  reason: collision with root package name */
                boolean f30011a;

                /* access modifiers changed from: protected */
                public Object doInBackground(Object[] objArr) {
                    this.f30011a = false;
                    Document document = new Document();
                    String M1 = ViewerHelperFragment.this.Q4.M1();
                    try {
                        Parser parser = new Parser();
                        StringWriter stringWriter = new StringWriter();
                        parser.setContentHandler(new XMLWriter((Writer) stringWriter));
                        parser.parse(new InputSource(new StringReader(Jsoup.c(str6, Whitelist.m()))));
                        String replaceAll = ViewerHelperFragment.this.F4.replaceAll("[\\W]", "_");
                        PdfWriter p1 = PdfWriter.p1(document, new FileOutputStream(M1 + "/" + replaceAll + ".pdf"));
                        document.open();
                        XMLWorkerHelper.e().o(p1, document, new StringReader(stringWriter.toString()));
                        document.close();
                        FragmentActivity r = ViewerHelperFragment.this.r();
                        MediaScannerConnection.scanFile(r, new String[]{M1 + "/" + replaceAll + ".pdf"}, (String[]) null, (MediaScannerConnection.OnScanCompletedListener) null);
                    } catch (Exception e2) {
                        FirebaseCrashlytics.d().g(e2);
                        this.f30011a = true;
                        String cls = getClass().toString();
                        iMDLogger.f(cls, "Error in converting to pdf :" + e2);
                    }
                    return null;
                }

                /* access modifiers changed from: protected */
                public void onPostExecute(Object obj) {
                    super.onPostExecute(obj);
                    ViewerHelperFragment.W4.M2();
                    extractingFragment unused = ViewerHelperFragment.W4 = null;
                    String M1 = ViewerHelperFragment.this.Q4.M1();
                    String replaceAll = ViewerHelperFragment.this.F4.replaceAll("[\\W]", "_");
                    Intent intent = new Intent("android.intent.action.VIEW");
                    File file = new File(M1 + "/" + replaceAll + ".pdf");
                    if (this.f30011a) {
                        CompressHelper.x2(ViewerHelperFragment.this.r(), "Error occured in making pdf document", 1);
                        if (file.exists()) {
                            file.delete();
                        }
                    }
                    if (file.exists()) {
                        intent.setDataAndType(Uri.fromFile(file), "application/pdf");
                        ViewerHelperFragment.this.D2(intent);
                    }
                }

                /* access modifiers changed from: protected */
                public void onPreExecute() {
                    extractingFragment unused = ViewerHelperFragment.W4 = new extractingFragment();
                    ViewerHelperFragment.W4.v2(true);
                    Bundle bundle = new Bundle();
                    bundle.putString("MESSAGE", "Generating PDF");
                    ViewerHelperFragment.W4.i2(bundle);
                    ViewerHelperFragment.W4.Z2(false);
                    ViewerHelperFragment.W4.e3(ViewerHelperFragment.this.M(), "extracting");
                }
            }.execute(new Object[0]);
        } else if (split[0].equals("findAction")) {
            String str7 = split[1];
            this.H4 = new JSONArray();
            try {
                this.H4 = new JSONArray(str7);
                H3(Boolean.valueOf(this.r4.getQuery().length() <= 0));
                this.H4.length();
                int i2 = this.n4;
                int i3 = this.o4;
                if (i2 < i3) {
                    this.n4 = i3;
                } else {
                    this.n4 = 0;
                }
                A3(this.n4);
            } catch (Exception e2) {
                FirebaseCrashlytics.d().g(e2);
                iMDLogger.f("Error in reading findAction Json", e2.toString());
                return false;
            }
        } else if (split[0].equals("coordinates")) {
            float f2 = b0().getDisplayMetrics().density;
            int intValue = Float.valueOf(split[1]).intValue();
            int intValue2 = Float.valueOf(split[2]).intValue();
            Float.valueOf(split[3]).intValue();
            Float.valueOf(split[4]).intValue();
            int[] iArr = new int[2];
            this.G4.getLocationInWindow(iArr);
            int i5 = ((int) (((float) intValue) * f2)) + iArr[0];
            int i6 = ((int) (((float) intValue2) * f2)) + iArr[1];
            int i7 = (int) (((float) 100) * f2);
            r();
            View inflate = ((LayoutInflater) r().getSystemService("layout_inflater")).inflate(R.layout.f1394popup_test, (ViewGroup) null, false);
            PopupWindow popupWindow = new PopupWindow(inflate, (int) (((float) 220) * f2), i7, false);
            this.O4 = popupWindow;
            popupWindow.setWindowLayoutMode(-2, -2);
            this.O4.setHeight(1);
            this.O4.setWidth(1);
            this.O4.showAtLocation(this.G4, 0, i5, i6 - i7);
            ((WhiteHighlightButton) inflate.findViewById(R.id.f972highlight_clear)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ViewerHelperFragment.this.G4.g("h=removeHighlightFromSelectedText()");
                    ViewerHelperFragment.this.G4.g("console.log('dehighlightAction,,,,,' + h.characterRange.start+'$'+h.characterRange.end+'$'+h.id+'$'+h.classApplier.cssClass+'$' );");
                    ViewerHelperFragment.this.u3();
                }
            });
            ((YellowHighlightButton) inflate.findViewById(R.id.f975highlight_yellow)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ViewerHelperFragment.this.G4.g("h=highlightSelectedTextWithClass(\"highlightYellow\")");
                    ViewerHelperFragment.this.G4.g("console.log('highlightAction,,,,,' + h.getText() + ',,,,,' + h.characterRange.start+'$'+h.characterRange.end+'$'+h.id+'$'+h.classApplier.cssClass+'$' );");
                    ViewerHelperFragment.this.u3();
                }
            });
            ((GreenHighlightButton) inflate.findViewById(R.id.f973highlight_green)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ViewerHelperFragment.this.G4.g("h=highlightSelectedTextWithClass(\"highlightGreen\")");
                    ViewerHelperFragment.this.G4.g("console.log('highlightAction,,,,,' + h.getText() + ',,,,,' + h.characterRange.start+'$'+h.characterRange.end+'$'+h.id+'$'+h.classApplier.cssClass+'$' );");
                    ViewerHelperFragment.this.u3();
                }
            });
            ((BlueHighlightButton) inflate.findViewById(R.id.f971highlight_blue)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ViewerHelperFragment.this.G4.g("h=highlightSelectedTextWithClass(\"highlightBlue\")");
                    ViewerHelperFragment.this.G4.g("console.log('highlightAction,,,,,' + h.getText() + ',,,,,' + h.characterRange.start+'$'+h.characterRange.end+'$'+h.id+'$'+h.classApplier.cssClass+'$' );");
                    ViewerHelperFragment.this.u3();
                }
            });
            ((RedHighlightButton) inflate.findViewById(R.id.f974highlight_red)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ViewerHelperFragment.this.G4.g("h=highlightSelectedTextWithClass(\"highlightRed\")");
                    ViewerHelperFragment.this.G4.g("console.log('highlightAction,,,,,' + h.getText() + ',,,,,' + h.characterRange.start+'$'+h.characterRange.end+'$'+h.id+'$'+h.classApplier.cssClass+'$' );");
                    ViewerHelperFragment.this.u3();
                }
            });
            ((TextView) inflate.findViewById(R.id.f911dictTv)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    iMDLogger.j(getClass().getName(), "Define Clicked");
                    ViewerHelperFragment.this.G4.g("console.log('defineAction,,,,,' + window.getSelection().toString())");
                    ViewerHelperFragment.this.u3();
                }
            });
            ((TextView) inflate.findViewById(R.id.f887copyTv)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ViewerHelperFragment.this.G4.g("console.log('copyAction,,,,,' + window.getSelection().toString())");
                    ViewerHelperFragment.this.u3();
                }
            });
            ((TextView) inflate.findViewById(R.id.f1020noteTv)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ViewerHelperFragment.this.G4.g("h=highlightSelectedTextWithClass(\"highlightNote\")");
                    ViewerHelperFragment.this.G4.g("console.log('highlightAction,,,,,' + h.getText() + ',,,,,' + h.characterRange.start+'$'+h.characterRange.end+'$'+h.id+'$'+h.classApplier.cssClass+'$' );");
                    ViewerHelperFragment.this.u3();
                }
            });
        } else if (split[0].equals("finisham")) {
            U3();
        }
        return true;
    }

    public void X0() {
        super.X0();
    }

    public boolean X3(WebView webView, String str, String str2, JsResult jsResult) {
        return false;
    }

    public void Y3(WebView webView, String str) {
    }

    public void Z2(String str, String str2) {
        String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(str2, "/");
        final String str3 = splitByWholeSeparator[splitByWholeSeparator.length - 1];
        final String str4 = this.D4.getString("Name") + " - " + this.E4;
        final downloadFragment downloadfragment = ((iMD) r().getApplicationContext()).c3;
        final CircleProgressView circleProgressView = (CircleProgressView) this.C4.findViewById(R.id.f1046progress_view);
        Bundle x3 = downloadfragment.x3(str4);
        if (x3 == null) {
            final String str5 = str;
            final String str6 = str2;
            new AlertDialog.Builder(r(), R.style.f2185alertDialogTheme).l("You don't have this video on your device, do you wish to download it ?").y("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    CompressHelper compressHelper = ViewerHelperFragment.this.Q4;
                    StringBuilder sb = new StringBuilder();
                    sb.append("fileSizes|||||");
                    String str = str5;
                    sb.append(str.replace(ViewerHelperFragment.this.Q4.getBaseUrl() + "/", ""));
                    compressHelper.o0(sb.toString()).h6(Schedulers.e()).s4(AndroidSchedulers.e()).f6(new Consumer<String>() {
                        /* renamed from: a */
                        public void accept(String str) throws Throwable {
                            String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(str, ";;;");
                            if (splitByWholeSeparator.length != 11) {
                                CompressHelper.x2(ViewerHelperFragment.this.r(), "Can't find file, please try again later", 1);
                                return;
                            }
                            circleProgressView.setVisibility(0);
                            AnonymousClass10 r0 = AnonymousClass10.this;
                            ViewerHelperFragment.this.S4 = str4;
                            ArrayList arrayList = new ArrayList();
                            arrayList.addAll(Arrays.asList(splitByWholeSeparator).subList(1, 11));
                            String join = StringUtils.join((Iterable<?>) arrayList, ",,,");
                            AnonymousClass10 r02 = AnonymousClass10.this;
                            downloadfragment.u3(ViewerHelperFragment.this.D4.getString("Title") + " - " + str3, str5, str6, splitByWholeSeparator[0], str3, str4, join);
                            AnonymousClass10 r13 = AnonymousClass10.this;
                            downloadfragment.U3(str4, circleProgressView);
                            AnonymousClass10 r132 = AnonymousClass10.this;
                            downloadfragment.R3(str4, ViewerHelperFragment.this.T4);
                            AnonymousClass10 r133 = AnonymousClass10.this;
                            downloadfragment.S3(str4, ViewerHelperFragment.this.U4);
                            AnonymousClass10 r134 = AnonymousClass10.this;
                            downloadfragment.Z3(str4);
                            CompressHelper.x2(ViewerHelperFragment.this.r(), "Download Started", 0);
                        }
                    }, new Consumer<Throwable>() {
                        /* renamed from: a */
                        public void accept(Throwable th) throws Throwable {
                            try {
                                th.printStackTrace();
                                CompressHelper.x2(ViewerHelperFragment.this.r(), "Error occured ", 0);
                            } catch (Exception e2) {
                                FirebaseCrashlytics.d().g(e2);
                            }
                        }
                    }, new Action() {
                        public void run() throws Throwable {
                        }
                    });
                }
            }).p("No", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                }
            }).I();
        } else if (x3.containsKey("downloader")) {
            CompressHelper.x2(r(), "We are downloading a file for this document, please be patient", 1);
        } else {
            circleProgressView.setVisibility(0);
            this.S4 = str4;
            downloadfragment.U3(str4, circleProgressView);
            downloadfragment.R3(str4, this.T4);
            downloadfragment.S3(str4, this.U4);
            downloadfragment.Z3(str4);
        }
    }

    public void Z3(WebView webView, String str) {
        SearchView searchView;
        if (this.k4) {
            this.k4 = false;
            String string = getActivity().getSharedPreferences("default_preferences", 0).getString("background_color", "#ffffff");
            if (!string.equals("#ffffff")) {
                this.G4.g("(function() { document.body.style.backgroundColor = '" + string + "'; })()");
            }
            String string2 = getActivity().getSharedPreferences("default_preferences", 0).getString("line_height", "Default");
            if (!string2.equals("Default")) {
                this.G4.g("(function() { document.body.style.lineHeight = '" + string2 + "'; })()");
            }
            if (y() != null && y().containsKey("SECTION")) {
                String string3 = y().getString("SECTION");
                if (string3.length() > 0) {
                    C3(string3);
                }
            }
            if (y() != null && y().containsKey("SEARCH")) {
                this.r4.k0(TextUtils.join(" OR ", y().getStringArray("SEARCH")), true);
                this.w4.setVisible(true);
                G3();
                y().remove("SEARCH");
            }
            if (this.g4 != null) {
                iMDLogger.j("viewhelper", "Restoring " + this.g4);
                this.G4.g("highlighter.removeAllHighlights();");
                iMDWebView imdwebview = this.G4;
                imdwebview.g("highlighter.deserialize('" + ("type:textContent|" + this.g4) + "');");
                this.G4.g("gotoHighlight('" + this.g4 + "');");
                this.G4.g("highlighter.removeAllHighlights();");
                this.G4.g("element=document.getElementById('orientation');element.parentNode.removeChild(element);");
                this.g4 = null;
            }
            String str2 = this.f4;
            if (!(str2 == null || str2.length() <= 0 || (searchView = this.r4) == null)) {
                searchView.k0(this.f4, true);
                this.f4 = null;
                this.r4.setIconified(false);
                this.r4.clearFocus();
            }
            this.G4.g("divs = document.getElementsByTagName('div');div=divs[0];range = document.createRange();range.setStart(div,0);range.setEnd(div,0);console.log('baserange,,,,,' + (new rangy.WrappedRange(range)).getBookmark(document.body).start);");
        }
    }

    public void a3(String str, String str2, String str3, String str4, String str5, String str6) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String a1 = this.Q4.a1(this.D4.getString("Name"));
        String a12 = this.Q4.a1(this.D4.getString("Title"));
        String a13 = this.Q4.a1(str);
        String a14 = this.Q4.a1(str2);
        String a15 = this.Q4.a1(str3);
        String a16 = this.Q4.a1(str4);
        String a17 = this.Q4.a1(str5);
        String a18 = this.Q4.a1(str6);
        String format = simpleDateFormat.format(new Date());
        CompressHelper compressHelper = this.Q4;
        String I3 = I3();
        compressHelper.q(I3, "Insert into highlight (dbName, dbTitle, dbAddress, dbDate, dbDocName, type, text, note, save) values ('" + a1 + "', '" + a12 + "', '" + a13 + "', '" + format + "', '" + a14 + "' , '" + a15 + "', '" + a16 + "', '" + a17 + "', '" + a18 + "')");
        if (a18.contains("highlightNote")) {
            D4(a18);
        }
    }

    public void a4(String str) {
        D2(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    public void b3(String str, String str2) {
    }

    public void b4(String str) {
        MediaPlayer.create(r(), Uri.fromFile(new File(str))).start();
    }

    public void c3() {
        try {
            String str = this.D4.getString("Name") + " - " + this.E4;
            downloadFragment downloadfragment = ((iMD) r().getApplicationContext()).c3;
            CircleProgressView circleProgressView = (CircleProgressView) this.C4.findViewById(R.id.f1046progress_view);
            Bundle x3 = downloadfragment.x3(str);
            if (x3 != null && x3.containsKey("downloader")) {
                circleProgressView.setVisibility(0);
                downloadfragment.U3(str, circleProgressView);
                downloadfragment.S3(str, this.U4);
                downloadfragment.R3(str, this.T4);
            }
        } catch (Exception unused) {
        }
    }

    public void c4(String str, String str2, String str3, final String str4) {
        Observable<byte[]> e2 = Decompress.e(str, str2);
        final File file = new File(str3);
        if (file.exists()) {
            b4(file.getAbsolutePath());
            file.deleteOnExit();
            return;
        }
        e2.h6(Schedulers.f()).s4(AndroidSchedulers.e()).d6(new Consumer<byte[]>() {
            /* renamed from: a */
            public void accept(byte[] bArr) throws Throwable {
                byte[] w = ViewerHelperFragment.this.Q4.w(bArr, str4, "127");
                try {
                    if (file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    CompressHelper.D2(file, w);
                } catch (Exception e2) {
                    FirebaseCrashlytics.d().g(e2);
                    iMDLogger.f("getSound", "Error in writing sound to " + file.getAbsolutePath() + " : " + e2);
                }
                file.deleteOnExit();
                ViewerHelperFragment.this.b4(file.getAbsolutePath());
            }
        });
    }

    public void d3() {
        try {
            this.x4.clearAllTabs();
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
        }
    }

    public String d4(Context context, String str) {
        if (context == null) {
            try {
                context = r();
            } catch (Exception e2) {
                FirebaseCrashlytics.d().g(e2);
                e2.printStackTrace();
                return "";
            }
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(str), StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                break;
            }
            sb.append(readLine + StringUtils.LF);
        }
        bufferedReader.close();
        String sb2 = sb.toString();
        if (context.getSharedPreferences("default_preferences", 0).getBoolean("defaultfont", false)) {
            sb2 = O2(sb2, C.o);
        }
        if (!context.getSharedPreferences("default_preferences", 0).getBoolean("justify", true)) {
            sb2 = i4(sb2);
        }
        String h42 = h4(sb2);
        return (!J3(context) || !h42.contains("</body>")) ? h42 : j4(h42, "</body>", "<script src=\"file:///android_asset/jquery.js\" ></script><script src=\"file:///android_asset/reverse1.js\" ></script><script src=\"file:///android_asset/reverse2.js\" ></script></body>");
    }

    public boolean e1(MenuItem menuItem) {
        int i2;
        int itemId = menuItem.getItemId();
        if (itemId == R.id.f942fix_highlight) {
            final EditText editText = new EditText(r());
            editText.setTextColor(b0().getColor(R.color.f140black));
            new AlertDialog.Builder(r(), R.style.f2185alertDialogTheme).l("Enter Offset for highlights").setView(editText).y("Only This Chapter", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    final long longValue = Long.valueOf(editText.getText().toString()).longValue();
                    ViewerHelperFragment.this.r3(new Runnable() {
                        public void run() {
                            Iterator<Bundle> it2;
                            try {
                                ArrayList arrayList = new ArrayList();
                                StringBuilder sb = new StringBuilder();
                                sb.append("select rowid as _id, dbName, dbTitle, dbAddress, dbDate, dbDocName, type, text, note, save from highlight where dbName='");
                                sb.append(ViewerHelperFragment.this.D4.getString("Name").replace("'", "''"));
                                sb.append("' AND dbAddress='");
                                ViewerHelperFragment viewerHelperFragment = ViewerHelperFragment.this;
                                sb.append(viewerHelperFragment.Q4.a1(viewerHelperFragment.s3()));
                                sb.append("'");
                                String sb2 = sb.toString();
                                ViewerHelperFragment viewerHelperFragment2 = ViewerHelperFragment.this;
                                ArrayList<Bundle> Y = viewerHelperFragment2.Q4.Y(viewerHelperFragment2.I3(), sb2);
                                if (Y == null) {
                                    ViewerHelperFragment.this.Q4.v2("There is no highlights in this document");
                                    return;
                                }
                                for (Iterator<Bundle> it3 = Y.iterator(); it3.hasNext(); it3 = it2) {
                                    Bundle next = it3.next();
                                    if (next.getString("save").length() > 0) {
                                        try {
                                            String string = next.getString("save");
                                            if (string.startsWith(",")) {
                                                string = string.substring(1);
                                            }
                                            String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(string, "$");
                                            StringBuilder sb3 = new StringBuilder();
                                            it2 = it3;
                                            try {
                                                sb3.append(((long) Integer.valueOf(splitByWholeSeparator[0]).intValue()) + longValue);
                                                sb3.append("$");
                                                sb3.append(((long) Integer.valueOf(splitByWholeSeparator[1]).intValue()) + longValue);
                                                sb3.append("$");
                                                sb3.append(splitByWholeSeparator[2]);
                                                sb3.append("$");
                                                sb3.append(splitByWholeSeparator[3]);
                                                sb3.append("$");
                                                sb3.append(splitByWholeSeparator[4]);
                                                String sb4 = sb3.toString();
                                                arrayList.add("Update highlight set save='" + sb4.replace("'", "''") + "' where rowid=" + next.getString("_id"));
                                            } catch (Exception e2) {
                                                e = e2;
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            it2 = it3;
                                            e.printStackTrace();
                                            iMDLogger.f("ViewerActivity", "Error in changing highlights " + e);
                                        }
                                    } else {
                                        it2 = it3;
                                    }
                                }
                                ViewerHelperFragment viewerHelperFragment3 = ViewerHelperFragment.this;
                                viewerHelperFragment3.Q4.r(viewerHelperFragment3.I3(), (String[]) arrayList.toArray(new String[0]), 0);
                            } catch (Exception e4) {
                                FirebaseCrashlytics.d().g(e4);
                                e4.printStackTrace();
                                iMDLogger.f("ViewerActivity", "Error in changing highlights " + e4);
                            }
                        }
                    }, new Runnable() {
                        public void run() {
                            ViewerHelperFragment.this.S3();
                            Toast.makeText(ViewerHelperFragment.this.r(), "Highlights Updated", 1);
                        }
                    });
                }
            }).p("All Documents of Database", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    ViewerHelperFragment.this.r3(new Runnable() {
                        public void run() {
                            Iterator<Bundle> it2;
                            try {
                                long longValue = Long.valueOf(editText.getText().toString()).longValue();
                                ArrayList arrayList = new ArrayList();
                                ViewerHelperFragment viewerHelperFragment = ViewerHelperFragment.this;
                                ArrayList<Bundle> Y = viewerHelperFragment.Q4.Y(viewerHelperFragment.I3(), "select rowid as _id, dbName, dbTitle, dbAddress, dbDate, dbDocName, type, text, note, save from highlight where dbName='" + ViewerHelperFragment.this.D4.getString("Name").replace("'", "''") + "'");
                                if (Y == null) {
                                    ViewerHelperFragment.this.Q4.v2("There is no highlights in this database");
                                    return;
                                }
                                for (Iterator<Bundle> it3 = Y.iterator(); it3.hasNext(); it3 = it2) {
                                    Bundle next = it3.next();
                                    if (next.getString("save").length() > 0) {
                                        try {
                                            String string = next.getString("save");
                                            if (string.startsWith(",")) {
                                                string = string.substring(1);
                                            }
                                            String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(string, "$");
                                            StringBuilder sb = new StringBuilder();
                                            it2 = it3;
                                            try {
                                                sb.append(((long) Integer.valueOf(splitByWholeSeparator[0]).intValue()) + longValue);
                                                sb.append("$");
                                                sb.append(((long) Integer.valueOf(splitByWholeSeparator[1]).intValue()) + longValue);
                                                sb.append("$");
                                                sb.append(splitByWholeSeparator[2]);
                                                sb.append("$");
                                                sb.append(splitByWholeSeparator[3]);
                                                sb.append("$");
                                                sb.append(splitByWholeSeparator[4]);
                                                String sb2 = sb.toString();
                                                arrayList.add("Update highlight set save='" + sb2.replace("'", "''") + "' where rowid=" + next.getString("_id"));
                                            } catch (Exception e2) {
                                                e = e2;
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            it2 = it3;
                                            e.printStackTrace();
                                            iMDLogger.f("ViewerActivity", "Error in changing highlights " + e);
                                        }
                                    } else {
                                        it2 = it3;
                                    }
                                }
                                ViewerHelperFragment viewerHelperFragment2 = ViewerHelperFragment.this;
                                viewerHelperFragment2.Q4.r(viewerHelperFragment2.I3(), (String[]) arrayList.toArray(new String[0]), 0);
                            } catch (Exception e4) {
                                e4.printStackTrace();
                                iMDLogger.f("ViewerActivity", "Error in changing highlights " + e4);
                            }
                        }
                    }, new Runnable() {
                        public void run() {
                            ViewerHelperFragment.this.S3();
                            Toast.makeText(ViewerHelperFragment.this.r(), "Highlights Updated", 1);
                        }
                    });
                }
            }).s("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                }
            }).I();
        }
        if (itemId == R.id.f1057remove_highlight) {
            new AlertDialog.Builder(r(), R.style.f2185alertDialogTheme).l("this will delete all the highlights.").y("From this document", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("delete from highlight where dbName='");
                    ViewerHelperFragment viewerHelperFragment = ViewerHelperFragment.this;
                    sb.append(viewerHelperFragment.Q4.a1(viewerHelperFragment.D4.getString("Name")));
                    sb.append("' AND dbAddress='");
                    ViewerHelperFragment viewerHelperFragment2 = ViewerHelperFragment.this;
                    sb.append(viewerHelperFragment2.Q4.a1(viewerHelperFragment2.s3()));
                    sb.append("'");
                    String sb2 = sb.toString();
                    ViewerHelperFragment viewerHelperFragment3 = ViewerHelperFragment.this;
                    viewerHelperFragment3.Q4.q(viewerHelperFragment3.I3(), sb2);
                    ViewerHelperFragment.this.S3();
                }
            }).p("From all documents of this database", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("delete from highlight where dbName='");
                    ViewerHelperFragment viewerHelperFragment = ViewerHelperFragment.this;
                    sb.append(viewerHelperFragment.Q4.a1(viewerHelperFragment.D4.getString("Name")));
                    sb.append("'");
                    String sb2 = sb.toString();
                    ViewerHelperFragment viewerHelperFragment2 = ViewerHelperFragment.this;
                    viewerHelperFragment2.Q4.q(viewerHelperFragment2.I3(), sb2);
                    ViewerHelperFragment.this.S3();
                }
            }).s("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                }
            }).I();
        }
        if (itemId == R.id.f800action_home) {
            if (y().containsKey("Dialog")) {
                try {
                    ((DialogFragment) U()).N2();
                } catch (Exception unused) {
                    try {
                        z().u().M(R.anim.f23to_fade_in, R.anim.f24to_fade_out).B(this).r();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            V().u().M(R.anim.f23to_fade_in, R.anim.f24to_fade_out).B(this).r();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            } else {
                this.Q4.Z1(false);
            }
        }
        if (itemId == R.id.f796action_favorites) {
            new Bundle();
            if (menuItem.getTitle().equals("Add Favorite")) {
                L2(this.F4, this.E4);
                menuItem.setTitle("Remove Favorite");
                i2 = R.drawable.F5;
            } else {
                p3(this.E4);
                menuItem.setTitle("Add Favorite");
                i2 = R.drawable.D5;
            }
            menuItem.setIcon(i2);
            return true;
        } else if (itemId == R.id.f811action_reload) {
            File file = new File(CompressHelper.g1(this.D4, "base"));
            this.G4.clearCache(true);
            this.G4.loadDataWithBaseURL("file://" + file.getAbsolutePath() + "/", this.A4, NanoHTTPD.p, "utf-8", (String) null);
            return true;
        } else {
            if (itemId == R.id.f793action_close) {
                this.r4.k0("", false);
                N2();
                if (!this.Q4.x1()) {
                    ActionBar F0 = ((AppCompatActivity) r()).F0();
                    if (F0 != null) {
                        F0.N();
                        F0.s0(0);
                    }
                } else {
                    d3();
                    TabHost tabHost = this.x4;
                    if (tabHost != null) {
                        tabHost.setVisibility(8);
                    }
                }
                this.w4.setVisible(false);
            }
            if (itemId == R.id.f1163zoom_in) {
                G4();
            }
            if (itemId == R.id.f1164zoom_out) {
                H4();
            }
            if (itemId == R.id.f804action_pdf) {
                if (this.D4.containsKey("Demo")) {
                    Toast.makeText(r(), "Can't make pdf in demo mode", 1).show();
                    return true;
                }
                try {
                    ((PrintManager) r().getSystemService("print")).print("iMD - " + this.D4.getString("Title") + " - " + this.F4, this.G4.createPrintDocumentAdapter("iMD - " + this.D4.getString("Title") + " - " + this.F4), new PrintAttributes.Builder().build());
                    return true;
                } catch (Exception e5) {
                    FirebaseCrashlytics.d().g(e5);
                    if (W4 == null) {
                        new AsyncTask() {

                            /* renamed from: a  reason: collision with root package name */
                            boolean f29990a;

                            /* access modifiers changed from: protected */
                            public Object doInBackground(Object[] objArr) {
                                this.f29990a = false;
                                Document document = new Document();
                                String M1 = ViewerHelperFragment.this.Q4.M1();
                                try {
                                    Parser parser = new Parser();
                                    StringWriter stringWriter = new StringWriter();
                                    parser.setContentHandler(new XMLWriter((Writer) stringWriter));
                                    parser.parse(new InputSource(new StringReader(Jsoup.c(ViewerHelperFragment.this.A4, Whitelist.m()))));
                                    String replaceAll = ViewerHelperFragment.this.F4.replaceAll("[\\W]", "_");
                                    PdfWriter p1 = PdfWriter.p1(document, new FileOutputStream(M1 + "/" + replaceAll + ".pdf"));
                                    document.open();
                                    XMLWorkerHelper.e().o(p1, document, new StringReader(stringWriter.toString()));
                                    document.close();
                                    FragmentActivity r = ViewerHelperFragment.this.r();
                                    MediaScannerConnection.scanFile(r, new String[]{M1 + "/" + replaceAll + ".pdf"}, (String[]) null, (MediaScannerConnection.OnScanCompletedListener) null);
                                } catch (Exception e2) {
                                    FirebaseCrashlytics.d().g(e2);
                                    this.f29990a = true;
                                    String cls = getClass().toString();
                                    iMDLogger.f(cls, "Error in converting to pdf :" + e2);
                                }
                                return null;
                            }

                            /* access modifiers changed from: protected */
                            public void onPostExecute(Object obj) {
                                super.onPostExecute(obj);
                                ViewerHelperFragment.W4.M2();
                                extractingFragment unused = ViewerHelperFragment.W4 = null;
                                String M1 = ViewerHelperFragment.this.Q4.M1();
                                String replaceAll = ViewerHelperFragment.this.F4.replaceAll("[\\W]", "_");
                                ViewerHelperFragment.this.Q4.u2(M1 + "/" + replaceAll + ".pdf", "application/pdf");
                            }

                            /* access modifiers changed from: protected */
                            public void onPreExecute() {
                                extractingFragment unused = ViewerHelperFragment.W4 = new extractingFragment();
                                ViewerHelperFragment.W4.v2(true);
                                Bundle bundle = new Bundle();
                                bundle.putString("MESSAGE", "Generating PDF");
                                ViewerHelperFragment.W4.i2(bundle);
                                ViewerHelperFragment.W4.Z2(false);
                                ViewerHelperFragment.W4.e3(ViewerHelperFragment.this.M(), "extracting");
                            }
                        }.execute(new Object[0]);
                    }
                }
            }
            return super.e1(menuItem);
        }
    }

    public void e3(Menu menu) {
    }

    public String e4() {
        return this.E4;
    }

    public void f3(int i2) {
        this.L4.setNavigationIcon((int) R.drawable.f539back_icon_small);
        this.L4.setNavigationOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ViewerHelperFragment.this.y().containsKey("Dialog")) {
                    try {
                        ViewerHelperFragment.this.z().u().M(R.anim.f23to_fade_in, R.anim.f24to_fade_out).B(ViewerHelperFragment.this).r();
                    } catch (Exception e2) {
                        FirebaseCrashlytics.d().g(e2);
                        e2.printStackTrace();
                        try {
                            ViewerHelperFragment.this.V().u().M(R.anim.f23to_fade_in, R.anim.f24to_fade_out).B(ViewerHelperFragment.this).r();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                } else {
                    ViewerHelperFragment.this.Q4.W1(false);
                }
            }
        });
        ImageButton imageButton = (ImageButton) this.C4.findViewById(R.id.f1010menu_button);
        if (imageButton != null) {
            if (this.Q4.x1()) {
                imageButton.setVisibility(0);
                imageButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        SlidingPaneLayout slidingPaneLayout = (SlidingPaneLayout) ViewerHelperFragment.this.r().findViewById(R.id.f1076sliding_layout);
                        if (slidingPaneLayout == null) {
                            return;
                        }
                        if (slidingPaneLayout.l()) {
                            slidingPaneLayout.c();
                        } else {
                            slidingPaneLayout.o();
                        }
                    }
                });
            } else {
                imageButton.setVisibility(8);
            }
        }
        if (this.F4 == null) {
            this.F4 = "Unknown";
        }
        this.L4.setTitle((CharSequence) this.F4);
        if (v4()) {
            M2();
        }
        try {
            CompressHelper compressHelper = this.Q4;
            String str = this.E4;
            String str2 = this.F4;
            compressHelper.H(str, str2, this.D4.getString("Name") + " --- " + this.D4.getString("Title"));
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
        }
        this.M4 = (ImageView) this.C4.findViewById(R.id.f1140toolbar_image_view);
        this.L4.getMenu().clear();
        this.L4.z(i2);
        final Menu menu = this.L4.getMenu();
        q4(menu);
        e3(menu);
        this.L4.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem menuItem) {
                ViewerHelperFragment.this.e1(menuItem);
                return true;
            }
        });
        o4();
        this.C4.postDelayed(new Runnable() {
            public void run() {
                MenuItem findItem;
                String str;
                if (menu.findItem(R.id.f796action_favorites) != null) {
                    ViewerHelperFragment viewerHelperFragment = ViewerHelperFragment.this;
                    if (viewerHelperFragment.K3(viewerHelperFragment.s3()).booleanValue()) {
                        menu.findItem(R.id.f796action_favorites).setIcon(R.drawable.F5);
                        findItem = menu.findItem(R.id.f796action_favorites);
                        str = "Remove Favorite";
                    } else {
                        menu.findItem(R.id.f796action_favorites).setIcon(R.drawable.D5);
                        findItem = menu.findItem(R.id.f796action_favorites);
                        str = "Add Favorite";
                    }
                    findItem.setTitle(str);
                }
            }
        }, 1000);
    }

    public String f4() {
        return this.F4;
    }

    public void g3() {
        u4();
        DrawerLayout drawerLayout = (DrawerLayout) this.C4.findViewById(R.id.f922drawer_layout);
        this.i4 = drawerLayout;
        if (drawerLayout != null) {
            drawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
                public void a(View view) {
                    ViewerHelperFragment viewerHelperFragment = ViewerHelperFragment.this;
                    viewerHelperFragment.j4.setAdapter(new HistoryAdapter(viewerHelperFragment.r(), ViewerHelperFragment.this.i4));
                }

                public void b(View view) {
                }

                public void c(int i2) {
                }

                public void d(View view, float f2) {
                }
            });
            RecyclerView recyclerView = (RecyclerView) this.C4.findViewById(R.id.f923drawer_view);
            this.j4 = recyclerView;
            if (recyclerView != null) {
                recyclerView.setLayoutManager(new LinearLayoutManager(r(), 1, false));
                this.j4.setItemDecoration(new CustomItemDecoration(r()));
            }
        }
    }

    public void g4(String str, String str2) {
        try {
            String a1 = this.Q4.a1(str);
            this.Q4.q(I3(), "delete from highlight where save match '" + a1 + "' AND rowid in (select rowid from highlight where dbName='" + this.Q4.a1(this.D4.getString("Name")) + "' AND dbAddress='" + this.Q4.a1(s3()) + "')");
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            e2.printStackTrace();
            iMDLogger.f("RemoveHighlight", "Error occured  " + str2);
        }
    }

    public void h3(String str) {
        BufferedSink d2;
        ArrayList arrayList = new ArrayList();
        arrayList.add("CharisSILB.ttf");
        arrayList.add("CharisSILBI.ttf");
        arrayList.add("CharisSILI.ttf");
        arrayList.add("CharisSILR.ttf");
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            String str2 = (String) arrayList.get(i2);
            String str3 = str + "/" + str2;
            if (!new File(str3).exists()) {
                try {
                    InputStream open = r().getAssets().open(str2);
                    d2 = Okio.d(Okio.n(new File(str3)));
                    d2.y1(Okio.u(open));
                    d2.close();
                } catch (Exception e2) {
                    FirebaseCrashlytics.d().g(e2);
                } catch (Throwable th) {
                    th.addSuppressed(th);
                }
            }
        }
        return;
        throw th;
    }

    public void j3(String str) {
        k3(str, "base");
    }

    public void k3(String str, String str2) {
        BufferedSink d2;
        String g1 = CompressHelper.g1(this.D4, str2);
        if (!new File(g1).exists()) {
            new File(g1).mkdirs();
        }
        File file = new File(g1 + '/' + str);
        if (file.exists()) {
            file.delete();
        }
        if (!file.exists()) {
            try {
                InputStream open = getActivity().getAssets().open(str);
                d2 = Okio.d(Okio.n(file));
                d2.y1(Okio.u(open));
                d2.close();
                return;
            } catch (Exception e2) {
                FirebaseCrashlytics.d().g(e2);
                iMDLogger.f("CopyJavascript", "Error in Copying " + str + " to " + g1 + "/" + str);
                return;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        } else {
            return;
        }
        throw th;
    }

    public void k4(String str) {
        try {
            String d4 = d4(r(), str);
            iMDWebView imdwebview = this.G4;
            imdwebview.g("" + d4);
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            iMDLogger.f("GetJavascript", "Can't read " + str);
        }
    }

    public void l1() {
        super.l1();
        G3();
        iMDWebView imdwebview = this.G4;
        if (imdwebview != null) {
            imdwebview.g("element=document.getElementById('orientation');element.parentNode.removeChild(element);");
        }
    }

    public void l3(final String str) {
        q3(new Runnable() {
            public void run() {
                InputStream open;
                BufferedSink d2;
                String g1 = CompressHelper.g1(ViewerHelperFragment.this.D4, "base");
                if (!new File(g1).exists()) {
                    new File(g1).mkdirs();
                }
                File file = new File(g1 + '/' + str);
                if (file.exists()) {
                    file.delete();
                }
                if (!file.exists()) {
                    try {
                        open = ViewerHelperFragment.this.r().getAssets().open(str);
                        d2 = Okio.d(Okio.n(file));
                        d2.y1(Okio.u(open));
                        d2.close();
                        if (open != null) {
                            open.close();
                            return;
                        }
                        return;
                    } catch (Exception e2) {
                        FirebaseCrashlytics.d().g(e2);
                        iMDLogger.f("CopyJavascript", "Error in Copying " + str + " to " + g1 + "/" + str);
                        return;
                    } catch (Throwable th) {
                        th.addSuppressed(th);
                    }
                } else {
                    return;
                }
                throw th;
                throw th;
            }
        }, new Runnable() {
            public void run() {
            }
        });
    }

    public void l4() {
        iMDLogger.d("sendFavorite", "Sending FavoriteChanged message");
        Intent intent = new Intent("net.imedicaldoctor.imd.favorite");
        intent.putExtra("Test", "Random data for test");
        LocalBroadcastManager.b(r()).d(intent);
    }

    public void m1(Bundle bundle) {
        super.m1(bundle);
    }

    public void m3() {
        n3("base");
    }

    public void m4(String str) {
        try {
            ((AppCompatActivity) r()).F0().A0(str);
        } catch (Exception unused) {
        }
    }

    public void n3(String str) {
        k3("log4javascript.js", str);
        k3("core.js", str);
        k3("dom.js", str);
        k3("domrange.js", str);
        k3("wrappedrange.js", str);
        k3("wrappedselection.js", str);
        k3("rangy-cssclassapplier.js", str);
        k3("rangy-highlighter.js", str);
        k3("hightlight.js", str);
        k3("find.js", str);
    }

    public void n4(String str) {
        ((CollapsingToolbarLayout) this.C4.findViewById(R.id.f882collapsing_toolbar)).setTitle(str);
    }

    public void o3(String str) {
        Bundle i1 = this.Q4.i1("Dictionary");
        if (i1 == null) {
            new AlertDialog.Builder(r(), R.style.f2185alertDialogTheme).l("Dictionary is not installed . you can download it from downloads page.").y("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                }
            }).p("Download Now", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    ViewerHelperFragment.this.Q4.Z1(true);
                    ((iMD) ViewerHelperFragment.this.r().getApplicationContext()).X2 = "\"Dictionary\"";
                }
            }).I();
            return;
        }
        CDicSearchActivity.CDicSearchFragment cDicSearchFragment = new CDicSearchActivity.CDicSearchFragment();
        Bundle bundle = new Bundle();
        bundle.putBundle("DB", i1);
        bundle.putString("Dialog", str);
        cDicSearchFragment.i2(bundle);
        cDicSearchFragment.Z2(true);
        cDicSearchFragment.e3(V(), "dictionaryDialog");
    }

    public void o4() {
        S2().h6(Schedulers.e()).s4(AndroidSchedulers.e()).d6(new Consumer<String>() {
            /* renamed from: a */
            public void accept(String str) throws Throwable {
                ImageView imageView = ViewerHelperFragment.this.M4;
                if (imageView != null) {
                    imageView.setImageDrawable((Drawable) null);
                    if (str != null && str.length() > 0) {
                        ViewerHelperFragment.this.M4.setVisibility(0);
                        File file = new File(str);
                        if (file.exists()) {
                            ViewerHelperFragment.this.M4.setImageURI(Uri.fromFile(file));
                        }
                    }
                }
            }
        });
    }

    public void p3(String str) {
        CompressHelper compressHelper = this.Q4;
        String X0 = compressHelper.X0();
        compressHelper.q(X0, "delete from favorites where dbName='" + this.Q4.a1(this.D4.getString("Name")) + "' AND dbAddress='" + this.Q4.a1(str) + "'");
        l4();
    }

    public void p4() {
        ImageButton imageButton = (ImageButton) this.C4.findViewById(R.id.f1041previous_button);
        ImageButton imageButton2 = (ImageButton) this.C4.findViewById(R.id.f1015next_button);
        this.u4 = imageButton2;
        this.t4 = imageButton;
        this.v4 = (TextView) this.C4.findViewById(R.id.f938find_status_label);
        imageButton.setEnabled(false);
        imageButton2.setEnabled(false);
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ViewerHelperFragment viewerHelperFragment = ViewerHelperFragment.this;
                int i2 = viewerHelperFragment.n4;
                ViewerHelperFragment.this.A3(i2 == 0 ? viewerHelperFragment.H4.length() - 1 : i2 - 1);
            }
        });
        imageButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ViewerHelperFragment viewerHelperFragment = ViewerHelperFragment.this;
                ViewerHelperFragment.this.A3(viewerHelperFragment.n4 == viewerHelperFragment.H4.length() + -1 ? 0 : ViewerHelperFragment.this.n4 + 1);
            }
        });
        ActionBar F0 = ((AppCompatActivity) r()).F0();
        if (F0 != null) {
            F0.m0(false);
        }
        if (this.Q4.x1()) {
            TabHost tabHost = this.x4;
            if (tabHost != null) {
                tabHost.setVisibility(8);
            }
        } else if (F0 != null) {
            F0.s0(0);
        }
    }

    public void q3(final Runnable runnable, final Runnable runnable2) {
        Observable.w1(new ObservableOnSubscribe<String>() {
            public void a(@NonNull ObservableEmitter<String> observableEmitter) throws Throwable {
                try {
                    runnable.run();
                    observableEmitter.onNext("asdfadf");
                } catch (Exception unused) {
                }
            }
        }).h6(Schedulers.e()).s4(AndroidSchedulers.e()).e6(new Consumer<String>() {
            /* renamed from: a */
            public void accept(String str) throws Throwable {
                try {
                    runnable2.run();
                } catch (Exception e2) {
                    FirebaseCrashlytics.d().g(e2);
                }
            }
        }, new Consumer<Throwable>() {
            /* renamed from: a */
            public void accept(Throwable th) throws Throwable {
                try {
                    iMDLogger.f("Error occured", th.getMessage());
                } catch (Exception e2) {
                    FirebaseCrashlytics.d().g(e2);
                }
            }
        });
    }

    public void q4(Menu menu) {
        MenuItem findItem;
        String str;
        this.s4 = menu;
        if (menu.findItem(R.id.f796action_favorites) != null) {
            if (K3(s3()).booleanValue()) {
                menu.findItem(R.id.f796action_favorites).setIcon(R.drawable.F5);
                findItem = menu.findItem(R.id.f796action_favorites);
                str = "Remove Favorite";
            } else {
                menu.findItem(R.id.f796action_favorites).setIcon(R.drawable.D5);
                findItem = menu.findItem(R.id.f796action_favorites);
                str = "Add Favorite";
            }
            findItem.setTitle(str);
        }
        menu.findItem(R.id.f1045progress_menu);
        if (menu.findItem(R.id.f797action_find) != null) {
            this.r4 = (SearchView) menu.findItem(R.id.f797action_find).getActionView();
            this.w4 = menu.findItem(R.id.f793action_close);
            this.r4.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                public boolean a(String str) {
                    return false;
                }

                public boolean b(String str) {
                    str.split(" OR ");
                    ViewerHelperFragment.this.t3(str);
                    ViewerHelperFragment.this.G3();
                    return true;
                }
            });
            this.r4.setOnCloseListener(new SearchView.OnCloseListener() {
                public boolean a() {
                    ViewerHelperFragment.this.N2();
                    if (ViewerHelperFragment.this.Q4.x1()) {
                        ViewerHelperFragment viewerHelperFragment = ViewerHelperFragment.this;
                        if (viewerHelperFragment.x4 != null) {
                            viewerHelperFragment.d3();
                            ViewerHelperFragment.this.x4.setVisibility(8);
                        }
                    } else if (((AppCompatActivity) ViewerHelperFragment.this.r()).F0() != null) {
                        ((AppCompatActivity) ViewerHelperFragment.this.r()).F0().N();
                        ((AppCompatActivity) ViewerHelperFragment.this.r()).F0().s0(0);
                    }
                    return false;
                }
            });
            this.s4 = menu;
            this.Q4.x1();
        }
    }

    public void r3(final Runnable runnable, final Runnable runnable2) {
        final BeautifulProgressDialog beautifulProgressDialog = new BeautifulProgressDialog(r(), BeautifulProgressDialog.q, (String) null);
        beautifulProgressDialog.p("loading-1.json");
        beautifulProgressDialog.q(true);
        beautifulProgressDialog.w();
        Observable.w1(new ObservableOnSubscribe<String>() {
            public void a(@NonNull ObservableEmitter<String> observableEmitter) throws Throwable {
                try {
                    runnable.run();
                    observableEmitter.onNext("asdfadf");
                } catch (Exception e2) {
                    FirebaseCrashlytics.d().g(e2);
                }
            }
        }).h6(Schedulers.e()).s4(AndroidSchedulers.e()).e6(new Consumer<String>() {
            /* renamed from: a */
            public void accept(String str) throws Throwable {
                beautifulProgressDialog.a();
                try {
                    runnable2.run();
                } catch (Exception e2) {
                    FirebaseCrashlytics.d().g(e2);
                }
            }
        }, new Consumer<Throwable>() {
            /* renamed from: a */
            public void accept(Throwable th) throws Throwable {
                beautifulProgressDialog.a();
            }
        });
    }

    public void r4(View view, Bundle bundle) {
        if (bundle != null && bundle.containsKey("Restoring")) {
            this.e4 = true;
            if (bundle.containsKey("Find")) {
                this.f4 = bundle.getString("Find");
                this.o4 = bundle.getInt("FindIndex");
            }
            if (bundle.containsKey("mFinalHTML")) {
                this.A4 = bundle.getString("mFinalHTML");
            }
            if (bundle.containsKey("mTitle")) {
                this.F4 = bundle.getString("mTitle");
            }
        }
        if (bundle != null && bundle.containsKey("mLastPosition")) {
            this.g4 = bundle.getString("mLastPosition");
        }
        this.C4 = view;
        this.G4 = (iMDWebView) view.findViewById(R.id.f1159webView);
        this.D4 = y().getBundle("DB");
        this.E4 = y().getString("URL");
        TabHost tabHost = (TabHost) view.findViewById(R.id.f939findtabhost);
        this.x4 = tabHost;
        if (tabHost != null) {
            tabHost.setup();
        }
        this.L4 = (Toolbar) this.C4.findViewById(R.id.f1139toolbar);
        this.P4 = (NestedScrollView) this.C4.findViewById(R.id.f1161webview_scrollview);
        g3();
        this.T4 = new Runnable() {
            public void run() {
                CompressHelper.x2(ViewerHelperFragment.this.r(), "Download Completed", 1);
                ViewerHelperFragment.this.F3();
            }
        };
        this.U4 = new Runnable() {
            public void run() {
                CompressHelper.x2(ViewerHelperFragment.this.r(), "Download failed", 1);
                ViewerHelperFragment.this.F3();
            }
        };
        if (!z4()) {
            ((AppBarLayout) this.C4.findViewById(R.id.f825appbar)).setExpanded(false);
        }
    }

    public void s(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        t3((String) tab.f());
    }

    public String s3() {
        return this.E4;
    }

    public void s4() {
        iMDWebView imdwebview = this.G4;
        imdwebview.j3 = this.D4.getString("type");
        imdwebview.getSettings().setAllowFileAccess(true);
        imdwebview.getSettings().setDomStorageEnabled(true);
        imdwebview.getSettings().setJavaScriptEnabled(true);
        imdwebview.getSettings().setAllowFileAccessFromFileURLs(true);
        imdwebview.getSettings().setAllowUniversalAccessFromFileURLs(true);
        imdwebview.setLayerType(2, (Paint) null);
        imdwebview.getSettings().setLoadWithOverviewMode(true);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("default_preferences", 0);
        WebSettings settings = imdwebview.getSettings();
        settings.setTextZoom(sharedPreferences.getInt(this.D4.getString("type") + "zoom", 100));
        imdwebview.setScrollbarFadingEnabled(true);
        imdwebview.setScrollBarStyle(16777216);
        imdwebview.setWebChromeClient(new WebChromeClient() {
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                return ViewerHelperFragment.this.W3(consoleMessage);
            }

            public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
                return ViewerHelperFragment.this.X3(webView, str, str2, jsResult);
            }
        });
        final View view = this.C4;
        imdwebview.setWebViewClient(new WebViewClient() {
            public void onLoadResource(WebView webView, String str) {
                iMDLogger.j("URL Requested", str);
                super.onLoadResource(webView, str);
            }

            public void onPageFinished(final WebView webView, final String str) {
                MenuItem menuItem = ViewerHelperFragment.this.J4;
                if (menuItem != null) {
                    menuItem.setVisible(false);
                }
                view.postDelayed(new Runnable() {
                    public void run() {
                        try {
                            ViewerHelperFragment.this.Z3(webView, str);
                        } catch (Exception e2) {
                            FirebaseCrashlytics.d().g(e2);
                        }
                    }
                }, 1000);
            }

            public void onPageStarted(WebView webView, final String str, Bitmap bitmap) {
                MenuItem menuItem = ViewerHelperFragment.this.J4;
                if (menuItem != null) {
                    menuItem.setVisible(true);
                    ViewerHelperFragment.this.q4.setIndeterminate(true);
                }
                ViewerHelperFragment viewerHelperFragment = ViewerHelperFragment.this;
                viewerHelperFragment.k4 = true;
                viewerHelperFragment.C4.postDelayed(new Runnable() {
                    public void run() {
                        ViewerHelperFragment viewerHelperFragment = ViewerHelperFragment.this;
                        if (viewerHelperFragment.k4) {
                            try {
                                viewerHelperFragment.Z3(viewerHelperFragment.G4, str);
                            } catch (Exception e2) {
                                FirebaseCrashlytics.d().g(e2);
                                e2.printStackTrace();
                            }
                        }
                    }
                }, ExoPlayer.a1);
                iMDLogger.j("URL Requested", str);
                super.onPageStarted(webView, str, bitmap);
            }

            public void onReceivedError(WebView webView, int i2, String str, String str2) {
                MenuItem menuItem = ViewerHelperFragment.this.J4;
                if (menuItem != null) {
                    menuItem.setVisible(false);
                }
                FragmentActivity r = ViewerHelperFragment.this.r();
                CompressHelper.x2(r, "Oh no! " + str, 0);
            }

            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                WebResourceResponse w4 = ViewerHelperFragment.this.w4(webView, webResourceRequest);
                return w4 != null ? w4 : super.shouldInterceptRequest(webView, webResourceRequest);
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                iMDLogger.j("URL Requested", str);
                Uri parse = Uri.parse(str);
                String scheme = parse.getScheme();
                String schemeSpecificPart = parse.getSchemeSpecificPart();
                if (!scheme.equals("note")) {
                    return ViewerHelperFragment.this.y4(webView, str, scheme, schemeSpecificPart);
                }
                ViewerHelperFragment.this.D4(schemeSpecificPart.replace("//", "").replace("soheilvbsoheilvbsoheilvb", "$"));
                return true;
            }

            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }

            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                WebResourceResponse x4 = ViewerHelperFragment.this.x4(webView, str);
                return x4 != null ? x4 : super.shouldInterceptRequest(webView, str);
            }
        });
        this.G4.g3 = new ActionModeResponse() {
            public void a() {
                ViewerHelperFragment.this.U3();
            }

            public void b() {
                ViewerHelperFragment.this.V3();
            }
        };
    }

    public void t3(String str) {
        String replace = str.replace(" OR ", "\",\"");
        this.G4.g("removeAllHighlights(\"aa\");");
        iMDWebView imdwebview = this.G4;
        imdwebview.g("console.log('findAction,,,,,' + highlightAllOccurencesOfString([\"" + replace + "\"],\"aa\"))");
    }

    public void t4() {
        iMDWebView imdwebview = this.G4;
        imdwebview.j3 = this.D4.getString("type");
        imdwebview.getSettings().setAllowFileAccess(true);
        imdwebview.getSettings().setDomStorageEnabled(true);
        imdwebview.getSettings().setJavaScriptEnabled(true);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("default_preferences", 0);
        WebSettings settings = imdwebview.getSettings();
        settings.setTextZoom(sharedPreferences.getInt(this.D4.getString("type") + "zoom", 100));
        imdwebview.getSettings().setSupportZoom(true);
        imdwebview.getSettings().setBuiltInZoomControls(true);
        imdwebview.getSettings().setDisplayZoomControls(false);
        imdwebview.setWebChromeClient(new WebChromeClient() {
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                return ViewerHelperFragment.this.W3(consoleMessage);
            }

            public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
                return ViewerHelperFragment.this.X3(webView, str, str2, jsResult);
            }
        });
        final View view = this.C4;
        imdwebview.setWebViewClient(new WebViewClient() {
            public void onLoadResource(WebView webView, String str) {
                iMDLogger.j("URL Requested", str);
                ViewerHelperFragment.this.Y3(webView, str);
                super.onLoadResource(webView, str);
            }

            public void onPageFinished(final WebView webView, final String str) {
                MenuItem menuItem = ViewerHelperFragment.this.J4;
                if (menuItem != null) {
                    menuItem.setVisible(false);
                }
                view.postDelayed(new Runnable() {
                    public void run() {
                        ViewerHelperFragment.this.Z3(webView, str);
                    }
                }, 1000);
            }

            public void onPageStarted(WebView webView, final String str, Bitmap bitmap) {
                MenuItem menuItem = ViewerHelperFragment.this.J4;
                if (menuItem != null) {
                    menuItem.setVisible(true);
                    ViewerHelperFragment.this.q4.setIndeterminate(true);
                }
                ViewerHelperFragment viewerHelperFragment = ViewerHelperFragment.this;
                viewerHelperFragment.k4 = true;
                viewerHelperFragment.C4.postDelayed(new Runnable() {
                    public void run() {
                        ViewerHelperFragment viewerHelperFragment = ViewerHelperFragment.this;
                        if (viewerHelperFragment.k4) {
                            try {
                                viewerHelperFragment.Z3(viewerHelperFragment.G4, str);
                            } catch (Exception e2) {
                                FirebaseCrashlytics.d().g(e2);
                                e2.printStackTrace();
                            }
                        }
                    }
                }, ExoPlayer.a1);
                iMDLogger.j("URL Requested", str);
                super.onPageStarted(webView, str, bitmap);
            }

            public void onReceivedError(WebView webView, int i2, String str, String str2) {
                MenuItem menuItem = ViewerHelperFragment.this.J4;
                if (menuItem != null) {
                    menuItem.setVisible(false);
                }
                FragmentActivity r = ViewerHelperFragment.this.r();
                CompressHelper.x2(r, "Oh no! " + str, 0);
            }

            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                WebResourceResponse w4 = ViewerHelperFragment.this.w4(webView, webResourceRequest);
                return w4 != null ? w4 : super.shouldInterceptRequest(webView, webResourceRequest);
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                iMDLogger.j("URL Requested", str);
                Uri parse = Uri.parse(str);
                String scheme = parse.getScheme();
                String schemeSpecificPart = parse.getSchemeSpecificPart();
                if (!scheme.equals("note")) {
                    return ViewerHelperFragment.this.y4(webView, str, scheme, schemeSpecificPart);
                }
                ViewerHelperFragment.this.D4(schemeSpecificPart.replace("//", "").replace("soheilvbsoheilvbsoheilvb", "$"));
                return true;
            }

            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                return super.shouldInterceptRequest(webView, str);
            }
        });
        this.G4.g3 = new ActionModeResponse() {
            public void a() {
                ViewerHelperFragment.this.U3();
            }

            public void b() {
                ViewerHelperFragment.this.V3();
            }
        };
    }

    public void u3() {
        this.G4.k();
        r().onActionModeFinished((ActionMode) null);
    }

    public void u4() {
        if (getActivity().getSharedPreferences("default_preferences", 0).getBoolean("HideStatusBar", false)) {
            float dimension = b0().getDimension(R.dimen.f522toolbar_padding);
            Toolbar toolbar = this.L4;
            if (toolbar != null) {
                toolbar.setPadding(0, (int) dimension, 0, 0);
            }
        }
    }

    public Bundle v3(ArrayList<Bundle> arrayList) {
        try {
            return arrayList.get(new Random().nextInt(arrayList.size()));
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            return null;
        }
    }

    public boolean v4() {
        return !y().containsKey("Dialog");
    }

    public String w3(ArrayList<String> arrayList) {
        if (arrayList != null) {
            try {
                if (arrayList.size() != 0) {
                    return arrayList.get(new Random().nextInt(arrayList.size()));
                }
            } catch (Exception e2) {
                FirebaseCrashlytics.d().g(e2);
            }
        }
        return null;
    }

    public WebResourceResponse w4(WebView webView, WebResourceRequest webResourceRequest) {
        return null;
    }

    public void x3(String str, String str2, String str3, final String str4) {
        final File file = new File(str3);
        if (file.exists()) {
            b4(file.getAbsolutePath());
            file.deleteOnExit();
            return;
        }
        Decompress.f(str, str2, new UnzipCompleted() {
            public void a(String str) {
                super.a(str);
            }

            public void b(byte[] bArr) {
                try {
                    CompressHelper.D2(file, ViewerHelperFragment.this.Q4.w(bArr, str4, "127"));
                } catch (Exception e2) {
                    FirebaseCrashlytics.d().g(e2);
                    iMDLogger.f("getSound", "Error in writing sound to " + file.getAbsolutePath() + " : " + e2);
                }
                file.deleteOnExit();
                ViewerHelperFragment.this.b4(file.getAbsolutePath());
            }
        });
    }

    public WebResourceResponse x4(WebView webView, String str) {
        return null;
    }

    public String y3(String str) {
        String F42 = F4();
        CompressHelper compressHelper = this.Q4;
        ArrayList<Bundle> Y = compressHelper.Y(F42, "Select id,content from temp where id ='" + str + "'");
        if (Y == null || Y.size() == 0) {
            return null;
        }
        return Y.get(0).getString(Annotation.i3);
    }

    public boolean y4(WebView webView, String str, String str2, String str3) {
        Log.e("Overriding", "Overriding");
        return true;
    }

    public void z3() {
        try {
            if (getActivity().getSharedPreferences("default_preferences", 0).getBoolean("lastred", false)) {
                CompressHelper compressHelper = this.Q4;
                Bundle s1 = compressHelper.s1(compressHelper.Y(I3(), "select save from highlight where dbName='" + this.D4.getString("Name").replace("'", "''") + "' AND dbAddress='" + this.Q4.a1(s3()) + "' AND save like '%$highlightRed$%'"));
                if (s1 != null) {
                    this.G4.loadUrl("javascript:gotoHighlight('" + s1.getString("save") + "');");
                }
            }
        } catch (Exception unused) {
        }
    }

    public boolean z4() {
        return B().getSharedPreferences("default_preferences", 0).getBoolean("NestedScroll", true);
    }
}
