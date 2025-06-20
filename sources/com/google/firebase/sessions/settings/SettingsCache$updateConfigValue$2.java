package com.google.firebase.sessions.settings;

import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H@"}, d2 = {"<anonymous>", "", "T", "preferences", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$2", f = "SettingsCache.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SettingsCache$updateConfigValue$2 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
    int X2;
    /* synthetic */ Object Y2;
    final /* synthetic */ T Z2;
    final /* synthetic */ Preferences.Key<T> a3;
    final /* synthetic */ SettingsCache b3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SettingsCache$updateConfigValue$2(T t, Preferences.Key<T> key, SettingsCache settingsCache, Continuation<? super SettingsCache$updateConfigValue$2> continuation) {
        super(2, continuation);
        this.Z2 = t;
        this.a3 = key;
        this.b3 = settingsCache;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        IntrinsicsKt.l();
        if (this.X2 == 0) {
            ResultKt.n(obj);
            MutablePreferences mutablePreferences = (MutablePreferences) this.Y2;
            T t = this.Z2;
            if (t != null) {
                mutablePreferences.o(this.a3, t);
            } else {
                mutablePreferences.n(this.a3);
            }
            this.b3.r(mutablePreferences);
            return Unit.f28779a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* renamed from: U */
    public final Object d0(@NotNull MutablePreferences mutablePreferences, @Nullable Continuation<? super Unit> continuation) {
        return ((SettingsCache$updateConfigValue$2) v(mutablePreferences, continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SettingsCache$updateConfigValue$2 settingsCache$updateConfigValue$2 = new SettingsCache$updateConfigValue$2(this.Z2, this.a3, this.b3, continuation);
        settingsCache$updateConfigValue$2.Y2 = obj;
        return settingsCache$updateConfigValue$2;
    }
}
