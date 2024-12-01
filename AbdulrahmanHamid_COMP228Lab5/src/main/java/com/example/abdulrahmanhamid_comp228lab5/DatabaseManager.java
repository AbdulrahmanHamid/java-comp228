package com.example.abdulrahmanhamid_comp228lab5;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DatabaseManager {
    private static final String URL = "jdbc:oracle:thin:@199.212.26.208:1521:SQLD";
    private static final String USER = "COMP228_F24_soh_43";
    private static final String PASSWORD = "";

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // a method to add all the information
    public void addGamePlayer(String firstName, String lastName, String address, String postalCode, String province, String phoneNumber, String gameTitle, String playingDate, int score) {
        String playerQuery = "INSERT INTO Abdulrahman_Hamid_player (first_name, last_name, address, postal_code, province, phone_number) VALUES (?, ?, ?, ?, ?, ?)";
        String gameQuery = "INSERT INTO Abdulrahman_Hamid_game (game_title) VALUES (?)";
        String playerGameQuery = "INSERT INTO Abdulrahman_H_player_and_game (game_id, player_id, playing_date, score) VALUES (?, ?, ?, ?)";

        try(Connection conn = connect()){
            // to insert player info
            //initialize player id to get the generated key by the database in oracle
            int playerId=0;
            try (PreparedStatement pstmt = conn.prepareStatement(playerQuery, new String[]{"player_id"})) {
                pstmt.setString(1, firstName);
                pstmt.setString(2, lastName);
                pstmt.setString(3, address);
                pstmt.setString(4, postalCode);
                pstmt.setString(5, province);
                pstmt.setString(6, phoneNumber);
                pstmt.executeUpdate();
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if(rs.next()) {
                        playerId = rs.getInt(1);
                    }
                }
            }
            // Insert game
            //initialize game id to get the generated key by the database in oracle
            int gameId=0;
            try (PreparedStatement pstmt = conn.prepareStatement(gameQuery, new String[]{"game_id"})) {
                pstmt.setString(1, gameTitle);
                pstmt.executeUpdate();

                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if(rs.next()){
                    gameId = rs.getInt(1);
                    }
                }
            }
            // to insert player game
            //it will get the player int and the game id from before when declared
            try (PreparedStatement pstmt = conn.prepareStatement(playerGameQuery)) {
                pstmt.setInt(1, gameId);
                pstmt.setInt(2, playerId);
                pstmt.setString(3, playingDate);
                pstmt.setInt(4, score);
                pstmt.executeUpdate();
            }
            JOptionPane.showMessageDialog(null, "all player game data was added", "Success", JOptionPane.DEFAULT_OPTION);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error data was not added", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getMessage());
        }
    }

    public void readPlayer() {
        String query = "SELECT * FROM Abdulrahman_Hamid_player";
        JTable table = new JTable();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Player ID");
        tableModel.addColumn("First Name");
        tableModel.addColumn("Last Name");
        tableModel.addColumn("Address");
        tableModel.addColumn("Postal Code");
        tableModel.addColumn("Province");
        tableModel.addColumn("Phone Number");

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

                while (rs.next()) {
                    tableModel.addRow(new String[]{Integer.toString(rs.getInt("player_id")), rs.getString("first_name"), rs.getString("last_name"), rs.getString("address"), rs.getString("postal_code"), rs.getString("province"), rs.getString("phone_number")});
                }

            table.setModel(tableModel);
            JScrollPane scrollPane = new JScrollPane(table);
            JFrame frame = new JFrame("Player and Game Information");
            frame.getContentPane().add(scrollPane);
            frame.setSize(800, 600);
            frame.setVisible(true);

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error"+ e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void readData() {
        String query = "SELECT first_name, last_name, address, postal_code, province, phone_number, game_title, playing_date, score from Abdulrahman_Hamid_player p join Abdulrahman_H_player_and_game o on p.player_id = o.player_id join Abdulrahman_Hamid_game g on o.game_id = g.game_id";

        JTable table = new JTable();
        DefaultTableModel tableModel = new DefaultTableModel();
        // Add columns to show it in the table model
        tableModel.addColumn("First Name");
        tableModel.addColumn("Last Name");
        tableModel.addColumn("Address");
        tableModel.addColumn("Postal Code");
        tableModel.addColumn("Province");
        tableModel.addColumn("Phone Number");
        tableModel.addColumn("Game Title");
        tableModel.addColumn("Playing Date");
        tableModel.addColumn("Score");

        // Add rows after we get them from the database
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

                while(rs.next()){
                    tableModel.addRow(new String[] { rs.getString("first_name"), rs.getString("last_name"), rs.getString("address"), rs.getString("postal_code"), rs.getString("province"), rs.getString("phone_number"), rs.getString("game_title"), rs.getString("playing_date"), Integer.toString(rs.getInt("score"))});
                    System.out.println("row added");
                }
                table.setModel(tableModel);
                JScrollPane scrollPane = new JScrollPane(table);
                JFrame frame = new JFrame("Player and Game Information");
                frame.getContentPane().add(scrollPane);
                frame.setSize(800, 600);
                frame.setVisible(true);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updatePlayer(int playerId, String firstName, String lastName, String address, String postalCode, String province, String phoneNumber) {
        String query = "update Abdulrahman_Hamid_player set first_name = NVL(?, first_name), last_name = NVL(?, last_name), address = NVL(?, address), postal_code = NVL(?, postal_code), province = NVL(?, province), phone_number = NVL(?, phone_number) where player_id = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, address);
            pstmt.setString(4, postalCode);
            pstmt.setString(5, province);
            pstmt.setString(6, phoneNumber);
            pstmt.setInt(7, playerId);

            //to check if the statement was done if not that means there was no ID similar to what was entered
            if (pstmt.executeUpdate() == 0) {
                JOptionPane.showMessageDialog(null, "No player found with the given ID. check the Get Players ID button", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "player with ID number " + playerId + " information has changed", "Success", JOptionPane.DEFAULT_OPTION);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "player information didn't update because: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


}
