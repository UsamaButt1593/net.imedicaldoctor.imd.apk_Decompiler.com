package com.google.firebase.sessions.settings;

import androidx.datastore.preferences.core.Preferences;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.google.firebase.sessions.settings.SettingsCache", f = "SettingsCache.kt", i = {}, l = {119}, m = "updateConfigValue", n = {}, s = {})
final class SettingsCache$updateConfigValue$1<T> extends ContinuationImpl {
    final /* synthetic */ SettingsCache X2;
    int Y2;
    /* synthetic */ Object Z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SettingsCache$updateConfigValue$1(SettingsCache settingsCache, Continuation<? super SettingsCache$updateConfigValue$1> continuation) {
        super(continuation);
        this.X2 = settingsCache;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        this.Z = obj;
        this.Y2 |= Integer.MIN_VALUE;
        return this.X2.n((Preferences.Key) null, null, this);
    }
}
