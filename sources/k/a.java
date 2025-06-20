package k;

import kotlinx.coroutines.debug.AgentPremain;
import sun.misc.Signal;
import sun.misc.SignalHandler;

public final /* synthetic */ class a implements SignalHandler {
    public final void a(Signal signal) {
        AgentPremain.c(signal);
    }
}
