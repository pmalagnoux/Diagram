package metier;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class Securite {
	
	@WebMethod(operationName="encrypt")
	public String encrypt(@WebParam(name="password")String password) {
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
			String encoded = Base64.getEncoder().encodeToString(hash);
			return encoded;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
		}
	@WebMethod(operationName="mailIsValid")
	public boolean mailIsValid(@WebParam(name="email")String email) {
        if (email.endsWith(".fr") || email.endsWith(".com") )
            if (email.indexOf("@")>0)return true;
        
        return false;
    }
	
}
