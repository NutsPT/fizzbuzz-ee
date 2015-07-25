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
				if(start > end){
					System.out.print("Invalid input (end is bigger then start)");
				} else {
					out = new StringBuilder();
					for (int i = start; i < end; i++) {
						out.append(converter(i));
						out.append(" ");
					}
					out.append(converter(end));
					System.out.print(out);
				}
			} else {
				System.out.print("Invalid number of arguments");
			}	
		} catch (NumberFormatException  e) {
			System.out.print("Invalid input");
		}
	}
	
	private static String converter(int number){
		if((number % 15) == 0){
			return "fizzbuzz";
		}else if((number % 5) == 0){
			return "buzz";
		}else if((number % 3) == 0){
			return "fizz";
		}else{
			return String.valueOf(number);
		}
	}

}
