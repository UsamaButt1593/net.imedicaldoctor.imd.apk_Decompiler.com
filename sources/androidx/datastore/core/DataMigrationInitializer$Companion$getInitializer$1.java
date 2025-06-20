package androidx.datastore.core;

import androidx.datastore.core.DataMigrationInitializer;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H@"}, d2 = {"<anonymous>", "", "T", "api", "Landroidx/datastore/core/InitializerApi;"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.DataMigrationInitializer$Companion$getInitializer$1", f = "DataMigrationInitializer.kt", i = {}, l = {33}, m = "invokeSuspend", n = {}, s = {})
final class DataMigrationInitializer$Companion$getInitializer$1 extends SuspendLambda implements Function2<InitializerApi<T>, Continuation<? super Unit>, Object> {
    int X2;
    /* synthetic */ Object Y2;
    final /* synthetic */ List<DataMigration<T>> Z2;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataMigrationInitializer$Companion$getInitializer$1(List<? extends DataMigration<T>> list, Continuation<? super DataMigrationInitializer$Companion$getInitializer$1> continuation) {
        super(2, continuation);
        this.Z2 = list;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        Object l2 = IntrinsicsKt.l();
        int i2 = this.X2;
        if (i2 == 0) {
            ResultKt.n(obj);
            DataMigrationInitializer.Companion companion = DataMigrationInitializer.f6903a;
            List<DataMigration<T>> list = this.Z2;
            this.X2 = 1;
            if (companion.c(list, (InitializerApi) this.Y2, this) == l2) {
                return l2;
            }
        } else if (i2 == 1) {
            ResultKt.n(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f28779a;
    }

    @Nullable
    /* renamed from: U */
    public final Object d0(@NotNull InitializerApi<T> initializerApi, @Nullable Continuation<? super Unit> continuation) {
        return ((DataMigrationInitializer$Companion$getInitializer$1) v(initializerApi, continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        DataMigrationInitializer$Companion$getInitializer$1 dataMigrationInitializer$Companion$getInitializer$1 = new DataMigrationInitializer$Companion$getInitializer$1(this.Z2, continuation);
        dataMigrationInitializer$Companion$getInitializer$1.Y2 = obj;
        return dataMigrationInitializer$Companion$getInitializer$1;
    }
}
