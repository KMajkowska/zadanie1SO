import java.util.Comparator;

public class ProcesCompare_MomentZgloszenia implements Comparator<Proces> {

		@Override
		public int compare(Proces proces1, Proces proces2) {
			if(proces1.getMomentZgloszenia()>proces2.getMomentZgloszenia())
			{
				return 1;
			}
			else if(proces1.getMomentZgloszenia()==proces2.getMomentZgloszenia())
			{
				return 0;
			}
			else {
				return -1;
			}
		}
		
	}
