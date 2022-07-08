import java.util.*;

public class Algorytmy{
	
	private ArrayList<Proces>procesy;
	private int moment;
	private Generator generator_procesy;
	
	public Algorytmy(Generator generator_procesy)
	{
		procesy=new ArrayList<Proces>();
		this.generator_procesy=generator_procesy;
		moment=0;		
	}
	
	public void FCFS()
	{
		while(generator_procesy.NastepnyProces() || procesy.size()>0)
		{
			dodajProcesyDoKolejki();
			if(procesy.size()>0)
			{
				//wyswietlKolejke();
				//System.out.println("\n\n");
				wykonaj();
				
			}
			else {
				moment++;
			}
			
		}
	}
	
	public void SJF()
	{
		while(generator_procesy.NastepnyProces() || procesy.size()>0)
		{
			dodajProcesyDoKolejki();
			Collections.sort(procesy, new ProcesCompare_FazaProcesora());
			if(procesy.size()>0)
			{
				//wyswietlKolejke();
				//System.out.println("\n\n");
				wykonaj();
			}
			else {
				moment++;
			}
			
		}
	}
	
	public void SRTF()
	{
		while(generator_procesy.NastepnyProces() || procesy.size()>0)
		{
			dodajProcesyDoKolejki();
			
			Collections.sort(procesy, new ProcesCompare_JednostkiCzasu());
			
			if(procesy.size()>0)
			{
				//wyswietlKolejke();
				//System.out.println("\n\n");
				while(!procesy.get(0).czyWykonany())
				{
					procesy.get(0).wykonywanie();
					moment++;
					aktualizacjaCzasuOczekiwania(procesy.get(0));
					dodajProcesyDoKolejki();
					Collections.sort(procesy, new ProcesCompare_JednostkiCzasu());
				}
				
				
				procesy.remove(0);
			}
			
			else 
			{
				moment++;
			}
			
		}
	}
	
	public void RR(int kwantCzasu)
	{
		int it=0;
		int obecneOkno=0;
		while(generator_procesy.NastepnyProces() || procesy.size()>0)
		{
			
			dodajProcesyDoKolejki();
			obecneOkno=0;
			//wyswietlKolejke();
			if(procesy.size()>0)
			{

				while(obecneOkno<kwantCzasu && !procesy.get(it).czyWykonany())
					{
						procesy.get(it).wykonywanie();
						obecneOkno++;
						moment++;
						aktualizacjaCzasuOczekiwania(procesy.get(it));
						dodajProcesyDoKolejki();
					}
					
					if(procesy.get(it).czyWykonany())
					{
						procesy.remove(it);
		
					}else
					{
						it++;

					}
					
					if(it>=procesy.size())
					{
						it=0;
					}
					
					
			}
			else {
				moment++;
			}
			
		}
	}
	
	public void aktualizacjaCzasuOczekiwania(Proces aktualnyProces)
	{
		for(int i=0; i<procesy.size(); i++)
		{
			Proces proces = procesy.get(i);
			if(proces!=aktualnyProces)
			{
				proces.czekaj();
			}
		}
	}
	
	public void wykonaj()
	{
		while(!procesy.get(0).czyWykonany())
		{
			procesy.get(0).wykonywanie();
			moment++;
			aktualizacjaCzasuOczekiwania(procesy.get(0));
			dodajProcesyDoKolejki();
		}
		procesy.remove(0);
		
	}
	
	public void dodajProcesyDoKolejki()
	{
		procesy.addAll(generator_procesy.ProcesyMoment(moment));
		
	}
	
	public void wyswietlKolejke()
	{
		for(Proces proces: procesy)
		{
			System.out.println(proces);
		}
	}

}

