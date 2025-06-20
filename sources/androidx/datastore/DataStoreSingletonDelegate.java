package androidx.datastore;

import android.content.Context;
import androidx.annotation.GuardedBy;
import androidx.datastore.core.DataMigration;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.DataStoreFactory;
import androidx.datastore.core.Serializer;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0002BW\b\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t\u0012\u001e\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r0\f0\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J*\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0013\u001a\u00020\u00032\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001c\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR,\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r0\f0\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u001eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010$\u001a\u00020!8\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u001e\u0010'\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006("}, d2 = {"Landroidx/datastore/DataStoreSingletonDelegate;", "T", "Lkotlin/properties/ReadOnlyProperty;", "Landroid/content/Context;", "Landroidx/datastore/core/DataStore;", "", "fileName", "Landroidx/datastore/core/Serializer;", "serializer", "Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;", "corruptionHandler", "Lkotlin/Function1;", "", "Landroidx/datastore/core/DataMigration;", "produceMigrations", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Ljava/lang/String;Landroidx/datastore/core/Serializer;Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;Lkotlin/jvm/functions/Function1;Lkotlinx/coroutines/CoroutineScope;)V", "thisRef", "Lkotlin/reflect/KProperty;", "property", "d", "(Landroid/content/Context;Lkotlin/reflect/KProperty;)Landroidx/datastore/core/DataStore;", "a", "Ljava/lang/String;", "b", "Landroidx/datastore/core/Serializer;", "c", "Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;", "Lkotlin/jvm/functions/Function1;", "e", "Lkotlinx/coroutines/CoroutineScope;", "", "f", "Ljava/lang/Object;", "lock", "g", "Landroidx/datastore/core/DataStore;", "INSTANCE", "datastore_release"}, k = 1, mv = {1, 5, 1})
public final class DataStoreSingletonDelegate<T> implements ReadOnlyProperty<Context, DataStore<T>> {
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final String f6894a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Serializer<T> f6895b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final ReplaceFileCorruptionHandler<T> f6896c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final Function1<Context, List<DataMigration<T>>> f6897d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final CoroutineScope f6898e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final Object f6899f = new Object();
    @Nullable
    @GuardedBy("lock")

    /* renamed from: g  reason: collision with root package name */
    private volatile DataStore<T> f6900g;

    public DataStoreSingletonDelegate(@NotNull String str, @NotNull Serializer<T> serializer, @Nullable ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, @NotNull Function1<? super Context, ? extends List<? extends DataMigration<T>>> function1, @NotNull CoroutineScope coroutineScope) {
        Intrinsics.p(str, "fileName");
        Intrinsics.p(serializer, "serializer");
        Intrinsics.p(function1, "produceMigrations");
        Intrinsics.p(coroutineScope, "scope");
        this.f6894a = str;
        this.f6895b = serializer;
        this.f6896c = replaceFileCorruptionHandler;
        this.f6897d = function1;
        this.f6898e = coroutineScope;
    }

    @NotNull
    /* renamed from: d */
    public DataStore<T> a(@NotNull Context context, @NotNull KProperty<?> kProperty) {
        DataStore<T> dataStore;
        Intrinsics.p(context, "thisRef");
        Intrinsics.p(kProperty, "property");
        DataStore<T> dataStore2 = this.f6900g;
        if (dataStore2 != null) {
            return dataStore2;
        }
        synchronized (this.f6899f) {
            try {
                if (this.f6900g == null) {
                    Context applicationContext = context.getApplicationContext();
                    Serializer<T> serializer = this.f6895b;
                    ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler = this.f6896c;
                    Function1<Context, List<DataMigration<T>>> function1 = this.f6897d;
                    Intrinsics.o(applicationContext, "applicationContext");
                    CoroutineScope coroutineScope = this.f6898e;
                    this.f6900g = DataStoreFactory.f6904a.b(serializer, replaceFileCorruptionHandler, function1.f(applicationContext), coroutineScope, new DataStoreSingletonDelegate$getValue$1$1(applicationContext, this));
                }
                dataStore = this.f6900g;
                Intrinsics.m(dataStore);
            } catch (Throwable th) {
                throw th;
            }
        }
        return dataStore;
    }
}
