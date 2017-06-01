
public class Estado {
    
    public int x;
    public int y;
    public char oper;
    public  Estado predecesor;
    public double calidad;

    public Estado(int x, int y, char oper, Estado predecesor) {
        this.x = x;
        this.y = y;
        this.oper = oper; 
        this.predecesor = predecesor;
    }
    
    @Override 
    public boolean equals(Object x){
        Estado e=(Estado)x;
        return this.x==e.x && this.y==e.y;
    
    }
    @Override 
    public int hashCode(){
        int hash =3;
        hash =89 * hash + this.x;
        hash = 89 * hash + this.y;
        return hash;
    }
    
    @Override 
    public String toString(){
        return "(" +x+ "," + y +")";
    }
    
     
    public int compareTo(Object o) {
        Estado e = (Estado) o;
        if (this.calidad == e.calidad) {
            return 0;
        } else {
            if (this.calidad > e.calidad) {
                return 1;
            } else {
                return -1;
            }
        }
    }
    //distancia a un estado
    public void distancia(Estado a){
        double valor;
        double parte1=Math.pow(this.x-a.x,2);
        double parte2= Math.pow(this.y-a.y,2);
        parte1+=parte2;
        valor=Math.sqrt(parte1);
        this.calidad+=valor;
    
    
    }
    
}
