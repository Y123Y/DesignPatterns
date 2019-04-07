package pattern.adapter.loginadapter.v1.service;

import pattern.adapter.loginadapter.ResultMsg;

public class SigninForThirdService extends SigninService {
    public ResultMsg loginForQQ(String openId) {
        return loginForRegist(openId, null);
    }

    public ResultMsg loginForWechat(String openId){
        return null;
    }

    public ResultMsg loginForToken(String token){
        return null;
    }
    public ResultMsg loginForTelphone(String telphone, String code){
        return null;
    }

    public ResultMsg loginForRegist(String username, String password) {
        super.regist(username, password);
        return super.login(username, password);
    }
}
