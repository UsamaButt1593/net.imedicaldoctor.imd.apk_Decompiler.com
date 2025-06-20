package androidx.datastore.preferences;

import android.content.Context;
import androidx.annotation.GuardedBy;
import androidx.datastore.core.DataMigration;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.preferences.core.PreferenceDataStoreFactory;
import androidx.datastore.preferences.core.Preferences;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001BI\b\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007\u0012\u001e\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000b0\n0\t\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J*\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0011\u001a\u00020\u00022\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R,\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000b0\n0\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u001cR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Landroidx/datastore/preferences/PreferenceDataStoreSingletonDelegate;", "Lkotlin/properties/ReadOnlyProperty;", "Landroid/content/Context;", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "", "name", "Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;", "corruptionHandler", "Lkotlin/Function1;", "", "Landroidx/datastore/core/DataMigration;", "produceMigrations", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Ljava/lang/String;Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;Lkotlin/jvm/functions/Function1;Lkotlinx/coroutines/CoroutineScope;)V", "thisRef", "Lkotlin/reflect/KProperty;", "property", "d", "(Landroid/content/Context;Lkotlin/reflect/KProperty;)Landroidx/datastore/core/DataStore;", "a", "Ljava/lang/String;", "b", "Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;", "c", "Lkotlin/jvm/functions/Function1;", "Lkotlinx/coroutines/CoroutineScope;", "", "e", "Ljava/lang/Object;", "lock", "f", "Landroidx/datastore/core/DataStore;", "INSTANCE", "datastore-preferences_release"}, k = 1, mv = {1, 5, 1})
public final class PreferenceDataStoreSingletonDelegate implements ReadOnlyProperty<Context, DataStore<Preferences>> {
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final String f6945a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final ReplaceFileCorruptionHandler<Preferences> f6946b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Function1<Context, List<DataMigration<Preferences>>> f6947c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final CoroutineScope f6948d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final Object f6949e = new Object();
    @Nullable
    @GuardedBy("lock")

    /* renamed from: f  reason: collision with root package name */
    private volatile DataStore<Preferences> f6950f;

    public PreferenceDataStoreSingletonDelegate(@NotNull String str, @Nullable ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, @NotNull Function1<? super Context, ? extends List<? extends DataMigration<Preferences>>> function1, @NotNull CoroutineScope coroutineScope) {
        Intrinsics.p(str, "name");
        Intrinsics.p(function1, "produceMigrations");
        Intrinsics.p(coroutineScope, "scope");
        this.f6945a = str;
        this.f6946b = replaceFileCorruptionHandler;
        this.f6947c = function1;
        this.f6948d = coroutineScope;
    }

    @NotNull
    /* renamed from: d */
    public DataStore<Preferences> a(@NotNull Context context, @NotNull KProperty<?> kProperty) {
        DataStore<Preferences> dataStore;
        Intrinsics.p(context, "thisRef");
        Intrinsics.p(kProperty, "property");
        DataStore<Preferences> dataStore2 = this.f6950f;
        if (dataStore2 != null) {
            return dataStore2;
        }
        synchronized (this.f6949e) {
            try {
                if (this.f6950f == null) {
                    Context applicationContext = context.getApplicationContext();
                    PreferenceDataStoreFactory preferenceDataStoreFactory = PreferenceDataStoreFactory.f6958a;
                    ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler = this.f6946b;
                    Function1<Context, List<DataMigration<Preferences>>> function1 = this.f6947c;
                    Intrinsics.o(applicationContext, "applicationContext");
                    this.f6950f = preferenceDataStoreFactory.b(replaceFileCorruptionHandler, function1.f(applicationContext), this.f6948d, new PreferenceDataStoreSingletonDelegate$getValue$1$1(applicationContext, this));
                }
                dataStore = this.f6950f;
                Intrinsics.m(dataStore);
            } catch (Throwable th) {
                throw th;
            }
        }
        return dataStore;
    }
}
