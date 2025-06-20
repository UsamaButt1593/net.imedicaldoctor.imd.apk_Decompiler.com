package com.google.firebase.installations;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.installations.local.PersistedInstallationEntry;

class GetIdListener implements StateListener {

    /* renamed from: a  reason: collision with root package name */
    final TaskCompletionSource<String> f24431a;

    public GetIdListener(TaskCompletionSource<String> taskCompletionSource) {
        this.f24431a = taskCompletionSource;
    }

    public boolean a(Exception exc) {
        return false;
    }

    public boolean b(PersistedInstallationEntry persistedInstallationEntry) {
        if (!persistedInstallationEntry.l() && !persistedInstallationEntry.k() && !persistedInstallationEntry.i()) {
            return false;
        }
        this.f24431a.e(persistedInstallationEntry.d());
        return true;
    }
}
