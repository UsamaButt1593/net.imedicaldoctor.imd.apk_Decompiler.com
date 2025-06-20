package net.imedicaldoctor.imd.Fragments;

import android.animation.Animator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.internal.view.SupportMenu;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Utils.Devices;
import net.imedicaldoctor.imd.VBHelper;
import net.imedicaldoctor.imd.Views.ProgressBarCircularIndeterminate;
import net.imedicaldoctor.imd.iMDActivity;

public class activationActivity extends iMDActivity {
    /* access modifiers changed from: private */
    public static final ExecutorService y3 = Executors.newSingleThreadExecutor();
    /* access modifiers changed from: private */
    public static final Handler z3 = new Handler(Looper.getMainLooper());

    public static class activationFragment extends Fragment {
        public View e4;
        public VBHelper f4;
        /* access modifiers changed from: private */
        public int g4 = 0;
        /* access modifiers changed from: private */
        public String h4;
        /* access modifiers changed from: private */
        public TextView i4;
        /* access modifiers changed from: private */
        public EditText j4;
        /* access modifiers changed from: private */
        public EditText k4;

        private static class ResultWrapper {

            /* renamed from: a  reason: collision with root package name */
            String f30082a;

            private ResultWrapper() {
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.lang.String} */
        /* JADX WARNING: type inference failed for: r4v1 */
        /* JADX WARNING: type inference failed for: r4v2, types: [java.net.HttpURLConnection] */
        /* JADX WARNING: type inference failed for: r4v5 */
        /* JADX WARNING: type inference failed for: r4v6 */
        /* JADX WARNING: type inference failed for: r4v8 */
        /* JADX WARNING: type inference failed for: r4v9 */
        /* JADX WARNING: type inference failed for: r4v10 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x0115  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x011a A[SYNTHETIC, Splitter:B:34:0x011a] */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x0136  */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x013e  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x0143 A[SYNTHETIC, Splitter:B:44:0x0143] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private java.lang.String O2(java.lang.String r10) {
            /*
                r9 = this;
                java.lang.String r0 = "Error closing stream "
                java.lang.String r1 = "Sendcommand"
                net.imedicaldoctor.imd.Data.CompressHelper r2 = new net.imedicaldoctor.imd.Data.CompressHelper
                androidx.fragment.app.FragmentActivity r3 = r9.r()
                r2.<init>(r3)
                net.imedicaldoctor.imd.VBHelper r3 = r9.f4
                java.lang.String r4 = "127"
                java.lang.String r3 = r3.n(r10, r4)
                r4 = 0
                java.net.URL r5 = new java.net.URL     // Catch:{ IOException -> 0x00eb, all -> 0x00e8 }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00eb, all -> 0x00e8 }
                r6.<init>()     // Catch:{ IOException -> 0x00eb, all -> 0x00e8 }
                java.lang.String r2 = r2.J()     // Catch:{ IOException -> 0x00eb, all -> 0x00e8 }
                r6.append(r2)     // Catch:{ IOException -> 0x00eb, all -> 0x00e8 }
                java.lang.String r2 = "/imd.php"
                r6.append(r2)     // Catch:{ IOException -> 0x00eb, all -> 0x00e8 }
                java.lang.String r2 = r6.toString()     // Catch:{ IOException -> 0x00eb, all -> 0x00e8 }
                r5.<init>(r2)     // Catch:{ IOException -> 0x00eb, all -> 0x00e8 }
                java.net.URLConnection r2 = r5.openConnection()     // Catch:{ IOException -> 0x00eb, all -> 0x00e8 }
                java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IOException -> 0x00eb, all -> 0x00e8 }
                java.lang.String r5 = "POST"
                r2.setRequestMethod(r5)     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                r5 = 10000(0x2710, float:1.4013E-41)
                r2.setReadTimeout(r5)     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                r5 = 15000(0x3a98, float:2.102E-41)
                r2.setConnectTimeout(r5)     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                r5 = 1
                r2.setDoInput(r5)     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                r2.setDoOutput(r5)     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                java.io.OutputStream r5 = r2.getOutputStream()     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                java.io.BufferedWriter r6 = new java.io.BufferedWriter     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                java.io.OutputStreamWriter r7 = new java.io.OutputStreamWriter     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                java.nio.charset.Charset r8 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                r7.<init>(r5, r8)     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                r6.<init>(r7)     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                r7.<init>()     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                java.lang.String r8 = "command="
                r7.append(r8)     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                r7.append(r3)     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                java.lang.String r3 = r7.toString()     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                r6.write(r3)     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                r6.flush()     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                r6.close()     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                r5.close()     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                r2.connect()     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                java.io.InputStream r3 = r2.getInputStream()     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                java.lang.StringBuffer r5 = new java.lang.StringBuffer     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                r5.<init>()     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                java.io.InputStreamReader r7 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                r7.<init>(r3)     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                r6.<init>(r7)     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
            L_0x008f:
                java.lang.String r3 = r6.readLine()     // Catch:{ IOException -> 0x00ae }
                if (r3 == 0) goto L_0x00b0
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00ae }
                r7.<init>()     // Catch:{ IOException -> 0x00ae }
                r7.append(r3)     // Catch:{ IOException -> 0x00ae }
                java.lang.String r3 = "\n"
                r7.append(r3)     // Catch:{ IOException -> 0x00ae }
                java.lang.String r3 = r7.toString()     // Catch:{ IOException -> 0x00ae }
                r5.append(r3)     // Catch:{ IOException -> 0x00ae }
                goto L_0x008f
            L_0x00aa:
                r3 = move-exception
            L_0x00ab:
                r4 = r2
                goto L_0x013c
            L_0x00ae:
                r3 = move-exception
                goto L_0x00ee
            L_0x00b0:
                r5.length()     // Catch:{ IOException -> 0x00ae }
                java.lang.String r4 = r5.toString()     // Catch:{ IOException -> 0x00ae }
                r2.disconnect()
                r6.close()     // Catch:{ IOException -> 0x00bf }
                goto L_0x0134
            L_0x00bf:
                r2 = move-exception
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r1)
                r3.append(r10)
                java.lang.String r10 = r3.toString()
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
            L_0x00d4:
                r1.append(r0)
                r1.append(r2)
                java.lang.String r0 = r1.toString()
                net.imedicaldoctor.imd.iMDLogger.f(r10, r0)
                goto L_0x0134
            L_0x00e2:
                r3 = move-exception
                r6 = r4
                goto L_0x00ab
            L_0x00e5:
                r3 = move-exception
                r6 = r4
                goto L_0x00ee
            L_0x00e8:
                r3 = move-exception
                r6 = r4
                goto L_0x013c
            L_0x00eb:
                r3 = move-exception
                r2 = r4
                r6 = r2
            L_0x00ee:
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00aa }
                r5.<init>()     // Catch:{ all -> 0x00aa }
                java.lang.String r7 = "Sendcommand "
                r5.append(r7)     // Catch:{ all -> 0x00aa }
                r5.append(r10)     // Catch:{ all -> 0x00aa }
                java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00aa }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00aa }
                r7.<init>()     // Catch:{ all -> 0x00aa }
                java.lang.String r8 = "Error in "
                r7.append(r8)     // Catch:{ all -> 0x00aa }
                r7.append(r3)     // Catch:{ all -> 0x00aa }
                java.lang.String r3 = r7.toString()     // Catch:{ all -> 0x00aa }
                net.imedicaldoctor.imd.iMDLogger.f(r5, r3)     // Catch:{ all -> 0x00aa }
                if (r2 == 0) goto L_0x0118
                r2.disconnect()
            L_0x0118:
                if (r6 == 0) goto L_0x0134
                r6.close()     // Catch:{ IOException -> 0x011e }
                goto L_0x0134
            L_0x011e:
                r2 = move-exception
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r1)
                r3.append(r10)
                java.lang.String r10 = r3.toString()
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                goto L_0x00d4
            L_0x0134:
                if (r4 == 0) goto L_0x013b
                java.lang.String r10 = "Sendcommand result"
                net.imedicaldoctor.imd.iMDLogger.j(r10, r4)
            L_0x013b:
                return r4
            L_0x013c:
                if (r4 == 0) goto L_0x0141
                r4.disconnect()
            L_0x0141:
                if (r6 == 0) goto L_0x0169
                r6.close()     // Catch:{ IOException -> 0x0147 }
                goto L_0x0169
            L_0x0147:
                r2 = move-exception
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                r4.append(r1)
                r4.append(r10)
                java.lang.String r10 = r4.toString()
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r0)
                r1.append(r2)
                java.lang.String r0 = r1.toString()
                net.imedicaldoctor.imd.iMDLogger.f(r10, r0)
            L_0x0169:
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.activationActivity.activationFragment.O2(java.lang.String):java.lang.String");
        }

        /* access modifiers changed from: private */
        public void c3() {
            if (r() != null) {
                try {
                    TextView textView = (TextView) r().findViewById(R.id.f1086status_label);
                    textView.setVisibility(0);
                    textView.setTextColor(SupportMenu.f5941c);
                } catch (Exception e2) {
                    FirebaseCrashlytics.d().g(e2);
                }
            }
        }

        private void e3() {
            try {
                ((ProgressBarCircularIndeterminate) r().findViewById(R.id.f1043progress_bar)).setVisibility(8);
            } catch (Exception e2) {
                FirebaseCrashlytics.d().g(e2);
            }
        }

        /* access modifiers changed from: private */
        public void f3() {
        }

        /* access modifiers changed from: private */
        public void g3() {
            try {
                InputMethodManager inputMethodManager = (InputMethodManager) r().getSystemService("input_method");
                if (r().getCurrentFocus() != null) {
                    inputMethodManager.hideSoftInputFromWindow(r().getCurrentFocus().getWindowToken(), 0);
                }
            } catch (Exception e2) {
                FirebaseCrashlytics.d().g(e2);
            }
        }

        private void h3(final View view, long j2) {
            view.animate().alpha(0.0f).setDuration(j2).setListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    view.setVisibility(8);
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }
            });
        }

