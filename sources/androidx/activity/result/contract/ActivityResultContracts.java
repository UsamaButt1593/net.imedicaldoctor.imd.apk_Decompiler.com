package androidx.activity.result.contract;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.ext.SdkExtensions;
import android.provider.MediaStore;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.CallSuper;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import com.itextpdf.tool.xml.html.HTML;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0013\u0018\u00002\u00020\u0001:\u0011\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0014"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts;", "", "()V", "CaptureVideo", "CreateDocument", "GetContent", "GetMultipleContents", "OpenDocument", "OpenDocumentTree", "OpenMultipleDocuments", "PickContact", "PickMultipleVisualMedia", "PickVisualMedia", "RequestMultiplePermissions", "RequestPermission", "StartActivityForResult", "StartIntentSenderForResult", "TakePicture", "TakePicturePreview", "TakeVideo", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ActivityResultContracts {

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$CaptureVideo;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroid/net/Uri;", "", "<init>", "()V", "Landroid/content/Context;", "context", "input", "Landroid/content/Intent;", "d", "(Landroid/content/Context;Landroid/net/Uri;)Landroid/content/Intent;", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "e", "(Landroid/content/Context;Landroid/net/Uri;)Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "", "resultCode", "intent", "f", "(ILandroid/content/Intent;)Ljava/lang/Boolean;", "activity_release"}, k = 1, mv = {1, 8, 0})
    public static class CaptureVideo extends ActivityResultContract<Uri, Boolean> {
        @NotNull
        @CallSuper
        /* renamed from: d */
        public Intent a(@NotNull Context context, @NotNull Uri uri) {
            Intrinsics.p(context, "context");
            Intrinsics.p(uri, HTML.Tag.q0);
            Intent putExtra = new Intent("android.media.action.VIDEO_CAPTURE").putExtra(HTML.Tag.U, uri);
            Intrinsics.o(putExtra, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
            return putExtra;
        }

        @Nullable
        /* renamed from: e */
        public final ActivityResultContract.SynchronousResult<Boolean> b(@NotNull Context context, @NotNull Uri uri) {
            Intrinsics.p(context, "context");
            Intrinsics.p(uri, HTML.Tag.q0);
            return null;
        }

        @NotNull
        /* renamed from: f */
        public final Boolean c(int i2, @Nullable Intent intent) {
            return Boolean.valueOf(i2 == -1);
        }
    }

    @RequiresApi(19)
    @SourceDebugExtension({"SMAP\nActivityResultContracts.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityResultContracts.kt\nandroidx/activity/result/contract/ActivityResultContracts$CreateDocument\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,959:1\n1#2:960\n*E\n"})
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0017\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006B\t\b\u0017¢\u0006\u0004\b\u0005\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\f\u0010\rJ'\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0014\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$CreateDocument;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "Landroid/net/Uri;", "mimeType", "<init>", "(Ljava/lang/String;)V", "()V", "Landroid/content/Context;", "context", "input", "Landroid/content/Intent;", "d", "(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "e", "(Landroid/content/Context;Ljava/lang/String;)Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "", "resultCode", "intent", "f", "(ILandroid/content/Intent;)Landroid/net/Uri;", "a", "Ljava/lang/String;", "activity_release"}, k = 1, mv = {1, 8, 0})
    public static class CreateDocument extends ActivityResultContract<String, Uri> {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final String f2496a;

        @Deprecated(message = "Using a wildcard mime type with CreateDocument is not recommended as it breaks the automatic handling of file extensions. Instead, specify the mime type by using the constructor that takes an concrete mime type (e.g.., CreateDocument(\"image/png\")).", replaceWith = @ReplaceWith(expression = "CreateDocument(\"todo/todo\")", imports = {}))
        public CreateDocument() {
            this("*/*");
        }

        @NotNull
        @CallSuper
        /* renamed from: d */
        public Intent a(@NotNull Context context, @NotNull String str) {
            Intrinsics.p(context, "context");
            Intrinsics.p(str, HTML.Tag.q0);
            Intent putExtra = new Intent("android.intent.action.CREATE_DOCUMENT").setType(this.f2496a).putExtra("android.intent.extra.TITLE", str);
            Intrinsics.o(putExtra, "Intent(Intent.ACTION_CRE…ntent.EXTRA_TITLE, input)");
            return putExtra;
        }

        @Nullable
        /* renamed from: e */
        public final ActivityResultContract.SynchronousResult<Uri> b(@NotNull Context context, @NotNull String str) {
            Intrinsics.p(context, "context");
            Intrinsics.p(str, HTML.Tag.q0);
            return null;
        }

        @Nullable
        /* renamed from: f */
        public final Uri c(int i2, @Nullable Intent intent) {
            if (i2 != -1) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }

        public CreateDocument(@NotNull String str) {
            Intrinsics.p(str, "mimeType");
            this.f2496a = str;
        }
    }

    @SourceDebugExtension({"SMAP\nActivityResultContracts.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityResultContracts.kt\nandroidx/activity/result/contract/ActivityResultContracts$GetContent\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,959:1\n1#2:960\n*E\n"})
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0012\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$GetContent;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "Landroid/net/Uri;", "<init>", "()V", "Landroid/content/Context;", "context", "input", "Landroid/content/Intent;", "d", "(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "e", "(Landroid/content/Context;Ljava/lang/String;)Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "", "resultCode", "intent", "f", "(ILandroid/content/Intent;)Landroid/net/Uri;", "activity_release"}, k = 1, mv = {1, 8, 0})
    public static class GetContent extends ActivityResultContract<String, Uri> {
        @NotNull
        @CallSuper
        /* renamed from: d */
        public Intent a(@NotNull Context context, @NotNull String str) {
            Intrinsics.p(context, "context");
            Intrinsics.p(str, HTML.Tag.q0);
            Intent type = new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(str);
            Intrinsics.o(type, "Intent(Intent.ACTION_GET…          .setType(input)");
            return type;
        }

        @Nullable
        /* renamed from: e */
        public final ActivityResultContract.SynchronousResult<Uri> b(@NotNull Context context, @NotNull String str) {
            Intrinsics.p(context, "context");
            Intrinsics.p(str, HTML.Tag.q0);
            return null;
        }

        @Nullable
        /* renamed from: f */
        public final Uri c(int i2, @Nullable Intent intent) {
            if (i2 != -1) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }
    }

    @RequiresApi(18)
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0017\u0018\u0000 \u00162\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u000f\u0012\r\u0012\t\u0012\u00070\u0004¢\u0006\u0002\b\u00050\u00030\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\f\u0010\rJ+\u0010\u000f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$GetMultipleContents;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "Landroid/net/Uri;", "Lkotlin/jvm/JvmSuppressWildcards;", "<init>", "()V", "Landroid/content/Context;", "context", "input", "Landroid/content/Intent;", "d", "(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "e", "(Landroid/content/Context;Ljava/lang/String;)Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "", "resultCode", "intent", "f", "(ILandroid/content/Intent;)Ljava/util/List;", "a", "Companion", "activity_release"}, k = 1, mv = {1, 8, 0})
    public static class GetMultipleContents extends ActivityResultContract<String, List<Uri>> {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final Companion f2497a = new Companion((DefaultConstructorMarker) null);

        @RequiresApi(18)
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$GetMultipleContents$Companion;", "", "<init>", "()V", "Landroid/content/Intent;", "", "Landroid/net/Uri;", "a", "(Landroid/content/Intent;)Ljava/util/List;", "activity_release"}, k = 1, mv = {1, 8, 0})
        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final List<Uri> a(@NotNull Intent intent) {
                Intrinsics.p(intent, "<this>");
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                Uri data = intent.getData();
                if (data != null) {
                    linkedHashSet.add(data);
                }
                ClipData clipData = intent.getClipData();
                if (clipData == null && linkedHashSet.isEmpty()) {
                    return CollectionsKt.E();
                }
                if (clipData != null) {
                    int itemCount = clipData.getItemCount();
                    for (int i2 = 0; i2 < itemCount; i2++) {
                        Uri uri = clipData.getItemAt(i2).getUri();
                        if (uri != null) {
                            linkedHashSet.add(uri);
                        }
                    }
                }
                return new ArrayList(linkedHashSet);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @NotNull
        @CallSuper
        /* renamed from: d */
        public Intent a(@NotNull Context context, @NotNull String str) {
            Intrinsics.p(context, "context");
            Intrinsics.p(str, HTML.Tag.q0);
            Intent putExtra = new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(str).putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            Intrinsics.o(putExtra, "Intent(Intent.ACTION_GET…TRA_ALLOW_MULTIPLE, true)");
            return putExtra;
        }

        @Nullable
        /* renamed from: e */
        public final ActivityResultContract.SynchronousResult<List<Uri>> b(@NotNull Context context, @NotNull String str) {
            Intrinsics.p(context, "context");
            Intrinsics.p(str, HTML.Tag.q0);
            return null;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0007, code lost:
            r2 = f2497a.a(r3);
         */
        @org.jetbrains.annotations.NotNull
        /* renamed from: f */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.util.List<android.net.Uri> c(int r2, @org.jetbrains.annotations.Nullable android.content.Intent r3) {
            /*
                r1 = this;
                r0 = -1
                if (r2 != r0) goto L_0x0004
                goto L_0x0005
            L_0x0004:
                r3 = 0
            L_0x0005:
                if (r3 == 0) goto L_0x0010
                androidx.activity.result.contract.ActivityResultContracts$GetMultipleContents$Companion r2 = f2497a
                java.util.List r2 = r2.a(r3)
                if (r2 == 0) goto L_0x0010
                goto L_0x0014
            L_0x0010:
                java.util.List r2 = kotlin.collections.CollectionsKt.E()
            L_0x0014:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.activity.result.contract.ActivityResultContracts.GetMultipleContents.c(int, android.content.Intent):java.util.List");
        }
    }

    @RequiresApi(19)
    @SourceDebugExtension({"SMAP\nActivityResultContracts.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityResultContracts.kt\nandroidx/activity/result/contract/ActivityResultContracts$OpenDocument\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,959:1\n1#2:960\n*E\n"})
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0017\u0018\u00002\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0017¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$OpenDocument;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "Landroid/net/Uri;", "<init>", "()V", "Landroid/content/Context;", "context", "input", "Landroid/content/Intent;", "d", "(Landroid/content/Context;[Ljava/lang/String;)Landroid/content/Intent;", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "e", "(Landroid/content/Context;[Ljava/lang/String;)Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "", "resultCode", "intent", "f", "(ILandroid/content/Intent;)Landroid/net/Uri;", "activity_release"}, k = 1, mv = {1, 8, 0})
    public static class OpenDocument extends ActivityResultContract<String[], Uri> {
        @NotNull
        @CallSuper
        /* renamed from: d */
        public Intent a(@NotNull Context context, @NotNull String[] strArr) {
            Intrinsics.p(context, "context");
            Intrinsics.p(strArr, HTML.Tag.q0);
            Intent type = new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", strArr).setType("*/*");
            Intrinsics.o(type, "Intent(Intent.ACTION_OPE…          .setType(\"*/*\")");
            return type;
        }

        @Nullable
        /* renamed from: e */
        public final ActivityResultContract.SynchronousResult<Uri> b(@NotNull Context context, @NotNull String[] strArr) {
            Intrinsics.p(context, "context");
            Intrinsics.p(strArr, HTML.Tag.q0);
            return null;
        }

        @Nullable
        /* renamed from: f */
        public final Uri c(int i2, @Nullable Intent intent) {
            if (i2 != -1) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }
    }

    @RequiresApi(21)
    @SourceDebugExtension({"SMAP\nActivityResultContracts.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityResultContracts.kt\nandroidx/activity/result/contract/ActivityResultContracts$OpenDocumentTree\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,959:1\n1#2:960\n*E\n"})
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0017\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0017¢\u0006\u0004\b\t\u0010\nJ)\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$OpenDocumentTree;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroid/net/Uri;", "<init>", "()V", "Landroid/content/Context;", "context", "input", "Landroid/content/Intent;", "d", "(Landroid/content/Context;Landroid/net/Uri;)Landroid/content/Intent;", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "e", "(Landroid/content/Context;Landroid/net/Uri;)Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "", "resultCode", "intent", "f", "(ILandroid/content/Intent;)Landroid/net/Uri;", "activity_release"}, k = 1, mv = {1, 8, 0})
    public static class OpenDocumentTree extends ActivityResultContract<Uri, Uri> {
        @NotNull
        @CallSuper
        /* renamed from: d */
        public Intent a(@NotNull Context context, @Nullable Uri uri) {
            Intrinsics.p(context, "context");
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
            if (Build.VERSION.SDK_INT >= 26 && uri != null) {
                intent.putExtra("android.provider.extra.INITIAL_URI", uri);
            }
            return intent;
        }

        @Nullable
        /* renamed from: e */
        public final ActivityResultContract.SynchronousResult<Uri> b(@NotNull Context context, @Nullable Uri uri) {
            Intrinsics.p(context, "context");
            return null;
        }

        @Nullable
        /* renamed from: f */
        public final Uri c(int i2, @Nullable Intent intent) {
            if (i2 != -1) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }
    }

    @RequiresApi(19)
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0017\u0018\u00002\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000f\u0012\r\u0012\t\u0012\u00070\u0005¢\u0006\u0002\b\u00060\u00040\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0017¢\u0006\u0004\b\r\u0010\u000eJ1\u0010\u0010\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$OpenMultipleDocuments;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "", "Landroid/net/Uri;", "Lkotlin/jvm/JvmSuppressWildcards;", "<init>", "()V", "Landroid/content/Context;", "context", "input", "Landroid/content/Intent;", "d", "(Landroid/content/Context;[Ljava/lang/String;)Landroid/content/Intent;", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "e", "(Landroid/content/Context;[Ljava/lang/String;)Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "", "resultCode", "intent", "f", "(ILandroid/content/Intent;)Ljava/util/List;", "activity_release"}, k = 1, mv = {1, 8, 0})
    public static class OpenMultipleDocuments extends ActivityResultContract<String[], List<Uri>> {
        @NotNull
        @CallSuper
        /* renamed from: d */
        public Intent a(@NotNull Context context, @NotNull String[] strArr) {
            Intrinsics.p(context, "context");
            Intrinsics.p(strArr, HTML.Tag.q0);
            Intent type = new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", strArr).putExtra("android.intent.extra.ALLOW_MULTIPLE", true).setType("*/*");
            Intrinsics.o(type, "Intent(Intent.ACTION_OPE…          .setType(\"*/*\")");
            return type;
        }

        @Nullable
        /* renamed from: e */
        public final ActivityResultContract.SynchronousResult<List<Uri>> b(@NotNull Context context, @NotNull String[] strArr) {
            Intrinsics.p(context, "context");
            Intrinsics.p(strArr, HTML.Tag.q0);
            return null;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0007, code lost:
            r2 = androidx.activity.result.contract.ActivityResultContracts.GetMultipleContents.f2497a.a(r3);
         */
        @org.jetbrains.annotations.NotNull
        /* renamed from: f */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.util.List<android.net.Uri> c(int r2, @org.jetbrains.annotations.Nullable android.content.Intent r3) {
            /*
                r1 = this;
                r0 = -1
                if (r2 != r0) goto L_0x0004
                goto L_0x0005
            L_0x0004:
                r3 = 0
            L_0x0005:
                if (r3 == 0) goto L_0x0010
                androidx.activity.result.contract.ActivityResultContracts$GetMultipleContents$Companion r2 = androidx.activity.result.contract.ActivityResultContracts.GetMultipleContents.f2497a
                java.util.List r2 = r2.a(r3)
                if (r2 == 0) goto L_0x0010
                goto L_0x0014
            L_0x0010:
                java.util.List r2 = kotlin.collections.CollectionsKt.E()
            L_0x0014:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.activity.result.contract.ActivityResultContracts.OpenMultipleDocuments.c(int, android.content.Intent):java.util.List");
        }
    }

    @SourceDebugExtension({"SMAP\nActivityResultContracts.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityResultContracts.kt\nandroidx/activity/result/contract/ActivityResultContracts$PickContact\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,959:1\n1#2:960\n*E\n"})
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$PickContact;", "Landroidx/activity/result/contract/ActivityResultContract;", "Ljava/lang/Void;", "Landroid/net/Uri;", "<init>", "()V", "Landroid/content/Context;", "context", "input", "Landroid/content/Intent;", "d", "(Landroid/content/Context;Ljava/lang/Void;)Landroid/content/Intent;", "", "resultCode", "intent", "e", "(ILandroid/content/Intent;)Landroid/net/Uri;", "activity_release"}, k = 1, mv = {1, 8, 0})
    public static final class PickContact extends ActivityResultContract<Void, Uri> {
        @NotNull
        /* renamed from: d */
        public Intent a(@NotNull Context context, @Nullable Void voidR) {
            Intrinsics.p(context, "context");
            Intent type = new Intent("android.intent.action.PICK").setType("vnd.android.cursor.dir/contact");
            Intrinsics.o(type, "Intent(Intent.ACTION_PIC…ct.Contacts.CONTENT_TYPE)");
            return type;
        }

        @Nullable
        /* renamed from: e */
        public Uri c(int i2, @Nullable Intent intent) {
            if (i2 != -1) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }
    }

    @RequiresApi(19)
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0017\u0018\u0000 \u00192\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u000f\u0012\r\u0012\t\u0012\u00070\u0004¢\u0006\u0002\b\u00050\u00030\u0001:\u0001\u001aB\u0011\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u000e\u0010\u000fJ0\u0010\u0011\u001a\u0015\u0012\u000f\u0012\r\u0012\t\u0012\u00070\u0004¢\u0006\u0002\b\u00050\u0003\u0018\u00010\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$PickMultipleVisualMedia;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroidx/activity/result/PickVisualMediaRequest;", "", "Landroid/net/Uri;", "Lkotlin/jvm/JvmSuppressWildcards;", "", "maxItems", "<init>", "(I)V", "Landroid/content/Context;", "context", "input", "Landroid/content/Intent;", "d", "(Landroid/content/Context;Landroidx/activity/result/PickVisualMediaRequest;)Landroid/content/Intent;", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "e", "(Landroid/content/Context;Landroidx/activity/result/PickVisualMediaRequest;)Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "resultCode", "intent", "f", "(ILandroid/content/Intent;)Ljava/util/List;", "a", "I", "b", "Companion", "activity_release"}, k = 1, mv = {1, 8, 0})
    public static class PickMultipleVisualMedia extends ActivityResultContract<PickVisualMediaRequest, List<Uri>> {
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        public static final Companion f2498b = new Companion((DefaultConstructorMarker) null);

        /* renamed from: a  reason: collision with root package name */
        private final int f2499a;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$PickMultipleVisualMedia$Companion;", "", "<init>", "()V", "", "a", "()I", "activity_release"}, k = 1, mv = {1, 8, 0})
        public static final class Companion {
            private Companion() {
            }

            @SuppressLint({"NewApi", "ClassVerificationFailure"})
            public final int a() {
                if (PickVisualMedia.f2500a.j()) {
                    return MediaStore.getPickImagesMaxLimit();
                }
                return Integer.MAX_VALUE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public PickMultipleVisualMedia() {
            this(0, 1, (DefaultConstructorMarker) null);
        }

        @NotNull
        @CallSuper
        @SuppressLint({"NewApi", "ClassVerificationFailure"})
        /* renamed from: d */
        public Intent a(@NotNull Context context, @NotNull PickVisualMediaRequest pickVisualMediaRequest) {
            Intrinsics.p(context, "context");
            Intrinsics.p(pickVisualMediaRequest, HTML.Tag.q0);
            PickVisualMedia.Companion companion = PickVisualMedia.f2500a;
            if (companion.j()) {
                Intent intent = new Intent("android.provider.action.PICK_IMAGES");
                intent.setType(companion.e(pickVisualMediaRequest.a()));
                if (this.f2499a <= MediaStore.getPickImagesMaxLimit()) {
                    intent.putExtra("android.provider.extra.PICK_IMAGES_MAX", this.f2499a);
                    return intent;
                }
                throw new IllegalArgumentException("Max items must be less or equals MediaStore.getPickImagesMaxLimit()".toString());
            } else if (companion.i(context)) {
                ResolveInfo d2 = companion.d(context);
                if (d2 != null) {
                    ActivityInfo activityInfo = d2.activityInfo;
                    Intent intent2 = new Intent(PickVisualMedia.f2501b);
                    intent2.setClassName(activityInfo.applicationInfo.packageName, activityInfo.name);
                    intent2.setType(companion.e(pickVisualMediaRequest.a()));
                    intent2.putExtra(PickVisualMedia.f2504e, this.f2499a);
                    return intent2;
                }
                throw new IllegalStateException("Required value was null.".toString());
            } else if (companion.f(context)) {
                ResolveInfo c2 = companion.c(context);
                if (c2 != null) {
                    ActivityInfo activityInfo2 = c2.activityInfo;
                    Intent intent3 = new Intent(PickVisualMedia.f2503d);
                    intent3.setClassName(activityInfo2.applicationInfo.packageName, activityInfo2.name);
                    intent3.putExtra(PickVisualMedia.f2504e, this.f2499a);
                    return intent3;
                }
                throw new IllegalStateException("Required value was null.".toString());
            } else {
                Intent intent4 = new Intent("android.intent.action.OPEN_DOCUMENT");
                intent4.setType(companion.e(pickVisualMediaRequest.a()));
                intent4.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
                if (intent4.getType() != null) {
                    return intent4;
                }
                intent4.setType("*/*");
                intent4.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
                return intent4;
            }
        }

        @Nullable
        /* renamed from: e */
        public final ActivityResultContract.SynchronousResult<List<Uri>> b(@NotNull Context context, @NotNull PickVisualMediaRequest pickVisualMediaRequest) {
            Intrinsics.p(context, "context");
            Intrinsics.p(pickVisualMediaRequest, HTML.Tag.q0);
            return null;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0007, code lost:
            r2 = androidx.activity.result.contract.ActivityResultContracts.GetMultipleContents.f2497a.a(r3);
         */
        @org.jetbrains.annotations.NotNull
        /* renamed from: f */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.util.List<android.net.Uri> c(int r2, @org.jetbrains.annotations.Nullable android.content.Intent r3) {
            /*
                r1 = this;
                r0 = -1
                if (r2 != r0) goto L_0x0004
                goto L_0x0005
            L_0x0004:
                r3 = 0
            L_0x0005:
                if (r3 == 0) goto L_0x0010
                androidx.activity.result.contract.ActivityResultContracts$GetMultipleContents$Companion r2 = androidx.activity.result.contract.ActivityResultContracts.GetMultipleContents.f2497a
                java.util.List r2 = r2.a(r3)
                if (r2 == 0) goto L_0x0010
                goto L_0x0014
            L_0x0010:
                java.util.List r2 = kotlin.collections.CollectionsKt.E()
            L_0x0014:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.activity.result.contract.ActivityResultContracts.PickMultipleVisualMedia.c(int, android.content.Intent):java.util.List");
        }

        public PickMultipleVisualMedia(int i2) {
            this.f2499a = i2;
            if (i2 <= 1) {
                throw new IllegalArgumentException("Max items must be higher than 1".toString());
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ PickMultipleVisualMedia(int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? f2498b.a() : i2);
        }
    }

    @RequiresApi(19)
    @SourceDebugExtension({"SMAP\nActivityResultContracts.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityResultContracts.kt\nandroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,959:1\n1#2:960\n*E\n"})
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0017\u0018\u0000 \u00142\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001:\u0006\u0015\u0016\u0017\u0018\u0019\u001aB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0012\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u001b"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroidx/activity/result/PickVisualMediaRequest;", "Landroid/net/Uri;", "<init>", "()V", "Landroid/content/Context;", "context", "input", "Landroid/content/Intent;", "d", "(Landroid/content/Context;Landroidx/activity/result/PickVisualMediaRequest;)Landroid/content/Intent;", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "f", "(Landroid/content/Context;Landroidx/activity/result/PickVisualMediaRequest;)Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "", "resultCode", "intent", "m", "(ILandroid/content/Intent;)Landroid/net/Uri;", "a", "Companion", "ImageAndVideo", "ImageOnly", "SingleMimeType", "VideoOnly", "VisualMediaType", "activity_release"}, k = 1, mv = {1, 8, 0})
    public static class PickVisualMedia extends ActivityResultContract<PickVisualMediaRequest, Uri> {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final Companion f2500a = new Companion((DefaultConstructorMarker) null);
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        public static final String f2501b = "androidx.activity.result.contract.action.PICK_IMAGES";
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        public static final String f2502c = "androidx.activity.result.contract.extra.PICK_IMAGES_MAX";
        @NotNull

        /* renamed from: d  reason: collision with root package name */
        public static final String f2503d = "com.google.android.gms.provider.action.PICK_IMAGES";
        @NotNull

        /* renamed from: e  reason: collision with root package name */
        public static final String f2504e = "com.google.android.gms.provider.extra.PICK_IMAGES_MAX";

        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u000b\u0010\u0006J\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\f\u0010\nJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\u0010\u0010\nJ\u0019\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\u0011\u0010\u000fJ\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0000¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u00148\u0006XT¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u0012\u0004\b\u0019\u0010\u0003R\u001a\u0010\u001a\u001a\u00020\u00148\u0006XT¢\u0006\f\n\u0004\b\u001a\u0010\u0018\u0012\u0004\b\u001b\u0010\u0003R\u0014\u0010\u001c\u001a\u00020\u00148\u0000XT¢\u0006\u0006\n\u0004\b\u001c\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u00148\u0000XT¢\u0006\u0006\n\u0004\b\u001d\u0010\u0018¨\u0006\u001e"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$Companion;", "", "<init>", "()V", "", "g", "()Z", "Landroid/content/Context;", "context", "h", "(Landroid/content/Context;)Z", "j", "i", "Landroid/content/pm/ResolveInfo;", "d", "(Landroid/content/Context;)Landroid/content/pm/ResolveInfo;", "f", "c", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;", "input", "", "e", "(Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;)Ljava/lang/String;", "ACTION_SYSTEM_FALLBACK_PICK_IMAGES", "Ljava/lang/String;", "a", "EXTRA_SYSTEM_FALLBACK_PICK_IMAGES_MAX", "b", "GMS_ACTION_PICK_IMAGES", "GMS_EXTRA_PICK_IMAGES_MAX", "activity_release"}, k = 1, mv = {1, 8, 0})
        public static final class Companion {
            private Companion() {
            }

            public static /* synthetic */ void a() {
            }

            public static /* synthetic */ void b() {
            }

            @JvmStatic
            @Nullable
            public final ResolveInfo c(@NotNull Context context) {
                Intrinsics.p(context, "context");
                return context.getPackageManager().resolveActivity(new Intent(PickVisualMedia.f2503d), 1114112);
            }

            @JvmStatic
            @Nullable
            public final ResolveInfo d(@NotNull Context context) {
                Intrinsics.p(context, "context");
                return context.getPackageManager().resolveActivity(new Intent(PickVisualMedia.f2501b), 1114112);
            }

            @Nullable
            public final String e(@NotNull VisualMediaType visualMediaType) {
                Intrinsics.p(visualMediaType, HTML.Tag.q0);
                if (visualMediaType instanceof ImageOnly) {
                    return "image/*";
                }
                if (visualMediaType instanceof VideoOnly) {
                    return "video/*";
                }
                if (visualMediaType instanceof SingleMimeType) {
                    return ((SingleMimeType) visualMediaType).a();
                }
                if (visualMediaType instanceof ImageAndVideo) {
                    return null;
                }
                throw new NoWhenBranchMatchedException();
            }

            @JvmStatic
            public final boolean f(@NotNull Context context) {
                Intrinsics.p(context, "context");
                return c(context) != null;
            }

            @JvmStatic
            @Deprecated(message = "This method is deprecated in favor of isPhotoPickerAvailable(context) to support the picker provided by updatable system apps", replaceWith = @ReplaceWith(expression = "isPhotoPickerAvailable(context)", imports = {}))
            @SuppressLint({"ClassVerificationFailure", "NewApi"})
            public final boolean g() {
                return j();
            }

            @JvmStatic
            @SuppressLint({"ClassVerificationFailure", "NewApi"})
            public final boolean h(@NotNull Context context) {
                Intrinsics.p(context, "context");
                return j() || i(context) || f(context);
            }

            @JvmStatic
            public final boolean i(@NotNull Context context) {
                Intrinsics.p(context, "context");
                return d(context) != null;
            }

            @JvmStatic
            @SuppressLint({"ClassVerificationFailure", "NewApi"})
            public final boolean j() {
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 33) {
                    return true;
                }
                return i2 >= 30 && SdkExtensions.getExtensionVersion(30) >= 2;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$ImageAndVideo;", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;", "()V", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class ImageAndVideo implements VisualMediaType {
            @NotNull

            /* renamed from: a  reason: collision with root package name */
            public static final ImageAndVideo f2505a = new ImageAndVideo();

            private ImageAndVideo() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$ImageOnly;", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;", "()V", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class ImageOnly implements VisualMediaType {
            @NotNull

            /* renamed from: a  reason: collision with root package name */
            public static final ImageOnly f2506a = new ImageOnly();

            private ImageOnly() {
            }
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b¨\u0006\t"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$SingleMimeType;", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;", "", "mimeType", "<init>", "(Ljava/lang/String;)V", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "activity_release"}, k = 1, mv = {1, 8, 0})
        public static final class SingleMimeType implements VisualMediaType {
            @NotNull

            /* renamed from: a  reason: collision with root package name */
            private final String f2507a;

            public SingleMimeType(@NotNull String str) {
                Intrinsics.p(str, "mimeType");
                this.f2507a = str;
            }

            @NotNull
            public final String a() {
                return this.f2507a;
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VideoOnly;", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;", "()V", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class VideoOnly implements VisualMediaType {
            @NotNull

            /* renamed from: a  reason: collision with root package name */
            public static final VideoOnly f2508a = new VideoOnly();

            private VideoOnly() {
            }
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001\u0001\u0004\u0002\u0003\u0004\u0005ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;", "", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$ImageAndVideo;", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$ImageOnly;", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$SingleMimeType;", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VideoOnly;", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public interface VisualMediaType {
        }

        @JvmStatic
        @Nullable
        public static final ResolveInfo e(@NotNull Context context) {
            return f2500a.c(context);
        }

        @JvmStatic
        @Nullable
        public static final ResolveInfo g(@NotNull Context context) {
            return f2500a.d(context);
        }

        @JvmStatic
        public static final boolean h(@NotNull Context context) {
            return f2500a.f(context);
        }

        @JvmStatic
        @Deprecated(message = "This method is deprecated in favor of isPhotoPickerAvailable(context) to support the picker provided by updatable system apps", replaceWith = @ReplaceWith(expression = "isPhotoPickerAvailable(context)", imports = {}))
        @SuppressLint({"ClassVerificationFailure", "NewApi"})
        public static final boolean i() {
            return f2500a.g();
        }

        @JvmStatic
        @SuppressLint({"ClassVerificationFailure", "NewApi"})
        public static final boolean j(@NotNull Context context) {
            return f2500a.h(context);
        }

        @JvmStatic
        public static final boolean k(@NotNull Context context) {
            return f2500a.i(context);
        }

        @JvmStatic
        @SuppressLint({"ClassVerificationFailure", "NewApi"})
        public static final boolean l() {
            return f2500a.j();
        }

        @NotNull
        @CallSuper
        /* renamed from: d */
        public Intent a(@NotNull Context context, @NotNull PickVisualMediaRequest pickVisualMediaRequest) {
            ActivityInfo activityInfo;
            Intent intent;
            Intrinsics.p(context, "context");
            Intrinsics.p(pickVisualMediaRequest, HTML.Tag.q0);
            Companion companion = f2500a;
            if (companion.j()) {
                Intent intent2 = new Intent("android.provider.action.PICK_IMAGES");
                intent2.setType(companion.e(pickVisualMediaRequest.a()));
                return intent2;
            }
            if (companion.i(context)) {
                ResolveInfo d2 = companion.d(context);
                if (d2 != null) {
                    activityInfo = d2.activityInfo;
                    intent = new Intent(f2501b);
                } else {
                    throw new IllegalStateException("Required value was null.".toString());
                }
            } else if (companion.f(context)) {
                ResolveInfo c2 = companion.c(context);
                if (c2 != null) {
                    activityInfo = c2.activityInfo;
                    intent = new Intent(f2503d);
                } else {
                    throw new IllegalStateException("Required value was null.".toString());
                }
            } else {
                Intent intent3 = new Intent("android.intent.action.OPEN_DOCUMENT");
                intent3.setType(companion.e(pickVisualMediaRequest.a()));
                if (intent3.getType() != null) {
                    return intent3;
                }
                intent3.setType("*/*");
                intent3.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
                return intent3;
            }
            intent.setClassName(activityInfo.applicationInfo.packageName, activityInfo.name);
            intent.setType(companion.e(pickVisualMediaRequest.a()));
            return intent;
        }

        @Nullable
        /* renamed from: f */
        public final ActivityResultContract.SynchronousResult<Uri> b(@NotNull Context context, @NotNull PickVisualMediaRequest pickVisualMediaRequest) {
            Intrinsics.p(context, "context");
            Intrinsics.p(pickVisualMediaRequest, HTML.Tag.q0);
            return null;
        }

        @Nullable
        /* renamed from: m */
        public final Uri c(int i2, @Nullable Intent intent) {
            if (i2 != -1) {
                intent = null;
            }
            if (intent == null) {
                return null;
            }
            Uri data = intent.getData();
            if (data == null) {
                data = (Uri) CollectionsKt.D2(GetMultipleContents.f2497a.a(intent));
            }
            return data;
        }
    }

    @SourceDebugExtension({"SMAP\nActivityResultContracts.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityResultContracts.kt\nandroidx/activity/result/contract/ActivityResultContracts$RequestMultiplePermissions\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,959:1\n12541#2,2:960\n8676#2,2:962\n9358#2,4:964\n11365#2:968\n11700#2,3:969\n*S KotlinDebug\n*F\n+ 1 ActivityResultContracts.kt\nandroidx/activity/result/contract/ActivityResultContracts$RequestMultiplePermissions\n*L\n188#1:960,2\n195#1:962,2\n195#1:964,4\n208#1:968\n208#1:969,3\n*E\n"})
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00172%\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0003\u0012\t\u0012\u00070\u0005¢\u0006\u0002\b\u00060\u00040\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ9\u0010\u0010\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$RequestMultiplePermissions;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "", "", "Lkotlin/jvm/JvmSuppressWildcards;", "<init>", "()V", "Landroid/content/Context;", "context", "input", "Landroid/content/Intent;", "d", "(Landroid/content/Context;[Ljava/lang/String;)Landroid/content/Intent;", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "e", "(Landroid/content/Context;[Ljava/lang/String;)Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "", "resultCode", "intent", "f", "(ILandroid/content/Intent;)Ljava/util/Map;", "a", "Companion", "activity_release"}, k = 1, mv = {1, 8, 0})
    public static final class RequestMultiplePermissions extends ActivityResultContract<String[], Map<String, Boolean>> {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final Companion f2509a = new Companion((DefaultConstructorMarker) null);
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        public static final String f2510b = "androidx.activity.result.contract.action.REQUEST_PERMISSIONS";
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        public static final String f2511c = "androidx.activity.result.contract.extra.PERMISSIONS";
        @NotNull

        /* renamed from: d  reason: collision with root package name */
        public static final String f2512d = "androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS";

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00058\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00058\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00058\u0006XT¢\u0006\u0006\n\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$RequestMultiplePermissions$Companion;", "", "<init>", "()V", "", "", "input", "Landroid/content/Intent;", "a", "([Ljava/lang/String;)Landroid/content/Intent;", "ACTION_REQUEST_PERMISSIONS", "Ljava/lang/String;", "EXTRA_PERMISSIONS", "EXTRA_PERMISSION_GRANT_RESULTS", "activity_release"}, k = 1, mv = {1, 8, 0})
        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final Intent a(@NotNull String[] strArr) {
                Intrinsics.p(strArr, HTML.Tag.q0);
                Intent putExtra = new Intent(RequestMultiplePermissions.f2510b).putExtra(RequestMultiplePermissions.f2511c, strArr);
                Intrinsics.o(putExtra, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
                return putExtra;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @NotNull
        /* renamed from: d */
        public Intent a(@NotNull Context context, @NotNull String[] strArr) {
            Intrinsics.p(context, "context");
            Intrinsics.p(strArr, HTML.Tag.q0);
            return f2509a.a(strArr);
        }

        @Nullable
        /* renamed from: e */
        public ActivityResultContract.SynchronousResult<Map<String, Boolean>> b(@NotNull Context context, @NotNull String[] strArr) {
            Intrinsics.p(context, "context");
            Intrinsics.p(strArr, HTML.Tag.q0);
            if (strArr.length == 0) {
                return new ActivityResultContract.SynchronousResult<>(MapsKt.z());
            }
            for (String a2 : strArr) {
                if (ContextCompat.a(context, a2) != 0) {
                    return null;
                }
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.u(MapsKt.j(strArr.length), 16));
            for (String a3 : strArr) {
                Pair a4 = TuplesKt.a(a3, Boolean.TRUE);
                linkedHashMap.put(a4.e(), a4.f());
            }
            return new ActivityResultContract.SynchronousResult<>(linkedHashMap);
        }

        @NotNull
        /* renamed from: f */
        public Map<String, Boolean> c(int i2, @Nullable Intent intent) {
            if (i2 != -1) {
                return MapsKt.z();
            }
            if (intent == null) {
                return MapsKt.z();
            }
            String[] stringArrayExtra = intent.getStringArrayExtra(f2511c);
            int[] intArrayExtra = intent.getIntArrayExtra(f2512d);
            if (intArrayExtra == null || stringArrayExtra == null) {
                return MapsKt.z();
            }
            ArrayList arrayList = new ArrayList(intArrayExtra.length);
            int length = intArrayExtra.length;
            for (int i3 = 0; i3 < length; i3++) {
                arrayList.add(Boolean.valueOf(intArrayExtra[i3] == 0));
            }
            return MapsKt.B0(CollectionsKt.f6(ArraysKt.Ta(stringArrayExtra), arrayList));
        }
    }

    @SourceDebugExtension({"SMAP\nActivityResultContracts.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityResultContracts.kt\nandroidx/activity/result/contract/ActivityResultContracts$RequestPermission\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,959:1\n12774#2,2:960\n*S KotlinDebug\n*F\n+ 1 ActivityResultContracts.kt\nandroidx/activity/result/contract/ActivityResultContracts$RequestPermission\n*L\n228#1:960,2\n*E\n"})
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00112\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$RequestPermission;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "<init>", "()V", "Landroid/content/Context;", "context", "input", "Landroid/content/Intent;", "d", "(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;", "", "resultCode", "intent", "f", "(ILandroid/content/Intent;)Ljava/lang/Boolean;", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "e", "(Landroid/content/Context;Ljava/lang/String;)Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "activity_release"}, k = 1, mv = {1, 8, 0})
    public static final class RequestPermission extends ActivityResultContract<String, Boolean> {
        @NotNull
        /* renamed from: d */
        public Intent a(@NotNull Context context, @NotNull String str) {
            Intrinsics.p(context, "context");
            Intrinsics.p(str, HTML.Tag.q0);
            return RequestMultiplePermissions.f2509a.a(new String[]{str});
        }

        @Nullable
        /* renamed from: e */
        public ActivityResultContract.SynchronousResult<Boolean> b(@NotNull Context context, @NotNull String str) {
            Intrinsics.p(context, "context");
            Intrinsics.p(str, HTML.Tag.q0);
            if (ContextCompat.a(context, str) == 0) {
                return new ActivityResultContract.SynchronousResult<>(Boolean.TRUE);
            }
            return null;
        }

        @NotNull
        /* renamed from: f */
        public Boolean c(int i2, @Nullable Intent intent) {
            if (intent == null || i2 != -1) {
                return Boolean.FALSE;
            }
            int[] intArrayExtra = intent.getIntArrayExtra(RequestMultiplePermissions.f2512d);
            boolean z = false;
            if (intArrayExtra != null) {
                int length = intArrayExtra.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    } else if (intArrayExtra[i3] == 0) {
                        z = true;
                        break;
                    } else {
                        i3++;
                    }
                }
            }
            return Boolean.valueOf(z);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000e\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$StartActivityForResult;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroid/content/Intent;", "Landroidx/activity/result/ActivityResult;", "<init>", "()V", "Landroid/content/Context;", "context", "input", "d", "(Landroid/content/Context;Landroid/content/Intent;)Landroid/content/Intent;", "", "resultCode", "intent", "e", "(ILandroid/content/Intent;)Landroidx/activity/result/ActivityResult;", "a", "Companion", "activity_release"}, k = 1, mv = {1, 8, 0})
    public static final class StartActivityForResult extends ActivityResultContract<Intent, ActivityResult> {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final Companion f2513a = new Companion((DefaultConstructorMarker) null);
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        public static final String f2514b = "androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE";

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$StartActivityForResult$Companion;", "", "()V", "EXTRA_ACTIVITY_OPTIONS_BUNDLE", "", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @NotNull
        /* renamed from: d */
        public Intent a(@NotNull Context context, @NotNull Intent intent) {
            Intrinsics.p(context, "context");
            Intrinsics.p(intent, HTML.Tag.q0);
            return intent;
        }

        @NotNull
        /* renamed from: e */
        public ActivityResult c(int i2, @Nullable Intent intent) {
            return new ActivityResult(i2, intent);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$StartIntentSenderForResult;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroidx/activity/result/IntentSenderRequest;", "Landroidx/activity/result/ActivityResult;", "<init>", "()V", "Landroid/content/Context;", "context", "input", "Landroid/content/Intent;", "d", "(Landroid/content/Context;Landroidx/activity/result/IntentSenderRequest;)Landroid/content/Intent;", "", "resultCode", "intent", "e", "(ILandroid/content/Intent;)Landroidx/activity/result/ActivityResult;", "a", "Companion", "activity_release"}, k = 1, mv = {1, 8, 0})
    public static final class StartIntentSenderForResult extends ActivityResultContract<IntentSenderRequest, ActivityResult> {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final Companion f2515a = new Companion((DefaultConstructorMarker) null);
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        public static final String f2516b = "androidx.activity.result.contract.action.INTENT_SENDER_REQUEST";
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        public static final String f2517c = "androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST";
        @NotNull

        /* renamed from: d  reason: collision with root package name */
        public static final String f2518d = "androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION";

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$StartIntentSenderForResult$Companion;", "", "()V", "ACTION_INTENT_SENDER_REQUEST", "", "EXTRA_INTENT_SENDER_REQUEST", "EXTRA_SEND_INTENT_EXCEPTION", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @NotNull
        /* renamed from: d */
        public Intent a(@NotNull Context context, @NotNull IntentSenderRequest intentSenderRequest) {
            Intrinsics.p(context, "context");
            Intrinsics.p(intentSenderRequest, HTML.Tag.q0);
            Intent putExtra = new Intent(f2516b).putExtra(f2517c, intentSenderRequest);
            Intrinsics.o(putExtra, "Intent(ACTION_INTENT_SEN…NT_SENDER_REQUEST, input)");
            return putExtra;
        }

        @NotNull
        /* renamed from: e */
        public ActivityResult c(int i2, @Nullable Intent intent) {
            return new ActivityResult(i2, intent);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$TakePicture;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroid/net/Uri;", "", "<init>", "()V", "Landroid/content/Context;", "context", "input", "Landroid/content/Intent;", "d", "(Landroid/content/Context;Landroid/net/Uri;)Landroid/content/Intent;", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "e", "(Landroid/content/Context;Landroid/net/Uri;)Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "", "resultCode", "intent", "f", "(ILandroid/content/Intent;)Ljava/lang/Boolean;", "activity_release"}, k = 1, mv = {1, 8, 0})
    public static class TakePicture extends ActivityResultContract<Uri, Boolean> {
        @NotNull
        @CallSuper
        /* renamed from: d */
        public Intent a(@NotNull Context context, @NotNull Uri uri) {
            Intrinsics.p(context, "context");
            Intrinsics.p(uri, HTML.Tag.q0);
            Intent putExtra = new Intent("android.media.action.IMAGE_CAPTURE").putExtra(HTML.Tag.U, uri);
            Intrinsics.o(putExtra, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
            return putExtra;
        }

        @Nullable
        /* renamed from: e */
        public final ActivityResultContract.SynchronousResult<Boolean> b(@NotNull Context context, @NotNull Uri uri) {
            Intrinsics.p(context, "context");
            Intrinsics.p(uri, HTML.Tag.q0);
            return null;
        }

        @NotNull
        /* renamed from: f */
        public final Boolean c(int i2, @Nullable Intent intent) {
            return Boolean.valueOf(i2 == -1);
        }
    }

    @SourceDebugExtension({"SMAP\nActivityResultContracts.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityResultContracts.kt\nandroidx/activity/result/contract/ActivityResultContracts$TakePicturePreview\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,959:1\n1#2:960\n*E\n"})
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0017¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0012\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$TakePicturePreview;", "Landroidx/activity/result/contract/ActivityResultContract;", "Ljava/lang/Void;", "Landroid/graphics/Bitmap;", "<init>", "()V", "Landroid/content/Context;", "context", "input", "Landroid/content/Intent;", "d", "(Landroid/content/Context;Ljava/lang/Void;)Landroid/content/Intent;", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "e", "(Landroid/content/Context;Ljava/lang/Void;)Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "", "resultCode", "intent", "f", "(ILandroid/content/Intent;)Landroid/graphics/Bitmap;", "activity_release"}, k = 1, mv = {1, 8, 0})
    public static class TakePicturePreview extends ActivityResultContract<Void, Bitmap> {
        @NotNull
        @CallSuper
        /* renamed from: d */
        public Intent a(@NotNull Context context, @Nullable Void voidR) {
            Intrinsics.p(context, "context");
            return new Intent("android.media.action.IMAGE_CAPTURE");
        }

        @Nullable
        /* renamed from: e */
        public final ActivityResultContract.SynchronousResult<Bitmap> b(@NotNull Context context, @Nullable Void voidR) {
            Intrinsics.p(context, "context");
            return null;
        }

        @Nullable
        /* renamed from: f */
        public final Bitmap c(int i2, @Nullable Intent intent) {
            if (i2 != -1) {
                intent = null;
            }
            if (intent != null) {
                return (Bitmap) intent.getParcelableExtra("data");
            }
            return null;
        }
    }

    @SourceDebugExtension({"SMAP\nActivityResultContracts.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityResultContracts.kt\nandroidx/activity/result/contract/ActivityResultContracts$TakeVideo\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,959:1\n1#2:960\n*E\n"})
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0017\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0012\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$TakeVideo;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroid/net/Uri;", "Landroid/graphics/Bitmap;", "<init>", "()V", "Landroid/content/Context;", "context", "input", "Landroid/content/Intent;", "d", "(Landroid/content/Context;Landroid/net/Uri;)Landroid/content/Intent;", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "e", "(Landroid/content/Context;Landroid/net/Uri;)Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "", "resultCode", "intent", "f", "(ILandroid/content/Intent;)Landroid/graphics/Bitmap;", "activity_release"}, k = 1, mv = {1, 8, 0})
    @Deprecated(message = "The thumbnail bitmap is rarely returned and is not a good signal to determine\n      whether the video was actually successfully captured. Use {@link CaptureVideo} instead.")
    public static class TakeVideo extends ActivityResultContract<Uri, Bitmap> {
        @NotNull
        @CallSuper
        /* renamed from: d */
        public Intent a(@NotNull Context context, @NotNull Uri uri) {
            Intrinsics.p(context, "context");
            Intrinsics.p(uri, HTML.Tag.q0);
            Intent putExtra = new Intent("android.media.action.VIDEO_CAPTURE").putExtra(HTML.Tag.U, uri);
            Intrinsics.o(putExtra, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
            return putExtra;
        }

        @Nullable
        /* renamed from: e */
        public final ActivityResultContract.SynchronousResult<Bitmap> b(@NotNull Context context, @NotNull Uri uri) {
            Intrinsics.p(context, "context");
            Intrinsics.p(uri, HTML.Tag.q0);
            return null;
        }

        @Nullable
        /* renamed from: f */
        public final Bitmap c(int i2, @Nullable Intent intent) {
            if (i2 != -1) {
                intent = null;
            }
            if (intent != null) {
                return (Bitmap) intent.getParcelableExtra("data");
            }
            return null;
        }
    }

    private ActivityResultContracts() {
    }
}
