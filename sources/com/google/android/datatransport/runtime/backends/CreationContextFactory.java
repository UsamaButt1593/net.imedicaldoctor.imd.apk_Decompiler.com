package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.time.Monotonic;
import com.google.android.datatransport.runtime.time.WallTime;
import javax.inject.Inject;

class CreationContextFactory {

    /* renamed from: a  reason: collision with root package name */
    private final Context f19472a;

    /* renamed from: b  reason: collision with root package name */
    private final Clock f19473b;

    /* renamed from: c  reason: collision with root package name */
    private final Clock f19474c;

    @Inject
    CreationContextFactory(Context context, @WallTime Clock clock, @Monotonic Clock clock2) {
        this.f19472a = context;
        this.f19473b = clock;
        this.f19474c = clock2;
    }

    /* access modifiers changed from: package-private */
    public CreationContext a(String str) {
        return CreationContext.b(this.f19472a, this.f19473b, this.f19474c, str);
    }
}
