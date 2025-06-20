package androidx.emoji2.text;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.provider.FontRequest;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.EmojiCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DefaultEmojiCompatConfig {

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class DefaultEmojiCompatConfigFactory {
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        private static final String f7569b = "emoji2.text.DefaultEmojiConfig";
        @NonNull

        /* renamed from: c  reason: collision with root package name */
        private static final String f7570c = "androidx.content.action.LOAD_EMOJI_FONT";
        @NonNull

        /* renamed from: d  reason: collision with root package name */
        private static final String f7571d = "emojicompat-emoji-font";

        /* renamed from: a  reason: collision with root package name */
        private final DefaultEmojiCompatConfigHelper f7572a;

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public DefaultEmojiCompatConfigFactory(@Nullable DefaultEmojiCompatConfigHelper defaultEmojiCompatConfigHelper) {
            this.f7572a = defaultEmojiCompatConfigHelper == null ? e() : defaultEmojiCompatConfigHelper;
        }

        @Nullable
        private EmojiCompat.Config a(@NonNull Context context, @Nullable FontRequest fontRequest) {
            if (fontRequest == null) {
                return null;
            }
            return new FontRequestEmojiCompatConfig(context, fontRequest);
        }

        @NonNull
        private List<List<byte[]>> b(@NonNull Signature[] signatureArr) {
            ArrayList arrayList = new ArrayList();
            for (Signature byteArray : signatureArr) {
                arrayList.add(byteArray.toByteArray());
            }
            return Collections.singletonList(arrayList);
        }

        @NonNull
        private FontRequest d(@NonNull ProviderInfo providerInfo, @NonNull PackageManager packageManager) throws PackageManager.NameNotFoundException {
            String str = providerInfo.authority;
            String str2 = providerInfo.packageName;
            return new FontRequest(str, str2, f7571d, b(this.f7572a.b(packageManager, str2)));
        }

        @NonNull
        private static DefaultEmojiCompatConfigHelper e() {
            return Build.VERSION.SDK_INT >= 28 ? new DefaultEmojiCompatConfigHelper_API28() : new DefaultEmojiCompatConfigHelper_API19();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
            r2 = r2.applicationInfo;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean f(@androidx.annotation.Nullable android.content.pm.ProviderInfo r2) {
            /*
                r1 = this;
                if (r2 == 0) goto L_0x000d
                android.content.pm.ApplicationInfo r2 = r2.applicationInfo
                if (r2 == 0) goto L_0x000d
                int r2 = r2.flags
                r0 = 1
                r2 = r2 & r0
                if (r2 != r0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                r0 = 0
            L_0x000e:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.DefaultEmojiCompatConfig.DefaultEmojiCompatConfigFactory.f(android.content.pm.ProviderInfo):boolean");
        }

        @Nullable
        private ProviderInfo g(@NonNull PackageManager packageManager) {
            for (ResolveInfo a2 : this.f7572a.c(packageManager, new Intent(f7570c), 0)) {
                ProviderInfo a3 = this.f7572a.a(a2);
                if (f(a3)) {
                    return a3;
                }
            }
            return null;
        }

        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public EmojiCompat.Config c(@NonNull Context context) {
            return a(context, h(context));
        }

        /* access modifiers changed from: package-private */
        @VisibleForTesting
        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public FontRequest h(@NonNull Context context) {
            PackageManager packageManager = context.getPackageManager();
            Preconditions.m(packageManager, "Package manager required to locate emoji font provider");
            ProviderInfo g2 = g(packageManager);
            if (g2 == null) {
                return null;
            }
            try {
                return d(g2, packageManager);
            } catch (PackageManager.NameNotFoundException e2) {
                Log.wtf(f7569b, e2);
                return null;
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class DefaultEmojiCompatConfigHelper {
        @Nullable
        public ProviderInfo a(@NonNull ResolveInfo resolveInfo) {
            throw new IllegalStateException("Unable to get provider info prior to API 19");
        }

        @NonNull
        public Signature[] b(@NonNull PackageManager packageManager, @NonNull String str) throws PackageManager.NameNotFoundException {
            return packageManager.getPackageInfo(str, 64).signatures;
        }

        @NonNull
        public List<ResolveInfo> c(@NonNull PackageManager packageManager, @NonNull Intent intent, int i2) {
            return Collections.emptyList();
        }
    }

    @RequiresApi(19)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class DefaultEmojiCompatConfigHelper_API19 extends DefaultEmojiCompatConfigHelper {
        @Nullable
        public ProviderInfo a(@NonNull ResolveInfo resolveInfo) {
            return resolveInfo.providerInfo;
        }

        @NonNull
        public List<ResolveInfo> c(@NonNull PackageManager packageManager, @NonNull Intent intent, int i2) {
            return packageManager.queryIntentContentProviders(intent, i2);
        }
    }

    @RequiresApi(28)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class DefaultEmojiCompatConfigHelper_API28 extends DefaultEmojiCompatConfigHelper_API19 {
        @NonNull
        public Signature[] b(@NonNull PackageManager packageManager, @NonNull String str) throws PackageManager.NameNotFoundException {
            return packageManager.getPackageInfo(str, 64).signatures;
        }
    }

    private DefaultEmojiCompatConfig() {
    }

    @Nullable
    public static FontRequestEmojiCompatConfig a(@NonNull Context context) {
        return (FontRequestEmojiCompatConfig) new DefaultEmojiCompatConfigFactory((DefaultEmojiCompatConfigHelper) null).c(context);
    }
}
