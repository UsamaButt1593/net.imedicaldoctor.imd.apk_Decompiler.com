package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.ViewPager;
import java.lang.ref.WeakReference;
import java.util.Locale;

@ViewPager.DecorView
public class PagerTitleStrip extends ViewGroup {
    private static final int[] k3 = {16842804, 16842901, 16842904, 16842927};
    private static final int[] l3 = {16843660};
    private static final float m3 = 0.6f;
    private static final int n3 = 16;
    TextView X2;
    TextView Y2;
    TextView Z2;
    private int a3;
    float b3;
    private int c3;
    private int d3;
    private boolean e3;
    private boolean f3;
    private final PageListener g3;
    private WeakReference<PagerAdapter> h3;
    private int i3;
    int j3;
    ViewPager s;

    private class PageListener extends DataSetObserver implements ViewPager.OnPageChangeListener, ViewPager.OnAdapterChangeListener {

        /* renamed from: a  reason: collision with root package name */
        private int f16513a;

        PageListener() {
        }

        public void a(int i2, float f2, int i3) {
            if (f2 > 0.5f) {
                i2++;
            }
            PagerTitleStrip.this.d(i2, f2, false);
        }

        public void b(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
            PagerTitleStrip.this.b(pagerAdapter, pagerAdapter2);
        }

        public void c(int i2) {
            this.f16513a = i2;
        }

        public void d(int i2) {
            if (this.f16513a == 0) {
                PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
                pagerTitleStrip.c(pagerTitleStrip.s.getCurrentItem(), PagerTitleStrip.this.s.getAdapter());
                PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
                float f2 = pagerTitleStrip2.b3;
                if (f2 < 0.0f) {
                    f2 = 0.0f;
                }
                pagerTitleStrip2.d(pagerTitleStrip2.s.getCurrentItem(), f2, true);
            }
        }

        public void onChanged() {
            PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
            pagerTitleStrip.c(pagerTitleStrip.s.getCurrentItem(), PagerTitleStrip.this.s.getAdapter());
            PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
            float f2 = pagerTitleStrip2.b3;
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            pagerTitleStrip2.d(pagerTitleStrip2.s.getCurrentItem(), f2, true);
        }
    }

    private static class SingleLineAllCapsTransform extends SingleLineTransformationMethod {

        /* renamed from: a  reason: collision with root package name */
        private Locale f16515a;

        SingleLineAllCapsTransform(Context context) {
            this.f16515a = context.getResources().getConfiguration().locale;
        }

