/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alex
 */
public class Mysql_database {

    public ArrayList search_movie() {
        String query = "SELECT imdb_uri FROM movies";
        ResultSet rs = search_sql(query);
        ArrayList<String> filmes = new ArrayList<>();
        try {
            while (rs.next()) {
                filmes.add(rs.getString(0));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mysql_database.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRO: search_movie");
        }
        return filmes;
    }

    public boolean actor_exists(String actor_imdb) {
        String query = "SELECT COUNT(imdb_uri) AS rowcount FROM actors WHERE imdb_uri=\"" + actor_imdb + "\"";
        ResultSet rs = search_sql(query);

        try {
            int count = 0;
            rs.next();
            count = rs.getInt("rowcount");
            return count != 0;
        } catch (SQLException ex) {
            Logger.getLogger(Mysql_database.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRO: actor_exists");
            return false;
        }
    }

    public ResultSet search_sql(String query) {
        ResultSet rs = null;
        try {
            // create a mysql database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/scrapper?user=root&password=124789");
            Statement st = conn.createStatement();
            rs = st.executeQuery(query);
            System.out.println(rs);
            //conn.close();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Mysql_database.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRO: search_sql");
        }
        return rs;
    }

    public boolean insert_sql(ArrayList<ArrayList<String>> q, String table) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/scrapper?user=root&password=124789");
            String query = "";

            switch (table) {
                case "actors":
                    query = "INSERT IGNORE INTO actors VALUES(?, ?, ?, ?, ?)";
                    break;
                case "movies":
                    query = "INSERT IGNORE INTO movies VALUES(?, ?, ?, ?)";
                    break;
                case "actor_movie":
                    query = "INSERT IGNORE INTO actor_movie VALUES(?, ?)";
                    break;
                default:
                    System.out.println("ERRO: A tabela não existe!");
                    return false;
            }

            PreparedStatement ps = conn.prepareStatement(query);

            switch (table) {
                case "actors":
                    for (ArrayList<String> v : q) {
                        for (int i = 0; i < v.size(); i++) {
                            ps.setString(i + 1, v.get(i));
                        }
                        ps.addBatch();
                    }
                    break;
                case "movies":
                    for (ArrayList<String> v : q) {
                        for (int i = 0; i < v.size(); i++) {
                            ps.setString(i + 1, v.get(i));
                        }
                        ps.addBatch();
                    }
                    break;
                case "actor_movie":
                    for (ArrayList<String> v : q) {
                        for (int i = 0; i < v.size(); i++) {
                            ps.setString(i + 1, v.get(i));
                        }
                        ps.addBatch();
                    }
                    break;
                default:
                    System.out.println("ERRO: A tabela não existe!");
                    return false;
//                    break;
            }
            ps.executeBatch();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Mysql_database.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRO: insert_sql");
            return false;
        }
    }
}
