package androidx.media3.extractor.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.C;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@UnstableApi
public final class SpliceScheduleCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceScheduleCommand> CREATOR = new Parcelable.Creator<SpliceScheduleCommand>() {
        /* renamed from: a */
        public SpliceScheduleCommand createFromParcel(Parcel parcel) {
            return new SpliceScheduleCommand(parcel);
        }

        /* renamed from: b */
        public SpliceScheduleCommand[] newArray(int i2) {
            return new SpliceScheduleCommand[i2];
        }
    };
    public final List<Event> s;

    public static final class ComponentSplice {

        /* renamed from: a  reason: collision with root package name */
        public final int f13383a;

        /* renamed from: b  reason: collision with root package name */
        public final long f13384b;

        private ComponentSplice(int i2, long j2) {
            this.f13383a = i2;
            this.f13384b = j2;
        }

        /* access modifiers changed from: private */
        public static ComponentSplice c(Parcel parcel) {
            return new ComponentSplice(parcel.readInt(), parcel.readLong());
        }

        /* access modifiers changed from: private */
        public void d(Parcel parcel) {
            parcel.writeInt(this.f13383a);
            parcel.writeLong(this.f13384b);
        }
    }

    public static final class Event {

        /* renamed from: a  reason: collision with root package name */
        public final long f13385a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f13386b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f13387c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f13388d;

        /* renamed from: e  reason: collision with root package name */
        public final long f13389e;

        /* renamed from: f  reason: collision with root package name */
        public final List<ComponentSplice> f13390f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f13391g;

        /* renamed from: h  reason: collision with root package name */
        public final long f13392h;

        /* renamed from: i  reason: collision with root package name */
        public final int f13393i;

        /* renamed from: j  reason: collision with root package name */
        public final int f13394j;

        /* renamed from: k  reason: collision with root package name */
        public final int f13395k;

        private Event(long j2, boolean z, boolean z2, boolean z3, List<ComponentSplice> list, long j3, boolean z4, long j4, int i2, int i3, int i4) {
            this.f13385a = j2;
            this.f13386b = z;
            this.f13387c = z2;
            this.f13388d = z3;
            this.f13390f = Collections.unmodifiableList(list);
            this.f13389e = j3;
            this.f13391g = z4;
            this.f13392h = j4;
            this.f13393i = i2;
            this.f13394j = i3;
            this.f13395k = i4;
        }

        /* access modifiers changed from: private */
        public static Event d(Parcel parcel) {
            return new Event(parcel);
        }

        /* access modifiers changed from: private */
        public static Event e(ParsableByteArray parsableByteArray) {
            boolean z;
            int i2;
            int i3;
            int i4;
            long j2;
            boolean z2;
            long j3;
            ArrayList arrayList;
            boolean z3;
            long j4;
            boolean z4;
            long N = parsableByteArray.N();
            boolean z5 = (parsableByteArray.L() & 128) != 0;
            ArrayList arrayList2 = new ArrayList();
            if (!z5) {
                int L = parsableByteArray.L();
                boolean z6 = (L & 128) != 0;
                boolean z7 = (L & 64) != 0;
                boolean z8 = (L & 32) != 0;
                long N2 = z7 ? parsableByteArray.N() : C.f9084b;
                if (!z7) {
                    int L2 = parsableByteArray.L();
                    ArrayList arrayList3 = new ArrayList(L2);
                    for (int i5 = 0; i5 < L2; i5++) {
                        arrayList3.add(new ComponentSplice(parsableByteArray.L(), parsableByteArray.N()));
                    }
                    arrayList2 = arrayList3;
                }
                if (z8) {
                    long L3 = (long) parsableByteArray.L();
                    boolean z9 = (128 & L3) != 0;
                    j4 = ((((L3 & 1) << 32) | parsableByteArray.N()) * 1000) / 90;
                    z4 = z9;
                } else {
                    z4 = false;
                    j4 = C.f9084b;
                }
                int R = parsableByteArray.R();
                int L4 = parsableByteArray.L();
                z = z7;
                i2 = parsableByteArray.L();
                j2 = j4;
                arrayList = arrayList2;
                long j5 = N2;
                i4 = R;
                i3 = L4;
                j3 = j5;
                boolean z10 = z6;
                z2 = z4;
                z3 = z10;
            } else {
                arrayList = arrayList2;
                z3 = false;
                j3 = C.f9084b;
                z2 = false;
                j2 = C.f9084b;
                i4 = 0;
                i3 = 0;
                i2 = 0;
                z = false;
            }
            return new Event(N, z5, z3, z, arrayList, j3, z2, j2, i4, i3, i2);
        }

        /* access modifiers changed from: private */
        public void f(Parcel parcel) {
            parcel.writeLong(this.f13385a);
            parcel.writeByte(this.f13386b ? (byte) 1 : 0);
            parcel.writeByte(this.f13387c ? (byte) 1 : 0);
            parcel.writeByte(this.f13388d ? (byte) 1 : 0);
            int size = this.f13390f.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                this.f13390f.get(i2).d(parcel);
            }
            parcel.writeLong(this.f13389e);
            parcel.writeByte(this.f13391g ? (byte) 1 : 0);
            parcel.writeLong(this.f13392h);
            parcel.writeInt(this.f13393i);
            parcel.writeInt(this.f13394j);
            parcel.writeInt(this.f13395k);
        }

        private Event(Parcel parcel) {
            this.f13385a = parcel.readLong();
            boolean z = false;
            this.f13386b = parcel.readByte() == 1;
            this.f13387c = parcel.readByte() == 1;
            this.f13388d = parcel.readByte() == 1;
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i2 = 0; i2 < readInt; i2++) {
                arrayList.add(ComponentSplice.c(parcel));
            }
            this.f13390f = Collections.unmodifiableList(arrayList);
            this.f13389e = parcel.readLong();
            this.f13391g = parcel.readByte() == 1 ? true : z;
            this.f13392h = parcel.readLong();
            this.f13393i = parcel.readInt();
            this.f13394j = parcel.readInt();
            this.f13395k = parcel.readInt();
        }
    }

    private SpliceScheduleCommand(Parcel parcel) {
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(Event.d(parcel));
        }
        this.s = Collections.unmodifiableList(arrayList);
    }

    static SpliceScheduleCommand a(ParsableByteArray parsableByteArray) {
        int L = parsableByteArray.L();
        ArrayList arrayList = new ArrayList(L);
        for (int i2 = 0; i2 < L; i2++) {
            arrayList.add(Event.e(parsableByteArray));
        }
        return new SpliceScheduleCommand((List<Event>) arrayList);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int size = this.s.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            this.s.get(i3).f(parcel);
        }
    }

    private SpliceScheduleCommand(List<Event> list) {
        this.s = Collections.unmodifiableList(list);
    }
}
