package androidx.media3.datasource.cache;

import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;
import com.google.common.base.Charsets;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@UnstableApi
public final class DefaultContentMetadata implements ContentMetadata {

    /* renamed from: f  reason: collision with root package name */
    public static final DefaultContentMetadata f10029f = new DefaultContentMetadata(Collections.emptyMap());

    /* renamed from: d  reason: collision with root package name */
    private int f10030d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, byte[]> f10031e;

    public DefaultContentMetadata() {
        this(Collections.emptyMap());
    }

    private static void d(HashMap<String, byte[]> hashMap, Map<String, Object> map) {
        for (Map.Entry next : map.entrySet()) {
            hashMap.put((String) next.getKey(), h(next.getValue()));
        }
    }

    private static Map<String, byte[]> e(Map<String, byte[]> map, ContentMetadataMutations contentMetadataMutations) {
        HashMap hashMap = new HashMap(map);
        j(hashMap, contentMetadataMutations.c());
        d(hashMap, contentMetadataMutations.b());
        return hashMap;
    }

    private static byte[] h(Object obj) {
        if (obj instanceof Long) {
            return ByteBuffer.allocate(8).putLong(((Long) obj).longValue()).array();
        }
        if (obj instanceof String) {
            return ((String) obj).getBytes(Charsets.f22255c);
        }
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        throw new IllegalArgumentException();
    }

    private static boolean i(Map<String, byte[]> map, Map<String, byte[]> map2) {
        if (map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry next : map.entrySet()) {
            if (!Arrays.equals((byte[]) next.getValue(), map2.get(next.getKey()))) {
                return false;
            }
        }
        return true;
    }

    private static void j(HashMap<String, byte[]> hashMap, List<String> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            hashMap.remove(list.get(i2));
        }
    }

    @Nullable
    public final String a(String str, @Nullable String str2) {
        byte[] bArr = this.f10031e.get(str);
        return bArr != null ? new String(bArr, Charsets.f22255c) : str2;
    }

    public final long b(String str, long j2) {
        byte[] bArr = this.f10031e.get(str);
        return bArr != null ? ByteBuffer.wrap(bArr).getLong() : j2;
    }

    @Nullable
    public final byte[] c(String str, @Nullable byte[] bArr) {
        byte[] bArr2 = this.f10031e.get(str);
        return bArr2 != null ? Arrays.copyOf(bArr2, bArr2.length) : bArr;
    }

    public final boolean contains(String str) {
        return this.f10031e.containsKey(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DefaultContentMetadata.class != obj.getClass()) {
            return false;
        }
        return i(this.f10031e, ((DefaultContentMetadata) obj).f10031e);
    }

    public DefaultContentMetadata f(ContentMetadataMutations contentMetadataMutations) {
        Map<String, byte[]> e2 = e(this.f10031e, contentMetadataMutations);
        return i(this.f10031e, e2) ? this : new DefaultContentMetadata(e2);
    }

    public Set<Map.Entry<String, byte[]>> g() {
        return this.f10031e.entrySet();
    }

    public int hashCode() {
        if (this.f10030d == 0) {
            int i2 = 0;
            for (Map.Entry next : this.f10031e.entrySet()) {
                i2 += Arrays.hashCode((byte[]) next.getValue()) ^ ((String) next.getKey()).hashCode();
            }
            this.f10030d = i2;
        }
        return this.f10030d;
    }

    public DefaultContentMetadata(Map<String, byte[]> map) {
        this.f10031e = Collections.unmodifiableMap(map);
    }
}
