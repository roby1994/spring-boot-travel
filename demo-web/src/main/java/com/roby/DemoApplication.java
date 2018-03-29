package com.roby;

import com.roby.filter.TimeFilter;
import com.roby.listener.ListenerTest;
import com.roby.servlet.ServletTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.EnumSet;

//@SpringBootApplication
//public class DemoApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(DemoApplication.class, args);
//	}
//}

@SpringBootApplication
public class DemoApplication implements ServletContextInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // 配置 Servlet
        servletContext.addServlet("servletTest", new ServletTest()).addMapping("/servletTest");
        // 配置过滤器
        servletContext.addFilter("timeFilter", new TimeFilter())
                .addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
        // 配置监听器
        servletContext.addListener(new ListenerTest());
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}