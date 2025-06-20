package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.R;
import androidx.appcompat.graphics.drawable.DrawableWrapperCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.widget.ListViewAutoScrollHelper;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class DropDownListView extends ListView {
    public static final int j3 = -1;
    public static final int k3 = -1;
    private int X2 = 0;
    private int Y2 = 0;
    private int Z2 = 0;
    private int a3 = 0;
    private int b3;
    private GateKeeperDrawable c3;
    private boolean d3;
    private boolean e3;
    private boolean f3;
    private ViewPropertyAnimatorCompat g3;
    private ListViewAutoScrollHelper h3;
    ResolveHoverRunnable i3;
    private final Rect s = new Rect();

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static void a(View view, float f2, float f3) {
            view.drawableHotspotChanged(f2, f3);
        }
    }

    @RequiresApi(30)
    static class Api30Impl {

        /* renamed from: a  reason: collision with root package name */
        private static Method f3198a;

        /* renamed from: b  reason: collision with root package name */
        private static Method f3199b;

        /* renamed from: c  reason: collision with root package name */
        private static Method f3200c;

        /* renamed from: d  reason: collision with root package name */
        private static boolean f3201d = true;

        static {
            Class<AdapterView> cls = AdapterView.class;
            Class<AbsListView> cls2 = AbsListView.class;
            try {
                Class cls3 = Integer.TYPE;
                Class cls4 = Float.TYPE;
                Method declaredMethod = cls2.getDeclaredMethod("positionSelector", new Class[]{cls3, View.class, Boolean.TYPE, cls4, cls4});
                f3198a = declaredMethod;
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = cls.getDeclaredMethod("setSelectedPositionInt", new Class[]{cls3});
                f3199b = declaredMethod2;
                declaredMethod2.setAccessible(true);
                Method declaredMethod3 = cls.getDeclaredMethod("setNextSelectedPositionInt", new Class[]{cls3});
                f3200c = declaredMethod3;
                declaredMethod3.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
            }
        }

        private Api30Impl() {
        }

        static boolean a() {
            return f3201d;
        }

        @SuppressLint({"BanUncheckedReflection"})
        static void b(DropDownListView dropDownListView, int i2, View view) {
            try {
                f3198a.invoke(dropDownListView, new Object[]{Integer.valueOf(i2), view, Boolean.FALSE, -1, -1});
                f3199b.invoke(dropDownListView, new Object[]{Integer.valueOf(i2)});
                f3200c.invoke(dropDownListView, new Object[]{Integer.valueOf(i2)});
            } catch (IllegalAccessException | InvocationTargetException e2) {
                e2.printStackTrace();
            }
        }
    }

    @RequiresApi(33)
    static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        static boolean a(AbsListView absListView) {
            return absListView.isSelectedChildViewEnabled();
        }

        @DoNotInline
        static void b(AbsListView absListView, boolean z) {
            absListView.setSelectedChildViewEnabled(z);
        }
    }

    private static class GateKeeperDrawable extends DrawableWrapperCompat {
        private boolean X = true;

        GateKeeperDrawable(Drawable drawable) {
            super(drawable);
        }

        /* access modifiers changed from: package-private */
        public void c(boolean z) {
            this.X = z;
        }

        public void draw(@NonNull Canvas canvas) {
            if (this.X) {
                super.draw(canvas);
            }
        }

        public void setHotspot(float f2, float f3) {
            if (this.X) {
                super.setHotspot(f2, f3);
            }
        }

        public void setHotspotBounds(int i2, int i3, int i4, int i5) {
            if (this.X) {
                super.setHotspotBounds(i2, i3, i4, i5);
            }
        }

        public boolean setState(int[] iArr) {
            if (this.X) {
                return super.setState(iArr);
            }
            return false;
        }

        public boolean setVisible(boolean z, boolean z2) {
            if (this.X) {
                return super.setVisible(z, z2);
            }
            return false;
        }
    }

    static class PreApi33Impl {

        /* renamed from: a  reason: collision with root package name */
        private static final Field f3202a;

        static {
            Field field = null;
            try {
                field = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
                field.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                e2.printStackTrace();
            }
            f3202a = field;
        }

        private PreApi33Impl() {
        }

        static boolean a(AbsListView absListView) {
            Field field = f3202a;
            if (field == null) {
                return false;
            }
            try {
                return field.getBoolean(absListView);
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return false;
            }
        }

        static void b(AbsListView absListView, boolean z) {
            Field field = f3202a;
            if (field != null) {
                try {
                    field.set(absListView, Boolean.valueOf(z));
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private class ResolveHoverRunnable implements Runnable {
        ResolveHoverRunnable() {
        }

        public void a() {
            DropDownListView dropDownListView = DropDownListView.this;
            dropDownListView.i3 = null;
            dropDownListView.removeCallbacks(this);
        }

        public void b() {
            DropDownListView.this.post(this);
        }

        public void run() {
            DropDownListView dropDownListView = DropDownListView.this;
            dropDownListView.i3 = null;
            dropDownListView.drawableStateChanged();
        }
    }

    DropDownListView(@NonNull Context context, boolean z) {
        super(context, (AttributeSet) null, R.attr.p1);
        this.e3 = z;
        setCacheColorHint(0);
    }

    private void a() {
        this.f3 = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.b3 - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.g3;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.d();
            this.g3 = null;
        }
    }

    private void b(View view, int i2) {
        performItemClick(view, i2, getItemIdAtPosition(i2));
    }

    private void c(Canvas canvas) {
        Drawable selector;
        if (!this.s.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(this.s);
            selector.draw(canvas);
        }
    }

    private void g(int i2, View view) {
        Rect rect = this.s;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.X2;
        rect.top -= this.Y2;
        rect.right += this.Z2;
        rect.bottom += this.a3;
        boolean l2 = l();
        if (view.isEnabled() != l2) {
            m(!l2);
            if (i2 != -1) {
                refreshDrawableState();
            }
        }
    }

    private void h(int i2, View view) {
        Drawable selector = getSelector();
        boolean z = true;
        boolean z2 = (selector == null || i2 == -1) ? false : true;
        if (z2) {
            selector.setVisible(false, false);
        }
        g(i2, view);
        if (z2) {
            Rect rect = this.s;
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            if (getVisibility() != 0) {
                z = false;
            }
            selector.setVisible(z, false);
            DrawableCompat.k(selector, exactCenterX, exactCenterY);
        }
    }

    private void i(int i2, View view, float f2, float f4) {
        h(i2, view);
        Drawable selector = getSelector();
        if (selector != null && i2 != -1) {
            DrawableCompat.k(selector, f2, f4);
        }
    }

    private void j(View view, int i2, float f2, float f4) {
        View childAt;
        this.f3 = true;
        Api21Impl.a(this, f2, f4);
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i4 = this.b3;
        if (!(i4 == -1 || (childAt = getChildAt(i4 - getFirstVisiblePosition())) == null || childAt == view || !childAt.isPressed())) {
            childAt.setPressed(false);
        }
        this.b3 = i2;
        Api21Impl.a(view, f2 - ((float) view.getLeft()), f4 - ((float) view.getTop()));
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        i(i2, view, f2, f4);
        k(false);
        refreshDrawableState();
    }

    private void k(boolean z) {
        GateKeeperDrawable gateKeeperDrawable = this.c3;
        if (gateKeeperDrawable != null) {
            gateKeeperDrawable.c(z);
        }
    }

    private boolean l() {
        return Build.VERSION.SDK_INT >= 33 ? Api33Impl.a(this) : PreApi33Impl.a(this);
    }

    private void m(boolean z) {
        if (Build.VERSION.SDK_INT >= 33) {
            Api33Impl.b(this, z);
        } else {
            PreApi33Impl.b(this, z);
        }
    }

    private boolean n() {
        return this.f3;
    }

    private void o() {
        Drawable selector = getSelector();
        if (selector != null && n() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    public int d(int i2, boolean z) {
        int i4;
        ListAdapter adapter = getAdapter();
        if (adapter != null && !isInTouchMode()) {
            int count = adapter.getCount();
            if (!getAdapter().areAllItemsEnabled()) {
                if (z) {
                    i4 = Math.max(0, i2);
                    while (i4 < count && !adapter.isEnabled(i4)) {
                        i4++;
                    }
                } else {
                    int min = Math.min(i2, count - 1);
                    while (i4 >= 0 && !adapter.isEnabled(i4)) {
                        min = i4 - 1;
                    }
                }
                if (i4 < 0 || i4 >= count) {
                    return -1;
                }
                return i4;
            } else if (i2 < 0 || i2 >= count) {
                return -1;
            } else {
                return i2;
            }
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        c(canvas);
        super.dispatchDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        if (this.i3 == null) {
            super.drawableStateChanged();
            k(true);
            o();
        }
    }

    public int e(int i2, int i4, int i5, int i6, int i7) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        int i8 = listPaddingTop + listPaddingBottom;
        if (adapter == null) {
            return i8;
        }
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        View view = null;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i9 < count) {
            int itemViewType = adapter.getItemViewType(i9);
            if (itemViewType != i10) {
                view = null;
                i10 = itemViewType;
            }
            view = adapter.getView(i9, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i12 = layoutParams.height;
            view.measure(i2, i12 > 0 ? View.MeasureSpec.makeMeasureSpec(i12, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i9 > 0) {
                i8 += dividerHeight;
            }
            i8 += view.getMeasuredHeight();
            if (i8 >= i6) {
                return (i7 < 0 || i9 <= i7 || i11 <= 0 || i8 == i6) ? i6 : i11;
            }
            if (i7 >= 0 && i9 >= i7) {
                i11 = i8;
            }
            i9++;
        }
        return i8;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000c, code lost:
        if (r0 != 3) goto L_0x000e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0065  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean f(android.view.MotionEvent r8, int r9) {
        /*
            r7 = this;
            int r0 = r8.getActionMasked()
            r1 = 1
            r2 = 0
            if (r0 == r1) goto L_0x0016
            r3 = 2
            if (r0 == r3) goto L_0x0014
            r9 = 3
            if (r0 == r9) goto L_0x0011
        L_0x000e:
            r9 = 0
            r3 = 1
            goto L_0x0046
        L_0x0011:
            r9 = 0
            r3 = 0
            goto L_0x0046
        L_0x0014:
            r3 = 1
            goto L_0x0017
        L_0x0016:
            r3 = 0
        L_0x0017:
            int r9 = r8.findPointerIndex(r9)
            if (r9 >= 0) goto L_0x001e
            goto L_0x0011
        L_0x001e:
            float r4 = r8.getX(r9)
            int r4 = (int) r4
            float r9 = r8.getY(r9)
            int r9 = (int) r9
            int r5 = r7.pointToPosition(r4, r9)
            r6 = -1
            if (r5 != r6) goto L_0x0031
            r9 = 1
            goto L_0x0046
        L_0x0031:
            int r3 = r7.getFirstVisiblePosition()
            int r3 = r5 - r3
            android.view.View r3 = r7.getChildAt(r3)
            float r4 = (float) r4
            float r9 = (float) r9
            r7.j(r3, r5, r4, r9)
            if (r0 != r1) goto L_0x000e
            r7.b(r3, r5)
            goto L_0x000e
        L_0x0046:
            if (r3 == 0) goto L_0x004a
            if (r9 == 0) goto L_0x004d
        L_0x004a:
            r7.a()
        L_0x004d:
            if (r3 == 0) goto L_0x0065
            androidx.core.widget.ListViewAutoScrollHelper r9 = r7.h3
            if (r9 != 0) goto L_0x005a
            androidx.core.widget.ListViewAutoScrollHelper r9 = new androidx.core.widget.ListViewAutoScrollHelper
            r9.<init>(r7)
            r7.h3 = r9
        L_0x005a:
            androidx.core.widget.ListViewAutoScrollHelper r9 = r7.h3
            r9.o(r1)
            androidx.core.widget.ListViewAutoScrollHelper r9 = r7.h3
            r9.onTouch(r7, r8)
            goto L_0x006c
        L_0x0065:
            androidx.core.widget.ListViewAutoScrollHelper r8 = r7.h3
            if (r8 == 0) goto L_0x006c
            r8.o(r2)
        L_0x006c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.DropDownListView.f(android.view.MotionEvent, int):boolean");
    }

    public boolean hasFocus() {
        return this.e3 || super.hasFocus();
    }

    public boolean hasWindowFocus() {
        return this.e3 || super.hasWindowFocus();
    }

    public boolean isFocused() {
        return this.e3 || super.isFocused();
    }

    public boolean isInTouchMode() {
        return (this.e3 && this.d3) || super.isInTouchMode();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.i3 = null;
        super.onDetachedFromWindow();
    }

    public boolean onHoverEvent(@NonNull MotionEvent motionEvent) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.i3 == null) {
            ResolveHoverRunnable resolveHoverRunnable = new ResolveHoverRunnable();
            this.i3 = resolveHoverRunnable;
            resolveHoverRunnable.b();
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (!(pointToPosition == -1 || pointToPosition == getSelectedItemPosition())) {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    requestFocus();
                    if (i2 < 30 || !Api30Impl.a()) {
                        setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                    } else {
                        Api30Impl.b(this, pointToPosition, childAt);
                    }
                }
                o();
            }
        } else {
            setSelection(-1);
        }
        return onHoverEvent;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.b3 = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        ResolveHoverRunnable resolveHoverRunnable = this.i3;
        if (resolveHoverRunnable != null) {
            resolveHoverRunnable.a();
        }
        return super.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: package-private */
    public void setListSelectionHidden(boolean z) {
        this.d3 = z;
    }

    public void setSelector(Drawable drawable) {
        GateKeeperDrawable gateKeeperDrawable = drawable != null ? new GateKeeperDrawable(drawable) : null;
        this.c3 = gateKeeperDrawable;
        super.setSelector(gateKeeperDrawable);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.X2 = rect.left;
        this.Y2 = rect.top;
        this.Z2 = rect.right;
        this.a3 = rect.bottom;
    }
}
