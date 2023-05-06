import java.math.BigInteger;

public class IBAN {
    
    private String iban;
    public IBAN(){

    }

    public IBAN(String i){
        setIban(i);
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getIban() {
        return iban;
    }

    public boolean verifica_Iban(){


        if (iban == null || iban.equals("")){
            throw new NullPointerException("codice iban vuoto");
        }        
      

        if (iban.length() != 27){
            return false;
        }
        String primi_4 = iban.substring(0, 4);
        
    
        String num = iban.substring(4, 27);
        

        iban = num + primi_4;
    
        StringBuilder sb = new StringBuilder();
        for (char c : iban.toCharArray()) {
            if (Character.isLetter(c)) {
                sb.append(Character.getNumericValue(c));
            } else {
                sb.append(c);
            }
        }
        String ibanNum = sb.toString();

        BigInteger ibanInt = new BigInteger(ibanNum);
        BigInteger risultato = ibanInt.mod(new BigInteger("97"));
        
        // stampa del risultato
        return risultato.intValue() == 1;
    }
}
