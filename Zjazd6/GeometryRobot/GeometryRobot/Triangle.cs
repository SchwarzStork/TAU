using System;
using System.Collections.Generic;
using System.Text;

namespace GeometryRobot
{
    public enum TriangleType
    {
        Scalene = 1, // no two sides are the same length
        Isosceles =  2, // only two sides are the same length
        Equilateral = 3, // all sides have the same length
        Error = 4 // sides cant create a triangle
    }
    class Triangle
    {
        public TriangleType TriangleType { get; private set; }
        public int sideA { get; private set; }
        public int sideB { get; private set; }
        public int sideC { get; private set; }

        public Triangle(int a, int b, int c)
        {
            sideA = a;
            sideB = b;
            sideC = c;
            TriangleType = GetTriangleType(a, b, c);
        }

        public static TriangleType GetTriangleType(int a, int b, int c)
        {
            if( a<=0 || b<=0 || c <= 0)
            {
                return TriangleType.Error;
            }
            if (a == b && a == c || b == c && b == a || c == a && c == b)
            {
                return TriangleType.Equilateral;
            }
            else if (a == b || a == c || b == c)
            {
                return TriangleType.Isosceles;
            }
            else
            {
                return TriangleType.Scalene;
            }
        }
    }
}
