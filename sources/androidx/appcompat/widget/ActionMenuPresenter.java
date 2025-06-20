package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.BaseMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ActionProvider;
import androidx.core.view.GravityCompat;
import java.util.ArrayList;

class ActionMenuPresenter extends BaseMenuPresenter implements ActionProvider.SubUiVisibilityListener {
    private static final String x3 = "ActionMenuPresenter";
    OverflowMenuButton d3;
    private Drawable e3;
    private boolean f3;
    private boolean g3;
    private boolean h3;
    private int i3;
    private int j3;
    private int k3;
    private boolean l3;
    private boolean m3;
    private boolean n3;
    private boolean o3;
    private int p3;
    private final SparseBooleanArray q3 = new SparseBooleanArray();
    OverflowPopup r3;
    ActionButtonSubmenu s3;
    OpenOverflowRunnable t3;
    private ActionMenuPopupCallback u3;
    final PopupPresenterCallback v3 = new PopupPresenterCallback();
    int w3;

    private class ActionButtonSubmenu extends MenuPopupHelper {
        public ActionButtonSubmenu(Context context, SubMenuBuilder subMenuBuilder, View view) {
            super(context, subMenuBuilder, view, false, R.attr.G);
            if (!((MenuItemImpl) subMenuBuilder.getItem()).o()) {
                View view2 = ActionMenuPresenter.this.d3;
                h(view2 == null ? (View) ActionMenuPresenter.this.b3 : view2);
            }
            a(ActionMenuPresenter.this.v3);
        }

        /* access modifiers changed from: protected */
        public void g() {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            actionMenuPresenter.s3 = null;
            actionMenuPresenter.w3 = 0;
            super.g();
        }
    }

    private class ActionMenuPopupCallback extends ActionMenuItemView.PopupCallback {
        ActionMenuPopupCallback() {
        }

        public ShowableListMenu a() {
            ActionButtonSubmenu actionButtonSubmenu = ActionMenuPresenter.this.s3;
            if (actionButtonSubmenu != null) {
                return actionButtonSubmenu.e();
            }
            return null;
        }
    }

    private class OpenOverflowRunnable implements Runnable {
        private OverflowPopup s;

        public OpenOverflowRunnable(OverflowPopup overflowPopup) {
            this.s = overflowPopup;
        }

        public void run() {
            if (ActionMenuPresenter.this.Y != null) {
                ActionMenuPresenter.this.Y.d();
            }
            View view = (View) ActionMenuPresenter.this.b3;
            if (!(view == null || view.getWindowToken() == null || !this.s.o())) {
                ActionMenuPresenter.this.r3 = this.s;
            }
            ActionMenuPresenter.this.t3 = null;
        }
    }

    private class OverflowMenuButton extends AppCompatImageView implements ActionMenuView.ActionMenuChildView {
        public OverflowMenuButton(Context context) {
            super(context, (AttributeSet) null, R.attr.F);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            TooltipCompat.a(this, getContentDescription());
            setOnTouchListener(new ForwardingListener(this, ActionMenuPresenter.this) {
                public ShowableListMenu b() {
                    OverflowPopup overflowPopup = ActionMenuPresenter.this.r3;
                    if (overflowPopup == null) {
                        return null;
                    }
                    return overflowPopup.e();
                }

                public boolean c() {
                    ActionMenuPresenter.this.Q();
                    return true;
                }

                public boolean d() {
                    ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
                    if (actionMenuPresenter.t3 != null) {
                        return false;
                    }
                    actionMenuPresenter.E();
                    return true;
                }
            });
        }

        public boolean a() {
            return false;
        }

        public boolean d() {
            return false;
        }

        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.Q();
            return true;
        }

