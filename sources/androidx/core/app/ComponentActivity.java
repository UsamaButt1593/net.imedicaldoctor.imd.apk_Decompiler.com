package androidx.core.app;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.RestrictTo;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.KeyEventDispatcher;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u00011B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0017¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0011H\u0015¢\u0006\u0004\b\u0016\u0010\u0014J)\u0010\u001a\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0017*\u00020\f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001cH\u0017¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b \u0010\u001fJ\u0017\u0010!\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b!\u0010\u001fJ\u001f\u0010\"\u001a\u00020\t2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0004¢\u0006\u0004\b\"\u0010\u000bR.\u0010'\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u0018\u0012\u0004\u0012\u00020\f0#8\u0002X\u0004¢\u0006\f\n\u0004\b$\u0010%\u0012\u0004\b&\u0010\u0005R\u001a\u0010,\u001a\u00020(8\u0002X\u0004¢\u0006\f\n\u0004\b)\u0010*\u0012\u0004\b+\u0010\u0005R\u0014\u00100\u001a\u00020-8VX\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u00062"}, d2 = {"Landroidx/core/app/ComponentActivity;", "Landroid/app/Activity;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/core/view/KeyEventDispatcher$Component;", "<init>", "()V", "", "", "args", "", "R", "([Ljava/lang/String;)Z", "Landroidx/core/app/ComponentActivity$ExtraData;", "extraData", "", "P", "(Landroidx/core/app/ComponentActivity$ExtraData;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "T", "Ljava/lang/Class;", "extraDataClass", "M", "(Ljava/lang/Class;)Landroidx/core/app/ComponentActivity$ExtraData;", "Landroid/view/KeyEvent;", "event", "B", "(Landroid/view/KeyEvent;)Z", "dispatchKeyShortcutEvent", "dispatchKeyEvent", "Q", "Landroidx/collection/SimpleArrayMap;", "s", "Landroidx/collection/SimpleArrayMap;", "N", "extraDataMap", "Landroidx/lifecycle/LifecycleRegistry;", "X", "Landroidx/lifecycle/LifecycleRegistry;", "O", "lifecycleRegistry", "Landroidx/lifecycle/Lifecycle;", "a", "()Landroidx/lifecycle/Lifecycle;", "lifecycle", "ExtraData", "core_release"}, k = 1, mv = {1, 8, 0})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ComponentActivity extends Activity implements LifecycleOwner, KeyEventDispatcher.Component {
    @NotNull
    private final LifecycleRegistry X = new LifecycleRegistry(this);
    @NotNull
    private final SimpleArrayMap<Class<? extends ExtraData>, ExtraData> s = new SimpleArrayMap<>();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Landroidx/core/app/ComponentActivity$ExtraData;", "", "()V", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Deprecated(message = "Store the object you want to save directly by using\n      {@link View#setTag(int, Object)} with the window's decor view.")
    public static class ExtraData {
    }

    private static /* synthetic */ void N() {
    }

    private static /* synthetic */ void O() {
    }

    private final boolean R(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        String str = strArr[0];
        switch (str.hashCode()) {
            case -645125871:
                return str.equals("--translation") && Build.VERSION.SDK_INT >= 31;
            case 100470631:
                if (!str.equals("--dump-dumpable")) {
                    return false;
                }
                break;
            case 472614934:
                if (!str.equals("--list-dumpables")) {
                    return false;
                }
                break;
            case 1159329357:
                return str.equals("--contentcapture") && Build.VERSION.SDK_INT >= 29;
            case 1455016274:
                return str.equals("--autofill") && Build.VERSION.SDK_INT >= 26;
            default:
                return false;
        }
        return Build.VERSION.SDK_INT >= 33;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean B(@NotNull KeyEvent keyEvent) {
        Intrinsics.p(keyEvent, NotificationCompat.I0);
        return super.dispatchKeyEvent(keyEvent);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated(message = "Use {@link View#getTag(int)} with the window's decor view.")
    public <T extends ExtraData> T M(@NotNull Class<T> cls) {
        Intrinsics.p(cls, "extraDataClass");
        return (ExtraData) this.s.get(cls);
    }

    @Deprecated(message = "Use {@link View#setTag(int, Object)} with the window's decor view.")
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void P(@NotNull ExtraData extraData) {
        Intrinsics.p(extraData, "extraData");
        this.s.put(extraData.getClass(), extraData);
    }

    /* access modifiers changed from: protected */
    public final boolean Q(@Nullable String[] strArr) {
        return !R(strArr);
    }

    @NotNull
    public Lifecycle a() {
        return this.X;
    }

    public boolean dispatchKeyEvent(@NotNull KeyEvent keyEvent) {
        Intrinsics.p(keyEvent, NotificationCompat.I0);
        View decorView = getWindow().getDecorView();
        Intrinsics.o(decorView, "window.decorView");
        if (KeyEventDispatcher.d(decorView, keyEvent)) {
            return true;
        }
        return KeyEventDispatcher.e(this, decorView, this, keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(@NotNull KeyEvent keyEvent) {
        Intrinsics.p(keyEvent, NotificationCompat.I0);
        View decorView = getWindow().getDecorView();
        Intrinsics.o(decorView, "window.decorView");
        if (KeyEventDispatcher.d(decorView, keyEvent)) {
            return true;
        }
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ReportFragment.X.d(this);
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.p(bundle, "outState");
        this.X.s(Lifecycle.State.CREATED);
        super.onSaveInstanceState(bundle);
    }
}
