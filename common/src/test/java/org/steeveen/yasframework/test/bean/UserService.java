package org.steeveen.yasframework.test.bean;

public class UserService {
    private String uId;
    /*需要注入的对象*/
    private UserDao userDao;

    public String queryUserInfo() {
        return userDao.queryUserName(uId);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append("").append(uId);
        return sb.toString();
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
