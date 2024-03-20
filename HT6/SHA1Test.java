import org.junit.Assert;
import org.junit.Test;

public class SHA1Test {
    @Test
    public void testCodificar() {

        SHA1 SHA1 = new SHA1();
        String Pe = SHA1.Codificar("Pedro");
        Assert.assertEquals("89b896402d8c3d208029b5b46597910af7e34a66", Pe);

    }
}
