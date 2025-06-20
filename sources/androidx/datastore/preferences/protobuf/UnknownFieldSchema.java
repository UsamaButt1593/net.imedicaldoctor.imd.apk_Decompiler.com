package androidx.datastore.preferences.protobuf;

import java.io.IOException;

abstract class UnknownFieldSchema<T, B> {
    UnknownFieldSchema() {
    }

    /* access modifiers changed from: package-private */
    public abstract void a(B b2, int i2, int i3);

    /* access modifiers changed from: package-private */
    public abstract void b(B b2, int i2, long j2);

    /* access modifiers changed from: package-private */
    public abstract void c(B b2, int i2, T t);

    /* access modifiers changed from: package-private */
    public abstract void d(B b2, int i2, ByteString byteString);

    /* access modifiers changed from: package-private */
    public abstract void e(B b2, int i2, long j2);

    /* access modifiers changed from: package-private */
    public abstract B f(Object obj);

    /* access modifiers changed from: package-private */
    public abstract T g(Object obj);

    /* access modifiers changed from: package-private */
    public abstract int h(T t);

    /* access modifiers changed from: package-private */
    public abstract int i(T t);

    /* access modifiers changed from: package-private */
    public abstract void j(Object obj);

    /* access modifiers changed from: package-private */
    public abstract T k(T t, T t2);

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:3:0x000d, LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void l(B r3, androidx.datastore.preferences.protobuf.Reader r4) throws java.io.IOException {
        /*
            r2 = this;
        L_0x0000:
            int r0 = r4.C()
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r0 == r1) goto L_0x000f
            boolean r0 = r2.m(r3, r4)
            if (r0 != 0) goto L_0x0000
        L_0x000f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.UnknownFieldSchema.l(java.lang.Object, androidx.datastore.preferences.protobuf.Reader):void");
    }

    /* access modifiers changed from: package-private */
    public final boolean m(B b2, Reader reader) throws IOException {
        int n2 = reader.n();
        int a2 = WireFormat.a(n2);
        int b3 = WireFormat.b(n2);
        if (b3 == 0) {
            e(b2, a2, reader.P());
            return true;
        } else if (b3 == 1) {
            b(b2, a2, reader.d());
            return true;
        } else if (b3 == 2) {
            d(b2, a2, reader.F());
            return true;
        } else if (b3 == 3) {
            Object n3 = n();
            int c2 = WireFormat.c(a2, 4);
            l(n3, reader);
            if (c2 == reader.n()) {
                c(b2, a2, r(n3));
                return true;
            }
            throw InvalidProtocolBufferException.b();
        } else if (b3 == 4) {
            return false;
        } else {
            if (b3 == 5) {
                a(b2, a2, reader.j());
                return true;
            }
            throw InvalidProtocolBufferException.e();
        }
    }

    /* access modifiers changed from: package-private */
    public abstract B n();

    /* access modifiers changed from: package-private */
    public abstract void o(Object obj, B b2);

    /* access modifiers changed from: package-private */
    public abstract void p(Object obj, T t);

    /* access modifiers changed from: package-private */
    public abstract boolean q(Reader reader);

    /* access modifiers changed from: package-private */
    public abstract T r(B b2);

    /* access modifiers changed from: package-private */
    public abstract void s(T t, Writer writer) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void t(T t, Writer writer) throws IOException;
}
