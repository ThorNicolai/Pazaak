package exceptions;

import domein.Taal;

public class NaamInGebruikException extends RuntimeException {

    public NaamInGebruikException() {
        
        this(Taal.geefVertaling("gebrNaam"));
    }

    public NaamInGebruikException(String message) {
        super(message);
    }

    public NaamInGebruikException(String message, Throwable cause) {
        super(message, cause);
    }

    public NaamInGebruikException(Throwable cause) {
        super(cause);
    }

    public NaamInGebruikException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
