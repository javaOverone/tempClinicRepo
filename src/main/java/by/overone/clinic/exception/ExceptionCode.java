package by.overone.clinic.exception;

public enum ExceptionCode {
    NOT_EXISTING_USER ("4000"),
    NOT_EXISTING_PET("4001");
    private final String errorCode;

    ExceptionCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
