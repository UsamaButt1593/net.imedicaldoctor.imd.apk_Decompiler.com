package androidx.activity;

import androidx.annotation.MainThread;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0017¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0017¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0006H'¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0017¢\u0006\u0004\b\u000f\u0010\bJ\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0014\u0010\u0013R*\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00028G@GX\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u0005R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00100\u001b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR*\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001f8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010 \u001a\u0004\b\u001c\u0010!\"\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Landroidx/activity/OnBackPressedCallback;", "", "", "enabled", "<init>", "(Z)V", "", "h", "()V", "Landroidx/activity/BackEventCompat;", "backEvent", "f", "(Landroidx/activity/BackEventCompat;)V", "e", "d", "c", "Landroidx/activity/Cancellable;", "cancellable", "a", "(Landroidx/activity/Cancellable;)V", "i", "value", "Z", "g", "()Z", "j", "isEnabled", "Ljava/util/concurrent/CopyOnWriteArrayList;", "b", "Ljava/util/concurrent/CopyOnWriteArrayList;", "cancellables", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "()Lkotlin/jvm/functions/Function0;", "k", "(Lkotlin/jvm/functions/Function0;)V", "enabledChangedCallback", "activity_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nOnBackPressedCallback.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OnBackPressedCallback.kt\nandroidx/activity/OnBackPressedCallback\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,115:1\n1855#2,2:116\n*S KotlinDebug\n*F\n+ 1 OnBackPressedCallback.kt\nandroidx/activity/OnBackPressedCallback\n*L\n67#1:116,2\n*E\n"})
public abstract class OnBackPressedCallback {

    /* renamed from: a  reason: collision with root package name */
    private boolean f2434a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final CopyOnWriteArrayList<Cancellable> f2435b = new CopyOnWriteArrayList<>();
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private Function0<Unit> f2436c;

    public OnBackPressedCallback(boolean z) {
        this.f2434a = z;
    }

    @JvmName(name = "addCancellable")
    public final void a(@NotNull Cancellable cancellable) {
        Intrinsics.p(cancellable, "cancellable");
        this.f2435b.add(cancellable);
    }

    @Nullable
    public final Function0<Unit> b() {
        return this.f2436c;
    }

    @MainThread
    public void c() {
    }

    @MainThread
    public abstract void d();

    @MainThread
    public void e(@NotNull BackEventCompat backEventCompat) {
        Intrinsics.p(backEventCompat, "backEvent");
    }

    @MainThread
    public void f(@NotNull BackEventCompat backEventCompat) {
        Intrinsics.p(backEventCompat, "backEvent");
    }

    @MainThread
    public final boolean g() {
        return this.f2434a;
    }

    @MainThread
    public final void h() {
        for (Cancellable cancel : this.f2435b) {
            cancel.cancel();
        }
    }

    @JvmName(name = "removeCancellable")
    public final void i(@NotNull Cancellable cancellable) {
        Intrinsics.p(cancellable, "cancellable");
        this.f2435b.remove(cancellable);
    }

    @MainThread
    public final void j(boolean z) {
        this.f2434a = z;
        Function0<Unit> function0 = this.f2436c;
        if (function0 != null) {
            function0.o();
        }
    }

    public final void k(@Nullable Function0<Unit> function0) {
        this.f2436c = function0;
    }
}
