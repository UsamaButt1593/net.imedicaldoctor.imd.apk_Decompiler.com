package it.neokree.materialtabs;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import it.neokree.materialtabs.tabBuilder;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"InflateParams"})
public class MaterialTabHost extends RelativeLayout implements View.OnClickListener {
    public static final int q3 = 1;
    public static final int r3 = 2;
    private static int s3;
    private int X2;
    private int Y2;
    private int Z2;
    private List<MaterialTab> a3;
    private boolean b3;
    private boolean c3;
    private float d3;
    private boolean e3;
    private int f3;
    private HorizontalScrollView g3;
    private LinearLayout h3;
    private ImageButton i3;
    private ImageButton j3;
    private int k3;
    private int l3;
    private int m3;
    private boolean n3;
    private boolean o3;
    private int p3;
    private int s;

    public MaterialTabHost(Context context) {
        this(context, (AttributeSet) null);
    }

    private LinearLayout.LayoutParams h(int i2) {
        return new LinearLayout.LayoutParams(i2, -1);
    }

    private View j() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) (((float) this.l3) * this.d3), -1);
        View view = new View(this.h3.getContext());
        view.setBackgroundColor(this.m3);
        view.setLayoutParams(layoutParams);
        return view;
    }

    private void k(int i2) {
        float j2;
        float f2;
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            int width = this.a3.get(i5).l().getWidth();
            if (width == 0) {
                if (!this.c3) {
                    j2 = (float) this.a3.get(i5).j();
                    f2 = 24.0f;
                } else {
                    j2 = (float) this.a3.get(i5).j();
                    f2 = 48.0f;
                }
                width = (int) (j2 + (this.d3 * f2));
            }
            i4 += width;
        }
        this.g3.smoothScrollTo(i4, 0);
    }

    public void a(MaterialTab materialTab) {
        materialTab.n(this.X2);
        materialTab.s(this.s);
        materialTab.v(this.Y2);
        materialTab.q(this.Z2);
        materialTab.r(this.a3.size());
        this.a3.add(materialTab);
        if (this.a3.size() == this.f3 && !this.b3) {
            this.e3 = true;
        }
        if (this.a3.size() == this.f3 && this.b3) {
            this.e3 = true;
        }
        if (this.a3.size() < this.f3) {
            this.e3 = false;
        }
    }

    public MaterialTab b(int i2, String str, boolean z) {
        MaterialTab materialTab = new MaterialTab(getContext(), new tabBuilder(z ? tabBuilder.layout.TAB_CUSTOM_TEXT : tabBuilder.layout.TAB_CUSTOM_NO_BUBBLE).i(getContext()).g(i2).f());
        materialTab.u(str);
        return materialTab;
    }

    public MaterialTab c(String str) {
        MaterialTab materialTab = new MaterialTab(getContext(), new tabBuilder(tabBuilder.layout.TAB_CUSTOM_TEXT).i(getContext()).g(this.k3).f());
        materialTab.u(str);
        return materialTab;
    }

    public MaterialTab d(CharSequence charSequence) {
        MaterialTab materialTab = new MaterialTab(getContext(), new tabBuilder(tabBuilder.layout.TAB_MATERIAL).i(getContext()).f());
        materialTab.u(charSequence);
        return materialTab;
    }

    public MaterialTab e(String str) {
        MaterialTab materialTab = new MaterialTab(getContext(), new tabBuilder(tabBuilder.layout.TAB_MATERIAL).i(getContext()).f());
        materialTab.u(str);
        return materialTab;
    }

    public MaterialTab f(tabBuilder tabbuilder) {
        return new MaterialTab(getContext(), tabbuilder);
    }

    public MaterialTab g(String str) {
        MaterialTab materialTab = new MaterialTab(getContext(), new tabBuilder(tabBuilder.layout.TAB_CLASSIC).i(getContext()).f());
        materialTab.u(str);
        return materialTab;
    }

    public MaterialTab getCurrentTab() {
        for (MaterialTab next : this.a3) {
            if (next.m()) {
                return next;
            }
        }
        return null;
    }

    @TargetApi(17)
    public void i() {
        RelativeLayout.LayoutParams layoutParams;
        super.removeAllViews();
        this.h3.removeAllViews();
        Point point = new Point();
        getDisplay().getSize(point);
        int i2 = point.x;
        int size = this.a3.size() - 1;
        int size2 = (i2 / this.a3.size()) - (this.n3 ? (int) (((float) this.l3) * this.d3) : 0);
        LinearLayout.LayoutParams h2 = h(size2);
        if (!this.e3) {
            for (int i4 = 0; i4 < this.a3.size(); i4++) {
                MaterialTab materialTab = this.a3.get(i4);
                if (!this.o3 && this.n3 && i4 == size) {
                    h2 = h(((int) this.d3) + size2);
                }
                this.h3.addView(materialTab.l(), h2);
                if (this.n3 && i4 < size && !this.o3) {
                    this.h3.addView(j());
                }
                if (this.n3 && this.o3) {
                    this.h3.addView(j());
                }
            }
        } else if (!this.c3) {
            for (int i5 = 0; i5 < this.a3.size(); i5++) {
                MaterialTab materialTab2 = this.a3.get(i5);
                int j2 = (int) (((float) materialTab2.j()) + (this.d3 * 24.0f));
                if (i5 == 0) {
                    View view = new View(this.h3.getContext());
                    view.setMinimumWidth((int) (this.d3 * 60.0f));
                    this.h3.addView(view);
                }
                LinearLayout.LayoutParams h4 = h(j2);
                if (!this.o3 && this.n3 && i5 == size) {
                    h4 = h(j2 + ((int) this.d3));
                }
                this.h3.addView(materialTab2.l(), h4);
                if (this.n3 && i5 < size && !this.o3) {
                    this.h3.addView(j());
                }
                if (this.n3 && this.o3) {
                    this.h3.addView(j());
                }
                if (i5 == this.a3.size() - 1) {
                    View view2 = new View(this.h3.getContext());
                    view2.setMinimumWidth((int) (this.d3 * 60.0f));
                    this.h3.addView(view2);
                }
            }
        } else {
            for (int i6 = 0; i6 < this.a3.size(); i6++) {
                MaterialTab materialTab3 = this.a3.get(i6);
                int j4 = (int) (((float) materialTab3.j()) + (this.d3 * 48.0f));
                LinearLayout.LayoutParams h5 = h(j4);
                if (!this.o3 && this.n3 && i6 == size) {
                    h5 = h(j4 + ((int) this.d3));
                }
                this.h3.addView(materialTab3.l(), h5);
                if (this.n3 && i6 < size && !this.o3) {
                    this.h3.addView(j());
                }
                if (this.n3 && this.o3) {
                    this.h3.addView(j());
                }
            }
        }
        if (!this.c3 || !this.e3) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            Resources resources = getResources();
            ImageButton imageButton = new ImageButton(getContext());
            this.i3 = imageButton;
            int i7 = R.id.F;
            imageButton.setId(i7);
            this.i3.setImageDrawable(resources.getDrawable(R.drawable.R));
            this.i3.setBackgroundColor(0);
            this.i3.setOnClickListener(this);
            float f2 = this.d3;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) (f2 * 56.0f), (int) (f2 * 48.0f));
            layoutParams2.addRule(9);
            layoutParams2.addRule(10);
            layoutParams2.addRule(12);
            addView(this.i3, layoutParams2);
            ImageButton imageButton2 = new ImageButton(getContext());
            this.j3 = imageButton2;
            int i8 = R.id.Q;
            imageButton2.setId(i8);
            this.j3.setImageDrawable(resources.getDrawable(R.drawable.S));
            this.j3.setBackgroundColor(0);
            this.j3.setOnClickListener(this);
            float f4 = this.d3;
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) (56.0f * f4), (int) (f4 * 48.0f));
            layoutParams3.addRule(11);
            layoutParams3.addRule(10);
            layoutParams3.addRule(12);
            addView(this.j3, layoutParams3);
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(0, i8);
            layoutParams.addRule(1, i7);
        }
        addView(this.g3, layoutParams);
        setSelectedNavigationItem(s3);
    }

    public void l(int i2, int i4) {
        this.n3 = true;
        this.l3 = i2;
        this.m3 = i4;
    }

    @SuppressLint({"ResourceAsColor"})
    public void m(int i2, int i4) {
        this.n3 = true;
        this.l3 = i2;
        this.m3 = this.h3.getContext().getResources().getColor(i4);
    }

    public void onClick(View view) {
        int i2;
        int h2 = getCurrentTab().h();
        if (view.getId() == R.id.Q && h2 < this.a3.size() - 1) {
            i2 = h2 + 1;
        } else if (view.getId() == R.id.F && h2 > 0) {
            i2 = h2 - 1;
        } else {
            return;
        }
        setSelectedNavigationItem(i2);
        this.a3.get(i2).i().b(this.a3.get(i2));
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i4, int i5, int i6) {
        super.onSizeChanged(i2, i4, i5, i6);
        if (getWidth() != 0 && this.a3.size() != 0) {
            i();
        }
    }

    public void removeAllViews() {
        for (int i2 = 0; i2 < this.a3.size(); i2++) {
            this.a3.remove(i2);
        }
        this.h3.removeAllViews();
        super.removeAllViews();
    }

    public void setAccentColor(int i2) {
        this.X2 = i2;
        for (MaterialTab n2 : this.a3) {
            n2.n(i2);
        }
    }

    public void setCustomBackground(int i2) {
        super.setBackground(getContext().getResources().getDrawable(i2));
    }

    public void setFixTabLimit(int i2) {
        this.f3 = i2;
        this.e3 = false;
        if (this.a3.size() > i2 && !this.b3) {
            this.e3 = true;
        }
        if (this.a3.size() > 6 && this.b3) {
            this.e3 = true;
        }
        i();
    }

    public void setIconColor(int i2) {
        this.Z2 = i2;
        for (MaterialTab q : this.a3) {
            q.q(i2);
        }
    }

    public void setMeasurementType(int i2) {
        this.p3 = i2;
    }

    public void setPrimaryColor(int i2) {
        this.s = i2;
        setBackgroundColor(i2);
        for (MaterialTab s2 : this.a3) {
            s2.s(i2);
        }
    }

    public void setSelectedNavigationItem(int i2) {
        if (i2 < 0 || i2 > this.a3.size()) {
            throw new RuntimeException("Index overflow");
        }
        for (int i4 = 0; i4 < this.a3.size(); i4++) {
            MaterialTab materialTab = this.a3.get(i4);
            if (i4 == i2) {
                materialTab.d();
            } else {
                this.a3.get(i4).f();
            }
        }
        if (this.e3) {
            k(i2);
        }
        s3 = i2;
    }

    public void setTextColor(int i2) {
        this.Y2 = i2;
        for (MaterialTab v : this.a3) {
            v.v(i2);
        }
    }

    public MaterialTabHost(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaterialTabHost(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.n3 = false;
        this.o3 = false;
        this.p3 = 2;
        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(context);
        this.g3 = horizontalScrollView;
        horizontalScrollView.setOverScrollMode(2);
        this.g3.setHorizontalScrollBarEnabled(false);
        LinearLayout linearLayout = new LinearLayout(context);
        this.h3 = linearLayout;
        this.g3.addView(linearLayout);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.u0, 0, 0);
            try {
                this.b3 = obtainStyledAttributes.getBoolean(R.styleable.x0, false);
                this.s = obtainStyledAttributes.getColor(R.styleable.z0, Color.parseColor("#009688"));
                this.X2 = obtainStyledAttributes.getColor(R.styleable.v0, Color.parseColor("#00b0ff"));
                this.Z2 = obtainStyledAttributes.getColor(R.styleable.y0, -1);
                this.Y2 = obtainStyledAttributes.getColor(R.styleable.B0, -1);
                this.f3 = obtainStyledAttributes.getColor(R.styleable.A0, getResources().getInteger(R.integer.f28708a));
                this.k3 = obtainStyledAttributes.getResourceId(R.styleable.w0, -1);
            } finally {
                obtainStyledAttributes.recycle();
            }
        } else {
            this.b3 = false;
        }
        isInEditMode();
        this.e3 = false;
        this.c3 = getResources().getBoolean(R.bool.f28651c);
        this.d3 = getResources().getDisplayMetrics().density;
        s3 = 0;
        this.a3 = new LinkedList();
        super.setBackgroundColor(this.s);
    }
}
