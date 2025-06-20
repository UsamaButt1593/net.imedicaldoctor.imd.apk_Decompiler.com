package com.google.android.material.datepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.util.Pair;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.R;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.dialog.InsetDialogOnTouchListener;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.EdgeToEdgeUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.apache.commons.lang3.StringUtils;

public final class MaterialDatePicker<S> extends DialogFragment {
    static final Object A5 = "TOGGLE_BUTTON_TAG";
    public static final int B5 = 0;
    public static final int C5 = 1;
    private static final String j5 = "OVERRIDE_THEME_RES_ID";
    private static final String k5 = "DATE_SELECTOR_KEY";
    private static final String l5 = "CALENDAR_CONSTRAINTS_KEY";
    private static final String m5 = "DAY_VIEW_DECORATOR_KEY";
    private static final String n5 = "TITLE_TEXT_RES_ID_KEY";
    private static final String o5 = "TITLE_TEXT_KEY";
    private static final String p5 = "POSITIVE_BUTTON_TEXT_RES_ID_KEY";
    private static final String q5 = "POSITIVE_BUTTON_TEXT_KEY";
    private static final String r5 = "POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY";
    private static final String s5 = "POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY";
    private static final String t5 = "NEGATIVE_BUTTON_TEXT_RES_ID_KEY";
    private static final String u5 = "NEGATIVE_BUTTON_TEXT_KEY";
    private static final String v5 = "NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY";
    private static final String w5 = "NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY";
    private static final String x5 = "INPUT_MODE_KEY";
    static final Object y5 = "CONFIRM_BUTTON_TAG";
    static final Object z5 = "CANCEL_BUTTON_TAG";
    /* access modifiers changed from: private */
    public final LinkedHashSet<MaterialPickerOnPositiveButtonClickListener<? super S>> F4 = new LinkedHashSet<>();
    /* access modifiers changed from: private */
    public final LinkedHashSet<View.OnClickListener> G4 = new LinkedHashSet<>();
    private final LinkedHashSet<DialogInterface.OnCancelListener> H4 = new LinkedHashSet<>();
    private final LinkedHashSet<DialogInterface.OnDismissListener> I4 = new LinkedHashSet<>();
    @StyleRes
    private int J4;
    @Nullable
    private DateSelector<S> K4;
    private PickerFragment<S> L4;
    @Nullable
    private CalendarConstraints M4;
    @Nullable
    private DayViewDecorator N4;
    private MaterialCalendar<S> O4;
    @StringRes
    private int P4;
    private CharSequence Q4;
    private boolean R4;
    private int S4;
    @StringRes
    private int T4;
    private CharSequence U4;
    @StringRes
    private int V4;
    private CharSequence W4;
    @StringRes
    private int X4;
    private CharSequence Y4;
    @StringRes
    private int Z4;
    private CharSequence a5;
    private TextView b5;
    private TextView c5;
    private CheckableImageButton d5;
    @Nullable
    private MaterialShapeDrawable e5;
    /* access modifiers changed from: private */
    public Button f5;
    private boolean g5;
    @Nullable
    private CharSequence h5;
    @Nullable
    private CharSequence i5;

    public static final class Builder<S> {

        /* renamed from: a  reason: collision with root package name */
        final DateSelector<S> f21365a;

        /* renamed from: b  reason: collision with root package name */
        int f21366b = 0;

        /* renamed from: c  reason: collision with root package name */
        CalendarConstraints f21367c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        DayViewDecorator f21368d;

        /* renamed from: e  reason: collision with root package name */
        int f21369e = 0;

        /* renamed from: f  reason: collision with root package name */
        CharSequence f21370f = null;

        /* renamed from: g  reason: collision with root package name */
        int f21371g = 0;

        /* renamed from: h  reason: collision with root package name */
        CharSequence f21372h = null;

        /* renamed from: i  reason: collision with root package name */
        int f21373i = 0;

        /* renamed from: j  reason: collision with root package name */
        CharSequence f21374j = null;

        /* renamed from: k  reason: collision with root package name */
        int f21375k = 0;

        /* renamed from: l  reason: collision with root package name */
        CharSequence f21376l = null;

        /* renamed from: m  reason: collision with root package name */
        int f21377m = 0;

        /* renamed from: n  reason: collision with root package name */
        CharSequence f21378n = null;
        @Nullable
        S o = null;
        int p = 0;

