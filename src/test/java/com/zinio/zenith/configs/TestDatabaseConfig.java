package com.zinio.zenith.configs;

import com.zinio.zenith.RemotePF;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


@ComponentScan(basePackages = {"com.zinio.zenith"})
public class TestDatabaseConfig extends DatabaseConfig {
    private static RemotePF remotePF;
    private static DataSource dataSource;

    /**
     * DataSource definition for database connection. Settings are read from
     * the application.properties file (using the env object).
     */
    @Override
    @Bean
    public DataSource dataSource() {
        if (null == remotePF) {
            if (Boolean.parseBoolean(env.getProperty("db.behind_proxy", "false"))) {
                Map<RemotePF.PortForwardConfigEnum, String> portForwardSetting = new HashMap<RemotePF.PortForwardConfigEnum, String>() {{
                    put(RemotePF.PortForwardConfigEnum.SSH_HOST, env.getProperty(RemotePF.PortForwardConfigEnum.SSH_HOST.getValue()));
                    put(RemotePF.PortForwardConfigEnum.SSH_PORT, env.getProperty(RemotePF.PortForwardConfigEnum.SSH_PORT.getValue()));
                    put(RemotePF.PortForwardConfigEnum.SSH_USER, env.getProperty(RemotePF.PortForwardConfigEnum.SSH_USER.getValue()));
                    put(RemotePF.PortForwardConfigEnum.SSH_PASS, env.getProperty(RemotePF.PortForwardConfigEnum.SSH_PASS.getValue()));
                    put(RemotePF.PortForwardConfigEnum.SSH_PUBLIC_KEY, env.getProperty(RemotePF.PortForwardConfigEnum.SSH_PUBLIC_KEY.getValue()));
                    put(RemotePF.PortForwardConfigEnum.DB_HOST, env.getProperty(RemotePF.PortForwardConfigEnum.DB_HOST.getValue()));
                    put(RemotePF.PortForwardConfigEnum.DB_PORT, env.getProperty(RemotePF.PortForwardConfigEnum.DB_PORT.getValue()));
                    put(RemotePF.PortForwardConfigEnum.PORT_FORWARD, env.getProperty(RemotePF.PortForwardConfigEnum.PORT_FORWARD.getValue()));
                }};
                remotePF = new RemotePF(portForwardSetting);
                try {
                    remotePF.start();
//                    if (remotePF.testDatabaseConnection(
//                            env.getProperty("db.url"),
//                            env.getProperty("db.username"),
//                            env.getProperty("db.password"))) {
//                        System.out.println("Success");
//                    } else {
//                        System.out.println("Failed");
//                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        if (null == dataSource) {
            dataSource = super.dataSource();
        }
        return dataSource;
    }

//    @PostConstruct
//    public void finishSetUP(){
//    }

}
