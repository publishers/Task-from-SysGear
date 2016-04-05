import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Sergey ML on 28.07.14.
 * How does it work?
 * This class read line from a file.
 * Creating array of domains: if array size = 0 then add the point to the domains.
 * if array size != 0 check if the point to belong to the one of the consist points of the domains
 * if is true add the point to domains and the mark increases
 * if it's belong to the second or more point of the consist points of the domains then 
 * add the point to domains and the mark decreases
 * else just add the new point. 
 */
public class NumberDomains {
    private File file;
    private Scanner scann;
    private ArrayList<FieldDomain> domains = new ArrayList();
    private int j = 0;
    private int numberDomains;

    public int getNumberDomains() {
        return numberDomains;
    }

    public NumberDomains(String fileName)  {
        if(new File(fileName).exists()) {
            try {
                file = new File(fileName);
                scann = new Scanner(file);
                numberDomains = 0;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        else System.err.println("File not exist");
    }

    public void scannFile(){
        while(scann.hasNext()){
            writeToDomain(scann.nextLine().getBytes());
        }
    }

    private void testOnDomain(int i, int j) {
        int numberOfCompresions = 0;
        for(int t = 0; t< domains.size(); t++) {
            if (lengthBetweenPoints(domains.get(t).i, i, domains.get(t).j, j)) {
                numberOfCompresions++;
            }
        }

        if(numberOfCompresions == 2) {
            domains.add(new FieldDomain(i, j));
            numberDomains--;
        }else if(numberOfCompresions == 0){
            domains.add(new FieldDomain(i, j));
            numberDomains++;
        }else {
            domains.add(new FieldDomain(i, j));
        }
    }

    private void writeToDomain(byte[] bytes) {
        for (int i = 0; i < bytes.length; i++) {
            if(bytes[i]-(byte)48 == 1) {
                if (domains.size() == 0) {
                    domains.add(new FieldDomain(this.j, i));
                    numberDomains++;
                }
                else {
                    testOnDomain(this.j, i);
                }
            }
        }
        this.j++;
    }

    private boolean lengthBetweenPoints(int x1, int x2, int y1, int y2) {
        return (Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)) == 1) ? true : false;
    }

    public String toString(){
        return ""+numberDomains;
    }

}

