package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B.\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\b\b¢\u0006\u0004\b\n\u0010\u000bR \u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0000X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000eR+\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\b\b8\u0000X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/lifecycle/viewmodel/ViewModelInitializer;", "Landroidx/lifecycle/ViewModel;", "T", "", "Ljava/lang/Class;", "clazz", "Lkotlin/Function1;", "Landroidx/lifecycle/viewmodel/CreationExtras;", "Lkotlin/ExtensionFunctionType;", "initializer", "<init>", "(Ljava/lang/Class;Lkotlin/jvm/functions/Function1;)V", "a", "Ljava/lang/Class;", "()Ljava/lang/Class;", "b", "Lkotlin/jvm/functions/Function1;", "()Lkotlin/jvm/functions/Function1;", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 8, 0})
public final class ViewModelInitializer<T extends ViewModel> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Class<T> f8718a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Function1<CreationExtras, T> f8719b;

    public ViewModelInitializer(@NotNull Class<T> cls, @NotNull Function1<? super CreationExtras, ? extends T> function1) {
        Intrinsics.p(cls, "clazz");
        Intrinsics.p(function1, "initializer");
        this.f8718a = cls;
        this.f8719b = function1;
    }

    @NotNull
    public final Class<T> a() {
        return this.f8718a;
    }

    @NotNull
    public final Function1<CreationExtras, T> b() {
        return this.f8719b;
    }
}
