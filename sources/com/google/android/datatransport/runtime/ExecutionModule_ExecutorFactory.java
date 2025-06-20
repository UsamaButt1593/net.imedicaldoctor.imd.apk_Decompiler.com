package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.dagger.internal.DaggerGenerated;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import com.google.android.datatransport.runtime.dagger.internal.QualifierMetadata;
import com.google.android.datatransport.runtime.dagger.internal.ScopeMetadata;
import java.util.concurrent.Executor;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
public final class ExecutionModule_ExecutorFactory implements Factory<Executor> {

    private static final class InstanceHolder {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final ExecutionModule_ExecutorFactory f19440a = new ExecutionModule_ExecutorFactory();

        private InstanceHolder() {
        }
    }

    public static ExecutionModule_ExecutorFactory a() {
        return InstanceHolder.f19440a;
    }

    public static Executor b() {
        return (Executor) Preconditions.f(ExecutionModule.a());
    }

    /* renamed from: c */
    public Executor get() {
        return b();
    }
}
