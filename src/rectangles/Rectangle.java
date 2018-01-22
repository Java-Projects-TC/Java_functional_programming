package rectangles;

public class Rectangle {

  // Fields
  private final int x1;
  private final int x2;
  private final int y1;
  private final int y2;

  // Constructors
  public Rectangle(Point topLeft, int width, int height) {
    this.x1 = topLeft.getX();
    this.y1 = topLeft.getY();
    this.x2 = this.x1 + width;
    this.y2 = this.y1 + height;
  }

  public Rectangle(Point topLeft, Point bottomRight) {
    this(topLeft, bottomRight.getX() - topLeft.getX(), bottomRight.getY() -
        topLeft.getY());
  }

  public Rectangle(int w, int h) {
    this(new Point(), w, h);
  }

  // Methods
  public int getWidth() {
    return this.x2 - this.x1;
  }

  public int getHeight() {
    return this.y2 - this.y1;
  }

  public Rectangle setWidth(int newWidth) {
    return new Rectangle(new Point(this.x1,this.y1), newWidth, this.y2 -
        this.y1);
  }


  public Rectangle setHeight(int newHeight) {
    return new Rectangle(new Point(this.x1, this.y1), this.x2 - this.x1,
        newHeight);
  }

  public Point getTopLeft() {
    return new Point(this.x1, this.y1);
  }

  public Point getTopRight() {
    return new Point(this.x2, this.y1);
  }

  public Point getBottomLeft() {
    return new Point(this.x1, this.y2);
  }

  public Point getBottomRight() {
    return new Point(this.x2, this.y2);
  }

  public int area() {
    return this.x2 - this.x1 * this.y2 - this.y1;
  }

  public boolean intersects(Rectangle other) {
    // loop through all points in current rectangle and see if the other
    // rectangle contains any of them
    return false;
  }

  private boolean contains(Point point) {
    return this.x1 <= point.getX() && this.x2 >= point.getX() && this.y1 <=
        point.getY() && this.y2 >= point.getY();
  }
}