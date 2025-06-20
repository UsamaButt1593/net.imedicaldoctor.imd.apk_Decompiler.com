package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public class LazyStringArrayList extends AbstractProtobufList<String> implements LazyStringList, RandomAccess {
    public static final LazyStringList X2;
    private static final LazyStringArrayList Z;
    private final List<Object> Y;

    private static class ByteArrayListView extends AbstractList<byte[]> implements RandomAccess {
        private final LazyStringArrayList s;

        ByteArrayListView(LazyStringArrayList lazyStringArrayList) {
            this.s = lazyStringArrayList;
        }

        /* renamed from: b */
        public void add(int i2, byte[] bArr) {
            this.s.o(i2, bArr);
            this.modCount++;
        }

        /* renamed from: c */
        public byte[] get(int i2) {
            return this.s.K0(i2);
        }

        /* renamed from: d */
        public byte[] remove(int i2) {
            String C = this.s.remove(i2);
            this.modCount++;
            return LazyStringArrayList.q(C);
        }

        /* renamed from: g */
        public byte[] set(int i2, byte[] bArr) {
            Object c2 = this.s.G(i2, bArr);
            this.modCount++;
            return LazyStringArrayList.q(c2);
        }

        public int size() {
            return this.s.size();
        }
    }

    private static class ByteStringListView extends AbstractList<ByteString> implements RandomAccess {
        private final LazyStringArrayList s;

        ByteStringListView(LazyStringArrayList lazyStringArrayList) {
            this.s = lazyStringArrayList;
        }

        /* renamed from: b */
        public void add(int i2, ByteString byteString) {
            this.s.m(i2, byteString);
            this.modCount++;
        }

        /* renamed from: c */
        public ByteString get(int i2) {
            return this.s.T1(i2);
        }

        /* renamed from: d */
        public ByteString remove(int i2) {
            String C = this.s.remove(i2);
            this.modCount++;
            return LazyStringArrayList.r(C);
        }

        /* renamed from: g */
        public ByteString set(int i2, ByteString byteString) {
            Object h2 = this.s.E(i2, byteString);
            this.modCount++;
            return LazyStringArrayList.r(h2);
        }

        public int size() {
            return this.s.size();
        }
    }

    static {
        LazyStringArrayList lazyStringArrayList = new LazyStringArrayList();
        Z = lazyStringArrayList;
        lazyStringArrayList.S();
        X2 = lazyStringArrayList;
    }

    public LazyStringArrayList() {
        this(10);
    }

    /* access modifiers changed from: private */
    public Object E(int i2, ByteString byteString) {
        b();
        return this.Y.set(i2, byteString);
    }

    /* access modifiers changed from: private */
    public Object G(int i2, byte[] bArr) {
        b();
        return this.Y.set(i2, bArr);
    }

    /* access modifiers changed from: private */
    public void m(int i2, ByteString byteString) {
        b();
        this.Y.add(i2, byteString);
        this.modCount++;
    }

    /* access modifiers changed from: private */
    public void o(int i2, byte[] bArr) {
        b();
        this.Y.add(i2, bArr);
        this.modCount++;
    }

    /* access modifiers changed from: private */
    public static byte[] q(Object obj) {
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        return obj instanceof String ? Internal.y((String) obj) : ((ByteString) obj).j0();
    }

    /* access modifiers changed from: private */
    public static ByteString r(Object obj) {
        if (obj instanceof ByteString) {
            return (ByteString) obj;
        }
        return obj instanceof String ? ByteString.B((String) obj) : ByteString.x((byte[]) obj);
    }

    private static String t(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        return obj instanceof ByteString ? ((ByteString) obj).o0() : Internal.z((byte[]) obj);
    }

    static LazyStringArrayList x() {
        return Z;
    }

    /* renamed from: B */
    public LazyStringArrayList f(int i2) {
        if (i2 >= size()) {
            ArrayList arrayList = new ArrayList(i2);
            arrayList.addAll(this.Y);
            return new LazyStringArrayList((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: C */
    public String remove(int i2) {
        b();
        Object remove = this.Y.remove(i2);
        this.modCount++;
        return t(remove);
    }

    public void C0(ByteString byteString) {
        b();
        this.Y.add(byteString);
        this.modCount++;
    }

    /* renamed from: D */
    public String set(int i2, String str) {
        b();
        return t(this.Y.set(i2, str));
    }

    public void F1(LazyStringList lazyStringList) {
        b();
        for (Object next : lazyStringList.d1()) {
            if (next instanceof byte[]) {
                byte[] bArr = (byte[]) next;
                this.Y.add(Arrays.copyOf(bArr, bArr.length));
            } else {
                this.Y.add(next);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.util.List<java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: byte[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] K0(int r3) {
        /*
            r2 = this;
            java.util.List<java.lang.Object> r0 = r2.Y
            java.lang.Object r0 = r0.get(r3)
            byte[] r1 = q(r0)
            if (r1 == r0) goto L_0x0011
            java.util.List<java.lang.Object> r0 = r2.Y
            r0.set(r3, r1)
        L_0x0011:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.LazyStringArrayList.K0(int):byte[]");
    }

    public void L0(int i2, ByteString byteString) {
        E(i2, byteString);
    }

    public /* bridge */ /* synthetic */ boolean P2() {
        return super.P2();
    }

    public boolean R0(Collection<byte[]> collection) {
        b();
        boolean addAll = this.Y.addAll(collection);
        this.modCount++;
        return addAll;
    }

    public ByteString T1(int i2) {
        Object obj = this.Y.get(i2);
        ByteString r = r(obj);
        if (r != obj) {
            this.Y.set(i2, r);
        }
        return r;
    }

    public void Y0(int i2, byte[] bArr) {
        G(i2, bArr);
    }

    public boolean addAll(int i2, Collection<? extends String> collection) {
        b();
        if (collection instanceof LazyStringList) {
            collection = ((LazyStringList) collection).d1();
        }
        boolean addAll = this.Y.addAll(i2, collection);
        this.modCount++;
        return addAll;
    }

    public void clear() {
        b();
        this.Y.clear();
        this.modCount++;
    }

    public List<?> d1() {
        return Collections.unmodifiableList(this.Y);
    }

    public LazyStringList e2() {
        return P2() ? new UnmodifiableLazyStringList(this) : this;
    }

    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public List<ByteString> f2() {
        return new ByteStringListView(this);
    }

    public List<byte[]> h1() {
        return new ByteArrayListView(this);
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public boolean j1(Collection<? extends ByteString> collection) {
        b();
        boolean addAll = this.Y.addAll(collection);
        this.modCount++;
        return addAll;
    }

    /* renamed from: n */
    public void add(int i2, String str) {
        b();
        this.Y.add(i2, str);
        this.modCount++;
    }

    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    public int size() {
        return this.Y.size();
    }

    public void u(byte[] bArr) {
        b();
        this.Y.add(bArr);
        this.modCount++;
    }

    public Object w2(int i2) {
        return this.Y.get(i2);
    }

    /* renamed from: z */
    public String get(int i2) {
        Object obj = this.Y.get(i2);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            String o0 = byteString.o0();
            if (byteString.N()) {
                this.Y.set(i2, o0);
            }
            return o0;
        }
        byte[] bArr = (byte[]) obj;
        String z = Internal.z(bArr);
        if (Internal.u(bArr)) {
            this.Y.set(i2, z);
        }
        return z;
    }

    public LazyStringArrayList(int i2) {
        this((ArrayList<Object>) new ArrayList(i2));
    }

    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    public LazyStringArrayList(LazyStringList lazyStringList) {
        this.Y = new ArrayList(lazyStringList.size());
        addAll(lazyStringList);
    }

    private LazyStringArrayList(ArrayList<Object> arrayList) {
        this.Y = arrayList;
    }

    public LazyStringArrayList(List<String> list) {
        this((ArrayList<Object>) new ArrayList(list));
    }
}