        public static boolean i3(Context context) {
            return Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0;
        }

        public static boolean j3(Context context) {
            NetworkCapabilities networkCapabilities;
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 23) {
                Network a2 = connectivityManager.getActiveNetwork();
                if (a2 == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(a2)) == null) {
                    return false;
                }
                return networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(0);
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void k3(Context context) {
            context.startActivity(new Intent(context, mainActivity.class));
            V1().finish();
            V1().overridePendingTransition(R.anim.f15from_fade_in, R.anim.f16from_fade_out);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void l3(ResultWrapper resultWrapper, Context context) {
            String str;
            try {
                String str2 = resultWrapper.f30082a;
                if (str2 == null) {
                    w3("Error in contacting server. Please check your internet connection and tap here to try again");
                    v3();
                    return;
                }
                try {
                    String replace = str2.replace("|||||", ":::::");
                    resultWrapper.f30082a = replace;
                    String[] split = TextUtils.split(replace, ":::::");
                    if (!split[0].equals(IcyHeaders.a3) || split[0].length() != 1) {
                        if (split[0].equals("0")) {
                            v3();
                            str = split[1];
                        } else {
                            v3();
                            str = "Error in adding device";
                        }
                        w3(str);
                        return;
                    }
                    f3();
                    this.h4 = null;
                    this.i4.setText("Your Device Activated Successfully. Enjoy!");
                    context.getSharedPreferences("default_preferences", 0).edit().putString("ActivationCode", split[1]).apply();
                    activationActivity.z3.postDelayed(new e(this, context), ExoPlayer.a1);
                } catch (Exception unused) {
                    w3("Data error. Please try again.");
                }
            } catch (Exception e2) {
                w3("An unexpected error occurred. Please try again.");
                e2.printStackTrace();
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void m3(String str) {
            ResultWrapper resultWrapper = new ResultWrapper();
            String b2 = Devices.b();
            FragmentActivity V1 = V1();
            int i2 = 0;
            try {
                i2 = V1.getPackageManager().getPackageInfo(V1.getPackageName(), 0).versionCode;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                resultWrapper.f30082a = this.f4.j(O2("addDevice|||||" + str + "|||||" + this.f4.m() + "|||||" + Build.USER + "|||||" + b2 + "|||||android|||||" + d3() + "|||||android-" + i2), "127");
            } catch (Exception e3) {
                resultWrapper.f30082a = null;
                e3.printStackTrace();
            }
            activationActivity.z3.post(new g(this, resultWrapper, V1));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void n3(ResultWrapper resultWrapper) {
            try {
                String str = resultWrapper.f30082a;
                if (str == null) {
                    w3("Error in contacting server. Please check your internet connection and tap here to try again");
                    v3();
                    return;
                }
                try {
                    String replace = str.replace("|||||", ":::::");
                    resultWrapper.f30082a = replace;
                    String[] split = TextUtils.split(replace, ":::::");
                    if (split[0].equals(IcyHeaders.a3)) {
                        if (split[0].length() == 1) {
                            f3();
                            this.h4 = null;
                            this.i4.setText("Login Successful");
                            V1().getSharedPreferences("default_preferences", 0).edit().putString("Username", this.f4.n(this.j4.getText().toString(), "127")).putString("Password", this.f4.n(this.k4.getText().toString(), "127")).remove("DS").apply();
                            r3(split[1]);
                            return;
                        }
                    }
                    v3();
                    w3("Wrong Username or Password");
                    V1().getSharedPreferences("default_preferences", 0).edit().remove("Username").remove("Password").apply();
                } catch (Exception unused) {
                    w3("Data error. Please try again.");
                }
            } catch (Exception e2) {
                w3("An unexpected error occurred. Please try again.");
                e2.printStackTrace();
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void o3(String str) {
            ResultWrapper resultWrapper = new ResultWrapper();
            try {
                resultWrapper.f30082a = this.f4.j(O2(str), "127");
            } catch (Exception e2) {
                resultWrapper.f30082a = null;
                e2.printStackTrace();
            }
            activationActivity.z3.post(new f(this, resultWrapper));
        }

        /* access modifiers changed from: private */
        public void p3() {
            TextView textView = (TextView) r().findViewById(R.id.f1086status_label);
            textView.setVisibility(0);
            textView.setTextColor(-16711936);
        }

        /* access modifiers changed from: private */
        public void q3(String str) {
            D2(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        }

        private void r3(String str) {
            if (this.f4 == null || this.i4 == null) {
                w3("Application error. Please restart the app.");
            } else {
                activationActivity.y3.execute(new h(this, str));
            }
        }

        /* access modifiers changed from: private */
        public void t3(String str) {
            try {
                e3();
                if (str != null) {
                    this.i4.setText(str);
                    this.i4.setVisibility(0);
                    return;
                }
                this.i4.setText("");
                this.i4.setVisibility(8);
                this.h4 = str;
            } catch (Exception e2) {
                FirebaseCrashlytics.d().g(e2);
            }
        }

        /* access modifiers changed from: private */
        public void u3() {
            ProgressBarCircularIndeterminate progressBarCircularIndeterminate = (ProgressBarCircularIndeterminate) r().findViewById(R.id.f1043progress_bar);
            progressBarCircularIndeterminate.setBackgroundColor(Color.parseColor("#1e88e5"));
            progressBarCircularIndeterminate.setVisibility(0);
            this.i4.setVisibility(8);
        }

        private void v3() {
        }

        private void w3(String str) {
            e3();
            this.h4 = null;
            this.i4.setText(str);
            c3();
        }

        public View U0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View view = this.e4;
            if (view != null) {
                return view;
            }
            this.f4 = new VBHelper(r());
            this.e4 = layoutInflater.inflate(R.layout.f1250fragment_new_login, viewGroup, false);
            new Timer().schedule(new TimerTask() {
                public void run() {
                    if (activationFragment.this.h4 == null) {
                        int unused = activationFragment.this.g4 = 0;
                        return;
                    }
                    activationFragment activationfragment = activationFragment.this;
                    int unused2 = activationfragment.g4 = activationfragment.g4 + 1;
                    final String str = "";
                    for (int i2 = 0; i2 < activationFragment.this.g4; i2++) {
                        str = str + ".";
                    }
                    activationFragment.this.i4.post(new Runnable() {
                        public void run() {
                            TextView textView = (TextView) activationFragment.this.e4.findViewById(R.id.f1086status_label);
                            if (activationFragment.this.h4 != null) {
                                textView.setText(activationFragment.this.h4 + str);
                            }
                        }
                    });
                    if (activationFragment.this.g4 >= 3) {
                        int unused3 = activationFragment.this.g4 = 0;
                    }
                }
            }, 500, 500);
            ((TextView) this.e4.findViewById(R.id.f982imd_title)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    String l2 = new CompressHelper(activationFragment.this.r()).l2();
                    if (l2.length() <= 0) {
                        l2 = "No Message Available";
                    }
                    new AlertDialog.Builder(activationFragment.this.r(), R.style.f2185alertDialogTheme).l(l2).p("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    }).I();
                }
            });
            this.i4 = (TextView) this.e4.findViewById(R.id.f1086status_label);
            this.j4 = (EditText) this.e4.findViewById(R.id.f1156user_text);
            this.k4 = (EditText) this.e4.findViewById(R.id.f1039password_text);
            this.j4.setText(this.f4.j(V1().getSharedPreferences("default_preferences", 0).getString("Username", ""), "127"));
            this.k4.setText(this.f4.j(V1().getSharedPreferences("default_preferences", 0).getString("Password", ""), "127"));
            final CompressHelper compressHelper = new CompressHelper(r());
            ((LinearLayout) this.e4.findViewById(R.id.f1152upper_layout)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    activationFragment.this.g3();
                }
            });
            ((Button) this.e4.findViewById(R.id.f1003login_button)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (activationFragment.this.j4.getText().toString().length() < 1) {
                        activationFragment.this.c3();
                        activationFragment.this.t3("Please enter your Username");
                        return;
                    }
                    activationFragment.this.p3();
                    if (activationFragment.this.k4.getText().toString().length() < 1) {
                        activationFragment.this.c3();
                        activationFragment.this.t3("Please enter your Password");
                    } else if (activationFragment.i3(activationFragment.this.r())) {
                        activationFragment.this.c3();
                        activationFragment.this.t3("Please turn off Airplane Mode");
                    } else {
                        activationFragment.this.g3();
                        activationFragment.this.u3();
                        activationFragment.this.f3();
                        activationFragment.this.s3("checkUser|||||" + activationFragment.this.j4.getText().toString() + "|||||" + activationFragment.this.k4.getText().toString());
                    }
                }
            });
            ((TextView) this.e4.findViewById(R.id.f1056register_button)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    compressHelper.P("http://imedicaldoctor.net/buyaccount.php");
                }
            });
            final TextView textView = (TextView) this.e4.findViewById(R.id.f871change_server_button);
            textView.setText(V1().getSharedPreferences("default_preferences", 0).getString("MainServer", "Iran") + " Server (Tap to change)");
            textView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    activationFragment.this.V1().getSharedPreferences("default_preferences", 0).edit().putString("MainServer", activationFragment.this.V1().getSharedPreferences("default_preferences", 0).getString("MainServer", "Iran").equals("Iran") ? "Germany" : "Iran").commit();
                    TextView textView = textView;
                    textView.setText(activationFragment.this.V1().getSharedPreferences("default_preferences", 0).getString("MainServer", "Iran") + " Server (Tap to change)");
                }
            });
            TextView textView2 = (TextView) this.e4.findViewById(R.id.f945forgot_label);
            textView2.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    String l2 = compressHelper.l2();
                    if (l2.length() <= 0) {
                        return false;
                    }
                    new AlertDialog.Builder(activationFragment.this.r(), R.style.f2185alertDialogTheme).l(l2).p("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    }).I();
                    return false;
                }
            });
            textView2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    compressHelper.P("http://imedicaldoctor.net/forgot.php");
                }
            });
            ((ImageView) this.e4.findViewById(R.id.f1112telegram_button)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    activationFragment.this.q3("http://imedicaldoctor.net/telegramandroid.php");
                }
            });
            ((ImageView) this.e4.findViewById(R.id.f987instagram_button)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    activationFragment.this.q3("http://instagram.com/imedicaldoctor");
                }
            });
            ((ImageView) this.e4.findViewById(R.id.f1004mail_button)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    activationFragment.this.q3("mailto:support@imedicaldoctor.net");
                }
            });
            return this.e4;
        }

        public void V0() {
            super.V0();
            activationActivity.y3.shutdown();
        }

        public String d3() {
            String str = Build.VERSION.RELEASE;
            int i2 = Build.VERSION.SDK_INT;
            return "Android SDK: " + i2 + " (" + str + ")";
        }

        public void p1(View view, Bundle bundle) {
            super.p1(view, bundle);
            this.i4.setText("");
        }

        public void s3(String str) {
            if (this.f4 == null || this.j4 == null || this.k4 == null || this.i4 == null) {
                w3("Application error. Please restart the app.");
            } else {
                activationActivity.y3.execute(new d(this, str));
            }
        }
    }

    public static Bitmap d1(Context context, String str) {
        try {
            return BitmapFactory.decodeStream(context.getAssets().open(str));
        } catch (IOException unused) {
            return null;
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.f1166activity_activation);
        if (bundle == null) {
            k0().u().f(R.id.container, new activationFragment()).r();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        menuItem.getItemId();
        return super.onOptionsItemSelected(menuItem);
    }
}
