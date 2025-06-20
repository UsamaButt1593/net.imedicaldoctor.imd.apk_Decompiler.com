package net.imedicaldoctor.imd.Fragments;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Process;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import at.grabner.circleprogress.BuildConfig;
import com.basusingh.beautifulprogressdialog.BeautifulProgressDialog;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.requery.android.database.sqlite.SQLiteDatabase;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Utils.MaterialRippleLayout;
import net.imedicaldoctor.imd.VBHelper;
import net.imedicaldoctor.imd.Views.ButtonFloatHelp;
import net.imedicaldoctor.imd.Views.ButtonFloatHelpBadge;
import net.imedicaldoctor.imd.iMD;
import net.imedicaldoctor.imd.iMDLogger;
import org.apache.commons.lang3.StringUtils;
import yuku.ambilwarna.AmbilWarnaDialog;

public class accountFragment extends Fragment {
    public static final String G4 = "Setting_SelectDownloadPath";
    public static final String H4 = "Setting_Selectlandingpage";
    public static final String I4 = "Setting_MainServer";
    public static final String J4 = "Setting_DownloadServer";
    public static final String K4 = "Setting_FullscreenMode";
    public static final String L4 = "Setting_HideListOnSelect";
    public static final String M4 = "Setting_HideStatusBar";
    public static final String N4 = "Setting_DynamicRipple";
    public static final String O4 = "Setting_CollapseSearchResults";
    public static final String P4 = "Setting_CollapseContentSearch";
    public static final String Q4 = "Setting_LockinFullscreen";
    public static final String R4 = "Setting_UseLessSpace";
    public static final String S4 = "Setting_EnableSwipeDelete";
    public static final String T4 = "Setting_UseDeltaUpdate";
    public static final String U4 = "Setting_UseCollapsingToolbar";
    public static final String V4 = "Setting_newDocumentOpen";
    public static final String W4 = "Setting_UseLastRed";
    public static final String X4 = "Setting_UseDefaultFont";
    public static final String Y4 = "Setting_LoadDownloadsAutomatically";
    public static final String Z4 = "Setting_JustifyTexts";
    public static final String a5 = "Setting_OpenLastTopic";
    public static final String b5 = "Setting_SaveLogs";
    public static final String c5 = "Setting_EnableWakeLock";
    public static final String d5 = "Setting_DarkTheme";
    public static final String e5 = "Setting_AutomaticBackups";
    public static final String f5 = "Setting_LineHeight";
    public static final String g5 = "Setting_ShowPopup";
    public static final String h5 = "Setting_AutomaticHighlight";
    public static final String i5 = "Setting_CheckUpdate";
    public static final String j5 = "Setting_StartFileWebServer";
    public static final String k5 = "Setting_BackupHighlightsFAvorites";
    public static final String l5 = "Setting_Restore";
    public static final String m5 = "Setting_DeleteTemp";
    public static final String n5 = "Setting_Background";
    public int A4 = 0;
    /* access modifiers changed from: private */
    public Boolean B4;
    Typeface C4;
    private final BroadcastReceiver D4 = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            iMDLogger.d("account", "let's referesh accounts");
            try {
                accountFragment.this.N2();
                accountFragment.this.f4.getAdapter().G();
            } catch (Exception e2) {
                FirebaseCrashlytics.d().g(e2);
            }
        }
    };
    private final BroadcastReceiver E4 = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            accountFragment.this.g4.post(new Runnable() {
                public void run() {
                    accountFragment.this.g4.setRefreshing(true);
                    accountFragment.this.M2();
                }
            });
        }
    };
    public BroadcastReceiver F4 = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            iMDLogger.j("downloadFragment", "Received reload Downloads");
            accountFragment.this.K2();
        }
    };
    /* access modifiers changed from: private */
    public View e4;
    /* access modifiers changed from: private */
    public RecyclerView f4;
    /* access modifiers changed from: private */
    public SwipeRefreshLayout g4;
    /* access modifiers changed from: private */
    public ArrayList<String> h4;
    /* access modifiers changed from: private */
    public Boolean i4;
    /* access modifiers changed from: private */
    public String j4;
    /* access modifiers changed from: private */
    public ArrayList<Bundle> k4;
    /* access modifiers changed from: private */
    public ArrayList<String> l4;
    /* access modifiers changed from: private */
    public Bundle m4;
    /* access modifiers changed from: private */
    public String n4;
    /* access modifiers changed from: private */
    public boolean o4;
    public CompressHelper p4;
    public VBHelper q4;
    /* access modifiers changed from: private */
    public Activity r4;
    private ButtonFloatHelp s4;
    private ButtonFloatHelpBadge t4;
    /* access modifiers changed from: private */
    public String u4;
    /* access modifiers changed from: private */
    public String v4;
    private FileWebServer w4;
    /* access modifiers changed from: private */
    public ArrayList<String> x4;
    public int y4 = 0;
    public int z4 = 0;

    public class AccountAdapter extends RecyclerView.Adapter {

        /* renamed from: d  reason: collision with root package name */
        HashMap<String, Integer> f30075d = new HashMap<>();

        public AccountAdapter() {
        }

        public long B(int i2) {
            return (long) i2;
        }

        public int C(int i2) {
            Bundle d0 = d0(i2, accountFragment.this.h4);
            if (!d0.getString("Type").equals("Header") && d0.getString("Type").equals("Item")) {
                String string = d0.getString("Section");
                int i3 = d0.getInt("Index");
                if (string.equals("Account Information") || string.equals("Help")) {
                    return 1;
                }
                if (string.equals("Your Databases")) {
                    return accountFragment.this.l4.contains(TtmlNode.r0) ? 1 : 2;
                }
                if (string.equals("About Us")) {
                    if (i3 == 0) {
                        return 3;
                    }
                    return i3 > 5 ? 1 : 4;
                } else if (string.equals("Settings")) {
                    String str = (String) accountFragment.this.x4.get(i3);
                    if (str.equals(accountFragment.I4)) {
                        return 8;
                    }
                    if (str.equals(accountFragment.H4)) {
                        return 5;
                    }
                    if (str.equals(accountFragment.J4)) {
                        return 8;
                    }
                    if (str.equals(accountFragment.K4) || str.equals(accountFragment.L4) || str.equals(accountFragment.M4) || str.equals(accountFragment.N4) || str.equals(accountFragment.O4) || str.equals(accountFragment.P4) || str.equals(accountFragment.Q4) || str.equals(accountFragment.R4) || str.equals(accountFragment.S4) || str.equals(accountFragment.T4) || str.equals(accountFragment.U4) || str.equals(accountFragment.g5) || str.equals(accountFragment.V4) || str.equals(accountFragment.W4) || str.equals(accountFragment.X4) || str.equals(accountFragment.Y4) || str.equals(accountFragment.Z4) || str.equals(accountFragment.a5) || str.equals(accountFragment.b5) || str.equals(accountFragment.c5) || str.equals(accountFragment.d5) || str.equals(accountFragment.e5)) {
                        return 6;
                    }
                    if (!str.equals(accountFragment.i5) && !str.equals(accountFragment.j5) && !str.equals(accountFragment.k5) && !str.equals(accountFragment.l5) && !str.equals(accountFragment.m5)) {
                        return (!str.equals(accountFragment.n5) && !str.equals(accountFragment.f5)) ? 5 : 8;
                    }
                    return 1;
                } else if (string.equals("")) {
                    return (i3 == 1 || i3 == 3) ? 7 : 1;
                }
            }
            return 0;
        }

        public void R(RecyclerView.ViewHolder viewHolder, int i2) {
            int i3;
            TextView textView;
            AccountTextViewHolder accountTextViewHolder;
            View.OnClickListener onClickListener;
            MaterialRippleLayout materialRippleLayout;
            int i4;
            MaterialRippleLayout materialRippleLayout2;
            SwitchCompat j0;
            View.OnClickListener r3;
            View i0;
            View.OnLongClickListener r2;
            TextView j02;
            String c3;
            Button button;
            View.OnClickListener r32;
            TextView textView2;
            int i5;
            TextView j03;
            String str;
            int i6;
            StringBuilder sb;
            String str2;
            final int i7 = i2;
            Bundle d0 = d0(i7, accountFragment.this.h4);
            if (d0.getString("Type").equals("Header")) {
                HeaderCellViewHolder headerCellViewHolder = (HeaderCellViewHolder) viewHolder;
                headerCellViewHolder.f15587a.setOnClickListener((View.OnClickListener) null);
                String string = d0.getString("Text");
                if (string.equals("Settings")) {
                    try {
                        i6 = accountFragment.this.r4.getPackageManager().getPackageInfo(accountFragment.this.r4.getPackageName(), 0).versionCode;
                    } catch (Exception unused) {
                        i6 = 0;
                    }
                    headerCellViewHolder.f15587a.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            accountFragment accountfragment = accountFragment.this;
                            Boolean unused = accountfragment.i4 = Boolean.valueOf(!accountfragment.i4.booleanValue());
                            accountFragment.this.f4.getAdapter().G();
                        }
                    });
                    if (accountFragment.this.i4.booleanValue()) {
                        sb = new StringBuilder();
                        sb.append(string);
                        str2 = " ( Tap to Show )";
                    } else {
                        sb = new StringBuilder();
                        sb.append(string);
                        str2 = " ( Tap to Hide )";
                    }
                    sb.append(str2);
                    string = sb.toString() + " - App Version : " + i6;
                } else if (string.equals("Help")) {
                    string = "Help";
                }
                headerCellViewHolder.I.setText(string);
            }
            if (d0.getString("Type").equals("Item")) {
                String string2 = d0.getString("Section");
                int i8 = d0.getInt("Index");
                if (string2.equals("Account Information")) {
                    accountTextViewHolder = (AccountTextViewHolder) viewHolder;
                    accountTextViewHolder.J.setOnClickListener((View.OnClickListener) null);
                    String a2 = accountFragment.this.p4.a();
                    if (!a2.equals("All")) {
                        if (a2.equals("Simple")) {
                            if (i8 == 0) {
                                accountTextViewHolder.I.setText("Your Account Credit Is");
                                accountTextViewHolder.I.setTextColor(accountFragment.this.b0().getColor(R.color.f469white));
                                materialRippleLayout2 = accountTextViewHolder.J;
                                i4 = Color.parseColor("#ff1cab47");
                                materialRippleLayout2.setBackgroundColor(i4);
                            } else if (i8 == 1) {
                                accountTextViewHolder.I.setText(accountFragment.this.n4 + " Toman");
                            } else {
                                if (i8 == 2) {
                                    accountTextViewHolder.I.setText("Buy Credit");
                                    accountTextViewHolder.I.setTextColor(accountFragment.this.b0().getColor(R.color.f469white));
                                    accountTextViewHolder.J.setBackgroundColor(accountFragment.this.b0().getColor(R.color.f454red_dark));
                                    materialRippleLayout = accountTextViewHolder.J;
                                    onClickListener = new View.OnClickListener() {
                                        public void onClick(View view) {
                                            CompressHelper compressHelper = accountFragment.this.p4;
                                            StringBuilder sb = new StringBuilder();
                                            sb.append("http://imedicaldoctor.net/buycredit.php?user=");
                                            accountFragment accountfragment = accountFragment.this;
                                            sb.append(accountfragment.q4.encodeActivationCodeToHex(accountfragment.u4));
                                            compressHelper.P(sb.toString());
                                        }
                                    };
                                } else if (i8 == 3) {
                                    accountTextViewHolder.I.setText("Enter Credit Serial");
                                    accountTextViewHolder.I.setTextColor(accountFragment.this.b0().getColor(R.color.f469white));
                                    accountTextViewHolder.J.setBackgroundColor(accountFragment.this.b0().getColor(R.color.f142blue));
                                    materialRippleLayout = accountTextViewHolder.J;
                                    onClickListener = new View.OnClickListener() {
                                        public void onClick(View view) {
                                            final EditText editText = new EditText(accountFragment.this.r());
                                            editText.setTextColor(accountFragment.this.b0().getColor(R.color.f140black));
                                            new AlertDialog.Builder(accountFragment.this.r(), R.style.f2185alertDialogTheme).l("Enter Credit Serial Number").setView(editText).y("Add Credit", new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialogInterface, int i2) {
                                                    String obj = editText.getText().toString();
                                                    if (obj.length() == 0) {
                                                        CompressHelper.x2(accountFragment.this.r(), "You must enter a serial number", 1);
                                                        return;
                                                    }
                                                    CompressHelper compressHelper = accountFragment.this.p4;
                                                    compressHelper.o0("AddCredit|||||" + accountFragment.this.q4.m() + "|||||" + obj).e6(new Consumer<String>() {
                                                        /* renamed from: a */
                                                        public void accept(String str) throws Throwable {
                                                            String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(str, "|||||");
                                                            if (splitByWholeSeparator[0].equals(IcyHeaders.a3)) {
                                                                accountFragment.this.p4.t2(splitByWholeSeparator[1]);
                                                                accountFragment.this.N2();
                                                                accountFragment.this.J2();
                                                                return;
                                                            }
                                                            CompressHelper.x2(accountFragment.this.r(), splitByWholeSeparator[1], 1);
                                                        }
                                                    }, new Consumer<Throwable>() {
                                                        /* renamed from: a */
                                                        public void accept(Throwable th) throws Throwable {
                                                            try {
                                                                th.printStackTrace();
                                                                CompressHelper.x2(accountFragment.this.r(), "Error occured on contacting server, try again later.", 1);
                                                            } catch (Exception unused) {
                                                            }
                                                        }
                                                    });
                                                }
                                            }).p("Cancel", new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialogInterface, int i2) {
                                                }
                                            }).I();
                                        }
                                    };
                                } else if (i8 == 4) {
                                    accountTextViewHolder.I.setText("Upgrade to VIP Account");
                                    accountTextViewHolder.I.setTextColor(accountFragment.this.b0().getColor(R.color.f469white));
                                    accountTextViewHolder.J.setBackgroundColor(Color.parseColor("#c8a900"));
                                    materialRippleLayout = accountTextViewHolder.J;
                                    onClickListener = new View.OnClickListener() {
                                        public void onClick(View view) {
                                            CompressHelper compressHelper = accountFragment.this.p4;
                                            StringBuilder sb = new StringBuilder();
                                            sb.append("http://imedicaldoctor.net/extendsubscription.php?user=");
                                            accountFragment accountfragment = accountFragment.this;
                                            sb.append(accountfragment.q4.encodeActivationCodeToHex(accountfragment.u4));
                                            compressHelper.P(sb.toString());
                                        }
                                    };
                                } else {
                                    return;
                                }
                                materialRippleLayout.setOnClickListener(onClickListener);
                                return;
                            }
                        } else if (a2.contains("Active|")) {
                            if (i8 == 0) {
                                j03 = accountTextViewHolder.I;
                                str = "VIP Account - Active Till";
                            } else if (i8 == 1) {
                                Date date = new Date(Long.parseLong(TextUtils.split(a2.replace("|", ":"), ":")[1]) * 1000);
                                long convert = TimeUnit.DAYS.convert(Math.abs(new Date().getTime() - date.getTime()), TimeUnit.MILLISECONDS);
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                accountTextViewHolder.I.setText(simpleDateFormat.format(date) + " - " + convert + " Days Remaining");
                            } else if (i8 == 2) {
                                accountTextViewHolder.I.setText("Extend Subscription");
                                accountTextViewHolder.I.setTextColor(accountFragment.this.b0().getColor(R.color.f469white));
                                accountTextViewHolder.J.setBackgroundColor(Color.parseColor("#0a7229"));
                                materialRippleLayout = accountTextViewHolder.J;
                                onClickListener = new View.OnClickListener() {
                                    public void onClick(View view) {
                                        CompressHelper compressHelper = accountFragment.this.p4;
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("http://imedicaldoctor.net/extendsubscription.php?user=");
                                        accountFragment accountfragment = accountFragment.this;
                                        sb.append(accountfragment.q4.encodeActivationCodeToHex(accountfragment.u4));
                                        compressHelper.P(sb.toString());
                                    }
                                };
                                materialRippleLayout.setOnClickListener(onClickListener);
                                return;
                            } else {
                                return;
                            }
                        } else if (!a2.contains("Expired|")) {
                            return;
                        } else {
                            if (i8 == 0) {
                                accountTextViewHolder.I.setText("VIP Account - Expired At");
                                accountTextViewHolder.I.setTextColor(accountFragment.this.b0().getColor(R.color.f469white));
                                materialRippleLayout2 = accountTextViewHolder.J;
                                i4 = accountFragment.this.b0().getColor(R.color.f454red_dark);
                                materialRippleLayout2.setBackgroundColor(i4);
                            } else if (i8 == 1) {
                                accountTextViewHolder.I.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date(Long.parseLong(TextUtils.split(a2.replace("|", ":"), ":")[1]) * 1000)));
                            } else if (i8 == 2) {
                                accountTextViewHolder.I.setText("Extend Subscription");
                                accountTextViewHolder.I.setTextColor(accountFragment.this.b0().getColor(R.color.f469white));
                                accountTextViewHolder.J.setBackgroundColor(Color.parseColor("#0a7229"));
                                materialRippleLayout = accountTextViewHolder.J;
                                onClickListener = new View.OnClickListener() {
                                    public void onClick(View view) {
                                        CompressHelper compressHelper = accountFragment.this.p4;
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("http://imedicaldoctor.net/extendsubscription.php?user=");
                                        accountFragment accountfragment = accountFragment.this;
                                        sb.append(accountfragment.q4.encodeActivationCodeToHex(accountfragment.u4));
                                        compressHelper.P(sb.toString());
                                    }
                                };
                                materialRippleLayout.setOnClickListener(onClickListener);
                                return;
                            } else {
                                return;
                            }
                        }
                        textView = accountTextViewHolder.I;
                        i3 = accountFragment.this.b0().getColor(R.color.f140black);
                        textView.setTextColor(i3);
                    } else if (i8 == 0) {
                        j03 = accountTextViewHolder.I;
                        str = "VIP Account Forever";
                    } else {
                        return;
                    }
                    j03.setText(str);
                    accountTextViewHolder.I.setTextColor(accountFragment.this.b0().getColor(R.color.f469white));
                    materialRippleLayout2 = accountTextViewHolder.J;
                    i4 = Color.parseColor("#c8a900");
                    materialRippleLayout2.setBackgroundColor(i4);
                }
                if (string2.equals("Help")) {
                    accountTextViewHolder = (AccountTextViewHolder) viewHolder;
                    if (i8 == 0) {
                        accountTextViewHolder.I.setText("راهنمای استفاده از نرم افزار");
                        accountTextViewHolder.I.setTextColor(accountFragment.this.b0().getColor(R.color.f140black));
                        accountTextViewHolder.I.setTypeface(accountFragment.this.C4);
                        accountTextViewHolder.J.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                accountFragment.this.p4.P("http://imedicaldoctor.net/guide-android.php");
                            }
                        });
                    } else {
                        accountTextViewHolder.I.setText("سوالات و مشکلات شایع");
                        accountTextViewHolder.I.setTextColor(accountFragment.this.b0().getColor(R.color.f140black));
                        accountTextViewHolder.I.setTypeface(accountFragment.this.C4);
                        accountTextViewHolder.J.setBackgroundColor(accountFragment.this.b0().getColor(R.color.f469white));
                        materialRippleLayout = accountTextViewHolder.J;
                        onClickListener = new View.OnClickListener() {
                            public void onClick(View view) {
                                accountFragment.this.p4.P("http://imedicaldoctor.net/faq.php");
                            }
                        };
                    }
                } else if (!string2.equals("Your Databases")) {
                    if (string2.equals("About Us")) {
                        if (i8 == 0) {
                            ((SimpleTextViewHolder) viewHolder).I.setText("iMD - Medical Resources");
                            return;
                        } else if (i8 == 1) {
                            SocialCellViewHolder socialCellViewHolder = (SocialCellViewHolder) viewHolder;
                            socialCellViewHolder.I.setText("http://imedicaldoctor.net");
                            socialCellViewHolder.J.setImageResource(R.drawable.y6);
                            materialRippleLayout = socialCellViewHolder.K;
                            onClickListener = new View.OnClickListener() {
                                public void onClick(View view) {
                                    accountFragment.this.p4.P("http://imedicaldoctor.net");
                                }
                            };
                        } else if (i8 == 2) {
                            SocialCellViewHolder socialCellViewHolder2 = (SocialCellViewHolder) viewHolder;
                            socialCellViewHolder2.I.setText("support@imedicaldoctor.net");
                            socialCellViewHolder2.J.setImageResource(R.drawable.f636gmail);
                            materialRippleLayout = socialCellViewHolder2.K;
                            onClickListener = new View.OnClickListener() {
                                public void onClick(View view) {
                                    accountFragment.this.p4.P("mailto:support@imedicaldoctor.net");
                                }
                            };
                        } else if (i8 == 3) {
                            SocialCellViewHolder socialCellViewHolder3 = (SocialCellViewHolder) viewHolder;
                            socialCellViewHolder3.I.setText("Telegram Channel");
                            socialCellViewHolder3.J.setImageResource(R.drawable.Ia);
                            materialRippleLayout = socialCellViewHolder3.K;
                            onClickListener = new View.OnClickListener() {
                                public void onClick(View view) {
                                    accountFragment.this.p4.P("http://imedicaldoctor.net/t.php");
                                }
                            };
                        } else if (i8 == 4) {
                            SocialCellViewHolder socialCellViewHolder4 = (SocialCellViewHolder) viewHolder;
                            socialCellViewHolder4.I.setText("Telegram Group");
                            socialCellViewHolder4.J.setImageResource(R.drawable.Ia);
                            materialRippleLayout = socialCellViewHolder4.K;
                            onClickListener = new View.OnClickListener() {
                                public void onClick(View view) {
                                    accountFragment.this.p4.P("http://imedicaldoctor.net/telegramandroid.php");
                                }
                            };
                        } else if (i8 == 5) {
                            SocialCellViewHolder socialCellViewHolder5 = (SocialCellViewHolder) viewHolder;
                            socialCellViewHolder5.I.setText("@imedicaldoctor");
                            socialCellViewHolder5.J.setImageResource(R.drawable.f663insta);
                            materialRippleLayout = socialCellViewHolder5.K;
                            onClickListener = new View.OnClickListener() {
                                public void onClick(View view) {
                                    accountFragment.this.p4.P("https://www.instagram.com/imedicaldoctor/");
                                }
                            };
                        } else if (i8 == 6) {
                            AccountTextViewHolder accountTextViewHolder2 = (AccountTextViewHolder) viewHolder;
                            accountTextViewHolder2.I.setText("Log Out");
                            accountTextViewHolder2.I.setTextColor(accountFragment.this.b0().getColor(R.color.f469white));
                            accountTextViewHolder2.J.setBackgroundColor(accountFragment.this.b0().getColor(R.color.f453red));
                            materialRippleLayout = accountTextViewHolder2.J;
                            onClickListener = new View.OnClickListener() {
                                public void onClick(View view) {
                                    new AlertDialog.Builder(accountFragment.this.r(), R.style.f2185alertDialogTheme).l("Are you sure? your information won't be deleted. ").y("Yes", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialogInterface, int i2) {
                                            CompressHelper compressHelper = accountFragment.this.p4;
                                            compressHelper.o0("RemoveDevice|||||" + accountFragment.this.q4.m()).h6(Schedulers.e()).s4(AndroidSchedulers.e()).e6(new Consumer<String>() {
                                                /* renamed from: a */
                                                public void accept(String str) throws Throwable {
                                                    if (str.contains("1|||||")) {
                                                        accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).edit().remove("DS").commit();
                                                        accountFragment.this.p4.t2((String) null);
                                                        accountFragment.this.p4.w2("Logout Successful", new Runnable() {
                                                            public void run() {
                                                                Process.killProcess(Process.myPid());
                                                            }
                                                        });
                                                        return;
                                                    }
                                                    iMDLogger.f("Error", str);
                                                    CompressHelper.x2(accountFragment.this.r(), "Error occured", 0);
                                                }
                                            }, new Consumer<Throwable>() {
                                                /* renamed from: a */
                                                public void accept(Throwable th) throws Throwable {
                                                    try {
                                                        th.printStackTrace();
                                                        CompressHelper.x2(accountFragment.this.r(), "Error occured ", 0);
                                                    } catch (Exception unused) {
                                                    }
                                                }
                                            });
                                        }
                                    }).p("No", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialogInterface, int i2) {
                                        }
                                    }).I();
                                }
                            };
                        } else if (i8 == 7) {
                            AccountTextViewHolder accountTextViewHolder3 = (AccountTextViewHolder) viewHolder;
                            accountTextViewHolder3.I.setText("Exit app");
                            Boolean unused2 = accountFragment.this.B4 = Boolean.FALSE;
                            accountTextViewHolder3.I.setTextColor(accountFragment.this.b0().getColor(R.color.f469white));
                            accountTextViewHolder3.J.setBackgroundColor(accountFragment.this.b0().getColor(R.color.f159darkGrey));
                            accountTextViewHolder3.J.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View view) {
                                    if (!accountFragment.this.B4.booleanValue()) {
                                        Process.killProcess(Process.myPid());
                                    }
                                }
                            });
                            i0 = accountTextViewHolder3.J;
                            r2 = new View.OnLongClickListener() {
                                public boolean onLongClick(View view) {
                                    Boolean unused = accountFragment.this.B4 = Boolean.TRUE;
                                    accountFragment.this.p4.u2(accountFragment.this.p4.M1() + "/zlogs.db", "*/*");
                                    return true;
                                }
                            };
                        } else {
                            return;
                        }
                    } else if (string2.equals("Settings")) {
                        String str3 = (String) accountFragment.this.x4.get(i8);
                        if (str3.equals(accountFragment.G4)) {
                            SettingCellViewHolder settingCellViewHolder = (SettingCellViewHolder) viewHolder;
                            settingCellViewHolder.I.setText("Select Download Path");
                            materialRippleLayout = settingCellViewHolder.J;
                            onClickListener = new View.OnClickListener() {
                                public void onClick(View view) {
                                    HashSet<String> o1 = accountFragment.this.p4.o1();
                                    ArrayList arrayList = new ArrayList();
                                    Iterator<String> it2 = o1.iterator();
                                    while (it2.hasNext()) {
                                        String next = it2.next();
                                        if (!next.contains("/.") && !next.contains("/sdcard/external_sd") && !next.contains("/mnt/sdcard/external_sd")) {
                                            Bundle bundle = new Bundle();
                                            bundle.putString("Path", next);
                                            long usableSpace = new File(next).getUsableSpace();
                                            DecimalFormat decimalFormat = new DecimalFormat("#,##0");
                                            bundle.putString("Title", accountFragment.this.p4.Q(next));
                                            bundle.putString("Size", (decimalFormat.format((usableSpace / PlaybackStateCompat.p3) / PlaybackStateCompat.p3) + " MB") + " - " + next);
                                            arrayList.add(bundle);
                                        }
                                    }
                                    String y = accountFragment.this.p4.y();
                                    fileSizeSettingsList filesizesettingslist = new fileSizeSettingsList();
                                    Bundle bundle2 = new Bundle();
                                    bundle2.putString("type", "DownloadPath");
                                    bundle2.putParcelableArrayList("items", arrayList);
                                    bundle2.putString("titleProperty", "Title");
                                    bundle2.putString("selected", y);
                                    filesizesettingslist.i2(bundle2);
                                    filesizesettingslist.Z2(true);
                                    filesizesettingslist.A2(accountFragment.this, 0);
                                    filesizesettingslist.e3(accountFragment.this.M(), "SettingListDownloadPath");
                                }
                            };
                        } else if (str3.equals(accountFragment.H4)) {
                            SettingCellViewHolder settingCellViewHolder2 = (SettingCellViewHolder) viewHolder;
                            settingCellViewHolder2.I.setText("Select Landing Page");
                            materialRippleLayout = settingCellViewHolder2.J;
                            onClickListener = new View.OnClickListener() {
                                public void onClick(View view) {
                                    ArrayList arrayList = new ArrayList();
                                    String[] strArr = {"Titles", "Databases", "Favorites", "Content", "Store", "Account"};
                                    for (int i2 = 0; i2 < 6; i2++) {
                                        arrayList.add(accountFragment.this.m3(strArr[i2]));
                                    }
                                    String string = accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).getString("Tab", "");
                                    if (string.length() == 0) {
                                        string = strArr[1];
                                    }
                                    settingsList settingslist = new settingsList();
                                    Bundle bundle = new Bundle();
                                    bundle.putString("type", "Tab");
                                    bundle.putParcelableArrayList("items", arrayList);
                                    bundle.putString("titleProperty", "Title");
                                    bundle.putString("selected", string);
                                    settingslist.i2(bundle);
                                    settingslist.Z2(true);
                                    settingslist.A2(accountFragment.this, 0);
                                    settingslist.e3(accountFragment.this.M(), "SettingListTab");
                                }
                            };
                        } else if (str3.equals(accountFragment.I4)) {
                            accountFragment.this.y4 = i7;
                            SettingDetailCellViewHolder settingDetailCellViewHolder = (SettingDetailCellViewHolder) viewHolder;
                            settingDetailCellViewHolder.I.setText("Main Server");
                            settingDetailCellViewHolder.J.setText(accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).getString("MainServer", "Iran"));
                            settingDetailCellViewHolder.K.setVisibility(8);
                            materialRippleLayout = settingDetailCellViewHolder.L;
                            onClickListener = new View.OnClickListener() {
                                public void onClick(View view) {
                                    ArrayList arrayList = new ArrayList();
                                    String[] strArr = {"Germany", "Iran"};
                                    for (int i2 = 0; i2 < 2; i2++) {
                                        arrayList.add(accountFragment.this.m3(strArr[i2]));
                                    }
                                    String string = accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).getString("MainServer", "Iran");
                                    settingsList settingslist = new settingsList();
                                    Bundle bundle = new Bundle();
                                    bundle.putString("type", "MainDL");
                                    bundle.putParcelableArrayList("items", arrayList);
                                    bundle.putString("titleProperty", "Title");
                                    bundle.putString("selected", string);
                                    settingslist.i2(bundle);
                                    settingslist.Z2(true);
                                    settingslist.A2(accountFragment.this, 0);
                                    settingslist.e3(accountFragment.this.M(), "SettingListTab");
                                }
                            };
                        } else if (str3.equals(accountFragment.J4)) {
                            accountFragment.this.z4 = i7;
                            SettingDetailCellViewHolder settingDetailCellViewHolder2 = (SettingDetailCellViewHolder) viewHolder;
                            settingDetailCellViewHolder2.I.setText("Download Server");
                            settingDetailCellViewHolder2.J.setText(accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).getString("DownloadServer", "dl").equals("dl") ? "Germany" : "Iran");
                            settingDetailCellViewHolder2.K.setVisibility(8);
                            materialRippleLayout = settingDetailCellViewHolder2.L;
                            onClickListener = new View.OnClickListener() {
                                public void onClick(View view) {
                                    ArrayList arrayList = new ArrayList();
                                    String str = "Germany";
                                    String[] strArr = {str, "Iran"};
                                    for (int i2 = 0; i2 < 2; i2++) {
                                        arrayList.add(accountFragment.this.m3(strArr[i2]));
                                    }
                                    if (!accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).getString("DownloadServer", "dl").equals("dl")) {
                                        str = "Iran";
                                    }
                                    settingsList settingslist = new settingsList();
                                    Bundle bundle = new Bundle();
                                    bundle.putString("type", "DL");
                                    bundle.putParcelableArrayList("items", arrayList);
                                    bundle.putString("titleProperty", "Title");
                                    bundle.putString("selected", str);
                                    settingslist.i2(bundle);
                                    settingslist.Z2(true);
                                    settingslist.A2(accountFragment.this, 0);
                                    settingslist.e3(accountFragment.this.M(), "SettingListTab");
                                }
                            };
                        } else if (str3.equals(accountFragment.i5)) {
                            AccountTextViewHolder accountTextViewHolder4 = (AccountTextViewHolder) viewHolder;
                            accountTextViewHolder4.I.setText("Check App Update");
                            accountTextViewHolder4.I.setTextColor(accountFragment.this.b0().getColor(R.color.f469white));
                            accountTextViewHolder4.J.setBackgroundColor(accountFragment.this.b0().getColor(R.color.f159darkGrey));
                            accountTextViewHolder4.J.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View view) {
                                    if (accountFragment.this.r4 != null) {
                                        ((mainActivity) accountFragment.this.r4).tryUpdateApp(true);
                                    }
                                }
                            });
                            i0 = accountTextViewHolder4.J;
                            r2 = new View.OnLongClickListener() {
                                public boolean onLongClick(View view) {
                                    AccountAdapter.this.e0(new Runnable() {
                                        public void run() {
                                            AccountAdapter.this.f0();
                                        }
                                    }, (Runnable) null);
                                    return true;
                                }
                            };
                        } else if (str3.equals(accountFragment.j5)) {
                            AccountTextViewHolder accountTextViewHolder5 = (AccountTextViewHolder) viewHolder;
                            accountTextViewHolder5.I.setText(accountFragment.this.v4);
                            accountTextViewHolder5.I.setTextColor(accountFragment.this.b0().getColor(R.color.f469white));
                            accountTextViewHolder5.J.setBackgroundColor(accountFragment.this.b0().getColor(R.color.f364material_orange_800));
                            materialRippleLayout = accountTextViewHolder5.J;
                            onClickListener = new View.OnClickListener() {
                                public void onClick(View view) {
                                    accountFragment.this.t3();
                                }
                            };
                        } else if (str3.equals(accountFragment.k5)) {
                            AccountTextViewHolder accountTextViewHolder6 = (AccountTextViewHolder) viewHolder;
                            accountTextViewHolder6.I.setTextColor(accountFragment.this.b0().getColor(R.color.f469white));
                            accountTextViewHolder6.J.setBackgroundColor(accountFragment.this.b0().getColor(R.color.f167green));
                            if (accountFragment.this.j4.length() == 0) {
                                j02 = accountTextViewHolder6.I;
                                c3 = "Backup Favorites & Highlights";
                            } else {
                                j02 = accountTextViewHolder6.I;
                                c3 = accountFragment.this.j4;
                            }
                            j02.setText(c3);
                            accountTextViewHolder6.J.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View view) {
                                    if (accountFragment.this.j4.length() <= 0) {
                                        new AlertDialog.Builder(accountFragment.this.r(), R.style.f2185alertDialogTheme).l("This will backup your favorites & highlights to the iMD Server and will give you a identifier to restore it later.").y("OK", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialogInterface, int i2) {
                                                CompressHelper compressHelper = accountFragment.this.p4;
                                                String s0 = compressHelper.s0(compressHelper.X0(), "select dbName,dbTitle,dbAddress,dbDate,dbDocName from favorites", "dbName,dbTitle,dbAddress,dbDate,dbDocName", (Bundle) null);
                                                Bundle bundle = new Bundle();
                                                bundle.putString("text", "");
                                                accountFragment accountfragment = accountFragment.this;
                                                try {
                                                    String str = "SaveToFileZip|||||" + CompressHelper.G0(s0 + "###" + accountfragment.p4.s0(accountfragment.q3(), "select dbName,dbTitle,dbAddress,dbDate,dbDocName,type,text,note,save from highlight", "dbName,dbTitle,dbAddress,dbDate,dbDocName,type,text,note,save", bundle)) + "|||||" + accountFragment.this.p4.y1() + "|||||Account Page";
                                                    final ProgressDialog show = ProgressDialog.show(accountFragment.this.r(), "Backing up", "Please wait...", true);
                                                    accountFragment.this.p4.o0(str).h6(Schedulers.e()).s4(AndroidSchedulers.e()).e6(new Consumer<String>() {
                                                        /* renamed from: a */
                                                        public void accept(String str) throws Throwable {
                                                            show.dismiss();
                                                            accountFragment accountfragment = accountFragment.this;
                                                            String unused = accountfragment.j4 = "Backup identifier : " + str;
                                                            accountFragment.this.f4.getAdapter().G();
                                                        }
                                                    }, new Consumer<Throwable>() {
                                                        /* renamed from: a */
                                                        public void accept(Throwable th) throws Throwable {
                                                            show.dismiss();
                                                            CompressHelper.x2(accountFragment.this.r(), "Error in contacting server", 1);
                                                        }
                                                    });
                                                } catch (Exception e2) {
                                                    CompressHelper.x2(accountFragment.this.r(), "Error in compressing data. " + e2.getMessage(), 1);
                                                }
                                            }
                                        }).p("Cancel", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialogInterface, int i2) {
                                            }
                                        }).I();
                                    }
                                }
                            });
                            i0 = accountTextViewHolder6.J;
                            r2 = new View.OnLongClickListener() {
                                public boolean onLongClick(View view) {
                                    new AlertDialog.Builder(accountFragment.this.r(), R.style.f2185alertDialogTheme).l("This will delete all of your favorites. are you sure ?").y("OK", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialogInterface, int i2) {
                                            CompressHelper compressHelper = accountFragment.this.p4;
                                            compressHelper.q(compressHelper.X0(), "delete from favorites");
                                            accountFragment.this.r3();
                                        }
                                    }).p("Cancel", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialogInterface, int i2) {
                                        }
                                    }).I();
                                    return true;
                                }
                            };
                        } else if (str3.equals(accountFragment.l5)) {
                            AccountTextViewHolder accountTextViewHolder7 = (AccountTextViewHolder) viewHolder;
                            accountTextViewHolder7.I.setText("Restore Favorites & Highlights");
                            accountTextViewHolder7.I.setTextColor(accountFragment.this.b0().getColor(R.color.f469white));
                            accountTextViewHolder7.J.setBackgroundColor(accountFragment.this.b0().getColor(R.color.f160dark_blue));
                            accountTextViewHolder7.J.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View view) {
                                    final EditText editText = new EditText(accountFragment.this.r());
                                    editText.setTextColor(accountFragment.this.b0().getColor(R.color.f140black));
                                    new AlertDialog.Builder(accountFragment.this.r(), R.style.f2185alertDialogTheme).l("Enter Backup Identifier.").setView(editText).y("Replace", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialogInterface, int i2) {
                                            accountFragment.this.O2(editText.getText().toString(), true);
                                        }
                                    }).p("Merge", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialogInterface, int i2) {
                                            accountFragment.this.O2(editText.getText().toString(), false);
                                        }
                                    }).s("Cancel", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialogInterface, int i2) {
                                        }
                                    }).I();
                                }
                            });
                            i0 = accountTextViewHolder7.J;
                            r2 = new View.OnLongClickListener() {
                                public boolean onLongClick(View view) {
                                    new AlertDialog.Builder(accountFragment.this.r(), R.style.f2185alertDialogTheme).l("This will delete all of your highlights and notes. are you sure ?").y("OK", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialogInterface, int i2) {
                                            accountFragment accountfragment = accountFragment.this;
                                            accountfragment.p4.q(accountfragment.q3(), "delete from highlights");
                                        }
                                    }).p("Cancel", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialogInterface, int i2) {
                                        }
                                    }).I();
                                    return true;
                                }
                            };
                        } else if (str3.equals(accountFragment.m5)) {
                            AccountTextViewHolder accountTextViewHolder8 = (AccountTextViewHolder) viewHolder;
                            accountTextViewHolder8.I.setText("Delete Temp Files");
                            accountTextViewHolder8.I.setTextColor(accountFragment.this.b0().getColor(R.color.f469white));
                            accountTextViewHolder8.J.setBackgroundColor(accountFragment.this.b0().getColor(R.color.f453red));
                            materialRippleLayout = accountTextViewHolder8.J;
                            onClickListener = new View.OnClickListener() {
                                public void onClick(View view) {
                                    Iterator<String> it2 = accountFragment.this.p4.o1().iterator();
                                    while (it2.hasNext()) {
                                        String next = it2.next();
                                        String[] list = new File(next).list(new FilenameFilter() {
                                            public boolean accept(File file, String str) {
                                                return str.endsWith(".zip") || str.endsWith(".zipp") || str.endsWith(".download") || str.endsWith(".md5") || str.endsWith(".1") || str.endsWith(".2") || str.endsWith(".3") || str.endsWith(".4") || str.endsWith(".5") || str.endsWith(".6") || str.endsWith(".7") || str.endsWith(".8") || str.endsWith(".9") || str.endsWith(".10");
                                            }
                                        });
                                        if (!(list == null || list.length == 0)) {
                                            for (String str : list) {
                                                new File(next + "/" + str).delete();
                                            }
                                        }
                                    }
                                    new File(accountFragment.this.p4.M1() + "/zlogs.db").delete();
                                    CompressHelper.x2(accountFragment.this.r4, "All temp files deleted.", 1);
                                    new File(accountFragment.this.p4.D0()).delete();
                                }
                            };
                        } else {
                            if (str3.equals(accountFragment.K4)) {
                                final SettingCellSwitchViewHolder settingCellSwitchViewHolder = (SettingCellSwitchViewHolder) viewHolder;
                                settingCellSwitchViewHolder.I.setText("Fullscreen Mode");
                                settingCellSwitchViewHolder.J.setChecked(accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).getBoolean("Fullscreen", true));
                                j0 = settingCellSwitchViewHolder.J;
                                r3 = new View.OnClickListener() {
                                    public void onClick(View view) {
                                        accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).edit().putBoolean("Fullscreen", settingCellSwitchViewHolder.J.isChecked()).commit();
                                        CompressHelper.x2(accountFragment.this.r(), "You must restart your app for this change to take effect", 0);
                                    }
                                };
                            } else if (str3.equals(accountFragment.L4)) {
                                final SettingCellSwitchViewHolder settingCellSwitchViewHolder2 = (SettingCellSwitchViewHolder) viewHolder;
                                settingCellSwitchViewHolder2.I.setText("Hide List On Select");
                                settingCellSwitchViewHolder2.J.setChecked(accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).getBoolean("HideList", true));
                                j0 = settingCellSwitchViewHolder2.J;
                                r3 = new View.OnClickListener() {
                                    public void onClick(View view) {
                                        accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).edit().putBoolean("HideList", settingCellSwitchViewHolder2.J.isChecked()).commit();
                                    }
                                };
                            } else if (str3.equals(accountFragment.M4)) {
                                final SettingCellSwitchViewHolder settingCellSwitchViewHolder3 = (SettingCellSwitchViewHolder) viewHolder;
                                settingCellSwitchViewHolder3.I.setText("Hide Status Bar");
                                settingCellSwitchViewHolder3.J.setChecked(accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).getBoolean("HideStatusBar", false));
                                j0 = settingCellSwitchViewHolder3.J;
                                r3 = new View.OnClickListener() {
                                    public void onClick(View view) {
                                        accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).edit().putBoolean("HideStatusBar", settingCellSwitchViewHolder3.J.isChecked()).commit();
                                        CompressHelper.x2(accountFragment.this.r(), "You must restart your app for this change to take effect", 0);
                                    }
                                };
                            } else if (str3.equals(accountFragment.N4)) {
                                final SettingCellSwitchViewHolder settingCellSwitchViewHolder4 = (SettingCellSwitchViewHolder) viewHolder;
                                settingCellSwitchViewHolder4.I.setText("Dynamic Ripple Colors");
                                settingCellSwitchViewHolder4.J.setChecked(accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).getBoolean("ripple", true));
                                j0 = settingCellSwitchViewHolder4.J;
                                r3 = new View.OnClickListener() {
                                    public void onClick(View view) {
                                        accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).edit().putBoolean("ripple", settingCellSwitchViewHolder4.J.isChecked()).commit();
                                        CompressHelper.x2(accountFragment.this.r(), "You must restart your app for this change to take effect", 0);
                                    }
                                };
                            } else if (str3.equals(accountFragment.O4)) {
                                final SettingCellSwitchViewHolder settingCellSwitchViewHolder5 = (SettingCellSwitchViewHolder) viewHolder;
                                settingCellSwitchViewHolder5.I.setText("Collapse Search Results");
                                settingCellSwitchViewHolder5.J.setChecked(accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).getBoolean("SearchCollapsed", false));
                                j0 = settingCellSwitchViewHolder5.J;
                                r3 = new View.OnClickListener() {
                                    public void onClick(View view) {
                                        accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).edit().putBoolean("SearchCollapsed", settingCellSwitchViewHolder5.J.isChecked()).commit();
                                    }
                                };
                            } else if (str3.equals(accountFragment.P4)) {
                                final SettingCellSwitchViewHolder settingCellSwitchViewHolder6 = (SettingCellSwitchViewHolder) viewHolder;
                                settingCellSwitchViewHolder6.I.setText("Collapse Content Results");
                                settingCellSwitchViewHolder6.J.setChecked(accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).getBoolean("ContentCollapsed", false));
                                j0 = settingCellSwitchViewHolder6.J;
                                r3 = new View.OnClickListener() {
                                    public void onClick(View view) {
                                        accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).edit().putBoolean("ContentCollapsed", settingCellSwitchViewHolder6.J.isChecked()).commit();
                                    }
                                };
                            } else if (str3.equals(accountFragment.Q4)) {
                                final SettingCellSwitchViewHolder settingCellSwitchViewHolder7 = (SettingCellSwitchViewHolder) viewHolder;
                                settingCellSwitchViewHolder7.I.setText("Lock in Fullscreen");
                                settingCellSwitchViewHolder7.J.setChecked(accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).getBoolean("lockfull", true));
                                j0 = settingCellSwitchViewHolder7.J;
                                r3 = new View.OnClickListener() {
                                    public void onClick(View view) {
                                        accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).edit().putBoolean("lockfull", settingCellSwitchViewHolder7.J.isChecked()).commit();
                                        CompressHelper.x2(accountFragment.this.r(), "You must restart your app for this change to take effect", 0);
                                    }
                                };
                            } else if (str3.equals(accountFragment.R4)) {
                                final SettingCellSwitchViewHolder settingCellSwitchViewHolder8 = (SettingCellSwitchViewHolder) viewHolder;
                                settingCellSwitchViewHolder8.I.setText("Use less space for install");
                                settingCellSwitchViewHolder8.J.setChecked(accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).getBoolean("lessspace", false));
                                j0 = settingCellSwitchViewHolder8.J;
                                r3 = new View.OnClickListener() {
                                    public void onClick(View view) {
                                        accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).edit().putBoolean("lessspace", settingCellSwitchViewHolder8.J.isChecked()).commit();
                                        if (settingCellSwitchViewHolder8.J.isChecked()) {
                                            CompressHelper.x2(accountFragment.this.r(), "This may cause problems on install process", 0);
                                        }
                                    }
                                };
                            } else if (str3.equals(accountFragment.S4)) {
                                final SettingCellSwitchViewHolder settingCellSwitchViewHolder9 = (SettingCellSwitchViewHolder) viewHolder;
                                settingCellSwitchViewHolder9.I.setText("Enable Swipe to Delete");
                                settingCellSwitchViewHolder9.J.setChecked(accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).getBoolean("swipedelete", true));
                                j0 = settingCellSwitchViewHolder9.J;
                                r3 = new View.OnClickListener() {
                                    public void onClick(View view) {
                                        accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).edit().putBoolean("swipedelete", settingCellSwitchViewHolder9.J.isChecked()).commit();
                                    }
                                };
                            } else if (str3.equals(accountFragment.T4)) {
                                final SettingCellSwitchViewHolder settingCellSwitchViewHolder10 = (SettingCellSwitchViewHolder) viewHolder;
                                settingCellSwitchViewHolder10.I.setText("Use Delta Update");
                                settingCellSwitchViewHolder10.J.setChecked(accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).getBoolean("delta", false));
                                j0 = settingCellSwitchViewHolder10.J;
                                r3 = new View.OnClickListener() {
                                    public void onClick(View view) {
                                        accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).edit().putBoolean("delta", settingCellSwitchViewHolder10.J.isChecked()).commit();
                                        if (settingCellSwitchViewHolder10.J.isChecked()) {
                                            CompressHelper.x2(accountFragment.this.r(), "On some devices delta update can corrupt the main database and you must download the whole database again", 1);
                                        } else {
                                            LocalBroadcastManager.b(accountFragment.this.r()).d(new Intent("reloadDownloads"));
                                        }
                                    }
                                };
                            } else if (str3.equals(accountFragment.U4)) {
                                final SettingCellSwitchViewHolder settingCellSwitchViewHolder11 = (SettingCellSwitchViewHolder) viewHolder;
                                settingCellSwitchViewHolder11.I.setText("Use Collapsing Toolbar");
                                settingCellSwitchViewHolder11.J.setChecked(accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).getBoolean("NestedScroll", true));
                                j0 = settingCellSwitchViewHolder11.J;
                                r3 = new View.OnClickListener() {
                                    public void onClick(View view) {
                                        accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).edit().putBoolean("NestedScroll", settingCellSwitchViewHolder11.J.isChecked()).commit();
                                    }
                                };
                            } else if (str3.equals(accountFragment.g5)) {
                                final SettingCellSwitchViewHolder settingCellSwitchViewHolder12 = (SettingCellSwitchViewHolder) viewHolder;
                                settingCellSwitchViewHolder12.I.setText("Open Tables as Popup");
                                settingCellSwitchViewHolder12.J.setChecked(accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).getBoolean("showpopup", true));
                                j0 = settingCellSwitchViewHolder12.J;
                                r3 = new View.OnClickListener() {
                                    public void onClick(View view) {
                                        accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).edit().putBoolean("showpopup", settingCellSwitchViewHolder12.J.isChecked()).commit();
                                    }
                                };
                            } else if (str3.equals(accountFragment.V4)) {
                                final SettingCellSwitchViewHolder settingCellSwitchViewHolder13 = (SettingCellSwitchViewHolder) viewHolder;
                                settingCellSwitchViewHolder13.I.setText("New Document Loading");
                                settingCellSwitchViewHolder13.J.setChecked(accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).getBoolean("newdocument", false));
                                j0 = settingCellSwitchViewHolder13.J;
                                r3 = new View.OnClickListener() {
                                    public void onClick(View view) {
                                        accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).edit().putBoolean("newdocument", settingCellSwitchViewHolder13.J.isChecked()).commit();
                                    }
                                };
                            } else if (str3.equals(accountFragment.W4)) {
                                final SettingCellSwitchViewHolder settingCellSwitchViewHolder14 = (SettingCellSwitchViewHolder) viewHolder;
                                settingCellSwitchViewHolder14.I.setText("Use Last Red Highlight as Starting Point");
                                settingCellSwitchViewHolder14.J.setChecked(accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).getBoolean("lastred", false));
                                j0 = settingCellSwitchViewHolder14.J;
                                r3 = new View.OnClickListener() {
                                    public void onClick(View view) {
                                        accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).edit().putBoolean("lastred", settingCellSwitchViewHolder14.J.isChecked()).commit();
                                    }
                                };
                            } else if (str3.equals(accountFragment.X4)) {
                                final SettingCellSwitchViewHolder settingCellSwitchViewHolder15 = (SettingCellSwitchViewHolder) viewHolder;
                                settingCellSwitchViewHolder15.I.setText("Use Default System Font");
                                settingCellSwitchViewHolder15.J.setChecked(accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).getBoolean("defaultfont", false));
                                j0 = settingCellSwitchViewHolder15.J;
                                r3 = new View.OnClickListener() {
                                    public void onClick(View view) {
                                        accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).edit().putBoolean("defaultfont", settingCellSwitchViewHolder15.J.isChecked()).commit();
                                    }
                                };
                            } else if (str3.equals(accountFragment.Y4)) {
                                final SettingCellSwitchViewHolder settingCellSwitchViewHolder16 = (SettingCellSwitchViewHolder) viewHolder;
                                settingCellSwitchViewHolder16.I.setText("Load Download List Automatically");
                                settingCellSwitchViewHolder16.J.setChecked(accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).getBoolean("loaddownload", false));
                                settingCellSwitchViewHolder16.J.setOnClickListener(new View.OnClickListener() {
                                    public void onClick(View view) {
                                        accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).edit().putBoolean("loaddownload", settingCellSwitchViewHolder16.J.isChecked()).commit();
                                    }
                                });
                                i0 = settingCellSwitchViewHolder16.I;
                                r2 = new View.OnLongClickListener() {
                                    public boolean onLongClick(View view) {
                                        FragmentActivity r;
                                        String str;
                                        boolean z = !accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).getBoolean("showfreeversion", false);
                                        accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).edit().putBoolean("showfreeversion", z).commit();
                                        if (!z) {
                                            r = accountFragment.this.r();
                                            str = "Showing Last Version : False";
                                        } else {
                                            r = accountFragment.this.r();
                                            str = "Showing Last Version : True";
                                        }
                                        Toast.makeText(r, str, 1).show();
                                        LocalBroadcastManager.b(accountFragment.this.r()).d(new Intent("reloadDownloads"));
                                        return true;
                                    }
                                };
                            } else if (str3.equals(accountFragment.Z4)) {
                                final SettingCellSwitchViewHolder settingCellSwitchViewHolder17 = (SettingCellSwitchViewHolder) viewHolder;
                                settingCellSwitchViewHolder17.I.setText("Justify Texts");
                                settingCellSwitchViewHolder17.J.setChecked(accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).getBoolean("justify", true));
                                j0 = settingCellSwitchViewHolder17.J;
                                r3 = new View.OnClickListener() {
                                    public void onClick(View view) {
                                        accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).edit().putBoolean("justify", settingCellSwitchViewHolder17.J.isChecked()).commit();
                                    }
                                };
                            } else if (str3.equals(accountFragment.a5)) {
                                final SettingCellSwitchViewHolder settingCellSwitchViewHolder18 = (SettingCellSwitchViewHolder) viewHolder;
                                settingCellSwitchViewHolder18.I.setText("Open Last Topic after crash");
                                settingCellSwitchViewHolder18.J.setChecked(accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).getBoolean("openaftercrash", true));
                                j0 = settingCellSwitchViewHolder18.J;
                                r3 = new View.OnClickListener() {
                                    public void onClick(View view) {
                                        accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).edit().putBoolean("openaftercrash", settingCellSwitchViewHolder18.J.isChecked()).commit();
                                    }
                                };
                            } else if (str3.equals(accountFragment.b5)) {
                                final SettingCellSwitchViewHolder settingCellSwitchViewHolder19 = (SettingCellSwitchViewHolder) viewHolder;
                                settingCellSwitchViewHolder19.I.setText("Save Logs");
                                settingCellSwitchViewHolder19.J.setChecked(accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).getBoolean("savelogs", false));
                                j0 = settingCellSwitchViewHolder19.J;
                                r3 = new View.OnClickListener() {
                                    public void onClick(View view) {
                                        accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).edit().putBoolean("savelogs", settingCellSwitchViewHolder19.J.isChecked()).commit();
                                    }
                                };
                            } else if (str3.equals(accountFragment.c5)) {
                                final SettingCellSwitchViewHolder settingCellSwitchViewHolder20 = (SettingCellSwitchViewHolder) viewHolder;
                                settingCellSwitchViewHolder20.I.setText("Enable Wake Lock");
                                settingCellSwitchViewHolder20.J.setChecked(accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).getBoolean("wakelock", true));
                                j0 = settingCellSwitchViewHolder20.J;
                                r3 = new View.OnClickListener() {
                                    public void onClick(View view) {
                                        accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).edit().putBoolean("wakelock", settingCellSwitchViewHolder20.J.isChecked()).commit();
                                    }
                                };
                            } else if (str3.equals(accountFragment.d5)) {
                                final SettingCellSwitchViewHolder settingCellSwitchViewHolder21 = (SettingCellSwitchViewHolder) viewHolder;
                                settingCellSwitchViewHolder21.I.setText("Dark Theme (works sometimes)");
                                settingCellSwitchViewHolder21.J.setChecked(accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).getBoolean("dark", false));
                                j0 = settingCellSwitchViewHolder21.J;
                                r3 = new View.OnClickListener() {
                                    public void onClick(View view) {
                                        accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).edit().putBoolean("dark", settingCellSwitchViewHolder21.J.isChecked()).commit();
                                        accountFragment.this.r().getSharedPreferences("default_preferences", 0).getBoolean("dark", false);
                                        CompressHelper.x2(accountFragment.this.r(), "closing app for changes to take effect", 2);
                                        accountFragment.this.e4.postDelayed(new Runnable() {
                                            public void run() {
                                                Process.killProcess(Process.myPid());
                                            }
                                        }, ExoPlayer.a1);
                                    }
                                };
                            } else if (str3.equals(accountFragment.n5)) {
                                final SettingDetailCellViewHolder settingDetailCellViewHolder3 = (SettingDetailCellViewHolder) viewHolder;
                                settingDetailCellViewHolder3.I.setText("Document Color");
                                settingDetailCellViewHolder3.J.setText(accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).getString("background_color", "#ffffff"));
                                settingDetailCellViewHolder3.K.setVisibility(0);
                                settingDetailCellViewHolder3.K.setOnClickListener(new View.OnClickListener() {
                                    public void onClick(View view) {
                                        accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).edit().remove("background_color").commit();
                                        settingDetailCellViewHolder3.J.setText("#ffffff");
                                    }
                                });
                                settingDetailCellViewHolder3.L.setOnClickListener(new View.OnClickListener() {
                                    public void onClick(View view) {
                                        new AmbilWarnaDialog(accountFragment.this.r(), Color.parseColor(accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).getString("background_color", "#ffffff")), new AmbilWarnaDialog.OnAmbilWarnaListener() {
                                            public void a(AmbilWarnaDialog ambilWarnaDialog, int i2) {
                                                accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).edit().putString("background_color", String.format("#%06X", new Object[]{Integer.valueOf(16777215 & i2)})).commit();
                                                accountFragment.this.f4.getAdapter().H(i7);
                                            }

                                            public void b(AmbilWarnaDialog ambilWarnaDialog) {
                                            }
                                        }).v();
                                    }
                                });
                                return;
                            } else if (str3.equals(accountFragment.f5)) {
                                accountFragment.this.A4 = i7;
                                final SettingDetailCellViewHolder settingDetailCellViewHolder4 = (SettingDetailCellViewHolder) viewHolder;
                                settingDetailCellViewHolder4.I.setText("Line Height");
                                settingDetailCellViewHolder4.J.setText(accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).getString("line_height", "Default"));
                                settingDetailCellViewHolder4.K.setVisibility(0);
                                settingDetailCellViewHolder4.K.setOnClickListener(new View.OnClickListener() {
                                    public void onClick(View view) {
                                        accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).edit().remove("line_height").commit();
                                        settingDetailCellViewHolder4.J.setText("Default");
                                    }
                                });
                                materialRippleLayout = settingDetailCellViewHolder4.L;
                                onClickListener = new View.OnClickListener() {
                                    public void onClick(View view) {
                                        ArrayList arrayList = new ArrayList();
                                        String[] strArr = {"1.0", BuildConfig.f16618f, "1.4", "1.6", "1.8", "2.0", "2.2", "2.4"};
                                        for (int i2 = 0; i2 < 8; i2++) {
                                            arrayList.add(accountFragment.this.m3(strArr[i2]));
                                        }
                                        String string = accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).getString("line_height", "Default");
                                        settingsList settingslist = new settingsList();
                                        Bundle bundle = new Bundle();
                                        bundle.putString("type", "LineHeight");
                                        bundle.putParcelableArrayList("items", arrayList);
                                        bundle.putString("titleProperty", "Title");
                                        bundle.putString("selected", string);
                                        settingslist.i2(bundle);
                                        settingslist.Z2(true);
                                        settingslist.A2(accountFragment.this, 0);
                                        settingslist.e3(accountFragment.this.M(), "SettingListTab");
                                    }
                                };
                            } else if (str3.equals(accountFragment.e5)) {
                                final SettingCellSwitchViewHolder settingCellSwitchViewHolder22 = (SettingCellSwitchViewHolder) viewHolder;
                                settingCellSwitchViewHolder22.I.setText("Automatic QBank Backups");
                                settingCellSwitchViewHolder22.J.setChecked(accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).getBoolean("qbankbackup", true));
                                j0 = settingCellSwitchViewHolder22.J;
                                r3 = new View.OnClickListener() {
                                    public void onClick(View view) {
                                        accountFragment.this.getActivity().getSharedPreferences("default_preferences", 0).edit().putBoolean("qbankbackup", settingCellSwitchViewHolder22.J.isChecked()).commit();
                                    }
                                };
                            } else {
                                return;
                            }
                            j0.setOnClickListener(r3);
                            return;
                        }
                    } else {
                        return;
                    }
                    i0.setOnLongClickListener(r2);
                    return;
                } else if (accountFragment.this.l4.contains(TtmlNode.r0)) {
                    accountTextViewHolder = (AccountTextViewHolder) viewHolder;
                    accountTextViewHolder.J.setOnClickListener((View.OnClickListener) null);
                    accountTextViewHolder.I.setText("You Are Subscribed To All Databases");
                    textView = accountTextViewHolder.I;
                    i3 = accountFragment.this.b0().getColor(R.color.f170grey);
                    textView.setTextColor(i3);
                } else {
                    DatabaseButtonCellViewHolder databaseButtonCellViewHolder = (DatabaseButtonCellViewHolder) viewHolder;
                    final Bundle bundle = (Bundle) accountFragment.this.k4.get(i8);
                    databaseButtonCellViewHolder.I.setText(bundle.getString("Title"));
                    g0(databaseButtonCellViewHolder.K, bundle.getString("IconName"));
                    databaseButtonCellViewHolder.J.setVisibility(8);
                    if (accountFragment.this.m4.containsKey(bundle.getString("name"))) {
                        databaseButtonCellViewHolder.J.setVisibility(0);
                        databaseButtonCellViewHolder.J.setText("Valid until " + CompressHelper.c1(accountFragment.this.m4.getBundle(bundle.getString("name")).getString(DublinCoreProperties.f27398d)));
                        if (accountFragment.this.m4.getBundle(bundle.getString("name")).getInt("expired") == 1) {
                            databaseButtonCellViewHolder.J.setText("Subscription Ended on " + CompressHelper.c1(accountFragment.this.m4.getBundle(bundle.getString("name")).getString(DublinCoreProperties.f27398d)));
                            textView2 = databaseButtonCellViewHolder.J;
                            i5 = SupportMenu.f5941c;
                        } else {
                            textView2 = databaseButtonCellViewHolder.J;
                            i5 = -12303292;
                        }
                        textView2.setTextColor(i5);
                    } else {
                        databaseButtonCellViewHolder.J.setVisibility(8);
                    }
                    final Bundle Y0 = accountFragment.this.p4.Y0("Name", bundle.getString("name"));
                    if (Y0 == null) {
                        databaseButtonCellViewHolder.L.setText("Download");
                        button = databaseButtonCellViewHolder.L;
                        r32 = new View.OnClickListener() {
                            public void onClick(View view) {
                                ((mainActivity) accountFragment.this.r()).y3.setCurrentItem(4);
                                accountFragment.this.e4.postDelayed(new Runnable() {
                                    public void run() {
                                        downloadFragment downloadfragment = ((iMD) accountFragment.this.r().getApplicationContext()).c3;
                                        if (downloadfragment.K3()) {
                                            downloadfragment.M2();
                                        }
                                        downloadfragment.r4.D(0).r();
                                        downloadfragment.m4.k0(bundle.getString("Title"), true);
                                    }
                                }, 1000);
                            }
                        };
                    } else if (Y0.getString("Version").compareTo(bundle.getString("Version")) >= 0) {
                        databaseButtonCellViewHolder.L.setText("Open");
                        databaseButtonCellViewHolder.L.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                ((mainActivity) accountFragment.this.r()).y3.setCurrentItem(1);
                                accountFragment.this.e4.postDelayed(new Runnable() {
                                    public void run() {
                                        AnonymousClass9 r0 = AnonymousClass9.this;
                                        accountFragment.this.p4.z1(Y0);
                                    }
                                }, 1000);
                            }
                        });
                        return;
                    } else {
                        databaseButtonCellViewHolder.L.setText("Update");
                        button = databaseButtonCellViewHolder.L;
                        r32 = new View.OnClickListener() {
                            public void onClick(View view) {
                                ((mainActivity) accountFragment.this.r()).y3.setCurrentItem(4);
                                accountFragment.this.e4.postDelayed(new Runnable() {
                                    public void run() {
                                        downloadFragment downloadfragment = ((iMD) accountFragment.this.r().getApplicationContext()).c3;
                                        downloadfragment.r4.D(0).r();
                                        downloadfragment.m4.k0(bundle.getString("Title"), true);
                                    }
                                }, 1000);
                            }
                        };
                    }
                    button.setOnClickListener(r32);
                    return;
                }
                materialRippleLayout.setOnClickListener(onClickListener);
                return;
                materialRippleLayout2 = accountTextViewHolder.J;
                i4 = accountFragment.this.b0().getColor(R.color.f469white);
                materialRippleLayout2.setBackgroundColor(i4);
            }
        }

        public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
            switch (i2) {
                case 0:
                    return new HeaderCellViewHolder(LayoutInflater.from(accountFragment.this.r()).inflate(R.layout.f1310list_view_item_database_header, viewGroup, false));
                case 1:
                    AccountTextViewHolder accountTextViewHolder = new AccountTextViewHolder(LayoutInflater.from(accountFragment.this.r()).inflate(R.layout.f1298list_view_item_account_text, viewGroup, false));
                    accountTextViewHolder.J.setRippleColor(accountFragment.this.b0().getColor(R.color.material_grey_300));
                    return accountTextViewHolder;
                case 2:
                    return new DatabaseButtonCellViewHolder(LayoutInflater.from(accountFragment.this.r()).inflate(R.layout.f1307list_view_item_database_button, viewGroup, false));
                case 3:
                    return new SimpleTextViewHolder(LayoutInflater.from(accountFragment.this.r()).inflate(R.layout.f1365list_view_item_simple_text, viewGroup, false));
                case 4:
                    return new SocialCellViewHolder(LayoutInflater.from(accountFragment.this.r()).inflate(R.layout.f1373list_view_item_social, viewGroup, false));
                case 5:
                    return new SettingCellViewHolder(LayoutInflater.from(accountFragment.this.r()).inflate(R.layout.f1362list_view_item_setting_text, viewGroup, false));
                case 6:
                    return new SettingCellSwitchViewHolder(LayoutInflater.from(accountFragment.this.r()).inflate(R.layout.f1364list_view_item_setting_text_switch, viewGroup, false));
                case 7:
                    return new SeparatorViewHolder(LayoutInflater.from(accountFragment.this.r()).inflate(R.layout.f1361list_view_item_separator, viewGroup, false));
                case 8:
                    return new SettingDetailCellViewHolder(LayoutInflater.from(accountFragment.this.r()).inflate(R.layout.f1363list_view_item_setting_text_detail, viewGroup, false));
                default:
                    return null;
            }
        }

        public int b() {
            return k0(accountFragment.this.h4);
        }

        public Bundle d0(int i2, ArrayList<String> arrayList) {
            Iterator<String> it2 = arrayList.iterator();
            int i3 = 0;
            while (it2.hasNext()) {
                String next = it2.next();
                if (i2 == i3) {
                    Bundle bundle = new Bundle();
                    if (next.endsWith("Information")) {
                        next = next + " - " + accountFragment.this.u4;
                    }
                    bundle.putString("Text", next);
                    bundle.putString("Type", "Header");
                    return bundle;
                }
                int h0 = i3 + h0(next);
                if (i2 <= h0) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("Section", next);
                    bundle2.putInt("Index", (i2 - (h0 - h0(next))) - 1);
                    bundle2.putString("Type", "Item");
                    return bundle2;
                }
                i3 = h0 + 1;
            }
            return null;
        }

        public void e0(final Runnable runnable, final Runnable runnable2) {
            final BeautifulProgressDialog beautifulProgressDialog = new BeautifulProgressDialog(accountFragment.this.r(), BeautifulProgressDialog.q, (String) null);
            beautifulProgressDialog.p("loading-1.json");
            beautifulProgressDialog.q(true);
            new Thread(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(500);
                        accountFragment.this.e4.post(new Runnable() {
                            public void run() {
                                if (!accountFragment.this.o4) {
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
                        boolean unused = accountFragment.this.o4 = true;
                        beautifulProgressDialog.a();
                    }
                }
            }).h6(Schedulers.e()).s4(AndroidSchedulers.e()).e6(new Consumer<String>() {
                /* renamed from: a */
                public void accept(String str) throws Throwable {
                    boolean unused = accountFragment.this.o4 = true;
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
                    boolean unused = accountFragment.this.o4 = true;
                    beautifulProgressDialog.a();
                    th.printStackTrace();
                    FirebaseCrashlytics.d().g(th);
                    runnable2.run();
                }
            });
        }

        public void f0() {
            HashSet<String> o1 = accountFragment.this.p4.o1();
            new ArrayList();
            Iterator<String> it2 = o1.iterator();
            while (it2.hasNext()) {
                j0(new File(it2.next()));
            }
        }

        public void g0(ImageView imageView, String str) {
            RequestBuilder<Drawable> P;
            ArrayList arrayList = new ArrayList();
            arrayList.add("visualdx.png");
            arrayList.add("uptodate.png");
            arrayList.add("irandarou.png");
            if (arrayList.contains(str)) {
                RequestManager F = Glide.F(accountFragment.this);
                P = F.g(Uri.parse("file:///android_asset/" + str));
            } else {
                RequestManager F2 = Glide.F(accountFragment.this);
                P = F2.t(accountFragment.this.p4.getBaseUrl() + "/Icons/" + str);
            }
            P.B2(imageView);
        }

        public int h0(String str) {
            ArrayList Y2;
            if (str.equals("Account Information")) {
                String a2 = accountFragment.this.p4.a();
                if (a2.equals("All")) {
                    return 1;
                }
                return a2.equals("Simple") ? 5 : 3;
            } else if (str.equals("Help")) {
                return 2;
            } else {
                if (str.equals("Your Databases")) {
                    if (accountFragment.this.l4 == null) {
                        return 0;
                    }
                    if (accountFragment.this.l4.contains(TtmlNode.r0)) {
                        return 1;
                    }
                    if (accountFragment.this.k4 == null) {
                        return 0;
                    }
                    Y2 = accountFragment.this.k4;
                } else if (str.equals("About Us")) {
                    return 8;
                } else {
                    if (!str.equals("Settings")) {
                        return str.equals("") ? 5 : 0;
                    }
                    if (accountFragment.this.i4.booleanValue()) {
                        return 0;
                    }
                    Y2 = accountFragment.this.x4;
                }
                return Y2.size();
            }
        }

        public void i0(Intent intent) {
        }

        public void j0(File file) {
            try {
                if (file.isDirectory()) {
                    if (!file.canRead() || !file.canWrite() || !file.canExecute()) {
                        file.setReadable(true, false);
                        file.setWritable(true, false);
                        file.setExecutable(true, false);
                    }
                    File[] listFiles = file.listFiles();
                    if (listFiles != null) {
                        for (File j0 : listFiles) {
                            j0(j0);
                        }
                    }
                } else if (!file.canRead() || !file.canWrite()) {
                    file.setReadable(true, false);
                    file.setWritable(true, false);
                }
            } catch (Exception unused) {
            }
        }

        public int k0(ArrayList<String> arrayList) {
            int i2 = 0;
            if (arrayList == null) {
                return 0;
            }
            Iterator<String> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                i2 = i2 + h0(it2.next()) + 1;
            }
            return i2;
        }
    }

    public class AccountTextViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public final TextView I;
        /* access modifiers changed from: private */
        public final MaterialRippleLayout J;

        public AccountTextViewHolder(View view) {
            super(view);
            this.I = (TextView) view.findViewById(R.id.text);
            MaterialRippleLayout materialRippleLayout = (MaterialRippleLayout) view.findViewById(R.id.f1061ripple_layout);
            this.J = materialRippleLayout;
            materialRippleLayout.setOnClickListener(new View.OnClickListener(accountFragment.this) {
                public void onClick(View view) {
                }
            });
        }
    }

    public static class DatabaseButtonCellViewHolder extends RecyclerView.ViewHolder {
        public TextView I;
        public TextView J;
        public ImageView K;
        public Button L;

        public DatabaseButtonCellViewHolder(View view) {
            super(view);
            this.I = (TextView) view.findViewById(R.id.f896database_title);
            this.J = (TextView) view.findViewById(R.id.f895database_subtitle);
            this.K = (ImageView) view.findViewById(R.id.f893database_image);
            this.L = (Button) view.findViewById(R.id.f851button);
        }
    }

    public static class DatabaseCellViewHolder extends RecyclerView.ViewHolder {
        public TextView I;
        public TextView J;
        public ImageView K;

        public DatabaseCellViewHolder(View view) {
            super(view);
            this.I = (TextView) view.findViewById(R.id.f896database_title);
            this.J = (TextView) view.findViewById(R.id.f895database_subtitle);
            this.K = (ImageView) view.findViewById(R.id.f893database_image);
        }
    }

    public static class HeaderCellViewHolder extends RecyclerView.ViewHolder {
        public TextView I;

        public HeaderCellViewHolder(View view) {
            super(view);
            this.I = (TextView) view.findViewById(R.id.f957header_text);
        }
    }

    public class SeparatorViewHolder extends RecyclerView.ViewHolder {
        public SeparatorViewHolder(View view) {
            super(view);
        }
    }

    public class SettingCellSwitchViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public final TextView I;
        /* access modifiers changed from: private */
        public final SwitchCompat J;

        public SettingCellSwitchViewHolder(View view) {
            super(view);
            this.I = (TextView) view.findViewById(R.id.text);
            this.J = (SwitchCompat) view.findViewById(R.id.f1102switch_view);
        }
    }

    public class SettingCellViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public final TextView I;
        /* access modifiers changed from: private */
        public final MaterialRippleLayout J;

        public SettingCellViewHolder(View view) {
            super(view);
            this.I = (TextView) view.findViewById(R.id.text);
            this.J = (MaterialRippleLayout) view.findViewById(R.id.f1061ripple_layout);
        }
    }

    public class SettingDetailCellViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public final TextView I;
        /* access modifiers changed from: private */
        public final TextView J;
        /* access modifiers changed from: private */
        public final Button K;
        /* access modifiers changed from: private */
        public final MaterialRippleLayout L;

        public SettingDetailCellViewHolder(View view) {
            super(view);
            this.I = (TextView) view.findViewById(R.id.text);
            this.L = (MaterialRippleLayout) view.findViewById(R.id.f1061ripple_layout);
            this.J = (TextView) view.findViewById(R.id.f907detail_text);
            this.K = (Button) view.findViewById(R.id.f1059reset_button);
        }
    }

    public class SimpleTextViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public final TextView I;

        public SimpleTextViewHolder(View view) {
            super(view);
            this.I = (TextView) view.findViewById(R.id.text);
        }
    }

    public static class SocialCellViewHolder extends RecyclerView.ViewHolder {
        public TextView I;
        public ImageView J;
        public MaterialRippleLayout K;

        public SocialCellViewHolder(View view) {
            super(view);
            this.I = (TextView) view.findViewById(R.id.f896database_title);
            this.J = (ImageView) view.findViewById(R.id.f893database_image);
            this.K = (MaterialRippleLayout) view.findViewById(R.id.f1061ripple_layout);
        }
    }

    private void L2() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.x4 = arrayList;
        arrayList.add(G4);
        this.x4.add(I4);
        this.x4.add(J4);
        this.x4.add(L4);
        this.x4.add(O4);
        this.x4.add(P4);
        this.x4.add(Q4);
        this.x4.add(S4);
        this.x4.add(U4);
        this.x4.add(g5);
        this.x4.add(V4);
        this.x4.add(W4);
        this.x4.add(X4);
        this.x4.add(Z4);
        this.x4.add(a5);
        this.x4.add(c5);
        this.x4.add(d5);
        this.x4.add(f5);
        this.x4.add(n5);
        this.x4.add(e5);
        this.x4.add(i5);
        this.x4.add(j5);
        this.x4.add(k5);
        this.x4.add(l5);
        this.x4.add(m5);
    }

    /* access modifiers changed from: private */
    public void M2() {
        int i2 = 0;
        try {
            i2 = r().getPackageManager().getPackageInfo(r().getPackageName(), 0).versionCode;
        } catch (Exception unused) {
        }
        CompressHelper compressHelper = this.p4;
        compressHelper.o0("ActivationCode|||||" + this.q4.m() + "|||||android-" + i2).h6(Schedulers.e()).s4(AndroidSchedulers.e()).f6(new Consumer<String>() {
            /* renamed from: a */
            public void accept(String str) throws Throwable {
                String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(str, "|||||");
                if (splitByWholeSeparator[0].equals(IcyHeaders.a3)) {
                    accountFragment.this.p4.t2(splitByWholeSeparator[1]);
                    accountFragment.this.N2();
                    accountFragment.this.J2();
                    accountFragment.this.g4.setRefreshing(false);
                } else if (splitByWholeSeparator[0].equals("0")) {
                    accountFragment.this.p4.t2((String) null);
                    iMDLogger.f("system finish", "CheckActivationCode : " + str);
                    accountFragment.this.r().finish();
                    System.exit(0);
                }
            }
        }, new Consumer<Throwable>() {
            /* renamed from: a */
            public void accept(Throwable th) throws Throwable {
                try {
                    th.printStackTrace();
                    accountFragment.this.g4.setRefreshing(false);
                } catch (Exception unused) {
                }
            }
        }, new Action() {
            public void run() throws Throwable {
            }
        });
    }

    /* access modifiers changed from: private */
    public void N2() {
        try {
            VBHelper vBHelper = this.q4;
            String[] split = TextUtils.split(vBHelper.x(vBHelper.m()).replace("||", "::"), "::");
            String[] split2 = TextUtils.split(split[3], ",");
            this.n4 = split[5];
            this.l4 = new ArrayList<>(Arrays.asList(split2));
            ArrayList<String> arrayList = new ArrayList<>();
            this.m4 = new Bundle();
            Iterator<String> it2 = this.l4.iterator();
            while (it2.hasNext()) {
                String next = it2.next();
                if (next.contains("$$$")) {
                    int i2 = 0;
                    String str = StringUtils.splitByWholeSeparator(next, "$$$")[0];
                    if (str.contains("-expired")) {
                        str = str.replace("-expired", "");
                        i2 = 1;
                    }
                    arrayList.add(str);
                    Bundle bundle = new Bundle();
                    bundle.putString(DublinCoreProperties.f27398d, StringUtils.splitByWholeSeparator(next, "$$$")[1]);
                    bundle.putInt("expired", i2);
                    this.m4.putBundle(str, bundle);
                } else {
                    arrayList.add(next);
                }
            }
            this.l4 = arrayList;
            if (split.length > 9) {
                this.u4 = split[9];
            } else {
                this.u4 = "";
            }
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            this.n4 = "0";
            this.l4 = new ArrayList<>();
        }
    }

    private String o3() {
        return Formatter.formatIpAddress(((WifiManager) this.r4.getApplicationContext().getSystemService("wifi")).getConnectionInfo().getIpAddress());
    }

    /* access modifiers changed from: private */
    public void t3() {
        File file = new File(this.p4.M1());
        if (this.w4 == null || this.v4.equals("Start File Web Server")) {
            if (this.w4 == null) {
                this.w4 = new FileWebServer(r(), 1080, file);
            }
            try {
                this.w4.L();
                String o3 = o3();
                this.v4 = "http://" + o3 + ":1080/";
            } catch (IOException e2) {
                e2.printStackTrace();
                this.v4 = "Failed to start server";
            }
        } else {
            this.w4.O();
            this.v4 = "Start File Web Server";
        }
        this.f4.getAdapter().G();
    }

    public void J2() {
        K2();
    }

    public void K2() {
        String str = this.p4.U1() + "/DBs.db";
        if (new File(str).exists()) {
            try {
                this.k4 = this.p4.Y(str, "select id,Title,name,max(Version) as Version, IconName,folderSize, url, fileSize, md5,price from Dbs where name in ('" + TextUtils.join("','", this.l4) + "') group by name order by title asc");
            } catch (Exception e2) {
                FirebaseCrashlytics.d().g(e2);
                iMDLogger.f("LoadDBS", "Error in querying db. let's delete that");
                new File(str).delete();
            }
            iMDLogger.f("LoadDBs", "Load DBS Completed");
            this.f4.getAdapter().G();
        }
    }

    public void M0(Activity activity) {
        super.M0(activity);
        this.r4 = activity;
    }

    public void O2(String str, final boolean z) {
        if (str.length() == 0) {
            this.p4.v2("You must enter a backup identifier");
            return;
        }
        final ProgressDialog show = ProgressDialog.show(r(), "Restoring", "Please wait...", true);
        this.p4.o0("LoadFromFileZip|||||" + str).h6(Schedulers.e()).s4(AndroidSchedulers.e()).e6(new Consumer<String>() {
            /* renamed from: a */
            public void accept(String str) throws Throwable {
                String M0 = CompressHelper.M0(str);
                if (M0.length() == 0) {
                    show.dismiss();
                    accountFragment.this.p4.v2("Identifier not found");
                    return;
                }
                String[] splitByWholeSeparatorPreserveAllTokens = StringUtils.splitByWholeSeparatorPreserveAllTokens(M0, "###");
                if (accountFragment.this.p4.t(splitByWholeSeparatorPreserveAllTokens[0]) != 5) {
                    show.dismiss();
                    CompressHelper.x2(accountFragment.this.r(), "This backup code is not created here.", 1);
                    return;
                }
                if (z) {
                    CompressHelper compressHelper = accountFragment.this.p4;
                    compressHelper.q(compressHelper.X0(), "Delete from favorites");
                    accountFragment accountfragment = accountFragment.this;
                    accountfragment.p4.q(accountfragment.q3(), "Delete from highlight");
                }
                CompressHelper compressHelper2 = accountFragment.this.p4;
                compressHelper2.m0(splitByWholeSeparatorPreserveAllTokens[0], compressHelper2.X0(), "favorites", "dbName,dbTitle,dbAddress,dbDate,dbDocName", (Bundle) null);
                accountFragment accountfragment2 = accountFragment.this;
                accountfragment2.p4.m0(splitByWholeSeparatorPreserveAllTokens[1], accountfragment2.q3(), "highlight", "dbName,dbTitle,dbAddress,dbDate,dbDocName,type,text,note,save", (Bundle) null);
                show.dismiss();
                accountFragment.this.p4.v2("Restore successful");
                accountFragment.this.r3();
            }
        }, new Consumer<Throwable>() {
            /* renamed from: a */
            public void accept(Throwable th) throws Throwable {
                th.printStackTrace();
                FirebaseCrashlytics.d().g(th);
                show.dismiss();
                accountFragment.this.p4.v2("Error in contacting server");
            }
        });
    }

    public void Q0(Bundle bundle) {
        super.Q0(bundle);
        LocalBroadcastManager.b(getActivity()).c(this.D4, new IntentFilter("referesh.account"));
        LocalBroadcastManager.b(getActivity()).c(this.E4, new IntentFilter("referesh.account.visible"));
        LocalBroadcastManager.b(getActivity()).c(this.F4, new IntentFilter("reloadaccountdownloads"));
    }

    public void T0(Menu menu, MenuInflater menuInflater) {
        menu.clear();
        menuInflater.inflate(R.menu.f1415menu_account, menu);
        try {
            r().setTitle("Account & Settings");
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
        }
        super.T0(menu, menuInflater);
    }

    public View onFragmentBind(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.e4;
        if (view != null) {
            return view;
        }
        this.i4 = Boolean.FALSE;
        this.j4 = "";
        this.C4 = Typeface.createFromAsset(r().getAssets(), "fonts/IRANSans(FaNum).ttf");
        this.v4 = "Start File Web Server";
        L2();
        View inflate = layoutInflater.inflate(R.layout.f1211fragment_account, viewGroup, false);
        this.p4 = new CompressHelper(r());
        this.q4 = new VBHelper(r());
        this.e4 = inflate;
        p3();
        RecyclerView recyclerView = (RecyclerView) this.e4.findViewById(R.id.f1054recycler_view);
        this.f4 = recyclerView;
        recyclerView.setItemDecoration(new CustomItemDecoration(r()));
        this.f4.setLayoutManager(new LinearLayoutManager(r(), 1, false));
        this.f4.setAdapter(new AccountAdapter());
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) this.e4.findViewById(R.id.f1101swipeRefreshLayout);
        this.g4 = swipeRefreshLayout;
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            public void a() {
                accountFragment.this.M2();
            }
        });
        ArrayList<String> arrayList = new ArrayList<>();
        this.h4 = arrayList;
        arrayList.add("Account Information");
        this.h4.add("Your Databases");
        this.h4.add("Settings");
        this.h4.add("About Us");
        ButtonFloatHelp buttonFloatHelp = (ButtonFloatHelp) this.e4.findViewById(R.id.f958help);
        this.s4 = buttonFloatHelp;
        buttonFloatHelp.setVisibility(8);
        ButtonFloatHelpBadge buttonFloatHelpBadge = (ButtonFloatHelpBadge) this.e4.findViewById(R.id.f959helpBadge);
        this.t4 = buttonFloatHelpBadge;
        buttonFloatHelpBadge.setVisibility(8);
        this.k4 = new ArrayList<>();
        N2();
        J2();
        o2(true);
        return inflate;
    }

    public void onDestroy() {
        LocalBroadcastManager.b(getActivity()).f(this.D4);
        LocalBroadcastManager.b(getActivity()).f(this.E4);
        LocalBroadcastManager.b(getActivity()).f(this.F4);
        super.onDestroy();
    }

    public Bundle m3(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("Title", str);
        return bundle;
    }

    public String n3() {
        Iterator<Bundle> it2 = CompressHelper.t.iterator();
        int i2 = 0;
        String str = "";
        while (it2.hasNext()) {
            Bundle next = it2.next();
            i2++;
            str = str + i2 + ". " + ((((("" + "Title : " + next.getString("Title") + " | ") + "Type : " + next.getString("Type") + " | ") + "Name : " + next.getString("Name") + " | ") + "Version : " + next.getString("Version") + " | ") + "Path : " + next.getString("Path")) + "\n\n";
        }
        return str.trim();
    }

    public void p3() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) r().getSystemService("input_method");
            if (r().getCurrentFocus() != null) {
                inputMethodManager.hideSoftInputFromWindow(r().getCurrentFocus().getWindowToken(), 0);
            }
            if (r().getCurrentFocus() != null) {
                r().getCurrentFocus().clearFocus();
            }
        } catch (Exception unused) {
        }
    }

    public String q3() {
        String str = this.p4.M1() + "/highlights.db";
        if (!new File(str).exists()) {
            SQLiteDatabase.openOrCreateDatabase(str, (SQLiteDatabase.CursorFactory) null).execSQL("create virtual table highlight using fts4 (dbName, dbTitle, dbAddress, dbDate, dbDocName, type, text, note, save)");
        }
        return str;
    }

    public void r3() {
        iMDLogger.d("sendFavorite", "Sending FavoriteChanged message");
        Intent intent = new Intent("net.imedicaldoctor.imd.favorite");
        intent.putExtra("Test", "Random data for test");
        LocalBroadcastManager.b(r()).d(intent);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x01b3, code lost:
        if (V1().getSharedPreferences("default_preferences", 0).contains(r0) != false) goto L_0x01b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x01fd, code lost:
        if (V1().getSharedPreferences("default_preferences", 0).contains(r0) != false) goto L_0x01b5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void s3(android.os.Bundle r6, java.lang.String r7) {
        /*
            r5 = this;
            java.lang.String r0 = "DownloadPath"
            boolean r1 = r7.equals(r0)
            r2 = 0
            java.lang.String r3 = "default_preferences"
            if (r1 == 0) goto L_0x0056
            if (r6 == 0) goto L_0x0200
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
            goto L_0x0200
        L_0x0056:
            java.lang.String r0 = "Tab"
            boolean r1 = r7.equals(r0)
            java.lang.String r4 = "Title"
            if (r1 == 0) goto L_0x009a
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
            goto L_0x0200
        L_0x009a:
            java.lang.String r0 = "MainDL"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x00e9
            androidx.fragment.app.FragmentActivity r7 = r5.V1()
            android.content.SharedPreferences r7 = r7.getSharedPreferences(r3, r2)
            java.lang.String r0 = "MainServer"
            boolean r7 = r7.contains(r0)
            if (r7 == 0) goto L_0x00c5
            androidx.fragment.app.FragmentActivity r7 = r5.V1()
            android.content.SharedPreferences r7 = r7.getSharedPreferences(r3, r2)
            android.content.SharedPreferences$Editor r7 = r7.edit()
            android.content.SharedPreferences$Editor r7 = r7.remove(r0)
            r7.commit()
        L_0x00c5:
            java.lang.String r6 = r6.getString(r4)
            androidx.fragment.app.FragmentActivity r7 = r5.V1()
            android.content.SharedPreferences r7 = r7.getSharedPreferences(r3, r2)
            android.content.SharedPreferences$Editor r7 = r7.edit()
            android.content.SharedPreferences$Editor r6 = r7.putString(r0, r6)
            r6.commit()
            androidx.recyclerview.widget.RecyclerView r6 = r5.f4
            androidx.recyclerview.widget.RecyclerView$Adapter r6 = r6.getAdapter()
            int r7 = r5.y4
        L_0x00e4:
            r6.H(r7)
            goto L_0x0200
        L_0x00e9:
            java.lang.String r0 = "LineHeight"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0134
            androidx.fragment.app.FragmentActivity r7 = r5.V1()
            android.content.SharedPreferences r7 = r7.getSharedPreferences(r3, r2)
            java.lang.String r0 = "line_height"
            boolean r7 = r7.contains(r0)
            if (r7 == 0) goto L_0x0114
            androidx.fragment.app.FragmentActivity r7 = r5.V1()
            android.content.SharedPreferences r7 = r7.getSharedPreferences(r3, r2)
            android.content.SharedPreferences$Editor r7 = r7.edit()
            android.content.SharedPreferences$Editor r7 = r7.remove(r0)
            r7.commit()
        L_0x0114:
            java.lang.String r6 = r6.getString(r4)
            androidx.fragment.app.FragmentActivity r7 = r5.V1()
            android.content.SharedPreferences r7 = r7.getSharedPreferences(r3, r2)
            android.content.SharedPreferences$Editor r7 = r7.edit()
            android.content.SharedPreferences$Editor r6 = r7.putString(r0, r6)
            r6.commit()
            androidx.recyclerview.widget.RecyclerView r6 = r5.f4
            androidx.recyclerview.widget.RecyclerView$Adapter r6 = r6.getAdapter()
            int r7 = r5.A4
            goto L_0x00e4
        L_0x0134:
            java.lang.String r0 = "DL"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x019f
            androidx.fragment.app.FragmentActivity r7 = r5.V1()
            android.content.SharedPreferences r7 = r7.getSharedPreferences(r3, r2)
            java.lang.String r0 = "DownloadServer"
            boolean r7 = r7.contains(r0)
            if (r7 == 0) goto L_0x015f
            androidx.fragment.app.FragmentActivity r7 = r5.V1()
            android.content.SharedPreferences r7 = r7.getSharedPreferences(r3, r2)
            android.content.SharedPreferences$Editor r7 = r7.edit()
            android.content.SharedPreferences$Editor r7 = r7.remove(r0)
            r7.commit()
        L_0x015f:
            java.lang.String r6 = r6.getString(r4)
            java.lang.String r7 = "Iran"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x016e
            java.lang.String r6 = "idl"
            goto L_0x0170
        L_0x016e:
            java.lang.String r6 = "dl"
        L_0x0170:
            androidx.fragment.app.FragmentActivity r7 = r5.V1()
            android.content.SharedPreferences r7 = r7.getSharedPreferences(r3, r2)
            android.content.SharedPreferences$Editor r7 = r7.edit()
            android.content.SharedPreferences$Editor r6 = r7.putString(r0, r6)
            r6.commit()
            androidx.fragment.app.FragmentActivity r6 = r5.r()
            androidx.localbroadcastmanager.content.LocalBroadcastManager r6 = androidx.localbroadcastmanager.content.LocalBroadcastManager.b(r6)
            android.content.Intent r7 = new android.content.Intent
            java.lang.String r0 = "reloadDownloads"
            r7.<init>(r0)
            r6.d(r7)
            androidx.recyclerview.widget.RecyclerView r6 = r5.f4
            androidx.recyclerview.widget.RecyclerView$Adapter r6 = r6.getAdapter()
            int r7 = r5.z4
            goto L_0x00e4
        L_0x019f:
            java.lang.String r0 = "SearchResult"
            boolean r1 = r7.equals(r0)
            if (r1 == 0) goto L_0x01e9
            androidx.fragment.app.FragmentActivity r7 = r5.V1()
            android.content.SharedPreferences r7 = r7.getSharedPreferences(r3, r2)
            boolean r7 = r7.contains(r0)
            if (r7 == 0) goto L_0x01c8
        L_0x01b5:
            androidx.fragment.app.FragmentActivity r7 = r5.V1()
            android.content.SharedPreferences r7 = r7.getSharedPreferences(r3, r2)
            android.content.SharedPreferences$Editor r7 = r7.edit()
            android.content.SharedPreferences$Editor r7 = r7.remove(r0)
            r7.commit()
        L_0x01c8:
            androidx.fragment.app.FragmentActivity r7 = r5.V1()
            android.content.SharedPreferences r7 = r7.getSharedPreferences(r3, r2)
            android.content.SharedPreferences$Editor r7 = r7.edit()
            java.lang.String r6 = r6.getString(r4)
            android.content.SharedPreferences$Editor r6 = r7.putString(r0, r6)
            r6.commit()
            androidx.recyclerview.widget.RecyclerView r6 = r5.f4
            androidx.recyclerview.widget.RecyclerView$Adapter r6 = r6.getAdapter()
            r6.G()
            goto L_0x0200
        L_0x01e9:
            java.lang.String r0 = "ContentSearchResult"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0200
            androidx.fragment.app.FragmentActivity r7 = r5.V1()
            android.content.SharedPreferences r7 = r7.getSharedPreferences(r3, r2)
            boolean r7 = r7.contains(r0)
            if (r7 == 0) goto L_0x01c8
            goto L_0x01b5
        L_0x0200:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.accountFragment.s3(android.os.Bundle, java.lang.String):void");
    }
}
