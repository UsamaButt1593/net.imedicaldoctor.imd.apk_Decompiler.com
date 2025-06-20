package androidx.datastore.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.datastore.migrations.SharedPreferencesMigration;
import androidx.datastore.migrations.SharedPreferencesView;
import androidx.datastore.preferences.core.Preferences;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u001a3\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0007¢\u0006\u0004\b\b\u0010\t\u001a5\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0007¢\u0006\u0004\b\r\u0010\u000e\u001a4\u0010\u0013\u001a$\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000fH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a<\u0010\u0017\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00152\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\" \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0000X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lkotlin/Function0;", "Landroid/content/SharedPreferences;", "produceSharedPreferences", "", "", "keysToMigrate", "Landroidx/datastore/migrations/SharedPreferencesMigration;", "Landroidx/datastore/preferences/core/Preferences;", "d", "(Lkotlin/jvm/functions/Function0;Ljava/util/Set;)Landroidx/datastore/migrations/SharedPreferencesMigration;", "Landroid/content/Context;", "context", "sharedPreferencesName", "b", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/Set;)Landroidx/datastore/migrations/SharedPreferencesMigration;", "Lkotlin/Function3;", "Landroidx/datastore/migrations/SharedPreferencesView;", "Lkotlin/coroutines/Continuation;", "", "h", "()Lkotlin/jvm/functions/Function3;", "Lkotlin/Function2;", "", "i", "(Ljava/util/Set;)Lkotlin/jvm/functions/Function2;", "a", "Ljava/util/Set;", "g", "()Ljava/util/Set;", "MIGRATE_ALL_KEYS", "datastore-preferences_release"}, k = 2, mv = {1, 5, 1})
public final class SharedPreferencesMigrationKt {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private static final Set<String> f6954a = new LinkedHashSet();

    @NotNull
    @JvmOverloads
    public static final SharedPreferencesMigration<Preferences> a(@NotNull Context context, @NotNull String str) {
        Intrinsics.p(context, "context");
        Intrinsics.p(str, "sharedPreferencesName");
        return e(context, str, (Set) null, 4, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public static final SharedPreferencesMigration<Preferences> b(@NotNull Context context, @NotNull String str, @NotNull Set<String> set) {
        Intrinsics.p(context, "context");
        Intrinsics.p(str, "sharedPreferencesName");
        Intrinsics.p(set, "keysToMigrate");
        if (set == f6954a) {
            return new SharedPreferencesMigration(context, str, (Set) null, i(set), h(), 4, (DefaultConstructorMarker) null);
        }
        return new SharedPreferencesMigration<>(context, str, set, i(set), h());
    }

    @NotNull
    @JvmOverloads
    public static final SharedPreferencesMigration<Preferences> c(@NotNull Function0<? extends SharedPreferences> function0) {
        Intrinsics.p(function0, "produceSharedPreferences");
        return f(function0, (Set) null, 2, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public static final SharedPreferencesMigration<Preferences> d(@NotNull Function0<? extends SharedPreferences> function0, @NotNull Set<String> set) {
        Intrinsics.p(function0, "produceSharedPreferences");
        Intrinsics.p(set, "keysToMigrate");
        if (set != f6954a) {
            return new SharedPreferencesMigration<>(function0, set, i(set), h());
        }
        return new SharedPreferencesMigration((Function0) function0, (Set) null, (Function2) i(set), (Function3) h(), 2, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ SharedPreferencesMigration e(Context context, String str, Set<String> set, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            set = f6954a;
        }
        return b(context, str, set);
    }

    public static /* synthetic */ SharedPreferencesMigration f(Function0 function0, Set<String> set, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            set = f6954a;
        }
        return d(function0, set);
    }

    @NotNull
    public static final Set<String> g() {
        return f6954a;
    }

    private static final Function3<SharedPreferencesView, Preferences, Continuation<? super Preferences>, Object> h() {
        return new SharedPreferencesMigrationKt$getMigrationFunction$1((Continuation<? super SharedPreferencesMigrationKt$getMigrationFunction$1>) null);
    }

    private static final Function2<Preferences, Continuation<? super Boolean>, Object> i(Set<String> set) {
        return new SharedPreferencesMigrationKt$getShouldRunMigration$1(set, (Continuation<? super SharedPreferencesMigrationKt$getShouldRunMigration$1>) null);
    }
}
