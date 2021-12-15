package advent2021.day15;

public abstract class Noeud {
	public Noeud precurseur = null;
	public double distanceDuDepart = Double.POSITIVE_INFINITY;
	public double distanceEstimee;
}
