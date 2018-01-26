package rectangles;

public class Point {

  // Fields
  private final int x;
  private final int y;

  // Constructors
  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public Point() {
    this(0, 0);
  }

  public Point(int x) {
    this(x, 0);
  }

  // Methods
  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public Point setX(int newX) {
    return new Point(newX, this.y);
  }

  public Point setY(int newY) {
    return new Point(this.x, newY);
  }

  public boolean isLeftOf(Point other) {
    return this.x < other.getX();
  }

  public boolean isRightOf(Point other) {
    return this.x > other.getX();
  }

  public boolean isAbove(Point other) {
    return this.y < other.getY();
  }

  public boolean isBelow(Point other) {
    return this.y > other.getY();
  }

  public Point add(Point vector) {
    return new Point(this.x + vector.getX(), this.y + vector.getY());
  }
}