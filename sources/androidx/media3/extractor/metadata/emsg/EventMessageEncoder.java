package androidx.media3.extractor.metadata.emsg;

import androidx.media3.common.util.UnstableApi;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

@UnstableApi
public final class EventMessageEncoder {

    /* renamed from: a  reason: collision with root package name */
    private final ByteArrayOutputStream f13348a;

    /* renamed from: b  reason: collision with root package name */
    private final DataOutputStream f13349b;

    public EventMessageEncoder() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        this.f13348a = byteArrayOutputStream;
        this.f13349b = new DataOutputStream(byteArrayOutputStream);
    }

    private static void b(DataOutputStream dataOutputStream, String str) throws IOException {
        dataOutputStream.writeBytes(str);
        dataOutputStream.writeByte(0);
    }

    public byte[] a(EventMessage eventMessage) {
        this.f13348a.reset();
        try {
            b(this.f13349b, eventMessage.s);
            String str = eventMessage.X;
            if (str == null) {
                str = "";
            }
            b(this.f13349b, str);
            this.f13349b.writeLong(eventMessage.Y);
            this.f13349b.writeLong(eventMessage.Z);
            this.f13349b.write(eventMessage.X2);
            this.f13349b.flush();
            return this.f13348a.toByteArray();
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }
}
