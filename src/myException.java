public class myException extends Exception {

  public myException() {
  }

  public myException(String message) {
    super(message);
  }

  public myException(String message, Throwable cause) {
    super(message, cause);
  }

  public myException(Throwable cause) {
    super(cause);
  }

  public myException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
