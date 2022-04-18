@regression
Feature: Footer links verification
  Checking if all clickable "links" functioning as expected

  Background:
    Given user navigates to "url"
    When user scrolls down to footer

  @smoke
  Scenario Outline: Verifying "Get To Know Us" sub-link "<subLinkOne>"
    And user clicks on "Get To Know Us"
    Then user verifies "<subLinkOne>" opens "<expected>" page
    Examples:
      | subLinkOne                        | expected                        |
      | About Ashley Homestore            | com/about-us/                   |
      | Our History                       | com/en/company/history          |
      | About Ashley Furniture Industries | com/en/company/company-overview |
      | Careers                           | ashleycareers.ttcportals.com/   |
      | News                              | com/news                        |
      | Social Responsibility             | com/social-responsibility/      |
      | Store Locations                   | stores.ashleyfurniture.com      |
      | Trade Program                     | com/trade/                      |

  Scenario Outline: Verifying "Customer Care" sub-link "<subLinkTwo>"
    And user clicks on "Customer Care"
    Then user verifies "<subLinkTwo>" opens "<expected>" page
    Examples:
      | subLinkTwo                | expected                            |
      | Help Center               | com/ask-ashley/                     |
      | Contact Us                | com/ask-ashley/                     |
      | Apply for Financing       | com/financing/                      |
      | Prequalify for Financing  | com/financing/                      |
      | Lease to Own Option       | com/financing/acima/                |
      | Returns                   | returns                             |
      | Accessibility             | accessibility.com/ashley-homestore/ |
      | Consumer Notifications    | com/consumer-notifications          |
      | FAQ                       | faqs                                |
      | Price Match               | com/price-match/                    |
      | Child Safety              | com/anchorit/                       |
      | Warranty Information      | com/warranty/                       |
      | Product Care & Cleaning   | com/care-and-cleaning/              |
      | Furniture Protection Plan | com/furniture-protection/           |

  Scenario Outline: Verifying "Get Inspired" sub-link "<subLinkThree>"
    And user clicks on "Get Inspired"
    Then user verifies "<subLinkThree>" opens "<expected>" page
    Examples:
      | subLinkThree    | expected                         |
      | Blog            | blog.ashleyfurniture.com/        |
      | Home Ideas      | com/c/shop-by/                   |
      | Digital Catalog | com/digital-catalog/             |
      | 3D Room Design  | roombuilder.ashleyfurniture.com/ |
      | Hope to Dream   | ahopetodream.com/                |
      | Refer a Friend  | com/referafriend/                |


  Scenario Outline: Verifying "Terms & Policies" sub-link "<subLinkFour>"
    And user clicks on "Terms & Policies"
    Then user verifies "<subLinkFour>" opens "<expected>" page
    Examples:
      | subLinkFour                  | expected                         |
      | Offers & Details*            | com/coupons-deals-and-offers/    |
      | Terms & Conditions           | com/terms-and-conditions/        |
      | Terms of Use                 | com/terms-of-use/                |
      | Privacy Policy               | com/privacy-policy/              |
      | Interest-Based Ads           | com/interest-based-ads/          |
      | Do not sell my Personal Info | preferences.ashleyfurniture.com/ |