        public CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence transformation = super.getTransformation(charSequence, view);
            if (transformation != null) {
                return transformation.toString().toUpperCase(this.f16515a);
            }
            return null;
        }
    }

    public PagerTitleStrip(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private static void setSingleLineAllCaps(TextView textView) {
        textView.setTransformationMethod(new SingleLineAllCapsTransform(textView.getContext()));
    }

    public void a(int i2, float f2) {
        this.X2.setTextSize(i2, f2);
        this.Y2.setTextSize(i2, f2);
        this.Z2.setTextSize(i2, f2);
    }

    /* access modifiers changed from: package-private */
    public void b(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
        if (pagerAdapter != null) {
            pagerAdapter.u(this.g3);
            this.h3 = null;
        }
        if (pagerAdapter2 != null) {
            pagerAdapter2.m(this.g3);
            this.h3 = new WeakReference<>(pagerAdapter2);
        }
        ViewPager viewPager = this.s;
        if (viewPager != null) {
            this.a3 = -1;
            this.b3 = -1.0f;
            c(viewPager.getCurrentItem(), pagerAdapter2);
            requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public void c(int i2, PagerAdapter pagerAdapter) {
        int e2 = pagerAdapter != null ? pagerAdapter.e() : 0;
        this.e3 = true;
        CharSequence charSequence = null;
        this.X2.setText((i2 < 1 || pagerAdapter == null) ? null : pagerAdapter.g(i2 - 1));
        this.Y2.setText((pagerAdapter == null || i2 >= e2) ? null : pagerAdapter.g(i2));
        int i4 = i2 + 1;
        if (i4 < e2 && pagerAdapter != null) {
            charSequence = pagerAdapter.g(i4);
        }
        this.Z2.setText(charSequence);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((float) ((getWidth() - getPaddingLeft()) - getPaddingRight())) * 0.8f)), Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        this.X2.measure(makeMeasureSpec, makeMeasureSpec2);
        this.Y2.measure(makeMeasureSpec, makeMeasureSpec2);
        this.Z2.measure(makeMeasureSpec, makeMeasureSpec2);
        this.a3 = i2;
        if (!this.f3) {
            d(i2, this.b3, false);
        }
        this.e3 = false;
    }

    /* access modifiers changed from: package-private */
    public void d(int i2, float f2, boolean z) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8 = i2;
        float f4 = f2;
        if (i8 != this.a3) {
            c(i8, this.s.getAdapter());
        } else if (!z && f4 == this.b3) {
            return;
        }
        this.f3 = true;
        int measuredWidth = this.X2.getMeasuredWidth();
        int measuredWidth2 = this.Y2.getMeasuredWidth();
        int measuredWidth3 = this.Z2.getMeasuredWidth();
        int i9 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i10 = paddingRight + i9;
        int i11 = (width - (paddingLeft + i9)) - i10;
        float f5 = 0.5f + f4;
        if (f5 > 1.0f) {
            f5 -= 1.0f;
        }
        int i12 = ((width - i10) - ((int) (((float) i11) * f5))) - i9;
        int i13 = measuredWidth2 + i12;
        int baseline = this.X2.getBaseline();
        int baseline2 = this.Y2.getBaseline();
        int baseline3 = this.Z2.getBaseline();
        int max = Math.max(Math.max(baseline, baseline2), baseline3);
        int i14 = max - baseline;
        int i15 = max - baseline2;
        int i16 = max - baseline3;
        int i17 = measuredWidth3;
        int max2 = Math.max(Math.max(this.X2.getMeasuredHeight() + i14, this.Y2.getMeasuredHeight() + i15), this.Z2.getMeasuredHeight() + i16);
        int i18 = this.d3 & 112;
        if (i18 == 16) {
            i7 = (((height - paddingTop) - paddingBottom) - max2) / 2;
        } else if (i18 != 80) {
            i6 = i14 + paddingTop;
            i4 = i15 + paddingTop;
            i5 = paddingTop + i16;
            TextView textView = this.Y2;
            textView.layout(i12, i4, i13, textView.getMeasuredHeight() + i4);
            int min = Math.min(paddingLeft, (i12 - this.c3) - measuredWidth);
            TextView textView2 = this.X2;
            textView2.layout(min, i6, measuredWidth + min, textView2.getMeasuredHeight() + i6);
            int max3 = Math.max((width - paddingRight) - i17, i13 + this.c3);
            TextView textView3 = this.Z2;
            textView3.layout(max3, i5, max3 + i17, textView3.getMeasuredHeight() + i5);
            this.b3 = f2;
            this.f3 = false;
        } else {
            i7 = (height - paddingBottom) - max2;
        }
        i6 = i14 + i7;
        i4 = i15 + i7;
        i5 = i7 + i16;
        TextView textView4 = this.Y2;
        textView4.layout(i12, i4, i13, textView4.getMeasuredHeight() + i4);
        int min2 = Math.min(paddingLeft, (i12 - this.c3) - measuredWidth);
        TextView textView22 = this.X2;
        textView22.layout(min2, i6, measuredWidth + min2, textView22.getMeasuredHeight() + i6);
        int max32 = Math.max((width - paddingRight) - i17, i13 + this.c3);
        TextView textView32 = this.Z2;
        textView32.layout(max32, i5, max32 + i17, textView32.getMeasuredHeight() + i5);
        this.b3 = f2;
        this.f3 = false;
    }

    /* access modifiers changed from: package-private */
    public int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }

    public int getTextSpacing() {
        return this.c3;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof ViewPager) {
            ViewPager viewPager = (ViewPager) parent;
            PagerAdapter adapter = viewPager.getAdapter();
            viewPager.V(this.g3);
            viewPager.b(this.g3);
            this.s = viewPager;
            WeakReference<PagerAdapter> weakReference = this.h3;
            b(weakReference != null ? weakReference.get() : null, adapter);
            return;
        }
        throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewPager viewPager = this.s;
        if (viewPager != null) {
            b(viewPager.getAdapter(), (PagerAdapter) null);
            this.s.V((ViewPager.OnPageChangeListener) null);
            this.s.N(this.g3);
            this.s = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i4, int i5, int i6) {
        if (this.s != null) {
            float f2 = this.b3;
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            d(this.a3, f2, true);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i4) {
        int i5;
        if (View.MeasureSpec.getMode(i2) == 1073741824) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i4, paddingTop, -2);
            int size = View.MeasureSpec.getSize(i2);
            int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i2, (int) (((float) size) * 0.2f), -2);
            this.X2.measure(childMeasureSpec2, childMeasureSpec);
            this.Y2.measure(childMeasureSpec2, childMeasureSpec);
            this.Z2.measure(childMeasureSpec2, childMeasureSpec);
            if (View.MeasureSpec.getMode(i4) == 1073741824) {
                i5 = View.MeasureSpec.getSize(i4);
            } else {
                i5 = Math.max(getMinHeight(), this.Y2.getMeasuredHeight() + paddingTop);
            }
            setMeasuredDimension(size, View.resolveSizeAndState(i5, i4, this.Y2.getMeasuredState() << 16));
            return;
        }
        throw new IllegalStateException("Must measure with an exact width");
    }

    public void requestLayout() {
        if (!this.e3) {
            super.requestLayout();
        }
    }

    public void setGravity(int i2) {
        this.d3 = i2;
        requestLayout();
    }

    public void setNonPrimaryAlpha(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        int i2 = ((int) (f2 * 255.0f)) & 255;
        this.i3 = i2;
        int i4 = (i2 << 24) | (this.j3 & ViewCompat.x);
        this.X2.setTextColor(i4);
        this.Z2.setTextColor(i4);
    }

    public void setTextColor(@ColorInt int i2) {
        this.j3 = i2;
        this.Y2.setTextColor(i2);
        int i4 = (this.i3 << 24) | (this.j3 & ViewCompat.x);
        this.X2.setTextColor(i4);
        this.Z2.setTextColor(i4);
    }

    public void setTextSpacing(int i2) {
        this.c3 = i2;
        requestLayout();
    }

    public PagerTitleStrip(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a3 = -1;
        this.b3 = -1.0f;
        this.g3 = new PageListener();
        TextView textView = new TextView(context);
        this.X2 = textView;
        addView(textView);
        TextView textView2 = new TextView(context);
        this.Y2 = textView2;
        addView(textView2);
        TextView textView3 = new TextView(context);
        this.Z2 = textView3;
        addView(textView3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k3);
        boolean z = false;
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            TextViewCompat.D(this.X2, resourceId);
            TextViewCompat.D(this.Y2, resourceId);
            TextViewCompat.D(this.Z2, resourceId);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            a(0, (float) dimensionPixelSize);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            int color = obtainStyledAttributes.getColor(2, 0);
            this.X2.setTextColor(color);
            this.Y2.setTextColor(color);
            this.Z2.setTextColor(color);
        }
        this.d3 = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        this.j3 = this.Y2.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(m3);
        TextView textView4 = this.X2;
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView4.setEllipsize(truncateAt);
        this.Y2.setEllipsize(truncateAt);
        this.Z2.setEllipsize(truncateAt);
        if (resourceId != 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, l3);
            z = obtainStyledAttributes2.getBoolean(0, false);
            obtainStyledAttributes2.recycle();
        }
        TextView textView5 = this.X2;
        if (z) {
            setSingleLineAllCaps(textView5);
            setSingleLineAllCaps(this.Y2);
            setSingleLineAllCaps(this.Z2);
        } else {
            textView5.setSingleLine();
            this.Y2.setSingleLine();
            this.Z2.setSingleLine();
        }
        this.c3 = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }
}
