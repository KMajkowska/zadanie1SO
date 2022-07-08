import java.util.*;

public class Generator {
	
	private ArrayList<Proces>Procesy;
	private int pos;
	
	public static ArrayList<Proces> generujProcesy(int n, int maxFaza, int minCzasZgloszenia, int maxCzasZgloszenia)
	{
		ArrayList<Proces>lista = new ArrayList<>();
		Random g = new Random();

		for(int i=0;i<n;i++)
		{
			lista.add(new Proces(i, g.nextInt(maxFaza)+1, g.nextInt(maxCzasZgloszenia-minCzasZgloszenia+1)+minCzasZgloszenia));
		}
		Collections.sort(lista, new ProcesCompare_MomentZgloszenia());
		
		return lista;
		
	}
	
	public Generator(int liczbaProcesow, int Faza, int minZgloszenia, int maxZgloszenia)
	{
		Procesy=generujProcesy(liczbaProcesow, Faza, minZgloszenia,maxZgloszenia);
		pos=0;
		
	}
	
	public Generator(Generator generator)
	{
		Procesy=new ArrayList<>();
		for(Proces proces: generator.Procesy)
		{
			this.Procesy.add(new Proces(proces));
		}
		pos=generator.pos;
	}
	
	public double sredniCzasOczekiwania()
	{
		double suma=0;
		for(int i=0; i<Procesy.size(); i++)
		{
			Proces proces = Procesy.get(i);
			suma+=proces.getCzasOczekiwania();
		}
		return suma/(double)(Procesy.size());
	}
	
	public boolean NastepnyProces()
	{
		return pos<Procesy.size();
	}
	
	public ArrayList<Proces> ProcesyMoment(int moment)
	{
		ArrayList<Proces>procesy_moment = new ArrayList<Proces>();
		
		while(pos<Procesy.size() && Procesy.get(pos).getMomentZgloszenia()==moment)
		{
			procesy_moment.add(Procesy.get(pos));
			pos++;
		}
		
		return procesy_moment;
		
	}

}