package net.imedicaldoctor.imd.Data;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.FileProvider;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;
import com.google.common.net.HttpHeaders;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.messaging.FirebaseMessaging;
import com.itextpdf.text.Annotation;
import com.itextpdf.tool.xml.html.HTML;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.requery.android.database.sqlite.SQLiteDatabase;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.Inflater;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import kotlinx.coroutines.scheduling.WorkQueueKt;
import net.imedicaldoctor.imd.BuildConfig;
import net.imedicaldoctor.imd.Decompress;
import net.imedicaldoctor.imd.Fragments.AccessMedicine.AMChaptersActivity;
import net.imedicaldoctor.imd.Fragments.Amirsys.ASListActivity;
import net.imedicaldoctor.imd.Fragments.Amirsys.ASListActivityFragment;
import net.imedicaldoctor.imd.Fragments.CMEInfo.CMETOC;
import net.imedicaldoctor.imd.Fragments.CMEInfo.CMETOCFragment;
import net.imedicaldoctor.imd.Fragments.DRE.DREMainActivity;
import net.imedicaldoctor.imd.Fragments.DRE.DREMainActivityFragment;
import net.imedicaldoctor.imd.Fragments.Dictionary.CDicSearchActivity;
import net.imedicaldoctor.imd.Fragments.EPUB.EPUBChaptersActivity;
import net.imedicaldoctor.imd.Fragments.EPUB.EPUBChaptersActivityFragment;
import net.imedicaldoctor.imd.Fragments.Elsevier.ELSChaptersActivity;
import net.imedicaldoctor.imd.Fragments.Epocrate.EPOLabListActivity;
import net.imedicaldoctor.imd.Fragments.Epocrate.EPOLabListActivityFragment;
import net.imedicaldoctor.imd.Fragments.Epocrate.EPOMainActivity;
import net.imedicaldoctor.imd.Fragments.Epocrate.EPOMainActivityFragment;
import net.imedicaldoctor.imd.Fragments.Facts.FTListActivity;
import net.imedicaldoctor.imd.Fragments.Facts.FTListActivityFragment;
import net.imedicaldoctor.imd.Fragments.IranDaru.IDSearchActivity;
import net.imedicaldoctor.imd.Fragments.IranGenericDrugs.IranGenericDrugsList;
import net.imedicaldoctor.imd.Fragments.IranGenericDrugs.IranGenericDrugsListFragment;
import net.imedicaldoctor.imd.Fragments.LWW.LWWChapters;
import net.imedicaldoctor.imd.Fragments.LWW.LWWChaptersFragment;
import net.imedicaldoctor.imd.Fragments.Lexi.LXItems;
import net.imedicaldoctor.imd.Fragments.LexiInteract.LXInteractList;
import net.imedicaldoctor.imd.Fragments.LexiInteract.LXIvInteract;
import net.imedicaldoctor.imd.Fragments.Martindale.MDListActivity;
import net.imedicaldoctor.imd.Fragments.Martindale.MDListActivityFragment;
import net.imedicaldoctor.imd.Fragments.Medhand.MHSearchActivity;
import net.imedicaldoctor.imd.Fragments.Micromedex.MMIVSelectActivity;
import net.imedicaldoctor.imd.Fragments.Micromedex.MMIVSelectActivityFragment;
import net.imedicaldoctor.imd.Fragments.Micromedex.MMInteractSelectActivity;
import net.imedicaldoctor.imd.Fragments.Micromedex.MMInteractSelectActivityFragment;
import net.imedicaldoctor.imd.Fragments.Micromedex.MMListActivity;
import net.imedicaldoctor.imd.Fragments.Micromedex.MMListActivityFragment;
import net.imedicaldoctor.imd.Fragments.Micromedex.MMNeoListActivity;
import net.imedicaldoctor.imd.Fragments.Micromedex.MMNeoListActivityFragment;
import net.imedicaldoctor.imd.Fragments.NEJM.NEJMTOCActivity;
import net.imedicaldoctor.imd.Fragments.Noskheha.NOSListActivity;
import net.imedicaldoctor.imd.Fragments.Noskheha.NOSListActivityFragment;
import net.imedicaldoctor.imd.Fragments.OVID.OvidChaptersActivity;
import net.imedicaldoctor.imd.Fragments.Sanford.SANTocActivity;
import net.imedicaldoctor.imd.Fragments.Sanford.SANTocActivityFragment;
import net.imedicaldoctor.imd.Fragments.Skyscape.SSSearchActivity;
import net.imedicaldoctor.imd.Fragments.Statdx.SDListActivity;
import net.imedicaldoctor.imd.Fragments.Statdx.SDListActivityFragment;
import net.imedicaldoctor.imd.Fragments.Stockley.STListActivity;
import net.imedicaldoctor.imd.Fragments.Stockley.STListActivityFragment;
import net.imedicaldoctor.imd.Fragments.TOL.PsychoListActivity;
import net.imedicaldoctor.imd.Fragments.TOL.PsychoListActivityFragment;
import net.imedicaldoctor.imd.Fragments.UTDAdvanced.UTDASearchActivity;
import net.imedicaldoctor.imd.Fragments.UTDAdvanced.UTDASearchActivityFragment;
import net.imedicaldoctor.imd.Fragments.UWorld.UWMainActivity;
import net.imedicaldoctor.imd.Fragments.UWorld.UWMainActivityFragment;
import net.imedicaldoctor.imd.Fragments.Uptodate.UTDSearchActivity;
import net.imedicaldoctor.imd.Fragments.UptodateDDX.UTDDSearchActivity;
import net.imedicaldoctor.imd.Fragments.VisualDDX.VDDxScenarioActivity;
import net.imedicaldoctor.imd.Fragments.VisualDXLookup.VDSearchActivity;
import net.imedicaldoctor.imd.Fragments.mainActivity;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Utils.MaterialRippleLayout;
import net.imedicaldoctor.imd.VBHelper;
import net.imedicaldoctor.imd.iMD;
import net.imedicaldoctor.imd.iMDLogger;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class CompressHelper {

    /* renamed from: h  reason: collision with root package name */
    public static final String f29538h = "fileSize";

    /* renamed from: i  reason: collision with root package name */
    public static final String f29539i = "MD5";

    /* renamed from: j  reason: collision with root package name */
    public static final String f29540j = "bytesDownloaded";

    /* renamed from: k  reason: collision with root package name */
    public static final String f29541k = "bytesTotal";

    /* renamed from: l  reason: collision with root package name */
    public static final String f29542l = "avgSpeed";

    /* renamed from: m  reason: collision with root package name */
    public static final String f29543m = "remaining";

    /* renamed from: n  reason: collision with root package name */
    public static final String f29544n = "downloader";
    public static MediaPlayer o = null;
    public static ArrayList<String> p = null;
    public static final String q = ",visualdx.png,uptodate.png,irandarou.png,";
    public static Fragment r = null;
    public static HashMap<String, Stack<Fragment>> s = null;
    public static ArrayList<Bundle> t = null;
    private static final Logger u = Logger.getLogger(CompressHelper.class.toString());
    public static final String v = "master";
    public static final String w = "detail";
    public static boolean x;

    /* renamed from: a  reason: collision with root package name */
    public Bundle f29545a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<File> f29546b;

    /* renamed from: c  reason: collision with root package name */
    public String f29547c;

    /* renamed from: d  reason: collision with root package name */
    public Context f29548d;

    /* renamed from: e  reason: collision with root package name */
    public Bundle f29549e;

    /* renamed from: f  reason: collision with root package name */
    public VBHelper f29550f;

    /* renamed from: g  reason: collision with root package name */
    private final OkHttpClient f29551g = new OkHttpClient();

    public CompressHelper(Context context) {
        if (s == null) {
            HashMap<String, Stack<Fragment>> hashMap = new HashMap<>();
            s = hashMap;
            hashMap.put(v, new Stack());
            s.put(w, new Stack());
        }
        this.f29548d = context;
        this.f29550f = new VBHelper(context);
        this.f29545a = new Bundle();
    }

    /* access modifiers changed from: private */
    public boolean A2(String str, String str2, Bundle bundle) throws IOException {
        File file;
        if (!new File(str).exists()) {
            return false;
        }
        long longValue = Long.valueOf(bundle.getString("fileSize", "0")).longValue();
        if (longValue == 0 && this.f29545a.containsKey(str)) {
            longValue = this.f29545a.getLong(str);
        }
        if (new File(str).length() == longValue || longValue == 0) {
            String string = bundle.getString("MD5", "");
            if (string.isEmpty() && new File(str2).exists()) {
                string = f2(str2);
            }
            if (string.equalsIgnoreCase(P1(new File(str)).replace(StringUtils.LF, "")) || string.isEmpty()) {
                return true;
            }
            file = new File(str);
        } else {
            file = new File(str);
        }
        file.delete();
        bundle.putDouble("bytesDownloaded", 0.0d);
        return false;
    }

    /* access modifiers changed from: private */
    public void B2(String str, String str2, String str3, Bundle bundle) throws IOException {
        File file;
        BufferedSink d2;
        BufferedSink d3;
        String string = bundle.getString("MD5", "");
        if (string.isEmpty() && new File(str3).exists()) {
            string = f2(str3);
        }
        if (string.isEmpty()) {
            BufferedSource e2 = Okio.e(Okio.t(new File(str)));
            try {
                d2 = Okio.d(Okio.n(new File(str2)));
                d2.y1(e2);
                d2.close();
                if (e2 != null) {
                    e2.close();
                }
                file = new File(str);
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        } else if (string.equalsIgnoreCase(P1(new File(str)).replace(StringUtils.LF, ""))) {
            BufferedSource e3 = Okio.e(Okio.t(new File(str)));
            try {
                d3 = Okio.d(Okio.n(new File(str2)));
                d3.y1(e3);
                d3.close();
                if (e3 != null) {
                    e3.close();
                }
                file = new File(str);
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        } else {
            new File(str).delete();
            bundle.putDouble("bytesDownloaded", 0.0d);
            throw new IOException("MD5 checksum mismatch. Downloading again");
        }
        file.delete();
        return;
        throw th;
        throw th;
        throw th;
        throw th;
    }

    public static String C(Bundle bundle) {
        try {
            String string = bundle.getString("IconName");
            if (q.contains("," + string + ",")) {
                return "file:///android_asset/" + string;
            }
            return bundle.getString("Path") + "/" + string;
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            return "file:///android_asset/placeholder.png";
        }
    }

    public static boolean C1(View view) {
        if (view instanceof CardView) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                if (C1(viewGroup.getChildAt(i2))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String D(Bundle bundle) {
        String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(bundle.getString("dbIcon"), "/");
        String str = splitByWholeSeparator[splitByWholeSeparator.length - 1];
        if (!q.contains("," + str + ",")) {
            return bundle.getString("dbIcon");
        }
        return "file:///android_asset/" + str;
    }

    public static boolean D1(View view) {
        if (view instanceof MaterialRippleLayout) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                if (D1(viewGroup.getChildAt(i2))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void D2(File file, byte[] bArr) throws IOException {
        BufferedSink d2 = Okio.d(Okio.n(file));
        try {
            d2.write(bArr);
            d2.close();
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public static void E2(File file, String str) throws IOException {
        BufferedSink d2 = Okio.d(Okio.n(file));
        try {
            d2.W0(str);
            d2.flush();
            d2.close();
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public static byte[] F0(byte[] bArr) throws IOException {
        Deflater deflater = new Deflater();
        deflater.setLevel(-1);
        deflater.setInput(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        deflater.finish();
        byte[] bArr2 = new byte[5120];
        while (!deflater.finished()) {
            byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
        }
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static String F1(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b2 : digest) {
                String hexString = Integer.toHexString(b2 & 255);
                while (hexString.length() < 2) {
                    hexString = "0" + hexString;
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String G0(String str) throws IOException {
        if (str == null || str.length() == 0) {
            return str;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(str.getBytes("UTF-8"));
        gZIPOutputStream.close();
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }

    /* access modifiers changed from: private */
    public boolean H1(Bundle bundle) {
        return bundle.containsKey("downloader") && bundle.getBundle("downloader").containsKey("Go");
    }

    public static String I1(ArrayList<Bundle> arrayList, String str) {
        return J1(arrayList, str, ",", "", "");
    }

    public static String J1(ArrayList<Bundle> arrayList, String str, String str2, String str3, String str4) {
        ArrayList arrayList2 = new ArrayList();
        Iterator<Bundle> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(str3 + it2.next().getString(str) + str4);
        }
        return TextUtils.join(str2, arrayList2);
    }

    public static String K1(String str) {
        ArrayList arrayList = new ArrayList(Arrays.asList(StringUtils.splitByWholeSeparator(str, "/")));
        return (String) arrayList.get(arrayList.size() - 1);
    }

    public static byte[] L0(byte[] bArr) throws IOException, DataFormatException {
        Inflater inflater = new Inflater();
        inflater.setInput(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        byte[] bArr2 = new byte[1024];
        while (!inflater.finished()) {
            byteArrayOutputStream.write(bArr2, 0, inflater.inflate(bArr2));
        }
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static String M0(String str) throws IOException {
        if (str == null || str.length() == 0) {
            return str;
        }
        GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(Base64.decode(str, 0)));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = gZIPInputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toString("UTF-8");
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static String O1(String str, int i2) {
        if (str.length() <= i2) {
            return str;
        }
        return str.substring(0, i2 - 1) + "...";
    }

    public static boolean P0(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    P0(file2);
                } else {
                    file2.delete();
                }
            }
        }
        return file.delete();
    }

    public static void Q0(Context context, String str, String str2, String str3) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.b(false);
            builder.y("اطلاعات بیشتر", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                }
            });
            builder.p("باشه", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                }
            });
            builder.setTitle(str);
            builder.l(str2);
            AlertDialog create = builder.create();
            ((TextView) create.findViewById(16908299)).setTypeface(ResourcesCompat.j(context, R.font.f782iransans));
            create.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean Q1(File file, File file2) {
        Source t2;
        Sink n2;
        if (!file.exists()) {
            return false;
        }
        file2.getParentFile().mkdirs();
        try {
            t2 = Okio.t(file);
            n2 = Okio.n(file2);
            Okio.d(n2).y1(t2);
            if (n2 != null) {
                n2.close();
            }
            if (t2 != null) {
                t2.close();
            }
            return file.delete();
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
        throw th;
    }

    public static boolean R1(String str, String str2) {
        Source t2;
        Sink n2;
        File file = new File(str);
        File file2 = new File(str2);
        if (!file.exists()) {
            return false;
        }
        file2.getParentFile().mkdirs();
        try {
            t2 = Okio.t(file);
            n2 = Okio.n(file2);
            Okio.d(n2).y1(t2);
            if (n2 != null) {
                n2.close();
            }
            if (t2 != null) {
                t2.close();
            }
            return file.delete();
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
        throw th;
    }

    public static void V1(Context context, String str) {
        try {
            MediaPlayer mediaPlayer = o;
            if (mediaPlayer != null) {
                mediaPlayer.release();
                o = null;
            }
            if (o == null) {
                o = new MediaPlayer();
            }
            if (o.isPlaying()) {
                o.stop();
            }
            AssetFileDescriptor openFd = context.getAssets().openFd(str);
            o.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
            openFd.close();
            o.prepare();
            o.setVolume(1.0f, 1.0f);
            o.setLooping(false);
            o.start();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static int b(ArrayList<Bundle> arrayList, Bundle bundle, String str) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (arrayList.get(i2).getString(str).equals(bundle.getString(str))) {
                return i2;
            }
        }
        return -1;
    }

    public static String c1(String str) {
        try {
            return (str.length() == 6 ? new SimpleDateFormat("MMM, yyyy") : new SimpleDateFormat("MMM d, yyyy")).format((str.length() == 6 ? new SimpleDateFormat("yyyyMM") : new SimpleDateFormat("yyyyMMdd")).parse(str));
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            return str;
        }
    }

    public static byte[] d1(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(bArr);
        gZIPOutputStream.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return byteArray;
    }

    public static byte[] d2(File file) throws IOException {
        BufferedSource e2 = Okio.e(Okio.t(file));
        try {
            byte[] b0 = e2.b0();
            e2.close();
            return b0;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public static byte[] e1(byte[] bArr) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream, 32);
        byte[] bArr2 = new byte[32];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        while (true) {
            int read = gZIPInputStream.read(bArr2);
            if (read != -1) {
                byteArrayOutputStream.write(bArr2, 0, read);
            } else {
                gZIPInputStream.close();
                byteArrayInputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static String e2(File file) throws IOException {
        BufferedSource e2 = Okio.e(Okio.t(file));
        try {
            String a2 = e2.a2();
            e2.close();
            return a2;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public static String f(String str, String str2, String str3) {
        if (!str.contains(str2) || !str.contains(str3)) {
            return null;
        }
        String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(str, str2);
        return StringUtils.splitByWholeSeparator(splitByWholeSeparator[splitByWholeSeparator.length - 1], str3)[0];
    }

    public static String f1(Bundle bundle) {
        return bundle.getString("Path") + "/" + bundle.getString("Name");
    }

    public static String g1(Bundle bundle, String str) {
        return bundle.getString("Path") + "/" + str;
    }

    public static String h1(Bundle bundle, String str, String str2) {
        return bundle.getString("Path") + "/" + str2 + "/" + str;
    }

    public static String j2(String str) {
        ArrayList arrayList = new ArrayList(Arrays.asList(StringUtils.splitByWholeSeparator(str, "/")));
        arrayList.remove(arrayList.size() - 1);
        return StringUtils.join((Iterable<?>) arrayList, "/");
    }

    /* access modifiers changed from: private */
    public long k1(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.length();
        }
        return 0;
    }

    public static HashSet<String> l1() {
        HashSet<String> hashSet = new HashSet<>();
        String str = "";
        try {
            Process start = new ProcessBuilder(new String[0]).command(new String[]{"mount"}).redirectErrorStream(true).start();
            start.waitFor();
            InputStream inputStream = start.getInputStream();
            byte[] bArr = new byte[1024];
            while (inputStream.read(bArr) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        for (String str2 : str.split(StringUtils.LF)) {
            if (!str2.toLowerCase(Locale.US).contains("asec") && str2.matches("(?i).*vold.*(vfat|ntfs|exfat|fat32|ext3|ext4).*rw.*")) {
                for (String str3 : str2.split(StringUtils.SPACE)) {
                    if (str3.startsWith("/") && !str3.toLowerCase(Locale.US).contains("vold")) {
                        hashSet.add(str3);
                    }
                }
            }
        }
        return hashSet;
    }

    /* access modifiers changed from: private */
    public long m1(String str) throws IOException {
        Response execute = new OkHttpClient().a(new Request.Builder().q(str).g().b()).execute();
        try {
            if (execute.r()) {
                long parseLong = Long.parseLong(execute.i(HttpHeaders.f22874b));
                execute.close();
                return parseLong;
            }
            execute.close();
            return -1;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public static Bundle q1(ArrayList<Bundle> arrayList, final String str, final String str2) {
        ArrayList arrayList2 = new ArrayList(Collections2.d(arrayList, new Predicate<Bundle>() {
            /* renamed from: a */
            public boolean apply(Bundle bundle) {
                try {
                    return bundle.getString(str).equals(str2);
                } catch (Exception e2) {
                    FirebaseCrashlytics.d().g(e2);
                    iMDLogger.f("Error in filtering", e2.getLocalizedMessage());
                    return false;
                }
            }
        }));
        if (arrayList2.size() == 0) {
            return null;
        }
        return (Bundle) arrayList2.get(0);
    }

    public static String u1(Bundle bundle, String str) {
        return bundle.getString("Path") + "/" + str;
    }

    public static String v1() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        int nextInt = random.nextInt(20);
        for (int i2 = 0; i2 < nextInt; i2++) {
            sb.append((char) (random.nextInt(96) + 32));
        }
        return sb.toString();
    }

    public static void x2(Context context, String str, int i2) {
        if (context != null) {
            try {
                Toast.makeText(context, str, i2).show();
            } catch (Exception e2) {
                FirebaseCrashlytics.d().g(e2);
                FirebaseCrashlytics.d().g(e2);
                iMDLogger.f("Error", "Error in showtoast");
                e2.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public String z2(String str) throws MalformedURLException {
        if (str.startsWith("http://") || str.startsWith("https://")) {
            return str;
        }
        throw new MalformedURLException("Invalid URL scheme. URL should start with 'http://' or 'https://'");
    }

    public String A() {
        String str = "";
        try {
            str = U1() + "/spell.db";
            if (!new File(str).exists()) {
                InputStream open = this.f29548d.getAssets().open("spell.db");
                FileOutputStream fileOutputStream = new FileOutputStream(str);
                byte[] bArr = new byte[1048576];
                while (true) {
                    int read = open.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.flush();
                fileOutputStream.close();
                open.close();
            }
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            iMDLogger.f(CompressHelper.class.toString(), e2.getMessage());
        }
        return str;
    }

    public void A0(String str, String str2, String str3, String str4) {
        String a1 = a1(str);
        String a12 = a1(str2);
        String a13 = a1(str4);
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String h2 = h2();
        q(h2, "Insert into recent (dbName, dbTitle, dbAddress, dbDate, dbDocName) values ('" + a1.replace("'", "''") + "', '" + a12.replace("'", "''") + "', '" + str3.replace("'", "''") + "', '" + format + "', '" + a13.replace("'", "''") + "')");
    }

    public void A1(Bundle bundle, String str, String[] strArr, String str2) {
        B1(bundle, str, strArr, str2, (Bundle) null);
    }

    public String B(String str, String str2, String str3) {
        String str4;
        if (!str3.equals("127")) {
            return null;
        }
        VBHelper vBHelper = this.f29550f;
        String str5 = TextUtils.split(vBHelper.x(vBHelper.m()).replace("||", "::"), "::")[1];
        byte[] decode = Base64.decode(str, 0);
        for (int length = str2.length(); length < 8; length++) {
            str2 = str2 + StringUtils.SPACE;
        }
        try {
            try {
                return new String(e1(N0(str5.toCharArray(), str2.getBytes(StandardCharsets.UTF_8), new byte[]{17, 115, 105, 102, 103, 104, 111, 107, 108, 122, 120, 119, 118, 98, 110, 109}, decode)));
            } catch (Exception e2) {
                e = e2;
                str4 = "CompressHelper _ GetString Decompressing";
                iMDLogger.f(str4, e.toString());
                return null;
            }
        } catch (Exception e3) {
            e = e3;
            str4 = "CompressHelper _ GetString Decryption";
            iMDLogger.f(str4, e.toString());
            return null;
        }
    }

    public void B0(String str, String str2, String str3) {
        String a1 = a1(str);
        String a12 = a1(str2);
        String a13 = a1(str3);
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String h2 = h2();
        q(h2, "Insert into dbrecent (dbName, dbTitle, dbDate, dbIcon) values ('" + a1 + "', '" + a12 + "', '" + format + "', '" + a13 + "')");
    }

    /* JADX WARNING: Removed duplicated region for block: B:230:0x0623  */
    /* JADX WARNING: Removed duplicated region for block: B:233:0x062c  */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x063c  */
    /* JADX WARNING: Removed duplicated region for block: B:474:0x0bc6  */
    /* JADX WARNING: Removed duplicated region for block: B:477:0x0bcf  */
    /* JADX WARNING: Removed duplicated region for block: B:480:0x0bdf  */
    /* JADX WARNING: Removed duplicated region for block: B:485:0x0c10  */
    /* JADX WARNING: Removed duplicated region for block: B:489:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void B1(android.os.Bundle r25, java.lang.String r26, java.lang.String[] r27, java.lang.String r28, android.os.Bundle r29) {
        /*
            r24 = this;
            r6 = r24
            r0 = r25
            r1 = r26
            r2 = r27
            r3 = r28
            r4 = r29
            android.content.Context r5 = r6.f29548d
            android.app.Activity r5 = (android.app.Activity) r5
            boolean r5 = r24.x1()
            java.lang.String r7 = "-"
            java.lang.String[] r7 = r1.split(r7)
            java.lang.String r8 = "Type"
            java.lang.String r9 = r0.getString(r8)
            java.lang.String r10 = "uptodate"
            java.lang.String r11 = "nejm"
            java.lang.String r12 = "elseviernew"
            java.lang.String r13 = "elsevier"
            java.lang.String r15 = "mDB"
            java.lang.String r14 = "testresult"
            java.lang.String r4 = "test"
            java.lang.String r0 = "menu"
            java.lang.String r3 = ",,,"
            r16 = r8
            java.lang.String r8 = ""
            r17 = r15
            java.lang.String r15 = " "
            java.lang.String r2 = "default_preferences"
            r18 = r2
            java.lang.String r2 = "interactresult"
            r19 = r14
            java.lang.String r14 = "doc"
            r20 = r4
            java.lang.String r4 = "html"
            r21 = r2
            java.lang.String r2 = "URL"
            if (r5 != 0) goto L_0x0653
            boolean r5 = r9.equals(r13)
            if (r5 != 0) goto L_0x005a
            boolean r5 = r9.equals(r12)
            if (r5 == 0) goto L_0x005e
        L_0x005a:
            r3 = r27
            goto L_0x0616
        L_0x005e:
            boolean r5 = r9.equals(r11)
            if (r5 == 0) goto L_0x0074
            android.content.Intent r14 = new android.content.Intent
            android.content.Context r0 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.NEJM.NEJMViewerActivity> r3 = net.imedicaldoctor.imd.Fragments.NEJM.NEJMViewerActivity.class
            r14.<init>(r0, r3)
        L_0x006d:
            r14.putExtra(r2, r1)
        L_0x0070:
            r3 = r27
            goto L_0x0621
        L_0x0074:
            boolean r5 = r9.equals(r10)
            java.lang.Class<net.imedicaldoctor.imd.Fragments.AccessMedicine.AMHTMLViewer> r10 = net.imedicaldoctor.imd.Fragments.AccessMedicine.AMHTMLViewer.class
            if (r5 == 0) goto L_0x00e8
            r5 = 0
            r0 = r7[r5]
            java.lang.String r0 = r0.replace(r15, r8)
            java.lang.String r3 = "Graphic"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x00c6
            android.content.Intent r14 = new android.content.Intent
            android.content.Context r0 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity> r1 = net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity.class
            r14.<init>(r0, r1)
            r0 = 1
            r0 = r7[r0]
            java.lang.String r1 = ",,,,"
            java.lang.String[] r0 = r0.split(r1)
            java.lang.String r1 = "IDS"
            r14.putExtra(r1, r0)
            int r0 = r7.length
            r1 = 4
            if (r0 != r1) goto L_0x0070
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 2
            r1 = r7[r1]
            java.lang.String r2 = ","
            java.lang.String[] r1 = org.apache.commons.lang3.StringUtils.splitByWholeSeparator(r1, r2)
            java.util.List r1 = java.util.Arrays.asList(r1)
            r0.<init>(r1)
            java.lang.String r1 = "AllGraphics"
            r14.putExtra(r1, r0)
            r0 = 3
            r0 = r7[r0]
            java.lang.String r1 = "GraphicIndex"
            r14.putExtra(r1, r0)
            goto L_0x0070
        L_0x00c6:
            r0 = 0
            r0 = r7[r0]
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x00de
            java.lang.String r0 = r24.F2(r25, r26)
            android.content.Intent r14 = new android.content.Intent
            android.content.Context r1 = r6.f29548d
            r14.<init>(r1, r10)
        L_0x00da:
            r14.putExtra(r2, r0)
            goto L_0x0070
        L_0x00de:
            android.content.Intent r14 = new android.content.Intent
            android.content.Context r0 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.Uptodate.UTDViewerActivity> r3 = net.imedicaldoctor.imd.Fragments.Uptodate.UTDViewerActivity.class
            r14.<init>(r0, r3)
            goto L_0x006d
        L_0x00e8:
            java.lang.String r5 = "utdadvanced"
            boolean r5 = r9.equals(r5)
            if (r5 == 0) goto L_0x0113
            r5 = 0
            r0 = r7[r5]
            java.lang.String r0 = r0.replace(r15, r8)
            java.lang.String r3 = "pathway"
            boolean r0 = r0.equals(r3)
            android.content.Intent r14 = new android.content.Intent
            if (r0 == 0) goto L_0x010a
            android.content.Context r0 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.UTDAdvanced.UTDAViewerActivity> r3 = net.imedicaldoctor.imd.Fragments.UTDAdvanced.UTDAViewerActivity.class
            r14.<init>(r0, r3)
            goto L_0x006d
        L_0x010a:
            android.content.Context r0 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.Uptodate.UTDViewerActivity> r3 = net.imedicaldoctor.imd.Fragments.Uptodate.UTDViewerActivity.class
            r14.<init>(r0, r3)
            goto L_0x006d
        L_0x0113:
            java.lang.String r5 = "accessmedicine"
            boolean r5 = r9.equals(r5)
            if (r5 == 0) goto L_0x013d
            r5 = 0
            r0 = r7[r5]
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0131
            java.lang.String r0 = r24.F2(r25, r26)
            android.content.Intent r1 = new android.content.Intent
            android.content.Context r3 = r6.f29548d
            r1.<init>(r3, r10)
            r14 = r1
            goto L_0x00da
        L_0x0131:
            android.content.Intent r0 = new android.content.Intent
            android.content.Context r3 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.AccessMedicine.AMViewerActivity> r4 = net.imedicaldoctor.imd.Fragments.AccessMedicine.AMViewerActivity.class
            r0.<init>(r3, r4)
            r14 = r0
            r0 = r1
            goto L_0x00da
        L_0x013d:
            java.lang.String r5 = "lww"
            boolean r5 = r9.equals(r5)
            if (r5 == 0) goto L_0x0150
            android.content.Intent r14 = new android.content.Intent
            android.content.Context r0 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.LWW.LWWViewer> r3 = net.imedicaldoctor.imd.Fragments.LWW.LWWViewer.class
            r14.<init>(r0, r3)
            goto L_0x006d
        L_0x0150:
            java.lang.String r5 = "skyscape"
            boolean r5 = r9.equals(r5)
            if (r5 == 0) goto L_0x0163
            android.content.Intent r14 = new android.content.Intent
            android.content.Context r0 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.Skyscape.SSViewerActivity> r3 = net.imedicaldoctor.imd.Fragments.Skyscape.SSViewerActivity.class
            r14.<init>(r0, r3)
            goto L_0x006d
        L_0x0163:
            java.lang.String r5 = "ovid"
            boolean r5 = r9.equals(r5)
            if (r5 == 0) goto L_0x0176
            android.content.Intent r14 = new android.content.Intent
            android.content.Context r0 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.OVID.OvidViewerActivity> r3 = net.imedicaldoctor.imd.Fragments.OVID.OvidViewerActivity.class
            r14.<init>(r0, r3)
            goto L_0x006d
        L_0x0176:
            java.lang.String r5 = "irandarou"
            boolean r5 = r9.equals(r5)
            if (r5 == 0) goto L_0x0189
            android.content.Intent r14 = new android.content.Intent
            android.content.Context r0 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity> r3 = net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity.class
            r14.<init>(r0, r3)
            goto L_0x006d
        L_0x0189:
            java.lang.String r5 = "uptodateddx"
            boolean r5 = r9.equals(r5)
            if (r5 == 0) goto L_0x019c
            android.content.Intent r14 = new android.content.Intent
            android.content.Context r0 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.UptodateDDX.UTDDViewerActivity> r3 = net.imedicaldoctor.imd.Fragments.UptodateDDX.UTDDViewerActivity.class
            r14.<init>(r0, r3)
            goto L_0x006d
        L_0x019c:
            java.lang.String r5 = "visualdxddx"
            boolean r5 = r9.equals(r5)
            if (r5 == 0) goto L_0x01c3
            r5 = 0
            r0 = r7[r5]
            java.lang.String r3 = "ddx"
            boolean r0 = r0.equals(r3)
            android.content.Intent r14 = new android.content.Intent
            if (r0 == 0) goto L_0x01ba
            android.content.Context r0 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.VisualDXLookup.VDDxResults> r3 = net.imedicaldoctor.imd.Fragments.VisualDXLookup.VDDxResults.class
            r14.<init>(r0, r3)
            goto L_0x006d
        L_0x01ba:
            android.content.Context r0 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.VisualDDX.VDDxBuilderActivity> r3 = net.imedicaldoctor.imd.Fragments.VisualDDX.VDDxBuilderActivity.class
            r14.<init>(r0, r3)
            goto L_0x006d
        L_0x01c3:
            java.lang.String r5 = "visualdx"
            boolean r5 = r9.equals(r5)
            if (r5 == 0) goto L_0x01ea
            r5 = 0
            r0 = r7[r5]
            java.lang.String r3 = "Doc"
            boolean r0 = r0.equals(r3)
            android.content.Intent r14 = new android.content.Intent
            if (r0 == 0) goto L_0x01e1
            android.content.Context r0 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.VisualDXLookup.VDViewerActivity> r3 = net.imedicaldoctor.imd.Fragments.VisualDXLookup.VDViewerActivity.class
            r14.<init>(r0, r3)
            goto L_0x006d
        L_0x01e1:
            android.content.Context r0 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.VisualDXLookup.VDDiagnosisActivity> r3 = net.imedicaldoctor.imd.Fragments.VisualDXLookup.VDDiagnosisActivity.class
            r14.<init>(r0, r3)
            goto L_0x006d
        L_0x01ea:
            java.lang.String r5 = "Dictionary"
            boolean r5 = r9.equals(r5)
            if (r5 == 0) goto L_0x0234
            r5 = 0
            r0 = r7[r5]
            java.lang.String r3 = "EP"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0208
            android.content.Intent r14 = new android.content.Intent
            android.content.Context r0 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.Dictionary.CDicEPActivity> r3 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEPActivity.class
            r14.<init>(r0, r3)
            goto L_0x006d
        L_0x0208:
            r0 = r7[r5]
            java.lang.String r3 = "EE"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x021d
            android.content.Intent r14 = new android.content.Intent
            android.content.Context r0 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity> r3 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity.class
            r14.<init>(r0, r3)
            goto L_0x006d
        L_0x021d:
            r0 = r7[r5]
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0230
            android.content.Intent r14 = new android.content.Intent
            android.content.Context r0 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.Dictionary.CDicSimpleWebViewer> r3 = net.imedicaldoctor.imd.Fragments.Dictionary.CDicSimpleWebViewer.class
            r14.<init>(r0, r3)
            goto L_0x006d
        L_0x0230:
            r3 = r27
            goto L_0x0605
        L_0x0234:
            java.lang.String r5 = "medhand"
            boolean r5 = r9.equals(r5)
            if (r5 == 0) goto L_0x0247
            android.content.Intent r14 = new android.content.Intent
            android.content.Context r0 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.Medhand.MHViewerActivity> r3 = net.imedicaldoctor.imd.Fragments.Medhand.MHViewerActivity.class
            r14.<init>(r0, r3)
            goto L_0x006d
        L_0x0247:
            java.lang.String r5 = "epub"
            boolean r5 = r9.equals(r5)
            if (r5 == 0) goto L_0x025a
            android.content.Intent r14 = new android.content.Intent
            android.content.Context r0 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.EPUB.EPUBViewerActivity> r3 = net.imedicaldoctor.imd.Fragments.EPUB.EPUBViewerActivity.class
            r14.<init>(r0, r3)
            goto L_0x006d
        L_0x025a:
            java.lang.String r5 = "amirsys"
            boolean r5 = r9.equals(r5)
            if (r5 == 0) goto L_0x0290
            java.lang.String[] r3 = org.apache.commons.lang3.StringUtils.splitByWholeSeparator(r1, r3)
            r4 = 0
            r5 = r3[r4]
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x027a
            android.content.Intent r14 = new android.content.Intent
            android.content.Context r0 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.Amirsys.ASMenuActivity> r3 = net.imedicaldoctor.imd.Fragments.Amirsys.ASMenuActivity.class
            r14.<init>(r0, r3)
            goto L_0x006d
        L_0x027a:
            r0 = r3[r4]
            boolean r0 = r0.equals(r14)
            if (r0 == 0) goto L_0x028d
            android.content.Intent r14 = new android.content.Intent
            android.content.Context r0 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.Amirsys.ASDocActivity> r3 = net.imedicaldoctor.imd.Fragments.Amirsys.ASDocActivity.class
            r14.<init>(r0, r3)
            goto L_0x006d
        L_0x028d:
            r14 = 0
            goto L_0x006d
        L_0x0290:
            java.lang.String r5 = "statdx"
            boolean r5 = r9.equals(r5)
            if (r5 == 0) goto L_0x02d8
            java.lang.String[] r3 = org.apache.commons.lang3.StringUtils.splitByWholeSeparator(r1, r3)
            r4 = 0
            r5 = r3[r4]
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x02b0
            android.content.Intent r14 = new android.content.Intent
            android.content.Context r0 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.Statdx.SDMenuActivity> r3 = net.imedicaldoctor.imd.Fragments.Statdx.SDMenuActivity.class
            r14.<init>(r0, r3)
            goto L_0x006d
        L_0x02b0:
            r0 = r3[r4]
            boolean r0 = r0.equals(r14)
            if (r0 == 0) goto L_0x02c3
            android.content.Intent r14 = new android.content.Intent
            android.content.Context r0 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.Statdx.SDDocActivity> r3 = net.imedicaldoctor.imd.Fragments.Statdx.SDDocActivity.class
            r14.<init>(r0, r3)
            goto L_0x006d
        L_0x02c3:
            r0 = r3[r4]
            java.lang.String r3 = "case"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x028d
            android.content.Intent r14 = new android.content.Intent
            android.content.Context r0 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.Statdx.SDCaseActivity> r3 = net.imedicaldoctor.imd.Fragments.Statdx.SDCaseActivity.class
            r14.<init>(r0, r3)
            goto L_0x006d
        L_0x02d8:
            java.lang.String r0 = "martindale"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x02eb
            android.content.Intent r14 = new android.content.Intent
            android.content.Context r0 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.Martindale.MDViewerActivity> r3 = net.imedicaldoctor.imd.Fragments.Martindale.MDViewerActivity.class
            r14.<init>(r0, r3)
            goto L_0x006d
        L_0x02eb:
            java.lang.String r0 = "facts"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x02fe
            android.content.Intent r14 = new android.content.Intent
            android.content.Context r0 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.Facts.FTViewerActivity> r3 = net.imedicaldoctor.imd.Fragments.Facts.FTViewerActivity.class
            r14.<init>(r0, r3)
            goto L_0x006d
        L_0x02fe:
            java.lang.String r0 = "micromedex-drug"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0311
            android.content.Intent r14 = new android.content.Intent
            android.content.Context r0 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.Micromedex.MMViewerActivity> r3 = net.imedicaldoctor.imd.Fragments.Micromedex.MMViewerActivity.class
            r14.<init>(r0, r3)
            goto L_0x006d
        L_0x0311:
            java.lang.String r0 = "micromedex-neofax"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0324
            android.content.Intent r14 = new android.content.Intent
            android.content.Context r0 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.Micromedex.MMNeoViewerActivity> r3 = net.imedicaldoctor.imd.Fragments.Micromedex.MMNeoViewerActivity.class
            r14.<init>(r0, r3)
            goto L_0x006d
        L_0x0324:
            java.lang.String r0 = "micromedex-interact"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0355
            r0 = 0
            r3 = r7[r0]
            r5 = r21
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0342
            android.content.Intent r14 = new android.content.Intent
            android.content.Context r0 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.Micromedex.MMInteractResultActivity> r3 = net.imedicaldoctor.imd.Fragments.Micromedex.MMInteractResultActivity.class
            r14.<init>(r0, r3)
            goto L_0x006d
        L_0x0342:
            r0 = r7[r0]
            boolean r0 = r0.equals(r14)
            if (r0 == 0) goto L_0x028d
            android.content.Intent r14 = new android.content.Intent
            android.content.Context r0 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.Micromedex.MMInteractViewerActivity> r3 = net.imedicaldoctor.imd.Fragments.Micromedex.MMInteractViewerActivity.class
            r14.<init>(r0, r3)
            goto L_0x006d
        L_0x0355:
            r5 = r21
            java.lang.String r0 = "micromedex-iv"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0386
            r0 = 0
            r3 = r7[r0]
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0373
            android.content.Intent r14 = new android.content.Intent
            android.content.Context r0 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.Micromedex.MMIVResultActivity> r3 = net.imedicaldoctor.imd.Fragments.Micromedex.MMIVResultActivity.class
            r14.<init>(r0, r3)
            goto L_0x006d
        L_0x0373:
            r0 = r7[r0]
            boolean r0 = r0.equals(r14)
            if (r0 == 0) goto L_0x028d
            android.content.Intent r14 = new android.content.Intent
            android.content.Context r0 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.Micromedex.MMIVViewerActivity> r3 = net.imedicaldoctor.imd.Fragments.Micromedex.MMIVViewerActivity.class
            r14.<init>(r0, r3)
            goto L_0x006d
        L_0x0386:
            java.lang.String r0 = "sanford"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0399
            android.content.Intent r14 = new android.content.Intent
            android.content.Context r0 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.Sanford.SANViewerActivity> r3 = net.imedicaldoctor.imd.Fragments.Sanford.SANViewerActivity.class
            r14.<init>(r0, r3)
            goto L_0x006d
        L_0x0399:
            java.lang.String r0 = "tol"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x0614
            java.lang.String r0 = "noskhe"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x03b4
            android.content.Intent r14 = new android.content.Intent
            android.content.Context r0 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.Noskheha.NOSViewerActivity> r3 = net.imedicaldoctor.imd.Fragments.Noskheha.NOSViewerActivity.class
            r14.<init>(r0, r3)
            goto L_0x006d
        L_0x03b4:
            java.lang.String r0 = "stockley"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x03c7
            android.content.Intent r14 = new android.content.Intent
            android.content.Context r0 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.Stockley.STViewerActivity> r3 = net.imedicaldoctor.imd.Fragments.Stockley.STViewerActivity.class
            r14.<init>(r0, r3)
            goto L_0x006d
        L_0x03c7:
            java.lang.String r0 = "mksap"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x03da
            android.content.Intent r14 = new android.content.Intent
            android.content.Context r0 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.mksap.MKSAPActivity> r3 = net.imedicaldoctor.imd.Fragments.mksap.MKSAPActivity.class
            r14.<init>(r0, r3)
            goto L_0x006d
        L_0x03da:
            java.lang.String r0 = "uworld"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0442
            r0 = 0
            r3 = r7[r0]
            r8 = r20
            boolean r3 = r3.equals(r8)
            if (r3 == 0) goto L_0x03f9
            android.content.Intent r0 = new android.content.Intent
            android.content.Context r3 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivity> r4 = net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivity.class
            r0.<init>(r3, r4)
        L_0x03f6:
            r14 = r0
            goto L_0x006d
        L_0x03f9:
            r3 = r7[r0]
            r11 = r19
            boolean r3 = r3.equals(r11)
            if (r3 == 0) goto L_0x040d
            android.content.Intent r0 = new android.content.Intent
            android.content.Context r3 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.UWorld.UWTestResultActivity> r4 = net.imedicaldoctor.imd.Fragments.UWorld.UWTestResultActivity.class
            r0.<init>(r3, r4)
            goto L_0x03f6
        L_0x040d:
            r3 = r7[r0]
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0424
            java.lang.String r0 = r24.F2(r25, r26)
            android.content.Intent r1 = new android.content.Intent
            android.content.Context r3 = r6.f29548d
            r1.<init>(r3, r10)
            r14 = r1
            r1 = r0
            goto L_0x006d
        L_0x0424:
            r0 = r7[r0]
            java.lang.String r3 = "progress"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0438
            android.content.Intent r0 = new android.content.Intent
            android.content.Context r3 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.UWorld.UWProgressActivity> r4 = net.imedicaldoctor.imd.Fragments.UWorld.UWProgressActivity.class
            r0.<init>(r3, r4)
            goto L_0x03f6
        L_0x0438:
            android.content.Intent r0 = new android.content.Intent
            android.content.Context r3 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivity> r4 = net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivity.class
            r0.<init>(r3, r4)
            goto L_0x03f6
        L_0x0442:
            r11 = r19
            r8 = r20
            java.lang.String r0 = "irqbank"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x047e
            r0 = 0
            r3 = r7[r0]
            boolean r3 = r3.equals(r8)
            if (r3 == 0) goto L_0x0461
            android.content.Intent r0 = new android.content.Intent
            android.content.Context r3 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivity> r4 = net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivity.class
            r0.<init>(r3, r4)
            goto L_0x03f6
        L_0x0461:
            r0 = r7[r0]
            boolean r0 = r0.equals(r11)
            if (r0 == 0) goto L_0x0473
            android.content.Intent r0 = new android.content.Intent
            android.content.Context r3 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.DRE.DRETestResultActivity> r4 = net.imedicaldoctor.imd.Fragments.DRE.DRETestResultActivity.class
            r0.<init>(r3, r4)
            goto L_0x03f6
        L_0x0473:
            android.content.Intent r0 = new android.content.Intent
            android.content.Context r3 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivity> r4 = net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivity.class
            r0.<init>(r3, r4)
            goto L_0x03f6
        L_0x047e:
            java.lang.String r0 = "epocrate"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0607
            r0 = 0
            r3 = r7[r0]
            java.lang.String r8 = "dx"
            boolean r3 = r3.equals(r8)
            java.lang.Class<net.imedicaldoctor.imd.Fragments.Epocrate.EPODxViewerActivity> r8 = net.imedicaldoctor.imd.Fragments.Epocrate.EPODxViewerActivity.class
            if (r3 == 0) goto L_0x04cc
            android.content.Context r3 = r6.f29548d
            r4 = r18
            android.content.SharedPreferences r3 = r3.getSharedPreferences(r4, r0)
            java.lang.String r4 = "DiseaseList"
            boolean r3 = r3.getBoolean(r4, r0)
            android.content.Intent r0 = new android.content.Intent
            if (r3 == 0) goto L_0x04af
            android.content.Context r3 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.Epocrate.EPODxListViewerActivity> r4 = net.imedicaldoctor.imd.Fragments.Epocrate.EPODxListViewerActivity.class
            r0.<init>(r3, r4)
        L_0x04ac:
            r3 = r27
            goto L_0x04b5
        L_0x04af:
            android.content.Context r3 = r6.f29548d
            r0.<init>(r3, r8)
            goto L_0x04ac
        L_0x04b5:
            if (r3 == 0) goto L_0x04be
            android.content.Intent r0 = new android.content.Intent
            android.content.Context r4 = r6.f29548d
            r0.<init>(r4, r8)
        L_0x04be:
            r14 = r0
            r14.putExtra(r2, r1)
            r0 = 0
            r0 = r7[r0]
            r9 = r17
        L_0x04c7:
            r14.putExtra(r9, r0)
            goto L_0x0621
        L_0x04cc:
            r3 = r27
            r9 = r17
            r10 = r18
            r11 = r7[r0]
            java.lang.String r12 = "lab"
            boolean r11 = r11.equals(r12)
            if (r11 == 0) goto L_0x050d
            android.content.Context r4 = r6.f29548d
            android.content.SharedPreferences r4 = r4.getSharedPreferences(r10, r0)
            java.lang.String r0 = "LabList"
            r5 = 1
            boolean r0 = r4.getBoolean(r0, r5)
            if (r0 == 0) goto L_0x04f5
            android.content.Intent r0 = new android.content.Intent
            android.content.Context r4 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.Epocrate.EPODxListViewerActivity> r5 = net.imedicaldoctor.imd.Fragments.Epocrate.EPODxListViewerActivity.class
            r0.<init>(r4, r5)
            goto L_0x04fc
        L_0x04f5:
            android.content.Intent r0 = new android.content.Intent
            android.content.Context r4 = r6.f29548d
            r0.<init>(r4, r8)
        L_0x04fc:
            if (r3 == 0) goto L_0x0505
            android.content.Intent r0 = new android.content.Intent
            android.content.Context r4 = r6.f29548d
            r0.<init>(r4, r8)
        L_0x0505:
            r14 = r0
            r14.putExtra(r2, r1)
            r0 = 0
            r0 = r7[r0]
            goto L_0x04c7
        L_0x050d:
            r8 = r7[r0]
            java.lang.String r9 = "rx"
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x0525
            android.content.Intent r14 = new android.content.Intent
            android.content.Context r0 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivity> r4 = net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivity.class
            r14.<init>(r0, r4)
        L_0x0520:
            r14.putExtra(r2, r1)
            goto L_0x0621
        L_0x0525:
            r8 = r7[r0]
            java.lang.String r9 = "epohtml"
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x0542
            android.content.Intent r14 = new android.content.Intent
            android.content.Context r0 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.Epocrate.EPOHTMLViewer> r5 = net.imedicaldoctor.imd.Fragments.Epocrate.EPOHTMLViewer.class
            r14.<init>(r0, r5)
            r14.putExtra(r2, r1)
            r8 = r16
            r14.putExtra(r8, r4)
            goto L_0x0621
        L_0x0542:
            r8 = r16
            r4 = r7[r0]
            java.lang.String r0 = "epourl"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0561
            android.content.Intent r14 = new android.content.Intent
            android.content.Context r0 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.Epocrate.EPOHTMLViewer> r4 = net.imedicaldoctor.imd.Fragments.Epocrate.EPOHTMLViewer.class
            r14.<init>(r0, r4)
            r14.putExtra(r2, r1)
            java.lang.String r0 = "url"
            r14.putExtra(r8, r0)
            goto L_0x0621
        L_0x0561:
            r0 = 0
            r4 = r7[r0]
            java.lang.String r8 = "web"
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x0576
            android.content.Intent r14 = new android.content.Intent
            android.content.Context r0 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.Epocrate.EpoDXWebViewerActivity> r4 = net.imedicaldoctor.imd.Fragments.Epocrate.EpoDXWebViewerActivity.class
            r14.<init>(r0, r4)
            goto L_0x0520
        L_0x0576:
            r4 = r7[r0]
            java.lang.String r8 = "interact"
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x058a
            android.content.Intent r14 = new android.content.Intent
            android.content.Context r0 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.Epocrate.EPOInteractSingleActivity> r4 = net.imedicaldoctor.imd.Fragments.Epocrate.EPOInteractSingleActivity.class
            r14.<init>(r0, r4)
            goto L_0x0520
        L_0x058a:
            r4 = r7[r0]
            java.lang.String r8 = "interactview"
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x059e
            android.content.Intent r14 = new android.content.Intent
            android.content.Context r0 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.Epocrate.EPOInteractViewerActivity> r4 = net.imedicaldoctor.imd.Fragments.Epocrate.EPOInteractViewerActivity.class
            r14.<init>(r0, r4)
            goto L_0x0520
        L_0x059e:
            r4 = r7[r0]
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x05b1
            android.content.Intent r14 = new android.content.Intent
            android.content.Context r0 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.Epocrate.EPOInteractResultActivity> r4 = net.imedicaldoctor.imd.Fragments.Epocrate.EPOInteractResultActivity.class
            r14.<init>(r0, r4)
            goto L_0x0520
        L_0x05b1:
            r4 = r7[r0]
            java.lang.String r5 = "id"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x05c6
            android.content.Intent r14 = new android.content.Intent
            android.content.Context r0 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.Epocrate.EPOIDViewerActivity> r4 = net.imedicaldoctor.imd.Fragments.Epocrate.EPOIDViewerActivity.class
            r14.<init>(r0, r4)
            goto L_0x0520
        L_0x05c6:
            r4 = r7[r0]
            java.lang.String r5 = "guideline"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x05db
            android.content.Intent r14 = new android.content.Intent
            android.content.Context r0 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.Epocrate.EPOGuidelineViewerActivity> r4 = net.imedicaldoctor.imd.Fragments.Epocrate.EPOGuidelineViewerActivity.class
            r14.<init>(r0, r4)
            goto L_0x0520
        L_0x05db:
            r4 = r7[r0]
            java.lang.String r5 = "table"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x05f0
            android.content.Intent r14 = new android.content.Intent
            android.content.Context r0 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.Epocrate.EPOTableViewerActivity> r4 = net.imedicaldoctor.imd.Fragments.Epocrate.EPOTableViewerActivity.class
            r14.<init>(r0, r4)
            goto L_0x0520
        L_0x05f0:
            r0 = r7[r0]
            java.lang.String r4 = "pillid"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0605
            android.content.Intent r14 = new android.content.Intent
            android.content.Context r0 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.Epocrate.EPOPillResultActivity> r4 = net.imedicaldoctor.imd.Fragments.Epocrate.EPOPillResultActivity.class
            r14.<init>(r0, r4)
            goto L_0x0520
        L_0x0605:
            r14 = 0
            goto L_0x0621
        L_0x0607:
            r3 = r27
            android.content.Intent r14 = new android.content.Intent
            android.content.Context r0 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.Lexi.LXViewer> r4 = net.imedicaldoctor.imd.Fragments.Lexi.LXViewer.class
            r14.<init>(r0, r4)
            goto L_0x0520
        L_0x0614:
            r0 = 0
            throw r0
        L_0x0616:
            android.content.Intent r14 = new android.content.Intent
            android.content.Context r0 = r6.f29548d
            java.lang.Class<net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity> r4 = net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity.class
            r14.<init>(r0, r4)
            goto L_0x0520
        L_0x0621:
            if (r3 == 0) goto L_0x0628
            java.lang.String r0 = "SEARCH"
            r14.putExtra(r0, r3)
        L_0x0628:
            r0 = r28
            if (r0 == 0) goto L_0x0631
            java.lang.String r1 = "SECTION"
            r14.putExtra(r1, r0)
        L_0x0631:
            java.lang.String r0 = "DB"
            r1 = r25
            r14.putExtra(r0, r1)
            r0 = r29
            if (r0 == 0) goto L_0x063f
            r14.putExtras(r0)
        L_0x063f:
            android.content.Context r0 = r6.f29548d
            r0.startActivity(r14)
            android.content.Context r0 = r6.f29548d
            android.app.Activity r0 = (android.app.Activity) r0
            r1 = 2130772005(0x7f010025, float:1.7147116E38)
            r2 = 2130772006(0x7f010026, float:1.7147118E38)
            r0.overridePendingTransition(r1, r2)
            goto L_0x0c13
        L_0x0653:
            r6 = r0
            r0 = r3
            r22 = r18
            r5 = r21
            android.os.Bundle r3 = new android.os.Bundle
            r3.<init>()
            boolean r13 = r9.equals(r13)
            if (r13 != 0) goto L_0x066a
            boolean r12 = r9.equals(r12)
            if (r12 == 0) goto L_0x0674
        L_0x066a:
            r10 = 1
            r12 = 0
            r6 = r24
            r9 = r27
            r8 = r22
            goto L_0x0bba
        L_0x0674:
            boolean r11 = r9.equals(r11)
            if (r11 == 0) goto L_0x068d
            r3.putString(r2, r1)
            net.imedicaldoctor.imd.Fragments.NEJM.NEJMViewerActivity$NEJMViewerFragment r0 = new net.imedicaldoctor.imd.Fragments.NEJM.NEJMViewerActivity$NEJMViewerFragment
            r0.<init>()
        L_0x0682:
            r10 = 1
            r12 = 0
            r6 = r24
            r9 = r27
            r2 = r0
        L_0x0689:
            r8 = r22
            goto L_0x0bc4
        L_0x068d:
            boolean r10 = r9.equals(r10)
            if (r10 == 0) goto L_0x06fc
            r10 = 0
            r0 = r7[r10]
            java.lang.String r0 = r0.replace(r15, r8)
            java.lang.String r5 = "Graphic"
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x06d6
            net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity$UTDGraphicFragment r0 = new net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity$UTDGraphicFragment
            r0.<init>()
            r1 = 1
            r2 = r7[r1]
            java.lang.String r1 = ",,,,"
            java.lang.String[] r1 = r2.split(r1)
            java.lang.String r2 = "IDS"
            r3.putStringArray(r2, r1)
            int r1 = r7.length
            r2 = 4
            if (r1 != r2) goto L_0x0682
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 2
            r2 = r7[r2]
            java.lang.String r4 = ","
            java.lang.String[] r2 = org.apache.commons.lang3.StringUtils.splitByWholeSeparator(r2, r4)
            java.util.List r2 = java.util.Arrays.asList(r2)
            r1.<init>(r2)
            java.lang.String r2 = "AllGraphics"
            r3.putStringArrayList(r2, r1)
            r1 = 3
            r1 = r7[r1]
            java.lang.String r2 = "GraphicIndex"
            goto L_0x06f8
        L_0x06d6:
            r0 = 0
            r5 = r7[r0]
            boolean r0 = r5.equals(r4)
            if (r0 == 0) goto L_0x06f3
            java.lang.String r0 = r24.F2(r25, r26)
            net.imedicaldoctor.imd.Fragments.AccessMedicine.AMHTMLViewerFragment r1 = new net.imedicaldoctor.imd.Fragments.AccessMedicine.AMHTMLViewerFragment
            r1.<init>()
        L_0x06e8:
            r3.putString(r2, r0)
        L_0x06eb:
            r10 = 1
            r12 = 0
            r6 = r24
            r9 = r27
            r2 = r1
            goto L_0x0689
        L_0x06f3:
            net.imedicaldoctor.imd.Fragments.Uptodate.UTDViewerActivity$UTDViewerFragment r0 = new net.imedicaldoctor.imd.Fragments.Uptodate.UTDViewerActivity$UTDViewerFragment
            r0.<init>()
        L_0x06f8:
            r3.putString(r2, r1)
            goto L_0x0682
        L_0x06fc:
            java.lang.String r10 = "utdadvanced"
            boolean r10 = r9.equals(r10)
            if (r10 == 0) goto L_0x071f
            r10 = 0
            r0 = r7[r10]
            java.lang.String r0 = r0.replace(r15, r8)
            java.lang.String r4 = "pathway"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0719
            net.imedicaldoctor.imd.Fragments.UTDAdvanced.UTDAViewerActivityFragment r0 = new net.imedicaldoctor.imd.Fragments.UTDAdvanced.UTDAViewerActivityFragment
            r0.<init>()
            goto L_0x06f8
        L_0x0719:
            net.imedicaldoctor.imd.Fragments.Uptodate.UTDViewerActivity$UTDViewerFragment r0 = new net.imedicaldoctor.imd.Fragments.Uptodate.UTDViewerActivity$UTDViewerFragment
            r0.<init>()
            goto L_0x06f8
        L_0x071f:
            java.lang.String r8 = "accessmedicine"
            boolean r8 = r9.equals(r8)
            if (r8 == 0) goto L_0x0745
            r8 = 0
            r0 = r7[r8]
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x073a
            java.lang.String r0 = r24.F2(r25, r26)
            net.imedicaldoctor.imd.Fragments.AccessMedicine.AMHTMLViewerFragment r1 = new net.imedicaldoctor.imd.Fragments.AccessMedicine.AMHTMLViewerFragment
            r1.<init>()
            goto L_0x06e8
        L_0x073a:
            net.imedicaldoctor.imd.Fragments.AccessMedicine.AMViewerActivity$AMViewerFragment r0 = new net.imedicaldoctor.imd.Fragments.AccessMedicine.AMViewerActivity$AMViewerFragment
            r0.<init>()
            r23 = r1
            r1 = r0
            r0 = r23
            goto L_0x06e8
        L_0x0745:
            java.lang.String r8 = "lww"
            boolean r8 = r9.equals(r8)
            if (r8 == 0) goto L_0x0753
            net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment r0 = new net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment
            r0.<init>()
            goto L_0x06f8
        L_0x0753:
            java.lang.String r8 = "skyscape"
            boolean r8 = r9.equals(r8)
            if (r8 == 0) goto L_0x0765
            r3.putString(r2, r1)
            net.imedicaldoctor.imd.Fragments.Skyscape.SSViewerActivity$SSViewerFragment r0 = new net.imedicaldoctor.imd.Fragments.Skyscape.SSViewerActivity$SSViewerFragment
            r0.<init>()
            goto L_0x0682
        L_0x0765:
            java.lang.String r8 = "ovid"
            boolean r8 = r9.equals(r8)
            if (r8 == 0) goto L_0x0777
            r3.putString(r2, r1)
            net.imedicaldoctor.imd.Fragments.OVID.OvidViewerActivity$OvidViewerFragment r0 = new net.imedicaldoctor.imd.Fragments.OVID.OvidViewerActivity$OvidViewerFragment
            r0.<init>()
            goto L_0x0682
        L_0x0777:
            java.lang.String r8 = "irandarou"
            boolean r8 = r9.equals(r8)
            if (r8 == 0) goto L_0x0789
            r3.putString(r2, r1)
            net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity$IDViewerFragment r0 = new net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity$IDViewerFragment
            r0.<init>()
            goto L_0x0682
        L_0x0789:
            java.lang.String r8 = "uptodateddx"
            boolean r8 = r9.equals(r8)
            if (r8 == 0) goto L_0x079b
            r3.putString(r2, r1)
            net.imedicaldoctor.imd.Fragments.UptodateDDX.UTDDViewerActivity$UTDDViewerFragment r0 = new net.imedicaldoctor.imd.Fragments.UptodateDDX.UTDDViewerActivity$UTDDViewerFragment
            r0.<init>()
            goto L_0x0682
        L_0x079b:
            java.lang.String r8 = "visualdx"
            boolean r8 = r9.equals(r8)
            if (r8 == 0) goto L_0x07bf
            r8 = 0
            r0 = r7[r8]
            java.lang.String r4 = "Doc"
            boolean r0 = r0.equals(r4)
            r3.putString(r2, r1)
            if (r0 == 0) goto L_0x07b8
            net.imedicaldoctor.imd.Fragments.VisualDXLookup.VDViewerActivity$VDViewerFragment r0 = new net.imedicaldoctor.imd.Fragments.VisualDXLookup.VDViewerActivity$VDViewerFragment
            r0.<init>()
            goto L_0x0682
        L_0x07b8:
            net.imedicaldoctor.imd.Fragments.VisualDXLookup.VDDiagnosisActivity$VDDiagnosisFragment r0 = new net.imedicaldoctor.imd.Fragments.VisualDXLookup.VDDiagnosisActivity$VDDiagnosisFragment
            r0.<init>()
            goto L_0x0682
        L_0x07bf:
            java.lang.String r8 = "visualdxddx"
            boolean r8 = r9.equals(r8)
            if (r8 == 0) goto L_0x07e3
            r8 = 0
            r0 = r7[r8]
            java.lang.String r4 = "ddx"
            boolean r0 = r0.equals(r4)
            r3.putString(r2, r1)
            if (r0 == 0) goto L_0x07dc
            net.imedicaldoctor.imd.Fragments.VisualDXLookup.VDDxResults$VDDxResultsFragment r0 = new net.imedicaldoctor.imd.Fragments.VisualDXLookup.VDDxResults$VDDxResultsFragment
            r0.<init>()
            goto L_0x0682
        L_0x07dc:
            net.imedicaldoctor.imd.Fragments.VisualDDX.VDDxBuilderActivity$VDDXBuilderFragment r0 = new net.imedicaldoctor.imd.Fragments.VisualDDX.VDDxBuilderActivity$VDDXBuilderFragment
            r0.<init>()
            goto L_0x0682
        L_0x07e3:
            java.lang.String r8 = "Dictionary"
            boolean r8 = r9.equals(r8)
            if (r8 == 0) goto L_0x082a
            r3.putString(r2, r1)
            r0 = 0
            r1 = r7[r0]
            java.lang.String r4 = "EP"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x0800
            net.imedicaldoctor.imd.Fragments.Dictionary.CDicEPActivity$CDicEPFragment r1 = new net.imedicaldoctor.imd.Fragments.Dictionary.CDicEPActivity$CDicEPFragment
            r1.<init>()
            goto L_0x06eb
        L_0x0800:
            r1 = r7[r0]
            java.lang.String r4 = "EE"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x0811
            net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity$CDicEEFragment r1 = new net.imedicaldoctor.imd.Fragments.Dictionary.CDicEEActivity$CDicEEFragment
            r1.<init>()
            goto L_0x06eb
        L_0x0811:
            r1 = r7[r0]
            boolean r0 = r1.equals(r2)
            if (r0 == 0) goto L_0x0820
            net.imedicaldoctor.imd.Fragments.Dictionary.CDicSimpleWebViewer$CDicSimpleWebViewerFragment r0 = new net.imedicaldoctor.imd.Fragments.Dictionary.CDicSimpleWebViewer$CDicSimpleWebViewerFragment
            r0.<init>()
            goto L_0x0682
        L_0x0820:
            r10 = 1
            r12 = 0
            r6 = r24
            r9 = r27
            r8 = r22
            goto L_0x0ba6
        L_0x082a:
            java.lang.String r8 = "medhand"
            boolean r8 = r9.equals(r8)
            if (r8 == 0) goto L_0x083c
            r3.putString(r2, r1)
            net.imedicaldoctor.imd.Fragments.Medhand.MHViewerActivity$MHViewerFragment r0 = new net.imedicaldoctor.imd.Fragments.Medhand.MHViewerActivity$MHViewerFragment
            r0.<init>()
            goto L_0x0682
        L_0x083c:
            java.lang.String r8 = "epub"
            boolean r8 = r9.equals(r8)
            if (r8 == 0) goto L_0x084e
            r3.putString(r2, r1)
            net.imedicaldoctor.imd.Fragments.EPUB.EPUBViewerActivityFragment r0 = new net.imedicaldoctor.imd.Fragments.EPUB.EPUBViewerActivityFragment
            r0.<init>()
            goto L_0x0682
        L_0x084e:
            java.lang.String r8 = "amirsys"
            boolean r8 = r9.equals(r8)
            if (r8 == 0) goto L_0x087c
            java.lang.String[] r0 = org.apache.commons.lang3.StringUtils.splitByWholeSeparator(r1, r0)
            r3.putString(r2, r1)
            r1 = 0
            r2 = r0[r1]
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L_0x086d
            net.imedicaldoctor.imd.Fragments.Amirsys.ASMenuActivityFragment r0 = new net.imedicaldoctor.imd.Fragments.Amirsys.ASMenuActivityFragment
            r0.<init>()
            goto L_0x0682
        L_0x086d:
            r0 = r0[r1]
            boolean r0 = r0.equals(r14)
            if (r0 == 0) goto L_0x0820
            net.imedicaldoctor.imd.Fragments.Amirsys.ASDocActivityFragment r0 = new net.imedicaldoctor.imd.Fragments.Amirsys.ASDocActivityFragment
            r0.<init>()
            goto L_0x0682
        L_0x087c:
            java.lang.String r8 = "statdx"
            boolean r8 = r9.equals(r8)
            if (r8 == 0) goto L_0x08bb
            java.lang.String[] r0 = org.apache.commons.lang3.StringUtils.splitByWholeSeparator(r1, r0)
            r3.putString(r2, r1)
            r1 = 0
            r2 = r0[r1]
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L_0x089b
            net.imedicaldoctor.imd.Fragments.Statdx.SDMenuActivityFragment r0 = new net.imedicaldoctor.imd.Fragments.Statdx.SDMenuActivityFragment
            r0.<init>()
            goto L_0x0682
        L_0x089b:
            r2 = r0[r1]
            boolean r2 = r2.equals(r14)
            if (r2 == 0) goto L_0x08aa
            net.imedicaldoctor.imd.Fragments.Statdx.SDDocActivityFragment r0 = new net.imedicaldoctor.imd.Fragments.Statdx.SDDocActivityFragment
            r0.<init>()
            goto L_0x0682
        L_0x08aa:
            r0 = r0[r1]
            java.lang.String r1 = "case"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0820
            net.imedicaldoctor.imd.Fragments.Statdx.SDCaseActivityFragment r0 = new net.imedicaldoctor.imd.Fragments.Statdx.SDCaseActivityFragment
            r0.<init>()
            goto L_0x0682
        L_0x08bb:
            java.lang.String r0 = "martindale"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x08cd
            r3.putString(r2, r1)
            net.imedicaldoctor.imd.Fragments.Martindale.MDViewerActivityFragment r0 = new net.imedicaldoctor.imd.Fragments.Martindale.MDViewerActivityFragment
            r0.<init>()
            goto L_0x0682
        L_0x08cd:
            java.lang.String r0 = "facts"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x08df
            r3.putString(r2, r1)
            net.imedicaldoctor.imd.Fragments.Facts.FTViewerActivityFragment r0 = new net.imedicaldoctor.imd.Fragments.Facts.FTViewerActivityFragment
            r0.<init>()
            goto L_0x0682
        L_0x08df:
            java.lang.String r0 = "micromedex-drug"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x08f1
            r3.putString(r2, r1)
            net.imedicaldoctor.imd.Fragments.Micromedex.MMViewerActivityFragment r0 = new net.imedicaldoctor.imd.Fragments.Micromedex.MMViewerActivityFragment
            r0.<init>()
            goto L_0x0682
        L_0x08f1:
            java.lang.String r0 = "micromedex-neofax"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0903
            r3.putString(r2, r1)
            net.imedicaldoctor.imd.Fragments.Micromedex.MMNeoViewerActivityFragment r0 = new net.imedicaldoctor.imd.Fragments.Micromedex.MMNeoViewerActivityFragment
            r0.<init>()
            goto L_0x0682
        L_0x0903:
            java.lang.String r0 = "micromedex-interact"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0935
            r0 = 0
            r4 = r7[r0]
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x091a
            net.imedicaldoctor.imd.Fragments.Micromedex.MMInteractResultActivityFragment r14 = new net.imedicaldoctor.imd.Fragments.Micromedex.MMInteractResultActivityFragment
            r14.<init>()
            goto L_0x0929
        L_0x091a:
            r4 = r7[r0]
            boolean r0 = r4.equals(r14)
            if (r0 == 0) goto L_0x0928
            net.imedicaldoctor.imd.Fragments.Micromedex.MMInteractViewerActivityFragment r14 = new net.imedicaldoctor.imd.Fragments.Micromedex.MMInteractViewerActivityFragment
            r14.<init>()
            goto L_0x0929
        L_0x0928:
            r14 = 0
        L_0x0929:
            r3.putString(r2, r1)
            r10 = 1
            r12 = 0
            r6 = r24
            r9 = r27
            r2 = r14
            goto L_0x0689
        L_0x0935:
            java.lang.String r0 = "micromedex-iv"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x095a
            r0 = 0
            r4 = r7[r0]
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x094c
            net.imedicaldoctor.imd.Fragments.Micromedex.MMIVResultActivityFragment r14 = new net.imedicaldoctor.imd.Fragments.Micromedex.MMIVResultActivityFragment
            r14.<init>()
            goto L_0x0929
        L_0x094c:
            r4 = r7[r0]
            boolean r0 = r4.equals(r14)
            if (r0 == 0) goto L_0x0928
            net.imedicaldoctor.imd.Fragments.Micromedex.MMIVViewerActivityFragment r14 = new net.imedicaldoctor.imd.Fragments.Micromedex.MMIVViewerActivityFragment
            r14.<init>()
            goto L_0x0929
        L_0x095a:
            java.lang.String r0 = "sanford"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x096c
            r3.putString(r2, r1)
            net.imedicaldoctor.imd.Fragments.Sanford.SANViewerActivityFragment r0 = new net.imedicaldoctor.imd.Fragments.Sanford.SANViewerActivityFragment
            r0.<init>()
            goto L_0x0682
        L_0x096c:
            java.lang.String r0 = "tol"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0995
            r3.putString(r2, r1)
            java.lang.String r0 = "1"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0986
            net.imedicaldoctor.imd.Fragments.TOL.TolFragment r0 = new net.imedicaldoctor.imd.Fragments.TOL.TolFragment
            r0.<init>()
            goto L_0x0682
        L_0x0986:
            java.lang.String r0 = "10"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0820
            net.imedicaldoctor.imd.Fragments.TOL.IGTFragment r0 = new net.imedicaldoctor.imd.Fragments.TOL.IGTFragment
            r0.<init>()
            goto L_0x0682
        L_0x0995:
            java.lang.String r0 = "noskhe"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x09a7
            r3.putString(r2, r1)
            net.imedicaldoctor.imd.Fragments.Noskheha.NOSViewerActivityFragment r0 = new net.imedicaldoctor.imd.Fragments.Noskheha.NOSViewerActivityFragment
            r0.<init>()
            goto L_0x0682
        L_0x09a7:
            java.lang.String r0 = "stockley"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x09b9
            r3.putString(r2, r1)
            net.imedicaldoctor.imd.Fragments.Stockley.STViewerActivityFragment r0 = new net.imedicaldoctor.imd.Fragments.Stockley.STViewerActivityFragment
            r0.<init>()
            goto L_0x0682
        L_0x09b9:
            java.lang.String r0 = "mksap"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x09cb
            r3.putString(r2, r1)
            net.imedicaldoctor.imd.Fragments.mksap.MKSAPActivityFragment r0 = new net.imedicaldoctor.imd.Fragments.mksap.MKSAPActivityFragment
            r0.<init>()
            goto L_0x0682
        L_0x09cb:
            java.lang.String r0 = "uworld"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0a27
            r0 = 0
            r5 = r7[r0]
            r6 = r20
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x09e4
            net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment r4 = new net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment
            r4.<init>()
            goto L_0x0a1b
        L_0x09e4:
            r5 = r7[r0]
            r8 = r19
            boolean r5 = r5.equals(r8)
            if (r5 == 0) goto L_0x09f4
            net.imedicaldoctor.imd.Fragments.UWorld.UWTestResultActivityFragment r4 = new net.imedicaldoctor.imd.Fragments.UWorld.UWTestResultActivityFragment
            r4.<init>()
            goto L_0x0a1b
        L_0x09f4:
            r5 = r7[r0]
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x0a06
            java.lang.String r1 = r24.F2(r25, r26)
            net.imedicaldoctor.imd.Fragments.AccessMedicine.AMHTMLViewerFragment r4 = new net.imedicaldoctor.imd.Fragments.AccessMedicine.AMHTMLViewerFragment
            r4.<init>()
            goto L_0x0a1b
        L_0x0a06:
            r4 = r7[r0]
            java.lang.String r0 = "progress"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0a16
            net.imedicaldoctor.imd.Fragments.UWorld.UWProgressFragment r4 = new net.imedicaldoctor.imd.Fragments.UWorld.UWProgressFragment
            r4.<init>()
            goto L_0x0a1b
        L_0x0a16:
            net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment r4 = new net.imedicaldoctor.imd.Fragments.UWorld.UWTestViewerActivityFragment
            r4.<init>()
        L_0x0a1b:
            r3.putString(r2, r1)
            r10 = 1
            r12 = 0
            r6 = r24
            r9 = r27
            r2 = r4
            goto L_0x0689
        L_0x0a27:
            r8 = r19
            r6 = r20
            java.lang.String r0 = "irqbank"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0a56
            r0 = 0
            r4 = r7[r0]
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x0a42
            net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment r4 = new net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment
            r4.<init>()
            goto L_0x0a1b
        L_0x0a42:
            r4 = r7[r0]
            boolean r0 = r4.equals(r8)
            if (r0 == 0) goto L_0x0a50
            net.imedicaldoctor.imd.Fragments.DRE.DRETestResultActivityFragment r4 = new net.imedicaldoctor.imd.Fragments.DRE.DRETestResultActivityFragment
            r4.<init>()
            goto L_0x0a1b
        L_0x0a50:
            net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment r4 = new net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment
            r4.<init>()
            goto L_0x0a1b
        L_0x0a56:
            java.lang.String r0 = "epocrate"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0ba8
            r0 = 0
            r6 = r7[r0]
            java.lang.String r8 = "dx"
            boolean r6 = r6.equals(r8)
            if (r6 == 0) goto L_0x0aa0
            r6 = r24
            android.content.Context r4 = r6.f29548d
            r8 = r22
            android.content.SharedPreferences r4 = r4.getSharedPreferences(r8, r0)
            java.lang.String r5 = "DiseaseList"
            boolean r4 = r4.getBoolean(r5, r0)
            if (r4 == 0) goto L_0x0a83
            net.imedicaldoctor.imd.Fragments.Epocrate.EPODxListViewerActivityFragment r0 = new net.imedicaldoctor.imd.Fragments.Epocrate.EPODxListViewerActivityFragment
            r0.<init>()
        L_0x0a80:
            r9 = r27
            goto L_0x0a89
        L_0x0a83:
            net.imedicaldoctor.imd.Fragments.Epocrate.EPODxViewerActivityFragment r0 = new net.imedicaldoctor.imd.Fragments.Epocrate.EPODxViewerActivityFragment
            r0.<init>()
            goto L_0x0a80
        L_0x0a89:
            if (r9 == 0) goto L_0x0a90
            net.imedicaldoctor.imd.Fragments.Epocrate.EPODxViewerActivityFragment r0 = new net.imedicaldoctor.imd.Fragments.Epocrate.EPODxViewerActivityFragment
            r0.<init>()
        L_0x0a90:
            r3.putString(r2, r1)
            r10 = 0
            r1 = r7[r10]
            r11 = r17
            r3.putString(r11, r1)
            r2 = r0
            r10 = 1
            r12 = 0
            goto L_0x0bc4
        L_0x0aa0:
            r10 = 0
            r6 = r24
            r9 = r27
            r11 = r17
            r8 = r22
            r0 = r7[r10]
            java.lang.String r12 = "lab"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x0ae0
            android.content.Context r0 = r6.f29548d
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r8, r10)
            java.lang.String r4 = "LabList"
            r10 = 1
            boolean r0 = r0.getBoolean(r4, r10)
            if (r0 == 0) goto L_0x0ac8
            net.imedicaldoctor.imd.Fragments.Epocrate.EPODxListViewerActivityFragment r0 = new net.imedicaldoctor.imd.Fragments.Epocrate.EPODxListViewerActivityFragment
            r0.<init>()
            goto L_0x0acd
        L_0x0ac8:
            net.imedicaldoctor.imd.Fragments.Epocrate.EPODxViewerActivityFragment r0 = new net.imedicaldoctor.imd.Fragments.Epocrate.EPODxViewerActivityFragment
            r0.<init>()
        L_0x0acd:
            if (r9 == 0) goto L_0x0ad4
            net.imedicaldoctor.imd.Fragments.Epocrate.EPODxViewerActivityFragment r0 = new net.imedicaldoctor.imd.Fragments.Epocrate.EPODxViewerActivityFragment
            r0.<init>()
        L_0x0ad4:
            r3.putString(r2, r1)
            r12 = 0
            r1 = r7[r12]
        L_0x0ada:
            r3.putString(r11, r1)
        L_0x0add:
            r2 = r0
            goto L_0x0bc4
        L_0x0ae0:
            r10 = 1
            r12 = 0
            r0 = r7[r12]
            java.lang.String r11 = "rx"
            boolean r0 = r0.equals(r11)
            if (r0 == 0) goto L_0x0af5
            net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment r0 = new net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment
            r0.<init>()
        L_0x0af1:
            r3.putString(r2, r1)
            goto L_0x0add
        L_0x0af5:
            r0 = r7[r12]
            java.lang.String r11 = "epohtml"
            boolean r0 = r0.equals(r11)
            if (r0 == 0) goto L_0x0b0d
            net.imedicaldoctor.imd.Fragments.Epocrate.EPOHTMLViewerFragment r0 = new net.imedicaldoctor.imd.Fragments.Epocrate.EPOHTMLViewerFragment
            r0.<init>()
            r3.putString(r2, r1)
            r11 = r16
            r3.putString(r11, r4)
            goto L_0x0add
        L_0x0b0d:
            r11 = r16
            r0 = r7[r12]
            java.lang.String r4 = "epourl"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0b24
            net.imedicaldoctor.imd.Fragments.Epocrate.EPOHTMLViewerFragment r0 = new net.imedicaldoctor.imd.Fragments.Epocrate.EPOHTMLViewerFragment
            r0.<init>()
            r3.putString(r2, r1)
            java.lang.String r1 = "url"
            goto L_0x0ada
        L_0x0b24:
            r0 = r7[r12]
            java.lang.String r4 = "web"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0b34
            net.imedicaldoctor.imd.Fragments.Epocrate.EpoDXWebViewerActivityFragment r0 = new net.imedicaldoctor.imd.Fragments.Epocrate.EpoDXWebViewerActivityFragment
            r0.<init>()
            goto L_0x0af1
        L_0x0b34:
            r0 = r7[r12]
            java.lang.String r4 = "interact"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0b44
            net.imedicaldoctor.imd.Fragments.Epocrate.EPOInteractSingleActivityFragment r0 = new net.imedicaldoctor.imd.Fragments.Epocrate.EPOInteractSingleActivityFragment
            r0.<init>()
            goto L_0x0af1
        L_0x0b44:
            r0 = r7[r12]
            java.lang.String r4 = "interactview"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0b54
            net.imedicaldoctor.imd.Fragments.Epocrate.EPOInteractViewerActivityFragment r0 = new net.imedicaldoctor.imd.Fragments.Epocrate.EPOInteractViewerActivityFragment
            r0.<init>()
            goto L_0x0af1
        L_0x0b54:
            r0 = r7[r12]
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x0b62
            net.imedicaldoctor.imd.Fragments.Epocrate.EPOInteractResultActivityFragment r0 = new net.imedicaldoctor.imd.Fragments.Epocrate.EPOInteractResultActivityFragment
            r0.<init>()
            goto L_0x0af1
        L_0x0b62:
            r0 = r7[r12]
            java.lang.String r4 = "id"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0b73
            net.imedicaldoctor.imd.Fragments.Epocrate.EPOIDViewerActivityFragment r0 = new net.imedicaldoctor.imd.Fragments.Epocrate.EPOIDViewerActivityFragment
            r0.<init>()
            goto L_0x0af1
        L_0x0b73:
            r0 = r7[r12]
            java.lang.String r4 = "guideline"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0b84
            net.imedicaldoctor.imd.Fragments.Epocrate.EPOGuidelineViewerActivityFragment r0 = new net.imedicaldoctor.imd.Fragments.Epocrate.EPOGuidelineViewerActivityFragment
            r0.<init>()
            goto L_0x0af1
        L_0x0b84:
            r0 = r7[r12]
            java.lang.String r4 = "table"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0b95
            net.imedicaldoctor.imd.Fragments.Epocrate.EPOTableViewerActivityFragment r0 = new net.imedicaldoctor.imd.Fragments.Epocrate.EPOTableViewerActivityFragment
            r0.<init>()
            goto L_0x0af1
        L_0x0b95:
            r0 = r7[r12]
            java.lang.String r4 = "pillid"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0ba6
            net.imedicaldoctor.imd.Fragments.Epocrate.EPOPillResultActivityFragment r0 = new net.imedicaldoctor.imd.Fragments.Epocrate.EPOPillResultActivityFragment
            r0.<init>()
            goto L_0x0af1
        L_0x0ba6:
            r2 = 0
            goto L_0x0bc4
        L_0x0ba8:
            r10 = 1
            r12 = 0
            r6 = r24
            r9 = r27
            r8 = r22
            r3.putString(r2, r1)
            net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment r0 = new net.imedicaldoctor.imd.Fragments.Lexi.LXViewer$LXViewerFragment
            r0.<init>()
            goto L_0x0add
        L_0x0bba:
            r3.putString(r2, r1)
            net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity$ELSViewerFragment r0 = new net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity$ELSViewerFragment
            r0.<init>()
            goto L_0x0add
        L_0x0bc4:
            if (r9 == 0) goto L_0x0bcb
            java.lang.String r0 = "SEARCH"
            r3.putStringArray(r0, r9)
        L_0x0bcb:
            r0 = r28
            if (r0 == 0) goto L_0x0bd4
            java.lang.String r1 = "SECTION"
            r3.putString(r1, r0)
        L_0x0bd4:
            java.lang.String r0 = "DB"
            r1 = r25
            r3.putBundle(r0, r1)
            r0 = r29
            if (r0 == 0) goto L_0x0be2
            r3.putAll(r0)
        L_0x0be2:
            r2.i2(r3)
            r4 = 1
            r5 = 1
            java.lang.String r1 = "detail"
            r3 = 2131362076(0x7f0a011c, float:1.8343922E38)
            r0 = r24
            r7 = 1
            r9 = 0
            r0.a2(r1, r2, r3, r4, r5)
            android.content.Context r0 = r6.f29548d
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r8, r9)
            java.lang.String r1 = "HideList"
            boolean r0 = r0.getBoolean(r1, r7)
            if (r0 == 0) goto L_0x0c13
            android.content.Context r0 = r6.f29548d
            android.app.Activity r0 = (android.app.Activity) r0
            r1 = 2131362562(0x7f0a0302, float:1.8344908E38)
            android.view.View r0 = r0.findViewById(r1)
            androidx.slidingpanelayout.widget.SlidingPaneLayout r0 = (androidx.slidingpanelayout.widget.SlidingPaneLayout) r0
            if (r0 == 0) goto L_0x0c13
            r0.c()
        L_0x0c13:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Data.CompressHelper.B1(android.os.Bundle, java.lang.String, java.lang.String[], java.lang.String, android.os.Bundle):void");
    }

    public String C0(String str, String str2) {
        String a1 = a1(str);
        String D0 = D0();
        Bundle n1 = n1(Y(D0, "Select * from cache where cachekey='" + a1 + "'"));
        if (n1 == null) {
            return null;
        }
        if (n1.getString("cachevalidation").equals(str2)) {
            return n1.getString("cachecontent");
        }
        String D02 = D0();
        q(D02, "Delete form cache where cachekey = '" + a1 + "'");
        return null;
    }

    public void C2(String str) {
        BufferedSink d2;
        String str2 = M1() + "/exp.txt";
        try {
            String n2 = new VBHelper(this.f29548d).n(str, "127");
            d2 = Okio.d(Okio.n(new File(str2)));
            d2.W0(n2);
            d2.close();
            return;
        } catch (Exception unused) {
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public String D0() {
        String str = M1() + "/cache.db";
        if (!new File(str).exists()) {
            SQLiteDatabase.openOrCreateDatabase(str, (SQLiteDatabase.CursorFactory) null).execSQL("create table cache (id integer primary key autoincrement, cachekey varchar(255) unique, cachecontent text, cachevalidation text);");
        }
        return str;
    }

    public ArrayList<Object> E(JSONArray jSONArray) {
        ArrayList<Object> arrayList = new ArrayList<>();
        int i2 = 0;
        while (i2 < jSONArray.length()) {
            new Bundle();
            try {
                if (!jSONArray.isNull(i2)) {
                    Object obj = jSONArray.get(i2);
                    if (obj.getClass() != JSONArray.class) {
                        arrayList.add(obj.getClass() == JSONObject.class ? G((JSONObject) obj) : jSONArray.getString(i2));
                    }
                }
                i2++;
            } catch (Exception e2) {
                FirebaseCrashlytics.d().g(e2);
                e2.getStackTrace()[0].getLineNumber();
                ArrayList arrayList2 = new ArrayList();
                for (int i3 = 0; i3 < e2.getStackTrace().length; i3++) {
                    String str = e2.getStackTrace()[i3].getClassName() + " - " + e2.getStackTrace()[i3].getLineNumber();
                    arrayList2.add(str);
                    iMDLogger.f("JSONArrayTo", str);
                }
                e2.printStackTrace();
                iMDLogger.f("JSONArrayToBundle", "Error in parsing");
                return null;
            }
        }
        return arrayList;
    }

    public String E0(String str) {
        if (str.contains(") order by RANDOM() limit 3")) {
            return str;
        }
        return "Select * from (" + str + ") order by RANDOM() limit 3";
    }

    public String E1(File file) {
        FileInputStream fileInputStream;
        BufferedSource e2;
        String l2 = Long.toString(file.length());
        byte[] bArr = new byte[1048576];
        try {
            fileInputStream = new FileInputStream(file);
            e2 = Okio.e(Okio.u(fileInputStream));
            e2.read(bArr, 0, 1048576);
            e2.close();
            fileInputStream.close();
            CRC32 crc32 = new CRC32();
            crc32.update(bArr, 0, 1048576);
            String l3 = Long.toString(crc32.getValue());
            return l3 + l2;
            throw th;
            throw th;
        } catch (IOException unused) {
            return null;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
    }

    public ArrayList<Bundle> F(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < jSONArray.length()) {
            new Bundle();
            try {
                Object obj = jSONArray.get(i2);
                if (obj.getClass() != JSONArray.class) {
                    arrayList.add(obj.getClass() == JSONObject.class ? G((JSONObject) obj) : jSONArray.getString(i2));
                }
                i2++;
            } catch (Exception e2) {
                FirebaseCrashlytics.d().g(e2);
                iMDLogger.f("JSONArrayToBundle", "Error in parsing");
                return null;
            }
        }
        ArrayList<Bundle> arrayList2 = new ArrayList<>();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add((Bundle) it2.next());
        }
        return arrayList2;
    }

    public String F2(Bundle bundle, String str) {
        BufferedSink d2;
        try {
            d2 = Okio.d(Okio.n(new File(g1(bundle, "temp.html"))));
            d2.C1(str, StandardCharsets.UTF_8);
            d2.close();
            return Annotation.k3;
        } catch (Exception unused) {
            return Annotation.k3;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public Bundle G(JSONObject jSONObject) throws Exception {
        Bundle bundle = new Bundle();
        Iterator<String> it2 = Lists.s(jSONObject.keys()).iterator();
        while (it2.hasNext()) {
            String next = it2.next();
            Object obj = jSONObject.get(next);
            if (obj.getClass() == JSONArray.class) {
                ArrayList<Object> E = E((JSONArray) obj);
                if (E.size() == 0) {
                    bundle.putParcelableArrayList(next, new ArrayList());
                } else if (E.get(0).getClass() == Bundle.class) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<Object> it3 = E.iterator();
                    while (it3.hasNext()) {
                        arrayList.add((Bundle) it3.next());
                    }
                    bundle.putParcelableArrayList(next, arrayList);
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<Object> it4 = E.iterator();
                    while (it4.hasNext()) {
                        arrayList2.add((String) it4.next());
                    }
                    bundle.putStringArrayList(next, arrayList2);
                }
            } else if (obj.getClass() == JSONObject.class) {
                bundle.putBundle(next, G((JSONObject) obj));
            } else {
                bundle.putString(next, jSONObject.getString(next));
            }
        }
        return bundle;
    }

    public void G1() {
        Bundle s1 = s1(Y(h2(), "Select c from r where id=1"));
        if (s1 == null) {
            q(h2(), "INSERT OR IGNORE INTO r values (1,0)");
            return;
        }
        String h2 = h2();
        q(h2, "update r set c=" + (Integer.valueOf(s1.getString("c")).intValue() + 1) + " where id=1");
    }

    public void H(String str, String str2, String str3) {
    }

    public Observable<String> H0(Activity activity, Observable<String> observable) {
        return observable.h6(Schedulers.e()).s4(AndroidSchedulers.e());
    }

    public void I(String str, String str2) {
    }

    public Observable<String> I0(Fragment fragment, Observable<String> observable) {
        return observable.h6(Schedulers.e()).s4(AndroidSchedulers.e());
    }

    public String J() {
        String str = this.f29548d.getSharedPreferences("default_preferences", 0).getString("MainServer", "Iran").equals("Iran") ? "si.imedicaldoctor.net" : "sg.imedicaldoctor.net";
        return "http://" + str;
    }

    public byte[] J0(char[] cArr, byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(cArr, bArr, 19, 128)).getEncoded(), "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
        instance.init(1, secretKeySpec, ivParameterSpec);
        return instance.doFinal(bArr3);
    }

    public String K() {
        String absolutePath = Environment.getExternalStoragePublicDirectory("Documents").getAbsolutePath();
        new File(absolutePath).mkdirs();
        return absolutePath + "/.iMD";
    }

    public ArrayList<String> K0() {
        ArrayList<Bundle> arrayList = ((iMD) this.f29548d.getApplicationContext()).s;
        ArrayList<String> arrayList2 = new ArrayList<>();
        boolean z = false;
        boolean z2 = arrayList == null;
        if (arrayList.size() == 0) {
            z = true;
        }
        if (z || z2) {
            return arrayList2;
        }
        Iterator<Bundle> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(it2.next().getString("Name"));
        }
        return arrayList2;
    }

    public String L() {
        String absolutePath = Environment.getExternalStoragePublicDirectory("Documents").getAbsolutePath();
        new File(absolutePath).mkdirs();
        return absolutePath + "/iMD";
    }

    public ArrayList<Bundle> L1() {
        String str = M1() + "/databases.json";
        if (((iMD) this.f29548d.getApplicationContext()).s == null) {
            k0();
            if (((iMD) this.f29548d.getApplicationContext()).s == null) {
                ((iMD) this.f29548d.getApplicationContext()).s = new ArrayList<>();
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Bundle> it2 = ((iMD) this.f29548d.getApplicationContext()).s.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next());
        }
        Collections.sort(arrayList, new Comparator<Bundle>() {
            /* renamed from: a */
            public int compare(Bundle bundle, Bundle bundle2) {
                return bundle.getString("Section").compareTo(bundle.getString("Section"));
            }
        });
        if (!new File(str).exists()) {
            return q2(arrayList);
        }
        try {
            JSONArray jSONArray = new JSONArray(new String(c2(str)));
            ArrayList<Bundle> arrayList2 = new ArrayList<>();
            int i2 = 0;
            while (i2 < jSONArray.length()) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                JSONArray jSONArray2 = jSONObject.getJSONArray("items");
                ArrayList arrayList3 = new ArrayList();
                int i3 = 0;
                while (i3 < jSONArray2.length()) {
                    final JSONObject jSONObject2 = jSONArray2.getJSONObject(i3);
                    ArrayList arrayList4 = new ArrayList(Collections2.d(arrayList, new Predicate<Bundle>() {
                        /* renamed from: a */
                        public boolean apply(Bundle bundle) {
                            try {
                                return bundle.getString("Name").equals(jSONObject2.getString("Name"));
                            } catch (Exception e2) {
                                FirebaseCrashlytics.d().g(e2);
                                iMDLogger.f("Error in filtering", e2.getLocalizedMessage());
                                return false;
                            }
                        }
                    }));
                    JSONArray jSONArray3 = jSONArray;
                    if (arrayList4.size() == 1) {
                        Bundle bundle = (Bundle) arrayList4.get(0);
                        arrayList.remove(bundle);
                        if (!jSONObject2.has("dontSearch") || !jSONObject2.getString("dontSearch").equals(IcyHeaders.a3)) {
                            bundle.putString("dontSearch", "0");
                        } else {
                            bundle.putString("dontSearch", IcyHeaders.a3);
                        }
                        arrayList3.add(bundle);
                    }
                    i3++;
                    jSONArray = jSONArray3;
                }
                JSONArray jSONArray4 = jSONArray;
                Bundle bundle2 = new Bundle();
                bundle2.putString("title", jSONObject.getString("title"));
                bundle2.putParcelableArrayList("items", arrayList3);
                arrayList2.add(bundle2);
                i2++;
                jSONArray = jSONArray4;
            }
            if (arrayList.size() > 0) {
                ArrayList<Bundle> q2 = q2(arrayList);
                for (int i4 = 0; i4 < q2.size(); i4++) {
                    final Bundle bundle3 = q2.get(i4);
                    ArrayList arrayList5 = new ArrayList(Collections2.d(arrayList2, new Predicate<Bundle>() {
                        /* renamed from: a */
                        public boolean apply(Bundle bundle) {
                            return bundle.getString("title").equals(bundle3.getString("title"));
                        }
                    }));
                    if (arrayList5.size() == 0) {
                        Bundle bundle4 = new Bundle();
                        bundle4.putString("title", bundle3.getString("title"));
                        bundle4.putParcelableArrayList("items", bundle3.getParcelableArrayList("items"));
                        arrayList2.add(bundle4);
                    } else {
                        Bundle bundle5 = (Bundle) arrayList5.get(0);
                        ArrayList parcelableArrayList = bundle5.getParcelableArrayList("items");
                        parcelableArrayList.addAll(bundle3.getParcelableArrayList("items"));
                        int indexOf = arrayList2.indexOf(bundle5);
                        Bundle bundle6 = new Bundle();
                        bundle6.putString("title", bundle5.getString("title"));
                        bundle6.putParcelableArrayList("items", parcelableArrayList);
                        arrayList2.remove(indexOf);
                        arrayList2.add(indexOf, bundle6);
                    }
                }
            }
            return arrayList2;
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            iMDLogger.f("Error in Reading Json", e2.getLocalizedMessage());
            return q2(arrayList);
        }
    }

    public void M(Class<?> cls, Class<?> cls2, Bundle bundle, int i2) {
        if (!x1()) {
            Intent intent = new Intent(this.f29548d, cls);
            intent.putExtras(bundle);
            this.f29548d.startActivity(intent);
            ((Activity) this.f29548d).overridePendingTransition(R.anim.f15from_fade_in, R.anim.f16from_fade_out);
            return;
        }
        try {
            Fragment fragment = (Fragment) cls2.getConstructor((Class[]) null).newInstance((Object[]) null);
            fragment.i2(bundle);
            if (i2 == R.id.container) {
                a2(v, fragment, R.id.f1064rootcontainer, true, true);
            } else {
                a2(w, fragment, i2, false, true);
            }
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            iMDLogger.f("OpenFragment", "Error in creating fragment : " + e2);
            FirebaseCrashlytics.d().g(e2);
            e2.printStackTrace();
        }
    }

    public String M1() {
        return U1();
    }

    public void N(Class<?> cls, Class<?> cls2, Bundle bundle) {
        M(cls, cls2, bundle, R.id.container);
    }

    public byte[] N0(char[] cArr, byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(cArr, bArr, 19, 128)).getEncoded(), "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
        instance.init(2, secretKeySpec, ivParameterSpec);
        return instance.doFinal(bArr3);
    }

    public boolean N1(Bundle bundle, String str) {
        String decode = URLDecoder.decode(str);
        if (decode.contains("rx/monograph/")) {
            String valueOf = String.valueOf(Integer.valueOf(t1(StringUtils.splitByWholeSeparator(decode, "rx/monograph/"))).intValue() + 1);
            A1(bundle, "rx-" + valueOf, (String[]) null, (String) null);
            return true;
        } else if (decode.contains("dx/monograph/")) {
            String t1 = t1(StringUtils.splitByWholeSeparator(decode, "dx/monograph/"));
            A1(bundle, "dx-" + t1, (String[]) null, (String) null);
            return true;
        } else if (decode.contains("lab/monograph/")) {
            String t12 = t1(StringUtils.splitByWholeSeparator(decode, "lab/monograph/"));
            A1(bundle, "lab-" + t12, (String[]) null, (String) null);
            return true;
        } else if (decode.contains("lab/list/panel/")) {
            String t13 = t1(StringUtils.splitByWholeSeparator(decode, "lab/list/panel/"));
            Bundle s1 = s1(V(bundle, "Select * from lab_panel where id2=" + t13));
            if (s1 != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putBundle("DB", bundle);
                bundle2.putString("ParentId", s1.getString("id"));
                N(EPOLabListActivity.class, EPOLabListActivityFragment.class, bundle2);
            }
            return true;
        } else if (decode.contains("rx/list/drug?select=")) {
            String replace = t1(StringUtils.splitByWholeSeparator(decode, "rx/list/drug?select=")).replace("*", "");
            Bundle s12 = s1(W(bundle, "select * from drug where name='" + replace + "'", "RX.sqlite"));
            if (s12 == null) {
                x2(this.f29548d, "Sorry, Can't find it", 1);
                return true;
            }
            A1(bundle, "rx-" + s12.getString("ID"), (String[]) null, (String) null);
            return true;
        } else {
            iMDLogger.j("manageEpocrateURL", "Can't manage " + decode);
            return false;
        }
    }

    public void O(Class<?> cls, Class<?> cls2, Bundle bundle) {
        M(cls, cls2, bundle, R.id.f906detail_container);
        SlidingPaneLayout slidingPaneLayout = (SlidingPaneLayout) ((Activity) this.f29548d).findViewById(R.id.f1076sliding_layout);
        if (slidingPaneLayout != null) {
            slidingPaneLayout.c();
        }
    }

    public void O0(char[] cArr, byte[] bArr, byte[] bArr2, FileInputStream fileInputStream, FileOutputStream fileOutputStream) throws Exception {
        CipherInputStream cipherInputStream;
        Source u2;
        BufferedSink d2;
        SecretKeySpec secretKeySpec = new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(cArr, bArr, 19, 128)).getEncoded(), "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
        instance.init(2, secretKeySpec, ivParameterSpec);
        try {
            cipherInputStream = new CipherInputStream(fileInputStream, instance);
            u2 = Okio.u(cipherInputStream);
            d2 = Okio.d(Okio.p(fileOutputStream));
            d2.y1(u2);
            d2.close();
            if (u2 != null) {
                u2.close();
            }
            cipherInputStream.close();
            return;
            throw th;
            throw th;
            throw th;
        } catch (IOException e2) {
            FirebaseCrashlytics.d().g(e2);
            iMDLogger.f(getClass().toString(), "Error in decrypting stream");
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
    }

    public void P(String str) {
        this.f29548d.startActivity(new Intent("android.intent.action.VIEW").setData(Uri.parse(str)));
    }

    public String P1(File file) {
        try {
            if (!file.exists()) {
                return "";
            }
            MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(file);
            String encodeToString = Base64.encodeToString(DigestUtils.md5((InputStream) fileInputStream), 0);
            fileInputStream.close();
            return encodeToString;
        } catch (Exception unused) {
            return "";
        }
    }

    public String Q(String str) {
        return u(str).equals(u(M1())) ? "Internal Storage" : "External Storage";
    }

    public String R() {
        String str = M1() + "/psych.db";
        if (!new File(str).exists()) {
            try {
                SQLiteDatabase openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(str, (SQLiteDatabase.CursorFactory) null);
                openOrCreateDatabase.execSQL("CREATE TABLE tol (_id INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE , name TEXT, time integer, moves integer, dateadded TEXT)");
                openOrCreateDatabase.execSQL("CREATE TABLE igt (_id INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE , name TEXT, money integer, time integer, a integer,b integer,c integer, d integer,pos int,neg int, dateadded TEXT)");
            } catch (Exception e2) {
                FirebaseCrashlytics.d().g(e2);
            }
        }
        return str;
    }

    public void R0(final Runnable runnable, final Runnable runnable2) {
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

    public Cursor S(Bundle bundle, String str) {
        if (bundle.containsKey("Demo")) {
            str = E0(str);
        }
        return U(f1(bundle), str);
    }

    public void S0(String str, String str2) throws IOException {
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        Response execute = builder.i(30, timeUnit).C(100, timeUnit).J(30, timeUnit).d().a(new Request.Builder().q(str).b()).execute();
        if (new File(str2).exists()) {
            new File(str2).delete();
        }
        if (execute.r()) {
            try {
                bufferedInputStream = new BufferedInputStream(execute.b().b(), 8192);
                FileOutputStream fileOutputStream = new FileOutputStream(str2);
                try {
                    bufferedOutputStream = new BufferedOutputStream(fileOutputStream, 8192);
                    byte[] bArr = new byte[1048576];
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        bufferedOutputStream.write(bArr, 0, read);
                    }
                    PrintStream printStream = System.out;
                    printStream.println(str + "File downloaded successfully");
                    bufferedOutputStream.close();
                    fileOutputStream.close();
                    bufferedInputStream.close();
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                throw new IOException("Error during download", e2);
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        } else {
            PrintStream printStream2 = System.out;
            printStream2.println("No file to download. Server replied HTTP code: " + execute.f());
        }
        execute.close();
        return;
        throw th;
        throw th;
    }

    public String S1(String str) {
        return str;
    }

    public Cursor T(Bundle bundle, String str, String str2) {
        if (bundle.containsKey("Demo")) {
            str = E0(str);
        }
        return U(g1(bundle, str2), str);
    }

    public Observable<String> T0(final String str, final String str2) {
        return Observable.w1(new ObservableOnSubscribe<String>() {
            public void a(@NonNull ObservableEmitter<String> observableEmitter) throws Throwable {
                try {
                    CompressHelper.this.S0(str, str2);
                    observableEmitter.onComplete();
                } catch (Exception e2) {
                    iMDLogger.f("DownloadFile", "Error in downloading file " + e2);
                    observableEmitter.onError(e2);
                }
            }
        });
    }

    public String T1(String str) {
        return str;
    }

    public Cursor U(String str, String str2) {
        try {
            return this.f29548d.getContentResolver().query(Uri.parse("content://net.imedicaldoctor.imd/query"), (String[]) null, str, (String[]) null, str2);
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            e2.printStackTrace();
            iMDLogger.f("QueryDB " + str, "Error in Query DB , " + str + ", " + e2.getLocalizedMessage());
            return null;
        }
    }

    public Observable<HttpURLConnection> U0(String str, String str2, Bundle bundle) {
        final String str3 = str2 + ".download";
        final String str4 = str2 + ".md5";
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        final OkHttpClient d2 = builder.i(30, timeUnit).J(30, timeUnit).C(100, timeUnit).d();
        final String str5 = str;
        final String str6 = str2;
        final Bundle bundle2 = bundle;
        return Observable.w1(new ObservableOnSubscribe<HttpURLConnection>() {
            public void a(@NonNull ObservableEmitter<HttpURLConnection> observableEmitter) throws Throwable {
                try {
                    final String t0 = CompressHelper.this.z2(str5);
                    if (CompressHelper.this.A2(str6, str4, bundle2)) {
                        observableEmitter.onComplete();
                        return;
                    }
                    final long v0 = CompressHelper.this.k1(str3);
                    Request.Builder q = new Request.Builder().q(t0);
                    final ObservableEmitter<HttpURLConnection> observableEmitter2 = observableEmitter;
                    d2.a(q.a(HttpHeaders.I, "bytes=" + v0 + "-").b()).e0(new Callback() {
                        /* JADX WARNING: Code restructure failed: missing block: B:33:0x007b, code lost:
                            r3.flush();
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0090, code lost:
                            if (new java.io.File(r8).length() != (r0 + r6)) goto L_0x00a1;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0092, code lost:
                            r0 = r8.f29588d;
                            net.imedicaldoctor.imd.Data.CompressHelper.y0(r0.f29584g, r8, r5, r6, r7);
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
                            r3.close();
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
                            r10.close();
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
                            r9.close();
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:42:0x00aa, code lost:
                            r4.onComplete();
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:43:0x00af, code lost:
                            return;
                         */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public void a(okhttp3.Call r9, okhttp3.Response r10) throws java.io.IOException {
                            /*
                                r8 = this;
                                boolean r9 = r10.r()
                                if (r9 != 0) goto L_0x0022
                                io.reactivex.rxjava3.core.ObservableEmitter r9 = r4
                                java.io.IOException r0 = new java.io.IOException
                                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                                r1.<init>()
                                java.lang.String r2 = "Unexpected code "
                                r1.append(r2)
                                r1.append(r10)
                                java.lang.String r10 = r1.toString()
                                r0.<init>(r10)
                                r9.onError(r0)
                                return
                            L_0x0022:
                                net.imedicaldoctor.imd.Data.CompressHelper$3 r9 = net.imedicaldoctor.imd.Data.CompressHelper.AnonymousClass3.this
                                net.imedicaldoctor.imd.Data.CompressHelper r9 = net.imedicaldoctor.imd.Data.CompressHelper.this
                                java.lang.String r0 = r5
                                long r0 = r9.m1(r0)
                                long r2 = r6
                                long r0 = r0 - r2
                                java.io.BufferedInputStream r9 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x006e }
                                okhttp3.ResponseBody r10 = r10.b()     // Catch:{ IOException -> 0x006e }
                                java.io.InputStream r10 = r10.b()     // Catch:{ IOException -> 0x006e }
                                r2 = 16384(0x4000, float:2.2959E-41)
                                r9.<init>(r10, r2)     // Catch:{ IOException -> 0x006e }
                                java.io.FileOutputStream r10 = new java.io.FileOutputStream     // Catch:{ all -> 0x0070 }
                                net.imedicaldoctor.imd.Data.CompressHelper$3 r3 = net.imedicaldoctor.imd.Data.CompressHelper.AnonymousClass3.this     // Catch:{ all -> 0x0070 }
                                java.lang.String r3 = r8     // Catch:{ all -> 0x0070 }
                                r4 = 1
                                r10.<init>(r3, r4)     // Catch:{ all -> 0x0070 }
                                java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x0072 }
                                r3.<init>(r10, r2)     // Catch:{ all -> 0x0072 }
                                r2 = 1048576(0x100000, float:1.469368E-39)
                                byte[] r2 = new byte[r2]     // Catch:{ all -> 0x0079 }
                            L_0x0051:
                                int r4 = r9.read(r2)     // Catch:{ all -> 0x0079 }
                                r5 = -1
                                if (r4 == r5) goto L_0x007b
                                net.imedicaldoctor.imd.Data.CompressHelper$3 r5 = net.imedicaldoctor.imd.Data.CompressHelper.AnonymousClass3.this     // Catch:{ all -> 0x0079 }
                                net.imedicaldoctor.imd.Data.CompressHelper r6 = net.imedicaldoctor.imd.Data.CompressHelper.this     // Catch:{ all -> 0x0079 }
                                android.os.Bundle r5 = r7     // Catch:{ all -> 0x0079 }
                                boolean r5 = r6.H1(r5)     // Catch:{ all -> 0x0079 }
                                if (r5 != 0) goto L_0x0074
                                r3.close()     // Catch:{ all -> 0x0072 }
                                r10.close()     // Catch:{ all -> 0x0070 }
                                r9.close()     // Catch:{ IOException -> 0x006e }
                                return
                            L_0x006e:
                                r9 = move-exception
                                goto L_0x00cb
                            L_0x0070:
                                r10 = move-exception
                                goto L_0x00c2
                            L_0x0072:
                                r0 = move-exception
                                goto L_0x00b9
                            L_0x0074:
                                r5 = 0
                                r3.write(r2, r5, r4)     // Catch:{ all -> 0x0079 }
                                goto L_0x0051
                            L_0x0079:
                                r0 = move-exception
                                goto L_0x00b0
                            L_0x007b:
                                r3.flush()     // Catch:{ all -> 0x0079 }
                                java.io.File r2 = new java.io.File     // Catch:{ all -> 0x0079 }
                                net.imedicaldoctor.imd.Data.CompressHelper$3 r4 = net.imedicaldoctor.imd.Data.CompressHelper.AnonymousClass3.this     // Catch:{ all -> 0x0079 }
                                java.lang.String r4 = r8     // Catch:{ all -> 0x0079 }
                                r2.<init>(r4)     // Catch:{ all -> 0x0079 }
                                long r4 = r2.length()     // Catch:{ all -> 0x0079 }
                                long r6 = r6     // Catch:{ all -> 0x0079 }
                                long r0 = r0 + r6
                                int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
                                if (r2 != 0) goto L_0x00a1
                                net.imedicaldoctor.imd.Data.CompressHelper$3 r0 = net.imedicaldoctor.imd.Data.CompressHelper.AnonymousClass3.this     // Catch:{ all -> 0x0079 }
                                net.imedicaldoctor.imd.Data.CompressHelper r1 = net.imedicaldoctor.imd.Data.CompressHelper.this     // Catch:{ all -> 0x0079 }
                                java.lang.String r2 = r8     // Catch:{ all -> 0x0079 }
                                java.lang.String r4 = r5     // Catch:{ all -> 0x0079 }
                                java.lang.String r5 = r6     // Catch:{ all -> 0x0079 }
                                android.os.Bundle r0 = r7     // Catch:{ all -> 0x0079 }
                                r1.B2(r2, r4, r5, r0)     // Catch:{ all -> 0x0079 }
                            L_0x00a1:
                                r3.close()     // Catch:{ all -> 0x0072 }
                                r10.close()     // Catch:{ all -> 0x0070 }
                                r9.close()     // Catch:{ IOException -> 0x006e }
                                io.reactivex.rxjava3.core.ObservableEmitter r9 = r4
                                r9.onComplete()
                                return
                            L_0x00b0:
                                r3.close()     // Catch:{ all -> 0x00b4 }
                                goto L_0x00b8
                            L_0x00b4:
                                r1 = move-exception
                                r0.addSuppressed(r1)     // Catch:{ all -> 0x0072 }
                            L_0x00b8:
                                throw r0     // Catch:{ all -> 0x0072 }
                            L_0x00b9:
                                r10.close()     // Catch:{ all -> 0x00bd }
                                goto L_0x00c1
                            L_0x00bd:
                                r10 = move-exception
                                r0.addSuppressed(r10)     // Catch:{ all -> 0x0070 }
                            L_0x00c1:
                                throw r0     // Catch:{ all -> 0x0070 }
                            L_0x00c2:
                                r9.close()     // Catch:{ all -> 0x00c6 }
                                goto L_0x00ca
                            L_0x00c6:
                                r9 = move-exception
                                r10.addSuppressed(r9)     // Catch:{ IOException -> 0x006e }
                            L_0x00ca:
                                throw r10     // Catch:{ IOException -> 0x006e }
                            L_0x00cb:
                                io.reactivex.rxjava3.core.ObservableEmitter r10 = r4
                                r10.onError(r9)
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Data.CompressHelper.AnonymousClass3.AnonymousClass1.a(okhttp3.Call, okhttp3.Response):void");
                        }

                        public void b(Call call, IOException iOException) {
                            observableEmitter2.onError(iOException);
                        }
                    });
                } catch (Exception e2) {
                    observableEmitter.onError(e2);
                }
            }
        });
    }

    public String U1() {
        Context context = this.f29548d;
        if (context == null) {
            return "";
        }
        File externalFilesDir = context.getExternalFilesDir("");
        if (externalFilesDir == null) {
            externalFilesDir = this.f29548d.getFilesDir();
        }
        return externalFilesDir.toString();
    }

    public ArrayList<Bundle> V(Bundle bundle, String str) {
        if (bundle.containsKey("Demo")) {
            str = E0(str);
        }
        return Y(f1(bundle), str);
    }

    public void V0() {
        if (!y2().booleanValue()) {
            t2((String) null);
            Process.killProcess(Process.myPid());
        }
    }

    public ArrayList<Bundle> W(Bundle bundle, String str, String str2) {
        if (bundle.containsKey("Demo")) {
            str = E0(str);
        }
        return Y(g1(bundle, str2), str);
    }

    public void W0() {
        G1();
    }

    public boolean W1(boolean z) {
        String str;
        int i2;
        if (!x1()) {
            ((Activity) this.f29548d).finish();
            ((Activity) this.f29548d).overridePendingTransition(R.anim.f23to_fade_in, R.anim.f24to_fade_out);
            return false;
        }
        if (z) {
            str = v;
            i2 = R.id.f1064rootcontainer;
        } else {
            str = w;
            i2 = R.id.f906detail_container;
        }
        return X1(str, i2);
    }

    public ArrayList<Bundle> X(Bundle bundle, String str, String str2, boolean z) {
        if (bundle.containsKey("Demo")) {
            str = E0(str);
        }
        ArrayList<Bundle> W = W(bundle, str, str2);
        return (W != null || !z) ? W : new ArrayList<>();
    }

    public String X0() {
        String str = M1() + "/favorites.db";
        if (!new File(str).exists()) {
            try {
                SQLiteDatabase.openOrCreateDatabase(str, (SQLiteDatabase.CursorFactory) null).execSQL("CREATE TABLE favorites (_id INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE , dbName TEXT, dbTitle TEXT, dbAddress TEXT, dbDate TEXT, dbDocName TEXT);");
            } catch (Exception e2) {
                FirebaseCrashlytics.d().g(e2);
                new File(str).delete();
                try {
                    SQLiteDatabase.openOrCreateDatabase(str, (SQLiteDatabase.CursorFactory) null).execSQL("CREATE TABLE favorites (_id INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE , dbName TEXT, dbTitle TEXT, dbAddress TEXT, dbDate TEXT, dbDocName TEXT);");
                } catch (Exception unused) {
                }
            }
        }
        return str;
    }

    public boolean X1(String str, int i2) {
        try {
            if (s.get(str).size() == 0) {
                return false;
            }
            if (s.get(str).size() > 1) {
                Fragment fragment = (Fragment) s.get(str).elementAt(s.get(str).size() - 2);
                s.get(str).pop();
                FragmentTransaction u2 = ((AppCompatActivity) this.f29548d).k0().u();
                u2.M(R.anim.f23to_fade_in, R.anim.f24to_fade_out);
                if (x1() && str.equals(w)) {
                    u2.M(R.anim.f14fade_out, R.anim.f13fade_in);
                }
                u2.C(i2, fragment);
                u2.r();
            } else {
                Fragment fragment2 = (Fragment) s.get(str).elementAt(s.get(str).size() - 1);
                s.get(str).pop();
                FragmentTransaction u3 = ((AppCompatActivity) this.f29548d).k0().u();
                u3.M(R.anim.f23to_fade_in, R.anim.f24to_fade_out);
                if (x1() && str.equals(w)) {
                    u3.M(R.anim.f14fade_out, R.anim.f13fade_in);
                }
                u3.B(fragment2);
                u3.r();
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    public void run() {
                        LocalBroadcastManager.b(CompressHelper.this.f29548d).d(new Intent("showLeftPane"));
                    }
                }, 500);
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public ArrayList<Bundle> Y(String str, String str2) {
        try {
            Context context = this.f29548d;
            if (context == null) {
                return null;
            }
            Cursor query = context.getContentResolver().query(Uri.parse("content://net.imedicaldoctor.imd/query"), (String[]) null, str, (String[]) null, str2);
            ArrayList<Bundle> c2 = c(query);
            if (query == null) {
                return null;
            }
            query.close();
            g(str);
            return c2;
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            iMDLogger.f("QueryDBAsArray " + str, "Error in Query DB , " + str + ", " + e2.getLocalizedMessage());
            e2.printStackTrace();
            return null;
        }
    }

    public Bundle Y0(final String str, final String str2) {
        ArrayList<Bundle> arrayList = ((iMD) this.f29548d.getApplicationContext()).s;
        boolean z = true;
        boolean z2 = arrayList == null;
        if (arrayList.size() != 0) {
            z = false;
        }
        if (z || z2) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList(Collections2.d(arrayList, new Predicate<Bundle>() {
            /* renamed from: a */
            public boolean apply(Bundle bundle) {
                try {
                    return bundle.getString(str).equals(str2);
                } catch (Exception e2) {
                    FirebaseCrashlytics.d().g(e2);
                    return false;
                }
            }
        }));
        if (arrayList2.size() == 0) {
            return null;
        }
        return (Bundle) arrayList2.get(0);
    }

    public void Y1(String str, int i2) {
        try {
            if (s.get(str).size() > 1) {
                while (s.get(str).size() == 1) {
                    s.get(str).pop();
                }
            }
            Fragment fragment = (Fragment) s.get(str).elementAt(s.get(str).size() - 1);
            s.get(str).pop();
            FragmentTransaction u2 = ((AppCompatActivity) this.f29548d).k0().u();
            u2.M(R.anim.f23to_fade_in, R.anim.f24to_fade_out);
            if (x1() && str.equals(w)) {
                u2.M(R.anim.f14fade_out, R.anim.f13fade_in);
            }
            u2.B(fragment);
            u2.r();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public ArrayList<String> Z(String str, String str2, String str3) {
        try {
            Cursor query = this.f29548d.getContentResolver().query(Uri.parse("content://net.imedicaldoctor.imd/query"), (String[]) null, str, (String[]) null, str2);
            ArrayList<String> d2 = d(query, str3);
            query.close();
            g(str);
            return d2;
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            iMDLogger.f("QueryDBAsArray " + str, "Error in Query DB , " + str + ", " + e2.getLocalizedMessage());
            e2.printStackTrace();
            return null;
        }
    }

    public ArrayList<Bundle> Z0(final String str, final String str2) {
        return new ArrayList<>(Collections2.d(((iMD) this.f29548d.getApplicationContext()).s, new Predicate<Bundle>() {
            /* renamed from: a */
            public boolean apply(Bundle bundle) {
                try {
                    return bundle.getString(str).equals(str2);
                } catch (Exception e2) {
                    FirebaseCrashlytics.d().g(e2);
                    iMDLogger.f("Error in filtering", e2.getLocalizedMessage());
                    return false;
                }
            }
        }));
    }

    public void Z1(boolean z) {
        String str;
        int i2;
        if (!x1()) {
            Intent intent = new Intent(this.f29548d, mainActivity.class);
            intent.addFlags(67108864);
            this.f29548d.startActivity(intent);
            ((Activity) this.f29548d).overridePendingTransition(R.anim.f23to_fade_in, R.anim.f24to_fade_out);
            return;
        }
        if (z) {
            str = v;
            i2 = R.id.f1064rootcontainer;
        } else {
            str = w;
            i2 = R.id.f906detail_container;
        }
        Y1(str, i2);
    }

    public String a() {
        StringBuilder sb;
        String str;
        VBHelper vBHelper = this.f29550f;
        String[] split = TextUtils.split(vBHelper.x(vBHelper.m()).replace("||", "::"), "::");
        ArrayList arrayList = new ArrayList(Arrays.asList(TextUtils.split(split[3], ",")));
        String str2 = split[2];
        if (arrayList.contains(TtmlNode.r0)) {
            if (str2.length() <= 0) {
                return "All";
            }
            sb = new StringBuilder();
            str = "Active|";
        } else if (!arrayList.contains("expired")) {
            return "Simple";
        } else {
            sb = new StringBuilder();
            str = "Expired|";
        }
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public Observable<ArrayList<Bundle>> a0(final Bundle bundle, final String str) {
        if (bundle.containsKey("Demo")) {
            str = E0(str);
        }
        return Observable.w1(new ObservableOnSubscribe<ArrayList<Bundle>>() {
            public void a(@NonNull ObservableEmitter<ArrayList<Bundle>> observableEmitter) throws Throwable {
                ArrayList<Bundle> V = CompressHelper.this.V(bundle, str);
                if (V != null) {
                    observableEmitter.onNext(V);
                }
                observableEmitter.onComplete();
            }
        });
    }

    public String a1(String str) {
        return str.replace("'", "''");
    }

    public void a2(String str, Fragment fragment, int i2, boolean z, boolean z2) {
        if (z2) {
            try {
                s.get(str).push(fragment);
            } catch (Exception e2) {
                e2.printStackTrace();
                FirebaseCrashlytics.d().g(e2);
                return;
            }
        }
        if (str.equals(w) && s.get(str).size() > 3) {
            s.get(str).removeElementAt(0);
        }
        FragmentTransaction u2 = ((AppCompatActivity) this.f29548d).k0().u();
        if (z) {
            u2.M(R.anim.f15from_fade_in, R.anim.f16from_fade_out);
        }
        if (x1() && str.equals(w)) {
            u2.M(R.anim.f13fade_in, R.anim.f14fade_out);
        }
        u2.C(i2, fragment);
        u2.r();
    }

    public Observable<ArrayList<Bundle>> b0(final Bundle bundle, final String str, final String str2) {
        if (bundle.containsKey("Demo")) {
            str = E0(str);
        }
        return Observable.w1(new ObservableOnSubscribe<ArrayList<Bundle>>() {
            public void a(@NonNull ObservableEmitter<ArrayList<Bundle>> observableEmitter) throws Throwable {
                ArrayList<Bundle> W = CompressHelper.this.W(bundle, str, str2);
                if (W != null) {
                    observableEmitter.onNext(W);
                }
                observableEmitter.onComplete();
            }
        });
    }

    public String b1(String str) {
        return str.replace("&amp;", "&");
    }

    public long b2() {
        long j2;
        Bundle s1 = s1(Y(h2(), "Select c from r where id=2"));
        Date date = new Date();
        if (s1 == null) {
            String h2 = h2();
            q(h2, "INSERT OR IGNORE INTO r values (2," + date.getTime() + ")");
            j2 = date.getTime();
        } else {
            j2 = Long.valueOf(s1.getString("c")).longValue();
        }
        String h22 = h2();
        q(h22, "update r set c=" + date.getTime() + " where id=2");
        return j2;
    }

    public ArrayList<Bundle> c(Cursor cursor) {
        if (cursor == null || !cursor.moveToFirst()) {
            return null;
        }
        ArrayList<Bundle> arrayList = new ArrayList<>(cursor.getCount());
        int columnCount = cursor.getColumnCount();
        do {
            Bundle bundle = new Bundle();
            for (int i2 = 0; i2 < columnCount; i2++) {
                if (cursor.getType(i2) == 4) {
                    bundle.putByteArray(cursor.getColumnName(i2), cursor.getBlob(i2));
                } else {
                    String string = cursor.getString(i2);
                    if (string == null) {
                        string = "";
                    }
                    bundle.putString(cursor.getColumnName(i2), string);
                }
            }
            arrayList.add(bundle);
        } while (cursor.moveToNext());
        cursor.close();
        return arrayList;
    }

    public Observable<ArrayList<Bundle>> c0(final String str, final String str2) {
        return Observable.w1(new ObservableOnSubscribe<ArrayList<Bundle>>() {
            public void a(@NonNull ObservableEmitter<ArrayList<Bundle>> observableEmitter) throws Throwable {
                ArrayList<Bundle> Y = CompressHelper.this.Y(str, str2);
                if (Y != null) {
                    observableEmitter.onNext(Y);
                }
                observableEmitter.onComplete();
            }
        });
    }

    public byte[] c2(String str) {
        BufferedSource e2;
        try {
            e2 = Okio.e(Okio.t(new File(str)));
            byte[] b0 = e2.b0();
            e2.close();
            return b0;
        } catch (IOException e3) {
            FirebaseCrashlytics.d().g(e3);
            String cls = getClass().toString();
            iMDLogger.f(cls, "Error in Reading file: " + str);
            return null;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public ArrayList<String> d(Cursor cursor, String str) {
        if (cursor == null || !cursor.moveToFirst()) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>(cursor.getCount());
        int columnIndex = cursor.getColumnIndex(str);
        do {
            new Bundle();
            arrayList.add(cursor.getString(columnIndex));
        } while (cursor.moveToNext());
        cursor.close();
        return arrayList;
    }

    public ArrayList<Bundle> d0(String str, String str2, int i2) {
        try {
            Cursor query = this.f29548d.getContentResolver().query(Uri.parse("content://net.imedicaldoctor.imd/query"), (String[]) null, str, (String[]) null, str2);
            ArrayList<Bundle> e2 = e(query, i2);
            query.close();
            g(str);
            return e2;
        } catch (Exception e3) {
            FirebaseCrashlytics.d().g(e3);
            iMDLogger.f("QueryDBAsArray " + str, "Error in Query DB , " + str + ", " + e3.getLocalizedMessage());
            e3.printStackTrace();
            return null;
        }
    }

    public ArrayList<Bundle> e(Cursor cursor, int i2) {
        if (cursor == null || !cursor.moveToFirst()) {
            return null;
        }
        ArrayList<Bundle> arrayList = new ArrayList<>(cursor.getCount());
        int columnCount = cursor.getColumnCount();
        int count = cursor.getCount();
        for (int i3 = 0; i3 < count; i3++) {
            Bundle bundle = new Bundle();
            if (i3 < i2) {
                for (int i4 = 0; i4 < columnCount; i4++) {
                    if (cursor.getType(i4) == 4) {
                        bundle.putByteArray(cursor.getColumnName(i4), cursor.getBlob(i4));
                    } else {
                        String string = cursor.getString(i4);
                        if (string == null) {
                            string = "";
                        }
                        bundle.putString(cursor.getColumnName(i4), string);
                    }
                }
                arrayList.add(bundle);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return arrayList;
    }

    public Bundle e0(Bundle bundle, String str) {
        return n1(V(bundle, str));
    }

    public Bundle f0(Bundle bundle, String str, String str2) {
        return n1(W(bundle, str, str2));
    }

    public String f2(String str) {
        try {
            return Okio.e(Okio.t(new File(str))).g1(StandardCharsets.UTF_8);
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            e2.printStackTrace();
            return "";
        }
    }

    public void g(String str) {
        this.f29548d.getContentResolver().query(Uri.parse("content://net.imedicaldoctor.imd/close"), (String[]) null, str, (String[]) null, (String) null);
    }

    public Observable<Cursor> g0(final Bundle bundle, final String str) {
        if (bundle.containsKey("Demo")) {
            str = E0(str);
        }
        return Observable.w1(new ObservableOnSubscribe<Cursor>() {
            public void a(@NonNull ObservableEmitter<Cursor> observableEmitter) throws Throwable {
                Cursor S = CompressHelper.this.S(bundle, str);
                if (S != null) {
                    observableEmitter.onNext(S);
                }
                observableEmitter.onComplete();
            }
        });
    }

    public int g2() {
        Bundle s1 = s1(Y(h2(), "Select c from r where id=1"));
        if (s1 != null) {
            return Integer.valueOf(s1.getString("c")).intValue();
        }
        q(h2(), "INSERT OR IGNORE INTO r values (1,0)");
        return 0;
    }

    public Cursor h(ArrayList<Bundle> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        String[] strArr = (String[]) FluentIterable.D(arrayList.get(0).keySet()).P(String.class);
        MatrixCursor matrixCursor = new MatrixCursor(strArr);
        Iterator<Bundle> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Bundle next = it2.next();
            ArrayList arrayList2 = new ArrayList();
            for (String string : strArr) {
                arrayList2.add(next.getString(string));
            }
            matrixCursor.addRow(arrayList2);
        }
        return matrixCursor;
    }

    public Observable<Cursor> h0(final Bundle bundle, final String str, final String str2) {
        if (bundle.containsKey("Demo")) {
            str = E0(str);
        }
        return Observable.w1(new ObservableOnSubscribe<Cursor>() {
            public void a(@NonNull ObservableEmitter<Cursor> observableEmitter) throws Throwable {
                Cursor T = CompressHelper.this.T(bundle, str, str2);
                if (T != null) {
                    observableEmitter.onNext(T);
                }
                observableEmitter.onComplete();
            }
        });
    }

    public String h2() {
        String str = M1() + "/recent.db";
        try {
            if (!new File(str).exists()) {
                SQLiteDatabase openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(str, (SQLiteDatabase.CursorFactory) null);
                openOrCreateDatabase.execSQL("create table IF NOT EXISTS recent (id integer primary key autoincrement, dbName text, dbTitle text, dbAddress text, dbDate text, dbDocName text);");
                openOrCreateDatabase.execSQL("create table IF NOT EXISTS dbrecent (id integer primary key autoincrement, dbName text, dbTitle text, dbDate text,dbIcon text);");
                openOrCreateDatabase.execSQL("create table IF NOT EXISTS r (id integer primary key autoincrement, c int)");
            }
            if (s1(Y(str, "SELECT name FROM sqlite_master WHERE type='table' AND name='r'")) == null) {
                SQLiteDatabase.openOrCreateDatabase(str, (SQLiteDatabase.CursorFactory) null).execSQL("create table IF NOT EXISTS r (id integer primary key autoincrement, c int)");
            }
        } catch (Exception unused) {
        }
        return str;
    }

    public Cursor i(ArrayList<Bundle> arrayList, String[] strArr) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        Bundle bundle = arrayList.get(0);
        MatrixCursor matrixCursor = new MatrixCursor(strArr);
        Iterator<Bundle> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Bundle next = it2.next();
            ArrayList arrayList2 = new ArrayList();
            for (String string : strArr) {
                arrayList2.add(next.getString(string));
            }
            matrixCursor.addRow(arrayList2);
        }
        return matrixCursor;
    }

    public Observable<Cursor> i0(final String str, final String str2) {
        return Observable.w1(new ObservableOnSubscribe<Cursor>() {
            public void a(@NonNull ObservableEmitter<Cursor> observableEmitter) throws Throwable {
                Cursor U = CompressHelper.this.U(str, str2);
                if (U != null) {
                    observableEmitter.onNext(U);
                }
                observableEmitter.onComplete();
            }
        });
    }

    public Bundle i1(final String str) {
        ArrayList arrayList = new ArrayList(Collections2.d(((iMD) this.f29548d.getApplicationContext()).s, new Predicate<Bundle>() {
            /* renamed from: a */
            public boolean apply(Bundle bundle) {
                return bundle.getString("Name").equals(str);
            }
        }));
        if (arrayList.size() == 0) {
            return null;
        }
        return (Bundle) arrayList.get(0);
    }

    public void i2(File[] fileArr) {
        if (fileArr != null) {
            int i2 = 0;
            while (i2 != fileArr.length) {
                String absolutePath = fileArr[i2].getAbsolutePath();
                if (absolutePath.contains(BuildConfig.f29476b) || absolutePath.contains("Documents/iMD") || absolutePath.contains("Documents/.iMD")) {
                    i2++;
                } else {
                    String str = fileArr[i2].getAbsolutePath() + "||" + fileArr[i2].length() + "||" + fileArr[i2].lastModified();
                    if (this.f29547c != null) {
                        str = this.f29547c + StringUtils.LF + str;
                    }
                    this.f29547c = str;
                    if (fileArr[i2].isDirectory()) {
                        i2(fileArr[i2].listFiles());
                    }
                    i2++;
                    iMDLogger.d(i2 + "", absolutePath);
                }
            }
        }
    }

    public void j(String str) {
        try {
            String replace = str.replace("//", "/");
            System.gc();
            File file = new File(replace);
            file.exists();
            file.setWritable(true, false);
            if (file.delete()) {
                Log.e("DeleteFile", "Delete Successfull . " + replace);
            } else if (!file.getCanonicalFile().delete()) {
                file.deleteOnExit();
            }
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            Log.e("DeleteFile", "Failed to Delete " + str);
        }
    }

    public ArrayList<Bundle> j0(String str) {
        return Y(X0(), str);
    }

    public Bundle j1(final String str) {
        ArrayList arrayList = new ArrayList(Collections2.d(((iMD) this.f29548d.getApplicationContext()).s, new Predicate<Bundle>() {
            /* renamed from: a */
            public boolean apply(Bundle bundle) {
                return bundle.getString("Title").equals(str);
            }
        }));
        if (arrayList.size() == 0) {
            return null;
        }
        return (Bundle) arrayList.get(0);
    }

    public void k(File file) {
        if (file.isDirectory()) {
            for (File k2 : file.listFiles()) {
                k(k2);
            }
        }
        file.delete();
    }

    public void k0() {
        Bundle d2;
        Log.e("Speed", "RefereshDatabaes Started");
        ArrayList<Bundle> arrayList = new ArrayList<>();
        VBHelper vBHelper = this.f29550f;
        if (vBHelper.a(vBHelper.r()) == null) {
            ((iMD) this.f29548d.getApplicationContext()).s = null;
            return;
        }
        Iterator<String> it2 = o1().iterator();
        while (it2.hasNext()) {
            File file = new File(it2.next());
            if (file.listFiles() != null) {
                for (File file2 : file.listFiles()) {
                    if (file2.isDirectory()) {
                        File file3 = new File(file2.getAbsolutePath() + "/info.vbe");
                        if (file3.exists()) {
                            Bundle d3 = this.f29550f.d(file3);
                            if (d3 != null) {
                                Bundle q1 = q1(arrayList, "Name", d3.getString("Name"));
                                if (q1 != null) {
                                    if (q1.getString("Version").compareTo(d3.getString("Version")) >= 0) {
                                        iMDLogger.f("RefereshDatabases", "Delete Older Version");
                                        k(file3.getParentFile());
                                    } else {
                                        iMDLogger.f("RefereshDatabases", "There is an older version");
                                        String string = q1.getString("Path");
                                        arrayList.remove(q1);
                                        iMDLogger.f("Deleting", string);
                                        k(new File(string));
                                    }
                                }
                                d3.putString("Path", file2.getAbsolutePath());
                                arrayList.add(d3);
                            }
                        }
                        File file4 = new File(file2.getAbsolutePath() + "/info2.vbe");
                        if (file4.exists() && (d2 = this.f29550f.d(file4)) != null) {
                            d2.putString("Path", file2.getAbsolutePath());
                            arrayList.add(d2);
                        }
                    }
                }
            }
        }
        ((iMD) this.f29548d.getApplicationContext()).s = arrayList;
        Log.e("Speed", "RefereshDatabaes Ended");
    }

    public void k2() {
        String h2;
        String str;
        if (s1(Y(h2(), "Select c from r where id=1")) == null) {
            h2 = h2();
            str = "INSERT OR IGNORE INTO r values (1,0)";
        } else {
            h2 = h2();
            str = "update r set c=0 where id=1";
        }
        q(h2, str);
    }

    public Observable<String> l(Fragment fragment) {
        iMDLogger.f("DownloadDBs", "Starting");
        return Observable.w1(new ObservableOnSubscribe<String>() {
            public void a(@NonNull ObservableEmitter<String> observableEmitter) throws Throwable {
                if (CompressHelper.x) {
                    iMDLogger.f("DownloadDBs", "is Downloading , Return");
                    return;
                }
                do {
                } while (CompressHelper.x);
                CompressHelper.x = true;
                String str = CompressHelper.this.U1() + "/DBs.z";
                if (new File(CompressHelper.this.U1() + "/DBs.db").exists()) {
                    iMDLogger.f("DownloadDBs", "DB Exist, no need to download");
                    CompressHelper.x = false;
                    observableEmitter.onComplete();
                    return;
                }
                if (new File(str).exists()) {
                    new File(str).delete();
                }
                try {
                    iMDLogger.f("DownloadDBs", "Downloading Zip File");
                    CompressHelper.this.S0(CompressHelper.this.J() + "/dbs.z", str);
                    iMDLogger.f("DownloadDBs", "Downloading Zip File Completed");
                    Decompress decompress = new Decompress(str, CompressHelper.this.U1() + "/", CompressHelper.this.f29548d);
                    iMDLogger.f("CompressHelper", "Extract of dbs.z started");
                    boolean j2 = decompress.j();
                    iMDLogger.f("CompressHelper", "Extract of dbs.z ended");
                    CompressHelper.x = false;
                    if (j2) {
                        iMDLogger.f("CompressHelper", "extract of dbs.z successful");
                        observableEmitter.onComplete();
                        return;
                    }
                    iMDLogger.f("CompressHelper", "extract of dbs.z failed");
                    observableEmitter.onError((Throwable) null);
                } catch (Exception e2) {
                    CompressHelper.x = false;
                    iMDLogger.f("DownloadDBs", "Error in downloading file " + e2);
                    e2.printStackTrace();
                    observableEmitter.onError(e2);
                }
            }
        });
    }

    public void l0() {
        FirebaseMessaging.y().B().e(new OnCompleteListener<String>() {
            public void a(@NonNull Task<String> task) {
                if (!task.v()) {
                    Log.w("RegisterToken", "Fetching FCM registration token failed", task.q());
                    return;
                }
                VBHelper vBHelper = new VBHelper(CompressHelper.this.f29548d);
                CompressHelper compressHelper = CompressHelper.this;
                compressHelper.o0("PushRegistration|||||" + vBHelper.m() + "|||||" + task.r()).h6(Schedulers.e()).s4(AndroidSchedulers.e()).f6(new Consumer<String>() {
                    /* renamed from: a */
                    public void accept(String str) throws Throwable {
                        Log.e("RegisterToken", "Registration Successful");
                    }
                }, new Consumer<Throwable>() {
                    /* renamed from: a */
                    public void accept(Throwable th) throws Throwable {
                    }
                }, new Action() {
                    public void run() throws Throwable {
                    }
                });
            }
        });
    }

    public String l2() {
        BufferedSource e2;
        try {
            e2 = Okio.e(Okio.t(new File(M1() + "/exp.txt")));
            String a2 = e2.a2();
            e2.close();
            return new VBHelper(this.f29548d).j(a2, "127");
        } catch (Exception unused) {
            return "";
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public void m(Bundle bundle, String str) {
        try {
            this.f29548d.getContentResolver().update(Uri.parse("content://net.imedicaldoctor.imd/query"), (ContentValues) null, f1(bundle), new String[]{str});
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            iMDLogger.f("ExecuteDB" + bundle.getString("Name"), "Error in Executing DB , " + f1(bundle) + ", " + e2.getLocalizedMessage());
        }
    }

    public void m0(String str, String str2, String str3, String str4, Bundle bundle) {
        String str5;
        String str6 = str4;
        Bundle bundle2 = bundle;
        ArrayList arrayList = new ArrayList();
        String[] splitByWholeSeparatorPreserveAllTokens = StringUtils.splitByWholeSeparatorPreserveAllTokens(str, ";;;");
        String[] splitByWholeSeparatorPreserveAllTokens2 = StringUtils.splitByWholeSeparatorPreserveAllTokens(str6, ",");
        int length = splitByWholeSeparatorPreserveAllTokens.length;
        int i2 = 0;
        while (i2 < length) {
            String[] splitByWholeSeparatorPreserveAllTokens3 = StringUtils.splitByWholeSeparatorPreserveAllTokens(splitByWholeSeparatorPreserveAllTokens[i2], ":::");
            ArrayList arrayList2 = new ArrayList();
            int length2 = splitByWholeSeparatorPreserveAllTokens3.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length2) {
                String str7 = splitByWholeSeparatorPreserveAllTokens3[i3];
                String str8 = splitByWholeSeparatorPreserveAllTokens2[i4];
                String[] strArr = splitByWholeSeparatorPreserveAllTokens;
                if (bundle2 == null || !bundle2.containsKey(str8)) {
                    str5 = "'" + str7.replace("'", "''") + "'";
                } else {
                    str5 = "'" + bundle2.getString(str8).replace("'", "''") + "'";
                }
                arrayList2.add(str5);
                i4++;
                i3++;
                splitByWholeSeparatorPreserveAllTokens = strArr;
            }
            String[] strArr2 = splitByWholeSeparatorPreserveAllTokens;
            arrayList.add("Insert into " + str3 + " (" + str6 + ") values (" + StringUtils.join((Iterable<?>) arrayList2, ",") + ")");
            i2++;
            splitByWholeSeparatorPreserveAllTokens = strArr2;
        }
        r(str2, (String[]) arrayList.toArray(new String[0]), 0);
    }

    public Bundle m2(Cursor cursor) {
        int columnCount = cursor.getColumnCount();
        Bundle bundle = new Bundle();
        for (int i2 = 0; i2 < columnCount; i2++) {
            String string = cursor.getString(i2);
            if (string == null) {
                string = "";
            }
            bundle.putString(cursor.getColumnName(i2), string);
        }
        return bundle;
    }

    public void n(Bundle bundle, String str, String str2) {
        try {
            this.f29548d.getContentResolver().update(Uri.parse("content://net.imedicaldoctor.imd/query"), (ContentValues) null, g1(bundle, str2), new String[]{str});
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            iMDLogger.f("ExecuteDB" + bundle.getString("Name"), "Error in Executing DB , " + g1(bundle, str2) + ", " + e2.getLocalizedMessage());
        }
    }

    public String n0(String str) {
        Response execute;
        String str2;
        BufferedSource e2;
        String str3 = null;
        try {
            execute = this.f29551g.a(new Request.Builder().q(J() + "/imd.php").l(new FormBody.Builder().a(HTML.Tag.Y, this.f29550f.n(str, "127")).c()).b()).execute();
            if (!execute.r()) {
                e2 = Okio.e(Okio.u(execute.b().b()));
                iMDLogger.f("SendCommand", e2.a2());
                e2.close();
                str2 = null;
            } else {
                str2 = execute.b().r();
            }
            execute.close();
            str3 = str2;
        } catch (IOException e3) {
            iMDLogger.f("SendCommand", "Error in " + e3);
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        if (str3 == null) {
            W0();
        } else {
            n2(WorkQueueKt.f29430c);
            iMDLogger.j("SendCommand result", str3);
        }
        return str3;
        throw th;
        throw th;
    }

    public Bundle n1(ArrayList<Bundle> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        return arrayList.get(0);
    }

    public void n2(int i2) {
        if (i2 == 127) {
            k2();
        }
    }

    public void o(Bundle bundle, String str, String str2, int i2) {
        try {
            this.f29548d.getContentResolver().update(Uri.parse("content://net.imedicaldoctor.imd/query"), (ContentValues) null, g1(bundle, str2), new String[]{"SQLFile", str, String.valueOf(i2)});
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            iMDLogger.f("ExecuteDB" + bundle.getString("Name"), "Error in Executing DB , " + g1(bundle, str2) + ", " + e2.getLocalizedMessage());
        }
    }

    public Observable<String> o0(final String str) {
        return Observable.w1(new ObservableOnSubscribe<String>() {
            public void a(@NonNull ObservableEmitter<String> observableEmitter) throws Throwable {
                String n0 = CompressHelper.this.n0(str);
                if (n0 == null) {
                    observableEmitter.onError(new Throwable("Error Occured"));
                    return;
                }
                String j2 = CompressHelper.this.f29550f.j(n0, "127");
                if (j2 == null) {
                    CompressHelper.this.W0();
                    observableEmitter.onComplete();
                } else {
                    observableEmitter.onNext(j2);
                }
                observableEmitter.onComplete();
            }
        }).h6(Schedulers.e()).s4(AndroidSchedulers.e());
    }

    public HashSet<String> o1() {
        if (((iMD) this.f29548d.getApplicationContext()).Y != null) {
            return ((iMD) this.f29548d.getApplicationContext()).Y;
        }
        HashSet<String> l1 = l1();
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add(M1());
        File[] externalFilesDirs = this.f29548d.getExternalFilesDirs((String) null);
        l1.add("/storage/sdcard1");
        l1.add(Environment.getExternalStorageDirectory().getAbsolutePath());
        Iterator<String> it2 = l1.iterator();
        while (it2.hasNext()) {
            String str = it2.next() + "/Android/data/net.imedicaldoctor.imd/Documents";
            new File(str).mkdirs();
            if (new File(str).exists() && !hashSet.contains(str)) {
                hashSet.add(str);
            }
        }
        Iterator<String> it3 = l1.iterator();
        while (it3.hasNext()) {
            String str2 = it3.next() + "/Android/data/net.imedicaldoctor.imd/.Documents";
            new File(str2).mkdirs();
            if (new File(str2).exists() && !hashSet.contains(str2)) {
                hashSet.add(str2);
            }
        }
        int i2 = 0;
        if (externalFilesDirs != null) {
            try {
                for (File file : externalFilesDirs) {
                    if (file != null) {
                        String str3 = file.getParentFile().getAbsolutePath() + "/Documents";
                        new File(str3).mkdirs();
                        if (new File(str3).exists() && !hashSet.contains(str3)) {
                            hashSet.add(str3);
                        }
                    }
                }
                for (File file2 : externalFilesDirs) {
                    if (file2 != null) {
                        String str4 = file2.getParentFile().getAbsolutePath() + "/.Documents";
                        new File(str4).mkdirs();
                        if (new File(str4).exists() && !hashSet.contains(str4)) {
                            hashSet.add(str4);
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        HashSet hashSet2 = new HashSet();
        ArrayList arrayList = new ArrayList();
        Iterator<String> it4 = hashSet.iterator();
        while (it4.hasNext()) {
            arrayList.add(it4.next());
        }
        while (i2 < arrayList.size() - 1) {
            int i3 = i2 + 1;
            for (int i4 = i3; i4 < arrayList.size(); i4++) {
                try {
                    if (new File((String) arrayList.get(i2)).getCanonicalPath().equals(new File((String) arrayList.get(i4)).getCanonicalPath())) {
                        hashSet2.add((String) arrayList.get(i4));
                    }
                } catch (Exception unused2) {
                }
            }
            i2 = i3;
        }
        Iterator it5 = hashSet2.iterator();
        while (it5.hasNext()) {
            hashSet.remove((String) it5.next());
        }
        ((iMD) this.f29548d.getApplicationContext()).Y = hashSet;
        return hashSet;
    }

    public void o2(ArrayList<Bundle> arrayList) {
        BufferedSink d2;
        Throwable th;
        String str = M1() + "/databases.json";
        ArrayList arrayList2 = new ArrayList();
        JSONArray jSONArray = new JSONArray();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            Bundle bundle = arrayList.get(i2);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("items");
            ArrayList arrayList3 = new ArrayList();
            JSONArray jSONArray2 = new JSONArray();
            int i3 = 0;
            while (i3 < parcelableArrayList.size()) {
                Bundle bundle2 = (Bundle) parcelableArrayList.get(i3);
                String string = bundle2.getString("dontSearch", "0");
                Bundle bundle3 = new Bundle();
                bundle3.putString("Name", bundle2.getString("Name"));
                bundle3.putString("dontSearch", string);
                arrayList3.add(bundle3);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("Name", bundle2.getString("Name"));
                    jSONObject.put("dontSearch", string);
                    jSONArray2.put(jSONObject);
                } catch (Exception unused) {
                }
                i3++;
                ArrayList<Bundle> arrayList4 = arrayList;
            }
            Bundle bundle4 = new Bundle();
            bundle4.putString("title", bundle.getString("title"));
            bundle4.putParcelableArrayList("items", arrayList3);
            arrayList2.add(bundle4);
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("title", bundle.getString("title"));
                jSONObject2.put("items", jSONArray2);
                jSONArray.put(jSONObject2);
            } catch (Exception unused2) {
            }
        }
        String jSONArray3 = jSONArray.toString();
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        try {
            d2 = Okio.d(Okio.n(file));
            d2.W0(jSONArray3);
            d2.close();
            return;
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            iMDLogger.f("Error in writing json", e2.getLocalizedMessage());
            return;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    public void p(Bundle bundle, String[] strArr, String str, int i2) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(Arrays.asList(strArr).subList(i2, strArr.length));
            String[] strArr2 = new String[arrayList.size()];
            arrayList.toArray(strArr2);
            this.f29548d.getContentResolver().update(Uri.parse("content://net.imedicaldoctor.imd/query"), (ContentValues) null, g1(bundle, str), strArr2);
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            iMDLogger.f("ExecuteDB" + bundle.getString("Name"), "Error in Executing DB , " + g1(bundle, str) + ", " + e2.getLocalizedMessage());
        }
    }

    public Observable<String> p0(final String str) {
        return Observable.w1(new ObservableOnSubscribe<String>() {
            public void a(@NonNull ObservableEmitter<String> observableEmitter) throws Throwable {
                try {
                    Thread.sleep(4000);
                } catch (Exception e2) {
                    FirebaseCrashlytics.d().g(e2);
                }
                String j2 = CompressHelper.this.f29550f.j(CompressHelper.this.q0(str), "127");
                if (j2 == null) {
                    CompressHelper.this.W0();
                    observableEmitter.onComplete();
                } else {
                    observableEmitter.onNext(j2);
                }
                observableEmitter.onComplete();
            }
        }).h6(Schedulers.e()).s4(AndroidSchedulers.e());
    }

    public String p1(String str, String str2) throws Exception {
        InputStream inputStream;
        BufferedSource e2;
        String C0 = C0(str2, str2);
        if (C0 != null) {
            return C0;
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(180000);
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == 200) {
            httpURLConnection.getHeaderField(HttpHeaders.a0);
            httpURLConnection.getContentType();
            httpURLConnection.getContentLength();
            try {
                inputStream = httpURLConnection.getInputStream();
                e2 = Okio.e(Okio.u(inputStream));
                String a2 = e2.a2();
                z0(str2, a2, str2);
                e2.close();
                if (inputStream != null) {
                    inputStream.close();
                }
                httpURLConnection.disconnect();
                return a2;
            } catch (IOException e3) {
                throw new Exception("Error reading from input stream", e3);
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        } else {
            throw new Exception("Error in contacting server, response code: " + responseCode);
        }
        throw th;
        throw th;
    }

    public ArrayList<Bundle> p2() {
        Log.e("Speed", "Sections Started");
        ArrayList<Bundle> L1 = L1();
        o2(L1);
        ArrayList<Bundle> arrayList = new ArrayList<>();
        Iterator<Bundle> it2 = L1.iterator();
        while (it2.hasNext()) {
            Iterator it3 = it2.next().getParcelableArrayList("items").iterator();
            while (it3.hasNext()) {
                arrayList.add((Bundle) it3.next());
            }
        }
        t = arrayList;
        Log.e("Speed", "Sections ended");
        return L1;
    }

    public void q(String str, String str2) {
        try {
            this.f29548d.getContentResolver().update(Uri.parse("content://net.imedicaldoctor.imd/query"), (ContentValues) null, str, new String[]{str2});
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            iMDLogger.f("ExecuteDB", "Error in Executing DB , " + str + ", " + e2.getLocalizedMessage());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: type inference failed for: r2v2, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00e4 A[SYNTHETIC, Splitter:B:35:0x00e4] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0109 A[SYNTHETIC, Splitter:B:48:0x0109] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String q0(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r0 = "Error closing stream "
            java.lang.String r1 = "Sendcommand"
            net.imedicaldoctor.imd.VBHelper r2 = r8.f29550f
            java.lang.String r3 = "127"
            java.lang.String r9 = r2.n(r9, r3)
            r2 = 0
            java.net.URL r3 = new java.net.URL     // Catch:{ IOException -> 0x00c4, all -> 0x00c1 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00c4, all -> 0x00c1 }
            r4.<init>()     // Catch:{ IOException -> 0x00c4, all -> 0x00c1 }
            java.lang.String r5 = r8.J()     // Catch:{ IOException -> 0x00c4, all -> 0x00c1 }
            r4.append(r5)     // Catch:{ IOException -> 0x00c4, all -> 0x00c1 }
            java.lang.String r5 = "/imd.php"
            r4.append(r5)     // Catch:{ IOException -> 0x00c4, all -> 0x00c1 }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x00c4, all -> 0x00c1 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x00c4, all -> 0x00c1 }
            java.net.URLConnection r3 = r3.openConnection()     // Catch:{ IOException -> 0x00c4, all -> 0x00c1 }
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ IOException -> 0x00c4, all -> 0x00c1 }
            java.lang.String r4 = "POST"
            r3.setRequestMethod(r4)     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            r4 = 3000(0xbb8, float:4.204E-42)
            r3.setReadTimeout(r4)     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            r3.setConnectTimeout(r4)     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            r4 = 1
            r3.setDoInput(r4)     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            r3.setDoOutput(r4)     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            java.io.OutputStream r4 = r3.getOutputStream()     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            java.io.BufferedWriter r5 = new java.io.BufferedWriter     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            java.io.OutputStreamWriter r6 = new java.io.OutputStreamWriter     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            java.nio.charset.Charset r7 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            r6.<init>(r4, r7)     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            r5.<init>(r6)     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            r6.<init>()     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            java.lang.String r7 = "command="
            r6.append(r7)     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            r6.append(r9)     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            java.lang.String r9 = r6.toString()     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            r5.write(r9)     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            r5.flush()     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            r5.close()     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            r4.close()     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            r3.connect()     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            java.io.InputStream r9 = r3.getInputStream()     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            java.lang.StringBuffer r4 = new java.lang.StringBuffer     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            r4.<init>()     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            r6.<init>(r9)     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            r5.<init>(r6)     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
        L_0x0084:
            java.lang.String r9 = r5.readLine()     // Catch:{ IOException -> 0x0097 }
            if (r9 == 0) goto L_0x0099
            r4.append(r9)     // Catch:{ IOException -> 0x0097 }
            java.lang.String r9 = "\n"
            r4.append(r9)     // Catch:{ IOException -> 0x0097 }
            goto L_0x0084
        L_0x0093:
            r9 = move-exception
        L_0x0094:
            r2 = r3
            goto L_0x0102
        L_0x0097:
            r9 = move-exception
            goto L_0x00c7
        L_0x0099:
            r4.length()     // Catch:{ IOException -> 0x0097 }
            java.lang.String r2 = r4.toString()     // Catch:{ IOException -> 0x0097 }
            r3.disconnect()
            r5.close()     // Catch:{ IOException -> 0x00a7 }
            goto L_0x00ef
        L_0x00a7:
            r9 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
        L_0x00ad:
            r3.append(r0)
            r3.append(r9)
            java.lang.String r9 = r3.toString()
            net.imedicaldoctor.imd.iMDLogger.f(r1, r9)
            goto L_0x00ef
        L_0x00bb:
            r9 = move-exception
            r5 = r2
            goto L_0x0094
        L_0x00be:
            r9 = move-exception
            r5 = r2
            goto L_0x00c7
        L_0x00c1:
            r9 = move-exception
            r5 = r2
            goto L_0x0102
        L_0x00c4:
            r9 = move-exception
            r3 = r2
            r5 = r3
        L_0x00c7:
            java.lang.String r4 = "Sendcommand "
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0093 }
            r6.<init>()     // Catch:{ all -> 0x0093 }
            java.lang.String r7 = "Error in "
            r6.append(r7)     // Catch:{ all -> 0x0093 }
            r6.append(r9)     // Catch:{ all -> 0x0093 }
            java.lang.String r9 = r6.toString()     // Catch:{ all -> 0x0093 }
            net.imedicaldoctor.imd.iMDLogger.f(r4, r9)     // Catch:{ all -> 0x0093 }
            if (r3 == 0) goto L_0x00e2
            r3.disconnect()
        L_0x00e2:
            if (r5 == 0) goto L_0x00ef
            r5.close()     // Catch:{ IOException -> 0x00e8 }
            goto L_0x00ef
        L_0x00e8:
            r9 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            goto L_0x00ad
        L_0x00ef:
            if (r2 != 0) goto L_0x00f5
            r8.W0()
            goto L_0x00fa
        L_0x00f5:
            r9 = 127(0x7f, float:1.78E-43)
            r8.n2(r9)
        L_0x00fa:
            if (r2 == 0) goto L_0x0101
            java.lang.String r9 = "Sendcommand result"
            net.imedicaldoctor.imd.iMDLogger.j(r9, r2)
        L_0x0101:
            return r2
        L_0x0102:
            if (r2 == 0) goto L_0x0107
            r2.disconnect()
        L_0x0107:
            if (r5 == 0) goto L_0x0120
            r5.close()     // Catch:{ IOException -> 0x010d }
            goto L_0x0120
        L_0x010d:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            r3.append(r2)
            java.lang.String r0 = r3.toString()
            net.imedicaldoctor.imd.iMDLogger.f(r1, r0)
        L_0x0120:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Data.CompressHelper.q0(java.lang.String):java.lang.String");
    }

    public ArrayList<Bundle> q2(ArrayList<Bundle> arrayList) {
        return r2(arrayList, "Section");
    }

    public void r(String str, String[] strArr, int i2) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(Arrays.asList(strArr).subList(i2, strArr.length));
            String[] strArr2 = new String[arrayList.size()];
            arrayList.toArray(strArr2);
            this.f29548d.getContentResolver().update(Uri.parse("content://net.imedicaldoctor.imd/query"), (ContentValues) null, str, strArr2);
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            iMDLogger.f("ExecuteDB" + str, "Error in Executing DB , " + str + ", " + e2.getLocalizedMessage());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: type inference failed for: r2v2, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00e4 A[SYNTHETIC, Splitter:B:35:0x00e4] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0109 A[SYNTHETIC, Splitter:B:48:0x0109] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String r0(byte[] r9) {
        /*
            r8 = this;
            java.lang.String r0 = "Error closing stream "
            java.lang.String r1 = "Sendcommand"
            net.imedicaldoctor.imd.VBHelper r2 = r8.f29550f
            java.lang.String r3 = "127"
            java.lang.String r9 = r2.p(r9, r3)
            r2 = 0
            java.net.URL r3 = new java.net.URL     // Catch:{ IOException -> 0x00c4, all -> 0x00c1 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00c4, all -> 0x00c1 }
            r4.<init>()     // Catch:{ IOException -> 0x00c4, all -> 0x00c1 }
            java.lang.String r5 = r8.J()     // Catch:{ IOException -> 0x00c4, all -> 0x00c1 }
            r4.append(r5)     // Catch:{ IOException -> 0x00c4, all -> 0x00c1 }
            java.lang.String r5 = "/imd.php"
            r4.append(r5)     // Catch:{ IOException -> 0x00c4, all -> 0x00c1 }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x00c4, all -> 0x00c1 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x00c4, all -> 0x00c1 }
            java.net.URLConnection r3 = r3.openConnection()     // Catch:{ IOException -> 0x00c4, all -> 0x00c1 }
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ IOException -> 0x00c4, all -> 0x00c1 }
            java.lang.String r4 = "POST"
            r3.setRequestMethod(r4)     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            r4 = 3000(0xbb8, float:4.204E-42)
            r3.setReadTimeout(r4)     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            r3.setConnectTimeout(r4)     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            r4 = 1
            r3.setDoInput(r4)     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            r3.setDoOutput(r4)     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            java.io.OutputStream r4 = r3.getOutputStream()     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            java.io.BufferedWriter r5 = new java.io.BufferedWriter     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            java.io.OutputStreamWriter r6 = new java.io.OutputStreamWriter     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            java.nio.charset.Charset r7 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            r6.<init>(r4, r7)     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            r5.<init>(r6)     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            r6.<init>()     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            java.lang.String r7 = "command="
            r6.append(r7)     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            r6.append(r9)     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            java.lang.String r9 = r6.toString()     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            r5.write(r9)     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            r5.flush()     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            r5.close()     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            r4.close()     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            r3.connect()     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            java.io.InputStream r9 = r3.getInputStream()     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            java.lang.StringBuffer r4 = new java.lang.StringBuffer     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            r4.<init>()     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            r6.<init>(r9)     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            r5.<init>(r6)     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
        L_0x0084:
            java.lang.String r9 = r5.readLine()     // Catch:{ IOException -> 0x0097 }
            if (r9 == 0) goto L_0x0099
            r4.append(r9)     // Catch:{ IOException -> 0x0097 }
            java.lang.String r9 = "\n"
            r4.append(r9)     // Catch:{ IOException -> 0x0097 }
            goto L_0x0084
        L_0x0093:
            r9 = move-exception
        L_0x0094:
            r2 = r3
            goto L_0x0102
        L_0x0097:
            r9 = move-exception
            goto L_0x00c7
        L_0x0099:
            r4.length()     // Catch:{ IOException -> 0x0097 }
            java.lang.String r2 = r4.toString()     // Catch:{ IOException -> 0x0097 }
            r3.disconnect()
            r5.close()     // Catch:{ IOException -> 0x00a7 }
            goto L_0x00ef
        L_0x00a7:
            r9 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
        L_0x00ad:
            r3.append(r0)
            r3.append(r9)
            java.lang.String r9 = r3.toString()
            net.imedicaldoctor.imd.iMDLogger.f(r1, r9)
            goto L_0x00ef
        L_0x00bb:
            r9 = move-exception
            r5 = r2
            goto L_0x0094
        L_0x00be:
            r9 = move-exception
            r5 = r2
            goto L_0x00c7
        L_0x00c1:
            r9 = move-exception
            r5 = r2
            goto L_0x0102
        L_0x00c4:
            r9 = move-exception
            r3 = r2
            r5 = r3
        L_0x00c7:
            java.lang.String r4 = "Sendcommand "
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0093 }
            r6.<init>()     // Catch:{ all -> 0x0093 }
            java.lang.String r7 = "Error in "
            r6.append(r7)     // Catch:{ all -> 0x0093 }
            r6.append(r9)     // Catch:{ all -> 0x0093 }
            java.lang.String r9 = r6.toString()     // Catch:{ all -> 0x0093 }
            net.imedicaldoctor.imd.iMDLogger.f(r4, r9)     // Catch:{ all -> 0x0093 }
            if (r3 == 0) goto L_0x00e2
            r3.disconnect()
        L_0x00e2:
            if (r5 == 0) goto L_0x00ef
            r5.close()     // Catch:{ IOException -> 0x00e8 }
            goto L_0x00ef
        L_0x00e8:
            r9 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            goto L_0x00ad
        L_0x00ef:
            if (r2 != 0) goto L_0x00f5
            r8.W0()
            goto L_0x00fa
        L_0x00f5:
            r9 = 127(0x7f, float:1.78E-43)
            r8.n2(r9)
        L_0x00fa:
            if (r2 == 0) goto L_0x0101
            java.lang.String r9 = "Sendcommand result"
            net.imedicaldoctor.imd.iMDLogger.j(r9, r2)
        L_0x0101:
            return r2
        L_0x0102:
            if (r2 == 0) goto L_0x0107
            r2.disconnect()
        L_0x0107:
            if (r5 == 0) goto L_0x0120
            r5.close()     // Catch:{ IOException -> 0x010d }
            goto L_0x0120
        L_0x010d:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            r3.append(r2)
            java.lang.String r0 = r3.toString()
            net.imedicaldoctor.imd.iMDLogger.f(r1, r0)
        L_0x0120:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Data.CompressHelper.r0(byte[]):java.lang.String");
    }

    public JSONObject r1(JSONArray jSONArray, String str, String str2) {
        int i2 = 0;
        while (i2 < jSONArray.length()) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                if (jSONObject.getString(str).equals(str2)) {
                    return jSONObject;
                }
                i2++;
            } catch (Exception e2) {
                FirebaseCrashlytics.d().g(e2);
                iMDLogger.f("Error in getJSONObjectFromArray", e2.getLocalizedMessage());
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public ArrayList<Bundle> r2(ArrayList<Bundle> arrayList, String str) {
        ArrayList<Bundle> arrayList2 = new ArrayList<>();
        String str2 = null;
        if (arrayList == null) {
            return null;
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator<Bundle> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Bundle next = it2.next();
            String string = next.getString(str);
            if (str2 == null) {
                arrayList3.add(next);
            } else if (str2.equals(string)) {
                arrayList3.add(next);
            } else {
                Bundle bundle = new Bundle();
                bundle.putString("title", str2);
                bundle.putParcelableArrayList("items", arrayList3);
                arrayList2.add(bundle);
                ArrayList arrayList4 = new ArrayList();
                arrayList4.add(next);
                arrayList3 = arrayList4;
            }
            str2 = string;
        }
        if (str2 != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("title", str2);
            bundle2.putParcelableArrayList("items", arrayList3);
            arrayList2.add(bundle2);
        }
        return arrayList2;
    }

    public void s(String str) {
        try {
            this.f29548d.getContentResolver().update(Uri.parse("content://net.imedicaldoctor.imd/query"), (ContentValues) null, X0(), new String[]{str});
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            iMDLogger.f("ExecuteDB", "Error in Executing DB , " + X0() + ", " + e2.getLocalizedMessage());
        }
    }

    public String s0(String str, String str2, String str3, Bundle bundle) {
        ArrayList<Bundle> Y = Y(str, str2);
        if (Y == null || Y.isEmpty()) {
            return "";
        }
        String[] splitByWholeSeparatorPreserveAllTokens = StringUtils.splitByWholeSeparatorPreserveAllTokens(str3, ",");
        StringBuilder sb = new StringBuilder();
        Iterator<Bundle> it2 = Y.iterator();
        while (it2.hasNext()) {
            Bundle next = it2.next();
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < splitByWholeSeparatorPreserveAllTokens.length; i2++) {
                String str4 = splitByWholeSeparatorPreserveAllTokens[i2];
                String string = (bundle == null || !bundle.containsKey(str4)) ? next.getString(str4) : bundle.getString(str4);
                if (i2 > 0) {
                    sb2.append(":::");
                }
                sb2.append(string);
            }
            if (sb.length() > 0) {
                sb.append(";;;");
            }
            sb.append(sb2);
        }
        return sb.toString();
    }

    public Bundle s1(ArrayList<Bundle> arrayList) {
        return z(arrayList);
    }

    public ArrayList<Bundle> s2(ArrayList<Bundle> arrayList, String str) {
        ArrayList<Bundle> arrayList2 = new ArrayList<>();
        if (arrayList == null) {
            return null;
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator<Bundle> it2 = arrayList.iterator();
        String str2 = "";
        while (it2.hasNext()) {
            Bundle next = it2.next();
            String lowerCase = next.getString(str).substring(0, 1).toLowerCase();
            String upperCase = !"abcdefghijklmnopqrstuvwxyz".contains(lowerCase) ? "#" : lowerCase.toUpperCase();
            if (str2.length() != 0) {
                if (str2.equals(upperCase)) {
                    arrayList3.add(next);
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putString("title", str2);
                    bundle.putParcelableArrayList("items", arrayList3);
                    arrayList2.add(bundle);
                    arrayList3 = new ArrayList();
                }
            }
            arrayList3.add(next);
            str2 = upperCase;
        }
        if (str2.length() > 0) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("title", str2);
            bundle2.putParcelableArrayList("items", arrayList3);
            arrayList2.add(bundle2);
        }
        return arrayList2;
    }

    public int t(String str) {
        String[] splitByWholeSeparatorPreserveAllTokens = StringUtils.splitByWholeSeparatorPreserveAllTokens(str, ";;;");
        if (splitByWholeSeparatorPreserveAllTokens.length > 0) {
            return StringUtils.splitByWholeSeparatorPreserveAllTokens(splitByWholeSeparatorPreserveAllTokens[0], ":::").length;
        }
        return 0;
    }

    public String t1(String[] strArr) {
        return strArr[strArr.length - 1];
    }

    public void t2(String str) {
        (str == null ? this.f29548d.getSharedPreferences("default_preferences", 0).edit().remove("ActivationCode") : this.f29548d.getSharedPreferences("default_preferences", 0).edit().putString("ActivationCode", str)).commit();
    }

    public String u(String str) {
        String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(str, "/");
        return splitByWholeSeparator[0] + "/" + splitByWholeSeparator[1];
    }

    public void u2(String str, String str2) {
        Intent intent = new Intent("android.intent.action.SEND");
        File file = new File(str);
        if (file.exists()) {
            intent.setType(str2);
            Context context = this.f29548d;
            Uri h2 = FileProvider.h(context, this.f29548d.getApplicationContext().getPackageName() + ".provider", file);
            intent.putExtra("android.intent.extra.STREAM", h2);
            intent.addFlags(1);
            Intent createChooser = Intent.createChooser(intent, "Share File");
            for (ResolveInfo resolveInfo : this.f29548d.getPackageManager().queryIntentActivities(createChooser, 65536)) {
                this.f29548d.grantUriPermission(resolveInfo.activityInfo.packageName, h2, 3);
            }
            this.f29548d.startActivity(createChooser);
        }
    }

    public byte[] v(String str, String str2, String str3) {
        if (!str3.equals("127")) {
            return null;
        }
        try {
            VBHelper vBHelper = this.f29550f;
            String str4 = TextUtils.split(vBHelper.x(vBHelper.m()).replace("||", "::"), "::")[1];
            byte[] decode = Base64.decode(str, 0);
            for (int length = str2.length(); length < 8; length++) {
                str2 = str2 + StringUtils.SPACE;
            }
            try {
                try {
                    return e1(N0(str4.toCharArray(), str2.getBytes(StandardCharsets.UTF_8), new byte[]{17, 115, 105, 102, 103, 104, 111, 107, 108, 122, 120, 119, 118, 98, 110, 109}, decode));
                } catch (Exception e2) {
                    iMDLogger.f("CompressHelper _ GetData Decompressing", e2.toString());
                    return null;
                }
            } catch (Exception e3) {
                iMDLogger.f("CompressHelper _ GetData Decryption", e3.toString());
                return null;
            }
        } catch (Exception e4) {
            FirebaseCrashlytics.d().g(e4);
            FirebaseCrashlytics.d().g(e4);
            return null;
        }
    }

    public void v2(String str) {
        new AlertDialog.Builder(this.f29548d, R.style.f2185alertDialogTheme).l(str).p("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
            }
        }).I();
    }

    public byte[] w(byte[] bArr, String str, String str2) {
        if (!str2.equals("127")) {
            return null;
        }
        VBHelper vBHelper = this.f29550f;
        String str3 = TextUtils.split(vBHelper.x(vBHelper.m()).replace("||", "::"), "::")[1];
        for (int length = str.length(); length < 8; length++) {
            str = str + StringUtils.SPACE;
        }
        try {
            return N0(str3.toCharArray(), str.getBytes(StandardCharsets.UTF_8), new byte[]{17, 115, 105, 102, 103, 104, 111, 107, 108, 122, 120, 119, 118, 98, 110, 109}, bArr);
        } catch (Exception e2) {
            iMDLogger.f("CompressHelper _ GetData Decryption", e2.toString());
            return null;
        }
    }

    public ArrayList<String> w1() {
        HashSet<String> o1 = o1();
        Bundle bundle = new Bundle();
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<String> it2 = o1.iterator();
        while (it2.hasNext()) {
            String next = it2.next();
            long usableSpace = new File(next).getUsableSpace();
            if (!bundle.containsKey(String.valueOf(usableSpace))) {
                String replace = next.replace("Android/data/net.imedicaldoctor.imd/Documents", "").replace("Android/data/net.imedicaldoctor.imd/.Documents", "").replace("Documents/iMD", "").replace("Documents/.iMD", "");
                bundle.putString(String.valueOf(usableSpace), replace);
                arrayList.add(replace);
            }
        }
        return arrayList;
    }

    public void w2(String str, final Runnable runnable) {
        new AlertDialog.Builder(this.f29548d, R.style.f2185alertDialogTheme).l(str).p("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                runnable.run();
            }
        }).I();
    }

    public byte[] x(byte[] bArr, String str, String str2) {
        if (!str2.equals("127")) {
            return null;
        }
        VBHelper vBHelper = this.f29550f;
        String str3 = TextUtils.split(vBHelper.x(vBHelper.m()).replace("||", "::"), "::")[1];
        for (int length = str.length(); length < 8; length++) {
            str = str + StringUtils.SPACE;
        }
        try {
            return N0(str3.toCharArray(), str.getBytes(StandardCharsets.UTF_8), new byte[]{17, 115, 105, 102, 103, 104, 111, 107, 108, 122, 120, 119, 118, 98, 110, 109}, bArr);
        } catch (Exception e2) {
            iMDLogger.f("CompressHelper _ GetData Decryption", e2.toString());
            return null;
        }
    }

    public boolean x1() {
        if (this.f29548d.getSharedPreferences("default_preferences", 0).getBoolean("mobile", false)) {
            return false;
        }
        return this.f29548d.getResources().getBoolean(R.bool.isTablet);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004a A[Catch:{ Exception -> 0x003a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String y() {
        /*
            r5 = this;
            java.lang.String r0 = "DownloadPath"
            java.lang.String r1 = "default_preferences"
            android.content.Context r2 = r5.f29548d
            android.content.Context r2 = r2.getApplicationContext()
            net.imedicaldoctor.imd.iMD r2 = (net.imedicaldoctor.imd.iMD) r2
            java.lang.String r2 = r2.Z
            if (r2 == 0) goto L_0x001b
            android.content.Context r0 = r5.f29548d
            android.content.Context r0 = r0.getApplicationContext()
            net.imedicaldoctor.imd.iMD r0 = (net.imedicaldoctor.imd.iMD) r0
            java.lang.String r0 = r0.Z
            return r0
        L_0x001b:
            android.content.Context r2 = r5.f29548d     // Catch:{ Exception -> 0x003a }
            r3 = 0
            android.content.SharedPreferences r2 = r2.getSharedPreferences(r1, r3)     // Catch:{ Exception -> 0x003a }
            java.lang.String r4 = ""
            java.lang.String r2 = r2.getString(r0, r4)     // Catch:{ Exception -> 0x003a }
            int r4 = r2.length()     // Catch:{ Exception -> 0x003a }
            if (r4 == 0) goto L_0x003c
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x003a }
            r4.<init>(r2)     // Catch:{ Exception -> 0x003a }
            boolean r4 = r4.exists()     // Catch:{ Exception -> 0x003a }
            if (r4 != 0) goto L_0x0040
            goto L_0x003c
        L_0x003a:
            r0 = move-exception
            goto L_0x0071
        L_0x003c:
            java.lang.String r2 = r5.M1()     // Catch:{ Exception -> 0x003a }
        L_0x0040:
            java.util.HashSet r4 = r5.o1()     // Catch:{ Exception -> 0x003a }
            boolean r4 = r4.contains(r2)     // Catch:{ Exception -> 0x003a }
            if (r4 != 0) goto L_0x0083
            java.lang.String r2 = r5.M1()     // Catch:{ Exception -> 0x003a }
            android.content.Context r4 = r5.f29548d     // Catch:{ Exception -> 0x003a }
            android.content.SharedPreferences r4 = r4.getSharedPreferences(r1, r3)     // Catch:{ Exception -> 0x003a }
            android.content.SharedPreferences$Editor r4 = r4.edit()     // Catch:{ Exception -> 0x003a }
            android.content.SharedPreferences$Editor r4 = r4.remove(r0)     // Catch:{ Exception -> 0x003a }
            r4.commit()     // Catch:{ Exception -> 0x003a }
            android.content.Context r4 = r5.f29548d     // Catch:{ Exception -> 0x003a }
            android.content.SharedPreferences r1 = r4.getSharedPreferences(r1, r3)     // Catch:{ Exception -> 0x003a }
            android.content.SharedPreferences$Editor r1 = r1.edit()     // Catch:{ Exception -> 0x003a }
            android.content.SharedPreferences$Editor r0 = r1.putString(r0, r2)     // Catch:{ Exception -> 0x003a }
            r0.commit()     // Catch:{ Exception -> 0x003a }
            goto L_0x0083
        L_0x0071:
            com.google.firebase.crashlytics.FirebaseCrashlytics r1 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()
            r1.g(r0)
            com.google.firebase.crashlytics.FirebaseCrashlytics r1 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()
            r1.g(r0)
            java.lang.String r2 = r5.M1()
        L_0x0083:
            android.content.Context r0 = r5.f29548d
            android.content.Context r0 = r0.getApplicationContext()
            net.imedicaldoctor.imd.iMD r0 = (net.imedicaldoctor.imd.iMD) r0
            r0.Z = r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Data.CompressHelper.y():java.lang.String");
    }

    public String y1() {
        VBHelper vBHelper = this.f29550f;
        String x2 = vBHelper.x(vBHelper.m());
        return x2 == null ? "Nousername" : TextUtils.split(x2.replace("||", "::"), "::")[9];
    }

    public Boolean y2() {
        if (this.f29550f.r().equals("")) {
            return Boolean.TRUE;
        }
        VBHelper vBHelper = this.f29550f;
        String[] split = TextUtils.split(vBHelper.x(vBHelper.m()).replace("||", "::"), "::");
        if (split.length < 12) {
            C2("Parts less than 12 . parts length = " + split.length);
            return Boolean.FALSE;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(TextUtils.split(split[3], ",")));
        String str = split[8];
        String F1 = F1("NSDate" + split[2] + split[3] + split[10] + split[9] + "NSString");
        if (F1("NSDate" + F1).equals(str)) {
            Log.d("Validation", "Check hash passed");
            Date date = new Date(Long.parseLong(split[10]) * 1000);
            TimeUnit timeUnit = TimeUnit.HOURS;
            TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
            long convert = timeUnit.convert(new Date().getTime() - date.getTime(), timeUnit2);
            if (convert > 240) {
                C2("Server Date and System Date Mismatch . Server Date : " + date.getTime() + ", System Date : " + new Date().getTime());
                return Boolean.FALSE;
            } else if (convert < -240) {
                C2("Server Date and System Date Mismatch . Server Date : " + date.getTime() + ", System Date : " + new Date().getTime());
                return Boolean.FALSE;
            } else {
                Log.d("Validation", "Check server date passed");
                String str2 = split[2];
                if (str2.length() > 2) {
                    long convert2 = TimeUnit.DAYS.convert(new Date(Long.parseLong(str2) * 1000).getTime() - new Date().getTime(), timeUnit2);
                    if (convert2 < 0) {
                        if (!arrayList.contains("expired")) {
                            C2("VIP Account Expired. Days Remaining : " + convert2);
                            return Boolean.FALSE;
                        } else if (arrayList.contains(TtmlNode.r0)) {
                            C2("VIP Account Expired. Days Remaining : " + convert2);
                            return Boolean.FALSE;
                        }
                    }
                }
                Log.d("Validation", "Check DOE passed");
                if (split[11].equals("0")) {
                    l0();
                }
                int g2 = g2();
                Log.d("Validation", "C = " + g2);
                if (g2 > 5000) {
                    C2("C Exceeded 5000. Counter : " + g2);
                    n2(WorkQueueKt.f29430c);
                    return Boolean.FALSE;
                }
                long convert3 = timeUnit.convert(new Date().getTime() - b2(), timeUnit2);
                if (convert3 < -48) {
                    C2("D Failed. Hours : " + convert3);
                    Log.d("Validation", "D failed . hours = " + convert3);
                    return Boolean.FALSE;
                }
                Log.d("Validation", "D Succeed");
                return Boolean.TRUE;
            }
        } else {
            C2("Hash Validation Failed");
            return Boolean.FALSE;
        }
    }

    public Bundle z(ArrayList<Bundle> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        return arrayList.get(arrayList.size() - 1);
    }

    public void z0(String str, String str2, String str3) {
        String a1 = a1(str);
        String a12 = a1(str2);
        String a13 = a1(str3);
        String D0 = D0();
        q(D0, "INSERT OR REPLACE into cache (cachekey, cachecontent, cachevalidation) values ('" + a1 + "', '" + a12 + "', '" + a13 + "')");
    }

    public void z1(Bundle bundle) {
        Class cls;
        Class cls2;
        String string = bundle.getString("Type");
        String string2 = bundle.getString("Name");
        Bundle bundle2 = new Bundle();
        bundle2.putBundle("DB", bundle);
        if (this.f29550f.y(bundle.getString("Name"), bundle.getString("Version"), new StringBuilder()) || bundle.containsKey("Demo")) {
            B0(bundle.getString("Name"), bundle.getString("Title"), C(bundle));
            if (string.equals("elsevier") || string.equals("elseviernew")) {
                cls = ELSChaptersActivity.class;
                cls2 = ELSChaptersActivity.ELSChaptersFragment.class;
            } else if (string.equals("uptodate")) {
                cls = UTDSearchActivity.class;
                cls2 = UTDSearchActivity.UTDSearchFragment.class;
            } else if (string.equals("nejm")) {
                cls = NEJMTOCActivity.class;
                cls2 = NEJMTOCActivity.NEJMTOCFragment.class;
            } else if (string.equals("utdadvanced")) {
                cls = UTDASearchActivity.class;
                cls2 = UTDASearchActivityFragment.class;
            } else if (string.equals("accessmedicine")) {
                bundle2.putString("ParentId", "0");
                cls = AMChaptersActivity.class;
                cls2 = AMChaptersActivity.AMChaptersFragment.class;
            } else if (string2.equals("interact.db")) {
                cls = LXInteractList.class;
                cls2 = LXInteractList.LXInteractListFragment.class;
            } else if (string2.equals("ivcompat.db")) {
                cls = LXIvInteract.class;
                cls2 = LXIvInteract.LXIvInteractFragment.class;
            } else if (string.equals("skyscape")) {
                cls = SSSearchActivity.class;
                cls2 = SSSearchActivity.SSSearchFragment.class;
            } else if (string.equals("ovid")) {
                cls = OvidChaptersActivity.class;
                cls2 = OvidChaptersActivity.OvidChaptersFragment.class;
            } else if (string.equals("irandarou")) {
                cls = IDSearchActivity.class;
                cls2 = IDSearchActivity.IDSearchFragment.class;
            } else if (string.equals("uptodateddx")) {
                cls = UTDDSearchActivity.class;
                cls2 = UTDDSearchActivity.UTDDSearchFragment.class;
            } else if (string.equals("visualdx")) {
                cls = VDSearchActivity.class;
                cls2 = VDSearchActivity.VDSearchFragment.class;
            } else if (string.equals("visualdxddx")) {
                cls = VDDxScenarioActivity.class;
                cls2 = VDDxScenarioActivity.VDDxScenarioFragment.class;
            } else if (string.equals("Dictionary")) {
                cls = CDicSearchActivity.class;
                cls2 = CDicSearchActivity.CDicSearchFragment.class;
            } else if (string.equals("medhand")) {
                cls = MHSearchActivity.class;
                cls2 = MHSearchActivity.MHSearchFragment.class;
            } else if (string.equals("epub")) {
                bundle2.putString("ParentId", "0");
                cls = EPUBChaptersActivity.class;
                cls2 = EPUBChaptersActivityFragment.class;
            } else if (string.equals("epocrate")) {
                cls = EPOMainActivity.class;
                cls2 = EPOMainActivityFragment.class;
            } else if (string.equals("martindale")) {
                cls = MDListActivity.class;
                cls2 = MDListActivityFragment.class;
            } else if (string.equals("amirsys")) {
                cls = ASListActivity.class;
                cls2 = ASListActivityFragment.class;
            } else if (string.equals("statdx")) {
                cls = SDListActivity.class;
                cls2 = SDListActivityFragment.class;
            } else if (string.equals("facts")) {
                cls = FTListActivity.class;
                cls2 = FTListActivityFragment.class;
            } else if (string.equals("micromedex-drug")) {
                cls = MMListActivity.class;
                cls2 = MMListActivityFragment.class;
            } else if (string.equals("micromedex-neofax")) {
                cls = MMNeoListActivity.class;
                cls2 = MMNeoListActivityFragment.class;
            } else if (string.equals("micromedex-interact")) {
                cls = MMInteractSelectActivity.class;
                cls2 = MMInteractSelectActivityFragment.class;
            } else if (string.equals("micromedex-iv")) {
                cls = MMIVSelectActivity.class;
                cls2 = MMIVSelectActivityFragment.class;
            } else if (string.equals("sanford")) {
                cls = SANTocActivity.class;
                cls2 = SANTocActivityFragment.class;
            } else if (string.equals("uworld")) {
                cls = UWMainActivity.class;
                cls2 = UWMainActivityFragment.class;
            } else if (string.equals("irqbank")) {
                cls = DREMainActivity.class;
                cls2 = DREMainActivityFragment.class;
            } else if (string.equals("noskhe")) {
                cls = NOSListActivity.class;
                cls2 = NOSListActivityFragment.class;
            } else if (string.equals("irandrugs")) {
                cls = IranGenericDrugsList.class;
                cls2 = IranGenericDrugsListFragment.class;
            } else if (string.equals("mksap")) {
                A1(bundle, "", (String[]) null, (String) null);
                return;
            } else if (string.equals("stockley")) {
                cls = STListActivity.class;
                cls2 = STListActivityFragment.class;
            } else if (string.equals("lww")) {
                bundle2.putString("ParentId", "0");
                cls = LWWChapters.class;
                cls2 = LWWChaptersFragment.class;
            } else {
                Class<CMETOCFragment> cls3 = CMETOCFragment.class;
                Class<CMETOC> cls4 = CMETOC.class;
                if (string.equals("cme") || string.equals("kaptest")) {
                    bundle2.putString("ParentId", "0");
                    N(cls4, cls3, bundle2);
                    return;
                } else if (string.equals("tol")) {
                    cls = PsychoListActivity.class;
                    cls2 = PsychoListActivityFragment.class;
                } else {
                    cls = LXItems.class;
                    cls2 = LXItems.LXItemsFragment.class;
                }
            }
            N(cls, cls2, bundle2);
            return;
        }
        Toast.makeText(this.f29548d, "You don't own this database, please Buy before use", 1).show();
    }
}
