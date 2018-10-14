package courseworkX;
import api.ripley.Ripley;
import courseworkX.controller.Controller;
import courseworkX.model.Model;
import courseworkX.view.MainView;
import courseworkX.view.panel2.Panel2View;


public class Main {

	public static void main(String[] args) {

	    Ripley ripley = new Ripley( "90tLI3CWt9yyVD6ql2OMtA==","lBgm4pRo8wzVqL46EnH7ew==");
        System.out.println(ripley.getLastUpdated());

        Model model = new Model(ripley);
        Controller controller = new Controller(model);
        new MainView(controller, model, ripley);

        model.stats();
        System.out.println(ripley.getAcknowledgementString());
        

	}
}

