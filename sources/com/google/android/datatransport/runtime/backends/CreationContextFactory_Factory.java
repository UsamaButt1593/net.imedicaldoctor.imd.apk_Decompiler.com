package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.DaggerGenerated;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.QualifierMetadata;
import com.google.android.datatransport.runtime.dagger.internal.ScopeMetadata;
import com.google.android.datatransport.runtime.time.Clock;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.google.android.datatransport.runtime.time.WallTime", "com.google.android.datatransport.runtime.time.Monotonic"})
public final class CreationContextFactory_Factory implements Factory<CreationContextFactory> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f19475a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Clock> f19476b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<Clock> f19477c;

    public CreationContextFactory_Factory(Provider<Context> provider, Provider<Clock> provider2, Provider<Clock> provider3) {
        this.f19475a = provider;
        this.f19476b = provider2;
        this.f19477c = provider3;
    }

    public static CreationContextFactory_Factory a(Provider<Context> provider, Provider<Clock> provider2, Provider<Clock> provider3) {
        return new CreationContextFactory_Factory(provider, provider2, provider3);
    }

    public static CreationContextFactory c(Context context, Clock clock, Clock clock2) {
        return new CreationContextFactory(context, clock, clock2);
    }

    /* renamed from: b */
    public CreationContextFactory get() {
        return c(this.f19475a.get(), this.f19476b.get(), this.f19477c.get());
    }
}
