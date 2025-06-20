package net.imedicaldoctor.imd.Fragments.DRE;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.WebView;
import androidx.appcompat.app.AlertDialog;
import androidx.exifinterface.media.ExifInterface;
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
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.Gallery.GalleryActivity;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.iMDLogger;
import org.apache.commons.lang3.StringUtils;

public class DRETestViewerActivityFragment extends ViewerHelperFragment {
    public Bundle X4;
    public ArrayList<String> Y4;
    public ArrayList<Bundle> Z4;
    public ArrayList<Bundle> a5;
    public ArrayList<Bundle> b5;
    public int c5;
    public Bundle d5;
    public Date e5;
    public String f5;
    public boolean g5;

    /* access modifiers changed from: private */
    public void M4() {
        CompressHelper compressHelper = this.Q4;
        Bundle bundle = this.D4;
        ArrayList<Bundle> V = compressHelper.V(bundle, "Select * from images where questionId = " + this.b5.get(this.c5).getString("id"));
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
        this.Z4 = V;
    }

    /* access modifiers changed from: private */
    public void N4(ArrayList<String> arrayList) {
        Iterator<String> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            String next = it2.next();
            String h1 = CompressHelper.h1(this.D4, next, "media-E");
            if (new File(h1).exists()) {
                try {
                    byte[] w = this.Q4.w(CompressHelper.d2(new File(h1)), next, "127");
                    String h12 = CompressHelper.h1(this.D4, next, "base");
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
        this.Y4 = arrayList;
    }

    private void X4(String str) {
        ArrayList<String> arrayList = this.Y4;
        if ((arrayList == null && this.Z4 == null) || arrayList.size() + this.Z4.size() == 0) {
            CompressHelper.x2(r(), "There is no images in this document", 1);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<String> it2 = this.Y4.iterator();
        while (it2.hasNext()) {
            String next = it2.next();
            Bundle bundle = new Bundle();
            bundle.putString("ImagePath", CompressHelper.h1(this.D4, next, "base"));
            bundle.putString("Description", "");
            bundle.putString("id", next);
            arrayList2.add(bundle);
        }
        Iterator<Bundle> it3 = this.Z4.iterator();
        while (it3.hasNext()) {
            Bundle next2 = it3.next();
            Bundle bundle2 = new Bundle();
            bundle2.putString("ImagePath", CompressHelper.h1(this.D4, next2.getString("filename"), "base"));
            bundle2.putString("Description", next2.getString("title"));
            bundle2.putString("id", next2.getString("mediaId"));
            if (next2.getString("filename").endsWith(".mov")) {
                bundle2.putString("isVideo", "");
            }
            if (next2.getString("filename").endsWith(".mp4")) {
                bundle2.putString("isVideo", "");
            }
            arrayList2.add(bundle2);
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

    public void I4() {
        this.s4.findItem(R.id.f805action_previous).setEnabled(false);
        this.s4.findItem(R.id.f805action_previous).setIcon(R.drawable.L5);
    }

    public void J4() {
        this.s4.findItem(R.id.f803action_next).setEnabled(false);
        this.s4.findItem(R.id.f803action_next).setIcon(R.drawable.I5);
    }

    public void K4() {
        this.s4.findItem(R.id.f805action_previous).setEnabled(true);
        this.s4.findItem(R.id.f805action_previous).setIcon(R.drawable.J5);
    }

    public void L4() {
        this.s4.findItem(R.id.f803action_next).setEnabled(true);
        this.s4.findItem(R.id.f803action_next).setIcon(R.drawable.G5);
    }

    public String Q4(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ZZZ").format(date);
    }

    public String R2() {
        return null;
    }

    public String R4(String str) {
        if (str.equals(IcyHeaders.a3)) {
            return "الف";
        }
        if (str.equals(ExifInterface.Y4)) {
            return "ب";
        }
        if (str.equals(ExifInterface.Z4)) {
            return "ج";
        }
        if (str.equals("4")) {
            return "د";
        }
        if (str.equals("5")) {
            return "ه";
        }
        if (str.equals("6")) {
            return "خ";
        }
        if (str.equals("7")) {
            return "G";
        }
        return str.equals("8") ? "H" : str;
    }

    public void S4(final String str, final boolean z) {
        T2(new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:53:0x036d  */
            /* JADX WARNING: Removed duplicated region for block: B:54:0x0376  */
            /* JADX WARNING: Removed duplicated region for block: B:58:0x038e  */
            /* JADX WARNING: Removed duplicated region for block: B:59:0x03ac  */
            /* JADX WARNING: Removed duplicated region for block: B:61:0x03b0  */
            /* JADX WARNING: Removed duplicated region for block: B:64:0x03b7  */
            /* JADX WARNING: Removed duplicated region for block: B:65:0x03be  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r33 = this;
                    r0 = r33
                    net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment r1 = net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment.this
                    java.util.Date r2 = new java.util.Date
                    r2.<init>()
                    r1.e5 = r2
                    net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment r1 = net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment.this
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "سوال "
                    r2.append(r3)
                    net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment r3 = net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment.this
                    int r3 = r3.c5
                    int r3 = r3 + 1
                    r2.append(r3)
                    java.lang.String r3 = " از "
                    r2.append(r3)
                    net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment r3 = net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment.this
                    java.util.ArrayList<android.os.Bundle> r3 = r3.b5
                    int r3 = r3.size()
                    r2.append(r3)
                    java.lang.String r2 = r2.toString()
                    r1.F4 = r2
                    net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment r1 = net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment.this
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "answer-"
                    r2.append(r3)
                    net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment r3 = net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment.this
                    java.util.ArrayList<android.os.Bundle> r4 = r3.b5
                    int r3 = r3.c5
                    java.lang.Object r3 = r4.get(r3)
                    android.os.Bundle r3 = (android.os.Bundle) r3
                    java.lang.String r4 = "id"
                    java.lang.String r3 = r3.getString(r4)
                    r2.append(r3)
                    java.lang.String r2 = r2.toString()
                    r1.E4 = r2
                    java.lang.String r1 = r2
                    java.lang.String r2 = ""
                    if (r1 == 0) goto L_0x0064
                    goto L_0x0065
                L_0x0064:
                    r1 = r2
                L_0x0065:
                    net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment r3 = net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment.this
                    java.util.ArrayList<android.os.Bundle> r5 = r3.b5
                    int r3 = r3.c5
                    java.lang.Object r3 = r5.get(r3)
                    android.os.Bundle r3 = (android.os.Bundle) r3
                    java.lang.String r4 = r3.getString(r4)
                    java.lang.String r5 = "question"
                    java.lang.String r5 = r3.getString(r5)
                    net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment r6 = net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment.this
                    net.imedicaldoctor.imd.Data.CompressHelper r6 = r6.Q4
                    java.lang.String r7 = "127"
                    java.lang.String r5 = r6.B(r5, r4, r7)
                    java.lang.String r6 = "explanation"
                    java.lang.String r6 = r3.getString(r6)
                    if (r6 == 0) goto L_0x0096
                    net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment r8 = net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment.this
                    net.imedicaldoctor.imd.Data.CompressHelper r8 = r8.Q4
                    java.lang.String r6 = r8.B(r6, r4, r7)
                    goto L_0x0097
                L_0x0096:
                    r6 = r2
                L_0x0097:
                    java.lang.String r8 = "trainingTip"
                    java.lang.String r8 = r3.getString(r8)
                    if (r8 == 0) goto L_0x00a8
                    net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment r9 = net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment.this
                    net.imedicaldoctor.imd.Data.CompressHelper r9 = r9.Q4
                    java.lang.String r8 = r9.B(r8, r4, r7)
                    goto L_0x00a9
                L_0x00a8:
                    r8 = r2
                L_0x00a9:
                    java.lang.StringBuilder r9 = new java.lang.StringBuilder
                    r9.<init>()
                    java.lang.String r10 = "type"
                    java.lang.String r10 = r3.getString(r10)
                    r9.append(r10)
                    java.lang.String r10 = " - "
                    r9.append(r10)
                    java.lang.String r11 = "area"
                    java.lang.String r11 = r3.getString(r11)
                    r9.append(r11)
                    r9.append(r10)
                    java.lang.String r11 = "Month"
                    java.lang.String r11 = r3.getString(r11)
                    r9.append(r11)
                    r9.append(r10)
                    java.lang.String r10 = "Year"
                    java.lang.String r10 = r3.getString(r10)
                    r9.append(r10)
                    java.lang.String r9 = r9.toString()
                    net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment r10 = net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment.this
                    androidx.fragment.app.FragmentActivity r11 = r10.r()
                    java.lang.String r12 = "DREHeader.css"
                    java.lang.String r10 = r10.d4(r11, r12)
                    java.lang.StringBuilder r11 = new java.lang.StringBuilder
                    r11.<init>()
                    r11.append(r10)
                    net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment r10 = net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment.this
                    androidx.fragment.app.FragmentActivity r12 = r10.r()
                    java.lang.String r13 = "DREAnswer.css"
                    java.lang.String r10 = r10.d4(r12, r13)
                    r11.append(r10)
                    java.lang.String r10 = r11.toString()
                    java.lang.String r11 = "[size]"
                    java.lang.String r12 = "200"
                    java.lang.String r10 = r10.replace(r11, r12)
                    java.util.ArrayList r11 = new java.util.ArrayList
                    r11.<init>()
                    java.lang.String r12 = "otherMedias"
                    java.lang.String r12 = r3.getString(r12)
                    int r13 = r12.length()
                    if (r13 <= 0) goto L_0x012a
                    java.lang.String r13 = ","
                    java.lang.String[] r12 = org.apache.commons.lang3.StringUtils.splitByWholeSeparator(r12, r13)
                    java.util.Collections.addAll(r11, r12)
                L_0x012a:
                    net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment r12 = net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment.this
                    r12.N4(r11)
                    net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment r11 = net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment.this
                    r11.M4()
                    java.lang.String r11 = "corrAns"
                    java.lang.String r12 = r3.getString(r11)
                    net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment r13 = net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment.this
                    net.imedicaldoctor.imd.Data.CompressHelper r14 = r13.Q4
                    android.os.Bundle r13 = r13.D4
                    java.lang.StringBuilder r15 = new java.lang.StringBuilder
                    r15.<init>()
                    r16 = r6
                    java.lang.String r6 = "select * from answers where qId = "
                    r15.append(r6)
                    r15.append(r4)
                    java.lang.String r6 = r15.toString()
                    java.util.ArrayList r6 = r14.V(r13, r6)
                    java.lang.String r13 = "[correctID]"
                    java.lang.String r11 = r3.getString(r11)
                    java.lang.String r10 = r10.replace(r13, r11)
                    java.lang.String r11 = "[Question]"
                    java.lang.String r5 = r10.replace(r11, r5)
                    net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment r10 = net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment.this
                    boolean r10 = r10.g5
                    java.lang.String r11 = "correctPercentage"
                    r13 = 0
                    if (r10 != 0) goto L_0x0190
                    java.util.Iterator r10 = r6.iterator()
                L_0x0175:
                    boolean r15 = r10.hasNext()
                    if (r15 == 0) goto L_0x0190
                    java.lang.Object r15 = r10.next()
                    android.os.Bundle r15 = (android.os.Bundle) r15
                    java.lang.String r15 = r15.getString(r11)
                    java.lang.Long r15 = java.lang.Long.valueOf(r15)
                    long r17 = r15.longValue()
                    long r13 = r17 + r13
                    goto L_0x0175
                L_0x0190:
                    java.util.Iterator r6 = r6.iterator()
                    r10 = r2
                L_0x0195:
                    boolean r15 = r6.hasNext()
                    if (r15 == 0) goto L_0x02de
                    java.lang.Object r15 = r6.next()
                    android.os.Bundle r15 = (android.os.Bundle) r15
                    r17 = r6
                    java.lang.String r6 = "answerText"
                    java.lang.String r6 = r15.getString(r6)
                    r18 = r8
                    net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment r8 = net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment.this
                    net.imedicaldoctor.imd.Data.CompressHelper r8 = r8.Q4
                    java.lang.String r6 = r8.B(r6, r4, r7)
                    java.lang.String r8 = "row"
                    java.lang.String r8 = r15.getString(r8)
                    r19 = r4
                    net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment r4 = net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment.this
                    java.lang.String r4 = r4.R4(r8)
                    r20 = r7
                    net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment.this
                    boolean r7 = r7.g5
                    if (r7 != 0) goto L_0x01db
                    java.lang.String r7 = r15.getString(r11)
                    java.lang.Float r7 = java.lang.Float.valueOf(r7)
                    float r7 = r7.floatValue()
                    float r15 = (float) r13
                    float r7 = r7 / r15
                    int r7 = (int) r7
                    int r7 = r7 * 100
                    goto L_0x01dc
                L_0x01db:
                    r7 = -1
                L_0x01dc:
                    boolean r15 = r8.equals(r1)
                    if (r15 == 0) goto L_0x01ed
                    java.lang.String r15 = "<img id=\"false\" src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAANCAMAAACXZR4WAAAABGdBTUEAAK/INwWK6QAAABl0RVh0U29mdHdhcmUAQWRvYmUgSW1hZ2VSZWFkeXHJZTwAAABgUExURQAAANkAANwREffMzPCZmehmZuEzM/zu7uNERPW7u+ZVVfrd3d4iIut3dwAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAO4UQPoAAAABdFJOUwBA5thmAAAAUUlEQVR42mzPSQ7AIAwDQFzK2vb/321CLOQDuUQeIUekdJjxxM6DgCv7ugFCXWK5EJqL5BDNJi8w9Y69Z/POpYqsviYSfS6E/kXz7Kd//AIMAHTvAR54Dn9XAAAAAElFTkSuQmCC\">"
                    java.lang.String r21 = "checked=\"checked\""
                    r32 = r21
                    r21 = r11
                    r11 = r32
                    goto L_0x01f1
                L_0x01ed:
                    r15 = r2
                    r21 = r11
                    r11 = r15
                L_0x01f1:
                    boolean r22 = r8.equals(r12)
                    if (r22 == 0) goto L_0x01f9
                    java.lang.String r15 = "<img id=\"correct\" src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAANCAMAAACXZR4WAAAABGdBTUEAAK/INwWK6QAAABl0RVh0U29mdHdhcmUAQWRvYmUgSW1hZ2VSZWFkeXHJZTwAAABgUExURQCtACG9IVrOWnPOc5zWnLXWtQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAv7hYAAAAHdFJOU////////wAaSwNGAAAAQklEQVR42mzOwREAIAgDwaCR/kt2BBF05Lf3CdDnUNGfIHIHQYRGdwbQjHYCuCyaAWELLPYVpvcsj+OP8X993RRgAK2vA9pkmd9zAAAAAElFTkSuQmCC\">"
                L_0x01f9:
                    r22 = r13
                    java.lang.String r13 = ");\">"
                    java.lang.String r14 = "\" onclick=\"answerClickedForStrikeout("
                    r24 = r3
                    java.lang.String r3 = ". </span></td><td><span id=\"AnswerText"
                    r25 = r2
                    java.lang.String r2 = "></td><td class=\"answerOptionNumber\"><span>"
                    r26 = r12
                    java.lang.String r12 = ")\" disable2=\"\" "
                    r27 = r1
                    java.lang.String r1 = "</td><td><input type=\"radio\" name=\"Qbank-Answer-Button-Group\" onclick=\"showExplanation("
                    r28 = r5
                    java.lang.String r5 = "\">"
                    r29 = r9
                    java.lang.String r9 = "\"><td width=\"16\" id=\"Qbank-Answer-Row-Image-"
                    r30 = r10
                    java.lang.String r10 = "<tr name=\"Qbank-Answer-Row-"
                    if (r7 == 0) goto L_0x0275
                    r31 = r7
                    net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment r7 = net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment.this
                    boolean r7 = r7.g5
                    if (r7 == 0) goto L_0x0226
                    goto L_0x0275
                L_0x0226:
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder
                    r7.<init>()
                    r7.append(r10)
                    r7.append(r8)
                    r7.append(r9)
                    r7.append(r8)
                    r7.append(r5)
                    r7.append(r15)
                    r7.append(r1)
                    r7.append(r8)
                    r7.append(r12)
                    r7.append(r11)
                    r7.append(r2)
                    r7.append(r4)
                    r7.append(r3)
                    r7.append(r8)
                    r7.append(r14)
                    r7.append(r8)
                    r7.append(r13)
                    r7.append(r6)
                    java.lang.String r1 = " <span style=\"display: inline;\" name=\"Qbank-Answer-Stats\">["
                    r7.append(r1)
                    r1 = r31
                    r7.append(r1)
                    java.lang.String r1 = "%]</span></span></td>"
                L_0x026d:
                    r7.append(r1)
                    java.lang.String r1 = r7.toString()
                    goto L_0x02b3
                L_0x0275:
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder
                    r7.<init>()
                    r7.append(r10)
                    r7.append(r8)
                    r7.append(r9)
                    r7.append(r8)
                    r7.append(r5)
                    r7.append(r15)
                    r7.append(r1)
                    r7.append(r8)
                    r7.append(r12)
                    r7.append(r11)
                    r7.append(r2)
                    r7.append(r4)
                    r7.append(r3)
                    r7.append(r8)
                    r7.append(r14)
                    r7.append(r8)
                    r7.append(r13)
                    r7.append(r6)
                    java.lang.String r1 = " <span style=\"display: inline;\" name=\"Qbank-Answer-Stats\"></span></span></td>"
                    goto L_0x026d
                L_0x02b3:
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    r3 = r30
                    r2.append(r3)
                    r2.append(r1)
                    java.lang.String r10 = r2.toString()
                    r6 = r17
                    r8 = r18
                    r4 = r19
                    r7 = r20
                    r11 = r21
                    r13 = r22
                    r3 = r24
                    r2 = r25
                    r12 = r26
                    r1 = r27
                    r5 = r28
                    r9 = r29
                    goto L_0x0195
                L_0x02de:
                    r27 = r1
                    r25 = r2
                    r24 = r3
                    r28 = r5
                    r18 = r8
                    r29 = r9
                    r3 = r10
                    r26 = r12
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    r1.append(r3)
                    java.lang.String r2 = "<p style=\"text-align:left;font-size:small;\">"
                    r1.append(r2)
                    r2 = r29
                    r1.append(r2)
                    java.lang.String r2 = "</p>"
                    r1.append(r2)
                    java.lang.String r1 = r1.toString()
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "<div id=\"answerSectionsa\"></div>"
                    r2.append(r3)
                    r2.append(r1)
                    java.lang.String r1 = r2.toString()
                    java.lang.String r2 = "[Answers]"
                    r3 = r28
                    java.lang.String r1 = r3.replace(r2, r1)
                    int r2 = r27.length()
                    java.lang.String r3 = "</b>"
                    java.lang.String r4 = "[Correct]"
                    if (r2 != 0) goto L_0x034c
                    net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment r2 = net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment.this
                    r5 = r26
                    java.lang.String r2 = r2.R4(r5)
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder
                    r5.<init>()
                    java.lang.String r6 = "<span id=\"resultstatement\" style=\"display: inline;\"> جواب صحیح :  <b class=\"greenFont\">"
                L_0x033a:
                    r5.append(r6)
                    r5.append(r2)
                    r5.append(r3)
                    java.lang.String r2 = r5.toString()
                L_0x0347:
                    java.lang.String r1 = r1.replace(r4, r2)
                    goto L_0x0367
                L_0x034c:
                    r5 = r26
                    r2 = r27
                    boolean r2 = r2.equals(r5)
                    if (r2 == 0) goto L_0x0359
                    java.lang.String r2 = "<span class=\"greenFont\">درست</span>"
                    goto L_0x0347
                L_0x0359:
                    net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment r2 = net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment.this
                    java.lang.String r2 = r2.R4(r5)
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder
                    r5.<init>()
                    java.lang.String r6 = "<span class=\"redFont\">نادرست</span>. </span><span id=\"resultstatement\" style=\"display: inline;\"> جواب صحیح :  <b class=\"greenFont\">"
                    goto L_0x033a
                L_0x0367:
                    net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment r2 = net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment.this
                    boolean r2 = r2.g5
                    if (r2 == 0) goto L_0x0376
                    java.lang.String r2 = "<div>[CorrectPercent]% درست پاسخ دادند</div>"
                    r3 = r25
                    java.lang.String r1 = r1.replace(r2, r3)
                    goto L_0x0386
                L_0x0376:
                    r3 = r25
                    java.lang.String r2 = "CorrPerc"
                    r4 = r24
                    java.lang.String r2 = r4.getString(r2)
                    java.lang.String r4 = "[CorrectPercent]"
                    java.lang.String r1 = r1.replace(r4, r2)
                L_0x0386:
                    if (r18 == 0) goto L_0x03ac
                    int r2 = r18.length()
                    if (r2 <= 0) goto L_0x03ac
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r4 = "<p style=\"background:yellow;\"><p><b>نکته آموزشی : </b></p><p style=\"background:yellow;\">"
                    r2.append(r4)
                    r8 = r18
                    r2.append(r8)
                    java.lang.String r4 = "</p></p>"
                    r2.append(r4)
                    r6 = r16
                    r2.append(r6)
                    java.lang.String r6 = r2.toString()
                    goto L_0x03ae
                L_0x03ac:
                    r6 = r16
                L_0x03ae:
                    if (r6 != 0) goto L_0x03b1
                    r6 = r3
                L_0x03b1:
                    net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment r2 = net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment.this
                    boolean r2 = r2.g5
                    if (r2 == 0) goto L_0x03be
                    java.lang.String r2 = "<div id=\"explanation\"><br><table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\"><tbody><tr><td width=\"50%\"><b>توضیحات:</b></td></tr></tbody></table>[Explanation]</div>"
                    java.lang.String r1 = r1.replace(r2, r3)
                    goto L_0x03c4
                L_0x03be:
                    java.lang.String r2 = "[Explanation]"
                    java.lang.String r1 = r1.replace(r2, r6)
                L_0x03c4:
                    java.lang.String r2 = ";font-family:"
                    java.lang.String r3 = ";disable-font-family:"
                    java.lang.String r1 = r1.replace(r2, r3)
                    java.lang.String r2 = "style=\"font-family:"
                    java.lang.String r3 = "style=\"disable-font-family:"
                    java.lang.String r1 = r1.replace(r2, r3)
                    net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment r2 = net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment.this
                    r2.A4 = r1
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.DRE.DRETestViewerActivityFragment.AnonymousClass3.run():void");
            }
        }, new Runnable() {
            public void run() {
                String str = DRETestViewerActivityFragment.this.p4;
                if (str == null || str.length() <= 0) {
                    DRETestViewerActivityFragment.this.U4();
                    if (z) {
                        DRETestViewerActivityFragment.this.f5 = "answerSectionsa";
                        return;
                    }
                    return;
                }
                DRETestViewerActivityFragment dRETestViewerActivityFragment = DRETestViewerActivityFragment.this;
                dRETestViewerActivityFragment.C4(dRETestViewerActivityFragment.p4);
            }
        });
    }

    public void T4() {
        T2(new Runnable() {
            public void run() {
                DRETestViewerActivityFragment.this.e5 = new Date();
                DRETestViewerActivityFragment.this.F4 = "سوال " + (DRETestViewerActivityFragment.this.c5 + 1) + " از " + DRETestViewerActivityFragment.this.b5.size();
                DRETestViewerActivityFragment dRETestViewerActivityFragment = DRETestViewerActivityFragment.this;
                StringBuilder sb = new StringBuilder();
                sb.append("question-");
                DRETestViewerActivityFragment dRETestViewerActivityFragment2 = DRETestViewerActivityFragment.this;
                sb.append(dRETestViewerActivityFragment2.b5.get(dRETestViewerActivityFragment2.c5).getString("id"));
                dRETestViewerActivityFragment.E4 = sb.toString();
                DRETestViewerActivityFragment dRETestViewerActivityFragment3 = DRETestViewerActivityFragment.this;
                Bundle bundle = dRETestViewerActivityFragment3.b5.get(dRETestViewerActivityFragment3.c5);
                String string = bundle.getString("id");
                Bundle bundle2 = DRETestViewerActivityFragment.this.d5;
                String str = "100";
                if (bundle2 != null) {
                    String string2 = bundle2.getString("id");
                    DRETestViewerActivityFragment dRETestViewerActivityFragment4 = DRETestViewerActivityFragment.this;
                    ArrayList<Bundle> V = dRETestViewerActivityFragment4.Q4.V(dRETestViewerActivityFragment4.D4, "Select * from logs where testId=" + string2 + " AND qid = " + string);
                    if (V == null || V.size() <= 0) {
                        if (DRETestViewerActivityFragment.this.d5.getString("done").equals(IcyHeaders.a3)) {
                            DRETestViewerActivityFragment.this.S4(str, false);
                            return;
                        }
                    } else if (!DRETestViewerActivityFragment.this.d5.getString("mode").equals("Testing")) {
                        DRETestViewerActivityFragment.this.S4(V.get(0).getString("selectedAnswer"), false);
                        return;
                    } else if (DRETestViewerActivityFragment.this.d5.getString("done").equals("0")) {
                        str = V.get(0).getString("selectedAnswer");
                    } else {
                        DRETestViewerActivityFragment.this.S4(V.get(0).getString("selectedAnswer"), false);
                        return;
                    }
                }
                String B = DRETestViewerActivityFragment.this.Q4.B(bundle.getString("question"), string, "127");
                String string3 = bundle.getString("explanation");
                if (string3 != null) {
                    DRETestViewerActivityFragment.this.Q4.B(string3, string, "127");
                }
                DRETestViewerActivityFragment dRETestViewerActivityFragment5 = DRETestViewerActivityFragment.this;
                String d4 = dRETestViewerActivityFragment5.d4(dRETestViewerActivityFragment5.r(), "DREHeader.css");
                StringBuilder sb2 = new StringBuilder();
                sb2.append(d4);
                DRETestViewerActivityFragment dRETestViewerActivityFragment6 = DRETestViewerActivityFragment.this;
                sb2.append(dRETestViewerActivityFragment6.d4(dRETestViewerActivityFragment6.r(), "DREQuestion.css"));
                String replace = sb2.toString().replace("[size]", "200");
                ArrayList arrayList = new ArrayList();
                String string4 = bundle.getString("otherMedias");
                if (string4.length() > 0) {
                    Collections.addAll(arrayList, StringUtils.splitByWholeSeparator(string4, ","));
                }
                DRETestViewerActivityFragment.this.N4(arrayList);
                DRETestViewerActivityFragment.this.M4();
                DRETestViewerActivityFragment dRETestViewerActivityFragment7 = DRETestViewerActivityFragment.this;
                ArrayList<Bundle> V2 = dRETestViewerActivityFragment7.Q4.V(dRETestViewerActivityFragment7.D4, "select * from answers where qId = " + string);
                String replace2 = replace.replace("[correctID]", bundle.getString("corrAns")).replace("[Question]", B);
                Iterator<Bundle> it2 = V2.iterator();
                String str2 = "";
                while (it2.hasNext()) {
                    Bundle next = it2.next();
                    String B2 = DRETestViewerActivityFragment.this.Q4.B(next.getString("answerText"), string, "127");
                    String string5 = next.getString("row");
                    String R4 = DRETestViewerActivityFragment.this.R4(string5);
                    str2 = str2 + ("<tr><td width=\"16\" id=\"Qbank-Answer-Row-Image-" + string5 + "\"></td><td><input type=\"radio\" name=\"Qbank-Answer-Button-Group\" onclick=\"answerChanged(" + string5 + ")\" " + (string5.equals(str) ? "checked=\"checked\"" : "") + "></td><td class=\"answerOptionNumber\"><span>" + R4 + ". </span></td><td><span id=\"AnswerText" + string5 + "\" onclick=\"answerClickedForStrikeout(" + string5 + ");\">" + B2 + "</span></td></tr>");
                }
                DRETestViewerActivityFragment.this.A4 = replace2.replace("[Answers]", str2 + "<p style=\"text-align:left;font-size:small;\">" + (bundle.getString("type") + " - " + bundle.getString("area") + " - " + bundle.getString("Month") + " - " + bundle.getString("Year")) + "</p>").replace(";font-family:", ";disable-font-family:").replace("style=\"font-family:", "style=\"disable-font-family:");
            }
        }, new Runnable() {
            public void run() {
                String str = DRETestViewerActivityFragment.this.p4;
                if (str == null || str.length() <= 0) {
                    DRETestViewerActivityFragment.this.U4();
                    return;
                }
                DRETestViewerActivityFragment dRETestViewerActivityFragment = DRETestViewerActivityFragment.this;
                dRETestViewerActivityFragment.C4(dRETestViewerActivityFragment.p4);
            }
        });
    }

    public View onFragmentBind(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.C4;
        if (view != null) {
            return view;
        }
        View inflate = layoutInflater.inflate(R.layout.f1255fragment_new_viewer, viewGroup, false);
        this.C4 = inflate;
        r4(inflate, bundle);
        this.g5 = this.Q4.V(this.D4, "Select CorrPerc from Questions limit 1") == null;
        if (y() == null) {
            return this.C4;
        }
        try {
            String str = this.A4;
            if (str != null) {
                if (str.length() == 0) {
                }
                m3();
                s4();
                return this.C4;
            }
            p4();
            o2(false);
            f3(R.menu.f1495uworld_test);
            G3();
            iMDLogger.f("Loading Document", this.E4);
            if (!this.E4.contains("-")) {
                this.b5 = this.Q4.V(this.D4, y().getString("Query"));
                this.c5 = y().getInt("QuestionIndex");
            } else {
                String[] split = this.E4.split("-");
                if (split[0].equals("test")) {
                    CompressHelper compressHelper = this.Q4;
                    Bundle bundle2 = this.D4;
                    this.d5 = compressHelper.s1(compressHelper.V(bundle2, "Select * from tests where id =" + split[1]));
                    CompressHelper compressHelper2 = this.Q4;
                    Bundle bundle3 = this.D4;
                    this.b5 = compressHelper2.V(bundle3, "Select * from Questions where id in (" + this.d5.getString("qIds") + ")");
                    this.c5 = Integer.valueOf(this.d5.getString("qIndex")).intValue();
                    if (y().containsKey("gotoQIndex")) {
                        this.c5 = y().getInt("gotoQIndex");
                    }
                } else if (split[0].equals("question")) {
                    CompressHelper compressHelper3 = this.Q4;
                    Bundle bundle4 = this.D4;
                    this.b5 = compressHelper3.V(bundle4, "Select * from Questions where id=" + split[1]);
                    this.c5 = 0;
                } else {
                    if (split[0].equals("answer")) {
                        CompressHelper compressHelper4 = this.Q4;
                        Bundle bundle5 = this.D4;
                        this.b5 = compressHelper4.V(bundle5, "Select * from Questions where id=" + split[1]);
                        this.c5 = 0;
                        S4((String) null, false);
                    }
                    m3();
                    s4();
                    return this.C4;
                }
            }
            T4();
            m3();
            s4();
        } catch (Exception e2) {
            e2.printStackTrace();
            B4(e2);
        }
        return this.C4;
    }

    public void U4() {
        O3(this.A4, CompressHelper.g1(this.D4, "base"));
        String str = this.F4;
        if (str != null) {
            this.L4.setTitle((CharSequence) str);
            n4(this.F4);
            M2();
        }
        o4();
        q4(this.L4.getMenu());
        Y4();
    }

    public void V4(String str) {
        String str2;
        String string = this.b5.get(this.c5).getString("id");
        String string2 = this.b5.get(this.c5).getString("corrAns");
        Date date = new Date();
        String Q4 = Q4(date);
        long time = (date.getTime() - this.e5.getTime()) / 1000;
        Bundle bundle = this.d5;
        String string3 = bundle != null ? bundle.getString("id") : "null";
        ArrayList<Bundle> V = this.Q4.V(this.D4, "Select * from logs where testId=" + string3 + " AND qid = " + string);
        if (V == null || V.size() <= 0) {
            str2 = "Insert into logs (id, qid, selectedAnswer, corrAnswer, answerDate, time, testId) values (null, " + string + ", " + str + ", " + string2 + ", '" + str + "', " + time + ", " + string3 + ")";
        } else {
            str2 = "Update logs set selectedAnswer = " + str + ", answerDate='" + Q4 + "', time=" + time + " where id=" + V.get(0).getString("id");
        }
        this.Q4.m(this.D4, str2);
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
                            str = W4(str);
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
            this.Y4 = arrayList;
            o4();
        } else if (split[0].equals("answer")) {
            String str4 = split[1];
            V4(str4);
            Bundle bundle = this.d5;
            if (bundle == null || !bundle.getString("mode").equals("Testing")) {
                S4(str4, true);
            }
        }
        return super.W3(consoleMessage);
    }

    public String W4(String str) {
        ArrayList arrayList = new ArrayList(Arrays.asList(StringUtils.splitByWholeSeparator(str, "/")));
        arrayList.remove(arrayList.size() - 1);
        return StringUtils.join((Iterable<?>) arrayList, "/");
    }

    public void Y4() {
        this.s4.findItem(R.id.f820action_stop).setVisible(false);
        if (this.d5 != null) {
            this.s4.findItem(R.id.f820action_stop).setVisible(true);
        }
        K4();
        L4();
        if (this.c5 <= 0) {
            I4();
        }
        if (this.c5 >= this.b5.size() - 1) {
            J4();
        }
    }

    public void Z3(WebView webView, String str) {
        this.G4.g("for (var i=0; i < document.images.length; i++) { document.images[i].onclick = function(e){window.location.href=\"image://\" + e.target.src;}}");
        this.G4.g("onBodyLoad();");
        String str2 = this.f5;
        if (str2 != null) {
            C3(str2);
            this.f5 = null;
        }
        super.Z3(webView, str);
    }

    public boolean e1(MenuItem menuItem) {
        int i2;
        int itemId = menuItem.getItemId();
        if (itemId == R.id.f796action_favorites) {
            new Bundle();
            String str = "Question " + this.b5.get(this.c5).getString("id") + " - " + this.b5.get(this.c5).getString("title");
            if (menuItem.getTitle().equals("Add Favorite")) {
                L2(str, this.E4);
                menuItem.setTitle("Remove Favorite");
                i2 = R.drawable.F5;
            } else {
                p3(this.E4);
                menuItem.setTitle("Add Favorite");
                i2 = R.drawable.D5;
            }
            menuItem.setIcon(i2);
            return true;
        } else if (itemId == R.id.f799action_gallery) {
            X4("asdfafdsaf");
            return true;
        } else {
            if (itemId == R.id.f805action_previous) {
                this.c5--;
                T4();
                Y4();
            }
            if (itemId == R.id.f803action_next) {
                this.c5++;
                T4();
                Y4();
                if (this.d5 != null) {
                    this.Q4.m(this.D4, "Update tests set qIndex=" + this.c5 + " where id=" + this.d5.getString("id"));
                }
            }
            if (itemId == R.id.f820action_stop) {
                new AlertDialog.Builder(r(), R.style.f2185alertDialogTheme).l("اتمام آزمون ؟").y("بله", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        DRETestViewerActivityFragment dRETestViewerActivityFragment = DRETestViewerActivityFragment.this;
                        if (dRETestViewerActivityFragment.d5 != null) {
                            CompressHelper compressHelper = dRETestViewerActivityFragment.Q4;
                            Bundle bundle = dRETestViewerActivityFragment.D4;
                            ArrayList<Bundle> V = compressHelper.V(bundle, "Select questions.id,selectedAnswer,corrAnswer,time  from Questions left outer join (select * from logs where testId=" + DRETestViewerActivityFragment.this.d5.getString("id") + ") as logs2 on questions.id=logs2.qid where questions.id in (" + DRETestViewerActivityFragment.this.d5.getString("qIds") + ")");
                            Iterator<Bundle> it2 = V.iterator();
                            float f2 = 0.0f;
                            while (it2.hasNext()) {
                                Bundle next = it2.next();
                                if (next.getString("selectedAnswer").length() != 0 && next.getString("selectedAnswer").equals(next.getString("corrAnswer"))) {
                                    f2 += 1.0f;
                                }
                            }
                            int size = (int) ((f2 / ((float) V.size())) * 100.0f);
                            DRETestViewerActivityFragment dRETestViewerActivityFragment2 = DRETestViewerActivityFragment.this;
                            CompressHelper compressHelper2 = dRETestViewerActivityFragment2.Q4;
                            Bundle bundle2 = dRETestViewerActivityFragment2.D4;
                            compressHelper2.m(bundle2, "Update tests set score='" + size + "', done=1 where id=" + DRETestViewerActivityFragment.this.d5.getString("id"));
                            DRETestViewerActivityFragment dRETestViewerActivityFragment3 = DRETestViewerActivityFragment.this;
                            CompressHelper compressHelper3 = dRETestViewerActivityFragment3.Q4;
                            Bundle bundle3 = dRETestViewerActivityFragment3.D4;
                            compressHelper3.A1(bundle3, "testresult-" + DRETestViewerActivityFragment.this.d5.getString("id"), (String[]) null, (String) null);
                        }
                    }
                }).p("خیر", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i2) {
                    }
                }).I();
            }
            return super.e1(menuItem);
        }
    }

    public void e3(Menu menu) {
    }

    public boolean v4() {
        return false;
    }

    public boolean y4(WebView webView, String str, String str2, String str3) {
        if (str2.equals("image")) {
            String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(str3, "/");
            X4(splitByWholeSeparator[splitByWholeSeparator.length - 1]);
            return true;
        }
        iMDLogger.j("Override", "Url : " + str + ", Scheme : " + str2 + ", Resource : " + str3);
        if (str3.contains("USMLEWorld-Question-Answer-Changed")) {
            this.G4.g("console.log(\"answer,,,,,\" + prevAnswerID);");
            return true;
        } else if (str3.contains("/2323")) {
            X4("soheilvb");
            return true;
        } else {
            if (str2.equals(Annotation.k3) || (str2.equals("http") && str3.contains("localhost:"))) {
                String[] splitByWholeSeparator2 = StringUtils.splitByWholeSeparator(str3, "/");
                X4(splitByWholeSeparator2[splitByWholeSeparator2.length - 1]);
            }
            return true;
        }
    }
}
