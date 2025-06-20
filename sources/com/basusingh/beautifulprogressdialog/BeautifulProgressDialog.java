package com.basusingh.beautifulprogressdialog;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.gif.GifDrawable;

public class BeautifulProgressDialog {
    public static final String o = "withImage";
    public static final String p = "withGIF";
    public static final String q = "withLottie";
    private static String r = null;
    private static boolean s = false;

    /* renamed from: a  reason: collision with root package name */
    private Uri f17385a;

    /* renamed from: b  reason: collision with root package name */
    LottieAnimationView f17386b;

    /* renamed from: c  reason: collision with root package name */
    private Activity f17387c;

    /* renamed from: d  reason: collision with root package name */
    private Dialog f17388d;

    /* renamed from: e  reason: collision with root package name */
    View f17389e;

    /* renamed from: f  reason: collision with root package name */
    CardView f17390f;

    /* renamed from: g  reason: collision with root package name */
    private int f17391g;

    /* renamed from: h  reason: collision with root package name */
    private int f17392h;

    /* renamed from: i  reason: collision with root package name */
    private int f17393i;

    /* renamed from: j  reason: collision with root package name */
    private int f17394j;

    /* renamed from: k  reason: collision with root package name */
    private int f17395k;

    /* renamed from: l  reason: collision with root package name */
    LinearLayout f17396l = ((LinearLayout) this.f17389e.findViewById(R.id.P1));

    /* renamed from: m  reason: collision with root package name */
    ImageView f17397m = ((ImageView) this.f17389e.findViewById(R.id.N1));

