package com.google.common.util.concurrent;

import com.google.common.annotations.J2ktIncompatible;
import java.util.concurrent.locks.LockSupport;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@J2ktIncompatible
final class OverflowAvoidingLockSupport {

    /* renamed from: a  reason: collision with root package name */
    static final long f23198a = 2147483647999999999L;

    private OverflowAvoidingLockSupport() {
    }

    static void a(@CheckForNull Object obj, long j2) {
        LockSupport.parkNanos(obj, Math.min(j2, f23198a));
    }
}
