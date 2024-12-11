interface ITest {
	String show();
	int add(int i);
	double sum(double i, double j);
}
class Tester implements Tester {
	abstract String show();
	public int add (int i ) {
		return i+1;
	}
	public double sum(double i, double j) {
		return i+j;
	}
}

class Tester2 extends Tester{
	String msg;
	Tester2 (String m){
		msg = m;
	}
	public String show() {
		return msg;
	}
}
class Tester3 implements ITest {
	public String show(){
		return "666";
	}

	public int add(int i) {
		return 666;
	}
	public double sum (double i, double j) {
		return 666.0;
	}
}



class IntDemo {
	public static void main(String[] args){
		Tester2 i = new Tester2("Проверка работы с интерфейсом ITest");
		System.out.println(i.show() + " " + i.add(10) + " " + i.sum(5.0, 15.0));
		
		ITest i;
		j=i;
		System.out.println(i.show() + " " + i.add(10) + " " + i.sum(5.0, 15.0));

		i = new Tester3();
		System.out.println(i.show() + " " + i.add(10) + " " + i.sum(5.0, 15.0));
	}
}
