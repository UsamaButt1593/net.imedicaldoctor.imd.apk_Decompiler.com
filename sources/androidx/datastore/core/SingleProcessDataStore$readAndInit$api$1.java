package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.sync.Mutex;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001JF\u0010\t\u001a\u00028\u000021\u0010\b\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0002H@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"androidx/datastore/core/SingleProcessDataStore$readAndInit$api$1", "Landroidx/datastore/core/InitializerApi;", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "t", "Lkotlin/coroutines/Continuation;", "", "transform", "a", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core"}, k = 1, mv = {1, 5, 1})
public final class SingleProcessDataStore$readAndInit$api$1 implements InitializerApi<T> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Mutex f6929a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Ref.BooleanRef f6930b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Ref.ObjectRef<T> f6931c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ SingleProcessDataStore<T> f6932d;

    SingleProcessDataStore$readAndInit$api$1(Mutex mutex, Ref.BooleanRef booleanRef, Ref.ObjectRef<T> objectRef, SingleProcessDataStore<T> singleProcessDataStore) {
        this.f6929a = mutex;
        this.f6930b = booleanRef;
        this.f6931c = objectRef;
        this.f6932d = singleProcessDataStore;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x009a A[Catch:{ all -> 0x00d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ba A[Catch:{ all -> 0x0056 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d0 A[Catch:{ all -> 0x003b }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00da A[SYNTHETIC, Splitter:B:49:0x00da] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1$updateData$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1$updateData$1 r0 = (androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1$updateData$1) r0
            int r1 = r0.d3
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.d3 = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1$updateData$1 r0 = new androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1$updateData$1
            r0.<init>(r10, r12)
        L_0x0018:
            java.lang.Object r12 = r0.b3
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.d3
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0076
            if (r2 == r5) goto L_0x005a
            if (r2 == r4) goto L_0x0046
            if (r2 != r3) goto L_0x003e
            java.lang.Object r11 = r0.Y2
            java.lang.Object r1 = r0.X2
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            java.lang.Object r0 = r0.Z
            kotlinx.coroutines.sync.Mutex r0 = (kotlinx.coroutines.sync.Mutex) r0
            kotlin.ResultKt.n(r12)     // Catch:{ all -> 0x003b }
            goto L_0x00cc
        L_0x003b:
            r11 = move-exception
            goto L_0x00e2
        L_0x003e:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0046:
            java.lang.Object r11 = r0.Y2
            androidx.datastore.core.SingleProcessDataStore r11 = (androidx.datastore.core.SingleProcessDataStore) r11
            java.lang.Object r2 = r0.X2
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
            java.lang.Object r4 = r0.Z
            kotlinx.coroutines.sync.Mutex r4 = (kotlinx.coroutines.sync.Mutex) r4
            kotlin.ResultKt.n(r12)     // Catch:{ all -> 0x0056 }
            goto L_0x00b2
        L_0x0056:
            r11 = move-exception
            r0 = r4
            goto L_0x00e2
        L_0x005a:
            java.lang.Object r11 = r0.a3
            androidx.datastore.core.SingleProcessDataStore r11 = (androidx.datastore.core.SingleProcessDataStore) r11
            java.lang.Object r2 = r0.Z2
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
            java.lang.Object r5 = r0.Y2
            kotlin.jvm.internal.Ref$BooleanRef r5 = (kotlin.jvm.internal.Ref.BooleanRef) r5
            java.lang.Object r7 = r0.X2
            kotlinx.coroutines.sync.Mutex r7 = (kotlinx.coroutines.sync.Mutex) r7
            java.lang.Object r8 = r0.Z
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            kotlin.ResultKt.n(r12)
            r12 = r7
            r9 = r8
            r8 = r11
            r11 = r9
            goto L_0x0096
        L_0x0076:
            kotlin.ResultKt.n(r12)
            kotlinx.coroutines.sync.Mutex r12 = r10.f6929a
            kotlin.jvm.internal.Ref$BooleanRef r2 = r10.f6930b
            kotlin.jvm.internal.Ref$ObjectRef<T> r7 = r10.f6931c
            androidx.datastore.core.SingleProcessDataStore<T> r8 = r10.f6932d
            r0.Z = r11
            r0.X2 = r12
            r0.Y2 = r2
            r0.Z2 = r7
            r0.a3 = r8
            r0.d3 = r5
            java.lang.Object r5 = r12.c(r6, r0)
            if (r5 != r1) goto L_0x0094
            return r1
        L_0x0094:
            r5 = r2
            r2 = r7
        L_0x0096:
            boolean r5 = r5.s     // Catch:{ all -> 0x00d7 }
            if (r5 != 0) goto L_0x00da
            T r5 = r2.s     // Catch:{ all -> 0x00d7 }
            r0.Z = r12     // Catch:{ all -> 0x00d7 }
            r0.X2 = r2     // Catch:{ all -> 0x00d7 }
            r0.Y2 = r8     // Catch:{ all -> 0x00d7 }
            r0.Z2 = r6     // Catch:{ all -> 0x00d7 }
            r0.a3 = r6     // Catch:{ all -> 0x00d7 }
            r0.d3 = r4     // Catch:{ all -> 0x00d7 }
            java.lang.Object r11 = r11.d0(r5, r0)     // Catch:{ all -> 0x00d7 }
            if (r11 != r1) goto L_0x00af
            return r1
        L_0x00af:
            r4 = r12
            r12 = r11
            r11 = r8
        L_0x00b2:
            T r5 = r2.s     // Catch:{ all -> 0x0056 }
            boolean r5 = kotlin.jvm.internal.Intrinsics.g(r12, r5)     // Catch:{ all -> 0x0056 }
            if (r5 != 0) goto L_0x00d0
            r0.Z = r4     // Catch:{ all -> 0x0056 }
            r0.X2 = r2     // Catch:{ all -> 0x0056 }
            r0.Y2 = r12     // Catch:{ all -> 0x0056 }
            r0.d3 = r3     // Catch:{ all -> 0x0056 }
            java.lang.Object r11 = r11.A(r12, r0)     // Catch:{ all -> 0x0056 }
            if (r11 != r1) goto L_0x00c9
            return r1
        L_0x00c9:
            r11 = r12
            r1 = r2
            r0 = r4
        L_0x00cc:
            r1.s = r11     // Catch:{ all -> 0x003b }
            r2 = r1
            goto L_0x00d1
        L_0x00d0:
            r0 = r4
        L_0x00d1:
            T r11 = r2.s     // Catch:{ all -> 0x003b }
            r0.d(r6)
            return r11
        L_0x00d7:
            r11 = move-exception
            r0 = r12
            goto L_0x00e2
        L_0x00da:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00d7 }
            java.lang.String r0 = "InitializerApi.updateData should not be called after initialization is complete."
            r11.<init>(r0)     // Catch:{ all -> 0x00d7 }
            throw r11     // Catch:{ all -> 0x00d7 }
        L_0x00e2:
            r0.d(r6)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1.a(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
