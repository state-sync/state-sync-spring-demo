package org.statesync.spring.demo.util;

import org.springframework.http.HttpStatus;
import org.statesync.spring.demo.api.advice.ApiRuntimeException;

public final class Preconditions {

    private Preconditions() {
    }

    public static void checkNotNull(Object ref, String messageCode, HttpStatus status, Object arg) {
        if (ref == null) {
            throw new ApiRuntimeException(messageCode, status, arg);
        }
    }

    public static void checkNotNull(Object ref, String messageCode, HttpStatus status, Object arg1, Object arg2) {
        if (ref == null) {
            throw new ApiRuntimeException(messageCode, status, arg1, arg2);
        }
    }

    public static void checkNotNull(Object ref, String messageCode, HttpStatus status, Object arg1, Object arg2, Object arg3) {
        if (ref == null) {
            throw new ApiRuntimeException(messageCode, status, arg1, arg2, arg3);
        }
    }

    public static void checkNotNull(Object ref, String messageCode, HttpStatus status, Object... args) {
        if (ref == null) {
            throw new ApiRuntimeException(messageCode, status, args);
        }
    }

    public static void checkNull(Object ref, String messageCode, HttpStatus status, Object arg) {
        if (ref != null) {
            throw new ApiRuntimeException(messageCode, status, arg);
        }
    }

    public static void checkNull(Object ref, String messageCode, HttpStatus status, Object arg1, Object arg2) {
        if (ref != null) {
            throw new ApiRuntimeException(messageCode, status, arg1, arg2);
        }
    }

    public static void checkNull(Object ref, String messageCode, HttpStatus status, Object arg1, Object arg2, Object arg3) {
        if (ref != null) {
            throw new ApiRuntimeException(messageCode, status, arg1, arg2, arg3);
        }
    }

    public static void checkNull(Object ref, String messageCode, HttpStatus status, Object... args) {
        if (ref != null) {
            throw new ApiRuntimeException(messageCode, status, args);
        }
    }

    public static void checkTrue(boolean value, String messageCode, HttpStatus status, Object arg) {
        if (!value) {
            throw new ApiRuntimeException(messageCode, status, arg);
        }
    }

    public static void checkTrue(boolean value, String messageCode, HttpStatus status, Object arg1, Object arg2) {
        if (!value) {
            throw new ApiRuntimeException(messageCode, status, arg1, arg2);
        }
    }

    public static void checkTrue(boolean value, String messageCode, HttpStatus status, Object arg1, Object arg2, Object arg3) {
        if (!value) {
            throw new ApiRuntimeException(messageCode, status, arg1, arg2, arg3);
        }
    }

    public static void checkTrue(boolean value, String messageCode, HttpStatus status, Object... args) {
        if (!value) {
            throw new ApiRuntimeException(messageCode, status, args);
        }
    }

    public static void checkFalse(boolean value, String messageCode, HttpStatus status, Object arg) {
        checkTrue(!value, messageCode, status, arg);
    }

    public static void checkFalse(boolean value, String messageCode, HttpStatus status, Object arg1, Object arg2) {
        checkTrue(!value, messageCode, status, arg1, arg2);
    }

    public static void checkFalse(boolean value, String messageCode, HttpStatus status, Object arg1, Object arg2, Object arg3) {
        checkTrue(!value, messageCode, status, arg1, arg2, arg3);
    }

    public static void checkFalse(boolean value, String messageCode, HttpStatus status, Object... args) {
        checkTrue(!value, messageCode, status, args);
    }
}
