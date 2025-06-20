package androidx.datastore.preferences.protobuf;

import java.io.IOException;

public class LazyFieldLite {

    /* renamed from: e  reason: collision with root package name */
    private static final ExtensionRegistryLite f7175e = ExtensionRegistryLite.d();

    /* renamed from: a  reason: collision with root package name */
    private ByteString f7176a;

    /* renamed from: b  reason: collision with root package name */
    private ExtensionRegistryLite f7177b;

    /* renamed from: c  reason: collision with root package name */
    protected volatile MessageLite f7178c;

    /* renamed from: d  reason: collision with root package name */
    private volatile ByteString f7179d;

    public LazyFieldLite() {
    }

    private static void a(ExtensionRegistryLite extensionRegistryLite, ByteString byteString) {
        if (extensionRegistryLite == null) {
            throw new NullPointerException("found null ExtensionRegistry");
        } else if (byteString == null) {
            throw new NullPointerException("found null ByteString");
        }
    }

    public static LazyFieldLite e(MessageLite messageLite) {
        LazyFieldLite lazyFieldLite = new LazyFieldLite();
        lazyFieldLite.m(messageLite);
        return lazyFieldLite;
    }

    private static MessageLite j(MessageLite messageLite, ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        try {
            return messageLite.E().F2(byteString, extensionRegistryLite).build();
        } catch (InvalidProtocolBufferException unused) {
            return messageLite;
        }
    }

