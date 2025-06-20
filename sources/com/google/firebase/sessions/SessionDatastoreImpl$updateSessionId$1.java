package com.google.firebase.sessions;

import android.util.Log;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.PreferencesKt;
import com.google.firebase.sessions.SessionDatastoreImpl;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.google.firebase.sessions.SessionDatastoreImpl$updateSessionId$1", f = "SessionDatastore.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
final class SessionDatastoreImpl$updateSessionId$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int X2;
    final /* synthetic */ SessionDatastoreImpl Y2;
    final /* synthetic */ String Z2;

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H@"}, d2 = {"<anonymous>", "", "preferences", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.sessions.SessionDatastoreImpl$updateSessionId$1$1", f = "SessionDatastore.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.google.firebase.sessions.SessionDatastoreImpl$updateSessionId$1$1  reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
        int X2;
        /* synthetic */ Object Y2;

        @Nullable
        public final Object D(@NotNull Object obj) {
            IntrinsicsKt.l();
            if (this.X2 == 0) {
                ResultKt.n(obj);
                ((MutablePreferences) this.Y2).o(SessionDatastoreImpl.FirebaseSessionDataKeys.f25089a.a(), str);
                return Unit.f28779a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Nullable
        /* renamed from: U */
        public final Object d0(@NotNull MutablePreferences mutablePreferences, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) v(mutablePreferences, continuation)).D(Unit.f28779a);
        }

        @NotNull
        public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(str, continuation);
            r0.Y2 = obj;
            return r0;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SessionDatastoreImpl$updateSessionId$1(SessionDatastoreImpl sessionDatastoreImpl, String str, Continuation<? super SessionDatastoreImpl$updateSessionId$1> continuation) {
        super(2, continuation);
        this.Y2 = sessionDatastoreImpl;
        this.Z2 = str;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        Object l2 = IntrinsicsKt.l();
        int i2 = this.X2;
        if (i2 == 0) {
            ResultKt.n(obj);
            DataStore a2 = SessionDatastoreImpl.f25081f.b(this.Y2.f25084b);
            final String str = this.Z2;
            AnonymousClass1 r1 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.X2 = 1;
            if (PreferencesKt.a(a2, r1, this) == l2) {
                return l2;
            }
        } else if (i2 == 1) {
            try {
                ResultKt.n(obj);
            } catch (IOException e2) {
                Log.w("FirebaseSessionsRepo", "Failed to update session Id: " + e2);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f28779a;
    }

    @Nullable
    /* renamed from: U */
    public final Object d0(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SessionDatastoreImpl$updateSessionId$1) v(coroutineScope, continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SessionDatastoreImpl$updateSessionId$1(this.Y2, this.Z2, continuation);
    }
}
