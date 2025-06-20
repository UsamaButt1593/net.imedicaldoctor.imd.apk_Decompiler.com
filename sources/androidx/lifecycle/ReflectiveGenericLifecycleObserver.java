package androidx.lifecycle;

import androidx.annotation.NonNull;
import androidx.lifecycle.ClassesInfoCache;
import androidx.lifecycle.Lifecycle;

@Deprecated
class ReflectiveGenericLifecycleObserver implements LifecycleEventObserver {
    private final ClassesInfoCache.CallbackInfo X;
    private final Object s;

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.s = obj;
        this.X = ClassesInfoCache.f8498c.c(obj.getClass());
    }

    public void d(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
        this.X.a(lifecycleOwner, event, this.s);
    }
}
