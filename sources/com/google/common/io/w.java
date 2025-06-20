package com.google.common.io;

import com.google.common.io.TempFileCreator;
import java.nio.file.attribute.FileAttribute;

public final /* synthetic */ class w implements TempFileCreator.JavaNioCreator.PermissionSupplier {
    public final FileAttribute get() {
        return TempFileCreator.JavaNioCreator.n();
    }
}
