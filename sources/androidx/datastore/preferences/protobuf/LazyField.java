package androidx.datastore.preferences.protobuf;

import java.util.Iterator;
import java.util.Map;

public class LazyField extends LazyFieldLite {

    /* renamed from: f  reason: collision with root package name */
    private final MessageLite f7174f;

    static class LazyEntry<K> implements Map.Entry<K, Object> {
        private Map.Entry<K, LazyField> s;

        private LazyEntry(Map.Entry<K, LazyField> entry) {
            this.s = entry;
        }

        public LazyField a() {
            return this.s.getValue();
        }

        public K getKey() {
            return this.s.getKey();
        }

        public Object getValue() {
            LazyField value = this.s.getValue();
            if (value == null) {
                return null;
            }
            return value.p();
        }

        public Object setValue(Object obj) {
            if (obj instanceof MessageLite) {
                return this.s.getValue().m((MessageLite) obj);
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
    }

    static class LazyIterator<K> implements Iterator<Map.Entry<K, Object>> {
        private Iterator<Map.Entry<K, Object>> s;

        public LazyIterator(Iterator<Map.Entry<K, Object>> it2) {
            this.s = it2;
        }

        /* renamed from: a */
        public Map.Entry<K, Object> next() {
            Map.Entry<K, Object> next = this.s.next();
            return next.getValue() instanceof LazyField ? new LazyEntry(next) : next;
        }

        public boolean hasNext() {
            return this.s.hasNext();
        }

        public void remove() {
            this.s.remove();
        }
    }

    public LazyField(MessageLite messageLite, ExtensionRegistryLite extensionRegistryLite, ByteString byteString) {
        super(extensionRegistryLite, byteString);
        this.f7174f = messageLite;
    }

    public boolean c() {
        return super.c() || this.f7178c == this.f7174f;
    }

    public boolean equals(Object obj) {
        return p().equals(obj);
    }

    public int hashCode() {
        return p().hashCode();
    }

    public MessageLite p() {
        return g(this.f7174f);
    }

    public String toString() {
        return p().toString();
    }
}
