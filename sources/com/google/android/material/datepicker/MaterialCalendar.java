package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pair;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;
import java.util.Iterator;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class MaterialCalendar<S> extends PickerFragment<S> {
    @VisibleForTesting
    static final Object A4 = "NAVIGATION_NEXT_TAG";
    @VisibleForTesting
    static final Object B4 = "SELECTOR_TOGGLE_TAG";
    private static final String s4 = "THEME_RES_ID_KEY";
    private static final String t4 = "GRID_SELECTOR_KEY";
    private static final String u4 = "CALENDAR_CONSTRAINTS_KEY";
    private static final String v4 = "DAY_VIEW_DECORATOR_KEY";
    private static final String w4 = "CURRENT_MONTH_KEY";
    private static final int x4 = 3;
    @VisibleForTesting
    static final Object y4 = "MONTHS_VIEW_GROUP_TAG";
    @VisibleForTesting
    static final Object z4 = "NAVIGATION_PREV_TAG";
    @StyleRes
    private int f4;
    /* access modifiers changed from: private */
    @Nullable
    public DateSelector<S> g4;
    /* access modifiers changed from: private */
    @Nullable
    public CalendarConstraints h4;
    @Nullable
    private DayViewDecorator i4;
    /* access modifiers changed from: private */
    @Nullable
    public Month j4;
    private CalendarSelector k4;
    /* access modifiers changed from: private */
    public CalendarStyle l4;
    /* access modifiers changed from: private */
    public RecyclerView m4;
    /* access modifiers changed from: private */
    public RecyclerView n4;
    private View o4;
    private View p4;
    private View q4;
    /* access modifiers changed from: private */
    public View r4;

    enum CalendarSelector {
        DAY,
        YEAR
    }

    interface OnDayClickListener {
        void a(long j2);
    }

    private void U2(@NonNull View view, @NonNull final MonthsPagerAdapter monthsPagerAdapter) {
        final MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.b3);
        materialButton.setTag(B4);
        ViewCompat.H1(materialButton, new AccessibilityDelegateCompat() {
            public void g(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                MaterialCalendar materialCalendar;
                int i2;
                super.g(view, accessibilityNodeInfoCompat);
                if (MaterialCalendar.this.r4.getVisibility() == 0) {
                    materialCalendar = MaterialCalendar.this;
                    i2 = R.string.M1;
                } else {
                    materialCalendar = MaterialCalendar.this;
                    i2 = R.string.K1;
                }
                accessibilityNodeInfoCompat.A1(materialCalendar.i0(i2));
            }
        });
        View findViewById = view.findViewById(R.id.d3);
        this.o4 = findViewById;
        findViewById.setTag(z4);
        View findViewById2 = view.findViewById(R.id.c3);
        this.p4 = findViewById2;
        findViewById2.setTag(A4);
        this.q4 = view.findViewById(R.id.o3);
        this.r4 = view.findViewById(R.id.h3);
        g3(CalendarSelector.DAY);
        materialButton.setText(this.j4.m());
        this.n4.t(new RecyclerView.OnScrollListener() {
            public void a(@NonNull RecyclerView recyclerView, int i2) {
                if (i2 == 0) {
                    recyclerView.announceForAccessibility(materialButton.getText());
                }
            }

            public void b(@NonNull RecyclerView recyclerView, int i2, int i3) {
                LinearLayoutManager b3 = MaterialCalendar.this.b3();
                int B2 = i2 < 0 ? b3.B2() : b3.E2();
                Month unused = MaterialCalendar.this.j4 = monthsPagerAdapter.e0(B2);
                materialButton.setText(monthsPagerAdapter.f0(B2));
            }
        });
        materialButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MaterialCalendar.this.i3();
            }
        });
        this.p4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int B2 = MaterialCalendar.this.b3().B2() + 1;
                if (B2 < MaterialCalendar.this.n4.getAdapter().b()) {
                    MaterialCalendar.this.f3(monthsPagerAdapter.e0(B2));
                }
            }
        });
        this.o4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int E2 = MaterialCalendar.this.b3().E2() - 1;
                if (E2 >= 0) {
                    MaterialCalendar.this.f3(monthsPagerAdapter.e0(E2));
                }
            }
        });
    }

    @NonNull
    private RecyclerView.ItemDecoration V2() {
        return new RecyclerView.ItemDecoration() {

            /* renamed from: a  reason: collision with root package name */
            private final Calendar f21352a = UtcDates.x();

            /* renamed from: b  reason: collision with root package name */
            private final Calendar f21353b = UtcDates.x();

            public void i(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
                if ((recyclerView.getAdapter() instanceof YearGridAdapter) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                    YearGridAdapter yearGridAdapter = (YearGridAdapter) recyclerView.getAdapter();
                    GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                    for (Pair next : MaterialCalendar.this.g4.h()) {
                        F f2 = next.f6296a;
                        if (!(f2 == null || next.f6297b == null)) {
                            this.f21352a.setTimeInMillis(((Long) f2).longValue());
                            this.f21353b.setTimeInMillis(((Long) next.f6297b).longValue());
                            int f0 = yearGridAdapter.f0(this.f21352a.get(1));
                            int f02 = yearGridAdapter.f0(this.f21353b.get(1));
                            View O = gridLayoutManager.O(f0);
                            View O2 = gridLayoutManager.O(f02);
                            int H3 = f0 / gridLayoutManager.H3();
                            int H32 = f02 / gridLayoutManager.H3();
                            int i2 = H3;
                            while (i2 <= H32) {
                                View O3 = gridLayoutManager.O(gridLayoutManager.H3() * i2);
                                if (O3 != null) {
                                    canvas.drawRect((float) ((i2 != H3 || O == null) ? 0 : O.getLeft() + (O.getWidth() / 2)), (float) (O3.getTop() + MaterialCalendar.this.l4.f21344d.e()), (float) ((i2 != H32 || O2 == null) ? recyclerView.getWidth() : O2.getLeft() + (O2.getWidth() / 2)), (float) (O3.getBottom() - MaterialCalendar.this.l4.f21344d.b()), MaterialCalendar.this.l4.f21348h);
                                }
                                i2++;
                            }
                        }
                    }
                }
            }
        };
    }

    @Px
    static int Z2(@NonNull Context context) {
        return context.getResources().getDimensionPixelSize(R.dimen.hb);
    }

    private static int a3(@NonNull Context context) {
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.Cb) + resources.getDimensionPixelOffset(R.dimen.Db) + resources.getDimensionPixelOffset(R.dimen.Bb);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.mb);
        int i2 = MonthAdapter.Z2;
        return dimensionPixelSize + dimensionPixelSize2 + (resources.getDimensionPixelSize(R.dimen.hb) * i2) + ((i2 - 1) * resources.getDimensionPixelOffset(R.dimen.Ab)) + resources.getDimensionPixelOffset(R.dimen.eb);
    }

    @NonNull
    public static <T> MaterialCalendar<T> c3(@NonNull DateSelector<T> dateSelector, @StyleRes int i2, @NonNull CalendarConstraints calendarConstraints) {
        return d3(dateSelector, i2, calendarConstraints, (DayViewDecorator) null);
    }

    @NonNull
    public static <T> MaterialCalendar<T> d3(@NonNull DateSelector<T> dateSelector, @StyleRes int i2, @NonNull CalendarConstraints calendarConstraints, @Nullable DayViewDecorator dayViewDecorator) {
        MaterialCalendar<T> materialCalendar = new MaterialCalendar<>();
        Bundle bundle = new Bundle();
        bundle.putInt(s4, i2);
        bundle.putParcelable(t4, dateSelector);
        bundle.putParcelable(u4, calendarConstraints);
        bundle.putParcelable(v4, dayViewDecorator);
        bundle.putParcelable(w4, calendarConstraints.t());
        materialCalendar.i2(bundle);
        return materialCalendar;
    }

    private void e3(final int i2) {
        this.n4.post(new Runnable() {
            public void run() {
                MaterialCalendar.this.n4.X1(i2);
            }
        });
    }

    private void h3() {
        ViewCompat.H1(this.n4, new AccessibilityDelegateCompat() {
            public void g(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.g(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.X1(false);
            }
        });
    }

    public boolean J2(@NonNull OnSelectionChangedListener<S> onSelectionChangedListener) {
        return super.J2(onSelectionChangedListener);
    }

    @Nullable
    public DateSelector<S> L2() {
        return this.g4;
    }

    public void Q0(@Nullable Bundle bundle) {
        super.Q0(bundle);
        if (bundle == null) {
            bundle = y();
        }
        this.f4 = bundle.getInt(s4);
        this.g4 = (DateSelector) bundle.getParcelable(t4);
        this.h4 = (CalendarConstraints) bundle.getParcelable(u4);
        this.i4 = (DayViewDecorator) bundle.getParcelable(v4);
        this.j4 = (Month) bundle.getParcelable(w4);
    }

    @NonNull
    public View U0(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        final int i2;
        int i3;
        DaysOfWeekAdapter daysOfWeekAdapter;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(B(), this.f4);
        this.l4 = new CalendarStyle(contextThemeWrapper);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        Month z = this.h4.z();
        if (MaterialDatePicker.E3(contextThemeWrapper)) {
            i3 = R.layout.C0;
            i2 = 1;
        } else {
            i3 = R.layout.x0;
            i2 = 0;
        }
        View inflate = cloneInContext.inflate(i3, viewGroup, false);
        inflate.setMinimumHeight(a3(X1()));
        GridView gridView = (GridView) inflate.findViewById(R.id.i3);
        ViewCompat.H1(gridView, new AccessibilityDelegateCompat() {
            public void g(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.g(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.l1((Object) null);
            }
        });
        int o = this.h4.o();
        if (o <= 0) {
            daysOfWeekAdapter = new DaysOfWeekAdapter();
        }
        gridView.setAdapter(daysOfWeekAdapter);
        gridView.setNumColumns(z.Z);
        gridView.setEnabled(false);
        this.n4 = (RecyclerView) inflate.findViewById(R.id.l3);
        this.n4.setLayoutManager(new SmoothCalendarLayoutManager(B(), i2, false) {
            /* access modifiers changed from: protected */
            public void o2(@NonNull RecyclerView.State state, @NonNull int[] iArr) {
                if (i2 == 0) {
                    iArr[0] = MaterialCalendar.this.n4.getWidth();
                    iArr[1] = MaterialCalendar.this.n4.getWidth();
                    return;
                }
                iArr[0] = MaterialCalendar.this.n4.getHeight();
                iArr[1] = MaterialCalendar.this.n4.getHeight();
            }
        });
        this.n4.setTag(y4);
        MonthsPagerAdapter monthsPagerAdapter = new MonthsPagerAdapter(contextThemeWrapper, this.g4, this.h4, this.i4, new OnDayClickListener() {
            public void a(long j2) {
                if (MaterialCalendar.this.h4.k().y(j2)) {
                    MaterialCalendar.this.g4.L(j2);
                    Iterator<OnSelectionChangedListener<S>> it2 = MaterialCalendar.this.e4.iterator();
                    while (it2.hasNext()) {
                        it2.next().b(MaterialCalendar.this.g4.G());
                    }
                    MaterialCalendar.this.n4.getAdapter().G();
                    if (MaterialCalendar.this.m4 != null) {
                        MaterialCalendar.this.m4.getAdapter().G();
                    }
                }
            }
        });
        this.n4.setAdapter(monthsPagerAdapter);
        int integer = contextThemeWrapper.getResources().getInteger(R.integer.Y);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.o3);
        this.m4 = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.m4.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.m4.setAdapter(new YearGridAdapter(this));
            this.m4.p(V2());
        }
        if (inflate.findViewById(R.id.b3) != null) {
            U2(inflate, monthsPagerAdapter);
        }
        if (!MaterialDatePicker.E3(contextThemeWrapper)) {
            new PagerSnapHelper().b(this.n4);
        }
        this.n4.O1(monthsPagerAdapter.g0(this.j4));
        h3();
        return inflate;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public CalendarConstraints W2() {
        return this.h4;
    }

    /* access modifiers changed from: package-private */
    public CalendarStyle X2() {
        return this.l4;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Month Y2() {
        return this.j4;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public LinearLayoutManager b3() {
        return (LinearLayoutManager) this.n4.getLayoutManager();
    }

    /* access modifiers changed from: package-private */
    public void f3(Month month) {
        RecyclerView recyclerView;
        int i2;
        MonthsPagerAdapter monthsPagerAdapter = (MonthsPagerAdapter) this.n4.getAdapter();
        int g0 = monthsPagerAdapter.g0(month);
        int g02 = g0 - monthsPagerAdapter.g0(this.j4);
        boolean z = false;
        boolean z2 = Math.abs(g02) > 3;
        if (g02 > 0) {
            z = true;
        }
        this.j4 = month;
        if (!z2 || !z) {
            if (z2) {
                recyclerView = this.n4;
                i2 = g0 + 3;
            }
            e3(g0);
        }
        recyclerView = this.n4;
        i2 = g0 - 3;
        recyclerView.O1(i2);
        e3(g0);
    }

    /* access modifiers changed from: package-private */
    public void g3(CalendarSelector calendarSelector) {
        this.k4 = calendarSelector;
        if (calendarSelector == CalendarSelector.YEAR) {
            this.m4.getLayoutManager().V1(((YearGridAdapter) this.m4.getAdapter()).f0(this.j4.Y));
            this.q4.setVisibility(0);
            this.r4.setVisibility(8);
            this.o4.setVisibility(8);
            this.p4.setVisibility(8);
        } else if (calendarSelector == CalendarSelector.DAY) {
            this.q4.setVisibility(8);
            this.r4.setVisibility(0);
            this.o4.setVisibility(0);
            this.p4.setVisibility(0);
            f3(this.j4);
        }
    }

    /* access modifiers changed from: package-private */
    public void i3() {
        CalendarSelector calendarSelector = this.k4;
        CalendarSelector calendarSelector2 = CalendarSelector.YEAR;
        if (calendarSelector == calendarSelector2) {
            g3(CalendarSelector.DAY);
        } else if (calendarSelector == CalendarSelector.DAY) {
            g3(calendarSelector2);
        }
    }

    public void m1(@NonNull Bundle bundle) {
        super.m1(bundle);
        bundle.putInt(s4, this.f4);
        bundle.putParcelable(t4, this.g4);
        bundle.putParcelable(u4, this.h4);
        bundle.putParcelable(v4, this.i4);
        bundle.putParcelable(w4, this.j4);
    }
}
