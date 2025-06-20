package net.imedicaldoctor.imd.Views;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import net.imedicaldoctor.imd.R;

public class SnackBar extends Dialog {
    float X = 14.0f;
    Activity X2;
    String Y;
    View Y2;
    View.OnClickListener Z;
    ButtonFlat Z2;
    int a3 = Color.parseColor("#333333");
    int b3 = Color.parseColor("#1E88E5");
    OnHideListener c3;
    private boolean d3 = false;
    /* access modifiers changed from: private */
    public int e3 = PathInterpolatorCompat.f16346d;
    Thread f3 = new Thread(new Runnable() {
        public void run() {
            try {
                Thread.sleep((long) SnackBar.this.e3);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            SnackBar.this.g3.sendMessage(new Message());
        }
    });
    Handler g3 = new Handler(new Handler.Callback() {
        public boolean handleMessage(Message message) {
            OnHideListener onHideListener = SnackBar.this.c3;
            if (onHideListener != null) {
                onHideListener.a();
            }
            SnackBar.this.dismiss();
            return false;
        }
    });
    String s;

    public interface OnHideListener {
        void a();
    }

    public SnackBar(Activity activity, String str) {
        super(activity, 16973839);
        this.X2 = activity;
        this.s = str;
    }

    public int c() {
        return this.e3;
    }

    public boolean d() {
        return this.d3;
    }

    public void dismiss() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.X2, R.anim.f21snackbar_hide_animation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                SnackBar.super.dismiss();
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        this.Y2.startAnimation(loadAnimation);
    }

    public void e(int i2) {
        this.a3 = i2;
        View view = this.Y2;
        if (view != null) {
            view.setBackgroundColor(i2);
        }
    }

    public void f(int i2) {
        this.b3 = i2;
        ButtonFlat buttonFlat = this.Z2;
        if (buttonFlat != null) {
            buttonFlat.setBackgroundColor(i2);
        }
    }

    public void g(int i2) {
        this.e3 = i2;
    }

    public void h(boolean z) {
        this.d3 = z;
    }

    public void i(float f2) {
        this.X = f2;
    }

    public void j(OnHideListener onHideListener) {
        this.c3 = onHideListener;
    }

    public void onBackPressed() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.f1398snackbar);
        setCanceledOnTouchOutside(false);
        ((TextView) findViewById(R.id.text)).setText(this.s);
        ((TextView) findViewById(R.id.text)).setTextSize(this.X);
        ButtonFlat buttonFlat = (ButtonFlat) findViewById(R.id.f859buttonflat);
        this.Z2 = buttonFlat;
        if (this.s == null || this.Z == null) {
            buttonFlat.setVisibility(8);
        } else {
            buttonFlat.setText(this.Y);
            this.Z2.setBackgroundColor(this.b3);
            this.Z2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    SnackBar.this.dismiss();
                    SnackBar.this.Z.onClick(view);
                }
            });
        }
        View findViewById = findViewById(R.id.f1077snackbar);
        this.Y2 = findViewById;
        findViewById.setBackgroundColor(this.a3);
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            dismiss();
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.X2.dispatchTouchEvent(motionEvent);
    }

    public void show() {
        super.show();
        this.Y2.setVisibility(0);
        this.Y2.startAnimation(AnimationUtils.loadAnimation(this.X2, R.anim.f22snackbar_show_animation));
        if (!this.d3) {
            this.f3.start();
        }
    }

    public SnackBar(Activity activity, String str, String str2, View.OnClickListener onClickListener) {
        super(activity, 16973839);
        this.X2 = activity;
        this.s = str;
        this.Y = str2;
        this.Z = onClickListener;
    }
}
