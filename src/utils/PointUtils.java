package utils;

public class PointUtils {
  public static double lengthBetweenPoints(int x1, int x2, int y1, int y2) {
    return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
  }
}
