package androidx.media3.common.util;

@UnstableApi
public interface TimestampIterator {
    TimestampIterator a();

    boolean hasNext();

    long next();
}
