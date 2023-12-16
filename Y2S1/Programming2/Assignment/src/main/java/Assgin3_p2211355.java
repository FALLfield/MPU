public class Assgin3_p2211355 {
	public static void main(String[] args) {
		// Part 1 - test the SimpleVec2D class
		SimpleVec2D[] vectors = new SimpleVec2D[10];
		for(int i = 0; i < 10; ++i) {
			vectors[i] = new SimpleVec2D(Math.random(), Math.random());
			vectors[i].Mul(10.0);
			vectors[i].calculateDistance();
		}
		for(int i = 0; i < 10; ++i) {
			System.out.printf("(%.2f, %.2f) Dist = %.2f, HashCode = %d\n", vectors[i].getX(), vectors[i].getY(), vectors[i].getDistance(), vectors[i].hashCode());
		}
		
		// Part 2 - test the SimpleTable class
		SimpleTable table = new SimpleTable();
		for(int i = 0; i < 10; ++i) {
			table.AddElement(vectors[i]);
		}
		table.Print();
		SimpleVec2D sumVector = table.SumElement();
		sumVector.calculateDistance();
		System.out.printf("SUM = (%.2f, %.2f) Dist = %.2f\n", sumVector.getX(), sumVector.getY(), sumVector.getDistance());
		sumVector.Sub(vectors[0]);
		sumVector.calculateDistance();
		System.out.printf("SUM - First = (%.2f, %.2f) Dist = %.2f\n", sumVector.getX(), sumVector.getY(), sumVector.getDistance());
	}
}

abstract class Vectors {
	protected double distance = 0;
	public abstract void calculateDistance();
	public double getDistance() {	return distance; }	// Euclidean distance to (0, 0)
}

interface Arithmetic<E> {
	public void Add(E var);
	public void Sub(E var);
	public void Mul(double scalar);
}

class SimpleTable {
	private SimpleVec2D[][] theTable;
	
	public SimpleTable() {
		theTable = new SimpleVec2D[5][10];
	}
	
	public void Print() {
		System.out.println("===========================================");
		for(int j = 0; j < 5; ++j) {
			System.out.print("[" + j + "] : ");
			for(int i = 0; i < 10; ++i) {
				if (theTable[j][i] != null)
					System.out.printf("%.2f | ", theTable[j][i].getDistance());
			}
			System.out.println();
		}		
		System.out.println("===========================================");
	}
	
	// Complete the following methods
	public void AddElement(SimpleVec2D var) {
		int index = var.hashCode();
		int length = 0;
		for(int i = 0; i < 10; ++i){
			if (theTable[index][i] != null) {
				++length;
			}
		}
		for(int i = length - 1; i >= 0; --i){
			theTable[index][i+1] = theTable[index][i];
		}
		theTable[index][0]=var;
	}
	
	public SimpleVec2D SumElement() {
		SimpleVec2D summ = new SimpleVec2D(0,0);
		for(int i = 0 ; i < 5; ++i){
			for(int j = 0; j < 10; ++j){
				if (theTable[i][j] != null) {
					summ.Add(theTable[i][j]);
				}
			}
		}
		return summ;
	}
}

// Your SimpleVec2D start from here --------------------------------------------------
class SimpleVec2D extends Vectors implements Arithmetic<SimpleVec2D>{
	private double x;
	private double y;

	public SimpleVec2D(double x, double y){
		this.x = x;
		this.y = y;
	}
	@Override
	public int hashCode(){
		double a = this.getDistance();
		int b = (int)this.getDistance();
		if(a - b > 0.5){
			return (b+1)%5;
		}
		return b%5;
	}

	@Override
	public void calculateDistance() {
		distance = Math.sqrt(x * x + y * y);
	}

	@Override
	public void Add(SimpleVec2D var) {
		this.x += var.getX();
		this.y += var.getY();
	}

	@Override
	public void Sub(SimpleVec2D var) {
		this.x -= var.getX();
		this.y -= var.getY();
	}

	@Override
	public void Mul(double scalar) {
		x = x*scalar;
		y = y*scalar;
	}

	public double getX() {
		return x;
	}

	public double  getY(){
		return y;
	}

}
