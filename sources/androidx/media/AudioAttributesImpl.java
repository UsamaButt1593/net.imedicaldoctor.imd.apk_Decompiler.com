package androidx.media;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcelable;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public interface AudioAttributesImpl extends VersionedParcelable {

    public interface Builder {
        @NonNull
        Builder a(int i2);

        @NonNull
        Builder b(int i2);

        @NonNull
        AudioAttributesImpl build();

        @NonNull
        Builder c(int i2);

        @NonNull
        Builder d(int i2);
    }

    @Nullable
    Object d();

    int e();

    int f();

    int g();

    int getContentType();

    int h();

    int j();
}
