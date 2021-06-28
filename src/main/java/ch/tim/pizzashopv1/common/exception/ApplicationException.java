package ch.tim.pizzashopv1.common.exception;

public class ApplicationException extends RuntimeException {

    private static final long serialVersionUID = -8718416973316843767L;

    private ErrorDetail errorDetail;

    public ApplicationException() {
    }


    public ApplicationException(final String detailMessage) {
        this(new ErrorDetail(detailMessage));
    }



    public ApplicationException(final MessageCode messageCode, final String detailMessage) {
        this(new ErrorDetail(messageCode, detailMessage));
    }



    private ApplicationException(final ErrorDetail errorDetail) {
        this.errorDetail = errorDetail;
    }

    public ErrorDetail getErrorDetail() {
        return errorDetail;
    }

    public void setErrorDetail(ErrorDetail errorDetail) {
        this.errorDetail = errorDetail;
    }
}

