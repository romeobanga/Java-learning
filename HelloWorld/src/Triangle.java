
public class Triangle extends FigureGeometrique {
	
	private double bases;

	public Triangle(double p, double base) {
		super(p);
		this.bases = base;
	}

	public double Surface()
	{
		return bases*position*constante/2;
	}
	
	public double perimetreTriangle()
	{
		return position + bases;
	}
}
