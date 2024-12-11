//Демонстрация наследования
class A {
	int a = 5;
	void showA() {
		System.out.println("Значение a: " + a);
	}
	int addA() {
		a+=1;
		return a;
	}
	void showString(){
		System.out.println("Метод, ыполняемый из объекта класса А");
	}

}
// Класс B наследует все открытые переменные и методы класса A
// и добавляет свои переменные и методы
class B extends A {
	int b = 10;
	int addB() {
		b+=1;
		return b;
	}
	void showString(){
	         System.out.println("Метод, ыполняемый из объекта класса B");
	}
}
class C extends A {
	int c = 20;
	void showString(){
		 System.out.println("Метод, ыполняемый из объекта класса C");
	} 
}
class Inheritance {
	public static void main(String[] args) {
		A objA = new A();
		B objB = new B();
		objA.showA();
		//Вызываем метод родительского класса
		objB.showA();
		//Вызываем метод своего класса
		objA.addA();
		objB.addA();
		objA.showA();
                objB.showA();
		objB.addB();
		System.out.println("Значение b: " + objB.b);
		//Родительский класс не имеет доступа к переменным и методам дочернего класса
		//Недопустимая операция: objA.addB(); - нет доступа к методу addB
      
		C objC = new C();
		objC.showA();

		System.out.println();
		objA.showString();
		objB.showString();
		objC.showString();
		
		//Переменнная суперкласс может указывать на любой объект, относящийся к подклассу

		objA = objB;
		objA.showString();
	 	objA = objC;
		objA.showString();
	}
}

