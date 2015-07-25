package com.miguelsaraiva.fizzbuzz;

public class FizzBuzz {
	
	public static void main(String[] args)
    {
		fizzbuzz(args);
    }
	
	private static void fizzbuzz(String[] args){
		StringBuilder out = null;
		try {
			if(args.length == 2){
				int start = Integer.parseInt(args[0]);
				int end = Integer.parseInt(args[1]);
				FizzBuzzCounter counter = new FizzBuzzCounter();
				if(start > end){
					System.out.print("Invalid input (end is bigger then start)");
				} else {
					out = new StringBuilder();
					for (int i = start; i < end; i++) {
						out.append(converter(i, counter));
						out.append(" ");
					}
					out.append(converter(end, counter));
					System.out.println(out);
					System.out.println("fizz: " + counter.getTotalFizz());
					System.out.println("buzz: " + counter.getTotalBuzz());
					System.out.println("fizzbuzz: " + counter.getTotalFizzBuzz());
					System.out.println("lucky: " + counter.getTotalLucky());
					System.out.println("integer: " + counter.getTotalInteger());
				}
			} else {
				System.out.print("Invalid number of arguments");
			}	
		} catch (NumberFormatException  e) {
			System.out.print("Invalid input");
		}
	}
	
	private static String converter(int number, FizzBuzzCounter counter){
		String value = String.valueOf(number);
		if(value.contains("3")){
			counter.setTotalLucky(counter.getTotalLucky()+1);
			return "lucky";
		}else{
			if((number % 15) == 0){
				counter.setTotalFizzBuzz(counter.getTotalFizzBuzz()+1);
				return "fizzbuzz";
			}else if((number % 5) == 0){
				counter.setTotalBuzz(counter.getTotalBuzz()+1);
				return "buzz";
			}else if((number % 3) == 0){
				counter.setTotalFizz(counter.getTotalFizz()+1);
				return "fizz";
			}else{
				counter.setTotalInteger(counter.getTotalInteger()+1);
				return String.valueOf(number);
			}
		}
	}

}
