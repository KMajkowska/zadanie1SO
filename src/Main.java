import java.util.*;
public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int nProcesow;
		int maxFaza;
		int minCzasZgloszenia;
		int maxCzasZgloszenia;
		int kwantCzasu;
		int iloscProb;
		
		System.out.println("Liczba testow: ");
		iloscProb = scan.nextInt();
		
		System.out.println("Liczba procesow na test: ");
		nProcesow = scan.nextInt();
		
		System.out.println("Maksymalna faza procesu: ");
		maxFaza=scan.nextInt();
		
		System.out.println("Minimalny czas zgłoszenia procesu: ");
		minCzasZgloszenia=scan.nextInt();
		
		System.out.println("Maksymalny czas zgłoszenia procesu: ");
		maxCzasZgloszenia=scan.nextInt();
		
		System.out.println("Kwant czasu dla algorytmu RR: ");
		kwantCzasu=scan.nextInt();

		SredniaCiagu(iloscProb,nProcesow, maxFaza,minCzasZgloszenia,maxCzasZgloszenia,kwantCzasu);
	}
	
	public static void SredniaCiagu(int ileCiagow, int n, int maxFaza, int minCzasZgloszenia, int maxCzasZgloszenia, int kwantCzasu)
	{
		double sumaFCFS=0;
		double sumaSJF=0;
		double sumaSRTF=0;
		double sumaRR=0;

		Algorytmy procesor;
		Generator g;
		Generator g2;
		Generator g3; 
		Generator g4; 
		
		for(int i=0;i<ileCiagow;i++)
		{
			g = new Generator(n, maxFaza, minCzasZgloszenia, maxCzasZgloszenia);
			g2 = new Generator(g);
			g3 = new Generator(g);
			g4 = new Generator(g);
						
			procesor = new Algorytmy(g);			
			procesor.FCFS();
			sumaFCFS+=g.sredniCzasOczekiwania();
			
			procesor = new Algorytmy(g2);
			procesor.SJF();
			sumaSJF+=g2.sredniCzasOczekiwania();
			
			procesor = new Algorytmy(g3);
			procesor.SRTF();
			sumaSRTF+=g3.sredniCzasOczekiwania();
			
			procesor = new Algorytmy(g4);
			procesor.RR(kwantCzasu);
			sumaRR+=g4.sredniCzasOczekiwania();
			
		}
		
		System.out.println("Sredni czas FCFS: "+sumaFCFS/(double)ileCiagow);
		System.out.println("Sredni czas SJF: "+sumaSJF/(double)ileCiagow);
		System.out.println("Sredni czas SRTF: "+sumaSRTF/(double)ileCiagow);
		System.out.println("Sredni czas RR: "+sumaRR/(double)ileCiagow);
	}

}
