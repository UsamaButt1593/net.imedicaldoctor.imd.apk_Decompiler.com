package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003:\u0001\u0014B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00028\u0000H&¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000f\u001a\u00028\u00012\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00112\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContract;", "I", "O", "", "<init>", "()V", "Landroid/content/Context;", "context", "input", "Landroid/content/Intent;", "a", "(Landroid/content/Context;Ljava/lang/Object;)Landroid/content/Intent;", "", "resultCode", "intent", "c", "(ILandroid/content/Intent;)Ljava/lang/Object;", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "b", "(Landroid/content/Context;Ljava/lang/Object;)Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "SynchronousResult", "activity_release"}, k = 1, mv = {1, 8, 0})
public abstract class ActivityResultContract<I, O> {

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0002\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00028\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b¨\u0006\t"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "T", "", "value", "<init>", "(Ljava/lang/Object;)V", "a", "Ljava/lang/Object;", "()Ljava/lang/Object;", "activity_release"}, k = 1, mv = {1, 8, 0})
    public static final class SynchronousResult<T> {

        /* renamed from: a  reason: collision with root package name */
        private final T f2495a;

        public SynchronousResult(T t) {
            this.f2495a = t;
        }

        public final T a() {
            return this.f2495a;
        }
    }

    @NotNull
    public abstract Intent a(@NotNull Context context, I i2);

    @Nullable
    public SynchronousResult<O> b(@NotNull Context context, I i2) {
        Intrinsics.p(context, "context");
        return null;
    }

    public abstract O c(int i2, @Nullable Intent intent);
}
