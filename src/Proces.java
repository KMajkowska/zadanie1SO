 import java.util.Collections;

import java.util.Comparator;
public class Proces{

	private int numer;
	private int fazaProcesora;
	private int momentZgloszenia;
	private int czasOczekiwania;
	private int jednostkiCzasu;
	
	public Proces(int numer, int fazaProcesora, int momentZgloszenia)
	{
		this.numer=numer;
		this.fazaProcesora=fazaProcesora;
		this.momentZgloszenia=momentZgloszenia;
		this.czasOczekiwania=0;
		this.jednostkiCzasu=this.fazaProcesora;
	}
	
	public Proces(Proces pro)
	{
		this.numer=pro.numer;
		this.fazaProcesora=pro.fazaProcesora;
		this.momentZgloszenia=pro.momentZgloszenia;
		this.czasOczekiwania=pro.czasOczekiwania;
		this.jednostkiCzasu=pro.fazaProcesora;
	}

	public int getNumer() {
		return numer;
	}

	public void setNumer(int numer) {
		this.numer = numer;
	}

	public int getFazaProcesora() {
		return fazaProcesora;
	}

	public void setFazaProcesora(int fazaProcesora) {
		this.fazaProcesora = fazaProcesora;
	}

	public int getMomentZgloszenia() {
		return momentZgloszenia;
	}

	public void setMomentZgloszenia(int momentZgloszenia) {
		this.momentZgloszenia = momentZgloszenia;
	}

	public int getCzasOczekiwania() {
		return czasOczekiwania;
	}

	public void setCzasOczekiwania(int czasOczekiwania) {
		this.czasOczekiwania = czasOczekiwania;
	}

	public int getJednostkiCzasu() {
		return jednostkiCzasu;
	}

	public void setJednostkiCzasu(int jednostkiCzasu) {
		this.jednostkiCzasu = jednostkiCzasu;
	}

	public void wykonywanie()
	{
		if(jednostkiCzasu>=1)
		{
			jednostkiCzasu--;
		}
	}
	
	public boolean czyWykonany()
	{
		if(jednostkiCzasu == 0)
		{
			return true;
		}
		else
			return false;
	}
	
	public void czekaj()
	{
		czasOczekiwania++;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proces other = (Proces) obj;
		return czasOczekiwania == other.czasOczekiwania && fazaProcesora == other.fazaProcesora
				&& momentZgloszenia == other.momentZgloszenia && numer == other.numer;
	}
	
	public String toString()
	{
		return "numer " + numer + " faza procesora " + fazaProcesora + " moment zg³oszenia " + momentZgloszenia + " czas oczekiwania " + czasOczekiwania + " jednostki czasu " + jednostkiCzasu;
	}
	
	
}
