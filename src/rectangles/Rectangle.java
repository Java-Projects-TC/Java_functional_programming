package rectangles;

import java.util.Optional;

public class Rectangle {

  // Fields
  private final Point topLeft;
  private final Point bottomRight;

  // Constructors
  public Rectangle(Point topLeft, Point bottomRight) {
    int largeX, smallX, largeY, smallY;
    if (topLeft.getX() <= bottomRight.getX()) {
      smallX = topLeft.getX();
      largeX = bottomRight.getX();
    } else {
      smallX = bottomRight.getX();
      largeX = topLeft.getX();
    }
    if (topLeft.getY() <= bottomRight.getY()) {
      smallY = topLeft.getY();
      largeY = bottomRight.getY();
    } else {
      smallY = bottomRight.getY();
      largeY = topLeft.getY();
    }
    this.topLeft = new Point(smallX, smallY);
    this.bottomRight = new Point(largeX, largeY);
  }

  public Rectangle(Point topLeft, int width, int height) {
    this(topLeft, topLeft.add(new Point(width, height)));
  }

  public Rectangle(int w, int h) {
    this(new Point(0, 0), new Point(w, h));
  }

  // Methods
  public int getWidth() {
    return this.bottomRight.getX() - this.topLeft.getX();
  }

  public int getHeight() {
    return this.bottomRight.getY() - this.topLeft.getY();
  }

  public Rectangle setWidth(int newWidth) {
    return new Rectangle(this.topLeft, newWidth, this.getHeight());
  }


  public Rectangle setHeight(int newHeight) {
    return new Rectangle(this.topLeft, this.getWidth(), newHeight);
  }

  public Point getTopLeft() {
    return this.topLeft;
  }

  public Point getTopRight() {
    return new Point(this.bottomRight.getX(), this.topLeft.getY());
  }

  public Point getBottomLeft() {
    return new Point(this.topLeft.getX(), this.bottomRight.getY());
  }

  public Point getBottomRight() {
    return this.bottomRight;
  }

  public int area() {
    return this.getWidth() * this.getHeight();
  }

  public boolean intersects(Rectangle other) {

    return !(other.getBottomLeft().isAbove(this.getTopLeft()) ||
        other.getBottomLeft().isRightOf(this.getTopRight()) ||
        this.getBottomLeft().isAbove(other.getTopLeft()) ||
        this.getBottomLeft().isRightOf(other.getTopRight()));

    /* I had this horrible messy thing below before changing it to this

    return other.getBottomRight().getX() >= this.getTopLeft().getX() &&
        other.getBottomRight().getY() >= this.getTopLeft().getY() &&
        other.getBottomLeft().getX() <= this.getTopRight().getX() &&
        other.getBottomLeft().getY() >= this.getTopRight().getY() &&
        other.getTopRight().getX() >= this.getBottomLeft().getX() &&
        other.getTopRight().getY() <= this.getBottomLeft().getY() &&
        other.getTopLeft().getX() <= this.getBottomRight().getX() &&
        other.getTopLeft().getY() <= this.getBottomRight().getY();
        */
  }

  public Optional<Rectangle> intersection(Rectangle other) {
    if (!this.intersects(other)) {
      return Optional.empty();
    }
    return Optional.of(new Rectangle(
        new Point(Math.max(this.getTopLeft().getX(), other.getTopLeft().getX()),
            Math.max(this.getTopLeft().getY(), other.getTopLeft().getY())),
        new Point((Math.min(this.getBottomRight().getX(),
            other.getBottomRight().getX())),
            Math.min(this.getBottomRight().getY(),
                other.getBottomRight().getY()))));
  }

}
