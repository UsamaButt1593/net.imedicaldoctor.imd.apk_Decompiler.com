package com.google.firebase.installations;

import com.google.firebase.installations.local.PersistedInstallationEntry;

interface StateListener {
    boolean a(Exception exc);

    boolean b(PersistedInstallationEntry persistedInstallationEntry);
}
