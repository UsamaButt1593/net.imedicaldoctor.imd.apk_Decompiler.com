package net.imedicaldoctor.imd.Fragments;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.VBHelper;
import net.imedicaldoctor.imd.iMDLogger;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.io.inputstream.ZipInputStream;
import net.lingala.zip4j.model.FileHeader;
import okio.BufferedSink;
import okio.Okio;
import org.apache.commons.lang3.StringUtils;

public class InstallingFragment extends DialogFragment {
    private Bundle F4;
    private String G4;
    /* access modifiers changed from: private */
    public TextView H4;
    /* access modifiers changed from: private */
    public TextView I4;
    /* access modifiers changed from: private */
    public ProgressBar J4;
    /* access modifiers changed from: private */
    public TextView K4;
    private ImageView L4;
    private View M4;
    /* access modifiers changed from: private */
    public Timer N4;
    /* access modifiers changed from: private */
    public int O4;
    private Activity P4;
    /* access modifiers changed from: private */
    public boolean Q4;
    private Button R4;
    private Button S4;
    /* access modifiers changed from: private */
    public String T4;
    public Handler U4 = new Handler() {
        public void handleMessage(Message message) {
            InstallingFragment installingFragment = InstallingFragment.this;
            int unused = installingFragment.O4 = installingFragment.O4 + 1;
            if (InstallingFragment.this.O4 == 7) {
                int unused2 = InstallingFragment.this.O4 = 1;
            }
            String str = "";
            for (int i2 = 0; i2 < InstallingFragment.this.O4; i2++) {
                str = str + ".";
            }
            InstallingFragment.this.K4.setText(str);
        }
    };

    /* access modifiers changed from: private */
    public void g3() {
        this.Q4 = true;
        do {
        } while (this.Q4);
    }

