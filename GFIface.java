
interface SomeTest <T>{
	boolean test (T n, T m);

}
class GFIface {
	public static void  main(String[] args) {
		SomeTest<Integer> isFactor = (n,d) -> (n%d) == 0;
		if(isFactor.test(10,2))
			System.out.println("2 - делитель 10");
		System.out.println();
		

		SomeTest<Double> isFactorD = (n,d) -> (n%d) == 0;
		if(isFactorD.test(212.0,4.0))
			System.out.println("4.0 - делитель 212.0");
		System.out.println();

		SomeTest<String> isIn = (a,b) -> a.indexOf(b) != -1;
		String str = "Generic Fuctional Interface";
		System.out.println("Проверяемая строка" + str);
		if(isIn.test(str, "face"))
			System.out.println("строка \"face\" найдена");
		else
			System.out.println("строка \"face\" не найдена" );
	}
}
