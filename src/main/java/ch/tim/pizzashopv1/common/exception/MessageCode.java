package ch.tim.pizzashopv1.common.exception;

public enum MessageCode {

    UNKNOWN_ERROR("PSI-000000", "Unknown error code"),
    INVALID_CREDENTIALS("PSI-000002", "Bad Credentials"),
    NOT_FOUND("PSI-000001", "Entity not found");

    
    private final String code;

    private final String description;

    MessageCode(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static MessageCode fromValue(final String value) {
        for (MessageCode messageCode : values()) {
            if (messageCode.value().equals(value)) {
                return messageCode;
            }
        }
        return null;
    }

    public final String value() {
        return code;
    }

    public final String getDescription() {
        return description;
    }
}
