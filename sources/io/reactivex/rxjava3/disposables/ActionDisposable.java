package io.reactivex.rxjava3.disposables;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;

final class ActionDisposable extends ReferenceDisposable<Action> {
    private static final long X = -8219729196779211169L;

    ActionDisposable(Action action) {
        super(action);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void a(@NonNull Action action) {
        try {
            action.run();
        } catch (Throwable th) {
            throw ExceptionHelper.i(th);
        }
    }

    public String toString() {
        return "ActionDisposable(disposed=" + g() + ", " + get() + ")";
    }
}
