package com.google.common.io;

import com.google.common.io.TempFileCreator;
import java.nio.file.attribute.FileAttribute;

public final /* synthetic */ class x implements TempFileCreator.JavaNioCreator.PermissionSupplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FileAttribute f22805a;

    public /* synthetic */ x(FileAttribute fileAttribute) {
        this.f22805a = fileAttribute;
    }

    public final FileAttribute get() {
        return TempFileCreator.JavaNioCreator.o(this.f22805a);
    }
}
