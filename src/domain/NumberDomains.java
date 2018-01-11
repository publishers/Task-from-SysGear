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
    file = new File(fileName);
  }

  public void findDomainsFromFile() throws FileNotFoundException {
    scann = new Scanner(file);
    while (scann.hasNext()) {
      findDomains(scann.nextLine().getBytes());
    }
  }

  private void findDomains(byte[] bytes) {
    for (int i = 0; i < bytes.length; i++) {
      if (isDomain(bytes[i])) {
        processNewDomain(this.lineFromFile, i);
      }
    }
    this.lineFromFile++;
  }

  private boolean isDomain(byte domain) {
    return domain - (byte) 48 == 1;
  }

  private void processNewDomain(int i, int j) {
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

