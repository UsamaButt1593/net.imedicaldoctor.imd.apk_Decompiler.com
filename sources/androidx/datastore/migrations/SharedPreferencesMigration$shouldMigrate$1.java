package androidx.datastore.migrations;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "androidx.datastore.migrations.SharedPreferencesMigration", f = "SharedPreferencesMigration.kt", i = {0}, l = {147}, m = "shouldMigrate", n = {"this"}, s = {"L$0"})
final class SharedPreferencesMigration$shouldMigrate$1 extends ContinuationImpl {
    /* synthetic */ Object X2;
    final /* synthetic */ SharedPreferencesMigration<T> Y2;
    Object Z;
    int Z2;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SharedPreferencesMigration$shouldMigrate$1(SharedPreferencesMigration<T> sharedPreferencesMigration, Continuation<? super SharedPreferencesMigration$shouldMigrate$1> continuation) {
        super(continuation);
        this.Y2 = sharedPreferencesMigration;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        this.X2 = obj;
        this.Z2 |= Integer.MIN_VALUE;
        return this.Y2.b(null, this);
    }
}
