package androidx.media3.extractor.metadata.id3;

import androidx.media3.common.Format;
import androidx.media3.common.G;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
public abstract class Id3Frame implements Metadata.Entry {
    public final String s;

    public Id3Frame(String str) {
        this.s = str;
    }

    public /* synthetic */ byte[] J() {
        return G.a(this);
    }

    public int describeContents() {
        return 0;
    }

    public /* synthetic */ Format n() {
        return G.b(this);
    }

    public /* synthetic */ void q(MediaMetadata.Builder builder) {
        G.c(this, builder);
    }

    public String toString() {
        return this.s;
    }
}
