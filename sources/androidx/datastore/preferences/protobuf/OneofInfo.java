package androidx.datastore.preferences.protobuf;

import java.lang.reflect.Field;

final class OneofInfo {

    /* renamed from: a  reason: collision with root package name */
    private final int f7228a;

    /* renamed from: b  reason: collision with root package name */
    private final Field f7229b;

    /* renamed from: c  reason: collision with root package name */
    private final Field f7230c;

    public OneofInfo(int i2, Field field, Field field2) {
        this.f7228a = i2;
        this.f7229b = field;
        this.f7230c = field2;
    }

    public Field a() {
        return this.f7229b;
    }

    public int b() {
        return this.f7228a;
    }

    public Field c() {
        return this.f7230c;
    }
}
