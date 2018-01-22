package rectangles;

public class Rectangle {

  // Fields
  private final int x1;
  private final int x2;
  private final int y1;
  private final int y2;

  // Could I have a field for HEIGHT and WIDTH in terms of x1,x2, y1 and y2

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
}