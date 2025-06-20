package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.collect.Multiset;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
final class Serialization {

    static final class FieldSetter<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Field f22494a;

        private FieldSetter(Field field) {
            this.f22494a = field;
            field.setAccessible(true);
        }

        /* access modifiers changed from: package-private */
        public void a(T t, int i2) {
            try {
                this.f22494a.set(t, Integer.valueOf(i2));
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }

        /* access modifiers changed from: package-private */
        public void b(T t, Object obj) {
            try {
                this.f22494a.set(t, obj);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    private Serialization() {
    }

    static <T> FieldSetter<T> a(Class<T> cls, String str) {
        try {
            return new FieldSetter<>(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e2) {
            throw new AssertionError(e2);
        }
    }

    static <K, V> void b(Map<K, V> map, ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        c(map, objectInputStream, objectInputStream.readInt());
    }

    static <K, V> void c(Map<K, V> map, ObjectInputStream objectInputStream, int i2) throws IOException, ClassNotFoundException {
        for (int i3 = 0; i3 < i2; i3++) {
            map.put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    static <K, V> void d(Multimap<K, V> multimap, ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        e(multimap, objectInputStream, objectInputStream.readInt());
    }

    static <K, V> void e(Multimap<K, V> multimap, ObjectInputStream objectInputStream, int i2) throws IOException, ClassNotFoundException {
        for (int i3 = 0; i3 < i2; i3++) {
            Collection<V> collection = multimap.get(objectInputStream.readObject());
            int readInt = objectInputStream.readInt();
            for (int i4 = 0; i4 < readInt; i4++) {
                collection.add(objectInputStream.readObject());
            }
        }
    }

    static <E> void f(Multiset<E> multiset, ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        g(multiset, objectInputStream, objectInputStream.readInt());
    }

    static <E> void g(Multiset<E> multiset, ObjectInputStream objectInputStream, int i2) throws IOException, ClassNotFoundException {
        for (int i3 = 0; i3 < i2; i3++) {
            multiset.Q(objectInputStream.readObject(), objectInputStream.readInt());
        }
    }

    static int h(ObjectInputStream objectInputStream) throws IOException {
        return objectInputStream.readInt();
    }

    static <K, V> void i(Map<K, V> map, ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(map.size());
        for (Map.Entry next : map.entrySet()) {
            objectOutputStream.writeObject(next.getKey());
            objectOutputStream.writeObject(next.getValue());
        }
    }

    static <K, V> void j(Multimap<K, V> multimap, ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(multimap.g().size());
        for (Map.Entry next : multimap.g().entrySet()) {
            objectOutputStream.writeObject(next.getKey());
            objectOutputStream.writeInt(((Collection) next.getValue()).size());
            for (Object writeObject : (Collection) next.getValue()) {
                objectOutputStream.writeObject(writeObject);
            }
        }
    }

    static <E> void k(Multiset<E> multiset, ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(multiset.entrySet().size());
        for (Multiset.Entry next : multiset.entrySet()) {
            objectOutputStream.writeObject(next.a());
            objectOutputStream.writeInt(next.getCount());
        }
    }
}
