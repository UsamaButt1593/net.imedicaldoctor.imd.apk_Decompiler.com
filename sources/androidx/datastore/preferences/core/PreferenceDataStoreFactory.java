package androidx.datastore.preferences.core;

import androidx.datastore.core.DataMigration;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.DataStoreFactory;
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

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JU\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f2\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0014\b\u0002\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b0\u00072\b\b\u0002\u0010\u000b\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/datastore/preferences/core/PreferenceDataStoreFactory;", "", "<init>", "()V", "Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;", "Landroidx/datastore/preferences/core/Preferences;", "corruptionHandler", "", "Landroidx/datastore/core/DataMigration;", "migrations", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlin/Function0;", "Ljava/io/File;", "produceFile", "Landroidx/datastore/core/DataStore;", "b", "(Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;Ljava/util/List;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function0;)Landroidx/datastore/core/DataStore;", "datastore-preferences-core"}, k = 1, mv = {1, 5, 1})
public final class PreferenceDataStoreFactory {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final PreferenceDataStoreFactory f6958a = new PreferenceDataStoreFactory();

    private PreferenceDataStoreFactory() {
    }

    public static /* synthetic */ DataStore e(PreferenceDataStoreFactory preferenceDataStoreFactory, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List list, CoroutineScope coroutineScope, Function0 function0, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            replaceFileCorruptionHandler = null;
        }
        if ((i2 & 2) != 0) {
            list = CollectionsKt.E();
        }
        if ((i2 & 4) != 0) {
            Dispatchers dispatchers = Dispatchers.f29186a;
            coroutineScope = CoroutineScopeKt.a(Dispatchers.c().v(SupervisorKt.c((Job) null, 1, (Object) null)));
        }
        return preferenceDataStoreFactory.b(replaceFileCorruptionHandler, list, coroutineScope, function0);
    }

    @NotNull
    @JvmOverloads
    public final DataStore<Preferences> a(@Nullable ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, @NotNull List<? extends DataMigration<Preferences>> list, @NotNull Function0<? extends File> function0) {
        Intrinsics.p(list, "migrations");
        Intrinsics.p(function0, "produceFile");
        return e(this, replaceFileCorruptionHandler, list, (CoroutineScope) null, function0, 4, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final DataStore<Preferences> b(@Nullable ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, @NotNull List<? extends DataMigration<Preferences>> list, @NotNull CoroutineScope coroutineScope, @NotNull Function0<? extends File> function0) {
        Intrinsics.p(list, "migrations");
        Intrinsics.p(coroutineScope, "scope");
        Intrinsics.p(function0, "produceFile");
        return new PreferenceDataStore(DataStoreFactory.f6904a.b(PreferencesSerializer.f6962a, replaceFileCorruptionHandler, list, coroutineScope, new PreferenceDataStoreFactory$create$delegate$1(function0)));
    }

    @NotNull
    @JvmOverloads
    public final DataStore<Preferences> c(@Nullable ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, @NotNull Function0<? extends File> function0) {
        Intrinsics.p(function0, "produceFile");
        return e(this, replaceFileCorruptionHandler, (List) null, (CoroutineScope) null, function0, 6, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final DataStore<Preferences> d(@NotNull Function0<? extends File> function0) {
        Intrinsics.p(function0, "produceFile");
        return e(this, (ReplaceFileCorruptionHandler) null, (List) null, (CoroutineScope) null, function0, 7, (Object) null);
    }
}
