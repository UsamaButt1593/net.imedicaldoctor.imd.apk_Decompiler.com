package androidx.media;

import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.util.ObjectsCompat;
import androidx.media.AudioAttributesCompat;

public class AudioFocusRequestCompat {

    /* renamed from: g  reason: collision with root package name */
    static final AudioAttributesCompat f8882g = new AudioAttributesCompat.Builder().e(1).a();

    /* renamed from: a  reason: collision with root package name */
    private final int f8883a;

    /* renamed from: b  reason: collision with root package name */
    private final AudioManager.OnAudioFocusChangeListener f8884b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f8885c;

    /* renamed from: d  reason: collision with root package name */
    private final AudioAttributesCompat f8886d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f8887e;

    /* renamed from: f  reason: collision with root package name */
    private final Object f8888f;

    @RequiresApi(26)
    private static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static AudioFocusRequest a(int i2, AudioAttributes audioAttributes, boolean z, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, Handler handler) {
            return new AudioFocusRequest.Builder(i2).setAudioAttributes(audioAttributes).setWillPauseWhenDucked(z).setOnAudioFocusChangeListener(onAudioFocusChangeListener, handler).build();
        }
    }

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private int f8889a;

        /* renamed from: b  reason: collision with root package name */
        private AudioManager.OnAudioFocusChangeListener f8890b;

        /* renamed from: c  reason: collision with root package name */
        private Handler f8891c;

        /* renamed from: d  reason: collision with root package name */
        private AudioAttributesCompat f8892d = AudioFocusRequestCompat.f8882g;

        /* renamed from: e  reason: collision with root package name */
        private boolean f8893e;

        public Builder(int i2) {
            d(i2);
        }

        private static boolean b(int i2) {
            return i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4;
        }

        public AudioFocusRequestCompat a() {
            if (this.f8890b != null) {
                return new AudioFocusRequestCompat(this.f8889a, this.f8890b, this.f8891c, this.f8892d, this.f8893e);
            }
            throw new IllegalStateException("Can't build an AudioFocusRequestCompat instance without a listener");
        }

        @NonNull
        public Builder c(@NonNull AudioAttributesCompat audioAttributesCompat) {
            if (audioAttributesCompat != null) {
                this.f8892d = audioAttributesCompat;
                return this;
            }
            throw new NullPointerException("Illegal null AudioAttributes");
        }

        @NonNull
        public Builder d(int i2) {
            if (b(i2)) {
                this.f8889a = i2;
                return this;
            }
            throw new IllegalArgumentException("Illegal audio focus gain type " + i2);
        }

        @NonNull
        public Builder e(@NonNull AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener) {
            return f(onAudioFocusChangeListener, new Handler(Looper.getMainLooper()));
        }

        @NonNull
        public Builder f(@NonNull AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, @NonNull Handler handler) {
            if (onAudioFocusChangeListener == null) {
                throw new IllegalArgumentException("OnAudioFocusChangeListener must not be null");
            } else if (handler != null) {
                this.f8890b = onAudioFocusChangeListener;
                this.f8891c = handler;
                return this;
            } else {
                throw new IllegalArgumentException("Handler must not be null");
            }
        }

        @NonNull
        public Builder g(boolean z) {
            this.f8893e = z;
            return this;
        }

        public Builder(@NonNull AudioFocusRequestCompat audioFocusRequestCompat) {
            if (audioFocusRequestCompat != null) {
                this.f8889a = audioFocusRequestCompat.e();
                this.f8890b = audioFocusRequestCompat.f();
                this.f8891c = audioFocusRequestCompat.d();
                this.f8892d = audioFocusRequestCompat.b();
                this.f8893e = audioFocusRequestCompat.g();
                return;
            }
            throw new IllegalArgumentException("AudioFocusRequestCompat to copy must not be null");
        }
    }

    private static class OnAudioFocusChangeListenerHandlerCompat implements Handler.Callback, AudioManager.OnAudioFocusChangeListener {
        private static final int Y = 2782386;
        private final AudioManager.OnAudioFocusChangeListener X;
        private final Handler s;

        OnAudioFocusChangeListenerHandlerCompat(@NonNull AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, @NonNull Handler handler) {
            this.X = onAudioFocusChangeListener;
            this.s = new Handler(handler.getLooper(), this);
        }

        public boolean handleMessage(Message message) {
            if (message.what != Y) {
                return false;
            }
            this.X.onAudioFocusChange(message.arg1);
            return true;
        }

        public void onAudioFocusChange(int i2) {
            Handler handler = this.s;
            handler.sendMessage(Message.obtain(handler, Y, i2, 0));
        }
    }

    AudioFocusRequestCompat(int i2, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, Handler handler, AudioAttributesCompat audioAttributesCompat, boolean z) {
        this.f8883a = i2;
        this.f8885c = handler;
        this.f8886d = audioAttributesCompat;
        this.f8887e = z;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 26 || handler.getLooper() == Looper.getMainLooper()) {
            this.f8884b = onAudioFocusChangeListener;
        } else {
            this.f8884b = new OnAudioFocusChangeListenerHandlerCompat(onAudioFocusChangeListener, handler);
        }
        this.f8888f = i3 >= 26 ? Api26Impl.a(i2, a(), z, this.f8884b, handler) : null;
    }

    /* access modifiers changed from: package-private */
    @RequiresApi(21)
    public AudioAttributes a() {
        AudioAttributesCompat audioAttributesCompat = this.f8886d;
        if (audioAttributesCompat != null) {
            return (AudioAttributes) audioAttributesCompat.c();
        }
        return null;
    }

    @NonNull
    public AudioAttributesCompat b() {
        return this.f8886d;
    }

    /* access modifiers changed from: package-private */
    @RequiresApi(26)
    public AudioFocusRequest c() {
        return b.a(this.f8888f);
    }

    @NonNull
    public Handler d() {
        return this.f8885c;
    }

    public int e() {
        return this.f8883a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AudioFocusRequestCompat)) {
            return false;
        }
        AudioFocusRequestCompat audioFocusRequestCompat = (AudioFocusRequestCompat) obj;
        return this.f8883a == audioFocusRequestCompat.f8883a && this.f8887e == audioFocusRequestCompat.f8887e && ObjectsCompat.a(this.f8884b, audioFocusRequestCompat.f8884b) && ObjectsCompat.a(this.f8885c, audioFocusRequestCompat.f8885c) && ObjectsCompat.a(this.f8886d, audioFocusRequestCompat.f8886d);
    }

    @NonNull
    public AudioManager.OnAudioFocusChangeListener f() {
        return this.f8884b;
    }

    public boolean g() {
        return this.f8887e;
    }

    public int hashCode() {
        return ObjectsCompat.b(Integer.valueOf(this.f8883a), this.f8884b, this.f8885c, this.f8886d, Boolean.valueOf(this.f8887e));
    }
}
