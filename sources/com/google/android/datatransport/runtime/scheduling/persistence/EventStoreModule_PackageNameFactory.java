package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.DaggerGenerated;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import com.google.android.datatransport.runtime.dagger.internal.QualifierMetadata;
import com.google.android.datatransport.runtime.dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class EventStoreModule_PackageNameFactory implements Factory<String> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f19649a;

    public EventStoreModule_PackageNameFactory(Provider<Context> provider) {
        this.f19649a = provider;
    }

    public static EventStoreModule_PackageNameFactory a(Provider<Context> provider) {
        return new EventStoreModule_PackageNameFactory(provider);
    }

    public static String c(Context context) {
        return (String) Preconditions.f(EventStoreModule.d(context));
    }

    /* renamed from: b */
    public String get() {
        return c(this.f19649a.get());
    }
}
