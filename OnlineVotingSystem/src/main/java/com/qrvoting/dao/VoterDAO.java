package com.qrvoting.dao;

import com.qrvoting.db.DBConnection;
import com.qrvoting.model.Voter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class VoterDAO {
    public boolean loginVoter(String email, String password) {

        String sql = "SELECT * FROM voters WHERE email = ? AND password = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            return rs.next(); // true if user exists

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    public boolean isEmailExists(String email) {

        String sql = "SELECT id FROM voters WHERE email = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            return rs.next(); // true if email exists

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    public boolean registerVoter(Voter voter) {

        // 🔒 Step 1: check duplicate email
        if (isEmailExists(voter.getEmail())) {
            System.out.println("❌ Email already registered!");
            return false;
        }

        String sql = "INSERT INTO voters(name, email, password, has_voted) VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, voter.getName());
            ps.setString(2, voter.getEmail());
            ps.setString(3, voter.getPassword());
            ps.setBoolean(4, false);

            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
