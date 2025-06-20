package androidx.datastore.core;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0000\u0018\u0000 \u0005*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0006B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Landroidx/datastore/core/DataMigrationInitializer;", "T", "", "<init>", "()V", "a", "Companion", "datastore-core"}, k = 1, mv = {1, 5, 1})
public final class DataMigrationInitializer<T> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f6903a = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J;\u0010\u000b\u001a\u00020\n\"\u0004\b\u0001\u0010\u00042\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00060\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\bH@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ[\u0010\u0011\u001a3\b\u0001\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00010\b¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r\"\u0004\b\u0001\u0010\u00042\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00060\u0005ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Landroidx/datastore/core/DataMigrationInitializer$Companion;", "", "<init>", "()V", "T", "", "Landroidx/datastore/core/DataMigration;", "migrations", "Landroidx/datastore/core/InitializerApi;", "api", "", "c", "(Ljava/util/List;Landroidx/datastore/core/InitializerApi;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Lkotlin/coroutines/Continuation;", "b", "(Ljava/util/List;)Lkotlin/jvm/functions/Function2;", "datastore-core"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0046  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x006f  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x009a  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x009d  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final <T> java.lang.Object c(java.util.List<? extends androidx.datastore.core.DataMigration<T>> r7, androidx.datastore.core.InitializerApi<T> r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
            /*
                r6 = this;
                boolean r0 = r9 instanceof androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1
                if (r0 == 0) goto L_0x0013
                r0 = r9
                androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1 r0 = (androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1) r0
                int r1 = r0.a3
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.a3 = r1
                goto L_0x0018
            L_0x0013:
                androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1 r0 = new androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1
                r0.<init>(r6, r9)
            L_0x0018:
                java.lang.Object r9 = r0.Y2
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
                int r2 = r0.a3
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L_0x0046
                if (r2 == r4) goto L_0x003e
                if (r2 != r3) goto L_0x0036
                java.lang.Object r7 = r0.X2
                java.util.Iterator r7 = (java.util.Iterator) r7
                java.lang.Object r8 = r0.Z
                kotlin.jvm.internal.Ref$ObjectRef r8 = (kotlin.jvm.internal.Ref.ObjectRef) r8
                kotlin.ResultKt.n(r9)     // Catch:{ all -> 0x0034 }
                goto L_0x0069
            L_0x0034:
                r9 = move-exception
                goto L_0x0082
            L_0x0036:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L_0x003e:
                java.lang.Object r7 = r0.Z
                java.util.List r7 = (java.util.List) r7
                kotlin.ResultKt.n(r9)
                goto L_0x0060
            L_0x0046:
                kotlin.ResultKt.n(r9)
                java.util.ArrayList r9 = new java.util.ArrayList
                r9.<init>()
                androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2 r2 = new androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2
                r5 = 0
                r2.<init>(r7, r9, r5)
                r0.Z = r9
                r0.a3 = r4
                java.lang.Object r7 = r8.a(r2, r0)
                if (r7 != r1) goto L_0x005f
                return r1
            L_0x005f:
                r7 = r9
            L_0x0060:
                kotlin.jvm.internal.Ref$ObjectRef r8 = new kotlin.jvm.internal.Ref$ObjectRef
                r8.<init>()
                java.util.Iterator r7 = r7.iterator()
            L_0x0069:
                boolean r9 = r7.hasNext()
                if (r9 == 0) goto L_0x0094
                java.lang.Object r9 = r7.next()
                kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
                r0.Z = r8     // Catch:{ all -> 0x0034 }
                r0.X2 = r7     // Catch:{ all -> 0x0034 }
                r0.a3 = r3     // Catch:{ all -> 0x0034 }
                java.lang.Object r9 = r9.f(r0)     // Catch:{ all -> 0x0034 }
                if (r9 != r1) goto L_0x0069
                return r1
            L_0x0082:
                T r2 = r8.s
                if (r2 != 0) goto L_0x0089
                r8.s = r9
                goto L_0x0069
            L_0x0089:
                kotlin.jvm.internal.Intrinsics.m(r2)
                T r2 = r8.s
                java.lang.Throwable r2 = (java.lang.Throwable) r2
                kotlin.ExceptionsKt.a(r2, r9)
                goto L_0x0069
            L_0x0094:
                T r7 = r8.s
                java.lang.Throwable r7 = (java.lang.Throwable) r7
                if (r7 != 0) goto L_0x009d
                kotlin.Unit r7 = kotlin.Unit.f28779a
                return r7
            L_0x009d:
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataMigrationInitializer.Companion.c(java.util.List, androidx.datastore.core.InitializerApi, kotlin.coroutines.Continuation):java.lang.Object");
        }

        @NotNull
        public final <T> Function2<InitializerApi<T>, Continuation<? super Unit>, Object> b(@NotNull List<? extends DataMigration<T>> list) {
            Intrinsics.p(list, "migrations");
            return new DataMigrationInitializer$Companion$getInitializer$1(list, (Continuation<? super DataMigrationInitializer$Companion$getInitializer$1>) null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
