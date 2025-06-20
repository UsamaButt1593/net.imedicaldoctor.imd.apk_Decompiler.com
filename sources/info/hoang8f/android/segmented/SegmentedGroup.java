package info.hoang8f.android.segmented;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class SegmentedGroup extends RadioGroup {
    private Resources X2;
    private int Y2;
    private int Z2 = -1;
    private LayoutSelector a3;
    private Float b3;
    private int s;

    private class LayoutSelector {

        /* renamed from: a  reason: collision with root package name */
        private int f28352a;

        /* renamed from: b  reason: collision with root package name */
        private int f28353b;

        /* renamed from: c  reason: collision with root package name */
        private final int f28354c = R.drawable.f28343b;

        /* renamed from: d  reason: collision with root package name */
        private final int f28355d = R.drawable.f28344c;

        /* renamed from: e  reason: collision with root package name */
        private float f28356e;

        /* renamed from: f  reason: collision with root package name */
        private final float f28357f;

        /* renamed from: g  reason: collision with root package name */
        private final float[] f28358g;

        /* renamed from: h  reason: collision with root package name */
        private final float[] f28359h;

        /* renamed from: i  reason: collision with root package name */
        private final float[] f28360i;

        /* renamed from: j  reason: collision with root package name */
        private final float[] f28361j;

        /* renamed from: k  reason: collision with root package name */
        private final float[] f28362k;

        /* renamed from: l  reason: collision with root package name */
        private final float[] f28363l;

        /* renamed from: m  reason: collision with root package name */
        private float[] f28364m;

        public LayoutSelector(float f2) {
            float applyDimension = TypedValue.applyDimension(1, 0.1f, SegmentedGroup.this.getResources().getDisplayMetrics());
            this.f28357f = applyDimension;
            this.f28352a = -1;
            this.f28353b = -1;
            this.f28356e = f2;
            this.f28358g = new float[]{f2, f2, applyDimension, applyDimension, applyDimension, applyDimension, f2, f2};
            this.f28359h = new float[]{applyDimension, applyDimension, f2, f2, f2, f2, applyDimension, applyDimension};
            this.f28360i = new float[]{applyDimension, applyDimension, applyDimension, applyDimension, applyDimension, applyDimension, applyDimension, applyDimension};
            this.f28361j = new float[]{f2, f2, f2, f2, f2, f2, f2, f2};
            this.f28362k = new float[]{f2, f2, f2, f2, applyDimension, applyDimension, applyDimension, applyDimension};
            this.f28363l = new float[]{applyDimension, applyDimension, applyDimension, applyDimension, f2, f2, f2, f2};
        }

        private int a(View view) {
            return SegmentedGroup.this.indexOfChild(view);
        }

        private int c() {
            return SegmentedGroup.this.getChildCount();
        }

        private void f(int i2, int i3) {
            if (this.f28352a != i2 || this.f28353b != i3) {
                this.f28352a = i2;
                this.f28353b = i3;
                if (i2 == 1) {
                    this.f28364m = this.f28361j;
                } else if (i3 == 0) {
                    this.f28364m = SegmentedGroup.this.getOrientation() == 0 ? this.f28358g : this.f28362k;
                } else if (i3 == i2 - 1) {
                    this.f28364m = SegmentedGroup.this.getOrientation() == 0 ? this.f28359h : this.f28363l;
                } else {
                    this.f28364m = this.f28360i;
                }
            }
        }

        public float[] b(View view) {
            f(c(), a(view));
            return this.f28364m;
        }

        public int d() {
            return this.f28354c;
        }

        public int e() {
            return this.f28355d;
        }
    }

    public SegmentedGroup(Context context) {
        super(context);
        Resources resources = getResources();
        this.X2 = resources;
        this.Y2 = resources.getColor(R.color.f28338a);
        this.s = (int) getResources().getDimension(R.dimen.f28341b);
        Float valueOf = Float.valueOf(getResources().getDimension(R.dimen.f28340a));
        this.b3 = valueOf;
        this.a3 = new LayoutSelector(valueOf.floatValue());
    }

    private void a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.f28347a, 0, 0);
        try {
            this.s = (int) obtainStyledAttributes.getDimension(R.styleable.f28348b, getResources().getDimension(R.dimen.f28341b));
            this.b3 = Float.valueOf(obtainStyledAttributes.getDimension(R.styleable.f28350d, getResources().getDimension(R.dimen.f28340a)));
            this.Y2 = obtainStyledAttributes.getColor(R.styleable.f28351e, getResources().getColor(R.color.f28338a));
            this.Z2 = obtainStyledAttributes.getColor(R.styleable.f28349c, getResources().getColor(17170443));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void d(View view) {
        int d2 = this.a3.d();
        int e2 = this.a3.e();
        ((Button) view).setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[]{-16842919, -16842912}, new int[]{-16842919, 16842912}}, new int[]{-7829368, this.Y2, this.Z2}));
        Drawable mutate = this.X2.getDrawable(d2).mutate();
        Drawable mutate2 = this.X2.getDrawable(e2).mutate();
        GradientDrawable gradientDrawable = (GradientDrawable) mutate;
        gradientDrawable.setColor(this.Y2);
        gradientDrawable.setStroke(this.s, this.Y2);
        GradientDrawable gradientDrawable2 = (GradientDrawable) mutate2;
        gradientDrawable2.setStroke(this.s, this.Y2);
        gradientDrawable.setCornerRadii(this.a3.b(view));
        gradientDrawable2.setCornerRadii(this.a3.b(view));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{-16842912}, mutate2);
        stateListDrawable.addState(new int[]{16842912}, mutate);
        view.setBackground(stateListDrawable);
    }

    public void b(int i2, int i3) {
        this.Y2 = i2;
        this.Z2 = i3;
        c();
    }

    public void c() {
        int childCount = super.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = getChildAt(i2);
            d(childAt);
            if (i2 != childCount - 1) {
                RadioGroup.LayoutParams layoutParams = (RadioGroup.LayoutParams) childAt.getLayoutParams();
                RadioGroup.LayoutParams layoutParams2 = new RadioGroup.LayoutParams(layoutParams.width, layoutParams.height, layoutParams.weight);
                if (getOrientation() == 0) {
                    layoutParams2.setMargins(0, 0, -this.s, 0);
                } else {
                    layoutParams2.setMargins(0, 0, 0, -this.s);
                }
                childAt.setLayoutParams(layoutParams2);
                i2++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        c();
    }

    public void setTintColor(int i2) {
        this.Y2 = i2;
        c();
    }

    public SegmentedGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Resources resources = getResources();
        this.X2 = resources;
        this.Y2 = resources.getColor(R.color.f28338a);
        this.s = (int) getResources().getDimension(R.dimen.f28341b);
        this.b3 = Float.valueOf(getResources().getDimension(R.dimen.f28340a));
        a(attributeSet);
        this.a3 = new LayoutSelector(this.b3.floatValue());
    }
}
