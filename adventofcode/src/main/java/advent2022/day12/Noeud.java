package advent2022.day12;

public abstract class Noeud {
	public Noeud precurseur = null;
	public double distanceDuDepart = Double.POSITIVE_INFINITY;
	public double distanceEstimee;
}
