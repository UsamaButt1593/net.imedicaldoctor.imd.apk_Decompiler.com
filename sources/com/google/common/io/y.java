package com.google.common.io;

import com.google.common.io.TempFileCreator;
import java.io.IOException;
import java.nio.file.attribute.FileAttribute;

public final /* synthetic */ class y implements TempFileCreator.JavaNioCreator.PermissionSupplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IOException f22806a;

    public /* synthetic */ y(IOException iOException) {
        this.f22806a = iOException;
    }

    public final FileAttribute get() {
        return TempFileCreator.JavaNioCreator.p(this.f22806a);
    }
}
