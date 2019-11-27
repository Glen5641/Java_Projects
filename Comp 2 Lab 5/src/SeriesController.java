import java.awt.event.*;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Lab 5, CS 2334, Section 010, 21 March 2017
 * <P>
 * The MVC controller for the program.
 * </P>
 * <P>
 * Note that, in addition to the SeriesController class, this file contains
 * three inner classes, one for each listener.
 * </P>
 * 
 * @author Dean Hougen and Clayton Glenn
 * @version 2.0
 */
public class SeriesController {
	/** The model to modify in response to events. */
	private SeriesModel model;

	/**
	 * The view that provides the events to which the control should respond.
	 */
	private SeriesInputWindow inputView;

	/**
	 * Constructor to create a series controller.
	 */
	public SeriesController() {
		// intentionally empty, do not change
	}

	/**
	 * <code>AddEpisodeListener</code> provides a method to create a new
	 * episode. The episode should then be added to the episode list of the
	 * model. The values for the new episode come from the fields of the input
	 * view using <code>getText()</code>. If the model is null when the method
	 * is called, it returns without taking any action.
	 */
	private class AddEpisodeListener implements ActionListener {

		/**
		 * This overridden <code>actionPerformed</code> method is only supposed
		 * to respond to one kind of action - adding an episode. For that
		 * reason, it ignores the action event handed to it as a parameter and
		 * simply gets the text from the fields of the input view, creates an
		 * episode from them, and adds that episode to the model.
		 * 
		 * @param e
		 *            The action event that triggered this method. (Ignored.)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			if (model == null)
				return; // No model associated. Can't do anything.

			String title = inputView.jtfTitle.getText();
			Episode episode = new Episode(title, inputView.jtfSeasonNumber.getText(), 
					inputView.jtfEpisodeNumber.getText(), inputView.jtfYear.getText());

			if (model.contains(title)) { // Episode already in collection so ask
											// what to do

				//Use a JOptionPane here to ask what to do
				JFrame frame = new JFrame();
				String[] questions = {"An episode entitled " + title + " already exists.", 
						"Would you like to replace the existing episode data or keep old episode?"};
				String[] options = {"Replace Episode", "Cancel"};
				
				//assign returned value of JOptionPane to response
				int response = (JOptionPane.showOptionDialog(frame.getContentPane(), 
						questions[0], questions[1], 0, JOptionPane.INFORMATION_MESSAGE,
						null, options, null));

				if (response == 1) {
					// option 0 is cancel so do nothing
				} else if (response == 0) {
					//Replace episode
					boolean replace = model.replaceEpisode(episode);
					if(replace == false) {
						System.err.println("Program failed to replace episode.");
						System.exit(0);
					}
				} else {
					// Should handle error case here (we won't for this lab).
				}
			} else { // Episode not in collection, so add
				model.addEpisode(episode);
				
			}
		}
	}

	/**
	 * <code>ClearEpisodeListener</code> provides a method to clear the episode
	 * list of the model. If the model is null when the method is called, it
	 * returns without taking any action.
	 */
	private class ClearEpisodeListener implements ActionListener {
		
		/**
		 * This overridden <code>actionPerformed</code> method is only supposed
		 * to respond to one kind of action - clearing the list of episodes. For
		 * that reason, it ignores the action event handed to it as a parameter
		 * and simply calls the <code>clearEpisodes</code> method of the model.
		 * 
		 * @param e
		 *            The action event that triggered this method. (Ignored.)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			if (model == null)
				return;
			model.clearEpisodes();
		}
	}

	/**
	 * <code>ClearInputFieldsListener</code> provides a method to clear the input fields of
	 * the inputView.
	 */
	private class ClearInputFieldsListener implements ActionListener {
		
		/**
		 * This overridden <code>actionPerformed</code> method is only supposed
		 * to respond to one kind of action - clearing the input fields of the
		 * input view. For that reason, it ignores the action event handed to it
		 * as a parameter and simply calls the <code>clearInputFields</code>
		 * method of the input view.
		 * 
		 * @param e
		 *            The action event that triggered this method. (Ignored.)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			if (model == null)
				return;
			inputView.clearInputFields();
		}
	}

	//Create additional listener classes for menu and toolbar.
	
	/**
	 * LoadEpisodesListener provides method to Load 
	 * episodes into a map when menu item is clicked
	 */
	private class LoadEpisodesListener implements ActionListener {
		
		/**
		 * This overriden method only acts when the load 
		 * button is pressed. Episodes are loaded into the map.
		 */
		@Override
		public void actionPerformed(ActionEvent e){
			model.loadEpisodeMap();
		}
	}

	/**
	 * SaveEpisodesListener provides method to Save the 
	 * episode array to a data file when the menu item is clicked
	 */
	private class SaveEpisodesListener implements ActionListener {
		
		/**
		 * This overriden method only acts when the save item is clicked.
		 * The method saves the episodes to a file to be loaded later.
		 */
		@Override
		public void actionPerformed(ActionEvent e){
			try {
				model.saveEpisodeMap();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	/**
	 * ExitListener provides method to Exit the program when Exit is clicked
	 */
	private class ExitListener implements ActionListener {
	
		/*
		 * This overriden method exits the program, but can only be 
		 * accessed when the exit button is clicked
		 */
		@Override
		public void actionPerformed(ActionEvent e){
			System.exit(0);
		}
	}

	/**
	 * PrintEpisodesListener provides method to Print episodes to console
	 */
	private class PrintEpisodesListener implements ActionListener {
	
		/**
		 * This overriden method is only addressed after print is clicked.
		 * Print prints the episodes to the console
		 */
		@Override
		public void actionPerformed(ActionEvent e){
			model.printEpisodes();
		}
	}

	/**
	 * Mutator method that sets the model for this controller.
	 * 
	 * @param model
	 *            The model that holds the data we want to modify.
	 */
	public void setModel(SeriesModel model) {
		this.model = model;
	}

	/**
	 * Mutator method that sets the input view (window) for this controller.
	 * 
	 * @param theView
	 *            The view on which the listeners should be set.
	 */
	public void setInputWindow(SeriesInputWindow theView) {
		inputView = theView;

		// Register listeners
		inputView.addAddEpisodeButtonListener(new AddEpisodeListener());
		inputView.addClearEpisodesButtonListener(new ClearEpisodeListener());
		inputView.addClearInputButtonListener(new ClearInputFieldsListener());
		inputView.addLoadEpisodesListener(new LoadEpisodesListener());
		inputView.addSaveEpisodesListener(new SaveEpisodesListener());
		inputView.addExitListener(new ExitListener());
		inputView.addPrintEpisodesListener(new PrintEpisodesListener());

		System.out.println("listeners registered in controller for input window");
	}
}