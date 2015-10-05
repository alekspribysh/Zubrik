import com.service.ValidateDoctor;
import com.service.ValidateUser;
import org.testng.annotations.Test;
import org.testng.*;



/**
 * Created by alekspribysh on 9/23/15.
 */
public class TestLogin {

    ValidateUser valid = new ValidateUser();
    ValidateDoctor validDoc = new ValidateDoctor();
    private String name = "aleks";
    private String passcode = "aleksandr";
    private String fullName = "Aliaksandr Prybysh";
    private String email = "aleks@gmail";
    private String spec = "physician";

    @Test
    public void log_in()  {

       // Assert.assertEquals(valid.validLoginPassword(name, passcode), true);
    }

    @Test
    public void createUser()  {

        //Assert.assertEquals(valid.validAddUser(name, passcode,fullName, email), true);
    }

    @Test
    public void createDoctor()  {

 //       Assert.assertEquals(validDoc.createDoctors(fullName,spec,email), true);
    }
}
