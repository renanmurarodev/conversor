package Main;

import Model.Coins;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class History {
    private Scanner reader;
    List<Coins> historyConverter = new ArrayList<>();

    public History(Scanner reader) {
        this.reader = reader;
    }

    public void Add(Coins coins){
        historyConverter.add(coins);
    }

    public void TestHistory(){
        if (!historyConverter.isEmpty()){
            System.out.println("\n Aqui o histórico de conversão: \n");
            for(Coins it : historyConverter){
                System.out.println("- " + it);
            }
        }else{
            System.out.println("\nHistórico vazio\n");
        }
    }

}
