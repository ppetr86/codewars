package com.example.codewars3.entwicklerheld.vendor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    static class FrequencyVendorBean {
        //vendor id, frequency
        private Map<String, Integer> vendorIdFrequencyMap = new HashMap<>();
    }

    //article id, vendorBean
    private static HashMap<String, FrequencyVendorBean> ARTICLE_VENDOR_ID_FREQUENCY = new HashMap<>();
    private static HashMap<String, Integer> ARTICLEID_VENDORCOUNT = new HashMap<>();
    private static List<Vendor> VENDORS;

    static {
        Vendor Clothers = new Vendor("107432", "Clothers", 5.0, 5);
        Vendor Dynamic24 = new Vendor("107232", "Dynamic24", 5.0, 5);
        Vendor FashionCore = new Vendor("107573", "FashionCore", 5.0, 5);
        Vendor OTTO = new Vendor("107001", "OTTO", 5.0, 5);
        Vendor FashionMint = new Vendor("107391", "Fashion-Mint", 5.0, 5);
        Vendor DressSellers = new Vendor("107393", "DressSellers", 5.0, 5);
        Vendor FashionAffairs = new Vendor("107392", "FashionAffairs", 5.0, 5);

        ArticleOffer a2 = new ArticleOffer("1", 22.99, 100, 1);
        ArticleOffer a1 = new ArticleOffer("1", 21.99, 100, 1);
        ArticleOffer a3 = new ArticleOffer("3", 21.99, 100, 1);
        ArticleOffer a4 = new ArticleOffer("2", 21.99, 100, 1);

        Clothers.addArticleOffer(a2);
        Dynamic24.addArticleOffer(a1);
        FashionCore.addArticleOffer(a1);
        OTTO.addArticleOffer(a1);
        FashionMint.addArticleOffer(a1);
        DressSellers.addArticleOffer(a1);
        FashionAffairs.addArticleOffer(a1);

        Clothers.addArticleOffer(a3);
        Dynamic24.addArticleOffer(a4);
        FashionCore.addArticleOffer(a4);
        OTTO.addArticleOffer(a3);
        FashionMint.addArticleOffer(a3);
        DressSellers.addArticleOffer(a4);
        FashionAffairs.addArticleOffer(a3);

        VENDORS = List.of(Clothers, Dynamic24, FashionCore, OTTO, FashionMint, DressSellers, FashionAffairs);
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
        updateArticleIdVendorCountMapBasedOnVendorsPerArticle(article, vendors.size());
        /*String str = vendors.stream()
                .map(v -> "vendorID: " + v.getId()
                        + " name: " + v.getName()
                        + " price: " + v.getArticleOffer(article.getId()).getPrice()
                        + " shipping: " + v.getArticleOffer(article.getId()).getShippingTime()
                        + " availability: " + v.getArticleOffer(article.getId()).getAvailability())
                .collect(Collectors.joining("\n"));
        System.out.println(str);*/

        double minPrice = Integer.MAX_VALUE;
        List<Vendor> bestPriceVendors = new ArrayList<>();

        //find vendors with lowest price
        for (Vendor currentVendor : vendors) {
            ArticleOffer currentOffer = currentVendor.getArticleOffer(article.getId());
            //eligible???
            if (currentOffer.getAvailability() > 0 && currentOffer.getPrice() > 0 && currentOffer.getShippingTime() >= 0) {
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
        }

        Vendor bestFairVendor = null;

        //article sold for the first time...
        //add article ID to map, create new bean with vendor and frequency 1
        if (!ARTICLE_VENDOR_ID_FREQUENCY.containsKey(article.getId())) {
            bestFairVendor = bestPriceVendors.get(0);
            FrequencyVendorBean bean = new FrequencyVendorBean();
            bean.vendorIdFrequencyMap.put(bestFairVendor.getId(), 1);
            ARTICLE_VENDOR_ID_FREQUENCY.put(article.getId(), bean);
        } else {
            //article was sold already

            FrequencyVendorBean bean = ARTICLE_VENDOR_ID_FREQUENCY.get(article.getId());
            Map<String, Integer> idFrequencyMap = bean.vendorIdFrequencyMap;
            Map.Entry<String, Integer> vendorIdWithMinimumFrequency = idFrequencyMap.entrySet().stream()
                    .min(Map.Entry.comparingByValue())
                    .get();

            for (Vendor bestPriceVendor : bestPriceVendors) {
                //article was sold, but the vendor is not there
                if (!idFrequencyMap.containsKey(bestPriceVendor.getId())) {
                    bestFairVendor = bestPriceVendor;
                    idFrequencyMap.put(bestPriceVendor.getId(), 1);
                    bean.vendorIdFrequencyMap = idFrequencyMap;
                    ARTICLE_VENDOR_ID_FREQUENCY.put(article.getId(), bean);
                    break;
                } else if (bestPriceVendors.size() > idFrequencyMap.size()) {
                    continue;
                } else if (vendorIdWithMinimumFrequency.getKey().equalsIgnoreCase(bestPriceVendor.getId())) {
                    bestFairVendor = bestPriceVendor;
                    idFrequencyMap.put(bestPriceVendor.getId(), vendorIdWithMinimumFrequency.getValue() + 1);
                    bean.vendorIdFrequencyMap = idFrequencyMap;
                    ARTICLE_VENDOR_ID_FREQUENCY.put(article.getId(), bean);
                    break;
                }
            }
        }
        return bestFairVendor;
    }

    private static void updateArticleIdVendorCountMapBasedOnVendorsPerArticle(Article article, int size) {
        if (!ARTICLEID_VENDORCOUNT.containsKey(article.getId()))
            ARTICLEID_VENDORCOUNT.put(article.getId(), size);
        else if (ARTICLEID_VENDORCOUNT.get(article.getId()) != size) {
            ARTICLEID_VENDORCOUNT.put(article.getId(), size);
            ARTICLE_VENDOR_ID_FREQUENCY.remove(article.getId());
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 135; i++) {
            findFairBestVendor(new Article("A1", "1"));
        }

        System.out.println();

    }

}
