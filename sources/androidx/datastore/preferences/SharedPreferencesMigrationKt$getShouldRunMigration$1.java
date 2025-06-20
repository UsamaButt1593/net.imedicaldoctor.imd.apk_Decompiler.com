package androidx.datastore.preferences;

import androidx.datastore.preferences.core.Preferences;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H@"}, d2 = {"<anonymous>", "", "prefs", "Landroidx/datastore/preferences/core/Preferences;"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "androidx.datastore.preferences.SharedPreferencesMigrationKt$getShouldRunMigration$1", f = "SharedPreferencesMigration.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SharedPreferencesMigrationKt$getShouldRunMigration$1 extends SuspendLambda implements Function2<Preferences, Continuation<? super Boolean>, Object> {
    int X2;
    /* synthetic */ Object Y2;
    final /* synthetic */ Set<String> Z2;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SharedPreferencesMigrationKt$getShouldRunMigration$1(Set<String> set, Continuation<? super SharedPreferencesMigrationKt$getShouldRunMigration$1> continuation) {
        super(2, continuation);
        this.Z2 = set;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        IntrinsicsKt.l();
        if (this.X2 == 0) {
            ResultKt.n(obj);
            Set<Preferences.Key<?>> keySet = ((Preferences) this.Y2).a().keySet();
            ArrayList arrayList = new ArrayList(CollectionsKt.Y(keySet, 10));
            for (Preferences.Key a2 : keySet) {
                arrayList.add(a2.a());
            }
            boolean z = true;
            if (this.Z2 != SharedPreferencesMigrationKt.g()) {
                Set<String> set = this.Z2;
                if (!(set instanceof Collection) || !set.isEmpty()) {
                    Iterator<T> it2 = set.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (Boxing.a(!arrayList.contains((String) it2.next())).booleanValue()) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                z = false;
            }
            return Boxing.a(z);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* renamed from: U */
    public final Object d0(@NotNull Preferences preferences, @Nullable Continuation<? super Boolean> continuation) {
        return ((SharedPreferencesMigrationKt$getShouldRunMigration$1) v(preferences, continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SharedPreferencesMigrationKt$getShouldRunMigration$1 sharedPreferencesMigrationKt$getShouldRunMigration$1 = new SharedPreferencesMigrationKt$getShouldRunMigration$1(this.Z2, continuation);
        sharedPreferencesMigrationKt$getShouldRunMigration$1.Y2 = obj;
        return sharedPreferencesMigrationKt$getShouldRunMigration$1;
    }
}