        private Builder(DateSelector<S> dateSelector) {
            this.f21365a = dateSelector;
        }

        private Month b() {
            if (!this.f21365a.F().isEmpty()) {
                Month c2 = Month.c(this.f21365a.F().iterator().next().longValue());
                if (f(c2, this.f21367c)) {
                    return c2;
                }
            }
            Month g2 = Month.g();
            return f(g2, this.f21367c) ? g2 : this.f21367c.z();
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static <S> Builder<S> c(@NonNull DateSelector<S> dateSelector) {
            return new Builder<>(dateSelector);
        }

        @NonNull
        public static Builder<Long> d() {
            return new Builder<>(new SingleDateSelector());
        }

        @NonNull
        public static Builder<Pair<Long, Long>> e() {
            return new Builder<>(new RangeDateSelector());
        }

        private static boolean f(Month month, CalendarConstraints calendarConstraints) {
            return month.compareTo(calendarConstraints.z()) >= 0 && month.compareTo(calendarConstraints.l()) <= 0;
        }

        @NonNull
        public MaterialDatePicker<S> a() {
            if (this.f21367c == null) {
                this.f21367c = new CalendarConstraints.Builder().a();
            }
            if (this.f21369e == 0) {
                this.f21369e = this.f21365a.s();
            }
            S s = this.o;
            if (s != null) {
                this.f21365a.i(s);
            }
            if (this.f21367c.t() == null) {
                this.f21367c.E(b());
            }
            return MaterialDatePicker.I3(this);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder<S> g(CalendarConstraints calendarConstraints) {
            this.f21367c = calendarConstraints;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder<S> h(@Nullable DayViewDecorator dayViewDecorator) {
            this.f21368d = dayViewDecorator;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder<S> i(int i2) {
            this.p = i2;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder<S> j(@StringRes int i2) {
            this.f21377m = i2;
            this.f21378n = null;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder<S> k(@Nullable CharSequence charSequence) {
            this.f21378n = charSequence;
            this.f21377m = 0;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder<S> l(@StringRes int i2) {
            this.f21375k = i2;
            this.f21376l = null;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder<S> m(@Nullable CharSequence charSequence) {
            this.f21376l = charSequence;
            this.f21375k = 0;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder<S> n(@StringRes int i2) {
            this.f21373i = i2;
            this.f21374j = null;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder<S> o(@Nullable CharSequence charSequence) {
            this.f21374j = charSequence;
            this.f21373i = 0;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder<S> p(@StringRes int i2) {
            this.f21371g = i2;
            this.f21372h = null;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder<S> q(@Nullable CharSequence charSequence) {
            this.f21372h = charSequence;
            this.f21371g = 0;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder<S> r(S s) {
            this.o = s;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder<S> s(@Nullable SimpleDateFormat simpleDateFormat) {
            this.f21365a.w(simpleDateFormat);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder<S> t(@StyleRes int i2) {
            this.f21366b = i2;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder<S> u(@StringRes int i2) {
            this.f21369e = i2;
            this.f21370f = null;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder<S> v(@Nullable CharSequence charSequence) {
            this.f21370f = charSequence;
            this.f21369e = 0;
            return this;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface InputMode {
    }

    private static int A3(@NonNull Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.fb);
        int i2 = Month.g().Z;
        return (dimensionPixelOffset * 2) + (resources.getDimensionPixelSize(R.dimen.lb) * i2) + ((i2 - 1) * resources.getDimensionPixelOffset(R.dimen.zb));
    }

    private int C3(Context context) {
        int i2 = this.J4;
        return i2 != 0 ? i2 : v3().x(context);
    }

    private void D3(Context context) {
        this.d5.setTag(A5);
        this.d5.setImageDrawable(t3(context));
        this.d5.setChecked(this.S4 != 0);
        ViewCompat.H1(this.d5, (AccessibilityDelegateCompat) null);
        T3(this.d5);
        this.d5.setOnClickListener(new g(this));
    }

    static boolean E3(@NonNull Context context) {
        return J3(context, 16843277);
    }

    private boolean F3() {
        return b0().getConfiguration().orientation == 2;
    }

    static boolean G3(@NonNull Context context) {
        return J3(context, R.attr.ue);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void H3(View view) {
        this.f5.setEnabled(v3().A());
        this.d5.toggle();
        int i2 = 1;
        if (this.S4 == 1) {
            i2 = 0;
        }
        this.S4 = i2;
        T3(this.d5);
        O3();
    }

    @NonNull
    static <S> MaterialDatePicker<S> I3(@NonNull Builder<S> builder) {
        MaterialDatePicker<S> materialDatePicker = new MaterialDatePicker<>();
        Bundle bundle = new Bundle();
        bundle.putInt(j5, builder.f21366b);
        bundle.putParcelable(k5, builder.f21365a);
        bundle.putParcelable(l5, builder.f21367c);
        bundle.putParcelable(m5, builder.f21368d);
        bundle.putInt(n5, builder.f21369e);
        bundle.putCharSequence(o5, builder.f21370f);
        bundle.putInt(x5, builder.p);
        bundle.putInt(p5, builder.f21371g);
        bundle.putCharSequence(q5, builder.f21372h);
        bundle.putInt(r5, builder.f21373i);
        bundle.putCharSequence(s5, builder.f21374j);
        bundle.putInt(t5, builder.f21375k);
        bundle.putCharSequence(u5, builder.f21376l);
        bundle.putInt(v5, builder.f21377m);
        bundle.putCharSequence(w5, builder.f21378n);
        materialDatePicker.i2(bundle);
        return materialDatePicker;
    }

    static boolean J3(@NonNull Context context, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(MaterialAttributes.g(context, R.attr.Ac, MaterialCalendar.class.getCanonicalName()), new int[]{i2});
        boolean z = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z;
    }

    private void O3() {
        int C3 = C3(X1());
        MaterialCalendar<S> d3 = MaterialCalendar.d3(v3(), C3, this.M4, this.N4);
        this.O4 = d3;
        PickerFragment pickerFragment = d3;
        if (this.S4 == 1) {
            pickerFragment = MaterialTextInputPicker.N2(v3(), C3, this.M4);
        }
        this.L4 = pickerFragment;
        S3();
        R3(y3());
        FragmentTransaction u = z().u();
        u.C(R.id.j3, this.L4);
        u.s();
        this.L4.J2(new OnSelectionChangedListener<S>() {
            public void a() {
                MaterialDatePicker.this.f5.setEnabled(false);
            }

            public void b(S s) {
                MaterialDatePicker materialDatePicker = MaterialDatePicker.this;
                materialDatePicker.R3(materialDatePicker.y3());
                MaterialDatePicker.this.f5.setEnabled(MaterialDatePicker.this.v3().A());
            }
        });
    }

    public static long P3() {
        return Month.g().Y2;
    }

    public static long Q3() {
        return UtcDates.v().getTimeInMillis();
    }

    private void S3() {
        this.b5.setText((this.S4 != 1 || !F3()) ? this.h5 : this.i5);
    }

    private void T3(@NonNull CheckableImageButton checkableImageButton) {
        this.d5.setContentDescription(checkableImageButton.getContext().getString(this.S4 == 1 ? R.string.J1 : R.string.L1));
    }

    @NonNull
    private static Drawable t3(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842912}, AppCompatResources.b(context, R.drawable.v1));
        stateListDrawable.addState(new int[0], AppCompatResources.b(context, R.drawable.x1));
        return stateListDrawable;
    }

    private void u3(Window window) {
        if (!this.g5) {
            final View findViewById = b2().findViewById(R.id.R1);
            EdgeToEdgeUtils.b(window, true, ViewUtils.j(findViewById), (Integer) null);
            final int paddingTop = findViewById.getPaddingTop();
            final int i2 = findViewById.getLayoutParams().height;
            ViewCompat.k2(findViewById, new OnApplyWindowInsetsListener() {
                public WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat) {
                    int i2 = windowInsetsCompat.f(WindowInsetsCompat.Type.i()).f5825b;
                    if (i2 >= 0) {
                        findViewById.getLayoutParams().height = i2 + i2;
                        View view2 = findViewById;
                        view2.setLayoutParams(view2.getLayoutParams());
                    }
                    View view3 = findViewById;
                    view3.setPadding(view3.getPaddingLeft(), paddingTop + i2, findViewById.getPaddingRight(), findViewById.getPaddingBottom());
                    return windowInsetsCompat;
                }
            });
            this.g5 = true;
        }
    }

    /* access modifiers changed from: private */
    public DateSelector<S> v3() {
        if (this.K4 == null) {
            this.K4 = (DateSelector) y().getParcelable(k5);
        }
        return this.K4;
    }

    @Nullable
    private static CharSequence w3(@Nullable CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        String[] split = TextUtils.split(String.valueOf(charSequence), StringUtils.LF);
        return split.length > 1 ? split[0] : charSequence;
    }

    private String x3() {
        return v3().u(X1());
    }

    @Nullable
    public final S B3() {
        return v3().G();
    }

    public boolean K3(DialogInterface.OnCancelListener onCancelListener) {
        return this.H4.remove(onCancelListener);
    }

    public boolean L3(DialogInterface.OnDismissListener onDismissListener) {
        return this.I4.remove(onDismissListener);
    }

    public boolean M3(View.OnClickListener onClickListener) {
        return this.G4.remove(onClickListener);
    }

    public boolean N3(MaterialPickerOnPositiveButtonClickListener<? super S> materialPickerOnPositiveButtonClickListener) {
        return this.F4.remove(materialPickerOnPositiveButtonClickListener);
    }

    public final void Q0(@Nullable Bundle bundle) {
        super.Q0(bundle);
        if (bundle == null) {
            bundle = y();
        }
        this.J4 = bundle.getInt(j5);
        this.K4 = (DateSelector) bundle.getParcelable(k5);
        this.M4 = (CalendarConstraints) bundle.getParcelable(l5);
        this.N4 = (DayViewDecorator) bundle.getParcelable(m5);
        this.P4 = bundle.getInt(n5);
        this.Q4 = bundle.getCharSequence(o5);
        this.S4 = bundle.getInt(x5);
        this.T4 = bundle.getInt(p5);
        this.U4 = bundle.getCharSequence(q5);
        this.V4 = bundle.getInt(r5);
        this.W4 = bundle.getCharSequence(s5);
        this.X4 = bundle.getInt(t5);
        this.Y4 = bundle.getCharSequence(u5);
        this.Z4 = bundle.getInt(v5);
        this.a5 = bundle.getCharSequence(w5);
        CharSequence charSequence = this.Q4;
        if (charSequence == null) {
            charSequence = X1().getResources().getText(this.P4);
        }
        this.h5 = charSequence;
        this.i5 = w3(charSequence);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void R3(String str) {
        this.c5.setContentDescription(x3());
        this.c5.setText(str);
    }

    @NonNull
    public final View onFragmentBind(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View findViewById;
        LinearLayout.LayoutParams layoutParams;
        View inflate = layoutInflater.inflate(this.R4 ? R.layout.J0 : R.layout.I0, viewGroup);
        Context context = inflate.getContext();
        DayViewDecorator dayViewDecorator = this.N4;
        if (dayViewDecorator != null) {
            dayViewDecorator.l(context);
        }
        if (this.R4) {
            findViewById = inflate.findViewById(R.id.j3);
            layoutParams = new LinearLayout.LayoutParams(A3(context), -2);
        } else {
            findViewById = inflate.findViewById(R.id.k3);
            layoutParams = new LinearLayout.LayoutParams(A3(context), -1);
        }
        findViewById.setLayoutParams(layoutParams);
        TextView textView = (TextView) inflate.findViewById(R.id.v3);
        this.c5 = textView;
        ViewCompat.J1(textView, 1);
        this.d5 = (CheckableImageButton) inflate.findViewById(R.id.x3);
        this.b5 = (TextView) inflate.findViewById(R.id.B3);
        D3(context);
        this.f5 = (Button) inflate.findViewById(R.id.M0);
        if (v3().A()) {
            this.f5.setEnabled(true);
        } else {
            this.f5.setEnabled(false);
        }
        this.f5.setTag(y5);
        CharSequence charSequence = this.U4;
        if (charSequence != null) {
            this.f5.setText(charSequence);
        } else {
            int i2 = this.T4;
            if (i2 != 0) {
                this.f5.setText(i2);
            }
        }
        CharSequence charSequence2 = this.W4;
        if (charSequence2 != null) {
            this.f5.setContentDescription(charSequence2);
        } else if (this.V4 != 0) {
            this.f5.setContentDescription(B().getResources().getText(this.V4));
        }
        this.f5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Iterator it2 = MaterialDatePicker.this.F4.iterator();
                while (it2.hasNext()) {
                    ((MaterialPickerOnPositiveButtonClickListener) it2.next()).a(MaterialDatePicker.this.B3());
                }
                MaterialDatePicker.this.M2();
            }
        });
        Button button = (Button) inflate.findViewById(R.id.A0);
        button.setTag(z5);
        CharSequence charSequence3 = this.Y4;
        if (charSequence3 != null) {
            button.setText(charSequence3);
        } else {
            int i3 = this.X4;
            if (i3 != 0) {
                button.setText(i3);
            }
        }
        CharSequence charSequence4 = this.a5;
        if (charSequence4 == null) {
            if (this.Z4 != 0) {
                charSequence4 = B().getResources().getText(this.Z4);
            }
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Iterator it2 = MaterialDatePicker.this.G4.iterator();
                    while (it2.hasNext()) {
                        ((View.OnClickListener) it2.next()).onClick(view);
                    }
                    MaterialDatePicker.this.M2();
                }
            });
            return inflate;
        }
        button.setContentDescription(charSequence4);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Iterator it2 = MaterialDatePicker.this.G4.iterator();
                while (it2.hasNext()) {
                    ((View.OnClickListener) it2.next()).onClick(view);
                }
                MaterialDatePicker.this.M2();
            }
        });
        return inflate;
    }

    @NonNull
    public final Dialog U2(@Nullable Bundle bundle) {
        Dialog dialog = new Dialog(X1(), C3(X1()));
        Context context = dialog.getContext();
        this.R4 = E3(context);
        int i2 = R.attr.Ac;
        int i3 = R.style.nj;
        this.e5 = new MaterialShapeDrawable(context, (AttributeSet) null, i2, i3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, R.styleable.Fm, i2, i3);
        int color = obtainStyledAttributes.getColor(R.styleable.Hm, 0);
        obtainStyledAttributes.recycle();
        this.e5.a0(context);
        this.e5.p0(ColorStateList.valueOf(color));
        this.e5.o0(ViewCompat.T(dialog.getWindow().getDecorView()));
        return dialog;
    }

    public boolean l3(DialogInterface.OnCancelListener onCancelListener) {
        return this.H4.add(onCancelListener);
    }

    public final void m1(@NonNull Bundle bundle) {
        super.m1(bundle);
        bundle.putInt(j5, this.J4);
        bundle.putParcelable(k5, this.K4);
        CalendarConstraints.Builder builder = new CalendarConstraints.Builder(this.M4);
        MaterialCalendar<S> materialCalendar = this.O4;
        Month Y2 = materialCalendar == null ? null : materialCalendar.Y2();
        if (Y2 != null) {
            builder.d(Y2.Y2);
        }
        bundle.putParcelable(l5, builder.a());
        bundle.putParcelable(m5, this.N4);
        bundle.putInt(n5, this.P4);
        bundle.putCharSequence(o5, this.Q4);
        bundle.putInt(x5, this.S4);
        bundle.putInt(p5, this.T4);
        bundle.putCharSequence(q5, this.U4);
        bundle.putInt(r5, this.V4);
        bundle.putCharSequence(s5, this.W4);
        bundle.putInt(t5, this.X4);
        bundle.putCharSequence(u5, this.Y4);
        bundle.putInt(v5, this.Z4);
        bundle.putCharSequence(w5, this.a5);
    }

    public boolean m3(DialogInterface.OnDismissListener onDismissListener) {
        return this.I4.add(onDismissListener);
    }

    public void n1() {
        super.n1();
        Window window = Y2().getWindow();
        if (this.R4) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.e5);
            u3(window);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = b0().getDimensionPixelOffset(R.dimen.nb);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable(this.e5, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new InsetDialogOnTouchListener(Y2(), rect));
        }
        O3();
    }

    public boolean n3(View.OnClickListener onClickListener) {
        return this.G4.add(onClickListener);
    }

    public void o1() {
        this.L4.K2();
        super.o1();
    }

    public boolean o3(MaterialPickerOnPositiveButtonClickListener<? super S> materialPickerOnPositiveButtonClickListener) {
        return this.F4.add(materialPickerOnPositiveButtonClickListener);
    }

    public final void onCancel(@NonNull DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnCancelListener> it2 = this.H4.iterator();
        while (it2.hasNext()) {
            it2.next().onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    public final void onDismiss(@NonNull DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it2 = this.I4.iterator();
        while (it2.hasNext()) {
            it2.next().onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) q0();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    public void p3() {
        this.H4.clear();
    }

    public void q3() {
        this.I4.clear();
    }

    public void r3() {
        this.G4.clear();
    }

    public void s3() {
        this.F4.clear();
    }

    public String y3() {
        return v3().f(B());
    }

    public int z3() {
        return this.S4;
    }
}
