package br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Service;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {

	public static String hashPassword(String plainTextPassword){
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}
	
	public static boolean checkPass(String plainPassword, String hashedPassword) {
		if (BCrypt.checkpw(plainPassword, hashedPassword))
			return true;
		else
			return false;
	}

}