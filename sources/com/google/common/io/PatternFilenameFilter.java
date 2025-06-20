package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
@J2ktIncompatible
public final class PatternFilenameFilter implements FilenameFilter {

    /* renamed from: a  reason: collision with root package name */
    private final Pattern f22796a;

    public PatternFilenameFilter(String str) {
        this(Pattern.compile(str));
    }

    public boolean accept(File file, String str) {
        return this.f22796a.matcher(str).matches();
    }

    public PatternFilenameFilter(Pattern pattern) {
        this.f22796a = (Pattern) Preconditions.E(pattern);
    }
}
