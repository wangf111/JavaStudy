package thread.my;

class Fork{
	private boolean[] used={false,false,false,false,false};
	public synchronized void takeFork(){
		String name = Thread.currentThread().getName();
		int i=Integer.parseInt(name);
		while(used[i]||used[(i+1)%5]){
			try{
				wait();
			}catch(Exception e){e.printStackTrace();}
		}
	}
}
class Phiosopher extends Thread{
	private String name ;
}
public class PhilosophererMy {

}
