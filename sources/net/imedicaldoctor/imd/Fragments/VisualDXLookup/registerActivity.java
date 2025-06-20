package net.imedicaldoctor.imd.Fragments.VisualDXLookup;

import android.animation.Animator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.payActivity;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Views.ProgressBarCircularIndeterminate;
import net.imedicaldoctor.imd.iMDActivity;
import org.apache.commons.lang3.StringUtils;

public class registerActivity extends iMDActivity {

    public static class registerFragment extends Fragment {
        private final int e4 = 0;
        private String f4;
        /* access modifiers changed from: private */
        public TextView g4;
        /* access modifiers changed from: private */
        public View h4;
        public BroadcastReceiver i4 = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                if (intent.getIntExtra("result", 0) == 1) {
                    registerFragment.this.Y2();
                    registerFragment.this.b3("Successsful . Login Now");
                    new Timer().schedule(new TimerTask() {
                        public void run() {
                            registerFragment.this.g4.post(new Runnable() {
                                public void run() {
                                    registerFragment.this.r().finish();
                                }
                            });
                        }
                    }, 1000);
                    return;
                }
                registerFragment.this.S2();
                registerFragment registerfragment = registerFragment.this;
                registerfragment.b3("Failed . " + intent.getStringExtra("message"));
            }
        };

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.lang.String} */
        /* JADX WARNING: type inference failed for: r4v2 */
        /* JADX WARNING: type inference failed for: r4v3, types: [java.net.HttpURLConnection] */
        /* JADX WARNING: type inference failed for: r4v6 */
        /* JADX WARNING: type inference failed for: r4v7 */
        /* JADX WARNING: type inference failed for: r4v9 */
        /* JADX WARNING: type inference failed for: r4v10 */
        /* JADX WARNING: type inference failed for: r4v11 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x011c  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0121 A[SYNTHETIC, Splitter:B:34:0x0121] */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x013d  */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x0145  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x014a A[SYNTHETIC, Splitter:B:44:0x014a] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private java.lang.String J2(java.lang.String r10) {
            /*
                r9 = this;
                java.lang.String r0 = "Error closing stream "
                java.lang.String r1 = "Sendcommand"
                net.imedicaldoctor.imd.Data.CompressHelper r2 = new net.imedicaldoctor.imd.Data.CompressHelper
                androidx.fragment.app.FragmentActivity r3 = r9.r()
                r2.<init>(r3)
                net.imedicaldoctor.imd.VBHelper r3 = new net.imedicaldoctor.imd.VBHelper
                androidx.fragment.app.FragmentActivity r4 = r9.r()
                r3.<init>(r4)
                java.lang.String r4 = "127"
                java.lang.String r3 = r3.n(r10, r4)
                r4 = 0
                java.net.URL r5 = new java.net.URL     // Catch:{ IOException -> 0x00f2, all -> 0x00ef }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00f2, all -> 0x00ef }
                r6.<init>()     // Catch:{ IOException -> 0x00f2, all -> 0x00ef }
                java.lang.String r2 = r2.J()     // Catch:{ IOException -> 0x00f2, all -> 0x00ef }
                r6.append(r2)     // Catch:{ IOException -> 0x00f2, all -> 0x00ef }
                java.lang.String r2 = "/imd.php"
                r6.append(r2)     // Catch:{ IOException -> 0x00f2, all -> 0x00ef }
                java.lang.String r2 = r6.toString()     // Catch:{ IOException -> 0x00f2, all -> 0x00ef }
                r5.<init>(r2)     // Catch:{ IOException -> 0x00f2, all -> 0x00ef }
                java.net.URLConnection r2 = r5.openConnection()     // Catch:{ IOException -> 0x00f2, all -> 0x00ef }
                java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IOException -> 0x00f2, all -> 0x00ef }
                java.lang.String r5 = "POST"
                r2.setRequestMethod(r5)     // Catch:{ IOException -> 0x00ec, all -> 0x00e9 }
                r5 = 10000(0x2710, float:1.4013E-41)
                r2.setReadTimeout(r5)     // Catch:{ IOException -> 0x00ec, all -> 0x00e9 }
                r5 = 15000(0x3a98, float:2.102E-41)
                r2.setConnectTimeout(r5)     // Catch:{ IOException -> 0x00ec, all -> 0x00e9 }
                r5 = 1
                r2.setDoInput(r5)     // Catch:{ IOException -> 0x00ec, all -> 0x00e9 }
                r2.setDoOutput(r5)     // Catch:{ IOException -> 0x00ec, all -> 0x00e9 }
                java.io.OutputStream r5 = r2.getOutputStream()     // Catch:{ IOException -> 0x00ec, all -> 0x00e9 }
                java.io.BufferedWriter r6 = new java.io.BufferedWriter     // Catch:{ IOException -> 0x00ec, all -> 0x00e9 }
                java.io.OutputStreamWriter r7 = new java.io.OutputStreamWriter     // Catch:{ IOException -> 0x00ec, all -> 0x00e9 }
                java.nio.charset.Charset r8 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x00ec, all -> 0x00e9 }
                r7.<init>(r5, r8)     // Catch:{ IOException -> 0x00ec, all -> 0x00e9 }
                r6.<init>(r7)     // Catch:{ IOException -> 0x00ec, all -> 0x00e9 }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00ec, all -> 0x00e9 }
                r7.<init>()     // Catch:{ IOException -> 0x00ec, all -> 0x00e9 }
                java.lang.String r8 = "command="
                r7.append(r8)     // Catch:{ IOException -> 0x00ec, all -> 0x00e9 }
                r7.append(r3)     // Catch:{ IOException -> 0x00ec, all -> 0x00e9 }
                java.lang.String r3 = r7.toString()     // Catch:{ IOException -> 0x00ec, all -> 0x00e9 }
                r6.write(r3)     // Catch:{ IOException -> 0x00ec, all -> 0x00e9 }
                r6.flush()     // Catch:{ IOException -> 0x00ec, all -> 0x00e9 }
                r6.close()     // Catch:{ IOException -> 0x00ec, all -> 0x00e9 }
                r5.close()     // Catch:{ IOException -> 0x00ec, all -> 0x00e9 }
                r2.connect()     // Catch:{ IOException -> 0x00ec, all -> 0x00e9 }
                java.io.InputStream r3 = r2.getInputStream()     // Catch:{ IOException -> 0x00ec, all -> 0x00e9 }
                java.lang.StringBuffer r5 = new java.lang.StringBuffer     // Catch:{ IOException -> 0x00ec, all -> 0x00e9 }
                r5.<init>()     // Catch:{ IOException -> 0x00ec, all -> 0x00e9 }
                java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00ec, all -> 0x00e9 }
                java.io.InputStreamReader r7 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00ec, all -> 0x00e9 }
                r7.<init>(r3)     // Catch:{ IOException -> 0x00ec, all -> 0x00e9 }
                r6.<init>(r7)     // Catch:{ IOException -> 0x00ec, all -> 0x00e9 }
            L_0x0096:
                java.lang.String r3 = r6.readLine()     // Catch:{ IOException -> 0x00b5 }
                if (r3 == 0) goto L_0x00b7
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00b5 }
                r7.<init>()     // Catch:{ IOException -> 0x00b5 }
                r7.append(r3)     // Catch:{ IOException -> 0x00b5 }
                java.lang.String r3 = "\n"
                r7.append(r3)     // Catch:{ IOException -> 0x00b5 }
                java.lang.String r3 = r7.toString()     // Catch:{ IOException -> 0x00b5 }
                r5.append(r3)     // Catch:{ IOException -> 0x00b5 }
                goto L_0x0096
            L_0x00b1:
                r3 = move-exception
            L_0x00b2:
                r4 = r2
                goto L_0x0143
            L_0x00b5:
                r3 = move-exception
                goto L_0x00f5
            L_0x00b7:
                r5.length()     // Catch:{ IOException -> 0x00b5 }
                java.lang.String r4 = r5.toString()     // Catch:{ IOException -> 0x00b5 }
                r2.disconnect()
                r6.close()     // Catch:{ IOException -> 0x00c6 }
                goto L_0x013b
            L_0x00c6:
                r2 = move-exception
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r1)
                r3.append(r10)
                java.lang.String r10 = r3.toString()
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
            L_0x00db:
                r1.append(r0)
                r1.append(r2)
                java.lang.String r0 = r1.toString()
                net.imedicaldoctor.imd.iMDLogger.f(r10, r0)
                goto L_0x013b
            L_0x00e9:
                r3 = move-exception
                r6 = r4
                goto L_0x00b2
            L_0x00ec:
                r3 = move-exception
                r6 = r4
                goto L_0x00f5
            L_0x00ef:
                r3 = move-exception
                r6 = r4
                goto L_0x0143
            L_0x00f2:
                r3 = move-exception
                r2 = r4
                r6 = r2
            L_0x00f5:
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b1 }
                r5.<init>()     // Catch:{ all -> 0x00b1 }
                java.lang.String r7 = "Sendcommand "
                r5.append(r7)     // Catch:{ all -> 0x00b1 }
                r5.append(r10)     // Catch:{ all -> 0x00b1 }
                java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00b1 }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b1 }
                r7.<init>()     // Catch:{ all -> 0x00b1 }
                java.lang.String r8 = "Error in "
                r7.append(r8)     // Catch:{ all -> 0x00b1 }
                r7.append(r3)     // Catch:{ all -> 0x00b1 }
                java.lang.String r3 = r7.toString()     // Catch:{ all -> 0x00b1 }
                net.imedicaldoctor.imd.iMDLogger.f(r5, r3)     // Catch:{ all -> 0x00b1 }
                if (r2 == 0) goto L_0x011f
                r2.disconnect()
            L_0x011f:
                if (r6 == 0) goto L_0x013b
                r6.close()     // Catch:{ IOException -> 0x0125 }
                goto L_0x013b
            L_0x0125:
                r2 = move-exception
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r1)
                r3.append(r10)
                java.lang.String r10 = r3.toString()
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                goto L_0x00db
            L_0x013b:
                if (r4 == 0) goto L_0x0142
                java.lang.String r10 = "Sendcommand result"
                net.imedicaldoctor.imd.iMDLogger.j(r10, r4)
            L_0x0142:
                return r4
            L_0x0143:
                if (r4 == 0) goto L_0x0148
                r4.disconnect()
            L_0x0148:
                if (r6 == 0) goto L_0x0170
                r6.close()     // Catch:{ IOException -> 0x014e }
                goto L_0x0170
            L_0x014e:
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
            L_0x0170:
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.VisualDXLookup.registerActivity.registerFragment.J2(java.lang.String):java.lang.String");
        }

        /* access modifiers changed from: private */
        public void S2() {
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

        /* access modifiers changed from: private */
        public String T2(int i2) {
            return ((EditText) this.h4.findViewById(i2)).getText().toString();
        }

        private void U2() {
            ((ProgressBarCircularIndeterminate) r().findViewById(R.id.f1043progress_bar)).setVisibility(8);
        }

        private void V2() {
        }

        /* access modifiers changed from: private */
        public void W2() {
            try {
                InputMethodManager inputMethodManager = (InputMethodManager) r().getSystemService("input_method");
                if (r().getCurrentFocus() != null) {
                    inputMethodManager.hideSoftInputFromWindow(r().getCurrentFocus().getWindowToken(), 0);
                }
            } catch (Exception e2) {
                FirebaseCrashlytics.d().g(e2);
            }
        }

        private void X2(final View view, long j2) {
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

        /* access modifiers changed from: private */
        public void Y2() {
            TextView textView = (TextView) r().findViewById(R.id.f1086status_label);
            textView.setVisibility(0);
            textView.setTextColor(-16711936);
        }

        private void Z2(String str) {
            D2(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        }

        /* access modifiers changed from: private */
        public void b3(String str) {
            U2();
            TextView textView = this.g4;
            if (str != null) {
                textView.setText(str);
                this.g4.setVisibility(0);
                return;
            }
            textView.setText("");
            this.g4.setVisibility(8);
            this.f4 = str;
        }

        /* access modifiers changed from: private */
        public void c3() {
            ProgressBarCircularIndeterminate progressBarCircularIndeterminate = (ProgressBarCircularIndeterminate) r().findViewById(R.id.f1043progress_bar);
            progressBarCircularIndeterminate.setVisibility(0);
            progressBarCircularIndeterminate.setBackgroundColor(Color.parseColor("#1e88e5"));
            this.g4.setVisibility(8);
        }

        private void d3() {
        }

        private void e3(String str) {
            U2();
            this.g4.setVisibility(0);
            this.f4 = null;
            this.g4.setText(str);
            S2();
        }

        public void L0(int i2, int i3, Intent intent) {
            if (intent != null) {
                if (intent.getIntExtra("result", 0) == 1) {
                    Y2();
                    b3("Successsful . Login Now");
                    new Timer().schedule(new TimerTask() {
                        public void run() {
                            registerFragment.this.g4.post(new Runnable() {
                                public void run() {
                                    registerFragment.this.r().finish();
                                    registerFragment.this.r().overridePendingTransition(R.anim.f23to_fade_in, R.anim.f24to_fade_out);
                                }
                            });
                        }
                    }, ExoPlayer.a1);
                } else {
                    S2();
                    b3("Failed . " + intent.getStringExtra("message"));
                }
                super.L0(i2, i3, intent);
            }
        }

        public void Q0(Bundle bundle) {
            super.Q0(bundle);
        }

        public View onFragmentBind(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View view = this.h4;
            if (view != null) {
                return view;
            }
            View inflate = layoutInflater.inflate(R.layout.f1251fragment_new_register, viewGroup, false);
            this.h4 = inflate;
            this.g4 = (TextView) inflate.findViewById(R.id.f1086status_label);
            final CompressHelper compressHelper = new CompressHelper(r());
            RadioGroup radioGroup = (RadioGroup) this.h4.findViewById(R.id.f1052radio_group);
            radioGroup.check(R.id.f1049radio_1);
            a3();
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                public void onCheckedChanged(RadioGroup radioGroup, int i2) {
                    registerFragment.this.a3();
                }
            });
            ((Button) inflate.findViewById(R.id.f1056register_button)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    final String str;
                    String str2;
                    registerFragment.this.W2();
                    final String L2 = registerFragment.this.T2(R.id.f1156user_text);
                    final String L22 = registerFragment.this.T2(R.id.f1039password_text);
                    final String L23 = registerFragment.this.T2(R.id.f1005mail_text);
                    final String L24 = registerFragment.this.T2(R.id.f1012mobile_text);
                    if (L2.length() == 0) {
                        registerFragment.this.S2();
                        registerFragment.this.b3("Username can't be empty");
                    } else if (L22.length() == 0) {
                        registerFragment.this.S2();
                        registerFragment.this.b3("Password can't be empty");
                    } else if (L23.length() == 0) {
                        registerFragment.this.S2();
                        registerFragment.this.b3("Mail can't be empty");
                    } else if (L24.length() == 0) {
                        registerFragment.this.S2();
                        registerFragment.this.b3("Mobile can't be empty");
                    } else {
                        int checkedRadioButtonId = ((RadioGroup) registerFragment.this.h4.findViewById(R.id.f1052radio_group)).getCheckedRadioButtonId();
                        if (checkedRadioButtonId != R.id.f1049radio_1) {
                            if (checkedRadioButtonId == R.id.f1050radio_2) {
                                str2 = IcyHeaders.a3;
                            } else if (checkedRadioButtonId == R.id.f1051radio_3) {
                                str2 = ExifInterface.Y4;
                            }
                            str = str2;
                            registerFragment.this.Y2();
                            registerFragment.this.c3();
                            CompressHelper compressHelper = compressHelper;
                            compressHelper.o0("checkRegister|||||" + L2 + "|||||" + L22 + "|||||" + L23 + "|||||" + L24).h6(Schedulers.e()).s4(AndroidSchedulers.e()).e6(new Consumer<String>() {
                                /* renamed from: a */
                                public void accept(String str) throws Throwable {
                                    registerFragment registerfragment;
                                    String str2;
                                    String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(str, "|||||");
                                    if (splitByWholeSeparator[0].equals(IcyHeaders.a3)) {
                                        registerFragment.this.Y2();
                                        registerFragment.this.b3("Successfull , Redirecting ...");
                                        Intent intent = new Intent(registerFragment.this.r(), payActivity.class);
                                        intent.putExtra("AccountCommand", L2 + "|||||" + L22 + "|||||" + L23 + "|||||" + L24 + "|||||" + str);
                                        intent.putExtra("Type", "account");
                                        registerFragment.this.startActivityForResult(intent, 1);
                                        registerFragment.this.r().overridePendingTransition(R.anim.f15from_fade_in, R.anim.f16from_fade_out);
                                        return;
                                    }
                                    if (splitByWholeSeparator.length == 1) {
                                        registerFragment.this.S2();
                                        registerfragment = registerFragment.this;
                                        str2 = splitByWholeSeparator[0];
                                    } else {
                                        registerFragment.this.S2();
                                        registerfragment = registerFragment.this;
                                        str2 = splitByWholeSeparator[1];
                                    }
                                    registerfragment.b3(str2);
                                }
                            }, new Consumer<Throwable>() {
                                /* renamed from: a */
                                public void accept(Throwable th) throws Throwable {
                                    try {
                                        CompressHelper.x2(registerFragment.this.r(), "Error occured on contacting server, try again later.", 1);
                                        registerFragment.this.S2();
                                        registerFragment.this.b3("Error occured");
                                    } catch (Exception e2) {
                                        FirebaseCrashlytics.d().g(e2);
                                    }
                                }
                            });
                        }
                        str = "0";
                        registerFragment.this.Y2();
                        registerFragment.this.c3();
                        CompressHelper compressHelper2 = compressHelper;
                        compressHelper2.o0("checkRegister|||||" + L2 + "|||||" + L22 + "|||||" + L23 + "|||||" + L24).h6(Schedulers.e()).s4(AndroidSchedulers.e()).e6(new Consumer<String>() {
                            /* renamed from: a */
                            public void accept(String str) throws Throwable {
                                registerFragment registerfragment;
                                String str2;
                                String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(str, "|||||");
                                if (splitByWholeSeparator[0].equals(IcyHeaders.a3)) {
                                    registerFragment.this.Y2();
                                    registerFragment.this.b3("Successfull , Redirecting ...");
                                    Intent intent = new Intent(registerFragment.this.r(), payActivity.class);
                                    intent.putExtra("AccountCommand", L2 + "|||||" + L22 + "|||||" + L23 + "|||||" + L24 + "|||||" + str);
                                    intent.putExtra("Type", "account");
                                    registerFragment.this.startActivityForResult(intent, 1);
                                    registerFragment.this.r().overridePendingTransition(R.anim.f15from_fade_in, R.anim.f16from_fade_out);
                                    return;
                                }
                                if (splitByWholeSeparator.length == 1) {
                                    registerFragment.this.S2();
                                    registerfragment = registerFragment.this;
                                    str2 = splitByWholeSeparator[0];
                                } else {
                                    registerFragment.this.S2();
                                    registerfragment = registerFragment.this;
                                    str2 = splitByWholeSeparator[1];
                                }
                                registerfragment.b3(str2);
                            }
                        }, new Consumer<Throwable>() {
                            /* renamed from: a */
                            public void accept(Throwable th) throws Throwable {
                                try {
                                    CompressHelper.x2(registerFragment.this.r(), "Error occured on contacting server, try again later.", 1);
                                    registerFragment.this.S2();
                                    registerFragment.this.b3("Error occured");
                                } catch (Exception e2) {
                                    FirebaseCrashlytics.d().g(e2);
                                }
                            }
                        });
                    }
                }
            });
            return inflate;
        }

        public void onDestroy() {
            super.onDestroy();
        }

        public void a3() {
            String str;
            Button button = (Button) this.h4.findViewById(R.id.f1056register_button);
            int checkedRadioButtonId = ((RadioGroup) this.h4.findViewById(R.id.f1052radio_group)).getCheckedRadioButtonId();
            RadioButton radioButton = (RadioButton) this.h4.findViewById(R.id.f1049radio_1);
            RadioButton radioButton2 = (RadioButton) this.h4.findViewById(R.id.f1050radio_2);
            RadioButton radioButton3 = (RadioButton) this.h4.findViewById(R.id.f1051radio_3);
            if (checkedRadioButtonId == R.id.f1049radio_1) {
                button.setText("Register - 10,000 Toman");
                radioButton2.setChecked(false);
                radioButton3.setChecked(false);
                return;
            }
            if (checkedRadioButtonId == R.id.f1050radio_2) {
                str = "Register - 17,000 Toman";
            } else if (checkedRadioButtonId == R.id.f1051radio_3) {
                str = "Register - 249,000 Toman";
            } else {
                return;
            }
            button.setText(str);
        }

        public void onFragmentCreated(View view, Bundle bundle) {
            super.onFragmentCreated(view, bundle);
        }
    }

    public static Bitmap b1(Context context, String str) {
        try {
            return BitmapFactory.decodeStream(context.getAssets().open(str));
        } catch (IOException unused) {
            return null;
        }
    }

    public void c1(ColorStateList colorStateList) {
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.f1186activity_register);
        if (bundle == null) {
            k0().u().o("register").f(R.id.container, new registerFragment()).r();
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
