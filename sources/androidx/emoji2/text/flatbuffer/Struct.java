package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public class Struct {

    /* renamed from: a  reason: collision with root package name */
    protected int f7770a;

    /* renamed from: b  reason: collision with root package name */
    protected ByteBuffer f7771b;

    public void a() {
        b(0, (ByteBuffer) null);
    }

    /* access modifiers changed from: protected */
    public void b(int i2, ByteBuffer byteBuffer) {
        this.f7771b = byteBuffer;
        if (byteBuffer == null) {
            i2 = 0;
        }
        this.f7770a = i2;
    }
}
