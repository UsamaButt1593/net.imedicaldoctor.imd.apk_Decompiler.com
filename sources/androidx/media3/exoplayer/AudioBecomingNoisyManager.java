package androidx.media3.exoplayer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;

final class AudioBecomingNoisyManager {

    /* renamed from: a  reason: collision with root package name */
    private final Context f10077a;

    /* renamed from: b  reason: collision with root package name */
    private final AudioBecomingNoisyReceiver f10078b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f10079c;

    private final class AudioBecomingNoisyReceiver extends BroadcastReceiver implements Runnable {
        private final Handler X;
        private final EventListener s;

        public AudioBecomingNoisyReceiver(Handler handler, EventListener eventListener) {
            this.X = handler;
            this.s = eventListener;
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                this.X.post(this);
            }
        }

        public void run() {
            if (AudioBecomingNoisyManager.this.f10079c) {
                this.s.A();
            }
        }
    }

    public interface EventListener {
        void A();
    }

    public AudioBecomingNoisyManager(Context context, Handler handler, EventListener eventListener) {
        this.f10077a = context.getApplicationContext();
        this.f10078b = new AudioBecomingNoisyReceiver(handler, eventListener);
    }

    public void b(boolean z) {
        boolean z2;
        if (z && !this.f10079c) {
            this.f10077a.registerReceiver(this.f10078b, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
            z2 = true;
        } else if (!z && this.f10079c) {
            this.f10077a.unregisterReceiver(this.f10078b);
            z2 = false;
        } else {
            return;
        }
        this.f10079c = z2;
    }
}
