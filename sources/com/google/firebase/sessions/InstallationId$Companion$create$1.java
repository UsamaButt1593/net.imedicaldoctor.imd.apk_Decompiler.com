package com.google.firebase.sessions;

import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.InstallationId;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.google.firebase.sessions.InstallationId$Companion", f = "InstallationId.kt", i = {0, 1}, l = {32, 40}, m = "create", n = {"firebaseInstallations", "authToken"}, s = {"L$0", "L$0"})
final class InstallationId$Companion$create$1 extends ContinuationImpl {
    /* synthetic */ Object X2;
    final /* synthetic */ InstallationId.Companion Y2;
    Object Z;
    int Z2;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InstallationId$Companion$create$1(InstallationId.Companion companion, Continuation<? super InstallationId$Companion$create$1> continuation) {
        super(continuation);
        this.Y2 = companion;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        this.X2 = obj;
        this.Z2 |= Integer.MIN_VALUE;
        return this.Y2.a((FirebaseInstallationsApi) null, this);
    }
}
