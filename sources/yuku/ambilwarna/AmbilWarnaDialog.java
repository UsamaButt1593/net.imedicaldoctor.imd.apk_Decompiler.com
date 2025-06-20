package yuku.ambilwarna;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;

public class AmbilWarnaDialog {

    /* renamed from: a  reason: collision with root package name */
    final AlertDialog f31912a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final boolean f31913b;

    /* renamed from: c  reason: collision with root package name */
    final OnAmbilWarnaListener f31914c;

    /* renamed from: d  reason: collision with root package name */
    final View f31915d;

    /* renamed from: e  reason: collision with root package name */
    final AmbilWarnaSquare f31916e;

    /* renamed from: f  reason: collision with root package name */
    final ImageView f31917f;

    /* renamed from: g  reason: collision with root package name */
    final ImageView f31918g;

    /* renamed from: h  reason: collision with root package name */
    final View f31919h;

    /* renamed from: i  reason: collision with root package name */
    final View f31920i;

    /* renamed from: j  reason: collision with root package name */
    final View f31921j;

    /* renamed from: k  reason: collision with root package name */
    final ImageView f31922k;

    /* renamed from: l  reason: collision with root package name */
    final ImageView f31923l;

    /* renamed from: m  reason: collision with root package name */
    final ViewGroup f31924m;

    /* renamed from: n  reason: collision with root package name */
    final float[] f31925n;
    int o;

    public interface OnAmbilWarnaListener {
        void a(AmbilWarnaDialog ambilWarnaDialog, int i2);

        void b(AmbilWarnaDialog ambilWarnaDialog);
    }

    public AmbilWarnaDialog(Context context, int i2, OnAmbilWarnaListener onAmbilWarnaListener) {
        this(context, i2, false, onAmbilWarnaListener);
    }

    private float i() {
        return (float) this.o;
    }

    /* access modifiers changed from: private */
    public int j() {
        return (Color.HSVToColor(this.f31925n) & ViewCompat.x) | (this.o << 24);
    }

    /* access modifiers changed from: private */
    public float l() {
        return this.f31925n[0];
    }

    private float m() {
        return this.f31925n[1];
    }

    private float n() {
        return this.f31925n[2];
    }

    /* access modifiers changed from: private */
    public void r(int i2) {
        this.o = i2;
    }

    /* access modifiers changed from: private */
    public void s(float f2) {
        this.f31925n[0] = f2;
    }

    /* access modifiers changed from: private */
    public void t(float f2) {
        this.f31925n[1] = f2;
    }

    /* access modifiers changed from: private */
    public void u(float f2) {
        this.f31925n[2] = f2;
    }

