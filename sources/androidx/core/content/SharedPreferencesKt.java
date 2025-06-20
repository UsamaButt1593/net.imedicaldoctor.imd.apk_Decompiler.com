package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a7\u0010\b\u001a\u00020\u0005*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\b¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroid/content/SharedPreferences;", "", "commit", "Lkotlin/Function1;", "Landroid/content/SharedPreferences$Editor;", "", "Lkotlin/ExtensionFunctionType;", "action", "a", "(Landroid/content/SharedPreferences;ZLkotlin/jvm/functions/Function1;)V", "core-ktx_release"}, k = 2, mv = {1, 8, 0})
public final class SharedPreferencesKt {
    @SuppressLint({"ApplySharedPref"})
    public static final void a(@NotNull SharedPreferences sharedPreferences, boolean z, @NotNull Function1<? super SharedPreferences.Editor, Unit> function1) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        function1.f(edit);
        if (z) {
            edit.commit();
        } else {
            edit.apply();
        }
    }

    public static /* synthetic */ void b(SharedPreferences sharedPreferences, boolean z, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        function1.f(edit);
        if (z) {
            edit.commit();
        } else {
            edit.apply();
        }
    }
}
