package control;

import java.rmi.ServerException;
import javax.servlet.http.HttpServletRequest;
import model.Utente;

public class MyException extends ServerException {

  public MyException(String message) {
    super(message);
  }

  public MyException(String message, Exception ex) {
    super(message, ex);
  }

  public static void checkAdmin(HttpServletRequest request) throws MyException {
    Utente utente = (Utente) request.getSession().getAttribute("utente");
    if (utente == null || !utente.isAdmin()) {
      throw new MyException("Utente non autorizzato");
    }
  }

  public static void checkLogged(HttpServletRequest request) throws MyException {
    Utente utente = (Utente) request.getSession().getAttribute("utente");
    if (utente == null) {
      throw new MyException("Utente non loggato");
    }
  }

}
