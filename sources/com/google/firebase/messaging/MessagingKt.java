package com.google.firebase.messaging;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.Firebase;
import com.google.firebase.messaging.RemoteMessage;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a6\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0002\b\u0005H\bø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\"\u0015\u0010\u000e\u001a\u00020\u000b*\u00020\n8F¢\u0006\u0006\u001a\u0004\b\f\u0010\r\u0002\u0007\n\u0005\b20\u0001¨\u0006\u000f"}, d2 = {"", "to", "Lkotlin/Function1;", "Lcom/google/firebase/messaging/RemoteMessage$Builder;", "", "Lkotlin/ExtensionFunctionType;", "init", "Lcom/google/firebase/messaging/RemoteMessage;", "b", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Lcom/google/firebase/messaging/RemoteMessage;", "Lcom/google/firebase/Firebase;", "Lcom/google/firebase/messaging/FirebaseMessaging;", "a", "(Lcom/google/firebase/Firebase;)Lcom/google/firebase/messaging/FirebaseMessaging;", "messaging", "com.google.firebase-firebase-messaging"}, k = 2, mv = {1, 8, 0})
public final class MessagingKt {
    @NotNull
    public static final FirebaseMessaging a(@NotNull Firebase firebase) {
        Intrinsics.p(firebase, "<this>");
        FirebaseMessaging y = FirebaseMessaging.y();
        Intrinsics.o(y, "getInstance()");
        return y;
    }

    @NotNull
    public static final RemoteMessage b(@NotNull String str, @NotNull Function1<? super RemoteMessage.Builder, Unit> function1) {
        Intrinsics.p(str, TypedValues.TransitionType.f4027d);
        Intrinsics.p(function1, "init");
        RemoteMessage.Builder builder = new RemoteMessage.Builder(str);
        function1.f(builder);
        RemoteMessage b2 = builder.b();
        Intrinsics.o(b2, "builder.build()");
        return b2;
    }
}
