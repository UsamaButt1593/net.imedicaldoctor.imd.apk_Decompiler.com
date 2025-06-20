package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
import com.google.android.material.R;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.textfield.TextInputLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SingleDateSelector implements DateSelector<Long> {
    public static final Parcelable.Creator<SingleDateSelector> CREATOR = new Parcelable.Creator<SingleDateSelector>() {
        @NonNull
        /* renamed from: a */
        public SingleDateSelector createFromParcel(@NonNull Parcel parcel) {
            SingleDateSelector singleDateSelector = new SingleDateSelector();
            Long unused = singleDateSelector.X = (Long) parcel.readValue(Long.class.getClassLoader());
            return singleDateSelector;
        }

        @NonNull
        /* renamed from: b */
        public SingleDateSelector[] newArray(int i2) {
            return new SingleDateSelector[i2];
        }
    };
    /* access modifiers changed from: private */
    @Nullable
    public Long X;
    @Nullable
    private SimpleDateFormat Y;
    /* access modifiers changed from: private */
    @Nullable
    public CharSequence s;

    /* access modifiers changed from: private */
    public void d() {
        this.X = null;
    }

    public boolean A() {
        return this.X != null;
    }

    @NonNull
    public Collection<Long> F() {
        ArrayList arrayList = new ArrayList();
        Long l2 = this.X;
        if (l2 != null) {
            arrayList.add(l2);
        }
        return arrayList;
    }

    public void L(long j2) {
        this.X = Long.valueOf(j2);
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
        Long l2 = this.X;
        if (l2 == null) {
            return resources.getString(R.string.l1);
        }
        String m2 = DateStrings.m(l2.longValue());
        return resources.getString(R.string.j1, new Object[]{m2});
    }

    @Nullable
    /* renamed from: g */
    public Long G() {
        return this.X;
    }

    @NonNull
    public Collection<Pair<Long, Long>> h() {
        return new ArrayList();
    }

    /* renamed from: j */
    public void i(@Nullable Long l2) {
        this.X = l2 == null ? null : Long.valueOf(UtcDates.a(l2.longValue()));
    }

    public View r(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle, CalendarConstraints calendarConstraints, @NonNull OnSelectionChangedListener<Long> onSelectionChangedListener) {
        View inflate = layoutInflater.inflate(R.layout.P0, viewGroup, false);
        final TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(R.id.y3);
        EditText editText = textInputLayout.getEditText();
        if (ManufacturerUtils.b()) {
            editText.setInputType(17);
        }
        SimpleDateFormat simpleDateFormat = this.Y;
        boolean z = simpleDateFormat != null;
        if (!z) {
            simpleDateFormat = UtcDates.g();
        }
        SimpleDateFormat simpleDateFormat2 = simpleDateFormat;
        String pattern = z ? simpleDateFormat2.toPattern() : UtcDates.h(inflate.getResources(), simpleDateFormat2);
        textInputLayout.setPlaceholderText(pattern);
        Long l2 = this.X;
        if (l2 != null) {
            editText.setText(simpleDateFormat2.format(l2));
        }
        final OnSelectionChangedListener<Long> onSelectionChangedListener2 = onSelectionChangedListener;
        editText.addTextChangedListener(new DateFormatTextWatcher(pattern, simpleDateFormat2, textInputLayout, calendarConstraints) {
            /* access modifiers changed from: package-private */
            public void f() {
                CharSequence unused = SingleDateSelector.this.s = textInputLayout.getError();
                onSelectionChangedListener2.a();
            }

            /* access modifiers changed from: package-private */
            public void g(@Nullable Long l2) {
                if (l2 == null) {
                    SingleDateSelector.this.d();
                } else {
                    SingleDateSelector.this.L(l2.longValue());
                }
                CharSequence unused = SingleDateSelector.this.s = null;
                onSelectionChangedListener2.b(SingleDateSelector.this.G());
            }
        });
        e.c(editText);
        return inflate;
    }

    public int s() {
        return R.string.k1;
    }

    @NonNull
    public String u(@NonNull Context context) {
        Resources resources = context.getResources();
        Long l2 = this.X;
        return resources.getString(R.string.f1, new Object[]{l2 == null ? resources.getString(R.string.g1) : DateStrings.m(l2.longValue())});
    }

    public void w(@Nullable SimpleDateFormat simpleDateFormat) {
        if (simpleDateFormat != null) {
            simpleDateFormat = (SimpleDateFormat) UtcDates.q(simpleDateFormat);
        }
        this.Y = simpleDateFormat;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        parcel.writeValue(this.X);
    }

    public int x(Context context) {
        return MaterialAttributes.g(context, R.attr.Bc, MaterialDatePicker.class.getCanonicalName());
    }
}
