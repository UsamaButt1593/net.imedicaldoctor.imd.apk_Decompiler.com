package com.google.firebase.ktx;

import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Qualified;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

@SourceDebugExtension({"SMAP\nFirebase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Firebase.kt\ncom/google/firebase/ktx/FirebaseKt$coroutineDispatcher$1\n*L\n1#1,158:1\n*E\n"})
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00050\u0005\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"", "T", "Lcom/google/firebase/components/ComponentContainer;", "kotlin.jvm.PlatformType", "c", "Lkotlinx/coroutines/CoroutineDispatcher;", "b", "(Lcom/google/firebase/components/ComponentContainer;)Lkotlinx/coroutines/CoroutineDispatcher;", "com/google/firebase/ktx/FirebaseKt$coroutineDispatcher$1"}, k = 3, mv = {1, 8, 0})
public final class FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$3<T> implements ComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$3<T> f24620a = new FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$3<>();

    /* renamed from: b */
    public final CoroutineDispatcher a(ComponentContainer componentContainer) {
        Object h2 = componentContainer.h(Qualified.a(Blocking.class, Executor.class));
        Intrinsics.o(h2, "c.get(Qualified.qualifie…a, Executor::class.java))");
        return ExecutorsKt.c((Executor) h2);
    }
}
