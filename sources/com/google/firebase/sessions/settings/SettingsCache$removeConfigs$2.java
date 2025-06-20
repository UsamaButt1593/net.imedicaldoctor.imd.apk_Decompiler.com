package com.google.firebase.sessions.settings;

import androidx.datastore.preferences.core.MutablePreferences;
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

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H@"}, d2 = {"<anonymous>", "", "preferences", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.google.firebase.sessions.settings.SettingsCache$removeConfigs$2", f = "SettingsCache.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SettingsCache$removeConfigs$2 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
    int X2;
    /* synthetic */ Object Y2;
    final /* synthetic */ SettingsCache Z2;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SettingsCache$removeConfigs$2(SettingsCache settingsCache, Continuation<? super SettingsCache$removeConfigs$2> continuation) {
        super(2, continuation);
        this.Z2 = settingsCache;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        IntrinsicsKt.l();
        if (this.X2 == 0) {
            ResultKt.n(obj);
            MutablePreferences mutablePreferences = (MutablePreferences) this.Y2;
            mutablePreferences.g();
            this.Z2.r(mutablePreferences);
            return Unit.f28779a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* renamed from: U */
    public final Object d0(@NotNull MutablePreferences mutablePreferences, @Nullable Continuation<? super Unit> continuation) {
        return ((SettingsCache$removeConfigs$2) v(mutablePreferences, continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SettingsCache$removeConfigs$2 settingsCache$removeConfigs$2 = new SettingsCache$removeConfigs$2(this.Z2, continuation);
        settingsCache$removeConfigs$2.Y2 = obj;
        return settingsCache$removeConfigs$2;
    }
}