    /* access modifiers changed from: private */
    public void w() {
        this.f31921j.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.HSVToColor(this.f31925n), 0}));
    }

    public AlertDialog k() {
        return this.f31912a;
    }

    /* access modifiers changed from: protected */
    public void o() {
        float measuredHeight = (float) this.f31923l.getMeasuredHeight();
        float i2 = measuredHeight - ((i() * measuredHeight) / 255.0f);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f31918g.getLayoutParams();
        layoutParams.leftMargin = (int) ((((double) this.f31923l.getLeft()) - Math.floor((double) (this.f31918g.getMeasuredWidth() / 2))) - ((double) this.f31924m.getPaddingLeft()));
        layoutParams.topMargin = (int) ((((double) (((float) this.f31923l.getTop()) + i2)) - Math.floor((double) (this.f31918g.getMeasuredHeight() / 2))) - ((double) this.f31924m.getPaddingTop()));
        this.f31918g.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public void p() {
        float measuredHeight = ((float) this.f31915d.getMeasuredHeight()) - ((l() * ((float) this.f31915d.getMeasuredHeight())) / 360.0f);
        if (measuredHeight == ((float) this.f31915d.getMeasuredHeight())) {
            measuredHeight = 0.0f;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f31917f.getLayoutParams();
        layoutParams.leftMargin = (int) ((((double) this.f31915d.getLeft()) - Math.floor((double) (this.f31917f.getMeasuredWidth() / 2))) - ((double) this.f31924m.getPaddingLeft()));
        layoutParams.topMargin = (int) ((((double) (((float) this.f31915d.getTop()) + measuredHeight)) - Math.floor((double) (this.f31917f.getMeasuredHeight() / 2))) - ((double) this.f31924m.getPaddingTop()));
        this.f31917f.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public void q() {
        float m2 = m() * ((float) this.f31916e.getMeasuredWidth());
        float n2 = (1.0f - n()) * ((float) this.f31916e.getMeasuredHeight());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f31922k.getLayoutParams();
        layoutParams.leftMargin = (int) ((((double) (((float) this.f31916e.getLeft()) + m2)) - Math.floor((double) (this.f31922k.getMeasuredWidth() / 2))) - ((double) this.f31924m.getPaddingLeft()));
        layoutParams.topMargin = (int) ((((double) (((float) this.f31916e.getTop()) + n2)) - Math.floor((double) (this.f31922k.getMeasuredHeight() / 2))) - ((double) this.f31924m.getPaddingTop()));
        this.f31922k.setLayoutParams(layoutParams);
    }

    public void v() {
        this.f31912a.show();
    }

    public AmbilWarnaDialog(Context context, int i2, boolean z, OnAmbilWarnaListener onAmbilWarnaListener) {
        float[] fArr = new float[3];
        this.f31925n = fArr;
        this.f31913b = z;
        this.f31914c = onAmbilWarnaListener;
        i2 = !z ? i2 | ViewCompat.y : i2;
        Color.colorToHSV(i2, fArr);
        this.o = Color.alpha(i2);
        final View inflate = LayoutInflater.from(context).inflate(R.layout.f31957a, (ViewGroup) null);
        View findViewById = inflate.findViewById(R.id.f31955l);
        this.f31915d = findViewById;
        AmbilWarnaSquare ambilWarnaSquare = (AmbilWarnaSquare) inflate.findViewById(R.id.f31956m);
        this.f31916e = ambilWarnaSquare;
        this.f31917f = (ImageView) inflate.findViewById(R.id.f31946c);
        View findViewById2 = inflate.findViewById(R.id.f31949f);
        this.f31919h = findViewById2;
        View findViewById3 = inflate.findViewById(R.id.f31948e);
        this.f31920i = findViewById3;
        this.f31922k = (ImageView) inflate.findViewById(R.id.f31953j);
        this.f31924m = (ViewGroup) inflate.findViewById(R.id.f31954k);
        View findViewById4 = inflate.findViewById(R.id.f31950g);
        this.f31921j = findViewById4;
        ImageView imageView = (ImageView) inflate.findViewById(R.id.f31945b);
        this.f31918g = imageView;
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.f31944a);
        this.f31923l = imageView2;
        int i3 = 8;
        findViewById4.setVisibility(z ? 0 : 8);
        imageView.setVisibility(z ? 0 : 8);
        imageView2.setVisibility(z ? 0 : i3);
        ambilWarnaSquare.setHue(l());
        findViewById2.setBackgroundColor(i2);
        findViewById3.setBackgroundColor(i2);
        findViewById.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 2 && motionEvent.getAction() != 0 && motionEvent.getAction() != 1) {
                    return false;
                }
                float y = motionEvent.getY();
                float f2 = 0.0f;
                if (y < 0.0f) {
                    y = 0.0f;
                }
                if (y > ((float) AmbilWarnaDialog.this.f31915d.getMeasuredHeight())) {
                    y = ((float) AmbilWarnaDialog.this.f31915d.getMeasuredHeight()) - 0.001f;
                }
                float measuredHeight = 360.0f - ((360.0f / ((float) AmbilWarnaDialog.this.f31915d.getMeasuredHeight())) * y);
                if (measuredHeight != 360.0f) {
                    f2 = measuredHeight;
                }
                AmbilWarnaDialog.this.s(f2);
                AmbilWarnaDialog ambilWarnaDialog = AmbilWarnaDialog.this;
                ambilWarnaDialog.f31916e.setHue(ambilWarnaDialog.l());
                AmbilWarnaDialog.this.p();
                AmbilWarnaDialog ambilWarnaDialog2 = AmbilWarnaDialog.this;
                ambilWarnaDialog2.f31920i.setBackgroundColor(ambilWarnaDialog2.j());
                AmbilWarnaDialog.this.w();
                return true;
            }
        });
        if (z) {
            imageView2.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() != 2 && motionEvent.getAction() != 0 && motionEvent.getAction() != 1) {
                        return false;
                    }
                    float y = motionEvent.getY();
                    if (y < 0.0f) {
                        y = 0.0f;
                    }
                    if (y > ((float) AmbilWarnaDialog.this.f31923l.getMeasuredHeight())) {
                        y = ((float) AmbilWarnaDialog.this.f31923l.getMeasuredHeight()) - 0.001f;
                    }
                    int round = Math.round(255.0f - ((255.0f / ((float) AmbilWarnaDialog.this.f31923l.getMeasuredHeight())) * y));
                    AmbilWarnaDialog.this.r(round);
                    AmbilWarnaDialog.this.o();
                    AmbilWarnaDialog.this.f31920i.setBackgroundColor((round << 24) | (AmbilWarnaDialog.this.j() & ViewCompat.x));
                    return true;
                }
            });
        }
        ambilWarnaSquare.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 2 && motionEvent.getAction() != 0 && motionEvent.getAction() != 1) {
                    return false;
                }
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (x < 0.0f) {
                    x = 0.0f;
                }
                if (x > ((float) AmbilWarnaDialog.this.f31916e.getMeasuredWidth())) {
                    x = (float) AmbilWarnaDialog.this.f31916e.getMeasuredWidth();
                }
                if (y < 0.0f) {
                    y = 0.0f;
                }
                if (y > ((float) AmbilWarnaDialog.this.f31916e.getMeasuredHeight())) {
                    y = (float) AmbilWarnaDialog.this.f31916e.getMeasuredHeight();
                }
                AmbilWarnaDialog ambilWarnaDialog = AmbilWarnaDialog.this;
                ambilWarnaDialog.t((1.0f / ((float) ambilWarnaDialog.f31916e.getMeasuredWidth())) * x);
                AmbilWarnaDialog ambilWarnaDialog2 = AmbilWarnaDialog.this;
                ambilWarnaDialog2.u(1.0f - ((1.0f / ((float) ambilWarnaDialog2.f31916e.getMeasuredHeight())) * y));
                AmbilWarnaDialog.this.q();
                AmbilWarnaDialog ambilWarnaDialog3 = AmbilWarnaDialog.this;
                ambilWarnaDialog3.f31920i.setBackgroundColor(ambilWarnaDialog3.j());
                return true;
            }
        });
        AlertDialog create = new AlertDialog.Builder(context).setPositiveButton(17039370, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                AmbilWarnaDialog ambilWarnaDialog = AmbilWarnaDialog.this;
                OnAmbilWarnaListener onAmbilWarnaListener = ambilWarnaDialog.f31914c;
                if (onAmbilWarnaListener != null) {
                    onAmbilWarnaListener.a(ambilWarnaDialog, ambilWarnaDialog.j());
                }
            }
        }).setNegativeButton(17039360, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                AmbilWarnaDialog ambilWarnaDialog = AmbilWarnaDialog.this;
                OnAmbilWarnaListener onAmbilWarnaListener = ambilWarnaDialog.f31914c;
                if (onAmbilWarnaListener != null) {
                    onAmbilWarnaListener.b(ambilWarnaDialog);
                }
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
                AmbilWarnaDialog ambilWarnaDialog = AmbilWarnaDialog.this;
                OnAmbilWarnaListener onAmbilWarnaListener = ambilWarnaDialog.f31914c;
                if (onAmbilWarnaListener != null) {
                    onAmbilWarnaListener.b(ambilWarnaDialog);
                }
            }
        }).create();
        this.f31912a = create;
        create.setView(inflate, 0, 0, 0, 0);
        inflate.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                AmbilWarnaDialog.this.p();
                if (AmbilWarnaDialog.this.f31913b) {
                    AmbilWarnaDialog.this.o();
                }
                AmbilWarnaDialog.this.q();
                if (AmbilWarnaDialog.this.f31913b) {
                    AmbilWarnaDialog.this.w();
                }
                inflate.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
    }
}
