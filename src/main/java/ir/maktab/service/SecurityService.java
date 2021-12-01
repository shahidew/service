package ir.maktab.service;

public interface SecurityService {

    public void autoLogin(String username, String password);

    String findLoggedInUsername();
}
