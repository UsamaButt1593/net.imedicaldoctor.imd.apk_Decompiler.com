package androidx.asynclayoutinflater.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.core.util.Pools;
import java.util.concurrent.ArrayBlockingQueue;

public final class AsyncLayoutInflater {

    /* renamed from: e  reason: collision with root package name */
    private static final String f3464e = "AsyncLayoutInflater";

    /* renamed from: a  reason: collision with root package name */
    LayoutInflater f3465a;

    /* renamed from: b  reason: collision with root package name */
    Handler f3466b;

    /* renamed from: c  reason: collision with root package name */
    InflateThread f3467c;

    /* renamed from: d  reason: collision with root package name */
    private Handler.Callback f3468d = new Handler.Callback() {
        public boolean handleMessage(Message message) {
            InflateRequest inflateRequest = (InflateRequest) message.obj;
            if (inflateRequest.f3473d == null) {
                inflateRequest.f3473d = AsyncLayoutInflater.this.f3465a.inflate(inflateRequest.f3472c, inflateRequest.f3471b, false);
            }
            inflateRequest.f3474e.a(inflateRequest.f3473d, inflateRequest.f3472c, inflateRequest.f3471b);
            AsyncLayoutInflater.this.f3467c.d(inflateRequest);
            return true;
        }
    };

    private static class BasicInflater extends LayoutInflater {

        /* renamed from: a  reason: collision with root package name */
        private static final String[] f3469a = {"android.widget.", "android.webkit.", "android.app."};

        BasicInflater(Context context) {
            super(context);
        }

        public LayoutInflater cloneInContext(Context context) {
            return new BasicInflater(context);
        }

        /* access modifiers changed from: protected */
        public View onCreateView(String str, AttributeSet attributeSet) throws ClassNotFoundException {
            String[] strArr = f3469a;
            int length = strArr.length;
            int i2 = 0;
            while (i2 < length) {
                try {
                    View createView = createView(str, strArr[i2], attributeSet);
                    if (createView != null) {
                        return createView;
                    }
                    i2++;
                } catch (ClassNotFoundException unused) {
                }
            }
            return super.onCreateView(str, attributeSet);
        }
    }

    private static class InflateRequest {

        /* renamed from: a  reason: collision with root package name */
        AsyncLayoutInflater f3470a;

        /* renamed from: b  reason: collision with root package name */
        ViewGroup f3471b;

        /* renamed from: c  reason: collision with root package name */
        int f3472c;

        /* renamed from: d  reason: collision with root package name */
        View f3473d;

        /* renamed from: e  reason: collision with root package name */
        OnInflateFinishedListener f3474e;

        InflateRequest() {
        }
    }

    private static class InflateThread extends Thread {
        private static final InflateThread Y;
        private Pools.SynchronizedPool<InflateRequest> X = new Pools.SynchronizedPool<>(10);
        private ArrayBlockingQueue<InflateRequest> s = new ArrayBlockingQueue<>(10);

        static {
            InflateThread inflateThread = new InflateThread();
            Y = inflateThread;
            inflateThread.start();
        }

        private InflateThread() {
        }

        public static InflateThread b() {
            return Y;
        }

        public void a(InflateRequest inflateRequest) {
            try {
                this.s.put(inflateRequest);
            } catch (InterruptedException e2) {
                throw new RuntimeException("Failed to enqueue async inflate request", e2);
            }
        }

        public InflateRequest c() {
            InflateRequest b2 = this.X.b();
            return b2 == null ? new InflateRequest() : b2;
        }

        public void d(InflateRequest inflateRequest) {
            inflateRequest.f3474e = null;
            inflateRequest.f3470a = null;
            inflateRequest.f3471b = null;
            inflateRequest.f3472c = 0;
            inflateRequest.f3473d = null;
            this.X.c(inflateRequest);
        }

        public void e() {
            try {
                InflateRequest take = this.s.take();
                try {
                    take.f3473d = take.f3470a.f3465a.inflate(take.f3472c, take.f3471b, false);
                } catch (RuntimeException e2) {
                    Log.w(AsyncLayoutInflater.f3464e, "Failed to inflate resource in the background! Retrying on the UI thread", e2);
                }
                Message.obtain(take.f3470a.f3466b, 0, take).sendToTarget();
            } catch (InterruptedException e3) {
                Log.w(AsyncLayoutInflater.f3464e, e3);
            }
        }

        public void run() {
            while (true) {
                e();
            }
        }
    }

    public interface OnInflateFinishedListener {
        void a(@NonNull View view, @LayoutRes int i2, @Nullable ViewGroup viewGroup);
    }

    public AsyncLayoutInflater(@NonNull Context context) {
        this.f3465a = new BasicInflater(context);
        this.f3466b = new Handler(this.f3468d);
        this.f3467c = InflateThread.b();
    }

    @UiThread
    public void a(@LayoutRes int i2, @Nullable ViewGroup viewGroup, @NonNull OnInflateFinishedListener onInflateFinishedListener) {
        if (onInflateFinishedListener != null) {
            InflateRequest c2 = this.f3467c.c();
            c2.f3470a = this;
            c2.f3472c = i2;
            c2.f3471b = viewGroup;
            c2.f3474e = onInflateFinishedListener;
            this.f3467c.a(c2);
            return;
        }
        throw new NullPointerException("callback argument may not be null!");
    }
}
