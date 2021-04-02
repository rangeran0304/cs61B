public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String  imgFileName;
    public static  Double G = 6.67e-11;
    public Planet(double xP, double yP,double xV, double yV,double m, String  img){
        xxPos=xP;
        yyPos=yP;
        xxVel=xV;
        yyVel=yV;
        mass=m;
        imgFileName=img;
    }
    public Planet(Planet p){
        this.yyVel=p.yyVel;
        this.xxVel=p.xxVel;
        this.xxPos=p.xxPos;
        this.yyPos=p.yyPos;
        this.mass =p.mass;
        this.imgFileName=p.imgFileName;
    }
    public double calcDistance( Planet p){
        return Math.sqrt(Math.pow(p.xxPos-this.xxPos,2)+Math.pow(p.yyPos-this.yyPos,2));
    }
    public  double calcForceExertedBy(Planet p){
        return G*p.mass*this.mass/Math.pow(this.calcDistance(p),2);
    }
    public double calcNetForceExertedByX (Planet[] p_array){
        double Force_x=0;
        for (int i=0; i<p_array.length;i++){
            if (this.calcDistance(p_array[i])==0){
                continue;
            }
            double dx=p_array[i].xxPos-this.xxPos;
            Force_x+=this.calcForceExertedBy(p_array[i])*dx/this.calcDistance(p_array[i]);
        }
        return Force_x;
    }
    public double calcNetForceExertedByY (Planet[] p_array){
        double Force_y=0;
        for (int i=0; i<p_array.length;i++){
            if (this.calcDistance(p_array[i])==0){
                continue;
            }
            double dy=p_array[i].yyPos-this.yyPos;
            Force_y+=this.calcForceExertedBy(p_array[i])*dy/this.calcDistance(p_array[i]);
        }
        return Force_y;
    }
    public void update(double dt, double fx, double fy){
        double a_x= fx / this.mass;
        double a_y= fy / this.mass;
        this.xxVel += a_x*dt;
        this.yyVel += a_y*dt;
        this.xxPos += dt*this.xxVel;
        this.yyPos += dt*this.yyVel;
    }
    public void draw(){
        String path = "images/"+this.imgFileName;
        StdDraw.picture(this.xxPos,this.yyPos,path);
    }

}
