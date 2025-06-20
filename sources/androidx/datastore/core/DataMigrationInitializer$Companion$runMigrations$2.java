package androidx.datastore.core;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u0001H@"}, d2 = {"<anonymous>", "T", "startingData"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2", f = "DataMigrationInitializer.kt", i = {0, 0}, l = {44, 46}, m = "invokeSuspend", n = {"migration", "data"}, s = {"L$2", "L$3"})
final class DataMigrationInitializer$Companion$runMigrations$2 extends SuspendLambda implements Function2<T, Continuation<? super T>, Object> {
    Object X2;
    Object Y2;
    Object Z2;
    int a3;
    /* synthetic */ Object b3;
    final /* synthetic */ List<DataMigration<T>> c3;
    final /* synthetic */ List<Function1<Continuation<? super Unit>, Object>> d3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataMigrationInitializer$Companion$runMigrations$2(List<? extends DataMigration<T>> list, List<Function1<Continuation<? super Unit>, Object>> list2, Continuation<? super DataMigrationInitializer$Companion$runMigrations$2> continuation) {
        super(2, continuation);
        this.c3 = list;
        this.d3 = list2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x008a  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object D(@org.jetbrains.annotations.NotNull java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r1 = r9.a3
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0037
            if (r1 == r3) goto L_0x0022
            if (r1 != r2) goto L_0x001a
            java.lang.Object r1 = r9.X2
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r4 = r9.b3
            java.util.List r4 = (java.util.List) r4
            kotlin.ResultKt.n(r10)
            goto L_0x0044
        L_0x001a:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0022:
            java.lang.Object r1 = r9.Z2
            java.lang.Object r4 = r9.Y2
            androidx.datastore.core.DataMigration r4 = (androidx.datastore.core.DataMigration) r4
            java.lang.Object r5 = r9.X2
            java.util.Iterator r5 = (java.util.Iterator) r5
            java.lang.Object r6 = r9.b3
            java.util.List r6 = (java.util.List) r6
            kotlin.ResultKt.n(r10)
            r8 = r6
            r6 = r4
            r4 = r8
            goto L_0x0066
        L_0x0037:
            kotlin.ResultKt.n(r10)
            java.lang.Object r10 = r9.b3
            java.util.List<androidx.datastore.core.DataMigration<T>> r1 = r9.c3
            java.util.List<kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object>> r4 = r9.d3
            java.util.Iterator r1 = r1.iterator()
        L_0x0044:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x008c
            java.lang.Object r5 = r1.next()
            androidx.datastore.core.DataMigration r5 = (androidx.datastore.core.DataMigration) r5
            r9.b3 = r4
            r9.X2 = r1
            r9.Y2 = r5
            r9.Z2 = r10
            r9.a3 = r3
            java.lang.Object r6 = r5.b(r10, r9)
            if (r6 != r0) goto L_0x0061
            return r0
        L_0x0061:
            r8 = r1
            r1 = r10
            r10 = r6
            r6 = r5
            r5 = r8
        L_0x0066:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x008a
            androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2$1$1 r10 = new androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2$1$1
            r7 = 0
            r10.<init>(r6, r7)
            r4.add(r10)
            r9.b3 = r4
            r9.X2 = r5
            r9.Y2 = r7
            r9.Z2 = r7
            r9.a3 = r2
            java.lang.Object r10 = r6.c(r1, r9)
            if (r10 != r0) goto L_0x0088
            return r0
        L_0x0088:
            r1 = r5
            goto L_0x0044
        L_0x008a:
            r10 = r1
            goto L_0x0088
        L_0x008c:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2.D(java.lang.Object):java.lang.Object");
    }

    @Nullable
    /* renamed from: U */
    public final Object d0(T t, @Nullable Continuation<? super T> continuation) {
        return ((DataMigrationInitializer$Companion$runMigrations$2) v(t, continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        DataMigrationInitializer$Companion$runMigrations$2 dataMigrationInitializer$Companion$runMigrations$2 = new DataMigrationInitializer$Companion$runMigrations$2(this.c3, this.d3, continuation);
        dataMigrationInitializer$Companion$runMigrations$2.b3 = obj;
        return dataMigrationInitializer$Companion$runMigrations$2;
    }
}
