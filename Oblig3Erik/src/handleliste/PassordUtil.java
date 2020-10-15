package handleliste;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PassordUtil {

	private static final int SALT_LENGDE = 24;
	private static final int HASH_ITERASJONER = 1000;
	
	private static final int KEY_LENGDE = 256;
	
	private static final String KEY_FACTORY_ALGORITHM = "PBKDF2WithHmacSHA256";
	
	private static final String KORREKT_PASSORD_PATTERN = "DAT108ErGoy";
	
	
	public String krypterPassord(String passord) throws IllegalArgumentException {
	
		if(passord == null || !passord.matches(KORREKT_PASSORD_PATTERN)) {
			throw new IllegalArgumentException("Ugyldig passord. Passordet stemmer ikke med passordet du har valgt");
		}
		
		byte[] salt = genererTilfeldigSalt();
		return krypterMedSalt(salt, passord);
		
	}
	
	public boolean sjekkPassord(String passord, String kryptert) {
		
		if(passord == null || !passord.matches(KORREKT_PASSORD_PATTERN)) {
			throw new IllegalArgumentException("Ugyldig passord. Passordet stemmer ikke med passordet du har valgt");
		}
		
		if(kryptert == null) {
			throw new IllegalArgumentException("Kryptert passord kan ikke være null");
		}
		
		byte[] salt = hentUtSaltFraKryptertStreng(kryptert);
		return krypterMedSalt(salt, passord).equals(kryptert);
	}
	
	public String krypterMedSalt(byte[] salt, String passord) {
		
		String kryptert = null;
		
		SecretKeyFactory skf;
		try {
			char[] passchars = passord.toCharArray();
			
			PBEKeySpec pks = new PBEKeySpec(passchars, salt, HASH_ITERASJONER, KEY_LENGDE);
			skf = SecretKeyFactory.getInstance(KEY_FACTORY_ALGORITHM);
			byte[] keyHash = skf.generateSecret(pks).getEncoded();
			
			byte[] saltPlusKeyHash = leggSammen(salt, keyHash);
			kryptert = Base64.getEncoder().encodeToString(saltPlusKeyHash);
		}
		catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
		}
		
		return kryptert;
		
	}
	
	
	//Hjelpemetoder
	
	public byte[] genererTilfeldigSalt() {
		byte[] salt = new byte[SALT_LENGDE];
		
		new SecureRandom().nextBytes(salt);
		return salt;
	}
	
	private byte[] hentUtSaltFraKryptertStreng(String kryptert) {
		byte[] saltPlusDigest = Base64.getDecoder().decode(kryptert);
		byte[] salt = Arrays.copyOf(saltPlusDigest, SALT_LENGDE);
		return salt;
	}
	
	private byte[] leggSammen(byte[] tabell1, byte[] tabell2) {
		byte[] enOgTo = new byte[tabell1.length + tabell2.length];
		System.arraycopy(tabell1, 0, enOgTo, 0, tabell1.length);
		System.arraycopy(tabell2, 0, enOgTo, tabell1.length, tabell2.length);
		return enOgTo;
	}
	
}
