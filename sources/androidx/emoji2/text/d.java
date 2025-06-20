package androidx.emoji2.text;

import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.EmojiCompatInitializer;
import java.util.concurrent.ThreadPoolExecutor;

public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ EmojiCompat.MetadataRepoLoaderCallback X;
    public final /* synthetic */ ThreadPoolExecutor Y;
    public final /* synthetic */ EmojiCompatInitializer.BackgroundDefaultLoader s;

    public /* synthetic */ d(EmojiCompatInitializer.BackgroundDefaultLoader backgroundDefaultLoader, EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback, ThreadPoolExecutor threadPoolExecutor) {
        this.s = backgroundDefaultLoader;
        this.X = metadataRepoLoaderCallback;
        this.Y = threadPoolExecutor;
    }

    public final void run() {
        this.s.d(this.X, this.Y);
    }
}
