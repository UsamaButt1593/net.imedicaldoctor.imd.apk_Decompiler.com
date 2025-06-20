package androidx.media3.datasource.cache;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@UnstableApi
public class ContentMetadataMutations {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, Object> f10027a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final List<String> f10028b = new ArrayList();

    @CanIgnoreReturnValue
    private ContentMetadataMutations a(String str, Object obj) {
        this.f10027a.put((String) Assertions.g(str), Assertions.g(obj));
        this.f10028b.remove(str);
        return this;
    }

    public static ContentMetadataMutations h(ContentMetadataMutations contentMetadataMutations, long j2) {
        return contentMetadataMutations.e(ContentMetadata.f10026c, j2);
    }

    public static ContentMetadataMutations i(ContentMetadataMutations contentMetadataMutations, @Nullable Uri uri) {
        return uri == null ? contentMetadataMutations.d(ContentMetadata.f10025b) : contentMetadataMutations.f(ContentMetadata.f10025b, uri.toString());
    }

    public Map<String, Object> b() {
        HashMap hashMap = new HashMap(this.f10027a);
        for (Map.Entry entry : hashMap.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                byte[] bArr = (byte[]) value;
                entry.setValue(Arrays.copyOf(bArr, bArr.length));
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public List<String> c() {
        return Collections.unmodifiableList(new ArrayList(this.f10028b));
    }

    @CanIgnoreReturnValue
    public ContentMetadataMutations d(String str) {
        this.f10028b.add(str);
        this.f10027a.remove(str);
        return this;
    }

    @CanIgnoreReturnValue
    public ContentMetadataMutations e(String str, long j2) {
        return a(str, Long.valueOf(j2));
    }

    @CanIgnoreReturnValue
    public ContentMetadataMutations f(String str, String str2) {
        return a(str, str2);
    }

    @CanIgnoreReturnValue
    public ContentMetadataMutations g(String str, byte[] bArr) {
        return a(str, Arrays.copyOf(bArr, bArr.length));
    }
}
