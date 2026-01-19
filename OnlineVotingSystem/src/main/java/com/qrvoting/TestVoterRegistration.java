package com.qrvoting;

import com.qrvoting.dao.VoterDAO;
import com.qrvoting.model.Voter;

public class TestVoterRegistration {
    public static void main(String[] args) {

        Voter voter = new Voter(
                "Ashish Samal",
                "ashish@test.com",
                "12345"
        );

        VoterDAO dao = new VoterDAO();
        boolean success = dao.registerVoter(voter);

        if (success) {
            System.out.println("Voter Registered Successfully!");
        } else {
            System.out.println("Registration Failed!");
        }
    }
}
