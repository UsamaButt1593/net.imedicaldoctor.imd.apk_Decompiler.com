package androidx.datastore.preferences.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class StructuralMessageInfo implements MessageInfo {

    /* renamed from: a  reason: collision with root package name */
    private final ProtoSyntax f7253a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f7254b;

    /* renamed from: c  reason: collision with root package name */
    private final int[] f7255c;

    /* renamed from: d  reason: collision with root package name */
    private final FieldInfo[] f7256d;

    /* renamed from: e  reason: collision with root package name */
    private final MessageLite f7257e;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final List<FieldInfo> f7258a;

        /* renamed from: b  reason: collision with root package name */
        private ProtoSyntax f7259b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f7260c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f7261d;

        /* renamed from: e  reason: collision with root package name */
        private int[] f7262e;

        /* renamed from: f  reason: collision with root package name */
        private Object f7263f;

        public Builder() {
            this.f7262e = null;
            this.f7258a = new ArrayList();
        }

        public StructuralMessageInfo a() {
            if (this.f7260c) {
                throw new IllegalStateException("Builder can only build once");
            } else if (this.f7259b != null) {
                this.f7260c = true;
                Collections.sort(this.f7258a);
                return new StructuralMessageInfo(this.f7259b, this.f7261d, this.f7262e, (FieldInfo[]) this.f7258a.toArray(new FieldInfo[0]), this.f7263f);
            } else {
                throw new IllegalStateException("Must specify a proto syntax");
            }
        }

        public void b(int[] iArr) {
            this.f7262e = iArr;
        }

        public void c(Object obj) {
            this.f7263f = obj;
        }

        public void d(FieldInfo fieldInfo) {
            if (!this.f7260c) {
                this.f7258a.add(fieldInfo);
                return;
            }
            throw new IllegalStateException("Builder can only build once");
        }

        public void e(boolean z) {
            this.f7261d = z;
        }

        public void f(ProtoSyntax protoSyntax) {
            this.f7259b = (ProtoSyntax) Internal.e(protoSyntax, "syntax");
        }

        public Builder(int i2) {
            this.f7262e = null;
            this.f7258a = new ArrayList(i2);
        }
    }

    StructuralMessageInfo(ProtoSyntax protoSyntax, boolean z, int[] iArr, FieldInfo[] fieldInfoArr, Object obj) {
        this.f7253a = protoSyntax;
        this.f7254b = z;
        this.f7255c = iArr;
        this.f7256d = fieldInfoArr;
        this.f7257e = (MessageLite) Internal.e(obj, "defaultInstance");
    }

    public static Builder e() {
        return new Builder();
    }

    public static Builder g(int i2) {
        return new Builder(i2);
    }

    public boolean a() {
        return this.f7254b;
    }

    public MessageLite b() {
        return this.f7257e;
    }

    public int[] c() {
        return this.f7255c;
    }

    public FieldInfo[] d() {
        return this.f7256d;
    }

    public ProtoSyntax f() {
        return this.f7253a;
    }
}
