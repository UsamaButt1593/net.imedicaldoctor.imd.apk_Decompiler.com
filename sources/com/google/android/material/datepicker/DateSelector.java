package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.core.util.Pair;
import java.text.SimpleDateFormat;
import java.util.Collection;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface DateSelector<S> extends Parcelable {
    boolean A();

    @NonNull
    Collection<Long> F();

    @Nullable
    S G();

    void L(long j2);

    @Nullable
    String e();

    @NonNull
    String f(Context context);

    @NonNull
    Collection<Pair<Long, Long>> h();

    void i(@NonNull S s);

    @NonNull
    View r(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle, @NonNull CalendarConstraints calendarConstraints, @NonNull OnSelectionChangedListener<S> onSelectionChangedListener);

    @StringRes
    int s();

    @NonNull
    String u(@NonNull Context context);

    void w(@Nullable SimpleDateFormat simpleDateFormat);

    @StyleRes
    int x(Context context);
}
