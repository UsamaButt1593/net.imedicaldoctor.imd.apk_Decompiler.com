package com.google.common.graph;

@ElementTypesAreNonnullByDefault
final class GraphConstants {

    /* renamed from: a  reason: collision with root package name */
    static final int f22601a = 2;

    /* renamed from: b  reason: collision with root package name */
    static final int f22602b = 10;

    /* renamed from: c  reason: collision with root package name */
    static final int f22603c = 20;

    /* renamed from: d  reason: collision with root package name */
    static final float f22604d = 1.0f;

    /* renamed from: e  reason: collision with root package name */
    static final int f22605e = 2;

    /* renamed from: f  reason: collision with root package name */
    static final String f22606f = "Node %s is not an element of this graph.";

    /* renamed from: g  reason: collision with root package name */
    static final String f22607g = "Edge %s is not an element of this graph.";

    /* renamed from: h  reason: collision with root package name */
    static final String f22608h = "Edge %s already exists between the following nodes: %s, so it cannot be reused to connect the following nodes: %s.";

    /* renamed from: i  reason: collision with root package name */
    static final String f22609i = "Cannot call edgeConnecting() when parallel edges exist between %s and %s. Consider calling edgesConnecting() instead.";

    /* renamed from: j  reason: collision with root package name */
    static final String f22610j = "Nodes %s and %s are already connected by a different edge. To construct a graph that allows parallel edges, call allowsParallelEdges(true) on the Builder.";

    /* renamed from: k  reason: collision with root package name */
    static final String f22611k = "Cannot add self-loop edge on node %s, as self-loops are not allowed. To construct a graph that allows self-loops, call allowsSelfLoops(true) on the Builder.";

    /* renamed from: l  reason: collision with root package name */
    static final String f22612l = "Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.";

    /* renamed from: m  reason: collision with root package name */
    static final String f22613m = "Edge %s already exists in the graph.";

    /* renamed from: n  reason: collision with root package name */
    static final String f22614n = "Mismatch: endpoints' ordering is not compatible with directionality of the graph";

    enum Presence {
        EDGE_EXISTS
    }

    private GraphConstants() {
    }
}
