package service;
import model.Account;
public class UserService {
    RegLoginService userDao = new RegLoginService();
    public boolean checkEmail(String email) {
        boolean isExistEmail = userDao.find(email);
        return !isExistEmail;
    }
    public boolean reg(Account account) {
        Boolean isReg=false;
        if (userDao.reg(account)==1) {
            isReg=true;
        }
        return isReg;
    }

    public String checkLogin(String email, String pwd) {
        return userDao.find(email,pwd);
    }

    public String getUserId(String email) {
        return userDao.getUserId(email);
    }
}
