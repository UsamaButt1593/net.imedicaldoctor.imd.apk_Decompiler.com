package com.google.firebase.installations;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.installations.local.PersistedInstallationEntry;

class GetAuthTokenListener implements StateListener {

    /* renamed from: a  reason: collision with root package name */
    private final Utils f24429a;

    /* renamed from: b  reason: collision with root package name */
    private final TaskCompletionSource<InstallationTokenResult> f24430b;

    public GetAuthTokenListener(Utils utils, TaskCompletionSource<InstallationTokenResult> taskCompletionSource) {
        this.f24429a = utils;
        this.f24430b = taskCompletionSource;
    }

    public boolean a(Exception exc) {
        this.f24430b.d(exc);
        return true;
    }

    public boolean b(PersistedInstallationEntry persistedInstallationEntry) {
        if (!persistedInstallationEntry.k() || this.f24429a.f(persistedInstallationEntry)) {
            return false;
        }
        this.f24430b.c(InstallationTokenResult.a().b(persistedInstallationEntry.b()).d(persistedInstallationEntry.c()).c(persistedInstallationEntry.h()).a());
        return true;
    }
}
