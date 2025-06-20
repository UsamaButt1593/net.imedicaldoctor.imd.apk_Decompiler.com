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
@DebugMetadata(c = "androidx.datastore.preferences.core.PreferenceDataStore$updateData$2", f = "PreferenceDataStoreFactory.kt", i = {}, l = {85}, m = "invokeSuspend", n = {}, s = {})
final class PreferenceDataStore$updateData$2 extends SuspendLambda implements Function2<Preferences, Continuation<? super Preferences>, Object> {
    int X2;
    /* synthetic */ Object Y2;
    final /* synthetic */ Function2<Preferences, Continuation<? super Preferences>, Object> Z2;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PreferenceDataStore$updateData$2(Function2<? super Preferences, ? super Continuation<? super Preferences>, ? extends Object> function2, Continuation<? super PreferenceDataStore$updateData$2> continuation) {
        super(2, continuation);
        this.Z2 = function2;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        Object l2 = IntrinsicsKt.l();
        int i2 = this.X2;
        if (i2 == 0) {
            ResultKt.n(obj);
            Function2<Preferences, Continuation<? super Preferences>, Object> function2 = this.Z2;
            this.X2 = 1;
            obj = function2.d0((Preferences) this.Y2, this);
            if (obj == l2) {
                return l2;
            }
        } else if (i2 == 1) {
            ResultKt.n(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Preferences preferences = (Preferences) obj;
        ((MutablePreferences) preferences).h();
        return preferences;
    }

    @Nullable
    /* renamed from: U */
    public final Object d0(@NotNull Preferences preferences, @Nullable Continuation<? super Preferences> continuation) {
        return ((PreferenceDataStore$updateData$2) v(preferences, continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        PreferenceDataStore$updateData$2 preferenceDataStore$updateData$2 = new PreferenceDataStore$updateData$2(this.Z2, continuation);
        preferenceDataStore$updateData$2.Y2 = obj;
        return preferenceDataStore$updateData$2;
    }
}
