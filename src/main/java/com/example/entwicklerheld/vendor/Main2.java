package com.example.entwicklerheld.vendor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main2 {

    static class FrequencyVendorBean implements Comparable<FrequencyVendorBean> {
        private final String vendorId;
        private int frequency;

        public FrequencyVendorBean(String vendorId, int frequency) {
            this.vendorId = vendorId;
            this.frequency = frequency;
        }

        public FrequencyVendorBean(String id) {
            this.vendorId = id;
        }

        @Override
        public int compareTo(FrequencyVendorBean o) {
            return ID_VENDOR_COMPARATOR.compare(this, o);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            FrequencyVendorBean bean = (FrequencyVendorBean) o;
            return vendorId.equals(bean.vendorId);
        }

        public int getFrequency() {
            return frequency;
        }


        public String getVendorId() {
            return vendorId;
        }

        @Override
        public int hashCode() {
            return 31 * Integer.parseInt(vendorId);
        }


    }

    private static HashMap<String, Set<FrequencyVendorBean>> ARTICLE_VENDOR_ID_FREQUENCY = new HashMap<>();
    private static Comparator<FrequencyVendorBean> FREQUENCY_VENDOR_COMPARATOR = Comparator.comparing(FrequencyVendorBean::getFrequency);
    private static Comparator<FrequencyVendorBean> ID_VENDOR_COMPARATOR = Comparator.comparing(FrequencyVendorBean::getVendorId);
    private static List<Vendor> VENDORS;

    static {
        Vendor dynamic24 = new Vendor("1", "dynamic24", 5.0, 5);
        Vendor FashionCore = new Vendor("2", "FashionCore", 5.0, 5);
        Vendor FashionMint = new Vendor("3", "Fashion-Mint", 5.0, 5);
        Vendor FashionAffairs = new Vendor("4", "FashionAffairs", 5.0, 5);
        Vendor OTTO = new Vendor("5", "OTTO", 5.0, 5);
        Vendor DressSellers = new Vendor("6", "DressSellers", 5.0, 5);
        Vendor expensiveSeller = new Vendor("7", "expensiveSeller", 5.0, 5);

        ArticleOffer a1 = new ArticleOffer("1", 21.99, 100, 1);
        ArticleOffer a2 = new ArticleOffer("1", 22.99, 100, 1);

        dynamic24.addArticleOffer(a1);
        FashionCore.addArticleOffer(a1);
        FashionMint.addArticleOffer(a1);
        FashionAffairs.addArticleOffer(a1);
        OTTO.addArticleOffer(a1);
        DressSellers.addArticleOffer(a1);
        expensiveSeller.addArticleOffer(a2);

        FrequencyVendorBean b1 = new FrequencyVendorBean("1", 1);
        FrequencyVendorBean b2 = new FrequencyVendorBean("2", 2);
        FrequencyVendorBean b5 = new FrequencyVendorBean("5", 5);
        FrequencyVendorBean b4 = new FrequencyVendorBean("3", 3);
        FrequencyVendorBean b4_2 = new FrequencyVendorBean("3", 6);

        Set<FrequencyVendorBean> testTree = new TreeSet<>(FREQUENCY_VENDOR_COMPARATOR);
        testTree.add(b1);
        testTree.add(b2);
        testTree.add(b5);
        testTree.add(b4);
        testTree.add(b4_2);

        Set<FrequencyVendorBean> set = new HashSet<>();

        set.add(b1);
        set.add(b2);
        set.add(b5);
        set.add(b4);
        set.add(b4_2);

        boolean b = testTree.contains(new FrequencyVendorBean("1", 1));

        VENDORS = List.of(dynamic24, FashionCore, FashionMint, FashionAffairs, OTTO, DressSellers, expensiveSeller);
    }

    public Vendor findBestVendor(Article article) {

        List<Vendor> vendors = Vendor.getVendorsForArticle(article.getId());
        double minPrice = vendors.get(0).getArticleOffer(article.getId()).getPrice();
        int minShipping = vendors.get(0).getArticleOffer(article.getId()).getShippingTime();
        double maxRating = vendors.get(0).getRating();
        int maxRatingCount = vendors.get(0).getNumberOfRatings();
        int minAvailability = vendors.get(0).getArticleOffer(article.getId()).getAvailability();

        Vendor best = vendors.get(0);

        for (int i = 1; i < vendors.size(); i++) {
            Vendor currentVendor = vendors.get(i);
            ArticleOffer currentOffer = vendors.get(i).getArticleOffer(article.getId());
            //price is higher... continue
            if (currentOffer.getPrice() > minPrice)
                continue;
                // price is equal... add
            else if (minPrice == currentOffer.getPrice()) {
                // current shiping is higher than minSoFar
                if (minShipping < currentOffer.getShippingTime())
                    continue;
                else if (minShipping == currentOffer.getShippingTime()) {
                    //maxRating is higher than current... continue
                    if (maxRating > currentVendor.getRating())
                        continue;
                    else if (maxRating == currentVendor.getRating()) {
                        // maxRatingCount is higher than current .... continue
                        if (maxRatingCount > currentVendor.getNumberOfRatings()) {
                            continue;
                        } else if (maxRatingCount == currentVendor.getNumberOfRatings()) {
                            //rating counts are the same, add Bean
                            if (minAvailability == currentOffer.getAvailability()) {
                                best = currentVendor;
                            } else if (minAvailability < currentOffer.getAvailability()) {
                                //reassign
                                minAvailability = currentOffer.getAvailability();
                                best = currentVendor;
                            }

                        } else {
                            // found rating Count is higher than maxSoFar
                            maxRatingCount = currentVendor.getNumberOfRatings();
                            best = currentVendor;
                        }
                    } else {
                        // found rating is higher than minSoFar
                        maxRating = currentVendor.getRating();
                        best = currentVendor;
                    }
                    //add to considered on equal shipping
                    best = currentVendor;
                } else {
                    //current shipping is new min delete list, and add reassign min shipping
                    best = currentVendor;
                }
            } else {
                //price is lower than min... delete list and add, reassign min price minShipping
                minPrice = currentOffer.getPrice();
                minShipping = currentOffer.getShippingTime();
                maxRating = currentVendor.getRating();
                best = currentVendor;
            }
        }

        return best;
    }

    public static Vendor findFairBestVendor(Article article) {
        List<Vendor> vendors = VENDORS;

        double minPrice = vendors.get(0).getArticleOffer(article.getId()).getPrice();
        List<Vendor> bestPriceVendors = new ArrayList<>();
        bestPriceVendors.add(vendors.get(0));
        //find vendors with lowest price
        for (int i = 1; i < vendors.size(); i++) {
            Vendor currentVendor = vendors.get(i);
            ArticleOffer currentOffer = vendors.get(i).getArticleOffer(article.getId());
            //current is lower than minSoFar
            if (currentOffer.getPrice() > minPrice)
                continue;
            else if (currentOffer.getPrice() < minPrice) {
                //price is lower than min... delete list and add, reassign min price minShipping
                minPrice = currentOffer.getPrice();
                bestPriceVendors.clear();
            }
            // currentOfferPrice is same as minSoFar... add to minPriceSet
            //in case of else if and else add vendor to bestPriceVendors
            bestPriceVendors.add(currentVendor);
        }

        Vendor fairestVendor = null;

        //article sold for the first time...
        //add article ID to map, create new treeset with vendor and frequency 1
        if (!ARTICLE_VENDOR_ID_FREQUENCY.containsKey(article.getId())) {
            fairestVendor = bestPriceVendors.get(0);
            Set<FrequencyVendorBean> treeSet = new TreeSet<>(FREQUENCY_VENDOR_COMPARATOR.thenComparing(ID_VENDOR_COMPARATOR));
            treeSet.add(new FrequencyVendorBean(fairestVendor.getId(), 1));
            ARTICLE_VENDOR_ID_FREQUENCY.put(article.getId(), treeSet);
            return fairestVendor;
        } else {
            //article was sold already

            Set<FrequencyVendorBean> treeSet = ARTICLE_VENDOR_ID_FREQUENCY.get(article.getId());
            FrequencyVendorBean vendorWithLowestFrequencyInSet = ARTICLE_VENDOR_ID_FREQUENCY.get(article.getId()).iterator().next();

            for (Vendor bestPriceVendor : bestPriceVendors) {
                //article was sold, but the vendor is not there
                boolean contains = treeSet.contains(new FrequencyVendorBean(bestPriceVendor.getId(), 1));
                if (!contains) {
                    fairestVendor = bestPriceVendor;
                    FrequencyVendorBean bean = new FrequencyVendorBean(fairestVendor.getId(), 1);
                    treeSet.add(bean);
                    ARTICLE_VENDOR_ID_FREQUENCY.put(article.getId(), treeSet);
                    break;
                } else if (bestPriceVendors.size() > treeSet.size()) {
                    continue;
                } else if (vendorWithLowestFrequencyInSet.vendorId.equalsIgnoreCase(bestPriceVendor.getId())) {
                    fairestVendor = bestPriceVendor;
                    treeSet.remove(vendorWithLowestFrequencyInSet);
                    vendorWithLowestFrequencyInSet.frequency += 1;
                    treeSet.add(vendorWithLowestFrequencyInSet);
                    ARTICLE_VENDOR_ID_FREQUENCY.put(article.getId(), treeSet);
                    break;
                }
            }
        }
        return fairestVendor;
    }

    public static void main(String[] args) {
        findFairBestVendor(new Article("A1", "1"));
        findFairBestVendor(new Article("A1", "1"));
        findFairBestVendor(new Article("A1", "1"));
        findFairBestVendor(new Article("A1", "1"));
        findFairBestVendor(new Article("A1", "1"));
        findFairBestVendor(new Article("A1", "1"));
        findFairBestVendor(new Article("A1", "1"));
        findFairBestVendor(new Article("A1", "1"));
        findFairBestVendor(new Article("A1", "1"));
        findFairBestVendor(new Article("A1", "1"));
        findFairBestVendor(new Article("A1", "1"));
        findFairBestVendor(new Article("A1", "1"));

    }

}
