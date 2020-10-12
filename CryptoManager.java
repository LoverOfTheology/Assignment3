package application;



public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds(String plainText) {
		int length = plainText.length();
		boolean bounds=true;
		for(int i = 0; i<length; i++) {
			if(plainText.charAt(i) < 32 || plainText.charAt(i) > 95 ) {
				bounds = false;
				break;
			}
		}
		if(bounds)
			return true;
		else
			return false;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		int length = plainText.length();
		String newString= "";
		char[] encrypt;
		encrypt = new char[length];
		
		for(int i = 0; i<length; i++) {
		encrypt[i] = plainText.charAt(i); //Copies the text to a new array
		}
		for(int i = 0; i<length; i++) {
			encrypt[i] += key;      
			if(encrypt[i] > 95 || encrypt[i] < 32 ) {
				encrypt[i] -= 64;
			}
			newString +=encrypt[i];			//Copying the encrypted chars into a string
		}
		return newString;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		int length = plainText.length();   int length2 = bellasoStr.length();
		String newString= "";
		char[] encrypt; encrypt = new char[length];   char[] bellaso; bellaso = new char[length];
		
		for(int i = 0; i<length; i++) {
		encrypt[i] = plainText.charAt(i); //Copies the text to a new array
		}
			for(int j=0; j<=length; j++) {
			if(length2 != length){
				bellasoStr += bellasoStr.charAt(j);	
				length2 = bellasoStr.length();
				if(j>=length2 ) {
					j=0;
				}
			}
			else
				break;
			}
			for(int i=0; i<length; i++) {
				bellaso[i] = bellasoStr.charAt(i);   //This copies the new formulated string to an array
			}
			
	
			for(int i = 0; i<length; i++) {
				encrypt[i] += bellasoStr.charAt(i);
			
			while(encrypt[i]<32 || encrypt[i] > 95){ 
				encrypt[i] -= 64;				//This makes sure that the result is in the range.
			}
			newString += encrypt[i];			//Copying the encrypted chars into a string

			}
		
		return newString;
	}
	
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		int length = encryptedText.length();
		String newString= "";
		char[] decrypt;
		decrypt = new char[length];
		
		for(int i = 0; i<length; i++) {
		decrypt[i] = encryptedText.charAt(i);//Copies the encrypted text to a new array
		}
		for(int i = 0; i<length; i++) {
			decrypt[i] -= key;
			if(decrypt[i] > 95 || decrypt[i] < 32 ) {
				decrypt[i] += 64; 			//This makes sure that the result is in the range.
			}
			newString +=decrypt[i];			//Copying the decrypted chars into a string
		}
		return newString;	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		int length = encryptedText.length();
		int length2 = bellasoStr.length();
		String newString= "";
		char[] decrypt;
		decrypt = new char[length];
		char[] bellaso;
		bellaso = new char[100];
		for(int i = 0; i<length; i++) { //Copies the encrypted text to a new array
			decrypt[i] = encryptedText.charAt(i);
			}
			
			 {
				for(int j=0; j<length; j++) { //This copies the chars over and over again
				if(length2 != length){
					bellasoStr += bellasoStr.charAt(j);	
					length2 = bellasoStr.length();
					if(j>length2) {
						j=0;
					}
				}
				else
					break;
				}
				for(int i=0; i<length; i++) { //This copies the new formulated string to an array
					bellaso[i] = bellasoStr.charAt(i);
				}
				for(int i = 0; i<length; i++) { //This is used to decrypt the code
					decrypt[i] -= bellaso[i];
				
					while(decrypt[i]<32 || decrypt[i] > 95) { //This makes sure that the result is in the range.
					decrypt[i] += 64;
				}
				newString += decrypt[i];  //Copying the decrypted chars into a string

				}
			
		return newString;
			 }
	}
}

	