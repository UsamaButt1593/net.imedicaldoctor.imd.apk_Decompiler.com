package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.DaggerGenerated;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.QualifierMetadata;
import com.google.android.datatransport.runtime.dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class SchemaManager_Factory implements Factory<SchemaManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f19659a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<String> f19660b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<Integer> f19661c;

    public SchemaManager_Factory(Provider<Context> provider, Provider<String> provider2, Provider<Integer> provider3) {
        this.f19659a = provider;
        this.f19660b = provider2;
        this.f19661c = provider3;
    }

    public static SchemaManager_Factory a(Provider<Context> provider, Provider<String> provider2, Provider<Integer> provider3) {
        return new SchemaManager_Factory(provider, provider2, provider3);
    }

    public static SchemaManager c(Context context, String str, int i2) {
        return new SchemaManager(context, str, i2);
    }

    /* renamed from: b */
    public SchemaManager get() {
        return c(this.f19659a.get(), this.f19660b.get(), this.f19661c.get().intValue());
    }
}
