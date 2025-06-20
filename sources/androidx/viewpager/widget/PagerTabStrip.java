package androidx.viewpager.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;

public class PagerTabStrip extends PagerTitleStrip {
    private static final String E3 = "PagerTabStrip";
    private static final int F3 = 3;
    private static final int G3 = 6;
    private static final int H3 = 16;
    private static final int I3 = 32;
    private static final int J3 = 64;
    private static final int K3 = 1;
    private static final int L3 = 32;
    private boolean A3;
    private float B3;
    private float C3;
    private int D3;
    private int o3;
    private int p3;
    private int q3;
    private int r3;
    private int s3;
    private int t3;
    private final Paint u3;
    private final Rect v3;
    private int w3;
    private boolean x3;
    private boolean y3;
    private int z3;

    public PagerTabStrip(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: package-private */
    public void d(int i2, float f2, boolean z) {
        Rect rect = this.v3;
        int height = getHeight();
        int left = this.Y2.getLeft() - this.t3;
        int right = this.Y2.getRight() + this.t3;
        int i3 = height - this.p3;
        rect.set(left, i3, right, height);
        super.d(i2, f2, z);
        this.w3 = (int) (Math.abs(f2 - 0.5f) * 2.0f * 255.0f);
        rect.union(this.Y2.getLeft() - this.t3, i3, this.Y2.getRight() + this.t3, height);
        invalidate(rect);
    }

    public boolean getDrawFullUnderline() {
        return this.x3;
    }

    /* access modifiers changed from: package-private */
    public int getMinHeight() {
        return Math.max(super.getMinHeight(), this.s3);
    }

    @ColorInt
    public int getTabIndicatorColor() {
        return this.o3;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.Y2.getLeft() - this.t3;
        int right = this.Y2.getRight() + this.t3;
        this.u3.setColor((this.w3 << 24) | (this.o3 & ViewCompat.x));
        float f2 = (float) height;
        canvas.drawRect((float) left, (float) (height - this.p3), (float) right, f2, this.u3);
        if (this.x3) {
            this.u3.setColor((this.o3 & ViewCompat.x) | ViewCompat.y);
            canvas.drawRect((float) getPaddingLeft(), (float) (height - this.z3), (float) (getWidth() - getPaddingRight()), f2, this.u3);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewPager viewPager;
        int currentItem;
        int action = motionEvent.getAction();
        if (action != 0 && this.A3) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (action == 0) {
            this.B3 = x;
            this.C3 = y;
            this.A3 = false;
        } else if (action == 1) {
            if (x < ((float) (this.Y2.getLeft() - this.t3))) {
                viewPager = this.s;
                currentItem = viewPager.getCurrentItem() - 1;
            } else if (x > ((float) (this.Y2.getRight() + this.t3))) {
                viewPager = this.s;
                currentItem = viewPager.getCurrentItem() + 1;
            }
            viewPager.setCurrentItem(currentItem);
        } else if (action == 2 && (Math.abs(x - this.B3) > ((float) this.D3) || Math.abs(y - this.C3) > ((float) this.D3))) {
            this.A3 = true;
        }
        return true;
    }

    public void setBackgroundColor(@ColorInt int i2) {
        super.setBackgroundColor(i2);
        if (!this.y3) {
            this.x3 = (i2 & ViewCompat.y) == 0;
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (!this.y3) {
            this.x3 = drawable == null;
        }
    }

    public void setBackgroundResource(@DrawableRes int i2) {
        super.setBackgroundResource(i2);
        if (!this.y3) {
            this.x3 = i2 == 0;
        }
    }

    public void setDrawFullUnderline(boolean z) {
        this.x3 = z;
        this.y3 = true;
        invalidate();
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
        int i6 = this.q3;
        if (i5 < i6) {
            i5 = i6;
        }
        super.setPadding(i2, i3, i4, i5);
    }

    public void setTabIndicatorColor(@ColorInt int i2) {
        this.o3 = i2;
        this.u3.setColor(i2);
        invalidate();
    }

    public void setTabIndicatorColorResource(@ColorRes int i2) {
        setTabIndicatorColor(ContextCompat.g(getContext(), i2));
    }

    public void setTextSpacing(int i2) {
        int i3 = this.r3;
        if (i2 < i3) {
            i2 = i3;
        }
        super.setTextSpacing(i2);
    }

    public PagerTabStrip(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.u3 = paint;
        this.v3 = new Rect();
        this.w3 = 255;
        this.x3 = false;
        this.y3 = false;
        int i2 = this.j3;
        this.o3 = i2;
        paint.setColor(i2);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.p3 = (int) ((3.0f * f2) + 0.5f);
        this.q3 = (int) ((6.0f * f2) + 0.5f);
        this.r3 = (int) (64.0f * f2);
        this.t3 = (int) ((16.0f * f2) + 0.5f);
        this.z3 = (int) ((1.0f * f2) + 0.5f);
        this.s3 = (int) ((f2 * 32.0f) + 0.5f);
        this.D3 = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.X2.setFocusable(true);
        this.X2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ViewPager viewPager = PagerTabStrip.this.s;
                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
            }
        });
        this.Z2.setFocusable(true);
        this.Z2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ViewPager viewPager = PagerTabStrip.this.s;
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            }
        });
        if (getBackground() == null) {
            this.x3 = true;
        }
    }
}
