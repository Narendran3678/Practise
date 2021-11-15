import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
interface LamdaClass
{
	public void lamdaMethod();
}

public class LamdaExpression 
{
	public static void main(String[] args) {
		LamdaClass lamda=()->{
			System.out.println("Lamda Method");
		};
		lamda.lamdaMethod();
		Consumer<Integer> consumer = (value) -> {
			System.out.print(value);
		};
		Consumer<Integer> consumerAndThen = (value) -> {
			System.out.print(value+3);
		};
		for(int i=0;i<3;i++)
		{
			consumer.andThen(consumerAndThen).accept(i);
			System.out.println();
		}
		Supplier<String> supplier = ()->{return "Supplier Function";};
		System.out.println(supplier.get());
		
		Predicate<Integer> evenPredicate= (num) -> num%2==0;
		Predicate<Integer> oddPredicate= (num) -> num%2!=0;
		System.out.println(evenPredicate.or(oddPredicate).negate().test(2));
		
		Function<Integer,Integer> function =(i) ->{return i+5;};
		Function<Integer,Boolean> functionType =(i) ->{return i%2==0;};
		System.out.println(function.andThen(functionType).apply(2));
	}
}
