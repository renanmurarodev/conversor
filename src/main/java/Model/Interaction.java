package Model;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Interaction {
    public void textMain() {

        System.out.println(


                        """ 
                        
                        -- Menu do Conversor de Moedas --
                        
                        1 - Real para Dólar (BRL-USD)
                        2 - Dólar para Real (USD-BRL)
                        3 - Real para Euro (BRL-EUR)
                        4 - Euro para Real (EUR-BRL)
                        5 - Real para Dólar Autraliano (BRL-AUD)                        
                        6 - Dólar Autraliano para Real (AUD-BRL)
                                               
                        7 - Salvar ou Exibir o Histórico"
                        8 = Sair
                        
                        """
        );
    }

    public int Check(Scanner reader) {
        int key = 0;
        while (true) {
            try {
                key = reader.nextInt();
                if (key < 1 || key > 8) {
                    System.out.println("Inválido! Digite um número entre 1 e 8.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Inválido! Digite um número entre 1 e 8.\n");
                reader.nextLine();
            }
        }
        return key;
    }
}

