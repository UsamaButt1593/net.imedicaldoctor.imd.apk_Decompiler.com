package kotlinx.coroutines.channels;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u001aL\u0010\n\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003j\u0002`\t2\u001a\u0010\u0002\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00010\u0000\"\u0006\u0012\u0002\b\u00030\u0001H\u0001¢\u0006\u0004\b\n\u0010\u000b\u001a+\u0010\u000f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u000e\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a-\u0010\u0011\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u000e\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0010\u001a#\u0010\u0012\u001a\u00028\u0000\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u0001H@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a%\u0010\u0014\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u0001H@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0013\u001a+\u0010\u0016\u001a\u00020\r\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0015\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a#\u0010\u0018\u001a\u00028\u0000\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u0001H@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0013\u001a+\u0010\u0019\u001a\u00020\r\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0015\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0017\u001a%\u0010\u001a\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u0001H@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0013\u001a#\u0010\u001b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u0001H@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0013\u001a%\u0010\u001c\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u0001H@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u0013\u001a7\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u001d\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\u001eH\u0007¢\u0006\u0004\b \u0010!\u001aV\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\"\u0010&\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#\u0012\u0006\u0012\u0004\u0018\u00010%0\"H\u0007ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001aV\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\"\u0010&\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#\u0012\u0006\u0012\u0004\u0018\u00010%0\"H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010(\u001ak\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u001e27\u0010&\u001a3\b\u0001\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#\u0012\u0006\u0012\u0004\u0018\u00010%0)H\u0007ø\u0001\u0000¢\u0006\u0004\b*\u0010+\u001aV\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\"\u0010&\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#\u0012\u0006\u0012\u0004\u0018\u00010%0\"H\u0007ø\u0001\u0000¢\u0006\u0004\b,\u0010(\u001a+\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\f*\u00020%*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001H\u0001¢\u0006\u0004\b-\u0010.\u001aC\u00101\u001a\u00028\u0001\"\b\b\u0000\u0010\f*\u00020%\"\u0010\b\u0001\u0010\u0019*\n\u0012\u0006\b\u0000\u0012\u00028\u00000/*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00012\u0006\u00100\u001a\u00028\u0001H@ø\u0001\u0000¢\u0006\u0004\b1\u00102\u001aA\u00104\u001a\u00028\u0001\"\b\b\u0000\u0010\f*\u00020%\"\u000e\b\u0001\u0010\u0019*\b\u0012\u0004\u0012\u00028\u000003*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00012\u0006\u00100\u001a\u00028\u0001H@ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001a7\u00106\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u001d\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\u001eH\u0007¢\u0006\u0004\b6\u0010!\u001aV\u00107\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\"\u0010&\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#\u0012\u0006\u0012\u0004\u0018\u00010%0\"H\u0007ø\u0001\u0000¢\u0006\u0004\b7\u0010(\u001a;\u00108\u001a\u00028\u0001\"\u0004\b\u0000\u0010\f\"\u000e\b\u0001\u0010\u0019*\b\u0012\u0004\u0012\u00028\u000003*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u00100\u001a\u00028\u0001H@ø\u0001\u0000¢\u0006\u0004\b8\u00105\u001a=\u00109\u001a\u00028\u0001\"\u0004\b\u0000\u0010\f\"\u0010\b\u0001\u0010\u0019*\n\u0012\u0006\b\u0000\u0012\u00028\u00000/*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u00100\u001a\u00028\u0001H@ø\u0001\u0000¢\u0006\u0004\b9\u00102\u001aA\u0010>\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010=\"\u0004\b\u0000\u0010:\"\u0004\b\u0001\u0010;*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010<0\u0001H@ø\u0001\u0000¢\u0006\u0004\b>\u0010\u0013\u001aW\u0010A\u001a\u00028\u0002\"\u0004\b\u0000\u0010:\"\u0004\b\u0001\u0010;\"\u0018\b\u0002\u0010@*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010?*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010<0\u00012\u0006\u00100\u001a\u00028\u0002H@ø\u0001\u0000¢\u0006\u0004\bA\u0010B\u001a)\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00000C\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u0001H@ø\u0001\u0000¢\u0006\u0004\bD\u0010\u0013\u001a)\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00000E\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u0001H@ø\u0001\u0000¢\u0006\u0004\bF\u0010\u0013\u001ab\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\u001c*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u001e2(\u0010G\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00010#\u0012\u0006\u0012\u0004\u0018\u00010%0\"H\u0007ø\u0001\u0000¢\u0006\u0004\bH\u0010(\u001a\\\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\u001c*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\"\u0010G\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010#\u0012\u0006\u0012\u0004\u0018\u00010%0\"H\u0001ø\u0001\u0000¢\u0006\u0004\b\f\u0010(\u001aq\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\u001c*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u001e27\u0010G\u001a3\b\u0001\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010#\u0012\u0006\u0012\u0004\u0018\u00010%0)H\u0001ø\u0001\u0000¢\u0006\u0004\bI\u0010+\u001aw\u0010J\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\f\"\b\b\u0001\u0010\u001c*\u00020%*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u001e29\u0010G\u001a5\b\u0001\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00028\u0000\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010#\u0012\u0006\u0012\u0004\u0018\u00010%0)H\u0007ø\u0001\u0000¢\u0006\u0004\bJ\u0010+\u001ab\u0010:\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\f\"\b\b\u0001\u0010\u001c*\u00020%*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u001e2$\u0010G\u001a \b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010#\u0012\u0006\u0012\u0004\u0018\u00010%0\"H\u0007ø\u0001\u0000¢\u0006\u0004\b:\u0010(\u001a5\u0010L\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000K0\u0001\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u001eH\u0007¢\u0006\u0004\bL\u0010M\u001a%\u0010N\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007¢\u0006\u0004\bN\u0010.\u001a\\\u0010P\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010:*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\"\u0010O\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010#\u0012\u0006\u0012\u0004\u0018\u00010%0\"H\u0001ø\u0001\u0000¢\u0006\u0004\bP\u0010(\u001a)\u0010R\u001a\b\u0012\u0004\u0012\u00028\u00000Q\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u0001H@ø\u0001\u0000¢\u0006\u0004\bR\u0010\u0013\u001a#\u0010S\u001a\u00020$\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u0001H@ø\u0001\u0000¢\u0006\u0004\bS\u0010\u0013\u001a#\u0010T\u001a\u00020\r\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u0001H@ø\u0001\u0000¢\u0006\u0004\bT\u0010\u0013\u001aA\u0010@\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\u0010W\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000Uj\n\u0012\u0006\b\u0000\u0012\u00028\u0000`VH@ø\u0001\u0000¢\u0006\u0004\b@\u0010X\u001aA\u0010Y\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\u0010W\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000Uj\n\u0012\u0006\b\u0000\u0012\u00028\u0000`VH@ø\u0001\u0000¢\u0006\u0004\bY\u0010X\u001a#\u0010Z\u001a\u00020$\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u0001H@ø\u0001\u0000¢\u0006\u0004\bZ\u0010\u0013\u001a+\u0010[\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\f*\u00020%*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001H\u0007¢\u0006\u0004\b[\u0010.\u001aF\u0010]\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010<0\u0001\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\u001c*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\\\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001H\u0004¢\u0006\u0004\b]\u0010^\u001a\u0001\u0010`\u001a\b\u0012\u0004\u0012\u00028\u00020\u0001\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\u001c\"\u0004\b\u0002\u0010;*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\\\u001a\b\u0012\u0004\u0012\u00028\u00010\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u001e26\u0010G\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(S\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(_\u0012\u0004\u0012\u00028\u00020\"H\u0001¢\u0006\u0004\b`\u0010a\u001a8\u0010_\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003j\u0002`\t*\u0006\u0012\u0002\b\u00030\u0001H\u0001¢\u0006\u0004\b_\u0010b\u0002\u0004\n\u0002\b\u0019¨\u0006c"}, d2 = {"", "Lkotlinx/coroutines/channels/ReceiveChannel;", "channels", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "c", "([Lkotlinx/coroutines/channels/ReceiveChannel;)Lkotlin/jvm/functions/Function1;", "E", "", "index", "l", "(Lkotlinx/coroutines/channels/ReceiveChannel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "m", "w", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "x", "element", "A", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "B", "C", "D", "Q", "R", "n", "Lkotlin/coroutines/CoroutineContext;", "context", "h", "(Lkotlinx/coroutines/channels/ReceiveChannel;ILkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "predicate", "j", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlin/Function3;", "p", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/channels/ReceiveChannel;", "r", "t", "(Lkotlinx/coroutines/channels/ReceiveChannel;)Lkotlinx/coroutines/channels/ReceiveChannel;", "", "destination", "u", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/SendChannel;", "v", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlinx/coroutines/channels/SendChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "S", "U", "W", "X", "K", "V", "Lkotlin/Pair;", "", "Z", "", "M", "Y", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "a0", "", "c0", "transform", "y", "G", "I", "Lkotlin/collections/IndexedValue;", "d0", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/channels/ReceiveChannel;", "e", "selector", "f", "", "b0", "a", "d", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Comparator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "N", "O", "P", "other", "f0", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlinx/coroutines/channels/ReceiveChannel;)Lkotlinx/coroutines/channels/ReceiveChannel;", "b", "g0", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "(Lkotlinx/coroutines/channels/ReceiveChannel;)Lkotlin/jvm/functions/Function1;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xs = "kotlinx/coroutines/channels/ChannelsKt")
final /* synthetic */ class ChannelsKt__DeprecatedKt {
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0064 A[Catch:{ all -> 0x0037 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0070 A[Catch:{ all -> 0x0037 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x008b A[Catch:{ all -> 0x0037 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ java.lang.Object A(kotlinx.coroutines.channels.ReceiveChannel r7, java.lang.Object r8, kotlin.coroutines.Continuation r9) {
        /*
            boolean r0 = r9 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$indexOf$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$indexOf$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$indexOf$1) r0
            int r1 = r0.b3
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b3 = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$indexOf$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$indexOf$1
            r0.<init>(r9)
        L_0x0018:
            java.lang.Object r9 = r0.a3
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.b3
            r3 = 1
            if (r2 == 0) goto L_0x0042
            if (r2 != r3) goto L_0x003a
            java.lang.Object r7 = r0.Z2
            kotlinx.coroutines.channels.ChannelIterator r7 = (kotlinx.coroutines.channels.ChannelIterator) r7
            java.lang.Object r8 = r0.Y2
            kotlinx.coroutines.channels.ReceiveChannel r8 = (kotlinx.coroutines.channels.ReceiveChannel) r8
            java.lang.Object r2 = r0.X2
            kotlin.jvm.internal.Ref$IntRef r2 = (kotlin.jvm.internal.Ref.IntRef) r2
            java.lang.Object r4 = r0.Z
            kotlin.ResultKt.n(r9)     // Catch:{ all -> 0x0037 }
            goto L_0x0067
        L_0x0037:
            r7 = move-exception
            goto L_0x009a
        L_0x003a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0042:
            kotlin.ResultKt.n(r9)
            kotlin.jvm.internal.Ref$IntRef r9 = new kotlin.jvm.internal.Ref$IntRef
            r9.<init>()
            kotlinx.coroutines.channels.ChannelIterator r2 = r7.iterator()     // Catch:{ all -> 0x0096 }
            r6 = r8
            r8 = r7
            r7 = r2
            r2 = r9
            r9 = r6
        L_0x0053:
            r0.Z = r9     // Catch:{ all -> 0x0037 }
            r0.X2 = r2     // Catch:{ all -> 0x0037 }
            r0.Y2 = r8     // Catch:{ all -> 0x0037 }
            r0.Z2 = r7     // Catch:{ all -> 0x0037 }
            r0.b3 = r3     // Catch:{ all -> 0x0037 }
            java.lang.Object r4 = r7.a(r0)     // Catch:{ all -> 0x0037 }
            if (r4 != r1) goto L_0x0064
            return r1
        L_0x0064:
            r6 = r4
            r4 = r9
            r9 = r6
        L_0x0067:
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch:{ all -> 0x0037 }
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x0037 }
            r5 = 0
            if (r9 == 0) goto L_0x008b
            java.lang.Object r9 = r7.next()     // Catch:{ all -> 0x0037 }
            boolean r9 = kotlin.jvm.internal.Intrinsics.g(r4, r9)     // Catch:{ all -> 0x0037 }
            if (r9 == 0) goto L_0x0084
            int r7 = r2.s     // Catch:{ all -> 0x0037 }
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.Boxing.f(r7)     // Catch:{ all -> 0x0037 }
            kotlinx.coroutines.channels.ChannelsKt.b(r8, r5)
            return r7
        L_0x0084:
            int r9 = r2.s     // Catch:{ all -> 0x0037 }
            int r9 = r9 + r3
            r2.s = r9     // Catch:{ all -> 0x0037 }
            r9 = r4
            goto L_0x0053
        L_0x008b:
            kotlin.Unit r7 = kotlin.Unit.f28779a     // Catch:{ all -> 0x0037 }
            kotlinx.coroutines.channels.ChannelsKt.b(r8, r5)
            r7 = -1
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.Boxing.f(r7)
            return r7
        L_0x0096:
            r8 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
        L_0x009a:
            throw r7     // Catch:{ all -> 0x009b }
        L_0x009b:
            r9 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.b(r8, r7)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.A(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0071 A[Catch:{ all -> 0x004e }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0093 A[Catch:{ all -> 0x0036 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a2 A[SYNTHETIC, Splitter:B:46:0x00a2] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ java.lang.Object B(kotlinx.coroutines.channels.ReceiveChannel r6, kotlin.coroutines.Continuation r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$last$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$last$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$last$1) r0
            int r1 = r0.a3
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.a3 = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$last$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$last$1
            r0.<init>(r7)
        L_0x0018:
            java.lang.Object r7 = r0.Z2
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.a3
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0051
            if (r2 == r4) goto L_0x0042
            if (r2 != r3) goto L_0x003a
            java.lang.Object r6 = r0.Y2
            java.lang.Object r2 = r0.X2
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            java.lang.Object r4 = r0.Z
            kotlinx.coroutines.channels.ReceiveChannel r4 = (kotlinx.coroutines.channels.ReceiveChannel) r4
            kotlin.ResultKt.n(r7)     // Catch:{ all -> 0x0036 }
            goto L_0x008b
        L_0x0036:
            r6 = move-exception
            r2 = r4
            goto L_0x00aa
        L_0x003a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0042:
            java.lang.Object r6 = r0.X2
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r2 = r0.Z
            kotlinx.coroutines.channels.ReceiveChannel r2 = (kotlinx.coroutines.channels.ReceiveChannel) r2
            kotlin.ResultKt.n(r7)     // Catch:{ all -> 0x004e }
            goto L_0x0069
        L_0x004e:
            r6 = move-exception
            goto L_0x00aa
        L_0x0051:
            kotlin.ResultKt.n(r7)
            kotlinx.coroutines.channels.ChannelIterator r7 = r6.iterator()     // Catch:{ all -> 0x009e }
            r0.Z = r6     // Catch:{ all -> 0x009e }
            r0.X2 = r7     // Catch:{ all -> 0x009e }
            r0.a3 = r4     // Catch:{ all -> 0x009e }
            java.lang.Object r2 = r7.a(r0)     // Catch:{ all -> 0x009e }
            if (r2 != r1) goto L_0x0065
            return r1
        L_0x0065:
            r5 = r2
            r2 = r6
            r6 = r7
            r7 = r5
        L_0x0069:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x004e }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x004e }
            if (r7 == 0) goto L_0x00a2
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x004e }
            r5 = r2
            r2 = r6
            r6 = r5
        L_0x0078:
            r0.Z = r6     // Catch:{ all -> 0x009e }
            r0.X2 = r2     // Catch:{ all -> 0x009e }
            r0.Y2 = r7     // Catch:{ all -> 0x009e }
            r0.a3 = r3     // Catch:{ all -> 0x009e }
            java.lang.Object r4 = r2.a(r0)     // Catch:{ all -> 0x009e }
            if (r4 != r1) goto L_0x0087
            return r1
        L_0x0087:
            r5 = r4
            r4 = r6
            r6 = r7
            r7 = r5
        L_0x008b:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x0036 }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x0036 }
            if (r7 == 0) goto L_0x0099
            java.lang.Object r7 = r2.next()     // Catch:{ all -> 0x0036 }
            r6 = r4
            goto L_0x0078
        L_0x0099:
            r7 = 0
            kotlinx.coroutines.channels.ChannelsKt.b(r4, r7)
            return r6
        L_0x009e:
            r7 = move-exception
            r2 = r6
            r6 = r7
            goto L_0x00aa
        L_0x00a2:
            java.util.NoSuchElementException r6 = new java.util.NoSuchElementException     // Catch:{ all -> 0x004e }
            java.lang.String r7 = "ReceiveChannel is empty."
            r6.<init>(r7)     // Catch:{ all -> 0x004e }
            throw r6     // Catch:{ all -> 0x004e }
        L_0x00aa:
            throw r6     // Catch:{ all -> 0x00ab }
        L_0x00ab:
            r7 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.b(r2, r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.B(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0072 A[Catch:{ all -> 0x003b }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007d A[Catch:{ all -> 0x003b }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0092 A[Catch:{ all -> 0x003b }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ java.lang.Object C(kotlinx.coroutines.channels.ReceiveChannel r7, java.lang.Object r8, kotlin.coroutines.Continuation r9) {
        /*
            boolean r0 = r9 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$lastIndexOf$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$lastIndexOf$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$lastIndexOf$1) r0
            int r1 = r0.c3
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.c3 = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$lastIndexOf$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$lastIndexOf$1
            r0.<init>(r9)
        L_0x0018:
            java.lang.Object r9 = r0.b3
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.c3
            r3 = 1
            if (r2 == 0) goto L_0x0046
            if (r2 != r3) goto L_0x003e
            java.lang.Object r7 = r0.a3
            kotlinx.coroutines.channels.ChannelIterator r7 = (kotlinx.coroutines.channels.ChannelIterator) r7
            java.lang.Object r8 = r0.Z2
            kotlinx.coroutines.channels.ReceiveChannel r8 = (kotlinx.coroutines.channels.ReceiveChannel) r8
            java.lang.Object r2 = r0.Y2
            kotlin.jvm.internal.Ref$IntRef r2 = (kotlin.jvm.internal.Ref.IntRef) r2
            java.lang.Object r4 = r0.X2
            kotlin.jvm.internal.Ref$IntRef r4 = (kotlin.jvm.internal.Ref.IntRef) r4
            java.lang.Object r5 = r0.Z
            kotlin.ResultKt.n(r9)     // Catch:{ all -> 0x003b }
            goto L_0x0075
        L_0x003b:
            r7 = move-exception
            goto L_0x00a3
        L_0x003e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0046:
            kotlin.ResultKt.n(r9)
            kotlin.jvm.internal.Ref$IntRef r9 = new kotlin.jvm.internal.Ref$IntRef
            r9.<init>()
            r2 = -1
            r9.s = r2
            kotlin.jvm.internal.Ref$IntRef r2 = new kotlin.jvm.internal.Ref$IntRef
            r2.<init>()
            kotlinx.coroutines.channels.ChannelIterator r4 = r7.iterator()     // Catch:{ all -> 0x009f }
            r6 = r8
            r8 = r7
            r7 = r4
            r4 = r9
            r9 = r6
        L_0x005f:
            r0.Z = r9     // Catch:{ all -> 0x003b }
            r0.X2 = r4     // Catch:{ all -> 0x003b }
            r0.Y2 = r2     // Catch:{ all -> 0x003b }
            r0.Z2 = r8     // Catch:{ all -> 0x003b }
            r0.a3 = r7     // Catch:{ all -> 0x003b }
            r0.c3 = r3     // Catch:{ all -> 0x003b }
            java.lang.Object r5 = r7.a(r0)     // Catch:{ all -> 0x003b }
            if (r5 != r1) goto L_0x0072
            return r1
        L_0x0072:
            r6 = r5
            r5 = r9
            r9 = r6
        L_0x0075:
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch:{ all -> 0x003b }
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x003b }
            if (r9 == 0) goto L_0x0092
            java.lang.Object r9 = r7.next()     // Catch:{ all -> 0x003b }
            boolean r9 = kotlin.jvm.internal.Intrinsics.g(r5, r9)     // Catch:{ all -> 0x003b }
            if (r9 == 0) goto L_0x008b
            int r9 = r2.s     // Catch:{ all -> 0x003b }
            r4.s = r9     // Catch:{ all -> 0x003b }
        L_0x008b:
            int r9 = r2.s     // Catch:{ all -> 0x003b }
            int r9 = r9 + r3
            r2.s = r9     // Catch:{ all -> 0x003b }
            r9 = r5
            goto L_0x005f
        L_0x0092:
            kotlin.Unit r7 = kotlin.Unit.f28779a     // Catch:{ all -> 0x003b }
            r7 = 0
            kotlinx.coroutines.channels.ChannelsKt.b(r8, r7)
            int r7 = r4.s
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.Boxing.f(r7)
            return r7
        L_0x009f:
            r8 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
        L_0x00a3:
            throw r7     // Catch:{ all -> 0x00a4 }
        L_0x00a4:
            r9 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.b(r8, r7)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.C(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0075 A[SYNTHETIC, Splitter:B:32:0x0075] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0097 A[Catch:{ all -> 0x0037 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ java.lang.Object D(kotlinx.coroutines.channels.ReceiveChannel r7, kotlin.coroutines.Continuation r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$lastOrNull$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$lastOrNull$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$lastOrNull$1) r0
            int r1 = r0.a3
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.a3 = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$lastOrNull$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$lastOrNull$1
            r0.<init>(r8)
        L_0x0018:
            java.lang.Object r8 = r0.Z2
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.a3
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x0051
            if (r2 == r4) goto L_0x0043
            if (r2 != r3) goto L_0x003b
            java.lang.Object r7 = r0.Y2
            java.lang.Object r2 = r0.X2
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            java.lang.Object r4 = r0.Z
            kotlinx.coroutines.channels.ReceiveChannel r4 = (kotlinx.coroutines.channels.ReceiveChannel) r4
            kotlin.ResultKt.n(r8)     // Catch:{ all -> 0x0037 }
            goto L_0x008f
        L_0x0037:
            r7 = move-exception
            r2 = r4
            goto L_0x00a4
        L_0x003b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0043:
            java.lang.Object r7 = r0.X2
            kotlinx.coroutines.channels.ChannelIterator r7 = (kotlinx.coroutines.channels.ChannelIterator) r7
            java.lang.Object r2 = r0.Z
            kotlinx.coroutines.channels.ReceiveChannel r2 = (kotlinx.coroutines.channels.ReceiveChannel) r2
            kotlin.ResultKt.n(r8)     // Catch:{ all -> 0x004f }
            goto L_0x0069
        L_0x004f:
            r7 = move-exception
            goto L_0x00a4
        L_0x0051:
            kotlin.ResultKt.n(r8)
            kotlinx.coroutines.channels.ChannelIterator r8 = r7.iterator()     // Catch:{ all -> 0x00a1 }
            r0.Z = r7     // Catch:{ all -> 0x00a1 }
            r0.X2 = r8     // Catch:{ all -> 0x00a1 }
            r0.a3 = r4     // Catch:{ all -> 0x00a1 }
            java.lang.Object r2 = r8.a(r0)     // Catch:{ all -> 0x00a1 }
            if (r2 != r1) goto L_0x0065
            return r1
        L_0x0065:
            r6 = r2
            r2 = r7
            r7 = r8
            r8 = r6
        L_0x0069:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x004f }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x004f }
            if (r8 != 0) goto L_0x0075
            kotlinx.coroutines.channels.ChannelsKt.b(r2, r5)
            return r5
        L_0x0075:
            java.lang.Object r8 = r7.next()     // Catch:{ all -> 0x004f }
            r6 = r2
            r2 = r7
            r7 = r6
        L_0x007c:
            r0.Z = r7     // Catch:{ all -> 0x00a1 }
            r0.X2 = r2     // Catch:{ all -> 0x00a1 }
            r0.Y2 = r8     // Catch:{ all -> 0x00a1 }
            r0.a3 = r3     // Catch:{ all -> 0x00a1 }
            java.lang.Object r4 = r2.a(r0)     // Catch:{ all -> 0x00a1 }
            if (r4 != r1) goto L_0x008b
            return r1
        L_0x008b:
            r6 = r4
            r4 = r7
            r7 = r8
            r8 = r6
        L_0x008f:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x0037 }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x0037 }
            if (r8 == 0) goto L_0x009d
            java.lang.Object r8 = r2.next()     // Catch:{ all -> 0x0037 }
            r7 = r4
            goto L_0x007c
        L_0x009d:
            kotlinx.coroutines.channels.ChannelsKt.b(r4, r5)
            return r7
        L_0x00a1:
            r8 = move-exception
            r2 = r7
            r7 = r8
        L_0x00a4:
            throw r7     // Catch:{ all -> 0x00a5 }
        L_0x00a5:
            r8 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.b(r2, r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.D(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @NotNull
    @PublishedApi
    public static final <E, R> ReceiveChannel<R> E(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull CoroutineContext coroutineContext, @NotNull Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2) {
        return ProduceKt.g(GlobalScope.s, coroutineContext, 0, (CoroutineStart) null, ChannelsKt.g(receiveChannel), new ChannelsKt__DeprecatedKt$map$1(receiveChannel, function2, (Continuation<? super ChannelsKt__DeprecatedKt$map$1>) null), 6, (Object) null);
    }

    public static /* synthetic */ ReceiveChannel F(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            coroutineContext = Dispatchers.g();
        }
        return ChannelsKt.J(receiveChannel, coroutineContext, function2);
    }

    @NotNull
    @PublishedApi
    public static final <E, R> ReceiveChannel<R> G(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull CoroutineContext coroutineContext, @NotNull Function3<? super Integer, ? super E, ? super Continuation<? super R>, ? extends Object> function3) {
        return ProduceKt.g(GlobalScope.s, coroutineContext, 0, (CoroutineStart) null, ChannelsKt.g(receiveChannel), new ChannelsKt__DeprecatedKt$mapIndexed$1(receiveChannel, function3, (Continuation<? super ChannelsKt__DeprecatedKt$mapIndexed$1>) null), 6, (Object) null);
    }

    public static /* synthetic */ ReceiveChannel H(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            coroutineContext = Dispatchers.g();
        }
        return ChannelsKt.L(receiveChannel, coroutineContext, function3);
    }

    public static /* synthetic */ ReceiveChannel J(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            coroutineContext = Dispatchers.g();
        }
        return ChannelsKt.y(ChannelsKt.L(receiveChannel, coroutineContext, function3));
    }

    public static /* synthetic */ ReceiveChannel L(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            coroutineContext = Dispatchers.g();
        }
        return ChannelsKt.y(ChannelsKt.J(receiveChannel, coroutineContext, function2));
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0086 A[SYNTHETIC, Splitter:B:34:0x0086] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x009f A[Catch:{ all -> 0x00b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ab A[Catch:{ all -> 0x00b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ java.lang.Object M(kotlinx.coroutines.channels.ReceiveChannel r8, java.util.Comparator r9, kotlin.coroutines.Continuation r10) {
        /*
            boolean r0 = r10 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$maxWith$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$maxWith$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$maxWith$1) r0
            int r1 = r0.b3
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b3 = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$maxWith$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$maxWith$1
            r0.<init>(r10)
        L_0x0018:
            java.lang.Object r10 = r0.a3
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.b3
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x005f
            if (r2 == r4) goto L_0x004c
            if (r2 != r3) goto L_0x0044
            java.lang.Object r8 = r0.Z2
            java.lang.Object r9 = r0.Y2
            kotlinx.coroutines.channels.ChannelIterator r9 = (kotlinx.coroutines.channels.ChannelIterator) r9
            java.lang.Object r2 = r0.X2
            kotlinx.coroutines.channels.ReceiveChannel r2 = (kotlinx.coroutines.channels.ReceiveChannel) r2
            java.lang.Object r4 = r0.Z
            java.util.Comparator r4 = (java.util.Comparator) r4
            kotlin.ResultKt.n(r10)     // Catch:{ all -> 0x0040 }
            r7 = r0
            r0 = r8
            r8 = r2
        L_0x003d:
            r2 = r7
            goto L_0x00a3
        L_0x0040:
            r8 = move-exception
            r9 = r2
            goto L_0x00c2
        L_0x0044:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x004c:
            java.lang.Object r8 = r0.Y2
            kotlinx.coroutines.channels.ChannelIterator r8 = (kotlinx.coroutines.channels.ChannelIterator) r8
            java.lang.Object r9 = r0.X2
            kotlinx.coroutines.channels.ReceiveChannel r9 = (kotlinx.coroutines.channels.ReceiveChannel) r9
            java.lang.Object r2 = r0.Z
            java.util.Comparator r2 = (java.util.Comparator) r2
            kotlin.ResultKt.n(r10)     // Catch:{ all -> 0x005c }
            goto L_0x007a
        L_0x005c:
            r8 = move-exception
            goto L_0x00c2
        L_0x005f:
            kotlin.ResultKt.n(r10)
            kotlinx.coroutines.channels.ChannelIterator r10 = r8.iterator()     // Catch:{ all -> 0x00b9 }
            r0.Z = r9     // Catch:{ all -> 0x00b9 }
            r0.X2 = r8     // Catch:{ all -> 0x00b9 }
            r0.Y2 = r10     // Catch:{ all -> 0x00b9 }
            r0.b3 = r4     // Catch:{ all -> 0x00b9 }
            java.lang.Object r2 = r10.a(r0)     // Catch:{ all -> 0x00b9 }
            if (r2 != r1) goto L_0x0075
            return r1
        L_0x0075:
            r7 = r9
            r9 = r8
            r8 = r10
            r10 = r2
            r2 = r7
        L_0x007a:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ all -> 0x005c }
            boolean r10 = r10.booleanValue()     // Catch:{ all -> 0x005c }
            if (r10 != 0) goto L_0x0086
            kotlinx.coroutines.channels.ChannelsKt.b(r9, r5)
            return r5
        L_0x0086:
            java.lang.Object r10 = r8.next()     // Catch:{ all -> 0x005c }
            r4 = r2
            r7 = r9
            r9 = r8
            r8 = r7
        L_0x008e:
            r0.Z = r4     // Catch:{ all -> 0x00b9 }
            r0.X2 = r8     // Catch:{ all -> 0x00b9 }
            r0.Y2 = r9     // Catch:{ all -> 0x00b9 }
            r0.Z2 = r10     // Catch:{ all -> 0x00b9 }
            r0.b3 = r3     // Catch:{ all -> 0x00b9 }
            java.lang.Object r2 = r9.a(r0)     // Catch:{ all -> 0x00b9 }
            if (r2 != r1) goto L_0x009f
            return r1
        L_0x009f:
            r7 = r0
            r0 = r10
            r10 = r2
            goto L_0x003d
        L_0x00a3:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ all -> 0x00b9 }
            boolean r10 = r10.booleanValue()     // Catch:{ all -> 0x00b9 }
            if (r10 == 0) goto L_0x00be
            java.lang.Object r10 = r9.next()     // Catch:{ all -> 0x00b9 }
            int r6 = r4.compare(r0, r10)     // Catch:{ all -> 0x00b9 }
            if (r6 >= 0) goto L_0x00b7
        L_0x00b5:
            r0 = r2
            goto L_0x008e
        L_0x00b7:
            r10 = r0
            goto L_0x00b5
        L_0x00b9:
            r9 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
            goto L_0x00c2
        L_0x00be:
            kotlinx.coroutines.channels.ChannelsKt.b(r8, r5)
            return r0
        L_0x00c2:
            throw r8     // Catch:{ all -> 0x00c3 }
        L_0x00c3:
            r10 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.b(r9, r8)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.M(kotlinx.coroutines.channels.ReceiveChannel, java.util.Comparator, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0086 A[SYNTHETIC, Splitter:B:34:0x0086] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x009f A[Catch:{ all -> 0x00b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ab A[Catch:{ all -> 0x00b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ java.lang.Object N(kotlinx.coroutines.channels.ReceiveChannel r8, java.util.Comparator r9, kotlin.coroutines.Continuation r10) {
        /*
            boolean r0 = r10 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$minWith$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$minWith$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$minWith$1) r0
            int r1 = r0.b3
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b3 = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$minWith$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$minWith$1
            r0.<init>(r10)
        L_0x0018:
            java.lang.Object r10 = r0.a3
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.b3
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x005f
            if (r2 == r4) goto L_0x004c
            if (r2 != r3) goto L_0x0044
            java.lang.Object r8 = r0.Z2
            java.lang.Object r9 = r0.Y2
            kotlinx.coroutines.channels.ChannelIterator r9 = (kotlinx.coroutines.channels.ChannelIterator) r9
            java.lang.Object r2 = r0.X2
            kotlinx.coroutines.channels.ReceiveChannel r2 = (kotlinx.coroutines.channels.ReceiveChannel) r2
            java.lang.Object r4 = r0.Z
            java.util.Comparator r4 = (java.util.Comparator) r4
            kotlin.ResultKt.n(r10)     // Catch:{ all -> 0x0040 }
            r7 = r0
            r0 = r8
            r8 = r2
        L_0x003d:
            r2 = r7
            goto L_0x00a3
        L_0x0040:
            r8 = move-exception
            r9 = r2
            goto L_0x00c2
        L_0x0044:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x004c:
            java.lang.Object r8 = r0.Y2
            kotlinx.coroutines.channels.ChannelIterator r8 = (kotlinx.coroutines.channels.ChannelIterator) r8
            java.lang.Object r9 = r0.X2
            kotlinx.coroutines.channels.ReceiveChannel r9 = (kotlinx.coroutines.channels.ReceiveChannel) r9
            java.lang.Object r2 = r0.Z
            java.util.Comparator r2 = (java.util.Comparator) r2
            kotlin.ResultKt.n(r10)     // Catch:{ all -> 0x005c }
            goto L_0x007a
        L_0x005c:
            r8 = move-exception
            goto L_0x00c2
        L_0x005f:
            kotlin.ResultKt.n(r10)
            kotlinx.coroutines.channels.ChannelIterator r10 = r8.iterator()     // Catch:{ all -> 0x00b9 }
            r0.Z = r9     // Catch:{ all -> 0x00b9 }
            r0.X2 = r8     // Catch:{ all -> 0x00b9 }
            r0.Y2 = r10     // Catch:{ all -> 0x00b9 }
            r0.b3 = r4     // Catch:{ all -> 0x00b9 }
            java.lang.Object r2 = r10.a(r0)     // Catch:{ all -> 0x00b9 }
            if (r2 != r1) goto L_0x0075
            return r1
        L_0x0075:
            r7 = r9
            r9 = r8
            r8 = r10
            r10 = r2
            r2 = r7
        L_0x007a:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ all -> 0x005c }
            boolean r10 = r10.booleanValue()     // Catch:{ all -> 0x005c }
            if (r10 != 0) goto L_0x0086
            kotlinx.coroutines.channels.ChannelsKt.b(r9, r5)
            return r5
        L_0x0086:
            java.lang.Object r10 = r8.next()     // Catch:{ all -> 0x005c }
            r4 = r2
            r7 = r9
            r9 = r8
            r8 = r7
        L_0x008e:
            r0.Z = r4     // Catch:{ all -> 0x00b9 }
            r0.X2 = r8     // Catch:{ all -> 0x00b9 }
            r0.Y2 = r9     // Catch:{ all -> 0x00b9 }
            r0.Z2 = r10     // Catch:{ all -> 0x00b9 }
            r0.b3 = r3     // Catch:{ all -> 0x00b9 }
            java.lang.Object r2 = r9.a(r0)     // Catch:{ all -> 0x00b9 }
            if (r2 != r1) goto L_0x009f
            return r1
        L_0x009f:
            r7 = r0
            r0 = r10
            r10 = r2
            goto L_0x003d
        L_0x00a3:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ all -> 0x00b9 }
            boolean r10 = r10.booleanValue()     // Catch:{ all -> 0x00b9 }
            if (r10 == 0) goto L_0x00be
            java.lang.Object r10 = r9.next()     // Catch:{ all -> 0x00b9 }
            int r6 = r4.compare(r0, r10)     // Catch:{ all -> 0x00b9 }
            if (r6 <= 0) goto L_0x00b7
        L_0x00b5:
            r0 = r2
            goto L_0x008e
        L_0x00b7:
            r10 = r0
            goto L_0x00b5
        L_0x00b9:
            r9 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
            goto L_0x00c2
        L_0x00be:
            kotlinx.coroutines.channels.ChannelsKt.b(r8, r5)
            return r0
        L_0x00c2:
            throw r8     // Catch:{ all -> 0x00c3 }
        L_0x00c3:
            r10 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.b(r9, r8)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.N(kotlinx.coroutines.channels.ReceiveChannel, java.util.Comparator, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005b, code lost:
        kotlinx.coroutines.channels.ChannelsKt.b(r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005e, code lost:
        throw r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ java.lang.Object O(kotlinx.coroutines.channels.ReceiveChannel r4, kotlin.coroutines.Continuation r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$none$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$none$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$none$1) r0
            int r1 = r0.Y2
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.Y2 = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$none$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$none$1
            r0.<init>(r5)
        L_0x0018:
            java.lang.Object r5 = r0.X2
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.Y2
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r4 = r0.Z
            kotlinx.coroutines.channels.ReceiveChannel r4 = (kotlinx.coroutines.channels.ReceiveChannel) r4
            kotlin.ResultKt.n(r5)     // Catch:{ all -> 0x002d }
            goto L_0x0049
        L_0x002d:
            r5 = move-exception
            goto L_0x0059
        L_0x002f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0037:
            kotlin.ResultKt.n(r5)
            kotlinx.coroutines.channels.ChannelIterator r5 = r4.iterator()     // Catch:{ all -> 0x002d }
            r0.Z = r4     // Catch:{ all -> 0x002d }
            r0.Y2 = r3     // Catch:{ all -> 0x002d }
            java.lang.Object r5 = r5.a(r0)     // Catch:{ all -> 0x002d }
            if (r5 != r1) goto L_0x0049
            return r1
        L_0x0049:
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch:{ all -> 0x002d }
            boolean r5 = r5.booleanValue()     // Catch:{ all -> 0x002d }
            r5 = r5 ^ r3
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.a(r5)     // Catch:{ all -> 0x002d }
            r0 = 0
            kotlinx.coroutines.channels.ChannelsKt.b(r4, r0)
            return r5
        L_0x0059:
            throw r5     // Catch:{ all -> 0x005a }
        L_0x005a:
            r0 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.b(r4, r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.O(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006c A[Catch:{ all -> 0x004a }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x008e A[SYNTHETIC, Splitter:B:39:0x008e] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0096 A[SYNTHETIC, Splitter:B:42:0x0096] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ java.lang.Object Q(kotlinx.coroutines.channels.ReceiveChannel r6, kotlin.coroutines.Continuation r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$single$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$single$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$single$1) r0
            int r1 = r0.Z2
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.Z2 = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$single$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$single$1
            r0.<init>(r7)
        L_0x0018:
            java.lang.Object r7 = r0.Y2
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.Z2
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x004c
            if (r2 == r4) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            java.lang.Object r6 = r0.X2
            java.lang.Object r0 = r0.Z
            kotlinx.coroutines.channels.ReceiveChannel r0 = (kotlinx.coroutines.channels.ReceiveChannel) r0
            kotlin.ResultKt.n(r7)     // Catch:{ all -> 0x0032 }
            goto L_0x0081
        L_0x0032:
            r6 = move-exception
            r2 = r0
            goto L_0x00a1
        L_0x0036:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003e:
            java.lang.Object r6 = r0.X2
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r2 = r0.Z
            kotlinx.coroutines.channels.ReceiveChannel r2 = (kotlinx.coroutines.channels.ReceiveChannel) r2
            kotlin.ResultKt.n(r7)     // Catch:{ all -> 0x004a }
            goto L_0x0064
        L_0x004a:
            r6 = move-exception
            goto L_0x00a1
        L_0x004c:
            kotlin.ResultKt.n(r7)
            kotlinx.coroutines.channels.ChannelIterator r7 = r6.iterator()     // Catch:{ all -> 0x009e }
            r0.Z = r6     // Catch:{ all -> 0x009e }
            r0.X2 = r7     // Catch:{ all -> 0x009e }
            r0.Z2 = r4     // Catch:{ all -> 0x009e }
            java.lang.Object r2 = r7.a(r0)     // Catch:{ all -> 0x009e }
            if (r2 != r1) goto L_0x0060
            return r1
        L_0x0060:
            r5 = r2
            r2 = r6
            r6 = r7
            r7 = r5
        L_0x0064:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x004a }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x004a }
            if (r7 == 0) goto L_0x0096
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x004a }
            r0.Z = r2     // Catch:{ all -> 0x004a }
            r0.X2 = r7     // Catch:{ all -> 0x004a }
            r0.Z2 = r3     // Catch:{ all -> 0x004a }
            java.lang.Object r6 = r6.a(r0)     // Catch:{ all -> 0x004a }
            if (r6 != r1) goto L_0x007d
            return r1
        L_0x007d:
            r0 = r2
            r5 = r7
            r7 = r6
            r6 = r5
        L_0x0081:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x0032 }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x0032 }
            if (r7 != 0) goto L_0x008e
            r7 = 0
            kotlinx.coroutines.channels.ChannelsKt.b(r0, r7)
            return r6
        L_0x008e:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0032 }
            java.lang.String r7 = "ReceiveChannel has more than one element."
            r6.<init>(r7)     // Catch:{ all -> 0x0032 }
            throw r6     // Catch:{ all -> 0x0032 }
        L_0x0096:
            java.util.NoSuchElementException r6 = new java.util.NoSuchElementException     // Catch:{ all -> 0x004a }
            java.lang.String r7 = "ReceiveChannel is empty."
            r6.<init>(r7)     // Catch:{ all -> 0x004a }
            throw r6     // Catch:{ all -> 0x004a }
        L_0x009e:
            r7 = move-exception
            r2 = r6
            r6 = r7
        L_0x00a1:
            throw r6     // Catch:{ all -> 0x00a2 }
        L_0x00a2:
            r7 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.b(r2, r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.Q(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0070 A[SYNTHETIC, Splitter:B:32:0x0070] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0090 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0091 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ java.lang.Object R(kotlinx.coroutines.channels.ReceiveChannel r7, kotlin.coroutines.Continuation r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$singleOrNull$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$singleOrNull$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$singleOrNull$1) r0
            int r1 = r0.Z2
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.Z2 = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$singleOrNull$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$singleOrNull$1
            r0.<init>(r8)
        L_0x0018:
            java.lang.Object r8 = r0.Y2
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.Z2
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x004c
            if (r2 == r4) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            java.lang.Object r7 = r0.X2
            java.lang.Object r0 = r0.Z
            kotlinx.coroutines.channels.ReceiveChannel r0 = (kotlinx.coroutines.channels.ReceiveChannel) r0
            kotlin.ResultKt.n(r8)     // Catch:{ all -> 0x0033 }
            goto L_0x0085
        L_0x0033:
            r7 = move-exception
            r2 = r0
            goto L_0x0095
        L_0x0036:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003e:
            java.lang.Object r7 = r0.X2
            kotlinx.coroutines.channels.ChannelIterator r7 = (kotlinx.coroutines.channels.ChannelIterator) r7
            java.lang.Object r2 = r0.Z
            kotlinx.coroutines.channels.ReceiveChannel r2 = (kotlinx.coroutines.channels.ReceiveChannel) r2
            kotlin.ResultKt.n(r8)     // Catch:{ all -> 0x004a }
            goto L_0x0064
        L_0x004a:
            r7 = move-exception
            goto L_0x0095
        L_0x004c:
            kotlin.ResultKt.n(r8)
            kotlinx.coroutines.channels.ChannelIterator r8 = r7.iterator()     // Catch:{ all -> 0x0092 }
            r0.Z = r7     // Catch:{ all -> 0x0092 }
            r0.X2 = r8     // Catch:{ all -> 0x0092 }
            r0.Z2 = r4     // Catch:{ all -> 0x0092 }
            java.lang.Object r2 = r8.a(r0)     // Catch:{ all -> 0x0092 }
            if (r2 != r1) goto L_0x0060
            return r1
        L_0x0060:
            r6 = r2
            r2 = r7
            r7 = r8
            r8 = r6
        L_0x0064:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x004a }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x004a }
            if (r8 != 0) goto L_0x0070
            kotlinx.coroutines.channels.ChannelsKt.b(r2, r5)
            return r5
        L_0x0070:
            java.lang.Object r8 = r7.next()     // Catch:{ all -> 0x004a }
            r0.Z = r2     // Catch:{ all -> 0x004a }
            r0.X2 = r8     // Catch:{ all -> 0x004a }
            r0.Z2 = r3     // Catch:{ all -> 0x004a }
            java.lang.Object r7 = r7.a(r0)     // Catch:{ all -> 0x004a }
            if (r7 != r1) goto L_0x0081
            return r1
        L_0x0081:
            r0 = r2
            r6 = r8
            r8 = r7
            r7 = r6
        L_0x0085:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x0033 }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x0033 }
            kotlinx.coroutines.channels.ChannelsKt.b(r0, r5)
            if (r8 == 0) goto L_0x0091
            return r5
        L_0x0091:
            return r7
        L_0x0092:
            r8 = move-exception
            r2 = r7
            r7 = r8
        L_0x0095:
            throw r7     // Catch:{ all -> 0x0096 }
        L_0x0096:
            r8 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.b(r2, r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.R(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ ReceiveChannel T(ReceiveChannel receiveChannel, int i2, CoroutineContext coroutineContext, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            coroutineContext = Dispatchers.g();
        }
        return ProduceKt.g(GlobalScope.s, coroutineContext, 0, (CoroutineStart) null, ChannelsKt.g(receiveChannel), new ChannelsKt__DeprecatedKt$take$1(i2, receiveChannel, (Continuation<? super ChannelsKt__DeprecatedKt$take$1>) null), 6, (Object) null);
    }

    public static /* synthetic */ ReceiveChannel V(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            coroutineContext = Dispatchers.g();
        }
        return ProduceKt.g(GlobalScope.s, coroutineContext, 0, (CoroutineStart) null, ChannelsKt.g(receiveChannel), new ChannelsKt__DeprecatedKt$takeWhile$1(receiveChannel, function2, (Continuation<? super ChannelsKt__DeprecatedKt$takeWhile$1>) null), 6, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0078 A[Catch:{ all -> 0x003b }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    @kotlin.PublishedApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E, C extends kotlinx.coroutines.channels.SendChannel<? super E>> java.lang.Object W(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r6, @org.jetbrains.annotations.NotNull C r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super C> r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toChannel$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toChannel$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toChannel$1) r0
            int r1 = r0.a3
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.a3 = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toChannel$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toChannel$1
            r0.<init>(r8)
        L_0x0018:
            java.lang.Object r8 = r0.Z2
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.a3
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0055
            if (r2 == r4) goto L_0x0045
            if (r2 != r3) goto L_0x003d
            java.lang.Object r6 = r0.Y2
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r0.X2
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r2 = r0.Z
            kotlinx.coroutines.channels.SendChannel r2 = (kotlinx.coroutines.channels.SendChannel) r2
            kotlin.ResultKt.n(r8)     // Catch:{ all -> 0x003b }
        L_0x0037:
            r8 = r6
            r6 = r7
            r7 = r2
            goto L_0x005c
        L_0x003b:
            r6 = move-exception
            goto L_0x0096
        L_0x003d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0045:
            java.lang.Object r6 = r0.Y2
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r0.X2
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r2 = r0.Z
            kotlinx.coroutines.channels.SendChannel r2 = (kotlinx.coroutines.channels.SendChannel) r2
            kotlin.ResultKt.n(r8)     // Catch:{ all -> 0x003b }
            goto L_0x0070
        L_0x0055:
            kotlin.ResultKt.n(r8)
            kotlinx.coroutines.channels.ChannelIterator r8 = r6.iterator()     // Catch:{ all -> 0x0092 }
        L_0x005c:
            r0.Z = r7     // Catch:{ all -> 0x0092 }
            r0.X2 = r6     // Catch:{ all -> 0x0092 }
            r0.Y2 = r8     // Catch:{ all -> 0x0092 }
            r0.a3 = r4     // Catch:{ all -> 0x0092 }
            java.lang.Object r2 = r8.a(r0)     // Catch:{ all -> 0x0092 }
            if (r2 != r1) goto L_0x006b
            return r1
        L_0x006b:
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r2
            r2 = r5
        L_0x0070:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x003b }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x003b }
            if (r8 == 0) goto L_0x008b
            java.lang.Object r8 = r6.next()     // Catch:{ all -> 0x003b }
            r0.Z = r2     // Catch:{ all -> 0x003b }
            r0.X2 = r7     // Catch:{ all -> 0x003b }
            r0.Y2 = r6     // Catch:{ all -> 0x003b }
            r0.a3 = r3     // Catch:{ all -> 0x003b }
            java.lang.Object r8 = r2.g0(r8, r0)     // Catch:{ all -> 0x003b }
            if (r8 != r1) goto L_0x0037
            return r1
        L_0x008b:
            kotlin.Unit r6 = kotlin.Unit.f28779a     // Catch:{ all -> 0x003b }
            r6 = 0
            kotlinx.coroutines.channels.ChannelsKt.b(r7, r6)
            return r2
        L_0x0092:
            r7 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
        L_0x0096:
            throw r6     // Catch:{ all -> 0x0097 }
        L_0x0097:
            r8 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.b(r7, r6)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.W(kotlinx.coroutines.channels.ReceiveChannel, kotlinx.coroutines.channels.SendChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0059 A[Catch:{ all -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0064 A[Catch:{ all -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    @kotlin.PublishedApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E, C extends java.util.Collection<? super E>> java.lang.Object X(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r5, @org.jetbrains.annotations.NotNull C r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super C> r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toCollection$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toCollection$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toCollection$1) r0
            int r1 = r0.a3
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.a3 = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toCollection$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toCollection$1
            r0.<init>(r7)
        L_0x0018:
            java.lang.Object r7 = r0.Z2
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.a3
            r3 = 1
            if (r2 == 0) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            java.lang.Object r5 = r0.Y2
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r6 = r0.X2
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r2 = r0.Z
            java.util.Collection r2 = (java.util.Collection) r2
            kotlin.ResultKt.n(r7)     // Catch:{ all -> 0x0035 }
            goto L_0x005c
        L_0x0035:
            r5 = move-exception
            goto L_0x0078
        L_0x0037:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003f:
            kotlin.ResultKt.n(r7)
            kotlinx.coroutines.channels.ChannelIterator r7 = r5.iterator()     // Catch:{ all -> 0x0074 }
            r4 = r6
            r6 = r5
            r5 = r7
            r7 = r4
        L_0x004a:
            r0.Z = r7     // Catch:{ all -> 0x0035 }
            r0.X2 = r6     // Catch:{ all -> 0x0035 }
            r0.Y2 = r5     // Catch:{ all -> 0x0035 }
            r0.a3 = r3     // Catch:{ all -> 0x0035 }
            java.lang.Object r2 = r5.a(r0)     // Catch:{ all -> 0x0035 }
            if (r2 != r1) goto L_0x0059
            return r1
        L_0x0059:
            r4 = r2
            r2 = r7
            r7 = r4
        L_0x005c:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x0035 }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x0035 }
            if (r7 == 0) goto L_0x006d
            java.lang.Object r7 = r5.next()     // Catch:{ all -> 0x0035 }
            r2.add(r7)     // Catch:{ all -> 0x0035 }
            r7 = r2
            goto L_0x004a
        L_0x006d:
            kotlin.Unit r5 = kotlin.Unit.f28779a     // Catch:{ all -> 0x0035 }
            r5 = 0
            kotlinx.coroutines.channels.ChannelsKt.b(r6, r5)
            return r2
        L_0x0074:
            r6 = move-exception
            r4 = r6
            r6 = r5
            r5 = r4
        L_0x0078:
            throw r5     // Catch:{ all -> 0x0079 }
        L_0x0079:
            r7 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.b(r6, r5)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.X(kotlinx.coroutines.channels.ReceiveChannel, java.util.Collection, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0059 A[Catch:{ all -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0064 A[Catch:{ all -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    @kotlin.PublishedApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <K, V, M extends java.util.Map<? super K, ? super V>> java.lang.Object Y(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends kotlin.Pair<? extends K, ? extends V>> r6, @org.jetbrains.annotations.NotNull M r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super M> r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toMap$2
            if (r0 == 0) goto L_0x0013
            r0 = r8
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toMap$2 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toMap$2) r0
            int r1 = r0.a3
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.a3 = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toMap$2 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toMap$2
            r0.<init>(r8)
        L_0x0018:
            java.lang.Object r8 = r0.Z2
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.a3
            r3 = 1
            if (r2 == 0) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            java.lang.Object r6 = r0.Y2
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r0.X2
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r2 = r0.Z
            java.util.Map r2 = (java.util.Map) r2
            kotlin.ResultKt.n(r8)     // Catch:{ all -> 0x0035 }
            goto L_0x005c
        L_0x0035:
            r6 = move-exception
            goto L_0x0082
        L_0x0037:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003f:
            kotlin.ResultKt.n(r8)
            kotlinx.coroutines.channels.ChannelIterator r8 = r6.iterator()     // Catch:{ all -> 0x007e }
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L_0x004a:
            r0.Z = r8     // Catch:{ all -> 0x0035 }
            r0.X2 = r7     // Catch:{ all -> 0x0035 }
            r0.Y2 = r6     // Catch:{ all -> 0x0035 }
            r0.a3 = r3     // Catch:{ all -> 0x0035 }
            java.lang.Object r2 = r6.a(r0)     // Catch:{ all -> 0x0035 }
            if (r2 != r1) goto L_0x0059
            return r1
        L_0x0059:
            r5 = r2
            r2 = r8
            r8 = r5
        L_0x005c:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x0035 }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x0035 }
            if (r8 == 0) goto L_0x0077
            java.lang.Object r8 = r6.next()     // Catch:{ all -> 0x0035 }
            kotlin.Pair r8 = (kotlin.Pair) r8     // Catch:{ all -> 0x0035 }
            java.lang.Object r4 = r8.e()     // Catch:{ all -> 0x0035 }
            java.lang.Object r8 = r8.f()     // Catch:{ all -> 0x0035 }
            r2.put(r4, r8)     // Catch:{ all -> 0x0035 }
            r8 = r2
            goto L_0x004a
        L_0x0077:
            kotlin.Unit r6 = kotlin.Unit.f28779a     // Catch:{ all -> 0x0035 }
            r6 = 0
            kotlinx.coroutines.channels.ChannelsKt.b(r7, r6)
            return r2
        L_0x007e:
            r7 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
        L_0x0082:
            throw r6     // Catch:{ all -> 0x0083 }
        L_0x0083:
            r8 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.b(r7, r6)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.Y(kotlinx.coroutines.channels.ReceiveChannel, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0050, code lost:
        kotlinx.coroutines.channels.ChannelsKt.b(r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0053, code lost:
        throw r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ java.lang.Object a(kotlinx.coroutines.channels.ReceiveChannel r4, kotlin.coroutines.Continuation r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$any$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$any$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$any$1) r0
            int r1 = r0.Y2
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.Y2 = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$any$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$any$1
            r0.<init>(r5)
        L_0x0018:
            java.lang.Object r5 = r0.X2
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.Y2
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r4 = r0.Z
            kotlinx.coroutines.channels.ReceiveChannel r4 = (kotlinx.coroutines.channels.ReceiveChannel) r4
            kotlin.ResultKt.n(r5)     // Catch:{ all -> 0x002d }
            goto L_0x0049
        L_0x002d:
            r5 = move-exception
            goto L_0x004e
        L_0x002f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0037:
            kotlin.ResultKt.n(r5)
            kotlinx.coroutines.channels.ChannelIterator r5 = r4.iterator()     // Catch:{ all -> 0x002d }
            r0.Z = r4     // Catch:{ all -> 0x002d }
            r0.Y2 = r3     // Catch:{ all -> 0x002d }
            java.lang.Object r5 = r5.a(r0)     // Catch:{ all -> 0x002d }
            if (r5 != r1) goto L_0x0049
            return r1
        L_0x0049:
            r0 = 0
            kotlinx.coroutines.channels.ChannelsKt.b(r4, r0)
            return r5
        L_0x004e:
            throw r5     // Catch:{ all -> 0x004f }
        L_0x004f:
            r0 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.b(r4, r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.a(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @NotNull
    @PublishedApi
    public static final Function1<Throwable, Unit> b(@NotNull ReceiveChannel<?> receiveChannel) {
        return new ChannelsKt__DeprecatedKt$consumes$1(receiveChannel);
    }

    @Nullable
    @PublishedApi
    public static final <E> Object b0(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Continuation<? super Set<E>> continuation) {
        return ChannelsKt.f0(receiveChannel, new LinkedHashSet(), continuation);
    }

    @NotNull
    @PublishedApi
    public static final Function1<Throwable, Unit> c(@NotNull ReceiveChannel<?>... receiveChannelArr) {
        return new ChannelsKt__DeprecatedKt$consumesAll$1(receiveChannelArr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0068 A[Catch:{ all -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ java.lang.Object d(kotlinx.coroutines.channels.ReceiveChannel r6, kotlin.coroutines.Continuation r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$count$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$count$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$count$1) r0
            int r1 = r0.a3
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.a3 = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$count$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$count$1
            r0.<init>(r7)
        L_0x0018:
            java.lang.Object r7 = r0.Z2
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.a3
            r3 = 1
            if (r2 == 0) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            java.lang.Object r6 = r0.Y2
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r2 = r0.X2
            kotlinx.coroutines.channels.ReceiveChannel r2 = (kotlinx.coroutines.channels.ReceiveChannel) r2
            java.lang.Object r4 = r0.Z
            kotlin.jvm.internal.Ref$IntRef r4 = (kotlin.jvm.internal.Ref.IntRef) r4
            kotlin.ResultKt.n(r7)     // Catch:{ all -> 0x0035 }
            goto L_0x0060
        L_0x0035:
            r6 = move-exception
            goto L_0x0085
        L_0x0037:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003f:
            kotlin.ResultKt.n(r7)
            kotlin.jvm.internal.Ref$IntRef r7 = new kotlin.jvm.internal.Ref$IntRef
            r7.<init>()
            kotlinx.coroutines.channels.ChannelIterator r2 = r6.iterator()     // Catch:{ all -> 0x0082 }
            r4 = r7
            r7 = r6
            r6 = r2
        L_0x004e:
            r0.Z = r4     // Catch:{ all -> 0x007f }
            r0.X2 = r7     // Catch:{ all -> 0x007f }
            r0.Y2 = r6     // Catch:{ all -> 0x007f }
            r0.a3 = r3     // Catch:{ all -> 0x007f }
            java.lang.Object r2 = r6.a(r0)     // Catch:{ all -> 0x007f }
            if (r2 != r1) goto L_0x005d
            return r1
        L_0x005d:
            r5 = r2
            r2 = r7
            r7 = r5
        L_0x0060:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x0035 }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x0035 }
            if (r7 == 0) goto L_0x0072
            r6.next()     // Catch:{ all -> 0x0035 }
            int r7 = r4.s     // Catch:{ all -> 0x0035 }
            int r7 = r7 + r3
            r4.s = r7     // Catch:{ all -> 0x0035 }
            r7 = r2
            goto L_0x004e
        L_0x0072:
            kotlin.Unit r6 = kotlin.Unit.f28779a     // Catch:{ all -> 0x0035 }
            r6 = 0
            kotlinx.coroutines.channels.ChannelsKt.b(r2, r6)
            int r6 = r4.s
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.f(r6)
            return r6
        L_0x007f:
            r6 = move-exception
            r2 = r7
            goto L_0x0085
        L_0x0082:
            r7 = move-exception
            r2 = r6
            r6 = r7
        L_0x0085:
            throw r6     // Catch:{ all -> 0x0086 }
        L_0x0086:
            r7 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.b(r2, r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.d(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ ReceiveChannel e0(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            coroutineContext = Dispatchers.g();
        }
        return ProduceKt.g(GlobalScope.s, coroutineContext, 0, (CoroutineStart) null, ChannelsKt.g(receiveChannel), new ChannelsKt__DeprecatedKt$withIndex$1(receiveChannel, (Continuation<? super ChannelsKt__DeprecatedKt$withIndex$1>) null), 6, (Object) null);
    }

    @NotNull
    @PublishedApi
    public static final <E, K> ReceiveChannel<E> f(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull CoroutineContext coroutineContext, @NotNull Function2<? super E, ? super Continuation<? super K>, ? extends Object> function2) {
        return ProduceKt.g(GlobalScope.s, coroutineContext, 0, (CoroutineStart) null, ChannelsKt.g(receiveChannel), new ChannelsKt__DeprecatedKt$distinctBy$1(receiveChannel, function2, (Continuation<? super ChannelsKt__DeprecatedKt$distinctBy$1>) null), 6, (Object) null);
    }

    public static /* synthetic */ ReceiveChannel g(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            coroutineContext = Dispatchers.g();
        }
        return ChannelsKt.k(receiveChannel, coroutineContext, function2);
    }

    @NotNull
    @PublishedApi
    public static final <E, R, V> ReceiveChannel<V> g0(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull ReceiveChannel<? extends R> receiveChannel2, @NotNull CoroutineContext coroutineContext, @NotNull Function2<? super E, ? super R, ? extends V> function2) {
        return ProduceKt.g(GlobalScope.s, coroutineContext, 0, (CoroutineStart) null, ChannelsKt.h(receiveChannel, receiveChannel2), new ChannelsKt__DeprecatedKt$zip$2(receiveChannel2, receiveChannel, function2, (Continuation<? super ChannelsKt__DeprecatedKt$zip$2>) null), 6, (Object) null);
    }

    public static /* synthetic */ ReceiveChannel h0(ReceiveChannel receiveChannel, ReceiveChannel receiveChannel2, CoroutineContext coroutineContext, Function2 function2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            coroutineContext = Dispatchers.g();
        }
        return ChannelsKt.q0(receiveChannel, receiveChannel2, coroutineContext, function2);
    }

    public static /* synthetic */ ReceiveChannel i(ReceiveChannel receiveChannel, int i2, CoroutineContext coroutineContext, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            coroutineContext = Dispatchers.g();
        }
        return ProduceKt.g(GlobalScope.s, coroutineContext, 0, (CoroutineStart) null, ChannelsKt.g(receiveChannel), new ChannelsKt__DeprecatedKt$drop$1(i2, receiveChannel, (Continuation<? super ChannelsKt__DeprecatedKt$drop$1>) null), 6, (Object) null);
    }

    public static /* synthetic */ ReceiveChannel k(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            coroutineContext = Dispatchers.g();
        }
        return ProduceKt.g(GlobalScope.s, coroutineContext, 0, (CoroutineStart) null, ChannelsKt.g(receiveChannel), new ChannelsKt__DeprecatedKt$dropWhile$1(receiveChannel, function2, (Continuation<? super ChannelsKt__DeprecatedKt$dropWhile$1>) null), 6, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006c A[Catch:{ all -> 0x0039 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ java.lang.Object l(kotlinx.coroutines.channels.ReceiveChannel r9, int r10, kotlin.coroutines.Continuation r11) {
        /*
            boolean r0 = r11 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$elementAt$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$elementAt$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$elementAt$1) r0
            int r1 = r0.b3
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b3 = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$elementAt$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$elementAt$1
            r0.<init>(r11)
        L_0x0018:
            java.lang.Object r11 = r0.a3
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.b3
            r3 = 46
            java.lang.String r4 = "ReceiveChannel doesn't contain element at index "
            r5 = 1
            if (r2 == 0) goto L_0x0044
            if (r2 != r5) goto L_0x003c
            int r9 = r0.X2
            int r10 = r0.Z
            java.lang.Object r2 = r0.Z2
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            java.lang.Object r6 = r0.Y2
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            kotlin.ResultKt.n(r11)     // Catch:{ all -> 0x0039 }
            goto L_0x0064
        L_0x0039:
            r9 = move-exception
            goto L_0x00b1
        L_0x003c:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0044:
            kotlin.ResultKt.n(r11)
            if (r10 < 0) goto L_0x0099
            kotlinx.coroutines.channels.ChannelIterator r11 = r9.iterator()     // Catch:{ all -> 0x0095 }
            r2 = 0
        L_0x004e:
            r0.Y2 = r9     // Catch:{ all -> 0x0095 }
            r0.Z2 = r11     // Catch:{ all -> 0x0095 }
            r0.Z = r10     // Catch:{ all -> 0x0095 }
            r0.X2 = r2     // Catch:{ all -> 0x0095 }
            r0.b3 = r5     // Catch:{ all -> 0x0095 }
            java.lang.Object r6 = r11.a(r0)     // Catch:{ all -> 0x0095 }
            if (r6 != r1) goto L_0x005f
            return r1
        L_0x005f:
            r8 = r6
            r6 = r9
            r9 = r2
            r2 = r11
            r11 = r8
        L_0x0064:
            java.lang.Boolean r11 = (java.lang.Boolean) r11     // Catch:{ all -> 0x0039 }
            boolean r11 = r11.booleanValue()     // Catch:{ all -> 0x0039 }
            if (r11 == 0) goto L_0x007d
            java.lang.Object r11 = r2.next()     // Catch:{ all -> 0x0039 }
            int r7 = r9 + 1
            if (r10 != r9) goto L_0x0079
            r9 = 0
            kotlinx.coroutines.channels.ChannelsKt.b(r6, r9)
            return r11
        L_0x0079:
            r11 = r2
            r9 = r6
            r2 = r7
            goto L_0x004e
        L_0x007d:
            java.lang.IndexOutOfBoundsException r9 = new java.lang.IndexOutOfBoundsException     // Catch:{ all -> 0x0039 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0039 }
            r11.<init>()     // Catch:{ all -> 0x0039 }
            r11.append(r4)     // Catch:{ all -> 0x0039 }
            r11.append(r10)     // Catch:{ all -> 0x0039 }
            r11.append(r3)     // Catch:{ all -> 0x0039 }
            java.lang.String r10 = r11.toString()     // Catch:{ all -> 0x0039 }
            r9.<init>(r10)     // Catch:{ all -> 0x0039 }
            throw r9     // Catch:{ all -> 0x0039 }
        L_0x0095:
            r10 = move-exception
            r6 = r9
            r9 = r10
            goto L_0x00b1
        L_0x0099:
            java.lang.IndexOutOfBoundsException r11 = new java.lang.IndexOutOfBoundsException     // Catch:{ all -> 0x0095 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0095 }
            r0.<init>()     // Catch:{ all -> 0x0095 }
            r0.append(r4)     // Catch:{ all -> 0x0095 }
            r0.append(r10)     // Catch:{ all -> 0x0095 }
            r0.append(r3)     // Catch:{ all -> 0x0095 }
            java.lang.String r10 = r0.toString()     // Catch:{ all -> 0x0095 }
            r11.<init>(r10)     // Catch:{ all -> 0x0095 }
            throw r11     // Catch:{ all -> 0x0095 }
        L_0x00b1:
            throw r9     // Catch:{ all -> 0x00b2 }
        L_0x00b2:
            r10 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.b(r6, r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.l(kotlinx.coroutines.channels.ReceiveChannel, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0064 A[Catch:{ all -> 0x0080 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0070 A[Catch:{ all -> 0x0080 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ java.lang.Object m(kotlinx.coroutines.channels.ReceiveChannel r8, int r9, kotlin.coroutines.Continuation r10) {
        /*
            boolean r0 = r10 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$elementAtOrNull$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$elementAtOrNull$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$elementAtOrNull$1) r0
            int r1 = r0.b3
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b3 = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$elementAtOrNull$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$elementAtOrNull$1
            r0.<init>(r10)
        L_0x0018:
            java.lang.Object r10 = r0.a3
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.b3
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0045
            if (r2 != r3) goto L_0x003d
            int r8 = r0.X2
            int r9 = r0.Z
            java.lang.Object r2 = r0.Z2
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            java.lang.Object r5 = r0.Y2
            kotlinx.coroutines.channels.ReceiveChannel r5 = (kotlinx.coroutines.channels.ReceiveChannel) r5
            kotlin.ResultKt.n(r10)     // Catch:{ all -> 0x003b }
            r7 = r2
            r2 = r8
            r8 = r5
            r5 = r0
            r0 = r7
            goto L_0x0068
        L_0x003b:
            r8 = move-exception
            goto L_0x0088
        L_0x003d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0045:
            kotlin.ResultKt.n(r10)
            if (r9 >= 0) goto L_0x004e
            kotlinx.coroutines.channels.ChannelsKt.b(r8, r4)
            return r4
        L_0x004e:
            kotlinx.coroutines.channels.ChannelIterator r10 = r8.iterator()     // Catch:{ all -> 0x0080 }
            r2 = 0
        L_0x0053:
            r0.Y2 = r8     // Catch:{ all -> 0x0080 }
            r0.Z2 = r10     // Catch:{ all -> 0x0080 }
            r0.Z = r9     // Catch:{ all -> 0x0080 }
            r0.X2 = r2     // Catch:{ all -> 0x0080 }
            r0.b3 = r3     // Catch:{ all -> 0x0080 }
            java.lang.Object r5 = r10.a(r0)     // Catch:{ all -> 0x0080 }
            if (r5 != r1) goto L_0x0064
            return r1
        L_0x0064:
            r7 = r0
            r0 = r10
            r10 = r5
            r5 = r7
        L_0x0068:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ all -> 0x0080 }
            boolean r10 = r10.booleanValue()     // Catch:{ all -> 0x0080 }
            if (r10 == 0) goto L_0x0084
            java.lang.Object r10 = r0.next()     // Catch:{ all -> 0x0080 }
            int r6 = r2 + 1
            if (r9 != r2) goto L_0x007c
            kotlinx.coroutines.channels.ChannelsKt.b(r8, r4)
            return r10
        L_0x007c:
            r10 = r0
            r0 = r5
            r2 = r6
            goto L_0x0053
        L_0x0080:
            r9 = move-exception
            r5 = r8
            r8 = r9
            goto L_0x0088
        L_0x0084:
            kotlinx.coroutines.channels.ChannelsKt.b(r8, r4)
            return r4
        L_0x0088:
            throw r8     // Catch:{ all -> 0x0089 }
        L_0x0089:
            r9 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.b(r5, r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.m(kotlinx.coroutines.channels.ReceiveChannel, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @NotNull
    @PublishedApi
    public static final <E> ReceiveChannel<E> n(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull CoroutineContext coroutineContext, @NotNull Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return ProduceKt.g(GlobalScope.s, coroutineContext, 0, (CoroutineStart) null, ChannelsKt.g(receiveChannel), new ChannelsKt__DeprecatedKt$filter$1(receiveChannel, function2, (Continuation<? super ChannelsKt__DeprecatedKt$filter$1>) null), 6, (Object) null);
    }

    public static /* synthetic */ ReceiveChannel o(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            coroutineContext = Dispatchers.g();
        }
        return ChannelsKt.s(receiveChannel, coroutineContext, function2);
    }

    public static /* synthetic */ ReceiveChannel q(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            coroutineContext = Dispatchers.g();
        }
        return ProduceKt.g(GlobalScope.s, coroutineContext, 0, (CoroutineStart) null, ChannelsKt.g(receiveChannel), new ChannelsKt__DeprecatedKt$filterIndexed$1(receiveChannel, function3, (Continuation<? super ChannelsKt__DeprecatedKt$filterIndexed$1>) null), 6, (Object) null);
    }

    public static /* synthetic */ ReceiveChannel s(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            coroutineContext = Dispatchers.g();
        }
        return ChannelsKt.s(receiveChannel, coroutineContext, new ChannelsKt__DeprecatedKt$filterNot$1(function2, (Continuation<? super ChannelsKt__DeprecatedKt$filterNot$1>) null));
    }

    @NotNull
    @PublishedApi
    public static final <E> ReceiveChannel<E> t(@NotNull ReceiveChannel<? extends E> receiveChannel) {
        return o(receiveChannel, (CoroutineContext) null, new ChannelsKt__DeprecatedKt$filterNotNull$1((Continuation<? super ChannelsKt__DeprecatedKt$filterNotNull$1>) null), 1, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0059 A[Catch:{ all -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0064 A[Catch:{ all -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006f A[Catch:{ all -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ java.lang.Object u(kotlinx.coroutines.channels.ReceiveChannel r5, java.util.Collection r6, kotlin.coroutines.Continuation r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$1) r0
            int r1 = r0.a3
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.a3 = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$1
            r0.<init>(r7)
        L_0x0018:
            java.lang.Object r7 = r0.Z2
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.a3
            r3 = 1
            if (r2 == 0) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            java.lang.Object r5 = r0.Y2
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r6 = r0.X2
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r2 = r0.Z
            java.util.Collection r2 = (java.util.Collection) r2
            kotlin.ResultKt.n(r7)     // Catch:{ all -> 0x0035 }
            goto L_0x005c
        L_0x0035:
            r5 = move-exception
            goto L_0x007a
        L_0x0037:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003f:
            kotlin.ResultKt.n(r7)
            kotlinx.coroutines.channels.ChannelIterator r7 = r5.iterator()     // Catch:{ all -> 0x0076 }
            r4 = r6
            r6 = r5
            r5 = r7
            r7 = r4
        L_0x004a:
            r0.Z = r7     // Catch:{ all -> 0x0035 }
            r0.X2 = r6     // Catch:{ all -> 0x0035 }
            r0.Y2 = r5     // Catch:{ all -> 0x0035 }
            r0.a3 = r3     // Catch:{ all -> 0x0035 }
            java.lang.Object r2 = r5.a(r0)     // Catch:{ all -> 0x0035 }
            if (r2 != r1) goto L_0x0059
            return r1
        L_0x0059:
            r4 = r2
            r2 = r7
            r7 = r4
        L_0x005c:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x0035 }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x0035 }
            if (r7 == 0) goto L_0x006f
            java.lang.Object r7 = r5.next()     // Catch:{ all -> 0x0035 }
            if (r7 == 0) goto L_0x006d
            r2.add(r7)     // Catch:{ all -> 0x0035 }
        L_0x006d:
            r7 = r2
            goto L_0x004a
        L_0x006f:
            kotlin.Unit r5 = kotlin.Unit.f28779a     // Catch:{ all -> 0x0035 }
            r5 = 0
            kotlinx.coroutines.channels.ChannelsKt.b(r6, r5)
            return r2
        L_0x0076:
            r6 = move-exception
            r4 = r6
            r6 = r5
            r5 = r4
        L_0x007a:
            throw r5     // Catch:{ all -> 0x007b }
        L_0x007b:
            r7 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.b(r6, r5)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.u(kotlinx.coroutines.channels.ReceiveChannel, java.util.Collection, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0070 A[Catch:{ all -> 0x0092 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0071 A[Catch:{ all -> 0x0092 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007d A[Catch:{ all -> 0x0092 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x009a A[Catch:{ all -> 0x0092 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ java.lang.Object v(kotlinx.coroutines.channels.ReceiveChannel r6, kotlinx.coroutines.channels.SendChannel r7, kotlin.coroutines.Continuation r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$3
            if (r0 == 0) goto L_0x0013
            r0 = r8
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$3 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$3) r0
            int r1 = r0.a3
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.a3 = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$3 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$3
            r0.<init>(r8)
        L_0x0018:
            java.lang.Object r8 = r0.Z2
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.a3
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x005b
            if (r2 == r4) goto L_0x0046
            if (r2 != r3) goto L_0x003e
            java.lang.Object r6 = r0.Y2
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r0.X2
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r2 = r0.Z
            kotlinx.coroutines.channels.SendChannel r2 = (kotlinx.coroutines.channels.SendChannel) r2
            kotlin.ResultKt.n(r8)     // Catch:{ all -> 0x003b }
            r8 = r6
            r6 = r7
            r7 = r2
            goto L_0x0062
        L_0x003b:
            r6 = move-exception
            goto L_0x00a1
        L_0x003e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0046:
            java.lang.Object r6 = r0.Y2
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r0.X2
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r2 = r0.Z
            kotlinx.coroutines.channels.SendChannel r2 = (kotlinx.coroutines.channels.SendChannel) r2
            kotlin.ResultKt.n(r8)     // Catch:{ all -> 0x003b }
            r5 = r0
            r0 = r6
            r6 = r7
            r7 = r2
        L_0x0059:
            r2 = r5
            goto L_0x0075
        L_0x005b:
            kotlin.ResultKt.n(r8)
            kotlinx.coroutines.channels.ChannelIterator r8 = r6.iterator()     // Catch:{ all -> 0x0092 }
        L_0x0062:
            r0.Z = r7     // Catch:{ all -> 0x0092 }
            r0.X2 = r6     // Catch:{ all -> 0x0092 }
            r0.Y2 = r8     // Catch:{ all -> 0x0092 }
            r0.a3 = r4     // Catch:{ all -> 0x0092 }
            java.lang.Object r2 = r8.a(r0)     // Catch:{ all -> 0x0092 }
            if (r2 != r1) goto L_0x0071
            return r1
        L_0x0071:
            r5 = r0
            r0 = r8
            r8 = r2
            goto L_0x0059
        L_0x0075:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x0092 }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x0092 }
            if (r8 == 0) goto L_0x009a
            java.lang.Object r8 = r0.next()     // Catch:{ all -> 0x0092 }
            if (r8 == 0) goto L_0x0097
            r2.Z = r7     // Catch:{ all -> 0x0092 }
            r2.X2 = r6     // Catch:{ all -> 0x0092 }
            r2.Y2 = r0     // Catch:{ all -> 0x0092 }
            r2.a3 = r3     // Catch:{ all -> 0x0092 }
            java.lang.Object r8 = r7.g0(r8, r2)     // Catch:{ all -> 0x0092 }
            if (r8 != r1) goto L_0x0097
            return r1
        L_0x0092:
            r7 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
            goto L_0x00a1
        L_0x0097:
            r8 = r0
            r0 = r2
            goto L_0x0062
        L_0x009a:
            kotlin.Unit r8 = kotlin.Unit.f28779a     // Catch:{ all -> 0x0092 }
            r8 = 0
            kotlinx.coroutines.channels.ChannelsKt.b(r6, r8)
            return r7
        L_0x00a1:
            throw r6     // Catch:{ all -> 0x00a2 }
        L_0x00a2:
            r8 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.b(r7, r6)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.v(kotlinx.coroutines.channels.ReceiveChannel, kotlinx.coroutines.channels.SendChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005b A[Catch:{ all -> 0x0031 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0064 A[SYNTHETIC, Splitter:B:27:0x0064] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ java.lang.Object w(kotlinx.coroutines.channels.ReceiveChannel r5, kotlin.coroutines.Continuation r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$first$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$first$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$first$1) r0
            int r1 = r0.Z2
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.Z2 = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$first$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$first$1
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.Y2
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.Z2
            r3 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r5 = r0.X2
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r0 = r0.Z
            kotlinx.coroutines.channels.ReceiveChannel r0 = (kotlinx.coroutines.channels.ReceiveChannel) r0
            kotlin.ResultKt.n(r6)     // Catch:{ all -> 0x0031 }
            goto L_0x0053
        L_0x0031:
            r5 = move-exception
            goto L_0x006f
        L_0x0033:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003b:
            kotlin.ResultKt.n(r6)
            kotlinx.coroutines.channels.ChannelIterator r6 = r5.iterator()     // Catch:{ all -> 0x006c }
            r0.Z = r5     // Catch:{ all -> 0x006c }
            r0.X2 = r6     // Catch:{ all -> 0x006c }
            r0.Z2 = r3     // Catch:{ all -> 0x006c }
            java.lang.Object r0 = r6.a(r0)     // Catch:{ all -> 0x006c }
            if (r0 != r1) goto L_0x004f
            return r1
        L_0x004f:
            r4 = r0
            r0 = r5
            r5 = r6
            r6 = r4
        L_0x0053:
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ all -> 0x0031 }
            boolean r6 = r6.booleanValue()     // Catch:{ all -> 0x0031 }
            if (r6 == 0) goto L_0x0064
            java.lang.Object r5 = r5.next()     // Catch:{ all -> 0x0031 }
            r6 = 0
            kotlinx.coroutines.channels.ChannelsKt.b(r0, r6)
            return r5
        L_0x0064:
            java.util.NoSuchElementException r5 = new java.util.NoSuchElementException     // Catch:{ all -> 0x0031 }
            java.lang.String r6 = "ReceiveChannel is empty."
            r5.<init>(r6)     // Catch:{ all -> 0x0031 }
            throw r5     // Catch:{ all -> 0x0031 }
        L_0x006c:
            r6 = move-exception
            r0 = r5
            r5 = r6
        L_0x006f:
            throw r5     // Catch:{ all -> 0x0070 }
        L_0x0070:
            r6 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.b(r0, r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.w(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0060 A[SYNTHETIC, Splitter:B:27:0x0060] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ java.lang.Object x(kotlinx.coroutines.channels.ReceiveChannel r5, kotlin.coroutines.Continuation r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$firstOrNull$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$firstOrNull$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$firstOrNull$1) r0
            int r1 = r0.Z2
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.Z2 = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$firstOrNull$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$firstOrNull$1
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.Y2
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.Z2
            r3 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r5 = r0.X2
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r0 = r0.Z
            kotlinx.coroutines.channels.ReceiveChannel r0 = (kotlinx.coroutines.channels.ReceiveChannel) r0
            kotlin.ResultKt.n(r6)     // Catch:{ all -> 0x0031 }
            goto L_0x0053
        L_0x0031:
            r5 = move-exception
            goto L_0x006b
        L_0x0033:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003b:
            kotlin.ResultKt.n(r6)
            kotlinx.coroutines.channels.ChannelIterator r6 = r5.iterator()     // Catch:{ all -> 0x0068 }
            r0.Z = r5     // Catch:{ all -> 0x0068 }
            r0.X2 = r6     // Catch:{ all -> 0x0068 }
            r0.Z2 = r3     // Catch:{ all -> 0x0068 }
            java.lang.Object r0 = r6.a(r0)     // Catch:{ all -> 0x0068 }
            if (r0 != r1) goto L_0x004f
            return r1
        L_0x004f:
            r4 = r0
            r0 = r5
            r5 = r6
            r6 = r4
        L_0x0053:
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ all -> 0x0031 }
            boolean r6 = r6.booleanValue()     // Catch:{ all -> 0x0031 }
            r1 = 0
            if (r6 != 0) goto L_0x0060
            kotlinx.coroutines.channels.ChannelsKt.b(r0, r1)
            return r1
        L_0x0060:
            java.lang.Object r5 = r5.next()     // Catch:{ all -> 0x0031 }
            kotlinx.coroutines.channels.ChannelsKt.b(r0, r1)
            return r5
        L_0x0068:
            r6 = move-exception
            r0 = r5
            r5 = r6
        L_0x006b:
            throw r5     // Catch:{ all -> 0x006c }
        L_0x006c:
            r6 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.b(r0, r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.x(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ ReceiveChannel z(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            coroutineContext = Dispatchers.g();
        }
        return ProduceKt.g(GlobalScope.s, coroutineContext, 0, (CoroutineStart) null, ChannelsKt.g(receiveChannel), new ChannelsKt__DeprecatedKt$flatMap$1(receiveChannel, function2, (Continuation<? super ChannelsKt__DeprecatedKt$flatMap$1>) null), 6, (Object) null);
    }
}
