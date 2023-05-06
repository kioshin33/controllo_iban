import java.math.BigInteger;


/**
 * il funzionamento della classe consiste nel verificare la viliditá di un IBAN 
 * @author Fabrizio La  Volpe
 * @version 1.2
 */
public class IBAN {
    
    private String iban;
    /**
     * costruttore, creatore di nuovi oggetti
     */
    public IBAN(){

    }
    /**
     * Metodo Costruttore che setta un nuovo iban come oggetto IBAN
     * @param i codice iban
     * */ 
    public IBAN(String i){
        setIban(i);
    }
    /**
     * metodo per settare iban come ogetto IBAM
     * @param iban codice iban
     */
    public void setIban(String iban) {
        this.iban = iban;
    }
    /**
     * Metodo per stampare il codice iban
     * @return ritorna il codice iban come stringa 
     */
    public String getIban() {
        return iban;
    }
    /**
    * Metodo per controllare la validitá del codice iban
    * @return vero se l'iban é coretto altrimenti falso 
    * @throws NullPointerException l'iban puo essere vuoto oppure non valido 
    */
    public boolean verifica_Iban(){

        // verifica che il codice iban é vuoto
        if (iban == null || iban.equals("")){
            throw new NullPointerException("codice iban vuoto");
        }        
      
        // Verifica la corretta lunghezza del codice iban
        if (iban.length() != 27){
            return false;
        }

        
        // prende i primi 4 caratteri del codice 
        String primi_4 = iban.substring(0, 4);
        
        
        // prende tutti gli altri caratteri del codice 
        
        String num = iban.substring(4, 27);
        
        // mette i primi 4 caratteri presi in precedenza e li aggiunge alla fine del codice
        iban = num + primi_4;
        
        // Converte le lettere in numeri
        StringBuilder sb = new StringBuilder();
        for (char c : iban.toCharArray()) {
            if (Character.isLetter(c)) {
                sb.append(Character.getNumericValue(c));
            } else {
                sb.append(c);
            }
        }
        String ibanNum = sb.toString();


        // Converte da stringa in intero e verifica il modulo 97
        BigInteger ibanInt = new BigInteger(ibanNum);
        BigInteger risultato = ibanInt.mod(new BigInteger("97"));
        
        // stampa del risultato
        return risultato.intValue() == 1;
    }
}
