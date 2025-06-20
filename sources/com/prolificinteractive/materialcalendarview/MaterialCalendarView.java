package com.prolificinteractive.materialcalendarview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ArrayRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import com.prolificinteractive.materialcalendarview.format.ArrayWeekDayFormatter;
import com.prolificinteractive.materialcalendarview.format.DayFormatter;
import com.prolificinteractive.materialcalendarview.format.MonthArrayTitleFormatter;
import com.prolificinteractive.materialcalendarview.format.TitleFormatter;
import com.prolificinteractive.materialcalendarview.format.WeekDayFormatter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.temporal.WeekFields;

public class MaterialCalendarView extends ViewGroup {
    public static final int A3 = 1;
    public static final int B3 = 2;
    public static final int C3 = 3;
    public static final int D3 = 0;
    public static final int E3 = 1;
    public static final int F3 = 2;
    public static final int G3 = 4;
    public static final int H3 = 4;
    public static final int I3 = 7;
    public static final int J3 = 0;
    public static final int K3 = 1;
    public static final int L3 = 44;
    private static final int M3 = 7;
    private static final int N3 = 6;
    private static final int O3 = 1;
    public static final int y3 = -10;
    public static final int z3 = 0;
    private final TextView X2;
    /* access modifiers changed from: private */
    public final ImageView Y2;
    /* access modifiers changed from: private */
    public final ImageView Z2;
    /* access modifiers changed from: private */
    public final CalendarPager a3;
    /* access modifiers changed from: private */
    public CalendarPagerAdapter<?> b3;
    /* access modifiers changed from: private */
    public CalendarDay c3;
    private LinearLayout d3;
    private CalendarMode e3;
    private boolean f3;
    private final ArrayList<DayViewDecorator> g3;
    private final View.OnClickListener h3;
    private final ViewPager.OnPageChangeListener i3;
    private CalendarDay j3;
    private CalendarDay k3;
    private OnDateSelectedListener l3;
    private OnDateLongClickListener m3;
    private OnMonthChangedListener n3;
    private OnRangeSelectedListener o3;
    CharSequence p3;
    private int q3;
    private int r3;
    /* access modifiers changed from: private */
    public final TitleChanger s;
    private int s3;
    private int t3;
    private boolean u3;
    private DayOfWeek v3;
    private boolean w3;
    private State x3;

    /* renamed from: com.prolificinteractive.materialcalendarview.MaterialCalendarView$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f27976a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.prolificinteractive.materialcalendarview.CalendarMode[] r0 = com.prolificinteractive.materialcalendarview.CalendarMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f27976a = r0
                com.prolificinteractive.materialcalendarview.CalendarMode r1 = com.prolificinteractive.materialcalendarview.CalendarMode.MONTHS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f27976a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.prolificinteractive.materialcalendarview.CalendarMode r1 = com.prolificinteractive.materialcalendarview.CalendarMode.WEEKS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.prolificinteractive.materialcalendarview.MaterialCalendarView.AnonymousClass4.<clinit>():void");
        }
    }

    protected static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(int i2) {
            super(-1, i2);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SelectionMode {
    }

    @SuppressLint({"UniqueConstants"})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ShowOtherDates {
    }

    public class State {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final CalendarMode f27977a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final DayOfWeek f27978b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final CalendarDay f27979c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final CalendarDay f27980d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public final boolean f27981e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public final boolean f27982f;

        private State(StateBuilder stateBuilder) {
            this.f27977a = stateBuilder.f27984a;
            this.f27978b = stateBuilder.f27985b;
            this.f27979c = stateBuilder.f27987d;
            this.f27980d = stateBuilder.f27988e;
            this.f27981e = stateBuilder.f27986c;
            this.f27982f = stateBuilder.f27989f;
        }

        public StateBuilder g() {
            return new StateBuilder(this);
        }
    }

    public class StateBuilder {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public CalendarMode f27984a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public DayOfWeek f27985b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public boolean f27986c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public CalendarDay f27987d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public CalendarDay f27988e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public boolean f27989f;

        public StateBuilder() {
            this.f27986c = false;
            this.f27987d = null;
            this.f27988e = null;
            this.f27984a = CalendarMode.MONTHS;
            this.f27985b = LocalDate.n2().q0(WeekFields.e(Locale.getDefault()).b(), 1).j1();
        }

        public void g() {
            MaterialCalendarView materialCalendarView = MaterialCalendarView.this;
            materialCalendarView.r(new State(this));
        }

        public StateBuilder h(boolean z) {
            this.f27986c = z;
            return this;
        }

        public StateBuilder i(CalendarMode calendarMode) {
            this.f27984a = calendarMode;
            return this;
        }

        public StateBuilder j(DayOfWeek dayOfWeek) {
            this.f27985b = dayOfWeek;
            return this;
        }

        public StateBuilder k(@Nullable CalendarDay calendarDay) {
            this.f27988e = calendarDay;
            return this;
        }

        public StateBuilder l(@Nullable LocalDate localDate) {
            k(CalendarDay.b(localDate));
            return this;
        }

        public StateBuilder m(@Nullable CalendarDay calendarDay) {
            this.f27987d = calendarDay;
            return this;
        }

        public StateBuilder n(@Nullable LocalDate localDate) {
            m(CalendarDay.b(localDate));
            return this;
        }

        public StateBuilder o(boolean z) {
            this.f27989f = z;
            return this;
        }

        private StateBuilder(State state) {
            this.f27986c = false;
            this.f27987d = null;
            this.f27988e = null;
            this.f27984a = state.f27977a;
            this.f27985b = state.f27978b;
            this.f27987d = state.f27979c;
            this.f27988e = state.f27980d;
            this.f27986c = state.f27981e;
            this.f27989f = state.f27982f;
        }
    }

    public MaterialCalendarView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void Q(CalendarDay calendarDay, CalendarDay calendarDay2) {
        CalendarDay calendarDay3 = this.c3;
        this.b3.R(calendarDay, calendarDay2);
        this.c3 = calendarDay3;
        if (calendarDay != null) {
            if (!calendarDay.l(calendarDay3)) {
                calendarDay = this.c3;
            }
            this.c3 = calendarDay;
        }
        this.a3.S(this.b3.z(calendarDay3), false);
        W();
    }

    private void R() {
        addView(this.d3);
        this.a3.setId(R.id.a0);
        this.a3.setOffscreenPageLimit(1);
        addView(this.a3, new LayoutParams(this.w3 ? this.e3.s + 1 : this.e3.s));
    }

    public static boolean S(int i2) {
        return (i2 & 4) != 0;
    }

    public static boolean T(int i2) {
        return (i2 & 1) != 0;
    }

    public static boolean U(int i2) {
        return (i2 & 2) != 0;
    }

    /* access modifiers changed from: private */
    public void W() {
        this.s.f(this.c3);
        w(this.Y2, n());
        w(this.Z2, o());
    }

