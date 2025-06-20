package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.DaggerGenerated;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.QualifierMetadata;
import com.google.android.datatransport.runtime.dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
public final class MetadataBackendRegistry_Factory implements Factory<MetadataBackendRegistry> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f19485a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<CreationContextFactory> f19486b;

    public MetadataBackendRegistry_Factory(Provider<Context> provider, Provider<CreationContextFactory> provider2) {
        this.f19485a = provider;
        this.f19486b = provider2;
    }

    public static MetadataBackendRegistry_Factory a(Provider<Context> provider, Provider<CreationContextFactory> provider2) {
        return new MetadataBackendRegistry_Factory(provider, provider2);
    }

    public static MetadataBackendRegistry c(Context context, Object obj) {
        return new MetadataBackendRegistry(context, (CreationContextFactory) obj);
    }

    /* renamed from: b */
    public MetadataBackendRegistry get() {
        return c(this.f19485a.get(), this.f19486b.get());
    }
}
