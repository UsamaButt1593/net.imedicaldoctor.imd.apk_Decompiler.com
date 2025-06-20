package androidx.core.service.quicksettings;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.PendingIntentCompat;

public class PendingIntentActivityWrapper {

    /* renamed from: a  reason: collision with root package name */
    private final Context f6145a;

    /* renamed from: b  reason: collision with root package name */
    private final int f6146b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final Intent f6147c;

    /* renamed from: d  reason: collision with root package name */
    private final int f6148d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final Bundle f6149e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private final PendingIntent f6150f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f6151g;

    public PendingIntentActivityWrapper(@NonNull Context context, int i2, @NonNull Intent intent, int i3, @Nullable Bundle bundle, boolean z) {
        this.f6145a = context;
        this.f6146b = i2;
        this.f6147c = intent;
        this.f6148d = i3;
        this.f6149e = bundle;
        this.f6151g = z;
        this.f6150f = a();
    }

    @Nullable
    private PendingIntent a() {
        Bundle bundle = this.f6149e;
        Context context = this.f6145a;
        int i2 = this.f6146b;
        Intent intent = this.f6147c;
        int i3 = this.f6148d;
        return bundle == null ? PendingIntentCompat.e(context, i2, intent, i3, this.f6151g) : PendingIntentCompat.d(context, i2, intent, i3, bundle, this.f6151g);
    }

    @NonNull
    public Context b() {
        return this.f6145a;
    }

    public int c() {
        return this.f6148d;
    }

    @NonNull
    public Intent d() {
        return this.f6147c;
    }

    @NonNull
    public Bundle e() {
        return this.f6149e;
    }

    @Nullable
    public PendingIntent f() {
        return this.f6150f;
    }

    public int g() {
        return this.f6146b;
    }

    public boolean h() {
        return this.f6151g;
    }

    public PendingIntentActivityWrapper(@NonNull Context context, int i2, @NonNull Intent intent, int i3, boolean z) {
        this(context, i2, intent, i3, (Bundle) null, z);
    }
}
