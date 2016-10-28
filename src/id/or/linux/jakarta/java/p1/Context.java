package id.or.linux.jakarta.java.p1;

public class Context {
	private static Context instance = null;
	
	private static Graph graph;
	private static Rect rect1;
	private static Rect rect2;
	
	public static Graph getGraph() {
		return graph;
	}
	public static void setGraph(Graph graph) {
		Context.graph = graph;
	}
	public static Rect getRect1() {
		return rect1;
	}
	public static void setRect1(Rect rect1) {
		Context.rect1 = rect1;
	}
	public static Rect getRect2() {
		return rect2;
	}
	public static void setRect2(Rect rect2) {
		Context.rect2 = rect2;
		
	}
	protected Context(){
		
	}
	public static Context getInstance() {
	      if(instance == null) {
	         instance = new Context();
	      }
	      return instance;
	}

}
