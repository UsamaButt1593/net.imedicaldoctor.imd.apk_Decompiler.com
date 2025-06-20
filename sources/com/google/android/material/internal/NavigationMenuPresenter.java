package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Dimension;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import com.google.android.material.R;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationMenuPresenter implements MenuPresenter {
    private static final String A3 = "android:menu:header";
    public static final int x3 = 0;
    private static final String y3 = "android:menu:list";
    private static final String z3 = "android:menu:adapter";
    LinearLayout X;
    private int X2;
    private MenuPresenter.Callback Y;
    NavigationMenuAdapter Y2;
    MenuBuilder Z;
    LayoutInflater Z2;
    int a3 = 0;
    @Nullable
    ColorStateList b3;
    int c3 = 0;
    boolean d3 = true;
    ColorStateList e3;
    ColorStateList f3;
    Drawable g3;
    RippleDrawable h3;
    int i3;
    @Px
    int j3;
    int k3;
    int l3;
    @Px
    int m3;
    @Px
    int n3;
    @Px
    int o3;
    @Px
    int p3;
    boolean q3;
    boolean r3 = true;
    private NavigationMenuView s;
    /* access modifiers changed from: private */
    public int s3;
    private int t3;
    int u3;
    private int v3 = -1;
    final View.OnClickListener w3 = new View.OnClickListener() {
        public void onClick(View view) {
            boolean z = true;
            NavigationMenuPresenter.this.b0(true);
            MenuItemImpl itemData = ((NavigationMenuItemView) view).getItemData();
            NavigationMenuPresenter navigationMenuPresenter = NavigationMenuPresenter.this;
            boolean Q = navigationMenuPresenter.Z.Q(itemData, navigationMenuPresenter, 0);
            if (itemData == null || !itemData.isCheckable() || !Q) {
                z = false;
            } else {
                NavigationMenuPresenter.this.Y2.p0(itemData);
            }
            NavigationMenuPresenter.this.b0(false);
            if (z) {
                NavigationMenuPresenter.this.d(false);
            }
        }
    };

    private static class HeaderViewHolder extends ViewHolder {
        public HeaderViewHolder(View view) {
            super(view);
        }
    }

    private class NavigationMenuAdapter extends RecyclerView.Adapter<ViewHolder> {

        /* renamed from: h  reason: collision with root package name */
        private static final String f21525h = "android:menu:checked";

        /* renamed from: i  reason: collision with root package name */
        private static final String f21526i = "android:menu:action_views";

        /* renamed from: j  reason: collision with root package name */
        private static final int f21527j = 0;

        /* renamed from: k  reason: collision with root package name */
        private static final int f21528k = 1;

        /* renamed from: l  reason: collision with root package name */
        private static final int f21529l = 2;

        /* renamed from: m  reason: collision with root package name */
        private static final int f21530m = 3;

        /* renamed from: d  reason: collision with root package name */
        private final ArrayList<NavigationMenuItem> f21531d = new ArrayList<>();

        /* renamed from: e  reason: collision with root package name */
        private MenuItemImpl f21532e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f21533f;

        NavigationMenuAdapter() {
            m0();
        }

        /* access modifiers changed from: private */
        public int e0(int i2) {
            int i3 = i2;
            for (int i4 = 0; i4 < i2; i4++) {
                if (NavigationMenuPresenter.this.Y2.C(i4) == 2 || NavigationMenuPresenter.this.Y2.C(i4) == 3) {
                    i3--;
                }
            }
            return i3;
        }

        private void f0(int i2, int i3) {
            while (i2 < i3) {
                ((NavigationMenuTextItem) this.f21531d.get(i2)).f21541b = true;
                i2++;
            }
        }

        private void m0() {
            if (!this.f21533f) {
                this.f21533f = true;
                this.f21531d.clear();
                this.f21531d.add(new NavigationMenuHeaderItem());
                int size = NavigationMenuPresenter.this.Z.H().size();
                int i2 = -1;
                boolean z = false;
                int i3 = 0;
                for (int i4 = 0; i4 < size; i4++) {
                    MenuItemImpl menuItemImpl = NavigationMenuPresenter.this.Z.H().get(i4);
                    if (menuItemImpl.isChecked()) {
                        p0(menuItemImpl);
                    }
                    if (menuItemImpl.isCheckable()) {
                        menuItemImpl.w(false);
                    }
                    if (menuItemImpl.hasSubMenu()) {
                        SubMenu subMenu = menuItemImpl.getSubMenu();
                        if (subMenu.hasVisibleItems()) {
                            if (i4 != 0) {
                                this.f21531d.add(new NavigationMenuSeparatorItem(NavigationMenuPresenter.this.u3, 0));
                            }
                            this.f21531d.add(new NavigationMenuTextItem(menuItemImpl));
                            int size2 = this.f21531d.size();
                            int size3 = subMenu.size();
                            boolean z2 = false;
                            for (int i5 = 0; i5 < size3; i5++) {
                                MenuItemImpl menuItemImpl2 = (MenuItemImpl) subMenu.getItem(i5);
                                if (menuItemImpl2.isVisible()) {
                                    if (!z2 && menuItemImpl2.getIcon() != null) {
                                        z2 = true;
                                    }
                                    if (menuItemImpl2.isCheckable()) {
                                        menuItemImpl2.w(false);
                                    }
                                    if (menuItemImpl.isChecked()) {
                                        p0(menuItemImpl);
                                    }
                                    this.f21531d.add(new NavigationMenuTextItem(menuItemImpl2));
                                }
                            }
                            if (z2) {
                                f0(size2, this.f21531d.size());
                            }
                        }
                    } else {
                        int groupId = menuItemImpl.getGroupId();
                        if (groupId != i2) {
                            i3 = this.f21531d.size();
                            z = menuItemImpl.getIcon() != null;
                            if (i4 != 0) {
                                i3++;
                                ArrayList<NavigationMenuItem> arrayList = this.f21531d;
                                int i6 = NavigationMenuPresenter.this.u3;
                                arrayList.add(new NavigationMenuSeparatorItem(i6, i6));
                            }
                        } else if (!z && menuItemImpl.getIcon() != null) {
                            f0(i3, this.f21531d.size());
                            z = true;
                        }
                        NavigationMenuTextItem navigationMenuTextItem = new NavigationMenuTextItem(menuItemImpl);
                        navigationMenuTextItem.f21541b = z;
                        this.f21531d.add(navigationMenuTextItem);
                        i2 = groupId;
                    }
                }
                this.f21533f = false;
            }
        }

        private void o0(View view, final int i2, final boolean z) {
            ViewCompat.H1(view, new AccessibilityDelegateCompat() {
                public void g(@NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                    super.g(view, accessibilityNodeInfoCompat);
                    accessibilityNodeInfoCompat.m1(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.j(NavigationMenuAdapter.this.e0(i2), 1, 1, 1, z, view.isSelected()));
                }
            });
        }

        public long B(int i2) {
            return (long) i2;
        }

        public int C(int i2) {
            NavigationMenuItem navigationMenuItem = this.f21531d.get(i2);
            if (navigationMenuItem instanceof NavigationMenuSeparatorItem) {
                return 2;
            }
            if (navigationMenuItem instanceof NavigationMenuHeaderItem) {
                return 3;
            }
            if (navigationMenuItem instanceof NavigationMenuTextItem) {
                return ((NavigationMenuTextItem) navigationMenuItem).a().hasSubMenu() ? 1 : 0;
            }
            throw new RuntimeException("Unknown item type.");
        }

        public int b() {
            return this.f21531d.size();
        }

        @NonNull
        public Bundle g0() {
            Bundle bundle = new Bundle();
            MenuItemImpl menuItemImpl = this.f21532e;
            if (menuItemImpl != null) {
                bundle.putInt(f21525h, menuItemImpl.getItemId());
            }
            SparseArray sparseArray = new SparseArray();
            int size = this.f21531d.size();
            for (int i2 = 0; i2 < size; i2++) {
                NavigationMenuItem navigationMenuItem = this.f21531d.get(i2);
                if (navigationMenuItem instanceof NavigationMenuTextItem) {
                    MenuItemImpl a2 = ((NavigationMenuTextItem) navigationMenuItem).a();
                    View actionView = a2 != null ? a2.getActionView() : null;
                    if (actionView != null) {
                        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                        actionView.saveHierarchyState(parcelableSparseArray);
                        sparseArray.put(a2.getItemId(), parcelableSparseArray);
                    }
                }
            }
            bundle.putSparseParcelableArray(f21526i, sparseArray);
            return bundle;
        }

        public MenuItemImpl h0() {
            return this.f21532e;
        }

        /* access modifiers changed from: package-private */
        public int i0() {
            int i2 = 0;
            for (int i3 = 0; i3 < NavigationMenuPresenter.this.Y2.b(); i3++) {
                int C = NavigationMenuPresenter.this.Y2.C(i3);
                if (C == 0 || C == 1) {
                    i2++;
                }
            }
            return i2;
        }

        /* renamed from: j0 */
        public void R(@NonNull ViewHolder viewHolder, int i2) {
            int C = C(i2);
            if (C == 0) {
                NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) viewHolder.f15587a;
                navigationMenuItemView.setIconTintList(NavigationMenuPresenter.this.f3);
                navigationMenuItemView.setTextAppearance(NavigationMenuPresenter.this.c3);
                ColorStateList colorStateList = NavigationMenuPresenter.this.e3;
                if (colorStateList != null) {
                    navigationMenuItemView.setTextColor(colorStateList);
                }
                Drawable drawable = NavigationMenuPresenter.this.g3;
                ViewCompat.P1(navigationMenuItemView, drawable != null ? drawable.getConstantState().newDrawable() : null);
                RippleDrawable rippleDrawable = NavigationMenuPresenter.this.h3;
                if (rippleDrawable != null) {
                    navigationMenuItemView.setForeground(rippleDrawable.getConstantState().newDrawable());
                }
                NavigationMenuTextItem navigationMenuTextItem = (NavigationMenuTextItem) this.f21531d.get(i2);
                navigationMenuItemView.setNeedsEmptyIcon(navigationMenuTextItem.f21541b);
                NavigationMenuPresenter navigationMenuPresenter = NavigationMenuPresenter.this;
                int i3 = navigationMenuPresenter.i3;
                int i4 = navigationMenuPresenter.j3;
                navigationMenuItemView.setPadding(i3, i4, i3, i4);
                navigationMenuItemView.setIconPadding(NavigationMenuPresenter.this.k3);
                NavigationMenuPresenter navigationMenuPresenter2 = NavigationMenuPresenter.this;
                if (navigationMenuPresenter2.q3) {
                    navigationMenuItemView.setIconSize(navigationMenuPresenter2.l3);
                }
                navigationMenuItemView.setMaxLines(NavigationMenuPresenter.this.s3);
                navigationMenuItemView.H(navigationMenuTextItem.a(), NavigationMenuPresenter.this.d3);
                o0(navigationMenuItemView, i2, false);
            } else if (C == 1) {
                TextView textView = (TextView) viewHolder.f15587a;
                textView.setText(((NavigationMenuTextItem) this.f21531d.get(i2)).a().getTitle());
                TextViewCompat.D(textView, NavigationMenuPresenter.this.a3);
                textView.setPadding(NavigationMenuPresenter.this.o3, textView.getPaddingTop(), NavigationMenuPresenter.this.p3, textView.getPaddingBottom());
                ColorStateList colorStateList2 = NavigationMenuPresenter.this.b3;
                if (colorStateList2 != null) {
                    textView.setTextColor(colorStateList2);
                }
                o0(textView, i2, true);
            } else if (C == 2) {
                NavigationMenuSeparatorItem navigationMenuSeparatorItem = (NavigationMenuSeparatorItem) this.f21531d.get(i2);
                viewHolder.f15587a.setPadding(NavigationMenuPresenter.this.m3, navigationMenuSeparatorItem.b(), NavigationMenuPresenter.this.n3, navigationMenuSeparatorItem.a());
            }
        }

        @Nullable
        /* renamed from: k0 */
        public ViewHolder T(ViewGroup viewGroup, int i2) {
            if (i2 == 0) {
                NavigationMenuPresenter navigationMenuPresenter = NavigationMenuPresenter.this;
                return new NormalViewHolder(navigationMenuPresenter.Z2, viewGroup, navigationMenuPresenter.w3);
            } else if (i2 == 1) {
                return new SubheaderViewHolder(NavigationMenuPresenter.this.Z2, viewGroup);
            } else {
                if (i2 == 2) {
                    return new SeparatorViewHolder(NavigationMenuPresenter.this.Z2, viewGroup);
                }
                if (i2 != 3) {
                    return null;
                }
                return new HeaderViewHolder(NavigationMenuPresenter.this.X);
            }
        }

        /* renamed from: l0 */
        public void Y(ViewHolder viewHolder) {
            if (viewHolder instanceof NormalViewHolder) {
                ((NavigationMenuItemView) viewHolder.f15587a).I();
            }
        }

        public void n0(@NonNull Bundle bundle) {
            MenuItemImpl a2;
            View actionView;
            ParcelableSparseArray parcelableSparseArray;
            MenuItemImpl a3;
            int i2 = bundle.getInt(f21525h, 0);
            if (i2 != 0) {
                this.f21533f = true;
                int size = this.f21531d.size();
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        break;
                    }
                    NavigationMenuItem navigationMenuItem = this.f21531d.get(i3);
                    if ((navigationMenuItem instanceof NavigationMenuTextItem) && (a3 = ((NavigationMenuTextItem) navigationMenuItem).a()) != null && a3.getItemId() == i2) {
                        p0(a3);
                        break;
                    }
                    i3++;
                }
                this.f21533f = false;
                m0();
            }
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(f21526i);
            if (sparseParcelableArray != null) {
                int size2 = this.f21531d.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    NavigationMenuItem navigationMenuItem2 = this.f21531d.get(i4);
                    if (!(!(navigationMenuItem2 instanceof NavigationMenuTextItem) || (a2 = ((NavigationMenuTextItem) navigationMenuItem2).a()) == null || (actionView = a2.getActionView()) == null || (parcelableSparseArray = (ParcelableSparseArray) sparseParcelableArray.get(a2.getItemId())) == null)) {
                        actionView.restoreHierarchyState(parcelableSparseArray);
                    }
                }
            }
        }

        public void p0(@NonNull MenuItemImpl menuItemImpl) {
            if (this.f21532e != menuItemImpl && menuItemImpl.isCheckable()) {
                MenuItemImpl menuItemImpl2 = this.f21532e;
                if (menuItemImpl2 != null) {
                    menuItemImpl2.setChecked(false);
                }
                this.f21532e = menuItemImpl;
                menuItemImpl.setChecked(true);
            }
        }

        public void q0(boolean z) {
            this.f21533f = z;
        }

        public void r0() {
            m0();
            G();
        }
    }

    private static class NavigationMenuHeaderItem implements NavigationMenuItem {
        NavigationMenuHeaderItem() {
        }
    }

    private interface NavigationMenuItem {
    }

    private static class NavigationMenuSeparatorItem implements NavigationMenuItem {

        /* renamed from: a  reason: collision with root package name */
        private final int f21538a;

        /* renamed from: b  reason: collision with root package name */
        private final int f21539b;

        public NavigationMenuSeparatorItem(int i2, int i3) {
            this.f21538a = i2;
            this.f21539b = i3;
        }

        public int a() {
            return this.f21539b;
        }

        public int b() {
            return this.f21538a;
        }
    }

    private static class NavigationMenuTextItem implements NavigationMenuItem {

        /* renamed from: a  reason: collision with root package name */
        private final MenuItemImpl f21540a;

        /* renamed from: b  reason: collision with root package name */
        boolean f21541b;

        NavigationMenuTextItem(MenuItemImpl menuItemImpl) {
            this.f21540a = menuItemImpl;
        }

        public MenuItemImpl a() {
            return this.f21540a;
        }
    }

    private class NavigationMenuViewAccessibilityDelegate extends RecyclerViewAccessibilityDelegate {
        NavigationMenuViewAccessibilityDelegate(@NonNull RecyclerView recyclerView) {
            super(recyclerView);
        }

        public void g(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.g(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.l1(AccessibilityNodeInfoCompat.CollectionInfoCompat.e(NavigationMenuPresenter.this.Y2.i0(), 1, false));
        }
    }

    private static class NormalViewHolder extends ViewHolder {
        public NormalViewHolder(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(R.layout.K, viewGroup, false));
            this.f15587a.setOnClickListener(onClickListener);
        }
    }

    private static class SeparatorViewHolder extends ViewHolder {
        public SeparatorViewHolder(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.M, viewGroup, false));
        }
    }

    private static class SubheaderViewHolder extends ViewHolder {
        public SubheaderViewHolder(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.N, viewGroup, false));
        }
    }

    private static abstract class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View view) {
            super(view);
        }
    }

    private boolean C() {
        return r() > 0;
    }

    private void c0() {
        int i2 = (C() || !this.r3) ? 0 : this.t3;
        NavigationMenuView navigationMenuView = this.s;
        navigationMenuView.setPadding(0, i2, 0, navigationMenuView.getPaddingBottom());
    }

    @Px
    public int A() {
        return this.p3;
    }

    @Px
    public int B() {
        return this.o3;
    }

    public View D(@LayoutRes int i2) {
        View inflate = this.Z2.inflate(i2, this.X, false);
        b(inflate);
        return inflate;
    }

    public boolean E() {
        return this.r3;
    }

    public void F(@NonNull View view) {
        this.X.removeView(view);
        if (!C()) {
            NavigationMenuView navigationMenuView = this.s;
            navigationMenuView.setPadding(0, this.t3, 0, navigationMenuView.getPaddingBottom());
        }
    }

    public void G(boolean z) {
        if (this.r3 != z) {
            this.r3 = z;
            c0();
        }
    }

    public void H(@NonNull MenuItemImpl menuItemImpl) {
        this.Y2.p0(menuItemImpl);
    }

    public void I(@Px int i2) {
        this.n3 = i2;
        d(false);
    }

    public void J(@Px int i2) {
        this.m3 = i2;
        d(false);
    }

    public void K(int i2) {
        this.X2 = i2;
    }

    public void L(@Nullable Drawable drawable) {
        this.g3 = drawable;
        d(false);
    }

    public void M(@Nullable RippleDrawable rippleDrawable) {
        this.h3 = rippleDrawable;
        d(false);
    }

    public void N(int i2) {
        this.i3 = i2;
        d(false);
    }

    public void O(int i2) {
        this.k3 = i2;
        d(false);
    }

    public void P(@Dimension int i2) {
        if (this.l3 != i2) {
            this.l3 = i2;
            this.q3 = true;
            d(false);
        }
    }

    public void Q(@Nullable ColorStateList colorStateList) {
        this.f3 = colorStateList;
        d(false);
    }

    public void R(int i2) {
        this.s3 = i2;
        d(false);
    }

    public void S(@StyleRes int i2) {
        this.c3 = i2;
        d(false);
    }

    public void T(boolean z) {
        this.d3 = z;
        d(false);
    }

    public void U(@Nullable ColorStateList colorStateList) {
        this.e3 = colorStateList;
        d(false);
    }

    public void V(@Px int i2) {
        this.j3 = i2;
        d(false);
    }

    public void W(int i2) {
        this.v3 = i2;
        NavigationMenuView navigationMenuView = this.s;
        if (navigationMenuView != null) {
            navigationMenuView.setOverScrollMode(i2);
        }
    }

    public void X(@Nullable ColorStateList colorStateList) {
        this.b3 = colorStateList;
        d(false);
    }

    public void Y(@Px int i2) {
        this.p3 = i2;
        d(false);
    }

    public void Z(@Px int i2) {
        this.o3 = i2;
        d(false);
    }

    public void a0(@StyleRes int i2) {
        this.a3 = i2;
        d(false);
    }

    public void b(@NonNull View view) {
        this.X.addView(view);
        NavigationMenuView navigationMenuView = this.s;
        navigationMenuView.setPadding(0, 0, 0, navigationMenuView.getPaddingBottom());
    }

    public void b0(boolean z) {
        NavigationMenuAdapter navigationMenuAdapter = this.Y2;
        if (navigationMenuAdapter != null) {
            navigationMenuAdapter.q0(z);
        }
    }

    public void c(MenuBuilder menuBuilder, boolean z) {
        MenuPresenter.Callback callback = this.Y;
        if (callback != null) {
            callback.c(menuBuilder, z);
        }
    }

    public void d(boolean z) {
        NavigationMenuAdapter navigationMenuAdapter = this.Y2;
        if (navigationMenuAdapter != null) {
            navigationMenuAdapter.r0();
        }
    }

    public boolean e() {
        return false;
    }

    public boolean f(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public boolean g(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public int getId() {
        return this.X2;
    }

    public void h(MenuPresenter.Callback callback) {
        this.Y = callback;
    }

    public void i(@NonNull Context context, @NonNull MenuBuilder menuBuilder) {
        this.Z2 = LayoutInflater.from(context);
        this.Z = menuBuilder;
        this.u3 = context.getResources().getDimensionPixelOffset(R.dimen.v1);
    }

    public void j(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.s.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle(z3);
            if (bundle2 != null) {
                this.Y2.n0(bundle2);
            }
            SparseArray sparseParcelableArray2 = bundle.getSparseParcelableArray(A3);
            if (sparseParcelableArray2 != null) {
                this.X.restoreHierarchyState(sparseParcelableArray2);
            }
        }
    }

    public void k(@NonNull WindowInsetsCompat windowInsetsCompat) {
        int r = windowInsetsCompat.r();
        if (this.t3 != r) {
            this.t3 = r;
            c0();
        }
        NavigationMenuView navigationMenuView = this.s;
        navigationMenuView.setPadding(0, navigationMenuView.getPaddingTop(), 0, windowInsetsCompat.o());
        ViewCompat.p(this.X, windowInsetsCompat);
    }

    public boolean l(SubMenuBuilder subMenuBuilder) {
        return false;
    }

    public MenuView m(ViewGroup viewGroup) {
        if (this.s == null) {
            NavigationMenuView navigationMenuView = (NavigationMenuView) this.Z2.inflate(R.layout.O, viewGroup, false);
            this.s = navigationMenuView;
            navigationMenuView.setAccessibilityDelegateCompat(new NavigationMenuViewAccessibilityDelegate(this.s));
            if (this.Y2 == null) {
                NavigationMenuAdapter navigationMenuAdapter = new NavigationMenuAdapter();
                this.Y2 = navigationMenuAdapter;
                navigationMenuAdapter.a0(true);
            }
            int i2 = this.v3;
            if (i2 != -1) {
                this.s.setOverScrollMode(i2);
            }
            LinearLayout linearLayout = (LinearLayout) this.Z2.inflate(R.layout.L, this.s, false);
            this.X = linearLayout;
            ViewCompat.Z1(linearLayout, 2);
            this.s.setAdapter(this.Y2);
        }
        return this.s;
    }

    @NonNull
    public Parcelable n() {
        Bundle bundle = new Bundle();
        if (this.s != null) {
            SparseArray sparseArray = new SparseArray();
            this.s.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        NavigationMenuAdapter navigationMenuAdapter = this.Y2;
        if (navigationMenuAdapter != null) {
            bundle.putBundle(z3, navigationMenuAdapter.g0());
        }
        if (this.X != null) {
            SparseArray sparseArray2 = new SparseArray();
            this.X.saveHierarchyState(sparseArray2);
            bundle.putSparseParcelableArray(A3, sparseArray2);
        }
        return bundle;
    }

    @Nullable
    public MenuItemImpl o() {
        return this.Y2.h0();
    }

    @Px
    public int p() {
        return this.n3;
    }

    @Px
    public int q() {
        return this.m3;
    }

    public int r() {
        return this.X.getChildCount();
    }

    public View s(int i2) {
        return this.X.getChildAt(i2);
    }

    @Nullable
    public Drawable t() {
        return this.g3;
    }

    public int u() {
        return this.i3;
    }

    public int v() {
        return this.k3;
    }

    public int w() {
        return this.s3;
    }

    @Nullable
    public ColorStateList x() {
        return this.e3;
    }

    @Nullable
    public ColorStateList y() {
        return this.f3;
    }

    @Px
    public int z() {
        return this.j3;
    }
}
