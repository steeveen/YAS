package org.steeveen.yasframework.test.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author steeveen
 * @date 2023/2/12 18:24
 */
public class UserDao {
    private static Map<String,String> hashMap=new HashMap<>();
    static {
        hashMap.put("user01","user-1");
        hashMap.put("user02","user-2");
        hashMap.put("user03","user-3");
    }
    public String queryUserName(String uid) {
        return hashMap.get(uid);
    }
}
