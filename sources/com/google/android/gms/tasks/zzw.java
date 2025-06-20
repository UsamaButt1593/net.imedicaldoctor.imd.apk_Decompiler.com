package com.google.android.gms.tasks;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

final class zzw<TResult> extends Task<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private final Object f20562a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final zzr f20563b = new zzr();

    /* renamed from: c  reason: collision with root package name */
    private boolean f20564c;

    /* renamed from: d  reason: collision with root package name */
    private volatile boolean f20565d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private Object f20566e;

    /* renamed from: f  reason: collision with root package name */
    private Exception f20567f;

    zzw() {
    }

    private final void D() {
        Preconditions.y(this.f20564c, "Task is not yet complete");
    }

    private final void E() {
        if (this.f20565d) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    private final void F() {
        if (this.f20564c) {
            throw DuplicateTaskCompletionException.a(this);
        }
    }

    private final void G() {
        synchronized (this.f20562a) {
            try {
                if (this.f20564c) {
                    this.f20563b.b(this);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public final boolean A() {
        synchronized (this.f20562a) {
            try {
                if (this.f20564c) {
                    return false;
                }
                this.f20564c = true;
                this.f20565d = true;
                this.f20563b.b(this);
                return true;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public final boolean B(@NonNull Exception exc) {
        Preconditions.s(exc, "Exception must not be null");
        synchronized (this.f20562a) {
            try {
                if (this.f20564c) {
                    return false;
                }
                this.f20564c = true;
                this.f20567f = exc;
                this.f20563b.b(this);
                return true;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public final boolean C(@Nullable Object obj) {
        synchronized (this.f20562a) {
            try {
                if (this.f20564c) {
                    return false;
                }
                this.f20564c = true;
                this.f20566e = obj;
                this.f20563b.b(this);
                return true;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    @NonNull
    public final Task<TResult> a(@NonNull Activity activity, @NonNull OnCanceledListener onCanceledListener) {
        zzh zzh = new zzh(TaskExecutors.f20522a, onCanceledListener);
        this.f20563b.a(zzh);
        zzv.m(activity).n(zzh);
        G();
        return this;
    }

    @NonNull
    public final Task<TResult> b(@NonNull OnCanceledListener onCanceledListener) {
        c(TaskExecutors.f20522a, onCanceledListener);
        return this;
    }

    @NonNull
    public final Task<TResult> c(@NonNull Executor executor, @NonNull OnCanceledListener onCanceledListener) {
        this.f20563b.a(new zzh(executor, onCanceledListener));
        G();
        return this;
    }

    @NonNull
    public final Task<TResult> d(@NonNull Activity activity, @NonNull OnCompleteListener<TResult> onCompleteListener) {
        zzj zzj = new zzj(TaskExecutors.f20522a, onCompleteListener);
        this.f20563b.a(zzj);
        zzv.m(activity).n(zzj);
        G();
        return this;
    }

    @NonNull
    public final Task<TResult> e(@NonNull OnCompleteListener<TResult> onCompleteListener) {
        this.f20563b.a(new zzj(TaskExecutors.f20522a, onCompleteListener));
        G();
        return this;
    }

    @NonNull
    public final Task<TResult> f(@NonNull Executor executor, @NonNull OnCompleteListener<TResult> onCompleteListener) {
        this.f20563b.a(new zzj(executor, onCompleteListener));
        G();
        return this;
    }

    @NonNull
    public final Task<TResult> g(@NonNull Activity activity, @NonNull OnFailureListener onFailureListener) {
        zzl zzl = new zzl(TaskExecutors.f20522a, onFailureListener);
        this.f20563b.a(zzl);
        zzv.m(activity).n(zzl);
        G();
        return this;
    }

    @NonNull
    public final Task<TResult> h(@NonNull OnFailureListener onFailureListener) {
        i(TaskExecutors.f20522a, onFailureListener);
        return this;
    }

    @NonNull
    public final Task<TResult> i(@NonNull Executor executor, @NonNull OnFailureListener onFailureListener) {
        this.f20563b.a(new zzl(executor, onFailureListener));
        G();
        return this;
    }

    @NonNull
    public final Task<TResult> j(@NonNull Activity activity, @NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        zzn zzn = new zzn(TaskExecutors.f20522a, onSuccessListener);
        this.f20563b.a(zzn);
        zzv.m(activity).n(zzn);
        G();
        return this;
    }

    @NonNull
    public final Task<TResult> k(@NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        l(TaskExecutors.f20522a, onSuccessListener);
        return this;
    }

    @NonNull
    public final Task<TResult> l(@NonNull Executor executor, @NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        this.f20563b.a(new zzn(executor, onSuccessListener));
        G();
        return this;
    }

    @NonNull
    public final <TContinuationResult> Task<TContinuationResult> m(@NonNull Continuation<TResult, TContinuationResult> continuation) {
        return n(TaskExecutors.f20522a, continuation);
    }

    @NonNull
    public final <TContinuationResult> Task<TContinuationResult> n(@NonNull Executor executor, @NonNull Continuation<TResult, TContinuationResult> continuation) {
        zzw zzw = new zzw();
        this.f20563b.a(new zzd(executor, continuation, zzw));
        G();
        return zzw;
    }

    @NonNull
    public final <TContinuationResult> Task<TContinuationResult> o(@NonNull Continuation<TResult, Task<TContinuationResult>> continuation) {
        return p(TaskExecutors.f20522a, continuation);
    }

    @NonNull
    public final <TContinuationResult> Task<TContinuationResult> p(@NonNull Executor executor, @NonNull Continuation<TResult, Task<TContinuationResult>> continuation) {
        zzw zzw = new zzw();
        this.f20563b.a(new zzf(executor, continuation, zzw));
        G();
        return zzw;
    }

    @Nullable
    public final Exception q() {
        Exception exc;
        synchronized (this.f20562a) {
            exc = this.f20567f;
        }
        return exc;
    }

    public final TResult r() {
        TResult tresult;
        synchronized (this.f20562a) {
            try {
                D();
                E();
                Exception exc = this.f20567f;
                if (exc == null) {
                    tresult = this.f20566e;
                } else {
                    throw new RuntimeExecutionException(exc);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return tresult;
    }

    public final <X extends Throwable> TResult s(@NonNull Class<X> cls) throws Throwable {
        TResult tresult;
        synchronized (this.f20562a) {
            try {
                D();
                E();
                if (!cls.isInstance(this.f20567f)) {
                    Exception exc = this.f20567f;
                    if (exc == null) {
                        tresult = this.f20566e;
                    } else {
                        throw new RuntimeExecutionException(exc);
                    }
                } else {
                    throw ((Throwable) cls.cast(this.f20567f));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return tresult;
    }

    public final boolean t() {
        return this.f20565d;
    }

    public final boolean u() {
        boolean z;
        synchronized (this.f20562a) {
            z = this.f20564c;
        }
        return z;
    }

    public final boolean v() {
        boolean z;
        synchronized (this.f20562a) {
            try {
                z = false;
                if (this.f20564c && !this.f20565d && this.f20567f == null) {
                    z = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    @NonNull
    public final <TContinuationResult> Task<TContinuationResult> w(@NonNull SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        Executor executor = TaskExecutors.f20522a;
        zzw zzw = new zzw();
        this.f20563b.a(new zzp(executor, successContinuation, zzw));
        G();
        return zzw;
    }

    @NonNull
    public final <TContinuationResult> Task<TContinuationResult> x(Executor executor, SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        zzw zzw = new zzw();
        this.f20563b.a(new zzp(executor, successContinuation, zzw));
        G();
        return zzw;
    }

    public final void y(@NonNull Exception exc) {
        Preconditions.s(exc, "Exception must not be null");
        synchronized (this.f20562a) {
            F();
            this.f20564c = true;
            this.f20567f = exc;
        }
        this.f20563b.b(this);
    }

    public final void z(@Nullable Object obj) {
        synchronized (this.f20562a) {
            F();
            this.f20564c = true;
            this.f20566e = obj;
        }
        this.f20563b.b(this);
    }
}
