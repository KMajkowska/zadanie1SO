import java.util.Comparator;

public class ProcesCompare_FazaProcesora implements Comparator<Proces> {

		@Override
		public int compare(Proces proces1, Proces proces2) {
			if(proces1.getFazaProcesora()>proces2.getFazaProcesora())
			{
				return 1;
			}
			else if(proces1.getFazaProcesora()==proces2.getFazaProcesora())
			{
				return 0;
			}
			else {
				return -1;
			}
		}
		
	}
