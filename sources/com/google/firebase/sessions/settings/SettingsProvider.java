package com.google.firebase.sessions.settings;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.time.Duration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\u0013\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001f\u0010\u000e\u001a\u0004\u0018\u00010\u000b8&X¦\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0013"}, d2 = {"Lcom/google/firebase/sessions/settings/SettingsProvider;", "", "", "e", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "c", "()Z", "a", "()Ljava/lang/Boolean;", "sessionEnabled", "Lkotlin/time/Duration;", "b", "()Lkotlin/time/Duration;", "sessionRestartTimeout", "", "d", "()Ljava/lang/Double;", "samplingRate", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0})
public interface SettingsProvider {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean a(@NotNull SettingsProvider settingsProvider) {
            return false;
        }

        @Nullable
        public static Object b(@NotNull SettingsProvider settingsProvider, @NotNull Continuation<? super Unit> continuation) {
            return Unit.f28779a;
        }
    }

    @Nullable
    Boolean a();

    @Nullable
    Duration b();

    boolean c();

    @Nullable
    Double d();

    @Nullable
    Object e(@NotNull Continuation<? super Unit> continuation);
}
