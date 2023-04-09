package controller;

import java.util.concurrent.Semaphore;

public class CalcBD extends Thread
{
	private int id;
	private Semaphore fila;
	
	public CalcBD(int id, Semaphore fila)
	{
		this.id = id;
		this.fila = fila;
	}
	
	public void bancoDeDados()
	{
		new Thread()
		{
			public void run()
			{
				iniBD();
				
			}
		}.start();
	}
	
	public void iniBD()
	{
		calc(id % 3);
	}
	public void calc(int tipo)
	{
		try {
			if(tipo == 1)
			{
				for (int i = 0; i < 2; i++)
				{
					System.out.println("O id " + this.id + " do tipo " + tipo + " está calculando");
					sleep((int)(Math.random() * 801) + 200);
					BD(tipo);
				}
			}
			else if(tipo == 2)
			{
				for (int i = 0; i < 3; i++)
				{					
					System.out.println("O id " + this.id + " do tipo " + tipo + " está calculando");
					sleep((int)(Math.random() * 1001) + 500);
					BD(tipo);
				}
			}
			else 
			{
				for (int i = 0; i < 3; i++)
				{					
					System.out.println("O id " + this.id + " do tipo " + tipo + " está calculando");
					sleep((int)(Math.random() * 1001) + 1000);
					BD(tipo);
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("O id " + this.id + " do tipo " + tipo + " terminou sua tarefa.");
	}
	
	public void BD(int tipo)
	{
		try {
			if(tipo == 1)
			{
				fila.acquire();
				System.out.println("O id " + this.id + " do tipo " + tipo + " esta fazendo transacao no BD");
				sleep(1000);			
			}
			else if(tipo == 2)
			{
				fila.acquire();
				System.out.println("O id " + this.id + " do tipo " + tipo + " esta fazendo transacao no BD");
				sleep(1500);
			}
			else
			{
				fila.acquire();
				System.out.println("O id " + this.id + " do tipo " + tipo + " esta fazendo transacao no BD");
				sleep(1500);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			fila.release();
		}
	}
}
