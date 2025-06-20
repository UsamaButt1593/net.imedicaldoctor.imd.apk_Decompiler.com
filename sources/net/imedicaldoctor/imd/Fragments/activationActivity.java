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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
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
    public static final ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
    /* access modifiers changed from: private */
    public static final Handler mainThreadHandler = new Handler(Looper.getMainLooper());



    public static class activationFragment extends Fragment {
        public View rootView;
        public VBHelper vbHelper;
        /* access modifiers changed from: private */
        public int g4 = 0;
        /* access modifiers changed from: private */
        public String h4;
        /* access modifiers changed from: private */
        public TextView textViewStatus;
        /* access modifiers changed from: private */
        public EditText editTextUsername;
        /* access modifiers changed from: private */
        public EditText editTextPassword;


        private static final String SERVER_ENDPOINT_PATH = "/imd.php";
        private static final int DEFAULT_READ_TIMEOUT_MS = 10000;
        private static final int DEFAULT_CONNECT_TIMEOUT_MS = 15000;
        private static final String PARAM_COMMAND = "command";

        private static class ResultWrapper {

            /* renamed from: a  reason: collision with root package name */
            String result;

            private ResultWrapper() {
            }
        }


        /**
         * Sends an encrypted command to the server and retrieves the response.
         *
         * @param command The raw command string to be encrypted and sent.
         * @return The server's response as a String, or null if an error occurs.
         */
        private String sendEncryptedCommandToServer(String command) {
            CompressHelper compressHelper = new CompressHelper(getActivity());

            HttpURLConnection urlConnection = null;
            try {
                String baseUrl = compressHelper.getBaseUrl();
                if (baseUrl == null || baseUrl.isEmpty()) {
                    return null;
                }

                URL serverUrl = new URL(baseUrl + SERVER_ENDPOINT_PATH);
                urlConnection = (HttpURLConnection) serverUrl.openConnection();
                urlConnection.setRequestMethod("POST");
                urlConnection.setReadTimeout(DEFAULT_READ_TIMEOUT_MS);
                urlConnection.setConnectTimeout(DEFAULT_CONNECT_TIMEOUT_MS);
                urlConnection.setDoInput(true);
                urlConnection.setDoOutput(true);

                String encryptedCommand = this.vbHelper.encodeActivationCodeToHex(command);
                if (encryptedCommand == null) {
                    return null;
                }

                String postData = PARAM_COMMAND + "=" + encryptedCommand;
                try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(urlConnection.getOutputStream(), StandardCharsets.UTF_8);
                     BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter)) {
                    bufferedWriter.write(postData);
                    bufferedWriter.flush();
                }

                int responseCode = urlConnection.getResponseCode();
                if (responseCode != HttpURLConnection.HTTP_OK) {
                    return null;
                }

                StringBuilder responseBuilder = new StringBuilder();
                try (InputStreamReader inputStreamReader = new InputStreamReader(urlConnection.getInputStream(), StandardCharsets.UTF_8);
                     BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        responseBuilder.append(line).append("\n");
                    }
                }

                return responseBuilder.toString();

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }
        }

        /* access modifiers changed from: private */
        public void showStatus() {
            try {
                TextView textView = (TextView) getActivity().findViewById(R.id.f1086status_label);
                textView.setVisibility(0);
                textView.setTextColor(SupportMenu.f5941c);
            } catch (Exception e2) {
                FirebaseCrashlytics.d().g(e2);
            }
        }

        private void hideProgressBar() {
            try {
                ((ProgressBarCircularIndeterminate) getActivity().findViewById(R.id.f1043progress_bar)).setVisibility(8);
            } catch (Exception e2) {
                FirebaseCrashlytics.d().g(e2);
            }
        }

        /* access modifiers changed from: private */
        public void hideKeyboard() {
            try {
                InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
                if (getActivity().getCurrentFocus() != null) {
                    inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
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

        public static boolean checkAirplaneMode(Context context) {
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
            getActivity().finish();
            getActivity().overridePendingTransition(R.anim.f15from_fade_in, R.anim.f16from_fade_out);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void onCommandResult(ResultWrapper resultWrapper, Context context) {
            String str;
            try {
                if (resultWrapper.result == null) {
                    w3("Error in contacting server. Please check your internet connection and tap here to try again");
                    return;
                }

                try {
                    resultWrapper.result = resultWrapper.result.replace("|||||", ":::::");
                    String[] split = TextUtils.split(resultWrapper.result, ":::::");
                    if (!split[0].equals("1")) {
                        if (split[0].equals("0")) {
                            str = split[1];
                        } else {
                            str = "Error in adding device";
                        }

                        w3(str);
                        return;
                    } else {
                        split[0].length();
                    }

                    f3();
                    this.h4 = null;
                    this.textViewStatus.setText("Your Device Activated Successfully. Enjoy!");

                    context.getSharedPreferences("default_preferences", 0).edit().putString("ActivationCode", split[1]).apply();
                    activationActivity.mainThreadHandler.postDelayed(new e(this, context), ExoPlayer.a1);
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
            FragmentActivity V1 = getActivity();
            int i2 = 0;
            try {
                i2 = V1.getPackageManager().getPackageInfo(V1.getPackageName(), 0).versionCode;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                resultWrapper.result = this.vbHelper.decryptHexEncodedStringForKey(sendEncryptedCommandToServer("addDevice|||||" + str + "|||||" + this.vbHelper.m() + "|||||" + Build.USER + "|||||" + b2 + "|||||android|||||" + d3() + "|||||android-" + i2));
            } catch (Exception e3) {
                resultWrapper.result = null;
                e3.printStackTrace();
            }

            activationActivity.mainThreadHandler.post(new Runnable() {
                @Override
                public void run() {
                     activationFragment.this.onCommandResult(resultWrapper, V1);
                }
            });
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void n3(ResultWrapper resultWrapper) {
            try {
                String str = resultWrapper.result;
                if (str == null) {
                    w3("Error in contacting server. Please check your internet connection and tap here to try again");
                    v3();
                    return;
                }
                try {
                    String replace = str.replace("|||||", ":::::");
                    resultWrapper.result = replace;
                    String[] split = TextUtils.split(replace, ":::::");
                    if (split[0].equals(IcyHeaders.a3)) {
                        if (split[0].length() == 1) {
                            f3();
                            this.h4 = null;
                            this.textViewStatus.setText("Login Successful");
                            getActivity().getSharedPreferences("default_preferences", 0).edit().putString("Username", this.vbHelper.encodeActivationCodeToHex(this.editTextUsername.getText().toString())).putString("Password", this.vbHelper.encodeActivationCodeToHex(this.editTextPassword.getText().toString(), "127")).remove("DS").apply();
                            r3(split[1]);
                            return;
                        }
                    }
                    v3();
                    w3("Wrong Username or Password");
                    getActivity().getSharedPreferences("default_preferences", 0).edit().remove("Username").remove("Password").apply();
                } catch (Exception unused) {
                    w3("Data error. Please try again.");
                }
            } catch (Exception e2) {
                w3("An unexpected error occurred. Please try again.");
                e2.printStackTrace();
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void onCommandRun(String command) {
            ResultWrapper resultWrapper = new ResultWrapper();
            try {
                resultWrapper.result = this.vbHelper.decryptHexEncodedStringForKey(sendEncryptedCommandToServer(command));
            } catch (Exception e2) {
                resultWrapper.result = null;
                e2.printStackTrace();
            }
            activationActivity.mainThreadHandler.post(new f(this, resultWrapper));
        }

        /* access modifiers changed from: private */
        public void changeStatusLabelColor() {
            TextView textView = (TextView) getActivity().findViewById(R.id.f1086status_label);
            textView.setVisibility(0);
            textView.setTextColor(-16711936);
        }

        /* access modifiers changed from: private */
        public void q3(String str) {
            D2(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        }

        private void r3(String str) {
            if (this.vbHelper == null || this.textViewStatus == null) {
                w3("Application error. Please restart the app.");
            } else {
                activationActivity.singleThreadExecutor.execute(new h(this, str));
            }
        }

        /* access modifiers changed from: private */
        public void setAndShowStatusText(String str) {
            try {
                hideProgressBar();
                if (str != null) {
                    this.textViewStatus.setText(str);
                    this.textViewStatus.setVisibility(0);
                    return;
                }
                this.textViewStatus.setText("");
                this.textViewStatus.setVisibility(8);
                this.h4 = null;
            } catch (Exception e2) {
                FirebaseCrashlytics.d().g(e2);
            }
        }

        /* access modifiers changed from: private */
        public void showProgressBar() {
            ProgressBarCircularIndeterminate progressBarCircularIndeterminate = (ProgressBarCircularIndeterminate) getActivity().findViewById(R.id.f1043progress_bar);
            progressBarCircularIndeterminate.setBackgroundColor(Color.parseColor("#1e88e5"));
            progressBarCircularIndeterminate.setVisibility(0);
            this.textViewStatus.setVisibility(8);
        }

        private void v3() {
        }

        private void w3(String str) {
            hideProgressBar();
            this.h4 = null;
            this.textViewStatus.setText(str);
            showStatus();
        }

        public View onFragmentBind(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View view = this.rootView;
            if (view != null) {
                return view;
            }
            this.vbHelper = new VBHelper(r());
            this.rootView = layoutInflater.inflate(R.layout.f1250fragment_new_login, viewGroup, false);
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
                    activationFragment.this.textViewStatus.post(new Runnable() {
                        public void run() {
                            TextView textView = (TextView) activationFragment.this.rootView.findViewById(R.id.f1086status_label);
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
            ((TextView) this.rootView.findViewById(R.id.f982imd_title)).setOnClickListener(new View.OnClickListener() {
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
            this.textViewStatus = (TextView) this.rootView.findViewById(R.id.f1086status_label);
            this.editTextUsername = (EditText) this.rootView.findViewById(R.id.f1156user_text);
            this.editTextPassword = (EditText) this.rootView.findViewById(R.id.f1039password_text);

            this.editTextUsername.setText(this.vbHelper.decryptHexEncodedStringForKey(getActivity().getSharedPreferences("default_preferences", 0).getString("Username", "")));
            this.editTextPassword.setText(this.vbHelper.decryptHexEncodedStringForKey(getActivity().getSharedPreferences("default_preferences", 0).getString("Password", "")));

            final CompressHelper compressHelper = new CompressHelper(getActivity());

            ((LinearLayout) this.rootView.findViewById(R.id.f1152upper_layout)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    activationFragment.this.hideKeyboard();
                }
            });

            ((Button) this.rootView.findViewById(R.id.f1003login_button)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (activationFragment.this.editTextUsername.getText().toString().isEmpty()) {
                        activationFragment.this.showStatus();
                        activationFragment.this.setAndShowStatusText("Please enter your Username");
                        return;
                    }

                    activationFragment.this.changeStatusLabelColor();

                    if (activationFragment.this.editTextPassword.getText().toString().isEmpty()) {
                        activationFragment.this.showStatus();
                        activationFragment.this.setAndShowStatusText("Please enter your Password");
                    } else if (activationFragment.checkAirplaneMode(activationFragment.this.getActivity())) {
                        activationFragment.this.showStatus();
                        activationFragment.this.setAndShowStatusText("Please turn off Airplane Mode");
                    } else {
                        activationFragment.this.hideKeyboard();
                        activationFragment.this.showProgressBar();
                        activationFragment.this.executeCommand("checkUser|||||" + activationFragment.this.editTextUsername.getText().toString() + "|||||" + activationFragment.this.editTextPassword.getText().toString());
                    }
                }
            });

            ((TextView) this.rootView.findViewById(R.id.f1056register_button)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    compressHelper.P("http://imedicaldoctor.net/buyaccount.php");
                }
            });
            final TextView textView = (TextView) this.rootView.findViewById(R.id.f871change_server_button);
            textView.setText(getActivity().getSharedPreferences("default_preferences", 0).getString("MainServer", "Iran") + " Server (Tap to change)");
            textView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    activationFragment.this.getActivity().getSharedPreferences("default_preferences", 0).edit().putString("MainServer", activationFragment.this.getActivity().getSharedPreferences("default_preferences", 0).getString("MainServer", "Iran").equals("Iran") ? "Germany" : "Iran").commit();
                    TextView textView = textView;
                    textView.setText(activationFragment.this.getActivity().getSharedPreferences("default_preferences", 0).getString("MainServer", "Iran") + " Server (Tap to change)");
                }
            });
            TextView textView2 = (TextView) this.rootView.findViewById(R.id.f945forgot_label);
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
            ((ImageView) this.rootView.findViewById(R.id.f1112telegram_button)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    activationFragment.this.q3("http://imedicaldoctor.net/telegramandroid.php");
                }
            });
            ((ImageView) this.rootView.findViewById(R.id.f987instagram_button)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    activationFragment.this.q3("http://instagram.com/imedicaldoctor");
                }
            });
            ((ImageView) this.rootView.findViewById(R.id.f1004mail_button)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    activationFragment.this.q3("mailto:support@imedicaldoctor.net");
                }
            });
            return this.rootView;
        }

        public void onDestroy() {
            super.onDestroy();
            activationActivity.singleThreadExecutor.shutdown();
        }

        public String d3() {
            String str = Build.VERSION.RELEASE;
            int i2 = Build.VERSION.SDK_INT;
            return "Android SDK: " + i2 + " (" + str + ")";
        }

        public void onFragmentCreated(View view, Bundle bundle) {
            super.onFragmentCreated(view, bundle);
            this.textViewStatus.setText("");
        }

        public void executeCommand(String command) {
            if (this.vbHelper == null || this.editTextUsername == null || this.editTextPassword == null || this.textViewStatus == null) {
                w3("Application error. Please restart the app.");
            } else {
                activationActivity.singleThreadExecutor.execute(new Runnable() {
                    @Override
                    public void run() {
                        activationFragment.this.onCommandRun(command);
                    }
                });
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
