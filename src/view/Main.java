package view;

import java.util.concurrent.Semaphore;

import controller.CalcBD;

public class Main 
{
	public static void main(String[] args)
	{
		
		Semaphore perm = new Semaphore(1);
		
		for(int i = 1; i <= 21; i++)
		{
			CalcBD controllBD = new CalcBD(i, perm);
			controllBD.bancoDeDados();
		}
		
	}

}
