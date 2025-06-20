package androidx.media3.datasource.cache;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class SimpleCacheSpan extends CacheSpan {
    static final String Z2 = ".exo";
    private static final String a3 = ".v3.exo";
    private static final Pattern b3 = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v1\\.exo$", 32);
    private static final Pattern c3 = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v2\\.exo$", 32);
    private static final Pattern d3 = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.v3\\.exo$", 32);

    private SimpleCacheSpan(String str, long j2, long j3, long j4, @Nullable File file) {
        super(str, j2, j3, j4, file);
    }

    @Nullable
    public static SimpleCacheSpan f(File file, long j2, long j3, CachedContentIndex cachedContentIndex) {
        File file2;
        String l2;
        CachedContentIndex cachedContentIndex2 = cachedContentIndex;
        String name = file.getName();
        if (!name.endsWith(a3)) {
            File file3 = file;
            File k2 = k(file, cachedContentIndex2);
            if (k2 == null) {
                return null;
            }
            file2 = k2;
            name = k2.getName();
        } else {
            file2 = file;
        }
        Matcher matcher = d3.matcher(name);
        if (!matcher.matches() || (l2 = cachedContentIndex2.l(Integer.parseInt((String) Assertions.g(matcher.group(1))))) == null) {
            return null;
        }
        long length = j2 == -1 ? file2.length() : j2;
        if (length == 0) {
            return null;
        }
        return new SimpleCacheSpan(l2, Long.parseLong((String) Assertions.g(matcher.group(2))), length, j3 == C.f9084b ? Long.parseLong((String) Assertions.g(matcher.group(3))) : j3, file2);
    }

    @Nullable
    public static SimpleCacheSpan g(File file, long j2, CachedContentIndex cachedContentIndex) {
        return f(file, j2, C.f9084b, cachedContentIndex);
    }

    public static SimpleCacheSpan h(String str, long j2, long j3) {
        return new SimpleCacheSpan(str, j2, j3, C.f9084b, (File) null);
    }

    public static SimpleCacheSpan i(String str, long j2) {
        return new SimpleCacheSpan(str, j2, -1, C.f9084b, (File) null);
    }

    public static File j(File file, int i2, long j2, long j3) {
        return new File(file, i2 + "." + j2 + "." + j3 + a3);
    }

    @Nullable
    private static File k(File file, CachedContentIndex cachedContentIndex) {
        String str;
        String name = file.getName();
        Matcher matcher = c3.matcher(name);
        if (matcher.matches()) {
            str = Util.G2((String) Assertions.g(matcher.group(1)));
        } else {
            matcher = b3.matcher(name);
            str = matcher.matches() ? (String) Assertions.g(matcher.group(1)) : null;
        }
        if (str == null) {
            return null;
        }
        File j2 = j((File) Assertions.k(file.getParentFile()), cachedContentIndex.f(str), Long.parseLong((String) Assertions.g(matcher.group(2))), Long.parseLong((String) Assertions.g(matcher.group(3))));
        if (!file.renameTo(j2)) {
            return null;
        }
        return j2;
    }

    public SimpleCacheSpan e(File file, long j2) {
        Assertions.i(this.Z);
        return new SimpleCacheSpan(this.s, this.X, this.Y, j2, file);
    }
}
