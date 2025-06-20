package androidx.datastore;

import android.content.Context;
import androidx.datastore.core.DataMigration;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.Serializer;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ay\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f0\u000e\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00052 \b\u0002\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\t0\u00072\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"T", "", "fileName", "Landroidx/datastore/core/Serializer;", "serializer", "Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;", "corruptionHandler", "Lkotlin/Function1;", "Landroid/content/Context;", "", "Landroidx/datastore/core/DataMigration;", "produceMigrations", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlin/properties/ReadOnlyProperty;", "Landroidx/datastore/core/DataStore;", "a", "(Ljava/lang/String;Landroidx/datastore/core/Serializer;Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;Lkotlin/jvm/functions/Function1;Lkotlinx/coroutines/CoroutineScope;)Lkotlin/properties/ReadOnlyProperty;", "datastore_release"}, k = 2, mv = {1, 5, 1})
public final class DataStoreDelegateKt {
    @NotNull
    public static final <T> ReadOnlyProperty<Context, DataStore<T>> a(@NotNull String str, @NotNull Serializer<T> serializer, @Nullable ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, @NotNull Function1<? super Context, ? extends List<? extends DataMigration<T>>> function1, @NotNull CoroutineScope coroutineScope) {
        Intrinsics.p(str, "fileName");
        Intrinsics.p(serializer, "serializer");
        Intrinsics.p(function1, "produceMigrations");
        Intrinsics.p(coroutineScope, "scope");
        return new DataStoreSingletonDelegate(str, serializer, replaceFileCorruptionHandler, function1, coroutineScope);
    }

    public static /* synthetic */ ReadOnlyProperty b(String str, Serializer serializer, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, Function1 function1, CoroutineScope coroutineScope, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            replaceFileCorruptionHandler = null;
        }
        if ((i2 & 8) != 0) {
            function1 = DataStoreDelegateKt$dataStore$1.X;
        }
        if ((i2 & 16) != 0) {
            Dispatchers dispatchers = Dispatchers.f29186a;
            coroutineScope = CoroutineScopeKt.a(Dispatchers.c().v(SupervisorKt.c((Job) null, 1, (Object) null)));
        }
        return a(str, serializer, replaceFileCorruptionHandler, function1, coroutineScope);
    }
}
