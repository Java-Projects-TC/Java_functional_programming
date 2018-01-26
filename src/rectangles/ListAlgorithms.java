package rectangles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListAlgorithms {

  /**
   * Returns a new list of rectangles by translating (moving) each rectangle
   * according to the given distance vector.
   *
   * @param rectangles The rectangles to be translated
   * @param vector The distance vector
   * @return The translated rectangles
   */
  public static List<Rectangle> translate(List<Rectangle> rectangles,
      Point vector) {
    List<Rectangle> result = new ArrayList<>();
    for (Rectangle rectangle : rectangles) {
      result.add(new Rectangle(rectangle.getTopLeft().add(vector), rectangle
          .getBottomRight().add(vector)));
    }
    return result;
  }

  /**
   * Returns a new list of rectangles by scaling each rectangle by a given
   * amount.
   *
   * @param rectangles The rectangles to be scaled
   * @param factor A non-negative scale factor
   * @return The scaled rectangles
   */
  public static List<Rectangle> scale(List<Rectangle> rectangles, int factor) {
    List<Rectangle> result = new ArrayList<>();
    for (Rectangle rectangle : rectangles) {
      // Why not just:
      // rectangle.setWidth(rectangle.getWidth * factor)
      // rectangle.setHeight(rectangle.getHeight * factor)
      result.add(new Rectangle(rectangle.getTopLeft(), rectangle.getWidth() *
          factor, rectangle.getHeight() * factor));
    }
    return result;
  }

  /**
   * Returns a list containing, in order, the bottom-left point of each input
   * rectangle.
   */
  public static List<Point> getBottomLeftPoints(List<Rectangle> rectangles) {
    List<Point> result = new ArrayList<>();
    for (Rectangle rectangle : rectangles) {
      result.add(rectangle.getBottomLeft());
    }
    return result;
  }

  /**
   * Returns a list containing all rectangles that intersect with the given
   * rectangle.
   *
   * @param rectangles A list of rectangles to be checked for intersection
   * @param rectangle The rectangle against which intersection should be
   * checked
   * @return All rectangles that do intersect with the given rectangle
   */
  public static List<Rectangle> getAllIntersecting(List<Rectangle> rectangles,
      Rectangle rectangle) {
    List<Rectangle> result = new ArrayList<>();
    for (Rectangle rect : rectangles) {
      if (rect.intersects(rectangle)) {
        result.add(rect);
      }
    }
    return result;
  }

  /**
   * Returns a list containing all rectangles with a bigger area than the given
   * rectangle.
   *
   * @param rectangles A list of rectangles whose area is to be checked
   * @param rectangle The rectangle against which areas are to be compared
   * @return All rectangles that have a larger area than the given rectangle
   */
  public static List<Rectangle> getAllWithBiggerAreaThan(
      List<Rectangle> rectangles,
      Rectangle rectangle) {
    List<Rectangle> result = new ArrayList<>();
    for (Rectangle rect : rectangles) {
      if (rect.area() > rectangle.area()) {
        result.add(rect);
      }
    }
    return result;
  }

  /**
   * Returns the largest area among the given rectangles.
   */
  public static int findLargestArea(List<Rectangle> rectangles) {
    int maxArea = 0;
    for (Rectangle rectangle : rectangles) {
      if (rectangle.area() > maxArea) {
        maxArea = rectangle.area();
      }
    }
    return maxArea;
  }

  /**
   * Returns the largest height among all the given rectangles.
   */
  public static int findMaxHeight(List<Rectangle> rectangles) {
    int maxHeight = 0;
    for (Rectangle rectangle : rectangles) {
      if (rectangle.getHeight() > maxHeight) {
        maxHeight = rectangle.getHeight();
      }
    }
    return maxHeight;
  }

  /**
   * Computes the sum of areas of all the given rectangles.
   */
  public static int getSumOfAreas(List<Rectangle> rectangles) {
    int result = 0;
    for (Rectangle rectangle : rectangles) {
      result += rectangle.area();
    }
    return result;
  }

  /**
   * Computes the sum of areas of all rectangles that intersect with the given
   * rectangle.
   *
   * @param rectangles The rectangles whose areas to be considered and summed
   * @param rectangle The rectangle with which intersection is to be checked
   * @return The sum of areas of all rectangles that do intersect with the given
   * rectangle
   */
  public static int getSumOfAreasOfAllIntersecting(List<Rectangle> rectangles,
      Rectangle rectangle) {
    return getSumOfAreas(getAllIntersecting(rectangles, rectangle));
  }

  /**
   * Returns collection that maps each rectangle to its computed area.
   */
  public static Map<Rectangle, Integer> getAreaMap(List<Rectangle> rectangles) {
    Map<Rectangle, Integer> areaMap = new HashMap<>();
    for (Rectangle rectangle : rectangles) {
      areaMap.put(rectangle, rectangle.area());
    }
    return areaMap;
  }

}
