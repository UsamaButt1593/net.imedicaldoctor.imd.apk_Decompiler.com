package androidx.lifecycle;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003BC\b\u0007\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0006\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00028\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Landroidx/lifecycle/ViewModelLazy;", "Landroidx/lifecycle/ViewModel;", "VM", "Lkotlin/Lazy;", "Lkotlin/reflect/KClass;", "viewModelClass", "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModelStore;", "storeProducer", "Landroidx/lifecycle/ViewModelProvider$Factory;", "factoryProducer", "Landroidx/lifecycle/viewmodel/CreationExtras;", "extrasProducer", "<init>", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "", "m", "()Z", "s", "Lkotlin/reflect/KClass;", "X", "Lkotlin/jvm/functions/Function0;", "Y", "Z", "X2", "Landroidx/lifecycle/ViewModel;", "cached", "a", "()Landroidx/lifecycle/ViewModel;", "value", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 8, 0})
public final class ViewModelLazy<VM extends ViewModel> implements Lazy<VM> {
    @NotNull
    private final Function0<ViewModelStore> X;
    @Nullable
    private VM X2;
    @NotNull
    private final Function0<ViewModelProvider.Factory> Y;
    @NotNull
    private final Function0<CreationExtras> Z;
    @NotNull
    private final KClass<VM> s;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ViewModelLazy(@NotNull KClass<VM> kClass, @NotNull Function0<? extends ViewModelStore> function0, @NotNull Function0<? extends ViewModelProvider.Factory> function02) {
        this(kClass, function0, function02, (Function0) null, 8, (DefaultConstructorMarker) null);
        Intrinsics.p(kClass, "viewModelClass");
        Intrinsics.p(function0, "storeProducer");
        Intrinsics.p(function02, "factoryProducer");
    }

    @NotNull
    /* renamed from: a */
    public VM getValue() {
        VM vm = this.X2;
        if (vm != null) {
            return vm;
        }
        VM a2 = new ViewModelProvider(this.X.o(), this.Y.o(), this.Z.o()).a(JvmClassMappingKt.e(this.s));
        this.X2 = a2;
        return a2;
    }

    public boolean m() {
        return this.X2 != null;
    }

    @JvmOverloads
    public ViewModelLazy(@NotNull KClass<VM> kClass, @NotNull Function0<? extends ViewModelStore> function0, @NotNull Function0<? extends ViewModelProvider.Factory> function02, @NotNull Function0<? extends CreationExtras> function03) {
        Intrinsics.p(kClass, "viewModelClass");
        Intrinsics.p(function0, "storeProducer");
        Intrinsics.p(function02, "factoryProducer");
        Intrinsics.p(function03, "extrasProducer");
        this.s = kClass;
        this.X = function0;
        this.Y = function02;
        this.Z = function03;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ViewModelLazy(KClass kClass, Function0 function0, Function0 function02, Function0 function03, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(kClass, function0, function02, (i2 & 8) != 0 ? AnonymousClass1.X : function03);
    }
}
