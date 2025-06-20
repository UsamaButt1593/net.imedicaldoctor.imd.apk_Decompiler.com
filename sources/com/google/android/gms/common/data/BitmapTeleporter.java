package com.google.android.gms.common.data;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

@ShowFirstParty
@KeepForSdk
@SafeParcelable.Class(creator = "BitmapTeleporterCreator")
public class BitmapTeleporter extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    @KeepForSdk
    public static final Parcelable.Creator<BitmapTeleporter> CREATOR = new zaa();
    @SafeParcelable.Field(id = 2)
    @Nullable
    ParcelFileDescriptor X;
    private boolean X2;
    @SafeParcelable.Field(id = 3)
    final int Y;
    private File Y2;
    @Nullable
    private Bitmap Z;
    @SafeParcelable.VersionField(id = 1)
    final int s;

    @SafeParcelable.Constructor
    BitmapTeleporter(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) ParcelFileDescriptor parcelFileDescriptor, @SafeParcelable.Param(id = 3) int i3) {
        this.s = i2;
        this.X = parcelFileDescriptor;
        this.Y = i3;
        this.Z = null;
        this.X2 = false;
    }

    private static final void I(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e2) {
            Log.w("BitmapTeleporter", "Could not close stream", e2);
        }
    }

    @KeepForSdk
    @Nullable
    public Bitmap C() {
        if (!this.X2) {
            DataInputStream dataInputStream = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream((ParcelFileDescriptor) Preconditions.r(this.X)));
            try {
                byte[] bArr = new byte[dataInputStream.readInt()];
                int readInt = dataInputStream.readInt();
                int readInt2 = dataInputStream.readInt();
                Bitmap.Config valueOf = Bitmap.Config.valueOf(dataInputStream.readUTF());
                dataInputStream.read(bArr);
                I(dataInputStream);
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                Bitmap createBitmap = Bitmap.createBitmap(readInt, readInt2, valueOf);
                createBitmap.copyPixelsFromBuffer(wrap);
                this.Z = createBitmap;
                this.X2 = true;
            } catch (IOException e2) {
                throw new IllegalStateException("Could not read from parcel file descriptor", e2);
            } catch (Throwable th) {
                I(dataInputStream);
                throw th;
            }
        }
        return this.Z;
    }

    @KeepForSdk
    public void H(@NonNull File file) {
        if (file != null) {
            this.Y2 = file;
            return;
        }
        throw new NullPointerException("Cannot set null temp directory");
    }

    @KeepForSdk
    public void a() {
        if (!this.X2) {
            try {
                ((ParcelFileDescriptor) Preconditions.r(this.X)).close();
            } catch (IOException e2) {
                Log.w("BitmapTeleporter", "Could not close PFD", e2);
            }
        }
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i2) {
        if (this.X == null) {
            Bitmap bitmap = (Bitmap) Preconditions.r(this.Z);
            ByteBuffer allocate = ByteBuffer.allocate(bitmap.getRowBytes() * bitmap.getHeight());
            bitmap.copyPixelsToBuffer(allocate);
            byte[] array = allocate.array();
            File file = this.Y2;
            if (file != null) {
                try {
                    File createTempFile = File.createTempFile("teleporter", ".tmp", file);
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                        this.X = ParcelFileDescriptor.open(createTempFile, 268435456);
                        createTempFile.delete();
                        DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(fileOutputStream));
                        try {
                            dataOutputStream.writeInt(array.length);
                            dataOutputStream.writeInt(bitmap.getWidth());
                            dataOutputStream.writeInt(bitmap.getHeight());
                            dataOutputStream.writeUTF(bitmap.getConfig().toString());
                            dataOutputStream.write(array);
                            I(dataOutputStream);
                        } catch (IOException e2) {
                            throw new IllegalStateException("Could not write into unlinked file", e2);
                        } catch (Throwable th) {
                            I(dataOutputStream);
                            throw th;
                        }
                    } catch (FileNotFoundException unused) {
                        throw new IllegalStateException("Temporary file is somehow already deleted");
                    }
                } catch (IOException e3) {
                    throw new IllegalStateException("Could not create temporary file", e3);
                }
            } else {
                throw new IllegalStateException("setTempDir() must be called before writing this object to a parcel");
            }
        }
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.F(parcel, 1, this.s);
        SafeParcelWriter.S(parcel, 2, this.X, i2 | 1, false);
        SafeParcelWriter.F(parcel, 3, this.Y);
        SafeParcelWriter.b(parcel, a2);
        this.X = null;
    }

    @KeepForSdk
    public BitmapTeleporter(@NonNull Bitmap bitmap) {
        this.s = 1;
        this.X = null;
        this.Y = 0;
        this.Z = bitmap;
        this.X2 = true;
    }
}
