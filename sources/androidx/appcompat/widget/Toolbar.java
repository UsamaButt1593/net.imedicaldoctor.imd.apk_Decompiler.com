package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.ColorInt;
import androidx.annotation.DoNotInline;
import androidx.annotation.DrawableRes;
import androidx.annotation.MainThread;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.GravityCompat;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.itextpdf.tool.xml.html.HTML;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Toolbar extends ViewGroup implements MenuHost {
    private static final String Q3 = "Toolbar";
    private final ArrayList<View> A3;
    private final int[] B3;
    final MenuHostHelper C3;
    private ArrayList<MenuItem> D3;
    OnMenuItemClickListener E3;
    private final ActionMenuView.OnMenuItemClickListener F3;
    private ToolbarWidgetWrapper G3;
    private ActionMenuPresenter H3;
    private ExpandedActionViewMenuPresenter I3;
    private MenuPresenter.Callback J3;
    MenuBuilder.Callback K3;
    private boolean L3;
    private OnBackInvokedCallback M3;
    private OnBackInvokedDispatcher N3;
    private boolean O3;
    private final Runnable P3;
    private TextView X2;
    private TextView Y2;
    private ImageButton Z2;
    private ImageView a3;
    private Drawable b3;
    private CharSequence c3;
    ImageButton d3;
    View e3;
    private Context f3;
    private int g3;
    private int h3;
    private int i3;
    int j3;
    private int k3;
    private int l3;
    private int m3;
    private int n3;
    private int o3;
    private RtlSpacingHelper p3;
    private int q3;
    private int r3;
    ActionMenuView s;
    private int s3;
    private CharSequence t3;
    private CharSequence u3;
    private ColorStateList v3;
    private ColorStateList w3;
    private boolean x3;
    private boolean y3;
    private final ArrayList<View> z3;

    @RequiresApi(33)
    static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        @Nullable
        static OnBackInvokedDispatcher a(@NonNull View view) {
            return view.findOnBackInvokedDispatcher();
        }

        @DoNotInline
        @NonNull
        static OnBackInvokedCallback b(@NonNull Runnable runnable) {
            Objects.requireNonNull(runnable);
            return new T(runnable);
        }

        @DoNotInline
        static void c(@NonNull Object obj, @NonNull Object obj2) {
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(1000000, (OnBackInvokedCallback) obj2);
        }

        @DoNotInline
        static void d(@NonNull Object obj, @NonNull Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    private class ExpandedActionViewMenuPresenter implements MenuPresenter {
        MenuItemImpl X;
        MenuBuilder s;

        ExpandedActionViewMenuPresenter() {
        }

        public void c(MenuBuilder menuBuilder, boolean z) {
        }

        public void d(boolean z) {
            if (this.X != null) {
                MenuBuilder menuBuilder = this.s;
                if (menuBuilder != null) {
                    int size = menuBuilder.size();
                    int i2 = 0;
                    while (i2 < size) {
                        if (this.s.getItem(i2) != this.X) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                }
                f(this.s, this.X);
            }
        }

        public boolean e() {
            return false;
        }

        public boolean f(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
            View view = Toolbar.this.e3;
            if (view instanceof CollapsibleActionView) {
                ((CollapsibleActionView) view).d();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.e3);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.d3);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.e3 = null;
            toolbar3.a();
            this.X = null;
            Toolbar.this.requestLayout();
            menuItemImpl.t(false);
            Toolbar.this.Z();
            return true;
        }

        public boolean g(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
            Toolbar.this.i();
            ViewParent parent = Toolbar.this.d3.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.d3);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.d3);
            }
            Toolbar.this.e3 = menuItemImpl.getActionView();
            this.X = menuItemImpl;
            ViewParent parent2 = Toolbar.this.e3.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.e3);
                }
                LayoutParams o = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                o.f2698a = (toolbar4.j3 & 112) | GravityCompat.f6387b;
                o.f3338b = 2;
                toolbar4.e3.setLayoutParams(o);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.e3);
            }
            Toolbar.this.O();
            Toolbar.this.requestLayout();
            menuItemImpl.t(true);
            View view = Toolbar.this.e3;
            if (view instanceof CollapsibleActionView) {
                ((CollapsibleActionView) view).b();
            }
            Toolbar.this.Z();
            return true;
        }

        public int getId() {
            return 0;
        }

        public void h(MenuPresenter.Callback callback) {
        }

        public void i(Context context, MenuBuilder menuBuilder) {
            MenuItemImpl menuItemImpl;
            MenuBuilder menuBuilder2 = this.s;
            if (!(menuBuilder2 == null || (menuItemImpl = this.X) == null)) {
                menuBuilder2.g(menuItemImpl);
            }
            this.s = menuBuilder;
        }

        public void j(Parcelable parcelable) {
        }

        public boolean l(SubMenuBuilder subMenuBuilder) {
            return false;
        }

        public MenuView m(ViewGroup viewGroup) {
            return null;
        }

        public Parcelable n() {
            return null;
        }
    }

    @RequiresApi(29)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion<Toolbar> {

        /* renamed from: a  reason: collision with root package name */
        private boolean f3321a = false;

        /* renamed from: b  reason: collision with root package name */
        private int f3322b;

        /* renamed from: c  reason: collision with root package name */
        private int f3323c;

        /* renamed from: d  reason: collision with root package name */
        private int f3324d;

        /* renamed from: e  reason: collision with root package name */
        private int f3325e;

        /* renamed from: f  reason: collision with root package name */
        private int f3326f;

        /* renamed from: g  reason: collision with root package name */
        private int f3327g;

        /* renamed from: h  reason: collision with root package name */
        private int f3328h;

        /* renamed from: i  reason: collision with root package name */
        private int f3329i;

        /* renamed from: j  reason: collision with root package name */
        private int f3330j;

        /* renamed from: k  reason: collision with root package name */
        private int f3331k;

        /* renamed from: l  reason: collision with root package name */
        private int f3332l;

        /* renamed from: m  reason: collision with root package name */
        private int f3333m;

        /* renamed from: n  reason: collision with root package name */
        private int f3334n;
        private int o;
        private int p;
        private int q;
        private int r;
        private int s;
        private int t;
        private int u;

        /* renamed from: a */
        public void readProperties(@NonNull Toolbar toolbar, @NonNull PropertyReader propertyReader) {
            if (this.f3321a) {
                propertyReader.readObject(this.f3322b, toolbar.getCollapseContentDescription());
                propertyReader.readObject(this.f3323c, toolbar.getCollapseIcon());
                propertyReader.readInt(this.f3324d, toolbar.getContentInsetEnd());
                propertyReader.readInt(this.f3325e, toolbar.getContentInsetEndWithActions());
                propertyReader.readInt(this.f3326f, toolbar.getContentInsetLeft());
                propertyReader.readInt(this.f3327g, toolbar.getContentInsetRight());
                propertyReader.readInt(this.f3328h, toolbar.getContentInsetStart());
                propertyReader.readInt(this.f3329i, toolbar.getContentInsetStartWithNavigation());
                propertyReader.readObject(this.f3330j, toolbar.getLogo());
                propertyReader.readObject(this.f3331k, toolbar.getLogoDescription());
                propertyReader.readObject(this.f3332l, toolbar.getMenu());
                propertyReader.readObject(this.f3333m, toolbar.getNavigationContentDescription());
                propertyReader.readObject(this.f3334n, toolbar.getNavigationIcon());
                propertyReader.readResourceId(this.o, toolbar.getPopupTheme());
                propertyReader.readObject(this.p, toolbar.getSubtitle());
                propertyReader.readObject(this.q, toolbar.getTitle());
                propertyReader.readInt(this.r, toolbar.getTitleMarginBottom());
                propertyReader.readInt(this.s, toolbar.getTitleMarginEnd());
                propertyReader.readInt(this.t, toolbar.getTitleMarginStart());
                propertyReader.readInt(this.u, toolbar.getTitleMarginTop());
                return;
            }
            throw C0004e.a();
        }

        public void mapProperties(@NonNull PropertyMapper propertyMapper) {
            this.f3322b = propertyMapper.mapObject("collapseContentDescription", R.attr.z0);
            this.f3323c = propertyMapper.mapObject("collapseIcon", R.attr.A0);
            this.f3324d = propertyMapper.mapInt("contentInsetEnd", R.attr.O0);
            this.f3325e = propertyMapper.mapInt("contentInsetEndWithActions", R.attr.P0);
            this.f3326f = propertyMapper.mapInt("contentInsetLeft", R.attr.Q0);
            this.f3327g = propertyMapper.mapInt("contentInsetRight", R.attr.R0);
            this.f3328h = propertyMapper.mapInt("contentInsetStart", R.attr.S0);
            this.f3329i = propertyMapper.mapInt("contentInsetStartWithNavigation", R.attr.T0);
            this.f3330j = propertyMapper.mapObject("logo", R.attr.h2);
            this.f3331k = propertyMapper.mapObject("logoDescription", R.attr.i2);
            this.f3332l = propertyMapper.mapObject(HTML.Tag.w0, R.attr.l2);
            this.f3333m = propertyMapper.mapObject("navigationContentDescription", R.attr.n2);
            this.f3334n = propertyMapper.mapObject("navigationIcon", R.attr.o2);
            this.o = propertyMapper.mapResourceId("popupTheme", R.attr.A2);
            this.p = propertyMapper.mapObject("subtitle", R.attr.e3);
            this.q = propertyMapper.mapObject("title", R.attr.J3);
            this.r = propertyMapper.mapInt("titleMarginBottom", R.attr.L3);
            this.s = propertyMapper.mapInt("titleMarginEnd", R.attr.M3);
            this.t = propertyMapper.mapInt("titleMarginStart", R.attr.N3);
            this.u = propertyMapper.mapInt("titleMarginTop", R.attr.O3);
            this.f3321a = true;
        }
    }

    public static class LayoutParams extends ActionBar.LayoutParams {

        /* renamed from: c  reason: collision with root package name */
        static final int f3335c = 0;

        /* renamed from: d  reason: collision with root package name */
        static final int f3336d = 1;

        /* renamed from: e  reason: collision with root package name */
        static final int f3337e = 2;

        /* renamed from: b  reason: collision with root package name */
        int f3338b;

        public LayoutParams(int i2) {
            this(-2, -1, i2);
        }

        /* access modifiers changed from: package-private */
        public void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            this.f3338b = 0;
            this.f2698a = 8388627;
        }

        public LayoutParams(int i2, int i3, int i4) {
            super(i2, i3);
            this.f3338b = 0;
            this.f2698a = i4;
        }

        public LayoutParams(@NonNull Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3338b = 0;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f3338b = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super((ViewGroup.LayoutParams) marginLayoutParams);
            this.f3338b = 0;
            a(marginLayoutParams);
        }

        public LayoutParams(ActionBar.LayoutParams layoutParams) {
            super(layoutParams);
            this.f3338b = 0;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ActionBar.LayoutParams) layoutParams);
            this.f3338b = 0;
            this.f3338b = layoutParams.f3338b;
        }
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: c */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };
        int Y;
        boolean Z;

        public SavedState(Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.Y);
            parcel.writeInt(this.Z ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.Y = parcel.readInt();
            this.Z = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public Toolbar(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private boolean B(View view) {
        return view.getParent() == this || this.A3.contains(view);
    }

    private int G(View view, int i2, int[] iArr, int i4) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i5 = layoutParams.leftMargin - iArr[0];
        int max = i2 + Math.max(0, i5);
        iArr[0] = Math.max(0, -i5);
        int s2 = s(view, i4);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, s2, max + measuredWidth, view.getMeasuredHeight() + s2);
        return max + measuredWidth + layoutParams.rightMargin;
    }

    private int I(View view, int i2, int[] iArr, int i4) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i5 = layoutParams.rightMargin - iArr[1];
        int max = i2 - Math.max(0, i5);
        iArr[1] = Math.max(0, -i5);
        int s2 = s(view, i4);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, s2, max, view.getMeasuredHeight() + s2);
        return max - (measuredWidth + layoutParams.leftMargin);
    }

    private int J(View view, int i2, int i4, int i5, int i6, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i7 = marginLayoutParams.leftMargin - iArr[0];
        int i8 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i7) + Math.max(0, i8);
        iArr[0] = Math.max(0, -i7);
        iArr[1] = Math.max(0, -i8);
        view.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + max + i4, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i5, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i6, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private void L(View view, int i2, int i4, int i5, int i6, int i7) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i4, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i5, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i6, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i7 >= 0) {
            if (mode != 0) {
                i7 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i7);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private void M() {
        Menu menu = getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        this.C3.h(menu, getMenuInflater());
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.D3 = currentMenuItems2;
    }

    private void N() {
        removeCallbacks(this.P3);
        post(this.P3);
    }

    private boolean W() {
        if (!this.L3) {
            return false;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (X(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean X(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private void b(List<View> list, int i2) {
        boolean z = getLayoutDirection() == 1;
        int childCount = getChildCount();
        int d2 = GravityCompat.d(i2, getLayoutDirection());
        list.clear();
        if (z) {
            for (int i4 = childCount - 1; i4 >= 0; i4--) {
                View childAt = getChildAt(i4);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f3338b == 0 && X(childAt) && r(layoutParams.f2698a) == d2) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt2 = getChildAt(i5);
            LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
            if (layoutParams2.f3338b == 0 && X(childAt2) && r(layoutParams2.f2698a) == d2) {
                list.add(childAt2);
            }
        }
    }

    private void d(View view, boolean z) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        LayoutParams o = layoutParams == null ? generateDefaultLayoutParams() : !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (LayoutParams) layoutParams;
        o.f3338b = 1;
        if (!z || this.e3 == null) {
            addView(view, o);
            return;
        }
        view.setLayoutParams(o);
        this.A3.add(view);
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i2 = 0; i2 < menu.size(); i2++) {
            arrayList.add(menu.getItem(i2));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new SupportMenuInflater(getContext());
    }

    private void j() {
        if (this.p3 == null) {
            this.p3 = new RtlSpacingHelper();
        }
    }

    private void k() {
        if (this.a3 == null) {
            this.a3 = new AppCompatImageView(getContext());
        }
    }

    private void l() {
        m();
        if (this.s.R() == null) {
            MenuBuilder menuBuilder = (MenuBuilder) this.s.getMenu();
            if (this.I3 == null) {
                this.I3 = new ExpandedActionViewMenuPresenter();
            }
            this.s.setExpandedActionViewsExclusive(true);
            menuBuilder.c(this.I3, this.f3);
            Z();
        }
    }

    private void m() {
        if (this.s == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.s = actionMenuView;
            actionMenuView.setPopupTheme(this.g3);
            this.s.setOnMenuItemClickListener(this.F3);
            this.s.S(this.J3, new MenuBuilder.Callback() {
                public boolean a(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
                    MenuBuilder.Callback callback = Toolbar.this.K3;
                    return callback != null && callback.a(menuBuilder, menuItem);
                }

                public void b(@NonNull MenuBuilder menuBuilder) {
                    if (!Toolbar.this.s.N()) {
                        Toolbar.this.C3.k(menuBuilder);
                    }
                    MenuBuilder.Callback callback = Toolbar.this.K3;
                    if (callback != null) {
                        callback.b(menuBuilder);
                    }
                }
            });
            LayoutParams o = generateDefaultLayoutParams();
            o.f2698a = (this.j3 & 112) | GravityCompat.f6388c;
            this.s.setLayoutParams(o);
            d(this.s, false);
        }
    }

    private void n() {
        if (this.Z2 == null) {
            this.Z2 = new AppCompatImageButton(getContext(), (AttributeSet) null, R.attr.T3);
            LayoutParams o = generateDefaultLayoutParams();
            o.f2698a = (this.j3 & 112) | GravityCompat.f6387b;
            this.Z2.setLayoutParams(o);
        }
    }

    private int r(int i2) {
        int layoutDirection = getLayoutDirection();
        int d2 = GravityCompat.d(i2, layoutDirection) & 7;
        if (d2 == 1 || d2 == 3 || d2 == 5) {
            return d2;
        }
        return layoutDirection == 1 ? 5 : 3;
    }

    private int s(View view, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = i2 > 0 ? (measuredHeight - i2) / 2 : 0;
        int t = t(layoutParams.f2698a);
        if (t == 48) {
            return getPaddingTop() - i4;
        }
        if (t == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - layoutParams.bottomMargin) - i4;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int i5 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i6 = layoutParams.topMargin;
        if (i5 < i6) {
            i5 = i6;
        } else {
            int i7 = (((height - paddingBottom) - measuredHeight) - i5) - paddingTop;
            int i8 = layoutParams.bottomMargin;
            if (i7 < i8) {
                i5 = Math.max(0, i5 - (i8 - i7));
            }
        }
        return paddingTop + i5;
    }

    private int t(int i2) {
        int i4 = i2 & 112;
        return (i4 == 16 || i4 == 48 || i4 == 80) ? i4 : this.s3 & 112;
    }

    private int u(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.getMarginStart() + marginLayoutParams.getMarginEnd();
    }

    private int v(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private int w(List<View> list, int[] iArr) {
        int i2 = iArr[0];
        int i4 = iArr[1];
        int size = list.size();
        int i5 = 0;
        int i6 = 0;
        while (i5 < size) {
            View view = list.get(i5);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int i7 = layoutParams.leftMargin - i2;
            int i8 = layoutParams.rightMargin - i4;
            int max = Math.max(0, i7);
            int max2 = Math.max(0, i8);
            int max3 = Math.max(0, -i7);
            int max4 = Math.max(0, -i8);
            i6 += max + view.getMeasuredWidth() + max2;
            i5++;
            i4 = max4;
            i2 = max3;
        }
        return i6;
    }

    public boolean A() {
        return this.O3;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean C() {
        ActionMenuView actionMenuView = this.s;
        return actionMenuView != null && actionMenuView.M();
    }

    public boolean D() {
        ActionMenuView actionMenuView = this.s;
        return actionMenuView != null && actionMenuView.N();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean E() {
        Layout layout2;
        TextView textView = this.X2;
        if (textView == null || (layout2 = textView.getLayout()) == null) {
            return false;
        }
        int lineCount = layout2.getLineCount();
        for (int i2 = 0; i2 < lineCount; i2++) {
            if (layout2.getEllipsisCount(i2) > 0) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"LambdaLast"})
    @MainThread
    public void F(@NonNull MenuProvider menuProvider, @NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.State state) {
        this.C3.e(menuProvider, lifecycleOwner, state);
    }

    @MainThread
    public void H(@NonNull MenuProvider menuProvider) {
        this.C3.c(menuProvider);
    }

    @MainThread
    public void K() {
        Iterator<MenuItem> it2 = this.D3.iterator();
        while (it2.hasNext()) {
            getMenu().removeItem(it2.next().getItemId());
        }
        M();
    }

    /* access modifiers changed from: package-private */
    public void O() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (!(((LayoutParams) childAt.getLayoutParams()).f3338b == 2 || childAt == this.s)) {
                removeViewAt(childCount);
                this.A3.add(childAt);
            }
        }
    }

    public void P(int i2, int i4) {
        j();
        this.p3.e(i2, i4);
    }

    public void Q(int i2, int i4) {
        j();
        this.p3.g(i2, i4);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void R(MenuBuilder menuBuilder, ActionMenuPresenter actionMenuPresenter) {
        if (menuBuilder != null || this.s != null) {
            m();
            MenuBuilder R = this.s.R();
            if (R != menuBuilder) {
                if (R != null) {
                    R.T(this.H3);
                    R.T(this.I3);
                }
                if (this.I3 == null) {
                    this.I3 = new ExpandedActionViewMenuPresenter();
                }
                actionMenuPresenter.K(true);
                if (menuBuilder != null) {
                    menuBuilder.c(actionMenuPresenter, this.f3);
                    menuBuilder.c(this.I3, this.f3);
                } else {
                    actionMenuPresenter.i(this.f3, (MenuBuilder) null);
                    this.I3.i(this.f3, (MenuBuilder) null);
                    actionMenuPresenter.d(true);
                    this.I3.d(true);
                }
                this.s.setPopupTheme(this.g3);
                this.s.setPresenter(actionMenuPresenter);
                this.H3 = actionMenuPresenter;
                Z();
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void S(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.J3 = callback;
        this.K3 = callback2;
        ActionMenuView actionMenuView = this.s;
        if (actionMenuView != null) {
            actionMenuView.S(callback, callback2);
        }
    }

    public void T(Context context, @StyleRes int i2) {
        this.i3 = i2;
        TextView textView = this.Y2;
        if (textView != null) {
            textView.setTextAppearance(context, i2);
        }
    }

    public void U(int i2, int i4, int i5, int i6) {
        this.l3 = i2;
        this.n3 = i4;
        this.m3 = i5;
        this.o3 = i6;
        requestLayout();
    }

    public void V(Context context, @StyleRes int i2) {
        this.h3 = i2;
        TextView textView = this.X2;
        if (textView != null) {
            textView.setTextAppearance(context, i2);
        }
    }

    public boolean Y() {
        ActionMenuView actionMenuView = this.s;
        return actionMenuView != null && actionMenuView.T();
    }

    /* access modifiers changed from: package-private */
    public void Z() {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher a2 = Api33Impl.a(this);
            boolean z = x() && a2 != null && isAttachedToWindow() && this.O3;
            if (z && this.N3 == null) {
                if (this.M3 == null) {
                    this.M3 = Api33Impl.b(new Q(this));
                }
                Api33Impl.c(a2, this.M3);
            } else if (!z && (onBackInvokedDispatcher = this.N3) != null) {
                Api33Impl.d(onBackInvokedDispatcher, this.M3);
                a2 = null;
            } else {
                return;
            }
            this.N3 = a2;
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        for (int size = this.A3.size() - 1; size >= 0; size--) {
            addView(this.A3.get(size));
        }
        this.A3.clear();
    }

    @MainThread
    public void c(@NonNull MenuProvider menuProvider, @NonNull LifecycleOwner lifecycleOwner) {
        this.C3.d(menuProvider, lifecycleOwner);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r1.s;
     */
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean e() {
        /*
            r1 = this;
            int r0 = r1.getVisibility()
            if (r0 != 0) goto L_0x0012
            androidx.appcompat.widget.ActionMenuView r0 = r1.s
            if (r0 == 0) goto L_0x0012
            boolean r0 = r0.O()
            if (r0 == 0) goto L_0x0012
            r0 = 1
            goto L_0x0013
        L_0x0012:
            r0 = 0
        L_0x0013:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.e():boolean");
    }

    @MainThread
    public void f(@NonNull MenuProvider menuProvider) {
        this.C3.l(menuProvider);
    }

    public void g() {
        ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = this.I3;
        MenuItemImpl menuItemImpl = expandedActionViewMenuPresenter == null ? null : expandedActionViewMenuPresenter.X;
        if (menuItemImpl != null) {
            menuItemImpl.collapseActionView();
        }
    }

    @Nullable
    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.d3;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    @Nullable
    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.d3;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        RtlSpacingHelper rtlSpacingHelper = this.p3;
        if (rtlSpacingHelper != null) {
            return rtlSpacingHelper.a();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i2 = this.r3;
        return i2 != Integer.MIN_VALUE ? i2 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        RtlSpacingHelper rtlSpacingHelper = this.p3;
        if (rtlSpacingHelper != null) {
            return rtlSpacingHelper.b();
        }
        return 0;
    }

    public int getContentInsetRight() {
        RtlSpacingHelper rtlSpacingHelper = this.p3;
        if (rtlSpacingHelper != null) {
            return rtlSpacingHelper.c();
        }
        return 0;
    }

    public int getContentInsetStart() {
        RtlSpacingHelper rtlSpacingHelper = this.p3;
        if (rtlSpacingHelper != null) {
            return rtlSpacingHelper.d();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i2 = this.q3;
        return i2 != Integer.MIN_VALUE ? i2 : getContentInsetStart();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.R();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getCurrentContentInsetEnd() {
        /*
            r3 = this;
            androidx.appcompat.widget.ActionMenuView r0 = r3.s
            if (r0 == 0) goto L_0x0020
            androidx.appcompat.view.menu.MenuBuilder r0 = r0.R()
            if (r0 == 0) goto L_0x0020
            boolean r0 = r0.hasVisibleItems()
            if (r0 == 0) goto L_0x0020
            int r0 = r3.getContentInsetEnd()
            int r1 = r3.r3
            r2 = 0
            int r1 = java.lang.Math.max(r1, r2)
            int r0 = java.lang.Math.max(r0, r1)
            goto L_0x0024
        L_0x0020:
            int r0 = r3.getContentInsetEnd()
        L_0x0024:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.getCurrentContentInsetEnd():int");
    }

    public int getCurrentContentInsetLeft() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.q3, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.a3;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.a3;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        l();
        return this.s.getMenu();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    @Nullable
    public View getNavButtonView() {
        return this.Z2;
    }

    @Nullable
    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.Z2;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    @Nullable
    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.Z2;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.H3;
    }

    @Nullable
    public Drawable getOverflowIcon() {
        l();
        return this.s.getOverflowIcon();
    }

    /* access modifiers changed from: package-private */
    public Context getPopupContext() {
        return this.f3;
    }

    @StyleRes
    public int getPopupTheme() {
        return this.g3;
    }

    public CharSequence getSubtitle() {
        return this.u3;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    @Nullable
    public final TextView getSubtitleTextView() {
        return this.Y2;
    }

    public CharSequence getTitle() {
        return this.t3;
    }

    public int getTitleMarginBottom() {
        return this.o3;
    }

    public int getTitleMarginEnd() {
        return this.m3;
    }

    public int getTitleMarginStart() {
        return this.l3;
    }

    public int getTitleMarginTop() {
        return this.n3;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    @Nullable
    public final TextView getTitleTextView() {
        return this.X2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DecorToolbar getWrapper() {
        if (this.G3 == null) {
            this.G3 = new ToolbarWidgetWrapper(this, true);
        }
        return this.G3;
    }

    public void h() {
        ActionMenuView actionMenuView = this.s;
        if (actionMenuView != null) {
            actionMenuView.F();
        }
    }

    /* access modifiers changed from: package-private */
    public void i() {
        if (this.d3 == null) {
            AppCompatImageButton appCompatImageButton = new AppCompatImageButton(getContext(), (AttributeSet) null, R.attr.T3);
            this.d3 = appCompatImageButton;
            appCompatImageButton.setImageDrawable(this.b3);
            this.d3.setContentDescription(this.c3);
            LayoutParams o = generateDefaultLayoutParams();
            o.f2698a = (this.j3 & 112) | GravityCompat.f6387b;
            o.f3338b = 2;
            this.d3.setLayoutParams(o);
            this.d3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Toolbar.this.g();
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Z();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.P3);
        Z();
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.y3 = false;
        }
        if (!this.y3) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.y3 = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.y3 = false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0297 A[LOOP:0: B:108:0x0295->B:109:0x0297, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x02b9 A[LOOP:1: B:111:0x02b7->B:112:0x02b9, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x02e3  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x02f2 A[LOOP:2: B:119:0x02f0->B:120:0x02f2, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x021d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            r19 = this;
            r0 = r19
            int r1 = r19.getLayoutDirection()
            r2 = 0
            r3 = 1
            if (r1 != r3) goto L_0x000c
            r1 = 1
            goto L_0x000d
        L_0x000c:
            r1 = 0
        L_0x000d:
            int r4 = r19.getWidth()
            int r5 = r19.getHeight()
            int r6 = r19.getPaddingLeft()
            int r7 = r19.getPaddingRight()
            int r8 = r19.getPaddingTop()
            int r9 = r19.getPaddingBottom()
            int r10 = r4 - r7
            int[] r11 = r0.B3
            r11[r3] = r2
            r11[r2] = r2
            int r12 = androidx.core.view.ViewCompat.h0(r19)
            if (r12 < 0) goto L_0x003a
            int r13 = r24 - r22
            int r12 = java.lang.Math.min(r12, r13)
            goto L_0x003b
        L_0x003a:
            r12 = 0
        L_0x003b:
            android.widget.ImageButton r13 = r0.Z2
            boolean r13 = r0.X(r13)
            if (r13 == 0) goto L_0x0054
            android.widget.ImageButton r13 = r0.Z2
            if (r1 == 0) goto L_0x004e
            int r13 = r0.I(r13, r10, r11, r12)
            r14 = r13
            r13 = r6
            goto L_0x0056
        L_0x004e:
            int r13 = r0.G(r13, r6, r11, r12)
        L_0x0052:
            r14 = r10
            goto L_0x0056
        L_0x0054:
            r13 = r6
            goto L_0x0052
        L_0x0056:
            android.widget.ImageButton r15 = r0.d3
            boolean r15 = r0.X(r15)
            if (r15 == 0) goto L_0x006b
            android.widget.ImageButton r15 = r0.d3
            if (r1 == 0) goto L_0x0067
            int r14 = r0.I(r15, r14, r11, r12)
            goto L_0x006b
        L_0x0067:
            int r13 = r0.G(r15, r13, r11, r12)
        L_0x006b:
            androidx.appcompat.widget.ActionMenuView r15 = r0.s
            boolean r15 = r0.X(r15)
            if (r15 == 0) goto L_0x0080
            androidx.appcompat.widget.ActionMenuView r15 = r0.s
            if (r1 == 0) goto L_0x007c
            int r13 = r0.G(r15, r13, r11, r12)
            goto L_0x0080
        L_0x007c:
            int r14 = r0.I(r15, r14, r11, r12)
        L_0x0080:
            int r15 = r19.getCurrentContentInsetLeft()
            int r16 = r19.getCurrentContentInsetRight()
            int r3 = r15 - r13
            int r3 = java.lang.Math.max(r2, r3)
            r11[r2] = r3
            int r3 = r10 - r14
            int r3 = r16 - r3
            int r3 = java.lang.Math.max(r2, r3)
            r17 = 1
            r11[r17] = r3
            int r3 = java.lang.Math.max(r13, r15)
            int r10 = r10 - r16
            int r10 = java.lang.Math.min(r14, r10)
            android.view.View r13 = r0.e3
            boolean r13 = r0.X(r13)
            if (r13 == 0) goto L_0x00bb
            android.view.View r13 = r0.e3
            if (r1 == 0) goto L_0x00b7
            int r10 = r0.I(r13, r10, r11, r12)
            goto L_0x00bb
        L_0x00b7:
            int r3 = r0.G(r13, r3, r11, r12)
        L_0x00bb:
            android.widget.ImageView r13 = r0.a3
            boolean r13 = r0.X(r13)
            if (r13 == 0) goto L_0x00d0
            android.widget.ImageView r13 = r0.a3
            if (r1 == 0) goto L_0x00cc
            int r10 = r0.I(r13, r10, r11, r12)
            goto L_0x00d0
        L_0x00cc:
            int r3 = r0.G(r13, r3, r11, r12)
        L_0x00d0:
            android.widget.TextView r13 = r0.X2
            boolean r13 = r0.X(r13)
            android.widget.TextView r14 = r0.Y2
            boolean r14 = r0.X(r14)
            if (r13 == 0) goto L_0x00f5
            android.widget.TextView r15 = r0.X2
            android.view.ViewGroup$LayoutParams r15 = r15.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r15 = (androidx.appcompat.widget.Toolbar.LayoutParams) r15
            int r2 = r15.topMargin
            r23 = r7
            android.widget.TextView r7 = r0.X2
            int r7 = r7.getMeasuredHeight()
            int r2 = r2 + r7
            int r7 = r15.bottomMargin
            int r2 = r2 + r7
            goto L_0x00f8
        L_0x00f5:
            r23 = r7
            r2 = 0
        L_0x00f8:
            if (r14 == 0) goto L_0x0112
            android.widget.TextView r7 = r0.Y2
            android.view.ViewGroup$LayoutParams r7 = r7.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r7 = (androidx.appcompat.widget.Toolbar.LayoutParams) r7
            int r15 = r7.topMargin
            r16 = r4
            android.widget.TextView r4 = r0.Y2
            int r4 = r4.getMeasuredHeight()
            int r15 = r15 + r4
            int r4 = r7.bottomMargin
            int r15 = r15 + r4
            int r2 = r2 + r15
            goto L_0x0114
        L_0x0112:
            r16 = r4
        L_0x0114:
            if (r13 != 0) goto L_0x0120
            if (r14 == 0) goto L_0x0119
            goto L_0x0120
        L_0x0119:
            r18 = r6
            r22 = r12
        L_0x011d:
            r2 = 0
            goto L_0x0287
        L_0x0120:
            if (r13 == 0) goto L_0x0125
            android.widget.TextView r4 = r0.X2
            goto L_0x0127
        L_0x0125:
            android.widget.TextView r4 = r0.Y2
        L_0x0127:
            if (r14 == 0) goto L_0x012c
            android.widget.TextView r7 = r0.Y2
            goto L_0x012e
        L_0x012c:
            android.widget.TextView r7 = r0.X2
        L_0x012e:
            android.view.ViewGroup$LayoutParams r4 = r4.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r4 = (androidx.appcompat.widget.Toolbar.LayoutParams) r4
            android.view.ViewGroup$LayoutParams r7 = r7.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r7 = (androidx.appcompat.widget.Toolbar.LayoutParams) r7
            if (r13 == 0) goto L_0x0144
            android.widget.TextView r15 = r0.X2
            int r15 = r15.getMeasuredWidth()
            if (r15 > 0) goto L_0x014e
        L_0x0144:
            if (r14 == 0) goto L_0x0151
            android.widget.TextView r15 = r0.Y2
            int r15 = r15.getMeasuredWidth()
            if (r15 <= 0) goto L_0x0151
        L_0x014e:
            r17 = 1
            goto L_0x0153
        L_0x0151:
            r17 = 0
        L_0x0153:
            int r15 = r0.s3
            r15 = r15 & 112(0x70, float:1.57E-43)
            r18 = r6
            r6 = 48
            if (r15 == r6) goto L_0x019b
            r6 = 80
            if (r15 == r6) goto L_0x018d
            int r6 = r5 - r8
            int r6 = r6 - r9
            int r6 = r6 - r2
            int r6 = r6 / 2
            int r15 = r4.topMargin
            r22 = r12
            int r12 = r0.n3
            r24 = r3
            int r3 = r15 + r12
            if (r6 >= r3) goto L_0x0176
            int r6 = r15 + r12
            goto L_0x018b
        L_0x0176:
            int r5 = r5 - r9
            int r5 = r5 - r2
            int r5 = r5 - r6
            int r5 = r5 - r8
            int r2 = r4.bottomMargin
            int r3 = r0.o3
            int r2 = r2 + r3
            if (r5 >= r2) goto L_0x018b
            int r2 = r7.bottomMargin
            int r2 = r2 + r3
            int r2 = r2 - r5
            int r6 = r6 - r2
            r2 = 0
            int r6 = java.lang.Math.max(r2, r6)
        L_0x018b:
            int r8 = r8 + r6
            goto L_0x01aa
        L_0x018d:
            r24 = r3
            r22 = r12
            int r5 = r5 - r9
            int r3 = r7.bottomMargin
            int r5 = r5 - r3
            int r3 = r0.o3
            int r5 = r5 - r3
            int r8 = r5 - r2
            goto L_0x01aa
        L_0x019b:
            r24 = r3
            r22 = r12
            int r2 = r19.getPaddingTop()
            int r3 = r4.topMargin
            int r2 = r2 + r3
            int r3 = r0.n3
            int r8 = r2 + r3
        L_0x01aa:
            if (r1 == 0) goto L_0x021d
            if (r17 == 0) goto L_0x01b2
            int r1 = r0.l3
        L_0x01b0:
            r2 = 1
            goto L_0x01b4
        L_0x01b2:
            r1 = 0
            goto L_0x01b0
        L_0x01b4:
            r3 = r11[r2]
            int r1 = r1 - r3
            r3 = 0
            int r4 = java.lang.Math.max(r3, r1)
            int r10 = r10 - r4
            int r1 = -r1
            int r1 = java.lang.Math.max(r3, r1)
            r11[r2] = r1
            if (r13 == 0) goto L_0x01ea
            android.widget.TextView r1 = r0.X2
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r1 = (androidx.appcompat.widget.Toolbar.LayoutParams) r1
            android.widget.TextView r2 = r0.X2
            int r2 = r2.getMeasuredWidth()
            int r2 = r10 - r2
            android.widget.TextView r3 = r0.X2
            int r3 = r3.getMeasuredHeight()
            int r3 = r3 + r8
            android.widget.TextView r4 = r0.X2
            r4.layout(r2, r8, r10, r3)
            int r4 = r0.m3
            int r2 = r2 - r4
            int r1 = r1.bottomMargin
            int r8 = r3 + r1
            goto L_0x01eb
        L_0x01ea:
            r2 = r10
        L_0x01eb:
            if (r14 == 0) goto L_0x0211
            android.widget.TextView r1 = r0.Y2
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r1 = (androidx.appcompat.widget.Toolbar.LayoutParams) r1
            int r1 = r1.topMargin
            int r8 = r8 + r1
            android.widget.TextView r1 = r0.Y2
            int r1 = r1.getMeasuredWidth()
            int r1 = r10 - r1
            android.widget.TextView r3 = r0.Y2
            int r3 = r3.getMeasuredHeight()
            int r3 = r3 + r8
            android.widget.TextView r4 = r0.Y2
            r4.layout(r1, r8, r10, r3)
            int r1 = r0.m3
            int r1 = r10 - r1
            goto L_0x0212
        L_0x0211:
            r1 = r10
        L_0x0212:
            if (r17 == 0) goto L_0x0219
            int r1 = java.lang.Math.min(r2, r1)
            r10 = r1
        L_0x0219:
            r3 = r24
            goto L_0x011d
        L_0x021d:
            if (r17 == 0) goto L_0x0224
            int r2 = r0.l3
            r1 = r2
        L_0x0222:
            r2 = 0
            goto L_0x0226
        L_0x0224:
            r1 = 0
            goto L_0x0222
        L_0x0226:
            r3 = r11[r2]
            int r1 = r1 - r3
            int r3 = java.lang.Math.max(r2, r1)
            int r3 = r24 + r3
            int r1 = -r1
            int r1 = java.lang.Math.max(r2, r1)
            r11[r2] = r1
            if (r13 == 0) goto L_0x025b
            android.widget.TextView r1 = r0.X2
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r1 = (androidx.appcompat.widget.Toolbar.LayoutParams) r1
            android.widget.TextView r4 = r0.X2
            int r4 = r4.getMeasuredWidth()
            int r4 = r4 + r3
            android.widget.TextView r5 = r0.X2
            int r5 = r5.getMeasuredHeight()
            int r5 = r5 + r8
            android.widget.TextView r6 = r0.X2
            r6.layout(r3, r8, r4, r5)
            int r6 = r0.m3
            int r4 = r4 + r6
            int r1 = r1.bottomMargin
            int r8 = r5 + r1
            goto L_0x025c
        L_0x025b:
            r4 = r3
        L_0x025c:
            if (r14 == 0) goto L_0x0280
            android.widget.TextView r1 = r0.Y2
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r1 = (androidx.appcompat.widget.Toolbar.LayoutParams) r1
            int r1 = r1.topMargin
            int r8 = r8 + r1
            android.widget.TextView r1 = r0.Y2
            int r1 = r1.getMeasuredWidth()
            int r1 = r1 + r3
            android.widget.TextView r5 = r0.Y2
            int r5 = r5.getMeasuredHeight()
            int r5 = r5 + r8
            android.widget.TextView r6 = r0.Y2
            r6.layout(r3, r8, r1, r5)
            int r5 = r0.m3
            int r1 = r1 + r5
            goto L_0x0281
        L_0x0280:
            r1 = r3
        L_0x0281:
            if (r17 == 0) goto L_0x0287
            int r3 = java.lang.Math.max(r4, r1)
        L_0x0287:
            java.util.ArrayList<android.view.View> r1 = r0.z3
            r4 = 3
            r0.b(r1, r4)
            java.util.ArrayList<android.view.View> r1 = r0.z3
            int r1 = r1.size()
            r4 = r3
            r3 = 0
        L_0x0295:
            if (r3 >= r1) goto L_0x02a8
            java.util.ArrayList<android.view.View> r5 = r0.z3
            java.lang.Object r5 = r5.get(r3)
            android.view.View r5 = (android.view.View) r5
            r12 = r22
            int r4 = r0.G(r5, r4, r11, r12)
            int r3 = r3 + 1
            goto L_0x0295
        L_0x02a8:
            r12 = r22
            java.util.ArrayList<android.view.View> r1 = r0.z3
            r3 = 5
            r0.b(r1, r3)
            java.util.ArrayList<android.view.View> r1 = r0.z3
            int r1 = r1.size()
            r3 = 0
        L_0x02b7:
            if (r3 >= r1) goto L_0x02c8
            java.util.ArrayList<android.view.View> r5 = r0.z3
            java.lang.Object r5 = r5.get(r3)
            android.view.View r5 = (android.view.View) r5
            int r10 = r0.I(r5, r10, r11, r12)
            int r3 = r3 + 1
            goto L_0x02b7
        L_0x02c8:
            java.util.ArrayList<android.view.View> r1 = r0.z3
            r3 = 1
            r0.b(r1, r3)
            java.util.ArrayList<android.view.View> r1 = r0.z3
            int r1 = r0.w(r1, r11)
            int r3 = r16 - r18
            int r3 = r3 - r23
            int r3 = r3 / 2
            int r6 = r18 + r3
            int r3 = r1 / 2
            int r6 = r6 - r3
            int r1 = r1 + r6
            if (r6 >= r4) goto L_0x02e3
            goto L_0x02ea
        L_0x02e3:
            if (r1 <= r10) goto L_0x02e9
            int r1 = r1 - r10
            int r4 = r6 - r1
            goto L_0x02ea
        L_0x02e9:
            r4 = r6
        L_0x02ea:
            java.util.ArrayList<android.view.View> r1 = r0.z3
            int r1 = r1.size()
        L_0x02f0:
            if (r2 >= r1) goto L_0x0301
            java.util.ArrayList<android.view.View> r3 = r0.z3
            java.lang.Object r3 = r3.get(r2)
            android.view.View r3 = (android.view.View) r3
            int r4 = r0.G(r3, r4, r11, r12)
            int r2 = r2 + 1
            goto L_0x02f0
        L_0x0301:
            java.util.ArrayList<android.view.View> r1 = r0.z3
            r1.clear()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int[] iArr = this.B3;
        char b2 = ViewUtils.b(this);
        int i12 = 0;
        char c2 = b2 ^ 1;
        if (X(this.Z2)) {
            L(this.Z2, i2, 0, i4, 0, this.k3);
            i7 = this.Z2.getMeasuredWidth() + u(this.Z2);
            i6 = Math.max(0, this.Z2.getMeasuredHeight() + v(this.Z2));
            i5 = View.combineMeasuredStates(0, this.Z2.getMeasuredState());
        } else {
            i7 = 0;
            i6 = 0;
            i5 = 0;
        }
        if (X(this.d3)) {
            L(this.d3, i2, 0, i4, 0, this.k3);
            i7 = this.d3.getMeasuredWidth() + u(this.d3);
            i6 = Math.max(i6, this.d3.getMeasuredHeight() + v(this.d3));
            i5 = View.combineMeasuredStates(i5, this.d3.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max = Math.max(currentContentInsetStart, i7);
        iArr[b2] = Math.max(0, currentContentInsetStart - i7);
        if (X(this.s)) {
            L(this.s, i2, max, i4, 0, this.k3);
            i8 = this.s.getMeasuredWidth() + u(this.s);
            i6 = Math.max(i6, this.s.getMeasuredHeight() + v(this.s));
            i5 = View.combineMeasuredStates(i5, this.s.getMeasuredState());
        } else {
            i8 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max2 = max + Math.max(currentContentInsetEnd, i8);
        iArr[c2] = Math.max(0, currentContentInsetEnd - i8);
        if (X(this.e3)) {
            max2 += J(this.e3, i2, max2, i4, 0, iArr);
            i6 = Math.max(i6, this.e3.getMeasuredHeight() + v(this.e3));
            i5 = View.combineMeasuredStates(i5, this.e3.getMeasuredState());
        }
        if (X(this.a3)) {
            max2 += J(this.a3, i2, max2, i4, 0, iArr);
            i6 = Math.max(i6, this.a3.getMeasuredHeight() + v(this.a3));
            i5 = View.combineMeasuredStates(i5, this.a3.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (((LayoutParams) childAt.getLayoutParams()).f3338b == 0 && X(childAt)) {
                max2 += J(childAt, i2, max2, i4, 0, iArr);
                i6 = Math.max(i6, childAt.getMeasuredHeight() + v(childAt));
                i5 = View.combineMeasuredStates(i5, childAt.getMeasuredState());
            }
        }
        int i14 = this.n3 + this.o3;
        int i15 = this.l3 + this.m3;
        if (X(this.X2)) {
            J(this.X2, i2, max2 + i15, i4, i14, iArr);
            int measuredWidth = this.X2.getMeasuredWidth() + u(this.X2);
            i9 = this.X2.getMeasuredHeight() + v(this.X2);
            i11 = View.combineMeasuredStates(i5, this.X2.getMeasuredState());
            i10 = measuredWidth;
        } else {
            i11 = i5;
            i10 = 0;
            i9 = 0;
        }
        if (X(this.Y2)) {
            int i16 = i9 + i14;
            i10 = Math.max(i10, J(this.Y2, i2, max2 + i15, i4, i16, iArr));
            i9 += this.Y2.getMeasuredHeight() + v(this.Y2);
            i11 = View.combineMeasuredStates(i11, this.Y2.getMeasuredState());
        } else {
            int i17 = i11;
        }
        int max3 = Math.max(i6, i9);
        int paddingLeft = max2 + i10 + getPaddingLeft() + getPaddingRight();
        int paddingTop = max3 + getPaddingTop() + getPaddingBottom();
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i2, -16777216 & i11);
        int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i4, i11 << 16);
        if (!W()) {
            i12 = resolveSizeAndState2;
        }
        setMeasuredDimension(resolveSizeAndState, i12);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        ActionMenuView actionMenuView = this.s;
        MenuBuilder R = actionMenuView != null ? actionMenuView.R() : null;
        int i2 = savedState.Y;
        if (!(i2 == 0 || this.I3 == null || R == null || (findItem = R.findItem(i2)) == null)) {
            findItem.expandActionView();
        }
        if (savedState.Z) {
            N();
        }
    }

    public void onRtlPropertiesChanged(int i2) {
        super.onRtlPropertiesChanged(i2);
        j();
        RtlSpacingHelper rtlSpacingHelper = this.p3;
        boolean z = true;
        if (i2 != 1) {
            z = false;
        }
        rtlSpacingHelper.f(z);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        MenuItemImpl menuItemImpl;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = this.I3;
        if (!(expandedActionViewMenuPresenter == null || (menuItemImpl = expandedActionViewMenuPresenter.X) == null)) {
            savedState.Y = menuItemImpl.getItemId();
        }
        savedState.Z = D();
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.x3 = false;
        }
        if (!this.x3) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.x3 = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.x3 = false;
        }
        return true;
    }

    /* renamed from: p */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ActionBar.LayoutParams) {
            return new LayoutParams((ActionBar.LayoutParams) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public void setBackInvokedCallbackEnabled(boolean z) {
        if (this.O3 != z) {
            this.O3 = z;
            Z();
        }
    }

    public void setCollapseContentDescription(@StringRes int i2) {
        setCollapseContentDescription(i2 != 0 ? getContext().getText(i2) : null);
    }

    public void setCollapseIcon(@DrawableRes int i2) {
        setCollapseIcon(AppCompatResources.b(getContext(), i2));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setCollapsible(boolean z) {
        this.L3 = z;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i2) {
        if (i2 < 0) {
            i2 = Integer.MIN_VALUE;
        }
        if (i2 != this.r3) {
            this.r3 = i2;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i2) {
        if (i2 < 0) {
            i2 = Integer.MIN_VALUE;
        }
        if (i2 != this.q3) {
            this.q3 = i2;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(@DrawableRes int i2) {
        setLogo(AppCompatResources.b(getContext(), i2));
    }

    public void setLogoDescription(@StringRes int i2) {
        setLogoDescription(getContext().getText(i2));
    }

    public void setNavigationContentDescription(@StringRes int i2) {
        setNavigationContentDescription(i2 != 0 ? getContext().getText(i2) : null);
    }

    public void setNavigationIcon(@DrawableRes int i2) {
        setNavigationIcon(AppCompatResources.b(getContext(), i2));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        n();
        this.Z2.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.E3 = onMenuItemClickListener;
    }

    public void setOverflowIcon(@Nullable Drawable drawable) {
        l();
        this.s.setOverflowIcon(drawable);
    }

    public void setPopupTheme(@StyleRes int i2) {
        if (this.g3 != i2) {
            this.g3 = i2;
            if (i2 == 0) {
                this.f3 = getContext();
            } else {
                this.f3 = new ContextThemeWrapper(getContext(), i2);
            }
        }
    }

    public void setSubtitle(@StringRes int i2) {
        setSubtitle(getContext().getText(i2));
    }

    public void setSubtitleTextColor(@ColorInt int i2) {
        setSubtitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setTitle(@StringRes int i2) {
        setTitle(getContext().getText(i2));
    }

    public void setTitleMarginBottom(int i2) {
        this.o3 = i2;
        requestLayout();
    }

    public void setTitleMarginEnd(int i2) {
        this.m3 = i2;
        requestLayout();
    }

    public void setTitleMarginStart(int i2) {
        this.l3 = i2;
        requestLayout();
    }

    public void setTitleMarginTop(int i2) {
        this.n3 = i2;
        requestLayout();
    }

    public void setTitleTextColor(@ColorInt int i2) {
        setTitleTextColor(ColorStateList.valueOf(i2));
    }

    public boolean x() {
        ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = this.I3;
        return (expandedActionViewMenuPresenter == null || expandedActionViewMenuPresenter.X == null) ? false : true;
    }

    public boolean y() {
        ActionMenuView actionMenuView = this.s;
        return actionMenuView != null && actionMenuView.L();
    }

    public void z(@MenuRes int i2) {
        getMenuInflater().inflate(i2, getMenu());
    }

    public Toolbar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.U3);
    }

    public void setCollapseContentDescription(@Nullable CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            i();
        }
        ImageButton imageButton = this.d3;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(@Nullable Drawable drawable) {
        if (drawable != null) {
            i();
            this.d3.setImageDrawable(drawable);
            return;
        }
        ImageButton imageButton = this.d3;
        if (imageButton != null) {
            imageButton.setImageDrawable(this.b3);
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            k();
            if (!B(this.a3)) {
                d(this.a3, true);
            }
        } else {
            ImageView imageView = this.a3;
            if (imageView != null && B(imageView)) {
                removeView(this.a3);
                this.A3.remove(this.a3);
            }
        }
        ImageView imageView2 = this.a3;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            k();
        }
        ImageView imageView = this.a3;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(@Nullable CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            n();
        }
        ImageButton imageButton = this.Z2;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
            TooltipCompat.a(this.Z2, charSequence);
        }
    }

    public void setNavigationIcon(@Nullable Drawable drawable) {
        if (drawable != null) {
            n();
            if (!B(this.Z2)) {
                d(this.Z2, true);
            }
        } else {
            ImageButton imageButton = this.Z2;
            if (imageButton != null && B(imageButton)) {
                removeView(this.Z2);
                this.A3.remove(this.Z2);
            }
        }
        ImageButton imageButton2 = this.Z2;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.Y2 == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.Y2 = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.Y2.setEllipsize(TextUtils.TruncateAt.END);
                int i2 = this.i3;
                if (i2 != 0) {
                    this.Y2.setTextAppearance(context, i2);
                }
                ColorStateList colorStateList = this.w3;
                if (colorStateList != null) {
                    this.Y2.setTextColor(colorStateList);
                }
            }
            if (!B(this.Y2)) {
                d(this.Y2, true);
            }
        } else {
            TextView textView = this.Y2;
            if (textView != null && B(textView)) {
                removeView(this.Y2);
                this.A3.remove(this.Y2);
            }
        }
        TextView textView2 = this.Y2;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.u3 = charSequence;
    }

    public void setSubtitleTextColor(@NonNull ColorStateList colorStateList) {
        this.w3 = colorStateList;
        TextView textView = this.Y2;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.X2 == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.X2 = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.X2.setEllipsize(TextUtils.TruncateAt.END);
                int i2 = this.h3;
                if (i2 != 0) {
                    this.X2.setTextAppearance(context, i2);
                }
                ColorStateList colorStateList = this.v3;
                if (colorStateList != null) {
                    this.X2.setTextColor(colorStateList);
                }
            }
            if (!B(this.X2)) {
                d(this.X2, true);
            }
        } else {
            TextView textView = this.X2;
            if (textView != null && B(textView)) {
                removeView(this.X2);
                this.A3.remove(this.X2);
            }
        }
        TextView textView2 = this.X2;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.t3 = charSequence;
    }

    public void setTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.v3 = colorStateList;
        TextView textView = this.X2;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public Toolbar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.s3 = 8388627;
        this.z3 = new ArrayList<>();
        this.A3 = new ArrayList<>();
        this.B3 = new int[2];
        this.C3 = new MenuHostHelper(new S(this));
        this.D3 = new ArrayList<>();
        this.F3 = new ActionMenuView.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (Toolbar.this.C3.j(menuItem)) {
                    return true;
                }
                OnMenuItemClickListener onMenuItemClickListener = Toolbar.this.E3;
                if (onMenuItemClickListener != null) {
                    return onMenuItemClickListener.onMenuItemClick(menuItem);
                }
                return false;
            }
        };
        this.P3 = new Runnable() {
            public void run() {
                Toolbar.this.Y();
            }
        };
        Context context2 = getContext();
        int[] iArr = R.styleable.r6;
        TintTypedArray G = TintTypedArray.G(context2, attributeSet, iArr, i2, 0);
        ViewCompat.F1(this, context, iArr, attributeSet, G.B(), i2, 0);
        this.h3 = G.u(R.styleable.U6, 0);
        this.i3 = G.u(R.styleable.L6, 0);
        this.s3 = G.p(R.styleable.s6, this.s3);
        this.j3 = G.p(R.styleable.u6, 48);
        int f2 = G.f(R.styleable.O6, 0);
        int i4 = R.styleable.T6;
        f2 = G.C(i4) ? G.f(i4, f2) : f2;
        this.o3 = f2;
        this.n3 = f2;
        this.m3 = f2;
        this.l3 = f2;
        int f4 = G.f(R.styleable.R6, -1);
        if (f4 >= 0) {
            this.l3 = f4;
        }
        int f5 = G.f(R.styleable.Q6, -1);
        if (f5 >= 0) {
            this.m3 = f5;
        }
        int f6 = G.f(R.styleable.S6, -1);
        if (f6 >= 0) {
            this.n3 = f6;
        }
        int f7 = G.f(R.styleable.P6, -1);
        if (f7 >= 0) {
            this.o3 = f7;
        }
        this.k3 = G.g(R.styleable.F6, -1);
        int f8 = G.f(R.styleable.B6, Integer.MIN_VALUE);
        int f9 = G.f(R.styleable.x6, Integer.MIN_VALUE);
        int g2 = G.g(R.styleable.z6, 0);
        int g4 = G.g(R.styleable.A6, 0);
        j();
        this.p3.e(g2, g4);
        if (!(f8 == Integer.MIN_VALUE && f9 == Integer.MIN_VALUE)) {
            this.p3.g(f8, f9);
        }
        this.q3 = G.f(R.styleable.C6, Integer.MIN_VALUE);
        this.r3 = G.f(R.styleable.y6, Integer.MIN_VALUE);
        this.b3 = G.h(R.styleable.w6);
        this.c3 = G.x(R.styleable.v6);
        CharSequence x = G.x(R.styleable.N6);
        if (!TextUtils.isEmpty(x)) {
            setTitle(x);
        }
        CharSequence x2 = G.x(R.styleable.K6);
        if (!TextUtils.isEmpty(x2)) {
            setSubtitle(x2);
        }
        this.f3 = getContext();
        setPopupTheme(G.u(R.styleable.J6, 0));
        Drawable h2 = G.h(R.styleable.I6);
        if (h2 != null) {
            setNavigationIcon(h2);
        }
        CharSequence x4 = G.x(R.styleable.H6);
        if (!TextUtils.isEmpty(x4)) {
            setNavigationContentDescription(x4);
        }
        Drawable h4 = G.h(R.styleable.D6);
        if (h4 != null) {
            setLogo(h4);
        }
        CharSequence x5 = G.x(R.styleable.E6);
        if (!TextUtils.isEmpty(x5)) {
            setLogoDescription(x5);
        }
        int i5 = R.styleable.V6;
        if (G.C(i5)) {
            setTitleTextColor(G.d(i5));
        }
        int i6 = R.styleable.M6;
        if (G.C(i6)) {
            setSubtitleTextColor(G.d(i6));
        }
        int i7 = R.styleable.G6;
        if (G.C(i7)) {
            z(G.u(i7, 0));
        }
        G.I();
    }
}
