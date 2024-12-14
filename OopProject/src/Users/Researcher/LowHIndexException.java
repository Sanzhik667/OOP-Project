package Users.Researcher;

//Custom Exception for low h-index
public class LowHIndexException extends Exception {
	
 public LowHIndexException(String message) {
     super(message);
 }  
}
