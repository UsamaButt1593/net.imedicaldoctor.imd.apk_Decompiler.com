package net.imedicaldoctor.imd.Fragments;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import at.grabner.circleprogress.CircleProgressView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.dd.CircularProgressButton;
import com.google.android.material.tabs.TabLayout;
import com.google.common.net.UrlEscapers;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.VBHelper;
import net.imedicaldoctor.imd.ViewHolders.StatusAdapter;
import net.imedicaldoctor.imd.iMD;
import net.imedicaldoctor.imd.iMDLogger;
import org.apache.commons.lang3.StringUtils;

public class downloadFragment extends Fragment {
    public static final String A5 = "Delta";
    public static final String B5 = "Update";
    public static final String C5 = "Rebuilding";
    public static final String D5 = "Parts";
    public static final String E5 = "folderSizeKey";
    public static final String F5 = "videoIdKey";
    public static final String G5 = "savePathKey";
    public static final String H5 = "LatestKey";
    public static final String I5 = "HiddenKey";
    public static final String J5 = "SpeedReceived";
    /* access modifiers changed from: private */
    public static ArrayList<Bundle> N4 = null;
    private static ArrayList<Bundle> O4 = null;
    private static HashMap<String, CircleProgressView> P4 = null;
    /* access modifiers changed from: private */
    public static HashMap<String, Runnable> Q4 = null;
    /* access modifiers changed from: private */
    public static HashMap<String, Runnable> R4 = null;
    private static HashMap<String, Runnable> S4 = null;
    private static ArrayList<Bundle> T4 = null;
    public static HashMap<String, Bundle> U4 = null;
    private static ArrayList<Bundle> V4 = null;
    /* access modifiers changed from: private */
    public static ArrayList<Bundle> W4 = null;
    private static Bundle X4 = null;
    private static String Y4 = null;
    private static String Z4 = null;
    /* access modifiers changed from: private */
    public static String a5 = null;
    public static Bundle b5 = null;
    public static int c5 = 0;
    public static HashMap<String, DisposableObserver<HttpURLConnection>> d5 = null;
    public static final String e5 = "bytesDownloaded";
    public static final String f5 = "bytesTotal";
    public static final String g5 = "avgSpeed";
    public static final String h5 = "remaining";
    public static final String i5 = "Progress";
    public static final String j5 = "Title";
    public static final String k5 = "URL";
    public static final String l5 = "FileName";
    public static final String m5 = "MD5";
    public static final String n5 = "PartFileSize";
    public static final String o5 = "price";
    public static final String p5 = "Buy";
    public static final String q5 = "downloader";
    public static final String r5 = "retry";
    public static final String s5 = "completed";
    public static final String t5 = "Installed";
    public static final String u5 = "error";
    public static final String v5 = "fileSize";
    public static final String w5 = "Icon";
    public static final String x5 = "name";
    public static final String y5 = "type";
    public static final String z5 = "version";
    /* access modifiers changed from: private */
    public String A4;
    /* access modifiers changed from: private */
    public boolean B4;
    /* access modifiers changed from: private */
    public boolean C4;
    private Activity D4;
    public Typeface E4;
    public BetterLinearLayoutManager F4;
    public String G4;
    public boolean H4;
    CompressHelper I4;
    public DownloadsAdapter J4;
    public Handler K4 = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            downloadFragment.this.b4();
        }
    };
    public Handler L4 = new Handler() {
        public void handleMessage(Message message) {
            downloadFragment.this.v3();
        }
    };
    public BroadcastReceiver M4 = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (!downloadFragment.this.C3()) {
                SearchView searchView = downloadFragment.this.m4;
                if (searchView != null) {
                    searchView.clearFocus();
                }
                if (!downloadFragment.this.K3()) {
                    downloadFragment.this.M2();
                }
                downloadFragment.this.B3();
            }
        }
    };
    private Bundle e4;
    /* access modifiers changed from: private */
    public Bundle f4;
    private Observable<String> g4;
    /* access modifiers changed from: private */
    public Bundle h4;
    /* access modifiers changed from: private */
    public View i4;
    public RecyclerView j4;
    /* access modifiers changed from: private */
    public MenuItem k4;
    /* access modifiers changed from: private */
    public ProgressBar l4;
    public SearchView m4;
    public VBHelper n4;
    private Bundle o4;
    public long p4;
    public Bundle q4;
    public TabLayout r4;
    public CardView s4;
    public ImageView t4;
    public Button u4;
    private boolean v4;
    private Timer w4;
    private Timer x4;
    /* access modifiers changed from: private */
    public String y4;
    /* access modifiers changed from: private */
    public String z4;

    private static class BetterLinearLayoutManager extends LinearLayoutManager {
        public BetterLinearLayoutManager(Context context) {
            super(context);
        }

        public boolean n2() {
            return false;
        }

        public BetterLinearLayoutManager(Context context, int i2, boolean z) {
            super(context, i2, z);
        }

        public BetterLinearLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
            super(context, attributeSet, i2, i3);
        }
    }

    public class DownloadCellViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public final TextView I;
        /* access modifiers changed from: private */
        public final TextView J;
        /* access modifiers changed from: private */
        public final TextView K;
        /* access modifiers changed from: private */
        public final TextView L;
        /* access modifiers changed from: private */
        public final TextView M;
        /* access modifiers changed from: private */
        public final ImageView N;
        /* access modifiers changed from: private */
        public final Button O;
        /* access modifiers changed from: private */
        public final CircleProgressView P;

        public DownloadCellViewHolder(View view) {
            super(view);
            this.I = (TextView) view.findViewById(R.id.title);
            this.J = (TextView) view.findViewById(R.id.f1096subtitle);
            this.K = (TextView) view.findViewById(R.id.f992latest);
            this.L = (TextView) view.findViewById(R.id.f903demo);
            this.N = (ImageView) view.findViewById(R.id.image);
            Button button = (Button) view.findViewById(R.id.f919download_button);
            this.O = button;
            this.M = (TextView) view.findViewById(R.id.f905desc);
            button.setTypeface(downloadFragment.this.E4);
            this.P = (CircleProgressView) view.findViewById(R.id.f877circleView);
        }
    }

    public class DownloadsAdapter extends RecyclerView.Adapter {
        public DownloadsAdapter() {
        }

        private void d0(final CircularProgressButton circularProgressButton) {
            circularProgressButton.setProgress(1);
            circularProgressButton.postDelayed(new Runnable() {
                public void run() {
                    circularProgressButton.setProgress(0);
                    circularProgressButton.postDelayed(new Runnable() {
                        public void run() {
                            circularProgressButton.setProgress(1);
                        }
                    }, 100);
                }
            }, 100);
        }

        private double e0(Bundle bundle, String str) {
            try {
                if (bundle.containsKey(str)) {
                    return bundle.getDouble(str);
                }
                return 0.0d;
            } catch (Exception e2) {
                FirebaseCrashlytics.d().g(e2);
                return 0.0d;
            }
        }

        private long g0(Bundle bundle, String str) {
            try {
                if (bundle.containsKey(str)) {
                    return bundle.getLong(str);
                }
                return 0;
            } catch (Exception e2) {
                FirebaseCrashlytics.d().g(e2);
                return 0;
            }
        }

        private String h0(int i2) {
            return j0(i2 / 3600) + " : " + j0((i2 % 3600) / 60) + " : " + j0(i2 % 60);
        }

        private String j0(int i2) {
            if (i2 == 0) {
                return "00";
            }
            if (i2 / 10 != 0) {
                return String.valueOf(i2);
            }
            return "0" + i2;
        }

        public int C(int i2) {
            return 1;
        }

        /* JADX WARNING: Removed duplicated region for block: B:44:0x017a A[Catch:{ Exception -> 0x0159 }] */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x019b A[Catch:{ Exception -> 0x0159 }] */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x022a  */
        /* JADX WARNING: Removed duplicated region for block: B:68:0x028f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void R(androidx.recyclerview.widget.RecyclerView.ViewHolder r22, int r23) {
            /*
                r21 = this;
                r1 = r21
                r0 = r23
                java.lang.String r2 = "error"
                java.lang.String r3 = "Buy"
                r4 = r22
                net.imedicaldoctor.imd.Fragments.downloadFragment$DownloadCellViewHolder r4 = (net.imedicaldoctor.imd.Fragments.downloadFragment.DownloadCellViewHolder) r4
                java.util.ArrayList r5 = net.imedicaldoctor.imd.Fragments.downloadFragment.N4
                if (r5 == 0) goto L_0x03e7
                java.util.ArrayList r5 = net.imedicaldoctor.imd.Fragments.downloadFragment.N4
                int r5 = r5.size()
                int r5 = r5 + -1
                if (r5 >= r0) goto L_0x0020
                goto L_0x03e7
            L_0x0020:
                java.util.ArrayList r5 = net.imedicaldoctor.imd.Fragments.downloadFragment.N4
                java.lang.Object r0 = r5.get(r0)
                r5 = r0
                android.os.Bundle r5 = (android.os.Bundle) r5
                android.widget.TextView r0 = r4.I
                java.lang.String r6 = "Title"
                java.lang.String r6 = r5.getString(r6)
                r0.setText(r6)
                android.widget.ImageView r0 = r4.N
                r1.i0(r0, r5)
                java.lang.String r0 = "LatestKey"
                boolean r6 = r5.containsKey(r0)
                java.lang.String r7 = "0"
                r8 = 0
                r9 = 8
                if (r6 == 0) goto L_0x007b
                android.widget.TextView r6 = r4.K
                r6.setVisibility(r8)
                java.lang.String r0 = r5.getString(r0)
                boolean r0 = r0.equals(r7)
                if (r0 == 0) goto L_0x0067
                android.widget.TextView r0 = r4.K
                java.lang.String r6 = "Show Latest Version"
            L_0x0063:
                r0.setText(r6)
                goto L_0x006e
            L_0x0067:
                android.widget.TextView r0 = r4.K
                java.lang.String r6 = "Show Free Version"
                goto L_0x0063
            L_0x006e:
                android.widget.TextView r0 = r4.K
                net.imedicaldoctor.imd.Fragments.downloadFragment$DownloadsAdapter$2 r6 = new net.imedicaldoctor.imd.Fragments.downloadFragment$DownloadsAdapter$2
                r6.<init>(r5)
                r0.setOnClickListener(r6)
                goto L_0x0082
            L_0x007b:
                android.widget.TextView r0 = r4.K
                r0.setVisibility(r9)
            L_0x0082:
                java.lang.String r0 = "completed"
                boolean r0 = r5.containsKey(r0)
                if (r0 == 0) goto L_0x0110
                java.lang.String r0 = "Installed"
                boolean r0 = r5.containsKey(r0)
                if (r0 == 0) goto L_0x00cc
                android.widget.TextView r0 = r4.J
                java.lang.String r2 = "ّInstalled"
                r0.setText(r2)
                android.widget.TextView r0 = r4.J
                net.imedicaldoctor.imd.Fragments.downloadFragment r2 = net.imedicaldoctor.imd.Fragments.downloadFragment.this
                android.content.res.Resources r2 = r2.b0()
                r3 = 2131099710(0x7f06003e, float:1.781178E38)
                int r2 = r2.getColor(r3)
                r0.setTextColor(r2)
                android.widget.Button r0 = r4.O
                r0.setVisibility(r8)
                android.widget.Button r0 = r4.O
                java.lang.String r2 = "Open"
                r0.setText(r2)
                android.widget.Button r0 = r4.O
                net.imedicaldoctor.imd.Fragments.downloadFragment$DownloadsAdapter$3 r2 = new net.imedicaldoctor.imd.Fragments.downloadFragment$DownloadsAdapter$3
                r2.<init>(r5)
                r0.setOnClickListener(r2)
                goto L_0x00f0
            L_0x00cc:
                android.widget.TextView r0 = r4.J
                java.lang.String r2 = "Download Completed"
                r0.setText(r2)
                android.widget.TextView r0 = r4.J
                net.imedicaldoctor.imd.Fragments.downloadFragment r2 = net.imedicaldoctor.imd.Fragments.downloadFragment.this
                android.content.res.Resources r2 = r2.b0()
                r3 = 2131099828(0x7f0600b4, float:1.781202E38)
                int r2 = r2.getColor(r3)
                r0.setTextColor(r2)
                android.widget.Button r0 = r4.O
                r0.setVisibility(r9)
            L_0x00f0:
                java.lang.String r0 = "Rebuilding"
                boolean r0 = r5.containsKey(r0)
                if (r0 == 0) goto L_0x0101
                android.widget.TextView r0 = r4.J
                java.lang.String r2 = "Rebuilding ..."
                r0.setText(r2)
            L_0x0101:
                android.widget.TextView r0 = r4.L
                r0.setVisibility(r9)
                at.grabner.circleprogress.CircleProgressView r0 = r4.P
                r0.setVisibility(r9)
                return
            L_0x0110:
                java.lang.String r0 = "downloader"
                boolean r0 = r5.containsKey(r0)
                r6 = 2131099762(0x7f060072, float:1.7811886E38)
                if (r0 != 0) goto L_0x02fd
                android.widget.Button r0 = r4.O
                r0.setVisibility(r8)
                at.grabner.circleprogress.CircleProgressView r0 = r4.P
                r0.setVisibility(r9)
                android.widget.TextView r0 = r4.L
                r0.setVisibility(r9)
                boolean r0 = r5.containsKey(r3)     // Catch:{ Exception -> 0x0159 }
                java.lang.String r10 = "name"
                if (r0 == 0) goto L_0x016d
                net.imedicaldoctor.imd.Fragments.downloadFragment r0 = net.imedicaldoctor.imd.Fragments.downloadFragment.this     // Catch:{ Exception -> 0x0159 }
                java.lang.String r11 = r5.getString(r10)     // Catch:{ Exception -> 0x0159 }
                boolean r0 = r0.D3(r11)     // Catch:{ Exception -> 0x0159 }
                if (r0 == 0) goto L_0x016d
                net.imedicaldoctor.imd.Fragments.downloadFragment r0 = net.imedicaldoctor.imd.Fragments.downloadFragment.this     // Catch:{ Exception -> 0x0159 }
                java.lang.String r11 = r5.getString(r10)     // Catch:{ Exception -> 0x0159 }
                java.lang.String r0 = r0.N2(r11)     // Catch:{ Exception -> 0x0159 }
                java.lang.String r11 = "1year"
                boolean r0 = r0.equals(r11)     // Catch:{ Exception -> 0x0159 }
                if (r0 == 0) goto L_0x015c
                java.lang.String r0 = "Free monthly updates for one year"
                goto L_0x015e
            L_0x0159:
                r0 = move-exception
                goto L_0x0207
            L_0x015c:
                java.lang.String r0 = "Free monthly updates for two years"
            L_0x015e:
                android.widget.TextView r11 = r4.M     // Catch:{ Exception -> 0x0159 }
                r11.setText(r0)     // Catch:{ Exception -> 0x0159 }
                android.widget.TextView r0 = r4.M     // Catch:{ Exception -> 0x0159 }
                r0.setVisibility(r8)     // Catch:{ Exception -> 0x0159 }
                goto L_0x0174
            L_0x016d:
                android.widget.TextView r0 = r4.M     // Catch:{ Exception -> 0x0159 }
                r0.setVisibility(r9)     // Catch:{ Exception -> 0x0159 }
            L_0x0174:
                boolean r0 = r5.containsKey(r2)     // Catch:{ Exception -> 0x0159 }
                if (r0 == 0) goto L_0x019b
                android.widget.TextView r0 = r4.J     // Catch:{ Exception -> 0x0159 }
                java.lang.String r2 = r5.getString(r2)     // Catch:{ Exception -> 0x0159 }
                r0.setText(r2)     // Catch:{ Exception -> 0x0159 }
                android.widget.TextView r0 = r4.J     // Catch:{ Exception -> 0x0159 }
                net.imedicaldoctor.imd.Fragments.downloadFragment r2 = net.imedicaldoctor.imd.Fragments.downloadFragment.this     // Catch:{ Exception -> 0x0159 }
                android.content.res.Resources r2 = r2.b0()     // Catch:{ Exception -> 0x0159 }
                r6 = 2131100785(0x7f060471, float:1.7813961E38)
                int r2 = r2.getColor(r6)     // Catch:{ Exception -> 0x0159 }
            L_0x0196:
                r0.setTextColor(r2)     // Catch:{ Exception -> 0x0159 }
                goto L_0x021a
            L_0x019b:
                net.imedicaldoctor.imd.Fragments.downloadFragment r0 = net.imedicaldoctor.imd.Fragments.downloadFragment.this     // Catch:{ Exception -> 0x0159 }
                java.lang.String r2 = r5.getString(r10)     // Catch:{ Exception -> 0x0159 }
                boolean r0 = r0.D3(r2)     // Catch:{ Exception -> 0x0159 }
                java.lang.String r2 = "fileSize"
                if (r0 == 0) goto L_0x01e1
                android.widget.TextView r0 = r4.J     // Catch:{ Exception -> 0x0159 }
                java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0159 }
                r10.<init>()     // Catch:{ Exception -> 0x0159 }
                net.imedicaldoctor.imd.Fragments.downloadFragment r11 = net.imedicaldoctor.imd.Fragments.downloadFragment.this     // Catch:{ Exception -> 0x0159 }
                java.lang.String r2 = r5.getString(r2)     // Catch:{ Exception -> 0x0159 }
                java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ Exception -> 0x0159 }
                long r12 = r2.longValue()     // Catch:{ Exception -> 0x0159 }
                java.lang.String r2 = r11.M3(r12)     // Catch:{ Exception -> 0x0159 }
                r10.append(r2)     // Catch:{ Exception -> 0x0159 }
                java.lang.String r2 = " - "
                r10.append(r2)     // Catch:{ Exception -> 0x0159 }
                java.lang.String r2 = "version"
                java.lang.String r2 = r5.getString(r2)     // Catch:{ Exception -> 0x0159 }
                java.lang.String r2 = net.imedicaldoctor.imd.Data.CompressHelper.c1(r2)     // Catch:{ Exception -> 0x0159 }
                r10.append(r2)     // Catch:{ Exception -> 0x0159 }
                java.lang.String r2 = r10.toString()     // Catch:{ Exception -> 0x0159 }
            L_0x01dd:
                r0.setText(r2)     // Catch:{ Exception -> 0x0159 }
                goto L_0x01f8
            L_0x01e1:
                android.widget.TextView r0 = r4.J     // Catch:{ Exception -> 0x0159 }
                net.imedicaldoctor.imd.Fragments.downloadFragment r10 = net.imedicaldoctor.imd.Fragments.downloadFragment.this     // Catch:{ Exception -> 0x0159 }
                java.lang.String r2 = r5.getString(r2)     // Catch:{ Exception -> 0x0159 }
                java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ Exception -> 0x0159 }
                long r11 = r2.longValue()     // Catch:{ Exception -> 0x0159 }
                java.lang.String r2 = r10.M3(r11)     // Catch:{ Exception -> 0x0159 }
                goto L_0x01dd
            L_0x01f8:
                android.widget.TextView r0 = r4.J     // Catch:{ Exception -> 0x0159 }
                net.imedicaldoctor.imd.Fragments.downloadFragment r2 = net.imedicaldoctor.imd.Fragments.downloadFragment.this     // Catch:{ Exception -> 0x0159 }
                android.content.res.Resources r2 = r2.b0()     // Catch:{ Exception -> 0x0159 }
                int r2 = r2.getColor(r6)     // Catch:{ Exception -> 0x0159 }
                goto L_0x0196
            L_0x0207:
                com.google.firebase.crashlytics.FirebaseCrashlytics r2 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()
                r2.g(r0)
                android.widget.TextView r2 = r4.J
                java.lang.String r6 = "Error occured, try again"
                r2.setText(r6)
                r0.printStackTrace()
            L_0x021a:
                java.lang.String r0 = "Update"
                boolean r2 = r5.containsKey(r0)
                java.lang.String r6 = "type"
                java.lang.String r10 = " T"
                java.lang.String r11 = "Free"
                java.lang.String r12 = "price"
                if (r2 == 0) goto L_0x028f
                boolean r2 = r5.containsKey(r3)
                if (r2 == 0) goto L_0x0287
                java.lang.String r0 = r5.getString(r12)
                boolean r0 = r0.equals(r7)
                if (r0 == 0) goto L_0x0243
            L_0x023a:
                android.widget.Button r0 = r4.O
                r0.setText(r11)
                goto L_0x02e3
            L_0x0243:
                android.widget.Button r0 = r4.O
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = r5.getString(r12)
                r2.append(r3)
                r2.append(r10)
                java.lang.String r2 = r2.toString()
                r0.setText(r2)
                net.imedicaldoctor.imd.Fragments.downloadFragment r0 = net.imedicaldoctor.imd.Fragments.downloadFragment.this
                net.imedicaldoctor.imd.VBHelper r0 = r0.n4
                java.lang.String r2 = r5.getString(r6)
                boolean r0 = r0.v(r2)
                if (r0 == 0) goto L_0x027f
                android.widget.TextView r0 = r4.L
                r0.setVisibility(r8)
                android.widget.TextView r0 = r4.L
                net.imedicaldoctor.imd.Fragments.downloadFragment$DownloadsAdapter$4 r2 = new net.imedicaldoctor.imd.Fragments.downloadFragment$DownloadsAdapter$4
                r2.<init>(r5)
            L_0x027b:
                r0.setOnClickListener(r2)
                goto L_0x02e3
            L_0x027f:
                android.widget.TextView r0 = r4.L
                r0.setVisibility(r9)
                goto L_0x02e3
            L_0x0287:
                android.widget.Button r2 = r4.O
                r2.setText(r0)
                goto L_0x02e3
            L_0x028f:
                boolean r0 = r5.containsKey(r3)
                if (r0 == 0) goto L_0x02d9
                java.lang.String r0 = r5.getString(r12)
                boolean r0 = r0.equals(r7)
                if (r0 == 0) goto L_0x02a0
                goto L_0x023a
            L_0x02a0:
                android.widget.Button r0 = r4.O
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = r5.getString(r12)
                r2.append(r3)
                r2.append(r10)
                java.lang.String r2 = r2.toString()
                r0.setText(r2)
                net.imedicaldoctor.imd.Fragments.downloadFragment r0 = net.imedicaldoctor.imd.Fragments.downloadFragment.this
                net.imedicaldoctor.imd.VBHelper r0 = r0.n4
                java.lang.String r2 = r5.getString(r6)
                boolean r0 = r0.v(r2)
                if (r0 == 0) goto L_0x027f
                android.widget.TextView r0 = r4.L
                r0.setVisibility(r8)
                android.widget.TextView r0 = r4.L
                net.imedicaldoctor.imd.Fragments.downloadFragment$DownloadsAdapter$5 r2 = new net.imedicaldoctor.imd.Fragments.downloadFragment$DownloadsAdapter$5
                r2.<init>(r5)
                goto L_0x027b
            L_0x02d9:
                android.widget.Button r0 = r4.O
                java.lang.String r2 = "Download"
                r0.setText(r2)
                goto L_0x027f
            L_0x02e3:
                android.widget.Button r0 = r4.O
                net.imedicaldoctor.imd.Fragments.downloadFragment$DownloadsAdapter$6 r2 = new net.imedicaldoctor.imd.Fragments.downloadFragment$DownloadsAdapter$6
                r2.<init>(r5)
                r0.setOnClickListener(r2)
                android.widget.Button r0 = r4.O
                net.imedicaldoctor.imd.Fragments.downloadFragment$DownloadsAdapter$7 r2 = new net.imedicaldoctor.imd.Fragments.downloadFragment$DownloadsAdapter$7
                r2.<init>(r5)
                r0.setOnLongClickListener(r2)
                goto L_0x03e7
            L_0x02fd:
                android.widget.TextView r0 = r4.K
                r0.setVisibility(r9)
                android.widget.TextView r0 = r4.L
                r0.setVisibility(r9)
                java.text.DecimalFormat r0 = new java.text.DecimalFormat
                java.lang.String r2 = "#,##0.#"
                r0.<init>(r2)
                android.widget.Button r2 = r4.O
                r2.setVisibility(r9)
                at.grabner.circleprogress.CircleProgressView r2 = r4.P
                r2.setVisibility(r8)
                java.lang.String r2 = "bytesDownloaded"
                double r2 = r1.e0(r5, r2)
                java.lang.String r7 = "bytesTotal"
                double r7 = r1.e0(r5, r7)
                java.lang.String r9 = "avgSpeed"
                long r9 = r1.g0(r5, r9)
                java.lang.String r11 = "remaining"
                long r11 = r1.g0(r5, r11)
                java.lang.String r13 = "Progress"
                int r13 = r1.f0(r5, r13)
                java.lang.StringBuilder r14 = new java.lang.StringBuilder
                r14.<init>()
                r15 = 4652218415073722368(0x4090000000000000, double:1024.0)
                double r17 = r2 / r15
                r19 = r7
                double r6 = r17 / r15
                java.lang.String r6 = r0.format(r6)
                r14.append(r6)
                java.lang.String r6 = " of "
                r14.append(r6)
                double r7 = r19 / r15
                double r7 = r7 / r15
                java.lang.String r0 = r0.format(r7)
                r14.append(r0)
                java.lang.String r0 = " MB("
                r14.append(r0)
                net.imedicaldoctor.imd.Fragments.downloadFragment r0 = net.imedicaldoctor.imd.Fragments.downloadFragment.this
                java.lang.String r0 = r0.M3(r9)
                r14.append(r0)
                java.lang.String r0 = "/s), "
                r14.append(r0)
                int r0 = (int) r11
                java.lang.String r0 = r1.h0(r0)
                r14.append(r0)
                java.lang.String r0 = " remaining"
                r14.append(r0)
                java.lang.String r0 = r14.toString()
                android.widget.TextView r6 = r4.J
                net.imedicaldoctor.imd.Fragments.downloadFragment r7 = net.imedicaldoctor.imd.Fragments.downloadFragment.this
                android.content.res.Resources r7 = r7.b0()
                r8 = 2131099762(0x7f060072, float:1.7811886E38)
                int r7 = r7.getColor(r8)
                r6.setTextColor(r7)
                r6 = 0
                int r8 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
                if (r8 != 0) goto L_0x03a9
                at.grabner.circleprogress.CircleProgressView r0 = r4.P
                r0.u()
                java.lang.String r0 = "Preparing Download"
                goto L_0x03b0
            L_0x03a9:
                at.grabner.circleprogress.CircleProgressView r2 = r4.P
                r2.v()
            L_0x03b0:
                android.widget.TextView r2 = r4.J
                r2.setText(r0)
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "Progress : "
                r0.append(r2)
                r0.append(r13)
                java.lang.String r0 = r0.toString()
                java.lang.String r2 = "ONBindViewHolder"
                net.imedicaldoctor.imd.iMDLogger.d(r2, r0)
                at.grabner.circleprogress.CircleProgressView r0 = r4.P
                if (r13 != 0) goto L_0x03d9
                r2 = 1065353216(0x3f800000, float:1.0)
            L_0x03d5:
                r0.setValue(r2)
                goto L_0x03db
            L_0x03d9:
                float r2 = (float) r13
                goto L_0x03d5
            L_0x03db:
                at.grabner.circleprogress.CircleProgressView r0 = r4.P
                net.imedicaldoctor.imd.Fragments.downloadFragment$DownloadsAdapter$8 r2 = new net.imedicaldoctor.imd.Fragments.downloadFragment$DownloadsAdapter$8
                r2.<init>(r5)
                r0.setOnClickListener(r2)
            L_0x03e7:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.downloadFragment.DownloadsAdapter.R(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
        }

        public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
            View inflate = LayoutInflater.from(downloadFragment.this.z3()).inflate(R.layout.f1315list_view_item_download, viewGroup, false);
            inflate.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    downloadFragment.this.B3();
                }
            });
            return new DownloadCellViewHolder(inflate);
        }

        public int b() {
            if (downloadFragment.N4 == null) {
                return 0;
            }
            return downloadFragment.N4.size();
        }

        public int f0(Bundle bundle, String str) {
            if (bundle.containsKey(str)) {
                return bundle.getInt(str);
            }
            return 0;
        }

        public void i0(ImageView imageView, Bundle bundle) {
            RequestBuilder<Drawable> P;
            ArrayList arrayList = new ArrayList();
            arrayList.add("visualdx.png");
            arrayList.add("uptodate.png");
            arrayList.add("irandarou.png");
            if (arrayList.contains(bundle.getString("Icon"))) {
                P = Glide.F(downloadFragment.this).g(Uri.parse("file:///android_asset/" + bundle.getString("Icon")));
            } else {
                P = Glide.F(downloadFragment.this).t(downloadFragment.this.I4.S1("http://" + downloadFragment.this.z4 + ".imedicaldoctor.net/Icons/" + bundle.getString("Icon")));
            }
            P.B2(imageView);
        }
    }

    public class PackageCellViewHolder extends RecyclerView.ViewHolder {
        private final TextView I;
        private final Button J;

        public PackageCellViewHolder(View view) {
            super(view);
            this.I = (TextView) view.findViewById(R.id.title);
            this.J = (Button) view.findViewById(R.id.f919download_button);
        }
    }

    private Observable<String> F3(final Bundle bundle) {
        return Observable.w1(new ObservableOnSubscribe<String>() {
            public void a(@NonNull ObservableEmitter<String> observableEmitter) throws Throwable {
                FileOutputStream fileOutputStream;
                String str;
                String str2;
                String str3;
                ObservableEmitter<String> observableEmitter2 = observableEmitter;
                String y = downloadFragment.this.I4.y();
                StringBuilder sb = new StringBuilder();
                sb.append(y);
                String str4 = "/";
                sb.append(str4);
                String str5 = "FileName";
                sb.append(bundle.getString(str5));
                sb.append(".tmp");
                String sb2 = sb.toString();
                File file = new File(sb2);
                if (file.exists()) {
                    iMDLogger.j("joinFiles", sb2 + " Already exists : " + downloadFragment.this.M3(file.length()));
                    file.length();
                    downloadFragment.this.I4.j(file.getAbsolutePath());
                } else {
                    try {
                        if (!file.createNewFile()) {
                            iMDLogger.f("JoinFiles", "Error in creating " + sb2 + " Without error");
                        }
                    } catch (Exception e2) {
                        FirebaseCrashlytics.d().g(e2);
                        iMDLogger.f("JoinFiles", "Error in creating " + sb2 + " With Error : " + e2);
                        observableEmitter2.onError(e2);
                    }
                }
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (Exception e3) {
                    FirebaseCrashlytics.d().g(e3);
                    iMDLogger.f("JoiningFiles", "Error in opening file output stream for " + file.getAbsolutePath());
                    fileOutputStream = null;
                }
                FileOutputStream fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 == null) {
                    observableEmitter2.onError(new Throwable("No Opening Stream"));
                }
                int i2 = 1;
                long j2 = 0;
                while (i2 < 11) {
                    String str6 = y + str4 + bundle.getString(str5) + "." + i2;
                    File file2 = new File(str6);
                    if (!file2.exists()) {
                        iMDLogger.f("JoinFiles", str6 + " don't exist");
                        str = sb2;
                        downloadFragment.this.I4.j(file.getAbsolutePath());
                        observableEmitter2.onError(new Throwable(str6 + " don't exist"));
                    } else {
                        str = sb2;
                    }
                    String str7 = str5;
                    try {
                        long length = file2.length();
                        FileInputStream fileInputStream = new FileInputStream(file2);
                        int i3 = 0;
                        while (((long) i3) < length) {
                            int i4 = i3 + 1000000;
                            str3 = y;
                            str2 = str4;
                            if (((long) i4) > length) {
                                int i5 = ((int) length) - i3;
                                try {
                                    byte[] bArr = new byte[i5];
                                    fileInputStream.read(bArr, 0, i5);
                                    fileOutputStream2.write(bArr);
                                } catch (Exception e4) {
                                    e = e4;
                                    FirebaseCrashlytics.d().g(e);
                                    iMDLogger.f("Join Files", "Error combining parts of " + bundle.getString("PartFileSize") + " with error : " + e);
                                    observableEmitter2.onError(e);
                                    i2++;
                                    sb2 = str;
                                    str5 = str7;
                                    y = str3;
                                    str4 = str2;
                                }
                            } else {
                                byte[] bArr2 = new byte[1000000];
                                fileInputStream.read(bArr2, 0, 1000000);
                                fileOutputStream2.write(bArr2);
                            }
                            i3 = i4;
                            y = str3;
                            str4 = str2;
                        }
                        str3 = y;
                        str2 = str4;
                        fileInputStream.close();
                        j2 += length;
                        iMDLogger.j("JoinFiles", "IN " + i2 + " :" + j2 + " , " + file.length());
                    } catch (Exception e5) {
                        e = e5;
                        str3 = y;
                        str2 = str4;
                        FirebaseCrashlytics.d().g(e);
                        iMDLogger.f("Join Files", "Error combining parts of " + bundle.getString("PartFileSize") + " with error : " + e);
                        observableEmitter2.onError(e);
                        i2++;
                        sb2 = str;
                        str5 = str7;
                        y = str3;
                        str4 = str2;
                    }
                    i2++;
                    sb2 = str;
                    str5 = str7;
                    y = str3;
                    str4 = str2;
                }
                String str8 = y;
                String str9 = str4;
                String str10 = sb2;
                String str11 = str5;
                fileOutputStream2.close();
                iMDLogger.j("Joining Files", "Compare " + file.length() + " With " + bundle.getString("fileSize"));
                long abs = Math.abs(file.length() - Long.valueOf(bundle.getString("fileSize")).longValue());
                if (abs == 0 || abs == 16) {
                    String str12 = str11;
                    String str13 = str8;
                    String str14 = str9;
                    int i6 = 1;
                    file.setReadable(true, false);
                    while (i6 < 11) {
                        StringBuilder sb3 = new StringBuilder();
                        String str15 = str10;
                        sb3.append(str15);
                        sb3.append(".");
                        sb3.append(i6);
                        String replace = sb3.toString().replace("tmp.", "");
                        File file3 = new File(replace);
                        try {
                            downloadFragment.this.I4.j(replace);
                        } catch (Exception e6) {
                            FirebaseCrashlytics.d().g(e6);
                            file3.deleteOnExit();
                        }
                        i6++;
                        str10 = str15;
                    }
                    File file4 = new File(str13 + str14 + bundle.getString(str12));
                    if (bundle.containsKey("savePathKey")) {
                        file4 = new File(bundle.getString("savePathKey"));
                        if (!file4.getParentFile().exists()) {
                            file4.getParentFile().mkdirs();
                        }
                    }
                    if (file4.exists()) {
                        downloadFragment.this.I4.j(file4.getAbsolutePath());
                    }
                    try {
                        downloadFragment.this.L3(file, file4);
                    } catch (Exception unused) {
                        observableEmitter2.onError(new Throwable("Renamed failed to " + file4.getAbsolutePath()));
                    }
                    observableEmitter.onComplete();
                    return;
                }
                Log.d("Joining Files", "Comparing failed. deleteing all parts");
                for (int i7 = 1; i7 < 11; i7++) {
                    String str16 = str8 + str9 + bundle.getString(str11) + "." + i7;
                    new File(str16);
                    downloadFragment.this.I4.j(str16);
                }
                observableEmitter2.onError(new Throwable("Rebuild unsuccesfull"));
            }
        });
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void L3(java.io.File r9, java.io.File r10) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ all -> 0x0035 }
            r1.<init>(r10)     // Catch:{ all -> 0x0035 }
            java.nio.channels.FileChannel r10 = r1.getChannel()     // Catch:{ all -> 0x0035 }
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x0033 }
            r1.<init>(r9)     // Catch:{ all -> 0x0033 }
            java.nio.channels.FileChannel r0 = r1.getChannel()     // Catch:{ all -> 0x0033 }
            long r5 = r0.size()     // Catch:{ all -> 0x0033 }
            r3 = 0
            r2 = r0
            r7 = r10
            r2.transferTo(r3, r5, r7)     // Catch:{ all -> 0x0033 }
            r0.close()     // Catch:{ all -> 0x0033 }
            net.imedicaldoctor.imd.Data.CompressHelper r1 = r8.I4     // Catch:{ all -> 0x0033 }
            java.lang.String r9 = r9.getAbsolutePath()     // Catch:{ all -> 0x0033 }
            r1.j(r9)     // Catch:{ all -> 0x0033 }
            r0.close()
            if (r10 == 0) goto L_0x0032
            r10.close()
        L_0x0032:
            return
        L_0x0033:
            r9 = move-exception
            goto L_0x0037
        L_0x0035:
            r9 = move-exception
            r10 = r0
        L_0x0037:
            if (r0 == 0) goto L_0x003c
            r0.close()
        L_0x003c:
            if (r10 == 0) goto L_0x0041
            r10.close()
        L_0x0041:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.downloadFragment.L3(java.io.File, java.io.File):void");
    }

    private String P3(String str) {
        return str;
    }

    /* access modifiers changed from: private */
    public void Q2() {
        VBHelper vBHelper = this.n4;
        String x = vBHelper.x(vBHelper.m());
        if (x != null) {
            String[] split = TextUtils.split(x.replace("||", "::"), "::");
            String str = split[1];
            String[] split2 = TextUtils.split(split[3], ",");
            Y4 = split[5];
            new ArrayList(Arrays.asList(split2));
            if (X4 == null) {
                X4 = this.n4.z();
            }
            Z4 = split[4];
        }
    }

    /* access modifiers changed from: private */
    public void U2() {
        String str;
        if (this.G4 != null) {
            ((TextView) this.i4.findViewById(R.id.f1086status_label)).setText(this.G4);
            this.G4 = null;
            return;
        }
        ArrayList<Bundle> arrayList = N4;
        if (arrayList == null || arrayList.size() == 0) {
            if (CompressHelper.x) {
                str = "Loading Databases";
            } else {
                String str2 = a5;
                if (str2 == null || str2.length() <= 0) {
                    TabLayout tabLayout = this.r4;
                    if (tabLayout.D(tabLayout.getSelectedTabPosition()).n().equals("Updates")) {
                        str = "All your databases are up to date.";
                    } else {
                        TabLayout tabLayout2 = this.r4;
                        if (tabLayout2.D(tabLayout2.getSelectedTabPosition()).n().equals("Paid")) {
                            str = "You haven't purchased any databases yet";
                        }
                    }
                }
                X3("No Databases Found");
                return;
            }
            X3(str);
            return;
        }
        W3();
        O2();
        this.j4.X1(0);
    }

    public String A3(Bundle bundle) {
        StringBuilder sb;
        String str;
        String str2 = "<font color=\"#337a33\" size=\"18\"><b>" + bundle.getString("Title") + " </b></font></div><br/>";
        String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(bundle.getString("Titles"), "||||");
        for (int i2 = 0; i2 < splitByWholeSeparator.length; i2++) {
            String str3 = StringUtils.LF + splitByWholeSeparator[i2];
            if (i2 % 2 == 0) {
                sb = new StringBuilder();
                str = "<font color=\"#000000\" size=\"14\"><b>";
            } else {
                sb = new StringBuilder();
                str = "<font color=\"#777777\" size=\"14\"><b>";
            }
            sb.append(str);
            sb.append(str3);
            sb.append(" </b></font></div><br/>");
            String sb2 = sb.toString();
            if (i2 == splitByWholeSeparator.length - 1) {
                sb2 = sb2.replace("<br/>", "");
            }
            str2 = str2 + sb2;
        }
        return str2;
    }

    public void B3() {
        try {
            ((InputMethodManager) z3().getSystemService("input_method")).hideSoftInputFromWindow(z3().getCurrentFocus().getWindowToken(), 0);
            if (z3().getCurrentFocus() != null) {
                z3().getCurrentFocus().clearFocus();
            }
        } catch (Exception unused) {
        }
    }

    public boolean C3() {
        Bundle bundle = this.f4;
        if (bundle == null) {
            return false;
        }
        for (String bundle2 : bundle.keySet()) {
            if (this.f4.getBundle(bundle2).containsKey("downloader")) {
                return true;
            }
        }
        return false;
    }

    public boolean D3(String str) {
        Bundle bundle = this.o4;
        if (bundle == null) {
            return false;
        }
        return bundle.containsKey(str);
    }

    public boolean E3(String str) {
        TabLayout tabLayout = this.r4;
        tabLayout.D(tabLayout.getSelectedTabPosition());
        TabLayout tabLayout2 = this.r4;
        return tabLayout2.D(tabLayout2.getSelectedTabPosition()).n().toString().toLowerCase().equals(str.toLowerCase());
    }

    public boolean G3() {
        ArrayList<Bundle> arrayList = ((iMD) r().getApplicationContext()).s;
        if (arrayList == null || arrayList.size() == 0) {
            return true;
        }
        return getActivity().getSharedPreferences("default_preferences", 0).getBoolean("loaddownload", false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0638, code lost:
        if (r1.compareTo(r3) >= 0) goto L_0x064e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0661  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0671  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void H3() {
        /*
            r24 = this;
            r0 = r24
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            r0.e4 = r1
            net.imedicaldoctor.imd.VBHelper r1 = r0.n4
            android.os.Bundle r1 = r1.z()
            X4 = r1
            java.lang.String r1 = "LoadDownloads"
            java.lang.String r2 = "Started"
            net.imedicaldoctor.imd.iMDLogger.f(r1, r2)
            androidx.fragment.app.FragmentActivity r1 = r24.V1()
            java.lang.String r2 = "default_preferences"
            r3 = 0
            android.content.SharedPreferences r1 = r1.getSharedPreferences(r2, r3)
            java.lang.String r2 = "DownloadServer"
            java.lang.String r4 = "dl"
            java.lang.String r1 = r1.getString(r2, r4)
            r0.z4 = r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            net.imedicaldoctor.imd.Data.CompressHelper r2 = r0.I4
            java.lang.String r2 = r2.U1()
            r1.append(r2)
            java.lang.String r2 = "/DBs.db"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.io.File r2 = new java.io.File
            r2.<init>(r1)
            boolean r2 = r2.exists()
            if (r2 != 0) goto L_0x0050
            return
        L_0x0050:
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            r0.o4 = r2
            net.imedicaldoctor.imd.Data.CompressHelper r2 = r0.I4
            java.lang.String r5 = "Select * from expiredDBs"
            java.util.ArrayList r2 = r2.Y(r1, r5)
            java.util.Iterator r2 = r2.iterator()
        L_0x0063:
            boolean r5 = r2.hasNext()
            java.lang.String r6 = "name"
            if (r5 == 0) goto L_0x0081
            java.lang.Object r5 = r2.next()
            android.os.Bundle r5 = (android.os.Bundle) r5
            android.os.Bundle r7 = r0.o4
            java.lang.String r6 = r5.getString(r6)
            java.lang.String r8 = "desc"
            java.lang.String r5 = r5.getString(r8)
            r7.putString(r6, r5)
            goto L_0x0063
        L_0x0081:
            java.lang.String r2 = "LoadDownloads"
            java.lang.String r5 = "Loading Downloads"
            net.imedicaldoctor.imd.iMDLogger.f(r2, r5)
            java.lang.String r2 = "Paid"
            boolean r5 = r0.E3(r2)
            java.lang.String r7 = "\""
            java.lang.String r8 = "''"
            java.lang.String r9 = "'"
            java.lang.String r10 = ""
            java.lang.String r12 = "group by name,title"
            if (r5 == 0) goto L_0x018d
            android.os.Bundle r5 = X4
            java.lang.String r13 = "all"
            boolean r5 = r5.containsKey(r13)
            if (r5 != 0) goto L_0x018d
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            android.os.Bundle r13 = X4
            java.util.Set r13 = r13.keySet()
            java.util.Iterator r13 = r13.iterator()
        L_0x00b3:
            boolean r14 = r13.hasNext()
            if (r14 == 0) goto L_0x00d9
            java.lang.Object r14 = r13.next()
            java.lang.String r14 = (java.lang.String) r14
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            r15.append(r9)
            java.lang.String r14 = r14.replace(r9, r8)
            r15.append(r14)
            r15.append(r9)
            java.lang.String r14 = r15.toString()
            r5.add(r14)
            goto L_0x00b3
        L_0x00d9:
            java.lang.String r13 = a5
            java.lang.String r14 = " order by maxdate desc, version desc limit "
            java.lang.String r15 = ","
            java.lang.String r3 = "select id,Title,name,Version, IconName,folderSize, url, fileSize, md5,price, partfilesize,type,addedDate as maxdate,dl,trending from Dbs where name in ("
            if (r13 == 0) goto L_0x0167
            int r13 = r13.length()
            if (r13 <= 0) goto L_0x0167
            java.lang.String r13 = a5
            boolean r13 = r13.contains(r7)
            if (r13 == 0) goto L_0x012e
            net.imedicaldoctor.imd.Data.CompressHelper r13 = r0.I4
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r3)
            java.lang.String r3 = org.apache.commons.lang3.StringUtils.join((java.lang.Iterable<?>) r5, (java.lang.String) r15)
            r11.append(r3)
            java.lang.String r3 = ") AND title='"
            r11.append(r3)
            java.lang.String r3 = a5
            java.lang.String r3 = r3.replace(r9, r8)
            java.lang.String r3 = r3.replace(r7, r10)
            r11.append(r3)
            java.lang.String r3 = "' "
            r11.append(r3)
            r11.append(r12)
            r11.append(r14)
            r3 = 200(0xc8, float:2.8E-43)
            r11.append(r3)
            java.lang.String r3 = r11.toString()
            java.util.ArrayList r3 = r13.Y(r1, r3)
            goto L_0x0269
        L_0x012e:
            net.imedicaldoctor.imd.Data.CompressHelper r7 = r0.I4
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r3)
            java.lang.String r3 = org.apache.commons.lang3.StringUtils.join((java.lang.Iterable<?>) r5, (java.lang.String) r15)
            r11.append(r3)
            java.lang.String r3 = ") AND title match '"
            r11.append(r3)
            java.lang.String r3 = a5
            java.lang.String r3 = r3.replace(r9, r8)
            r11.append(r3)
            java.lang.String r3 = "*' "
            r11.append(r3)
            r11.append(r12)
            r11.append(r14)
            r3 = 200(0xc8, float:2.8E-43)
            r11.append(r3)
            java.lang.String r3 = r11.toString()
        L_0x0161:
            java.util.ArrayList r3 = r7.Y(r1, r3)
            goto L_0x0269
        L_0x0167:
            net.imedicaldoctor.imd.Data.CompressHelper r7 = r0.I4
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r3)
            java.lang.String r3 = org.apache.commons.lang3.StringUtils.join((java.lang.Iterable<?>) r5, (java.lang.String) r15)
            r8.append(r3)
            java.lang.String r3 = ") "
            r8.append(r3)
            r8.append(r12)
            r8.append(r14)
            r3 = 200(0xc8, float:2.8E-43)
            r8.append(r3)
            java.lang.String r3 = r8.toString()
            goto L_0x0161
        L_0x018d:
            java.lang.String r3 = "Popular"
            boolean r3 = r0.E3(r3)
            if (r3 == 0) goto L_0x0198
            java.lang.String r3 = "dl asc, version desc"
            goto L_0x01a5
        L_0x0198:
            java.lang.String r3 = "Trending"
            boolean r3 = r0.E3(r3)
            if (r3 == 0) goto L_0x01a3
            java.lang.String r3 = "trending asc, version desc"
            goto L_0x01a5
        L_0x01a3:
            java.lang.String r3 = "maxdate desc, version desc"
        L_0x01a5:
            java.lang.String r5 = a5
            java.lang.String r11 = " limit "
            java.lang.String r13 = " order by "
            if (r5 == 0) goto L_0x0224
            int r5 = r5.length()
            if (r5 <= 0) goto L_0x0224
            java.lang.String r5 = a5
            boolean r5 = r5.contains(r7)
            if (r5 == 0) goto L_0x01f4
            net.imedicaldoctor.imd.Data.CompressHelper r5 = r0.I4
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = "select id,Title,name,Version, IconName,folderSize, url, fileSize, md5,price, partfilesize,type,addedDate as maxdate,dl,trending from Dbs where title ='"
            r14.append(r15)
            java.lang.String r15 = a5
            java.lang.String r8 = r15.replace(r9, r8)
            java.lang.String r7 = r8.replace(r7, r10)
            r14.append(r7)
            java.lang.String r7 = "' "
            r14.append(r7)
            r14.append(r12)
            r14.append(r13)
            r14.append(r3)
            r14.append(r11)
            r3 = 200(0xc8, float:2.8E-43)
            r14.append(r3)
            java.lang.String r3 = r14.toString()
        L_0x01ee:
            java.util.ArrayList r3 = r5.Y(r1, r3)
            goto L_0x0269
        L_0x01f4:
            net.imedicaldoctor.imd.Data.CompressHelper r5 = r0.I4
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r14 = "select id,Title,name,Version, IconName,folderSize, url, fileSize, md5,price, partfilesize,type,addedDate as maxdate,dl,trending from Dbs where title match '"
            r7.append(r14)
            java.lang.String r14 = a5
            java.lang.String r8 = r14.replace(r9, r8)
            r7.append(r8)
            java.lang.String r8 = "*' "
            r7.append(r8)
            r7.append(r12)
            r7.append(r13)
            r7.append(r3)
            r7.append(r11)
            r3 = 200(0xc8, float:2.8E-43)
            r7.append(r3)
            java.lang.String r3 = r7.toString()
            goto L_0x01ee
        L_0x0224:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = "select id,Title,name,Version, IconName,folderSize, url, fileSize, md5,price, partfilesize,type,addedDate as maxdate,dl,trending from Dbs "
            r5.append(r7)
            r5.append(r12)
            r5.append(r13)
            r5.append(r3)
            r5.append(r11)
            r3 = 200(0xc8, float:2.8E-43)
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            android.os.Bundle r5 = r0.q4
            if (r5 != 0) goto L_0x024e
            android.os.Bundle r5 = new android.os.Bundle
            r5.<init>()
            r0.q4 = r5
        L_0x024e:
            android.os.Bundle r5 = r0.q4
            boolean r5 = r5.containsKey(r3)
            if (r5 == 0) goto L_0x025d
            android.os.Bundle r5 = r0.q4
            java.util.ArrayList r3 = r5.getParcelableArrayList(r3)
            goto L_0x0269
        L_0x025d:
            net.imedicaldoctor.imd.Data.CompressHelper r5 = r0.I4
            java.util.ArrayList r5 = r5.Y(r1, r3)
            android.os.Bundle r7 = r0.q4
            r7.putParcelableArrayList(r3, r5)
            r3 = r5
        L_0x0269:
            if (r3 != 0) goto L_0x0270
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
        L_0x0270:
            java.util.ArrayList<android.os.Bundle> r5 = W4
            if (r5 != 0) goto L_0x027e
            net.imedicaldoctor.imd.Data.CompressHelper r5 = r0.I4
            java.lang.String r7 = "Select * from Deltas"
            java.util.ArrayList r5 = r5.Y(r1, r7)
            W4 = r5
        L_0x027e:
            android.os.Bundle r5 = r0.h4
            java.lang.String r7 = "url"
            if (r5 != 0) goto L_0x02b4
            net.imedicaldoctor.imd.Data.CompressHelper r5 = r0.I4
            java.lang.String r8 = "select * from DBspass"
            java.util.ArrayList r1 = r5.Y(r1, r8)
            if (r1 != 0) goto L_0x0293
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
        L_0x0293:
            android.os.Bundle r5 = new android.os.Bundle
            r5.<init>()
            r0.h4 = r5
            java.util.Iterator r1 = r1.iterator()
        L_0x029e:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x02b4
            java.lang.Object r5 = r1.next()
            android.os.Bundle r5 = (android.os.Bundle) r5
            android.os.Bundle r8 = r0.h4
            java.lang.String r9 = r5.getString(r7)
            r8.putBundle(r9, r5)
            goto L_0x029e
        L_0x02b4:
            android.app.Activity r1 = r24.z3()
            android.content.Context r1 = r1.getApplicationContext()
            net.imedicaldoctor.imd.iMD r1 = (net.imedicaldoctor.imd.iMD) r1
            java.util.ArrayList<android.os.Bundle> r1 = r1.s
            android.app.Activity r1 = r24.z3()
            android.content.Context r1 = r1.getApplicationContext()
            net.imedicaldoctor.imd.iMD r1 = (net.imedicaldoctor.imd.iMD) r1
            net.imedicaldoctor.imd.Data.CompressHelper r1 = r1.a3
            java.util.ArrayList r1 = r1.K0()
            r24.Q2()
            java.lang.String r5 = Z4
            java.lang.String r8 = "1"
            boolean r5 = r5.equals(r8)
            if (r5 != 0) goto L_0x02e3
            r8 = 4610334938539176755(0x3ffb333333333333, double:1.7)
            goto L_0x02e5
        L_0x02e3:
            r8 = 4607182418800017408(0x3ff0000000000000, double:1.0)
        L_0x02e5:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            android.os.Bundle r11 = X4
            if (r11 != 0) goto L_0x02f6
            net.imedicaldoctor.imd.VBHelper r11 = r0.n4
            android.os.Bundle r11 = r11.z()
            X4 = r11
        L_0x02f6:
            android.os.Bundle r11 = new android.os.Bundle
            r11.<init>()
            java.util.Iterator r3 = r3.iterator()
        L_0x02ff:
            boolean r12 = r3.hasNext()
            java.lang.String r13 = "id"
            if (r12 == 0) goto L_0x069e
            java.lang.Object r12 = r3.next()
            android.os.Bundle r12 = (android.os.Bundle) r12
            android.os.Bundle r14 = r0.f4
            java.lang.String r15 = r12.getString(r13)
            boolean r14 = r14.containsKey(r15)
            if (r14 == 0) goto L_0x0353
            android.os.Bundle r14 = r0.f4
            java.lang.String r12 = r12.getString(r13)
            android.os.Bundle r12 = r14.getBundle(r12)
            boolean r13 = r0.E3(r2)
            if (r13 == 0) goto L_0x0342
            java.lang.String r13 = "downloader"
            boolean r13 = r12.containsKey(r13)
            if (r13 == 0) goto L_0x0342
            r13 = 1
            r19 = r1
            r18 = r2
            r16 = r3
            r17 = r4
            r22 = r5
            r20 = r8
            r23 = r11
            goto L_0x0651
        L_0x0342:
            r19 = r1
            r18 = r2
            r16 = r3
            r17 = r4
            r22 = r5
            r20 = r8
            r23 = r11
        L_0x0350:
            r13 = 0
            goto L_0x0651
        L_0x0353:
            android.os.Bundle r14 = new android.os.Bundle
            r14.<init>()
            java.lang.String r15 = r12.getString(r13)
            r14.putString(r13, r15)
            java.lang.String r13 = "Title"
            java.lang.String r15 = r12.getString(r13)
            java.lang.String r15 = r0.P3(r15)
            r14.putString(r13, r15)
            java.lang.String r15 = r12.getString(r4)
            r14.putString(r4, r15)
            java.lang.String r15 = "trending"
            java.lang.String r15 = r12.getString(r15)
            r16 = r3
            java.lang.String r3 = "trending"
            r14.putString(r3, r15)
            java.lang.String r3 = r12.getString(r6)
            boolean r3 = r11.containsKey(r3)
            if (r3 == 0) goto L_0x03b3
            java.lang.String r3 = r12.getString(r6)
            java.lang.String r3 = r11.getString(r3)
            java.lang.String r3 = r3.toLowerCase()
            java.lang.String r15 = "video"
            boolean r3 = r3.contains(r15)
            if (r3 != 0) goto L_0x03be
            java.lang.String r3 = r12.getString(r13)
            java.lang.String r3 = r3.toLowerCase()
            java.lang.String r15 = "video"
            boolean r3 = r3.contains(r15)
            if (r3 == 0) goto L_0x03af
            goto L_0x03be
        L_0x03af:
            r3 = r16
            goto L_0x02ff
        L_0x03b3:
            java.lang.String r3 = r12.getString(r6)
            java.lang.String r15 = r12.getString(r13)
            r11.putString(r3, r15)
        L_0x03be:
            net.imedicaldoctor.imd.Data.CompressHelper r3 = r0.I4
            java.lang.String r15 = r12.getString(r7)
            r17 = r4
            java.lang.String r4 = "/"
            java.lang.String[] r4 = org.apache.commons.lang3.StringUtils.splitByWholeSeparator(r15, r4)
            java.lang.String r3 = r3.t1(r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r15 = "http://"
            r4.append(r15)
            java.lang.String r15 = r0.z4
            r4.append(r15)
            java.lang.String r15 = ".imedicaldoctor.net"
            r4.append(r15)
            java.lang.String r15 = r12.getString(r7)
            r4.append(r15)
            java.lang.String r4 = r4.toString()
            net.imedicaldoctor.imd.Data.CompressHelper r15 = r0.I4
            java.lang.String r4 = r15.S1(r4)
            java.lang.String r15 = "price"
            java.lang.String r15 = r12.getString(r15)
            java.lang.Float r15 = java.lang.Float.valueOf(r15)
            float r15 = r15.floatValue()
            r19 = r1
            r18 = r2
            double r1 = (double) r15
            double r1 = r1 * r8
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = ".0"
            java.lang.String r1 = r1.replace(r2, r10)
            java.lang.String r2 = "fileSize"
            java.lang.String r15 = r12.getString(r2)
            r20 = r8
            java.lang.String r8 = "partfilesize"
            java.lang.String r9 = r12.getString(r8)
            r22 = r9
            android.os.Bundle r9 = r0.h4
            r23 = r11
            java.lang.String r11 = r12.getString(r7)
            boolean r9 = r9.containsKey(r11)
            if (r9 == 0) goto L_0x0471
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r4)
            java.lang.String r4 = "p"
            r9.append(r4)
            java.lang.String r4 = r9.toString()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r3)
            java.lang.String r3 = "p"
            r9.append(r3)
            java.lang.String r3 = r9.toString()
            android.os.Bundle r9 = r0.h4
            java.lang.String r11 = r12.getString(r7)
            android.os.Bundle r9 = r9.getBundle(r11)
            java.lang.String r15 = r9.getString(r2)
            android.os.Bundle r9 = r0.h4
            java.lang.String r11 = r12.getString(r7)
            android.os.Bundle r9 = r9.getBundle(r11)
            java.lang.String r9 = r9.getString(r8)
            goto L_0x0473
        L_0x0471:
            r9 = r22
        L_0x0473:
            java.lang.String r11 = "URL"
            r14.putString(r11, r4)
            java.lang.String r4 = "FileName"
            r14.putString(r4, r3)
            r14.putString(r2, r15)
            java.lang.String r3 = "IconName"
            java.lang.String r3 = r12.getString(r3)
            java.lang.String r15 = "Icon"
            r14.putString(r15, r3)
            java.lang.String r3 = r12.getString(r6)
            r14.putString(r6, r3)
            java.lang.String r3 = "type"
            java.lang.String r3 = r12.getString(r3)
            java.lang.String r15 = "type"
            r14.putString(r15, r3)
            java.lang.String r3 = "Version"
            java.lang.String r15 = r12.getString(r3)
            r22 = r5
            java.lang.String r5 = "version"
            r14.putString(r5, r15)
            java.lang.String r15 = "price"
            r14.putString(r15, r1)
            java.lang.String r1 = "md5"
            java.lang.String r1 = r12.getString(r1)
            java.lang.String r15 = "MD5"
            r14.putString(r15, r1)
            java.lang.String r1 = "PartFileSize"
            r14.putString(r1, r9)
            java.lang.String r1 = "folderSize"
            java.lang.String r1 = r12.getString(r1)
            java.lang.String r9 = "folderSizeKey"
            r14.putString(r9, r1)
            java.lang.String r1 = r12.getString(r6)
            r9 = r19
            boolean r1 = r9.contains(r1)
            if (r1 == 0) goto L_0x05cc
            net.imedicaldoctor.imd.Data.CompressHelper r1 = r0.I4
            java.lang.String r15 = "Name"
            r19 = r9
            java.lang.String r9 = r12.getString(r6)
            android.os.Bundle r1 = r1.Y0(r15, r9)
            java.lang.String r9 = r1.getString(r3)
            java.lang.String r15 = r12.getString(r3)
            int r9 = r9.compareTo(r15)
            if (r9 < 0) goto L_0x0503
            java.lang.String r2 = "completed"
            r14.putString(r2, r10)
            java.lang.String r2 = "Installed"
            r14.putString(r2, r10)
            java.lang.String r2 = "DB"
            r14.putBundle(r2, r1)
            goto L_0x05ce
        L_0x0503:
            java.lang.String r9 = r1.getString(r13)
            java.lang.String r13 = r14.getString(r13)
            boolean r9 = r9.equals(r13)
            if (r9 == 0) goto L_0x05ce
            java.lang.String r9 = "Update"
            r14.putString(r9, r10)
            java.util.ArrayList r9 = new java.util.ArrayList
            java.util.ArrayList<android.os.Bundle> r13 = W4
            net.imedicaldoctor.imd.Fragments.downloadFragment$14 r15 = new net.imedicaldoctor.imd.Fragments.downloadFragment$14
            r15.<init>(r1)
            java.util.Collection r1 = com.google.common.collect.Collections2.d(r13, r15)
            r9.<init>(r1)
            int r1 = r9.size()
            if (r1 <= 0) goto L_0x05ce
            androidx.fragment.app.FragmentActivity r1 = r24.V1()
            java.lang.String r13 = "default_preferences"
            r15 = 0
            android.content.SharedPreferences r1 = r1.getSharedPreferences(r13, r15)
            java.lang.String r13 = "delta"
            boolean r1 = r1.getBoolean(r13, r15)
            if (r1 == 0) goto L_0x05ce
            java.lang.Object r1 = r9.get(r15)
            android.os.Bundle r1 = (android.os.Bundle) r1
            java.lang.String r9 = "toVersion"
            java.lang.String r9 = r1.getString(r9)
            java.lang.String r3 = r12.getString(r3)
            boolean r3 = r9.equals(r3)
            if (r3 == 0) goto L_0x05ce
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r9 = "http://"
            r3.append(r9)
            java.lang.String r9 = r0.z4
            r3.append(r9)
            java.lang.String r9 = ".imedicaldoctor.net"
            r3.append(r9)
            java.lang.String r9 = r1.getString(r7)
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            net.imedicaldoctor.imd.Data.CompressHelper r9 = r0.I4
            java.lang.String r3 = r9.S1(r3)
            r14.remove(r11)
            r14.putString(r11, r3)
            net.imedicaldoctor.imd.Data.CompressHelper r9 = r0.I4
            java.lang.String r11 = "/"
            java.lang.String[] r3 = org.apache.commons.lang3.StringUtils.split((java.lang.String) r3, (java.lang.String) r11)
            java.lang.String r3 = r9.t1(r3)
            r14.remove(r4)
            r14.putString(r4, r3)
            r14.remove(r2)
            java.lang.String r3 = r1.getString(r2)
            r14.putString(r2, r3)
            java.lang.String r2 = "MD5"
            r14.remove(r2)
            java.lang.String r2 = "md5"
            java.lang.String r2 = r1.getString(r2)
            java.lang.String r3 = "MD5"
            r14.putString(r3, r2)
            java.lang.String r2 = "PartFileSize"
            r14.remove(r2)
            java.lang.String r2 = "PartFileSize"
            java.lang.String r3 = r1.getString(r8)
            r14.putString(r2, r3)
            r14.remove(r5)
            java.lang.String r2 = "toVersion"
            java.lang.String r1 = r1.getString(r2)
            r14.putString(r5, r1)
            java.lang.String r1 = "Delta"
            r14.putString(r1, r10)
            goto L_0x05ce
        L_0x05cc:
            r19 = r9
        L_0x05ce:
            android.os.Bundle r1 = X4
            java.lang.String r2 = "all"
            boolean r1 = r1.containsKey(r2)
            if (r1 == 0) goto L_0x05da
            goto L_0x064e
        L_0x05da:
            android.os.Bundle r1 = X4
            java.lang.String r2 = r12.getString(r6)
            boolean r1 = r1.containsKey(r2)
            if (r1 != 0) goto L_0x05e7
            goto L_0x0649
        L_0x05e7:
            android.os.Bundle r1 = X4
            java.lang.String r2 = r12.getString(r6)
            java.lang.String r1 = r1.getString(r2)
            java.lang.String r2 = "0"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x064e
            android.os.Bundle r1 = X4
            java.lang.String r2 = r12.getString(r6)
            java.lang.String r1 = r1.getString(r2)
            java.lang.String r2 = r14.getString(r5)
            java.text.SimpleDateFormat r3 = new java.text.SimpleDateFormat
            java.lang.String r4 = "yyyyMMdd"
            r3.<init>(r4)
            java.util.Date r4 = new java.util.Date
            r4.<init>()
            java.lang.String r3 = r3.format(r4)
            int r4 = r2.length()
            r5 = 6
            if (r4 != r5) goto L_0x0628
            r4 = 6
            r5 = 0
            java.lang.String r1 = r1.substring(r5, r4)
            java.lang.String r3 = r3.substring(r5, r4)
        L_0x0628:
            java.lang.String r4 = r12.getString(r6)
            java.lang.String r5 = "uptodateonline"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x063b
            int r1 = r1.compareTo(r3)
            if (r1 < 0) goto L_0x0649
            goto L_0x064e
        L_0x063b:
            int r1 = r1.compareTo(r2)
            if (r1 < 0) goto L_0x0642
            goto L_0x064e
        L_0x0642:
            java.lang.String r1 = "LatestKey"
            java.lang.String r2 = "1"
            r14.putString(r1, r2)
        L_0x0649:
            java.lang.String r1 = "Buy"
            r14.putString(r1, r10)
        L_0x064e:
            r12 = r14
            goto L_0x0350
        L_0x0651:
            java.lang.String r1 = "Updates"
            boolean r1 = r0.E3(r1)
            if (r1 == 0) goto L_0x0671
            java.lang.String r1 = "Update"
            boolean r1 = r12.containsKey(r1)
            if (r1 != 0) goto L_0x0671
            r3 = r16
            r4 = r17
            r2 = r18
        L_0x0667:
            r1 = r19
            r8 = r20
            r5 = r22
        L_0x066d:
            r11 = r23
            goto L_0x02ff
        L_0x0671:
            r1 = r18
            boolean r2 = r0.E3(r1)
            if (r2 == 0) goto L_0x0687
            java.lang.String r2 = "Buy"
            boolean r2 = r12.containsKey(r2)
            if (r2 == 0) goto L_0x0687
            r2 = r1
            r3 = r16
            r4 = r17
            goto L_0x0667
        L_0x0687:
            r3 = r22
            r2 = 0
            if (r13 == 0) goto L_0x0690
            r3.add(r2, r12)
            goto L_0x0693
        L_0x0690:
            r3.add(r12)
        L_0x0693:
            r2 = r1
            r5 = r3
            r3 = r16
            r4 = r17
            r1 = r19
            r8 = r20
            goto L_0x066d
        L_0x069e:
            r3 = r5
            r2 = 0
        L_0x06a0:
            int r1 = r3.size()
            if (r2 >= r1) goto L_0x06b8
            android.os.Bundle r1 = r0.e4
            java.lang.Object r4 = r3.get(r2)
            android.os.Bundle r4 = (android.os.Bundle) r4
            java.lang.String r4 = r4.getString(r13)
            r1.putInt(r4, r2)
            int r2 = r2 + 1
            goto L_0x06a0
        L_0x06b8:
            N4 = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.downloadFragment.H3():void");
    }

    public Observable<String> I3() {
        return Observable.w1(new ObservableOnSubscribe<String>() {
            public void a(@NonNull ObservableEmitter<String> observableEmitter) throws Throwable {
                try {
                    downloadFragment.this.H3();
                } catch (Exception e2) {
                    FirebaseCrashlytics.d().g(e2);
                    e2.printStackTrace();
                }
                observableEmitter.onComplete();
            }
        });
    }

    public float J2(int i2, String str) {
        if (!b5.containsKey(str)) {
            b5.putIntegerArrayList(str, new ArrayList());
            return 0.0f;
        }
        ArrayList<Integer> integerArrayList = b5.getIntegerArrayList(str);
        if (integerArrayList.size() > 5) {
            integerArrayList.remove(0);
        }
        integerArrayList.add(Integer.valueOf(i2));
        return K2(integerArrayList) / 2.0f;
    }

    public void J3() {
        if (!this.C4) {
            this.C4 = true;
            this.j4.b2();
            final long currentTimeMillis = System.currentTimeMillis();
            this.p4 = currentTimeMillis;
            iMDLogger.f("DownloadAndLoadDBs", "Successful");
            iMDLogger.f("DownloadAndLoadDBs", "Loading Downloads");
            iMDLogger.f("CompressHelper", "Loading DBs after download");
            Observable<String> I3 = I3();
            this.g4 = I3;
            Observable<String> s42 = I3.h6(Schedulers.e()).s4(AndroidSchedulers.e());
            this.g4 = s42;
            s42.f6(new Consumer<String>() {
                /* renamed from: a */
                public void accept(String str) throws Throwable {
                }
            }, new Consumer<Throwable>() {
                /* renamed from: a */
                public void accept(Throwable th) throws Throwable {
                    try {
                        boolean unused = downloadFragment.this.C4 = false;
                        th.printStackTrace();
                        iMDLogger.f("downloadFragment", "Error in loaddownloads");
                        downloadFragment.this.X3("Error occured . Tap to Try Again");
                        th.printStackTrace();
                    } catch (Exception unused2) {
                    }
                }
            }, new Action() {
                public void run() throws Throwable {
                    iMDLogger.f("downloadFragment", "Search called");
                    if (downloadFragment.N4 == null) {
                        boolean unused = downloadFragment.this.C4 = false;
                        downloadFragment.this.X3("Error occured in reading database . Tap to try again");
                        return;
                    }
                    long j2 = currentTimeMillis;
                    downloadFragment downloadfragment = downloadFragment.this;
                    if (j2 == downloadfragment.p4) {
                        boolean unused2 = downloadfragment.C4 = false;
                        downloadFragment.this.U2();
                        return;
                    }
                    Log.e("download", "other query executed");
                }
            });
        }
    }

    public float K2(ArrayList<Integer> arrayList) {
        Iterator<Integer> it2 = arrayList.iterator();
        long j2 = 0;
        while (it2.hasNext()) {
            j2 += (long) it2.next().intValue();
        }
        return ((float) j2) / ((float) arrayList.size());
    }

    public boolean K3() {
        return this.s4.getVisibility() != 8;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x01af  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x01c7  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01cc A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void L2(android.os.Bundle r24) {
        /*
            r23 = this;
            r1 = r23
            r2 = r24
            java.lang.String r3 = ""
            java.lang.String r4 = "Parts"
            boolean r0 = r2.containsKey(r4)
            if (r0 == 0) goto L_0x0030
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "Item "
            r0.append(r3)
            java.lang.String r3 = "Title"
            java.lang.String r2 = r2.getString(r3)
            r0.append(r2)
            java.lang.String r2 = " Already has parts"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "CreatePartsForDownloadItem"
            net.imedicaldoctor.imd.iMDLogger.f(r2, r0)
            return
        L_0x0030:
            java.lang.String r5 = "MD5"
            java.lang.String r0 = r2.getString(r5)
            java.lang.String r6 = ",,,"
            org.apache.commons.lang3.StringUtils.splitByWholeSeparator(r0, r6)
            java.lang.String r7 = "PartFileSize"
            java.lang.String r0 = r2.getString(r7)
            java.lang.String[] r6 = org.apache.commons.lang3.StringUtils.splitByWholeSeparator(r0, r6)
            java.util.ArrayList r8 = new java.util.ArrayList
            java.lang.String r9 = "URL"
            java.lang.String r0 = r2.getString(r9)
            java.lang.String r10 = "/"
            java.lang.String[] r0 = org.apache.commons.lang3.StringUtils.splitByWholeSeparator(r0, r10)
            java.util.List r0 = java.util.Arrays.asList(r0)
            r8.<init>(r0)
            int r0 = r8.size()
            int r0 = r0 + -1
            r8.add(r0, r4)
            int r0 = r8.size()
            int r0 = r0 + -1
            java.lang.Object r0 = r8.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            int r11 = r8.size()     // Catch:{ Exception -> 0x007c }
            int r11 = r11 + -1
            r8.remove(r11)     // Catch:{ Exception -> 0x007c }
            r8.add(r0)     // Catch:{ Exception -> 0x007c }
            goto L_0x0084
        L_0x007c:
            r0 = move-exception
            com.google.firebase.crashlytics.FirebaseCrashlytics r11 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()
            r11.g(r0)
        L_0x0084:
            java.lang.String r0 = org.apache.commons.lang3.StringUtils.join((java.lang.Iterable<?>) r8, (java.lang.String) r10)
            java.lang.String r8 = "http:/"
            java.lang.String r11 = "http://"
            java.lang.String r0 = r0.replace(r8, r11)
            java.lang.String r8 = r1.y3(r0)
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            net.imedicaldoctor.imd.Data.CompressHelper r0 = r1.I4
            java.lang.String r0 = r0.y()
            java.io.File r12 = new java.io.File
            r12.<init>(r0)
            java.io.File[] r0 = r12.listFiles()
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            int r13 = r0.length
            r15 = 0
        L_0x00af:
            if (r15 >= r13) goto L_0x00c3
            r16 = r0[r15]
            boolean r17 = r16.isFile()
            if (r17 == 0) goto L_0x00c0
            java.lang.String r14 = r16.getName()
            r12.add(r14)
        L_0x00c0:
            int r15 = r15 + 1
            goto L_0x00af
        L_0x00c3:
            r14 = 0
        L_0x00c4:
            r0 = 10
            if (r14 >= r0) goto L_0x01de
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r8)
            java.lang.String r13 = "."
            r0.append(r13)
            int r15 = r14 + 1
            r0.append(r15)
            r16 = r8
            java.lang.String r8 = r0.toString()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r17 = r4
            java.lang.String r4 = "FileName"
            r18 = r11
            java.lang.String r11 = r2.getString(r4)
            r0.append(r11)
            r0.append(r13)
            r0.append(r15)
            java.lang.String r11 = r0.toString()
            android.os.Bundle r13 = new android.os.Bundle
            r13.<init>()
            net.imedicaldoctor.imd.Data.CompressHelper r0 = r1.I4
            java.lang.String r0 = r0.y()
            r19 = r15
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            r15.append(r0)
            r15.append(r10)
            r15.append(r11)
            java.lang.String r0 = ".md5"
            r15.append(r0)
            java.lang.String r15 = r15.toString()
            r20 = r10
            java.io.File r10 = new java.io.File     // Catch:{ Exception -> 0x0138 }
            r10.<init>(r15)     // Catch:{ Exception -> 0x0138 }
            boolean r10 = r10.exists()     // Catch:{ Exception -> 0x0138 }
            if (r10 == 0) goto L_0x013e
            net.imedicaldoctor.imd.Data.CompressHelper r0 = r1.I4     // Catch:{ Exception -> 0x0138 }
            java.lang.String r0 = r0.f2(r15)     // Catch:{ Exception -> 0x0138 }
            r22 = r5
            r21 = r12
            goto L_0x019d
        L_0x0138:
            r0 = move-exception
            r22 = r5
            r21 = r12
            goto L_0x017f
        L_0x013e:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0138 }
            r10.<init>()     // Catch:{ Exception -> 0x0138 }
            r10.append(r8)     // Catch:{ Exception -> 0x0138 }
            r10.append(r0)     // Catch:{ Exception -> 0x0138 }
            java.lang.String r0 = r10.toString()     // Catch:{ Exception -> 0x0138 }
            net.imedicaldoctor.imd.Data.CompressHelper r10 = r1.I4     // Catch:{ Exception -> 0x0138 }
            io.reactivex.rxjava3.core.Observable r10 = r10.T0(r0, r15)     // Catch:{ Exception -> 0x0138 }
            io.reactivex.rxjava3.core.Scheduler r15 = io.reactivex.rxjava3.schedulers.Schedulers.e()     // Catch:{ Exception -> 0x0138 }
            io.reactivex.rxjava3.core.Observable r10 = r10.h6(r15)     // Catch:{ Exception -> 0x0138 }
            io.reactivex.rxjava3.core.Scheduler r15 = io.reactivex.rxjava3.android.schedulers.AndroidSchedulers.e()     // Catch:{ Exception -> 0x0138 }
            io.reactivex.rxjava3.core.Observable r10 = r10.s4(r15)     // Catch:{ Exception -> 0x0138 }
            net.imedicaldoctor.imd.Fragments.downloadFragment$32 r15 = new net.imedicaldoctor.imd.Fragments.downloadFragment$32     // Catch:{ Exception -> 0x0138 }
            r15.<init>()     // Catch:{ Exception -> 0x0138 }
            r21 = r12
            net.imedicaldoctor.imd.Fragments.downloadFragment$33 r12 = new net.imedicaldoctor.imd.Fragments.downloadFragment$33     // Catch:{ Exception -> 0x017c }
            r12.<init>(r0)     // Catch:{ Exception -> 0x017c }
            r22 = r5
            net.imedicaldoctor.imd.Fragments.downloadFragment$34 r5 = new net.imedicaldoctor.imd.Fragments.downloadFragment$34     // Catch:{ Exception -> 0x017a }
            r5.<init>(r0)     // Catch:{ Exception -> 0x017a }
            r10.f6(r15, r12, r5)     // Catch:{ Exception -> 0x017a }
            goto L_0x019c
        L_0x017a:
            r0 = move-exception
            goto L_0x017f
        L_0x017c:
            r0 = move-exception
            r22 = r5
        L_0x017f:
            com.google.firebase.crashlytics.FirebaseCrashlytics r5 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()
            r5.g(r0)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r10 = "Error in md5 capture with error "
            r5.append(r10)
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            java.lang.String r5 = "New MD5 Capture"
            android.util.Log.e(r5, r0)
        L_0x019c:
            r0 = r3
        L_0x019d:
            java.lang.String r5 = r2.getString(r7)
            boolean r5 = r5.equals(r3)
            java.lang.String r10 = "fileSize"
            if (r5 == 0) goto L_0x01af
            java.lang.String r5 = "0"
        L_0x01ab:
            r13.putString(r10, r5)
            goto L_0x01b4
        L_0x01af:
            if (r6 == 0) goto L_0x01b4
            r5 = r6[r14]
            goto L_0x01ab
        L_0x01b4:
            r13.putString(r9, r8)
            r13.putString(r4, r11)
            r4 = r22
            r13.putString(r4, r0)
            r5 = r21
            boolean r0 = r5.contains(r11)
            if (r0 == 0) goto L_0x01cc
            java.lang.String r0 = "completed"
            r13.putString(r0, r3)
        L_0x01cc:
            r8 = r18
            r8.add(r13)
            r12 = r5
            r11 = r8
            r8 = r16
            r14 = r19
            r10 = r20
            r5 = r4
            r4 = r17
            goto L_0x00c4
        L_0x01de:
            r10 = r4
            r8 = r11
            r2.putParcelableArrayList(r10, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.downloadFragment.L2(android.os.Bundle):void");
    }

    public void M0(Activity activity) {
        super.M0(activity);
        this.D4 = activity;
    }

    public void M2() {
        this.s4.setVisibility(8);
        SearchView searchView = this.m4;
        if (searchView != null) {
            searchView.clearFocus();
        }
        X3("Loading Databases");
        iMDLogger.f("DownloadAndLoadDBs", "Starting");
        if (!P2().booleanValue()) {
            iMDLogger.f("DownloadAndLoadDBs", "No Permission");
            X3("Storage Permission not granted. Tap to Allow");
            return;
        }
        this.I4.l(this).h6(Schedulers.e()).s4(AndroidSchedulers.e()).f6(new Consumer<String>() {
            /* renamed from: a */
            public void accept(String str) throws Throwable {
            }
        }, new Consumer<Throwable>() {
            /* renamed from: a */
            public void accept(Throwable th) throws Throwable {
                try {
                    iMDLogger.f("DownloadAndLoadDBs", "Error Occured");
                    downloadFragment.this.X3("Failed loading databases .tap to try again");
                } catch (Exception unused) {
                }
            }
        }, new Action() {
            public void run() throws Throwable {
                ArrayList unused = downloadFragment.W4 = null;
                Bundle unused2 = downloadFragment.this.h4 = null;
                downloadFragment.this.J3();
                LocalBroadcastManager.b(downloadFragment.this.r()).d(new Intent("reloadaccountdownloads"));
                downloadFragment.this.v3();
            }
        });
    }

    public String M3(long j2) {
        if (j2 <= 0) {
            return "0";
        }
        double d2 = (double) j2;
        int log10 = (int) (Math.log10(d2) / Math.log10(1024.0d));
        return new DecimalFormat("#,##0.#").format(d2 / Math.pow(1024.0d, (double) log10)) + StringUtils.SPACE + new String[]{"B", "KB", "MB", "GB", "TB"}[log10];
    }

    public String N2(String str) {
        if (this.o4.containsKey(str)) {
            return this.o4.getString(str);
        }
        return null;
    }

    public void N3() {
        iMDLogger.f("RefereshDBs", "Clicked");
        try {
            this.I4.j(this.I4.U1() + "/DBs.db");
            this.I4.j(this.I4.U1() + "/DBs.z");
            this.I4.j(this.I4.U1() + "/DBs.md5");
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
        }
        iMDLogger.f("RefreshDBs", "DownloadingAndLoadDBS");
        if (!K3()) {
            M2();
        }
    }

    public void O2() {
        if (!this.C4) {
            iMDLogger.f("download", "NotifyDatasetChange");
            this.j4.getRecycledViewPool().c();
            this.j4.getAdapter().G();
        }
    }

    public Observable<Bundle> O3() {
        return Observable.w1(new ObservableOnSubscribe<Bundle>() {
            public void a(@NonNull ObservableEmitter<Bundle> observableEmitter) throws Throwable {
                if (downloadFragment.this.f4 != null) {
                    for (String bundle : downloadFragment.this.f4.keySet()) {
                        Bundle bundle2 = downloadFragment.this.f4.getBundle(bundle);
                        if (downloadFragment.this.Y2(bundle2) != 100) {
                            observableEmitter.onNext(bundle2);
                        }
                    }
                    observableEmitter.onComplete();
                }
            }
        });
    }

    public Boolean P2() {
        return Boolean.TRUE;
    }

    public void Q0(Bundle bundle) {
        super.Q0(bundle);
        LocalBroadcastManager.b(z3()).c(this.M4, new IntentFilter("reloadDownloads"));
    }

    public void Q3() {
        try {
            iMDLogger.d("sendFavorite", "Sending FavoriteChanged message");
            LocalBroadcastManager.b(z3()).d(new Intent("referesh.account"));
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
        }
    }

    public int R2(Bundle bundle, String str) {
        if (bundle.containsKey(str)) {
            return bundle.getInt(str);
        }
        return 0;
    }

    public void R3(String str, Runnable runnable) {
        Q4.remove(str);
        Q4.put(str, runnable);
    }

    public Observable<String> S2() {
        return Observable.w1(new ObservableOnSubscribe<String>() {
            public void a(@NonNull ObservableEmitter<String> observableEmitter) throws Throwable {
            }
        });
    }

    public void S3(String str, Runnable runnable) {
        R4.remove(str);
        R4.put(str, runnable);
    }

    public void T0(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.f1409download, menu);
        final SearchView searchView = (SearchView) menu.findItem(R.id.f814action_search).getActionView();
        MenuItem findItem = menu.findItem(R.id.f1045progress_menu);
        this.k4 = findItem;
        this.l4 = (ProgressBar) findItem.getActionView();
        this.m4 = searchView;
        if (Build.VERSION.SDK_INT >= 26) {
            searchView.setImportantForAutofill(8);
        }
        searchView.setIconifiedByDefault(false);
        searchView.setQueryHint("Search Store");
        final String str = this.y4;
        this.m4.postDelayed(new Runnable() {
            public void run() {
                iMDLogger.j("DownloadFragment", "Running post delay");
                boolean unused = downloadFragment.this.B4 = true;
                downloadFragment.this.m4.k0(str, false);
                if (downloadFragment.this.A4 == null) {
                    iMDLogger.j("DownloadFragment", "mQuery is null");
                    return;
                }
                if (downloadFragment.this.A4.length() == 0) {
                    iMDLogger.j("DownloadFragment", "mQuery is 0 length !!");
                }
                if (downloadFragment.this.A4 != null && downloadFragment.this.A4.length() > 0) {
                    iMDLogger.j("DownloadFragment", "mQuery is " + downloadFragment.this.A4);
                    if (downloadFragment.N4 == null || downloadFragment.N4.size() == 0) {
                        iMDLogger.j("DownloadFragment", "setting query true");
                        downloadFragment downloadfragment = downloadFragment.this;
                        downloadfragment.m4.k0(downloadfragment.A4, true);
                    } else {
                        iMDLogger.j("DownloadFragment", "setting query false");
                        downloadFragment downloadfragment2 = downloadFragment.this;
                        downloadfragment2.m4.k0(downloadfragment2.A4, false);
                        downloadFragment.this.W3();
                    }
                    downloadFragment.this.B3();
                }
            }
        }, 10);
        this.B4 = false;
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            public boolean a(String str) {
                if (!downloadFragment.this.B4) {
                    return true;
                }
                if (downloadFragment.this.y4 == null && (str == null || str.length() == 0)) {
                    return true;
                }
                String unused = downloadFragment.this.y4 = str;
                String unused2 = downloadFragment.this.A4 = str;
                String unused3 = downloadFragment.a5 = str;
                downloadFragment.this.J3();
                return true;
            }

            public boolean b(String str) {
                return false;
            }
        });
        ((ImageView) searchView.findViewById(R.id.search_close_btn)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                searchView.k0("", false);
                searchView.clearFocus();
                String unused = downloadFragment.a5 = null;
                String unused2 = downloadFragment.this.y4 = null;
                String unused3 = downloadFragment.this.A4 = null;
                downloadFragment.this.J3();
                downloadFragment.this.B3();
            }
        });
        super.T0(menu, menuInflater);
    }

    public void T2(Bundle bundle, String str) {
        if (str.equals("downloader") && bundle.containsKey("id")) {
            Log.e("here", "here");
        }
        if (bundle.containsKey(str)) {
            bundle.remove(str);
        }
    }

    public void T3(String str, Runnable runnable) {
        S4.remove(str);
        S4.put(str, runnable);
    }

    public View onFragmentBind(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.E4 = Typeface.createFromAsset(r().getAssets(), "fonts/HelveticaNeue-Light.otf");
        this.f4 = new Bundle();
        ((iMD) r().getApplicationContext()).c3 = this;
        View inflate = layoutInflater.inflate(R.layout.f1222fragment_download, viewGroup, false);
        this.I4 = new CompressHelper(r());
        this.n4 = new VBHelper(r());
        if (bundle != null && bundle.containsKey("Query")) {
            this.A4 = bundle.getString("Query");
            iMDLogger.j("DownloadFragment", "Loading mQuery " + this.A4);
        }
        if (bundle != null && bundle.containsKey("LastStatus")) {
            this.G4 = bundle.getString("LastStatus");
        }
        this.i4 = inflate;
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.f1054recycler_view);
        this.j4 = recyclerView;
        recyclerView.setItemDecoration(new CustomItemDecoration(r()));
        BetterLinearLayoutManager betterLinearLayoutManager = new BetterLinearLayoutManager(z3(), 1, false);
        this.F4 = betterLinearLayoutManager;
        this.j4.setLayoutManager(betterLinearLayoutManager);
        this.j4.setItemAnimator((RecyclerView.ItemAnimator) null);
        o2(true);
        P4 = new HashMap<>();
        Q4 = new HashMap<>();
        R4 = new HashMap<>();
        S4 = new HashMap<>();
        T4 = new ArrayList<>();
        DownloadsAdapter downloadsAdapter = new DownloadsAdapter();
        this.J4 = downloadsAdapter;
        this.j4.setAdapter(downloadsAdapter);
        this.r4 = (TabLayout) this.i4.findViewById(R.id.f1109tab_layout);
        this.s4 = (CardView) this.i4.findViewById(R.id.f999load_screen);
        this.t4 = (ImageView) this.i4.findViewById(R.id.f998load_image);
        this.u4 = (Button) this.i4.findViewById(R.id.f997load_button);
        this.s4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                downloadFragment.this.M2();
            }
        });
        this.u4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                downloadFragment.this.M2();
            }
        });
        this.t4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                downloadFragment.this.M2();
            }
        });
        this.u4.setTypeface(this.E4);
        a5 = "";
        Y3();
        if (b5 == null) {
            b5 = new Bundle();
            d5 = new HashMap<>();
            this.r4.D(0).r();
            Q2();
            if (G3()) {
                M2();
            }
        } else {
            this.r4.D(c5).r();
        }
        this.r4.h(new TabLayout.OnTabSelectedListener() {
            public void a(TabLayout.Tab tab) {
            }

            public void b(TabLayout.Tab tab) {
                downloadFragment.c5 = tab.k();
                downloadFragment.this.J3();
            }

            public void c(TabLayout.Tab tab) {
            }
        });
        return this.i4;
    }

    public void U3(String str, CircleProgressView circleProgressView) {
        P4.remove(str);
        P4.put(str, circleProgressView);
    }

    public void onDestroy() {
        super.onDestroy();
        try {
            LocalBroadcastManager.b(z3()).f(this.M4);
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            e2.printStackTrace();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v17, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v19, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v21, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01d4  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x023d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void V2(android.os.Bundle r36) {
        /*
            r35 = this;
            r7 = r35
            r8 = r36
            java.lang.String r9 = "fileSize"
            java.lang.String r10 = "downloader"
            boolean r0 = r8.containsKey(r10)
            if (r0 == 0) goto L_0x000f
            return
        L_0x000f:
            java.lang.String r0 = "PartFileSize"
            boolean r1 = r8.containsKey(r0)
            if (r1 != 0) goto L_0x0018
            return
        L_0x0018:
            java.lang.String r0 = r8.getString(r0)
            java.lang.String r1 = ",,,"
            java.lang.String[] r0 = org.apache.commons.lang3.StringUtils.splitByWholeSeparator(r0, r1)
            if (r0 != 0) goto L_0x0025
            return
        L_0x0025:
            java.lang.String r0 = "Parts"
            boolean r1 = r8.containsKey(r0)
            if (r1 != 0) goto L_0x0030
            r35.L2(r36)
        L_0x0030:
            java.util.ArrayList r11 = r8.getParcelableArrayList(r0)
            net.imedicaldoctor.imd.Data.CompressHelper r0 = r7.I4
            java.lang.String r12 = r0.y()
            java.io.File r0 = new java.io.File
            r0.<init>(r12)
            long r1 = r0.getUsableSpace()
            java.lang.String r0 = r8.getString(r9)     // Catch:{ Exception -> 0x0050 }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ Exception -> 0x0050 }
            long r3 = r0.longValue()     // Catch:{ Exception -> 0x0050 }
            goto L_0x005d
        L_0x0050:
            r0 = move-exception
            com.google.firebase.crashlytics.FirebaseCrashlytics r3 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()
            r3.g(r0)
            r0.printStackTrace()
            r3 = 0
        L_0x005d:
            java.text.DecimalFormat r5 = new java.text.DecimalFormat
            java.lang.String r0 = "#,##0"
            r5.<init>(r0)
            androidx.fragment.app.FragmentActivity r0 = r35.V1()
            java.lang.String r6 = "default_preferences"
            r15 = 0
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r6, r15)
            java.lang.String r6 = "lessspace"
            boolean r0 = r0.getBoolean(r6, r15)
            java.lang.String r6 = "folderSizeKey"
            java.lang.String r16 = r8.getString(r6)
            java.lang.String r15 = ".download"
            java.lang.String r13 = "FileName"
            java.lang.String r14 = "/"
            r20 = r9
            r21 = r10
            java.lang.String r9 = "URL"
            if (r16 == 0) goto L_0x0240
            java.lang.String r6 = r8.getString(r6)
            java.lang.Double r6 = java.lang.Double.valueOf(r6)
            double r24 = r6.doubleValue()
            r26 = 4
            r10 = r6
            long r6 = r3 * r26
            double r6 = (double) r6
            r26 = 2
            int r16 = (r24 > r6 ? 1 : (r24 == r6 ? 0 : -1))
            if (r16 <= 0) goto L_0x00a9
            long r6 = r3 * r26
            double r6 = (double) r6
            java.lang.Double r6 = java.lang.Double.valueOf(r6)
            goto L_0x00aa
        L_0x00a9:
            r6 = r10
        L_0x00aa:
            r24 = 524288000(0x1f400000, double:2.590326893E-315)
            int r7 = (r3 > r24 ? 1 : (r3 == r24 ? 0 : -1))
            if (r7 <= 0) goto L_0x00c6
            if (r0 == 0) goto L_0x00c6
            double r6 = r6.doubleValue()     // Catch:{ Exception -> 0x00c2 }
            r24 = 9
            r16 = r9
            long r9 = r3 / r24
            double r9 = (double) r9     // Catch:{ Exception -> 0x00c0 }
            double r6 = r6 + r9
            goto L_0x00db
        L_0x00c0:
            r0 = move-exception
            goto L_0x00cf
        L_0x00c2:
            r0 = move-exception
            r16 = r9
            goto L_0x00cf
        L_0x00c6:
            r16 = r9
            double r9 = (double) r3     // Catch:{ Exception -> 0x00c0 }
            double r6 = r6.doubleValue()     // Catch:{ Exception -> 0x00c0 }
            double r6 = r6 + r9
            goto L_0x00db
        L_0x00cf:
            com.google.firebase.crashlytics.FirebaseCrashlytics r6 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()
            r6.g(r0)
            r0.printStackTrace()
            r6 = 0
        L_0x00db:
            java.lang.String r0 = "Delta"
            boolean r0 = r8.containsKey(r0)
            if (r0 == 0) goto L_0x00e6
            long r6 = r3 * r26
            double r6 = (double) r6
        L_0x00e6:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r9 = "Available : "
            r0.append(r9)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r9 = "download"
            net.imedicaldoctor.imd.iMDLogger.f(r9, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r10 = "FileSize : "
            r0.append(r10)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            net.imedicaldoctor.imd.iMDLogger.f(r9, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r10 = "Required : "
            r0.append(r10)
            r24 = r3
            long r3 = (long) r6
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            net.imedicaldoctor.imd.iMDLogger.f(r9, r0)
            r0 = 0
            r3 = 0
        L_0x012a:
            int r10 = r11.size()
            if (r0 >= r10) goto L_0x019c
            java.lang.Object r10 = r11.get(r0)
            android.os.Bundle r10 = (android.os.Bundle) r10
            r26 = r11
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r12)
            r11.append(r14)
            r27 = r14
            java.lang.String r14 = r10.getString(r13)
            r11.append(r14)
            java.lang.String r11 = r11.toString()
            r14 = r16
            r10.getString(r14)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r11)
            r10.append(r15)
            java.lang.String r10 = r10.toString()
            r16 = r15
            java.io.File r15 = new java.io.File
            r15.<init>(r10)
            boolean r15 = r15.exists()
            if (r15 == 0) goto L_0x017c
            java.io.File r15 = new java.io.File
            r15.<init>(r10)
            long r28 = r15.length()
            long r3 = r3 + r28
        L_0x017c:
            java.io.File r10 = new java.io.File
            r10.<init>(r11)
            boolean r10 = r10.exists()
            if (r10 == 0) goto L_0x0191
            java.io.File r10 = new java.io.File
            r10.<init>(r11)
            long r10 = r10.length()
            long r3 = r3 + r10
        L_0x0191:
            int r0 = r0 + 1
            r15 = r16
            r11 = r26
            r16 = r14
            r14 = r27
            goto L_0x012a
        L_0x019c:
            r26 = r11
            r27 = r14
            r14 = r16
            r16 = r15
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r10 = "Used : "
            r0.append(r10)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            net.imedicaldoctor.imd.iMDLogger.f(r9, r0)
            double r3 = (double) r3
            double r6 = r6 - r3
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "Required Really : "
            r0.append(r3)
            long r3 = (long) r6
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            net.imedicaldoctor.imd.iMDLogger.f(r9, r0)
            double r0 = (double) r1
            int r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r2 >= 0) goto L_0x023d
            androidx.appcompat.app.AlertDialog$Builder r2 = new androidx.appcompat.app.AlertDialog$Builder
            android.app.Activity r3 = r35.z3()
            r4 = 2132018351(0x7f1404af, float:1.9675006E38)
            r2.<init>(r3, r4)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "You need at least "
            r3.append(r4)
            r8 = 4652218415073722368(0x4090000000000000, double:1024.0)
            double r6 = r6 / r8
            double r6 = r6 / r8
            java.lang.String r4 = r5.format(r6)
            r3.append(r4)
            java.lang.String r4 = " MB available . you already have "
            r3.append(r4)
            double r0 = r0 / r8
            double r0 = r0 / r8
            java.lang.String r0 = r5.format(r0)
            r3.append(r0)
            java.lang.String r0 = " MB Available. Please free up some space . \n After install "
            r3.append(r0)
            r13 = r24
            double r0 = (double) r13
            double r0 = r0 / r8
            double r0 = r0 / r8
            java.lang.String r0 = r5.format(r0)
            r3.append(r0)
            java.lang.String r0 = " MB would be freed"
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            androidx.appcompat.app.AlertDialog$Builder r0 = r2.l(r0)
            net.imedicaldoctor.imd.Fragments.downloadFragment$36 r1 = new net.imedicaldoctor.imd.Fragments.downloadFragment$36
            r7 = r35
            r1.<init>()
            java.lang.String r2 = "OK"
            androidx.appcompat.app.AlertDialog$Builder r0 = r0.y(r2, r1)
            net.imedicaldoctor.imd.Fragments.downloadFragment$35 r1 = new net.imedicaldoctor.imd.Fragments.downloadFragment$35
            r1.<init>()
            java.lang.String r2 = "Change Download Path"
            androidx.appcompat.app.AlertDialog$Builder r0 = r0.p(r2, r1)
            r0.I()
            return
        L_0x023d:
            r7 = r35
            goto L_0x0247
        L_0x0240:
            r26 = r11
            r27 = r14
            r16 = r15
            r14 = r9
        L_0x0247:
            java.lang.String r0 = r8.getString(r14)
            java.lang.String r9 = "StartDownload"
            net.imedicaldoctor.imd.iMDLogger.d(r9, r0)
            java.lang.String r0 = "retry"
            r7.T2(r8, r0)
            java.lang.String r0 = "Buy"
            r7.T2(r8, r0)
            java.lang.String r0 = "error"
            r7.T2(r8, r0)
            java.lang.String r10 = ""
            r11 = r21
            r8.putString(r11, r10)
            r35.X2(r36)
            java.lang.String r15 = "id"
            java.lang.String r21 = r8.getString(r15)
            r1 = 0
            r6 = 0
        L_0x0272:
            int r3 = r26.size()
            java.lang.String r5 = "SpeedReceived"
            if (r6 >= r3) goto L_0x0428
            r4 = r26
            java.lang.Object r3 = r4.get(r6)
            android.os.Bundle r3 = (android.os.Bundle) r3
            java.lang.String r3 = r3.getString(r14)
            r24 = r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r25 = r15
            java.lang.String r15 = "Started : "
            r5.append(r15)
            r5.append(r3)
            java.lang.String r5 = r5.toString()
            net.imedicaldoctor.imd.iMDLogger.d(r9, r5)
            java.lang.Object r5 = r4.get(r6)
            r15 = r5
            android.os.Bundle r15 = (android.os.Bundle) r15
            java.lang.String r5 = "bytesDownloaded"
            r28 = r1
            r1 = 0
            r15.putDouble(r5, r1)
            java.lang.String r5 = "bytesTotal"
            r15.putDouble(r5, r1)
            java.lang.String r5 = "remaining"
            r1 = 0
            r15.putLong(r5, r1)
            java.lang.String r5 = "avgSpeed"
            r15.putLong(r5, r1)
            java.lang.String r5 = "Progress"
            r4 = 0
            r15.putInt(r5, r4)
            r7.T2(r15, r0)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r12)
            r17 = r12
            r12 = r27
            r5.append(r12)
            java.lang.String r1 = r15.getString(r13)
            r5.append(r1)
            java.lang.String r1 = r5.toString()
            java.lang.String r2 = "completed"
            boolean r5 = r15.containsKey(r2)
            if (r5 == 0) goto L_0x034d
            java.io.File r5 = new java.io.File
            r5.<init>(r1)
            long r4 = r5.length()
            r30 = r12
            r12 = r20
            java.lang.String r20 = r8.getString(r12)
            java.lang.Long r20 = java.lang.Long.valueOf(r20)
            r32 = r12
            r31 = r13
            long r12 = r20.longValue()
            r20 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r3)
            java.lang.String r8 = " Already Downloaded. With File Size "
            r0.append(r8)
            r0.append(r4)
            java.lang.String r8 = ", Master file size : "
            r0.append(r8)
            r0.append(r12)
            java.lang.String r0 = r0.toString()
            net.imedicaldoctor.imd.iMDLogger.d(r9, r0)
            r33 = 11
            long r12 = r12 / r33
            int r0 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r0 >= 0) goto L_0x036f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r3)
            java.lang.String r4 = " Already Downloaded. Very Low file size. Restarting"
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            net.imedicaldoctor.imd.iMDLogger.d(r9, r0)
            net.imedicaldoctor.imd.Data.CompressHelper r0 = r7.I4
            r0.j(r1)
            r7.T2(r15, r2)
            goto L_0x0355
        L_0x034d:
            r30 = r12
            r31 = r13
            r32 = r20
            r20 = r0
        L_0x0355:
            boolean r0 = r15.containsKey(r11)
            if (r0 == 0) goto L_0x0383
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r3)
            java.lang.String r1 = " has Downloaderkey"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            net.imedicaldoctor.imd.iMDLogger.d(r9, r0)
        L_0x036f:
            r34 = r6
            r33 = r9
            r24 = r10
            r27 = r16
            r16 = r26
            r1 = r28
            r18 = 0
            r22 = 0
            r26 = 0
            goto L_0x040e
        L_0x0383:
            java.lang.String r0 = r15.getString(r14)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            r8 = r16
            r2.append(r8)
            java.lang.String r2 = r2.toString()
            java.io.File r3 = new java.io.File
            r3.<init>(r2)
            boolean r3 = r3.exists()
            if (r3 == 0) goto L_0x03b2
            java.io.File r3 = new java.io.File
            r3.<init>(r2)
            long r2 = r3.length()
            long r4 = r28 + r2
            r12 = r2
            r28 = r4
            goto L_0x03b4
        L_0x03b2:
            r12 = 0
        L_0x03b4:
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            java.lang.String r3 = "Go"
            r2.putString(r3, r10)
            r7.T2(r15, r11)
            r15.putBundle(r11, r2)
            net.imedicaldoctor.imd.Data.CompressHelper r2 = r7.I4
            io.reactivex.rxjava3.core.Observable r1 = r2.U0(r0, r1, r15)
            io.reactivex.rxjava3.core.Scheduler r2 = io.reactivex.rxjava3.schedulers.Schedulers.e()
            io.reactivex.rxjava3.core.Observable r1 = r1.h6(r2)
            io.reactivex.rxjava3.core.Scheduler r2 = io.reactivex.rxjava3.android.schedulers.AndroidSchedulers.e()
            io.reactivex.rxjava3.core.Observable r5 = r1.s4(r2)
            net.imedicaldoctor.imd.Fragments.downloadFragment$37 r4 = new net.imedicaldoctor.imd.Fragments.downloadFragment$37
            r18 = 0
            r22 = 0
            r1 = r4
            r2 = r35
            r3 = r21
            r27 = r8
            r16 = r26
            r26 = 0
            r8 = r4
            r4 = r6
            r33 = r9
            r9 = r24
            r24 = r10
            r10 = r5
            r5 = r0
            r34 = r6
            r6 = r17
            r1.<init>(r3, r4, r5, r6)
            r10.a(r8)
            java.util.HashMap<java.lang.String, io.reactivex.rxjava3.observers.DisposableObserver<java.net.HttpURLConnection>> r1 = d5
            r1.remove(r0)
            java.util.HashMap<java.lang.String, io.reactivex.rxjava3.observers.DisposableObserver<java.net.HttpURLConnection>> r1 = d5
            r1.put(r0, r8)
            r15.putLong(r9, r12)
            r1 = r28
        L_0x040e:
            int r6 = r34 + 1
            r8 = r36
            r26 = r16
            r12 = r17
            r0 = r20
            r10 = r24
            r15 = r25
            r16 = r27
            r27 = r30
            r13 = r31
            r20 = r32
            r9 = r33
            goto L_0x0272
        L_0x0428:
            r28 = r1
            r9 = r5
            r25 = r15
            r35.w3(r36)
            r1 = r36
            r2 = r28
            r1.putLong(r9, r2)
            android.os.Bundle r0 = r7.f4
            r2 = r25
            java.lang.String r3 = r1.getString(r2)
            boolean r0 = r0.containsKey(r3)
            if (r0 == 0) goto L_0x044e
            android.os.Bundle r0 = r7.f4
            java.lang.String r3 = r1.getString(r2)
            r0.remove(r3)
        L_0x044e:
            android.os.Bundle r0 = r7.f4
            java.lang.String r2 = r1.getString(r2)
            r0.putBundle(r2, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.downloadFragment.V2(android.os.Bundle):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x00ad, code lost:
        if (V1().getSharedPreferences("default_preferences", 0).contains(r0) != false) goto L_0x00af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00f1, code lost:
        if (V1().getSharedPreferences("default_preferences", 0).contains(r0) != false) goto L_0x00af;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void V3(android.os.Bundle r6, java.lang.String r7) {
        /*
            r5 = this;
            java.lang.String r0 = "DownloadPath"
            boolean r1 = r7.equals(r0)
            r2 = 0
            java.lang.String r3 = "default_preferences"
            if (r1 == 0) goto L_0x0056
            if (r6 == 0) goto L_0x00f4
            androidx.fragment.app.FragmentActivity r7 = r5.V1()
            android.content.SharedPreferences r7 = r7.getSharedPreferences(r3, r2)
            boolean r7 = r7.contains(r0)
            if (r7 == 0) goto L_0x002e
            androidx.fragment.app.FragmentActivity r7 = r5.V1()
            android.content.SharedPreferences r7 = r7.getSharedPreferences(r3, r2)
            android.content.SharedPreferences$Editor r7 = r7.edit()
            android.content.SharedPreferences$Editor r7 = r7.remove(r0)
            r7.commit()
        L_0x002e:
            androidx.fragment.app.FragmentActivity r7 = r5.V1()
            android.content.SharedPreferences r7 = r7.getSharedPreferences(r3, r2)
            android.content.SharedPreferences$Editor r7 = r7.edit()
            java.lang.String r1 = "Path"
            java.lang.String r6 = r6.getString(r1)
            android.content.SharedPreferences$Editor r6 = r7.putString(r0, r6)
            r6.commit()
            androidx.fragment.app.FragmentActivity r6 = r5.r()
            android.content.Context r6 = r6.getApplicationContext()
            net.imedicaldoctor.imd.iMD r6 = (net.imedicaldoctor.imd.iMD) r6
            r7 = 0
            r6.Z = r7
            goto L_0x00f4
        L_0x0056:
            java.lang.String r0 = "Tab"
            boolean r1 = r7.equals(r0)
            java.lang.String r4 = "Title"
            if (r1 == 0) goto L_0x0099
            androidx.fragment.app.FragmentActivity r7 = r5.V1()
            android.content.SharedPreferences r7 = r7.getSharedPreferences(r3, r2)
            boolean r7 = r7.contains(r0)
            if (r7 == 0) goto L_0x0081
            androidx.fragment.app.FragmentActivity r7 = r5.V1()
            android.content.SharedPreferences r7 = r7.getSharedPreferences(r3, r2)
            android.content.SharedPreferences$Editor r7 = r7.edit()
            android.content.SharedPreferences$Editor r7 = r7.remove(r0)
            r7.commit()
        L_0x0081:
            androidx.fragment.app.FragmentActivity r7 = r5.V1()
            android.content.SharedPreferences r7 = r7.getSharedPreferences(r3, r2)
            android.content.SharedPreferences$Editor r7 = r7.edit()
            java.lang.String r6 = r6.getString(r4)
            android.content.SharedPreferences$Editor r6 = r7.putString(r0, r6)
            r6.commit()
            goto L_0x00f4
        L_0x0099:
            java.lang.String r0 = "SearchResult"
            boolean r1 = r7.equals(r0)
            if (r1 == 0) goto L_0x00dd
            androidx.fragment.app.FragmentActivity r7 = r5.V1()
            android.content.SharedPreferences r7 = r7.getSharedPreferences(r3, r2)
            boolean r7 = r7.contains(r0)
            if (r7 == 0) goto L_0x00c2
        L_0x00af:
            androidx.fragment.app.FragmentActivity r7 = r5.V1()
            android.content.SharedPreferences r7 = r7.getSharedPreferences(r3, r2)
            android.content.SharedPreferences$Editor r7 = r7.edit()
            android.content.SharedPreferences$Editor r7 = r7.remove(r0)
            r7.commit()
        L_0x00c2:
            androidx.fragment.app.FragmentActivity r7 = r5.V1()
            android.content.SharedPreferences r7 = r7.getSharedPreferences(r3, r2)
            android.content.SharedPreferences$Editor r7 = r7.edit()
            java.lang.String r6 = r6.getString(r4)
            android.content.SharedPreferences$Editor r6 = r7.putString(r0, r6)
            r6.commit()
            r5.O2()
            goto L_0x00f4
        L_0x00dd:
            java.lang.String r0 = "ContentSearchResult"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x00f4
            androidx.fragment.app.FragmentActivity r7 = r5.V1()
            android.content.SharedPreferences r7 = r7.getSharedPreferences(r3, r2)
            boolean r7 = r7.contains(r0)
            if (r7 == 0) goto L_0x00c2
            goto L_0x00af
        L_0x00f4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.downloadFragment.V3(android.os.Bundle, java.lang.String):void");
    }

    public void W2(final Bundle bundle) {
        T2(bundle, "downloader");
        X2(bundle);
        this.I4.H0(z3(), Observable.w1(new ObservableOnSubscribe<String>() {
            public void a(@NonNull ObservableEmitter<String> observableEmitter) throws Throwable {
                ArrayList parcelableArrayList;
                iMDLogger.d("StopDownload", bundle.getString("URL"));
                if (bundle.containsKey("Parts") && (parcelableArrayList = bundle.getParcelableArrayList("Parts")) != null) {
                    for (int i2 = 0; i2 < parcelableArrayList.size(); i2++) {
                        Bundle bundle = (Bundle) parcelableArrayList.get(i2);
                        if (bundle.containsKey("downloader")) {
                            downloadFragment.this.T2(bundle.getBundle("downloader"), "Go");
                            bundle.remove("downloader");
                        }
                    }
                    bundle.remove("downloader");
                    bundle.remove("Parts");
                }
            }
        })).d6(new Consumer<String>() {
            /* renamed from: a */
            public void accept(String str) throws Throwable {
                downloadFragment.this.X2(bundle);
            }
        });
    }

    public void W3() {
        DownloadsAdapter downloadsAdapter;
        if (!this.C4 && this.j4.getAdapter() != (downloadsAdapter = this.J4)) {
            this.j4.setAdapter(downloadsAdapter);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00c2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void X2(android.os.Bundle r5) {
        /*
            r4 = this;
            boolean r0 = r4.C4
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            java.lang.String r0 = "videoIdKey"
            boolean r1 = r5.containsKey(r0)
            if (r1 == 0) goto L_0x004b
            java.util.HashMap<java.lang.String, at.grabner.circleprogress.CircleProgressView> r1 = P4
            java.lang.String r2 = r5.getString(r0)
            boolean r1 = r1.containsKey(r2)
            if (r1 == 0) goto L_0x002f
            java.util.HashMap<java.lang.String, at.grabner.circleprogress.CircleProgressView> r1 = P4
            java.lang.String r2 = r5.getString(r0)
            java.lang.Object r1 = r1.get(r2)
            at.grabner.circleprogress.CircleProgressView r1 = (at.grabner.circleprogress.CircleProgressView) r1
            java.lang.String r2 = "Progress"
            int r2 = r4.R2(r5, r2)
            float r2 = (float) r2
            r1.setValue(r2)
        L_0x002f:
            java.util.HashMap<java.lang.String, java.lang.Runnable> r1 = S4
            java.lang.String r2 = r5.getString(r0)
            boolean r1 = r1.containsKey(r2)
            if (r1 == 0) goto L_0x004a
            java.util.HashMap<java.lang.String, java.lang.Runnable> r1 = S4
            java.lang.String r5 = r5.getString(r0)
            java.lang.Object r5 = r1.get(r5)
            java.lang.Runnable r5 = (java.lang.Runnable) r5
            r5.run()
        L_0x004a:
            return
        L_0x004b:
            java.util.ArrayList<android.os.Bundle> r0 = N4
            if (r0 == 0) goto L_0x00e7
            android.os.Bundle r0 = r4.e4
            if (r0 == 0) goto L_0x00e7
            java.lang.String r1 = "id"
            java.lang.String r2 = r5.getString(r1)
            boolean r0 = r0.containsKey(r2)
            if (r0 == 0) goto L_0x00e7
            androidx.recyclerview.widget.RecyclerView r0 = r4.j4
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r0.getLayoutManager()
            net.imedicaldoctor.imd.Fragments.downloadFragment$BetterLinearLayoutManager r0 = (net.imedicaldoctor.imd.Fragments.downloadFragment.BetterLinearLayoutManager) r0
            int r2 = r0.B2()     // Catch:{ Exception -> 0x0072 }
            int r0 = r0.E2()     // Catch:{ Exception -> 0x0070 }
            goto L_0x0084
        L_0x0070:
            r0 = move-exception
            goto L_0x0074
        L_0x0072:
            r0 = move-exception
            r2 = 0
        L_0x0074:
            com.google.firebase.crashlytics.FirebaseCrashlytics r3 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()
            r3.g(r0)
            java.lang.String r0 = "DownloadFragment"
            java.lang.String r3 = "Error in getting first and last visible position"
            net.imedicaldoctor.imd.iMDLogger.f(r0, r3)
            r0 = 10000(0x2710, float:1.4013E-41)
        L_0x0084:
            android.os.Bundle r3 = r4.e4
            java.lang.String r5 = r5.getString(r1)
            int r5 = r3.getInt(r5)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Contains "
            r1.append(r3)
            r1.append(r5)
            java.lang.String r3 = " . first : "
            r1.append(r3)
            r1.append(r2)
            java.lang.String r3 = ", Last : "
            r1.append(r3)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            java.lang.String r3 = "download"
            net.imedicaldoctor.imd.iMDLogger.f(r3, r1)
            r1 = -1
            if (r2 != r1) goto L_0x00c2
            androidx.recyclerview.widget.RecyclerView r5 = r4.j4
            net.imedicaldoctor.imd.Fragments.downloadFragment$DownloadsAdapter r0 = new net.imedicaldoctor.imd.Fragments.downloadFragment$DownloadsAdapter
            r0.<init>()
            r5.setAdapter(r0)
            return
        L_0x00c2:
            if (r5 < r2) goto L_0x00e7
            if (r5 > r0) goto L_0x00e7
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "NotifyItemChanged "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            net.imedicaldoctor.imd.iMDLogger.d(r3, r0)
            boolean r0 = r4.C4
            if (r0 != 0) goto L_0x00e7
            androidx.recyclerview.widget.RecyclerView r0 = r4.j4
            androidx.recyclerview.widget.RecyclerView$Adapter r0 = r0.getAdapter()
            r0.H(r5)
        L_0x00e7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.downloadFragment.X2(android.os.Bundle):void");
    }

    public void X3(String str) {
        RecyclerView recyclerView;
        RecyclerView.Adapter statusAdapter;
        this.j4.setLayoutManager(new BetterLinearLayoutManager(r(), 1, false));
        if (str.toLowerCase().contains("Tap to".toLowerCase())) {
            recyclerView = this.j4;
            statusAdapter = new StatusAdapter(r(), str) {
                public void d0() {
                    downloadFragment.this.N3();
                }
            };
        } else {
            recyclerView = this.j4;
            statusAdapter = new StatusAdapter(r(), str);
        }
        recyclerView.setAdapter(statusAdapter);
    }

    public int Y2(Bundle bundle) {
        double d2;
        float f2;
        String str;
        long j2;
        String str2;
        double d3;
        StringBuilder sb;
        Bundle bundle2 = bundle;
        if (bundle2.containsKey("error") || !bundle2.containsKey("downloader")) {
            return 100;
        }
        String y = this.I4.y();
        ArrayList parcelableArrayList = bundle2.getParcelableArrayList("Parts");
        if (parcelableArrayList == null) {
            return 100;
        }
        double d4 = 0.0d;
        long j3 = 0;
        for (int i2 = 0; i2 < parcelableArrayList.size(); i2++) {
            Bundle bundle3 = (Bundle) parcelableArrayList.get(i2);
            if (bundle3.containsKey("completed")) {
                sb.append(y);
                sb.append("/");
                sb.append(bundle3.getString("FileName"));
                d4 += (double) new File(sb.toString()).length();
            } else {
                sb = new StringBuilder();
                sb.append(y);
                sb.append("/");
                sb.append(bundle3.getString("FileName"));
                sb.append(".download");
                String sb2 = sb.toString();
                long length = new File(sb2).exists() ? new File(sb2).length() : 0;
                d4 += (double) length;
                j3 += length;
            }
        }
        double doubleValue = Double.valueOf(bundle2.getString("fileSize")).doubleValue();
        float f3 = d4 > 0.0d ? (((float) d4) / ((float) doubleValue)) * 100.0f : 0.0f;
        long j6 = j3 - bundle2.getLong(J5);
        if (j6 < 0) {
            j6 = 0;
        } else {
            T2(bundle2, J5);
            bundle2.putLong(J5, j3);
        }
        long time = new Date().getTime();
        if (bundle2.containsKey("DateUpdated")) {
            f2 = f3;
            long j7 = bundle2.getLong("DateUpdated");
            if (bundle2.containsKey("bytesDownloaded")) {
                str2 = "bytesDownloaded";
                d3 = bundle2.getDouble("bytesDownloaded");
            } else {
                str2 = "bytesDownloaded";
                d3 = 0.0d;
            }
            d2 = doubleValue;
            Log.e("New Speed", "Received: " + d4 + " , OldDownloaded : " + d3 + ", DAtenow : " + time + ", Date prev :" + j7);
            T2(bundle2, "DateUpdated");
            bundle2.putLong("DateUpdated", time);
            j2 = (long) ((d4 - d3) / (((double) (time - j7)) / 1000.0d));
            str = str2;
        } else {
            d2 = doubleValue;
            f2 = f3;
            bundle2.putLong("DateUpdated", time);
            str = "bytesDownloaded";
            j2 = 0;
        }
        T2(bundle2, str);
        T2(bundle2, "bytesTotal");
        T2(bundle2, "Progress");
        T2(bundle2, "remaining");
        T2(bundle2, "avgSpeed");
        bundle2.putLong("avgSpeed", j2);
        J2((int) j6, bundle2.getString("URL"));
        bundle2.putDouble(str, d4);
        double d6 = d2;
        bundle2.putDouble("bytesTotal", d6);
        bundle2.putLong("remaining", j2 > 0 ? ((long) (d6 - d4)) / j2 : 0);
        bundle2.putInt("Progress", (int) f2);
        return f2 == 100.0f ? 50 : 0;
    }

    public void Y3() {
        iMDLogger.f("downloadFragment", "Start Reloading Tables");
        Timer timer = new Timer();
        this.w4 = timer;
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                downloadFragment.this.K4.obtainMessage(1).sendToTarget();
            }
        }, ExoPlayer.a1, ExoPlayer.a1);
    }

    public boolean Z3(String str) {
        Bundle x3 = x3(str);
        if (x3 == null) {
            return false;
        }
        V2(x3);
        return true;
    }

    public boolean a4(String str) {
        Bundle x3 = x3(str);
        if (x3 == null) {
            return false;
        }
        W2(x3);
        return true;
    }

    public void b4() {
        try {
            O3().h6(Schedulers.e()).s4(AndroidSchedulers.e()).e6(new Consumer<Bundle>() {
                /* renamed from: a */
                public void accept(Bundle bundle) throws Throwable {
                    if (bundle.getInt("Progress") == 100) {
                        iMDLogger.f("downloadFragment", "Update " + bundle.getString("id") + " progress is 100!!!!");
                        downloadFragment.this.w3(bundle);
                        return;
                    }
                    downloadFragment.this.X2(bundle);
                }
            }, new Consumer<Throwable>() {
                /* renamed from: a */
                public void accept(Throwable th) throws Throwable {
                    try {
                        iMDLogger.f("UpdateStatus", "Error occured in reloading tables : " + th.getMessage());
                        th.printStackTrace();
                    } catch (Exception e2) {
                        FirebaseCrashlytics.d().g(e2);
                        Log.e("FoundIT", "FoundIT . it was here in updatestatus");
                    }
                }
            });
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
        }
    }

    public boolean e1(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.f1055referesh_button) {
            return super.e1(menuItem);
        }
        if (C3()) {
            new AlertDialog.Builder(z3(), R.style.f2185alertDialogTheme).l("You are downloading some files, if you do this, your downloads would cancel ? are you sure ?").y("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    downloadFragment.this.N3();
                }
            }).p("Hell, No", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                }
            }).I();
            return true;
        }
        N3();
        return true;
    }

    public void m1(Bundle bundle) {
        super.m1(bundle);
    }

    public void u3(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Bundle bundle = new Bundle();
        bundle.putString("Title", str);
        bundle.putString("URL", str2);
        bundle.putString("FileName", str5);
        bundle.putString("fileSize", str4);
        bundle.putString("Icon", "");
        bundle.putString("name", str5);
        bundle.putString("videoIdKey", str6);
        bundle.putString("id", str6);
        bundle.putString(I5, IcyHeaders.a3);
        bundle.putString("PartFileSize", str7);
        bundle.putString("savePathKey", str3);
        if (U4 == null) {
            U4 = new HashMap<>();
        }
        if (N4 == null) {
            N4 = new ArrayList<>();
        }
        if (T4 == null) {
            T4 = new ArrayList<>();
        }
        U4.put(str6, bundle);
        N4.add(bundle);
        T4.add(bundle);
    }

    public void v3() {
        iMDLogger.j("CheckDBsMD5", "Checking DBs MD5");
        this.I4.T0(this.I4.getBaseUrl() + "/dbs.md5", this.I4.U1() + "/DBs.md5").h6(Schedulers.e()).s4(AndroidSchedulers.e()).f6(new Consumer<String>() {
            /* renamed from: a */
            public void accept(String str) throws Throwable {
            }
        }, new Consumer<Throwable>() {
            /* renamed from: a */
            public void accept(Throwable th) throws Throwable {
                try {
                    iMDLogger.f("CheckDBSMD5", "Error in downloading dbs.md5 " + th.getMessage());
                    th.printStackTrace();
                } catch (Exception unused) {
                }
            }
        }, new Action() {
            public void run() throws Throwable {
                if (new File(downloadFragment.this.I4.U1() + "/DBs.md5").exists()) {
                    try {
                        String e2 = CompressHelper.e2(new File(downloadFragment.this.I4.U1() + "/DBs.md5"));
                        CompressHelper compressHelper = downloadFragment.this.I4;
                        if (e2.equalsIgnoreCase(compressHelper.P1(new File(downloadFragment.this.I4.U1() + "/DBs.db")).replace(StringUtils.LF, ""))) {
                            iMDLogger.j("CheckDBsMD5", "MD5s match , don't delete it");
                            return;
                        }
                        iMDLogger.j("CheckDBsMD5", "MD5s dont match ,  delete it");
                        if (!downloadFragment.this.C3()) {
                            iMDLogger.j("CheckDBsMD5", "Isn't downloading . ");
                            downloadFragment.this.N3();
                        }
                    } catch (Exception e3) {
                        FirebaseCrashlytics.d().g(e3);
                        iMDLogger.f("CheckDBsMD5", "Error in comparing md5 of dbs.db : " + e3.getMessage());
                        e3.printStackTrace();
                    }
                }
            }
        });
    }

    public void w3(final Bundle bundle) {
        ArrayList parcelableArrayList;
        if (!bundle.containsKey("completed") && (parcelableArrayList = bundle.getParcelableArrayList("Parts")) != null) {
            boolean z = false;
            boolean z2 = true;
            for (int i2 = 0; i2 < parcelableArrayList.size(); i2++) {
                if (!((Bundle) parcelableArrayList.get(i2)).containsKey("completed")) {
                    z2 = false;
                }
            }
            if (parcelableArrayList.size() >= 10) {
                z = z2;
            }
            if (z) {
                iMDLogger.f("Completed", bundle.getString("URL") + " Download completed ");
                bundle.putString("Rebuilding", "");
                bundle.putString("completed", "");
                T2(bundle, "downloader");
                X2(bundle);
                if (!bundle.getString("FileName").contains(".zip") || Long.valueOf(bundle.getString("fileSize")).longValue() <= 524288000) {
                    this.I4.H0(z3(), F3(bundle)).f6(new Consumer<String>() {
                        /* renamed from: a */
                        public void accept(String str) throws Throwable {
                        }
                    }, new Consumer<Throwable>() {
                        /* renamed from: a */
                        public void accept(Throwable th) throws Throwable {
                            try {
                                String y = downloadFragment.this.I4.y();
                                File file = new File(y + "/" + bundle.getString("FileName"));
                                if (file.exists()) {
                                    downloadFragment.this.I4.j(file.getAbsolutePath());
                                }
                                downloadFragment.this.T2(bundle, "Rebuilding");
                                downloadFragment.this.T2(bundle, "completed");
                                downloadFragment.this.T2(bundle, "downloader");
                                downloadFragment.this.T2(bundle, "error");
                                Bundle bundle = bundle;
                                bundle.putString("error", "Rebuild failed : " + th.getMessage());
                                downloadFragment.this.X2(bundle);
                            } catch (Exception unused) {
                            }
                        }
                    }, new Action() {
                        public void run() throws Throwable {
                            downloadFragment.this.T2(bundle, "Rebuilding");
                            downloadFragment.this.T2(bundle, "completed");
                            downloadFragment.this.X2(bundle);
                            if (downloadFragment.this.f4.containsKey(bundle.getString("id"))) {
                                downloadFragment.this.f4.remove(bundle.getString("id"));
                            }
                            LocalBroadcastManager.b(downloadFragment.this.z3()).d(new Intent("checkzip"));
                            if (bundle.containsKey("videoIdKey")) {
                                String string = bundle.getString("videoIdKey");
                                if (downloadFragment.Q4.containsKey(string)) {
                                    try {
                                        ((Runnable) downloadFragment.Q4.get(string)).run();
                                    } catch (Exception e2) {
                                        FirebaseCrashlytics.d().g(e2);
                                    }
                                }
                            }
                        }
                    });
                    return;
                }
                T2(bundle, "Rebuilding");
                if (this.f4.containsKey(bundle.getString("id"))) {
                    this.f4.remove(bundle.getString("id"));
                }
                X2(bundle);
                LocalBroadcastManager.b(z3()).d(new Intent("checkzip"));
            }
        }
    }

    public Bundle x3(String str) {
        HashMap<String, Bundle> hashMap = U4;
        if (hashMap != null && hashMap.containsKey(str)) {
            return U4.get(str);
        }
        return null;
    }

    public String y3(String str) {
        ArrayList arrayList = new ArrayList(Arrays.asList(StringUtils.splitByWholeSeparator(str, "/")));
        String str2 = (String) arrayList.get(arrayList.size() - 1);
        arrayList.remove(arrayList.size() - 1);
        try {
            str = StringUtils.join((Iterable<?>) arrayList, "/") + "/" + UrlEscapers.b().b(str2);
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
        }
        return str.replace("http:/", "http://");
    }

    public Activity z3() {
        return this.D4;
    }
}
