package com.google.firebase.sessions.settings;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.google.firebase.sessions.settings.SessionsSettings", f = "SessionsSettings.kt", i = {0}, l = {138, 139}, m = "updateSettings", n = {"this"}, s = {"L$0"})
final class SessionsSettings$updateSettings$1 extends ContinuationImpl {
    /* synthetic */ Object X2;
    final /* synthetic */ SessionsSettings Y2;
    Object Z;
    int Z2;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SessionsSettings$updateSettings$1(SessionsSettings sessionsSettings, Continuation<? super SessionsSettings$updateSettings$1> continuation) {
        super(continuation);
        this.Y2 = sessionsSettings;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        this.X2 = obj;
        this.Z2 |= Integer.MIN_VALUE;
        return this.Y2.g(this);
    }
}
