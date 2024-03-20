import org.junit.Assert;
import org.junit.Test;

public class MD5Test {
    @Test
    public void testCodificar() {

        MD5 MD5 = new MD5();
        String Pi = MD5.Codificar("Pedro");
        Assert.assertEquals("38e2b2e31c0fce9537f735dda9fdf10a", Pi);
        
    }
}
