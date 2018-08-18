import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShipDamage! {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int X1 = in.nextInt();
        int Y1 = in.nextInt();
        int X2 = in.nextInt();
        int Y2 = in.nextInt();
        Point topLeft = null;
        Point topRight = null;
        Point bottomLeft = null;
        Point bottomRight = null;
        if (X1 > X2 && Y1 > Y2){
            topRight = new Point(X1, Y1);
            bottomLeft = new Point(X2, Y2);
            topLeft = new Point(X2, Y1);
            bottomRight = new Point(X1, Y2);
        } else if (X1 < X2 && Y1 > Y2){
            topLeft = new Point(X1, Y1);
            bottomRight = new Point(X2, Y2);
            topRight = new Point(X2, Y1);
            bottomLeft = new Point(X1, Y2);
        } else if (X1 > X2 && Y1 < Y2){
            bottomRight = new Point(X1, Y1);
            topLeft = new Point(X2, Y2);
            bottomLeft = new Point(X2, Y1);
            topRight = new Point(X1, Y2);
        } else if (X1 < X2 && Y1 < Y2){
            bottomLeft = new Point(X1, Y1);
            topRight = new Point(X2, Y2);
            bottomRight = new Point(X2, Y1);
            topLeft = new Point(X1, Y2);
        }

        int H = in.nextInt();
        int Cx1 = in.nextInt();
        int Cy1 = in.nextInt();
        int Cx2 = in.nextInt();
        int Cy2 = in.nextInt();
        int Cx3 = in.nextInt();
        int Cy3 = in.nextInt();

        int quadrant1 = determineInWhichQuadrantIsThePoint(Cx1, Cy1);
        int quadrant2 = determineInWhichQuadrantIsThePoint(Cx2, Cy2);
        int quadrant3 = determineInWhichQuadrantIsThePoint(Cx3, Cy3);

        Point oppositePoint1 = getOppositePointOf(Cx1, Cy1, H, quadrant1);
        Point oppositePoint2 = getOppositePointOf(Cx2, Cy2, H, quadrant2);
        Point oppositePoint3 = getOppositePointOf(Cx3, Cy3, H, quadrant3);

        int result = getDamage(oppositePoint1, oppositePoint2, oppositePoint3, topLeft, topRight, bottomLeft, bottomRight);

        System.out.println(result + "%");
    }

    private static class Point {
        private int X;
        private int Y;

        public Point(int X, int Y){
            this.setX(X);
            this.setY(Y);
        }

        public int getX() {
            return X;
        }

        public void setX(int x) {
            X = x;
        }

        public int getY() {
            return Y;
        }

        public void setY(int y) {
            Y = y;
        }

        @Override
        public boolean equals(Object obj) {
            Point other = (Point) obj;
            return this.getX() == other.getX() && this.getY() == other.getY();
        }
    }

    private static int getDamage(Point oppositePoint1, Point oppositePoint2, Point oppositePoint3, Point topLeft, Point topRight, Point bottomLeft, Point bottomRight) {
        int damage1 = getDamageOfPoint(oppositePoint1, topLeft, topRight, bottomLeft, bottomRight);
        int damage2 = getDamageOfPoint(oppositePoint2, topLeft, topRight, bottomLeft, bottomRight);
        int damage3 = getDamageOfPoint(oppositePoint3, topLeft, topRight, bottomLeft, bottomRight);
        return damage1 + damage2 + damage3;
    }

    private static int getDamageOfPoint(Point point, Point topLeft, Point topRight, Point bottomLeft, Point bottomRight) {
        boolean liesOnLeft = onLeft(point, topLeft, bottomLeft);
        boolean liesOnTop = onTop(point, topLeft, topRight);
        boolean liesOnRight = onRight(point, topRight, bottomRight);
        boolean liesOnBottom = onBottom(point, bottomLeft, bottomRight);

        if ((bottomLeft.getX() < point.getX() && point.getX() < topRight.getX()) && (bottomLeft.getY() < point.getY() && point.getY() < topRight.getY())){
            return 100;
        } else if (liesOnLeft || liesOnTop || liesOnRight || liesOnBottom){
            return 50;
        } else if (point.equals(topLeft) || point.equals(topRight) || point.equals(bottomLeft) || point.equals(bottomRight)){
            return 25;
        }

        return 0;
    }

    private static boolean onRight(Point point, Point topRight, Point bottomRight) {
        return point.getX() == topRight.getX() && bottomRight.getY() < point.getY() && point.getY() < topRight.getY();
    }

    private static boolean onBottom(Point point, Point bottomLeft, Point bottomRight) {
        return point.getY() == bottomLeft.getY() && bottomLeft.getX() < point.getX() && point.getX() < bottomRight.getX();
    }

    private static boolean onTop(Point point, Point topLeft, Point topRight) {
        return point.getY() == topLeft.getY() && topLeft.getX() < point.getX() && point.getX() < topRight.getX();
    }

    private static boolean onLeft(Point point, Point topLeft, Point bottomLeft) {
        return point.getX() == topLeft.getX() && bottomLeft.getY() < point.getY() && point.getY() < topLeft.getY();
    }

    private static Point getOppositePointOf(int x, int y, int h, int quadrant) {
        if (x == 0 && y > 0){
            return new Point(x, h - (y - h));
        } else if (x == 0 && y < 0){
            return new Point(x, h + (h - y));
        } else if (y == 0 && h > 0){
            return new Point(x, h + (h - y));
        } else if (y == 0 && h < 0){
            return new Point(x, h - (y - h));
        }

        if (quadrant == 1 || quadrant == 2){
            return new Point(x, h - (y - h));
        } else if (quadrant == 3 || quadrant == 4){
            return new Point(x, h + (h - y));
        }

        return null;
    }

    private static int determineInWhichQuadrantIsThePoint(int x, int y) {
        if (x > 0 && y > 0){
            return 1;
        } else if (x < 0 && y > 0){
            return 2;
        } else if (x < 0 && y < 0){
            return 3;
        } else if (x > 0 && y < 0){
            return 4;
        }

        return 0;
    }
}
