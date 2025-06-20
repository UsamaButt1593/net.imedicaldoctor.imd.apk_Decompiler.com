package kotlinx.coroutines.tasks;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import kotlinx.coroutines.CompletableDeferred;

public final /* synthetic */ class a implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CompletableDeferred f29470a;

    public /* synthetic */ a(CompletableDeferred completableDeferred) {
        this.f29470a = completableDeferred;
    }

    public final void a(Task task) {
        TasksKt.f(this.f29470a, task);
    }
}
