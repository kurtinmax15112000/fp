// Варианты ламбда -функциий:
// () -> 100.2;
// () -> Math.random() * 100;
// (n) -> 1.5/n
// (n) -> (n%2)==0;
interface MyValue { // Создание функционального интерфейса с одним обстрактным методом
	//В функционально интерфейсе может быть определён только один абстрактный метод
	double getValue();

}

interface MyParamValue {
	//Определяем метод с оджним целым параметром
	 double getPValue(int n);
}

interface NumericTest {
	boolean test(int n, int m);


}



class Lambda {
	public static void main(String[] args) {
		MyValue myVal;
		myVal = () -> 100.2;
		System.out.println("Значение 1: " + myVal.getValue());
		myVal = () -> Math.random() * 10.2;	
		System.out.println("Значение 2: " + myVal.getValue());
		MyParamValue myPVal;
		myPVal = (n)  -> 1.0/n;
		System.out.println("Значение 1 для интерфейса с параметром " + myPVal.getPValue(10));
		myPVal = (n)  -> 10.5*n+5.5*n-(45.5/n);
		System.out.println("Значение 2 для интерфейса с параметром " + myPVal.getPValue(5));

		// Применение функционального интерфейса метода с двумя параметрами
		// Проверка на деление:
		NumericTest isFactor =(n,d) -> (n%d)==0;

		if(isFactor.test(10,2))
			System.out.println("2 является делителем 10");
		if(isFactor.test(10,3))
			System.out.println("3 не является делителем 10");
		
		// Проверка на то, что первый аргумент меньше второго

		NumericTest lessThan = (n,m) -> (n<m);

		if(isFactor.test(2,10))
			System.out.println("2 меньше 10");

		if(!isFactor.test(10,2))
			System.out.println("10 не меньше 2");

		 //Проверка на равенство абсолютных значений
		 NumericTest absEqual = (n, m) -> (n<0 ? -n : n) == (m<0 ? -m : m);
		 int x1, x2;
		 x1 =4;
		 x2 = -4;
		 if(absEqual.test(x1,x2))
			 System.out.println("Абсолютные значения " + x1 + " и "+ x2 + " равны");
		 else
			 System.out.println("Абсолютные значения " + x1 + " и "+ x2 + " не равны");
		 x1=5;
		 x2=6;
		 if(absEqual.test(x1,x2))		                     
			 System.out.println("Абсолютные значения " + x1 + " и "+ x2 + " равны");
		 else			
			 System.out.println("Абсолютные значения " + x1 + " и "+ x2 + " равны");
	}
}
	
