package springbootdemo.springbootdemo.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

@Service
public class DataService {

    public Object getTeams() throws Exception {
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;

        try {
            // kines 27-41 will not change
            List<Map<String, String>> data = new ArrayList<>();
            String user = "themxvog";
            String password = "@Minority1";
            String host = "server236.web-hosting.com";
            int port = 21098;

            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, port);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            session.setPortForwardingL(5522, "127.0.0.1", 3306);

            String connectionUrl = "jdbc:mysql://localhost:5522/themxvog_bt";
            connection = DriverManager.getConnection(connectionUrl, "themxvog_bt_2162213", "2162213bt");

            String query = "SELECT * FROM nba";
            statement = connection.createStatement(); // typically does not change
            resultSet = statement.executeQuery(query); // how you access the rows, connect to database, make
                                                       // transaction, make query

            while (resultSet.next()) {
                // creating the table
                Map<String, String> map = new HashMap<>();
                map.put("team", resultSet.getString("team"));
                map.put("city", resultSet.getString("city"));
                map.put("state", resultSet.getString("state"));
                map.put("mascot", resultSet.getString("mascot"));

                data.add(map);
            }

            return data;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw e;
        } finally { // if you do not close your database it will stay open
                    // make sure you close each interaction
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        }
    }

    public void insertTeam() throws Exception {

        Connection connection = null;
        Statement statement = null;

        try {

            String user = "themxvog";
            String password = "*****";
            String host = "server236.web-hosting.com";
            int port = 21098;

            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, port);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            session.setPortForwardingL(5522, "127.0.0.1", 3306);

            String connectionUrl = "jdbc:mysql://localhost:5522/themxvog_wp679";
            connection = DriverManager.getConnection(connectionUrl, "themxvog_wp679", "******");

            String query = "insert into nba (team, city, state, mascot) values ('hawks', 'atlanta', 'georgia', 'hawk')";

            statement = connection.createStatement();
            statement.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
        }
    }

    public void deleteTeam() throws Exception {

        Connection connection = null;
        Statement statement = null;

        try {

            String user = "themxvog";
            String password = "*****";
            String host = "server236.web-hosting.com";
            int port = 21098;

            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, port);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            session.setPortForwardingL(5522, "127.0.0.1", 3306);

            String connectionUrl = "jdbc:mysql://localhost:5522/themxvog_wp679";
            connection = DriverManager.getConnection(connectionUrl, "themxvog_wp679", "******");

            String query = "delete from nba where team='suns'";

            statement = connection.createStatement();
            statement.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
        }
    }

    public void updateTeam() throws Exception {

        Connection connection = null;
        Statement statement = null;

        try {

            String user = "themxvog";
            String password = "*****";
            String host = "server236.web-hosting.com";
            int port = 21098;

            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, port);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            session.setPortForwardingL(5522, "127.0.0.1", 3306);

            String connectionUrl = "jdbc:mysql://localhost:5522/themxvog_wp679";
            connection = DriverManager.getConnection(connectionUrl, "themxvog_wp679", "******");

            String query = "update nba set team='mavericks' where team='76ers' ";
            query = "update nba set city='dallas' where city='philadelphia' ";
            query = "update nba set state='texas' where city='pennsylvania' ";
            query = "update nba set mascot='horse' where mascot='franklin the dog'";

            statement = connection.createStatement();
            statement.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
        }
    }
}