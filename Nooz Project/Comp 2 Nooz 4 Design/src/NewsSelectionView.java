import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;

/**
 * This is default view for the user. It has two jlists and a menu bar full of
 * fun goodies for the user to change the newsMakerlist .
 * 
 * @author cglen
 *
 */
class NewsSelectionView {

	protected JMenuBar jmBar;

	protected JMenu jFile;
	protected JMenuItem jmiFileLoad;
	protected JMenuItem jmiFileSave;
	protected JMenuItem jmiFileImport;
	protected JMenuItem jmiFileExport;

	protected JMenu jNewsMaker;
	protected JMenuItem jmiNewsMakerAddMaker;
	protected JMenuItem jmiNewsMakerEditMaker;
	protected JMenuItem jmiNewsMakerDeleteMaker;
	protected JMenuItem jmiNewsMakerDeleteMakerList;

	protected JMenu jNewsStory;
	protected JMenuItem jmiNewsStoryAddStory;
	protected JMenuItem jmiNewsStoryEditStory;
	protected JMenuItem jmiNewsStorySortStories;
	protected JMenuItem jmiNewsStoryDeleteStory;
	protected JMenuItem jmiNewsStoryDeleteStoryList;

	protected JMenu jDisplay;
	protected JMenuItem jmiDisplayPieChart;
	protected JMenuItem jmiDisplayText;

	protected JList<String> jlNewsMakers;
	protected JList<String> jlNewsStories;
	protected JScrollPane jlScroller;

	/**
	 * CONSTRUCTOR
	 */
	public NewsSelectionView() {
	}

	/**
	 * Add listener for file load
	 * 
	 * @param loadFile
	 */
	public void addFileLoadItemListener(ActionListener loadFile) {
	}

	/**
	 * Add listener for Saving
	 * 
	 * @param saveFile
	 */
	public void addFileSaveItemListener(ActionListener saveFile) {
	}

	/**
	 * Add listener for import
	 * 
	 * @param importFile
	 */
	public void addFileImportItemListener(ActionListener importFile) {
	}

	/**
	 * Add listener for export
	 * 
	 * @param exportFile
	 */
	public void addFileExportItemListener(ActionListener exportFile) {
	}

	/**
	 * Add listener for makerEntry
	 * 
	 * @param makerEntry
	 */
	public void addNewsMakerEntryItemListener(ActionListener makerEntry) {
	}

	/**
	 * Add listener for Edit NewsMaker
	 * 
	 * @param makerEdit
	 */
	public void addNewsMakerEditItemListener(ActionListener makerEdit) {
	}

	/**
	 * Add listener for deleting a newsMaker
	 * 
	 * @param deleteMaker
	 */
	public void addNewsMakerDeleteMakerItemListener(ActionListener deleteMaker) {
	}

	/**
	 * Add listener to delete whole newsMaker List
	 * 
	 * @param deleteMakerList
	 */
	public void addNewsMakerDeleteMakerListItemListener(ActionListener deleteMakerList) {
	}

	/**
	 * Add listener for news story entry
	 * 
	 * @param storyEntry
	 */
	public void addNewsStoryEntryItemListener(ActionListener storyEntry) {
	}

	/**
	 * Add listener for newsStory edit
	 * 
	 * @param storyEdit
	 */
	public void addNewsStoryEditItemListener(ActionListener storyEdit) {
	}

	/**
	 * Add listener for sorting stories
	 * 
	 * @param storySort
	 */
	public void addNewsStorySortItemListener(ActionListener storySort) {
	}

	/**
	 * Add listener for deleting stories
	 * 
	 * @param deleteStory
	 */
	public void addNewsStoryDeleteStoryItemListener(ActionListener deleteStory) {
	}

	/**
	 * Add listener for deleting whole list of stories
	 * 
	 * @param deleteStoryList
	 */
	public void addNewsStoryDeleteStoryListItemListener(ActionListener deleteStoryList) {
	}

	/**
	 * Add listener to display window with pie chart
	 * 
	 * @param pieChart
	 */
	public void addDisplayPieChartItemListener(ActionListener pieChart) {
	}

	/**
	 * Add listener to display text format of stories
	 * 
	 * @param text
	 */
	public void addDisplayTextItemListener(ActionListener text) {
	}

}
