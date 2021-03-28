import com.calcolo.interesse.composto.controller.CalcoloInteresseCompostoController;
import com.calcolo.interesse.composto.model.CalcoloInteresseCompostoModel;
import com.calcolo.interesse.composto.view.CalcoloInteresseCompostoView;

public class CalcoloInteresseComposto {
	public static void main(String[] args) {
		CalcoloInteresseCompostoModel model = new CalcoloInteresseCompostoModel();
		CalcoloInteresseCompostoView view = new CalcoloInteresseCompostoView();
				
		new CalcoloInteresseCompostoController(model, view);
		
	}
}