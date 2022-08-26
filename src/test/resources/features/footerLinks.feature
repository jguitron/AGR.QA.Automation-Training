@regression
Feature: Footer sub-category links verification
  Verify if all clickable "sub-category links" in footer functioning as expected


  Scenario Outline: Verifying "<subCategory>"
    Given User navigates to 'url'
    When User scrolls down to footer
    And  If platform is mobile user clicks on category
      | Get To Know Us   |
      | Customer Care    |
      | Get Inspired     |
      | Terms & Policies |
    Then User verifies '<subCategory>' opens '<expected>' page
    Examples:
      | subCategory                       | expected                            |
      | About Ashley Homestore            | com/about-us/                       |
      | Our History                       | com/en/company/history              |
      | About Ashley Furniture Industries | com/en/company/company-overview     |
      | Careers                           | ashleycareers.ttcportals.com/       |
      | News                              | com/news                            |
      | Social Responsibility             | com/social-responsibility/          |
      | Store Locations                   | stores.ashleyfurniture.com          |
      | Trade Program                     | com/trade/                          |
      | Help Center                       | com/ask-ashley/                     |
      | Contact Us                        | com/ask-ashley/                     |
      | Apply for Financing               | com/financing/                      |
      | Prequalify for Financing          | com/financing/                      |
      | Lease to Own Option               | com/financing/acima/                |
      | Returns                           | returns                             |
      | Accessibility                     | accessibility.com/ashley-homestore/ |
      | Consumer Notifications            | com/consumer-notifications          |
      | FAQ                               | faqs                                |
      | Price Match                       | com/price-match/                    |
      | Child Safety                      | com/anchorit/                       |
      | Warranty Information              | com/warranty/                       |
      | Product Care & Cleaning           | com/care-and-cleaning/              |
      | Furniture Protection Plan         | com/furniture-protection/           |
      | Blog                              | blog.ashleyfurniture.com/           |
      | Home Ideas                        | com/c/shop-by/                      |
      | Digital Catalog                   | com/digital-catalog/                |
      | 3D Room Design                    | roombuilder                         |
      | Hope to Dream                     | ahopetodream.com/                   |
      | Refer a Friend                    | com/referafriend/                   |
      | Offers & Details*                 | com/coupons-deals-and-offers/       |
      | Terms & Conditions                | com/terms-and-conditions/           |
      | Terms of Use                      | com/terms-of-use/                   |
      | Privacy Policy                    | com/privacy-policy/                 |
      | Interest-Based Ads                | com/interest-based-ads/             |
      | Do not sell my Personal Info      | preferences.ashleyfurniture.com/    |