    /* access modifiers changed from: private */
    public void y3(File file) {
        try {
            if (file.isDirectory()) {
                if (!file.canRead() || !file.canWrite() || !file.canExecute()) {
                    file.setReadable(true, false);
                    file.setWritable(true, false);
                    file.setExecutable(true, false);
                }
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File y3 : listFiles) {
                        y3(y3);
                    }
                }
            } else if (!file.canRead() || !file.canWrite()) {
                file.setReadable(true, false);
                file.setWritable(true, false);
            }
        } catch (Exception unused) {
        }
    }

    public void M0(Activity activity) {
        super.M0(activity);
        this.P4 = activity;
    }

    public Dialog U2(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(r());
        View inflate = r().getLayoutInflater().inflate(R.layout.f1236fragment_installing, (ViewGroup) null);
        this.M4 = inflate;
        this.H4 = (TextView) inflate.findViewById(R.id.f988installing_label);
        this.I4 = (TextView) this.M4.findViewById(R.id.f894database_name);
        this.K4 = (TextView) this.M4.findViewById(R.id.f1044progress_label);
        this.J4 = (ProgressBar) this.M4.findViewById(R.id.f1043progress_bar);
        this.L4 = (ImageView) this.M4.findViewById(R.id.f1088stethoscope);
        this.R4 = (Button) this.M4.findViewById(R.id.cancel_button);
        this.S4 = (Button) this.M4.findViewById(R.id.f881close_button);
        Typeface createFromAsset = Typeface.createFromAsset(r().getAssets(), "fonts/HelveticaNeue-Light.otf");
        this.H4.setTypeface(createFromAsset);
        this.I4.setTypeface(createFromAsset);
        this.J4.setProgress(0);
        r().setFinishOnTouchOutside(false);
        final CompressHelper compressHelper = new CompressHelper(r());
        final VBHelper vBHelper = new VBHelper(r());
        Observable s4 = Observable.w1(new ObservableOnSubscribe<Bundle>() {
            /* JADX WARNING: Code restructure failed: missing block: B:27:0x00fc, code lost:
                r2 = 1;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void a(@io.reactivex.rxjava3.annotations.NonNull io.reactivex.rxjava3.core.ObservableEmitter<android.os.Bundle> r47) throws java.lang.Throwable {
                /*
                    r46 = this;
                    r1 = r46
                    r2 = r47
                    java.lang.String r3 = ".zipp"
                    java.lang.String r4 = ".zip"
                    java.lang.String r6 = ""
                    java.lang.String r7 = " In "
                    java.lang.String r8 = "Executing SQLs"
                    java.lang.String r9 = "%.2f"
                    java.lang.String r12 = ", Delta From Version : "
                    java.lang.String r13 = "Versions don't match. DBVersion : "
                    java.lang.String r14 = "Folder"
                    java.lang.String r15 = "progress"
                    java.lang.String r5 = "From"
                    java.lang.String r10 = "Version"
                    java.lang.String r11 = "update.vbe"
                    net.imedicaldoctor.imd.Data.CompressHelper r0 = r1
                    java.util.HashSet r0 = r0.o1()
                    r16 = r3
                    java.util.ArrayList r3 = new java.util.ArrayList
                    r3.<init>()
                    r17 = r4
                    java.util.ArrayList r4 = new java.util.ArrayList
                    r4.<init>()
                    java.util.Iterator r0 = r0.iterator()
                L_0x0036:
                    boolean r18 = r0.hasNext()
                    r19 = r6
                    java.lang.String r6 = ".zipp.1"
                    r20 = r8
                    java.lang.String r8 = ".zip.1"
                    r21 = r7
                    java.lang.String r7 = "/"
                    if (r18 == 0) goto L_0x0133
                    java.lang.Object r18 = r0.next()
                    r22 = r0
                    r0 = r18
                    java.lang.String r0 = (java.lang.String) r0
                    r18 = r15
                    java.io.File r15 = new java.io.File
                    r15.<init>(r0)
                    r23 = r9
                    net.imedicaldoctor.imd.Fragments.InstallingFragment$1$1 r9 = new net.imedicaldoctor.imd.Fragments.InstallingFragment$1$1
                    r9.<init>()
                    java.lang.String[] r9 = r15.list(r9)
                    r24 = r12
                    if (r9 == 0) goto L_0x007d
                    int r12 = r9.length
                    r25 = r13
                    if (r12 != 0) goto L_0x006e
                    goto L_0x007f
                L_0x006e:
                    r12 = 0
                L_0x006f:
                    int r13 = r9.length
                    if (r12 >= r13) goto L_0x007f
                    r13 = r9[r12]
                    r3.add(r13)
                    r4.add(r0)
                    r13 = 1
                    int r12 = r12 + r13
                    goto L_0x006f
                L_0x007d:
                    r25 = r13
                L_0x007f:
                    net.imedicaldoctor.imd.Fragments.InstallingFragment$1$2 r9 = new net.imedicaldoctor.imd.Fragments.InstallingFragment$1$2
                    r9.<init>()
                    java.lang.String[] r9 = r15.list(r9)
                    if (r9 == 0) goto L_0x008d
                    int r12 = r9.length
                    if (r12 != 0) goto L_0x0093
                L_0x008d:
                    r26 = r5
                    r27 = r10
                    goto L_0x011b
                L_0x0093:
                    r12 = 0
                L_0x0094:
                    int r13 = r9.length
                    if (r12 >= r13) goto L_0x008d
                    r13 = r9[r12]
                    r26 = r5
                    r15 = 1
                L_0x009c:
                    r5 = 11
                    if (r15 >= r5) goto L_0x0107
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder
                    r5.<init>()
                    r5.append(r0)
                    r5.append(r7)
                    r27 = r10
                    java.lang.StringBuilder r10 = new java.lang.StringBuilder
                    r10.<init>()
                    java.lang.String r2 = ".zip."
                    r10.append(r2)
                    r10.append(r15)
                    java.lang.String r2 = r10.toString()
                    java.lang.String r2 = r13.replace(r8, r2)
                    java.lang.StringBuilder r10 = new java.lang.StringBuilder
                    r10.<init>()
                    r28 = r13
                    java.lang.String r13 = ".zipp."
                    r10.append(r13)
                    r10.append(r15)
                    java.lang.String r10 = r10.toString()
                    java.lang.String r2 = r2.replace(r6, r10)
                    r5.append(r2)
                    java.lang.String r2 = r5.toString()
                    java.io.File r5 = new java.io.File
                    r5.<init>(r2)
                    boolean r5 = r5.exists()
                    if (r5 != 0) goto L_0x00ec
                    goto L_0x00fc
                L_0x00ec:
                    java.io.File r5 = new java.io.File
                    r5.<init>(r2)
                    long r29 = r5.length()
                    r31 = 52428800(0x3200000, double:2.5903269E-316)
                    int r2 = (r29 > r31 ? 1 : (r29 == r31 ? 0 : -1))
                    if (r2 >= 0) goto L_0x00fe
                L_0x00fc:
                    r2 = 1
                    goto L_0x0112
                L_0x00fe:
                    r2 = 1
                    int r15 = r15 + r2
                    r2 = r47
                    r10 = r27
                    r13 = r28
                    goto L_0x009c
                L_0x0107:
                    r27 = r10
                    r2 = 1
                    r5 = r9[r12]
                    r3.add(r5)
                    r4.add(r0)
                L_0x0112:
                    int r12 = r12 + r2
                    r2 = r47
                    r5 = r26
                    r10 = r27
                    goto L_0x0094
                L_0x011b:
                    r2 = r47
                    r15 = r18
                    r6 = r19
                    r8 = r20
                    r7 = r21
                    r0 = r22
                    r9 = r23
                    r12 = r24
                    r13 = r25
                    r5 = r26
                    r10 = r27
                    goto L_0x0036
                L_0x0133:
                    r26 = r5
                    r23 = r9
                    r27 = r10
                    r24 = r12
                    r25 = r13
                    r18 = r15
                    r2 = 0
                L_0x0140:
                    int r0 = r3.size()
                    if (r2 >= r0) goto L_0x0ac5
                    java.lang.Object r0 = r3.get(r2)
                    r5 = r0
                    java.lang.String r5 = (java.lang.String) r5
                    java.lang.Object r0 = r4.get(r2)
                    java.lang.String r0 = (java.lang.String) r0
                    java.lang.StringBuilder r9 = new java.lang.StringBuilder
                    r9.<init>()
                    r9.append(r0)
                    r9.append(r7)
                    r9.append(r5)
                    java.lang.String r9 = r9.toString()
                    java.lang.StringBuilder r10 = new java.lang.StringBuilder
                    r10.<init>()
                    java.lang.String r12 = "Analyzing "
                    r10.append(r12)
                    r10.append(r9)
                    java.lang.String r10 = r10.toString()
                    java.lang.String r12 = "InstallingFragment"
                    net.imedicaldoctor.imd.iMDLogger.j(r12, r10)
                    boolean r10 = r9.endsWith(r8)
                    java.lang.String r13 = " extracting failed"
                    java.lang.String r15 = "2"
                    r22 = r4
                    java.lang.String r4 = "0"
                    if (r10 != 0) goto L_0x018f
                    boolean r10 = r9.endsWith(r6)
                    if (r10 == 0) goto L_0x01b1
                L_0x018f:
                    r42 = r3
                    r34 = r6
                    r35 = r8
                    r8 = r9
                    r36 = r14
                    r9 = r15
                    r37 = r23
                    r39 = r25
                    r38 = r27
                    r15 = r47
                    r23 = r2
                    r2 = r5
                    r25 = r24
                    r24 = r26
                    r5 = r4
                    r26 = r11
                    r11 = r19
                    r19 = r21
                    goto L_0x0a08
                L_0x01b1:
                    java.lang.String r10 = "Checking if zip file contains update.vbe"
                    net.imedicaldoctor.imd.iMDLogger.j(r12, r10)
                    android.os.Bundle r10 = new android.os.Bundle
                    r10.<init>()
                    r34 = r6
                    net.lingala.zip4j.ZipFile r6 = new net.lingala.zip4j.ZipFile
                    r6.<init>((java.lang.String) r9)
                    boolean r28 = r6.D()     // Catch:{ Exception -> 0x09de }
                    if (r28 == 0) goto L_0x01f5
                    java.lang.String r28 = "imedicaldoctor"
                    r35 = r8
                    char[] r8 = r28.toCharArray()     // Catch:{ Exception -> 0x01d4 }
                    r6.R(r8)     // Catch:{ Exception -> 0x01d4 }
                    goto L_0x01f7
                L_0x01d4:
                    r0 = move-exception
                L_0x01d5:
                    r15 = r47
                    r42 = r3
                L_0x01d9:
                    r36 = r14
                L_0x01db:
                    r37 = r23
                    r39 = r25
                    r38 = r27
                    r23 = r2
                    r27 = r5
                    r25 = r24
                    r24 = r26
                    r26 = r11
                    r11 = r19
                    r19 = r21
                    goto L_0x09e7
                L_0x01f1:
                    r0 = move-exception
                    r35 = r8
                    goto L_0x01d5
                L_0x01f5:
                    r35 = r8
                L_0x01f7:
                    net.imedicaldoctor.imd.Fragments.InstallingFragment r8 = net.imedicaldoctor.imd.Fragments.InstallingFragment.this     // Catch:{ Exception -> 0x01d4 }
                    byte[] r8 = r8.u3(r6, r11, r10)     // Catch:{ Exception -> 0x01d4 }
                    java.lang.String r10 = r10.getString(r14)     // Catch:{ Exception -> 0x01d4 }
                    r36 = r14
                    java.lang.String r14 = "Path"
                    r28 = r6
                    java.lang.String r6 = "Name"
                    r37 = r13
                    java.lang.String r13 = "Title"
                    if (r8 == 0) goto L_0x0818
                    r38 = r15
                    java.lang.String r15 = "Found update.vbe"
                    net.imedicaldoctor.imd.iMDLogger.j(r12, r15)     // Catch:{ Exception -> 0x0814 }
                    net.imedicaldoctor.imd.VBHelper r15 = r2     // Catch:{ Exception -> 0x0814 }
                    android.os.Bundle r8 = r15.c(r8)     // Catch:{ Exception -> 0x0814 }
                    if (r8 != 0) goto L_0x0281
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x027d }
                    r0.<init>()     // Catch:{ Exception -> 0x027d }
                    java.lang.String r4 = "Can't read update.vbe in "
                    r0.append(r4)     // Catch:{ Exception -> 0x027d }
                    r0.append(r9)     // Catch:{ Exception -> 0x027d }
                    java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x027d }
                    net.imedicaldoctor.imd.iMDLogger.j(r12, r0)     // Catch:{ Exception -> 0x027d }
                    net.imedicaldoctor.imd.Fragments.InstallingFragment r0 = net.imedicaldoctor.imd.Fragments.InstallingFragment.this     // Catch:{ Exception -> 0x027d }
                    r4 = 1
                    boolean unused = r0.Q4 = r4     // Catch:{ Exception -> 0x027d }
                    net.imedicaldoctor.imd.Fragments.InstallingFragment r0 = net.imedicaldoctor.imd.Fragments.InstallingFragment.this     // Catch:{ Exception -> 0x027d }
                    java.lang.String r29 = "Updating"
                    int r32 = r3.size()     // Catch:{ Exception -> 0x027d }
                    java.lang.String r33 = "Bad Update.vbe file"
                    r28 = r0
                    r30 = r5
                    r31 = r2
                    android.os.Bundle r0 = r28.w3(r29, r30, r31, r32, r33)     // Catch:{ Exception -> 0x027d }
                    r15 = r47
                    r15.onNext(r0)     // Catch:{ Exception -> 0x0278 }
                    net.imedicaldoctor.imd.Fragments.InstallingFragment r0 = net.imedicaldoctor.imd.Fragments.InstallingFragment.this     // Catch:{ Exception -> 0x0278 }
                    r0.g3()     // Catch:{ Exception -> 0x0278 }
                    net.imedicaldoctor.imd.Data.CompressHelper r0 = r1     // Catch:{ Exception -> 0x0278 }
                L_0x0258:
                    r0.j(r9)     // Catch:{ Exception -> 0x0278 }
                    r42 = r3
                    r10 = r16
                    r4 = r17
                    r37 = r23
                    r39 = r25
                    r38 = r27
                    r6 = r34
                    r23 = r2
                    r25 = r24
                    r24 = r26
                    r2 = 1
                    r26 = r11
                    r11 = r19
                    r19 = r21
                    goto L_0x0aa4
                L_0x0278:
                    r0 = move-exception
                L_0x0279:
                    r42 = r3
                    goto L_0x01db
                L_0x027d:
                    r0 = move-exception
                    r15 = r47
                    goto L_0x0279
                L_0x0281:
                    r15 = r47
                    r39 = r4
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0801 }
                    r4.<init>()     // Catch:{ Exception -> 0x0801 }
                    r4.append(r0)     // Catch:{ Exception -> 0x0801 }
                    r4.append(r7)     // Catch:{ Exception -> 0x0801 }
                    r4.append(r10)     // Catch:{ Exception -> 0x0801 }
                    java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0801 }
                    r40 = r4
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0801 }
                    r4.<init>()     // Catch:{ Exception -> 0x0801 }
                    r4.append(r0)     // Catch:{ Exception -> 0x0801 }
                    r4.append(r7)     // Catch:{ Exception -> 0x0801 }
                    r4.append(r10)     // Catch:{ Exception -> 0x0801 }
                    java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x0801 }
                    r8.putString(r14, r0)     // Catch:{ Exception -> 0x0801 }
                    net.imedicaldoctor.imd.Data.CompressHelper r0 = r1     // Catch:{ Exception -> 0x0801 }
                    java.lang.String r4 = r8.getString(r6)     // Catch:{ Exception -> 0x0801 }
                    java.util.ArrayList r0 = r0.Z0(r6, r4)     // Catch:{ Exception -> 0x0801 }
                    int r4 = r0.size()     // Catch:{ Exception -> 0x0801 }
                    if (r4 != 0) goto L_0x02fc
                    java.lang.String r0 = "No Database available for this update"
                    net.imedicaldoctor.imd.iMDLogger.f(r12, r0)     // Catch:{ Exception -> 0x0278 }
                    net.imedicaldoctor.imd.Fragments.InstallingFragment r0 = net.imedicaldoctor.imd.Fragments.InstallingFragment.this     // Catch:{ Exception -> 0x0278 }
                    r4 = 1
                    boolean unused = r0.Q4 = r4     // Catch:{ Exception -> 0x0278 }
                    net.imedicaldoctor.imd.Fragments.InstallingFragment r0 = net.imedicaldoctor.imd.Fragments.InstallingFragment.this     // Catch:{ Exception -> 0x0278 }
                    java.lang.String r29 = "Updating"
                    int r32 = r3.size()     // Catch:{ Exception -> 0x0278 }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0278 }
                    r4.<init>()     // Catch:{ Exception -> 0x0278 }
                    java.lang.String r10 = "No Database with name "
                    r4.append(r10)     // Catch:{ Exception -> 0x0278 }
                    java.lang.String r6 = r8.getString(r6)     // Catch:{ Exception -> 0x0278 }
                    r4.append(r6)     // Catch:{ Exception -> 0x0278 }
                    java.lang.String r33 = r4.toString()     // Catch:{ Exception -> 0x0278 }
                    r28 = r0
                    r30 = r5
                    r31 = r2
                    android.os.Bundle r0 = r28.w3(r29, r30, r31, r32, r33)     // Catch:{ Exception -> 0x0278 }
                    r15.onNext(r0)     // Catch:{ Exception -> 0x0278 }
                    net.imedicaldoctor.imd.Fragments.InstallingFragment r0 = net.imedicaldoctor.imd.Fragments.InstallingFragment.this     // Catch:{ Exception -> 0x0278 }
                    r0.g3()     // Catch:{ Exception -> 0x0278 }
                    net.imedicaldoctor.imd.Data.CompressHelper r0 = r1     // Catch:{ Exception -> 0x0278 }
                    goto L_0x0258
                L_0x02fc:
                    r4 = 0
                    java.lang.Object r0 = r0.get(r4)     // Catch:{ Exception -> 0x0801 }
                    r4 = r0
                    android.os.Bundle r4 = (android.os.Bundle) r4     // Catch:{ Exception -> 0x0801 }
                    java.lang.String r0 = net.imedicaldoctor.imd.Data.CompressHelper.g1(r4, r11)     // Catch:{ Exception -> 0x0801 }
                    r10 = r27
                    java.lang.String r6 = r4.getString(r10)     // Catch:{ Exception -> 0x07e2 }
                    r27 = r5
                    r5 = r26
                    r26 = r11
                    java.lang.String r11 = r8.getString(r5)     // Catch:{ Exception -> 0x07c6 }
                    boolean r6 = r6.equals(r11)     // Catch:{ Exception -> 0x07c6 }
                    if (r6 != 0) goto L_0x03cb
                    java.io.File r6 = new java.io.File     // Catch:{ Exception -> 0x03c5 }
                    r6.<init>(r0)     // Catch:{ Exception -> 0x03c5 }
                    boolean r0 = r6.exists()     // Catch:{ Exception -> 0x03c5 }
                    if (r0 != 0) goto L_0x03cb
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03c5 }
                    r0.<init>()     // Catch:{ Exception -> 0x03c5 }
                    r11 = r25
                    r0.append(r11)     // Catch:{ Exception -> 0x03c1 }
                    java.lang.String r6 = r4.getString(r10)     // Catch:{ Exception -> 0x03c1 }
                    r0.append(r6)     // Catch:{ Exception -> 0x03c1 }
                    r6 = r24
                    r0.append(r6)     // Catch:{ Exception -> 0x03ac }
                    java.lang.String r14 = r8.getString(r5)     // Catch:{ Exception -> 0x03ac }
                    r0.append(r14)     // Catch:{ Exception -> 0x03ac }
                    java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x03ac }
                    net.imedicaldoctor.imd.iMDLogger.f(r12, r0)     // Catch:{ Exception -> 0x03ac }
                    net.imedicaldoctor.imd.Fragments.InstallingFragment r0 = net.imedicaldoctor.imd.Fragments.InstallingFragment.this     // Catch:{ Exception -> 0x03ac }
                    r12 = 1
                    boolean unused = r0.Q4 = r12     // Catch:{ Exception -> 0x03ac }
                    net.imedicaldoctor.imd.Fragments.InstallingFragment r0 = net.imedicaldoctor.imd.Fragments.InstallingFragment.this     // Catch:{ Exception -> 0x03ac }
                    java.lang.String r29 = "Updating"
                    java.lang.String r30 = r4.getString(r13)     // Catch:{ Exception -> 0x03ac }
                    int r32 = r3.size()     // Catch:{ Exception -> 0x03ac }
                    java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03ac }
                    r12.<init>()     // Catch:{ Exception -> 0x03ac }
                    r12.append(r11)     // Catch:{ Exception -> 0x03ac }
                    java.lang.String r4 = r4.getString(r10)     // Catch:{ Exception -> 0x03ac }
                    r12.append(r4)     // Catch:{ Exception -> 0x03ac }
                    r12.append(r6)     // Catch:{ Exception -> 0x03ac }
                    java.lang.String r4 = r8.getString(r5)     // Catch:{ Exception -> 0x03ac }
                    r12.append(r4)     // Catch:{ Exception -> 0x03ac }
                    java.lang.String r33 = r12.toString()     // Catch:{ Exception -> 0x03ac }
                    r28 = r0
                    r31 = r2
                    android.os.Bundle r0 = r28.w3(r29, r30, r31, r32, r33)     // Catch:{ Exception -> 0x03ac }
                    r15.onNext(r0)     // Catch:{ Exception -> 0x03ac }
                    net.imedicaldoctor.imd.Fragments.InstallingFragment r0 = net.imedicaldoctor.imd.Fragments.InstallingFragment.this     // Catch:{ Exception -> 0x03ac }
                    r0.g3()     // Catch:{ Exception -> 0x03ac }
                    net.imedicaldoctor.imd.Data.CompressHelper r0 = r1     // Catch:{ Exception -> 0x03ac }
                    r0.j(r9)     // Catch:{ Exception -> 0x03ac }
                    r42 = r3
                    r24 = r5
                    r25 = r6
                    r38 = r10
                    r39 = r11
                    r10 = r16
                    r4 = r17
                    r11 = r19
                    r19 = r21
                    r37 = r23
                    r6 = r34
                    r23 = r2
                L_0x03a9:
                    r2 = 1
                    goto L_0x0aa4
                L_0x03ac:
                    r0 = move-exception
                L_0x03ad:
                    r42 = r3
                    r24 = r5
                    r25 = r6
                L_0x03b3:
                    r38 = r10
                    r39 = r11
                L_0x03b7:
                    r11 = r19
                    r19 = r21
                    r37 = r23
                    r23 = r2
                    goto L_0x09e7
                L_0x03c1:
                    r0 = move-exception
                    r6 = r24
                    goto L_0x03ad
                L_0x03c5:
                    r0 = move-exception
                    r6 = r24
                    r11 = r25
                    goto L_0x03ad
                L_0x03cb:
                    r6 = r24
                    r11 = r25
                    net.imedicaldoctor.imd.Fragments.InstallingFragment r0 = net.imedicaldoctor.imd.Fragments.InstallingFragment.this     // Catch:{ Exception -> 0x07c0 }
                    java.lang.String r29 = "Updating"
                    java.lang.String r30 = r4.getString(r13)     // Catch:{ Exception -> 0x07c0 }
                    int r32 = r3.size()     // Catch:{ Exception -> 0x07c0 }
                    java.lang.String r33 = ""
                    r28 = r0
                    r31 = r2
                    android.os.Bundle r0 = r28.w3(r29, r30, r31, r32, r33)     // Catch:{ Exception -> 0x07c0 }
                    r15.onNext(r0)     // Catch:{ Exception -> 0x07c0 }
                    java.lang.String r8 = r4.getString(r14)     // Catch:{ Exception -> 0x07c0 }
                    net.imedicaldoctor.imd.Fragments.InstallingFragment r0 = net.imedicaldoctor.imd.Fragments.InstallingFragment.this     // Catch:{ Exception -> 0x07c0 }
                    java.lang.String unused = r0.T4 = r9     // Catch:{ Exception -> 0x07c0 }
                    net.imedicaldoctor.imd.Decompress r0 = new net.imedicaldoctor.imd.Decompress     // Catch:{ Exception -> 0x07c0 }
                    java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x07c0 }
                    r14.<init>()     // Catch:{ Exception -> 0x07c0 }
                    r14.append(r8)     // Catch:{ Exception -> 0x07c0 }
                    r14.append(r7)     // Catch:{ Exception -> 0x07c0 }
                    java.lang.String r14 = r14.toString()     // Catch:{ Exception -> 0x07c0 }
                    r24 = r5
                    net.imedicaldoctor.imd.Fragments.InstallingFragment r5 = net.imedicaldoctor.imd.Fragments.InstallingFragment.this     // Catch:{ Exception -> 0x07ba }
                    androidx.fragment.app.FragmentActivity r5 = r5.r()     // Catch:{ Exception -> 0x07ba }
                    r0.<init>(r9, r14, r5)     // Catch:{ Exception -> 0x07ba }
                    java.lang.String r5 = r4.getString(r13)     // Catch:{ Exception -> 0x07ba }
                    java.lang.String r0 = r0.g(r15, r5)     // Catch:{ Exception -> 0x07ba }
                    int r5 = r40.length()     // Catch:{ Exception -> 0x07ba }
                    if (r5 <= 0) goto L_0x0434
                    net.imedicaldoctor.imd.Fragments.InstallingFragment r5 = net.imedicaldoctor.imd.Fragments.InstallingFragment.this     // Catch:{ Exception -> 0x0430 }
                    java.io.File r14 = new java.io.File     // Catch:{ Exception -> 0x0430 }
                    r25 = r6
                    r6 = r40
                    r14.<init>(r6)     // Catch:{ Exception -> 0x042c }
                    r5.y3(r14)     // Catch:{ Exception -> 0x042c }
                L_0x0429:
                    r5 = r39
                    goto L_0x0437
                L_0x042c:
                    r0 = move-exception
                L_0x042d:
                    r42 = r3
                    goto L_0x03b3
                L_0x0430:
                    r0 = move-exception
                    r25 = r6
                    goto L_0x042d
                L_0x0434:
                    r25 = r6
                    goto L_0x0429
                L_0x0437:
                    boolean r5 = r0.equals(r5)     // Catch:{ Exception -> 0x07a2 }
                    if (r5 == 0) goto L_0x071e
                    java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x0716 }
                    r0.<init>(r8)     // Catch:{ Exception -> 0x0716 }
                    net.imedicaldoctor.imd.Fragments.InstallingFragment$1$3 r5 = new net.imedicaldoctor.imd.Fragments.InstallingFragment$1$3     // Catch:{ Exception -> 0x0716 }
                    r5.<init>()     // Catch:{ Exception -> 0x0716 }
                    java.lang.String[] r5 = r0.list(r5)     // Catch:{ Exception -> 0x0716 }
                    int r0 = r5.length     // Catch:{ Exception -> 0x0716 }
                    r28 = 0
                    r30 = r28
                    r6 = 0
                L_0x0451:
                    if (r6 >= r0) goto L_0x047b
                    r12 = r5[r6]     // Catch:{ Exception -> 0x0475 }
                    java.lang.String r12 = net.imedicaldoctor.imd.Data.CompressHelper.g1(r4, r12)     // Catch:{ Exception -> 0x0475 }
                    java.io.File r14 = new java.io.File     // Catch:{ Exception -> 0x0475 }
                    r14.<init>(r12)     // Catch:{ Exception -> 0x0475 }
                    r38 = r10
                    r39 = r11
                    long r10 = r14.length()     // Catch:{ Exception -> 0x0470 }
                    double r10 = (double) r10
                    double r30 = r30 + r10
                    r10 = 1
                    int r6 = r6 + r10
                    r10 = r38
                    r11 = r39
                    goto L_0x0451
                L_0x0470:
                    r0 = move-exception
                L_0x0471:
                    r42 = r3
                    goto L_0x03b7
                L_0x0475:
                    r0 = move-exception
                    r38 = r10
                    r39 = r11
                    goto L_0x0471
                L_0x047b:
                    r38 = r10
                    r39 = r11
                    int r6 = r5.length     // Catch:{ Exception -> 0x070a }
                    r0 = 0
                    r10 = 0
                L_0x0482:
                    if (r10 >= r6) goto L_0x06c1
                    r11 = r5[r10]     // Catch:{ Exception -> 0x06b1 }
                    r12 = 1
                    int r14 = r0 + 1
                    double r32 = r28 / r30
                    r40 = 4636737291354636288(0x4059000000000000, double:100.0)
                    double r32 = r32 * r40
                    java.lang.Double r0 = java.lang.Double.valueOf(r32)     // Catch:{ Exception -> 0x06b1 }
                    r32 = r6
                    java.lang.Object[] r6 = new java.lang.Object[r12]     // Catch:{ Exception -> 0x069f }
                    r12 = 0
                    r6[r12] = r0     // Catch:{ Exception -> 0x069f }
                    r12 = r23
                    java.lang.String r0 = java.lang.String.format(r12, r6)     // Catch:{ Exception -> 0x069b }
                    android.os.Bundle r6 = new android.os.Bundle     // Catch:{ Exception -> 0x069b }
                    r6.<init>()     // Catch:{ Exception -> 0x069b }
                    r23 = r2
                    java.lang.String r2 = "labelText"
                    r42 = r3
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x068b }
                    r3.<init>()     // Catch:{ Exception -> 0x068b }
                    r43 = r9
                    java.lang.String r9 = r4.getString(r13)     // Catch:{ Exception -> 0x068b }
                    r3.append(r9)     // Catch:{ Exception -> 0x068b }
                    java.lang.String r9 = " ( "
                    r3.append(r9)     // Catch:{ Exception -> 0x068b }
                    r3.append(r14)     // Catch:{ Exception -> 0x068b }
                    java.lang.String r9 = " / "
                    r3.append(r9)     // Catch:{ Exception -> 0x068b }
                    int r9 = r5.length     // Catch:{ Exception -> 0x068b }
                    r3.append(r9)     // Catch:{ Exception -> 0x068b }
                    java.lang.String r9 = " )"
                    r3.append(r9)     // Catch:{ Exception -> 0x068b }
                    java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x068b }
                    r6.putString(r2, r3)     // Catch:{ Exception -> 0x068b }
                    r2 = r18
                    r6.putString(r2, r0)     // Catch:{ Exception -> 0x067f }
                    r15.onNext(r6)     // Catch:{ Exception -> 0x067f }
                    java.lang.String r3 = net.imedicaldoctor.imd.Data.CompressHelper.g1(r4, r11)     // Catch:{ Exception -> 0x067f }
                    java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0624 }
                    java.io.InputStreamReader r9 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0624 }
                    r18 = r5
                    java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ Exception -> 0x061e }
                    r33 = r14
                    java.io.File r14 = new java.io.File     // Catch:{ Exception -> 0x061a }
                    r14.<init>(r3)     // Catch:{ Exception -> 0x061a }
                    r5.<init>(r14)     // Catch:{ Exception -> 0x061a }
                    r9.<init>(r5)     // Catch:{ Exception -> 0x061a }
                    r0.<init>(r9)     // Catch:{ Exception -> 0x061a }
                    java.lang.String r5 = r0.readLine()     // Catch:{ Exception -> 0x061a }
                    java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x061a }
                    r9.<init>()     // Catch:{ Exception -> 0x061a }
                    r9.append(r8)     // Catch:{ Exception -> 0x061a }
                    r9.append(r7)     // Catch:{ Exception -> 0x061a }
                    r9.append(r5)     // Catch:{ Exception -> 0x061a }
                    java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x061a }
                    r14 = 2
                    r44 = r8
                    r8 = 0
                    io.requery.android.database.sqlite.SQLiteDatabase r9 = io.requery.android.database.sqlite.SQLiteDatabase.openDatabase((java.lang.String) r9, (io.requery.android.database.sqlite.SQLiteDatabase.CursorFactory) r8, (int) r14)     // Catch:{ Exception -> 0x0612 }
                    java.lang.String r8 = "PRAGMA temp_store = MEMORY"
                    r9.execSQL(r8)     // Catch:{ Exception -> 0x0612 }
                    r9.beginTransaction()     // Catch:{ Exception -> 0x0612 }
                    java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0612 }
                    r8.<init>()     // Catch:{ Exception -> 0x0612 }
                    java.lang.String r14 = "Starting Executing "
                    r8.append(r14)     // Catch:{ Exception -> 0x0612 }
                    r8.append(r3)     // Catch:{ Exception -> 0x0612 }
                    r14 = r21
                    r8.append(r14)     // Catch:{ Exception -> 0x0608 }
                    r8.append(r5)     // Catch:{ Exception -> 0x0608 }
                    java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0608 }
                    r21 = r7
                    r7 = r20
                    net.imedicaldoctor.imd.iMDLogger.j(r7, r8)     // Catch:{ Exception -> 0x0603 }
                    r20 = r13
                    r8 = 0
                L_0x0543:
                    java.lang.String r13 = r0.readLine()     // Catch:{ Exception -> 0x0560, all -> 0x055b }
                    if (r13 != 0) goto L_0x0564
                    r9.setTransactionSuccessful()     // Catch:{ Exception -> 0x0560, all -> 0x055b }
                    r9.endTransaction()     // Catch:{ Exception -> 0x0556 }
                    r9.close()     // Catch:{ Exception -> 0x0556 }
                    r11 = r19
                    goto L_0x05dd
                L_0x0556:
                    r0 = move-exception
                L_0x0557:
                    r11 = r19
                    goto L_0x0628
                L_0x055b:
                    r0 = move-exception
                    r11 = r19
                    goto L_0x05fc
                L_0x0560:
                    r0 = move-exception
                    r11 = r19
                    goto L_0x05cd
                L_0x0564:
                    r37 = r0
                    int r0 = r13.length()     // Catch:{ Exception -> 0x0560, all -> 0x055b }
                    double r0 = (double) r0     // Catch:{ Exception -> 0x0560, all -> 0x055b }
                    double r28 = r28 + r0
                    r1 = 1
                    int r8 = r8 + r1
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0560, all -> 0x055b }
                    r0.<init>()     // Catch:{ Exception -> 0x0560, all -> 0x055b }
                    java.lang.String r1 = "SQL Line - "
                    r0.append(r1)     // Catch:{ Exception -> 0x0560, all -> 0x055b }
                    r0.append(r11)     // Catch:{ Exception -> 0x0560, all -> 0x055b }
                    java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0560, all -> 0x055b }
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0560, all -> 0x055b }
                    r1.<init>()     // Catch:{ Exception -> 0x0560, all -> 0x055b }
                    r1.append(r8)     // Catch:{ Exception -> 0x0560, all -> 0x055b }
                    r45 = r11
                    r11 = r19
                    r1.append(r11)     // Catch:{ Exception -> 0x05ba }
                    java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x05ba }
                    net.imedicaldoctor.imd.iMDLogger.d(r0, r1)     // Catch:{ Exception -> 0x05ba }
                    int r0 = r8 % 100
                    if (r0 != 0) goto L_0x05bc
                    double r0 = r28 / r30
                    double r0 = r0 * r40
                    java.lang.Double r0 = java.lang.Double.valueOf(r0)     // Catch:{ Exception -> 0x05ba }
                    r19 = r8
                    r1 = 1
                    java.lang.Object[] r8 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x05ba }
                    r1 = 0
                    r8[r1] = r0     // Catch:{ Exception -> 0x05ba }
                    java.lang.String r0 = java.lang.String.format(r12, r8)     // Catch:{ Exception -> 0x05ba }
                    r6.remove(r2)     // Catch:{ Exception -> 0x05ba }
                    r6.putString(r2, r0)     // Catch:{ Exception -> 0x05ba }
                    r15.onNext(r6)     // Catch:{ Exception -> 0x05ba }
                    goto L_0x05be
                L_0x05b8:
                    r0 = move-exception
                    goto L_0x05fc
                L_0x05ba:
                    r0 = move-exception
                    goto L_0x05cd
                L_0x05bc:
                    r19 = r8
                L_0x05be:
                    r9.execSQL(r13)     // Catch:{ Exception -> 0x05ba }
                    r1 = r46
                    r8 = r19
                    r0 = r37
                    r19 = r11
                    r11 = r45
                    goto L_0x0543
                L_0x05cd:
                    com.google.firebase.crashlytics.FirebaseCrashlytics r1 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()     // Catch:{ all -> 0x05b8 }
                    r1.g(r0)     // Catch:{ all -> 0x05b8 }
                    r0.printStackTrace()     // Catch:{ all -> 0x05b8 }
                    r9.endTransaction()     // Catch:{ Exception -> 0x05fa }
                    r9.close()     // Catch:{ Exception -> 0x05fa }
                L_0x05dd:
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x05fa }
                    r0.<init>()     // Catch:{ Exception -> 0x05fa }
                    java.lang.String r1 = "Done Executing "
                    r0.append(r1)     // Catch:{ Exception -> 0x05fa }
                    r0.append(r3)     // Catch:{ Exception -> 0x05fa }
                    r0.append(r14)     // Catch:{ Exception -> 0x05fa }
                    r0.append(r5)     // Catch:{ Exception -> 0x05fa }
                    java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x05fa }
                    net.imedicaldoctor.imd.iMDLogger.j(r7, r0)     // Catch:{ Exception -> 0x05fa }
                L_0x05f7:
                    r1 = r46
                    goto L_0x0649
                L_0x05fa:
                    r0 = move-exception
                    goto L_0x0628
                L_0x05fc:
                    r9.endTransaction()     // Catch:{ Exception -> 0x05fa }
                    r9.close()     // Catch:{ Exception -> 0x05fa }
                    throw r0     // Catch:{ Exception -> 0x05fa }
                L_0x0603:
                    r0 = move-exception
                    r20 = r13
                    goto L_0x0557
                L_0x0608:
                    r0 = move-exception
                    r21 = r7
                    r11 = r19
                L_0x060d:
                    r7 = r20
                    r20 = r13
                    goto L_0x0628
                L_0x0612:
                    r0 = move-exception
                L_0x0613:
                    r11 = r19
                    r14 = r21
                    r21 = r7
                    goto L_0x060d
                L_0x061a:
                    r0 = move-exception
                    r44 = r8
                    goto L_0x0613
                L_0x061e:
                    r0 = move-exception
                L_0x061f:
                    r44 = r8
                    r33 = r14
                    goto L_0x0613
                L_0x0624:
                    r0 = move-exception
                    r18 = r5
                    goto L_0x061f
                L_0x0628:
                    com.google.firebase.crashlytics.FirebaseCrashlytics r1 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()     // Catch:{ Exception -> 0x067b }
                    r1.g(r0)     // Catch:{ Exception -> 0x067b }
                    r0.printStackTrace()     // Catch:{ Exception -> 0x067b }
                    java.lang.String r0 = "ReadingSQL"
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x067b }
                    r1.<init>()     // Catch:{ Exception -> 0x067b }
                    java.lang.String r5 = "Error in reading and executing "
                    r1.append(r5)     // Catch:{ Exception -> 0x067b }
                    r1.append(r3)     // Catch:{ Exception -> 0x067b }
                    java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x067b }
                    net.imedicaldoctor.imd.iMDLogger.f(r0, r1)     // Catch:{ Exception -> 0x067b }
                    goto L_0x05f7
                L_0x0649:
                    net.imedicaldoctor.imd.Data.CompressHelper r0 = r1     // Catch:{ Exception -> 0x066e }
                    r0.j(r3)     // Catch:{ Exception -> 0x066e }
                    r3 = 1
                    int r10 = r10 + r3
                    r19 = r11
                    r5 = r18
                    r13 = r20
                    r6 = r32
                    r0 = r33
                    r3 = r42
                    r9 = r43
                    r8 = r44
                    r18 = r2
                    r20 = r7
                    r7 = r21
                    r2 = r23
                    r23 = r12
                    r21 = r14
                    goto L_0x0482
                L_0x066e:
                    r0 = move-exception
                L_0x066f:
                    r18 = r2
                L_0x0671:
                    r20 = r7
                L_0x0673:
                    r37 = r12
                L_0x0675:
                    r19 = r14
                L_0x0677:
                    r7 = r21
                    goto L_0x09e7
                L_0x067b:
                    r0 = move-exception
                    r1 = r46
                    goto L_0x066f
                L_0x067f:
                    r0 = move-exception
                    r11 = r19
                    r14 = r21
                    r21 = r7
                    r7 = r20
                    r18 = r2
                    goto L_0x0673
                L_0x068b:
                    r0 = move-exception
                L_0x068c:
                    r2 = r18
                    r11 = r19
                    r14 = r21
                    r21 = r7
                L_0x0694:
                    r7 = r20
                    goto L_0x0673
                L_0x0697:
                    r0 = move-exception
                L_0x0698:
                    r42 = r3
                    goto L_0x068c
                L_0x069b:
                    r0 = move-exception
                    r23 = r2
                    goto L_0x0698
                L_0x069f:
                    r0 = move-exception
                    r42 = r3
                    r11 = r19
                    r14 = r21
                    r12 = r23
                    r23 = r2
                    r21 = r7
                    r2 = r18
                    r7 = r20
                    goto L_0x066f
                L_0x06b1:
                    r0 = move-exception
                    r42 = r3
                    r11 = r19
                    r14 = r21
                    r12 = r23
                L_0x06ba:
                    r23 = r2
                    r21 = r7
                    r2 = r18
                    goto L_0x0694
                L_0x06c1:
                    r42 = r3
                    r43 = r9
                    r11 = r19
                    r14 = r21
                    r12 = r23
                    r23 = r2
                    r21 = r7
                    r2 = r18
                    r7 = r20
                    net.imedicaldoctor.imd.Data.CompressHelper r0 = r1     // Catch:{ Exception -> 0x0705 }
                    r3 = r26
                    java.lang.String r5 = net.imedicaldoctor.imd.Data.CompressHelper.g1(r4, r3)     // Catch:{ Exception -> 0x06fe }
                    r0.j(r5)     // Catch:{ Exception -> 0x06fe }
                    net.imedicaldoctor.imd.Data.CompressHelper r0 = r1     // Catch:{ Exception -> 0x06fe }
                    r8 = r43
                    r0.j(r8)     // Catch:{ Exception -> 0x06fe }
                    net.imedicaldoctor.imd.Fragments.InstallingFragment r0 = net.imedicaldoctor.imd.Fragments.InstallingFragment.this     // Catch:{ Exception -> 0x06fe }
                    r0.x3(r4)     // Catch:{ Exception -> 0x06fe }
                    r18 = r2
                    r26 = r3
                    r20 = r7
                    r37 = r12
                L_0x06f2:
                    r19 = r14
                L_0x06f4:
                    r10 = r16
                    r4 = r17
                    r7 = r21
                L_0x06fa:
                    r6 = r34
                    goto L_0x03a9
                L_0x06fe:
                    r0 = move-exception
                    r18 = r2
                    r26 = r3
                    goto L_0x0671
                L_0x0705:
                    r0 = move-exception
                    r3 = r26
                    goto L_0x066f
                L_0x070a:
                    r0 = move-exception
                    r42 = r3
                L_0x070d:
                    r11 = r19
                    r14 = r21
                    r12 = r23
                    r3 = r26
                    goto L_0x06ba
                L_0x0716:
                    r0 = move-exception
                    r42 = r3
                    r38 = r10
                    r39 = r11
                    goto L_0x070d
                L_0x071e:
                    r42 = r3
                    r8 = r9
                    r39 = r11
                    r11 = r19
                    r14 = r21
                    r3 = r26
                    r9 = r38
                    r21 = r7
                    r38 = r10
                    r7 = r20
                    r10 = r23
                    r23 = r2
                    r20 = r13
                    r2 = r18
                    boolean r0 = r0.equals(r9)     // Catch:{ Exception -> 0x0783 }
                    if (r0 == 0) goto L_0x078e
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0783 }
                    r0.<init>()     // Catch:{ Exception -> 0x0783 }
                    r0.append(r8)     // Catch:{ Exception -> 0x0783 }
                    r13 = r37
                    r0.append(r13)     // Catch:{ Exception -> 0x0783 }
                    java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0783 }
                    net.imedicaldoctor.imd.iMDLogger.j(r12, r0)     // Catch:{ Exception -> 0x0783 }
                    net.imedicaldoctor.imd.Fragments.InstallingFragment r0 = net.imedicaldoctor.imd.Fragments.InstallingFragment.this     // Catch:{ Exception -> 0x0783 }
                    r5 = 1
                    boolean unused = r0.Q4 = r5     // Catch:{ Exception -> 0x0783 }
                    net.imedicaldoctor.imd.Fragments.InstallingFragment r0 = net.imedicaldoctor.imd.Fragments.InstallingFragment.this     // Catch:{ Exception -> 0x0783 }
                    java.lang.String r29 = "Updating"
                    r5 = r20
                    java.lang.String r30 = r4.getString(r5)     // Catch:{ Exception -> 0x0783 }
                    int r32 = r42.size()     // Catch:{ Exception -> 0x0783 }
                    java.lang.String r33 = "There is no space available. Please free up some space and open app again"
                    r28 = r0
                    r31 = r23
                    android.os.Bundle r0 = r28.w3(r29, r30, r31, r32, r33)     // Catch:{ Exception -> 0x0783 }
                    r15.onNext(r0)     // Catch:{ Exception -> 0x0783 }
                    net.imedicaldoctor.imd.Fragments.InstallingFragment r0 = net.imedicaldoctor.imd.Fragments.InstallingFragment.this     // Catch:{ Exception -> 0x0783 }
                    r0.g3()     // Catch:{ Exception -> 0x0783 }
                L_0x0779:
                    r18 = r2
                    r26 = r3
                    r20 = r7
                    r37 = r10
                    goto L_0x06f2
                L_0x0783:
                    r0 = move-exception
                    r18 = r2
                    r26 = r3
                    r20 = r7
                L_0x078a:
                    r37 = r10
                    goto L_0x0675
                L_0x078e:
                    net.imedicaldoctor.imd.Data.CompressHelper r0 = r1     // Catch:{ Exception -> 0x0783 }
                    java.lang.String r5 = net.imedicaldoctor.imd.Data.CompressHelper.g1(r4, r3)     // Catch:{ Exception -> 0x0783 }
                    r0.j(r5)     // Catch:{ Exception -> 0x0783 }
                    net.imedicaldoctor.imd.Data.CompressHelper r0 = r1     // Catch:{ Exception -> 0x0783 }
                    r0.j(r8)     // Catch:{ Exception -> 0x0783 }
                    net.imedicaldoctor.imd.Fragments.InstallingFragment r0 = net.imedicaldoctor.imd.Fragments.InstallingFragment.this     // Catch:{ Exception -> 0x0783 }
                    r0.x3(r4)     // Catch:{ Exception -> 0x0783 }
                    goto L_0x0779
                L_0x07a2:
                    r0 = move-exception
                    r42 = r3
                L_0x07a5:
                    r38 = r10
                    r39 = r11
                    r11 = r19
                    r14 = r21
                    r10 = r23
                    r3 = r26
                    r23 = r2
                    r21 = r7
                    r2 = r18
                    r7 = r20
                    goto L_0x078a
                L_0x07ba:
                    r0 = move-exception
                    r42 = r3
                L_0x07bd:
                    r25 = r6
                    goto L_0x07a5
                L_0x07c0:
                    r0 = move-exception
                    r42 = r3
                    r24 = r5
                    goto L_0x07bd
                L_0x07c6:
                    r0 = move-exception
                    r42 = r3
                    r38 = r10
                    r11 = r19
                    r14 = r21
                    r10 = r23
                    r39 = r25
                    r3 = r26
                    r23 = r2
                    r21 = r7
                    r2 = r18
                    r7 = r20
                    r25 = r24
                    r24 = r5
                    goto L_0x078a
                L_0x07e2:
                    r0 = move-exception
                    r42 = r3
                    r27 = r5
                    r38 = r10
                    r3 = r11
                    r11 = r19
                    r14 = r21
                    r10 = r23
                    r39 = r25
                    r23 = r2
                L_0x07f4:
                    r21 = r7
                    r2 = r18
                    r7 = r20
                    r25 = r24
                    r24 = r26
                    r26 = r3
                    goto L_0x078a
                L_0x0801:
                    r0 = move-exception
                L_0x0802:
                    r42 = r3
                    r3 = r11
                    r11 = r19
                    r14 = r21
                    r10 = r23
                    r39 = r25
                    r38 = r27
                    r23 = r2
                    r27 = r5
                    goto L_0x07f4
                L_0x0814:
                    r0 = move-exception
                    r15 = r47
                    goto L_0x0802
                L_0x0818:
                    r42 = r3
                    r8 = r9
                    r9 = r15
                    r10 = r23
                    r39 = r25
                    r38 = r27
                    r15 = r47
                    r23 = r2
                    r27 = r5
                    r2 = r13
                    r13 = r37
                    r5 = r4
                    r4 = r24
                    r24 = r26
                    r26 = r11
                    r11 = r19
                    r19 = r21
                    r21 = r7
                    r7 = r20
                    java.lang.String r3 = "Checking if zip file contains info.vbe"
                    net.imedicaldoctor.imd.iMDLogger.j(r12, r3)     // Catch:{ Exception -> 0x09da }
                    android.os.Bundle r3 = new android.os.Bundle     // Catch:{ Exception -> 0x09da }
                    r3.<init>()     // Catch:{ Exception -> 0x09da }
                    r25 = r4
                    net.imedicaldoctor.imd.Fragments.InstallingFragment r4 = net.imedicaldoctor.imd.Fragments.InstallingFragment.this     // Catch:{ Exception -> 0x09d6 }
                    r20 = r7
                    java.lang.String r7 = "info.vbe"
                    r37 = r10
                    r10 = r28
                    byte[] r4 = r4.u3(r10, r7, r3)     // Catch:{ Exception -> 0x08a9 }
                    r7 = r36
                    java.lang.String r3 = r3.getString(r7)     // Catch:{ Exception -> 0x0903 }
                    if (r4 == 0) goto L_0x0908
                    java.lang.String r10 = "Found info.vbe"
                    net.imedicaldoctor.imd.iMDLogger.j(r12, r10)     // Catch:{ Exception -> 0x0903 }
                    net.imedicaldoctor.imd.VBHelper r10 = r2     // Catch:{ Exception -> 0x0903 }
                    r36 = r7
                    r7 = 0
                    android.os.Bundle r4 = r10.e(r4, r7)     // Catch:{ Exception -> 0x08a9 }
                    if (r4 != 0) goto L_0x08ac
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x08a9 }
                    r0.<init>()     // Catch:{ Exception -> 0x08a9 }
                    java.lang.String r2 = "Can't read info.vbe in "
                    r0.append(r2)     // Catch:{ Exception -> 0x08a9 }
                    r0.append(r8)     // Catch:{ Exception -> 0x08a9 }
                    java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x08a9 }
                    net.imedicaldoctor.imd.iMDLogger.j(r12, r0)     // Catch:{ Exception -> 0x08a9 }
                    net.imedicaldoctor.imd.Fragments.InstallingFragment r0 = net.imedicaldoctor.imd.Fragments.InstallingFragment.this     // Catch:{ Exception -> 0x08a9 }
                    r2 = 1
                    boolean unused = r0.Q4 = r2     // Catch:{ Exception -> 0x08a9 }
                    net.imedicaldoctor.imd.Fragments.InstallingFragment r0 = net.imedicaldoctor.imd.Fragments.InstallingFragment.this     // Catch:{ Exception -> 0x08a9 }
                    java.lang.String r29 = "Installing"
                    int r32 = r42.size()     // Catch:{ Exception -> 0x08a9 }
                    java.lang.String r33 = "Bad info.vbe file"
                    r28 = r0
                    r30 = r27
                    r31 = r23
                    android.os.Bundle r0 = r28.w3(r29, r30, r31, r32, r33)     // Catch:{ Exception -> 0x08a9 }
                    r15.onNext(r0)     // Catch:{ Exception -> 0x08a9 }
                    net.imedicaldoctor.imd.Fragments.InstallingFragment r0 = net.imedicaldoctor.imd.Fragments.InstallingFragment.this     // Catch:{ Exception -> 0x08a9 }
                    r0.g3()     // Catch:{ Exception -> 0x08a9 }
                    net.imedicaldoctor.imd.Data.CompressHelper r0 = r1     // Catch:{ Exception -> 0x08a9 }
                    r0.j(r8)     // Catch:{ Exception -> 0x08a9 }
                    goto L_0x06f4
                L_0x08a9:
                    r0 = move-exception
                    goto L_0x0677
                L_0x08ac:
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x08a9 }
                    r7.<init>()     // Catch:{ Exception -> 0x08a9 }
                    r7.append(r0)     // Catch:{ Exception -> 0x08a9 }
                    r10 = 47
                    r7.append(r10)     // Catch:{ Exception -> 0x08a9 }
                    r7.append(r3)     // Catch:{ Exception -> 0x08a9 }
                    java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x08a9 }
                    r4.putString(r14, r7)     // Catch:{ Exception -> 0x08a9 }
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x08a9 }
                    r7.<init>()     // Catch:{ Exception -> 0x08a9 }
                    r7.append(r0)     // Catch:{ Exception -> 0x08a9 }
                    r10 = 47
                    r7.append(r10)     // Catch:{ Exception -> 0x08a9 }
                    r7.append(r3)     // Catch:{ Exception -> 0x08a9 }
                    java.lang.String r3 = r7.toString()     // Catch:{ Exception -> 0x08a9 }
                    net.imedicaldoctor.imd.Data.CompressHelper r7 = r1     // Catch:{ Exception -> 0x08a9 }
                    java.lang.String r10 = r4.getString(r6)     // Catch:{ Exception -> 0x08a9 }
                    java.util.ArrayList r6 = r7.Z0(r6, r10)     // Catch:{ Exception -> 0x08a9 }
                    int r7 = r6.size()     // Catch:{ Exception -> 0x08a9 }
                    r10 = 1
                    if (r7 != r10) goto L_0x08fd
                    r10 = 0
                    java.lang.Object r6 = r6.get(r10)     // Catch:{ Exception -> 0x08a9 }
                    android.os.Bundle r6 = (android.os.Bundle) r6     // Catch:{ Exception -> 0x08a9 }
                    net.imedicaldoctor.imd.Data.CompressHelper r7 = r1     // Catch:{ Exception -> 0x08a9 }
                    java.io.File r10 = new java.io.File     // Catch:{ Exception -> 0x08a9 }
                    java.lang.String r6 = r6.getString(r14)     // Catch:{ Exception -> 0x08a9 }
                    r10.<init>(r6)     // Catch:{ Exception -> 0x08a9 }
                    r7.k(r10)     // Catch:{ Exception -> 0x08a9 }
                L_0x08fd:
                    java.lang.String r2 = r4.getString(r2)     // Catch:{ Exception -> 0x08a9 }
                    r14 = r4
                    goto L_0x0914
                L_0x0903:
                    r0 = move-exception
                    r36 = r7
                    goto L_0x0677
                L_0x0908:
                    r36 = r7
                    r7 = 0
                    java.lang.String r2 = "Not Found info.vbe"
                    net.imedicaldoctor.imd.iMDLogger.j(r12, r2)     // Catch:{ Exception -> 0x08a9 }
                    r14 = r7
                    r3 = r11
                    r2 = r27
                L_0x0914:
                    java.lang.String r4 = "&apos;"
                    java.lang.String r6 = "'"
                    java.lang.String r2 = r2.replace(r4, r6)     // Catch:{ Exception -> 0x08a9 }
                    java.lang.String r4 = "&amp;"
                    java.lang.String r6 = "&"
                    java.lang.String r2 = r2.replace(r4, r6)     // Catch:{ Exception -> 0x08a9 }
                    net.imedicaldoctor.imd.Fragments.InstallingFragment r4 = net.imedicaldoctor.imd.Fragments.InstallingFragment.this     // Catch:{ Exception -> 0x08a9 }
                    java.lang.String r29 = "Installing"
                    int r32 = r42.size()     // Catch:{ Exception -> 0x08a9 }
                    java.lang.String r33 = ""
                    r28 = r4
                    r30 = r2
                    r31 = r23
                    android.os.Bundle r4 = r28.w3(r29, r30, r31, r32, r33)     // Catch:{ Exception -> 0x08a9 }
                    r15.onNext(r4)     // Catch:{ Exception -> 0x08a9 }
                    net.imedicaldoctor.imd.Decompress r4 = new net.imedicaldoctor.imd.Decompress     // Catch:{ Exception -> 0x08a9 }
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x08a9 }
                    r6.<init>()     // Catch:{ Exception -> 0x08a9 }
                    r6.append(r0)     // Catch:{ Exception -> 0x08a9 }
                    r7 = r21
                    r6.append(r7)     // Catch:{ Exception -> 0x0971 }
                    java.lang.String r0 = r6.toString()     // Catch:{ Exception -> 0x0971 }
                    net.imedicaldoctor.imd.Fragments.InstallingFragment r6 = net.imedicaldoctor.imd.Fragments.InstallingFragment.this     // Catch:{ Exception -> 0x0971 }
                    androidx.fragment.app.FragmentActivity r6 = r6.r()     // Catch:{ Exception -> 0x0971 }
                    r4.<init>(r8, r0, r6)     // Catch:{ Exception -> 0x0971 }
                    net.imedicaldoctor.imd.Fragments.InstallingFragment r0 = net.imedicaldoctor.imd.Fragments.InstallingFragment.this     // Catch:{ Exception -> 0x0971 }
                    java.lang.String unused = r0.T4 = r8     // Catch:{ Exception -> 0x0971 }
                    java.lang.String r0 = r4.g(r15, r2)     // Catch:{ Exception -> 0x0971 }
                    int r2 = r3.length()     // Catch:{ Exception -> 0x0971 }
                    if (r2 <= 0) goto L_0x0974
                    net.imedicaldoctor.imd.Fragments.InstallingFragment r2 = net.imedicaldoctor.imd.Fragments.InstallingFragment.this     // Catch:{ Exception -> 0x0971 }
                    java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x0971 }
                    r4.<init>(r3)     // Catch:{ Exception -> 0x0971 }
                    r2.y3(r4)     // Catch:{ Exception -> 0x0971 }
                    goto L_0x0974
                L_0x0971:
                    r0 = move-exception
                    goto L_0x09e7
                L_0x0974:
                    boolean r2 = r0.equals(r5)     // Catch:{ Exception -> 0x0971 }
                    if (r2 == 0) goto L_0x098c
                    net.imedicaldoctor.imd.Data.CompressHelper r0 = r1     // Catch:{ Exception -> 0x0971 }
                    r0.j(r8)     // Catch:{ Exception -> 0x0971 }
                    if (r14 == 0) goto L_0x0986
                    net.imedicaldoctor.imd.Fragments.InstallingFragment r0 = net.imedicaldoctor.imd.Fragments.InstallingFragment.this     // Catch:{ Exception -> 0x0971 }
                L_0x0983:
                    r0.x3(r14)     // Catch:{ Exception -> 0x0971 }
                L_0x0986:
                    r10 = r16
                    r4 = r17
                    goto L_0x06fa
                L_0x098c:
                    boolean r0 = r0.equals(r9)     // Catch:{ Exception -> 0x0971 }
                    if (r0 == 0) goto L_0x09c7
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0971 }
                    r0.<init>()     // Catch:{ Exception -> 0x0971 }
                    r0.append(r8)     // Catch:{ Exception -> 0x0971 }
                    r0.append(r13)     // Catch:{ Exception -> 0x0971 }
                    java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0971 }
                    net.imedicaldoctor.imd.iMDLogger.j(r12, r0)     // Catch:{ Exception -> 0x0971 }
                    net.imedicaldoctor.imd.Fragments.InstallingFragment r0 = net.imedicaldoctor.imd.Fragments.InstallingFragment.this     // Catch:{ Exception -> 0x0971 }
                    r2 = 1
                    boolean unused = r0.Q4 = r2     // Catch:{ Exception -> 0x0971 }
                    net.imedicaldoctor.imd.Fragments.InstallingFragment r0 = net.imedicaldoctor.imd.Fragments.InstallingFragment.this     // Catch:{ Exception -> 0x0971 }
                    java.lang.String r29 = "Installing"
                    int r32 = r42.size()     // Catch:{ Exception -> 0x0971 }
                    java.lang.String r33 = "There is no space available. Please free up some space and open app again"
                    r28 = r0
                    r30 = r27
                    r31 = r23
                    android.os.Bundle r0 = r28.w3(r29, r30, r31, r32, r33)     // Catch:{ Exception -> 0x0971 }
                    r15.onNext(r0)     // Catch:{ Exception -> 0x0971 }
                    net.imedicaldoctor.imd.Fragments.InstallingFragment r0 = net.imedicaldoctor.imd.Fragments.InstallingFragment.this     // Catch:{ Exception -> 0x0971 }
                    r0.g3()     // Catch:{ Exception -> 0x0971 }
                    goto L_0x0986
                L_0x09c7:
                    net.imedicaldoctor.imd.Data.CompressHelper r0 = r1     // Catch:{ Exception -> 0x0971 }
                    r0.j(r8)     // Catch:{ Exception -> 0x0971 }
                    if (r14 == 0) goto L_0x0986
                    net.imedicaldoctor.imd.Fragments.InstallingFragment r0 = net.imedicaldoctor.imd.Fragments.InstallingFragment.this     // Catch:{ Exception -> 0x0971 }
                    goto L_0x0983
                L_0x09d1:
                    r0 = move-exception
                L_0x09d2:
                    r37 = r10
                    goto L_0x0677
                L_0x09d6:
                    r0 = move-exception
                L_0x09d7:
                    r20 = r7
                    goto L_0x09d2
                L_0x09da:
                    r0 = move-exception
                    r25 = r4
                    goto L_0x09d7
                L_0x09de:
                    r0 = move-exception
                    r15 = r47
                    r42 = r3
                    r35 = r8
                    goto L_0x01d9
                L_0x09e7:
                    com.google.firebase.crashlytics.FirebaseCrashlytics r2 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()
                    r2.g(r0)
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r2 = "error in extracting "
                    r0.append(r2)
                    r2 = r27
                    r0.append(r2)
                    java.lang.String r0 = r0.toString()
                    java.lang.String r2 = "Installing"
                    android.util.Log.e(r2, r0)
                    goto L_0x0986
                L_0x0a08:
                    net.imedicaldoctor.imd.Fragments.InstallingFragment r3 = net.imedicaldoctor.imd.Fragments.InstallingFragment.this
                    java.lang.String unused = r3.T4 = r8
                    r4 = r17
                    r3 = r35
                    java.lang.String r2 = r2.replace(r3, r4)
                    r10 = r16
                    r6 = r34
                    java.lang.String r2 = r2.replace(r6, r10)
                    java.lang.String r8 = r8.replace(r3, r4)
                    java.lang.String r8 = r8.replace(r6, r10)
                    net.imedicaldoctor.imd.Fragments.InstallingFragment r14 = net.imedicaldoctor.imd.Fragments.InstallingFragment.this
                    int r32 = r42.size()
                    java.lang.String r33 = ""
                    java.lang.String r29 = "Installing"
                    r28 = r14
                    r30 = r2
                    r31 = r23
                    android.os.Bundle r14 = r28.w3(r29, r30, r31, r32, r33)
                    r15.onNext(r14)
                    net.imedicaldoctor.imd.Decompress r14 = new net.imedicaldoctor.imd.Decompress
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    r3.append(r0)
                    r3.append(r7)
                    java.lang.String r0 = r3.toString()
                    net.imedicaldoctor.imd.Fragments.InstallingFragment r3 = net.imedicaldoctor.imd.Fragments.InstallingFragment.this
                    androidx.fragment.app.FragmentActivity r3 = r3.r()
                    r14.<init>(r8, r0, r3)
                    net.imedicaldoctor.imd.Fragments.InstallingFragment r0 = net.imedicaldoctor.imd.Fragments.InstallingFragment.this
                    androidx.fragment.app.FragmentActivity r0 = r0.r()
                    java.lang.String r0 = r14.h(r15, r2, r0)
                    boolean r3 = r0.equals(r5)
                    if (r3 == 0) goto L_0x0a68
                    goto L_0x03a9
                L_0x0a68:
                    boolean r0 = r0.equals(r9)
                    if (r0 == 0) goto L_0x03a9
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    r0.append(r8)
                    r0.append(r13)
                    java.lang.String r0 = r0.toString()
                    net.imedicaldoctor.imd.iMDLogger.j(r12, r0)
                    net.imedicaldoctor.imd.Fragments.InstallingFragment r0 = net.imedicaldoctor.imd.Fragments.InstallingFragment.this
                    r3 = 1
                    boolean unused = r0.Q4 = r3
                    net.imedicaldoctor.imd.Fragments.InstallingFragment r0 = net.imedicaldoctor.imd.Fragments.InstallingFragment.this
                    int r32 = r42.size()
                    java.lang.String r33 = "There is no space available. Please free up some space and open app again"
                    java.lang.String r29 = "Installing"
                    r28 = r0
                    r30 = r2
                    r31 = r23
                    android.os.Bundle r0 = r28.w3(r29, r30, r31, r32, r33)
                    r15.onNext(r0)
                    net.imedicaldoctor.imd.Fragments.InstallingFragment r0 = net.imedicaldoctor.imd.Fragments.InstallingFragment.this
                    r0.g3()
                    goto L_0x03a9
                L_0x0aa4:
                    int r0 = r23 + 1
                    r2 = r0
                    r17 = r4
                    r16 = r10
                    r21 = r19
                    r4 = r22
                    r8 = r35
                    r14 = r36
                    r23 = r37
                    r27 = r38
                    r3 = r42
                    r19 = r11
                    r11 = r26
                    r26 = r24
                    r24 = r25
                    r25 = r39
                    goto L_0x0140
                L_0x0ac5:
                    r15 = r47
                    r47.onComplete()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.InstallingFragment.AnonymousClass1.a(io.reactivex.rxjava3.core.ObservableEmitter):void");
            }
        }).h6(Schedulers.e()).s4(AndroidSchedulers.e());
        final AnonymousClass2 r3 = new DisposableObserver<Bundle>() {
            /* renamed from: c */
            public void onNext(@NonNull Bundle bundle) {
                if (bundle.containsKey("progress")) {
                    String string = bundle.getString("labelText");
                    String string2 = bundle.getString("progress");
                    TextView n3 = InstallingFragment.this.I4;
                    n3.setText(string + " ( " + string2 + "% )");
                    return;
                }
                String string3 = bundle.getString("error");
                int i2 = bundle.getInt("current");
                int i3 = bundle.getInt("total");
                String string4 = bundle.getString("dbName");
                InstallingFragment.this.H4.setText(bundle.getString("labelText"));
                InstallingFragment.this.I4.setText(string4);
                InstallingFragment.this.J4.setMax(i3);
                InstallingFragment.this.J4.setProgress(i2 + 1);
                if (string3 != null && string3.length() != 0 && InstallingFragment.this.Q4) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(InstallingFragment.this.r(), R.style.f2185alertDialogTheme);
                    builder.setTitle("Error Occured in " + string4).l(string3).y("Ok . Continue", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            boolean unused = InstallingFragment.this.Q4 = false;
                        }
                    }).p("Close App", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            Process.killProcess(Process.myPid());
                        }
                    }).I();
                }
            }

            public void onComplete() {
                InstallingFragment.this.N4.cancel();
                LocalBroadcastManager.b(InstallingFragment.this.v3()).d(new Intent("reload"));
                InstallingFragment.this.N2();
            }

            public void onError(@NonNull Throwable th) {
                iMDLogger.f("InstallingFragment", "Error occured on installing : " + th.getMessage());
                th.printStackTrace();
                new AlertDialog.Builder(InstallingFragment.this.r(), R.style.f2185alertDialogTheme).setTitle("Error Occured in Extract").l(th.getLocalizedMessage()).y("Ok . Continue", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        InstallingFragment.this.N2();
                        LocalBroadcastManager.b(InstallingFragment.this.v3()).d(new Intent("reload"));
                    }
                }).I();
            }
        };
        s4.a(r3);
        this.R4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                r3.m();
                new AlertDialog.Builder(InstallingFragment.this.r(), R.style.f2185alertDialogTheme).setTitle("What do you want to do ?").l(InstallingFragment.this.T4).y("Delete This File", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        AnonymousClass3 r1 = AnonymousClass3.this;
                        compressHelper.j(InstallingFragment.this.T4);
                        Process.killProcess(Process.myPid());
                    }
                }).p("Just Close App", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        Process.killProcess(Process.myPid());
                    }
                }).I();
            }
        });
        this.S4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                InstallingFragment.this.N2();
            }
        });
        z3();
        builder.setView(inflate);
        return builder.create();
    }

    public byte[] u3(ZipFile zipFile, String str, Bundle bundle) {
        String str2;
        FileHeader fileHeader;
        try {
            Iterator<FileHeader> it2 = zipFile.y().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    str2 = null;
                    fileHeader = null;
                    break;
                }
                fileHeader = it2.next();
                String k2 = fileHeader.k();
                if (k2.endsWith("/" + str)) {
                    str2 = StringUtils.splitByWholeSeparator(k2, "/")[0];
                    break;
                }
            }
            if (str2 == null) {
                Log.e("findFileInZip", "Can't find " + str);
                return null;
            }
            if (bundle != null) {
                bundle.putString("Folder", str2);
            }
            iMDLogger.j("findFileInZip", "folder name is " + str2);
            ZipInputStream z = zipFile.z(fileHeader);
            byte[] b0 = Okio.e(Okio.u(z)).b0();
            z.close();
            return b0;
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            e2.printStackTrace();
            iMDLogger.f("findFileInZip", e2.getMessage() + " - " + e2);
            return null;
        }
    }

    public Activity v3() {
        Activity activity = this.P4;
        return activity == null ? r() : activity;
    }

    public Bundle w3(String str, String str2, int i2, int i3, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("labelText", str);
        bundle.putString("dbName", str2);
        bundle.putInt("current", i2);
        bundle.putInt("total", i3);
        bundle.putString("error", str3);
        return bundle;
    }

    public void x3(Bundle bundle) {
        BufferedSink d2;
        ArrayList arrayList = new ArrayList();
        arrayList.add("visualdx.png");
        arrayList.add("uptodate.png");
        arrayList.add("irandarou.png");
        String string = bundle.getString("IconName");
        String str = bundle.getString("Path") + "/" + string;
        if (arrayList.contains(string)) {
            if (new File(str).exists()) {
                new CompressHelper(r()).j(str);
            }
            try {
                InputStream open = r().getAssets().open(string);
                d2 = Okio.d(Okio.n(new File(str)));
                d2.y1(Okio.e(Okio.u(open)));
                d2.close();
                open.close();
                return;
            } catch (Exception e2) {
                FirebaseCrashlytics.d().g(e2);
                iMDLogger.f("replaceIcons", "Error in replacing icons " + str + " : " + e2);
                e2.printStackTrace();
                return;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        } else {
            return;
        }
        throw th;
    }

    public void z3() {
        Timer timer = new Timer();
        this.N4 = timer;
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                InstallingFragment.this.U4.obtainMessage(1).sendToTarget();
            }
        }, 0, 1000);
    }
}
