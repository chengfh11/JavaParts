package parts;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class PasswordDecrypter {



	public static String decryptPassword(String encryptedPassword) {

		//String encryptedPassword = "bSj4cytnbBp4YxZ40btDmg==";
		String key = "849d5fc7a66ad08b99f10a4c00c6d520";
		String iapKey = "76d69e02b551303ab3a9d5267dcd2b9f";
		
		StandardPBEStringEncryptor decryptor = new StandardPBEStringEncryptor();
		decryptor.setPassword(key);
		String password = decryptor.decrypt(encryptedPassword);
		//System.out.println(decryptor.encrypt("kaplan"));
		// System.out.println(password);
		return password;

	}

	public static String encryptPassword(String password) {

		//String encryptedPassword = "bSj4cytnbBp4YxZ40btDmg==";

		StandardPBEStringEncryptor decryptor = new StandardPBEStringEncryptor();
		decryptor.setPassword("849d5fc7a66ad08b99f10a4c00c6d520");
		String encryptedPassword = decryptor.encrypt(password);
		//System.out.println(decryptor.encrypt("kaplan"));
		//System.out.println(password);
		return encryptedPassword;

	}
}