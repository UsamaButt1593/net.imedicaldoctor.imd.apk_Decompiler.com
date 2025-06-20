package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public class BaseVector {

    /* renamed from: a  reason: collision with root package name */
    private int f7689a;

    /* renamed from: b  reason: collision with root package name */
    private int f7690b;

    /* renamed from: c  reason: collision with root package name */
    private int f7691c;

    /* renamed from: d  reason: collision with root package name */
    protected ByteBuffer f7692d;

    /* access modifiers changed from: protected */
    public int a(int i2) {
        return this.f7689a + (i2 * this.f7691c);
    }

    /* access modifiers changed from: protected */
    public void b(int i2, int i3, ByteBuffer byteBuffer) {
        this.f7692d = byteBuffer;
        if (byteBuffer != null) {
            this.f7689a = i2;
            this.f7690b = byteBuffer.getInt(i2 - 4);
            this.f7691c = i3;
            return;
        }
        this.f7689a = 0;
        this.f7690b = 0;
        this.f7691c = 0;
    }

    /* access modifiers changed from: protected */
    public int c() {
        return this.f7689a;
    }

    public int d() {
        return this.f7690b;
    }

    public void e() {
        b(0, 0, (ByteBuffer) null);
    }
}
