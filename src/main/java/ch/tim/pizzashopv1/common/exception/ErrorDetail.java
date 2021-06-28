package ch.tim.pizzashopv1.common.exception;

import org.springframework.util.Assert;

import java.util.Arrays;

public class ErrorDetail {
    /**
     * Der Fehlercode, im Normalfall TRI-....
     */
    private MessageCode messageCode;

    /**
     * Eine interne Beschreibung zum Fehler.
     */
    private String detailMessage;

    /**
     * Die Liste aller Parameter, die in der Meldung ausgegeben werden sollen.
     */
    private String[] parameters;

    public ErrorDetail(MessageCode code) {
        Assert.notNull(code, "Error message code cannot be null");
        this.messageCode = code;
    }

    public ErrorDetail(final String detailMessage) {
        this.detailMessage = detailMessage;
    }

    /**
     * Instanziert ein neues Objekt der Klasse ErrorDetail ohne Parameter.
     *
     * @param code          Der Fehlercode, im Normalfall TRI-.... (mandatory)
     * @param detailMessage interne Beschreibung zum Fehler
     */
    public ErrorDetail(final MessageCode code, final String detailMessage) {
        this(code);
        this.detailMessage = detailMessage;
        this.parameters = null;
    }

    /**
     * Instanziert ein neues Objekt der Klasse ErrorDetail mit Parameter.
     *
     * @param code          Der Fehlercode, im Normalfall TRI-.... (mandatory)
     * @param detailMessage interne Beschreibung zum Fehler
     * @param parameters    Die Liste aller Parameter, die in der Meldung ausgegeben werden sollen
     */
    public ErrorDetail(final MessageCode code, final String detailMessage, final String... parameters) {
        this(code);
        this.detailMessage = detailMessage;
        this.parameters = parameters;
    }

    /**
     * Instanziert ein neues Objekt der Klasse ErrorDetail mit Parameter.
     *
     * @param code          Der Fehlercode, im Normalfall TRI-.... (mandatory)
     * @param detailMessage interne Beschreibung zum Fehler
     * @param parameters    Die Liste aller Parameter, die in der Meldung ausgegeben werden sollen
     */
    public ErrorDetail(final String code, final String detailMessage, final String... parameters) {
        this(MessageCode.fromValue(code), detailMessage, parameters);
    }

    public MessageCode getMessageCode() {
        return messageCode;
    }

    public String getDetailMessage() {
        return detailMessage;
    }

    public String[] getParameters() {
        return parameters;
    }

    @Override
    public String toString() {
        return "ErrorDetail{" + "code='" + messageCode + '\'' + ", detailMessage='" + detailMessage + '\'' + ", parameters=" + parameters + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ErrorDetail that = (ErrorDetail) o;

        if (messageCode != that.messageCode) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(parameters, that.parameters);
    }

    @Override
    public int hashCode() {
        int result = messageCode != null ? messageCode.hashCode() : 0;
        result = 31 * result + Arrays.hashCode(parameters);
        return result;
    }
}