package com.google.firebase.sessions.settings;

import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/google/firebase/sessions/settings/SettingsCache;", "b", "()Lcom/google/firebase/sessions/settings/SettingsCache;"}, k = 3, mv = {1, 8, 0})
final class RemoteSettings$settingsCache$2 extends Lambda implements Function0<SettingsCache> {
    final /* synthetic */ DataStore<Preferences> X;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RemoteSettings$settingsCache$2(DataStore<Preferences> dataStore) {
        super(0);
        this.X = dataStore;
    }

    @NotNull
    /* renamed from: b */
    public final SettingsCache o() {
        return new SettingsCache(this.X);
    }
}
