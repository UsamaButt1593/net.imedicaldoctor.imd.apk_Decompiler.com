package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.ForwardingListener;
import androidx.appcompat.widget.TooltipCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ActionMenuItemView extends AppCompatTextView implements MenuView.ItemView, View.OnClickListener, ActionMenuView.ActionMenuChildView {
    private static final String o3 = "ActionMenuItemView";
    private static final int p3 = 32;
    MenuItemImpl d3;
    private CharSequence e3;
    private Drawable f3;
    MenuBuilder.ItemInvoker g3;
    private ForwardingListener h3;
    PopupCallback i3;
    private boolean j3;
    private boolean k3;
    private int l3;
    private int m3;
    private int n3;

    private class ActionMenuItemForwardingListener extends ForwardingListener {
        public ActionMenuItemForwardingListener() {
            super(ActionMenuItemView.this);
        }

        public ShowableListMenu b() {
            PopupCallback popupCallback = ActionMenuItemView.this.i3;
            if (popupCallback != null) {
                return popupCallback.a();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000f, code lost:
            r0 = b();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean c() {
            /*
                r3 = this;
                androidx.appcompat.view.menu.ActionMenuItemView r0 = androidx.appcompat.view.menu.ActionMenuItemView.this
                androidx.appcompat.view.menu.MenuBuilder$ItemInvoker r1 = r0.g3
                r2 = 0
                if (r1 == 0) goto L_0x001c
                androidx.appcompat.view.menu.MenuItemImpl r0 = r0.d3
                boolean r0 = r1.a(r0)
                if (r0 == 0) goto L_0x001c
                androidx.appcompat.view.menu.ShowableListMenu r0 = r3.b()
                if (r0 == 0) goto L_0x001c
                boolean r0 = r0.b()
                if (r0 == 0) goto L_0x001c
                r2 = 1
            L_0x001c:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.ActionMenuItemView.ActionMenuItemForwardingListener.c():boolean");
        }
    }

    public static abstract class PopupCallback {
        public abstract ShowableListMenu a();
    }

    public ActionMenuItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    private boolean w() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i2 = configuration.screenWidthDp;
        return i2 >= 480 || (i2 >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    private void x() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.e3);
        if (this.f3 != null && (!this.d3.E() || (!this.j3 && !this.k3))) {
            z = false;
        }
        boolean z3 = z2 & z;
        CharSequence charSequence = null;
        setText(z3 ? this.e3 : null);
        CharSequence contentDescription = this.d3.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            contentDescription = z3 ? null : this.d3.getTitle();
        }
        setContentDescription(contentDescription);
        CharSequence tooltipText = this.d3.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            if (!z3) {
                charSequence = this.d3.getTitle();
            }
            TooltipCompat.a(this, charSequence);
            return;
        }
        TooltipCompat.a(this, tooltipText);
    }

    public boolean a() {
        return v();
    }

    public void c(boolean z, char c2) {
    }

    public boolean d() {
        return v() && this.d3.getIcon() == null;
    }

    public boolean f() {
        return true;
    }

    public boolean g() {
        return true;
    }

    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    public MenuItemImpl getItemData() {
        return this.d3;
    }

    public void h(MenuItemImpl menuItemImpl, int i2) {
        this.d3 = menuItemImpl;
        setIcon(menuItemImpl.getIcon());
        setTitle(menuItemImpl.l(this));
        setId(menuItemImpl.getItemId());
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        setEnabled(menuItemImpl.isEnabled());
        if (menuItemImpl.hasSubMenu() && this.h3 == null) {
            this.h3 = new ActionMenuItemForwardingListener();
        }
    }

    public void onClick(View view) {
        MenuBuilder.ItemInvoker itemInvoker = this.g3;
        if (itemInvoker != null) {
            itemInvoker.a(this.d3);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.j3 = w();
        x();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i4) {
        int i5;
        boolean v = v();
        if (v && (i5 = this.m3) >= 0) {
            super.setPadding(i5, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i2, i4);
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int measuredWidth = getMeasuredWidth();
        int min = mode == Integer.MIN_VALUE ? Math.min(size, this.l3) : this.l3;
        if (mode != 1073741824 && this.l3 > 0 && measuredWidth < min) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(min, 1073741824), i4);
        }
        if (!v && this.f3 != null) {
            super.setPadding((getMeasuredWidth() - this.f3.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState((Parcelable) null);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        ForwardingListener forwardingListener;
        if (!this.d3.hasSubMenu() || (forwardingListener = this.h3) == null || !forwardingListener.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.k3 != z) {
            this.k3 = z;
            MenuItemImpl menuItemImpl = this.d3;
            if (menuItemImpl != null) {
                menuItemImpl.e();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f3 = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i2 = this.n3;
            if (intrinsicWidth > i2) {
                intrinsicHeight = (int) (((float) intrinsicHeight) * (((float) i2) / ((float) intrinsicWidth)));
                intrinsicWidth = i2;
            }
            if (intrinsicHeight > i2) {
                intrinsicWidth = (int) (((float) intrinsicWidth) * (((float) i2) / ((float) intrinsicHeight)));
            } else {
                i2 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i2);
        }
        setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        x();
    }

    public void setItemInvoker(MenuBuilder.ItemInvoker itemInvoker) {
        this.g3 = itemInvoker;
    }

    public void setPadding(int i2, int i4, int i5, int i6) {
        this.m3 = i2;
        super.setPadding(i2, i4, i5, i6);
    }

    public void setPopupCallback(PopupCallback popupCallback) {
        this.i3 = popupCallback;
    }

    public void setTitle(CharSequence charSequence) {
        this.e3 = charSequence;
        x();
    }

    public boolean v() {
        return !TextUtils.isEmpty(getText());
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Resources resources = context.getResources();
        this.j3 = w();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.G, i2, 0);
        this.l3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.H, 0);
        obtainStyledAttributes.recycle();
        this.n3 = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.m3 = -1;
        setSaveEnabled(false);
    }
}
