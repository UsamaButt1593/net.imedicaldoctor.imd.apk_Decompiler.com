package okio.internal;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\r\u0010\u000f¨\u0006\u0010"}, d2 = {"Lokio/internal/EocdRecord;", "", "", "entryCount", "centralDirectoryOffset", "", "commentByteCount", "<init>", "(JJI)V", "a", "J", "c", "()J", "b", "I", "()I", "okio"}, k = 1, mv = {1, 5, 1})
final class EocdRecord {

    /* renamed from: a  reason: collision with root package name */
    private final long f31422a;

    /* renamed from: b  reason: collision with root package name */
    private final long f31423b;

    /* renamed from: c  reason: collision with root package name */
    private final int f31424c;

    public EocdRecord(long j2, long j3, int i2) {
        this.f31422a = j2;
        this.f31423b = j3;
        this.f31424c = i2;
    }

    public final long a() {
        return this.f31423b;
    }

    public final int b() {
        return this.f31424c;
    }

    public final long c() {
        return this.f31422a;
    }
}
