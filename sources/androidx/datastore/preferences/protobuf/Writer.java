package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.MapEntryLite;
import java.io.IOException;
import java.util.List;
import java.util.Map;

interface Writer {

    public enum FieldOrder {
        ASCENDING,
        DESCENDING
    }

    void A(int i2, long j2) throws IOException;

    void B(int i2, List<Integer> list, boolean z) throws IOException;

    void C(int i2, Object obj, Schema schema) throws IOException;

    void D(int i2, List<Boolean> list, boolean z) throws IOException;

    @Deprecated
    void E(int i2, Object obj) throws IOException;

    void F(int i2, List<Integer> list, boolean z) throws IOException;

    void G(int i2, List<Long> list, boolean z) throws IOException;

    void H(int i2, long j2) throws IOException;

    void I(int i2, float f2) throws IOException;

    @Deprecated
    void J(int i2) throws IOException;

    void K(int i2, List<Integer> list, boolean z) throws IOException;

    void L(int i2, int i3) throws IOException;

    void M(int i2, List<Long> list, boolean z) throws IOException;

    void N(int i2, List<Integer> list, boolean z) throws IOException;

    void O(int i2, List<Double> list, boolean z) throws IOException;

    <K, V> void P(int i2, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) throws IOException;

    void Q(int i2, int i3) throws IOException;

    void R(int i2, List<ByteString> list) throws IOException;

    @Deprecated
    void S(int i2, Object obj, Schema schema) throws IOException;

    void a(int i2, List<Float> list, boolean z) throws IOException;

    void b(int i2, int i3) throws IOException;

    void c(int i2, Object obj) throws IOException;

    void d(int i2, int i3) throws IOException;

    void e(int i2, double d2) throws IOException;

    void f(int i2, List<Long> list, boolean z) throws IOException;

    void g(int i2, List<Long> list, boolean z) throws IOException;

    @Deprecated
    void h(int i2, List<?> list) throws IOException;

    void i(int i2, long j2) throws IOException;

    FieldOrder j();

    void k(int i2, List<?> list, Schema schema) throws IOException;

    void l(int i2, List<String> list) throws IOException;

    @Deprecated
    void m(int i2, List<?> list, Schema schema) throws IOException;

    void n(int i2, List<?> list) throws IOException;

    void o(int i2, String str) throws IOException;

    void p(int i2, long j2) throws IOException;

    void q(int i2, Object obj) throws IOException;

    void r(int i2, List<Integer> list, boolean z) throws IOException;

    void s(int i2, long j2) throws IOException;

    void t(int i2, boolean z) throws IOException;

    void u(int i2, int i3) throws IOException;

    @Deprecated
    void v(int i2) throws IOException;

    void w(int i2, int i3) throws IOException;

    void x(int i2, List<Long> list, boolean z) throws IOException;

    void y(int i2, List<Integer> list, boolean z) throws IOException;

    void z(int i2, ByteString byteString) throws IOException;
}
