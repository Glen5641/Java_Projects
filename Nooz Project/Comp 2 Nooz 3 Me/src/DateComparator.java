import java.util.Comparator;

/**
 * This class is a comparator that compares the dates of 2 news stories. if the
 * dates match, part of day is the next to be compared
 * 
 * @author cglen and Dean Hougen
 */
public class DateComparator implements Comparator<NewsStory> {

	public static final DateComparator DATE_COMPARATOR = new DateComparator();

	/**
	 * This overriden method compares the times of 2 newsStories
	 * 
	 * @return int Compared integer from the dates of 2 newsStories
	 */
	@Override
	public int compare(NewsStory newsStory1, NewsStory newsStory2) {

		TVNewsStory tvNewsStory1;
		TVNewsStory tvNewsStory2;
		OnlineNewsStory onlineNewsStory1;
		OnlineNewsStory onlineNewsStory2;

		// Compare the 2 dates
		int compare = newsStory1.getDate().compareTo(newsStory2.getDate());

		// If the dates match, compare the parts of day
		if (compare == 0) {
			if (newsStory1 instanceof TVNewsStory && newsStory2 instanceof TVNewsStory) {
				tvNewsStory1 = (TVNewsStory) newsStory1;
				tvNewsStory2 = (TVNewsStory) newsStory2;
				compare += tvNewsStory1.getPartOfDay().compareTo(tvNewsStory2.getPartOfDay());
			} else if (newsStory1 instanceof OnlineNewsStory && newsStory2 instanceof OnlineNewsStory) {
				onlineNewsStory1 = (OnlineNewsStory) newsStory1;
				onlineNewsStory2 = (OnlineNewsStory) newsStory2;
				compare += onlineNewsStory1.getPartOfDay().compareTo(onlineNewsStory2.getPartOfDay());
			} else if (newsStory1 instanceof TVNewsStory && newsStory2 instanceof OnlineNewsStory) {
				tvNewsStory1 = (TVNewsStory) newsStory1;
				onlineNewsStory2 = (OnlineNewsStory) newsStory2;
				compare += tvNewsStory1.getPartOfDay().compareTo(onlineNewsStory2.getPartOfDay());
			} else if (newsStory1 instanceof OnlineNewsStory && newsStory2 instanceof TVNewsStory) {
				onlineNewsStory1 = (OnlineNewsStory) newsStory1;
				tvNewsStory2 = (TVNewsStory) newsStory2;
				compare += onlineNewsStory1.getPartOfDay().compareTo(tvNewsStory2.getPartOfDay());
			} else if (newsStory1 instanceof NewspaperStory && newsStory2 instanceof NewspaperStory) {
			} else {
				if (newsStory1 instanceof TVNewsStory || newsStory1 instanceof OnlineNewsStory) {
					compare = 1;
				} else {
					compare = -1;
				}
			}
		}

		// Return the int from compare
		return compare;
	}
}
