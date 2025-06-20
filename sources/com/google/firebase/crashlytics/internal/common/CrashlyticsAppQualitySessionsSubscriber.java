package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.sessions.api.SessionSubscriber;

public class CrashlyticsAppQualitySessionsSubscriber implements SessionSubscriber {

    /* renamed from: a  reason: collision with root package name */
    private final DataCollectionArbiter f23575a;

    /* renamed from: b  reason: collision with root package name */
    private final CrashlyticsAppQualitySessionsStore f23576b;

    public CrashlyticsAppQualitySessionsSubscriber(DataCollectionArbiter dataCollectionArbiter, FileStore fileStore) {
        this.f23575a = dataCollectionArbiter;
        this.f23576b = new CrashlyticsAppQualitySessionsStore(fileStore);
    }

    public boolean a() {
        return this.f23575a.d();
    }

    @NonNull
    public SessionSubscriber.Name b() {
        return SessionSubscriber.Name.CRASHLYTICS;
    }

    public void c(@NonNull SessionSubscriber.SessionDetails sessionDetails) {
        Logger f2 = Logger.f();
        f2.b("App Quality Sessions session changed: " + sessionDetails);
        this.f23576b.h(sessionDetails.d());
    }

    @Nullable
    public String d(@NonNull String str) {
        return this.f23576b.c(str);
    }

    public void e(@Nullable String str) {
        this.f23576b.i(str);
    }
}
