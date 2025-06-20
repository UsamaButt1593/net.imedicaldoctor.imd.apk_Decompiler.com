package com.bumptech.glide.load.data;

import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.data.DataRewinder;
import java.io.IOException;

public final class ParcelFileDescriptorRewinder implements DataRewinder<ParcelFileDescriptor> {

    /* renamed from: a  reason: collision with root package name */
    private final InternalRewinder f17844a;

    @RequiresApi(21)
    public static final class Factory implements DataRewinder.Factory<ParcelFileDescriptor> {
        @NonNull
        public Class<ParcelFileDescriptor> a() {
            return ParcelFileDescriptor.class;
        }

        @NonNull
        /* renamed from: c */
        public DataRewinder<ParcelFileDescriptor> b(@NonNull ParcelFileDescriptor parcelFileDescriptor) {
            return new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }
    }

    @RequiresApi(21)
    private static final class InternalRewinder {

        /* renamed from: a  reason: collision with root package name */
        private final ParcelFileDescriptor f17845a;

        InternalRewinder(ParcelFileDescriptor parcelFileDescriptor) {
            this.f17845a = parcelFileDescriptor;
        }

        /* access modifiers changed from: package-private */
        public ParcelFileDescriptor a() throws IOException {
            try {
                Os.lseek(this.f17845a.getFileDescriptor(), 0, OsConstants.SEEK_SET);
                return this.f17845a;
            } catch (ErrnoException e2) {
                throw new IOException(e2);
            }
        }
    }

    @RequiresApi(21)
    public ParcelFileDescriptorRewinder(ParcelFileDescriptor parcelFileDescriptor) {
        this.f17844a = new InternalRewinder(parcelFileDescriptor);
    }

    public static boolean c() {
        return true;
    }

    public void b() {
    }

    @RequiresApi(21)
    @NonNull
    /* renamed from: d */
    public ParcelFileDescriptor a() throws IOException {
        return this.f17844a.a();
    }
}
