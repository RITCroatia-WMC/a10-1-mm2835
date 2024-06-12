package part1;

/*
@ASSESSME.USERID: userID
@ASSESSME.AUTHOR: author, list of authors
@ASSESSME.LANGUAGE: JAVA
@ASSESSME.DESCRIPTION: ASS10.1
@ASSESSME.ANALYZE: YES
*/

public class Woolie implements Runnable {
    private String name;
    private int crossingTime;
    private String startCity;
    private String endCity;
    
    public Woolie(String name, int crossingTime, String startCity, String endCity) {
        this.name = name;
        this.crossingTime = crossingTime;
        this.startCity = startCity;
        this.endCity = endCity;
    }
    @Override
    public void run() {
        try {
            System.out.println(name + " has arrived at the bridge at " + startCity + ".");
            System.out.println(name + " is starting to cross ");
            for (int i = 1, i<= crossingTime; i++) {
                System.out.println("\t" + name + ":" + i + " seconds.");
                Thread.sleep(1000);
            }
            System.out.println(name + " arrives at " + endCity + ".");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Thread woolie1 = new Thread(new Woolie("Ahmed", 5, "Courtwald", "Glassdell"));
        Thread woolie2 = new Thread(new Woolie("Chris", 6, "Glassdell", "Courtwald"));
        Thread woolie3 = new Thread(new Woolie("Bruce", 7, "Courtwald", "Glassdell"));
        Thread woolie4 = new Thread(new Woolie("Bobby", 8, "Glassdell", "Courtwald"));

        woolie1.start();
        woolie2.start();
        woolie3.start();
        woolie4.start();
    }
}