    public void b() {
        this.f7176a = null;
        this.f7178c = null;
        this.f7179d = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r2.f7176a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean c() {
        /*
            r2 = this;
            androidx.datastore.preferences.protobuf.ByteString r0 = r2.f7179d
            androidx.datastore.preferences.protobuf.ByteString r1 = androidx.datastore.preferences.protobuf.ByteString.X2
            if (r0 == r1) goto L_0x0013
            androidx.datastore.preferences.protobuf.MessageLite r0 = r2.f7178c
            if (r0 != 0) goto L_0x0011
            androidx.datastore.preferences.protobuf.ByteString r0 = r2.f7176a
            if (r0 == 0) goto L_0x0013
            if (r0 != r1) goto L_0x0011
            goto L_0x0013
        L_0x0011:
            r0 = 0
            goto L_0x0014
        L_0x0013:
            r0 = 1
        L_0x0014:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.LazyFieldLite.c():boolean");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:16|17) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r3.f7178c = r4;
        r3.f7179d = androidx.datastore.preferences.protobuf.ByteString.X2;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x002c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(androidx.datastore.preferences.protobuf.MessageLite r4) {
        /*
            r3 = this;
            androidx.datastore.preferences.protobuf.MessageLite r0 = r3.f7178c
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r3)
            androidx.datastore.preferences.protobuf.MessageLite r0 = r3.f7178c     // Catch:{ all -> 0x000c }
            if (r0 == 0) goto L_0x000e
            monitor-exit(r3)     // Catch:{ all -> 0x000c }
            return
        L_0x000c:
            r4 = move-exception
            goto L_0x0034
        L_0x000e:
            androidx.datastore.preferences.protobuf.ByteString r0 = r3.f7176a     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            if (r0 == 0) goto L_0x0027
            androidx.datastore.preferences.protobuf.Parser r0 = r4.q2()     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            androidx.datastore.preferences.protobuf.ByteString r1 = r3.f7176a     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            androidx.datastore.preferences.protobuf.ExtensionRegistryLite r2 = r3.f7177b     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            java.lang.Object r0 = r0.d(r1, r2)     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            androidx.datastore.preferences.protobuf.MessageLite r0 = (androidx.datastore.preferences.protobuf.MessageLite) r0     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            r3.f7178c = r0     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            androidx.datastore.preferences.protobuf.ByteString r0 = r3.f7176a     // Catch:{ InvalidProtocolBufferException -> 0x002c }
        L_0x0024:
            r3.f7179d = r0     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            goto L_0x0032
        L_0x0027:
            r3.f7178c = r4     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            androidx.datastore.preferences.protobuf.ByteString r0 = androidx.datastore.preferences.protobuf.ByteString.X2     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            goto L_0x0024
        L_0x002c:
            r3.f7178c = r4     // Catch:{ all -> 0x000c }
            androidx.datastore.preferences.protobuf.ByteString r4 = androidx.datastore.preferences.protobuf.ByteString.X2     // Catch:{ all -> 0x000c }
            r3.f7179d = r4     // Catch:{ all -> 0x000c }
        L_0x0032:
            monitor-exit(r3)     // Catch:{ all -> 0x000c }
            return
        L_0x0034:
            monitor-exit(r3)     // Catch:{ all -> 0x000c }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.LazyFieldLite.d(androidx.datastore.preferences.protobuf.MessageLite):void");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LazyFieldLite)) {
            return false;
        }
        LazyFieldLite lazyFieldLite = (LazyFieldLite) obj;
        MessageLite messageLite = this.f7178c;
        MessageLite messageLite2 = lazyFieldLite.f7178c;
        return (messageLite == null && messageLite2 == null) ? n().equals(lazyFieldLite.n()) : (messageLite == null || messageLite2 == null) ? messageLite != null ? messageLite.equals(lazyFieldLite.g(messageLite.D())) : g(messageLite2.D()).equals(messageLite2) : messageLite.equals(messageLite2);
    }

    public int f() {
        if (this.f7179d != null) {
            return this.f7179d.size();
        }
        ByteString byteString = this.f7176a;
        if (byteString != null) {
            return byteString.size();
        }
        if (this.f7178c != null) {
            return this.f7178c.R0();
        }
        return 0;
    }

    public MessageLite g(MessageLite messageLite) {
        d(messageLite);
        return this.f7178c;
    }

    public void h(LazyFieldLite lazyFieldLite) {
        ByteString byteString;
        if (!lazyFieldLite.c()) {
            if (c()) {
                k(lazyFieldLite);
                return;
            }
            if (this.f7177b == null) {
                this.f7177b = lazyFieldLite.f7177b;
            }
            ByteString byteString2 = this.f7176a;
            if (byteString2 != null && (byteString = lazyFieldLite.f7176a) != null) {
                this.f7176a = byteString2.m(byteString);
            } else if (this.f7178c == null && lazyFieldLite.f7178c != null) {
                m(j(lazyFieldLite.f7178c, this.f7176a, this.f7177b));
            } else if (this.f7178c == null || lazyFieldLite.f7178c != null) {
                m(this.f7178c.E().P(lazyFieldLite.f7178c).build());
            } else {
                m(j(this.f7178c, lazyFieldLite.f7176a, lazyFieldLite.f7177b));
            }
        }
    }

    public int hashCode() {
        return 1;
    }

    public void i(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        ByteString m2;
        if (c()) {
            m2 = codedInputStream.x();
        } else {
            if (this.f7177b == null) {
                this.f7177b = extensionRegistryLite;
            }
            ByteString byteString = this.f7176a;
            if (byteString != null) {
                m2 = byteString.m(codedInputStream.x());
                extensionRegistryLite = this.f7177b;
            } else {
                try {
                    m(this.f7178c.E().Q1(codedInputStream, extensionRegistryLite).build());
                    return;
                } catch (InvalidProtocolBufferException unused) {
                    return;
                }
            }
        }
        l(m2, extensionRegistryLite);
    }

    public void k(LazyFieldLite lazyFieldLite) {
        this.f7176a = lazyFieldLite.f7176a;
        this.f7178c = lazyFieldLite.f7178c;
        this.f7179d = lazyFieldLite.f7179d;
        ExtensionRegistryLite extensionRegistryLite = lazyFieldLite.f7177b;
        if (extensionRegistryLite != null) {
            this.f7177b = extensionRegistryLite;
        }
    }

    public void l(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        a(extensionRegistryLite, byteString);
        this.f7176a = byteString;
        this.f7177b = extensionRegistryLite;
        this.f7178c = null;
        this.f7179d = null;
    }

    public MessageLite m(MessageLite messageLite) {
        MessageLite messageLite2 = this.f7178c;
        this.f7176a = null;
        this.f7179d = null;
        this.f7178c = messageLite;
        return messageLite2;
    }

    public ByteString n() {
        if (this.f7179d != null) {
            return this.f7179d;
        }
        ByteString byteString = this.f7176a;
        if (byteString != null) {
            return byteString;
        }
        synchronized (this) {
            try {
                if (this.f7179d != null) {
                    ByteString byteString2 = this.f7179d;
                    return byteString2;
                }
                this.f7179d = this.f7178c == null ? ByteString.X2 : this.f7178c.q0();
                ByteString byteString3 = this.f7179d;
                return byteString3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void o(Writer writer, int i2) throws IOException {
        ByteString byteString;
        if (this.f7179d != null) {
            byteString = this.f7179d;
        } else {
            byteString = this.f7176a;
            if (byteString == null) {
                if (this.f7178c != null) {
                    writer.q(i2, this.f7178c);
                    return;
                }
                byteString = ByteString.X2;
            }
        }
        writer.z(i2, byteString);
    }

    public LazyFieldLite(ExtensionRegistryLite extensionRegistryLite, ByteString byteString) {
        a(extensionRegistryLite, byteString);
        this.f7177b = extensionRegistryLite;
        this.f7176a = byteString;
    }
}
