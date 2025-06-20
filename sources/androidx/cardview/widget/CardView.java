package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.cardview.R;

public class CardView extends FrameLayout {
    private static final int[] d3 = {16842801};
    private static final CardViewImpl e3;
    private boolean X2;
    int Y2;
    int Z2;
    final Rect a3;
    final Rect b3;
    private final CardViewDelegate c3;
    private boolean s;

    static {
        CardViewApi21Impl cardViewApi21Impl = new CardViewApi21Impl();
        e3 = cardViewApi21Impl;
        cardViewApi21Impl.j();
    }

    public CardView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    @NonNull
    public ColorStateList getCardBackgroundColor() {
        return e3.h(this.c3);
    }

    public float getCardElevation() {
        return e3.c(this.c3);
    }

    @Px
    public int getContentPaddingBottom() {
        return this.a3.bottom;
    }

    @Px
    public int getContentPaddingLeft() {
        return this.a3.left;
    }

    @Px
    public int getContentPaddingRight() {
        return this.a3.right;
    }

    @Px
    public int getContentPaddingTop() {
        return this.a3.top;
    }

    public float getMaxCardElevation() {
        return e3.g(this.c3);
    }

    public boolean getPreventCornerOverlap() {
        return this.X2;
    }

    public float getRadius() {
        return e3.d(this.c3);
    }

    public boolean getUseCompatPadding() {
        return this.s;
    }

    public void h(@Px int i2, @Px int i3, @Px int i4, @Px int i5) {
        this.a3.set(i2, i3, i4, i5);
        e3.i(this.c3);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        CardViewImpl cardViewImpl = e3;
        if (!(cardViewImpl instanceof CardViewApi21Impl)) {
            int mode = View.MeasureSpec.getMode(i2);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i2 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) cardViewImpl.l(this.c3)), View.MeasureSpec.getSize(i2)), mode);
            }
            int mode2 = View.MeasureSpec.getMode(i3);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i3 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) cardViewImpl.k(this.c3)), View.MeasureSpec.getSize(i3)), mode2);
            }
        }
        super.onMeasure(i2, i3);
    }

    public void setCardBackgroundColor(@ColorInt int i2) {
        e3.n(this.c3, ColorStateList.valueOf(i2));
    }

    public void setCardElevation(float f2) {
        e3.f(this.c3, f2);
    }

    public void setMaxCardElevation(float f2) {
        e3.o(this.c3, f2);
    }

    public void setMinimumHeight(int i2) {
        this.Z2 = i2;
        super.setMinimumHeight(i2);
    }

    public void setMinimumWidth(int i2) {
        this.Y2 = i2;
        super.setMinimumWidth(i2);
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
    }

    public void setPaddingRelative(int i2, int i3, int i4, int i5) {
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.X2) {
            this.X2 = z;
            e3.m(this.c3);
        }
    }

    public void setRadius(float f2) {
        e3.b(this.c3, f2);
    }

    public void setUseCompatPadding(boolean z) {
        if (this.s != z) {
            this.s = z;
            e3.e(this.c3);
        }
    }

    public CardView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.f3481g);
    }

    public void setCardBackgroundColor(@Nullable ColorStateList colorStateList) {
        e3.n(this.c3, colorStateList);
    }

    public CardView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Resources resources;
        int i3;
        ColorStateList valueOf;
        Rect rect = new Rect();
        this.a3 = rect;
        this.b3 = new Rect();
        AnonymousClass1 r3 = new CardViewDelegate() {

            /* renamed from: a  reason: collision with root package name */
            private Drawable f3512a;

            public void a(int i2, int i3, int i4, int i5) {
                CardView.this.b3.set(i2, i3, i4, i5);
                CardView cardView = CardView.this;
                Rect rect = cardView.a3;
                CardView.super.setPadding(i2 + rect.left, i3 + rect.top, i4 + rect.right, i5 + rect.bottom);
            }

            public void b(int i2, int i3) {
                CardView cardView = CardView.this;
                if (i2 > cardView.Y2) {
                    CardView.super.setMinimumWidth(i2);
                }
                CardView cardView2 = CardView.this;
                if (i3 > cardView2.Z2) {
                    CardView.super.setMinimumHeight(i3);
                }
            }

            public void c(Drawable drawable) {
                this.f3512a = drawable;
                CardView.this.setBackgroundDrawable(drawable);
            }

            public boolean d() {
                return CardView.this.getPreventCornerOverlap();
            }

            public boolean e() {
                return CardView.this.getUseCompatPadding();
            }

            public Drawable f() {
                return this.f3512a;
            }

            public View g() {
                return CardView.this;
            }
        };
        this.c3 = r3;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.f3498a, i2, R.style.f3495b);
        int i4 = R.styleable.f3501d;
        if (obtainStyledAttributes.hasValue(i4)) {
            valueOf = obtainStyledAttributes.getColorStateList(i4);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(d3);
            int color = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            if (fArr[2] > 0.5f) {
                resources = getResources();
                i3 = R.color.f3488b;
            } else {
                resources = getResources();
                i3 = R.color.f3487a;
            }
            valueOf = ColorStateList.valueOf(resources.getColor(i3));
        }
        ColorStateList colorStateList = valueOf;
        float dimension = obtainStyledAttributes.getDimension(R.styleable.f3502e, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(R.styleable.f3503f, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(R.styleable.f3504g, 0.0f);
        this.s = obtainStyledAttributes.getBoolean(R.styleable.f3506i, false);
        this.X2 = obtainStyledAttributes.getBoolean(R.styleable.f3505h, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.f3507j, 0);
        rect.left = obtainStyledAttributes.getDimensionPixelSize(R.styleable.f3509l, dimensionPixelSize);
        rect.top = obtainStyledAttributes.getDimensionPixelSize(R.styleable.f3511n, dimensionPixelSize);
        rect.right = obtainStyledAttributes.getDimensionPixelSize(R.styleable.f3510m, dimensionPixelSize);
        rect.bottom = obtainStyledAttributes.getDimensionPixelSize(R.styleable.f3508k, dimensionPixelSize);
        float f2 = dimension2 > dimension3 ? dimension2 : dimension3;
        this.Y2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.f3499b, 0);
        this.Z2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.f3500c, 0);
        obtainStyledAttributes.recycle();
        e3.a(r3, context, colorStateList, dimension, dimension2, f2);
    }
}
