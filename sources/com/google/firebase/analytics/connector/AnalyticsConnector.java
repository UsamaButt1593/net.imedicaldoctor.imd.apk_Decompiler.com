package com.google.firebase.analytics.connector;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.annotations.DeferredApi;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface AnalyticsConnector {

    @KeepForSdk
    public interface AnalyticsConnectorHandle {
        @KeepForSdk
        void a();

        @KeepForSdk
        void b();

        @KeepForSdk
        void c(@NonNull Set<String> set);
    }

    @KeepForSdk
    public interface AnalyticsConnectorListener {
        @KeepForSdk
        void a(int i2, @Nullable Bundle bundle);
    }

    @KeepForSdk
    public static class ConditionalUserProperty {
        @NonNull
        @KeepForSdk

        /* renamed from: a  reason: collision with root package name */
        public String f23345a;
        @NonNull
        @KeepForSdk

        /* renamed from: b  reason: collision with root package name */
        public String f23346b;
        @KeepForSdk
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        public Object f23347c;
        @KeepForSdk
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public String f23348d;
        @KeepForSdk

        /* renamed from: e  reason: collision with root package name */
        public long f23349e;
        @KeepForSdk
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        public String f23350f;
        @KeepForSdk
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        public Bundle f23351g;
        @KeepForSdk
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        public String f23352h;
        @KeepForSdk
        @Nullable

        /* renamed from: i  reason: collision with root package name */
        public Bundle f23353i;
        @KeepForSdk

        /* renamed from: j  reason: collision with root package name */
        public long f23354j;
        @KeepForSdk
        @Nullable

        /* renamed from: k  reason: collision with root package name */
        public String f23355k;
        @KeepForSdk
        @Nullable

        /* renamed from: l  reason: collision with root package name */
        public Bundle f23356l;
        @KeepForSdk

        /* renamed from: m  reason: collision with root package name */
        public long f23357m;
        @KeepForSdk

        /* renamed from: n  reason: collision with root package name */
        public boolean f23358n;
        @KeepForSdk
        public long o;
    }

    @WorkerThread
    @NonNull
    @KeepForSdk
    Map<String, Object> a(boolean z);

    @KeepForSdk
    void b(@NonNull ConditionalUserProperty conditionalUserProperty);

    @KeepForSdk
    void c(@NonNull String str, @NonNull String str2, @Nullable Bundle bundle);

    @WorkerThread
    @KeepForSdk
    int d(@Size(min = 1) @NonNull String str);

    @KeepForSdk
    void e(@Size(max = 24, min = 1) @NonNull String str, @Nullable String str2, @Nullable Bundle bundle);

    @WorkerThread
    @NonNull
    @KeepForSdk
    List<ConditionalUserProperty> f(@NonNull String str, @Size(max = 23, min = 1) @Nullable String str2);

    @KeepForSdk
    void g(@NonNull String str, @NonNull String str2, @NonNull Object obj);

    @KeepForSdk
    @DeferredApi
    @Nullable
    AnalyticsConnectorHandle h(@NonNull String str, @NonNull AnalyticsConnectorListener analyticsConnectorListener);
}
