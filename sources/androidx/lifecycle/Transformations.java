package androidx.lifecycle;

import androidx.annotation.CheckResult;
import androidx.annotation.MainThread;
import androidx.arch.core.util.Function;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001aI\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u001c\u0010\u0005\u001a\u0018\u0012\t\u0012\u00078\u0000¢\u0006\u0002\b\u0004\u0012\t\u0012\u00078\u0001¢\u0006\u0002\b\u00040\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a?\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\bH\u0007¢\u0006\u0004\b\n\u0010\u000b\u001aQ\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022$\u0010\u0005\u001a \u0012\t\u0012\u00078\u0000¢\u0006\u0002\b\u0004\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0002¢\u0006\u0002\b\u00040\u0003H\u0007¢\u0006\u0004\b\f\u0010\u0007\u001aE\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00020\bH\u0007¢\u0006\u0004\b\u000e\u0010\u000b\u001a%\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0007¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"X", "Y", "Landroidx/lifecycle/LiveData;", "Lkotlin/Function1;", "Lkotlin/jvm/JvmSuppressWildcards;", "transform", "c", "(Landroidx/lifecycle/LiveData;Lkotlin/jvm/functions/Function1;)Landroidx/lifecycle/LiveData;", "Landroidx/arch/core/util/Function;", "mapFunction", "b", "(Landroidx/lifecycle/LiveData;Landroidx/arch/core/util/Function;)Landroidx/lifecycle/LiveData;", "e", "switchMapFunction", "d", "a", "(Landroidx/lifecycle/LiveData;)Landroidx/lifecycle/LiveData;", "lifecycle-livedata_release"}, k = 2, mv = {1, 8, 0})
@JvmName(name = "Transformations")
public final class Transformations {
    @MainThread
    @CheckResult
    @NotNull
    @JvmName(name = "distinctUntilChanged")
    public static final <X> LiveData<X> a(@NotNull LiveData<X> liveData) {
        Intrinsics.p(liveData, "<this>");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.s = true;
        if (liveData.j()) {
            mediatorLiveData.r(liveData.f());
            booleanRef.s = false;
        }
        mediatorLiveData.s(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new Transformations$distinctUntilChanged$1(mediatorLiveData, booleanRef)));
        return mediatorLiveData;
    }

    @MainThread
    @CheckResult
    @Deprecated(level = DeprecationLevel.Y, message = "Use kotlin functions, instead of outdated arch core Functions")
    @JvmName(name = "map")
    public static final /* synthetic */ LiveData b(LiveData liveData, Function function) {
        Intrinsics.p(liveData, "<this>");
        Intrinsics.p(function, "mapFunction");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.s(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new Transformations$map$2(mediatorLiveData, function)));
        return mediatorLiveData;
    }

    @MainThread
    @CheckResult
    @NotNull
    @JvmName(name = "map")
    public static final <X, Y> LiveData<Y> c(@NotNull LiveData<X> liveData, @NotNull Function1<X, Y> function1) {
        Intrinsics.p(liveData, "<this>");
        Intrinsics.p(function1, "transform");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.s(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new Transformations$map$1(mediatorLiveData, function1)));
        return mediatorLiveData;
    }

    @MainThread
    @CheckResult
    @Deprecated(level = DeprecationLevel.Y, message = "Use kotlin functions, instead of outdated arch core Functions")
    @JvmName(name = "switchMap")
    public static final /* synthetic */ LiveData d(LiveData liveData, Function function) {
        Intrinsics.p(liveData, "<this>");
        Intrinsics.p(function, "switchMapFunction");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.s(liveData, new Transformations$switchMap$2(function, mediatorLiveData));
        return mediatorLiveData;
    }

    @MainThread
    @CheckResult
    @NotNull
    @JvmName(name = "switchMap")
    public static final <X, Y> LiveData<Y> e(@NotNull LiveData<X> liveData, @NotNull Function1<X, LiveData<Y>> function1) {
        Intrinsics.p(liveData, "<this>");
        Intrinsics.p(function1, "transform");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.s(liveData, new Transformations$switchMap$1(function1, mediatorLiveData));
        return mediatorLiveData;
    }
}