        /* access modifiers changed from: protected */
        public boolean setFrame(int i2, int i3, int i4, int i5) {
            boolean frame = super.setFrame(i2, i3, i4, i5);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                DrawableCompat.l(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    private class OverflowPopup extends MenuPopupHelper {
        public OverflowPopup(Context context, MenuBuilder menuBuilder, View view, boolean z) {
            super(context, menuBuilder, view, z, R.attr.G);
            j(GravityCompat.f6388c);
            a(ActionMenuPresenter.this.v3);
        }

        /* access modifiers changed from: protected */
        public void g() {
            if (ActionMenuPresenter.this.Y != null) {
                ActionMenuPresenter.this.Y.close();
            }
            ActionMenuPresenter.this.r3 = null;
            super.g();
        }
    }

    private class PopupPresenterCallback implements MenuPresenter.Callback {
        PopupPresenterCallback() {
        }

        public void c(@NonNull MenuBuilder menuBuilder, boolean z) {
            if (menuBuilder instanceof SubMenuBuilder) {
                menuBuilder.G().f(false);
            }
            MenuPresenter.Callback q = ActionMenuPresenter.this.q();
            if (q != null) {
                q.c(menuBuilder, z);
            }
        }

        public boolean d(@NonNull MenuBuilder menuBuilder) {
            if (menuBuilder == ActionMenuPresenter.this.Y) {
                return false;
            }
            ActionMenuPresenter.this.w3 = ((SubMenuBuilder) menuBuilder).getItem().getItemId();
            MenuPresenter.Callback q = ActionMenuPresenter.this.q();
            if (q != null) {
                return q.d(menuBuilder);
            }
            return false;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    private static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };
        public int s;

        SavedState() {
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.s);
        }

        SavedState(Parcel parcel) {
            this.s = parcel.readInt();
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, R.layout.f2637d, R.layout.f2636c);
    }

    private View C(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.b3;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if ((childAt instanceof MenuView.ItemView) && ((MenuView.ItemView) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public boolean B() {
        return E() | F();
    }

    public Drawable D() {
        OverflowMenuButton overflowMenuButton = this.d3;
        if (overflowMenuButton != null) {
            return overflowMenuButton.getDrawable();
        }
        if (this.f3) {
            return this.e3;
        }
        return null;
    }

    public boolean E() {
        MenuView menuView;
        OpenOverflowRunnable openOverflowRunnable = this.t3;
        if (openOverflowRunnable == null || (menuView = this.b3) == null) {
            OverflowPopup overflowPopup = this.r3;
            if (overflowPopup == null) {
                return false;
            }
            overflowPopup.dismiss();
            return true;
        }
        ((View) menuView).removeCallbacks(openOverflowRunnable);
        this.t3 = null;
        return true;
    }

    public boolean F() {
        ActionButtonSubmenu actionButtonSubmenu = this.s3;
        if (actionButtonSubmenu == null) {
            return false;
        }
        actionButtonSubmenu.dismiss();
        return true;
    }

    public boolean G() {
        return this.t3 != null || H();
    }

    public boolean H() {
        OverflowPopup overflowPopup = this.r3;
        return overflowPopup != null && overflowPopup.f();
    }

    public boolean I() {
        return this.g3;
    }

    public void J(Configuration configuration) {
        if (!this.l3) {
            this.k3 = ActionBarPolicy.b(this.X).d();
        }
        MenuBuilder menuBuilder = this.Y;
        if (menuBuilder != null) {
            menuBuilder.O(true);
        }
    }

    public void K(boolean z) {
        this.o3 = z;
    }

    public void L(int i2) {
        this.k3 = i2;
        this.l3 = true;
    }

    public void M(ActionMenuView actionMenuView) {
        this.b3 = actionMenuView;
        actionMenuView.e(this.Y);
    }

    public void N(Drawable drawable) {
        OverflowMenuButton overflowMenuButton = this.d3;
        if (overflowMenuButton != null) {
            overflowMenuButton.setImageDrawable(drawable);
            return;
        }
        this.f3 = true;
        this.e3 = drawable;
    }

    public void O(boolean z) {
        this.g3 = z;
        this.h3 = true;
    }

    public void P(int i2, boolean z) {
        this.i3 = i2;
        this.m3 = z;
        this.n3 = true;
    }

    public boolean Q() {
        MenuBuilder menuBuilder;
        if (!this.g3 || H() || (menuBuilder = this.Y) == null || this.b3 == null || this.t3 != null || menuBuilder.C().isEmpty()) {
            return false;
        }
        OpenOverflowRunnable openOverflowRunnable = new OpenOverflowRunnable(new OverflowPopup(this.X, this.Y, this.d3, true));
        this.t3 = openOverflowRunnable;
        ((View) this.b3).post(openOverflowRunnable);
        return true;
    }

    public void a(boolean z) {
        if (z) {
            super.l((SubMenuBuilder) null);
            return;
        }
        MenuBuilder menuBuilder = this.Y;
        if (menuBuilder != null) {
            menuBuilder.f(false);
        }
    }

    public void c(MenuBuilder menuBuilder, boolean z) {
        B();
        super.c(menuBuilder, z);
    }

    public void d(boolean z) {
        MenuView menuView;
        super.d(z);
        ((View) this.b3).requestLayout();
        MenuBuilder menuBuilder = this.Y;
        boolean z2 = false;
        if (menuBuilder != null) {
            ArrayList<MenuItemImpl> v = menuBuilder.v();
            int size = v.size();
            for (int i2 = 0; i2 < size; i2++) {
                ActionProvider b2 = v.get(i2).b();
                if (b2 != null) {
                    b2.k(this);
                }
            }
        }
        MenuBuilder menuBuilder2 = this.Y;
        ArrayList<MenuItemImpl> C = menuBuilder2 != null ? menuBuilder2.C() : null;
        if (this.g3 && C != null) {
            int size2 = C.size();
            if (size2 == 1) {
                z2 = !C.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        OverflowMenuButton overflowMenuButton = this.d3;
        if (z2) {
            if (overflowMenuButton == null) {
                this.d3 = new OverflowMenuButton(this.s);
            }
            ViewGroup viewGroup = (ViewGroup) this.d3.getParent();
            if (viewGroup != this.b3) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.d3);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.b3;
                actionMenuView.addView(this.d3, actionMenuView.J());
            }
        } else if (overflowMenuButton != null && overflowMenuButton.getParent() == (menuView = this.b3)) {
            ((ViewGroup) menuView).removeView(this.d3);
        }
        ((ActionMenuView) this.b3).setOverflowReserved(this.g3);
    }

    public boolean e() {
        int i2;
        ArrayList<MenuItemImpl> arrayList;
        int i4;
        int i5;
        int i6;
        ActionMenuPresenter actionMenuPresenter = this;
        MenuBuilder menuBuilder = actionMenuPresenter.Y;
        View view = null;
        int i7 = 0;
        if (menuBuilder != null) {
            arrayList = menuBuilder.H();
            i2 = arrayList.size();
        } else {
            arrayList = null;
            i2 = 0;
        }
        int i8 = actionMenuPresenter.k3;
        int i9 = actionMenuPresenter.j3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) actionMenuPresenter.b3;
        boolean z = false;
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < i2; i12++) {
            MenuItemImpl menuItemImpl = arrayList.get(i12);
            if (menuItemImpl.d()) {
                i10++;
            } else if (menuItemImpl.q()) {
                i11++;
            } else {
                z = true;
            }
            if (actionMenuPresenter.o3 && menuItemImpl.isActionViewExpanded()) {
                i8 = 0;
            }
        }
        if (actionMenuPresenter.g3 && (z || i11 + i10 > i8)) {
            i8--;
        }
        int i13 = i8 - i10;
        SparseBooleanArray sparseBooleanArray = actionMenuPresenter.q3;
        sparseBooleanArray.clear();
        if (actionMenuPresenter.m3) {
            int i14 = actionMenuPresenter.p3;
            i4 = i9 / i14;
            i5 = i14 + ((i9 % i14) / i4);
        } else {
            i5 = 0;
            i4 = 0;
        }
        int i15 = 0;
        int i16 = 0;
        while (i15 < i2) {
            MenuItemImpl menuItemImpl2 = arrayList.get(i15);
            if (menuItemImpl2.d()) {
                View r = actionMenuPresenter.r(menuItemImpl2, view, viewGroup);
                if (actionMenuPresenter.m3) {
                    i4 -= ActionMenuView.P(r, i5, i4, makeMeasureSpec, i7);
                } else {
                    r.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = r.getMeasuredWidth();
                i9 -= measuredWidth;
                if (i16 == 0) {
                    i16 = measuredWidth;
                }
                int groupId = menuItemImpl2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                menuItemImpl2.x(true);
                i6 = i2;
            } else if (menuItemImpl2.q()) {
                int groupId2 = menuItemImpl2.getGroupId();
                boolean z2 = sparseBooleanArray.get(groupId2);
                boolean z3 = (i13 > 0 || z2) && i9 > 0 && (!actionMenuPresenter.m3 || i4 > 0);
                boolean z4 = z3;
                i6 = i2;
                if (z3) {
                    View r2 = actionMenuPresenter.r(menuItemImpl2, (View) null, viewGroup);
                    if (actionMenuPresenter.m3) {
                        int P = ActionMenuView.P(r2, i5, i4, makeMeasureSpec, 0);
                        i4 -= P;
                        if (P == 0) {
                            z4 = false;
                        }
                    } else {
                        r2.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    boolean z5 = z4;
                    int measuredWidth2 = r2.getMeasuredWidth();
                    i9 -= measuredWidth2;
                    if (i16 == 0) {
                        i16 = measuredWidth2;
                    }
                    z3 = z5 & (!actionMenuPresenter.m3 ? i9 + i16 > 0 : i9 >= 0);
                }
                if (z3 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z2) {
                    sparseBooleanArray.put(groupId2, false);
                    int i17 = 0;
                    while (i17 < i15) {
                        MenuItemImpl menuItemImpl3 = arrayList.get(i17);
                        if (menuItemImpl3.getGroupId() == groupId2) {
                            if (menuItemImpl3.o()) {
                                i13++;
                            }
                            menuItemImpl3.x(false);
                        }
                        i17++;
                    }
                }
                if (z3) {
                    i13--;
                }
                menuItemImpl2.x(z3);
            } else {
                i6 = i2;
                menuItemImpl2.x(false);
                i15++;
                view = null;
                actionMenuPresenter = this;
                i2 = i6;
                i7 = 0;
            }
            i15++;
            view = null;
            actionMenuPresenter = this;
            i2 = i6;
            i7 = 0;
        }
        return true;
    }

    public void i(@NonNull Context context, @Nullable MenuBuilder menuBuilder) {
        super.i(context, menuBuilder);
        Resources resources = context.getResources();
        ActionBarPolicy b2 = ActionBarPolicy.b(context);
        if (!this.h3) {
            this.g3 = b2.h();
        }
        if (!this.n3) {
            this.i3 = b2.c();
        }
        if (!this.l3) {
            this.k3 = b2.d();
        }
        int i2 = this.i3;
        if (this.g3) {
            if (this.d3 == null) {
                OverflowMenuButton overflowMenuButton = new OverflowMenuButton(this.s);
                this.d3 = overflowMenuButton;
                if (this.f3) {
                    overflowMenuButton.setImageDrawable(this.e3);
                    this.e3 = null;
                    this.f3 = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.d3.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i2 -= this.d3.getMeasuredWidth();
        } else {
            this.d3 = null;
        }
        this.j3 = i2;
        this.p3 = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    public void j(Parcelable parcelable) {
        int i2;
        MenuItem findItem;
        if ((parcelable instanceof SavedState) && (i2 = ((SavedState) parcelable).s) > 0 && (findItem = this.Y.findItem(i2)) != null) {
            l((SubMenuBuilder) findItem.getSubMenu());
        }
    }

    public void k(MenuItemImpl menuItemImpl, MenuView.ItemView itemView) {
        itemView.h(menuItemImpl, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) itemView;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.b3);
        if (this.u3 == null) {
            this.u3 = new ActionMenuPopupCallback();
        }
        actionMenuItemView.setPopupCallback(this.u3);
    }

    public boolean l(SubMenuBuilder subMenuBuilder) {
        boolean z = false;
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        SubMenuBuilder subMenuBuilder2 = subMenuBuilder;
        while (subMenuBuilder2.o0() != this.Y) {
            subMenuBuilder2 = (SubMenuBuilder) subMenuBuilder2.o0();
        }
        View C = C(subMenuBuilder2.getItem());
        if (C == null) {
            return false;
        }
        this.w3 = subMenuBuilder.getItem().getItemId();
        int size = subMenuBuilder.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            MenuItem item = subMenuBuilder.getItem(i2);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
            i2++;
        }
        ActionButtonSubmenu actionButtonSubmenu = new ActionButtonSubmenu(this.X, subMenuBuilder, C);
        this.s3 = actionButtonSubmenu;
        actionButtonSubmenu.i(z);
        this.s3.l();
        super.l(subMenuBuilder);
        return true;
    }

    public MenuView m(ViewGroup viewGroup) {
        MenuView menuView = this.b3;
        MenuView m2 = super.m(viewGroup);
        if (menuView != m2) {
            ((ActionMenuView) m2).setPresenter(this);
        }
        return m2;
    }

    public Parcelable n() {
        SavedState savedState = new SavedState();
        savedState.s = this.w3;
        return savedState;
    }

    public boolean p(ViewGroup viewGroup, int i2) {
        if (viewGroup.getChildAt(i2) == this.d3) {
            return false;
        }
        return super.p(viewGroup, i2);
    }

    public View r(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        View actionView = menuItemImpl.getActionView();
        if (actionView == null || menuItemImpl.m()) {
            actionView = super.r(menuItemImpl, view, viewGroup);
        }
        actionView.setVisibility(menuItemImpl.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.q(layoutParams));
        }
        return actionView;
    }

    public boolean t(int i2, MenuItemImpl menuItemImpl) {
        return menuItemImpl.o();
    }
}
