package androidx.media3.decoder;

import androidx.annotation.CallSuper;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
public abstract class DecoderOutputBuffer extends Buffer {
    public long X;
    public int Y;
    public boolean Z;

    public interface Owner<S extends DecoderOutputBuffer> {
        void a(S s);
    }

    @CallSuper
    public void g() {
        super.g();
        this.X = 0;
        this.Y = 0;
        this.Z = false;
    }

    public abstract void q();
}
