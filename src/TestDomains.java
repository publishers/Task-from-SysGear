import domain.NumberDomains;

public class TestDomains {
  public static void main(String[] args) {
    NumberDomains domainsFromFile = new NumberDomains("testFile.txt");
    domainsFromFile.readFile();
    System.out.println(domainsFromFile.getNumberDomains());
  }
}
