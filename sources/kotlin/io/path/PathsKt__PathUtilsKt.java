package kotlin.io.path;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import java.net.URI;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileStore;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.UserPrincipal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.WasExperimental;
import kotlin.collections.SetsKt;
import kotlin.internal.InlineOnly;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;
import org.apache.commons.httpclient.cookie.Cookie2;
import org.apache.commons.lang3.ClassUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\u001a\u0014\u0010\u0001\u001a\u00020\u0000*\u00020\u0000H\b¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u0000H\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a\u001b\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\t\u0010\b\u001a\u001d\u0010\n\u001a\u0004\u0018\u00010\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\n\u0010\b\u001a&\u0010\u000e\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\fH\b¢\u0006\u0004\b\u000e\u0010\u000f\u001a0\u0010\u0013\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00002\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0010\"\u00020\u0011H\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a(\u0010\u0016\u001a\u00020\f*\u00020\u00002\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0010\"\u00020\u0015H\b¢\u0006\u0004\b\u0016\u0010\u0017\u001a(\u0010\u0018\u001a\u00020\f*\u00020\u00002\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0010\"\u00020\u0015H\b¢\u0006\u0004\b\u0018\u0010\u0017\u001a(\u0010\u0019\u001a\u00020\f*\u00020\u00002\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0010\"\u00020\u0015H\b¢\u0006\u0004\b\u0019\u0010\u0017\u001a(\u0010\u001a\u001a\u00020\f*\u00020\u00002\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0010\"\u00020\u0015H\b¢\u0006\u0004\b\u001a\u0010\u0017\u001a\u0014\u0010\u001b\u001a\u00020\f*\u00020\u0000H\b¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0014\u0010\u001d\u001a\u00020\f*\u00020\u0000H\b¢\u0006\u0004\b\u001d\u0010\u001c\u001a\u0014\u0010\u001e\u001a\u00020\f*\u00020\u0000H\b¢\u0006\u0004\b\u001e\u0010\u001c\u001a\u0014\u0010\u001f\u001a\u00020\f*\u00020\u0000H\b¢\u0006\u0004\b\u001f\u0010\u001c\u001a\u0014\u0010 \u001a\u00020\f*\u00020\u0000H\b¢\u0006\u0004\b \u0010\u001c\u001a\u001c\u0010\"\u001a\u00020\f*\u00020\u00002\u0006\u0010!\u001a\u00020\u0000H\b¢\u0006\u0004\b\"\u0010#\u001a#\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00000%*\u00020\u00002\b\b\u0002\u0010$\u001a\u00020\u0003H\u0007¢\u0006\u0004\b&\u0010'\u001aA\u0010,\u001a\u00028\u0000\"\u0004\b\u0000\u0010(*\u00020\u00002\b\b\u0002\u0010$\u001a\u00020\u00032\u0018\u0010+\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000*\u0012\u0004\u0012\u00028\u00000)H\bø\u0001\u0000¢\u0006\u0004\b,\u0010-\u001a5\u00100\u001a\u00020.*\u00020\u00002\b\b\u0002\u0010$\u001a\u00020\u00032\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020.0)H\bø\u0001\u0000¢\u0006\u0004\b0\u00101\u001a\u0014\u00103\u001a\u000202*\u00020\u0000H\b¢\u0006\u0004\b3\u00104\u001a\u0014\u00105\u001a\u00020.*\u00020\u0000H\b¢\u0006\u0004\b5\u00106\u001a\u0014\u00107\u001a\u00020\f*\u00020\u0000H\b¢\u0006\u0004\b7\u0010\u001c\u001a0\u0010:\u001a\u00020\u0000*\u00020\u00002\u001a\u00109\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u0003080\u0010\"\u0006\u0012\u0002\b\u000308H\b¢\u0006\u0004\b:\u0010;\u001a0\u0010<\u001a\u00020\u0000*\u00020\u00002\u001a\u00109\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u0003080\u0010\"\u0006\u0012\u0002\b\u000308H\b¢\u0006\u0004\b<\u0010;\u001a/\u0010=\u001a\u00020\u0000*\u00020\u00002\u001a\u00109\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u0003080\u0010\"\u0006\u0012\u0002\b\u000308H\u0007¢\u0006\u0004\b=\u0010;\u001a0\u0010>\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00002\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0010\"\u00020\u0011H\b¢\u0006\u0004\b>\u0010\u0014\u001a&\u0010?\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\fH\b¢\u0006\u0004\b?\u0010\u000f\u001a\u0014\u0010A\u001a\u00020@*\u00020\u0000H\b¢\u0006\u0004\bA\u0010B\u001a2\u0010E\u001a\u0004\u0018\u00010D*\u00020\u00002\u0006\u0010C\u001a\u00020\u00032\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0010\"\u00020\u0015H\b¢\u0006\u0004\bE\u0010F\u001a:\u0010H\u001a\u00020\u0000*\u00020\u00002\u0006\u0010C\u001a\u00020\u00032\b\u0010G\u001a\u0004\u0018\u00010D2\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0010\"\u00020\u0015H\b¢\u0006\u0004\bH\u0010I\u001a6\u0010L\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010K\u0018\u0001*\u00020J*\u00020\u00002\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0010\"\u00020\u0015H\b¢\u0006\u0004\bL\u0010M\u001a4\u0010N\u001a\u00028\u0000\"\n\b\u0000\u0010K\u0018\u0001*\u00020J*\u00020\u00002\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0010\"\u00020\u0015H\b¢\u0006\u0004\bN\u0010M\u001a#\u0010S\u001a\u00020R2\u0006\u0010O\u001a\u00020\u00002\n\u0010Q\u001a\u0006\u0012\u0002\b\u00030PH\u0001¢\u0006\u0004\bS\u0010T\u001a4\u0010W\u001a\u00028\u0000\"\n\b\u0000\u0010V\u0018\u0001*\u00020U*\u00020\u00002\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0010\"\u00020\u0015H\b¢\u0006\u0004\bW\u0010X\u001a>\u0010Z\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010D0Y*\u00020\u00002\u0006\u00109\u001a\u00020\u00032\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0010\"\u00020\u0015H\b¢\u0006\u0004\bZ\u0010[\u001a(\u0010]\u001a\u00020\\*\u00020\u00002\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0010\"\u00020\u0015H\b¢\u0006\u0004\b]\u0010^\u001a\u001c\u0010_\u001a\u00020\u0000*\u00020\u00002\u0006\u0010G\u001a\u00020\\H\b¢\u0006\u0004\b_\u0010`\u001a*\u0010b\u001a\u0004\u0018\u00010a*\u00020\u00002\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0010\"\u00020\u0015H\b¢\u0006\u0004\bb\u0010c\u001a\u001c\u0010d\u001a\u00020\u0000*\u00020\u00002\u0006\u0010G\u001a\u00020aH\b¢\u0006\u0004\bd\u0010e\u001a.\u0010h\u001a\b\u0012\u0004\u0012\u00020g0f*\u00020\u00002\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0010\"\u00020\u0015H\b¢\u0006\u0004\bh\u0010i\u001a\"\u0010j\u001a\u00020\u0000*\u00020\u00002\f\u0010G\u001a\b\u0012\u0004\u0012\u00020g0fH\b¢\u0006\u0004\bj\u0010k\u001a\u001c\u0010l\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000H\b¢\u0006\u0004\bl\u0010\b\u001a8\u0010m\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00002\u001a\u00109\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u0003080\u0010\"\u0006\u0012\u0002\b\u000308H\b¢\u0006\u0004\bm\u0010n\u001a\u0014\u0010o\u001a\u00020\u0000*\u00020\u0000H\b¢\u0006\u0004\bo\u0010\u0002\u001a0\u0010p\u001a\u00020\u0000*\u00020\u00002\u001a\u00109\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u0003080\u0010\"\u0006\u0012\u0002\b\u000308H\b¢\u0006\u0004\bp\u0010;\u001aD\u0010s\u001a\u00020\u00002\n\b\u0002\u0010q\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010r\u001a\u0004\u0018\u00010\u00032\u001a\u00109\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u0003080\u0010\"\u0006\u0012\u0002\b\u000308H\b¢\u0006\u0004\bs\u0010t\u001aM\u0010v\u001a\u00020\u00002\b\u0010u\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010q\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010r\u001a\u0004\u0018\u00010\u00032\u001a\u00109\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u0003080\u0010\"\u0006\u0012\u0002\b\u000308H\u0007¢\u0006\u0004\bv\u0010w\u001a8\u0010x\u001a\u00020\u00002\n\b\u0002\u0010q\u001a\u0004\u0018\u00010\u00032\u001a\u00109\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u0003080\u0010\"\u0006\u0012\u0002\b\u000308H\b¢\u0006\u0004\bx\u0010y\u001aA\u0010z\u001a\u00020\u00002\b\u0010u\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010q\u001a\u0004\u0018\u00010\u00032\u001a\u00109\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u0003080\u0010\"\u0006\u0012\u0002\b\u000308H\u0007¢\u0006\u0004\bz\u0010{\u001a\u001c\u0010|\u001a\u00020\u0000*\u00020\u00002\u0006\u0010!\u001a\u00020\u0000H\n¢\u0006\u0004\b|\u0010\b\u001a\u001c\u0010}\u001a\u00020\u0000*\u00020\u00002\u0006\u0010!\u001a\u00020\u0003H\n¢\u0006\u0004\b}\u0010~\u001a\u0019\u0010\u001a\u00020\u00002\u0006\u0010O\u001a\u00020\u0003H\b¢\u0006\u0005\b\u0010\u0001\u001a0\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00032\u0013\u0010\u0001\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0010\"\u00020\u0003H\b¢\u0006\u0006\b\u0001\u0010\u0001\u001a\u0018\u0010\u0001\u001a\u00020\u0000*\u00030\u0001H\b¢\u0006\u0006\b\u0001\u0010\u0001\u001a2\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00000**\u00020\u00002\u0014\u0010\u0012\u001a\u000b\u0012\u0007\b\u0001\u0012\u00030\u00010\u0010\"\u00030\u0001H\u0007¢\u0006\u0006\b\u0001\u0010\u0001\u001a=\u0010\u0001\u001a\u00020.*\u00020\u00002\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020\u00000\u00012\n\b\u0002\u0010\u0001\u001a\u00030\u00012\t\b\u0002\u0010\u0001\u001a\u00020\fH\u0007¢\u0006\u0006\b\u0001\u0010\u0001\u001aV\u0010\u0001\u001a\u00020.*\u00020\u00002\n\b\u0002\u0010\u0001\u001a\u00030\u00012\t\b\u0002\u0010\u0001\u001a\u00020\f2\u001a\u0010\u0001\u001a\u0015\u0012\u0005\u0012\u00030\u0001\u0012\u0004\u0012\u00020.0)¢\u0006\u0003\b\u0001H\u0007\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0003 \u0001¢\u0006\u0006\b\u0001\u0010\u0001\u001aB\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020\u00000\u00012\u001a\u0010\u0001\u001a\u0015\u0012\u0005\u0012\u00030\u0001\u0012\u0004\u0012\u00020.0)¢\u0006\u0003\b\u0001H\u0007\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0006\b\u0001\u0010\u0001\"!\u0010\u0001\u001a\u00020\u0003*\u00020\u00008FX\u0004¢\u0006\u000e\u0012\u0005\b\u0001\u00106\u001a\u0005\b\u0001\u0010\u0005\"!\u0010\u0001\u001a\u00020\u0003*\u00020\u00008FX\u0004¢\u0006\u000e\u0012\u0005\b\u0001\u00106\u001a\u0005\b\u0001\u0010\u0005\"!\u0010 \u0001\u001a\u00020\u0003*\u00020\u00008FX\u0004¢\u0006\u000e\u0012\u0005\b\u0001\u00106\u001a\u0005\b\u0001\u0010\u0005\"\"\u0010£\u0001\u001a\u00020\u0003*\u00020\u00008Æ\u0002X\u0004¢\u0006\u000e\u0012\u0005\b¢\u0001\u00106\u001a\u0005\b¡\u0001\u0010\u0005\"!\u0010¦\u0001\u001a\u00020\u0003*\u00020\u00008FX\u0004¢\u0006\u000e\u0012\u0005\b¥\u0001\u00106\u001a\u0005\b¤\u0001\u0010\u0005\"\"\u0010©\u0001\u001a\u00020\u0003*\u00020\u00008Æ\u0002X\u0004¢\u0006\u000e\u0012\u0005\b¨\u0001\u00106\u001a\u0005\b§\u0001\u0010\u0005\u0002\u0007\n\u0005\b20\u0001¨\u0006ª\u0001"}, d2 = {"Ljava/nio/file/Path;", "d0", "(Ljava/nio/file/Path;)Ljava/nio/file/Path;", "", "e0", "(Ljava/nio/file/Path;)Ljava/lang/String;", "base", "q1", "(Ljava/nio/file/Path;Ljava/nio/file/Path;)Ljava/nio/file/Path;", "s1", "r1", "target", "", "overwrite", "f0", "(Ljava/nio/file/Path;Ljava/nio/file/Path;Z)Ljava/nio/file/Path;", "", "Ljava/nio/file/CopyOption;", "options", "g0", "(Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/CopyOption;)Ljava/nio/file/Path;", "Ljava/nio/file/LinkOption;", "A0", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Z", "m1", "d1", "Z0", "f1", "(Ljava/nio/file/Path;)Z", "a1", "b1", "c1", "g1", "other", "e1", "(Ljava/nio/file/Path;Ljava/nio/file/Path;)Z", "glob", "", "h1", "(Ljava/nio/file/Path;Ljava/lang/String;)Ljava/util/List;", "T", "Lkotlin/Function1;", "Lkotlin/sequences/Sequence;", "block", "y1", "(Ljava/nio/file/Path;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "", "action", "H0", "(Ljava/nio/file/Path;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "", "E0", "(Ljava/nio/file/Path;)J", "w0", "(Ljava/nio/file/Path;)V", "x0", "Ljava/nio/file/attribute/FileAttribute;", "attributes", "j0", "(Ljava/nio/file/Path;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "i0", "m0", "k1", "j1", "Ljava/nio/file/FileStore;", "F0", "(Ljava/nio/file/Path;)Ljava/nio/file/FileStore;", "attribute", "", "J0", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/LinkOption;)Ljava/lang/Object;", "value", "t1", "(Ljava/nio/file/Path;Ljava/lang/String;Ljava/lang/Object;[Ljava/nio/file/LinkOption;)Ljava/nio/file/Path;", "Ljava/nio/file/attribute/FileAttributeView;", "V", "D0", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/FileAttributeView;", "C0", "path", "Ljava/lang/Class;", "attributeViewClass", "", "B0", "(Ljava/nio/file/Path;Ljava/lang/Class;)Ljava/lang/Void;", "Ljava/nio/file/attribute/BasicFileAttributes;", "A", "n1", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/BasicFileAttributes;", "", "o1", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/LinkOption;)Ljava/util/Map;", "Ljava/nio/file/attribute/FileTime;", "Q0", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/FileTime;", "u1", "(Ljava/nio/file/Path;Ljava/nio/file/attribute/FileTime;)Ljava/nio/file/Path;", "Ljava/nio/file/attribute/UserPrincipal;", "V0", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/UserPrincipal;", "v1", "(Ljava/nio/file/Path;Ljava/nio/file/attribute/UserPrincipal;)Ljava/nio/file/Path;", "", "Ljava/nio/file/attribute/PosixFilePermission;", "Y0", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/util/Set;", "w1", "(Ljava/nio/file/Path;Ljava/util/Set;)Ljava/nio/file/Path;", "l0", "n0", "(Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "p1", "k0", "prefix", "suffix", "s0", "(Ljava/lang/String;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "directory", "t0", "(Ljava/nio/file/Path;Ljava/lang/String;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "o0", "(Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "p0", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "z0", "y0", "(Ljava/nio/file/Path;Ljava/lang/String;)Ljava/nio/file/Path;", "b0", "(Ljava/lang/String;)Ljava/nio/file/Path;", "subpaths", "c0", "(Ljava/lang/String;[Ljava/lang/String;)Ljava/nio/file/Path;", "Ljava/net/URI;", "x1", "(Ljava/net/URI;)Ljava/nio/file/Path;", "Lkotlin/io/path/PathWalkOption;", "E1", "(Ljava/nio/file/Path;[Lkotlin/io/path/PathWalkOption;)Lkotlin/sequences/Sequence;", "Ljava/nio/file/FileVisitor;", "visitor", "", "maxDepth", "followLinks", "B1", "(Ljava/nio/file/Path;Ljava/nio/file/FileVisitor;IZ)V", "Lkotlin/io/path/FileVisitorBuilder;", "Lkotlin/ExtensionFunctionType;", "builderAction", "A1", "(Ljava/nio/file/Path;IZLkotlin/jvm/functions/Function1;)V", "G0", "(Lkotlin/jvm/functions/Function1;)Ljava/nio/file/FileVisitor;", "R0", "S0", "name", "T0", "U0", "nameWithoutExtension", "K0", "L0", "extension", "W0", "X0", "pathString", "O0", "P0", "invariantSeparatorsPathString", "M0", "N0", "invariantSeparatorsPath", "kotlin-stdlib-jdk7"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/io/path/PathsKt")
@SourceDebugExtension({"SMAP\nPathUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathUtils.kt\nkotlin/io/path/PathsKt__PathUtilsKt\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1174:1\n26#2:1175\n26#2:1179\n1#3:1176\n1855#4,2:1177\n*S KotlinDebug\n*F\n+ 1 PathUtils.kt\nkotlin/io/path/PathsKt__PathUtilsKt\n*L\n221#1:1175\n616#1:1179\n440#1:1177,2\n*E\n"})
class PathsKt__PathUtilsKt extends PathsKt__PathRecursiveFunctionsKt {
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final boolean A0(Path path, LinkOption... linkOptionArr) {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(linkOptionArr, "options");
        return Files.exists(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalPathApi
    public static final void A1(@NotNull Path path, int i2, boolean z, @NotNull Function1<? super FileVisitorBuilder, Unit> function1) {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(function1, "builderAction");
        B1(path, G0(function1), i2, z);
    }

    @NotNull
    @PublishedApi
    public static final Void B0(@NotNull Path path, @NotNull Class<?> cls) {
        Intrinsics.p(path, Cookie2.PATH);
        Intrinsics.p(cls, "attributeViewClass");
        throw new UnsupportedOperationException("The desired attribute view type " + cls + " is not available for the file " + path + ClassUtils.PACKAGE_SEPARATOR_CHAR);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalPathApi
    public static final void B1(@NotNull Path path, @NotNull FileVisitor<Path> fileVisitor, int i2, boolean z) {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(fileVisitor, "visitor");
        Path unused = Files.walkFileTree(path, z ? SetsKt.f(FileVisitOption.FOLLOW_LINKS) : SetsKt.k(), i2, fileVisitor);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final /* synthetic */ <V extends FileAttributeView> V C0(Path path, LinkOption... linkOptionArr) {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(linkOptionArr, "options");
        Intrinsics.y(4, ExifInterface.X4);
        FileAttributeView a2 = Files.getFileAttributeView(path, S0.a(), (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        if (a2 != null) {
            return C0528o0.a(a2);
        }
        Intrinsics.y(4, ExifInterface.X4);
        B0(path, S0.a());
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ void C1(Path path, int i2, boolean z, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = Integer.MAX_VALUE;
        }
        if ((i3 & 2) != 0) {
            z = false;
        }
        A1(path, i2, z, function1);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final /* synthetic */ <V extends FileAttributeView> V D0(Path path, LinkOption... linkOptionArr) {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(linkOptionArr, "options");
        Intrinsics.y(4, ExifInterface.X4);
        return Files.getFileAttributeView(path, S0.a(), (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    public static /* synthetic */ void D1(Path path, FileVisitor fileVisitor, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = Integer.MAX_VALUE;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        B1(path, fileVisitor, i2, z);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final long E0(Path path) throws IOException {
        Intrinsics.p(path, "<this>");
        return Files.size(path);
    }

    @SinceKotlin(version = "1.7")
    @NotNull
    @ExperimentalPathApi
    public static final Sequence<Path> E1(@NotNull Path path, @NotNull PathWalkOption... pathWalkOptionArr) {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(pathWalkOptionArr, "options");
        return new PathTreeWalk(path, pathWalkOptionArr);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final FileStore F0(Path path) throws IOException {
        Intrinsics.p(path, "<this>");
        FileStore a2 = Files.getFileStore(path);
        Intrinsics.o(a2, "getFileStore(this)");
        return a2;
    }

    @SinceKotlin(version = "1.7")
    @NotNull
    @ExperimentalPathApi
    public static final FileVisitor<Path> G0(@NotNull Function1<? super FileVisitorBuilder, Unit> function1) {
        Intrinsics.p(function1, "builderAction");
        FileVisitorBuilderImpl fileVisitorBuilderImpl = new FileVisitorBuilderImpl();
        function1.f(fileVisitorBuilderImpl);
        return fileVisitorBuilderImpl.e();
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final void H0(Path path, String str, Function1<? super Path, Unit> function1) throws IOException {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(str, "glob");
        Intrinsics.p(function1, "action");
        DirectoryStream a2 = Files.newDirectoryStream(path, str);
        try {
            DirectoryStream<Object> a3 = C0506d0.a(a2);
            Intrinsics.o(a3, "it");
            for (Object f2 : a3) {
                function1.f(f2);
            }
            Unit unit = Unit.f28779a;
            InlineMarker.d(1);
            CloseableKt.a(a2, (Throwable) null);
            InlineMarker.c(1);
        } catch (Throwable th) {
            InlineMarker.d(1);
            CloseableKt.a(a2, th);
            InlineMarker.c(1);
            throw th;
        }
    }

    static /* synthetic */ void I0(Path path, String str, Function1 function1, int i2, Object obj) throws IOException {
        if ((i2 & 1) != 0) {
            str = "*";
        }
        Intrinsics.p(path, "<this>");
        Intrinsics.p(str, "glob");
        Intrinsics.p(function1, "action");
        DirectoryStream a2 = Files.newDirectoryStream(path, str);
        try {
            DirectoryStream<Object> a3 = C0506d0.a(a2);
            Intrinsics.o(a3, "it");
            for (Object f2 : a3) {
                function1.f(f2);
            }
            Unit unit = Unit.f28779a;
            InlineMarker.d(1);
            CloseableKt.a(a2, (Throwable) null);
            InlineMarker.c(1);
        } catch (Throwable th) {
            InlineMarker.d(1);
            CloseableKt.a(a2, th);
            InlineMarker.c(1);
            throw th;
        }
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Object J0(Path path, String str, LinkOption... linkOptionArr) throws IOException {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(str, "attribute");
        Intrinsics.p(linkOptionArr, "options");
        return Files.getAttribute(path, str, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0013, code lost:
        r2 = kotlin.text.StringsKt.o5((r2 = r2.toString()), org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR, "");
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String K0(@org.jetbrains.annotations.NotNull java.nio.file.Path r2) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.p(r2, r0)
            java.nio.file.Path r2 = r2.getFileName()
            java.lang.String r0 = ""
            if (r2 == 0) goto L_0x001d
            java.lang.String r2 = r2.toString()
            if (r2 == 0) goto L_0x001d
            r1 = 46
            java.lang.String r2 = kotlin.text.StringsKt.o5(r2, r1, r0)
            if (r2 != 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r0 = r2
        L_0x001d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathsKt__PathUtilsKt.K0(java.nio.file.Path):java.lang.String");
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static /* synthetic */ void L0(Path path) {
    }

    private static final String M0(Path path) {
        Intrinsics.p(path, "<this>");
        return O0(path);
    }

    @SinceKotlin(version = "1.4")
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use invariantSeparatorsPathString property instead.", replaceWith = @ReplaceWith(expression = "invariantSeparatorsPathString", imports = {}))
    @InlineOnly
    @ExperimentalPathApi
    public static /* synthetic */ void N0(Path path) {
    }

    @NotNull
    public static final String O0(@NotNull Path path) {
        Intrinsics.p(path, "<this>");
        String a2 = path.getFileSystem().getSeparator();
        if (Intrinsics.g(a2, "/")) {
            return path.toString();
        }
        String obj = path.toString();
        Intrinsics.o(a2, "separator");
        return StringsKt.i2(obj, a2, "/", false, 4, (Object) null);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static /* synthetic */ void P0(Path path) {
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final FileTime Q0(Path path, LinkOption... linkOptionArr) throws IOException {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(linkOptionArr, "options");
        FileTime a2 = Files.getLastModifiedTime(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        Intrinsics.o(a2, "getLastModifiedTime(this, *options)");
        return a2;
    }

    @NotNull
    public static final String R0(@NotNull Path path) {
        Intrinsics.p(path, "<this>");
        Path a2 = path.getFileName();
        String obj = a2 != null ? a2.toString() : null;
        return obj == null ? "" : obj;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static /* synthetic */ void S0(Path path) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0011, code lost:
        r3 = kotlin.text.StringsKt.z5((r3 = r3.toString()), ".", (java.lang.String) null, 2, (java.lang.Object) null);
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String T0(@org.jetbrains.annotations.NotNull java.nio.file.Path r3) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.p(r3, r0)
            java.nio.file.Path r3 = r3.getFileName()
            if (r3 == 0) goto L_0x001b
            java.lang.String r3 = r3.toString()
            if (r3 == 0) goto L_0x001b
            java.lang.String r0 = "."
            r1 = 2
            r2 = 0
            java.lang.String r3 = kotlin.text.StringsKt.z5(r3, r0, r2, r1, r2)
            if (r3 != 0) goto L_0x001d
        L_0x001b:
            java.lang.String r3 = ""
        L_0x001d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathsKt__PathUtilsKt.T0(java.nio.file.Path):java.lang.String");
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static /* synthetic */ void U0(Path path) {
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final UserPrincipal V0(Path path, LinkOption... linkOptionArr) throws IOException {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(linkOptionArr, "options");
        return Files.getOwner(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    private static final String W0(Path path) {
        Intrinsics.p(path, "<this>");
        return path.toString();
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static /* synthetic */ void X0(Path path) {
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Set<PosixFilePermission> Y0(Path path, LinkOption... linkOptionArr) throws IOException {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(linkOptionArr, "options");
        Set<PosixFilePermission> a2 = Files.getPosixFilePermissions(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        Intrinsics.o(a2, "getPosixFilePermissions(this, *options)");
        return a2;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final boolean Z0(Path path, LinkOption... linkOptionArr) {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(linkOptionArr, "options");
        return Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final boolean a1(Path path) {
        Intrinsics.p(path, "<this>");
        return Files.isExecutable(path);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path b0(String str) {
        Intrinsics.p(str, Cookie2.PATH);
        Path a2 = Paths.get(str, new String[0]);
        Intrinsics.o(a2, "get(path)");
        return a2;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final boolean b1(Path path) throws IOException {
        Intrinsics.p(path, "<this>");
        return Files.isHidden(path);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path c0(String str, String... strArr) {
        Intrinsics.p(str, "base");
        Intrinsics.p(strArr, "subpaths");
        Path a2 = Paths.get(str, (String[]) Arrays.copyOf(strArr, strArr.length));
        Intrinsics.o(a2, "get(base, *subpaths)");
        return a2;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final boolean c1(Path path) {
        Intrinsics.p(path, "<this>");
        return Files.isReadable(path);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path d0(Path path) {
        Intrinsics.p(path, "<this>");
        Path a2 = path.toAbsolutePath();
        Intrinsics.o(a2, "toAbsolutePath()");
        return a2;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final boolean d1(Path path, LinkOption... linkOptionArr) {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(linkOptionArr, "options");
        return Files.isRegularFile(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final String e0(Path path) {
        Intrinsics.p(path, "<this>");
        return path.toAbsolutePath().toString();
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final boolean e1(Path path, Path path2) throws IOException {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(path2, "other");
        return Files.isSameFile(path, path2);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path f0(Path path, Path path2, boolean z) throws IOException {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(path2, TypedValues.AttributesType.M);
        CopyOption[] copyOptionArr = z ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        Path a2 = Files.copy(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        Intrinsics.o(a2, "copy(this, target, *options)");
        return a2;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final boolean f1(Path path) {
        Intrinsics.p(path, "<this>");
        return Files.isSymbolicLink(path);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path g0(Path path, Path path2, CopyOption... copyOptionArr) throws IOException {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(path2, TypedValues.AttributesType.M);
        Intrinsics.p(copyOptionArr, "options");
        Path a2 = Files.copy(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        Intrinsics.o(a2, "copy(this, target, *options)");
        return a2;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final boolean g1(Path path) {
        Intrinsics.p(path, "<this>");
        return Files.isWritable(path);
    }

    static /* synthetic */ Path h0(Path path, Path path2, boolean z, int i2, Object obj) throws IOException {
        if ((i2 & 2) != 0) {
            z = false;
        }
        Intrinsics.p(path, "<this>");
        Intrinsics.p(path2, TypedValues.AttributesType.M);
        CopyOption[] copyOptionArr = z ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        Path a2 = Files.copy(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        Intrinsics.o(a2, "copy(this, target, *options)");
        return a2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0022, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0023, code lost:
        kotlin.io.CloseableKt.a(r1, r2);
     */
    @kotlin.SinceKotlin(version = "1.5")
    @org.jetbrains.annotations.NotNull
    @kotlin.WasExperimental(markerClass = {kotlin.io.path.ExperimentalPathApi.class})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.List<java.nio.file.Path> h1(@org.jetbrains.annotations.NotNull java.nio.file.Path r1, @org.jetbrains.annotations.NotNull java.lang.String r2) throws java.io.IOException {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.p(r1, r0)
            java.lang.String r0 = "glob"
            kotlin.jvm.internal.Intrinsics.p(r2, r0)
            java.nio.file.DirectoryStream r1 = java.nio.file.Files.newDirectoryStream(r1, r2)
            java.nio.file.DirectoryStream r2 = kotlin.io.path.C0506d0.a(r1)     // Catch:{ all -> 0x0020 }
            java.lang.String r0 = "it"
            kotlin.jvm.internal.Intrinsics.o(r2, r0)     // Catch:{ all -> 0x0020 }
            java.util.List r2 = kotlin.collections.CollectionsKt.S5(r2)     // Catch:{ all -> 0x0020 }
            r0 = 0
            kotlin.io.CloseableKt.a(r1, r0)
            return r2
        L_0x0020:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0022 }
        L_0x0022:
            r0 = move-exception
            kotlin.io.CloseableKt.a(r1, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathsKt__PathUtilsKt.h1(java.nio.file.Path, java.lang.String):java.util.List");
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path i0(Path path, FileAttribute<?>... fileAttributeArr) throws IOException {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(fileAttributeArr, "attributes");
        Path a2 = Files.createDirectories(path, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.o(a2, "createDirectories(this, *attributes)");
        return a2;
    }

    public static /* synthetic */ List i1(Path path, String str, int i2, Object obj) throws IOException {
        if ((i2 & 1) != 0) {
            str = "*";
        }
        return h1(path, str);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path j0(Path path, FileAttribute<?>... fileAttributeArr) throws IOException {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(fileAttributeArr, "attributes");
        Path a2 = Files.createDirectory(path, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.o(a2, "createDirectory(this, *attributes)");
        return a2;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path j1(Path path, Path path2, boolean z) throws IOException {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(path2, TypedValues.AttributesType.M);
        CopyOption[] copyOptionArr = z ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        Path a2 = Files.move(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        Intrinsics.o(a2, "move(this, target, *options)");
        return a2;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path k0(Path path, FileAttribute<?>... fileAttributeArr) throws IOException {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(fileAttributeArr, "attributes");
        Path a2 = Files.createFile(path, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.o(a2, "createFile(this, *attributes)");
        return a2;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path k1(Path path, Path path2, CopyOption... copyOptionArr) throws IOException {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(path2, TypedValues.AttributesType.M);
        Intrinsics.p(copyOptionArr, "options");
        Path a2 = Files.move(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        Intrinsics.o(a2, "move(this, target, *options)");
        return a2;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path l0(Path path, Path path2) throws IOException {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(path2, TypedValues.AttributesType.M);
        Path a2 = Files.createLink(path, path2);
        Intrinsics.o(a2, "createLink(this, target)");
        return a2;
    }

    static /* synthetic */ Path l1(Path path, Path path2, boolean z, int i2, Object obj) throws IOException {
        if ((i2 & 2) != 0) {
            z = false;
        }
        Intrinsics.p(path, "<this>");
        Intrinsics.p(path2, TypedValues.AttributesType.M);
        CopyOption[] copyOptionArr = z ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        Path a2 = Files.move(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        Intrinsics.o(a2, "move(this, target, *options)");
        return a2;
    }

    @SinceKotlin(version = "1.9")
    @NotNull
    public static final Path m0(@NotNull Path path, @NotNull FileAttribute<?>... fileAttributeArr) throws IOException {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(fileAttributeArr, "attributes");
        Path a2 = path.getParent();
        if (a2 != null && !Files.isDirectory(a2, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0))) {
            try {
                FileAttribute[] fileAttributeArr2 = (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length);
                Intrinsics.o(Files.createDirectories(a2, (FileAttribute[]) Arrays.copyOf(fileAttributeArr2, fileAttributeArr2.length)), "createDirectories(this, *attributes)");
            } catch (FileAlreadyExistsException e2) {
                if (!Files.isDirectory(a2, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0))) {
                    throw e2;
                }
            }
        }
        return path;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final boolean m1(Path path, LinkOption... linkOptionArr) {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(linkOptionArr, "options");
        return Files.notExists(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path n0(Path path, Path path2, FileAttribute<?>... fileAttributeArr) throws IOException {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(path2, TypedValues.AttributesType.M);
        Intrinsics.p(fileAttributeArr, "attributes");
        Path a2 = Files.createSymbolicLink(path, path2, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.o(a2, "createSymbolicLink(this, target, *attributes)");
        return a2;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final /* synthetic */ <A extends BasicFileAttributes> A n1(Path path, LinkOption... linkOptionArr) throws IOException {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(linkOptionArr, "options");
        Intrinsics.y(4, ExifInterface.W4);
        BasicFileAttributes a2 = Files.readAttributes(path, A.a(), (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        Intrinsics.o(a2, "readAttributes(this, A::class.java, *options)");
        return C0524m0.a(a2);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path o0(String str, FileAttribute<?>... fileAttributeArr) throws IOException {
        Intrinsics.p(fileAttributeArr, "attributes");
        Path a2 = Files.createTempDirectory(str, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.o(a2, "createTempDirectory(prefix, *attributes)");
        return a2;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Map<String, Object> o1(Path path, String str, LinkOption... linkOptionArr) throws IOException {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(str, "attributes");
        Intrinsics.p(linkOptionArr, "options");
        Map<String, Object> a2 = Files.readAttributes(path, str, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        Intrinsics.o(a2, "readAttributes(this, attributes, *options)");
        return a2;
    }

    @SinceKotlin(version = "1.5")
    @NotNull
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static final Path p0(@Nullable Path path, @Nullable String str, @NotNull FileAttribute<?>... fileAttributeArr) throws IOException {
        Path a2;
        String str2;
        Intrinsics.p(fileAttributeArr, "attributes");
        if (path != null) {
            a2 = Files.createTempDirectory(path, str, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
            str2 = "createTempDirectory(dire…ory, prefix, *attributes)";
        } else {
            a2 = Files.createTempDirectory(str, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
            str2 = "createTempDirectory(prefix, *attributes)";
        }
        Intrinsics.o(a2, str2);
        return a2;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path p1(Path path) throws IOException {
        Intrinsics.p(path, "<this>");
        Path a2 = Files.readSymbolicLink(path);
        Intrinsics.o(a2, "readSymbolicLink(this)");
        return a2;
    }

    static /* synthetic */ Path q0(String str, FileAttribute[] fileAttributeArr, int i2, Object obj) throws IOException {
        if ((i2 & 1) != 0) {
            str = null;
        }
        Intrinsics.p(fileAttributeArr, "attributes");
        Path a2 = Files.createTempDirectory(str, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.o(a2, "createTempDirectory(prefix, *attributes)");
        return a2;
    }

    @NotNull
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static final Path q1(@NotNull Path path, @NotNull Path path2) {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(path2, "base");
        try {
            return PathRelativizer.f28897a.a(path, path2);
        } catch (IllegalArgumentException e2) {
            throw new IllegalArgumentException(e2.getMessage() + "\nthis path: " + path + "\nbase path: " + path2, e2);
        }
    }

    public static /* synthetic */ Path r0(Path path, String str, FileAttribute[] fileAttributeArr, int i2, Object obj) throws IOException {
        if ((i2 & 2) != 0) {
            str = null;
        }
        return p0(path, str, fileAttributeArr);
    }

    @SinceKotlin(version = "1.5")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static final Path r1(@NotNull Path path, @NotNull Path path2) {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(path2, "base");
        try {
            return PathRelativizer.f28897a.a(path, path2);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path s0(String str, String str2, FileAttribute<?>... fileAttributeArr) throws IOException {
        Intrinsics.p(fileAttributeArr, "attributes");
        Path a2 = Files.createTempFile(str, str2, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.o(a2, "createTempFile(prefix, suffix, *attributes)");
        return a2;
    }

    @NotNull
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static final Path s1(@NotNull Path path, @NotNull Path path2) {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(path2, "base");
        Path r1 = r1(path, path2);
        return r1 == null ? path : r1;
    }

    @SinceKotlin(version = "1.5")
    @NotNull
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static final Path t0(@Nullable Path path, @Nullable String str, @Nullable String str2, @NotNull FileAttribute<?>... fileAttributeArr) throws IOException {
        Path a2;
        String str3;
        Intrinsics.p(fileAttributeArr, "attributes");
        if (path != null) {
            a2 = Files.createTempFile(path, str, str2, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
            str3 = "createTempFile(directory…fix, suffix, *attributes)";
        } else {
            a2 = Files.createTempFile(str, str2, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
            str3 = "createTempFile(prefix, suffix, *attributes)";
        }
        Intrinsics.o(a2, str3);
        return a2;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path t1(Path path, String str, Object obj, LinkOption... linkOptionArr) throws IOException {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(str, "attribute");
        Intrinsics.p(linkOptionArr, "options");
        Path a2 = Files.setAttribute(path, str, obj, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        Intrinsics.o(a2, "setAttribute(this, attribute, value, *options)");
        return a2;
    }

    static /* synthetic */ Path u0(String str, String str2, FileAttribute[] fileAttributeArr, int i2, Object obj) throws IOException {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        Intrinsics.p(fileAttributeArr, "attributes");
        Path a2 = Files.createTempFile(str, str2, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.o(a2, "createTempFile(prefix, suffix, *attributes)");
        return a2;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path u1(Path path, FileTime fileTime) throws IOException {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(fileTime, "value");
        Path a2 = Files.setLastModifiedTime(path, fileTime);
        Intrinsics.o(a2, "setLastModifiedTime(this, value)");
        return a2;
    }

    public static /* synthetic */ Path v0(Path path, String str, String str2, FileAttribute[] fileAttributeArr, int i2, Object obj) throws IOException {
        if ((i2 & 2) != 0) {
            str = null;
        }
        if ((i2 & 4) != 0) {
            str2 = null;
        }
        return t0(path, str, str2, fileAttributeArr);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path v1(Path path, UserPrincipal userPrincipal) throws IOException {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(userPrincipal, "value");
        Path a2 = Files.setOwner(path, userPrincipal);
        Intrinsics.o(a2, "setOwner(this, value)");
        return a2;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final void w0(Path path) throws IOException {
        Intrinsics.p(path, "<this>");
        Files.delete(path);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path w1(Path path, Set<? extends PosixFilePermission> set) throws IOException {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(set, "value");
        Path a2 = Files.setPosixFilePermissions(path, set);
        Intrinsics.o(a2, "setPosixFilePermissions(this, value)");
        return a2;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final boolean x0(Path path) throws IOException {
        Intrinsics.p(path, "<this>");
        return Files.deleteIfExists(path);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path x1(URI uri) {
        Intrinsics.p(uri, "<this>");
        Path a2 = Paths.get(uri);
        Intrinsics.o(a2, "get(this)");
        return a2;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path y0(Path path, String str) {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(str, "other");
        Path a2 = path.resolve(str);
        Intrinsics.o(a2, "this.resolve(other)");
        return a2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003c, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0032, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0033, code lost:
        kotlin.jvm.internal.InlineMarker.d(1);
        kotlin.io.CloseableKt.a(r2, r4);
        kotlin.jvm.internal.InlineMarker.c(1);
     */
    @kotlin.SinceKotlin(version = "1.5")
    @kotlin.internal.InlineOnly
    @kotlin.WasExperimental(markerClass = {kotlin.io.path.ExperimentalPathApi.class})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final <T> T y1(java.nio.file.Path r2, java.lang.String r3, kotlin.jvm.functions.Function1<? super kotlin.sequences.Sequence<? extends java.nio.file.Path>, ? extends T> r4) throws java.io.IOException {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.p(r2, r0)
            java.lang.String r0 = "glob"
            kotlin.jvm.internal.Intrinsics.p(r3, r0)
            java.lang.String r0 = "block"
            kotlin.jvm.internal.Intrinsics.p(r4, r0)
            java.nio.file.DirectoryStream r2 = java.nio.file.Files.newDirectoryStream(r2, r3)
            r3 = 1
            java.nio.file.DirectoryStream r0 = kotlin.io.path.C0506d0.a(r2)     // Catch:{ all -> 0x0030 }
            java.lang.String r1 = "it"
            kotlin.jvm.internal.Intrinsics.o(r0, r1)     // Catch:{ all -> 0x0030 }
            kotlin.sequences.Sequence r0 = kotlin.collections.CollectionsKt.x1(r0)     // Catch:{ all -> 0x0030 }
            java.lang.Object r4 = r4.f(r0)     // Catch:{ all -> 0x0030 }
            kotlin.jvm.internal.InlineMarker.d(r3)
            r0 = 0
            kotlin.io.CloseableKt.a(r2, r0)
            kotlin.jvm.internal.InlineMarker.c(r3)
            return r4
        L_0x0030:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0032 }
        L_0x0032:
            r0 = move-exception
            kotlin.jvm.internal.InlineMarker.d(r3)
            kotlin.io.CloseableKt.a(r2, r4)
            kotlin.jvm.internal.InlineMarker.c(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathsKt__PathUtilsKt.y1(java.nio.file.Path, java.lang.String, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path z0(Path path, Path path2) {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(path2, "other");
        Path a2 = path.resolve(path2);
        Intrinsics.o(a2, "this.resolve(other)");
        return a2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0037, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
        kotlin.jvm.internal.InlineMarker.d(1);
        kotlin.io.CloseableKt.a(r0, r1);
        kotlin.jvm.internal.InlineMarker.c(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0041, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object z1(java.nio.file.Path r0, java.lang.String r1, kotlin.jvm.functions.Function1 r2, int r3, java.lang.Object r4) throws java.io.IOException {
        /*
            r4 = 1
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0006
            java.lang.String r1 = "*"
        L_0x0006:
            java.lang.String r3 = "<this>"
            kotlin.jvm.internal.Intrinsics.p(r0, r3)
            java.lang.String r3 = "glob"
            kotlin.jvm.internal.Intrinsics.p(r1, r3)
            java.lang.String r3 = "block"
            kotlin.jvm.internal.Intrinsics.p(r2, r3)
            java.nio.file.DirectoryStream r0 = java.nio.file.Files.newDirectoryStream(r0, r1)
            java.nio.file.DirectoryStream r1 = kotlin.io.path.C0506d0.a(r0)     // Catch:{ all -> 0x0035 }
            java.lang.String r3 = "it"
            kotlin.jvm.internal.Intrinsics.o(r1, r3)     // Catch:{ all -> 0x0035 }
            kotlin.sequences.Sequence r1 = kotlin.collections.CollectionsKt.x1(r1)     // Catch:{ all -> 0x0035 }
            java.lang.Object r1 = r2.f(r1)     // Catch:{ all -> 0x0035 }
            kotlin.jvm.internal.InlineMarker.d(r4)
            r2 = 0
            kotlin.io.CloseableKt.a(r0, r2)
            kotlin.jvm.internal.InlineMarker.c(r4)
            return r1
        L_0x0035:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0037 }
        L_0x0037:
            r2 = move-exception
            kotlin.jvm.internal.InlineMarker.d(r4)
            kotlin.io.CloseableKt.a(r0, r1)
            kotlin.jvm.internal.InlineMarker.c(r4)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathsKt__PathUtilsKt.z1(java.nio.file.Path, java.lang.String, kotlin.jvm.functions.Function1, int, java.lang.Object):java.lang.Object");
    }
}
