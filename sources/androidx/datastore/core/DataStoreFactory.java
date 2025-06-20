package androidx.datastore.core;

import androidx.datastore.core.handlers.NoOpCorruptionHandler;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Ji\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011\"\u0004\b\u0000\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00072\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\t2\b\b\u0002\u0010\r\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0007¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/datastore/core/DataStoreFactory;", "", "<init>", "()V", "T", "Landroidx/datastore/core/Serializer;", "serializer", "Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;", "corruptionHandler", "", "Landroidx/datastore/core/DataMigration;", "migrations", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlin/Function0;", "Ljava/io/File;", "produceFile", "Landroidx/datastore/core/DataStore;", "b", "(Landroidx/datastore/core/Serializer;Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;Ljava/util/List;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function0;)Landroidx/datastore/core/DataStore;", "datastore-core"}, k = 1, mv = {1, 5, 1})
public final class DataStoreFactory {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final DataStoreFactory f6904a = new DataStoreFactory();

    private DataStoreFactory() {
    }

    public static /* synthetic */ DataStore e(DataStoreFactory dataStoreFactory, Serializer serializer, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List list, CoroutineScope coroutineScope, Function0 function0, int i2, Object obj) {
        ReplaceFileCorruptionHandler replaceFileCorruptionHandler2 = (i2 & 2) != 0 ? null : replaceFileCorruptionHandler;
        if ((i2 & 4) != 0) {
            list = CollectionsKt.E();
        }
        List list2 = list;
        if ((i2 & 8) != 0) {
            Dispatchers dispatchers = Dispatchers.f29186a;
            coroutineScope = CoroutineScopeKt.a(Dispatchers.c().v(SupervisorKt.c((Job) null, 1, (Object) null)));
        }
        return dataStoreFactory.b(serializer, replaceFileCorruptionHandler2, list2, coroutineScope, function0);
    }

    @NotNull
    @JvmOverloads
    public final <T> DataStore<T> a(@NotNull Serializer<T> serializer, @Nullable ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, @NotNull List<? extends DataMigration<T>> list, @NotNull Function0<? extends File> function0) {
        Intrinsics.p(serializer, "serializer");
        Intrinsics.p(list, "migrations");
        Intrinsics.p(function0, "produceFile");
        return e(this, serializer, replaceFileCorruptionHandler, list, (CoroutineScope) null, function0, 8, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final <T> DataStore<T> b(@NotNull Serializer<T> serializer, @Nullable ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, @NotNull List<? extends DataMigration<T>> list, @NotNull CoroutineScope coroutineScope, @NotNull Function0<? extends File> function0) {
        Intrinsics.p(serializer, "serializer");
        Intrinsics.p(list, "migrations");
        Intrinsics.p(coroutineScope, "scope");
        Intrinsics.p(function0, "produceFile");
        CorruptionHandler corruptionHandler = replaceFileCorruptionHandler;
        if (replaceFileCorruptionHandler == null) {
            corruptionHandler = new NoOpCorruptionHandler();
        }
        return new SingleProcessDataStore(function0, serializer, CollectionsKt.k(DataMigrationInitializer.f6903a.b(list)), corruptionHandler, coroutineScope);
    }

    @NotNull
    @JvmOverloads
    public final <T> DataStore<T> c(@NotNull Serializer<T> serializer, @Nullable ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, @NotNull Function0<? extends File> function0) {
        Intrinsics.p(serializer, "serializer");
        Intrinsics.p(function0, "produceFile");
        return e(this, serializer, replaceFileCorruptionHandler, (List) null, (CoroutineScope) null, function0, 12, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final <T> DataStore<T> d(@NotNull Serializer<T> serializer, @NotNull Function0<? extends File> function0) {
        Intrinsics.p(serializer, "serializer");
        Intrinsics.p(function0, "produceFile");
        return e(this, serializer, (ReplaceFileCorruptionHandler) null, (List) null, (CoroutineScope) null, function0, 14, (Object) null);
    }
}
