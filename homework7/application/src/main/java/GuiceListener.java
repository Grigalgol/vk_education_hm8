import com.google.inject.AbstractModule;
import com.google.inject.Module;
import dao.CompanyDAO;
import dao.ProductDAO;
import org.jboss.resteasy.plugins.guice.GuiceResteasyBootstrapServletContextListener;
import service.DataManager;

import javax.servlet.ServletContext;
import java.util.Collections;
import java.util.List;

public class GuiceListener extends GuiceResteasyBootstrapServletContextListener {
    @Override
    protected List<? extends Module> getModules(ServletContext context) {
        return Collections.singletonList(new GuiceModule());
    }
    private static final class GuiceModule extends AbstractModule {
        @Override
        protected void configure() {
            bind(ObjectMapperProvider.class).toInstance(new ObjectMapperProvider());
            bind(ProductDAO.class);
            bind(CompanyDAO.class);
            bind(DataManager.class);
            bind(JacksonMessageBodyHandler.class).toInstance(new JacksonMessageBodyHandler());
            bind(ProductRest.class);
        }
    }
}