    private int getWeekCountBasedOnMode() {
        CalendarPagerAdapter<?> calendarPagerAdapter;
        CalendarPager calendarPager;
        CalendarMode calendarMode = this.e3;
        int i2 = calendarMode.s;
        if (calendarMode.equals(CalendarMode.MONTHS) && this.f3 && (calendarPagerAdapter = this.b3) != null && (calendarPager = this.a3) != null) {
            LocalDate c2 = calendarPagerAdapter.A(calendarPager.getCurrentItem()).c();
            i2 = c2.W2(c2.F()).b(WeekFields.f(this.v3, 1).i());
        }
        return this.w3 ? i2 + 1 : i2;
    }

    private static int p(int i2, int i4) {
        int mode = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i4);
        if (mode != Integer.MIN_VALUE) {
            return mode != 1073741824 ? i2 : size;
        }
        return Math.min(i2, size);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0048, code lost:
        if (r1.m(r2) == false) goto L_0x007c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void r(com.prolificinteractive.materialcalendarview.MaterialCalendarView.State r6) {
        /*
            r5 = this;
            com.prolificinteractive.materialcalendarview.CalendarPagerAdapter<?> r0 = r5.b3
            if (r0 == 0) goto L_0x007b
            boolean r0 = r6.f27981e
            if (r0 == 0) goto L_0x007b
            com.prolificinteractive.materialcalendarview.CalendarPagerAdapter<?> r0 = r5.b3
            com.prolificinteractive.materialcalendarview.CalendarPager r1 = r5.a3
            int r1 = r1.getCurrentItem()
            com.prolificinteractive.materialcalendarview.CalendarDay r0 = r0.A(r1)
            com.prolificinteractive.materialcalendarview.CalendarMode r1 = r5.e3
            com.prolificinteractive.materialcalendarview.CalendarMode r2 = r6.f27977a
            if (r1 == r2) goto L_0x007c
            com.prolificinteractive.materialcalendarview.CalendarDay r1 = r5.getSelectedDate()
            com.prolificinteractive.materialcalendarview.CalendarMode r2 = r5.e3
            com.prolificinteractive.materialcalendarview.CalendarMode r3 = com.prolificinteractive.materialcalendarview.CalendarMode.MONTHS
            if (r2 != r3) goto L_0x004b
            if (r1 == 0) goto L_0x004b
            org.threeten.bp.LocalDate r2 = r0.c()
            r3 = 1
            org.threeten.bp.LocalDate r2 = r2.J2(r3)
            com.prolificinteractive.materialcalendarview.CalendarDay r2 = com.prolificinteractive.materialcalendarview.CalendarDay.b(r2)
            boolean r3 = r1.equals(r0)
            if (r3 != 0) goto L_0x0077
            boolean r3 = r1.l(r0)
            if (r3 == 0) goto L_0x007c
            boolean r2 = r1.m(r2)
            if (r2 == 0) goto L_0x007c
            goto L_0x0077
        L_0x004b:
            com.prolificinteractive.materialcalendarview.CalendarMode r3 = com.prolificinteractive.materialcalendarview.CalendarMode.WEEKS
            if (r2 != r3) goto L_0x007c
            org.threeten.bp.LocalDate r2 = r0.c()
            r3 = 6
            org.threeten.bp.LocalDate r2 = r2.J2(r3)
            com.prolificinteractive.materialcalendarview.CalendarDay r2 = com.prolificinteractive.materialcalendarview.CalendarDay.b(r2)
            if (r1 == 0) goto L_0x0079
            boolean r3 = r1.equals(r0)
            if (r3 != 0) goto L_0x0077
            boolean r3 = r1.equals(r2)
            if (r3 != 0) goto L_0x0077
            boolean r0 = r1.l(r0)
            if (r0 == 0) goto L_0x0079
            boolean r0 = r1.m(r2)
            if (r0 == 0) goto L_0x0079
        L_0x0077:
            r0 = r1
            goto L_0x007c
        L_0x0079:
            r0 = r2
            goto L_0x007c
        L_0x007b:
            r0 = 0
        L_0x007c:
            r5.x3 = r6
            com.prolificinteractive.materialcalendarview.CalendarMode r1 = r6.f27977a
            r5.e3 = r1
            org.threeten.bp.DayOfWeek r1 = r6.f27978b
            r5.v3 = r1
            com.prolificinteractive.materialcalendarview.CalendarDay r1 = r6.f27979c
            r5.j3 = r1
            com.prolificinteractive.materialcalendarview.CalendarDay r1 = r6.f27980d
            r5.k3 = r1
            boolean r6 = r6.f27982f
            r5.w3 = r6
            int[] r6 = com.prolificinteractive.materialcalendarview.MaterialCalendarView.AnonymousClass4.f27976a
            com.prolificinteractive.materialcalendarview.CalendarMode r1 = r5.e3
            int r1 = r1.ordinal()
            r6 = r6[r1]
            r1 = 1
            if (r6 == r1) goto L_0x00ba
            r2 = 2
            if (r6 != r2) goto L_0x00b2
            com.prolificinteractive.materialcalendarview.WeekPagerAdapter r6 = new com.prolificinteractive.materialcalendarview.WeekPagerAdapter
            r6.<init>(r5)
            goto L_0x00bf
        L_0x00b2:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Provided display mode which is not yet implemented"
            r6.<init>(r0)
            throw r6
        L_0x00ba:
            com.prolificinteractive.materialcalendarview.MonthPagerAdapter r6 = new com.prolificinteractive.materialcalendarview.MonthPagerAdapter
            r6.<init>(r5)
        L_0x00bf:
            com.prolificinteractive.materialcalendarview.CalendarPagerAdapter<?> r2 = r5.b3
            if (r2 != 0) goto L_0x00c6
        L_0x00c3:
            r5.b3 = r6
            goto L_0x00cb
        L_0x00c6:
            com.prolificinteractive.materialcalendarview.CalendarPagerAdapter r6 = r2.K(r6)
            goto L_0x00c3
        L_0x00cb:
            com.prolificinteractive.materialcalendarview.CalendarPagerAdapter<?> r6 = r5.b3
            boolean r2 = r5.w3
            r6.V(r2)
            com.prolificinteractive.materialcalendarview.CalendarPager r6 = r5.a3
            com.prolificinteractive.materialcalendarview.CalendarPagerAdapter<?> r2 = r5.b3
            r6.setAdapter(r2)
            com.prolificinteractive.materialcalendarview.CalendarDay r6 = r5.j3
            com.prolificinteractive.materialcalendarview.CalendarDay r2 = r5.k3
            r5.Q(r6, r2)
            boolean r6 = r5.w3
            if (r6 == 0) goto L_0x00ea
            com.prolificinteractive.materialcalendarview.CalendarMode r6 = r5.e3
            int r6 = r6.s
            int r6 = r6 + r1
            goto L_0x00ee
        L_0x00ea:
            com.prolificinteractive.materialcalendarview.CalendarMode r6 = r5.e3
            int r6 = r6.s
        L_0x00ee:
            com.prolificinteractive.materialcalendarview.CalendarPager r2 = r5.a3
            com.prolificinteractive.materialcalendarview.MaterialCalendarView$LayoutParams r3 = new com.prolificinteractive.materialcalendarview.MaterialCalendarView$LayoutParams
            r3.<init>(r6)
            r2.setLayoutParams(r3)
            int r6 = r5.t3
            if (r6 != r1) goto L_0x0116
            com.prolificinteractive.materialcalendarview.CalendarPagerAdapter<?> r6 = r5.b3
            java.util.List r6 = r6.C()
            boolean r6 = r6.isEmpty()
            if (r6 != 0) goto L_0x0116
            com.prolificinteractive.materialcalendarview.CalendarPagerAdapter<?> r6 = r5.b3
            java.util.List r6 = r6.C()
            r1 = 0
            java.lang.Object r6 = r6.get(r1)
            com.prolificinteractive.materialcalendarview.CalendarDay r6 = (com.prolificinteractive.materialcalendarview.CalendarDay) r6
            goto L_0x011a
        L_0x0116:
            com.prolificinteractive.materialcalendarview.CalendarDay r6 = com.prolificinteractive.materialcalendarview.CalendarDay.p()
        L_0x011a:
            r5.setCurrentDate((com.prolificinteractive.materialcalendarview.CalendarDay) r6)
            if (r0 == 0) goto L_0x012a
            com.prolificinteractive.materialcalendarview.CalendarPager r6 = r5.a3
            com.prolificinteractive.materialcalendarview.CalendarPagerAdapter<?> r1 = r5.b3
            int r0 = r1.z(r0)
            r6.setCurrentItem(r0)
        L_0x012a:
            r5.C()
            r5.W()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.prolificinteractive.materialcalendarview.MaterialCalendarView.r(com.prolificinteractive.materialcalendarview.MaterialCalendarView$State):void");
    }

    private int v(int i2) {
        return (int) TypedValue.applyDimension(1, (float) i2, getResources().getDisplayMetrics());
    }

    private static void w(View view, boolean z) {
        view.setEnabled(z);
        view.setAlpha(z ? 1.0f : 0.1f);
    }

    private static int z(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843829, typedValue, true);
        return typedValue.data;
    }

    public void A() {
        if (o()) {
            CalendarPager calendarPager = this.a3;
            calendarPager.S(calendarPager.getCurrentItem() + 1, true);
        }
    }

    public void B() {
        if (n()) {
            CalendarPager calendarPager = this.a3;
            calendarPager.S(calendarPager.getCurrentItem() - 1, true);
        }
    }

    public void C() {
        this.b3.G();
    }

    public boolean D() {
        return this.f3;
    }

    public boolean E() {
        return this.a3.b0();
    }

    public boolean F() {
        return this.w3;
    }

    public StateBuilder G() {
        return new StateBuilder();
    }

    /* access modifiers changed from: protected */
    public void H(@NonNull CalendarDay calendarDay, boolean z) {
        int i2 = this.t3;
        if (i2 != 2) {
            if (i2 != 3) {
                this.b3.v();
                this.b3.M(calendarDay, true);
                s(calendarDay, true);
                return;
            }
            List<CalendarDay> C = this.b3.C();
            if (C.size() != 0) {
                if (C.size() == 1) {
                    CalendarDay calendarDay2 = C.get(0);
                    if (!calendarDay2.equals(calendarDay)) {
                        if (calendarDay2.l(calendarDay)) {
                            this.b3.L(calendarDay, calendarDay2);
                        } else {
                            this.b3.L(calendarDay2, calendarDay);
                        }
                        u(this.b3.C());
                        return;
                    }
                } else {
                    this.b3.v();
                }
            }
        }
        this.b3.M(calendarDay, z);
        s(calendarDay, z);
    }

    /* access modifiers changed from: protected */
    public void I(DayView dayView) {
        CalendarDay currentDate = getCurrentDate();
        CalendarDay h2 = dayView.h();
        int g2 = currentDate.g();
        int g4 = h2.g();
        if (this.e3 == CalendarMode.MONTHS && this.u3 && g2 != g4) {
            if (currentDate.l(h2)) {
                B();
            } else if (currentDate.m(h2)) {
                A();
            }
        }
        H(dayView.h(), !dayView.isChecked());
    }

    /* access modifiers changed from: protected */
    public void J(DayView dayView) {
        OnDateLongClickListener onDateLongClickListener = this.m3;
        if (onDateLongClickListener != null) {
            onDateLongClickListener.a(this, dayView.h());
        }
    }

    /* access modifiers changed from: protected */
    public void K(CalendarDay calendarDay) {
        s(calendarDay, false);
    }

    public void L(DayViewDecorator dayViewDecorator) {
        this.g3.remove(dayViewDecorator);
        this.b3.Q(this.g3);
    }

    public void M() {
        this.g3.clear();
        this.b3.Q(this.g3);
    }

    public void N(CalendarDay calendarDay, CalendarDay calendarDay2) {
        if (calendarDay != null && calendarDay2 != null) {
            if (calendarDay.l(calendarDay2)) {
                this.b3.L(calendarDay2, calendarDay);
            } else {
                this.b3.L(calendarDay, calendarDay2);
            }
            u(this.b3.C());
        }
    }

    public void O(@Nullable CalendarDay calendarDay, boolean z) {
        if (calendarDay != null) {
            this.a3.S(this.b3.z(calendarDay), z);
            W();
        }
    }

    public void P(@Nullable CalendarDay calendarDay, boolean z) {
        if (calendarDay != null) {
            this.b3.M(calendarDay, z);
        }
    }

    public State V() {
        return this.x3;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(@NonNull SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    /* access modifiers changed from: protected */
    public void dispatchSaveInstanceState(@NonNull SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    public CharSequence getCalendarContentDescription() {
        CharSequence charSequence = this.p3;
        return charSequence != null ? charSequence : getContext().getString(R.string.r);
    }

    public CalendarMode getCalendarMode() {
        return this.e3;
    }

    public CalendarDay getCurrentDate() {
        return this.b3.A(this.a3.getCurrentItem());
    }

    public DayOfWeek getFirstDayOfWeek() {
        return this.v3;
    }

    public Drawable getLeftArrow() {
        return this.Y2.getDrawable();
    }

    public CalendarDay getMaximumDate() {
        return this.k3;
    }

    public CalendarDay getMinimumDate() {
        return this.j3;
    }

    public Drawable getRightArrow() {
        return this.Z2.getDrawable();
    }

    @Nullable
    public CalendarDay getSelectedDate() {
        List<CalendarDay> C = this.b3.C();
        if (C.isEmpty()) {
            return null;
        }
        return C.get(C.size() - 1);
    }

    @NonNull
    public List<CalendarDay> getSelectedDates() {
        return this.b3.C();
    }

    public int getSelectionColor() {
        return this.q3;
    }

    public int getSelectionMode() {
        return this.t3;
    }

    public int getShowOtherDates() {
        return this.b3.D();
    }

    public int getTileHeight() {
        return this.r3;
    }

    @Deprecated
    public int getTileSize() {
        return Math.max(this.r3, this.s3);
    }

    public int getTileWidth() {
        return this.s3;
    }

    public int getTitleAnimationOrientation() {
        return this.s.i();
    }

    public boolean getTopbarVisible() {
        return this.d3.getVisibility() == 0;
    }

    public void j(DayViewDecorator dayViewDecorator) {
        if (dayViewDecorator != null) {
            this.g3.add(dayViewDecorator);
            this.b3.Q(this.g3);
        }
    }

    public void k(Collection<? extends DayViewDecorator> collection) {
        if (collection != null) {
            this.g3.addAll(collection);
            this.b3.Q(this.g3);
        }
    }

    public void l(DayViewDecorator... dayViewDecoratorArr) {
        k(Arrays.asList(dayViewDecoratorArr));
    }

    public boolean m() {
        return this.u3;
    }

    public boolean n() {
        return this.a3.getCurrentItem() > 0;
    }

    public boolean o() {
        return this.a3.getCurrentItem() < this.b3.e() - 1;
    }

    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(MaterialCalendarView.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(MaterialCalendarView.class.getName());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i4, int i5, int i6) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = ((i5 - i2) - paddingLeft) - getPaddingRight();
        int paddingTop = getPaddingTop();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int i8 = ((paddingRight - measuredWidth) / 2) + paddingLeft;
                int measuredHeight = childAt.getMeasuredHeight() + paddingTop;
                childAt.layout(i8, paddingTop, measuredWidth + i8, measuredHeight);
                paddingTop = measuredHeight;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i4) {
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i4);
        int mode2 = View.MeasureSpec.getMode(i4);
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
        int weekCountBasedOnMode = getWeekCountBasedOnMode();
        if (getTopbarVisible()) {
            weekCountBasedOnMode++;
        }
        int i5 = paddingLeft / 7;
        int i6 = paddingTop / weekCountBasedOnMode;
        int i7 = this.s3;
        int i8 = -1;
        if (i7 == -10 && this.r3 == -10) {
            if (mode != 1073741824 && mode != Integer.MIN_VALUE) {
                i5 = (mode2 == 1073741824 || mode2 == Integer.MIN_VALUE) ? i6 : -1;
            } else if (mode2 == 1073741824) {
                i5 = Math.min(i5, i6);
            }
            i6 = -1;
        } else {
            if (i7 > 0) {
                i5 = i7;
            }
            int i9 = this.r3;
            i8 = i5;
            if (i9 > 0) {
                i6 = i9;
            }
            i5 = -1;
        }
        if (i5 > 0) {
            i6 = i5;
        } else if (i5 <= 0) {
            int v = i8 <= 0 ? v(44) : i8;
            if (i6 <= 0) {
                i6 = v(44);
            }
            i5 = v;
        } else {
            i5 = i8;
        }
        int i10 = i5 * 7;
        setMeasuredDimension(p(getPaddingLeft() + getPaddingRight() + i10, i2), p((weekCountBasedOnMode * i6) + getPaddingTop() + getPaddingBottom(), i4));
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            childAt.measure(View.MeasureSpec.makeMeasureSpec(i10, 1073741824), View.MeasureSpec.makeMeasureSpec(((LayoutParams) childAt.getLayoutParams()).height * i6, 1073741824));
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        V().g().m(savedState.Y).k(savedState.Z).h(savedState.c3).g();
        setShowOtherDates(savedState.s);
        setAllowClickDaysOutsideCurrentMonth(savedState.X);
        q();
        for (CalendarDay P : savedState.X2) {
            P(P, true);
        }
        setTopbarVisible(savedState.Y2);
        setSelectionMode(savedState.Z2);
        setDynamicHeightEnabled(savedState.a3);
        setCurrentDate(savedState.b3);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.s = getShowOtherDates();
        savedState.X = m();
        savedState.Y = getMinimumDate();
        savedState.Z = getMaximumDate();
        savedState.X2 = getSelectedDates();
        savedState.Z2 = getSelectionMode();
        savedState.Y2 = getTopbarVisible();
        savedState.a3 = this.f3;
        savedState.b3 = this.c3;
        savedState.c3 = this.x3.f27981e;
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.a3.dispatchTouchEvent(motionEvent);
    }

    public void q() {
        List<CalendarDay> selectedDates = getSelectedDates();
        this.b3.v();
        for (CalendarDay s2 : selectedDates) {
            s(s2, false);
        }
    }

    /* access modifiers changed from: protected */
    public void s(CalendarDay calendarDay, boolean z) {
        OnDateSelectedListener onDateSelectedListener = this.l3;
        if (onDateSelectedListener != null) {
            onDateSelectedListener.a(this, calendarDay, z);
        }
    }

    public void setAllowClickDaysOutsideCurrentMonth(boolean z) {
        this.u3 = z;
    }

    public void setContentDescriptionArrowFuture(CharSequence charSequence) {
        this.Z2.setContentDescription(charSequence);
    }

    public void setContentDescriptionArrowPast(CharSequence charSequence) {
        this.Y2.setContentDescription(charSequence);
    }

    public void setContentDescriptionCalendar(CharSequence charSequence) {
        this.p3 = charSequence;
    }

    public void setCurrentDate(@Nullable CalendarDay calendarDay) {
        O(calendarDay, true);
    }

    public void setDateTextAppearance(int i2) {
        this.b3.N(i2);
    }

    public void setDayFormatter(DayFormatter dayFormatter) {
        CalendarPagerAdapter<?> calendarPagerAdapter = this.b3;
        if (dayFormatter == null) {
            dayFormatter = DayFormatter.f28154b;
        }
        calendarPagerAdapter.O(dayFormatter);
    }

    public void setDayFormatterContentDescription(DayFormatter dayFormatter) {
        this.b3.P(dayFormatter);
    }

    public void setDynamicHeightEnabled(boolean z) {
        this.f3 = z;
    }

    public void setHeaderTextAppearance(int i2) {
        this.X2.setTextAppearance(getContext(), i2);
    }

    public void setLeftArrow(@DrawableRes int i2) {
        this.Y2.setImageResource(i2);
    }

    public void setOnDateChangedListener(OnDateSelectedListener onDateSelectedListener) {
        this.l3 = onDateSelectedListener;
    }

    public void setOnDateLongClickListener(OnDateLongClickListener onDateLongClickListener) {
        this.m3 = onDateLongClickListener;
    }

    public void setOnMonthChangedListener(OnMonthChangedListener onMonthChangedListener) {
        this.n3 = onMonthChangedListener;
    }

    public void setOnRangeSelectedListener(OnRangeSelectedListener onRangeSelectedListener) {
        this.o3 = onRangeSelectedListener;
    }

    public void setOnTitleClickListener(View.OnClickListener onClickListener) {
        this.X2.setOnClickListener(onClickListener);
    }

    public void setPagingEnabled(boolean z) {
        this.a3.setPagingEnabled(z);
        W();
    }

    public void setRightArrow(@DrawableRes int i2) {
        this.Z2.setImageResource(i2);
    }

    public void setSelectedDate(@Nullable CalendarDay calendarDay) {
        q();
        if (calendarDay != null) {
            P(calendarDay, true);
        }
    }

    public void setSelectionColor(int i2) {
        if (i2 == 0) {
            if (isInEditMode()) {
                i2 = -7829368;
            } else {
                return;
            }
        }
        this.q3 = i2;
        this.b3.S(i2);
        invalidate();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0010, code lost:
        if (r0 != 0) goto L_0x0012;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setSelectionMode(int r6) {
        /*
            r5 = this;
            int r0 = r5.t3
            r5.t3 = r6
            r1 = 0
            r2 = 3
            r3 = 2
            r4 = 1
            if (r6 == r4) goto L_0x0016
            if (r6 == r3) goto L_0x002b
            if (r6 == r2) goto L_0x0012
            r5.t3 = r1
            if (r0 == 0) goto L_0x002b
        L_0x0012:
            r5.q()
            goto L_0x002b
        L_0x0016:
            if (r0 == r3) goto L_0x001a
            if (r0 != r2) goto L_0x002b
        L_0x001a:
            java.util.List r6 = r5.getSelectedDates()
            boolean r6 = r6.isEmpty()
            if (r6 != 0) goto L_0x002b
            com.prolificinteractive.materialcalendarview.CalendarDay r6 = r5.getSelectedDate()
            r5.setSelectedDate((com.prolificinteractive.materialcalendarview.CalendarDay) r6)
        L_0x002b:
            com.prolificinteractive.materialcalendarview.CalendarPagerAdapter<?> r6 = r5.b3
            int r0 = r5.t3
            if (r0 == 0) goto L_0x0032
            r1 = 1
        L_0x0032:
            r6.T(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.prolificinteractive.materialcalendarview.MaterialCalendarView.setSelectionMode(int):void");
    }

    public void setShowOtherDates(int i2) {
        this.b3.U(i2);
    }

    public void setTileHeight(int i2) {
        this.r3 = i2;
        requestLayout();
    }

    public void setTileHeightDp(int i2) {
        setTileHeight(v(i2));
    }

    public void setTileSize(int i2) {
        this.s3 = i2;
        this.r3 = i2;
        requestLayout();
    }

    public void setTileSizeDp(int i2) {
        setTileSize(v(i2));
    }

    public void setTileWidth(int i2) {
        this.s3 = i2;
        requestLayout();
    }

    public void setTileWidthDp(int i2) {
        setTileWidth(v(i2));
    }

    public void setTitleAnimationOrientation(int i2) {
        this.s.j(i2);
    }

    public void setTitleFormatter(@Nullable TitleFormatter titleFormatter) {
        this.s.l(titleFormatter);
        this.b3.W(titleFormatter);
        W();
    }

    public void setTitleMonths(@ArrayRes int i2) {
        setTitleMonths(getResources().getTextArray(i2));
    }

    public void setTopbarVisible(boolean z) {
        this.d3.setVisibility(z ? 0 : 8);
        requestLayout();
    }

    public void setWeekDayFormatter(WeekDayFormatter weekDayFormatter) {
        CalendarPagerAdapter<?> calendarPagerAdapter = this.b3;
        if (weekDayFormatter == null) {
            weekDayFormatter = WeekDayFormatter.f28158a;
        }
        calendarPagerAdapter.X(weekDayFormatter);
    }

    public void setWeekDayLabels(@ArrayRes int i2) {
        setWeekDayLabels(getResources().getTextArray(i2));
    }

    public void setWeekDayTextAppearance(int i2) {
        this.b3.Y(i2);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void t(CalendarDay calendarDay) {
        OnMonthChangedListener onMonthChangedListener = this.n3;
        if (onMonthChangedListener != null) {
            onMonthChangedListener.a(this, calendarDay);
        }
    }

    /* access modifiers changed from: protected */
    public void u(@NonNull List<CalendarDay> list) {
        OnRangeSelectedListener onRangeSelectedListener = this.o3;
        if (onRangeSelectedListener != null) {
            onRangeSelectedListener.a(this, list);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(1);
    }

    /* renamed from: y */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(1);
    }

    public static class SavedState extends View.BaseSavedState {
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
        boolean X;
        List<CalendarDay> X2;
        CalendarDay Y;
        boolean Y2;
        CalendarDay Z;
        int Z2;
        boolean a3;
        CalendarDay b3;
        boolean c3;
        int s;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.s = 4;
            boolean z = true;
            this.X = true;
            this.Y = null;
            this.Z = null;
            this.X2 = new ArrayList();
            this.Y2 = true;
            this.Z2 = 1;
            this.a3 = false;
            this.b3 = null;
            this.s = parcel.readInt();
            this.X = parcel.readByte() != 0;
            ClassLoader classLoader = CalendarDay.class.getClassLoader();
            this.Y = (CalendarDay) parcel.readParcelable(classLoader);
            this.Z = (CalendarDay) parcel.readParcelable(classLoader);
            parcel.readTypedList(this.X2, CalendarDay.CREATOR);
            this.Y2 = parcel.readInt() == 1;
            this.Z2 = parcel.readInt();
            this.a3 = parcel.readInt() == 1;
            this.b3 = (CalendarDay) parcel.readParcelable(classLoader);
            this.c3 = parcel.readByte() == 0 ? false : z;
        }

        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.s);
            parcel.writeByte(this.X ? (byte) 1 : 0);
            parcel.writeParcelable(this.Y, 0);
            parcel.writeParcelable(this.Z, 0);
            parcel.writeTypedList(this.X2);
            parcel.writeInt(this.Y2 ? 1 : 0);
            parcel.writeInt(this.Z2);
            parcel.writeInt(this.a3 ? 1 : 0);
            parcel.writeParcelable(this.b3, 0);
            parcel.writeByte(this.c3 ? (byte) 1 : 0);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
            this.s = 4;
            this.X = true;
            this.Y = null;
            this.Z = null;
            this.X2 = new ArrayList();
            this.Y2 = true;
            this.Z2 = 1;
            this.a3 = false;
            this.b3 = null;
        }
    }

    public MaterialCalendarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g3 = new ArrayList<>();
        AnonymousClass1 r0 = new View.OnClickListener() {
            public void onClick(View view) {
                CalendarPager b2;
                int currentItem;
                if (view == MaterialCalendarView.this.Z2) {
                    b2 = MaterialCalendarView.this.a3;
                    currentItem = MaterialCalendarView.this.a3.getCurrentItem() + 1;
                } else if (view == MaterialCalendarView.this.Y2) {
                    b2 = MaterialCalendarView.this.a3;
                    currentItem = MaterialCalendarView.this.a3.getCurrentItem() - 1;
                } else {
                    return;
                }
                b2.S(currentItem, true);
            }
        };
        this.h3 = r0;
        AnonymousClass2 r1 = new ViewPager.OnPageChangeListener() {
            public void a(int i2, float f2, int i3) {
            }

            public void c(int i2) {
            }

            public void d(int i2) {
                MaterialCalendarView.this.s.k(MaterialCalendarView.this.c3);
                MaterialCalendarView materialCalendarView = MaterialCalendarView.this;
                CalendarDay unused = materialCalendarView.c3 = materialCalendarView.b3.A(i2);
                MaterialCalendarView.this.W();
                MaterialCalendarView materialCalendarView2 = MaterialCalendarView.this;
                materialCalendarView2.t(materialCalendarView2.c3);
            }
        };
        this.i3 = r1;
        this.j3 = null;
        this.k3 = null;
        this.q3 = 0;
        this.r3 = -10;
        this.s3 = -10;
        this.t3 = 1;
        this.u3 = true;
        setClipToPadding(false);
        setClipChildren(false);
        View inflate = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.A, (ViewGroup) null, false);
        this.d3 = (LinearLayout) inflate.findViewById(R.id.N);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.p0);
        this.Y2 = imageView;
        TextView textView = (TextView) inflate.findViewById(R.id.f0);
        this.X2 = textView;
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.i0);
        this.Z2 = imageView2;
        CalendarPager calendarPager = new CalendarPager(getContext());
        this.a3 = calendarPager;
        imageView.setOnClickListener(r0);
        imageView2.setOnClickListener(r0);
        TitleChanger titleChanger = new TitleChanger(textView);
        this.s = titleChanger;
        calendarPager.setOnPageChangeListener(r1);
        calendarPager.W(false, new ViewPager.PageTransformer() {
            public void a(View view, float f2) {
                view.setAlpha((float) Math.sqrt((double) (1.0f - Math.abs(f2))));
            }
        });
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.v4, 0, 0);
        try {
            int integer = obtainStyledAttributes.getInteger(R.styleable.x4, 0);
            int integer2 = obtainStyledAttributes.getInteger(R.styleable.z4, -1);
            titleChanger.j(obtainStyledAttributes.getInteger(R.styleable.L4, 0));
            this.v3 = (integer2 < 1 || integer2 > 7) ? WeekFields.e(Locale.getDefault()).c() : DayOfWeek.s(integer2);
            this.w3 = obtainStyledAttributes.getBoolean(R.styleable.H4, true);
            G().j(this.v3).i(CalendarMode.values()[integer]).o(this.w3).g();
            setSelectionMode(obtainStyledAttributes.getInteger(R.styleable.F4, 1));
            int layoutDimension = obtainStyledAttributes.getLayoutDimension(R.styleable.J4, -10);
            if (layoutDimension > -10) {
                setTileSize(layoutDimension);
            }
            int layoutDimension2 = obtainStyledAttributes.getLayoutDimension(R.styleable.K4, -10);
            if (layoutDimension2 > -10) {
                setTileWidth(layoutDimension2);
            }
            int layoutDimension3 = obtainStyledAttributes.getLayoutDimension(R.styleable.I4, -10);
            if (layoutDimension3 > -10) {
                setTileHeight(layoutDimension3);
            }
            setLeftArrow(obtainStyledAttributes.getResourceId(R.styleable.B4, R.drawable.u0));
            setRightArrow(obtainStyledAttributes.getResourceId(R.styleable.D4, R.drawable.t0));
            setSelectionColor(obtainStyledAttributes.getColor(R.styleable.E4, z(context)));
            CharSequence[] textArray = obtainStyledAttributes.getTextArray(R.styleable.M4);
            if (textArray != null) {
                setWeekDayFormatter(new ArrayWeekDayFormatter(textArray));
            }
            CharSequence[] textArray2 = obtainStyledAttributes.getTextArray(R.styleable.C4);
            if (textArray2 != null) {
                setTitleFormatter(new MonthArrayTitleFormatter(textArray2));
            }
            setHeaderTextAppearance(obtainStyledAttributes.getResourceId(R.styleable.A4, R.style.H3));
            setWeekDayTextAppearance(obtainStyledAttributes.getResourceId(R.styleable.N4, R.style.I3));
            setDateTextAppearance(obtainStyledAttributes.getResourceId(R.styleable.y4, R.style.G3));
            setShowOtherDates(obtainStyledAttributes.getInteger(R.styleable.G4, 4));
            setAllowClickDaysOutsideCurrentMonth(obtainStyledAttributes.getBoolean(R.styleable.w4, true));
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
        obtainStyledAttributes.recycle();
        R();
        CalendarDay p = CalendarDay.p();
        this.c3 = p;
        setCurrentDate(p);
        if (isInEditMode()) {
            removeView(this.a3);
            MonthView monthView = new MonthView(this, this.c3, getFirstDayOfWeek(), true);
            monthView.s(getSelectionColor());
            monthView.l(this.b3.y());
            monthView.w(this.b3.E());
            monthView.u(getShowOtherDates());
            addView(monthView, new LayoutParams(this.e3.s + 1));
        }
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(1);
    }

    public void setCurrentDate(@Nullable LocalDate localDate) {
        setCurrentDate(CalendarDay.b(localDate));
    }

    public void setSelectedDate(@Nullable LocalDate localDate) {
        setSelectedDate(CalendarDay.b(localDate));
    }

    public void setTitleMonths(CharSequence[] charSequenceArr) {
        setTitleFormatter(new MonthArrayTitleFormatter(charSequenceArr));
    }

    public void setWeekDayLabels(CharSequence[] charSequenceArr) {
        setWeekDayFormatter(new ArrayWeekDayFormatter(charSequenceArr));
    }
}
