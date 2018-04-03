package server;
import java.util.ArrayList;


public class HerniPole {

	private int rozmer;
	
	ArrayList<Bunka> bunky = new ArrayList<Bunka>();

	ArrayList<Hrac> hrac = new ArrayList<Hrac>();
	
	public HerniPole(int rozmer) {
		this.rozmer = rozmer;
		for(int x=0;x<this.rozmer;x++) {
			for(int y=0;y<this.rozmer;y++) {
				this.bunky.add(new Bunka(x, y));
			}
		}
	}
	
	public void hraj(int id, int x, int y) {
		
		
		Hrac h = Hrac.getHrac(id);
		
		System.out.println("Hrac "+h.id+" hraje ["+ x + ","+y+"], posledni pokus v "+h.lastTimestamp);
		
		if(!h.canPlay()) {
			return;
		}
		
		Bunka b= this.getBunka(x,y);
		if(b ==null) {
			 return;
		}
		
		if(!this.hasHrac(id) && b.idHrac == 0) {
			h.obsad(b);
			
		} 
		
		ArrayList<Bunka> bunkyOkolo = new ArrayList<Bunka>();
		bunkyOkolo.add(this.getBunka(x-1, y));
		bunkyOkolo.add(this.getBunka(x-1, y-1));
		bunkyOkolo.add(this.getBunka(x-1, y+1));
		bunkyOkolo.add(this.getBunka(x, y-1));
		bunkyOkolo.add(this.getBunka(x+1, y));
		bunkyOkolo.add(this.getBunka(x+1, y+1));
		bunkyOkolo.add(this.getBunka(x+1, y-1));
		bunkyOkolo.add(this.getBunka(x, y+1));
		
		for(Bunka okolniBunka : bunkyOkolo) {
			if(okolniBunka == null) {
				continue;
			}
			if(okolniBunka.idHrac == id) {
				h.obsad(b);
				return;
			}
		}
	}
	
	public boolean hasHrac(int id) {
		boolean hasHrac = false;
		
		for(Bunka b : this.bunky) {
			if(b.idHrac == id) {
				return true;
			}
		}
		
		return false;
	}
	
	public String toString() {
		String s = "";
		for(int x=0;x<this.rozmer;x++) {
			
			for(int y=0;y<this.rozmer;y++) {
				Bunka b = this.getBunka(x,y);
				if(b != null) {
					s += " " + b.idHrac + ",";
				} else {
					s += "   ,";
				}
			}
			s += "\n";
		}
		
		return s;
	}

	public Bunka getBunka(int x, int y) {
		for(Bunka b : this.bunky) {
			if(b.x == x && b.y == y) {
				return b;
			}
		}
		return null;
	}
	
}
