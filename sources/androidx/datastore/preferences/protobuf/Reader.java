package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.MapEntryLite;
import java.io.IOException;
import java.util.List;
import java.util.Map;

interface Reader {

    /* renamed from: a  reason: collision with root package name */
    public static final int f7239a = Integer.MAX_VALUE;

    /* renamed from: b  reason: collision with root package name */
    public static final int f7240b = 0;

    void A(List<Boolean> list) throws IOException;

    String B() throws IOException;

    int C() throws IOException;

    void D(List<String> list) throws IOException;

    void E(List<String> list) throws IOException;

    ByteString F() throws IOException;

    void G(List<Float> list) throws IOException;

    int H() throws IOException;

    @Deprecated
    <T> void I(List<T> list, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    boolean J();

    boolean K() throws IOException;

    int L() throws IOException;

    void M(List<ByteString> list) throws IOException;

    void N(List<Double> list) throws IOException;

    <T> void O(List<T> list, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    long P() throws IOException;

    String Q() throws IOException;

    void R(List<Long> list) throws IOException;

    @Deprecated
    <T> T S(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    <T> T a(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    void b(List<Integer> list) throws IOException;

    long c() throws IOException;

    long d() throws IOException;

    <T> T e(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    @Deprecated
    <T> void f(List<T> list, Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    void g(List<Integer> list) throws IOException;

    void h(List<Long> list) throws IOException;

    void i(List<Integer> list) throws IOException;

    int j() throws IOException;

    boolean k() throws IOException;

    long l() throws IOException;

    void m(List<Long> list) throws IOException;

    int n();

    @Deprecated
    <T> T o(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    <T> void p(List<T> list, Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    int q() throws IOException;

    void r(List<Long> list) throws IOException;

    double readDouble() throws IOException;

    float readFloat() throws IOException;

    void s(List<Long> list) throws IOException;

    void t(List<Integer> list) throws IOException;

    void u(List<Integer> list) throws IOException;

    <K, V> void v(Map<K, V> map, MapEntryLite.Metadata<K, V> metadata, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    int w() throws IOException;

    void x(List<Integer> list) throws IOException;

    int y() throws IOException;

    long z() throws IOException;
}
