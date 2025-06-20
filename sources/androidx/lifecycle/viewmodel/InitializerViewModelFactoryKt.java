package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a,\u0010\u0006\u001a\u00020\u00052\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\bø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a>\u0010\f\u001a\u00020\u0002\"\n\b\u0000\u0010\t\u0018\u0001*\u00020\b*\u00020\u00012\u0019\b\b\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\u0002\b\u0003H\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u0002\u0007\n\u0005\b20\u0001¨\u0006\u000e"}, d2 = {"Lkotlin/Function1;", "Landroidx/lifecycle/viewmodel/InitializerViewModelFactoryBuilder;", "", "Lkotlin/ExtensionFunctionType;", "builder", "Landroidx/lifecycle/ViewModelProvider$Factory;", "b", "(Lkotlin/jvm/functions/Function1;)Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "VM", "Landroidx/lifecycle/viewmodel/CreationExtras;", "initializer", "a", "(Landroidx/lifecycle/viewmodel/InitializerViewModelFactoryBuilder;Lkotlin/jvm/functions/Function1;)V", "lifecycle-viewmodel_release"}, k = 2, mv = {1, 8, 0})
public final class InitializerViewModelFactoryKt {
    public static final /* synthetic */ <VM extends ViewModel> void a(InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder, Function1<? super CreationExtras, ? extends VM> function1) {
        Intrinsics.p(initializerViewModelFactoryBuilder, "<this>");
        Intrinsics.p(function1, "initializer");
        Intrinsics.y(4, "VM");
        initializerViewModelFactoryBuilder.a(Reflection.d(ViewModel.class), function1);
    }

    @NotNull
    public static final ViewModelProvider.Factory b(@NotNull Function1<? super InitializerViewModelFactoryBuilder, Unit> function1) {
        Intrinsics.p(function1, "builder");
        InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
        function1.f(initializerViewModelFactoryBuilder);
        return initializerViewModelFactoryBuilder.b();
    }
}
