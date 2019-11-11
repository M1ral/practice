package interview.phone.twentyninteen.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Competetiors {

    public static void main(String[] args) {
        String review1 = "ebay is awesome";
        String review2 = "eBay has great product";
        String review3 = "amazon is awesome";
        String review4 = "Amazon has great product";
        String review5 = "Google is awesome. I like using Google products.";
        String review6 = "Microsoft is too good";
        String review7 = "ebay is too good";

        List<String> reviews = Arrays.asList(new String[]{review1, review2, review3, review4, review5, review6, review7});

        List<String> competitors = Arrays.asList(new String[]{"Google", "Amazon", "eBay", "Microsoft"});

        System.out.println(Arrays.toString(
                topNCompetitors(4, 3, competitors, 6, reviews).toArray()));
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static ArrayList<String> topNCompetitors(int numCompetitors,
                                                    int topNCompetitors,
                                                    List<String> competitors,
                                                    int numReviews,
                                                    List<String> reviews) {
        ArrayList<String> result = new ArrayList<String>();
        if (null == competitors || competitors.isEmpty()) {
            return result;
        }
        if (null == reviews || reviews.isEmpty()) {
            return result;
        }

        List<Company> companies = new ArrayList<>(numCompetitors);

        // Initialize list of Companies
        for (String company : competitors) {
            companies.add(new Company(company.toLowerCase(), 0));
        }

        // Go through each review and find for the company's keyword
        for (String review : reviews) {
            for (Company competitor : companies) {
                if (review.toLowerCase().indexOf(competitor.name) != -1) {
                    competitor.numReviews++;
                    break;
                }
            }
        }

        // sort companies by number of reviews and alphabetical order
        Collections.sort(companies);

        // if N is greater than num of Companies, return names of
        // companies discussed in reviews
        int count = 0;
        for (Company c : companies) {
            result.add(c.name);
            count++;
            if (count == topNCompetitors) {
                break;
            }
        }

        return result;
    }
}

class Company implements Comparable<Company> {
    int numReviews;
    String name;

    public Company(String name, int numReviews) {
        this.name = name;
        this.numReviews = numReviews;
    }

    public int compareTo(Company other) {
        int cmp1 = other.numReviews - this.numReviews;
        if (cmp1 != 0) {
            return cmp1;
        }
        return this.name.compareTo(other.name);
    }
}
