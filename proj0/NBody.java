import java.util.Scanner;

public class NBody {
    public static double readRadius(String name){
        In file = new In(name);
        int firstitem = file.readInt();
        double seconditem = file.readDouble();
        return seconditem;
    }
    public static Planet[] readPlanets(String name){
        In file2 = new In(name);
        int firstitem = file2.readInt();
        Planet[] planets = new Planet[firstitem];
        double seconditem = file2.readDouble();
        for (int i = 0; i<firstitem; i++){
            double xxPos = file2.readDouble(),
                    yyPos = file2.readDouble(),
                    xxVel = file2.readDouble(),
                    yyVel = file2.readDouble(),
                    mass = file2.readDouble();
            String imgFileName = file2.readString();
            planets[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
        }
        return planets;
    }
    public static void main (String[] args){
        double T;
        T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        /*String filename = "./data/planets.txt";*/
        double radius = NBody.readRadius(filename);
        Planet[] planets = NBody.readPlanets(filename);
        StdDraw.setScale(-radius, radius);
        String Universepath = "images/starfield.jpg";
        StdDraw.enableDoubleBuffering();
        StdDraw.picture(0,0,Universepath);
        for(int i=0; i<planets.length;i++){
            planets[i].draw();
        }
        double initT = 0.0;
        while(initT<T){
            double[] xForces=new double[planets.length];
            double[] yForces=new double[planets.length];
            for(int i = 0 ; i<planets.length; i++){
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for(int j = 0; j<planets.length; j++){
                planets[j].update(dt, xForces[j], yForces[j]);
            }
            StdDraw.picture(0,0,Universepath);
            for(int i=0; i<planets.length;i++){
                planets[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            initT+=dt;
        }
    }
}
