package androidx.lifecycle;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.ViewModelInitializer;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final /* synthetic */ class l {
    static {
        ViewModelProvider.Factory.Companion companion = ViewModelProvider.Factory.f8617a;
    }

    @NotNull
    public static ViewModel a(ViewModelProvider.Factory factory, @NotNull Class cls) {
        Intrinsics.p(cls, "modelClass");
        throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
    }

    @NotNull
    public static ViewModel b(ViewModelProvider.Factory factory, @NotNull Class cls, @NotNull CreationExtras creationExtras) {
        Intrinsics.p(cls, "modelClass");
        Intrinsics.p(creationExtras, "extras");
        return factory.a(cls);
    }

    @JvmStatic
    @NotNull
    public static ViewModelProvider.Factory c(@NotNull ViewModelInitializer<?>... viewModelInitializerArr) {
        return ViewModelProvider.Factory.f8617a.a(viewModelInitializerArr);
    }
}
