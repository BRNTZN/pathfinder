package beans;

import java.util.List;
import java.util.Stack;

public class Pathfinder {
	
	private int xmax, ymax;
	private Stack<Tyle> route = new Stack<Tyle>();
	private Stack<Tyle> deads = new Stack<Tyle>();
	private Tyle einde, begin;
	private int[][] grid;
	
	public List<List<Integer>> find(List<List<Integer>> gridlist) {
		this.grid = new int[gridlist.get(0).size()][gridlist.size()];
		this.xmax = gridlist.get(0).size()-1;
		this.ymax = gridlist.size()-1;
		int y =0;
		for (List<Integer> list : gridlist) {
			int x =0;
			for (Integer integer : list) {
				if (integer.intValue()>0) {
					grid[x][y]=0;
					if (integer.intValue()==2) {
						this.begin = new Tyle(x, y);
					}
					if (integer.intValue()==3) {
						this.einde = new Tyle(x, y);
					}
				}else{
					grid[x][y]=1;
				}
				x++;
			}
			y++;
		}
		check(begin);
		route.pop();
		route.remove(0);
		for (Tyle t : route) {
			List<Integer> row = gridlist.get(t.getY());
			row.remove(t.getX());
			row.add(t.getX(), 4);
		}
		return gridlist;
	}
	
	private boolean check(int x, int y) {
		boolean omw = false;
		Tyle t = new Tyle(x, y);
		if (t.equals(einde)) {
			omw = true;
			route.push(t);
		} else {
			if (!deads.contains(t)) {
				if (x > xmax || x < 0 || y > ymax || y < 0 || grid[x][y] == 1) {
					deads.push(t);
				} else {
					route.push(t);
					omw = true;
					boolean surrounded = false;
					Tyle boven = new Tyle(x, y - 1);
					Tyle rechts = new Tyle(x + 1, y);
					Tyle onder = new Tyle(x, y + 1);
					Tyle links = new Tyle(x - 1, y);
					if (route.contains(boven) || !check(boven)) {
						if (route.contains(rechts) || !check(rechts)) {
							if (route.contains(onder) || !check(onder)) {
								if (route.contains(links) || !check(links)) {
									surrounded = true;
								}
							}
						}
					}
					if (surrounded) {
						deads.push(t);
						route.remove(t);
						omw = false;
					}
				}

			}
		}
		return omw;
	}

	private boolean check(Tyle c) {
		return check(c.getX(), c.getY());
	}
	
	public int getXmax() {
		return xmax;
	}
	public void setXmax(int xmax) {
		this.xmax = xmax;
	}
	public int getYmax() {
		return ymax;
	}
	public void setYmax(int ymax) {
		this.ymax = ymax;
	}
	public Stack<Tyle> getRoute() {
		return route;
	}
	public void setRoute(Stack<Tyle> route) {
		this.route = route;
	}
	public Stack<Tyle> getDeads() {
		return deads;
	}
	public void setDeads(Stack<Tyle> deads) {
		this.deads = deads;
	}
	public Tyle getEinde() {
		return einde;
	}
	public void setEinde(Tyle einde) {
		this.einde = einde;
	}
	public Tyle getBegin() {
		return begin;
	}
	public void setBegin(Tyle begin) {
		this.begin = begin;
	}
	public int[][] getGrid() {
		return grid;
	}
	public void setGrid(int[][] grid) {
		this.grid = grid;
	}

}
