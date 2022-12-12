package shupeyko.eshop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ProdiutServlet", urlPatterns = "/product")
public class ProdiutServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(ProdiutServlet.class);

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Tomato", 10));
        products.add(new Product("Milk", 1));
        products.add(new Product("Cucumber", 5));
        products.add(new Product("Aplle", 7));
        products.add(new Product("Orange", 8));
        products.add(new Product("Cola", 1));
        products.add(new Product("Steak", 2));

        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().printf("<html><title>SpringHomeWork</title><body>");

        for (Product p : products){
            resp.getWriter().printf("<h1> " + p + "</h1>");
        }

        resp.getWriter().printf("</body></html>");
        resp.getWriter().close();
    }

}