    /* renamed from: n  reason: collision with root package name */
    TextView f17398n = ((TextView) this.f17389e.findViewById(R.id.y2));

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x00ba, code lost:
        if (r7.equals(p) == false) goto L_0x00a9;
     */
    @android.annotation.SuppressLint({"ResourceAsColor"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public BeautifulProgressDialog(android.app.Activity r6, java.lang.String r7, java.lang.String r8) {
        /*
            r5 = this;
            java.lang.String r0 = "withLottie"
            r5.<init>()
            r5.f17387c = r6
            android.app.Dialog r1 = new android.app.Dialog
            int r2 = com.basusingh.beautifulprogressdialog.R.style.S3
            r1.<init>(r6, r2)
            r5.f17388d = r1
            r2 = 1
            r1.requestWindowFeature(r2)
            android.view.LayoutInflater r6 = android.view.LayoutInflater.from(r6)
            int r1 = com.basusingh.beautifulprogressdialog.R.layout.S
            r3 = 0
            android.view.View r6 = r6.inflate(r1, r3)
            r5.f17389e = r6
            android.app.Dialog r1 = r5.f17388d
            r1.setContentView(r6)
            android.app.Dialog r6 = r5.f17388d
            android.view.Window r6 = r6.getWindow()
            java.util.Objects.requireNonNull(r6)
            android.graphics.drawable.ColorDrawable r1 = new android.graphics.drawable.ColorDrawable
            r3 = 0
            r1.<init>(r3)
            r6.setBackgroundDrawable(r1)
            android.app.Dialog r6 = r5.f17388d
            com.basusingh.beautifulprogressdialog.BeautifulProgressDialog$1 r1 = new com.basusingh.beautifulprogressdialog.BeautifulProgressDialog$1
            r1.<init>()
            r6.setOnCancelListener(r1)
            android.app.Dialog r6 = r5.f17388d
            r6.setCanceledOnTouchOutside(r3)
            android.app.Dialog r6 = r5.f17388d
            r6.setCancelable(r3)
            r5.u()
            android.view.View r6 = r5.f17389e
            int r1 = com.basusingh.beautifulprogressdialog.R.id.p3
            android.view.View r6 = r6.findViewById(r1)
            androidx.cardview.widget.CardView r6 = (androidx.cardview.widget.CardView) r6
            r5.f17390f = r6
            r1 = 1077936128(0x40400000, float:3.0)
            r6.setElevation(r1)
            androidx.cardview.widget.CardView r6 = r5.f17390f
            r1 = 1097859072(0x41700000, float:15.0)
            r6.setRadius(r1)
            android.view.View r6 = r5.f17389e
            int r1 = com.basusingh.beautifulprogressdialog.R.id.P1
            android.view.View r6 = r6.findViewById(r1)
            android.widget.LinearLayout r6 = (android.widget.LinearLayout) r6
            r5.f17396l = r6
            android.view.View r6 = r5.f17389e
            int r1 = com.basusingh.beautifulprogressdialog.R.id.N1
            android.view.View r6 = r6.findViewById(r1)
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            r5.f17397m = r6
            android.view.View r6 = r5.f17389e
            int r1 = com.basusingh.beautifulprogressdialog.R.id.y2
            android.view.View r6 = r6.findViewById(r1)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r5.f17398n = r6
            android.view.View r6 = r5.f17389e
            int r1 = com.basusingh.beautifulprogressdialog.R.id.d2
            android.view.View r6 = r6.findViewById(r1)
            com.airbnb.lottie.LottieAnimationView r6 = (com.airbnb.lottie.LottieAnimationView) r6
            r5.f17386b = r6
            r1 = -1
            r6.setRepeatCount(r1)
            r = r7
            r7.hashCode()
            r6 = 8
            int r4 = r7.hashCode()
            switch(r4) {
                case 892179509: goto L_0x00bd;
                case 1355113758: goto L_0x00b4;
                case 1976074245: goto L_0x00ab;
                default: goto L_0x00a9;
            }
        L_0x00a9:
            r2 = -1
            goto L_0x00c7
        L_0x00ab:
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L_0x00b2
            goto L_0x00a9
        L_0x00b2:
            r2 = 2
            goto L_0x00c7
        L_0x00b4:
            java.lang.String r4 = "withGIF"
            boolean r7 = r7.equals(r4)
            if (r7 != 0) goto L_0x00c7
            goto L_0x00a9
        L_0x00bd:
            java.lang.String r2 = "withImage"
            boolean r7 = r7.equals(r2)
            if (r7 != 0) goto L_0x00c6
            goto L_0x00a9
        L_0x00c6:
            r2 = 0
        L_0x00c7:
            switch(r2) {
                case 0: goto L_0x00db;
                case 1: goto L_0x00db;
                case 2: goto L_0x00cb;
                default: goto L_0x00ca;
            }
        L_0x00ca:
            goto L_0x00e5
        L_0x00cb:
            android.widget.ImageView r7 = r5.f17397m
            r7.setVisibility(r6)
            com.airbnb.lottie.LottieAnimationView r7 = r5.f17386b
            r7.setVisibility(r3)
            com.airbnb.lottie.LottieAnimationView r7 = r5.f17386b
            r7.setRepeatCount(r1)
            goto L_0x00e5
        L_0x00db:
            android.widget.ImageView r7 = r5.f17397m
            r7.setVisibility(r3)
            com.airbnb.lottie.LottieAnimationView r7 = r5.f17386b
            r7.setVisibility(r6)
        L_0x00e5:
            if (r8 == 0) goto L_0x00ff
            android.widget.TextView r6 = r5.f17398n
            r6.setText(r8)
            android.widget.TextView r6 = r5.f17398n
            r6.setVisibility(r3)
            android.widget.LinearLayout r6 = r5.f17396l
            int r7 = r5.f17393i
            int r8 = r5.f17391g
            int r0 = r5.f17394j
            int r1 = r5.f17392h
            r6.setPadding(r7, r8, r0, r1)
            goto L_0x0124
        L_0x00ff:
            android.widget.TextView r7 = r5.f17398n
            r7.setVisibility(r6)
            android.widget.LinearLayout r6 = r5.f17396l
            int r7 = r5.f17395k
            r6.setPadding(r7, r7, r7, r7)
            java.lang.String r6 = r
            boolean r6 = r6.equalsIgnoreCase(r0)
            if (r6 != 0) goto L_0x011b
        L_0x0113:
            android.widget.LinearLayout r6 = r5.f17396l
            int r7 = r5.f17395k
            r6.setPadding(r7, r7, r7, r7)
            goto L_0x0124
        L_0x011b:
            boolean r6 = s
            if (r6 == 0) goto L_0x0113
            android.widget.LinearLayout r6 = r5.f17396l
            r6.setPadding(r3, r3, r3, r3)
        L_0x0124:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.basusingh.beautifulprogressdialog.BeautifulProgressDialog.<init>(android.app.Activity, java.lang.String, java.lang.String):void");
    }

    public static int b(int i2) {
        return (int) (((float) i2) * Resources.getSystem().getDisplayMetrics().density);
    }

    private void t(int i2) {
    }

    private void u() {
        this.f17391g = b(15);
        this.f17392h = b(15);
        this.f17393i = b(30);
        this.f17394j = b(30);
        this.f17395k = b(20);
    }

    public void a() {
        LottieAnimationView lottieAnimationView;
        if (r.equalsIgnoreCase(q) && (lottieAnimationView = this.f17386b) != null) {
            lottieAnimationView.k();
        }
        if (r.equalsIgnoreCase(p)) {
            try {
                ((GifDrawable) this.f17397m.getDrawable()).stop();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.f17388d.dismiss();
    }

    public boolean c() {
        return this.f17388d.isShowing();
    }

    public void d() {
        LinearLayout linearLayout;
        int i2;
        this.f17398n.setVisibility(8);
        if (r.equalsIgnoreCase(q) && s) {
            linearLayout = this.f17396l;
            i2 = 0;
        } else {
            linearLayout = this.f17396l;
            i2 = this.f17395k;
        }
        linearLayout.setPadding(i2, i2, i2, i2);
    }

    public void e(boolean z) {
        this.f17388d.setCancelable(false);
    }

    public void f(boolean z) {
        this.f17388d.setCanceledOnTouchOutside(z);
    }

    public void g(String str) {
        try {
            this.f17398n.setTypeface(Typeface.createFromAsset(this.f17387c.getAssets(), str));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void h(Uri uri) {
        this.f17385a = uri;
    }

    public void i(Bitmap bitmap) {
        this.f17397m.setImageBitmap(bitmap);
    }

    public void j(Drawable drawable) {
        this.f17397m.setImageDrawable(drawable);
    }

    public void k(Uri uri) {
        this.f17397m.setImageURI(uri);
    }

    @SuppressLint({"ResourceAsColor"})
    public void l(int i2) {
        this.f17390f.setCardBackgroundColor(i2);
    }

    public void m(float f2) {
        this.f17390f.setElevation(f2);
    }

    public void n(float f2) {
        this.f17390f.setRadius(f2);
    }

    public void o(boolean z) {
        LinearLayout linearLayout;
        int i2;
        s = z;
        if (z) {
            linearLayout = this.f17396l;
            i2 = 0;
        } else {
            linearLayout = this.f17396l;
            i2 = this.f17395k;
        }
        linearLayout.setPadding(i2, i2, i2, i2);
    }

    public void p(String str) {
        this.f17386b.setAnimation(str);
    }

    public void q(boolean z) {
        this.f17386b.setRepeatCount(z ? -1 : 0);
    }

    public void r(String str) {
        this.f17398n.setText(str);
        this.f17398n.setVisibility(0);
        this.f17396l.setPadding(this.f17393i, this.f17391g, this.f17394j, this.f17392h);
    }

    public void s(int i2) {
        this.f17398n.setTextColor(i2);
    }

    public void v(String str) {
        r = str;
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case 892179509:
                if (str.equals(o)) {
                    c2 = 0;
                    break;
                }
                break;
            case 1355113758:
                if (str.equals(p)) {
                    c2 = 1;
                    break;
                }
                break;
            case 1976074245:
                if (str.equals(q)) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
                this.f17397m.setVisibility(0);
                this.f17386b.setVisibility(8);
                return;
            case 2:
                this.f17397m.setVisibility(8);
                this.f17386b.setVisibility(0);
                return;
            default:
                return;
        }
    }

    public void w() {
        LottieAnimationView lottieAnimationView;
        String str = r;
        if (str == null) {
            Log.e("View Type", "Null");
            return;
        }
        if (str.equalsIgnoreCase(q) && (lottieAnimationView = this.f17386b) != null) {
            lottieAnimationView.x();
        }
        if (r.equalsIgnoreCase(p) && this.f17385a != null) {
            ((RequestBuilder) ((RequestBuilder) Glide.B(this.f17387c).g(this.f17385a).s(DiskCacheStrategy.f17908b)).w1(true)).B2(this.f17397m);
        }
        this.f17388d.show();
    }

    public void x(boolean z) {
        LinearLayout linearLayout;
        int i2 = 0;
        if (z) {
            this.f17398n.setVisibility(0);
            this.f17396l.setPadding(this.f17393i, this.f17391g, this.f17394j, this.f17392h);
            return;
        }
        this.f17398n.setVisibility(8);
        if (r.equalsIgnoreCase(q) && s) {
            linearLayout = this.f17396l;
        } else {
            linearLayout = this.f17396l;
            i2 = this.f17395k;
        }
        linearLayout.setPadding(i2, i2, i2, i2);
    }
}
