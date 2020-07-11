import Controller.MainController;
import Model.DataManager;
import Model.MainModel;
import View.MainView;

import java.io.IOException;

public class Driver {
    private static DataManager data;

    public static void main(String[] args) throws IOException, ClassNotFoundException 
    {
    	
        data = DataManager.getInstance();
        data.loadData();
        
        try
        {
        	
            MainView mainView = new MainView();
            mainView.start();
            
        }
        catch (Exception e) 
        {
        	
            System.out.println("Failed to start application");
            e.printStackTrace();
            
        }
        
        data.saveData();

    }
    
}
