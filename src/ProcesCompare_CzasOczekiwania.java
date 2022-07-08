import java.util.Comparator;

public class ProcesCompare_CzasOczekiwania implements Comparator<Proces> {
		

		public int compare(Proces proces1, Proces proces2) {
			if(proces1.getCzasOczekiwania()>proces2.getCzasOczekiwania())
			{
				return 1;
			}
			else if(proces1.getCzasOczekiwania()==proces2.getCzasOczekiwania())
			{
				return 0;
			}
			else {
				return -1;
			}
		}
	}
