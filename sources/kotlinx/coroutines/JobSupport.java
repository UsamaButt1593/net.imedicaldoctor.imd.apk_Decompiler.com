package kotlinx.coroutines;

import androidx.concurrent.futures.a;
import androidx.exifinterface.media.ExifInterface;
import com.dd.plist.ASCIIPropertyListParser;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause0;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\r\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0006Ï\u0001Ð\u0001Ñ\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ&\u0010\u000e\u001a\u00020\r2\u0014\u0010\f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u000b0\tH\b¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0013\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0018\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ!\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u001f\u0010 J!\u0010!\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b!\u0010\"J\u001f\u0010&\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u0016H\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u0016H\u0002¢\u0006\u0004\b(\u0010)J\u001d\u0010*\u001a\u00020\u000b*\u00020#2\b\u0010%\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b*\u0010'J.\u0010-\u001a\u00020\u000b\"\n\b\u0000\u0010,\u0018\u0001*\u00020+2\u0006\u0010$\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010\u0016H\b¢\u0006\u0004\b-\u0010'J\u0019\u0010/\u001a\u00020.2\b\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b/\u00100J@\u00106\u001a\u00020+2'\u00104\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0016¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u000b0\tj\u0002`32\u0006\u00105\u001a\u00020\u0005H\u0002¢\u0006\u0004\b6\u00107J'\u0010:\u001a\u00020\u00052\u0006\u00108\u001a\u00020\n2\u0006\u0010$\u001a\u00020#2\u0006\u00109\u001a\u00020+H\u0002¢\u0006\u0004\b:\u0010;J\u0017\u0010=\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020<H\u0002¢\u0006\u0004\b=\u0010>J\u0017\u0010?\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020+H\u0002¢\u0006\u0004\b?\u0010@J\u000f\u0010A\u001a\u00020\u0005H\u0002¢\u0006\u0004\bA\u0010BJ\u0013\u0010C\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0004\bC\u0010DJ\u001b\u0010E\u001a\u0004\u0018\u00010\n2\b\u0010%\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\bE\u0010FJ\u0019\u0010G\u001a\u00020\u00162\b\u0010%\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\bG\u0010HJ\u001b\u0010I\u001a\u0004\u0018\u00010\n2\b\u0010%\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\bI\u0010FJ\u0019\u0010J\u001a\u0004\u0018\u00010#2\u0006\u0010\u0011\u001a\u00020\u001dH\u0002¢\u0006\u0004\bJ\u0010KJ\u001f\u0010L\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u0016H\u0002¢\u0006\u0004\bL\u0010MJ%\u0010N\u001a\u0004\u0018\u00010\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\bN\u0010OJ#\u0010P\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\u001d2\b\u0010\u0012\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\bP\u0010QJ\u0019\u0010S\u001a\u0004\u0018\u00010R2\u0006\u0010\u0011\u001a\u00020\u001dH\u0002¢\u0006\u0004\bS\u0010TJ*\u0010V\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010U\u001a\u00020R2\b\u0010\u0012\u001a\u0004\u0018\u00010\nH\u0010¢\u0006\u0004\bV\u0010WJ)\u0010Y\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010X\u001a\u00020R2\b\u0010\u0012\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\bY\u0010ZJ\u0015\u0010\\\u001a\u0004\u0018\u00010R*\u00020[H\u0002¢\u0006\u0004\b\\\u0010]J\u0019\u0010_\u001a\u00020^2\b\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b_\u0010`J\u0015\u0010a\u001a\u0004\u0018\u00010\nH@ø\u0001\u0000¢\u0006\u0004\ba\u0010DJ\u0019\u0010c\u001a\u00020\u000b2\b\u0010b\u001a\u0004\u0018\u00010\u0001H\u0004¢\u0006\u0004\bc\u0010dJ\r\u0010e\u001a\u00020\u0005¢\u0006\u0004\be\u0010BJ\u000f\u0010f\u001a\u00020\u000bH\u0014¢\u0006\u0004\bf\u0010gJ\u0011\u0010j\u001a\u00060hj\u0002`i¢\u0006\u0004\bj\u0010kJ#\u0010m\u001a\u00060hj\u0002`i*\u00020\u00162\n\b\u0002\u0010l\u001a\u0004\u0018\u00010^H\u0004¢\u0006\u0004\bm\u0010nJ6\u0010p\u001a\u00020o2'\u00104\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0016¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u000b0\tj\u0002`3¢\u0006\u0004\bp\u0010qJF\u0010s\u001a\u00020o2\u0006\u00105\u001a\u00020\u00052\u0006\u0010r\u001a\u00020\u00052'\u00104\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0016¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u000b0\tj\u0002`3¢\u0006\u0004\bs\u0010tJ\u0013\u0010u\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0004\bu\u0010DJB\u0010z\u001a\u00020\u000b\"\u0004\b\u0000\u0010v2\f\u0010x\u001a\b\u0012\u0004\u0012\u00028\u00000w2\u001c\u0010\f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000y\u0012\u0006\u0012\u0004\u0018\u00010\n0\tø\u0001\u0000¢\u0006\u0004\bz\u0010{J\u0017\u0010|\u001a\u00020\u000b2\u0006\u00109\u001a\u00020+H\u0000¢\u0006\u0004\b|\u0010@J\u001f\u0010}\u001a\u00020\u000b2\u000e\u0010%\u001a\n\u0018\u00010hj\u0004\u0018\u0001`iH\u0016¢\u0006\u0004\b}\u0010~J\u0010\u0010\u001a\u00020^H\u0014¢\u0006\u0005\b\u0010\u0001J\u001b\u0010\u0001\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010\u0016H\u0017¢\u0006\u0005\b\u0001\u0010)J\u001a\u0010\u0001\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u0016H\u0016¢\u0006\u0006\b\u0001\u0010\u0001J\u0019\u0010\u0001\u001a\u00020\u000b2\u0007\u0010\u0001\u001a\u00020\u0003¢\u0006\u0006\b\u0001\u0010\u0001J\u0019\u0010\u0001\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u0016H\u0016¢\u0006\u0005\b\u0001\u0010)J\u0019\u0010\u0001\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010\u0016¢\u0006\u0005\b\u0001\u0010)J\u001c\u0010\u0001\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0006\b\u0001\u0010\u0001J,\u0010\u0001\u001a\u00030\u00012\n\b\u0002\u0010l\u001a\u0004\u0018\u00010^2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0016H\b¢\u0006\u0006\b\u0001\u0010\u0001J\u0015\u0010\u0001\u001a\u00060hj\u0002`iH\u0016¢\u0006\u0005\b\u0001\u0010kJ\u001c\u0010\u0001\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001d\u0010\u0001\u001a\u0004\u0018\u00010\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0005\b\u0001\u0010FJ\u0019\u0010\u0001\u001a\u00030\u00012\u0006\u0010U\u001a\u00020\u0002¢\u0006\u0006\b\u0001\u0010\u0001J\u001b\u0010\u0001\u001a\u00020\u000b2\u0007\u0010\u0001\u001a\u00020\u0016H\u0010¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u00010\u0016H\u0014¢\u0006\u0006\b\u0001\u0010\u0001J\u001a\u0010\u0001\u001a\u00020\u00052\u0007\u0010\u0001\u001a\u00020\u0016H\u0014¢\u0006\u0005\b\u0001\u0010)J\u001c\u0010\u0001\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0006\b\u0001\u0010\u0001J\u0012\u0010\u0001\u001a\u00020^H\u0016¢\u0006\u0006\b\u0001\u0010\u0001J\u0012\u0010\u0001\u001a\u00020^H\u0007¢\u0006\u0006\b\u0001\u0010\u0001J\u0012\u0010\u0001\u001a\u00020^H\u0010¢\u0006\u0006\b\u0001\u0010\u0001J\u0012\u0010\u0001\u001a\u0004\u0018\u00010\u0016¢\u0006\u0006\b\u0001\u0010\u0001J\u0014\u0010 \u0001\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0006\b \u0001\u0010¡\u0001J\u0017\u0010¢\u0001\u001a\u0004\u0018\u00010\nH@ø\u0001\u0000¢\u0006\u0005\b¢\u0001\u0010DJT\u0010¤\u0001\u001a\u00020\u000b\"\u0004\b\u0000\u0010,\"\u0004\b\u0001\u0010v2\f\u0010x\u001a\b\u0012\u0004\u0012\u00028\u00010w2#\u0010\f\u001a\u001f\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010y\u0012\u0006\u0012\u0004\u0018\u00010\n0£\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\b¤\u0001\u0010¥\u0001JT\u0010¦\u0001\u001a\u00020\u000b\"\u0004\b\u0000\u0010,\"\u0004\b\u0001\u0010v2\f\u0010x\u001a\b\u0012\u0004\u0012\u00028\u00010w2#\u0010\f\u001a\u001f\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010y\u0012\u0006\u0012\u0004\u0018\u00010\n0£\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\b¦\u0001\u0010¥\u0001R\u001e\u0010¨\u0001\u001a\u0004\u0018\u00010\u0016*\u0004\u0018\u00010\n8BX\u0004¢\u0006\u0007\u001a\u0005\b§\u0001\u0010HR\u001b\u0010«\u0001\u001a\u00020\u0005*\u00020\u001d8BX\u0004¢\u0006\b\u001a\u0006\b©\u0001\u0010ª\u0001R\u0019\u0010¯\u0001\u001a\u0007\u0012\u0002\b\u00030¬\u00018F¢\u0006\b\u001a\u0006\b­\u0001\u0010®\u0001R0\u0010µ\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010°\u0001\u001a\u0005\u0018\u00010\u00018@@@X\u000e¢\u0006\u0010\u001a\u0006\b±\u0001\u0010²\u0001\"\u0006\b³\u0001\u0010´\u0001R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\n8@X\u0004¢\u0006\b\u001a\u0006\b¶\u0001\u0010¡\u0001R\u0016\u0010¸\u0001\u001a\u00020\u00058VX\u0004¢\u0006\u0007\u001a\u0005\b·\u0001\u0010BR\u0013\u0010º\u0001\u001a\u00020\u00058F¢\u0006\u0007\u001a\u0005\b¹\u0001\u0010BR\u0013\u0010»\u0001\u001a\u00020\u00058F¢\u0006\u0007\u001a\u0005\b»\u0001\u0010BR\u0019\u0010½\u0001\u001a\u0004\u0018\u00010\u00168DX\u0004¢\u0006\b\u001a\u0006\b¼\u0001\u0010\u0001R\u0016\u0010¿\u0001\u001a\u00020\u00058DX\u0004¢\u0006\u0007\u001a\u0005\b¾\u0001\u0010BR\u0014\u0010Â\u0001\u001a\u00020\u00048F¢\u0006\b\u001a\u0006\bÀ\u0001\u0010Á\u0001R\u0016\u0010Ä\u0001\u001a\u00020\u00058PX\u0004¢\u0006\u0007\u001a\u0005\bÃ\u0001\u0010BR\u001b\u0010È\u0001\u001a\t\u0012\u0004\u0012\u00020\u00010Å\u00018F¢\u0006\b\u001a\u0006\bÆ\u0001\u0010Ç\u0001R\u0016\u0010Ê\u0001\u001a\u00020\u00058TX\u0004¢\u0006\u0007\u001a\u0005\bÉ\u0001\u0010BR\u0016\u0010Ì\u0001\u001a\u00020\u00058PX\u0004¢\u0006\u0007\u001a\u0005\bË\u0001\u0010BR\u0013\u0010Î\u0001\u001a\u00020\u00058F¢\u0006\u0007\u001a\u0005\bÍ\u0001\u0010B\u0002\u0004\n\u0002\b\u0019¨\u0006Ò\u0001"}, d2 = {"Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/ChildJob;", "Lkotlinx/coroutines/ParentJob;", "Lkotlinx/coroutines/selects/SelectClause0;", "", "active", "<init>", "(Z)V", "Lkotlin/Function1;", "", "", "block", "", "c1", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Void;", "Lkotlinx/coroutines/JobSupport$Finishing;", "state", "proposedUpdate", "I0", "(Lkotlinx/coroutines/JobSupport$Finishing;Ljava/lang/Object;)Ljava/lang/Object;", "", "", "exceptions", "O0", "(Lkotlinx/coroutines/JobSupport$Finishing;Ljava/util/List;)Ljava/lang/Throwable;", "rootCause", "r0", "(Ljava/lang/Throwable;Ljava/util/List;)V", "Lkotlinx/coroutines/Incomplete;", "update", "A1", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)Z", "D0", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)V", "Lkotlinx/coroutines/NodeList;", "list", "cause", "j1", "(Lkotlinx/coroutines/NodeList;Ljava/lang/Throwable;)V", "A0", "(Ljava/lang/Throwable;)Z", "k1", "Lkotlinx/coroutines/JobNode;", "T", "l1", "", "v1", "(Ljava/lang/Object;)I", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "onCancelling", "g1", "(Lkotlin/jvm/functions/Function1;Z)Lkotlinx/coroutines/JobNode;", "expect", "node", "q0", "(Ljava/lang/Object;Lkotlinx/coroutines/NodeList;Lkotlinx/coroutines/JobNode;)Z", "Lkotlinx/coroutines/Empty;", "p1", "(Lkotlinx/coroutines/Empty;)V", "q1", "(Lkotlinx/coroutines/JobNode;)V", "a1", "()Z", "b1", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "z0", "(Ljava/lang/Object;)Ljava/lang/Object;", "F0", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "d1", "R0", "(Lkotlinx/coroutines/Incomplete;)Lkotlinx/coroutines/NodeList;", "B1", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Throwable;)Z", "C1", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "D1", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/ChildHandleNode;", "J0", "(Lkotlinx/coroutines/Incomplete;)Lkotlinx/coroutines/ChildHandleNode;", "child", "E1", "(Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)Z", "lastChild", "E0", "(Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "i1", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/ChildHandleNode;", "", "w1", "(Ljava/lang/Object;)Ljava/lang/String;", "v0", "parent", "W0", "(Lkotlinx/coroutines/Job;)V", "start", "o1", "()V", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "I", "()Ljava/util/concurrent/CancellationException;", "message", "x1", "(Ljava/lang/Throwable;Ljava/lang/String;)Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/DisposableHandle;", "Z", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "invokeImmediately", "H", "(ZZLkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "F", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/coroutines/Continuation;", "C", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function1;)V", "s1", "i", "(Ljava/util/concurrent/CancellationException;)V", "B0", "()Ljava/lang/String;", "d", "y0", "(Ljava/lang/Throwable;)V", "parentJob", "L", "(Lkotlinx/coroutines/ParentJob;)V", "C0", "w0", "x0", "(Ljava/lang/Object;)Z", "Lkotlinx/coroutines/JobCancellationException;", "G0", "(Ljava/lang/String;Ljava/lang/Throwable;)Lkotlinx/coroutines/JobCancellationException;", "h0", "e1", "f1", "Lkotlinx/coroutines/ChildHandle;", "m0", "(Lkotlinx/coroutines/ChildJob;)Lkotlinx/coroutines/ChildHandle;", "exception", "V0", "m1", "U0", "n1", "(Ljava/lang/Object;)V", "s0", "toString", "z1", "h1", "A", "()Ljava/lang/Throwable;", "K0", "()Ljava/lang/Object;", "t0", "Lkotlin/Function2;", "r1", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "t1", "N0", "exceptionOrNull", "X0", "(Lkotlinx/coroutines/Incomplete;)Z", "isCancelling", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "key", "value", "S0", "()Lkotlinx/coroutines/ChildHandle;", "u1", "(Lkotlinx/coroutines/ChildHandle;)V", "parentHandle", "T0", "b", "isActive", "p", "isCompleted", "isCancelled", "L0", "completionCause", "M0", "completionCauseHandled", "d0", "()Lkotlinx/coroutines/selects/SelectClause0;", "onJoin", "Q0", "onCancelComplete", "Lkotlin/sequences/Sequence;", "y", "()Lkotlin/sequences/Sequence;", "children", "Z0", "isScopedCoroutine", "P0", "handlesException", "Y0", "isCompletedExceptionally", "AwaitContinuation", "ChildCompletion", "Finishing", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
@Deprecated(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
public class JobSupport implements Job, ChildJob, ParentJob, SelectClause0 {
    private static final /* synthetic */ AtomicReferenceFieldUpdater s = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_state");
    @NotNull
    private volatile /* synthetic */ Object _parentHandle;
    @NotNull
    private volatile /* synthetic */ Object _state;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/JobSupport$AwaitContinuation;", "T", "Lkotlinx/coroutines/CancellableContinuationImpl;", "Lkotlin/coroutines/Continuation;", "delegate", "Lkotlinx/coroutines/JobSupport;", "job", "<init>", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/JobSupport;)V", "Lkotlinx/coroutines/Job;", "parent", "", "x", "(Lkotlinx/coroutines/Job;)Ljava/lang/Throwable;", "", "F", "()Ljava/lang/String;", "b3", "Lkotlinx/coroutines/JobSupport;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private static final class AwaitContinuation<T> extends CancellableContinuationImpl<T> {
        @NotNull
        private final JobSupport b3;

        public AwaitContinuation(@NotNull Continuation<? super T> continuation, @NotNull JobSupport jobSupport) {
            super(continuation, 1);
            this.b3 = jobSupport;
        }

        /* access modifiers changed from: protected */
        @NotNull
        public String F() {
            return "AwaitContinuation";
        }

        @NotNull
        public Throwable x(@NotNull Job job) {
            Throwable e2;
            Object T0 = this.b3.T0();
            if (!(T0 instanceof Finishing) || (e2 = ((Finishing) T0).e()) == null) {
                return T0 instanceof CompletedExceptionally ? ((CompletedExceptionally) T0).f29164a : job.I();
            }
            return e2;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\t\u001a\u0004\u0018\u00010\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/JobSupport$ChildCompletion;", "Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/JobSupport;", "parent", "Lkotlinx/coroutines/JobSupport$Finishing;", "state", "Lkotlinx/coroutines/ChildHandleNode;", "child", "", "proposedUpdate", "<init>", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "", "cause", "", "X0", "(Ljava/lang/Throwable;)V", "X2", "Lkotlinx/coroutines/JobSupport;", "Y2", "Lkotlinx/coroutines/JobSupport$Finishing;", "Z2", "Lkotlinx/coroutines/ChildHandleNode;", "a3", "Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private static final class ChildCompletion extends JobNode {
        @NotNull
        private final JobSupport X2;
        @NotNull
        private final Finishing Y2;
        @NotNull
        private final ChildHandleNode Z2;
        @Nullable
        private final Object a3;

        public ChildCompletion(@NotNull JobSupport jobSupport, @NotNull Finishing finishing, @NotNull ChildHandleNode childHandleNode, @Nullable Object obj) {
            this.X2 = jobSupport;
            this.Y2 = finishing;
            this.Z2 = childHandleNode;
            this.a3 = obj;
        }

        public void X0(@Nullable Throwable th) {
            this.X2.E0(this.Y2, this.Z2, this.a3);
        }

        public /* bridge */ /* synthetic */ Object f(Object obj) {
            X0((Throwable) obj);
            return Unit.f28779a;
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001a\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B!\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\b0\fj\b\u0012\u0004\u0012\u00020\b`\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\b¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR(\u0010$\u001a\u0004\u0018\u00010\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010\u00018B@BX\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00068F@FX\u000e¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\b8F@FX\u000e¢\u0006\f\u001a\u0004\b)\u0010*\"\u0004\b+\u0010\u0017R\u0011\u0010-\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b,\u0010&R\u0011\u0010/\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b.\u0010&R\u0014\u00101\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b0\u0010&¨\u00062"}, d2 = {"Lkotlinx/coroutines/JobSupport$Finishing;", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "Lkotlinx/coroutines/Incomplete;", "Lkotlinx/coroutines/NodeList;", "list", "", "isCompleting", "", "rootCause", "<init>", "(Lkotlinx/coroutines/NodeList;ZLjava/lang/Throwable;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "c", "()Ljava/util/ArrayList;", "proposedException", "", "i", "(Ljava/lang/Throwable;)Ljava/util/List;", "exception", "", "a", "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "s", "Lkotlinx/coroutines/NodeList;", "B", "()Lkotlinx/coroutines/NodeList;", "value", "d", "()Ljava/lang/Object;", "k", "(Ljava/lang/Object;)V", "exceptionsHolder", "g", "()Z", "j", "(Z)V", "e", "()Ljava/lang/Throwable;", "l", "h", "isSealed", "f", "isCancelling", "b", "isActive", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private static final class Finishing implements Incomplete {
        @NotNull
        private volatile /* synthetic */ Object _exceptionsHolder = null;
        @NotNull
        private volatile /* synthetic */ int _isCompleting;
        @NotNull
        private volatile /* synthetic */ Object _rootCause;
        @NotNull
        private final NodeList s;

        public Finishing(@NotNull NodeList nodeList, boolean z, @Nullable Throwable th) {
            this.s = nodeList;
            this._isCompleting = z ? 1 : 0;
            this._rootCause = th;
        }

        private final ArrayList<Throwable> c() {
            return new ArrayList<>(4);
        }

        private final Object d() {
            return this._exceptionsHolder;
        }

        private final void k(Object obj) {
            this._exceptionsHolder = obj;
        }

        @NotNull
        public NodeList B() {
            return this.s;
        }

        public final void a(@NotNull Throwable th) {
            Throwable e2 = e();
            if (e2 == null) {
                l(th);
            } else if (th != e2) {
                Object d2 = d();
                if (d2 == null) {
                    k(th);
                } else if (d2 instanceof Throwable) {
                    if (th != d2) {
                        ArrayList<Throwable> c2 = c();
                        c2.add(d2);
                        c2.add(th);
                        k(c2);
                    }
                } else if (d2 instanceof ArrayList) {
                    ((ArrayList) d2).add(th);
                } else {
                    throw new IllegalStateException(("State is " + d2).toString());
                }
            }
        }

        public boolean b() {
            return e() == null;
        }

        @Nullable
        public final Throwable e() {
            return (Throwable) this._rootCause;
        }

        public final boolean f() {
            return e() != null;
        }

        /* JADX WARNING: type inference failed for: r0v0, types: [int, boolean] */
        public final boolean g() {
            return this._isCompleting;
        }

        public final boolean h() {
            return d() == JobSupportKt.f29214h;
        }

        @NotNull
        public final List<Throwable> i(@Nullable Throwable th) {
            ArrayList<Throwable> arrayList;
            Object d2 = d();
            if (d2 == null) {
                arrayList = c();
            } else if (d2 instanceof Throwable) {
                ArrayList<Throwable> c2 = c();
                c2.add(d2);
                arrayList = c2;
            } else if (d2 instanceof ArrayList) {
                arrayList = (ArrayList) d2;
            } else {
                throw new IllegalStateException(("State is " + d2).toString());
            }
            Throwable e2 = e();
            if (e2 != null) {
                arrayList.add(0, e2);
            }
            if (th != null && !Intrinsics.g(th, e2)) {
                arrayList.add(th);
            }
            k(JobSupportKt.f29214h);
            return arrayList;
        }

        public final void j(boolean z) {
            this._isCompleting = z ? 1 : 0;
        }

        public final void l(@Nullable Throwable th) {
            this._rootCause = th;
        }

        @NotNull
        public String toString() {
            return "Finishing[cancelling=" + f() + ", completing=" + g() + ", rootCause=" + e() + ", exceptions=" + d() + ", list=" + B() + ']';
        }
    }

    public JobSupport(boolean z) {
        this._state = z ? JobSupportKt.f29216j : JobSupportKt.f29215i;
        this._parentHandle = null;
    }

    private final boolean A0(Throwable th) {
        if (Z0()) {
            return true;
        }
        boolean z = th instanceof CancellationException;
        ChildHandle S0 = S0();
        if (S0 == null || S0 == NonDisposableHandle.s) {
            return z;
        }
        return S0.D(th) || z;
    }

    private final boolean A1(Incomplete incomplete, Object obj) {
        if (!a.a(s, this, incomplete, JobSupportKt.g(obj))) {
            return false;
        }
        m1((Throwable) null);
        n1(obj);
        D0(incomplete, obj);
        return true;
    }

    private final boolean B1(Incomplete incomplete, Throwable th) {
        NodeList R0 = R0(incomplete);
        if (R0 == null) {
            return false;
        }
        if (!a.a(s, this, incomplete, new Finishing(R0, false, th))) {
            return false;
        }
        j1(R0, th);
        return true;
    }

    private final Object C1(Object obj, Object obj2) {
        if (!(obj instanceof Incomplete)) {
            return JobSupportKt.f29207a;
        }
        if (((obj instanceof Empty) || (obj instanceof JobNode)) && !(obj instanceof ChildHandleNode) && !(obj2 instanceof CompletedExceptionally)) {
            return A1((Incomplete) obj, obj2) ? obj2 : JobSupportKt.f29209c;
        }
        return D1((Incomplete) obj, obj2);
    }

    private final void D0(Incomplete incomplete, Object obj) {
        ChildHandle S0 = S0();
        if (S0 != null) {
            S0.m();
            u1(NonDisposableHandle.s);
        }
        Throwable th = null;
        CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
        if (completedExceptionally != null) {
            th = completedExceptionally.f29164a;
        }
        if (incomplete instanceof JobNode) {
            try {
                ((JobNode) incomplete).X0(th);
            } catch (Throwable th2) {
                V0(new CompletionHandlerException("Exception in completion handler " + incomplete + " for " + this, th2));
            }
        } else {
            NodeList B = incomplete.B();
            if (B != null) {
                k1(B, th);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0066, code lost:
        if (r2 == null) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0068, code lost:
        j1(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x006b, code lost:
        r8 = J0(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x006f, code lost:
        if (r8 == null) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0075, code lost:
        if (E1(r1, r8, r9) == false) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0079, code lost:
        return kotlinx.coroutines.JobSupportKt.f29208b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x007e, code lost:
        return I0(r1, r9);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object D1(kotlinx.coroutines.Incomplete r8, java.lang.Object r9) {
        /*
            r7 = this;
            kotlinx.coroutines.NodeList r0 = r7.R0(r8)
            if (r0 != 0) goto L_0x000b
            kotlinx.coroutines.internal.Symbol r8 = kotlinx.coroutines.JobSupportKt.f29209c
            return r8
        L_0x000b:
            boolean r1 = r8 instanceof kotlinx.coroutines.JobSupport.Finishing
            r2 = 0
            if (r1 == 0) goto L_0x0014
            r1 = r8
            kotlinx.coroutines.JobSupport$Finishing r1 = (kotlinx.coroutines.JobSupport.Finishing) r1
            goto L_0x0015
        L_0x0014:
            r1 = r2
        L_0x0015:
            r3 = 0
            if (r1 != 0) goto L_0x001d
            kotlinx.coroutines.JobSupport$Finishing r1 = new kotlinx.coroutines.JobSupport$Finishing
            r1.<init>(r0, r3, r2)
        L_0x001d:
            kotlin.jvm.internal.Ref$ObjectRef r3 = new kotlin.jvm.internal.Ref$ObjectRef
            r3.<init>()
            monitor-enter(r1)
            boolean r4 = r1.g()     // Catch:{ all -> 0x002f }
            if (r4 == 0) goto L_0x0031
            kotlinx.coroutines.internal.Symbol r8 = kotlinx.coroutines.JobSupportKt.f29207a     // Catch:{ all -> 0x002f }
            monitor-exit(r1)
            return r8
        L_0x002f:
            r8 = move-exception
            goto L_0x007f
        L_0x0031:
            r4 = 1
            r1.j(r4)     // Catch:{ all -> 0x002f }
            if (r1 == r8) goto L_0x0045
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = s     // Catch:{ all -> 0x002f }
            boolean r5 = androidx.concurrent.futures.a.a(r5, r7, r8, r1)     // Catch:{ all -> 0x002f }
            if (r5 != 0) goto L_0x0045
            kotlinx.coroutines.internal.Symbol r8 = kotlinx.coroutines.JobSupportKt.f29209c     // Catch:{ all -> 0x002f }
            monitor-exit(r1)
            return r8
        L_0x0045:
            boolean r5 = r1.f()     // Catch:{ all -> 0x002f }
            boolean r6 = r9 instanceof kotlinx.coroutines.CompletedExceptionally     // Catch:{ all -> 0x002f }
            if (r6 == 0) goto L_0x0051
            r6 = r9
            kotlinx.coroutines.CompletedExceptionally r6 = (kotlinx.coroutines.CompletedExceptionally) r6     // Catch:{ all -> 0x002f }
            goto L_0x0052
        L_0x0051:
            r6 = r2
        L_0x0052:
            if (r6 == 0) goto L_0x0059
            java.lang.Throwable r6 = r6.f29164a     // Catch:{ all -> 0x002f }
            r1.a(r6)     // Catch:{ all -> 0x002f }
        L_0x0059:
            java.lang.Throwable r6 = r1.e()     // Catch:{ all -> 0x002f }
            r4 = r4 ^ r5
            if (r4 == 0) goto L_0x0061
            r2 = r6
        L_0x0061:
            r3.s = r2     // Catch:{ all -> 0x002f }
            kotlin.Unit r3 = kotlin.Unit.f28779a     // Catch:{ all -> 0x002f }
            monitor-exit(r1)
            if (r2 == 0) goto L_0x006b
            r7.j1(r0, r2)
        L_0x006b:
            kotlinx.coroutines.ChildHandleNode r8 = r7.J0(r8)
            if (r8 == 0) goto L_0x007a
            boolean r8 = r7.E1(r1, r8, r9)
            if (r8 == 0) goto L_0x007a
            kotlinx.coroutines.internal.Symbol r8 = kotlinx.coroutines.JobSupportKt.f29208b
            return r8
        L_0x007a:
            java.lang.Object r8 = r7.I0(r1, r9)
            return r8
        L_0x007f:
            monitor-exit(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.D1(kotlinx.coroutines.Incomplete, java.lang.Object):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void E0(Finishing finishing, ChildHandleNode childHandleNode, Object obj) {
        ChildHandleNode i1 = i1(childHandleNode);
        if (i1 == null || !E1(finishing, i1, obj)) {
            s0(I0(finishing, obj));
        }
    }

    private final boolean E1(Finishing finishing, ChildHandleNode childHandleNode, Object obj) {
        while (Job.DefaultImpls.f(childHandleNode.X2, false, false, new ChildCompletion(this, finishing, childHandleNode, obj), 1, (Object) null) == NonDisposableHandle.s) {
            childHandleNode = i1(childHandleNode);
            if (childHandleNode == null) {
                return false;
            }
        }
        return true;
    }

    private final Throwable F0(Object obj) {
        if (obj == null ? true : obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            return th == null ? new JobCancellationException(B0(), (Throwable) null, this) : th;
        } else if (obj != null) {
            return ((ParentJob) obj).h0();
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        }
    }

    public static /* synthetic */ JobCancellationException H0(JobSupport jobSupport, String str, Throwable th, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                str = null;
            }
            if ((i2 & 2) != 0) {
                th = null;
            }
            if (str == null) {
                str = jobSupport.B0();
            }
            return new JobCancellationException(str, th, jobSupport);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: defaultCancellationException");
    }

    private final Object I0(Finishing finishing, Object obj) {
        boolean f2;
        Throwable O0;
        CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
        Throwable th = completedExceptionally != null ? completedExceptionally.f29164a : null;
        synchronized (finishing) {
            f2 = finishing.f();
            List<Throwable> i2 = finishing.i(th);
            O0 = O0(finishing, i2);
            if (O0 != null) {
                r0(O0, i2);
            }
        }
        if (!(O0 == null || O0 == th)) {
            obj = new CompletedExceptionally(O0, false, 2, (DefaultConstructorMarker) null);
        }
        if (O0 != null && (A0(O0) || U0(O0))) {
            if (obj != null) {
                ((CompletedExceptionally) obj).b();
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            }
        }
        if (!f2) {
            m1(O0);
        }
        n1(obj);
        a.a(s, this, finishing, JobSupportKt.g(obj));
        D0(finishing, obj);
        return obj;
    }

    private final ChildHandleNode J0(Incomplete incomplete) {
        ChildHandleNode childHandleNode = incomplete instanceof ChildHandleNode ? (ChildHandleNode) incomplete : null;
        if (childHandleNode != null) {
            return childHandleNode;
        }
        NodeList B = incomplete.B();
        if (B != null) {
            return i1(B);
        }
        return null;
    }

    private final Throwable N0(Object obj) {
        CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
        if (completedExceptionally != null) {
            return completedExceptionally.f29164a;
        }
        return null;
    }

    private final Throwable O0(Finishing finishing, List<? extends Throwable> list) {
        T t;
        T t2 = null;
        if (!list.isEmpty()) {
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    t = null;
                    break;
                }
                t = it2.next();
                if (!(((Throwable) t) instanceof CancellationException)) {
                    break;
                }
            }
            Throwable th = (Throwable) t;
            if (th != null) {
                return th;
            }
            Throwable th2 = (Throwable) list.get(0);
            if (th2 instanceof TimeoutCancellationException) {
                Iterator<T> it3 = list.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    T next = it3.next();
                    Throwable th3 = (Throwable) next;
                    if (th3 != th2 && (th3 instanceof TimeoutCancellationException)) {
                        t2 = next;
                        break;
                    }
                }
                Throwable th4 = (Throwable) t2;
                if (th4 != null) {
                    return th4;
                }
            }
            return th2;
        } else if (finishing.f()) {
            return new JobCancellationException(B0(), (Throwable) null, this);
        } else {
            return null;
        }
    }

    private final NodeList R0(Incomplete incomplete) {
        NodeList B = incomplete.B();
        if (B != null) {
            return B;
        }
        if (incomplete instanceof Empty) {
            return new NodeList();
        }
        if (incomplete instanceof JobNode) {
            q1((JobNode) incomplete);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + incomplete).toString());
    }

    private final boolean X0(Incomplete incomplete) {
        return (incomplete instanceof Finishing) && ((Finishing) incomplete).f();
    }

    private final boolean a1() {
        Object T0;
        do {
            T0 = T0();
            if (!(T0 instanceof Incomplete)) {
                return false;
            }
        } while (v1(T0) < 0);
        return true;
    }

    /* access modifiers changed from: private */
    public final Object b1(Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.e(continuation), 1);
        cancellableContinuationImpl.W();
        CancellableContinuationKt.a(cancellableContinuationImpl, Z(new ResumeOnCompletion(cancellableContinuationImpl)));
        Object y = cancellableContinuationImpl.y();
        if (y == IntrinsicsKt.l()) {
            DebugProbesKt.c(continuation);
        }
        return y == IntrinsicsKt.l() ? y : Unit.f28779a;
    }

    private final Void c1(Function1<Object, Unit> function1) {
        while (true) {
            function1.f(T0());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0040, code lost:
        if (r0 == null) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0042, code lost:
        j1(((kotlinx.coroutines.JobSupport.Finishing) r2).B(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004f, code lost:
        return kotlinx.coroutines.JobSupportKt.a();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object d1(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 0
            r1 = r0
        L_0x0002:
            java.lang.Object r2 = r6.T0()
            boolean r3 = r2 instanceof kotlinx.coroutines.JobSupport.Finishing
            if (r3 == 0) goto L_0x0052
            monitor-enter(r2)
            r3 = r2
            kotlinx.coroutines.JobSupport$Finishing r3 = (kotlinx.coroutines.JobSupport.Finishing) r3     // Catch:{ all -> 0x001a }
            boolean r3 = r3.h()     // Catch:{ all -> 0x001a }
            if (r3 == 0) goto L_0x001c
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.JobSupportKt.f29210d     // Catch:{ all -> 0x001a }
            monitor-exit(r2)
            return r7
        L_0x001a:
            r7 = move-exception
            goto L_0x0050
        L_0x001c:
            r3 = r2
            kotlinx.coroutines.JobSupport$Finishing r3 = (kotlinx.coroutines.JobSupport.Finishing) r3     // Catch:{ all -> 0x001a }
            boolean r3 = r3.f()     // Catch:{ all -> 0x001a }
            if (r7 != 0) goto L_0x0027
            if (r3 != 0) goto L_0x0033
        L_0x0027:
            if (r1 != 0) goto L_0x002d
            java.lang.Throwable r1 = r6.F0(r7)     // Catch:{ all -> 0x001a }
        L_0x002d:
            r7 = r2
            kotlinx.coroutines.JobSupport$Finishing r7 = (kotlinx.coroutines.JobSupport.Finishing) r7     // Catch:{ all -> 0x001a }
            r7.a(r1)     // Catch:{ all -> 0x001a }
        L_0x0033:
            r7 = r2
            kotlinx.coroutines.JobSupport$Finishing r7 = (kotlinx.coroutines.JobSupport.Finishing) r7     // Catch:{ all -> 0x001a }
            java.lang.Throwable r7 = r7.e()     // Catch:{ all -> 0x001a }
            r1 = r3 ^ 1
            if (r1 == 0) goto L_0x003f
            r0 = r7
        L_0x003f:
            monitor-exit(r2)
            if (r0 == 0) goto L_0x004b
            kotlinx.coroutines.JobSupport$Finishing r2 = (kotlinx.coroutines.JobSupport.Finishing) r2
            kotlinx.coroutines.NodeList r7 = r2.B()
            r6.j1(r7, r0)
        L_0x004b:
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.JobSupportKt.f29207a
            return r7
        L_0x0050:
            monitor-exit(r2)
            throw r7
        L_0x0052:
            boolean r3 = r2 instanceof kotlinx.coroutines.Incomplete
            if (r3 == 0) goto L_0x00a3
            if (r1 != 0) goto L_0x005c
            java.lang.Throwable r1 = r6.F0(r7)
        L_0x005c:
            r3 = r2
            kotlinx.coroutines.Incomplete r3 = (kotlinx.coroutines.Incomplete) r3
            boolean r4 = r3.b()
            if (r4 == 0) goto L_0x0070
            boolean r2 = r6.B1(r3, r1)
            if (r2 == 0) goto L_0x0002
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.JobSupportKt.f29207a
            return r7
        L_0x0070:
            kotlinx.coroutines.CompletedExceptionally r3 = new kotlinx.coroutines.CompletedExceptionally
            r4 = 0
            r5 = 2
            r3.<init>(r1, r4, r5, r0)
            java.lang.Object r3 = r6.C1(r2, r3)
            kotlinx.coroutines.internal.Symbol r4 = kotlinx.coroutines.JobSupportKt.f29207a
            if (r3 == r4) goto L_0x0088
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.JobSupportKt.f29209c
            if (r3 == r2) goto L_0x0002
            return r3
        L_0x0088:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Cannot happen in "
            r0.append(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = r0.toString()
            r7.<init>(r0)
            throw r7
        L_0x00a3:
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.JobSupportKt.f29210d
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.d1(java.lang.Object):java.lang.Object");
    }

    private final JobNode g1(Function1<? super Throwable, Unit> function1, boolean z) {
        JobNode jobNode = null;
        if (z) {
            if (function1 instanceof JobCancellingNode) {
                jobNode = (JobCancellingNode) function1;
            }
            if (jobNode == null) {
                jobNode = new InvokeOnCancelling(function1);
            }
        } else {
            if (function1 instanceof JobNode) {
                jobNode = (JobNode) function1;
            }
            if (jobNode == null) {
                jobNode = new InvokeOnCompletion(function1);
            }
        }
        jobNode.Z0(this);
        return jobNode;
    }

    private final ChildHandleNode i1(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.N0()) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.K0();
        }
        while (true) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.J0();
            if (!lockFreeLinkedListNode.N0()) {
                if (lockFreeLinkedListNode instanceof ChildHandleNode) {
                    return (ChildHandleNode) lockFreeLinkedListNode;
                }
                if (lockFreeLinkedListNode instanceof NodeList) {
                    return null;
                }
            }
        }
    }

    private final void j1(NodeList nodeList, Throwable th) {
        m1(th);
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) nodeList.I0(); !Intrinsics.g(lockFreeLinkedListNode, nodeList); lockFreeLinkedListNode = lockFreeLinkedListNode.J0()) {
            if (lockFreeLinkedListNode instanceof JobCancellingNode) {
                JobNode jobNode = (JobNode) lockFreeLinkedListNode;
                try {
                    jobNode.X0(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        ExceptionsKt.a(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + jobNode + " for " + this, th2);
                        Unit unit = Unit.f28779a;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            V0(completionHandlerException);
        }
        A0(th);
    }

    private final void k1(NodeList nodeList, Throwable th) {
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) nodeList.I0(); !Intrinsics.g(lockFreeLinkedListNode, nodeList); lockFreeLinkedListNode = lockFreeLinkedListNode.J0()) {
            if (lockFreeLinkedListNode instanceof JobNode) {
                JobNode jobNode = (JobNode) lockFreeLinkedListNode;
                try {
                    jobNode.X0(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        ExceptionsKt.a(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + jobNode + " for " + this, th2);
                        Unit unit = Unit.f28779a;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            V0(completionHandlerException);
        }
    }

    private final /* synthetic */ <T extends JobNode> void l1(NodeList nodeList, Throwable th) {
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) nodeList.I0(); !Intrinsics.g(lockFreeLinkedListNode, nodeList); lockFreeLinkedListNode = lockFreeLinkedListNode.J0()) {
            Intrinsics.y(3, ExifInterface.d5);
            if (lockFreeLinkedListNode instanceof LockFreeLinkedListNode) {
                JobNode jobNode = (JobNode) lockFreeLinkedListNode;
                try {
                    jobNode.X0(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        ExceptionsKt.a(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + jobNode + " for " + this, th2);
                        Unit unit = Unit.f28779a;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            V0(completionHandlerException);
        }
    }

    /* JADX WARNING: type inference failed for: r1v2, types: [kotlinx.coroutines.InactiveNodeList] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void p1(kotlinx.coroutines.Empty r3) {
        /*
            r2 = this;
            kotlinx.coroutines.NodeList r0 = new kotlinx.coroutines.NodeList
            r0.<init>()
            boolean r1 = r3.b()
            if (r1 == 0) goto L_0x000c
            goto L_0x0012
        L_0x000c:
            kotlinx.coroutines.InactiveNodeList r1 = new kotlinx.coroutines.InactiveNodeList
            r1.<init>(r0)
            r0 = r1
        L_0x0012:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = s
            androidx.concurrent.futures.a.a(r1, r2, r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.p1(kotlinx.coroutines.Empty):void");
    }

    private final boolean q0(Object obj, NodeList nodeList, JobNode jobNode) {
        int V0;
        JobSupport$addLastAtomic$$inlined$addLastIf$1 jobSupport$addLastAtomic$$inlined$addLastIf$1 = new JobSupport$addLastAtomic$$inlined$addLastIf$1(jobNode, this, obj);
        do {
            V0 = nodeList.K0().V0(jobNode, nodeList, jobSupport$addLastAtomic$$inlined$addLastIf$1);
            if (V0 == 1) {
                return true;
            }
        } while (V0 != 2);
        return false;
    }

    private final void q1(JobNode jobNode) {
        jobNode.C0(new NodeList());
        a.a(s, this, jobNode, jobNode.J0());
    }

    private final void r0(Throwable th, List<? extends Throwable> list) {
        if (list.size() > 1) {
            Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
            for (Throwable th2 : list) {
                if (th2 != th && th2 != th && !(th2 instanceof CancellationException) && newSetFromMap.add(th2)) {
                    ExceptionsKt.a(th, th2);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final Object v0(Continuation<Object> continuation) {
        AwaitContinuation awaitContinuation = new AwaitContinuation(IntrinsicsKt.e(continuation), this);
        awaitContinuation.W();
        CancellableContinuationKt.a(awaitContinuation, Z(new ResumeAwaitOnCompletion(awaitContinuation)));
        Object y = awaitContinuation.y();
        if (y == IntrinsicsKt.l()) {
            DebugProbesKt.c(continuation);
        }
        return y;
    }

    private final int v1(Object obj) {
        if (obj instanceof Empty) {
            if (((Empty) obj).b()) {
                return 0;
            }
            if (!a.a(s, this, obj, JobSupportKt.f29216j)) {
                return -1;
            }
            o1();
            return 1;
        } else if (!(obj instanceof InactiveNodeList)) {
            return 0;
        } else {
            if (!a.a(s, this, obj, ((InactiveNodeList) obj).B())) {
                return -1;
            }
            o1();
            return 1;
        }
    }

    private final String w1(Object obj) {
        if (!(obj instanceof Finishing)) {
            return obj instanceof Incomplete ? ((Incomplete) obj).b() ? "Active" : "New" : obj instanceof CompletedExceptionally ? "Cancelled" : "Completed";
        }
        Finishing finishing = (Finishing) obj;
        if (finishing.f()) {
            return "Cancelling";
        }
        return finishing.g() ? "Completing" : "Active";
    }

    public static /* synthetic */ CancellationException y1(JobSupport jobSupport, Throwable th, String str, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                str = null;
            }
            return jobSupport.x1(th, str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
    }

    private final Object z0(Object obj) {
        Object C1;
        do {
            Object T0 = T0();
            if (!(T0 instanceof Incomplete) || ((T0 instanceof Finishing) && ((Finishing) T0).g())) {
                return JobSupportKt.f29207a;
            }
            C1 = C1(T0, new CompletedExceptionally(F0(obj), false, 2, (DefaultConstructorMarker) null));
        } while (C1 == JobSupportKt.f29209c);
        return C1;
    }

    @Nullable
    public final Throwable A() {
        Object T0 = T0();
        if (!(T0 instanceof Incomplete)) {
            return N0(T0);
        }
        throw new IllegalStateException("This job has not completed yet".toString());
    }

    /* access modifiers changed from: protected */
    @NotNull
    public String B0() {
        return "Job was cancelled";
    }

    public final <R> void C(@NotNull SelectInstance<? super R> selectInstance, @NotNull Function1<? super Continuation<? super R>, ? extends Object> function1) {
        Object T0;
        do {
            T0 = T0();
            if (!selectInstance.I()) {
                if (!(T0 instanceof Incomplete)) {
                    if (selectInstance.y()) {
                        UndispatchedKt.c(function1, selectInstance.J());
                        return;
                    }
                    return;
                }
            } else {
                return;
            }
        } while (v1(T0) != 0);
        selectInstance.p0(Z(new SelectJoinOnCompletion(selectInstance, function1)));
    }

    public boolean C0(@NotNull Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return x0(th) && P0();
    }

    @Nullable
    public final Object F(@NotNull Continuation<? super Unit> continuation) {
        if (!a1()) {
            JobKt.z(continuation.g());
            return Unit.f28779a;
        }
        Object b1 = b1(continuation);
        return b1 == IntrinsicsKt.l() ? b1 : Unit.f28779a;
    }

    @NotNull
    public final JobCancellationException G0(@Nullable String str, @Nullable Throwable th) {
        if (str == null) {
            str = B0();
        }
        return new JobCancellationException(str, th, this);
    }

    @NotNull
    public final DisposableHandle H(boolean z, boolean z2, @NotNull Function1<? super Throwable, Unit> function1) {
        JobNode g1 = g1(function1, z);
        while (true) {
            Object T0 = T0();
            if (T0 instanceof Empty) {
                Empty empty = (Empty) T0;
                if (!empty.b()) {
                    p1(empty);
                } else if (a.a(s, this, T0, g1)) {
                    return g1;
                }
            } else {
                Throwable th = null;
                if (T0 instanceof Incomplete) {
                    NodeList B = ((Incomplete) T0).B();
                    if (B != null) {
                        DisposableHandle disposableHandle = NonDisposableHandle.s;
                        if (z && (T0 instanceof Finishing)) {
                            synchronized (T0) {
                                try {
                                    th = ((Finishing) T0).e();
                                    if (th != null) {
                                        if ((function1 instanceof ChildHandleNode) && !((Finishing) T0).g()) {
                                        }
                                        Unit unit = Unit.f28779a;
                                    }
                                    if (q0(T0, B, g1)) {
                                        if (th == null) {
                                            return g1;
                                        }
                                        disposableHandle = g1;
                                        Unit unit2 = Unit.f28779a;
                                    }
                                } catch (Throwable th2) {
                                    throw th2;
                                }
                            }
                        }
                        if (th != null) {
                            if (z2) {
                                function1.f(th);
                            }
                            return disposableHandle;
                        } else if (q0(T0, B, g1)) {
                            return g1;
                        }
                    } else if (T0 != null) {
                        q1((JobNode) T0);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    }
                } else {
                    if (z2) {
                        CompletedExceptionally completedExceptionally = T0 instanceof CompletedExceptionally ? (CompletedExceptionally) T0 : null;
                        if (completedExceptionally != null) {
                            th = completedExceptionally.f29164a;
                        }
                        function1.f(th);
                    }
                    return NonDisposableHandle.s;
                }
            }
        }
    }

    @NotNull
    public final CancellationException I() {
        Object T0 = T0();
        if (T0 instanceof Finishing) {
            Throwable e2 = ((Finishing) T0).e();
            if (e2 != null) {
                CancellationException x1 = x1(e2, DebugStringsKt.a(this) + " is cancelling");
                if (x1 != null) {
                    return x1;
                }
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (T0 instanceof Incomplete) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (T0 instanceof CompletedExceptionally) {
            return y1(this, ((CompletedExceptionally) T0).f29164a, (String) null, 1, (Object) null);
        } else {
            return new JobCancellationException(DebugStringsKt.a(this) + " has completed normally", (Throwable) null, this);
        }
    }

    @Nullable
    public final Object K0() {
        Object T0 = T0();
        if (!(!(T0 instanceof Incomplete))) {
            throw new IllegalStateException("This job has not completed yet".toString());
        } else if (!(T0 instanceof CompletedExceptionally)) {
            return JobSupportKt.o(T0);
        } else {
            throw ((CompletedExceptionally) T0).f29164a;
        }
    }

    public final void L(@NotNull ParentJob parentJob) {
        x0(parentJob);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final Throwable L0() {
        Object T0 = T0();
        if (T0 instanceof Finishing) {
            Throwable e2 = ((Finishing) T0).e();
            if (e2 != null) {
                return e2;
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (T0 instanceof Incomplete) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (T0 instanceof CompletedExceptionally) {
            return ((CompletedExceptionally) T0).f29164a;
        } else {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final boolean M0() {
        Object T0 = T0();
        return (T0 instanceof CompletedExceptionally) && ((CompletedExceptionally) T0).a();
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    public Job O(@NotNull Job job) {
        return Job.DefaultImpls.i(this, job);
    }

    public boolean P0() {
        return true;
    }

    public boolean Q0() {
        return false;
    }

    @Nullable
    public final ChildHandle S0() {
        return (ChildHandle) this._parentHandle;
    }

    @Nullable
    public final Object T0() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof OpDescriptor)) {
                return obj;
            }
            ((OpDescriptor) obj).c(this);
        }
    }

    /* access modifiers changed from: protected */
    public boolean U0(@NotNull Throwable th) {
        return false;
    }

    public void V0(@NotNull Throwable th) {
        throw th;
    }

    /* access modifiers changed from: protected */
    public final void W0(@Nullable Job job) {
        if (job == null) {
            u1(NonDisposableHandle.s);
            return;
        }
        job.start();
        ChildHandle m0 = job.m0(this);
        u1(m0);
        if (p()) {
            m0.m();
            u1(NonDisposableHandle.s);
        }
    }

    public final boolean Y0() {
        return T0() instanceof CompletedExceptionally;
    }

    @NotNull
    public final DisposableHandle Z(@NotNull Function1<? super Throwable, Unit> function1) {
        return H(false, true, function1);
    }

    /* access modifiers changed from: protected */
    public boolean Z0() {
        return false;
    }

    public boolean b() {
        Object T0 = T0();
        return (T0 instanceof Incomplete) && ((Incomplete) T0).b();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        i((CancellationException) null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Added since 1.2.0 for binary compatibility with versions <= 1.1.x")
    public /* synthetic */ boolean d(Throwable th) {
        Throwable th2;
        if (th == null || (th2 = y1(this, th, (String) null, 1, (Object) null)) == null) {
            th2 = new JobCancellationException(B0(), (Throwable) null, this);
        }
        y0(th2);
        return true;
    }

    @NotNull
    public final SelectClause0 d0() {
        return this;
    }

    @Nullable
    public <E extends CoroutineContext.Element> E e(@NotNull CoroutineContext.Key<E> key) {
        return Job.DefaultImpls.e(this, key);
    }

    public final boolean e1(@Nullable Object obj) {
        Object C1;
        do {
            C1 = C1(T0(), obj);
            if (C1 == JobSupportKt.f29207a) {
                return false;
            }
            if (C1 == JobSupportKt.f29208b) {
                return true;
            }
        } while (C1 == JobSupportKt.f29209c);
        s0(C1);
        return true;
    }

    @NotNull
    public CoroutineContext f(@NotNull CoroutineContext.Key<?> key) {
        return Job.DefaultImpls.g(this, key);
    }

    @Nullable
    public final Object f1(@Nullable Object obj) {
        Object C1;
        do {
            C1 = C1(T0(), obj);
            if (C1 == JobSupportKt.f29207a) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, N0(obj));
            }
        } while (C1 == JobSupportKt.f29209c);
        return C1;
    }

    @NotNull
    public final CoroutineContext.Key<?> getKey() {
        return Job.P2;
    }

    @NotNull
    public CancellationException h0() {
        Throwable th;
        Object T0 = T0();
        CancellationException cancellationException = null;
        if (T0 instanceof Finishing) {
            th = ((Finishing) T0).e();
        } else if (T0 instanceof CompletedExceptionally) {
            th = ((CompletedExceptionally) T0).f29164a;
        } else if (!(T0 instanceof Incomplete)) {
            th = null;
        } else {
            throw new IllegalStateException(("Cannot be cancelling child in this state: " + T0).toString());
        }
        if (th instanceof CancellationException) {
            cancellationException = (CancellationException) th;
        }
        if (cancellationException != null) {
            return cancellationException;
        }
        return new JobCancellationException("Parent job is " + w1(T0), th, this);
    }

    @NotNull
    public String h1() {
        return DebugStringsKt.a(this);
    }

    public void i(@Nullable CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(B0(), (Throwable) null, this);
        }
        y0(cancellationException);
    }

    public final boolean isCancelled() {
        Object T0 = T0();
        return (T0 instanceof CompletedExceptionally) || ((T0 instanceof Finishing) && ((Finishing) T0).f());
    }

    @NotNull
    public final ChildHandle m0(@NotNull ChildJob childJob) {
        return (ChildHandle) Job.DefaultImpls.f(this, true, false, new ChildHandleNode(childJob), 2, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void m1(@Nullable Throwable th) {
    }

    public <R> R n(R r, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return Job.DefaultImpls.d(this, r, function2);
    }

    /* access modifiers changed from: protected */
    public void n1(@Nullable Object obj) {
    }

    /* access modifiers changed from: protected */
    public void o1() {
    }

    public final boolean p() {
        return !(T0() instanceof Incomplete);
    }

    public final <T, R> void r1(@NotNull SelectInstance<? super R> selectInstance, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        Object T0;
        do {
            T0 = T0();
            if (!selectInstance.I()) {
                if (!(T0 instanceof Incomplete)) {
                    if (!selectInstance.y()) {
                        return;
                    }
                    if (T0 instanceof CompletedExceptionally) {
                        selectInstance.g0(((CompletedExceptionally) T0).f29164a);
                        return;
                    } else {
                        UndispatchedKt.d(function2, JobSupportKt.o(T0), selectInstance.J());
                        return;
                    }
                }
            } else {
                return;
            }
        } while (v1(T0) != 0);
        selectInstance.p0(Z(new SelectAwaitOnCompletion(selectInstance, function2)));
    }

    /* access modifiers changed from: protected */
    public void s0(@Nullable Object obj) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void s1(@org.jetbrains.annotations.NotNull kotlinx.coroutines.JobNode r4) {
        /*
            r3 = this;
        L_0x0000:
            java.lang.Object r0 = r3.T0()
            boolean r1 = r0 instanceof kotlinx.coroutines.JobNode
            if (r1 == 0) goto L_0x0018
            if (r0 == r4) goto L_0x000b
            return
        L_0x000b:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = s
            kotlinx.coroutines.Empty r2 = kotlinx.coroutines.JobSupportKt.f29216j
            boolean r0 = androidx.concurrent.futures.a.a(r1, r3, r0, r2)
            if (r0 == 0) goto L_0x0000
            return
        L_0x0018:
            boolean r1 = r0 instanceof kotlinx.coroutines.Incomplete
            if (r1 == 0) goto L_0x0027
            kotlinx.coroutines.Incomplete r0 = (kotlinx.coroutines.Incomplete) r0
            kotlinx.coroutines.NodeList r0 = r0.B()
            if (r0 == 0) goto L_0x0027
            r4.Q0()
        L_0x0027:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.s1(kotlinx.coroutines.JobNode):void");
    }

    public final boolean start() {
        int v1;
        do {
            v1 = v1(T0());
            if (v1 == 0) {
                return false;
            }
        } while (v1 != 1);
        return true;
    }

    @Nullable
    public final Object t0(@NotNull Continuation<Object> continuation) {
        Object T0;
        do {
            T0 = T0();
            if (!(T0 instanceof Incomplete)) {
                if (!(T0 instanceof CompletedExceptionally)) {
                    return JobSupportKt.o(T0);
                }
                throw ((CompletedExceptionally) T0).f29164a;
            }
        } while (v1(T0) < 0);
        return v0(continuation);
    }

    public final <T, R> void t1(@NotNull SelectInstance<? super R> selectInstance, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        Object T0 = T0();
        if (T0 instanceof CompletedExceptionally) {
            selectInstance.g0(((CompletedExceptionally) T0).f29164a);
            return;
        }
        CancellableKt.f(function2, JobSupportKt.o(T0), selectInstance.J(), (Function1) null, 4, (Object) null);
    }

    @NotNull
    public String toString() {
        return z1() + '@' + DebugStringsKt.b(this);
    }

    public final void u1(@Nullable ChildHandle childHandle) {
        this._parentHandle = childHandle;
    }

    @NotNull
    public CoroutineContext v(@NotNull CoroutineContext coroutineContext) {
        return Job.DefaultImpls.h(this, coroutineContext);
    }

    public final boolean w0(@Nullable Throwable th) {
        return x0(th);
    }

    public final boolean x0(@Nullable Object obj) {
        Object a2 = JobSupportKt.f29207a;
        if (Q0() && (a2 = z0(obj)) == JobSupportKt.f29208b) {
            return true;
        }
        if (a2 == JobSupportKt.f29207a) {
            a2 = d1(obj);
        }
        if (a2 == JobSupportKt.f29207a || a2 == JobSupportKt.f29208b) {
            return true;
        }
        if (a2 == JobSupportKt.f29210d) {
            return false;
        }
        s0(a2);
        return true;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public final CancellationException x1(@NotNull Throwable th, @Nullable String str) {
        CancellationException cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
        if (cancellationException == null) {
            if (str == null) {
                str = B0();
            }
            cancellationException = new JobCancellationException(str, th, this);
        }
        return cancellationException;
    }

    @NotNull
    public final Sequence<Job> y() {
        return SequencesKt.b(new JobSupport$children$1(this, (Continuation<? super JobSupport$children$1>) null));
    }

    public void y0(@NotNull Throwable th) {
        x0(th);
    }

    @NotNull
    @InternalCoroutinesApi
    public final String z1() {
        return h1() + ASCIIPropertyListParser.f18652j + w1(T0()) + ASCIIPropertyListParser.f18653k;
    }
}
