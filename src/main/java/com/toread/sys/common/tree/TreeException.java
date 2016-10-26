package com.toread.sys.common.tree;

/**
 * Created by toread on 16-10-25.
 */
public class TreeException extends RuntimeException {
    public TreeException() {
        super();
    }

    public TreeException(String message) {
        super(message);
    }

    public TreeException(String message, Throwable cause) {
        super(message, cause);
    }

    public TreeException(Throwable cause) {
        super(cause);
    }

    protected TreeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
