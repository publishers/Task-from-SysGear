package domain;

import utils.PointUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class NumberDomains {
  private File file;
  private Scanner scann;
  private ArrayList<FieldDomain> domains;
  private int lineFromFile;
  private int numberDomains;

  public int getNumberDomains() {
    return numberDomains;
  }

  public NumberDomains(String fileName) {
    domains = new ArrayList<>();
    if (new File(fileName).exists()) {
      try {
        file = new File(fileName);
        scann = new Scanner(file);
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
    } else System.err.println("File not exist");
  }

  public void readFile() {
    while (scann.hasNext()) {
      writeToDomain(scann.nextLine().getBytes());
    }
  }

  private void writeToDomain(byte[] bytes) {
    for (int i = 0; i < bytes.length; i++) {
      if (isDomain(bytes[i])) {
        checkNewDomain(this.lineFromFile, i);
      }
    }
    this.lineFromFile++;
  }

  private boolean isDomain(byte domain){
    return domain - (byte) 48 == 1;
  }

  private void checkNewDomain(int i, int j) {
    int intersectionDomains = 0;
    for (FieldDomain domain : domains) {
      if (PointUtils.lengthBetweenPoints(domain.x, i, domain.y, j) == 1) {
        intersectionDomains++;
      }
    }
    domains.add(new FieldDomain(i, j));
    checkDomains(intersectionDomains);
  }

  private void checkDomains(int intersectionDomains) {
    if (intersectionDomains == 2) {
      numberDomains--;
    } else if (intersectionDomains == 0) {
      numberDomains++;
    }
  }

  public String toString() {
    return "" + numberDomains;
  }

}

