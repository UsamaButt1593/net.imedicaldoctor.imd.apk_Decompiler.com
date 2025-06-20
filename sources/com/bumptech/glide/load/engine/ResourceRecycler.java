package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class ResourceRecycler {

    /* renamed from: a  reason: collision with root package name */
    private boolean f17966a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f17967b = new Handler(Looper.getMainLooper(), new ResourceRecyclerCallback());

    private static final class ResourceRecyclerCallback implements Handler.Callback {
        static final int s = 1;

        ResourceRecyclerCallback() {
        }

        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((Resource) message.obj).recycle();
            return true;
        }
    }

    ResourceRecycler() {
    }

    /* access modifiers changed from: package-private */
    public synchronized void a(Resource<?> resource, boolean z) {
        try {
            if (!this.f17966a) {
                if (!z) {
                    this.f17966a = true;
                    resource.recycle();
                    this.f17966a = false;
                }
            }
            this.f17967b.obtainMessage(1, resource).sendToTarget();
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }
}
