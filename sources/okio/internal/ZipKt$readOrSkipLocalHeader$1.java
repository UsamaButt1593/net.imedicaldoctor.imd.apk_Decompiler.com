package okio.internal;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import okio.BufferedSource;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "headerId", "", "dataSize", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
final class ZipKt$readOrSkipLocalHeader$1 extends Lambda implements Function2<Integer, Long, Unit> {
    final /* synthetic */ BufferedSource X;
    final /* synthetic */ Ref.ObjectRef<Long> X2;
    final /* synthetic */ Ref.ObjectRef<Long> Y;
    final /* synthetic */ Ref.ObjectRef<Long> Z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ZipKt$readOrSkipLocalHeader$1(BufferedSource bufferedSource, Ref.ObjectRef<Long> objectRef, Ref.ObjectRef<Long> objectRef2, Ref.ObjectRef<Long> objectRef3) {
        super(2);
        this.X = bufferedSource;
        this.Y = objectRef;
        this.Z = objectRef2;
        this.X2 = objectRef3;
    }

    public final void b(int i2, long j2) {
        if (i2 == 21589) {
            long j3 = 1;
            if (j2 >= 1) {
                byte readByte = this.X.readByte();
                boolean z = false;
                boolean z2 = (readByte & 1) == 1;
                boolean z3 = (readByte & 2) == 2;
                if ((readByte & 4) == 4) {
                    z = true;
                }
                BufferedSource bufferedSource = this.X;
                if (z2) {
                    j3 = 5;
                }
                if (z3) {
                    j3 += 4;
                }
                if (z) {
                    j3 += 4;
                }
                if (j2 >= j3) {
                    if (z2) {
                        this.Y.s = Long.valueOf(((long) bufferedSource.R1()) * 1000);
                    }
                    if (z3) {
                        this.Z.s = Long.valueOf(((long) this.X.R1()) * 1000);
                    }
                    if (z) {
                        this.X2.s = Long.valueOf(((long) this.X.R1()) * 1000);
                        return;
                    }
                    return;
                }
                throw new IOException("bad zip: extended timestamp extra too short");
            }
            throw new IOException("bad zip: extended timestamp extra too short");
        }
    }

    public /* bridge */ /* synthetic */ Object d0(Object obj, Object obj2) {
        b(((Number) obj).intValue(), ((Number) obj2).longValue());
        return Unit.f28779a;
    }
}
