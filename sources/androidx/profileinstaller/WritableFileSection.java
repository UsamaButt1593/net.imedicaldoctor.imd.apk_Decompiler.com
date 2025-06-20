package androidx.profileinstaller;

import androidx.annotation.NonNull;

class WritableFileSection {

    /* renamed from: a  reason: collision with root package name */
    final FileSectionType f15153a;

    /* renamed from: b  reason: collision with root package name */
    final int f15154b;

    /* renamed from: c  reason: collision with root package name */
    final byte[] f15155c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f15156d;

    WritableFileSection(@NonNull FileSectionType fileSectionType, int i2, @NonNull byte[] bArr, boolean z) {
        this.f15153a = fileSectionType;
        this.f15154b = i2;
        this.f15155c = bArr;
        this.f15156d = z;
    }
}
