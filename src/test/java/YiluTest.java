import org.junit.Test;

import static org.junit.Assert.*;

public class YiluTest{

    @Test
    public void testGetFirstNonRepeatedChar(){
        String str = "Hello";
        String str2 = "RRonnie";

        assertEquals(
                YiluService.getFirstNonRepeatedChar(str).orElse(""),
                "H");

        assertEquals(
                YiluService.getFirstNonRepeatedChar(str2).orElse(""),
                "o");
    }

    @Test
    public void testIsRotation(){
        String a = "Hola";
        String b = "aloH";

        String c = "bye";
        String d = "yeb";

        String e = "anita lava la tina";
        String f = "anit al aval atina";

        assertTrue(YiluService.isRotation(a, b));
        assertFalse(YiluService.isRotation(c, d));
        assertTrue(YiluService.isRotation(e, f));
    }
}