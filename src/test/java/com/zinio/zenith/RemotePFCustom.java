package com.zinio.zenith;

import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.connection.channel.direct.LocalPortForwarder;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.Map;
import java.util.concurrent.*;

/**
 * This example demonstrates remote port forwarding i.e. when the remote host is made to listen on a specific address
 * and port; and forwards us incoming connections.
 */
public class RemotePFCustom {
    private Future<?> keepConnectionFuture;
    private SSHClient client;
    private ExecutorService executorService;
    private Map<PortForwardConfigEnum, String> properties;

    public enum PortForwardConfigEnum {
        SSH_HOST("ssh.host"),
        SSH_PORT("ssh.port"),
        SSH_USER("ssh.user"),
        SSH_PASS("ssh.pass"),
        SSH_PUBLIC_KEY("ssh.public_key"),
        PORT_FORWARD("port.forward"),
        DB_HOST("db.host"),
        DB_PORT("db.port");

        private String value;

        PortForwardConfigEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public void start() throws IOException, InterruptedException {
        this.executorService = Executors.newFixedThreadPool(2);
        this.keepConnectionFuture = this.executorService.submit(() -> {
            try {
                this.client = new SSHClient();
                this.client.loadKnownHosts();

                this.client.connect(
                        this.properties.get(PortForwardConfigEnum.SSH_HOST),
                        Integer.parseInt(this.properties.getOrDefault(PortForwardConfigEnum.SSH_PORT, "22"))
                );
                if (!Boolean.parseBoolean(this.properties.getOrDefault(PortForwardConfigEnum.SSH_PUBLIC_KEY, "false"))) {
                    this.client.authPassword(
                            this.properties.get(PortForwardConfigEnum.SSH_USER),
                            this.properties.get(PortForwardConfigEnum.SSH_PASS)
                    );
                } else {
                    this.client.authPublickey("duc.nguyen");
                }
                LocalPortForwarder.Parameters parameters = new LocalPortForwarder.Parameters(
                        "localhost",
                        Integer.parseInt(this.properties.get(PortForwardConfigEnum.PORT_FORWARD)),
                        this.properties.get(PortForwardConfigEnum.DB_HOST),
                        Integer.parseInt(this.properties.get(PortForwardConfigEnum.DB_PORT))
                );
                LocalPortForwarder localPortForwarder = client.newLocalPortForwarder(
                        parameters,
                        new ServerSocket(Integer.parseInt(this.properties.get(PortForwardConfigEnum.PORT_FORWARD))));
                client.getConnection().getKeepAlive().setKeepAliveInterval(30);
                localPortForwarder.listen();
                // Something to hang on to so that the forwarding stays
//                client.getTransport().join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        int i = 0;
        for (i = 0; i < 10; i++) {
            try {
                Socket socket = new Socket("localhost", Integer.parseInt(this.properties.get(PortForwardConfigEnum.PORT_FORWARD)));
                while (!socket.isConnected()) {
                    Thread.currentThread().sleep(2000);
                }
                break;
            } catch (Exception e) {
                Thread.currentThread().sleep(2000);
            }
        }
        if (10 >= i) {
            this.executorService.execute(() -> {
                try {
                    this.keepConnectionFuture.get();
                } catch (CancellationException cancellationException) {
//                    this.keepConnectionFuture.
                } catch (Exception e) {
                    e.printStackTrace();
//                    throw new RuntimeException(e);
                }
            });
        } else {
            throw new RuntimeException("Couldn't create the Port forward");
        }
    }

    public void stop() throws IOException {
        if (!this.keepConnectionFuture.isDone()) {
            this.keepConnectionFuture.cancel(true);
        }
        this.executorService.shutdownNow();
    }

    public RemotePFCustom(@NotNull Map<PortForwardConfigEnum, String> properties) {
        this.properties = properties;
    }

    public boolean testDatabaseConnection(String url,
                                          String user,
                                          String pass
    ) throws SQLException {
        System.out.println("Connect to database....");
        String strDbUser = user; // database loging username
        String strDbPassword = pass;//"nR3Jkvhmn3N3JLnhsnx4ttjL"; // database login password
        Connection con = null;
        try {
            con = DriverManager.getConnection(
                    url,
//                    String.format("jdbc:mysql://%s:%d?&serverTimezone=UTC", host, port),
                    strDbUser,
                    strDbPassword
            );
            DatabaseMetaData md = con.getMetaData();
            ResultSet rs = md.getTables(null, null, "%", null);
            while (rs.next()) {
                System.out.println(String.format("%s:%s:%S", rs.getString(1), rs.getString(2), rs.getString(3)));
            }
            rs.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (null != con) {
                con.close();
            }
        }
        return false;
    }

    public void keepConnection() throws ExecutionException, InterruptedException {
        this.keepConnectionFuture.get();
    }
}