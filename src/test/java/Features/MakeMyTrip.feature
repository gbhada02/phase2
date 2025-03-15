Feature: Makemytrip Round trip

  @Regression
  Scenario Outline: User is able to check the available flights with given city and dates
    Given User is able to login using valid credentials '<testcasedesription>'
    When User select from  '<fromcity>' to '<toCity>' with round trip and Deprature date '<depraturedate>' , return date '<return_date>' and number of travellers <traveller>
    Then verify user is able to see the available flights.

    Examples: 
      | fromCity | toCity   | depraturedate | return_date | traveller | testcasedesription                                 |
      | pune     | Srinagar | 25/02/2025    | 25/02/2025  |         1 | valid testcase with same deprature and retuen date |
#| pune | Srinagar | 25/02/2025 | 27/02/2025 |1  |valid testcase with different deprature and retuen date in a same moth|
#| pune | Srinagar | 25/02/2025 | 25/03/2025 |1  |valid testcase with different deprature and retuen date in a different month but same year |
