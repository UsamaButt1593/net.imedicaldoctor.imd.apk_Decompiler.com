package androidx.media3.datasource.cache;

import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
public interface ContentMetadata {

    /* renamed from: a  reason: collision with root package name */
    public static final String f10024a = "custom_";

    /* renamed from: b  reason: collision with root package name */
    public static final String f10025b = "exo_redir";

    /* renamed from: c  reason: collision with root package name */
    public static final String f10026c = "exo_len";

    @Nullable
    String a(String str, @Nullable String str2);

    long b(String str, long j2);

    @Nullable
    byte[] c(String str, @Nullable byte[] bArr);

    boolean contains(String str);
}
