package androidx.datastore.preferences;

import android.content.Context;
import androidx.datastore.core.DataMigration;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.preferences.core.Preferences;
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

@Metadata(d1 = {"\u00004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ae\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\r0\f2\u0006\u0010\u0001\u001a\u00020\u00002\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022 \b\u0002\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b0\u00070\u00052\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"", "name", "Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;", "Landroidx/datastore/preferences/core/Preferences;", "corruptionHandler", "Lkotlin/Function1;", "Landroid/content/Context;", "", "Landroidx/datastore/core/DataMigration;", "produceMigrations", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlin/properties/ReadOnlyProperty;", "Landroidx/datastore/core/DataStore;", "a", "(Ljava/lang/String;Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;Lkotlin/jvm/functions/Function1;Lkotlinx/coroutines/CoroutineScope;)Lkotlin/properties/ReadOnlyProperty;", "datastore-preferences_release"}, k = 2, mv = {1, 5, 1})
public final class PreferenceDataStoreDelegateKt {
    @NotNull
    public static final ReadOnlyProperty<Context, DataStore<Preferences>> a(@NotNull String str, @Nullable ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, @NotNull Function1<? super Context, ? extends List<? extends DataMigration<Preferences>>> function1, @NotNull CoroutineScope coroutineScope) {
        Intrinsics.p(str, "name");
        Intrinsics.p(function1, "produceMigrations");
        Intrinsics.p(coroutineScope, "scope");
        return new PreferenceDataStoreSingletonDelegate(str, replaceFileCorruptionHandler, function1, coroutineScope);
    }

    public static /* synthetic */ ReadOnlyProperty b(String str, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, Function1 function1, CoroutineScope coroutineScope, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            replaceFileCorruptionHandler = null;
        }
        if ((i2 & 4) != 0) {
            function1 = PreferenceDataStoreDelegateKt$preferencesDataStore$1.X;
        }
        if ((i2 & 8) != 0) {
            Dispatchers dispatchers = Dispatchers.f29186a;
            coroutineScope = CoroutineScopeKt.a(Dispatchers.c().v(SupervisorKt.c((Job) null, 1, (Object) null)));
        }
        return a(str, replaceFileCorruptionHandler, function1, coroutineScope);
    }
}
