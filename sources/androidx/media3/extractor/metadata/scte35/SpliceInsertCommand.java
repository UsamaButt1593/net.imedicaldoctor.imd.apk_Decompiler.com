package androidx.media3.extractor.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.C;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.UnstableApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@UnstableApi
public final class SpliceInsertCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceInsertCommand> CREATOR = new Parcelable.Creator<SpliceInsertCommand>() {
        /* renamed from: a */
        public SpliceInsertCommand createFromParcel(Parcel parcel) {
            return new SpliceInsertCommand(parcel);
        }

        /* renamed from: b */
        public SpliceInsertCommand[] newArray(int i2) {
            return new SpliceInsertCommand[i2];
        }
    };
    public final boolean X;
    public final boolean X2;
    public final boolean Y;
    public final long Y2;
    public final boolean Z;
    public final long Z2;
    public final List<ComponentSplice> a3;
    public final boolean b3;
    public final long c3;
    public final int d3;
    public final int e3;
    public final int f3;
    public final long s;

    public static final class ComponentSplice {

        /* renamed from: a  reason: collision with root package name */
        public final int f13380a;

        /* renamed from: b  reason: collision with root package name */
        public final long f13381b;

        /* renamed from: c  reason: collision with root package name */
        public final long f13382c;

        private ComponentSplice(int i2, long j2, long j3) {
            this.f13380a = i2;
            this.f13381b = j2;
            this.f13382c = j3;
        }

        public static ComponentSplice a(Parcel parcel) {
            return new ComponentSplice(parcel.readInt(), parcel.readLong(), parcel.readLong());
        }

        public void b(Parcel parcel) {
            parcel.writeInt(this.f13380a);
            parcel.writeLong(this.f13381b);
            parcel.writeLong(this.f13382c);
        }
    }

    private SpliceInsertCommand(long j2, boolean z, boolean z2, boolean z3, boolean z4, long j3, long j4, List<ComponentSplice> list, boolean z5, long j5, int i2, int i3, int i4) {
        this.s = j2;
        this.X = z;
        this.Y = z2;
        this.Z = z3;
        this.X2 = z4;
        this.Y2 = j3;
        this.Z2 = j4;
        this.a3 = Collections.unmodifiableList(list);
        this.b3 = z5;
        this.c3 = j5;
        this.d3 = i2;
        this.e3 = i3;
        this.f3 = i4;
    }

    static SpliceInsertCommand a(ParsableByteArray parsableByteArray, long j2, TimestampAdjuster timestampAdjuster) {
        boolean z;
        int i2;
        int i3;
        int i4;
        long j3;
        boolean z2;
        List list;
        long j4;
        boolean z3;
        boolean z4;
        long j5;
        boolean z5;
        TimestampAdjuster timestampAdjuster2 = timestampAdjuster;
        long N = parsableByteArray.N();
        boolean z6 = (parsableByteArray.L() & 128) != 0;
        List emptyList = Collections.emptyList();
        if (!z6) {
            int L = parsableByteArray.L();
            boolean z7 = (L & 128) != 0;
            boolean z8 = (L & 64) != 0;
            boolean z9 = (L & 32) != 0;
            boolean z10 = (L & 16) != 0;
            long b2 = (!z8 || z10) ? C.f9084b : TimeSignalCommand.b(parsableByteArray, j2);
            if (!z8) {
                int L2 = parsableByteArray.L();
                ArrayList arrayList = new ArrayList(L2);
                for (int i5 = 0; i5 < L2; i5++) {
                    int L3 = parsableByteArray.L();
                    long b4 = !z10 ? TimeSignalCommand.b(parsableByteArray, j2) : C.f9084b;
                    arrayList.add(new ComponentSplice(L3, b4, timestampAdjuster2.b(b4)));
                }
                emptyList = arrayList;
            }
            if (z9) {
                long L4 = (long) parsableByteArray.L();
                boolean z11 = (128 & L4) != 0;
                j5 = ((((L4 & 1) << 32) | parsableByteArray.N()) * 1000) / 90;
                z5 = z11;
            } else {
                z5 = false;
                j5 = C.f9084b;
            }
            i4 = parsableByteArray.R();
            z = z8;
            i3 = parsableByteArray.L();
            i2 = parsableByteArray.L();
            list = emptyList;
            long j6 = b2;
            z2 = z5;
            j3 = j5;
            z3 = z10;
            z4 = z7;
            j4 = j6;
        } else {
            list = emptyList;
            z4 = false;
            z3 = false;
            j4 = C.f9084b;
            z2 = false;
            j3 = C.f9084b;
            i4 = 0;
            i3 = 0;
            i2 = 0;
            z = false;
        }
        return new SpliceInsertCommand(N, z6, z4, z, z3, j4, timestampAdjuster2.b(j4), list, z2, j3, i4, i3, i2);
    }

    public String toString() {
        return "SCTE-35 SpliceInsertCommand { programSplicePts=" + this.Y2 + ", programSplicePlaybackPositionUs= " + this.Z2 + " }";
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.s);
        parcel.writeByte(this.X ? (byte) 1 : 0);
        parcel.writeByte(this.Y ? (byte) 1 : 0);
        parcel.writeByte(this.Z ? (byte) 1 : 0);
        parcel.writeByte(this.X2 ? (byte) 1 : 0);
        parcel.writeLong(this.Y2);
        parcel.writeLong(this.Z2);
        int size = this.a3.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            this.a3.get(i3).b(parcel);
        }
        parcel.writeByte(this.b3 ? (byte) 1 : 0);
        parcel.writeLong(this.c3);
        parcel.writeInt(this.d3);
        parcel.writeInt(this.e3);
        parcel.writeInt(this.f3);
    }

    private SpliceInsertCommand(Parcel parcel) {
        this.s = parcel.readLong();
        boolean z = false;
        this.X = parcel.readByte() == 1;
        this.Y = parcel.readByte() == 1;
        this.Z = parcel.readByte() == 1;
        this.X2 = parcel.readByte() == 1;
        this.Y2 = parcel.readLong();
        this.Z2 = parcel.readLong();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(ComponentSplice.a(parcel));
        }
        this.a3 = Collections.unmodifiableList(arrayList);
        this.b3 = parcel.readByte() == 1 ? true : z;
        this.c3 = parcel.readLong();
        this.d3 = parcel.readInt();
        this.e3 = parcel.readInt();
        this.f3 = parcel.readInt();
    }
}
