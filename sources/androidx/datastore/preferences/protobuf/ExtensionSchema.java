package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.FieldSet;
import androidx.datastore.preferences.protobuf.FieldSet.FieldDescriptorLite;
import java.io.IOException;
import java.util.Map;

abstract class ExtensionSchema<T extends FieldSet.FieldDescriptorLite<T>> {
    ExtensionSchema() {
    }

    /* access modifiers changed from: package-private */
    public abstract int a(Map.Entry<?, ?> entry);

    /* access modifiers changed from: package-private */
    public abstract Object b(ExtensionRegistryLite extensionRegistryLite, MessageLite messageLite, int i2);

    /* access modifiers changed from: package-private */
    public abstract FieldSet<T> c(Object obj);

    /* access modifiers changed from: package-private */
    public abstract FieldSet<T> d(Object obj);

    /* access modifiers changed from: package-private */
    public abstract boolean e(MessageLite messageLite);

    /* access modifiers changed from: package-private */
    public abstract void f(Object obj);

    /* access modifiers changed from: package-private */
    public abstract <UT, UB> UB g(Reader reader, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<T> fieldSet, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void h(Reader reader, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<T> fieldSet) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void i(ByteString byteString, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<T> fieldSet) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void j(Writer writer, Map.Entry<?, ?> entry) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void k(Object obj, FieldSet<T> fieldSet);
}
