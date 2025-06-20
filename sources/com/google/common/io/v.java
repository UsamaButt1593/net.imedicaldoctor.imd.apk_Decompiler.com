package com.google.common.io;

import com.google.common.io.TempFileCreator;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermissions;

public final /* synthetic */ class v implements TempFileCreator.JavaNioCreator.PermissionSupplier {
    public final FileAttribute get() {
        return PosixFilePermissions.asFileAttribute(PosixFilePermissions.fromString("rwx------"));
    }
}
