package server;
import java.util.Calendar;
import java.util.HashMap;


public class Hrac {

	private static int delay = 10000; //MILISECOND
	
	private static HashMap<Integer, Hrac> pool = new HashMap<Integer, Hrac>();
	
	public static Hrac getHrac(int id) {
		Hrac h = Hrac.pool.get(id);
		if(h == null) {
			h = new Hrac(id);
			Hrac.pool.put(id, h);
		}
		return h;
	}
	
	public int id = 0;
	
	public long lastTimestamp = 0;
	
	private Hrac(int id) {
		this.id = id;
	}
	
	public void obsad(Bunka b) {
		b.idHrac = this.id;
		Calendar calendar = Calendar.getInstance();
		lastTimestamp = calendar.getTime().getTime();
	}
	
	
	public boolean canPlay() {
		Calendar calendar = Calendar.getInstance();
		return lastTimestamp < calendar.getTime().getTime() - Hrac.delay; 
		
	}
	
}
