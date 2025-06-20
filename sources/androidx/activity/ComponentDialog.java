package androidx.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.CallSuper;
import androidx.annotation.StyleRes;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u001b\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0003\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0015¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0015¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000fH\u0015¢\u0006\u0004\b\u0014\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u000fH\u0017¢\u0006\u0004\b\u0015\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u0017\u0010\u001bJ!\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b\u0017\u0010\u001eJ!\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b\u001f\u0010\u001eJ\u000f\u0010 \u001a\u00020\u000fH\u0017¢\u0006\u0004\b \u0010\u0013R\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u001d\u0010/\u001a\u00020)8\u0006¢\u0006\u0012\n\u0004\b*\u0010+\u0012\u0004\b.\u0010\u0013\u001a\u0004\b,\u0010-R\u0014\u00102\u001a\u00020!8BX\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0014\u00106\u001a\u0002038VX\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u0014\u0010:\u001a\u0002078VX\u0004¢\u0006\u0006\u001a\u0004\b8\u00109¨\u0006;"}, d2 = {"Landroidx/activity/ComponentDialog;", "Landroid/app/Dialog;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/activity/OnBackPressedDispatcherOwner;", "Landroidx/savedstate/SavedStateRegistryOwner;", "Landroid/content/Context;", "context", "", "themeResId", "<init>", "(Landroid/content/Context;I)V", "Landroid/os/Bundle;", "onSaveInstanceState", "()Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "onBackPressed", "layoutResID", "setContentView", "(I)V", "Landroid/view/View;", "view", "(Landroid/view/View;)V", "Landroid/view/ViewGroup$LayoutParams;", "params", "(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V", "addContentView", "f", "Landroidx/lifecycle/LifecycleRegistry;", "s", "Landroidx/lifecycle/LifecycleRegistry;", "_lifecycleRegistry", "Landroidx/savedstate/SavedStateRegistryController;", "X", "Landroidx/savedstate/SavedStateRegistryController;", "savedStateRegistryController", "Landroidx/activity/OnBackPressedDispatcher;", "Y", "Landroidx/activity/OnBackPressedDispatcher;", "e", "()Landroidx/activity/OnBackPressedDispatcher;", "d", "onBackPressedDispatcher", "c", "()Landroidx/lifecycle/LifecycleRegistry;", "lifecycleRegistry", "Landroidx/savedstate/SavedStateRegistry;", "A", "()Landroidx/savedstate/SavedStateRegistry;", "savedStateRegistry", "Landroidx/lifecycle/Lifecycle;", "a", "()Landroidx/lifecycle/Lifecycle;", "lifecycle", "activity_release"}, k = 1, mv = {1, 8, 0})
public class ComponentDialog extends Dialog implements LifecycleOwner, OnBackPressedDispatcherOwner, SavedStateRegistryOwner {
    @NotNull
    private final SavedStateRegistryController X;
    @NotNull
    private final OnBackPressedDispatcher Y;
    @Nullable
    private LifecycleRegistry s;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ComponentDialog(@NotNull Context context) {
        this(context, 0, 2, (DefaultConstructorMarker) null);
        Intrinsics.p(context, "context");
    }

    private final LifecycleRegistry c() {
        LifecycleRegistry lifecycleRegistry = this.s;
        if (lifecycleRegistry != null) {
            return lifecycleRegistry;
        }
        LifecycleRegistry lifecycleRegistry2 = new LifecycleRegistry(this);
        this.s = lifecycleRegistry2;
        return lifecycleRegistry2;
    }

    public static /* synthetic */ void d() {
    }

    /* access modifiers changed from: private */
    public static final void g(ComponentDialog componentDialog) {
        Intrinsics.p(componentDialog, "this$0");
        super.onBackPressed();
    }

    @NotNull
    public SavedStateRegistry A() {
        return this.X.b();
    }

    @NotNull
    public Lifecycle a() {
        return c();
    }

    public void addContentView(@NotNull View view, @Nullable ViewGroup.LayoutParams layoutParams) {
        Intrinsics.p(view, "view");
        f();
        super.addContentView(view, layoutParams);
    }

    @NotNull
    public final OnBackPressedDispatcher e() {
        return this.Y;
    }

    @CallSuper
    public void f() {
        Window window = getWindow();
        Intrinsics.m(window);
        View decorView = window.getDecorView();
        Intrinsics.o(decorView, "window!!.decorView");
        ViewTreeLifecycleOwner.b(decorView, this);
        Window window2 = getWindow();
        Intrinsics.m(window2);
        View decorView2 = window2.getDecorView();
        Intrinsics.o(decorView2, "window!!.decorView");
        ViewTreeOnBackPressedDispatcherOwner.b(decorView2, this);
        Window window3 = getWindow();
        Intrinsics.m(window3);
        View decorView3 = window3.getDecorView();
        Intrinsics.o(decorView3, "window!!.decorView");
        ViewTreeSavedStateRegistryOwner.b(decorView3, this);
    }

    @CallSuper
    public void onBackPressed() {
        this.Y.p();
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackPressedDispatcher onBackPressedDispatcher = this.Y;
            OnBackInvokedDispatcher a2 = getOnBackInvokedDispatcher();
            Intrinsics.o(a2, "onBackInvokedDispatcher");
            onBackPressedDispatcher.s(a2);
        }
        this.X.d(bundle);
        c().l(Lifecycle.Event.ON_CREATE);
    }

    @NotNull
    public Bundle onSaveInstanceState() {
        Bundle onSaveInstanceState = super.onSaveInstanceState();
        Intrinsics.o(onSaveInstanceState, "super.onSaveInstanceState()");
        this.X.e(onSaveInstanceState);
        return onSaveInstanceState;
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onStart() {
        super.onStart();
        c().l(Lifecycle.Event.ON_RESUME);
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onStop() {
        c().l(Lifecycle.Event.ON_DESTROY);
        this.s = null;
        super.onStop();
    }

    public void setContentView(int i2) {
        f();
        super.setContentView(i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ComponentDialog(@NotNull Context context, @StyleRes int i2) {
        super(context, i2);
        Intrinsics.p(context, "context");
        this.X = SavedStateRegistryController.f15714d.a(this);
        this.Y = new OnBackPressedDispatcher(new g(this));
    }

    public void setContentView(@NotNull View view) {
        Intrinsics.p(view, "view");
        f();
        super.setContentView(view);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ComponentDialog(Context context, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? 0 : i2);
    }

    public void setContentView(@NotNull View view, @Nullable ViewGroup.LayoutParams layoutParams) {
        Intrinsics.p(view, "view");
        f();
        super.setContentView(view, layoutParams);
    }
}
