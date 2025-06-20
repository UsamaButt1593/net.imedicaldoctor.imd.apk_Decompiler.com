package androidx.media3.common.audio;

import androidx.annotation.CallSuper;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.UnstableApi;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@UnstableApi
public abstract class BaseAudioProcessor implements AudioProcessor {

    /* renamed from: b  reason: collision with root package name */
    protected AudioProcessor.AudioFormat f9386b;

    /* renamed from: c  reason: collision with root package name */
    protected AudioProcessor.AudioFormat f9387c;

    /* renamed from: d  reason: collision with root package name */
    private AudioProcessor.AudioFormat f9388d;

    /* renamed from: e  reason: collision with root package name */
    private AudioProcessor.AudioFormat f9389e;

    /* renamed from: f  reason: collision with root package name */
    private ByteBuffer f9390f;

    /* renamed from: g  reason: collision with root package name */
    private ByteBuffer f9391g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f9392h;

    public BaseAudioProcessor() {
        ByteBuffer byteBuffer = AudioProcessor.f9380a;
        this.f9390f = byteBuffer;
        this.f9391g = byteBuffer;
        AudioProcessor.AudioFormat audioFormat = AudioProcessor.AudioFormat.f9381e;
        this.f9388d = audioFormat;
        this.f9389e = audioFormat;
        this.f9386b = audioFormat;
        this.f9387c = audioFormat;
    }

    /* access modifiers changed from: protected */
    public final boolean a() {
        return this.f9391g.hasRemaining();
    }

    public boolean b() {
        return this.f9389e != AudioProcessor.AudioFormat.f9381e;
    }

    @CallSuper
    public boolean c() {
        return this.f9392h && this.f9391g == AudioProcessor.f9380a;
    }

    @CallSuper
    public ByteBuffer d() {
        ByteBuffer byteBuffer = this.f9391g;
        this.f9391g = AudioProcessor.f9380a;
        return byteBuffer;
    }

    public final void f() {
        this.f9392h = true;
        j();
    }

    public final void flush() {
        this.f9391g = AudioProcessor.f9380a;
        this.f9392h = false;
        this.f9386b = this.f9388d;
        this.f9387c = this.f9389e;
        i();
    }

    public final AudioProcessor.AudioFormat g(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        this.f9388d = audioFormat;
        this.f9389e = h(audioFormat);
        return b() ? this.f9389e : AudioProcessor.AudioFormat.f9381e;
    }

    /* access modifiers changed from: protected */
    public AudioProcessor.AudioFormat h(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        return AudioProcessor.AudioFormat.f9381e;
    }

    /* access modifiers changed from: protected */
    public void i() {
    }

    /* access modifiers changed from: protected */
    public void j() {
    }

    /* access modifiers changed from: protected */
    public void k() {
    }

    /* access modifiers changed from: protected */
    public final ByteBuffer l(int i2) {
        if (this.f9390f.capacity() < i2) {
            this.f9390f = ByteBuffer.allocateDirect(i2).order(ByteOrder.nativeOrder());
        } else {
            this.f9390f.clear();
        }
        ByteBuffer byteBuffer = this.f9390f;
        this.f9391g = byteBuffer;
        return byteBuffer;
    }

    public final void reset() {
        flush();
        this.f9390f = AudioProcessor.f9380a;
        AudioProcessor.AudioFormat audioFormat = AudioProcessor.AudioFormat.f9381e;
        this.f9388d = audioFormat;
        this.f9389e = audioFormat;
        this.f9386b = audioFormat;
        this.f9387c = audioFormat;
        k();
    }
}
