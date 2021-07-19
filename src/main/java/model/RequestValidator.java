package model;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.lang.String;

public class RequestValidator {

    private final List<String> errors;
    private final HttpServletRequest request;
    private static final Pattern INT_PATTERN = Pattern.compile("^\\d+$");
    private static final Pattern DOUBLE_PATTERN = Pattern.compile("^(-)?(0|[1-9]\\d+)\\.\\d+$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("(?=(.*[0-9]))((?=.*[A-Za-z0-9])(?=.*[A-Z])(?=.*[a-z]))^.{8,}$");

    public RequestValidator(HttpServletRequest request) {
        this.errors = new ArrayList<>();
        this.request = request;
    }

    public RequestValidator(){
        this.errors = new ArrayList<>();
        this.request = null;
    }

    public boolean hasErrors(){
        return !errors.isEmpty();
    }

    public List<String> getErrors(){
        return errors;
    }

    public void addError(String msg){
        errors.add(msg);
    }

    private boolean gatherError(boolean condition, String message){
        if(condition){
            return true;
        }else{
            errors.add(message);
            return false;
        }
    }

    private boolean required(String value){
        return value != null && !value.trim().isEmpty();
    }

    public boolean assertMatch(String value, Pattern regexp, String msg){
        String param = request.getParameter(value);
        boolean condition = required(param) && regexp.matcher(param).matches();
        return gatherError(condition, msg);
    }

    public boolean assertInt(String value, String msg) {
        return assertMatch(value, INT_PATTERN, msg);
    }

    public boolean assertDouble(String value, String msg){
        return assertMatch(value, DOUBLE_PATTERN, msg);
    }

    public boolean assertEmail(String value, String msg){
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$");
        return assertMatch(value, pattern,msg);
    }

    public boolean assertPassword(String value, String msg){
        return assertMatch(value, PASSWORD_PATTERN, msg );
    }

    public boolean equalEmail(String email1, String email2, String msg){
        String firstEm = request.getParameter(email1);
        String secondEm = request.getParameter(email2);
        return gatherError(firstEm.equals(secondEm), msg);
    }

    public boolean equalPassword(String pwd1, String pwd2, String msg){
        String firstPw = request.getParameter(pwd1);
        String secondPw = request.getParameter(pwd2);
        return gatherError(firstPw.equals(secondPw), msg);
    }

}
