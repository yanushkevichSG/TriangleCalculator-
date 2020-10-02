package com.epam.triangle.exception;

import java.io.IOException;

public class NotSupportedPuthException extends IOException {
    public NotSupportedPuthException(String msg, Throwable exception) {
        super(msg, exception);
    }

}
