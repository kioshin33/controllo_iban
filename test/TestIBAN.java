import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class TestIBAN {

    private IBAN iban;
    @Before
    public void init(){
        iban = new IBAN();
    }

    @Test 
    public void testVerificaIbanValido(){
        iban.setIban("IT39S0300203280758493646878");
        assertTrue(iban.verifica_Iban());
    }

    @Test
    public void testVerificaIbanNonValido(){
        iban.setIban("IT39S0300203280758493646878");
        assertFalse(iban.verifica_Iban());
    }

    @Test
    public void testVerificaLunghezzaIbanNonValido(){
        iban.setIban("IT39S0300203280758493646878");
        assertFalse(iban.verifica_Iban);
    }

    @Test
    public void testVerificaIbanVuoto(){
        iban.setIban("IT39S0300203280758493646878");
        assertThrows(NullPointerException.class,null);    }




}
