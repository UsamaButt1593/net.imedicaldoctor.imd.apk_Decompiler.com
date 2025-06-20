package androidx.datastore.preferences.protobuf;

final class RawMessageInfo implements MessageInfo {

    /* renamed from: a  reason: collision with root package name */
    private final MessageLite f7235a;

    /* renamed from: b  reason: collision with root package name */
    private final String f7236b;

    /* renamed from: c  reason: collision with root package name */
    private final Object[] f7237c;

    /* renamed from: d  reason: collision with root package name */
    private final int f7238d;

    RawMessageInfo(MessageLite messageLite, String str, Object[] objArr) {
        char charAt;
        this.f7235a = messageLite;
        this.f7236b = str;
        this.f7237c = objArr;
        char charAt2 = str.charAt(0);
        if (charAt2 >= 55296) {
            char c2 = charAt2 & 8191;
            int i2 = 13;
            int i3 = 1;
            while (true) {
                int i4 = i3 + 1;
                charAt = str.charAt(i3);
                if (charAt < 55296) {
                    break;
                }
                c2 |= (charAt & 8191) << i2;
                i2 += 13;
                i3 = i4;
            }
            charAt2 = c2 | (charAt << i2);
        }
        this.f7238d = charAt2;
    }

    public boolean a() {
        return (this.f7238d & 2) == 2;
    }

    public MessageLite b() {
        return this.f7235a;
    }

    /* access modifiers changed from: package-private */
    public Object[] c() {
        return this.f7237c;
    }

    /* access modifiers changed from: package-private */
    public String d() {
        return this.f7236b;
    }

    public ProtoSyntax f() {
        return (this.f7238d & 1) == 1 ? ProtoSyntax.PROTO2 : ProtoSyntax.PROTO3;
    }
}
