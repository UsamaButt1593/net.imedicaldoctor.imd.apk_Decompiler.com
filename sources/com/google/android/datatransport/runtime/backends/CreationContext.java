package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class CreationContext {

    /* renamed from: a  reason: collision with root package name */
    private static final String f19471a = "cct";

    public static CreationContext a(Context context, Clock clock, Clock clock2) {
        return new AutoValue_CreationContext(context, clock, clock2, f19471a);
    }

    public static CreationContext b(Context context, Clock clock, Clock clock2, String str) {
        return new AutoValue_CreationContext(context, clock, clock2, str);
    }

    public abstract Context c();

    @NonNull
    public abstract String d();

    public abstract Clock e();

    public abstract Clock f();
}
