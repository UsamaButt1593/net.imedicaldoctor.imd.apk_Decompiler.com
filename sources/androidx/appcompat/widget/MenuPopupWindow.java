package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.appcompat.view.menu.MenuBuilder;
import java.lang.reflect.Method;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MenuPopupWindow extends ListPopupWindow implements MenuItemHoverListener {
    private static final String N3 = "MenuPopupWindow";
    private static Method O3;
    private MenuItemHoverListener M3;

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static void a(PopupWindow popupWindow, Transition transition) {
            popupWindow.setEnterTransition(transition);
        }

        @DoNotInline
        static void b(PopupWindow popupWindow, Transition transition) {
            popupWindow.setExitTransition(transition);
        }
    }

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static void a(PopupWindow popupWindow, boolean z) {
            popupWindow.setTouchModal(z);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class MenuDropDownListView extends DropDownListView {
        final int l3;
        final int m3;
        private MenuItemHoverListener n3;
        private MenuItem o3;

        public MenuDropDownListView(Context context, boolean z) {
            super(context, z);
            if (1 == context.getResources().getConfiguration().getLayoutDirection()) {
                this.l3 = 21;
                this.m3 = 22;
                return;
            }
            this.l3 = 22;
            this.m3 = 21;
        }

        public /* bridge */ /* synthetic */ int d(int i2, boolean z) {
            return super.d(i2, z);
        }

        public /* bridge */ /* synthetic */ int e(int i2, int i3, int i4, int i5, int i6) {
            return super.e(i2, i3, i4, i5, i6);
        }

        public /* bridge */ /* synthetic */ boolean f(MotionEvent motionEvent, int i2) {
            return super.f(motionEvent, i2);
        }

        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0035, code lost:
            r2 = (r2 = pointToPosition((int) r5.getX(), (int) r5.getY())) - r1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onHoverEvent(android.view.MotionEvent r5) {
            /*
                r4 = this;
                androidx.appcompat.widget.MenuItemHoverListener r0 = r4.n3
                if (r0 == 0) goto L_0x005c
                android.widget.ListAdapter r0 = r4.getAdapter()
                boolean r1 = r0 instanceof android.widget.HeaderViewListAdapter
                if (r1 == 0) goto L_0x0019
                android.widget.HeaderViewListAdapter r0 = (android.widget.HeaderViewListAdapter) r0
                int r1 = r0.getHeadersCount()
                android.widget.ListAdapter r0 = r0.getWrappedAdapter()
                androidx.appcompat.view.menu.MenuAdapter r0 = (androidx.appcompat.view.menu.MenuAdapter) r0
                goto L_0x001c
            L_0x0019:
                androidx.appcompat.view.menu.MenuAdapter r0 = (androidx.appcompat.view.menu.MenuAdapter) r0
                r1 = 0
            L_0x001c:
                int r2 = r5.getAction()
                r3 = 10
                if (r2 == r3) goto L_0x0043
                float r2 = r5.getX()
                int r2 = (int) r2
                float r3 = r5.getY()
                int r3 = (int) r3
                int r2 = r4.pointToPosition(r2, r3)
                r3 = -1
                if (r2 == r3) goto L_0x0043
                int r2 = r2 - r1
                if (r2 < 0) goto L_0x0043
                int r1 = r0.getCount()
                if (r2 >= r1) goto L_0x0043
                androidx.appcompat.view.menu.MenuItemImpl r1 = r0.getItem(r2)
                goto L_0x0044
            L_0x0043:
                r1 = 0
            L_0x0044:
                android.view.MenuItem r2 = r4.o3
                if (r2 == r1) goto L_0x005c
                androidx.appcompat.view.menu.MenuBuilder r0 = r0.b()
                if (r2 == 0) goto L_0x0053
                androidx.appcompat.widget.MenuItemHoverListener r3 = r4.n3
                r3.h(r0, r2)
            L_0x0053:
                r4.o3 = r1
                if (r1 == 0) goto L_0x005c
                androidx.appcompat.widget.MenuItemHoverListener r2 = r4.n3
                r2.e(r0, r1)
            L_0x005c:
                boolean r5 = super.onHoverEvent(r5)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.MenuPopupWindow.MenuDropDownListView.onHoverEvent(android.view.MotionEvent):boolean");
        }

        public boolean onKeyDown(int i2, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i2 == this.l3) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            } else if (listMenuItemView == null || i2 != this.m3) {
                return super.onKeyDown(i2, keyEvent);
            } else {
                setSelection(-1);
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
                }
                ((MenuAdapter) adapter).b().f(false);
                return true;
            }
        }

        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public void p() {
            setSelection(-1);
        }

        public void setHoverListener(MenuItemHoverListener menuItemHoverListener) {
            this.n3 = menuItemHoverListener;
        }

        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                O3 = PopupWindow.class.getDeclaredMethod("setTouchModal", new Class[]{Boolean.TYPE});
            }
        } catch (NoSuchMethodException unused) {
            Log.i(N3, "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public MenuPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    public void e(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
        MenuItemHoverListener menuItemHoverListener = this.M3;
        if (menuItemHoverListener != null) {
            menuItemHoverListener.e(menuBuilder, menuItem);
        }
    }

    public void h(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
        MenuItemHoverListener menuItemHoverListener = this.M3;
        if (menuItemHoverListener != null) {
            menuItemHoverListener.h(menuBuilder, menuItem);
        }
    }

    public void p0(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            Api23Impl.a(this.y3, (Transition) obj);
        }
    }

    public void q0(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            Api23Impl.b(this.y3, (Transition) obj);
        }
    }

    public void r0(MenuItemHoverListener menuItemHoverListener) {
        this.M3 = menuItemHoverListener;
    }

    public void s0(boolean z) {
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = O3;
            if (method != null) {
                try {
                    method.invoke(this.y3, new Object[]{Boolean.valueOf(z)});
                } catch (Exception unused) {
                    Log.i(N3, "Could not invoke setTouchModal() on PopupWindow. Oh well.");
                }
            }
        } else {
            Api29Impl.a(this.y3, z);
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public DropDownListView u(Context context, boolean z) {
        MenuDropDownListView menuDropDownListView = new MenuDropDownListView(context, z);
        menuDropDownListView.setHoverListener(this);
        return menuDropDownListView;
    }
}
