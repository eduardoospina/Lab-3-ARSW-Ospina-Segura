package edu.eci.arsw.blacklistvalidator;

import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;

import java.util.LinkedList;

public class Hilo extends  Thread{

    private int a;
    private int b;
    private String ip;
    private HostBlacklistsDataSourceFacade skds = HostBlacklistsDataSourceFacade.getInstance();
    public static int contador = 0;
    public static int checkedLists=0;
    public static LinkedList<Integer> blackListOcurrences=new LinkedList<>();

    Hilo(int a, int b, String ip){
        this.a = a;
        this.b = b;
        this.ip = ip;
    }

    public synchronized void count(){
        contador++;
    }

    public synchronized void countList(){
        checkedLists++;
    }

    public void run(){
        try {
            for (int i = a; i < b && contador < HostBlackListsValidator.BLACK_LIST_ALARM_COUNT; i++) {
                countList();
                if (skds.isInBlackListServer(i, ip)){
                    blackListOcurrences.add(i);
                    count();
                }
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
}
