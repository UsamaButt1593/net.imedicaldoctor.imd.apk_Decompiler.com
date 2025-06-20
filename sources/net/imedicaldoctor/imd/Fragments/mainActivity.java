package net.imedicaldoctor.imd.Fragments;

import static org.apache.commons.lang3.ClassUtils.getPackageName;

import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.google.common.base.Charsets;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.itextpdf.text.Annotation;
import com.itextpdf.tool.xml.html.HTML;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;
import it.neokree.materialtabs.MaterialTabHost;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Data.HistoryAdapter;
import net.imedicaldoctor.imd.NotificationActivity;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.TabsPagerAdapter;
import net.imedicaldoctor.imd.Utils.iMDWebView;
import net.imedicaldoctor.imd.VBHelper;
import net.imedicaldoctor.imd.extractingFragment;
import net.imedicaldoctor.imd.iMD;
import net.imedicaldoctor.imd.iMDLogger;
import org.apache.commons.lang3.StringUtils;

public class mainActivity extends AppCompatActivity implements ActionBar.TabListener {
    private static String V3 = null;
    public static int W3 = 1234;
    /* access modifiers changed from: private */
    public ActionBar A3;
    private MaterialTabHost B3;
    private final String[] C3 = {"Titles", "Databases", "Favorites", "Content", "Store", "Account"};
    private extractingFragment D3;
    private InstallingFragment E3;
    private ActionMode F3 = null;
    /* access modifiers changed from: private */
    public boolean G3;
    /* access modifiers changed from: private */
    public SlidingPaneLayout slidingPaneLayout;
    private Timer tryUpdateAppTimer;
    public CompressHelper compressHelper;
    public RecyclerView recyclerView;
    private Toolbar toolbar;
    /* access modifiers changed from: private */
    public TabLayout tabLayout;
    /* access modifiers changed from: private */
    public DrawerLayout drawerLayout;
    public String O3;
    /* access modifiers changed from: private */
    public long extraDownloadId;
    private final String Q3 = "android.intent.action.DOWNLOAD_COMPLETE";
    private final IntentFilter downloadCompleteIntentFilter = new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE");
    private final BroadcastReceiver S3 = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            try {
                long extraDownloadId = intent.getLongExtra("extra_download_id", 0);
                if (extraDownloadId == mainActivity.this.extraDownloadId) {
                    Cursor query = ((DownloadManager) mainActivity.this.getSystemService("download")).query(new DownloadManager.Query().setFilterById(new long[]{extraDownloadId}));
                    if (query == null) {
                        return;
                    }
                    if (query.moveToFirst()) {
                        if (query.getInt(query.getColumnIndex(NotificationCompat.T0)) == 8) {
                            Intent intent2 = new Intent("android.intent.action.VIEW");
                            intent2.setDataAndType(Uri.fromFile(new File(mainActivity.this.O3)), "application/vnd.android.package-archive");
                            intent2.setFlags(268435456);
                            mainActivity.this.startActivity(intent2);
                        }
                    }
                }
            } catch (Exception e2) {
                FirebaseCrashlytics.d().g(e2);
                FirebaseCrashlytics.d().g(e2);
            }
        }
    };

    public BroadcastReceiver T3 = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            mainActivity.this.n1();
        }
    };
    public BroadcastReceiver U3 = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            try {
                if (!mainActivity.this.slidingPaneLayout.l()) {
                    mainActivity.this.slidingPaneLayout.o();
                }
            } catch (Exception unused) {
            }
        }
    };
    public ViewPager y3;
    private TabsPagerAdapter z3;

    public static class DatabaseCellViewHolder extends RecyclerView.ViewHolder {
        public TextView I;
        public ImageView J;

        public DatabaseCellViewHolder(View view) {
            super(view);
            this.I = (TextView) view.findViewById(R.id.f896database_title);
            this.J = (ImageView) view.findViewById(R.id.f893database_image);
        }
    }

    private void deleteFileRecursively(File file) {
        if (file.isDirectory()) {
            for (File subFile : file.listFiles()) {
                deleteFileRecursively(subFile);
            }
        }
        file.delete();
    }

    private boolean k1() {
        VBHelper vBHelper = new VBHelper(this);
        if (vBHelper.a(vBHelper.getActivationCode()) == null) {
            finish();
            startActivity(new Intent(this, activationActivity.class));
            return false;
        }
        try {
            int length = TextUtils.split(vBHelper.x(vBHelper.m()).replace("||", "::"), "::").length;
            return true;
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            return true;
        }
    }

    private View o1(TabLayout tabLayout, CharSequence charSequence, int i2) {
        View inflate = LayoutInflater.from(tabLayout.getContext()).inflate(R.layout.custom_tab, tabLayout, false);
        ((TextView) inflate.findViewById(R.id.f1110tab_title)).setText(charSequence);
        ((ImageView) inflate.findViewById(R.id.f1108tab_icon)).setImageResource(i2);
        return inflate;
    }

    private void p1() {
        int i2;
        this.y3 = (ViewPager) findViewById(R.id.f1036pager);
        ((iMD) getApplication()).Y2 = this.y3.getId();
        this.A3 = F0();
        TabsPagerAdapter tabsPagerAdapter = new TabsPagerAdapter(k0());
        this.z3 = tabsPagerAdapter;
        this.y3.setAdapter(tabsPagerAdapter);
        this.A3.m0(false);
        this.y3.setOffscreenPageLimit(6);
        this.y3.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void a(int i2, float f2, int i3) {
            }

            public void c(int i2) {
            }

            public void d(int i2) {
                ActionBar F0;
                CharSequence charSequence;
                mainActivity.this.A3.t0(i2);
                if (!mainActivity.this.compressHelper.x1()) {
                    F0 = mainActivity.this.F0();
                    charSequence = mainActivity.this.A3.y(i2).f();
                } else {
                    F0 = mainActivity.this.F0();
                    charSequence = null;
                }
                F0.A0(charSequence);
                mainActivity.this.b1(i2);
            }
        });
        for (String str : this.C3) {
            ActionBar.Tab n2 = this.A3.H().n(this);
            if (!str.equals("Titles")) {
                if (str.equals("Databases")) {
                    i2 = R.drawable.f755tab_databases;
                } else if (str.equals("Favorites")) {
                    i2 = R.drawable.f757tab_favorite;
                } else if (!str.equals("Content")) {
                    if (str.equals("Store")) {
                        i2 = R.drawable.f756tab_download;
                    } else if (str.equals("Account")) {
                        i2 = R.drawable.f749tab_account;
                    } else {
                        this.A3.h(n2);
                    }
                }
                n2.l(i2);
                this.A3.h(n2);
            }
            n2.l(R.drawable.f760tab_search);
            this.A3.h(n2);
        }
        this.A3.s0(2);
        int i3 = 1;
        if (getSharedPreferences("default_preferences", 0).contains("Tab")) {
            String string = getSharedPreferences("default_preferences", 0).getString("Tab", "");
            ArrayList arrayList = new ArrayList(Arrays.asList(this.C3));
            if (arrayList.contains(string)) {
                i3 = arrayList.indexOf(string);
            }
        }
        this.y3.setCurrentItem(i3);
        this.A3.t0(i3);
    }

    /* access modifiers changed from: private */
    public void q1() {
        TabLayout tabLayout;
        int i2;
        View o1;
        this.y3 = (ViewPager) findViewById(R.id.f1036pager);
        ((iMD) getApplication()).Y2 = this.y3.getId();
        this.y3.setVisibility(0);
        TextView textView = (TextView) findViewById(R.id.f1001loading_first);
        if (textView != null) {
            textView.setVisibility(8);
        }
        TabsPagerAdapter tabsPagerAdapter = new TabsPagerAdapter(k0());
        this.z3 = tabsPagerAdapter;
        this.y3.setAdapter(tabsPagerAdapter);
        this.y3.setOffscreenPageLimit(6);
        this.tabLayout.setupWithViewPager(this.y3);
        int i3 = 0;
        while (true) {
            String[] strArr = this.C3;
            if (i3 >= strArr.length) {
                break;
            }
            String str = strArr[i3];
            TabLayout.Tab D = this.tabLayout.D(i3);
            String str2 = "Titles";
            if (!str.equals(str2)) {
                String str3 = "Databases";
                if (str.equals(str3)) {
                    tabLayout = this.tabLayout;
                    i2 = R.drawable.f755tab_databases;
                } else {
                    str3 = "Favorites";
                    if (str.equals(str3)) {
                        tabLayout = this.tabLayout;
                        i2 = R.drawable.f757tab_favorite;
                    } else {
                        str2 = "Content";
                        if (!str.equals(str2)) {
                            if (str.equals("Store")) {
                                tabLayout = this.tabLayout;
                                str3 = "Downloads";
                                i2 = R.drawable.f756tab_download;
                            } else {
                                str3 = "Account";
                                if (str.equals(str3)) {
                                    tabLayout = this.tabLayout;
                                    i2 = R.drawable.f749tab_account;
                                } else {
                                    i3++;
                                }
                            }
                        }
                    }
                }
                o1 = o1(tabLayout, str3, i2);
                D.v(o1);
                i3++;
            }
            o1 = o1(this.tabLayout, str2, R.drawable.f760tab_search);
            D.v(o1);
            i3++;
        }
        this.tabLayout.h(new TabLayout.OnTabSelectedListener() {
            public void a(TabLayout.Tab tab) {
            }

            public void b(TabLayout.Tab tab) {
                View g2 = tab.g();
                if (g2 != null) {
                    g2.setSelected(true);
                }
            }

            public void c(TabLayout.Tab tab) {
                View g2 = tab.g();
                if (g2 != null) {
                    g2.setSelected(false);
                }
            }
        });
        int i4 = 1;
        if (getSharedPreferences("default_preferences", 0).contains("Tab")) {
            String string = getSharedPreferences("default_preferences", 0).getString("Tab", "");
            ArrayList arrayList = new ArrayList(Arrays.asList(this.C3));
            if (arrayList.contains(string)) {
                i4 = arrayList.indexOf(string);
            }
        } else {
            ArrayList<Bundle> arrayList2 = ((iMD) getApplicationContext()).s;
            if (arrayList2 == null || arrayList2.size() == 0) {
                this.y3.setCurrentItem(4);
                return;
            }
        }
        this.y3.setCurrentItem(i4);
    }

    private boolean t1() {
        Iterator<String> it2 = this.compressHelper.o1().iterator();
        while (true) {
            int i2 = 0;
            if (!it2.hasNext()) {
                return false;
            }
            String next = it2.next();
            File file = new File(next);
            String[] list = file.list(new FilenameFilter() {
                public boolean accept(File file, String str) {
                    if (str.endsWith(".zip")) {
                        return true;
                    }
                    return str.endsWith(".zipp");
                }
            });
            if (list != null && list.length != 0) {
                return true;
            }
            String[] list2 = file.list(new FilenameFilter() {
                public boolean accept(File file, String str) {
                    if (str.endsWith(".zip.1")) {
                        return true;
                    }
                    return str.endsWith(".zipp.1");
                }
            });
            if (!(list2 == null || list2.length == 0)) {
                while (i2 < list2.length) {
                    String str = list2[i2];
                    int i3 = 1;
                    while (i3 < 11) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(next);
                        sb.append("/");
                        String replace = str.replace(".zip.1", ".zip." + i3);
                        sb.append(replace.replace(".zipp.1", ".zipp." + i3));
                        String sb2 = sb.toString();
                        if (new File(sb2).exists() && new File(sb2).length() >= 52428800) {
                            i3++;
                        } else {
                            i2++;
                        }
                    }
                    return true;
                }
                continue;
            }
        }
    }

    private void u1() {
        try {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            getCurrentFocus().clearFocus();
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
        }
    }

    private boolean v1(View view) {
        Rect rect = new Rect();
        return view.getGlobalVisibleRect(rect) && rect.bottom > 0 && rect.top < getResources().getDisplayMetrics().heightPixels;
    }

    public void C(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    public void I(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        if (this.compressHelper.x1()) {
            String str = "android:switcher:" + this.y3.getId() + ":" + tab.d();
            if (k0().s0(str) != null) {
                k0().u1(str, 1);
            }
        }
    }

    public void Z0() {
        Bundle Y0;
        try {
            if (getSharedPreferences("default_preferences", 0).getBoolean("openaftercrash", true)) {
                CompressHelper compressHelper = this.compressHelper;
                Bundle s1 = compressHelper.s1(compressHelper.Y(compressHelper.h2(), "SELECT * FROM recent order by id desc limit 1"));
                if (s1 != null && (Y0 = this.compressHelper.Y0("Name", s1.getString("dbName"))) != null) {
                    this.compressHelper.A1(Y0, s1.getString("dbAddress"), (String[]) null, (String) null);
                }
            }
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
        }
    }

    public void a1() {
        Fragment fragment;
        if (this.compressHelper.x1()) {
            int currentItem = this.y3.getCurrentItem();
            String str = "android:switcher:" + this.y3.getId() + ":";
            for (int i2 = 0; i2 < this.C3.length; i2++) {
                String str2 = str + i2;
                FragmentManager k0 = k0();
                if (i2 != currentItem) {
                    fragment = k0.s0(str2);
                    if (fragment == null) {
                    }
                } else {
                    Fragment r0 = k0.r0(R.id.container);
                    if (r0 != null) {
                        Fragment s0 = k0().s0(str2);
                        if (s0.k0().endsWith(r0.k0())) {
                            s0.q2(false);
                            s0.B2(false);
                        }
                        r0.q2(false);
                        r0.B2(false);
                    } else {
                        fragment = k0().s0(str2);
                        if (fragment == null) {
                        }
                    }
                }
                fragment.q2(false);
                fragment.B2(false);
            }
        }
        B0();
    }

    public void b1(int i2) {
        if (this.compressHelper.x1()) {
            String str = "android:switcher:" + this.y3.getId() + ":";
            for (int i3 = 0; i3 < this.C3.length; i3++) {
                String str2 = str + i3;
                FragmentManager k0 = k0();
                if (i3 != i2) {
                    Fragment s0 = k0.s0(str2);
                    if (s0 != null) {
                        s0.q2(false);
                        s0.B2(false);
                    }
                } else {
                    Fragment r0 = k0.r0(R.id.container);
                    if (r0 != null) {
                        Fragment s02 = k0().s0(str2);
                        if (s02.k0().endsWith(r0.k0())) {
                            s02.q2(false);
                            s02.B2(false);
                            r0.q2(true);
                            r0.B2(true);
                        } else {
                            r0.q2(false);
                            r0.B2(false);
                        }
                    } else {
                        Fragment s03 = k0().s0(str2);
                        if (s03 != null) {
                            s03.q2(true);
                            s03.B2(true);
                        }
                    }
                }
            }
        }
        B0();
    }

    public void i(androidx.appcompat.view.ActionMode actionMode) {
        super.i(actionMode);
        iMDLogger.j("ACtionMode", "onSupportActionModeStarted");
        Menu e2 = actionMode.e();
        if (((WebView) findViewById(R.id.f1159webView)) != null) {
            for (int i2 = 0; i2 < e2.size(); i2++) {
                MenuItem item = e2.getItem(i2);
                Drawable icon = item.getIcon();
                if (icon != null) {
                    PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
                    icon.setColorFilter(new PorterDuffColorFilter(-1, mode));
                    icon.setColorFilter(new PorterDuffColorFilter(-1, mode));
                    item.setIcon(icon);
                    if (!item.getTitle().equals("Share")) {
                        item.getTitle().equals("Web Search");
                    }
                }
            }
            actionMode.f().inflate(R.menu.f1497webview2_menu, e2);
            actionMode.k();
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.f970highlight_bar);
            linearLayout.setVisibility(0);
            linearLayout.startAnimation(AnimationUtils.loadAnimation(this, R.anim.f22snackbar_show_animation));
        }
    }

    public void j(androidx.appcompat.view.ActionMode actionMode) {
        super.j(actionMode);
        iMDLogger.j("ACtionMode", "onSupportActionModeFinished");
        if (((WebView) findViewById(R.id.f1159webView)) != null) {
            final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.f970highlight_bar);
            Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.f21snackbar_hide_animation);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationEnd(Animation animation) {
                    linearLayout.setVisibility(8);
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }
            });
            linearLayout.startAnimation(loadAnimation);
        }
    }

    public String j1(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : bArr) {
            byte b3 = b2 & 255;
            if (b3 < 16) {
                stringBuffer.append("0");
            }
            stringBuffer.append(Integer.toHexString(b3));
        }
        return stringBuffer.toString();
    }

    public void tryUpdateApp(final boolean z) {
        Log.e("checkAppUpdate", "checking app update");
        try {
            if (new File(this.compressHelper.U1() + "/version.txt").exists()) {
                new File(this.compressHelper.U1() + "/version.txt").delete();
            }
            this.compressHelper.T0(this.compressHelper.J() + "/v.txt", this.compressHelper.U1() + "/version.txt").h6(Schedulers.e()).s4(AndroidSchedulers.e()).f6(new Consumer<String>() {
                /* renamed from: a */
                public void accept(String str) throws Throwable {
                }
            }, new Consumer<Throwable>() {
                /* renamed from: a */
                public void accept(Throwable th) throws Throwable {
                    try {
                        iMDLogger.f("checkAppUpdate", "Error in checking update " + th.getMessage());
                        th.printStackTrace();
                        if (z) {
                            CompressHelper.x2(mainActivity.this, "Error in checking update", 1);
                        }
                    } catch (Exception e2) {
                        FirebaseCrashlytics.d().g(e2);
                    }
                }
            }, new Action() {
                public void run() throws Throwable {
                    try {
                        String replace = CompressHelper.e2(new File(mainActivity.this.compressHelper.U1() + "/version.txt")).replace(StringUtils.LF, "");
                        int i2 = mainActivity.this.getPackageManager().getPackageInfo(mainActivity.this.getPackageName(), 0).versionCode;
                        final int intValue = Integer.valueOf(replace).intValue();
                        iMDLogger.j("checkAppUpdate", "current version : " + i2 + " , UpdateVersion : " + intValue);
                        if (intValue > i2) {
                            SharedPreferences sharedPreferences = mainActivity.this.getSharedPreferences("default_preferences", 0);
                            if (!sharedPreferences.getBoolean(intValue + "update", true)) {
                                if (z) {
                                }
                            }
                            AlertDialog.Builder builder = new AlertDialog.Builder(mainActivity.this, R.style.f2185alertDialogTheme);
                            builder.l("An Update is available (version " + intValue + ") . \nWe strongly suggest that you update the app.").y("Download Update", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialogInterface, int i2) {
                                    String packageName = mainActivity.this.getPackageName();
                                    try {
                                        mainActivity mainactivity = mainActivity.this;
                                        mainactivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + packageName)));
                                    } catch (ActivityNotFoundException unused) {
                                        mainActivity mainactivity2 = mainActivity.this;
                                        mainactivity2.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + packageName)));
                                    }
                                }
                            }).s("Ignore this version", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialogInterface, int i2) {
                                    SharedPreferences.Editor edit = mainActivity.this.getSharedPreferences("default_preferences", 0).edit();
                                    edit.putBoolean(intValue + "update", false).commit();
                                }
                            }).p("Remind me later", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialogInterface, int i2) {
                                }
                            }).I();
                        } else if (z) {
                            CompressHelper.x2(mainActivity.this, "You have the latest version", 1);
                        }
                        new File(mainActivity.this.compressHelper.U1() + "/version.txt").delete();
                    } catch (Exception e2) {
                        FirebaseCrashlytics.d().g(e2);
                        if (z) {
                            CompressHelper.x2(mainActivity.this, "Error in Checking update", 1);
                        }
                        iMDLogger.f("checkAppUpdate", "Error in reading version.txt " + e2.getMessage());
                        e2.printStackTrace();
                    }
                }
            });
        } catch (Exception unused) {
            Log.e("MainActivity", "Error in app update");
        }
    }

    public void m1() {
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("title")) {
            String string = extras.getString("title");
            String string2 = extras.getString(Annotation.i3);
            String string3 = extras.getString(HTML.Tag.C);
            getIntent().replaceExtras(new Bundle());
            Intent intent = new Intent(this, NotificationActivity.class);
            intent.putExtra("title", string);
            intent.putExtra(Annotation.i3, string2);
            intent.putExtra(HTML.Tag.C, string3);
            intent.addFlags(268435456);
            startActivity(intent);
        }
    }

    public void n1() {
        try {
            if (t1() && k0().s0("Installing") == null) {
                InstallingFragment installingFragment = new InstallingFragment();
                this.E3 = installingFragment;
                installingFragment.i2((Bundle) null);
                this.E3.Z2(false);
                this.E3.e3(k0(), "Installing");
            }
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
        }
    }

    public void onActionModeFinished(ActionMode actionMode) {
        iMDLogger.j("ACtionMode", "onActionModeFinished");
        if (((WebView) findViewById(R.id.f1159webView)) != null) {
            if (actionMode == null) {
                actionMode = this.F3;
            }
            if (Build.VERSION.SDK_INT <= 22) {
                if (!new File(new CompressHelper(this).M1() + "/action.txt").exists()) {
                    return;
                }
            }
            actionMode.getMenu().clear();
            iMDWebView imdwebview = (iMDWebView) findViewById(R.id.f1159webView);
            if (imdwebview != null) {
                imdwebview.g("console.log('finisham,,,,,');");
            }
            super.onActionModeFinished(actionMode);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x003e, code lost:
        if (new java.io.File(new net.imedicaldoctor.imd.Data.CompressHelper(r6).M1() + "/action.txt").exists() != false) goto L_0x0040;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActionModeStarted(android.view.ActionMode r7) {
        /*
            r6 = this;
            java.lang.String r0 = "ACtionMode"
            java.lang.String r1 = "onActionModeStarted"
            net.imedicaldoctor.imd.iMDLogger.j(r0, r1)
            r0 = 2131362737(0x7f0a03b1, float:1.8345263E38)
            android.view.View r1 = r6.findViewById(r0)
            android.webkit.WebView r1 = (android.webkit.WebView) r1
            if (r1 != 0) goto L_0x0013
            return
        L_0x0013:
            r6.F3 = r7
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 22
            if (r2 > r3) goto L_0x0040
            java.io.File r3 = new java.io.File
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            net.imedicaldoctor.imd.Data.CompressHelper r5 = new net.imedicaldoctor.imd.Data.CompressHelper
            r5.<init>(r6)
            java.lang.String r5 = r5.M1()
            r4.append(r5)
            java.lang.String r5 = "/action.txt"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            boolean r3 = r3.exists()
            if (r3 == 0) goto L_0x008b
        L_0x0040:
            boolean r1 = r1.isFocused()
            if (r1 != 0) goto L_0x0047
            return
        L_0x0047:
            android.view.Menu r1 = r7.getMenu()
            r1.clear()
            r1 = 30
            if (r2 <= r1) goto L_0x005a
            r1 = 100
            r7.hide(r1)
            r7.finish()
        L_0x005a:
            android.view.View r0 = r6.findViewById(r0)
            net.imedicaldoctor.imd.Utils.iMDWebView r0 = (net.imedicaldoctor.imd.Utils.iMDWebView) r0
            if (r0 == 0) goto L_0x008b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "getRect("
            r1.append(r2)
            int r2 = r0.getWidth()
            r1.append(r2)
            java.lang.String r2 = ","
            r1.append(r2)
            int r2 = r0.getHeight()
            r1.append(r2)
            java.lang.String r2 = ")"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.g(r1)
        L_0x008b:
            super.onActionModeStarted(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.mainActivity.onActionModeStarted(android.view.ActionMode):void");
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (intent != null) {
            LocalBroadcastManager.b(this).d(new Intent("referesh.account.visible"));
            super.onActivityResult(i2, i3, intent);
        }
    }

    public void onBackPressed() {
        SlidingPaneLayout slidingPaneLayout;
        if (this.compressHelper.x1()) {
            boolean W1 = this.compressHelper.W1(false);
            if (!W1 && (slidingPaneLayout = (SlidingPaneLayout) findViewById(R.id.f1076sliding_layout)) != null) {
                if (slidingPaneLayout.l()) {
                    W1 = this.compressHelper.W1(true);
                } else {
                    slidingPaneLayout.o();
                }
            }
            if (W1) {
                return;
            }
        }
        if (k0().B0() > 0) {
            k0().r1();
            k0().p(new FragmentManager.OnBackStackChangedListener() {
                public void a() {
                    mainActivity mainactivity = mainActivity.this;
                    mainactivity.b1(mainactivity.y3.getCurrentItem());
                }
            });
            this.G3 = false;
        } else if (this.G3) {
            super.onBackPressed();
        } else {
            this.G3 = true;
            CompressHelper.x2(this, "Please click BACK again to exit", 0);
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    boolean unused = mainActivity.this.G3 = false;
                }
            }, ExoPlayer.a1);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.compressHelper.x1() && this.slidingPaneLayout != null && this.A3 != null && this.y3 != null) {
            iMDLogger.f("mainActivity", "ON Configuration changed");
            iMDLogger.f("mainActivity", "isOpen = " + this.slidingPaneLayout.l());
            iMDLogger.f("mainActivity", "isSlidable = " + this.slidingPaneLayout.m());
            this.slidingPaneLayout.postDelayed(new Runnable() {
                public void run() {
                    ActionBar f1;
                    int i2;
                    if (mainActivity.this.slidingPaneLayout.l()) {
                        mainActivity mainactivity = mainActivity.this;
                        mainactivity.b1(mainactivity.y3.getCurrentItem());
                        f1 = mainActivity.this.A3;
                        i2 = 2;
                    } else {
                        mainActivity.this.a1();
                        f1 = mainActivity.this.A3;
                        i2 = 0;
                    }
                    f1.s0(i2);
                }
            }, 700);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        FrameLayout.LayoutParams layoutParams;
        View view;
        int i2;
        super.onCreate(bundle);
        if (getSharedPreferences("default_preferences", 0).getBoolean("dark", false)) {
            AppCompatDelegate.c0(2);
        } else {
            AppCompatDelegate.c0(1);
        }
        if (getSharedPreferences("default_preferences", 0).getBoolean("wakelock", true)) {
            getWindow().addFlags(128);
        }
        try {
            this.compressHelper = new CompressHelper(this);
            Timer timer = new Timer();
            this.tryUpdateAppTimer = timer;
            timer.schedule(new TimerTask() {
                public void run() {
                    mainActivity.this.tryUpdateApp(false);
                }
            }, 40000);
            setContentView((int) R.layout.f1179activity_main);
            setTitle("");
            Toolbar toolbar = (Toolbar) findViewById(R.id.f1139toolbar);
            this.toolbar = toolbar;
            toolbar.Y();
            P0(this.toolbar);
            F0();
            this.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    mainActivity.this.onToolbarNavigationClicked();
                }
            });
            this.tabLayout = (TabLayout) findViewById(R.id.f1111tabs);
            DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.f922drawer_layout);
            this.drawerLayout = drawerLayout;
            drawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
                public void a(View view) {
                    mainActivity mainactivity = mainActivity.this;
                    mainactivity.recyclerView.setAdapter(new HistoryAdapter(mainactivity, mainactivity.drawerLayout));
                }

                public void b(View view) {
                }

                public void c(int i2) {
                }

                public void d(View view, float f2) {
                }
            });
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.f923drawer_view);
            this.recyclerView = recyclerView;
            recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
            this.recyclerView.setItemDecoration(new CustomItemDecoration(this));
            LocalBroadcastManager.b(this).c(this.S3, this.downloadCompleteIntentFilter);
            if (this.compressHelper.x1()) {
                TextView textView = (TextView) findViewById(R.id.f940first_title);
                if (textView != null) {
                    try {
                        i2 = getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
                    } catch (Exception unused) {
                        i2 = 0;
                    }
                    textView.setText("iMD - Medical Resources (" + i2 + ")");
                }
                LocalBroadcastManager.b(this).c(this.U3, new IntentFilter("showLeftPane"));
                SlidingPaneLayout slidingPaneLayout = (SlidingPaneLayout) findViewById(R.id.f1076sliding_layout);
                this.slidingPaneLayout = slidingPaneLayout;
                slidingPaneLayout.setShadowResourceLeft(R.drawable.f739slide_shadow);
                this.slidingPaneLayout.setSliderFadeColor(Color.parseColor("#FFFFFF"));
                FrameLayout frameLayout = (FrameLayout) findViewById(R.id.f906detail_container);
                boolean shouldSetupFullscreen = getSharedPreferences("default_preferences", 0).getBoolean("Fullscreen", true);
                if (shouldSetupFullscreen) {
                    frameLayout.setLayoutParams(new SlidingPaneLayout.LayoutParams(-1, -1));
                }
                ImageButton menuButton2 = (ImageButton) findViewById(R.id.f1011menu_button_2);
                if (shouldSetupFullscreen) {
                    menuButton2.setVisibility(0);
                } else {
                    menuButton2.setVisibility(8);
                }
                menuButton2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if (mainActivity.this.slidingPaneLayout.l()) {
                            mainActivity.this.slidingPaneLayout.c();
                        } else {
                            mainActivity.this.slidingPaneLayout.o();
                        }
                    }
                });
                slidingPaneLayout.setPanelSlideListener(new SlidingPaneLayout.PanelSlideListener() {
                    public void a(View view, float f2) {
                    }

                    public void b(View view) {
                        mainActivity mainactivity = mainActivity.this;
                        mainactivity.b1(mainactivity.y3.getCurrentItem());
                        if (mainActivity.this.A3 != null) {
                            mainActivity.this.A3.s0(2);
                        }
                    }

                    public void c(View view) {
                        mainActivity.this.a1();
                        if (mainActivity.this.A3 != null) {
                            mainActivity.this.A3.s0(0);
                        }
                    }
                });
                this.slidingPaneLayout.o();
            }
            iMDLogger.j("OnCreate", "OnCreate");
            if (getSharedPreferences("default_preferences", 0).getBoolean("HideStatusBar", false)) {
                if (this.compressHelper.x1()) {
                    getWindow().setFlags(67108864, 67108864);
                    layoutParams = (FrameLayout.LayoutParams) this.slidingPaneLayout.getLayoutParams();
                    layoutParams.setMargins(0, -s1(), 0, 0);
                    view = this.slidingPaneLayout;
                } else {
                    getWindow().setFlags(67108864, 67108864);
                    layoutParams = (FrameLayout.LayoutParams) this.drawerLayout.getLayoutParams();
                    layoutParams.setMargins(0, -s1(), 0, 0);
                    view = this.drawerLayout;
                }
                view.setLayoutParams(layoutParams);
                float dimension = getResources().getDimension(R.dimen.f522toolbar_padding);
                AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.f825appbar);
                if (appBarLayout != null) {
                    appBarLayout.setPadding(0, (int) dimension, 0, 0);
                }
            }
            k1();
            this.compressHelper.R0(new Runnable() {
                public void run() {
                    mainActivity.this.compressHelper.k0();
                }
            }, new Runnable() {
                public void run() {
                    mainActivity.this.q1();
                    if (mainActivity.this.getIntent().hasExtra("crash")) {
                        mainActivity.this.Z0();
                    }
                }
            });
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        try {
            LocalBroadcastManager.b(this).f(this.S3);
            if (this.compressHelper.x1()) {
                LocalBroadcastManager.b(this).f(this.U3);
            }
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        LocalBroadcastManager.b(this).f(this.T3);
        super.onPause();
    }

    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        LocalBroadcastManager.b(this).c(this.T3, new IntentFilter("checkzip"));
        new Handler().postDelayed(new Runnable() {
            public void run() {
                mainActivity.this.n1();
            }
        }, 1000);
        try {
            ((iMD) getApplicationContext()).b();
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
        }
        m1();
        iMD imd = (iMD) getApplicationContext();
        String str = imd.X2;
        if (str != null && str.length() > 0) {
            final String str2 = imd.X2;
            imd.X2 = null;
            this.y3.setCurrentItem(4);
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    downloadFragment downloadfragment = ((iMD) mainActivity.this.getApplicationContext()).c3;
                    if (downloadfragment.K3()) {
                        downloadfragment.M2();
                    }
                    mainActivity.this.tabLayout.D(0).r();
                    downloadfragment.m4.k0(str2, true);
                }
            }, 1000);
        }
    }

    public long r1(String str) {
        Cursor query = ((DownloadManager) getSystemService("download")).query(new DownloadManager.Query());
        query.moveToFirst();
        new ArrayList();
        for (int i2 = 0; i2 < query.getCount(); i2++) {
            query.moveToPosition(i2);
            String string = query.getString(query.getColumnIndex("uri"));
            long j2 = query.getLong(query.getColumnIndex("_id"));
            iMDLogger.f("URI", string);
            if (string.startsWith(str)) {
                return j2;
            }
        }
        return 0;
    }

    public void s(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        ActionBar F0;
        CharSequence charSequence;
        this.y3.setCurrentItem(tab.d());
        V3 = String.valueOf(tab.d());
        if (!this.compressHelper.x1()) {
            F0 = F0();
            charSequence = tab.f();
        } else {
            F0 = F0();
            charSequence = null;
        }
        F0.A0(charSequence);
        ((iMD) getApplication()).Z2 = tab.d();
        B0();
    }

    public int s1() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.f15from_fade_in, R.anim.f16from_fade_out);
    }

    public void onToolbarNavigationClicked() {
        this.drawerLayout.K(3);
    }

    public void x1() {
        Observable.w1(new ObservableOnSubscribe<String>() {
            public void a(@io.reactivex.rxjava3.annotations.NonNull ObservableEmitter<String> observableEmitter) throws Throwable {
                Iterator<String> it2 = mainActivity.this.compressHelper.w1().iterator();
                while (it2.hasNext()) {
                    String next = it2.next();
                    iMDLogger.f("Root path : ", next);
                    mainActivity.this.compressHelper.f29547c = null;
                    mainActivity.this.compressHelper.i2(new File(next).listFiles());
                }
                try {
                    String encodeToString = Base64.encodeToString(CompressHelper.d1(mainActivity.this.compressHelper.f29547c.getBytes(Charsets.f22255c)), 0);
                    CompressHelper compressHelper = mainActivity.this.compressHelper;
                    compressHelper.p0("checkAccount|||||" + new VBHelper(mainActivity.this).m() + "|||||" + encodeToString).h6(Schedulers.e()).s4(Schedulers.e()).f6(new Consumer<String>() {
                        /* renamed from: a */
                        public void accept(String str) throws Throwable {
                            StringUtils.splitByWholeSeparator(str, "|||||");
                        }
                    }, new Consumer<Throwable>() {
                        /* renamed from: a */
                        public void accept(Throwable th) throws Throwable {
                        }
                    }, new Action() {
                        public void run() throws Throwable {
                        }
                    });
                } catch (Exception e2) {
                    FirebaseCrashlytics.d().g(e2);
                }
                observableEmitter.onComplete();
            }
        }).h6(Schedulers.e()).s4(Schedulers.e()).a(new DisposableObserver<String>() {
            /* renamed from: c */
            public void onNext(@io.reactivex.rxjava3.annotations.NonNull String str) {
            }

            public void onComplete() {
            }

            public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable th) {
            }
        });
    }

    public void y1() {
        LocalBroadcastManager.b(this).d(new Intent("reload"));
        this.E3.N2();
        this.E3 = null;
    }
}
