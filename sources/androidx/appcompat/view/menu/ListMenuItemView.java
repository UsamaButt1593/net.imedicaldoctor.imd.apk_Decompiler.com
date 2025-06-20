package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TintTypedArray;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ListMenuItemView extends LinearLayout implements MenuView.ItemView, AbsListView.SelectionBoundsAdjuster {
    private static final String n3 = "ListMenuItemView";
    private ImageView X2;
    private RadioButton Y2;
    private TextView Z2;
    private CheckBox a3;
    private TextView b3;
    private ImageView c3;
    private ImageView d3;
    private LinearLayout e3;
    private Drawable f3;
    private int g3;
    private Context h3;
    private boolean i3;
    private Drawable j3;
    private boolean k3;
    private LayoutInflater l3;
    private boolean m3;
    private MenuItemImpl s;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.Y1);
    }

    private void a(View view) {
        b(view, -1);
    }

    private void b(View view, int i2) {
        LinearLayout linearLayout = this.e3;
        if (linearLayout != null) {
            linearLayout.addView(view, i2);
        } else {
            addView(view, i2);
        }
    }

    private void d() {
        CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.o, this, false);
        this.a3 = checkBox;
        a(checkBox);
    }

    private void e() {
        ImageView imageView = (ImageView) getInflater().inflate(R.layout.p, this, false);
        this.X2 = imageView;
        b(imageView, 0);
    }

    private LayoutInflater getInflater() {
        if (this.l3 == null) {
            this.l3 = LayoutInflater.from(getContext());
        }
        return this.l3;
    }

    private void i() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.r, this, false);
        this.Y2 = radioButton;
        a(radioButton);
    }

    private void setSubMenuArrowVisible(boolean z) {
        ImageView imageView = this.c3;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.d3;
        if (imageView != null && imageView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.d3.getLayoutParams();
            rect.top += this.d3.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
        }
    }

    public void c(boolean z, char c2) {
        int i2 = (!z || !this.s.D()) ? 8 : 0;
        if (i2 == 0) {
            this.b3.setText(this.s.k());
        }
        if (this.b3.getVisibility() != i2) {
            this.b3.setVisibility(i2);
        }
    }

    public boolean f() {
        return false;
    }

    public boolean g() {
        return this.m3;
    }

    public MenuItemImpl getItemData() {
        return this.s;
    }

    public void h(MenuItemImpl menuItemImpl, int i2) {
        this.s = menuItemImpl;
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        setTitle(menuItemImpl.l(this));
        setCheckable(menuItemImpl.isCheckable());
        c(menuItemImpl.D(), menuItemImpl.j());
        setIcon(menuItemImpl.getIcon());
        setEnabled(menuItemImpl.isEnabled());
        setSubMenuArrowVisible(menuItemImpl.hasSubMenu());
        setContentDescription(menuItemImpl.getContentDescription());
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        setBackground(this.f3);
        TextView textView = (TextView) findViewById(R.id.s0);
        this.Z2 = textView;
        int i2 = this.g3;
        if (i2 != -1) {
            textView.setTextAppearance(this.h3, i2);
        }
        this.b3 = (TextView) findViewById(R.id.h0);
        ImageView imageView = (ImageView) findViewById(R.id.n0);
        this.c3 = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.j3);
        }
        this.d3 = (ImageView) findViewById(R.id.C);
        this.e3 = (LinearLayout) findViewById(R.id.t);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i4) {
        if (this.X2 != null && this.i3) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.X2.getLayoutParams();
            int i5 = layoutParams.height;
            if (i5 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i5;
            }
        }
        super.onMeasure(i2, i4);
    }

    public void setCheckable(boolean z) {
        View view;
        CompoundButton compoundButton;
        if (z || this.Y2 != null || this.a3 != null) {
            if (this.s.p()) {
                if (this.Y2 == null) {
                    i();
                }
                compoundButton = this.Y2;
                view = this.a3;
            } else {
                if (this.a3 == null) {
                    d();
                }
                compoundButton = this.a3;
                view = this.Y2;
            }
            if (z) {
                compoundButton.setChecked(this.s.isChecked());
                if (compoundButton.getVisibility() != 0) {
                    compoundButton.setVisibility(0);
                }
                if (view != null && view.getVisibility() != 8) {
                    view.setVisibility(8);
                    return;
                }
                return;
            }
            CheckBox checkBox = this.a3;
            if (checkBox != null) {
                checkBox.setVisibility(8);
            }
            RadioButton radioButton = this.Y2;
            if (radioButton != null) {
                radioButton.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.s.p()) {
            if (this.Y2 == null) {
                i();
            }
            compoundButton = this.Y2;
        } else {
            if (this.a3 == null) {
                d();
            }
            compoundButton = this.a3;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.m3 = z;
        this.i3 = z;
    }

    public void setGroupDividerEnabled(boolean z) {
        ImageView imageView = this.d3;
        if (imageView != null) {
            imageView.setVisibility((this.k3 || !z) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z = this.s.C() || this.m3;
        if (z || this.i3) {
            ImageView imageView = this.X2;
            if (imageView != null || drawable != null || this.i3) {
                if (imageView == null) {
                    e();
                }
                if (drawable != null || this.i3) {
                    ImageView imageView2 = this.X2;
                    if (!z) {
                        drawable = null;
                    }
                    imageView2.setImageDrawable(drawable);
                    if (this.X2.getVisibility() != 0) {
                        this.X2.setVisibility(0);
                        return;
                    }
                    return;
                }
                this.X2.setVisibility(8);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        int i2;
        TextView textView;
        if (charSequence != null) {
            this.Z2.setText(charSequence);
            if (this.Z2.getVisibility() != 0) {
                textView = this.Z2;
                i2 = 0;
            } else {
                return;
            }
        } else {
            i2 = 8;
            if (this.Z2.getVisibility() != 8) {
                textView = this.Z2;
            } else {
                return;
            }
        }
        textView.setVisibility(i2);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        TintTypedArray G = TintTypedArray.G(getContext(), attributeSet, R.styleable.I4, i2, 0);
        this.f3 = G.h(R.styleable.O4);
        this.g3 = G.u(R.styleable.K4, -1);
        this.i3 = G.a(R.styleable.Q4, false);
        this.h3 = context;
        this.j3 = G.h(R.styleable.R4);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes((AttributeSet) null, new int[]{16843049}, R.attr.p1, 0);
        this.k3 = obtainStyledAttributes.hasValue(0);
        G.I();
        obtainStyledAttributes.recycle();
    }
}
