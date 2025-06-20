package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
import androidx.core.util.Preconditions;
import com.google.android.material.R;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.textfield.TextInputLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.commons.lang3.StringUtils;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class RangeDateSelector implements DateSelector<Pair<Long, Long>> {
    public static final Parcelable.Creator<RangeDateSelector> CREATOR = new Parcelable.Creator<RangeDateSelector>() {
        @NonNull
        /* renamed from: a */
        public RangeDateSelector createFromParcel(@NonNull Parcel parcel) {
            RangeDateSelector rangeDateSelector = new RangeDateSelector();
            Class<Long> cls = Long.class;
            Long unused = rangeDateSelector.Z = (Long) parcel.readValue(cls.getClassLoader());
            Long unused2 = rangeDateSelector.X2 = (Long) parcel.readValue(cls.getClassLoader());
            return rangeDateSelector;
        }

        @NonNull
        /* renamed from: b */
        public RangeDateSelector[] newArray(int i2) {
            return new RangeDateSelector[i2];
        }
    };
    private String X;
    /* access modifiers changed from: private */
    @Nullable
    public Long X2 = null;
    private final String Y = StringUtils.SPACE;
    /* access modifiers changed from: private */
    @Nullable
    public Long Y2 = null;
    /* access modifiers changed from: private */
    @Nullable
    public Long Z = null;
    /* access modifiers changed from: private */
    @Nullable
    public Long Z2 = null;
    @Nullable
    private SimpleDateFormat a3;
    @Nullable
    private CharSequence s;

    private void j(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2) {
        if (textInputLayout.getError() != null && this.X.contentEquals(textInputLayout.getError())) {
            textInputLayout.setError((CharSequence) null);
        }
        if (textInputLayout2.getError() != null && StringUtils.SPACE.contentEquals(textInputLayout2.getError())) {
            textInputLayout2.setError((CharSequence) null);
        }
    }

    private boolean l(long j2, long j3) {
        return j2 <= j3;
    }

    private void m(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2) {
        textInputLayout.setError(this.X);
        textInputLayout2.setError(StringUtils.SPACE);
    }

    private void p(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2) {
        this.s = !TextUtils.isEmpty(textInputLayout.getError()) ? textInputLayout.getError() : !TextUtils.isEmpty(textInputLayout2.getError()) ? textInputLayout2.getError() : null;
    }

    /* access modifiers changed from: private */
    public void t(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2, @NonNull OnSelectionChangedListener<Pair<Long, Long>> onSelectionChangedListener) {
        Long l2 = this.Y2;
        if (l2 == null || this.Z2 == null) {
            j(textInputLayout, textInputLayout2);
        } else if (l(l2.longValue(), this.Z2.longValue())) {
            this.Z = this.Y2;
            this.X2 = this.Z2;
            onSelectionChangedListener.b(G());
            p(textInputLayout, textInputLayout2);
        } else {
            m(textInputLayout, textInputLayout2);
        }
        onSelectionChangedListener.a();
        p(textInputLayout, textInputLayout2);
    }

    public boolean A() {
        Long l2 = this.Z;
        return (l2 == null || this.X2 == null || !l(l2.longValue(), this.X2.longValue())) ? false : true;
    }

    @NonNull
    public Collection<Long> F() {
        ArrayList arrayList = new ArrayList();
        Long l2 = this.Z;
        if (l2 != null) {
            arrayList.add(l2);
        }
        Long l3 = this.X2;
        if (l3 != null) {
            arrayList.add(l3);
        }
        return arrayList;
    }

    public void L(long j2) {
        Long l2 = this.Z;
        if (l2 != null) {
            if (this.X2 != null || !l(l2.longValue(), j2)) {
                this.X2 = null;
            } else {
                this.X2 = Long.valueOf(j2);
                return;
            }
        }
        this.Z = Long.valueOf(j2);
    }

    public int describeContents() {
        return 0;
    }

    @Nullable
    public String e() {
        if (TextUtils.isEmpty(this.s)) {
            return null;
        }
        return this.s.toString();
    }

    @NonNull
    public String f(@NonNull Context context) {
        Resources resources = context.getResources();
        Long l2 = this.Z;
        if (l2 == null && this.X2 == null) {
            return resources.getString(R.string.z1);
        }
        Long l3 = this.X2;
        if (l3 == null) {
            return resources.getString(R.string.w1, new Object[]{DateStrings.c(l2.longValue())});
        } else if (l2 == null) {
            return resources.getString(R.string.v1, new Object[]{DateStrings.c(l3.longValue())});
        } else {
            Pair<String, String> a2 = DateStrings.a(l2, l3);
            return resources.getString(R.string.x1, new Object[]{a2.f6296a, a2.f6297b});
        }
    }

    @NonNull
    public Collection<Pair<Long, Long>> h() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair(this.Z, this.X2));
        return arrayList;
    }

    @NonNull
    /* renamed from: k */
    public Pair<Long, Long> G() {
        return new Pair<>(this.Z, this.X2);
    }

    /* renamed from: o */
    public void i(@NonNull Pair<Long, Long> pair) {
        F f2 = pair.f6296a;
        if (!(f2 == null || pair.f6297b == null)) {
            Preconditions.a(l(((Long) f2).longValue(), ((Long) pair.f6297b).longValue()));
        }
        F f3 = pair.f6296a;
        Long l2 = null;
        this.Z = f3 == null ? null : Long.valueOf(UtcDates.a(((Long) f3).longValue()));
        S s2 = pair.f6297b;
        if (s2 != null) {
            l2 = Long.valueOf(UtcDates.a(((Long) s2).longValue()));
        }
        this.X2 = l2;
    }

    public View r(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle, CalendarConstraints calendarConstraints, @NonNull OnSelectionChangedListener<Pair<Long, Long>> onSelectionChangedListener) {
        View inflate = layoutInflater.inflate(R.layout.Q0, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(R.id.A3);
        TextInputLayout textInputLayout2 = (TextInputLayout) inflate.findViewById(R.id.z3);
        EditText editText = textInputLayout.getEditText();
        EditText editText2 = textInputLayout2.getEditText();
        if (ManufacturerUtils.b()) {
            editText.setInputType(17);
            editText2.setInputType(17);
        }
        this.X = inflate.getResources().getString(R.string.r1);
        SimpleDateFormat simpleDateFormat = this.a3;
        boolean z = simpleDateFormat != null;
        if (!z) {
            simpleDateFormat = UtcDates.g();
        }
        SimpleDateFormat simpleDateFormat2 = simpleDateFormat;
        Long l2 = this.Z;
        if (l2 != null) {
            editText.setText(simpleDateFormat2.format(l2));
            this.Y2 = this.Z;
        }
        Long l3 = this.X2;
        if (l3 != null) {
            editText2.setText(simpleDateFormat2.format(l3));
            this.Z2 = this.X2;
        }
        String pattern = z ? simpleDateFormat2.toPattern() : UtcDates.h(inflate.getResources(), simpleDateFormat2);
        textInputLayout.setPlaceholderText(pattern);
        textInputLayout2.setPlaceholderText(pattern);
        AnonymousClass1 r10 = r0;
        CalendarConstraints calendarConstraints2 = calendarConstraints;
        String str = pattern;
        final TextInputLayout textInputLayout3 = textInputLayout;
        SimpleDateFormat simpleDateFormat3 = simpleDateFormat2;
        final TextInputLayout textInputLayout4 = textInputLayout2;
        EditText editText3 = editText2;
        final OnSelectionChangedListener<Pair<Long, Long>> onSelectionChangedListener2 = onSelectionChangedListener;
        AnonymousClass1 r0 = new DateFormatTextWatcher(pattern, simpleDateFormat2, textInputLayout, calendarConstraints2) {
            /* access modifiers changed from: package-private */
            public void f() {
                Long unused = RangeDateSelector.this.Y2 = null;
                RangeDateSelector.this.t(textInputLayout3, textInputLayout4, onSelectionChangedListener2);
            }

            /* access modifiers changed from: package-private */
            public void g(@Nullable Long l2) {
                Long unused = RangeDateSelector.this.Y2 = l2;
                RangeDateSelector.this.t(textInputLayout3, textInputLayout4, onSelectionChangedListener2);
            }
        };
        editText.addTextChangedListener(r10);
        editText3.addTextChangedListener(new DateFormatTextWatcher(str, simpleDateFormat3, textInputLayout2, calendarConstraints2) {
            /* access modifiers changed from: package-private */
            public void f() {
                Long unused = RangeDateSelector.this.Z2 = null;
                RangeDateSelector.this.t(textInputLayout3, textInputLayout4, onSelectionChangedListener2);
            }

            /* access modifiers changed from: package-private */
            public void g(@Nullable Long l2) {
                Long unused = RangeDateSelector.this.Z2 = l2;
                RangeDateSelector.this.t(textInputLayout3, textInputLayout4, onSelectionChangedListener2);
            }
        });
        e.c(editText, editText3);
        return inflate;
    }

    public int s() {
        return R.string.y1;
    }

    @NonNull
    public String u(@NonNull Context context) {
        Resources resources = context.getResources();
        Pair<String, String> a2 = DateStrings.a(this.Z, this.X2);
        F f2 = a2.f6296a;
        String string = f2 == null ? resources.getString(R.string.g1) : (String) f2;
        S s2 = a2.f6297b;
        return resources.getString(R.string.e1, new Object[]{string, s2 == null ? resources.getString(R.string.g1) : (String) s2});
    }

    public void w(@Nullable SimpleDateFormat simpleDateFormat) {
        if (simpleDateFormat != null) {
            simpleDateFormat = (SimpleDateFormat) UtcDates.q(simpleDateFormat);
        }
        this.a3 = simpleDateFormat;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        parcel.writeValue(this.Z);
        parcel.writeValue(this.X2);
    }

    public int x(@NonNull Context context) {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return MaterialAttributes.g(context, Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) > resources.getDimensionPixelSize(R.dimen.yb) ? R.attr.Bc : R.attr.qc, MaterialDatePicker.class.getCanonicalName());
    }
}
