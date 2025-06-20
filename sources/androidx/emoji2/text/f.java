package androidx.emoji2.text;

import androidx.emoji2.text.FontRequestEmojiCompatConfig;

public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ FontRequestEmojiCompatConfig.FontRequestMetadataLoader s;

    public /* synthetic */ f(FontRequestEmojiCompatConfig.FontRequestMetadataLoader fontRequestMetadataLoader) {
        this.s = fontRequestMetadataLoader;
    }

    public final void run() {
        this.s.d();
    }
}
