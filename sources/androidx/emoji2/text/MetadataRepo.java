package androidx.emoji2.text;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.SparseArray;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.os.TraceCompat;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.flatbuffer.MetadataList;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

@RequiresApi(19)
@AnyThread
public final class MetadataRepo {

    /* renamed from: e  reason: collision with root package name */
    private static final int f7670e = 1024;

    /* renamed from: f  reason: collision with root package name */
    private static final String f7671f = "EmojiCompat.MetadataRepo.create";
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final MetadataList f7672a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final char[] f7673b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final Node f7674c = new Node(1024);
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final Typeface f7675d;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    static class Node {

        /* renamed from: a  reason: collision with root package name */
        private final SparseArray<Node> f7676a;

        /* renamed from: b  reason: collision with root package name */
        private TypefaceEmojiRasterizer f7677b;

        private Node() {
            this(1);
        }

        /* access modifiers changed from: package-private */
        public Node a(int i2) {
            SparseArray<Node> sparseArray = this.f7676a;
            if (sparseArray == null) {
                return null;
            }
            return sparseArray.get(i2);
        }

        /* access modifiers changed from: package-private */
        public final TypefaceEmojiRasterizer b() {
            return this.f7677b;
        }

        /* access modifiers changed from: package-private */
        public void c(@NonNull TypefaceEmojiRasterizer typefaceEmojiRasterizer, int i2, int i3) {
            Node a2 = a(typefaceEmojiRasterizer.b(i2));
            if (a2 == null) {
                a2 = new Node();
                this.f7676a.put(typefaceEmojiRasterizer.b(i2), a2);
            }
            if (i3 > i2) {
                a2.c(typefaceEmojiRasterizer, i2 + 1, i3);
            } else {
                a2.f7677b = typefaceEmojiRasterizer;
            }
        }

        Node(int i2) {
            this.f7676a = new SparseArray<>(i2);
        }
    }

    private MetadataRepo(@NonNull Typeface typeface, @NonNull MetadataList metadataList) {
        this.f7675d = typeface;
        this.f7672a = metadataList;
        this.f7673b = new char[(metadataList.K() * 2)];
        a(metadataList);
    }

    private void a(MetadataList metadataList) {
        int K = metadataList.K();
        for (int i2 = 0; i2 < K; i2++) {
            TypefaceEmojiRasterizer typefaceEmojiRasterizer = new TypefaceEmojiRasterizer(this, i2);
            Character.toChars(typefaceEmojiRasterizer.g(), this.f7673b, i2 * 2);
            k(typefaceEmojiRasterizer);
        }
    }

    @NonNull
    public static MetadataRepo b(@NonNull AssetManager assetManager, @NonNull String str) throws IOException {
        try {
            TraceCompat.b(f7671f);
            return new MetadataRepo(Typeface.createFromAsset(assetManager, str), MetadataListReader.b(assetManager, str));
        } finally {
            TraceCompat.d();
        }
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.TESTS})
    public static MetadataRepo c(@NonNull Typeface typeface) {
        try {
            TraceCompat.b(f7671f);
            return new MetadataRepo(typeface, new MetadataList());
        } finally {
            TraceCompat.d();
        }
    }

    @NonNull
    public static MetadataRepo d(@NonNull Typeface typeface, @NonNull InputStream inputStream) throws IOException {
        try {
            TraceCompat.b(f7671f);
            return new MetadataRepo(typeface, MetadataListReader.c(inputStream));
        } finally {
            TraceCompat.d();
        }
    }

    @NonNull
    public static MetadataRepo e(@NonNull Typeface typeface, @NonNull ByteBuffer byteBuffer) throws IOException {
        try {
            TraceCompat.b(f7671f);
            return new MetadataRepo(typeface, MetadataListReader.d(byteBuffer));
        } finally {
            TraceCompat.d();
        }
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public char[] f() {
        return this.f7673b;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public MetadataList g() {
        return this.f7672a;
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int h() {
        return this.f7672a.S();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Node i() {
        return this.f7674c;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Typeface j() {
        return this.f7675d;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void k(@NonNull TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
        Preconditions.m(typefaceEmojiRasterizer, "emoji metadata cannot be null");
        Preconditions.b(typefaceEmojiRasterizer.c() > 0, "invalid metadata codepoint length");
        this.f7674c.c(typefaceEmojiRasterizer, 0, typefaceEmojiRasterizer.c() - 1);
    }
}
