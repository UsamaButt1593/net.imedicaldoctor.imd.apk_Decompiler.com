package com.google.firebase;

import androidx.annotation.Keep;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.annotations.concurrent.Lightweight;
import com.google.firebase.annotations.concurrent.UiThread;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nFirebase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Firebase.kt\ncom/google/firebase/FirebaseCommonKtxRegistrar\n+ 2 Firebase.kt\ncom/google/firebase/FirebaseKt\n*L\n1#1,82:1\n76#2,6:83\n76#2,6:89\n76#2,6:95\n76#2,6:101\n*S KotlinDebug\n*F\n+ 1 Firebase.kt\ncom/google/firebase/FirebaseCommonKtxRegistrar\n*L\n67#1:83,6\n68#1:89,6\n69#1:95,6\n70#1:101,6\n*E\n"})
@Keep
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/google/firebase/FirebaseCommonKtxRegistrar;", "Lcom/google/firebase/components/ComponentRegistrar;", "()V", "getComponents", "", "Lcom/google/firebase/components/Component;", "com.google.firebase-firebase-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FirebaseCommonKtxRegistrar implements ComponentRegistrar {
    @NotNull
    public List<Component<?>> getComponents() {
        Class<Background> cls = Background.class;
        Class<CoroutineDispatcher> cls2 = CoroutineDispatcher.class;
        Class<Executor> cls3 = Executor.class;
        Component<CoroutineDispatcher> d2 = Component.f(Qualified.a(cls, cls2)).b(Dependency.l(Qualified.a(cls, cls3))).f(FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$1.f23292a).d();
        Intrinsics.o(d2, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        Class<Lightweight> cls4 = Lightweight.class;
        Component<Lightweight> d3 = Component.f(Qualified.a(cls4, cls2)).b(Dependency.l(Qualified.a(cls4, cls3))).f(FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$2.f23293a).d();
        Intrinsics.o(d3, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        Class<Blocking> cls5 = Blocking.class;
        Component<Blocking> d4 = Component.f(Qualified.a(cls5, cls2)).b(Dependency.l(Qualified.a(cls5, cls3))).f(FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$3.f23294a).d();
        Intrinsics.o(d4, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        Class<UiThread> cls6 = UiThread.class;
        Component<UiThread> d5 = Component.f(Qualified.a(cls6, cls2)).b(Dependency.l(Qualified.a(cls6, cls3))).f(FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$4.f23295a).d();
        Intrinsics.o(d5, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        return CollectionsKt.L(d2, d3, d4, d5);
    }
}
