package com.qrvoting;

import com.qrvoting.dao.VoterDAO;
import com.qrvoting.model.Voter;

public class TestVoterRegistration {

    public static void main(String[] args) {

        VoterDAO dao = new VoterDAO();

        // SAME email which already exists in DB
        Voter voter = new Voter(
                "Ashish Samal",
                "ashish@test.com", // duplicate email
                "12345"
        );

        boolean success = dao.registerVoter(voter);

        if (success) {
            System.out.println("Voter Registered Successfully!");
        } else {
            System.out.println("Registration Failed!");
        }
    }
}
