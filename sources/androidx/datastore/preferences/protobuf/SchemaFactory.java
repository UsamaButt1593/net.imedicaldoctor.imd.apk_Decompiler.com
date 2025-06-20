package androidx.datastore.preferences.protobuf;

interface SchemaFactory {
    <T> Schema<T> a(Class<T> cls);
}
