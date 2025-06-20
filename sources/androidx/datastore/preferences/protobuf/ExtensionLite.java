package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.MessageLite;
import androidx.datastore.preferences.protobuf.WireFormat;

public abstract class ExtensionLite<ContainingType extends MessageLite, Type> {
    public abstract Type a();

    public abstract WireFormat.FieldType b();

    public abstract MessageLite c();

    public abstract int d();

    /* access modifiers changed from: package-private */
    public boolean e() {
        return true;
    }

    public abstract boolean f();
}
