package com.bumptech.glide.load.engine;

final class CallbackException extends RuntimeException {
    private static final long s = -7530898992688511851L;

    CallbackException(Throwable th) {
        super("Unexpected exception thrown by non-Glide code", th);
    }
}
