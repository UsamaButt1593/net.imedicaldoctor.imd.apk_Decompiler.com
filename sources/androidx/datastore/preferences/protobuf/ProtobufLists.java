package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;

final class ProtobufLists {
    private ProtobufLists() {
    }

    public static Internal.BooleanList a() {
        return BooleanArrayList.h();
    }

    public static Internal.DoubleList b() {
        return DoubleArrayList.h();
    }

    public static Internal.FloatList c() {
        return FloatArrayList.h();
    }

    public static Internal.IntList d() {
        return IntArrayList.h();
    }

    public static Internal.LongList e() {
        return LongArrayList.h();
    }

    public static <E> Internal.ProtobufList<E> f() {
        return ProtobufArrayList.d();
    }

    public static <E> Internal.ProtobufList<E> g(Internal.ProtobufList<E> protobufList) {
        int size = protobufList.size();
        return protobufList.f(size == 0 ? 10 : size * 2);
    }

    public static Internal.BooleanList h() {
        return new BooleanArrayList();
    }

    public static Internal.DoubleList i() {
        return new DoubleArrayList();
    }

    public static Internal.FloatList j() {
        return new FloatArrayList();
    }

    public static Internal.IntList k() {
        return new IntArrayList();
    }

    public static Internal.LongList l() {
        return new LongArrayList();
    }
}
