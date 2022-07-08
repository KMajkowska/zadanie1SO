import java.util.Comparator;

public class ProcesCompare_Numer implements Comparator<Proces>{
		public int compare(Proces proces1, Proces proces2) {
			if(proces1.getNumer()>proces2.getNumer())
			{
				return 1;
			}
			else if(proces1.getNumer()==proces2.getNumer())
			{
				return 0;
			}
			else {
				return -1;
			}
		}

	}