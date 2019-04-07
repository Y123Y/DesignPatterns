package pattern.adapter.loginadapter.v1.service;

import pattern.adapter.loginadapter.ResultMsg;

public class SigninService {
    public ResultMsg regist(String username, String password){
        return new ResultMsg(200, "注册成功", new Object());
    }

    public ResultMsg login(String username, String password) {
        return null;
    }
}
