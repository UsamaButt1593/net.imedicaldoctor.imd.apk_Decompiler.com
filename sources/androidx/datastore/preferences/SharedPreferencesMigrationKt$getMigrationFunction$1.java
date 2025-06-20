package androidx.datastore.preferences;

import androidx.datastore.migrations.SharedPreferencesView;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H@"}, d2 = {"<anonymous>", "Landroidx/datastore/preferences/core/Preferences;", "sharedPrefs", "Landroidx/datastore/migrations/SharedPreferencesView;", "currentData"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "androidx.datastore.preferences.SharedPreferencesMigrationKt$getMigrationFunction$1", f = "SharedPreferencesMigration.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SharedPreferencesMigrationKt$getMigrationFunction$1 extends SuspendLambda implements Function3<SharedPreferencesView, Preferences, Continuation<? super Preferences>, Object> {
    int X2;
    /* synthetic */ Object Y2;
    /* synthetic */ Object Z2;

    SharedPreferencesMigrationKt$getMigrationFunction$1(Continuation<? super SharedPreferencesMigrationKt$getMigrationFunction$1> continuation) {
        super(3, continuation);
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        Preferences.Key g2;
        IntrinsicsKt.l();
        if (this.X2 == 0) {
            ResultKt.n(obj);
            SharedPreferencesView sharedPreferencesView = (SharedPreferencesView) this.Y2;
            Preferences preferences = (Preferences) this.Z2;
            Set<Preferences.Key<?>> keySet = preferences.a().keySet();
            ArrayList arrayList = new ArrayList(CollectionsKt.Y(keySet, 10));
            for (Preferences.Key a2 : keySet) {
                arrayList.add(a2.a());
            }
            Map<String, Object> c2 = sharedPreferencesView.c();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry next : c2.entrySet()) {
                if (Boxing.a(!arrayList.contains((String) next.getKey())).booleanValue()) {
                    linkedHashMap.put(next.getKey(), next.getValue());
                }
            }
            MutablePreferences d2 = preferences.d();
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                if (value instanceof Boolean) {
                    g2 = PreferencesKeys.a(str);
                } else if (value instanceof Float) {
                    g2 = PreferencesKeys.c(str);
                } else if (value instanceof Integer) {
                    g2 = PreferencesKeys.d(str);
                } else if (value instanceof Long) {
                    g2 = PreferencesKeys.e(str);
                } else if (value instanceof String) {
                    g2 = PreferencesKeys.f(str);
                } else if (value instanceof Set) {
                    g2 = PreferencesKeys.g(str);
                    if (value != null) {
                        value = (Set) value;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
                    }
                } else {
                    continue;
                }
                d2.o(g2, value);
            }
            return d2.e();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* renamed from: U */
    public final Object A(@NotNull SharedPreferencesView sharedPreferencesView, @NotNull Preferences preferences, @Nullable Continuation<? super Preferences> continuation) {
        SharedPreferencesMigrationKt$getMigrationFunction$1 sharedPreferencesMigrationKt$getMigrationFunction$1 = new SharedPreferencesMigrationKt$getMigrationFunction$1(continuation);
        sharedPreferencesMigrationKt$getMigrationFunction$1.Y2 = sharedPreferencesView;
        sharedPreferencesMigrationKt$getMigrationFunction$1.Z2 = preferences;
        return sharedPreferencesMigrationKt$getMigrationFunction$1.D(Unit.f28779a);
    }
}
