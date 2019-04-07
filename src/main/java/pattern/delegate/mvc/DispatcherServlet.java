package pattern.delegate.mvc;

import pattern.delegate.mvc.controllers.MemberController;
import pattern.delegate.mvc.controllers.OrderController;
import pattern.delegate.mvc.controllers.SystemController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class DispatcherServlet extends HttpServlet {
    private List<Hanlder> hanlderMapping = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        try {
            Class<?> memberControllerClass = MemberController.class;
            hanlderMapping.add(new Hanlder().setController(memberControllerClass.newInstance())
                    .setMethod(memberControllerClass.getMethod("getMemberById", String.class))
                    .setUrl("localhost:8080/Delegate/getMemberById"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDispatch(req, resp);
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) {
        String uri = req.getRequestURI();
        Hanlder hanlder = null;
        for (Hanlder h : hanlderMapping) {
            if (uri != null && uri.equals(h.getUrl())) {
                hanlder = h;
                break;
            }
        }

        try {
            Object obj = hanlder.getMethod().invoke(hanlder.getController(), req.getParameter("mid"));
            resp.getWriter().write(obj.toString());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        String uri = req.getRequestURI();
//        String mid = req.getParameter("mid");
//        if ("getMemberById".equals(uri)) {
//            new MemberController().getMemberById(mid);
//        } else if ("getOrderById".equals(uri)) {
//            new OrderController().getOrderById(mid);
//        } else if ("logout".equals(uri)) {
//            new SystemController().logout();
//        } else {
//            resp.getWriter().write("404 Not Found!");
//        }
//    }

    class Hanlder{
        private Object controller;
        private Method method;
        private String url;

        public Object getController() {
            return controller;
        }

        public Hanlder setController(Object controller) {
            this.controller = controller;
            return this;
        }

        public Method getMethod() {
            return method;
        }

        public Hanlder setMethod(Method method) {
            this.method = method;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public Hanlder setUrl(String url) {
            this.url = url;
            return this;
        }
    }
}
