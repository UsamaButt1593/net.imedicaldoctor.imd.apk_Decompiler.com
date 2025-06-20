package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.core.widget.PopupWindowCompat;
import java.lang.reflect.Method;

public class ListPopupWindow implements ShowableListMenu {
    private static final boolean A3 = false;
    static final int B3 = 250;
    private static Method C3 = null;
    private static Method D3 = null;
    private static Method E3 = null;
    public static final int F3 = 0;
    public static final int G3 = 1;
    public static final int H3 = -1;
    public static final int I3 = -2;
    public static final int J3 = 0;
    public static final int K3 = 1;
    public static final int L3 = 2;
    private static final String z3 = "ListPopupWindow";
    private ListAdapter X;
    private int X2;
    DropDownListView Y;
    private int Y2;
    private int Z;
    private int Z2;
    private int a3;
    private boolean b3;
    private boolean c3;
    private boolean d3;
    private int e3;
    private boolean f3;
    private boolean g3;
    int h3;
    private View i3;
    private int j3;
    private DataSetObserver k3;
    private View l3;
    private Drawable m3;
    private AdapterView.OnItemClickListener n3;
    private AdapterView.OnItemSelectedListener o3;
    final ResizePopupRunnable p3;
    private final PopupTouchInterceptor q3;
    private final PopupScrollListener r3;
    private Context s;
    private final ListSelectorHider s3;
    private Runnable t3;
    final Handler u3;
    private final Rect v3;
    private Rect w3;
    private boolean x3;
    PopupWindow y3;

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static int a(PopupWindow popupWindow, View view, int i2, boolean z) {
            return popupWindow.getMaxAvailableHeight(view, i2, z);
        }
    }

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static void a(PopupWindow popupWindow, Rect rect) {
            popupWindow.setEpicenterBounds(rect);
        }

        @DoNotInline
        static void b(PopupWindow popupWindow, boolean z) {
            popupWindow.setIsClippedToScreen(z);
        }
    }

    private class ListSelectorHider implements Runnable {
        ListSelectorHider() {
        }

        public void run() {
            ListPopupWindow.this.s();
        }
    }

    private class PopupDataSetObserver extends DataSetObserver {
        PopupDataSetObserver() {
        }

        public void onChanged() {
            if (ListPopupWindow.this.b()) {
                ListPopupWindow.this.a();
            }
        }

        public void onInvalidated() {
            ListPopupWindow.this.dismiss();
        }
    }

    private class PopupScrollListener implements AbsListView.OnScrollListener {
        PopupScrollListener() {
        }

        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        }

        public void onScrollStateChanged(AbsListView absListView, int i2) {
            if (i2 == 1 && !ListPopupWindow.this.K() && ListPopupWindow.this.y3.getContentView() != null) {
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                listPopupWindow.u3.removeCallbacks(listPopupWindow.p3);
                ListPopupWindow.this.p3.run();
            }
        }
    }

    private class PopupTouchInterceptor implements View.OnTouchListener {
        PopupTouchInterceptor() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = ListPopupWindow.this.y3) != null && popupWindow.isShowing() && x >= 0 && x < ListPopupWindow.this.y3.getWidth() && y >= 0 && y < ListPopupWindow.this.y3.getHeight()) {
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                listPopupWindow.u3.postDelayed(listPopupWindow.p3, 250);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                ListPopupWindow listPopupWindow2 = ListPopupWindow.this;
                listPopupWindow2.u3.removeCallbacks(listPopupWindow2.p3);
                return false;
            }
        }
    }

    private class ResizePopupRunnable implements Runnable {
        ResizePopupRunnable() {
        }

        public void run() {
            DropDownListView dropDownListView = ListPopupWindow.this.Y;
            if (dropDownListView != null && dropDownListView.isAttachedToWindow() && ListPopupWindow.this.Y.getCount() > ListPopupWindow.this.Y.getChildCount()) {
                int childCount = ListPopupWindow.this.Y.getChildCount();
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                if (childCount <= listPopupWindow.h3) {
                    listPopupWindow.y3.setInputMethodMode(2);
                    ListPopupWindow.this.a();
                }
            }
        }
    }

    static {
        Class<PopupWindow> cls = PopupWindow.class;
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                C3 = cls.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
            } catch (NoSuchMethodException unused) {
                Log.i(z3, "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                E3 = cls.getDeclaredMethod("setEpicenterBounds", new Class[]{Rect.class});
            } catch (NoSuchMethodException unused2) {
                Log.i(z3, "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                D3 = cls.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
            } catch (NoSuchMethodException unused3) {
                Log.i(z3, "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public ListPopupWindow(@NonNull Context context) {
        this(context, (AttributeSet) null, R.attr.Z1);
    }

    private int A(View view, int i2, boolean z) {
        if (Build.VERSION.SDK_INT > 23) {
            return Api24Impl.a(this.y3, view, i2, z);
        }
        Method method = D3;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.y3, new Object[]{view, Integer.valueOf(i2), Boolean.valueOf(z)})).intValue();
            } catch (Exception unused) {
                Log.i(z3, "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.y3.getMaxAvailableHeight(view, i2);
    }

    private static boolean I(int i2) {
        return i2 == 66 || i2 == 23;
    }

    private void R() {
        View view = this.i3;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.i3);
            }
        }
    }

    private void i0(boolean z) {
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = C3;
            if (method != null) {
                try {
                    method.invoke(this.y3, new Object[]{Boolean.valueOf(z)});
                } catch (Exception unused) {
                    Log.i(z3, "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                }
            }
        } else {
            Api29Impl.b(this.y3, z);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v23, resolved type: androidx.appcompat.widget.DropDownListView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v24, resolved type: androidx.appcompat.widget.DropDownListView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: android.widget.LinearLayout} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v29, resolved type: androidx.appcompat.widget.DropDownListView} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0152  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int r() {
        /*
            r12 = this;
            androidx.appcompat.widget.DropDownListView r0 = r12.Y
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = -1
            r3 = 1
            r4 = 0
            if (r0 != 0) goto L_0x00bf
            android.content.Context r0 = r12.s
            androidx.appcompat.widget.ListPopupWindow$2 r5 = new androidx.appcompat.widget.ListPopupWindow$2
            r5.<init>()
            r12.t3 = r5
            boolean r5 = r12.x3
            r5 = r5 ^ r3
            androidx.appcompat.widget.DropDownListView r5 = r12.u(r0, r5)
            r12.Y = r5
            android.graphics.drawable.Drawable r6 = r12.m3
            if (r6 == 0) goto L_0x0022
            r5.setSelector(r6)
        L_0x0022:
            androidx.appcompat.widget.DropDownListView r5 = r12.Y
            android.widget.ListAdapter r6 = r12.X
            r5.setAdapter(r6)
            androidx.appcompat.widget.DropDownListView r5 = r12.Y
            android.widget.AdapterView$OnItemClickListener r6 = r12.n3
            r5.setOnItemClickListener(r6)
            androidx.appcompat.widget.DropDownListView r5 = r12.Y
            r5.setFocusable(r3)
            androidx.appcompat.widget.DropDownListView r5 = r12.Y
            r5.setFocusableInTouchMode(r3)
            androidx.appcompat.widget.DropDownListView r5 = r12.Y
            androidx.appcompat.widget.ListPopupWindow$3 r6 = new androidx.appcompat.widget.ListPopupWindow$3
            r6.<init>()
            r5.setOnItemSelectedListener(r6)
            androidx.appcompat.widget.DropDownListView r5 = r12.Y
            androidx.appcompat.widget.ListPopupWindow$PopupScrollListener r6 = r12.r3
            r5.setOnScrollListener(r6)
            android.widget.AdapterView$OnItemSelectedListener r5 = r12.o3
            if (r5 == 0) goto L_0x0054
            androidx.appcompat.widget.DropDownListView r6 = r12.Y
            r6.setOnItemSelectedListener(r5)
        L_0x0054:
            androidx.appcompat.widget.DropDownListView r5 = r12.Y
            android.view.View r6 = r12.i3
            if (r6 == 0) goto L_0x00b8
            android.widget.LinearLayout r7 = new android.widget.LinearLayout
            r7.<init>(r0)
            r7.setOrientation(r3)
            android.widget.LinearLayout$LayoutParams r0 = new android.widget.LinearLayout$LayoutParams
            r8 = 1065353216(0x3f800000, float:1.0)
            r0.<init>(r2, r4, r8)
            int r8 = r12.j3
            if (r8 == 0) goto L_0x008f
            if (r8 == r3) goto L_0x0088
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = "Invalid hint position "
            r0.append(r5)
            int r5 = r12.j3
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            java.lang.String r5 = "ListPopupWindow"
            android.util.Log.e(r5, r0)
            goto L_0x0095
        L_0x0088:
            r7.addView(r5, r0)
            r7.addView(r6)
            goto L_0x0095
        L_0x008f:
            r7.addView(r6)
            r7.addView(r5, r0)
        L_0x0095:
            int r0 = r12.X2
            if (r0 < 0) goto L_0x009c
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x009e
        L_0x009c:
            r0 = 0
            r5 = 0
        L_0x009e:
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r5)
            r6.measure(r0, r4)
            android.view.ViewGroup$LayoutParams r0 = r6.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            int r5 = r6.getMeasuredHeight()
            int r6 = r0.topMargin
            int r5 = r5 + r6
            int r0 = r0.bottomMargin
            int r5 = r5 + r0
            r0 = r5
            r5 = r7
            goto L_0x00b9
        L_0x00b8:
            r0 = 0
        L_0x00b9:
            android.widget.PopupWindow r6 = r12.y3
            r6.setContentView(r5)
            goto L_0x00dd
        L_0x00bf:
            android.widget.PopupWindow r0 = r12.y3
            android.view.View r0 = r0.getContentView()
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            android.view.View r0 = r12.i3
            if (r0 == 0) goto L_0x00dc
            android.view.ViewGroup$LayoutParams r5 = r0.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r5 = (android.widget.LinearLayout.LayoutParams) r5
            int r0 = r0.getMeasuredHeight()
            int r6 = r5.topMargin
            int r0 = r0 + r6
            int r5 = r5.bottomMargin
            int r0 = r0 + r5
            goto L_0x00dd
        L_0x00dc:
            r0 = 0
        L_0x00dd:
            android.widget.PopupWindow r5 = r12.y3
            android.graphics.drawable.Drawable r5 = r5.getBackground()
            if (r5 == 0) goto L_0x00f9
            android.graphics.Rect r6 = r12.v3
            r5.getPadding(r6)
            android.graphics.Rect r5 = r12.v3
            int r6 = r5.top
            int r5 = r5.bottom
            int r5 = r5 + r6
            boolean r7 = r12.b3
            if (r7 != 0) goto L_0x00ff
            int r6 = -r6
            r12.Z2 = r6
            goto L_0x00ff
        L_0x00f9:
            android.graphics.Rect r5 = r12.v3
            r5.setEmpty()
            r5 = 0
        L_0x00ff:
            android.widget.PopupWindow r6 = r12.y3
            int r6 = r6.getInputMethodMode()
            r7 = 2
            if (r6 != r7) goto L_0x0109
            goto L_0x010a
        L_0x0109:
            r3 = 0
        L_0x010a:
            android.view.View r4 = r12.v()
            int r6 = r12.Z2
            int r3 = r12.A(r4, r6, r3)
            boolean r4 = r12.f3
            if (r4 != 0) goto L_0x0163
            int r4 = r12.Z
            if (r4 != r2) goto L_0x011d
            goto L_0x0163
        L_0x011d:
            int r4 = r12.X2
            r6 = -2
            if (r4 == r6) goto L_0x012c
            r1 = 1073741824(0x40000000, float:2.0)
            if (r4 == r2) goto L_0x012c
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r1)
        L_0x012a:
            r7 = r1
            goto L_0x0145
        L_0x012c:
            android.content.Context r2 = r12.s
            android.content.res.Resources r2 = r2.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            int r2 = r2.widthPixels
            android.graphics.Rect r4 = r12.v3
            int r6 = r4.left
            int r4 = r4.right
            int r6 = r6 + r4
            int r2 = r2 - r6
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r1)
            goto L_0x012a
        L_0x0145:
            androidx.appcompat.widget.DropDownListView r6 = r12.Y
            int r10 = r3 - r0
            r11 = -1
            r8 = 0
            r9 = -1
            int r1 = r6.e(r7, r8, r9, r10, r11)
            if (r1 <= 0) goto L_0x0161
            androidx.appcompat.widget.DropDownListView r2 = r12.Y
            int r2 = r2.getPaddingTop()
            androidx.appcompat.widget.DropDownListView r3 = r12.Y
            int r3 = r3.getPaddingBottom()
            int r2 = r2 + r3
            int r5 = r5 + r2
            int r0 = r0 + r5
        L_0x0161:
            int r1 = r1 + r0
            return r1
        L_0x0163:
            int r3 = r3 + r5
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ListPopupWindow.r():int");
    }

    public int B() {
        return this.j3;
    }

    @Nullable
    public Object C() {
        if (!b()) {
            return null;
        }
        return this.Y.getSelectedItem();
    }

    public long D() {
        if (!b()) {
            return Long.MIN_VALUE;
        }
        return this.Y.getSelectedItemId();
    }

    public int E() {
        if (!b()) {
            return -1;
        }
        return this.Y.getSelectedItemPosition();
    }

    @Nullable
    public View F() {
        if (!b()) {
            return null;
        }
        return this.Y.getSelectedView();
    }

    public int G() {
        return this.y3.getSoftInputMode();
    }

    public int H() {
        return this.X2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean J() {
        return this.f3;
    }

    public boolean K() {
        return this.y3.getInputMethodMode() == 2;
    }

    public boolean L() {
        return this.x3;
    }

    public boolean M(int i2, @NonNull KeyEvent keyEvent) {
        int i4;
        int i5;
        if (b() && i2 != 62 && (this.Y.getSelectedItemPosition() >= 0 || !I(i2))) {
            int selectedItemPosition = this.Y.getSelectedItemPosition();
            boolean z = !this.y3.isAboveAnchor();
            ListAdapter listAdapter = this.X;
            if (listAdapter != null) {
                boolean areAllItemsEnabled = listAdapter.areAllItemsEnabled();
                i4 = areAllItemsEnabled ? 0 : this.Y.d(0, true);
                i5 = areAllItemsEnabled ? listAdapter.getCount() - 1 : this.Y.d(listAdapter.getCount() - 1, false);
            } else {
                i4 = Integer.MAX_VALUE;
                i5 = Integer.MIN_VALUE;
            }
            if ((!z || i2 != 19 || selectedItemPosition > i4) && (z || i2 != 20 || selectedItemPosition < i5)) {
                this.Y.setListSelectionHidden(false);
                if (this.Y.onKeyDown(i2, keyEvent)) {
                    this.y3.setInputMethodMode(2);
                    this.Y.requestFocusFromTouch();
                    a();
                    if (i2 == 19 || i2 == 20 || i2 == 23 || i2 == 66) {
                        return true;
                    }
                } else if (!z || i2 != 20) {
                    return !z && i2 == 19 && selectedItemPosition == i4;
                } else {
                    if (selectedItemPosition == i5) {
                        return true;
                    }
                }
            } else {
                s();
                this.y3.setInputMethodMode(1);
                a();
                return true;
            }
        }
    }

    public boolean N(int i2, @NonNull KeyEvent keyEvent) {
        if (i2 != 4 || !b()) {
            return false;
        }
        View view = this.l3;
        if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            KeyEvent.DispatcherState keyDispatcherState = view.getKeyDispatcherState();
            if (keyDispatcherState != null) {
                keyDispatcherState.startTracking(keyEvent, this);
            }
            return true;
        } else if (keyEvent.getAction() != 1) {
            return false;
        } else {
            KeyEvent.DispatcherState keyDispatcherState2 = view.getKeyDispatcherState();
            if (keyDispatcherState2 != null) {
                keyDispatcherState2.handleUpEvent(keyEvent);
            }
            if (!keyEvent.isTracking() || keyEvent.isCanceled()) {
                return false;
            }
            dismiss();
            return true;
        }
    }

    public boolean O(int i2, @NonNull KeyEvent keyEvent) {
        if (!b() || this.Y.getSelectedItemPosition() < 0) {
            return false;
        }
        boolean onKeyUp = this.Y.onKeyUp(i2, keyEvent);
        if (onKeyUp && I(i2)) {
            dismiss();
        }
        return onKeyUp;
    }

    public boolean P(int i2) {
        if (!b()) {
            return false;
        }
        if (this.n3 == null) {
            return true;
        }
        DropDownListView dropDownListView = this.Y;
        int i4 = i2;
        this.n3.onItemClick(dropDownListView, dropDownListView.getChildAt(i2 - dropDownListView.getFirstVisiblePosition()), i4, dropDownListView.getAdapter().getItemId(i2));
        return true;
    }

    public void Q() {
        this.u3.post(this.t3);
    }

    public void S(@Nullable View view) {
        this.l3 = view;
    }

    public void T(@StyleRes int i2) {
        this.y3.setAnimationStyle(i2);
    }

    public void U(int i2) {
        Drawable background = this.y3.getBackground();
        if (background != null) {
            background.getPadding(this.v3);
            Rect rect = this.v3;
            this.X2 = rect.left + rect.right + i2;
            return;
        }
        n0(i2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void V(boolean z) {
        this.f3 = z;
    }

    public void W(int i2) {
        this.e3 = i2;
    }

    public void X(@Nullable Rect rect) {
        this.w3 = rect != null ? new Rect(rect) : null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void Y(boolean z) {
        this.g3 = z;
    }

    public void Z(int i2) {
        if (i2 >= 0 || -2 == i2 || -1 == i2) {
            this.Z = i2;
            return;
        }
        throw new IllegalArgumentException("Invalid height. Must be a positive value, MATCH_PARENT, or WRAP_CONTENT.");
    }

    public void a() {
        int r = r();
        boolean K = K();
        PopupWindowCompat.d(this.y3, this.a3);
        boolean z = true;
        if (!this.y3.isShowing()) {
            int i2 = this.X2;
            if (i2 == -1) {
                i2 = -1;
            } else if (i2 == -2) {
                i2 = v().getWidth();
            }
            int i4 = this.Z;
            if (i4 == -1) {
                r = -1;
            } else if (i4 != -2) {
                r = i4;
            }
            this.y3.setWidth(i2);
            this.y3.setHeight(r);
            i0(true);
            this.y3.setOutsideTouchable(!this.g3 && !this.f3);
            this.y3.setTouchInterceptor(this.q3);
            if (this.d3) {
                PopupWindowCompat.c(this.y3, this.c3);
            }
            if (Build.VERSION.SDK_INT <= 28) {
                Method method = E3;
                if (method != null) {
                    try {
                        method.invoke(this.y3, new Object[]{this.w3});
                    } catch (Exception e2) {
                        Log.e(z3, "Could not invoke setEpicenterBounds on PopupWindow", e2);
                    }
                }
            } else {
                Api29Impl.a(this.y3, this.w3);
            }
            PopupWindowCompat.e(this.y3, v(), this.Y2, this.Z2, this.e3);
            this.Y.setSelection(-1);
            if (!this.x3 || this.Y.isInTouchMode()) {
                s();
            }
            if (!this.x3) {
                this.u3.post(this.s3);
            }
        } else if (v().isAttachedToWindow()) {
            int i5 = this.X2;
            if (i5 == -1) {
                i5 = -1;
            } else if (i5 == -2) {
                i5 = v().getWidth();
            }
            int i6 = this.Z;
            if (i6 == -1) {
                if (!K) {
                    r = -1;
                }
                if (K) {
                    this.y3.setWidth(this.X2 == -1 ? -1 : 0);
                    this.y3.setHeight(0);
                } else {
                    this.y3.setWidth(this.X2 == -1 ? -1 : 0);
                    this.y3.setHeight(-1);
                }
            } else if (i6 != -2) {
                r = i6;
            }
            PopupWindow popupWindow = this.y3;
            if (this.g3 || this.f3) {
                z = false;
            }
            popupWindow.setOutsideTouchable(z);
            this.y3.update(v(), this.Y2, this.Z2, i5 < 0 ? -1 : i5, r < 0 ? -1 : r);
        }
    }

    public void a0(int i2) {
        this.y3.setInputMethodMode(i2);
    }

    public boolean b() {
        return this.y3.isShowing();
    }

    /* access modifiers changed from: package-private */
    public void b0(int i2) {
        this.h3 = i2;
    }

    public void c(@Nullable Drawable drawable) {
        this.y3.setBackgroundDrawable(drawable);
    }

    public void c0(Drawable drawable) {
        this.m3 = drawable;
    }

    public int d() {
        return this.Y2;
    }

    public void d0(boolean z) {
        this.x3 = z;
        this.y3.setFocusable(z);
    }

    public void dismiss() {
        this.y3.dismiss();
        R();
        this.y3.setContentView((View) null);
        this.Y = null;
        this.u3.removeCallbacks(this.p3);
    }

    public void e0(@Nullable PopupWindow.OnDismissListener onDismissListener) {
        this.y3.setOnDismissListener(onDismissListener);
    }

    public void f(int i2) {
        this.Y2 = i2;
    }

    public void f0(@Nullable AdapterView.OnItemClickListener onItemClickListener) {
        this.n3 = onItemClickListener;
    }

    public void g0(@Nullable AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.o3 = onItemSelectedListener;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void h0(boolean z) {
        this.d3 = true;
        this.c3 = z;
    }

    @Nullable
    public Drawable i() {
        return this.y3.getBackground();
    }

    public void j0(int i2) {
        this.j3 = i2;
    }

    @Nullable
    public ListView k() {
        return this.Y;
    }

    public void k0(@Nullable View view) {
        boolean b2 = b();
        if (b2) {
            R();
        }
        this.i3 = view;
        if (b2) {
            a();
        }
    }

    public void l(int i2) {
        this.Z2 = i2;
        this.b3 = true;
    }

    public void l0(int i2) {
        DropDownListView dropDownListView = this.Y;
        if (b() && dropDownListView != null) {
            dropDownListView.setListSelectionHidden(false);
            dropDownListView.setSelection(i2);
            if (dropDownListView.getChoiceMode() != 0) {
                dropDownListView.setItemChecked(i2, true);
            }
        }
    }

    public void m0(int i2) {
        this.y3.setSoftInputMode(i2);
    }

    public void n0(int i2) {
        this.X2 = i2;
    }

    public int o() {
        if (!this.b3) {
            return 0;
        }
        return this.Z2;
    }

    public void o0(int i2) {
        this.a3 = i2;
    }

    public void q(@Nullable ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.k3;
        if (dataSetObserver == null) {
            this.k3 = new PopupDataSetObserver();
        } else {
            ListAdapter listAdapter2 = this.X;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.X = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.k3);
        }
        DropDownListView dropDownListView = this.Y;
        if (dropDownListView != null) {
            dropDownListView.setAdapter(this.X);
        }
    }

    public void s() {
        DropDownListView dropDownListView = this.Y;
        if (dropDownListView != null) {
            dropDownListView.setListSelectionHidden(true);
            dropDownListView.requestLayout();
        }
    }

    public View.OnTouchListener t(View view) {
        return new ForwardingListener(view) {
            /* renamed from: k */
            public ListPopupWindow b() {
                return ListPopupWindow.this;
            }
        };
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public DropDownListView u(Context context, boolean z) {
        return new DropDownListView(context, z);
    }

    @Nullable
    public View v() {
        return this.l3;
    }

    @StyleRes
    public int w() {
        return this.y3.getAnimationStyle();
    }

    @Nullable
    public Rect x() {
        if (this.w3 != null) {
            return new Rect(this.w3);
        }
        return null;
    }

    public int y() {
        return this.Z;
    }

    public int z() {
        return this.y3.getInputMethodMode();
    }

    public ListPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.Z1);
    }

    public ListPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        this(context, attributeSet, i2, 0);
    }

    public ListPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i4) {
        this.Z = -2;
        this.X2 = -2;
        this.a3 = 1002;
        this.e3 = 0;
        this.f3 = false;
        this.g3 = false;
        this.h3 = Integer.MAX_VALUE;
        this.j3 = 0;
        this.p3 = new ResizePopupRunnable();
        this.q3 = new PopupTouchInterceptor();
        this.r3 = new PopupScrollListener();
        this.s3 = new ListSelectorHider();
        this.v3 = new Rect();
        this.s = context;
        this.u3 = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.a4, i2, i4);
        this.Y2 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.b4, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.c4, 0);
        this.Z2 = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.b3 = true;
        }
        obtainStyledAttributes.recycle();
        AppCompatPopupWindow appCompatPopupWindow = new AppCompatPopupWindow(context, attributeSet, i2, i4);
        this.y3 = appCompatPopupWindow;
        appCompatPopupWindow.setInputMethodMode(1);
    }
}
