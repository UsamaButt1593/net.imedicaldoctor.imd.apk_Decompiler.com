package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class UnmodifiableLazyStringList extends AbstractList<String> implements LazyStringList, RandomAccess {
    /* access modifiers changed from: private */
    public final LazyStringList s;

    public UnmodifiableLazyStringList(LazyStringList lazyStringList) {
        this.s = lazyStringList;
    }

    public void C0(ByteString byteString) {
        throw new UnsupportedOperationException();
    }

    public void F1(LazyStringList lazyStringList) {
        throw new UnsupportedOperationException();
    }

    public byte[] K0(int i2) {
        return this.s.K0(i2);
    }

    public void L0(int i2, ByteString byteString) {
        throw new UnsupportedOperationException();
    }

    public boolean R0(Collection<byte[]> collection) {
        throw new UnsupportedOperationException();
    }

    public ByteString T1(int i2) {
        return this.s.T1(i2);
    }

    public void Y0(int i2, byte[] bArr) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: c */
    public String get(int i2) {
        return (String) this.s.get(i2);
    }

    public List<?> d1() {
        return this.s.d1();
    }

    public LazyStringList e2() {
        return this;
    }

    public List<ByteString> f2() {
        return Collections.unmodifiableList(this.s.f2());
    }

    public List<byte[]> h1() {
        return Collections.unmodifiableList(this.s.h1());
    }

    public Iterator<String> iterator() {
        return new Iterator<String>() {
            Iterator<String> s;

            {
                this.s = UnmodifiableLazyStringList.this.s.iterator();
            }

            /* renamed from: a */
            public String next() {
                return this.s.next();
            }

            public boolean hasNext() {
                return this.s.hasNext();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public boolean j1(Collection<? extends ByteString> collection) {
        throw new UnsupportedOperationException();
    }

    public ListIterator<String> listIterator(int i2) {
        return new ListIterator<String>(i2) {
            final /* synthetic */ int X;
            ListIterator<String> s;

            {
                this.X = r2;
                this.s = UnmodifiableLazyStringList.this.s.listIterator(r2);
            }

            /* renamed from: a */
            public void add(String str) {
                throw new UnsupportedOperationException();
            }

            /* renamed from: b */
            public String next() {
                return this.s.next();
            }

            /* renamed from: c */
            public String previous() {
                return this.s.previous();
            }

            /* renamed from: d */
            public void set(String str) {
                throw new UnsupportedOperationException();
            }

            public boolean hasNext() {
                return this.s.hasNext();
            }

            public boolean hasPrevious() {
                return this.s.hasPrevious();
            }

            public int nextIndex() {
                return this.s.nextIndex();
            }

            public int previousIndex() {
                return this.s.previousIndex();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public int size() {
        return this.s.size();
    }

    public void u(byte[] bArr) {
        throw new UnsupportedOperationException();
    }

    public Object w2(int i2) {
        return this.s.w2(i2);
    }
}
