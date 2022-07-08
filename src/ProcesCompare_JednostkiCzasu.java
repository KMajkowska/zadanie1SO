import java.util.Comparator;

public class ProcesCompare_JednostkiCzasu implements Comparator<Proces> {
		@Override
		public int compare(Proces proces1, Proces proces2) {
			if(proces1.getJednostkiCzasu()>proces2.getJednostkiCzasu())
			{
				return 1;
			}
			else if(proces1.getJednostkiCzasu()==proces2.getJednostkiCzasu())
			{
				return 0;
			}
			else {
				return -1;
			}
		}
	}