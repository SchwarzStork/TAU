using System;
using System.Collections.Generic;
using System.Text;

namespace GeometryRobot
{
    public enum QuadrangleType
    {
        Square = 1, // all sides equal
        Rectangle = 2, // 2 opposite sides are equal
        Error = 3 //its neither a rectangle or square
    }
    class Quadrangle
    {
        public QuadrangleType QuadrangleType { get; private set; }
        public int sideA { get; private set; }
        public int sideB { get; private set; }
        public int sideC { get; private set; }
        public int sideD { get; private set; }

        public Quadrangle(int a, int b, int c, int d)
        {
            sideA = a;
            sideB = b;
            sideC = c;
            sideD = d;
            QuadrangleType = GetQuadrangleType(a, b, c, d);
        }

        public static QuadrangleType GetQuadrangleType(int a, int b, int c, int d)
        {
            if (a <= 0 || b <= 0 || c <= 0 || d <= 0)
            {
                return QuadrangleType.Error;
            }
            if (a == b && a == c && a == d || b == a && b == c && c == d || c == a && c == b && c == d || d == a && d == b && d == c)
            {
                return QuadrangleType.Square;
            }
            else if (a == c && b == c)
            {
                return QuadrangleType.Rectangle;
            }
            else
            {
                return QuadrangleType.Error;
            }
        }

    }
}
