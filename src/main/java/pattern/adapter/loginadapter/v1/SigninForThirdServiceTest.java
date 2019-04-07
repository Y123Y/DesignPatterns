package pattern.adapter.loginadapter.v1;

import pattern.adapter.loginadapter.v1.service.SigninForThirdService;

public class SigninForThirdServiceTest {
    public static void main(String[] args) {
        SigninForThirdService service = new SigninForThirdService();
        service.login("34", "456");

    }
}
