package okio.internal;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import net.lingala.zip4j.util.InternalZipConstants;
import okio.BufferedSource;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "headerId", "", "dataSize", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
final class ZipKt$readEntry$1 extends Lambda implements Function2<Integer, Long, Unit> {
    final /* synthetic */ Ref.BooleanRef X;
    final /* synthetic */ BufferedSource X2;
    final /* synthetic */ long Y;
    final /* synthetic */ Ref.LongRef Y2;
    final /* synthetic */ Ref.LongRef Z;
    final /* synthetic */ Ref.LongRef Z2;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ZipKt$readEntry$1(Ref.BooleanRef booleanRef, long j2, Ref.LongRef longRef, BufferedSource bufferedSource, Ref.LongRef longRef2, Ref.LongRef longRef3) {
        super(2);
        this.X = booleanRef;
        this.Y = j2;
        this.Z = longRef;
        this.X2 = bufferedSource;
        this.Y2 = longRef2;
        this.Z2 = longRef3;
    }

    public final void b(int i2, long j2) {
        if (i2 == 1) {
            Ref.BooleanRef booleanRef = this.X;
            if (!booleanRef.s) {
                booleanRef.s = true;
                if (j2 >= this.Y) {
                    Ref.LongRef longRef = this.Z;
                    long j3 = longRef.s;
                    if (j3 == InternalZipConstants.f30717k) {
                        j3 = this.X2.p2();
                    }
                    longRef.s = j3;
                    Ref.LongRef longRef2 = this.Y2;
                    long j4 = 0;
                    longRef2.s = longRef2.s == InternalZipConstants.f30717k ? this.X2.p2() : 0;
                    Ref.LongRef longRef3 = this.Z2;
                    if (longRef3.s == InternalZipConstants.f30717k) {
                        j4 = this.X2.p2();
                    }
                    longRef3.s = j4;
                    return;
                }
                throw new IOException("bad zip: zip64 extra too short");
            }
            throw new IOException("bad zip: zip64 extra repeated");
        }
    }

    public /* bridge */ /* synthetic */ Object d0(Object obj, Object obj2) {
        b(((Number) obj).intValue(), ((Number) obj2).longValue());
        return Unit.f28779a;
    }
}
