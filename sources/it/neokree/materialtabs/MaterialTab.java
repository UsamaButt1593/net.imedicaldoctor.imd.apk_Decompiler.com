package it.neokree.materialtabs;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import at.markushi.ui.RevealColorView;
import java.util.Locale;

@SuppressLint({"InflateParams", "ClickableViewAccessibility"})
public class MaterialTab<T extends TextView> implements View.OnTouchListener {
    private static final int k3 = 400;
    private static final int l3 = 500;
    private final ImageView X;
    private final ImageView X2;
    private final T Y;
    private Resources Y2;
    /* access modifiers changed from: private */
    public final RevealColorView Z;
    private MaterialTabListener Z2;
    private Drawable a3;
    private int b3;
    private int c3;
    /* access modifiers changed from: private */
    public int d3;
    private int e3;
    private boolean f3;
    private int g3;
    private final boolean h3;
    private float i3;
    /* access modifiers changed from: private */
    public Point j3;
    private final View s;

    public MaterialTab(Context context, tabBuilder tabbuilder) {
        this.i3 = context.getResources().getDisplayMetrics().density;
        this.Y2 = context.getResources();
        this.h3 = tabbuilder.e();
        RevealColorView revealColorView = null;
        View h2 = tabbuilder.h() != null ? tabbuilder.h() : null;
        this.s = h2;
        this.X = tabbuilder.b() != null ? tabbuilder.b() : null;
        this.Y = tabbuilder.d() != null ? tabbuilder.d() : null;
        this.Z = tabbuilder.a() != null ? tabbuilder.a() : revealColorView;
        this.X2 = tabbuilder.c();
        h2.setOnTouchListener(this);
        this.f3 = false;
        this.b3 = -1;
        this.c3 = -1;
    }

    private boolean e() {
        return this.Z != null;
    }

    private int g() {
        return (int) (this.i3 * 24.0f);
    }

    private int k() {
        String charSequence = this.Y.getText().toString();
        Rect rect = new Rect();
        this.Y.getPaint().getTextBounds(charSequence, 0, charSequence.length(), rect);
        return rect.width();
    }

    @SuppressLint({"NewApi"})
    private void p(int i2) {
        this.X.setImageAlpha(i2);
    }

    public void d() {
        T t = this.Y;
        if (t != null) {
            t.setTextColor(this.b3);
        }
        if (this.X != null) {
            p(255);
        }
        this.X2.setBackgroundColor(this.e3);
        this.f3 = true;
    }

    public void f() {
        T t = this.Y;
        if (t != null) {
            t.setTextColor(Color.argb(153, Color.red(this.b3), Color.green(this.b3), Color.blue(this.b3)));
        }
        if (this.X != null) {
            p(153);
        }
        this.X2.setBackgroundColor(this.Y2.getColor(17170445));
        this.f3 = false;
        MaterialTabListener materialTabListener = this.Z2;
        if (materialTabListener != null) {
            materialTabListener.a(this);
        }
    }

    public int h() {
        return this.g3;
    }

    public MaterialTabListener i() {
        return this.Z2;
    }

    public int j() {
        return this.h3 ? g() : k();
    }

    public View l() {
        return this.s;
    }

    public boolean m() {
        return this.f3;
    }

    public void n(int i2) {
        this.e3 = i2;
        this.b3 = i2;
        this.c3 = i2;
    }

    public MaterialTab o(Drawable drawable) {
        if (this.h3) {
            this.a3 = drawable;
            this.X.setImageDrawable(drawable);
            q(this.c3);
            return this;
        }
        throw new RuntimeException("You had set tabs without icons, uses text instead icons");
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        Point point = new Point();
        this.j3 = point;
        point.x = (int) motionEvent.getX();
        this.j3.y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            if (!e()) {
                this.s.setBackgroundColor(Color.argb(128, Color.red(this.e3), Color.green(this.e3), Color.blue(this.e3)));
            }
            return true;
        } else if (motionEvent.getAction() == 3) {
            if (!e()) {
                this.s.setBackgroundColor(this.d3);
            }
            return true;
        } else if (motionEvent.getAction() != 1) {
            return false;
        } else {
            if (!e()) {
                this.s.setBackgroundColor(this.d3);
            } else {
                RevealColorView revealColorView = this.Z;
                Point point2 = this.j3;
                revealColorView.reveal(point2.x, point2.y, Color.argb(128, Color.red(this.e3), Color.green(this.e3), Color.blue(this.e3)), 0, 400, new Animator.AnimatorListener() {
                    public void onAnimationCancel(Animator animator) {
                    }

                    public void onAnimationEnd(Animator animator) {
                        MaterialTab.this.Z.reveal(MaterialTab.this.j3.x, MaterialTab.this.j3.y, MaterialTab.this.d3, 0, 500, (Animator.AnimatorListener) null);
                    }

                    public void onAnimationRepeat(Animator animator) {
                    }

                    public void onAnimationStart(Animator animator) {
                    }
                });
            }
            MaterialTabListener materialTabListener = this.Z2;
            if (materialTabListener != null) {
                if (this.f3) {
                    materialTabListener.c(this);
                } else {
                    materialTabListener.b(this);
                }
            }
            if (!this.f3) {
                d();
            }
            return true;
        }
    }

    public void q(int i2) {
        this.c3 = i2;
        ImageView imageView = this.X;
        if (imageView != null) {
            imageView.setColorFilter(i2);
        }
    }

    public void r(int i2) {
        this.g3 = i2;
    }

    public void s(int i2) {
        this.d3 = i2;
        if (e()) {
            this.Z.setBackgroundColor(i2);
        } else {
            this.s.setBackgroundColor(i2);
        }
    }

    public MaterialTab t(MaterialTabListener materialTabListener) {
        this.Z2 = materialTabListener;
        return this;
    }

    public MaterialTab u(CharSequence charSequence) {
        if (!this.h3) {
            this.Y.setText(charSequence.toString().toUpperCase(Locale.US));
            return this;
        }
        throw new RuntimeException("You had set tabs with icons, uses icons instead text");
    }

    public void v(int i2) {
        this.b3 = i2;
        T t = this.Y;
        if (t != null) {
            t.setTextColor(i2);
        }
    }
}
