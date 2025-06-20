package androidx.datastore.preferences.protobuf;

import java.io.IOException;

class UnknownFieldSetLiteSchema extends UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> {
    UnknownFieldSetLiteSchema() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: A */
    public UnknownFieldSetLite g(Object obj) {
        return ((GeneratedMessageLite) obj).unknownFields;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: B */
    public int h(UnknownFieldSetLite unknownFieldSetLite) {
        return unknownFieldSetLite.f();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: C */
    public int i(UnknownFieldSetLite unknownFieldSetLite) {
        return unknownFieldSetLite.g();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: D */
    public UnknownFieldSetLite k(UnknownFieldSetLite unknownFieldSetLite, UnknownFieldSetLite unknownFieldSetLite2) {
        return unknownFieldSetLite2.equals(UnknownFieldSetLite.e()) ? unknownFieldSetLite : UnknownFieldSetLite.o(unknownFieldSetLite, unknownFieldSetLite2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: E */
    public UnknownFieldSetLite n() {
        return UnknownFieldSetLite.p();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: F */
    public void o(Object obj, UnknownFieldSetLite unknownFieldSetLite) {
        p(obj, unknownFieldSetLite);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: G */
    public void p(Object obj, UnknownFieldSetLite unknownFieldSetLite) {
        ((GeneratedMessageLite) obj).unknownFields = unknownFieldSetLite;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: H */
    public UnknownFieldSetLite r(UnknownFieldSetLite unknownFieldSetLite) {
        unknownFieldSetLite.j();
        return unknownFieldSetLite;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: I */
    public void s(UnknownFieldSetLite unknownFieldSetLite, Writer writer) throws IOException {
        unknownFieldSetLite.t(writer);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: J */
    public void t(UnknownFieldSetLite unknownFieldSetLite, Writer writer) throws IOException {
        unknownFieldSetLite.w(writer);
    }

    /* access modifiers changed from: package-private */
    public void j(Object obj) {
        g(obj).j();
    }

    /* access modifiers changed from: package-private */
    public boolean q(Reader reader) {
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: u */
    public void a(UnknownFieldSetLite unknownFieldSetLite, int i2, int i3) {
        unknownFieldSetLite.r(WireFormat.c(i2, 5), Integer.valueOf(i3));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: v */
    public void b(UnknownFieldSetLite unknownFieldSetLite, int i2, long j2) {
        unknownFieldSetLite.r(WireFormat.c(i2, 1), Long.valueOf(j2));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: w */
    public void c(UnknownFieldSetLite unknownFieldSetLite, int i2, UnknownFieldSetLite unknownFieldSetLite2) {
        unknownFieldSetLite.r(WireFormat.c(i2, 3), unknownFieldSetLite2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: x */
    public void d(UnknownFieldSetLite unknownFieldSetLite, int i2, ByteString byteString) {
        unknownFieldSetLite.r(WireFormat.c(i2, 2), byteString);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: y */
    public void e(UnknownFieldSetLite unknownFieldSetLite, int i2, long j2) {
        unknownFieldSetLite.r(WireFormat.c(i2, 0), Long.valueOf(j2));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: z */
    public UnknownFieldSetLite f(Object obj) {
        UnknownFieldSetLite A = g(obj);
        if (A != UnknownFieldSetLite.e()) {
            return A;
        }
        UnknownFieldSetLite p = UnknownFieldSetLite.p();
        p(obj, p);
        return p;
    }
}
