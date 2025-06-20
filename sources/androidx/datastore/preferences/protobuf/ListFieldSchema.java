package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;
import java.util.Collections;
import java.util.List;

abstract class ListFieldSchema {

    /* renamed from: a  reason: collision with root package name */
    private static final ListFieldSchema f7180a = new ListFieldSchemaFull();

    /* renamed from: b  reason: collision with root package name */
    private static final ListFieldSchema f7181b = new ListFieldSchemaLite();

    private static final class ListFieldSchemaFull extends ListFieldSchema {

        /* renamed from: c  reason: collision with root package name */
        private static final Class<?> f7182c = Collections.unmodifiableList(Collections.emptyList()).getClass();

        private ListFieldSchemaFull() {
            super();
        }

        static <E> List<E> f(Object obj, long j2) {
            return (List) UnsafeUtil.O(obj, j2);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: androidx.datastore.preferences.protobuf.LazyStringArrayList} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.util.ArrayList} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: androidx.datastore.preferences.protobuf.LazyStringArrayList} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: androidx.datastore.preferences.protobuf.LazyStringArrayList} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static <L> java.util.List<L> g(java.lang.Object r3, long r4, int r6) {
            /*
                java.util.List r0 = f(r3, r4)
                boolean r1 = r0.isEmpty()
                if (r1 == 0) goto L_0x002d
                boolean r1 = r0 instanceof androidx.datastore.preferences.protobuf.LazyStringList
                if (r1 == 0) goto L_0x0014
                androidx.datastore.preferences.protobuf.LazyStringArrayList r0 = new androidx.datastore.preferences.protobuf.LazyStringArrayList
                r0.<init>((int) r6)
                goto L_0x0029
            L_0x0014:
                boolean r1 = r0 instanceof androidx.datastore.preferences.protobuf.PrimitiveNonBoxingCollection
                if (r1 == 0) goto L_0x0024
                boolean r1 = r0 instanceof androidx.datastore.preferences.protobuf.Internal.ProtobufList
                if (r1 == 0) goto L_0x0024
                androidx.datastore.preferences.protobuf.Internal$ProtobufList r0 = (androidx.datastore.preferences.protobuf.Internal.ProtobufList) r0
                androidx.datastore.preferences.protobuf.Internal$ProtobufList r6 = r0.f(r6)
                r0 = r6
                goto L_0x0029
            L_0x0024:
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>(r6)
            L_0x0029:
                androidx.datastore.preferences.protobuf.UnsafeUtil.q0(r3, r4, r0)
                goto L_0x007a
            L_0x002d:
                java.lang.Class<?> r1 = f7182c
                java.lang.Class r2 = r0.getClass()
                boolean r1 = r1.isAssignableFrom(r2)
                if (r1 == 0) goto L_0x004b
                java.util.ArrayList r1 = new java.util.ArrayList
                int r2 = r0.size()
                int r2 = r2 + r6
                r1.<init>(r2)
                r1.addAll(r0)
            L_0x0046:
                androidx.datastore.preferences.protobuf.UnsafeUtil.q0(r3, r4, r1)
                r0 = r1
                goto L_0x007a
            L_0x004b:
                boolean r1 = r0 instanceof androidx.datastore.preferences.protobuf.UnmodifiableLazyStringList
                if (r1 == 0) goto L_0x005f
                androidx.datastore.preferences.protobuf.LazyStringArrayList r1 = new androidx.datastore.preferences.protobuf.LazyStringArrayList
                int r2 = r0.size()
                int r2 = r2 + r6
                r1.<init>((int) r2)
                androidx.datastore.preferences.protobuf.UnmodifiableLazyStringList r0 = (androidx.datastore.preferences.protobuf.UnmodifiableLazyStringList) r0
                r1.addAll(r0)
                goto L_0x0046
            L_0x005f:
                boolean r1 = r0 instanceof androidx.datastore.preferences.protobuf.PrimitiveNonBoxingCollection
                if (r1 == 0) goto L_0x007a
                boolean r1 = r0 instanceof androidx.datastore.preferences.protobuf.Internal.ProtobufList
                if (r1 == 0) goto L_0x007a
                r1 = r0
                androidx.datastore.preferences.protobuf.Internal$ProtobufList r1 = (androidx.datastore.preferences.protobuf.Internal.ProtobufList) r1
                boolean r2 = r1.P2()
                if (r2 != 0) goto L_0x007a
                int r0 = r0.size()
                int r0 = r0 + r6
                androidx.datastore.preferences.protobuf.Internal$ProtobufList r0 = r1.f(r0)
                goto L_0x0029
            L_0x007a:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.ListFieldSchema.ListFieldSchemaFull.g(java.lang.Object, long, int):java.util.List");
        }

        /* access modifiers changed from: package-private */
        public void c(Object obj, long j2) {
            Object obj2;
            List list = (List) UnsafeUtil.O(obj, j2);
            if (list instanceof LazyStringList) {
                obj2 = ((LazyStringList) list).e2();
            } else if (!f7182c.isAssignableFrom(list.getClass())) {
                if (!(list instanceof PrimitiveNonBoxingCollection) || !(list instanceof Internal.ProtobufList)) {
                    obj2 = Collections.unmodifiableList(list);
                } else {
                    Internal.ProtobufList protobufList = (Internal.ProtobufList) list;
                    if (protobufList.P2()) {
                        protobufList.S();
                        return;
                    }
                    return;
                }
            } else {
                return;
            }
            UnsafeUtil.q0(obj, j2, obj2);
        }

        /* access modifiers changed from: package-private */
        public <E> void d(Object obj, Object obj2, long j2) {
            List f2 = f(obj2, j2);
            List g2 = g(obj, j2, f2.size());
            int size = g2.size();
            int size2 = f2.size();
            if (size > 0 && size2 > 0) {
                g2.addAll(f2);
            }
            if (size > 0) {
                f2 = g2;
            }
            UnsafeUtil.q0(obj, j2, f2);
        }

        /* access modifiers changed from: package-private */
        public <L> List<L> e(Object obj, long j2) {
            return g(obj, j2, 10);
        }
    }

    private static final class ListFieldSchemaLite extends ListFieldSchema {
        private ListFieldSchemaLite() {
            super();
        }

        static <E> Internal.ProtobufList<E> f(Object obj, long j2) {
            return (Internal.ProtobufList) UnsafeUtil.O(obj, j2);
        }

        /* access modifiers changed from: package-private */
        public void c(Object obj, long j2) {
            f(obj, j2).S();
        }

        /* access modifiers changed from: package-private */
        public <E> void d(Object obj, Object obj2, long j2) {
            Internal.ProtobufList f2 = f(obj, j2);
            Internal.ProtobufList f3 = f(obj2, j2);
            int size = f2.size();
            int size2 = f3.size();
            if (size > 0 && size2 > 0) {
                if (!f2.P2()) {
                    f2 = f2.f(size2 + size);
                }
                f2.addAll(f3);
            }
            if (size > 0) {
                f3 = f2;
            }
            UnsafeUtil.q0(obj, j2, f3);
        }

        /* access modifiers changed from: package-private */
        public <L> List<L> e(Object obj, long j2) {
            Internal.ProtobufList f2 = f(obj, j2);
            if (f2.P2()) {
                return f2;
            }
            int size = f2.size();
            Internal.ProtobufList f3 = f2.f(size == 0 ? 10 : size * 2);
            UnsafeUtil.q0(obj, j2, f3);
            return f3;
        }
    }

    private ListFieldSchema() {
    }

    static ListFieldSchema a() {
        return f7180a;
    }

    static ListFieldSchema b() {
        return f7181b;
    }

    /* access modifiers changed from: package-private */
    public abstract void c(Object obj, long j2);

    /* access modifiers changed from: package-private */
    public abstract <L> void d(Object obj, Object obj2, long j2);

    /* access modifiers changed from: package-private */
    public abstract <L> List<L> e(Object obj, long j2);
}
