package com.trello.lifecycle4.android.lifecycle;

import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import com.trello.rxlifecycle4.LifecycleTransformer;
import com.trello.rxlifecycle4.OutsideLifecycleException;
import com.trello.rxlifecycle4.RxLifecycle;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;

public final class RxLifecycleAndroidLifecycle {

    /* renamed from: a  reason: collision with root package name */
    private static final Function<Lifecycle.Event, Lifecycle.Event> f28245a = new Function<Lifecycle.Event, Lifecycle.Event>() {
        /* renamed from: a */
        public Lifecycle.Event apply(Lifecycle.Event event) throws Exception {
            switch (AnonymousClass2.f28246a[event.ordinal()]) {
                case 1:
                    return Lifecycle.Event.ON_DESTROY;
                case 2:
                    return Lifecycle.Event.ON_STOP;
                case 3:
                    return Lifecycle.Event.ON_PAUSE;
                case 4:
                    return Lifecycle.Event.ON_STOP;
                case 5:
                    return Lifecycle.Event.ON_DESTROY;
                case 6:
                    throw new OutsideLifecycleException("Cannot bind to Activity lifecycle when outside of it.");
                default:
                    throw new UnsupportedOperationException("Binding to " + event + " not yet implemented");
            }
        }
    };

    /* renamed from: com.trello.lifecycle4.android.lifecycle.RxLifecycleAndroidLifecycle$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f28246a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.lifecycle.Lifecycle$Event[] r0 = androidx.lifecycle.Lifecycle.Event.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f28246a = r0
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_CREATE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f28246a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_START     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f28246a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_RESUME     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f28246a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_PAUSE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f28246a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_STOP     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f28246a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_DESTROY     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.trello.lifecycle4.android.lifecycle.RxLifecycleAndroidLifecycle.AnonymousClass2.<clinit>():void");
        }
    }

    private RxLifecycleAndroidLifecycle() {
        throw new AssertionError("No instances");
    }

    @CheckResult
    @NonNull
    public static <T> LifecycleTransformer<T> a(@NonNull Observable<Lifecycle.Event> observable) {
        return RxLifecycle.b(observable, f28245a);
    }
}
