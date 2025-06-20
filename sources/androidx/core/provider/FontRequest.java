package androidx.core.provider;

import android.util.Base64;
import androidx.annotation.ArrayRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import java.util.List;

public final class FontRequest {

    /* renamed from: a  reason: collision with root package name */
    private final String f6091a;

    /* renamed from: b  reason: collision with root package name */
    private final String f6092b;

    /* renamed from: c  reason: collision with root package name */
    private final String f6093c;

    /* renamed from: d  reason: collision with root package name */
    private final List<List<byte[]>> f6094d;

    /* renamed from: e  reason: collision with root package name */
    private final int f6095e;

    /* renamed from: f  reason: collision with root package name */
    private final String f6096f;

    public FontRequest(@NonNull String str, @NonNull String str2, @NonNull String str3, @ArrayRes int i2) {
        this.f6091a = (String) Preconditions.l(str);
        this.f6092b = (String) Preconditions.l(str2);
        this.f6093c = (String) Preconditions.l(str3);
        this.f6094d = null;
        Preconditions.a(i2 != 0);
        this.f6095e = i2;
        this.f6096f = a(str, str2, str3);
    }

    private String a(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        return str + "-" + str2 + "-" + str3;
    }

    @Nullable
    public List<List<byte[]>> b() {
        return this.f6094d;
    }

    @ArrayRes
    public int c() {
        return this.f6095e;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public String d() {
        return this.f6096f;
    }

    @Deprecated
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public String e() {
        return this.f6096f;
    }

    @NonNull
    public String f() {
        return this.f6091a;
    }

    @NonNull
    public String g() {
        return this.f6092b;
    }

    @NonNull
    public String h() {
        return this.f6093c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f6091a + ", mProviderPackage: " + this.f6092b + ", mQuery: " + this.f6093c + ", mCertificates:");
        for (int i2 = 0; i2 < this.f6094d.size(); i2++) {
            sb.append(" [");
            List list = this.f6094d.get(i2);
            for (int i3 = 0; i3 < list.size(); i3++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString((byte[]) list.get(i3), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f6095e);
        return sb.toString();
    }

    public FontRequest(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull List<List<byte[]>> list) {
        this.f6091a = (String) Preconditions.l(str);
        this.f6092b = (String) Preconditions.l(str2);
        this.f6093c = (String) Preconditions.l(str3);
        this.f6094d = (List) Preconditions.l(list);
        this.f6095e = 0;
        this.f6096f = a(str, str2, str3);
    }
}
