package edu.picturedlsys.exception;

public class DownloadPicutreException extends RuntimeException {

    public DownloadPicutreException(String message) {
        super(message);
    }

    public DownloadPicutreException(String message, Throwable cause) {
        super(message, cause);
    }

    public DownloadPicutreException(Throwable cause) {
        super(cause);
    }
}
