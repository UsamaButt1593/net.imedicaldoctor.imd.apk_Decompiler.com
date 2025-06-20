package com.google.android.material.datepicker;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import kotlin.text.Typography;
import org.apache.commons.lang3.StringUtils;

abstract class DateFormatTextWatcher extends TextWatcherAdapter {
    private final String X;
    private final String X2;
    private final DateFormat Y;
    private final Runnable Y2;
    private final CalendarConstraints Z;
    private Runnable Z2;
    private int a3 = 0;
    @NonNull
    private final TextInputLayout s;

    DateFormatTextWatcher(String str, DateFormat dateFormat, @NonNull TextInputLayout textInputLayout, CalendarConstraints calendarConstraints) {
        this.X = str;
        this.Y = dateFormat;
        this.s = textInputLayout;
        this.Z = calendarConstraints;
        this.X2 = textInputLayout.getContext().getString(R.string.u1);
        this.Y2 = new a(this, str);
    }

    private Runnable c(long j2) {
        return new b(this, j2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(long j2) {
        String c2 = DateStrings.c(j2);
        this.s.setError(String.format(this.X2, new Object[]{i(c2)}));
        f();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(String str) {
        TextInputLayout textInputLayout = this.s;
        DateFormat dateFormat = this.Y;
        Context context = textInputLayout.getContext();
        String string = context.getString(R.string.o1);
        String format = String.format(context.getString(R.string.q1), new Object[]{i(str)});
        String format2 = String.format(context.getString(R.string.p1), new Object[]{i(dateFormat.format(new Date(UtcDates.v().getTimeInMillis())))});
        textInputLayout.setError(string + StringUtils.LF + format + StringUtils.LF + format2);
        f();
    }

    private String i(String str) {
        return str.replace(' ', Typography.f29120g);
    }

    public void afterTextChanged(@NonNull Editable editable) {
        if (!Locale.getDefault().getLanguage().equals(Locale.KOREAN.getLanguage()) && editable.length() != 0 && editable.length() < this.X.length() && editable.length() >= this.a3) {
            char charAt = this.X.charAt(editable.length());
            if (!Character.isLetterOrDigit(charAt)) {
                editable.append(charAt);
            }
        }
    }

    public void beforeTextChanged(@NonNull CharSequence charSequence, int i2, int i3, int i4) {
        this.a3 = charSequence.length();
    }

    /* access modifiers changed from: package-private */
    public void f() {
    }

    /* access modifiers changed from: package-private */
    public abstract void g(@Nullable Long l2);

    public void h(View view, Runnable runnable) {
        view.post(runnable);
    }

    public void onTextChanged(@NonNull CharSequence charSequence, int i2, int i3, int i4) {
        this.s.removeCallbacks(this.Y2);
        this.s.removeCallbacks(this.Z2);
        this.s.setError((CharSequence) null);
        g((Long) null);
        if (!TextUtils.isEmpty(charSequence) && charSequence.length() >= this.X.length()) {
            try {
                Date parse = this.Y.parse(charSequence.toString());
                this.s.setError((CharSequence) null);
                long time = parse.getTime();
                if (!this.Z.k().y(time) || !this.Z.D(time)) {
                    Runnable c2 = c(time);
                    this.Z2 = c2;
                    h(this.s, c2);
                    return;
                }
                g(Long.valueOf(parse.getTime()));
            } catch (ParseException unused) {
                h(this.s, this.Y2);
            }
        }
    }
}
