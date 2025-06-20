package androidx.datastore.preferences.core;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H@"}, d2 = {"<anonymous>", "Landroidx/datastore/preferences/core/Preferences;", "it"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "androidx.datastore.preferences.core.PreferencesKt$edit$2", f = "Preferences.kt", i = {}, l = {329}, m = "invokeSuspend", n = {}, s = {})
final class PreferencesKt$edit$2 extends SuspendLambda implements Function2<Preferences, Continuation<? super Preferences>, Object> {
    int X2;
    /* synthetic */ Object Y2;
    final /* synthetic */ Function2<MutablePreferences, Continuation<? super Unit>, Object> Z2;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PreferencesKt$edit$2(Function2<? super MutablePreferences, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super PreferencesKt$edit$2> continuation) {
        super(2, continuation);
        this.Z2 = function2;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        Object l2 = IntrinsicsKt.l();
        int i2 = this.X2;
        if (i2 == 0) {
            ResultKt.n(obj);
            MutablePreferences d2 = ((Preferences) this.Y2).d();
            Function2<MutablePreferences, Continuation<? super Unit>, Object> function2 = this.Z2;
            this.Y2 = d2;
            this.X2 = 1;
            return function2.d0(d2, this) == l2 ? l2 : d2;
        } else if (i2 == 1) {
            MutablePreferences mutablePreferences = (MutablePreferences) this.Y2;
            ResultKt.n(obj);
            return mutablePreferences;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Nullable
    /* renamed from: U */
    public final Object d0(@NotNull Preferences preferences, @Nullable Continuation<? super Preferences> continuation) {
        return ((PreferencesKt$edit$2) v(preferences, continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        PreferencesKt$edit$2 preferencesKt$edit$2 = new PreferencesKt$edit$2(this.Z2, continuation);
        preferencesKt$edit$2.Y2 = obj;
        return preferencesKt$edit$2;
    }
}
